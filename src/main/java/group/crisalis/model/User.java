package group.crisalis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import group.crisalis.model.dto.UserDTO;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name ="usuario")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "pass")
    private String password;

    @Column(name = "name")
    private String name;
    
public User(UserDTO userDTO){
    this.name = userDTO.getName();
    this.username = userDTO.getUsername();
    this.password = userDTO.getPassword();
}

public UserDTO toDTO(){
    return UserDTO
                .builder()
                .name(this.name)
                .username(this.username)
                .password(this.password)
                .build();
}

}
