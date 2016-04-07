package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.TipoDespachoActividadLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoDespachoActividadLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();
   
	public TipoDespachoActividadLocal create(Long oidActividad, Long oidTipoDespacho)
        throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_ATDE_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		TipoDespachoActividadLocal local = new TipoDespachoActividadLocal(oid, oidActividad, oidTipoDespacho);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoDespachoActividadLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoDespachoActividadLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoDespachoActividadLocal findByPrimaryKey(Long  oid) {
		TipoDespachoActividadLocal local = (TipoDespachoActividadLocal)em.find(TipoDespachoActividadLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByOidActividad(Long oidActividad) {
		Query query=em.createNamedQuery("TipoDespachoActividadLocal.FindByOidActividad");
		
		query.setParameter(1, oidActividad);

		return query.getResultList();
	}

	public Collection findByCampos(Long oidTipoDespachoMAV,Long oidActividad,Long oidEnvioConSolicitud) {
		Query query=em.createNamedQuery("TipoDespachoActividadLocal.FindByCampos");
		
		query.setParameter(1, oidTipoDespachoMAV);

		query.setParameter(2, oidActividad);

		query.setParameter(3, oidEnvioConSolicitud);

		return query.getResultList();
	}

}
