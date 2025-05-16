package bdbt_bada_project.OSKApplication.Database.Oferty;

public class Oferta {
	private int id_oferty;
	private String nazwa;
	private String okres;
	private String cena;
	private int id_operatora;
	private int id_planu;
	private String specjalna;

	public Oferta() {
	}

	public Oferta(int id_oferty, String nazwa, String okres, String cena, int id_operatora, int id_planu,
			String specjalna) {
		this.id_oferty = id_oferty;
		this.nazwa = nazwa;
		this.okres = okres;
		this.cena = cena;
		this.id_operatora = id_operatora;
		this.id_planu = id_planu;
		this.specjalna = specjalna;
	}

	public int getId_oferty() {
		return id_oferty;
	}

	public void setId_oferty(int id_oferty) {
		this.id_oferty = id_oferty;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getOkres() {
		return okres;
	}

	public void setOkres(String okres) {
		this.okres = okres;
	}

	public String getCena() {
		return cena;
	}

	public void setCena(String cena) {
		this.cena = cena;
	}

	public int getId_operatora() {
		return id_operatora;
	}

	public void setId_operatora(int id_operatora) {
		this.id_operatora = id_operatora;
	}

	public int getId_planu() {
		return id_planu;
	}

	public void setId_planu(int id_planu) {
		this.id_planu = id_planu;
	}

	public String getSpecjalna() {
		return specjalna;
	}

	public void setSpecjalna(String specjalna) {
		this.specjalna = specjalna;
	}

	@Override
	public String toString() {
		return "Oferta{" +
				"id_oferty=" + id_oferty +
				", nazwa='" + nazwa + '\'' +
				", okres='" + okres + '\'' +
				", cena='" + cena + '\'' +
				", id_operatora=" + id_operatora +
				", id_planu=" + id_planu +
				", specjalna='" + specjalna + '\'' +
				'}';
	}
}
