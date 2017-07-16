package habuma;

import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

@Component
public class BookRepoListener
	extends AbstractRepositoryEventListener<Book> {

	@Override
	protected void onBeforeDelete(Book entity) {
		if (entity.getAuthor().getLastName().equals("Walls")) {
			throw new DontDeleteCraigsBooks();
		}
	}
	
}
