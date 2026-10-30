package controler;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookWiewControler {
    @GetMapping("/home")
    public String home(Model model){
        model.addAttribuate("mesage". "Welcome to our Library system");
        return "home";

    }
}
