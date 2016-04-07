package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.PremioArticuloLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PremioArticuloLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public PremioArticuloLocal create(Integer numUnid, Long panpOidParaNivePrem) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PRAR_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		PremioArticuloLocal local = new PremioArticuloLocal(oid, numUnid, panpOidParaNivePrem);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PremioArticuloLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PremioArticuloLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PremioArticuloLocal findByPrimaryKey(Long  oid) {
		PremioArticuloLocal local = (PremioArticuloLocal)em.find(PremioArticuloLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("PremioArticuloLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByParametroNivelPremiacion(Long nivelPremiacion) {
		Query query=em.createNamedQuery("PremioArticuloLocal.FindByParametroNivelPremiacion");
		
		query.setParameter(1, nivelPremiacion);

	    return query.getResultList();
	}

	public PremioArticuloLocal findByUK(Long oidParaNivePrem) {
		Query query=em.createNamedQuery("PremioArticuloLocal.FindByUK");
		
		query.setParameter(1, oidParaNivePrem);

		return (PremioArticuloLocal)(query.getSingleResult());
	}

}
