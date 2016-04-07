package es.indra.sicc.logicanegocio.ped;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.Date;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.ped.DTOInformacionSolicitud;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ped.DTOInformacionBasicaSolicitud;
import es.indra.sicc.dtos.ped.DTOInformacionClienteSolicitud;
import es.indra.sicc.dtos.ped.DTOInformacionAdministrativaSolicitud;
import es.indra.sicc.dtos.ped.DTOInformacionEconomicaSolicitud;
import es.indra.sicc.dtos.ped.DTOInformacionEstadoSolicitud;
import es.indra.sicc.dtos.ped.DTOConsultarPosicionesSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.ped.DTOBuscarSolicitud;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;

import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;



public class MONModificarSolicitudBean implements SessionBean  {
  public void ejbCreate() {
  }

  public void ejbActivate() {
  }

  public void ejbPassivate() {
  }

  public void ejbRemove() {
  }

  public void setSessionContext(SessionContext ctx) {
  }


  /**
  * Sistema:     Belcorp
  * Modulo:      PED
  * Fecha:       30/12/2004
  * @version     3.3
  * @autor       Pablo Perez (pperez)
  * Descripcion: 
  * @param    
  * @return   
  * @throws es.indra.mare.common.exception.MareException
  */
  public DTOInformacionSolicitud obtenerSolicitud(DTOOID dtoOid) throws MareException {
    /* Obtiene la información referente a una solicitud */ 
    
    // Obtiene la cabecera de la solicitud 
    /*
    DTOInformacionSolicitud = consultarCabeceraSolicitud(DTOOID) 
    
    Devuelve DTOInformacionSolicitud */
    return this.consultarCabeceraSolicitud(dtoOid);
  }

  public DTOInformacionBasicaSolicitud crearDTOInformacionBasicaSolicitud(RecordSet resultado) throws MareException {
    UtilidadesLog.info("MONModificarSolicitudBean.crearDTOInformacionBasicaSolicitud(RecordSet resultado): Entrada ");
    // Crea un DTOInformacionBasicaSolicitud con la información recuperada del RecordSet recibido y lo devuelve 

    //Crea un DTOInformacionBasicaSolicitud 
    DTOInformacionBasicaSolicitud dtoInfoBasicaSolicitud = new DTOInformacionBasicaSolicitud();

    dtoInfoBasicaSolicitud.setTipoSolicitud(objectToString(resultado.getValueAt(0,"TIPO_SOLICITUD")));
    dtoInfoBasicaSolicitud.setOidTipoSolicitud(objectToLong(resultado.getValueAt(0,"OID_TIPO_SOLICITUD")));
    dtoInfoBasicaSolicitud.setOidProceso(objectToLong(resultado.getValueAt(0,"OID_PROCESO")));
    dtoInfoBasicaSolicitud.setSubacceso(objectToString(resultado.getValueAt(0,"SUBACCESO")));
    dtoInfoBasicaSolicitud.setNumeroSolicitud(objectToLong(resultado.getValueAt(0,"NUMERO_SOLICITUD")));
    dtoInfoBasicaSolicitud.setMarca(objectToString(resultado.getValueAt(0,"MARCA")));
    dtoInfoBasicaSolicitud.setCanal(objectToString(resultado.getValueAt(0,"CANAL")));
    dtoInfoBasicaSolicitud.setPeriodo(objectToString(resultado.getValueAt(0,"PERIODO")));
    dtoInfoBasicaSolicitud.setAcceso(objectToString(resultado.getValueAt(0,"ACCESO")));
    dtoInfoBasicaSolicitud.setOidAccesoFisico(objectToLong(resultado.getValueAt(0,"ACCESO_FISICO")));
    dtoInfoBasicaSolicitud.setOidTipoDespacho(objectToLong(resultado.getValueAt(0,"TIPO_DESPACHO")));
    dtoInfoBasicaSolicitud.setSociedadVentas(objectToString(resultado.getValueAt(0,"SOCIEDAD_VENTAS")));
    
    dtoInfoBasicaSolicitud.setOidSubacceso(objectToLong(resultado.getValueAt(0,"OID_SBAC")));
    dtoInfoBasicaSolicitud.setOidMarca(objectToLong(resultado.getValueAt(0,"OID_MARC")));
    dtoInfoBasicaSolicitud.setOidCanal(objectToLong(resultado.getValueAt(0,"OID_CANA")));
    dtoInfoBasicaSolicitud.setOidPeriodo(objectToLong(resultado.getValueAt(0,"OID_PERI")));
    dtoInfoBasicaSolicitud.setOidAcceso(objectToLong(resultado.getValueAt(0,"OID_ACCE")));

    //Devuelve DTOInformacionBasicaSolicitud 
    UtilidadesLog.info("MONModificarSolicitudBean.crearDTOInformacionBasicaSolicitud(RecordSet resultado): Salida ");
    return dtoInfoBasicaSolicitud;
  }

