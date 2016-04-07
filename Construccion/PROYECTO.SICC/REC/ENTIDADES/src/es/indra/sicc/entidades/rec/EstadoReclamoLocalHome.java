package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.EstadoReclamoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EstadoReclamoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public EstadoReclamoLocal create(String codEstado) throws MareException{
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_ESRE_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                EstadoReclamoLocal local = new EstadoReclamoLocal(oid, codEstado);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(EstadoReclamoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(EstadoReclamoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public EstadoReclamoLocal findByPrimaryKey(Long  oid) {
		EstadoReclamoLocal local = (EstadoReclamoLocal)em.find(EstadoReclamoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("EstadoReclamoLocal.FindAll");
		
		return (query.getResultList());
	}

}
