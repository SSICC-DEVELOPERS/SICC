package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.ParametrizacionGerenteZonaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ParametrizacionGerenteZonaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();

	public ParametrizacionGerenteZonaLocal create(Long oidParametrizacionMAV, Long oidSubtipoCliente) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_PGZO_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ParametrizacionGerenteZonaLocal local = new ParametrizacionGerenteZonaLocal(oid, oidParametrizacionMAV, oidSubtipoCliente);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametrizacionGerenteZonaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametrizacionGerenteZonaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametrizacionGerenteZonaLocal findByPrimaryKey(Long  oid) {
		ParametrizacionGerenteZonaLocal local = (ParametrizacionGerenteZonaLocal)em.find(ParametrizacionGerenteZonaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByParametrizacion(Long oidParam) {
		Query query=em.createNamedQuery("ParametrizacionGerenteZonaLocal.FindByParametrizacion");
		
		query.setParameter(1, oidParam);

		return query.getResultList();
	}

}
