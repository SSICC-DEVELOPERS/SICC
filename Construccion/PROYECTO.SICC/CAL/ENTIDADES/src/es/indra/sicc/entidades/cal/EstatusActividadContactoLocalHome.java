package es.indra.sicc.entidades.cal;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cal.EstatusActividadContactoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class EstatusActividadContactoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cal");
	private EntityManager em = emf.createEntityManager();

	public EstatusActividadContactoLocal create(Long valor) throws MareException {
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("CAL_ESAC_SEQ");    
		final EntityTransaction et = em.getTransaction();
		et.begin();
		EstatusActividadContactoLocal local = new EstatusActividadContactoLocal(oid);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(EstatusActividadContactoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(EstatusActividadContactoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public EstatusActividadContactoLocal findByPrimaryKey(Long  oid) {
		EstatusActividadContactoLocal local = (EstatusActividadContactoLocal)em.find(EstatusActividadContactoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
        public Collection findAll() {
            Query query=em.createNamedQuery("EstatusActividadContactoLocal.FindAll");
            return query.getResultList();
        }


	
}
