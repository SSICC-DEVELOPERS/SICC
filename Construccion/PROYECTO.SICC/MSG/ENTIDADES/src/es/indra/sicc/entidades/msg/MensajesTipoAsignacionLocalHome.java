package es.indra.sicc.entidades.msg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.msg.MensajesTipoAsignacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MensajesTipoAsignacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-msg");
	private EntityManager em = emf.createEntityManager();

	public MensajesTipoAsignacionLocal create(Long mens_oid_mens, Long tide_oid_tipo_dest) throws  MareException{
		final EntityTransaction et = em.getTransaction();
		et.begin();
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("MSG_MSTD_SEQ");
		MensajesTipoAsignacionLocal local = new MensajesTipoAsignacionLocal(oid, mens_oid_mens, tide_oid_tipo_dest);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MensajesTipoAsignacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MensajesTipoAsignacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MensajesTipoAsignacionLocal findByPrimaryKey(Long  oid) {
		MensajesTipoAsignacionLocal local = (MensajesTipoAsignacionLocal)em.find(MensajesTipoAsignacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByTipo(Long param1,Long param2) {
		Query query=em.createNamedQuery("MensajesTipoAsignacionLocal.FindByTipo");
		
		query.setParameter(1, param1);

		query.setParameter(2, param2);

		return query.getResultList();
	}

	public Collection findByMensaje(Long param1) {
		Query query=em.createNamedQuery("MensajesTipoAsignacionLocal.FindByMensaje");
		
		query.setParameter(1, param1);

		return query.getResultList();
	}

}
