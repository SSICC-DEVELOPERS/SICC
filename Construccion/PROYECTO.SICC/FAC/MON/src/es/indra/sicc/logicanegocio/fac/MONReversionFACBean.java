/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.logicanegocio.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.dtos.ccc.DTORevertirCCFac;
import es.indra.sicc.dtos.fac.DTOFACAcumuladoImpuestos;
import es.indra.sicc.dtos.fac.DTOFACCabeceraDocContable;
import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import es.indra.sicc.dtos.fac.DTOFACConsultaFacturas;
import es.indra.sicc.dtos.fac.DTOFACDocumentoSubacceso;
import es.indra.sicc.dtos.fac.DTOFACSecuenciaProcesos;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.dtos.ped.DTOArranqueGP;
import es.indra.sicc.dtos.ped.DTOParametroMonitor;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.entidades.fac.CabeceraDocumentoContableLocal;
import es.indra.sicc.entidades.fac.CabeceraDocumentoContableLocalHome;
import es.indra.sicc.entidades.fac.DocumentoPorSubaccesoLocal;
import es.indra.sicc.entidades.fac.DocumentoPorSubaccesoLocalHome;
import es.indra.sicc.entidades.fac.FormularioLocal;
import es.indra.sicc.entidades.fac.FormularioLocalHome;
import es.indra.sicc.entidades.fac.ParametrosFacturacionLocal;
import es.indra.sicc.entidades.fac.RegistroUnicoVentasLocal;
import es.indra.sicc.entidades.fac.RegistroUnicoVentasLocalHome;
import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.logicanegocio.ape.MONArmadoPedidosHM;
import es.indra.sicc.logicanegocio.ccc.MONCuentasCorrientes;
import es.indra.sicc.logicanegocio.ccc.MONCuentasCorrientesHome;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajes;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesHome;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.ped.MONSecuenciaProcesos;
import es.indra.sicc.logicanegocio.ped.MONSecuenciaProcesosHome;
import es.indra.sicc.logicanegocio.rec.MONActualizarEstadoReclamos;
import es.indra.sicc.logicanegocio.rec.MONActualizarEstadoReclamosHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.BelcorpService;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import java.sql.Date;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.dtos.fac.DTOFACReasignarNumeroDocContable;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;
import es.indra.sicc.entidades.fac.ParametrosFacturacionLocalHome;
import es.indra.sicc.logicanegocio.ape.MONArmadoPedidosHMHome;

import javax.persistence.NoResultException;

public class MONReversionFACBean implements SessionBean  {
	private SessionContext ctx;
	private ArrayList procesosReversibles;  
	private ArrayList secuenciaProcesos;  
	private Character identificador;
	private String grupoReversion;	
  
  /* BELC400000697 - dmorello, 31/08/2007 */
  private String modalidadDistribucion;
  
	private final static String MON_VALIDACION = "MONValidacion";
	
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

	public void desasignarNumeroDocumentoContable(DTOOIDs cabecerasDC) throws MareException {
        UtilidadesLog.info("MONReversionFACBean.desasignarNumeroDocumentoContable(DTOOIDs cabecerasDC): Entrada");
		/*
		 * DAOFACReversion daoReversion = new DAOFACReversion() 

			daoReversion.anularFacturas( cabecerasDC ) 

			daoReversion.anularRUV( cabecerasDC )*/
		//descomentar a partir de aquí:
		DAOFACReversion daoReversion = new DAOFACReversion();

		daoReversion.anularFacturas(cabecerasDC);
		daoReversion.anularRUV(cabecerasDC);
        UtilidadesLog.info("MONReversionFACBean.desasignarNumeroDocumentoContable(DTOOIDs cabecerasDC): Salida");
	}

    // CAMBIOS EN EL METODO POR INCIDENCIA 18507
	public void eliminarMensajeProductoFueraDocumentoLegal(DTOFACCabeceraDocContable dtoDocContable) throws MareException {
        UtilidadesLog.info("MONReversionFACBean.eliminarMensajeProductoFueraDocumentoLegal(DTOFACCabeceraDocContable dtoDocContable): Entrada");

		DAOFACMensajes daoMensajes = new DAOFACMensajes();
		ArrayList mensajes = daoMensajes.obtenerMensajes(dtoDocContable);
        UtilidadesLog.debug("Numero de mensajes: "+mensajes.size());
	    if(mensajes.size() != 0){
            DTOBuzonMensajes dtoMensaje = null;
            Iterator iteMensajes = mensajes.iterator();
            MONGestionMensajes monGestionMensajes= this.getMONGestionMensajes();
            while(iteMensajes.hasNext()){
                dtoMensaje =(DTOBuzonMensajes)iteMensajes.next();
                try{
                    UtilidadesLog.debug("Borro el mensaje con oid: "+dtoMensaje.getOid());
                    monGestionMensajes.eliminaDatosMensaje(dtoMensaje);
                }catch(RemoteException re){
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("*** Error en eliminarMensajeProductoFueraDocumentoLegal",re);
                    String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));					
                }
            }
    
            /*- marcamos el mensaje de facturación como borrado 
    
            daoMensajes.marcarMensajesBorrados( mensajes )*/
    
