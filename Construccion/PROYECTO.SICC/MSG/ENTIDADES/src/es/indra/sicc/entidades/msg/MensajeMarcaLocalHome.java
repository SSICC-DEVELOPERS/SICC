package es.indra.sicc.entidades.msg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.msg.MensajeMarcaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MensajeMarcaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-msg");
	private EntityManager em = emf.createEntityManager();

	public MensajeMarcaLocal create(Long marc_oid_marc, Long mens_oid_mens) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("MSG_MSMA_SEQ");
		MensajeMarcaLocal local = new MensajeMarcaLocal(oid, marc_oid_marc, mens_oid_mens);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MensajeMarcaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MensajeMarcaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MensajeMarcaLocal findByPrimaryKey(Long  oid) {
		MensajeMarcaLocal local = (MensajeMarcaLocal)em.find(MensajeMarcaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByMensajeM(Long param1) {
		Query query=em.createNamedQuery("MensajeMarcaLocal.FindByMensajeM");
		
		query.setParameter(1, param1);

		return query.getResultList();
	}

}
