package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ResultadosRankingLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ResultadosRankingLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ResultadosRankingLocal create(Long copaOidParaGral, Long perdOidPeri, Long clieOidClie, Long resultado) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_RERA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ResultadosRankingLocal local = new ResultadosRankingLocal(oid, copaOidParaGral, perdOidPeri, clieOidClie, resultado);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ResultadosRankingLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ResultadosRankingLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ResultadosRankingLocal findByPrimaryKey(Long  oid) {
		ResultadosRankingLocal local = (ResultadosRankingLocal)em.find(ResultadosRankingLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ResultadosRankingLocal.FindAll");
                    return query.getResultList();
            }

}
