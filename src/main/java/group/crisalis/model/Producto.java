package group.crisalis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import group.crisalis.model.dto.ProductoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@Table(name = "producto")
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "subtotal")
    private Integer subtotal;

    @Column(name = "montoTotal")
    private Integer montoTotal;

    @Column(name = "garantiaXano")
    private Integer garantiaXano;

    @Column(name = "impuesto")
    private Integer impuesto;


    public Producto(ProductoDTO productoDTO) {
        this.nombre = productoDTO.getNombre();
        this.subtotal = productoDTO.getSubtotal();
        this.montoTotal = productoDTO.getMontoTotal();
        this.garantiaXano = productoDTO.getGarantiaXano();
        this.impuesto = productoDTO.getImpuesto();
    }

    public ProductoDTO toDTO(){
        return ProductoDTO
                    .builder()
                    .nombre(this.nombre)
                    .subtotal(this.subtotal)
                    .montoTotal(this.montoTotal)
                    .garantiaXano(this.garantiaXano)
                    .impuesto(this.impuesto)
                    .build();
    }


}
