package es.indra.sicc.logicanegocio.car;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.dtos.car.DTOAsignacionCod;
import es.indra.sicc.dtos.car.DTOAsignaciones;
import es.indra.sicc.dtos.car.DTOAsignacionesEjecutivo;
import es.indra.sicc.dtos.car.DTOCodigoConfiguracion;
import es.indra.sicc.dtos.car.DTOCriteriosCodigoConf;
import es.indra.sicc.dtos.car.DTOCriteriosEjecutivo;
import es.indra.sicc.dtos.car.DTOCriteriosGrupoSol;
import es.indra.sicc.dtos.car.DTOEjecutivo;
import es.indra.sicc.dtos.car.DTOFiltroGrupoSolicitud;
import es.indra.sicc.dtos.car.DTOGrupoSolicitud;
import es.indra.sicc.dtos.car.DTOTiposSolicitudenGrupo;
import es.indra.sicc.dtos.ped.DTOTipoSolicitud;
import es.indra.sicc.dtos.car.DTOEliminarCodigoConf;
import es.indra.sicc.entidades.car.AsignacionCodigoConfiguracionLocal;
import es.indra.sicc.entidades.car.AsignacionCodigoConfiguracionLocalHome;
import es.indra.sicc.entidades.car.AsignacionEjecutivoCuentaLocalHome;
import es.indra.sicc.entidades.car.AsignacionEjecutivoCuentaLocal;
import es.indra.sicc.entidades.car.EjecutivosCuentaLocalHome;
import es.indra.sicc.entidades.car.GrupoSolicitudLocal;
import es.indra.sicc.entidades.car.GrupoSolicitudLocalHome;
import es.indra.sicc.entidades.car.ParametrosdeCarteraLocal;
import es.indra.sicc.entidades.car.ParametrosdeCarteraLocalHome;
import es.indra.sicc.entidades.car.EjecutivosCuentaLocal;
import es.indra.sicc.entidades.zon.SubGerenciaVentaLocal;
import es.indra.sicc.entidades.zon.SubGerenciaVentaLocalHome;
import es.indra.sicc.util.CAREjbLocators;
import es.indra.sicc.util.CMNEjbLocators;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.ZONEjbLocators;
import es.indra.sicc.util.PEDEjbLocators;
import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Vector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.ejb.RemoveException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.lang.Object;
import es.indra.sicc.dtos.car.DTOUsuarioJerarquia;

