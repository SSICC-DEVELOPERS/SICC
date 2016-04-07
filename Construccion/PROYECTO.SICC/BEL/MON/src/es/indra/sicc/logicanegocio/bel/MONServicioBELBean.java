/**
 * Copyright 2002 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.logicanegocio.bel;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOString;
import es.indra.sicc.cmn.negocio.correo.DTOCorreoElectronico;
import es.indra.sicc.cmn.negocio.correo.MONServicioCorreoElectronico;
import es.indra.sicc.cmn.negocio.correo.MONServicioCorreoElectronicoHome;
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.dtos.bel.DTOAlmOrigDest;
import es.indra.sicc.dtos.bel.DTOCopiarParametrosBelcenter;
import es.indra.sicc.dtos.bel.DTOMovimientoCajaDetalle;
import es.indra.sicc.dtos.bel.DTOStock;

import es.indra.sicc.dtos.cal.DTOBuscarStockProducto;

import es.indra.sicc.entidades.bel.AsociacionMaquinaCajaLocal;
import es.indra.sicc.entidades.bel.AsociacionMaquinaCajaLocalHome;
import es.indra.sicc.entidades.bel.CajaLocal;
import es.indra.sicc.entidades.bel.CajaLocalHome;
import es.indra.sicc.entidades.bel.ParametrosBelcenterLocal;
import es.indra.sicc.entidades.bel.ParametrosBelcenterLocalHome;
import es.indra.sicc.entidades.bel.StockLocal;
import es.indra.sicc.entidades.bel.StockLocalHome;
import es.indra.sicc.entidades.seg.SubaccesoLocal;
import es.indra.sicc.entidades.seg.SubaccesoLocalHome;
import es.indra.sicc.logicanegocio.bel.DAOServicioBel;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;

import javax.persistence.PersistenceException;

import javax.rmi.PortableRemoteObject;

/**
 * 
 */
public class MONServicioBELBean implements SessionBean, IServicioBEL  {
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

	/** 
     * Método para recuperar el Stock de una Agrupacion para un almacen y un producto determinados
     * @param pais Long con el oid del pais
     * @param almacen Long con el oid del almacen
     * @param producto Long con el oid del producto
     * @param codigoAgrupacion String con el codigo de agrupacion
     * @return Long  con el valor del Stock
     * @exception MareException 
     */	
	public Long recuperarStockEstadosAgrupados(Long pais, Long almacen, Long producto, String codigoAgrupacion) throws MareException{
		UtilidadesLog.info("MONServicioBELBean.recuperarStockEstadosAgrupados(Long pais, Long almacen, Long producto, String codigoAgrupacion):Entrada");
		long acumulador=0;
		String usuario = ctx.getCallerPrincipal().getName();
		DAOServicioBel daoServicio=new DAOServicioBel(usuario);
		RecordSet rsRetorno=daoServicio.obtenerStocksAgrupacion(pais,almacen,producto,codigoAgrupacion);
		for(int i=0;i<rsRetorno.getRowCount();i++){
			Long parcial=new Long(rsRetorno.getValueAt(i,"VAL_SALD").toString()); //VAL_SALD no puede ser nulo
			String operacion=rsRetorno.getValueAt(i,"COD_OPER").toString(); //COD_OPER no puede ser nulo
			if(operacion.equalsIgnoreCase("+")){
				acumulador+=parcial.longValue();
			}else{
				acumulador-=parcial.longValue();
			}			
		}
		UtilidadesLog.debug("****Metodo recuperarStockEstadosAgrupados: retorna: "+acumulador);
		UtilidadesLog.info("MONServicioBELBean.recuperarStockEstadosAgrupados(Long pais, Long almacen, Long producto, String codigoAgrupacion):Salida");
		return new Long(acumulador);
	}

	/** 
     * Método para obtener los medios de pago de un pais
     * @param dto DTOBelcorp con los criterios de la consulta
     * @return DTOSalida el resultado de la consulta
     * @exception MareException 
     */	
	public DTOSalida obtenerMediosDePago(DTOBelcorp dto) throws MareException {
		UtilidadesLog.info("MONServicioBELBean.obtenerMediosDePago(DTOBelcorp dto):Entrada");
		DTOSalida salida=null;
		String usuario = ctx.getCallerPrincipal().getName();
		DAOServicioBel daoServicio=new DAOServicioBel(usuario);
		salida=daoServicio.obtenerMediosDePago(dto);
		if(salida==null){
			salida=new DTOSalida(new RecordSet());
		}
		UtilidadesLog.info("MONServicioBELBean.obtenerMediosDePago(DTOBelcorp dto):Salida");
		return salida;
	}
	
