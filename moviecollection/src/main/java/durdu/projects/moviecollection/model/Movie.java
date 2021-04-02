package durdu.projects.moviecollection.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import durdu.projects.moviecollection.validator.Year;

@Entity
public class Movie {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	@NotBlank(message = "*Please enter the movie name!")
	private String name;
	@NotBlank(message = "*Please enter the director of the movie!")
	private String director;
	@Year
	private int year;
	@NotBlank(message = "*Please enter the description for the movie!")
	private String description;
	
	@Transient
	private MultipartFile file;
	

	/** **/
	@ManyToOne(fetch = FetchType.LAZY,cascade = { CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="genre_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Genre genre;

	
	/** **/
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name="movie_lang",
			joinColumns = { @JoinColumn(name ="movie_id") },
			inverseJoinColumns = { @JoinColumn(name = "lang_id") }
			)
	private Set<Language> languages =  new HashSet<>();

	
	/** **/
	@Valid
	@OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "movie_id")
	private List<Cast> castList = new ArrayList<>();
	
	public Movie() {
		this.code = "MV" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Set<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<Language> languages) {
		this.languages = languages;
	}

	public List<Cast> getCastList() {
		return castList;
	}

	public void setCastList(List<Cast> castList) {
		this.castList = castList;
	}
	

}