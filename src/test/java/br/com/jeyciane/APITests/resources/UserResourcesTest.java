package br.com.jeyciane.APITests.resources;

import br.com.jeyciane.APITests.domain.User;
import br.com.jeyciane.APITests.domain.dto.UserDTO;
import br.com.jeyciane.APITests.services.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.MockitoAnnotations.*;

@SpringBootTest
class UserResourcesTest {

    public static final Integer ID = 1;
    public static final Integer INDEX = 0;
    public static final String NOME = "Jey";
    public static final String EMAIL = "jey@zup.com";
    public static final String PASSWORD = "123";

    private User user;
    private UserDTO userDTO;

    @InjectMocks
    private UserResources resources;
    @Mock
    private UserServiceImpl service;
    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        openMocks(this);
        startUser();
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startUser() {
        user = new User(ID, NOME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID, NOME, EMAIL, PASSWORD);
    }

}