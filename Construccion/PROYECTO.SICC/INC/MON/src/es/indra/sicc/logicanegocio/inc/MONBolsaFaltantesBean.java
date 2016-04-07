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
 *
 * Autor : Damasia Maneiro
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import es.indra.sicc.dtos.inc.DTOBusquedaFaltantes;
import es.indra.sicc.dtos.inc.DTOPremioSustitutivo;
import es.indra.sicc.dtos.inc.DTOProductoSustitutivo;
import es.indra.sicc.dtos.ped.DTOEstatusSolicitud;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternosLocalHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.Cronometrador;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.util.ArrayList;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MONBolsaFaltantesBean
        implements SessionBean {
        
    private SessionContext sessionContext;
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
        sessionContext = ctx;
    }

    /**
    * Fecha de Creacion: 27/04/2005
    * Autor: Damasia Maneiro
    *
    */
    public DTOSalida recuperarCodConcursos(DTOBelcorp dto)
            throws MareException {
        UtilidadesLog.info("MONBolsaFaltantesBean.recuperarCodConcursos(DTOBelcorp dto):Entrada");
        DAOFaltantes daoFaltantes = new DAOFaltantes();
        UtilidadesLog.info("MONBolsaFaltantesBean.recuperarCodConcursos(DTOBelcorp dto):Salida");
        
        return daoFaltantes.recuperarCodConcurso(dto);
    }

    /**
    * Fecha de Creacion: 27/04/2005
    * Autor: Damasia Maneiro
    * Comentario: retorna los premios faltantes dependiente del valor del atributo situacionRegistro.
    * Modificado: 26/05/2005
    * Autor: Carlos Leal
    */
    public DTOSalida buscarPremiosFaltantes(DTOBusquedaFaltantes dtoEnt)
            throws MareException {
        UtilidadesLog.info("MONBolsaFaltantesBean.buscarPremiosFaltantes(DTOBusquedaFaltantes dtoEnt):Entrada");
        

        DAOFaltantes daoFaltantes = new DAOFaltantes();
        DTOSalida dtoSalida = new DTOSalida();
        Integer situacionRegistroVigente = Integer.valueOf(ConstantesINC.SITUACION_REGISTRO_VIGENTE.toString());
        Integer situacionRegistroHistorica = Integer.valueOf(ConstantesINC.SITUACION_REGISTRO_HISTORICA.toString());
        UtilidadesLog.debug("*** dtoEnt.getSituacionRegistro(): "+dtoEnt.getSituacionRegistro());
        if (situacionRegistroVigente.equals(dtoEnt.getSituacionRegistro())) {
            dtoSalida = daoFaltantes.recuperarPremiosFaltantesVigentes(dtoEnt);
        }

        if (situacionRegistroHistorica.equals(dtoEnt.getSituacionRegistro())) {
            dtoSalida = daoFaltantes.recuperarPremiosFaltantesHistoricos(dtoEnt);
        }

        UtilidadesLog.debug("****DTOSalida: " + dtoSalida);
        UtilidadesLog.info("MONBolsaFaltantesBean.buscarPremiosFaltantes(DTOBusquedaFaltantes dtoEnt):Salida");

        return dtoSalida;
    }

    /**
    * Fecha de Creacion: 27/04/2005
    * Autor: Damasia Maneiro
    * Comentario: este metodo se encarga de procesar los faltantes 
    * con sus productos sustitutivos.
    * Modificado: Cristian Valenzuela
    * Fecha: 29/08/2006
    * Incidencia: BELC300023933
    */
    public void guardarAsignacionFaltantes(DTOPremioSustitutivo dtosus)
            throws MareException {
        UtilidadesLog.info("MONBolsaFaltantesBean.guardarAsignacionFaltantes"+
        "(DTOPremioSustitutivo dtosus):Entrada");
        
        try{
            DAOFaltantes daoFaltantes = new DAOFaltantes();
            Faltante faltante;
            Long oidSolicitudAux = null;
            ArrayList faltantes = new ArrayList();
            BolsaFaltantesHelper bolsaFaltantesHelper = new BolsaFaltantesHelper();    
            faltantes = daoFaltantes.obtenerFaltantesSustitucion(dtosus);
            
            //Agregado por BELC300023933
            ArrayList productosConStock = obtenerProductosConStock(dtosus, 
            (Faltante)faltantes.get(0));            
            dtosus.setProductosSustitutivos(productosConStock);
            //Fin agregado por BELC300023933
            
            if(faltantes!=null && faltantes.size() > 0){
                UtilidadesLog.debug("*** Tipo Cambio: " + dtosus.getTipoCambio());
                
                if (!dtosus.getTipoCambio().equals(ConstantesINC.TIPO_CAMBIO_SIN_PREMIO)) {
                    UtilidadesLog.debug("*** tipo cambio no es TIPO_CAMBIO_SIN_PREMIO");
                    faltante = (Faltante) faltantes.get(0);                   
                    
                    UtilidadesLog.debug("*** Cantidad de Faltantes: "+faltantes.size());
                    for (int pos = 0; faltantes.size() > pos; pos++) {
                                    
                        UtilidadesLog.debug("*** pos: "+pos);
                        faltante = (Faltante) faltantes.get(pos);
                        
                        UtilidadesLog.debug("*** OID Faltante: "+faltante.getOidBolsaFaltantes());                                                
                        UtilidadesLog.debug("*** oidSolicitudAux: "+oidSolicitudAux);
                        UtilidadesLog.debug("*** faltante.getOidSolicitud(): "+faltante.getOidSolicitud());
                        
                        //Comentado por BELC300023933
                        //if (!faltante.getOidSolicitud().equals(oidSolicitudAux)){           
                            bolsaFaltantesHelper.generarSolicitudSustitutos(faltante, dtosus);
        
                            if (dtosus.getCodigoMensaje() != null && dtosus.getCodigoMensaje().length() > 0) {
                                UtilidadesLog.debug("*** Va a generarMensajeFaltantes: " + dtosus.getCodigoMensaje());
                                bolsaFaltantesHelper.generarMensajeFaltantes(faltante, dtosus);
                            }
        
                        //Comentado por BELC300023933
                        //    oidSolicitudAux = faltante.getOidSolicitud();
                        //}
                    }
                }
                else {
                    UtilidadesLog.debug("*** tipo cambio es TIPO_CAMBIO_SIN_PREMIO");
                    for (int pos = 0; faltantes.size() > pos; pos++) {
                        faltante = (Faltante) faltantes.get(pos);
                        daoFaltantes.actualizarEntidadesFaltantes(faltante, dtosus);
                    }
                }
            }
        }
        catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            sessionContext.setRollbackOnly();
            throw me;
        }
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            sessionContext.setRollbackOnly();
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("MONBolsaFaltantesBean.guardarAsignacionFaltantes"+
        "(DTOPremioSustitutivo dtosus):Salida");
    }

    public DTOEstatusSolicitud procesarBolsaFaltantes(DTOSolicitudValidacion dtoSolicitud)
            throws MareException {
        UtilidadesLog.info("MONBolsaFaltantesBean.procesarBolsaFaltantes(DTOSolicitudValidacion dtoSolicitud):Entrada");
        Cronometrador.startTransaction("MONBolsaFaltantesBean.procesarBolsaFaltantes", Thread.currentThread().getName());
        DAOFaltantes dtoFaltantes = new DAOFaltantes();
        Cronometrador.startTransaction("dtoFaltantes.obtenerFaltantesSolicitud", Thread.currentThread().getName());
        ArrayList faltantes = dtoFaltantes.obtenerFaltantesSolicitud(dtoSolicitud);
        Cronometrador.startTransaction("dtoFaltantes.obtenerFaltantesSolicitud", Thread.currentThread().getName());

        BolsaFaltantesHelper bolsaFaltantesHelper = new BolsaFaltantesHelper();    
        for (int i = 0; i < faltantes.size(); i++) {
            bolsaFaltantesHelper.procesarFaltante((Faltante) faltantes.get(i));
        }
        
        DTOEstatusSolicitud dtoEStatusSolicitud = new DTOEstatusSolicitud();
        dtoEStatusSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONBolsaFaltantesBean.procesarBolsaFaltantes(DTOSolicitudValidacion dtoSolicitud):Salida");
        Cronometrador.endTransaction("MONBolsaFaltantesBean.procesarBolsaFaltantes", Thread.currentThread().getName());
        return dtoEStatusSolicitud;
    }

    // sapaza -- PER-SiCC-2012-0355 -- 27/04/2012
    public void procesarBolsaFaltantesServicio(DTOFACProcesoCierre dtoe)
            throws MareException {
        UtilidadesLog.info("MONBolsaFaltantesBean.procesarBolsaFaltantesServicio(DTOFACProcesoCierre dtoe):Entrada");
        
        DAOFaltantes daoFaltantes = new DAOFaltantes();
        daoFaltantes.procesarBolsaFaltantesServicio(dtoe);
        
        UtilidadesLog.info("MONBolsaFaltantesBean.procesarBolsaFaltantesServicio(DTOFACProcesoCierre dtoe):Salida");
    }

    /**
         * Sistema:     Belcorp
         * Modulo:      INC
         * Fecha:       23/05/2005
         * @version     1.0
         * @autor       Carlos Leal
    **/
    public DTOSalida obtenerSituacionRegistro(DTOBelcorp dtoe)
            throws MareException {
        UtilidadesLog.info("MONBolsaFaltantesBean.obtenerSituacionRegistro(DTOBelcorp dtoe):Entrada");

        DAOFaltantes dAOFaltantes = new DAOFaltantes();
        RecordSet situacionRegistro = dAOFaltantes.obtenerSituacionRegistro(dtoe);

        DTOSalida dTOSalida = new DTOSalida();
        dTOSalida.setResultado(situacionRegistro);

        UtilidadesLog.info("MONBolsaFaltantesBean.obtenerSituacionRegistro(DTOBelcorp dtoe):Salida");

        return dTOSalida;
    }

    public DTOSalida obtenerTipoCambio(DTOBelcorp DTOE)
            throws MareException {
        // Llama al método obtenerTipoCambio(DTOE) de la clase DAOFaltantes y obtiene el RecordSet "tipoCambio" 
        UtilidadesLog.info("MONBolsaFaltantesBean.obtenerTipoCambio(DTOBelcorp DTOE):Entrada");

        DAOFaltantes dAOFaltantes = new DAOFaltantes();
        RecordSet tipoCambio = dAOFaltantes.obtenerTipoCambio(DTOE);

        DTOSalida dTOSalida = new DTOSalida();
        dTOSalida.setResultado(tipoCambio);
        UtilidadesLog.info("MONBolsaFaltantesBean.obtenerTipoCambio(DTOBelcorp DTOE):Salida");

        return dTOSalida;
    }


    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:       29/08/2006
     * @version     1.0
     * @autor       Cristian Valenzuela
     **/
    public ArrayList obtenerProductosConStock(DTOPremioSustitutivo dtoSus, Faltante faltante) throws MareException {
         
         UtilidadesLog.info("MONBolsaFaltantesBean.obtenerProductosConStock("+         
         "DTOPremioSustitutivo dtoSus, Faltante faltante):Entrada");
         
         DAOFaltantes dao = new DAOFaltantes();
         RecordSet stockProductos = dao.obtenerStockProductosSustitutivos(dtoSus, faltante);
         UtilidadesLog.debug("******** stockProductos " +  stockProductos);
         
         int cantStock = stockProductos.getRowCount();
         UtilidadesLog.debug("******** cantStock " +  cantStock);
         
         ArrayList productosSustitutivosConStock = new ArrayList();
         
         ArrayList productosSustitutivos = dtoSus.getProductosSustitutivos();
         int cant = productosSustitutivos.size();
         UtilidadesLog.debug("******** cant " +  cant);
         
         for(int i=0; i<cant; i++)  {
            DTOProductoSustitutivo productoSustitutivo = 
            (DTOProductoSustitutivo)productosSustitutivos.get(i);
            
            Long oidProducto = productoSustitutivo.getOidProducto();
            UtilidadesLog.debug("******** oidProducto " +  oidProducto);
            
            BigDecimal oidTemp = null;
            BigDecimal stockTemp = null;
            
            for(int j=0; j<cantStock; j++) {
                BigDecimal oid = (BigDecimal)stockProductos.getValueAt(i, "OIDPRODUCTO");
                UtilidadesLog.debug("******** oid " +  oid);
                
                if(oidProducto.longValue() == oid.longValue()) {
                    oidTemp = (BigDecimal)stockProductos.getValueAt(i, "OIDPRODUCTO");
                    stockTemp = (BigDecimal)stockProductos.getValueAt(i, "STOCK");                    
                }                
            }   
            
            UtilidadesLog.debug("******** oidTemp " +  oidTemp);
            UtilidadesLog.debug("******** stockTemp " +  stockTemp);
            
            if(oidTemp!=null) {
                if(dtoSus.getTipoCambio().longValue() == 
                    ConstantesINC.TIPO_CAMBIO_MASIVO.longValue()) {
                    
                    UtilidadesLog.debug("******** TIPO_CAMBIO_MASIVO");        
                    
                    if(stockTemp.longValue()>=
                    productoSustitutivo.getCantidad().longValue()) {                        
                        UtilidadesLog.debug("******** se añade al ArrayList" + productoSustitutivo);        
                        productosSustitutivosConStock.add(productoSustitutivo);                        
                    }                    
                }
                else if(dtoSus.getTipoCambio().longValue() == 
                    ConstantesINC.TIPO_CAMBIO_PREMIADO_A_PREMIADO.longValue()) {
                    
                    UtilidadesLog.debug("******** TIPO_CAMBIO_PREMIADO_A_PREMIADO");        
                    
                    if(stockTemp.longValue()>0) {
                        UtilidadesLog.debug("******** se añade al ArrayList" + productoSustitutivo);        
                        productosSustitutivosConStock.add(productoSustitutivo);                        
                    }
                }                
            }      
         }
         
         int cantArrayList = productosSustitutivosConStock.size();
         UtilidadesLog.debug("******** cantArrayList " +  cantArrayList);
         
         UtilidadesLog.info("MONBolsaFaltantesBean.obtenerProductosConStock("+         
         "DTOPremioSustitutivo dtoSus, Faltante faltante):Salida");
        
         return productosSustitutivosConStock;
    }
    
    private MONGenerarSolicitudModulosExternosLocalHome getMONGenerarSolicitudModulosExternosLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONGenerarSolicitudModulosExternosLocalHome)context.lookup("java:comp/env/ejb/local/MONGenerarSolicitudModulosExternos");
    }    
    
}