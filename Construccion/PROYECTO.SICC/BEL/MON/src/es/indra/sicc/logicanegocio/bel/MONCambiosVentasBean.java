package es.indra.sicc.logicanegocio.bel;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.comunapplet.ConstantesApplet;
import es.indra.sicc.dtos.bel.DTOCambiosVentas;
import es.indra.sicc.dtos.bel.DTOPosicionCambioVenta;
import es.indra.sicc.entidades.bel.ParametrosBelcenterLocal;
import es.indra.sicc.entidades.bel.ParametrosBelcenterLocalHome;
import es.indra.sicc.logicanegocio.ped.applet.MONRegistroOnline;
import es.indra.sicc.logicanegocio.ped.applet.MONRegistroOnlineHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.NamingException;
import javax.naming.InitialContext;
import es.indra.sicc.dtos.bel.DTOApplet;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONCambiosVentasBean implements SessionBean 
{    
    private SessionContext _ctx;    
    private Integer _numeroMaxProductos;
    private BigDecimal _montoMaxDiferencia;
    private BigDecimal _montoDevuelve;
    private Boolean _simulacion;
    private DTOSalida _posicionesSimulacion;    
    private String userName = null;
    
    private Long oidIdioma;
    
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
        _ctx=ctx;
    }
  
    /**
     * @throws MareException
     * @return DTOSalida
     * @param DTOCambiosVentas
     * @autor jquiroga
     * @documentation
        // Obtiene parámetros de Belcenter 
        parametrosBelcenter = ParametrosBelcenter.findByUK(DTOE.oidPais, DTOE.oidSubacceso) 
        numeroMaxProductos = parametrosBelcenter.numeroMaximoProductos 
        montoMaxDiferencia = parametrosBelcenter.montoMaximoDiferencia 
        simulacion = DTOE.simulacion 
        posicionesSimulacion == null 
        
        // Lectura de las solicitudes 
        DTOSalida = IPedidosSolicitud.buscarSolicitudesCambiosVentas(DTOE) 
        
        // Se procesan las solicitudes 
        procesarSolicitudes(DTOSalida.resultado) 
        
        Devuelve posicionesSimulacion
     */
    public DTOSalida cambiosVentas(DTOCambiosVentas dtoe) throws MareException{
      UtilidadesLog.info("MONCambiosVentasBean.cambiosVentas(DTOCambiosVentas dtoe):Entrada");
      ParametrosBelcenterLocal parametrosBelcenterLocal=null;
      ParametrosBelcenterLocalHome parametrosBelcenterLocalHome=null;
      MONRegistroOnlineHome monRegistroOnlineHome=null;
      MONRegistroOnline monRegistroOnline=null;
      DTOSalida dtoSalida=null;
      
      this.oidIdioma = dtoe.getOidIdioma();
      this.userName = dtoe.getUserName();
      try {
        // Obtiene parámetros de Belcenter
        parametrosBelcenterLocalHome=getParametrosBelcenterLocalHome();
        parametrosBelcenterLocal=parametrosBelcenterLocalHome.findByUK(dtoe.getOidPais(), dtoe.getOidSubacceso());
        
        _numeroMaxProductos=parametrosBelcenterLocal.getNumeroMaximoProductos();
        _montoMaxDiferencia=parametrosBelcenterLocal.getMontoMaximoDiferencia();
        _simulacion = dtoe.getSimulacion();
        _posicionesSimulacion=null;
        
        // Lectura de las solicitudes        
        monRegistroOnlineHome = (MONRegistroOnlineHome)UtilidadesEJB.getHome("MONRegistroOnline", MONRegistroOnlineHome.class);
        monRegistroOnline = monRegistroOnlineHome.create();
        dtoSalida = monRegistroOnline.buscarSolicitudesCambiosVentas(dtoe);

        // Se procesan las solicitudes
        procesarSolicitudes(dtoSalida.getResultado());
      } catch (NamingException nex) {
          UtilidadesLog.debug(nex);
          throw new MareException(nex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));      
      } catch (NoResultException fex) {        
          UtilidadesLog.debug(fex);
          throw new MareException(fex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));      
      } catch (PersistenceException cex) {
          UtilidadesLog.debug(cex);
          throw new MareException(cex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (RemoteException rex) {
          UtilidadesLog.debug(rex);
          throw new MareException(rex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (CreateException cex) {
          UtilidadesLog.debug(cex);
          throw new MareException(cex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (Exception ex) { //ERROR NO DOCUMENTADO
          UtilidadesLog.debug(ex);
          throw new MareException(ex);
      }
      
      if(_posicionesSimulacion == null) {
        _posicionesSimulacion = new DTOSalida();
      }
      if(_posicionesSimulacion.getResultado() == null) {
        _posicionesSimulacion.setResultado(new RecordSet());
      }
      UtilidadesLog.info("MONCambiosVentasBean.cambiosVentas(DTOCambiosVentas dtoe):Salida");
      return _posicionesSimulacion;
    }
  
    /**
     * @throws java.lang.Exception
     * @param solicitudes
     * @autor jquiroga
     * @documentation
        // Se procesan las solicitudes recibidas 
        // Se determina si cada solicitud es una nota de crédito, una venta sin aplicar nota de crédito o 
        // una venta con aplicación de nota de crédito 
        
        Recorre el RecordSet solicitudes utilizando el contador fila 
        { 
        oidSolicitud = solicitudes.getValueAt(fila, "OID") 
        
        Si solicitudes.getValueAt(fila, "TOTAL_PAGAR_LOCAL") <= 0 
        { 
        // Nota de crédito 
        procesarNotaCredito(oidSolicitud) 
        } 
        sino 
        { 
        // Nota de crédito parcial 
        procesarNotaCreditoParcial(oidSolicitud) 
        } 
        }      
     */
    private void procesarSolicitudes (RecordSet solicitudes) throws Exception{
      UtilidadesLog.info("MONCambiosVentasBean.procesarSolicitudes(RecordSet solicitudes):Entrada");
      Long oidSolicitud=null;
      if(solicitudes != null) {
        int solRowCount =solicitudes.getRowCount();
        
        for(int fila=0; fila<solRowCount; fila++) {
          oidSolicitud = bigDecimalToLong((BigDecimal)solicitudes.getValueAt(fila, "OID"));
          //pperanzola BELC300014639
          if( (solicitudes.getValueAt(fila, "TOTAL_PAGAR_LOCAL")==null || ((BigDecimal)solicitudes.getValueAt(fila, "TOTAL_PAGAR_LOCAL")).compareTo(new BigDecimal(0)) == -1)) {
            // Nota de crédito
            procesarNotaCredito(oidSolicitud);
          }
          else {
            // Nota de crédito parcial
            procesarNotaCreditoParcial(oidSolicitud);
          }
        }
      }
      
      UtilidadesLog.info("MONCambiosVentasBean.procesarSolicitudes(RecordSet solicitudes):Salida");
    }
    
    /**
    * @throws java.lang.Exception
    * @param solicitudes
    * @autor jquiroga
    * @documentation
        // Es una nota de crédito 
        montoDevuelve = 0 
        
        Crea un DTOOID con: 
        - oid = oidSolicitud 
        
        posiciones = IPedidosSolicitud.obtenerPosicionesCambioVenta(DTOOID) 
        
        posicionesSolicitud = crearPosiciones(posiciones) 
        
        // Actualizar solicitud 
        Si simulacion == False 
        { 
        // Todas las unidades serán de cambio 
        actualizarUnidadesCambioVenta(posicionesSolicitud, posicionesSolicitud) 
        } 
        sino 
        { 
        posicionesSimulacion = IPedidosSolicitud.simularCambiosVentas(DTOOID) 
        } 
    */
    
    private void procesarNotaCredito(Long oidSolicitud) throws Exception{
      UtilidadesLog.info("MONCambiosVentasBean.procesarNotaCredito(Long oidSolicitud):Entrada");
      
      DTOOID dtoOID=new DTOOID();
      DTOSalida posiciones=null;
      ArrayList posicionesSolicitud=null;
      
      try {
        // Es una nota de crédito 
        _montoDevuelve = new BigDecimal(0);
        
        dtoOID.setOidIdioma(this.oidIdioma);
        dtoOID.setOid(oidSolicitud);
        
        //Gpons inc. BELC3000022052 
        DAOServicioBel DAOServBel = new DAOServicioBel(this.userName);
        posiciones = new DTOSalida();
        posiciones.setResultado(DAOServBel.obtenerPosicionesCambioVenta(oidSolicitud));
        posicionesSolicitud = crearPosiciones(posiciones.getResultado());
        
        // Actualizar solicitud 
        if(Boolean.FALSE.equals(_simulacion)) { 
          // Todas las unidades serán de cambio 
          actualizarUnidadesCambioVenta(posicionesSolicitud, posicionesSolicitud);
        }
        else {
          _posicionesSimulacion = new DTOSalida();
          _posicionesSimulacion.setResultado(DAOServBel.simularCambiosVentas(dtoOID));
        }
      }
      catch (RemoteException rex) {
          UtilidadesLog.debug(rex);
          throw new MareException(rex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
      catch (CreateException cex) {
          UtilidadesLog.debug(cex);
          throw new MareException(cex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
      catch (Exception ex) { //ERROR NO DOCUMENTADO
          UtilidadesLog.debug(ex);
          throw new MareException(ex);
      }
      UtilidadesLog.info("MONCambiosVentasBean.procesarNotaCredito(Long oidSolicitud):Salida");
    }
    
    
    /**
    * @throws java.lang.Exception
    * @param oidSolicitud
    * @autor jquiroga
    * @documentation
        // Es una factura/boleta pagada parcialmente con una nota de crédito 
        
        Crea un DTOOID con: 
        - oid = oidSolicitud 
        
        // Calculamos el monto pagado con nota de crédito 
        monto = calcularMontoDevuelve(DTOOID) 
        
        Si monto == 0 OR monto == null 
        { 
        montoDevuelve = 0 
        
        posiciones = IPedidosSolicitud.obtenerPosicionesCambioVenta(DTOOID) 
        
        posicionesSolicitud = crearPosiciones(posiciones) 
        
        // Actualizar solicitud 
        Si simulacion == False 
        { 
        // Todas las unidades serán de venta 
        actualizarUnidadesCambioVenta(null, posicionesSolicitud) 
        } 
        sino 
        { 
        posicionesSimulacion = IPedidosSolicitud.simularCambiosVentas(DTOOID) 
        } 
        } 
        sino 
        { 
        unidadesVendidas = IPedidosSolicitud.obtenerNumeroUnidadesVendidas(DTOOID) 
        
        Si unidadesVendidas < numeroMaxProductos 
        { 
        //ALGORITMO ANALISIS COMBINATORIO
        aplicarAnalisisCombinatorio(DTOOID) 
        } 
        sino 
        { 
        //ALGORITMO MOCHILA
        aplicarAlgoritmoMochila(DTOOID) 
        } 
        }
    */
    private void procesarNotaCreditoParcial (Long oidSolicitud) throws Exception{
    
      UtilidadesLog.info("MONCambiosVentasBean.procesarNotaCreditoParcial(Long oidSolicitud):Entrada");
      
      MONRegistroOnlineHome monRegistroOnlineHome=null;
      MONRegistroOnline monRegistroOnline=null;

      DTOOID dtoOID=new DTOOID();
      BigDecimal monto=null;
      DTOSalida posiciones=null;
      ArrayList posicionesSolicitud=null;
      DTOOID unidadesVendidas=null;
      
      try {
        // Es una factura/boleta pagada parcialmente con una nota de crédito 
        dtoOID.setOidIdioma(this.oidIdioma);
        dtoOID.setOid(oidSolicitud);
        //dtoOID.setProperty(ConstantesApplet.USER_NAME, this.userName);
        DTOApplet dtoApplet = new DTOApplet();
        dtoApplet.setDto(dtoOID);
        dtoApplet.setUserName(this.userName);
        

        //Gpons inc. BELC3000022052 
        DAOServicioBel DAOServBel = new DAOServicioBel(this.userName);
         
        // Calculamos el monto pagado con nota de crédito
        monto=calcularMontoDevuelve(dtoOID);
        if(monto==null || monto.intValue()==0) {
          UtilidadesLog.debug("a");
          _montoDevuelve=new BigDecimal(0);
          
          posiciones = new DTOSalida();
          posiciones.setResultado(DAOServBel.obtenerPosicionesCambioVenta(oidSolicitud));
          posicionesSolicitud = crearPosiciones(posiciones.getResultado());
          
          // Actualizar solicitud
          if(Boolean.FALSE.equals(_simulacion)) { 
            UtilidadesLog.debug("entra por _simulacion == Boolean.FALSE");
            // Todas las unidades serán de venta 
            actualizarUnidadesCambioVenta(null, posicionesSolicitud);
          } 
          else { 
            UtilidadesLog.debug("entra por _simulacion == Boolean.TRUE");
            _posicionesSimulacion = new DTOSalida();
            _posicionesSimulacion.setResultado(DAOServBel.simularCambiosVentas(dtoOID));
          }    
        }
        else {
          UtilidadesLog.debug("a");
          monRegistroOnlineHome = (MONRegistroOnlineHome)UtilidadesEJB.getHome("MONRegistroOnline", MONRegistroOnlineHome.class);
          monRegistroOnline = monRegistroOnlineHome.create();

          unidadesVendidas = monRegistroOnline.obtenerNumeroUnidadesVendidas(dtoApplet);
          //pperanzola inc BELC300014644
          long uVendidasTmp = (unidadesVendidas.getOid() ==null ? 0 : unidadesVendidas.getOid().longValue());
          
          if(uVendidasTmp < _numeroMaxProductos.longValue()) {
            //ALGORITMO ANALISIS COMBINATORIO
            aplicarAnalisisCombinatorio(dtoOID);
          } 
          else { 
            //ALGORITMO MOCHILA
            aplicarAlgoritmoMochila(dtoOID);
          }         
        }
      }
      catch (RemoteException rex) {
          UtilidadesLog.debug(rex);
          throw new MareException(rex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
      catch (CreateException cex) {
          UtilidadesLog.debug(cex);
          throw new MareException(cex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
      catch (Exception ex) { //ERROR NO DOCUMENTADO
          UtilidadesLog.debug(ex);
          throw new MareException(ex);
      }
      UtilidadesLog.info("MONCambiosVentasBean.procesarNotaCreditoParcial(Long oidSolicitud):Salida");
    }
    
    /**
    * @throws java.lang.Exception
    * @param dtoe
    * @autor jquiroga
    * @documentation
        // Aplica el algoritmos de análisis combinatorio a la solicitud 
        
        posiciones = IPedidosSolicitud.obtenerPosicionesCambioVenta(DTOOID) 
        
        posicionesSolicitud = crearPosiciones(posiciones) 
        
        // Crea un objeto de tipo AnalisisCombinatorio 
        AnalisisCombinatorio analisisCombinatorio = new AnalisisCombinatorio(posicionesSolicitud, montoDevuelve, montoMaxDiferencia) 
        
        // Realiza una copia de las posiciones iniciales 
        analisisCombinatorio.pilaInicial = (ArrayList)analisisCombinatorio.posiciones.clone(); 
        
        // Realiza el análisis combinatorio de las posiciones 
        analisisCombinatorio.combinar(0, posicionesSolicitud.size()); 
        
        // Si no se ha cubierto el montoDevuelve, obtenemos el mínimo óptimo 
        if(analisisCombinatorio.pilaOptima.size() == 0) 
        { 
        analisisCombinatorio.obtenerMinimoOptimo(); 
        } 
        
        // Actualizar solicitud 
        Si simulacion == False 
        { 
        actualizarUnidadesCambioVenta(analisisCombinatorio.pilaOptima, posicionesSolicitud) 
        } 
        sino 
        {
        posicionesSimulacion = IPedidosSolicitud.simularCambiosVentas(DTOOID) 
        }
    */
    private void aplicarAnalisisCombinatorio (DTOOID dtoOId) throws Exception{
      // Aplica el algoritmos de análisis combinatorio a la solicitud
      UtilidadesLog.info("MONCambiosVentasBean.aplicarAnalisisCombinatorio(DTOOID dtoOId):Entrada");
      MONRegistroOnlineHome monRegistroOnlineHome=null;
      MONRegistroOnline monRegistroOnline=null;
      DTOSalida posiciones=null;
      ArrayList posicionesSolicitud=null;
      AnalisisCombinatorio analisisCombinatorio=null;
      
      try
      {        
        monRegistroOnlineHome = (MONRegistroOnlineHome)UtilidadesEJB.getHome("MONRegistroOnline", MONRegistroOnlineHome.class);
        monRegistroOnline = monRegistroOnlineHome.create();
        DTOApplet dtoApplet = new DTOApplet();
        dtoApplet.setDto(dtoOId);
        dtoApplet.setUserName(this.userName);
        // Aplica el algoritmos de análisis combinatorio a la solicitud
        posiciones=monRegistroOnline.obtenerPosicionesCambioVenta(dtoApplet);        
        posicionesSolicitud = crearPosiciones(posiciones.getResultado());

        // Crea un objeto de tipo AnalisisCombinatorio 
        analisisCombinatorio = new AnalisisCombinatorio(posicionesSolicitud, _montoDevuelve, _montoMaxDiferencia);
        
        // Realiza una copia de las posiciones iniciales
        analisisCombinatorio.setPilaInicial((ArrayList)analisisCombinatorio.getPosicionesSolicitud().clone()); 
        
        // Realiza el análisis combinatorio de las posiciones 
        analisisCombinatorio.combinar(0, posicionesSolicitud.size());         
        
        // Si no se ha cubierto el montoDevuelve, obtenemos el mínimo óptimo 
        if(analisisCombinatorio.getPilaOptima().size() == 0) {
          analisisCombinatorio.obtenerMinimoOptimo();
        }
        
        // Actualizar solicitud 
        if(_simulacion == Boolean.FALSE) {
          actualizarUnidadesCambioVenta(analisisCombinatorio.getPilaOptima(), posicionesSolicitud);
        } 
        else {  
          _posicionesSimulacion = monRegistroOnline.simularCambiosVentas(dtoApplet);
        }        
      }
      catch (RemoteException rex) {
          UtilidadesLog.debug(rex);
          throw new MareException(rex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
      catch (CreateException cex) {
          UtilidadesLog.debug(cex);
          throw new MareException(cex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
      catch (Exception ex) { //ERROR NO DOCUMENTADO
          UtilidadesLog.debug(ex);
          throw new MareException(ex);
      }    
      UtilidadesLog.info("MONCambiosVentasBean.aplicarAnalisisCombinatorio(DTOOID dtoOId):Salida");
    }
    
    /**
    * @throws java.lang.Exception
    * @return ArrayList
    * @param solicitudes
    * @autor jquiroga
    * @documentation
        Crea un ArrayList posicionesSolicitud 
        
        Recorre el RecordSet posiciones utilizando el contador fila 
        { 
        unidades = posiciones.getValueAt(fila, "UNIDADES_ATENDIDAS") 
        
        // Crea un DTOPosicionCambioVenta por cada unidad de la posicion de la solicitud 
        for(i=0; i<unidades; i++) 
        { 
        DTOPosicionCambioVenta = crearDTOPosicionCambioVenta(posiciones, fila, (i+1)) 
        posicionesSolicitud.add(DTOPosicionCambioVenta) 
        } 
        } 
        
        Devuelve posicionesSolicitud
    */
    private ArrayList crearPosiciones (RecordSet solicitudes) throws Exception{
      UtilidadesLog.info("MONCambiosVentasBean.crearPosiciones(RecordSet solicitudes):Entrada");
    
      ArrayList posicionesSolicitud=new ArrayList();
      BigDecimal unidades=null;
      DTOPosicionCambioVenta dtoPosicionCambioVenta=null;
      int solRowCount=solicitudes.getRowCount();
      
      for(int fila=0; fila<solRowCount; fila++) {
        unidades = objectToBigDecimal(solicitudes.getValueAt(fila, "UNIDADES_ATENDIDAS"));
      
        // Crea un DTOPosicionCambioVenta por cada unidad de la posicion de la solicitud
        if(unidades!=null) {
          int uniIntValue = unidades.intValue();
          for(int i=0; i<uniIntValue; i++) {
          
            UtilidadesLog.debug("_posicionesSimulacion: " + _posicionesSimulacion);

            //14/03/2005-mmaidana: validacion de nulo
            if(_posicionesSimulacion != null){
              dtoPosicionCambioVenta = crearDTOPosicionCambioVenta(solicitudes, fila, (i+1));
              posicionesSolicitud.add(dtoPosicionCambioVenta);
            }
          }
        }
      }
      UtilidadesLog.info("MONCambiosVentasBean.crearPosiciones(RecordSet solicitudes):Salida");
      return posicionesSolicitud;
    }
    
    /**
    * @throws java.lang.Exception
    * @return es.indra.sicc.dtos.bel.DTOPosicionCambioVenta
    * @param unidad
    * @param fila
    * @param posiciones
    * @autor jquiroga
    * @documentation
        Crea un DTOPosicionCambioVenta con: 
        - oid = posiciones.getValueAt(fila, "OID") 
        - oidProducto = posiciones.getValueAt(fila, "OID_PRODUCTO") 
        - codigoProducto = posiciones.getValueAt(fila, "COD_PRODUCTO") 
        - codigoVenta = posiciones.getValueAt(fila, "CODIGO_VENTA") 
        - numeroPosicion = posiciones.getValueAt(fila, "NUMERO_POSICION") 
        - unidadesAtendidas = 1 
        - precioFacturaUnitarioLocal = posiciones.getValueAt(fila, "PRECIO_UNITARIO") 
        - unidadesCambio = posiciones.getValueAt(fila, "UNIDADES_CAMBIO") 
        - unidadesVenta = posiciones.getValueAt(fila, "UNIDADES_VENTA") 
        - numeroUnidad = unidad 
        
        Devuelve DTOPosicionCambioVenta
    */
    private DTOPosicionCambioVenta crearDTOPosicionCambioVenta (RecordSet posiciones, int fila, int unidad) throws Exception{
    
      UtilidadesLog.info("MONCambiosVentasBean.crearDTOPosicionCambioVenta(RecordSet posiciones, int fila, int unidad):Entrada");
    
      UtilidadesLog.debug("-----------------------");
      UtilidadesLog.debug(posiciones.getColumnIdentifiers());
      UtilidadesLog.debug(posiciones);
      UtilidadesLog.debug("-----------------------");
    
      DTOPosicionCambioVenta dtoPosicionCambioVenta=new DTOPosicionCambioVenta();

      if(posiciones != null && !posiciones.esVacio() && posiciones.getValueAt(fila, "OID")!=null){
        dtoPosicionCambioVenta.setOid(objectToLong(posiciones.getValueAt(fila, "OID")));
      }
      
      if(posiciones != null && !posiciones.esVacio() && posiciones.getValueAt(fila, "OID_PRODUCTO")!=null){
        dtoPosicionCambioVenta.setOidProducto(objectToLong(posiciones.getValueAt(fila, "OID_PRODUCTO")));
      }
      
      if(posiciones != null && !posiciones.esVacio() && posiciones.getValueAt(fila, "COD_PRODUCTO")!=null){
        dtoPosicionCambioVenta.setCodigoProducto(objectToString(posiciones.getValueAt(fila, "COD_PRODUCTO")));
      }
      
      if(posiciones != null && !posiciones.esVacio() && posiciones.getValueAt(fila, "CODIGO_VENTA")!=null){
        dtoPosicionCambioVenta.setCodigoVenta(objectToString(posiciones.getValueAt(fila, "CODIGO_VENTA")));
      }
      
      if(posiciones != null && !posiciones.esVacio() && posiciones.getValueAt(fila, "NUMERO_POSICION")!=null){
        dtoPosicionCambioVenta.setNumeroPosicion(objectToLong(posiciones.getValueAt(fila, "NUMERO_POSICION")));
      }
      
      dtoPosicionCambioVenta.setUnidadesAtendidas(new Long(1));
      
      if(posiciones != null && !posiciones.esVacio() && posiciones.getValueAt(fila, "PRECIO_UNITARIO")!=null){
        dtoPosicionCambioVenta.setPrecioFacturaUnitarioLocal(objectToBigDecimal(posiciones.getValueAt(fila, "PRECIO_UNITARIO")));
      }
      
      if(posiciones != null && !posiciones.esVacio() && posiciones.getValueAt(fila, "UNIDADES_CAMBIO")!=null){
        dtoPosicionCambioVenta.setUnidadesCambio(objectToLong(posiciones.getValueAt(fila, "UNIDADES_CAMBIO")));
      }
      
      if(posiciones != null && !posiciones.esVacio() && posiciones.getValueAt(fila, "UNIDADES_VENTA")!=null){
        dtoPosicionCambioVenta.setUnidadesVenta(objectToLong(posiciones.getValueAt(fila, "UNIDADES_VENTA")));
      }
      
      dtoPosicionCambioVenta.setNumeroUnidad(new Integer(unidad));
      UtilidadesLog.info("MONCambiosVentasBean.crearDTOPosicionCambioVenta(RecordSet posiciones, int fila, int unidad):Salida");
      return dtoPosicionCambioVenta;
    }
    
    /**
    * @throws java.lang.Exception
    * @param posicionesSolicitud
    * @param posicionesCambio
    * @autor jquiroga
    * @documentation
        // Recorre el ArrayList de posicionesSolicitud y busca sus elementos en el ArrayList con las posiciones seleccionadas para el cambio. Por cada coincidencia, añadimos una unidad de cambio a la posición. En caso contrario, añadimos una unidad de venta.         
        // Comprueba si el ArrayList posicionesCambio está vacio 
        Si posicionesCambio == null OR posicionesCambio.size() == 0 
        { 
        // En ese caso todas las unidades son de venta 
        Recorrer el ArrayList posicionesSolicitud utilizando el contador posicion 
        { 
        DTOPosicionCambioVenta = posicionesSolicitud.get(posicion) 
        
        DTOPosicionCambioVenta.unidadesCambio = 0 
        DTOPosicionCambioVenta.unidadesVenta = 1 
        
        // Actualiza en BD las unidades cambio/venta actualizadas 
        IPedidosSolicitud.actualizarPosicionesCambioVenta(DTOPosicionCambioVenta) 
        
        // Actualizo la posición en el ArrayList posicionesSolicitud 
        posicionesSolicitud.set(posicion, DTOPosicionCambioVenta) 
        } 
        } 
        sino // Hay al menos una posición con unidad de cambio 
        { 
        Recorrer el ArrayList posicionesSolicitud utilizando el contador posicion 
        { 
        DTOPosicionCambioVenta = posicionesSolicitud.get(posicion) 
        
        // Busca la posición en el ArrayList posicionesCambio 
        Recorrer el ArrayList posicionesCambio utilizando el contador posicionCambio 
        { 
        DTOPosicionCambioVenta2 = posicionescambio.get(posicionCambio) 
        Si (DTOPosicionCambioVenta.oid == DTOPosicionCambioVenta2.oid) AND (DTOPosicionCambioVenta.numeroUnidad == DTOPosicionCambioVenta2.numeroUnidad) 
        { 
        // Es una posicion de cambio 
        DTOPosicionCambioVenta.unidadesCambio = 1 
        DTOPosicionCambioVenta.unidadesVenta = 0 
        } 
        sino 
        { 
        // Es una posicion de venta 
        DTOPosicionCambioVenta.unidadesCambio = 0 
        DTOPosicionCambioVenta.unidadesVenta = 1 
        } 
        
        // Actualiza en BD las unidades cambio/venta actualizadas 
        IPedidosSolicitud.actualizarPosicionesCambioVenta(DTOPosicionCambioVenta) 
        
        // Actualizo la posición en el ArrayList posicionesSolicitud 
        posicionesSolicitud.set(posicion, DTOPosicionCambioVenta) 
        } 
        }
    */
    private void actualizarUnidadesCambioVenta (ArrayList posicionesCambio, ArrayList posicionesSolicitud) throws Exception{
    
        UtilidadesLog.info("MONCambiosVentasBean.actualizarUnidadesCambioVenta(ArrayList posicionesCambio, ArrayList posicionesSolicitud):Entrada");
    
        // Recorre el ArrayList de posicionesSolicitud y busca sus elementos en el ArrayList
        // con las posiciones seleccionadas para el cambio. Por cada coincidencia, añadimos una
        // unidad de cambio a la posición. En caso contrario, añadimos una unidad de venta.         
        MONRegistroOnlineHome monRegistroOnlineHome=null;
        MONRegistroOnline monRegistroOnline=null;
        DTOPosicionCambioVenta dtoPosicionCambioVenta=null;
        DTOPosicionCambioVenta dtoPosicionCambioVenta2=null;
        int posSolSize;
        int posCambioSize;
        
        try {
          monRegistroOnlineHome = (MONRegistroOnlineHome)UtilidadesEJB.getHome("MONRegistroOnline", MONRegistroOnlineHome.class);
          monRegistroOnline = monRegistroOnlineHome.create();
          
          // Comprueba si el ArrayList posicionesCambio está vacio 
          if(posicionesCambio == null || posicionesCambio.size() == 0) { 
            // En ese caso todas las unidades son de venta 
            posSolSize = posicionesSolicitud.size();
            for(int posicion=0; posicion<posSolSize; posicion++) { 
              dtoPosicionCambioVenta = (DTOPosicionCambioVenta)posicionesSolicitud.get(posicion); 
              dtoPosicionCambioVenta.setUnidadesCambio(new Long(0));
              dtoPosicionCambioVenta.setUnidadesVenta(new Long(1));
              dtoPosicionCambioVenta.setUserName(this.userName);
              
              // Actualiza en BD las unidades cambio/venta actualizadas 
              monRegistroOnline.actualizarPosicionCambioVenta(dtoPosicionCambioVenta); 
          
              // Actualizo la posición en el ArrayList posicionesSolicitud 
              posicionesSolicitud.set(posicion, dtoPosicionCambioVenta);
            } 
          } 
          else {
            // Hay al menos una posición con unidad de cambio 
            posSolSize = posicionesSolicitud.size();
            for(int posicion=0; posicion<posSolSize; posicion++) {
              dtoPosicionCambioVenta = (DTOPosicionCambioVenta)posicionesSolicitud.get(posicion);
          
              // Busca la posición en el ArrayList posicionesCambio 
              posCambioSize = posicionesCambio.size();
              for(int posicionCambio=0; posicionCambio<posCambioSize; posicionCambio++) { 
                dtoPosicionCambioVenta2 = (DTOPosicionCambioVenta)posicionesCambio.get(posicionCambio);
                if (dtoPosicionCambioVenta.getOid().equals(dtoPosicionCambioVenta2.getOid()) && dtoPosicionCambioVenta.getNumeroUnidad().equals(dtoPosicionCambioVenta2.getNumeroUnidad())) { 
                  // Es una posicion de cambio 
                  dtoPosicionCambioVenta.setUnidadesCambio(new Long(1));
                  dtoPosicionCambioVenta.setUnidadesVenta(new Long(0));
                } 
                else {
                  // Es una posicion de venta 
                  dtoPosicionCambioVenta.setUnidadesCambio(new Long(0)); 
                  dtoPosicionCambioVenta.setUnidadesVenta(new Long(1)); 
                }
                
                dtoPosicionCambioVenta.setUserName(this.userName);
                
                // Actualiza en BD las unidades cambio/venta actualizadas 
                monRegistroOnline.actualizarPosicionCambioVenta(dtoPosicionCambioVenta);
          
                // Actualizo la posición en el ArrayList posicionesSolicitud 
                posicionesSolicitud.set(posicion, dtoPosicionCambioVenta); 
              } /* END FOR 2*/
            } /* END FOR 1*/
          } /* END ELSE */           
        } /* END TRY */
        catch (RemoteException rex) {
          UtilidadesLog.debug(rex);
          throw new MareException(rex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        catch (CreateException cex) {
          UtilidadesLog.debug(cex);
          throw new MareException(cex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        catch (Exception ex) { //ERROR NO DOCUMENTADO
          UtilidadesLog.debug(ex);
          throw new MareException(ex);
        }
        
        UtilidadesLog.info("MONCambiosVentasBean.actualizarUnidadesCambioVenta(ArrayList posicionesCambio, ArrayList posicionesSolicitud):Salida");
    }
    
    /** 
    * @throws java.lang.Exception
    * @param DTOOID
    * @autor jquiroga
    * @documentation
        // Aplica el algoritmos de análisis combinatorio a la solicitud        
        posiciones = IPedidosSolicitud.obtenerPosicionesCambioVenta(DTOOID) 
        
        posicionesSolicitud = crearPosiciones(posiciones) 
        
        // Crea un objeto de tipo Mochila 
        Mochila mochila = new Mochila(posicionesSolicitud, montoDevuelve, montoMaxDiferencia) 
        
        // Realiza una copia de las posiciones iniciales 
        mochila.pilaInicial = (ArrayList)mochila.posiciones.clone() 
        
        // Aplica el algoritmo de la mochila 
        if(mochila.llenar() == false) 
        { 
        mochila.obtenerMinimoOptimo() 
        } 
        
        // Actualizar solicitud 
        Si simulacion == False 
        { 
        actualizarUnidadesCambioVenta(mochila.pilaOptima, posicionesSolicitud) 
        } 
        sino 
        { 
        posicionesSimulacion = IPedidosSolicitud.simularCambiosVentas(DTOOID) 
        }
    */
    private void aplicarAlgoritmoMochila (DTOOID dtoOId) throws Exception{
      // Aplica el algoritmos de análisis combinatorio a la solicitud
      UtilidadesLog.info("MONCambiosVentasBean.aplicarAlgoritmoMochila(DTOOID dtoOId):Entrada");
      MONRegistroOnlineHome monRegistroOnlineHome=null;
      MONRegistroOnline monRegistroOnline=null;
      DTOSalida posiciones=null;
      ArrayList posicionesSolicitud=null;
      Mochila mochila=null;
    
      try {
        monRegistroOnlineHome = (MONRegistroOnlineHome)UtilidadesEJB.getHome("MONRegistroOnline", MONRegistroOnlineHome.class);
        monRegistroOnline = monRegistroOnlineHome.create();
        
        //dtoOId.setProperty(ConstantesApplet.USER_NAME, this.userName);
        DTOApplet dtoApplet = new DTOApplet();
        dtoApplet.setDto(dtoOId);
        dtoApplet.setUserName(this.userName);
        posiciones = monRegistroOnline.obtenerPosicionesCambioVenta(dtoApplet);
        posicionesSolicitud = crearPosiciones(posiciones.getResultado());
        
        // Crea un objeto de tipo Mochila
        mochila = new Mochila(posicionesSolicitud, _montoDevuelve, _montoMaxDiferencia);
    
        // Realiza una copia de las posiciones iniciales
        mochila.setPilaInicial((ArrayList)mochila.getPosicionesSolicitud().clone());
        
        // Aplica el algoritmo de la mochila 
        if(!mochila.llenar()) { 
          mochila.obtenerMinimoOptimo();
        }
        
        // Actualizar solicitud
        if(_simulacion == Boolean.FALSE) {
          actualizarUnidadesCambioVenta(mochila.getPilaOptima(), posicionesSolicitud);
        }
        else { 
          _posicionesSimulacion = monRegistroOnline.simularCambiosVentas(dtoApplet);
        }
      }
      catch (RemoteException rex) {
          UtilidadesLog.debug(rex);
          throw new MareException(rex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
      catch (CreateException cex) {
          UtilidadesLog.debug(cex);
          throw new MareException(cex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
      catch (Exception ex) { //ERROR NO DOCUMENTADO
          UtilidadesLog.debug(ex);
          throw new MareException(ex);
      }
      UtilidadesLog.info("MONCambiosVentasBean.aplicarAlgoritmoMochila(DTOOID dtoOId):Salida");
    }
    
    /**
    * @throws java.lang.Exception
    * @return BigDecimal
    * @param DTOOID
    * @autor jquiroga
    * @documentation
        monto = Llamar al método IPedidosSolicitud.calcularMontoDevuelve(DTOOID) 
        
        Devuelve monto
    */
    private BigDecimal calcularMontoDevuelve (DTOOID dtoOId) throws Exception{
      UtilidadesLog.info("MONCambiosVentasBean.calcularMontoDevuelve(DTOOID dtoOId):Entrada");    
      MONRegistroOnlineHome monRegistroOnlineHome=null;
      MONRegistroOnline monRegistroOnline=null;
      
      try
      {
        monRegistroOnlineHome = (MONRegistroOnlineHome)UtilidadesEJB.getHome("MONRegistroOnline", MONRegistroOnlineHome.class);
        monRegistroOnline = monRegistroOnlineHome.create();
        //dtoOId.setProperty(ConstantesApplet.USER_NAME, this.userName);
        DTOApplet dtoApplet = new DTOApplet();
        dtoApplet.setDto(dtoOId);
        dtoApplet.setUserName(this.userName);
        _montoDevuelve=monRegistroOnline.calcularMontoDevuelve(dtoApplet);
      }
      catch (RemoteException rex) {
          UtilidadesLog.debug(rex);
          throw new MareException(rex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
      catch (CreateException cex) {
          UtilidadesLog.debug(cex);
          throw new MareException(cex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
      catch (Exception ex) { //ERROR NO DOCUMENTADO
          UtilidadesLog.debug(ex);
          throw new MareException(ex);
      }
      UtilidadesLog.info("MONCambiosVentasBean.calcularMontoDevuelve(DTOOID dtoOId):Salida");
      return _montoDevuelve;
    }
    
    private Long bigDecimalToLong(BigDecimal b){
        if (b == null)
          return null;
        return new Long(b.toString());
    }    
    private Long integerToLong(Integer b){
        if (b == null)
          return null;
        return new Long(b.intValue());
    }    
    private Long objectToLong(Object obj) {
      if (obj != null) {
        Long result = new Long(((BigDecimal)obj).longValue());
        return result;
      } else {
        return null;
      }
    }  
    private Integer objectToInteger(Object obj) {
      if (obj != null) {
        Integer result = new Integer((String)obj);
        return result;
      } else {
        return null;
      }
    }  
    private BigDecimal objectToBigDecimal(Object obj) {
      if (obj != null) {
        return (BigDecimal)obj;
      } else {
        return null;
      }
    }     
    private String objectToString(Object obj) {
      if (obj != null) {
        return (String)obj;
      } else {
        return null;
      }
    }

    private ParametrosBelcenterLocalHome getParametrosBelcenterLocalHome() {
      return new ParametrosBelcenterLocalHome();
    }
  
}