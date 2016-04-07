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
package es.indra.sicc.logicanegocio.rec;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.dtos.pre.DTOEValidarCodigoVenta;
import es.indra.sicc.dtos.pre.DTOSValidarCodigoVenta;
import es.indra.sicc.dtos.rec.DTOAtencionReclamoREC;
import es.indra.sicc.dtos.rec.DTOBuscarGeneracion;
import es.indra.sicc.dtos.rec.DTODatosPreRec;
import es.indra.sicc.dtos.rec.DTODetallePreRec;
import es.indra.sicc.dtos.rec.DTOGuardarGeneracion;
import es.indra.sicc.dtos.rec.DTOLista;
import es.indra.sicc.dtos.rec.DTONumDocFecha;
import es.indra.sicc.entidades.pre.DetalleOfertaLocalHome;
import es.indra.sicc.entidades.pre.DetalleOfertaLocal;
import es.indra.sicc.entidades.rec.CabeceraGeneracionMasivaLocal;
import es.indra.sicc.entidades.rec.CabeceraReclamoLocal;
import es.indra.sicc.entidades.rec.DetalleGeneracionMasivaLocal;
import es.indra.sicc.entidades.rec.LineasOperacionReclamoLocal;
import es.indra.sicc.entidades.rec.OperacionReclamoLocal;
import es.indra.sicc.entidades.rec.OperacionesLocal;
import es.indra.sicc.entidades.rec.OperacionesLocalHome;
import es.indra.sicc.entidades.rec.TiposOperacionLocal;
import es.indra.sicc.entidades.rec.TiposOperacionLocalHome;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.ped.MONProcesosPED;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMF;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMFHome;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;




import java.math.BigDecimal;
import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.entidades.rec.CabeceraGeneracionMasivaLocalHome;
import es.indra.sicc.entidades.rec.DetalleGeneracionMasivaLocalHome;
import es.indra.sicc.dtos.rec.DTOBuscarCambiosPrecios;
import es.indra.sicc.dtos.rec.DTOCargaListas;
import es.indra.sicc.dtos.rec.DTORecuperarCabeGen;
import es.indra.sicc.entidades.rec.CabeceraReclamoLocalHome;
import es.indra.sicc.entidades.rec.OperacionReclamoLocalHome;
import es.indra.sicc.entidades.rec.LineasOperacionReclamoLocalHome;
import es.indra.sicc.dtos.rec.DTOGuardarModificacion;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;

import javax.persistence.PersistenceException;

import javax.rmi.PortableRemoteObject;

public class MONCambiosDePreciosBean implements SessionBean 
{
    private SessionContext ctx;
    
    public void ejbCreate(){
    }

    public void ejbActivate(){
    }

    public void ejbPassivate(){
    }

    public void ejbRemove(){
    }

    public void setSessionContext(SessionContext ctx){
        this.ctx = ctx;
    }

    public DTONumDocFecha obtenerNumeroDocumento(DTOBelcorp dto) throws MareException{
        UtilidadesLog.info("MONCambiosDePrecios.obtenerNumeroDocumento(DTOBelcorp):Entrada");
        DTONumeroSolicitud dtoNum = new DTONumeroSolicitud();
        dtoNum.setOidPais(dto.getOidPais());
        dtoNum.setOperacion(ConstantesBEL.COD_REC052 );
        MONProcesosPED mon =  this.getMONProcesosPED();
        String numDocumento = null;
        try {
        numDocumento = mon.generaNumeroDocumento(dtoNum);
        }catch(RemoteException e){
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
        }
        DTONumDocFecha resultado = new DTONumDocFecha();
        resultado.setNumDocumento(numDocumento);
        resultado.setFechaGenerar(new Date(System.currentTimeMillis()));
        UtilidadesLog.info("MONCambiosDePrecios.obtenerNumeroDocumento(DTOBelcorp):Salida");
        return resultado;
    }
    
    private MONProcesosPED getMONProcesosPED() throws MareException {
        // Se obtiene el interfaz home
        MONProcesosPEDHome home = (MONProcesosPEDHome)UtilidadesEJB.getHome(
            "MONProcesosPED", MONProcesosPEDHome.class);
            
        // Se obtiene el interfaz remoto
        MONProcesosPED ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        return ejb;
    }

    private MONMantenimientoMF getMONMantenimientoMF() throws MareException {
        // Se obtiene el interfaz home
        
        MONMantenimientoMFHome home = (MONMantenimientoMFHome)UtilidadesEJB.getHome(
            "MONMantenimientoMF", MONMantenimientoMFHome.class);
            
        // Se obtiene el interfaz remoto
        MONMantenimientoMF ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        
        return ejb;
    }


