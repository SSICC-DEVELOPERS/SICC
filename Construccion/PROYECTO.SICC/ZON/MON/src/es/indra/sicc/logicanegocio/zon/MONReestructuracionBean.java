package es.indra.sicc.logicanegocio.zon;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.zon.DTOLISTUniNSE;
import es.indra.sicc.dtos.zon.DTOUniNSE;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.entidades.zon.TerritorioLocal;
import es.indra.sicc.entidades.zon.TerritorioLocalHome;
import es.indra.sicc.logicanegocio.mae.IMaestroClientes;
import es.indra.sicc.logicanegocio.mae.MONClientes;
import es.indra.sicc.logicanegocio.mae.MONClientesHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.MAEEjbLocators;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.ZONEjbLocators;
import es.indra.sicc.util.DTOOID;

import java.rmi.RemoteException;

import java.sql.Date;

import java.util.ArrayList;
import java.util.Collection;

import java.util.HashMap;
import java.util.Iterator;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.mae.*;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONReestructuracionBean implements SessionBean {
    private SessionContext ctx;

    public void setSessionContext(SessionContext ctx) {  this.ctx = ctx; }

    public void ejbCreate() { }
    public void ejbActivate() { }
    public void ejbPassivate() {  }
    public void ejbRemove() {  }

    public void PruebaDAOZONA() throws MareException {
        DAOZON d = new DAOZON();

        try {
            ArrayList aList = d.obtenerSeccionesdeTerritorio(new Long(1));
            UtilidadesLog.debug(aList.toString());
        } catch (Exception ex) {
            UtilidadesLog.debug(ex);
        }
    }

	/*
	 * 11/07/2005 - rgiorgi: inc. 19559
	 * */
	private void asignarNSETerritorio(Long codPais, Long codMarca, Long codCanal, 
									Long codTerritorio) throws MareException {
                  
        UtilidadesLog.info("MONReestructuracionBean.asignarNSETerritorio(Long codPais, Long codMarca, Long codCanal, Long codTerritorio): Entrada");                  

        String codigoError = "";
        Boolean paisTieneUG = null;
        MONUnidadesGeograficasHome localHome = null;
        MONUnidadesGeograficas monUG = null;
        MONUnidadesAdministrativasHome localHomeUA = null;
        MONUnidadesAdministrativas monUA = null;
        TerritorioLocalHome localHomeT = null;
        TerritorioLocal entityT = null;

        // 1. Chequea la existencia de UG para el pais.
        try {
            localHome = ZONEjbLocators.getMONUnidadesGeograficasHome();
            monUG = localHome.create();
            paisTieneUG = monUG.paisTieneUG(codPais);
        } catch (MareException e) {
            UtilidadesLog.error("MareException - MONUNidadesGeograficas");
            throw e;
        } catch (RemoteException e1) {
            UtilidadesLog.error("RemoteException - MONUnidadesGeograficas");
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e1, UtilidadesError.armarCodigoError(codigoError));
        } catch (CreateException e2) {
            UtilidadesLog.error("CreateException - MONUnidadesGeograficas");
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e2, UtilidadesError.armarCodigoError(codigoError));
        }

        // 2. Si existe un pais, sigue adelante. Si no, levanta un MareException.
        if (paisTieneUG.booleanValue() == true) {
            // Obtiene una instacia de MONUnidadesAdministrativas
            try {
                localHomeUA = ZONEjbLocators.getMONUnidadesAdministrativasHome();
                monUA = localHomeUA.create();

                // 4. Llama a generaUATerritorio de MONUnidadAdministrativa. 
                // Devuelve un DTOUnidadAdministrativia.
                DTOUnidadAdministrativa dtoUA = 
					monUA.generaUATerritorio(codPais, codMarca, codCanal, 
														codTerritorio, null);

                // 6. Llama a calcularModaNSEConsultoras de MONClientes
                String moda = calcularModaNSEConsultoras(dtoUA);
                TerritorioLocal terr;

                // 8. Llama al método findByPaisTerritorio de la Entidad Territorio.
                UtilidadesLog.debug("8. Llama al método findByPaisTerritorio de la Entidad Territorio");
                localHomeT = this.getTerritorioLocalHome();

                Collection col = null;
                try {
                    terr = localHomeT.findByPrimaryKey(codTerritorio);
                } catch (NoResultException ex) {
                    UtilidadesLog.error("FinderException");
                    codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                    throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                // 10. Actualiza NSE3 con el valor de la moda obtenido antes.
                UtilidadesLog.debug("10. Actualiza NSE3 con el valor de la moda obtenido antes");
                terr.setNse3(moda);
                
                localHomeT.merge(terr);

                //11. Llama a método calcularNSE de MONUnidadesGeograficas.
                UtilidadesLog.debug("11. Llama a método calcularNSE de MONUnidadesGeograficas.");
                monUG.calcularNSE(codPais, codTerritorio);

                //12. Llama a método calcularNSE de MONUnidadesAdministrativas.
                UtilidadesLog.debug("************ 12. Llama a método calcularNSE de MONUnidadesAdministrativas. **********");
                UtilidadesLog.debug("Valor de dtoUA: " + dtoUA.toString());
                monUA.calcularNSE(dtoUA);
              
                UtilidadesLog.info("MONReestructuracionBean.asignarNSETerritorio(Long codPais, Long codMarca, Long codCanal, Long codTerritorio): Salida");
          
            } catch (MareException e) {
				//Si el error se produce porque el metodo calcularModaNSEConsultoras
				//retorna vacio en la consulta, entonces no devolvemos la excpetion
				//inc. 775.
                int error = Integer.parseInt(ConstantesSEG.MODULO_MAE + es.indra.sicc.logicanegocio.mae.ErroresDeNegocio.UNID_ADM_SIN_CONSULTORAS);

                if (e.getCode() != error) {
                    throw e;
                }
            } catch (RemoteException e1) {
                codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(e1, UtilidadesError.armarCodigoError(codigoError));
            } catch (CreateException e2) {
                UtilidadesLog.info("MONReestructuracionBean.asignarNSETerritorio(Long codPais, Long codMarca, Long codCanal, Long codTerritorio): Salida");
                codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
                throw new MareException(e2, UtilidadesError.armarCodigoError(codigoError));
            }
        } else if (paisTieneUG.booleanValue() == false) {
            UtilidadesLog.info("MONReestructuracionBean.asignarNSETerritorio(Long codPais, Long codMarca, Long codCanal, Long codTerritorio): Salida");
            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.PAIS_SIN_UNIDADES_GEOGRAFICAS));
        }
	}
	
	/*
	 * 11/07/2005 - rgiorgi: inc. 19559
	 * */	
    public void asignarNSE(Long codPais, Long codMarca, Long codCanal, 
		Long codTerritorio, Long codUA, Integer nivelUA) throws MareException {
    
    UtilidadesLog.info("MONReestructuracionBean.asignarNSE(Long codPais, Long codMarca, Long codCanal, Long codTerritorio, Long codUA, Integer nivelUA): Entrada");

		if (codTerritorio != null ){
			//Tengo un territorio particular, uso ese.
            UtilidadesLog.debug("codTerritorio: " + codTerritorio);
			asignarNSETerritorio(codPais, codMarca, codCanal, codTerritorio);
      UtilidadesLog.info("MONReestructuracionBean.asignarNSE(Long codPais, Long codMarca, Long codCanal, Long codTerritorio, Long codUA, Integer nivelUA): Salida");
		} else {
			//Debo obtener todos los territorios a partir de la UA obtenida, y
			//llamar N veces como territorios tenga como hojas.
			if (codUA!=null && nivelUA!=null){
				DAOZON daoZON = new DAOZON();
		
				// Generar UA Territorio
				//los que tienen nivel 5 son los que toma: territorio
				ArrayList territorios = new ArrayList();
        DTOLISTUniNSE rsUAsInferioresTerr = null;
        DTOUniNSE dtoUniNSETerr = null;
        DTOLISTUniNSE rsUAsInferioresSecc = null;
        DTOUniNSE dtoUniNSESecc = null;
        DTOLISTUniNSE rsUAsInferioresZona = null;
        DTOUniNSE dtoUniNSEZona = null;
        DTOLISTUniNSE rsUAsInferioresRegion = null;
        DTOUniNSE dtoUniNSERegion = null;
		
				//  Obtener UAs inferiores
				//  valores: 
				//	1 - SVG, 2 - Region, 3 - Zona, 4 - Seccion			
        if(nivelUA.intValue()==4) {
            rsUAsInferioresTerr = daoZON.obtenerUAinferioresUA(codUA, nivelUA);
            UtilidadesLog.info("rsUAsInferioresTerr: " + rsUAsInferioresTerr);
            
            if(rsUAsInferioresTerr.getArrayDTOUniNSE() != null){
                for (Iterator itUAsInferioresTerr= rsUAsInferioresTerr.getArrayDTOUniNSE().iterator(); itUAsInferioresTerr.hasNext();){
                    dtoUniNSETerr = (DTOUniNSE) itUAsInferioresTerr.next();
                    territorios.add(dtoUniNSETerr.getOidUni());
                }
            }
            
            UtilidadesLog.info("Territorio: " + territorios);
            
        } else if (nivelUA.intValue()==3) {
            rsUAsInferioresSecc = daoZON.obtenerUAinferioresUA(codUA, nivelUA);
            UtilidadesLog.info("rsUAsInferioresSecc: " + rsUAsInferioresSecc);
            
            if(rsUAsInferioresSecc.getArrayDTOUniNSE() != null){
                for (Iterator itUAsInferioresSecc= rsUAsInferioresSecc.getArrayDTOUniNSE().iterator(); itUAsInferioresSecc.hasNext();){
                    dtoUniNSESecc = (DTOUniNSE) itUAsInferioresSecc.next();
                    
                    rsUAsInferioresTerr = daoZON.obtenerUAinferioresUA(dtoUniNSESecc.getOidUni(), new Integer(4));
                    UtilidadesLog.info("rsUAsInferioresTerr: " + rsUAsInferioresTerr);
                
                    if(rsUAsInferioresTerr.getArrayDTOUniNSE() != null){
                        for (Iterator itUAsInferioresTerr= rsUAsInferioresTerr.getArrayDTOUniNSE().iterator(); itUAsInferioresTerr.hasNext();){
                            dtoUniNSETerr = (DTOUniNSE) itUAsInferioresTerr.next();
                            territorios.add(dtoUniNSETerr.getOidUni());
                        }
                    }
                }
            }
            
            UtilidadesLog.info("Territorio: " + territorios);
            
        } else if (nivelUA.intValue()==2) {
        
            rsUAsInferioresZona = daoZON.obtenerUAinferioresUA(codUA, nivelUA);
            UtilidadesLog.info("rsUAsInferioresZona: " + rsUAsInferioresZona);
            
            if(rsUAsInferioresZona.getArrayDTOUniNSE() != null){
                for (Iterator itUAsInferioresZona= rsUAsInferioresZona.getArrayDTOUniNSE().iterator(); itUAsInferioresZona.hasNext();){
                    dtoUniNSEZona = (DTOUniNSE) itUAsInferioresZona.next();
                    
                    rsUAsInferioresSecc = daoZON.obtenerUAinferioresUA(dtoUniNSEZona.getOidUni(), new Integer(3));
                    UtilidadesLog.info("rsUAsInferioresSecc: " + rsUAsInferioresSecc);
                    
                    if(rsUAsInferioresSecc.getArrayDTOUniNSE() != null){
                        for (Iterator itUAsInferioresSecc= rsUAsInferioresSecc.getArrayDTOUniNSE().iterator(); itUAsInferioresSecc.hasNext();){
                            dtoUniNSESecc = (DTOUniNSE) itUAsInferioresSecc.next();
                            
                            rsUAsInferioresTerr = daoZON.obtenerUAinferioresUA(dtoUniNSESecc.getOidUni(), new Integer(4));
                            UtilidadesLog.info("rsUAsInferioresTerr: " + rsUAsInferioresTerr);
                        
                            if(rsUAsInferioresTerr.getArrayDTOUniNSE() != null){
                                for (Iterator itUAsInferioresTerr= rsUAsInferioresTerr.getArrayDTOUniNSE().iterator(); itUAsInferioresTerr.hasNext();){
                                    dtoUniNSETerr = (DTOUniNSE) itUAsInferioresTerr.next();
                                    territorios.add(dtoUniNSETerr.getOidUni());
                                }
                            }
                        }
                    }
                }
            }
            
            UtilidadesLog.info("Territorio: " + territorios);
            
        } else if (nivelUA.intValue()==1) {
            rsUAsInferioresRegion = daoZON.obtenerUAinferioresUA(codUA, nivelUA);
            UtilidadesLog.info("rsUAsInferioresRegion: " + rsUAsInferioresRegion);
            
            if(rsUAsInferioresRegion.getArrayDTOUniNSE() != null){
                for (Iterator itUAsInferioresRegion= rsUAsInferioresRegion.getArrayDTOUniNSE().iterator(); itUAsInferioresRegion.hasNext();){
                    dtoUniNSERegion = (DTOUniNSE) itUAsInferioresRegion.next();
                    
                    rsUAsInferioresZona = daoZON.obtenerUAinferioresUA(dtoUniNSERegion.getOidUni(), new Integer(2));
                    UtilidadesLog.info("rsUAsInferioresZona: " + rsUAsInferioresZona);
                
                    if(rsUAsInferioresZona.getArrayDTOUniNSE() != null){
                        for (Iterator itUAsInferioresZona= rsUAsInferioresZona.getArrayDTOUniNSE().iterator(); itUAsInferioresZona.hasNext();){
                            dtoUniNSEZona = (DTOUniNSE) itUAsInferioresZona.next();
                            
                            rsUAsInferioresSecc = daoZON.obtenerUAinferioresUA(dtoUniNSEZona.getOidUni(), new Integer(3));
                            UtilidadesLog.info("rsUAsInferioresSecc: " + rsUAsInferioresSecc);
                            
                            if(rsUAsInferioresSecc.getArrayDTOUniNSE() != null){
                                for (Iterator itUAsInferioresSecc= rsUAsInferioresSecc.getArrayDTOUniNSE().iterator(); itUAsInferioresSecc.hasNext();){
                                    dtoUniNSESecc = (DTOUniNSE) itUAsInferioresSecc.next();
                                    
                                    rsUAsInferioresTerr = daoZON.obtenerUAinferioresUA(dtoUniNSESecc.getOidUni(), new Integer(4));
                                    UtilidadesLog.info("rsUAsInferioresTerr: " + rsUAsInferioresTerr);
                                
                                    if(rsUAsInferioresTerr.getArrayDTOUniNSE() != null){
                                        for (Iterator itUAsInferioresTerr= rsUAsInferioresTerr.getArrayDTOUniNSE().iterator(); itUAsInferioresTerr.hasNext();){
                                            dtoUniNSETerr = (DTOUniNSE) itUAsInferioresTerr.next();
                                            territorios.add(dtoUniNSETerr.getOidUni());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            
            UtilidadesLog.info("Territorio: " + territorios);
        }
				
				for (Iterator itTerritorio = territorios.iterator();itTerritorio.hasNext(); ){
				//Arranca el for de territorios		
					asignarNSETerritorio(codPais, codMarca, codCanal, (Long) itTerritorio.next());		
				}
        
        UtilidadesLog.info("MONReestructuracionBean.asignarNSE(Long codPais, Long codMarca, Long codCanal, Long codTerritorio, Long codUA, Integer nivelUA): Salida");
        
			} else {//if codUA != null && nivelUA != null
				UtilidadesLog.error("[ZON][asignarNSE]:error de parámetros de entrada.");
        UtilidadesLog.info("MONReestructuracionBean.asignarNSE(Long codPais, Long codMarca, Long codCanal, Long codTerritorio, Long codUA, Integer nivelUA): Salida");
			}
		}//cod_terri != null
    }

    public void realizarDivisionTerritorios(Long oidTerrOrigen, String codTerrDestino, Long oidCliente, Long oidPais, Date fechaInicioPeriodo) throws MareException {
    }

    public void actualizarMaestroCliente(Long oidClienteAfectado, Long oidTerrEliminado, Long oidTerrNuevo) throws MareException {
    
        UtilidadesLog.info("MONReestructuracionBean.actualizarMaestroCliente(Long oidClienteAfectado, Long oidTerrEliminado, Long oidTerrNuevo): Entrada");
        
        BelcorpService bs;
        StringBuffer SQL = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        SQL.append("UPDATE MARE_CLIEN_DIREC SET TERR_OID_TERR=");
        SQL.append(oidTerrNuevo.toString());
        SQL.append(" WHERE CLIE_OID_CLIE=" + oidClienteAfectado.toString());
        SQL.append(" AND TERR_OID_TERR=" + oidTerrEliminado.toString());

        try {
            bs.dbService.executeUpdate(SQL.toString());
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("MONReestructuracionBean.actualizarMaestroCliente(Long oidClienteAfectado, Long oidTerrEliminado, Long oidTerrNuevo): Salida");
    }

    public void insertarHistoricoGerenteLideres(Long oidcliente, Long oidTerrOrigen, Long oidTerrDestino) throws MareException {
    }

    public void actualizarMaestroClientesFusion(Long oidTerrEliminado, Long oidTerrNuevo) throws MareException {
    
        UtilidadesLog.info("MONReestructuracionBean.actualizarMaestroClientesFusion(Long oidTerrEliminado, Long oidTerrNuevo): Entrada");
        // Actualiza todos las direcciones en entidad ClientesDirecciones de MAE
        // que tenían asociado el territorio eliminado, por el nuveo territorio.
        BelcorpService bs;
        StringBuffer SQL = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        SQL.append("UPDATE MARE_CLIEN_DIREC SET TERR_OID_TERR=");
        SQL.append(oidTerrNuevo.toString());
        SQL.append(" WHERE TERR_OID_TERR=" + oidTerrEliminado.toString());

        try {
            bs.dbService.executeUpdate(SQL.toString());
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONReestructuracionBean.actualizarMaestroClientesFusion(Long oidTerrEliminado, Long oidTerrNuevo): Salida");
        return;
    }

    public void insertaHistoricoReterritorializacion(Long oidTerritorio1, Long oidTerritorio2, Long oidTerritorio3, String tipoOP, Date fechaInicioPerido) throws MareException {
    }

    public void realizarFusionTerritorios(Long oidTerrOrigen01, Long oidTerrOrigen02, String codTerrDestion, Long oidPais, Date fechaInicioPeriodo) throws MareException {
    }

    
    private MONUnidadesGeograficasHome getMONUnidadesGeograficasHome() throws MareException {
    
        UtilidadesLog.info("MONReestructuracionBean.getMONUnidadesGeograficasHome(): Entrada");
        
        MONUnidadesGeograficasHome localHome = null;
        BelcorpService service = null;
        String codigoError = "";

        try {
            service = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            localHome = (MONUnidadesGeograficasHome) service.ejbLocator.getHome("MONUnidadesGeograficas", MONUnidadesGeograficasHome.class);
        } catch (MareServiceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("MONReestructuracionBean.getMONUnidadesGeograficasHome(): Salida");
        return localHome;
    }

    private MONUnidadesAdministrativasHome getMONUnidadesAdministrativasHome() throws MareException {
        UtilidadesLog.info("MONReestructuracionBean.getMONUnidadesAdministrativasHome(): Entrada");
        
        MONUnidadesAdministrativasHome localHome = null;
        BelcorpService service = null;
        String codigoError = "";

        try {
            service = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            localHome = (MONUnidadesAdministrativasHome) service.ejbLocator.getHome("MONUnidadesAdministrativas", MONUnidadesAdministrativasHome.class);
        } catch (MareServiceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("MONReestructuracionBean.getMONUnidadesAdministrativasHome(): Salida");
        return localHome;
    }

    public RecordSet listadoClientes() {
        return null;
    }

    public Long[] obtenerConsultorasTerritorios(Long[] territorios) {
        return null;
    }

    public String calcularModaNSEConsultoras(DTOUnidadAdministrativa adm) throws MareException {
    
        UtilidadesLog.info("MONReestructuracionBean.calcularModaNSEConsultoras(DTOUnidadAdministrativa adm): Entrada");
        UtilidadesLog.info("adm :" + adm);
        
        String codigoError = "";
        MONClientesHome localHome;
        MONClientes monCliente;
        String NSERetorno = "0";

        try {
            localHome = MAEEjbLocators.getMONClientesHome();
            monCliente = localHome.create();

            Long oidTerrAdm = adm.getOidTerritorioAdministrativo();

            DTOUnidadAdministrativa dtoUnAdm = new DTOUnidadAdministrativa();
            dtoUnAdm.setOidTerritorioAdministrativo(new Long(oidTerrAdm.toString()));

            NSERetorno = monCliente.calcularModaNSEConsultoras(dtoUnAdm);
        } catch (MareException me) {
            throw me;
        } catch (RemoteException re) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
        } catch (CreateException ce) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(ce, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("MONReestructuracionBean.calcularModaNSEConsultoras(DTOUnidadAdministrativa adm): Salida");
        return NSERetorno;
    }

    public Boolean hayConsultorasTerrAdm(Long[] terrAdm) throws MareException {
        return null;
    }

    public DTOSalida listaClientesPais(DTOBelcorp dto) throws MareException {
        return null;
    }

    public Long obtenerIDCliente(Long pais, String codCliente) throws MareException {
        return null;
    }
    public DTODireccion[] obtenerDireccionCliente(Long cliente, Long tipoDireccion) throws MareException{
        return null;
    }

    public String obtenerDireccion(DTOOID dto) throws MareException {     
        return null;    
  }

  public boolean ponerbloqueoFinanciero(Long cliente, String motivo) throws MareException
  {
    return false;
  }

  public DTOSalida buscarClientesBloqueoFinanciero (DTOBuscarClienteBloqueo criterios) throws MareException
  {
    return null;
  }

  public DTOSalida obtenerTiposDireccionCliente(DTOOID cliente) throws MareException {
    return null;
  }

  public Long obtenerOidCliente(Long pais, String codCliente) throws MareException {
     return null;
  }

  public boolean estaClienteBloqueado(Long cliente, String tipoBloqueo) throws MareException {
    UtilidadesLog.info("MONReestructuracionBean.estaClienteBloqueado(Long cliente, String tipoBloqueo)): Entrada");
    boolean bool = true;
    UtilidadesLog.info("MONReestructuracionBean.estaClienteBloqueado(Long cliente, String tipoBloqueo): Salida");
	return bool; 
  }

  public DTOUnidadAdministrativa obtenerUnidadAdministrativa(Long cliente, Long periodo) throws MareException {
		return null;
	}

  public Boolean hayClientesTerrAdm(Long terrAdm) throws MareException {
    return null;
  }

  public boolean ponerbloqueoFinanciero(Long cliente, String motivo, String observaciones) throws MareException {
    return true;
  }
  
    private TerritorioLocalHome getTerritorioLocalHome() {
        return new TerritorioLocalHome();
    } 

}