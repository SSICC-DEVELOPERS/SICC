package es.indra.sicc.entidades.intsys;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.intsys.RecepcionVentasAsociadasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Date;

public class RecepcionVentasAsociadasLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public RecepcionVentasAsociadasLocal create(Long numeroLote, Date fechaOrdenInternet, Long consultora, Long canal, Long marca, Long sociedad) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_IRVA_SEQ");
		RecepcionVentasAsociadasLocal local = new RecepcionVentasAsociadasLocal(oid, numeroLote, fechaOrdenInternet, consultora, canal, marca, sociedad);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(RecepcionVentasAsociadasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(RecepcionVentasAsociadasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public RecepcionVentasAsociadasLocal findByPrimaryKey(Long  oid) {
		RecepcionVentasAsociadasLocal local = em.find(RecepcionVentasAsociadasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("RecepcionVentasAsociadasLocal.FindAll");
		return query.getResultList();
	}

	public RecepcionVentasAsociadasLocal findByUK(Long consultora,Long numeroLote) {
		Query query=em.createNamedQuery("RecepcionVentasAsociadasLocal.FindByUK");
		query.setParameter(1, consultora);
		query.setParameter(2, numeroLote);
		return (RecepcionVentasAsociadasLocal)(query.getSingleResult());
	}

}
