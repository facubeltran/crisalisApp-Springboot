package group.crisalis.service.UserService;

import org.springframework.security.core.userdetails.UserDetailsService;

import group.crisalis.model.User;
import group.crisalis.model.dto.UserDTO;

public interface UserService extends UserDetailsService{
    public User save(UserDTO userDTO);
}
