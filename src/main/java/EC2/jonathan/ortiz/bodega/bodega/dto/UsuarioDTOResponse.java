package EC2.jonathan.ortiz.bodega.bodega.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTOResponse {
    private String token;

    public UsuarioDTOResponse() {
        super();
    }

    public UsuarioDTOResponse(String token) {
        super();
        this.token = token;
    }
}
