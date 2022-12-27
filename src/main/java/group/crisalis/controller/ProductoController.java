package group.crisalis.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import group.crisalis.model.Producto;
import group.crisalis.model.dto.ProductoDTO;
import group.crisalis.service.ProductoService;

@RestController
@RequestMapping("producto")
public class ProductoController {
    
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService){
        this.productoService=productoService;
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Producto saveProducto(@RequestBody ProductoDTO productoDTO){
        return this.productoService.saveProducto(productoDTO);
    }

    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductoDTO> getAllProductos(){
        return this.productoService.getAllProductos();
    }

    @GetMapping(value = "id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductoDTO getById(@RequestParam Integer id){
        return this.productoService.getById(id);
    }

    @GetMapping(value = "nombre", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductoDTO getByNombre(@RequestParam String nombre) {
        return this.productoService.getByNombre(nombre);
    }

    @DeleteMapping(value = "borrar", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteById(@RequestParam Integer id) {
        this.productoService.remove(id);
    }

}
