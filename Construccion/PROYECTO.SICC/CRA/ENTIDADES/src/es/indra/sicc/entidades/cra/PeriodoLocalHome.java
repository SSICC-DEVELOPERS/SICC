package es.indra.sicc.entidades.cra;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Date;

public class PeriodoLocalHome	{

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cra");
	private EntityManager em = emf.createEntityManager();

	public PeriodoLocal create(Long cana_oid_cana, 
                         Long marc_oid_marc, Long pais_oid_pais, Long peri_oid_peri,
                         Date fec_inic, Date fec_fina, Boolean val_esta, 
                         String val_nomb_peri,  Long acce_oid_acce) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("CRA_PERD_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		PeriodoLocal local = new PeriodoLocal(oid, cana_oid_cana, marc_oid_marc, pais_oid_pais, peri_oid_peri,
                                                        fec_inic, fec_fina, val_esta, val_nomb_peri, acce_oid_acce);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PeriodoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PeriodoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PeriodoLocal findByPrimaryKey(Long  oid) {
		PeriodoLocal local = em.find(PeriodoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public PeriodoLocal findByUk(Long oidPeriodoCorporativo, Long oidMarca, Long oidPais, Long oidCanal) {
		Query query=em.createNamedQuery("PeriodoLocal.FindByUk");
		query.setParameter(1, oidPeriodoCorporativo);
		query.setParameter(2, oidMarca);
		query.setParameter(3, oidPais);
		query.setParameter(4, oidCanal);
		return (PeriodoLocal)(query.getSingleResult());
	}

}
