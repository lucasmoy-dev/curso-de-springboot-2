package academy.atl.customers.controllers;

import academy.atl.customers.dto.RequestLogin;
import academy.atl.customers.entities.User;
import academy.atl.customers.services.AuthService;
import academy.atl.customers.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/auth/login")
    public String login(@RequestBody RequestLogin request) {
        String email = request.getEmail();
        String password = request.getPassword();
        User user = service.login(email, password);
        String token = JwtUtil.generateToken(user);
        return token;
    }
}
