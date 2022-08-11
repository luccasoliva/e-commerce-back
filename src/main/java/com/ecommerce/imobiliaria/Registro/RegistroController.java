package com.ecommerce.imobiliaria.Registro;


import com.ecommerce.imobiliaria.Services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/imobil")
@AllArgsConstructor
public class RegistroController {
    private RegistroService registroService;

    private AuthenticationManager authenticationManager;
    private RoleService roleService;

    @PostMapping("/registro/consumidor")
    public String registro(@RequestBody RegistroRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(registroService.registroConsumidor(request)).getBody();
    }

    @GetMapping("/confirmar")
    public String confirmToken(@RequestParam("token") String token){
        return registroService.confirmToken(token);
    }

    @PostMapping("/registro/vendedor")
    public String registroVendedor(@RequestBody RegistroRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(registroService.registroVendedor(request)).getBody();
    }
}
