package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.FormaCalculoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class FormaCalculoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public FormaCalculoLocal create() throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_FCAL_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		FormaCalculoLocal local = new FormaCalculoLocal(oid);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(FormaCalculoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(FormaCalculoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public FormaCalculoLocal findByPrimaryKey(Long  oid) {
		FormaCalculoLocal local = (FormaCalculoLocal)em.find(FormaCalculoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                    Query query = em.createNamedQuery("FormaCalculoLocal.FindAll");
                    return query.getResultList();
            }

}
