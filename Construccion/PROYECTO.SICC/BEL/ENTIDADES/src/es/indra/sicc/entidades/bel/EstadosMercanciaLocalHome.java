package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.EstadosMercanciaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EstadosMercanciaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public EstadosMercanciaLocal create(Long pais, String codigoEstado) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_ESME_SEQ");
                EstadosMercanciaLocal local = new EstadosMercanciaLocal(oid, pais, codigoEstado);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(EstadosMercanciaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(EstadosMercanciaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public EstadosMercanciaLocal findByPrimaryKey(Long  oid) {
		EstadosMercanciaLocal local = (EstadosMercanciaLocal)em.find(EstadosMercanciaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public EstadosMercanciaLocal findByUK(Long pais,String codigoEstado) {
		Query query=em.createNamedQuery("EstadosMercanciaLocal.FindByUK");
		query.setParameter(1, pais);
		query.setParameter(2, codigoEstado);
		return (EstadosMercanciaLocal)(query.getSingleResult());
	}

}
