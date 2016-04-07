package es.indra.sicc.logicanegocio.ped;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudOP;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudPais;
import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocalHome;
import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocal;
import es.indra.sicc.entidades.ped.TiposSolicitudLocalHome;
import es.indra.sicc.entidades.ped.TiposSolicitudLocal;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudOperacion;
import es.indra.sicc.dtos.ped.DTOTipoPosicionOperacion;
import es.indra.sicc.entidades.seg.AccesoLocalHome;
import es.indra.sicc.entidades.seg.AccesoLocal;
import es.indra.sicc.util.DTOBelcorp;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONTiposSolicitudPaisBean implements SessionBean, IPEDTiposSolicitud  {
	private SessionContext ctx;

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
	 * Fecha:       22/07/2004
	 * @version     1.0
	 * @autor       Maximiliano Dello Russo
	 * Descripcion: Elimina los tipos de solicitud por pais de todos los oids del dto. 
	 */
	public void elimina(DTOOIDs dto) throws MareException {
        UtilidadesLog.info("MONTiposSolicitudPaisBean.elimina(DTOOIDs dto): Entrada ");
		// A través del EJB entity TiposSolicitudPais borra todos los registros 
		// identificados por cada oid incluido en el dto. 
		try{
			TiposSolicitudPaisLocalHome tiposSolPaisLH =  new TiposSolicitudPaisLocalHome();
			TiposSolicitudPaisLocal tiposSolPais;
			Long [] dtos = dto.getOids();
			for( int i = 0; i < dtos.length; i++ ){
				tiposSolPais = tiposSolPaisLH.findByPrimaryKey(dtos[i]);
                                try {
                                    tiposSolPaisLH.remove(tiposSolPais);
                                } catch (PersistenceException e) {
                                    UtilidadesLog.error("Exception: ",e);
                                    ctx.setRollbackOnly();
                                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                                }
			}
		} catch(NoResultException e) {
			UtilidadesLog.error("Exception: ",e);
			ctx.setRollbackOnly();
			throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		} catch(PersistenceException e) {
			UtilidadesLog.error("Exception: ",e);
			ctx.setRollbackOnly();
			throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
		}
        UtilidadesLog.info("MONTiposSolicitudPaisBean.elimina(DTOOIDs dto): Salida ");
	}

	/**
	 * Sistema:     Belcorp
	 * Modulo:      PED
	 * Fecha:       22/07/2004
	 * @version     1.0
	 * @autor       Maximiliano Dello Russo
	 * Descripcion: Guarda el Tipo de Solicitud por Pais 
	 */
	public void guarda(DTOTipoSolicitudPais dto) throws MareException {
		try{
			UtilidadesLog.info("MONTiposSolicitudPaisBean.guarda(DTOTipoSolicitudPais dto): Entrada ");
			TiposSolicitudPaisLocalHome tiposSolPaisLH = new TiposSolicitudPaisLocalHome();
			TiposSolicitudPaisLocal tiposSolicitudPais = null;
			// 1.- Invoca a compruebaActualizacion(dto) y se recibe una MareException la lanza sin continuar el proceso. 
			UtilidadesLog.debug("CompruebaActualizacion");
			if( dto.getTipoConsolidado() != null ){
				try{
					compruebaActualizacion(dto);
				} catch(MareException e){
					throw e;
				}
			}
			UtilidadesLog.debug("Comprobacion OK.");
			// 2.- Si dto.oid es distinto de null se realiza una modificación usando el EJB entity 
			// TiposSolicitudPais buscando por dto.oid. 
			if( dto.getOid() != null ){
				UtilidadesLog.debug("OID != NULL");
				tiposSolicitudPais = tiposSolPaisLH.findByPrimaryKey(dto.getOid());
				UtilidadesLog.debug("Se realizo finder");
				tiposSolicitudPais.setOidPais(dto.getOidPais());
				tiposSolicitudPais.setOidTipoSolicitud( dto.getTipoSolicitud() );
				tiposSolicitudPais.setSujetoFlete( dto.getSujetoFlete() );
				tiposSolicitudPais.setReservaStock( dto.getReservaStock() );
				tiposSolicitudPais.setPermiteReversion( dto.getPermiteReversion() );
				tiposSolicitudPais.setIndPedidoPrueba( dto.getIndPedidoPrueba() );
				tiposSolicitudPais.setIndComisionable( dto.getIndComisionable() );
				tiposSolicitudPais.setIndVentaSAB14( dto.getIndVentaSAB14() );
				tiposSolicitudPais.setPermiteUnionSolicitudes( dto.getPermiteUnionSolicitudes() );
				tiposSolicitudPais.setIndPedGtZona( dto.getIndPedGtZona() );
				tiposSolicitudPais.setIndCambioVentaBEL( dto.getIndCambioVentaBEL() );
                                
			}else{
				// Si por el contrario es null, se hace un create. 
				UtilidadesLog.debug("OID == NULL");
                                try {
                                    tiposSolicitudPais = tiposSolPaisLH.create( dto.getOidPais(), dto.getTipoSolicitud(), dto.getSujetoFlete(),
                                                                                dto.getReservaStock(), dto.getPermiteReversion(), dto.getIndPedidoPrueba(),
                                                                                dto.getIndComisionable(), dto.getIndVentaSAB14(), dto.getPermiteUnionSolicitudes(),
                                                                                dto.getIndPedGtZona(), dto.getIndCambioVentaBEL() );				
                                } catch (PersistenceException e) {
                                    UtilidadesLog.error("Exception: ",e);
                                    ctx.setRollbackOnly();
                                    throw new MareException(e, UtilidadesError.armarCodigoError(
                                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                                }
				UtilidadesLog.debug("Se creo entidad");
			}
			tiposSolicitudPais.setNumPorLote(dto.getNumPorLote());
			tiposSolicitudPais.setAlarmaNumUnidades(dto.getAlarmaNumUnidades());
			tiposSolicitudPais.setOidSociedad(dto.getSociedad());
			tiposSolicitudPais.setOidFormaPago(dto.getFormaPago());
			tiposSolicitudPais.setOidTipoDocumentoLegal(dto.getTipoDocumentoLegal());
			tiposSolicitudPais.setOidMoneda(dto.getMoneda());
			tiposSolicitudPais.setOidActividad(dto.getActividad());
			tiposSolicitudPais.setOidTipoMovReserva(dto.getTipoMovReserva());
			tiposSolicitudPais.setOidTipoMovAsigna(dto.getTipoMovAsigna());
			tiposSolicitudPais.setOidTipoMovFacturacion(dto.getTipoMovFacturacion());
			tiposSolicitudPais.setOidTipoSolicitud(dto.getTipoSolicitud());
			tiposSolicitudPais.setOidTipoConsolidado(dto.getTipoConsolidado());
			tiposSolicitudPais.setGlosa(dto.getGlosa());
			tiposSolicitudPais.setOidAlmacen(dto.getAlmacen());	
                        
                        try {
                            tiposSolPaisLH.merge(tiposSolicitudPais);
                        } catch (PersistenceException e) {
                            UtilidadesLog.error("Exception: ",e);
                            ctx.setRollbackOnly();
                            throw new MareException(e, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }
			UtilidadesLog.debug("Listoc");
		} catch (NoResultException e) {
			UtilidadesLog.error("Exception: ",e);
			ctx.setRollbackOnly();
		    throw new MareException(e, UtilidadesError.armarCodigoError(
				CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		} catch (PersistenceException e) {
			 UtilidadesLog.error("Exception: ",e);
			ctx.setRollbackOnly();
		    throw new MareException(e, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
		}
		UtilidadesLog.info("MONTiposSolicitudPaisBean.guarda(DTOTipoSolicitudPais dto): Salida ");
	}

	/**
	 * Sistema:     Belcorp
	 * Modulo:      PED
	 * Fecha:       22/07/2004
	 * @version     1.0
	 * @autor       Maximiliano Dello Russo
	 * Descripcion: Obtiene los tipos de solicitud. 
	 */
	public DTOSalida consulta(DTOTipoSolicitudPais dto) throws MareException {
		// Invoca a DAOPED.obtieneTiposSolicitudPais(dto) y devuelve el DTOSalida.
        UtilidadesLog.info("MONTiposSolicitudPaisBean.consulta(DTOTipoSolicitudPais dto): Entrada ");
		String user = ctx.getCallerPrincipal().getName();
		DAOPED dao = new DAOPED(user);
		DTOSalida salida = dao.obtieneTiposSolicitudPais(dto);
        UtilidadesLog.info("MONTiposSolicitudPaisBean.consulta(DTOTipoSolicitudPais dto): Salida ");
		return salida;
	}

	/**
	 * Sistema:     Belcorp
	 * Modulo:      PED
	 * Fecha:       22/07/2004
	 * @version     1.0
	 * @autor       Maximiliano Dello Russo
	 * Descripcion: Obtiene los detalles del tipo de solicitud por país. 
	 */
	public DTOTipoSolicitudPais consultaDetalles(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONTiposSolicitudPaisBean.consultaDetalles(DTOOID dto): Entrada ");
		try{
			// 1.- Hace un findByPrimaryKey del EJB entity TiposSolicitudPais con dto.oid y 
			// obtiene un objeto al que llamaremos tipoSolicitudPais. 
			TiposSolicitudPaisLocalHome tiposSolPaisLH = new TiposSolicitudPaisLocalHome();
			TiposSolicitudPaisLocal tipoSolicitudPais = tiposSolPaisLH.findByPrimaryKey(dto.getOid());
			// 2.- Se crea un DTOTipoSolicitud (dtos) que se rellena así: 
			DTOTipoSolicitudPais dtos = new DTOTipoSolicitudPais();
			dtos.setOid(tipoSolicitudPais.getOid());
			dtos.setNumPorLote(tipoSolicitudPais.getNumPorLote());
			dtos.setAlarmaNumUnidades(tipoSolicitudPais.getAlarmaNumUnidades());
			dtos.setSujetoFlete(tipoSolicitudPais.getSujetoFlete());
			dtos.setPermiteUnionSolicitudes(tipoSolicitudPais.getPermiteUnionSolicitudes());
			dtos.setReservaStock(tipoSolicitudPais.getReservaStock());
			dtos.setPermiteReversion(tipoSolicitudPais.getPermiteReversion());
			dtos.setIndPedidoPrueba(tipoSolicitudPais.getIndPedidoPrueba());
			dtos.setIndComisionable(tipoSolicitudPais.getIndComisionable());
			dtos.setIndPedGtZona(tipoSolicitudPais.getIndPedGtZona());
			dtos.setIndCambioVentaBEL(tipoSolicitudPais.getIndCambioVentaBEL());
			dtos.setIndVentaSAB14(tipoSolicitudPais.getIndVentaSAB14());
			dtos.setSociedad(tipoSolicitudPais.getOidSociedad());
			dtos.setFormaPago(tipoSolicitudPais.getOidFormaPago());
			dtos.setTipoDocumentoLegal(tipoSolicitudPais.getOidTipoDocumentoLegal());
			dtos.setMoneda(tipoSolicitudPais.getOidMoneda());
			dtos.setActividad(tipoSolicitudPais.getOidActividad());
			dtos.setTipoMovReserva(tipoSolicitudPais.getOidTipoMovReserva());
			dtos.setTipoMovAsigna(tipoSolicitudPais.getOidTipoMovAsigna());
			dtos.setTipoMovFacturacion(tipoSolicitudPais.getOidTipoMovFacturacion());
			dtos.setOidPais(tipoSolicitudPais.getOidPais());
			dtos.setTipoSolicitud(tipoSolicitudPais.getOidTipoSolicitud());
			dtos.setTipoConsolidado(tipoSolicitudPais.getOidTipoConsolidado());
			dtos.setGlosa(tipoSolicitudPais.getGlosa());
			dtos.setAlmacen(tipoSolicitudPais.getOidAlmacen());
			// 3.- Devuelve el dto creado.
            UtilidadesLog.info("MONTiposSolicitudPaisBean.consultaDetalles(DTOOID dto): Salida ");
			return dtos;
		} catch (NoResultException e) {
			UtilidadesLog.error("Exception: ",e);
			ctx.setRollbackOnly();
		    throw new MareException(e, UtilidadesError.armarCodigoError(
				CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		} catch (PersistenceException e) {
			 UtilidadesLog.error("Exception: ",e);
			ctx.setRollbackOnly();
		    throw new MareException(e, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
		}
	}

	/**
	 * Sistema:     Belcorp
	 * Modulo:      PED
	 * Fecha:       22/07/2004
	 * @version     1.0
	 * @autor       Maximiliano Dello Russo
	 * Descripcion: Comprueba que los tipos de solicitud y consolidado 
	 * sean compatibles, es decir, que si el Tipo de Solicitud tiene 
	 * Acceso=Belcenter, el Tipo de Solicitud de Consolidado tenga también 
	 * Acceso=Belcenter y mismo Canal/Acceso que el Tipo de Solicitud
   * 
   * --------------------------------------------------------------------
   * 
   * Modificado: 22/11/2004
   * Autor: Cristian Valenzuela
   * Incidencias: 9765 y 9800
	 */
	private void compruebaActualizacion(DTOTipoSolicitudPais dto) throws MareException{
        UtilidadesLog.info("MONTiposSolicitudPaisBean.compruebaActualizacion(DTOTipoSolicitudPais dto): Entrada ");
    try {    
      /*  1.- TiposSolicitud.findByPrimaryKey(dto.tipoSolicitud) y el objeto devuelto lo llamamos tiposolicitud
          2.- TiposSolicitud.findByPrimaryKey(dto.tipoConsolidado) y el objeto devuelto lo llamamos tipoconsolidado
             accesoSolicitud = tiposolicitud.acceso //oid del acceso del tipo de solicitud
             accesoConsolidado = tipoconsolidado.acceso //oid del acceso del tipo de consolidado
          3.- accSolicitud = Llamar al método Acceso.findByPk (accesoSolicitud)
             indicadorAccesoSolicitud = accSolicitud.indicador
    
          4.-  Si (indicadorAccesoSolicitud == ConstantesSEG.IND_ACCESO_BELCENTER (belcenter)
                { 
                  Si accesoSolicitud<>accesoConsolidado
                      se lanza la MareException PED-007 "Tipo de solicitud o tipo de consolidado no es de Belcenter" 
                }
               En caso contrario sale del método. */
      
      TiposSolicitudLocalHome tiposSolicitudLH = new TiposSolicitudLocalHome();
			TiposSolicitudLocal tipoSolicitud = null;
      TiposSolicitudPaisLocal tipoSolicitudPais = null;
			TiposSolicitudLocal tipoConsolidado = null;
      TiposSolicitudPaisLocalHome tiposSolicitudPaisLH = new TiposSolicitudPaisLocalHome();
      
      //1
      tipoSolicitud = tiposSolicitudLH.findByPrimaryKey(dto.getTipoSolicitud());
      tipoSolicitudPais = tiposSolicitudPaisLH.findByPrimaryKey(dto.getTipoConsolidado());
      //2
      tipoConsolidado = tiposSolicitudLH.findByPrimaryKey(tipoSolicitudPais.getOidTipoSolicitud());

      AccesoLocalHome accesoLH = new AccesoLocalHome();
			AccesoLocal accesoSolicitud = null;
			AccesoLocal accesoConsolidado = null;

      accesoSolicitud = accesoLH.findByPrimaryKey(tipoSolicitud.getOidAcceso());
      accesoConsolidado = accesoLH.findByPrimaryKey(tipoConsolidado.getOidAcceso());

      //3
      AccesoLocal accSolicitud = null;
      accSolicitud = accesoLH.findByPrimaryKey(accesoSolicitud.getOid());
      String indicadorAccesoSolicitud = accSolicitud.getIndicador();

      //4
      if(indicadorAccesoSolicitud.equals(ConstantesSEG.IND_ACCESO_BELCENTER)) {
//        if(accesoSolicitud.getOidCanal().longValue() != accesoConsolidado.getOidCanal().longValue()) {
		if( !accesoSolicitud.getIndicador().equals(accesoConsolidado.getIndicador()) ){
          throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED, "", ErroresNegocio.PED_007));
        }
      }      
    }
    catch (NoResultException e) {
      UtilidadesLog.error("Exception: ",e);
			ctx.setRollbackOnly();
		  throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		}
    catch (PersistenceException e) {
      UtilidadesLog.error("Exception: ",e);
			ctx.setRollbackOnly();
		  throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
		}
        
      UtilidadesLog.info("MONTiposSolicitudPaisBean.compruebaActualizacion(DTOTipoSolicitudPais dto): Salida ");
	} 

	private boolean esOidAccesoBelcenter(Long oid){
        UtilidadesLog.info("MONTiposSolicitudPaisBean.esOidAccesoBelcenter(Long oid): Entrada ");
		int longitud = ConstantesSEG.OID_ACCESO_BELCENTER.length;
		for( int i=0; i < longitud; i++ ){
			if( ConstantesSEG.OID_ACCESO_BELCENTER[i] == oid ){ 
                UtilidadesLog.info("MONTiposSolicitudPaisBean.esOidAccesoBelcenter(Long oid): Entrada ");
                return true;
            }
		}
        UtilidadesLog.info("MONTiposSolicitudPaisBean.esOidAccesoBelcenter(Long oid): Salida ");
		return false;
	}


    /**
     * Sistema:     Belcorp
     * Modulo:      PED
     * Fecha:       30/07/2004
     * @version     1.0
     * @autor       Marta Aurora Montiel
     * Descripcion: Llama al método DAOPED.obtieneTipoCliente(DTOE)
     */

	public DTOSalida obtieneTipoCliente(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONTiposSolicitudPaisBean.obtieneTipoCliente(DTOOID dto): Entrada ");
        String user = ctx.getCallerPrincipal().getName();
		DAOPED dao = new DAOPED(user);		
        DTOSalida dts = new DTOSalida();
        dts = dao.obtieneTipoCliente(dto);    
        UtilidadesLog.info("MONTiposSolicitudPaisBean.obtieneTipoCliente(DTOOID dto): Salida ");
		return dts;
	}

	/**
	 * Sistema:     Belcorp
	 * Modulo:      PED
	 * Fecha:       02/08/2004
	 * @version     1.0
	 * @autor       Maximiliano Dello Russo
	 * Descripcion: Obtiene oid de tipoSolicitudPais contenidos en tipoSolicitudProceso 
	 * y descripción de tipoSolicitud filtrando por los criterios de entrada definidos 
	 * en el dto que sean distintos de null .
	 */
	public DTOSalida obtieneTipoSolicitudOperacion(DTOTipoSolicitudOperacion dto) throws MareException {
        UtilidadesLog.info("MONTiposSolicitudPaisBean.obtieneTipoSolicitudOperacion(DTOTipoSolicitudOperacion dto): Entrada ");
		String user = ctx.getCallerPrincipal().getName();
		DAOPED dao = new DAOPED(user);
		// -> Llamar al método DAOPED.obtieneTipoSolicitudOperacion(dto : DTOTipoSolicitudOperacion) : DTOSalida 
		DTOSalida dtoSalida = dao.obtieneTipoSolicitudOperacion(dto);		
		// -> Devolver objeto DTOSalida obtenido en la llamada anterior.
        UtilidadesLog.info("MONTiposSolicitudPaisBean.obtieneTipoSolicitudOperacion(DTOTipoSolicitudOperacion dto): Salida ");
		return dtoSalida;
	}

	public DTOSalida obtieneTipoPosicionOperacion( DTOTipoPosicionOperacion dto) throws MareException {
        UtilidadesLog.info("MONTiposSolicitudPaisBean.obtieneTipoPosicionOperacion( DTOTipoPosicionOperacion dto): Entrada ");
		String user = ctx.getCallerPrincipal().getName();
		DAOPED dao = new DAOPED(user);
		DTOSalida dtoSalida = dao.obtieneTipoPosicionOperacion(dto);
        UtilidadesLog.info("MONTiposSolicitudPaisBean.obtieneTipoPosicionOperacion( DTOTipoPosicionOperacion dto): Salida ");
		return dtoSalida;
	}

  public DTOTipoSolicitudOP obtieneTipoSolicitudporProceso(DTOTipoSolicitudOP dto) throws MareException {
    UtilidadesLog.info("MONTiposSolicitudPaisBean.obtieneTipoSolicitudporProceso(DTOTipoSolicitudOP dto): Entrada ");
    String user = ctx.getCallerPrincipal().getName();
    UtilidadesLog.debug("usario"+ user);
    DAOPED dao =new DAOPED(user);
    UtilidadesLog.debug("despues daoped");
    dto=dao.obtieneTipoSolicitudporProceso(dto);
    UtilidadesLog.info("MONTiposSolicitudPaisBean.obtieneTipoSolicitudporProceso(DTOTipoSolicitudOP dto): Salida ");
    return dto;
  }


    public DTOSalida obtenerTipoSolicitudPaisREP(DTOBelcorp dto) throws MareException {
    UtilidadesLog.info("MONTiposSolicitudPaisBean.obtenerTipoSolicitudPaisREP(DTOBelcorp dto): Entrada ");
    String user = ctx.getCallerPrincipal().getName();
    DAOPED dao = new DAOPED(user);
    
    UtilidadesLog.info("MONTiposSolicitudPaisBean.obtenerTipoSolicitudPaisREP(DTOBelcorp dto): Salida ");
    return dao.obtenerTipoSolicitudPaisREP(dto);
  }


}