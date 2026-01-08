package com.avaliaft.controller;

import com.avaliaft.dtos.AuthenticationDTO;
import com.avaliaft.dtos.DadosTokenJWT;
import com.avaliaft.dtos.RegisterDTO;
import com.avaliaft.models.Usuario;
import com.avaliaft.repository.UsuarioRepository;
import com.avaliaft.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO login){
        var usernamePassord =  new UsernamePasswordAuthenticationToken(login.login(), login.password());
        var auth = authenticationManager.authenticate(usernamePassord);
        var usuario = (Usuario) auth.getPrincipal();
        var token = tokenService.gerarToken(usuario);


        return  ResponseEntity.ok(new DadosTokenJWT(token));
    }

    @PostMapping("/register")
    public ResponseEntity register (@RequestBody RegisterDTO data){

        if (usuarioRepository.findByLogin(data.login()) != null) {

            return ResponseEntity.badRequest().build();

        }else {
            String encryptedPassoword = new BCryptPasswordEncoder().encode(data.password());
            Usuario novousuario = new Usuario(data.login(), encryptedPassoword);
            usuarioRepository.save(novousuario);
            return ResponseEntity.ok().build();
        }

    }






}
