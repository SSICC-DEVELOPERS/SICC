package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.EstadoEnvioLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EstadoEnvioLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();

	public EstadoEnvioLocal create(String descripcion) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_ESEN_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		EstadoEnvioLocal local = new EstadoEnvioLocal(oid, descripcion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(EstadoEnvioLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(EstadoEnvioLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public EstadoEnvioLocal findByPrimaryKey(Long  oid) {
		EstadoEnvioLocal local = (EstadoEnvioLocal)em.find(EstadoEnvioLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
