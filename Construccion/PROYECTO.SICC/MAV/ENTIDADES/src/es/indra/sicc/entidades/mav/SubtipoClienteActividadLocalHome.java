package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.SubtipoClienteActividadLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class SubtipoClienteActividadLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();

	public SubtipoClienteActividadLocal create(Long oidActividad, Long oidSubtipoCliente)
         throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_ASTC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		SubtipoClienteActividadLocal local = new SubtipoClienteActividadLocal(oid, oidActividad, oidSubtipoCliente);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(SubtipoClienteActividadLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(SubtipoClienteActividadLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public SubtipoClienteActividadLocal findByPrimaryKey(Long  oid) {
		SubtipoClienteActividadLocal local = (SubtipoClienteActividadLocal)em.find(SubtipoClienteActividadLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByOidActividad(Long oidActividad) {
		Query query=em.createNamedQuery("SubtipoClienteActividadLocal.FindByOidActividad");
		
		query.setParameter(1, oidActividad);

		return query.getResultList();
	}

}
