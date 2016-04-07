package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.TipoOfertaActividadLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoOfertaActividadLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();

	public TipoOfertaActividadLocal create(Long oidActividad, Long oidTipoOferta)
        throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_ATOF_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		TipoOfertaActividadLocal local = new TipoOfertaActividadLocal(oid, oidActividad, oidTipoOferta);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoOfertaActividadLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoOfertaActividadLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoOfertaActividadLocal findByPrimaryKey(Long  oid) {
		TipoOfertaActividadLocal local = (TipoOfertaActividadLocal)em.find(TipoOfertaActividadLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByOidActividad(Long oidActividad) {
		Query query=em.createNamedQuery("TipoOfertaActividadLocal.FindByOidActividad");
		
		query.setParameter(1, oidActividad);

		return query.getResultList();
	}

}
