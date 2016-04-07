package es.indra.sicc.entidades.rec;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.rec.ProductoNoRecogibleLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ProductoNoRecogibleLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-rec");
	private EntityManager em = emf.createEntityManager();

	public ProductoNoRecogibleLocal create(Long paisOidPais, Long canaOidCana, Long perdOidPeri, Long marcOidMarc, Long oidArticuloLote, Long oidDetalleOferta) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("REC_PNRE_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
                ProductoNoRecogibleLocal local = new ProductoNoRecogibleLocal(oid,  paisOidPais, canaOidCana, perdOidPeri, marcOidMarc, oidArticuloLote, oidDetalleOferta);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ProductoNoRecogibleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ProductoNoRecogibleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ProductoNoRecogibleLocal findByPrimaryKey(Long  oid) {
		ProductoNoRecogibleLocal local = (ProductoNoRecogibleLocal)em.find(ProductoNoRecogibleLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("ProductoNoRecogibleLocal.FindAll");
		
		return (query.getResultList());
	}

}
