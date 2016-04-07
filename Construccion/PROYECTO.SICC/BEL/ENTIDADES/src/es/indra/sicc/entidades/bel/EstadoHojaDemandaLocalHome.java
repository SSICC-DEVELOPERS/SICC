package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.EstadoHojaDemandaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EstadoHojaDemandaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public EstadoHojaDemandaLocal create() throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_DHDE_SEQ");
                EstadoHojaDemandaLocal local = new EstadoHojaDemandaLocal(oid);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(EstadoHojaDemandaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(EstadoHojaDemandaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public EstadoHojaDemandaLocal findByPrimaryKey(Long  oid) {
		EstadoHojaDemandaLocal local = (EstadoHojaDemandaLocal)em.find(EstadoHojaDemandaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("EstadoHojaDemandaLocal.FindAll");
		return query.getResultList();
	}

}
