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
	
	@GetMapping
	public Iterable<Book> qbeBooks() {
		Author author = new Author(null, "Walls");
		Book book = new Book(null, null, null, author, null);
		
		Example<Book> example = 
					Example.of(book); 
						
		
		return repo.findAll(example);
	}
	
	@GetMapping("/simple")
	public Publication simple() {
		return repo.findPublicationByIsbn("9781617291203");
	}
	
	@GetMapping("/{id}")
	public Book byId(@PathVariable("id") Book book) {
		return book;
	}
	
}
