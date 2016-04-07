package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.CicloVidaActividadLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CicloVidaActividadLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();

	public CicloVidaActividadLocal create(Long oidActividad, Long oidCicloVida)
        throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_ACCV_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		CicloVidaActividadLocal local = new CicloVidaActividadLocal(oid, oidActividad, oidCicloVida);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CicloVidaActividadLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CicloVidaActividadLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CicloVidaActividadLocal findByPrimaryKey(Long  oid) {
		CicloVidaActividadLocal local = (CicloVidaActividadLocal)em.find(CicloVidaActividadLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByOidActividad(Long oidActividad) {
		Query query=em.createNamedQuery("CicloVidaActividadLocal.FindByOidActividad");
		
		query.setParameter(1, oidActividad);

		return query.getResultList();
	}

}
