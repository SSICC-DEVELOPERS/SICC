package es.indra.sicc.entidades.cra;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cra.HistoricoMatrizDiasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;
import java.sql.Timestamp;


public class HistoricoMatrizDiasLocalHome	{

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cra");
	private EntityManager em = emf.createEntityManager();

	public HistoricoMatrizDiasLocal create(Long cgzo_oid_cabe_grup_zona, Long cact_oid_acti,
                                        Long num_dias_refe, Timestamp fec_hist) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CRA_HMDI_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
		HistoricoMatrizDiasLocal local = new HistoricoMatrizDiasLocal(oid, cgzo_oid_cabe_grup_zona, cact_oid_acti,
                                                                                num_dias_refe, fec_hist);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(HistoricoMatrizDiasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(HistoricoMatrizDiasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public HistoricoMatrizDiasLocal findByPrimaryKey(Long  oid) {
		HistoricoMatrizDiasLocal local = em.find(HistoricoMatrizDiasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
