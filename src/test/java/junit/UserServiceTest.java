package junit;

import static constants.TestConstants.AGE;
import static constants.TestConstants.ID;
import static constants.TestConstants.NAME;
import static constants.TestConstants.PRODUCT_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.javarush.dto.UserDto;
import ru.javarush.entity.UserEntity;
import ru.javarush.mapper.UserMapper;
import ru.javarush.repository.UserRepository;
import ru.javarush.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    private static UserDto userDto;
    private static UserEntity userEntity;

    @Mock
    private UserMapper userMapper;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void init() {
        userEntity = new UserEntity();
        userEntity.setId(ID);
        userEntity.setAge(AGE);
        userEntity.setName(NAME);

        userDto = new UserDto();
        userDto.setAge(AGE);
        userDto.setName(NAME);
    }

    @Test
    void getUserById_GivenId_ReturnUserDto() {
        when(userRepository.findById(ID)).thenReturn(Optional.of(userEntity));
        when(userMapper.toUserDto(userEntity)).thenReturn(userDto);

        var actual = userService.getUserById(ID);
        var expected = userDto;

        assertEquals(expected, actual);

        verify(userRepository, times(1)).findById(ID);
    }

}