	/** 
     * Método para obtener los medios de pago de un pais (datos asignables a un combo)
     * @param dto DTOBelcorp con los criterios de la consulta
     * @return DTOSalida el resultado de la consulta
     * @exception MareException 
     */	
	public DTOSalida obtenerMediosPagoCombo(DTOBelcorp dto) throws MareException {
    UtilidadesLog.info("MONServicioBELBean.obtenerMediosPagoCombo(DTOBelcorp dto):Entrada");
		DTOSalida salida=null;
		String usuario = ctx.getCallerPrincipal().getName();
		DAOServicioBel daoServicio=new DAOServicioBel(usuario);
		salida=daoServicio.obtenerMediosPagoCombo(dto);
		if(salida==null){
			salida=new DTOSalida(new RecordSet());
		}
		UtilidadesLog.info("MONServicioBELBean.obtenerMediosPagoCombo(DTOBelcorp dto):Salida");
		return salida;	
	}

	/** 
     * Método para obtener los tipos de medios de pago
     * @param dto DTOBelcorp con los criterios de la consulta
     * @return DTOSalida el resultado de la consulta
     * @exception MareException 
     */	
	public DTOSalida obtenerTiposMedioPago(DTOBelcorp dto) throws MareException {
		UtilidadesLog.info("MONServicioBELBean.obtenerTiposMedioPago(DTOBelcorp dto):Entrada");
		DTOSalida salida=null;
		String usuario = ctx.getCallerPrincipal().getName();
		DAOServicioBel daoServicio=new DAOServicioBel(usuario);
		salida=daoServicio.obtenerTiposMedioPago(dto);
		if(salida==null){
			salida=new DTOSalida(new RecordSet());
		}
		UtilidadesLog.info("MONServicioBELBean.obtenerTiposMedioPago(DTOBelcorp dto):Salida");
		return salida;	
	}	 

	/** 
     * Método para obtener las formas de pago de un pais
     * @param dto DTOBelcorp con los criterios de la consulta
     * @return DTOSalida el resultado de la consulta
     * @exception MareException 
     */	
	public DTOSalida obtenerFormasPagoCabecera(DTOBelcorp dto) throws MareException {
		UtilidadesLog.info("MONServicioBELBean.obtenerFormasPagoCabecera(DTOBelcorp dto):Entrada");
		DTOSalida salida=null;
		String usuario = ctx.getCallerPrincipal().getName();
		DAOServicioBel daoServicio=new DAOServicioBel(usuario);
		salida=daoServicio.obtenerFormasPagoCabecera(dto);
		if(salida==null){
			salida=new DTOSalida(new RecordSet());
		}
		UtilidadesLog.info("MONServicioBELBean.obtenerFormasPagoCabecera(DTOBelcorp dto):Salida");
		return salida;	
	}

	/** 
     * Método para obtener los estados de mercancia de un pais
     * @param dto DTOBelcorp con los criterios de la consulta
     * @return DTOSalida el resultado de la consulta
     * @exception MareException 
     */	
	public DTOSalida obtenerEstadosMercancia(DTOBelcorp dto) throws MareException {
		UtilidadesLog.info("MONServicioBELBean.obtenerEstadosMercancia(DTOBelcorp dto):Entrada");
		DTOSalida salida=null;
		String usuario = ctx.getCallerPrincipal().getName();
		DAOServicioBel daoServicio=new DAOServicioBel(usuario);
		salida=daoServicio.obtenerEstadosMercancia(dto);
		if(salida==null){
			salida=new DTOSalida(new RecordSet());
		}
		UtilidadesLog.info("MONServicioBELBean.obtenerEstadosMercancia(DTOBelcorp dto):Salida");
		return salida;	
	}

