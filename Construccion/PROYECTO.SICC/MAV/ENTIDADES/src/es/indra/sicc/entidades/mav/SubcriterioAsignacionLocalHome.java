package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.SubcriterioAsignacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class SubcriterioAsignacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();

	public SubcriterioAsignacionLocal create(String descripcion, Long oidCriterioAsignacion) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_SCAS_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		SubcriterioAsignacionLocal local = new SubcriterioAsignacionLocal(oid, descripcion, oidCriterioAsignacion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(SubcriterioAsignacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(SubcriterioAsignacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public SubcriterioAsignacionLocal findByPrimaryKey(Long  oid) {
		SubcriterioAsignacionLocal local = (SubcriterioAsignacionLocal)em.find(SubcriterioAsignacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
