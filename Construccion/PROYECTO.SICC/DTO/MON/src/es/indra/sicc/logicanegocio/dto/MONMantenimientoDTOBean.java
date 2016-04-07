/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.    
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La rmación contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 */
package es.indra.sicc.logicanegocio.dto;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.dtos.dto.DTOAlcanceAdministrativoDetalleDto;
import es.indra.sicc.dtos.dto.DTOAlcanceAdministrativoDto;
import es.indra.sicc.dtos.dto.DTOCodigoClienteDto;
import es.indra.sicc.dtos.dto.DTODescuento;
import es.indra.sicc.dtos.dto.DTODescuentoCliente;
import es.indra.sicc.dtos.dto.DTODescuentoDG;
import es.indra.sicc.dtos.dto.DTODescuentoOrden;
import es.indra.sicc.dtos.dto.DTOEAlcanceAdministrativoDTO;
import es.indra.sicc.dtos.dto.DTOEAlcanceClasificacionDTO;
import es.indra.sicc.dtos.dto.DTOEAlcanceTipoCliente;
import es.indra.sicc.dtos.dto.DTOEBaseAplicacion;
import es.indra.sicc.dtos.dto.DTOEBaseCalculo;
import es.indra.sicc.dtos.dto.DTOEBaseCalculoDetalle;
import es.indra.sicc.dtos.dto.DTOEBuscarAlcanceClasificacionDTO;
import es.indra.sicc.dtos.dto.DTOEBuscarAlcanceClienteDTO;
import es.indra.sicc.dtos.dto.DTOEBuscarDescuentos;
import es.indra.sicc.dtos.dto.DTOEBuscarDescuentosOrdenacion;
import es.indra.sicc.dtos.dto.DTOEBuscarProductosDTO;
import es.indra.sicc.dtos.dto.DTOEDescuentoCliente;
import es.indra.sicc.dtos.dto.DTOEDescuentosOrdenacion;
import es.indra.sicc.dtos.dto.DTOEMatrizSubtiposCliente;
import es.indra.sicc.dtos.dto.DTOEscalon;
import es.indra.sicc.dtos.dto.DTOGlobalDescuento;
import es.indra.sicc.dtos.dto.DTOListaBasesAplicacionDto;
import es.indra.sicc.dtos.dto.DTOListaDescuentoCliente;
import es.indra.sicc.dtos.dto.DTOSAlcanceTipoClienteDTO;
import es.indra.sicc.dtos.dto.DTOSBaseAplicacion;
import es.indra.sicc.dtos.dto.DTOSBaseAplicacionDetalle;
import es.indra.sicc.dtos.dto.DTOSBaseCalculo;
import es.indra.sicc.dtos.dto.DTOSBaseCalculoDetalle;
import es.indra.sicc.dtos.dto.DTOSPaginaAlcanceTiposClienteDetalle;
import es.indra.sicc.dtos.inc.DTODescuentosIncentivos;
import es.indra.sicc.dtos.inc.DTOProductoDescuento;
import es.indra.sicc.dtos.pre.ConstantesPRE;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.dto.AccesoDescuentoLocal;
import es.indra.sicc.entidades.dto.AccesoDescuentoLocalHome;
import es.indra.sicc.entidades.dto.AlcanceDescuentoAdministrativoLocal;
import es.indra.sicc.entidades.dto.AlcanceDescuentoAdministrativoLocalHome;
import es.indra.sicc.entidades.dto.AlcanceDescuentoClasificacionLocal;
import es.indra.sicc.entidades.dto.AlcanceDescuentoClasificacionLocalHome;
import es.indra.sicc.entidades.dto.AlcanceDescuentoClienteLocal;
import es.indra.sicc.entidades.dto.AlcanceDescuentoClienteLocalHome;
import es.indra.sicc.entidades.dto.BaseAplicacionCabeceraLocal;
import es.indra.sicc.entidades.dto.BaseAplicacionCabeceraLocalHome;
import es.indra.sicc.entidades.dto.BaseAplicacionDetalleLocal;
import es.indra.sicc.entidades.dto.BaseAplicacionDetalleLocalHome;
import es.indra.sicc.entidades.dto.BaseCalculoCabeceraLocal;
import es.indra.sicc.entidades.dto.BaseCalculoCabeceraLocalHome;
import es.indra.sicc.entidades.dto.BaseCalculoDetalleLocal;
import es.indra.sicc.entidades.dto.BaseCalculoDetalleLocalHome;
import es.indra.sicc.entidades.dto.DescuentoLocal;
import es.indra.sicc.entidades.dto.DescuentoLocalHome;
import es.indra.sicc.entidades.dto.EscalonLocal;
import es.indra.sicc.entidades.dto.EscalonLocalHome;
import es.indra.sicc.entidades.dto.SubaccesoDescuentoLocal;
import es.indra.sicc.entidades.dto.SubaccesoDescuentoLocalHome;
import es.indra.sicc.entidades.dto.SubtipoClienteDescuentoLocalHome;
import es.indra.sicc.entidades.dto.TipoClienteDescuentoLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.logicanegocio.dto.ConstantesDTO;
import es.indra.sicc.logicanegocio.dto.ServiciosDTO;
import es.indra.sicc.logicanegocio.mae.MONClientes;
import es.indra.sicc.logicanegocio.pre.PREConsultas;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.ExcepcionParametrizada;
import es.indra.sicc.util.MAEEjbLocators;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.sql.Date;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONMantenimientoDTOBean implements SessionBean {
    private SessionContext ctx = null;

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

    public DTOSalida buscarDescuentos(DTOEBuscarDescuentos dto)  
    throws MareException {
        DAODescuento descDAO = new DAODescuento();
        return descDAO.buscarDescuentos(dto);
    }
//
    public DTOSalida buscarDescuentosOrdenacion( DTOEBuscarDescuentosOrdenacion dto) 
    throws MareException {
        DAODescuento descDAO = new DAODescuento();
        return descDAO.buscarDescuentosOrdenacion(dto);
    }
//

    /**
    * @author Ssantana
    * @date 3/11/2004
    * @desc Modif: Se agrega validacion tal que la fecha de sistema sea menor a 
    * PeriodoInico.final x inc. 9722 
    * @throws MareException
    * Notas:
    *       @adiaz 21/11/2005, refac. segun modelo: DMCO-DTO-BELC300014763
    */
    public DTOOID guardarDescuentoDG(DTOGlobalDescuento dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoDTO.guardarDescuentoDG(DTOGlobalDescuento dto): Entrada");
        
        DTODescuentoDG dtoDDG = new DTODescuentoDG();

        dtoDDG.setAccesos(dto.getDatosGralesDto().getAccesos());
        dtoDDG.setActivo(dto.getDatosGralesDto().getActivo());
        dtoDDG.setAfectaACuentasCorrientes(dto.getDatosGralesDto().getAfectaACuentasCorrientes());
        dtoDDG.setAfectaAFacturas(dto.getDatosGralesDto().getAfectaAFacturas());
        dtoDDG.setAprobado(dto.getDatosGralesDto().getAprobado());
        dtoDDG.setAttTraducible(dto.getDatosGralesDto().getAttTraducible());
        dtoDDG.setComunicacionAParticipantes(dto.getDatosGralesDto().
        getComunicacionAParticipantes());
        dtoDDG.setControlAnulaciones(dto.getDatosGralesDto().getControlAnulaciones());
        dtoDDG.setControlDevoluciones(dto.getDatosGralesDto().getControlDevoluciones());
        dtoDDG.setCulminacion(dto.getDatosGralesDto().getCulminacion());
        dtoDDG.setDescripcion(dto.getDatosGralesDto().getDescripcion());
        dtoDDG.setDescuentoAcumulativo(dto.getDatosGralesDto().getDescuentoAcumulativo());
        dtoDDG.setMorosidad(dto.getDatosGralesDto().getMorosidad());
        dtoDDG.setNacional(dto.getDatosGralesDto().getNacional());
        dtoDDG.setNumeroCorrelativo(dto.getDatosGralesDto().getNumeroCorrelativo());
        dtoDDG.setNumeroDescuento(dto.getDatosGralesDto().getNumeroDescuento());
        dtoDDG.setOidCabeceraDTO(dto.getDatosGralesDto().getOidCabeceraDTO());
        dtoDDG.setOidCanal(dto.getDatosGralesDto().getOidCanal());
        dtoDDG.setOidDescuento(dto.getDatosGralesDto().getOidDescuento());
        dtoDDG.setOidMarca(dto.getDatosGralesDto().getOidMarca());
        dtoDDG.setOidPais(dto.getDatosGralesDto().getOidPais());
        dtoDDG.setOidPeriodoDesde(dto.getDatosGralesDto().getOidPeriodoDesde());
        dtoDDG.setOidPeriodoHasta(dto.getDatosGralesDto().getOidPeriodoHasta());
        dtoDDG.setSubaccesos(dto.getDatosGralesDto().getSubaccesos());
        dtoDDG.setVigencia(dto.getDatosGralesDto().getVigencia());
        
        UtilidadesLog.debug("SCS, dtoDDG, queda: " + dtoDDG);
        
        // Validar bases de aplicación si se quiere activar el descuento 
        if (dtoDDG.getActivo().booleanValue())
        {
            // Debe validarse que el descuento tenga bases de aplicación existentes
            if (dto.getBasesAplicacion().getBasesAplicacion() != null)
            {
                if (dto.getBasesAplicacion().getBasesAplicacion().length == 0)
                {
                    UtilidadesLog.debug("SCS, excepcion: DESCUENTO NO ACTIVABLE POR BASE APLICACION....");
                    throw new MareException(null,null, UtilidadesError.armarCodigoError( 
                                            ConstantesSEG.MODULO_DTO , "",
                                            ErroresDeNegocio.DESCUENTO_NO_ACTIVABLE_POR_BASE_APLICACION_0015));
                }
            }    
        }
        
        // Validar Periodos
        try{
            if (dtoDDG.getOidPeriodoDesde() != null) 
            {
                PeriodoLocalHome p = new PeriodoLocalHome();            
                PeriodoLocal vigenciaInicial =  p.findByPrimaryKey(dtoDDG.getOidPeriodoDesde());                        
                
                /*
                 * Comentado por incidencia BELC300024057 
                 * 
                if (System.currentTimeMillis() >= vigenciaInicial.getFechaFin().getTime())
                {
                    UtilidadesLog.debug("SCS, excepcion: PERIODO INICIAL NO VIGENTE....");
                    throw new MareException(new Exception(), 
                            UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_DTO , "",
                                ErroresDeNegocio.PERIODO_INICIAL_NO_VIGENTE));
                }
                
                */
                
                if (dtoDDG.getOidPeriodoHasta() != null) 
                {    
                    UtilidadesLog.debug(" -getOidPeriodoHasta: " + dtoDDG.getOidPeriodoHasta().toString());            
                    UtilidadesLog.debug(" -getOidPeriodoDesde: " + dtoDDG.getOidPeriodoDesde().toString());                            
                    PeriodoLocal vigenciaFinal = p.findByPrimaryKey(dtoDDG.getOidPeriodoHasta());
                     
                    if (vigenciaInicial.getFechaFin().getTime() > vigenciaFinal.getFechaFin().getTime())
                    {  
                        UtilidadesLog.debug("SCS, excepcion: ERROR EN PERIODO....");
                        throw new MareException(new Exception(), 
                                UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_DTO , "",
                                    ErroresDeNegocio.ERROR_EN_PERIODO_0014));
                    }
                    
                }    
            }
        } catch (NoResultException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError( 
                      CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }        

        // Guardar Datos 
        
        if (dtoDDG.getOidDescuento() == null)
        {
            DAODescuento daoDESC = new DAODescuento();
            Long ultNroCorr = Long.valueOf(daoDESC.ultimoNumeroCorrelativo(dtoDDG.
                                           getOidPais(), dtoDDG.getOidMarca(), 
                                           dtoDDG.getOidCanal()).toString());
            Long ultNro     = Long.valueOf(daoDESC.ultimoNumeroDescuentoPais(
                                           dtoDDG.getOidPais()).toString());
            
            UtilidadesLog.debug("SCS, ultNroCorr/ultNro, son: " + ultNroCorr + "/" + ultNro);
            Long newOID = null;
            try {
                DescuentoLocalHome desc = new DescuentoLocalHome();
                DescuentoLocal descL = desc.create(dtoDDG.getOidPeriodoDesde(),
                                               dtoDDG.getOidCanal(),
                                               dtoDDG.getOidMarca(),
                                               UtilidadesDTO.getLong(dtoDDG.getCulminacion()),
                                               UtilidadesDTO.getLong(dtoDDG.getAfectaAFacturas()), 
                                               UtilidadesDTO.getLong(dtoDDG.getControlDevoluciones()), 
                                               UtilidadesDTO.getLong(dtoDDG.getComunicacionAParticipantes()),
                                               UtilidadesDTO.getLong(dtoDDG.getActivo()), 
                                               UtilidadesDTO.getLong(dtoDDG.getControlAnulaciones()), 
                                               UtilidadesDTO.getLong(dtoDDG.getDescuentoAcumulativo()), 
                                               UtilidadesDTO.getLong(dtoDDG.getAfectaACuentasCorrientes()),
                                               UtilidadesDTO.getLong(dtoDDG.getMorosidad()), 
                                               UtilidadesDTO.getLong(dtoDDG.getAprobado()), 
                                               UtilidadesDTO.getLong(dtoDDG.getNacional()), 
                                               dtoDDG.getOidPais(), 
                                               ultNroCorr, 
                                               ultNro);
                                               
                descL.setMdes_oid_tipo_desc(dtoDDG.getOidCabeceraDTO());
                descL.setPerd_oid_peri_limi_fin(dtoDDG.getOidPeriodoHasta());
                desc.merge(descL);
                
                newOID  = descL.getOid();                               
                UtilidadesLog.debug("SCS, cree registro en Descuento!");
            }catch (PersistenceException e) {
                UtilidadesLog.error(e);
                throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            // Accesos
            DTOOIDs dtos = dtoDDG.getAccesos();
            try {
                UtilidadesLog.debug("SCS, dtos.getOids(), mide: " + dtos.getOids().length);
                int lenOids = dtos.getOids().length;
                for (int i  = 0; i < lenOids ; i++){
                    if (dtos.getOids()[i] != null)   
                    {
                        Long oid = dtos.getOids()[i];
                        UtilidadesLog.debug("SCS, dtos.getOids(), posicion: " + i + ", contenido: " + oid);
                        AccesoDescuentoLocalHome acc = new AccesoDescuentoLocalHome();
                        UtilidadesLog.debug("data a meter: " + newOID + " , " +  dtos.getOids()[i]);
                        acc.create(newOID, dtos.getOids()[i]);
                    }    
                }
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(e);
                throw new MareException(e, UtilidadesError.
                armarCodigoError( CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }                
            
            // Subaccesos
            dtos = dtoDDG.getSubaccesos();
            try {
                for (int i  = 0; i < dtos.getOids().length ; i++){
                    SubaccesoDescuentoLocalHome sacc = new SubaccesoDescuentoLocalHome();
                    sacc.create(dtos.getOids()[i], newOID);
                }
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(e);
                throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }                
            
            UtilidadesLog.debug("SubAccesos grabados");
            UtilidadesDTO.insertarTraducciones("DTO_DESCU", newOID , 
                                                dtoDDG.getAttTraducible(), ctx);
            DTOOID oid = new DTOOID();
            oid.setOid(newOID);
            
            UtilidadesLog.info("MONMantenimientoDTO.guardarDescuentoDG(DTOGlobalDescuento dto): Salida");
            return oid;       
        
        } else {
            // Modificacion de descuento existente
            DAODescuento daoDESC = new DAODescuento();

            UtilidadesLog.debug("Modificando descuento existente");            
            DescuentoLocalHome desc = new DescuentoLocalHome();
            DescuentoLocal des = null;
            try {
                des = desc.findByPrimaryKey(dtoDDG.getOidDescuento());
            } catch (NoResultException e) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(e);
                throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }        
            
            des.setCana_oid_cana(dtoDDG.getOidCanal());
            des.setInd_acti(UtilidadesDTO.getLong(dtoDDG.getActivo()));
            des.setInd_afec_cc(UtilidadesDTO.getLong(dtoDDG.getAfectaACuentasCorrientes()));
            des.setInd_afec_fact(UtilidadesDTO.getLong(dtoDDG.getAfectaAFacturas()));
            des.setInd_apro(UtilidadesDTO.getLong(dtoDDG.getAprobado()));
            des.setInd_comu_part(UtilidadesDTO.getLong(dtoDDG.getComunicacionAParticipantes()));
            des.setInd_ctrl_anul(UtilidadesDTO.getLong(dtoDDG.getControlAnulaciones()));
            des.setInd_ctrl_devo(UtilidadesDTO.getLong(dtoDDG.getControlDevoluciones()));
            des.setInd_culm(UtilidadesDTO.getLong(dtoDDG.getCulminacion()));
            des.setInd_desc_acumu(UtilidadesDTO.getLong(dtoDDG.getDescuentoAcumulativo()));
            des.setInd_moro(UtilidadesDTO.getLong(dtoDDG.getMorosidad()));
            des.setInd_naci(UtilidadesDTO.getLong(dtoDDG.getNacional()));
            des.setMarc_oid_marc(dtoDDG.getOidMarca());
            des.setMdes_oid_tipo_desc(dtoDDG.getOidCabeceraDTO());
            des.setPais_oid_pais(dto.getOidPais());
            des.setPerd_oid_peri(dtoDDG.getOidPeriodoDesde());
            des.setPerd_oid_peri_limi_fin(dtoDDG.getOidPeriodoHasta());
            desc.merge(des);

            RecordSet rs = daoDESC.obtenerAccesosDescuento(dtoDDG.getOidDescuento());
            AccesoDescuentoLocalHome alh = new AccesoDescuentoLocalHome();
            UtilidadesLog.debug("SCS, rs; es: " + rs);
            int records = rs.getRowCount();
            for(int i = 0 ; i < records; i++){
                Long oid = UtilidadesDTO.getLong(rs.getValueAt(i, 0));
                try {
                    AccesoDescuentoLocal al = alh.findByPrimaryKey(oid);
                    alh.remove(al);
                } catch (NoResultException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error(e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error(e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }        
            }
            UtilidadesLog.debug("Accesos removidos");
            rs = daoDESC.obtenerSubaccesosDescuento(dtoDDG.getOidDescuento());
            UtilidadesLog.debug("SCS, rs; es: " + rs);
            SubaccesoDescuentoLocalHome slh = new SubaccesoDescuentoLocalHome();
            int records1 = rs.getRowCount();                                        
            for(int i = 0 ; i < records1; i++){
                Long oid = UtilidadesDTO.getLong(rs.getValueAt(i, 0));
                try {
                    SubaccesoDescuentoLocal sl = slh.findByPrimaryKey(oid);
                    slh.remove(sl);
                } catch (NoResultException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error(e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                } catch (PersistenceException e) {
                        ctx.setRollbackOnly();
                        UtilidadesLog.error(e);
                        throw new MareException(e, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }                         
            }
            UtilidadesLog.debug("subaccesos removidos");
            DTOOIDs accOids = dtoDDG.getAccesos();
            UtilidadesLog.debug("SCS, accOids.getOids(); es: " + accOids.getOids());
            int lenOids = accOids.getOids().length;
            for (int i  = 0; i < lenOids; i++){
                Long oid = accOids.getOids()[i];
                try {   
                    alh.create(dtoDDG.getOidDescuento(), oid);
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error(e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }                
            }
            UtilidadesLog.debug("accesos creados");
            DTOOIDs sccOids = dtoDDG.getSubaccesos();
            UtilidadesLog.debug("SCS, sccOids.getOids(); es: " + sccOids.getOids());
            int lenOids1 = sccOids.getOids().length; 
            for (int i  = 0; i < lenOids1; i++){
                Long oid = sccOids.getOids()[i];
                try {
                    slh.create(oid, dtoDDG.getOidDescuento());
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error(e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }                
                    
            }
            UtilidadesLog.debug("subaccesos creados");
            UtilidadesDTO.insertarTraducciones("DTO_DESCU", dtoDDG.getOidDescuento() , 
            dtoDDG.getAttTraducible() , ctx);

            DTOOID dtooid = new DTOOID();
            dtooid.setOid(dtoDDG.getOidDescuento());

            // Eliminamos el descuento de los descuentos residentes en memoria
            ServiciosDTO serviciosDTO = ServiciosDTO.getInstannce();
            serviciosDTO.getDescuentos().remove(dtoDDG.getOidDescuento());
            
            UtilidadesLog.debug("SCS, el dtooid q' retorno, es: " + dtooid);
            UtilidadesLog.info("MONMantenimientoDTO.guardarDescuentoDG(DTOGlobalDescuento dto): Salida");
            return dtooid; 
            
        }
    }


    public void guardarParametroNacional (DTODescuentoDG dto) throws MareException{
        UtilidadesLog.info("MONMantenimientoDTO.guardarParametroNacional(): Entrada");

        /*
        Entrada: DTODescuentoDG 
        Sólo tenemos en cuenta los atributos oidDescuento y nacional 
        Proceso: 
        -> Hacer findByPrimaryKey sobre la la entidad Descuento con el oidDescuento del dto de entrada 
        -> Setear el atributo nacional del dto de entrada en el atributo nacional de la entidad
        */
        try{
            DescuentoLocalHome descHome = new DescuentoLocalHome();
            DescuentoLocal dl  = descHome.findByPrimaryKey(dto.getOidDescuento());
            dl.setInd_naci(UtilidadesDTO.getLong(dto.getNacional()));
            descHome.merge(dl);
        } catch (NoResultException e) {
            throw new MareException(e,
            UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("MONMantenimientoDTO.guardarParametroNacional(): Salida");
    }

    


    public void guardarOrdenacionDTO(DTOEDescuentosOrdenacion dto ) throws MareException {
        UtilidadesLog.info("MONMantenimientoDTO.guardarOrdenacionDTO(): Entrada");

        /*
          Entrada: DTOEDescuentosOrdenacion
        - lista : arrayList de elementos DTODescuentoOrdenacion
        Proceso:
        Iniciar un contador en 1 e iniciar el siguiente bucle:
        Para cada elemento del array hacer
        -> Hacer findByPrimaryKey sobre la entidad Descuento con el oidDescuento contenido en el dto
        -> Setear "numeroCorrelativo" de descuento con el valor del contador, y también setear el indicador de culminación.
        -> Incrementar contador
        Fin Para
        */
        
        Iterator iter = dto.getLista().iterator();
       
        for (int i = 1; iter.hasNext(); i++) {
            DescuentoLocalHome descHome = new DescuentoLocalHome();
            DTODescuentoOrden orden = (DTODescuentoOrden) iter.next();

            DescuentoLocal desc = null;

            try {
				UtilidadesLog.debug("orden.getOidDescuento() : " +orden);
                desc = descHome.findByPrimaryKey(orden.getOidDescuento());
            } catch (NoResultException e) {
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                       CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }

            desc.setNum_desc_corr(new Long(i));
            desc.setInd_culm(orden.getIndicadorCulminacion().booleanValue() ? new Long(1) : new Long(0));
            descHome.merge(desc);
        }
        UtilidadesLog.info("MONMantenimientoDTO.guardarOrdenacionDTO(): Salida");
    }


    /**
     * Elimina un descuentos por cada oid de entrada.
     * Elimina en cascada todos los registros relacionados de la entidad "Descuento".
     * Valida que el descuente NO este activo, y valida que el descuento NO HAYA estado activo.
     */
    public void eliminarDescuentos(DTOOIDs dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoDTO.eliminarDescuentos(): Entrada");
        int codigoError;
        Long[] oids = dto.getOids();
        DescuentoLocalHome descHome = new DescuentoLocalHome();
        DescuentoLocal descBean = null;

        // Para cada oid contenido en el dto de entrada hacer lo siguiente:
        for (int i = 0; i < oids.length; i++) {
            try {
                // -> Hacer un "findByPrimaryKey" sobre la entidad "Descuento"
                descBean = descHome.findByPrimaryKey(oids[i]);
                eliminarDescripcion(oids[i]);
            } catch (NoResultException e) {
                ctx.setRollbackOnly();
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
            // -> Verificar que no es un descuento activo, atributo "activo" de tipo Boolean
            if (UtilidadesDTO.getBoole(descBean.getInd_acti()).equals(Boolean.FALSE)) {
                //Si no es un descuento activo entonces
                // -> Crear variable llamada "fechaIniPeriodoIni" de tipo Date
                Date fechaIniPeriodoIni;
                // -> Hacer "findByPrimaryKey" sobre la entidad Periodo (CRA) tomando el valor de
                // Descuento.vigenciaInicial (oid de periodo de inicio)
                PeriodoLocalHome periodoLocalHome = new PeriodoLocalHome();
                PeriodoLocal periodoLocal;
                try {
                    periodoLocal = periodoLocalHome.findByPrimaryKey(descBean.getPerd_oid_peri());
                } catch (NoResultException e) {
                    ctx.setRollbackOnly();
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                }
                // -> fechaIniPefiodoIni = Periodo.fechaIni
                fechaIniPeriodoIni = periodoLocal.getFechainicio();

                // Si (fechaIniPeriodoIni > fecha del sistema) entonces
                if (fechaIniPeriodoIni.getTime() > System.currentTimeMillis()) {
                    // -> Hacer un "remove" sobre la entidad "Descuento", sus registros asociados se borrarán en cascada.
                    try {
                        descHome.remove(descBean);
                    } catch (PersistenceException e) {
                        ctx.setRollbackOnly();
                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                    }
                    // Eliminamos el descuento de los descuentos residentes en memoria
                    ServiciosDTO serviciosDTO = ServiciosDTO.getInstannce();
                    serviciosDTO.getDescuentos().remove(oids[i]);

                } else {
                    // -> Lanzar MareException con código de mensaje "DTO-0021" con el valor de Descuento.numeroDescuento como parámetro
                    UtilidadesLog.debug("NO_PUEDE_BORRARSE_DESCUENTO_QUE_ESTUBO_ACTIVO_0021");
                    codigoError = UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_DTO,"",
                                        ErroresDeNegocio.NO_PUEDE_BORRARSE_DESCUENTO_QUE_ESTUBO_ACTIVO_0021);    
                    ExcepcionParametrizada exParam = new ExcepcionParametrizada(new MareException(), codigoError);
                    exParam.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                    exParam.addParameter(descBean.getNum_desc().toString());
                    throw exParam;
                }

            } else {
                // Si es un descuento activo entonces
                // -> Lanzar MareException con código de mensaje "DTO-0011"
                UtilidadesLog.debug("NO_PUEDE_BORRARSE_UN_DESCUENTO_ACTIVO_0011");
                codigoError = UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_DTO,"",
                                    ErroresDeNegocio.NO_PUEDE_BORRARSE_UN_DESCUENTO_ACTIVO_0011);    
                ExcepcionParametrizada exParam = 
                new ExcepcionParametrizada(new MareException(), codigoError);
                exParam.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                exParam.addParameter(descBean.getNum_desc().toString());
                throw exParam;
            }
        }
        UtilidadesLog.info("MONMantenimientoDTO.eliminarDescuentos(): Salida");
    }


    /**
     * 
     */
    public DTOSalida consultarAlcanceAdministrativoDTO(
        DTOOID dto) throws MareException {
        DAODescuento descDAO = new DAODescuento();

        return descDAO.obtenerDTOAlcanceAdministrativo(dto);
    }

    public DTOSalida consultarAlcanceClienteDTO(DTOEBuscarAlcanceClienteDTO dto)
        throws MareException {
        DAODescuento descDAO = new DAODescuento();

        return descDAO.obtenerDTOAlcanceCliente(dto);
    }
//
    public DTOSBaseCalculo consultarBaseCalculoDTO(DTOOID dto)
        throws MareException {
        DAODescuento descDAO = new DAODescuento();

        return descDAO.obtenerDTOBaseCalculo(dto);
    }
//                                         
    public DTOSalida consultarProductosDTO(DTOEBuscarProductosDTO dto)
        throws MareException {
        DAODescuento descDAO = new DAODescuento();
        return descDAO.obtenerDTOProductos(dto);
    }
    
   /*
   * @author  ssaavedr
   * @date    02/11/2005
   * @description construido segun modelo: DMCO-DTO-BELC300014763
   * @throws MareException
   */    
    public DTOSBaseAplicacion consultarBaseAplicacionDTO(DTOOID dto) throws MareException {
        DAODescuento descDAO = new DAODescuento();
        return descDAO.obtenerDTOBaseAplicacion(dto);
    }
    
    public DTOSBaseAplicacion consultarBaseAplicacionDTOBatch(DTOOID dto) throws MareException {
        DAODescuento descDAO = new DAODescuento();
        return descDAO.obtenerDTOBaseAplicacionBatch(dto);
    }
//
//    
    /**
    * modificado por Noziglia C.
    * se agrego el campo Oid Clasificacion en el create de AlcanceDescuentoClasificacionLocalHome
    */
    public void guardarAlcanceTipoCliente(DTOEAlcanceTipoCliente dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoDTO.guardarAlcanceTipoCliente(): Entrada");

        UtilidadesLog.debug("dto: "+dto);
        DTOOID oidD = new DTOOID();
        oidD.setOid(dto.getOidDescuento());
        oidD.setOidIdioma(dto.getOidIdioma());
        oidD.setOidPais(dto.getOidPais());
        DAODescuento dao = new DAODescuento();
        UtilidadesLog.debug("antes de dao.obtenerDTOAlcanceTipoCliente");
        DTOSAlcanceTipoClienteDTO dtotc  = dao.obtenerDTOAlcanceTipoCliente2(oidD);
        UtilidadesLog.debug("DTOSAlcanceTipoClienteDTO: "+dtotc);        
        RecordSet rsTC = dtotc.getTiposCliente();
        RecordSet rsSTC = dtotc.getSubtiposCliente();
        RecordSet rsAC = dtotc.getAlcanceClasificacion();
        try{
                TipoClienteDescuentoLocalHome tclh = new TipoClienteDescuentoLocalHome();
                SubtipoClienteDescuentoLocalHome stclh = new SubtipoClienteDescuentoLocalHome();
                AlcanceDescuentoClasificacionLocalHome adlh = new AlcanceDescuentoClasificacionLocalHome();
                for (int i = 0 ;i < rsTC.getRowCount(); i++){
                    Object obj = rsTC.getValueAt(i,0);
                    Long oid = null;
                    if (obj != null){
                        oid = UtilidadesDTO.getLong( rsTC.getValueAt(i,0) );
                        tclh.remove(tclh.findByPrimaryKey(oid));
                    }
                }
                for (int i = 0 ;i < rsSTC.getRowCount(); i++){
                    Object obj = rsSTC.getValueAt(i,0);
                    Long oid = null;
                    if (obj != null){
                        oid = UtilidadesDTO.getLong(rsSTC.getValueAt(i,0));
                        stclh.remove(stclh.findByPrimaryKey(oid));
                    }
                }
                for (int i = 0 ;i < rsAC.getRowCount(); i++){
                    Object obj = rsAC.getValueAt(i,0);
                    Long oid = null;
                    if (obj != null){
                        oid = UtilidadesDTO.getLong(rsAC.getValueAt(i,0));
                        adlh.remove(adlh.findByPrimaryKey(oid));
                    }                
                }

                // Creates
                UtilidadesLog.debug("antes de los creates");
                Long[] oids = null;
                
                if (dto.getTipoCliente()!=null){
                  oids = dto.getTipoCliente().getOids();
                  for (int i = 0 ;i < oids.length; i++){
                      if (oids[i] != null)
                          tclh.create(oids[i], dto.getOidDescuento());
                  }
                }
                UtilidadesLog.debug("cree tipoCliente");                
                if(dto.getSubtipoCliente()!= null){
                  oids = dto.getSubtipoCliente().getOids();
                            UtilidadesLog.debug("Tam:  " + oids.length);
                  for (int i = 0 ;i < oids.length; i++){
                                if (oids[i] != null)
                                    stclh.create(dto.getOidDescuento(), oids[i]);
                  }
                }
                UtilidadesLog.debug("cree subtipoCliente");
                Iterator itAl = null;
                UtilidadesLog.debug("antes de if");
                if(dto.getListaDescuentos() != null){
                    itAl =  dto.getListaDescuentos().iterator();
                    while (itAl.hasNext()){
                        DTOEAlcanceClasificacionDTO dtoe = (DTOEAlcanceClasificacionDTO)
                        itAl.next();                    
                        UtilidadesLog.debug("DTOEAlcanceClasificacionDTO:" + dtoe);
                        UtilidadesLog.debug(dtoe.getOidClasificacion());
                        AlcanceDescuentoClasificacionLocal adl = adlh.create(dto.getOidDescuento(),
                        dtoe.getOidClasificacion() );
                        UtilidadesLog.debug("creo cladificacion");
                        // vbongiov -- cambio DTO-08 -- 26/06/2008
                        if (dtoe.getOidTipoClasificacion() != null){
                            adl.setTccl_oid_tipo_clas(dtoe.getOidTipoClasificacion());
                            adlh.merge(adl);
                        }
                        /*if (dtoe.getPorcentajeAdicional() != null){
                            UtilidadesLog.debug(dtoe.getPorcentajeAdicional());                        
                            adl.setVal_porc_adic(dtoe.getPorcentajeAdicional());
                        }*/
                    }
                }
        }  catch (NoResultException fe) {
            UtilidadesLog.error(fe);
            ctx.setRollbackOnly();
            throw new MareException(fe,
            UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ce) {
               UtilidadesLog.error(ce);
               ctx.setRollbackOnly();
               throw new MareException(ce,
                   UtilidadesError.armarCodigoError(
                       CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } 
        UtilidadesLog.info("MONMantenimientoDTO.guardarAlcanceTipoCliente(): Entrada");
    }


/*
 * modificado por Noziglia C.
 * se agrego el campo Oid Clasificacion en el create de AlcanceDescuentoClasificacionLocalHome
 */
    public void guardarAlcanceClasificacion(DTOEAlcanceClasificacionDTO dto) throws MareException {
         UtilidadesLog.info("MONMantenimientoDTO.guardarAlcanceClasificacion(): Entrada");

        AlcanceDescuentoClasificacionLocalHome adclh = new AlcanceDescuentoClasificacionLocalHome();
        
        try {
            adclh.create( dto.getOidDescuento(), dto.getOidClasificacion());
            
            // vbongiov -- cambio DTO-08 -- 26/06/2008            
            /*if(dto.getPorcentajeAdicional() != null){
                adc.setVal_porc_adic(dto.getPorcentajeAdicional());
            }*/

        } catch (PersistenceException ce) {
            UtilidadesLog.error(ce);
            throw new MareException(ce,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
         UtilidadesLog.info("MONMantenimientoDTO.guardarAlcanceClasificacion(): Salida");

    }


    public void guardarAlcanceCliente(DTOEDescuentoCliente dto) throws MareException{
         UtilidadesLog.info("MONMantenimientoDTO.guardarAlcanceCliente(): Entrada");

        try {
            MONClientes cli = MAEEjbLocators.getMONClientesHome().create();
            Long oid = cli.obtenerOidCliente(dto.getOidPais(), dto.getCodigoCliente());
           
            if(oid != null){
                AlcanceDescuentoClienteLocalHome adclh = new AlcanceDescuentoClienteLocalHome();
                AlcanceDescuentoClienteLocal adcl = adclh.create(dto.getOidDescuento(), oid);
                if(dto.getImporteDescuento() != null){
                    UtilidadesLog.debug(dto.getImporteDescuento());
                    adcl.setImp_fijo(dto.getImporteDescuento());
                    adclh.merge(adcl);
                }
                if(dto.getPorcentajeDescuento() != null){
                    UtilidadesLog.debug(dto.getPorcentajeDescuento());                
                    adcl.setVal_porc_desc(dto.getPorcentajeDescuento());
                    adclh.merge(adcl);
                }
            }else{
                            throw new MareException(null,null, 
                        UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_DTO , "",
                            ErroresDeNegocio.NO_EXISTE_EL_CODIGO_DE_CLIENTE_0013));

            }
        } catch (MareException e) {
            UtilidadesLog.error("Error ME",e);
            ctx.setRollbackOnly();
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
         UtilidadesLog.info("MONMantenimientoDTO.guardarAlcanceCliente(): Salida");

    }


    public void guardarAlcanceAdministrativo(DTOEAlcanceAdministrativoDTO dto) throws MareException {
         UtilidadesLog.info("MONMantenimientoDTO.guardarAlcanceAdministrativo(): Entrada");

        DTOOID oidD = new DTOOID();
        oidD.setOid(dto.getOidDescuento());
        oidD.setOidIdioma(dto.getOidIdioma());
        DAODescuento dao = new DAODescuento();
        
        DTOSalida dtos = dao.obtenerDTOAlcanceAdministrativo(oidD);
        RecordSet rs = dtos.getResultado();
        try{
            AlcanceDescuentoAdministrativoLocalHome adalh = new AlcanceDescuentoAdministrativoLocalHome();
            AlcanceDescuentoAdministrativoLocal adal;
            
            for (int i = 0 ;i < rs.getRowCount(); i++){
                Long oid = UtilidadesDTO.getLong( rs.getValueAt(i,0));
                adal = adalh.findByPrimaryKey(oid);
                adalh.remove(adal);
            }
            UtilidadesLog.debug(" AlcanceDescuentoAdministrativo removidos ");
            ArrayList detalles = dto.getDetalle();
            if ((detalles != null) && (detalles.size()>0)) {
                for (int i =  0 ;  i < detalles.size(); i++){
                    UtilidadesLog.debug("Detalle: "+i);
                    DTOAlcanceAdministrativoDetalleDto detdto = 
                    (DTOAlcanceAdministrativoDetalleDto)detalles.get(i);
                    
                    //el create de dos 2 campos no servia, se agrego el que mete los
                    //cuatro campos del la UK. (gacevedo)
                    AlcanceDescuentoAdministrativoLocal ad = 
                    adalh.create(dto.getOidDescuento(), detdto.getOidSubgerencia(), detdto.getOidRegion(), detdto.getOidZona());
                    
                    UtilidadesLog.debug(" AlcanceDescuentoAdministrativo creado");
                    if(detdto.getPorcentajeAdicional() != null){
                        ad.setVal_porc_adic(new Double(detdto.getPorcentajeAdicional().doubleValue()));
                        adalh.merge(ad);
                    }
                }
            }
            /*Agregado de acuerdo al modelo de componentes*/
            DescuentoLocalHome descHome = new DescuentoLocalHome();
            DescuentoLocal dl  = descHome.findByPrimaryKey(dto.getOidDescuento());
            UtilidadesLog.debug("Valor Nacional: " + dto.getNacional());
            boolean bNacional = dto.getNacional().booleanValue(); 
            if ( bNacional ) {
                dl.setInd_naci(new Long(1));
            } else {
                dl.setInd_naci(new Long(0));
            }
            descHome.merge(dl);
            
        } catch (NoResultException e) {
            throw new MareException(e,
            UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            ctx.setRollbackOnly();
            throw new MareException(e,
            UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
         UtilidadesLog.info("MONMantenimientoDTO.guardarAlcanceAdministrativo(): Salida");
    }


    /**
     * Guarda una base aplicacion cabecera y sus detalles segun el dto de entrada.
     */
    public void guardarBaseCalculoDTO(DTOEBaseCalculo dto) throws MareException {
        UtilidadesLog.info(" MONManteniemientoDTO.guardarBaseCalculoDTO(): Entrada ");
        
        Long oidBase = dto.getOidBase();
        Long oid = dto.getOidDescuento();

        UtilidadesLog.debug(" oidBase: " + oidBase );
        UtilidadesLog.debug(" oid: " + oid);
        UtilidadesLog.debug(" DTOEBaseCalculo detalle: " + dto.getDetalle());
        
        BaseCalculoCabeceraLocalHome bclh = new BaseCalculoCabeceraLocalHome();

        if (oidBase != null) {
            try{
                UtilidadesLog.debug("Previo a Find y Remove");
                BaseCalculoCabeceraLocal bcl = bclh.findByPrimaryKey(oidBase);
                bclh.remove(bcl);
            } catch (NoResultException e) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(e);
                throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(e);
                throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_BORRADO_DE_DATOS));
            }
        }
        
        try{
            UtilidadesLog.debug("Create Cabecera Base Calculo con oid: " + oid);
            BaseCalculoCabeceraLocal bcl = bclh.create(oid);
            Long newOidCabeceraBaseCalculo = bcl.getOid();
            UtilidadesLog.debug(" Oid Cabecera newOid: " + newOidCabeceraBaseCalculo);
            BaseCalculoDetalleLocalHome bcdlh = new BaseCalculoDetalleLocalHome();

            ArrayList dets = dto.getDetalle();
          
            for(int i = 0; i < dets.size() ; i++ ){
                UtilidadesLog.debug("Detalle  " + i);
                //Create de cada detalle
                DTOEBaseCalculoDetalle dtoDet = (DTOEBaseCalculoDetalle)dets.get(i);
                UtilidadesLog.debug("Base calculo detalle: " + dtoDet);
                UtilidadesLog.debug(" Llamando al create - BaseCalculoDetalle, con:");
                UtilidadesLog.debug(" dtoDet.getCicloVida: " + dtoDet.getCicloVida());
                UtilidadesLog.debug(" newOidCabecera: " + newOidCabeceraBaseCalculo);
                UtilidadesLog.debug("Seteando tipo oferta:" + dtoDet.getTipoOferta());

                BaseCalculoDetalleLocal bcdl = bcdlh.create(dtoDet.getCicloVida(), 
                                                            newOidCabeceraBaseCalculo,
                                                            dtoDet.getSupergenerico(),
                                                            dtoDet.getProducto(), 
                                                            dtoDet.getGenericos(), 
                                                            dtoDet.getMarca(),
                                                            dtoDet.getUnidadNegocio(), 
                                                            dtoDet.getNegocio(), 
                                                            dtoDet.getTipoOferta() );
                UtilidadesLog.debug("Seteando exclusion tipo oferta:" + dtoDet.getExclusionTipoOferta());
                if ( (dtoDet.getExclusionTipoOferta() != null) && 
                      dtoDet.getExclusionTipoOferta().booleanValue()) {
                    bcdl.setInd_excl_tipo_ofer(new Long(1));
                } else {
                    bcdl.setInd_excl_tipo_ofer(new Long(0));
                }
                bcdlh.merge(bcdl);
            } //for           

        } catch(PersistenceException e) {
            UtilidadesLog.debug("Entre a CreateException");
            ctx.setRollbackOnly();
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info(" MONManteniemientoDTO.guardarBaseCalculoDTO(): Salida ");
    }


    /**
     * 
     */
    public void guardarBaseAplicacionDTO(DTOEBaseAplicacion dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoDTO.guardarBaseAplicacionDTO(): Entrada");
        Long oid = dto.getOidDescuento();                
        Long oidBase = dto.getOidBase();
        UtilidadesLog.debug("oidDecuento: " + oid);
        UtilidadesLog.debug("oidCabeceraBaseAplicacion: " + oidBase);
        BaseAplicacionCabeceraLocalHome baclh= null;
        BaseAplicacionCabeceraLocal bacl= null; 
                
        baclh = new BaseAplicacionCabeceraLocalHome();
        
        if (oidBase != null) {
            try {                            
                bacl = baclh.findByPrimaryKey(oidBase);
                baclh.remove(bacl);              
            } catch (NoResultException e) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(e);
                throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(e);
                throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_BORRADO_DE_DATOS));
           }
        }
        
        try{
            UtilidadesLog.debug("Llamando al create BaseAplicacionCabecera ");
            bacl = baclh.create(oid);
             
            if (dto.getNumeroUnidadesObligatorias()!=null)  {
                UtilidadesLog.debug("Seteando numero unidades obligatorias");
                bacl.setNum_unid_obli(Long.valueOf(dto.getNumeroUnidadesObligatorias().toString()));
                baclh.merge(bacl);
            }            
             
            Long newOidCabeceraBaseAplicacion = bacl.getOid();
            UtilidadesLog.debug("newOidCabeceraBaseAplicacion: " + newOidCabeceraBaseAplicacion);

            ArrayList dets = dto.getDetalle();
            Iterator detsIter = dets.iterator();
            BaseAplicacionDetalleLocalHome badlh  = new BaseAplicacionDetalleLocalHome();
            
            BaseAplicacionDetalleLocal badl = null;             
            
            while (detsIter.hasNext()) {                 
                DTOSBaseAplicacionDetalle det = (DTOSBaseAplicacionDetalle)detsIter.next();                 
                UtilidadesLog.debug("Llamando al create BaseAplicacionDetalle");
                badl = badlh.create(det.getCicloVida(), newOidCabeceraBaseAplicacion, 
                                    det.getSupergenerico(), det.getProducto(), 
                                    det.getGenerico(), det.getMarca(),
                                    det.getUnidadNegocio(), det.getNegocio(), 
                                    det.getTipoOferta() );
                //badl.setTofe_oid_tipo_ofer(det.getTipoOferta());
                UtilidadesLog.debug("Seteando exclusion tipo oferta:" + 
                det.getExclusionTipoOferta());
                if ( (det.getExclusionTipoOferta() != null) && 
                      det.getExclusionTipoOferta().booleanValue()) {
                    badl.setInd_excl_tipo_ofer(new Long(1));
                } else {
                    badl.setInd_excl_tipo_ofer(new Long(0));
                }
                badlh.merge(badl);
            }

            EscalonLocalHome esclh = new EscalonLocalHome();
             
            EscalonLocal escl = null;
            ArrayList esc = dto.getEscalones();
                         
            Iterator escIter = esc.iterator();

            while (escIter.hasNext()) {
                DTOEscalon es = (DTOEscalon)escIter.next();                                 
                UtilidadesLog.debug("Llamando al create - Escalon con: ");
                UtilidadesLog.debug("es.getEscalaDesde " + es.getEscalaDesde());
                UtilidadesLog.debug("es.getPorcentajeDescuento " + es.getPorcentajeDescuento());
                UtilidadesLog.debug("newOidCabeceraBaseAplicacion " + newOidCabeceraBaseAplicacion);
                
                escl = esclh.create(es.getEscalaDesde(), es.getPorcentajeDescuento(), newOidCabeceraBaseAplicacion);
                UtilidadesLog.debug("Seteando escala hasta");                                             
                escl.setVal_hast(es.getEscalaHasta());                        
                esclh.merge(escl);
            }                            
        } catch (PersistenceException e) {
            UtilidadesLog.debug("Entre a CreateException");
            UtilidadesLog.error(e);
            ctx.setRollbackOnly(); 
            throw new MareException(e, UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }		
        UtilidadesLog.info("MONMantenimientoDTO.guardarBaseAplicacionDTO(): Salida");

    }


    public DTOSalida buscarMatricesDTOActivas(DTOSiccPaginacion dto) throws MareException {
        DAOMatrizDescuentos daoMat = new DAOMatrizDescuentos();

        return daoMat.obtenerMatricesDTOActivas(dto);
    }
    
    

    public void eliminarDTOSPorClasificacion(DTOOIDs dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoDTO.eliminarDTOSPorClasificacion(): Entrada");

        for (int i = 0; i < dto.getOids().length; i++) {
            AlcanceDescuentoClasificacionLocalHome descHome = new  AlcanceDescuentoClasificacionLocalHome();
            try {
                AlcanceDescuentoClasificacionLocal bean = 
                descHome.findByPrimaryKey(dto.getOids()[i]);
                descHome.remove(bean);
            } catch (NoResultException e) {
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_BORRADO_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONMantenimientoDTO.eliminarDTOSPorClasificacion(): Salida");
    }


    public void eliminarDescuentosCliente(DTOOIDs dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoDTO.eliminarDescuentosCliente(): Entrada");

        for (int i = 0; i < dto.getOids().length; i++) {
            AlcanceDescuentoClienteLocalHome descHome = new AlcanceDescuentoClienteLocalHome();

            try {
                AlcanceDescuentoClienteLocal bean = 
                descHome.findByPrimaryKey(dto.getOids()[i]);
                descHome.remove(bean);
            } catch (NoResultException e) {
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_BORRADO_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONMantenimientoDTO.eliminarDescuentosCliente(): Salida");
    }


    public void eliminarAlcanceAdministrativoDTO(DTOOIDs dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoDTO.eliminarAlcanceAdministrativoDTO(): Entrada");
        for (int i = 0; i < dto.getOids().length; i++) {
            AlcanceDescuentoAdministrativoLocalHome descHome = new AlcanceDescuentoAdministrativoLocalHome();

            try {
                AlcanceDescuentoAdministrativoLocal bean = 
                descHome.findByPrimaryKey(dto.getOids()[i]);
                descHome.remove(bean);
            } catch (NoResultException e) {
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_BORRADO_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONMantenimientoDTO.eliminarAlcanceAdministrativoDTO(): Salida");
    }


    public DTODescuentoDG consultarDescuentoDG(DTOOID dto)  throws MareException {
        UtilidadesLog.info("MONMantenimientoDTO.consultarDescuentoDG(): Entrada");
        DAODescuento descDAO = new DAODescuento();
        DTODescuentoDG descuento = new  DTODescuentoDG();
        descuento = descDAO.obtenerDescuentoDG(dto);
        Character respuesta = vigenciaDescuento(dto.getOid());
        UtilidadesLog.debug("Pase vigenciaDescuento");        
        descuento.setVigencia(respuesta);
        UtilidadesLog.info("MONMantenimientoDTO.consultarDescuentoDG(): Salida");
        return descuento;
    }


    public DTOSAlcanceTipoClienteDTO consultarAlcanceTipoClienteDTO(DTOOID dto) throws MareException {
        UtilidadesLog.debug("Llego");
        DAODescuento descDAO = new DAODescuento();

        return descDAO.obtenerDTOAlcanceTipoCliente(dto);
    }


    public DTOSalida consultarAlcanceClasificacionDTO( DTOEBuscarAlcanceClasificacionDTO dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoDTO.consultarAlcanceClasificacionDTO(): Entrada");

        DTOSalida dtos  = null;
        try{
            DAODescuento descDAO = new DAODescuento();

            dtos  =descDAO.obtenerDTOAlcanceClasificacion(dto);
        }catch(Exception e){
            UtilidadesLog.error(e);
        }
        UtilidadesLog.info("MONMantenimientoDTO.consultarAlcanceClasificacionDTO(): Salida");
        return dtos;
    }

    public  DTOSPaginaAlcanceTiposClienteDetalle cargarPaginaAlcanceTiposClienteDetalle(DTOEMatrizSubtiposCliente dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoDTO.cargarPaginaAlcanceTiposClienteDetalle(): Entrada");

        DTOSPaginaAlcanceTiposClienteDetalle ret = new DTOSPaginaAlcanceTiposClienteDetalle();
        DAOMatrizDescuentos daomd = new DAOMatrizDescuentos();
        DTOSalida sal = 
        daomd.obtenerTiposClasificacionMultiSubtipoClienteDTOMatrizSeleccionada(dto);
        ret.setTiposClasificacion(sal.getResultado());
         
        ret.setClasificacion(null);
        UtilidadesLog.info("MONMantenimientoDTO.cargarPaginaAlcanceTiposClienteDetalle(): Salida");
     
        return ret;
    }


    public DTOSalida obtenerDescuentosActivos(DTOSiccPaginacion dto) throws MareException {
        DAODescuento dao = new DAODescuento();
        return dao.obtenerDescuentosActivos( dto );
    }


    /**
     * Retorna todos los datos de un Descuento segun el oidDescuento pasado por parametro.
     * Obtiene los datos generales del descuento, Obtiene los datos de alcance tipo cliente, 
     * Obtiene los datos de descuentos a cliente, Obtiene los datos de alcance administrativo,
     * Obtiene los datos de base de cálculo y Obtiene los datos de base de aplicación.
     */
    public DTODescuento obtenerDescuento(DTOOID dto) throws MareException{
        UtilidadesLog.info("MONMantenimientoDTOBean.obtenerDescuento(): Entrada");

        DTODescuento dtoDesc = new DTODescuento(); 
        DTODescuentoDG dtodg =  consultarDescuentoDG(dto);
        dtoDesc.setDatosGenerales(dtodg);

        dtoDesc.setAlcanceTipoCliente(consultarAlcanceTipoClienteDTO(dto));

        DAODescuento dao = new DAODescuento();
        dtoDesc.setDescuentosACliente( dao.obtenerDescuentosACliente(dto.getOid()));

        dtoDesc.setAlcanceAdministrativo(consultarAlcanceAdministrativoDTO(dto).getResultado());

        ArrayList bc = new ArrayList();
        bc.add(consultarBaseCalculoDTO(dto));
        dtoDesc.setBaseCalculo(bc);

        DTOOIDs dtoOids =  consultarBasesAplicacionDTO(dto);
        ArrayList ba = new ArrayList();
        for (int i = 0 ; i < dtoOids.getOids().length; i++){
            DTOOID dtoOid = new DTOOID();
            dtoOid.setOid(dtoOids.getOids()[i]);
            dtoOid.setOidIdioma(dto.getOidIdioma());
            dtoOid.setOidPais(dto.getOidPais());
            ba.add(consultarBaseAplicacionDTO(dtoOid));
        }

        dtoDesc.setBaseAplicacion(ba);
        UtilidadesLog.info("MONMantenimientoDTOBean.obtenerDescuento(): Salida");
        return dtoDesc;
    }


   /*
   * @author  ssaavedr
   * @date    02/11/2005
   * @description construido segun modelo: DMCO-DTO-BELC300014763
   * @throws MareException
   */    
    private DTOListaBasesAplicacionDto consultarListaBasesAplicacionDTO(DTOOID dto)
    throws MareException {
        UtilidadesLog.info("MONMantenimientoDTOBean.consultarListaBasesAplicacionDTO(DTOOID dto): Entrada");

        DAODescuento dao  = new DAODescuento();
        UtilidadesLog.info("MONMantenimientoDTOBean.consultarListaBasesAplicacionDTO(DTOOID dto): Salida");
        
        return dao.obtenerBasesAplicacionDTO(dto);

    }

   /**
   * @author  Adiaz
   * @date    22/11/2005
   * @description construido segun modelo: DMCO-DTO-BELC300014763
   * @throws MareException
   */    
    public DTOOIDs consultarBasesAplicacionDTO(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoDTOBean.consultarBasesAplicacionDTO(DTOOID dto): Entrada");

        DAODescuento dao  = new DAODescuento();
        RecordSet rs = dao.consultarBasesAplicacionDTO(dto.getOid());
        UtilidadesLog.debug("SCS, RS obtenido, desde: consultarBasesAplicacionDTO.....: " + rs);
        Long[] oids = new Long[rs.getRowCount()];
        int records = rs.getRowCount();
        for(int i = 0; i < records; i++){
            oids[i] = UtilidadesDTO.getLong(rs.getValueAt(i,0));
        }
        DTOOIDs dtos = new DTOOIDs();
        dtos.setOids(oids);
        UtilidadesLog.debug("SCS, retorno los oids: " + dtos.getOids());
        UtilidadesLog.info("MONMantenimientoDTOBean.consultarBasesAplicacionDTO(DTOOID dto): Salida");

        return dtos;
    }
    
    /**
     *   Autor: Ssantana
     *   Fecha: 3/11/2004
     *   Descripción Modif: Se agrega validacion tal que la fecha de sistema sea menor a
     *   PeriodoInico.final x inc. 9722 
     */
    private boolean validaPeriodoFechaSistema(PeriodoLocal perio) throws MareException {
        UtilidadesLog.info("MONMantenimientoDTOBean.validaPeriodoFechaSistema(): Entrada");
        java.util.Date fechaPerio = perio.getFechaFin();
        java.util.Date fechaSistema = new java.util.Date();
        
        long perioFin = fechaPerio.getTime();
        long sistema = fechaSistema.getTime();
        
        UtilidadesLog.debug("Fecha Sistema: " + sistema);
        UtilidadesLog.debug("Periodo Fin: " + perioFin);    
        
        boolean retorno = true;
        if (sistema >= perioFin)
        {
            UtilidadesLog.debug("Fecha de sistema > Periodo.Fin - Devuelve false");      
            retorno = false;
        }
            UtilidadesLog.info("MONMantenimientoDTOBean.validaPeriodoFechaSistema(): Salida");
        
        return retorno;
    }


    private Character vigenciaDescuento(Long descuento) throws MareException {
        

        Character respuesta = ConstantesDTO.DESCUENTO_FUTURO;
    try{
        UtilidadesLog.info("MONMantenimientoDTOBean.vigenciaDescuento(): Entrada");
            PeriodoLocal PeriodoFinal = null ;    
            DescuentoLocalHome desc = new DescuentoLocalHome();
            DescuentoLocal des = desc.findByPrimaryKey(descuento);

            PeriodoLocalHome p = new PeriodoLocalHome();
            UtilidadesLog.debug("Periodo Inicial:  " + des.getPerd_oid_peri());            
            PeriodoLocal PeriodoInicial =  p.findByPrimaryKey(des.getPerd_oid_peri());

            if (des.getPerd_oid_peri_limi_fin() != null) {
                UtilidadesLog.debug("Periodo Final:  " + des.getPerd_oid_peri_limi_fin());
                PeriodoFinal =  p.findByPrimaryKey(des.getPerd_oid_peri_limi_fin());
            }

            java.util.Date fechaSistema = new java.util.Date();
                        
            long perioIni = PeriodoInicial.getFechainicio().getTime();
            long sistema = fechaSistema.getTime();

            long perioFin = 0;

            if (PeriodoFinal != null) {
                perioFin = PeriodoFinal.getFechaFin().getTime();
            } else {
                perioFin = 0;
            }

            UtilidadesLog.debug("Fecha Sistema: " + sistema);
            UtilidadesLog.debug("Periodo Inicio: " + perioIni);
            UtilidadesLog.debug("Periodo Final: " + perioFin);


            UtilidadesLog.debug("Fechas Parseadas");
            UtilidadesLog.debug("SERVIDOR: " + fechaSistema);
            UtilidadesLog.debug("APLICACION: "+ PeriodoInicial.getFechainicio());
            
            //(1)Si (PeriodoInicial.fechaIni > fecha del sistema) entonces
            if (perioIni > sistema) {
                respuesta = ConstantesDTO.DESCUENTO_FUTURO;
            } else {
                if (perioFin == 0) {
                        if (perioIni < sistema)
                            respuesta = ConstantesDTO.DESCUENTO_VIGENTE;
                } else {
                    /*(1)Si no Si ( PeriodoInicial.fechaIni <= fecha del sistema 
                            && (PeriodoFinal== NULL || fecha del sistema <= PeriodoFinal.fechaFin)
                            ) entonces
                            
                        Modificado Incidencia BELC300021893 
                    */

                    if ((perioIni <= sistema) && (perioFin == 0 || sistema <= perioFin))
                    {
                        //    -> respuesta = ConstantesDTO.DESCUENTO_VIGENTE
                        respuesta = ConstantesDTO.DESCUENTO_VIGENTE;
                    }
                    else
                    {
                        //(1)Si no Si (fecha del sistema > PeriodoFinal.fechaFin) entonces
                        if(sistema > perioFin)
                        {
                            respuesta = ConstantesDTO.DESCUENTO_CADUCADO;
                        //    -> respuesta = ConstantesDTO.DESCUENTO_CADUCADO
                        }//(2)Fin Si
                    }
                }
            }

            UtilidadesLog.debug("devolviendo:  "+ respuesta);
            UtilidadesLog.info("MONMantenimientoDTOBean.vigenciaDescuento(): Salida");
            return respuesta;
        } catch (NoResultException e) {
            throw new MareException(e,
            UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
    }
    
    
    private void eliminarDescripcion(Long oid) throws MareException {
        UtilidadesLog.info("MONMantenimientoDTOBean.eliminarDescripcion(): Entrada");
	
        Entidadi18nLocalHome entidadi18nLocalHome;
        Entidadi18nLocal entidadi18n;
        Collection grupos = new ArrayList();

        try{
        
                entidadi18nLocalHome = new Entidadi18nLocalHome();			
                grupos = entidadi18nLocalHome.findByEntAtrPK(
                        "DTO_DESCU",
                        new Long(1),
                        oid);

                Iterator it = grupos.iterator();
                while (it.hasNext()){
                        entidadi18n = (Entidadi18nLocal) it.next();
                        entidadi18nLocalHome.remove(entidadi18n);
                }
                
        }catch(NoResultException fe) {
                ctx.setRollbackOnly();
                throw new MareException(fe,
                        UtilidadesError.armarCodigoError( 
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch(PersistenceException re) {
                ctx.setRollbackOnly();
                throw new MareException(re,
                        UtilidadesError.armarCodigoError( 
                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONMantenimientoDTOBean.eliminarDescripcion(): Salida");

    }

  public DTOSalida buscarMatricesDTOActivasREP(DTOBelcorp dto) throws MareException {
      DAOMatrizDescuentos daoMat = new DAOMatrizDescuentos();

      return daoMat.obtenerMatricesDTOActivasREP(dto);
  }
  
  
  /*
   * este metodo crea un descuento para el tipo de premio descuento de incentivos. 
   * 
   * Fecha: 2005/05/30
   * Autor: Dante Castiglione
   */
  public void ingresarDescuentosIncentivos(DTODescuentosIncentivos dtoDes) throws MareException {
    /*
     * 1.- Validar el oidCliente y que se halla especificado un periodo inicial y un porcentaje o importe fijo de descuento.
     * Si no es asi generar una linea de error en el log y terminar con indicación de error.  
     */
    
        UtilidadesLog.info("MONMantenimientoDTOBean.ingresarDescuentosIncentivos(): Entrada");
        ClienteDatosBasicosLocalHome clienHome =  new ClienteDatosBasicosLocalHome();
        try {
          clienHome.findByPrimaryKey(dtoDes.getOidCliente());
          if (dtoDes.getOidPeriodoInicial() == null){
            UtilidadesLog.debug("Atributo OIDPeriodoInicial no informado en DTODescuentosIncentivos");
            // BELC300020339 
            throw new MareException(null, null,UtilidadesError.armarCodigoError(
            ConstantesSEG.MODULO_INC + 
            es.indra.sicc.logicanegocio.inc.ErroresDeNegocio.INC_0039)); 
            
          }
          if (dtoDes.getPorcentaje() == null && dtoDes.getImporte() == null){
            UtilidadesLog.debug("Atributos Porcentaje e Importe no informados en DTODescuentosIncentivos");
            // BELC300020339
            throw new MareException(null, null,UtilidadesError.armarCodigoError(
            ConstantesSEG.MODULO_INC + es.indra.sicc.logicanegocio.inc.ErroresDeNegocio.INC_0039)); 
          }
        } catch (NoResultException fe) {
              UtilidadesLog.debug("MONMantenimientoDTOBean metodo ingresarDescuentosIncentivos, no se encontro el oidCliente : " + dtoDes.getOidCliente());
              throw new MareException(fe, UtilidadesError.armarCodigoError(
              CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        /*
         * 2.- Hacer un create de la entidad DTO:Descuento (descuento)
         */
        DAODescuento dAODescuento = new DAODescuento();
        
        int numeroCorrelativo = dAODescuento.ultimoNumeroCorrelativo(
        dtoDes.getOidPais(), dtoDes.getOidMarca(), 
        dtoDes.getOidCanal()).intValue();
        numeroCorrelativo = numeroCorrelativo + 1;
        
        int numeroDescuento = dAODescuento.ultimoNumeroDescuentoPais(
        dtoDes.getOidPais()).intValue();
        numeroDescuento = numeroDescuento + 1;
        
        Long indComunicacionAutomatica;
        if (dtoDes.getIndComunicacionAutomatica().booleanValue() == false)
        {
          indComunicacionAutomatica = new Long(0);
        } else {
          indComunicacionAutomatica = new Long(1);
        }
        
        DescuentoLocalHome descuentoHome = new DescuentoLocalHome(); 
        DescuentoLocal descuento;
        
        try {
          descuento = descuentoHome.create(dtoDes.getOidPeriodoInicial(),
                                           dtoDes.getOidCanal(),
                                           dtoDes.getOidMarca(),
                                           new Long(1),
                                           new Long(1),
                                           new Long(0),
                                           indComunicacionAutomatica,
                                           new Long(1),
                                           new Long(0),
                                           new Long(1),
                                           new Long(0),
                                           new Long(0),
                                           new Long(0),
                                           new Long(1),
                                           dtoDes.getOidPais(),
                                           new Long(numeroCorrelativo),
                                           new Long(numeroDescuento)
                                          );
        } catch (PersistenceException ce) {
              throw new MareException(ce, UtilidadesError.armarCodigoError(
              CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        descuento.setPerd_oid_peri_limi_fin(dtoDes.getOidPeriodoFinal());
        descuentoHome.merge(descuento);
        
        try {
            Entidadi18nLocalHome entidadi18nLocalHome = new Entidadi18nLocalHome();
            entidadi18nLocalHome.create("DTO_DESCU", 
                                        new Long(1), 
                                        dtoDes.getOidIdioma(),
                                        ConstantesDTO.NOMBRE_DESCUENTO_ESPECIAL_CLIENTE + dtoDes.getOidCliente(),
                                        descuento.getOid());
        } catch (PersistenceException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        /*
         * 3.- Hacer un create de la entidad DTO:AccesoDescuento (accesoDes)
         */
        AccesoDescuentoLocalHome accesodescuentoHome = new AccesoDescuentoLocalHome();
        if (dtoDes.getOidAcceso() != null) {
            UtilidadesLog.debug("dtoDes.getOidAcceso(): " + dtoDes.getOidAcceso());
            try {
                int cant = dtoDes.getOidAcceso().length;
                Long[] oidAccesos= dtoDes.getOidAcceso();
                
                for(int i=0; i<cant; i++)  {
                    accesodescuentoHome.create(descuento.getOid(), oidAccesos[i]);
                }
                
            } catch (PersistenceException ce) {
                  throw new MareException(ce, UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        
        /*
         * INC-86 jrivas 18/4/2006
         * 3.5.- Hacer un create de la entidad DTO:DescuentoPorCliente
         */
        AlcanceDescuentoClienteLocalHome adclh = new AlcanceDescuentoClienteLocalHome();
        try {
           AlcanceDescuentoClienteLocal adcl = adclh.create(descuento.getOid(), dtoDes.getOidCliente());
    
            if(dtoDes.getImporte() != null){
                adcl.setImp_fijo(new Double(dtoDes.getImporte().doubleValue())); 
            }
            if(dtoDes.getPorcentaje() != null){
                adcl.setVal_porc_desc(new Double(dtoDes.getPorcentaje().doubleValue()));
            }
            adclh.merge(adcl);
        } catch (PersistenceException ce) {
              throw new MareException(ce, UtilidadesError.armarCodigoError(
              CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        /*
         * 4.- Guardar la base de calculo en las tablas de cabecera y detalle. 
         */
        // Obtiene los ciclos de vida
        // vbongiov - 10/05/2006 - DBLG5000000664
        PREConsultas preConsultas = new PREConsultas();        
        DTOSalida dtoSal = preConsultas.obtenerCiclosVida(dtoDes);
        RecordSet resultado = dtoSal.getResultado();
        int cantReg = resultado.getRowCount();
         
        BaseCalculoCabeceraLocalHome baseCalculoCabeceraHome = new BaseCalculoCabeceraLocalHome();
        BaseCalculoCabeceraLocal baseCalculoCabecera;
        try {
              baseCalculoCabecera = baseCalculoCabeceraHome.create(descuento.getOid());
        } catch (PersistenceException ce) {
              throw new MareException(ce, UtilidadesError.armarCodigoError(
              CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("dtoDes.getProductos(): " + dtoDes.getProductos());
        
        Iterator productosCalculo = dtoDes.getProductos().iterator();
        
        while (productosCalculo.hasNext()){
          DTOProductoDescuento desProd = (DTOProductoDescuento) productosCalculo.next();
          BaseCalculoDetalleLocalHome baseCalculoDetalleHome = new BaseCalculoDetalleLocalHome();
          BaseCalculoDetalleLocal baseCalculoDetalle;
          
          for(int i=0;i < cantReg; i++){
              try {
                  baseCalculoDetalle = baseCalculoDetalleHome.create(new Long(((BigDecimal)resultado.getValueAt(i, "OID_CICL_VIDA")).toString()),
                                                                     baseCalculoCabecera.getOid(),
                                                                     desProd.getOidSuperGenerico(),
                                                                     desProd.getOidProducto(),
                                                                     desProd.getOidGenerico(),
                                                                     desProd.getOidMarcaProducto(),
                                                                     desProd.getOidUnidadNegocio(),
                                                                     desProd.getOidNegocio(), null);
                                                                     
                  baseCalculoDetalle.setInd_excl_tipo_ofer(new Long(1));
                  baseCalculoDetalleHome.merge(baseCalculoDetalle);
                
              } catch (PersistenceException ce) {
                throw new MareException(ce, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
              }
          }
        }
        
        /*
         * 5.- Guardar la base de aplicacion 
         */
        BaseAplicacionCabeceraLocalHome baseAplicacionCabeceraHome = new BaseAplicacionCabeceraLocalHome();
        BaseAplicacionCabeceraLocal baseAplicacionCabecera;
        try {
              baseAplicacionCabecera = baseAplicacionCabeceraHome.create(descuento.getOid());
        } catch (PersistenceException ce) {
              throw new MareException(ce, UtilidadesError.armarCodigoError(
              CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        Iterator productosAplicacion = dtoDes.getProductos().iterator();
        while (productosAplicacion.hasNext()) {
          DTOProductoDescuento desProd = (DTOProductoDescuento) productosAplicacion.next();
          BaseAplicacionDetalleLocalHome baseAplicacionDetalleHome = new BaseAplicacionDetalleLocalHome();
          BaseAplicacionDetalleLocal baseAplicacionDetalle;
          try {
            baseAplicacionDetalle = baseAplicacionDetalleHome.create(ConstantesPRE.CICLO_VIDA_00,
                                                                     baseAplicacionCabecera.getOid(),
                                                                     desProd.getOidSuperGenerico(),
                                                                     desProd.getOidProducto(),
                                                                     desProd.getOidGenerico(),
                                                                     desProd.getOidMarcaProducto(),
                                                                     desProd.getOidUnidadNegocio(),
                                                                     desProd.getOidNegocio(),
                                                                     null);
                                                                     
            baseAplicacionDetalle.setInd_excl_tipo_ofer(new Long(1));
            baseAplicacionDetalleHome.merge(baseAplicacionDetalle);
            
          } catch (PersistenceException ce) {
            throw new MareException(ce, UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
          }
        }
        UtilidadesLog.info("MONMantenimientoDTOBean.ingresarDescuentosIncentivos(): Salida");

  }


    /**
     * @author  vconte
     * @date    21/11/2005
     * @throws MareException
     */    
  
    public DTODescuentoCliente obtenerAlcanceClienteDetalle(DTOCodigoClienteDto dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoDTOBean.obtenerAlcanceClienteDetalle(DTOCodigoClienteDto dtoe): Entrada");
        ClienteDatosBasicosLocalHome clienHome = new ClienteDatosBasicosLocalHome();
        ClienteDatosBasicosLocal clienLocal = null;
        try {
          clienLocal = clienHome.findByCodigoYPais(dtoe.getOid(), dtoe.getCodigo());
        } catch (NoResultException fe) {
          UtilidadesLog.debug("MONMantenimientoDTOBean metodo ingresarDescuentosIncentivos, no se encontro el codigo/oid : " + dtoe.getCodigo() + "/" + dtoe.getOid());
          throw new MareException(fe, UtilidadesError.armarCodigoError(
          CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        if (clienLocal != null)
        {
            DTODescuentoCliente dtoDC = new DTODescuentoCliente();
            dtoDC.setCodigoCliente(dtoe.getCodigo());
            
            String auxNomb1 = null;
            String auxNomb2 = null;
            String auxApe1 = null;
            String auxApe2 = null;
            
            if (clienLocal.getVal_nom1() != null) {
                auxNomb1 = String.valueOf(clienLocal.getVal_nom1());
            }else{
                auxNomb1 = new String(" ");
            }
            if (clienLocal.getVal_nom1() != null) {
                auxNomb2 = String.valueOf(clienLocal.getVal_nom2());
            }else{
                auxNomb2 = new String(" ");
            }

            if (clienLocal.getVal_nom1() != null) {
                auxApe1 = String.valueOf(clienLocal.getVal_ape1());
            }else{
                auxApe1 = new String(" ");
            }
            if (clienLocal.getVal_nom1() != null) {
                auxApe2 = String.valueOf(clienLocal.getVal_ape2());
            }else{
                auxApe2 = new String(" ");
            }
            
            dtoDC.setNombre(auxNomb1.concat(auxNomb2));
            dtoDC.setApellidos(auxApe1.concat(auxApe2));
            UtilidadesLog.debug("retorno el dto: " + dtoDC);
            UtilidadesLog.info("MONMantenimientoDTOBean.obtenerAlcanceClienteDetalle(DTOCodigoClienteDto dtoe): Salida");
            return dtoDC;
        } else {
          UtilidadesLog.debug("retorno nulo!");
          UtilidadesLog.info("MONMantenimientoDTOBean.obtenerAlcanceClienteDetalle(DTOCodigoClienteDto dtoe): Salida");
          return null;
        }  
        
    }
    
    /**
    * @author  vconte
    * @date    21/11/2005
    * @throws MareException
    */    
    public void guardarDatosDescuento(DTOGlobalDescuento dtoe) throws MareException
    {
      try{
        UtilidadesLog.info("MONMantenimientoDTOBean.guardarDatosDescuento(DTOGlobalDescuento dtoe): Entrada");
        DTOOID dtoOID = this.guardarDescuentoDG(dtoe);
        
        UtilidadesLog.debug("SCS, indicadores.................");
        UtilidadesLog.debug("SCS, IndAlcanceTipoCliente() : " + 
        dtoe.getIndAlcanceTipoCliente().booleanValue());
        
        UtilidadesLog.debug("SCS, IndAlcanceCliente() : " + 
        dtoe.getIndAlcanceCliente().booleanValue());
        UtilidadesLog.debug("SCS, la lista Al. Clte. es: " + 
        dtoe.getAlcanceCliente());
        
        UtilidadesLog.debug("SCS, IndAlcanceAdministrativo() : " + 
        dtoe.getIndAlcanceAdministrativo().booleanValue());
        UtilidadesLog.debug("SCS, IndBaseCalculo() : " + 
        dtoe.getIndBaseCalculo().booleanValue());
        UtilidadesLog.debug("SCS, IndBaseAplicacion() : " + 
        dtoe.getIndBaseAplicacion().booleanValue());
        
        if (dtoe.getIndAlcanceTipoCliente().booleanValue())
        {
                        
            dtoe.getAlcanceTipoCliente().setOidDescuento(dtoOID.getOid());
            UtilidadesLog.debug("SCS, tengo IndAlcanceTipoCliente(), voy a guardarAlcanceTipoCliente, con: " + dtoe.getAlcanceTipoCliente());
            this.guardarAlcanceTipoCliente(dtoe.getAlcanceTipoCliente());
        }
        if (dtoe.getIndAlcanceCliente().booleanValue())
        {
            dtoe.getAlcanceCliente().setOidDescuento(dtoOID.getOid());
            UtilidadesLog.debug("SCS, tengo IndAlcanceCliente(), voy a guardarListaAlcanceCliente, con: " + dtoe.getAlcanceCliente());
            this.guardarListaAlcanceCliente(dtoe.getAlcanceCliente());
        }
        if (dtoe.getIndAlcanceAdministrativo().booleanValue())
        {   
        
            //Agregado por incidencia DBLG400000506 por pzerbino 02/02/2006
            UtilidadesLog.info("adentro de dtoe.getIndAlcanceAdministrativo.... ");    
            DTOEAlcanceAdministrativoDTO dtoEAA = new DTOEAlcanceAdministrativoDTO();
            dtoEAA.setOidDescuento(dtoOID.getOid());
            dtoEAA.setNacional(dtoe.getDatosGralesDto().getNacional());
            DTOAlcanceAdministrativoDetalleDto[] listaDetalle = null;
            if (dtoe.getAlcanceAdministrativo() != null){  
              UtilidadesLog.info("estoy dentro del getalcance admnistrativo "); 
              if(dtoe.getAlcanceAdministrativo().getDetalle() != null){
                listaDetalle = dtoe.getAlcanceAdministrativo().getDetalle();
              }
            } 
            UtilidadesLog.info("setee datos ...2.... "); 
            
            ArrayList auxListaDetalle = new ArrayList();
            
            if ((listaDetalle != null) && (listaDetalle.length > 0)) {
                int lenDeta = listaDetalle.length;
                for (int i = 0; i < lenDeta; i++) {
                    // SAPAZA - DBLG700000249 - 09/02/2007
                    UtilidadesLog.debug("SCS, tengo IndAlcanceAdministrativo(), listaDetalle["+i+"] es: " + listaDetalle[i]);    
                    
                    DTOAlcanceAdministrativoDetalleDto auxDetalle = new DTOAlcanceAdministrativoDetalleDto();
                    DTOAlcanceAdministrativoDetalleDto registro = listaDetalle[i];
                    auxDetalle.setOidSubgerencia(registro.getOidSubgerencia());
                    auxDetalle.setOidRegion(registro.getOidRegion());
                    auxDetalle.setOidZona(registro.getOidZona());
                    auxDetalle.setPorcentajeAdicional(registro.getPorcentajeAdicional());
                    
                    auxListaDetalle.add(auxDetalle);
                }    
                dtoEAA.setDetalle(auxListaDetalle);
            }
            UtilidadesLog.debug("SCS, voy a guardarAlcanceAdministrativo(..con : " + dtoEAA);
            this.guardarAlcanceAdministrativo(dtoEAA);
        }
        if (dtoe.getIndBaseCalculo().booleanValue())
        {
            DTOEBaseCalculo dtoEBC = new DTOEBaseCalculo ();        
            dtoEBC.setOidDescuento(dtoOID.getOid());
            
            ArrayList auxListaDetalle = new ArrayList();
            
            dtoEBC.setDetalle(dtoe.getBaseCalculo().getDetalle());
            dtoEBC.setIpCliente(dtoe.getBaseCalculo().getIpCliente());
            dtoEBC.setOidBase(dtoe.getBaseCalculo().getOidBase());
            dtoEBC.setOidIdioma(dtoe.getBaseCalculo().getOidIdioma());
            dtoEBC.setOidPais(dtoe.getBaseCalculo().getOidPais());
            dtoEBC.setPrograma(dtoe.getBaseCalculo().getPrograma());
            
            UtilidadesLog.debug("SCS, tengo IndBaseCalculo, base calculo detalle, es : " + dtoe.getBaseCalculo().getDetalle());
            
            if ((dtoe.getBaseCalculo().getDetalle() != null) && 
                (dtoe.getBaseCalculo().getDetalle().size() > 0)) {
                int detaSize = dtoe.getBaseCalculo().getDetalle().size();
                for (int i = 0; i < detaSize; i++) {
                    DTOEBaseCalculoDetalle auxDetalle = new DTOEBaseCalculoDetalle();
                    DTOSBaseCalculoDetalle registro = (DTOSBaseCalculoDetalle) dtoe.getBaseCalculo().getDetalle().get(i);
                    
                    auxDetalle.setCicloVida(registro.getCicloVida());
                    auxDetalle.setExclusionTipoOferta(registro.getExclusionTipoOferta());
                    auxDetalle.setGenericos(registro.getGenerico());
                    auxDetalle.setMarca(registro.getMarca());
                    auxDetalle.setNegocio(registro.getNegocio());
                    auxDetalle.setOidBase(dtoe.getBaseCalculo().getOidBase());
                    auxDetalle.setOidDescuento(dtoe.getDatosGralesDto().getOidDescuento());
                    auxDetalle.setProducto(registro.getProducto());
                    auxDetalle.setSupergenerico(registro.getSupergenerico());
                    auxDetalle.setTipoOferta(registro.getTipoOferta());
                    auxDetalle.setUnidadNegocio(registro.getUnidadNegocio());
                    
                    auxListaDetalle.add(auxDetalle);
                
                }
                
                dtoEBC.setDetalle(auxListaDetalle);
            }    
            UtilidadesLog.debug("SCS, dtoEBC.detalle, es: " + dtoEBC.getDetalle());
            UtilidadesLog.debug("SCS, voy a guardarBaseCalculoDTO, con: " + dtoEBC);
            this.guardarBaseCalculoDTO(dtoEBC);
        }
        if (dtoe.getIndBaseAplicacion().booleanValue())
        {
            if ((dtoe.getBasesAplicacion().getBasesAplicacion() != null) && 
                (dtoe.getBasesAplicacion().getBasesAplicacion().length > 0)) {
                DTOSBaseAplicacion[] listaDetalle = 
                dtoe.getBasesAplicacion().getBasesAplicacion();
                DTOEBaseAplicacion dtoEBA = new  DTOEBaseAplicacion();
                
                UtilidadesLog.debug("SCS, tengo IndBaseAplicacion..., listadetalle es: " + listaDetalle.length);
                
                int listaLen = listaDetalle.length;
                for (int k = 0; k < listaLen; k++) {
                    DTOSBaseAplicacion registro = listaDetalle[k];
                    
                    registro.setOidDescuento(dtoOID.getOid());
                    
                    dtoEBA.setIpCliente(registro.getIpCliente());
                    dtoEBA.setNumeroUnidadesObligatorias(
                    registro.getNumeroUnidadesObligatorias());
                    dtoEBA.setOidBase(registro.getOidBase());
                    dtoEBA.setOidDescuento(registro.getOidDescuento());
                    dtoEBA.setOidIdioma(registro.getOidIdioma());
                    dtoEBA.setOidPais(registro.getOidPais());
                    
                    UtilidadesLog.debug("SCS, registro.getDetalle() es: " + 
                    registro.getDetalle());
                    
                    dtoEBA.setDetalle(new ArrayList());
                
                    int regSize = registro.getDetalle().size();
                    for (int i = 0; i < regSize; i++) {
                        DTOSBaseAplicacionDetalle registroS = 
                        (DTOSBaseAplicacionDetalle) registro.getDetalle().get(i);    
                        DTOSBaseAplicacionDetalle registroE = new DTOSBaseAplicacionDetalle(); 
                        
                        registroE.setCicloVida(registroS.getCicloVida());
                        registroE.setExclusionTipoOferta(registroS.getExclusionTipoOferta());
                        registroE.setGenerico(registroS.getGenerico());
                        registroE.setIpCliente(registroS.getIpCliente());
                        registroE.setMarca(registroS.getMarca());
                        registroE.setNegocio(registroS.getNegocio());
                        registroE.setOidIdioma(registroS.getOidIdioma());
                        registroE.setOidPais(registroS.getOidPais());
                        registroE.setProducto(registroS.getProducto());
                        registroE.setSupergenerico(registroS.getSupergenerico());
                        registroE.setTipoOferta(registroS.getTipoOferta());
                        registroE.setUnidadNegocio(registroS.getUnidadNegocio());
                        
                        dtoEBA.getDetalle().add(i, registroE);
                        
                    }
                    
                    UtilidadesLog.debug("SCS, registro.getEscalones() es: " + 
                    registro.getEscalones());
                    
                    dtoEBA.setEscalones(new ArrayList());
                    int escSize = registro.getEscalones().size();
                    for (int l = 0; l < escSize; l++) {
                        DTOEscalon registroEscalonS = (DTOEscalon) registro.getEscalones().get(l);    

                        DTOEscalon registroEscalonE = new DTOEscalon();
                        registroEscalonE.setEscalaDesde(registroEscalonS.getEscalaDesde());
                        registroEscalonE.setEscalaHasta(registroEscalonS.getEscalaHasta());
                        registroEscalonE.setOidEscalon(registroEscalonS.getOidEscalon());
                        registroEscalonE.setPorcentajeDescuento(
                        registroEscalonS.getPorcentajeDescuento());
                    
                        dtoEBA.getEscalones().add(l, registroEscalonE);
                    }
                    
                    UtilidadesLog.debug("SCS, voy a guardarBaseAplicacionDTO(...,con : " + dtoEBA);
                    this.guardarBaseAplicacionDTO(dtoEBA);
                
                }
            }

        }

      } catch (Exception ex) {
          UtilidadesLog.error("ERROR: ", ex);
          ex.printStackTrace();
          throw new MareException(ex);
      } 
        
        UtilidadesLog.info("MONMantenimientoDTOBean.guardarDatosDescuento(DTOGlobalDescuento dtoe): Salida");
        
    }
    
    /**
    * @author  Wancho
    * @date    21/11/2005
    * @description construido segun modelo: DMCO-DTO-BELC300014763
    * @throws MareException
    */    
    public void guardarListaAlcanceCliente(DTOListaDescuentoCliente dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoDTOBean.guardarListaAlcanceCliente(DTOListaDescuentoCliente dto): Entrada");
        // Se eliminan primero los alcances de cliente existentes
        DTODescuentoCliente[] listaAlcClte = dto.getAlcanceCliente();
        UtilidadesLog.debug("SCS, listaAlcClte es: " + listaAlcClte);
        
        AlcanceDescuentoClienteLocalHome adclh = new AlcanceDescuentoClienteLocalHome();
        Collection alcanceDescuentoParaOid = new ArrayList();
        //si el oid de descuento viene no nulo, borro todos los registros para ese oid
        if (dto.getOidDescuento() != null) {
            try {                
                alcanceDescuentoParaOid = adclh.findByOidDescuento(dto.getOidDescuento());
                UtilidadesLog.debug("SCS, encontre data en Alcance Descuento Cliente, para oid de descuento: " + dto.getOidDescuento());
            } catch (NoResultException e) {
                UtilidadesLog.debug("SCS, NO encontre data en Alcance Descuento Cliente, para oid de descuento: " + dto.getOidDescuento());
            }

            AlcanceDescuentoClienteLocal adcl;
            Iterator it = alcanceDescuentoParaOid.iterator();
            while (it.hasNext()){
                adcl = (AlcanceDescuentoClienteLocal) it.next();
                try {
                    adclh.remove(adcl);
                    UtilidadesLog.debug("SCS, removi...");
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
            }            
                
        }
        
        if ((listaAlcClte != null) && (listaAlcClte.length > 0)) {
            // Ahora se agregan todos los alcances
            
            Double aux = new Double(0);
            UtilidadesLog.debug("SCS, voy a recorrer listaAlcClte, la misma es: " + 
            listaAlcClte);
            int listaLen = listaAlcClte.length;
            for (int i = 0; i < listaLen; i++) {
                DTOEDescuentoCliente dtoEDC = new DTOEDescuentoCliente();
                
                dtoEDC.setOidDescuento(dto.getOidDescuento());
                DTODescuentoCliente registro = listaAlcClte[i];
                
                UtilidadesLog.debug("SCS, registro es: " + registro);
                
                dtoEDC.setCodigoCliente(registro.getCodigoCliente());
                
                if (registro.getImporteDescuento()!=null)
                {
                    dtoEDC.setImporteDescuento(registro.getImporteDescuento());
                }
                  
                dtoEDC.setOidDescuento(dto.getOidDescuento());

                if (registro.getPorcentajeDescuento()!=null)
                {
                    dtoEDC.setPorcentajeDescuento(aux.valueOf(
                    new String(registro.getPorcentajeDescuento().toString())));
                }
                
                dtoEDC.setOidPais(dto.getOidPais());
                dtoEDC.setOidIdioma(dto.getOidIdioma());
                
                this.guardarAlcanceCliente(dtoEDC);
            }
                
        }
        
        UtilidadesLog.info("MONMantenimientoDTOBean.guardarListaAlcanceCliente(DTOListaDescuentoCliente dto): Salida");
    }

    /**
    * @author  vconte
    * @date    21/11/2005
    * @throws MareException
    */    
    public DTOGlobalDescuento obtenerDatosDescuentos(DTOOID dtoe) throws MareException
    {
        UtilidadesLog.info("MONMantenimientoDTOBean.obtenerDatosDescuentos(DTOOID dtoe): Entrada");
        
        DTOGlobalDescuento dtoDescuento = new DTOGlobalDescuento();
        // Se hacen las llamadas a los distintos métodos para traer los datos relacionados con cada una de las pestañas 
        
        // Pestaña 'Datos Generales' 
        dtoDescuento.setDatosGralesDto(this.consultarDescuentoDG(dtoe));
        UtilidadesLog.debug("SCS, de this.consultarDescuentoDG(dtoe), obtengo: " + 
        dtoDescuento.getDatosGralesDto());
        // Se setea el indicador de la pestaña
        if (dtoDescuento.getDatosGralesDto() != null)
            dtoDescuento.setIndDatosGralesDto(Boolean.TRUE);    
        else
            dtoDescuento.setIndDatosGralesDto(Boolean.FALSE);    
        
        
        // Para la pestaña 'Alcance Tipo Cliente' se hace un pasaje de la información obtenida un 
        //tipo de DTO a el tipo de DTO que existe dentro de DTOGlobalDescuento 
        DTOEAlcanceTipoCliente  dtoATC = new DTOEAlcanceTipoCliente();
        dtoATC.setOidDescuento(dtoe.getOid());
        dtoATC.setOidIdioma(dtoe.getOidIdioma());
        dtoATC.setOidPais(dtoe.getOidPais());
        
        DTOSAlcanceTipoClienteDTO consulta = this.consultarAlcanceTipoClienteDTO(dtoe);
        RecordSet rsATCdto = consulta.getTiposCliente();
        RecordSet rsSTCdto = consulta.getSubtiposCliente();
        RecordSet rsAC = consulta.getAlcanceClasificacion();
        
        UtilidadesLog.debug("SCS, rsATCdto es: " + rsATCdto);
        UtilidadesLog.debug("SCS, rsSTCdto es: " + rsSTCdto);
        UtilidadesLog.debug("SCS, rsAC es: " + rsAC);
        
        if ((rsATCdto != null) && (rsATCdto.getRowCount()>0))
        { 
            DTOOIDs dtoOIDS = new DTOOIDs();
            Long[] arrIDS = new Long[rsATCdto.getRowCount()];
            int pos = 0;
            ArrayList descripciones = new ArrayList();
            int rowsCnt = rsATCdto.getRowCount();
            while (pos < rowsCnt) {   
            
                if(rsATCdto.getValueAt(pos,0)!=null)
                {
                    arrIDS[pos] = Long.valueOf(((BigDecimal)
                    rsATCdto.getValueAt(pos,0)).toString());
                }

                if(rsATCdto.getValueAt(pos,1)!=null)
                {  
                    descripciones.add(pos, rsATCdto.getValueAt(pos,1));
                }
            
                pos++;
            }
            UtilidadesLog.debug("SCS, arrIDS, queda: " + arrIDS);
            UtilidadesLog.debug("SCS, dtoOIDS, queda: " + dtoOIDS);
            UtilidadesLog.debug("SCS, arrIDS, descripciones: " + descripciones);
            
            dtoOIDS.setOids(arrIDS);
            dtoATC.setTipoCliente(dtoOIDS);
            dtoATC.setDescTipoCliente(descripciones);
        }
        
        if ((rsSTCdto != null) && (rsSTCdto.getRowCount()>0))   
        { 
            DTOOIDs dtoOIDS1 = new DTOOIDs();
            Long[] arrIDS1 = new Long[rsSTCdto.getRowCount()];
            int pos1 = 0;
            ArrayList descripciones1 = new ArrayList();
            int records = rsSTCdto.getRowCount();
            while (pos1 < records) {   
            
                if(rsSTCdto.getValueAt(pos1,0)!=null)
                {
                    arrIDS1[pos1] = Long.valueOf(((BigDecimal)
                    rsSTCdto.getValueAt(pos1,0)).toString());
                }

                if(rsSTCdto.getValueAt(pos1,1)!=null)
                {  
                    descripciones1.add(pos1, rsSTCdto.getValueAt(pos1,1));
                }
            
                pos1++;
            }
            UtilidadesLog.debug("SCS, arrIDS, queda: " + arrIDS1);
            UtilidadesLog.debug("SCS, dtoOIDS, queda: " + dtoOIDS1);
            UtilidadesLog.debug("SCS, arrIDS, descripciones: " + descripciones1);
            
            dtoOIDS1.setOids(arrIDS1);
            dtoATC.setSubtipoCliente(dtoOIDS1);
            dtoATC.setDescSubTipoCliente(descripciones1);
        }
        
        if ((rsAC != null) && (rsAC.getRowCount()>0))
        {
            DTOEAlcanceClasificacionDTO  dtoACdto = null;
            ArrayList listaDesctos = new ArrayList();

            int pos2 = 0;
            int records = rsAC.getRowCount();
            while (pos2 < records) {   
            
                dtoACdto = new DTOEAlcanceClasificacionDTO();

                if(rsAC.getValueAt(pos2,0)!=null)
                {
                    dtoACdto.setOidClasificacion(Long.valueOf(((BigDecimal)
                    rsAC.getValueAt(pos2,0)).toString()));
                }

                if(rsAC.getValueAt(pos2,3)!=null)
                {  
                    dtoACdto.setPorcentajeAdicional(Double.valueOf(((BigDecimal)
                    rsAC.getValueAt(pos2,3)).toString()));
                }
                
                if(rsAC.getValueAt(pos2,4)!=null)
                {  
                    dtoACdto.setOidTipoClasificacion(Long.valueOf(((BigDecimal)
                    rsAC.getValueAt(pos2,4)).toString()));
                }
                
                //descripciones
                if(rsAC.getValueAt(pos2,1)!=null)
                {
                    dtoACdto.setDescClasificacion(rsAC.getValueAt(pos2,1).toString());
                }
                if(rsAC.getValueAt(pos2,2)!=null)
                {  
                    dtoACdto.setDescTipoClasificacion(rsAC.getValueAt(pos2,2).toString());
                }
                
                listaDesctos.add(dtoACdto);
                pos2++;
            }
        
            UtilidadesLog.debug("SCS, listaDesctos es: " + listaDesctos);
            dtoATC.setListaDescuentos(listaDesctos);
        }
        
        UtilidadesLog.debug("SCS, dtoATC es: " + dtoATC);
        dtoDescuento.setAlcanceTipoCliente(dtoATC);


        if (consulta.getTiposCliente() ==null || 
            consulta.getTiposCliente().esVacio() || 
            consulta.getTiposCliente().getValueAt(0,0) == null ) {
            dtoDescuento.setIndAlcanceTipoCliente(Boolean.FALSE);    
        } else {
            dtoDescuento.setIndAlcanceTipoCliente(Boolean.TRUE);    
        }
        
        
        // Para la pestaña 'AlcanceTipoCliente - Nivel Cliente' se hace un pasaje de la 
        //información obtenida un tipo de DTO a el tipo de DTO que existe dentro de DTOGlobalDescuento 

        DTOListaDescuentoCliente listaDtoCliente = new DTOListaDescuentoCliente();
        DTOEBuscarAlcanceClienteDTO dtoBusqueda = new DTOEBuscarAlcanceClienteDTO();
       
        dtoBusqueda.setOidIdioma(dtoe.getOidIdioma());
        dtoBusqueda.setOidPais(dtoe.getOidPais());
        dtoBusqueda.setOidDescuento(dtoe.getOid());
       
        DTOSalida dtoSAL = this.consultarAlcanceClienteDTO(dtoBusqueda);
        UtilidadesLog.debug("SCS, dtoSAL es: " + dtoSAL);
       
        if ((dtoSAL.getResultado() != null) && (dtoSAL.getResultado().getRowCount() > 0))
        {
            DTODescuentoCliente[] arrDTODesctoClte = 
            new DTODescuentoCliente[dtoSAL.getResultado().getRowCount()];
            int pos3 = 0;
            Long pais = new Long(1);
            int rows = dtoSAL.getResultado().getRowCount();
            while (pos3 < rows) {   
            
                DTODescuentoCliente elemento = new DTODescuentoCliente();
                
                if(dtoSAL.getResultado().getValueAt(pos3,0)!=null)
                {
                    elemento.setOidAlcanceCliente(Long.valueOf(((BigDecimal)
                    dtoSAL.getResultado().getValueAt(pos3,0)).toString()));
                }
                if(dtoSAL.getResultado().getValueAt(pos3,1)!=null)
                {
                    elemento.setCodigoCliente(new String(
                    dtoSAL.getResultado().getValueAt(pos3,1).toString()));
                }
                if(dtoSAL.getResultado().getValueAt(pos3,2)!=null)
                {
                    elemento.setNombre(new String(
                    dtoSAL.getResultado().getValueAt(pos3,2).toString()));
                }
                if(dtoSAL.getResultado().getValueAt(pos3,3)!=null)
                {
                    elemento.setApellidos(new String(
                    dtoSAL.getResultado().getValueAt(pos3,3).toString()));
                }
                if(dtoSAL.getResultado().getValueAt(pos3,4)!=null)
                {
                    elemento.setPorcentajeDescuento(new Float(((BigDecimal)
                    dtoSAL.getResultado().getValueAt(pos3,4)).toString()));
                }
                if(dtoSAL.getResultado().getValueAt(pos3,5)!=null)
                {
                    elemento.setImporteDescuento(new Double(((BigDecimal)
                    dtoSAL.getResultado().getValueAt(pos3,5)).toString()));
                }
                if(dtoSAL.getResultado().getValueAt(pos3,6)!=null)
                {
                    elemento.setOidCliente(Long.valueOf(((BigDecimal)
                    dtoSAL.getResultado().getValueAt(pos3,6)).toString()));
                }
               
                if(dtoSAL.getResultado().getValueAt(pos3,7)!=null)
                {
                    pais = Long.valueOf(((BigDecimal)
                    dtoSAL.getResultado().getValueAt(pos3,7)).toString());
                }
                UtilidadesLog.debug("SCS, elemento es: " + elemento);
                arrDTODesctoClte[pos3] = elemento;
                
                pos3++;
               
            }
            UtilidadesLog.debug("SCS, arrDTODesctoClte es: " + arrDTODesctoClte);
            listaDtoCliente.setAlcanceCliente(arrDTODesctoClte);
            
            listaDtoCliente.setOidPais(pais);
            
           
            UtilidadesLog.debug("SCS, listaDtoCliente es: " + listaDtoCliente); 
            dtoDescuento.setAlcanceCliente(listaDtoCliente);
            dtoDescuento.setIndAlcanceCliente(Boolean.TRUE);  
         } else
            dtoDescuento.setIndAlcanceCliente(Boolean.FALSE);  
        
        
        //Para la pestaña 'Alcance Administrativo' se hace un pasaje de la información obtenida 
        //un tipo de DTO a el tipo de DTO que existe dentro de DTOGlobalDescuento 
        DTOAlcanceAdministrativoDto alcanceAdmin = new DTOAlcanceAdministrativoDto();
        DTOSalida dtoSALI = this.consultarAlcanceAdministrativoDTO(dtoe);
        
        RecordSet rs = dtoSALI.getResultado();

        UtilidadesLog.debug("SCS, dtoSALI.getResultado() es: " + 
        dtoSALI.getResultado());
        
        if ((rs != null) && (rs.getRowCount() > 0)) 
        {
            DTOAlcanceAdministrativoDetalleDto[] alcancesDetalles = 
            new DTOAlcanceAdministrativoDetalleDto[rs.getRowCount()];
            int rows = rs.getRowCount();
            for (int i = 0 ;i < rows; i++) {
                DTOAlcanceAdministrativoDetalleDto dtoAAD = 
                new DTOAlcanceAdministrativoDetalleDto();
        
                if(rs.getValueAt(i,0)!=null) {
                    dtoAAD.setOidAlcance(Long.valueOf(((BigDecimal)
                    rs.getValueAt(i,0)).toString()));
                }    
                if(rs.getValueAt(i,6)!=null) {
                    dtoAAD.setOidRegion(Long.valueOf(((BigDecimal)
                    rs.getValueAt(i,6)).toString()));
                }    
                if(rs.getValueAt(i,7)!=null) {
                    dtoAAD.setOidSubgerencia(Long.valueOf((((BigDecimal)
                    rs.getValueAt(i,7)).toString())));
                }    
                if(rs.getValueAt(i,5)!=null) {
                    dtoAAD.setOidZona(Long.valueOf((((BigDecimal)
                    rs.getValueAt(i,5)).toString())));
                }
                if(rs.getValueAt(i,4)!=null) {
                    dtoAAD.setPorcentajeAdicional(Float.valueOf(((BigDecimal)
                    rs.getValueAt(i,4)).toString()));
                }    
                if(rs.getValueAt(i,2)!=null) {
                    dtoAAD.setRegion(String.valueOf(
                    rs.getValueAt(i,2).toString()));
                }    
                if(rs.getValueAt(i,1)!=null) {
                    dtoAAD.setSubgerencia(String.valueOf(
                    rs.getValueAt(i,1).toString()));
                }    
                if(rs.getValueAt(i,3)!=null) {
                    dtoAAD.setZona(String.valueOf(
                    rs.getValueAt(i,3).toString()));
                }    
            
                alcancesDetalles[i] = dtoAAD;
            }    
            UtilidadesLog.debug("SCS, alcancesDetalles es: " + alcancesDetalles);
            alcanceAdmin.setDetalle(alcancesDetalles);
            dtoDescuento.setAlcanceAdministrativo(alcanceAdmin);//BELC300021721 
            dtoDescuento.setIndAlcanceAdministrativo(Boolean.TRUE);
        } else {
                //Agregado por incidencia DBLG400000506 por pzerbino 2/02/2006
                UtilidadesLog.info("dtoDescuento.getDatosGralesDto().getNacional(): " + dtoDescuento.getDatosGralesDto().getNacional());
                if (!(dtoDescuento.getDatosGralesDto().getNacional().booleanValue())){
                    UtilidadesLog.info("entre a false");
                    dtoDescuento.setIndAlcanceAdministrativo(Boolean.FALSE);        
                }else{
                    UtilidadesLog.info("entre al true");
                    dtoDescuento.setIndAlcanceAdministrativo(Boolean.TRUE);      
                }
        }
        
        // Pestaña 'Base Calculo' 
        DTOSBaseCalculo dtoSBC = this.consultarBaseCalculoDTO(dtoe);
        UtilidadesLog.debug("SCS, dtoSBC es: " + dtoSBC);
        if (dtoSBC.getOidBase() != null) {
            dtoDescuento.setBaseCalculo(dtoSBC);
            dtoDescuento.setIndBaseCalculo(Boolean.TRUE);
        } else {
            dtoDescuento.setIndBaseCalculo(Boolean.FALSE);
        }
            
            
        // Pestaña 'Bases de Aplicación' 
        DTOListaBasesAplicacionDto dtoLBA = 
        this.consultarListaBasesAplicacionDTO(dtoe);
        UtilidadesLog.debug("SCS, dtoLBA es: " + dtoLBA);
        if (dtoLBA.getBasesAplicacion() != null && 
            dtoLBA.getBasesAplicacion().length>0 && 
            dtoLBA.getBasesAplicacion()[0]!=null &&
            dtoLBA.getBasesAplicacion()[0].getOidBase()!=null) 
        {
            dtoDescuento.setBasesAplicacion(dtoLBA);
            dtoDescuento.setIndBaseAplicacion(Boolean.TRUE);
        } else {
            dtoDescuento.setIndBaseAplicacion(Boolean.FALSE);
        }
        
        UtilidadesLog.info("MONMantenimientoDTOBean.obtenerDatosDescuentos(DTOOID dtoe): Salida");
        
        return dtoDescuento ;
    }


    public DTODescuento obtenerDescuentoBatch(DTOOID dto) throws MareException{
        DTODescuento dtoDesc = new DTODescuento(); 
        DTODescuentoDG dtodg =  consultarDescuentoDG(dto);
        dtoDesc.setDatosGenerales(dtodg);

        dtoDesc.setAlcanceTipoCliente(consultarAlcanceTipoClienteDTO(dto));

        DAODescuento dao = new DAODescuento();
        dtoDesc.setDescuentosACliente( dao.obtenerDescuentosACliente(dto.getOid()));

        dtoDesc.setAlcanceAdministrativo(consultarAlcanceAdministrativoDTO(dto).getResultado());

        ArrayList bc = new ArrayList();
        bc.add(consultarBaseCalculoDTO(dto));
        dtoDesc.setBaseCalculo(bc);

        DTOOIDs dtoOids =  consultarBasesAplicacionDTO(dto);
        ArrayList ba = new ArrayList();
        for (int i = 0 ; i < dtoOids.getOids().length; i++){
            DTOOID dtoOid = new DTOOID();
            dtoOid.setOid(dtoOids.getOids()[i]);
            dtoOid.setOidIdioma(dto.getOidIdioma());
            dtoOid.setOidPais(dto.getOidPais());
            ba.add(consultarBaseAplicacionDTOBatch(dtoOid));
        }

        dtoDesc.setBaseAplicacion(ba);
        return dtoDesc;
    }
}