package es.indra.sicc.entidades.edu;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.edu.PlantillaTiposCursosExigidosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PlantillaTiposCursosExigidosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-edu");
	private EntityManager em = emf.createEntityManager();

	public PlantillaTiposCursosExigidosLocal create(Long oidDetaPlanCurs, Long oidCurs) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("EDU_ESPC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		PlantillaTiposCursosExigidosLocal local = new PlantillaTiposCursosExigidosLocal(oid, oidDetaPlanCurs, oidCurs);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PlantillaTiposCursosExigidosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PlantillaTiposCursosExigidosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PlantillaTiposCursosExigidosLocal findByPrimaryKey(Long  oid) {
		PlantillaTiposCursosExigidosLocal local = (PlantillaTiposCursosExigidosLocal)em.find(PlantillaTiposCursosExigidosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("PlantillaTiposCursosExigidosLocal.FindAll");
		
		return query.getResultList();
	}

}
