package br.com.jeyciane.APITests.services.impl;

import br.com.jeyciane.APITests.domain.User;
import br.com.jeyciane.APITests.repositories.UserRepository;
import br.com.jeyciane.APITests.services.UserService;
import br.com.jeyciane.APITests.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
