package group.crisalis.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import group.crisalis.model.dto.ClienteDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "CUIL")
    private String cuil;



    public Cliente(ClienteDTO clienteDTO) {
        this.nombre = clienteDTO.getNombre();
        this.telefono = clienteDTO.getTelefono();
        this.email = clienteDTO.getEmail();
        this.direccion = clienteDTO.getDireccion();
        this.cuil = clienteDTO.getCuil();
    }

    public ClienteDTO toDTO(){
        return ClienteDTO
                    .builder()
                    .nombre(this.nombre)
                    .telefono(this.telefono)
                    .email(this.email)
                    .direccion(this.direccion)
                    .cuil(this.cuil)
                    .build();
    }

}
