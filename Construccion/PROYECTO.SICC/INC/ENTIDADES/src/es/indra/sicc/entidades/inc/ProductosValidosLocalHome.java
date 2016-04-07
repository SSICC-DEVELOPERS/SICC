package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ProductosValidosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ProductosValidosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ProductosValidosLocal create(Long prduOidProd) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PRVA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ProductosValidosLocal local = new ProductosValidosLocal(oid, prduOidProd);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ProductosValidosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ProductosValidosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ProductosValidosLocal findByPrimaryKey(Long  oid) {
		ProductosValidosLocal local = (ProductosValidosLocal)em.find(ProductosValidosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ProductosValidosLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByProducto(Long producto) {
		Query query=em.createNamedQuery("ProductosValidosLocal.FindByProducto");
		
		query.setParameter(1, producto);

	    return query.getResultList();
	}

}
