package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.EstadoCivilLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EstadoCivilLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
	private EntityManager em = emf.createEntityManager();

	public EstadoCivilLocal create(String codigo) throws MareException {
	    Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_ESCV_SEQ");
            final EntityTransaction et = em.getTransaction();
            et.begin();
            EstadoCivilLocal local = new EstadoCivilLocal(oid, codigo);
            em.persist(local);
            et.commit();
            return local;
	}
	
	public void remove(EstadoCivilLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(local);
            et.commit();
	}
	
	public void merge(EstadoCivilLocal local) {
            final EntityTransaction et = em.getTransaction();
            et.begin();
            em.merge(local);
            et.commit();
	}
	
	public EstadoCivilLocal findByPrimaryKey(Long  oid) {
            EstadoCivilLocal local = em.find(EstadoCivilLocal.class, oid);
            if (local==null) throw new NoResultException();
            return local;
	}

	
	public Collection findAll() {
            Query query=em.createNamedQuery("EstadoCivilLocal.FindAll");
            return query.getResultList();
	}

	public EstadoCivilLocal findByUK(String codigo) {
            Query query=em.createNamedQuery("EstadoCivilLocal.FindByUK");
            query.setParameter(1, codigo);
            return (EstadoCivilLocal)(query.getSingleResult());
	}

}
