package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.ParametrizacionChequeoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ParametrizacionChequeoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public ParametrizacionChequeoLocal create() throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_PCHQ_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                ParametrizacionChequeoLocal local = new ParametrizacionChequeoLocal(oid);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametrizacionChequeoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametrizacionChequeoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametrizacionChequeoLocal findByPrimaryKey(Long  oid) {
		ParametrizacionChequeoLocal local = (ParametrizacionChequeoLocal)em.find(ParametrizacionChequeoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("ParametrizacionChequeoLocal.FindAll");
		
		return query.getResultList();
	}
        
        public ParametrizacionChequeoLocal findByUK(Long oidTipoChequeo) {
                Query query=em.createNamedQuery("ParametrizacionChequeoLocal.FindByUK");
                
                query.setParameter(1, oidTipoChequeo);
    
                return (ParametrizacionChequeoLocal)(query.getSingleResult());
        }


}
