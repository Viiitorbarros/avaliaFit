package com.avaliaft.repository;

import com.avaliaft.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario , String> {


    UserDetails findByLogin(String Login);

}
