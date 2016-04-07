package es.indra.sicc.entidades.rep;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rep.GenReporLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;

public class GenReporLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rep");
	private EntityManager em = emf.createEntityManager();

	public GenReporLocal create(String codProc, String valUsua, Timestamp fecRepo, String valModu, Long rrepOidRepo, String valExt) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("GEN_REPO_SEQ");
		GenReporLocal local = new GenReporLocal(oid, codProc, valUsua, fecRepo, valModu, rrepOidRepo, valExt);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(GenReporLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(GenReporLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public GenReporLocal findByPrimaryKey(java.lang.Long  oid) {
		GenReporLocal local = (GenReporLocal)em.find(GenReporLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("GenReporLocal.FindAll");
		return (query.getResultList());
	}

	public Collection findByCodProc(java.lang.String param1) {
		Query query=em.createNamedQuery("GenReporLocal.FindByCodProc");
		query.setParameter(1, param1);
		return (query.getResultList());
	}

}