package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.TipoDespachoMAVLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoDespachoMAVLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();

	public TipoDespachoMAVLocal create() throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_TDCH_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		TipoDespachoMAVLocal local = new TipoDespachoMAVLocal(oid);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoDespachoMAVLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoDespachoMAVLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoDespachoMAVLocal findByPrimaryKey(Long  oid) {
		TipoDespachoMAVLocal local = (TipoDespachoMAVLocal)em.find(TipoDespachoMAVLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
