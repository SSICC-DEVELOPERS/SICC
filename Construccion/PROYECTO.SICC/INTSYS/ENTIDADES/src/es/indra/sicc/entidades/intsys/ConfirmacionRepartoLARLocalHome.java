package es.indra.sicc.entidades.intsys;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.intsys.ConfirmacionRepartoLARLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Date;

import java.util.Collection;

public class ConfirmacionRepartoLARLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public ConfirmacionRepartoLARLocal create(Integer numSecu, Date fecFact, String valChip, Date fecRepa, String valHoraRepa, Long zzonOidZona, Long tdreOidTipoDireRepa) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_ICRL_SEQ");   
		ConfirmacionRepartoLARLocal local = new ConfirmacionRepartoLARLocal(oid, numSecu, fecFact, valChip, fecRepa, valHoraRepa, zzonOidZona, tdreOidTipoDireRepa);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ConfirmacionRepartoLARLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ConfirmacionRepartoLARLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ConfirmacionRepartoLARLocal findByPrimaryKey(Long  oid) {
		ConfirmacionRepartoLARLocal local = em.find(ConfirmacionRepartoLARLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("ConfirmacionRepartoLARLocal.FindAll");
		return query.getResultList();
	}

}
