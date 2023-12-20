package br.edu.ifpb.ianribeirodev.booklog.service;

import br.edu.ifpb.ianribeirodev.booklog.model.Book;
import br.edu.ifpb.ianribeirodev.booklog.repositories.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks() {
        return this.bookRepository.findAll();
    }

    public Book getBookById(Long idBook) {
        return this.bookRepository.findById(idBook).orElse(null);
    }

    @Transactional
    public Book insert(Book book) {
        if(book.getPrice().isNaN()) {
            throw new RuntimeException("Insira o preço corretamente, utilizando . para separar os valores inteiros dos decimais");
        }

        return this.bookRepository.save(book);
    }

    @Transactional
    public Book update(Book book) {
        if(book.getPrice().isNaN()) {
            throw new RuntimeException("Insira o preço corretamente, utilizando . para separar os valores inteiros dos decimais");
        }

        return this.bookRepository.save(book);
    }

    public void delete(Long id) {
        this.bookRepository.deleteById(id);
    }
}