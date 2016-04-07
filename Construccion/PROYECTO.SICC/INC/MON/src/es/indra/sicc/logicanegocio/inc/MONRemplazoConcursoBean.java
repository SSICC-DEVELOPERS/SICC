package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.inc.DTOArticuloLoteColeccion;
import es.indra.sicc.dtos.inc.DTOReemplazoArticuloLote;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.dtos.pre.DTOEBuscarProductos;
import es.indra.sicc.entidades.inc.ContadorPremioArticuloLocal;
import es.indra.sicc.entidades.inc.ContadorPremioArticuloLocalHome;
import es.indra.sicc.entidades.inc.ReemplazoArticuloLoteLocal;
import es.indra.sicc.entidades.inc.ReemplazoArticuloLoteLocalHome;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternos;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternosHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.RecuperadorIdiomaDefectoServidor;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Timestamp;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import javax.rmi.PortableRemoteObject;


public class MONRemplazoConcursoBean implements SessionBean {
    private SessionContext _context;

    public void ejbCreate() {
    }

    public void setSessionContext(SessionContext context) throws EJBException {
        _context = context;
    }

    public void ejbRemove() throws EJBException {
    }

    public void ejbActivate() throws EJBException {
    }

    public void ejbPassivate() throws EJBException {
    }

    public DTOSalida obtenerConcursosNumeroNombre(DTOBelcorp dtoe) throws MareException {
         UtilidadesLog.info("MONRemplazoConcursoBean.obtenerConcursosNumeroNombre(DTOBelcorp dtoe): Entrada");   
         DAORemplazoPremios dao = new DAORemplazoPremios();
         DTOSalida dtoSalida = dao.obtenerConcursosNumeroNombre(dtoe);
         
         UtilidadesLog.info("MONRemplazoConcursoBean.obtenerConcursosNumeroNombre(DTOBelcorp dtoe): Salida");
         return dtoSalida;
    }

    public DTOSalida buscarPremiosConcurso(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("MONRemplazoConcursoBean.buscarPremioConcursoBean(DTOID dtoe): Entrada");    
        DAORemplazoPremios dao = new DAORemplazoPremios();
        DTOSalida dtoSalida = dao.buscarPremiosConcurso(dtoe);
        UtilidadesLog.info("MONRemplazoConcursoBean.buscarPremioConcursoBean(DTOID dtoe): Salida");
        return dtoSalida;
    }

    public DTOSalida obtenerReemplazo(DTOOID dteo) throws MareException {
        UtilidadesLog.info("MONRemoplazoConcursoBean.obtenerReemplazo(DTOBelcorp dtoe): Entrada");
        DAORemplazoPremios dao = new DAORemplazoPremios();
        DTOSalida dtoSalida = dao.obtenerReeplazo(dteo);
        UtilidadesLog.info("MONRemoplazoConcursoBean.obtenerReemplazo(DTOBelcorp dtoe): Salida");
        return dtoSalida;
    }

    public DTOSalida obtenerCriterioReemplazo(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("MONRemplazoConcursoBean.obtenerCriterioReemplazo(DTOBelcorp dtoe): Entrada");
        DAORemplazoPremios dao = new DAORemplazoPremios();
        DTOSalida dtoSalida = dao.obtenerCriterioDeReemplazo(dtoe);
        UtilidadesLog.info("MONRemplazoConcursoBean.obtenerCriterioReemplazo(DTOBelcorp dtoe): Salida");
        return dtoSalida;
    }


