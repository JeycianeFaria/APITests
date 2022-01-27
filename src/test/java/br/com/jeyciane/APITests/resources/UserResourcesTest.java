package br.com.jeyciane.APITests.resources;

import br.com.jeyciane.APITests.domain.User;
import br.com.jeyciane.APITests.domain.dto.UserDTO;
import br.com.jeyciane.APITests.services.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

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
    void whenFindByIdThenReturnSuccess() {
        when(service.findById(anyInt())).thenReturn(user);
        when(modelMapper.map(any(), any())).thenReturn(userDTO);

        ResponseEntity<UserDTO> response = resources.findById(ID);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(UserDTO.class, response.getBody().getClass());

        assertEquals(ID, response.getBody().getId());
        assertEquals(EMAIL, response.getBody().getEmail());
        assertEquals(NOME, response.getBody().getName());
        assertEquals(PASSWORD, response.getBody().getPassword());
    }

    @Test
    void whenFindAllThenReturnAListOfUserDTO() {
        when(service.findAll()).thenReturn(List.of(user));
        when(modelMapper.map(any(),any())).thenReturn(userDTO);

        ResponseEntity<List<UserDTO>> response = resources.findAll();

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode()); //aqui verifica se o status da resposta está correto
        assertEquals(ResponseEntity.class, response.getClass()); //aqui verifica se a classe da resposta é um ResponseEntity
        assertEquals(ArrayList.class, response.getBody().getClass()); //aqui verifica se a classe do corpo  da resposta é um ArrayList
        assertEquals(UserDTO.class, response.getBody().get(INDEX).getClass()); //aqui verifica se o primeiro item(index 0) é um user dto

        assertEquals(ID, response.getBody().get(INDEX).getId());
        assertEquals(EMAIL, response.getBody().get(INDEX).getEmail());
        assertEquals(NOME, response.getBody().get(INDEX).getName());
        assertEquals(PASSWORD, response.getBody().get(INDEX).getPassword());
    }

    @Test
    void whenCreateThenReturnCreated() {
        when(service.create(any())).thenReturn(user);

        ResponseEntity<UserDTO> response = resources.create(userDTO);

        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.CREATED,response.getStatusCode());
        assertNotNull(response.getHeaders().get("Location")); //verificar se o header tem a chave location


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