package es.indra.sicc.entidades.intsys;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.intsys.EstadoDescuentoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.util.Collection;

import javax.persistence.Persistence;


public class EstadoDescuentoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public EstadoDescuentoLocal create(String codigo) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_ESDE_SEQ");
		EstadoDescuentoLocal local = new EstadoDescuentoLocal(oid, codigo);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(EstadoDescuentoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(EstadoDescuentoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public EstadoDescuentoLocal findByPrimaryKey(Long  oid) {
		EstadoDescuentoLocal local = em.find(EstadoDescuentoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("EstadoDescuentoLocal.FindAll");
		return query.getResultList();
	}

}
