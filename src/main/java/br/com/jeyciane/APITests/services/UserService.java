package br.com.jeyciane.APITests.services;

import br.com.jeyciane.APITests.domain.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);

    List<User> findAll();
}
