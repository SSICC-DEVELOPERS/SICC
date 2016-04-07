package es.indra.sicc.entidades.car;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.car.CondicionesEvaluacionNRLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CondicionesEvaluacionNRLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-car");
	private EntityManager em = emf.createEntityManager();

	public CondicionesEvaluacionNRLocal create(Long penr_oid_para_eval_nr, Double val_mini, Double val_esca_mini) throws MareException {
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("CAR_CENR_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		CondicionesEvaluacionNRLocal local = new CondicionesEvaluacionNRLocal(oid, penr_oid_para_eval_nr, val_mini, val_esca_mini);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CondicionesEvaluacionNRLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CondicionesEvaluacionNRLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CondicionesEvaluacionNRLocal findByPrimaryKey(Long  oid) {
		CondicionesEvaluacionNRLocal local = (CondicionesEvaluacionNRLocal)em.find(CondicionesEvaluacionNRLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
        
        public Collection findAll() {
            Query query=em.createNamedQuery("CondicionesEvaluacionNRLocal.FindAll");          
            return query.getResultList();
        }

	
}
