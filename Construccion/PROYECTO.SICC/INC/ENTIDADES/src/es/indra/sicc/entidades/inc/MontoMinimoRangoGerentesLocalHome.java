package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.MontoMinimoRangoGerentesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class MontoMinimoRangoGerentesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public MontoMinimoRangoGerentesLocal create(BigDecimal impMontoMinim, Long clpcOidClasPartCali) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_MMRG_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		MontoMinimoRangoGerentesLocal local = new MontoMinimoRangoGerentesLocal(oid, impMontoMinim, clpcOidClasPartCali);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MontoMinimoRangoGerentesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MontoMinimoRangoGerentesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MontoMinimoRangoGerentesLocal findByPrimaryKey(Long  oid) {
		MontoMinimoRangoGerentesLocal local = (MontoMinimoRangoGerentesLocal)em.find(MontoMinimoRangoGerentesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("AccesoLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByParticipanteCalificacion(Long partCalific) {
		Query query=em.createNamedQuery("MontoMinimoRangoGerentesLocal.FindByParticipanteCalificacion");
		
		query.setParameter(1, partCalific);

	    return query.getResultList();
	}

}
