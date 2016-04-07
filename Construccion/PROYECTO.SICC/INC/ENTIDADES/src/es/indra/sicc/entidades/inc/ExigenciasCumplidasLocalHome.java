package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ExigenciasCumplidasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ExigenciasCumplidasLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ExigenciasCumplidasLocal create(Boolean indExigCump, Long copaOidParaGral, Long clieOidClie, Long perdOidPeri) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_EXCU_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ExigenciasCumplidasLocal local = new ExigenciasCumplidasLocal(oid, indExigCump, copaOidParaGral, clieOidClie, perdOidPeri);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ExigenciasCumplidasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ExigenciasCumplidasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ExigenciasCumplidasLocal findByPrimaryKey(Long  oid) {
		ExigenciasCumplidasLocal local = (ExigenciasCumplidasLocal)em.find(ExigenciasCumplidasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ExigenciasCumplidasLocal.FindAll");
                    return query.getResultList();
            }

	public ExigenciasCumplidasLocal findByUK(Long consultora, Long concurso, Long Periodo) {
		Query query=em.createNamedQuery("ExigenciasCumplidasLocal.FindByUK");
		
		query.setParameter(1, consultora);

		query.setParameter(2, concurso);

		query.setParameter(3, Periodo);

		return (ExigenciasCumplidasLocal)(query.getSingleResult());
	}

	public Collection findByConcurso(Long oidConcurso) {
		Query query=em.createNamedQuery("ExigenciasCumplidasLocal.FindByConcurso");
		
		query.setParameter(1, oidConcurso);

	    return query.getResultList();
	}

}
