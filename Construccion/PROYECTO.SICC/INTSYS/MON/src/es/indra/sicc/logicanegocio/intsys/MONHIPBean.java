/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.logicanegocio.intsys;

import es.indra.sicc.cmn.negocio.interfaces.InterfazDef;
import es.indra.sicc.cmn.negocio.interfaces.RegistroDefs;
import es.indra.sicc.cmn.negocio.interfaces.buzones.BuzonEntrada;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.CreateException;
import javax.ejb.FinderException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.DTOOID;
import java.util.List;

import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;

import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesHome;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;

import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.EmpresaLocal;
import es.indra.sicc.entidades.seg.EmpresaLocalHome;

import es.indra.sicc.logicanegocio.seg.ConstantesSEG;

import es.indra.sicc.entidades.fac.RegistroUnicoVentasLocalHome;
import es.indra.sicc.entidades.fac.TipoDocumentoLegalLocal;
import es.indra.sicc.entidades.fac.TipoDocumentoLegalLocalHome;

import es.indra.sicc.entidades.ped.IndicadorImpuestosLocal;
import es.indra.sicc.entidades.ped.IndicadorImpuestosLocalHome;

import java.rmi.RemoteException;
import javax.rmi.PortableRemoteObject;

import es.indra.sicc.dtos.intsys.DTOHIPRecepcionar;
import es.indra.sicc.dtos.intsys.DTONomApeCliente;

