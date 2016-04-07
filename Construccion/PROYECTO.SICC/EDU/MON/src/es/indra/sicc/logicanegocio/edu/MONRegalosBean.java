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

package es.indra.sicc.logicanegocio.edu;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;

import es.indra.sicc.dtos.edu.DTORegalo;
import es.indra.sicc.dtos.edu.DTOOIDRegalo;
import es.indra.sicc.dtos.edu.DTOObtieneRegalo;
import es.indra.sicc.dtos.edu.DTOConsultaRegalo;
import es.indra.sicc.dtos.edu.DTORegaloProducto;
import es.indra.sicc.dtos.edu.DTOEliminaRegalo;

import es.indra.sicc.entidades.edu.RegalosLocal;
import es.indra.sicc.entidades.edu.RegalosLocalHome;
import es.indra.sicc.entidades.edu.RegalosProductosLocal;
import es.indra.sicc.entidades.edu.RegalosProductosLocalHome;

import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.DTOSalida;

import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;

import es.indra.sicc.logicanegocio.edu.DAORegalos;

import java.util.Collection;
import java.util.Iterator;

import java.rmi.RemoteException;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONRegalosBean implements SessionBean  {

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
     * Realiza la inserción del regalo en la tabla EDU_REGAL y sus tablas relacionadas
     * @param dto
     * @exception MareException si no se pudo acceder a la base de datos 
     */   
	public void insertaRegalo(DTORegalo dto) throws MareException {
		UtilidadesLog.info(" MONRegalos.insertaRegalo(DTORegalo): Entrada");
		String codigoError = null;
		try{
			
			this.validaAcceso(dto.getOidPais(),null,null,null,null,null,null,null,null,null,null);

			//-Insertamos en Regalos
			RegalosLocalHome regalosLocalHome = new RegalosLocalHome();
                        RegalosLocal  regalosLocal = null;
                        regalosLocal=regalosLocalHome.create(dto.getCodRegalo(),dto.getOidPais());
			//-Por cada elemento en el array dto.productos() 
			//Se crea un nuevo objeto RegalosProductos (EJB Entity) con la siguiente información: 
			if (dto.getProductos()!=null && dto.getProductos().length>0) {
				RegalosProductosLocalHome regProdLocalHome = new RegalosProductosLocalHome();
                                RegalosProductosLocal  regProdLocal = null;  
				
				for (int i = 0; i < dto.getProductos().length; i++){
					regProdLocal = regProdLocalHome.create(regalosLocal.getOid(),dto.getProductos()[i].getOidProducto());
				}
			}

			//- Para cada DTO del vector dto.attriTraducible se debe hacer una llamada al método "create" 
			//del Entity Bean: "Entidadi18n". El oid es del registro de Regalos afectado (paso primero).
			Entidadi18nLocalHome eiLH = new Entidadi18nLocalHome();
                        Entidadi18nLocal  eiL = null;
                        DTOI18nSICC dtoTrad[]=dto.getAttriTraducible();
                        for (int i = 0; i <dtoTrad.length ; i++){
                            eiL =  eiLH.create("EDU_REGAL", dtoTrad[i].getOidAtriuto(), dtoTrad[i].getOidIdioma(), dtoTrad[i].getValorI18n(), regalosLocal.getOid());
                        }
		}catch(PersistenceException ce){
                        UtilidadesLog.error("insertaRegalo: PersistenceException" ,ce);
                        ctx.setRollbackOnly();
                        codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                        throw new MareException(ce, UtilidadesError.armarCodigoError(codigoError));
                }

		UtilidadesLog.info(" MONRegalos.insertaRegalo(DTORegalo): Salida");
	}
 
	/** 
     * Obtiene la información del regalo pasado por parámetro.
     * @param dto DTOOIDRegalo 
     * @return DTOObtieneRegalo 
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos que cumplieran los criterios de busqueda
     */
	public DTOObtieneRegalo obtieneRegalo(DTOOIDRegalo dto) throws MareException {

		UtilidadesLog.info(" MONRegalos.obtieneRegalo(DTOOIDRegalo): Entrada");
		String codigoError = null;
		RegalosLocal regalosLocal = null;
		Entidadi18nLocal i18nLocal=null;
		try{
			RegalosLocalHome regalosLocalHome = new RegalosLocalHome();
			//Obtiene el objeto de Regalos (EJB Entity) cuyo oid es dtoe.oidRegalo 
			regalosLocal=regalosLocalHome.findByPrimaryKey(dto.getOidRegalo());
			Entidadi18nLocalHome i18n = new Entidadi18nLocalHome();
			i18nLocal=i18n.findByEntAtrIdioPK("EDU_REGAL",new Long(1),dto.getOidIdioma(),dto.getOidRegalo());
			
		} catch (NoResultException fe) {		
			UtilidadesLog.error("obtieneRegalo: NoResultException",fe);
                        codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                        throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
                } 

		DTOObtieneRegalo dtoObtieneRegalo=new DTOObtieneRegalo();
		
		//Retorna DTOObtieneRegalo con la siguiente información: 
		//DTOObtieneRegalo.codRegalo = Regalos.codigo 
		dtoObtieneRegalo.setCodRegalo(regalosLocal.getCodigo());
		dtoObtieneRegalo.setDescRegalo(i18nLocal.getDetalle());
                UtilidadesLog.info(" MONRegalos.obtieneRegalo(DTOOIDRegalo): Salida");
		return dtoObtieneRegalo;
	}

	/** 
     * Obtiene los regalos que cumplen los criterios  de busqueda 
     * @param dto DTOConsultaRegalo con los criterios de busqueda
     * @return DTOSalida con los registros encontrados
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontraron datos que cumplieran los criterios de busqueda
     */
	public DTOSalida cargaRegalo(DTOConsultaRegalo dto) throws MareException {
		UtilidadesLog.info(" MONRegalos.cargaRegalo(DTOConsultaRegalo): Entrada");
		DAORegalos daoRegalos=new DAORegalos(ctx.getCallerPrincipal().getName());
		DTOSalida dtoSalida=new DTOSalida();
		dtoSalida=daoRegalos.obtieneRegalos(dto);
		RecordSet rs = new RecordSet();
		rs = dtoSalida.getResultado();
		if(rs == null){
			rs = new RecordSet();
		}
		if(rs.esVacio()){
			 throw new MareException(new Exception(),
             UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		}
		UtilidadesLog.info(" MONRegalos.cargaRegalo(DTOConsultaRegalo): Salida");
		return dtoSalida;
		
	}

	/** 
     * Obtiene los productos de un regalo. El idioma se agregó por incidencia número 6949
     * @param dto 
     * @return DTOSalida 
     * @exception MareException si no se pudo acceder a la base de datos o no se 
     * encontró el registro
     */   
	public DTOSalida obtieneProductosRegalo(DTOOIDRegalo dto) throws MareException {
		UtilidadesLog.info(" MONRegalos.obtieneProductosRegalo(DTOOIDRegalo): Entrada");
		
		DAORegalos daoRegalos=new DAORegalos(ctx.getCallerPrincipal().getName());
		RecordSet recordset=daoRegalos.obtieneProductos(dto.getOidRegalo(),dto.getOidIdioma());
    UtilidadesLog.info(" MONRegalos.obtieneProductosRegalo(DTOOIDRegalo): Salida");
		return new DTOSalida(recordset);
	}

	/** 
     * Realiza la modificación de un regalo en la tabla EDU_REGAL y sus tablas relacionadas
     * @param dto
     * @exception MareException si no se pudo acceder a la base de datos 
     */  
	public void modificaRegalo(DTORegalo dto) throws MareException {
		UtilidadesLog.info(" MONRegalos.modificaRegalo(DTORegalo): Entrada");
		RegalosLocal regalosLocal = null;
		String codigoError=null;
		try{

			//Se realiza el validaAcceso
			this.validaAcceso(dto.getOidPais(),null,null,null,null,null,null,null,null,null,null);		

			RegalosLocalHome regalosLocalHome = new RegalosLocalHome();
			//Obtiene el objeto de Regalos (EJB Entity) cuyo oid es dtoe.oidRegalo 
			regalosLocal=regalosLocalHome.findByPrimaryKey(dto.getOid());

			//Eliminamos las descripcion internacionalizable
			this.eliminaTraduccionesRegalo(dto.getOid());

			// Obtenemos la interfaz local home de los entity que utilizamos
                        Entidadi18nLocalHome entidadi18nLocalHome = new Entidadi18nLocalHome();
                        Entidadi18nLocal entidadi18nLocal = null;
			//actualizamos la descripcion internacionalizable
			//- Para cada DTO del vector dto.attriTraducible se debe hacer una llamada al método "create" 
			//del Entity Bean: "Entidadi18n". El oid es del registro de Regalos afectado.
			DTOI18nSICC[] dtoAttrTraducible = dto.getAttriTraducible();
                        for (int i = 0; i <dtoAttrTraducible.length ; i++) {
                            
                            entidadi18nLocal = entidadi18nLocalHome.create(
                                                        "EDU_REGAL",
                                                        dtoAttrTraducible[i].getOidAtriuto(),
                                                        dtoAttrTraducible[i].getOidIdioma(),
                                                        dtoAttrTraducible[i].getValorI18n(), 
                                                        dto.getOid()
                                                        );   
                        }       

			//Se llama al método eliminaRegaloProducto(dtoe.oid) 
			this.eliminaRegaloProducto(dto.getOid());


			//Por cada elemento en el array dtoe.productos() 
			//Se crea un nuevo objeto RegalosProductos (EJB Entity) con la siguiente información: 
			//RegalosProductos.regalo = dtoe.oid 
			//RegalosProductos.Producto = dtoe.productos(i).oidProducto 
			//RegalosProductos.oid = se genera automáticamente 

			DTORegaloProducto dtos[]=dto.getProductos();
			RegalosProductosLocalHome regProdLocalHome = new RegalosProductosLocalHome();
                        RegalosProductosLocal regProdLocal = null;  
			for (int i=0; i<dtos.length; i++){
				regProdLocal = regProdLocalHome.create(dto.getOid(),dtos[i].getOidProducto());
			}
			
		}catch(NoResultException fe){
			UtilidadesLog.error("modificaRegalo: FinderException",fe);
                        codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                        throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
		}catch(PersistenceException ce){
			UtilidadesLog.error("modificaRegalo: CreateException" ,ce);
			ctx.setRollbackOnly();
			codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			throw new MareException(ce, UtilidadesError.armarCodigoError(codigoError));
		}
                UtilidadesLog.info(" MONRegalos.modificaRegalo(DTORegalo): Salida");
	}

	/** 
     * Realiza la eliminación de un regalo en la tabla EDU_REGAL y sus tablas relacionadas
     * @param dto
     * @exception MareException si no se pudo acceder a la base de datos 
     */  
	public void eliminaRegalo(DTOEliminaRegalo dto) throws MareException {
		UtilidadesLog.info(" MONRegalos.eliminaRegalo(DTOEliminaRegalo): Entrada");
		String codigoError=null;
		DTOOIDRegalo dtos[]=dto.getRegalos();
		RegalosLocal regalosLocal=null;

		if(dtos != null && dtos.length>0){
			//Por cada elemento en el array dtoe.regalos() 
			//Se llama al método eliminaRegaloProducto(dtoe.regalos(i).oidRegalo) 
			try{
				for (int i=0;i<dtos.length;i++){

					//DEBEMOS HACER UN FINDBYPRIMARIKEY 
					//valida accesos por cada regalo
					RegalosLocalHome regalosLocalHome = new RegalosLocalHome();
					//Obtiene el objeto de Regalos (EJB Entity) cuyo oid es dtoe.oidRegalo 
					regalosLocal=regalosLocalHome.findByPrimaryKey(dtos[i].getOidRegalo());
					this.validaAcceso(regalosLocal.getPais(),null,null,null,null,null,null,null,null,null,null);

					//Elimina los registros de la tabla EDU_REGAL_DETAL		
					this.eliminaRegaloProducto(dtos[i].getOidRegalo());

					//Se elimina el objeto Regalos (EJB Entity) cuyo oid es dtoe.regalos(i).oidRegalo
					//teniendo en cuenta que la descripción es internacionalizable 
					regalosLocalHome.remove(regalosLocal);

					//Elimina la descripcion del regalo en sus diferentes idiomas
					this.eliminaTraduccionesRegalo(dtos[i].getOidRegalo());
				}
			}catch (NoResultException fe){
				UtilidadesLog.error("eliminaRegalo: FinderException",fe);
				ctx.setRollbackOnly();
				codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
				throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
			}catch (PersistenceException exception){
				ctx.setRollbackOnly();
				UtilidadesLog.error("eliminaRegalo: RemoveException",exception);	
				throw new MareException(exception,
					UtilidadesError.armarCodigoError(
						CodigosError.ERROR_DE_BORRADO_DE_DATOS));
			}
			
		}
		UtilidadesLog.info(" MONRegalos.eliminaRegalo(DTOEliminaRegalo): Salida");
	}

	
	private void eliminaTraduccionesRegalo (Long oid) throws MareException {
     UtilidadesLog.info(" MONRegalos.eliminaTraduccionesRegalo(oid): Entrada");
        try {
				Collection myCollectionI18n=null;
				//Eliminamos el registro con el oid 	
				//Obtenemos la interfaz local home de los entity que utilizamos
				Entidadi18nLocalHome  entidadi18nLocalHome = new Entidadi18nLocalHome();
				Entidadi18nLocal entidadi18nLocal = null;
				//Buscamos el seleccionado			
				myCollectionI18n = entidadi18nLocalHome.findByEntPK("EDU_REGAL",oid);				
				Iterator myIteratorE18=myCollectionI18n.iterator();
				while(myIteratorE18.hasNext()){
					entidadi18nLocal=(Entidadi18nLocal)myIteratorE18.next();					
					entidadi18nLocalHome.remove(entidadi18nLocal);								
				}                  
		} catch (NoResultException fe) {
				UtilidadesLog.error("eliminaTraduccionesRegalo: FinderException",fe);			
                //no se encontro gen-006
                ctx.setRollbackOnly();
                throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));		
		} catch (PersistenceException exception){
            ctx.setRollbackOnly();
			UtilidadesLog.error("eliminaTraduccionesRegalo: RemoveException",exception);	
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }catch (Exception exception){
            ctx.setRollbackOnly();
			UtilidadesLog.error("eliminaTraduccionesRegalo: Exception",exception);	
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
		UtilidadesLog.info(" MONRegalos.eliminaTraduccionesRegalo(oid): Salida");
    }

	/** 
     * Realiza la eliminación de los registros de la tabla EDU_REGAL_DETAL
	 * cuyo código de regalo sea igual al pasado como parámetro
     * @param oidRegalo
     * @exception MareException si no se pudo acceder a la base de datos 
	 * o no se pudo borrar el registro
     */	
	private void eliminaRegaloProducto(Long oidRegalo) throws MareException {
		UtilidadesLog.info(" MONRegalos.eliminaRegaloProducto(oidRegalo): Entrada");
		DAORegalos daoRegalos=null;
		RegalosProductosLocal regalosProductosLocal = null;
		try{
			daoRegalos=new DAORegalos(ctx.getCallerPrincipal().getName());
			//daoRegalos=new DAORegalos("USUARIO1");
			RecordSet rs = daoRegalos.obtieneRegaloProducto(oidRegalo);
			if (rs!=null && !rs.esVacio() && rs.getRowCount()>0){
				RegalosProductosLocalHome regalosProductosLocalHome = new RegalosProductosLocalHome();
				for(int i=0;i<rs.getRowCount();i++){
					//Obtiene el objeto de Regalos (EJB Entity) cuyo oid es dtoe.oidRegalo 
					regalosProductosLocal=regalosProductosLocalHome.findByPrimaryKey(new Long(rs.getValueAt(i,0).toString()));
					regalosProductosLocalHome.remove(regalosProductosLocal);
				}
			}
		}catch(NoResultException fe){
			String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("eliminaRegaloProducto: FinderException",fe);
			throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
		}catch (PersistenceException exception){
                        ctx.setRollbackOnly();
			UtilidadesLog.error("eliminaRegaloProducto: RemoveException",exception);	
                        throw new MareException(exception,
                            UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_DE_BORRADO_DE_DATOS));
		}
		UtilidadesLog.info(" MONRegalos.eliminaRegaloProducto(oidRegalo): Salida");
	}


    private MONValidacionHome getMONValidacionHome() throws NamingException {
		final InitialContext context = new InitialContext();
		return (MONValidacionHome)context.lookup("java:comp/env/MONValidacion");
	}

	private MONValidacion getMONValidacion() throws MareException {
        // Se obtiene el interfaz home
		UtilidadesLog.info(" MONRegalos.getMONValidacion(): Entrada");
        MONValidacionHome home = (MONValidacionHome)UtilidadesEJB.getHome(
            "MONValidacion", MONValidacionHome.class);
            
        // Se obtiene el interfaz remoto
        MONValidacion ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error("*** Error en getMONValidacion",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.info(" MONRegalos.getMONValidacion(): Salida");
        return ejb;
	}

	
/*
	private Log getLog() {
		Log log = null;
		try {
			return (((LoggingService)MareMii.getService(new MareTopic("LoggingService"))).getMareLog());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println ("No se pudo obtener el objeto Log");
			throw new RuntimeException ("No se pudo obtener el objeto Log");
		}
	}  
*/

	private void validaAcceso(Long pais, Long sociedad, Long marca, Long canal, Long acceso, 
        Long subacceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio)
        throws MareException {
        UtilidadesLog.info("  MONRegalos.validaAccesoVinculos(pais, marca, canal, sociedad, acceso, subacceso, subgerencia, region, zona, seccion, territorio): Entrada");

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
                "**** validaAccesoVinculos: validaAcceso : ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.debug("****Retorno validaAcceso : " + b.toString());

        if (!b.booleanValue()) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(
                "**** validaAccesoVinculos: validaAcceso : ERROR_ASOCIACION_ESTRUCTURAL");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_ASOCIACION_ESTRUCTURAL));
        }

        UtilidadesLog.info("  MONRegalos.validaAccesoVinculos(pais, marca, canal, sociedad, acceso, subacceso, subgerencia, region, zona, seccion, territorio): Salida");
    }

}