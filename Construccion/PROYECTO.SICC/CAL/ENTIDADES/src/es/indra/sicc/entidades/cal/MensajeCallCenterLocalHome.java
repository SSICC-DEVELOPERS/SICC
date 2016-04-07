package es.indra.sicc.entidades.cal;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cal.MensajeCallCenterLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MensajeCallCenterLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cal");
	private EntityManager em = emf.createEntityManager();

	public MensajeCallCenterLocal create(String val_text_mens, Long pais_oid_pais) throws MareException {
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("CAL_MECL_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
		MensajeCallCenterLocal local = new MensajeCallCenterLocal(oid, val_text_mens, pais_oid_pais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MensajeCallCenterLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MensajeCallCenterLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MensajeCallCenterLocal findByPrimaryKey(Long  oid) {
		MensajeCallCenterLocal local = (MensajeCallCenterLocal)em.find(MensajeCallCenterLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public MensajeCallCenterLocal findByUK(Long pais) {
		Query query=em.createNamedQuery("MensajeCallCenterLocal.FindByUK");
		
		query.setParameter(1, pais);

		return (MensajeCallCenterLocal)(query.getSingleResult());
	}
        public Collection findAll() {
            Query query=em.createNamedQuery("MensajeCallCenterLocal.FindAll");
            return query.getResultList();
        }

}
