package es.indra.sicc.entidades.car;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.car.ParametrosNRLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ParametrosNRLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-car");
	private EntityManager em = emf.createEntityManager();

	public ParametrosNRLocal create(Long niri_oid_nive_ries, Double val_mini) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CAR_PANR_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ParametrosNRLocal local = new ParametrosNRLocal(oid, niri_oid_nive_ries, val_mini);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametrosNRLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametrosNRLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametrosNRLocal findByPrimaryKey(Long  oid) {
		ParametrosNRLocal local = (ParametrosNRLocal)em.find(ParametrosNRLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
        
        public Collection findAll() {
            Query query=em.createNamedQuery("ParametrosNRLocal.FindAll");          
            return query.getResultList();
        }

	
}
