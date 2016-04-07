package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.RequisitosProgramaNuevasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class RequisitosProgramaNuevasLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public RequisitosProgramaNuevasLocal create(Integer numPedi, BigDecimal valExigMini, Long prnuOidProgNuev) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_REPN_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		RequisitosProgramaNuevasLocal local = new RequisitosProgramaNuevasLocal(oid, numPedi, valExigMini, prnuOidProgNuev);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(RequisitosProgramaNuevasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(RequisitosProgramaNuevasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public RequisitosProgramaNuevasLocal findByPrimaryKey(Long  oid) {
		RequisitosProgramaNuevasLocal local = (RequisitosProgramaNuevasLocal)em.find(RequisitosProgramaNuevasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("RequisitosProgramaNuevasLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByProgramaNuevas(Long programaNuevas) {
		Query query=em.createNamedQuery("RequisitosProgramaNuevasLocal.FindByProgramaNuevas");
		
		query.setParameter(1, programaNuevas);

	    return query.getResultList();
	}

}
