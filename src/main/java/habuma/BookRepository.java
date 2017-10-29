package habuma;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path="/libros", rel="tome")
public interface BookRepository 
		extends CrudRepository<Book, Long>,
				QueryByExampleExecutor<Book> {

	SimplePublication findSimpleById(Long id);
	
	Book findByIsbn(String isbn);
	
}
