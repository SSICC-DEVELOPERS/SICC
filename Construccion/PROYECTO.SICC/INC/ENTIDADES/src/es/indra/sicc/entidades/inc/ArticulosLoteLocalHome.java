package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ArticulosLoteLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class ArticulosLoteLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ArticulosLoteLocal create(Boolean indDesp, BigDecimal impPrecPubl, Integer numUnid, String codVentFict, Long prodOidProd, Long lopaOidLotePremArti, Boolean indCentroServGar, String indTipoEntrega) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_ARLO_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ArticulosLoteLocal local = new ArticulosLoteLocal(oid, indDesp, impPrecPubl, numUnid, codVentFict, prodOidProd, lopaOidLotePremArti, indCentroServGar, indTipoEntrega);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ArticulosLoteLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ArticulosLoteLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ArticulosLoteLocal findByPrimaryKey(Long  oid) {
		ArticulosLoteLocal local = (ArticulosLoteLocal)em.find(ArticulosLoteLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ArticulosLoteLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByLotePremioArticulo(Long lotePremioArticulo) {
		Query query=em.createNamedQuery("ArticulosLoteLocal.FindByLotePremioArticulo");
		
		query.setParameter(1, lotePremioArticulo);

	    return query.getResultList();
	}

}
