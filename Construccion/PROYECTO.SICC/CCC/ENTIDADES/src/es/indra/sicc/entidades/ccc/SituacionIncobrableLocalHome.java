package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.SituacionIncobrableLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.util.Collection;

import javax.persistence.Query;

public class SituacionIncobrableLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();

        public SituacionIncobrableLocal create() throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_SIIN_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		SituacionIncobrableLocal local = new SituacionIncobrableLocal(oid);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(SituacionIncobrableLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(SituacionIncobrableLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
        
        public Collection findAll() {
                Query query=em.createNamedQuery("SituacionIncobrableLocal.FindAll");
                return query.getResultList();
        }
        
	public SituacionIncobrableLocal findByPrimaryKey(Long  oid) {
		SituacionIncobrableLocal local = (SituacionIncobrableLocal)em.find(SituacionIncobrableLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
