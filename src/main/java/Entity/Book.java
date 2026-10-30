package Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@RequiredArgsConstructor
@Entity(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String price;
    @Column(nullable = false)
    private String genre;
    @ManyToOne
   @JoinColumn(name = "author_id")
    private Author author;

    public Book(String title, String price, String genre, Author author) {
        this.title = title;
        this.price = price;
        this.genre = genre;
    }
}
