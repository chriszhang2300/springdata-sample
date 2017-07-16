package habuma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBookProcessor
	implements ResourceProcessor<Resource<Book>>{

	@Autowired
	private EntityLinks entityLinks;
	
	@Override
	public Resource<Book> process(Resource<Book> resource) {
		
		Book book = resource.getContent();
		
		if (book.getAuthor().getLastName().equals("Walls")) {
		
		resource.add(entityLinks
				.linkForSingleResource(
						Book.class,
						book.getIsbn())
				.slash("buy")
				.withRel("BUYTHISBOOK")
				);
		}
		
		return resource;
	}

	
	
}
