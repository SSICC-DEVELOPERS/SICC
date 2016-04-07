package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ConcursoVariablesVentaGerentesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ConcursoVariablesVentaGerentesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ConcursoVariablesVentaGerentesLocal create(Long copaOidParaGral) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_CVVG_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ConcursoVariablesVentaGerentesLocal local = new ConcursoVariablesVentaGerentesLocal(oid, copaOidParaGral);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ConcursoVariablesVentaGerentesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ConcursoVariablesVentaGerentesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ConcursoVariablesVentaGerentesLocal findByPrimaryKey(Long  oid) {
		ConcursoVariablesVentaGerentesLocal local = (ConcursoVariablesVentaGerentesLocal)em.find(ConcursoVariablesVentaGerentesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ConcursoVariablesVentaGerentesLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByConcurso(Long concurso) {
		Query query=em.createNamedQuery("ConcursoVariablesVentaGerentesLocal.FindByConcurso");
		
		query.setParameter(1, concurso);

	    return query.getResultList();
	}

}
