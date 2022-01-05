package br.com.jeyciane.APITests.services;

import br.com.jeyciane.APITests.domain.User;

public interface UserService {

    User findById(Integer id);

}
