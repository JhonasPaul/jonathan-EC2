package EC2.jonathan.ortiz.bodega.bodega.repository;

import EC2.jonathan.ortiz.bodega.bodega.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
