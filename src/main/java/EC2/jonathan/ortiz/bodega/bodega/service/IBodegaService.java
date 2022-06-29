package EC2.jonathan.ortiz.bodega.bodega.service;

import EC2.jonathan.ortiz.bodega.bodega.dto.BodegaDTORequest;
import EC2.jonathan.ortiz.bodega.bodega.dto.BodegaDTOResponse;

import java.util.List;

public interface IBodegaService {

    void guardarProducto(BodegaDTORequest bodegaDTORequest);

    void actualizarProducto(BodegaDTORequest bodegaDTORequest);

    void eliminarBodega(Long id);

    List<BodegaDTOResponse> listarBodegas();

    BodegaDTOResponse obtenerBodegasPorId(Long id);
}
