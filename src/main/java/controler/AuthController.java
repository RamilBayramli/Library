package controler;

import Service.AuthorService;
import auth.AuthResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthorService authorService;
    private final AuthenticationManager authenticationManager;
    private final SecurityContextRepository securityContextRepository;

    @GetMapping("/csrf")
    public Map<String, String> csrf(CsrfToken token) {

        return map.of(
                "headerName", token.getHeaderName()
                "token", token.getToken()
        );
    }

    @PostMapping("/reqister")
    public AuthResponse reqister(@Valid @RequestBody ReqisterRequest request) {
        AuthResponse response = authorService.reqister(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

     @PostMapping("/login")
    public AuthResponse login(){

     }
}
