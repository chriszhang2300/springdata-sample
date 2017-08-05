package habuma;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface BookRepository 
		extends CrudRepository<Book, Long>,
				QueryByExampleExecutor<Book> {

	Book findByIsbn(String isbn);
	
	Publication findPublicationByIsbn(String isbn);
	
}
