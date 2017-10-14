package habuma;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skoob")
public class SkoobController {

	private BookRepository repo;

	public SkoobController(BookRepository repo) {
		this.repo = repo;
	}
	
	
	@GetMapping
	public SimplePublication oneBook() {
		return repo.findSimpleBookById(1L);
	}
	
	
	@GetMapping("/qbe")
	public Iterable<Book> qbe() {
		Author author = new Author("KEN", "Walls");
		Book book = new Book(null, null, null, author, null);
		
		Example<Book> example = Example.of(book,
					ExampleMatcher.matchingAny()
						.withIgnoreCase("author.firstName", "author.lastName"));
		
		return repo.findAll(example);
	}
	
}
