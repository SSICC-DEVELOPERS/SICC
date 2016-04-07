package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.DetalleCuponesTramiteDepuracionLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.math.BigDecimal;

import java.sql.Date;

public class DetalleCuponesTramiteDepuracionLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();

   	public DetalleCuponesTramiteDepuracionLocal create(Long cliente, Long movimientoCC, 
                                                            Long movimientoBanc, BigDecimal importe, 
                                                            Long cc, Date fechaDigitacion, 
                                                            Long cabeceraCuponesTramiteDepuracion, 
                                                            Long empresa) throws MareException{
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_DCTD_SEQ");                                                            
		final EntityTransaction et = em.getTransaction();
		et.begin();
		DetalleCuponesTramiteDepuracionLocal local = new DetalleCuponesTramiteDepuracionLocal(oid, cliente, 
                                                         movimientoCC, movimientoBanc, importe, 
                                                         cc, fechaDigitacion, cabeceraCuponesTramiteDepuracion, 
                                                         empresa);
		em.persist(local);
		et.commit();
		return local;
	}

        public DetalleCuponesTramiteDepuracionLocal create(Long cliente, Long movimientoCC, 
                                                    Long movimientoBanc, BigDecimal importe, 
                                                    Long cc, Date fechaDigitacion, 
                                                    Long cabeceraCuponesTramiteDepuracion, 
                                                    Long empresa, Long periodo, 
                                                    Integer numeroLinea, Date fechaDocumento, 
                                                    String referenciaExterna, String observaciones, 
                                                    Long situacion, Integer numeroCupon, 
                                                    Date fechaMovimientoBancario, 
                                                    Long banco) throws MareException{
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_DCTD_SEQ");                                                            
                final EntityTransaction et = em.getTransaction();
                et.begin();
                DetalleCuponesTramiteDepuracionLocal local = new DetalleCuponesTramiteDepuracionLocal(oid, cliente, 
                                                 movimientoCC, movimientoBanc,  importe,  cc, 
                                                 fechaDigitacion, cabeceraCuponesTramiteDepuracion, empresa, 
                                                 periodo, numeroLinea, fechaDocumento, referenciaExterna, 
                                                 observaciones, situacion, numeroCupon, 
                                                 fechaMovimientoBancario, 
                                                 banco);
                em.persist(local);
                et.commit();
                return local;
        }
    
	public void remove(DetalleCuponesTramiteDepuracionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(DetalleCuponesTramiteDepuracionLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public DetalleCuponesTramiteDepuracionLocal findByPrimaryKey(Long  oid) {
		DetalleCuponesTramiteDepuracionLocal local = (DetalleCuponesTramiteDepuracionLocal)em.find(DetalleCuponesTramiteDepuracionLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
}
