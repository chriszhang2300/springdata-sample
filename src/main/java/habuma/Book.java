package habuma;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.context.annotation.Lazy;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private final String isbn;
	private final String title;
	
	@ManyToOne
	@Lazy
	private final Publisher publisher;

	@ManyToOne
	@Lazy
	private final Author author;
	
	private final Integer pages;
	
}
