package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.HistoricoMovimientosCCLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

import java.sql.Date;
import java.sql.Timestamp;

public class HistoricoMovimientosCCLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();

	public HistoricoMovimientosCCLocal create(Long subproceso, Long tipoAbono,
                                Integer numeroHistoria, Timestamp fechaMovimiento, 
                                Date fechaVencimiento, Double importe, Double importePagado,
                                Long cuentaContable, Long tipoCliente, Long marcaSituacion, 
                                Long moneda, Long consultora, Double importePendiente, 
                                Long movimiento, Date fechaDocumento) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_HMCC_SEQ");                                
		final EntityTransaction et = em.getTransaction();
		et.begin();
		HistoricoMovimientosCCLocal local = new HistoricoMovimientosCCLocal(oid, subproceso, tipoAbono,
                             numeroHistoria, fechaMovimiento, 
                             fechaVencimiento, importe, importePagado,
                             cuentaContable, tipoCliente, marcaSituacion, 
                             moneda, consultora, importePendiente, 
                             movimiento, fechaDocumento);
		em.persist(local);
		et.commit();
		return local;
	}        
        
        public HistoricoMovimientosCCLocal create(Long subproceso, Long tipoAbono, 
                        Integer numeroHistoria, String refNumDocExt, Timestamp fechaMovimiento, 
                        Date fechaVencimiento, Date fechaValor, Double importe, Double importePagado,
                        Double impPendiente, Double impDivisa, Double impPagDiv, String ultDocMesSerie,
                        String ultDocAnyo, Integer ultDocNum, String numLoteContab, Date fechaContab, 
                        String observs, Long cuentaContable, Long tipoCliente, Long marcaSituacion, 
                        Long moneda, Long medioPagoTeorico, Long consultora, BigDecimal tipoCambio, 
                        String usuario, BigDecimal importePago, BigDecimal importeMovimiento, 
                        BigDecimal importeMovimientoDivisa, Long movimiento, Date fechaDocumento, 
                        Boolean indicaDescuentoRecargo) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_HMCC_SEQ");                                
                final EntityTransaction et = em.getTransaction();
                et.begin();
                HistoricoMovimientosCCLocal local = new HistoricoMovimientosCCLocal(oid, subproceso, tipoAbono, 
                     numeroHistoria, refNumDocExt, fechaMovimiento, 
                     fechaVencimiento, fechaValor, importe, importePagado,
                     impPendiente, impDivisa, impPagDiv, ultDocMesSerie,
                     ultDocAnyo, ultDocNum, numLoteContab, fechaContab, 
                     observs, cuentaContable, tipoCliente, marcaSituacion, 
                     moneda, medioPagoTeorico, consultora, tipoCambio, 
                     usuario, importePago, importeMovimiento, 
                     importeMovimientoDivisa, movimiento, fechaDocumento, 
                     indicaDescuentoRecargo);
                em.persist(local);
                et.commit();
                return local;
        }    
            
	public void remove(HistoricoMovimientosCCLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(HistoricoMovimientosCCLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public HistoricoMovimientosCCLocal findByPrimaryKey(Long  oid) {
		HistoricoMovimientosCCLocal local = (HistoricoMovimientosCCLocal)em.find(HistoricoMovimientosCCLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public HistoricoMovimientosCCLocal findByUK(Long oidMovimiento,Integer numeroHistoria) {
		Query query=em.createNamedQuery("HistoricoMovimientosCCLocal.FindByUK");
		
		query.setParameter(1, oidMovimiento);

		query.setParameter(2, numeroHistoria);

		return (HistoricoMovimientosCCLocal)(query.getSingleResult());
	}

}
