package group.crisalis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group.crisalis.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer>{
    Optional<Producto> findById(Integer id);
    Optional<Producto> findByNombre(String nombre);
    
}
