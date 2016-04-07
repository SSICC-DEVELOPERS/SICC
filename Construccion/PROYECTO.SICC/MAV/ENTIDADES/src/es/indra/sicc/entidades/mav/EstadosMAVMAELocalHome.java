package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.EstadosMAVMAELocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EstadosMAVMAELocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();

	public EstadosMAVMAELocal create(Long oidEstadosMAV, Long oidEstatusCliente) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_AVAE_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		EstadosMAVMAELocal local = new EstadosMAVMAELocal(oid, oidEstadosMAV, oidEstatusCliente);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(EstadosMAVMAELocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(EstadosMAVMAELocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public EstadosMAVMAELocal findByPrimaryKey(Long  oid) {
		EstadosMAVMAELocal local = (EstadosMAVMAELocal)em.find(EstadosMAVMAELocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findOidEstadoMAV(Long estadoMAV) {
		Query query=em.createNamedQuery("EstadosMAVMAELocal.FindOidEstadoMAV");
		
		query.setParameter(1, estadoMAV);

		return query.getResultList();
	}

}
