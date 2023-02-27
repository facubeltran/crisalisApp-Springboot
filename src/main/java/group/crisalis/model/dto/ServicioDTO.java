package group.crisalis.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ServicioDTO {
    
    @JsonProperty(value = "nombre")
    private String nombre;

    @JsonProperty(value = "montoMensual")
    private String montoMensual;

    @JsonProperty(value = "iva")
    private String iva;

    @JsonProperty(value = "iibb")
    private String iibb;

    @JsonProperty(value = "soporteAdicional")
    private String soporteAdicional;
}
