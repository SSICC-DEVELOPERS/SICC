package es.indra.sicc.entidades.cal;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cal.TemporalLlamadasIVRLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;
import java.sql.Date;

public class TemporalLlamadasIVRLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cal");
	private EntityManager em = emf.createEntityManager();

	public TemporalLlamadasIVRLocal create(Long telefono, Date fecha, Long pais) throws MareException {
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("CAL_TIVR_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		TemporalLlamadasIVRLocal local = new TemporalLlamadasIVRLocal(oid, telefono, fecha, pais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TemporalLlamadasIVRLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TemporalLlamadasIVRLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TemporalLlamadasIVRLocal findByPrimaryKey(Long  oid) {
		TemporalLlamadasIVRLocal local = (TemporalLlamadasIVRLocal)em.find(TemporalLlamadasIVRLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
       public Collection findAll() {
             Query query=em.createNamedQuery("TemporalLlamadasIVRLocal.FindAll");
             return query.getResultList();
       }

	public TemporalLlamadasIVRLocal findByUK(Long telefono,Long pais) {
		Query query=em.createNamedQuery("TemporalLlamadasIVRLocal.FindByUK");
		
		query.setParameter(1, telefono);

		query.setParameter(2, pais);

		return (TemporalLlamadasIVRLocal)(query.getSingleResult());
	}

}
