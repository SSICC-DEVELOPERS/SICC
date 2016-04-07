package es.indra.sicc.entidades.rep;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rep.RepReporLocal;

public class RepReporLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rep");
	private EntityManager em = emf.createEntityManager();

	public RepReporLocal create(Long oidRepo, String codReporte) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		RepReporLocal local = new RepReporLocal(oidRepo, codReporte);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(RepReporLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(RepReporLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public RepReporLocal findByPrimaryKey(java.lang.Long  oidRepo) {
		RepReporLocal local = (RepReporLocal)em.find(RepReporLocal.class, oidRepo);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("RepReporLocal.FindAll");
		return (query.getResultList());
	}

	public RepReporLocal findByUk(java.lang.String param1) {
		Query query=em.createNamedQuery("RepReporLocal.FindByUk");
		query.setParameter(1, param1);
		return (RepReporLocal)(query.getSingleResult());
	}

}