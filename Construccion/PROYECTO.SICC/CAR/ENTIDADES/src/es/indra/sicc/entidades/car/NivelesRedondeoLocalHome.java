package es.indra.sicc.entidades.car;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.car.NivelesRedondeoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class NivelesRedondeoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-car");
	private EntityManager em = emf.createEntityManager();

	public NivelesRedondeoLocal create(Long  oid) throws MareException {
	        oid = SecuenciadorOID.obtenerSiguienteValor("CAR_NIRE_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		NivelesRedondeoLocal local = new NivelesRedondeoLocal(oid);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(NivelesRedondeoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(NivelesRedondeoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public NivelesRedondeoLocal findByPrimaryKey(Long  oid) {
		NivelesRedondeoLocal local = (NivelesRedondeoLocal)em.find(NivelesRedondeoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
        
        public Collection findAll() {
            Query query=em.createNamedQuery("NivelesRedondeoLocal.FindAll");          
            return query.getResultList();
        }

	
}
