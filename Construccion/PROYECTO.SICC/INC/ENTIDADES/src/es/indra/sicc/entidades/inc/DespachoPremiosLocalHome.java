package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.DespachoPremiosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class DespachoPremiosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public DespachoPremiosLocal create(Boolean indComuDespAuto, Boolean indComuDespManu, Long copaOidParaGral) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_DEPR_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		DespachoPremiosLocal local = new DespachoPremiosLocal(oid, indComuDespAuto, indComuDespManu, copaOidParaGral);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(DespachoPremiosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(DespachoPremiosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public DespachoPremiosLocal findByPrimaryKey(Long  oid) {
		DespachoPremiosLocal local = (DespachoPremiosLocal)em.find(DespachoPremiosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("DespachoPremiosLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByConcurso(Long concurso) {
		Query query=em.createNamedQuery("DespachoPremiosLocal.FindByConcurso");
		
		query.setParameter(1, concurso);

	    return query.getResultList();
	}

}
