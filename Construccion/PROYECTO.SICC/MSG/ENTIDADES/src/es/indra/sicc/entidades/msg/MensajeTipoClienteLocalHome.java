package es.indra.sicc.entidades.msg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.msg.MensajeTipoClienteLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MensajeTipoClienteLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-msg");
	private EntityManager em = emf.createEntityManager();

	public MensajeTipoClienteLocal create(Long mens_oid_mens, Long ticl_oid_tipo_clie) throws  MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("MSG_MSTC_SEQ");
		MensajeTipoClienteLocal local = new MensajeTipoClienteLocal(oid, mens_oid_mens, ticl_oid_tipo_clie);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MensajeTipoClienteLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MensajeTipoClienteLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MensajeTipoClienteLocal findByPrimaryKey(Long  oid) {
		MensajeTipoClienteLocal local = (MensajeTipoClienteLocal)em.find(MensajeTipoClienteLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByMensaje(Long param1) {
		Query query=em.createNamedQuery("MensajeTipoClienteLocal.FindByMensaje");
		
		query.setParameter(1, param1);

		return query.getResultList();
	}

}
