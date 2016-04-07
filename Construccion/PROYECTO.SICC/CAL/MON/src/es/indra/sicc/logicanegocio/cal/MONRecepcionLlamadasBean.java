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

package es.indra.sicc.logicanegocio.cal;

import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.dtos.cal.DTONombre;
import es.indra.sicc.dtos.mae.DTOCodigoCliente;
import es.indra.sicc.entidades.mae.ClienteBloqueoLocal;
import es.indra.sicc.entidades.mae.ClienteBloqueoLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.mae.ClienteTipoSubTipoLocal;
import es.indra.sicc.entidades.mae.ClienteTipoSubTipoLocalHome;
import es.indra.sicc.entidades.mae.ClienteVinculoLocal;
import es.indra.sicc.entidades.mae.ClienteVinculoLocalHome;
import es.indra.sicc.entidades.mae.TipoClienteLocal;
import es.indra.sicc.entidades.mae.TipoClienteLocalHome;
import es.indra.sicc.entidades.mae.TipoVinculoLocal;
import es.indra.sicc.entidades.mae.TipoVinculoLocalHome;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.dtos.mae.DTOTipificacionCliente;
import java.math.BigDecimal;
import es.indra.sicc.logicanegocio.ped.DAOSolicitud;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;

import java.rmi.RemoteException;

import java.sql.Timestamp;

import es.indra.sicc.dtos.cal.DTOCliente;

import es.indra.sicc.dtos.ped.DTONumeroSolicitud;

import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.BelcorpService;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.entidades.cal.ContactoLocalHome;
import es.indra.sicc.entidades.cal.ContactoLocal;
import es.indra.sicc.entidades.cal.AtributoEstadoContactoLocal;
import es.indra.sicc.entidades.cal.AtributoEstadoContactoLocalHome;
import es.indra.sicc.entidades.cal.TemporalLlamadasIVRLocal;
import es.indra.sicc.entidades.cal.TemporalLlamadasIVRLocalHome;

import es.indra.sicc.logicanegocio.ped.MONProcesosPED;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;
import es.indra.sicc.dtos.cal.DTOContacto;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado;
import es.indra.sicc.dtos.cal.DTOCabecera;
import es.indra.sicc.dtos.cal.DTOCabeceraPedido;
import es.indra.sicc.dtos.cal.DTODetalle;
import es.indra.sicc.dtos.cal.DTODetallePedido;
import es.indra.sicc.dtos.cal.DTOInterfazIVR;
import es.indra.sicc.dtos.cal.DTOFichaCliente;
import es.indra.sicc.dtos.cal.DTOBloqueoAdm;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;



public class MONRecepcionLlamadasBean implements SessionBean 
{
  private SessionContext ctx;
  
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

  public void setSessionContext(SessionContext ctx) {
    this.ctx = ctx;
  }

