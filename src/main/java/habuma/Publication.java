package habuma;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="publication", types=Book.class)
public interface Publication {

	String getTitle();
	Integer getPages();
	
	@Value("#{target.author.lastName + ', ' + target.author.firstName}")
	String getAuthor();

	@Value("#{T(System).currentTimeMillis()}")
	Long getWhenFetched();
	
}
