package EC2.jonathan.ortiz.bodega.bodega.controller;

import EC2.jonathan.ortiz.bodega.bodega.dto.BodegaDTORequest;
import EC2.jonathan.ortiz.bodega.bodega.dto.BodegaDTOResponse;
import EC2.jonathan.ortiz.bodega.bodega.service.BodegaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BodegaController {
    @Autowired
    BodegaService service;

    @GetMapping("/bodegas") //Http Method GET
    public List<BodegaDTOResponse> listar() {
        return service.listarBodegas();
    }

    @PostMapping("/bodegas") //Http Method POST
    public ResponseEntity<?> agregar(@RequestBody BodegaDTORequest bodegaDTORequest) {
        Map<String, Object> response = new HashMap<>();
        service.guardarProducto(bodegaDTORequest);
        response.put("producto", bodegaDTORequest);
        response.put("mensaje", "El producto ".concat(bodegaDTORequest.getNombreBodega()).concat(" ha sido creado con éxito"));
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED); //Http status code
    }

    @GetMapping("/bodegas/{id}") //Http Method GET
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        BodegaDTOResponse p =service.obtenerBodegasPorId(id);
        if(p != null) {
            return  new ResponseEntity<BodegaDTOResponse>(service.obtenerBodegasPorId(id),HttpStatus.OK);
        }
        return  new ResponseEntity<BodegaDTOResponse>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/bodegas/{id}") //Http Method DELETE
    public ResponseEntity<?> borrar(@PathVariable Long id) {
        BodegaDTOResponse b =service.obtenerBodegasPorId(id);
        Map<String, Object> response = new HashMap<>();
        if(b != null) {
            service.eliminarBodega(id);
            response.put("mensaje", "Bodega  eliminado con éxito!");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/bodegas") //Http Method PUT
    public ResponseEntity<?> editar(@RequestBody BodegaDTORequest bodegaDTOResquest) {
        BodegaDTOResponse productoActual = service.obtenerBodegasPorId(bodegaDTOResquest.getIdBodega());
        Map<String, Object> response = new HashMap<>();
        if(productoActual != null) {
            service.actualizarProducto(bodegaDTOResquest);
            response.put("bodega: ", bodegaDTOResquest);
            response.put("mensaje", "Bodega " + bodegaDTOResquest.getNombreBodega() + " actualizado con éxito");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
