package group.crisalis.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import group.crisalis.exception.custom.EmptyElementException;
import group.crisalis.exception.custom.NotCreatedException;
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
        if(checkUserDTO(userDTO)){
            return this.userRepository.save(new User(userDTO));
        }
        throw new NotCreatedException("Error in save new user");
    }

    private Boolean checkUserDTO(UserDTO userDTO){
        if(StringUtils.isEmpty(userDTO.getName())){
            throw new EmptyElementException("name is empty");
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
