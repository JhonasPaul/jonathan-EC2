package EC2.jonathan.ortiz.bodega.bodega.service;

import EC2.jonathan.ortiz.bodega.bodega.dto.ProductoDTORequest;
import EC2.jonathan.ortiz.bodega.bodega.dto.ProductoDTOResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductoService {

    void guardarProducto(ProductoDTORequest productoDTOResponse);

    void actualizarProducto(ProductoDTORequest productoDTOResponse);

    void eliminarProducto(Long idProducto);

    List<ProductoDTOResponse> listarProductos();

    ProductoDTOResponse obtenerProductisPorId(Long id);
}
