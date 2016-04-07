/**
 * Sistema:     Belcorp
 * Modulo:      PED
 * Fecha:       12/07/2004
 * @version     1.0
 * @autor       Maximiliano Dello Russo
 */

package es.indra.sicc.logicanegocio.ped;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import es.indra.sicc.entidades.ped.TiposSolicitudLocal;
import es.indra.sicc.entidades.ped.TiposSolicitudLocalHome;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;

import es.indra.sicc.util.DTOOIDs;
import java.util.Collection;
import java.util.Iterator;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.dtos.ped.DTOTipoSolicitud;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import java.util.Vector;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocalHome;
import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocal;
import es.indra.sicc.entidades.seg.AccesoLocalHome;
import es.indra.sicc.entidades.seg.AccesoLocal;
import es.indra.sicc.dtos.ped.DTOTipoPosicionOperacion;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.logicanegocio.ped.DAOPED;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONTiposSolicitudBean implements SessionBean  {

	private static String nombrePersistencia = "PED_TIPO_SOLIC";

	SessionContext ctx;

	public void ejbCreate() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	public void ejbRemove() {}
	public void setSessionContext(SessionContext ctx) {
		this.ctx = ctx;
	}

	/**
	 * Sistema:     Belcorp
	 * Modulo:      PED
	 * Fecha:       12/07/2004
	 * @version     1.0
	 * @autor       Maximiliano Dello Russo
	 */
	// Elimina los tipos de solicitud de todos los oids del dto. 
	public void elimina(DTOOIDs dto) throws MareException {
        UtilidadesLog.info("MONTiposSolicitudBean.elimina(DTOOIDs dto): Entrada ");
		// 1.- A través del EJB entity TiposSolicitud borra todos los registros 
		// identificados por cada oid incluido en el dto y tambien hace un remove 
		// de las descripciones haciendo uso del Entity Entidadi18n.
		try{
			Entidadi18nLocalHome entidadI18NLocalHome = new Entidadi18nLocalHome();
			TiposSolicitudLocalHome tiposSolicitudLocalHome = new TiposSolicitudLocalHome();
			TiposSolicitudLocal tipoSolicitud = null;
			Entidadi18nLocal entidadI18N = null;

			Long oids[] = dto.getOids();
			Collection traducibles = null;
			Iterator it = null;

			for(int i=0; i < oids.length; i++){
				tipoSolicitud = tiposSolicitudLocalHome.findByPrimaryKey(oids[i]);
        
				traducibles = entidadI18NLocalHome.findByEntAtrPK(nombrePersistencia, new Long(1), oids[i]);
				it = traducibles.iterator();
                                
                                try {
                                    while(it.hasNext()){
                                            entidadI18N = (Entidadi18nLocal)it.next();
                                            entidadI18NLocalHome.remove(entidadI18N);
                                    }
                                } catch(PersistenceException pe) {
                                    UtilidadesLog.error("Exception: ",pe);
                                    ctx.setRollbackOnly();
                                    throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                                }
                                
                                try {
                                    tiposSolicitudLocalHome.remove(tipoSolicitud);
                                } catch(PersistenceException pe) {
                                    UtilidadesLog.error("Exception: ",pe);
                                    ctx.setRollbackOnly();
                                    throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                                }
			}
		} catch(NoResultException nre){
			UtilidadesLog.error("Exception: ",nre);
			ctx.setRollbackOnly();
			throw new MareException(nre, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		} catch(PersistenceException pe) {
			UtilidadesLog.error("Exception: ",pe);
			ctx.setRollbackOnly();
			throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
        UtilidadesLog.info("MONTiposSolicitudBean.elimina(DTOOIDs dto): Salida ");
	}


	/**
	 * Sistema:     Belcorp
	 * Modulo:      PED
	 * Fecha:       12/07/2004
	 * @version     1.0
	 * @autor       Maximiliano Dello Russo
	 */
	// Guarda el Tipo de Solicitud. 
	public void guarda(DTOTipoSolicitud dto) throws MareException {
		// 1.- Si dto.oid es distinto de null se realiza una modificación usando
		// el EJB entity TiposSolicitud buscando por dto.oid. Si por el contrario
		// es null, se hace un create. 
		// En ambos la información a guardar en el EJBentity es: 
		//	tipoSolicitud.codigo = dto.codigo 
		// tipoSolicitud.claseSolicitud = dto.claseSolicitud 
		// tipoSolicitud.indConsolidado = dto.indConsolidado 
		// tipoSolicitud.indSolNegativa = dto.indSolNegativa 
		// tipoSolicitud.indDevoluciones = dto.indDevoluciones 
		// tipoSolicitud.indAnulacion = dto.indAnulacion 
		// tipoSolicitud.marca = dto.marca 
		// tipoSolicitud.acceso = dto.acceso 
		// tipoSolicitud.subacceso = dto.subacceso 
		// tipoSolicitud.tipoCliente = dto.tipoCliente 

		// 2.- Para cada DTO del vector dto.attriTraducible se debe hacer una 
		// llamada al método "create" (en caso de haber realizado una inserción)
		// o "find..." y "set..." (en caso de modificación) del Entity Bean: 
		// Entidadi18n". En ambos casos el oid es tipoSolicitud.oid. 
        UtilidadesLog.info("MONTiposSolicitudBean.guarda(DTOTipoSolicitud dto): Entrada ");
		try{
			UtilidadesLog.debug("### Entro en guarda ###");
			UtilidadesLog.debug(dto.toString());
			TiposSolicitudLocalHome tipoSolicitudLocalHome = new TiposSolicitudLocalHome();
			TiposSolicitudLocal tipoSolicitud = null;
			Entidadi18nLocalHome entidadI18NLocalHome = new Entidadi18nLocalHome();
			Entidadi18nLocal entidadI18N = null;
			if( dto.getOid() != null ){
				tipoSolicitud = tipoSolicitudLocalHome.findByPrimaryKey(dto.getOid());
				UtilidadesLog.debug("Encontrada tipoSolicitud");
				tipoSolicitud.setCodigo(dto.getCodigo()); 
				tipoSolicitud.setOidClaseSolicitud(dto.getClaseSolicitud());
				tipoSolicitud.setIndConsolidado(dto.getIndConsolidado());
				tipoSolicitud.setIndSolNegativa(dto.getIndSolNegativa());
				tipoSolicitud.setIndDevoluciones(dto.getIndDevoluciones());
				tipoSolicitud.setIndAnulacion(dto.getIndAnulacion());
				tipoSolicitud.setOidMarca(dto.getMarca());
				tipoSolicitud.setOidAcceso(dto.getAcceso());
				tipoSolicitud.setOidTipoCliente(dto.getTipoCliente());
				//-- DUDA: Que pasa con el atributo oidGrupoSolicitud 
				// Resolucion punto 2
				Vector vecDescripciones = dto.getAttriTraducible();
				Iterator it = vecDescripciones.iterator();
				DTOI18nSICC dtoI18N = null;
				while(it.hasNext()){
					dtoI18N = (DTOI18nSICC)it.next();
					UtilidadesLog.debug("ValorI18n: %" + dtoI18N.getValorI18n() + "%");
					try{
						entidadI18N = entidadI18NLocalHome.findByEntAtrIdioPK(nombrePersistencia, dtoI18N.getOidAtriuto(), 
																		dtoI18N.getOidIdioma(), dto.getOid());
						UtilidadesLog.debug("Encontro Entidadi18n");
						if( dtoI18N.getValorI18n().equals("") || dtoI18N.getValorI18n().equals(" ") || dtoI18N.getValorI18n() == null){
							UtilidadesLog.debug("Borrando");
                                                        try {
                                                            entidadI18NLocalHome.remove(entidadI18N);
                                                        } catch (PersistenceException e) {
                                                            ctx.setRollbackOnly();
                                                            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                                                        }
						}else{
							UtilidadesLog.debug("Seteando");
							entidadI18N.setDetalle(dtoI18N.getValorI18n());	
                                                        try {
                                                            entidadI18NLocalHome.merge(entidadI18N);
                                                        } catch (PersistenceException e) {
                                                            ctx.setRollbackOnly();
                                                            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                                                        }
						}
					}catch(NoResultException e){
						if( dtoI18N.getValorI18n() != null && !dtoI18N.getValorI18n().equals("") && !dtoI18N.getValorI18n().equals(" ") ){
							UtilidadesLog.debug("Creando");
                                                        try {
                                                            entidadI18NLocalHome.create( nombrePersistencia, dtoI18N.getOidAtriuto(), dtoI18N.getOidIdioma(),
														dtoI18N.getValorI18n(), dto.getOid() );
                                                        } catch (PersistenceException pe) {
                                                            ctx.setRollbackOnly();
                                                            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                                                        }
						}
					}catch(PersistenceException e) {
                                            ctx.setRollbackOnly();
                                            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                                        }
				}
			}else{
				UtilidadesLog.debug("Creando nuevo tipoSolicitud");
                                try {
                                    tipoSolicitud = tipoSolicitudLocalHome.create(dto.getCodigo(), dto.getTipoCliente(), dto.getMarca(),
														dto.getAcceso(), dto.getClaseSolicitud(), dto.getIndConsolidado(),
														dto.getIndSolNegativa(), dto.getIndDevoluciones(), dto.getIndAnulacion());
                                } catch (PersistenceException e) {
                                    ctx.setRollbackOnly();
                                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                                }
				// Pto 2:
				Vector vecDescripciones = dto.getAttriTraducible();
				Iterator it = vecDescripciones.iterator();
				DTOI18nSICC dtoI18N = null;
				while(it.hasNext()){
					dtoI18N = (DTOI18nSICC)it.next();
					if( dtoI18N.getValorI18n() != null && !dtoI18N.getValorI18n().equals("") && !dtoI18N.getValorI18n().equals(" ")){
						UtilidadesLog.debug("Creando entidadI18N");
                                                try {
                                                    entidadI18NLocalHome.create(nombrePersistencia, dtoI18N.getOidAtriuto(), dtoI18N.getOidIdioma(), 
													dtoI18N.getValorI18n(), tipoSolicitud.getOid());
                                                } catch (PersistenceException e) {
                                                    ctx.setRollbackOnly();
                                                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                                                }
					}
				}
			}
			tipoSolicitud.setOidSubacceso(dto.getSubacceso());	
                        try {
                            tipoSolicitudLocalHome.merge(tipoSolicitud);
                        } catch (PersistenceException e) {
                            ctx.setRollbackOnly();
                            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }
		} catch (NoResultException e) {
			UtilidadesLog.error("Exception: ",e);
			ctx.setRollbackOnly();
		    throw new MareException(e, UtilidadesError.armarCodigoError(
				CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		} catch (PersistenceException pe) {
			 UtilidadesLog.error("Exception: ",pe);
			ctx.setRollbackOnly();
		    throw new MareException(pe, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
        UtilidadesLog.info("MONTiposSolicitudBean.guarda(DTOTipoSolicitud dto): Salida ");
	}

	/**
	 * Sistema:     Belcorp
	 * Modulo:      PED
	 * Fecha:       12/07/2004
	 * @version     1.0
	 * @autor       Maximiliano Dello Russo
	 */
	// Obtiene los tipos de solicitud. 
	public DTOSalida consulta(DTOTipoSolicitud dto) throws MareException {
        UtilidadesLog.info("MONTiposSolicitudBean.consulta(DTOTipoSolicitud dto): Entrada ");
		// 1.- Devuelve el resultado de DAOPED.obtieneTiposSolicitud(dto).
		UtilidadesLog.debug("### Entro en consulta ###");
		DTOSalida dtoSalida = new DTOSalida();
		String user = ctx.getCallerPrincipal().getName();
		DAOPED dao = new DAOPED(user);
		
		dtoSalida = dao.obtieneTiposSolicitud(dto);
        UtilidadesLog.info("MONTiposSolicitudBean.consulta(DTOTipoSolicitud dto): Salida ");
		return dtoSalida;
	}

	/**
	 * Sistema:     Belcorp
	 * Modulo:      PED
	 * Fecha:       12/07/2004
	 * @version     1.0
	 * @autor       Maximiliano Dello Russo
	 */
	// Obtiene los detalles del tipo de solicitud. 
	public DTOTipoSolicitud consultaDetalles(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONTiposSolicitudBean.consultaDetalles(DTOOID dto): Entrada ");
		// 1.- Hace un findByPrimaryKey del EJB entity TiposSolicitud con dto.oid 
		// y obtiene un objeto al que llamaremos tipoSolicitud. 
		// 2.- Se crea un DTOTipoSolicitud (dtos) que se rellena así: 
		// 	dtos.codigo = tipoSolicitud.codigo 
		// 	dtos.claseSolicitud = tipoSolicitud.claseSolicitud 
		// 	dtos.indConsolidado = tipoSolicitud.indConsolidado 
		// 	dtos.indSolNegativa = tipoSolicitud.indSolNegativa 
		// 	dtos.indDevoluciones = tipoSolicitud.indDevoluciones 
		// 	dtos.indAnulacion = tipoSolicitud.indAnulacion 
		// 	dtos.marca = tipoSolicitud.marca 
		// 	dtos.acceso = tipoSolicitud.acceso 
		// 	dtos.subacceso = tipoSolicitud.subacceso 
		// 	dtos.tipoCliente = tipoSolicitud.tipoCliente 
		// 	dtos.pais = dto.pais 
		// 	dtos.idioma = dto.idioma 
		// 3 .- (Punto agregado a partir de la incidencia BELC300006384)
		// Hace un findByPrimaryKey del EJB entity Acceso con tipoSolicitud.acceso
		// y obtiene un objeto al que llamaremos Acceso. De este se toma el 
		// valor del oid del canal y se le asigna al dto.canal.
		// 4.- Hace Entidadi18n.findByEntAtrPK("PED_TIPO_SOLIC", 1, dto.oid) y
		// con cada elemento de la colección devuelta crea un elemento DTOI18nSICC, 
		// al final tendrá un array de DTOI18nSICC que llamaremos descripciones. 
		// 5.- dtos.attriTraducible <- descripciones 
		// 6.- Devuelve el dto creado.
		try{
			// 1.-
			TiposSolicitudLocalHome tiposSolicitudLocalHome = new TiposSolicitudLocalHome();
			TiposSolicitudLocal tipoSolicitud = tiposSolicitudLocalHome.findByPrimaryKey(dto.getOid());
			// 2.-
			DTOTipoSolicitud dtos = new DTOTipoSolicitud();
			dtos.setCodigo(tipoSolicitud.getCodigo());
			dtos.setClaseSolicitud(tipoSolicitud.getOidClaseSolicitud());
			dtos.setIndConsolidado(tipoSolicitud.getIndConsolidado());
			dtos.setIndSolNegativa(tipoSolicitud.getIndSolNegativa());
			dtos.setIndDevoluciones(tipoSolicitud.getIndDevoluciones());
			dtos.setIndAnulacion(tipoSolicitud.getIndAnulacion());
			dtos.setMarca(tipoSolicitud.getOidMarca());
			dtos.setAcceso(tipoSolicitud.getOidAcceso());
			dtos.setSubacceso(tipoSolicitud.getOidSubacceso());
			dtos.setTipoCliente(tipoSolicitud.getOidTipoCliente());
			dtos.setOidPais(dto.getOidPais());
			dtos.setOidIdioma(dto.getOidIdioma());
			dtos.setOid(dto.getOid());
			// 3.-
			AccesoLocalHome accesoLH = new AccesoLocalHome();
			AccesoLocal acceso = accesoLH.findByPrimaryKey(tipoSolicitud.getOidAcceso());
			dtos.setCanal(acceso.getOidCanal());
			// 4.-
			Entidadi18nLocalHome entidadI18NLocalHome = new Entidadi18nLocalHome();
			Collection collectionEntidadesI18n = entidadI18NLocalHome.findByEntAtrPK(nombrePersistencia, new Long(1), dto.getOid());
			Iterator it = collectionEntidadesI18n.iterator();
			Entidadi18nLocal entidadI18N;
			DTOI18nSICC dtoI18n = null;
			Vector vecDescripciones = new Vector();
			while(it.hasNext()){
				entidadI18N = (Entidadi18nLocal)it.next();
				dtoI18n = new DTOI18nSICC();
				dtoI18n.setOidAtriuto(entidadI18N.getAtributo());
				dtoI18n.setOidIdioma(entidadI18N.getIdioma());
				dtoI18n.setValorI18n(entidadI18N.getDetalle());
				vecDescripciones.add(dtoI18n);
			}
			// 5.-
			dtos.setAttriTraducible(vecDescripciones);
			// 6.-
                        UtilidadesLog.info("MONTiposSolicitudBean.consultaDetalles(DTOOID dto): Salida ");
			return dtos;
		} catch (NoResultException e) {
			UtilidadesLog.error("Exception: ",e);
			ctx.setRollbackOnly();
		    throw new MareException(e, UtilidadesError.armarCodigoError(
				CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		} catch (PersistenceException pe) {
			UtilidadesLog.error("Exception: ",pe);
			ctx.setRollbackOnly();
		    throw new MareException(pe, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
		}
	}

	/**
	 * Sistema:     Belcorp
	 * Modulo:      PED
	 * Fecha:       15/07/2004
	 * @version     1.0
	 * @autor       Maximiliano Dello Russo
	 * Descripcion: Obtiene los detalles del tipo de solicitud a partir de un tipo de solicitud por pais recibido. 
	 */
	public DTOTipoSolicitud obtenerValoresAsociadosTipoSolicitud(DTOOID dtoe) throws MareException{
        UtilidadesLog.info("MONTiposSolicitudBean.obtenerValoresAsociadosTipoSolicitud(DTOOID dtoe): Entrada ");
		try{
			// 1.- Hace un findByPrimaryKey del EJB entity TiposSolicitudPais 
			// con DTOE.oid y obtiene un objeto al que llamaremos tipoSolicitudPais. 
			TiposSolicitudPaisLocalHome tipoSolPaisLH = new TiposSolicitudPaisLocalHome();
			TiposSolicitudPaisLocal tipoSolicitudPais = tipoSolPaisLH.findByPrimaryKey(dtoe.getOid());
			// 2.- Crea un DTOOID con: 
			// oid = tipoSolicitudPais.oidTipoSolicitud 
			DTOOID dtoOid = new DTOOID();
			dtoOid.setOid(tipoSolicitudPais.getOidTipoSolicitud());
			// 3.- DTOTipoSolicitud = Llamar al método consultaDetalle(DTOOID) 
			DTOTipoSolicitud dtoSalida = new DTOTipoSolicitud();
			dtoSalida = consultaDetalles(dtoOid);
			// 4.- Devuelve el DTOTipoSolicitud
                        UtilidadesLog.info("MONTiposSolicitudBean.obtenerValoresAsociadosTipoSolicitud(DTOOID dtoe): Salida ");
			return dtoSalida;
                } catch(NoResultException nre) {
                        UtilidadesLog.error("Exception: ",nre);
                        ctx.setRollbackOnly();
                    throw new MareException(nre, UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		} catch(PersistenceException pe){
			UtilidadesLog.error("Exception: ",pe);
			ctx.setRollbackOnly();
		    throw new MareException(pe, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
		}
	}


    /**
     * Sistema:     Belcorp
     * Modulo:      PED
     * Fecha:       12/08/2004
     * @version     1.0
     * @autor       Maximiliano Dello Russo
     * Descripcion: 
     */
	public DTOSalida obtieneTipoPosicionOperacion(DTOTipoPosicionOperacion dto) throws MareException {
        UtilidadesLog.info("MONTiposSolicitudBean.obtieneTipoPosicionOperacion(DTOTipoPosicionOperacion dto): Entrada ");
		// ** Obtiene oid de tipoPosicion contenidos en tipoSolicitudProceso y descripción de 
		// tipoPosicion filtrando por los criterios de entrada definidos en el dto que sean distintos de null 
		// Entrada: 
		// - dto : DTOTipoPosicionOperacion 
		// - oidTipoSolicitudPais 
		// - oidMarca : Long 
		// - oidCanal : Long 
		// - oidTipoCliente : Long 
		// - oidOperacion : Long 
		// Proceso: 
		// -> Llamar al método DAOPED.obtieneTipoPosicionOperacion(dto : DTOTipoPosicionOperacion) : DTOSalida 
		DTOSalida dtoSalida = new DTOSalida();
		String user = ctx.getCallerPrincipal().getName();
		DAOPED dao = new DAOPED(user);
		dtoSalida = dao.obtieneTipoPosicionOperacion(dto);
		// -> Devolver objeto DTOSalida obtenido en la llamada anterior.		
        UtilidadesLog.info("MONTiposSolicitudBean.obtieneTipoPosicionOperacion(DTOTipoPosicionOperacion dto): Salida ");
		return dtoSalida;
	}

  // ***********************************************************************************
  // Autor: ssantana, 19/11/2004
  // Motivo: inc. 9737
  // Desc: Llama a DAOPED.obtieneTiposSolicitud(dtoBelcorp) y devuelve un DTOSalida
  //       con el RecordSet que devuelve el método del DAO.
  // ***********************************************************************************
  public DTOSalida obtenerAccesosBelcenter(DTOBelcorp dtoBelcorp) throws MareException {
    UtilidadesLog.info("MONTiposSolicitudBean.obtenerAccesosBelcenter(DTOBelcorp dtoBelcorp): Entrada ");
    UtilidadesLog.debug(" ---- Entrando a MONTiposSolicitudBean.obtenerAccesosBelcenter ");
    DTOSalida dtoSalida = new DTOSalida();
    
    DAOPED daoPed = new DAOPED( ctx.getCallerPrincipal().getName() );

    RecordSet r = daoPed.obtieneAccesosBelcenter(dtoBelcorp);
    dtoSalida.setResultado(r);

    UtilidadesLog.debug(" ---- Saliendo de MONTiposSolicitudBean.obtenerAccesosBelcenter ");
    UtilidadesLog.debug("dtoSalida a Retornar: " + dtoSalida);
    UtilidadesLog.info("MONTiposSolicitudBean.obtenerAccesosBelcenter(DTOBelcorp dtoBelcorp): Salida ");
    return dtoSalida;
  }

}