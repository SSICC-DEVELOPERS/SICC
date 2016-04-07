package es.indra.sicc.entidades.cob;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cob.SubtipoAccionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class SubtipoAccionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cob");
	private EntityManager em = emf.createEntityManager();

	public SubtipoAccionLocal create(Character codigo) throws MareException {
		final EntityTransaction et = em.getTransaction();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COB_SACC_SEQ");
		et.begin();
		SubtipoAccionLocal local = new SubtipoAccionLocal(oid, codigo);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(SubtipoAccionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(SubtipoAccionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public SubtipoAccionLocal findByPrimaryKey(Long  oid) {
		SubtipoAccionLocal local = (SubtipoAccionLocal)em.find(SubtipoAccionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
            Query query=em.createNamedQuery("SubtipoAccionLocal.FindAll");          
            return query.getResultList();
        }
}