    public void guardar(DTOArticuloLoteColeccion dtoe) throws MareException {
        UtilidadesLog.info("MONRemplazoConcursoBean.guardar(DTOReemplazoArticuloLote dtoe): Entrada");
                DTOSalida dtoSalida = new DTOSalida();
                DAORemplazoPremios dao = new DAORemplazoPremios();
                Boolean inicio = true;
                ArrayList array = dtoe.getLista();
                ArrayList eliminados = dtoe.getRegistrosEliminados();
                UtilidadesLog.info("eliminados: " + eliminados);
                UtilidadesLog.info("array " + array);
                DTOReemplazoArticuloLote dta = null;
                DTOReemplazoArticuloLote oids = new DTOReemplazoArticuloLote();


               if(eliminados != null){
                   Iterator itElminados = eliminados.iterator();
                    while(itElminados.hasNext()){
                                String parametro  = (String) itElminados.next();
                                UtilidadesLog.info("parametro: " + parametro);
                                oids.setOidReemArtiLote(Long.valueOf(parametro));
                                UtilidadesLog.info("77777RegistroEliminados: "+ oids);
                                this.eliminar(oids);
                      }
               }
               if(array != null){
                   Iterator it = array.iterator();
                   while(it.hasNext()){
                     try{
                             UtilidadesLog.info(" Entro al while");
                             dta = (DTOReemplazoArticuloLote)it.next();
                             if(dta.getOidReemArtiLote() != null){
                                  UtilidadesLog.info("777777777Modifica777777777");
                                  this.modificar(dta);
                             }else{
                                   ContadorPremioArticuloLocalHome conPreArtLH = this.getContadorPremioArticuloLocalHome();
                                   ContadorPremioArticuloLocal conPreArtL = conPreArtLH.findByPais(dta.getOidPais());

                                   UtilidadesLog.info("DTO: " + dta);
                                   Long codigoVentaFicticio = this.obtengoCodVentaFicticio(conPreArtL);
                                   dta.setCodVentFict(codigoVentaFicticio.toString());
                                   dta.setIndActi(dta.getIndActi());
                                   //dta.setIndReemVali(new Long(0));
                                   //dta.setNumOrde(new Long(1));
                                   ReemplazoArticuloLoteLocalHome reemplazoLocalHome = this.getReemplazoArticuloLoteLocalHome();
                                   
                                   // sapaza -- VEN-SiCC-2012-0100 -- 23/08/2012
                                   ReemplazoArticuloLoteLocal reemplazoLocal = reemplazoLocalHome.create(dta.getIndDesp(), dta.getImpPrecPubi(), dta.getNumUnid(),
                                                                                                      dta.getCodVentFict(), dta.getProdOidProd(), dta.getIndCentDistGara(), dta.getIndTipoEntrPrem(),
                                                                                                       dta.getCtreOidCritReem(), dta.getValCritReem(), dta.getArloOidArtiLote(), dta.getNumOrde(),
                                                                                                       dta.getIndActi(), dta.getIndComu(), null);

                                   reemplazoLocal.setValObseCentDist(dta.getValObseCentDist());
                                   reemplazoLocal.setNumMeseGara( dta.getNumMeseGara());
                                   reemplazoLocal.setCeseOidCeseEntr(dta.getCeseOidCeseEntr());
                                   reemplazoLocal.setCeseOidCeseGara(dta.getCeseOidCeseGara());
                                   
                                   // sapaza -- PER-SiCC-2012-0322 -- 18/04/2012
                                   reemplazoLocal.setUsuarioCreacion(_context.getCallerPrincipal().getName());
                                   reemplazoLocal.setFechaCreacion(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
                                   
                                   //reemplazoLocal.setValUsua(_context.getCallerPrincipal().getName());
                                   reemplazoLocalHome.merge(reemplazoLocal);
                                   DTOReemplazoArticuloLote dto = new DTOReemplazoArticuloLote();

                                   if(dta.getOidRegion() != null){
                                      dto.setOidReemArtiLote(reemplazoLocal.getOid());
                                      dto.setOidRegion(dta.getOidRegion());
                                      dao.guardarRemplazoRegion(dto);

                                   }
                                   if(dta.getOidZona() != null){
                                      dto.setOidReemArtiLote(reemplazoLocal.getOid());
                                      dto.setOidZona(dta.getOidZona());
                                      dao.guardarRemplazoZona(dto);
                                   }
                           }
                           }catch(PersistenceException e){
                                   e.printStackTrace();
                                  _context.setRollbackOnly();
                                  throw new MareException(e,
                                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                           }

                      }// while
                }
                // dtoSalida.setResultado(dao.valoresSolicitud(inicio));

                 UtilidadesLog.info("MONRemplazoConcursoBean.guardar(DTOReemplazoArticuloLote dtoe): Salida");
               //  return dtoSalida;
    }

    public Long obtengoCodVentaFicticio(ContadorPremioArticuloLocal contPremioArt) throws MareException {
               UtilidadesLog.info("MONConcursoBean.obtengoCodVentaFicticio(ContadorPremioArticuloLocal contPremioArt): Entrada");
               
               Long codVentaFict = null; 
                       
               UtilidadesLog.debug("contPremioArt.getRangoDesde(): " + contPremioArt.getRangoDesde());
               UtilidadesLog.debug("contPremioArt.getRangoHasta(): " + contPremioArt.getRangoHasta());
               UtilidadesLog.debug("contPremioArt.getUltimContador(): " + contPremioArt.getUltimContador());
               
            
               if(contPremioArt.getUltimContador() == null || contPremioArt.getUltimContador().equals(new Long(0)) ||
                 ((contPremioArt.getUltimContador().compareTo(contPremioArt.getRangoDesde()) < 0) || 
                  (contPremioArt.getUltimContador().compareTo(contPremioArt.getRangoHasta()) >= 0))){
                  
                   UtilidadesLog.debug("vuelve a empezar");
                  
                   codVentaFict = contPremioArt.getRangoDesde();
                   contPremioArt.setUltimContador(codVentaFict);
               
               } else {
                   UtilidadesLog.debug("suma 1");
                   codVentaFict = new Long(contPremioArt.getUltimContador().intValue() + 1);
                   contPremioArt.setUltimContador(codVentaFict);
               }        
               this.getContadorPremioArticuloLocalHome().merge(contPremioArt);
               UtilidadesLog.debug("codVentaFict: " + codVentaFict);
               
               UtilidadesLog.info("MONConcursoBean.obtengoCodVentaFicticio(ContadorPremioArticuloLocal contPremioArt): Salida");
               return codVentaFict;
    }

    public void LanazarNuevaSolicitudReemplazo(DTOReemplazoArticuloLote dtoe) throws MareException {
               UtilidadesLog.info("MONReemplazoConcursoBean.LanzarNuevaSolicitudReemplazo(DTOReemplazoArticuloLote dtoe): Entrada");
               
               // sapaza -- VEN-SiCC-2012-0100 -- 23/08/2012
               dtoe.setValUsua(_context.getCallerPrincipal().getName());
               
               DTOBatch dtoBatch = new DTOBatch( "generarNuevaSolicitudReemplazo", new MareBusinessID("INCGenerarNuevaSolicitud"), dtoe);
               try{
                     BatchUtil.executeMLN( dtoBatch, "ZONReterritorializacion");                    
               }catch(RemoteException re){
                        re.printStackTrace();
                        UtilidadesLog.error("*** Error en lanzarReterritorializacion",re);
                        String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                        throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));                     
               }
               UtilidadesLog.info("MONReemplazoConcursoBean.LanzarNuevaSolicitudReemplazo(DTOReemplazoArticuloLote dtoe): Salida");          
    }