  public DTOInformacionClienteSolicitud crearDTOInformacionClienteSolicitud(RecordSet resultado) throws MareException {
    // Crea un DTOInformacionClienteSolicitud con la información recuperada del RecordSet recibido y lo devuelve 
    UtilidadesLog.info("MONModificarSolicitudBean.crearDTOInformacionClienteSolicitud(RecordSet resultado): Entrada ");    
    DTOInformacionClienteSolicitud dtoInfoClienteSolicitud = new DTOInformacionClienteSolicitud();

    dtoInfoClienteSolicitud.setOidCliente(objectToLong(resultado.getValueAt(0,"OID_CLIENTE")));
    dtoInfoClienteSolicitud.setCodigoCliente(objectToString(resultado.getValueAt(0,"CODIGO_CLIENTE")));
    dtoInfoClienteSolicitud.setNombre(objectToString(resultado.getValueAt(0,"NOMBRE1")));
    dtoInfoClienteSolicitud.setApellido1(objectToString(resultado.getValueAt(0,"APELLIDO1")));
    dtoInfoClienteSolicitud.setApellido2(objectToString(resultado.getValueAt(0,"APELLIDO2")));
    dtoInfoClienteSolicitud.setTipoCliente(objectToString(resultado.getValueAt(0,"TIPO_CLIENTE")));
    dtoInfoClienteSolicitud.setSubtipoCliente(objectToString(resultado.getValueAt(0,"SUBTIPO_CLIENTE")));
    dtoInfoClienteSolicitud.setSubgerenciaCliente(objectToString(resultado.getValueAt(0,"SUBGERENCIA_VENTAS")));
    dtoInfoClienteSolicitud.setRegionCliente(objectToString(resultado.getValueAt(0,"REGION")));  
    dtoInfoClienteSolicitud.setZonaCliente(objectToString(resultado.getValueAt(0,"ZONA")));
    UtilidadesLog.debug("resultado.getValueAt(0,SECCION) " + resultado.getValueAt(0,"SECCION"));
    dtoInfoClienteSolicitud.setSeccionCliente(objectToString(resultado.getValueAt(0,"SECCION")));
    UtilidadesLog.debug("resultado.getValueAt(0,SECCION) " + resultado.getValueAt(0,"SECCION"));
    dtoInfoClienteSolicitud.setTerritorioCliente(objectToStringBig(resultado.getValueAt(0,"TERRITORIO")));
    UtilidadesLog.debug(" resultado.getValueAt(0,TERRITORIO)) " + resultado.getValueAt(0,"TERRITORIO")) ;
    dtoInfoClienteSolicitud.setUbigeoCliente(objectToString(resultado.getValueAt(0,"UBIGEO")));
    
    dtoInfoClienteSolicitud.setOidTipoCliente(objectToLong(resultado.getValueAt(0,"OID_TIPO_CLIE")));
    dtoInfoClienteSolicitud.setOidSubtipocliente(objectToLong(resultado.getValueAt(0,"OID_SUBT_CLIE")));
    dtoInfoClienteSolicitud.setOidSubgerenciaVentas(objectToLong(resultado.getValueAt(0,"OID_SUBG_VENT")));
    dtoInfoClienteSolicitud.setOidRegion(objectToLong(resultado.getValueAt(0,"OID_REGI")));
    dtoInfoClienteSolicitud.setOidZona(objectToLong(resultado.getValueAt(0,"OID_ZONA")));
    dtoInfoClienteSolicitud.setOidSeccion(objectToLong(resultado.getValueAt(0,"OID_SECC")));
    dtoInfoClienteSolicitud.setOidTerritorio(objectToLong(resultado.getValueAt(0,"OID_TERR")));

    // Devuelve DTOInformacionClienteSolicitud 
    UtilidadesLog.info("MONModificarSolicitudBean.crearDTOInformacionClienteSolicitud(RecordSet resultado): Salida ");    
    return dtoInfoClienteSolicitud;
  }

