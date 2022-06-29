package EC2.jonathan.ortiz.bodega.bodega.controller;


import EC2.jonathan.ortiz.bodega.bodega.dto.ProductoDTORequest;
import EC2.jonathan.ortiz.bodega.bodega.dto.ProductoDTOResponse;
import EC2.jonathan.ortiz.bodega.bodega.service.ProductoSaervice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProductoController {
    @Autowired
    ProductoSaervice service;

    @GetMapping("/productos") //Http Method GET
    public List<ProductoDTOResponse> listar() {
        return service.listarProductos();
    }

    @PostMapping("/productos") //Http Method POST
    public ResponseEntity<?> agregar(@RequestBody ProductoDTORequest productoDTOResquest) {
        Map<String, Object> response = new HashMap<>();
        service.guardarProducto(productoDTOResquest);
        response.put("producto", productoDTOResquest);
        response.put("mensaje", "El producto ".concat(productoDTOResquest.getProductoProducto()).concat(" ha sido creado con éxito"));
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED); //Http status code
    }

    @GetMapping("/productos/{id}") //Http Method GET
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        ProductoDTOResponse p =service.obtenerProductisPorId(id);
        if(p != null) {
            return  new ResponseEntity<ProductoDTOResponse>(service.obtenerProductisPorId(id),HttpStatus.OK);
        }
        return  new ResponseEntity<ProductoDTOResponse>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/productos/{id}") //Http Method DELETE
    public ResponseEntity<?> borrar(@PathVariable Long id) {
        ProductoDTOResponse p =service.obtenerProductisPorId(id);
        Map<String, Object> response = new HashMap<>();
        if(p != null) {
            service.eliminarProducto(id);
            response.put("mensaje", "Producto '" .concat(p.getProductoProducto()).concat("' eliminado con éxito!"));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/productos") //Http Method PUT
    public ResponseEntity<?> editar(@RequestBody ProductoDTORequest productoDTOResquest) {
        ProductoDTOResponse productoActual = service.obtenerProductisPorId(productoDTOResquest.getIdProducto());
        Map<String, Object> response = new HashMap<>();
        if(productoActual != null) {
            service.actualizarProducto(productoDTOResquest);
            response.put("producto: ", productoDTOResquest);
            response.put("mensaje", "Producto " + productoDTOResquest.getProductoProducto() + " actualizado con éxito");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
