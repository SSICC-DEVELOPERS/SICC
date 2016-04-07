package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.CriterioAsignacionActividadLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CriterioAsignacionActividadLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();

	public CriterioAsignacionActividadLocal create(Long oidActividad, Long oidCriterioAsignacion)
            throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_CRAA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		CriterioAsignacionActividadLocal local = new CriterioAsignacionActividadLocal(oid, oidActividad, oidCriterioAsignacion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CriterioAsignacionActividadLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CriterioAsignacionActividadLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CriterioAsignacionActividadLocal findByPrimaryKey(Long  oid) {
		CriterioAsignacionActividadLocal local = (CriterioAsignacionActividadLocal)em.find(CriterioAsignacionActividadLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByOidActividad(Long oidActividad) {
		Query query=em.createNamedQuery("CriterioAsignacionActividadLocal.FindByOidActividad");
		
		query.setParameter(1, oidActividad);

		return query.getResultList();
	}

}
