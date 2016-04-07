package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.SituacionCuponesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class SituacionCuponesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();

	public SituacionCuponesLocal create(String codigoSituacion, String descripcion)
                                                                                throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_SICU_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		SituacionCuponesLocal local = new SituacionCuponesLocal(oid, codigoSituacion, descripcion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(SituacionCuponesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(SituacionCuponesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public SituacionCuponesLocal findByPrimaryKey(Long  oid) {
		SituacionCuponesLocal local = (SituacionCuponesLocal)em.find(SituacionCuponesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public SituacionCuponesLocal findByCodigoSituacion(String codigoSituacion) {
		Query query=em.createNamedQuery("SituacionCuponesLocal.FindByCodigoSituacion");
		
		query.setParameter(1, codigoSituacion);

		return (SituacionCuponesLocal)(query.getSingleResult());
	}

}
