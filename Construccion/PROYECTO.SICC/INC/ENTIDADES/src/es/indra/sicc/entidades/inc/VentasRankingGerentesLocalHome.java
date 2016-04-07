package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.VentasRankingGerentesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class VentasRankingGerentesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public VentasRankingGerentesLocal create(Long zzonOidZona, Long copaOidParaGral, Long zsccOidSecc, Long zsgvOidSubgVent, Long clieOidClie, Long regiOidRegi) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_IVRG_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		VentasRankingGerentesLocal local = new VentasRankingGerentesLocal(oid, zzonOidZona, copaOidParaGral, zsccOidSecc, zsgvOidSubgVent, clieOidClie, regiOidRegi);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(VentasRankingGerentesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(VentasRankingGerentesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public VentasRankingGerentesLocal findByPrimaryKey(Long  oid) {
		VentasRankingGerentesLocal local = (VentasRankingGerentesLocal)em.find(VentasRankingGerentesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("VentasRankingGerentesLocal.FindAll");
                    return query.getResultList();
            }

	public VentasRankingGerentesLocal findByUK(Long zzonOidZona, Long copaOidParaGral, Long zsccOidSecc, Long zsgvOidSubgVent, Long clieOidClie, Long regiOidRegi) {
		Query query=em.createNamedQuery("VentasRankingGerentesLocal.FindByUK");
		
		query.setParameter(1, zzonOidZona);

		query.setParameter(2, copaOidParaGral);

		query.setParameter(3, zsccOidSecc);

		query.setParameter(4, zsgvOidSubgVent);

		query.setParameter(5, clieOidClie);

		query.setParameter(6, regiOidRegi);

		return (VentasRankingGerentesLocal)(query.getSingleResult());
	}

}
