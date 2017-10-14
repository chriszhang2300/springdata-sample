package habuma;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface BookRepository 
			extends CrudRepository<Book, Long>,
					QueryByExampleExecutor<Book> {

	SimplePublication findSimpleBookById(@Param("id") Long id);
	
	Book findByIsbn(@Param("isbn") String isbn);
	
}
