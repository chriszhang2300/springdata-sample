package habuma;

import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomBookProcessor 
	implements ResourceProcessor<Resource<Book>> {

	private final @NonNull EntityLinks entityLinks;
	
  	@Override
  	public Resource<Book> process(Resource<Book> bookResource) {
  		
  		Book book = bookResource.getContent();
  		if (book.getAuthor().getLastName().equals("Walls")) {
  			bookResource.add(
  					entityLinks.linkToSingleResource(
  							Book.class, book.getIsbn())
  					.withRel("BUYBOOK"));
  		}
  		
  		return bookResource;
  	}
	
}
