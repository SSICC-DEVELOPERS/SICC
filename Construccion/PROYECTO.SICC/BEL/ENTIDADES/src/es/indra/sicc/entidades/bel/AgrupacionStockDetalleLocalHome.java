package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.AgrupacionStockDetalleLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class AgrupacionStockDetalleLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public AgrupacionStockDetalleLocal create(Long agrupacionStockCabecera, Long estadoMercancia, Character operacion) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_AGSD_SEQ");
                AgrupacionStockDetalleLocal local = new AgrupacionStockDetalleLocal(oid, agrupacionStockCabecera, estadoMercancia, operacion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(AgrupacionStockDetalleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(AgrupacionStockDetalleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public AgrupacionStockDetalleLocal findByPrimaryKey(Long  oid) {
		AgrupacionStockDetalleLocal local = (AgrupacionStockDetalleLocal)em.find(AgrupacionStockDetalleLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByAgrupacionStockCabecera(Long agrupacionStockCabecera) {
		Query query=em.createNamedQuery("AgrupacionStockDetalleLocal.FindByAgrupacionStockCabecera");
		query.setParameter(1, agrupacionStockCabecera);
		return query.getResultList();
	}

}
