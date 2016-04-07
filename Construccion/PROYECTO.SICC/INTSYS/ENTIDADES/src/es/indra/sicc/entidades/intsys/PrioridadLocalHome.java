package es.indra.sicc.entidades.intsys;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.intsys.PrioridadLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PrioridadLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public PrioridadLocal create() throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_PRIO_SEQ");
		PrioridadLocal local = new PrioridadLocal(oid);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PrioridadLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PrioridadLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PrioridadLocal findByPrimaryKey(Long  oid) {
		PrioridadLocal local = em.find(PrioridadLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("PrioridadLocal.FindAll");
        	return query.getResultList();
	}

}
