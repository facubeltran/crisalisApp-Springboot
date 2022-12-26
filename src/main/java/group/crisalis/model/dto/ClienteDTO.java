package group.crisalis.model.dto;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

import group.crisalis.model.Servicio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ClienteDTO {
    
    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("telefono")
    private Integer telefono;

    @JsonProperty("email")
    private String email;

    @JsonProperty("direccion")
    private String direccion;

    @JsonProperty("CUIL")
    private Integer cuil;


}
