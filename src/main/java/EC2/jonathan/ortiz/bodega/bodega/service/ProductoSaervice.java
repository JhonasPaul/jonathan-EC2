package EC2.jonathan.ortiz.bodega.bodega.service;

import EC2.jonathan.ortiz.bodega.bodega.dto.ProductoDTORequest;
import EC2.jonathan.ortiz.bodega.bodega.dto.ProductoDTOResponse;
import EC2.jonathan.ortiz.bodega.bodega.model.Producto;
import EC2.jonathan.ortiz.bodega.bodega.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoSaervice implements IProductoService{

    @Autowired
    private ProductoRepository repository;
    @Override
    public void guardarProducto(ProductoDTORequest productoDTORequest) {
        Producto p = new Producto();
        p.setId(productoDTORequest.getIdProducto());
        p.setProducto(productoDTORequest.getProductoProducto());
        p.setDescripcion(productoDTORequest.getDescripcionProducto());
        p.setPrecio(productoDTORequest.getPrecioProducto());
        p.setStock(productoDTORequest.getStockProducto());
        repository.save(p);
    }

    @Override
    public void actualizarProducto(ProductoDTORequest productoDTOResponse) {
        Producto p = new Producto();
        p.setId(productoDTOResponse.getIdProducto());
        p.setProducto(productoDTOResponse.getProductoProducto());
        p.setDescripcion(productoDTOResponse.getDescripcionProducto());
        p.setPrecio(productoDTOResponse.getPrecioProducto());
        p.setStock(productoDTOResponse.getStockProducto());

        repository.saveAndFlush(p);
    }

    @Override
    public void eliminarProducto(Long idProducto) {
        repository.deleteById(idProducto);

    }

    @Override
    public List<ProductoDTOResponse> listarProductos() {

        List<ProductoDTOResponse> listar = new ArrayList<>();
        ProductoDTOResponse dto = null;
        List<Producto> p = repository.findAll();
        /*recorre lo que obtenga de la base de datos y llenar el dto*/
        for (Producto productos : p) {
            /*el objeto de la base de datos se almacena en el dto*/
            dto = new ProductoDTOResponse();
            dto.setProductoProducto(productos.getProducto());
            dto.setIdProducto(productos.getId());
            dto.setDescripcionProducto(productos.getDescripcion());
            dto.setPrecioProducto(productos.getPrecio());
            dto.setStockProducto(productos.getStock());
            /*el dto se almacena en la lista*/
            listar.add(dto);
        }
            return listar;
    }

    @Override
    public ProductoDTOResponse obtenerProductisPorId(Long id) {
        List<ProductoDTOResponse> listar = new ArrayList<>();
        ProductoDTOResponse dto = null;
        List<Producto> p = repository.findAll();
        /*recorre lo que obtenga de la base de datos y llenar el dto*/
        for (Producto productos : p) {
            /*el objeto de la base de datos se almacena en el dto*/
            dto = new ProductoDTOResponse();
            dto.setProductoProducto(productos.getProducto());
            dto.setIdProducto(productos.getId());
            dto.setDescripcionProducto(productos.getDescripcion());
            dto.setPrecioProducto(productos.getPrecio());
            dto.setStockProducto(productos.getStock());
            /*el dto se almacena en la lista*/

        }
        return dto;
    }
}
