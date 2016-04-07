package es.indra.sicc.entidades.seg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.seg.AyudaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class AyudaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-seg");
	private EntityManager em = emf.createEntityManager();

	public AyudaLocal create(Long oidFunc) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("SEG_AYUD_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		AyudaLocal local = new AyudaLocal(oid, oidFunc);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(AyudaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(AyudaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public AyudaLocal findByPrimaryKey(Long  oid) {
		AyudaLocal local = (AyudaLocal)em.find(AyudaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
	
	public Collection findAll() {
		Query query = em.createNamedQuery("AyudaLocal.FindAll");
		return query.getResultList();
	}

	public Collection findOidFunc(Long oidFunc) {
		Query query = em.createNamedQuery("AyudaLocal.FindOidFunc");
		query.setParameter(1, oidFunc);
		return query.getResultList();
	}
}
