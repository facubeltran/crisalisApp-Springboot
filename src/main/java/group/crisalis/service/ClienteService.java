package group.crisalis.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import group.crisalis.exception.custom.EmptyElementException;
import group.crisalis.exception.custom.NotCreatedException;
import group.crisalis.exception.custom.UnauthorizedException;
import group.crisalis.model.Cliente;
import group.crisalis.model.dto.ClienteDTO;
import group.crisalis.repository.ClienteRepository;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente saveCliente(ClienteDTO clienteDTO){
        if (checkClienteDTO(clienteDTO)) {
            return this.clienteRepository.save(new Cliente(clienteDTO));  
        }
        throw new NotCreatedException("error en guardar cliente");
    }

    public List<ClienteDTO> getAllClientes() {
        return this.clienteRepository
                .findAll()
                .stream()
                .map(Cliente::toDTO)
                .collect(Collectors.toList());
    }

    public ClienteDTO getCliente(String nombre){
        return clienteRepository.findByNombre(nombre).orElseThrow(
            () -> new UnauthorizedException("no se encuentra el cliente")
        ).toDTO();
    }


    public Boolean checkClienteDTO(ClienteDTO clienteDTO) {
        if (StringUtils.isEmpty(clienteDTO.getNombre())) {
            throw new EmptyElementException("name is empty");
        }
        return Boolean.TRUE;
        
    }


}
