package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.ProductosExcluidosCalificacionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ProductosExcluidosCalificacionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public ProductosExcluidosCalificacionLocal create(Long copaOidParaGral, Long maprOidMarcProd, Long oidPeri, Long oidPeriHasta) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_PRE2_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		ProductosExcluidosCalificacionLocal local = new ProductosExcluidosCalificacionLocal(oid, copaOidParaGral, maprOidMarcProd, oidPeri, oidPeriHasta);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ProductosExcluidosCalificacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ProductosExcluidosCalificacionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ProductosExcluidosCalificacionLocal findByPrimaryKey(Long  oid) {
		ProductosExcluidosCalificacionLocal local = (ProductosExcluidosCalificacionLocal)em.find(ProductosExcluidosCalificacionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
    public Collection findAll() {
                    Query query = em.createNamedQuery("ProductosExcluidosCalificacionLocal.FindAll");
                    return query.getResultList();
            }

	public Collection findByConcurso(Long concurso) {
		Query query=em.createNamedQuery("ProductosExcluidosCalificacionLocal.FindByConcurso");
		
		query.setParameter(1, concurso);

	    return query.getResultList();
	}

}
