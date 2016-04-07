package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.PremioPuntosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class PremioPuntosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public PremioPuntosLocal create(Integer numPrem, Long panpOidParaNivePrem, Long tppuOidTipoPremPunt, Long copaOidParaGral) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PRPU_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		PremioPuntosLocal local = new PremioPuntosLocal(oid, numPrem, panpOidParaNivePrem, tppuOidTipoPremPunt, copaOidParaGral);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(PremioPuntosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(PremioPuntosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public PremioPuntosLocal findByPrimaryKey(Long  oid) {
		PremioPuntosLocal local = (PremioPuntosLocal)em.find(PremioPuntosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("PremioPuntosLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByParametroNivelPremiacion(Long nivelPremiacion) {
		Query query=em.createNamedQuery("PremioPuntosLocal.FindByParametroNivelPremiacion");
		
		query.setParameter(1, nivelPremiacion);

	    return query.getResultList();
	}

	public PremioPuntosLocal findByUK(Long oidParaNivePrem) {
		Query query=em.createNamedQuery("PremioPuntosLocal.FindByUK");
		
		query.setParameter(1, oidParaNivePrem);

		return (PremioPuntosLocal)(query.getSingleResult());
	}

}
