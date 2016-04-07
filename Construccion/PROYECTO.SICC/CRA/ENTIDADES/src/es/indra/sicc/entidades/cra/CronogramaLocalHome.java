package es.indra.sicc.entidades.cra;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cra.CronogramaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;
import java.sql.Timestamp;

public class CronogramaLocalHome	{

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cra");
	private EntityManager em = emf.createEntityManager();

	public CronogramaLocal create(Long perd_oid_peri, Long cact_oid_acti, Long cod_tipo_fact, 
                                        Timestamp fec_inic, Long zzon_oid_zona, Boolean indFija, 
                                        Boolean tipoDias, Long fecha0, Integer cod_vist) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("CRA_CRON_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		CronogramaLocal local = new CronogramaLocal(oid, perd_oid_peri, cact_oid_acti, cod_tipo_fact, 
                                                            fec_inic, zzon_oid_zona, indFija, 
                                                            tipoDias, fecha0, cod_vist);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CronogramaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CronogramaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CronogramaLocal findByPrimaryKey(Long  oid) {
		CronogramaLocal local = em.find(CronogramaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
