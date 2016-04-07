package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.BloqueoMovBancLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class BloqueoMovBancLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();
    
	public BloqueoMovBancLocal create(String usuario, BigDecimal tiempo, Long movimientoBanc) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_CBMB_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		BloqueoMovBancLocal local = new BloqueoMovBancLocal(oid, usuario, tiempo, movimientoBanc);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(BloqueoMovBancLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(BloqueoMovBancLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public BloqueoMovBancLocal findByPrimaryKey(Long  oid) {
		BloqueoMovBancLocal local = (BloqueoMovBancLocal)em.find(BloqueoMovBancLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public BloqueoMovBancLocal findByUk(Long movimientoBanc) {
		Query query=em.createNamedQuery("BloqueoMovBancLocal.FindByUk");
		
		query.setParameter(1, movimientoBanc);

		return (BloqueoMovBancLocal)(query.getSingleResult());
	}

}
