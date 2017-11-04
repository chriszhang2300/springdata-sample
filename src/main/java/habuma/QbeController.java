package habuma;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
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
	
	public String lowerIt(Object t) {
		System.out.println(" -->  " + t);
		return ((String)t).toLowerCase();
	}
	
	@GetMapping
	public Iterable<Book> qbe() {
		Author author = new Author("KEN", "walls");
		Book book = new Book(null, "spring", null, author, null);
		
		Example<Book> example = Example.of(book,
				ExampleMatcher.matchingAny()
					.withIgnoreCase("author.firstName")
					.withStringMatcher(StringMatcher.CONTAINING)
					.withTransformer("title", this::lowerIt));
		
		return repo.findAll(example);
		
//		return repo.findByAuthorFirstNameAndAuthorLastName("Craig", "Walls");
	}
	
}
