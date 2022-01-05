package br.com.jeyciane.APITests.config;

import br.com.jeyciane.APITests.domain.User;
import br.com.jeyciane.APITests.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public void startDB(){
        User u1 = new User(null,"Jey","jey@zup.com","123");
        User u2 = new User(null,"Thaisa","thata@zup.com","123");

        userRepository.saveAll(List.of(u1,u2));
    }

}
