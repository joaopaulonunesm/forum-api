package com.forum.services;

import com.forum.controllers.models.RegisterRequest;
import com.forum.repositories.UserRepository;
import com.forum.repositories.entities.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserDetails buscarPorLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public void criar(RegisterRequest data) {
        if (buscarPorLogin(data.login()) != null) {
            throw new ServiceException(CodigoErro.ERRO_USUARIO_EXISTENTE);
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User user = new User(data.login(), encryptedPassword);
        userRepository.save(user);
    }
}
