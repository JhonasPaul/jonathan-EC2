package EC2.jonathan.ortiz.bodega.bodega.repository;

import EC2.jonathan.ortiz.bodega.bodega.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
