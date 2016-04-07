package es.indra.sicc.entidades.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.fac.ControlCuponPagoLocal;
import es.indra.sicc.util.SecuenciadorOID;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;


public class ControlCuponPagoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-fac");
	private EntityManager em = emf.createEntityManager();

	public ControlCuponPagoLocal create(Long cliente, Date fechaGrabacion, Date fechaUltimoMovimiento, String estadoCuentaAnterior) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("FAC_CCPA_SEQ");
		ControlCuponPagoLocal local = new ControlCuponPagoLocal(oid, cliente, fechaGrabacion, fechaUltimoMovimiento, estadoCuentaAnterior);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ControlCuponPagoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ControlCuponPagoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ControlCuponPagoLocal findByPrimaryKey(Long  oid) {
		ControlCuponPagoLocal local = (ControlCuponPagoLocal)em.find(ControlCuponPagoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
