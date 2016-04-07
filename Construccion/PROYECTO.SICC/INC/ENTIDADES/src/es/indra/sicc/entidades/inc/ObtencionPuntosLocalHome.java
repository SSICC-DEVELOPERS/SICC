package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ObtencionPuntosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class ObtencionPuntosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ObtencionPuntosLocal create(BigDecimal valFactConv, Integer numPuntAsig, Boolean indComuObte, Long copaOidParaGral) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_OBPU_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ObtencionPuntosLocal local = new ObtencionPuntosLocal(oid, valFactConv, numPuntAsig, indComuObte, copaOidParaGral);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ObtencionPuntosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ObtencionPuntosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ObtencionPuntosLocal findByPrimaryKey(Long  oid) {
		ObtencionPuntosLocal local = (ObtencionPuntosLocal)em.find(ObtencionPuntosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ObtencionPuntosLocal.FindAll");
                    return query.getResultList();
            }

	public ObtencionPuntosLocal findByUK(Long copaOidParaGral) {
		Query query=em.createNamedQuery("ObtencionPuntosLocal.FindByUK");
		
		query.setParameter(1, copaOidParaGral);

		return (ObtencionPuntosLocal)(query.getSingleResult());
	}

}
