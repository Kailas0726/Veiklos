package Veiklos_Web;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
public class Partijos {

	public Partijos() {
		
		super();

	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer id;
	private String partija;
	
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_partijos", referencedColumnName="id", insertable=false, updatable=false)    
    private List<Zmones> zmones;
 	
	public Integer getId() {
		
		return id;
		
	}
	public void setId(Integer id) {
		
		this.id = id;
		
	}
	public String getPartija() {
		
		return partija;
		
	}
	public void setPartija(String partija) {
		
		this.partija = partija;
		
	}
	public List<Zmones> getZmones() {
		
		return zmones;
		
	}
	public void setZmones(List<Zmones> zmones) {
		
		this.zmones = zmones;
		
	}

}
