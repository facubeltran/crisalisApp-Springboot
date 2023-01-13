package group.crisalis.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import group.crisalis.model.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "usuario")
@Data
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

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(
			name = "usuarios_roles",
			joinColumns = @JoinColumn(name = "usuario_id",referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "rol_id",referencedColumnName = "id")
			)
	private Collection<Rol> roles;


    public User(String username, String password, String name, Collection<Rol> roles) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.roles = roles;
    }


    public User(UserDTO userDTO){
        this.username=userDTO.getUsername();
        this.password=userDTO.getPassword();
        this.name=userDTO.getName();
    }

    public UserDTO toDTO(){
        return UserDTO
            .builder()
            .username(this.username)
            .password(this.password)
            .name(this.name)
            .build();
    }
}
