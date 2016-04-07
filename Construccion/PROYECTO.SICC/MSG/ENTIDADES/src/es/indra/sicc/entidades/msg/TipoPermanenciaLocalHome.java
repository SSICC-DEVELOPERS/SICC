package es.indra.sicc.entidades.msg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.msg.TipoPermanenciaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoPermanenciaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-msg");
	private EntityManager em = emf.createEntityManager();

	public TipoPermanenciaLocal create(String cod_tipo_perm)throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("MSG_TPER_SEQ");
		TipoPermanenciaLocal local = new TipoPermanenciaLocal(oid, cod_tipo_perm);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoPermanenciaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoPermanenciaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoPermanenciaLocal findByPrimaryKey(Long  oid) {
		TipoPermanenciaLocal local = (TipoPermanenciaLocal)em.find(TipoPermanenciaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
