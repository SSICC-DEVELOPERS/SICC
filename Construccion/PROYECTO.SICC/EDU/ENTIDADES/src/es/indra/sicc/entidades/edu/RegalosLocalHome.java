package es.indra.sicc.entidades.edu;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.edu.RegalosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class RegalosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-edu");
	private EntityManager em = emf.createEntityManager();

	public RegalosLocal create(Integer codigo, Long pais)throws MareException {
                Long oid=SecuenciadorOID.obtenerSiguienteValor("EDU_REGA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		RegalosLocal local = new RegalosLocal(oid, codigo, pais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(RegalosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(RegalosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public RegalosLocal findByPrimaryKey(Long  oid) {
		RegalosLocal local = (RegalosLocal)em.find(RegalosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
