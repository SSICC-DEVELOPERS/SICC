package es.indra.sicc.entidades.bel;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.bel.MovimientosDeCajaDetalleLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

import java.sql.Timestamp;

public class MovimientosDeCajaDetalleLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-bel");
	private EntityManager em = emf.createEntityManager();

	public MovimientosDeCajaDetalleLocal create(Long movimientoDeCajaCabecera, Long medioPagoBelcenter, Integer numeroLinea, Long tipoMovimientoCaja) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_MCAD_SEQ");
                MovimientosDeCajaDetalleLocal local = new MovimientosDeCajaDetalleLocal(oid, movimientoDeCajaCabecera, medioPagoBelcenter, numeroLinea, tipoMovimientoCaja);
		em.persist(local);
		et.commit();
		return local;
	}

        public MovimientosDeCajaDetalleLocal create(Long movimientoDeCajaCabecera, Long medioPagoBelcenter, Integer numeroLinea, Long tipoMovimientoCaja, BigDecimal importe, BigDecimal diferenciaVuelto, BigDecimal importeDivisa, String numeroCheque, String numeroTarjeta, String numeroValeCompra, Long tipoTarjeta, Long monedaAlternativa, Timestamp fecha) throws MareException {
                final EntityTransaction et = em.getTransaction();
                et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("BEL_MCAD_SEQ");
                MovimientosDeCajaDetalleLocal local = new MovimientosDeCajaDetalleLocal(oid, movimientoDeCajaCabecera, medioPagoBelcenter, numeroLinea, tipoMovimientoCaja, importe, diferenciaVuelto, importeDivisa, numeroCheque, numeroTarjeta, numeroValeCompra, tipoTarjeta, monedaAlternativa, fecha);
                em.persist(local);
                et.commit();
                return local;
        }
        
        
	
	public void remove(MovimientosDeCajaDetalleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MovimientosDeCajaDetalleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MovimientosDeCajaDetalleLocal findByPrimaryKey(Long  oid) {
		MovimientosDeCajaDetalleLocal local = (MovimientosDeCajaDetalleLocal)em.find(MovimientosDeCajaDetalleLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