  public DTOOID guardarContacto(DTOCliente dtoE) throws MareException
  {
    //Se inserta un registro en la entidad CAL:Contacto: 
    UtilidadesLog.info("MONRecepcionLlamadasBean.guardarContacto(DTOCliente dtoE): Entrada");
    DTONumeroSolicitud dtoNumeroSolicitud = new DTONumeroSolicitud();
    dtoNumeroSolicitud.setOidPais(dtoE.getOidPais());
    dtoNumeroSolicitud.setOperacion(ConstantesCAL.CAL002);
    
    MONProcesosPED mon = this.getMONProcesosPED();
    Long codigoContacto = null;
    try {
      codigoContacto= new Long(mon.generaNumeroDocumento(dtoNumeroSolicitud));
    } catch(RemoteException re) {
			UtilidadesLog.error("*** Error en guardarContacto",re);
			String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));				
		}
    String codOperador = ctx.getCallerPrincipal().getName();
    Timestamp fechaContacto = new Timestamp(System.currentTimeMillis());
    Long oidMotivo = null;
    if (dtoE.getOidMotivoContacto() == null) {
      oidMotivo = ConstantesCAL.OID_MOTIVO_INFO_GENERAL;
    } else {
      oidMotivo = dtoE.getOidMotivoContacto();
    }
    Long atributoEstado = null; //incidencia 12324:
    /* contacto.AtributoEstado = findByUk (ConstantesCAL.OID_TIPO_ESTADO_CONTACTO_REGISTRADO,
     *   ConstantesCAL.COD_ATRIBUTO_NORMAL) de la entidad CAL:AtributoEstadoContacto //obtenemos el oid de la
     *   entidad 
     */
    AtributoEstadoContactoLocalHome atributoEstadoContactoLocalHome = this.getAtributoEstadoContactoLocalHome();
    AtributoEstadoContactoLocal atributoEstadoContactoLocal = null;
    try {
        atributoEstadoContactoLocal = atributoEstadoContactoLocalHome.findByUK(ConstantesCAL.OID_TIPO_ESTADO_CONTACTO_REGISTRADO , 
          ConstantesCAL.COD_ATRIBUTO_NORMAL );
    } catch (NoResultException nre) {
        ctx.setRollbackOnly();
       UtilidadesLog.error("guardarContacto: FinderException",nre);
			 throw new MareException(nre, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    }catch(PersistenceException pex) {
                ctx.setRollbackOnly();
                throw new MareException(pex, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    atributoEstado = atributoEstadoContactoLocal.getOid();
    ContactoLocalHome contactoLocalHome = this.getContactoLocalHome();
    ContactoLocal contactoLocal = null;
    try {

/*    contactoLocal = contactoLocalHome.create( codigoContacto , codOperador , fechaContacto, 
        fechaContacto , dtoE.getOidPais() , dtoE.getOidCliente() , oidMotivo , atributoEstado );*/
    
    // Modificado por ssantana, 31/1/2005
    // Se cambia el 3er parametro del Create de Timestamp a java.sql.Date
    // por cambio en Entidad segun. inc. de GPM BELC300012727
             java.sql.Date newFechaContacto = new java.sql.Date(fechaContacto.getTime() );
             contactoLocal = contactoLocalHome.create( codigoContacto , codOperador , newFechaContacto, 
             fechaContacto , dtoE.getOidPais() , dtoE.getOidCliente() , oidMotivo , atributoEstado);
             contactoLocal.setTipoCliente(dtoE.getOidTipoCliente()); // dtoE.getOidTipoCliente()); //14888
             contactoLocal.setSubTipoCliente(dtoE.getOidSubtipoCliente()); //dtoE.getOidSubtipoCliente()); //14888
             contactoLocalHome.merge(contactoLocal);
    } catch(PersistenceException e) {
             ctx.setRollbackOnly();
             throw new MareException(e,
             UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
    }      
        
    DTOOID dtoS = new DTOOID();
    dtoS.setOidPais(dtoE.getOidPais());
    dtoS.setOidIdioma(dtoE.getOidIdioma());
    dtoS.setOid(contactoLocal.getOid());
           
    UtilidadesLog.info("MONRecepcionLlamadasBean.guardarContacto(DTOCliente dtoE): Salida");
    
    return dtoS;
  }


    private MONProcesosPED getMONProcesosPED() throws MareException {
	    // Se obtiene el interfaz home
        
      UtilidadesLog.info("MONRecepcionLlamadasBean.getMONProcesosPED(): Entrada");
      
      MONProcesosPEDHome home = (MONProcesosPEDHome)UtilidadesEJB.getHome(
        "MONProcesosPED", MONProcesosPEDHome.class);
      // Se obtiene el interfaz remoto
      MONProcesosPED ejb = null;
      try {
        ejb = home.create();
      } catch (Exception e) {
		    UtilidadesLog.error("*** Error en getMONProcesosPED",e);
        String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
        throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } 
      
      UtilidadesLog.info("MONRecepcionLlamadasBean.getMONProcesosPED(): Salida");
      
      return ejb;
	}

    /*
    public void realizarBloqueoAdministrativo(DTOOID DTOE) throws MareException {
        UtilidadesLog.info("MONRecepcionLlamadasBean.realizarBloqueoAdministrativo(DTOOID DTOE): Entrada");
        
        //Realiza el bloqueo administrativo del cliente 
        /*bloqueos = llamar la método findByClienteTipoBloqueo(DTOE.oidCliente, ConstantesMAE.OID_BLOQUEO_ADMINISTRATIVO) de la entidad MAE.ClienteBloqueo 
        
        Si no existe ningún registro 
        { 
        Crear un registro en la entidad MAE.ClienteBloqueo con la siguiente información: 
        cliente = DTOE.oidCliente 
        tipoBloqueo = ConstantesMAE.OID_BLOQUEO_ADMINISTRATIVO 
        motivoBloqueo = ContantesCAL.OBSERV_BLOQUEO_ADMINISTRATIVO 
        fechaBloqueo = fecha del sistema 
        usuarioBloqueo = llamar al getcallerPrincipal del contexto y obtener el usuario 
        observacionesBloqueo = ContantesCAL.OBSERV_BLOQUEO_ADMINISTRATIVO 
        } 
        
        ClienteBloqueoLocalHome clienteBloqueoLocalHome = this.getClienteBloqueoLocalHome();
        ClienteBloqueoLocal clienteBloqueoLocal;
        try{
            clienteBloqueoLocal = clienteBloqueoLocalHome.findByClienteTipoBloqueo(DTOE.getOid(),ConstantesMAE.OID_BLOQUEO_ADMINISTRATIVO);
        } catch (FinderException fe) {
             Long cliente = DTOE.getOid();
             Long tipoBloqueo = ConstantesMAE.OID_BLOQUEO_ADMINISTRATIVO;
             String motivoBloqueo = ConstantesCAL.OBSERV_BLOQUEO_ADMINISTRATIVO;
             Timestamp fechaBloqueo = new Timestamp(System.currentTimeMillis());
             String usuarioBloqueo = ctx.getCallerPrincipal().getName();
             String observacionesBloqueo = ConstantesCAL.OBSERV_BLOQUEO_ADMINISTRATIVO; 
             try{
                clienteBloqueoLocalHome.create(cliente,tipoBloqueo,fechaBloqueo
                                        ,motivoBloqueo,usuarioBloqueo,
                                        observacionesBloqueo);
             } catch(CreateException ce){
                            ctx.setRollbackOnly();
                            UtilidadesLog.error("*** Error en clienteBloqueoHome.create",ce);
                            String codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                            throw new MareException(ce, UtilidadesError.armarCodigoError(codigoError));	
            }
        }
        
        UtilidadesLog.info("MONRecepcionLlamadasBean.realizarBloqueoAdministrativo(DTOOID DTOE): Salida");
    }*/
    
    /**
     * Metodo modificado por cambio COL-blo-01 (SCS-23/10/2007)
     */
    public void realizarBloqueoAdministrativo(DTOOID DTOE) throws MareException {
        UtilidadesLog.info("MONRecepcionLlamadasBean.realizarBloqueoAdministrativo(DTOOID DTOE): Entrada");
        
        DAORecepcionLlamadas dao = new DAORecepcionLlamadas();
        
        if (dao.verificacionDeBloqueo(DTOE.getOid(), DTOE.getOidPais())){ //esta bloqueado, halle registros
            String codigoError;
            codigoError = ErroresDeNegocio.CLIENTE_YA_BLOQUEADO;
            UtilidadesLog.debug("cliente se encuentra bloqueado..........");    
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CAL, "", codigoError));
        }else{
                        
        }
        UtilidadesLog.info("MONRecepcionLlamadasBean.realizarBloqueoAdministrativo(DTOOID DTOE): Salida");
    }    

    public void actualizarContacto(DTOContacto dto) throws MareException {
        UtilidadesLog.info("MONRecepcionLlamadasBean.actualizarContacto(DTOContacto dto): Entrada");
        
        validaAccesos(dto.getOidPais(), null, null, null,
         null,null, null, null, null, null, null);
        
        ContactoLocalHome contactoLocalHome = this.getContactoLocalHome();
        ContactoLocal contactoLocal = null; 
        
        
        try 
        {
            //Actualiza los siguientes atributos de la entidad CAL:Contacto cuyo oid es dto.oidContacto: 
            contactoLocal = getContactoLocalHome().findByPrimaryKey(dto.getOidContacto());              
    
        } catch (NoResultException nre) {
            UtilidadesLog.debug(nre);
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(nre, UtilidadesError.armarCodigoError(codigoError));
        }catch(PersistenceException pex) {
                ctx.setRollbackOnly();
                throw new MareException(pex, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
                 
        
       // AtributoEstado = dto.oidAtributo 
       // horaFin = hora del sistema (al igual que en el método guardarContacto(),
       // introducimos todo el dato TimeStamp)
        contactoLocal.setAtributoEstado(dto.getOidAtributo());
        contactoLocal.setHoraFin( new Timestamp (System.currentTimeMillis() ) );
        
        if((dto.getOidEstado()).equals(ConstantesCAL.OID_TIPO_ESTADO_CONTACTO_CERRADO)){
            contactoLocal.setFechaHoraCierre( new Timestamp (System.currentTimeMillis() ));
        }
        else{
            contactoLocal.setFechaHoraCierre(null);
        }
        contactoLocalHome.merge(contactoLocal);
        UtilidadesLog.info("MONRecepcionLlamadasBean.actualizarContacto(DTOContacto dto): Salida");
    }

    public DTOSalida obtenerEstadoContacto(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerEstadoContacto(DTOBelcorp dto): Entrada");
        
        //Se retorna el DTOSalida que devuelve el método
        //DAORecepcionLlamadas.obtenerEstadoContacto(dto)
        DAORecepcionLlamadas dao = new DAORecepcionLlamadas();
        DTOSalida dtoSalida = dao.obtenerEstadoContacto(dto);
        
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerEstadoContacto(DTOBelcorp dto): Salida");
        return dtoSalida ;
    }


    public DTOSalida obtenerAtributoEstado(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerAtributoEstado(DTOOID dto): Entrada");	
        // Se retorna el DTOSalida que devuelve el método
        // DAORecepcionLlamadas.obtenerAtributoEstado(dto)
        DTOSalida dtoSalida = new DTOSalida();
        DAORecepcionLlamadas dao = new DAORecepcionLlamadas();
        dtoSalida = dao.obtenerAtributoEstado(dto);
        
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerAtributoEstado(DTOOID dto): Salida");	
        return dtoSalida;
    }
    
    /*private void logearError(String mensaje,Throwable e) {
		//mensaje: nombreMetodo: tipoExcepcion
		UtilidadesLog.error("****Error Metodo: "+mensaje+": "+ e.getMessage());
		this.logearStackTrace(e);
	}*/

	/*private void logearStackTrace(Throwable e){
		try{						
			ByteArrayOutputStream pila = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(pila);
			e.printStackTrace(out);
			UtilidadesLog.error(pila.toString());
		}catch(Exception ex){
			UtilidadesLog.error("Error Logeando Pila: "+ex.getMessage());
		}			
	}*/   

    public DTOSalida obtenerContactos(DTOCliente DTOE) throws MareException {
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerContactos(DTOCliente DTOE): Entrada");
        /*contactos = Llamar al método obtenerContactos(DTOE) 
        del DAORecepcionLlamadas 

        Crear un DTOSalida con: 
        DTOSalida.resultado = contactos 
        
        Devuelve DTOSalida

         */
        DTOSalida dtoSalida = new DTOSalida();
        DAORecepcionLlamadas contactos = new DAORecepcionLlamadas();
        dtoSalida.setResultado(contactos.obtenerContactos(DTOE));
        
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerContactos(DTOCliente DTOE): Salida");
        
        return dtoSalida;
    }
    
    public DTOSalida obtenerCuentasCorrientes(DTOOIDPaginado DTOE) throws MareException {
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerCuentasCorrientes(DTOOIDPaginado DTOE): Entrada");	
        /*
        cuentas = Llamar al método obtenerCuentasCorrientes(DTOE) del DAORecepcionLlamadas 

        Crear un DTOSalida con 
        DTOSalida.resultado = cuentas 
        
        Devolver DTOSalida
        */
        DTOSalida dtoSalida = new DTOSalida();
        DAORecepcionLlamadas dao = new DAORecepcionLlamadas();
        dtoSalida.setResultado(dao.obtenerCuentasCorrientes(DTOE));
        
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerCuentasCorrientes(DTOOIDPaginado DTOE): Salida");	
        return dtoSalida;
    }
    
    //Cambio parámetro de entrada por incidencia 12536
    public DTOSalida obtenerVinculos(DTOOIDPaginado DTOE) throws MareException {
    
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerVinculos(DTOOIDPaginado DTOE): Entrada");        
        /*vinculos = Llamar al método obtenerVinculos(DTOE) del DAORecepcionLlamadas 

        Crear un DTOSalida con 
        DTOSalida.resultado = vinculos 
    
        Devolver DTOSalida
        */
        DTOSalida dtoSalida = new DTOSalida();
        DAORecepcionLlamadas dao = new DAORecepcionLlamadas();
        dtoSalida.setResultado(dao.obtenerVinculos(DTOE));
        
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerVinculos(DTOOIDPaginado DTOE): Salida");
        
        return dtoSalida;
    }
    
    //Cambio parámetro de entrada por incidencia 12536
    public DTOSalida obtenerDocumentos(DTOOIDPaginado DTOE) throws MareException {
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerDocumentos(DTOOIDPaginado DTOE): Entrada");
        /*
        documentos = Llamar al método obtenerDocumentos(DTOE) del DAORecepcionLlamadas 

        Crear un DTOSalida con 
        DTOSalida.resultado = documentos 
        
        Devolver DTOSalida

        */
        DTOSalida dtoSalida = new DTOSalida();
        DAORecepcionLlamadas dao = new DAORecepcionLlamadas();
        dtoSalida.setResultado(dao.obtenerDocumentos(DTOE));
        
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerDocumentos(DTOOIDPaginado DTOE): Salida");
        
        return dtoSalida;
    }

    //Cambio parámetro de entrada por incidencia 12536
    public DTOSalida obtenerDirecciones(DTOOIDPaginado DTOE) throws MareException {
    
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerDirecciones(DTOOIDPaginado DTOE): Entrada");
        /*
        direcciones = Llamar al método obtenerDirecciones(DTOE) del DAORecepcionLlamadas 
        
        Crear un DTOSalida con 
        DTOSalida.resultado = direcciones 
        
        Devolver DTOSalida
        
        */
        DTOSalida dtoSalida = new DTOSalida();
        DAORecepcionLlamadas dao = new DAORecepcionLlamadas();
        dtoSalida.setResultado(dao.obtenerDirecciones(DTOE));
        
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerDirecciones(DTOOIDPaginado DTOE): Salida");
        
        return dtoSalida;
    }

    //Cambio parámetro de entrada por incidencia 12536
    public DTOSalida obtenerCabeceraPedidos(DTOOIDPaginado DTOE) throws MareException {
    
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerCabeceraPedidos(DTOOIDPaginado DTOE): Entrada");
        
        /*cabeceras = Llamar al método obtenerCabeceraPedidos(DTOE) del DAORecepcionLlamadas 
        
        Crear un DTOSalida con 
        DTOSalida.resultado = cabeceras 
        
        Devolver DTOSalida
        */
        DTOSalida dtoSalida = new DTOSalida();
        DAORecepcionLlamadas dao = new DAORecepcionLlamadas();
        dtoSalida.setResultado(dao.obtenerCabeceraPedidos(DTOE));
        
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerCabeceraPedidos(DTOOIDPaginado DTOE): Salida");
        
        return dtoSalida;
    }

    //Cambio parámetro de entrada por incidencia 12536
    public DTOSalida obtenerDetalleCabecera(DTOOIDPaginado DTOE) throws MareException {
    
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerDetalleCabecera(DTOOIDPaginado DTOE): Entrada");
        
        /*detalles = Llamar al método obtenerDetalleCabecera(DTOE) del DAORecepcionLlamadas 

        Crear un DTOSalida con 
        DTOSalida.resultado = detalles 
        
        Devolver DTOSalida
        */
        DTOSalida dtoSalida = new DTOSalida();
        DAORecepcionLlamadas dao = new DAORecepcionLlamadas();
        dtoSalida.setResultado(dao.obtenerDetalleCabecera(DTOE));
        
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerDetalleCabecera(DTOOIDPaginado DTOE): Salida");
        
        return dtoSalida;
    }

    public DTOCabeceraPedido obtenerDatosAdicionalesCabecera(DTOOID DTOE) throws MareException {
        //INCIDENCIA 12384
        
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerDatosAdicionalesCabecera(DTOOID DTOE): Entrada");
        /*dtoCabecera = Llamar al método obtenerDatosAdicionalesCabecera d
        el DAORecepcionLlamadas 

        Devuelve el dtoCabecera
        */

        DTOCabeceraPedido dtoCabecera = null;
        DAORecepcionLlamadas dao = new DAORecepcionLlamadas();
        dtoCabecera = dao.obtenerDatosAdicionalesCabecera(DTOE);
        
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerDatosAdicionalesCabecera(DTOOID DTOE): Salida");
        
        return dtoCabecera;
    
    }

    public DTODetallePedido obtenerDatosAdicionalesDetalle(DTOOID DTOE) throws MareException {
        //INCIDENCIA 12384
        
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerDatosAdicionalesDetalle(DTOOID DTOE): Entrada");
        
        /*dtoDetalle = Llamar al método obtenerDatosAdicionalesDetalle(DTOE)
        del DAORecepcionLlamadas 

        Devuelve el dtoDetalle
        */

        DTODetallePedido dtoDetalle = null;
        DAORecepcionLlamadas dao = new DAORecepcionLlamadas();
        dtoDetalle = dao.obtenerDatosAdicionalesDetalle(DTOE);
        
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerDatosAdicionalesDetalle(DTOOID DTOE): Salida");
        
        return dtoDetalle;
        
    }
       private MONValidacion getMONValidacion() throws MareException {
        UtilidadesLog.info("MONRecepcionLamadas.getMONValidacion(): Entrada");

        // Se obtiene el interfaz home
        MONValidacionHome home = (MONValidacionHome) UtilidadesEJB.getHome("MONValidacion",
                MONValidacionHome.class);

        // Se obtiene el interfaz remoto
        MONValidacion ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONRecepcionLamadas.getMONValidacion(): Salida");

        return ejb;
    }


    // Validaciones
    private void validaAccesos(Long pais, Long sociedad, Long marca, Long canal,
        Long acceso, Long subacceso, Long subgerencia, Long region, Long zona,
        Long seccion, Long territorio) throws MareException 
	{

        UtilidadesLog.info("MONRecepcionLamadas.validaAccesos(Long pais, Long sociedad, Long marca, Long canal,Long acceso, Long subacceso, Long subgerencia, Long region, Long zona,Long seccion, Long territorio): Entrada");

        MONValidacion monValidacion = this.getMONValidacion();
        Boolean b = new Boolean(true);

        UtilidadesLog.debug("****Llamada a validaAcceso(pais= " + pais +
            ",sociedad = " + sociedad + ", marca=" + marca + ", canal= " +
            canal + ", acceso=" + acceso + ",subacceso = " + subacceso +
            ", subgerencia=" + subgerencia + ", region=" + region + ", zona=" +
            zona + ", seccion=" + seccion + ", territorio=" + territorio);

        try {
            b = monValidacion.validarAccesos(pais, sociedad, marca, canal,
                    acceso, subacceso, subgerencia, region, zona, seccion,
                    territorio);
        } catch (RemoteException rExc) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(
                "****Metodo MONRecepcionLamadas.validaAccesoVinculos: validaAcceso : ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.debug("****Retorno validaAcceso : " + b.toString());

        if (!b.booleanValue()) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(
                "****Metodo MONRecepcionLamadas.validaAccesoVinculos: validaAcceso : ERROR_ASOCIACION_ESTRUCTURAL");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_ASOCIACION_ESTRUCTURAL));
        }

        UtilidadesLog.info("MONRecepcionLamadas.validaAccesos(Long pais, Long sociedad, Long marca, Long canal,Long acceso, Long subacceso, Long subgerencia, Long region, Long zona,Long seccion, Long territorio): Salida");
    }

    public DTOInterfazIVR obtenerClientePorTelefono(DTOInterfazIVR DTOE) throws MareException { 
    
        UtilidadesLog.info("MONRecepcionLamadas.obtenerClientePorTelefono(DTOInterfazIVR DTOE): Entrada");
        
        //Busca en la entidad CAL:TemporalLlamadasIVR el código y 
        //tipo de cliente para el teléfono y país del DTOE 
        
        validaAccesos(DTOE.getOidPais(), null, null, null,
                                    null,null, null, null, null, null, null);
        TemporalLlamadasIVRLocalHome tempHome = getTemporalLlamadasIVRLocalHome();
        TemporalLlamadasIVRLocal ivr  = null;           
        //Crear un DTOS del tipo DTOInterfazIVR  
        DTOInterfazIVR DTOS = new DTOInterfazIVR();
        DTOS.setOidIdioma(DTOE.getOidIdioma());
        DTOS.setOidPais(DTOE.getOidPais());
       
        try {
            ivr = tempHome.findByUK(DTOE.getTelefono(), DTOE.getOidPais());
            //findByUK(telefono,pais) -> incidencia 13023
            /*Si recupera un registro: incidencia 13023
           
            DTOS.telefono = DTOE.telefono
            DTOS.oidCliente = llamar al método findByCodigoYPais (ivr.codigoCliente, DTOE.pais) de la entidad
            MAE.ClienteDatosBasicos y obtengo el oid del Cliente
            DTOS.oidTipoCliente = llamar al método findByUk (ivr.codigoTipoCliente) de la entidad MAE.TipoCliente y obtengo
            el oidTipoCliente
            ivr.remove() //se elimina el registro correspondiente al número de teléfono y país, en la entidad
            CAL:TemporalLlamadasIVR
            */ 
            DTOS.setTelefono(DTOE.getTelefono());
            ClienteDatosBasicosLocalHome clienteDatosBasicosLocalHome = new ClienteDatosBasicosLocalHome();
            ClienteDatosBasicosLocal clienteDatosBasicosLocal = null;
            
            try{
                clienteDatosBasicosLocal = clienteDatosBasicosLocalHome.findByCodigoYPais(DTOE.getOidPais(),ivr.getCodigoCliente());
            }catch(NoResultException nre){
                UtilidadesLog.error("obtenerClientePorTelefono: FinderException",nre);
                throw new MareException(nre, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch(PersistenceException pex) {
                ctx.setRollbackOnly();
                throw new MareException(pex, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
            DTOS.setOidCliente(clienteDatosBasicosLocal.getOid());
            
            TipoClienteLocalHome tipoClienteLocalHome = new TipoClienteLocalHome();
            TipoClienteLocal tipoClienteLocal = null;
            
            try{
                tipoClienteLocal = tipoClienteLocalHome.findByUK(ivr.getCodigoTipoCliente());
            }catch(NoResultException fe){
                UtilidadesLog.error("obtenerClientePorTelefono: FinderException",fe);
                throw new MareException(fe, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }catch(PersistenceException pex) {
                ctx.setRollbackOnly();
                throw new MareException(pex, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
            
            DTOS.setOidTipoCliente(tipoClienteLocal.getOid());
            try{
                tempHome.remove(ivr);
            }catch (PersistenceException pe) {
                    ctx.setRollbackOnly();
                    throw new MareException(pe, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
    
        } catch (NoResultException nre) {
            /*en otro caso 
            ver incidencia 13023
            DTOS.telefono = null 
            DTOS.oidCliente = null 
            DTOS.oidTipoCliente = null 
            */
            DTOS.setTelefono(null);
            DTOS.setOidCliente(null);
            DTOS.setOidTipoCliente(null);
            return DTOS;
        }catch(PersistenceException pex) {
                ctx.setRollbackOnly();
                throw new MareException(pex, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }   
        
        UtilidadesLog.info("MONRecepcionLamadas.obtenerClientePorTelefono(DTOInterfazIVR DTOE): Salida");
        
        return DTOS;
    }

    public DTOSalida obtenerClientes(DTOCliente DTOE) throws MareException {
    
        UtilidadesLog.info("MONRecepcionLamadas.obtenerClientes(DTOCliente DTOE): Entrada");
        
        /*Llamar al método obtenerClientes(DTOE) del DAORecepcionLlamadas y 
        obtiene el Recordset "clientes" 
        
        Crear un DTOSalida.resultado = clientes 
        
        Devuelve DTOSalida
        */
        
        DTOSalida dtoSalida = new DTOSalida();
        DAORecepcionLlamadas dao = new DAORecepcionLlamadas();
        RecordSet rs = new RecordSet();
         
        if(DTOE.getCodCliente()!=null && DTOE.getCodCliente().length()>0){
            // vbongiov -- Cambio RI 20080764 -- 9/10/2008
            rs = dao.obtenerClientePorCodigo(DTOE);
            
            if (rs.esVacio()) {
               String codigoError;
               codigoError = ErroresDeNegocio.CLIENTE_NO_EXISTE;
               UtilidadesLog.debug("Clinte no existe");
               throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CAL, "", codigoError));
            } else  {
                dtoSalida.setResultado(rs);    
            }
        }else{
            // vbongiov -- Cambio RI 20080764 -- 9/10/2008
            rs = dao.obtenerClientes(DTOE);
            
            if (rs.esVacio()) {
                throw new MareException(new Exception(),  
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } else  {
                dtoSalida.setResultado(rs);    
            }
        }
        
        UtilidadesLog.info("MONRecepcionLamadas.obtenerClientes(DTOCliente DTOE): Salida");
        
        return dtoSalida;
    }

    public DTOSalida obtenerTiposCliente(DTOCodigoCliente DTOE) throws MareException {
    
        UtilidadesLog.info("MONRecepcionLamadas.obtenerTiposCliente(DTOCodigoCliente DTOE): Entrada");
        
        /*tiposCliente = Llamar al método obtenerTiposCliente(DTOE) del DAO 

        Crear un DTOSalida 
        DTOSalida.resultado = tiposCliente
        */
        DTOSalida dtoSalida = new DTOSalida();
        DAORecepcionLlamadas dao = new DAORecepcionLlamadas();
        dtoSalida.setResultado(dao.obtenerTiposCliente(DTOE));
        
        UtilidadesLog.info("MONRecepcionLamadas.obtenerTiposCliente(DTOCodigoCliente DTOE): Salida");
        
        return dtoSalida;
    }

    //Modificado por incidencia 12606
    public DTOFichaCliente obtenerDatosFichaCliente(DTOCliente DTOE) throws MareException{
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerDatosFichaCliente(DTOCliente DTOE): Entrada ");
        
        UtilidadesLog.info("***** Se recibe DTO: "+ DTOE);
        //Se crea un dtoFicha del tipo DTOFichaCliente 
        DTOFichaCliente dtoFicha = new DTOFichaCliente();
        DAORecepcionLlamadas dao = new DAORecepcionLlamadas();
        //Cambio CALL-02 (gacevedo) 23/07/2007
        //Se habre el flujo a fin de contemplar que por pedido de cambio
        //si se ingresa el codigo de consultora, aqui no llega el tipo de cliente
        //por lo que traeremos todos los tipos y subtipos y buscaremos si es gerente
        //tipo que prevalece sobre los demas. Luego se completan los atributos de
        //tipo y subtipo para continuar con el flujo.
        
        //Se completa el siguiente dto a fin de ejecutar el codigo posterior que hacia referencia
        //al objeto subTipo que queda fuera de alcanze al encerrarse en el ELSE de la siguiente condicion.
        DTOTipificacionCliente dtoTipoSubtipo = new DTOTipificacionCliente();
        if(DTOE.getOidTipoCliente()==null){//no se informo el tipo de cliente, codigo nuevo de cambio CALL-02 (gacevedo)
            //aqui la logica indica que:
            //si existe mas de un tipo de cliente, prevalece el de rango mas alto, es decir:
            //si el cliente es gerente y consultora, se selecciona el tipo gerente.
            StringBuffer consulta = new StringBuffer();
            Vector params = new Vector();
            
            consulta.append("SELECT OID_CLIE_TIPO_SUBT, CLIE_OID_CLIE, TICL_OID_TIPO_CLIE, SBTI_OID_SUBT_CLIE, IND_PPAL ");
            consulta.append("FROM MAE_CLIEN_TIPO_SUBTI WHERE CLIE_OID_CLIE = ?");
            params.add(DTOE.getOidCliente());
            try {
                RecordSet salida = BelcorpService.getInstance().dbService.executePreparedQuery(consulta.toString(),params);
                if(salida.esVacio()){
                    throw new Exception("No existen datos");
                }
                int largo = salida.getRowCount();
                long tipoCliente=0;
                long subTipoCliente=0;
                if(largo==1){
                    tipoCliente = ((BigDecimal)salida.getValueAt(0,"TICL_OID_TIPO_CLIE")).longValue();
                    subTipoCliente = ((BigDecimal)salida.getValueAt(0,"SBTI_OID_SUBT_CLIE")).longValue();
                }else{
                    for(int i=0;i< largo;i++){
                        //si unos de los tipos de cliente es gerente, usamos ese,
                        //sino, el ultimo del recorset.
                        tipoCliente = ((BigDecimal)salida.getValueAt(i,"TICL_OID_TIPO_CLIE")).longValue();
                        subTipoCliente = ((BigDecimal)salida.getValueAt(i,"SBTI_OID_SUBT_CLIE")).longValue();
                        if(new Long(tipoCliente).equals(ConstantesMAE.OID_TIPO_CLIENTE_GERENTE)){
                            break;
                        }
                    }
                }
                dtoTipoSubtipo.setOidTipoCliente(new Long(tipoCliente));
                dtoTipoSubtipo.setOidSubtipoCliente(new Long(subTipoCliente));
                DTOE.setOidSubtipoCliente(dtoTipoSubtipo.getOidSubtipoCliente());
                DTOE.setOidTipoCliente(dtoTipoSubtipo.getOidTipoCliente());
            }
            catch (Exception e) {
                UtilidadesLog.error("obtenerDatosFichaCliente: Exception",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
        }else{//se informo el tipo de cliente, dejamos trabajar como estaba antes del cambio CALL-02 (gacevedo)
            /*14888
            //Se obtiene el subtipo de cliente
            subtipo = llamar al método findByClienteTipo (DTOE.oidCliente,
            DTOE.oidTipoCliente) de la entidad MAE.ClienteTipoSubTipo
            //Se guarda en el DTOE el oid del subtipo, para la llamada a guardarContacto:
            DTOE.oidSubtipoCliente = subtipo.oidSubtipo
            */
            ClienteTipoSubTipoLocalHome clienteTipoSubTipoHome = new ClienteTipoSubTipoLocalHome();
            ClienteTipoSubTipoLocal subTipo = null;
            try {
               subTipo = clienteTipoSubTipoHome.findByClienteTipo(DTOE.getOidCliente(), DTOE.getOidTipoCliente()); // Incidencia 12606
            } catch(NoResultException fe) {
                 UtilidadesLog.error("obtenerDatosFichaCliente: FinderException",fe);
                 throw new MareException(fe, UtilidadesError.armarCodigoError(
                 CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }catch(PersistenceException pex) {
                ctx.setRollbackOnly();
                throw new MareException(pex, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
            DTOE.setOidSubtipoCliente(subTipo.getSbti_oid_subt_clie());
            dtoTipoSubtipo.setOidTipoCliente(DTOE.getOidTipoCliente());
            dtoTipoSubtipo.setOidSubtipoCliente(subTipo.getSbti_oid_subt_clie());
        }
        /*Se guarda el contacto, si el indicador está a true, ya que cuando se 
        realiza una consulta interna no debe guardarse información en esta entidad 
        Si DTOE.indContacto 
        DTOOID dtoOid = guardarContacto(DTOE) 
        dtoFicha.oidContacto = dtoOid.oid 
        */
        if(DTOE.getIndContacto().booleanValue()){
            DTOOID dtoOid = this.guardarContacto(DTOE);
            dtoFicha.setOidContacto(dtoOid.getOid());
        }
        
        /*
        Si subtipo.oidSubtipo == ConstantesMAE.OID_SUBTIPO_CLIENTE_FINAL { 
        vinculos = llamar al método findByClienteVinculante(DTOE.oidCliente) de la
        entidad MAE.ClienteVinculo 
        Recupero el campo clienteVinculado del primer registro de la colección "vinculos" 
        oidClienteVinculado = vinculos[0].clientevinculado 
        nombreConsul = Llamar al método findByPK(oidClienteVinculado) de la entidad ClientesDatosBasicos 
        dtoFicha.nombreConsultora.nombre1 = nombreConsul.nombre1 
        dtoFicha.nombreConsultora.nombre2 = nombreConsul.nombre2 
        dtoFicha.nombreConsultora.apellido1 = nombreConsul.apellido1 
        dtoFicha.nombreConsultora.apellido2 = nombreConsul.apellido2 
        dtoFicha.nombreConsultora.apellidoCasada = nombreConsul.apellidoCasada 
        dtoFicha.nombreGerenteZona = null 
        dtoFicha.nombreGerenteRegional = null 
        dtoFicha.nombreSubgerenteVentas = null 
        } */
        if(dtoTipoSubtipo.getOidSubtipoCliente().equals(ConstantesMAE.OID_SUBTIPO_CLIENTE_FINAL)){ // ConstantesMAE.OID_SUBTIPO_CLIENTE_FINAL pendiente 12607
            
            UtilidadesLog.info("***** oid_Subtipo_cli = MAE.OID_SUBTIPO_CLIENTE_FINAL ");
            TipoVinculoLocalHome tipoVinculoHome = new TipoVinculoLocalHome();
            
            Collection vinculos = null;
            try{
            /*
             * tipoConsultoraClienteFinal = findByUk (DTOE.pais, ConstantesMAE.TIPO_VINCULO_CONSULTORA_CLIENTEFINAL de la entidad MAE:TipoVinculo
             */
          
                TipoVinculoLocal tipoConsultoraClienteFinal = tipoVinculoHome.findByUK(DTOE.getOidPais(),ConstantesMAE.TIPO_VINCULO_CONSULTORA_CLIENTEFINAL); // cambiado 12606
                ClienteVinculoLocalHome clienteVinculoHome = new ClienteVinculoLocalHome();
                   //vinculos = clienteVinculoHome.findAll();  // pendiente 12606
                vinculos = clienteVinculoHome.findByClienteVinculanteTipoVinculo(DTOE.getOidCliente(),tipoConsultoraClienteFinal.getOid());
            
                UtilidadesLog.info("***** Vinculos_Cole: ["+vinculos+"] size: " + vinculos.size());
            
            }catch(NoResultException fe){
                UtilidadesLog.error("obtenerDatosFichaCliente: FinderException",fe);
                throw new MareException(fe, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }catch(PersistenceException pex) {
                ctx.setRollbackOnly();
                throw new MareException(pex, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
            
            //agrega 29/05/2006 inc. BELC300023202
            // controlo que la coleccion de vinculos no este vacia
            if(vinculos.size() > 0){ //<-- agrega linea
              
              
            Iterator itVinculos = vinculos.iterator(); 
            ClienteVinculoLocal clienteVinculoLocal = (ClienteVinculoLocal)itVinculos.next();
            Long oidClienteVinculado = clienteVinculoLocal.getClie_oid_clie_vndo();
            
            ClienteDatosBasicosLocalHome clienteDatosBasicosHome = new ClienteDatosBasicosLocalHome();
            ClienteDatosBasicosLocal nombreConsul = null;
            
            try{
                nombreConsul = clienteDatosBasicosHome.findByPrimaryKey(oidClienteVinculado);
            }catch(NoResultException fe){
                UtilidadesLog.error("obtenerDatosFichaCliente: FinderException",fe);
                throw new MareException(fe, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }catch(PersistenceException pex) {
                ctx.setRollbackOnly();
                throw new MareException(pex, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
            DTONombre dtoNombreConsultora = new DTONombre();
            dtoNombreConsultora.setNombre1(nombreConsul.getVal_nom1());
            dtoNombreConsultora.setNombre2(nombreConsul.getVal_nom2());
            dtoNombreConsultora.setApellido1(nombreConsul.getVal_ape1());
            dtoNombreConsultora.setApellido2(nombreConsul.getVal_ape2());
            dtoNombreConsultora.setApellidoCasada(nombreConsul.getVal_apel_casa());
            
            dtoFicha.setNombreConsultora(dtoNombreConsultora);
            } // <-- agrega linea    BELC300023202    
           
            dtoFicha.setNombreGerenteZona(null);
            dtoFicha.setNombreGerenteRegional(null);
            dtoFicha.setNombreSubgerenteVentas(null);
        }

        /*Si DTOE.oidTipoCliente == ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA { 
        dtoFicha.nombreGerenteZona = Llamar al método obtenerNombreGerenteZona(DTOE.oidCliente) del DAORecepcionLlamadas 
        dtoFicha.nombreConsultora = null 
        dtoFicha.nombreGerenteRegional = null 
        dtoFicha.nombreSubgerenteVentas = null 
        }*/ 
        if(DTOE.getOidTipoCliente().equals(ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA)){
            UtilidadesLog.info("***** oid_Subtipo_cli = MAE.OID_TIPO_CLIENTE_CONSULTORA ");
            dtoFicha.setNombreGerenteZona(dao.obtenerNombreGerenteZona(DTOE.getOidCliente()));
            dtoFicha.setNombreConsultora(null);
            dtoFicha.setNombreGerenteRegional(null);
            dtoFicha.setNombreSubgerenteVentas(null);
        
        }
        
        /* Si subtipo.oidSubtipo == ConstantesMAE.OID_SUBTIPO_GERENTE_ZONA { 
        dtoFicha.nombreGerenteRegional = Llamar al método obtenerNombreGerenteRegional(DTOE.oidCliente) del DAORecepcionLlamadas 
        dtoFicha.nombreConsultora = null 
        dtoFicha.nombreGerenteZona = null 
        dtoFicha.nombreSubgerenteVentas = null 
        }*/
        if(dtoTipoSubtipo.getOidSubtipoCliente().equals(ConstantesMAE.OID_SUBTIPO_GERENTE_ZONA)){ 
             UtilidadesLog.info("***** oid_Subtipo_cli = MAE.OID_SUBTIPO_GERENTE_ZONA ");
            dtoFicha.setNombreGerenteRegional(dao.obtenerNombreGerenteRegional(DTOE.getOidCliente()));
            dtoFicha.setNombreConsultora(null);
            dtoFicha.setNombreGerenteZona(null);
            dtoFicha.setNombreSubgerenteVentas(null);
        }
        

        /*Si subtipo.oidSubtipo == ConstantesMAE.OID_TIPO_SUBTIPO_GERENTE_REGION { 
        dtoFicha.nombreSubgerenteVentas = Llamar al método obtenerNombreGerenteRegion(DTOE.oidCliente) del DAORecepcionLlamadas 
        dtoFicha.nombreConsultora = null 
        dtoFicha.nombreGerenteZona = null 
        dtoFicha.nombreGerenteRegional = null 
        } */
        if(dtoTipoSubtipo.getOidSubtipoCliente().equals(ConstantesMAE.OID_SUBTIPO_GERENTE_REGION)){ 
            dtoFicha.setNombreSubgerenteVentas(dao.obtenerNombreSubgerenteVentas(DTOE.getOidCliente())); //Incidencia 12606
            dtoFicha.setNombreConsultora(null);
            dtoFicha.setNombreGerenteZona(null);
            dtoFicha.setNombreGerenteRegional(null);
        }
        
        
        //Obtenemos los datos generales del cliente 
        //dtoFicha.cliente = Llamar al método obtenerDatosGeneralesCliente(DTOE) 
        //del DAORecepcionLlamadas 
        dtoFicha.setCliente(dao.obtenerDatosGeneralesCliente(DTOE));
        
        /* Cambios por incidencia BELC300013304 
         //Obtenemos los motivos del bloqueo administrativo y financiero
         bloqueoAdministrativo = findByClienteTipoBloqueo (DTOE.oidCliente,
         ContantesMAE.OID_BLOQUEO_ADMINISTRATIVO) de la entidad MAE.ClienteBloqueo
         Si se recupera un registro en el find //solo puede haber un bloqueo para ese cliente y ese tipo
            dtoFicha.cliente.desBloqueoAdministrativo = bloqueoAdministrativo.motivoBloqueo
         en otro caso
            dtoFicha.cliente.desBloqueoAdministrativo = null
         
         bloquedoFinanciero = findByClienteTipoBloqueo (DTOE.oidCliente,
         ContantesMAE.OID_BLOQUEO_FINANCIERO) de la entidad MAE.ClienteBloqueo
         Si se recupera un registro en el find //solo puede haber un bloqueo para ese cliente y ese tipo
            dtoFicha.cliente.desBloqueoFinanciero = bloqueoFinanciero.motivoBloqueo
         en otro caso
            dtoFicha.cliente.desBloqueoFinanciero = null
         
         */
        /*se saca por COL-blo-01 (SCS-23/10/2007)
        ClienteBloqueoLocalHome clienteBloqueoHome = this.getClienteBloqueoLocalHome();
        ClienteBloqueoLocal clienteBloqueoAdmin = null;
        ClienteBloqueoLocal clienteBloqueoFinanc = null;
        
        boolean clienteBloqAdmin = true;
        
        try{
            clienteBloqueoAdmin = clienteBloqueoHome.findByClienteTipoBloqueo(DTOE.getOidCliente(), ConstantesMAE.OID_BLOQUEO_ADMINISTRATIVO);
        }catch(FinderException fe){
            UtilidadesLog.debug("**** No existe Bloqueo Administrativo para el cliente_ "+DTOE.getOidCliente());
            UtilidadesLog.error("obtenerDatosFichaCliente: FinderException",fe);
            clienteBloqAdmin = false;
        }
        
         if (clienteBloqAdmin) {
            dtoFicha.getCliente().setDesBloqueoAdministrativo(clienteBloqueoAdmin.getVal_moti_bloq());            
         } else {
            dtoFicha.getCliente().setDesBloqueoAdministrativo(null);
         } 
        
        boolean clienteBloqFinanc = true;
        try{
            clienteBloqueoFinanc = clienteBloqueoHome.findByClienteTipoBloqueo(DTOE.getOidCliente(), ConstantesMAE.OID_BLOQUEO_FINANCIERO);
        }catch(FinderException fe){
                UtilidadesLog.debug("**** No existe Bloqueo Financiero para el cliente_ "+DTOE.getOidCliente());
                //UtilidadesLog.error("obtenerDatosFichaCliente: FinderException", fe);
                //Es una excepcion controlada se quita el logueo del error.
                clienteBloqFinanc = false;
        }
        
         if (clienteBloqFinanc) {
            dtoFicha.getCliente().setDesBloqueoFinanciero(clienteBloqueoFinanc.getVal_moti_bloq());
         } else {
            dtoFicha.getCliente().setDesBloqueoFinanciero(null);
         }
        */  
        
        //cambio COL-blo-01 (SCS-23/10/2007)
        dtoFicha.getCliente().setBloqueo(dao.obtenerDescrBloqueo(DTOE.getOidCliente(), DTOE.getOidPais(), DTOE.getOidIdioma()));

        /*//Guardamos código cliente/tipo/subtipo //BELC300012941
        dtoFicha.cliente.oidTipoCliente = DTOE.oidTipoCliente 
        dtoFicha.cliente.oidSubtipoCliente = subtipo.oidSubtipo 
        DTOE.oidSubtipoCliente = subtipo.oidSubtipo //para la llamada a obtenerTipificacionCliente 
        */
        
        dtoFicha.getCliente().setOidTipoCliente(DTOE.getOidTipoCliente());
        dtoFicha.getCliente().setOidSubtipoCliente(dtoTipoSubtipo.getOidSubtipoCliente()); 
        
        DTOE.setOidSubtipoCliente(dtoTipoSubtipo.getOidSubtipoCliente());
        
        //Obtenemos la descripción de la tipificación del cliente 
        //dtoFicha.tipificacion = Llamar al método obtenerTipificacionCliente(DTOE) 
        //del DAORecepcionLlamadas 
       
        //Incidencia 12606
        dtoFicha.setTipificacion(dao.obtenerTipificacionCliente(DTOE));
        
        //Obtenemos el grupo de Unidades Administrativas 
        //dtoFicha.unidadesAdministrativas = llamar al método 
        //obtenerUnidadesAdministrativas(DTOE) del DAORecepcionLlamadas 
        dtoFicha.setUnidadesAdministrativas(dao.obtenerUnidadesAdministrativas(DTOE));

        //Obtenemos el grupo de últimos pedidos 
        //dtoFicha.ultimosPedidos = llamar al método obtenerUltimosPedidos(DTOE) 
        //del DAORecepcionLlamadas 
        dtoFicha.setUltimosPedidos(dao.obtenerUltimosPedidos(DTOE));
        dtoFicha.setTipoComunicacion(dao.obtenerTipoComunicacion(DTOE));
        
        //Y por último el monto de las solicitudes nuevas 
        //dtoFicha.montoSolicitudesNuevas = Llamar al método 
        //PED.DAOSolicitud.CalcularMontoSolicitudesNuevas(DTOE.oidCliente) 
        DAOSolicitud daoSolicitud = new DAOSolicitud();
        BigDecimal monto = daoSolicitud.calcularMontoSolicitudesNuevas(DTOE.getOidCliente());
        if (monto != null)
                dtoFicha.setMontoSolicitudesNuevas(new Long(monto.longValue()));
              
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerDatosFichaCliente(DTOCliente DTOE): Salida");
        
        //Devuelve el dtoFicha.
        return dtoFicha;
    }


    /** 
     * Método para obtener los tipos de llamada
     * @param dto DTOBelcorp con el pais e idioma del usuario
     * @return DTOSalida con los datos encontrados
     * @exception MareException si no se pudo acceder a la base de datos
     */
     
   public DTOSalida obtenerTipoLlamada(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerTipoLLamada(DTOBelcorp dto): Entrada");
      
        //Se retorna el DTOSalida que devuelve el método
        //DAORecepcionLlamadas.obtenerEstadoContacto(dto)
        DAORecepcionLlamadas dao = new DAORecepcionLlamadas();
        DTOSalida dtoSalida = dao.obtenerTipoLlamada(dto);
        
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerTipoLLamada(DTOBelcorp dto): Salida");
        return dtoSalida ;
   }
    
   /**
    * Agregado por incidencia CAL-04
    */
   public DTOSalida obtenerCabeceraPedidoNoFacturado(DTOOIDPaginado DTOE) throws MareException {
    UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerCabeceraPedidoNoFacturado(DTOOIDPaginado DTOE): Entrada");
   
        DAORecepcionLlamadas dao = new DAORecepcionLlamadas();
        DTOSalida dtoSalida = new DTOSalida();   
        dtoSalida.setResultado(dao.obtenerCabeceraPedidoNoFacturado(DTOE));  
   
     UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerCabeceraPedidoNoFacturado(DTOOIDPaginado DTOE): Salida");
    return dtoSalida;  
    }

    public void guardarBloqueoAdm(DTOBloqueoAdm dtoGuardado) throws MareException
    {
        UtilidadesLog.info("MONRecepcionLlamadasBean.guardarBloqueoAdm(DTOBloqueoAdm dtoGuardado): Entrada");
        UtilidadesLog.error("DTOBloqueoAdm, es: " + dtoGuardado);
        //guardo en: MAE-Clien-Bloqu
        String usuarioBloqueo = ctx.getCallerPrincipal().getName();
        DAORecepcionLlamadas dao = new DAORecepcionLlamadas();
        dao.guardoBloqueo(dtoGuardado, usuarioBloqueo);
        
        UtilidadesLog.info("MONRecepcionLlamadasBean.guardarBloqueoAdm(DTOBloqueoAdm dtoGuardado): Salida");
    }

    /**
     * Metodo agregado por cambio COL-blo-01 (SCS-23/10/2007)
     * recupera, tipos de bloqueo
     */
   public DTOSalida obtenerTiposBloqueo(DTOOID dtoEnt) throws MareException {
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerTiposBloqueo(DTOOID dtoEnt): Entrada");
        // vbongiov -- 30/05/2008
        String usuario = ctx.getCallerPrincipal().getName();
        
        DAORecepcionLlamadas dao = new DAORecepcionLlamadas();
        UtilidadesLog.info("MONRecepcionLlamadasBean.obtenerTiposBloqueo(DTOOID dtoEnt): Salida");
        return dao.obtenerTiposBloqueo(dtoEnt.getOidIdioma().longValue(), usuario);
   }
   
    private ContactoLocalHome getContactoLocalHome(){
      
           return new ContactoLocalHome();          
     }
     
      private AtributoEstadoContactoLocalHome getAtributoEstadoContactoLocalHome()  {
                return new AtributoEstadoContactoLocalHome();
     }

     private TemporalLlamadasIVRLocalHome getTemporalLlamadasIVRLocalHome() {
           
           return new TemporalLlamadasIVRLocalHome();
     }

    public DTOCliente obtenerIndicadorActivo(DTOCliente dtoe) throws MareException {
        
        UtilidadesLog.info("MONRecepcionLlamadasBean(DTOCliente dtoe): Entrada");
        DAORecepcionLlamadas dao = new DAORecepcionLlamadas();
        UtilidadesLog.info("MONRecepcionLlamadasBean(DTOCliente dtoe): Salida");
        return dao.obtenerIndicadorActivo(dtoe);
    }
}
