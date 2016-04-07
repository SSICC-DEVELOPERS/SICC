package es.indra.sicc.entidades.msg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.msg.MensajeCodigoVentaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MensajeCodigoVentaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-msg");
	private EntityManager em = emf.createEntityManager();

	public MensajeCodigoVentaLocal create(Long mens_oid_mens, String val_codi_vent) throws  MareException{
		final EntityTransaction et = em.getTransaction();
		et.begin();
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("MSG_MSCV_SEQ");
		MensajeCodigoVentaLocal local = new MensajeCodigoVentaLocal(oid,  mens_oid_mens,  val_codi_vent);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MensajeCodigoVentaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MensajeCodigoVentaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MensajeCodigoVentaLocal findByPrimaryKey(Long  oid) {
		MensajeCodigoVentaLocal local = (MensajeCodigoVentaLocal)em.find(MensajeCodigoVentaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByMensaje(Long param1) {
		Query query=em.createNamedQuery("MensajeCodigoVentaLocal.FindByMensaje");
		
		query.setParameter(1, param1);

		return query.getResultList();
	}

}
