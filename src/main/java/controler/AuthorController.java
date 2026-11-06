package controler;
import Entity.Author;
import Service.AuthorService;
import Author.AuthorRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/library")
public class AuthorController {
    private final AuthorService authorService;
    @GetMapping("/authors")
    public String authors(Model model) {
        model.addAttribute("authors", authorService.getAll());
        return "authors";
    }
    @GetMapping("/authors/add")
    public String addAuthorPage(Model model) {
        model.addAttribute("authorRequest", new AuthorRequest());
        model.addAttribute("editMode", false);
        return "author-form";
    }
    @PostMapping("/authors/add")
    public String addAuthor(@Valid @ModelAttribute("authorRequest") AuthorRequest request, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("editMode", false);
            return "author-form";
        }
        authorService.create(request);
        return "redirect:/library/authors";
    }
    @GetMapping("/authors/{id}/edit")
    public String editAuthorPage(@PathVariable Long id, Model model) {
        Author author = authorService.getById(id);
        AuthorRequest request = new AuthorRequest();
        request.setStyle(author.getStyle());
        request.setFullname(author.getFullname());
        request.setCountry(author.getCountry());
        model.addAttribute("authorRequest", request);
        model.addAttribute("authorId", id);
        model.addAttribute("editMode", true);
        return "author-form";
    }
    @PostMapping("/authors/{id}/edit")
    public String updateAuthor(@PathVariable Long id, @Valid @ModelAttribute("authorRequest") AuthorRequest request, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("authorId", id);
            model.addAttribute("editMode", true);
            return "author-form";
        }
        authorService.update(id, request);
        return "redirect:/library/authors";
    }

    @PostMapping("/authors/{id}/delete")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.delete(id);
        return "redirect:/library/authors";
    }
}
