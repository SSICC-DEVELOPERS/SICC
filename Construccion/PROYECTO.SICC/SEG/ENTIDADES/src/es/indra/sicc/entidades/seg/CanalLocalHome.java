package es.indra.sicc.entidades.seg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.seg.CanalLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CanalLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-seg");
	private EntityManager em = emf.createEntityManager();

	public CanalLocal create(String codCanal, Long oidTipoPeriodo) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("SEG_CANA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		CanalLocal local = new CanalLocal(oid, codCanal, oidTipoPeriodo);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CanalLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CanalLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CanalLocal findByPrimaryKey(Long  oid) {
		CanalLocal local = (CanalLocal)em.find(CanalLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public CanalLocal findByClaveUnica(String param1) {
		Query query=em.createNamedQuery("CanalLocal.FindByClaveUnica");
		query.setParameter(1, param1);
		return (CanalLocal)(query.getSingleResult());
	}

	public CanalLocal findByUK(String param1) {
		Query query=em.createNamedQuery("CanalLocal.FindByUK");
		query.setParameter(1, param1);
		return (CanalLocal)(query.getSingleResult());
	}
	
	public Collection findAll() {
		Query query = em.createNamedQuery("CanalLocal.FindAll");
		return query.getResultList();
	}

}
