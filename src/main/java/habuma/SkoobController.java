package habuma;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/skoob")
@RequiredArgsConstructor
public class SkoobController {

	private final BookRepository repo;

	@GetMapping("/{id}")
	public Object byId(@PathVariable("id") Long id) {
		return repo.findSimpleBookById(id, NotAsSimpleOfABook.class);
	}
	
//	@GetMapping("/{isbn}")
//	public String exists(@PathVariable("isbn") String isbn) {
//		return "DOES IT EXIST:  " + repo.existsByIsbn(isbn);
//	}
	
	@GetMapping("/byexample")
	public Iterable<Book> byExample() {
		Author author = new Author("Craig", null);
		Book book = new Book(null, null, null, author, null);
		
		Example<Book> example = 
				Example.of(book,
						ExampleMatcher
							.matching()
								.withIgnoreCase(false));
					
		
		return repo.findAll(example);
	}
	
}
