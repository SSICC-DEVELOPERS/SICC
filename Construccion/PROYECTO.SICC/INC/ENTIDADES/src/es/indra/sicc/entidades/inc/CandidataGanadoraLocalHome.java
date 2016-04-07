package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.CandidataGanadoraLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class CandidataGanadoraLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public CandidataGanadoraLocal create(Boolean indMetaSupe, Boolean valRequPremSupe, Long perdOidPeri, Long copaOidParaGral, Long clieOidClie) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_CAGA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		CandidataGanadoraLocal local = new CandidataGanadoraLocal(oid, indMetaSupe, valRequPremSupe, perdOidPeri, copaOidParaGral, clieOidClie);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(CandidataGanadoraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CandidataGanadoraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CandidataGanadoraLocal findByPrimaryKey(Long  oid) {
		CandidataGanadoraLocal local = (CandidataGanadoraLocal)em.find(CandidataGanadoraLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                    Query query = em.createNamedQuery("CandidataGanadoraLocal.FindAll");
                    return query.getResultList();
            }

	public CandidataGanadoraLocal findByUK(Long oidConcurso,Long oidCliente,Long oidPeriodo) {
		Query query=em.createNamedQuery("CandidataGanadoraLocal.FindByUK");
		
		query.setParameter(1, oidConcurso);

		query.setParameter(2, oidCliente);

		query.setParameter(3, oidPeriodo);

		return (CandidataGanadoraLocal)(query.getSingleResult());
	}

	public Collection findByConcurso(Long oidConcurso) {
		Query query=em.createNamedQuery("CandidataGanadoraLocal.FindByConcurso");
		
		query.setParameter(1, oidConcurso);

	    return query.getResultList();
	}

}
