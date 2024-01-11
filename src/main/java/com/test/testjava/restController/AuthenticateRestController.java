package com.test.testjava.restController;

import com.test.testjava.dto.RequestTokenDTO;
import com.test.testjava.dto.ResponseTokenDTO;
import com.test.testjava.security.JwtManager;
import com.test.testjava.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthenticateRestController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtManager jwtManager;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public ResponseTokenDTO post(@RequestBody RequestTokenDTO dto){
        try{
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());
            authenticationManager.authenticate(token);
        }catch (Exception ex){
            ResponseTokenDTO response = new ResponseTokenDTO(false, "Unauthorized");
            return response;
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getUsername());
        String role = "User";
        String token = jwtManager.generateToken(dto.getSubject(), dto.getUsername(), dto.getSecretKey(), role, dto.getAudience());
        ResponseTokenDTO response = new ResponseTokenDTO(true, "Successfully Login", token);
        return response;
    }
}
