package es.indra.sicc.entidades.cra;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cra.MensajesCRALocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Date;

public class MensajesCRALocalHome	{

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cra");
	private EntityManager em = emf.createEntityManager();

	public MensajesCRALocal create(Long clie_oid_clie, Long zona,
                          Long num_mens, Date fec_mens,
                          Long actividad, Long periodo) throws MareException {
		Long oid = SecuenciadorOID.obtenerSiguienteValor("CRA_MECR_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		MensajesCRALocal local = new MensajesCRALocal(oid, clie_oid_clie, zona,
                                                            num_mens, fec_mens, actividad, periodo);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MensajesCRALocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MensajesCRALocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MensajesCRALocal findByPrimaryKey(Long  oid) {
		MensajesCRALocal local = em.find(MensajesCRALocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
	
	public Collection findByPeriodo(Long oidPeriodo) {
		Query query=em.createNamedQuery("MensajesCRALocal.FindByPeriodo");
		query.setParameter(1, oidPeriodo);
		return query.getResultList();
	}

}
