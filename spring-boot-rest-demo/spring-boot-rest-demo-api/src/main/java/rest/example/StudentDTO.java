package rest.example;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class StudentDTO {

	private Long id;
	private String name;
	
	private Collection<MarksDTO> marksDTOs = null;
	
	public Collection<MarksDTO> getMarksDTOs() {
		return marksDTOs;
	}
	public void setMarksDTOs(Collection<MarksDTO> marksDTOs) {
		this.marksDTOs = marksDTOs;
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
