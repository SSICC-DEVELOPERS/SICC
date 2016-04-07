package es.indra.sicc.entidades.msg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.msg.TipoAsignacionDestinatarioLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoAsignacionDestinatarioLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-msg");
	private EntityManager em = emf.createEntityManager();

	public TipoAsignacionDestinatarioLocal create(Long ind_excl)throws  MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("MSG_TIDE_SEQ");
		TipoAsignacionDestinatarioLocal local = new TipoAsignacionDestinatarioLocal(oid, ind_excl);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoAsignacionDestinatarioLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoAsignacionDestinatarioLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoAsignacionDestinatarioLocal findByPrimaryKey(Long  oid) {
		TipoAsignacionDestinatarioLocal local = (TipoAsignacionDestinatarioLocal)em.find(TipoAsignacionDestinatarioLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
