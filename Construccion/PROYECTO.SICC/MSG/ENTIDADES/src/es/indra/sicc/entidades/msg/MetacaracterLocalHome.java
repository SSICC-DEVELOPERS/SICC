package es.indra.sicc.entidades.msg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.msg.MetacaracterLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MetacaracterLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-msg");
	private EntityManager em = emf.createEntityManager();

	public MetacaracterLocal create(Long cod_meta, String val_lite_iden, String val_esta, Long time_oid_tipo) throws  MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("MSG_METC_SEQ");
		MetacaracterLocal local = new MetacaracterLocal(oid, cod_meta,  val_lite_iden,  val_esta,  time_oid_tipo);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MetacaracterLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MetacaracterLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MetacaracterLocal findByPrimaryKey(Long  oid) {
		MetacaracterLocal local = (MetacaracterLocal)em.find(MetacaracterLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