  public DTOInformacionAdministrativaSolicitud crearDTOInformacionAdministrativaSolicitud(RecordSet resultado) throws MareException {
    // Crea un DTOInformacionAdministrativaSolicitud con la información recuperada del RecordSet recibido y lo devuelve 
        UtilidadesLog.info("MONModificarSolicitudBean.crearDTOInformacionAdministrativaSolicitud(RecordSet resultado): Entrada ");
      DTOInformacionAdministrativaSolicitud dtoInfoAdministrativa = new DTOInformacionAdministrativaSolicitud();
      dtoInfoAdministrativa.setOidConsultoraAsociada(objectToLong(resultado.getValueAt(0,"OID_CONSULTORA_ASOCIADA")));
      dtoInfoAdministrativa.setConsultoraAsociada(objectToString(resultado.getValueAt(0,"CONSULTORA_ASOCIADA")));
      dtoInfoAdministrativa.setOidReceptorFactura(objectToLong(resultado.getValueAt(0,"OID_RECEPTOR_FACTURA")));
      dtoInfoAdministrativa.setReceptorFactura(objectToString(resultado.getValueAt(0,"RECEPTOR_FACTURA")));
      dtoInfoAdministrativa.setOidPagadorFactura(objectToLong(resultado.getValueAt(0,"OID_PAGADOR_FACTURA")));
      dtoInfoAdministrativa.setPagadorFactura(objectToString(resultado.getValueAt(0,"PAGADOR_FACTURA")));
      dtoInfoAdministrativa.setNumeroClientes(objectToInteger(resultado.getValueAt(0,"NUMERO_CLIENTES")));
      
      //BELC300023533 
      dtoInfoAdministrativa.setOidDestino(objectToLong(resultado.getValueAt(0,"OID_CLIENTE_DIRECCION")));
      
      dtoInfoAdministrativa.setOidTipoDocumentoIdentidad(objectToLong(resultado.getValueAt(0,"TIPO_DOC_IDENTIDAD")));
      dtoInfoAdministrativa.setNumeroDocumentoLegal(objectToLong(resultado.getValueAt(0,"NUMERO_DOC_LEGAL")));
      dtoInfoAdministrativa.setTipoDocumentoLegal(objectToString(resultado.getValueAt(0,"TIPO_DOC_LEGAL")));
      dtoInfoAdministrativa.setIndicadorImpuestos(objectToString(resultado.getValueAt(0,"INDICADOR_IMPUESTO")));
      dtoInfoAdministrativa.setOidFormaPago(objectToLong(resultado.getValueAt(0,"FORMA_PAGO")));
    
      dtoInfoAdministrativa.setOidTipoDocumento(objectToLong(resultado.getValueAt(0,"OID_TIPO_DOCU")));

    // Devuelve DTOInformacionAdministrativaSolicitud 
        UtilidadesLog.info("MONModificarSolicitudBean.crearDTOInformacionAdministrativaSolicitud(RecordSet resultado): Salida ");
    return dtoInfoAdministrativa;
  }

