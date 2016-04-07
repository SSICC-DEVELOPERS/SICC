package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ProductosExigidosPremiacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ProductosExigidosPremiacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ProductosExigidosPremiacionLocal create(Long reprOidRequPrem, Long maprOidMarcProd) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PRE2_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ProductosExigidosPremiacionLocal local = new ProductosExigidosPremiacionLocal(oid, reprOidRequPrem, maprOidMarcProd);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ProductosExigidosPremiacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ProductosExigidosPremiacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ProductosExigidosPremiacionLocal findByPrimaryKey(Long  oid) {
		ProductosExigidosPremiacionLocal local = (ProductosExigidosPremiacionLocal)em.find(ProductosExigidosPremiacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ProductosExigidosPremiacionLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByRequisito(Long oidRequisitosPremiacion) {
		Query query=em.createNamedQuery("ProductosExigidosPremiacionLocal.FindByRequisito");
		
		query.setParameter(1, oidRequisitosPremiacion);

	    return query.getResultList();
	}

}
