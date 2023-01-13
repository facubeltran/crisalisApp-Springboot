package group.crisalis.model.dto;

import org.springframework.security.access.method.P;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserDTO {

    @JsonProperty("username")
    private String username;

    @JsonProperty("pass")
    private String password;

    @JsonProperty("name")
    private String name;
}
