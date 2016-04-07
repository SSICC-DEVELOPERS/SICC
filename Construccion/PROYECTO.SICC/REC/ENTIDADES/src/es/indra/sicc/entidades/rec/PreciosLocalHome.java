package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.PreciosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PreciosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public PreciosLocal create(String codPrecio) throws MareException{
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_PECI_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                PreciosLocal local = new PreciosLocal(oid, codPrecio);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PreciosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PreciosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PreciosLocal findByPrimaryKey(Long  oid) {
		PreciosLocal local = (PreciosLocal)em.find(PreciosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("PreciosLocal.FindAll");
		
		return (query.getResultList());
	}

}
