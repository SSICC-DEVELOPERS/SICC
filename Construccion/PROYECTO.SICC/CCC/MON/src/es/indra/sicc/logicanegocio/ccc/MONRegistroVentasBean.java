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
 
package es.indra.sicc.logicanegocio.ccc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;

import es.indra.sicc.dtos.ccc.DTOBuscarRegistroVentas;
import es.indra.sicc.dtos.ccc.DTOFecha;
import es.indra.sicc.dtos.ccc.DTONumRegistros;
import es.indra.sicc.dtos.ccc.DTORegistroVentas;

import es.indra.sicc.entidades.fac.RegistroUnicoVentasLocalHome;

import es.indra.sicc.logicanegocio.ccc.DAORegistroVentas;
import es.indra.sicc.logicanegocio.ccc.ErroresDeNegocio;
import es.indra.sicc.logicanegocio.mae.MONClientes;
import es.indra.sicc.logicanegocio.mae.MONClientesHome;
import es.indra.sicc.logicanegocio.ped.DAOParametrosPedidos;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;

import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.ExcepcionParametrizada;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.rmi.RemoteException;

import java.util.Vector;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONRegistroVentasBean implements SessionBean  {
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

	public DTOSalida buscarRegistroVentas(DTOBuscarRegistroVentas dto) throws MareException {
		//Llamamos a DAORegistroVentas.buscarRegistroVentas(dto)                 
        
		UtilidadesLog.info("MONRegistroVentasBean.buscarRegistroVentas(DTOBuscarRegistroVentas dto): Entrada");
        
		this.validaAcceso(dto.getOidPais(),null,null,null,null,null,null,null,null,null,null);
		DTOSalida dtoSalida=new DTOSalida();                                                            
		String usuario=ctx.getCallerPrincipal().getName();                                              
		DAORegistroVentas daoRegistroVentas= new DAORegistroVentas(usuario);                       
		dtoSalida.setResultado(daoRegistroVentas.buscarRegistroVentas(dto,usuario));
																
			                                                                                                         
		RecordSet rs=new RecordSet();                                                                   
		rs=dtoSalida.getResultado();                                                                    
		 if (rs.esVacio()) {                                                                            
            		//GEN-0007 --> 005                                                                                  
			UtilidadesLog.debug("****DAORegistroVentas.buscarRegistroVentas(dto): No hay datos ");				
			//UtilidadesLog.error("cargaAsignarAptas: FinderException",ce);                           
            		throw new MareException(new Exception(),                                                            
                		UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));        
        	}                                                                                                       
		UtilidadesLog.info("MONRegistroVentasBean.buscarRegistroVentas(DTOBuscarRegistroVentas dto): Salida");
		return dtoSalida;                                                                               
	}

	public DTOSalida buscarRegistroVentas(DTOOID dto) throws MareException {

		//Llamamos a DAORegistroVentas.buscarRegistroVentas(dto)                 
		UtilidadesLog.info("MONRegistroVentasBean.buscarRegistroVentas(DTOOID dto): Entrada");
		this.validaAcceso(dto.getOidPais(),null,null,null,null,null,null,null,null,null,null);
		DTOSalida dtoSalida=new DTOSalida();                                                            
		String usuario=ctx.getCallerPrincipal().getName();                                              
		DAORegistroVentas daoRegistroVentas= new DAORegistroVentas(usuario);                       
		dtoSalida.setResultado(daoRegistroVentas.buscarRegistroVentas(usuario,dto.getOidPais(),dto.getOid())); 
		//String usuario, Long oidPais, Long oidReg
		RecordSet rs=new RecordSet();                                                                   
		rs=dtoSalida.getResultado();                                                                    
		 if (rs.esVacio()) {                                                                            
            		//GEN-0007 --> 005                                                                                  
			UtilidadesLog.debug("****DAORegistroVentas.buscarRegistroVentas(dto): No hay datos ");				
			//UtilidadesLog.error("cargaAsignarAptas: FinderException",ce);                           
            		throw new MareException(new Exception(),                                                            
                		UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));        
        	}                                                                                                       
		UtilidadesLog.info("MONRegistroVentasBean.buscarRegistroVentas(DTOOID dto): Salida");
		return dtoSalida;                                                                               
	}

	

	public void guardarRegistroVentas(DTORegistroVentas dto) throws  RemoteException, MareException {
	    UtilidadesLog.info("MONRegistroVentasBean.guardarRegistroVentas(DTORegistroVentas dto): Entrada");
	          String usuario=ctx.getCallerPrincipal().getName();  
	          DAORegistroVentas dao = new DAORegistroVentas(usuario);
	          int cant = dao.validarRegistro(dto);
	          
	          if( cant > 0 )
	          {
	             
	              ExcepcionParametrizada ex = new  ExcepcionParametrizada(new MareException(),
	                                               UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
	                                               ErroresDeNegocio.CCC_0062));
	                                               throw ex;
	          }else
	          {
	                 if(dto.getNumeroDocumentoLegalFinal() == null || dto.getNumeroDocumentoLegalFinal() == ""){  
	                   
	                   MONClientes monClientes = null; //Es un mon de mae
	                   Long oidCliente;
	                   monClientes = this.getMONClientes();
	                   try{
	                       oidCliente = monClientes.obtenerOidCliente(dto.getOidPais(),dto.getCodigoCliente()); //BELC300007648
	                   }catch(RemoteException e){
	                      UtilidadesLog.error(e);
	                      throw new MareException(e,UtilidadesError.armarCodigoError(
	                      CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));                   
	                   }              
	                                
	                   dao.guardar(dto, oidCliente);
	                 }else
	                 {
	                      UtilidadesLog.debug("Creo los registros faltantes");
	                      int cant1 = dao.validarDocLegal(dto);
	                      if(cant1 > 0)
	                      {
	                          ExcepcionParametrizada ex = new  ExcepcionParametrizada(new MareException(),
	                                               UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
	                                               ErroresDeNegocio.CCC_0061));
	                                               throw ex;
	                      }else
	                      {
	                          
	                          int docLegalInc = Integer.valueOf(dto.getNumeroDocumentoLegal()).intValue();
	                          int docLegalFin = Integer.valueOf(dto.getNumeroDocumentoLegalFinal()).intValue();
                                  //sb
                                   int docCtrolInc=0;
                                   if(dto.getNumDocControlLegal() != null && dto.getNumDocControlLegal() != "")
                                       docCtrolInc =  Integer.valueOf(dto.getNumDocControlLegal()).intValue();
                                  
	                          Vector parametros = new Vector();
	                          
	                          while(docLegalInc <= docLegalFin)
	                          {     
	                                
	                                DTORegistroVentas dto1 =  new DTORegistroVentas();
	                                dto1.setApellido1(dto.getApellido1());
	                                dto1.setApellido2(dto.getApellido2());
	                                dto1.setOidPais(dto.getOidPais());
	                                dto1.setBaseImponible(dto.getBaseImponible());
	                                dto1.setBaseImponibleNeto(dto.getBaseImponibleNeto());
	                                dto1.setCodigoCliente(dto.getCodigoCliente());
	                                dto1.setCoeficienteImpuesto( dto.getCoeficienteImpuesto());
	                                dto1.setDescuento(dto.getDescuento());
	                                dto1.setEstadoAnulado(dto.getEstadoAnulado());
	                                dto1.setEstadoRUV( dto.getEstadoRUV());
	                                dto1.setFechaEmision( dto.getFechaEmision());
	                                dto1.setImporteImpuesto( dto.getImporteImpuesto());
	                                dto1.setImporteTotal( dto.getImporteTotal());
	                                dto1.setIndTransfGratuita( dto.getIndTransfGratuita());
	                                dto1.setNombre1( dto.getNombre1());
	                                dto1.setNombre2(dto.getNombre2());
	                                
	                                dto1.setNumeroDocumentoLegal(String.valueOf(docLegalInc));
	                                dto1.setNumeroDocumentoRef( dto.getNumeroDocumentoRef());
	                                dto1.setNumeroIdentificacionFiscal( dto.getNumeroIdentificacionFiscal());
	                                dto1.setNumeroIdentificacionNacional(dto.getNumeroIdentificacionNacional());
	                                dto1.setOidAcceso( dto.getOidAcceso());
	                                dto1.setOidCanal( dto.getOidCanal());
	                                dto1.setOidEmpresa( dto.getOidEmpresa());
	                                dto1.setOidIndImpuestos(dto.getOidIndImpuestos());
	                                dto1.setOidReg( dto.getOidReg());
	                                dto1.setOidSubAcceso(dto.getOidSubAcceso());
	                                dto1.setOidTipoDocumentoLegal( dto.getOidTipoDocumentoLegal());
	                                dto1.setOidTipoDocumentoRef( dto.getOidTipoDocumentoRef());
	                                dto1.setPuntoEmision( dto.getPuntoEmision());
	                                dto1.setSerieDocumentoLegal( dto.getSerieDocumentoLegal());
	                                dto1.setSerieDocumentoRef( dto.getSerieDocumentoRef());
                                        
	                                //sapaza -- PER-SiCC-2010-0487 -- 16/08/2010
	                                dto1.setOidTipoDocumento( dto.getOidTipoDocumento());
	                                dto1.setFechaEmisionReferencia(dto.getFechaEmisionReferencia());
                                        //sbuchelli
                                        if(dto.getNumDocControlLegal() != null && dto.getNumDocControlLegal() != ""){                                           
                                            dto1.setNumDocControlLegal(String.valueOf(docCtrolInc));
                                            docCtrolInc++;
                                        }
                                        //dto1.setNumDocControlFinalLegal(dto.getNumDocControlFinalLegal());
                                        //
	                                parametros.add(dto1);
	                                UtilidadesLog.debug("Cantidad: " + docLegalInc);
	                                docLegalInc++;                                                   
	                          } 
	                          //while
	                          MONClientes monClientes = null; //Es un mon de mae
	                          Long oidCliente;
	                          monClientes = this.getMONClientes();
	                          try{
	                              oidCliente = monClientes.obtenerOidCliente(dto.getOidPais(),dto.getCodigoCliente()); //BELC300007648
	                          }catch(RemoteException e){
	                             UtilidadesLog.error(e);
	                             throw new MareException(e,UtilidadesError.armarCodigoError(
	                             CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));                    
	                          }
	                          for(int i = 0; i < parametros.size(); i++){
	                             DTORegistroVentas dto8 = (DTORegistroVentas) parametros.elementAt(i);                        
	                             dao.guardar(dto8, oidCliente);
	                          }
	                      }// else if(cant > 0)
	                 }// else if(!dto.getNumeroDocumentoLegalFinal() != null || !dto.getNumeroDocumentoLegalFinal() != "")
	          }// else1 if( cant > 0 )
	}

	public void eliminarRegistrosVentas(DTOOIDs dto) throws  RemoteException, MareException{
	    UtilidadesLog.info("MONRegistroVentasBean.eliminarRegistrosVentas(DTOOIDs dto): Entrada");
	    this.validaAcceso(dto.getOidPais(), null, null, null, null, null, null, null, null,null,null);
	    String usuario=ctx.getCallerPrincipal().getName();  
	    DAORegistroVentas dao = new DAORegistroVentas(usuario);
	    dao.remove( dto);
	    UtilidadesLog.info("MONRegistroVentasBean.eliminarRegistrosVentas(DTOOIDs dto): Salida");
	}

	public DTONumRegistros cerrarRegistrosVentas(DTOBuscarRegistroVentas dto) throws  MareException {
/* El sistema actualiza la entidad "Registro único de ventas" (FAC) actualizando
 * el atributo Estado RUV a '(C)errado' para todos los registros que cumplan los
 * criterios introducidos y estuvieran en estado "Activo". Como fecha de cierre
 * se introduce la proporcionada por el usuario. 
 * */
		UtilidadesLog.info("MONRegistroVentasBean.cerrarRegistrosVentas(DTOBuscarRegistroVentas dto): Entrada");
		this.validaAcceso(dto.getOidPais(),null,null,null,null,null,null,null,null,null,null);
		MONClientes monClientes = null; //Es un mon de mae
		Long oidClienteDesde = null;
		Long oidClienteHasta = null;

		monClientes = this.getMONClientes();
				
		//Cambiado por incidencia BELC300007971:
		if(dto.getCodigoClienteDesde()!=null){
			if(dto.getCodigoClienteDesde().length() > 0){ //No blancos
				try{
					oidClienteDesde = monClientes.obtenerOidCliente(dto.getOidPais(),dto.getCodigoClienteDesde());
				}catch(RemoteException e){
					UtilidadesLog.error(e);
					throw new MareException(e,UtilidadesError.armarCodigoError(
										CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
				}
				if(oidClienteDesde==null){ //No localiza el codigo de cliente
					throw new MareException(null,null,UtilidadesError.armarCodigoError("16", "", es.indra.sicc.logicanegocio.mae.ErroresDeNegocio.MAE_0024));
				}
			}
		}
		if(dto.getCodigoClienteHasta()!=null){
			if(dto.getCodigoClienteHasta().length() > 0){ //No blancos
				try{
					oidClienteHasta = monClientes.obtenerOidCliente(dto.getOidPais(),dto.getCodigoClienteHasta());
				}catch(RemoteException e){
					UtilidadesLog.error(e);
					throw new MareException(e,UtilidadesError.armarCodigoError(
										CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
				}
				if(oidClienteHasta==null){ //No localiza el codigo de cliente
					throw new MareException(null,null,UtilidadesError.armarCodigoError("16", "", es.indra.sicc.logicanegocio.mae.ErroresDeNegocio.MAE_0024));
				}
			}
		}
		
		DAORegistroVentas daoRegistroVentas = new DAORegistroVentas(ctx.getCallerPrincipal().getName());
		DTOBuscarRegistroVentas dtoe = new DTOBuscarRegistroVentas();
		if(oidClienteDesde==null){
			dtoe.setCodigoClienteDesde(null);
		}else{
			dtoe.setCodigoClienteDesde(oidClienteDesde.toString());
		}
		if(oidClienteHasta==null){
			dtoe.setCodigoClienteHasta(null);
		}else{
			dtoe.setCodigoClienteHasta(oidClienteHasta.toString());
		}
		dtoe.setFechaCierre(dto.getFechaCierre());
		dtoe.setFechaEmisionDesde(dto.getFechaEmisionDesde());
		dtoe.setFechaEmisionHasta(dto.getFechaEmisionHasta());
		dtoe.setOidImpuestos(dto.getOidImpuestos());

		DTONumRegistros dtoNumRegistros = new DTONumRegistros();
		dtoNumRegistros = daoRegistroVentas.cerrarRegistrosVentas(dtoe);
		UtilidadesLog.info("MONRegistroVentasBean.cerrarRegistrosVentas(DTOBuscarRegistroVentas dto): Salida");
		return dtoNumRegistros;
	}

	public DTONumRegistros reabrirRegistrosVentas(DTOFecha dtoe) throws MareException {
		/* El sistema actualiza la entidad "Registro único de ventas" (FAC)
		 * actualizando el atributo Estado RUV a '(A)ctivo' e inicializando 
		 * a nulos la Fecha de Cierre.para todos los registros que tengan
		 * la fecha de cierre introducida por el usuario y Estado de RUV=(C)errado. 
		 */
		UtilidadesLog.info("MONRegistroVentasBean.reabrirRegistrosVentas(DTOFecha dtoe): Entrada");
		this.validaAcceso(dtoe.getOidPais(),null,null,null,null,null,null,null,null,null,null);
		String usuario = ctx.getCallerPrincipal().getName();
				
		DAORegistroVentas dao = new DAORegistroVentas(usuario);
		DTONumRegistros dtoNumReg= new DTONumRegistros();
		dtoNumReg = dao.reabrirRegistrosVentas(dtoe); 

		UtilidadesLog.info("MONRegistroVentasBean.reabrirRegistrosVentas(DTOFecha dtoe): Salida");
		// Devolvemos el número de registros que se han "Reabierto". 
		return dtoNumReg;
	}

	// Realizado por incidencia: BELC300007750
	public DTOSalida obtenerTasasImpuestoPorPais(DTOBelcorp dtoe) throws  MareException {
		UtilidadesLog.info("MONRegistroVentasBean.obtenerTasasImpuestoPorPais(DTOBelcorp dtoe): Entrada");
		this.validaAcceso(dtoe.getOidPais(),null,null,null,null,null,null,null,null,null,null);
		//String usuario = ctx.getCallerPrincipal().getName();
				
		DAOParametrosPedidos dao = new DAOParametrosPedidos();
		DTOSalida dtoSalida = new DTOSalida();
		dtoSalida.setResultado(dao.obtenerTasasImpuestoPorPais(dtoe));
		UtilidadesLog.info("MONRegistroVentasBean.obtenerTasasImpuestoPorPais(DTOBelcorp dtoe): Salida");
		// Devolvemos el número de registros que se han "Reabierto". 
		return dtoSalida;
	}


// Funciones Ayuda
	private void loguearSql(String metodo, String sql, Vector params){
        UtilidadesLog.info("MONRegistroVentasBean.loguearSql(String metodo, String sql, Vector params): Entrada");
		UtilidadesLog.debug(metodo + sql);
		if (params!=null && params.size()>0){
			String sParams="";
			for (int i=0; i<params.size();i++){
				if (params.elementAt(i)!=null)
					sParams+="param "+ (i+1) + ": " +  (params.elementAt(i)).toString() + ", ";
				else
					sParams+="param "+ (i+1) + ": es nulo, ";
			}
			UtilidadesLog.debug(metodo + sParams);
		}		
        UtilidadesLog.info("MONRegistroVentasBean.loguearSql(String metodo, String sql, Vector params): Salida");
	}

// MONcliente
	 private MONClientes getMONClientes() throws MareException {
        // Se obtiene el interfaz home
		UtilidadesLog.info("MONRegistroVentasBean.getMONClientes(): Entrada");
        MONClientesHome home = (MONClientesHome)UtilidadesEJB.getHome("MONClientes", MONClientesHome.class);
            
        // Se obtiene el interfaz remoto
        MONClientes ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			
			UtilidadesLog.error(e);
			ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.info("MONRegistroVentasBean.getMONClientes(): Salida");
        return ejb;
	}  


// Validaciones
	private void validaAcceso(Long pais, Long sociedad, Long marca, Long canal, Long acceso, 
        Long subacceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio)
        throws MareException {
        UtilidadesLog.info("MONRegistroVentasBean.validaAcceso(Long pais, Long sociedad, Long marca, Long canal, Long acceso, Long subacceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio): Entrada");

        MONValidacion monValidacion = this.getMONValidacion();
        Boolean b = Boolean.valueOf(true);

        UtilidadesLog.debug("****Llamada a validaAcceso(pais= " + pais + ",sociedad = " + sociedad +
            ", marca=" + marca + ", canal= " + canal + ", acceso=" + acceso + ",subacceso = "
	        + subacceso +  ", subgerencia=" + subgerencia + ", region=" + region + ", zona=" +
            zona + ", seccion=" + seccion + ", territorio=" + territorio);

        try {
            b = monValidacion.validarAccesos(pais, sociedad, marca, canal, acceso,
                    subacceso, subgerencia, region, zona, seccion, territorio);
        } catch (RemoteException rExc) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(
                "****Metodo validaAccesoVinculos: validaAcceso : ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.debug("****Retorno validaAcceso : " + b.toString());

        if (!b.booleanValue()) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(
                "****Metodo validaAccesoVinculos: validaAcceso : ERROR_ASOCIACION_ESTRUCTURAL");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_ASOCIACION_ESTRUCTURAL));
        }

        UtilidadesLog.info("MONRegistroVentasBean.validaAcceso(Long pais, Long sociedad, Long marca, Long canal, Long acceso, Long subacceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio): Salida");
    }


	private MONValidacion getMONValidacion() throws MareException {
        // Se obtiene el interfaz home
		UtilidadesLog.info("MONRegistroVentasBean.getMONValidacion(): Entrada");
        MONValidacionHome home = (MONValidacionHome)UtilidadesEJB.getHome(
            "MONValidacion", MONValidacionHome.class);
            
        // Se obtiene el interfaz remoto
        MONValidacion ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.info("MONRegistroVentasBean.getMONValidacion(): Salida");
        return ejb;
	}	

	private RegistroUnicoVentasLocalHome getRegistroUnicoVentasLocalHome() throws MareException {
		UtilidadesLog.info("MONRegistroVentasBean.getRegistroUnicoVentasLocalHome(): Entrada");
		RegistroUnicoVentasLocalHome registroUnicoVentasLocalHome = (RegistroUnicoVentasLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/RegistroUnicoVentas");
		UtilidadesLog.info("MONRegistroVentasBean.getRegistroUnicoVentasLocalHome(): Salida");
		return registroUnicoVentasLocalHome;
	}

	//Añadido por incidencia 11525
	public DTOSalida obtenerCoeficienteImpuesto(DTOOID dto) throws MareException {
		UtilidadesLog.info("MONRegistroVentasBean.obtenerCoeficienteImpuesto(DTOOID dto): Entrada");

		DTOSalida dtoSalida = new DTOSalida();
		DAOParametrosPedidos dao = new DAOParametrosPedidos();
		dtoSalida = dao.obtenerCoeficienteImpuesto(dto);

		UtilidadesLog.info("MONRegistroVentasBean.obtenerCoeficienteImpuesto(DTOOID dto): Salida");
		return dtoSalida;
	}

    public void update(DTORegistroVentas dtoe) throws MareException {
        UtilidadesLog.info("MONRegistroVentasBean.update(DTORegistroVentas dtoe): Entrada");
             String usuario=ctx.getCallerPrincipal().getName();
              DAORegistroVentas dao = new DAORegistroVentas(usuario);
              int cant = dao.validarRegistro(dtoe);              
              MONClientes monClientes = null; //Es un mon de mae
              Long oidCliente;
              monClientes = this.getMONClientes();
              try{
                     oidCliente = monClientes.obtenerOidCliente(dtoe.getOidPais(),dtoe.getCodigoCliente()); //BELC300007648
              }catch(RemoteException e){
                      UtilidadesLog.error(e);
                      throw new MareException(e,UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
             }
             dao.update(dtoe, oidCliente);
              
            UtilidadesLog.info("MONRegistrosVentasBean.update(DTORegistroVentas dtoe): Salida");
    }

    public DTOSalida creacionFichero(DTOBuscarRegistroVentas dto) throws MareException {
        UtilidadesLog.info("MONRegistrosVentasBean.creacionFichero(DTOCreacionFichero dtoe): Entrada");
           
           UtilidadesLog.debug("DTOCreacionFichero: " + dto);
           String usuario=ctx.getCallerPrincipal().getName();    
           
           try  {
            
             DAORegistroVentas dao = new DAORegistroVentas(usuario);       
             RecordSet rs2 = dao.buscarRegistroVentas(dto,usuario);
             
             DTOSalida dtoSalida = new DTOSalida();
             
             dtoSalida.setResultado(rs2);
             
             UtilidadesLog.info("MONRegistroVentasBean.creacionRegistro(DTOCreacionFichero dtoe): Salida");
             
             return dtoSalida;
             
           } catch(Exception ex)  {
               UtilidadesLog.error(ex);       
               throw new MareException(ex);
           }   
         }
    
}
