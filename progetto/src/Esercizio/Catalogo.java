package Esercizio;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.Table;

@Entity
@Table(name="catalogo")
@Inheritance(strategy =InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="Catalogo",discriminatorType = DiscriminatorType.STRING )


public class Catalogo implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ISBN")
	private Integer ISBN;
	@Column(name = "titolo")
	private String titolo;
	@Column(name = "annopublicazione")
	private Integer annopubblicazione;
	@Column(name = "numeroPagine")
	private int numeropagine;
	
	public Catalogo() {
		super();
	}

	public Integer getISBN() {
		return ISBN;
	}

	public void setISBN(Integer iSBN) {
		ISBN = iSBN;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Integer getAnnopubblicazione() {
		return annopubblicazione;
	}

	public void setAnnopubblicazione(Integer annopubblicazione) {
		this.annopubblicazione = annopubblicazione;
	}

	public int getNumeropagine() {
		return numeropagine;
	}

	public void setNumeropagine(int numeropagine) {
		this.numeropagine = numeropagine;
	}

	
	

}