    public DTOSalidaBatch generarNuevaSolicitudReemplazo(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONReemplazoConcursoBean.generarNuevaSolicitudReemplazo(DTOReemplazoArticuloLote dtoe): Entrada ");
                DAORemplazoPremios dao = new DAORemplazoPremios();
                //UtilidadesLog.info("dtoe: " + dtoBatch);
                 DTOReemplazoArticuloLote dtoe = null;
                Boolean inicio = false;
                RecordSet rs = null;
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date date = new Date(System.currentTimeMillis());
               
                try{
                    dtoe = (DTOReemplazoArticuloLote)dtoBatch.getDTOOnline(); 
                    rs = dao.valoresSolicitud(inicio, dtoe);
                    if(!rs.esVacio()){
                       dao.carrarBolsaFaltante(rs);
                    }
                }catch(ClassCastException cce){
                       UtilidadesLog.debug("**** ClassCastException  en  MONReemplazoConcursoBean.LanzarNuevaSolicitud, salimos del metodo : ");
                       throw new MareException(" ClassCastException  en  MONReemplazoConcursoBean.LanzarNuevaSolicitud  ", cce);
                }
                try{
                        MONPeriodosHome periodoHm = this.getMONPeriodosHome();
                        MONPeriodos peri = periodoHm.create();

                        if(!rs.esVacio()){

                            // sapaza -- Cambio PER-SiCC-2010-0213 -- 16/04/2010    
                            Map mapSolicitud = dao.obtenerTipoSubtipoSolicitud("INC030", dtoe.getOidPais());
                            
                            // sapaza -- VEN-SiCC-2012-0100 -- 23/08/2012
                            Map oidReemplazos = new HashMap();
                        
                                    for(int i = 0; i < rs.getRowCount(); i++){
                                            DTOCabeceraSolicitud dt = new DTOCabeceraSolicitud();
                                            DTOPosicionSolicitud dtoPosiciones = new DTOPosicionSolicitud();
                                            ArrayList lista = new ArrayList();
                                            dt.setOidPais(dtoe.getOidPais());
                                            dt.setOidIdioma(RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor());

                                            // sapaza -- Cambio PER-SiCC-2010-0213 -- 16/04/2010                                           
                                            dt.setOperacion((Long)mapSolicitud.get("oidOperacion"));                        
                                            dt.setTipoSolicitud((Long)mapSolicitud.get("tipoSolicitud"));                                            
                                            
                                            dt.setModulo(ConstantesINC.CODIGO_MODULO_ORIGEN);
                                            dt.setTipoCliente(new Long(((BigDecimal)rs.getValueAt(i,"TICL_OID_TIPO_CLIE")).toString()));
                                            dt.setOidCliente(new Long(((BigDecimal)rs.getValueAt(i,"CLIE_OID_CLIE")).toString()));
                                            dt.setMarca(new Long(((BigDecimal)rs.getValueAt(i,"MARC_OID_MARC")).toString()));
                                            dt.setCanal(new Long(((BigDecimal)rs.getValueAt(i,"CANA_OID_CANA")).toString()));
                                            dt.setAcceso(new Long(((BigDecimal)rs.getValueAt(i,"OID_ACCE")).toString()));
                                            dt.setFecha(new Date(System.currentTimeMillis()));                                            
                                            DTOPeriodo dtoPeriodo =   peri.obtienePeriodoActual(dtoe.getOidPais(), dt.getMarca(),dt.getCanal());
                                            dt.setPeriodo(dtoPeriodo.getOid());
                                            dt.setObservaciones("NULL");
                                            dt.setOidConcursoParametros(new Long(((BigDecimal)rs.getValueAt(i,"OID_PARA_GRAL")).toString()));                    
                                            dt.setNumeroPremio(new Integer(((BigDecimal)rs.getValueAt(i,"NUM_PREM")).toString()));
                                            dtoPosiciones.setTipoPosicion( new Long (((BigDecimal)rs.getValueAt(i,"TPOS_OID_TIPO_POSI")).toString()));
                                            dtoPosiciones.setSubtipoPosicion(new  Long(((BigDecimal)rs.getValueAt(i, "STPO_OID_SUBT_POSI")).toString()));                                            
                                            if(rs.getValueAt(i,"IND_ACTI").toString().equals("1")){
                                                UtilidadesLog.info("rs Reemplazo: " + rs.getValueAt(i,"IND_ACTI").toString());
                                                dtoPosiciones.setOidProducto(new  Long(((BigDecimal)rs.getValueAt(i, "REEMPLAZO")).toString()));
                                                dtoPosiciones.setProducto(new  Long(((BigDecimal)rs.getValueAt(i, "REEMPLAZO")).toString()));
                                            }else if(rs.getValueAt(i,"IND_ACTI").toString().equals("0")){
                                                UtilidadesLog.info("rs Original: " + rs.getValueAt(i,"IND_ACTI").toString());
                                                dtoPosiciones.setOidProducto(new  Long(((BigDecimal)rs.getValueAt(i, "ORIGINAL")).toString()));
                                                dtoPosiciones.setProducto(new  Long(((BigDecimal)rs.getValueAt(i, "ORIGINAL")).toString()));
                                            }
                                            dtoPosiciones.setCodigoVentaFicticio(new Long(rs.getValueAt(i, "COD_VENT_FICT").toString()));
                                    
                                            // sapaza -- Cambio PER-SiCC-2010-0213 -- 26/04/2010 
                                            Long unidadesArticulo = new Long(((BigDecimal)rs.getValueAt(i,"NUM_UNID")).toString());
                                            Long unidadesDemandadas = new Long(((BigDecimal)rs.getValueAt(i,"NUM_UNID_FALT")).toString());
                                            dtoPosiciones.setUnidadesDemandadas(new Long(unidadesArticulo.longValue() * unidadesDemandadas.longValue()));
                                            
                                            dtoPosiciones.setPrecioContableUnitarioDocumento(BigDecimal.valueOf(new Long(((BigDecimal)rs.getValueAt(i,"IMP_PREC_PUBL")).toString())));                                        
                                            UtilidadesLog.debug("dtoPosiciones: " + dtoPosiciones);
                                            lista.add(dtoPosiciones);
                                            dt.setPosiciones(lista);
                                            UtilidadesLog.debug("dt: " + dt);
                                            MONGenerarSolicitudModulosExternosHome monGenerarSolicitudModulosExternos = this.getMONGenerarSolicitudModulosExternosHome();
                                            MONGenerarSolicitudModulosExternos modulosExternos = monGenerarSolicitudModulosExternos.create();
                                            modulosExternos.generaSolicitud(dt);

                                            // sapaza -- VEN-SiCC-2012-0100 -- 23/08/2012
                                            String oidReemplazo = rs.getValueAt(i,"OID_REEM_ARTI_LOTE").toString();
                                            if(oidReemplazos.get(oidReemplazo) == null) {
                                                oidReemplazos.put(oidReemplazo, oidReemplazo);
                                            }

                                }
                                
                                // sapaza -- VEN-SiCC-2012-0100 -- 23/08/2012
                                dao.actualizarUsuarioReemplazos(oidReemplazos, dtoe.getValUsua());
                        }
              }catch(NamingException nEx){
                         UtilidadesLog.debug("3- Naming Exception al obtener monPeriodos");
                         throw new MareException (nEx,
                         UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              }catch (RemoteException rEx){
                        UtilidadesLog.debug("3- Remote Exception");
                        throw new MareException (rEx,
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));

              } catch (CreateException cEx){
                        UtilidadesLog.debug("3- Create Exception");
                        UtilidadesLog.error(cEx);
                        _context.setRollbackOnly();
                        throw new MareException (cEx,
                             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        }





            UtilidadesLog.info("MONReemplazoConcursoBean.generarNuevaSolicitudReemplazo(DTOReemplazoArticuloLote dtoe): Salida ");
            return new DTOSalidaBatch ( 0,"Nueva Solicitud Realizada");    
    }

    public DTOSalida recuperaDatosFaltantes(DTOReemplazoArticuloLote dtoe) throws MareException {
                UtilidadesLog.info("MONReemplazoConcursoBean.recuperaDatosFaltantes(DTOReemplazoArticuloLote dtoe): Entrada");
                DAORemplazoPremios dao = new DAORemplazoPremios();
                DTOSalida dtoSalida = dao.recuperaDatosFaltantes(dtoe);
                UtilidadesLog.info("MONReemplazoConcursoBean.recuperaDatosFaltantes(DTOReemplazoArticuloLote dtoe): Salida");
                return dtoSalida;
    }

    public void modificar(DTOReemplazoArticuloLote dtoe) throws MareException {
        UtilidadesLog.info("MONReemplazoConcursoBean.modificar(DTOReemplazoArticuloLote dtoe): Entrada");
               try{
                       ReemplazoArticuloLoteLocalHome reemplazoLocalHome = null;
                       ReemplazoArticuloLoteLocal reemplazoLocal = null;
                     try{
                         reemplazoLocalHome = this.getReemplazoArticuloLoteLocalHome();
                         reemplazoLocal = reemplazoLocalHome.findByPrimaryKey(dtoe.getOidReemArtiLote());                
                         reemplazoLocal.setIndicadorDesp(dtoe.getIndDesp());
                         reemplazoLocal.setPrecioPublico(dtoe.getImpPrecPubi());
                         reemplazoLocal.setUnidad(dtoe.getNumUnid());
                         reemplazoLocal.setOidProducto( dtoe.getProdOidProd());
                         reemplazoLocal.setGarantia(dtoe.getIndCentDistGara());
                         reemplazoLocal.setCodigoVentaFicticio(dtoe.getCodVentFict());
                         reemplazoLocal.setEntregaPremio(dtoe.getIndTipoEntrPrem());
                         reemplazoLocal.setCriterioReemplazo(dtoe.getCtreOidCritReem());
                         reemplazoLocal.setValorCriterioReemplazo(dtoe.getValCritReem());
                         reemplazoLocal.setOidArticuloLote(dtoe.getArloOidArtiLote());
                         reemplazoLocal.setnumeroOrden(dtoe.getNumOrde());
                         reemplazoLocal.setIndicadorActivo(dtoe.getIndActi());
                         reemplazoLocal.setIndComunicacion(dtoe.getIndComu());
                         dtoe.setIndReemVali(new Long(1));
                         //reemplazoLocal.setIndicadorReemplazo(dtoe.getIndReemVali());
                         reemplazoLocal.setValObseCentDist(dtoe.getValObseCentDist());
                         reemplazoLocal.setNumMeseGara(dtoe.getNumMeseGara());
                         reemplazoLocal.setCeseOidCeseEntr(dtoe.getCeseOidCeseEntr());
                         reemplazoLocal.setCeseOidCeseGara(dtoe.getCeseOidCeseGara());
                         
                         // sapaza -- VEN-SiCC-2012-0100 -- 23/08/2012
                         //reemplazoLocal.setValUsua(_context.getCallerPrincipal().getName());    
                         
                         // sapaza -- PER-SiCC-2012-0322 -- 18/04/2012
                         reemplazoLocal.setUsuarioModificacion(_context.getCallerPrincipal().getName());
                         reemplazoLocal.setFechaModificacion(new Timestamp(new Date(System.currentTimeMillis()).getTime()));
                        
                         DTOReemplazoArticuloLote dto = new DTOReemplazoArticuloLote();
                         DAORemplazoPremios dao = new DAORemplazoPremios();
                         if(dtoe.getOidRegion() != null ){
                            UtilidadesLog.info(" region");
                            dto.setOidReemArtiLote(reemplazoLocal.getOid());
                            dto.setOidRegion(dtoe.getOidRegion());
                            dao.actualizaRegion(dto);                  
                         }else{
                             RecordSet region = dao.obtenerRegion(dtoe);   
                             UtilidadesLog.debug("region: " + region);
                             int cant = region.getRowCount();
                             for(int i = 0; i < cant; i ++){
                                     if(region.getValueAt(i,"ZORG_OID_REGI") != null){
                                        dao.eliminarZonaRegion(dtoe);
                                    }
                             }
                         }
                         if(dtoe.getOidZona() != null){
                             
                             dto.setOidReemArtiLote(reemplazoLocal.getOid());
                             dto.setOidZona(dtoe.getOidZona());
                             dao.actualizarZonas(dto);
                         }else{
                              UtilidadesLog.info("Modifica eliminando zona");   
                              RecordSet zona = dao.obtenerZona(dtoe);   
                              UtilidadesLog.debug("zona: " + zona);
                             int cant = zona.getRowCount();
                             for(int i = 0; i < cant; i++){
                                 if(zona.getValueAt(i,"ZZON_OID_ZONA") != null){
                                      dao.eliminarZonaRegion(dtoe);
                                    }
                             }
                         }
                          try {
                             reemplazoLocalHome.merge(reemplazoLocal);
                           }catch(PersistenceException pe){
                              throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                           }
                       
                     } catch(NoResultException nre){
                               throw new MareException(nre, UtilidadesError.armarCodigoError(
                                     CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                     } catch(PersistenceException pe){
                               UtilidadesLog.error("Exception: ",pe);
                       throw new MareException(pe, UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                       } 
                       } catch( MareException me ){
                        _context.setRollbackOnly();
                        throw me;
                       }
                     UtilidadesLog.info("MONReemplazoConcursoBean.modificar(DTOReemplazoArticuloLote dtoe): Salida");
    }

    public void eliminar(DTOReemplazoArticuloLote oids) throws MareException {
        UtilidadesLog.info("MONReemplazoConcursoBean.Eliminar(DTOOID oids): Entrada");
                try{
                        ReemplazoArticuloLoteLocalHome reemplazoLocalHome = null;
                        ReemplazoArticuloLoteLocal reemplazoLocal = null;
                      try{
                          reemplazoLocalHome = this.getReemplazoArticuloLoteLocalHome();
                          reemplazoLocal = reemplazoLocalHome.findByPrimaryKey(oids.getOidReemArtiLote());

                          DTOReemplazoArticuloLote dto = new DTOReemplazoArticuloLote();
                          DAORemplazoPremios dao = new DAORemplazoPremios();
                          dto.setOidReemArtiLote(reemplazoLocal.getOid());
                          Long oid  = oids.getOidReemArtiLote();
                          ArrayList array = new ArrayList();
                          array.add(oid);
                          dao.eliminarRegionZona(array);
                          try {
                              reemplazoLocalHome.remove(reemplazoLocal);
                           }catch(PersistenceException pe){
                               throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                           }

                      }catch(NoResultException nre){
                                throw new MareException(nre, UtilidadesError.armarCodigoError(
                                      CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                      }catch(PersistenceException pe){
                                UtilidadesLog.error("Exception: ",pe);
                                throw new MareException(pe, UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                      }
                      }catch(MareException me){
                         _context.setRollbackOnly();
                         throw me;
                      }

              UtilidadesLog.info("MONReemplazoConcursoBean.Eliminar(DTOOID oids): Salida");
    }

    private ReemplazoArticuloLoteLocalHome getReemplazoArticuloLoteLocalHome(){
                return new  ReemplazoArticuloLoteLocalHome();
        }
    private ContadorPremioArticuloLocalHome getContadorPremioArticuloLocalHome() {
               return new ContadorPremioArticuloLocalHome();
       }

    private MONGenerarSolicitudModulosExternosHome getMONGenerarSolicitudModulosExternosHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONGenerarSolicitudModulosExternosHome) PortableRemoteObject.narrow( context.lookup( "java:comp/env/MONGenerarSolicitudModulosExternos" ), MONGenerarSolicitudModulosExternosHome.class );
    }

    private MONPeriodosHome getMONPeriodosHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONPeriodosHome) PortableRemoteObject.narrow( context.lookup( "java:comp/env/MONPeriodos" ), MONPeriodosHome.class );
    }

    public DTOSalida obtenerProducto(DTOEBuscarProductos dtoe) throws MareException {
        UtilidadesLog.info("MONReemplazoConcursoBean.obtenerProducto(DTOEBuscarProductos dtoe): Entrada");        
        DAORemplazoPremios dao = new DAORemplazoPremios();         
        UtilidadesLog.info("MONReemplazoConcursoBean.obtenerProducto(DTOEBuscarProductos dtoe): Salida");
        return dao.obtenerProducto(dtoe);
    }

    private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (BusinessFacadeLocalHome) context.lookup( "java:comp/env/BusinessFacadeBATCH" );
    }

    public DTOSalida validarBolsaFaltantes(DTOArticuloLoteColeccion dtoe) throws MareException {
        UtilidadesLog.info("MONRemplazoConcursoBean.validarBolsaFaltante(DTOArticuloLoteColeccion dtoe): Entrada");
        ArrayList array = dtoe.getLista();    
        Iterator remplazo = array.iterator();
        DTOReemplazoArticuloLote dto = null;
        while(remplazo.hasNext()){
             dto = (DTOReemplazoArticuloLote)remplazo.next();
        }
        DAORemplazoPremios dao = new DAORemplazoPremios();         
        DTOSalida dtoSalida = new DTOSalida();
        Boolean inicio = true;
        
        // sapaza -- PER-SiCC-2011-0752 -- 29/09/2011
        if(dao.validaEjecucionProcesoBatch("generarNuevaSolicitudReemp")) {
            UtilidadesLog.error("Exception: Proceso: Reemplazo en Bolsa de Faltantes en ejecución. Intentarlo más tarde.");
             throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, 
                                                     "", ErroresDeNegocio.INC_0057)); 
        }

        dtoSalida.setResultado(dao.valoresSolicitud(inicio, dto));
        UtilidadesLog.info("MONRemplazoConcursoBean.validarBolsaFaltante(DTOArticuloLoteColeccion dtoe): Salida");
        return dtoSalida;
    }

