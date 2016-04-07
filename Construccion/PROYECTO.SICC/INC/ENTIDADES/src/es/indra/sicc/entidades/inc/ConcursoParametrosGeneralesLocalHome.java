package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ConcursoParametrosGeneralesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ConcursoParametrosGeneralesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ConcursoParametrosGeneralesLocal create(Long oid, String numConc, Integer numVers, Long paisOidPais, String valNomb, Boolean indRank, Long perdOidPeriDesd, Long perdOidPeriHast, Long diriOidDiri, Long marcOidMarc, Long canaOidCana, Boolean indDuplaCyzone)  throws MareException {
                if (oid == null) {
	            oid = SecuenciadorOID.obtenerSiguienteValor("INC_COPA_SEQ");
	        }  
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ConcursoParametrosGeneralesLocal local = new ConcursoParametrosGeneralesLocal(oid, numConc, numVers, paisOidPais, valNomb, indRank, perdOidPeriDesd, perdOidPeriHast, diriOidDiri, marcOidMarc, canaOidCana, indDuplaCyzone);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ConcursoParametrosGeneralesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ConcursoParametrosGeneralesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ConcursoParametrosGeneralesLocal findByPrimaryKey(Long  oid) {
		ConcursoParametrosGeneralesLocal local = (ConcursoParametrosGeneralesLocal)em.find(ConcursoParametrosGeneralesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ConcursoParametrosGeneralesLocal.FindAll");
                    return query.getResultList();
            }

	public ConcursoParametrosGeneralesLocal findByCamposClave(String numeroConcurso, Integer version, Long pais) {
		Query query=em.createNamedQuery("ConcursoParametrosGeneralesLocal.FindByCamposClave");
		
		query.setParameter(1, numeroConcurso);

		query.setParameter(2, version);

		query.setParameter(3, pais);

		return (ConcursoParametrosGeneralesLocal)(query.getSingleResult());
	}

}
