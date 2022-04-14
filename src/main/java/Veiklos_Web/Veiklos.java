package Veiklos_Web;

//import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Veiklos {

	public Veiklos() {
		
		super();
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer id;
	private String veikla;
	private String aprasymas;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="veiklos_id", referencedColumnName="id", insertable=false, updatable=false)
	private List<ZmonesVeiklos> zmones_veiklos;
	
	
	public List<ZmonesVeiklos> getZmones_veiklos() {
		
		return zmones_veiklos;
		
	}
	public void setZmones_veiklos(List<ZmonesVeiklos> zmones_veiklos) {
		
		this.zmones_veiklos = zmones_veiklos;
		
	}
	public Integer getId() {
		
		return id;
		
	}
	public void setId(Integer id) {
		
		this.id = id;
		
	}
	public String getVeikla() {
		
		return veikla;
		
	}
	public void setVeikla(String veikla) {
		
		this.veikla = veikla;
		
	}
	public String getAprasymas() {
		
		return aprasymas;
		
	}
	public void setAprasymas(String aprasymas) {
		
		this.aprasymas = aprasymas;
		
	}
	

}
