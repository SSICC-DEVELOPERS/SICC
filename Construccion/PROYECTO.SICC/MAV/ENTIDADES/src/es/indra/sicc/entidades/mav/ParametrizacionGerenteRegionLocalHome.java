package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.ParametrizacionGerenteRegionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ParametrizacionGerenteRegionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();

	public ParametrizacionGerenteRegionLocal create(Long oidParametrizacionMAV, Long oidSubtipoCliente) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_PGRE_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ParametrizacionGerenteRegionLocal local = new ParametrizacionGerenteRegionLocal(oid, oidParametrizacionMAV, oidSubtipoCliente);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametrizacionGerenteRegionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametrizacionGerenteRegionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametrizacionGerenteRegionLocal findByPrimaryKey(Long  oid) {
		ParametrizacionGerenteRegionLocal local = (ParametrizacionGerenteRegionLocal)em.find(ParametrizacionGerenteRegionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByParametrizacion(Long oidParam) {
		Query query=em.createNamedQuery("ParametrizacionGerenteRegionLocal.FindByParametrizacion");
		
		query.setParameter(1, oidParam);

		return query.getResultList();
	}

}
