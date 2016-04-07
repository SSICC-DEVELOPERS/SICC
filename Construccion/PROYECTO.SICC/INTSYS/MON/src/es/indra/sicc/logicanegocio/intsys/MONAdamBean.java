package es.indra.sicc.logicanegocio.intsys;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mgu.manager.UserIDImpl;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.comun.DTOINTError;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.comun.RegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesHome;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.dtos.ccc.DTOSaldosPorFechas;
import es.indra.sicc.dtos.ccc.DTOSaldosPorFechasyVtos;
import es.indra.sicc.dtos.ccc.DTOTotal;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.intsys.DTOBuscarSolicitudAdam;
import es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz;
import es.indra.sicc.dtos.intsys.DTOEnvioComInc;
import es.indra.sicc.dtos.intsys.DTOSolicitudAdam;
import es.indra.sicc.dtos.mae.DTOTipoSubtipoCliente;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.entidades.intsys.DescuentosPersonalCabeceraLocal;
import es.indra.sicc.entidades.intsys.DescuentosPersonalCabeceraLocalHome;
import es.indra.sicc.entidades.intsys.DescuentosPersonalDetalleLocal;
import es.indra.sicc.entidades.intsys.DescuentosPersonalDetalleLocalHome;
import es.indra.sicc.entidades.intsys.IngresoComisionesEIncentivosLocal;
import es.indra.sicc.entidades.intsys.IngresoComisionesEIncentivosLocalHome;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.ccc.CCCConstantes;
import es.indra.sicc.logicanegocio.ccc.DAOCCC;
import es.indra.sicc.logicanegocio.ccc.MONInterfaceModulos;
import es.indra.sicc.logicanegocio.ccc.MONInterfaceModulosHome;
import es.indra.sicc.logicanegocio.mae.MONConfiguracionClientes;
import es.indra.sicc.logicanegocio.mae.MONConfiguracionClientesHome;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.ped.DAOSolicitud;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternos;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternosHome;
import es.indra.sicc.logicanegocio.ped.MONProcesosPED;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.rmi.RemoteException;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import java.math.BigDecimal;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.intsys.DTOEnviarComInc;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.intsys.DTOCargaAdam;
import es.indra.sicc.dtos.intsys.DTOMostrarDeuda;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.intsys.DTOGenerarFichero;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.dtos.intsys.DTOEstatus;
import es.indra.sicc.dtos.intsys.DTOINT;
import es.indra.sicc.dtos.intsys.DTOIndError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.intsys.DTOBusquedaDescuentos;
import es.indra.sicc.util.DTODate;
import es.indra.sicc.dtos.intsys.DTODescPers;
import javax.naming.NamingException;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;
import javax.naming.InitialContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONAdamBean implements SessionBean  {

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

    public void ingresarComisionesEIncentivos(Long moduloGenerador, Long oidCliente, BigDecimal importe) throws MareException {
        UtilidadesLog.info("MONAdamBean.ingresarComisionesEIncentivos(Long moduloGenerador, Long oidCliente, BigDecimal importe): Entrada");
        UtilidadesLog.debug("*** \n MONAdam.ingresarComisionesEIncentivos:  moduloGenerador " + moduloGenerador);
        UtilidadesLog.debug("*** \n MONAdam.ingresarComisionesEIncentivos:  oidCliente " + oidCliente);
        UtilidadesLog.debug("*** \n MONAdam.ingresarComisionesEIncentivos:  importe " + importe);
		
		//Obtenemos el TipoCliente para el oidCliente recibido.
		DTOTipoSubtipoCliente dtoTipoCliente = new DTOTipoSubtipoCliente();
		try{
			dtoTipoCliente = this.getMONConfiguracionClientes().obtenerTipoPrincipalCliente(oidCliente);
            // Se agrego esta validacion, porque puede ser que el cliente no tenga marcado ningun tipo cliente 
            // como principal. Ademas es posible que exista mas de un registro.
            if (dtoTipoCliente.getOid() == null)    {
                dtoTipoCliente = this.getMONConfiguracionClientes().obtenerPrimerTipoClienteNoPrincipal(oidCliente);
            }
		}catch(RemoteException re){
				UtilidadesLog.debug("error RemoteException ingresarComisionesEIncentivos ");
				throw new MareException(re,
					UtilidadesError.armarCodigoError(
					CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
		}
		
		//insertamos 
		IngresoComisionesEIncentivosLocalHome home = this.getIngresoComisionesEIncentivosLocalHome();
		IngresoComisionesEIncentivosLocal local = null;
		try{
                    if (importe!=null){
                        local = home.create(new Long((long)(importe.floatValue() * 100)),dtoTipoCliente.getOid(),moduloGenerador);  //  en la incidencia 
                    }else{
                        local = home.create(new Long(0),dtoTipoCliente.getOid(),moduloGenerador);  //  en la incidencia 
                    }
		}catch(PersistenceException cr){
			UtilidadesLog.debug("error CreateException  ingresarComisionesEIncentivos");
			throw new MareException(cr,
				UtilidadesError.armarCodigoError(
				CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}
		//Incidencia BELC300014529 para añadir campos que faltan
		local.setFecha(new java.sql.Date(System.currentTimeMillis()));
                home.merge(local);
        UtilidadesLog.info("MONAdamBean.ingresarComisionesEIncentivos(Long moduloGenerador, Long oidCliente, BigDecimal importe): Salida");
	}

    public DTOSalidaBatch enviarComisionesBatch(DTOEnviarComInc dtoe) throws MareException {
        UtilidadesLog.info("MONAdamBean.enviarComisionesBatch(DTOEnviarComInc dtoe): Entrada");
        UtilidadesLog.debug("*** \n MONAdam.enviarComisionesBatch:  DTOEnviarComInc dtoe " + dtoe);
   /*
    // Se invoca al caso de uso "Generar Fichero Envio de Comisiones", en modo batch 
    DTOBatch dtoBatch = new DTOBatch( nombre = "Generar Fichero Envio de Comisiones", 
    IDOnline = "INTEnviarComisiones", 
    DTOOnline = dtoe ) 

    BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" ) 
    mensaje += "Generar Fichero Envio de Comisiones Batch ejecutado- " 
    Retornar new DTOSalidaBatch( 0, mensaje )
    */
        String mensaje = null;
        IMareDTO  DTOOnline = dtoe; 
        UtilidadesLog.debug("*** \n MONAdam.enviarComisionesBatch:  DTOOnline " + DTOOnline);
        
        MareBusinessID IDOnline =  new MareBusinessID("INTEnviarComisiones");
        DTOBatch dtoBatch = new DTOBatch("Generar Fichero Envio de Comisiones", IDOnline , DTOOnline );
        
        try{
				UtilidadesLog.debug(" **** Antes de BatchUtil ***");
				BatchUtil.executeMLN( dtoBatch, new MareBusinessID("INTProcesoInterfaces"));
        } catch(RemoteException e){            
            UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));   
        }
        
        mensaje += "FichComisionesBatch ejecutado- ";
        
        UtilidadesLog.info("MONAdamBean.enviarComisionesBatch(DTOEnviarComInc dtoe): Salida");
        return new DTOSalidaBatch(0, mensaje); //return null;
    }

    public DTOSalidaBatch enviarComisiones(DTOBatch dtoe) throws MareException {
        UtilidadesLog.info("MONAdamBean.enviarComisiones(DTOBatch dtoe): Entrada");
    UtilidadesLog.debug("*** \n MONAdam.enviarComisiones:  DTOBatch dtoe " + dtoe);
    int n = 0;
    ArrayList listaCom= null;
     DAOAdam dao = null;
    // Se toma el dto con los datos necesarios extrayéndolo del DTOBatch que se recibe: 
    DTOEnviarComInc dtoEnviar = (DTOEnviarComInc)dtoe.getDTOOnline(); 
    UtilidadesLog.debug("*** \n MONAdam.enviarComisiones:  dtoEnviar  " + dtoEnviar);

    // Obtenemos una referencia al sistema gestor de interfaces, y creamos la interfaz ada1: 
    MONGestorInterfacesHome home = (MONGestorInterfacesHome) UtilidadesEJB.getHome("MONGestorInterfaces",MONGestorInterfacesHome.class);                  
    MONGestorInterfaces gi = null;
    try    {
      gi = home.create(); 
    }
    catch(Exception e)
    {
      UtilidadesLog.error(e);
      String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
      throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
    }
    
    InterfazInfo info = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_ADA1,
                                            dtoEnviar.getNumeroLote(),
                                            dtoEnviar.getOidPais());
    InterfazInfo interfaz = null;
    try{
      interfaz = gi.crearInterfaz(info);
      interfaz.setObservaciones(dtoEnviar.getObservaciones());
      interfaz.setDescripcionLote(dtoEnviar.getDescripcionLote());
    } catch (RemoteException ne) {
            if ( ne.detail != null && ne.detail instanceof InterfacesException ) {
                UtilidadesLog.error("  MONADAM.enviarComisiones Excepcion de la Interfaz " +  ((InterfacesException)ne.detail).getMotivo() , ne.detail );                
            } else {                                
                throw new MareException(ne.detail != null? ne.detail: ne,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
    } catch (InterfacesException ie) {            
            UtilidadesLog.error("  MONADAM.enviarComisiones Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );
    } 
    RegistroSicc registro = new RegistroSicc();
       
     
  try{
         dao = new DAOAdam(ctx.getCallerPrincipal().getName());
         listaCom = dao.obtenerEnvioComision( dtoEnviar ); 
          UtilidadesLog.debug("*** \n     listaCom = dao.obtenerEnvioComision  -->  listaCom " + listaCom);
       
        if (listaCom==null) { 
             UtilidadesLog.debug("interfaz "+ interfaz.toString());
            UtilidadesLog.debug("registro "+ registro.toString());
            UtilidadesLog.debug("ErroresDeNegocio.INT_0033  "+ ErroresDeNegocio.INT_0033);
            //DTOINTError dtoError = new DTOINTError( info, registro, ErroresDeNegocio.INT_0033);
            DTOINTError dtoError = new DTOINTError( interfaz, registro, ErroresDeNegocio.INT_0033 + interfaz.getCodigoInterfaz() + " Lote: " + interfaz.getNumeroLote());
            gi.registrarError( dtoError ); 
            return  new DTOSalidaBatch( 0, "GeneraFicherComisiones") ;
        }        
        
       n= listaCom.size();
       DTOEnvioComInc dtoEnvioCI = null;
       for ( int i=0;i<n ;i++ ){
            dtoEnvioCI=(DTOEnvioComInc)listaCom.get(i);
            UtilidadesLog.debug("*** \n     dtoEnvioCI=(DTOEnvioComInc)listaCom.get(i);  -->  dtoEnvioCI " + dtoEnvioCI);
            if(dtoEnvioCI.getImportePagar().intValue() > 0){
                try { 
                        registro.anyadirCampo( IAdam.ADA1_RELLENO_BLANC1 , "  "); //aquí se introduciran 2 espacios. 
                     
                         if(dtoEnvioCI.getCodPlanilla()==null){
                                    registro.anyadirCampo( IAdam.ADA1_CODIGO_PLANILLA, null );
                         }else{
                                    registro.anyadirCampo( IAdam.ADA1_CODIGO_PLANILLA, new Long(dtoEnvioCI.getCodPlanilla()) );
                        }
                     
                      //  registro.anyadirCampo( IAdam.ADA1_CODIGO_PLANILLA, dtoEnvioCI.getCodPlanilla());//esto es un String y la interfaz es long 
                        // try{
                           // registro.anyadirCampo( IAdam.ADA1_CODIGO_PLANILLA, new Long(dtoEnvioCI.getCodPlanilla())); 
                       // }catch(Exception  e){
                            //throw new MareException("El codPlanilla ha traido una letra.enviarIncentivos  ");
                       // }
                        registro.anyadirCampo( IAdam.ADA1_RELLENO_BLANC2, "                                                  "); //aquí se introduciran 50 espacios. 
                        registro.anyadirCampo( IAdam.ADA1_IMPORTE, dtoEnvioCI.getImportePagar());
                        
                        gi.anyadirRegistro(interfaz,registro);
     
                      //Añadido incidencia 13120
                        registro.vaciar();
                    
                    } catch( InterfacesException fex ){ 
                        //- se registra la excepción con el servicio MareLogging 
                        DTOINTError dtoError = new DTOINTError( interfaz, registro, ErroresDeNegocio.INT_0012 + interfaz.getCodigoInterfaz() + " Lote: " + interfaz.getNumeroLote());                         
                        gi.registrarError( dtoError ); 
                        dtoEnvioCI.setFallido(Boolean.TRUE);
                        continue;
                    }
              }//if
  
        }//Fin del bucle lista com
    
       try{ 
        gi.enviarInterfaz(interfaz);
   
        } catch (InterfacesException ie) {
            DTOINTError dtoError = new DTOINTError( interfaz, registro, ErroresDeNegocio.INT_0009 + interfaz.getCodigoInterfaz() + "Lote: " + interfaz.getNumeroLote() ); 
            gi.registrarError( dtoError ); 
             return  new DTOSalidaBatch(0,"GeneraFicherComision") ;           
            //UtilidadesLog.error("Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );
        }
  
      ArrayList listaClintes = new ArrayList();
      
      for ( int j=0;j<n ;j++ ){
            if(! ((DTOEnvioComInc)listaCom.get(j)).getFallido().booleanValue() ){
                //modificado por inc 22281
                //listaClintes.add(((DTOEnvioComInc)listaCom.get(j)).getOidCliente());
                listaClintes.add((DTOEnvioComInc)listaCom.get(j));
            }
      }
    UtilidadesLog.debug("*** \n  listaClintes " + listaClintes);
    UtilidadesLog.debug("*** \n  dtoEnviar.getNumeroLote() " + dtoEnviar.getNumeroLote());
    // se cambia llamada al metodo del dao Inc 22280
    dao.actualizarRegistrosLeidos(listaClintes, dtoEnviar.getNumeroLote(), dtoEnviar.getFechaDesde(), dtoEnviar.getFechaHasta() );
    UtilidadesLog.debug("*** \n  DESPUES dao.actualizarRegistrosLeidos(listaClintes,dtoEnviar.getNumeroLote(), dtoEnviar.getFechaDesde(), dtoEnviar.getFechaHasta());");
   
  
   }catch (RemoteException ne) {
            if ( ne.detail != null && ne.detail instanceof InterfacesException ) {
                UtilidadesLog.error("Excepcion de la Interfaz " +  ((InterfacesException)ne.detail).getMotivo() , ne.detail );                
            } else {                                
                throw new MareException(ne.detail != null? ne.detail: ne,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
    } catch (InterfacesException ie) {             
            UtilidadesLog.error("  MONADAM.enviarComisiones Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );
    }
 
    UtilidadesLog.info("MONAdamBean.enviarComisiones(DTOBatch dtoe): Salida");
    return new DTOSalidaBatch(0,"enviarComisiones procesado");
    }

    public DTOSalidaBatch enviarIncentivosBatch(DTOEnviarComInc dtoe) throws MareException {
        UtilidadesLog.info("MONAdamBean.enviarIncentivosBatch(DTOEnviarComInc dtoe): Entrada");        
        UtilidadesLog.debug("*** MONAdam.enviarIncentivosBatch:  DTOEnviarComInc dtoe "+ dtoe);
        String mensaje = null;
        IMareDTO  DTOOnline = dtoe; 
         UtilidadesLog.debug("*** MONAdam.enviarIncentivosBatch:  DTOOnline  "+ DTOOnline);
        
        MareBusinessID IDOnline =  new MareBusinessID("INTEnviarIncentivos");
        DTOBatch dtoBatch = new DTOBatch("Generar Envio de Incentivos", IDOnline , DTOOnline );
        
        try{
				UtilidadesLog.debug(" **** Antes de BatchUtil ***");
				BatchUtil.executeMLN( dtoBatch, new MareBusinessID("INTProcesoInterfaces"));
        } catch(RemoteException e){            
            UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));   
        }
        
        mensaje += "FichIncentivosBatch ejecutado- ";
        
        UtilidadesLog.info("MONAdamBean.enviarIncentivosBatch(DTOEnviarComInc dtoe): Salida");        
        return new DTOSalidaBatch(0, mensaje); //return null;
    }

    public DTOSalidaBatch enviarIncentivos(DTOBatch dtoe) throws MareException {
        UtilidadesLog.info("MONAdamBean.enviarIncentivos(DTOBatch dtoe): Entrada");
         UtilidadesLog.debug(" *** Metodo MONADAM.enviarIncentivos : DTOBatch dtoe "+  dtoe);
    int n = 0;
    ArrayList listaCom= null;
     DAOAdam dao = null;
    // Se toma el dto con los datos necesarios extrayéndolo del DTOBatch que se recibe: 
    DTOEnviarComInc dtoEnviar = (DTOEnviarComInc)dtoe.getDTOOnline(); 
    UtilidadesLog.debug(" *** Metodo MONADAM.enviarIncentivos : dtoEnviar "+  dtoEnviar);
    
    // Obtenemos una referencia al sistema gestor de interfaces, y creamos la interfaz ada1: 
    MONGestorInterfacesHome home = (MONGestorInterfacesHome) UtilidadesEJB.getHome("MONGestorInterfaces",MONGestorInterfacesHome.class);                  
    MONGestorInterfaces gi = null;
    try    {
      gi = home.create(); 
    }
    catch(Exception e)
    {
      UtilidadesLog.error(e);
      String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
      throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
    }
    
    InterfazInfo info = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_ADA2,
                                            dtoEnviar.getNumeroLote(),
                                            dtoEnviar.getOidPais());
    InterfazInfo interfaz = null;
    try{
      interfaz = gi.crearInterfaz(info);
      interfaz.setObservaciones(dtoEnviar.getObservaciones());
      interfaz.setDescripcionLote(dtoEnviar.getDescripcionLote());
    } catch (RemoteException ne) {
            if ( ne.detail != null && ne.detail instanceof InterfacesException ) {
                UtilidadesLog.error("  MONADAM.enviarIncentivos Excepcion de la Interfaz " +  ((InterfacesException)ne.detail).getMotivo() , ne.detail );                
            } else {                                
                throw new MareException(ne.detail != null? ne.detail: ne,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
    } catch (InterfacesException ie) {            
            UtilidadesLog.error("  MONADAM.enviarIncentivos Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );
    } 
    RegistroSicc registro = new RegistroSicc();
  
     
  try{
         dao = new DAOAdam(ctx.getCallerPrincipal().getName());
         listaCom = dao.obtenerEnvioIncentivo( dtoEnviar );
        UtilidadesLog.debug(" *** Metodo  listaCom = dao.obtenerEnvioIncentivo( dtoEnviar )--->listaCom "+  listaCom);
       
        if (listaCom==null) { 
        UtilidadesLog.debug("interfaz "+ interfaz);
        UtilidadesLog.debug("registro "+ registro);
        UtilidadesLog.debug("ErroresDeNegocio.INT_0033  "+ ErroresDeNegocio.INT_0033);
            DTOINTError dtoError = new DTOINTError( interfaz, registro, ErroresDeNegocio.INT_0033 + interfaz.getCodigoInterfaz() + " Lote: " + interfaz.getNumeroLote());
            //DTOINTError dtoError = new DTOINTError( info, registro, ErroresDeNegocio.INT_0033);
            gi.registrarError( dtoError ); 
            return  new DTOSalidaBatch( 0, "GeneraFicherIncentivos") ;
        }
        
       n= listaCom.size();
       DTOEnvioComInc dtoEnvioCI = null;
       for ( int i=0;i<n ;i++ ){
            dtoEnvioCI=(DTOEnvioComInc)listaCom.get(i);
            UtilidadesLog.debug(" *** Metodo    dtoEnvioCI=(DTOEnvioComInc)listaCom.get(i);--->dtoEnvioCI "+  dtoEnvioCI);
            if(dtoEnvioCI.getImportePagar().intValue() > 0){
                try { 
                        registro.anyadirCampo( IAdam.ADA2_RELLENO_BLANC1 , "  "); //aquí se introduciran 2 espacios. 
                       
                       if(dtoEnvioCI.getCodPlanilla()==null){
                                    registro.anyadirCampo( IAdam.ADA2_CODIGO_PLANILLA, null );
                         }else{
                                    registro.anyadirCampo( IAdam.ADA2_CODIGO_PLANILLA, new Long(dtoEnvioCI.getCodPlanilla()) );
                        }
                      
                      //  try{
                         //   registro.anyadirCampo( IAdam.ADA2_CODIGO_PLANILLA, new Long(dtoEnvioCI.getCodPlanilla())); 
                       // }catch(Exception  e){
                        //    throw new MareException("El codPlanilla ha traido una letra.enviarIncentivos  ");
                       // }
                        
                        registro.anyadirCampo( IAdam.ADA2_RELLENO_BLANC2, "                                                  "); //aquí se introduciran 50 espacios. 
                        registro.anyadirCampo( IAdam.ADA2_IMPORTE, dtoEnvioCI.getImportePagar());
                        
                        gi.anyadirRegistro(interfaz,registro);
      
                      //Añadido incidencia 13120
                        registro.vaciar();
                    
                    } catch( InterfacesException fex ){ 
                        //- se registra la excepción con el servicio MareLogging 
                        DTOINTError dtoError = new DTOINTError( interfaz, registro, ErroresDeNegocio.INT_0012 + interfaz.getCodigoInterfaz() + " Lote: " + interfaz.getNumeroLote());                         
                        gi.registrarError( dtoError ); 
                        dtoEnvioCI.setFallido(Boolean.TRUE);
                        continue;
                    }
              }//if
  
        }//Fin del bucle lista com
    
       try{ 
        gi.enviarInterfaz(interfaz);
   
        } catch (InterfacesException ie) {
            DTOINTError dtoError = new DTOINTError( interfaz, null, ErroresDeNegocio.INT_0009 + interfaz.getCodigoInterfaz() + "Lote: " + interfaz.getNumeroLote() ); 
            gi.registrarError( dtoError ); 
             return  new DTOSalidaBatch(0,"GeneraFicherIncentivos") ;           
            //UtilidadesLog.error("Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );
        }
  
      ArrayList listaClintes = new ArrayList();
      
      for ( int j=0;j<n ;j++ ){
            if(! ((DTOEnvioComInc)listaCom.get(j)).getFallido().booleanValue() ){
                //modificado por inc 22281
                //listaClintes.add(((DTOEnvioComInc)listaCom.get(j)).getOidCliente());
                listaClintes.add((DTOEnvioComInc)listaCom.get(j));
            }
      }
      UtilidadesLog.debug(" *** Metodo   listaClintes "+ listaClintes);
      UtilidadesLog.debug(" *** Metodo   dtoEnviar.getNumeroLote() "+ dtoEnviar.getNumeroLote());
      dao.actualizarRegistrosLeidos(listaClintes,dtoEnviar.getNumeroLote(), dtoEnviar.getFechaDesde(), dtoEnviar.getFechaHasta());
       UtilidadesLog.debug(" *** Metodo  dao.actualizarRegistrosLeidos(listaClintes,dtoEnviar.getNumeroLote(), dtoEnviar.getFechaDesde(), dtoEnviar.getFechaHasta());");
      
   }catch (RemoteException ne) {
            if ( ne.detail != null && ne.detail instanceof InterfacesException ) {
                UtilidadesLog.error("Excepcion de la Interfaz " +  ((InterfacesException)ne.detail).getMotivo() , ne.detail );                
            } else {                
                throw new MareException(ne.detail != null? ne.detail: ne,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
    } catch (InterfacesException ie) {             
            UtilidadesLog.error("  MONADAM.enviarIncentivos Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );
    }
 
    UtilidadesLog.info("MONAdamBean.enviarIncentivos(DTOBatch dtoe): Salida");
    return new DTOSalidaBatch(0,"enviarIncentivos procesado");
    }

    public DTOCargaAdam obtenerCombosEstado(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("MONAdamBean.obtenerCombosEstado(DTOBelcorp dtoe): Entrada");
        UtilidadesLog.debug("MONAdam.obtenerCombosEstado: DTOBelcorp "+ dtoe);

            DAOAdam daoAdam = new DAOAdam(this.ctx.getCallerPrincipal().getName()); 
            boolean estadoPed = true; 
            ArrayList listaOids = null;
            listaOids = daoAdam.buscarRegistrosDesc(); 
            UtilidadesLog.debug("MONAdam. listaOids = daoAdam.buscarRegistrosDesc();---> listaOids "+ listaOids);
            
            if (listaOids==null) { 
                estadoPed = false; 
            } 
            
            //vamos a obtener la fecha de vencimiento desde. 
            String codInterfaz = IGestorInterfaces.COD_INTERFAZ_ADA3; 
            DTODate dtoFecha = daoAdam.buscarFechaDesde(codInterfaz, dtoe);
            
            
            MONMantenimientoSEG monMSEG = this.getMONMantenimientoSEG();
            MONConfiguracionClientes monCClientes = this.getMONConfiguracionClientes();
            
            DTOSalida dtoCanal =  null;
            DTOSalida dtoMarca =  null;
            DTOSalida dtoTipo  =  null;
            try{
                //obtenemos los oids y descripciones de canales, para cargar posteriormente una combo 
                dtoCanal = monMSEG.obtenerCanalesSinFiltro(dtoe);
                UtilidadesLog.debug("MONAdam. monMSEG.obtenerCanalesSinFiltro(dtoe);---> dtoCanal "+ dtoCanal);
                
                //obtenemos los oids y descripciones de marcas, para cargar posteriormente una combo 
                dtoMarca = monMSEG.obtenerMarcasSinFiltro();
                UtilidadesLog.debug("MONAdam.   dtoMarca = monMSEG.obtenerMarcasSinFiltro();---> dtoMarca "+ dtoMarca);
                
                //obtenemos los oids y descripciones de los tipos de cliente, para cargar el combo correspondiente de la pantalla 
                dtoTipo = monCClientes.obtenerTipos(dtoe);
                UtilidadesLog.debug("MONAdam.   dtoTipo = monCClientes.obtenerTipos(dtoe);---> dtoTipo "+ dtoTipo);
                
            }catch (RemoteException ne) {                
                UtilidadesLog.error(ne);
                throw new MareException(ne,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            //Crearmos un DTOCargaAdam 
            DTOCargaAdam dtoCargaAdam = new DTOCargaAdam();
            
            dtoCargaAdam.setCanales(dtoCanal.getResultado());
            dtoCargaAdam.setMarcas(dtoMarca.getResultado());
            dtoCargaAdam.setTipoCliente(dtoTipo.getResultado());
            dtoCargaAdam.setEstadoP(new Boolean(estadoPed));
            dtoCargaAdam.setFechaDesde(dtoFecha.getFecha());
            
            //Devolvemos este DTOCargaAdam
        UtilidadesLog.debug("MONAdam.obtenerCombosEstado: Salida   dtoCargaAdam "+ dtoCargaAdam);
        UtilidadesLog.info("MONAdamBean.obtenerCombosEstado(DTOBelcorp dtoe): Salida");
        return dtoCargaAdam;
    }

    public DTOMostrarDeuda obtenerDatosAdam(DTODescPers dtoe) throws MareException {
        UtilidadesLog.info("MONAdamBean.obtenerDatosAdam(DTODescPers dtoe): Entrada");
        UtilidadesLog.debug("MONAdam.obtenerDatosAdam: dto ENTRADA    DTODescPers " +dtoe);

        DAOAdam daoAdam = new DAOAdam(this.ctx.getCallerPrincipal().getName());
        DAOCCC daoCCC = new DAOCCC();
        RecordSet marcas = daoCCC.obtenerMarcasTipoAbonoEntrada(CCCConstantes.CODIGO_PROCESO_CON005,new Integer(CCCConstantes.SUBPROCESO_DESCUENTO),dtoe.getOidPais());
        UtilidadesLog.debug("RecordSet marcas=daoCCC.obtenerMarcasTipoAbonoEntrada ------> marcas" +marcas);
        
        RecordSet listaCliente = daoAdam.obtenerDatos(dtoe, marcas);      
        UtilidadesLog.debug("RecordSet listaCliente = daoAdam.obtenerDatos(dtoe, marcas);  ------> listaCliente" +listaCliente);

        DTONumeroSolicitud dtoNum = new DTONumeroSolicitud();
        dtoNum.setOidIdioma(dtoe.getOidIdioma());
        dtoNum.setOidPais(dtoe.getOidPais());
        dtoNum.setOperacion(ConstantesBEL.COD_INT083);
        
        UtilidadesLog.debug(" DTONumeroSolicitud dtoNum " + dtoNum);

        MONProcesosPED monPPED = this.getMONProcesosPED();
        String numDocumento =  null;
        try{
            
            numDocumento = monPPED.generaNumeroDocumento(dtoNum);
            UtilidadesLog.debug("\n\n numDocumento = monPPED.generaNumeroDocumento(dtoNum);   ------> numDocumento" +numDocumento);

        }catch(RemoteException re){            
            UtilidadesLog.debug("Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        
        DTOOID estatusPendiente = new DTOOID();
        estatusPendiente.setOidIdioma(dtoe.getOidIdioma());
        estatusPendiente.setOidPais(dtoe.getOidPais());
        estatusPendiente.setOid(ConstantesINT.ESTADO_PENDIENTE);
        
        DTOEstatus dtoEstatus = daoAdam.obtenerEstatus(estatusPendiente);
        UtilidadesLog.debug("\n\n  DTOEstatus dtoEstatus = daoAdam.obtenerEstatus(estatusPendiente);   ------> dtoEstatus" +dtoEstatus);

        
        RecordSet listaCompleta = this.calcularLineaCreditoDisp(listaCliente, dtoe.getOidIdioma(), dtoe.getOidPais());
        UtilidadesLog.debug("\n\n   RecordSet listaCompleta = this.calcularLineaCreditoDisp(listaCliente, dtoe.getOidIdioma(), dtoe.getOidPais());   ------> listaCompleta" +listaCompleta);


        DTOMostrarDeuda dtoMostrarDeuda = new DTOMostrarDeuda();
        dtoMostrarDeuda.setNumDocumento(numDocumento);
        dtoMostrarDeuda.setFechaCreacion(new Date());
        dtoMostrarDeuda.setOidEstatus(dtoEstatus.getOidEstatus());
        dtoMostrarDeuda.setEstatus(dtoEstatus.getCadena());        
        dtoMostrarDeuda.setDetalle(listaCompleta);
     
        UtilidadesLog.debug("MONAdam.obtenerDatosAdam: SALIDA    DTOMostrarDeuda    " +dtoMostrarDeuda);        
        UtilidadesLog.info("MONAdamBean.obtenerDatosAdam(DTODescPers dtoe): Salida");
        return dtoMostrarDeuda;
    }

    public RecordSet calcularLineaCreditoDisp(RecordSet listaClient, Long oidIdioma, Long oidPais) throws MareException {
        UtilidadesLog.info("MONAdamBean.calcularLineaCreditoDisp(RecordSet listaClient, Long oidIdioma, Long oidPais): Entrada");
		UtilidadesLog.debug("RecordSet listaClient    " +listaClient);  
        UtilidadesLog.debug("Long oidIdioma    " +oidIdioma);  
        UtilidadesLog.debug("Long oidPais    " +oidPais);  
        
		Vector lineaDisponible = new Vector();
		//se debe comprobar siempre si lo que te llega es null o no?? 
        //HAZLO
        
		for(int i= 0;i< listaClient.getRowCount();i++){
			//Tomamos la siguiente fila del RecordSet 

			// Calcula el número de solicitudes nuevas aprobadas pendientes de facturar 
			DAOSolicitud dao = new DAOSolicitud();
			BigDecimal SNA= dao.calcularMontoSolicitudesNuevas(new Long(((BigDecimal)listaClient.getValueAt(i,"OID_CLIE")).toString()));
			UtilidadesLog.debug("BigDecimal SNA    " +SNA);
            
			// Calcula la deuda total 
			DTOSaldosPorFechasyVtos dto = new DTOSaldosPorFechasyVtos();
			dto.setOidCliente(new Long(((BigDecimal)listaClient.getValueAt(i,"OID_CLIE")).toString()));
            dto.setOidIdioma(oidIdioma);
            dto.setOidPais(oidPais);
			DTOTotal dtoTotal = null;
			try{
				dtoTotal = this.getMONInterfaceModulos().calcularSaldoCCCliente(dto);
                UtilidadesLog.debug("dtoTotal = this.getMONInterfaceModulos().calcularSaldoCCCliente(dto);-->dtoTotal " +dtoTotal);
			}catch(RemoteException re){				
				UtilidadesLog.debug(re);
				throw new MareException(re, UtilidadesError.armarCodigoError(
					CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
			}
 			
			// Calcula el valor del cupón de trámite 
			DTOSaldosPorFechas dtoSalFech = new DTOSaldosPorFechas();
			dtoSalFech.setOidCliente(new Long(((BigDecimal)listaClient.getValueAt(i,"OID_CLIE")).toString()));
            dtoSalFech.setOidIdioma(oidIdioma);
            dtoSalFech.setOidPais(oidPais);
			DTOTotal dtoTot = null;
			try{
				dtoTot = this.getMONInterfaceModulos().calcularCuponTramiteCliente(dtoSalFech);
                UtilidadesLog.debug("dtoTot = this.getMONInterfaceModulos().calcularCuponTramiteCliente(dtoSalFech);-->dtoTot " +dtoTot);
			}catch(RemoteException re){
				UtilidadesLog.debug(re);
				throw new MareException(re, UtilidadesError.armarCodigoError(
					CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
			}
			//incidencia de quique, parado.
            
            //Incidencia 14652 -> no puede ser null los importes pero el IMP_MONT_LINE_CRED si (hablado por tlf)
            BigDecimal C3 = null;
            BigDecimal DT = null;
            BigDecimal montoCredito = null;
            if (listaClient.getValueAt(i,"IMP_MONT_LINE_CRED")!=null){
                montoCredito = (BigDecimal)listaClient.getValueAt(i,"IMP_MONT_LINE_CRED");
            }else{
                montoCredito = new BigDecimal(0);                
            }
            
            if (SNA==null){
                SNA = new BigDecimal(0);                
            }

            if ((dtoTotal==null)||(dtoTotal.getTotal()==null)){
                DT = new BigDecimal(0);                
            }else{
                DT = dtoTotal.getTotal();
            }

            if ((dtoTot==null)||(dtoTot.getTotal()==null)){
                C3 = new BigDecimal(0);                
            }else{
                C3 = dtoTot.getTotal();
            }


            BigDecimal total = new BigDecimal(montoCredito.intValue() - SNA.longValue() - DT.longValue() + C3.longValue());    
			
            listaClient.setValueAt(total,i,12);
            //lineaDisponible.add(total);
			
		}
		
		//añadimos a la fila del RecordSet que estamos procesando el valor obtenido, en la columna lineaCreditoDisponible
		//Este campo se a incluido en el dao, si es mas falic añadirlo aqui, se debe quitar del DAO.	
		
        //Se cambia esto porque no coinciden las columnas
        //listaClient.addColumn("LINEACREDITODISPONIBLE",lineaDisponible);
        
		UtilidadesLog.debug("MONAdam.calcularLineaCreditoDisp: listaClient"+listaClient);
        UtilidadesLog.info("MONAdamBean.calcularLineaCreditoDisp(RecordSet listaClient, Long oidIdioma, Long oidPais): Salida");
		return listaClient;
    }

    public DTOString generarFichero(DTOGenerarFichero dtoe) throws MareException {
         UtilidadesLog.info("MONAdamBean.generarFichero(DTOGenerarFichero dtoe): Entrada");         
         UtilidadesLog.debug("DTOGenerarFichero dtoe:  "+dtoe);
		//Vamos a obtener un número de lote 
		DTOString dto = new DTOString();
		dto.setCadena(IGestorInterfaces.COD_INTERFAZ_ADA3);
		dto.setOidIdioma(dtoe.getOidIdioma());
		dto.setOidPais(dtoe.getOidPais());
		
		DTOCargaInicialInterfaz dtoInter = new DTOCargaInicialInterfaz();
		try{
            UtilidadesLog.debug(" DTOString dto "+dto);
			dtoInter = this.getMONINT().cargaInicial(dto);
            UtilidadesLog.debug("dtoInter = this.getMONINT().cargaInicial(dto); -->dtoInter "+dtoInter);
		}catch(RemoteException re){			
				UtilidadesLog.debug("Error RemoteException");
				throw new MareException(re, UtilidadesError.armarCodigoError(
					CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}
		
		//Vamos a añadir el el campo numeroLote del DTOGenerarFichero el numero de lote generado por el subsistema, para poder enviarlo 
		DTOGenerarFichero dtoFichero = new DTOGenerarFichero();
        dtoFichero.setAcceso(dtoe.getAcceso());
        dtoFichero.setCanal(dtoe.getCanal());
        dtoFichero.setDescripcionLote(dtoe.getDescripcionLote());
        dtoFichero.setEstatus(dtoe.getEstatus());
        dtoFichero.setFechaCreacion(dtoe.getFechaCreacion());
        dtoFichero.setFechaVencimientoDesde(dtoe.getFechaVencimientoDesde());
        dtoFichero.setFechaVencimientoHasta(dtoe.getFechaVencimientoHasta());
        dtoFichero.setLstDetalle(dtoe.getLstDetalle());
        dtoFichero.setMarca(dtoe.getMarca());
        dtoFichero.setNumeroDocumento(dtoe.getNumeroDocumento());
        dtoFichero.setNumeroLote(dtoInter.getNumeroLote().toString());
        dtoFichero.setObservaciones(dtoe.getObservaciones());
        dtoFichero.setOidAcceso(dtoe.getOidAcceso());
        dtoFichero.setOidCanal(dtoe.getOidCanal());
        dtoFichero.setOidEstatus(dtoe.getOidEstatus());
        dtoFichero.setOidIdioma(dtoe.getOidIdioma());
        dtoFichero.setOidPais(dtoe.getOidPais());
        dtoFichero.setOidMarca(dtoe.getOidMarca());

		
		//Vamos a invocar en modo batch al método que envía el interfaz 
		DTOSalidaBatch dtoSalidaBatch = enviarDescuentosBatch(dtoFichero);
		UtilidadesLog.debug("DTOSalidaBatch dtoSalidaBatch = enviarDescuentosBatch(dtoFichero); -->dtoSalidaBatch "+dtoSalidaBatch);
		//Devolvemos un DTOString con el númeroLote que hemos hallado.
		DTOString dtoRetorno = new DTOString();
		dtoRetorno.setCadena(dtoInter.getNumeroLote().toString());
		
        UtilidadesLog.debug("dtoRetorno "+dtoRetorno);
        UtilidadesLog.info("MONAdamBean.generarFichero(DTOGenerarFichero dtoe): Salida");         
		return dtoRetorno;
    }

    public DTOSalidaBatch enviarDescuentosBatch(DTOGenerarFichero dtoe) throws MareException {
        UtilidadesLog.info("MONAdamBean.enviarDescuentosBatch(DTOGenerarFichero dtoe): Entrada");      
        String mensaje = null;
        IMareDTO  DTOOnline = dtoe; 
        UtilidadesLog.debug("***MONAdam.DTOOnline: DTOOnline "+DTOOnline);     
        MareBusinessID IDOnline =  new MareBusinessID("INTEnviarDescuentos");
        DTOBatch dtoBatch = new DTOBatch("Enviar Descuentos a Personal", IDOnline , DTOOnline );
        
        try{
				UtilidadesLog.debug(" **** Antes de BatchUtil ***");
				BatchUtil.executeMLN( dtoBatch, new MareBusinessID("INTProcesoInterfaces"));
        } catch(RemoteException e){            
            UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));   
        }
        
        mensaje += "DescuentosBatch ejecutado- ";
        
        UtilidadesLog.info("MONAdamBean.enviarDescuentosBatch(DTOGenerarFichero dtoe): Salida");
        return new DTOSalidaBatch(0, mensaje); //return null;
    }

    public DTOSalidaBatch enviarDescuentos(DTOBatch dtoe) throws MareException {
        UtilidadesLog.info("MONAdamBean.enviarDescuentos(DTOBatch dtoe): Entrada");
        UtilidadesLog.debug(" *** Metodo MONADAM.DTOBatch : "+ dtoe);
    int n = 0;
    ArrayList listaCom= null;
     DAOAdam dao = null;
    // Se toma el dto con los datos necesarios extrayéndolo del DTOBatch que se recibe: 
    DTOGenerarFichero  dtoGenerarF = (DTOGenerarFichero)dtoe.getDTOOnline(); 
    UtilidadesLog.debug(" *** dtoGenerarF "+dtoGenerarF);
    // Obtenemos una referencia al sistema gestor de interfaces, y creamos la interfaz ada1: 
    MONGestorInterfacesHome home = (MONGestorInterfacesHome) UtilidadesEJB.getHome("MONGestorInterfaces",MONGestorInterfacesHome.class);                  
    MONGestorInterfaces gi = null;
    try    {
      gi = home.create(); 
    }
    catch(Exception e)
    {      
      UtilidadesLog.error(e);
      String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
      throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
    }
    
    InterfazInfo info = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_ADA3,
                                            dtoGenerarF.getNumeroLote(),
                                            dtoGenerarF.getOidPais());
    InterfazInfo interfaz = null;
    try{
      interfaz = gi.crearInterfaz(info);
      interfaz.setObservaciones(dtoGenerarF.getObservaciones());
      interfaz.setDescripcionLote(dtoGenerarF.getDescripcionLote());
    } catch (RemoteException ne) {
            if ( ne.detail != null && ne.detail instanceof InterfacesException ) {
                UtilidadesLog.error("  MONADAM.enviarDescuentos Excepcion de la Interfaz " +  ((InterfacesException)ne.detail).getMotivo() , ne.detail );
            } else {                                
                throw new MareException(ne.detail != null? ne.detail: ne,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
    } catch (InterfacesException ie) {
            UtilidadesLog.error("  MONADAM.enviarDescuentos Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );
    } 
    RegistroSicc registro = new RegistroSicc();
   
                 /*//Vamos a escribir para cada fila del recordSet del DTOE.lstDetalle 
                        Mientras DTOE.lstDetalle tenga filas { //Tomamos la siguiente fila del RecordSet 
                        If (DTOE.lstDetalle.importeDeudaEnviarAdam > 0) { //Si el valor de la columna importeDeudaEnviarAdam de la fila 
            que estamos procesando del RecordSet lstDetalle >0 añadimos al registro 
              //se añaden los campos al registro 
            try { 
            registro.anyadirCampo( IAdam.ADA3_RELLENO_BLANC1, new String); //aquí se introduciran 2 espacios. 
            registro.anyadirCampo( IAdam.ADA3_CODIGO_PLANILLA, DTOE.lstDetalle.codPlanilla); //le pasamos el valor de la columna codPlanilla de la fila del recordSet que estamos procesando 
            registro.anyadirCampo( IAdam.ADA3_RELLENO_BLANC2, new String); //aquí se introduciran 50 espacios. 
            registro.anyadirCampo( Idam.ADA3_IMPORTE, DTOE.LstDetalle.importePagar); //le pasamos el valor de la columna importeDeudaEnviarAdam de la fila del recordSet que estamos procesando 
            } catch( FinderException fex ){ 
            - se registra la excepción con el servicio MareLogging 
            DTOINTError dtoError = new DTOINTError( interfaz, registro, mensaje INT-0012 + interfaz.codigo + "Lote: " + interfaz.numeroLote)             
            gi.registrarError( dtoError ) 
            continue 
            }} 
            }//Fin Recorrer RecordSet 
                 * */   
     try{
            boolean hayRegs = false;
            n = 0;
            RecordSet rs=dtoGenerarF.getLstDetalle();
            UtilidadesLog.debug("  RecordSet rs=dtoGenerarF.getLstDetalle(); "+rs);
            if(rs!=null){
                if(!rs.esVacio()){
                    n=rs.getRowCount();
                    BigDecimal cien = new BigDecimal("100");
                    for(int i=0;i<n;i++){
                        if(rs.getValueAt(i,"IMPORTEENVIAR")!=null){                                                                                   
                               if(((BigDecimal)rs.getValueAt(i,"IMPORTEENVIAR")).longValue()> 0 ){
                              
                                try { 
                                         registro.vaciar();
                                        registro.anyadirCampo( IAdam.ADA3_RELLENO_BLANC1 , "  "); //aquí se introduciran 2 espacios. 
                                        if(rs.getValueAt(i,"CODPLANILLA")==null){
                                            registro.anyadirCampo( IAdam.ADA3_CODIGO_PLANILLA, null );
                                        }else{
                                            registro.anyadirCampo( IAdam.ADA3_CODIGO_PLANILLA, new Long((String)rs.getValueAt(i,"CODPLANILLA")) );
                                        }
                                        registro.anyadirCampo( IAdam.ADA3_RELLENO_BLANC2, "                                                  "); //aquí se introduciran 50 espacios. 
                                        registro.anyadirCampo( IAdam.ADA3_IMPORTE, new Long(((BigDecimal)rs.getValueAt(i,"IMPORTEENVIAR")).multiply(cien).longValue()) );
                                        
                                        gi.anyadirRegistro(interfaz,registro);
                                        
                                        hayRegs=true;
                                      //Añadido incidencia 13120
                                        registro.vaciar();
                                    
                                    } catch( InterfacesException fex ){ 
                                        //- se registra la excepción con el servicio MareLogging 
                                        DTOINTError dtoError = new DTOINTError( interfaz, registro, ErroresDeNegocio.INT_0012 + interfaz.getCodigoInterfaz() + " Lote: " + interfaz.getNumeroLote());                                         
                                        gi.registrarError( dtoError ); 
                                        //dtoEnvioCI.setFallido(Boolean.TRUE);
                                        continue;
                                    } 
                              }                          
                         }  
                    }//for
                }//es vacio
            }//rs!=null
            
        if(hayRegs){
            try{ 
                    gi.enviarInterfaz(interfaz);
            } catch (InterfacesException ie) {
                DTOINTError dtoError = new DTOINTError( interfaz, null, ErroresDeNegocio.INT_0009 + interfaz.getCodigoInterfaz() + "Lote: " + interfaz.getNumeroLote() ); 
                gi.registrarError( dtoError ); 
                 return  new DTOSalidaBatch(0,"GeneraFicherComisiones") ;               
                //UtilidadesLog.error("Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );
            }
        }
  
        /*//Vamos a guardar la información en la cabecera 
        Seteamos en el campo DTOGenerarFichero.oidEstatus = ConstantesINT.ESTADO_ENVIADO 
        // pues queremos guardar los datos de la pantalla en estado enviado. 
        DTOEstatus dtoEstatus = guardarDescuento(DTOGenerarFichero) 
        
        String mensaje 
        mensaje += "Enviar Descuentos Personal procesado - " 
        Retornar new DTOSalidaBatch( 0, mensaje ) 
        */
        dtoGenerarF.setOidEstatus(ConstantesINT.ESTADO_ENVIADO); 
         UtilidadesLog.debug("  this.guardarDescuento(dtoGenerarF);; "+dtoGenerarF);
        this.guardarDescuento(dtoGenerarF);
    
    //catch genral
      
   }catch (RemoteException ne) {
            if ( ne.detail != null && ne.detail instanceof InterfacesException ) {
                UtilidadesLog.error("Excepcion de la Interfaz " +  ((InterfacesException)ne.detail).getMotivo() , ne.detail );
            } else {                                
                throw new MareException(ne.detail != null? ne.detail: ne,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
    } catch (InterfacesException ie) {             
            UtilidadesLog.error("  MONADAM.enviarDescuentos Excepcion de la Interfaz " +  ie.getMotivo()  + " ( "+ ie.getEx() + " )", ie );
    }
 
    UtilidadesLog.info("MONAdamBean.enviarDescuentos(DTOBatch dtoe): Salida");
    return new DTOSalidaBatch(0,"EnviarDesPersonal procesado ");
    }

    public DTOEstatus guardarDescuento(DTOGenerarFichero dtoe) throws MareException {
        UtilidadesLog.info("MONAdamBean.guardarDescuento(DTOGenerarFichero dtoe): Entrada");
        UtilidadesLog.debug("****Metodo  MONAdam.DTOGenerarFichero dtoe: " +dtoe);	

        Long cliente  = null;
        Long subtipo  = null;
        BigDecimal importe = null;
        BigDecimal importeDescontar = null;
        BigDecimal importeEnviar = null;
        Long cabecera = null;
        DescuentosPersonalDetalleLocal dpdLocal = null;
        DescuentosPersonalCabeceraLocal dpcLocal = null;
        Collection dpdLocalCollection = null;
        Iterator itDetalle = null;
        DescuentosPersonalCabeceraLocalHome dpc = this.getDescuentosPersonalCabeceraLocalHome();
        DescuentosPersonalDetalleLocalHome dpd = this.getDescuentosPersonalDetalleLocalHome();
        try{
            dpcLocal = dpc.findByUK(dtoe.getOidPais(),new Long(dtoe.getNumeroDocumento())); 

            dpcLocal.setNumeroLote(dtoe.getNumeroLote());   
            dpcLocal.setDescripcion(dtoe.getDescripcionLote());   
            dpcLocal.setObservaciones(dtoe.getObservaciones());   
            dpcLocal.setFechaCreacion(new java.sql.Date(dtoe.getFechaCreacion().getTime()));   
            if (dtoe.getFechaVencimientoDesde()!=null){
                dpcLocal.setFechaVencimientoDesde(new java.sql.Date(dtoe.getFechaVencimientoDesde().getTime())); 
            }
            if (dtoe.getFechaVencimientoHasta()!=null){
                dpcLocal.setFechaVencimientoHasta(new java.sql.Date(dtoe.getFechaVencimientoHasta().getTime()));  
            }
            dpcLocal.setEstado(dtoe.getOidEstatus());   
            dpcLocal.setMarca(dtoe.getOidMarca());   
            dpcLocal.setAcceso(dtoe.getOidAcceso());   
            dpc.merge(dpcLocal);
            
            try{
                dpdLocalCollection = dpd.findByCabecera(dpcLocal.getOid());    
                itDetalle = dpdLocalCollection.iterator();
                //Hacer un remove de todos los registros encontrados en DocumentosPersonalDetalle 
                while(itDetalle.hasNext()){
                    dpdLocal = (DescuentosPersonalDetalleLocal)itDetalle.next();
                    try{
                        dpd.remove(dpdLocal);
                    }catch(PersistenceException re){                        
                        UtilidadesLog.debug(re);
                        String codigoError = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
                        throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));   
                    }
                }
            } catch(NoResultException fe){
                UtilidadesLog.debug("No se encontraron registros - No se borran");
            }  catch (PersistenceException ce) {
                 UtilidadesLog.error("ERROR ", ce);
                 throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            RecordSet rs = dtoe.getLstDetalle();
            //Para cada fila del recordSet DTOE.lstDetalle recibida
            for (int j =0; j<rs.getRowCount(); j++){
                cliente = (Long)rs.getValueAt(j,"OIDCLIENTE");
                subtipo = (Long)rs.getValueAt(j,"OIDSUBTIPOCLIENTE");
                importe = (BigDecimal)rs.getValueAt(j,"IMPORTECALCULADO");
                importeDescontar = (BigDecimal)rs.getValueAt(j,"IMPORTEDESCONTAR");
                importeEnviar = (BigDecimal)rs.getValueAt(j,"IMPORTEENVIAR");
                cabecera = dpcLocal.getOid();
            //BigDecimal impDeudaCalculado, Long cliente, Long subtipo, Long numeroDocumento

                DTOTipoSubtipoCliente dtoTipoCliente = null;
                try{
                    dtoTipoCliente = this.getMONConfiguracionClientes().obtenerTipoPrincipalCliente(cliente);
                }catch(RemoteException re){                    
                        UtilidadesLog.debug("error RemoteException ingresarComisionesEIncentivos ");
                        throw new MareException(re,
                            UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                UtilidadesLog.debug("TipoSubtipoCliente: "+ dtoTipoCliente);
            
            
                try{
                    UtilidadesLog.debug("Parametros Create: ");
                    UtilidadesLog.debug(importe+" "+cliente+" "+dtoTipoCliente.getOid()+" "+cabecera);
                    dpdLocal = dpd.create(importe,cliente,dtoTipoCliente.getOid(),cabecera);
                }catch(PersistenceException ce){                    
                    UtilidadesLog.error(ce);
                    String codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                    throw new MareException(ce, UtilidadesError.armarCodigoError(codigoError));   
                }
                dpdLocal.setImpDeudaEnviarAdam(importeEnviar);
                dpdLocal.setImpDeudaDescontar(importeDescontar);
                dpd.merge(dpdLocal);
            }
        }catch(NoResultException fe) {

            //Long numeroDocumento, Date fechaCreacion, Long pais, Long acceso, Long estado, Long marca
            try{
                dpcLocal = dpc.create(new Long(dtoe.getNumeroDocumento()), new java.sql.Date(dtoe.getFechaCreacion().getTime()),dtoe.getOidPais(),dtoe.getOidAcceso(),
                                       dtoe.getOidEstatus(),dtoe.getOidMarca());
            }catch(PersistenceException ce){                
                UtilidadesLog.error(ce);
                String codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                throw new MareException(ce, UtilidadesError.armarCodigoError(codigoError));   
            }

            if (dtoe.getNumeroLote()!=null){
                dpcLocal.setNumeroLote(dtoe.getNumeroLote());   
            }
            if (dtoe.getDescripcionLote()!=null){                
                dpcLocal.setDescripcion(dtoe.getDescripcionLote());   
            }
            if (dtoe.getObservaciones()!=null){            
                dpcLocal.setObservaciones(dtoe.getObservaciones());   
            }
            if (dtoe.getFechaVencimientoDesde()!=null){
                dpcLocal.setFechaVencimientoDesde(new java.sql.Date(dtoe.getFechaVencimientoDesde().getTime())); 
            }
            if (dtoe.getFechaVencimientoHasta()!=null){
                dpcLocal.setFechaVencimientoHasta(new java.sql.Date(dtoe.getFechaVencimientoHasta().getTime()));  
            }
            dpc.merge(dpcLocal);

            //Para cada fila del recordSet DTOE.lstDetalle recibida { 
            //Hacer un create en la entidad DescuentosPersonalDetalle 
            RecordSet rs = dtoe.getLstDetalle();
            //Para cada fila del recordSet DTOE.lstDetalle recibida
            for (int j =0; j<rs.getRowCount(); j++){
                cliente = (Long)rs.getValueAt(j,"OIDCLIENTE");
                subtipo = (Long)rs.getValueAt(j,"OIDSUBTIPOCLIENTE");
                importe = (BigDecimal)rs.getValueAt(j,"IMPORTECALCULADO");
                importeDescontar = (BigDecimal)rs.getValueAt(j,"IMPORTEDESCONTAR");
                importeEnviar = (BigDecimal)rs.getValueAt(j,"IMPORTEENVIAR");
                cabecera = dpcLocal.getOid();
            //BigDecimal impDeudaCalculado, Long cliente, Long subtipo, Long numeroDocumento
                DTOTipoSubtipoCliente dtoTipoCliente = null;
                try{                
                    dtoTipoCliente = this.getMONConfiguracionClientes().obtenerTipoPrincipalCliente(cliente);
                }catch(RemoteException re){                    
                        UtilidadesLog.debug("error RemoteException ingresarComisionesEIncentivos ");
                        throw new MareException(re,
                            UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            
                UtilidadesLog.debug("TipoSubtipoCliente: "+ dtoTipoCliente);
                try{
                    UtilidadesLog.debug("Parametros Create: ");
                    UtilidadesLog.debug(importe+" "+cliente+" "+dtoTipoCliente.getOid()+" "+cabecera);
                    dpdLocal = dpd.create(importe,cliente,dtoTipoCliente.getOid(),cabecera);
                }catch(PersistenceException ce){                    
                    UtilidadesLog.error(ce);
                    String codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                    throw new MareException(ce, UtilidadesError.armarCodigoError(codigoError));   
                }
                dpdLocal.setImpDeudaEnviarAdam(importeEnviar);
                dpdLocal.setImpDeudaDescontar(importeDescontar);
                dpd.merge(dpdLocal);
            }

        }  catch (PersistenceException ce) {
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        DAOAdam daoAdam = new DAOAdam(this.ctx.getCallerPrincipal().getName());
        DTOOID dtooid = new DTOOID();
        dtooid.setOidIdioma(dtoe.getOidIdioma());
        dtooid.setOidPais(dtoe.getOidPais());
        dtooid.setOid(dtoe.getOidEstatus());
        DTOEstatus dtoEstatus = daoAdam.obtenerEstatus(dtooid);
        UtilidadesLog.debug(" DTOEstatus dtoEstatus = daoAdam.obtenerEstatus(dtooid); " +dtoEstatus);	
        UtilidadesLog.info("MONAdamBean.guardarDescuento(DTOGenerarFichero dtoe): Salida");
        return dtoEstatus;
    }

    public DTOEstatus generarDescuentosDeuda(DTOGenerarFichero dtoe) throws MareException {
        UtilidadesLog.info("MONAdamBean.generarDescuentosDeuda(DTOGenerarFichero dtoe): Entrada");        
         UtilidadesLog.debug("****Metodo  MONAdam.DTOGenerarFichero: Entrada" +dtoe);	
        
        //Vamos a guardar los datos de pantalla 
        DTOEstatus dtoEstatus = this.guardarDescuento(dtoe);
        UtilidadesLog.debug("  DTOEstatus dtoEstatus = this.guardarDescuento(dtoe); dtoEstatus--->" +dtoEstatus);


        // Recupero el subacceso asociado al usuario 
        String uName = ctx.getCallerPrincipal().getName(); 
        DAOAdam daoAdam = new DAOAdam(uName);
        
        //periodo actual 
        MONPeriodos monPeriodos = this.getMONPeriodos();
        DTOPeriodo dtoPeriodo = null;
        try{
            dtoPeriodo = monPeriodos.obtienePeriodoActual(dtoe.getOidPais(), dtoe.getOidMarca(), dtoe.getOidCanal());
            UtilidadesLog.debug(" dtoPeriodo = monPeriodos.obtienePeriodoActual(dtoe.getOidPais(), dtoe.getOidMarca(), dtoe.getOidCanal());dtoPeriodo  --->" +dtoPeriodo);
        }catch(RemoteException re){            
            UtilidadesLog.error(re);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));   
        }

        //Vamos a obtener para los clientes los tipo de solicitud por proceso 
        
        DTOBuscarSolicitudAdam dtoBuscarSolicitudAdam = new DTOBuscarSolicitudAdam();
        dtoBuscarSolicitudAdam.setOidPais(dtoe.getOidPais());
        dtoBuscarSolicitudAdam.setOidIdioma(dtoe.getOidIdioma());
        dtoBuscarSolicitudAdam.setOidMarca(dtoe.getOidMarca());
        dtoBuscarSolicitudAdam.setOidAcceso(dtoe.getOidAcceso());
        //dtoBuscarSolicitudAdam.setOidSubAcceso(oidSubAcceso);
        dtoBuscarSolicitudAdam.setLstDetalle(dtoe.getLstDetalle());
    
       //UtilidadesLog.debug(" DTOBuscarSolicitudAdams  --->" +dtoBuscarSolicitudAdam);
        ArrayList listaSolicitudes = daoAdam.obtenerTipoSolicitudProceso(dtoBuscarSolicitudAdam);//BELC300014561
       UtilidadesLog.debug(" listaSolicitudes = daoAdam.obtenerTipoSolicitudProceso(dtoBuscarSolicitudAdam);  listaSolicitudes  --->" +listaSolicitudes);


        //Iterator it = listaSolicitudes.iterator(); --> duda
        DTOSolicitudAdam dtoSolicitudAdam = null;
        Iterator it = null;
        Long tipoSubtipo = null;
        Long oidCliente = null;
        String codCliente = null;
        RecordSet rs = dtoe.getLstDetalle();
        for (int i=0; i<rs.getRowCount();i++){
                //Mientras el recordSet DTOGenerarFichero.lstDetalle tenga filas { 
                DTOCabeceraSolicitud dtoCabeceraSolicitud = null;
                tipoSubtipo = (Long)rs.getValueAt(i,"TIPOCLIENTE");
                //Recorremos el ArrayList ListaSolicitudes y obtenemos el objeto que tenga el campo oidTipoCliente 
                //igual a la columna oidTipoCliente de la fila que estamos procesando del recordSet                 
                it = listaSolicitudes.iterator();
                while (it.hasNext()){
                    dtoSolicitudAdam = (DTOSolicitudAdam)it.next();
                    if (dtoSolicitudAdam.getOidTipoCliente().longValue() == tipoSubtipo.longValue()){
                        dtoCabeceraSolicitud = new DTOCabeceraSolicitud();
                        dtoCabeceraSolicitud.setOidPais(dtoe.getOidPais());
                        dtoCabeceraSolicitud.setMarca(dtoe.getOidMarca());
                        dtoCabeceraSolicitud.setCanal(dtoe.getOidCanal());
                        dtoCabeceraSolicitud.setAcceso(dtoe.getOidAcceso());
                        dtoCabeceraSolicitud.setPeriodo(dtoPeriodo.getOid());
                        dtoCabeceraSolicitud.setOperacion(ConstantesBEL.INT083);
                        dtoCabeceraSolicitud.setModulo(ConstantesINT.MODULO_INT);
                        dtoCabeceraSolicitud.setNumeroDocumentoOrigen(new Long(dtoe.getNumeroLote()));
                        dtoCabeceraSolicitud.setFecha(new Date());
                        dtoCabeceraSolicitud.setTipoSolicitud(dtoSolicitudAdam.getOidTipoSolicitud());
                        codCliente = (String)rs.getValueAt(i,"CODCLIENTE");
                        dtoCabeceraSolicitud.setCliente(codCliente);
                        oidCliente = (Long)rs.getValueAt(i,"OIDCLIENTE");
                        dtoCabeceraSolicitud.setOidCliente(oidCliente);



                        DTOPosicionSolicitud dtoPosicion = new DTOPosicionSolicitud();
                        dtoPosicion.setTipoPosicion(dtoSolicitudAdam.getOidTipoPosicion());
                        dtoPosicion.setSubtipoPosicion(dtoSolicitudAdam.getOidSubtipoPosicion());
                        dtoPosicion.setProducto(dtoSolicitudAdam.getOidProducto());
                        dtoPosicion.setUnidadesDemandadas(new Long(1));
                        dtoPosicion.setUnidadesPorAtender(new Long(1));
                        dtoPosicion.setUnidadesDemandaReal(new Long(1));
                        
                        ArrayList posiciones = new ArrayList();
                        posiciones.add(dtoPosicion);
                        dtoCabeceraSolicitud.setPosiciones(posiciones);
 
 
                        MONGenerarSolicitudModulosExternos monGenerar = this.getMONGenerarSolicitudModulosExternos();
                        DTOOID dtooid;
                        try{
                             UtilidadesLog.debug(" dtoCabeceraSolicitud  "+dtoCabeceraSolicitud );               
                             dtooid = monGenerar.generaSolicitud(dtoCabeceraSolicitud);
                              UtilidadesLog.debug(" dtooid = monGenerar.generaSolicitud(dtoCabeceraSolicitud);  dtooid "+dtooid);	
                        }catch(RemoteException re){                            
                            UtilidadesLog.error(re);
                            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));   
                        }

                        break;
                    }
                }
        }    
        UtilidadesLog.debug("dtoEstatus -->" +dtoEstatus);	
        UtilidadesLog.info("MONAdamBean.generarDescuentosDeuda(DTOGenerarFichero dtoe): Salida");        
        return dtoEstatus;
    }

    public DTOIndError comprobarBatch(DTOINT dtoe) throws MareException {
        UtilidadesLog.info("MONAdamBean.comprobarBatch(DTOINT dtoe): Entrada");
        UtilidadesLog.debug("****Metodo  comprobarBatch DTOINT dtoe"  + dtoe);	
        // Diseño cambiado Incidencia BELC300014468
        DAOAdam daoAdam = new DAOAdam(this.ctx.getCallerPrincipal().getName());
        DTOIndError dtoIndError = daoAdam.comprobarBatch(dtoe);
        UtilidadesLog.debug(" DTOIndError dtoIndError = daoAdam.comprobarBatch(dtoe);  ---->dtoIndError"   + dtoIndError);
        if (dtoIndError==null){
            return null;
        }else{
            if(dtoIndError.getIndLog().longValue()==0){
                DTOOID dtooid = new DTOOID();
                dtooid.setOidIdioma(dtoe.getOidIdioma());
                dtooid.setOidPais(dtoe.getOidPais());
                dtooid.setOid(ConstantesINT.ESTADO_ENVIADO);
                DTOEstatus dtoEstatus = daoAdam.obtenerEstatus(dtooid);
                UtilidadesLog.debug(" DTOEstatus dtoEstatus = daoAdam.obtenerEstatus(dtooid);  ---->dtoEstatus"   + dtoEstatus);
                dtoIndError.setEstado(dtoEstatus.getCadena()); 
                
            }
        }
        UtilidadesLog.debug("\ndtoIndError"   + dtoIndError);
        UtilidadesLog.info("MONAdamBean.comprobarBatch(DTOINT dtoe): Salida");				
        return dtoIndError;
    }

    public DTOGenerarFichero recuperarLote(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("MONAdamBean.recuperarLote(DTOOID dtoe): Entrada");
        UtilidadesLog.debug("****Metodo  DTOOID dtoe "+ dtoe);
        DAOAdam daoAdam = new DAOAdam(this.ctx.getCallerPrincipal().getName());
        
        // Cambia por incidencia: BELC300014499 
        
        DTOGenerarFichero dto = daoAdam.recuperarCabecera(dtoe);
        UtilidadesLog.debug("DTOGenerarFichero dto = daoAdam.recuperarCabecera(dtoe);  DTOGenerarFichero--> "+ dto);
        
        //Vamos a recuperar los detalles para esa cabecera 
        RecordSet listaDetalles = daoAdam.recuperarDetalle(dtoe);
        UtilidadesLog.debug("RecordSet listaDetalles = daoAdam.recuperarDetalle(dtoe);  -->listaDetalles "+ listaDetalles);
        
        //Vamos a calcular la línea de crédito disponible. Esto se lo añadimos al recordSet ListaClient 
        RecordSet listaCompleta = this.calcularLineaCreditoDisp(listaDetalles, dtoe.getOidIdioma(), dtoe.getOidPais());
        UtilidadesLog.debug("\n\n RecordSet listaCompleta = this.calcularLineaCreditoDisp(listaDetalles, dtoe.getOidIdioma(), dtoe.getOidPais());  -->listaCompleta "+ listaCompleta);
        
        //Seteamos en el campo lstDetalle del DTOGenerarFichero la ListaCompleta anteriormente hallada 
        if (dto!=null){
            dto.setLstDetalle(listaCompleta);
        }
        
        //Se devuelve este DTOGenerarFichero

        UtilidadesLog.debug("dto de salida del metodo "+ dto);
        UtilidadesLog.info("MONAdamBean.recuperarLote(DTOOID dtoe): Salida");
        return dto;
    }

    public DTOSalida recuperarEstatus(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("MONAdamBean.recuperarEstatus(DTOBelcorp dtoe): Entrada");
        DAOAdam daoAdam = new DAOAdam(this.ctx.getCallerPrincipal().getName());
        RecordSet rs = daoAdam.recuperarEstatus(dtoe);
        DTOSalida dtoSalida = new DTOSalida(rs);			
        UtilidadesLog.info("MONAdamBean.recuperarEstatus(DTOBelcorp dtoe): Salida");
        return dtoSalida;
    }

    public DTOSalida buscarDescuentos(DTOBusquedaDescuentos dtoe) throws MareException {
        UtilidadesLog.info("MONAdamBean.buscarDescuentos(DTOBusquedaDescuentos dtoe): Entrada");        
        
        if(dtoe.getStringStatus()!=null){
            String cadena=dtoe.getStringStatus();
            ArrayList array=this.convertirStringTOArray(cadena);
            dtoe.setEstados(array);
        }        
        
        DAOAdam daoAdam = new DAOAdam(this.ctx.getCallerPrincipal().getName());
            
        RecordSet rs = daoAdam.buscarDescuentos(dtoe);
        DTOSalida dtoSalida = new DTOSalida(rs);
        if (rs.esVacio()) {
           //GEN-0007 --> 005
             UtilidadesLog.debug("****MONADAM.buscarDescuentos: no hay datos ");                                            
           //this.loguearError("cargaAsignarAptas: FinderException",ce);
            throw new MareException(new Exception(),
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
       }

        UtilidadesLog.info("MONAdamBean.buscarDescuentos(DTOBusquedaDescuentos dtoe): Salida");        
        return dtoSalida;
    }

    public DTODate obtenerFechaDesde(DTOINT dtoe) throws MareException {
        UtilidadesLog.info("MONAdamBean.obtenerFechaDesde(DTOINT dtoe): Entrada");
        //Se crea un DTODate 
        //DTODate= llamar al método obtenerFechaDesde(DTOE) del DAOAdam 
        DAOAdam daoAdam = new DAOAdam(this.ctx.getCallerPrincipal().getName());
        DTODate dtoDate = daoAdam.obtenerFechaDesde(dtoe);
        //Se devuelve este DTODate    			
        UtilidadesLog.info("MONAdamBean.obtenerFechaDesde(DTOINT dtoe): Salida");
        return dtoDate;
    }

// MONMantenimientoSEG
	 private MONMantenimientoSEG getMONMantenimientoSEG() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONAdamBean.getMONMantenimientoSEG(): Entrada");
        MONMantenimientoSEGHome home = (MONMantenimientoSEGHome)UtilidadesEJB.getHome("MONMantenimientoSEG", MONMantenimientoSEGHome.class);
            
        // Se obtiene el interfaz remoto
        MONMantenimientoSEG ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONAdamBean.getMONMantenimientoSEG(): Salida");
        return ejb;
	}   

// MONConfiguracionClientes
	 private MONConfiguracionClientes getMONConfiguracionClientes() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONAdamBean.getMONConfiguracionClientes(): Entrada");
        MONConfiguracionClientesHome home = (MONConfiguracionClientesHome)UtilidadesEJB.getHome("MONConfiguracionClientes", MONConfiguracionClientesHome.class);
            
        // Se obtiene el interfaz remoto
        MONConfiguracionClientes ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONAdamBean.getMONConfiguracionClientes(): Salida");
        return ejb;
	}   

// MONPeriodos
	 private MONPeriodos getMONPeriodos() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONAdamBean.getMONPeriodos(): Entrada");
        MONPeriodosHome home = (MONPeriodosHome)UtilidadesEJB.getHome("MONPeriodos", MONPeriodosHome.class);
            
        // Se obtiene el interfaz remoto
        MONPeriodos ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONAdamBean.getMONPeriodos(): Salida");
        return ejb;
	}   

// MONGenerarSolicitudModulosExternos
	 private MONGenerarSolicitudModulosExternos getMONGenerarSolicitudModulosExternos() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONAdamBean.getMONGenerarSolicitudModulosExternos(): Entrada");
        MONGenerarSolicitudModulosExternosHome home = (MONGenerarSolicitudModulosExternosHome)UtilidadesEJB.getHome("MONGenerarSolicitudModulosExternos", MONGenerarSolicitudModulosExternosHome.class);
            
        // Se obtiene el interfaz remoto
        MONGenerarSolicitudModulosExternos ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONAdamBean.getMONGenerarSolicitudModulosExternos(): Salida");
        return ejb;
	}   

	private MONProcesosPED getMONProcesosPED() throws MareException {
	    // Se obtiene el interfaz home
        UtilidadesLog.info("MONAdamBean.getMONProcesosPED(): Entrada");
        MONProcesosPEDHome home = (MONProcesosPEDHome)UtilidadesEJB.getHome(
        "MONProcesosPED", MONProcesosPEDHome.class);
        // Se obtiene el interfaz remoto
        MONProcesosPED ejb = null;
        try {
			ejb = home.create();
		} catch (Exception e) {		
			UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		} 
        UtilidadesLog.info("MONAdamBean.getMONProcesosPED(): Salida");
        return ejb;
	}
	
	private MONInterfaceModulos getMONInterfaceModulos() throws MareException {
	    // Se obtiene el interfaz home
        UtilidadesLog.info("MONAdamBean.getMONInterfaceModulos(): Entrada");
        MONInterfaceModulosHome home = (MONInterfaceModulosHome)UtilidadesEJB.getHome(
        "MONInterfaceModulos", MONInterfaceModulosHome.class);
        // Se obtiene el interfaz remoto
        MONInterfaceModulos ejb = null;
        try {
			ejb = home.create();
		} catch (Exception e) {
		
			UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		} 
        UtilidadesLog.info("MONAdamBean.getMONInterfaceModulos(): Salida");
        return ejb;
	}
	
	private MONINT getMONINT() throws MareException {
	    // Se obtiene el interfaz home
        UtilidadesLog.info("MONAdamBean.getMONINT(): Entrada");
        MONINTHome home = (MONINTHome)UtilidadesEJB.getHome(
        "MONINT", MONINTHome.class);
        // Se obtiene el interfaz remoto
        MONINT ejb = null;
        try {
			ejb = home.create();
		} catch (Exception e) {
		
			UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		} 
        UtilidadesLog.info("MONAdamBean.getMONINT(): Salida");
        return ejb;
	}


    private ArrayList convertirStringTOArray(String cadena)throws MareException{
    //Recibe un string separado por # y lo convierte en un array de LONGS
    UtilidadesLog.info("MONAdamBean.convertirStringTOArray(String cadena): Entrada");
    UtilidadesLog.debug("****Metodo MONAdam.convertirStringTOArray: cadena" +cadena);
    StringTokenizer st = new StringTokenizer(cadena, ",");
    ArrayList array=new ArrayList();
          
        while (st.countTokens()> 0) {
            String fila = st.nextToken();
            if(fila!=null){
                Long longi=new Long(fila);
                array.add(longi);
                UtilidadesLog.debug("Long " +longi);
           }
         }

       UtilidadesLog.debug("****Metodo MONAdam.convertirStringTOArray: array" +array);
       UtilidadesLog.info("MONAdamBean.convertirStringTOArray(String cadena): Salida");  
     return array;
     }

    private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinessFacadeBATCH");
    }
    
    private IngresoComisionesEIncentivosLocalHome getIngresoComisionesEIncentivosLocalHome() {
            return new IngresoComisionesEIncentivosLocalHome();
    }

    private DescuentosPersonalCabeceraLocalHome getDescuentosPersonalCabeceraLocalHome() {
            return new DescuentosPersonalCabeceraLocalHome();
    }

    private DescuentosPersonalDetalleLocalHome getDescuentosPersonalDetalleLocalHome() {
            return new DescuentosPersonalDetalleLocalHome();
    }

    
}