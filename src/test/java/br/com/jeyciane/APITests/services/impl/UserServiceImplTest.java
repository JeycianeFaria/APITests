package br.com.jeyciane.APITests.services.impl;

import br.com.jeyciane.APITests.domain.User;
import br.com.jeyciane.APITests.domain.dto.UserDTO;
import br.com.jeyciane.APITests.repositories.UserRepository;
import br.com.jeyciane.APITests.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {

    public static final Integer ID = 1;
    public static final String NOME = "Jey";
    public static final String EMAIL = "jey@zup.com";
    public static final String PASSWORD = "123";
    public static final String OBJETO_NAO_ENCONTRADO = "Objeto não encontrado";

    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private ModelMapper modelMapper;

    private User user;
    private UserDTO userDTO;
    private Optional<User> optionalUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void whenFindByIdThenReturnAnUserInstance() {
        when(userRepository.findById(anyInt())).thenReturn(optionalUser);

        User response = userService.findById(ID);

        assertNotNull(response); //verificando se a resposta não é nula
        assertEquals(User.class, response.getClass()); //verificando se a classe esperada é igual a atual(resposta)
        assertEquals(ID, response.getId()); //verifica se o id é igual
        assertEquals(NOME, response.getName()); //verifica se o nome é igual
        assertEquals(EMAIL, response.getEmail()); //verifica se o email é igual
    }

    @Test
    void whenFindByIdThenReturnAnObjectNotFoundException(){
        when(userRepository.findById(anyInt())).thenThrow(new ObjectNotFoundException(OBJETO_NAO_ENCONTRADO));

        try{
            userService.findById(ID);
        }catch (Exception e){
            assertEquals(ObjectNotFoundException.class, e.getClass()); //verificando se está estourando a exceção certa
            assertEquals(OBJETO_NAO_ENCONTRADO, e.getMessage()); //verificando se a mensagem estourada é a mesma que passamos
        }

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

    @Test
    void findByEmail() {
    }

    private void startUser() {
        user = new User(ID, NOME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID, NOME, EMAIL, PASSWORD);
        optionalUser = Optional.of(new User(ID, NOME, EMAIL, PASSWORD));
    }
}