	/** 
     * Método para obtener el subacceso asociado a una Maquina
     * @param dto DTOString con la cadena que identifica la Maquina
     * @return DTOOID con el oid del subacceso asociado
     * @exception MareException 
     */	
	public DTOOID obtenerSubaccesoAsociado(DTOString dto) throws MareException{
		UtilidadesLog.info("MONServicioBELBean.obtenerSubaccesoAsociado(DTOString dto):Entrada");
		DTOOID dtoOid = new DTOOID();
		/*modificado por mdolce segun incidencia 10173*/
    try{
       
       AsociacionMaquinaCajaLocalHome aMCLH = this.getAsociacionMaquinaCajaLocalHome();
       UtilidadesLog.debug("****dto.getCadena()" + dto.getCadena());
       AsociacionMaquinaCajaLocal     aMCL  = aMCLH.findByUK(dto.getCadena());
       
       CajaLocalHome cLH = this.getCajaLocalHome();
       UtilidadesLog.debug("****aMCL.getOidCaja()" + aMCL.getOidCaja());
       CajaLocal     cL  = cLH.findByPrimaryKey(aMCL.getOidCaja());
       UtilidadesLog.debug("****cL.getSubAcceso()" + cL.getSubAcceso());
       UtilidadesLog.debug("****dto.getOidPais()" + dto.getOidPais());
       dtoOid.setOid(cL.getSubAcceso());
       dtoOid.setOidPais(dto.getOidPais());     
       
    } catch(NoResultException e){
        UtilidadesLog.error(e);
        ctx.setRollbackOnly();		
			  throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));    				
    }  catch (PersistenceException ce) {   
        UtilidadesLog.error("ERROR ", ce);
        throw new MareException(ce, 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }
    UtilidadesLog.info("MONServicioBELBean.obtenerSubaccesoAsociado(DTOString dto):Salida");
    return  dtoOid;

	}
	
	/** 
     * Método para obtener los almacenes de un pais
     * @param dto DTOBelcorp con los criterios de la consulta
     * @return DTOSalida el resultado de la consulta
     * @exception MareException 
     */	
	public DTOSalida obtenerAlmacenes(DTOBelcorp dto) throws MareException {
		UtilidadesLog.info("MONServicioBELBean.obtenerAlmacenes(DTOBelcorp dto):Entrada");
		DTOSalida salida=null;
		String usuario = ctx.getCallerPrincipal().getName();
		DAOServicioBel daoServicio=new DAOServicioBel(usuario);
		salida=daoServicio.obtenerAlmacenes(dto);
		if(salida==null){
			salida=new DTOSalida(new RecordSet());
		}
		UtilidadesLog.info("MONServicioBELBean.obtenerAlmacenes(DTOBelcorp dto):Salida");
		return salida;	
	}	

	/** 
     * Método para obtener el Stock correspondiente a un almacen, un producto y un estado de mercancia determinados
     * @param almacen Long con el oid del almacen
     * @param estado Long con el oid del estado de la mercancia
     * @param producto Long con el oid del producto
     * @return Long  con el valor del saldo
	 * @exception MareException 
     */	
	public Long comprobarStock(Long almacen, Long estado, Long producto) throws MareException{
		UtilidadesLog.info("MONServicioBELBean.comprobarStock(Long almacen, Long estado, Long producto):Entrada");
		Long comprobacion = null;
		/*
		 * Hacer un findByClaveUnica sobre la entidad Stock pasando los atributos de entrada como parámetros de la llamada 
		 * -> Tomar del registro encontrado el saldo y devolverlo en un Long
		 */


		StockLocalHome stockLocalHome = this.getStockLocalHome();
		try {
			StockLocal stockLocal = stockLocalHome.findByClaveUnica(almacen, estado, producto);
			comprobacion = stockLocal.getSaldo();
		} catch(NoResultException e){
			//String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
      /* 26/04/2006 Inc.BELC300022840 Se modifica el mensaje de error 
       * BEL-0021 "No se ha podido generar movimientos de almancen. Al menos un 
       * producto no tiene stock en el almacen seleccionado" */
			this.logearError("obtenerSubaccesoAsociado: FinderException",e);
			throw new MareException(e, 
          UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_BEL, 
              ErroresDeNegocio.BEL_0021));    				
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}
                
		UtilidadesLog.info("MONServicioBELBean.comprobarStock(Long almacen, Long estado, Long producto):Salida");
		return comprobacion;
		
	}
	
	/** 
     * Método para obtener las operaciones definidas
     * @return DTOSalida el resultado de la consulta
     * @exception MareException 
     */	
	public DTOSalida obtenerOperaciones() throws MareException {
		UtilidadesLog.info("MONServicioBELBean.obtenerOperaciones():Entrada");
		RecordSet salida=null;
		String usuario = ctx.getCallerPrincipal().getName();
		DAOServicioBel daoServicio=new DAOServicioBel(usuario);
		salida=daoServicio.obtenerOperaciones();
		if(salida==null){
			salida=new RecordSet();
		}
		UtilidadesLog.info("MONServicioBELBean.obtenerOperaciones():Salida");
		return new DTOSalida(salida);	
	}	

	/** 
     * Método para mover los registros de Stock
     * @param DTOAlmOrigDest
     * @exception MareException 
     */	
	public void moverRegistrosDeStock(DTOAlmOrigDest dtoAlmOrigDest) throws MareException {
		UtilidadesLog.info("MONServicioBELBean.moverRegistrosDeStock(DTOAlmOrigDest dtoAlmOrigDest):Entrada");
        
        //@ssaavedr, agregado por inc.: BELC300014083, antes se debe borrar la información del almacén 
        //destino y luego copiar.
        /* Eliminación de los registros del Almacén Destino */
        DTOStock dtoStockTemp = new DTOStock();
        dtoStockTemp.setOidAlmacen(dtoAlmOrigDest.getOidAlmacenDestino());
        this.eliminarRegistrosDeStock(dtoStockTemp);
        //

		this.validaAcceso(dtoAlmOrigDest.getOidPais(),null,null,null,null,null,null,null,null);
		
		DTOStock dtoStock=new DTOStock();
		//Asigna el atributo DTOStock.oidAlmacen el atributo DTOAlmOrigDest.oidAlmacenOrigen
		dtoStock.setOidAlmacen(dtoAlmOrigDest.getOidAlmacenOrigen());
		String usuario = ctx.getCallerPrincipal().getName();
		DAOServicioBel daoServicio=new DAOServicioBel(usuario);
		RecordSet rs=daoServicio.obtenerStocks(dtoStock);
		
		Long almacen=dtoAlmOrigDest.getOidAlmacenDestino();
		Long estadoMercancia;
		Long producto;
		Long saldo;
		StockLocalHome stockLocalHome = this.getStockLocalHome();
		StockLocal stockLocal=null;
		for (int i=0; i<rs.getRowCount(); i++) {
			estadoMercancia=new Long(rs.getValueAt(i,"ESME_OID_ESTA_MERC").toString());
			producto=new Long(rs.getValueAt(i,"PROD_OID_PROD").toString());
			saldo=new Long(rs.getValueAt(i,"VAL_SALD").toString());
			
			try{
				stockLocal=stockLocalHome.create(almacen,estadoMercancia,producto,saldo);		
			}catch(PersistenceException ce){
				ctx.setRollbackOnly();
				String codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
				this.logearError("moverRegistrosDeStock: CreateException",ce);
				throw new MareException(ce, UtilidadesError.armarCodigoError(codigoError)); 
			}
		}
		UtilidadesLog.info("MONServicioBELBean.moverRegistrosDeStock(DTOAlmOrigDest dtoAlmOrigDest):Salida");
	}

	/** Metod para eliminar registros del Stock
	 * @param DTOStock
	 * @exception MareException
	 * @author masanz
	 */
	public void eliminarRegistrosDeStock(DTOStock dtoStock) throws  MareException {
		UtilidadesLog.info("MONServicioBELBean.eliminarRegistrosDeStock(DTOStock dtoStock):Entrada");

		this.validaAcceso(dtoStock.getOidPais(),null,null,null,null,null,null,null,null);
		Long oid = null;
		String usuario = ctx.getCallerPrincipal().getName();
		DAOServicioBel daoServicio=new DAOServicioBel(usuario);
		RecordSet rs=daoServicio.obtenerStocks(dtoStock);
		StockLocalHome stockLocalHome = this.getStockLocalHome();
		StockLocal stock = null;
		
		try{
			if (rs != null){
				for (int i = 0; i < rs.getRowCount(); i++){
					oid = new Long(rs.getValueAt(i,"OID_STOC").toString());
					stock = stockLocalHome.findByPrimaryKey(oid);
					stockLocalHome.remove(stock);
				}
			}
		} catch (NoResultException e){
			ctx.setRollbackOnly();
			String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
			this.logearError("eliminarRegistrosDeStock: FinderException",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		} catch (PersistenceException e){
			ctx.setRollbackOnly();
			String codigoError = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
			this.logearError("eliminarRegistrosDeStock: RemoveException",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		
		UtilidadesLog.info("MONServicioBELBean.eliminarRegistrosDeStock(DTOStock dtoStock):Salida");
	}
	
	private void logearError(String mensaje,Throwable e) {
		//mensaje: nombreMetodo: tipoExcepcion
		UtilidadesLog.error("****Error Metodo: "+mensaje+": "+ e.getMessage());
		UtilidadesLog.error(e);
	}

	private void logearStackTrace(Throwable e){
		try{						
			ByteArrayOutputStream pila = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(pila);
			/*e.printStackTrace(out);
			UtilidadesLog.error(pila.toString());*/
      UtilidadesLog.error(e);
		}catch(Exception ex){
			UtilidadesLog.error("Error Logeando Pila: "+ex.getMessage());
		}			
	}

	private void validaAcceso(Long pais, Long marca, Long canal, Long acceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio) throws  MareException {
		UtilidadesLog.info("MONServicioBELBean.validaAcceso(Long pais, Long marca, Long canal, Long acceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio):Entrada");
        MONValidacion monValidacion = this.getMONValidacion();
        Boolean b = new Boolean(true);

		UtilidadesLog.debug("****Llamada a validaAcceso(pais= "+ pais+", marca="+marca+", canal= "+canal+", acceso="+acceso+", subgerencia="+subgerencia+", region="+region+", zona="+zona+", seccion="+seccion+", territorio="+territorio);
		try{
			b = monValidacion.validarAccesos( pais, null, marca, canal, acceso, null, subgerencia, region, zona, seccion, territorio);
		}catch(RemoteException rExc){
      UtilidadesLog.error(rExc);
			ctx.setRollbackOnly();
			UtilidadesLog.error("****Metodo validaAccesoVinculos: validaAcceso : ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB");
			throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB) );			
		}
		UtilidadesLog.debug("****Retorno validaAcceso : " + b.toString());
		if (!b.booleanValue()){				
			ctx.setRollbackOnly();
			UtilidadesLog.error("****Metodo validaAccesoVinculos: validaAcceso : ERROR_ASOCIACION_ESTRUCTURAL");
			throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_ASOCIACION_ESTRUCTURAL) );
		}
		UtilidadesLog.info("MONServicioBELBean.validaAcceso(Long pais, Long marca, Long canal, Long acceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio):Salida");
	}

	private MONValidacion getMONValidacion() throws MareException {
        // Se obtiene el interfaz home
		UtilidadesLog.debug("****Metodo  getMONValidacion: Entrada");				
        MONValidacionHome home = (MONValidacionHome)UtilidadesEJB.getHome(
            "MONValidacion", MONValidacionHome.class);
            
        // Se obtiene el interfaz remoto
        MONValidacion ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			this.logearError("*** Error en getMONValidacion",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.debug("****Metodo  getMONValidacion: Salida");		        
        return ejb;
	}
	

	public DTOSalida consultarFPagoDetalNumPosi(DTOOID dtoe) throws MareException {
		return null;
	}

  public DTOBoolean comprobarParametrizacionSubacceso(DTOOID dto) throws MareException {
    UtilidadesLog.info("MONServicioBELBean.comprobarParametrizacionSubacceso(DTOOID dto):Entrada");
    DTOBoolean dtoBoolean = new DTOBoolean();
    String usuario = ctx.getCallerPrincipal().getName();
		DAOServicioBel daoServicio = new DAOServicioBel(usuario);

    dtoBoolean = daoServicio.comprobarParametrizacionSubacceso(dto);
    UtilidadesLog.info("MONServicioBELBean.comprobarParametrizacionSubacceso(DTOOID dto):Salida");
    return dtoBoolean;
  }

  public void copiarParametrosBelcenter(DTOCopiarParametrosBelcenter dto) throws  RemoteException, MareException{
    UtilidadesLog.info("MONServicioBELBean.copiarParametrosBelcenter(DTOCopiarParametrosBelcenter dto):Entrada");
		try {
      UtilidadesLog.debug("se fue aal primer finder");
      ParametrosBelcenterLocalHome parametrosLocalHome = this.getParametrosBelcenterLocalHome();
      UtilidadesLog.debug("antes de ejecutar");
      ParametrosBelcenterLocal parametrosLocal = parametrosLocalHome.findByUK(dto.getOidPais(),dto.getOidSubaccesoDestino());
      parametrosLocalHome.remove(parametrosLocal);
      

      UtilidadesLog.debug("salio primer finder");
    } catch (NoResultException fe){
       //como no hace nade sigue la ejecucion
    } catch (PersistenceException e){
			ctx.setRollbackOnly();
			String codigoError = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
			this.logearError("eliminarRegistrosDeStock: RemoveException",e);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
     }
    
    try{
           UtilidadesLog.debug("no encontro nada");
           UtilidadesLog.debug("el pais es " + dto.getOidPais());
           UtilidadesLog.debug("el subacceso origen es " + dto.getOidSubaccesoOrigen());
           ParametrosBelcenterLocalHome parametrosLocalHome = this.getParametrosBelcenterLocalHome();
           ParametrosBelcenterLocal parametrosLocal2 = parametrosLocalHome.findByUK(dto.getOidPais(),dto.getOidSubaccesoOrigen());

           ParametrosBelcenterLocal parametrosLocalDestino; 
           parametrosLocalDestino = parametrosLocalHome.create(dto.getOidSubaccesoDestino(),
                                            parametrosLocal2.getDireccion(),
                                            parametrosLocal2.getMontoMaximoDiferencia(),
                                            parametrosLocal2.getLimiteEfectivoCaja(),
                                            parametrosLocal2.getNumeroDeCajas(),
                                            parametrosLocal2.getNombreDeLocal(),
                                            parametrosLocal2.getTiempoDeReposicion(),
                                            parametrosLocal2.getFactorLocal(),
                                            parametrosLocal2.getNumeroMaximoProductos(),
                                            parametrosLocal2.getAlertaStock(),
                                            parametrosLocal2.getUsuario(),
                                            parametrosLocal2.getCliente(),
                                            parametrosLocal2.getEmpresa(),
                                            parametrosLocal2.getTipoTransaccion(),
                                            parametrosLocal2.getCuentaCorriente(),
                                            parametrosLocal2.getTipoMovimientoCobrar(),
                                            parametrosLocal2.getTipoMovimientoCierre(),
                                            parametrosLocal2.getMovimientoConfirmarStock(),
                                            parametrosLocal2.getMovimientoConfirmarStockEnTransito(),
                                            parametrosLocal2.getMovimientoStockEnTransito(),
                                            parametrosLocal2.getMovimientoStockDevolucion(),
                                            parametrosLocal2.getMovimientoRegularizacion(),
                                            parametrosLocal2.getMovimientoRegularizacionSAP(),
                                            parametrosLocal2.getMovimientoDevolverStockExistencias(),
                                            parametrosLocal2.getMovimientoPeticionExistencias(),
                                            parametrosLocal2.getPais());
            parametrosLocalDestino.setTelefono(parametrosLocal2.getTelefono());                                    
            
            parametrosLocalHome.merge(parametrosLocalDestino);

       UtilidadesLog.debug("creo exitosamente"); 
     }catch(NoResultException fex) {
          UtilidadesLog.error(fex);
          ctx.setRollbackOnly();
          throw new MareException(fex,
             UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
         }catch(PersistenceException createException) {
              UtilidadesLog.error(createException);
              ctx.setRollbackOnly();
              throw new MareException(createException,
                  UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
     }catch(Exception exception) {
          UtilidadesLog.error(exception);
           ctx.setRollbackOnly();
          throw new MareException(exception,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
     }
     
     UtilidadesLog.info("MONServicioBELBean.copiarParametrosBelcenter(DTOCopiarParametrosBelcenter dto):Salida");
  
  }


    /**
     * Obtiene los medios de pago segun el oidSubacceso. 
     * @param DTOOID con oid de subacceso
     * @return DTOSalida
     * @exception MareException 
     * @author gdmarzi
     */
    public DTOSalida obtenerMediosPagoBelcenter(DTOOID dto) throws MareException {
        // -> Llamar al método "DAOServicioBEL.obtenerMediosPagoBelcenter(dto : DTOOID) : DTOSalida" 
        UtilidadesLog.info("MONServicioBELBean.obtenerMediosPagoBelcenter(DTOOID dto):Entrada");
    		String usuario = ctx.getCallerPrincipal().getName();
        DAOServicioBel daoServicioBel = new DAOServicioBel(usuario);
        DTOSalida dtoSalida = daoServicioBel.obtenerMediosPagoBelcenter(dto);
        UtilidadesLog.info("MONServicioBELBean.obtenerMediosPagoBelcenter(DTOOID dto):Salida");
        // -> Devolver el DTOSailda - oid de medio de pago belcenter - código de medio de pago + descripción internacionalizada del medio de pago 
        return dtoSalida;
    }


    /**
     * 
     */
    public DTOSalida obtenerTiposMovimientosCajaManuales(DTOBelcorp dtoe) throws  MareException {
        UtilidadesLog.info("MONServicioBELBean.obtenerTiposMovimientosCajaManuales(DTOBelcorp dtoe):Entrada");
        String usuario = ctx.getCallerPrincipal().getName();
        DAOServicioBel daobel = new DAOServicioBel(usuario);
        UtilidadesLog.info("MONServicioBELBean.obtenerTiposMovimientosCajaManuales(DTOBelcorp dtoe):Salida");
        return daobel.obtenerTiposMovimientosCajaManuales(dtoe);
    }


    /**
     * 
     */
    public DTOSalida obtenerTiposMovimientosCaja(DTOBelcorp dtoe) throws  MareException {
        UtilidadesLog.info("MONServicioBELBean.obtenerTiposMovimientosCaja(DTOBelcorp dtoe):Entrada");
        String usuario = ctx.getCallerPrincipal().getName();
        DAOServicioBel daobel = new DAOServicioBel(usuario);
        DTOSalida dtoSalida = daobel.obtenerTiposMovimientosCaja(dtoe);   
        UtilidadesLog.info("MONServicioBELBean.obtenerTiposMovimientosCaja(DTOBelcorp dtoe):Salida");
        return dtoSalida;
    }


    /**
     * Envia un mensaje al administrador si limiteEfectivoCaja es menor a saldoEfectivo.
     * @param DTOOID con el oid de caja, (una caja tiene subacceso y por tanto acceso y canal).
     * @return void
     * @exception MareException 
     * @author gdmarzi
     */
    public void emitirMensajeAdministrador(Long oidCaja, BigDecimal saldoEfectivo, BigDecimal limiteEfectivoCaja) throws MareException {
        UtilidadesLog.info("MONServicioBELBean.emitirMensajeAdministrador(Long oidCaja, BigDecimal saldoEfectivo, BigDecimal limiteEfectivoCaja):Entrada");
        try {
          
            // -> Hallar el e-mail del usuario administrador (Incidencia 10047)
            MareMGC mgc = (MareMGC)MareMii.getService(new MareTopic(MareMii.SERVICE_MGC));
  
            UtilidadesLog.debug("usuario email "  + (String)mgc.getProperty("emailadmin"));
            
            String emailAdministrador = (String)mgc.getProperty("emailadmin");
            
            // (2)Si tiene e-mail entonces 
            if (emailAdministrador != null ) {
                CajaLocalHome cLH = this.getCajaLocalHome();
                CajaLocal     cL  = cLH.findByPrimaryKey(oidCaja) ;
                
                SubaccesoLocalHome subaccesoLocalHome = this.getSubaccesoLocalHome();
                SubaccesoLocal subaccesoLocal = subaccesoLocalHome.findByPrimaryKey(cL.getSubAcceso());
               
                DTOCorreoElectronico dtoCorreoElectronico = new DTOCorreoElectronico();
                dtoCorreoElectronico.setDireccion(emailAdministrador);
                dtoCorreoElectronico.setAsunto("Efectivo de caja " + cL.getCodigoCaja() + " superado.");
                dtoCorreoElectronico.setMensaje("El efectivo actual de la caja " + cL.getCodigoCaja() + 
                                                " es "+ saldoEfectivo + 
                                                " y es mayor que el efectivo máximo permitido que es de " + limiteEfectivoCaja + 
                                                " para el BelCenter " + subaccesoLocal.getCodigo() + ".");
                MONServicioCorreoElectronico servicioCorreo = getMONServicioCorreoElectronicoHome().create();
                servicioCorreo.enviarCorreo(dtoCorreoElectronico);
               } // fin tieme email
        } catch(NoResultException fex) {
            throw new MareException(fex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(MareException me) {
            UtilidadesLog.debug(me);
            throw me;
        } catch(Exception e) {
            UtilidadesLog.debug(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONServicioBELBean.emitirMensajeAdministrador(Long oidCaja, BigDecimal saldoEfectivo, BigDecimal limiteEfectivoCaja):Salida");
    }

    /**
     * Calcula el saldo movimiento caja detalle.
     * Se toman como parametros opcionales el oidCaja, el tipoMedioPago y una fecha.
     * @param DTOMovimientoCajaDetalle
     * @return BigDecimal
     * @exception MareException 
     * @author gdmarzi
     */
    public BigDecimal calcularSaldoMovimientosCajaDetalle(DTOMovimientoCajaDetalle dto) throws MareException  {
        // -> Llamar al método "DAOServicioBEL.calcularSaldoMovimientosCajaDetalle(dto : DTOMovimientosCajaDetalle) : BigDecimal" 
        UtilidadesLog.info("MONServicioBELBean.calcularSaldoMovimientosCajaDetalle(DTOMovimientoCajaDetalle dto):Entrada");
    		String usuario = ctx.getCallerPrincipal().getName();
        DAOServicioBel daoServicioBel = new DAOServicioBel(usuario);
        BigDecimal bigRetorno = daoServicioBel.calcularSaldoMovimientosCajaDetalle(dto);
        UtilidadesLog.info("MONServicioBELBean.calcularSaldoMovimientosCajaDetalle(DTOMovimientoCajaDetalle dto):Salida");
        return bigRetorno;
    }



        

    private MONServicioCorreoElectronicoHome getMONServicioCorreoElectronicoHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONServicioCorreoElectronicoHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONServicioCorreoElectronico"), MONServicioCorreoElectronicoHome.class);
    }

     /**
     * 22/11/2004
     * Llamado al dao para obtener los subaccesos parametrizados en BEL_PARAM_BELCE
     * Se toman como parametros el oid del acceso, el pais y el idioma
     * @param DTOOID
     * @return DTOSalida
     * @author mdolce
     */

  public DTOSalida obtieneSubaccesosPRMBelcenter(DTOOID dto) throws MareException {
     UtilidadesLog.info("MONServicioBELBean.obtieneSubaccesosPRMBelcenter(DTOOID dto):Entrada");
     String usuario = ctx.getCallerPrincipal().getName();
     DAOServicioBel dao = new DAOServicioBel(usuario);
     DTOSalida dtoSalida = dao.obtieneSubaccesosPRMBelcenter(dto);
     UtilidadesLog.info("MONServicioBELBean.obtieneSubaccesosPRMBelcenter(DTOOID dto):Salida");
     return dtoSalida;

     
  }
  

  public DTOSalida obtenerAgrupacionStockCabecera(DTOBelcorp dto) throws MareException
  {
    UtilidadesLog.info("MONServicioBELBean.obtenerAgrupacionStockCabecera(DTOBelcorp dto):Entrada");
    /*Proceso: 
    -> Llamar al método "DAOServicioBEL.obtenerAgrupacionStockCabecera(dto : DTOBelcorp) : DTOSalida" pasando el dto de entrada 
    -> Devolver el DTOSalida obtenido de la llamada anterior*/
    String usuario = this.ctx.getCallerPrincipal().getName();
    DTOSalida salida = null;
    DAOServicioBel daoServicioBel = new DAOServicioBel(usuario);
    
    salida = daoServicioBel.obtenerAgrupacionStockCabecera(dto);
    
    UtilidadesLog.info("MONServicioBELBean.obtenerAgrupacionStockCabecera(DTOBelcorp dto):Salida");
    return salida;
  }

     /**
     * 14/01/2005
     * Llamado al dao para obtener los signos de los tipos de movimientos manuales
     * DTOBelcorp
     * @param DTOBelcorp
     * @return DTOSalida
     * @author mdolce
     */
  public DTOSalida obtenerSignoTiposMovimientosCajaManuales(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("MONServicioBELBean.obtenerSignoTiposMovimientosCajaManuales(DTOBelcorp dtoe):Entrada");
        String usuario = ctx.getCallerPrincipal().getName();
        DAOServicioBel daobel = new DAOServicioBel(usuario);
        DTOSalida dtoSalida = daobel.obtenerSignoTiposMovimientosCajaManuales(dtoe);
        UtilidadesLog.info("MONServicioBELBean.obtenerSignoTiposMovimientosCajaManuales(DTOBelcorp dtoe):Salida");
        return dtoSalida;
    
  }

  public DTOSalida buscarStockProducto(DTOBuscarStockProducto dto) throws MareException {
    //incidencia 12317
    UtilidadesLog.info("MONServicioBELBean.buscarStockProducto(DTOBuscarStockProducto dto):Entrada");
    //Obtiene el stock de los productos según el criterio de búsqueda especificado por el usuario. Consulta paginada. 
    String usuario = ctx.getCallerPrincipal().getName();
    DAOServicioBel daobel = new DAOServicioBel(usuario);
    DTOSalida dtoSalida = daobel.buscarStockProducto(dto);
    UtilidadesLog.info("MONServicioBELBean.buscarStockProducto(DTOBuscarStockProducto dto):Salida");
    return dtoSalida;
  }

  /**
   * Debido a la incidencia BELC300013044 se crea este metodo, el cual calcula el límite
   * y llama al metod emitirMensajeAdministrador con los 2 parametros aquí recividos
   * mas el recuperado
   * @throws es.indra.mare.common.exception.MareException
   * @param saldoEfectivo
   * @param oidCaja
   * @fecha 8/3/2005
   */
  public void emitirMensajeAdministrador(Long oidCaja, BigDecimal saldoEfectivo) throws MareException{
    UtilidadesLog.info("MONServicioBELBean.emitirMensajeAdministrador(Long oidCaja, BigDecimal saldoEfectivo):Entrada");
    try{
        CajaLocalHome cajaHome = this.getCajaLocalHome();
        CajaLocal caja = cajaHome.findByPrimaryKey(oidCaja);
        
        ParametrosBelcenterLocalHome pBLH = this.getParametrosBelcenterLocalHome();
        ParametrosBelcenterLocal     pBL  = pBLH.findByUK(caja.getPais(), caja.getSubAcceso());
        UtilidadesLog.debug("el saldo efectivo " + saldoEfectivo);
        UtilidadesLog.debug("el limite efectivo " + pBL.getLimiteEfectivoCaja());
        if(pBL.getLimiteEfectivoCaja().compareTo(saldoEfectivo) == -1){
           this.emitirMensajeAdministrador( oidCaja, saldoEfectivo, pBL.getLimiteEfectivoCaja());        
        }
     } catch(NoResultException e){
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));    				  
     }  catch (PersistenceException ce) {   
         UtilidadesLog.error("ERROR ", ce);
         throw new MareException(ce, 
         UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
     }
     UtilidadesLog.info("MONServicioBELBean.emitirMensajeAdministrador(Long oidCaja, BigDecimal saldoEfectivo):Salida");
  }
  
// vbongiov -- 29/10/2008
  public DTOOID obtenerCanalVD(DTOString dtoe) throws MareException {
        UtilidadesLog.info("MONServicioBELBean.obtenerCanalVD(DTOString dtoe):Entrada");
                String usuario = ctx.getCallerPrincipal().getName();
                DAOServicioBel daoServicio=new DAOServicioBel(usuario);
                UtilidadesLog.info("MONServicioBELBean.obtenerCanalVD(DTOString dtoe):Salida");
                return daoServicio.obtenerCanalVD(dtoe);
    }


  private MONValidacionHome getMONValidacionHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONValidacionHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONValidacion"), MONValidacionHome.class);
  }

    private AsociacionMaquinaCajaLocalHome getAsociacionMaquinaCajaLocalHome() {
      return new AsociacionMaquinaCajaLocalHome();
    }

    private ParametrosBelcenterLocalHome getParametrosBelcenterLocalHome() {
        return new ParametrosBelcenterLocalHome();
    }

    private CajaLocalHome getCajaLocalHome() {
        return new CajaLocalHome();
    }


    private SubaccesoLocalHome getSubaccesoLocalHome() {
        return new SubaccesoLocalHome();
    }
    
    private StockLocalHome getStockLocalHome() {
        return new StockLocalHome();
    }

   
}
