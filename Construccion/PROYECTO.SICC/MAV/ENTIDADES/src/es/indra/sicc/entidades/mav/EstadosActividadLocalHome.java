package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.EstadosActividadLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EstadosActividadLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();

	public EstadosActividadLocal create(Long oidActividad, Long oidEstadosMAV) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_AEST_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		EstadosActividadLocal local = new EstadosActividadLocal(oid, oidActividad, oidEstadosMAV);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(EstadosActividadLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(EstadosActividadLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public EstadosActividadLocal findByPrimaryKey(Long  oid) {
		EstadosActividadLocal local = (EstadosActividadLocal)em.find(EstadosActividadLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByOidActividad(Long oidActividad) {
		Query query=em.createNamedQuery("EstadosActividadLocal.FindByOidActividad");
		
		query.setParameter(1, oidActividad);

		return query.getResultList();
	}

}
