package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.VariablesVentaRankingConcursoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class VariablesVentaRankingConcursoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public VariablesVentaRankingConcursoLocal create(Long valPeso, Long valDivi, Long oidConcurso, Long oidVariVentRank, Boolean aplicable) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_VVRC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		VariablesVentaRankingConcursoLocal local = new VariablesVentaRankingConcursoLocal(oid, valPeso, valDivi, oidConcurso, oidVariVentRank, aplicable);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(VariablesVentaRankingConcursoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(VariablesVentaRankingConcursoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public VariablesVentaRankingConcursoLocal findByPrimaryKey(Long  oid) {
		VariablesVentaRankingConcursoLocal local = (VariablesVentaRankingConcursoLocal)em.find(VariablesVentaRankingConcursoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("VariablesVentaRankingConcursoLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByConcurso(Long oidConcurso) {
		Query query=em.createNamedQuery("VariablesVentaRankingConcursoLocal.FindByConcurso");
		
		query.setParameter(1, oidConcurso);

	    return query.getResultList();
	}

}
