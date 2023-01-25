package group.crisalis.service.UserService;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import group.crisalis.model.Rol;
import group.crisalis.model.User;
import group.crisalis.model.dto.UserDTO;
import group.crisalis.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("usuario o password erroneos");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapAutRoles(user.getRoles()));
    }

    @Override
    public User save(UserDTO userDTO) {
        User user = new User(userDTO.getUsername(),passwordEncoder.encode(userDTO.getPassword()),userDTO.getName(), Arrays.asList(new Rol("ROLE_USER")));
        return userRepository.save(user);
    }

    private Collection<? extends GrantedAuthority> mapAutRoles(Collection<Rol> roles){
       return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }
    
}
