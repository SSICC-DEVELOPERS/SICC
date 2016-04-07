package es.indra.sicc.entidades.edu;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.edu.FrecuenciaCursosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class FrecuenciaCursosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-edu");
	private EntityManager em = emf.createEntityManager();

	public FrecuenciaCursosLocal create(Long codigo) throws MareException {
                Long oid=SecuenciadorOID.obtenerSiguienteValor("EDU_FRCU_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		FrecuenciaCursosLocal local = new FrecuenciaCursosLocal(oid, codigo);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(FrecuenciaCursosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(FrecuenciaCursosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public FrecuenciaCursosLocal findByPrimaryKey(Long  oid) {
		FrecuenciaCursosLocal local = (FrecuenciaCursosLocal)em.find(FrecuenciaCursosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
