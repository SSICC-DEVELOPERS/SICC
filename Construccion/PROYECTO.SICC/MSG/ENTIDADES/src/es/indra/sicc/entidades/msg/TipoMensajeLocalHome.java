package es.indra.sicc.entidades.msg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.msg.TipoMensajeLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoMensajeLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-msg");
	private EntityManager em = emf.createEntityManager();

	public TipoMensajeLocal create(String newCodigoTipoMensaje)throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MSG_TMEN_SEQ");
		TipoMensajeLocal local = new TipoMensajeLocal(oid, newCodigoTipoMensaje);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoMensajeLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoMensajeLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoMensajeLocal findByPrimaryKey(Long  oid) {
		TipoMensajeLocal local = (TipoMensajeLocal)em.find(TipoMensajeLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
