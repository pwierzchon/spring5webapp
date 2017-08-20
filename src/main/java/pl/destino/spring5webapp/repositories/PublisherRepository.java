package pl.destino.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.destino.spring5webapp.model.Publisher;

/**
 *
 * @author Destino
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long>{
    
}
