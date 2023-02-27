package group.crisalis.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import group.crisalis.model.Servicio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ProductoDTO {
    
    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("subtotal")
    private Integer subtotal;

    @JsonProperty("montoTotal")
    private Integer montoTotal;

    @JsonProperty("garantiaXano")
    private Integer garantiaXano;

    @JsonProperty("impuesto")
    private Integer impuesto;


}
