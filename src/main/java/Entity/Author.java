package Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@RequiredArgsConstructor
@Entity(name = "Authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
    @Column(nullable = false)
    private String style;
    private String Fullname;
    @Column(nullable = false)
    private String country;

    public Author(Long id, String style, String Fullname, String country ) {
        this.id = id;
        this.style = style;
        this.Fullname = Fullname;
        this.country = country;
    }
}


