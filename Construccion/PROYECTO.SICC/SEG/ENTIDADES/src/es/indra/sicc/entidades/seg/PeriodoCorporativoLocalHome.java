package es.indra.sicc.entidades.seg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.seg.PeriodoCorporativoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PeriodoCorporativoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-seg");
	private EntityManager em = emf.createEntityManager();

	public PeriodoCorporativoLocal create(Long oid, Long oidTipoPeriodo, String codigoPeriodo, Long anio)
			throws MareException {
		
		final EntityTransaction et = em.getTransaction();
		et.begin();
		PeriodoCorporativoLocal local = new PeriodoCorporativoLocal(oid, oidTipoPeriodo, codigoPeriodo, anio);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PeriodoCorporativoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PeriodoCorporativoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PeriodoCorporativoLocal findByPrimaryKey(Long  oid) {
		PeriodoCorporativoLocal local = (PeriodoCorporativoLocal)em.find(PeriodoCorporativoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	public PeriodoCorporativoLocal findByUK(String codPeri) {
		Query query=em.createNamedQuery("PeriodoCorporativoLocal.FindByUK");
		query.setParameter(1, codPeri);
		return (PeriodoCorporativoLocal)(query.getSingleResult());
	}
	
	public Collection findAll() {
		Query query=em.createNamedQuery("PeriodoCorporativoLocal.FindAll");
		return query.getResultList();
	}

}
