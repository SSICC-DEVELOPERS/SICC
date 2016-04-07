package es.indra.sicc.entidades.intsys;


import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.intsys.ModoEjecucionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ModoEjecucionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public ModoEjecucionLocal create(Long oidModoEjec, String descModoEjec) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_CMEJ_SEQ");
		ModoEjecucionLocal local = new ModoEjecucionLocal(oid, oidModoEjec, descModoEjec);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ModoEjecucionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ModoEjecucionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ModoEjecucionLocal findByPrimaryKey(Long  oid) {
		ModoEjecucionLocal local = em.find(ModoEjecucionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("ModoEjecucionLocal.FindAll");
		return query.getResultList();
	}

}
