package habuma;

import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBookProcessor implements ResourceProcessor<Resource<Book>> {

	private EntityLinks entityLinks;

	public CustomBookProcessor(EntityLinks entityLinks) {
		this.entityLinks = entityLinks;
	}
	
	@Override
	public Resource<Book> process(Resource<Book> resource) {
		
		Book book = resource.getContent();
		
		if (book.getAuthor().getLastName().equals("Walls")) {
			resource.add(
					entityLinks.linkForSingleResource(
							Book.class, book.getIsbn())
						.slash("buy")
						.slash("this")
						.slash("book")
						.slash("now")
						.withRel("BUY_THIS_BOOK")
					);
		}
		
		
		return resource;
	}

}
