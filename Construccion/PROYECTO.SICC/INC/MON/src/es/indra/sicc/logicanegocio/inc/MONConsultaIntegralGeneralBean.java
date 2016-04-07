package es.indra.sicc.logicanegocio.inc;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.inc.DTOCabeceraConsultaIntegral;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.entidades.mae.ClienteUnidadAdministrativaLocalHome;
import es.indra.sicc.entidades.mae.ClienteUnidadAdministrativaLocal;
import es.indra.sicc.entidades.zon.TerritorioAdministrativoLocalHome;
import es.indra.sicc.entidades.zon.TerritorioAdministrativoLocal;
import es.indra.sicc.entidades.zon.SeccionLocalHome;
import es.indra.sicc.entidades.zon.SeccionLocal;
import es.indra.sicc.entidades.zon.ZonaLocalHome;
import es.indra.sicc.entidades.zon.ZonaLocal;
import es.indra.sicc.entidades.zon.RegionLocalHome;
import es.indra.sicc.entidades.zon.RegionLocal;

import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONConsultaIntegralGeneralBean implements SessionBean {
    private SessionContext sessionContext;
    
    public void ejbCreate()  {   }
    public void ejbActivate()   {   }
    public void ejbPassivate()   {   }
    public void ejbRemove()   {   }

    public void setSessionContext(SessionContext ctx)  {
        this.sessionContext = ctx;
    }

   /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       25/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */

	public DTOCabeceraConsultaIntegral 
        obtenerDatosClienteConcurso(DTOCabeceraConsultaIntegral dto) 
		throws MareException{       
		UtilidadesLog.info("MONConsultaIntegralGeneralBean.obtenerDatos" + 
        "ClienteConcurso(DTOCabeceraConsultaIntegral dto): Entrada");		
		DAOConsultaIntegralGeneral dao = new DAOConsultaIntegralGeneral();

		if(dto.getOidCliente()==null && dto.getCodigoCliente()!=null) {
			dao.obtenerDatosCliente(dto);
		}

		if(dto.getOidConcurso()==null && dto.getNumeroConcurso()!=null) {
			dao.obtenerDatosConcurso(dto);
		}

		UtilidadesLog.info("MONConsultaIntegralGeneralBean." + 
        "obtenerDatosClienteConcurso(DTOCabeceraConsultaIntegral dto): Salida");        
		return dto;
	}

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       25/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    * Modificado:  13/12/2005
    * Detalle:     Incidencia 22076 (Cristian Valenzuela)
    * [1] modificaciones por performance
    */

	public DTOSalida 
        obtenerConcursosBusquedaGeneral(DTOCabeceraConsultaIntegral dto) 
		throws MareException{       
		UtilidadesLog.info("MONConsultaIntegralGeneralBean.obtenerConcursos"+
        "BusquedaGeneral(DTOCabeceraConsultaIntegral dto): Entrada");		
		DAOConsultaIntegralGeneral dao = new DAOConsultaIntegralGeneral();
        
        if(dto.getNumeroConcurso()!=null) {
            dao.obtenerDatosConcurso(dto);    
        }
		
		DTOSalida dtoSalida = dao.obtenerConcursosBusquedaGeneral_perf(dto);//[1]obtenerConcursosBusquedaGeneral(dto);		
        
		UtilidadesLog.info("MONConsultaIntegralGeneralBean.obtenerConcursos"+
        "BusquedaGeneral(DTOCabeceraConsultaIntegral dto): Salida");        
		return dtoSalida;
	}

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       25/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */

	public DTOSalida 
        consultarDetallePremiosProcesadosGral(DTOCabeceraConsultaIntegral dto) 
		throws MareException{       
		UtilidadesLog.info("MONConsultaIntegralGeneralBean.consultarDetalle"+
        "PremiosProcesadosGral(DTOCabeceraConsultaIntegral dto): Entrada");		
		DAOConsultaIntegralGeneral dao = new DAOConsultaIntegralGeneral();
		DTOSalida dtoSalida = new DTOSalida();
		RecordSet rs = dao.consultarDetallePremiosProcesadosGral(dto);		
		dtoSalida.setResultado(rs);
		UtilidadesLog.info("MONConsultaIntegralGeneralBean.consultarDetalle"+
        "PremiosProcesadosGral(DTOCabeceraConsultaIntegral dto): Salida");        
		return dtoSalida;
	}
  
  /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       3/4/2006
    * @version     1.0
    * @autor       Cristian Valenzuela
    */

  public DTOOIDs recuperarValoresUA(DTOOID dtoe) throws MareException {   
    UtilidadesLog.info("MONConsultaIntegralGeneralBean.recuperarValoresUA"+
    "(DTOOID dtoe): Entrada");		
    
    DTOOIDs dto = new DTOOIDs();
    Long[] oids = new Long[3];
       
    try {    
      UtilidadesLog.debug("** 1 **");      
      ClienteUnidadAdministrativaLocalHome cualh = this.getClienteUnidadAdministrativaLocalHome();        
      ClienteUnidadAdministrativaLocal cual = cualh.findByPrimaryKey(dtoe.getOid());      
      UtilidadesLog.debug("** 2 **");      
      TerritorioAdministrativoLocalHome talh = this.getTerritorioAdministrativoLocalHome();
      TerritorioAdministrativoLocal tal = talh.findByPrimaryKey(cual.getZtad_oid_terr_admi());      
      UtilidadesLog.debug("** 3 **");      
      SeccionLocalHome slh = this.getSeccionLocalHome();
      SeccionLocal sl = slh.findByPrimaryKey(tal.getOidSeccion());
      Long oidSeccion = sl.getOid();
      UtilidadesLog.debug("** oidSeccion: " + oidSeccion);      
      ZonaLocalHome zlh = this.getZonaLocalHome();
      ZonaLocal zl = zlh.findByPrimaryKey(sl.getOidZona());      
      Long oidZona = zl.getOid();
      UtilidadesLog.debug("** oidZona: " + oidZona);      
      RegionLocalHome rlh = this.getRegionLocalHome();
      RegionLocal rl = rlh.findByPrimaryKey(zl.getOidRegion());      
      Long oidRegion = rl.getOid();
      UtilidadesLog.debug("** oidRegion: " + oidRegion);
      
      oids[0] = oidSeccion;
      oids[1] = oidZona;
      oids[2] = oidRegion;
      
      dto.setOids(oids);     
    
      } catch (NoResultException nre) {
          UtilidadesLog.error(nre);
      } catch (PersistenceException ce) {
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }
      
  
    UtilidadesLog.info("MONConsultaIntegralGeneralBean.recuperarValoresUA"+
    "(DTOOID dtoe): Salida");	
    return dto;
  }
  
  // vbongiov -- INC 014 -- 20/10/2008
  public DTOSalida consultarDetallePremiosAsociadosNivel(DTOCabeceraConsultaIntegral dtoe) throws MareException
    {
        UtilidadesLog.info("MONConsultaIntegralGeneralBean.consultarDetallePremiosAsociadosNivel(DTOCabeceraConsultaIntegral dto): Entrada");
        DAOConsultaIntegralGeneral dao = new DAOConsultaIntegralGeneral();
        DTOSalida dtoSalida = new DTOSalida();
        es.indra.mare.common.mii.services.jdbcservice.RecordSet rs = dao.consultarDetallePremiosAsociadosNivel(dtoe);
        dtoSalida.setResultado(rs);
        UtilidadesLog.info("MONConsultaIntegralGeneralBean.consultarDetallePremiosAsociadosNivel(DTOCabeceraConsultaIntegral dto): Salida");
        return dtoSalida;
    }
  
  private ClienteUnidadAdministrativaLocalHome getClienteUnidadAdministrativaLocalHome(){
    return new ClienteUnidadAdministrativaLocalHome();
  }

  private TerritorioAdministrativoLocalHome getTerritorioAdministrativoLocalHome(){
    return new TerritorioAdministrativoLocalHome();
  }

  private SeccionLocalHome getSeccionLocalHome() {
    return new SeccionLocalHome();
  }

  private ZonaLocalHome getZonaLocalHome() {
    return new ZonaLocalHome();
  }

  private RegionLocalHome getRegionLocalHome() {
    return new RegionLocalHome();
  }   
}
