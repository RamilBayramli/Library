package book;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BookResponse {
    private String title;
    private String authoNamer;
    private Long id;
    private String genre;
    private String price;

    public BookResponse(String title, String authoNamer, Long id, String genre, String price) {
        this.title = title;
        this.authoNamer = authoNamer;
        this.id = id;
        this.genre = genre;
        this.price = price;
    }

}
