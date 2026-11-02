package controler;

import Entity.Book;
import Service.BookService;
import Service.AuthorService;
import book.BookRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/library")
public class BookWiewControler {
    private final BookService bookService;
    private final AuthorService authorService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to our Library system");
        return "Home";
    }

    @GetMapping("/books")
    public String books(Model model) {
        model.addAttribute("books", bookService.getAll());
        return "books";
    }

    @GetMapping("/books/add")
    public String addBookPage(Model model) {

        model.addAttribute("bookRequest", new BookRequest());
        model.addAttribute("authors", authorService.getAll());
        model.addAttribute("editMode", false);

        return "book-form";
    }

    @PostMapping("/books/add")
    public String addBook(@Valid @ModelAttribute("bookRequest") BookRequest request, BindingResult result, неModel model) {

        if (result.hasErrors()) {
            model.addAttribute("authors", authorService.getAll());
            model.addAttribute("editMode", false);

            return "book-form";
        }
        bookService.create(request);
        return "redirect:/library/books";
    }

    @GetMapping("/books/{id}/edit")
    public String editBookPage(@PathVariable Long id, Model model) {
        Book book = bookService.getById(id);
        BookRequest request = new BookRequest();
        request.setTitle(book.getTitle());
        request.setGenre(book.getGenre());
        request.setPrice(book.getPrice());
        request.setAuthorId(book.getAuthor().getId());
        model.addAttribute("bookRequest", request);
        model.addAttribute("authors", authorService.getAll());
        model.addAttribute("bookId", id);
        model.addAttribute("editMode", true);
        return "book-form";
    }

    @PostMapping("/books/{id}/edit")
    public String updateBook(@PathVariable Long id, @Valid @ModelAttribute("bookRequest") BookRequest request, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("authors", authorService.getAll());
            model.addAttribute("bookId", id);
            model.addAttribute("editMode", true);

            return "book-form";
        }

        bookService.update(id, request);
        return "redirect:/library/books";
    }
}
