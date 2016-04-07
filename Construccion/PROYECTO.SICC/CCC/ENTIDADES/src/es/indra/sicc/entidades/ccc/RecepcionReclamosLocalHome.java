package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.RecepcionReclamosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Date;
import java.sql.Timestamp;

public class RecepcionReclamosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();

	public RecepcionReclamosLocal create(Integer numero, String anio, String periodoMes, 
                                Long consultoraReclamante, String usuaSolicitante, Long empresa, 
                                Long periodoReclamante, Timestamp fechaDocumento,Double importeReclamado,
                                Long situacReclam, Long canal, Date fechaValor, Long pais)
                                        throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_RERE_SEQ");                                        
		final EntityTransaction et = em.getTransaction();
		et.begin();
		RecepcionReclamosLocal local = new RecepcionReclamosLocal(oid, numero, anio, periodoMes, 
                                                 consultoraReclamante, usuaSolicitante, empresa, 
                                                 periodoReclamante, fechaDocumento, importeReclamado,
                                                 situacReclam, canal, fechaValor, pais);
		em.persist(local);
		et.commit();
		return local;
	}
        
        public RecepcionReclamosLocal create(Integer numero, String anio, String periodoMes, Long consultoraReclamante,
                                 Long cargoAbono, String usuaSolicitante, String observClienteReclam, 
                                 String observAreaReclamo, Date fecResolPrevista, Timestamp fecResolReal,
                                 String fichDocumAdjunto, String usuGestorPrev, String usuGestorReal, 
                                 String observacionesResolucion, Long subacceso, Long empresa, Long cuenta, 
                                 Long movimientoCC, Long medioPago, Long motivosRechazo, Long periodoReclamante,
                                 Timestamp fechaDocumento, Double importeReclamado, Long situacReclam, Long canal,
                                 Long acceso, Date fechaValor, Long pais, Long sucursal)
                                 throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_RERE_SEQ");                                        
                final EntityTransaction et = em.getTransaction();
                et.begin();
                RecepcionReclamosLocal local = new RecepcionReclamosLocal(oid, numero, anio, periodoMes, consultoraReclamante,
                                                     cargoAbono, usuaSolicitante, observClienteReclam, 
                                                     observAreaReclamo, fecResolPrevista, fecResolReal,
                                                     fichDocumAdjunto, usuGestorPrev, usuGestorReal, 
                                                     observacionesResolucion, subacceso, empresa, cuenta, 
                                                     movimientoCC, medioPago, motivosRechazo, periodoReclamante,
                                                     fechaDocumento, importeReclamado, situacReclam, canal,
                                                     acceso, fechaValor, pais, sucursal);
                em.persist(local);
                et.commit();
                return local;
        }        
	
	public void remove(RecepcionReclamosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(RecepcionReclamosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public RecepcionReclamosLocal findByPrimaryKey(Long  oid) {
		RecepcionReclamosLocal local = (RecepcionReclamosLocal)em.find(RecepcionReclamosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
	
}
