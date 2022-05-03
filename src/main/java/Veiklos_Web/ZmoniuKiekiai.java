package Veiklos_Web;

import java.io.Serializable;

import javax.persistence.Id;

public class ZmoniuKiekiai implements Serializable{
	
	@Id
	private int id;
	private String veikla;
	private String aprasymas;
	private int zmoniu_skaicius;
	
	public ZmoniuKiekiai() {
		
		
	}

	public int getId() {
		
		return id;
		
	}

	public void setId(int id) {
		
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

	public int getZmoniu_skaicius() {
		
		return zmoniu_skaicius;
		
	}

	public void setZmoniu_skaicius(int zmoniu_skaicius) {
		
		this.zmoniu_skaicius = zmoniu_skaicius;
		
	}
	
	

}
