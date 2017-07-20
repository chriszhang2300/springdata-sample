package habuma;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="notsimple", types=Book.class)
public interface NotAsSimpleOfABook {

	String getIsbn();
	String getTitle();
	Integer getPages();
	
	@Value("#{target.author.firstName + ' ' + target.author.lastName}")
	String getAuthor();
	
	@Value("#{T(Math).random()}")
	Long getRandomNumber();
	
	default String getFoo() {
		return "Foo";
	}
	
}
