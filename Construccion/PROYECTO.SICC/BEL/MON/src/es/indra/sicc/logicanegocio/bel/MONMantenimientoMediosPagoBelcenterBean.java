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

package es.indra.sicc.logicanegocio.bel;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mii.services.logging.LoggingService;

import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesI18N;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import es.indra.sicc.dtos.bel.DTOMediosPagoBelcenter;
import es.indra.sicc.dtos.bel.DTOEBuscarMediosPagoBelcenter;

import es.indra.sicc.logicanegocio.bel.DAOMediosPagoBelcenter;
import es.indra.sicc.entidades.bel.MediosDePagoBelcenterLocalHome;
import es.indra.sicc.entidades.bel.MediosDePagoBelcenterLocal;

import es.indra.sicc.entidades.seg.AccesoLocalHome;
import es.indra.sicc.entidades.seg.AccesoLocal;

import es.indra.sicc.entidades.seg.SubaccesoLocalHome;
import es.indra.sicc.entidades.seg.SubaccesoLocal;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Vector;
import java.util.ArrayList;
import java.util.Iterator;

import java.math.BigDecimal;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.CreateException;
import javax.ejb.DuplicateKeyException;
import java.rmi.RemoteException;

import javax.persistence.NoResultException;

import javax.persistence.PersistenceException;


public class MONMantenimientoMediosPagoBelcenterBean implements SessionBean  {

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
     * Método para buscar medios pago
     * @param dto DTOEBuscarMediosPagoBelcenter 
     * @return DTOSalida el resultado de la busqueda
     * @exception MareException 
     */
	public DTOSalida buscarMediosPagoBelcenter(DTOEBuscarMediosPagoBelcenter dto) throws MareException {
		UtilidadesLog.info("MONMantenimientoMediosPagoBelcenterBean.buscarMediosPagoBelcenter(DTOEBuscarMediosPagoBelcenter dto):Entrada");
		DTOSalida resultado = new DTOSalida();

		//Documentation
		//Entrada: DTOEBuscarMediosPagoBelcenter 
		//Proceso: 
		//-> Llamar al método "DAOMediosPagoBelcenter.buscarMediosPagoBelcenter(dto : DTOEBuscarMediosPagoBelcenter) : DTOSalida" 
		//-> Devolver objeto DTOSalida obtenido en actividad anterior

		String usuario = ctx.getCallerPrincipal().getName();
		DAOMediosPagoBelcenter dao = new DAOMediosPagoBelcenter(usuario);
		resultado = dao.buscarMediosPagoBelcenter(dto);
		if(resultado.getResultado().esVacio()) {
			UtilidadesLog.debug("****buscarMediosPagoBelcenter: no hay datos ");				
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		}
		
		UtilidadesLog.info("MONMantenimientoMediosPagoBelcenterBean.buscarMediosPagoBelcenter(DTOEBuscarMediosPagoBelcenter dto):Salida");
		return resultado;
	}

