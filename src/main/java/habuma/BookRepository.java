package habuma;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface BookRepository 
		 extends CrudRepository<Book, Long>,
		 		QueryByExampleExecutor<Book> {

	boolean existsByIsbn(String isbn);
	
	<T> T findSimpleBookById(Long id, Class<T> projectionType);
	
	
	Book findByIsbn(String isbn);
}
