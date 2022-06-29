package EC2.jonathan.ortiz.bodega.bodega.model;



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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccion;
    private int dni;

    @ManyToMany(mappedBy = "clientes", cascade ={CascadeType.PERSIST, CascadeType.MERGE})
    private List<Producto>productos = new ArrayList<>();



    private static final long serialVersionUID = 1L;
}
