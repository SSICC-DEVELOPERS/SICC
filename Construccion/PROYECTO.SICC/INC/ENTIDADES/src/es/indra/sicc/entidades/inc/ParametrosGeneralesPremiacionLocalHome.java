package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ParametrosGeneralesPremiacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ParametrosGeneralesPremiacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ParametrosGeneralesPremiacionLocal create(Integer numNive, Boolean indComu, Long copaOidParaGral) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PAGP_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ParametrosGeneralesPremiacionLocal local = new ParametrosGeneralesPremiacionLocal(oid, numNive, indComu, copaOidParaGral);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ParametrosGeneralesPremiacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ParametrosGeneralesPremiacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ParametrosGeneralesPremiacionLocal findByPrimaryKey(Long  oid) {
		ParametrosGeneralesPremiacionLocal local = (ParametrosGeneralesPremiacionLocal)em.find(ParametrosGeneralesPremiacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ParametrosGeneralesPremiacionLocal.FindAll");
                    return query.getResultList();
            }

	public ParametrosGeneralesPremiacionLocal findByUK(Long oidConcurso) {
		Query query=em.createNamedQuery("ParametrosGeneralesPremiacionLocal.FindByUK");
		
		query.setParameter(1, oidConcurso);

	    return (ParametrosGeneralesPremiacionLocal)(query.getSingleResult());
	}

}
