package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ProductosCalificarLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ProductosCalificarLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ProductosCalificarLocal create(Long copaOidParaGral, Long maprOidMarcProd) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PRAC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ProductosCalificarLocal local = new ProductosCalificarLocal(oid, copaOidParaGral, maprOidMarcProd);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ProductosCalificarLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ProductosCalificarLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ProductosCalificarLocal findByPrimaryKey(Long  oid) {
		ProductosCalificarLocal local = (ProductosCalificarLocal)em.find(ProductosCalificarLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ProductosCalificarLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByConcurso(Long concurso) {
		Query query=em.createNamedQuery("ProductosCalificarLocal.FindByConcurso");
		
		query.setParameter(1, concurso);

	    return query.getResultList();
	}

}
