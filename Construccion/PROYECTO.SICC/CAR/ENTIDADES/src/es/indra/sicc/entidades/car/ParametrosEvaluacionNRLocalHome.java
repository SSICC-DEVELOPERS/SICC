package es.indra.sicc.entidades.car;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.car.ParametrosEvaluacionNRLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ParametrosEvaluacionNRLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-car");
	private EntityManager em = emf.createEntityManager();

	public ParametrosEvaluacionNRLocal create(String cod_para) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CAR_PENR_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ParametrosEvaluacionNRLocal local = new ParametrosEvaluacionNRLocal(oid, cod_para);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametrosEvaluacionNRLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametrosEvaluacionNRLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametrosEvaluacionNRLocal findByPrimaryKey(Long  oid) {
		ParametrosEvaluacionNRLocal local = (ParametrosEvaluacionNRLocal)em.find(ParametrosEvaluacionNRLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
        
        public Collection findAll() {
            Query query=em.createNamedQuery("ParametrosEvaluacionNRLocal.FindAll");          
            return query.getResultList();
        }

	
}
