package group.crisalis.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import group.crisalis.exception.custom.EmptyElementException;
import group.crisalis.exception.custom.NotCreatedException;
import group.crisalis.exception.custom.NotFoundException;
import group.crisalis.model.Producto;
import group.crisalis.model.dto.ProductoDTO;
import group.crisalis.repository.ProductoRepository;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository){
        this.productoRepository=productoRepository;
    }

    public Producto saveProducto(ProductoDTO productoDTO){
        if(checkProductoDTO(productoDTO)){
            return this.productoRepository.save(new Producto(productoDTO));
        }
        throw new NotCreatedException("error en guardar producto");
    }

    public List<ProductoDTO> getAllProductos(){
        return this.productoRepository
                .findAll()
                .stream()
                .map(Producto::toDTO)
                .collect(Collectors.toList());
    }

    public ProductoDTO getById(Integer id){
        return productoRepository.findById(id).orElseThrow(
            () -> new NotFoundException("no se encuentra el")
        ).toDTO();
    }


    public ProductoDTO getByNombre(String nombre){
        return productoRepository.findByNombre(nombre).orElseThrow(
           () -> new NotFoundException("no se encuentra el producto")
        ).toDTO();
    }

    public List<ProductoDTO> getLikeNombre(String nombre){
        return this.productoRepository
            .findByNombreContainingIgnoreCase(nombre)
            .stream()
            .map(Producto::toDTO)
            .collect(Collectors.toList());
    }

    public void remove(Integer id){
        productoRepository.delete(productoRepository.findById(id).get());
    }

    public Boolean checkProductoDTO(ProductoDTO productoDTO){
        if(StringUtils.isEmpty(productoDTO.getNombre())){
            throw new EmptyElementException("name is empty");
        }
        return Boolean.TRUE;
    }



}
