package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.DetalleDtoRecargoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

import java.sql.Date;

public class DetalleDtoRecargoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();
        
	public DetalleDtoRecargoLocal create(Long generadaSolicitudPedido, Long solicitud,
                                    Integer numeroLinea, Long cliente) throws MareException{
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_DDRF_SEQ");                                    
		final EntityTransaction et = em.getTransaction();
		et.begin();
		DetalleDtoRecargoLocal local = new DetalleDtoRecargoLocal(oid, generadaSolicitudPedido, solicitud,
                                 numeroLinea, cliente);
		em.persist(local);
		et.commit();
		return local;
	}
	
        public DetalleDtoRecargoLocal create(Long generadaSolicitudPedido, Long solicitud,
                                Long cabecera, Long historico, Integer numeroLinea, Long marca, 
                                Long cliente, Integer numeroDiasCalculados, BigDecimal importePago, 
                                BigDecimal importeLiquidacionCalculado, String observaciones, 
                                Date fechaDocumento, Date fechaVencimiento, Date fechaLiquidacion,
                                BigDecimal importeLiquidacionUsuario, Double importe, 
                                String referenciaDocumentoExterno) throws  MareException{
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_DDRF_SEQ");                                    
                final EntityTransaction et = em.getTransaction();
                et.begin();
                DetalleDtoRecargoLocal local = new DetalleDtoRecargoLocal(oid, generadaSolicitudPedido, solicitud,
                             cabecera, historico, numeroLinea, marca, 
                             cliente, numeroDiasCalculados, importePago, 
                             importeLiquidacionCalculado, observaciones, 
                             fechaDocumento, fechaVencimiento, fechaLiquidacion,
                             importeLiquidacionUsuario, importe, 
                             referenciaDocumentoExterno);
                em.persist(local);
                et.commit();
                return local;
        }
        
	public void remove(DetalleDtoRecargoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(DetalleDtoRecargoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public DetalleDtoRecargoLocal findByPrimaryKey(Long  oid) {
		DetalleDtoRecargoLocal local = (DetalleDtoRecargoLocal)em.find(DetalleDtoRecargoLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
