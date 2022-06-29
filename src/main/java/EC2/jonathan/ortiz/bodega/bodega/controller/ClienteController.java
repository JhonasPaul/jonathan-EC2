package EC2.jonathan.ortiz.bodega.bodega.controller;


import EC2.jonathan.ortiz.bodega.bodega.dto.ClienteDTORequest;
import EC2.jonathan.ortiz.bodega.bodega.dto.ClienteDTOResponse;
import EC2.jonathan.ortiz.bodega.bodega.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private IClienteService service;

    @GetMapping("/clientes") //Http Method GET
    public List<ClienteDTOResponse> listar() {
        return service.listarClientes();
    }

    @PostMapping("/clientes") //Http Method POST
    public ResponseEntity<?> agregar(@RequestBody ClienteDTORequest clienteResquest) {
        Map<String, Object> response = new HashMap<>();
        service.guardarCliente(clienteResquest);
        response.put("cliente", clienteResquest);
        response.put("mensaje", "El cliente ".concat(clienteResquest.getNombreCliente()).concat(" ha sido creado con éxito"));
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED); //Http status code
    }

    @GetMapping("/clientes/{id}") //Http Method GET
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        ClienteDTOResponse p =service.obtenerclientePorId(id);
        if(p != null) {
            return  new ResponseEntity<ClienteDTOResponse>(service.obtenerclientePorId(id),HttpStatus.OK);
        }
        return  new ResponseEntity<ClienteDTOResponse>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/clientes/{id}") //Http Method DELETE
    public ResponseEntity<?> borrar(@PathVariable Long id) {
        ClienteDTOResponse b =service.obtenerclientePorId(id);
        Map<String, Object> response = new HashMap<>();
        if(b != null) {
            service.eliminarCliente(id);
            response.put("mensaje", "Cliente  eliminado con éxito!");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/clientes") //Http Method PUT
    public ResponseEntity<?> editar(@RequestBody ClienteDTORequest clienteRequest) {
        ClienteDTOResponse productoActual = service.obtenerclientePorId(clienteRequest.getIdCliente());
        Map<String, Object> response = new HashMap<>();
        if(productoActual != null) {
            service.actualizarCliente(clienteRequest);
            response.put("bodega: ", clienteRequest);
            response.put("mensaje", "Bodega " + clienteRequest.getNombreCliente() + " actualizado con éxito");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
