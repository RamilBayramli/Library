package controler;

import Entity.Author;
import Service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorService.getAll();
    }

    @GetMapping("/authors/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorService.getById(id);
    }

    @PostMapping("/authors/create")
    public Author createAuthor(@RequestBody Author author) {
        return authorService.create(author);
    }

    @PutMapping("/authors/update/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        return authorService.update(id, author);
    }

    @DeleteMapping("/authors/delete/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.delete(id);
    }

    @GetMapping("/authors/search/name")
    public List<Author> getAuthorsByName(@RequestParam String name) {
        return authorService.getByName(name);
    }
}