            daoMensajes.marcarMensajesBorrados(dtoDocContable);
        }
        UtilidadesLog.info("MONReversionFACBean.eliminarMensajeProductoFueraDocumentoLegal(DTOFACCabeceraDocContable dtoDocContable): Salida");
	}
	// ******* Se elimina por incidencia 17582, no se elimina porque se necesita 
    //para los cambios de la incidencia 13532 **********
    
    public void revertirFacturacion(DTOFACCabeceraSolicitud cabeceraSolicitud) throws MareException {
        UtilidadesLog.info("MONReversionFACBean.revertirFacturacion(DTOFACCabeceraSolicitud cabeceraSolicitud): Entrada");
        /*
	   // Esta versión es la que se invoca desde FAC-Generar Registros de Cuenta Corriente, porque BelCenter ha devuelto 
		// una operación incorrecta de cobro 

		DTOSolicitudValidacion solicitud = new DTOSolicitudValidacion( oidSolicitud = cabeceraSolicitud.oidCabeceraSolicitud, 
		oidPais = cabeceraSolicitud.pais, 
		oidTipoSolPais = cabeceraSolicitud.tipoSolicitud, 
		oidSubacceso = cabeceraSolicitud.subacceso ) 
		*/
		DTOSolicitudValidacion solicitud = new DTOSolicitudValidacion();
		solicitud.setOidSolicitud(cabeceraSolicitud.getOidCabeceraSolicitud());
		solicitud.setOidPais(cabeceraSolicitud.getOidPais());
		solicitud.setOidTipoSolPais(cabeceraSolicitud.getTipoSolicitud());
		solicitud.setOidSubAcceso(cabeceraSolicitud.getSubacceso());
    
    solicitud.setFechaProceso((Date)cabeceraSolicitud.getFechaPrevistaFacturacion());
    solicitud.setZona(cabeceraSolicitud.getZona());
    
		if (cabeceraSolicitud.getNumeroSolicitud() != null)
			solicitud.setNumSolicitud(cabeceraSolicitud.getNumeroSolicitud().toString()); //11545

		/*
		DTOArranqueGP dtoArranqueGP = new DTOArranqueGP( new ArrayList( solicitud ), null ) 
    	revertirFacturacion( dtoArranqueGP, null, null )*/

        DTOArranqueGP dtoArranqueGP = new DTOArranqueGP();
		ArrayList listaSolicitudes= new ArrayList();
		listaSolicitudes.add(solicitud);
		dtoArranqueGP.setListaSolicitudes(listaSolicitudes);
		//INCIDENCIA BELC300011381
		dtoArranqueGP.setOidPais(cabeceraSolicitud.getOidPais());

        DTOParametroMonitor parametros= new DTOParametroMonitor();
        parametros.setOidGrupoProceso(ConstantesPED.GP5);

        dtoArranqueGP.setParametros(parametros);
        UtilidadesLog.debug("DTOArranqueGP = "+dtoArranqueGP);
		//this.revertirFacturacion(dtoArranqueGP,null,null); //modificado 
		
        MONSecuenciaProcesos monSecuenciaProcesos = this.getMONSecuenciaProcesos();
        try{
            monSecuenciaProcesos.reversar(dtoArranqueGP, ctx.getCallerPrincipal().getName());        
        }catch(RemoteException re){
            ctx.setRollbackOnly();
            UtilidadesLog.error("*** Error en revertirFacturacion al llamar a monSecuenciaProcesos.reversar(dtoArranqueGP)",re);
			String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
        }
        
        UtilidadesLog.info("MONReversionFACBean.revertirFacturacion(DTOFACCabeceraSolicitud cabeceraSolicitud): Salida");
	} 

    private MONSecuenciaProcesos getMONSecuenciaProcesos() throws MareException {
        UtilidadesLog.info("MONReversionFACBean.getMONSecuenciaProcesos(): Entrada");
        // Se obtiene el interfaz home
        MONSecuenciaProcesosHome home = (MONSecuenciaProcesosHome)UtilidadesEJB.getHome(
            "MONSecuenciaProcesos", MONSecuenciaProcesosHome.class);
            
        // Se obtiene el interfaz remoto
        MONSecuenciaProcesos ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error("*** Error en getMONSecuenciaProcesos",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONReversionFACBean.getMONSecuenciaProcesos(): Salida");
        return ejb;
	}
	
	private MONGestionMensajes getMONGestionMensajes() throws MareException {
		UtilidadesLog.info("MONReversionFACBean.getMONGestionMensajes(): Entrada");
        // Se obtiene el interfaz home
        MONGestionMensajesHome home = (MONGestionMensajesHome)UtilidadesEJB.getHome(
            "MONGestionMensajes", MONGestionMensajesHome.class);
            
        // Se obtiene el interfaz remoto
        MONGestionMensajes ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error("*** Error en getMONGestionMensajes",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONReversionFACBean.getMONGestionMensajes(): Salida");
        return ejb;
	}

    public void revertirFacturacion(DTOArranqueGP dtoArranqueGP, Long pais, String grupoReversion, String user) throws MareException {
        UtilidadesLog.info("MONReversionFACBean.revertirFacturacion(DTOArranqueGP dtoArranqueGP, Long pais, String grupoReversion): Entrada");
        UtilidadesLog.debug("DTO: " + dtoArranqueGP);
        UtilidadesLog.debug("Pais: " + pais);
        UtilidadesLog.debug("Pais del DTOArranqueGP: " + dtoArranqueGP.getOidPais());
        UtilidadesLog.debug("GrupoReversion: " + grupoReversion);
        UtilidadesLog.debug("Usuario: " + user);
        /*
         * // Método sobrecargado 
        // Esta versión se invoca desde PED-Revertir Procesos 
    
        (1) 
    
        this.grupoReversion = grupoReversion 
    
        // Almacenamos en memoria el contenido de la tabla de secuencia de procesos 
        secuenciaProcesos = DAOFACPrecargas.cargarSecuenciaProcesos() 
    
        procesosReversibles = new ArrayList( ConstantesFAC.COD_PROC_GENERAR_REGISTRO_CC, 
        ConstantesFAC.COD_PROC_GENERAR_RUV, 
        ConstantesFAC.COD_PROC_GENERAR_DOC_CONTABLE ) 
    
        Pais pais = PaisHome.findByPrimaryKey( dtoArranqueGP.pais ) 
        identificador = pais.identificador 
        */
        this.grupoReversion = grupoReversion;
        DAOFACPrecargas daoFacPrecargas = new DAOFACPrecargas();
        //modificado por incidencia 14555
        this.secuenciaProcesos = daoFacPrecargas.cargarSecuenciaProcesos(ConstantesPED.GP5,null,null);
        ArrayList procesosTemp = new ArrayList();
        procesosTemp.add(ConstantesFAC.COD_PROC_GENERAR_REGISTRO_CC);
        procesosTemp.add(ConstantesFAC.COD_PROC_GENERAR_RUV);
        procesosTemp.add(ConstantesFAC.COD_PROC_GENERAR_DOC_CONTABLE);
        
        this.procesosReversibles = procesosTemp;
        //UtilidadesLog.debug("Procesos reversibles: "+procesosReversibles);
        PaisLocalHome paisHome = this.getPaisLocalHome();
        PaisLocal paisLocal = null;
        try{
            paisLocal = paisHome.findByPrimaryKey(pais);
        }catch(NoResultException fe){
                ctx.setRollbackOnly();
            UtilidadesLog.error("revertirFacturacion: FinderException",fe);
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
        }
        this.identificador = new Character(paisLocal.getVal_iden().charAt(0));
        
        
        /* BELC400000697 - dmorello, 31/08/2007 */
        ParametrosFacturacionLocalHome paramHome = this.getParametrosFacturacionLocalHome();
        try {
            Collection paramCol = paramHome.findByPais(pais);
            if (paramCol != null && paramCol.size() == 1) {
                ParametrosFacturacionLocal param = (ParametrosFacturacionLocal)paramCol.iterator().next();
                this.modalidadDistribucion = param.getModalidadDistribucion();
                UtilidadesLog.debug("this.modalidadDistribucion: " + this.modalidadDistribucion);
            } else {
                String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                throw new MareException("", UtilidadesError.armarCodigoError(error));
            }
        } catch (NoResultException fex) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fex, UtilidadesError.armarCodigoError(error));
        }
        /* Fin BELC400000697 - dmorello, 31/08/2007 */
       
    
        /*(2) 
    
        DTOSolicitudValidacion consolidado 
        mientras( dtoArranqueGP.listaSolicitudes.tieneElementos ) 
        { 
        consolidado = (DTOSolicitudValidacion)dtoArranqueGP.listaSolicitudes.siguiente 
    
        revertirConsolidado( consolidado ) 
    
        } */
        DTOSolicitudValidacion consolidado = null;
        ArrayList listaSolicitudes = dtoArranqueGP.getListaSolicitudes();
        
        UtilidadesLog.debug("ListaSolicitudes: "+listaSolicitudes);
        Iterator iteListaSolicitudes = listaSolicitudes.iterator();
        //Iterator iteListaSolicitudes  = filtrarSolicitudesIguales(listaSolicitudes).iterator();
        
        //antes de poner a null SOCA_OID_SOLI_CABE, guardo todas las sol. que pertenecen al consolidado
        DAOFACReversion daoReversion = new DAOFACReversion();
        
        /*while(iteListaSolicitudes.hasNext()){
            consolidado = (DTOSolicitudValidacion)iteListaSolicitudes.next();
        }*/
        
        UtilidadesLog.debug("iterador ListaSolicitudes: " + iteListaSolicitudes);
        while(iteListaSolicitudes.hasNext()){
            consolidado = (DTOSolicitudValidacion)iteListaSolicitudes.next();
            UtilidadesLog.debug("Consolidado: "+consolidado);
            this.revertirConsolidado(consolidado, user);
        
            DTOFACCabeceraSolicitud dtoFacCabeceraSolicitud = new DTOFACCabeceraSolicitud();
            dtoFacCabeceraSolicitud.setOidCabeceraSolicitud(consolidado.getOidSolicitud());
              
            daoReversion.eliminarAcumuladoImpuestos(dtoFacCabeceraSolicitud);
        
            // ********** CAMBIO ***************
            // Se añade la eliminacion de los seguimientos de pedidos de los
            // consolidados puesto que al eliminar el consolidado no tiene sentido
            // hacer el seguimiento.
            // Incidencia BELC300018467
            daoReversion.eliminarSeguimientoPedidos(dtoFacCabeceraSolicitud);
        
            // Se elimina el registro de cabecera del consolidado 
            daoReversion.eliminarConsolidado( consolidado );
            
            //se elimina o decrementa el valor de gp5 en el acumulado correspondiente al consolidado...
            //se decrementan contadores de solicitudes contenidas en el consolidado...
            UtilidadesLog.debug("actualizo / borro el registro del consolidado en el acumulado");
            UtilidadesLog.debug("............. y actualizo solicitudes del consolidado");
            this.getMONReversionFACLocal().actualizoAcumulado(consolidado.getOidSubAcceso(), 
                                                              consolidado.getOidTipoSolPais(),
                                                              consolidado.getFechaProceso(),
                                                              consolidado.getZona());
        }                                                  
        
        UtilidadesLog.info("MONReversionFACBean.revertirFacturacion(DTOArranqueGP dtoArranqueGP, Long pais, String grupoReversion): Salida");
    }
    
    private ArrayList filtrarSolicitudesIguales(ArrayList solicitudes){
        ArrayList newSol = new ArrayList();

        for (int i = 0; i<solicitudes.size();i++){
            DTOSolicitudValidacion dto = (DTOSolicitudValidacion)solicitudes.get(i);
            newSol.add(dto);
            for (int j = i+1; j<solicitudes.size();j++){
                DTOSolicitudValidacion dto2 = (DTOSolicitudValidacion)solicitudes.get(j);
                if (dto.getOidSolicitud().longValue() == dto2.getOidSolicitud().longValue()){
                    solicitudes.remove(j);
                    j -=1;
                }
            }
        }
        return newSol;
    }

	public void reasignarNumeroDocumentoContable(DTOOIDs cabecerasDC) throws MareException {
        UtilidadesLog.info("MONReversionFACBean.reasignarNumeroDocumentoContable(DTOOIDs cabecerasDC): Entrada");

		// Se obtienen las cabeceras de documento contable a partir de sus OIDs 
		UtilidadesLog.debug("DTOOIDs cabecerasDC: "+cabecerasDC);
		DAOFACDocumentoContable dao = new DAOFACDocumentoContable(ctx.getCallerPrincipal().getName());
		ArrayList listaCabeceras = dao.obtenerCabecerasDC( cabecerasDC );
		UtilidadesLog.debug("listaCabeceras: "+listaCabeceras);
		// Por cada documento contable, se tratará de regenerar el número y serie de 
		// documento legal 

		String serieDocumentoLegal = "";
		Long numeroDocumentoLegal  = null;

		Collection formularios = null;
		DTOFACDocumentoSubacceso dtoDS = new DTOFACDocumentoSubacceso(); 

		ArrayList listaAcumuladoImpuestos = new ArrayList();
		DTOFACAcumuladoImpuestos dtoAcumulado = null;
		DTOFACCabeceraDocContable cabecera = null;
		DocumentoPorSubaccesoLocalHome documentoPorSubaccesoHome = null;
		DocumentoPorSubaccesoLocal dsa;
        
                Iterator iteraListaCabeceras = listaCabeceras.iterator();
                UtilidadesLog.debug("Mientras haya cabeceras....");			
		while( iteraListaCabeceras.hasNext() ){//1
				
			cabecera = (DTOFACCabeceraDocContable)iteraListaCabeceras.next();
			UtilidadesLog.debug("Obtengo la cabecera: "+cabecera);

			documentoPorSubaccesoHome = this.getDocumentoPorSubaccesoLocalHome();
			try {                            
                            dsa = documentoPorSubaccesoHome.findByUK( cabecera.getSubacceso(),  cabecera.getSociedad(), cabecera.getTipoDocumentoLegal(),cabecera.getOidPais() ); 
                            UtilidadesLog.debug("He obtenido el documento por subacceso con oid: "+dsa.getOid());
			} catch (NoResultException fe){
                                ctx.setRollbackOnly();
				UtilidadesLog.error("*** Error en reasignarNumeroDocumentoContable",fe);
				String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
				throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));					
			}
                        serieDocumentoLegal = dsa.getSerieDocLegal(); 
			numeroDocumentoLegal = dsa.getUltimoNumDocLegal(); 

			UtilidadesLog.debug(" DocumentoPorSubacceso de la cabecera: "+dsa.getOid());
			UtilidadesLog.debug(" Serie  doc legal en DSA: "+serieDocumentoLegal);
			UtilidadesLog.debug(" Ultimo Numero doc legal en DSA: "+numeroDocumentoLegal);            

			FormularioLocalHome formularioHome = this.getFormularioLocalHome();
			FormularioLocal formulario;
			UtilidadesLog.debug("cabecera.getTipoDocumentoLegal: "+ cabecera.getTipoDocumentoLegal());
			try{
                                UtilidadesLog.debug("SE busca el formulario correspondiente con el tipo de documento legal");
				formularios =(Collection) formularioHome.findByTipoDocumento(cabecera.getTipoDocumentoLegal());
			}catch(NoResultException fe){
                                ctx.setRollbackOnly();
				UtilidadesLog.error("*** Error en reasignarNumeroDocumentoContable",fe);
				String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
				throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));					
			}
			
			if (formularios==null){
				UtilidadesLog.error("*** Error en reasignarNumeroDocumentoContable");
				String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
				throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));
			}
			Iterator iteraFormularios = formularios.iterator();
			
			while (iteraFormularios.hasNext()){
				formulario = (FormularioLocal)iteraFormularios.next();//se coge el primero
				UtilidadesLog.debug("Formulario codigo: "+formulario.getCodigo());
				UtilidadesLog.debug("formulario.getOID: "+formulario.getOid());
				UtilidadesLog.debug("formulario.getNumeracionOficial: "+formulario.getNumeracionOficial());
				if(formulario.getNumeracionOficial().booleanValue()!= true){ 
					//Tipo de numeracion libre
                    UtilidadesLog.debug(" [ASF] Numeracion Libre ");
                    Long ejerDocumContaInter = new Long(cabecera.getEjercicioDocumentoContableInterno());
					if(dsa.getUltimoEjercicioDocInterno().longValue() == ejerDocumContaInter.longValue()){
						numeroDocumentoLegal = new Long (dsa.getUltimoNumDocLegal().longValue()+1);
					}else{
						numeroDocumentoLegal = new Long(1);
					}
				}else{
                    //tipo de numeración oficial
                    UtilidadesLog.debug(" [ASF] Numeracion Oficial ");
					numeroDocumentoLegal = new Long (dsa.getUltimoNumDocLegal().longValue()+1);
				}
				break;
			}
            UtilidadesLog.debug(" [ASF] NumeroDocumentoLegal: "+numeroDocumentoLegal);

			//se comprueba si el número de documento legal ha de ser inicializado
			if(dsa.getLimiteNumDocLegal().longValue()>0){
				if(numeroDocumentoLegal.longValue()>dsa.getLimiteNumDocLegal().longValue()){
					// Si es mayor al limite debemos de crear nuevo rango de numeracion oficial
                    UtilidadesLog.debug(" [ASF] Creamos Nuevo rango de numeracion");
    				try{
						MONTratamientosContables monTratamientosHome = this.getMONTratamientosContables();
						dtoDS = monTratamientosHome.activarNuevoRangoNumeracionOficial(cabecera,cabecera.getTipoDocumentoLegal());
					}catch(RemoteException re){
                        ctx.setRollbackOnly();
						UtilidadesLog.error("*** Error en revertirConsolidado al llamar a monTratamientosHome.activarNuevoRangoNumeracionOficial(cabecera,cabecera.getTipoDocumentoLegal());",re);
						String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
						throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
					}
					numeroDocumentoLegal = new Long(dtoDS.getUltimoNumeroDocumentoLegal().intValue());
                    serieDocumentoLegal = dtoDS.getSerieDocumentoLegal();
                    UtilidadesLog.debug(" [ASF] NumeroDocumentoLegal creado: "+numeroDocumentoLegal);
                    UtilidadesLog.debug(" [ASF] SerieDocumentoLegal creado:  "+serieDocumentoLegal);
				}
			}
			//se actualiza el registro de documento por subacceso
            UtilidadesLog.debug("Se actualiza documento por subacceso con los valores Num: "+numeroDocumentoLegal+"  Serie: "+serieDocumentoLegal);
			dsa.setUltimoNumDocLegal(numeroDocumentoLegal);
			dsa.setSerieDocLegal(serieDocumentoLegal);

			//Se actualiza el registro de documento por subacceso
			CabeceraDocumentoContableLocalHome cabeceraDocContHome = this.getCabeceraDocumentoContableLocalHome();
			CabeceraDocumentoContableLocal cabeceraLocal = null;
			try{
                UtilidadesLog.debug("[ASF] Se obtiene la cabecera de la entidad Documentos contables");
                cabeceraLocal = cabeceraDocContHome.findByPrimaryKey(cabecera.getOidCabeceraSolicitud());					
			}catch(FinderException fe){
                ctx.setRollbackOnly();  
				UtilidadesLog.error("*** Error en reasignarNumeroDocumentoContable",fe);
				String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
				throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));						
			}

            UtilidadesLog.debug("Se actualiza la cabecera con los valores Num: "+numeroDocumentoLegal+"  Serie: "+serieDocumentoLegal);
			cabeceraLocal.setSerieDocumentolegal(serieDocumentoLegal);
			cabeceraLocal.setNumeroDocumentoLegal(numeroDocumentoLegal);
            
            Long oidCabeceraDocumentoContable = cabeceraLocal.getOid();
            UtilidadesLog.debug("OID cabecera documento contable: "+oidCabeceraDocumentoContable);
            Long oidCabeceraDocumentoContable2 = cabecera.getOidCabeceraSolicitud();
            UtilidadesLog.debug("OID cabecera documento contable2 (deberia ser igual al valor anterior): "+oidCabeceraDocumentoContable2);

            Long numeroDocumentoContableInterno = cabeceraLocal.getNumDocumentoContableInterno();
            UtilidadesLog.debug("Numero documento contable interno: "+numeroDocumentoContableInterno);
            
	
            
			listaAcumuladoImpuestos = dao.obtenerAcumuladoImpuestos(cabecera);
			Iterator iteraListaAcumuladoImpuestos = listaAcumuladoImpuestos.iterator();
            
            UtilidadesLog.debug(" Numero de AcumuladosImpuestos: "+listaAcumuladoImpuestos.size());
			while(iteraListaAcumuladoImpuestos.hasNext()){
				dtoAcumulado = (DTOFACAcumuladoImpuestos)iteraListaAcumuladoImpuestos.next();
        		//se crea un nuevo registro haciendo uso del método 'create' del entity 
				//RegistroUnicoVentas, tomando los valores del objeto dtoDocContable en curso:
				RegistroUnicoVentasLocalHome registroVentasHome = this.getRegistroUnicoVentasLocalHome();
				try{
                    //por incidencia 15038: comprobamos que el campo NumerodocumentoReferencia no sea
                    //null para poder hacer el casting a Long
                    Long numeroDocumentoRef=null;
                    if (cabecera.getNumeroDocumentoReferencia()!=null) {
                            numeroDocumentoRef=new Long(cabecera.getNumeroDocumentoReferencia().longValue());
                            UtilidadesLog.debug("NumeroDocumentoReferencia!=null "+numeroDocumentoRef);
                    }
                    //por incidencia 22515: comprobamos que el campo NumeroDocumentoInterno no sea
                    //null para poder hacer el casting a Long
                    Long numeroDocumentoInterno=null;
                    if (cabecera.getNumeroDocumentoInterno()!=null) 
                    {
                        numeroDocumentoInterno = new Long(cabecera.getNumeroDocumentoInterno().longValue());
                        UtilidadesLog.debug("NumeroDocumentoInterno!=null "+numeroDocumentoInterno);
                    }
					RegistroUnicoVentasLocal registroLocal = registroVentasHome.create(cabecera.getOidPais(),//Long pais,
								cabecera.getSociedad(),//Long sociedadVenta,
								cabecera.getSubacceso(),// Long subacceso,
								cabecera.getEjercicioDocumentoContableInterno(),// String ejercicioDocumentoInterno, //tipo modificado por 10384
								new java.sql.Date(cabecera.getFechaFacturacion().getTime()),//Date fechaEmision,
								new BigDecimal(dtoAcumulado.getBaseImponibleTotalLocal().floatValue()),//BigDecimal baseImponible,
								new BigDecimal (dtoAcumulado.getTotalImpuestosLocal().floatValue()),// BigDecimal importeImpuesto,
								new BigDecimal (dtoAcumulado.getTotalImporteLocal().floatValue()),// BigDecimal importeTotal,
								cabecera.getPuntoEmision(),// String puntoEmision,
								//se modifica por la incidencia 22515
                                //numeroDocumentoContableInterno,// Long documentoInterno,
                                numeroDocumentoInterno, //Long DocumentoInterno
								cabecera.getNumeroIdentificacionFiscal(),// String numeroIdentificacionFiscal,
								cabecera.getNumeroIdentificacionNacional(),// String numeroIdentificacionNacional,
								null, //String serieDocumentoReferencia,
								//cabecera.getNumeroDocumentoReferencia(),// Integer numeroDocumentoReferencia,
                                numeroDocumentoRef, //cambiado por incidencia 15038. Se paso a Long
								cabecera.getNombre1(),// String nombre1, 
								cabecera.getNombre2(),// String nombre2,
								cabecera.getApellido1(),// String apellido1,
								cabecera.getApellido2(), //String apellido2,
								cabecera.getOidCliente(),//Long cliente,
								new Boolean (false), //Boolean transferenciaGratuita,
								oidCabeceraDocumentoContable2, //Long cabDocContable,
								dtoAcumulado.getOidIndicadorImpuesto(),////Long impuesto,
								cabecera.getTipoDocumentoLegal(),// Long tipoDocumentoLegal,
                                //cambiado a Long por incidencia 15038
								//Comento la siguiente linea para probar si actualiza el numero de documento legal bien
                                //new Long(cabecera.getNumeroDocumentoLegal().longValue()),// Integer numeroDocumentoLegal,
                                numeroDocumentoLegal,
                                //Mismo motivo que la anterior
                                //cabecera.getSerieDocumentoLegal(), //String serieDocumentoLegal,
                                serieDocumentoLegal,
								null,//Long tipoDocumentoReferencia, 
								null,//BigDecimal interesesMora,
								null,//BigDecimal descuento,
								null,//BigDecimal comisiones, 
								null,//BigDecimal flete,
								null, //BigDecimal baseImponibleNeto,
                                // 21993 dmorello 21/04/2006: estado será FALSE
								new Boolean(false),//Boolean estado,
								null,//Boolean facturaGratuita,
								null,//Date fechaCierre,
								ConstantesFAC.ESTADO_RUV_ACTIVO,// String estadoRUV,
								null//String documentoInternoHipersale
                                                                ,null
                                                                ,null
                                                                ,null
								);
				}catch(CreateException ce){
					ctx.setRollbackOnly();
					UtilidadesLog.error("*** Error en reasignarNumeroDocumentoContable",ce);
					String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
					throw new MareException(ce, UtilidadesError.armarCodigoError(codigoError));	
				}
			}
				
		}//1
        UtilidadesLog.info("MONReversionFACBean.reasignarNumeroDocumentoContable(DTOOIDs cabecerasDC): Salida");
	}


    private void revertirConsolidado(DTOSolicitudValidacion consolidado, String user) throws MareException{
        UtilidadesLog.info("MONReversionFACBean.revertirConsolidado(DTOSolicitudValidacion consolidado): Entrada");
    
        /*
        * /////////////////////////////////////////// 
        // Realiza la reversión de un consolidado 
        /////////////////////////////////////////// */
        Boolean flagP510 = new Boolean(false); 
        Boolean flagP515 = new Boolean(false); 
        Boolean flagP520 = new Boolean(false);
        
        /*// De la variable 'secuenciaProcesos' se seleccionan aquellos objetos (DTOFACSecuenciaProcesos) 
        // que cumplan las siguientes condiciones 
        ArrayList listaProcesos = secuenciaProcesos( grupoProcesos = ConstantesFAC.COD_GP5, 
        tipoSolicitud = consolidado.oidTipoSolPais ) */
        Iterator iteraSecuenciaProcesos = this.secuenciaProcesos.iterator();
        DTOFACSecuenciaProcesos dtoFACSecuenciaProcesos = null;
        ArrayList listaProcesos = new ArrayList();
        while (iteraSecuenciaProcesos.hasNext()){
          dtoFACSecuenciaProcesos = (DTOFACSecuenciaProcesos)iteraSecuenciaProcesos.next();
          if(dtoFACSecuenciaProcesos.getGrupoProcesos().equals(ConstantesFAC.COD_GP5) && dtoFACSecuenciaProcesos.getTipoSolicitud().equals(consolidado.getOidTipoSolPais())){
            listaProcesos.add(dtoFACSecuenciaProcesos);
          }
        }
        // Se ordena el array 'listaProcesos', en orden decreciente del atributo 'secuencia' (11534 -> no es necesario ordenar el array) 
        
        /*
         * // De 'listaProcesos', se eliminan aquellos elementos cuyo atributo 'codigoProceso'
         * no esté en la lista 'procesosReversibles' 
          // Además, al recorrer la lista de procesos, 
          vamos marcando si contiene los procesos reversibles que consideramos, es decir, P510, P515, P520 
        */
        /*
         * DTOFACSecuenciaProcesos dtoSecuencia 
          mientras( listaProcesos.tieneElementos ) 
          { 
          dtoSecuencia = (DTOFACSecuenciaProcesos )listaProcesos.siguiente 
          Si( !procesosReversibles.contiene( dtoSecuencia.codigoProceso ) ) 
          { 
          listaProcesos.eliminar( dtoSecuencia ) 
          } 
          Si no 
          { 
          switch( dtoSecuencia.codigoProceso ) 
          { 
          ConstantesFAC.COD_PROC_GENERAR_REGISTRO_CC : flagP510 = true; 
          ConstantesFAC.COD_PROC_GENERAR_RUV : flagP515 = true; 
          ConstantesFAC.COD_PROC_GENERAR_DOC_CONTABLE : flagP520 = true; 
          } 
          } 
          } 
          */
            UtilidadesLog.debug(" -> Lista Procesos: "+listaProcesos);
            
        for ( int i = 0; i < listaProcesos.size(); i++) {
                Boolean flagRemove = new Boolean (false);
          dtoFACSecuenciaProcesos = (DTOFACSecuenciaProcesos)listaProcesos.get(i);
    
          if (!this.procesosReversibles.contains(dtoFACSecuenciaProcesos.getCodigoProceso())) {
                flagRemove = new Boolean (true);
                            UtilidadesLog.debug("FLAG REMOVE Activo");
                            UtilidadesLog.debug(" CODIGO PROCESO NO REVERSIBLE: "+dtoFACSecuenciaProcesos.getCodigoProceso());
          } else {	//INCIDENCIA	BELC300011417 */
    
            if(dtoFACSecuenciaProcesos.getCodigoProceso().equals(ConstantesFAC.COD_PROC_GENERAR_DOC_CONTABLE)){
              flagP510 = new Boolean (true);
                        UtilidadesLog.debug("FLAG 510 Activo");
            }else if(dtoFACSecuenciaProcesos.getCodigoProceso().equals(ConstantesFAC.COD_PROC_GENERAR_RUV)){
              flagP515 =new Boolean (true);
                        UtilidadesLog.debug("FLAG 515 Activo");
            }else if(dtoFACSecuenciaProcesos.getCodigoProceso().equals(ConstantesFAC.COD_PROC_GENERAR_REGISTRO_CC)){
              flagP520 = new Boolean (true);
                        UtilidadesLog.debug("FLAG 520 Activo");
            }
          }
          if(flagRemove.booleanValue()) {
            listaProcesos.remove(i);
            i--;
          }
        }//fin del for
        /*
         * (4) 
        // Si se han recuperado los códigos de proceso "P510" o "P515", hay que actúar sobre las entidades 
        // de documentos contables 
    
        Si( listaProcesos.contiene( ConstantesFAC.COD_PROC_GENERAR_DOC_CONTABLE OR 
                listaProcesos.contiene( ConstantesFAC.COD_PROC_GENERAR_RUV ) 
          { 
        // Se recuperan los documentos contables generados por el consolidado tratado 
        DAOFACDocumentoContable daoDC = new DAOFACDocumentoContable() 
        ArrayList listaOIDs = new ArrayList( ) 
        listaOIDs.add( consolidado.oidSolicitud ) 
        ArrayList listaDC = daoDC.obtenerDocumentosConsolidado( listaOIDs ) 
    
        DAOFACReversion daoReversion = new DAOFACReversion() */
        DAOFACReversion daoReversion = new DAOFACReversion();
    
        //INCIDENCIA	BELC300011417   
        if( flagP510.booleanValue() || flagP515.booleanValue()){
            UtilidadesLog.debug("REVERSION P510 - P515");
            DAOFACDocumentoContable daoDC = new DAOFACDocumentoContable(ctx.getCallerPrincipal().getName());
            Long [] arrayOids= new Long[1];
            arrayOids[0] = consolidado.getOidSolicitud();
            DTOOIDs dtoOids= new DTOOIDs();
            dtoOids.setOids(arrayOids);
            ArrayList listaDC = daoDC.obtenerDocumentosConsolidado(dtoOids);
            UtilidadesLog.debug("Numero documentoscosolidados: "+listaDC.size());				
              
            /*/////////////////////////////////////////////////////// 
            /// INICIO BUCLE POR DOCUMENTO CONTABLE 
            /////////////////////////////////////////////////////// 
      
            DTOFACCabeceraDocContable cabeceraDC 
            mientras( listaDC.tieneElementos ) 
            { 
            cabeceraDC = (DTOFACCabeceraDocContable)listaDC.siguiente */
            DTOFACCabeceraDocContable cabeceraDC = null;
            Iterator iteraListaDC = listaDC.iterator();
            while(iteraListaDC.hasNext()){
                cabeceraDC = (DTOFACCabeceraDocContable)iteraListaDC.next();
                //(5) 
                // Eliminación de los mensajes asociados 
                eliminarMensajeProductoFueraDocumentoLegal( cabeceraDC );
                //UtilidadesLog.info(" %%%%%%%%%%% ATENCION!!!!EliminarMensajesProductoFueraDocumentoLegaL COMENTADO!!!!");
                //(6) 
                // Se anula el registro único de venta, si el consolidado tiene asociado el proceso P515 
                if(flagP515.booleanValue() ) { 
                    UtilidadesLog.debug("FLAG P515 -> LLamar AnularRegistroUnicoVentas");
                    daoReversion.anularRegistroUnicoVentas( cabeceraDC ) ;
                } 
                //(7) 
                // Se elimina el documento contable 
                // Primero se eliminan los registros de acumulados de impuestos 
                UtilidadesLog.debug("LLamar eliminarAcumuladoImpuestos");
                daoReversion.eliminarAcumuladoImpuestos( cabeceraDC ); 
                // Eliminamos los registros de linea de documento contable 
                UtilidadesLog.debug("LLamar eliminarPosicionesDocumentoContable");
                daoReversion.eliminarPosicionesDocumentoContable( cabeceraDC ); 
                // Eliminamos el registro de cabecera 
                CabeceraDocumentoContableLocalHome cabeceraHome = this.getCabeceraDocumentoContableLocalHome();
                CabeceraDocumentoContableLocal cabeceraLocal = null;
                try{
                  cabeceraLocal = cabeceraHome.findByPrimaryKey( cabeceraDC.getOidCabeceraSolicitud() ); //11524
                }catch(FinderException fe){
                            ctx.setRollbackOnly();
                  UtilidadesLog.error("revertirConsolidado: FinderException de cabeceraContable",fe);
                  String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                  throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));	
                }
                try{
                            UtilidadesLog.debug("LLamar cabeceraLocal.remove()");
                  cabeceraLocal.remove();		
                }catch(RemoveException re){
                            ctx.setRollbackOnly();
                  String codigoError = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
                  UtilidadesLog.error("revertirConsolidado: RemoveException de cabeceraContable",re);
                  throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));  
                }
        
                //(8) 
                /// REVERSIÓN DE LAS CUENTAS CORRIENTES 
                UtilidadesLog.debug("REVERSION DE LAS CUENTAS CORRIENTES");
                //INCIDENCIA	BELC300011417     
                if(flagP520.booleanValue()){
                  UtilidadesLog.debug("P520 -> Cuentas corrientes");
                  String idCuota = null;
                  ArrayList listaOID = new ArrayList();
                  listaOID.add(consolidado.getOidSolicitud());
                  //listaOID.add(consolidado);
                  DAOSolicitudCabecera daoSC = new DAOSolicitudCabecera();
                  DTOFACCabeceraSolicitud solicitud = (DTOFACCabeceraSolicitud)(daoSC.obtenerCabecerasSolicitud(listaOID)).get(0);
                  if (this.identificador.equals(ConstantesFAC.ID_BOLETA) || solicitud.getNumeroDocumentoContableInterno() == null) {
                      idCuota = consolidado.getNumSolicitud();
                  } else if (this.identificador.equals(ConstantesFAC.ID_FACTURA) && solicitud.getNumeroDocumentoContableInterno() != null) {
                      idCuota = solicitud.getNumeroDocumentoContableInterno().toString();
                  }
                  DTORevertirCCFac dtoRevertirCCFac = new DTORevertirCCFac();
                  dtoRevertirCCFac.setOidSubacceso(cabeceraDC.getSubacceso());
                  dtoRevertirCCFac.setNumIdentCuota(idCuota.toString());
                  dtoRevertirCCFac.setOidEmpresa(cabeceraDC.getSociedad());
                  dtoRevertirCCFac.setOidPais(cabeceraDC.getOidPais()); // CAMBIADO POR INCIDENCIA 11752
                  try{
                    MONCuentasCorrientes monCuentasCorrientes = this.getMONCuentasCorrientes();
                                UtilidadesLog.debug("LLAMADA monCuentasCorrientes.revertirCCFac ");
                                dtoRevertirCCFac.setAppLogUser(user);
                                UtilidadesLog.debug("DTO dtoRevertirCCFac:  "+dtoRevertirCCFac);
                    monCuentasCorrientes.revertirCCFac(dtoRevertirCCFac);
                  }catch(RemoteException re){
                                ctx.setRollbackOnly();
                    UtilidadesLog.error("*** Error en revertirConsolidado al llamar a monCuentasCorrientes.revertirCCFac(dtoRevertirCCFac)",re);
                    String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));							
                  }
                    
                } //fin del if P520
                
            }//fin del while
    
        }//fin del  if P510 o P515
        
        /* BELC400000697 - dmorello, 31/08/2007 */
        UtilidadesLog.debug("MODALIDAD_DISTRIBUCION_APE: " + ConstantesFAC.MODALIDAD_DISTRIBUCION_APE);
        UtilidadesLog.debug("this.modalidadDistribucion: " + this.modalidadDistribucion);
        if (ConstantesFAC.MODALIDAD_DISTRIBUCION_APE.equals(this.modalidadDistribucion)) {
            try {
                UtilidadesLog.debug("Voy a ejecutar Revertir armado pedidos");
                MONArmadoPedidosHM monArmado = this.getMONArmadoPedidosHMHome().create();
                DTOOID dtoOid = new DTOOID();
                dtoOid.setOid(consolidado.getOidSolicitud());
                monArmado.revertirArmadoPedidos(dtoOid);
            } catch (CreateException cex) {
                String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(cex, UtilidadesError.armarCodigoError(error));
            } catch (RemoteException re) {
                String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(error));
            }
        }
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer delete = new StringBuffer();
        delete.append("DELETE FROM FAC_SECUE_DOCUM_INTER ");
        delete.append("WHERE SOCA_OID_SOLI_CABE = ").append(consolidado.getOidSolicitud());
        try {
            bs.dbService.executeUpdate(delete.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        /* Fin BELC400000697 - dmorello, 31/08/2007 */
        
        //(9) 
        /*///////////////////////////////////////////////////////////////////////////// 
        /// ACTUALIZACIÓN DE LAS SOLICITUDES ORIGEN DEL CONSOLIDADO 
        ///////////////////////////////////////////////////////////////////////////// */
    
        // Obtenemos el código de proceso con el que actualizaremos las solicitudes origen 
        // Para ello, se busca en la variable 'secuenciaProcesos' aquellos objetos DTOFACSecuenciaProcesos que 
        // cumplan las siguientes condiciones: 
          
        // *************  añadido  ************************
        DAOFACPrecargas daoPrecargas = new DAOFACPrecargas();
        UtilidadesLog.debug("LLAMADA Carga secuencia procesos GP4 ");
        ArrayList secuenciaProcesosGP4 = daoPrecargas.cargarSecuenciaProcesos(ConstantesPED.GP4,null,null);
            
        //incidencia 11509 se realiza primero la actualizacion de posiciones y luego la de solicitudes
                  
        ArrayList listaSolicitudesOrigen = daoReversion.obtenerSolicitudesOrigen( consolidado );
        UtilidadesLog.debug(" Solicitudes Origen: "+listaSolicitudesOrigen);
        
        // Se actualizan las posiciones origen 
        daoReversion.actualizarPosicionesOrigen( listaSolicitudesOrigen );
            
            //******Cambio por incidencia 15191
        DTOFACCabeceraSolicitud cabeceraSolicitud = null;
        Iterator iteraListaSoli = listaSolicitudesOrigen.iterator();
        MONActualizarEstadoReclamos monReclamosHome = this.getMONActualizarEstadoReclamos();
        while(iteraListaSoli.hasNext()){
            cabeceraSolicitud = (DTOFACCabeceraSolicitud)iteraListaSoli.next();
            UtilidadesLog.debug("El modulo origen es: "+cabeceraSolicitud.getModulo());
            if(cabeceraSolicitud.getModulo().equals(new Long(ConstantesSEG.MODULO_REC))){
                try{
                    monReclamosHome.actualizarEstadoReclamosRevertirFacturacion(cabeceraSolicitud);
                }catch (RemoteException re){
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("*** Error en revertirConsolidado al llamar a monActualizarEstadoReclamos.actualizarEstadoReclamosRevertirFacturacion(cabeceraSolicitud)",re);
                    String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));		
                }           
            }
        }        
    
        // Actualizamos los registros de solicitud origen del consolidado 
        daoReversion.actualizarSolicitudesOrigen(consolidado, grupoReversion, ConstantesPED.GP4, secuenciaProcesosGP4);
        
        //
    
        /// Se elimina el registro del consolidado 
        /**
         * Se mueve al metodo que lo invoca
         */
        // Eliminamos los registros de impuestos acumulados correspondientes al consolidado
        /*DTOFACCabeceraSolicitud dtoFacCabeceraSolicitud = new DTOFACCabeceraSolicitud();
        dtoFacCabeceraSolicitud.setOidCabeceraSolicitud(consolidado.getOidSolicitud());
          
        daoReversion.eliminarAcumuladoImpuestos(dtoFacCabeceraSolicitud);
    
        // ********** CAMBIO ***************
        // Se añade la eliminacion de los seguimientos de pedidos de los
        // consolidados puesto que al eliminar el consolidado no tiene sentido
        // hacer el seguimiento.
        // Incidencia BELC300018467
        daoReversion.eliminarSeguimientoPedidos(dtoFacCabeceraSolicitud);
    
        // Se elimina el registro de cabecera del consolidado 
        daoReversion.eliminarConsolidado( consolidado );*/
    
        UtilidadesLog.info("MONReversionFACBean.revertirConsolidado(DTOSolicitudValidacion consolidado): Salida");
    }

    private CabeceraDocumentoContableLocalHome getCabeceraDocumentoContableLocalHome() throws MareException {
        UtilidadesLog.info("MONReversionFACBean.getCabeceraDocumentoContableLocalHome(): Entrada");
        CabeceraDocumentoContableLocalHome cabeceraDocumentoContableHome = (CabeceraDocumentoContableLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/CabeceraDocumentoContable");
        UtilidadesLog.info("MONReversionFACBean.getCabeceraDocumentoContableLocalHome(): Salida");
        return cabeceraDocumentoContableHome;
    }
	private MONCuentasCorrientes getMONCuentasCorrientes() throws MareException {
	    // Se obtiene el interfaz home
		UtilidadesLog.info("MONReversionFACBean.getMONCuentasCorrientes(): Entrada");
        MONCuentasCorrientesHome home = (MONCuentasCorrientesHome)UtilidadesEJB.getHome(
        "MONCuentasCorrientes", MONCuentasCorrientesHome.class);
        // Se obtiene el interfaz remoto
        MONCuentasCorrientes ejb = null;
        try {
			ejb = home.create();
		} catch (Exception e) {
		
			UtilidadesLog.error("*** Error en getMONCuentasCorrientes",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		} 
		UtilidadesLog.info("MONReversionFACBean.getMONCuentasCorrientes(): Salida");
        return ejb;
	}
	private MONTratamientosContables getMONTratamientosContables() throws MareException {
	    // Se obtiene el interfaz home
		UtilidadesLog.info("MONReversionFACBean.getMONTratamientosContables(): Entrada");
        MONTratamientosContablesHome home = (MONTratamientosContablesHome)UtilidadesEJB.getHome(
        "MONTratamientosContables", MONTratamientosContablesHome.class);
        // Se obtiene el interfaz remoto
        MONTratamientosContables ejb = null;
        try {
			ejb = home.create();
		} catch (Exception e) {
		
			UtilidadesLog.error("*** Error en getMONTratamientosContables",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		} 
		UtilidadesLog.info("MONReversionFACBean.getMONTratamientosContables(): Salida");
        return ejb;
	}


    private RegistroUnicoVentasLocalHome getRegistroUnicoVentasLocalHome() throws MareException {
		UtilidadesLog.info("MONReversionFACBean.getRegistroUnicoVentasLocalHome(): Entrada");
		RegistroUnicoVentasLocalHome RegistroUnicoVentasHome = (RegistroUnicoVentasLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/RegistroUnicoVentas");
		UtilidadesLog.info("MONReversionFACBean.getRegistroUnicoVentasLocalHome(): Salida");
		return RegistroUnicoVentasHome;
	}

	public DTOSalida consultarFacturas(DTOFACConsultaFacturas dtoE) throws MareException {
		UtilidadesLog.info("MONReversionFACBean.consultarFacturas(DTOFACConsultaFacturas dtoE): Entrada");
		String usuario = ctx.getCallerPrincipal().getName();
		DAOFACReversion dao = new DAOFACReversion(usuario);
		DTOSalida dtoS = dao.consultarFacturas(dtoE);
		
		UtilidadesLog.info("MONReversionFACBean.consultarFacturas(DTOFACConsultaFacturas dtoE): Salida");
		return dtoS;
	}
	 private MONValidacion getMONValidacion() throws MareException {
        UtilidadesLog.info("MONReversionFACBean.getMONValidacion(): Entrada");

        // Se obtiene el interfaz home
        MONValidacionHome home = (MONValidacionHome) UtilidadesEJB.getHome(MON_VALIDACION,
                MONValidacionHome.class);

        // Se obtiene el interfaz remoto
        MONValidacion ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error("*** Error en getMONValidacion", e);
           
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONReversionFACBean.getMONValidacion(): Salida");

        return ejb;
    }

    private String cerosIzq(String cadena1, int cantidad) {
        UtilidadesLog.info("MONReversionFACBean.cerosIzq(String cadena1, int cantidad): Entrada");
        StringBuffer cantCeros = new StringBuffer("");
        for(int i=0; i < cantidad - cadena1.length() ;i++) {
            cantCeros.append("0");
        }
      
        StringBuffer cadena2 = new StringBuffer(cantCeros.toString());
        cadena2.append(cadena1);
        UtilidadesLog.info("MONReversionFACBean.cerosIzq(String cadena1, int cantidad): Salida");  
        return cadena2.toString();
    }    
    
    private MONActualizarEstadoReclamos getMONActualizarEstadoReclamos() throws MareException {
	    // Se obtiene el interfaz home
		UtilidadesLog.info("MONReversionFACBean.getMONActualizarEstadoReclamos(): Entrada");
        MONActualizarEstadoReclamosHome home = (MONActualizarEstadoReclamosHome)UtilidadesEJB.getHome(
        "MONActualizarEstadoReclamos", MONActualizarEstadoReclamosHome.class);
        // Se obtiene el interfaz remoto
        MONActualizarEstadoReclamos ejb = null;
        try {
			ejb = home.create();
		} catch (Exception e) {
		
			UtilidadesLog.error("*** Error en getMONActualizarEstadoReclamos",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		} 
		UtilidadesLog.info("MONReversionFACBean.getMONActualizarEstadoReclamos(): Salida");
        return ejb;
	}

    public void revertirFacturacionOffLine(DTOArranqueGP dtoArranqueGP, Long pais, String grupoReversion, String user) throws MareException{
        UtilidadesLog.info("MONReversionFACBean.revertirFacturacionOffLine(DTOArranqueGP dtoArranqueGP, Long pais, String grupoReversion, String user): Entrada");
        this.revertirFacturacion(dtoArranqueGP, pais, grupoReversion, user);
        UtilidadesLog.info("MONReversionFACBean.revertirFacturacionOffLine(DTOArranqueGP dtoArranqueGP, Long pais, String grupoReversion, String user): Salida");
    }

    public void actualizoAcumulado(Long subAcceso, Long tipoSoliPais, Date fecProg, Long oidZona) throws MareException
    {
        UtilidadesLog.info("MONReversionFACBean.actualizoAcumulado(Long subAcceso, Long tipoSoliPais, Date fecProg, Long oidZona, int GP, ArrayList solConsolidadas): Entrada");
        UtilidadesLog.debug("recibo " +subAcceso+"-"+tipoSoliPais+"-"+fecProg+"-"+oidZona);
        
        //elimino o decremento en uno la cantidad de consolidados para estos datos en GP5
        DAOFACReversion daoReversion = new DAOFACReversion();  
        daoReversion.actualizoAcumConsolidado(subAcceso, tipoSoliPais, fecProg, oidZona);
        
        //se decrementan contadores de solicitudes contenidas en el consolidado...
        //daoReversion.actualizoAcumSolOrigen(solConsolidadas);        
        
        UtilidadesLog.info("MONReversionFACBean.actualizoAcumulado(Long subAcceso, Long tipoSoliPais, Date fecProg, Long oidZona, int GP, ArrayList solConsolidadas): Salida");
    }
    

    private MONReversionFACHome getMONReversionFACHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONReversionFACHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONReversionFAC"), MONReversionFACHome.class);
    }
    
    private MONReversionFACLocal getMONReversionFACLocal() throws MareException {
	    // Se obtiene el interfaz home
        MONReversionFACLocalHome localHome = (MONReversionFACLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/MONReversionFAC");
        // Se obtiene el interfaz remoto
        MONReversionFACLocal ejb = null;
        try {
            ejb = localHome.create();
        } catch (Exception e) {
            UtilidadesLog.error("ERROR",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        return ejb;
    }    

    private MONReversionFACLocalHome getMONReversionFACLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONReversionFACLocalHome)context.lookup("java:comp/env/MONReversionFAC");
    }

  public DTOFACReasignarNumeroDocContable reasignarNumeroDocumentoContableAsignar(DTOFACReasignarNumeroDocContable dtoFacReasignar) throws MareException
  {
    StringBuffer query = new StringBuffer();
    //  Modificado por HRCS - Fecha 29/05/2007 - Cambio Sicc20070258
    query.append(" SELECT SUM(CANT_DOC_IMPR) CANT_DOC_IMP, SUM(CANT_DOC_NOIMPR) CANT_DOC_NOIMP, SUM(NUM_REG_NONULOS) NUM_REG_NONULO ");
    query.append(" FROM ( ");
    query.append("  SELECT COUNT(*) as CANT_DOC_IMPR, 0 as CANT_DOC_NOIMPR, 0 as NUM_REG_NONULOS ");
    query.append("  FROM FAC_DOCUM_CONTA_CABEC DCC");
    query.append("  WHERE DCC.SBAC_OID_SBAC = " + dtoFacReasignar.getOidSubAcceso());
	query.append("   AND DCC.TIDO_OID_TIPO_DOCU = " + dtoFacReasignar.getOidTipoDocContable());
	query.append("   AND DCC.VAL_EJER_DOCU_INTE = '" + dtoFacReasignar.getEjercicio() + "'");
	query.append("   AND DCC.NUM_DOCU_CONT_INTE BETWEEN " + dtoFacReasignar.getRangoDocInternoDesde() + " AND " + dtoFacReasignar.getRangoDocInternoHasta());
    query.append("   AND DCC.IND_IMPR = 1 ");
    query.append("  UNION ");
    query.append("  SELECT 0 as CANT_DOC_IMPR, COUNT(*) as CANT_DOC_NOIMPR, 0 as NUM_REG_NONULOS ");
    query.append("  FROM FAC_DOCUM_CONTA_CABEC DCC");
    query.append("  WHERE DCC.SBAC_OID_SBAC = " + dtoFacReasignar.getOidSubAcceso());
	query.append("   AND DCC.TIDO_OID_TIPO_DOCU = " + dtoFacReasignar.getOidTipoDocContable());
	query.append("   AND DCC.VAL_EJER_DOCU_INTE = '" + dtoFacReasignar.getEjercicio() + "'");
	query.append("   AND DCC.NUM_DOCU_CONT_INTE BETWEEN " + dtoFacReasignar.getRangoDocInternoDesde() + " AND " + dtoFacReasignar.getRangoDocInternoHasta());
    query.append("   AND DCC.IND_IMPR = 0 ");
	query.append("  UNION ");
    query.append("  SELECT 0 as CANT_DOC_IMPR, 0 as CANT_DOC_NOIMPR, COUNT(*) as NUM_REG_NONULOS ");
    query.append("  FROM FAC_DOCUM_CONTA_CABEC DCC");
    query.append("  WHERE DCC.SBAC_OID_SBAC = " + dtoFacReasignar.getOidSubAcceso());
	query.append("   AND DCC.TIDO_OID_TIPO_DOCU = " + dtoFacReasignar.getOidTipoDocContable());
	query.append("   AND DCC.VAL_EJER_DOCU_INTE = '" + dtoFacReasignar.getEjercicio() + "'");
	query.append("   AND DCC.NUM_DOCU_CONT_INTE BETWEEN " + dtoFacReasignar.getRangoDocInternoDesde() + " AND " + dtoFacReasignar.getRangoDocInternoHasta());
    query.append("   AND DCC.IND_IMPR = 1 ");
    query.append("   AND (DCC.VAL_SERI_DOCU_LEGA IS NOT NULL ");
    query.append("     OR DCC.NUM_DOCU_LEGA IS NOT NULL) ");
    query.append(" ) ");
    RecordSet rs = null;
    rs = this.executeQuery(query.toString());
    if (rs != null && !(rs.esVacio())){
      Long cantDocumentos = this.bigDecimalToLong(rs.getValueAt(0, "CANT_DOC_IMP"));    // Cantidad de documentos impresos (Cambio Sicc20070258)
      dtoFacReasignar.setRangoDocLegalHasta(new Long((dtoFacReasignar.getRangoDocLegalDesde().longValue() + cantDocumentos.longValue())-1));
      dtoFacReasignar.setCantidadDocumentosNoImpresos( this.bigDecimalToLong(rs.getValueAt(0, "CANT_DOC_NOIMP")) ); // Cantidad de documentos No Impresos
      dtoFacReasignar.setNumeroRegistrosNoNulos( this.bigDecimalToLong(rs.getValueAt(0, "NUM_REG_NONULO")) ); // Cantidad de documentos con campos serie y numero legal no nulos
    }
    return dtoFacReasignar;
  }

  public void reasignarNumeroDocumentoContableConfirmar(DTOFACReasignarNumeroDocContable dtoFacReasignar) throws  Exception, MareException
  {
        ArrayList array = new ArrayList();
        array.add(dtoFacReasignar.getOidSubAcceso().toString());       
        array.add(dtoFacReasignar.getOidTipoDocContable().toString());       
        array.add(dtoFacReasignar.getEjercicio().toString());       
        array.add(dtoFacReasignar.getRangoDocInternoDesde().toString());       
        array.add(dtoFacReasignar.getRangoDocInternoHasta().toString());       
        array.add(dtoFacReasignar.getRangoDocLegalDesde().toString());       
        array.add(dtoFacReasignar.getSerieDocLegal().toString());       
        
        RecordSet rs1;
        try {
          BelcorpService belcorpService = BelcorpService.getInstance();
          rs1 = belcorpService.dbService.executeProcedure("FAC_ASIG_NUME_LEGA",array); 
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
              UtilidadesLog.info("Exception: " + e.getMessage());
              throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS) );
        }
        
        DTOBatch dtoBatch = null;
        dtoBatch = new DTOBatch ("enviarDatosImpresionGuias", new MareBusinessID("INTEnviarDatosImpresionGuias"), dtoFacReasignar);
        try {
            BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
        }catch(RemoteException re){
                UtilidadesLog.error("*** Error en enviarInterfaces",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
        }

  }
  
  private RecordSet executeQuery(String query) throws MareException {
    UtilidadesLog.info("MONReversionFACBean.executeQuery(String query): Entrada");
    RecordSet rs = null;
    
    try {
      BelcorpService belcorpService = BelcorpService.getInstance();
      rs = belcorpService.dbService.executeStaticQuery( query );
    } catch ( Exception ex ) {
      throw new MareException( ex, 
          UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
    }       
    UtilidadesLog.info("MONReversionFACBean.executeQuery(String query): Salida");  
    return rs;
  }
  
  private Long bigDecimalToLong(Object numero) {
        if (numero != null) {
            return new Long(((BigDecimal) numero).longValue());
        } else {
            return null;
        }
   }

  private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinessFacadeBATCH");
  }


    private MONArmadoPedidosHMHome getMONArmadoPedidosHMHome() throws MareException
  {
    Object objHome = UtilidadesEJB.getHome("java:comp/env/MONArmadoPedidosHM", MONArmadoPedidosHMHome.class);
    return (MONArmadoPedidosHMHome)objHome;
  }
   
    private DocumentoPorSubaccesoLocalHome getDocumentoPorSubaccesoLocalHome() throws MareException {
       return new DocumentoPorSubaccesoLocalHome();
    }

    private FormularioLocalHome getFormularioLocalHome() throws MareException {
       return new FormularioLocalHome();
    }

    private PaisLocalHome getPaisLocalHome() throws MareException {
        return new PaisLocalHome();
    }

    private ParametrosFacturacionLocalHome getParametrosFacturacionLocalHome() throws MareException {        
        return new ParametrosFacturacionLocalHome();
    }
   
}