	// Incidencia BELC300015464 cerrada
	public DTODatosPreRec buscarGeneracion(DTOBuscarGeneracion dto) throws MareException {
    
   	UtilidadesLog.info("MONCambiosDePrecios.buscarGeneracion(DTOBuscarGeneracion):Entrada");
      
      UtilidadesLog.debug("******** DTOBuscarGeneracion de entrada: " + dto);
      
      DetalleOfertaLocal detalleOfertaLocal = null;
      DetalleOfertaLocal detalleOfertaGeneradaLocal = null;
      DetalleOfertaLocalHome detalleOfertaLocalHome = new DetalleOfertaLocalHome();
      BigDecimal precioCatalogoDestino = null;
    
		// Vamos a validar el codigo de venta y si es valido obtener la descripcion y el precio catálogo venta */ 
		// Creamos un DTO del tipo DTOValidarCodigoVenta con los siguientres atributos: 
		// - periodo = DTOE.oidPeriodo 
		// - acceso = DTOE.oidAcceso 
		// - subAcceso = DTOE.oidSubAcceso 
		// - codigoVenta = DTOE.codVenta 
      DTOEValidarCodigoVenta dtoValida = new  DTOEValidarCodigoVenta();
      dtoValida.setPeriodo(dto.getOidPeriodo());
      dtoValida.setAcceso(dto.getOidAcceso());
      dtoValida.setSubacceso(dto.getOidSubAcceso()); 
      dtoValida.setCodigoVenta(dto.getCodVenta()); 
      
      // DTOSvalidarCodigoVenta dtoCodVenta = IServiceMF.validarCodigoVenta(DTOValidarCodigoVenta) 
      DTOSValidarCodigoVenta dtoCodVenta = null;
      try {
         UtilidadesLog.debug("******** Validando primer codigo venta: " + dtoValida.getCodigoVenta());
         dtoCodVenta = this.getMONMantenimientoMF().validarCodigoVenta(dtoValida);
      } catch(RemoteException e) {
          ctx.setRollbackOnly();
         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         UtilidadesLog.error(e);
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
      }

      // if dtoCodVenta == null {
      if (dtoCodVenta == null) {
         // Mostrar error: REC-0005
         UtilidadesLog.debug("***************** Primer codigo de venta NO valido: " + dtoValida.getCodigoVenta());
         throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_REC, "", ErroresDeNegocio.REC_0005));     
      } else { //distinto de null 
         // DetalleOferta = findByPk(dtoCodVenta.oidDetalleOferta) de la entidad DetalleOferta (PRE) 

         UtilidadesLog.debug("---------------------  antes de hacer el findByPrimaryKey de DetalleOferta con el codigoVenta");
         UtilidadesLog.debug("--- dtoCodVenta.oidDetalleOferta:" + dtoCodVenta.getOidDetalleOferta());

         try {
            
            detalleOfertaLocal = detalleOfertaLocalHome.findByPrimaryKey(dtoCodVenta.getOidDetalleOferta());
         } catch(NoResultException e) {
             ctx.setRollbackOnly();
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
         }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   
		}      
      

		// Vamos a validar el codigo de venta generada y si es valido obtener la descripcion y el precio catálogo venta
		// Creamos un DTO del tipo DTOValidarCodigoVenta con los siguientres atributos: 
		// - periodo = DTOE.oidPeriodo 
		// - acceso = DTOE.oidAcceso 
		// - subAcceso = DTOE.oidSubAcceso 
		// - codigoVenta = DTOE.codVentaGenerada 
      dtoValida = new  DTOEValidarCodigoVenta();
      dtoValida.setPeriodo(dto.getOidPeriodo());
      dtoValida.setAcceso(dto.getOidAcceso());
      dtoValida.setSubacceso(dto.getOidSubAcceso()); 
      dtoValida.setCodigoVenta(dto.getCodVentaGenerar()); 

      // DTOSvalidarCodigoVenta dtoCodVentaGen = IServiceMF.validarCodigoVenta(DTOValidarCodigoVenta) 
      DTOSValidarCodigoVenta dtoCodVentaGen = null;
      try {
         UtilidadesLog.debug("******** Validando segundo codigo venta: " + dtoValida.getCodigoVenta());
         dtoCodVentaGen = this.getMONMantenimientoMF().validarCodigoVenta(dtoValida);
      } catch(RemoteException e) {
          ctx.setRollbackOnly();
         String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         UtilidadesLog.error(e);
         throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
      }

		//if dtoCodVentaGen == null { 
      if (dtoCodVentaGen == null) {
         // Mostrar error: REC-0005 
         UtilidadesLog.debug("***************** Segundo codigo de venta NO valido: " + dtoValida.getCodigoVenta());
         throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_REC, "", ErroresDeNegocio.REC_0005));
      } else { //distinto de null 
		   // DetalleOfertaGenerada = findByPk(dtoCodVentaGen.oidDetalleOferta) de la entidad DetalleOferta 

         UtilidadesLog.debug("---------------------  antes de hacer el findByPrimaryKey de DetalleOferta con el codigoVentaGenerada");
         UtilidadesLog.debug("--- dtoCodVentaGen.oidDetalleOferta:" + dtoCodVentaGen.getOidDetalleOferta());

         try {
            detalleOfertaGeneradaLocal = detalleOfertaLocalHome.findByPrimaryKey(dtoCodVentaGen.getOidDetalleOferta());
         } catch(NoResultException e) {
             ctx.setRollbackOnly();
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
         }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   
         
         // Asignamos a una variable BigDecimal precioCatalogoDestino = DetalleOfertaGenerada.precioCatalogo 
         precioCatalogoDestino = detalleOfertaGeneradaLocal.getPrecioCatalogo();
		}      
      
      // Vamos a ver cual es el atributo precio envía de la operaión que se ha elegido
      // DTOOid precEnvia = dao.recuperarPrecio(DTOE.oidOperacion) 
      DTOOID precEnvia = null;
      precEnvia = new DAOCambiosEnPrecios().recuperarPrecio(dto.getOidOperacion());
    
      // Creamos un DTODatosPreRec con los siguientes atributos y se retorna 
		// numGeneracion = DTOE.numGeneracion 
		// oidDetalleOfertaOrigen = DetalleOferta.oid 
		// codVentaOrigen = DTOE.codVenta 
		// descripcionOrigen = DetalleOferta.textoBreve 
		// precioCatalogoOrigen = DetalleOferta.precioCatalogo 
		// oidDetalleOfertaDestino = DetalleOfertaGenerada.oid 
      // codVentaDestino = DTOE.codVentaGenerada // Incidencia BELC300015464
      // descripcionDestino = DetalleOfertaGenerada.textoBreve // Incidencia BELC300015464
		// precioCatalogoDestino = precioCatalogoDestino //calculado anteriormente 
		// oidPrecioEnvia = precEnvia
      
      DTODatosPreRec dtoDatos = new DTODatosPreRec();
      dtoDatos.setNumGeneracion(dto.getNumGeneracion());
      if (detalleOfertaLocal != null) {
         dtoDatos.setOidDetalleOfertaOrigen(detalleOfertaLocal.getOid());
      }
      dtoDatos.setCodVentaOrigen(dto.getCodVenta()); 
      if (detalleOfertaLocal != null) {
         dtoDatos.setDescripcionOrigen(detalleOfertaLocal.getTextoBreve()); 
      }
      if (detalleOfertaLocal != null) {
         dtoDatos.setPrecioCatalogoOrigen(detalleOfertaLocal.getPrecioCatalogo()); 
      }
      if (detalleOfertaGeneradaLocal != null) {
         dtoDatos.setOidDetalleOfertaDestino(detalleOfertaGeneradaLocal.getOid());
      }
      // Incidencia BELC300015464
      dtoDatos.setCodVentaDestino(dto.getCodVentaGenerar()); 
      if (detalleOfertaGeneradaLocal != null) {
         dtoDatos.setDescripcionDestino(detalleOfertaGeneradaLocal.getTextoBreve());    
      }
      dtoDatos.setPrecioCatalogoDestino(precioCatalogoDestino); 
      dtoDatos.setOidPrecioEnvia(precEnvia.getOid()); 
      
      UtilidadesLog.info("MONCambiosDePrecios.buscarGeneracion(DTOBuscarGeneracion):Salida");
      return dtoDatos;
   }


    public DTOSalida obtenerDetalleGeneracion(DTODetallePreRec dtoe) throws MareException{
    
      UtilidadesLog.info("MONCambiosDePrecios.obtenerDetalleGeneracion(DTODetallePreRec):Entrada"); 
      
      UtilidadesLog.debug("----- DTODetallePreRec: " + dtoe);

      RecordSet lista = null;
      
      if (dtoe.getStringSolicitudes() != null) { 
         //Venimos de configurar paginado 
         //Convertimos los oids de las solicitudes a un arrayList. 
         //Esto se ha diseñado así porque no es posible utilizar arrayList con el subsistema de paginacion 
         ArrayList solicitudes = this.convertirString(dtoe.getStringSolicitudes());
         
         //Seteamos en el atributo arrayTipoSolicitud las solicitudes 
         dtoe.setArrayTipoSolicitud(solicitudes);
      } 
      
      // Vamos a realizar la busqueda
      lista = new DAOCambiosEnPrecios().recuperarRegistros(dtoe);
      BigDecimal precioCataOrigen = null;
      BigDecimal precioCatalDestino = null;
      BigDecimal descuentoOrigen = null;
      BigDecimal descuentoDestino = null;
      BigDecimal numeroUnidades = null;
      BigDecimal importeNetoDestino = null;
      BigDecimal importeNetoOrigen = null;
      BigDecimal importeNetoDiferencia = null;
      BigDecimal porcentajeDescuento = null;

      // Añadimos al RecordSet los precios que faltan
		// Recorremos cada fila del RecordSet Lista { 
      for (int i=0; i < lista.getRowCount(); i++) {

         // añadimos a la columna precioCatalogoDestino = precioCatalogoDestino //calculado anteriormente 
         lista.setValueAt(dtoe.getPreciocatalogoDestino(), i, lista.getColumnPosition("PRECIOCATALOGODESTINO"));

         // if (DTOE.oidPrecEnvia == ConstantesREC.PRECIO_ENVIA_FACTURA) { 
         if (dtoe.getOidPrecioEnvia().compareTo(ConstantesREC.PRECIO_ENVIA_FACTURA) == 0) { // ConstantesREC.PRECIO_ENVIA_FACTURA = 1
            // añadimos a la columna importeNetoDestino el valor de calcular la operación siguiente 
            // con los valores de las columnas indicadas del recordSet 
            // añadimos a la columna 
            // importeNetoDestino = (precioCatalogoDestino - descuentoOrigen) * numeroUnidades 
            if (lista.getValueAt(i, "DESCUENTOORIGEN") != null 
               && lista.getValueAt(i, "UNIDADES") != null 
               && lista.getValueAt(i, "PRECIOCATALOGODESTINO") != null
               && lista.getValueAt(i, "PRECIOCATALOGOORIGEN") !=null) 
            {
               precioCataOrigen = (BigDecimal)lista.getValueAt(i, "PRECIOCATALOGOORIGEN");
               precioCatalDestino = (BigDecimal)lista.getValueAt(i, "PRECIOCATALOGODESTINO");
               descuentoOrigen = (BigDecimal)lista.getValueAt(i, "DESCUENTOORIGEN");
               numeroUnidades = (BigDecimal)lista.getValueAt(i, "UNIDADES");
               
               porcentajeDescuento = descuentoOrigen.divide(precioCataOrigen,BigDecimal.ROUND_HALF_EVEN);
               descuentoDestino = porcentajeDescuento.multiply(precioCatalDestino);
               UtilidadesLog.debug("*** precioCatalDestino: " + precioCatalDestino);
               UtilidadesLog.debug("*** descuentoOrigen: " + descuentoOrigen);
               UtilidadesLog.debug("*** numeroUnidades: " + numeroUnidades);
               
               
               // Modificado por SICC20070465 - Rafael Romero - 05/10/2007
               //importeNetoDestino = (precioCatalDestino.add(descuentoOrigen.negate())).multiply(numeroUnidades);
               
               // Fin modificado SICC20070465
               
               importeNetoDestino = (precioCatalDestino.subtract(descuentoDestino)).multiply(numeroUnidades);
               
               UtilidadesLog.debug("*** importeNetoDestino obtenido: " + importeNetoDestino);
               
               lista.setValueAt(importeNetoDestino, i, lista.getColumnPosition("IMPORTENETODESTINO"));
            }
         }
   
         // If (DTOE.oidPrecEnvia == ConstantesREC.PRECIO_ENVIA_CATALOGO) { 
         if (dtoe.getOidPrecioEnvia().compareTo(ConstantesREC.PRECIO_ENVIA_CATALOGO) == 0) { // ConstantesREC.PRECIO_ENVIA_CATALOGO = 2
            // añadimos a la columna importeNetoDestino el valor de calcular la operación 
            // siguiente con los valores de las columnas indicadas del recordSet 
            // añadimos a la columna importeNetoDestino = precioCatalogoDestino * numeroUnidades 
            if (lista.getValueAt(i, "UNIDADES") != null
               && lista.getValueAt(i, "PRECIOCATALOGODESTINO") != null)
            {
              
               precioCatalDestino = (BigDecimal)lista.getValueAt(i, "PRECIOCATALOGODESTINO");
               numeroUnidades = (BigDecimal)lista.getValueAt(i, "UNIDADES");

               UtilidadesLog.debug("*** precioCatalDestino: " + precioCatalDestino);
               UtilidadesLog.debug("*** numeroUnidades: " + numeroUnidades);               
            
               importeNetoDestino = precioCatalDestino.multiply(numeroUnidades);
               
               UtilidadesLog.debug("*** importeNetoDestino obtenido: " + importeNetoDestino);
            
               lista.setValueAt(importeNetoDestino, i, lista.getColumnPosition("IMPORTENETODESTINO"));
            } 
         }
         
         // añadimos a la columna importeNetoDestino el valor de calcular la operación siguiente con los valores de las columnas indicadas del recordSet 
         // añadimos a la columna importeDiferencia = importeNetoDestino - importeNetoOrigen 
         if (lista.getValueAt(i, "IMPORTEORIGEN") != null 
            && lista.getValueAt(i, "IMPORTENETODESTINO") != null) 
         {
            importeNetoDestino = (BigDecimal)lista.getValueAt(i, "IMPORTENETODESTINO");
            importeNetoOrigen = (BigDecimal)lista.getValueAt(i, "IMPORTEORIGEN");
            
            UtilidadesLog.debug("*** importeNetoDestino: " + importeNetoDestino);
            UtilidadesLog.debug("*** importeNetoOrigen: " + importeNetoOrigen);
            
            importeNetoDiferencia = importeNetoDestino.add(importeNetoOrigen.negate());
            
            UtilidadesLog.debug("*** importeNetoDiferencia obtenido: " + importeNetoDiferencia);
            
            lista.setValueAt(importeNetoDiferencia, i, lista.getColumnPosition("IMPORTEDIFERENCIA"));
         }
        
		}

		// Creamos un DTOSalida con el atributo resultado = Lista y se devuelve. 
      UtilidadesLog.info("MONCambiosDePrecios.obtenerDetalleGeneracion(DTODetallePreRec):Salida"); 

      return new DTOSalida(lista);
   }
    

    public ArrayList convertirString(String solicitud) throws MareException {
        UtilidadesLog.info("MONCambiosDePrecios.convertirString(String):Entrada"); 
    
        StringTokenizer s = new StringTokenizer(solicitud);
        ArrayList resultado = new ArrayList();
        while (s.hasMoreTokens()) {
            String cadena = s.nextToken(",");
            if (cadena != null){
                resultado.add(new Long(cadena));
            }
        }
        UtilidadesLog.info("MONCambiosDePrecios.convertirString(String):Salida"); 
        return resultado;
    }

    // Incidencia BELC300014877 cerrada
    // Incidencia BELC300014965 cerrada
    public DTOOID guardarGeneracion(DTOGuardarGeneracion dto) throws MareException {
        
        UtilidadesLog.info("MONCambiosDePrecios.guardarGeneracion(DTOGuardarGeneracion):Entrada"); 
        
        UtilidadesLog.debug("*** DTOGuardarGeneracion: " + dto);
        
        //Vamos a guardar la generación que se ha de realizar posteriormente 
        Integer numGeneracion = new Integer(dto.getNumGeneracion()); 
        Long oidEstadoGeneracion = ConstantesREC.ESTADO_GENERACION_PROVISIONAL;
        String observaciones = dto.getObservaciones();
        Long oidPais = dto.getOidPais();
        Long oidAcceso = dto.getOidAcceso();
        Long oidSubAcceso = dto.getOidSubAcceso();
        Long oidVentaDestino = dto.getOidDetalleOfertaDestino();
        Long oidVentaOrigen = dto.getOidDetalleOfertaOrigen();
        Long tipoOperacion = dto.getOidTipoOperacion();

        CabeceraGeneracionMasivaLocalHome cabeceraGeneracionMasivaLocalHome = new CabeceraGeneracionMasivaLocalHome();
        CabeceraGeneracionMasivaLocal cabeceraGeneracionMasivaLocal = null;
        try {
            cabeceraGeneracionMasivaLocal = cabeceraGeneracionMasivaLocalHome.create(numGeneracion, oidPais, oidAcceso,tipoOperacion, oidVentaOrigen, oidVentaDestino);

            // venta origen y destino han pasado a ser obligatorios y se asignan en el create
            //cabeceraGeneracionMasivaLocal.setVentaDestino(oidVentaDestino);
            //cabeceraGeneracionMasivaLocal.setVentaOrigen(oidVentaOrigen);
            cabeceraGeneracionMasivaLocal.setObservaciones(observaciones);
            cabeceraGeneracionMasivaLocal.setNumeroGeneracion(numGeneracion);
            cabeceraGeneracionMasivaLocal.setEstado(oidEstadoGeneracion.toString());
            cabeceraGeneracionMasivaLocal.setPais(oidPais);
            cabeceraGeneracionMasivaLocal.setAcceso(oidAcceso);
            cabeceraGeneracionMasivaLocal.setSubacceso(oidSubAcceso);
            // BELC300019804
            if (dto.getFechaGeneracion() != null) {
                cabeceraGeneracionMasivaLocal.setFechaGeneracion(new java.sql.Date(dto.getFechaGeneracion().getTime())); 
            }
            cabeceraGeneracionMasivaLocalHome.merge(cabeceraGeneracionMasivaLocal);
        } catch(PersistenceException e) {
        
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS)); 
        }

         
        DTODetallePreRec dtoDetalle = new DTODetallePreRec();
        dtoDetalle.setOidPais(oidPais);
        dtoDetalle.setOidIdioma(dto.getOidIdioma());
        dtoDetalle.setOidPeriodo(dto.getOidPeriodo());
        dtoDetalle.setOidSubAcceso(oidSubAcceso);
        dtoDetalle.setArrayTipoSolicitud(dto.getArrayTipoSolicitud());
        dtoDetalle.setOidPrecioEnvia(dto.getOidPrecioEnvia());
        // se asignan los siguientes valores por incidencia BELC300019830, ya que se utilizan en la 
        // consulta de DAOCambiosEnPrecios.recuperarRegistros, al que se llama desde
        // MONCambiosDePrecios.obtenerDetalleGeneracion
        dtoDetalle.setCodigoVentaAnterior(dto.getCodVentaOrigen());
        dtoDetalle.setDetalleOfertaAnterior(dto.getOidDetalleOfertaOrigen());
        dtoDetalle.setPreciocatalogoDestino(dto.getPrecioCatalogoDestino());
        
                
        DTOSalida dtoS = this.obtenerDetalleGeneracion(dtoDetalle);
        RecordSet Lista = dtoS.getResultado(); 
        //tomamos el recordSet del objeto DTOSalida recuperado.         
        
        DetalleGeneracionMasivaLocalHome detalleGeneracionMasivaLocalHome = new DetalleGeneracionMasivaLocalHome();
        DetalleGeneracionMasivaLocal detalleGeneracionMasivaLocal =  null;
        
        Long oidCliente = null;
        Long oidSoliCabe  = null;
        Long oidTipoSolicitud = null;
        Long oidCabeceraGeneracionMasiva = null;
        Integer numeroUnidades = null;
        BigDecimal precioCatalogoOrigen = null;
        BigDecimal importeNetoOrigen = null;
        Long descuentoOrigen = null;
        BigDecimal precioCatalogoDestino = null;
        BigDecimal importeNetoDestino = null;
        BigDecimal importeDiferencia = null;
        Long indicativoSeleccion = null;
        
         for (int i=0;i<Lista.getRowCount();i++) {
         /*Tomamos la siguiente fila del RecordSet 
          Hacemos un create en la entidad DetalleGeneracionMasiva con los siguientes campos: */
            oidCabeceraGeneracionMasiva = cabeceraGeneracionMasivaLocal.getOid();
            /* Modificacion por ssantana, 25/05/2006 */       
            /*oidTipoSolicitud = new Long(((BigDecimal)Lista.getValueAt(i, "TSPA_OID_TIPO_SOLI_PAIS")).longValue());  //Valor de la columna oidTipoSolicitud de la fila procesada 
            oidSoliCabe = new Long(((BigDecimal)Lista.getValueAt(i, "OIDSOLICABE")).longValue());  //Valor de la columna oidSoliCabe de la fila procesada 
            oidCliente = new Long(((BigDecimal)Lista.getValueAt(i, "CLIE_OID_CLIE")).longValue());  //Valor de la columna oidCliente de la fila procesada */
            oidTipoSolicitud = Long.valueOf(Lista.getValueAt(i, "OIDTIPOSOLICITUD").toString());
            oidSoliCabe = Long.valueOf(Lista.getValueAt(i, "OIDSOLICABE").toString());
            oidCliente = Long.valueOf(Lista.getValueAt(i, "OIDCLIENTE").toString());
            
            /*if (Lista.getValueAt(i, "NUMEROUNIDADES") != null) {
               numeroUnidades = new Integer(((BigDecimal)Lista.getValueAt(i, "NUMEROUNIDADES")).intValue());  //Valor de la columna numeroUnidades de la fila procesada 
            }*/
            
            if (Lista.getValueAt(i, "UNIDADES") != null) {
               numeroUnidades = new Integer(((BigDecimal)Lista.getValueAt(i, "UNIDADES")).intValue());  //Valor de la columna numeroUnidades de la fila procesada 
            }
            
            if (Lista.getValueAt(i, "PRECIOCATALOGOORIGEN") != null) {
               precioCatalogoOrigen = ((BigDecimal)Lista.getValueAt(i, "PRECIOCATALOGOORIGEN"));  //Valor de la columna precioCatalogoOrigen de la fila procesada 
            }
            /*if (Lista.getValueAt(i, "IMPORTENETOORIGEN") != null) {
               importeNetoOrigen = (BigDecimal)Lista.getValueAt(i, "IMPORTENETOORIGEN");  //Valor de la columna importeNetoOrigen de la fila procesada 
            }*/
            if (Lista.getValueAt(i, "IMPORTEORIGEN") != null) {
               importeNetoOrigen = (BigDecimal)Lista.getValueAt(i, "IMPORTEORIGEN");  //Valor de la columna importeNetoOrigen de la fila procesada 
            }
            
            if (Lista.getValueAt(i, "DESCUENTOORIGEN") != null) {
               descuentoOrigen = new Long(((BigDecimal)Lista.getValueAt(i, "DESCUENTOORIGEN")).longValue());  //Valor de la columna descuentoOrigen de la fila procesada 
            }
            if (Lista.getValueAt(i, "PRECIOCATALOGODESTINO") != null) {
               precioCatalogoDestino = (BigDecimal)Lista.getValueAt(i, "PRECIOCATALOGODESTINO");  //Valor de la columna precioCatalogoDestino de la fila procesada 
            }
            if (Lista.getValueAt(i, "IMPORTENETODESTINO") != null) {
               importeNetoDestino = (BigDecimal)Lista.getValueAt(i, "IMPORTENETODESTINO");  //Valor de la columna importeNetoDestino de la fila procesada 
            }
            if (Lista.getValueAt(i, "IMPORTEDIFERENCIA") != null) {
               importeDiferencia = (BigDecimal)Lista.getValueAt(i, "IMPORTEDIFERENCIA");  //Valor de la columna importeDiferencia de la fila procesada 
            }
            /* Fin Modificacion por ssantana, 25/05/2006 */             
            indicativoSeleccion = new Long(1); //Se debe marcar este campo 
        
            UtilidadesLog.debug("---------------------  antes de hacer el create de DetalleGeneracionMasiva  i  " + i);
            UtilidadesLog.debug("--- oidCabeceraGeneracionMasiva: " + oidCabeceraGeneracionMasiva);
            UtilidadesLog.debug("--- oidSoliCabe: " + oidSoliCabe);
            UtilidadesLog.debug("--- oidCliente: " + oidCliente);
            UtilidadesLog.debug("--- oidTipoSolicitud: " + oidTipoSolicitud);
            
            try {                                   
               detalleGeneracionMasivaLocal = detalleGeneracionMasivaLocalHome.create(oidCabeceraGeneracionMasiva, oidSoliCabe, oidCliente, oidTipoSolicitud);   

                detalleGeneracionMasivaLocal.setImporteDiferencia(importeDiferencia);
                detalleGeneracionMasivaLocal.setImporteNetoDestino(importeNetoDestino);
                detalleGeneracionMasivaLocal.setImporteNetoOrigen(importeNetoOrigen);
                detalleGeneracionMasivaLocal.setIndicativoSeleccion(Boolean.valueOf(true));
                detalleGeneracionMasivaLocal.setNumeroUnidades(numeroUnidades);
                detalleGeneracionMasivaLocal.setPrecioCatalogoDestino(precioCatalogoDestino);
                detalleGeneracionMasivaLocal.setPrecioCatalogoOrigen(precioCatalogoOrigen);
                // detalleGeneracionMasivaLocal.setTipoSolicitud(oidTipoSolicitud); -> ha pasado a ser obligatorio
                 detalleGeneracionMasivaLocalHome.merge(detalleGeneracionMasivaLocal);
            } catch(PersistenceException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));      
            }
        }
        
        /*Vamos ahora a desseleccionar aquellos registros de todos los anteriores, recuperados en el RecordSet Lista, 
        * que nos vienen en el RecordSet dtoe.lstNoGenerar. Para ello, debemos buscarlos mediante un findByUk, 
        * para posteriormente actualizar el indicativoSeleccion de aquellos registros que coincidan*/ 

        RecordSet listaNo = dto.getLstNoGenerar();
        
        UtilidadesLog.debug("-------  RecordSet con la lista NO generar: " + listaNo);

		// BELC300014965
      // Recorremos el RecordSet ListaNo { 
      for (int j=0; j < listaNo.getRowCount(); j++) { 
         // El findByUk recibe: 
         // oidCabeceraGeneracionMasiva (generado en el create de la cabecera), 
         // oidSoliCabe (valor de la columna oidSoliCabe de la fila procesada), 
         // oidCliente (valor de la columna oidCliente de la fila procesada), 
         // oidTipoSolicitud (valor de la columna oidSoliCabe de la fila procesada)
         // se asignan estos valores a los identificadores de las columnas en LPCambiosDePrecios.guardar
         oidCliente = new Long(((BigDecimal)listaNo.getValueAt(j, "OIDCLIENTE")).longValue());
         oidSoliCabe = new Long(((BigDecimal)listaNo.getValueAt(j, "OIDSOLICABE")).longValue());
         oidTipoSolicitud = new Long(((BigDecimal)listaNo.getValueAt(j, "OIDTIPOSOLICITUD")).longValue());

         UtilidadesLog.debug("---------------------  antes de hacer el findByUK");
         UtilidadesLog.debug("--- oidCliente: " + oidCliente);
         UtilidadesLog.debug("--- oidSoliCabe: " + oidSoliCabe);
         UtilidadesLog.debug("--- oidTipoSolicitud: " + oidTipoSolicitud);
         UtilidadesLog.debug("--- cabeceraGeneracionMasiva.oid: " + cabeceraGeneracionMasivaLocal.getOid());
         
         // Detalle = Llamamos findByUk(oidCabeceraGeneracionMasiva, oidSoliCabe, oidCliente, oidTipoSolicitud ) de la entidad DetalleGeneracionMasiva    
         try {                       
            // parametros de findByUk: Long cliente, Long solicitudCabecera, Long cabecGenerMasiva, Long tipoSolicitud
            detalleGeneracionMasivaLocal = detalleGeneracionMasivaLocalHome.findByUK(oidCliente, oidSoliCabe, cabeceraGeneracionMasivaLocal.getOid(), oidTipoSolicitud);
            // En caso de obtener un objeto:
            // Actualizamos el atributo Detalle.indicativoSeleccion=0 
            detalleGeneracionMasivaLocal.setIndicativoSeleccion(Boolean.valueOf(false));
            // Pasamos a la siguiente fila de la ListaNo 
             detalleGeneracionMasivaLocalHome.merge(detalleGeneracionMasivaLocal);
         } catch(NoResultException e) {
            // pasamos a la siguiente fila 
         }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }            
      }
      
      // Se crea un DTOOid con el oidCabeceraGeneracionMasiva generado en el create de 
      // la cabecera y se devuelve
      // esto se anyadio en el paquete 41 B
      // ahora el metodo devuelve un DTOOID, lo que implica cambios en fachada y conector
      DTOOID dtoOid = new DTOOID();
      dtoOid.setOid(cabeceraGeneracionMasivaLocal.getOid());
                 
      UtilidadesLog.info("MONCambiosDePrecios.guardarGeneracion(DTOGuardarGeneracion):Salida"); 
      
      return dtoOid;
   }



    public DTOSalida obtenerCodigosOperaciones(DTOBelcorp dto) throws MareException{
       UtilidadesLog.info("MONCambiosDePrecios.obtenerCodigosOperaciones(DTOBelcorp):Entrada"); 
       DAORec dao = new DAORec(ctx);
       DTOSalida dtos = new DTOSalida();
       RecordSet rs = dao.obtenerCodigosOperacion(dto);
       dtos.setResultado(rs);
       UtilidadesLog.info("MONCambiosDePrecios.obtenerCodigosOperaciones(DTOBelcorp):Salida"); 
       return dtos;
    }

    public DTOSalida buscarCambiosPrecios(DTOBuscarCambiosPrecios dtoE) throws MareException{
        
        UtilidadesLog.info("MONCambiosDePrecios.buscarCambiosPrecios(DTOBuscarCambiosPrecios):Salida"); 
        //Vamos a recuperar aquellos cambios de precios de reclamos que estén guardados 
        //en pendiente 
        //DTOBuscarCambiosPrecios dtoe 

        //primero vamos a separar el stringTipoSolicitud que recibimos en el dtoe recibido. Y lo seteamos en el campo arrayTipoSolicitud del dtoe 
        //dtoe.arrayTipoSolicitud = MONCambiosDePrecios.convertirString(dtoe.stringTipoSolicitud) 
        UtilidadesLog.debug("DTOBuscarCambiosPrecios = " +dtoE);
        if(dtoE.getStringTipoSolicitud()!= null){
            if(!dtoE.getStringTipoSolicitud().equals("")){
                dtoE.setArrayTipoSolicitud( this.convertirString(dtoE.getStringTipoSolicitud()));
            }
        }
        
        DAOCambiosEnPrecios dao = new DAOCambiosEnPrecios();
        DTOSalida salida = new DTOSalida();
        salida.setResultado(dao.buscarCambiosPrecios(dtoE));        
       
        //Vamos a buscar    
        //DAOCambiosDePrecios dao 
        //DTOSalida dtoS = dao.buscarCambiosPrecios(dtoe) 

        //Devolver el DTOSalida dtoS obtenido
        UtilidadesLog.info("MONCambiosDePrecios.buscarCambiosPrecios(DTOBuscarCambiosPrecios):Salida"); 
        return salida;
    }

    public DTOSalida obtenerEstadosGeneracion(DTOBelcorp dtoE) throws MareException{
        UtilidadesLog.info("MONCambiosDePrecios.obtenerEstadosGeneracion(DTOBelcorp):Salida"); 
        //Creamos un DTOSalida 
        //DTOSalida.resultado = DAOCambiosEnPrecios.obtenerEstadosGeneracion(DTOE)
        DTOSalida salida = new DTOSalida();
        DAOCambiosEnPrecios dao = new DAOCambiosEnPrecios();

        salida.setResultado(dao.obtenerEstadosGeneracion(dtoE));

        UtilidadesLog.info("MONCambiosDePrecios.obtenerEstadosGeneracion(DTOBelcorp):Salida"); 
        return salida;
    }

    public DTORecuperarCabeGen recuperarCabeceraGeneracion(DTOCargaListas dtoE) throws MareException{
        
        UtilidadesLog.info("MONCambiosDePrecios.recuperarCabeceraGeneracion(DTOCargaListas):Salida"); 
        UtilidadesLog.debug("DTOCargaListas = " +dtoE);
        DAOCambiosEnPrecios dao = new DAOCambiosEnPrecios();
        
        //Obtenemos la cabecera 
        //DTORecuperarCabeGen dto = dao.recuperarCabeceraGeneracion(dtoe)
        DTORecuperarCabeGen dto = dao.recuperarCabeceraGeneracion(dtoE);
        
        //Vamos a obtener el detalle para esta cabecera 
        //DTORecuperarCabeGen.lstNoGenerar = dao.recuperarDetalleGeneracion(dtoe) 
        dto.setLstNoGenerar(dao.recuperarDetalleGeneracion(dtoE));
        
        UtilidadesLog.info("MONCambiosDePrecios.recuperarCabeceraGeneracion(DTOCargaListas):Salida"); 
        return dto;
    }

    public DTOSalida recuperarDetalleGeneracion(DTOCargaListas dtoE) throws MareException{
        
        /*DTOCargaListas dtoe 
        DAOCambiosEnPrecios dao 
        DTOSalida dto = dao.recuperarDetalleGeneracion(dtoe) 
        Se devuelve este dto
        */
        UtilidadesLog.info("MONCambiosDePrecios.recuperarDetalleGeneracion(DTOCargaListas):Entrada"); 
        UtilidadesLog.debug("DTOCargaListas = " +dtoE);
        DAOCambiosEnPrecios dao = new DAOCambiosEnPrecios();

        DTOSalida salida = new DTOSalida();
        salida.setResultado(dao.recuperarDetalleGeneracion(dtoE));
        
        UtilidadesLog.info("MONCambiosDePrecios.recuperarDetalleGeneracion(DTOCargaListas):Salida"); 
        return salida;
    }

    /**
     * Modificado: Cristian Valenzuela
     * Fecha:      29/06/2006
     * Incidencia: BELC300022743
     */
    // BELC300019805
    public void generarReclamo(DTOOID dtoE) throws MareException{
        UtilidadesLog.info("MONCambiosDePrecios.generarReclamo(DTOOID):Entrada");       
        
        DTONumeroSolicitud dtoNum = null;
        DTOLista dtoLista = null;                
        MONProcesosPED monProcesosPED = this.getMONProcesosPED();
        Long oidPeriodoActual = null;
        String numDocumento = "";
        CabeceraReclamoLocalHome cabeceraReclamoLH = new CabeceraReclamoLocalHome();
        CabeceraReclamoLocal cabeceraReclamoLocal = null;        
        OperacionReclamoLocalHome operacionReclamoLH = new OperacionReclamoLocalHome();
        OperacionReclamoLocal operacionReclamoLocal = null;
        OperacionesLocalHome operacionLH = new OperacionesLocalHome();
        OperacionesLocal operacionLocal = null;
        TiposOperacionLocalHome tiposOperacionLocalHome = new TiposOperacionLocalHome();
        TiposOperacionLocal tiposOperacionLocal = null;
        LineasOperacionReclamoLocalHome lineasOperacionReclamoLH = new LineasOperacionReclamoLocalHome();
        LineasOperacionReclamoLocal lineasOperacionReclamoLocal = null;
        DTOAtencionReclamoREC dtoAtencion = null;
        MONCapturaProcesoReclamos monCapturaProcesoReclamos = this.getMONCapturaProcesoReclamos();
        CabeceraGeneracionMasivaLocalHome cabeceraGeneracionMasivaLH = new CabeceraGeneracionMasivaLocalHome();
        CabeceraGeneracionMasivaLocal cabecera = null;

        //Vamos a recuperar el detalle de los clientes a los que genera el reclamo         
        DAOCambiosEnPrecios dao = new DAOCambiosEnPrecios();
        ArrayList listaGeneracion = dao.obtenerListaGeneracion(dtoE.getOid());
        
        /* Agregado por ssantana, 19/07/2006, inc. BELC300023578, DBLG500000942 */ 
        try {
           if (listaGeneracion.size() > 0) {
              MONPeriodosHome monPeriodosHome = this.getMONPeriodosHome();
              MONPeriodos monPeriodos = monPeriodosHome.create(); 
              dtoLista = (DTOLista) listaGeneracion.get(0);
              Long oidCanal = dtoLista.getOidCanal();
              Long oidPais = dtoLista.getOidPais();
              Long oidMarca = dtoLista.getOidMarca();
              DTOPeriodo dtoPeriodo = monPeriodos.obtienePeriodoActual(oidPais, 
                                                                       oidMarca, 
                                                                       oidCanal);
              /* Usado más adelante en este método */
              oidPeriodoActual = dtoPeriodo.getOid();
           }
        } catch (NamingException ex) {
           UtilidadesLog.error(ex);
           ctx.setRollbackOnly();
           String sCodigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
           throw new MareException(ex,
                                   UtilidadesError.armarCodigoError(sCodigoError));
        } catch (RemoteException ex) {
           UtilidadesLog.error(ex);
           ctx.setRollbackOnly();
           String sCodigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
           throw new MareException(ex,
                                   UtilidadesError.armarCodigoError(sCodigoError));
        } catch (CreateException ex) {
           UtilidadesLog.error(ex);
           ctx.setRollbackOnly();
           String sCodigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
           throw new MareException(ex,
                                   UtilidadesError.armarCodigoError(sCodigoError));
        }
        /* Fin Agregado por ssantana, 19/07/2006, inc. BELC300023578, DBLG500000942 */ 
        
        Iterator lista = listaGeneracion.iterator();

        while(lista.hasNext()) {        
            //Vamos a obtener el número de documento para el pais, y la operacion="INT083" 
            //DTONumeroSolicitud dtoNum 
            //Seteamos en el dtoNum el pais recibido y la operacion="REC034'" 
            //dtoNum.pais = dtoe.pais 
            //dtoNum.operacion = ConstantesBEL.COD_REC034 
            //String numDocumento = IGenerarNumeroDocumento.generarNumeroDocumento(dtoNum) 
            dtoNum = new DTONumeroSolicitud();
            dtoNum.setOidPais(dtoE.getOidPais());
            dtoNum.setOperacion(ConstantesBEL.COD_REC034);
            
            try {       
                numDocumento = monProcesosPED.generaNumeroDocumento(dtoNum);
            } catch(RemoteException e){
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
            }        
            
            dtoLista = (DTOLista)lista.next();
            UtilidadesLog.debug("*** dtoLista: "+dtoLista);
            /*Hacemos un create en la entidad CabeceraReclamo con los siguientes atributos: 
            - pais = dtoe.pais  x
            - numeroAtencion = numDocumento x
            - numeroReclamo = numDocumento //Se pondrá el mismo valor que tome el numeroAtencion x
            - oidPeriodoReferencia = dtoLista.oidPeriodo x
            - oidPeriodo = dtoLista.oidPeriodoReclamo x
            - oidSolicitudCabacera = dtoLista.oidSolicitudCabacera x
            - oidCliente = dtoLista.oidCliente x
            - oidTipoCliente = dtoLista.oidSubTipoCliente x
            - oidSubTipoCliente = dtoLista.oidTipoCliente x
            - oidTipoDocumento = dtoLista.oidTipoDocumento x
            - oidEstadoReclamo = ConstantesREC.ESTADO_RECLAMO_INGRESADO x
            - totalEnvia = importeNetoDestino 
            - totalDevuelve = importeNetoOrigen 
            - saldoPagar = importeDiferencia 
            - oidTipoIngreso = ConstantesREC.TIPO_INGRESO_MASIVO 
            - oidTerritorioAdministrativo = dtoLista.oidTerritorioAdministrativo
            - fechaIngreso = fecha del Sistema
            - fechaDocumentoReferencia = dtoLista.fechaDocumentoReferencia
            */
            try{
                UtilidadesLog.debug("*** Se realiza el create de la cabecera ***");
                UtilidadesLog.debug("*** numDocumento " + numDocumento);
                //Long lNumDocumento = Long.valueOf(numDocumento);
                /* Modificado por ssantana, 19/07/2006, inc. BELC300023578 */ 
                cabeceraReclamoLocal = 
                        cabeceraReclamoLH.create(new Long(numDocumento),
                                                 new Long(numDocumento),
                                                 dtoE.getOidPais(),
                                                 dtoLista.getOidSoliCabe(),
                                                 dtoLista.getOidPeriodo(), 
                                                 dtoLista.getOidCliente(),
                                                 /* dtoLista.getOidPeriodoReclamo(), */
                                                 oidPeriodoActual,
                                                 dtoLista.getOidSubTipoCliente(),
                                                 dtoLista.getOidTipoDocumento(), 
                                                 ConstantesREC.ESTADO_RECLAMO_INGRESADO,
                                                 dtoLista.getOidTipoCliente());
                /* Fin modificacion ssantana, 19/07/2006, inc. BELC300023578 */ 
            }catch(PersistenceException ce){
                UtilidadesLog.error("generarReclamo: CreateException:CabeceraReclamo",ce);
                ctx.setRollbackOnly();
                throw new MareException(ce,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS)); 
            }
            //se setean el resto de campos
            cabeceraReclamoLocal.setTotalEnvia(dtoLista.getImporteNetoDestino());
            cabeceraReclamoLocal.setTotalDevuelve(dtoLista.getImporteNetoOrigen());
            cabeceraReclamoLocal.setSaldoPagar(dtoLista.getImporteDiferencia());
            cabeceraReclamoLocal.setTipoIngreso(ConstantesREC.TIPO_INGRESO_MASIVO);
            cabeceraReclamoLocal.setUnidadAdministrativaCliente(dtoLista.getOidTerritorioAdministrativo());
            cabeceraReclamoLocal.setFechaIngreso(new java.sql.Date(System.currentTimeMillis()));
            cabeceraReclamoLocal.setUsuarioIngreso(ctx.getCallerPrincipal().getName());
            //Agregado por Cristian Valenzuela - 29/06/2006
            cabeceraReclamoLocal.setFechaDocumentoReferencia(dtoLista.getFechaDocumentoReferencia());
            //Fin - Agregado por Cristian Valenzuela - 29/06/2006
            cabeceraReclamoLH.merge(cabeceraReclamoLocal);

            /*Hacemos un create en la entidad OperacionReclamo con los siguientes atributos 
            - oidCabeceraReclamo = oidCabeceraReclamo generado en el create anterior x
            - oidTipoOperacion = dtoLista.oidTipoOperacion x
            - numeroSecuencialOperacion = 1  x
            - oidPeriodoReclamo = dtoLista.oidPeriodoReclamo x
            - oidPeriodo = dtoLista.oidPeriodo 
            - oidEstadoOperacion = ConstantesREC.ESTADO_OPERACION_INGRESADO 
            - oidTipoSolicitudPais = dtoLista.oidTipoSolicitudPais 
            - oidIndicativoMercaderia = ConstantesREC.IND_MERCADERIA_S*/
            try{
                //Integer secuencialOperacion, Long numeroAtencion, Long periodoReclamo, Long tipoOperacion
                UtilidadesLog.debug("*** Se realiza el create de la operacion ***");
                /* Modificado por ssantana, 19/07/2006, inc. BELC300023578 */ 
                operacionReclamoLocal = 
                        operacionReclamoLH.create(new Integer(1),
                                                  cabeceraReclamoLocal.getOid(),
                                                  /*dtoLista.getOidPeriodoReclamo(), */
                                                  oidPeriodoActual,
                                                  dtoLista.getOidTipoOperacion(), 
                                                  dtoLista.getOidSoliCabe());
                /* Fin Modificacion por ssantana, 19/07/2006, inc. BELC300023578 */ 
            }catch(PersistenceException ce){
                UtilidadesLog.error("generarReclamo: CreateException:OperacionReclamo",ce);
                ctx.setRollbackOnly();
                throw new MareException(ce,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS)); 
            }
            operacionReclamoLocal.setEstadoOperacion(ConstantesREC.ESTADO_OPERACION_INGRESADO);
            
            /* Eliminado por ssantana, 20/07/2006, inc. BELC300023158 */
            /* operacionReclamoLocal.setTipoSolicitudPerdida(dtoLista.getOidTipoSolicitudPais());*/
            /* Fin Eliminado por ssantana, 20/07/2006, inc. BELC300023158 */ 
            
            operacionReclamoLocal.setIndicativoEntregaMercaderia(ConstantesREC.IND_MERCADERIA_S);
            operacionReclamoLH.merge(operacionReclamoLocal);
            //Vamos a crear una linea de operacion para el envia y una para el devuelve 
            /*Hacer un create en la entidad LineasOperacionReclamo con los siguientes atributos 
            - oidOperacionReclamo = oidOperacionReclamo generado en el create anterior x
            - numeroLinea = 1 x
            - oidTipoMovimiento = ConstantesREC.TIPO_MOVIMIENTO_ENVIA x
            - oidTipoOferta = dtoLista.oidTipoOfertaDestino x
            - unidadesReclamadas = dtoLista.numeroUnidades 
            - importeAbono = dtoLista.importeNetoDestino 
            - numeroUnidadesDevueltas = dtoLista.numeroUnidades 
            - indicadorEstado = ConstantesREC:ESTADO_LINEA_INGRESADO 
            - oidProducto = dtoLista.oidProductoDestino 
            - codigoVenta = dtoLista.oidMFDestino*/
            try{
                //Integer numeroLinea, Long operacion, Long tipoOferta, Long tipoPosicion, 
                //Long tipoMovimiento, Long motivoDevolucion
                UtilidadesLog.debug("*** Se realiza el create de la linea de envia ***");
                lineasOperacionReclamoLocal = lineasOperacionReclamoLH.create(new Integer(1),operacionReclamoLocal.getOid(),
                                                dtoLista.getOidTipoOferaDestino(),null ,ConstantesREC.TIPO_MOVIMIENTO_ENVIA,
                                                null);
            }catch(PersistenceException ce){
                UtilidadesLog.error("generarReclamo: CreateException:LineasOperacion",ce);
                ctx.setRollbackOnly();
                throw new MareException(ce,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS)); 
            }
            lineasOperacionReclamoLocal.setUnidadesReclamadas(dtoLista.getNumeroUnidades());

            //DBLG500001060
            lineasOperacionReclamoLocal.setImporteCargo(dtoLista.getImporteNetoDestino());
            lineasOperacionReclamoLocal.setPrecio(dtoLista.getImporteCatalogoDestino());
            //lineasOperacionReclamoLocal.setNumeroUnidadesDevueltas(dtoLista.getNumeroUnidades());incidencia DBLG50000678
            lineasOperacionReclamoLocal.setIndicadorEstado(new Character(ConstantesREC.ESTADO_LINEA_INGRESADO.charAt(0)));
            // BELC300020144 
            lineasOperacionReclamoLocal.setProducto(dtoLista.getOidProductoDestino()); 
            //Agregado por Cristian Valenzuela - 29/06/2006
            lineasOperacionReclamoLocal.setCodigoVenta(dtoLista.getOidMFDestino());
            //Fin - Agregado por Cristian Valenzuela - 29/06/2006
             lineasOperacionReclamoLH.merge(lineasOperacionReclamoLocal);      
            /*Hacer un create en la entidad LineasOperacionReclamo con los siguientes atributos 
            - oidOperacionReclamo = oidOperacionReclamo generado en el create anterior 
            - numeroLinea = 2 
            - oidTipoMovimiento = ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE 
            - oidTipoOferta = dtoLista.oidTipoOferta 
            - unidadesReclamadas = dtoLista.numeroUnidades 
            - importeCargo= dtoLista.importeNetoOrigen 
            - numeroUnidadesDevueltas = dtoLista.numeroUnidades 
            - indicadorEstado = ConstantesREC:ESTADO_LINEA_INGRESADO 
            - oidProducto = dtoLista.oidProductoOrigen 
            - codigoVenta = dtoLista.oidMFOrigen*/
            try{
                //Integer numeroLinea, Long operacion, Long tipoOferta, Long tipoPosicion, 
                //Long tipoMovimiento, Long motivoDevolucion
                UtilidadesLog.debug("*** Se realiza el create de la linea de devuelve ***");
                lineasOperacionReclamoLocal = lineasOperacionReclamoLH.create(new Integer(2),operacionReclamoLocal.getOid(),
                                                dtoLista.getOidTipoOferaDestino(),null,ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE,
                                                null);
            }catch(PersistenceException ce){
                UtilidadesLog.error("generarReclamo: CreateException:LineasOperacion",ce);
                ctx.setRollbackOnly();
                throw new MareException(ce,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS)); 
            }
            lineasOperacionReclamoLocal.setPosicionReferencia(dtoLista.getOidPosicionReferencia());  //inc 22743
            lineasOperacionReclamoLocal.setUnidadesReclamadas(dtoLista.getNumeroUnidades());
            
            //DBLG500001060
            lineasOperacionReclamoLocal.setImporteAbono(dtoLista.getImporteNetoOrigen());
            lineasOperacionReclamoLocal.setPrecio(dtoLista.getImporteCatalogoOrigen());
            lineasOperacionReclamoLocal.setNumeroUnidadesDevueltas(dtoLista.getNumeroUnidades());
            lineasOperacionReclamoLocal.setIndicadorEstado(new Character(ConstantesREC.ESTADO_LINEA_INGRESADO.charAt(0)));
            // BELC300020144 
            lineasOperacionReclamoLocal.setProducto(dtoLista.getOidProductoOrigen()); 
            //Agregado por Cristian Valenzuela - 29/06/2006
            lineasOperacionReclamoLocal.setCodigoVenta(dtoLista.getOidMFOrigen());
            //Fin - Agregado por Cristian Valenzuela - 29/06/2006
             lineasOperacionReclamoLH.merge(lineasOperacionReclamoLocal);
           try{
              
                UtilidadesLog.debug("*** Se realiza el Find de la operacion ***");
              
                tiposOperacionLocal = 
                        tiposOperacionLocalHome.findByPrimaryKey(operacionReclamoLocal.getTipoOperacion());
                
                operacionLocal = 
                        operacionLH.findByPrimaryKey(tiposOperacionLocal.getOperacion());
                /* Fin Modificacion por ssantana, 19/07/2006, inc. BELC300023578 */ 
            }catch(NoResultException fe){
                UtilidadesLog.error("generarReclamo: CreateException:Operacion",fe);
                ctx.setRollbackOnly();
                throw new MareException(fe,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS)); 
            } catch(PersistenceException ce){
                UtilidadesLog.error("generarReclamo: CreateException:Operacion",ce);
                ctx.setRollbackOnly();
                throw new MareException(ce,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS)); 
            }
            
            //Vamos a generar la solicitud 
            //Llamar al método MONCapturaProcesoReclamos.generarSolicitudes(numDocumento) 
            dtoAtencion = new DTOAtencionReclamoREC();
            dtoAtencion.setOidIdioma(dtoE.getOidIdioma());
            dtoAtencion.setOidPais(dtoE.getOidPais());
            dtoAtencion.setNumAtencion(new Long(numDocumento));
            if(operacionLocal.getRecojo().booleanValue()){
              dtoAtencion.setNumRecojo(ConstantesREC.RECOJO_INICIAL);
            }else{
              dtoAtencion.setNumRecojo(ConstantesREC.RECOJO_RECLAMO_MASIVO);
            }
            try{
                UtilidadesLog.debug("*** Se genera la solicitud. DTOAtencionReclamoREC: " + dtoAtencion);
                monCapturaProcesoReclamos.generarSolicitudes(dtoAtencion);
            }catch(RemoteException e){
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));    
            } catch(PersistenceException ce){
                
                ctx.setRollbackOnly();
                throw new MareException(ce,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS)); 
            }

            //Vamos a actualizar la cabecera del reclamo a generar a Enviado 
            //Cabecera = findByPrimaryKey (dtoe.oid) de la entidad CabeceraGeneracionMasiva 
            //Actualizamos el atributo Cabecera.oidEstadoGeneracion = ConstantesREC.ESTADO_GENERACION_ENVIADO 
            try{
               UtilidadesLog.debug("*** Se busca la cabecera con oid: " + dtoE.getOid());
               cabecera = cabeceraGeneracionMasivaLH.findByPrimaryKey(dtoE.getOid()); 
            }catch(NoResultException fe) {
                String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                ctx.setRollbackOnly();
                UtilidadesLog.error("MONCambiosDePrecios.generarReclamo: FinderException de CabeceraGeneracionMasiva",fe);
                throw new MareException(fe, UtilidadesError.armarCodigoError(error));
            } catch(PersistenceException ce){
             
                ctx.setRollbackOnly();
                throw new MareException(ce,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS)); 
            }
            cabecera.setEstado(ConstantesREC.ESTADO_GENERACION_ENVIADO.toString());
            cabeceraGeneracionMasivaLH.merge(cabecera);
        }
        
        UtilidadesLog.info("MONCambiosDePrecios.generarReclamo(DTOOID):Salida"); 
    }

 
   private MONCapturaProcesoReclamos getMONCapturaProcesoReclamos() throws MareException {
        // Se obtiene el interfaz home
        MONCapturaProcesoReclamosHome home = (MONCapturaProcesoReclamosHome)UtilidadesEJB.getHome(
            "MONCapturaProcesoReclamos", MONCapturaProcesoReclamosHome.class);
            
        // Se obtiene el interfaz remoto
        MONCapturaProcesoReclamos ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        return ejb;
    }

    // modificado por BELC300020340
    public void guardarModificacion(DTOGuardarModificacion dtoE) throws MareException {
        
        UtilidadesLog.info("MONCambiosDePrecios.guardarModificacion(DTOGuardarModificacion):Entrada"); 
        
        //Vamos a guardar la modificación del reclamos a generar 
        
        UtilidadesLog.debug("*** DTOGuardarModificacion = "+dtoE);
        
        DetalleGeneracionMasivaLocalHome detalleHome = new DetalleGeneracionMasivaLocalHome();
        DetalleGeneracionMasivaLocal detalleLocal = null;
        Long oidDetalleGeneracion = null;
        
        // Recorreremos ambos RecordSets: lstDetalles y lstNoGenerar
        
        ////////////////////////////////////////////// lista detalles
        
        // Vamos ahora a seleccionar aquellos registros recuperados en el RecordSet lstDetalles. 
        // Para ello, debemos buscarlos mediante un findByPrimaryKey, para posteriormente actualizar 
        // el indicativoSeleccion de aquellos registros que coincidan

        RecordSet listaSi = dtoE.getLstDetalles();        
        
        if(! listaSi.esVacio()) {
            /*Detalle = Llamamos findByPrimaryKey(oidDetalleGeneracion) de la entidad DetalleGeneracionMasiva 
            Si obtenemos una finderException { 
            pasamos a la siguiente fila 
            } 
            En caso de obtener un objeto { 
            Actualizamos el atributo Detalle.indicativoSeleccion=1
            Pasamos a la siguiente fila de la ListaSi
            } 
            } */
            for (int i=0; i < listaSi.getRowCount(); i++) {
                oidDetalleGeneracion = new Long(((BigDecimal)listaSi.getValueAt(i, "OIDDETALLEGENERA")).longValue());
                UtilidadesLog.debug("*** oidDetalleGeneracion = " + oidDetalleGeneracion);
                
                try {
                    detalleLocal = detalleHome.findByPrimaryKey(oidDetalleGeneracion);
                } catch (NoResultException fe) {
                    UtilidadesLog.error("No se encuentra el detalle con oid: " + oidDetalleGeneracion);
                    continue;
                }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   
                detalleLocal.setIndicativoSeleccion(Boolean.TRUE);
                detalleHome.merge(detalleLocal);
            }            
        }

       
        ////////////////////////////////////////////// lista no generar
        
        // Vamos ahora a desseleccionar aquellos registros recuperados en el RecordSet Lista, 
        // que nos vienen en el RecordSet dtoe.lstNoGenerar. Para ello, debemos buscarlos 
        // mediante un findByPrimaryKey, para posteriormente actualizar el indicativoSeleccion de aquellos 
        // registros que coincidan
        
        // RecordSet ListaNo = dtoe.lstNoGenerar 
        RecordSet listaNo = dtoE.getLstNoGenerar(); 

        if(!listaNo.esVacio()){
            /*Detalle = Llamamos findByPrimaryKey(oidDetalleGeneracion) de la entidad DetalleGeneracionMasiva 
            Si obtenemos una finderException { 
            pasamos a la siguiente fila 
            } 
            En caso de obtener un objeto { 
            Actualizamos el atributo Detalle.indicativoSeleccion=0 
            Pasamos a la siguiente fila de la ListaNo 
            } 
            } */
            for(int i=0;i<listaNo.getRowCount();i++){
                oidDetalleGeneracion = new Long(((BigDecimal)listaNo.getValueAt(i, "OIDDETALLEGENERA")).longValue());
                UtilidadesLog.debug("*** oidDetalleGeneracion = " + oidDetalleGeneracion);
                
                try{
                    detalleLocal = detalleHome.findByPrimaryKey(oidDetalleGeneracion);
                }catch(NoResultException fe){
                    UtilidadesLog.error("No se encuentra el detalle con oid: " + oidDetalleGeneracion);
                    continue;
                }catch(PersistenceException e) {
               ctx.setRollbackOnly();
               String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
               throw new MareException(e, UtilidadesError.armarCodigoError(error));
            }   
                detalleLocal.setIndicativoSeleccion(Boolean.FALSE);
                detalleHome.merge(detalleLocal);
            }
        }
        
        UtilidadesLog.info("MONCambiosDePrecios.guardarModificacion(DTOGuardarModificacion):Salida"); 
    }

    public void anularReclamo(DTOOID dtoE) throws MareException{
        UtilidadesLog.info("MONCambiosDePrecios.anularReclamo(DTOOID):Entrada"); 
        //Vamos a actualizar la cabecera con estado Anulado 
        //Cabecera = llamar al findByPrimaryKey(dtoe.oid) de la entidad CabeceraGeneracionMasiva 
        //Actualizamos el atributo CabeceraGeneracionMasiva.oidEstadoGeneracion = ConstantesREC.ESTADO_GENERACION_ANULADO
        CabeceraGeneracionMasivaLocalHome cabeceraHome = new CabeceraGeneracionMasivaLocalHome();
        CabeceraGeneracionMasivaLocal cabeceraLocal = null;
        UtilidadesLog.debug("*** Se anula la cabecera con oid ="+dtoE.getOid());
        
        try{
            cabeceraLocal = cabeceraHome.findByPrimaryKey(dtoE.getOid());
        }catch(NoResultException fe) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            ctx.setRollbackOnly();
            UtilidadesLog.error("MONCambiosDePrecios.anularReclamo: FinderException de CabeceraGeneracionMasiva",fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(error));
        } catch(PersistenceException ce){
                ctx.setRollbackOnly();
                throw new MareException(ce,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS)); 
        }
        UtilidadesLog.debug("*** Se actualiza el estado de la cabecera ***");
        cabeceraLocal.setEstado(ConstantesREC.ESTADO_GENERACION_ANULADO.toString());
        cabeceraHome.merge(cabeceraLocal);
        UtilidadesLog.info("MONCambiosDePrecios.anularReclamo(DTOOID):Salida"); 
    }

  private MONPeriodosHome getMONPeriodosHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONPeriodosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONPeriodos"), MONPeriodosHome.class);
  }

 
}