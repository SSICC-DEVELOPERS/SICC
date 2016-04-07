package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ProductoDescuentoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ProductoDescuentoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ProductoDescuentoLocal create(Long maprOidMarcProd, Long prdeOidPremDesc) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PRDE_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ProductoDescuentoLocal local = new ProductoDescuentoLocal(oid, maprOidMarcProd, prdeOidPremDesc);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ProductoDescuentoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ProductoDescuentoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ProductoDescuentoLocal findByPrimaryKey(Long  oid) {
		ProductoDescuentoLocal local = (ProductoDescuentoLocal)em.find(ProductoDescuentoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query = em.createNamedQuery("ProductoDescuentoLocal.FindAll");
		return query.getResultList();
	}

	public Collection findByPremioDescuento(Long premioDescuento) {
		Query query=em.createNamedQuery("ProductoDescuentoLocal.FindByPremioDescuento");
		
		query.setParameter(1, premioDescuento);

		return query.getResultList();
	}

}
