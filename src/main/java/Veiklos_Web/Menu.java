package Veiklos_Web;

public enum Menu {

	Veiklos("/veiklos")
	, Žmonės("/zmones")
	, Partijos("/partijos")
	, Kiekis("/zmoniukiekiai");
	
	private final String itemurl;
	
	Menu( String url ) {
		this.itemurl = url;
	}
	
	public String itemurl() {
		return this.itemurl;
	}
	
}

