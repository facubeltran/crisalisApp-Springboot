package group.crisalis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group.crisalis.model.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio,Integer>{
    Optional<Servicio> findByNombre(String nombre);
    Optional<Servicio> findById(Integer id);
    public abstract List<Servicio>findByNombreContainingIgnoreCase(String nombre);
    
}
