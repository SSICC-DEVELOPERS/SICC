package es.indra.sicc.entidades.mae;	

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mae.AccionesProcesosBloqueoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class AccionesProcesosBloqueoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mae");
	private EntityManager em = emf.createEntityManager();

	public AccionesProcesosBloqueoLocal create(Long oidTipoBloqueo, Long oidProcesoBloqueo, Long oidAccionBloqueo, Long oidPais) throws MareException {
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("MAE_MPBL_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		AccionesProcesosBloqueoLocal local = new AccionesProcesosBloqueoLocal(oid, oidTipoBloqueo, oidProcesoBloqueo, oidAccionBloqueo, oidPais);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(AccionesProcesosBloqueoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(AccionesProcesosBloqueoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public AccionesProcesosBloqueoLocal findByPrimaryKey(Long  oid) {
		AccionesProcesosBloqueoLocal local = em.find(AccionesProcesosBloqueoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("AccionesProcesosBloqueoLocal.FindAll");
		return query.getResultList();
	}

}
