package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.MontoMinimoRangoConsultorasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class MontoMinimoRangoConsultorasLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public MontoMinimoRangoConsultorasLocal create(BigDecimal impMontMini, Long esveOidEstaVent, Long clpcOidClasPartCali) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_MMRC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		MontoMinimoRangoConsultorasLocal local = new MontoMinimoRangoConsultorasLocal(oid, impMontMini, esveOidEstaVent, clpcOidClasPartCali);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MontoMinimoRangoConsultorasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MontoMinimoRangoConsultorasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MontoMinimoRangoConsultorasLocal findByPrimaryKey(Long  oid) {
		MontoMinimoRangoConsultorasLocal local = (MontoMinimoRangoConsultorasLocal)em.find(MontoMinimoRangoConsultorasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                    Query query = em.createNamedQuery("MontoMinimoRangoConsultorasLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByParticipanteCalificacion(Long partCalific) {
		Query query=em.createNamedQuery("MontoMinimoRangoConsultorasLocal.FindByParticipanteCalificacion");
		
		query.setParameter(1, partCalific);

	    return query.getResultList();
	}

}
