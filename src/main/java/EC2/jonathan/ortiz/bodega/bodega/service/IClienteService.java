package EC2.jonathan.ortiz.bodega.bodega.service;

import EC2.jonathan.ortiz.bodega.bodega.dto.ClienteDTORequest;
import EC2.jonathan.ortiz.bodega.bodega.dto.ClienteDTOResponse;

import java.util.List;

public interface IClienteService {

    void guardarCliente(ClienteDTORequest clienteDTORequest);

    void actualizarCliente(ClienteDTORequest clienteDTORequest);

    void eliminarCliente(Long id);

    List<ClienteDTOResponse> listarClientes();

    ClienteDTOResponse obtenerclientePorId(Long id);
}
