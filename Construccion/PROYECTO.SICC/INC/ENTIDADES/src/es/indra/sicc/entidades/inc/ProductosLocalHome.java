package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ProductosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ProductosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ProductosLocal create(Long copaOidParaGral) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PRDU_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ProductosLocal local = new ProductosLocal(oid, copaOidParaGral);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ProductosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ProductosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ProductosLocal findByPrimaryKey(Long  oid) {
		ProductosLocal local = (ProductosLocal)em.find(ProductosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                    Query query = em.createNamedQuery("ProductosLocal.FindAll");
                    return query.getResultList();
            }

	public ProductosLocal findByUK(Long oidConcurso) {
		Query query=em.createNamedQuery("ProductosLocal.FindByUK");
		
		query.setParameter(1, oidConcurso);

		return (ProductosLocal)(query.getSingleResult());
	}

}
