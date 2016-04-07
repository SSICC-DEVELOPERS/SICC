package es.indra.sicc.entidades.car;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.car.IndicadorValidacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class IndicadorValidacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-car");
	private EntityManager em = emf.createEntityManager();

	public IndicadorValidacionLocal create(String cod_indi_vali) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CAR_INVA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		IndicadorValidacionLocal local = new IndicadorValidacionLocal(oid, cod_indi_vali);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(IndicadorValidacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(IndicadorValidacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public IndicadorValidacionLocal findByPrimaryKey(Long  oid) {
		IndicadorValidacionLocal local = (IndicadorValidacionLocal)em.find(IndicadorValidacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
        
        public Collection findAll() {
            Query query=em.createNamedQuery("IndicadorValidacionLocal.FindAll");          
            return query.getResultList();
        }

	
}
