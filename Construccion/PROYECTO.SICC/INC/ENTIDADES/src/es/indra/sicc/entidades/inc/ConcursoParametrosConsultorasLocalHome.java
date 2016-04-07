package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ConcursoParametrosConsultorasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ConcursoParametrosConsultorasLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ConcursoParametrosConsultorasLocal create(Long copaOidParaGral) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_COPC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ConcursoParametrosConsultorasLocal local = new ConcursoParametrosConsultorasLocal(oid, copaOidParaGral);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ConcursoParametrosConsultorasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ConcursoParametrosConsultorasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ConcursoParametrosConsultorasLocal findByPrimaryKey(Long  oid) {
		ConcursoParametrosConsultorasLocal local = (ConcursoParametrosConsultorasLocal)em.find(ConcursoParametrosConsultorasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ConcursoParametrosConsultorasLocal.FindAll");
                    return query.getResultList();
            }

	public ConcursoParametrosConsultorasLocal findByUK(Long oidConcurso) {
		Query query=em.createNamedQuery("ConcursoParametrosConsultorasLocal.FindByUK");
		
		query.setParameter(1, oidConcurso);

		return (ConcursoParametrosConsultorasLocal)(query.getSingleResult());
	}

	public Collection findByConcurso(Long concurso) {
		Query query=em.createNamedQuery("ConcursoParametrosConsultorasLocal.FindByConcurso");
		
		query.setParameter(1, concurso);

	    return query.getResultList();
	}

}
