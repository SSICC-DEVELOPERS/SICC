package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.PremioDescuentoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PremioDescuentoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public PremioDescuentoLocal create(Integer numPrem, Long oidParaNivePrem, Long perdOidPeriDesd, Long tdscOidTipoDesc) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PRDE_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		PremioDescuentoLocal local = new PremioDescuentoLocal(oid, numPrem, oidParaNivePrem, perdOidPeriDesd, tdscOidTipoDesc);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PremioDescuentoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PremioDescuentoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PremioDescuentoLocal findByPrimaryKey(Long  oid) {
		PremioDescuentoLocal local = (PremioDescuentoLocal)em.find(PremioDescuentoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("PremioDescuentoLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByParametroNivelPremiacion(Long nivelPremiacion) {
		Query query=em.createNamedQuery("PremioDescuentoLocal.FindByParametroNivelPremiacion");
		
		query.setParameter(1, nivelPremiacion);

	    return query.getResultList();
	}

	public PremioDescuentoLocal findByUK(Long oidParaNivePrem) {
		Query query=em.createNamedQuery("PremioDescuentoLocal.FindByUK");
		
		query.setParameter(1, oidParaNivePrem);

		return (PremioDescuentoLocal)(query.getSingleResult());
	}

}
