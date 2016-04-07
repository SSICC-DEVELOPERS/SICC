package es.indra.sicc.entidades.cob;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cob.ArgumentosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ArgumentosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cob");
	private EntityManager em = emf.createEntityManager();

	public ArgumentosLocal create(String codigoArgumento, String descripcion, Long pais) throws MareException {
		final EntityTransaction et = em.getTransaction();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COB_ARGU_SEQ");
		et.begin();
		ArgumentosLocal local = new ArgumentosLocal(oid, codigoArgumento, descripcion, pais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ArgumentosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ArgumentosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ArgumentosLocal findByPrimaryKey(Long  oid) {
		ArgumentosLocal local = (ArgumentosLocal)em.find(ArgumentosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
            Query query=em.createNamedQuery("ArgumentosLocal.FindAll");          
            return query.getResultList();
        }
}
