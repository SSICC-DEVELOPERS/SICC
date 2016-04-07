package es.indra.sicc.entidades.edu;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.edu.ParametrosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ParametrosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-edu");
	private EntityManager em = emf.createEntityManager();

	public ParametrosLocal create() throws MareException{
                Long oid  = SecuenciadorOID.obtenerSiguienteValor("EDU_PAED_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ParametrosLocal local = new ParametrosLocal(oid);
		em.persist(local);
		et.commit();
		return local;
	}
	
        public ParametrosLocal create(Long oid_para) throws MareException{                
                final EntityTransaction et = em.getTransaction();
                et.begin();
                ParametrosLocal local = new ParametrosLocal(oid_para);
                em.persist(local);
                et.commit();
                return local;
        }
    
	public void remove(ParametrosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametrosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametrosLocal findByPrimaryKey(Long  oid) {
		ParametrosLocal local = (ParametrosLocal)em.find(ParametrosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
