package group.crisalis.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import group.crisalis.model.Servicio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ProductoDTO {
    
    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("subtotal")
    private Integer subtotal;

    @JsonProperty("montoTotal")
    private Integer montoTotal;

    @JsonProperty("garantiaXAño")
    private Integer garantiaXAño;

    @JsonProperty("impuesto")
    private Integer impuesto;


}
