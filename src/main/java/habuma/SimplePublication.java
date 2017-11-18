package habuma;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="simple", types=Book.class)
public interface SimplePublication {

	String getIsbn();
	String getTitle();
	
	@Value("#{target.author.firstName + ' ' + target.author.lastName}")
	String getAuthor();
	
	@Value("#{target.publisher.name}")
	String getPublisher();
	
	@Value("#{T(System).currentTimeMillis()}")
	long getFetchedAt();
	
}
