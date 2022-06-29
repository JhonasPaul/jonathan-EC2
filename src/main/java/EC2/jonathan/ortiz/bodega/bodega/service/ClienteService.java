package EC2.jonathan.ortiz.bodega.bodega.service;

import EC2.jonathan.ortiz.bodega.bodega.dto.ClienteDTORequest;
import EC2.jonathan.ortiz.bodega.bodega.dto.ClienteDTOResponse;
import EC2.jonathan.ortiz.bodega.bodega.model.Cliente;
import EC2.jonathan.ortiz.bodega.bodega.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ClienteService implements IClienteService{

    @Autowired
    private ClienteRepository repository;
    @Override

    public void guardarCliente(ClienteDTORequest clienteDTORequest) {
        Cliente c = new Cliente();
        c.setId(clienteDTORequest.getIdCliente());
        c.setNombre(clienteDTORequest.getNombreCliente());
        c.setDireccion(clienteDTORequest.getDireccionCliente());
        c.setDni(clienteDTORequest.getDniCliente());

        repository.save(c);
    }

    @Override
    public void actualizarCliente(ClienteDTORequest clienteDTORequest) {
        Cliente c = new Cliente();
        c.setId(clienteDTORequest.getIdCliente());
        c.setNombre(clienteDTORequest.getNombreCliente());
        c.setDireccion(clienteDTORequest.getDireccionCliente());
        c.setDni(clienteDTORequest.getDniCliente());
        repository.saveAndFlush(c);
    }

    @Override
    public void eliminarCliente(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ClienteDTOResponse> listarClientes() {
        List<ClienteDTOResponse> listar = new ArrayList<>();
        ClienteDTOResponse dto = null;
        List<Cliente> c = repository.findAll();
        /*recorre lo que obtenga de la base de datos y llenar el dto*/
        for (Cliente clientes : c) {
            /*el objeto de la base de datos se almacena en el dto*/
            dto = new ClienteDTOResponse();
            dto.setIdCliente(clientes.getId());
            dto.setNombreCliente(clientes.getNombre());
            dto.setDireccionCliente(clientes.getDireccion());
            dto.setDniCliente(clientes.getDni());
            /*el dto se almacena en la lista*/
            listar.add(dto);
        }
        return listar;
    }

    @Override
    public ClienteDTOResponse obtenerclientePorId(Long id) {
        List<ClienteDTOResponse> listar = new ArrayList<>();
        ClienteDTOResponse dto = null;
        List<Cliente> c = repository.findAll();
        /*recorre lo que obtenga de la base de datos y llenar el dto*/
        for (Cliente clientes : c) {
            /*el objeto de la base de datos se almacena en el dto*/
            dto = new ClienteDTOResponse();
            dto.setIdCliente(clientes.getId());
            dto.setNombreCliente(clientes.getNombre());
            dto.setDireccionCliente(clientes.getDireccion());
            dto.setDniCliente(clientes.getDni());
            /*el dto se almacena en la lista*/
        }
        return dto;
    }
}
