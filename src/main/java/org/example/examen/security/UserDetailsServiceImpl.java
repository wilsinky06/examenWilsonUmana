package org.example.examen.security;

import org.example.examen.data.UsuarioRepository;
import org.example.examen.logic.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Usuario usr = usuarioRepository.findById(username).get();
            return new UserDetailsImp(usr);
        } catch (Exception e) {
            throw new UsernameNotFoundException("Usuario " + username + " no encontrado");
        }
    }
}