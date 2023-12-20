package br.edu.ifpb.ianribeirodev.booklog.repositories;

import br.edu.ifpb.ianribeirodev.booklog.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    public List<Book> findByTitle(String title);
    public List<Book> findByAuthor(String author);
    public List<Book> findByPrice(Double price);

    @Query("SELECT b FROM Book b where b.price <= :x")
    public List<Book> getAffordableBooks(@Param("x") Double price);
}
