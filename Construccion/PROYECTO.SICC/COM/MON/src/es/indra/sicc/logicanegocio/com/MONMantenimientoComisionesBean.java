/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 */
 
package es.indra.sicc.logicanegocio.com;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.dtos.com.DTOComisiones;
import es.indra.sicc.dtos.com.DTOComisionesAccesos;
import es.indra.sicc.dtos.com.DTOComisionesClientes;
import es.indra.sicc.dtos.com.DTOComisionesCobranza;
import es.indra.sicc.dtos.com.DTOComisionesCobranzaTipoParticipante;
import es.indra.sicc.dtos.com.DTOComisionesEscalonada;
import es.indra.sicc.dtos.com.DTOComisionesProductos;
import es.indra.sicc.dtos.com.DTOComisionesVentas;
import es.indra.sicc.dtos.com.DTOComisionesVentasHistoricas;
import es.indra.sicc.dtos.com.DTODatosCalculosComision;
import es.indra.sicc.dtos.com.DTOGerenteZona;
import es.indra.sicc.dtos.com.DTOObtenerTramos;
import es.indra.sicc.dtos.com.DTOPlantillaDetalle;
import es.indra.sicc.dtos.com.DTORepCargaComision;
import es.indra.sicc.dtos.com.DTOSolicitudPosicion;
import es.indra.sicc.entidades.com.ComisionesAccesoLocal;
import es.indra.sicc.entidades.com.ComisionesAccesoLocalHome;
import es.indra.sicc.entidades.com.ComisionesClientesLocal;
import es.indra.sicc.entidades.com.ComisionesClientesLocalHome;
import es.indra.sicc.entidades.com.ComisionesCobranzasLocal;
import es.indra.sicc.entidades.com.ComisionesCobranzasLocalHome;
import es.indra.sicc.entidades.com.ComisionesCobranzasTipoParticipanteLocal;
import es.indra.sicc.entidades.com.ComisionesCobranzasTipoParticipanteLocalHome;
import es.indra.sicc.entidades.com.ComisionesLocal;
import es.indra.sicc.entidades.com.ComisionesLocalHome;
import es.indra.sicc.entidades.com.ComisionesMetasLocal;
import es.indra.sicc.entidades.com.ComisionesMetasLocalHome;
import es.indra.sicc.entidades.com.ComisionesProductosLocal;
import es.indra.sicc.entidades.com.ComisionesProductosLocalHome;
import es.indra.sicc.entidades.com.ComisionesVentaHistoricaLocal;
import es.indra.sicc.entidades.com.ComisionesVentaHistoricaLocalHome;
import es.indra.sicc.entidades.com.ComisionesVentasLocal;
import es.indra.sicc.entidades.com.ComisionesVentasLocalHome;
import es.indra.sicc.entidades.com.PlantillasComisionesAccesoLocal;
import es.indra.sicc.entidades.com.PlantillasComisionesAccesoLocalHome;
import es.indra.sicc.entidades.com.PlantillasComisionesLocal;
import es.indra.sicc.entidades.com.PlantillasComisionesLocalHome;
import es.indra.sicc.entidades.com.PlantillasComisionesMarcaLocal;
import es.indra.sicc.entidades.com.PlantillasComisionesMarcaLocalHome;
import es.indra.sicc.entidades.com.PlantillasComisionesPaisLocal;
import es.indra.sicc.entidades.com.PlantillasComisionesPaisLocalHome;
import es.indra.sicc.entidades.ped.TiposSolicitudLocal;
import es.indra.sicc.entidades.ped.TiposSolicitudLocalHome;
import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocal;
import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocalHome;
import es.indra.sicc.logicanegocio.com.DAOMantenimientoComisiones;
import es.indra.sicc.logicanegocio.com.MONGestionComisiones;
import es.indra.sicc.logicanegocio.com.MONGestionComisionesHome;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;

import javax.persistence.PersistenceException;

import javax.rmi.PortableRemoteObject;

/**
 * Sistema:           Belcorp
 * Modulo:            COM
 * Componente:        MONMantenimientoComisiones
 * Fecha:             16/03/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-COM-201-334-N033-1
 * Descripcion:       
 * @version           1.0
 * @autor             
 */
public class MONMantenimientoComisionesBean implements SessionBean {
    private SessionContext ctx;
    
    public void ejbCreate()  {
    }
    
    public void ejbActivate()  {
    }
    
    public void ejbPassivate()  {
    }
    
    public void ejbRemove()  {
    }
    
    public void setSessionContext(SessionContext ctx)  {
        this.ctx = ctx;
    }


