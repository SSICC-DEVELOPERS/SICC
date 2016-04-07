package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.StockLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class StockLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public StockLocal create(Long almacen, Long estadoMercancia, Long producto, Long saldo) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_STCK_SEQ");
                StockLocal local = new StockLocal(oid, almacen, estadoMercancia, producto, saldo);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(StockLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(StockLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public StockLocal findByPrimaryKey(Long  oid) {
		StockLocal local = (StockLocal)em.find(StockLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public StockLocal findByClaveUnica(Long almacen,Long estadoMercancia,Long preducto) {
		Query query=em.createNamedQuery("StockLocal.FindByClaveUnica");
		query.setParameter(1, almacen);
		query.setParameter(2, estadoMercancia);
		query.setParameter(3, preducto);
		return (StockLocal)(query.getSingleResult());
	}

}
