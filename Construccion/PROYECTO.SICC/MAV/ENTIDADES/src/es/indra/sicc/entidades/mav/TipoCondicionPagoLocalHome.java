package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.TipoCondicionPagoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoCondicionPagoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();

	public TipoCondicionPagoLocal create(String descripcion) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_TCPA_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		TipoCondicionPagoLocal local = new TipoCondicionPagoLocal(oid, descripcion);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoCondicionPagoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoCondicionPagoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoCondicionPagoLocal findByPrimaryKey(Long  oid) {
		TipoCondicionPagoLocal local = (TipoCondicionPagoLocal)em.find(TipoCondicionPagoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
