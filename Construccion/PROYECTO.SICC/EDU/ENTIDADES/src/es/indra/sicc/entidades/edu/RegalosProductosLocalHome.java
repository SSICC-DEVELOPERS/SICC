package es.indra.sicc.entidades.edu;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.edu.RegalosProductosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class RegalosProductosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-edu");
	private EntityManager em = emf.createEntityManager();
        
	public RegalosProductosLocal create(Long regalo, Long producto) throws  MareException {
                Long oid=SecuenciadorOID.obtenerSiguienteValor("EDU_REDE_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		RegalosProductosLocal local = new RegalosProductosLocal(oid, regalo, producto);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(RegalosProductosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(RegalosProductosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public RegalosProductosLocal findByPrimaryKey(Long  oid) {
		RegalosProductosLocal local = (RegalosProductosLocal)em.find(RegalosProductosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