import es.indra.sicc.cmn.negocio.interfaces.comun.DTOINTError;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;
import es.indra.sicc.dtos.fac.DTODatosRuvContaCentral;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class MONHIPBean implements SessionBean 
{

   private SessionContext ctx;   
   private static final Long oidSubAccesoContabilidad=new Long(2022);
   private static final String codigoTipoDocumentoIdentidadRUC="02";
  public void ejbCreate()
  {
  }

  public void ejbActivate()
  {
  }

  public void ejbPassivate()
  {
  }

  public void ejbRemove()
  {
  }

  public void setSessionContext(SessionContext ctx)
  {
      this.ctx = ctx;
  }

  public DTOSalidaBatch recepcionaRegistroVentasBatch(DTOHIPRecepcionar DTOE) throws MareException
  {
     UtilidadesLog.info("MONHIPBean.recepcionaRegistroVentasBatch(DTOHIPRecepcionar DTOE): Entrada");
     
     String mensaje = null;
     List lista = null;
      try{
        InterfazDef def = RegistroDefs.obtenerInterfaz( IGestorInterfaces.COD_INTERFAZ_HIP1 );
        BuzonEntrada buzon = new BuzonEntrada(def.getPathBuzonES());
        lista = buzon.obtenerFicheros(def.getPatronNombreFicheros());
     }catch(InterfacesException ie){
        UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
        throw new MareException(new Exception(),UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_INT, "", 
                                ErroresDeNegocio.INT_0099 )); 
     }
     IMareDTO  DTOOnline = DTOE;
     
     MareBusinessID IDOnline =  new MareBusinessID("HIPRecepcionarRegistroVentas");
		 DTOBatch dtoBatch = new DTOBatch("Registro Ventas Unificado-2", IDOnline , DTOOnline ); // modificado por incidencia BELC300012778
     try{
				UtilidadesLog.debug(" **** Antes de BatchUtil ***");
				BatchUtil.executeMLN( dtoBatch, new MareBusinessID("INTProcesoInterfaces"));
     } catch(RemoteException e){
        UtilidadesLog.error(e);
        String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
        throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));   
     }
    if(lista == null || lista.isEmpty()){
            UtilidadesLog.error("No se Recibio Interfaz "+ IGestorInterfaces.COD_INTERFAZ_HIP1 ); 
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_INT, "", 
                                   ErroresDeNegocio.INT_0099 )); 
    }    
     // incidencia BELC300013269
     mensaje += "Recepcionar Registro Ventas Batch ejecutado - ";
     
    UtilidadesLog.info("MONHIPBean.recepcionaRegistroVentasBatch(DTOHIPRecepcionar DTOE): Salida");
    return new DTOSalidaBatch(0, mensaje);
  }

  public DTOSalidaBatch recepcionarRegistroVentas(DTOBatch DTOE) throws MareException
  {
    UtilidadesLog.info("MONHIPBean.recepcionarRegistroVentas(DTOBatch DTOE): Entrada");
    MONGestorInterfaces gi = null;
    
    
        gi = this.getMONGestorInterfaces();
  
        IRegistroSicc registro = null;
		InterfazInfo interfaz = null;
        DTOHIPRecepcionar dto = (DTOHIPRecepcionar)DTOE.getDTOOnline();
        
        UtilidadesLog.debug("DTOEntrada: "+DTOE);
        UtilidadesLog.debug("DTOHIPRecepcionar: "+dto);
        
        // Se construye un objeto InterfazInfo con los valores que llegan a la entrada, para utilizarlo como 
        // handle de la interfaz que se va a procesar 

        InterfazInfo info = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_HIP1,
                        dto.getNumLote(),
                        dto.getOidPais());
        //Rellenamos los atributos descripcionLote y observaciones del objeto info con los atributos descripcionLote y observaciones del dto 
        info.setDescripcionLote(dto.getDescripcionLote());
        info.setObservaciones(dto.getObservaciones());
    
        //nos creamos un objeto IRegistroSicc, con la informacion recibida de la interfaz 
        try{
            interfaz = gi.importarInterfaz(info);
        }catch (InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
        }catch(RemoteException ne){            
            UtilidadesLog.error(ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        DAOHIP dao = new DAOHIP();
        Long oidPais = null;
		try{
			while ((registro = gi.cargarRegistro(interfaz)) != null){
            //Si no viene codigo de pais en la interfaz, será el pais de ejecución. 
            //Si viene codigo de pais, lo traducimos por su oid generando un error en caso de que no se encuentre. 
            String codPais = (String)registro.obtenerCampo(IRegistroSicc.HIP1_CODIGO_PAIS);

            if(codPais.equals("")){
                oidPais = dto.getOidPais();
            }else{
                try{
                    PaisLocal pais = this.getPaisLocalHome().findByUk(codPais);
                    oidPais = pais.getOid();
                }catch(NoResultException f){
                    try{
                        DTOINTError dtoError = new DTOINTError(info,registro,
                        ErroresDeNegocio.INT_0003 + "" + (String)registro.obtenerCampo(IRegistroSicc.HIP1_CODIGO_PAIS));
                        gi.registrarError(dtoError);
                        continue;
                    }catch(InterfacesException ie){
                        UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
                    }catch(RemoteException ne){                        
                        UtilidadesLog.error(ne);
                        throw new MareException(ne,
                            UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
               }  catch (PersistenceException ce) {   
                   UtilidadesLog.error("ERROR ", ce);
                   throw new MareException(ce, 
                   UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
               }
          }
      
      //comprobamos que existe la sociedad que viene en la interfaz, y si existe que es la misma que viene de la pantalla. 
      EmpresaLocal sociedad = null;
      try{
		String codSociedad = (String)registro.obtenerCampo(IRegistroSicc.HIP1_CODIGO_SOCIEDAD);
        sociedad = this.getEmpresaLocalHome().findByUK(codSociedad);
      }catch(NoResultException f){
        try{
            DTOINTError dtoError = new DTOINTError(info,registro,            
            ErroresDeNegocio.INT_0015 + "" +(String)registro.obtenerCampo(IRegistroSicc.HIP1_CODIGO_SOCIEDAD));
            gi.registrarError(dtoError);
            continue;
          }catch(InterfacesException ie){
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
          }catch(RemoteException ne){            
            UtilidadesLog.error(ne);
            throw new MareException(ne,
                      UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          }
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
      UtilidadesLog.debug("Sociedad: "+sociedad.getOid());
	  int igual = dto.getOidSociedad().compareTo(sociedad.getOid());
        if(igual != 0){
            //Añadido por incidencia 16482
            DTOINTError dtoError = new DTOINTError( info, registro, 
            ErroresDeNegocio.INT_0079 + "" + (String)registro.obtenerCampo(IRegistroSicc.HIP1_CODIGO_SOCIEDAD));
            try{
                gi.registrarError(dtoError);       
                continue;
            }catch(InterfacesException ie){
                UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
            }catch(RemoteException ne){                
                UtilidadesLog.error(ne);
                throw new MareException(ne,
                          UtilidadesError.armarCodigoError(
                          CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }
      
      //comprobamos que el tipo de impuesto, existe
      IndicadorImpuestosLocal tipoImpuesto = null;
      try{
        String tipImpu = (String)registro.obtenerCampo(IRegistroSicc.HIP1_TIPO_IMPUESTO);
        tipoImpuesto = this.getIndicadorImpuestosLocalHome().findByUK(oidPais, tipImpu);
      }catch(NoResultException f){
        try{
            DTOINTError dtoError = new DTOINTError(info,registro,
            ErroresDeNegocio.INT_0016 + "" + (String)registro.obtenerCampo(IRegistroSicc.HIP1_TIPO_IMPUESTO));
            gi.registrarError(dtoError);
            continue;
          }catch(InterfacesException ie){
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
          }catch(RemoteException ne){            
            UtilidadesLog.error(ne);
            throw new MareException(ne,
                      UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          }  
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
      //comprobamos si la tasa de impuesto que se recibe, es valida para tipo de impuesto.
	  Float tasaImpu = (Float)registro.obtenerCampo(IRegistroSicc.HIP1_TASA_IMPUESTO);
      //  Float tasa = new Float(tipoImpuesto.getTasaImpu().doubleValue());
      // int iguales = tasaImpu.compareTo(tasa);
      /* SB : ya no se valida el tipo de impuesto    
      if(iguales != 0){
        try{
            DTOINTError dtoError = new DTOINTError(info,registro,
            ErroresDeNegocio.INT_0017 + "" + (Float)registro.obtenerCampo(IRegistroSicc.HIP1_TASA_IMPUESTO));
            gi.registrarError(dtoError);
            continue;
          }catch(InterfacesException ie){
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
          }catch(RemoteException ne){            
            UtilidadesLog.error(ne);
            throw new MareException(ne,
                      UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          }  
      }*/
      
      
      //comprobamos el tipo de documento legal 
      TipoDocumentoLegalLocal tipoDocumentoLegal = null;
      try{
		String tipoDocu = (String)registro.obtenerCampo(IRegistroSicc.HIP1_TIPO_DOCUMENTO_LEGAL);
        tipoDocumentoLegal = this.getTipoDocumentoLegalLocalHome().findByUK(tipoDocu);
      }catch(NoResultException f){
        try{
            DTOINTError dtoError = new DTOINTError(info,registro,
            ErroresDeNegocio.INT_0018 + "" + (String)registro.obtenerCampo(IRegistroSicc.HIP1_TIPO_DOCUMENTO_LEGAL));
            gi.registrarError(dtoError);
            continue;
          }catch(InterfacesException ie){
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
          }catch(RemoteException ne){            
            UtilidadesLog.error(ne);
            throw new MareException(ne,
                      UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          }  
      }  catch (PersistenceException ce) {   
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
      
      //comprobamos el código del cliente y obtenemos el nombre1, nombre2, apellido1 y apellido2 para el cliente que hemos 
      String cliente = (String)registro.obtenerCampo(IRegistroSicc.HIP1_CODIGO_CLIENTE);
      //Modificado tipo cliente y tipo oidPais del dao por incidencia 17192
      DTONomApeCliente dtoCliente = new DTONomApeCliente();
      String nombreCliente="";
      if (!cliente.equals("")){
        dtoCliente = dao.obtenerNomApeCliente(cliente,oidPais);
        if(dtoCliente.getOidCliente() == null){
           try{
               DTOINTError dtoError = new DTOINTError(info,registro,
               ErroresDeNegocio.INT_0019 + "" + (String)registro.obtenerCampo(IRegistroSicc.HIP1_CODIGO_CLIENTE));
               gi.registrarError(dtoError);
               continue;
             }catch(InterfacesException ie){
               UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
             }catch(RemoteException ne){            
               UtilidadesLog.error(ne);
               throw new MareException(ne,
                         UtilidadesError.armarCodigoError(
                         CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
             }
          }
          nombreCliente = dtoCliente.getNombre1()+" "+dtoCliente.getNombre2()+" "+dtoCliente.getApellido1()+ " "+dtoCliente.getApellido2();
      }else{
          nombreCliente = (String)registro.obtenerCampo(IRegistroSicc.HIP_NOMBRE_CLIENTE);
      }
   
      //comprobamos el tipo de documento referencia que en caso de venir nulo, se debe seguir procesando el registro. 
     TipoDocumentoLegalLocal tipoDocumentoReferencia = null;
	  String tipoRefe = (String)registro.obtenerCampo(IRegistroSicc.HIP1_TIPO_DOCUMENTO_REFERENCIA);
      if(!tipoRefe.equals("")){
        try{
          tipoDocumentoReferencia = this.getTipoDocumentoLegalLocalHome().findByUK(tipoRefe);
        }catch(NoResultException f){
          try{
            DTOINTError dtoError = new DTOINTError(info,registro,
            ErroresDeNegocio.INT_0020 + "" + (String)registro.obtenerCampo(IRegistroSicc.HIP1_TIPO_DOCUMENTO_REFERENCIA));
            gi.registrarError(dtoError);
            continue;
          }catch(InterfacesException ie){
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
          }catch(RemoteException ne){            
            UtilidadesLog.error(ne);
            throw new MareException(ne,
                      UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          }
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
      }
      
      //comprobamos que el codigo de subacceso recibido en la interfaz, es un codigo que existe y obtenemos el oid de ese subAcceso 
      DTOOID dtoSub = dao.obtenerOidSubAcc((String)registro.obtenerCampo(IRegistroSicc.HIP1_CODIGO_SUBACCESO));
      // corregido por incidencia BELC300017192
      if(dtoSub.getOid() == null){
        try{
            DTOINTError dtoError = new DTOINTError(info,registro,
            ErroresDeNegocio.INT_0021 + "" + (String)registro.obtenerCampo(IRegistroSicc.HIP1_CODIGO_SUBACCESO));
            gi.registrarError(dtoError);
            continue;
          }catch(InterfacesException ie){
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
          }catch(RemoteException ne){            
            UtilidadesLog.error(ne);
            throw new MareException(ne,
                      UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          }
      }
      Date fecha = this.pasarAFecha((java.util.Date)registro.obtenerCampo(IRegistroSicc.HIP1_FECHA_EMISION));
      //pzerbino 14/8/2006 incidencia BELC300023745 

      Long documentoLegal =(Long) registro.obtenerCampo(IRegistroSicc.HIP1_NUMERO_DOCUMENTO_LEGAL);

	  //Integer documento = new Integer(documentoLegal.toString());
	    String factura = (String)registro.obtenerCampo(IRegistroSicc.HIP1_FACTURA_GRATUITA);
      Boolean transfGra = null;
      if(factura.equals("S"))      {
          transfGra = new Boolean("true");
      }else{
          transfGra = new Boolean("false");
      }
      //Llamamos al create() de la entidad FAC: RegistroUnicoVentas pasandole los siguientes atributos:
      try {
        UtilidadesLog.debug("Antes de hacer el create");
        Boolean facturaAnulada = null;
        Boolean facturaGratuita = null;
        if (((String)registro.obtenerCampo(IRegistroSicc.HIP1_INDICADOR_FACTURA_ANULADA)).equals("1")){
            facturaAnulada = new Boolean("true");
        }else{
            facturaAnulada = new Boolean("false");
        }
        if (((String)registro.obtenerCampo(IRegistroSicc.HIP1_FACTURA_GRATUITA)).equals("S")){
            facturaGratuita = new Boolean("true");
        }else{
            facturaGratuita = new Boolean("false");
        }
        UtilidadesLog.debug("IMPUESTO: "+((BigDecimal)registro.obtenerCampo(IRegistroSicc.HIP1_IMPUESTO)).toString());
        
        //pzerbino Incidencia BELC300023745 14/8/2006
        Long TIDO_TIPO_DOCU_REFE = null;
        if (tipoDocumentoReferencia != null){
              TIDO_TIPO_DOCU_REFE  = tipoDocumentoReferencia.getOid();
        }
        
        String nroReferenciaBajado  = (String)registro.obtenerCampo(IRegistroSicc.HIP1_NUMERO_DOCUMENTO_REFERENCIA);
        Long nroReferencia =  null;
        UtilidadesLog.debug("Valor de nroReferenciaBajado*" + nroReferenciaBajado + "*******");
        if (!nroReferenciaBajado.equals("")){
            nroReferencia = new Long(nroReferenciaBajado);
        }

      // numeroDocumentoIdentidad  incidencias 23832  
      String numeroDocumentoIdentidad = (String)registro.obtenerCampo(IRegistroSicc.HIP1_NUMERO_DOCUMENTO_IDENTIDAD);
      UtilidadesLog.debug("numeroDocumentoIdentidad " + numeroDocumentoIdentidad);
    /*  if ( numeroDocumentoIdentidad == null || numeroDocumentoIdentidad.trim().equals("") ) {
        try{
            DTOINTError dtoError = new DTOINTError(info,registro, ErroresDeNegocio.INT_0115);
            gi.registrarError(dtoError);
            continue;
          }catch(InterfacesException ie){
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie);
          }catch(RemoteException ne){            
            UtilidadesLog.error(ne);
            throw new MareException(ne,
                      UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
          }
      }*/
        
        //obtenos lo campos obtenidos
        String fechaEmisionDocumento = (String)registro.obtenerCampo(IRegistroSicc.HIP1_FECHA_EMISION_DOCUMENTO);
        UtilidadesLog.debug("fechaEmisionDocumento " + fechaEmisionDocumento);
        String codigoTipoDocumentoIdentidad = (String)registro.obtenerCampo(IRegistroSicc.HIP_TIPO_DOCUMENTO_IDENTIDAD);
        UtilidadesLog.debug("codigoTipoDocumentoIdentidad " + codigoTipoDocumentoIdentidad);
        
        UtilidadesLog.debug("nombreCliente " + nombreCliente);
        Long oidTipoDocumento=null;
        if(codigoTipoDocumentoIdentidad != null && !codigoTipoDocumentoIdentidad.equals("")){
             oidTipoDocumento= dao.obtenerOidDocumentoIdentidad(codigoTipoDocumentoIdentidad);
             if(oidTipoDocumento==null){
                 codigoTipoDocumentoIdentidad="09";//TIPO OTROS
                  oidTipoDocumento= dao.obtenerOidDocumentoIdentidad(codigoTipoDocumentoIdentidad);
             }                
         }
    
    
    /* Cuando se produzca la carga de un archivo proveniente de Contabilidad Central 
     * (código de subacceso 310 OID 2022) deberá haber una conversión para el 
     * tipo de documento de identidad, 
     * número de documento de identidad y nombre a :
     * RUC, 
     * el RUC de CETCO y 
     * por nombre CETCO S.A.
     */
     UtilidadesLog.debug("antes de numeroDocumentoIdentidad ruv : " + numeroDocumentoIdentidad);
     if(oidSubAccesoContabilidad.longValue() == dtoSub.getOid().longValue()){//ES CONTABILIDAD CENTARL
        UtilidadesLog.debug("numeroDocumentoIdentidad ruv : " + numeroDocumentoIdentidad);
        DTODatosRuvContaCentral dtoRuv =dao.obtenerDatosRuvContabilidadCentral(numeroDocumentoIdentidad);
        if(dtoRuv != null ){
            oidTipoDocumento= dtoRuv.getOidTipoDocumento();
            nombreCliente = dtoRuv.getNombre();
            numeroDocumentoIdentidad = dtoRuv.getIdentidadNacional();
        }
     }
    
    
        this.getRegistroUnicoVentasLocalHome().create(
               oidPais, // Long pais,
               sociedad.getOid(), // Long sociedadVenta,
               dtoSub.getOid(), // Long subacceso,
               null, // String ejercicioDocumentoInterno, //tipo modificado por 10384, // NO obligatorio
               fecha, // Date fechaEmision,
               (BigDecimal)registro.obtenerCampo(IRegistroSicc.HIP1_BASE_IMPONIBLE), // BigDecimal baseImponible,
               (BigDecimal)registro.obtenerCampo(IRegistroSicc.HIP1_IMPUESTO), // BigDecimal importeImpuesto,
               (BigDecimal)registro.obtenerCampo(IRegistroSicc.HIP1_IMPUESTO_TOTAL), // BigDecimal importeTotal,
               (String)registro.obtenerCampo(IRegistroSicc.HIP1_CODIGO_PUNTO_EMISION), // String puntoEmision,
               null, // Long documentoInterno, // NO obligatorio
               numeroDocumentoIdentidad, // String numeroIdentificacionFiscal,
               numeroDocumentoIdentidad, // String numeroIdentificacionNacional,
               (String)registro.obtenerCampo(IRegistroSicc.HIP1_SERIE_DOCUMENTO_REFERENCIA), // String serieDocumentoReferencia,
               nroReferencia, // Long numeroDocumentoReferencia,
               dtoCliente.getNombre1(), // String nombre1, 
               dtoCliente.getNombre2(), // String nombre2,
               dtoCliente.getApellido1(), // String apellido1,
               dtoCliente.getApellido2(), // String apellido2,
               dtoCliente.getOidCliente(), // Long cliente,
               transfGra, // Boolean transferenciaGratuita, // obligatorio // incidencia BELC300013282
               null, // Long cabDocContable, // NO obligatorio
               tipoImpuesto.getOidTasaImpu(), // Long impuesto,
               tipoDocumentoLegal.getOid(), // Long tipoDocumentoLegal,
               documentoLegal, // Long numeroDocumentoLegal,
               (String)registro.obtenerCampo(IRegistroSicc.HIP1_SERIE_DOCUMENTO_LEGAL), // String serieDocumentoLegal,
               TIDO_TIPO_DOCU_REFE,//pzerbino 14/8/2006 Incidencia BELC300023745 tipoDocumentoReferencia.getOid(), // Long tipoDocumentoReferencia, 
               (BigDecimal)registro.obtenerCampo(IRegistroSicc.HIP1_INTERESES_MORA), // BigDecimal interesesMora,
               (BigDecimal)registro.obtenerCampo(IRegistroSicc.HIP1_DESCUENTO), // BigDecimal descuento,
               (BigDecimal)registro.obtenerCampo(IRegistroSicc.HIP1_COMISIONES), // BigDecimal comisiones, 
               (BigDecimal)registro.obtenerCampo(IRegistroSicc.HIP1_FLETE), // BigDecimal flete,
               (BigDecimal)registro.obtenerCampo(IRegistroSicc.HIP1_BASE_IMPONIBLE_NETO), // BigDecimal baseImponibleNeto,
               facturaAnulada, // Boolean estado indicador Factura Anulada,
               facturaGratuita, // Boolean facturaGratuita,
               null, // Date fechaCierre, // NO obligatorio
               //"'" + ConstantesINT.RUV_ACTIVO+"'", // String estadoRUV,
               ConstantesINT.RUV_ACTIVO, // String estadoRUV, V-INTHIP 02 gPineda 20/01/2007
               (String)registro.obtenerCampo(IRegistroSicc.HIP1_DOCUMENTO_INTERNO_BELCORP), // String documentoInternoHipersale            
                fechaEmisionDocumento,
                oidTipoDocumento,
                nombreCliente
            );
      } catch (CreateException e) {
         ctx.setRollbackOnly();
         UtilidadesLog.error(e);         
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
    }
		}catch (InterfacesException ie) {
            UtilidadesLog.error("Excepcion de la Interfaz: "+ ie.getMotivo() ,ie); 
        }catch(RemoteException ne){
            UtilidadesLog.error(ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

    // incidencia BELC300013269
    String mensaje = "Recepcionar Registro Ventas procesado - ";
    UtilidadesLog.info("MONHIPBean.recepcionarRegistroVentas(DTOBatch DTOE): Salida");
    return new DTOSalidaBatch(0, mensaje);
  }
 
	private Date pasarAFecha(java.util.Date fecha){
        UtilidadesLog.info("MONHIPBean.pasarAFecha(java.util.Date fecha): Entrada");
        UtilidadesLog.debug("Fecha de entrada: "+fecha);
        Date fechaFin=null;
        if(fecha!=null){
            fechaFin = new Date(fecha.getTime());
        }else if(fecha==null){
            UtilidadesLog.debug("La fecha pasada a la clase pasarAFecha es null");
        }
        
        UtilidadesLog.debug("Fecha de cambiada: "+ fechaFin);
        UtilidadesLog.info("MONHIPBean.pasarAFecha(java.util.Date fecha): Salida");
       return fechaFin;
    } 
  
   private MONGestorInterfaces getMONGestorInterfaces() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONHIPBean.getMONGestorInterfaces(): Entrada");
        MONGestorInterfacesHome home = (MONGestorInterfacesHome)UtilidadesEJB.getHome("MONGestorInterfaces", MONGestorInterfacesHome.class);
            
        // Se obtiene el interfaz remoto
        MONGestorInterfaces ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error("*** Error en getMONMantenimientoSEG",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONHIPBean.getMONGestorInterfaces(): Salida");
        return ejb;
		}


    private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinessFacadeBach");
  }
  
    private PaisLocalHome getPaisLocalHome() {
            return new PaisLocalHome();
    }

    private EmpresaLocalHome getEmpresaLocalHome() {
            return new EmpresaLocalHome();
    }

    private IndicadorImpuestosLocalHome getIndicadorImpuestosLocalHome() {
            return new IndicadorImpuestosLocalHome();
    }

    private TipoDocumentoLegalLocalHome getTipoDocumentoLegalLocalHome() {
            return new TipoDocumentoLegalLocalHome();
    }
    
    private RegistroUnicoVentasLocalHome getRegistroUnicoVentasLocalHome() throws MareException{
         RegistroUnicoVentasLocalHome registroUnicoVentasLocalHome = (RegistroUnicoVentasLocalHome) UtilidadesEJB.getLocalHome("java:comp/env/RegistroUnicoVentas");
         return registroUnicoVentasLocalHome;
    }
    
    /**
     * This method converts a String to a date using the datePattern
     * 
     * @param strDate the date to convert (in format yyyyMMdd)
     * @return a date object
     * 
     * @throws ParseException
     */
    public static java.util.Date convertStringToDate(String strDate)
      throws ParseException {
        java.util.Date aDate = null;
        String datePattern = "yyyyMMdd";
        try {
          
            aDate = convertStringToDate(datePattern, strDate);
        } catch (ParseException pe) {
           UtilidadesLog.info("Could not convert '" + strDate
                      + "' to a date, throwing exception");
            pe.printStackTrace();
            throw new ParseException(pe.getMessage(),
                                     pe.getErrorOffset());
                    
        }

        return aDate;
    }

    /**
      * This method generates a string representation of a date/time
      * in the format you specify on input
      *
      * @param aMask the date pattern the string is in
      * @param strDate a string representation of a date
      * @return a converted Date object
      * @see java.text.SimpleDateFormat
      * @throws ParseException
      */
     public static final java.util.Date convertStringToDate(String aMask, String strDate)
       throws ParseException {
         SimpleDateFormat df = null;
         java.util.Date date = null;
         df = new SimpleDateFormat(aMask);
         try {
             date = df.parse(strDate);
         } catch (ParseException pe) {
             //log.error("ParseException: " + pe);
             throw new ParseException(pe.getMessage(), pe.getErrorOffset());
         }

         return (date);
     }
}
