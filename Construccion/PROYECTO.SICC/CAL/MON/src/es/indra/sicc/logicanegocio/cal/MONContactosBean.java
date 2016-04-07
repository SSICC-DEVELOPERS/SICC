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

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.dtos.cal.DTOBuscarCursosReuniones;
import es.indra.sicc.dtos.cal.DTOBuscarInformacionProductos;
import es.indra.sicc.dtos.cal.DTOBuscarPedidosNoFacturados;
import es.indra.sicc.dtos.cal.DTOBuscarStockProducto;
import es.indra.sicc.dtos.cal.DTOCargarOID;
import es.indra.sicc.dtos.cal.DTOCliente;
import es.indra.sicc.dtos.cal.DTOConsultaGerente;
import es.indra.sicc.dtos.cal.DTOConsultarFechasCronograma;
import es.indra.sicc.dtos.cal.DTODatosClien;
import es.indra.sicc.dtos.cal.DTOIngresoConsultora;
import es.indra.sicc.dtos.cal.DTOReclamo;
import es.indra.sicc.entidades.cal.DetalleBuzonLocal;
import es.indra.sicc.entidades.cal.DetalleBuzonLocalHome;
import es.indra.sicc.logicanegocio.bel.MONServicioBEL;
import es.indra.sicc.logicanegocio.bel.MONServicioBELHome;
import es.indra.sicc.logicanegocio.cra.MONCronograma;
import es.indra.sicc.logicanegocio.cra.MONCronogramaHome;
import es.indra.sicc.logicanegocio.edu.MONCursos;
import es.indra.sicc.logicanegocio.edu.MONCursosHome;
import es.indra.sicc.logicanegocio.mae.MONClientes;
import es.indra.sicc.logicanegocio.mae.MONClientesHome;
import es.indra.sicc.logicanegocio.mae.MONProductos;
import es.indra.sicc.logicanegocio.mae.MONProductosHome;
import es.indra.sicc.logicanegocio.ped.MONPedidosSolicitud;
import es.indra.sicc.logicanegocio.ped.MONPedidosSolicitudHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.rmi.RemoteException;

import java.sql.Timestamp;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.persistence.PersistenceException;


public class MONContactosBean implements SessionBean {
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

    public void setSessionContext(SessionContext ctx)
    {
    }

    public DTOSalida consultarProgramasLanzamiento(DTOSiccPaginacion dto) throws MareException
    {
    /*Se retorna el DTOSalida que devuelve el método 
    * DAOContactos.consultarProgramasLanzamiento(dto)*/
        
        UtilidadesLog.info("*** Metodo MONContactosBean.consultarProgramasLanzamiento(DTOSiccPaginacion dto): Entrada");
        DTOSalida dtoS = new DTOSalida();
        DAOContactos dao = new DAOContactos();
        dtoS = dao.consultarProgramasLanzamiento(dto);  
        UtilidadesLog.info("*** Metodo MONContactosBean.consultarProgramasLanzamiento(DTOSiccPaginacion dto): Salida");
        return dtoS;
    }

  public DTOSalida cargarContactos(DTOCargarOID dto) throws MareException {
    UtilidadesLog.info("*** Metodo MONContactosBean.cargarContactos(DTOCargarOID dto): Entrada");
    DAOContactos dao = new DAOContactos();
    DTOSalida dtoS = dao.cargarContactos(dto);
    UtilidadesLog.info("*** Metodo MONContactosBean.cargarContactos(DTOCargarOID dto): Salida");
    return dtoS;
  }

  public DTOSalida cargarMotivosTipoCliente(DTOCargarOID dto) throws MareException {
    UtilidadesLog.info("*** Metodo MONContactosBean.cargarMotivosTipoCliente(DTOCargarOID dto): Entrada");
    DAOContactos dao = new DAOContactos();
    DTOSalida dtoS = dao.cargarMotivosTipoCliente(dto);
    UtilidadesLog.info("*** Metodo MONContactosBean.cargarMotivosTipoCliente(DTOCargarOID dto): Salida");
    return dtoS;
  }
  
