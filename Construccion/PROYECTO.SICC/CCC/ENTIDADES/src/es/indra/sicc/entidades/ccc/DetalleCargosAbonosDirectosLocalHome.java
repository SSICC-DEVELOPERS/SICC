package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.DetalleCargosAbonosDirectosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

import java.sql.Date;

import java.util.Collection;

public class DetalleCargosAbonosDirectosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();
            
	public DetalleCargosAbonosDirectosLocal create(Long cabecera, Integer numeroLinea,
                                                        String codigoUsuario, Long empresa, 
                                                        Long tipoAbonoSubproceso) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_DCAD_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		DetalleCargosAbonosDirectosLocal local = new DetalleCargosAbonosDirectosLocal(oid, cabecera, numeroLinea,
                                                     codigoUsuario, empresa, 
                                                     tipoAbonoSubproceso);
		em.persist(local);
		et.commit();
		return local;
	}

        public DetalleCargosAbonosDirectosLocal create(Long cabecera, Long consultora, 
                                    Integer numeroLinea, Integer numeroHistoriaGenera, 
                                    Date fechaMovimiento, BigDecimal importeMoneda, 
                                    BigDecimal importe, String referenciaNumeroDocumento, 
                                    String observaciones, String glosaContable, Long moneda, 
                                    Long movimientoBancario, Long medioPago, Long cuotaAnterior, 
                                    Long cuotaNueva, Long movimiento, Long cuentaCorriente, 
                                    Date fechaPagoEnBancos, String codigoUsuario, 
                                    Long empresa, Long tipoAbonoSubproceso) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_DCAD_SEQ");
                final EntityTransaction et = em.getTransaction();
                et.begin();
                DetalleCargosAbonosDirectosLocal local = new DetalleCargosAbonosDirectosLocal(oid, cabecera, consultora, 
                                                                     numeroLinea, numeroHistoriaGenera, 
                                                                     fechaMovimiento, importeMoneda, 
                                                                     importe, referenciaNumeroDocumento, 
                                                                     observaciones, glosaContable, moneda, 
                                                                     movimientoBancario, medioPago, cuotaAnterior, 
                                                                     cuotaNueva, movimiento,  cuentaCorriente, 
                                                                     fechaPagoEnBancos, codigoUsuario, 
                                                                     empresa, tipoAbonoSubproceso);
                em.persist(local);
                et.commit();
                return local;
        }
    
        public DetalleCargosAbonosDirectosLocal create(Long cabecera, Integer numeroLinea, 
                                        Long cuotaAnterior, Long cuotaNueva, String codigoUsuario,
                                        Long empresa, Long tipoAbonoSubproceso) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_DCAD_SEQ");
                final EntityTransaction et = em.getTransaction();
                et.begin();
                DetalleCargosAbonosDirectosLocal local = new DetalleCargosAbonosDirectosLocal(oid, cabecera, numeroLinea, 
                                                         cuotaAnterior, cuotaNueva, codigoUsuario,
                                                         empresa, tipoAbonoSubproceso);
                em.persist(local);
                et.commit();
                return local;
        }    
        
	public void remove(DetalleCargosAbonosDirectosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(DetalleCargosAbonosDirectosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public DetalleCargosAbonosDirectosLocal findByPrimaryKey(Long  oid) {
		DetalleCargosAbonosDirectosLocal local = (DetalleCargosAbonosDirectosLocal)em.find(DetalleCargosAbonosDirectosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByTipoAbonoSubproceso(Long oidTipoAbonoSubproceso) {
		Query query=em.createNamedQuery("DetalleCargosAbonosDirectosLocal.FindByTipoAbonoSubproceso");
		
		query.setParameter(1, oidTipoAbonoSubproceso);

		return query.getResultList();
	}

	public Collection findByMovCC(Long oidMovCC) {
		Query query=em.createNamedQuery("DetalleCargosAbonosDirectosLocal.FindByMovCC");
		
		query.setParameter(1, oidMovCC);

		return query.getResultList();
	}

}
