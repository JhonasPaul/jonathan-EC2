package EC2.jonathan.ortiz.bodega.bodega.service;


import EC2.jonathan.ortiz.bodega.bodega.dto.BodegaDTORequest;
import EC2.jonathan.ortiz.bodega.bodega.dto.BodegaDTOResponse;

import EC2.jonathan.ortiz.bodega.bodega.model.Bodega;
import EC2.jonathan.ortiz.bodega.bodega.repository.BodegaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BodegaService implements IBodegaService{

    @Autowired
    private BodegaRepository repository;
    @Override
    public void guardarProducto(BodegaDTORequest bodegaDTORequest) {
        Bodega b = new Bodega();
        b.setId(bodegaDTORequest.getIdBodega());
        b.setNombre(bodegaDTORequest.getNombreBodega());
        b.setNombre(bodegaDTORequest.getNombreBodega());
        b.setDireccion(bodegaDTORequest.getDireccionBodega());
        repository.save(b);
    }

    @Override
    public void actualizarProducto(BodegaDTORequest bodegaDTORequest) {
        Bodega b = new Bodega();
        b.setId(bodegaDTORequest.getIdBodega());
        b.setNombre(bodegaDTORequest.getNombreBodega());
        b.setNombre(bodegaDTORequest.getNombreBodega());
        b.setDireccion(bodegaDTORequest.getDireccionBodega());
        repository.saveAndFlush(b);
    }

    @Override
    public void eliminarBodega(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<BodegaDTOResponse> listarBodegas() {
        List<BodegaDTOResponse> listar = new ArrayList<>();
        BodegaDTOResponse dto = null;
        List<Bodega> p = repository.findAll();
        /*recorre lo que obtenga de la base de datos y llenar el dto*/
        for (Bodega bodegas : p) {
            /*el objeto de la base de datos se almacena en el dto*/
            dto = new BodegaDTOResponse();
            dto.setIdBodega(bodegas.getId());
            dto.setNombreBodega(bodegas.getNombre());
            dto.setDireccionBodega(bodegas.getDireccion());
            /*el dto se almacena en la lista*/
            listar.add(dto);
        }
        return listar;
    }

    @Override
    public BodegaDTOResponse obtenerBodegasPorId(Long id) {
        Bodega bodega = new Bodega();
        BodegaDTOResponse dto = new BodegaDTOResponse();
        dto.setIdBodega(bodega.getId());
        dto.setNombreBodega(bodega.getNombre());
        dto.setDireccionBodega(bodega.getDireccion());
        return dto;
    }
}