  public DTOInformacionEconomicaSolicitud crearDTOInformacionEconomicaSolicitud(RecordSet resultado) throws MareException {

    UtilidadesLog.info("MONModificarSolicitudBean.crearDTOInformacionEconomicaSolicitud(RecordSet resultado): Entrada ");
      // Crea un DTOInformacionEconomicaSolicitud con la información recuperada del RecordSet recibido y lo devuelve 
      DTOInformacionEconomicaSolicitud dtoInfoEconomicaSolicitud = new DTOInformacionEconomicaSolicitud();
      
      /*dtoInfoEconomicaSolicitud.setMoneda(objectToString(resultado.getValueAt(0,"MONEDA")));
      dtoInfoEconomicaSolicitud.setMontoDescuento1((BigDecimal)resultado.getValueAt(0,"MONTO1"));
      dtoInfoEconomicaSolicitud.setMontoDescuento2((BigDecimal)resultado.getValueAt(0,"MONTO2"));
      dtoInfoEconomicaSolicitud.setMontoDescuento3((BigDecimal)resultado.getValueAt(0,"MONTO3"));
      dtoInfoEconomicaSolicitud.setFletePagar((BigDecimal)resultado.getValueAt(0,"FLETE"));
      dtoInfoEconomicaSolicitud.setTotalImpuestos((BigDecimal)resultado.getValueAt(0,"IMPORTE_IMPUESTO"));
      dtoInfoEconomicaSolicitud.setTotalPagar((BigDecimal)resultado.getValueAt(0,"TOTAL_PAGAR"));       
      dtoInfoEconomicaSolicitud.setOidMoneda(objectToLong(resultado.getValueAt(0,"OID_MONE")));*/
      
      //inc. BELC300023533 
      dtoInfoEconomicaSolicitud.setMoneda(objectToString(resultado.getValueAt(0,38)));
      dtoInfoEconomicaSolicitud.setMontoDescuento1((BigDecimal)resultado.getValueAt(0,39));
      dtoInfoEconomicaSolicitud.setMontoDescuento2((BigDecimal)resultado.getValueAt(0,40));
      dtoInfoEconomicaSolicitud.setMontoDescuento3((BigDecimal)resultado.getValueAt(0,41));
      dtoInfoEconomicaSolicitud.setFletePagar((BigDecimal)resultado.getValueAt(0,42));
      dtoInfoEconomicaSolicitud.setTotalImpuestos((BigDecimal)resultado.getValueAt(0,43));
      dtoInfoEconomicaSolicitud.setTotalPagar((BigDecimal)resultado.getValueAt(0,44));       
      dtoInfoEconomicaSolicitud.setOidMoneda(objectToLong(resultado.getValueAt(0,"OID_MONE")));
      
      
      //Devuelve DTOInformacionEconomicaSolicitud 
      UtilidadesLog.info("la info economica es: " + dtoInfoEconomicaSolicitud);
      
      UtilidadesLog.info("MONModificarSolicitudBean.crearDTOInformacionEconomicaSolicitud(RecordSet resultado): Salida ");
      return dtoInfoEconomicaSolicitud;
  }

  public DTOInformacionEstadoSolicitud crearDTOInformacionEstadoSolicitud(RecordSet resultado) throws MareException {
    UtilidadesLog.info("MONModificarSolicitudBean.crearDTOInformacionEstadoSolicitud(RecordSet resultado): Entrada ");  
    /* Crea un DTOInformacionEstadoSolicitud con la información recuperada del RecordSet recibido y lo devuelve */
    DTOInformacionEstadoSolicitud dtoInfoEstadoSolicitud = new DTOInformacionEstadoSolicitud();
    try{
    dtoInfoEstadoSolicitud.setFechaPrevistaFacturacion(objectToDate(resultado.getValueAt(0,"FECHA_PREVISTA")));
    UtilidadesLog.debug("hasta aca0 ");  
    dtoInfoEstadoSolicitud.setFechaFacturacion(objectToDate(resultado.getValueAt(0,"FECHA_FACT")));
    UtilidadesLog.debug("hasta aca1 ");  
    dtoInfoEstadoSolicitud.setEstadoCredito(objectToString(resultado.getValueAt(0,"CODIGO_ESTADO")));
    dtoInfoEstadoSolicitud.setGrupoProcesos(objectToString(resultado.getValueAt(0,"GRUPO_PROCESO")));
    dtoInfoEstadoSolicitud.setProcesoValidacion(objectToString(resultado.getValueAt(0,"PROCESO")));
    dtoInfoEstadoSolicitud.setEstadoSolicitud(objectToString(resultado.getValueAt(0,"ESTADO")));
    UtilidadesLog.debug("hasta aca ");  
    dtoInfoEstadoSolicitud.setOidEstadoSolicitud(objectToLong(resultado.getValueAt(0,"OID_ESTA_SOLIC")));
    dtoInfoEstadoSolicitud.setOidGrupoProcesos(objectToLong(resultado.getValueAt(0,"OID_GRUP_PROC")));
    UtilidadesLog.debug("hasta aca AHORA DESCRIPCION ");  
    UtilidadesLog.debug("AQUI VIENE LA DESCRIPCIONESTADO " + resultado.getValueAt(0,"DESCRIPCIONESTADO"));  
    dtoInfoEstadoSolicitud.setDescripcionEstado(objectToString(resultado.getValueAt(0,"DESCRIPCIONESTADO")));
    }catch (Exception ex ){
        ex.printStackTrace();
        UtilidadesLog.error(ex);
        throw new MareException (ex);
    }
    UtilidadesLog.info("MONModificarSolicitudBean.crearDTOInformacionEstadoSolicitud(RecordSet resultado): Salida ");  

    //Devuelve DTOInformacionEstadoSolicitud
    return dtoInfoEstadoSolicitud;
  }

