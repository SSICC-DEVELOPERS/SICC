package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ParametrosRankingLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ParametrosRankingLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ParametrosRankingLocal create(Long oidConcurso, Long oidPeri, Long oidPeriPrem, Long oidTipoRank, Long agraOidAgruRank) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PARA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ParametrosRankingLocal local = new ParametrosRankingLocal(oid, oidConcurso, oidPeri, oidPeriPrem, oidTipoRank, agraOidAgruRank);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametrosRankingLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametrosRankingLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametrosRankingLocal findByPrimaryKey(Long  oid) {
		ParametrosRankingLocal local = (ParametrosRankingLocal)em.find(ParametrosRankingLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                    Query query = em.createNamedQuery("ParametrosRankingLocal.FindAll");
                    return query.getResultList();
            }

	public ParametrosRankingLocal findByUK(Long oidConcurso) {
		Query query=em.createNamedQuery("ParametrosRankingLocal.FindByUK");
		
		query.setParameter(1, oidConcurso);

		return (ParametrosRankingLocal)(query.getSingleResult());
	}

}
