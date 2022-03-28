package su.ibn.springdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.istack.NotNull;
import su.ibn.springdemo.model.Book;
import su.ibn.springdemo.repository.BookRepository;
import su.ibn.springdemo.services.SoundAnimals;

@Controller
@RequestMapping("/")
public class HomeController {

    private final BookRepository bookRepository;
    /*
    поскольку интерфейс SoundAnimal имеет несколько реализаций, необходимо точно указать ему на нужную, например
    проаннатировав параметр метода
     public HomeController(BookRepository bookRepository, @Qualifier("catSound") SoundAnimals soundAnimals) {
   */
    private SoundAnimals soundAnimals;

    /*
    Во время создания бина Spring найдет нужный класс и скормит его конструктору
     */
    @Autowired
    public HomeController(BookRepository bookRepository,SoundAnimals soundAnimals) {
        this.bookRepository = bookRepository;
        this.soundAnimals = soundAnimals;
    }


    @GetMapping
    public String getIndex(@NotNull Model model) {
        System.out.println("From controller: " + soundAnimals.sound());
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
