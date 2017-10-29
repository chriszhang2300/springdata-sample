package habuma;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qbe")
public class QbeController {
	
	private BookRepository repo;

	public QbeController(BookRepository repo) {
		this.repo = repo;
	}

	@GetMapping
	public Iterable<Book> qbe() {
		Author author = new Author("Ken", "Kousen");
		Book book = new Book(null, null, null, author, null);
		
		Example<Book> example = 
				Example.of(book, 
						ExampleMatcher.matchingAny());
		
		return repo.findAll(example);
	}
	
}
