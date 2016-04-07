package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.EstadosMAVLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EstadosMAVLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();

	public EstadosMAVLocal create(Long oidPais) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_EMAV_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		EstadosMAVLocal local = new EstadosMAVLocal(oid, oidPais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(EstadosMAVLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(EstadosMAVLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public EstadosMAVLocal findByPrimaryKey(Long  oid) {
		EstadosMAVLocal local = (EstadosMAVLocal)em.find(EstadosMAVLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
