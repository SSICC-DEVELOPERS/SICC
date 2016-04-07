package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ProductosExcluidosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ProductosExcluidosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ProductosExcluidosLocal create(Long prduOidProd) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PREX_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ProductosExcluidosLocal local = new ProductosExcluidosLocal(oid, prduOidProd);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ProductosExcluidosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ProductosExcluidosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ProductosExcluidosLocal findByPrimaryKey(Long  oid) {
		ProductosExcluidosLocal local = (ProductosExcluidosLocal)em.find(ProductosExcluidosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ProductosExcluidosLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByProducto(Long producto) {
		Query query=em.createNamedQuery("ProductosExcluidosLocal.FindByProducto");
		
		query.setParameter(1, producto);

	    return query.getResultList();
	}

}
