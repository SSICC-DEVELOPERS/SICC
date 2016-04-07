package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.BloqueoMovCCLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class BloqueoMovCCLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();
    
	public BloqueoMovCCLocal create(String usuario, Long tiempo, Long movimientoCC)throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_CBMC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		BloqueoMovCCLocal local = new BloqueoMovCCLocal(oid, usuario, tiempo, movimientoCC);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(BloqueoMovCCLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(BloqueoMovCCLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public BloqueoMovCCLocal findByPrimaryKey(Long  oid) {
		BloqueoMovCCLocal local = (BloqueoMovCCLocal)em.find(BloqueoMovCCLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public BloqueoMovCCLocal findByUk(Long movimientoCC) {
		Query query=em.createNamedQuery("BloqueoMovCCLocal.FindByUk");
		
		query.setParameter(1, movimientoCC);

		return (BloqueoMovCCLocal)(query.getSingleResult());
	}

}
