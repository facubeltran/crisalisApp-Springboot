package group.crisalis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

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

    @Column(name = "garantiaXAño")
    private Integer garantiaXAño;

    @Column(name = "impuesto")
    private Integer impuesto;

}
