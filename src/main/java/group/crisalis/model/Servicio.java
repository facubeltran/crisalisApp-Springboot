package group.crisalis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import group.crisalis.model.dto.ServicioDTO;

import javax.persistence.GenerationType;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "servicio")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "montoMensual")
    private String montoMensual;

    @Column(name = "iva")
    private String iva;

    @Column(name = "iibb")
    private String iibb;

    @Column(name = "soporteAdicional")
    private String soporteAdicional;


    public Servicio(ServicioDTO servicioDTO){
        this.nombre = servicioDTO.getNombre();
        this.montoMensual = servicioDTO.getMontoMensual();
        this.iva= servicioDTO.getIva();
        this.iibb= servicioDTO.getIibb();
        this.soporteAdicional = servicioDTO.getSoporteAdicional();
    }

    public ServicioDTO toDTO(){
        return ServicioDTO
                    .builder()
                    .nombre(this.nombre)
                    .montoMensual(this.montoMensual)
                    .iva(this.iva)
                    .iibb(this.iibb)
                    .soporteAdicional(this.soporteAdicional)
                    .build();

    }

}
