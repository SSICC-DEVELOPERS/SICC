package es.indra.sicc.entidades.ccc;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;

import es.indra.sicc.entidades.ccc.CabeceraCargosAbonosDirectosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Date;

public class CabeceraCargosAbonosDirectosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-ccc");
	private EntityManager em = emf.createEntityManager();
        
	public CabeceraCargosAbonosDirectosLocal create(Integer numero, String anio, 
                        String periodoMes, Date fechaDocumento, Long pais_oid_pais,
                        Long empresa, String codigoUsuario, Date fechaValor, Long proceso) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_CCAD_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		CabeceraCargosAbonosDirectosLocal local = new CabeceraCargosAbonosDirectosLocal(oid, numero, anio, 
                                                periodoMes, fechaDocumento, pais_oid_pais,
                                             empresa, codigoUsuario, fechaValor, proceso);
		em.persist(local);
		et.commit();
		return local;
	}

        public CabeceraCargosAbonosDirectosLocal create(Integer numero, String anio,
                String periodoMes, Date fechaDocumento, Date fechaValor, String referenciaExterna, 
                String numeroLoteContabilizacion, Date fechaContabilizacion, 
                String observaciones, Long subacceso, Long pais, Long empresa, 
                Long cliente, String codigoUsuario, Long tipoAbonoSubproceso, Long situacion,
                String codigoClienteDesde, String codigoClienteHasta, String periodoDesde, 
                String periodoHasta, Date fechaDocumentoDesde, Date fechaDocumentoHasta,
                Date fechaVencimientoDesde, Date fechaVencimientoHasta, Long cuentacorriente, Long proceso) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("CCC_CCAD_SEQ");
                final EntityTransaction et = em.getTransaction();
                et.begin();
                CabeceraCargosAbonosDirectosLocal local = new CabeceraCargosAbonosDirectosLocal(oid, numero, anio,
                                             periodoMes, fechaDocumento, fechaValor, referenciaExterna, 
                                             numeroLoteContabilizacion, fechaContabilizacion, 
                                             observaciones, subacceso, pais, empresa, 
                                             cliente, codigoUsuario, tipoAbonoSubproceso, situacion,
                                             codigoClienteDesde, codigoClienteHasta, periodoDesde, 
                                             periodoHasta, fechaDocumentoDesde, fechaDocumentoHasta,
                                             fechaVencimientoDesde, fechaVencimientoHasta, cuentacorriente, proceso);
                em.persist(local);
                et.commit();
                return local;
        }
        
	public void remove(CabeceraCargosAbonosDirectosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(CabeceraCargosAbonosDirectosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public CabeceraCargosAbonosDirectosLocal findByPrimaryKey(Long  oid) {
		CabeceraCargosAbonosDirectosLocal local = (CabeceraCargosAbonosDirectosLocal)em.find(CabeceraCargosAbonosDirectosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public CabeceraCargosAbonosDirectosLocal findByUK(Integer numeroCargoAbonoDirecto,String anyoAbonoDirecto,String periodoMesAbonoDirecto) {
		Query query=em.createNamedQuery("CabeceraCargosAbonosDirectosLocal.FindByUK");
		
		query.setParameter(1, numeroCargoAbonoDirecto);

		query.setParameter(2, anyoAbonoDirecto);

		query.setParameter(3, periodoMesAbonoDirecto);

		return (CabeceraCargosAbonosDirectosLocal)(query.getSingleResult());
	}

	public CabeceraCargosAbonosDirectosLocal findByPaisEmpresaLoteFacturacion(Long oidPais,Long oidEmpresa,String nroLoteFacturacion) {
		Query query=em.createNamedQuery("CabeceraCargosAbonosDirectosLocal.FindByPaisEmpresaLoteFacturacion");
		
		query.setParameter(1, oidPais);

		query.setParameter(2, oidEmpresa);

		query.setParameter(3, nroLoteFacturacion);

		return (CabeceraCargosAbonosDirectosLocal)(query.getSingleResult());
	}

}
