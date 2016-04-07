package es.indra.sicc.entidades.cal;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cal.InterfazTemporalIVRLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class InterfazTemporalIVRLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cal");
	private EntityManager em = emf.createEntityManager();

	public InterfazTemporalIVRLocal create(Long num_telf, String fec_llam, Long pais_oid_pais) throws MareException {
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("CAL_TIVR_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		InterfazTemporalIVRLocal local = new InterfazTemporalIVRLocal(oid, num_telf, fec_llam, pais_oid_pais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(InterfazTemporalIVRLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(InterfazTemporalIVRLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public InterfazTemporalIVRLocal findByPrimaryKey(Long  oid) {
		InterfazTemporalIVRLocal local = (InterfazTemporalIVRLocal)em.find(InterfazTemporalIVRLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

         public Collection findAll() {
                Query query=em.createNamedQuery("InterfazTemporalIVRLocal.FindAll");
                return query.getResultList();
        }
}
