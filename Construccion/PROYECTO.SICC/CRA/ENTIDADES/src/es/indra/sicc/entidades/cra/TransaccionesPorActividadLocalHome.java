package es.indra.sicc.entidades.cra;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cra.TransaccionesPorActividadLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.util.Date;

public class TransaccionesPorActividadLocalHome	{

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cra");
	private EntityManager em = emf.createEntityManager();

	public TransaccionesPorActividadLocal create(Long oidTran, Long cact_oid_acti, Date fec_tran_acti) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CRA_TRAC_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
		TransaccionesPorActividadLocal local = new TransaccionesPorActividadLocal(oid, oidTran, cact_oid_acti, fec_tran_acti);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TransaccionesPorActividadLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TransaccionesPorActividadLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TransaccionesPorActividadLocal findByPrimaryKey(Long  oid) {
		TransaccionesPorActividadLocal local = em.find(TransaccionesPorActividadLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
