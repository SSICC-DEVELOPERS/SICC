package es.indra.sicc.entidades.msg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.msg.MensajeUnidadAdministrativaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MensajeUnidadAdministrativaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-msg");
	private EntityManager em = emf.createEntityManager();

	public MensajeUnidadAdministrativaLocal create(Long mens_oid_mens) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
	       Long oid = SecuenciadorOID.obtenerSiguienteValor("MSG_MSUA_SEQ");
		MensajeUnidadAdministrativaLocal local = new MensajeUnidadAdministrativaLocal(oid, mens_oid_mens);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MensajeUnidadAdministrativaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MensajeUnidadAdministrativaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MensajeUnidadAdministrativaLocal findByPrimaryKey(Long  oid) {
		MensajeUnidadAdministrativaLocal local = (MensajeUnidadAdministrativaLocal)em.find(MensajeUnidadAdministrativaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByMensaje(Long param1) {
		Query query=em.createNamedQuery("MensajeUnidadAdministrativaLocal.FindByMensaje");
		
		query.setParameter(1, param1);

		return query.getResultList();
	}

}
