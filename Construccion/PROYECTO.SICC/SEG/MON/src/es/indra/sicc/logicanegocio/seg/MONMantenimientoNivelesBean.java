/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
package es.indra.sicc.logicanegocio.seg;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.seg.PaginaDefinirNivelesDTO;
import es.indra.sicc.dtos.seg.AsociacionNivelesDTO;
import es.indra.sicc.dtos.seg.PaginaEliminarNivelesDTO;
import es.indra.sicc.dtos.seg.DTOListaAsociacionNiveles;
import es.indra.sicc.dtos.seg.DTOInternacional;

import es.indra.sicc.logicanegocio.mae.MONMantenimientoMAEHome;
import es.indra.sicc.logicanegocio.mae.MONMantenimientoMAE;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;

import es.indra.sicc.entidades.seg.AsociacionNivelesLocal;
import es.indra.sicc.entidades.seg.AsociacionNivelesLocalHome;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import javax.ejb.CreateException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

/**
 * Sistema:           Belcorp - SICC
 * Modulo:            SEG - Seguridad
 * Componente:        MONMantenimientoNivelesBean
 * Fecha:             03/11/2003
 * Documentacion:     
 * Observaciones:     
 *
 * @version           1.0
 * @author            Viviana Bongiovanni
 */ 

public class MONMantenimientoNivelesBean implements SessionBean  {

private SessionContext ctx;
 
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    public PaginaDefinirNivelesDTO cargarPaginaDefinirNiveles(Long oidPais, Long oidIdioma) throws MareException {
        UtilidadesLog.info("MONMantenimientoNiveles.cargarPaginaDefinirNiveles(Long , Long):Entrada");
        DTOInternacional internacional = new DTOInternacional(); 
        PaginaDefinirNivelesDTO dtos = new PaginaDefinirNivelesDTO();

        // Paises
        MONMantenimientoSEGHome segHome = getMONMantenimientoSEGHome();

        try {
            MONMantenimientoSEG seg = segHome.create();
            internacional.setOidIdioma(oidIdioma);
            dtos.setPaises(seg.recuperarPaisesSinTodos(internacional).getResultado());
            
        } catch(RemoteException re) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
            throw new MareException(re,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException ce) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
            throw new MareException(ce,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        // NSE de Pais
        dtos.setTiposNivelesSocioeconomicosPersonal(this.recuperarTiposNivelesSocioeconomicosPersonales(oidPais,oidIdioma).getResultado());

        // NSE e Belcorp
        dtos.setNivelesSocioeconomicosBelcorp(this.recuperarNivelesSocioEconomicosBelcorp().getResultado());
        UtilidadesLog.info("MONMantenimientoNiveles.cargarPaginaDefinirNiveles(Long , Long):Salida");
        return dtos;
    }

    public PaginaEliminarNivelesDTO cargarPaginaEliminarNiveles(Long oidPais, Long oidIdioma) throws MareException {
        UtilidadesLog.info("MONMantenimientoNiveles.cargarPaginaEliminarNiveles(Long , Long):Entrada");
        DTOInternacional internacional = new DTOInternacional();
        PaginaEliminarNivelesDTO dtos = new PaginaEliminarNivelesDTO();

        // Paises
        MONMantenimientoSEGHome segHome = getMONMantenimientoSEGHome();

        try {
            MONMantenimientoSEG seg = segHome.create();
            internacional.setOidIdioma(oidIdioma);
            dtos.setPaises(seg.recuperarPaisesSinTodos(internacional).getResultado());
            
        } catch(RemoteException re) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
            throw new MareException(re,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException ce) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
            throw new MareException(ce,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        // Relación
        dtos.setAsociaciones(this.recuperarAsociacionesNiveles(oidPais, oidIdioma).getResultado());
        
        UtilidadesLog.info("MONMantenimientoNiveles.cargarPaginaEliminarNiveles(Long , Long):Salida");
        return dtos;        
    }

    public DTOSalida recuperarTiposNivelesSocioeconomicosPersonales(Long oidPais, Long oidIdioma) throws MareException {
        UtilidadesLog.info("MONMantenimientoNiveles.recuperarTiposNivelesSocioeconomicosPersonales(Long , Long):Entrada");
        DTOSalida dtos = new DTOSalida();
        
        MONMantenimientoMAEHome maeHome = getMONMantenimientoMAEHome();

        try {
            MONMantenimientoMAE mae = maeHome.create();

            dtos = mae.recuperaTiposNSEPPorPais(oidPais,oidIdioma);
            
        } catch(RemoteException re) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
            throw new MareException(re,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException ce) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
            throw new MareException(ce,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONMantenimientoNiveles.recuperarTiposNivelesSocioeconomicosPersonales(Long , Long):Salida");
        return dtos;  
       
    }

    public DTOSalida recuperarNivelesSocioEconomicosBelcorp() throws MareException {
        UtilidadesLog.info("MONMantenimientoNiveles.recuperarNivelesSocioEconomicosBelcorp():Entrada");
        BelcorpService bs;
        RecordSet respuesta;
        DTOSalida dtos = new DTOSalida();
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append("select OID_NIVE_SOEC_BELC, DES_NIVE_SOCI_ECON_BELC ");         
            buf.append("from SEG_NIVEL_SOCIO_ECONO_BELCO");
            buf.append(" order by DES_NIVE_SOCI_ECON_BELC");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

       dtos.setResultado(respuesta);
       UtilidadesLog.info("MONMantenimientoNiveles.recuperarNivelesSocioEconomicosBelcorp():Salida");
       return dtos;  
      
    }

    public DTOSalida recuperarAsociacionesNiveles(Long oidPais, Long oidIdioma) throws MareException {
        UtilidadesLog.info("MONMantenimientoNiveles.recuperarAsociacionesNiveles(Long , Long):Entrada");
        BelcorpService bs;
        RecordSet respuesta;
        DTOSalida dtos = new DTOSalida();
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            /**
             * Cambio realizado para Corporativo local
             * Viviana Bongiovanni 
             * 14/01/2005
             */
            buf.append(" 	SELECT c.oid_nive_soec_asoc, c.pais_oid_pais, b.oid_nive_soec_belc,	 ");
            buf.append(" 	b.des_nive_soci_econ_belc, c.oid_nsep, val_i18n desc_nsep_il8n	 ");
            buf.append(" 	FROM seg_nivel_socio_econo_belco b,	 ");
            buf.append(" 	(SELECT *	 ");
            buf.append(" 	FROM mae_tipo_nivel_socec_perso m, v_gen_i18n_sicc g, seg_nivel_socio_econo_asoci a	 ");
            buf.append(" 	WHERE m.oid_nsep = g.val_oid	 ");
                
            if (oidPais !=  null){
                  buf.append("and m.PAIS_OID_PAIS = " + oidPais);
            }
            
            if (oidIdioma !=  null){
                  buf.append(" 	and g.IDIO_OID_IDIO = " + oidIdioma);
            }
    
            buf.append(" 	AND g.attr_enti = 'MAE_TIPO_NIVEL_SOCEC_PERSO'	 ");
            buf.append(" 	AND g.attr_num_atri = 1	 ");
            buf.append(" 	AND a.nsep_oid_tipo_nive_soec_pers = m.oid_nsep) c	 ");
            buf.append(" 	WHERE c.nseb_oid_nive_soec_belc(+) = b.oid_nive_soec_belc	 ");
            buf.append(" 	ORDER BY des_nive_soci_econ_belc, desc_nsep_il8n	 ");          

            respuesta = bs.dbService.executeStaticQuery(buf.toString());


        } catch(Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
       
      

       dtos.setResultado(respuesta);
       UtilidadesLog.debug("dtos: " + dtos);
       UtilidadesLog.info("MONMantenimientoNiveles.recuperarAsociacionesNiveles(Long , Long):Salida");
       return dtos;         
       
    }

    public void definirAsociacionNiveles(DTOListaAsociacionNiveles asociacion) throws MareException {
        UtilidadesLog.info("MONMantenimientoNiveles.definirAsociacionNiveles(DTOListaAsociacionNiveles):Entrada");
        AsociacionNivelesLocalHome localHome = this.getAsociacionNivelesLocalHome();
        
        AsociacionNivelesDTO[] asociacionNiveles = asociacion.getAsociaciones();
        AsociacionNivelesDTO relacion = null;

        UtilidadesLog.debug("longitud: " + asociacionNiveles.length);

        for(int i=0; i < asociacionNiveles.length ;i++) {

            relacion = asociacionNiveles[i];

            try {

                localHome.create(relacion.getOidNivelSocioeconomicoBelcorp(),
                                                            relacion.getOidTipoNivelSocioeconomicoPersonal());
   
           
            } catch(PersistenceException e) {
                 ctx.setRollbackOnly();
                 throw new MareException(e,
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }                                                            

        }
        UtilidadesLog.info("MONMantenimientoNiveles.definirAsociacionNiveles(DTOListaAsociacionNiveles):Salida");
    }

    public void eliminarAsociacionNiveles(DTOListaAsociacionNiveles asociacion) throws MareException {
        UtilidadesLog.info("MONMantenimientoNiveles.eliminarAsociacionNiveles(DTOListaAsociacionNiveles):Entrada");
        AsociacionNivelesLocalHome localHome = this.getAsociacionNivelesLocalHome();

        AsociacionNivelesDTO[] asociacionNiveles = asociacion.getAsociaciones();
        AsociacionNivelesDTO relacion = null;

        UtilidadesLog.debug("longitud: " + asociacionNiveles.length);

        for(int i=0; i < asociacionNiveles.length ;i++) {

            relacion = asociacionNiveles[i];

            try {
                System.out.println("oid: " + relacion.getOidAsociacionNiveles());
                AsociacionNivelesLocal local = localHome.findByPrimaryKey(relacion.getOidAsociacionNiveles());
                try {
                    localHome.remove(local);
                } catch (PersistenceException pe) {
                    ctx.setRollbackOnly();
                    throw new MareException(pe, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
                
            } catch(NoResultException nre) {
                ctx.setRollbackOnly();
                throw new MareException(nre, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch(PersistenceException pex) {
                ctx.setRollbackOnly();
                throw new MareException(pex, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
            
        }
        UtilidadesLog.info("MONMantenimientoNiveles.eliminarAsociacionNiveles(DTOListaAsociacionNiveles):Salida");
    }

    private MONMantenimientoMAEHome getMONMantenimientoMAEHome() throws MareException {
        
        String codigoError;
        MONMantenimientoMAEHome localHome = null;
        BelcorpService miBerlcorpService = null;

        try {
            miBerlcorpService = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            localHome = (MONMantenimientoMAEHome)miBerlcorpService.ejbLocator.getHome("MONMantenimientoMAE",
                    MONMantenimientoMAEHome.class);
        } catch(MareServiceException e) {
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        return localHome;
        
    }

    private MONMantenimientoSEGHome getMONMantenimientoSEGHome() throws MareException {
    
        String codigoError;
        MONMantenimientoSEGHome localHome = null;
        BelcorpService miBerlcorpService = null;

        try {
            miBerlcorpService = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            localHome = (MONMantenimientoSEGHome)miBerlcorpService.ejbLocator.getHome("MONMantenimientoSEG",
                    MONMantenimientoSEGHome.class);
        } catch(MareServiceException e) {
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        return localHome;
       
    }

    private AsociacionNivelesLocalHome getAsociacionNivelesLocalHome() {
        return new AsociacionNivelesLocalHome();
    }
}
