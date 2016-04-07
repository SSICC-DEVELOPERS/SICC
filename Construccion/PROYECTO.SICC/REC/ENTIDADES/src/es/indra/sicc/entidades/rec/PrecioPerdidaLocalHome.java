package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.PrecioPerdidaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PrecioPerdidaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public PrecioPerdidaLocal create(String codPrecioPerdida) throws MareException{
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_PPER_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                PrecioPerdidaLocal local = new PrecioPerdidaLocal(oid, codPrecioPerdida);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PrecioPerdidaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PrecioPerdidaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PrecioPerdidaLocal findByPrimaryKey(Long  oid) {
		PrecioPerdidaLocal local = (PrecioPerdidaLocal)em.find(PrecioPerdidaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("PrecioPerdidaLocal.FindAll");
		
		return (query.getResultList());
	}

}
