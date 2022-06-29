package EC2.jonathan.ortiz.bodega.bodega.controller;

import EC2.jonathan.ortiz.bodega.bodega.dto.UsuarioDTORequest;
import EC2.jonathan.ortiz.bodega.bodega.dto.UsuarioDTOResponse;
import EC2.jonathan.ortiz.bodega.bodega.security.JWTUtil;
import EC2.jonathan.ortiz.bodega.bodega.security.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    /*9*/
    @Autowired
    private JWTUtil util;
    @Autowired
    private UserDetailService service;

    @RequestMapping(path = "/crearToken", method = RequestMethod.POST)
    public ResponseEntity<?> crearToken(@RequestBody UsuarioDTORequest resquest) {
        UserDetails user = service.loadUserByUsername(resquest.getUsuario());
        return  ResponseEntity.ok(new UsuarioDTOResponse(util.generateToken(user.getUsername())));
    }
}
