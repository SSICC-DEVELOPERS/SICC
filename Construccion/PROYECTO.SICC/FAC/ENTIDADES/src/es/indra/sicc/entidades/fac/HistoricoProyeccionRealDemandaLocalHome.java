package es.indra.sicc.entidades.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.fac.HistoricoProyeccionRealDemandaLocal;
import es.indra.sicc.util.SecuenciadorOID;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class HistoricoProyeccionRealDemandaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-fac");
	private EntityManager em = emf.createEntityManager();

	public HistoricoProyeccionRealDemandaLocal create(Long pais, Long periodo, Long zona, Long producto, Integer pedidosEstimadosMarketingZona, Integer pedidosFacturadosZonas, BigDecimal proyeccionParcialProductoZona, BigDecimal pupProductoZona, BigDecimal pupCampanya, Boolean cierreZona, Boolean cierreCampanya) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("FAC_HPRD_SEQ");
		HistoricoProyeccionRealDemandaLocal local = new HistoricoProyeccionRealDemandaLocal(oid, pais, periodo, zona, producto, pedidosEstimadosMarketingZona, pedidosFacturadosZonas, proyeccionParcialProductoZona, pupProductoZona, pupCampanya, cierreZona, cierreCampanya);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(HistoricoProyeccionRealDemandaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(HistoricoProyeccionRealDemandaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public HistoricoProyeccionRealDemandaLocal findByPrimaryKey(Long  oid) {
		HistoricoProyeccionRealDemandaLocal local = (HistoricoProyeccionRealDemandaLocal)em.find(HistoricoProyeccionRealDemandaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
