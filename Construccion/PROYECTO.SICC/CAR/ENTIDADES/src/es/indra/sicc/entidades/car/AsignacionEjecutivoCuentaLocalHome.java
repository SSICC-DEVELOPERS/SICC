package es.indra.sicc.entidades.car;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.car.AsignacionEjecutivoCuentaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class AsignacionEjecutivoCuentaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-car");
	private EntityManager em = emf.createEntityManager();

	public AsignacionEjecutivoCuentaLocal create(Long niri_oid_nive_ries, Long zsgv_oid_subg_vent, Long zorg_oid_regi, Long zzon_oid_zona, Long ejcu_oid_ejec_cuen) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CAR_ASEC_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		AsignacionEjecutivoCuentaLocal local = new AsignacionEjecutivoCuentaLocal(oid,niri_oid_nive_ries, zsgv_oid_subg_vent, zorg_oid_regi, zzon_oid_zona, ejcu_oid_ejec_cuen);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(AsignacionEjecutivoCuentaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(AsignacionEjecutivoCuentaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public AsignacionEjecutivoCuentaLocal findByPrimaryKey(Long  oid) {
		AsignacionEjecutivoCuentaLocal local = (AsignacionEjecutivoCuentaLocal)em.find(AsignacionEjecutivoCuentaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByEjecutivo(Long oidEjecutivo) {
		Query query=em.createNamedQuery("AsignacionEjecutivoCuentaLocal.FindByEjecutivo");
		
		query.setParameter(1, oidEjecutivo);

                return query.getResultList();
	}

	public Collection findBySBGRegZon(Long oidSGV, Long oidReg, Long oidZon) {
		Query query=em.createNamedQuery("AsignacionEjecutivoCuentaLocal.FindBySBGRegZon");
		
		query.setParameter(1, oidSGV);

		query.setParameter(2, oidReg);

		query.setParameter(3, oidZon);

                return query.getResultList();
	}

	public Collection findAll() {
            Query query=em.createNamedQuery("AsignacionEjecutivoCuentaLocal.FindAll");		
	    return query.getResultList();
	}
        
}
