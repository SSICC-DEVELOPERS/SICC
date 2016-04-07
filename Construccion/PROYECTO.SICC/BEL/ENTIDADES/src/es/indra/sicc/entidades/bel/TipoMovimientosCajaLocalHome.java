package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.TipoMovimientosCajaLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoMovimientosCajaLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public TipoMovimientosCajaLocal create(String descripcion, String signo, Character indicador) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_TMVC_SEQ");
                TipoMovimientosCajaLocal local = new TipoMovimientosCajaLocal(oid, descripcion, signo, indicador);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoMovimientosCajaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoMovimientosCajaLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoMovimientosCajaLocal findByPrimaryKey(Long  oid) {
		TipoMovimientosCajaLocal local = (TipoMovimientosCajaLocal)em.find(TipoMovimientosCajaLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
