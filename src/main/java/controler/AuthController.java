package controler;

import Service.AuthorService;
import auth.AuthResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthorService authorService;

    @PostMapping("/reqister")
    public AuthResponse reqister(@Valid @RequestBody ReqisterRequest request) {
        AuthResponse response = authorService.reqister(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
