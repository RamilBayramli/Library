package Author;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;
@Getter
@Setter
@RequiredArgsConstructor
public class AuthorRequest {
    @NotBlank(message = "Author style is Required")
    @Size(min = 2, max = 200)
    private String style;

    @NotBlank(message = "Author fullname is Required")
    @Size(min = 2, max = 200)
    private String fullname;

    @NotBlank(message = "Author country is Required")
    @Size(min = 2, max = 200)
    private String country;

    public AuthorRequest(String style, String fullname, String country) {
        this.style = style;
        this.fullname = fullname;
        this.country = country;
    }
}
