package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Movie 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="movie_name",nullable=false)
	private String movieName;
	@Column(name="movie_rating")
	private String rating;
	
	@ManyToMany(cascade={CascadeType.PERSIST})
	@JoinColumn(name="movie_id")
	
	@JoinTable(
			name="movie_actor",
			joinColumns= {@JoinColumn(name="movie_id")},
			inverseJoinColumns= {@JoinColumn(name="actor_id")}
			)
	private Set<Actor> actor = new HashSet<Actor>();
	
	public Movie()
	{
		
	}
	public Movie(String movieName, String rating) {
		super();
		this.movieName = movieName;
		this.rating = rating;
	}
	
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String moveName) {
		this.movieName = moveName;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}

	public Set<Actor> getActor() {
		return actor;
	}
	public void setActor(Set<Actor> actor) {
		this.actor = actor;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", moveName=" + movieName + ", rating=" + rating + ", actor=" + actor + "]";
	}
	
}
