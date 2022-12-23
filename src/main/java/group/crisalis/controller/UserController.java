package group.crisalis.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import group.crisalis.model.dto.UserDTO;
import group.crisalis.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }


    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveUser(@RequestBody UserDTO userDTO){
        this.userService.saveUser(userDTO);
    }


}
