package es.indra.sicc.entidades.intsys;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.intsys.MovimientoStockLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MovimientoStockLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public MovimientoStockLocal create(Long tmalOidTipoNegaAlma, Long paisOidPais, Long tmalOidTipoMoviAlma) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_IMSK_SEQ");   
		MovimientoStockLocal local = new MovimientoStockLocal(oid, tmalOidTipoNegaAlma, paisOidPais, tmalOidTipoMoviAlma);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MovimientoStockLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MovimientoStockLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MovimientoStockLocal findByPrimaryKey(Long  oid) {
		MovimientoStockLocal local = em.find(MovimientoStockLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("MovimientoStockLocal.FindAll");
		return query.getResultList();
	}

	public MovimientoStockLocal findByUK(Long param1) {
		Query query=em.createNamedQuery("MovimientoStockLocal.FindByUK");
		query.setParameter(1, param1);
		return (MovimientoStockLocal)(query.getSingleResult());
	}

}
