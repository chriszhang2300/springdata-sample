package habuma;

import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;

@Component
public class RepoEventListener
	extends AbstractRepositoryEventListener<Object> {

	@Override
	protected void onBeforeDelete(Object entity) {
//		if (entity.getAuthor().getLastName().equals("Walls")) {
		  throw new DontDeleteCraigsBooksException();
//		}
	}
	
}
