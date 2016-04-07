package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.LotePremioArticulosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class LotePremioArticulosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public LotePremioArticulosLocal create(Integer numLote, Integer numPrem, Long prarOidPremArti) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_LOPA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		LotePremioArticulosLocal local = new LotePremioArticulosLocal(oid, numLote, numPrem, prarOidPremArti);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(LotePremioArticulosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(LotePremioArticulosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public LotePremioArticulosLocal findByPrimaryKey(Long  oid) {
		LotePremioArticulosLocal local = (LotePremioArticulosLocal)em.find(LotePremioArticulosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("LotePremioArticulosLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByLotePremioArticulo(Long premioArticulo) {
		Query query=em.createNamedQuery("LotePremioArticulosLocal.FindByLotePremioArticulo");
		
		query.setParameter(1, premioArticulo);

	    return query.getResultList();
	}

}
