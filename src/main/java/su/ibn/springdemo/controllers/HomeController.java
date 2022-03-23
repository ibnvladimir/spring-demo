package su.ibn.springdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.istack.NotNull;
import su.ibn.springdemo.model.Book;
import su.ibn.springdemo.repository.BookRepository;

@Controller
@RequestMapping("/")
public class HomeController {

    private final BookRepository bookRepository;

    /*
    Во время создания бина Spring найдет нужный класс и скормит его конструктору
     */
    @Autowired
    public HomeController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @GetMapping
    public String getIndex(@NotNull Model model) {
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("newBook", new Book());
        return "index";
    }

    @PostMapping
    public String createBook(Book book) {
        bookRepository.save(book);
        return "redirect:/";
    }

}
