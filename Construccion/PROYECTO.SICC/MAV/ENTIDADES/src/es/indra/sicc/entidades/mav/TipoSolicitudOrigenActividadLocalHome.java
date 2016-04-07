package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.TipoSolicitudOrigenActividadLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoSolicitudOrigenActividadLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();

	public TipoSolicitudOrigenActividadLocal create(Long oidActividad, Long oidTipoSolicitudPais)
         throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_ATSO_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		TipoSolicitudOrigenActividadLocal local = new TipoSolicitudOrigenActividadLocal(oid, oidActividad, oidTipoSolicitudPais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoSolicitudOrigenActividadLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoSolicitudOrigenActividadLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoSolicitudOrigenActividadLocal findByPrimaryKey(Long  oid) {
		TipoSolicitudOrigenActividadLocal local = (TipoSolicitudOrigenActividadLocal)em.find(TipoSolicitudOrigenActividadLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByOidActividad(Long oidActividad) {
		Query query=em.createNamedQuery("TipoSolicitudOrigenActividadLocal.FindByOidActividad");
		
		query.setParameter(1, oidActividad);

		return query.getResultList();
	}

}
