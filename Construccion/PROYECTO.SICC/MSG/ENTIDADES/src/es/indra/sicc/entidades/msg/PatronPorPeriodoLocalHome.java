package es.indra.sicc.entidades.msg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.msg.PatronPorPeriodoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PatronPorPeriodoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-msg");
	private EntityManager em = emf.createEntityManager();

	public PatronPorPeriodoLocal create(Long patr_oid_patr_orig, Long patr_oid_patr, Long peri_oid_peri) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();                
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MSG_PAPE_SEQ");
		PatronPorPeriodoLocal local = new PatronPorPeriodoLocal(oid, patr_oid_patr_orig, patr_oid_patr, peri_oid_peri);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PatronPorPeriodoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PatronPorPeriodoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PatronPorPeriodoLocal findByPrimaryKey(Long  oid) {
		PatronPorPeriodoLocal local = (PatronPorPeriodoLocal)em.find(PatronPorPeriodoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public PatronPorPeriodoLocal findByPatron(Long param1) {
		Query query=em.createNamedQuery("PatronPorPeriodoLocal.FindByPatron");
		
		query.setParameter(1, param1);

		return (PatronPorPeriodoLocal)(query.getSingleResult());
	}

	public Collection findByPatronOrigen(Long param1) {
		Query query=em.createNamedQuery("PatronPorPeriodoLocal.FindByPatronOrigen");
		query.setParameter(1, param1);
		return query.getResultList();
	}

	public Collection findByPatronPeriodo(Long param1,Long param2) {
		Query query=em.createNamedQuery("PatronPorPeriodoLocal.FindByPatronPeriodo");
		query.setParameter(1, param1);
		query.setParameter(2, param2);
		return query.getResultList();
	}

}
