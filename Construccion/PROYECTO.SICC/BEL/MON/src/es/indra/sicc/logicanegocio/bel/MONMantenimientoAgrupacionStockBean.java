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
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.dtos.bel.DTOAgrupacionStock;
import es.indra.sicc.dtos.bel.DTOAgrupacionStockCabecera;
import es.indra.sicc.dtos.bel.DTOAgrupacionStockDetalle;
import es.indra.sicc.dtos.bel.DTOEBuscarAgrupacionStock;
import es.indra.sicc.entidades.bel.AgrupacionStockCabeceraLocal;
import es.indra.sicc.entidades.bel.AgrupacionStockCabeceraLocalHome;
import es.indra.sicc.entidades.bel.AgrupacionStockDetalleLocal;
import es.indra.sicc.entidades.bel.AgrupacionStockDetalleLocalHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;//util.ConstantesSEG;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.ejb.CreateException;
import javax.ejb.DuplicateKeyException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONMantenimientoAgrupacionStockBean implements SessionBean  {

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
		this.ctx=ctx;
	}
	
	/** 
     * Método para buscar agrupaciónes de stock
     * @param dto DTOEBuscarAgrupacionStock con los criterios de busqueda de codigo y descripcion
     * @return DTOSalida con los registros encontrados en la busqueda
     * @exception MareException 
     */
	public DTOSalida buscarAgrupacionStock(DTOEBuscarAgrupacionStock dto) throws MareException{
		UtilidadesLog.info("MONMantenimientoAgrupacionStockBean.buscarAgrupacionStock(DTOEBuscarAgrupacionStock dto):Entrada");

		String usuario = ctx.getCallerPrincipal().getName();
		DAOAgrupacionStock daoAgrupacionStock = new DAOAgrupacionStock(usuario);

		RecordSet rs = daoAgrupacionStock.buscarAgrupacionStock(dto);
		if (rs == null){
			rs = new RecordSet();
		}		
        // Si la consulta no devuelve ningun dato
        if (rs.esVacio()) {
            //GEN-0007 --> 005
			UtilidadesLog.debug("****buscarAgrupacionStock: no hay datos ");				
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

		UtilidadesLog.info("MONMantenimientoAgrupacionStockBean.buscarAgrupacionStock(DTOEBuscarAgrupacionStock dto):Salida");
		return new DTOSalida(rs);
	}
	
	/** 
     * Método para consultar una agrupacion de Stock
     * @param dto DTOOID con el oid de la Agrupacion de Stock
     * @return DTOAgrupacionStock con los datos de la Agrupacion de Stock (cabecera y detalles)
     * @exception MareException 
     */
	public DTOAgrupacionStock consultarAgrupacionStock(DTOOID dto) throws MareException {
		UtilidadesLog.info("MONMantenimientoAgrupacionStockBean.consultarAgrupacionStock(DTOOID dto):Entrada");

		DTOAgrupacionStock dtoAgrupacionSalida = new DTOAgrupacionStock();

		// Llamar al método "DAOAgrupacionStock.consultarAgrupacionStockCabecera(dto : DTOOID) 
		// : RecordSet" 

		String usuario = ctx.getCallerPrincipal().getName();
		DAOAgrupacionStock daoAgrupacionStock = new DAOAgrupacionStock(usuario);	
		RecordSet rs = daoAgrupacionStock.consultarAgrupacionStockCabecera(dto);

		/* Crear un objeto DTOAgrupacionStockCabecera, donde mapeamos el registro contenido en el RecordSet obtenido en la actividad anterior a los siguientes atributos: 
		- oidAgrupacionStockCabecera 
		- pais (lo tiene heredado de DTOBelcorp) 
		- codigoASC 
		- descripcion (internacionalizada) 
		- indicadorDefecto 
		*/
		DTOAgrupacionStockCabecera dtoAgrupacionCabecera = new DTOAgrupacionStockCabecera();
		if (rs != null && !rs.esVacio()) {
			if (rs.getValueAt(0,0) != null) {
				dtoAgrupacionCabecera.setOidAgrupacionStockCabecera(new Long(rs.getValueAt(0,0).toString()));
			}
			if (rs.getValueAt(0,1) != null) {
				dtoAgrupacionCabecera.setOidPais(new Long(rs.getValueAt(0,1).toString()));
			}
			if (rs.getValueAt(0,2) != null) {
				dtoAgrupacionCabecera.setCodigoASC(rs.getValueAt(0,2).toString());
			}
			if (rs.getValueAt(0,3) != null) {
				dtoAgrupacionCabecera.setDescripcion(rs.getValueAt(0,3).toString());
			}
			if (rs.getValueAt(0,4)!=null) {
				if (rs.getValueAt(0,4).toString().equals("0")) {
					dtoAgrupacionCabecera.setIndicadorDefecto(Boolean.FALSE);
				} else {
					dtoAgrupacionCabecera.setIndicadorDefecto(Boolean.TRUE);
				}
			}			
		}

		// Asignar dto creado al atributo "cabecera" del objeto "DTOAgrupacionStock" creado al inicio
		dtoAgrupacionSalida.setCabecera(dtoAgrupacionCabecera);

		// Llamar al método "DAOAgrupacionStock.consultarDetalleAgrupacionStock(dto : DTOOID) : 
		// RecordSet" 
		rs = daoAgrupacionStock.consultarDetalleAgrupacionStock(dto);

		/* -> Recorrer RecordSet obtenido en actividad anterior 
		Para cada registro contenido en el RecordSet hacer: 
		-> Construir un objeto DTOAgrupacionStockDetalle, mapeando los datos del registro en los 
		siguientes atributos: 
			- oidAgrupacionStockDetalle 
			- oidEstadoMercancia 
			- descripcionEstadoMercancia (internacionalizada) 
			- operacion 
		-> Introducir el objeto DTOAgrupacionStockDetalle creado en el atributo de tipo arrayList 
		del dto construido al inicio, "DTOAgrupacionStock.detalle" 
		*/
		ArrayList arrayDetalles=new ArrayList();
		if (rs != null && !rs.esVacio()) {
			for (int i=0; i<rs.getRowCount(); i++) {
				DTOAgrupacionStockDetalle agrupacionDetalle = new DTOAgrupacionStockDetalle();
				if (rs.getValueAt(i,0) != null) {
					agrupacionDetalle.setOidAgrupacionStockDetalle(new Long(rs.getValueAt(i,0).toString()));
				}				
				if (rs.getValueAt(i,1) != null) {
					agrupacionDetalle.setOidEstadoMercancia(new Long(rs.getValueAt(i,1).toString()));
				}				
				if (rs.getValueAt(i,2) != null) {
					agrupacionDetalle.setDescripcionEstadoMercancia(rs.getValueAt(i,2).toString());
				}				
				if (rs.getValueAt(i,3) != null) {
					agrupacionDetalle.setOperacion(new Character(rs.getValueAt(i,3).toString().charAt(0)));
				}												
				arrayDetalles.add(agrupacionDetalle);
			}
		}
		dtoAgrupacionSalida.setDetalle(arrayDetalles);
		
		UtilidadesLog.info("MONMantenimientoAgrupacionStockBean.consultarAgrupacionStock(DTOOID dto):Salida");
		return dtoAgrupacionSalida;
	}
	
	/** 
     * Método para insertar/modificar una agrupacion de Stock
     * @param dto DTOAgrupacionStock con los datos de la Agrupacion de Stock (cabecera y detalles).
     * @exception MareException 
     */
	public void guardarAgrupacionStock(DTOAgrupacionStock dto) throws MareException {
		UtilidadesLog.info("MONMantenimientoAgrupacionStockBean.guardarAgrupacionStock(DTOAgrupacionStock dto):Entrada");
		this.validaAcceso(dto.getOidPais(),null,null,null,null,null,null,null,null);
		// Se obtiene la cabecera y los detalles del DTO
		DTOAgrupacionStockCabecera cabecera = dto.getCabecera();
		ArrayList detalles = dto.getDetalle();

		Long oidAgrupacionStockCabecera = cabecera.getOidAgrupacionStockCabecera();
		if (oidAgrupacionStockCabecera == null) {
			Boolean indicadorDefecto = cabecera.getIndicadorDefecto();
			//-> Comprobar el valor del atributo "DTOAgrupacionStock.cabecera.indicadorDefecto" 
			if (indicadorDefecto != null && indicadorDefecto.booleanValue()) {
				//-> Llamar al método privado de esta clase "existeAgrupacionStockPorDefecto(pais : Long) : Boolean" pasándole como parámetro el pais contenido en el dto de entrada 
				Boolean existe = this.existeAgrupacionStockPorDefecto(dto.getOidPais());
				if (existe.booleanValue() == true) {
					//-> Lanzar una MareException con el código de error "BEL-0002" 
					throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_BEL, "", ErroresDeNegocio.AGRUPACION_POR_DEFECTO_YA_EXISTE));
				}
			}
			//-> Hacer create sobre la entidad AgrupacionStockCabecera con los atributos del DTOAgrupacionStockCabecera contenido en el dto de entrada menos el atributo attTraducible. 
			//-> Con el atributo attTraducible hacer un create sobre la entidad Entidadi18n 
			AgrupacionStockCabeceraLocalHome agStockCabHome = this.getAgrupacionStockCabeceraLocalHome();
			try {
				Long pais = dto.getOidPais();
				String codigoASC = cabecera.getCodigoASC();
				Boolean indicador = cabecera.getIndicadorDefecto();
				AgrupacionStockCabeceraLocal agStockCabLocal = agStockCabHome.create(pais, codigoASC, indicadorDefecto);
				oidAgrupacionStockCabecera = agStockCabLocal.getOid();
			} catch (PersistenceException e) {
				UtilidadesLog.error(e);
				ctx.setRollbackOnly();
				throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
                        }
			//-> Con el atributo attTraducible hacer un create sobre la entidad Entidadi18n 
			Entidadi18nLocalHome eiLH = this.getI18NEntityLocalHome();
			Object trad[] = cabecera.getAttTraducible().toArray();
			for (int i = 0; i < trad.length; i++) {
				DTOI18nSICC dtoTrad = (DTOI18nSICC) trad[i];
				try {
					eiLH.create("BEL_AGRUP_STOCK_CABEC", dtoTrad.getOidAtriuto(), dtoTrad.getOidIdioma(), dtoTrad.getValorI18n(), oidAgrupacionStockCabecera);
				} catch (PersistenceException e) {
					UtilidadesLog.error(e);
					ctx.setRollbackOnly();
					throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
				}
			}
		} else {
			// Hacer findByPrimaryKey sobre la entidad AgrupacionStockCabecera 
			AgrupacionStockCabeceraLocalHome agStockCabHome = this.getAgrupacionStockCabeceraLocalHome();
			AgrupacionStockCabeceraLocal agStockCabLocal = null;
			try {
				agStockCabLocal = agStockCabHome.findByPrimaryKey(oidAgrupacionStockCabecera);
			} catch (NoResultException e) {
				UtilidadesLog.error(e);
				ctx.setRollbackOnly();
				throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                        }  catch (PersistenceException ce) {   
                            UtilidadesLog.error("ERROR ", ce);
                            throw new MareException(ce, 
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
			}
			//Incidencia 6183
			Boolean indicadorDefecto = cabecera.getIndicadorDefecto();
			//-> Comprobar el valor del atributo "DTOAgrupacionStock.cabecera.indicadorDefecto"
			// Si es true y el registro en Base de Datos tenía false, comprobar si existe ya otro registro con identificador por defecto a true
			if (indicadorDefecto != null && indicadorDefecto.booleanValue() && agStockCabLocal.getIndicadorDefecto() != null && !agStockCabLocal.getIndicadorDefecto().booleanValue()) {
				//-> Llamar al método privado de esta clase "existeAgrupacionStockPorDefecto(pais : Long) : Boolean" pasándole como parámetro el pais contenido en el dto de entrada 
				Boolean existe = this.existeAgrupacionStockPorDefecto(dto.getOidPais());
				if (existe.booleanValue() == true) {
					//-> Lanzar una MareException con el código de error "BEL-0002" 
					throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_BEL, "", ErroresDeNegocio.AGRUPACION_POR_DEFECTO_YA_EXISTE));
				}
			}

			//Setear sobre el registro encontrado los atributos del DTOAgrupacionStockCabecera contenido en el dto de entrada menos el atributo attTraducible 
			agStockCabLocal.setCodigoASC(cabecera.getCodigoASC());
			agStockCabLocal.setIndicadorDefecto(cabecera.getIndicadorDefecto());
			agStockCabLocal.setPais(dto.getOidPais());

			//Con el atributo attTraducible hacer findByPrimaryKey sobre la entidad Entidadi18n y setear el atributo 
			this.eliminaTraducciones(oidAgrupacionStockCabecera);
			Entidadi18nLocalHome eiLH = this.getI18NEntityLocalHome();
			Object trad[] = cabecera.getAttTraducible().toArray();
			for (int i = 0; i < trad.length ; i++){
				DTOI18nSICC dtoTrad = (DTOI18nSICC) trad[i];
				try {
					eiLH.create("BEL_AGRUP_STOCK_CABEC", dtoTrad.getOidAtriuto(), dtoTrad.getOidIdioma(), dtoTrad.getValorI18n(), oidAgrupacionStockCabecera);
				} catch (PersistenceException e) {
					UtilidadesLog.error(e);
					ctx.setRollbackOnly();
					throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
				}

			}
			//Tomar el atributo oidAgrupacionStockCabecera del atributo cabecera del dto de entrada y crear objeto DTOOID
			DTOOID dtoOid = new DTOOID();
			dtoOid.setOid(oidAgrupacionStockCabecera);
			dtoOid.setOidPais(dto.getOidPais());
			dtoOid.setOidIdioma(dto.getOidIdioma());
			//Llamar al método de esta clase "eliminarDetalleAgrupacionStock(dto : DTOOID) : void" pasando el DTOOID creado
			this.eliminarDetalleAgrupacionStock(dtoOid);
		}

		//-> Tomar el arrayList del dto de entrada y recorrerlo
		if (detalles != null && detalles.size() > 0) {
			AgrupacionStockDetalleLocalHome asdLH = this.getAgrupacionStockDetalleLocalHome();
			//Para cada objeto DTOAgrupacionStockDetalle hacer: 
			//-> Hacer create sobre la entidad AgrupacionStockDetalle con los datos del dto 
			for (int i = 0; i < detalles.size(); i++) {
				DTOAgrupacionStockDetalle detalle = (DTOAgrupacionStockDetalle)detalles.get(i);
				try {
					asdLH.create(oidAgrupacionStockCabecera, detalle.getOidEstadoMercancia(), detalle.getOperacion());
				}  catch (PersistenceException e) {
					UtilidadesLog.error(e);
					ctx.setRollbackOnly();
					throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
				}

			}
		}
		UtilidadesLog.info("MONMantenimientoAgrupacionStockBean.guardarAgrupacionStock(DTOAgrupacionStock dto):Salida");
	}

    private void eliminaTraducciones(Long oid) throws MareException {
        UtilidadesLog.info("MONMantenimientoAgrupacionStockBean.eliminaTraducciones(Long oid):Entrada");
        try {
            Collection myCollectionI18n = null;
            //Eliminamos el registro con el oid 	
            //Obtenemos la interfaz local home de los entity que utilizamos
            Entidadi18nLocalHome  entidadi18nLocalHome = this.getI18NEntityLocalHome();
            //Buscamos el seleccionado	
            myCollectionI18n = entidadi18nLocalHome.findByEntPK("BEL_AGRUP_STOCK_CABEC", oid);				
            Iterator myIteratorE18 = myCollectionI18n.iterator();
            while (myIteratorE18.hasNext()) {
                    Entidadi18nLocal entidadi18nLocal = (Entidadi18nLocal)myIteratorE18.next();					
                    entidadi18nLocalHome.remove(entidadi18nLocal);
            }                  
        } catch (NoResultException fe) {
            this.logearError("eliminaTraducciones: FinderException",fe);			
            //no se encontro gen-006
            UtilidadesLog.error(fe);
            ctx.setRollbackOnly();
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));		
        } catch (PersistenceException exception) {
            ctx.setRollbackOnly();
            this.logearError("eliminaTraducciones: RemoveException",exception);	
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        } catch (Exception exception) {
            ctx.setRollbackOnly();
            this.logearError("eliminaTraducciones: Exception",exception);	
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONMantenimientoAgrupacionStockBean.eliminaTraducciones(Long oid):Salida");
    }

	
	/** 
     * Método para eliminar Agrupaciones de Stock
     * @param dto DTOOIDs con los oids de las Agrupaciones de Stock que se desean eliminar.
     * @exception MareException 
     */
	public void eliminarAgrupacionStock(DTOOIDs dto) throws MareException {
		UtilidadesLog.info("MONMantenimientoAgrupacionStockBean.eliminaTraducciones(Long oid):Entrada");
		DTOOID dtoOid=new DTOOID();
		dtoOid.setOidIdioma(dto.getOidIdioma());
		dtoOid.setOidPais(dto.getOidPais());
		Long oids[]=dto.getOids();
		for (int i = 0; i < oids.length; i++) {
			AgrupacionStockCabeceraLocalHome agStockCabHome = this.getAgrupacionStockCabeceraLocalHome();
			try {
				AgrupacionStockCabeceraLocal agStockCabLocal = agStockCabHome.findByPrimaryKey(oids[i]);
				this.validaAcceso(agStockCabLocal.getPais(),null,null,null,null,null,null,null,null);
			} catch (NoResultException e) {
				UtilidadesLog.error(e);
				ctx.setRollbackOnly();
				throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                        }  catch (PersistenceException ce) {   
                            UtilidadesLog.error("ERROR ", ce);
                            throw new MareException(ce, 
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));

			}
			dtoOid.setOid(oids[i]);
			this.eliminarDetalleAgrupacionStock(dtoOid);
			//-> Hacer findByPrimaryKey sobre la entidad AgrupacionStockCabecera con el oid de cabecera de turno 
			//-> Hacer remove sobre el registros encontrado de AgrupacionStockCabecera 
			try {
				AgrupacionStockCabeceraLocal agStockCabLocal = agStockCabHome.findByPrimaryKey(oids[i]);
				agStockCabHome.remove(agStockCabLocal);
			} catch (NoResultException e) {
				UtilidadesLog.error(e);
				ctx.setRollbackOnly();
				throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
			} catch (PersistenceException e) {
				UtilidadesLog.error(e);
				ctx.setRollbackOnly();
				throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
			}
			this.eliminaTraducciones(oids[i]);
		}
		UtilidadesLog.info("MONMantenimientoAgrupacionStockBean.eliminaTraducciones(Long oid):Salida");
	}

	/** 
     * Método para eliminar los detalles de una Agrupacion de Stock
     * @param dto DTOOID con el oid de las Agrupaciones de Stock cuyos detalles se van a eliminar.
     * @exception MareException 
     */
	public void eliminarDetalleAgrupacionStock(DTOOID dto) throws MareException{
		UtilidadesLog.info("MONMantenimientoAgrupacionStockBean.eliminarDetalleAgrupacionStock(DTOOID dto):Entrada");
		
		DAOAgrupacionStock daoAgrupacionStock = new DAOAgrupacionStock(ctx.getCallerPrincipal().getName());
		RecordSet rs = daoAgrupacionStock.consultarOidsDetalleAgrupacionStock(dto);
		if (rs != null && !rs.esVacio()) {
			for (int i = 0; i < rs.getRowCount(); i++) {
				if (rs.getValueAt(i,0) != null) {
					Long oid = new Long(rs.getValueAt(i,0).toString());
					AgrupacionStockDetalleLocalHome asdLH = this.getAgrupacionStockDetalleLocalHome();
					try {
						//-> Hacer findByPrimaryKey sobre la entidad AgrupacionStockDetalle 
						AgrupacionStockDetalleLocal asdL = asdLH.findByPrimaryKey(oid);
						//-> Hacer remove sobre el registro encontrado de AgrupacionStockDetalle 
						asdLH.remove(asdL);
					} catch (NoResultException e) {
						UtilidadesLog.error(e);
						ctx.setRollbackOnly();
						throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
					} catch (PersistenceException e) {
						UtilidadesLog.error(e);
						ctx.setRollbackOnly();
						throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
					}
				}
			}
		}
		UtilidadesLog.info("MONMantenimientoAgrupacionStockBean.eliminarDetalleAgrupacionStock(DTOOID dto):Salida");
	}
	
	private Boolean existeAgrupacionStockPorDefecto(Long pais) throws MareException {
		UtilidadesLog.info("MONMantenimientoAgrupacionStockBean.existeAgrupacionStockPorDefecto(Long pais):Entrada");
		DAOAgrupacionStock daoAgrupacionStock=new DAOAgrupacionStock(ctx.getCallerPrincipal().getName());
		RecordSet rs=daoAgrupacionStock.consultarAgrupacionStockPorDefecto(pais);	
		Boolean retorno=null;
		if(rs!=null&&!rs.esVacio()){
			retorno=Boolean.TRUE;
		}else{
			retorno=Boolean.FALSE;
		}
		UtilidadesLog.info("MONMantenimientoAgrupacionStockBean.existeAgrupacionStockPorDefecto(Long pais):Salida");
		return retorno;
	}


    private void validaAcceso(Long pais, Long marca, Long canal, Long acceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio) throws  MareException {
        UtilidadesLog.info("MONMantenimientoAgrupacionStockBean.validaAcceso(Long pais, Long marca, Long canal, Long acceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio):Entrada");
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
        UtilidadesLog.info("MONMantenimientoAgrupacionStockBean.validaAcceso(Long pais, Long marca, Long canal, Long acceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio):Salida");
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
	
	private void logearError(String mensaje,Throwable e) {
		//mensaje: nombreMetodo: tipoExcepcion
		UtilidadesLog.error("****Error Metodo: "+mensaje+": "+ e.getMessage());
		UtilidadesLog.error(e);
	}

	private void logearStackTrace(Throwable e){
		try{						
			ByteArrayOutputStream pila = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(pila);
			e.printStackTrace(out);
			UtilidadesLog.error(pila.toString());
		}catch(Exception ex){
			UtilidadesLog.error("Error Logeando Pila: "+ex.getMessage());
		}			
	}
        
    private Entidadi18nLocalHome getI18NEntityLocalHome() {
        return new Entidadi18nLocalHome();
    }   

    private AgrupacionStockCabeceraLocalHome getAgrupacionStockCabeceraLocalHome() {
        return new AgrupacionStockCabeceraLocalHome();
    }   

    private AgrupacionStockDetalleLocalHome getAgrupacionStockDetalleLocalHome() {
        return new AgrupacionStockDetalleLocalHome();
    }   
    


}
