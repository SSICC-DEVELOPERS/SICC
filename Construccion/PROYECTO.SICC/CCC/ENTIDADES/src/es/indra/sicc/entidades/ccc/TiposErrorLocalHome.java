package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.TiposErrorLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TiposErrorLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();

	public TiposErrorLocal create(String codigo)
                                            throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_TIER_SEQ");                                            
		final EntityTransaction et = em.getTransaction();
		et.begin();
		TiposErrorLocal local = new TiposErrorLocal(oid, codigo);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TiposErrorLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TiposErrorLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TiposErrorLocal findByPrimaryKey(Long  oid) {
		TiposErrorLocal local = (TiposErrorLocal)em.find(TiposErrorLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public TiposErrorLocal findByUK(String codigo) {
		Query query=em.createNamedQuery("TiposErrorLocal.FindByUK");
		
		query.setParameter(1, codigo);

		return (TiposErrorLocal)(query.getSingleResult());
	}

}
