package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.AccesoConcursoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class AccesoConcursoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public AccesoConcursoLocal create(Long copaOidParaGral, Long acceOidAcce) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_ACC2_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		AccesoConcursoLocal local = new AccesoConcursoLocal(oid, copaOidParaGral, acceOidAcce);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(AccesoConcursoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(AccesoConcursoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public AccesoConcursoLocal findByPrimaryKey(Long  oid) {
		AccesoConcursoLocal local = (AccesoConcursoLocal)em.find(AccesoConcursoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("AccesoConcursoLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByConcurso(Long concurso) {
		Query query=em.createNamedQuery("AccesoConcursoLocal.FindByConcurso");
		
		query.setParameter(1, concurso);

	    return query.getResultList();
	}

}
