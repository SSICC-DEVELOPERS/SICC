package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.MultinivelLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MultinivelLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public MultinivelLocal create(Integer numPeriParaCalc, Integer numPeriSobrCalc, Integer numMiniReco, Boolean indActi, Long copaOidParaGral, Long perdOidPeri, Long perdOidPeriDesd, Long cpreOidCalcPrem)throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_MULT_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		MultinivelLocal local = new MultinivelLocal(oid, numPeriParaCalc, numPeriSobrCalc,  numMiniReco, indActi, copaOidParaGral, perdOidPeri, perdOidPeriDesd, cpreOidCalcPrem);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MultinivelLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MultinivelLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MultinivelLocal findByPrimaryKey(Long  oid) {
		MultinivelLocal local = (MultinivelLocal)em.find(MultinivelLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("MultinivelLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByConcurso(Long concurso) {
		Query query=em.createNamedQuery("MultinivelLocal.FindByConcurso");
		
		query.setParameter(1, concurso);

	    return query.getResultList();
	}

}
