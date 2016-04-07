package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.PremioMonetarioLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PremioMonetarioLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public PremioMonetarioLocal create(Integer numPrem, Long moneOidMone, Long panpOidParaNivePrem, Long tpmoOidTipoPremMone, Long fpagOidFormPago) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PRMO_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		PremioMonetarioLocal local = new PremioMonetarioLocal(oid, numPrem, moneOidMone, panpOidParaNivePrem, tpmoOidTipoPremMone, fpagOidFormPago);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PremioMonetarioLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PremioMonetarioLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PremioMonetarioLocal findByPrimaryKey(Long  oid) {
		PremioMonetarioLocal local = (PremioMonetarioLocal)em.find(PremioMonetarioLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("PremioMonetarioLocal.FindAll");
                    return query.getResultList();
            }
            
	public Collection findByParametroNivelPremiacion(Long nivelPremiacion) {
		Query query=em.createNamedQuery("PremioMonetarioLocal.FindByParametroNivelPremiacion");
		
		query.setParameter(1, nivelPremiacion);

	    return query.getResultList();
	}

	public PremioMonetarioLocal findByUK(Long oidParaNivePrem) {
		Query query=em.createNamedQuery("PremioMonetarioLocal.FindByUK");
		
		query.setParameter(1, oidParaNivePrem);

		return (PremioMonetarioLocal)(query.getSingleResult());
	}

}
