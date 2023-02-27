package group.crisalis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import group.crisalis.model.dto.ClienteDTO;
import group.crisalis.model.dto.ProductoDTO;
import group.crisalis.model.dto.ServicioDTO;
import group.crisalis.model.dto.UserDTO;
import group.crisalis.service.ClienteService;
import group.crisalis.service.ProductoService;
import group.crisalis.service.ServicioService;
import group.crisalis.service.UserService.UserService;
import group.crisalis.service.UserService.UserServiceImpl;

@Controller

public class ControllerWeb {
    
    private final UserServiceImpl userServiceImpl;
    private final ClienteService clienteService;
    private final ServicioService servicioService;
    private final ProductoService productoService;

    public ControllerWeb(UserServiceImpl userServiceImpl, ClienteService clienteService
        ,ServicioService servicioService, ProductoService productoService){
        this.userServiceImpl = userServiceImpl;
        this.clienteService = clienteService;
        this.servicioService = servicioService;
        this.productoService = productoService;
    }

    @GetMapping(value = "/")
    public String showHomePage(){
        return "index";
    }


/* 
    @GetMapping("/login")
	public String mostrarLog(@RequestParam(value ="username", required=false, defaultValue="") String username,
                            @RequestParam(value = "password", required=false, defaultValue="")String password, 
                            Model model){
        model.addAttribute("username",username);
        model.addAttribute("password",password);
        
		return "login";
	}
*/

    @GetMapping(value = "/login")
    public String mostrarLog(){
        return "login";
    }

    @GetMapping(value = "registro")
    public String mostrarFormRegistro(){
        return "registro";
    }
 
    @ModelAttribute("user")
    public UserDTO retornaNewUser(){
        return new UserDTO();
    }
 

	@PostMapping(value = "saveRegistro")
	public String registrarCuentaDeUsuario(UserDTO userDTO) {
		try {
            System.out.println("pasa por aca");
            userServiceImpl.save(userDTO);
        } catch (Exception e) {
            e.getMessage();
        }
        
		return "redirect:/registro?exito";
	}

    @GetMapping(value = "cliente")
    public String mostrarCliente(@RequestParam(name = "buscarNombre", required = false, defaultValue = "") String buscarNombre, Model model ){
        model.addAttribute("likeNombre", clienteService.getLikeNombre(buscarNombre));
        return "cliente";
    }
 
    @ModelAttribute("cliente")
    public ClienteDTO returnNewClient() {
        return new ClienteDTO();
    }

    @PostMapping(value = "/saveCliente")
    public String nuevoCliente(ClienteDTO clienteDTO) {
        try {
            
            clienteService.saveCliente(clienteDTO);
        } catch (Exception e) {
            e.getMessage();
        }
        return "redirect:/cliente?exito";
    }


    @GetMapping(value = "servicio")
    public String mostrarServicio(@RequestParam(name = "buscarNombre", required = false, defaultValue = "") String buscarNombre, Model model ){
        model.addAttribute("likeNombre", servicioService.getLikeNombre(buscarNombre));
        return "servicio";
    }

    @ModelAttribute("servicio")
    public ServicioDTO returnNewService() {
        return new ServicioDTO();
    }

    @PostMapping(value = "/saveServicio")
    public String nuevoServicio(ServicioDTO servicioDTO) {
        try {
            
             servicioService.saveServicio(servicioDTO);
        } catch (Exception e) {
            e.getMessage();
        }
        return "redirect:/servicio?exito";
    }

    @GetMapping(value = "producto")
    public String mostrarProducto(@RequestParam(name = "buscarNombre", required = false, defaultValue = "") String buscarNombre, Model model ){
        model.addAttribute("likeNombre", productoService.getLikeNombre(buscarNombre));
        return "producto";
    }

    @ModelAttribute("producto")
    public ProductoDTO returnNewProducto() {
        return new ProductoDTO();
    }

    @PostMapping(value = "/saveProducto")
    public String nuevoServicio(ProductoDTO productoDTO) {
        try {
            
             productoService.saveProducto(productoDTO);
        } catch (Exception e) {
            e.getMessage();
        }
        return "redirect:/producto?exito";
    }

}


