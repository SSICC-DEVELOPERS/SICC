package es.indra.sicc.entidades.cra;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cra.CronogramaGruposZonaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;

public class CronogramaGruposZonaLocalHome	{

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cra");
	private EntityManager em = emf.createEntityManager();

	public CronogramaGruposZonaLocal create(Long perd_oid_peri, Long cgzo_oid_cabe_grup_zona,
                                                Long cact_oid_acti, Long cod_tipo_fact, Boolean tipoDias, 
                                                Long fecha0, Timestamp fecha_Prev, Integer cod_vist) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("CRA_CRGZ_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		CronogramaGruposZonaLocal local = new CronogramaGruposZonaLocal(oid, perd_oid_peri, cgzo_oid_cabe_grup_zona,
                                    cact_oid_acti, cod_tipo_fact, tipoDias, 
                                    fecha0, fecha_Prev, cod_vist);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CronogramaGruposZonaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CronogramaGruposZonaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CronogramaGruposZonaLocal findByPrimaryKey(Long  oid) {
		CronogramaGruposZonaLocal local = em.find(CronogramaGruposZonaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
