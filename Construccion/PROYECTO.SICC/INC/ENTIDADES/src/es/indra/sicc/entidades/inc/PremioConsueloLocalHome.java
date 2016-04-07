package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.PremioConsueloLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PremioConsueloLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public PremioConsueloLocal create(Long numUnid, Long mopcOidMotiPremCons, Long enviOidEnvi, Boolean valDesp) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PRCO_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		PremioConsueloLocal local = new PremioConsueloLocal(oid, numUnid, mopcOidMotiPremCons, enviOidEnvi, valDesp);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PremioConsueloLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PremioConsueloLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PremioConsueloLocal findByPrimaryKey(Long  oid) {
		PremioConsueloLocal local = (PremioConsueloLocal)em.find(PremioConsueloLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("PremioConsueloLocal.FindAll");
                    return query.getResultList();
            }
}
