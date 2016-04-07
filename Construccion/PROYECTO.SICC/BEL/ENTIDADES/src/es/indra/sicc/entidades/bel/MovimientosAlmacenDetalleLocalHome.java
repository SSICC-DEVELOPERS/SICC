package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.MovimientosAlmacenDetalleLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

public class MovimientosAlmacenDetalleLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public MovimientosAlmacenDetalleLocal create(Long movimientoAlmacenCabecera, Integer numeroLinea, Long cantidad, Long tipoMovimientoAlmacen, Long producto, Long operacionReferencia, Long almacenSalida, Long numeroMovimiento) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_MADE_SEQ");
                MovimientosAlmacenDetalleLocal local = new MovimientosAlmacenDetalleLocal(oid, movimientoAlmacenCabecera, numeroLinea, cantidad, tipoMovimientoAlmacen, producto, operacionReferencia, almacenSalida, numeroMovimiento);
		em.persist(local);
		et.commit();
		return local;
	}
	
        public MovimientosAlmacenDetalleLocal create(Long movimientoAlmacenCabecera, Integer numeroLinea, Long cantidad, Long tipoMovimientoAlmacen, Long producto, Long operacionReferencia, Long almacenSalida, BigDecimal precioVentaNeto, BigDecimal precioContable, Long numeroDocumentoReferencia, Integer numeroPosicionReferencia, Long almacenEntrada, Long numeroMovimiento, Long tipoOferta) throws MareException {
                final EntityTransaction et = em.getTransaction();
                et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_MADE_SEQ");
                MovimientosAlmacenDetalleLocal local = new MovimientosAlmacenDetalleLocal(oid, movimientoAlmacenCabecera, numeroLinea, cantidad, tipoMovimientoAlmacen, producto, operacionReferencia, almacenSalida, precioVentaNeto, precioContable, numeroDocumentoReferencia, numeroPosicionReferencia, almacenEntrada, numeroMovimiento, tipoOferta);
                em.persist(local);
                et.commit();
                return local;
        }


	public void remove(MovimientosAlmacenDetalleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MovimientosAlmacenDetalleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MovimientosAlmacenDetalleLocal findByPrimaryKey(Long  oid) {
		MovimientosAlmacenDetalleLocal local = (MovimientosAlmacenDetalleLocal)em.find(MovimientosAlmacenDetalleLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public MovimientosAlmacenDetalleLocal findByOperacion(Long param1,Long param2) {
		Query query=em.createNamedQuery("MovimientosAlmacenDetalleLocal.FindByOperacion");
		query.setParameter(1, param1);
		query.setParameter(2, param2);
		return (MovimientosAlmacenDetalleLocal)(query.getSingleResult());
	}

	public MovimientosAlmacenDetalleLocal findByOperacionNumLinea(Long param1,Integer param2,Long param3) {
		Query query=em.createNamedQuery("MovimientosAlmacenDetalleLocal.FindByOperacionNumLinea");
		query.setParameter(1, param1);
		query.setParameter(2, param2);
		query.setParameter(3, param3);
		return (MovimientosAlmacenDetalleLocal)(query.getSingleResult());
	}

}
