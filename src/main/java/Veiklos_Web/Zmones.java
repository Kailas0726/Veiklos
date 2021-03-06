package Veiklos_Web;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

//import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Zmones {
	
		public Zmones() {
			
			super();

		}

		 @Id
		 @GeneratedValue(strategy=GenerationType.IDENTITY)
		 
		 private Integer id;
		 private Integer id_partijos;
		 private String vardas;
		 private String pavarde;
		 private String elektroninis_pastas;
		 private String telefono_numeris;
		 
		 //@JsonIgnore
		 @ManyToOne
		 @JoinColumn(name="id_partijos", referencedColumnName="id", insertable=false, updatable=false)
		 private Partijos partija;
		 
		 
		 @OneToMany(cascade = CascadeType.ALL)
		 @JoinColumn(name="zmones_id", referencedColumnName="id", insertable=false, updatable=false)
		 private List<ZmonesVeiklos> zmones_veiklos;
		 
		public Partijos getPartija() {
			
			return partija;
			
		}
		public void setPartija(Partijos partija) {
			
			this.partija = partija;
			
		}
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
		
		public Integer getId_partijos() {
			
			return id_partijos;
			
		}
		public void setId_partijos(Integer id_partijos) {
			
			this.id_partijos = id_partijos;
			
		}
		public String getVardas() {
			
			return vardas;
			
		}
		public void setVardas(String vardas) {

			this.vardas = vardas;
			
		}
		public String getPavarde() {
			
			return pavarde;
			
		}
		public void setPavarde(String pavarde) {
			
			this.pavarde = pavarde;
			
		}
		public String getElektroninis_pastas() {
			
			return elektroninis_pastas;
			
		}
		public void setElektroninis_pastas(String elektroninis_pastas) {
			
			this.elektroninis_pastas = elektroninis_pastas;
			
		}
		public String getTelefono_numeris() {
			
			return telefono_numeris;
			
		}
		public void setTelefono_numeris(String telefono_numeris) {
			
			this.telefono_numeris = telefono_numeris;
			
		}	
		
}
