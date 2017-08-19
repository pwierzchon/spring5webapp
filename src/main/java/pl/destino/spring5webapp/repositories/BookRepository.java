package pl.destino.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.destino.spring5webapp.model.Book;

/**
 *
 * @author Destino
 */
public interface BookRepository extends CrudRepository<Book, Long> {

}
