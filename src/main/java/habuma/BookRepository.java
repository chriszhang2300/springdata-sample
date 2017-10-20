package habuma;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface BookRepository 
		 extends PagingAndSortingRepository<Book, Long>,
		 		QueryByExampleExecutor<Book> {

	SimplePublication findSimpleById(Long id);
	
	Book findByIsbn(String isbn);

	@Override
	void delete(Long id);
	
}
