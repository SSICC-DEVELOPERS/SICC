package es.indra.sicc.logicanegocio.ped;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.dto.DTOBuscarSolicitudesDTO;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.dtos.ped.DTOPeriodoDocumentoReferencia;
import es.indra.sicc.dtos.ped.DTOValoresDefecto;
import es.indra.sicc.dtos.ped.DTOSeguimientoPedidos;
import es.indra.sicc.dtos.ped.DTOArranqueGP;
import es.indra.sicc.dtos.ped.DTOParametroMonitor;
import es.indra.sicc.dtos.pre.DTOSValidarCodigoVenta;
import es.indra.sicc.entidades.bel.CajaLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocal;
import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocalHome;
import es.indra.sicc.entidades.ped.RegistroSolicitudLocal;
import es.indra.sicc.entidades.ped.RegistroSolicitudLocalHome;
import es.indra.sicc.entidades.seg.AccesoLocalHome;
import es.indra.sicc.entidades.seg.AccesoLocal;
import es.indra.sicc.entidades.bel.AsociacionMaquinaCajaLocalHome;
import es.indra.sicc.entidades.bel.AsociacionMaquinaCajaLocal;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.mare.common.dto.MareDTO;

import java.math.BigDecimal;

import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.entidades.bel.CajaLocalHome;
import es.indra.sicc.logicanegocio.bel.MONGenerarMovimientoAlmacenLocal;
import es.indra.sicc.logicanegocio.bel.MONGenerarMovimientoAlmacenLocalHome;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.Cronometrador;

import es.indra.sicc.util.UtilidadesBD;