import es.indra.sicc.util.BelcorpService;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONCARParametrizacionBean implements SessionBean {
    private SessionContext sessionContext;
    private String ENT_GRUPOSOLICITUD = "CAR_GRUPO_SOLIC";

    public void ejbCreate() { }
    public void ejbActivate() { }
    public void ejbPassivate() { }
    public void ejbRemove() { }
    public void setSessionContext(SessionContext ctx) {  sessionContext = ctx; }

    private void actualizarTiposSolicitud(DTOGrupoSolicitud dtoin) throws MareException {
        UtilidadesLog.info("MONCARParametrizacion.actualizarTiposSolicitud(DTOGrupoSolicitud):Entrada");
		
        DAOCAR daoCAR= new DAOCAR(sessionContext.getCallerPrincipal().getName());
        Vector tiposSol = dtoin.getTiposSolicitud();
         
        if (tiposSol != null){
            daoCAR.actualizarTiposSolicitud(dtoin);
        }
        
        UtilidadesLog.info("MONCARParametrizacion.actualizarTiposSolicitud(DTOGrupoSolicitud):Salida");
    }

    public DTOSalida buscarGruposSolicitud(DTOCriteriosGrupoSol dtoin)
        throws MareException {
        UtilidadesLog.info("MONCARParametrizacion.buscarGruposSolicitud(DTOCriteriosGrupoSol):Entrada");
		DTOSalida dto = new DTOSalida();
		RecordSet rs = new RecordSet();
		
		DAOCAR daoCar = new DAOCAR(sessionContext.getCallerPrincipal().getName());
		try{
			rs = daoCar.buscarGruposSolicitud(dtoin);
		}catch(Exception ex){
			ex.printStackTrace();
		}		

		if( rs.esVacio() ){
			throw new MareException(new Exception(),
			UtilidadesError.armarCodigoError(
				CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));                    
		}            

		dto.setResultado( rs );
		UtilidadesLog.info("MONCARParametrizacion.buscarGruposSolicitud(DTOCriteriosGrupoSol):Salida");
		return dto;
    }

    public void eliminarGrupoSolicitud(DTOOIDs dtoin) throws MareException {
        UtilidadesLog.info("MONCARParametrizacion.eliminarGrupoSolicitud(DTOOIDs):Entrada");
		
		GrupoSolicitudLocalHome grupoSolLHome = null;
		GrupoSolicitudLocal grupoSolLocal = null;
                DAOCAR daoCAR= new DAOCAR(sessionContext.getCallerPrincipal().getName());
		
		Long[] oids = dtoin.getOids();
		Collection solicitudes = new ArrayList();
		Long oidGrupoSolicitud;
		
		if (oids!=null){
			grupoSolLHome = this.getGrupoSolicitudLocalHome();

			try{
				for (int i=0 ; i< oids.length; i++)  {

					oidGrupoSolicitud = daoCAR.obtenerOidGrupoSolicitud(oids[i]);
					
					desasignarTiposSolicitud( oids[i], dtoin);

					solicitudes = daoCAR.obtenerGrupoSolicitud( oidGrupoSolicitud ); 

					if (solicitudes.size()==0 || 
						((i==oids.length-1 ) && (solicitudes.size()==oids.length)) ){
						grupoSolLocal = grupoSolLHome.findByPrimaryKey(oidGrupoSolicitud); 
                                                try{
                                                    grupoSolLHome.remove(grupoSolLocal);
                                                } catch (PersistenceException pe) {
                                                    sessionContext.setRollbackOnly();
                                                    throw new MareException(pe, 
                                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                                                }
						eliminarDescripcion( oidGrupoSolicitud ); 
					}
				}
                        } catch (NoResultException nre) {
                            sessionContext.setRollbackOnly();
                            throw new MareException(nre,        
                                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                        } catch (PersistenceException pe) {
                            sessionContext.setRollbackOnly();
                            throw new MareException(pe,
                                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                        }
		}
        UtilidadesLog.info("MONCARParametrizacion.eliminarGrupoSolicitud(DTOOIDs):Salida");
    }

    public DTOGrupoSolicitud consultarGrupoSolicitud(DTOOID dtoin) throws MareException {
	UtilidadesLog.info("MONCARParametrizacion.consultarGrupoSolicitud(DTOOID):Entrada");
	   DTOGrupoSolicitud dtogSol = new DTOGrupoSolicitud();
	   DTOI18nSICC i18n =new DTOI18nSICC();
	   Vector Vi18n=new Vector();
	   Vector col = new Vector();
	   RecordSet rs = new RecordSet();
	   DAOCAR daocar =new DAOCAR(sessionContext.getCallerPrincipal().getName());
	   UtilidadesLog.debug("Asignamos todas los objetos");
	   try{
			UtilidadesLog.debug("busco la solicitud : " + dtoin.getOid() );
			Long oidGrupoSolicitud = daocar.obtenerOidGrupoSolicitud(dtoin.getOid());
                        
			UtilidadesLog.debug("el grupo es : " + oidGrupoSolicitud );                        
                        
			dtogSol.setOidGrupoSol( oidGrupoSolicitud );
			GrupoSolicitudLocalHome grupoSolicitudHome =this.getGrupoSolicitudLocalHome();
			GrupoSolicitudLocal grupoSolicitud = grupoSolicitudHome.findByPrimaryKey(oidGrupoSolicitud);
			//GrupoSolicitudLocal grupoSolicitud =grupoSolicitudHome.findByPrimaryKey(dtoin.getOid());

			
			Entidadi18nLocalHome entidadi18nLocalHome = this.getEntidadi18nLocalHome();
			UtilidadesLog.debug("entidadi18nLocalHome" );
			//Entidadi18nLocal entidadi18n =entidadi18nLocalHome.findByEntAtrIdioPK("CAR_GRUPO_SOLIC",new Long(1),dtoin.getOidIdioma(),tiposSolicitudLocal.getOidGrupoSolicitud());
			Entidadi18nLocal entidadi18n =entidadi18nLocalHome.findByEntAtrIdioPK("CAR_GRUPO_SOLIC",new Long(1),dtoin.getOidIdioma(),grupoSolicitud.getOid());
			UtilidadesLog.debug("entidadi18nLocalHome.findByEntAtrIdioPK");
			
			dtogSol.setCodGrupoSolicitud(grupoSolicitud.getCodigoGrupoSolicitud());
			i18n.setValorI18n(entidadi18n.getDetalle());
			i18n.setOidAtriuto(entidadi18n.getEntidad_pk());
			Vi18n.add(i18n);
			dtogSol.setAttriTraducible(Vi18n);
            UtilidadesLog.debug("Reasignamos los demas objetos");

			
			//Usamos los datos devueltos por la entidad
			
			
		    UtilidadesLog.debug("la tiro con: " + grupoSolicitud.getOid() );
			rs=daocar.obtenerTiposSolicitud(grupoSolicitud.getOid(),dtoin.getOidIdioma(),new Boolean(false));
			//rs=daocar.obtenerTiposSolicitud(grupoSolicitud.getOid(),dtoin.getOidIdioma(),new Boolean(false));
			UtilidadesLog.debug("Obtenemos el recordset");
			 for(int i=0;i<rs.getRecords().size();i++){
				dtogSol.setTiposSolicitud(rs.getColumn(0));	
			 }
			UtilidadesLog.debug("Salio del bucle");
		
	      
		  /*
		  
           }catch (CreateException createException) {
            sessionContext.setRollbackOnly();
            throw new MareException(createException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
    */
       } catch (NoResultException nre) {
           sessionContext.setRollbackOnly();
           throw new MareException(nre,        
               UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
       } catch (PersistenceException pe) {
           sessionContext.setRollbackOnly();
           throw new MareException(pe,
               UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }
        UtilidadesLog.info("MONCARParametrizacion.consultarGrupoSolicitud(DTOOID):Salida");
		return dtogSol;
	}

    private void actualizarDescripcion(Vector attriTraducible, Long oid)
        throws MareException {
        UtilidadesLog.info("MONCARParametrizacion.actualizarDescripcion(Vector , Long):Entrada");
		Entidadi18nLocalHome entidadi18nLocalHome;
		Entidadi18nLocal entidadi18n;
		DTOI18nSICC dtoTraduccion;
		Collection grupos = new ArrayList();


		entidadi18nLocalHome = this.getEntidadi18nLocalHome();
		for (int i=0 ; i<attriTraducible.size(); i++ )  {
			dtoTraduccion = (DTOI18nSICC) attriTraducible.get(i);
      // Si viene la traduccion con "", es que no fue cargada la modal.
      if( dtoTraduccion.getValorI18n().equals("") ) {
        continue;
      }
			try{
				entidadi18n = entidadi18nLocalHome.findByEntAtrIdioPK(
					"CAR_GRUPO_SOLIC",
					dtoTraduccion.getOidAtriuto(),
					dtoTraduccion.getOidIdioma(),
					oid);				
        //Si viene con " ", es que fue eliminada por el usuario
        if( ! dtoTraduccion.getValorI18n().equals(" ") ){
          entidadi18n.setDetalle( dtoTraduccion.getValorI18n() );
          
          entidadi18nLocalHome.merge(entidadi18n);
          
        }else{
            try{
                entidadi18nLocalHome.remove(entidadi18n);
            } catch (PersistenceException pe) {
                sessionContext.setRollbackOnly();
                throw new MareException(pe, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
            }
        }
            } catch (NoResultException nre) {
                try{
                  //Si vienen con " ", es que el usuario no la llenó.
                  if( ! dtoTraduccion.getValorI18n().equals(" ") ){
                    entidadi18n = entidadi18nLocalHome.create(
                      "CAR_GRUPO_SOLIC",
                      dtoTraduccion.getOidAtriuto(),
                      dtoTraduccion.getOidIdioma(),
                      dtoTraduccion.getValorI18n(),
                      oid);
                  }
            } catch(PersistenceException e) {
                 sessionContext.setRollbackOnly();
                 throw new MareException(e,
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            } 
        
        } catch (PersistenceException pe) {
            sessionContext.setRollbackOnly();
            throw new MareException(pe,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
    }
        UtilidadesLog.info("MONCARParametrizacion.actualizarDescripcion(Vector , Long):Salida");
    }

    private void eliminarDescripcion(Long oid) throws MareException {
        UtilidadesLog.info("MONCARParametrizacion.eliminarDescripcion(Long):Entrada");
		Entidadi18nLocalHome entidadi18nLocalHome;
		Entidadi18nLocal entidadi18n;
		Collection grupos = new ArrayList();

		try{
		
			entidadi18nLocalHome = this.getEntidadi18nLocalHome();			
			grupos = entidadi18nLocalHome.findByEntAtrPK(
				"CAR_GRUPO_SOLIC",
				new Long(1),
				oid);

			Iterator it = grupos.iterator();
			while (it.hasNext()){
			    entidadi18n = (Entidadi18nLocal) it.next();
                            try{
				entidadi18nLocalHome.remove(entidadi18n);
			    } catch (PersistenceException pe) {
                                sessionContext.setRollbackOnly();
                                throw new MareException(pe, 
                                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                            }
			}
			
                } catch (NoResultException nre) {
                    sessionContext.setRollbackOnly();
                    throw new MareException(nre,        
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                } catch (PersistenceException pe) {
                    sessionContext.setRollbackOnly();
                    throw new MareException(pe,
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
        UtilidadesLog.info("MONCARParametrizacion.eliminarDescripcion(Long):Salida");
    }

    private void desasignarTiposSolicitud(Long oidTipoSolicitud, DTOOIDs dtoin)
        throws MareException {
        UtilidadesLog.info("MONCARParametrizacion.desasignarTiposSolicitud(Long, DTOOIDs):Entrada");
      BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        StringBuffer SQL = new StringBuffer(
                "UPDATE PED_TIPO_SOLIC SET GRSO_OID_GRUP_SOLI =null");
        SQL.append(" WHERE OID_TIPO_SOLI=" + oidTipoSolicitud);

        try {
            // Ejecuta la consulta.
            int updateValue = bs.dbService.executeUpdate(SQL.toString());
            UtilidadesLog.debug("updateValue: " + updateValue);
        } catch (Exception ex) {
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONCARParametrizacion.desasignarTiposSolicitud(Long, DTOOIDs):Salida");
    }

    public DTOSalida obtenerTiposSolicitud(DTOTiposSolicitudenGrupo dtoin)
        throws MareException {
        UtilidadesLog.info("MONCARParametrizacion.obtenerTiposSolicitud(DTOTiposSolicitudenGrupo):Entrada");
        DAOCAR daocar = new DAOCAR(sessionContext.getCallerPrincipal().getName());
        RecordSet rs = new RecordSet();
        DTOSalida out = new DTOSalida();
        rs = daocar.obtenerTiposSolicitud(dtoin.getOidGrupoSolicitud(),
                dtoin.getOidIdioma(), dtoin.getTiposSolLibres());
        out.setResultado(rs);
        UtilidadesLog.info("MONCARParametrizacion.obtenerTiposSolicitud(DTOTiposSolicitudenGrupo):Salida");
        return out;
    }

    public DTOSalida obtenerNivelesRiesgo(DTOOID dtoin)
        throws MareException {
        /*
        * Este metodo llama al DAOCAR.obtenerNivelesRiesgo pasandole como parametro
        * dto.getIdioma. y dto.getOID
        Con el RecordSet que recibe crea un DTOSalida que es retornado por el método.
        Si se recibe una excepcion, esta no lanza hacia el metodo que realizo la llamada.
        * */
        UtilidadesLog.info("MONCARParametrizacion.obtenerNivelesRiesgo(DTOOID):Entrada");
        
        DAOCAR daoCAR = new DAOCAR(sessionContext.getCallerPrincipal().getName());
        
        UtilidadesLog.debug(" ANTES DE daoCAR.obtenerNivelesRiesgo() !! ");
        RecordSet rsNivelRiesgo = daoCAR.obtenerNivelesRiesgo(dtoin.getOidIdioma(),
            dtoin.getOid());
        UtilidadesLog.debug(" DESPUÉS DE daoCAR.obtenerNivelesRiesgo() !! ");
        
        DTOSalida ds = new DTOSalida();
        ds.setResultado(rsNivelRiesgo);

        UtilidadesLog.debug("retorna: " + ds);
        UtilidadesLog.info("MONCARParametrizacion.obtenerNivelesRiesgo(DTOOID):Salida");
        return ds;
    }
    
    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dtoin
     */
    // Modificado por Sergio Platas - 22/07/2005 - Inc. 19834
    public DTOSalida obtenerGruposSolicitud(DTOFiltroGrupoSolicitud dtoin)
        throws MareException {
        /*
         Este metodo llama al DAOCAR.obtenerGruposSolicitud pasandole como parametro
         dto.getIdioma y dto.getOID.
         Con el RecordSet que recibe crea un DTOSalida que es retornado por el método.
         Si se recibe una excepcion, esta no lanza hacia el metodo que realizo la llamada.
         */
        UtilidadesLog.info("MONCARParametrizacion.obtenerGruposSolicitud(DTOFiltroGrupoSolicitud):Entrada");
        
        DAOCAR daoCAR = new DAOCAR(sessionContext.getCallerPrincipal().getName());
        RecordSet rsGrupoSolicitud = null;
        
        if(dtoin.getNivelRiesgo() != null){
            UtilidadesLog.debug("  dtoin.getNivelRiesgo() != null");
            rsGrupoSolicitud = daoCAR.obtenerGruposSolicitud(dtoin.getOidIdioma(),
                dtoin.getOidCodConf(), dtoin.getNivelRiesgo());
        }else{
            rsGrupoSolicitud = daoCAR.obtenerGruposSolicitud(dtoin.getOidIdioma(),
                dtoin.getOidCodConf());            
        }
        
        UtilidadesLog.debug("Generó un RecordSet = " + rsGrupoSolicitud.toString());
        
        DTOSalida ds = new DTOSalida();
        ds.setResultado(rsGrupoSolicitud);        
        UtilidadesLog.debug("retorna: " + ds.toString());
        
        UtilidadesLog.info("MONCARParametrizacion.obtenerGruposSolicitud(DTOFiltroGrupoSolicitud):Salida");
        return ds;
    }

    public DTOSalida obtenerIndicadoresValidacion(DTOBelcorp dtoin)
        throws MareException {
        UtilidadesLog.info("MONCARParametrizacion.obtenerIndicadoresValidacion(DTOBelcorp):Entrada");
        /*
        * Este metodo llama al DAOCAR.obtenerIndicadoresValidacion pasandole como parametro dto.getIdioma.
        Con el RecordSet que recibe crea un DTOSalida que es retornado por el método.
        Si se recibe una excepcion, esta no lanza hacia el metodo que realizo la llamada.
        * */
        DAOCAR daoCAR = new DAOCAR(sessionContext.getCallerPrincipal().getName());
        RecordSet rsIndValidacion = daoCAR.obtenerIndicadoresValidacion(dtoin.getOidIdioma());
        DTOSalida ds = new DTOSalida();
        ds.setResultado(rsIndValidacion);
        UtilidadesLog.info("MONCARParametrizacion.obtenerIndicadoresValidacion(DTOBelcorp):Salida");
        return ds;
    }

    public DTOSalida obtenerCodigosConfiguracion(DTOBelcorp dtoin)
        throws MareException {
        UtilidadesLog.info("MONCARParametrizacion.obtenerCodigosConfiguracion(DTOBelcorp):Entrada");
        /*
        * Este metodo llama al DAOCAR.obtenerCodigosConfiguracion pasandole como parametro dto.getIdioma.
        Con el RecordSet que recibe crea un DTOSalida que es retornado por el método.
        Si se recibe una excepcion, esta no lanza hacia el metodo que realizo la llamada.
        * */
        DAOCAR daoCAR = new DAOCAR(sessionContext.getCallerPrincipal().getName());
        RecordSet rsCodConfiguracion = daoCAR.obtenerCodigosConfiguracion();
        DTOSalida ds = new DTOSalida();
        ds.setResultado(rsCodConfiguracion);
        UtilidadesLog.info("MONCARParametrizacion.obtenerCodigosConfiguracion(DTOBelcorp):Salida");
        return ds;
    }

    public void guardarCodigoConf(DTOCodigoConfiguracion dtoin) throws MareException {
        UtilidadesLog.info("MONCARParametrizacion.guardarCodigoConf(DTOCodigoConfiguracion):Entrada");
        /*
        Si dtoin.oidCodConf=-1 entonces (es una inserccion)
            Se hace un create de la entidad CAR:ParametrodeCartera 
            pasandole: dtoin.codConf y obteniendo la referencia a la entidad creada.

        Si dtoin.oidCodConf <> -1 entonces (es una modificacion)
            Se hace un findByPrimaryKey de la entidad CAR:ParametrosdeCartera
            utilizando el dtoin.oidCodConf.
            Una vez con la refencia al entity se hacen las llamadas a los
            metodos "set" de la entidad para asignarle los valores recibidos.
            Esto se hace para todos los atributos a excepcion de "Asignaciones".

        En caso de Error:
        Se genera una MAREexcepción con el error encontrado.
        */

        
        ParametrosdeCarteraLocalHome parametrosCarteratLocalH = this.getParametrosdeCarteraLocalHome();
       
        UtilidadesLog.debug("*********** Pasando a mayuscula el codigo");
        String codConfUpper = dtoin.getCodConf().toUpperCase();
        UtilidadesLog.debug("*********** Antes: " + dtoin.getCodConf());
        UtilidadesLog.debug("*********** Ahora: " + codConfUpper);        

        if (dtoin.getOidCodConf().longValue() == -1L) {
          UtilidadesLog.debug("*********** Insercion");
          try {
          
            //cdos gPineda inc BELC300024017 10/08/06 - COMIENZO
            UtilidadesLog.debug("*********** Se verifica el Codigo de configuracion");
            boolean existe;
            Collection parametros;
            try {
              parametros = parametrosCarteratLocalH.findByPaisYCodConf(dtoin.getOidPais(), dtoin.getCodConf() );
              UtilidadesLog.debug("parametrosCarteratLocalH.findByPaisYCodConf("+ dtoin.getOidPais() +","+ dtoin.getCodConf() +" ): "+ parametros);
              if( parametros != null && parametros.size() != 0 ){
                existe = true;
              }else{
                existe = false;
              }            
            
            } catch (NoResultException nre) {
                UtilidadesLog.debug("FinderException - el Codigo de configuracion no existe");
                existe = false;
            } catch (PersistenceException pe) {
                sessionContext.setRollbackOnly();
                throw new MareException(pe,
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }            
            
            if( existe ) {
              throw new MareException("El Codigo de configuracion ya existe", UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CAR, "", ErroresDeNegocio.CAR_0013));
            }
            //cdos gPineda inc BELC300024017 10/08/06 -  FIN
          
            UtilidadesLog.debug("*********** Llamando al create de la entidad ParametrosdeCartera");
            ParametrosdeCarteraLocal paramCarteraL = parametrosCarteratLocalH.create(dtoin.getOidPais(),
            dtoin.getGrupoSolicitud(), dtoin.getNivelRiesgo(), codConfUpper, dtoin.getValDiasDeuda(),
            dtoin.getValLineaCredito(), dtoin.getValMontoMaximo(),
            dtoin.getValporcentajeMaximo());

            UtilidadesLog.debug("*********** Seteando fecha desde y fecha hasta");
            paramCarteraL.setFechaDesde(dtoin.getFechaVigenciaDesde());
            paramCarteraL.setFechaHasta(dtoin.getFechaVigenciaHasta());

            if (dtoin.getMontoMaximoPermitido() != null) {
              UtilidadesLog.debug("*********** Seteando Monto maximo permitido");
              paramCarteraL.setMontoMaximoPermitido(new Double(dtoin.getMontoMaximoPermitido().doubleValue()));
            }

            UtilidadesLog.debug("*********** Seteando Numero dias adicionales");
            paramCarteraL.setNumeroDiasAdicionales(dtoin.getNumDiasAdicionales());
            
            UtilidadesLog.debug("EL PORCENTAJE DE VALIDACION ES " + dtoin.getPorcentajeValidacion());

            UtilidadesLog.debug("*********** Seteando Porcentaje validacion");
            paramCarteraL.setPorcentajeValidacion(dtoin.getPorcentajeValidacion());
            UtilidadesLog.debug("*********** Seteando Indicador validacion");
            paramCarteraL.setOidIndicadorValidacion(dtoin.getIndicadorValidacion());

            if((dtoin.getDiasDeudaVenPerm() != null) && !(dtoin.getDiasDeudaVenPerm().equals(""))){
              UtilidadesLog.debug("*********** Seteando Numero dias deuda vencida");
              paramCarteraL.setNumeroDiasDeudaVencida(new Long(dtoin.getDiasDeudaVenPerm().longValue()));
            }

            UtilidadesLog.debug("*********** Seteando Valor porcentaje");
            paramCarteraL.setValorPorcentaje(dtoin.getPorcentajeMaximoPermitido());   
            
            parametrosCarteratLocalH.merge(paramCarteraL);
                                                                
            } catch(PersistenceException e) {
                 sessionContext.setRollbackOnly();
                 throw new MareException(e,
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            } 
        }
        else {
          try {
            UtilidadesLog.debug("*********** Oid: " + dtoin.getOidCodConf());
            ParametrosdeCarteraLocal paramCarteraL = parametrosCarteratLocalH.findByPrimaryKey(dtoin.getOidCodConf());
            paramCarteraL.setFechaDesde(dtoin.getFechaVigenciaDesde());
            paramCarteraL.setFechaHasta(dtoin.getFechaVigenciaHasta());

            if (dtoin.getMontoMaximoPermitido() != null) {
              paramCarteraL.setMontoMaximoPermitido(new Double(dtoin.getMontoMaximoPermitido().doubleValue()));
            }
            else{
              Double monto = null;
              paramCarteraL.setMontoMaximoPermitido(monto);
            }

            paramCarteraL.setNumeroDiasAdicionales(dtoin.getNumDiasAdicionales());
            paramCarteraL.setPorcentajeValidacion(dtoin.getPorcentajeValidacion());
            paramCarteraL.setOidIndicadorValidacion(dtoin.getIndicadorValidacion());
            paramCarteraL.setValorPorcentaje(dtoin.getPorcentajeMaximoPermitido());

            if(dtoin.getDiasDeudaVenPerm() != null){
              paramCarteraL.setNumeroDiasDeudaVencida(new Long(dtoin.getDiasDeudaVenPerm().intValue()));
            }
            else{
              Long numero = null;
              paramCarteraL.setNumeroDiasDeudaVencida(numero);
            }

            paramCarteraL.setIndicadorDeudaVencida(dtoin.getValDiasDeuda());
            paramCarteraL.setIndicadorLineaCredito(dtoin.getValLineaCredito());
            paramCarteraL.setIndicadorMontoMaximo(dtoin.getValMontoMaximo());
            paramCarteraL.setIndicadorPorcentajeMaximo(dtoin.getValporcentajeMaximo());        
            
            parametrosCarteratLocalH.merge(paramCarteraL);
                
            UtilidadesLog.debug("*********** Fin ***********");       
            
            } catch (NoResultException nre) {
                sessionContext.setRollbackOnly();
                throw new MareException(nre,        
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
            } catch (PersistenceException pe) {
                sessionContext.setRollbackOnly();
                throw new MareException(pe,
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONCARParametrizacion.guardarCodigoConf(DTOCodigoConfiguracion):Salida");
    }
    
   /**
    * @throws es.indra.mare.common.exception.MareException
    * @param dtoin
    */
    // Modificado por Sergio Platas - 22/07/2005 - Inc. 19834
    public void guardarAsignacionesCod(DTOAsignaciones dtoin)
        throws MareException {
        UtilidadesLog.info("MONCARParametrizacion.guardarAsignacionesCod(DTOAsignaciones):Entrada");
        /*
        Para cada DTOAsignacionCod (dtoaux) contenido en el dtoin: 
        { 
        Se hace la validacion de Vinculos. Para esto se hace una llamada al metodo 
        findByPrimeryKey de la entidad Subgerencia de Venta, y se obtiene el pais, canal y marca. 
        Utilizando estos valores se hace la llamada la metodo MONValidaciones.validarVinculos. 
        Si se obtiene TRUE como respuesta se contienua con el proceso, en caso contrario se 
        muestra al usuario el mensaje de error "GEN-0204" 
        } 
        FIN 
        */
        
        AsignacionCodigoConfiguracionLocalHome asignacionCodigoConfiguracionLH = 
            this.getAsignacionCodigoConfiguracionLocalHome();
        UtilidadesLog.debug("****** Llamando a parametros auditoria " + dtoin );        
        
        ArrayList arrDTOAsign = dtoin.getAsignaciones();
        UtilidadesLog.debug("    -->> Total Asignaciones =   " + arrDTOAsign.size());
        
        for(int i=0; i < arrDTOAsign.size(); i++ ){
            
            SubGerenciaVentaLocalHome subGerVentaLH = this.getSubGerenciaVentaLocalHome();            
            SubGerenciaVentaLocal subGerVentaL = null;
            try {
                DTOAsignacionCod dtoAsigCodAux =  (DTOAsignacionCod) arrDTOAsign.get(i);
                
                UtilidadesLog.debug("    -->>Asignaciones =     " + dtoAsigCodAux.getOidSgv());
                
                subGerVentaL = subGerVentaLH.findByPrimaryKey(dtoAsigCodAux.getOidSgv());  
                UtilidadesLog.debug("    -->> SubGVTA. =     " + subGerVentaL);
            } catch(NoResultException nre) {
                sessionContext.setRollbackOnly();
                throw new MareException(nre, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch(PersistenceException pex) {
                sessionContext.setRollbackOnly();
                throw new MareException(pex, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
            
            UtilidadesLog.debug("        --->    MONValidacion");
            MONValidacion monValidacion;
            try {
                UtilidadesLog.debug("        --->    create()!");
                monValidacion = getMONValidacionHome().create();
                
                UtilidadesLog.debug("        --->    Realiza la VALIDACION !");
                Boolean valido = monValidacion.validarVinculos(subGerVentaL.getOidPais(),
                        null, subGerVentaL.getOidMarca(),
                        subGerVentaL.getOidCanal(), null, null);
                
                if (!valido.booleanValue()) {
                    UtilidadesLog.debug("        --->    FALLO la VALIDACION !");
                    throw new MareException(null,null,
                        UtilidadesError.
                            armarCodigoError(CodigosError.ERROR_VINCULO_DE_JERARQUIA_NO_VALIDO));
                }
            } catch (CreateException ce) { 
                UtilidadesLog.error("        --->    CreateException");
                throw new MareException(ce,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            
            } catch (RemoteException re) {
                UtilidadesLog.error("        --->    RemoteException");
                throw new MareException(re,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }
        
        /*
        Una vez finalizada la validacion de vinculos para todas las asignaciones recibidas: 
        Para cada DTOAsignacionCod (dtoaux) contenido en el dtoin: 
        //Se obtiene el oid del codigo de configuracion a guardar en la asignacion 
        // Inc.19834
        Se hace un findByPrimaryKey sobre la entidad CAR:ParametrosdeCartera con el oidCodConf en el
        DTOAsginacionCod (parametroCartera)
        Se hace un findByUK sobre la entidad CAR:ParametrosdeCartera con el
        parametrosCartera.pais,parametroCartera.codigoConfiguracion, DTOAsignacionCod.nivelRiesgo y
        DTOAsignacionCod.grupoSolicitud (parametroCarteraAsignacion)
 
        Si dtoaux.oidAsignacion=NULL Entonces 
        Se llama al metodo "create" de la entidad "CAR:AsignacionCodigoConfiguracion" pasandole: 
        (parametroCarteraAsignacion.oid,,NivelRiesgo, GrupoSolicitud, oidSgv,oidRegion,oidZona,
        LCIni, NRIni) 
        Sino 
        Se llama al metodo "findByPrimaryKey" de la entidad "CAR:AsignacionCodigoConfiguracion" 
        Realiza la llamada a todos los metodos "set" de la entidad para transferir los datos del 
        DTOaux a la entidad "CAR:AsignacionCodigoConfiguracion" (En el caso de el oidCodConf se 
        debe usar el parametroCarteraAsignacion.oid) 
        Fin 
        */
        UtilidadesLog.debug("    Terminó la Validación: ejecuta los FINDERS !    ");
        for(int i=0; i < arrDTOAsign.size();i++ ){
            ParametrosdeCarteraLocalHome paramCartAsigLocalH = 
                this.getParametrosdeCarteraLocalHome();
            
            DTOAsignacionCod dtoAsigCodAux =  (DTOAsignacionCod) arrDTOAsign.get(i);
            //Long oidGrupoSolicitud = dtoAsigCodAux.getGrupoSolicitud();
            //Long oidNiveRies = dtoAsigCodAux.getNivelRiesgo();
            //String codigConf = dtoAsigCodAux.getOidCodConf().toString();
            try {
                UtilidadesLog.debug("        --->    dtoAsigCodAux.getOidCodConf(): " + dtoAsigCodAux.getOidCodConf()); 
                ParametrosdeCarteraLocal paramCarteraL = 
                    paramCartAsigLocalH.findByPrimaryKey(dtoAsigCodAux.getOidCodConf());
                UtilidadesLog.debug("        --->    findByPrimaryKey : OK !!");
                    
                UtilidadesLog.debug("        --->    OidPais: " + paramCarteraL.getOidPais());   
                //UtilidadesLog.debug("        --->    GrupoSolicitud: " + dtoAsigCodAux.getGrupoSolicitud()); 
                
                UtilidadesLog.debug("        --->    NivelRiesgo: "+ dtoAsigCodAux.getNivelRiesgo());   
                UtilidadesLog.debug("        --->    CodigoConfiguracion: " + paramCarteraL.getCodigoConfiguracion());   
                    
                ParametrosdeCarteraLocal paramCartAsigLocal = 
                    paramCartAsigLocalH.findByUK(paramCarteraL.getOidPais(),
                                                 dtoAsigCodAux.getGrupoSolicitud(),
                                                 dtoAsigCodAux.getNivelRiesgo(), 
                                                 paramCarteraL.getCodigoConfiguracion());
                UtilidadesLog.debug("        --->    findByUK : OK !!");
                
                /*
                Si dtoaux.oidAsignacion=NULL Entonces 
            Se llama al metodo "create" de la entidad "CAR:AsignacionCodigoConfiguracion" pasandole: 
            (parametroCarteraAsignacion.oid,,NivelRiesgo, GrupoSolicitud, oidSgv,oidRegion,oidZona,
            LCIni, NRIni) 
            Sino 
            Se llama al metodo "findByPrimaryKey" de la entidad "CAR:AsignacionCodigoConfiguracion" 
            Realiza la llamada a todos los metodos "set" de la entidad para transferir los datos del 
            DTOaux a la entidad "CAR:AsignacionCodigoConfiguracion" (En el caso de el oidCodConf se 
            debe usar el parametroCarteraAsignacion.oid) 
            Fin 
                */
                if(dtoAsigCodAux.getOidAsignacion() == null){
                    UtilidadesLog.debug("    -->>>  dtoAsigCodAux.getOidAsignacion() es null ");
                    
                    
                    try{
                        AsignacionCodigoConfiguracionLocal asignacionCodigoConfiguracionL =
                            asignacionCodigoConfiguracionLH.create(dtoAsigCodAux.getOidSgv(),
                                dtoAsigCodAux.getOidRegion(),
                                dtoAsigCodAux.getOidZona(),
                                dtoAsigCodAux.getGrupoSolicitud(),
                                dtoAsigCodAux.getNivelRiesgo(),
                                dtoAsigCodAux.getNRIni(),
                                paramCartAsigLocal.getOid(),
                                new Double(dtoAsigCodAux.getLCIni().doubleValue()));
                          
                        
                    } catch(PersistenceException e) {
                        UtilidadesLog.error("  --->  CreateException de 'AsigCodConfig' ");            
                         sessionContext.setRollbackOnly();
                         throw new MareException(e,
                                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    } 
                } else {
                    UtilidadesLog.debug("    -->>>  dtoAsigCod.getOidAsignacion() NO ES null !!");
                    
                    try {
                        UtilidadesLog.debug("        --->    findByPrimaryKey ");
                        AsignacionCodigoConfiguracionLocal asignacionCodigoConfiguracionL =
                            asignacionCodigoConfiguracionLH.findByPrimaryKey(
                                dtoAsigCodAux.getOidAsignacion());         
                        
                        asignacionCodigoConfiguracionL.setOidSubgerencia(
                            dtoAsigCodAux.getOidSgv());                            
                        UtilidadesLog.debug("        --->    asigna: SubGV");
                        
                        asignacionCodigoConfiguracionL.setOidRegion(
                            dtoAsigCodAux.getOidRegion());                            
                        UtilidadesLog.debug("        --->    asigna: Region");
                        
                        asignacionCodigoConfiguracionL.setOidZona(
                            dtoAsigCodAux.getOidZona());                            
                        UtilidadesLog.debug("        --->    asigna: Zona");
                        
                        asignacionCodigoConfiguracionL.setOidGrupoSolicitud(
                            dtoAsigCodAux.getGrupoSolicitud());                            
                        UtilidadesLog.debug("        --->    asigna: GSolic.");
                        
                        asignacionCodigoConfiguracionL.setOidNivelRiesgo(
                            dtoAsigCodAux.getNivelRiesgo());                            
                        UtilidadesLog.debug("        --->    asigna: NRiesgo");
                        
                        asignacionCodigoConfiguracionL.setOidNivelRiesgoInicial(
                            dtoAsigCodAux.getNRIni());                            
                        UtilidadesLog.debug("        --->    asigna: RInicial");
                        
                        asignacionCodigoConfiguracionL.setOidParametroCartera(
                            paramCartAsigLocal.getOid());
                        UtilidadesLog.debug("        --->    asigna: OID_ParCart");
                        
                        asignacionCodigoConfiguracionL.setLineaCreditoInicial(
                            new Double(dtoAsigCodAux.getLCIni().doubleValue()));
                        UtilidadesLog.debug("        --->    asigna: LCInicial");
                        
                        asignacionCodigoConfiguracionLH.merge(asignacionCodigoConfiguracionL);
                    
                    } catch (NoResultException nre) {
                        UtilidadesLog.error("        --->    FinderException 2!!!!");
                        sessionContext.setRollbackOnly();
                        throw new MareException(nre,        
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                    } catch (PersistenceException pe) {
                        sessionContext.setRollbackOnly();
                        throw new MareException(pe,
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                    }
                }
            
                } catch (NoResultException nre) {
                    sessionContext.setRollbackOnly();
                    throw new MareException(nre,        
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                } catch (PersistenceException pe) {
                    sessionContext.setRollbackOnly();
                    throw new MareException(pe,
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
             
        }   // FIN DEL for()
        
        
        
        UtilidadesLog.info("MONCARParametrizacion.guardarAsignacionesCod(DTOAsignaciones):Salida");
        
        /*  VERSION ANTERIOR!!!!:
         * 
         * Para cada DTOAsignacionCod (dtoaux) contenido en el dtoin:
        Si dtoaux.oidAsignacion=NULL Entonces
        Se llama al metodo "create" de la entidad "CAR:AsignacionCodigoConfiguracion" pasandole:
        (CodConf,NivelRiesgo, GrupoSolicitud, oidSgv,oidRegion,oidZona,LCIni, NRIni)
        Sino
        Se llama al metodo "findByPrimaryKey" de la entidad "CAR:AsignacionCodigoConfiguracion"
        Realiza la llamada a todos los metodos "set" de la entidad para transferir los datos del
        DTOaux a la entidad "CAR:AsignacionCodigoConfiguracion"  Fin
         *
         * 
        AsignacionCodigoConfiguracionLocalHome asignacionCodigoConfiguracionLH = this.getAsignacionCodigoConfiguracionLocalHome();
        UtilidadesLog.info("****** Llamando a parametros auditoria " + dtoin );
        ArrayList arr = dtoin.getAsignaciones();
        
        for (int i = 0; i < arr.size(); i++) {
        
            DTOAsignacionCod dtoAsigCod = (DTOAsignacionCod) arr.get(i);
            UtilidadesLog.info("dtoAsigCod  " + dtoAsigCod);

            //   incidencia BELC300003889  //
            SubGerenciaVentaLocalHome subGerVentaLH = this.getSubGerenciaVentaLocalHome();            
            SubGerenciaVentaLocal subGerVentaL = null;           

            try {
                subGerVentaL = subGerVentaLH.findByPrimaryKey(dtoAsigCod.getOidSgv());                
                UtilidadesLog.info("subGerVentaL" + subGerVentaL);
            } catch (FinderException re) {
                throw new MareException(re,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }

            MONValidacion monValidacion;
            
            try {
                monValidacion = getMONValidacionHome().create();
                
                Boolean valido = monValidacion.validarVinculos(subGerVentaL.getOidPais(),
                        null, subGerVentaL.getOidMarca(),
                        subGerVentaL.getOidCanal(), null, null);
                
                if (valido.booleanValue()) {
                
                    UtilidadesLog.info("oid cod conf: "+dtoAsigCod.getOidCodConf());
                    if (dtoAsigCod.getOidAsignacion() == null) {
                        UtilidadesLog.info(" dtoAsigCod.getOidAsignacion() es null ");
                        try {
                            AsignacionCodigoConfiguracionLocal asignacionCodigoConfiguracionL =
                                    asignacionCodigoConfiguracionLH.create(dtoAsigCod.getOidSgv(),
                                    dtoAsigCod.getOidRegion(),
                                    dtoAsigCod.getOidZona(),
                                    dtoAsigCod.getGrupoSolicitud(),
                                    dtoAsigCod.getNivelRiesgo(),
                                    dtoAsigCod.getNRIni(),
                                    dtoAsigCod.getOidCodConf(),
                                    new Double(dtoAsigCod.getLCIni().doubleValue()));
                    
                          
                        } catch (CreateException e) {
                            sessionContext.setRollbackOnly();
                            throw new MareException(e,
                                UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }
                    } else {
                        try {
                            UtilidadesLog.info("dtoAsigCod " + dtoAsigCod);
                            AsignacionCodigoConfiguracionLocal asignacionCodigoConfiguracionL =
                                asignacionCodigoConfiguracionLH.findByPrimaryKey(dtoAsigCod.getOidAsignacion());         
                            asignacionCodigoConfiguracionL.setOidSubgerencia(dtoAsigCod.getOidSgv());                            
                            asignacionCodigoConfiguracionL.setOidRegion(dtoAsigCod.getOidRegion());                            
                            asignacionCodigoConfiguracionL.setOidZona(dtoAsigCod.getOidZona());                            
                            asignacionCodigoConfiguracionL.setOidGrupoSolicitud(dtoAsigCod.getGrupoSolicitud());                            
                            asignacionCodigoConfiguracionL.setOidNivelRiesgo(dtoAsigCod.getNivelRiesgo());                            
                            asignacionCodigoConfiguracionL.setOidNivelRiesgoInicial(dtoAsigCod.getNRIni());                            
                            asignacionCodigoConfiguracionL.setOidParametroCartera(dtoAsigCod.getOidCodConf());                            
                            asignacionCodigoConfiguracionL.setLineaCreditoInicial(new Double(dtoAsigCod.getLCIni().doubleValue()));
                            
                        } catch (FinderException re) {
                          UtilidadesLog.info("FinderException");
                            throw new MareException(re,
                                UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        }
                    }
                }else{
                    throw new MareException(null,null,
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_VINCULO_DE_JERARQUIA_NO_VALIDO));  
                }
                
            } catch (CreateException ce) { 
                UtilidadesLog.info("CreateException");
                sessionContext.setRollbackOnly();
                throw new MareException(ce,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            } catch (RemoteException re) {
                sessionContext.setRollbackOnly();
                throw new MareException(re,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }
        */
    }


    /**
      fecha modificacion: 01/12/2004
      modificacion segun incidencia 9238.
      autor:mdolce
      Se modifica para poder eliminar las cabeceras y sus detalles
      y a aquellas cabeceras que no poseen detalle
     **/

    public void eliminarAsignaciones(DTOEliminarCodigoConf dtoin) throws MareException {
        UtilidadesLog.info("MONCARParametrizacion.eliminarAsignaciones(DTOEliminarCodigoConf):Entrada");
        ParametrosdeCarteraLocalHome paramCarteraLHome;
		  ParametrosdeCarteraLocal paramCarteraLocal;
		  AsignacionCodigoConfiguracionLocalHome asigCCLHome;
		  AsignacionCodigoConfiguracionLocal asigCCLocal;
		
		  HashSet hmParametros = new HashSet();
      HashSet hsParametros = new HashSet();
      
		  Long[] asignaciones = dtoin.getAsignaciones();
      Long[] codigos      = dtoin.getCodigos();
      for ( int i=0; i<asignaciones.length;i++ )  {
        UtilidadesLog.debug("######LOS OIDS SON " +  asignaciones[i]);
      
      }
   
		try{
			asigCCLHome = this.getAsignacionCodigoConfiguracionLocalHome();
      UtilidadesLog.debug("entro al try");
			
			for ( int i=0; i<asignaciones.length; i++)  {
                UtilidadesLog.debug("los oid a eliminar " + dtoin.getAsignaciones());
				asigCCLocal = asigCCLHome.findByPrimaryKey(asignaciones[i] );
				hmParametros.add(asigCCLocal.getOidParametroCartera() );
                                try{
                                    asigCCLHome.remove(asigCCLocal);
                                } catch (PersistenceException pe) {
                                    sessionContext.setRollbackOnly();
                                    throw new MareException(pe, 
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                                }
			}

      Iterator it = hmParametros.iterator();
      while (it.hasNext()){
         Long oidParam = (Long)it.next();
         UtilidadesLog.debug("oid param es " + oidParam);
         Collection col =  asigCCLHome.findByCodigoConfiguracion(oidParam);

         if (col.isEmpty())  {
            UtilidadesLog.debug("La coleccion es vacia....");
            paramCarteraLHome = this.getParametrosdeCarteraLocalHome();

            try{
               paramCarteraLocal = paramCarteraLHome.findByPrimaryKey(oidParam);
               try{
                    paramCarteraLHome.remove(paramCarteraLocal);	
                } catch (PersistenceException pe) {
                    sessionContext.setRollbackOnly();
                    throw new MareException(pe, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
               
            } catch(NoResultException nre) {
                //no hago nada.
            } catch(PersistenceException pex) {
                sessionContext.setRollbackOnly();
                throw new MareException(pex, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
         }
        
      }

      for ( int i=0; i<codigos.length; i++)  {
         paramCarteraLHome = this.getParametrosdeCarteraLocalHome();

         try{
            paramCarteraLocal = paramCarteraLHome.findByPrimaryKey(codigos[i]); 
            paramCarteraLHome.remove(paramCarteraLocal);	
         } catch(NoResultException nre) {
             //no hago nada.
         } catch(PersistenceException pex) {
             sessionContext.setRollbackOnly();
             throw new MareException(pex, 
             UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
          
      }
		
      } catch(NoResultException nre) {
          sessionContext.setRollbackOnly();
          throw new MareException(nre, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      } catch(PersistenceException pex) {
          sessionContext.setRollbackOnly();
          throw new MareException(pex, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
        UtilidadesLog.info("MONCARParametrizacion.eliminarAsignaciones(DTOEliminarCodigoConf):Salida");
    }
    
    /*Modificado por: Cristian Valenzuela
      Incidencia bloqueante: V_CAR_01
      Fecha: 12/12/2006
      Comentario: Al cargar la pantalla modal se recuperaban
      4700 registros y se caia la aplicacion, ahora se
      carga la lista usando el configurar paginado 
      y recuperando solo los primeros 20 registros */

    public DTOCodigoConfiguracion consultarCodigoConf(DTOOID dtoin)
        throws MareException {
        UtilidadesLog.info("MONCARParametrizacion.consultarCodigoConf(DTOOID):Entrada");
        /*
         * Se hace un findByPrimaryKey con el dtoin.oid sobre la entidad CAR:ParametrosdeCartera y
         * se obtiene la referencia a la entidad.
        Una vez obtenida la referencia, se crea un DTOCodigoConfiguracion y se le asignan
        los datos obtenidos de la entidad.
        Llama al metodo buscarAsignacionesCodigoConf del DAOCAR pasandole el dtoin de entrada,
        y obtiene el RecordSet con las asignaciones para el codigo de configuracion.
        Se asigna el RecordSet obtenido al atributo "asignaciones" del DTOCodigoConfiguracion
        En caso que no se encuentre el entity correspondiente a dtoin.oid se genera
        una excepción con el mensaje: CAR-0003
         * */
        ParametrosdeCarteraLocalHome parametrosCarteratLocalH = this.getParametrosdeCarteraLocalHome();
        AsignacionCodigoConfiguracionLocalHome asignacionCodigoLocalH = this.getAsignacionCodigoConfiguracionLocalHome();
        DTOCodigoConfiguracion dtoCodConf = new DTOCodigoConfiguracion();

        try {
            UtilidadesLog.debug("antes de hacer el finbyprimarykey");
            UtilidadesLog.debug("el oid enviado es " + dtoin.getOid());
            //AsignacionCodigoConfiguracionLocal asignacionCodigoL = asignacionCodigoLocalH.findByPrimaryKey(dtoin.getOid());
            ParametrosdeCarteraLocal paramCarteraL = parametrosCarteratLocalH.findByPrimaryKey(dtoin.getOid());
            dtoCodConf.setCodConf(paramCarteraL.getCodigoConfiguracion());
            dtoCodConf.setFechaVigenciaDesde(paramCarteraL.getFechaDesde());
            dtoCodConf.setFechaVigenciaHasta(paramCarteraL.getFechaHasta());
            dtoCodConf.setValDiasDeuda(paramCarteraL.getIndicadorDeudaVencida()); //verificar con RODO
            dtoCodConf.setValLineaCredito(paramCarteraL.getIndicadorLineaCredito());
            dtoCodConf.setValMontoMaximo(paramCarteraL.getIndicadorMontoMaximo());
            dtoCodConf.setValporcentajeMaximo(paramCarteraL.getIndicadorPorcentajeMaximo());

            if((paramCarteraL.getMontoMaximoPermitido() != null) && !(paramCarteraL.getMontoMaximoPermitido().equals(""))){
               dtoCodConf.setMontoMaximoPermitido(new BigDecimal(paramCarteraL.getMontoMaximoPermitido().doubleValue()));
            }
            dtoCodConf.setNumDiasAdicionales(paramCarteraL.getNumeroDiasAdicionales());
            dtoCodConf.setDiasDeudaVenPerm(  paramCarteraL.getNumeroDiasDeudaVencida()==null?null:new Integer(paramCarteraL.getNumeroDiasDeudaVencida().toString()) );
            dtoCodConf.setOidCodConf(paramCarteraL.getOid());
            dtoCodConf.setGrupoSolicitud(paramCarteraL.getOidGrupoSolicitud());
            dtoCodConf.setIndicadorValidacion(paramCarteraL.getOidIndicadorValidacion());
            dtoCodConf.setNivelRiesgo(paramCarteraL.getOidNivelRiesgo());
            dtoCodConf.setOidPais(paramCarteraL.getOidPais());
            dtoCodConf.setPorcentajeValidacion(paramCarteraL.getPorcentajeValidacion());
            dtoCodConf.setNivelRiesgo(paramCarteraL.getOidNivelRiesgo());
            dtoCodConf.setPorcentajeMaximoPermitido(paramCarteraL.getValorPorcentaje()); // validar con RODO

            /*DAOCAR daoCAR = new DAOCAR(sessionContext.getCallerPrincipal().getName());
            DTOOID dtoOid = new DTOOID();
            dtoOid.setOid(paramCarteraL.getOid());
            dtoOid.setOidIdioma(dtoin.getOidIdioma());
            dtoCodConf.setAsignaciones(daoCAR.buscarAsignacionesCodigoConf(dtoOid));
            UtilidadesLog.debug("asignaciones: "+dtoCodConf.getAsignaciones());*/
         } catch (NoResultException nre) {
             sessionContext.setRollbackOnly();
             throw new MareException(nre,        
                 UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
         } catch (PersistenceException pe) {
             sessionContext.setRollbackOnly();
             throw new MareException(pe,
                 UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
        UtilidadesLog.info("MONCARParametrizacion.consultarCodigoConf(DTOOID):Salida");
        return dtoCodConf;
    }

    public DTOSalida buscarCodigosConf(DTOCriteriosCodigoConf dtoin) throws MareException {
      UtilidadesLog.info("MONCARParametrizacion.buscarCodigosConf(DTOCriteriosCodigoConf):Entrada");
      DAOCAR daoCAR = new DAOCAR(sessionContext.getCallerPrincipal().getName());
      RecordSet rs = new RecordSet();
      rs = daoCAR.buscarCodigoConf(dtoin);

      //if( rs.esVacio() ){
        //UtilidadesLog.debug("************** No hay registros, se lanza la MareException");
        //throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        //throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      //}      

      DTOSalida ds = new DTOSalida();
      ds.setResultado(rs);
      UtilidadesLog.info("MONCARParametrizacion.buscarCodigosConf(DTOCriteriosCodigoConf):Salida");
      return ds;
    }

    public void guardarEjecutivo(DTOEjecutivo dtoin) throws MareException {
    UtilidadesLog.info("MONCARParametrizacion.guardarEjecutivo(DTOEjecutivo):Entrada");
		
    EjecutivosCuentaLocalHome ejCuentaLHome;
		EjecutivosCuentaLocal ejCuentaLocal;
    
		try{
			ejCuentaLHome = this.getEjecutivosCuentaLocalHome();      
      
      if(dtoin.getOidEjecutivo()!= null){
		  UtilidadesLog.debug("***** Traemos en DTOEjecutivo.oidEjecutivo --> " + dtoin.getOidEjecutivo());
      }else{
      UtilidadesLog.debug("***** Traemos en DTOEjecutivo.oidEjecutivo -->  NULL");
      }      
      
                        if(dtoin.getOidEjecutivo()==null || dtoin.getOidEjecutivo().equals(new Long(-1)) ){
				ejCuentaLocal = ejCuentaLHome.create(	dtoin.getOidPais(),
														dtoin.getIDPrincipal());
			}else{
                            try{
				ejCuentaLocal = ejCuentaLHome.findByPrimaryKey(dtoin.getOidEjecutivo());
                                
			    } catch (NoResultException nre) {
                                sessionContext.setRollbackOnly();
                                throw new MareException(nre,        
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                            } catch (PersistenceException pe) {
                                sessionContext.setRollbackOnly();
                                throw new MareException(pe,
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                            }
                                /*
                                 * no debemos grabar el "codigo de ejecutivo de cuenta"
                                 */
                                //ejCuentaLocal.setCodigoEjecutivoCuenta( dtoin.getIDPrincipal() ); inc. DBLG500001043
                                                
                                ejCuentaLocal.setOidPais( dtoin.getOidPais() );
			}
			ejCuentaLocal.setOidJerarquia( dtoin.getJerarquia());
                        
                        ejCuentaLHome.merge(ejCuentaLocal);
			
		    } catch(PersistenceException e) {
                         sessionContext.setRollbackOnly();
                         throw new MareException(e,
                                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    } 
        UtilidadesLog.info("MONCARParametrizacion.guardarEjecutivo(DTOEjecutivo):Salida");
    }

    public DTOSalida buscarEjecutivos(DTOCriteriosEjecutivo dtoin)
        throws MareException {
        UtilidadesLog.info("MONCARParametrizacion.buscarEjecutivos(DTOCriteriosEjecutivo):Entrada");
		DTOSalida dto;
		RecordSet rs;
		
		DAOCAR daoCar = new DAOCAR(sessionContext.getCallerPrincipal().getName());
		rs = daoCar.buscarEjecutivos(dtoin);
		if (rs.esVacio()){
			throw new MareException(null,null,
				UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		} else {
			dto = new DTOSalida();
			dto.setResultado( rs );
		}
		UtilidadesLog.info("MONCARParametrizacion.buscarEjecutivos(DTOCriteriosEjecutivo):Salida");
		return dto;
    }

    public void eliminarEjecutivos(DTOOIDs dtoin) throws MareException {
        UtilidadesLog.info("MONCARParametrizacion.eliminarEjecutivos(DTOOIDs):Entrada");
        EjecutivosCuentaLocalHome ejCuentaLHome;
		EjecutivosCuentaLocal ejCuentaLocal;
		AsignacionEjecutivoCuentaLocalHome asigECLHome;
		AsignacionEjecutivoCuentaLocal asigECLocal;
		
		HashSet hmEjecutivos = new HashSet();
		Long[] oids = dtoin.getOids();

//Se recibe un DTOOIDs que contiene una lista de oid de la entidad CAR:AsignacionEjecutivoCuenta.
//
//Se crear una Colleccion (coleje).
//
//Para cada oid recibido:
//    Se hace un findByPrimaryKey sobre la entidad CAR:AsignacionEjecutivoCuenta
//Se toma el ejecutivo relacionado a la entidad obtenida de CAR:AsignacionEjecutivoCuenta y se guarda en la
//coleccion (coleje) [Se debe evitar agregar oidEjecutivos Repetidos]
//   Se llama al metodo remove de la entidad.
//FIN
//
//Para cada oidEjecutivo en la collecion (coleje):
//      Se llama al metodo findByEjecutivo de la entidad CAR:AsignacionEjecutivoCuenta
//     Si esta llamada retorna una coleccion vacia: (el ejecutivo no esta asignado)
//            Se hace una llamada al findByPrimaryKey de la entidad CAR:EjecutviosCuenta
//            Si se obtiene un entity se ejecuta el metodo remove
//            Sino se continua con  el proximo oid ejecutivo
//     Sino se continua con  el proximo oid ejecutivo
//     FIN
//FIN

		try{
			asigECLHome = this.getAsignacionEjecutivoCuentaLocalHome();
			
			for ( int i=0; i<oids.length; i++)  {
				asigECLocal = asigECLHome.findByPrimaryKey( oids[i] );
				hmEjecutivos.add( asigECLocal.getOidEjecutivoCuenta() );
                                try{
                                    asigECLHome.remove(asigECLocal);
                                } catch (PersistenceException pe) {
                                    sessionContext.setRollbackOnly();
                                    throw new MareException(pe, 
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                                }
			}

            Iterator it = hmEjecutivos.iterator();
            while (it.hasNext()){	
                Long oidEje = (Long)it.next();
                Collection col =  asigECLHome.findByEjecutivo(oidEje);

                if (col.isEmpty())  {
                    UtilidadesLog.debug("La coleccion es vacia....");
                    ejCuentaLHome = this.getEjecutivosCuentaLocalHome();

                    try{
                        ejCuentaLocal = ejCuentaLHome.findByPrimaryKey(oidEje);
                        try{
                            ejCuentaLHome.remove(ejCuentaLocal);	
                        } catch (PersistenceException pe) {
                            sessionContext.setRollbackOnly();
                            throw new MareException(pe, 
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                        }
                     } catch(NoResultException nre) {
                         //no hago nada.
                     } catch(PersistenceException pex) {
                         sessionContext.setRollbackOnly();
                         throw new MareException(pex, 
                         UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                     }
                }
            }
			
         } catch (NoResultException nre) {
             sessionContext.setRollbackOnly();
             throw new MareException(nre,        
                 UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
         } catch (PersistenceException pe) {
             sessionContext.setRollbackOnly();
             throw new MareException(pe,
                 UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }	
        UtilidadesLog.info("MONCARParametrizacion.eliminarEjecutivos(DTOOIDs):Salida");
    }

    public DTOEjecutivo consultaEjecutivo(DTOOID dtoin)
        throws MareException {
        UtilidadesLog.info("MONCARParametrizacion.consultaEjecutivo(DTOOID):Salida");
		EjecutivosCuentaLocalHome ejLocalHome;
		EjecutivosCuentaLocal ejLocal;
		RecordSet rs = new RecordSet();

		DTOEjecutivo dtoEjecutivo = new DTOEjecutivo();
		try{
			ejLocalHome = this.getEjecutivosCuentaLocalHome();
			ejLocal = ejLocalHome.findByPrimaryKey( dtoin.getOid() );

			dtoEjecutivo.setOidEjecutivo(  ejLocal.getOid() );
			dtoEjecutivo.setIDPrincipal( ejLocal.getCodigoEjecutivoCuenta() );
			dtoEjecutivo.setJerarquia( ejLocal.getOidJerarquia() );
                } catch (NoResultException nre) {
                    sessionContext.setRollbackOnly();
                    throw new MareException(nre,        
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                } catch (PersistenceException pe) {
                    sessionContext.setRollbackOnly();
                    throw new MareException(pe,
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }

		DAOCAR daoCAR = new DAOCAR(sessionContext.getCallerPrincipal().getName());
		rs = daoCAR.buscarAsignacionesEjecutivo( dtoin );
		dtoEjecutivo.setAsignaciones( rs );		
		UtilidadesLog.info("MONCARParametrizacion.consultaEjecutivo(DTOOID):Salida");
        return dtoEjecutivo;
    }

    public void guardarAsignacionesEjecutivo(DTOAsignaciones dtoin)
        throws MareException {
        UtilidadesLog.info("MONCARParametrizacion.guardarAsignacionesEjecutivo(DTOAsignaciones):Entrada");
		ArrayList asignaciones = dtoin.getAsignaciones();
		DTOAsignacionesEjecutivo dtoAEjecutivo;
		AsignacionEjecutivoCuentaLocalHome asigECLHome;
		AsignacionEjecutivoCuentaLocal asigECLocal;

		try{
			if (asignaciones!=null){
				asigECLHome = this.getAsignacionEjecutivoCuentaLocalHome();
				
				for (int i=0; i < asignaciones.size();i++){
					dtoAEjecutivo = (DTOAsignacionesEjecutivo) asignaciones.get(i);

					if (dtoAEjecutivo.getOidAsignacion()==null){
						asigECLocal = asigECLHome.create(	dtoAEjecutivo.getOidNivelRiesgo(),
															dtoAEjecutivo.getOidSgv(),
															dtoAEjecutivo.getOidRegion(),
															dtoAEjecutivo.getOidZona(),
															dtoAEjecutivo.getOidEjecutivo());
					}else{
                                            try{
						asigECLocal = asigECLHome.findByPrimaryKey(dtoAEjecutivo.getOidAsignacion());
						asigECLocal.setOidEjecutivoCuenta( dtoAEjecutivo.getOidEjecutivo() );
						asigECLocal.setOidNivelRiesgo( dtoAEjecutivo.getOidNivelRiesgo() );
						asigECLocal.setOidRegion( dtoAEjecutivo.getOidRegion() );
						asigECLocal.setOidSubgerencia( dtoAEjecutivo.getOidSgv() );
						asigECLocal.setOidZona( dtoAEjecutivo.getOidZona() );
                                                
					        asigECLHome.merge(asigECLocal);
                                                
					    } catch (NoResultException nre) {
                                                sessionContext.setRollbackOnly();
                                                throw new MareException(nre,        
                                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                                            } catch (PersistenceException pe) {
                                                sessionContext.setRollbackOnly();
                                                throw new MareException(pe,
                                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                                            }
					}
				}
			}
			
		    } catch(PersistenceException e) {
                         sessionContext.setRollbackOnly();
                         throw new MareException(e,
                                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    } 
        UtilidadesLog.info("MONCARParametrizacion.guardarAsignacionesEjecutivo(DTOAsignaciones):Salida");
    }

    public DTOSalida obtenerJerarquias(DTOBelcorp dtoin)
        throws MareException {
        UtilidadesLog.info("MONCARParametrizacion.obtenerJerarquias(DTOBelcorp):Entrada");
		DTOSalida dto = new DTOSalida();
		RecordSet rs = new RecordSet();
		
		DAOCAR daoCar = new DAOCAR(sessionContext.getCallerPrincipal().getName());
		try{
			rs = daoCar.obtenerJerarquias(dtoin);
		}catch(Exception ex){
        UtilidadesLog.error(ex);
		}		

		dto.setResultado( rs );
		UtilidadesLog.info("MONCARParametrizacion.obtenerJerarquias(DTOBelcorp):Salida");
		return dto;
    }

    public DTOSalida obtenerEjecutivos(DTOBelcorp dtoin) throws MareException {
      UtilidadesLog.info("MONCARParametrizacion.obtenerEjecutivos(DTOBelcorp):Entrada");
      DTOSalida dto = new DTOSalida();
      RecordSet rs = new RecordSet();		
      DAOCAR daoCar = new DAOCAR(sessionContext.getCallerPrincipal().getName());

      try{
        rs = daoCar.obtenerEjecutivos(dtoin);
      }
      catch(Exception ex){
        UtilidadesLog.error(ex);
      }

      dto.setResultado( rs );		
      UtilidadesLog.info("MONCARParametrizacion.obtenerEjecutivos(DTOBelcorp):Salida");
      return dto;
    }

    public void guardarGrupoSolicitud(DTOGrupoSolicitud grupoSol)
        throws MareException {
        UtilidadesLog.info("MONCARParametrizacion.guardarGrupoSolicitud(DTOGrupoSolicitud):Entrada");
		DTOGrupoSolicitud dtoGSol = new DTOGrupoSolicitud();
		GrupoSolicitudLocalHome grupoSolicitudHome = this.getGrupoSolicitudLocalHome();
		
		GrupoSolicitudLocal grupoSolicitudLocal = null;
		Long oid = grupoSol.getOidGrupoSol();
		UtilidadesLog.debug("valor de entrada" + grupoSol.getOidGrupoSol().toString());

		try{		
			if(oid.equals(new Long(-1))){
				//Inserta
				UtilidadesLog.debug("inserta");
				grupoSolicitudLocal = grupoSolicitudHome.create(new Long(-1));
				grupoSolicitudLocal.setCodigoGrupoSolicitud(grupoSol.getCodGrupoSolicitud().toUpperCase());
				oid = grupoSolicitudLocal.getOid();
				
			}else{
				UtilidadesLog.debug("es modificacion");
                                try{
                                    grupoSolicitudLocal = grupoSolicitudHome.findByPrimaryKey(oid);
                                    grupoSolicitudLocal.setCodigoGrupoSolicitud(grupoSol.getCodGrupoSolicitud());
                                    
                                } catch (NoResultException nre) {
                                    sessionContext.setRollbackOnly();
                                    throw new MareException(nre,        
                                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                                } catch (PersistenceException pe) {
                                    sessionContext.setRollbackOnly();
                                    throw new MareException(pe,
                                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                                }
			}
                        
		        grupoSolicitudHome.merge(grupoSolicitudLocal);

			dtoGSol.setOidGrupoSol( grupoSolicitudLocal.getOid() );

		    } catch(PersistenceException e) {
                         sessionContext.setRollbackOnly();
                         throw new MareException(e,
                                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    } 

		try{
			UtilidadesLog.debug("El dtoGSol " + dtoGSol.toString());
			UtilidadesLog.debug("El grupoSol " + grupoSol.toString());			
			dtoGSol.setTiposSolicitud(grupoSol.getTiposSolicitud());
			actualizarTiposSolicitud(dtoGSol);
			actualizarDescripcion(grupoSol.getAttriTraducible(),oid);
		}catch(MareException me){
			sessionContext.setRollbackOnly();
            UtilidadesLog.error(me);
			throw me;
		}
        UtilidadesLog.info("MONCARParametrizacion.guardarGrupoSolicitud(DTOGrupoSolicitud):Salida");
    }

    private MONValidacionHome getMONValidacionHome() throws MareException {
        MONValidacionHome localHome = (MONValidacionHome) UtilidadesEJB.getHome("MONValidacion",
                MONValidacionHome.class);

        return localHome;
    }

	/**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       28/09/2004
	 * @version     1.0
	 * @autor       Maximiliano Dello Russo
	 * Descripcion: 
	 */
	public DTOSalida obtenerCodigosAprobacion(DTOBelcorp dtoin) throws MareException {
        UtilidadesLog.info("MONCARParametrizacion.obtenerCodigosAprobacion(DTOBelcorp):Entrada");
		// Este metodo llama al DAOCAR.obtenerCodigosAprobacion pasandole como parametro el dtoin. 
		DAOCAR dao = new DAOCAR(sessionContext.getCallerPrincipal().getName());
		RecordSet rs = dao.obtenerCodigosAprobacion(dtoin);
		// Con el RecordSet que recibe crea un DTOSalida que es retornado por el método. 
		DTOSalida dtoOut = new DTOSalida(rs);
		// Si se recibe una excepcion, esta no lanza hacia el metodo que realizo la llamada. 
        UtilidadesLog.info("MONCARParametrizacion.obtenerCodigosAprobacion(DTOBelcorp):Salida");
		return dtoOut;
	}

	/**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       28/09/2004
	 * @version     1.0
	 * @autor       Maximiliano Dello Russo
	 * Descripcion: 
	 */
	public DTOSalida obtenerEstatusPedidos(DTOBelcorp dtoin) throws MareException {
        UtilidadesLog.info("MONCARParametrizacion.obtenerEstatusPedidos(DTOBelcorp):Entrada");
		// Este metodo llama al DAOCAR.obtenerEstatusCredito pasandole como parametro el dtoin. 
		DAOCAR dao = new DAOCAR(sessionContext.getCallerPrincipal().getName());
		RecordSet rs = dao.obtenerEstatusCredito(dtoin);
		// Con el RecordSet que recibe crea un DTOSalida que es retornado por el método. 
		DTOSalida dtoOut = new DTOSalida(rs);
		// Si se recibe una excepcion, esta no lanza hacia el metodo que realizo la llamada. 
        UtilidadesLog.info("MONCARParametrizacion.obtenerEstatusPedidos(DTOBelcorp):Salida");
		return dtoOut;
	}

	public DTOUsuarioJerarquia obtenerJerarquiaUsuario(DTOUsuarioJerarquia dtoin) throws MareException {
        UtilidadesLog.info("MONCARParametrizacion.obtenerJerarquiaUsuario(DTOUsuarioJerarquia):Entrada");
		// Este metodo llama al DAOCAR.obtenerJerarquiaUsuario pasandole como parametro el dtoin.usuario y dtoin.Pais 
		DAOCAR dao = new DAOCAR(sessionContext.getCallerPrincipal().getName());
		DTOUsuarioJerarquia dtoJerarquia = dao.obtenerJerarquiaUsuario(dtoin.getUsuario(), dtoin.getOidPais());
		// Se retorna el DTOUsuarioJerarquia obtenido por el DAOCAR. 
		// Si se recibe una excepcion, esta lo lanza hacia el metodo que realizo la llamada. 
        UtilidadesLog.info("MONCARParametrizacion.obtenerJerarquiaUsuario(DTOUsuarioJerarquia):Salida");
		return dtoJerarquia;
	}

    public DTOSalida obtenerGruposSolicitud(DTOOID dtoin) throws MareException {
       UtilidadesLog.info("MONCARParametrizacion.obtenerGruposSolicitud(DTOOID):Entrada");
       /*
        Este metodo llama al DAOCAR.obtenerGruposSolicitud pasandole como parametro
        dto.getIdioma y dto.getOID.
        Con el RecordSet que recibe crea un DTOSalida que es retornado por el método.
        Si se recibe una excepcion, esta no lanza hacia el metodo que realizo la llamada.
        */
        DAOCAR daoCAR = new DAOCAR(sessionContext.getCallerPrincipal().getName());
        RecordSet rsGrupoSolicitud = daoCAR.obtenerGruposSolicitud(dtoin.getOidIdioma(),
                dtoin.getOid());
        DTOSalida ds = new DTOSalida();
        ds.setResultado(rsGrupoSolicitud);
        UtilidadesLog.info("MONCARParametrizacion.obtenerGruposSolicitud(DTOOID):Salida");
        return ds;
    }
/*
    Agregado por: Cristian Valenzuela
    Incidencia bloqueante: V_CAR_01
    Fecha: 12/12/2006
    Comentario: Al cargar la pantalla modal se recuperaban
    4700 registros y se caia la aplicacion, ahora se
    carga la lista usando el configurar paginado 
    y recuperando solo los primeros 20 registros
*/
  public DTOSalida buscarAsignacionesCodigoConf(DTOOID dtoin) throws MareException {
    UtilidadesLog.info("MONCARParametrizacion.buscarAsignacionesCodigoConf(DTOOID):Entrada");
    DTOSalida dtoSalida = new DTOSalida();
    DAOCAR daoCAR = new DAOCAR(sessionContext.getCallerPrincipal().getName());     
    dtoSalida.setResultado(daoCAR.buscarAsignacionesCodigoConf(dtoin));            
    UtilidadesLog.info("MONCARParametrizacion.buscarAsignacionesCodigoConf(DTOOID):Salida");        
    return dtoSalida; 
  }


    private AsignacionEjecutivoCuentaLocalHome getAsignacionEjecutivoCuentaLocalHome() 
      {
          return new AsignacionEjecutivoCuentaLocalHome();
      }

      private AsignacionCodigoConfiguracionLocalHome getAsignacionCodigoConfiguracionLocalHome() 
      {
          return new AsignacionCodigoConfiguracionLocalHome();
      }

      private EjecutivosCuentaLocalHome getEjecutivosCuentaLocalHome() 
      {
          return new EjecutivosCuentaLocalHome();
      }

      private GrupoSolicitudLocalHome getGrupoSolicitudLocalHome() 
      {
          return new GrupoSolicitudLocalHome();
      }

      private ParametrosdeCarteraLocalHome getParametrosdeCarteraLocalHome() 
      {
          return new ParametrosdeCarteraLocalHome();
      }

      private SubGerenciaVentaLocalHome getSubGerenciaVentaLocalHome() 
      {
          return new SubGerenciaVentaLocalHome();
      }
      
     private Entidadi18nLocalHome getEntidadi18nLocalHome() 
      {
          return new Entidadi18nLocalHome();
      }
}
