package Esercizio;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.catalog.Catalog;

public class MainProject {
	private static final Catalogo  = null;
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Esercizio15b");
	static EntityManager em =emf.createEntityManager();

	public static void main(String[] args) {
		//leggiTuttiILibri();
		// TODO Auto-generated method stub
		Utente u =new Utente();
		u.setNome("Luca");
		u.setCognome("Verdi");
		u.setDatanascita(LocalDate.now());
		//aggiungiUtente(u);
		
		Prestito p= new Prestito();
		p.setElementoprestato(0);
		p.setInizioprestito(LocalDate.now());
		p.setRestituzioneffettiva(LocalDate.now());
		p.setRestituzioneprevista(LocalDate.now());
		
		//aggiungiPrestito(p);
		
//	    Catalogo c = new Catalogo();
//	    c.setAnnopubblicazione(2002);
//	    c.setTitolo("Hunger Games");
//	    c.setNumeropagine(250);
//		aggiungiCatalogo(c);
		
		Libri l = new Libri();
		l.setTitolo("Hanger Games");
		l.setAutore("Suzanne Collins");
	    l.setGenere("Avventura");
	    l.setAnnopubblicazione(2002);
	    Libri n = new Libri();
		n.setTitolo("La commedia");
		n.setAutore("Dante");
	    n.setGenere("1304");
	    n.setAnnopubblicazione(1994);
	    
	    Libri r = new Libri();
		r.setTitolo("Piccolo principe");
		r.setAutore("Saint-Exupery");
	    r.setGenere("Avventura");
	    
	    Riviste s = new Riviste();
	    s.setTitolo("Focus");
	    s.setPeriodicita(Periodicita.SETTIMANALE);
	    
	    Riviste r1 = new Riviste();
	    r1.setTitolo("NewYorker");
	    r1.setPeriodicita(Periodicita.MENSILE);
	    
	    Riviste r2 = new Riviste();
		r2.setTitolo("Vouge");
		r2.setPeriodicita(Periodicita.SETTIMANALE);
	    
	    aggiungiCatalogo1(l);
	    //rimozione(2);
	    ricercaisbn(1);
	    Query query = null;
		List risultato = query.getResultList();
	    
	}
   
	
	private static void aggiungiUtente(Utente u ) {
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		System.out.println("Utente aggiunto nel db");
	}
	
	private static void aggiungiPrestito(Prestito p1 ) {
		em.getTransaction().begin();
		em.persist(p1);
		em.getTransaction().commit();
		System.out.println("Prestito aggiunto nel db");
	}
	
	
	private static void aggiungiCatalogo1(Catalogo l) {
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		System.out.println("Elemento del catalogo-libro aggiunto nel db");
	}
	
	private static void rimozione(Integer id){
		em.getTransaction().begin();
		Libri f=em.find(Libri.class, id);
		em.remove(f);
		em.getTransaction().commit();
		System.out.println("Elemento rimosso  by ISBN");
	}
	
	public static void  ricercaisbn (Integer id) {
		em.getTransaction().begin();
		Catalogo c1 = em.find(Catalogo.class, id);
		em.getTransaction().commit();
		System.out.println("Elemento trovato by Id "  + c1);
	
	}
	
	public static void leggidato(String autore) {
	try {
		Query querySelect = em.createQuery("SELECT autore FROM Catologo autore");
		List<Catalogo> resultList = querySelect.getResultList();
		em.getTransaction().begin();
		
		Query queryUpdate = em.createQuery("UPDATE Catalogo Libri SET titolo = :titolo WHERE Libri.titolo =:titolo");
	    queryUpdate.setParameter( "titolo","HarryPotter");
	    int numeroEntitaAggiornate= queryUpdate.executeUpdate();
	
	}
	finally {
		em.close();
	}
    
	}
//	public static List<Catalogo> leggiTuttiILibri(){
//		EntityManager em = emf.createEntityManager();
//		Query q = em.createNamedQuery("Catalogo.findAll");
//		return q.getResultList();
//	}
//		
//
//	public static String leggiCatalogoDaTitolo(String t){
//	EntityManager em = emf.createEntityManager();
//	Query q = em.createQuery(" SELECT IBNS, annopublicazione, numeroPagine FROM Libri WHERE titolo=Hunger Games");
//	return (String) q.getSingleResult();
//	}
	

	public static Libri leggiDaTitolo () {
		EntityManager em = emf.createEntityManager();
		Query q = em.createNamedQuery("cercaPerTitolo");
		return Libri;
	}
	
	}




//	prof. per questione di tempo dato che lavoro il sabato e la domenica non sono riuscito ad effettuare tutte le media query. 
//	ho perso tempo con esse semplicemente perché ho riscontrato un bel po di problemi e solo
//	domenica pomeriggio sono riuscito a capire come andavano definite e richiamate.


	
	
		
	
	
	