  public DTOInformacionSolicitud consultarCabeceraSolicitud(DTOOID dtoOid) throws MareException {
    UtilidadesLog.info("MONModificarSolicitudBean.consultarCabeceraSolicitud(DTOOID dtoOid): Entrada ");
    // Obtiene la información de la cabecera 
    
    DAOSolicitud daoSolicitud = new DAOSolicitud();
    
    //- resultado = DAOSolicitud.consultarCabeceraSolicitud(DTOOID.oid) 
    RecordSet resultado = daoSolicitud.consultarCabeceraSolicitud(dtoOid);

    
    // Organiza la información recuperada de la cabecera 
    DTOInformacionSolicitud dtoInfoSolicitud = new DTOInformacionSolicitud();
    dtoInfoSolicitud.setOidCabeceraSolicitud(dtoOid.getOid());
    
    // Información básica 
    dtoInfoSolicitud.setDtoInformacionBasicaSolicitud(crearDTOInformacionBasicaSolicitud(resultado));

    // Información del cliente 
    dtoInfoSolicitud.setDtoInformacionClienteSolicitud(crearDTOInformacionClienteSolicitud(resultado));
    
    // Información administrativa 
    dtoInfoSolicitud.setDtoInformacionAdministrativaSolicitud(crearDTOInformacionAdministrativaSolicitud(resultado));
    
    // Información economica 
    dtoInfoSolicitud.setDtoInformacionEconomicaSolicitud(crearDTOInformacionEconomicaSolicitud(resultado));
    
    // Información estado 
    dtoInfoSolicitud.setDtoInformacionEstadoSolicitud(crearDTOInformacionEstadoSolicitud(resultado));
    
    UtilidadesLog.info("MONModificarSolicitudBean.consultarCabeceraSolicitud(DTOOID dtoOid): Salida ");
    //Devuelve DTOInformacionSolicitud
    return dtoInfoSolicitud;
  }

  public DTOSalida consultarPosicionesSolicitud(DTOConsultarPosicionesSolicitud dtoe) throws MareException {
        UtilidadesLog.info("MONModificarSolicitudBean.consultarPosicionesSolicitud(DTOConsultarPosicionesSolicitud dtoe): Entrada ");
      DTOSalida dtoSalida = new DTOSalida();
      DAOPosicion daoPosicion = new DAOPosicion();
      
      Long tipoInformacion = dtoe.getOidTipoInformacion();
      
      if (tipoInformacion == null)  {
          dtoSalida.setResultado(daoPosicion.consultarPosicionesModificacion(dtoe.getOidCabeceraSolicitud(), dtoe.getOidIdioma()));
          return dtoSalida;
      } else {
        if (tipoInformacion.longValue() == ConstantesPED.INFORMACION_BASICA_POSICION.longValue())  {
            dtoSalida.setResultado(daoPosicion.consultarInformacionBasica(dtoe.getOidCabeceraSolicitud(),dtoe.getOidIdioma()));
        }
        if (tipoInformacion.longValue() == ConstantesPED.INFORMACION_PRODUCTOS_POSICION.longValue())  {
          dtoSalida.setResultado(daoPosicion.consultarInformacionProductos(dtoe.getOidCabeceraSolicitud()));
        }
        if (tipoInformacion.longValue() == ConstantesPED.INFORMACION_CANTIDADES_POSICION.longValue())  {
          dtoSalida.setResultado(daoPosicion.consultarInformacionCantidades(dtoe.getOidCabeceraSolicitud()));  
        }
        if (tipoInformacion.longValue() == ConstantesPED.INFORMACION_ECONOMICA_POSICION.longValue())  {
          dtoSalida.setResultado(daoPosicion.consultarInformacionEconomica(dtoe.getOidCabeceraSolicitud()));
        }
        UtilidadesLog.info("MONModificarSolicitudBean.consultarPosicionesSolicitud(DTOConsultarPosicionesSolicitud dtoe): Salida ");
        return dtoSalida;
      
      }
  }

