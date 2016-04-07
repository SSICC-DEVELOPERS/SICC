package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ProductosExigidosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class ProductosExigidosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ProductosExigidosLocal create(Integer numUnidExig, BigDecimal impMontExig, Integer numPuntExig, Long perdOidPeriHast, Long perdOidPeriDesd, Long prduOidProd) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PREX_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ProductosExigidosLocal local = new ProductosExigidosLocal(oid, numUnidExig, impMontExig, numPuntExig, perdOidPeriHast, perdOidPeriDesd, prduOidProd);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ProductosExigidosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ProductosExigidosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ProductosExigidosLocal findByPrimaryKey(Long  oid) {
		ProductosExigidosLocal local = (ProductosExigidosLocal)em.find(ProductosExigidosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ProductosExigidosLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByProducto(Long producto) {
		Query query=em.createNamedQuery("ProductosExigidosLocal.FindByProducto");
		
		query.setParameter(1, producto);

	    return query.getResultList();
	}

}
