package es.indra.sicc.entidades.seg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.seg.ModuloLocal;
import es.indra.mare.common.exception.MareException;

public class ModuloLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-seg");
	private EntityManager em = emf.createEntityManager();

	public ModuloLocal create(Long oid, String codigo) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ModuloLocal local = new ModuloLocal(oid, codigo);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ModuloLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ModuloLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ModuloLocal findByPrimaryKey(Long oid) {
		ModuloLocal local = (ModuloLocal)em.find(ModuloLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	public Collection findAll() {
		Query query = em.createNamedQuery("ModuloLocal.FindAll");
		return query.getResultList();
	}
}
