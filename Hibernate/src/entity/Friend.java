package entity;

import java.util.*;

import javax.persistence.*;
@Entity
public class Friend 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name",nullable=false)
	private String name;
	
	@Column(name="email",nullable=false)
	private String email;
	
	@ElementCollection
	@CollectionTable(name="friend_nickname",joinColumns=@JoinColumn(name="friend_id"))
	@Column(name="nickname")
	private Set<String> nickName = new HashSet<String>();
	
	
	public Friend(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<String> getNickName() {
		return nickName;
	}
	public void setNickName(Set<String> nickName) {
		this.nickName = nickName;
	}
	@Override
	public String toString() {
		return "Friend [id=" + id + ", name=" + name + ", email=" + email + ", nickName=" + nickName + "]";
	}
	
	
}