  public DTOSalida obtenerBloquesInformacionPosicion(DTOBelcorp dtoBelcorp) throws MareException {
        UtilidadesLog.info("MONModificarSolicitudBean.obtenerBloquesInformacionPosicion(DTOBelcorp dtoBelcorp): Entrada ");
    // Obtiene los distintos bloques de información de la posición de una solicitud 
      DAOSolicitud daoSolicitud = new DAOSolicitud();
      DTOSalida dtoSalida = new DTOSalida();
      dtoSalida.setResultado(daoSolicitud.obtenerBloquesInformacionPosicion(dtoBelcorp));
        UtilidadesLog.info("MONModificarSolicitudBean.obtenerBloquesInformacionPosicion(DTOBelcorp dtoBelcorp): Salida ");
      return dtoSalida;
  }

  public DTOSalida obtenerEstadosSolicitud(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONModificarSolicitudBean.obtenerEstadosSolicitud(DTOBelcorp dto): Entrada ");
    // Obtiene la información de las posiciones de la solicitud 
      DAOSolicitud daoSolicitud = new DAOSolicitud();
      DTOSalida dtoSalida = new DTOSalida();
      dtoSalida.setResultado(daoSolicitud.obtenerEstadosSolicitud(dto));
        UtilidadesLog.info("MONModificarSolicitudBean.obtenerEstadosSolicitud(DTOBelcorp dto): Salida ");
      return dtoSalida;
  }

  public DTOSalida buscarSolicitud(DTOBuscarSolicitud dtoe) throws MareException {
      UtilidadesLog.info("MONModificarSolicitudBean.buscarSolicitud(DTOBuscarSolicitud dtoe): Entrada ");
      DAOSolicitud daoSolicitud = new DAOSolicitud();
      DTOSalida dtoSalida = new DTOSalida();
      UtilidadesLog.debug("antes del daoSolicitud");
      dtoSalida.setResultado(daoSolicitud.buscarSolicitud(dtoe));
      UtilidadesLog.info("MONModificarSolicitudBean.buscarSolicitud(DTOBuscarSolicitud dtoe): Salida ");
      return dtoSalida;
  }

  public DTOSalida obtenerTiposSolicitudModificar(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("MONModificarSolicitudBean.obtenerTiposSolicitudModificar(DTOBelcorp dtoe): Entrada ");
    // Realiza la búsqueda de tipos de solicitud que se pueden modificar 
      DAOSolicitud daoSolicitud = new DAOSolicitud();
      DTOSalida dtoSalida = new DTOSalida();
      dtoSalida.setResultado(daoSolicitud.obtenerTiposSolicitudModificar(dtoe));
        UtilidadesLog.info("MONModificarSolicitudBean.obtenerTiposSolicitudModificar(DTOBelcorp dtoe): Salida ");
      return dtoSalida;
  }

