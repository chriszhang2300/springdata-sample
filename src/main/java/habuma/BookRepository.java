package habuma;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface BookRepository 
		extends CrudRepository<Book, Long>,
				QueryByExampleExecutor<Book> {

	SimplePublication findSPById(Long id);
	
	Book findByIsbn(String isbn);
	
	Iterable<Book> findByAuthorLastName(@Param("aln") String aln);
}
