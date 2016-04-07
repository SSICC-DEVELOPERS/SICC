package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.FormaCobroLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class FormaCobroLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();

	public FormaCobroLocal create(String descripcion) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_FCOB_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		FormaCobroLocal local = new FormaCobroLocal(oid, descripcion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(FormaCobroLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(FormaCobroLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public FormaCobroLocal findByPrimaryKey(Long  oid) {
		FormaCobroLocal local = (FormaCobroLocal)em.find(FormaCobroLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
