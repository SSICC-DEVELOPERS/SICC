package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.ChequeoUALocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ChequeoUALocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public ChequeoUALocal create() throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_CHUA_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                ChequeoUALocal local = new ChequeoUALocal(oid);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ChequeoUALocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ChequeoUALocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ChequeoUALocal findByPrimaryKey(Long  oid) {
		ChequeoUALocal local = (ChequeoUALocal)em.find(ChequeoUALocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("ChequeoUALocal.FindAll");
		
		return query.getResultList();
	}


}
