package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ProductosBonificadosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ProductosBonificadosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ProductosBonificadosLocal create(Integer numPuntUnid, Integer valFactMult, Long perdOidPeriDesd, Long perdOidPeriHast, Long prduOidProd) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PRBO_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ProductosBonificadosLocal local = new ProductosBonificadosLocal(oid, numPuntUnid, valFactMult, perdOidPeriDesd, perdOidPeriHast, prduOidProd);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ProductosBonificadosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ProductosBonificadosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ProductosBonificadosLocal findByPrimaryKey(Long  oid) {
		ProductosBonificadosLocal local = (ProductosBonificadosLocal)em.find(ProductosBonificadosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ProductosBonificadosLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByProducto(Long producto) {
		Query query=em.createNamedQuery("ProductosBonificadosLocal.FindByProducto");
		
		query.setParameter(1, producto);

	    return query.getResultList();
	}

}
