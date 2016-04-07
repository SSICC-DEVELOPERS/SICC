package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ClasificacionParticipantesConcursoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ClasificacionParticipantesConcursoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ClasificacionParticipantesConcursoLocal create(Long copaOidParaGral, Long paciOidPartConcCabe) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_CLPC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ClasificacionParticipantesConcursoLocal local = new ClasificacionParticipantesConcursoLocal(oid, copaOidParaGral, paciOidPartConcCabe);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ClasificacionParticipantesConcursoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ClasificacionParticipantesConcursoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ClasificacionParticipantesConcursoLocal findByPrimaryKey(Long  oid) {
		ClasificacionParticipantesConcursoLocal local = (ClasificacionParticipantesConcursoLocal)em.find(ClasificacionParticipantesConcursoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ClasificacionParticipantesConcursoLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByConcurso(Long concurso) {
		Query query=em.createNamedQuery("ClasificacionParticipantesConcursoLocal.FindByConcurso");
		
		query.setParameter(1, concurso);

	    return query.getResultList();
	}

}
