package group.crisalis.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    
    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;
    
    @JsonProperty("name")
    private String name;
}
