package group.crisalis.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import group.crisalis.exception.custom.EmptyElementException;
import group.crisalis.exception.custom.NotCreatedException;
import group.crisalis.exception.custom.NotFoundException;
import group.crisalis.model.Servicio;
import group.crisalis.model.dto.ServicioDTO;
import group.crisalis.repository.ServicioRepository;

@Service
public class ServicioService {
    private final ServicioRepository servicioRepository;

    public ServicioService(ServicioRepository servicioRepository){
        this.servicioRepository = servicioRepository;
    }

    public Servicio saveServicio(ServicioDTO servicioDTO){
        if (checkServicioDTO(servicioDTO)) {
            return servicioRepository.save(new Servicio(servicioDTO));
        }
        throw new NotCreatedException("error en crear");
    }

    public List<ServicioDTO> getAll(){
        return this.servicioRepository
                    .findAll()
                    .stream()
                    .map(Servicio::toDTO)
                    .collect(Collectors.toList());
    }

    public ServicioDTO getById(Integer id){
        return this.servicioRepository.findById(id).orElseThrow(
            () -> new NotFoundException("no se encuentra")
        ).toDTO();
    }

    public ServicioDTO getByNombre(String nombre){
        return this.servicioRepository.findByNombre(nombre).orElseThrow(
            () -> new NotFoundException("no se encuentra")
        ).toDTO();
    }

    public List<ServicioDTO> getLikeNombre(String nombre){
        return this.servicioRepository
            .findByNombreContainingIgnoreCase(nombre)
            .stream()
            .map(Servicio::toDTO)
            .collect(Collectors.toList());
    }

    public void remove(Integer id){
        this.servicioRepository.deleteById(id);
    }

    public Boolean checkServicioDTO(ServicioDTO servicioDTO){
        if(StringUtils.isEmpty(servicioDTO.getNombre())){
            throw new EmptyElementException("name is empty");
        }
        return Boolean.TRUE;
    }

}
