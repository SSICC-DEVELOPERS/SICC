package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.PeriodosRefenciaPagoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PeriodosRefenciaPagoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();
    
	public PeriodosRefenciaPagoLocal create(Long perd_oid_peri, Long repi_oid_resu_pago_inte) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_PRDN_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		PeriodosRefenciaPagoLocal local = new PeriodosRefenciaPagoLocal(oid, perd_oid_peri, repi_oid_resu_pago_inte);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PeriodosRefenciaPagoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PeriodosRefenciaPagoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PeriodosRefenciaPagoLocal findByPrimaryKey(Long  oid) {
		PeriodosRefenciaPagoLocal local = (PeriodosRefenciaPagoLocal)em.find(PeriodosRefenciaPagoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