    public DTOSalida validarDatosModificados(DTOArticuloLoteColeccion dtoe) throws MareException {
        UtilidadesLog.info("MONRemplazoConcursoBean.validarDatosModificados(DTOArticuloLoteColeccion dtoe): Entrada");
        ArrayList array = dtoe.getLista();    
        Iterator remplazo = array.iterator();
        DTOReemplazoArticuloLote dto = null;
        while(remplazo.hasNext()){
             dto = (DTOReemplazoArticuloLote)remplazo.next();
        }
        DAORemplazoPremios dao = new DAORemplazoPremios();         
        DTOSalida dtoSalida = new DTOSalida();
        Boolean inicio = true;
        dtoSalida.setResultado(dao.valoresSolicitudModificar(inicio, dto));
        UtilidadesLog.info("MONRemplazoConcursoBean.validarBolsaFaltante(DTOArticuloLoteColeccion dtoe): Salida");
        UtilidadesLog.info("MONRemplazoConcursoBean.validarDatosModificados(DTOArticuloLoteColeccion dtoe): Salida");
        return dtoSalida;
    }

    public void lanzarSolicitudModificados(DTOReemplazoArticuloLote dtoe) throws MareException {
        UtilidadesLog.info("MONReemplazoConcursoBean.lanzarSolicitudModificados(DTOReemplazoArticuloLote dtoe): Entrada");
        
        DTOBatch dtoBatch = new DTOBatch( "nuevaSolicitudModificado", new MareBusinessID("INCGenerarNuevaSolicitudModificados"), dtoe);
        try{
              BatchUtil.executeMLN( dtoBatch, "ZONReterritorializacion");                    
        }catch(RemoteException re){
                 re.printStackTrace();
                 UtilidadesLog.error("*** Error en lanzarReterritorializacion",re);
                 String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                 throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));                     
        }
        UtilidadesLog.info("MONReemplazoConcursoBean.lanzarSolicitudModificados(DTOReemplazoArticuloLote dtoe): Salida");  
    
    }

    public DTOSalidaBatch nuevaSolicitudModificado(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONReemplazoConcursoBean.generarNuevaSolicitudReemplazo(DTOReemplazoArticuloLote dtoe): Entrada ");
                DAORemplazoPremios dao = new DAORemplazoPremios();
                //UtilidadesLog.info("dtoe: " + dtoBatch);
                 DTOReemplazoArticuloLote dtoe = null;
                Boolean inicio = false;
                RecordSet rs = null;
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date date = new Date(System.currentTimeMillis());
               
                try{
                    dtoe = (DTOReemplazoArticuloLote)dtoBatch.getDTOOnline(); 
                    rs = dao.valoresSolicitudModificar(inicio, dtoe);
                    if(!rs.esVacio()){
                       dao.carrarBolsaFaltante(rs);
                    }
                }catch(ClassCastException cce){
                       UtilidadesLog.debug("**** ClassCastException  en  MONReemplazoConcursoBean.LanzarNuevaSolicitud, salimos del metodo : ");
                       throw new MareException(" ClassCastException  en  MONReemplazoConcursoBean.LanzarNuevaSolicitud  ", cce);
                }
                try{
                        MONPeriodosHome periodoHm = this.getMONPeriodosHome();
                        MONPeriodos peri = periodoHm.create();

                       
                        if(!rs.esVacio()){
                        
                            // sapaza -- Cambio PER-SiCC-2010-0213 -- 16/04/2010    
                            Map mapSolicitud = dao.obtenerTipoSubtipoSolicitud("INC030", dtoe.getOidPais());
                        
                                    for(int i = 0; i < rs.getRowCount(); i++){
                                            DTOCabeceraSolicitud dt = new DTOCabeceraSolicitud();
                                            DTOPosicionSolicitud dtoPosiciones = new DTOPosicionSolicitud();
                                            ArrayList lista = new ArrayList();
                                            dt.setOidPais(dtoe.getOidPais());
                                            dt.setOidIdioma(RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor());
                                            dt.setModulo(ConstantesINC.CODIGO_MODULO_ORIGEN);
                                            
                                            // sapaza -- Cambio PER-SiCC-2010-0213 -- 16/04/2010                                           
                                            dt.setOperacion((Long)mapSolicitud.get("oidOperacion"));                        
                                            dt.setTipoSolicitud((Long)mapSolicitud.get("tipoSolicitud"));                                            
                                            
                                            dt.setTipoCliente(new Long(((BigDecimal)rs.getValueAt(i,"TICL_OID_TIPO_CLIE")).toString()));
                                            dt.setOidCliente(new Long(((BigDecimal)rs.getValueAt(i,"CLIE_OID_CLIE")).toString()));
                                            dt.setMarca(new Long(((BigDecimal)rs.getValueAt(i,"MARC_OID_MARC")).toString()));
                                            dt.setCanal(new Long(((BigDecimal)rs.getValueAt(i,"CANA_OID_CANA")).toString()));
                                            dt.setAcceso(new Long(((BigDecimal)rs.getValueAt(i,"OID_ACCE")).toString()));
                                            dt.setFecha(new Date(System.currentTimeMillis()));                                            
                                            DTOPeriodo dtoPeriodo =   peri.obtienePeriodoActual(dtoe.getOidPais(), dt.getMarca(),dt.getCanal());
                                            dt.setPeriodo(dtoPeriodo.getOid());
                                            dt.setObservaciones("NULL");
                                            dt.setOidConcursoParametros(new Long(((BigDecimal)rs.getValueAt(i,"OID_PARA_GRAL")).toString()));                    
                                            dt.setNumeroPremio(new Integer(((BigDecimal)rs.getValueAt(i,"NUM_PREM")).toString()));
                                            dtoPosiciones.setTipoPosicion( new Long (((BigDecimal)rs.getValueAt(i,"TPOS_OID_TIPO_POSI")).toString()));
                                            dtoPosiciones.setSubtipoPosicion(new  Long(((BigDecimal)rs.getValueAt(i, "STPO_OID_SUBT_POSI")).toString()));                                            
                                            dtoPosiciones.setOidProducto(new  Long(((BigDecimal)rs.getValueAt(i, "ORIGINAL")).toString()));
                                            dtoPosiciones.setProducto(new  Long(((BigDecimal)rs.getValueAt(i, "ORIGINAL")).toString()));
                                            dtoPosiciones.setCodigoVentaFicticio(new Long(rs.getValueAt(i, "COD_VENT_FICT").toString()));
                                            
                                            // sapaza -- Cambio PER-SiCC-2010-0213 -- 26/04/2010 
                                            Long unidadesArticulo = new Long(((BigDecimal)rs.getValueAt(i,"NUM_UNID")).toString());
                                            Long unidadesDemandadas = new Long(((BigDecimal)rs.getValueAt(i,"NUM_UNID_FALT")).toString());
                                            dtoPosiciones.setUnidadesDemandadas(new Long(unidadesArticulo.longValue() * unidadesDemandadas.longValue()));
                                            
                                            dtoPosiciones.setPrecioContableUnitarioDocumento(BigDecimal.valueOf(new Long(((BigDecimal)rs.getValueAt(i,"IMP_PREC_PUBL")).toString())));                                        
                                            
                                            lista.add(dtoPosiciones);
                                            dt.setPosiciones(lista);
                                            MONGenerarSolicitudModulosExternosHome monGenerarSolicitudModulosExternos = this.getMONGenerarSolicitudModulosExternosHome();
                                            MONGenerarSolicitudModulosExternos modulosExternos = monGenerarSolicitudModulosExternos.create();
                                            modulosExternos.generaSolicitud(dt);



                                }
                        }
              }catch(NamingException nEx){
                         UtilidadesLog.debug("3- Naming Exception al obtener monPeriodos");
                         throw new MareException (nEx,
                         UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
              }catch (RemoteException rEx){
                        UtilidadesLog.debug("3- Remote Exception");
                        throw new MareException (rEx,
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));

              } catch (CreateException cEx){
                        UtilidadesLog.debug("3- Create Exception");
                        UtilidadesLog.error(cEx);
                        _context.setRollbackOnly();
                        throw new MareException (cEx,
                             UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        }





            UtilidadesLog.info("MONReemplazoConcursoBean.generarNuevaSolicitudReemplazo(DTOReemplazoArticuloLote dtoe): Salida ");
            return new DTOSalidaBatch ( 0,"Nueva Solicitud Mod");    
    }

    // sapaza -- PER-SICC-2011-0303 -- 18/05/2011
    public DTOSalida obtenerPendientesBolsaFaltantes(DTOOID dteo) throws MareException {
        UtilidadesLog.info("MONRemoplazoConcursoBean.obtenerPendientesBolsaFaltantes(DTOOID dtoe): Entrada");
        DAORemplazoPremios dao = new DAORemplazoPremios();
        DTOSalida dtoSalida = dao.obtenerPendientesBolsaFaltantes(dteo);
        UtilidadesLog.info("MONRemoplazoConcursoBean.obtenerPendientesBolsaFaltantes(DTOOID dtoe): Salida");
        return dtoSalida;
    }
}
