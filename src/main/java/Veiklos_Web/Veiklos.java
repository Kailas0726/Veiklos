package Veiklos_Web;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
