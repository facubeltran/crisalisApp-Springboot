package group.crisalis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import group.crisalis.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer>{
    Optional<Cliente> findByNombre(String nombre);
    Optional<Cliente> findById(Integer id);
    Optional<Cliente> findByEmail(String email);
    Optional<Cliente> findByCuil(Integer cuil);
    

}
