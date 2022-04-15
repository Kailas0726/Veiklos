package Veiklos_Web;

//import java.util.List;
//import java.util.function.Predicate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;


@Entity
public class ZmonesVeiklos {

	public ZmonesVeiklos() {
		
		super();

	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Integer id;
	private Integer zmones_id;
	private Integer veiklos_id;
	private String kontaktai;
	private String veiklos_vieta;
	private String veiklos_sritis;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="zmones_id", referencedColumnName="id",insertable=false, updatable=false)
	private Zmones zmones;
	
	public Zmones getZmones() {
		
		return zmones;
		
	}
	public void setZmones(Zmones zmones) {
		
		this.zmones = zmones;
		
	}
	public Integer getId() {
		
		return id;
		
	}
	public void setId(Integer id) {
		
		this.id = id;
		
	}
	public Integer getZmones_id() {
		
		return zmones_id;
		
	}
	public void setZmones_id(Integer zmones_id) {
		
		this.zmones_id = zmones_id;
		
	}
	public Integer getVeiklos_id() {
		
		return veiklos_id;
		
	}
	public void setVeiklos_id(Integer veiklos_id) {
		
		this.veiklos_id = veiklos_id;
		
	}
	public String getKontaktai() {
		
		return kontaktai;
		
	}
	public void setKontaktai(String kontaktai) {
		
		this.kontaktai = kontaktai;
		
	}
	public String getVeiklos_vieta() {
		
		return veiklos_vieta;
		
	}
	public void setVeiklos_vieta(String veiklos_vieta) {
		
		this.veiklos_vieta = veiklos_vieta;
		
	}
	
	public String getVeiklos_sritis() {
		
		return veiklos_sritis;
		
	}
	public void setVeiklos_sritis(String veiklos_sritis) {
		
		this.veiklos_sritis = veiklos_sritis;
		
	}
	
	
	

}
