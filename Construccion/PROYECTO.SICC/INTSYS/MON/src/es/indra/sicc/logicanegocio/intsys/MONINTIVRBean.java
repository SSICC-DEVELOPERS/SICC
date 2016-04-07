/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, MadridC
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

package es.indra.sicc.logicanegocio.intsys;

import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;

import es.indra.sicc.cmn.negocio.interfaces.comun.DTOINTError;
import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.cmn.negocio.interfaces.comun.RegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesHome;

import es.indra.sicc.dtos.ccc.DTOSaldosPorFechas;
import es.indra.sicc.dtos.ccc.DTOSaldosPorFechasyVtos;

import es.indra.sicc.dtos.ccc.DTOTotal;
import es.indra.sicc.dtos.cra.ConstantesCRA;
import es.indra.sicc.dtos.cra.DTOPeriodo;

import es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz;
import es.indra.sicc.dtos.intsys.DTODatosBasesIncumplidas;
import es.indra.sicc.dtos.intsys.DTODatosCartera;
import es.indra.sicc.dtos.intsys.DTODatosConcursos;
import es.indra.sicc.dtos.intsys.DTODatosConsultoras;
import es.indra.sicc.dtos.intsys.DTODatosCronograma;
import es.indra.sicc.dtos.intsys.DTODatosGerentes;
import es.indra.sicc.dtos.intsys.DTODatosLineaCredito;
import es.indra.sicc.dtos.intsys.DTODatosMotivosAtencion;
import es.indra.sicc.dtos.intsys.DTODatosNiveles;
import es.indra.sicc.dtos.intsys.DTODatosPremios;
import es.indra.sicc.dtos.intsys.DTODatosProductos;
import es.indra.sicc.dtos.intsys.DTODatosRegiones;
import es.indra.sicc.dtos.intsys.DTODatosServiciosPostVenta;
import es.indra.sicc.dtos.intsys.DTOEINTIVR;
import es.indra.sicc.dtos.intsys.DTOEnvioInterfacesIVR;
import es.indra.sicc.dtos.intsys.DTOLlamadaTelecobro;

import es.indra.sicc.entidades.cob.AccionesCobranzaLocal;
import es.indra.sicc.entidades.cob.AccionesCobranzaLocalHome;
import es.indra.sicc.entidades.cob.EtapasDeudaTiposCargoLocal;
import es.indra.sicc.entidades.cob.EtapasDeudaTiposCargoLocalHome;
import es.indra.sicc.entidades.cob.GestionesCobranzaLocal;
import es.indra.sicc.entidades.cob.GestionesCobranzaLocalHome;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.intsys.EstadoLlamadaLocal;
import es.indra.sicc.entidades.intsys.EstadoLlamadaLocalHome;
import es.indra.sicc.entidades.intsys.PrioridadLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.seg.CanalLocal;
import es.indra.sicc.entidades.seg.MarcaLocal;
import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocal;
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocalHome;
import es.indra.sicc.entidades.zon.ZonaLocal;
import es.indra.sicc.entidades.zon.ZonaLocalHome;

import es.indra.sicc.logicanegocio.ccc.CCCConstantes;
import es.indra.sicc.logicanegocio.ccc.MONInterfaceModulos;
import es.indra.sicc.logicanegocio.ccc.MONInterfaceModulosHome;
import es.indra.sicc.logicanegocio.cob.ConstantesCOB;
import es.indra.sicc.logicanegocio.cra.DAOCRA;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.logicanegocio.ped.DAOSolicitud;
import es.indra.sicc.logicanegocio.rec.ConstantesREC;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;

