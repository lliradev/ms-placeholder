package com.lliramx.ms.placeholder.resource;

import com.lliramx.ms.placeholder.model.Book;
import com.lliramx.ms.placeholder.repository.BookRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.Optional;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    private BookRepository bookRepository;

    @Inject
    private Logger logger;

    @GET
    public List<Book> getAllBooks() {
        logger.info("Returns all books");
        return bookRepository.getAllBooks();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countAllBooks() {
        return bookRepository.countAllBooks();
    }

    @GET
    @Path("{id}")
    public Optional<Book> getBook(@PathParam("id") int id) {
        return bookRepository.getBook(id);
    }
}
