package EC2.jonathan.ortiz.bodega.bodega.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTORequest {
    private Long idUsuario;
    private String usuario;
    private String password;
    private String rol;
}
