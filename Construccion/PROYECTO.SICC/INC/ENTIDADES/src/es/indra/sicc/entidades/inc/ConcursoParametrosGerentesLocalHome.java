package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ConcursoParametrosGerentesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ConcursoParametrosGerentesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ConcursoParametrosGerentesLocal create(Long copaOidParaGral, Long fcalOidFormCalc) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_COP2_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ConcursoParametrosGerentesLocal local = new ConcursoParametrosGerentesLocal(oid, copaOidParaGral, fcalOidFormCalc);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ConcursoParametrosGerentesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ConcursoParametrosGerentesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ConcursoParametrosGerentesLocal findByPrimaryKey(Long  oid) {
		ConcursoParametrosGerentesLocal local = (ConcursoParametrosGerentesLocal)em.find(ConcursoParametrosGerentesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ConcursoParametrosGerentesLocal.FindAll");
                    return query.getResultList();
            }

	public ConcursoParametrosGerentesLocal findByConcurso(Long concurso) {
		Query query=em.createNamedQuery("ConcursoParametrosGerentesLocal.FindByConcurso");
		
		query.setParameter(1, concurso);

		return (ConcursoParametrosGerentesLocal)(query.getSingleResult());
	}

}
