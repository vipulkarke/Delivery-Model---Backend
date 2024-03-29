package com.bezkoder.spring.login.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.login.models.BellyDarbar;
import com.bezkoder.spring.login.models.ERole;
import com.bezkoder.spring.login.models.Icecream;
import com.bezkoder.spring.login.models.Mcdonald_menu;
import com.bezkoder.spring.login.models.Menu;
import com.bezkoder.spring.login.models.OvenStory;
import com.bezkoder.spring.login.models.Restaurant;
import com.bezkoder.spring.login.models.Role;
import com.bezkoder.spring.login.models.User;
import com.bezkoder.spring.login.payload.request.LoginRequest;
import com.bezkoder.spring.login.payload.request.SignupRequest;
import com.bezkoder.spring.login.payload.response.UserInfoResponse;
import com.bezkoder.spring.login.payload.response.MessageResponse;
import com.bezkoder.spring.login.repository.McDonaldRepo;
import com.bezkoder.spring.login.repository.OvenRepo;
import com.bezkoder.spring.login.repository.RestaurantRepository;
import com.bezkoder.spring.login.repository.RoleRepository;
import com.bezkoder.spring.login.repository.UserRepository;
import com.bezkoder.spring.login.security.jwt.JwtUtils;
import com.bezkoder.spring.login.security.services.BellyService;
import com.bezkoder.spring.login.security.services.IceCreamService;
import com.bezkoder.spring.login.security.services.McDonaldsService;
import com.bezkoder.spring.login.security.services.MenuService;
import com.bezkoder.spring.login.security.services.OvenService;
import com.bezkoder.spring.login.security.services.RestaurantService;
import com.bezkoder.spring.login.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

//  @Autowired
//	private McDonaldRepo mcRepo;
//  
//  @Autowired
//  private OvenRepo ovenRepo;
//  
	@Autowired
	private IceCreamService IceService;

	@Autowired
	private OvenService ovenService;

	@Autowired
	private McDonaldsService McService;

	@Autowired
	private BellyService bellyService;

	@Autowired
	MenuService menuService;

	@Autowired
	RestaurantService restService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString()).body(
				new UserInfoResponse(userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "mod":
					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

	@PostMapping("/signout")
	public ResponseEntity<?> logoutUser() {
		ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
		return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
				.body(new MessageResponse("You've been signed out!"));
	}

	@GetMapping("/restaurant")
	public ResponseEntity<List<Restaurant>> getAllUsers() {
		List<Restaurant> getall = restService.getAllUsers();
		return new ResponseEntity<List<Restaurant>>(getall, HttpStatus.OK);
	}

	@GetMapping("/restaurant/{id}")
	public ResponseEntity<Restaurant> get_A_User(@PathVariable("id") Integer id) {
		Restaurant user = restService.get_A_User(id);
		return new ResponseEntity<Restaurant>(user, HttpStatus.OK);
	}

	@GetMapping("/restaurants/{id}")
	public ResponseEntity<Menu> getRestMenu(@PathVariable("id") Integer fk_id) {
//		Restaurant user = restService.get_A_User(id) ;
		Menu user1 = menuService.getMenu(fk_id);
		return new ResponseEntity<Menu>(user1, HttpStatus.OK);
	}

	@DeleteMapping("/restaurants/{id}")
	public ResponseEntity<?> deleteRestaurant(@PathVariable("id") Integer id) {
		restService.deleteRestaurant(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/menu")
	public ResponseEntity<List<Menu>> getAllMenu() {
		List<Menu> getall = menuService.All();
		return new ResponseEntity<List<Menu>>(getall, HttpStatus.OK);
	}


	@GetMapping("/mcdonald_menu")
	public ResponseEntity<List<Mcdonald_menu>> getAll() {
		List<Mcdonald_menu> getall = McService.getAll();
		return new ResponseEntity<List<Mcdonald_menu>>(getall, HttpStatus.OK);
	}

	@GetMapping("/ovenstory")
	public ResponseEntity<List<OvenStory>> getAllOven() {
		List<OvenStory> getall = ovenService.getAllOven();
		return new ResponseEntity<List<OvenStory>>(getall, HttpStatus.OK);
	}

	@GetMapping("/icecream")
	public ResponseEntity<List<Icecream>> getAllIceCream() {
		List<Icecream> getall = IceService.getAllIce();
		return new ResponseEntity<List<Icecream>>(getall, HttpStatus.OK);
	}

	@GetMapping("/bellydarbar")
	public ResponseEntity<List<BellyDarbar>> getAllffood() {
		List<BellyDarbar> getall = bellyService.getAllmenu();
		return new ResponseEntity<List<BellyDarbar>>(getall, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant) {
		Restaurant newRestaurant = restService.addRestaurant(restaurant);
		return new ResponseEntity<>(newRestaurant, HttpStatus.CREATED);
	}
	
	@PostMapping("/addmenu")
	public ResponseEntity<Menu> addMenu(@RequestBody Menu menu) {
		Menu newRestaurant = menuService.AddMenu(menu);
		return new ResponseEntity<>(newRestaurant, HttpStatus.CREATED);
	}

}