  public void modificarCabecera(DTOCabeceraSolicitud dtoe) throws MareException {
    UtilidadesLog.info("MONModificarSolicitudBean.modificarCabecera(DTOCabeceraSolicitud dtoe): Entrada ");
    // Actualiza la información de la cabecera de la solicitud recibida 
    // Antes se valida la cabecera de la solicitud 
    DAOGruposProceso daoGrupoProceso = new DAOGruposProceso();
    
    try  {
        MONValidacionesGeneralesSolicitudHome monValidacionesHome = (MONValidacionesGeneralesSolicitudHome) UtilidadesEJB.getHome("MONValidacionesGeneralesSolicitud",MONValidacionesGeneralesSolicitudHome.class);
        MONValidacionesGeneralesSolicitud monValidaciones = monValidacionesHome.create();
        
        dtoe = monValidaciones.validarSolicitud(dtoe);
        
        if (dtoe.getOK().booleanValue())  {
              Long proceso = daoGrupoProceso.obtenerUltimoProcesoGP(dtoe.getGrupoProcesos(), dtoe.getTipoSolicitud());
              dtoe.setProceso(proceso);            
              MONDigitacionInicialHome monDigitacionHome = (MONDigitacionInicialHome) UtilidadesEJB.getHome("MONDigitacionInicial", MONDigitacionInicialHome.class);
              MONDigitacionInicial monDigitacion = monDigitacionHome.create();
              
              dtoe = monDigitacion.guardarSolicitud(dtoe);
        } else {
            throw new MareException(null, null,UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED + ErroresNegocio.PED_016));
        }

    } catch (RemoteException re)  {
      UtilidadesLog.error("Exception: ",re);
      throw new MareException(re,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    } catch (CreateException ex)  {
      UtilidadesLog.error("Exception: ",ex);
      throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    } 
    UtilidadesLog.info("MONModificarSolicitudBean.modificarCabecera(DTOCabeceraSolicitud dtoe): Salida ");
  }

  public DTOCabeceraSolicitud modificarPosiciones(DTOCabeceraSolicitud dtoe) throws MareException {
    UtilidadesLog.info("MONModificarSolicitudBean.modificarPosiciones(DTOCabeceraSolicitud dtoe): Entrada ");

    DAOPosicion daoPosicion = new DAOPosicion();

    try  {
      
        int lineas = dtoe.getPosiciones().size();
        
        for (int i=0; i<lineas; i++)  {
            DTOPosicionSolicitud dtoPosicion = (DTOPosicionSolicitud) dtoe.getPosiciones().get(i);
            if (dtoPosicion.getOidPosicionSolicitud() != null)  {
                if ((dtoPosicion.getCodigoVenta() == null) &&
                    (dtoPosicion.getUnidadesDemandadas() == null))
                    daoPosicion.eliminarPosicion(dtoPosicion.getOidPosicionSolicitud());
            } else {
                MONGenerarPosicionSolicitudHome monGenerarPosHome = (MONGenerarPosicionSolicitudHome) UtilidadesEJB.getHome("MONGenerarPosicionSolicitud", MONGenerarPosicionSolicitudHome.class);
                MONGenerarPosicionSolicitud monGenerarPos = monGenerarPosHome.create();
                
                dtoe = monGenerarPos.generarPosicion(dtoe, new Long(i), Boolean.TRUE);
            }
            
        }

    } catch (RemoteException re)  {
      UtilidadesLog.error("Exception: ",re);
      throw new MareException(re,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    } catch (CreateException ex)  {
      UtilidadesLog.error("Exception: ",ex);
      throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    } 
    UtilidadesLog.info("MONModificarSolicitudBean.modificarPosiciones(DTOCabeceraSolicitud dtoe): Salida ");
    return dtoe;
  }
  
  
  private String objectToStringBig(Object oBigDecimal){
     if(oBigDecimal !=null)
      if (oBigDecimal instanceof BigDecimal)
          return ((BigDecimal)oBigDecimal).toString();
      else
          return oBigDecimal.toString();
     else 
      return new String("");  
  }
  
  private String objectToString(Object oString){
      if (oString != null)
          return (String) oString;
      else
        return null;

  }

  private Long objectToLong(Object oBigDecimal){
      if (oBigDecimal != null)
          return new Long(((BigDecimal)oBigDecimal).longValue());
      else 
          return null;
  }
  
  private Integer objectToInteger(Object oBigDecimal){
      if (oBigDecimal != null)
          return new Integer(((BigDecimal)oBigDecimal).intValue());
      else 
          return null;
  }

  private Date objectToDate(Object oDate){
      if (oDate != null)
          return (Date)oDate;
      else 
          return null;
  }

}