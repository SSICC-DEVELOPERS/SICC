package es.indra.sicc.entidades.edu;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.edu.MomentoEntregaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MomentoEntregaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-edu");
	private EntityManager em = emf.createEntityManager();

	public MomentoEntregaLocal create() throws  MareException {
                Long oid=SecuenciadorOID.obtenerSiguienteValor("EDU_MOME_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		MomentoEntregaLocal local = new MomentoEntregaLocal(oid);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MomentoEntregaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MomentoEntregaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MomentoEntregaLocal findByPrimaryKey(Long  oid) {
		MomentoEntregaLocal local = (MomentoEntregaLocal)em.find(MomentoEntregaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
