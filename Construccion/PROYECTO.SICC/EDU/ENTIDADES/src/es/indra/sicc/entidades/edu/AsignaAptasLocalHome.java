package es.indra.sicc.entidades.edu;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.edu.AsignaAptasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;

public class AsignaAptasLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-edu");
	private EntityManager em = emf.createEntityManager();

	public AsignaAptasLocal create(Long curso, Timestamp fecha) throws MareException {
                Long oid=SecuenciadorOID.obtenerSiguienteValor("EDU_ASAP_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		AsignaAptasLocal local = new AsignaAptasLocal(oid, curso, fecha);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(AsignaAptasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(AsignaAptasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public AsignaAptasLocal findByPrimaryKey(Long  oid) {
		AsignaAptasLocal local = (AsignaAptasLocal)em.find(AsignaAptasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
