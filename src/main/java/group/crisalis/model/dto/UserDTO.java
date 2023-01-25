package group.crisalis.model.dto;



import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    @JsonProperty("username")
    private String username;

    @JsonProperty("pass")
    private String password;

    @JsonProperty("name")
    private String name;
}
