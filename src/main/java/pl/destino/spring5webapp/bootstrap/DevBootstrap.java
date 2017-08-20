package pl.destino.spring5webapp.bootstrap;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.destino.spring5webapp.model.Author;
import pl.destino.spring5webapp.model.Book;
import pl.destino.spring5webapp.model.Publisher;
import pl.destino.spring5webapp.repositories.AuthorRepository;
import pl.destino.spring5webapp.repositories.BookRepository;
import pl.destino.spring5webapp.repositories.PublisherRepository;

/**
 *
 * @author Destino
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;

    private BookRepository bookRepository;

    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData() {

        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher harperCollins = new Publisher("HarperCollins");
        Book ddd = new Book("Domain Driven Design", "1234", harperCollins);
        ddd.getAuthors().add(eric);

        publisherRepository.save(harperCollins);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher worx = new Publisher("Worx");
        Book noEJB = new Book("J2EE Development Without EJB", "1234", worx);
        noEJB.getAuthors().add(rod);

        publisherRepository.save(worx);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        initData();
    }

}
