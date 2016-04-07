package es.indra.sicc.entidades.intsys;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.intsys.TipoDireccionRepartoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoDireccionRepartoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public TipoDireccionRepartoLocal create() throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_TDRE_SEQ");
		TipoDireccionRepartoLocal local = new TipoDireccionRepartoLocal(oid);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoDireccionRepartoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoDireccionRepartoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoDireccionRepartoLocal findByPrimaryKey(Long  oid) {
		TipoDireccionRepartoLocal local = em.find(TipoDireccionRepartoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("TipoDireccionRepartoLocal.FindAll");
		return query.getResultList();
	}

	public TipoDireccionRepartoLocal findByUk(String param1) {
		Query query=em.createNamedQuery("TipoDireccionRepartoLocal.FindByUk");
		
		query.setParameter(1, param1);

		return (TipoDireccionRepartoLocal)(query.getSingleResult());
	}

}
