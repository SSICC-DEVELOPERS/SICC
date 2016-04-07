package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.MovimientosAlmacenCabeceraLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;

public class MovimientosAlmacenCabeceraLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public MovimientosAlmacenCabeceraLocal create(Long pais, Long subacceso, Timestamp fecha, Long periodo, Long numeroMovimiento) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_MVAL_SEQ");
                MovimientosAlmacenCabeceraLocal local = new MovimientosAlmacenCabeceraLocal(oid, pais, subacceso, fecha, periodo, numeroMovimiento);
		em.persist(local);
		et.commit();
		return local;
	}
        
    
	public MovimientosAlmacenCabeceraLocal create(Long pais, Long subacceso, Timestamp fecha, Long periodo, String numeroDocumento, String observaciones, Long almacenEntrada, Long almacenSalida, Long tipoMovimientoAlmacen, Long numeroMovimiento) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_MVAL_SEQ");
                MovimientosAlmacenCabeceraLocal local = new MovimientosAlmacenCabeceraLocal(oid, pais, subacceso, fecha, periodo, numeroDocumento, observaciones, almacenEntrada, almacenSalida, tipoMovimientoAlmacen, numeroMovimiento);
		em.persist(local);
		et.commit();
		return local;
	}	
        
	public void remove(MovimientosAlmacenCabeceraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MovimientosAlmacenCabeceraLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MovimientosAlmacenCabeceraLocal findByPrimaryKey(Long  oid) {
		MovimientosAlmacenCabeceraLocal local = (MovimientosAlmacenCabeceraLocal)em.find(MovimientosAlmacenCabeceraLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public MovimientosAlmacenCabeceraLocal findByUK(Long pais,Long nMov, Long subacceso) {
		Query query=em.createNamedQuery("MovimientosAlmacenCabeceraLocal.FindByUK");
		query.setParameter(1, pais);
		query.setParameter(2, nMov);
		query.setParameter(3, subacceso);
		return (MovimientosAlmacenCabeceraLocal)(query.getSingleResult());
	}

}
