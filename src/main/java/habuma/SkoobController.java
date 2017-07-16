package habuma;

import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skoob")
public class SkoobController {

	private BookRepository repo;

	public SkoobController(BookRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping("/{id}")
	public SimpleBook byId(@PathVariable("id") Long id) {
		return repo.findSimpleBookById(id);
	}
	
	@GetMapping("/byAuthor")
	public Iterable<Book> findByAuthor() {
		Author author = new Author("Craig", "Walls");
		Book book = new Book(null, null, null, author, null);
		
		Example<Book> example = Example.of(book);
				
		
		return repo.findAll(example);
	}
	
}
