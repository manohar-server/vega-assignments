package rest.example.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity(name = "student")
public class StudentBO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "studentBO", fetch = FetchType.EAGER)
	private Collection<MarksBO> markss = new ArrayList<MarksBO>();
	
	public Collection<MarksBO> getMarkss() {
		return markss;
	}
	public void setMarkss(Collection<MarksBO> markss) {
		this.markss = markss;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
