package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.SituacionReclamoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class SituacionReclamoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();
    
	public SituacionReclamoLocal create() throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_SIRE_SEQ");        
		final EntityTransaction et = em.getTransaction();
		et.begin();
		SituacionReclamoLocal local = new SituacionReclamoLocal(oid);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(SituacionReclamoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(SituacionReclamoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public SituacionReclamoLocal findByPrimaryKey(Long  oid) {
		SituacionReclamoLocal local = (SituacionReclamoLocal)em.find(SituacionReclamoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
