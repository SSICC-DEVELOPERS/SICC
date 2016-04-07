package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ClasificacionParticipantesCalificacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ClasificacionParticipantesCalificacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ClasificacionParticipantesCalificacionLocal create(Long copaOidParaGral, Long paciOidPartConcCabe) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_CLPC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ClasificacionParticipantesCalificacionLocal local = new ClasificacionParticipantesCalificacionLocal(oid, copaOidParaGral, paciOidPartConcCabe);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ClasificacionParticipantesCalificacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ClasificacionParticipantesCalificacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ClasificacionParticipantesCalificacionLocal findByPrimaryKey(Long  oid) {
		ClasificacionParticipantesCalificacionLocal local = (ClasificacionParticipantesCalificacionLocal)em.find(ClasificacionParticipantesCalificacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ClasificacionParticipantesCalificacionLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByConcurso(Long concurso) {
		Query query=em.createNamedQuery("ClasificacionParticipantesCalificacionLocal.FindByConcurso");
		
		query.setParameter(1, concurso);

	    return query.getResultList();
	}

}
