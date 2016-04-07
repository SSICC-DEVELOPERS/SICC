package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ArticulosPremiosConsueloLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ArticulosPremiosConsueloLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ArticulosPremiosConsueloLocal create(Long premioConsuelo, Long prodOidProd, Boolean indCentroServGar, String indTipoEntrega) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_ARPC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ArticulosPremiosConsueloLocal local = new ArticulosPremiosConsueloLocal(oid, premioConsuelo, prodOidProd, indCentroServGar, indTipoEntrega);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ArticulosPremiosConsueloLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ArticulosPremiosConsueloLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ArticulosPremiosConsueloLocal findByPrimaryKey(Long  oid) {
		ArticulosPremiosConsueloLocal local = (ArticulosPremiosConsueloLocal)em.find(ArticulosPremiosConsueloLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ArticulosPremiosConsueloLocal.FindAll");
                    return query.getResultList();
            }
}
