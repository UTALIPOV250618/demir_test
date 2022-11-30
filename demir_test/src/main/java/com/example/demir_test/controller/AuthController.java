package com.example.demir_test.controller;


import com.example.demir_test.config.security.JwtTokenUtil;
import com.example.demir_test.exception.ExceptionType;
import com.example.demir_test.mapper.auth.AuthMapper;
import com.example.demir_test.model.security.User;
import com.example.demir_test.payload.auth.AuthRequest;
import com.example.demir_test.payload.auth.AuthResponse;
import com.example.demir_test.payload.client.ClientRequest;
import com.example.demir_test.payload.client.ClientResponse;
import com.example.demir_test.repo.UserRepository;
import com.example.demir_test.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/public")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class AuthController {

    private final JwtTokenUtil jwtTokenUtil;
    private final UserRepository repository;
    private final AuthMapper authMapper;
    private final ClientService userService;

    @PostMapping("/login")
    @Operation(summary = "All users can authenticate", description = "login all users")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
            User user = repository.findByUsername(authenticationToken.getName()).get();
            return ResponseEntity.ok().body(authMapper.view(jwtTokenUtil.generateToken(user), ExceptionType.SUCCESSFULLY, user));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(authMapper.view("", ExceptionType.LOGIN_FAILED, null));
        }
    }

    @Operation(summary = "Method registration client", description = "Registration client layout")
    @PostMapping("/registration")
    public ClientResponse registration(@RequestBody ClientRequest request) {
        return userService.registration(request);
    }

}
