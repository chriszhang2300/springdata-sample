package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proj")
public class ProjController {

	private BookRepository repo;

	public ProjController(BookRepository repo) {
		this.repo = repo;
	}
	
	
	@GetMapping
	public SimplePublication someBook() {
		return repo.findSimpleById(1L);
	}
	
}
