package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.TipoEstadoProcesoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoEstadoProcesoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();

	public TipoEstadoProcesoLocal create(String descripcion) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_TEPR_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		TipoEstadoProcesoLocal local = new TipoEstadoProcesoLocal(oid, descripcion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoEstadoProcesoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoEstadoProcesoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoEstadoProcesoLocal findByPrimaryKey(Long  oid) {
		TipoEstadoProcesoLocal local = (TipoEstadoProcesoLocal)em.find(TipoEstadoProcesoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
