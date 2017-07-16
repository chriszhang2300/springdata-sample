package habuma;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface BookRepository 
		extends CrudRepository<Book, Long>,
				QueryByExampleExecutor<Book> {

	SimpleBook findSimpleBookById(@Param("id") Long id);
	
	List<Book> findByAuthorFirstName(@Param("a") String a);
	
	Book findByIsbn(String isbn);
}
