package es.indra.sicc.entidades.intsys;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.intsys.RelacionOperacionRECLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class RelacionOperacionRECLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public RelacionOperacionRECLocal create(Long codigoOperacion, Long codigoIVR) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_ORIV_SEQ");   
                RelacionOperacionRECLocal local = new RelacionOperacionRECLocal(oid, codigoOperacion, codigoIVR);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(RelacionOperacionRECLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(RelacionOperacionRECLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public RelacionOperacionRECLocal findByPrimaryKey(Long  oid) {
		RelacionOperacionRECLocal local = em.find(RelacionOperacionRECLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("RelacionOperacionRECLocal.FindAll");
		return query.getResultList();
	}

}
