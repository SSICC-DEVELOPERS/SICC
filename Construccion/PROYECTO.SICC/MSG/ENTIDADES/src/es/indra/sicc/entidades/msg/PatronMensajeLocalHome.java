package es.indra.sicc.entidades.msg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.msg.PatronMensajeLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PatronMensajeLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-msg");
	private EntityManager em = emf.createEntityManager();

	public PatronMensajeLocal create(Long pase_oid_patr_secc, Long mens_oid_mens, Integer num_orde_impr) throws MareException{
		final EntityTransaction et = em.getTransaction();
		et.begin();
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("MSG_PAME_SEQ");
		PatronMensajeLocal local = new PatronMensajeLocal(oid, pase_oid_patr_secc, mens_oid_mens, num_orde_impr);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PatronMensajeLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PatronMensajeLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PatronMensajeLocal findByPrimaryKey(Long  oid) {
		PatronMensajeLocal local = (PatronMensajeLocal)em.find(PatronMensajeLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findBySeccion(Long param1) {
		Query query=em.createNamedQuery("PatronMensajeLocal.FindBySeccion");
		
		query.setParameter(1, param1);

		return query.getResultList();
	}

}
