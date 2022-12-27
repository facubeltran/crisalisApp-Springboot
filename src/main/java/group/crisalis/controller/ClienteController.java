package group.crisalis.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.MediaType;

import group.crisalis.model.Cliente;
import group.crisalis.model.dto.ClienteDTO;
import group.crisalis.service.ClienteService;

@RestController
@RequestMapping("cliente")
public class ClienteController {
    
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE )
    public Cliente saveCliente(@RequestBody ClienteDTO clienteDTO){
        return this.clienteService.saveCliente(clienteDTO);
    }

    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClienteDTO> getAllClientes() {
        return this.clienteService.getAllClientes();
    }

    @GetMapping(value = "nombre", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClienteDTO getByNombre(@RequestParam String nombre){
        return this.clienteService.getByNombre(nombre);
    }
    
    @GetMapping(value = "id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClienteDTO getById(@RequestParam Integer id){
        return this.clienteService.getById(id);
    }

    @GetMapping(value = "email", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClienteDTO getByEmail(@RequestParam String email){
        return this.clienteService.getByEmail(email);
    }


    @GetMapping(value = "cuil", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClienteDTO getByCuil(@RequestParam Integer cuil){
        return this.clienteService.getByCuil(cuil);
    }

    @DeleteMapping(value = "borrar", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteById(@RequestParam Integer id) {
        this.clienteService.remove(id);
    }

}
