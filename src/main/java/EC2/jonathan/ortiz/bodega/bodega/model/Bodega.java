package EC2.jonathan.ortiz.bodega.bodega.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bodegas")
public class Bodega implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bodega")
    private Long id;
    private String nombre;
    private String direccion;


    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto productos;


    private static final long serialVersionUID = 1L;
}
