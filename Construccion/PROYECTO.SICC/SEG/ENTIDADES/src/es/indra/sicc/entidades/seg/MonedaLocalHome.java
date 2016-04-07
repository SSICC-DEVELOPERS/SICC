package es.indra.sicc.entidades.seg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.seg.MonedaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MonedaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-seg");
	private EntityManager em = emf.createEntityManager();

	public MonedaLocal create(String cod_mone, Long num_deci) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("SEG_MONE_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		MonedaLocal local = new MonedaLocal(oid, cod_mone, num_deci);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MonedaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MonedaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MonedaLocal findByPrimaryKey(Long  oid) {
		MonedaLocal local = (MonedaLocal)em.find(MonedaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public MonedaLocal findByUK(String codigo) {
		Query query=em.createNamedQuery("MonedaLocal.FindByUK");
		query.setParameter(1, codigo);
		return (MonedaLocal)(query.getSingleResult());
	}
	
	public Collection findAll() {
		Query query = em.createNamedQuery("MonedaLocal.FindAll");
		return query.getResultList();
	}

}