   private MONServicioBEL getMONServicioBEL() throws MareException {
   
    UtilidadesLog.info("MONContactosBean.getMONServicioBEL(): Entrada");
    
    MONServicioBELHome home = (MONServicioBELHome) UtilidadesEJB.getHome("MONServicioBEL",MONServicioBELHome.class);
    MONServicioBEL ejb = null;
    try {
        ejb = home.create();
    } catch (Exception e) { 
    
            UtilidadesLog.error("*** Error en getMONServicioBEL",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));     
    }
    
    UtilidadesLog.info("MONContactosBean.getMONServicioBEL(): Salida");
    return ejb;
  }
  		
  private MONClientes getMONClientes() throws MareException {
    // Se obtiene el interfaz home
		UtilidadesLog.info("MONContactosBean.getMONClientes(): Entrada");
    MONClientesHome home = (MONClientesHome) UtilidadesEJB.getHome("MONClientes",MONClientesHome.class);
    //Se obtiene el interfaz remoto
    MONClientes ejb = null;
    try {
        ejb = home.create();
    } catch (Exception e) { 
    
            UtilidadesLog.error("*** Error en getMONClientes",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));     
    }
    
		UtilidadesLog.info("MONContactosBean.getMONClientes(): Salida");
    return ejb;
  }

  public DTOSalida obtenerZonaMarcaCanal(DTOOID dto) throws MareException {
    UtilidadesLog.info("MONContactosBean.obtenerZonaMarcaCanal(DTOOID dto): Entrada");
    MONClientes mon = this.getMONClientes();
    DTOSalida dtoS = null;
    try {
      dtoS = mon.obtenerZonaMarcaCanal(dto); //incidencia 12321
    } catch(RemoteException re) {
			UtilidadesLog.error("*** Error en obtenerZonaMarcaCanal",re);
			String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));				
		}
        
    UtilidadesLog.info("MONContactosBean.obtenerZonaMarcaCanal(DTOOID dto): Salida");
    
    return dtoS;
  }
  
  public DTOSalida consultarGerente(DTOOID dto) throws MareException {
    UtilidadesLog.info("MONContactosBean.consultarGerente: Entrada");
    
    DTOSalida dtoS = null;
    MONClientes mon = this.getMONClientes();
    try {
      dtoS = mon.consultarGerenteZona(dto); //incidencia 12321
    } catch(RemoteException re) {
			UtilidadesLog.error("*** Error en consultarGerente",re);
			String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));				
		}
      
    UtilidadesLog.info("MONContactosBean.consultarGerente: Salida");
    
    return dtoS;
  }

  public DTOSalida buscarStockProducto(DTOBuscarStockProducto dto) throws MareException {
  
    UtilidadesLog.info("MONContactosBean.buscarStockProducto(DTOBuscarStockProducto dto): Entrada");
    
    DTOSalida dtoS = null;
    MONServicioBEL mon = this.getMONServicioBEL();
    try {
      dtoS = mon.buscarStockProducto(dto); //incidencia 12317
    } catch(RemoteException re) {
			UtilidadesLog.error("*** Error en buscarStockProducto",re);
			String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));				
		}
        
    UtilidadesLog.info("MONContactosBean.buscarStockProducto(DTOBuscarStockProducto dto): Salida");
    
    return dtoS;
  }

  public void insertarReclamos(DTOReclamo dtoE) throws MareException
  {
  
        UtilidadesLog.info("MONContactosBean.insertarReclamos(DTOReclamo dtoE): Entrada");
        
    /*  Incidencia 12419
     * Crea un nuevo detalleBuzon en la entidad: DetalleBuzon con la siguiente información:
           - detalleBuzon.oidDetalle = número de secuencia generado por la base de datos
           - detalleBuzon.oidCabecera = DTOE.oidCabecera
           - detalleBuzon.codActividad = detalleBuzon.oidDetalle 
           - detalleBuzon.descripcionActividad = DTOE.descripcionActividad
           - detalleBuzon.fechaHoraCreacion = fecha y hora del sistema
           - detalleBuzon.oidContacto = DTOE.oidContacto
           - detalleBuzon.oidGestion = DTOE.oidGestion
           - detalleBuzon.observaciones = DTOE.observaciones
           - detalleBuzon.idUsuario = DTOE.codUsuario
           - detalleBuzon.estatusActividad = ConstantesCAL.NO_PROCESADO */
           
        DetalleBuzonLocalHome detalleBuzonLocalHome = this.getDetalleBuzonLocalHome();
				DetalleBuzonLocal detalleBuzon = null;
		
			
		try{
        
            /*
            * pperez 12/10/2006 - Incidencia DBLG700000121
            * */            
            Long cod_acti = obtenerNumeroSecuencialProximoDetalle(dtoE.getOidCabecera());        
			detalleBuzon = detalleBuzonLocalHome.create(
            cod_acti,//  Long cod_acti, el cmp coge por defecto para este valor el secuenciador luego da igual que valor le pasemos.
            dtoE.getDescripcionActividad(),//  String val_desc_acti,
            new Timestamp(System.currentTimeMillis()),//Timestamp fec_hora_crea,
            dtoE.getCodUsuario(),//String cod_usua,
            dtoE.getOidCabecera(),// Long cabu_oid,
            dtoE.getOidContacto(),//Long cont_oid,
            ConstantesCAL.NO_PROCESADO//Long oid_estatus_actividad_contacto
            );
            }catch(PersistenceException e) {
                 ctx.setRollbackOnly();
                 throw new MareException(e,
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            } 
            detalleBuzon.setObservaciones(dtoE.getObservaciones());
            detalleBuzon.setOidTipoGestion(dtoE.getOidTipoGestionCliente());
            detalleBuzonLocalHome.merge(detalleBuzon);
            
            
        UtilidadesLog.info("MONContactosBean.insertarReclamos(DTOReclamo dtoE): Salida");
  }

  public DTOSalida detalleInformacionProducto(DTOOID dtoOid) throws MareException
  {
    UtilidadesLog.info("MONContactosBean.detalleInformacionProducto(DTOOID dtoOid): Entrada");		
    MONProductos monProductos = this.getMONProductos();
    DTOSalida dto = null;
    try{
      dto = monProductos.detalleInformacionProducto(dtoOid);
    }catch(RemoteException e){
      UtilidadesLog.error("*** Error en detalleInformacionProducto",e);
      String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
      throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));     
    }
    
    UtilidadesLog.info("MONContactosBean.detalleInformacionProducto(DTOOID dtoOid): Salida");		
    
    return dto;
  }


    //cambio parámetro de entrada por iincidencia 12556
    public DTOSalida consultarCursosReuniones(DTOBuscarCursosReuniones dto) throws MareException {
    
        UtilidadesLog.info("MONContactosBean.consultarCursosReuniones(DTOBuscarCursosReuniones dto): Entrada");		
    
    
        //Retorna el DTOSalida que devuelve el método IEDU.consultarCursosReuniones(dto)
        MONCursosHome home = (MONCursosHome) UtilidadesEJB.getHome("MONCursos",MONCursosHome.class);                  
            
        MONCursos cursos = null;
        
        try{
           cursos = home.create();
        } catch (Exception e) {
            UtilidadesLog.error(e);

          String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
          throw new MareException(e,
              UtilidadesError.armarCodigoError(codigoError));
        }
            DTOSalida dtoSalida = null;
        try{
            dtoSalida = cursos.consultarCursosReuniones(dto);  
        } catch (RemoteException e) {
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
        }
        
        UtilidadesLog.info("MONContactosBean.consultarCursosReuniones(DTOBuscarCursosReuniones dto): Salida");		
        
        return dtoSalida;
    }


    /** 
     * Método para obtener los nombres de un cliente
     * @param oidCliente DTOOID con el oid de cliente
     * @return DTOSalida con los nombres encontrados
     * @exception MareException si no se pudo acceder a la base de datos
     */
    public DTOSalida consultarNombresCliente(DTOOID oidCliente) throws MareException {
        UtilidadesLog.info("MONContactosBean.consultarNombresCliente(DTOOID oidCliente): Entrada");
        DAOContactos dao = new DAOContactos();
        DTOSalida dtoS = dao.consultarNombresCliente(oidCliente);
        UtilidadesLog.info("MONContactosBean.consultarNombresCliente(DTOOID oidCliente): Salida");
        return dtoS;
    }
  
    /** 
     * Método para obtener las consultoras hijas de un cliente
     * @param datosCliente DTODatosClien con el oid del cliente
     * @return DTOSalida con las consultoras encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron consultoras
     */
     //Modificado por incidencia BELC300013227 
    public DTOSalida consultarConsultorasHijas(DTOOID datosCliente) throws MareException {
        UtilidadesLog.info("MONContactosBean.consultarConsultorasHijas(DTOOID datosCliente): Entrada");
        DAOContactos dao = new DAOContactos();
        RecordSet rs= dao.consultarConsultorasHijas(datosCliente);
        DTOSalida dtoS = new DTOSalida();
        dtoS.setResultado(rs);
        UtilidadesLog.info("MONContactosBean.consultarConsultorasHijas(DTOOID datosCliente): Salida");
        return dtoS;
    }
  
  
    /** 
     * Método para obtener los status de una consultora
     * @param entrada DTOIngresoConsultora con el oid del cliente
     * @return DTOSalida con los status encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se encontraron datos
     */
    public DTOSalida obtenerStatusConsultora (DTOIngresoConsultora entrada) throws MareException {
        UtilidadesLog.info("MONContactosBean.obtenerStatusConsultora(DTOIngresoConsultora entrada): Entrada");
        DAOContactos dao = new DAOContactos();
        DTOSalida dtoS = dao.obtenerStatusConsultora(entrada);
        UtilidadesLog.info("MONContactosBean.obtenerStatusConsultora(DTOIngresoConsultora entrada): Salida");
        return dtoS;
    }

    /** 
     * Método para obtener los datos historicos de una consultora
     * @param entrada DTOIngresoConsultora con el oid del cliente
     * @return DTOSalida con los datos historicos
     * @exception MareException si no se pudo acceder a la base de datos
     */
    public DTOSalida obtenerHistoricoDatos(DTOIngresoConsultora datosCliente) throws MareException {
        UtilidadesLog.info("MONContactosBean.obtenerHistoricoDatos(DTOIngresoConsultora datosCliente): Entrada");
        DAOContactos dao = new DAOContactos();
        DTOSalida dtoS = dao.obtenerHistoricoDatos(datosCliente);
        UtilidadesLog.info("MONContactosBean.obtenerHistoricoDatos(DTOIngresoConsultora datosCliente): Salida");
        return dtoS;
    }

    /** 
     * Método para obtener los pedidos no facturados de un periodo corporativo
     * @param dto DTOBuscarPedidosNoFacturados con el oid del periodo corporativo
     * @return DTOSalida con los datos de los pedidos no facturados
     * @exception MareException si no se pudo acceder a la base de datos o no se encontraron datos
     */
    public DTOSalida buscarPedidosNoFacturados(DTOBuscarPedidosNoFacturados dto) throws MareException {
        UtilidadesLog.info("MONContactosBean.buscarPedidosNoFacturados(DTOBuscarPedidosNoFacturados dto): Entrada");
        
        UtilidadesLog.debug("dto de entrada al mon: " + dto);
        
        MONPedidosSolicitud monPedidosSolicitud = this.getMONPedidosSolicitudHome();
		DTOSalida dtoS = null;
        try {
            dtoS = monPedidosSolicitud.buscarPedidosNoFacturados(dto); //pendiente 12593
        } catch (RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONContactosBean.buscarPedidosNoFacturados(DTOBuscarPedidosNoFacturados dto): Salida");
        return dtoS;
    }


    /** 
     * Método para obtener la información de los productos que cumplen el criterio especificado por el usuario
     * @param dto DTOBuscarInformacionProductos con los criterios de búsqueda
     * @return DTOSalida con los datos de los productos
     * @exception MareException si no se pudo acceder a la base de datos o no se encontraron datos
     */
    public DTOSalida buscarInformacionProductos(DTOBuscarInformacionProductos dto) throws MareException {
    
        UtilidadesLog.info("MONContactosBean.buscarInformacionProductos(DTOBuscarInformacionProductos dto): Entrada");
        
        MONProductos monProductos = this.getMONProductos();
 
        DTOSalida dtoS = null;
        try {
            dtoS = monProductos.buscarInformacionProductos(dto);
        } catch (RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.info("MONContactosBean.buscarInformacionProductos(DTOBuscarInformacionProductos dto): Salida");
        
        return dtoS;
    }
    
	/*private void logearError(String mensaje,Throwable e) {
		//mensaje: nombreMetodo: tipoExcepcion
		UtilidadesLog.error("****Error Metodo: "+mensaje+": "+ e.getMessage());
		UtilidadesLog.error(e);
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

    public DTOSalida consultarFechasCronograma(DTOConsultarFechasCronograma dto) throws MareException
    {
        UtilidadesLog.info("MONContactosBean.consultarFechasCronograma(DTOConsultarFechasCronograma dto): Entrada");
        
        MONCronograma monCronograma = this.getMONCronograma();
        try{
            UtilidadesLog.info("MONContactosBean.consultarFechasCronograma(DTOConsultarFechasCronograma dto): Salida");
            return monCronograma.consultarFechasCronograma(dto);
        }catch (RemoteException e) {
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
        }
    }

    private MONCronograma getMONCronograma() throws MareException {
        // Se obtiene el interfaz home
		UtilidadesLog.info("MONContactosBean.getMONCronograma(): Entrada");
        MONCronogramaHome home = (MONCronogramaHome)UtilidadesEJB.getHome(
            "MONCronograma", MONCronogramaHome.class);
            
        // Se obtiene el interfaz remoto
        MONCronograma ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONCronograma",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        
		UtilidadesLog.info("MONContactosBean.getMONCronograma(): Salida");
        
        return ejb;
	}     

  private MONProductos getMONProductos() throws MareException {
    // Se obtiene el interfaz home
    
		UtilidadesLog.info("MONContactosBean.getMONProductos(): Entrada");
        
        MONProductosHome home = (MONProductosHome)UtilidadesEJB.getHome(
            "MONProductos", MONProductosHome.class);
            
        // Se obtiene el interfaz remoto
        MONProductos ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONProductos", e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        
		UtilidadesLog.info("MONContactosBean.getMONProductos(): Salida");
    
    return ejb;
	}     

    private MONPedidosSolicitud getMONPedidosSolicitudHome() throws MareException {
        // Se obtiene el interfaz home
        
        UtilidadesLog.info("MONContactosBean.getMONPedidosSolicitudHome(): Entrada");

        MONPedidosSolicitudHome home = (MONPedidosSolicitudHome) UtilidadesEJB.getHome("MONPedidosSolicitud", MONPedidosSolicitudHome.class);

        // Se obtiene el interfaz remoto
        MONPedidosSolicitud ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONPedidosSolicitudHome", e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONContactosBean.getMONPedidosSolicitudHome(): Salida");

        return ejb;
    }
    public DTOSalida obtenerDatosGerente(DTOConsultaGerente entrada) throws MareException{
    
       UtilidadesLog.info("MONContactosBean.obtenerDatosGerente(DTOConsultaGerente entrada): Entrada");
       
        /*Documentation
        Se invoca al método obtenerDatosDireccionTelefonoGerente del DAOContactos 
        y devolvemos el DTOSalida que nos retorna
        */
        DAOContactos dao = new DAOContactos();
        DTOSalida salida = dao.obtenerDatosDireccionTelefonoGerente(entrada);
        
       UtilidadesLog.info("MONContactosBean.obtenerDatosGerente(DTOConsultaGerente entrada): Salida");
        
        return salida;
    }

    public DTOSalida obtenerCodUsuario(DTOBelcorp DTOE) throws MareException{
       /*Documentation
        Llamar al metodo obtenerCodUsuario() del DAOContactos pasandole el DTOE
        */
        
        UtilidadesLog.info("MONContactosBean.obtenerCodUsuario(DTOBelcorp DTOE): Entrada");
        
        DAOContactos dao = new DAOContactos();
        DTOSalida salida = new DTOSalida();
        RecordSet rs = dao.obtenerCodUsuario(DTOE);
        salida.setResultado(rs);
        
        UtilidadesLog.info("MONContactosBean.obtenerCodUsuario(DTOBelcorp DTOE): Salida");
        
        return salida;
    }

    public DTOSalida obtenerBuzonUsuario(DTOCliente DTOE) throws MareException{
        /*Documentation
        Llamar al metodo obtenerBuzonUsuario() del DAOContactos pasandole el DTOE
        */
        
        UtilidadesLog.info("MONContactosBean.obtenerBuzonUsuario(DTOCliente DTOE): Entrada");
        
        DAOContactos dao = new DAOContactos();
        DTOSalida salida = new DTOSalida();
        RecordSet rs = dao.obtenerBuzonUsuario(DTOE);
        salida.setResultado(rs);        
        
        UtilidadesLog.info("MONContactosBean.obtenerBuzonUsuario(DTOCliente DTOE): Salida");
        
        return salida; 
    }

   public DTOSalida consultarClasificacion(DTODatosClien DTOE) throws MareException {
      //ver incidencia 12630 para el diseño de este metodo
      
      UtilidadesLog.info("MONContactosBean.consultarClasificacion(DTODatosClien DTOE): Entrada");
      
      DAOContactos dao = new DAOContactos();
      DTOSalida salida = dao.consultarClasificacion(DTOE);
      
      UtilidadesLog.info("MONContactosBean.consultarClasificacion(DTODatosClien DTOE): Salida");
      
      return salida;
   }

  public DTOSalida obtenerMotivosContacto(DTOBelcorp dto) throws MareException{
    DAOContactos dao = new DAOContactos();
    return dao.obtenerMotivosContacto(dto);
  }

  /*
   * pperez 12/10/2006 - Incidencia DBLG700000121
   * */
  
  public Long obtenerNumeroSecuencialProximoDetalle(Long oidBuzon) throws MareException {
    UtilidadesLog.log(" Ingreso obtenerNumeroSecuencialProximoDetalle ");
    DAOBuzon dao = new DAOBuzon();
    Long numeroSecuencia = dao.obtenerNumeroSecuencialUltimoDetalle(oidBuzon);
    UtilidadesLog.log(" Sale obtenerNumeroSecuencialProximoDetalle " + numeroSecuencia);
    return numeroSecuencia;
  }
  
    private DetalleBuzonLocalHome getDetalleBuzonLocalHome() 
      {
        UtilidadesLog.info("MONContactosBean.getDetalleBuzonLocalHome(): Entrada");                                                      
        UtilidadesLog.info("MONContactosBean.getDetalleBuzonLocalHome(): Salida");                    
        return  new  DetalleBuzonLocalHome();
            
      }

}