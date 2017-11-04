package habuma;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface BookRepository extends 
					CrudRepository<Book, Long>, 
					QueryByExampleExecutor<Book> {
					
	SimplePublication findSimplePublicationById(Long id);

	Iterable<Book> findByAuthorFirstNameAndAuthorLastName(String fn, String ln);

	Iterable<Book> findByAuthorFirstNameAndAuthorLastNameAndTitleContains(String fn, String ln, String tc);

	Iterable<Book> findByAuthor(Author a);
	
	Book findByIsbn(@Param("isbn") String isbn);
	
	
}
