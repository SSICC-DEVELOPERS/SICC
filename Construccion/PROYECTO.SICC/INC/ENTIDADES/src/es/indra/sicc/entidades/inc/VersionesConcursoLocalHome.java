package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.VersionesConcursoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class VersionesConcursoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public VersionesConcursoLocal create(Integer valVersNuev, String numConc, Long perdOidPeri, Long copaOidParaGralOrig, Long esc2OidEstaConc, Long vigenciaConcurso) throws MareException {        
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_VECO_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		VersionesConcursoLocal local = new VersionesConcursoLocal(oid, valVersNuev, numConc, perdOidPeri, copaOidParaGralOrig, esc2OidEstaConc, vigenciaConcurso);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(VersionesConcursoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(VersionesConcursoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public VersionesConcursoLocal findByPrimaryKey(Long  oid) {
		VersionesConcursoLocal local = (VersionesConcursoLocal)em.find(VersionesConcursoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("VersionesConcursoLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByConcurso(Long oidConcurso) {
		Query query=em.createNamedQuery("VersionesConcursoLocal.FindByConcurso");
		
		query.setParameter(1, oidConcurso);

	    return query.getResultList();
	}

	public VersionesConcursoLocal findByConcursoVersion(Long oidConcurso, Integer version) {
		Query query=em.createNamedQuery("VersionesConcursoLocal.FindByConcursoVersion");
		
		query.setParameter(1, oidConcurso);

		query.setParameter(2, version);

		return (VersionesConcursoLocal)(query.getSingleResult());
	}

}
