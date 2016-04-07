package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.ObtencionCuentaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.util.Collection;

public class ObtencionCuentaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();

	public ObtencionCuentaLocal create(String valCodi) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_OBCU_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ObtencionCuentaLocal local = new ObtencionCuentaLocal(oid, valCodi);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ObtencionCuentaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ObtencionCuentaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ObtencionCuentaLocal findByPrimaryKey(Long  oid) {
		ObtencionCuentaLocal local = (ObtencionCuentaLocal)em.find(ObtencionCuentaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("ObtencionCuentaLocal.FindAll");
		
		return query.getResultList();
	}

}
