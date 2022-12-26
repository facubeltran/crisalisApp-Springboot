package group.crisalis.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import group.crisalis.exception.custom.EmptyElementException;
import group.crisalis.exception.custom.NotCreatedException;
import group.crisalis.exception.custom.UnauthorizedException;
import group.crisalis.model.User;
import group.crisalis.model.dto.UserDTO;
import group.crisalis.repository.UserRepository;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository){
        this.userRepository= userRepository;
    }
    public User saveUser(UserDTO userDTO){
        if(checkUserDTO(userDTO, Boolean.FALSE)){
            return this.userRepository.save(new User(userDTO));
        }
        throw new NotCreatedException("Error in save new user");
    }

    public UserDTO loginUserWithCredentials(String username, String password) {
        if(
            this.checkUserDTO(UserDTO
                            .builder()
                            .username(username)
                            .password(password)
                            .build()
                        ,Boolean.TRUE)
        ){
           return this.userRepository.findByUsernameAndPassword(username, password)
                .orElseThrow(
                    () -> new UnauthorizedException("invalid credentials")
                ).toDTO();
        }
        throw new UnauthorizedException("invalid credentials");
    }

    public List<UserDTO> getListAllUsersInBD(){
        return this.userRepository
                .findAll()
                .stream()
                .map(User::toDTO)
                .collect(Collectors.toList());
    }



    private Boolean checkUserDTO(UserDTO userDTO, Boolean isForLogin){
        if(!isForLogin){
            if(StringUtils.isEmpty(userDTO.getName())){
                throw new EmptyElementException("name is empty");
            }
        }
        if(StringUtils.isEmpty(userDTO.getPassword())){
            throw new EmptyElementException("pass is empty");
        }
        if(StringUtils.isEmpty(userDTO.getUsername())){
            throw new EmptyElementException("username is empty");
        }
        return Boolean.TRUE;
    }
}