import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.NoSuchElementException;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.entidades.seg.MarcaLocalHome;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import es.indra.sicc.entidades.seg.CanalLocalHome;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;
import es.indra.sicc.entidades.intsys.PrioridadLocalHome;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONINTIVRBean implements SessionBean  {

    private SessionContext ctx = null;
    private DTOEINTIVR dtoe;
    private RegistroSicc registro;
    private MONGestorInterfaces gi;
    private InterfazInfo interfaz;
    
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
    /*NOTA IMPORTANTE
     * mdolce 16/10/2006
     * A los codigos de cliente se les concatena un 0 adelante
     * debido a que en ejecucion real el codio en BBDD posee 9 digitos
     *  y la configuracion del mismo no se tocara 
     * */
    private void init(DTOBatch dtoBatch, String codigoInterfaz) throws MareException {
        UtilidadesLog.info("MONINTIVRBean.init(DTOBatch dtoBatch, String codigoInterfaz): Entrada");
        UtilidadesLog.debug(" [ "+codigoInterfaz+" ] MONINTIVR:init  ---->Entrada \n dtoBatch   " +dtoBatch+ " String codigoInterfaz -->"+codigoInterfaz );
        
        //Recogemos el dto encapsulado en el dtoBatch recibido 
        dtoe  = (DTOEINTIVR) dtoBatch.getDTOOnline();
        
        //Creamos un objeto gestor 
        this.gi = getMONGestorInterfaces();
        
        //Nos instanciamos un objeto InterfazInfo 
        InterfazInfo interfazInfo = new InterfazInfo( codigoInterfaz, dtoe.getNumeroLote(),dtoe.getOidPais());
        interfazInfo.setObservaciones(dtoe.getObservaciones());
        interfazInfo.setDescripcionLote(dtoe.getDescripcionLote());
        
        //Creamos un objeto info
        try{
            this.interfaz =gi.importarInterfaz(interfazInfo);
            this.interfaz.setDescripcionLote(dtoe.getObservaciones());
            this.interfaz.setObservaciones(dtoe.getDescripcionLote());

            //Añadido por incidencia 17714
            String listaCriteriosString = dtoe.getOidPais()+"&"+dtoe.getOidMarca()+
                    "&"+dtoe.getOidCanal()+"&"+dtoe.getOidAcceso()+"&"+dtoe.getOidPeriodo();
            this.interfaz.setCriteriosConsulta(listaCriteriosString);
            UtilidadesLog.debug("Lista criterios: "+this.interfaz.getCriteriosConsulta());

            UtilidadesLog.debug(" [ "+codigoInterfaz+" ]MIMPORTAMOS INTERFAZ : ");
        }
        catch(RemoteException re){             
             UtilidadesLog.debug("error RemoteException");
             throw new MareException(re,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        catch(InterfacesException ie){
             UtilidadesLog.error(" [ "+codigoInterfaz+" ]**** 1.- INTERFACES EXCEPTION importarInterfaz ");             
             UtilidadesLog.debug(" [ "+codigoInterfaz+" ]===============================================");
             UtilidadesLog.debug(" [ "+codigoInterfaz+" ]ERROR: "+ie.getMotivo());
             UtilidadesLog.debug(" [ "+codigoInterfaz+" ]===============================================");
             throw new MareException("1.- INTERFACES EXCEPTION importarInterfaz ", ie);
        }
        
        //Creamos un objeto registro de tipo RegistroSicc 
        registro = new RegistroSicc();
        
        UtilidadesLog.debug(" [ "+codigoInterfaz+" ] MONINTIVR:init  ---->Salida \n dtoBatch   " +dtoBatch+ " String codigoInterfaz -->"+codigoInterfaz );
        UtilidadesLog.info("MONINTIVRBean.init(DTOBatch dtoBatch, String codigoInterfaz): Salida");
    }

    private MONGestorInterfaces getMONGestorInterfaces() throws MareException {
            // Se obtiene el interfaz home
            UtilidadesLog.info("MONINTIVRBean.getMONGestorInterfaces(): Entrada");
            MONGestorInterfacesHome home = (MONGestorInterfacesHome)UtilidadesEJB.getHome("MONGestorInterfaces", MONGestorInterfacesHome.class);
                
            // Se obtiene el interfaz remoto
            MONGestorInterfaces ejb = null;
            try {
                ejb = home.create();
            } catch (Exception e) {
                UtilidadesLog.error("*** Error en getMONGestorInterfaces",e);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            } 
            UtilidadesLog.info("MONINTIVRBean.getMONGestorInterfaces(): Salida");
            return ejb;
    }     

    public DTOSalida obtenerInterfacesIVR(DTOString dto) throws MareException
    {
        UtilidadesLog.info("MONINTIVRBean.obtenerInterfacesIVR(DTOString dto): Entrada");	        
        /*
         MONINTIVR.obtenerInterfacesIVR(dto : DTOString) : DTOSalida 
        Entrada: 
        - dto : DTOString 
        Proceso: 
        -> Llamar al método "DAOINTIVR.obtenerInterfacesIVR(dto : DTOString) : DTOSalida" 
        -> Devolver DTOSalida obtenido en la llamada anterior
        */
        DAOINTIVR dao = new DAOINTIVR();
        DTOSalida dtoSalida = dao.obtenerInterfacesIVR(dto);
        
        UtilidadesLog.info("MONINTIVRBean.obtenerInterfacesIVR(DTOString dto): Salida");
        return dtoSalida;
    }

    public DTOSalidaBatch enviarTablaRegiones(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONINTIVRBean.enviarTablaRegiones(DTOBatch dtoBatch): Entrada");
        
        String codigo = IIVR.COD_INTERFAZ_IVR1; 

        try{        
             init( dtoBatch, codigo );
        }catch(MareException e){             
             UtilidadesLog.error(" [ "+codigo+" ] Fallo al realizar init en enviarTablaRegiones ");
             return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        } 
        
        DAOINTIVR dao = new DAOINTIVR(); 
        ArrayList regiones = dao.obtenerRegiones(this.dtoe.getOidPais(),
                                                this.dtoe.getOidMarca(),
                                                this.dtoe.getOidCanal());
        if(regiones.isEmpty()){
             String mensaje = "Regiones Sin Registros";
             return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado " + mensaje );
        }

        DTODatosRegiones dto = null;
        int n=regiones.size();
        for(int i=0;i<n;i++){
            dto = (DTODatosRegiones)regiones.get(i);
            try{
                registro.vaciar();
                registro.anyadirCampo(IIVR.IVR1_CODIGO_REGION,dto.getCodigoRegion());
                registro.anyadirCampo(IIVR.IVR1_DESCRIPCION_REGION, dto.getDescripcionRegion());
            }
            catch(InterfacesException iex){
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.error(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarTablaRegiones  ");                
                registro.vaciar();
                continue;
            }
            
            // Se añade el registro al fichero de interfaz 
            try{
                gi.anyadirRegistro(this.interfaz,registro);
            }
            catch(RemoteException re){                 
                 UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException");
                 throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            catch(InterfacesException iex){
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.error(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarTablaRegiones  ");                
            }
            
            registro.vaciar();
        }
        
        try{
            gi.enviarInterfaz(this.interfaz);
        }
        catch(InterfacesException iex){
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  iex.getMotivo()  + " ( "+ iex.getEx() + " )", iex );            
        }
        catch(RemoteException re){            
            UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.info("MONINTIVRBean.enviarTablaRegiones(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch(0,"Interfaz " + codigo + " procesada");
    }

    public DTOSalidaBatch enviarTablaCartera(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONINTIVRBean.enviarTablaCartera(DTOBatch dtoBatch): Entrada");
        String codigo = IIVR.COD_INTERFAZ_IVR4;

        try{        
             init( dtoBatch, codigo );
        }catch(MareException e){             
             UtilidadesLog.error(" [ "+codigo+" ] Fallo al realizar init en enviarTablaCartera ");
             return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        } 
        
        Date ultimaFecha = null;
        if(dtoe.getNovedad().booleanValue()){
            MONINT monINT = this.getMONINT();
            Long[] listaCriterios = {dtoe.getOidPais(),dtoe.getOidMarca(),dtoe.getOidCanal(),dtoe.getOidAcceso(),dtoe.getOidPeriodo()};
            try{
                ultimaFecha = monINT.obtenerUltimaFecha(listaCriterios, codigo);
            }catch(RemoteException e){                
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }else{
            ultimaFecha = null;
        }

        DAOINTIVR dao = new DAOINTIVR();         
        ArrayList carteras = dao.obtenerCarteras(dtoe.getOidPais(),dtoe.getOidMarca(),dtoe.getOidMarca(),ultimaFecha);

        DTODatosCartera dtoDatosCartera = null;

        if(carteras.isEmpty()){
             String mensaje = "Carteras Sin Registros";
             return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado " + mensaje );
        }

        int n=carteras.size();
        for(int i=0;i<n;i++){
            dtoDatosCartera = (DTODatosCartera)carteras.get(i);
            
            try{
                /*LEER NOTA AL COMIENZO CLASE*/
                registro.anyadirCampo( IIVR.IVR4_CODIGO_CLIENTE, "0" + dtoDatosCartera.getCodCliente());
                registro.anyadirCampo( IIVR.IVR4_CODIGO_PERIODO, dtoDatosCartera.getCodPeriodo());
                registro.anyadirCampo( IIVR.IVR4_NUMERO_DOCUMENTO, dtoDatosCartera.getNumeroDocumento() + "");
                registro.anyadirCampo( IIVR.IVR4_IMPORTE_PENDIENTE, dtoDatosCartera.getImportePendiente());
            }
            catch(InterfacesException iex ){
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.error(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarTablaCartera ");                
                continue;
            }
            
            // Se añade el registro al fichero de interfaz 
            try{
                gi.anyadirRegistro(this.interfaz,registro);
            }
            catch(RemoteException re){                 
                 UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException");
                 throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            catch(InterfacesException iex){
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.error(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarTablaCartera ");                
            }
            
            registro.vaciar();
        }

        try{
            gi.enviarInterfaz(this.interfaz);
        }
        catch(InterfacesException iex){
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  iex.getMotivo()  + " ( "+ iex.getEx() + " )", iex );            
        }
        catch(RemoteException re){            
            UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.debug("*[CS]Metodo  enviarTablaCartera: Salida");		 
        UtilidadesLog.info("MONINTIVRBean.enviarTablaCartera(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "Interfaz " + codigo + " procesada" );
    }

    public DTOSalidaBatch enviarTablaMotivosAtencion(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONINTIVRBean.enviarTablaMotivosAtencion(DTOBatch dtoBatch): Entrada");
        String codigo = IIVR.COD_INTERFAZ_IVR10;

        try{        
             init( dtoBatch, codigo );
        }catch(MareException e){             
             UtilidadesLog.error(" [ "+codigo+" ] Fallo al realizar init en enviarTablaMotivosAtencion ");
             return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        } 

        DAOINTIVR dao = new DAOINTIVR();         
        ArrayList motivosAtencion = dao.obtenerMotivosAtencion(dtoe.getOidPais(),dtoe.getOidIdioma());
        
        DTODatosMotivosAtencion dto = null;
        if(motivosAtencion.isEmpty()){
             String mensaje = "Motivos Atencion Sin Registros";
             return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado " + mensaje );
        }

        int n=motivosAtencion.size();
        for (int i=0;i<n;i++){
            dto = (DTODatosMotivosAtencion) motivosAtencion.get(i);
            try{
                registro.vaciar();
                registro.anyadirCampo(IIVR.IVR10_MOTIVO_ATENCION, dto.getMotivoAtencion());
                registro.anyadirCampo(IIVR.IVR10_DESCRIPCION_MOTIVO, dto.getDescripcionMotivo());
            }
            catch(InterfacesException iex ){
              //- se registra la excepción con el servicio MareLogging
              UtilidadesLog.error(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarTablaMotivosAtencion ");              
              registro.vaciar();
              continue;
            }

            // Se añade el registro al fichero de interfaz 
            try{
                gi.anyadirRegistro(this.interfaz,registro);
            }
            catch(RemoteException re){                 
                 UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException");
                 throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            catch(InterfacesException iex){
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.error(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarTablaMotivosAtencion ");                
            }
            
            registro.vaciar();
            
        }

        try{
            gi.enviarInterfaz(this.interfaz);
        }
        catch(InterfacesException iex){
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  iex.getMotivo()  + " ( "+ iex.getEx() + " )", iex );            
        }
        catch(RemoteException re){            
            UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.debug("*[CS]Metodo  enviarTablaMotivosAtencion: Salida");		 
        UtilidadesLog.info("MONINTIVRBean.enviarTablaMotivosAtencion(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "Interfaz " + codigo + " procesada" );
    }

    public DTOSalidaBatch enviarTablaCronogramaOperaciones(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONINTIVRBean.enviarTablaCronogramaOperaciones(DTOBatch dtoBatch): Entrada");
        String codigo = IIVR.COD_INTERFAZ_IVR9;

        try{        
             init( dtoBatch, codigo );
        }catch(MareException e){             
             UtilidadesLog.error(" [ "+codigo+" ] Fallo al realizar init en enviarTablaMotivosAtencion ");
             return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        } 
        
        DAOINTIVR dao = new DAOINTIVR();         
        ArrayList cronogramas = dao.obtenerCronogramaOperaciones(dtoe.getOidPais(),dtoe.getOidMarca(),dtoe.getOidCanal(),dtoe.getOidPeriodo(),dtoe.getOidAcceso());
        String indicadorFecha;

        DTODatosCronograma dto = null;
        if(cronogramas.isEmpty()){
             String mensaje = "Cronogramas Sin Registros";
             return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado " + mensaje );
        }

        int n=cronogramas.size();
        for(int i=0;i<cronogramas.size();i++){
            dto = (DTODatosCronograma)cronogramas.get(i);

            if ( dto.getClaseActividad().equalsIgnoreCase(ConstantesCRA.COD_CLASE_ACTIVIDAD_FACTURACION))
                indicadorFecha = IIVR.F;
            else{
                if (dto.getClaseActividad().equalsIgnoreCase(ConstantesCRA.COD_CLASE_ACTIVIDAD_CURSO)) 
                    indicadorFecha = IIVR.C;
                else
                    indicadorFecha = IIVR.R;
            }             
  
            try { 
                registro.vaciar();
                registro.anyadirCampo( IIVR.IVR9_CODIGO_ZONA, dto.getCodZona() );
                registro.anyadirCampo( IIVR.IVR9_CODIGO_ACTIVIDAD,dto.getCodActividad()); 
                registro.anyadirCampo( IIVR.IVR9_FECHA_ACTIVIDAD, dto.getFechaFin());
                registro.anyadirCampo( IIVR.IVR9_INDICADOR_FECHA, indicadorFecha);
            }
            catch(InterfacesException iex ){
              //- se registra la excepción con el servicio MareLogging
              UtilidadesLog.error(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarTablaCronogramaOperaciones ");              
              registro.vaciar();
              continue;
            }
            
            // Se añade el registro al fichero de interfaz 
            try{
                gi.anyadirRegistro(this.interfaz,registro);
            }
            catch(RemoteException re){                 
                 UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException");
                 throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            catch(InterfacesException iex){
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.error(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarTablaCronogramaOperaciones ");                
            }
            
            registro.vaciar();
        }
        
        try{
            gi.enviarInterfaz(this.interfaz);
        }
        catch(InterfacesException iex){
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  iex.getMotivo()  + " ( "+ iex.getEx() + " )", iex );            
        }
        catch(RemoteException re){            
            UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.info("MONINTIVRBean.enviarTablaCronogramaOperaciones(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "Interfaz " + codigo + " procesada" );
    }

    public DTOSalidaBatch enviarTablaGerentes(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONINTIVRBean.enviarTablaGerentes(DTOBatch dtoBatch): Entrada");
        java.util.Date ultimaFecha = null;
        
        String codigo = IIVR.COD_INTERFAZ_IVR2;
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTIVR:enviarTablaGerentes  ---->Entrada\n\n\n  dTOBatch   " +dtoBatch);
        
        MONINT monINT = this.getMONINT();
        
        try{
            init(dtoBatch, codigo);
        }catch (MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarTablaGerentes ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        }
       
        if(dtoe.getNovedad().booleanValue()){
            // Construimos un Array de Long con los siguientes campos del dto (pais, oidMarca, oidCanal, oidAcceso, oidPeriodo) 
            Long[] listaCriterios  = {dtoe.getOidPais() , dtoe.getOidMarca(), dtoe.getOidCanal(), dtoe.getOidAcceso(), dtoe.getOidPeriodo()};
            try{
                ultimaFecha = monINT.obtenerUltimaFecha(listaCriterios, codigo);
            }catch(RemoteException e){                
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }else{
            ultimaFecha = null;
        }
        
        DAOINTIVR dao = new DAOINTIVR();
        ArrayList gerentes = dao.obtenerGerentes( dtoe.getOidPais(), dtoe.getOidMarca(), dtoe.getOidCanal(), ultimaFecha );
        if(gerentes.isEmpty()){
                String mensaje = "enviarTablaGerentes SinRegistros";
                return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado " + mensaje);
        } 
        
        DTODatosGerentes dtoDatosGerentes = new DTODatosGerentes();
        int tamanio = gerentes.size();
        for(int i=0; i < tamanio; i++){
            dtoDatosGerentes = (DTODatosGerentes)gerentes.get(i);
            UtilidadesLog.debug(" [ "+codigo+" ] DTO a ingresar DTODatosGerentes "+ dtoDatosGerentes);            
            
            try{ 
                registro.vaciar();
                /*LEER NOTA AL COMIENZO CLASE*/
                registro.anyadirCampo( IIVR.IVR2_CODIGO_CLIENTE, "0" + dtoDatosGerentes.getCodCliente() );
                registro.anyadirCampo( IIVR.IVR2_NOMBRE_GERENTE, componerNombre( dtoDatosGerentes.getNombre1(), 
                dtoDatosGerentes.getNombre2(), dtoDatosGerentes.getApellido1(), dtoDatosGerentes.getApellido2() ,
                IIVR.LONGITUD_MAX_GERENTE));
                
                if (dtoDatosGerentes.getOidSubTipoCliente().longValue()==ConstantesMAE.OID_SUBTIPO_GERENTE_ZONA.longValue()) { 
                    registro.anyadirCampo( IIVR.IVR2_CODIGO_BUZON, dtoDatosGerentes.getCodBuzonZona() );
                }else { 
                    registro.anyadirCampo( IIVR.IVR2_CODIGO_BUZON, dtoDatosGerentes.getCodBuzonRegion() ); 
                } 
                SimpleDateFormat sdia = new SimpleDateFormat("dd");
                SimpleDateFormat smes = new SimpleDateFormat("MM");
                String fechacumple = "";
                if (dtoDatosGerentes.getFechaNacimiento() != null) {
                    fechacumple = sdia.format(dtoDatosGerentes.getFechaNacimiento())+ smes.format(dtoDatosGerentes.getFechaNacimiento());
                }
                registro.anyadirCampo( IIVR.IVR2_FECHA_NACIMIENTO, fechacumple ); 
                /*mdolce 16/10/2006 Modificado, se debe dejar asi, va este valor hardcodeado  */
                registro.anyadirCampo( IIVR.IVR2_TIPO_CLIENTE, "GZ" ); 

                // Se añade el registro al fichero de interfaz 
                try { 
                    gi.anyadirRegistro( interfaz, registro ); 
                } catch (RemoteException e) {                    
                    UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                    throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                
            registro.vaciar();
            
            }catch( InterfacesException e ) { 
                // Se registra la excepción con el servicio MareLogging
                UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarTablaGerentes ");                
                registro.vaciar();
                continue;
            }
        }
        
        try {
            gi.enviarInterfaz(this.interfaz );
        } catch( InterfacesException e ) { 
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  e.getMotivo()  + " ( "+ e.getEx() + " )", e );            
        } catch (RemoteException e) {            
            UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
            throw new MareException(e, UtilidadesError.armarCodigoError(
            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.debug(" [ "+codigo+" ] MONINTIVR:enviarTablaGerentes  ---->SALIDA ");
        UtilidadesLog.info("MONINTIVRBean.enviarTablaGerentes(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "Interfaz " + codigo + " procesada" );
    }

    public DTOSalidaBatch enviarTablaConsultoras(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONINTIVRBean.enviarTablaConsultoras(DTOBatch dtoBatch): Entrada");
        java.util.Date ultimaFecha = null;
        
        String codigo = IIVR.COD_INTERFAZ_IVR3;
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTIVR:enviarTablaConsultoras  ---->Entrada\n\n\n  dTOBatch   " +dtoBatch);
        
        try{
            init(dtoBatch, codigo);
        }catch (MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarTablaConsultoras ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        }
       
        if(dtoe.getNovedad().booleanValue()){
            MONINT monINT = this.getMONINT();
            Long[] listaCriterios = {dtoe.getOidPais(),dtoe.getOidMarca(),dtoe.getOidCanal(),dtoe.getOidAcceso(),dtoe.getOidPeriodo()};
            try{
                ultimaFecha = monINT.obtenerUltimaFecha(listaCriterios, codigo);
            }catch(RemoteException e){                
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }else{
            ultimaFecha = null;
        }
        
        DAOINTIVR dao = new DAOINTIVR();
        DTOSaldosPorFechasyVtos dtoSaldo = null;
        DTODatosConsultoras dtoDatosConsultoras;
        //Creamos un objeto interface
        MONInterfaceModulos inter = this.getMONInterfaceModulos();
        
        ArrayList consultoras = dao.obtenerConsultoras( dtoe.getOidPais(), dtoe.getOidMarca(), dtoe.getOidCanal(), ultimaFecha );
        if(consultoras.isEmpty()){
                String mensaje = "enviarTablaConsultoras SinRegistros";
                return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado " + mensaje);
        }
        
        int tamanio = consultoras.size();        
        for(int i=0; i < tamanio; i++){
            dtoDatosConsultoras = (DTODatosConsultoras)consultoras.get(i);
            UtilidadesLog.debug(" [ "+codigo+" ] DTO a ingresar DTODatosConsultoras "+ dtoDatosConsultoras);
            try{ 
                /*LEER NOTA AL COMIENZO CLASE*/
                registro.anyadirCampo( IIVR.IVR3_CODIGO_CLIENTE, "0" + dtoDatosConsultoras.getCodCliente() );
                registro.anyadirCampo( IIVR.IVR3_NOMBRE_CONSULTORA, componerNombre( dtoDatosConsultoras.getNombre1(), 
                dtoDatosConsultoras.getNombre2(), dtoDatosConsultoras.getApellido1(), dtoDatosConsultoras.getApellido2() ,
                IIVR.LONGITUD_MAX_CONSULTORA));
                registro.anyadirCampo( IIVR.IVR3_CODIGO_BUZON,dtoDatosConsultoras.getCodBuzon() );
                
                /*dtoSaldo = new DTOSaldosPorFechasyVtos(); 
                dtoSaldo.setOidCliente(dtoDatosConsultoras.getOidCliente());
                dtoSaldo.setOidIdioma(dtoe.getOidIdioma());
                dtoSaldo.setOidPais(dtoe.getOidPais());*/
                
                
                // INICIO: DBLG700000004 - splatas - 26/09/2006
                /*BigDecimal bSaldo = new BigDecimal("0.00");
                bSaldo.setScale(2);
                
                if( inter.calcularSaldoCCCliente(dtoSaldo).getTotal() != null ){     
                    bSaldo = inter.calcularSaldoCCCliente(dtoSaldo).getTotal().setScale(2);
                    UtilidadesLog.debug("   - SAP601:  bSaldo= " + bSaldo);
                    
                } else {
                    UtilidadesLog.debug("   - SAP601:  bSaldo= " + bSaldo );                                
                // FIN: DBLG700000004 - splatas - 26/09/2006    
                }*/
                
                // MODIFICADO POR INCIDENCIA VALIDACION V-INT-IVR-01 y PERFORMANCE
                //CNnoziglia
                
                BigDecimal bSaldo = new BigDecimal("0.00");
                bSaldo.setScale(2);
                if(dtoDatosConsultoras.getSaldo()!=null){
                    bSaldo = dtoDatosConsultoras.getSaldo();
                }
                registro.anyadirCampo( IIVR.IVR3_SALDO_CONSULTORA, bSaldo); 
                // fin modificado
                                
                registro.anyadirCampo( IIVR.IVR3_CODIGO_SECCION, dtoDatosConsultoras.getCodSeccion()); 
                registro.anyadirCampo( IIVR.IVR3_CODIGO_TERRITORIO, dtoDatosConsultoras.getCodTerritorio()); 
               
                UtilidadesLog.debug("   - SAP601:  hago el SimpleDateFormat con pattern= 'yyyyMMdd' ");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                UtilidadesLog.debug("   - SAP601:  hago el 'format'");
                String sFecha = "";
                if( dtoDatosConsultoras.getFechaDocumento() != null ){     
                    sFecha = sdf.format(dtoDatosConsultoras.getFechaDocumento());
                }else{
                    java.util.Date fecha = new java.util.Date();
                    fecha.setTime(System.currentTimeMillis());
                    sFecha = sdf.format(fecha);
                }                
                
                UtilidadesLog.debug("   - SAP601:  aniado la Fecha = " + sFecha);                
                registro.anyadirCampo( IIVR.IVR3_FECHA_DOCUMENTO, sFecha);
                
                if (dtoDatosConsultoras.getIndIncobrable().equals("1")) { // MODIFICADO POR INCIDENCIA VALIDACION V-INT-IVR-01 y PERFORMANCE
                //CNnoziglia
                    registro.anyadirCampo( IIVR.IVR3_INDICADOR_INCOBRABLE, CCCConstantes.DEUDA_INCOBRABLE ); 
                }else { 
                    registro.anyadirCampo( IIVR.IVR3_INDICADOR_INCOBRABLE, CCCConstantes.DEUDA_COBRABLE ); 
                }

                // Se añade el registro al fichero de interfaz 
                gi.anyadirRegistro( interfaz, registro ); 
 
                registro.vaciar();
                
            }catch (RemoteException e){                
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }catch( InterfacesException e ) { 
                // Se registra la excepción con el servicio MareLogging
                UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarTablaConsultoras ");                
                continue;
            }
        }
        
        try {
            gi.enviarInterfaz( this.interfaz );
        } catch( InterfacesException e ) { 
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  e.getMotivo()  + " ( "+ e.getEx() + " )", e );            
        } catch (RemoteException e) {            
            UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
            throw new MareException(e, UtilidadesError.armarCodigoError(
            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.debug(" [ "+codigo+" ] MONINTIVR:enviarTablaConsultoras  ---->SALIDA ");
        UtilidadesLog.info("MONINTIVRBean.enviarTablaConsultoras(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "Interfaz " + codigo + " procesada" );
    }
    
    private String componerNombre (String nombre1, String nombre2, String apellido1, String apellido2, Long longitudMax){
        UtilidadesLog.info("MONINTIVRBean.componerNombre(String nombre1, String nombre2, String apellido1, String apellido2, Long longitudMax): Entrada");
        UtilidadesLog.debug("componerNombre   nombre1-->" +nombre1+" String nombre2-->" +nombre2+", String apellido1-->" + apellido1+" String apellido2--> " +apellido2 );
        String nombreCompleto= "";
        
            if(nombre1!=null){
                nombreCompleto = nombre1; 
            }else nombre1="";
            
            if(nombre2!=null){
                nombreCompleto += " "+nombre2; 
            }else nombre2="";
            
             if(apellido1!=null){
                nombreCompleto += " "+apellido1; 
            }else apellido1="";
            
            if(apellido2!=null){
                nombreCompleto += " "+apellido2; 
            }else apellido2 ="";
           
            
            if(nombreCompleto.length() > longitudMax.intValue()){
                   nombreCompleto =nombre1 + apellido1 + apellido2;
                if(nombreCompleto.length() > longitudMax.intValue()){
                     nombreCompleto =nombre1 + apellido1;
                      if(nombreCompleto.length() > longitudMax.intValue()){
                             nombreCompleto = nombre1;
							if(nombreCompleto.length() > longitudMax.intValue()) {
								nombreCompleto = nombre1.substring(0,longitudMax.intValue()-1);
							}
					  }
                }
            }
            UtilidadesLog.debug("Longitud de la cadena devuleta = nombreCompleto = "+ nombreCompleto.length());
            UtilidadesLog.info("MONINTIVRBean.componerNombre(String nombre1, String nombre2, String apellido1, String apellido2, Long longitudMax): Salida");
            return nombreCompleto;
    }

    public void enviarIVRInterfaz(DTOEnvioInterfacesIVR dto) throws MareException {
        UtilidadesLog.info("MONINTIVRBean.enviarIVRInterfaz(DTOEnvioInterfacesIVR dto): Entrada");
        DTOSalidaBatch dtoSalidaBatch=this.enviarIVR(dto);
        UtilidadesLog.info("MONINTIVRBean.enviarIVRInterfaz(DTOEnvioInterfacesIVR dto): Salida");
    }

    public DTOSalidaBatch enviarIVRSistema(DTOEINTIVR dtoe) throws MareException {
        UtilidadesLog.info("MONINTIVRBean.enviarIVRSistema(DTOEINTIVR dtoe): Entrada");

        DTOEnvioInterfacesIVR envioInterfaces = new DTOEnvioInterfacesIVR();

        envioInterfaces.setOidMarca(dtoe.getOidMarca());
        envioInterfaces.setOidCanal(dtoe.getOidCanal());
        envioInterfaces.setOidAcceso(dtoe.getOidAcceso());
        envioInterfaces.setNumeroLote(dtoe.getNumeroLote());
        envioInterfaces.setDescripcionLote(dtoe.getDescripcionLote());
        envioInterfaces.setObservaciones(dtoe.getObservaciones());
        envioInterfaces.setNovedad(dtoe.getNovedad());        
        envioInterfaces.setOidIdioma(dtoe.getOidIdioma());
        envioInterfaces.setOidPais(dtoe.getOidPais());


        DTOString modoEnvio = new DTOString();
        modoEnvio.setOidIdioma(dtoe.getOidIdioma());
        modoEnvio.setOidPais(dtoe.getOidPais());
        
        if(envioInterfaces.getNovedad().booleanValue()){
            modoEnvio.setCadena("2");
        }
        else{
            modoEnvio.setCadena("1");
        }        

        DAOINTIVR daoIntIvr=new DAOINTIVR();        

        DTOSalida dtoSalida=daoIntIvr.obtenerInterfacesIVR(modoEnvio);
        RecordSet rs=dtoSalida.getResultado();        

        if(rs!=null){
            int tamano=rs.getRowCount();
            Long []arrayLong=new Long[tamano];            

            for(int i=0; i<tamano; i++){

                if(rs.getValueAt(i, "OID_DEFI_INTE")!=null){
                  arrayLong[i]=new Long(((BigDecimal)rs.getValueAt(i, "OID_DEFI_INTE")).longValue());
                }
            }
            envioInterfaces.setInterfaces(arrayLong);
        }        

        DTOSalidaBatch DTOSalidaBatchDevolver=this.enviarIVR(envioInterfaces);        

        UtilidadesLog.info("MONINTIVRBean.enviarIVRSistema(DTOEINTIVR dtoe): Salida");
        return DTOSalidaBatchDevolver;
    }

    public DTOSalidaBatch enviarIVR(DTOEnvioInterfacesIVR dto) throws MareException {
        UtilidadesLog.info("MONINTIVRBean.enviarIVR(DTOEnvioInterfacesIVR dto): Entrada");
        UtilidadesLog.debug(" MONINTIVR:enviarIVR  ---->Entrada \n\n\ndto  " +dto );
                
        try{
            Long []interfaces=dto.getInterfaces();
            int tamano=interfaces.length;
            DTOBatch dtoBatch=null;
            for(int i=0; i<tamano; i++){
                if(interfaces[i].longValue()==ConstantesINT.INTERFAZ_IVR_1.longValue()){
                    dtoBatch = new DTOBatch( "enviarTablaRegiones", new MareBusinessID("INTEnviarTablaRegiones"), dto); 
                    BatchUtil.executeMLN(dtoBatch, "INTProcesoInterfaces");
                    UtilidadesLog.debug("enviado INTEnviarTablaRegiones");
                }
                else{
                    if(interfaces[i].longValue()==ConstantesINT.INTERFAZ_IVR_2.longValue()){
                        dtoBatch = new DTOBatch( "enviarTablaGerentes", new MareBusinessID( "INTEnviarTablaGerentes" ), dto ); 
                        BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces");
                        UtilidadesLog.debug("enviado INTEnviarTablaGerentes");
                    }
                    else{
                        if(interfaces[i].longValue()==ConstantesINT.INTERFAZ_IVR_3.longValue()){
                            dtoBatch = new DTOBatch( "enviarTablaConsultoras", new MareBusinessID( "INTEnviarTablaConsultoras" ), dto );
                            BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces");
                            UtilidadesLog.debug("enviado INTEnviarTablaConsultoras");
                        }
                        else{
                            if(interfaces[i].longValue()==ConstantesINT.INTERFAZ_IVR_4.longValue()){
                                dtoBatch = new DTOBatch( "enviarTablaCartera", new MareBusinessID( "INTEnviarTablaCartera" ), dto ) ;
                                BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces"); 
                                UtilidadesLog.debug("enviado INTEnviarTablaCartera");
                            }
                            else{
                                if(interfaces[i].longValue()==ConstantesINT.INTERFAZ_IVR_9.longValue()){
                                    dtoBatch = new DTOBatch( "enviarTablaCronogramaOperaciones", new MareBusinessID( "INTEnviarTablaCronogramaOperaciones" ), dto ); 
                                    BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" ); 
                                    UtilidadesLog.debug("enviado INTEnviarTablaCronogramaOperaciones");
                                }
                                else{
                                    if(interfaces[i].longValue()==ConstantesINT.INTERFAZ_IVR_10.longValue()){
                                        dtoBatch = new DTOBatch( "enviarTablaMotivosAtencion", new MareBusinessID( "INTEnviarTablaMotivosAtencion" ), dto );
                                        BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces");
                                        UtilidadesLog.debug("enviado INTEnviarTablaMotivosAtencion");
                                    }else{
                                        if(interfaces[i].longValue()==ConstantesINT.INTERFAZ_IVR_11.longValue()){
                                        dtoBatch = new DTOBatch( "enviarTablaServicioPostVenta", new MareBusinessID( "INTEnviarTablaServiciosPostVenta" ), dto );
                                        BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces");
                                        UtilidadesLog.debug("enviado INTEnviarTablaServiciosPostVenta");
                                        }else{
                                            if(interfaces[i].longValue()==ConstantesINT.INTERFAZ_IVR_13.longValue()){
                                            dtoBatch = new DTOBatch( "enviarTablaLineaCredito", new MareBusinessID( "INTEnviarTablaLineaCredito" ), dto );
                                            BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces");
                                            UtilidadesLog.debug("enviado INTEnviarTablaLineaCredito");
                                            }else{
                                                if(interfaces[i].longValue()==ConstantesINT.INTERFAZ_IVR_14.longValue()){
                                                dtoBatch = new DTOBatch( "enviarTablaProductos", new MareBusinessID( "INTEnviarTablaProductos" ), dto );
                                                BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces");
                                                UtilidadesLog.debug("enviado INTEnviarTablaProductos");
                                                }else{
                                                    if(interfaces[i].longValue()==ConstantesINT.INTERFAZ_IVR_15.longValue()){
                                                    dtoBatch = new DTOBatch( "enviarConsultorasCCastigadas", new MareBusinessID( "INTEnviarConsultoraCuentaCastigada" ), dto );
                                                    BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces");
                                                    UtilidadesLog.debug("enviado INTEnviarConsultoraCuentaCastigada");
                                                    }else{
                                                        if(interfaces[i].longValue()==ConstantesINT.INTERFAZ_IVR_5.longValue()){
                                                        dtoBatch = new DTOBatch( "enviarTablaConcursos", new MareBusinessID( "INTEnviarTablaConcursos" ), dto );
                                                        BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces");
                                                        UtilidadesLog.debug("enviado INTEnviarTablaConcursos");
                                                        }else{
                                                            if(interfaces[i].longValue()==ConstantesINT.INTERFAZ_IVR_6.longValue()){
                                                            dtoBatch = new DTOBatch( "enviarTablaBasesIncumplidas", new MareBusinessID( "INTEnviarTablaBasesIncumplidas" ), dto );
                                                            BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces");
                                                            UtilidadesLog.debug("enviado INTEnviarTablaBasesIncumplidas");
                                                            }else{
                                                                if(interfaces[i].longValue()==ConstantesINT.INTERFAZ_IVR_7.longValue()){
                                                                dtoBatch = new DTOBatch( "enviarTablaNiveles", new MareBusinessID( "INTEnviarTablaNiveles" ), dto );
                                                                BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces");
                                                                UtilidadesLog.debug("enviado INTEnviarTablaNiveles");
                                                                }else{
                                                                    if(interfaces[i].longValue()==ConstantesINT.INTERFAZ_IVR_12.longValue()){
                                                                    dtoBatch = new DTOBatch( "enviarTablaPremios", new MareBusinessID( "INTEnviarTablaPremios" ), dto );
                                                                    BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces");
                                                                    UtilidadesLog.debug("enviado INTEnviarTablaPremios");
                                                                    }/*else{
                                                                        if(interfaces[i].longValue()==ConstantesINT.INTERFAZ_IVR_20.longValue()){
                                                                        dtoBatch = new DTOBatch( "GenerarLlamadastelecobro", new MareBusinessID( "INTGenerarLlamadasParaTelecobro" ), dto );
                                                                        BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces");
                                                                        UtilidadesLog.debug("enviado INTGenerarLlamadasParaTelecobro");
                                                                        }else{
                                                                            if(interfaces[i].longValue()==ConstantesINT.INTERFAZ_IVR_21.longValue()){
                                                                            dtoBatch = new DTOBatch( "RecibirEstadoLlamada", new MareBusinessID( "INTRecibirEstadoLlamadasBatch" ), dto );
                                                                            BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces");
                                                                            UtilidadesLog.debug("enviado INTRecibirEstadoLlamadasBatch");
                                                                            } 
                                                                        }
                                                                    }*/
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }//Fin del for
        }catch(RemoteException re){            
            UtilidadesLog.debug("Error RemoteException enviarIVR");
            throw new MareException(re, UtilidadesError.armarCodigoError(
            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    
         UtilidadesLog.info("MONINTIVRBean.enviarIVR(DTOEnvioInterfacesIVR dto): Salida");
         return new DTOSalidaBatch(0, "Proceso enviar IVR ejecutado");
    }
    
    private MONInterfaceModulos getMONInterfaceModulos() throws MareException {
        // Se obtiene el interfaz home
		UtilidadesLog.info("MONINTIVRBean.getMONInterfaceModulos(): Entrada");
        MONInterfaceModulosHome home = (MONInterfaceModulosHome)UtilidadesEJB.getHome("MONInterfaceModulos", MONInterfaceModulosHome.class);
            
        // Se obtiene el interfaz remoto
        MONInterfaceModulos ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONInterfaceModulos",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONINTIVRBean.getMONInterfaceModulos(): Salida");
        return ejb;
	}

    private MONINT getMONINT() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONINTIVRBean.getMONINT(): Entrada");
        MONINTHome home = (MONINTHome)UtilidadesEJB.getHome("MONINT", MONINTHome.class);
            
        // Se obtiene el interfaz remoto
        MONINT ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONINT",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONINTIVRBean.getMONINT(): Salida");
        return ejb;
	}


    // BELC300016340 resuelta (findByUK de EtapasDeudaTiposCargo y AccionesCobranza)
   // BELC300016325 resuelta (creacion tabla EstadoLlamada)
   // BELC300016338 resuelta
   // BELC300016428 resuelta
   // BELC300016434 resuelta
   public void recibirEstadoLlamadas(DTOOID dtoOid) throws MareException {
      UtilidadesLog.info("MONINTIVRBean.recibirEstadoLlamadas(DTOOID dtoOid): Entrada");
      UtilidadesLog.debug("**** DTOEntrada: "+dtoOid);
      
		// Nos instanciamos un objeto de tipo DAOINTIVR que utilizaremos para las consultas. 
		// dao = new DAOINTIVR() 
		
      // String pais = DTOE.oid 
      Long pais = dtoOid.getOid();

		// MONGestorInterfaces gi = MONGestorInterfacesHome.create() 
      MONGestorInterfaces gi = this.getMONGestorInterfaces();

		// InterfazInfo interfaz = gestor.importarInterfaz( IGestorInterfaces.COD_INTERFAZ_IVR21, pais ) 
		// - si se recibe una InterfacesException, se registra con MareLogging y finaliza el método 
      InterfazInfo interfaz = null;
      try {
         interfaz = gi.importarInterfaz(IIVR.COD_INTERFAZ_IVR21, pais);
      } catch(RemoteException re) {         
         UtilidadesLog.debug("***** Error RemoteException en MONINTIVR.recibirEstadoLlamadas");
         throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (InterfacesException ie) {      
         UtilidadesLog.debug("***** Error InterfacesException en MONINTIVR.recibirEstadoLlamadas");
         return;
      }      
      
      IRegistroSicc registro = null;
      
      AccionesCobranzaLocal acciCobranzaLocal = null;
      EtapasDeudaTiposCargoLocal etapDeudTipCargLocal = null;
      EstadoLlamadaLocal estadoLlamadaLocal = null;
      
      do {
         
         // mientras( ( registro = gestor.cargarRegistro( interfaz ) ) != null ) //mientras queden registros 
         try {
            registro = gi.cargarRegistro(interfaz);
            
            if (registro == null)
               break;
         
         } catch (RemoteException re) {            
            UtilidadesLog.debug("***** Error RemoteException en MONINTIVR.recibirEstadoLlamadas");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         } catch (InterfacesException ie) {
            // - si la carga del registro produce una InterfacesException, se registra mediante MareLogging, 
            // y se continúa con el registro siguiente            
            UtilidadesLog.debug("***** InterfacesException en MONINTIVR.recibirEstadoLlamadas al cargar un registro");
            continue;
         }
                         
         // SI (registro.obtenerCampo(IVR.IVR21_ESTADO) != 0 ) O (registro.obtenerCampo(IVR.IVR21_EXITO_LLAMADA) != 1 ) { 
         if ( (! registro.obtenerCampo(IIVR.IVR21_ESTADO).equals("0")) 
               || (! registro.obtenerCampo(IIVR.IVR21_EXITO_LLAMADA).equals("1")) ) {
            Long identificador = null;
            try {
               identificador = new Long((String)registro.obtenerCampo(IIVR.IVR21_IDENTIFICADOR));
               UtilidadesLog.debug("--- findByUK en EstadoLlamada. Buscando identificador: " + identificador);
               // BELC300016338
               // EstadoLlamada = llamar al findByUk(registro.obtenerCampo(IVR.IVR21_IDENTIFICADOR) de la entidad EstadoLlamada 
               estadoLlamadaLocal = this.getEstadoLlamadaLocalHome().findByUK(identificador);
            } catch(NoResultException fex) {
               // El identificador no existe
               UtilidadesLog.debug("*** Metodo MONINTIVR.recibirEstadoLlamadas: FinderException al buscar en EstadoLlamada");
               // DTOINTError dtoError = new DTOINTError( interfaz, registro, mensaje INT-0062 + registro.obtenerCampo(IVR.IVR21_IDENTIFICADOR) ) 
               DTOINTError dtoError= new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0062 + identificador.toString());
               try {               
                  gi.registrarError(dtoError);
               } 
               catch(InterfacesException iex){
                UtilidadesLog.error("Excepcion de la Interfaz: "+ iex.getMotivo() ,iex);
               }
               catch(RemoteException rex){                    
                    UtilidadesLog.debug("error RemoteException");
                    throw new MareException(rex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
               continue;
            }  catch (PersistenceException ce) {
                 UtilidadesLog.error("ERROR ", ce);
                 throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            // BELC300016338
            // Actualiza la siguiente información de EstadoLlamada
            // - indEstado = registro.obtenerCampo(IVR.IVR21_ESTADO) 
            // - oidExitoLlamada = registro.obtenerCampo(IVR.IVR21_EXITO_LLAMADA) 
            estadoLlamadaLocal.setEstado((String)registro.obtenerCampo(IIVR.IVR21_ESTADO));            
            estadoLlamadaLocal.setExitoLlamada(new Long((String)registro.obtenerCampo(IIVR.IVR21_EXITO_LLAMADA)));
            this.getEstadoLlamadaLocalHome().merge(estadoLlamadaLocal);
            
            try {
               UtilidadesLog.debug("--- findByUK en EtapasDeudaTiposCargo. Buscando:  EstadoLlamada.oidTipoCargo=" + estadoLlamadaLocal.getTipoCargo() + "  EstadoLlamada.oidEtapaDeuda=" + estadoLlamadaLocal.getEtapasDeuda());
               // EtapaDeudaTipoCargo = findByUK(EstadoLlamada.oidTipoCargo, EstadoLlamada.oidEtapaDeuda) de la entidad EtapasDeudaTipoCargo 
               etapDeudTipCargLocal = this.getEtapasDeudaTiposCargoLocalHome().findByUK(estadoLlamadaLocal.getTipoCargo(), estadoLlamadaLocal.getEtapasDeuda());
            } catch(NoResultException fex ) { 
               // El Tipo Cargo no existe 
               // DTOINTError dtoError = new DTOINTError( interfaz, registro, mensaje INT-0063 ) 
               // gi.registrarError( dtoError ) 
               // continue 
               UtilidadesLog.debug("*** Metodo MONINTIVR.recibirEstadoLlamadas: FinderException al buscar en EtapasDeudaTiposCargo");
               DTOINTError dtoError= new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0063);
               try {               
                  gi.registrarError(dtoError);
               } 
               catch(InterfacesException iex){
                UtilidadesLog.error("Excepcion de la Interfaz: "+ iex.getMotivo() ,iex);
               }
               catch(RemoteException rex){                    
                    UtilidadesLog.debug("error RemoteException");
                    throw new MareException(rex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
               continue;
               
             } catch(PersistenceException pex) {
                 ctx.setRollbackOnly();
                 pex.printStackTrace();
                 throw new MareException(pex, 
                 UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
             }

            try { 
               //AccionCobranza = findByUk(pais, ConstantesCOB.COD_ACCION_LLAMADA_TELEFONICA);
               // incidencia BELC300016428 => Corregida
               String accionCobranza = ConstantesCOB.COD_ACCION_LLAMADA_TELEFONICA;
               acciCobranzaLocal = this.getAccionesCobranzaLocalHome().findByUK(accionCobranza, pais);
            } catch (NoResultException fex) { 
               // El Tipo Cargo no existe 
               // DTOINTError dtoError = new DTOINTError( interfaz, registro, mensaje INT-0064 ) 
               // gi.registrarError( dtoError ) 
               // continue
               UtilidadesLog.debug("*** Metodo MONINTIVR.recibirEstadoLlamadas: FinderException al buscar en AccionesCobranza");
               DTOINTError dtoError= new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0064);
               try {               
                  gi.registrarError(dtoError);
               } 
               catch(InterfacesException iex){
                UtilidadesLog.error("Excepcion de la Interfaz: "+ iex.getMotivo() ,iex);
               }
               catch(RemoteException rex){                    
                    UtilidadesLog.debug("error RemoteException");
                    throw new MareException(rex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
               continue;         
               
             } catch(PersistenceException pex) {
                 ctx.setRollbackOnly();
                 pex.printStackTrace();
                 throw new MareException(pex, 
                 UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
             } 
      
            // BELC300016434
            // Hacer un create en la entidad COBGestionesCobranzas con los siguientes atributos: 
               // - oidCliente = EstadoExito.oidCliente
               // - oidUsuariosCobranzas = EstadoExito.oidUsuariosCobranzas 
               // - oidEtapaDeuda = EstadoExito.oidEtapaDeuda 
               // - oidPeriodo = EstadoExito.oidPeriodo 
               // - oidEtapaDeudaTipoCargo = EtapaDeudaTipoCargo.oidEtapaDeudaTipoCargo 
               // - oidAccionCobranza = AccionCobranza.oid 
            try {
               /* create(String orden,
                         Long cliente, 
                         Long periodo, 
                         Long etapaDeuda, 
                         Long usuarioCobranzas, 
                         Long codigoAccion)
               */
               GestionesCobranzaLocalHome gestionLH = this.getGestionesCobranzaLocalHome();
               GestionesCobranzaLocal gestionLocal = gestionLH.create(estadoLlamadaLocal.getIdentificador().toString(),
                                                            estadoLlamadaLocal.getCliente(), 
                                                            estadoLlamadaLocal.getPeriodo(), 
                                                            estadoLlamadaLocal.getEtapasDeuda(), 
                                                            estadoLlamadaLocal.getUsuarioCobranzas(),
                                                            acciCobranzaLocal.getOid());
                gestionLocal.setOidEtapaDTipoCargo(etapDeudTipCargLocal.getOid());
                
                gestionLH.merge(gestionLocal);                
                
            } catch(PersistenceException e) {
                 ctx.setRollbackOnly();
                 e.printStackTrace();
                 throw new MareException(e,
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }    
         
         } // del if
      
      } while (true);
      
      UtilidadesLog.info("MONINTIVRBean.recibirEstadoLlamadas(DTOOID dtoOid): Salida");
   }

   public DTOSalidaBatch recibirEstadoLlamadaBatch(DTOBatch dtoe) throws MareException {
      UtilidadesLog.info("MONINTIVRBean.recibirEstadoLlamadaBatch(DTOBatch dtoe): Entrada");
		
      // IMareDTO dto = dtoe.getDTOOnline() 
      IMareDTO dto = dtoe.getDTOOnline();

		// - se obtiene el oid del pais, a partir del código: 
		// Pais pais = PaisHome.findByUK( dto.getProperty( "cadena" ) ) 
      PaisLocal pais = null;
      try {
         pais = this.getPaisLocalHome().findByUk((String)dto.getProperty("cadena"));
         } catch(NoResultException fe) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            UtilidadesLog.error("MONINTIVR.recibirEstadoLlamadaBatch: FinderException de Pais", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(error));
         }  catch (PersistenceException ce) {   
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         }

		// recibirEstadoLlamadas ( new DTOOID( pais.oid ) ) 
      DTOOID dtoOid = new DTOOID();
      dtoOid.setOid(pais.getOid());
      this.recibirEstadoLlamadas(dtoOid);

      UtilidadesLog.info("MONINTIVRBean.recibirEstadoLlamadaBatch(DTOBatch dtoe): Salida");
      // Retornar new DTOSalidaBatch( 0, "Proceso recebir Estado de Llamadas ejecutado" )      
      return new DTOSalidaBatch(0, "Proc Rec. Estado Llamadas Ejec");
   }

    public DTOSalidaBatch  enviarTablaServiciosPostVenta(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONINTIVRBean.enviarTablaServiciosPostVenta(DTOBatch dtoBatch): Entrada");

        String codigo = IIVR.COD_INTERFAZ_IVR11;
        try{
            init(dtoBatch, codigo);
        } catch (MareException e){            
             UtilidadesLog.error(" [ "+codigo+" ] Fallo al realizar init en enviarTablaServiciosPostVenta ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        }
        
        Date ultimaFecha = null;
        
        if (this.dtoe.getNovedad().booleanValue()){
            Long[] listaCriterios = {dtoe.getOidPais(),dtoe.getOidMarca(),dtoe.getOidCanal(),dtoe.getOidAcceso(),dtoe.getOidPeriodo()};
            
            try {
                ultimaFecha = this.getMONINT().obtenerUltimaFecha(listaCriterios,codigo);   
            } catch (RemoteException e){                
                UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException. obtenerUltimaFecha");
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }else{
            ultimaFecha = null;
        }
        
        DTOPeriodo dtoPeriodoActual = null;
        Long oidPeriodoAnterior = null;
        DTOSalida periodos = null;
        
        MONPeriodos monPeriodos = this.getMONPeriodos();
        
        try{
            dtoPeriodoActual = monPeriodos.obtienePeriodoActual(dtoe.getOidPais(),dtoe.getOidMarca(),dtoe.getOidCanal());
        } catch (RemoteException e){            
                UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException. obtenerPeriodoActual");
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    
        try{
            periodos = monPeriodos.obtienePeriodosAnteriores(dtoPeriodoActual);
        } catch (RemoteException e){            
                UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException. obtenerPeriodoAnterior");
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        if (!periodos.getResultado().esVacio()){
			//rgiorgi - 27/8/2005: estaba tomando el código y no el oid del periodo.
            oidPeriodoAnterior = new Long(periodos.getResultado().getValueAt(0,2).toString());
        }
        
        DAOINTIVR dao = new DAOINTIVR();
        ArrayList serviciosPostVenta = dao.obtenerServiciosPostVenta(dtoe.getOidPais(), dtoe.getOidMarca(), dtoe.getOidCanal(), dtoPeriodoActual.getOid(), oidPeriodoAnterior,ultimaFecha);
        if(serviciosPostVenta.isEmpty()){
             String mensaje = "ServiciosPostVenta Sin Registros";
             return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado " + mensaje );
        }
        
        //String estadoOperacion;
        for (int i = 0; i < serviciosPostVenta.size(); i++){
            DTODatosServiciosPostVenta dto = (DTODatosServiciosPostVenta) serviciosPostVenta.get(i);
            
            try{
                registro.vaciar();
                /*LEER NOTA AL COMIENZO CLASE*/
                registro.anyadirCampo(IIVR.IVR11_CODIGO_CONSULTORA, "0" + dto.getCodCliente());
                registro.anyadirCampo( IIVR.IVR11_NUMERO_SERVICIO_POSTVENTA, dto.getNumeroReclamo().toString());
                registro.anyadirCampo( IIVR.IVR11_CODIGO_OPERACION, dto.getCodOperacion());
                registro.anyadirCampo( IIVR.IVR11_CODIGO_PRODUCTO, dto.getCodProducto());
                if (dto.getIndAtendido()!=null){
                    registro.anyadirCampo( IIVR.IVR11_ESTADO_ATENDIDO, dto.getIndAtendido().toString());
                }else{
                    registro.anyadirCampo( IIVR.IVR11_ESTADO_ATENDIDO, dto.getIndAtendido());
                }
                
                if (dto.getEstadoOperacion().longValue() == ConstantesREC.ESTADO_OPERACION_INGRESADO.longValue() ||
                    dto.getEstadoOperacion().longValue() == ConstantesREC.ESTADO_OPERACION_FACTURADO.longValue()){
                        registro.anyadirCampo( IIVR.IVR11_ESTADO_OPERACION, IIVR.A );
                }
                
                if (dto.getEstadoOperacion().longValue() == ConstantesREC.ESTADO_OPERACION_ENVIADO.longValue()) { 
                    registro.anyadirCampo( IIVR.IVR11_ESTADO_OPERACION, IIVR.E );
                } 
                if (dto.getEstadoOperacion().longValue() == ConstantesREC.ESTADO_OPERACION_BLOQUEO.longValue()) { 
                    registro.anyadirCampo( IIVR.IVR11_ESTADO_OPERACION, IIVR.X );
                } 
                registro.anyadirCampo( IIVR.IVR10_MOTIVO_ATENCION, dto.getCodMotivoRechazo());
                registro.anyadirCampo( IIVR.IVR11_DESCRIPCION_PRODUCTO, dto.getDescripcionProducto());

                if (dto.getImporteAbono() != null) { 
                    registro.anyadirCampo( IIVR.IVR11_MONTO_ATENCION_POSTVENTA, new Long (dto.getImporteAbono().longValue()));
                } else { // (dtoDatosServiciosPostVenta.importeCargo != null) No deberían venir los dos a null, es decir que tienen que uno de los dos un importe 
                    if (dto.getImporteCargo()!=null){
                        registro.anyadirCampo( IIVR.IVR11_MONTO_ATENCION_POSTVENTA, new Long(dto.getImporteCargo().longValue()));
                    }else{
                        registro.anyadirCampo( IIVR.IVR11_MONTO_ATENCION_POSTVENTA, null);
                    }
                } 
                registro.anyadirCampo( IIVR.IVR11_PERIODO_ATENCION, dto.getCodPeriodo());
            } catch(InterfacesException e){
                UtilidadesLog.error(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarTablaServiciosPostVenta  ");                
                registro.vaciar();
                continue;
            }
            
            // Se añade el registro al fichero de interfaz 
            try{
                gi.anyadirRegistro(this.interfaz,registro);
            }
            catch(RemoteException re){                 
                 UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException en anyadirRegistro");
                 throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            catch(InterfacesException iex){
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.error(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarTablaRegiones  ");                
            }
            
            registro.vaciar();
        }
        
        try{
            gi.enviarInterfaz(this.interfaz);
        }
        catch(InterfacesException iex){
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  iex.getMotivo()  + " ( "+ iex.getEx() + " )", iex );            
        }
        catch(RemoteException re){            
            UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.info("MONINTIVRBean.enviarTablaServiciosPostVenta(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch(0, "Interfaz " + codigo + " procesada");
    }

    private MONPeriodos getMONPeriodos() throws MareException {
        // Se obtiene el interfaz home
		UtilidadesLog.info("MONINTIVRBean.getMONPeriodos(): Entrada");
        MONPeriodosHome home = (MONPeriodosHome)UtilidadesEJB.getHome("MONPeriodos", MONPeriodosHome.class);
            
        // Se obtiene el interfaz remoto
        MONPeriodos ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONPeriodos",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONINTIVRBean.getMONPeriodos(): Salida");
        return ejb;
	}

public DTOSalidaBatch generarLlamadasParaTelecobro (DTOBatch dto) throws MareException{
         UtilidadesLog.info("MONINTIVRBean.generarLlamadasParaTelecobro(DTOBatch dto): Entrada");	 

         String codigo = IIVR.COD_INTERFAZ_IVR20;
         
         //Recogemos el dto encapsulado en el dtoBatch recibido 
         DTOLlamadaTelecobro dtoe = (DTOLlamadaTelecobro)dto.getDTOOnline();
         
         MONGestorInterfaces gi = this.getMONGestorInterfaces();
         
         InterfazInfo interfaz = null;
         try {
            interfaz = gi.importarInterfaz(codigo, dtoe.getOidPais());
         } 
         catch(RemoteException re) {            
            UtilidadesLog.debug("***** Error RemoteException en MONINTIVR.generarLlamadasParaTelecobro");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         } 
         catch (InterfacesException ie) {            
            UtilidadesLog.debug("***** Error InterfacesException en MONINTIVR.generarLlamadasParaTelecobro");
            throw new MareException("-- INTERFACES EXCEPTION importarInterfaz MONINTIVR.generarLlamadasParaTelecobro ", ie);
         }      
        
         // Obtener la compañía telefónica del pais 
         PaisLocal paisLocal = null;
         try{
            paisLocal = this.getPaisLocalHome().findByPrimaryKey(dtoe.getOidPais());
         }
         catch(NoResultException fe){
             UtilidadesLog.debug(" FinderException en generarLlamadasParaTelecobro: nos salimos en pais ");
             String mensaje = "generarLlamadasParaTelecobro: " + ErroresDeNegocio.INT_0061; 
             DTOINTError dtoError = new DTOINTError( this.interfaz, null, mensaje ); 
             return new DTOSalidaBatch( 0, mensaje );
         }  catch (PersistenceException ce) {   
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         }
        
         
         //vamos a asignar la prioridad, que será 2 si viene sin definir 
         if (dtoe.getPrioridad() == null)
            dtoe.setPrioridad(ConstantesINT.PRIORIDAD_GESTION);

         try {
         // Insertar un registro nuevo en la entidad estado de llamadas y recoger el identificador de la llamada 
               /* 
                Hacer un create en la entidad EstadoLlamada (INT) con la siguiente informacion: 
                - codLlamada = mismo valor que el creado en el oid del registro //Esto se realiza así por que se necesita un secuencial 
                - oidCliente = dtoe.oidCliente 
                - oidEtapaDeuda = dtoe.oidEtapaDeuda 
                - oidPeriodo = dteo.oidPeriodo 
                - oidSubTipoCliente = dtoe.oidSubTipoCliente 
                - oidTipoCargoAbono = dtoe.oidTipoCargoAbono 
                - oidUsuarioCobranzas = dtoe.oidUsuarioCobranzas 
                - oidZona = dteo.oidZona 
                - oidRegion = dtoe.oidRegion 
                - oidPrioridad = dtoe.prioridad */
            
               //BELC300016498 -- codLlamada se asigna en el create de la entidad
               EstadoLlamadaLocal estado = this.getEstadoLlamadaLocalHome().create(dtoe.getOidUsuarioCobranzas(),
                                                                                   dtoe.getOidTipoCargoAbono(),
                                                                                   dtoe.getOidSubTipoCliente(),
                                                                                   dtoe.getOidEtapaDeuda(),
                                                                                   dtoe.getOidCliente(),
                                                                                   dtoe.getOidPeriodo());
                
               estado.setZona(dtoe.getOidZona());
               estado.setRegion(dtoe.getOidRegion());
               estado.setPrioridad(dtoe.getPrioridad());
               this.getEstadoLlamadaLocalHome().merge(estado);
         } catch (PersistenceException crex) {
               ctx.setRollbackOnly();
               UtilidadesLog.error("Metodo MONINTIVR.generarLlamadasParaTelecobro: CreateException", crex);
               throw new MareException(crex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS)); 
         }
        
        // Obtener Cliente Datos Basicos
         ClienteDatosBasicosLocal clienteLocal = null;
         try{
            clienteLocal = this.getClienteDatosBasicosLocalHome().findByPrimaryKey(dtoe.getOidCliente());
         }
         catch(NoResultException fe){
             UtilidadesLog.debug(" FinderException en generarLlamadasParaTelecobro: nos salimos en ClienteDatosBasicos ");
             String mensaje = "generarLlamadasParaTelecobro: " + ErroresDeNegocio.INT_0076; 
             DTOINTError dtoError = new DTOINTError( interfaz, null, mensaje ); 
             return new DTOSalidaBatch( 0, mensaje );
         }  catch (PersistenceException ce) {   
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         }        
         // Obtener Zona
         ZonaLocal zonaLocal = null;
         try{
            zonaLocal = this.getZonaLocalHome().findByPrimaryKey(dtoe.getOidZona());
         }
         catch(NoResultException fe){
             UtilidadesLog.debug(" FinderException en generarLlamadasParaTelecobro: nos salimos en Zona ");
             String mensaje = "generarLlamadasParaTelecobro: " + ErroresDeNegocio.INT_0077; 
             DTOINTError dtoError = new DTOINTError( interfaz, null, mensaje ); 
             return new DTOSalidaBatch( 0, mensaje );
         }  catch (PersistenceException ce) {   
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         }

        
         //BELC300016498 -- Se elimina el finder por Region
         
         //Creamos un objeto registro de tipo RegistroSicc 
         RegistroSicc registro = new RegistroSicc();
         
         PrioridadLocalHome prioHL = this.getPrioridadLocalHome();
         PrioridadLocal pl= null;
    
        try{                  
            pl = prioHL.findByPrimaryKey(dtoe.getPrioridad());
         }catch(NoResultException fe){
             UtilidadesLog.debug(" FinderException en generarLlamadasParaTelecobro: nos salimos en Prioridad ");
             String mensaje = "generarLlamadasParaTelecobro: " + ErroresDeNegocio.INT_0078; 
             DTOINTError dtoError = new DTOINTError( interfaz, null, mensaje ); 
             return new DTOSalidaBatch( 0, mensaje );
         }  catch (PersistenceException ce) {
              UtilidadesLog.error("ERROR ", ce);
              throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
         }
                          
                          
         try{
           /*LEER NOTA AL COMIENZO CLASE*/
            registro.anyadirCampo(IIVR.IVR20_CODIGO_CLIENTE, "0" + clienteLocal.getCod_clie());
            registro.anyadirCampo(IIVR.IVR20_NOMBRE_CONSULTORA, componerNombre(clienteLocal.getVal_nom1(), clienteLocal.getVal_nom2(), clienteLocal.getVal_ape1(), clienteLocal.getVal_ape2() , IIVR.LONGITUD_MAX_CONSULTORA));
            registro.anyadirCampo(IIVR.IVR20_COMPANIA_TELEF, paisLocal.getVal_comp_tele());
            registro.anyadirCampo(IIVR.IVR20_TELEFONO1,dtoe.getTelefono1());
            registro.anyadirCampo(IIVR.IVR20_PRIORIDAD,pl.getCodigo()); 
            registro.anyadirCampo(IIVR.IVR20_ZONA, zonaLocal.getCodZona());
         }
         catch(InterfacesException iex ){
            //- se registra la excepción con el servicio MareLogging
            UtilidadesLog.error(" [ "+codigo+" ] \n\n 1.-InterfacesException En generarLlamadasParaTelecobro ");            
         }

         //registro.vaciar();


         // Se añade el registro al fichero de interfaz 
         try{
            gi.anyadirRegistro(interfaz,registro);
         }
         catch(RemoteException re){            
            UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         }
         catch(InterfacesException iex){
            //- se registra la excepción con el servicio MareLogging
            UtilidadesLog.error(" [ "+codigo+" ] \n\n 1.-InterfacesException En generarLlamadasParaTelecobro ");            
         }
        
         registro.vaciar();
        
         try{
            gi.enviarInterfaz(interfaz);
         }
         catch(InterfacesException iex){
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  iex.getMotivo()  + " ( "+ iex.getEx() + " )", iex );            
         }
         catch(RemoteException re){            
            UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         }        

         UtilidadesLog.info("MONINTIVRBean.generarLlamadasParaTelecobro(DTOBatch dto): Salida");
         return new DTOSalidaBatch( 0, "Interfaz " + codigo + " procesada" );
    }


    public void generarLlamadasParaTelecobroOnLine (DTOLlamadaTelecobro dto) throws MareException {
        UtilidadesLog.info("MONINTIVRBean.generarLlamadasParaTelecobroOnLine(DTOLlamadaTelecobro dto): Entrada");
        DTOBatch dtoBatch = new DTOBatch( "Generar Llamadas para Telecobro", new MareBusinessID("INTGenerarLlamadasParaTelecobro"), dto); 
        
        try{
            BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
        }
        catch(RemoteException re){            
            UtilidadesLog.debug("Error RemoteException generarLlamadasParaTelecobroOnLine");
            throw new MareException(re, UtilidadesError.armarCodigoError(
            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }        

        UtilidadesLog.info("MONINTIVRBean.generarLlamadasParaTelecobroOnLine(DTOLlamadaTelecobro dto): Salida");
    }

    public void enviarIVRSistemaNovedad(MareDTO dtoe) throws MareException {
        UtilidadesLog.info("MONINTIVRBean.enviarIVRSistemaNovedad(MareDTO dtoe): Entrada");
        DTOEINTIVR dtoEINTIVR = this.inicializarDatosSistema(dtoe);
        dtoEINTIVR.setNovedad(Boolean.TRUE);
        this.enviarIVRSistema(dtoEINTIVR);
        UtilidadesLog.info("MONINTIVRBean.enviarIVRSistemaNovedad(MareDTO dtoe): Salida");
    }

    public void enviarIVRSistemaCompleto(MareDTO dtoe) throws MareException {
        UtilidadesLog.info("MONINTIVRBean.enviarIVRSistemaCompleto(MareDTO dtoe): Entrada");
        DTOEINTIVR dtoEINTIVR = this.inicializarDatosSistema(dtoe);
        dtoEINTIVR.setNovedad(Boolean.FALSE);
        this.enviarIVRSistema(dtoEINTIVR);
        UtilidadesLog.info("MONINTIVRBean.enviarIVRSistemaCompleto(MareDTO dtoe): Salida");
    }

    private DTOEINTIVR inicializarDatosSistema(MareDTO dtoe)throws MareException{
        UtilidadesLog.info("MONINTIVRBean.inicializarDatosSistema(MareDTO dtoe): Entrada");
        
        Long pais = null;
        Long marca = null;
        Long canal = null;
        Long periodo = null;
        
        MarcaLocalHome marcaLH = this.getMarcaLocalHome();
        MarcaLocal marcaL = null;
        CanalLocalHome canalLH = this.getCanalLocalHome();
        CanalLocal canalL = null;
        
        // Asignamos el pais
        try{
            pais = new Long(dtoe.getLong("oidPais"));
        }catch(NoSuchElementException e){
            UtilidadesLog.debug("Error inicializarDatosSistema No se encuentra el pais");
            throw new MareException(new Exception("No se encuentra el pais"));
        }

        //Asignamos la marca
        try{
            marca = new Long(dtoe.getLong("oidMarca"));
        }catch(NoSuchElementException e){
            try{
                marcaL = marcaLH.findByUK(ConstantesSEG.COD_MARCA_T);
                marca = marcaL.getOid();
            }catch(NoResultException fe){
                try{
                    marcaL = marcaLH.findByUK(ConstantesSEG.COD_MARCA_EB);
                    marca = marcaL.getOid();
                }catch(NoResultException fem){
                    UtilidadesLog.debug("Error inicializarDatosSistema No se encuentra la marca");
                    throw new MareException(new Exception("No se encuentra la marca"));
                }
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }

        // Asignamos el canal
        try{
            canal = new Long(dtoe.getLong("oidCanal"));
        }catch(NoSuchElementException e){
            try{
                //canal = ConstantesSEG.CANAL_VD;
                canalL = canalLH.findByUK(ConstantesSEG.COD_CANAL_VD);
                canal = canalL.getOid();
            }catch(NoResultException fe){
                UtilidadesLog.debug("Error inicializarDatosSistema No se encuentra el Canal");
                throw new MareException(new Exception("No se encuentra el Canal"));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }
        
        // Obtenemos el periodo
        try{
            periodo = new Long(dtoe.getLong("oidPeriodo"));
        }catch(NoSuchElementException e){
            DAOCRA dao = new DAOCRA();
            DTOPeriodo dtoPeriodo= new DTOPeriodo();
            dtoPeriodo.setMarca(marca);
            dtoPeriodo.setCanal(canal);
            dtoPeriodo.setPais(pais);
            dtoPeriodo.setOidPais(pais);
            dtoPeriodo.setFechaInicio(new java.sql.Date(System.currentTimeMillis()));
            
            DTOSalida dtoSalida = dao.obtienePeriodosFecha(dtoPeriodo);
            RecordSet periodos = dtoSalida.getResultado();
            if (periodos.getValueAt(0,0)!=null){
                periodo = new Long(((BigDecimal)periodos.getValueAt(0,0)).longValue());
            }else{
                UtilidadesLog.debug("Error inicializarDatosSistema No se encuentra el Periodo");
                throw new MareException(new Exception("No se encuentra el Periodo"));
            }
        }
        
        DTOString dtoString = new DTOString();
        dtoString.setCadena(IIVR.COD_INTERFAZ_IVR1);
        dtoString.setOidPais(pais);
        
        // Obtenemos el numero de lote
        MONINT monINT = this.getMONINT();
        DTOCargaInicialInterfaz dtoCargaInicial = null;
        try{
            dtoCargaInicial = monINT.cargaInicial(dtoString);
        }catch(RemoteException re){            
            UtilidadesLog.debug("Error RemoteException generarLlamadasParaTelecobroOnLine");
            throw new MareException(re, UtilidadesError.armarCodigoError(
            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        // Rellenamos el DTO a devolver
        DTOEINTIVR dtoEINTIVR = new DTOEINTIVR();
        dtoEINTIVR.setOidCanal(canal);
        dtoEINTIVR.setOidMarca(marca);
        dtoEINTIVR.setOidPeriodo(periodo);
        dtoEINTIVR.setOidPais(pais);
        dtoEINTIVR.setNumeroLote(dtoCargaInicial.getNumeroLote().toString());
        dtoEINTIVR.setDescripcionLote(dtoCargaInicial.getDescripcion());
        
        UtilidadesLog.info("MONINTIVRBean.inicializarDatosSistema(MareDTO dtoe): Salida");
        return dtoEINTIVR;        
    }


    public DTOSalidaBatch enviarTablaProductos(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONINTIVRBean.enviarTablaProductos(DTOBatch dtoBatch): Entrada");
        String codigo = IIVR.COD_INTERFAZ_IVR14;
        
        try{
            init(dtoBatch,codigo);
        } catch (MareException e){            
            UtilidadesLog.error(" [ "+codigo+" ] Fallo al realizar init en enviarTablaProductos ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        }
        
        java.util.Date ultimaFecha = null;
        if (dtoe.getNovedad().booleanValue()){
            UtilidadesLog.debug("Entra x Novedad");
            Long [] listaCriterios = {dtoe.getOidPais(), dtoe.getOidMarca(), dtoe.getOidCanal(), dtoe.getOidAcceso(), dtoe.getOidPeriodo()};
            UtilidadesLog.debug("Lista de criterios "+listaCriterios);
            try{
                ultimaFecha = this.getMONINT().obtenerUltimaFecha(listaCriterios, codigo);    
                UtilidadesLog.debug("UltimaFecha: "+ultimaFecha);
            } catch (RemoteException e){                
                UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException. obtenerUltimaFecha");
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            UtilidadesLog.debug("Lista criterios: "+ this.interfaz.getCriteriosConsulta() +" Asignada");
        }else{
            UtilidadesLog.debug("Envio completo -> fecha null");
            ultimaFecha = null;
        }
        
        DAOINTIVR dao = new DAOINTIVR();
        ArrayList productos = dao.obtenerProductos(dtoe.getOidPais(),ultimaFecha);

        if(productos.isEmpty()){
                String mensaje = "TablaProductos Sin Registros";
                return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado " + mensaje );
        }
        
        for (int i = 0; i < productos.size(); i ++){
            DTODatosProductos dto = (DTODatosProductos) productos.get(i);

            try{
                registro.vaciar();
                registro.anyadirCampo( IIVR.IVR14_CODIGO_PRODUCTO, dto.getCodigoProducto());
                registro.anyadirCampo( IIVR.IVR14_DESCRIPCION_PRODUCTO, dto.getDescripcionProducto());
            } catch(InterfacesException e){
                UtilidadesLog.error(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarTablaProductos  ");                
                registro.vaciar();
                continue;
            }
            
            try{
                UtilidadesLog.debug("Enviamos la lista de criterios: "+this.interfaz.getCriteriosConsulta());
                gi.anyadirRegistro(this.interfaz,registro);
            }
            catch(RemoteException re){                 
                 UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException en anyadirRegistro");
                 throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            catch(InterfacesException iex){
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.error(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarTablaProductos  ");                
            }
            
            registro.vaciar();
        }
        try{
            gi.enviarInterfaz(this.interfaz);
        }
        catch(InterfacesException iex){
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  iex.getMotivo()  + " ( "+ iex.getEx() + " )", iex );            
        }
        catch(RemoteException re){            
            UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.info("MONINTIVRBean.enviarTablaProductos(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch(0, "Interfaz " + codigo + " procesada");
    }

    public DTOSalidaBatch enviarConsultoraCuentaCastigada(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONINTIVRBean.enviarConsultoraCuentaCastigada(DTOBatch dtoBatch): Entrada");
        
        String codigo = IIVR.COD_INTERFAZ_IVR15;
        
        try{        
             init( dtoBatch, codigo );
        }catch(MareException e){             
             UtilidadesLog.error(" [ "+codigo+" ] Fallo al realizar init en enviarConsultoraCuentaCastigada ");
             return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        } 
        
        Date ultimaFecha = null;
        if(dtoe.getNovedad().booleanValue()){
            Long[] listaCriterios = {dtoe.getOidPais(), dtoe.getOidMarca(), dtoe.getOidCanal(), dtoe.getOidAcceso(), dtoe.getOidPeriodo()};
            MONINT monINT = this.getMONINT();
            
            try{
                ultimaFecha = monINT.obtenerUltimaFecha(listaCriterios, codigo);
            }catch(RemoteException e){                
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }else{
            ultimaFecha = null;
        }

        DAOINTIVR dao = new DAOINTIVR();         
        ArrayList consultorasCuentas = dao.obtenerConsultorasCuentaCastigada( dtoe.getOidPais(),ultimaFecha);

        if(consultorasCuentas.isEmpty()){
             String mensaje = "Consultoras Cuentas Sin Registros";
             return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado " + mensaje );
        }
        
        DTOString dto = null;
        int n = consultorasCuentas.size();
        
        for(int i=0;i<n;i++){
            dto = (DTOString) consultorasCuentas.get(i);

            try{
                registro.anyadirCampo( IIVR.IVR15_NUMERO_DOCUMENTO, dto.getCadena());
                registro.anyadirCampo( IIVR.IVR15_ESTADO,IIVR.C);            
            }
            catch(InterfacesException iex ){
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.error(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarConsultoraCuentaCastigada ");                
                continue;
            }            
            
            // Se añade el registro al fichero de interfaz 
            try{
                gi.anyadirRegistro(this.interfaz,registro);
            }
            catch(RemoteException re){
                 UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException");
                 throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            catch(InterfacesException iex){
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.error(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarConsultoraCuentaCastigada ");                
            }
            
            registro.vaciar();
        }
        
        try{
            gi.enviarInterfaz(this.interfaz);
        }
        catch(InterfacesException iex){
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  iex.getMotivo()  + " ( "+ iex.getEx() + " )", iex );            
        }
        catch(RemoteException re){
            UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }        

        UtilidadesLog.info("MONINTIVRBean.enviarConsultoraCuentaCastigada(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "Interfaz " + codigo + " procesada" );
    }

    public DTOSalidaBatch enviarTablaLineaCredito (DTOBatch dtoBatch) throws MareException{
        UtilidadesLog.info("MONINTIVRBean.enviarTablaLineaCredito(DTOBatch dtoBatch): Entrada");
        
        java.util.Date ultimaFecha = null;
        DTOSalidaBatch dtoSalidaBatch=null;
        String codigo = IIVR.COD_INTERFAZ_IVR13;
        
        try{
            init(dtoBatch, codigo);
        }catch (MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarTablaLineaCredito ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        }
        
        if(dtoe.getNovedad().booleanValue()){
            // Construimos un Array de Long con los siguientes campos del dto (pais, oidMarca, oidCanal, oidAcceso, oidPeriodo) 
            Long[] listaCriterios  = {dtoe.getOidPais() , dtoe.getOidMarca(), dtoe.getOidCanal(), dtoe.getOidAcceso(), dtoe.getOidPeriodo()};
            try {
               ultimaFecha = this.getMONINT().obtenerUltimaFecha(listaCriterios, codigo);
            } catch(RemoteException re){                
                UtilidadesLog.error("*** MONINTIVR:enviarTablaLineaCredito: RemoteException al obtener referencia de MONINT", re);
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
         
        }else{
            ultimaFecha = null;
        }
        DAOINTIVR dao = new DAOINTIVR();
        ArrayList lineaCredito = dao.obtenerClientesLineaCredito( dtoe.getOidPais(), ultimaFecha );
        if(lineaCredito.isEmpty()){
            String mensaje = "ClientesLineaCredito Sin Registros";
            return new DTOSalidaBatch(0, "Interfaz " + codigo + " finalizado " + mensaje);
        }
        
        DAOSolicitud daoSolicitud = new DAOSolicitud();
        
        BigDecimal SNA = null;
        BigDecimal DT = null;
        DTOSaldosPorFechas dtoSalPorFechas = null;
        DTOSaldosPorFechasyVtos dtoSalporFechasVtos = null;
        DTOTotal dtoTotal = null;
        BigDecimal C3 = null;
        BigDecimal lineaDisponible = null;
        DTODatosLineaCredito dtoDatosLineaCredito = null;
        
        MONInterfaceModulos monInterfaceModulos = this.getMONInterfaceModulos();
        
        int tamanio = lineaCredito.size();        
        
        for (int i=0; i < tamanio; i++) {
            dtoDatosLineaCredito = (DTODatosLineaCredito)lineaCredito.get(i);
            UtilidadesLog.debug(" [ "+codigo+" ] DTO a ingresar DTODatosLineaCredito "+ dtoDatosLineaCredito);
            try {
                // Calcula el número de solicitudes nuevas aprobadas pendientes de facturar 
                SNA = daoSolicitud.calcularMontoSolicitudesNuevas(dtoDatosLineaCredito.getOidCliente()); 
                if (SNA==null){
                    SNA = new BigDecimal(0);
                }
                
                // Calcula la deuda total          
                dtoSalporFechasVtos = new DTOSaldosPorFechasyVtos();
                dtoSalporFechasVtos.setOidPais(this.dtoe.getOidPais());
                dtoSalporFechasVtos.setOidIdioma(this.dtoe.getOidIdioma());
                dtoSalporFechasVtos.setOidCliente(dtoDatosLineaCredito.getOidCliente());                
                              
                dtoTotal = monInterfaceModulos.calcularSaldoCCCliente(dtoSalporFechasVtos);                               
                
                if (dtoTotal.getTotal()!=null){
                    DT = dtoTotal.getTotal();     
                }else{
                    DT = new BigDecimal(0);
                }
            
                // Calcula el valor del cupón de trámite                 
                dtoSalPorFechas = new DTOSaldosPorFechas();
                dtoSalPorFechas.setOidCliente(dtoDatosLineaCredito.getOidCliente());
                dtoSalPorFechas.setOidPais(this.dtoe.getOidPais());
                dtoSalPorFechas.setOidIdioma(this.dtoe.getOidIdioma());
                
                dtoTotal = monInterfaceModulos.calcularCuponTramiteCliente(dtoSalPorFechas); 
                if (dtoTotal.getTotal()!=null){
                    C3 = dtoTotal.getTotal();     
                }else{
                    C3 = new BigDecimal(0);
                }

                if (dtoDatosLineaCredito.getLineaCredito()!=null){
                    lineaDisponible = new BigDecimal(dtoDatosLineaCredito.getLineaCredito().doubleValue() - SNA.doubleValue() - DT.doubleValue() + C3.doubleValue());
                }else{
                    lineaDisponible = new BigDecimal(SNA.doubleValue() - DT.doubleValue() + C3.doubleValue());
                }
                 /*LEER NOTA AL COMIENZO CLASE*/
                registro.anyadirCampo( IIVR.IVR13_CODIGO_CLIENTE, "0" + dtoDatosLineaCredito.getCodCliente()); 
                registro.anyadirCampo( IIVR.IVR13_NIVEL_RIESGO, dtoDatosLineaCredito.getNivelRiesgo()); 
                registro.anyadirCampo( IIVR.IVR13_LINEA_CREDITO, dtoDatosLineaCredito.getLineaCredito()); 
                registro.anyadirCampo( IIVR.IVR13_CREDITO_DISPONIBLE, lineaDisponible ) ;
                
                // Se añade el registro al fichero de interfaz 
                gi.anyadirRegistro(interfaz, registro);  
                registro.vaciar();
                
                
            }catch (RemoteException e){                
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }catch( InterfacesException e ) { 
                // Se registra la excepción con el servicio MareLogging
                UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarTablaLineaCredito ");                
                continue;
            }
        }
        
        try {
            gi.enviarInterfaz( interfaz );
        } catch( InterfacesException e ) { 
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  e.getMotivo()  + " ( "+ e.getEx() + " )", e );            
        } catch (RemoteException e) {            
            UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
            throw new MareException(e, UtilidadesError.armarCodigoError(
            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.debug(" [ "+codigo+" ] MONINTIVR:enviarTablaLineaCredito  ---->SALIDA ");                                        
        //return new DTOSalidaBatch( 0, "Interfaz " + codigo + " procesada" )
        UtilidadesLog.info("MONINTIVRBean.enviarTablaLineaCredito(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch(0, "Interfaz " + codigo + " procesada");
    } 


    private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinessFacadeBATCH");
    }


    /*
	 * rgiorgi - 27/8/2005: se corrigen null pointer exceptions.
	 * 						se modifica el campo codigo concurso por desc.
	 * */
    public DTOSalidaBatch enviarTablaConcursos(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONINTIVRBean.enviarTablaConcursos(DTOBatch dtoBatch): Entrada");
        
        java.util.Date ultimaFecha = null;
        DTOSalidaBatch dtoSalidaBatch=null;
        String codigo = IIVR.COD_INTERFAZ_IVR5;
        
        try{
            init(dtoBatch, codigo);
        }catch (MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en enviarTablaConcursos ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        }
        
        if(this.dtoe.getNovedad().booleanValue()){
            // Construimos un Array de Long con los siguientes campos del dto (pais, oidMarca, oidCanal, oidAcceso, oidPeriodo) 
            Long[] listaCriterios  = {this.dtoe.getOidPais() , this.dtoe.getOidMarca(), this.dtoe.getOidCanal(), this.dtoe.getOidAcceso(), this.dtoe.getOidPeriodo()};
            try {
               ultimaFecha = this.getMONINT().obtenerUltimaFecha(listaCriterios, codigo);
            } catch(RemoteException re){                
                UtilidadesLog.error("*** MONINTIVR:enviarTablaConcursos: RemoteException al obtener referencia de MONINT", re);
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
         
        }else{
            ultimaFecha = null;
        }
        
        //Vamos a obtener el periodo actual que necesitamos
        DTOPeriodo dtoPeriodoActual=null;
        try {
            dtoPeriodoActual = this.getMONPeriodos().obtienePeriodoActual(this.dtoe.getOidPais(), this.dtoe.getOidMarca(), this.dtoe.getOidCanal()); 
        }catch(RemoteException re) {            
            UtilidadesLog.error("*** MONINTIVR:enviarTablaConcursos: RemoteException al obtener referencia de MONPeriodo", re);
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        DAOINTIVR dao = new DAOINTIVR();
        ArrayList listaConcursos = dao.obtenerConcursos( this.dtoe.getOidPais(), dtoPeriodoActual.getOid(), ultimaFecha);
        if(listaConcursos.isEmpty()) {
            String mensaje = "enviarTablaConcursos SinRegistros";
            return new DTOSalidaBatch(0, "Interfaz " + codigo + " finalizado " + mensaje);
        }
        
        Long periodoVigencia = null;
        String indVigencia = null;
        DAOCRA daoCra = new DAOCRA();

        int tamanio = listaConcursos.size();        
        DTODatosConcursos dtoDatosConcursos = null;
        for (int i=0; i < tamanio; i++) {
            dtoDatosConcursos = (DTODatosConcursos)listaConcursos.get(i);
            UtilidadesLog.debug(" [ "+codigo+" ] DTO a ingresar DTODatosConcursos "+ dtoDatosConcursos);
            try {
                registro.vaciar();
                /*LEER NOTA AL COMIENZO CLASE*/
                registro.anyadirCampo(IIVR.IVR5_CODIGO_CONSULTORA, "0" + dtoDatosConcursos.getCodCliente());
                
                
                if (dtoDatosConcursos.getOidPeriodoDespacho() == null) { 
                //Vamos a calcular: periodoVigencia = periodoHasta + numPeriodos, para ello llamamos tantas veces como número de periodos tengamos a obtienePeriodoSiguiente pasandole el periodo que vamos obteniendo. 
                    periodoVigencia = dtoDatosConcursos.getOidPeriodoHasta(); 
					if (dtoDatosConcursos.getNumPeriodos() != null){
						int numPeriodos = dtoDatosConcursos.getNumPeriodos().intValue();
						for (int j=0; j < numPeriodos; j++) { 
							periodoVigencia = daoCra.obtienePeriodoSiguiente(periodoVigencia); 
						} 
					}
                } else { 
                    periodoVigencia = dtoDatosConcursos.getOidPeriodoDespacho(); 
                } 
                
                //vamos a comparar el periodoVigencia obtenido, con el periodo actual recibido por el método, según sea mayor o menor ponemos un indicador diferente 
                PeriodoLocalHome pVigenciaLocalHome=this.getPeriodoLocalHome();
                PeriodoLocal pVigenciaLocal=null;
                PeriodoLocalHome pActualLocalHome=this.getPeriodoLocalHome();
                PeriodoLocal pActualLocal=null;
                try { 
                    pVigenciaLocal = pVigenciaLocalHome.findByPrimaryKey(periodoVigencia);// de la entidad Periodo (CRA) 
                    pActualLocal = pActualLocalHome.findByPrimaryKey(dtoPeriodoActual.getOid());// de la entidad Periodo (CRA) 
                }catch( NoResultException fex ) { 
                    UtilidadesLog.debug(" FinderException en enviarTablaConcursos nos salimos  periodo  ");
                    String mensaje = "enviarTablaConcursos: " + ErroresDeNegocio.INT_0060;
                    DTOINTError dtoError = new DTOINTError( this.interfaz, null, mensaje ); 
                    gi.registrarError( dtoError ); 
                    continue; 
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                } 
                
                if (pActualLocal.getFechaFin().compareTo(pVigenciaLocal.getFechaFin()) > 0) {
                    indVigencia = IIVR.V; 
                }
                else { 
                    indVigencia = IIVR.T; 
                } 
                
                registro.anyadirCampo( IIVR.IVR5_PERIODO_FIN_CONCURSO, indVigencia); 
                /*mdolce 16/10/2006 Se parsea el numero de concurso, se le saca
                 *la barra / y el 0(cero) presente en la segunda mitad del numero
                 * */
                String concurso = dtoDatosConcursos.getNumeroConcurso();
                String mitadInicial = concurso.substring(0,2);
                String mitadFinal = concurso.substring(4,6);
                
                String concursoFinal = mitadInicial + mitadFinal;
                
                registro.anyadirCampo( IIVR.IVR5_NUMERO_CONCURSO, concursoFinal);
                registro.anyadirCampo( IIVR.IVR5_TIPO_CONCURSO, dtoDatosConcursos.getTipoConcurso());//convertido a String
                registro.anyadirCampo( IIVR.IVR5_PUNTAJE_OBTENIDO, dtoDatosConcursos.getPuntajeAcumulado());

                
                // Se añade el registro al fichero de interfaz 
                gi.anyadirRegistro(this.interfaz, registro);  
                registro.vaciar();
                
                
            }catch (RemoteException e){                
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }catch( InterfacesException e ) { 
                // Se registra la excepción con el servicio MareLogging
                UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarTablaConcursos ");                
                continue;
            }
        }
        
        try {
            gi.enviarInterfaz( this.interfaz );
        } catch( InterfacesException e ) { 
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  e.getMotivo()  + " ( "+ e.getEx() + " )", e );            
        } catch (RemoteException e) {            
            UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
            throw new MareException(e, UtilidadesError.armarCodigoError(
            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.debug(" [ "+codigo+" ] MONINTIVR:enviarTablaConcursos  ---->SALIDA ");                                        
        UtilidadesLog.info("MONINTIVRBean.enviarTablaConcursos(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch(0, "Interfaz " + codigo + " procesada");
    }

    public DTOSalidaBatch enviarTablaBasesIncumplidas(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONINTIVRBean.enviarTablaBasesIncumplidas(DTOBatch dtoBatch): Entrada");
        String codigo = IIVR.COD_INTERFAZ_IVR6;
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTIVR:enviarTablaBasesIncumplidas  " +
                           "---->Entrada\n\n\n  dtoBatch   " + dtoBatch);
               
        try{        
             init( dtoBatch, codigo );
        }catch(MareException e){             
             UtilidadesLog.error(" [ "+codigo+" ] Fallo al realizar init en enviarTablaBasesIncumplidas ");
             return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        } 
       
       boolean agregoRegistros = false; 
       
       try{
        Date ultimaFecha = null;
        if(this.dtoe.getNovedad().booleanValue()){
            Long[] listaCriterios = {this.dtoe.getOidPais(), this.dtoe.getOidMarca(),
            this.dtoe.getOidCanal(), this.dtoe.getOidAcceso(), this.dtoe.getOidPeriodo()};
            MONINT monINT = this.getMONINT();
            
            try{
                ultimaFecha = monINT.obtenerUltimaFecha(listaCriterios, codigo);
            }catch(RemoteException e){                
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }else{
            ultimaFecha = null;
        }
        UtilidadesLog.debug("******La ultima fecha es : " +ultimaFecha);
        UtilidadesLog.debug("******Interfaz antes de mandarse tiene : " +interfaz.toString());
        
        //Vamos a obtener el periodo actual que necesitamos
        DTOPeriodo dtoPeriodoActual = null;
        try {
            dtoPeriodoActual = this.getMONPeriodos().obtienePeriodoActual(this.dtoe.getOidPais(), this.dtoe.getOidMarca(), this.dtoe.getOidCanal()); 
        }catch(RemoteException re) {            
            UtilidadesLog.error("*** MONINTIVR:enviarTablaBasesIncumplidas: RemoteException al obtener referencia de MONPeriodo", re);
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        DAOINTIVR dao = new DAOINTIVR();         
        ArrayList basesIncumplidas = dao.obtenerBasesIncumplidas( this.dtoe.getOidPais(), dtoPeriodoActual.getOid(), ultimaFecha);
        if(basesIncumplidas.isEmpty()){
              UtilidadesLog.debug("*****entra en  basesIncumplidas.isEmpty() : " );
             String mensaje = "enviarTablaBasesIncumplidas: " + ErroresDeNegocio.INT_0033;
             DTOINTError dtoError = new DTOINTError( this.interfaz, this.registro, mensaje ); 
              try {
                  this.gi.registrarError( dtoError ); 
              }
              catch (InterfacesException iex) {
                  UtilidadesLog.debug(" [ "+codigo+" ] InterfacesException "+
                                     "MONINTIVR:enviarTablaBasesIncumplidas " +  
                                     iex.getMotivo()  + 
                                     " ( "+ iex.getEx() + " )", iex );                        
                
              }
             try{       
                gi.enviarInterfaz(this.interfaz);
             }catch(InterfacesException iex){
                UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  iex.getMotivo()  + " ( "+ iex.getEx() + " )", iex );            
             }catch(RemoteException re){            
                UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }  
            
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado " + mensaje );
        }
        
        DTODatosBasesIncumplidas dtoDatosBasesIncumplidas = null;
        int n = basesIncumplidas.size();
        
        for(int i=0;i<n;i++){
            dtoDatosBasesIncumplidas = (DTODatosBasesIncumplidas)basesIncumplidas.get(i);

            try{
            	registro.vaciar();
            	  /*LEER NOTA AL COMIENZO CLASE*/
                registro.anyadirCampo( IIVR.IVR6_CODIGO_CONSULTORA, "0" + dtoDatosBasesIncumplidas.getCodCliente() ); 
                /*mdolce 16/10/2006 Se parsea el numero de concurso, se le saca
                 *la barra / y el 0(cero) presente en la segunda mitad del numero
                 * */
                String concurso = dtoDatosBasesIncumplidas.getNumConcurso();
                String mitadInicial = concurso.substring(0,2);
                String mitadFinal = concurso.substring(4,6);
                
                String concursoFinal = mitadInicial + mitadFinal;
                
                registro.anyadirCampo( IIVR.IVR6_NUMERO_CONCURSO, concursoFinal); 
                registro.anyadirCampo( IIVR.IVR6_BASE_INCUMPLIDA, dtoDatosBasesIncumplidas.getBaseIncumplida().toString());
                
                PeriodoLocalHome periodoLocalHome = this.getPeriodoLocalHome();
                PeriodoLocal periodoLocal = null;
                        
                try { 
                    periodoLocal = periodoLocalHome.findByPrimaryKey(dtoPeriodoActual.getOid());//de la entidad Periodo (CRA) 
                }catch( NoResultException fex ) { 
                    DTOINTError dtoError = new DTOINTError( this.interfaz, registro, ErroresDeNegocio.INT_0060); 
                    try{
                        gi.registrarError(dtoError);
                    }catch(RemoteException rex){
                        UtilidadesLog.debug("[ "+codigo+" ] RemoteException MONINTIVR:enviarTablaBasesIncumplidas");                        
                        throw new MareException(rex, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }catch (InterfacesException iex){
                        UtilidadesLog.debug(" [ "+codigo+" ] InterfacesException MONINTIVR:enviarTablaBasesIncumplidas " +  iex.getMotivo()  + " ( "+ iex.getEx() + " )", iex );                        
                    }
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                
                PeriodoCorporativoLocalHome periodoCorporativoLocalHome = this.getPeriodoCorporativoLocalHome();
                PeriodoCorporativoLocal periodoCorporativoLocal = null;
                         
                try { 
                    periodoCorporativoLocal = periodoCorporativoLocalHome.findByPrimaryKey(periodoLocal.getOidPeriodoCorporativo());//de la entidad SEG: Periodo 
                }catch( NoResultException fex ) { 
                    DTOINTError dtoError = new DTOINTError( this.interfaz, registro, ErroresDeNegocio.INT_0080); 
                    try{
                        gi.registrarError(dtoError);
                    }catch(RemoteException rex){
                        UtilidadesLog.debug("[ "+codigo+" ] RemoteException MONINTIVR:enviarTablaBasesIncumplidas");                        
                        throw new MareException(rex, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }catch (InterfacesException iex){
                        UtilidadesLog.debug(" [ "+codigo+" ] InterfacesException MONINTIVR:enviarTablaBasesIncumplidas " +  iex.getMotivo()  + " ( "+ iex.getEx() + " )", iex );                        
                    }
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                    
                registro.anyadirCampo( IIVR.IVR6_CAMPANIA_INCUMPLIDA, periodoCorporativoLocal.getCodigoPeriodo()); 
                    
                // Calculamos el saldo
                DTOSaldosPorFechasyVtos dTOSaldosPorFechasyVtos = new DTOSaldosPorFechasyVtos();
                dTOSaldosPorFechasyVtos.setOidCliente(dtoDatosBasesIncumplidas.getOidCliente());
                dTOSaldosPorFechasyVtos.setOidPais(this.dtoe.getOidPais());
                dTOSaldosPorFechasyVtos.setOidIdioma(this.dtoe.getOidIdioma());
                BigDecimal saldo = null;
                try {
                    DTOTotal dtoTotal = this.getMONInterfaceModulos().calcularSaldoCCCliente(dTOSaldosPorFechasyVtos);
                    saldo = dtoTotal.getTotal().setScale(2,1);
                }catch(RemoteException rex){
                    UtilidadesLog.debug("[ "+codigo+" ] RemoteException MONINTIVR:enviarTablaBasesIncumplidas");                    
                    throw new MareException(rex, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                    
                registro.anyadirCampo( IIVR.IVR6_SALDO_CONSULTORA, saldo); 
                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                UtilidadesLog.debug("   - SAP601:  hago el 'format'");
                String sFecha = "";
              
                sFecha = sdf.format(new Date(System.currentTimeMillis()));
                
                
                registro.anyadirCampo( IIVR.IVR6_FECHA_SALDO, sFecha);
            
            }catch(InterfacesException iex ){
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.error(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarTablaBasesIncumplidas  ");                
                continue;
            }            
            
            // Se añade el registro al fichero de interfaz 
            try{
                gi.anyadirRegistro(this.interfaz,registro);
                agregoRegistros = true;
              
            }catch(RemoteException re){                 
                 UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException");
                 throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }catch(InterfacesException iex){
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.error(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarTablaBasesIncumplidas  ");                
            }
            
            registro.vaciar();
        }
        
       }catch(Exception exc) {
         
          String mensaje = "enviarTablaBasesIncumplidas: " +exc.getMessage();
					DTOINTError dtoError = new DTOINTError( this.interfaz, this.registro, mensaje ); 
          try {
            this.gi.registrarError( dtoError ); 
          }catch (InterfacesException iex) {
              UtilidadesLog.debug(" [ "+codigo+" ] InterfacesException "+
                                 "MONINTIVR:enviarTablaBasesIncumplidas " +  
                                 iex.getMotivo()  + 
                                 " ( "+ iex.getEx() + " )", iex );                          
          }catch (java.rmi.RemoteException rmiEx){
            UtilidadesLog.debug(" [ "+codigo+" ] InterfacesException "+
                                 "MONINTIVR:enviarTablaBasesIncumplidas " +  
                                 rmiEx.getMessage()  + 
                                 " ( "+ rmiEx.getCause() + " )", rmiEx );   
          }

          try{
            gi.enviarInterfaz(this.interfaz);
          }catch(InterfacesException iex){
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  iex.getMotivo()  + " ( "+ iex.getEx() + " )", iex );            
          }catch(RemoteException re){            
            UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          }        
          if (exc instanceof MareException){
            throw (MareException) exc;
          }else{
            throw new MareException (exc);
          }
       } 
       
       
        try{
            gi.enviarInterfaz(this.interfaz);
        }catch(InterfacesException iex){
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  iex.getMotivo()  + " ( "+ iex.getEx() + " )", iex );            
        }catch(RemoteException re){            
            UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }        

        UtilidadesLog.debug(" [ "+codigo+" ] MONINTIVR:enviarTablaBasesIncumplidas  " +
                           "---->Salida\n\n\n  dtoBatch   " +dtoBatch);
        UtilidadesLog.info("MONINTIVRBean.enviarTablaBasesIncumplidas(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "Interfaz " + codigo + " procesada" );
    }


    public DTOSalidaBatch enviarTablaNiveles(DTOBatch dtoBatch) throws MareException {
    UtilidadesLog.info("MONINTIVRBean.enviarTablaNiveles(DTOBatch dtoBatch): Entrada");
	String codigo = IIVR.COD_INTERFAZ_IVR7; 
        UtilidadesLog.debug(" [ "+codigo+" ] MONINTIVR:enviarTablaNiveles "   +
                           "---->Entrada\n\n\n  dtoBatch   " +dtoBatch);

        try{        
            init( dtoBatch, codigo );
        }catch(MareException e){            
            UtilidadesLog.debug(" [ "+codigo+" ] Fallo al realizar init en " +
                                "enviarTablaNiveles ");
            return new DTOSalidaBatch( 0, "Interfaz " + codigo + 
                                      " finalizado con error" );
        } 
		
		java.util.Date ultimaFecha = null;

		if ((this.dtoe.getNovedad() != null) && 
            (this.dtoe.getNovedad().booleanValue())) { 
                Long[] listaCriterios  = {this.dtoe.getOidPais(), 
                    this.dtoe.getOidMarca(), this.dtoe.getOidCanal(), 
                    this.dtoe.getOidAcceso(), this.dtoe.getOidPeriodo()};
            MONINT mONINT = this.getMONINT();
            try {
                ultimaFecha = mONINT.obtenerUltimaFecha(listaCriterios, codigo); 
            }
            catch (RemoteException e) {                
                UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
                throw new MareException(e, UtilidadesError.armarCodigoError(
										CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }else{
            ultimaFecha = null;
        } 

		Long puntaje = null;
		Long periodoDespacho = null; 

		//Vamos a obtener el periodo actual que necesitamos 
        DTOPeriodo dtoPeriodoActual = null;        
        
        try {
            dtoPeriodoActual = this.getMONPeriodos().obtienePeriodoActual(this.dtoe.getOidPais(),
                                                                          this.dtoe.getOidMarca(),
                                                                          this.dtoe.getOidCanal()); 
        }
        catch (RemoteException re) {            
            UtilidadesLog.error("*** MONINTIVR:enviarTablaNiveles: " +
                                "RemoteException al obtener referencia " + 
                                "de MONPeriodo", re);
            throw new MareException(re, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
		DTODatosNiveles dtoDatosNiveles = null;
        DAOINTIVR dAOINTIVR = new DAOINTIVR();

		ArrayList listaNiveles = 
			dAOINTIVR.obtenerNiveles(this.dtoe.getOidPais(),
            dtoPeriodoActual.getOidPeriodoCorporativo(),ultimaFecha);
       
		if(listaNiveles.isEmpty()) {
            String mensaje = "ListaNiveles Sin Registros";
            return new DTOSalidaBatch(0, "Interfaz " + codigo + " finalizado " + mensaje);
        }

		PeriodoLocalHome periodoHome = this.getPeriodoLocalHome();
		PeriodoLocal periodoLocal = null;
		PeriodoCorporativoLocalHome periodoCorporativoLocalHome = 
			this.getPeriodoCorporativoLocalHome();
		PeriodoCorporativoLocal periodoCorporativoLocal = null;

        DAOCRA dAOCRA = new DAOCRA();
		int tamaño = listaNiveles.size();
        
        for (int i=0; i<tamaño;i++ ) {
            dtoDatosNiveles = (DTODatosNiveles)listaNiveles.get(i);

			try{
       this.registro.vaciar();    
       /*mdolce 16/10/2006 Se parsea el numero de concurso, se le saca
       *la barra / y el 0(cero) presente en la segunda mitad del numero
       * */
       String concurso = dtoDatosNiveles.getNumeroConcurso();
       String mitadInicial = concurso.substring(0,2);
       String mitadFinal = concurso.substring(4,6);
      
       String concursoFinal = mitadInicial + mitadFinal;

				registro.anyadirCampo(IIVR.IVR7_NUMERO_CONCURSO, concursoFinal); 
				registro.anyadirCampo(IIVR.IVR7_NUMERO_NIVEL, dtoDatosNiveles.getNumeroNivel().toString());
				
				if (dtoDatosNiveles.getCantidadInicialPuntos() != null) { 
					puntaje = dtoDatosNiveles.getCantidadInicialPuntos(); 
				}else { 
					puntaje = dtoDatosNiveles.getCantidadFijaPuntos(); 
				} 

                registro.anyadirCampo( IIVR.IVR7_PUNTAJE_REQUERIDO, puntaje);

	
				if (dtoDatosNiveles.getOidPeriodoDespacho() == null) { 
					periodoDespacho = dtoDatosNiveles.getOidPeriodoHasta();

					for (i=0; i == dtoDatosNiveles.getNumPeriodos().intValue(); i++) { 
                        periodoDespacho = dAOCRA.obtienePeriodoSiguiente (periodoDespacho); 
					} 
				}
				else { 
					periodoDespacho = dtoDatosNiveles.getOidPeriodoDespacho(); 
				} 


				try{
					periodoLocal = periodoHome.findByPrimaryKey(periodoDespacho);
				}catch(NoResultException fex){
					UtilidadesLog.debug(" FinderException en enviarTablaNiveles " + 
                                       "nos salimos  periodo  ");
					String mensaje = "enviarTablaNiveles: " + ErroresDeNegocio.INT_0060;
					DTOINTError dtoError = new DTOINTError( this.interfaz, this.registro, mensaje ); 
                                        try {
                                            this.gi.registrarError( dtoError ); 
                                        }
                                        catch (InterfacesException iex) {
                                            UtilidadesLog.debug(" [ "+codigo+" ] InterfacesException "+
                                                               "MONINTIVR:enviarTablaNiveles " +  
                                                               iex.getMotivo()  + 
                                                               " ( "+ iex.getEx() + " )", iex );                        
                                            continue;
                                        }
                                        catch (RemoteException rex) {
                                            UtilidadesLog.debug("[ "+codigo+" ] RemoteException " +
                                                               "MONINTIVR:enviarTablaNiveles");                        
                                            throw new MareException(rex, UtilidadesError.armarCodigoError(
                                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                                        }
                                        continue;
                                }  catch (PersistenceException ce) {   
                                    UtilidadesLog.error("ERROR ", ce);
                                    throw new MareException(ce, 
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
				}            
				
				
				try{
					periodoCorporativoLocal = periodoCorporativoLocalHome.findByPrimaryKey(periodoLocal.getOidPeriodoCorporativo());
				}catch(NoResultException fex){
					UtilidadesLog.debug(" FinderException en enviarTablaNiveles " + 
                                       "nos salimos  periodoCorporativo  ");
					String mensaje = "enviarTablaNiveles: " + ErroresDeNegocio.INT_0080;
					DTOINTError dtoError = new DTOINTError( this.interfaz, this.registro, mensaje ); 
                                        try {
                                            this.gi.registrarError( dtoError ); 
                                        }
                                        catch (InterfacesException iex) {
                                            UtilidadesLog.debug(" [ "+codigo+" ] InterfacesException "+
                                                               "MONINTIVR:enviarTablaNiveles " +  
                                                               iex.getMotivo()  + 
                                                               " ( "+ iex.getEx() + " )", iex );                        
                                            continue;
                                        }
                                        catch (RemoteException rex) {
                                            UtilidadesLog.debug("[ "+codigo+" ] RemoteException " +
                                                               "MONINTIVR:enviarTablaNiveles");                        
                                            throw new MareException(rex, UtilidadesError.armarCodigoError(
                                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                                        }
                                                            continue;
                                }  catch (PersistenceException ce) {   
                                    UtilidadesLog.error("ERROR ", ce);
                                    throw new MareException(ce, 
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
				}
				
                registro.anyadirCampo(IIVR.IVR7_CAMPANA_DESPACHO,
                                      periodoCorporativoLocal.getCodigoPeriodo());

            } catch  (InterfacesException iex ){
                UtilidadesLog.debug(" [ "+codigo+" ] \n\n 1.- " + 
                                   "InterfacesException En enviarTablaNiveles ");                
                this.registro.vaciar();
                continue;            
            }
            
            // Se añade el registro al fichero de interfaz 
            try {
                this.gi.anyadirRegistro(this.interfaz, this.registro );
            }
            catch (InterfacesException iex) {
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.error(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarTablaBasesIncumplidas  ");                
            }
            catch (RemoteException re) {                 
                 UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException");
                 throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));                
            }
			UtilidadesLog.debug(" [ "+codigo+" ] hemos añadido el registro " +
                                " numero i = " +i);
            this.registro.vaciar();
		}	


		try { 
            this.gi.enviarInterfaz( this.interfaz );
		} catch( InterfacesException ie ) { 
			UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion " + 
                                "de la Interfaz " +  ie.getMotivo()  + 
                                " ( "+ ie.getEx() + " )", ie );			
        } catch (RemoteException e) {
            UtilidadesLog.debug(" [ "+codigo+" ] Error RemoteException");
            throw new MareException(e, UtilidadesError.armarCodigoError(
            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }        

		UtilidadesLog.debug(" [ "+codigo+" ] MONINTIVR:enviarTablaNiveles  ---->SALIDA ");
        UtilidadesLog.info("MONINTIVRBean.enviarTablaNiveles(DTOBatch dtoBatch): Salida");
		return new DTOSalidaBatch( 0, "Interfaz " + codigo + " procesada" );
	}     

    public DTOSalidaBatch enviarTablaPremios(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONINTIVRBean.enviarTablaPremios(DTOBatch dtoBatch): Entrada");
        
        String codigo = IIVR.COD_INTERFAZ_IVR12;
        
        try{        
             init( dtoBatch, codigo );
        }catch(MareException e){             
             UtilidadesLog.error(" [ "+codigo+" ] Fallo al realizar init en enviarTablaPremios ");
             return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado con error" );
        }        
        
        DAOINTIVR dao = new DAOINTIVR();         
        ArrayList listaPremios=dao.obtenerPremios(dtoe.getOidPais(),dtoe.getOidPeriodo());

        if(listaPremios.isEmpty()){
             String mensaje = "Lista Premios Sin Registros";
             return new DTOSalidaBatch( 0, "Interfaz " + codigo + " finalizado " + mensaje );
        }
        
        DTODatosPremios dto  = null;
        int n = listaPremios.size();
        
        for(int i=0;i<n;i++){
            dto = (DTODatosPremios) listaPremios.get(i);

            try{
                /*mdolce 16/10/2006 Se parsea el numero de concurso, se le saca
                *la barra / y el 0(cero) presente en la segunda mitad del numero
                * */
                String concurso = dto.getNumeroConcurso();
                String mitadInicial = concurso.substring(0,2);
                String mitadFinal = concurso.substring(4,6);
              
                String concursoFinal = mitadInicial + mitadFinal;
                registro.anyadirCampo( IIVR.IVR12_NUMERO_CONCURSO, concursoFinal); 
                
                if(dto.getNumeroNivel()!=null){
                     registro.anyadirCampo( IIVR.IVR12_NUMERO_NIVEL, dto.getNumeroNivel().toString());
                }else {
                     registro.anyadirCampo( IIVR.IVR12_NUMERO_NIVEL, null);
                }
                registro.anyadirCampo( IIVR.IVR12_CODIGO_PREMIO, dto.getCodProducto());
                registro.anyadirCampo( IIVR.IVR12_UNIDADES, dto.getNumUnidades());
            }
            catch(InterfacesException iex ){
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.error(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarTablaPremios ");                
                continue;
            }            
            
            // Se añade el registro al fichero de interfaz 
            try{
                this.gi.anyadirRegistro(this.interfaz,registro);
            }
            catch(RemoteException re){                 
                 UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException");
                 throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            catch(InterfacesException iex){
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.error(" [ "+codigo+" ] \n\n 1.-InterfacesException En enviarTablaPremios ");                
            }
            
            registro.vaciar();
        }
        
        try{
            gi.enviarInterfaz(this.interfaz);
        }
        catch(InterfacesException iex){
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " +  iex.getMotivo()  + " ( "+ iex.getEx() + " )", iex );            
        }
        catch(RemoteException re){            
            UtilidadesLog.error(" [ "+codigo+" ] Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }        

        UtilidadesLog.info("MONINTIVRBean.enviarTablaPremios(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch( 0, "Interfaz " + codigo + " procesada" );
    }
    
    private PaisLocalHome getPaisLocalHome() {
            return new PaisLocalHome();
    }

    private ClienteDatosBasicosLocalHome getClienteDatosBasicosLocalHome() {
            return new ClienteDatosBasicosLocalHome();
    }

    private ZonaLocalHome getZonaLocalHome() {
            return new ZonaLocalHome();
    }

    private MarcaLocalHome getMarcaLocalHome() {
            return new MarcaLocalHome();
    }

    private CanalLocalHome getCanalLocalHome() {
            return new CanalLocalHome();
    }

    private PeriodoLocalHome getPeriodoLocalHome() {
            return new PeriodoLocalHome();
    }

    private PeriodoCorporativoLocalHome getPeriodoCorporativoLocalHome() {
            return new PeriodoCorporativoLocalHome();
    }
    
    private EstadoLlamadaLocalHome getEstadoLlamadaLocalHome() {
            return new EstadoLlamadaLocalHome();
    }

    private PrioridadLocalHome getPrioridadLocalHome() {
            return new PrioridadLocalHome();
    }

    private EtapasDeudaTiposCargoLocalHome getEtapasDeudaTiposCargoLocalHome()
    {
    return new EtapasDeudaTiposCargoLocalHome();
    }

    private AccionesCobranzaLocalHome getAccionesCobranzaLocalHome()
    {
    return new AccionesCobranzaLocalHome();
    }


    private GestionesCobranzaLocalHome getGestionesCobranzaLocalHome()
    {
    return new GestionesCobranzaLocalHome();
    }


    
}