    /** 
    * Retorna todos los datos de una comision segun el oidComision de entrada.    
    * @return DTOComisiones
    * @exception MareException 
    * @author gdmarzi
    * @referencia SICC-DMCO-COM-201-334-N033-1
    */
    public DTOComisiones consultarComisiones(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoComisionesBean.consultarComisiones(DTOOID dto): Entrada");
        
        ComisionesLocal comisionesLocal;
        PlantillasComisionesLocal plantillasComisionesLocal;
        PlantillasComisionesPaisLocal plantillasComisionesPaisLocal;
        
        BelcorpService bs = BelcorpService.getInstance();
        StringBuffer query = new StringBuffer(""); 
        RecordSet rsMarca = null;
        
        DTOComisiones respuesta = new DTOComisiones();
        
        try {
            ComisionesLocalHome comisionesLocalHome = this.getComisionesLocalHome();            
            comisionesLocal = comisionesLocalHome.findByPrimaryKey(dto.getOid());        
        } catch (NoResultException nre) {
            ctx.setRollbackOnly();
             UtilidadesLog.error("ERROR ", nre);
            throw new MareException(nre,        
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
        } catch (PersistenceException pe) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("ERROR ", pe);
            throw new MareException(pe,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        respuesta.setOid(dto.getOid());
        respuesta.setCodigo(comisionesLocal.getCodComi());
        respuesta.setVersion(comisionesLocal.getNumVers());
        respuesta.setPeriodosEspera(comisionesLocal.getNumPeriEspe());
        respuesta.setConcepto(comisionesLocal.getValConc());

        if (comisionesLocal.getIndComp() != null) {
            if(comisionesLocal.getIndComp().booleanValue() == true) {
              respuesta.setComparativo(Boolean.TRUE);  
            }
            else {
              respuesta.setComparativo(Boolean.FALSE);  
            }            
        }
        else {
            respuesta.setComparativo(null);  
        }

        if (comisionesLocal.getIndTratDife() != null) {
            if(comisionesLocal.getIndTratDife().booleanValue() == true) {
              respuesta.setTratamientoDiferencial(Boolean.TRUE);
            }
            else {
              respuesta.setTratamientoDiferencial(Boolean.FALSE);
            }            
        }
        else {
            respuesta.setTratamientoDiferencial(null);
        }

        respuesta.setFecUltimoEstado(comisionesLocal.getFecUltiEsta());
        respuesta.setObservaciones(comisionesLocal.getValObse());
        respuesta.setOidPlantillasComisionesPais(comisionesLocal.getPlcpOidPlanComiPais());
        respuesta.setOidPlantillasComisionesMarca(comisionesLocal.getPlcmOidPlanComiMarc());         
        respuesta.setOidPeriodoDesde(comisionesLocal.getPerdOidPeri());        
        respuesta.setOidPeriodoHasta(comisionesLocal.getPerdOidPeriHast());
        respuesta.setOidPeriodoVigorModificacion(comisionesLocal.getPerdOidPeriVigoModi());
        respuesta.setOidTipoComision(comisionesLocal.getTplaOidTipoPlan());
        respuesta.setOidEstado(comisionesLocal.getEstado());  
        respuesta.setOidPlantillasComisones(comisionesLocal.getPlcoOidPlanComi());
        
        // vbongiov -- Cambio 20090913 -- 5/08/2009
        respuesta.setConsideraSabDomFer(comisionesLocal.getConsideraSabDomFer());
        respuesta.setDsctoImpstoVtaPagos(comisionesLocal.getDsctoImpstoVtaPagos());

        // sapaza -- PER-SiCC-2010-0478 -- 19/08/2010
        respuesta.setComisionEscalonada(comisionesLocal.getComisionEscalonada());
        
        try {        
            PlantillasComisionesPaisLocalHome plantillasComisionesPaisLocalHome = getPlantillasComisionesPaisLocalHome();            
            plantillasComisionesPaisLocal = plantillasComisionesPaisLocalHome.findByPrimaryKey(comisionesLocal.getPlcpOidPlanComiPais());
          
            PlantillasComisionesLocalHome plantillasComisionesLocalHome = getPlantillasComisionesLocalHome();        
            plantillasComisionesLocal = plantillasComisionesLocalHome.findByPrimaryKey(plantillasComisionesPaisLocal.getOidPlantillaComision());
        } catch (NoResultException nre) {
            ctx.setRollbackOnly();
             UtilidadesLog.error("ERROR ", nre);
            throw new MareException(nre,        
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
        } catch (PersistenceException pe) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("ERROR ", pe);
            throw new MareException(pe,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }     
        
        respuesta.setOidCanal(plantillasComisionesLocal.getOidCanal());
        
        /*Inicio Agragado Incidencia ciglesias DBLG700000207*/
        DTOPlantillaDetalle plantillaDetalle = new DTOPlantillaDetalle();
        plantillaDetalle.setOidPlantilla(plantillasComisionesLocal.getOid());
        plantillaDetalle.setOidTipoComision(plantillasComisionesLocal.getOidTipoPlantilla());
        plantillaDetalle.setComparativo(plantillasComisionesLocal.getComparativo()==null?"":plantillasComisionesLocal.getComparativo().toString());
        plantillaDetalle.setTratamientoDiferencial(plantillasComisionesLocal.getTratamientoDiferencial()==null?"":plantillasComisionesLocal.getTratamientoDiferencial().toString());
        
        respuesta.setPlantillaDetalle(plantillaDetalle);
        /*Fin Agragado Incidencia ciglesias DBLG700000207*/
        

        query.append(" SELECT v_gen_i18n_sicc.val_i18n as descripcion ");
        query.append(" FROM seg_canal, v_gen_i18n_sicc ");
        query.append(" WHERE seg_canal.oid_cana = v_gen_i18n_sicc.val_oid ");
        query.append(" AND v_gen_i18n_sicc.idio_oid_idio = " + dto.getOidIdioma());
        query.append(" AND v_gen_i18n_sicc.attr_enti = 'SEG_CANAL' ");
        query.append(" AND v_gen_i18n_sicc.attr_num_atri = 1 ");               
        query.append(" AND seg_canal.oid_cana = " + plantillasComisionesLocal.getOidCanal());
        
        try {
            rsMarca = bs.dbService.executeStaticQuery( query.toString());           
        }
        catch (Exception ex) {
          UtilidadesLog.error(ex);
          ctx.setRollbackOnly();
          throw new MareException(ex,
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        if (! rsMarca.esVacio()) {
          respuesta.setDescCanal( (String)rsMarca.getValueAt(0, "DESCRIPCION"));
        }

        DAOMantenimientoComisiones daoMantenimientoComisiones = new DAOMantenimientoComisiones();        
        
        respuesta.setComisionesAccesos(daoMantenimientoComisiones.consultarComisionesAccesos(dto));        
        respuesta.setComisionesProductos(daoMantenimientoComisiones.consultarComisionesProductos(dto));        
        respuesta.setComisionesCobranza(daoMantenimientoComisiones.consultarComisionesCobranzas(dto));        
        respuesta.setComisionesVentas(daoMantenimientoComisiones.consultarComisionesVentas(dto));       
        respuesta.setComisionesVentaHistorica(daoMantenimientoComisiones.consultarComisionesVentasHistoricas(dto));        
        respuesta.setComisionesClientes(daoMantenimientoComisiones.consultarComisionesClientes(dto));        
        
        Vector descrip = new Vector();
        
        try {               
          Entidadi18nLocalHome entidadi18nLocalHome = new Entidadi18nLocalHome();          
          Collection entidadesi18n = entidadi18nLocalHome.findByEntAtrPK("COM_COMIS",new Long(1), dto.getOid());
          Iterator it = entidadesi18n.iterator();
          
          int i = 0;
          while (it.hasNext()) {
            DTOI18nSICC dtoTemp = new DTOI18nSICC();
            Entidadi18nLocal entidad = (Entidadi18nLocal)it.next();
            dtoTemp.setOidAtriuto(entidad.getAtributo());
            dtoTemp.setOidIdioma(entidad.getIdioma());
            dtoTemp.setValorI18n(entidad.getDetalle());
            
            descrip.add(dtoTemp);
            i++;          
          }
        }
        catch (NoResultException e) {        
          UtilidadesLog.debug(e);
          throw new MareException(e, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
         catch (Exception ex) {
          UtilidadesLog.error(ex);         
        }
        
        DTOI18nSICC[] dtosI18N = new DTOI18nSICC[descrip.size()];
        
        for(int i=0; i<descrip.size(); i++) {
          dtosI18N[i] = (DTOI18nSICC)descrip.get(i);          
        }
        
        respuesta.setAttTraducible(dtosI18N);
        
        Long oidPlantillaMarc = respuesta.getOidPlantillasComisionesMarca();
        Long oidMarca = obtenerMarcaSegunPlantillaMarca(oidPlantillaMarc);
        respuesta.setOidMarca(oidMarca);
        
        respuesta.setIndVentaCobranza(comisionesLocal.getIndVentCob());
        
        UtilidadesLog.info("MONMantenimientoComisionesBean.consultarComisiones(DTOOID dto): Salida");
        return respuesta;
    }
    
    private Long obtenerMarcaSegunPlantillaMarca(Long oidPlantillaMarca) throws MareException {
      UtilidadesLog.info("MONMantenimientoComisionesBean.obtenerMarcaSegunPlantillaMarca(Long oidPlantillaMarca): Entrada");
      Long oidMarca = null;      
      PlantillasComisionesMarcaLocalHome pcmlh;
      PlantillasComisionesMarcaLocal pcml;
      
      try {
        pcmlh = this.getPlantillasComisionesMarcaLocalHome();
        pcml = pcmlh.findByPrimaryKey(oidPlantillaMarca);
        oidMarca = pcml.getOidMarca();
      } catch (NoResultException nre) {
          ctx.setRollbackOnly();
           UtilidadesLog.error("ERROR ", nre);
          throw new MareException(nre,        
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
      } catch (PersistenceException pe) {
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", pe);
          throw new MareException(pe,
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      UtilidadesLog.info("MONMantenimientoComisionesBean.obtenerMarcaSegunPlantillaMarca(Long oidPlantillaMarca): Salida");
      return oidMarca;
    }
    
    private Long obtieneOidPlantillaMarca(DTOComisiones dto) throws MareException {
          UtilidadesLog.info("MONMantenimientoComisionesBean.obtieneOidPlantillaMarca(DTOComisiones dto): Entrada");
          //Obteniendo oid de plantilla comisiones marca
          Long oidPlanComisMarca = null;          
          PlantillasComisionesMarcaLocalHome plantillaComLocalHome;
          PlantillasComisionesMarcaLocal plantillaComLocal;          
          
          if(dto.getOidPlantillasComisionesMarca()!=null) {
            oidPlanComisMarca = dto.getOidPlantillasComisionesMarca();
          }          
          else {
            try {
              plantillaComLocalHome = this.getPlantillasComisionesMarcaLocalHome();
              plantillaComLocal = plantillaComLocalHome.findByUk(dto.getOidMarca(), dto.getOidPlantillasComisones());          
            
              oidPlanComisMarca = plantillaComLocal.getOid();            
            } catch (NoResultException nre) {
                ctx.setRollbackOnly();
                 UtilidadesLog.error("ERROR ", nre);
                throw new MareException(nre,        
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
            } catch (PersistenceException pe) {
                ctx.setRollbackOnly();
                UtilidadesLog.error("ERROR ", pe);
                throw new MareException(pe,
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }               
          }         
          UtilidadesLog.info("MONMantenimientoComisionesBean.obtieneOidPlantillaMarca(DTOComisiones dto): Salida");
          return oidPlanComisMarca;
    }
    
    private Long obtieneOidPlantillaPais(DTOComisiones dto) throws MareException  {
          UtilidadesLog.info("MONMantenimientoComisionesBean.obtieneOidPlantillaPais(DTOComisiones dto): Entrada");
        //Obteniendo oid de plantilla comisiones marca pais        
          Long oidPlanComisPais = null;
          PlantillasComisionesPaisLocalHome pcplh;
          PlantillasComisionesPaisLocal pcpl;
          
          if(dto.getOidPlantillasComisionesPais()!=null) {
            oidPlanComisPais = dto.getOidPlantillasComisionesPais();
          }
          else {
            try {
              pcplh = this.getPlantillasComisionesPaisLocalHome();
              pcpl = pcplh.findByUK(dto.getOidPlantillasComisones(),
              dto.getOidPais());          
              oidPlanComisPais = pcpl.getOid();
            } catch (NoResultException nre) {
                ctx.setRollbackOnly();
                 UtilidadesLog.error("ERROR ", nre);
                throw new MareException(nre,        
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
            } catch (PersistenceException pe) {
                ctx.setRollbackOnly();
                UtilidadesLog.error("ERROR ", pe);
                throw new MareException(pe,
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }            
          }
          UtilidadesLog.info("MONMantenimientoComisionesBean.obtieneOidPlantillaPais(DTOComisiones dto): Salida");
          return oidPlanComisPais;      
    }


  /** 
  * @author ssantana, 28/3/2005  
  * @return void
  * @exception MareException 
  * @referencia SICC-DMCO-COM-201-334-N033-1
  */
  public void guardarComisiones(DTOComisiones dto) throws MareException   {
      UtilidadesLog.info("MONMantenimientoComisionesBean.guardarComisiones(DTOComisiones dto): Entrada");
      UtilidadesLog.debug("DTOComisiones: " + dto);
      
      ComisionesLocal comisLocal = null;
      ComisionesLocalHome comisLocalHome = null;
      
      Long oid = dto.getOid();
      comisLocalHome = this.getComisionesLocalHome();
           
      // Si oid es null crea la entidad, si no, obtiene la referencia a la entidad
      // ya existente.
      
      Long oidPlantillaComisionesPais = this.obtieneOidPlantillaPais(dto);
      Long oidPlantillaComisionesMarca = this.obtieneOidPlantillaMarca(dto);         
      Long estado;
      
      if(dto.getComisionesClientes()!=null && dto.getComisionesClientes().size() > 0) {                  
        if(dto.getComisionesVentas()!=null || dto.getComisionesCobranza()!=null) {
          estado = ConstantesCOM.ESTADO_COMISION_ACTIVA;                            
        }
        else {
          estado = ConstantesCOM.ESTADO_COMISION_EN_CREACION;  
        }
      }   
      else {
        estado = ConstantesCOM.ESTADO_COMISION_EN_CREACION;
      }
      
      boolean esModificacion = false;
      if (oid == null){
        try {
          UtilidadesLog.debug("Es una insercion de Comision");
          MONGestionComisionesHome monGestionComisHome = this.getMONGestionComisionesHome();
          MONGestionComisiones monGestionComis = monGestionComisHome.create();
          
          String codigoComision = monGestionComis.generaCodigoComision();
          
          
          comisLocal = comisLocalHome.create(codigoComision,
                                new Integer(1), /// Version en 1 si se crea por 1era vez.
                                oidPlantillaComisionesPais,
                                oidPlantillaComisionesMarca,
                                dto.getOidPeriodoDesde(),
                                dto.getOidTipoComision(),   // tplaOidTipoPlan ???????
                                dto.getOidPeriodoHasta(),
                                estado,
                                dto.getOidPlantillasComisones(),
                                dto.getIndVentaCobranza());
                                
          // vbongiov -- Cambio 20090913 -- 5/08/2009                                
          comisLocal.setConsideraSabDomFer(dto.getConsideraSabDomFer());      
          comisLocal.setDsctoImpstoVtaPagos(dto.getDsctoImpstoVtaPagos());
          
          // sapaza -- PER-SiCC-2010-0478 -- 19/08/2010
          comisLocal.setComisionEscalonada(dto.getComisionEscalonada());
          
          comisLocalHome.merge(comisLocal);      
                               
          oid = comisLocal.getOid();
          esModificacion = false;                          
        }
        catch (CreateException cEx){
          UtilidadesLog.error(cEx);
          String sCodigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
          throw new MareException(cEx, UtilidadesError.armarCodigoError(sCodigoError));
        }
        catch (NamingException nEx) {
            UtilidadesLog.error(nEx);
            ctx.setRollbackOnly();
            throw new MareException(nEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        catch (RemoteException rEx){
            UtilidadesLog.error(rEx);
            ctx.setRollbackOnly();
            throw new MareException(rEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch(PersistenceException e) {
           ctx.setRollbackOnly();
           UtilidadesLog.error("ERROR ", e);
           throw new MareException(e,
                  UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }                                                            
       
      }
      else {
          UtilidadesLog.debug("Es una Modificacion de Comision");
          try {
            comisLocal = comisLocalHome.findByPrimaryKey(oid);
            /*
             * dmorello, 29/05/2006: No cambia el número de versión.
             * El mismo ya se incrementó al marcar la comisión para modificar.
             */
            //Integer nVersion = comisLocal.getNumVers();
            //nVersion = new Integer( nVersion.intValue() + 1 );
            //comisLocal.setNumVers(nVersion);
            
            //Si el estado es comision autoriazada
            if(comisLocal.getEstado().longValue() == ConstantesCOM.ESTADO_COMISION_SOLICITUD_ACEPTADA.longValue()) {
              //Se cambia a comision confirmacion cambios
              comisLocal.setEstado(ConstantesCOM.ESTADO_COMISION_CONFIRMACION_CAMBIOS);              
            }
            
            //Si el estado es en creacion
            if(comisLocal.getEstado().longValue() == ConstantesCOM.ESTADO_COMISION_EN_CREACION.longValue()) {
              //y tiene clientes
              if(dto.getComisionesClientes()!=null && dto.getComisionesClientes().size() > 0) {                  
                //y ademas tiene ventas o cobranzas...
                if(dto.getComisionesVentas()!=null || dto.getComisionesCobranza()!=null) {
                  //se modifica el estado a activa
                  UtilidadesLog.debug("*** Cambiando el estado de la comision, de en_creacion a activa");
                  comisLocal.setEstado(ConstantesCOM.ESTADO_COMISION_ACTIVA);       
                }               
              }              
            }
            
            // Plantilla Comisiones Marca
            comisLocal.setPlcmOidPlanComiMarc(oidPlantillaComisionesMarca);
      
            // Plantilla Comisiones Pais
            comisLocal.setPlcpOidPlanComiPais(oidPlantillaComisionesPais);
            esModificacion = true;
            
          } catch (NoResultException nre) {
              ctx.setRollbackOnly();
               UtilidadesLog.error("ERROR ", nre);
              throw new MareException(nre,        
                  UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
          } catch (PersistenceException pe) {
              ctx.setRollbackOnly();
              UtilidadesLog.error("ERROR ", pe);
              throw new MareException(pe,
                  UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
      }
      
      
      // **************************
      // Realiza las modificaciones
      // **************************

      // Codigo Comision
      //comisLocal.setCodComi(dto.getCodigo());
      
      // Fecha Ultimo Estado
      Timestamp t = null;
      if ( dto.getFecUltimoEstado() != null)
        t = new Timestamp( dto.getFecUltimoEstado().getTime() );
      comisLocal.setFecUltiEsta(t);
      
      // Comparativo
      comisLocal.setIndComp(dto.getComparativo());
      
      // Tratamiento Diferencial
      comisLocal.setIndTratDife(dto.getTratamientoDiferencial());
      
      // Numero Periodos Espera
      comisLocal.setNumPeriEspe(dto.getPeriodosEspera());
      
      // Periodo (imagino que es Periodo Desde del DTO)
      comisLocal.setPerdOidPeri(dto.getOidPeriodoDesde());
      
      // Periodo Hasta
      comisLocal.setPerdOidPeriHast(dto.getOidPeriodoHasta());
      
      // vbongiov -- Cambio 20090913 -- 5/08/2009                                
      comisLocal.setConsideraSabDomFer(dto.getConsideraSabDomFer());      
      comisLocal.setDsctoImpstoVtaPagos(dto.getDsctoImpstoVtaPagos());
      
      // sapaza -- PER-SiCC-2010-0478 -- 19/08/2010
      comisLocal.setComisionEscalonada(dto.getComisionEscalonada());
      
      // Periodo Vigor Modificacion 
      comisLocal.setPerdOidPeriVigoModi(dto.getOidPeriodoVigorModificacion());
      
      // Plantilla Comisiones
      comisLocal.setPlcoOidPlanComi(dto.getOidPlantillasComisones());
      
      // Oid Tipo Plan (???????)
      comisLocal.setTplaOidTipoPlan(dto.getOidTipoComision());
      
      // Concepto
      comisLocal.setValConc(dto.getConcepto());
      
      // Observaciones
      comisLocal.setValObse(dto.getObservaciones());      
      
      comisLocalHome.merge(comisLocal);      
      
      // Elimina en Cascada todos los registros de las 7 entidades relacionadas...
      if (esModificacion)
        this.eliminarDatosComisiones(oid);
      
      this.grabaNuevasComisiones(dto, oid);
      UtilidadesLog.info("MONMantenimientoComisionesBean.guardarComisiones(DTOComisiones dto): Salida");
  }
  
  
  /**
   * @Author: ssantana, 31/3/2005
   * @throws es.indra.mare.common.exception.MareException
   */
  private void guardarI18nComision(Long oidComision, DTOComisiones dto) throws MareException   {
     UtilidadesLog.info("MONMantenimientoComisionesBean.guardarI18nComision(Long oidComision, DTOComisiones dto): Entrada");
     try {
       Entidadi18nLocalHome i18nLocalHome = new Entidadi18nLocalHome();
       Entidadi18nLocal i18nLocal = null;
       DTOI18nSICC[] dtoI18nArray = dto.getAttTraducible();
       
       // Primero borro todas aquellas Entidades que pertenezcan a "COM_COMIS"
       // cuyo Oid FK sea oidComision.
       Collection col = i18nLocalHome.findByEntPK("COM_COMIS", oidComision);
       Iterator it = col.iterator();
       
       while (it.hasNext()) {
          i18nLocal = (Entidadi18nLocal) it.next();
          i18nLocalHome.remove(i18nLocal);
       }
       
       // Ahora recorro el Array de DTOI18nSICC y creo las entidades.
       
       for (int i = 0; i < dtoI18nArray.length; i++) {
         DTOI18nSICC dtoi18n = (DTOI18nSICC) dtoI18nArray[i];
         i18nLocal = i18nLocalHome.create("COM_COMIS", 
                                           new Long(1),  // ATTR_NUM_ATRI 
                                           dtoi18n.getOidIdioma(),
                                           dtoi18n.getValorI18n(),
                                           oidComision );                  
       }
       UtilidadesLog.info("MONMantenimientoComisionesBean.guardarI18nComision(Long oidComision, DTOComisiones dto): Salida");
     }     
     catch (NoResultException fEx) {
        UtilidadesLog.debug(fEx);
        String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
        throw new MareException(fEx, UtilidadesError.armarCodigoError(sCodigoError) );
     }
      catch (PersistenceException cEx) {
         UtilidadesLog.error(cEx);
         String sCodigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
         throw new MareException(cEx, UtilidadesError.armarCodigoError(sCodigoError) );
      }     
    return;
  }
  /**
   * @Author: ssantana, 28/3/2005
   * @throws es.indra.mare.common.exception.MareException   
   */
  private void eliminarDatosComisiones(Long oidComision) throws MareException {
    // Borra ComisionesAccesos, ComisionesProductos, ComisionesCobranza, 
    // ComisionesCobranzaTipoParticipantes, ComisionesVentas, ComisionesVentaHistorica 
    // y ComisionesClientes que esten asociados al "oidComision"
    UtilidadesLog.info("MONMantenimientoComisionesBean.eliminarDatosComisiones(Long oidComision): Entrada");
    ComisionesProductosLocalHome comisionesProductosLocalHome = null;
    ComisionesProductosLocal comisionesProductosLocal = null;
    
    ComisionesVentasLocalHome comisionesVentasLocalHome = null;
    ComisionesVentasLocal comisionesVentasLocal = null;
    
    ComisionesVentaHistoricaLocalHome comisionesVHLocalHome = null;
    ComisionesVentaHistoricaLocal comisionesVHLocal = null;
    
    ComisionesClientesLocalHome comisionesClientesLocalHome = null;
    
    ComisionesAccesoLocalHome comisionesAccesoLocalHome = null;
    //ComisionesAccesoLocal comisionesAccesoLocal = null;
    
    ComisionesCobranzasLocalHome comisionesCobranzasLocalHome = null;
    //ComisionesCobranzasLocal comisionesCobranzasLocal = null;
    
    ComisionesCobranzasTipoParticipanteLocalHome comisionesTPLocalHome = null;
    ComisionesCobranzasTipoParticipanteLocal comisionesTPLocal = null;
    
    Vector vTuplasComisionesTP = new Vector(); // Contendrá las referencias a Entidades 
                                               // ComisionesTipoParticipantes.
    
    // Obtiene la referencia a estas entiddades. 
    comisionesProductosLocalHome = this.getComisionesProductosLocalHome();
    comisionesVentasLocalHome = this.getComisionesVentasLocalHome();
    comisionesVHLocalHome = this.getComisionesVentaHistoricaLocalHome();
    comisionesClientesLocalHome = this.getComisionesClientesLocalHome();
    comisionesAccesoLocalHome = this.getComisionesAccesoLocalHome();
    comisionesCobranzasLocalHome = this.getComisionesCobranzasLocalHome();
    comisionesTPLocalHome = this.getComisionesCobranzasTipoParticipanteLocalHome();


    // Busca todas las entidades que tengan oidComision.     
    Collection colComisionesProductos = null;
    Collection colComisionesClientes = null;
    Collection colComisionesAccesos = null;
    Collection colComisionesCobranzas = null;
    DAOMantenimientoComisiones daoMantenimientoComisiones = new DAOMantenimientoComisiones();
      
    // Entidades que retornan Collection    
    try {
        colComisionesProductos = comisionesProductosLocalHome.findByComision(oidComision);
        colComisionesClientes = comisionesClientesLocalHome.findByComision(oidComision);
        colComisionesAccesos = comisionesAccesoLocalHome.findbyComision(oidComision);
        colComisionesCobranzas = comisionesCobranzasLocalHome.findByComision(oidComision);
        
        // Para obtener comisionesTPLocalHome
        if (!colComisionesCobranzas.isEmpty())
        {
          Iterator it = colComisionesCobranzas.iterator();
          ComisionesCobranzasLocal comisionesCobranzasLocal = null;    
          
          // Por cada entidad de Comisiones Cobranzas, obtengo todas aquellas entidades
          // de comisionesTipoParticipante que le hacen referencia.
          Collection colComisionesTP = null;
          while (it.hasNext())
          {
              comisionesCobranzasLocal = (ComisionesCobranzasLocal)it.next();
              Long oidComisionesCobranza = comisionesCobranzasLocal.getOid();
              colComisionesTP = comisionesTPLocalHome.findByCobranza(oidComisionesCobranza);
              
              // Si existen datos en COM_COMIS_COBRA_TIPO_PARTI con 
              // COCO_OID_COMI_COBR = oidComisionesCobranza, entonces lo agrego al vector. 
              if (!colComisionesTP.isEmpty())
                this.anyadeTuplasComisionesTP(colComisionesTP, vTuplasComisionesTP);
          }
        }
        
    } catch (NoResultException nre) {
        ctx.setRollbackOnly();
         UtilidadesLog.error("ERROR ", nre);
        throw new MareException(nre,        
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
    } catch (PersistenceException pe) {
        ctx.setRollbackOnly();
        UtilidadesLog.error("ERROR ", pe);
        throw new MareException(pe,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    
    // Entidades a las que se realiza un findByUK
    try {
        comisionesVentasLocal = comisionesVentasLocalHome.findByUK(oidComision);    
        comisionesVHLocal = comisionesVHLocalHome.findByUK(oidComision);    
    
    } catch (NoResultException nre) {
        // Si pincha debe proceder con la ejecucion del método, no lanza
        // MareException.
        UtilidadesLog.debug(nre);
    } catch (PersistenceException pe) {
        ctx.setRollbackOnly();
        UtilidadesLog.error("ERROR ", pe);
        throw new MareException(pe,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }

    // ****************************************************************************************
    // *********************** Con todos los datos, ahora hace borrado en cascada *************
    // ****************************************************************************************
    try 
    {
       // Primero las tuplas ComisionesCobranzasTipoParticipanteLocal
       for (int i = 0; i < vTuplasComisionesTP.size(); i++)
       {
         comisionesTPLocal = (ComisionesCobranzasTipoParticipanteLocal) vTuplasComisionesTP.get(i);
         comisionesTPLocalHome.remove(comisionesTPLocal);
       }
       
       if(comisionesVentasLocal!=null) {
        comisionesVentasLocalHome.remove(comisionesVentasLocal);         
       }
       
       if(comisionesVHLocal!=null) {
        comisionesVHLocalHome.remove(comisionesVHLocal);  
       }       
       
       if ( !colComisionesProductos.isEmpty() )
       {
         Iterator it = colComisionesProductos.iterator();       
         for (int i = 0; i < colComisionesProductos.size(); i++)
         {
            comisionesProductosLocal = (ComisionesProductosLocal)it.next();
            comisionesProductosLocalHome.remove(comisionesProductosLocal);
         }
       }
       
       if ( !colComisionesClientes.isEmpty() )
       {
         Iterator it = colComisionesClientes.iterator();
         for (int i = 0; i < colComisionesClientes.size(); i++)
         {            
            ComisionesClientesLocal comisionesClientesLocal = (ComisionesClientesLocal)it.next();
            comisionesClientesLocalHome.remove(comisionesClientesLocal);
         }       
         
       }
       
       if ( !colComisionesAccesos.isEmpty() )
       {
         Iterator it = colComisionesAccesos.iterator();       
         for (int i = 0; i < colComisionesAccesos.size(); i++)
         {
            ComisionesAccesoLocal comisionesAccesoLocal = (ComisionesAccesoLocal)it.next();
            comisionesAccesoLocalHome.remove(comisionesAccesoLocal);
         }       
       }       
       
       if ( !colComisionesCobranzas.isEmpty() )
       {
         Iterator it = colComisionesCobranzas.iterator();
         for (int i = 0; i < colComisionesCobranzas.size(); i++)
         {
            ComisionesCobranzasLocal comisionesCobranzasLocal = (ComisionesCobranzasLocal)it.next();
            
             // sapaza -- PER-SiCC-2010-0478 -- 19/08/2010
             //Borramos la lista de Comisiones Escalonadas
             daoMantenimientoComisiones.eliminarComisionesEscalonadas(comisionesCobranzasLocal.getOid());
            
            comisionesCobranzasLocalHome.remove(comisionesCobranzasLocal);
         }       
       }
       
    } catch (PersistenceException pe) {
        ctx.setRollbackOnly();
        throw new MareException(pe, 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
    }

    UtilidadesLog.info("MONMantenimientoComisionesBean.eliminarDatosComisiones(Long oidComision): Salida");
  }
  
  
  /**
   * @author: ssantana, 29/3/2005
   * @throws es.indra.mare.common.exception.MareException   
   */
   // mmaidana -- 12/04/2005 -- Se agregó oidCanal en la invocación a 
   // guardarComisionesAccesos.
  private void grabaNuevasComisiones(DTOComisiones dto, Long oidComision) throws MareException {
      // Método Dispatcher que se utiliza para generar nuevos datos en las 7 Entidades 
      // relacionadas con Comisiones (Llama a las funciones que manejan los ArrayList).
      UtilidadesLog.info("MONMantenimientoComisionesBean.grabaNuevasComisiones(DTOComisiones dto, Long oidComision): Entrada");
      
      //ArrayList aListAccesos = dto.getComisionesAccesos();
      this.guardarComisionesAccesos(dto.getComisionesAccesos(), oidComision, dto.getOidPlantillasComisones(), dto.getOidCanal());
      
      ArrayList aListClientes = dto.getComisionesClientes();
      if((aListClientes!=null) && (aListClientes.size() > 0)) {
        this.guardarComisionesClientes(dto.getComisionesClientes(), oidComision);  
      }      
      
      ArrayList aListaProductos = dto.getComisionesProductos();
      if((aListaProductos!=null) && (aListaProductos.size() > 0)) {
        this.guardarComisionesProductos(dto.getComisionesProductos(), oidComision);  
      }      
      
      ArrayList aListaCobranza = dto.getComisionesCobranza();
      if((aListaCobranza!=null) && (aListaCobranza.size() > 0) ) {
        this.guardarComisionesCobranzas(aListaCobranza, oidComision);  
      }      
      
      DTOComisionesVentas dtoVentas = dto.getComisionesVentas();   
      if(dtoVentas!=null) {
        this.guardarComisionesVentas(dtoVentas, oidComision);  
      }      
      
      DTOComisionesVentasHistoricas dtoVentasHistoricas = dto.getComisionesVentaHistorica();
      if(dtoVentasHistoricas!=null) {
        this.guardarComisionesVentasHistoricas(dtoVentasHistoricas, oidComision);  
      }
      
      if(dto.getAttTraducible()!=null) {
        this.guardarI18nComision(oidComision, dto);
      }    
      
      UtilidadesLog.info("MONMantenimientoComisionesBean.grabaNuevasComisiones(DTOComisiones dto, Long oidComision): Salida");
  }
  
  /**
   * @author: ssantana, 29/3/2005
   * @throws es.indra.mare.common.exception.MareException   
   */
   // mmaidana -- 12/04/2005 -- Se agregó el parámetro oidCanal, debido al 
   // cambio del entity ComisionesAcceso.
  private void guardarComisionesAccesos(ArrayList accesos, Long oidComision, 
      Long oidPlantillaComisiones, Long oidCanal) throws MareException {
      
      UtilidadesLog.info("MONMantenimientoComisionesBean.guardarComisionesAccesos(ArrayList accesos, Long oidComision, Long oidPlantillaComisiones, Long oidCanal): Entrada");
      DTOComisionesAccesos dtoAccesos = null;
      ComisionesAccesoLocalHome comisionesAccesoLocalHome = null;
      ComisionesAccesoLocal comisionesAccesoLocal = null;

      Iterator it = accesos.iterator();
      try  { 
         comisionesAccesoLocalHome = this.getComisionesAccesoLocalHome();
         while(it.hasNext()) {
            dtoAccesos = (DTOComisionesAccesos) it.next();
            
            //En realidad se trata del oid de acceso, por eso antes de hacer el 
            //create, se hace lo siguiente (INCIDENCIA 16061)
            Long oidAcceso = dtoAccesos.getOid();
            PlantillasComisionesAccesoLocalHome pcalh = this.getPlantillasComisionesAccesoLocalHome();
            PlantillasComisionesAccesoLocal pcal = pcalh.findByUK(oidAcceso, oidPlantillaComisiones, oidCanal);
            Long oid = pcal.getOid();            
            comisionesAccesoLocalHome.create(oid, oidComision, oidCanal);
         }
         UtilidadesLog.info("MONMantenimientoComisionesBean.guardarComisionesAccesos(ArrayList accesos, Long oidComision, Long oidPlantillaComisiones, Long oidCanal): Salida");
      } catch (NoResultException nre) {
          ctx.setRollbackOnly();
           UtilidadesLog.error("ERROR ", nre);
          throw new MareException(nre,        
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
      } catch (PersistenceException pe) {
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", pe);
          throw new MareException(pe,
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
  }
  
  /**
   * @author: ssantana, 29/3/2005
   * @throws es.indra.mare.common.exception.MareException   
   */
  private void guardarComisionesClientes(ArrayList clientes, Long oidComision) 
    throws MareException {
      UtilidadesLog.info("MONMantenimientoComisionesBean.guardarComisionesClientes(ArrayList clientes, Long oidComision): Entrada");
      DTOComisionesClientes dtoComisionesClientes = null;
      ComisionesClientesLocalHome comisionesClientesLocalHome = null;
      ComisionesClientesLocal comisionesClientesLocal = null;
      Iterator it = clientes.iterator();
      
      try 
      {
          comisionesClientesLocalHome = this.getComisionesClientesLocalHome();
          while ( it.hasNext() )
          {
              dtoComisionesClientes = (DTOComisionesClientes) it.next();
              
              Integer codigoOrden = dtoComisionesClientes.getNumero();
              Long tipoClientesCCabecera = dtoComisionesClientes.getOidTipoClienteComisionesCabecera();
              
              UtilidadesLog.debug("oidComision: " + oidComision);
              UtilidadesLog.debug("tipoClientesCCabecera: " + tipoClientesCCabecera);
              UtilidadesLog.debug("codigoOrden: " + codigoOrden);
              
              comisionesClientesLocal = comisionesClientesLocalHome.create(oidComision, tipoClientesCCabecera, codigoOrden);
              
              java.sql.Date fechaAntDesde = dtoComisionesClientes.getFecAntiguedadDesde();
              java.sql.Date fechaAntHasta = dtoComisionesClientes.getFecAntiguedadHasta();
              Long SGV = dtoComisionesClientes.getOidSubgerencia();
              Long region = dtoComisionesClientes.getOidRegion();
              Long seccion = dtoComisionesClientes.getOidSeccion();
              Long zona = dtoComisionesClientes.getOidZona();
              Long territorio = dtoComisionesClientes.getOidTerritorio();
              BigDecimal bigTopeMinimo = dtoComisionesClientes.getTopeMinimo();
              BigDecimal bigTopeMaximo = dtoComisionesClientes.getTopeMaximo();
              
              comisionesClientesLocal.setFecAntiguedadDesde(fechaAntDesde);
              comisionesClientesLocal.setFecAntiguedadHasta(fechaAntHasta);
              comisionesClientesLocal.setSubgerenciaVentas(SGV);
              comisionesClientesLocal.setRegion(region);
              comisionesClientesLocal.setSeccion(seccion);
              comisionesClientesLocal.setZonas(zona);
              comisionesClientesLocal.setTerritorio(territorio);
              comisionesClientesLocal.setTopeMaximo(bigTopeMaximo);
              comisionesClientesLocal.setTopeMinimo(bigTopeMinimo);
              
              comisionesClientesLocalHome.merge(comisionesClientesLocal);
          }
       
       UtilidadesLog.info("MONMantenimientoComisionesBean.guardarComisionesClientes(ArrayList clientes, Long oidComision): Salida");   
      } catch(PersistenceException e) {
           ctx.setRollbackOnly();
           UtilidadesLog.error("ERROR ", e);
           throw new MareException(e,
                  UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }                                                            

  }
  
  /**
   * @author: ssantana, 29/3/2005
   * @throws es.indra.mare.common.exception.MareException   
   */
  private void guardarComisionesProductos(ArrayList productos, Long oidComision) 
    throws MareException {
      UtilidadesLog.info("MONMantenimientoComisionesBean.guardarComisionesProductos(ArrayList productos, Long oidComision): Entrada");
      DTOComisionesProductos dtoComisionesProductos = null;
      ComisionesProductosLocalHome comisionesProductosLocalHome = null;
      ComisionesProductosLocal comisionesProductosLocal = null;
      
      Iterator it = productos.iterator();
      try 
      {
          comisionesProductosLocalHome = this.getComisionesProductosLocalHome();
          while( it.hasNext() )
          {
            dtoComisionesProductos = (DTOComisionesProductos) it.next();
            
            Integer codigo = dtoComisionesProductos.getId();
            Long oidTipoProducto = dtoComisionesProductos.getOidTipoProducto();
            Long oidTipoInsercionProducto = dtoComisionesProductos.getOidTipoInsercionProductos();
          
            //comisionesProductosLocal = comisionesProductosLocalHome.create(codigo, oidComision, oidTipoProducto);
            comisionesProductosLocal = comisionesProductosLocalHome.create(codigo, oidComision, oidTipoProducto, oidTipoInsercionProducto);
            //Long comisionProductos = dtoComisionesProductos.get
            
            Long generico = dtoComisionesProductos.getOidGenerico();
            Long marcaProducto = dtoComisionesProductos.getOidMarcaProducto();
            Long negocio = dtoComisionesProductos.getOidNegocio();
            Long uNegocio = dtoComisionesProductos.getOidUnidadNegocio();
            Long producto = dtoComisionesProductos.getOidProducto();
            Long superGenerico = dtoComisionesProductos.getOidSupergenerico();
            Long cicloVida = dtoComisionesProductos.getOidCicloVida();
            Long tipoOferta = dtoComisionesProductos.getOidTipoOferta();
            Long comisionProducto = dtoComisionesProductos.getOidComisionProducto();
            //Long tipoInsercionProductos = dtoComisionesProductos.getOidTipoInsercionProductos();
            
            comisionesProductosLocal.setGenerico(generico);
            comisionesProductosLocal.setMarcaProducto(marcaProducto);
            comisionesProductosLocal.setNegocio(negocio);
            comisionesProductosLocal.setUnidadNegocio(uNegocio);
            comisionesProductosLocal.setProducto(producto);
            comisionesProductosLocal.setSuperGenerico(superGenerico);
            comisionesProductosLocal.setCicloVida(cicloVida);
            comisionesProductosLocal.setTipoOferta(tipoOferta);
            comisionesProductosLocal.setComisionProducto(comisionProducto);

            //comisionesProductosLocal.setComisionProducto(tipoInsercionProductos);
            //dtoComisionesProductos.get
            
            comisionesProductosLocalHome.merge(comisionesProductosLocal);
            
          }
          UtilidadesLog.info("MONMantenimientoComisionesBean.guardarComisionesProductos(ArrayList productos, Long oidComision): Salida");
      } catch(PersistenceException e) {
           ctx.setRollbackOnly();
           UtilidadesLog.error("ERROR ", e);
           throw new MareException(e,
                  UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }                                                            

  }
  
  /**
   * @author: ssantana, 29/3/2005
   * @throws es.indra.mare.common.exception.MareException
   * @param Long oidComision
   * @param ArrayList cobranzas
   */
  private void guardarComisionesCobranzas(ArrayList cobranzas, Long oidComision) throws MareException  {
      UtilidadesLog.info("MONMantenimientoComisionesBean.guardarComisionesCobranzas(ArrayList cobranzas, Long oidComision): Entrada");
      
      ComisionesCobranzasLocalHome comisionesCobranzasLocalHome = null;
      ComisionesCobranzasLocal comisionesCobranzasLocal = null;
      DTOComisionesCobranza dtoComisionesCobranza = null;      
      DAOMantenimientoComisiones daoMantenimientoComisiones = new DAOMantenimientoComisiones();

      Iterator it = cobranzas.iterator();
      try {
         comisionesCobranzasLocalHome = this.getComisionesCobranzasLocalHome();
         while (it.hasNext()) {
            dtoComisionesCobranza = (DTOComisionesCobranza) it.next();
            
            UtilidadesLog.debug("dtoComisionesCobranza " + dtoComisionesCobranza);
            
            Long tipoParticipante = dtoComisionesCobranza.getOidTipoParticipante();
            Integer diasTrasFacturacion = dtoComisionesCobranza.getDiasTrasFacturacion();
            
            comisionesCobranzasLocal = comisionesCobranzasLocalHome.create(oidComision, tipoParticipante);
            comisionesCobranzasLocal.setDiasTrasFacturacion(diasTrasFacturacion);
            
            comisionesCobranzasLocalHome.merge(comisionesCobranzasLocal);
            
            // Proceso Comisiones Cobranza Tipo Participante. 
            Long oidComisionesCobranzas = comisionesCobranzasLocal.getOid();
            ArrayList aListCobranzas = dtoComisionesCobranza.getComisionesCobranzasTipoParticipante();
            
            UtilidadesLog.debug("oidComisionesCobranza: "  + oidComisionesCobranzas);
            
            Iterator itTipoParticipantes = aListCobranzas.iterator();
            while (itTipoParticipantes.hasNext())   {
               DTOComisionesCobranzaTipoParticipante dtoComisionesTP = 
               (DTOComisionesCobranzaTipoParticipante) itTipoParticipantes.next();
                                                            
               this.guardarComisionesTP(dtoComisionesTP, oidComisionesCobranzas);
            }
            
            // sapaza -- PER-SiCC-2010-0478 -- 19/08/2010                
            // Proceso Comisiones Escalonada
            ArrayList aListEscalonada = dtoComisionesCobranza.getComisionesEscalonada();
            Iterator itEscalonada = aListEscalonada.iterator();
            while (itEscalonada.hasNext())   {
               DTOComisionesEscalonada dtoComisionesTP = (DTOComisionesEscalonada) itEscalonada.next();
                                                            
               daoMantenimientoComisiones.guardarComisionEscalonada(dtoComisionesTP, oidComisionesCobranzas);
            }
            
         }
         UtilidadesLog.info("MONMantenimientoComisionesBean.guardarComisionesCobranzas(ArrayList cobranzas, Long oidComision): Salida");
         
      } catch(PersistenceException e) {
           ctx.setRollbackOnly();
           UtilidadesLog.error("ERROR ", e);
           throw new MareException(e,
                  UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }                                                            

  }
  
  /**
   * @author: ssantana, 30/3/2005
   * @throws es.indra.mare.common.exception.MareException
   * @param Long oidCobranza
   * @param DTOComisionesCobranzaTipoParticipante dtoVentas
   */
  private void guardarComisionesTP(DTOComisionesCobranzaTipoParticipante dtoCobranzaTP, 
     Long oidCobranza) throws MareException {
     UtilidadesLog.info("MONMantenimientoComisionesBean.guardarComisionesTP(DTOComisionesCobranzaTipoParticipante dtoCobranzaTP, Long oidCobranza): Entrada");
     
     ComisionesCobranzasTipoParticipanteLocalHome comisionesTPLocalHome = null;
     ComisionesCobranzasTipoParticipanteLocal comisionesTPLocal = null;
     
     UtilidadesLog.debug("dtoCobranzaTP: "  + dtoCobranzaTP);
     
     try {
      comisionesTPLocalHome = this.getComisionesCobranzasTipoParticipanteLocalHome();
      Integer tramo = dtoCobranzaTP.getNivelTramo();
      BigDecimal porcentajeRecuperacion = dtoCobranzaTP.getPorcentajeRecuperacion();
      BigDecimal porcentajeComision = dtoCobranzaTP.getPorcentajeComision();
      comisionesTPLocal = comisionesTPLocalHome.create(tramo, 
                                                       porcentajeRecuperacion, 
                                                       oidCobranza,
                                                       porcentajeComision);
          
      Integer numDiasComision = dtoCobranzaTP.getDiasComision();
      //Integer numDiasComision = comisionesTPLocal.getDiasComision();
      comisionesTPLocal.setDiasComision(numDiasComision);
      
      // vbongiov -- Cambio 20090913 -- 5/08/2009
      comisionesTPLocal.setPorcentajeActividad(dtoCobranzaTP.getPorcentajeActividad());

      // sapaza -- PER-SiCC-2010-0478 -- 19/08/2010
      comisionesTPLocal.setPorcentajeComisionActividad(dtoCobranzaTP.getPorcentajeComisionActividad());
      
      comisionesTPLocalHome.merge(comisionesTPLocal);
      
      UtilidadesLog.info("MONMantenimientoComisionesBean.guardarComisionesTP(DTOComisionesCobranzaTipoParticipante dtoCobranzaTP, Long oidCobranza): Salida");
      
     } catch(PersistenceException e) {
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e,
                 UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
     }                                                            

  }
  
  /**
   * @author: ssantana, 29/3/2005
   * @throws es.indra.mare.common.exception.MareException
   * @param Long oidComision
   * @param DTOComisionesVentas dtoVentas
   */
  private void guardarComisionesVentas(DTOComisionesVentas dtoVentas, Long oidComision) 
   throws MareException  {
      UtilidadesLog.info("MONMantenimientoComisionesBean.guardarComisionesVentas(DTOComisionesVentas dtoVentas, Long oidComision): Entrada");
      ComisionesVentasLocalHome comisionesVentasLocalHome = null;
      ComisionesVentasLocal comisionesVentasLocal = null;
      
      try {
        comisionesVentasLocalHome = this.getComisionesVentasLocalHome();
        comisionesVentasLocal = comisionesVentasLocalHome.create(oidComision, dtoVentas.getOidFormula());
        
        Boolean calculoIncobrables = dtoVentas.getCalculoIncobrables();
        Boolean fechaEmisionInc = dtoVentas.getCalculoIncobrablesFechaEmision();
        Boolean fechaVencInc = dtoVentas.getCalculoIncobrablesFechaVencimiento();
        Integer numeroDiasInc = dtoVentas.getDiasIncobrables();
        Boolean indDevoluciones = dtoVentas.getDevoluciones();
        Boolean indAnulaciones = dtoVentas.getAnulaciones();
        Boolean indFaltantesNoAnunciados = dtoVentas.getFaltantesNoAnunciados();
        BigDecimal porcentajeComision = dtoVentas.getPorcentajeComision();
        BigDecimal importeFijoComision = dtoVentas.getImporteFijoComision();
        Long oidTipoComisionVtaIncremental = dtoVentas.getOidTipoComisionVentaIncremental();
        Long oidTipoComisionVta = dtoVentas.getOidTipoComisionVenta();
        
        comisionesVentasLocal.setCalculoIncobrables(calculoIncobrables);
        comisionesVentasLocal.setCalculoIncobrablesFechaEmision(fechaEmisionInc);
        comisionesVentasLocal.setCalculoIncobrablesFechaVencimiento(fechaVencInc);
        comisionesVentasLocal.setDiasIncobrables(numeroDiasInc);
        comisionesVentasLocal.setDevoluciones(indDevoluciones);
        comisionesVentasLocal.setAnulaciones(indAnulaciones);
        comisionesVentasLocal.setFaltantesNoAnunciados(indFaltantesNoAnunciados);
        comisionesVentasLocal.setPorcentajeComision(porcentajeComision);
        comisionesVentasLocal.setImporteFijoComision(importeFijoComision);
        comisionesVentasLocal.setTipoComisionVtaIncremental(oidTipoComisionVtaIncremental);
        comisionesVentasLocal.setTipoComisionVta(oidTipoComisionVta);
        
        comisionesVentasLocalHome.merge(comisionesVentasLocal);
        
        UtilidadesLog.info("MONMantenimientoComisionesBean.guardarComisionesVentas(DTOComisionesVentas dtoVentas, Long oidComision): Salida"); 
      } catch(PersistenceException e) {
           ctx.setRollbackOnly();
           UtilidadesLog.error("ERROR ", e);
           throw new MareException(e,
                  UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }                                                            

      
  }
  
  private void guardarComisionesVentasHistoricas(DTOComisionesVentasHistoricas dtoVentasHistoricas, 
  Long oidComision) throws MareException  {
    UtilidadesLog.info("MONMantenimientoComisionesBean.guardarComisionesVentasHistoricas(DTOComisionesVentasHistoricas dtoVentasHistoricas, Long oidComision): Entrada");
    ComisionesVentaHistoricaLocalHome comisionesVHLocalHome = null;
    ComisionesVentaHistoricaLocal comisionesVHLocal = null;
    
    try 
    {
        comisionesVHLocalHome = this.getComisionesVentaHistoricaLocalHome();
        Long periodoInicial = dtoVentasHistoricas.getOidPeriodoInicio();
        Long periodoFinal = dtoVentasHistoricas.getOidPeriodoFinal();
        
        comisionesVHLocal = comisionesVHLocalHome.create(oidComision, periodoFinal, periodoInicial);
        
        BigDecimal porcentajeIncremento = dtoVentasHistoricas.getPorcentajeIncremento();
        BigDecimal montoIncremento = dtoVentasHistoricas.getMontoIncremento();
        Boolean indDevoluciones = dtoVentasHistoricas.getDevoluciones();
        Boolean indAnulaciones = dtoVentasHistoricas.getAnulaciones();
        
        comisionesVHLocal.setPorcentajeIncremento(porcentajeIncremento);
        comisionesVHLocal.setMontoIncremento(montoIncremento);
        comisionesVHLocal.setDevoluciones(indDevoluciones);
        comisionesVHLocal.setAnulaciones(indAnulaciones);
        
        comisionesVHLocalHome.merge(comisionesVHLocal);        
        
        UtilidadesLog.info("MONMantenimientoComisionesBean.guardarComisionesVentasHistoricas(DTOComisionesVentasHistoricas dtoVentasHistoricas, Long oidComision): Salida");   
        
    } catch(PersistenceException e) {
         ctx.setRollbackOnly();
         UtilidadesLog.error("ERROR ", e);
         throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
    }                                                            

  }
  
  /**
   * @author: ssantana, 28/3/2005
   * @return Vector
   * @param Vector v
   * @param Collection col
   */
  private Vector anyadeTuplasComisionesTP(Collection col, Vector v) {
      UtilidadesLog.info("MONMantenimientoComisionesBean.anyadeTuplasComisionesTP(Collection col, Vector v): Entrada");
      // Recibe una Collection de Locals de tipo ComisionesCobranzasTipoParticipanteLocal
      // y las va agregando al Vector v. 
      // 
      // Retorna v.
      
     Iterator it = col.iterator();
     ComisionesCobranzasTipoParticipanteLocal comisionesTPLocal = null;
     while (it.hasNext())
     {
        comisionesTPLocal = null;
        comisionesTPLocal = (ComisionesCobranzasTipoParticipanteLocal)it.next();
        v.add(comisionesTPLocal);
     }
     UtilidadesLog.info("MONMantenimientoComisionesBean.anyadeTuplasComisionesTP(Collection col, Vector v): Salida");
     return v;
  }


  /** 
  * Metodo ...
  * @param DTOBelcorp dto
  * @return DTOSalida
  * @exception MareException 
  * @author Carlos Leal
  * @referencia SICC-DMCO-COM-201-334-N033-1
  */
  public DTOSalida obtenerTiposClienteCOM(DTOBelcorp dto) throws MareException{
    UtilidadesLog.info("MONMantenimientoComisionesBean.obtenerTiposClienteCOM(DTOBelcorp dto): Entrada");
    
    DAOMantenimientoComisiones dao = new DAOMantenimientoComisiones();
    DTOSalida dtoSalida = null;
    dtoSalida = dao.obtenerTiposClienteCOM(dto);    
    
    UtilidadesLog.info("MONMantenimientoComisionesBean.obtenerTiposClienteCOM(DTOBelcorp dto): Salida");
    return dtoSalida;
    
    }


  /** 
  * Metodo ...
  * @param DTOBelcorp dto
  * @return DTOSalida
  * @exception MareException 
  * @author Carlos Leal
  * @referencia SICC-DMCO-COM-201-334-N033-1
  */

  public DTOSalida obtenerTiposParticipantes(DTOBelcorp dto) throws MareException{
    UtilidadesLog.info("MONMantenimientoComisionesBean.obtenerTiposParticipantes(DTOBelcorp dto): Entrada");
    
    DAOMantenimientoComisiones dao = new DAOMantenimientoComisiones();
    DTOSalida dtoSalida = null;
    dtoSalida = dao.obtenerTiposParticipantes(dto);
    
    UtilidadesLog.info("MONMantenimientoComisionesBean.obtenerTiposParticipantes(DTOBelcorp dto): Salida");
    return dtoSalida;
    }

  /** 
  * Metodo ...
  * @param DTOBelcorp dto
  * @return DTOSalida
  * @exception MareException 
  * @author Carlos Leal
  * @referencia SICC-DMCO-COM-201-334-N033-1
  */
  public DTOSalida obtenerTiposComisionesVenta(DTOBelcorp dto) throws MareException{
    UtilidadesLog.info("MONMantenimientoComisionesBean.obtenerTiposComisionesVenta(DTOBelcorp dto): Entrada");
    
    DAOMantenimientoComisiones dao = new DAOMantenimientoComisiones();    
    DTOSalida dtoSalida = null;
    dtoSalida = dao.obtenerTiposComisionesVenta(dto);
    
    UtilidadesLog.info("MONMantenimientoComisionesBean.obtenerTiposComisionesVenta(DTOBelcorp dto): Salida");
    return dtoSalida;
    
    }


  /** 
  * Metodo ...
  * @param DTOBelcorp dto
  * @return DTOSalida
  * @exception MareException 
  * @author Carlos Leal
  * @referencia SICC-DMCO-COM-201-334-N033-1
  */
  public DTOSalida obtenerTiposComisionesVentaIncremental(DTOBelcorp dto) throws MareException{
    UtilidadesLog.info("MONMantenimientoComisionesBean.obtenerTiposComisionesVentaIncremental(DTOBelcorp dto): Entrada");
    
    DAOMantenimientoComisiones dao = new DAOMantenimientoComisiones();
    DTOSalida dtoSalida = null;
    dtoSalida = dao.obtenerTiposComisionesVentaIncremental(dto);
    
    UtilidadesLog.info("MONMantenimientoComisionesBean.obtenerTiposComisionesVentaIncremental(DTOBelcorp dto): Salida");    
    return dtoSalida;
    
    }


  /** 
  * Metodo ...
  * @param DTOBelcorp dto
  * @return DTOSalida
  * @exception MareException 
  * @author Carlos Leal
  * @referencia SICC-DMCO-COM-201-334-N033-1
  */
  public DTOSalida obtenerFormulas(DTOBelcorp dto) throws MareException{
    UtilidadesLog.info("MONMantenimientoComisionesBean.obtenerFormulas(DTOBelcorp dto): Entrada");
    
    DAOMantenimientoComisiones dao = new DAOMantenimientoComisiones();
    DTOSalida dtoSalida = null;
    dtoSalida = dao.obtenerFormulas(dto);
    
    UtilidadesLog.info("MONMantenimientoComisionesBean.obtenerFormulas(DTOBelcorp dto): Salida");
    return dtoSalida;
    
    
    }
    
     /** 
  * Metodo ...
  * @param DTORepCargaComision dto
  * @return DTOSalida
  * @exception MareException 
  * @author mdolce
  * @referencia --
  */
  public DTOSalida recCargaComision(DTORepCargaComision dtoIn) throws MareException{
    UtilidadesLog.info("MONMantenimientoComisionesBean.recCargaComision(DTORepCargaComision dtoIn): Entrada");
    
    DAOMantenimientoComisiones dao = new DAOMantenimientoComisiones();
    DTOSalida dtoSalida = null;
    dtoSalida = dao.recCargaComision(dtoIn);
    
    UtilidadesLog.info("MONMantenimientoComisionesBean.recCargaComision(DTORepCargaComision dtoIn): Salida");
    return dtoSalida;
    
    
    }
    
   
     /**
     * @author pperanzola
     * @date 03/06/2005
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoE
     * modificaciones 19/07/2005 - pperanzola - se modificó el diseño.
     */
    public void calcularMetas(DTOOID dtoE) throws MareException {   
        UtilidadesLog.info("MONMantenimientoComisionesBean.calcularMetas(DTOOID dtoE): Entrada");
       
        BigDecimal totalizador;
        BigDecimal tmpComisionable;
        BigDecimal tmpRsBigD;
        ComisionesMetasLocal comisionesMetas=null;
        ComisionesMetasLocalHome comisionesMetasLH=null;
        ComisionesVentasLocal comisionVenta=null;
        ComisionesVentasLocalHome oComiVentasLH= null;
        DAOMantenimientoComisiones daoManCom = new DAOMantenimientoComisiones();
        DAOCalcularComisiones daoCalcComis =new DAOCalcularComisiones();
        DTODatosCalculosComision dtoCalculoComision =null;
        DTOComisiones dtoComision = null;
        DTOComisionesAccesos dTOComisionesAccesos = null;
        DTOComisionesVentasHistoricas dtoVtaHisto = null;
        DTOGerenteZona dtoGerenteZona= null;
        DTOOIDs periodos =null;
        DTOSalida consolidados = null;
        DTOSalida consultoras = null;
        DTOSalida gerentes = null;
        DTOSalida solicitudes= null;
        DTOSolicitudPosicion posicion = null;
        DAOClasificarComisiones daoClasiComi = new DAOClasificarComisiones();
        int cantComisionesAcceso;
        int cantConsoli;
        int cantConsultoras;
        int cantGtes;
        int cantPeri;
        int cantSolicitudes;
        int i;
        int iGtes;
        int iComisionesAcceso;
        int iConsult;
        int iConsoli;
        int iSolicitudes;
        Long accesosOidClie;
        Long subtipoCliente;
        Long tmpOidClie;
        Long tmpOidConsoli;
        Long tmpSolOidTipoSoliPais;
        Long[] accesos = null;
        Long[] vecPeriodos=null;
        MONPeriodos monPeri = null;
        MONPeriodosHome monPeriH = null;
        Object tmpRs;
        PlantillasComisionesPaisLocal plantillaComisionesPais = null;
        PlantillasComisionesPaisLocalHome pComisionesPaisLH = null;
        RecordSet rsConsultoras = null;
        RecordSet rsConsolidados = null;
        RecordSet rsGerentes = null;
        RecordSet rsSolicitudes = null;
        TiposSolicitudLocal tipoSolic = null;
        TiposSolicitudLocalHome tipoSolicLH = null;
        TiposSolicitudPaisLocal tipoSolicPais = null;
        TiposSolicitudPaisLocalHome tipoSolicPaisLH = null;
        try{                
                daoManCom.elminarComisionesMetas(dtoE);
                dtoComision= consultarComisiones(dtoE);
                dtoVtaHisto = dtoComision.getComisionesVentaHistorica();
                // SEGUN INCIDENCIA BELC300018789
                try {
                    pComisionesPaisLH = getPlantillasComisionesPaisLocalHome();
                    plantillaComisionesPais = pComisionesPaisLH.findByPrimaryKey(dtoComision.getOidPlantillasComisionesPais());
                } catch (NoResultException nre) {
                    ctx.setRollbackOnly();
                     UtilidadesLog.error("ERROR ", nre);
                    throw new MareException(nre,        
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                } catch (PersistenceException pe) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("ERROR ", pe);
                    throw new MareException(pe,
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
                dtoComision.setOidPais(plantillaComisionesPais.getOidPais());
                UtilidadesLog.debug(">>>>>> obtuve: plantillaComisionesPais\n");
                
                dtoCalculoComision  = new DTODatosCalculosComision();
                // FIN BELC300018789
                // SEGUN INCIDENCIA BELC300018997 
                dtoCalculoComision.setOidPais(plantillaComisionesPais.getOidPais());
                UtilidadesLog.debug(">>>>>> dtoVtaHisto" + dtoVtaHisto + "\n");
                //UtilidadesLog.info(">>>>>> getOidTipoComisionVentaIncremental()" + 
                //                    dtoComision.getComisionesVentas().getOidTipoComisionVentaIncremental() + "\n");
                if (dtoVtaHisto != null && 
                    ConstantesCOM.COMISION_SOBRE_INCREMENTO.equals(
                                dtoComision.getComisionesVentas().getOidTipoComisionVenta())){
                    UtilidadesLog.debug(">>>>>> CAMBIO 19/07/2005 getOidTipoComisionVenta()" + 
                                    dtoComision.getComisionesVentas().getOidTipoComisionVenta() + "\n");
                    try {
                        tipoSolicLH = new TiposSolicitudLocalHome();
                        oComiVentasLH = getComisionesVentasLocalHome();
                        tipoSolicPaisLH = new TiposSolicitudPaisLocalHome();
                        
                        monPeriH = getMONPeriodosHome();   
                        monPeri = monPeriH.create();
                        periodos = monPeri.obtienePeriodosEntre(dtoVtaHisto.getOidPeriodoInicio(), dtoVtaHisto.getOidPeriodoFinal());               
                        
                     }
                     catch (NamingException nex) {
                        UtilidadesLog.error(nex);
                        throw new MareException(nex, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                     }
                     catch (CreateException cex) {                     
                        UtilidadesLog.error(cex);   
                        throw new MareException(cex, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                     }
                     catch (RemoteException rex) {
                        UtilidadesLog.error(rex);
                        throw new MareException(rex, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                     }
                     UtilidadesLog.debug(">>>>>> obtuve periodos correctamente\n");
                     vecPeriodos  = periodos.getOids();
                     cantPeri = vecPeriodos.length;
                     UtilidadesLog.debug(" >>>>>>cantidad de peridodos: " + cantPeri );
                     //(A) Por cada elemento de periodos hacer lo siguiente
// Agregado por Inc. BELC300022852 alorenzo 07/04/2006                     
                     Collection comisionesClientes = this.getComisionesClientesLocalHome().findByComision(dtoComision.getOid());
                     ComisionesClientesLocal comisionesClientesLocal = null;                     
// Fin Agregado por Inc. BELC300022852 alorenzo 07/04/2006                                          
                     for (i = 0; i <cantPeri; i++){
                         UtilidadesLog.debug(" >>>>>>Por cada elemento de periodos hacer lo siguiente\n");
                         //se cambia la llamada al metodo segun BELC300018941 se le pasa el dto
                         gerentes = daoClasiComi.recuperarGerentes(dtoComision); 
                         rsGerentes = gerentes.getResultado();
                         cantGtes = rsGerentes.getRowCount();
                         UtilidadesLog.debug(" >>>>>>cantidad de gerentes: " + cantGtes );
                         //(B) Por cada elemento de gerentes hacer lo siguiente
                         for (iGtes = 0; iGtes <cantGtes; iGtes++){
                            UtilidadesLog.debug("(B) Por cada elemento de gerentes hacer lo siguiente\n");
                            //dtoCalculoComision.getOidPlantillasComisionesPais(dtoComision.getOidPlantillasComisionesPais()); SE COMENTA SEGUN BELC300018789
                            totalizador = new BigDecimal(0);
                            dtoGerenteZona = new DTOGerenteZona();
 // Agregado por Inc. BELC300022852 alorenzo 07/04/2006    
                            Iterator it = comisionesClientes.iterator();                                             
                            //(B.1) Por cada elemento de comisionesClientes hacer lo siguiente:
                            while(it.hasNext()){
                                comisionesClientesLocal = (ComisionesClientesLocal) it.next();
                                dtoCalculoComision.setOidSV(comisionesClientesLocal.getSubgerenciaVentas());
                                dtoCalculoComision.setOidRegion(comisionesClientesLocal.getRegion());
                                dtoCalculoComision.setOidZona(comisionesClientesLocal.getZonas());
                                dtoCalculoComision.setOidSeccion(comisionesClientesLocal.getSeccion());                         
 // Fin Agregado por Inc. BELC300022852 alorenzo 07/04/2006                                                                     
                                tmpOidClie = new Long (((BigDecimal)rsGerentes.getValueAt(iGtes,"OID_CLIE")).longValue());
                                UtilidadesLog.debug("obtuve tmpOidCliente: " + tmpOidClie);
                                dtoGerenteZona = daoCalcComis.validarGerente( tmpOidClie ,dtoCalculoComision);
                                UtilidadesLog.debug(" obtuve correctamente dtoGerenteZona\n");
                                //(C) Si dtoGerenteZona != null 
                                if (dtoGerenteZona != null){
                                      UtilidadesLog.debug("dtoGerenteZona es <> de null \n");
                                      consultoras = daoCalcComis.recuperarConsultoras(vecPeriodos[i] , dtoGerenteZona);
                                      rsConsultoras =  consultoras.getResultado();
                                      cantConsultoras = rsConsultoras.getRowCount();
                                      UtilidadesLog.debug("### Cantidad de consultoras" + cantConsultoras + "\n");
                                      //(D) Por cada una de las consultoras hacer lo siguiente: 
                                      for (iConsult = 0; iConsult < cantConsultoras; iConsult++){
                                          UtilidadesLog.debug("entre por cada una de las consultoras \n");
                                          cantComisionesAcceso = dtoComision.getComisionesAccesos().toArray().length;
                                          UtilidadesLog.debug(">>>>>>>> cantComisionesAcceso = \n" + cantComisionesAcceso);
                                          accesos = new Long[cantComisionesAcceso];
                                          //  recorro el dtoComision porque devuelve un arraylist pero de DTOsComisionesAccesos
                                          for (iComisionesAcceso = 0; iComisionesAcceso< cantComisionesAcceso; iComisionesAcceso++){
                                            dTOComisionesAccesos = (DTOComisionesAccesos)dtoComision.getComisionesAccesos().get(iComisionesAcceso);
                                            accesos[iComisionesAcceso]= dTOComisionesAccesos.getOid();
                                          }
                                          UtilidadesLog.debug("accesos \n" + accesos);
                                          UtilidadesLog.debug(">>>>>>>> rsConsultoras \n");
                                          accesosOidClie = new Long(((BigDecimal) rsConsultoras.getValueAt(iConsult,"CLIE_OID_CLIE")).longValue());
                                          UtilidadesLog.debug("accesosOidClie \n" + accesosOidClie);
                                          consolidados = daoCalcComis.recuperarConsolidados(vecPeriodos[i]
                                                                                            ,accesosOidClie
                                                                                            ,accesos); 
                                        
                                          try {
                                            //segun incidencia BELC300018942 
                                            comisionVenta = oComiVentasLH.findByUK(dtoE.getOid());
                                            
                                          } catch (NoResultException nre) {
                                              ctx.setRollbackOnly();
                                               UtilidadesLog.error("ERROR ", nre);
                                              throw new MareException(nre,        
                                                  UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                                          } catch (PersistenceException pe) {
                                              ctx.setRollbackOnly();
                                              UtilidadesLog.error("ERROR ", pe);
                                              throw new MareException(pe,
                                                  UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                                          }
                                          
                                          UtilidadesLog.debug("obtuve comisionVenta correctamente \n");
                                          rsConsolidados = consolidados.getResultado();
                                          cantConsoli = rsConsolidados.getRowCount();
                                          UtilidadesLog.debug(" >>>>>>cantidad de cantConsoli: " + cantConsoli );
                                          //(E) Por cada consolidado se hace lo siguiente: 
                                          for (iConsoli = 0 ; iConsoli<cantConsoli ; iConsoli ++){
                                              UtilidadesLog.debug("(E) Por cada consolidado se hace lo siguiente \n");
                                              tmpOidConsoli =new Long (((BigDecimal) rsConsolidados.getValueAt(iConsoli,"oid_soli_cabe")).longValue());
                                              solicitudes = daoCalcComis.recuperarSolicitudes(tmpOidConsoli);
                                              rsSolicitudes = solicitudes.getResultado();
                                              cantSolicitudes = rsSolicitudes.getRowCount();
                                              UtilidadesLog.debug(" >>>>>>cantidad de cantSolicitudes: " + cantSolicitudes );
                                              //Por cada una de las solicitud-posicion devueltas por el recorset hacer: 
                                              for (iSolicitudes = 0; iSolicitudes < cantSolicitudes; iSolicitudes++){
                                                  try{
                                                    UtilidadesLog.debug("Por cada una de las solicitud-posicion devueltas por el recorset hacer:\n");
                                                    
                                                    tmpSolOidTipoSoliPais = new Long (((BigDecimal) rsSolicitudes.getValueAt(
                                                                                                        iSolicitudes,"tiposolicitudpais")).longValue());
                                                    tipoSolicPais = tipoSolicPaisLH.findByPrimaryKey(tmpSolOidTipoSoliPais);
            
                                                    tipoSolic = tipoSolicLH.findByPrimaryKey(tipoSolicPais.getOidTipoSolicitud());
                                                  } 
                                                  catch (NoResultException fex3) {
                                                        UtilidadesLog.debug(fex3);
                                                        throw new MareException(fex3, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                                                  }
                                                    UtilidadesLog.debug("obtuvo correctamente tipoSolic\n");
                                                    UtilidadesLog.debug(" >>>>>> tipoSolic\n" + tipoSolicPais.getIndComisionable());
                                                    //(1)
                                                    if (Boolean.TRUE.equals(tipoSolicPais.getIndComisionable())){
                                                    //(2)
                                                        UtilidadesLog.debug(" >>>>>> Devoluciones()\n" + comisionVenta.getDevoluciones());
                                                        UtilidadesLog.debug(" >>>>>> Anulaciones()\n" + comisionVenta.getAnulaciones());
                                                        UtilidadesLog.debug(" >>>>>> tipoSolic.Devoluciones()()\n" + tipoSolic.getIndDevoluciones());
                                                        UtilidadesLog.debug(" >>>>>> tipoSolic.IndAnulacion()\n" + tipoSolic.getIndAnulacion());
                                                        UtilidadesLog.debug(" >>>>>> Anulaciones()\n" + comisionVenta.getAnulaciones());
                                                        if ((Boolean.TRUE.equals(comisionVenta.getDevoluciones()) &&
                                                             Boolean.TRUE.equals(comisionVenta.getAnulaciones()))
                                                             || !((Boolean.FALSE.equals(comisionVenta.getDevoluciones()) &&
                                                                   Boolean.TRUE.equals(tipoSolic.getIndDevoluciones()))
                                                                   ||  (Boolean.FALSE.equals(comisionVenta.getAnulaciones())&& 
                                                                        Boolean.TRUE.equals(tipoSolic.getIndAnulacion())))){
                                                            UtilidadesLog.debug(" pasa por if (1) y (2) ");
                                                            //Crear un DTOSolicitudPosicion posicion y 
                                                            posicion = new DTOSolicitudPosicion();
                                                            //setearle los atributos que correspondan con los datos del 
                                                            //registro de posicion actual 
                                                            UtilidadesLog.debug(" >>>>>> iSolicitudes \n" + iSolicitudes);
                                                            tmpRsBigD = (BigDecimal) rsSolicitudes.getValueAt(iSolicitudes,"PRECIOCATALOGO");
                                                            UtilidadesLog.debug(" >>>>>> preciocatalogo \n" + tmpRsBigD);
                                                            posicion.setPrecioCatalogoTotalLocal(tmpRsBigD);
                                                            tmpRsBigD = (BigDecimal) rsSolicitudes.getValueAt(iSolicitudes,"PRECIOFACTURA");
                                                            UtilidadesLog.debug(" >>>>>> preciofactura \n" + tmpRsBigD);
                                                            posicion.setPrecioFacturaTotalLocal(tmpRsBigD);
                                                            tmpRsBigD = (BigDecimal) rsSolicitudes.getValueAt(iSolicitudes,"PRECIONETO");
                                                            UtilidadesLog.debug(" >>>>>> precioneto \n" + tmpRsBigD);
                                                            posicion.setPrecioNetoTotalLocal(tmpRsBigD);
                                                            tmpRs = rsSolicitudes.getValueAt(iSolicitudes,"UNIDADESATENDIDAS");
                                                            UtilidadesLog.debug(" >>>>>> unidadesatendidas \n" + (BigDecimal)tmpRs);
                                                            posicion.setUnidadesAtendidas(validaBigDecimal((BigDecimal)tmpRs));
                                                            // fin armado DTO
                                                            UtilidadesLog.debug(" fin armado DTOposicion ");
                                                            //totalizador = totalizador + comisionable(comisionVenta.get(oidFormula)), posicion) 
                                                            tmpComisionable = comisionable(comisionVenta.getFormula(),posicion);
                                                            if (tmpComisionable == null){
                                                                tmpComisionable = new BigDecimal(0);
                                                            }                
                                                            UtilidadesLog.debug(" >>>>>>>>>>>>> tmpComisionable\n "+ tmpComisionable);
                                                            totalizador = totalizador.add(tmpComisionable);
                                                            UtilidadesLog.debug(" >>>>>> totalizador = " + totalizador.toString());
                                                        }//(2) fin si 
                                                    }//(1) fin si 
            
                                              }//pasar a la siguiete solicitud-posicion 
                                          }//(E) pasar al siguiente consolidado 
                                      }//(D) pasar a la siguiente consultora 
                                       
                                      subtipoCliente  = daoManCom.obtenerTipoSubtipoClientePorGerente(tmpOidClie,dtoE.getOid());
                                      try{
                                        UtilidadesLog.debug(" >>>>>> vecPeriodos["+ i +"]"+ vecPeriodos[i]);
                                        UtilidadesLog.debug(" >>>>>> dtoE.getOid()" + dtoE.getOid());
                                        UtilidadesLog.debug(" >>>>>> subtipoCliente" + subtipoCliente);
                                        UtilidadesLog.debug(" >>>>>> totalizador:" + totalizador.toString());
                                        
                                        comisionesMetasLH = getComisionesMetasLocalHome();
                                        comisionesMetas = comisionesMetasLH.create(vecPeriodos[i], dtoE.getOid()
                                                                ,subtipoCliente,  new Double(totalizador.doubleValue()));
                                        UtilidadesLog.debug(comisionesMetas);
                                        UtilidadesLog.debug(" >>>>>> finalizo asignacion:");
                                        
                                       } catch(PersistenceException e) {
                                            ctx.setRollbackOnly();
                                            UtilidadesLog.error("ERROR ", e);
                                            throw new MareException(e,
                                                   UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                                       }                                                            

                                      UtilidadesLog.debug(" obtuve correctamente comisionesMetas ");
                                }//(C)fin si 
// Agregado por Inc. BELC300022852 alorenzo 07/04/2006    
                            }//(B.1) pasar a la siguiente comisionCliente 
 // Fin Agregado por Inc. BELC300022852 alorenzo 07/04/2006                                                                     
                         }//(B) pasar al siguiente gerente
                     }//(A) pasar al siguiente periodo                    
                }//(0) Sino devolver el siguiente Mensaje COM-0015
                else { 
                    throw new MareException ( null, null, UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_COM
                                                                                            , "", ErroresDeNegocio.COM_0015));
                        
                }
                UtilidadesLog.info("MONMantenimientoComisionesBean.calcularMetas(DTOOID dtoE): Salida");
        }
        catch(Exception ex5){
            UtilidadesLog.error(ex5);
            ctx.setRollbackOnly();        
            throw new MareException(ex5);
        }
    }
    
    
    /**
     * 
     * @date 02/06/2005 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param posicion
     * @param oidFormula
     * @author pperanzola
     * comisionable(oidFormula:Long ; posicion: DTOSolicitudPosicion):BigDecimal
        unidades = posicion.get(unidadesAtendidas) 
        Crear una entidad "Formula" 
        Switch formula.findByPK(oidFormula).get(oid_form) 
            case ConstantesCOM.VENTA_CATALOGO: 
                retornar (posicion.get(precioCatalogoTotalLocal) * unidades) 
            case ConstantesCOM.VENTA_FACTURA: 
                retornar (posicion.get(precioFacturaTotalLocal) * unidades) 
            case ConstantesCOM.VENTA_NETA: 
                retornar (posicion.get(precioNetoTotalLocal) * unidades) 
        Fin Switch 
     */
    private BigDecimal comisionable(Long oidFormula, DTOSolicitudPosicion posicion) 
        throws MareException {
        UtilidadesLog.info("MONMantenimientoComisionesBean.comisionable(Long oidFormula, DTOSolicitudPosicion posicion): Entrada");
        
        Long unidades = posicion.getUnidadesAtendidas();
        BigDecimal unidadesBigD = new BigDecimal( unidades.doubleValue());
        BigDecimal tmpRetorno= null;
        UtilidadesLog.debug(" >>>>>>>>>>>>> unidadesBigD\n "+ unidadesBigD);
        UtilidadesLog.debug(" >>>>>>>>>>>>> unidades\n "+ unidades);
        if (ConstantesCOM.VENTA_CATALOGO.equals(oidFormula)){
            tmpRetorno = posicion.getPrecioCatalogoTotalLocal().multiply(unidadesBigD);
        } else if (ConstantesCOM.VENTA_FACTURA.equals(oidFormula)){
            tmpRetorno = posicion.getPrecioFacturaTotalLocal().multiply(unidadesBigD);
        }else if (ConstantesCOM.VENTA_NETA.equals(oidFormula)){
            tmpRetorno = posicion.getPrecioNetoTotalLocal().multiply(unidadesBigD);
        }
        
        UtilidadesLog.debug(" >>>>>>>>>>>>> tmpRetorno\n " + tmpRetorno);
        UtilidadesLog.info("MONMantenimientoComisionesBean.comisionable(Long oidFormula, DTOSolicitudPosicion posicion): Salida");
        return tmpRetorno;
    }
    
    
        /** 
  * Metodo obtenerTramos
  * @param DTOBelcorp dto
  * @return DTOSalida
  * @exception MareException 
  * @author mdolce
  * @referencia --
  */
  public DTOSalida obtenerTramos(DTOOID dtoIn) throws MareException {
    UtilidadesLog.info("MONMantenimientoComisionesBean.obtenerTramos(DTOOID dtoIn): Entrada");
    
    DAOMantenimientoComisiones dao = new DAOMantenimientoComisiones();
    DTOSalida dtoSalida = null;
    dtoSalida = dao.obtenerTramos(dtoIn);
    
    UtilidadesLog.info("MONMantenimientoComisionesBean.obtenerTramos(DTOOID dtoIn): Salida");
    return dtoSalida;
  }
  
  
/** 
  * Metodo obtenerComisiones
  * @param DTOBelcorp dto
  * @return DTOSalida
  * @exception MareException 
  * @author mdolce
  * @referencia --
  */
  
  public DTOSalida obtenerComisiones(DTOBelcorp dto) throws MareException {
    UtilidadesLog.info("MONMantenimientoComisionesBean.obtenerComisiones(DTOBelcorp dto): Entrada");
    
    DAOMantenimientoComisiones dao = new DAOMantenimientoComisiones();
    DTOSalida dtoSalida = null;
    dtoSalida = dao.obtenerComisiones(dto);
    
    UtilidadesLog.info("MONMantenimientoComisionesBean.obtenerComisiones(DTOBelcorp dto): Salida");
    return dtoSalida;
  }
  
/** 
  * Metodo obtenerTramosPorComisionyPeriodo
  * @param DTOObtenerTramos dto
  * @return DTOSalida
  * @exception MareException 
  * @author mdolce
  * @referencia --
  */ 
   public DTOSalida obtenerTramosPorComisionyPeriodo(DTOObtenerTramos dto) throws MareException {
    UtilidadesLog.info("MONMantenimientoComisionesBean.obtenerTramosPorComisionyPeriodo(DTOObtenerTramos dto): Entrada");
    
    DAOMantenimientoComisiones dao = new DAOMantenimientoComisiones();
    DTOSalida dtoSalida = null;
    dtoSalida = dao.obtenerTramosPorComisionesyPeriodos(dto);
    
    UtilidadesLog.info("MONMantenimientoComisionesBean.obtenerTramosPorComisionyPeriodo(DTOObtenerTramos dto): Salida");
    return dtoSalida;
  }
  
  /** 
  * Metodo obtenerPeriodosPorComision
  * @param DTOOID dto
  * @return DTOSalida
  * @exception MareException 
  * @author mdolce
  * @referencia --
  */ 
   public DTOSalida obtenerPeriodosPorComision(DTOOID dto) throws MareException {
    UtilidadesLog.info("MONMantenimientoComisionesBean.obtenerPeriodosPorComision(DTOOID dto): Entrada");
    
    DAOMantenimientoComisiones dao = new DAOMantenimientoComisiones();
    DTOSalida dtoSalida = null;
    dtoSalida = dao.obtenerPeriodosPorComision(dto);
    
    UtilidadesLog.info("MONMantenimientoComisionesBean.obtenerPeriodosPorComision(DTOOID dto): Salida");
    return dtoSalida;
  }

  
  /**
     * funciones auxiliares para validacion de campos de rs
     * @date 
     * @return 
     * @param registroRs
     * @author pperanzola
     */
  private Long validaBigDecimal (BigDecimal registroRs){
    UtilidadesLog.info("MONMantenimientoComisionesBean.validaBigDecimal(BigDecimal registroRs): Entrada");
    Long tmp = null;
    if (registroRs != null ){
        tmp = new Long (registroRs.longValue());
    }
    UtilidadesLog.info("MONMantenimientoComisionesBean.validaBigDecimal(BigDecimal registroRs): Salida");
    return tmp;
  } 
  
  private Boolean validaBoolean (Long registroRs){
    UtilidadesLog.info("MONMantenimientoComisionesBean.validaBoolean(Long registroRs): Entrada");
    Boolean tmp = null;
    if (registroRs != null ){
        if (registroRs.longValue() == 1){
            tmp = Boolean.TRUE;
        }else{
            tmp = Boolean.FALSE;
        }
    }
    UtilidadesLog.info("MONMantenimientoComisionesBean.validaBoolean(Long registroRs): Salida");
    return tmp;
  }


    private MONGestionComisionesHome getMONGestionComisionesHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONGestionComisionesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGestionComisiones"), MONGestionComisionesHome.class);
  }


    private MONPeriodosHome getMONPeriodosHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONPeriodosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONPeriodos"), MONPeriodosHome.class);
    }
    
    private ComisionesAccesoLocalHome getComisionesAccesoLocalHome() throws MareException {      
       return new ComisionesAccesoLocalHome();
    }

    private ComisionesProductosLocalHome getComisionesProductosLocalHome() throws MareException {      
       return new ComisionesProductosLocalHome();
    }

    private ComisionesCobranzasLocalHome getComisionesCobranzasLocalHome() throws MareException {      
       return new ComisionesCobranzasLocalHome();
    }
    private ComisionesCobranzasTipoParticipanteLocalHome getComisionesCobranzasTipoParticipanteLocalHome() throws MareException {      
       return new ComisionesCobranzasTipoParticipanteLocalHome();
    }

    private ComisionesVentasLocalHome getComisionesVentasLocalHome() throws MareException {      
       return new ComisionesVentasLocalHome();
    }

    private ComisionesVentaHistoricaLocalHome getComisionesVentaHistoricaLocalHome() throws MareException {      
       return new ComisionesVentaHistoricaLocalHome();
    }

    private ComisionesClientesLocalHome getComisionesClientesLocalHome() throws MareException {      
       return new ComisionesClientesLocalHome();
    }

    private PlantillasComisionesPaisLocalHome getPlantillasComisionesPaisLocalHome() throws MareException {      
       return new PlantillasComisionesPaisLocalHome();
    }

    private PlantillasComisionesLocalHome getPlantillasComisionesLocalHome() throws MareException {      
       return new PlantillasComisionesLocalHome();
    }

    private PlantillasComisionesMarcaLocalHome getPlantillasComisionesMarcaLocalHome() throws MareException {      
       return new PlantillasComisionesMarcaLocalHome();
    }

    private PlantillasComisionesAccesoLocalHome getPlantillasComisionesAccesoLocalHome() throws MareException {      
       return new PlantillasComisionesAccesoLocalHome();
    }

    private ComisionesLocalHome getComisionesLocalHome() throws MareException {      
       return new ComisionesLocalHome();
    }

    private ComisionesMetasLocalHome getComisionesMetasLocalHome() throws MareException {      
       return new ComisionesMetasLocalHome();
    }    

}