	/** 
     * Método para eliminar meidos pago
     * @param dto DTOOIDs 
     * @return void
     * @exception MareException 
     */
	public void eliminarMediosPagoBelcenter(DTOOIDs dto) throws MareException {
		 UtilidadesLog.info("MONMantenimientoMediosPagoBelcenterBean.eliminarMediosPagoBelcenter(DTOOIDs dto):Entrada");
		 MONValidacion monValidacion = this.getMONValidacion();
		//Documentation
		//Entrada: DTOOIDs 
		//Proceso: 
		//Para cada oid contenido en el dto de entrada hacer: 
		//-> Hacer findByPrimaryKey sobre la entidad MediosDePagoBelcenter 
		//-> Hacer remove 
		//Fin Para
        Long oids[] = dto.getOids();
        String codigoError = null;
        
        if(oids !=null && oids.length>0) {
            try {
            MediosDePagoBelcenterLocalHome mdpH = this.getMediosDePagoBelcenterLocalHome();
            MediosDePagoBelcenterLocal  mdpL = null;
            for (int i = 0; i <oids.length; i++) {
                 mdpL=mdpH.findByPrimaryKey(oids[i]);
				 if( !(monValidacion.validarAccesos(null,
												null,
												null,
												null, null, 
												mdpL.getSubacceso(),
												null, null, 
												null, null,null)).booleanValue()){
			
				throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_ASOCIACION_ESTRUCTURAL) );
			 }
			     mdpH.remove(mdpL);					
                    }
            } catch (NoResultException fe) {		
				this.loguearError("eliminarMediosPagoBelcenter: FinderException", fe);
                ctx.setRollbackOnly();
                codigoError = CodigosError.ERROR_ELIMINAR_NO_EXISTE;
                throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
            } catch(RemoteException rm){
				this.loguearError("eliminarMediosPagoBelcenter: RemoteException:validarAccesos",rm);
				throw new MareException(rm,
				UtilidadesError.armarCodigoError(
				CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));			 
			} catch (PersistenceException re) {
				this.loguearError("eliminarMediosPagoBelcenter: RemoveException" ,re);
                ctx.setRollbackOnly();
                codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
            } 
        }
		UtilidadesLog.info("MONMantenimientoMediosPagoBelcenterBean.eliminarMediosPagoBelcenter(DTOOIDs dto):Salida");
	}

	/** 
     * Método para consultar medios pago
     * @param dto DTOOID 
     * @return DTOMediosPagoBelcenter el resultado de la consulta
     * @exception MareException 
     */
	public DTOMediosPagoBelcenter consultarMediosPagoBelcenter(DTOOID dto) throws MareException {
		UtilidadesLog.info("MONMantenimientoMediosPagoBelcenterBean.consultarMediosPagoBelcenter(DTOOID dto):Entrada");
		DTOMediosPagoBelcenter resultado = new DTOMediosPagoBelcenter();
		String codigoError = null;
		//Documentation
		//Entrada: DTOOID (oid de un registro de Medio de Pago Belcenter) 
		//Proceso: 
		//-> Hacer un findByPrimaryKey sobre la entidad MediosDePagoBelcenter con 
		//el oid contenido en el dto de entrada
		//-> Crear objeto DTOMediosPagoBelcenter 
		//-> Tomar oidSubacceso del registro encontrado y asignarlo al atributo 
		//oidSubacceso del dto creado 
		//incidencia 5614
		//-> Obtener la descripción internacionalizada del subacceso y meter en el atributo descripcionSubacceso del dto creado
		//-> Hacer un findByPrimaryKey sobre la entidad Subacceso con el oid de subacceso
		//-> Tomar el dato oidAcceso y meter en el atributo oidAcceso del dto creado
		//-> Obtener la descripción internacionalizada del acceso y meter en el atributo descripcionAcceso del dto creado
		//-> Hacer un findByPrimaryKey sobre la entidad Acceso con el oid de acceso anterior
		//-> Tomar el dato oidCanal y meter en el atributo oidCanal del dto creado
		//-> Obtener la descripción internacionalizada del canal y meter en el atributo descripcionCanal del dto creado

		//-> Llamar al método "DAOMediosPagoBelcenter.consultarMediosPagoBelcenter
		//(subacceso : Long) : RecordSet" 
		//-> Tomar RecordSet obtenido de la llamada anterior y asignar todos los 
		//oid de medios de pago encontrados al array mediosPago del objeto 
		//DTOMediosPagoBelcenter creado 
		//-> Devolver DTOMediosPagoBelcenter construido
	    try {
				MediosDePagoBelcenterLocalHome mdpH = this.getMediosDePagoBelcenterLocalHome();
				MediosDePagoBelcenterLocal  mdpL = null;
				mdpL=mdpH.findByPrimaryKey(dto.getOid());
				Long subacceso = mdpL.getSubacceso();
				resultado.setOidSubacceso(subacceso);
				//incidencia 5614
				//-> Obtener la descripción internacionalizada del subacceso y meter en el atributo descripcionSubacceso del dto creado
				resultado.setDescripcionSubacceso(UtilidadesI18N.recuperarTraducciones("SEG_SUBAC", subacceso, dto.getOidIdioma(), new Long(1)));
				//-> Hacer un findByPrimaryKey sobre la entidad Subacceso con el oid de subacceso
				SubaccesoLocalHome subaccesoLH = this.getSubaccesoLocalHome();
				SubaccesoLocal subaccesoL = subaccesoLH.findByPrimaryKey(subacceso);
				//-> Tomar el dato oidAcceso y meter en el atributo oidAcceso del dto creado
				resultado.setOidAcceso(subaccesoL.getOidAcceso());
				
				//-> Obtener la descripción internacionalizada del acceso y meter en el atributo descripcionAcceso del dto creado
				resultado.setDescripcionAcceso(UtilidadesI18N.recuperarTraducciones("SEG_ACCES", resultado.getOidAcceso(), dto.getOidIdioma(), new Long(1)));

				//-> Hacer un findByPrimaryKey sobre la entidad Acceso con el oid de acceso anterior
				AccesoLocalHome accesoLH = this.getAccesoLocalHome();
				AccesoLocal accesoL = accesoLH.findByPrimaryKey(resultado.getOidAcceso());
				//-> Tomar el dato oidCanal y meter en el atributo oidCanal del dto creado
				resultado.setOidCanal(accesoL.getOidCanal());
				//-> Obtener la descripción internacionalizada del canal y meter en el atributo descripcionCanal del dto creado
				resultado.setDescripcionCanal(UtilidadesI18N.recuperarTraducciones("SEG_CANAL", resultado.getOidCanal(), dto.getOidIdioma(), new Long(1)));

				String usuario = ctx.getCallerPrincipal().getName();
				DAOMediosPagoBelcenter dao = new DAOMediosPagoBelcenter(usuario);
				RecordSet rsOids = dao.consultarMediosPagoBelcenter(subacceso);
				ArrayList lista = new ArrayList();
				if(!rsOids.esVacio()) {
					for(int i=0; i<rsOids.getRowCount(); i++) {
						Vector fila = rsOids.getRow(i);
						lista.add(new Long((fila.firstElement()).toString()));
					}
				}
				resultado.setMediosPago(lista);
            } catch (NoResultException fe) {		
				this.loguearError("consultarMediosPagoBelcenter: FinderException", fe);
                //ctx.setRollbackOnly();
                codigoError = CodigosError.ERROR_ELIMINAR_NO_EXISTE;
                throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } 
		UtilidadesLog.info("MONMantenimientoMediosPagoBelcenterBean.consultarMediosPagoBelcenter(DTOOID dto):Salida");
		return resultado;
	}

	/** 
     * Método para guardar medios pago
     * @param dto DTOMediosPagoBelcenter 
     * @return void
     * @exception MareException 
     */
	public void guardarMediosPagoBelcenter(DTOMediosPagoBelcenter dto) throws MareException {
     UtilidadesLog.info("MONMantenimientoMediosPagoBelcenterBean.guardarMediosPagoBelcenter(DTOMediosPagoBelcenter dto):Entrada");

		/* Llamamos a MONValidacion.validarAcceso pasandole los elementos del dto:
		 * pais, empresa, marca y subacceso, (el resto de parametros van a null. 
		 * Si nos devuelve false lanzamos una MareException con el código de error
		 * GEN_0008 
		 * En el método actualizarCuenta de MONCuentasCorrientes, debes cambiar el
		 * código GEN-0008 por GEN-0025 (incidencia BELC300002983)
		 */
         MONValidacion monValidacion = this.getMONValidacion();
		 try{
			 if( !(monValidacion.validarAccesos(dto.getOidPais(),
												null,
												null,
												null, null, 
												dto.getOidSubacceso(),
												null, null, 
												null, null,null)).booleanValue()){
			
				throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_ASOCIACION_ESTRUCTURAL) );
			 }
		 }catch(RemoteException re){
			this.loguearError("guardarMediosPagoBelcenter: RemoteException:validarAccesos",re);
			throw new MareException(re,
					UtilidadesError.armarCodigoError(
						CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));			 
		 }catch(MareException e) {
			throw e;
		 }
		//Documentation
		//Entrada: DTOMediosPagoBelcenter 
		//- oidSubacceso : Long 
		//- mediosPago : arrayList 
		//Proceso: 
		//-> Recorrer el array mediosPago del dto de entrada 
		//Para cada oid de medio de pago hacer 
		//-> Hacer create sobre la entidad MediosDePagoBelcenter usando el 
		//oidSubacceso del dto de entrada y el oid de medio de pago 
		//Fin Para
		String codigoError = null;
		try {
			MediosDePagoBelcenterLocalHome mdpH = this.getMediosDePagoBelcenterLocalHome();
			MediosDePagoBelcenterLocal  mdpL = null;
			Long oidSubacceso = dto.getOidSubacceso();
			ArrayList mediosPago = dto.getMediosPago();
			Iterator it = mediosPago.iterator();
			while(it.hasNext()) {
				Long oidMedioPago = new Long((it.next()).toString());
				mdpL=mdpH.create(oidMedioPago,oidSubacceso);
			}
		} catch (PersistenceException ce) {
			this.loguearError("guardarMediosPagoBelcenter: CreateException" ,ce);
	        ctx.setRollbackOnly();
	        codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
	        throw new MareException(ce, UtilidadesError.armarCodigoError(codigoError));
	    } 
		UtilidadesLog.info("MONMantenimientoMediosPagoBelcenterBean.guardarMediosPagoBelcenter(DTOMediosPagoBelcenter dto):Salida");
	}


	private void loguearSql(String metodo, String sql, Vector params){
		UtilidadesLog.debug(metodo + sql);
		if (params!=null && params.size()>0){
			String sParams="";
			for (int i=0; i<params.size();i++){
				sParams+="param "+ (i+1) + ": " + params.elementAt(i) + ", ";
			}
			UtilidadesLog.debug(metodo + sParams);
		}	
	}

	private void loguearError(String mensaje,Throwable e) {
		//mensaje: nombreMetodo: tipoExcepcion
		UtilidadesLog.error("****Error Metodo: "+mensaje+": "+ e.getMessage());
		UtilidadesLog.error(e);
	}

	private void logStackTrace(Throwable e) {
		try{
			UtilidadesLog.error("Se produjo la excepcion: " + e.getMessage());
			ByteArrayOutputStream pila = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(pila);
			/*e.printStackTrace(out);
			UtilidadesLog.error("stack Trace : " +  pila.toString());*/
      UtilidadesLog.error(e);
		}catch(Exception ex){
			UtilidadesLog.error("Eror Logeando Pila: "+ex.getMessage());
		}
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
			this.loguearError("*** Error en getMONValidacion",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.debug("****Metodo  getMONValidacion: Salida");		        
        return ejb;
	}   
	

	private void validaAcceso(Long pais, Long marca, Long canal, Long acceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio) throws  MareException {
      UtilidadesLog.info("MONMantenimientoMediosPagoBelcenterBean.validaAcceso(Long pais, Long marca, Long canal, Long acceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio):Entrada");
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
      UtilidadesLog.info("MONMantenimientoMediosPagoBelcenterBean.validaAcceso(Long pais, Long marca, Long canal, Long acceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio):Salida");
   }
   
    private MediosDePagoBelcenterLocalHome getMediosDePagoBelcenterLocalHome() {
        return new MediosDePagoBelcenterLocalHome();
    }

    private SubaccesoLocalHome getSubaccesoLocalHome() {
        return new SubaccesoLocalHome();
    }

    private AccesoLocalHome getAccesoLocalHome() {
        return new AccesoLocalHome();
    }


}
