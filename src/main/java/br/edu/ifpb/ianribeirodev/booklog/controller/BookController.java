package br.edu.ifpb.ianribeirodev.booklog.controller;

import br.edu.ifpb.ianribeirodev.booklog.model.Book;
import br.edu.ifpb.ianribeirodev.booklog.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks() {
        return this.bookService.getBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        return this.bookService.getBookById(id);
    }

    @PostMapping("/books")
    public Book insertBook(@RequestBody Book book) {
        return this.bookService.insert(book);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book) {
        return this.bookService.update(book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        this.bookService.delete(id);
    }
}
