package es.indra.sicc.cmn.negocio.interfaces.fachada;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.cmn.negocio.interfaces.fachada.NumeroLoteLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class NumeroLoteLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cmn");
	private EntityManager em = emf.createEntityManager();

	public NumeroLoteLocal create(String id) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		NumeroLoteLocal local = new NumeroLoteLocal(id);
		em.persist(local);
		et.commit();
                return local;
	}
	
	public void remove(NumeroLoteLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(NumeroLoteLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public NumeroLoteLocal findByPrimaryKey(String id) {
		NumeroLoteLocal local = (NumeroLoteLocal)em.find(NumeroLoteLocal.class, id);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("NumeroLoteLocal.FindAll");
		return query.getResultList();
	}

}
