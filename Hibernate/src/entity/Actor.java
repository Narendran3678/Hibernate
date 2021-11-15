package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Actor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="actor_name",nullable=false)
	private String actorName;
	
	@Column(name="actor_age")
	private int age;
	
	@ManyToMany(mappedBy="actor")
	private Set<Movie> movie = new HashSet<Movie>();

	public Actor()
	{
		
	}
	public Actor(String actorName, int age) {
		super();
		this.actorName = actorName;
		this.age = age;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<Movie> getMovie() {
		return movie;
	}

	public void setMovie(Set<Movie> movie) {
		this.movie = movie;
	}
	public void addMovie(Movie movie)
	{
		this.movie.add(movie);
		movie.getActor().add(this);
		
	}
	@Override
	public String toString() {
		return "Actor [id=" + id + ", actorName=" + actorName + ", age=" + age + ", movie=" + movie + "]";
	}
	
	
	
}