import java.text.SimpleDateFormat;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONDigitacionInicialBean implements SessionBean  {
    private SessionContext ctx;
    private UtilidadesLog log = new UtilidadesLog();
    
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

    public DTOValoresDefecto obtenerValoresDefecto(DTOValoresDefecto DTOE) throws MareException {
        DAOValoresDefecto daoValores = new DAOValoresDefecto();		
	for (int i=0; i<DTOE.getCampo().length; i++) {
            DTOE = daoValores.obtenerValorDefecto( DTOE, i );
        }
        return DTOE;
    }

    public DTOSalida obtenerTipoDespacho(DTOBelcorp DTOE) throws MareException {
        DAODigitacion daoDigitacion = new DAODigitacion();		
	return new DTOSalida(daoDigitacion.obtenerTipoDespacho(DTOE));
    }

    public DTOSalida obtenerAccesoFisico(DTOBelcorp DTOE) throws MareException {
        DAODigitacion daoDigitacion = new DAODigitacion();		
	return new DTOSalida(daoDigitacion.obtenerAccesoFisico(DTOE));
    }

    public DTOSalida obtenerTiposSolicitudDigitacionVD(DTOBelcorp DTOE) throws MareException {
        DAODigitacion daoDigitacion = new DAODigitacion();		
	return new DTOSalida(daoDigitacion.obtenerTipoSolicitudDigitacionVD(DTOE));
    }

    /**
     * Obtiene el periodo correspondiente al documento de referencia para la soliitud recibida como par�metro.
     */
    public DTOPeriodoDocumentoReferencia obtenerPeriodoDocumentoReferencia(DTOOID dtoe) throws MareException {
        DTOPeriodoDocumentoReferencia dtoPeriodoDocRef;
        DAOSolicitud daoSolicitud = new DAOSolicitud();
        dtoPeriodoDocRef = daoSolicitud.obtenerPeriodoDocumentoReferencia(dtoe.getOid());
        return dtoPeriodoDocRef;
    }

    public DTOSalida buscarSolicitudesDTO(DTOBuscarSolicitudesDTO dtoe) throws MareException {
         //modificado por incidencia 11358
         DAOSolicitud dao = new DAOSolicitud();
         
         UtilidadesLog.debug("GA - DTOBuscarSolicitudesDTO dtoe: "+dtoe);
         
         ClienteDatosBasicosLocalHome clienBLH = null;
         ClienteDatosBasicosLocal clien = null;
         
         try{
            if(dtoe.getCodigoCliente()!=null){
             clienBLH = new ClienteDatosBasicosLocalHome();
             clien = clienBLH.findByCodigoYPais(dtoe.getOidPais(), dtoe.getCodigoCliente());
             dtoe.setOidCliente(clien.getOid());           
            }
         }catch(NoResultException e){
           ctx.setRollbackOnly();
           UtilidadesLog.debug("Exception: ", e);
           throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
         }catch(PersistenceException pe){
           ctx.setRollbackOnly();
           UtilidadesLog.debug("Exception: ", pe);
           throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
         return new DTOSalida(dao.buscarSolicitudesDTO(dtoe));
    }

    private void actualizarLote(DTOCabeceraSolicitud DTOE) throws MareException {
        RegistroSolicitudLocalHome rsLHome = null;
	RegistroSolicitudLocal rsLocal = null;
		// Actualiza el campo numeroDigitadas de la entidad RegistroSolicitud 
	DAOSolicitud dao = new DAOSolicitud();
	Long oidRegistroSolicitud = dao.obtenerResgistroSolicitud(DTOE.getOidCliente());
		// Actualiza el registro de solicitud 
	try {
            if (oidRegistroSolicitud != null)  {
                rsLHome = new RegistroSolicitudLocalHome();
		rsLocal = rsLHome.findByPrimaryKey(oidRegistroSolicitud);
		rsLocal.setNumDigitadas( new Long(1) );					
                try {
                    rsLHome.merge(rsLocal);
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }
        } catch(NoResultException e) {
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch(PersistenceException pe) {
            ctx.setRollbackOnly();
            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
    }

    private DTOCabeceraSolicitud generarNumeroSolicitud(DTOCabeceraSolicitud DTOE) throws MareException {
        UtilidadesLog.info("MONDigitacionInicialBean.generarNumeroSolicitud (DTOCabeceraSolicitud DTOE): Entrada");
        StringBuffer query = new StringBuffer();
        
        query.append("SELECT ("); 
        query.append(" SELECT COD_PAIS"); 
        query.append(" FROM SEG_PAIS"); 
        query.append(" WHERE OID_PAIS = ").append(DTOE.getOidPais());
        query.append(" ) COD_PAIS,"); 
        query.append(" ("); 
        query.append(" SELECT COD_SBAC"); 
        query.append(" FROM SEG_SUBAC"); 
        query.append(" WHERE OID_SBAC = ").append(DTOE.getSubacceso());
        query.append(" ) COD_SBAC"); 
        query.append(" FROM DUAL");
        
        RecordSet rs = null;
        
        rs = UtilidadesBD.executeQuery(query.toString());
        ArrayList arrayParametros = new ArrayList();
        
        if (rs != null && !rs.esVacio()){
            arrayParametros.add(UtilidadesBD.convertirAString(rs.getValueAt(0, "COD_PAIS")));    
            arrayParametros.add(UtilidadesBD.convertirAString(rs.getValueAt(0, "COD_SBAC")));    
        }
        
        arrayParametros.add(ConstantesBEL.COD_PED001);
        SimpleDateFormat sdf = new SimpleDateFormat("yy");
        Date currentYear = new Date( System.currentTimeMillis());
        String yy = sdf.format(currentYear);   
        arrayParametros.add(new Integer(yy)); 
        
        String numeroSolicitud = null;
        try {
            numeroSolicitud = this.getMONDigitacionInicialLocal().ejecutarFuncionGeneraNumeros(arrayParametros);
        } catch (NamingException ne) {
            UtilidadesLog.error("ERROR al localizar un componente EJB",ne);
            throw new MareException(ne);
        }

        StringBuffer numeroFormateado = new StringBuffer();
        numeroFormateado.append(cerosIzq(yy.toString(), 2));
        numeroFormateado.append(cerosIzq(numeroSolicitud, 8));         
        DTOE.setNumeroSolicitud(numeroFormateado.toString());
        UtilidadesLog.info("MONDigitacionInicialBean.generarNumeroSolicitud (DTOCabeceraSolicitud DTOE): Salida");  
        return DTOE;
    }

    private String cerosIzq(String cadenaEntrada, int cantidadCeros) {
        UtilidadesLog.info("MONDigitacionInicialBean.cerosIzq(String cadenaEntrada, int cantidadCeros): Entrada ");
        StringBuffer cadenaSalida = new StringBuffer("");
        for(int i=0; i < cantidadCeros - cadenaEntrada.length() ;i++) {
            cadenaSalida.append("0");
        }
        UtilidadesLog.info("MONDigitacionInicialBean.cerosIzq(String cadenaEntrada, int cantidadCeros): Salida ");
        return cadenaSalida.append(cadenaEntrada.toString()).toString();
    }

	
    public DTOCabeceraSolicitud grabarSolicitud(DTOCabeceraSolicitud DTOE) throws MareException {
		//M�todo que graba una solicitud recibida en la BD. 
		//Antes de nada, deber� validar y generar las posiciones de la solicitud. 
		//La cabecera ya ha sido validada previamente. 

		/* 
		 * Recorremos todas las posiciones de la solicitud (DTOE) y 
		 * para cada una de ellas (contador numeroPosicion) llamamos al m�todo 
		 * generarPosicion del MONGenrarPosicionSolicitud 
		 * con la cabecera de la solicitud y el n�mero de posici�n que ocupa 
		 * */	
   	Boolean errorPosicion = Boolean.FALSE;
        Cronometrador.startTransaction("Digitacion Inicial ---> Generar Posiciones");   	
        try {
            HashMap hashCodigosVenta = new HashMap();
            hashCodigosVenta = this.obtenerCodigosVenta(DTOE); 

            MONGenerarPosicionSolicitudLocalHome mgpLocalHome = (MONGenerarPosicionSolicitudLocalHome)this.getMONGenerarPosicionSolicitudLocalHome();
            MONGenerarPosicionSolicitudLocal mgp = mgpLocalHome.create();

            DTOE = mgp.generarPosiciones(DTOE, hashCodigosVenta);
       
            if (!DTOE.getOK().booleanValue()) {
                errorPosicion = Boolean.TRUE;
            }
        } catch(CreateException ce) {
           UtilidadesLog.error("ERROR" + ce);
           throw new MareException(ce,
           UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(Exception re) {
           UtilidadesLog.error("ERROR" + re);
           throw new MareException(re,
           UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        Cronometrador.endTransaction("Digitacion Inicial ---> Generar Posiciones");   	  
		// Una vez realizada la validaci�n y generaci�n de todas las posiciones, comprobamos si ha ocurrido alg�n error 
		/*
		 * Pablo Perez
		 * 06/12/2004
		 * 
		 * No se tiene en cuenta el atributo OK del DTOCabeceraSolicitud
		 * Sino que se cambio por la variable errorPosicion.
		 */
        Cronometrador.startTransaction("Digitacion Inicial ---> Grabar Solicitud");   	 
	DTOE.setOK(Boolean.valueOf(!errorPosicion.booleanValue()));
        boolean verificacion = false;
        
        if (DTOE.getVerificacion() != null)
            verificacion = DTOE.getVerificacion().booleanValue();

        if (!errorPosicion.booleanValue() && (verificacion == false)) { 
			// Procedemos a guardar la solicitud en BD 
            DTOE = guardarSolicitud(DTOE);

            if ((DTOE.getIndicadorDigitacion() != null) && DTOE.getIndicadorDigitacion().booleanValue()) {
                actualizarLote(DTOE);          
            }
      	}
	Cronometrador.endTransaction("Digitacion Inicial ---> Grabar Solicitud");   	 
	return DTOE;
    }


    private MONGenerarPosicionSolicitudHome getMONGenerarPosicionSolicitudHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONGenerarPosicionSolicitudHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGenerarPosicionSolicitud"), MONGenerarPosicionSolicitudHome.class);
    }

    public DTOCabeceraSolicitud guardarSolicitud(DTOCabeceraSolicitud DTOE) throws MareException {
        UtilidadesLog.info("MONDigitacionInicialBean.guardarSolicitud(DTOCabeceraSolicitud DTOE): Entrada");
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("DTOCabeceraSolicitud recibido: " + DTOE);
        
        TiposSolicitudPaisLocalHome tspLHome = null;
	TiposSolicitudPaisLocal tspLocal = null;
	AccesoLocalHome accesoLHome = null;
	AccesoLocal accesoLocal = null;
        AsociacionMaquinaCajaLocalHome asigMaquinaCajaLHome = null;
        AsociacionMaquinaCajaLocal asigMaquinaCajaL = null;
        CajaLocalHome cajaLHome = null;
        CajaLocal cajaL = null;
        DAOSolicitud daoSol = new DAOSolicitud();
		
		// Graba la cabecera de la solicitud en BD 

		// En primer lugar se comprueba si la solicitud tiene relleno el n�mero de solicitud 
        
	if (DTOE.getNumeroSolicitud() == null ||
            DTOE.getNumeroSolicitud().equals("") ){ 
            DTOE = generarNumeroSolicitud(DTOE);
	} 

		// Verificamos si es el �ltimo proceso de GP1 
        DAOValidaciones daoValidaciones = new DAOValidaciones();
	Boolean ultimoProceso = daoValidaciones.validarUltimoProceso(DTOE.getTipoSolicitud(), ConstantesPED.GP1, DTOE.getProceso());
	if (ultimoProceso.booleanValue()) {
            DTOE.setGrupoProcesos( ConstantesPED.GP1 );
            //Se agrega el estado de solicitud, ya que debe ser estado validado seg�n DECU
            //y AGuardiola.  (Gacevedo)
            DTOE.setEstado(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
	} else {
            // sapaza -- PER-SiCC-2011-0832 -- 24/10/2011
	    if (DTOE.getModulo().longValue() == 13) 
	        DTOE.setGrupoProcesos( ConstantesPED.GP4 );
	    else
	        DTOE.setGrupoProcesos( null );
	    
	}

	if (DTOE.getOidCabeceraSolicitud() == null) {
            // Guarda la cabecera de la solicitud 
            daoSol.guardarCabecera(DTOE);
    
            // Asigna los valores por defecto a la cabecera 
            daoSol.asignarValoresDefectoCabecera(DTOE.getOidCabeceraSolicitud(),DTOE.getTipoSolicitud(), DTOE.getModulo());
    
            // Guarda las posiciones de la solicitud 
            //Recorre todas las posiciones de la solicitud 
            RecordSet valoresDefectoPosicion;
            valoresDefectoPosicion = daoSol.recuperarValoresDefectoPosicion(DTOE.getTipoSolicitud(), DTOE.getModulo());
            DTOE = daoSol.guardarPosicion(DTOE);
            daoSol.asignarValoresDefectoPosicion(DTOE.getOidCabeceraSolicitud(), valoresDefectoPosicion);                
        } else {
            daoSol.modificarCabecera(DTOE);
        }
        


		// Si es el �ltimo proceso de GP1, actualizamos seguimiento de pedidos y comprobamos si se continua con la ejecuci�n on-line 
	if (ultimoProceso.booleanValue()) { 
            try {		
		tspLHome = new TiposSolicitudPaisLocalHome();			
		tspLocal = tspLHome.findByPrimaryKey(DTOE.getTipoSolicitud());

		accesoLHome = new AccesoLocalHome();
		accesoLocal = accesoLHome.findByPrimaryKey( DTOE.getAcceso() );

            } catch(NoResultException e) {
                ctx.setRollbackOnly();
                UtilidadesLog.error("Excepcion: ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch(PersistenceException pe) {
                ctx.setRollbackOnly();
                UtilidadesLog.error("Excepcion: ", pe);
                throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }

	    // sapaza -- PER-SiCC-2011-0477 -- 08/07/2011, se comenta la insercion en PED_SEGUI_PEDID
            /*if (DTOE.getOrdenCompra().booleanValue() && (tspLocal.getIndPedGtZona().booleanValue() || accesoLocal.getCodigo().equals(ConstantesSEG.ACCESO_BELCENTER))) {
					// Actualiza el seguimiento de pedidos 
                DTOSeguimientoPedidos dtoSegui = new DTOSeguimientoPedidos();
		dtoSegui.setSolicitud( DTOE.getOidCabeceraSolicitud()  );
		dtoSegui.setHitoSeguimiento( ConstantesPED.HITO_01  );
		dtoSegui.setTipoDocumento( ConstantesPED.TIPO_DOCUMENTO_PEDIDO  );

		try {
                    MONSeguimientoPedidosLocalHome mSeguiPLocalHome = (MONSeguimientoPedidosLocalHome) this.getMONSeguimientoPedidosLocalHome();
                    MONSeguimientoPedidosLocal mSeguimientoPLocal = mSeguiPLocalHome.create();				
                    mSeguimientoPLocal.actualizarSeguimientoPedidos(dtoSegui);
		} catch(CreateException ce) {
                    throw new MareException(ce,	UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		} catch(NamingException fe) {
                    throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
            }*/
				// Comprobar que los procesos del siguiente grupo (GP2) tienen ejecuci�n on-line 
            DAOGruposProceso daoProceso = new DAOGruposProceso();
            Boolean onLine = daoProceso.esGrupoProcesosOnline(DTOE.getTipoSolicitud(), ConstantesPED.GP2);

            if (onLine.booleanValue()) { 
                if (DTOE.getIP() != null && DTOE.getIP().length() > 0)  {
                    try {
                       asigMaquinaCajaLHome = new AsociacionMaquinaCajaLocalHome();
                       asigMaquinaCajaL = asigMaquinaCajaLHome.findByUK(DTOE.getIP());
                            
                       cajaLHome = new CajaLocalHome();
                       cajaL = cajaLHome.findByPrimaryKey(asigMaquinaCajaL.getOidCaja());
                    } catch (NoResultException nre)  {
                       ctx.setRollbackOnly();
                       nre.printStackTrace();
                       throw new MareException(nre, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                    } catch (PersistenceException ex)  {
                       ctx.setRollbackOnly();  
                       ex.printStackTrace();
                       throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                    } 
                }                    
                ArrayList solicitud = new ArrayList();
		solicitud.add(DTOE.getOidCabeceraSolicitud());

                // sapaza -- PER-SiCC-2012-0805 -- 11/09/2012
		ArrayList listaSolicitudes = daoSol.crearDTOSolicitudValidacion(solicitud, DTOE.getOidPais());

		DTOParametroMonitor dtoParametros = new DTOParametroMonitor();
		dtoParametros.setOidGrupoProceso( ConstantesPED.GP2 );
                dtoParametros.setModoFacturacion( "R" );
                dtoParametros.setFechaFacturacion(new Date(System.currentTimeMillis()));
                if (cajaL != null)
                    dtoParametros.setCodCaja(cajaL.getCodigoCaja()); 

		DTOArranqueGP dtoArranque = new DTOArranqueGP();
		dtoArranque.setListaSolicitudes(listaSolicitudes);
		dtoArranque.setParametros(dtoParametros);
          
                try {
                    MONSecuenciaProcesosLocalHome mSecuenciaPLocalHome = (MONSecuenciaProcesosLocalHome)this.getMONSecuenciaProcesosLocalHome();
                    MONSecuenciaProcesosLocal mSecuenciaLocalP = mSecuenciaPLocalHome.create();				
                    MareDTO salida = mSecuenciaLocalP.ejecutar(dtoArranque);
		} catch(CreateException ce) {
                    ce.printStackTrace();
                    ctx.setRollbackOnly();
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		} catch (MareException ma) {
                    ctx.setRollbackOnly();
                    throw ma;
                } catch(NamingException fe) {              
                    ctx.setRollbackOnly();
                    throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));          
                } catch (Exception e) {
                    e.printStackTrace();
                    ctx.setRollbackOnly();
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));      
                }
            } 
	} 
        UtilidadesLog.info("MONDigitacionInicialBean.guardarSolicitud(DTOCabeceraSolicitud DTOE): Salida");
	return DTOE;
   }


    public DTOSalida obtenerTiposSolicitudPaisNoConsolidados(DTOBelcorp dtoe) throws MareException {
        DAODigitacion daoDigitacion = new DAODigitacion();		
	return daoDigitacion.obtenerTiposSolicitudes(dtoe);
    }

    private HashMap obtenerCodigosVenta(DTOCabeceraSolicitud dtoCabecera) throws MareException {
        UtilidadesLog.info("MONDigitacionInicialBean.obtenerCodigoVenta(DTOEValidarCodigoVenta dtoCodigosVenta): Entrada");
        int count = 0;
        int x = 0;
        String codigosVenta = "";        
        ArrayList arrayPosiciones = dtoCabecera.getPosiciones();       
        StringBuffer query = null;
        
        if (this.verificarCodigosVentaEnPosiciones(arrayPosiciones).booleanValue()){
            query = new StringBuffer();
            query.append("SELECT POD.VAL_CODI_VENT, POD.OID_DETA_OFER, POD.PROD_OID_PROD, POD.IND_DIGI, POD.FOPA_OID_FORM_PAGO ");
            query.append("  FROM PRE_OFERT_DETAL POD, PRE_OFERT PO, PRE_ESTRA PE, PRE_MATRI_FACTU_CABEC PMF ");
            query.append("  WHERE POD.OFER_OID_OFER = PO.OID_OFER ");
            Iterator it = arrayPosiciones.iterator();
            query.append("  AND (");
            
            while (it.hasNext()){
                DTOPosicionSolicitud dtoPos = (DTOPosicionSolicitud) it.next();                
                if (dtoPos.getCodigoVenta() != null){
                    if (count == 0) {
                        codigosVenta = "'" + dtoPos.getCodigoVenta().toString() + "'";
                    } else { 
                        codigosVenta += ",'" + dtoPos.getCodigoVenta().toString() + "'";
                    }
                } else {
                    if(count == 0) {
                        codigosVenta += "''";
                    } else {
                        codigosVenta += ",''";
                    }
                        
                }
                if (count == 999)  {
                    query.append(" POD.VAL_CODI_VENT IN (" + codigosVenta.toString() + ") ");        
                    if (it.hasNext()){
                        query.append("  OR ");
                    }
                    count = 0;
                    codigosVenta = "";
                    x++;                
                } else {
                    if (!it.hasNext()){
                        query.append(" POD.VAL_CODI_VENT IN (" + codigosVenta.toString() + ") ");        
                    }
                    count++;            
                } 
                if (!it.hasNext()){              
                  query.append(")");
                }
            }
            
            if (dtoCabecera.getAcceso() != null) {
                query.append("  AND ( PO.ACCE_OID_ACCE  =  " + dtoCabecera.getAcceso());
                query.append(" 	   	OR PO.ACCE_OID_ACCE IS NULL) ");
            }
            if (dtoCabecera.getSubacceso() != null) {
                query.append("   AND (PO.SBAC_OID_SBAC =  " + dtoCabecera.getSubacceso());
                query.append("   	    OR PO.SBAC_OID_SBAC IS NULL)");  
            }
            query.append(" AND PO.MFCA_OID_CABE = PMF.OID_CABE ");
            query.append(" AND PO.COES_OID_ESTR = PE.OID_ESTR ");
            query.append(" AND PMF.PERD_OID_PERI = " + dtoCabecera.getPeriodo());
            RecordSet rs = null;
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("query: " + query.toString());
            
            rs = this.executeQuery(query.toString());
            
            if (!rs.esVacio()){
                 DTOSValidarCodigoVenta dtoVCV = null;
                 HashMap hashCodigosVenta = new HashMap();
                 for (int i=0;i < rs.getRowCount();i++){
                     dtoVCV = new DTOSValidarCodigoVenta();
                     dtoVCV.setOidDetalleOferta(UtilidadesBD.convertirALong(rs.getValueAt(i,"OID_DETA_OFER")));
                     dtoVCV.setProducto(UtilidadesBD.convertirALong(rs.getValueAt(i,"PROD_OID_PROD")));
                     dtoVCV.setIndicadorDigitableGP(UtilidadesBD.convertirABoolean(rs.getValueAt(i,"IND_DIGI")));
                     dtoVCV.setOidFormaPago(UtilidadesBD.convertirALong(rs.getValueAt(i,"FOPA_OID_FORM_PAGO")));
                     
                     if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                       UtilidadesLog.debug("plp dtoVCV: " + dtoVCV);
                       UtilidadesLog.debug("plp CODIGO VENTA  " + (String)rs.getValueAt(i,"VAL_CODI_VENT"));
                     }  
                     hashCodigosVenta.put((String)rs.getValueAt(i,"VAL_CODI_VENT"),dtoVCV);
                 }
                 UtilidadesLog.info("MONDigitacionInicialBean.obtenerCodigoVenta(DTOEValidarCodigoVenta dtoCodigosVenta): Salida");        
                 return hashCodigosVenta;
            } else {
              UtilidadesLog.info("MONDigitacionInicialBean.obtenerCodigoVenta(DTOEValidarCodigoVenta dtoCodigosVenta): Salida");        
              return null;
            }
        } else {
            UtilidadesLog.info("MONDigitacionInicialBean.obtenerCodigoVenta(DTOEValidarCodigoVenta dtoCodigosVenta): Salida");        
            return null;
        }
    }
    
    
    
    private Boolean verificarCodigosVentaEnPosiciones(ArrayList arrayPosiciones) {
        UtilidadesLog.info("MONDigitacionInicialBean.verificarCodigosVentaEnPosiciones(ArrayList arrayPosiciones): Entrada");        
        UtilidadesLog.debug("arrayPosiciones: " + arrayPosiciones);
    
        DTOPosicionSolicitud dtoPos = null;
        Iterator it = arrayPosiciones.iterator();
        
        while (it.hasNext()){
            dtoPos = (DTOPosicionSolicitud) it.next();
            if (dtoPos.getCodigoVenta() != null && dtoPos.getCodigoVenta().trim().length() > 0){
                UtilidadesLog.info("MONDigitacionInicialBean.verificarCodigosVentaEnPosiciones(ArrayList arrayPosiciones): Salida");
                return Boolean.TRUE;
            }
        }
        UtilidadesLog.info("MONDigitacionInicialBean.verificarCodigosVentaEnPosiciones(ArrayList arrayPosiciones): Salida");
        return Boolean.FALSE;
    }
    
    
    
    private RecordSet executeQuery(String query) throws MareException {
        UtilidadesLog.info("MONDigitacionInicialBean.executeQuery(String query): Entrada");
        RecordSet rs = null;
    
        try {
            BelcorpService belcorpService = BelcorpService.getInstance();
            rs = belcorpService.dbService.executeStaticQuery( query );
        } catch ( Exception ex ) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
        }       
        UtilidadesLog.info("MONDigitacionInicialBean.executeQuery(String query): Salida");
        return rs;
    }
 
  private MONGenerarPosicionSolicitudLocalHome getMONGenerarPosicionSolicitudLocalHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONGenerarPosicionSolicitudLocalHome)context.lookup("java:comp/env/ejb/local/MONGenerarPosicionSolicitud");
  }

  private MONSeguimientoPedidosLocalHome getMONSeguimientoPedidosLocalHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONSeguimientoPedidosLocalHome)context.lookup("java:comp/env/ejb/local/MONSeguimientoPedidos");
  }

  private MONSecuenciaProcesosLocalHome getMONSecuenciaProcesosLocalHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONSecuenciaProcesosLocalHome)context.lookup("java:comp/env/ejb/local/MONSecuenciaProcesos");
  }

  private MONProcesosPEDLocalHome getMONProcesosPEDLocalHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONProcesosPEDLocalHome)context.lookup("java:comp/env/ejb/local/MONProcesosPED");
  }

    private MONDigitacionInicialLocalHome getMONDigitacionInicialLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONDigitacionInicialLocalHome) context.lookup( "java:comp/env/ejb/local/MONDigitacionInicial" );
    }

    public String ejecutarFuncionGeneraNumeros(ArrayList arrayParametros) throws MareException {
        String numeroSolicitud = null;
        try {       
          numeroSolicitud = BelcorpService.getInstance().dbService.ExecuteFunction("OBT_NUM_SOL_OCR", arrayParametros);        
        } catch(Exception e) {
          UtilidadesLog.error("ERROR",e);
          throw new MareException(e);
        } 
        return numeroSolicitud;
    }
    
    private MONDigitacionInicialLocal getMONDigitacionInicialLocal() throws NamingException, MareException {

        MONDigitacionInicialLocalHome localHome = this.getMONDigitacionInicialLocalHome();
        // Se obtiene el interfaz remoto
        MONDigitacionInicialLocal ejb = null;
        try {
            ejb = localHome.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONDigitacionInicialLocalHome",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        return ejb;
    }
}
