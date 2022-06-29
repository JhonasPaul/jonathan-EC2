package EC2.jonathan.ortiz.bodega.bodega.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productos")
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id;
    private String producto;
    private String descripcion;
    private Double precio;
    private int stock;


    @OneToMany(mappedBy = "productos", cascade ={CascadeType.PERSIST, CascadeType.MERGE})
    private List<Bodega> bodegas = new ArrayList<>();

//    @JsonIgnoreProperties({"productos"})
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "productos_clientes",
            joinColumns = @JoinColumn(
                    name = "id_producto",
                    nullable = false,
                    unique = true

            ),
            inverseJoinColumns = @JoinColumn(
                    name = "id_cliente",
                    nullable = false,
                    unique = true
            )

    )
    private List<Cliente>clientes = new ArrayList<>();



    private final static long serialVersionUID = 1L;
}
