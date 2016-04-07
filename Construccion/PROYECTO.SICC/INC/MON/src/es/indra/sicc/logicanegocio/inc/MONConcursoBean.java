/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35guardarParametrosGeneralesConcurso
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
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.dtos.inc.DTOArticulo;
import es.indra.sicc.dtos.inc.DTOBuscarConcursos;
import es.indra.sicc.dtos.inc.DTOBuscarCtaCtePtos;
import es.indra.sicc.dtos.inc.DTOBuscarNumConcurso;
import es.indra.sicc.dtos.inc.DTOBuscarPlantillas;
import es.indra.sicc.dtos.inc.DTOBusquedaClienteCalificado;
import es.indra.sicc.dtos.inc.DTOCalificacionParticipante;
import es.indra.sicc.dtos.inc.DTOCalificacionParticipantes;

//import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.dtos.inc.DTOCentroServicio;
import es.indra.sicc.dtos.inc.DTOClasificacion;
import es.indra.sicc.dtos.inc.DTOClasificacionParticipantes;
import es.indra.sicc.dtos.inc.DTOConcurso;
import es.indra.sicc.dtos.inc.DTOCursoExigidoPremiacion;
import es.indra.sicc.dtos.inc.DTOCursosExigidosPremiacion;
import es.indra.sicc.dtos.inc.DTODespachoPremios;
import es.indra.sicc.dtos.inc.DTOEstatusVenta;
import es.indra.sicc.dtos.inc.DTOIncAmbitoGeografico;
import es.indra.sicc.dtos.inc.DTOIncrementoPorRango;
import es.indra.sicc.dtos.inc.DTOListaAmbitosGeograficos;
import es.indra.sicc.dtos.inc.DTOListaEstatusVenta;
import es.indra.sicc.dtos.inc.DTOListaMontoVentaRecomendadas;
import es.indra.sicc.dtos.inc.DTOLotesPremio;
import es.indra.sicc.dtos.inc.DTOMontoVentaRecomendadas;
import es.indra.sicc.dtos.inc.DTOMovimientoCtaCte;
import es.indra.sicc.dtos.inc.DTOMultinivel;
import es.indra.sicc.dtos.inc.DTONivelPremiacion;
import es.indra.sicc.dtos.inc.DTONivelesPremiacion;
import es.indra.sicc.dtos.inc.DTONuevaVersion;
import es.indra.sicc.dtos.inc.DTOObtencionPuntos;
import es.indra.sicc.dtos.inc.DTOPagoMonetario;
import es.indra.sicc.dtos.inc.DTOParametrosCalificacion;
import es.indra.sicc.dtos.inc.DTOParametrosConsultoras;
import es.indra.sicc.dtos.inc.DTOParametrosGeneralesConcurso;
import es.indra.sicc.dtos.inc.DTOParametrosGeneralesPremiacion;
import es.indra.sicc.dtos.inc.DTOParametrosGerentes;
import es.indra.sicc.dtos.inc.DTOParticipante;
import es.indra.sicc.dtos.inc.DTOPedidoPremiar;
import es.indra.sicc.dtos.inc.DTOPlantilla;
import es.indra.sicc.dtos.inc.DTOPremioArticulo;
import es.indra.sicc.dtos.inc.DTOPremioDescuento;
import es.indra.sicc.dtos.inc.DTOPremioMonetario;
import es.indra.sicc.dtos.inc.DTOPremioPuntos;
import es.indra.sicc.dtos.inc.DTOProdu;
import es.indra.sicc.dtos.inc.DTOProducto;
import es.indra.sicc.dtos.inc.DTOProductoExigidoPremiacion;
import es.indra.sicc.dtos.inc.DTOProductosExigidosPremiacion;
import es.indra.sicc.dtos.inc.DTOProductosLote;
import es.indra.sicc.dtos.inc.DTOProgramaNuevas;
import es.indra.sicc.dtos.inc.DTORequisitosPremiacion;
import es.indra.sicc.dtos.inc.DTOTipoProducto;
import es.indra.sicc.dtos.inc.DTOVariablesVenta;
import es.indra.sicc.dtos.inc.DTOVariablesVentaProyectada;
import es.indra.sicc.dtos.inc.DTOVersion;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.inc.AccesoConcursoLocal;
import es.indra.sicc.entidades.inc.AccesoConcursoLocalHome;
import es.indra.sicc.entidades.inc.AmbitoGeograficoLocal;
import es.indra.sicc.entidades.inc.AmbitoGeograficoLocalHome;
import es.indra.sicc.entidades.inc.ArticulosLoteLocal;
import es.indra.sicc.entidades.inc.ArticulosLoteLocalHome;
import es.indra.sicc.entidades.inc.ClasificacionParticipantesCalificacionLocal;
import es.indra.sicc.entidades.inc.ClasificacionParticipantesCalificacionLocalHome;
import es.indra.sicc.entidades.inc.ClasificacionParticipantesConcursoLocal;
import es.indra.sicc.entidades.inc.ClasificacionParticipantesConcursoLocalHome;
import es.indra.sicc.entidades.inc.ConcursoParametrosConsultorasLocal;
import es.indra.sicc.entidades.inc.ConcursoParametrosConsultorasLocalHome;
import es.indra.sicc.entidades.inc.ConcursoParametrosGeneralesLocal;
import es.indra.sicc.entidades.inc.ConcursoParametrosGeneralesLocalHome;
import es.indra.sicc.entidades.inc.ConcursoParametrosGerentesLocal;
import es.indra.sicc.entidades.inc.ConcursoParametrosGerentesLocalHome;
import es.indra.sicc.entidades.inc.ConcursoVariablesVentaGerentesLocal;
import es.indra.sicc.entidades.inc.ConcursoVariablesVentaGerentesLocalHome;
import es.indra.sicc.entidades.inc.ConcursoVariablesVentaProyectadaLocal;
import es.indra.sicc.entidades.inc.ConcursoVariablesVentaProyectadaLocalHome;
import es.indra.sicc.entidades.inc.CursosExigidosPremiacionLocal;
import es.indra.sicc.entidades.inc.CursosExigidosPremiacionLocalHome;
import es.indra.sicc.entidades.inc.DespachoPremiosLocal;
import es.indra.sicc.entidades.inc.DespachoPremiosLocalHome;
import es.indra.sicc.entidades.inc.EstatusVentaConsultoraLocal;
import es.indra.sicc.entidades.inc.EstatusVentaConsultoraLocalHome;
import es.indra.sicc.entidades.inc.EstatusVentaLocal;
import es.indra.sicc.entidades.inc.EstatusVentaLocalHome;
import es.indra.sicc.entidades.inc.LotePremioArticulosLocal;
import es.indra.sicc.entidades.inc.LotePremioArticulosLocalHome;
import es.indra.sicc.entidades.inc.MetasTipoVentaLocal;
import es.indra.sicc.entidades.inc.MetasTipoVentaLocalHome;
import es.indra.sicc.entidades.inc.MetasVentaProyectadaRegionLocal;
import es.indra.sicc.entidades.inc.MetasVentaProyectadaRegionLocalHome;
import es.indra.sicc.entidades.inc.MetasVentaProyectadaSubgerenciaVentaLocal;
import es.indra.sicc.entidades.inc.MetasVentaProyectadaSubgerenciaVentaLocalHome;
import es.indra.sicc.entidades.inc.MetasVentaProyectadaZonaLocal;
import es.indra.sicc.entidades.inc.MetasVentaProyectadaZonaLocalHome;
import es.indra.sicc.entidades.inc.MontoMinimoRangoConsultorasLocal;
import es.indra.sicc.entidades.inc.MontoMinimoRangoConsultorasLocalHome;
import es.indra.sicc.entidades.inc.MontoMinimoRangoGerentesLocal;
import es.indra.sicc.entidades.inc.MontoMinimoRangoGerentesLocalHome;
import es.indra.sicc.entidades.inc.MontoVentaRecomendadasLocal;
import es.indra.sicc.entidades.inc.MontoVentaRecomendadasLocalHome;
import es.indra.sicc.entidades.inc.MultinivelLocal;
import es.indra.sicc.entidades.inc.MultinivelLocalHome;
import es.indra.sicc.entidades.inc.ObtencionPuntosLocal;
import es.indra.sicc.entidades.inc.ObtencionPuntosLocalHome;
import es.indra.sicc.entidades.inc.PagoMonetariosLocal;
import es.indra.sicc.entidades.inc.PagoMonetariosLocalHome;
import es.indra.sicc.entidades.inc.ParametrosCalificacionLocal;
import es.indra.sicc.entidades.inc.ParametrosCalificacionLocalHome;
import es.indra.sicc.entidades.inc.ParametrosGeneralesPremiacionLocal;
import es.indra.sicc.entidades.inc.ParametrosGeneralesPremiacionLocalHome;
import es.indra.sicc.entidades.inc.ParametrosNivelPremiacionLocal;
import es.indra.sicc.entidades.inc.ParametrosNivelPremiacionLocalHome;
import es.indra.sicc.entidades.inc.PlantillaConcursoLocal;
import es.indra.sicc.entidades.inc.PlantillaConcursoLocalHome;
import es.indra.sicc.entidades.inc.PremioArticuloLocal;
import es.indra.sicc.entidades.inc.PremioArticuloLocalHome;
import es.indra.sicc.entidades.inc.PremioDescuentoLocal;
import es.indra.sicc.entidades.inc.PremioDescuentoLocalHome;
import es.indra.sicc.entidades.inc.PremioMonetarioLocal;
import es.indra.sicc.entidades.inc.PremioMonetarioLocalHome;
import es.indra.sicc.entidades.inc.PremioPuntosLocal;
import es.indra.sicc.entidades.inc.PremioPuntosLocalHome;
import es.indra.sicc.entidades.inc.ProductoDescuentoLocal;
import es.indra.sicc.entidades.inc.ProductoDescuentoLocalHome;
import es.indra.sicc.entidades.inc.ProductosBonificadosLocal;
import es.indra.sicc.entidades.inc.ProductosBonificadosLocalHome;
import es.indra.sicc.entidades.inc.ProductosCalificarLocal;
import es.indra.sicc.entidades.inc.ProductosCalificarLocalHome;
import es.indra.sicc.entidades.inc.ProductosExcluidosCalificacionLocal;
import es.indra.sicc.entidades.inc.ProductosExcluidosCalificacionLocalHome;
import es.indra.sicc.entidades.inc.ProductosExcluidosLocal;
import es.indra.sicc.entidades.inc.ProductosExcluidosLocalHome;
import es.indra.sicc.entidades.inc.ProductosExigidosLocal;
import es.indra.sicc.entidades.inc.ProductosExigidosLocalHome;
import es.indra.sicc.entidades.inc.ProductosExigidosPremiacionLocal;
import es.indra.sicc.entidades.inc.ProductosExigidosPremiacionLocalHome;
import es.indra.sicc.entidades.inc.ProductosLocal;
import es.indra.sicc.entidades.inc.ProductosLocalHome;
import es.indra.sicc.entidades.inc.ProductosValidosLocal;
import es.indra.sicc.entidades.inc.ProductosValidosLocalHome;
import es.indra.sicc.entidades.inc.ProgramaNuevasLocal;
import es.indra.sicc.entidades.inc.ProgramaNuevasLocalHome;
import es.indra.sicc.entidades.inc.RangoLocal;
import es.indra.sicc.entidades.inc.RangoLocalHome;
import es.indra.sicc.entidades.inc.RequisitosPremiacionLocal;
import es.indra.sicc.entidades.inc.RequisitosPremiacionLocalHome;
import es.indra.sicc.entidades.inc.RequisitosProgramaNuevasLocal;
import es.indra.sicc.entidades.inc.RequisitosProgramaNuevasLocalHome;
import es.indra.sicc.entidades.inc.VersionesConcursoLocal;
import es.indra.sicc.entidades.inc.VersionesConcursoLocalHome;
import es.indra.sicc.entidades.mae.MaestroProductosLocal;
import es.indra.sicc.entidades.mae.MaestroProductosLocalHome;
import es.indra.sicc.entidades.mae.MaestroProductosPK;
import es.indra.sicc.entidades.msg.MensajesLocal;
import es.indra.sicc.entidades.msg.MensajesLocalHome;
import es.indra.sicc.entidades.seg.MarcaProductoLocal;
import es.indra.sicc.entidades.seg.MarcaProductoLocalHome;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.ExcepcionParametrizada;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Date;

import java.text.Format;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesHome;
import es.indra.sicc.entidades.inc.ContadorPremioArticuloLocalHome;
import es.indra.sicc.entidades.inc.ContadorPremioArticuloLocal;

import es.indra.sicc.entidades.inc.PremioSorteoLocal;
import es.indra.sicc.entidades.inc.PremioSorteoLocalHome;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONConcursoBean
        implements SessionBean {
    private SessionContext sessionContext;

    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
        sessionContext = ctx;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param dtoe DTOBuscarPlantillas
     * @version 1.00 19 abr 2005
     * @author Igor Dedough
     *
     * LLama al método obtenerListaVersionesConcurso (DTOE)
     * de la clase DAOConcurso y obtiene un RecordSet "listaVersionesConcurso"
     * DTOSalida.resultado = listaVersionesConcurso
     */
    public DTOSalida obtenerListaVersionesConcurso(DTOBuscarPlantillas dtoe)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerListaVersionesConcurso(DTOBuscarPlantillas dtoe):Entrada");
        DAOConcurso daoConcurso = new DAOConcurso();
        DTOSalida dts = new DTOSalida();
        dts.setResultado(daoConcurso.obtenerListaVersionesConcurso(dtoe));
        UtilidadesLog.info("MONConcursoBean.obtenerListaVersionesConcurso(DTOBuscarPlantillas dtoe):Salida");
        return dts;       
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param dtoe DTOVersion
     * @version 1.00 19 abr 2005
     * @author Igor Dedough
     *
     * Se actualiza el estado de la versión del concurso:
     *    version = findByPk (DTOE.oid) de la entidad VersionesConcurso
     * Se modifica el estado:
     *    version.oidEstadoConcurso = DTOE.oidEstado
     *    
     *    Modificado por: Cristian Valenzuela
     *    Fecha:          2/11/2006
     *    Comentario:     Modificacion en el DECU hecha por Carlos Falco el 
     *                    martes 31/10/2006, para el caso de uso Evaluar cambios y solicitudes
     */
    public void actualizarEstadoVersion(DTOVersion dtoe)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.actualizarEstadoVersion(DTOVersion dtoe):Entrada");
        UtilidadesLog.debug("************ DTOVersion " + dtoe);
        
        try {
            VersionesConcursoLocalHome verConcLHome = null;
            VersionesConcursoLocal verConcLocal = null;
            verConcLHome = this.getVersionesConcursoLocalHome();

            if (dtoe.getOid() != null) {
                verConcLocal = verConcLHome.findByPrimaryKey(dtoe.getOid());

                if (dtoe.getOidEstado() != null) {
                    verConcLocal.setEstadoConcurso(dtoe.getOidEstado());
                    verConcLHome.merge(verConcLocal);
                }                
               
               /* Agregado por ssantana, 10/05/2006, Versionado */ 
               VersionesConcursoLocal datosVersion = null;
               
               if(dtoe.getIndAutoriza()!=null) {
                  //Boton Rechazar en cu: Evaluar cambios y solicitudes
                  if (!dtoe.getIndAutoriza().booleanValue()) { 
                      UtilidadesLog.debug("************ Rechazar - OID_VIG_CONCU_ANULADO");
                      verConcLocal.setVigenciaConcurso(ConstantesINC.OID_VIG_CONCU_ANULADO);                                    
                      verConcLHome.merge(verConcLocal);
                      Collection col = verConcLHome.findByConcurso(verConcLocal.getConcursoOrigen());
                      Iterator it = col.iterator();
                      while (it.hasNext()) {
                          datosVersion = (VersionesConcursoLocal) it.next();                      
                          Integer versionNueva = datosVersion.getVersionNueva();
                          if (versionNueva.equals(ConstantesINC.VERSION_1) ) {
                              UtilidadesLog.debug("************ OID_ESTADO_ACTIVO");
                              datosVersion.setEstadoConcurso(ConstantesINC.OID_ESTADO_ACTIVO);
                          }
                          else {
                              UtilidadesLog.debug("************ OID_ESTADO_APROBADO");
                              datosVersion.setEstadoConcurso(ConstantesINC.OID_ESTADO_APROBADO);
                          }                      
                     }           
                  }                 
                  else { //Boton Autorizar en cu: Evaluar cambios y solicitudes
                      UtilidadesLog.debug("************ Estado:" + dtoe.getOidEstado().longValue());
                      
                      if(dtoe.getOidEstado().longValue() == 
                      ConstantesINC.OID_ESTADO_APROBADO.longValue()) {
                      
                          UtilidadesLog.debug("************ Autorizar - OID_VIG_CONCU_NO_VIGENTE");
                          verConcLocal.setVigenciaConcurso(ConstantesINC.OID_VIG_CONCU_NO_VIGENTE);                                    
                          verConcLHome.merge(verConcLocal);
                          Collection col = verConcLHome.findByConcurso(verConcLocal.getConcursoOrigen());
                          Iterator it = col.iterator();
                          
                          while (it.hasNext()) {
                            datosVersion = (VersionesConcursoLocal) it.next();                      
                            Integer versionNueva = datosVersion.getVersionNueva();
                            if (versionNueva.equals(ConstantesINC.VERSION_1) ) {
                              UtilidadesLog.debug("************ OID_ESTADO_ACTIVO");
                              datosVersion.setEstadoConcurso(ConstantesINC.OID_ESTADO_ACTIVO);
                            }
                            else {
                              UtilidadesLog.debug("************ OID_ESTADO_APROBADO");
                              datosVersion.setEstadoConcurso(ConstantesINC.OID_ESTADO_APROBADO);
                            }                       
                         }                     
                      }                                                
                  }
               }               
               /* Fin Agregado por ssantana, 10/05/2006, Versionado */ 
            }
            
        } catch (NoResultException finderException) {
            UtilidadesLog.error("ERROR ", finderException);
            sessionContext.setRollbackOnly();
            throw new MareException(finderException, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONConcursoBean.actualizarEstadoVersion(DTOVersion dtoe):Salida");
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 20/04/2005
     */
    public DTOSalida cargarNroPlantilla(DTOBelcorp DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.cargarNroPlantilla(DTOBelcorp dtoe):Entrada");
        DAOConcurso dao = new DAOConcurso();
        RecordSet rs = dao.cargarNroPlantilla(DTOE);
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(rs);
        UtilidadesLog.info("MONConcursoBean.cargarNroPlantilla(DTOBelcorp dtoe):Salida");
        return dtos;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 20/04/2005
     */
    public DTOSalida cargarNroConcurso(DTOBuscarNumConcurso DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.cargarNroConcurso(DTOBuscarNumConcurso dtoe):Entrada");
        DAOConcurso dao = new DAOConcurso();
        RecordSet rs = dao.cargarNroConcurso(DTOE);
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(rs);
        UtilidadesLog.info("MONConcursoBean.cargarNroConcurso(DTOBuscarNumConcurso dtoe):Salida");
        return dtos;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Viviana Bongiovanni -- 1/08/2005
     */
    public DTOSalida cargarNroConcursoVersion(DTOBuscarNumConcurso DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.cargarNroConcursoVersion(DTOBuscarNumConcurso dtoe):Entrada");
        DAOConcurso dao = new DAOConcurso();
        RecordSet rs = dao.cargarNroConcursoVersion(DTOE);
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(rs);
        UtilidadesLog.info("MONConcursoBean.cargarNroConcursoVersion(DTOBuscarNumConcurso dtoe):Salida");
        return dtos;
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param dtoe DTOBuscarCtaCtePtos
     * @version 1.00 20 abr 2005
     * @author Igor Dedough
     *
     * LLama al método buscarCtaCtePtos (DTOE) de la clase DAOConcurso
     * y obtiene un RecordSet "ctaCtePtos"
     * DTOSalida.resultado = ctaCtePtos
     */
    public DTOSalida buscarCtaCtePtos(DTOBuscarCtaCtePtos dtoe)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.buscarCtaCtePtos(DTOBuscarCtaCtePtos dtoe):Entrada");
        DAOConcurso daoConcurso = new DAOConcurso();
        DTOSalida dts = new DTOSalida();
        //Agregado por dmaneiro- Inc 22398
        RecordSet datosLista = null;
        
        try{
          //Obtiene la Lista con la Fecha de Movimiento en formato dd-mm-yyyy
          datosLista = obtenerListaFormatoFecha(daoConcurso.buscarCtaCtePtos(dtoe));
        } catch(Exception e){
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e);//Error al parsear el String
        }
        //Fin de Agregado
        
        //Modificado por Cristian Valenzuela - 31/01/2006
        //dts.setResultado(daoConcurso.buscarCtaCtePtos(dtoe));
        dts.setResultado(datosLista);
        //FIN - Modificado por Cristian Valenzuela - 31/01/2006

        if (!dts.getResultado().esVacio()) {
            UtilidadesLog.debug("resultado  " + dts.getResultado());
            UtilidadesLog.info("MONConcursoBean.buscarCtaCtePtos(DTOBuscarCtaCtePtos dtoe):Salida");   
            return dts;
        } else {
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
    }
    
    /**
    *
    * @throws es.indra.mare.common.exception.Exception
    * @return
    * @param RecordSet
    * @author Damasia Maneiro-- 16/01/2006 - Inc. 22398    */
    RecordSet obtenerListaFormatoFecha(RecordSet lista) throws Exception{
      UtilidadesLog.info("****** Entrada obtenerListaFormatoFecha: " + lista);
      // 1027, 1, 1, 2005-01-02, Campaña 201002, Grupo Ebel, 1, Venta Directa, 304, 0, 1027, null, 04/053 - 1
      if(!lista.esVacio()){
     
        for(int i=0; lista.getRowCount() > i ;i++){
      
          String fechaMovimiento = lista.getValueAt(i,"FEC_MOVI").toString();
          lista.setValueAt(toDate(fechaMovimiento),i,3);      
          
        }
      }
      
      UtilidadesLog.info("****** Salida obtenerListaFormatoFecha: " + lista);
      
      return lista;
    }
    
    /**
     *
     * @throws es.indra.mare.common.exception.Exception
     * @return
     * @param String
     * @author Damasia Maneiro-- 16/01/2006 - Inc. 22398   */
    private String toDate(String sFecha) throws Exception{		
	  UtilidadesLog.info("****** Entrada toDate nuevo: " + sFecha);
      
      SimpleDateFormat sdfInput = new SimpleDateFormat( "yyyy-MM-dd" ); 
      SimpleDateFormat sdfOutput = new SimpleDateFormat ( "dd/MM/yyyy" ); 
    
      java.util.Date date = sdfInput.parse( sFecha ); 
            
      UtilidadesLog.info("****** Salida toDate nuevo: " + sdfOutput.format(date));
      
      return sdfOutput.format(date);      
     
    }
    

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 20/04/2005
     */
    public DTOSalida buscarListaPlantillas(DTOBuscarPlantillas DTOE) throws MareException {
        UtilidadesLog.info("MONConcursoBean.buscarListaPlantillas(DTOBuscarPlantillas dtoe):Entrada");   
        DAOConcurso dao = new DAOConcurso();
        RecordSet rs = dao.buscarListaPlantillas(DTOE);
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(rs);
        UtilidadesLog.info("MONConcursoBean.buscarListaPlantillas(DTOBuscarPlantillas dtoe):Salida");   
        return dtos;
    }

    /**
       *
       * @throws es.indra.mare.common.exception.MareException
       * @return
       * @param DTOE
       * @author Marcelo J. Maidana -- 21/04/2005
       */
    public DTOSalida obtenerListaParticipantes(DTOOID DTOE) throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerListaParticipantes(DTOOID DTOE):Entrada");   
        DAOConcurso dao = new DAOConcurso();
        RecordSet rs = dao.obtenerListaParticipantes(DTOE);
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(rs);
        UtilidadesLog.info("MONConcursoBean.obtenerListaParticipantes(DTOOID DTOE):Salida");   
        return dtos;
    }

    /**
       *
       * @throws es.indra.mare.common.exception.MareException
       * @return
       * @param DTOE
       * @author Marcelo J. Maidana -- 27/05/2005
       */
    public DTOConcurso obtenerDatosConcurso(DTOOID DTOE) throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerDatosConcurso(DTOOID DTOE):Entrada");         
        UtilidadesLog.debug("************ MONConcursoBean.obtenerDatosConcurso()");

        DTOConcurso dtoc = new DTOConcurso();
        DAOConcurso daoConcurso = new DAOConcurso();
        DTOOID dtoOidParticipante = null;
        DTOCalificacionParticipantes dtoCalificacionParticipantes = null;
        DTOSalida dtoSalida = null;
        RecordSet r = null;

        dtoc.setOidIdioma(DTOE.getOidIdioma());

        UtilidadesLog.debug("*********** 1");
        dtoc.setParamGenerales(this.obtenerParametrosGeneralesConcurso(DTOE));
        dtoc.setIndObligParamGenerales(Boolean.TRUE);
        dtoc.setIndParamGenerales(Boolean.TRUE);

        //Jrivas 6/6/2005
        //Faltaba la plantilla
        try {
            MONParametrizacionHome monPara = this.getMONParametrizacionHome();
            DTOOID dtoPl = new DTOOID();
            UtilidadesLog.debug("*********** 2");
            dtoPl.setOid(dtoc.getParamGenerales().getOidPlantilla());
            dtoPl.setOidIdioma(dtoc.getParamGenerales().getOidIdioma());
            dtoc.setPlantilla(monPara.create().obtenerPlantilla(dtoPl));
        } catch (NamingException ne) {
            UtilidadesLog.error("ERROR ", ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.debug("*********** 3");
        dtoc.setProgramaNuevas(this.obtenerProgramaNuevas(DTOE));

        if (dtoc.getProgramaNuevas() != null) {
            dtoc.setIndObligProgramaNuevas(Boolean.TRUE);
            dtoc.setIndProgramaNuevas(Boolean.TRUE);
        } else {
            dtoc.setIndObligProgramaNuevas(Boolean.FALSE);
            dtoc.setIndProgramaNuevas(Boolean.FALSE);
        }

        UtilidadesLog.debug("*********** 4");
        //Cleal - INC 06
        //dtoc.setEstatusVenta(this.obtenerListaEstatusVentaConsultora(DTOE));
        dtoc.setEstatusVenta(daoConcurso.obtenerListaEstatusVentaCalificacion(DTOE));


        if (dtoc.getEstatusVenta() != null) {
            dtoc.setIndEstatusVenta(Boolean.TRUE);
        } else {
            dtoc.setIndEstatusVenta(Boolean.FALSE);
        }
        //Cleal - INC 06
        dtoc.setEstatusVentaConsultoras(daoConcurso.obtenerListaEstatusVenta(DTOE));
        
        if (dtoc.getEstatusVentaConsultoras() != null) {
            dtoc.setIndEstatusVentaConsultoras(Boolean.TRUE);
        } else {
            dtoc.setIndEstatusVentaConsultoras(Boolean.FALSE);
        }


        UtilidadesLog.debug("*********** 5");
        dtoc.setListaAmbitosGeograficos(this.obtenerListaAmbitosGeograficos(DTOE));

        if (dtoc.getListaAmbitosGeograficos() != null) {
            dtoc.setIndObligAmbitosGeograficos(Boolean.TRUE);
            dtoc.setIndAmbitosGeograficos(Boolean.TRUE);
        } else {
            dtoc.setIndObligAmbitosGeograficos(Boolean.FALSE);
            dtoc.setIndAmbitosGeograficos(Boolean.FALSE);
        }

        UtilidadesLog.debug("*********** 6");
        dtoc.setObtencionPuntos(this.obtenerObtencionPuntos(DTOE));

        if (dtoc.getObtencionPuntos() != null) {
            dtoc.setIndObligObtencionPuntos(Boolean.TRUE);
            dtoc.setIndObtencionPuntos(Boolean.TRUE);
        } else {
            dtoc.setIndObligObtencionPuntos(Boolean.FALSE);
            dtoc.setIndObtencionPuntos(Boolean.FALSE);
        }

        UtilidadesLog.debug("*********** 7");
        dtoc.setListaMontoVentaRecomendadas(this.obtenerMontoVentaRecomendadas(DTOE));

        if (dtoc.getListaMontoVentaRecomendadas() != null) {
            dtoc.setIndMontoVentaRecomendadas(Boolean.TRUE);
        } else {
            UtilidadesLog.debug("************* 5.4");

            DTOBelcorp dtob = new DTOBelcorp();
            dtob.setOidIdioma(dtoc.getOidIdioma());

            DTOListaMontoVentaRecomendadas dtoLista = new DTOListaMontoVentaRecomendadas();
            dtoLista.setMontosVenta(this.parsearRecordSetMontoVenta(this.obtenerTipoMontoVentaRecomendada(dtob)));
            dtoc.setListaMontoVentaRecomendadas(dtoLista);
            UtilidadesLog.debug("************* 5.8");
            dtoc.setIndMontoVentaRecomendadas(Boolean.FALSE);
        }

        UtilidadesLog.debug("*********** 8");
        dtoc.setVariablesVenta(this.obtenerVariablesVenta(DTOE));

        if (dtoc.getVariablesVenta() != null) {
            dtoc.setIndVariablesVenta(Boolean.TRUE);
        } else {
            dtoc.setIndVariablesVenta(Boolean.FALSE);
        }

        UtilidadesLog.debug("*********** 9");
        dtoc.setVariablesVentaProyectada(this.obtenerVariablesVentaProyectada(DTOE));

        if (dtoc.getVariablesVentaProyectada() != null) {
            dtoc.setIndVariablesVentaProyectada(Boolean.TRUE);
        } else {
            dtoc.setIndVariablesVentaProyectada(Boolean.FALSE);
        }

        UtilidadesLog.debug("*********** 10");

        DTOClasificacionParticipantes dtoParticipante = new DTOClasificacionParticipantes();
        dtoParticipante.setOidPais(DTOE.getOidPais());
        dtoParticipante.setOidIdioma(DTOE.getOidIdioma());
        dtoParticipante.setOidConcurso(DTOE.getOid());
        dtoParticipante.setOidDirigidoA(dtoc.getParamGenerales().getOidDirigidoA());
        dtoc.setClasificParticipantes(this.obtenerListasClasificacion(dtoParticipante));

        if ((dtoc.getClasificParticipantes() != null) && (dtoc.getClasificParticipantes().getLstClasificacionParticipantes() != null) &&
                (dtoc.getClasificParticipantes().getLstClasificacionParticipantes().size() > 0)) {
            dtoc.setIndClasificacionParticipantes(Boolean.TRUE);
        } else {
            dtoc.setIndClasificacionParticipantes(Boolean.FALSE);
        }

        UtilidadesLog.debug("*********** 11");
        dtoc.setParamConsultoras(this.obtenerParametrosConsultoras(DTOE));

        if (dtoc.getParamConsultoras() != null) {
            dtoc.setIndObligConsultoras(Boolean.TRUE);
            dtoc.setIndConsultoras(Boolean.TRUE);
        } else {
            dtoc.setIndObligConsultoras(Boolean.FALSE);
            dtoc.setIndConsultoras(Boolean.FALSE);
        }

        UtilidadesLog.debug("*********** 12");
        dtoc.setParamGralesPremiacion(this.obtenerParametrosPremiacion(DTOE));

        if (dtoc.getParamGralesPremiacion() != null) {
            dtoc.setIndObligPremios(Boolean.TRUE);
            dtoc.setIndPremios(Boolean.TRUE);
        } else {
            dtoc.setIndObligPremios(Boolean.FALSE);
            dtoc.setIndPremios(Boolean.FALSE);
        }

        UtilidadesLog.debug("*********** 13");
        dtoc.setRequisitosPremiacion(this.obtenerRequisitosPremiacion(DTOE));

        if (dtoc.getRequisitosPremiacion() != null) {
            dtoc.setIndObligRequisitosPremiacion(Boolean.TRUE);
            dtoc.setIndRequisitosPremacion(Boolean.TRUE);
        } else {
            dtoc.setIndObligRequisitosPremiacion(Boolean.FALSE);
            dtoc.setIndRequisitosPremacion(Boolean.FALSE);
        }

        UtilidadesLog.debug("*********** 14");
        dtoc.setListaCursosExigidosPremiacion(this.obtenerCursosExigidosPremiacion(DTOE));

        if (dtoc.getListaCursosExigidosPremiacion() != null) {
            dtoc.setIndCursosExigidosPremiacion(Boolean.TRUE);
        } else {
            dtoc.setIndCursosExigidosPremiacion(Boolean.FALSE);
        }

        UtilidadesLog.debug("*********** 15");
        dtoc.setListaProductosExigidosPremiacion(this.obtenerProductosExigidosPremiacion(DTOE));

        if (dtoc.getListaProductosExigidosPremiacion() != null) {
            dtoc.setIndProductosExigidosPremiacion(Boolean.TRUE);
        } else {
            dtoc.setIndProductosExigidosPremiacion(Boolean.FALSE);
        }

        UtilidadesLog.debug("*********** 16");
        dtoc.setDespachoPremios(this.obtenerDespachoPremios(DTOE));

        if (dtoc.getDespachoPremios() != null) {
            dtoc.setIndObligDespachoPremios(Boolean.TRUE);
            dtoc.setIndDespachoPremios(Boolean.TRUE);
        } else {
            dtoc.setIndObligDespachoPremios(Boolean.FALSE);
            dtoc.setIndDespachoPremios(Boolean.FALSE);
        }

        UtilidadesLog.debug("*********** 17");

        dtoc.setProductosValidos(this.obtenerProductosValidos(DTOE));

        if (dtoc.getProductosValidos() != null) {
            dtoc.setIndObligProductosValidos(Boolean.TRUE);
            dtoc.setIndProductosValidos(Boolean.TRUE);
        } else {
            dtoc.setIndObligProductosValidos(Boolean.FALSE);
            dtoc.setIndProductosValidos(Boolean.FALSE);
        }

        UtilidadesLog.debug("*********** 18");
        dtoc.setProductosExcluidos(this.obtenerProductosExcluidos(DTOE));

        if (dtoc.getProductosExcluidos() != null) {
            dtoc.setIndObligProductosExcluidos(Boolean.TRUE);
            dtoc.setIndProductosExcluidos(Boolean.TRUE);
        } else {
            dtoc.setIndObligProductosExcluidos(Boolean.FALSE);
            dtoc.setIndProductosExcluidos(Boolean.FALSE);
        }

        UtilidadesLog.debug("*********** 19");
        dtoc.setProductosBonificados(this.obtenerProductosBonificados(DTOE));

        if (dtoc.getProductosBonificados() != null) {
            dtoc.setIndObligProductosBonificados(Boolean.TRUE);
            dtoc.setIndProductosBonificados(Boolean.TRUE);
        } else {
            dtoc.setIndObligProductosBonificados(Boolean.FALSE);
            dtoc.setIndProductosBonificados(Boolean.FALSE);
        }

        UtilidadesLog.debug("*********** 20");
        dtoc.setProductosExigidos(this.obtenerProductosExigidos(DTOE));

        if (dtoc.getProductosExigidos() != null) {
            dtoc.setIndObligProductosExigidos(Boolean.TRUE);
            dtoc.setIndProductosExigidos(Boolean.TRUE);
        } else {
            dtoc.setIndObligProductosExigidos(Boolean.FALSE);
            dtoc.setIndProductosExigidos(Boolean.FALSE);
        }

        UtilidadesLog.debug("*********** 21");
        dtoc.setProductosACalificar(this.obtenerProductosACalificar(DTOE));

        if (dtoc.getProductosACalificar() != null) {
            dtoc.setIndObligProductosACalificar(Boolean.TRUE);
            dtoc.setIndProductosACalificar(Boolean.TRUE);
        } else {
            dtoc.setIndObligProductosACalificar(Boolean.FALSE);
            dtoc.setIndProductosACalificar(Boolean.FALSE);
        }

        UtilidadesLog.debug("*********** 22");
        dtoc.setProductosExcluidosCalificacion(this.obtenerProductosExcluidosCalificacion(DTOE));

        if (dtoc.getProductosExcluidosCalificacion() != null) {
            dtoc.setIndObligProductosExcluidosCalificacion(Boolean.TRUE);
            dtoc.setIndProductosExcluidosCalificacion(Boolean.TRUE);
        } else {
            dtoc.setIndObligProductosExcluidosCalificacion(Boolean.FALSE);
            dtoc.setIndProductosExcluidosCalificacion(Boolean.FALSE);
        }

        UtilidadesLog.debug("*********** 23");
        dtoc.setParamCalificacion(this.obtenerParametrosCalificacion(DTOE));

        if (dtoc.getParamCalificacion() != null) {
            dtoc.setIndObligCalificacion(Boolean.TRUE);
            dtoc.setIndParamCalificacion(Boolean.TRUE);
        } else {
            dtoc.setIndObligCalificacion(Boolean.FALSE);
            dtoc.setIndParamCalificacion(Boolean.FALSE);
        }

        UtilidadesLog.debug("*********** 24");

        // Agregado por ssantan, 4/6/2005
        // Por incidencia 18472. 
        Long oidDirigidoA = dtoc.getParamGenerales().getOidDirigidoA();
        Long oidConcurso = DTOE.getOid();
        Long oidIdioma = DTOE.getOidIdioma();
        ArrayList lstCalificacionParticipantes = null;
        ArrayList lstParticipantes = null;
        dtoOidParticipante = new DTOOID();
        dtoOidParticipante.setOidIdioma(oidIdioma);
        dtoOidParticipante.setOidPais(DTOE.getOidPais());
        dtoOidParticipante.setOid(oidDirigidoA);
        UtilidadesLog.debug("*********** 25");

        dtoSalida = new DTOSalida();
        r = daoConcurso.obtenerListaParticipantes(dtoOidParticipante);
        dtoSalida.setResultado(r);
        UtilidadesLog.debug("dtoSalida: " + dtoSalida);

        lstCalificacionParticipantes = daoConcurso.obtenerListasCalificacionParticipantes(oidDirigidoA, oidConcurso, oidIdioma);

        lstParticipantes = this.recordsetToArrayListaParticipantes(r);
        dtoCalificacionParticipantes = new DTOCalificacionParticipantes();
        dtoCalificacionParticipantes.setOidConcurso(oidConcurso);
        dtoCalificacionParticipantes.setOidDirigidoA(oidDirigidoA);
        dtoCalificacionParticipantes.setLstCalificacionParticipantes(lstCalificacionParticipantes);
        dtoCalificacionParticipantes.setLstParticipantes(lstParticipantes);
        dtoc.setCalificacionParticipantes(dtoCalificacionParticipantes);

        if ((dtoc.getCalificacionParticipantes() != null) && (dtoc.getCalificacionParticipantes().getLstCalificacionParticipantes() != null) &&
                (dtoc.getCalificacionParticipantes().getLstCalificacionParticipantes().size() > 0)) {
            dtoc.setIndClasificacionParticipantesCalificacion(Boolean.TRUE);
        } else {
            dtoc.setIndClasificacionParticipantesCalificacion(Boolean.FALSE);
        }

        // vbongiov -- Cambio 20080811 -- 26/08/2009
        if(dtoc.getPlantilla().getIndSorteo()!= null && dtoc.getPlantilla().getIndSorteo().booleanValue()){
            dtoc.setListaNivelesPremiacion(null);
        } else {
            dtoc.setListaNivelesPremiacion(null);
            dtoc.setListaNivelesPremiacion(this.obtenerNivelesPremiacion(DTOE));
        }

        if (dtoc.getListaNivelesPremiacion() != null) {
            dtoc.setIndNivelPremiacion(Boolean.TRUE);
        } else {
            dtoc.setIndNivelPremiacion(Boolean.FALSE);
        }

        dtoc.setParamGerentes(this.obtenerParametrosGerentes(DTOE));

        if (dtoc.getParamGerentes() != null) {
            dtoc.setIndObligGerentes(Boolean.TRUE);
            dtoc.setIndGerentes(Boolean.TRUE);
        } else {
            dtoc.setIndObligGerentes(Boolean.FALSE);
            dtoc.setIndGerentes(Boolean.FALSE);
        }

        UtilidadesLog.debug("*********** 26");
        dtoc.setMultinivel(this.obtenerMultinivel(DTOE));

        if (dtoc.getMultinivel() != null) {
            dtoc.setIndObligMultinivel(Boolean.TRUE);
            dtoc.setIndMultinivel(Boolean.TRUE);
        } else {
            dtoc.setIndObligMultinivel(Boolean.FALSE);
            dtoc.setIndMultinivel(Boolean.FALSE);
        }

        UtilidadesLog.debug("*********** 27");

        UtilidadesLog.debug(dtoc);
        UtilidadesLog.info("MONConcursoBean.obtenerDatosConcurso(DTOOID DTOE):Salida");
        return dtoc;
    }

    public DTOParametrosGeneralesConcurso obtenerParametrosGeneralesConcurso(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerParametrosGeneralesConcurso(DTOOID DTOE):Entrada");
        ConcursoParametrosGeneralesLocalHome concursoParametrosGeneralesLH = null;
        ConcursoParametrosGeneralesLocal concursoParametrosGeneralesL = null;
        Entidadi18nLocalHome entidadi18nLH = null;
        AccesoConcursoLocalHome accesoConcursoLH = null;

        try {
            concursoParametrosGeneralesLH = this.getConcursoParametrosGeneralesLocalHome();
            accesoConcursoLH = this.getAccesoConcursoLocalHome();
            entidadi18nLH = this.getEntidadi18nLocalHome();
            concursoParametrosGeneralesL = concursoParametrosGeneralesLH.findByPrimaryKey(DTOE.getOid());
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        DTOParametrosGeneralesConcurso dtoPGC = new DTOParametrosGeneralesConcurso();
        dtoPGC.setOid(concursoParametrosGeneralesL.getOid());
        dtoPGC.setOidPlantilla(concursoParametrosGeneralesL.getPlantilla());
        dtoPGC.setNombreConcurso(concursoParametrosGeneralesL.getNombre());

        dtoPGC.setIndActivo(concursoParametrosGeneralesL.getActivo());
        dtoPGC.setOidCanal(concursoParametrosGeneralesL.getCanal());
        dtoPGC.setIndRanking(concursoParametrosGeneralesL.getRanking());
        
        //jrivas 25/1/2007 Cambio Dupla Cyzone
        dtoPGC.setIndDuplaCyzone(concursoParametrosGeneralesL.getIndDuplaCyzone());
        
        // vbongiov -- Cambio 20080809 -- 7/04/2009
        dtoPGC.setOidClasificacionConcurso(concursoParametrosGeneralesL.getOidClasificacionConcurso());
        
         // vbongiov -- Cambio 20090930 -- 16/07/2009
        dtoPGC.setIndNoGeneraPunt(concursoParametrosGeneralesL.getIndNoGeneraPunt());

        // sapaza -- PER-SiCC-2011-0042 -- 18/01/2011
        dtoPGC.setOidTipoOfertaConcurso(concursoParametrosGeneralesL.getOidTipoOfertaConcurso());
        
        // sapaza -- PER-SICC-2012-0082 -- 16/05/2012
        dtoPGC.setIndMultiMarca(concursoParametrosGeneralesL.getIndMultiMarca());
        dtoPGC.setPuntosAbonar(concursoParametrosGeneralesL.getPuntosAbonar());

        Entidadi18nLocal ei18n = null;

        try {
            ei18n = entidadi18nLH.findByEntAtrIdioPK(ConstantesINC.ENTIDAD_CANAL, new Long(ConstantesINC.NUM_ATRIBUTO.toString()),
                                                     DTOE.getOidIdioma(), concursoParametrosGeneralesL.getCanal());
        } catch (NoResultException nre) {
            try {
                ei18n = entidadi18nLH.findByEntAtrIdioPK(ConstantesINC.ENTIDAD_CANAL, new Long(ConstantesINC.NUM_ATRIBUTO.toString()),
                                                         ConstantesSEG.IDIOMA_DEFECTO, concursoParametrosGeneralesL.getCanal());
            } catch (NoResultException nrex) {

            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            
            }
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));

        }

        //Si se obtuvieron valores en la busqueda, se asigna la descripcion de canal
        //al dto.
        if (ei18n != null) {
            dtoPGC.setDesCanal(ei18n.getDetalle());
        }

        dtoPGC.setOidMarca(concursoParametrosGeneralesL.getMarca());
        dtoPGC.setOidPeriodoDesde(concursoParametrosGeneralesL.getPeriodoDesde());
        dtoPGC.setOidPeriodoHasta(concursoParametrosGeneralesL.getPeriodoHasta());
        dtoPGC.setIndDevoluciones(concursoParametrosGeneralesL.getDevoluciones());
        dtoPGC.setIndAnulaciones(concursoParametrosGeneralesL.getAnulaciones());
        dtoPGC.setIndFaltantesNoAnunciados(concursoParametrosGeneralesL.getFaltantesNoAnunciados());
        dtoPGC.setOidDirigidoA(concursoParametrosGeneralesL.getDirigidoA());

        try {
            ei18n = entidadi18nLH.findByEntAtrIdioPK(ConstantesINC.ENTIDAD_DIRIGIDO_A, new Long(ConstantesINC.NUM_ATRIBUTO.toString()),
                                                     dtoPGC.getOidIdioma(), dtoPGC.getOidDirigidoA());
        } catch (NoResultException nre) {
            try {
                ei18n = entidadi18nLH.findByEntAtrIdioPK(ConstantesINC.ENTIDAD_DIRIGIDO_A, new Long(ConstantesINC.NUM_ATRIBUTO.toString()),
                                                         ConstantesSEG.IDIOMA_DEFECTO, dtoPGC.getOidDirigidoA());
            } catch (NoResultException nrex) {

            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            
            }
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        if (ei18n != null) {
            dtoPGC.setDirigidoA(ei18n.getDetalle());
        }

        dtoPGC.setExpresionPuntaje(concursoParametrosGeneralesL.getExpresionPuntaje());
        dtoPGC.setIndPruebas(concursoParametrosGeneralesL.getPruebas());
        dtoPGC.setObservaciones(concursoParametrosGeneralesL.getObservaciones());
        dtoPGC.setOidTipoConcursoIVR(concursoParametrosGeneralesL.getTipoConcursoIVR());
        //agregado por cvalenzu - 4/7/2007 - fac-003
        dtoPGC.setOidTipoPrograma(concursoParametrosGeneralesL.getTipoPrograma());
        
        /* 
         * 03/05/2006, ssantana, versionado
         * 
         */
         VersionesConcursoLocal datosVersion = null;
         try {
             VersionesConcursoLocalHome vConcursoLocal =  this.getVersionesConcursoLocalHome();
         
             Collection col = vConcursoLocal.findByConcurso(dtoPGC.getOid());
             Iterator it = col.iterator();
             /* Devuelve solamente un registro */
             while (it.hasNext()) {
                 datosVersion = (VersionesConcursoLocal) it.next();
                 Long periodoEntradaVigor = datosVersion.getPeriodoEntradaVigor();
                 Long vigenciaConcurso = datosVersion.getVigenciaConcurso();
                 
                 dtoPGC.setOidPeriodoEntradaVigor(periodoEntradaVigor);
                 dtoPGC.setOidVigenciaConcurso(vigenciaConcurso);                
                 
                 PeriodoLocalHome periodoLocalHome = this.getPeriodoLocalHome();
                 PeriodoLocal periodoLocalDesde = 
                            periodoLocalHome.findByPrimaryKey(dtoPGC.getOidPeriodoDesde());
                 PeriodoLocal periodoLocalHasta = 
                            periodoLocalHome.findByPrimaryKey(dtoPGC.getOidPeriodoHasta());
                            
                 dtoPGC.setCodPeriodoDesde(periodoLocalDesde.getNombrePeriodo());
                 dtoPGC.setCodPeriodoHasta(periodoLocalHasta.getNombrePeriodo());
             }
         } catch (NoResultException ex) {
            UtilidadesLog.error("ERROR ", ex);
            String sCodError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            int codError = UtilidadesError.armarCodigoError(sCodError);
            throw new MareException(ex, codError);
         } catch (PersistenceException ce) {
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
         }
         
        Collection colAccesoConcurso = null;

        try {
            colAccesoConcurso = accesoConcursoLH.findByConcurso(DTOE.getOid());
        } catch (NoResultException fe) {

        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        if ((colAccesoConcurso != null) && !colAccesoConcurso.isEmpty()) {
            dtoPGC.setLstAccesos(new ArrayList());

            Iterator it = colAccesoConcurso.iterator();

            while (it.hasNext()) {
                dtoPGC.getLstAccesos().add(((AccesoConcursoLocal) it.next()).getAcceso());
            }
        }
        UtilidadesLog.info("MONConcursoBean.obtenerParametrosGeneralesConcurso(DTOOID DTOE):Salida");
        return dtoPGC;
    }


    //Llama al método obtenerTiposExigencia(DTOE) de la clase DAOConcurso y 
    //obtiene el RecordSet "tiposExigencia" 
    //DTOSalida.resultado = tiposExigencia
    public DTOSalida obtenerTiposExigencia(DTOBelcorp dtoE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerTiposExigencia(DTOBelcorp dtoE):Entrada");
        DTOSalida dtoS = new DTOSalida();
        DAOConcurso dao = new DAOConcurso();
        RecordSet rs = dao.obtenerTiposExigencia(dtoE);

        if (rs.esVacio()) {
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        dtoS.setResultado(rs);
        UtilidadesLog.info("MONConcursoBean.obtenerParametrosGeneralesConcurso(DTOOID DTOE):Salida");
        return dtoS;
    }

    /*
       * Llama al método obtenerTiposRequisito(DTOE) de la clase DAOConcurso y
       * obtiene el RecordSet "tiposrequisito"
       * DTOSalida.resultado = tiposRequisito
       *
       */
    public DTOSalida obtenerTiposRequisito(DTOBelcorp dtoE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerTiposRequisito(DTOBelcorp dtoE):Entrada");
        DAOConcurso dao = new DAOConcurso();
        RecordSet respuesta = null;

        // cambiar el nombre
        respuesta = dao.obtenerTiposRequisito(dtoE);

        if ((respuesta == null) || respuesta.esVacio()) {
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        UtilidadesLog.info("MONConcursoBean.obtenerTiposRequisito(DTOBelcorp dtoE):Salida");
        return (new DTOSalida(respuesta));
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param dtoOid DTOOID
     * @version 1.00 25 abr 2005
     * @author Igor Dedough
     *
     * Este método obtiene las versiones para el
     * caso de uso "mantener versiones concurso",
     * llamando al método del DAOConcurso del mismo nombre
     * versiones = llamar al método DAOConcurso.obtenerVersionesConcurso (DTOE)
     * Crear un DTOSalida con:
     * DTOSalida.resultado = versiones
     */
    public DTOSalida obtenerVersionesConcurso(DTOOIDPaginado dtoOid)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerVersionesConcurso(DTOOIDPaginado dtoOid):Entrada");
        UtilidadesLog.debug("entro METHOD obtenerVersionesConcurso(DTOBuscarPlantillas dtoOid) ");

        DTOSalida dtos = new DTOSalida();
        dtos.setResultado((new DAOConcurso()).obtenerVersionesConcurso(dtoOid));
        UtilidadesLog.info("MONConcursoBean.obtenerVersionesConcurso(DTOOIDPaginado dtoOid):Salida");
        return dtos;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param dtoe DTOVersion
     * @version 1.00 25 abr 2005
     * @author Igor Dedough
     *
     * existe = llamar al método DAOConcurso.obtenerVersionesSuperiores
     * Crear un DTOBoolean con:
     * DTOBoolean.resultado = existe
     * Devolver DTOBoolean
     */
    public DTOBoolean obtenerVersionesSuperiores(DTOVersion dtoe)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerVersionesSuperiores(DTOVersion dtoe):Entrada");
        DTOBoolean aux = new DTOBoolean();
        aux.setValor((new DAOConcurso()).obtenerVersionesSuperiores(dtoe).booleanValue());
        
        UtilidadesLog.info("MONConcursoBean.obtenerVersionesSuperiores(DTOVersion dtoe):Salida");
        return aux;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param dtoe DTONuevaVersion
     * @version 1.00 25 abr 2005
     * @author Igor Dedough
     *
     * ConcursoParametrosGenerales
     * concurso = findByPk (DTOE.oidConcurso) de la entidad ConcursoParametrosGenerales
     * Se modifica el campo:
     * concurso.periodoHasta = DTOE.oidPeriodoHasta
     *
     * //RequisitosPremiacion
     * requisito = findByPk (DTOE.oidRequisitoPremiacion) de la entidad RequisitosPremiacion
     * Se modifican los siguientes campos:
     * requisito.pagoATiempo = DTOE.indPagoTiempo
     * requisito.diasGracia = DTOE.diasGracia
     * requisito.PeriodoDesde = DTOE.oidPeriodoDesdeReq
     * requisito.PeriodoHasta = DTOE.oidPeriodoHastaReq
     *
     * //VersionesConcurso
     * version = findByPk (DTOE.oidVersion) de la entidad VersionesConcurso
     * Se modifica el campo:
     * version.periodoEntradaVigor = DTOE.oidPeriodoPuestaMarcha
     *
     *

     inc. 20333
     MONConcurso.actualizarNuevaVersion

     //ConcursoParametrosGenerales
     concurso = findByPk (DTOE.oidConcurso) de la entidad ConcursoParametrosGenerales
     Se modifica el campo:
     concurso.periodoHasta = DTOE.oidPeriodoHasta

     //RequisitosPremiacion
     requisito = findByPk (DTOE.oidRequisitoPremiacion) de la entidad RequisitosPremiacion
     Se modifican los siguientes campos:
     requisito.pagoATiempo = DTOE.indPagoTiempo
     requisito.diasGracia = DTOE.diasGracia
     requisito.PeriodoDesde = DTOE.oidPeriodoDesdeReq
     requisito.PeriodoHasta = DTOE.oidPeriodoHastaReq

      //VersionesConcurso
      version = findByPk (DTOE.oidVersion) de la entidad VersionesConcurso
      Se modifica el campo:
      version.periodoEntradaVigor = DTOE.oidPeriodoPuestaMarcha
      **********----------------------------AGREGADO---------------------**********
      version.concurso = DTOE.oidConcurso
      **********---------------------------------------------------------**********

      @CHANGELOG
      --------------------------
      2005.08.2 GMIOTTI DT
      Se agrega la asignacion del valor oidConcurso para la version correspondiente.
     *
     */
    public void actualizarNuevaVersion(DTONuevaVersion dtoe)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.actualizarNuevaVersion(DTONuevaVersion dtoe):Entrada");
        /*ConcursoParametrosGeneralesLocalHome concParGralsLH = null;
        ConcursoParametrosGeneralesLocal concParGralsL = null; */
        UtilidadesLog.debug("----- MONConcurso.actualizarNuevaVersion()");
        UtilidadesLog.debug("DTONuevaVersion: " + dtoe);
        VersionesConcursoLocalHome versConcLH = null;
        VersionesConcursoLocal versConcL = null;

        RequisitosPremiacionLocal reqPremL = null;

        try {
            if ((dtoe.getOidConcurso() != null) && (dtoe.getOidPeriodoHasta() != null)) {
                UtilidadesLog.debug("- Setea Periodo Hasta");
                ConcursoParametrosGeneralesLocal concursoL = this.getConcursoParametrosGeneralesLocalHome().findByPrimaryKey(dtoe.getOidConcurso());
                concursoL.setPeriodoHasta(dtoe.getOidPeriodoHasta());
                this.getConcursoParametrosGeneralesLocalHome().merge(concursoL);
            }

            if (dtoe.getOidRequisitoPremiacion() != null) {
                UtilidadesLog.debug("- Setea Requisitos Premiacion");
                reqPremL = (this.getRequisitosPremiacionLocalHome()).findByPrimaryKey(dtoe.getOidRequisitoPremiacion());
                reqPremL.setPagoATiempo(dtoe.getIndPagoTiempo());
                reqPremL.setDiasGracia(dtoe.getDiasGracia());
                reqPremL.setPeriodoDesde(dtoe.getOidPeriodoDesdeReq());
                reqPremL.setPeriodoHasta(dtoe.getOidPeriodoHastaReq());
                this.getRequisitosPremiacionLocalHome().merge(reqPremL);
                
            }

            versConcLH = this.getVersionesConcursoLocalHome();

            // INC 21471 - dmorello, 28/12/2005
            // Anteriormente se entraba al siguiente IF si dtoe.oidVersion != null
            // y si dtoe.oidPeriodoPuestaMarcha != null. Ahora, la segunda condición se verificará
            // dentro del IF, de modo de poder guardar el OID de concurso por más que no haya
            // en el DTO un OID de periodo de puesta en marcha
            if (dtoe.getOidVersion() != null) {
                versConcL = versConcLH.findByPrimaryKey(dtoe.getOidVersion());
                
                if (dtoe.getOidPeriodoPuestaMarcha() != null) {
                    UtilidadesLog.debug("- Setea Entrada en Vigor");    
                    versConcL.setPeriodoEntradaVigor(dtoe.getOidPeriodoPuestaMarcha());    
                }

                if (dtoe.getOidConcurso() != null) {
                    UtilidadesLog.debug("- Set OidConcurso");
                    versConcL.setConcurso(dtoe.getOidConcurso());
                }
                versConcLH.merge(versConcL);
            }
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            sessionContext.setRollbackOnly();
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONConcursoBean.actualizarNuevaVersion(DTONuevaVersion dtoe):Salida");
    }

    
    public void borrarConcurso(DTOVersion dtoe) throws MareException {
        UtilidadesLog.info("MONConcursoBean.borrarConcurso(DTOVersion dtoe):Entrada");
        try {
            if (dtoe.getOid() != null) {
                // INC 21471 - dmorello, 23/12/2005: Se guarda el OID de concurso en variable aparte
                VersionesConcursoLocal version = this.getVersionesConcursoLocalHome().findByPrimaryKey(dtoe.getOid());
                Long oidConcurso = version.getConcurso();

                if(dtoe.getIndBorrado().intValue() == 1) {
                  version.setConcurso(null);  
                  //Agregado por incidencia BELC300024406
                  //cvalenzu - 31/10/2006
                  version.setEstadoConcurso(ConstantesINC.OID_ESTADO_AUTORIZADO);                 
                  //Fin - Agregado por incidencia BELC300024406
                  this.getVersionesConcursoLocalHome().merge(version);
                }
                
                if(dtoe.getIndBorrado().intValue() == 2) {
                    this.getVersionesConcursoLocalHome().remove(version);
                }
                
                // INC 21471 - dmorello, 28/12/2005: Se pregunta por el OID guardado en la variable anterior
                if (oidConcurso != null) {
                    ConcursoParametrosGeneralesLocal concursoLocal = this.getConcursoParametrosGeneralesLocalHome().findByPrimaryKey(oidConcurso);
                    this.getConcursoParametrosGeneralesLocalHome().remove(concursoLocal);
                }
                // Fin modificaciones INC 21471
            }
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException re) {
            UtilidadesLog.error("ERROR ", re);
            sessionContext.setRollbackOnly();
            throw new MareException(re, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
        UtilidadesLog.info("MONConcursoBean.borrarConcurso(DTOVersion dtoe):Salida");
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param dtoe DTOVersion
     * @version 1.00 25 abr 2005
     * @author Igor Dedough
     */

    // crea Concurso Nueva Version
    public DTONuevaVersion crearConcursoNuevaVersion(DTOVersion dtoe)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.crearConcursoNuevaVersion(DTOVersion dtoe):Entrada");
        UtilidadesLog.debug(" method crearConcursoNuevaVersion ");

        DTONuevaVersion dtoNuevaVersion = null;

        if (dtoe.getOidConcursoOrigen() != null) {
            UtilidadesLog.debug(" dtoe.getOidConcursoOrigen() !null ");

            ConcursoParametrosGeneralesLocal concursoOrigen = null;
            ConcursoParametrosGeneralesLocalHome concParGralLH = null;

            concParGralLH = this.getConcursoParametrosGeneralesLocalHome();

            // valor de oid de Concurso Origen         
            Long argOidConcOrig = dtoe.getOidConcursoOrigen();

            try {
                concursoOrigen = concParGralLH.findByPrimaryKey(argOidConcOrig);
            } catch (NoResultException fe) {
                UtilidadesLog.error("ERROR ", fe);
                throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            // (!) -> salto left en 4ch por falta espacio                          
            // verifique si concurso origen !NULL 
            if (concursoOrigen != null) {
                UtilidadesLog.debug(" concursoOrigen !null ");
                UtilidadesLog.debug(" crea Concurso Parametros Generales ");

                Long crOidConcOrig = null;

                UtilidadesLog.debug(" dtoe.getNumeroConcurso() " + dtoe.getNumeroConcurso());
                UtilidadesLog.debug(" dtoe.getVersionNueva() " + dtoe.getVersionNueva());
                UtilidadesLog.debug(" concursoOrigen.getPais() " + concursoOrigen.getPais());

                ConcursoParametrosGeneralesLocal concursoExistente = null;

                try {
                    UtilidadesLog.debug("1");

                    if ((dtoe.getNumeroConcurso() != null) && (dtoe.getVersionNueva() != null) && (concursoOrigen.getPais() != null)) {
                        UtilidadesLog.debug("2");

                        concursoExistente = concParGralLH.findByCamposClave(dtoe.getNumeroConcurso(), dtoe.getVersionNueva(), concursoOrigen.getPais());
                    }

                    UtilidadesLog.debug("3");

                    // concursoNuevo = findByCamposClave(DTOE.numeroConcurso, DTOE.version, concursoOrigen.pais) sobre la entidad ConcursoParametrosGenerales
                } catch (NoResultException fe) {
                    UtilidadesLog.debug("concurso no existe");
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }

                UtilidadesLog.debug("4");

                // inc.20446 - dt - jpollio, implantación - idedough
                if (concursoExistente == null) {
                    UtilidadesLog.debug("5");

                    //String numeroConcurso = obtenerNumeroConcurso();            
                    // crea Concurso Parametros Generales
                    try {
                        if (concursoOrigen.getIndDuplaCyzone() == null) {
                            concursoOrigen.setIndDuplaCyzone(Boolean.FALSE);
                            concParGralLH.merge(concursoOrigen);
                            
                        }
                        
                        ConcursoParametrosGeneralesLocal concursoOrigen2 = concParGralLH.create(null, concursoOrigen.getNumeroConcurso(),
                                                                                                dtoe.getVersionNueva(), concursoOrigen.getPais(),
                                                                                                concursoOrigen.getNombre(),
                                                                                                concursoOrigen.getRanking(),
                                                                                                concursoOrigen.getPeriodoDesde(),
                                                                                                concursoOrigen.getPeriodoHasta(),
                                                                                                concursoOrigen.getDirigidoA(),
                                                                                                concursoOrigen.getMarca(), concursoOrigen.getCanal(), concursoOrigen.getIndDuplaCyzone());

                        concursoOrigen2.setTipoExigencia(concursoOrigen.getTipoExigencia());
                        concursoOrigen2.setTipoConcursoIVR(concursoOrigen.getTipoConcursoIVR());
                        concursoOrigen2.setStatusGeneracionMetas(concursoOrigen.getStatusGeneracionMetas());
                        concursoOrigen2.setPruebas(concursoOrigen.getPruebas());
                        concursoOrigen2.setPlantilla(concursoOrigen.getPlantilla());
                        concursoOrigen2.setObservaciones(concursoOrigen.getObservaciones());
                        concursoOrigen2.setMensaje(concursoOrigen.getMensaje());
                        concursoOrigen2.setFaltantesNoAnunciados(concursoOrigen.getFaltantesNoAnunciados());
                        concursoOrigen2.setExpresionPuntaje(concursoOrigen.getExpresionPuntaje());
                        concursoOrigen2.setDevoluciones(concursoOrigen.getDevoluciones());
                        concursoOrigen2.setComunicacion(concursoOrigen.getComunicacion());
                        concursoOrigen2.setBaseCalculo(concursoOrigen.getBaseCalculo());
                        concursoOrigen2.setAnulaciones(concursoOrigen.getAnulaciones());
                        concursoOrigen2.setActivo(concursoOrigen.getActivo());
                        //agregado por cvalenzu - 4/7/2007 - fac-003
                        concursoOrigen2.setTipoPrograma(concursoOrigen.getTipoPrograma());
                        // vbongiov -- Cambio 20080809 -- 7/04/2009
                        concursoOrigen2.setIndNoGeneraPunt(concursoOrigen.getIndNoGeneraPunt());
                        
                         // vbongiov -- Cambio 20090930 -- 16/07/2009
                        concursoOrigen2.setOidClasificacionConcurso(concursoOrigen.getOidClasificacionConcurso());

                        // sapaza -- PER-SiCC-2011-0042 -- 18/01/2011
                        concursoOrigen2.setOidTipoOfertaConcurso(concursoOrigen.getOidTipoOfertaConcurso());
                        
                        // sapaza -- PER-SICC-2012-0082 -- 16/05/2012
                        concursoOrigen2.setIndMultiMarca(concursoOrigen.getIndMultiMarca());
                        concursoOrigen2.setPuntosAbonar(concursoOrigen.getPuntosAbonar());
                        
                        concParGralLH.merge(concursoOrigen2);

                        // clave creado para crear registros de nueva version                                 
                        crOidConcOrig = concursoOrigen2.getOid();
                    } catch (PersistenceException ce) {
                        UtilidadesLog.error("ERROR ", ce);
                        sessionContext.setRollbackOnly();
                        throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
                    }

                    UtilidadesLog.debug("6");

                    if (crOidConcOrig != null) {
                        UtilidadesLog.debug("7");

                        //---------------------------------------------------------------------
                        try {
                            UtilidadesLog.debug("Concurso Parametros Gerentes ");

                            // crea Concurso Parametros Gerentes by Concurso
                            ConcursoParametrosGerentesLocalHome concParamGerentesLH = this.getConcursoParametrosGerentesLocalHome();
                            ConcursoParametrosGerentesLocal concParGerL = concParamGerentesLH.findByConcurso(argOidConcOrig);
                            concParamGerentesLH.create(crOidConcOrig, concParGerL.getFormaCalculo());

                        } catch (NoResultException fe) {
                            UtilidadesLog.debug(" FinderException Concurso Parametros Gerentes ");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("CreateEx Concurso Parametros Gerentes");
                        }

                        try {
                            UtilidadesLog.debug(" crea Monto Venta Recomendadas by Concurso ");

                            // crea Monto Venta Recomendadas by Concurso
                            MontoVentaRecomendadasLocalHome montoVentaRecomendadasLH = this.getMontoVentaRecomendadasLocalHome();
                            Collection collMontoVentaRecomendadas = montoVentaRecomendadasLH.findByConcurso(argOidConcOrig);

                            if (collMontoVentaRecomendadas != null) {
                                UtilidadesLog.debug("collMontoVentaRecomendadas != null ");

                                for (Iterator itMontoVentaRecomendadas = collMontoVentaRecomendadas.iterator(); itMontoVentaRecomendadas.hasNext();) {
                                    montoVentaRecomendadasLH.create(crOidConcOrig,
                                                                    ((MontoVentaRecomendadasLocal) itMontoVentaRecomendadas.next()).getTipoMontoVenta());
                                }
                            } // collMontoVentaRecomendadas !null
                        } catch (NoResultException fe) {
                            UtilidadesLog.debug("FinderEx Monto Venta Recomendadas ");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("CreateEx Monto Venta Recomendadas");
                        }

                        try {
                            UtilidadesLog.debug("crea Concurso Variables Venta Gerentes by Concurso");

                            // crea Concurso Variables Venta Gerentes by Concurso
                            ConcursoVariablesVentaGerentesLocalHome concVarVentGerLH = this.getConcursoVariablesVentaGerentesLocalHome();
                            Collection collConcVarVentGer = concVarVentGerLH.findByConcurso(argOidConcOrig);

                            if (collConcVarVentGer != null) {
                                UtilidadesLog.debug("collConcVarVentGer != null ");

                                for (Iterator itConcVarVentGer = collConcVarVentGer.iterator(); itConcVarVentGer.hasNext();) {
                                    concVarVentGerLH.create(crOidConcOrig);
                                }
                            } // collConcVarVentGer !null
                        } catch (NoResultException fe) {
                            UtilidadesLog.debug("FinderEx Concurso Variables Venta Gerentes");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("CreateEx Concurso Variables Venta Gerentes");
                        }

                        try {
                            UtilidadesLog.debug("crea ClasificacionParticipantesConcurso by Concurso");

                            // crea ClasificacionParticipantesConcurso by Concurso
                            ClasificacionParticipantesConcursoLocal clasifParticConcL = null;
                            ClasificacionParticipantesConcursoLocal crt_clasifParticConcL = null;

                            ClasificacionParticipantesConcursoLocalHome clasifParticConcLH = this.getClasificacionParticipantesConcursoLocalHome();
                            Collection collClasifParticiConc = clasifParticConcLH.findByConcurso(argOidConcOrig);

                            if (collClasifParticiConc != null) {
                                UtilidadesLog.debug("collClasifParticiConc != null ");

                                for (Iterator itClasifParticiConc = collClasifParticiConc.iterator(); itClasifParticiConc.hasNext();) {
                                    clasifParticConcL = (ClasificacionParticipantesConcursoLocal) itClasifParticiConc.next();

                                    crt_clasifParticConcL = clasifParticConcLH.create(crOidConcOrig, clasifParticConcL.getParticipante());

                                    // all fields                                                                                                                 
                                }
                            } // collClasifParticiConc !null
                        } catch (NoResultException fe) {
                            UtilidadesLog.debug(" FinderException ClasificacionParticipantesConcurso");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("CreateEx ClasificacionParticipantesConcurso");
                        }

                        try {
                            UtilidadesLog.debug("crea ConcursoParametroConsultoras by UK");

                            // crea ConcursoParametroConsultoras by UK
                            ConcursoParametrosConsultorasLocal concParConsL = null;
                            ConcursoParametrosConsultorasLocal crt_concParConsL = null;
                            ConcursoParametrosConsultorasLocalHome concParConsLH = this.getConcursoParametrosConsultorasLocalHome();
                            concParConsL = concParConsLH.findByUK(argOidConcOrig);

                            if (concParConsL != null) {
                                UtilidadesLog.debug("concParConsL != null ");

                                crt_concParConsL = concParConsLH.create(crOidConcOrig);

                                crt_concParConsL.setTipoVenta(concParConsL.getTipoVenta());
                                crt_concParConsL.setControlRecomendadas(concParConsL.getControlRecomendadas());
                                crt_concParConsL.setMontoMinimoPedido(concParConsL.getMontoMinimoPedido());
                                crt_concParConsL.setNumeroMinimoPedidos(concParConsL.getNumeroMinimoPedidos());
                                crt_concParConsL.setNumeroMinimoPedidosRecomendada(concParConsL.getNumeroMinimoPedidosRecomendada());
                                crt_concParConsL.setPeriodoDesde(concParConsL.getPeriodoDesde());
                                crt_concParConsL.setPeriodoHasta(concParConsL.getPeriodoHasta());
                                crt_concParConsL.setPeriodoInicialEvaluacion(concParConsL.getPeriodoInicialEvaluacion());
                                crt_concParConsL.setRecomendacionEfectiva(concParConsL.getRecomendacionEfectiva());
                                crt_concParConsL.setReingresoPierdePuntaje(concParConsL.getReingresoPierdePuntaje());
                                crt_concParConsL.setPeriodosEvaluacion(concParConsL.getPeriodosEvaluacion());
                                crt_concParConsL.setUnidadesMinimasPedido(concParConsL.getUnidadesMinimasPedido());
                                
                                concParConsLH.merge(crt_concParConsL);

                                // all fields 
                            } // concParConsL  !null
                        } catch (NoResultException fe) {
                            UtilidadesLog.debug(" FinderException ConcursoParametroConsultoras ");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("CreateEx ConcursoParametroConsultoras");
                        }

                        try {
                            UtilidadesLog.debug("crea EstatusVentaConsultoras by Concurso ");

                            // crea EstatusVentaConsultoras by Concurso
                            EstatusVentaConsultoraLocal estVentConsL = null;
                            EstatusVentaConsultoraLocalHome estVentConsLH = this.getEstatusVentaConsultoraLocalHome();
                            Collection collEstVentCons = estVentConsLH.findByConcurso(argOidConcOrig);

                            if (collEstVentCons != null) {
                                UtilidadesLog.debug("collEstVentCons != null ");

                                for (Iterator itEstVentCons = collEstVentCons.iterator(); itEstVentCons.hasNext();) {
                                    estVentConsL = (EstatusVentaConsultoraLocal) itEstVentCons.next();
                                    estVentConsLH.create(crOidConcOrig, estVentConsL.getEstatusVenta(), estVentConsL.getPeriodoDesde(),
                                                         estVentConsL.getPeriodoHasta());

                                    // all fields                                         
                                }
                            } // collEstVentCons !null
                        } catch (NoResultException fe) {
                            UtilidadesLog.debug(" FinderException Parámetros de Calificación ");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("CreateEx Parámetros de Calificación");
                        }

                        try {
                            UtilidadesLog.debug("crea Multinivel by Concurso ");

                            // crea Multinivel by Concurso
                            MultinivelLocal multinivelL = null;
                            MultinivelLocal crt_multinivelL = null;
                            MultinivelLocalHome multinivelLH = this.getMultinivelLocalHome();
                            Collection collMultinivel = multinivelLH.findByConcurso(argOidConcOrig);

                            if (collMultinivel != null) {
                                UtilidadesLog.debug("collMultinivel != null ");

                                for (Iterator itMultinivel = collMultinivel.iterator(); itMultinivel.hasNext();) {
                                    multinivelL = (MultinivelLocal) itMultinivel.next();

                                    // Modificado por ssantana, 29/6/2005
                                    crt_multinivelL = multinivelLH.create(multinivelL.getPeriodosParaCalculo(),
                                                                          multinivelL.getPeriodosSobreCalculo(),
                                                                          multinivelL.getNumeroMinimoRecomendadas(), multinivelL.getActividad(),
                                                                        //multinivelL.getPorcentajeSobreVenta(),
                                                                        crOidConcOrig, multinivelL.getPeriodoHasta(), multinivelL.getPeriodoDesde(), multinivelL.getCalculoPremio());
                                    crt_multinivelL.setPorcentajeSobreVenta(multinivelL.getPorcentajeSobreVenta());
                                    crt_multinivelL.setDiasGracia(multinivelL.getDiasGracia());
                                    crt_multinivelL.setMontoMinimoMadre(multinivelL.getMontoMinimoMadre());
                                    crt_multinivelL.setMontoMinimoPedido(multinivelL.getMontoMinimoPedido());
                                    crt_multinivelL.setMontoMinimoPedidoHijas(multinivelL.getMontoMinimoPedidoHijas());
                                    crt_multinivelL.setMontoMinimoRed(multinivelL.getMontoMinimoRed());
                                    crt_multinivelL.setPagoATiempo(multinivelL.getPagoATiempo());
                                    crt_multinivelL.setPedidosMinimosHijas(multinivelL.getPedidosMinimosHijas());
                                    crt_multinivelL.setPedidosMinimosMadre(multinivelL.getPedidosMinimosMadre());
                                    crt_multinivelL.setPedidosMinimosRed(multinivelL.getPedidosMinimosRed());
                                    crt_multinivelL.setPeriodoATiempoDesde(multinivelL.getPeriodoATiempoDesde());
                                    crt_multinivelL.setPeriodoATiempoHasta(multinivelL.getPeriodoATiempoHasta());
                                    crt_multinivelL.setPorcentajeSobreCobranza(multinivelL.getPorcentajeSobreCobranza());
                                    crt_multinivelL.setUnidadesMinimasHijas(multinivelL.getUnidadesMinimasHijas());
                                    crt_multinivelL.setUnidadesMinimasMadre(multinivelL.getUnidadesMinimasMadre());
                                    crt_multinivelL.setUnidadesMinimasPedidoHijas(multinivelL.getUnidadesMinimasPedidoHijas());
                                    crt_multinivelL.setUnidadesMinimasRed(multinivelL.getUnidadesMinimasRed());
                                    
                                    multinivelLH.merge(crt_multinivelL);

                                    // all fields 
                                }
                            } // collMultinivel !null
                        } catch (NoResultException fe) {
                            UtilidadesLog.debug(" FinderException Multinivel by Concurso ");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("CreateEx Multinivel by Concurso");
                        }

                        try {
                            UtilidadesLog.debug("crea AmbitoGeografico by Concurso ");

                            // crea AmbitoGeografico by Concurso
                            AmbitoGeograficoLocal ambitoGeogrL = null;
                            AmbitoGeograficoLocalHome ambitoGeogrLH = this.getAmbitoGeograficoLocalHome();
                            Collection collAmbitoGeogr = ambitoGeogrLH.findByConcurso(argOidConcOrig);

                            if (collAmbitoGeogr != null) {
                                UtilidadesLog.debug("collAmbitoGeogr != null ");

                                for (Iterator itAmbitoGeogr = collAmbitoGeogr.iterator(); itAmbitoGeogr.hasNext();) {
                                    ambitoGeogrL = (AmbitoGeograficoLocal) itAmbitoGeogr.next();
                                    ambitoGeogrLH.create(ambitoGeogrL.getSubgerencia(), crOidConcOrig);
                                }
                            } // collAmbitoGeogr !null
                        } catch (NoResultException fe) {
                            UtilidadesLog.debug(" FinderException AmbitoGeografico by Concurso ");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("CreateEx AmbitoGeografico by Concurso");
                        }

                        try {
                            UtilidadesLog.debug("crea Productos by UK Concurso ");

                            /*
                            * - Productos //se hace el findByConcurso sobre dicha entidad pasándole como argumento el 
                            * DTOE.oidConcursoOrigen y se hace el create donde concurso será el oid creado en la entidad 
                            * ConcursoParametrosGenerales: 
                            * productos = findByConcurso (DTOE.oidConcursoOrigen) sobre la entidad INC:Productos 
                            * Se hace un create() con: oid = secuencial 
                            * concurso = oid //el oid que se ha creado en la entidad ConcursoParametrosGenerales 
                            * Copiar el resto de atributos obtenidos en el objeto productos 
                            */
                            // crea Productos by UK Concurso
                            ProductosLocalHome productosLH = this.getProductosLocalHome();
                            ProductosLocal crt_productosL = null;
                            ProductosLocal productosL = productosLH.findByUK(argOidConcOrig);
                            //Agergado por incidencia 21467 - Cleal
                            crt_productosL = productosLH.create(crOidConcOrig);
                            crt_productosL.setComunicacionBonificados(productosL.getComunicacionBonificados());
                            crt_productosL.setComunicacionExcluidos(productosL.getComunicacionExcluidos());
                            crt_productosL.setComunicacionExigidos(productosL.getComunicacionExigidos());
                            crt_productosL.setComunicacionValidos(productosL.getComunicacionValidos());
                            crt_productosL.setMensajeBonificados(productosL.getMensajeBonificados());
                            crt_productosL.setMensajeExcluidos(productosL.getMensajeExcluidos());
                            crt_productosL.setMensajeExigidos(productosL.getMensajeExigidos());
                            crt_productosL.setMensajeValidos(productosL.getMensajeValidos());
                            productosLH.merge(crt_productosL);
                            //
                            
                            Long lnProd = null;

                            if (productosL != null) {
                                UtilidadesLog.debug("productosL != null ");
                                lnProd = crt_productosL.getOid();

                                UtilidadesLog.debug("crea Productos Validos by Producto ");

                                // crea Productos Validos by Producto
                                ProductosValidosLocal prodValL = null;
                                ProductosValidosLocal cr_prodValL = null;
                                ProductosValidosLocalHome prodValLH = this.getProductosValidosLocalHome();
                                Collection collProdVal = prodValLH.findByProducto(productosL.getOid());

                                if (collProdVal != null) {
                                    UtilidadesLog.debug("collProdVal != null ");
                                    Iterator itProdVal = collProdVal.iterator();
                                    while(itProdVal.hasNext()){
                                        UtilidadesLog.debug("*** Tiene productos Validos ");
                                        prodValL = (ProductosValidosLocal) itProdVal.next();
                                        cr_prodValL = prodValLH.create(lnProd);
                                        UtilidadesLog.debug("*** cr_prodValL: "+cr_prodValL);
                                        cr_prodValL.setCicloVida(prodValL.getCicloVida());
                                        cr_prodValL.setCodigoProducto(prodValL.getCodigoProducto());
                                        cr_prodValL.setGenerico(prodValL.getGenerico());
                                        cr_prodValL.setMarcaProducto(prodValL.getMarcaProducto());
                                        cr_prodValL.setNegocio(prodValL.getNegocio());                                        
                                        cr_prodValL.setSupergenerico(prodValL.getSupergenerico());
                                        cr_prodValL.setTipoOferta(prodValL.getTipoOferta());
                                        cr_prodValL.setUnidadNegocio(prodValL.getUnidadNegocio());
                                        prodValLH.merge(cr_prodValL);

                                        // all fields                                         
                                    }
                                } // collProdVal !null

                                UtilidadesLog.debug("crea Productos Excluidos by Producto ");

                                // crea Productos Excluidos by Producto
                                ProductosExcluidosLocal prodExclL = null;
                                ProductosExcluidosLocal cr_prodExclL = null;
                                ProductosExcluidosLocalHome prodExclLH = this.getProductosExcluidosLocalHome();
                                Collection collProdExcl = prodExclLH.findByProducto(productosL.getOid());

                                if (collProdExcl != null) {
                                    UtilidadesLog.debug("collProdExcl != null ");

                                    for (Iterator itProdExcl = collProdExcl.iterator(); itProdExcl.hasNext();) {
                                        prodExclL = (ProductosExcluidosLocal) itProdExcl.next();
                                        cr_prodExclL = prodExclLH.create(lnProd);
                                        cr_prodExclL.setCicloVida(prodExclL.getCicloVida());
                                        cr_prodExclL.setGenerico(prodExclL.getGenerico());
                                        cr_prodExclL.setMarcaProducto(prodExclL.getMarcaProducto());
                                        cr_prodExclL.setNegocio(prodExclL.getNegocio());
                                        cr_prodExclL.setPeriodoDesde(prodExclL.getPeriodoDesde());
                                        cr_prodExclL.setPeriodoHasta(prodExclL.getPeriodoHasta());
                                        cr_prodExclL.setSupergenerico(prodExclL.getSupergenerico());
                                        cr_prodExclL.setTipoOferta(prodExclL.getTipoOferta());
                                        cr_prodExclL.setUnidadNegocio(prodExclL.getUnidadNegocio());
                                        prodExclLH.merge(cr_prodExclL);

                                        // all fields                                                
                                    }
                                } // collProdExcl !null

                                UtilidadesLog.debug("crea Productos Bonificados by Producto ");

                                // crea Productos Bonificados by Producto
                                ProductosBonificadosLocal prodBonifL = null;
                                ProductosBonificadosLocal cr_prodBonifL = null;
                                ProductosBonificadosLocalHome prodBonifLH = this.getProductosBonificadosLocalHome();
                                Collection collProdBonif = prodBonifLH.findByProducto(productosL.getOid());

                                if (collProdBonif != null) {
                                    UtilidadesLog.debug("collProdBonif != null ");

                                    for (Iterator itProdBonif = collProdBonif.iterator(); itProdBonif.hasNext();) {
                                        prodBonifL = (ProductosBonificadosLocal) itProdBonif.next();
                                        cr_prodBonifL = prodBonifLH.create(prodBonifL.getPuntosUnidad(), prodBonifL.getFactorMultiplicador(),
                                                                           prodBonifL.getPeriodoDesde(), prodBonifL.getPeriodoHasta(), lnProd);
                                        cr_prodBonifL.setCicloVida(prodBonifL.getCicloVida());
                                        cr_prodBonifL.setGenerico(prodBonifL.getGenerico());
                                        cr_prodBonifL.setMarcaProducto(prodBonifL.getMarcaProducto());
                                        cr_prodBonifL.setNegocio(prodBonifL.getNegocio());
                                        cr_prodBonifL.setSupergenerico(prodBonifL.getSupergenerico());
                                        cr_prodBonifL.setTipoOferta(prodBonifL.getTipoOferta());
                                        cr_prodBonifL.setUnidadNegocio(prodBonifL.getUnidadNegocio());
                                        prodBonifLH.merge(cr_prodBonifL);

                                        // all fields                    
                                    }
                                } // collProdBonif !null

                                UtilidadesLog.debug("crea Productos Exigidos by Producto ");

                                // crea Productos Exigidos by Producto
                                ProductosExigidosLocal prodExigL = null;
                                ProductosExigidosLocal cr_prodExigL = null;
                                ProductosExigidosLocalHome prodExigLH = this.getProductosExigidosLocalHome();
                                Collection collProdExig = prodExigLH.findByProducto(productosL.getOid());

                                if (collProdExig != null) {
                                    UtilidadesLog.debug("collProdExig != null ");

                                    for (Iterator itProdExig = collProdExig.iterator(); itProdExig.hasNext();) {
                                        prodExigL = (ProductosExigidosLocal) itProdExig.next();
                                        cr_prodExigL = prodExigLH.create(prodExigL.getUnidadesExigidas(), prodExigL.getMontoExigido(),
                                                                         prodExigL.getPuntosExigidos(), prodExigL.getPeriodoHasta(),
                                                                         prodExigL.getPeriodoDesde(), lnProd);
                                        cr_prodExigL.setCicloVida(prodExigL.getCicloVida());
                                        cr_prodExigL.setGenerico(prodExigL.getGenerico());
                                        cr_prodExigL.setMarcaProducto(prodExigL.getMarcaProducto());
                                        cr_prodExigL.setNegocio(prodExigL.getNegocio());
                                        cr_prodExigL.setSupergenerico(prodExigL.getSupergenerico());
                                        cr_prodExigL.setTipoOferta(prodExigL.getTipoOferta());
                                        cr_prodExigL.setUnidadesExigidas(prodExigL.getUnidadesExigidas());
                                        cr_prodExigL.setUnidadNegocio(prodExigL.getUnidadNegocio());
                                        //Agregado por cvalenzu - BELC300024450            
                                        //30/11/2006
                                        cr_prodExigL.setProductoExigidoOriginal(prodExigL.getOid());
                                        //FIN - Agregado por cvalenzu - BELC300024450            
                                        prodExigLH.merge(cr_prodExigL);

                                        // all fields                        
                                    }
                                } // collProdExig !null
                            } // productosL !null
                        } catch (NoResultException fe) {
                            UtilidadesLog.debug(" FinderException Productos by Concurso ");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug(" CreateException Productos by Concurso ");
                        }

                        try {
                            UtilidadesLog.debug("crea Parámetros de Calificación by UK ");

                            // crea Parámetros de Calificación by UK
                            ParametrosCalificacionLocalHome paramCalificLH = this.getParametrosCalificacionLocalHome();
                            ParametrosCalificacionLocal paramCalificL = paramCalificLH.findByUK(argOidConcOrig);

                            if (paramCalificL != null) {
                                UtilidadesLog.debug("paramCalificL != null ");
                                paramCalificLH.create(paramCalificL.getDevoluciones(), paramCalificL.getAnulaciones(),
                                                      paramCalificL.getFaltantesNoAnunciados(), paramCalificL.getMetasModificables(),
                                                      paramCalificL.getMetasBloqueadas(), paramCalificL.getComunicacionCalificacion(),
                                                      paramCalificL.getPeriodoDesde(), paramCalificL.getPeriodoHasta(),
                                                      //paramCalificL.getTipoIncremento(),
                                                      paramCalificL.getTipoVentaCalificacion(), paramCalificL.getDirigidoA(), 
                                                      //paramCalificL.getTipoVentaHistorica(),
                                                      crOidConcOrig, paramCalificL.getFormaCalculo());

                                // all fields
                            } // paramCalificL !null
                        } catch (NoResultException fe) {
                            UtilidadesLog.debug(" FinderException Parámetros de Calificación");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("CreateEx Parámetros de Calificación");
                        }

                        try {
                            UtilidadesLog.debug("crea rango by Concurso ");

                            // crea rango by Concurso
                            RangoLocal rangoL = null;
                            RangoLocalHome rangoLH = this.getRangoLocalHome();
                            Collection collRango = rangoLH.findByConcurso(argOidConcOrig);

                            if (collRango != null) {
                                UtilidadesLog.debug("collRango != null ");

                                for (Iterator itRango = collRango.iterator(); itRango.hasNext();) {
                                    rangoL = (RangoLocal) itRango.next();
                                    rangoLH.create(rangoL.getDesde(), rangoL.getHasta(), rangoL.getIncremento(), crOidConcOrig);

                                    // all fields
                                }
                            } // collRango !null
                        } catch (NoResultException fe) {
                            UtilidadesLog.debug(" FinderException Rango ");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("CreateEx Rango");
                        }

                        try {
                            UtilidadesLog.debug("create en 2 ciclos ");

                            // create en 2 ciclos anidados
                            ClasificacionParticipantesCalificacionLocal clasifPartCalifL = null;
                            Long crOidClasifPartCalif = null;
                            Long lnParticipante = null;
                            ClasificacionParticipantesCalificacionLocalHome clasifPartCalifLH = this.getClasificacionParticipantesCalificacionLocalHome();
                            Collection collClasifPartCalif = clasifPartCalifLH.findByConcurso(argOidConcOrig);

                            MontoMinimoRangoGerentesLocal montoMinRangGerL = null;
                            MontoMinimoRangoGerentesLocalHome montoMinRangGerLH = this.getMontoMinimoRangoGerentesLocalHome();

                            MontoMinimoRangoConsultorasLocal montoMinRangConsL = null;
                            MontoMinimoRangoConsultorasLocalHome montoMinRangConsLH = this.getMontoMinimoRangoConsultorasLocalHome();

                            Collection collMontoMinRangGer = null;
                            Collection collMontoMinRangCons = null;

                            if (collClasifPartCalif != null) {
                                UtilidadesLog.debug("collClasifPartCalif != null ");

                                for (Iterator itClasifPartCalif = collClasifPartCalif.iterator(); itClasifPartCalif.hasNext();) {
                                    UtilidadesLog.debug("crea Clasificacion Participantes Calificacion by Concurso");

                                    // crea Clasificacion Participantes Calificacion by Concurso
                                    lnParticipante = ((ClasificacionParticipantesCalificacionLocal) itClasifPartCalif.next()).getParticipante();
                                    clasifPartCalifL = clasifPartCalifLH.create(crOidConcOrig, lnParticipante);

                                    // all fields
                                    crOidClasifPartCalif = clasifPartCalifL.getOid();
                                    collMontoMinRangGer = montoMinRangGerLH.findByParticipanteCalificacion(lnParticipante);

                                    if (collMontoMinRangGer != null) {
                                        UtilidadesLog.debug("collMontoMinRangGer != null ");

                                        for (Iterator itMontoMinRangGer = collMontoMinRangGer.iterator(); itMontoMinRangGer.hasNext();) {
                                            montoMinRangGerL = (MontoMinimoRangoGerentesLocal) itMontoMinRangGer.next();
                                            UtilidadesLog.debug("crea Monto Mínimo Rango Gerentes");

                                            // crea Monto Mínimo Rango Gerentes 
                                            // by ParticipanteCalificacion
                                            montoMinRangGerLH.create(montoMinRangGerL.getMontoMinimo(), crOidClasifPartCalif);

                                            // all fields
                                        }
                                    } // collMontoMinRangGer !null

                                    collMontoMinRangCons = montoMinRangConsLH.findByParticipanteCalificacion(lnParticipante);

                                    if (collMontoMinRangCons != null) {
                                        UtilidadesLog.debug("collMontoMinRangCons != null ");

                                        for (Iterator itMontoMinRangCons = collMontoMinRangCons.iterator(); itMontoMinRangCons.hasNext();) {
                                            montoMinRangConsL = (MontoMinimoRangoConsultorasLocal) itMontoMinRangCons.next();
                                            UtilidadesLog.debug("crea Monto Mínimo Rango Consultoras ");

                                            // crea Monto Mínimo Rango Consultoras 
                                            // by ParticipanteCalificacion
                                            montoMinRangConsLH.create(montoMinRangConsL.getMontoMinimo(), montoMinRangConsL.getEstatusVenta(),
                                                                      crOidClasifPartCalif);

                                            // all fields
                                        }
                                    } // collMontoMinRangCons !null
                                } // fi create en 2 ciclos anidados 
                            } // fi collClasifPartCalif !null
                        } catch (NoResultException fe) {
                            UtilidadesLog.debug(" FinderException ClasificacionParticipantesCalificacion ");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug(" CreateEx ClasificacionParticipantesCalificacion");
                        }

                        try {
                            UtilidadesLog.debug("crea Productos Calificar by Concurso ");

                            // crea Productos Calificar by Concurso
                            ProductosCalificarLocal cr_prodCalifL = null;
                            ProductosCalificarLocal prodCalifL = null;
                            ProductosCalificarLocalHome prodCalifLH = this.getProductosCalificarLocalHome();
                            Collection collProdCalif = prodCalifLH.findByConcurso(argOidConcOrig);

                            if (collProdCalif != null) {
                                UtilidadesLog.debug("collProdCalif  != null");

                                for (Iterator itProdCalif = collProdCalif.iterator(); itProdCalif.hasNext();) {
                                    prodCalifL = (ProductosCalificarLocal) itProdCalif.next();
                                    cr_prodCalifL = prodCalifLH.create(crOidConcOrig, prodCalifL.getMarcaProducto());
                                    cr_prodCalifL.setCicloVida(prodCalifL.getCicloVida());
                                    cr_prodCalifL.setCodigoProducto(prodCalifL.getCodigoProducto());
                                    cr_prodCalifL.setGenerico(prodCalifL.getGenerico());
                                    cr_prodCalifL.setNegocio(prodCalifL.getNegocio());
                                    cr_prodCalifL.setSupergenerico(prodCalifL.getSupergenerico());
                                    cr_prodCalifL.setTipoOferta(prodCalifL.getTipoOferta());
                                    cr_prodCalifL.setUnidadNegocio(prodCalifL.getUnidadNegocio());
                                    prodCalifLH.merge(cr_prodCalifL);
                                    // all fields
                                }
                            } // collProdCalif  !null
                        } catch (NoResultException fe) {
                            UtilidadesLog.debug(" FinderException Productos Calificar ");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("CreateEx Productos Calificar");
                        }

                        try {
                            UtilidadesLog.debug("crea ProductosExcluidosCalificación by Concurso");

                            // crea Productos Excluidos Calificación by Concurso 
                            ProductosExcluidosCalificacionLocal prodExclCalifL = null;
                            ProductosExcluidosCalificacionLocal cr_prodExclCalifL = null;
                            ProductosExcluidosCalificacionLocalHome prodExclCalifLH = this.getProductosExcluidosCalificacionLocalHome();
                            Collection collProdExclCalif = prodExclCalifLH.findByConcurso(argOidConcOrig);

                            if (collProdExclCalif != null) {
                                UtilidadesLog.debug("collProdExclCalif != null ");

                                for (Iterator itProdExclCalif = collProdExclCalif.iterator(); itProdExclCalif.hasNext();) {
                                    prodExclCalifL = (ProductosExcluidosCalificacionLocal) itProdExclCalif.next();
                                    cr_prodExclCalifL = prodExclCalifLH.create(crOidConcOrig, prodExclCalifL.getMarcaProducto(),
                                                                               prodExclCalifL.getPeriodoDesde(), prodExclCalifL.getPeriodoHasta());
                                    cr_prodExclCalifL.setCicloVida(prodExclCalifL.getCicloVida());
                                    cr_prodExclCalifL.setCodigoProducto(prodExclCalifL.getCodigoProducto());
                                    cr_prodExclCalifL.setGenerico(prodExclCalifL.getGenerico());
                                    cr_prodExclCalifL.setNegocio(prodExclCalifL.getNegocio());
                                    cr_prodExclCalifL.setSupergenerico(prodExclCalifL.getSupergenerico());
                                    cr_prodExclCalifL.setTipoOferta(prodExclCalifL.getTipoOferta());
                                    cr_prodExclCalifL.setUnidadNegocio(prodExclCalifL.getUnidadNegocio());
                                    prodExclCalifLH.merge(cr_prodExclCalifL);

                                    // all fields
                                }
                            } // collProdExclCalif !null
                        } catch (NoResultException fe) {
                            UtilidadesLog.debug("FinderEx Productos Excluidos Calificación");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("CreateEx Productos Excluidos Calificación");
                        }

                        try {
                            UtilidadesLog.debug("crea Concurso Variables de Venta Proyectada ");

                            // crea Concurso Variables de Venta Proyectada by Concurso         
                            ConcursoVariablesVentaProyectadaLocal concVarVentProyL = null;
                            ConcursoVariablesVentaProyectadaLocalHome concVarVentProyLH = this.getConcursoVariablesVentaProyectadaLocalHome();
                            Collection collConcVarVentProy = concVarVentProyLH.findByConcurso(argOidConcOrig);

                            if (collConcVarVentProy != null) {
                                UtilidadesLog.debug("collConcVarVentProy != null ");

                                for (Iterator itConcVarVentProy = collConcVarVentProy.iterator(); itConcVarVentProy.hasNext();) {
                                    concVarVentProyL = (ConcursoVariablesVentaProyectadaLocal) itConcVarVentProy.next();
                                    concVarVentProyLH.create(concVarVentProyL.getActivas(), concVarVentProyL.getIngreso(),
                                                             concVarVentProyL.getReingreso(), concVarVentProyL.getEgresos(),
                                                             concVarVentProyL.getEntregadas(), concVarVentProyL.getRecibidas(),
                                                             concVarVentProyL.getCapitalizacion(), concVarVentProyL.getActivasFinales(),
                                                             concVarVentProyL.getActividad(), concVarVentProyL.getNumeroPedidos(),
                                                             concVarVentProyL.getPrecioPromedioUnitario(), concVarVentProyL.getPromedioVentaPedido(),
                                                             concVarVentProyL.getPromedioOrdenesPedido(),
                                                             concVarVentProyL.getPromedioUnidadesPedido(), concVarVentProyL.getRetencion(),
                                                             concVarVentProyL.getVentaEstadisticable(), crOidConcOrig);

                                    // all fields
                                }
                            } // collConcVarVentProy !null
                        } catch (NoResultException fe) {
                            UtilidadesLog.debug("FinderEx ConcursoVariables de VentaProyectada");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("CreateEx ConcursoVariables de VentaProyectada");
                        }

                        try {
                            UtilidadesLog.debug("crea Metas Venta Proyectada Zona ");

                            // crea Metas Venta Proyectada Zona by Concurso
                            MetasVentaProyectadaZonaLocal metVentProyZonL = null;
                            MetasVentaProyectadaZonaLocal cr_metVentProyZonL = null;
                            UtilidadesLog.debug(" **************************** ");

                            MetasVentaProyectadaZonaLocalHome metVentProyZonLH = this.getMetasVentaProyectadaZonaLocalHome();

                            UtilidadesLog.debug(" **************************** ");
                            UtilidadesLog.debug("metVentProyZonLH " + metVentProyZonLH);

                            Collection collMetVentProyZon = metVentProyZonLH.findByConcurso(argOidConcOrig);

                            UtilidadesLog.debug("collMetVentProyZon " + collMetVentProyZon);

                            if (collMetVentProyZon != null) {
                                UtilidadesLog.debug("collMetVentProyZon != null ");

                                for (Iterator itMetVentProyZon = collMetVentProyZon.iterator(); itMetVentProyZon.hasNext();) {
                                    metVentProyZonL = (MetasVentaProyectadaZonaLocal) itMetVentProyZon.next();
                                    cr_metVentProyZonL = metVentProyZonLH.create(metVentProyZonL.getActivasIniciales(),
                                                                                 metVentProyZonL.getActivasFinales(), metVentProyZonL.getIngresos(),
                                                                                 metVentProyZonL.getReingresos(), metVentProyZonL.getEgresos(),
                                                                                 metVentProyZonL.getNumeroOrdenes(),
                                                                                 metVentProyZonL.getNumeroPedidos(),
                                                                                 metVentProyZonL.getUnidadesVendidas(),
                                                                                 metVentProyZonL.getNumeroClientes(),
                                                                                 metVentProyZonL.getVentaNetaEstadisticable(),
                                                                                 metVentProyZonL.getZona(), metVentProyZonL.getCliente(),
                                                                                 crOidConcOrig, metVentProyZonL.getPeriodoCalculado());
                                    cr_metVentProyZonL.setActividad(metVentProyZonL.getActividad());
                                    cr_metVentProyZonL.setCapitalizacion(metVentProyZonL.getCapitalizacion());
                                    cr_metVentProyZonL.setNumeroEntregadas(metVentProyZonL.getNumeroEntregadas());
                                    cr_metVentProyZonL.setNumeroRecibidas(metVentProyZonL.getNumeroRecibidas());
                                    cr_metVentProyZonL.setPrecioPromedioUnitario(metVentProyZonL.getPrecioPromedioUnitario());
                                    cr_metVentProyZonL.setPromedioOrdenesPedido(metVentProyZonL.getPromedioOrdenesPedido());
                                    cr_metVentProyZonL.setPromedioUnidadesPedido(metVentProyZonL.getPromedioUnidadesPedido());
                                    cr_metVentProyZonL.setPromedioVentaPedido(metVentProyZonL.getPromedioVentaPedido());
                                    cr_metVentProyZonL.setRetencion(metVentProyZonL.getRetencion());
                                    metVentProyZonLH.merge(cr_metVentProyZonL);
                                }
                            } // metVentProyZonL !null */
                        } catch (NoResultException fe) {
                            UtilidadesLog.debug(" FinderEx Metas Venta Proyectada Zona ");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("CreateEx Metas Venta Proyectada Zona");
                        }

                        try {
                            UtilidadesLog.debug("crea Metas Venta Proyectada Región by Concurso");

                            // crea Metas Venta Proyectada Región by Concurso
                            MetasVentaProyectadaRegionLocal metVentProyRegiL = null;
                            MetasVentaProyectadaRegionLocal cr_metVentProyRegiL = null;
                            MetasVentaProyectadaRegionLocalHome metVentProyRegiLH = this.getMetasVentaProyectadaRegionLocalHome();
                            Collection collMetVentProyRegi = metVentProyRegiLH.findByConcurso(argOidConcOrig);

                            if (collMetVentProyRegi != null) {
                                UtilidadesLog.debug("collMetVentProyRegi != null ");

                                for (Iterator itMetVentProySubgerVent = collMetVentProyRegi.iterator(); itMetVentProySubgerVent.hasNext();) {
                                    cr_metVentProyRegiL = metVentProyRegiLH.create(metVentProyRegiL.getAnioComercial(),
                                                                                   metVentProyRegiL.getActivasIniciales(),
                                                                                   metVentProyRegiL.getActivasFinales(),
                                                                                   metVentProyRegiL.getIngresos(), metVentProyRegiL.getReingresos(),
                                                                                   metVentProyRegiL.getEgresos(),
                                                                                   metVentProyRegiL.getNumeroOrdenes(),
                                                                                   metVentProyRegiL.getNumeroPedidos(),
                                                                                   metVentProyRegiL.getUnidadesVendidas(),
                                                                                   metVentProyRegiL.getNumeroClientes(),
                                                                                   metVentProyRegiL.getVentaNetaEstadisticable(),
                                                                                   metVentProyRegiL.getRegion(), metVentProyRegiL.getCliente(),
                                                                                   crOidConcOrig, metVentProyRegiL.getPeriodoCalculado());
                                    cr_metVentProyRegiL.setActividad(metVentProyRegiL.getActividad());
                                    cr_metVentProyRegiL.setCapitalizacion(metVentProyRegiL.getCapitalizacion());
                                    cr_metVentProyRegiL.setNumeroEntregadas(metVentProyRegiL.getNumeroEntregadas());
                                    cr_metVentProyRegiL.setNumeroRecibidas(metVentProyRegiL.getNumeroRecibidas());
                                    cr_metVentProyRegiL.setPrecioPromedioUnitario(metVentProyRegiL.getPrecioPromedioUnitario());
                                    cr_metVentProyRegiL.setPromedioOrdenesPedido(metVentProyRegiL.getPromedioOrdenesPedido());
                                    cr_metVentProyRegiL.setPromedioUnidadesPedido(metVentProyRegiL.getPromedioUnidadesPedido());
                                    cr_metVentProyRegiL.setPromedioVentaPedido(metVentProyRegiL.getPromedioVentaPedido());
                                    cr_metVentProyRegiL.setRetencion(metVentProyRegiL.getRetencion());
                                    metVentProyRegiLH.merge(cr_metVentProyRegiL);

                                    // all fields 
                                }
                            } // collMetVentProyRegi !null
                        } catch (NoResultException fe) {
                            UtilidadesLog.debug("FinderEx Metas Venta Proyectada Región by Concurso");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("CreateEx Metas Venta Proyectada Región by Concurso");
                        }

                        try {
                            UtilidadesLog.debug("crea Metas Venta Proyectada Subgerencia de Venta by Concurso");

                            // crea Metas Venta Proyectada Subgerencia de Venta by Concurso
                            MetasVentaProyectadaSubgerenciaVentaLocal metVentProySubgerVentL = null;
                            MetasVentaProyectadaSubgerenciaVentaLocal cr_metVentProySubgerVentL = null;
                            MetasVentaProyectadaSubgerenciaVentaLocalHome metVentProySubgerVentLH = this.getMetasVentaProyectadaSubgerenciaVentaLocalHome();
                            Collection collMetVentProySubgerVent = metVentProySubgerVentLH.findByConcurso(argOidConcOrig);

                            if (collMetVentProySubgerVent != null) {
                                UtilidadesLog.debug("collMetVentProySubgerVent != null ");

                                for (Iterator itMetVentProySubgerVent = collMetVentProySubgerVent.iterator(); itMetVentProySubgerVent.hasNext();) {
                                    metVentProySubgerVentL = (MetasVentaProyectadaSubgerenciaVentaLocal) itMetVentProySubgerVent.next();
                                    cr_metVentProySubgerVentL = metVentProySubgerVentLH.create(metVentProySubgerVentL.getAnioComercial(),
                                                                                               metVentProySubgerVentL.getActivasIniciales(),
                                                                                               metVentProySubgerVentL.getActivasFinales(),
                                                                                               metVentProySubgerVentL.getIngresos(),
                                                                                               metVentProySubgerVentL.getReingresos(),
                                                                                               metVentProySubgerVentL.getEgresos(),
                                                                                               metVentProySubgerVentL.getNumeroOrdenes(),
                                                                                               metVentProySubgerVentL.getNumeroPedidos(),
                                                                                               metVentProySubgerVentL.getUnidadesVendidas(),
                                                                                               metVentProySubgerVentL.getNumeroClientes(),
                                                                                               metVentProySubgerVentL.getVentaNetaEstadisticable(),
                                                                                               metVentProySubgerVentL.getCliente(),
                                                                                               metVentProySubgerVentL.getSubgerencia(),
                                                                                               crOidConcOrig,
                                                                                               metVentProySubgerVentL.getPeriodoCalculado());
                                    cr_metVentProySubgerVentL.setActividad(metVentProySubgerVentL.getActividad());
                                    cr_metVentProySubgerVentL.setCapitalizacion(metVentProySubgerVentL.getCapitalizacion());
                                    cr_metVentProySubgerVentL.setNumeroEntregadas(metVentProySubgerVentL.getNumeroEntregadas());
                                    cr_metVentProySubgerVentL.setNumeroRecibidas(metVentProySubgerVentL.getNumeroRecibidas());
                                    cr_metVentProySubgerVentL.setPrecioPromedioUnitario(metVentProySubgerVentL.getPrecioPromedioUnitario());
                                    cr_metVentProySubgerVentL.setPromedioOrdenesPedido(metVentProySubgerVentL.getPromedioOrdenesPedido());
                                    cr_metVentProySubgerVentL.setPromedioUnidadesPedido(metVentProySubgerVentL.getPromedioUnidadesPedido());
                                    cr_metVentProySubgerVentL.setPromedioVentaPedido(metVentProySubgerVentL.getPromedioVentaPedido());
                                    cr_metVentProySubgerVentL.setRetencion(metVentProySubgerVentL.getRetencion());
                                    metVentProySubgerVentLH.merge(cr_metVentProySubgerVentL);

                                    // all fields
                                }
                            } // collMetVentProySubgerVent !null
                        } catch (NoResultException fe) {
                            UtilidadesLog.debug("FinderEx MetasVentaProyectadaSubgerencia de Venta by Concurso");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("CreateEx MetasVentaProyectadaSubgerencia de Venta by Concurso");
                        }

                        try {
                            UtilidadesLog.debug("crea Metas Tipo Venta by Concurso ");

                            // crea Metas Tipo Venta by Concurso 
                            MetasTipoVentaLocal metTipoVentL = null;
                            MetasTipoVentaLocal cr_metTipoVentL = null;
                            MetasTipoVentaLocalHome metTipoVentLH = this.getMetasTipoVentaLocalHome();
                            Collection collMetTipoVent = metTipoVentLH.findByConcurso(argOidConcOrig);

                            if (collMetTipoVent != null) {
                                for (Iterator itMetTipoVent = collMetTipoVent.iterator(); itMetTipoVent.hasNext();) {
                                    UtilidadesLog.debug("collMetTipoVent != null ");
                                    metTipoVentL = (MetasTipoVentaLocal) itMetTipoVent.next();
                                    cr_metTipoVentL = metTipoVentLH.create(metTipoVentL.getMeta(), metTipoVentL.getCliente(), crOidConcOrig);
                                    cr_metTipoVentL.setIncremento(metTipoVentL.getIncremento());
                                    cr_metTipoVentL.setMontoVenta(metTipoVentL.getMontoVenta());
                                    cr_metTipoVentL.setUnidadesVendidas(metTipoVentL.getUnidadesVendidas());
                                    metTipoVentLH.merge(cr_metTipoVentL);

                                    // all fields
                                }
                            } // collMetTipoVent !null
                        } catch (NoResultException fe) {
                            UtilidadesLog.debug("FinderException Metas Tipo Venta by Concurso");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("CreateEx Metas Tipo Venta by Concurso");
                        }
                        
                        //Agregado por incidencia BELC300024406
                        //cvalenzu - 31/10/2006                        
                        try {
                            UtilidadesLog.debug("crea Programa Nuevas by Concurso");
                            ProgramaNuevasLocal pnl = null;
                            ProgramaNuevasLocalHome pnlh = this.getProgramaNuevasLocalHome();
                            
                            ProgramaNuevasLocal pnl2 = pnlh.findByConcurso(argOidConcOrig);                            

                            if (pnl2 != null) {
                                UtilidadesLog.debug("pnl2 != null");
                                
                                pnl = pnlh.create(pnl2.getNumeroPedidosEvaluar(),crOidConcOrig, pnl2.getTipoRequisito(), pnl2.getNumeroPedidosAPremiar());                                           
                            } 
                        } catch (NoResultException fe) {
                            UtilidadesLog.debug("FinderEx Programa nuevas by Concurso");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("CreateEx Programa nuevas");
                        }                        
                        //Fin - Agregado por incidencia BELC300024406

                        try {
                            UtilidadesLog.debug("crea Obtención de Puntos by UK concurso");

                            // crea Obtención de Puntos by UK concurso
                            ObtencionPuntosLocal cr_obtenPuntL = null;
                            ObtencionPuntosLocalHome obtenPuntLH = this.getObtencionPuntosLocalHome();
                            ObtencionPuntosLocal obtenPuntL = obtenPuntLH.findByUK(argOidConcOrig);

                            if (obtenPuntL != null) {
                                UtilidadesLog.debug("obtenPuntL != null");
                                cr_obtenPuntL = obtenPuntLH.create(obtenPuntL.getFactorConversion(), obtenPuntL.getNumPuntosAsignados(),
                                                                   obtenPuntL.getIndComuObte(), crOidConcOrig);
                                cr_obtenPuntL.setIndActi(obtenPuntL.getIndActi());
                                cr_obtenPuntL.setIndConsolidado(obtenPuntL.getIndConsolidado());
                                cr_obtenPuntL.setMensaje(obtenPuntL.getMensaje());
                                cr_obtenPuntL.setPuntoAcumulado(obtenPuntL.getPuntoAcumulado());
                                
                                // sapaza -- ECU-SiCC-2012-0213 -- 13/02/2013
                                cr_obtenPuntL.setNumPeriodosSinPedido(obtenPuntL.getNumPeriodosSinPedido());
                                
                                obtenPuntLH.merge(cr_obtenPuntL);

                                // all fields                                    
                            } // obtenPuntL !null
                        } catch (NoResultException fe) {
                            UtilidadesLog.debug("FinderEx Obtención de Puntos by UK concurso ");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("CreateEx Obtención de Puntos ");
                        }

                        Long lnParamGenerPrem = null;
                        Long lnParamGenerPremOrig = null;

                        try {
                            UtilidadesLog.debug("crea ParámetrosGeneralesPremiación by Concurso");

                            // crea Parámetros Generales Premiación by Concurso 
                            ParametrosGeneralesPremiacionLocal cr_paramGenPremL = null;
                            ParametrosGeneralesPremiacionLocalHome paramGenPremLH = this.getParametrosGeneralesPremiacionLocalHome();
                            ParametrosGeneralesPremiacionLocal paramGenPremL = paramGenPremLH.findByUK(argOidConcOrig);
                            cr_paramGenPremL = paramGenPremLH.create(paramGenPremL.getNumeroNiveles(), paramGenPremL.getComunicacion(), crOidConcOrig);

                            cr_paramGenPremL.setAccesoNivelSuperior(paramGenPremL.getAccesoNivelSuperior());
                            cr_paramGenPremL.setTipoPremiacion(paramGenPremL.getTipoPremiacion());
                            cr_paramGenPremL.setHastaNivel(paramGenPremL.getHastaNivel());
                            cr_paramGenPremL.setMensaje(paramGenPremL.getMensaje());
                            cr_paramGenPremL.setNivelElegible(paramGenPremL.getNivelElegible());
                            cr_paramGenPremL.setNivelesRotativos(paramGenPremL.getNivelesRotativos());
                            cr_paramGenPremL.setNumeroPeriodos(paramGenPremL.getNumeroPeriodos());
                            cr_paramGenPremL.setNumeroRotaciones(paramGenPremL.getNumeroRotaciones());
                            cr_paramGenPremL.setPeriodoDespacho(paramGenPremL.getPeriodoDespacho());
                            
                            // sapaza -- PER-SiCC-2010-0210 -- 23/04/2010
                            cr_paramGenPremL.setPeriodoDespachoInicio(paramGenPremL.getPeriodoDespachoInicio());
                            
                            cr_paramGenPremL.setPeriodoDespachoExigido(paramGenPremL.getPeriodoDespachoExigido());
                            cr_paramGenPremL.setPremiosAcumulativosNiveles(paramGenPremL.getPremiosAcumulativosNiveles());
                            cr_paramGenPremL.setPremiosElectivos(paramGenPremL.getPremiosElectivos());
                            cr_paramGenPremL.setTipoEleccion(paramGenPremL.getTipoEleccion());                            
                            
                            // sapaza -- PER-SiCC-2011-0857 -- 23/01/2012
                            cr_paramGenPremL.setSinPremioPorDefecto(paramGenPremL.getSinPremioPorDefecto());
                            
                            paramGenPremLH.merge(cr_paramGenPremL);
                            
                            // all fields
                            lnParamGenerPremOrig = paramGenPremL.getOid();
                            lnParamGenerPrem = cr_paramGenPremL.getOid();
                        } catch (NoResultException fe) {
                            UtilidadesLog.debug("FinderEx Parámetros Generales Premiación by Concurso");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("CreateEx Parámetros Generales Premiación");
                        }

                        /* ParametrosNivelPremiacion
                         * PremioMonetario
                         * PagoMonetario
                         * PremioArticulo
                         * LotePremioArticulos
                         * ArticulosLote
                         * PremioPuntos
                         * PremioDescuento
                         * ProductoDescuento */
                        try {
                            ParametrosNivelPremiacionLocal cr_paramNivelPremL = null;
                            ParametrosNivelPremiacionLocal paramNivelPremL = null;
                            ParametrosNivelPremiacionLocalHome paramNivelPremLH = this.getParametrosNivelPremiacionLocalHome();

                            // crea find by ParametroGeneralPremiacion
                            //Collection collParamNivelPrem = paramNivelPremLH.findByParametroGeneralPremiacion(lnParamGenerPrem);
                            Collection collParamNivelPrem = paramNivelPremLH.findByParametroGeneralPremiacion(lnParamGenerPremOrig);

                            PremioMonetarioLocal premMonetL = null;
                            PremioMonetarioLocal cr_premMonetL = null;
                            PremioMonetarioLocalHome premMonetLH = this.getPremioMonetarioLocalHome();

                            PagoMonetariosLocal pagoMonetL = null;
                            PagoMonetariosLocalHome pagoMonetLH = this.getPagoMonetariosLocalHome();

                            PremioArticuloLocal premArticL = null;
                            PremioArticuloLocal cr_premArticL = null;
                            PremioArticuloLocalHome premArticLH = this.getPremioArticuloLocalHome();

                            LotePremioArticulosLocal lotePremArticL = null;
                            LotePremioArticulosLocal cr_lotePremArticL = null;
                            LotePremioArticulosLocalHome lotePremArticLH = this.getLotePremioArticulosLocalHome();

                            ArticulosLoteLocal articLoteL = null;
                            ArticulosLoteLocal cr_articLoteL = null;
                            ArticulosLoteLocalHome articLoteLH = this.getArticulosLoteLocalHome();

                            PremioPuntosLocal premPuntL = null;
                            PremioPuntosLocal cr_premPuntL = null;
                            PremioPuntosLocalHome premPuntLH = this.getPremioPuntosLocalHome();

                            PremioDescuentoLocal premDescuentoL = null;
                            PremioDescuentoLocal cr_premDescuentoL = null;
                            PremioDescuentoLocalHome premDescuentoLH = this.getPremioDescuentoLocalHome();

                            ProductoDescuentoLocal prodDescuentoL = null;
                            ProductoDescuentoLocal cr_prodDescuentoL = null;
                            ProductoDescuentoLocalHome prodDescuentoLH = this.getProductoDescuentoLocalHome();

                            Long lnParamNivelPrem = null;
                            Long lnParamNivelPremOrig = null;
                            Long lnPremMonet = null;
                            Long lnPremMonetOrig = null;
                            Long lnPremArtic = null;
                            Long lnPremArticOrig = null;
                            Long lnLotePremArtic = null;
                            Long lnLotePremArticOrig = null;
                            Long lnPremDescuento = null;
                            Long lnPremDescuentoOrig = null;

                            Collection collPremMonet = null;
                            Collection collPagoMonet = null;
                            Collection collPremArtic = null;
                            Collection collLotePremArtic = null;
                            Collection collArticLote = null;
                            Collection collPremPunt = null;
                            Collection collPremDescuento = null;
                            Collection collProdDescuento = null;

                            if ((collParamNivelPrem != null) && (lnParamGenerPrem != null)) {
                                UtilidadesLog.debug("collParamNivelPrem != null ");

                                for (Iterator itParamNivelPrem = collParamNivelPrem.iterator(); itParamNivelPrem.hasNext();) {
                                    paramNivelPremL = (ParametrosNivelPremiacionLocal) itParamNivelPrem.next();
                                    UtilidadesLog.debug("crea ParámetrosNivelPremiación by ParametroGeneralPremiacion");

                                    //crea ParámetrosNivelPremiación by ParametroGeneralPremiacion
                                    cr_paramNivelPremL = paramNivelPremLH.create(paramNivelPremL.getNumeroNivel(), lnParamGenerPrem,
                                                                                 paramNivelPremL.getTipoPremio(),
                                                                                 paramNivelPremL.getFechaUltimaActualizacion());
                                    UtilidadesLog.debug("Nivel: "+paramNivelPremL.getNumeroNivel()+" OidParametrosGenerales: "+ lnParamGenerPrem+" Tipo premio: "+
                                                                                 paramNivelPremL.getTipoPremio()+" Fecha ultima actualizacion: "+
                                                                                 paramNivelPremL.getFechaUltimaActualizacion());                                                                                
                                    cr_paramNivelPremL.setCantidadFijaPuntos(paramNivelPremL.getCantidadFijaPuntos());
                                    cr_paramNivelPremL.setCantidadFinalPuntos(paramNivelPremL.getCantidadFinalPuntos());
                                    cr_paramNivelPremL.setCantidadInicialPuntos(paramNivelPremL.getCantidadInicialPuntos());
                                    cr_paramNivelPremL.setNivelSelectivo(paramNivelPremL.getNivelSelectivo());
                                    cr_paramNivelPremL.setNumeroAspirantes(paramNivelPremL.getNumeroAspirantes());
                                    //Cleal - 21468
                                    //cr_paramNivelPremL.setPremiacion(paramNivelPremL.getPremiacion());
                                    cr_paramNivelPremL.setPuntajeServicio(paramNivelPremL.getPuntajeServicio());
                                    cr_paramNivelPremL.setPuntosProductosExigidos(paramNivelPremL.getPuntosProductosExigidos());
                                    // vbongiov -- Cambio 20090930 -- 16/07/2009
                                    cr_paramNivelPremL.setDescripcionNivel(paramNivelPremL.getDescripcionNivel());
                                    
                                    paramNivelPremLH.merge(cr_paramNivelPremL);
                                    

                                    // all fields
                                    lnParamNivelPremOrig = paramNivelPremL.getOid();
                                    lnParamNivelPrem = cr_paramNivelPremL.getOid();

                                    try {
                                        //Cleal - 21468
                                        //collPremMonet = premMonetLH.findByParametroNivelPremiacion(lnParamNivelPrem);
                                        collPremMonet = premMonetLH.findByParametroNivelPremiacion(lnParamNivelPremOrig);

                                        if (collPremMonet != null) {
                                            UtilidadesLog.debug("collPremMonet != null ");

                                            for (Iterator itPremMonet = collPremMonet.iterator(); itPremMonet.hasNext();) {
                                                premMonetL = (PremioMonetarioLocal) itPremMonet.next();
                                                UtilidadesLog.debug("crea PremioMonetario by ParametroNivelPremiacion");

                                                // crea Premio Monetario by ParametroNivelPremiacion
                                                cr_premMonetL = premMonetLH.create(premMonetL.getNumeroPremio(), premMonetL.getMoneda(),
                                                                                   lnParamNivelPrem, premMonetL.getTipoPremioMonetario(),
                                                                                   premMonetL.getFormaPago());
                                                cr_premMonetL.setCantidad(premMonetL.getCantidad());
                                                cr_premMonetL.setDescontarPagosAnticipados(premMonetL.getDescontarPagosAnticipados());
                                                //Cleal - 21468
                                                //cr_premMonetL.setNivelPremiacion(premMonetL.getNivelPremiacion());
                                                cr_premMonetL.setPagoPartes(premMonetL.getPagoPartes());
                                                cr_premMonetL.setCumplimiento(premMonetL.getCumplimiento());
                                                cr_premMonetL.setPorcentaje(premMonetL.getPorcentaje());
                                                premMonetLH.merge(cr_premMonetL);

                                                // all fields
                                                lnPremMonetOrig = premMonetL.getOid();
                                                lnPremMonet = cr_premMonetL.getOid();

                                                try {
                                                    //Cleal - 21468
                                                    //collPagoMonet = pagoMonetLH.findByPremioMonetario(lnPremMonet);
                                                    collPagoMonet = pagoMonetLH.findByPremioMonetario(lnPremMonetOrig);

                                                    if (collPagoMonet != null) {
                                                        UtilidadesLog.debug("collPagoMonet != null ");

                                                        for (Iterator itPagoMonet = collPagoMonet.iterator(); itPagoMonet.hasNext();) {
                                                            pagoMonetL = (PagoMonetariosLocal) itPagoMonet.next();
                                                            UtilidadesLog.debug("crea  Pago Monetario by PremioMonetario");

                                                            // crea  Pago Monetario by PremioMonetario                                 
                                                            pagoMonetLH.create(pagoMonetL.getNumeroPago(), pagoMonetL.getPorcentajePremio(),
                                                                               pagoMonetL.getPeriodo(), lnPremMonet);

                                                            // all fields                                     
                                                        }
                                                    } // collPagoMonet !null
                                                } catch (NoResultException fe) {
                                                    UtilidadesLog.debug("FinderEx PremioMonetario");
                                                } catch (PersistenceException ce) {
                                                    UtilidadesLog.error("ERROR ", ce);
                                                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                                                }
                                            }
                                        } // collPremMonet !null
                                    } catch (NoResultException fe) {
                                        UtilidadesLog.debug("FinderEx Premio Monetario");
                                    } catch (PersistenceException ce) {
                                        UtilidadesLog.error("ERROR ", ce);
                                        throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                                    }

                                    try {
                                        //Cleal - 21468
                                        //collPremArtic = premArticLH.findByParametroNivelPremiacion(lnParamNivelPrem);
                                        collPremArtic = premArticLH.findByParametroNivelPremiacion(lnParamNivelPremOrig);

                                        if (collPremArtic != null) {
                                            UtilidadesLog.debug("collPremArtic != null ");

                                            for (Iterator itPremArtic = collPremArtic.iterator(); itPremArtic.hasNext();) {
                                                premArticL = (PremioArticuloLocal) itPremArtic.next();
                                                UtilidadesLog.debug("crea PremioArtículo by ParametroNivelPremiacion");

                                                //crea PremioArtículo by ParametroNivelPremiacion
                                                cr_premArticL = premArticLH.create(premArticL.getNumeroUnidades(), lnParamNivelPrem);

                                                // all fields                                    
                                                lnPremArticOrig = premArticL.getOid();
                                                lnPremArtic = cr_premArticL.getOid();

                                                try {
                                                    //Cleal - 21468
                                                    //collLotePremArtic = lotePremArticLH.findByLotePremioArticulo(lnPremArtic);
                                                    collLotePremArtic = lotePremArticLH.findByLotePremioArticulo(lnPremArticOrig);

                                                    if (collLotePremArtic != null) {
                                                        UtilidadesLog.debug("collLotePremArtic != null");

                                                        for (Iterator itLotePremArtic = collLotePremArtic.iterator(); itLotePremArtic.hasNext();) {
                                                            lotePremArticL = (LotePremioArticulosLocal) itLotePremArtic.next();
                                                            UtilidadesLog.debug("crea Lote Premio Artículo");

                                                            // crea Lote Premio Artículo 
                                                            // by Lote Premio Articulo
                                                            cr_lotePremArticL = lotePremArticLH.create(lotePremArticL.getNumeroLote(),
                                                                                                       lotePremArticL.getNumeroPremio(), lnPremArtic);
                                                            cr_lotePremArticL.setDescripcion(lotePremArticL.getDescripcion());
                                                            lotePremArticLH.merge(cr_lotePremArticL);

                                                            // all fields    
                                                            lnLotePremArticOrig = lotePremArticL.getOid();
                                                            lnLotePremArtic = cr_lotePremArticL.getOid();

                                                            try {
                                                                //Cleal - 21468
                                                                //collArticLote = articLoteLH.findByLotePremioArticulo(lnLotePremArtic);
                                                                collArticLote = articLoteLH.findByLotePremioArticulo(lnLotePremArticOrig);

                                                                if (collArticLote != null) {
                                                                    UtilidadesLog.debug("collArticLote != null");

                                                                    for (Iterator itArticLote = collArticLote.iterator(); itArticLote.hasNext();) {
                                                                        articLoteL = (ArticulosLoteLocal) itArticLote.next();
                                                                        UtilidadesLog.debug("crea Articulo Lote ");

                                                                        // crea Articulo Lote 
                                                                        // by Lote Premio Articulo
                                                                        // vbongiov -- 17/09/2007
                                                                        cr_articLoteL = articLoteLH.create(articLoteL.getDespacha(),
                                                                                                           articLoteL.getPrecioPublico(),
                                                                                                           articLoteL.getNumeroUnidades(),
                                                                                                           articLoteL.getCodigoVentaFicticio(),
                                                                                                           articLoteL.getProducto(), lnLotePremArtic,
                                                                                                           articLoteL.getIndCentroServGar(), articLoteL.getIndTipoEntrega());
                                                                                                           
                                                                         cr_articLoteL.setOidCentroServGar(articLoteL.getOidCentroServGar());
                                                                         cr_articLoteL.setNumMeses(articLoteL.getNumMeses());
                                                                         cr_articLoteL.setObservaciones(articLoteL.getObservaciones());
                                                                         cr_articLoteL.setOidCentroServEntrega(articLoteL.getOidCentroServEntrega());  
                                                                         articLoteLH.merge(cr_articLoteL);
                                                                        //Cleal - 21468
                                                                        //cr_articLoteL.setLote(articLoteL.getLote());

                                                                        // all fields                                                          
                                                                    }
                                                                } // collArticLote !null
                                                            } catch (NoResultException fe) {
                                                                UtilidadesLog.debug("FinderEx Articulo Lote");
                                                            } catch (PersistenceException ce) {
                                                                UtilidadesLog.error("ERROR ", ce);
                                                                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                                                            }
                                                        }
                                                    } // collLotePremArtic !null
                                                } catch (NoResultException fe) {
                                                    UtilidadesLog.debug("FinderEx Lote Premio Articulo");
                                                } catch (PersistenceException ce) {
                                                    UtilidadesLog.error("ERROR ", ce);
                                                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                                                }
                                            }
                                        } // ollPremArtic !null
                                    } catch (NoResultException fe) {
                                        UtilidadesLog.debug("FinderEx Premio Articulo");
                                    } catch (PersistenceException ce) {
                                        UtilidadesLog.error("ERROR ", ce);
                                        throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                                    }

                                    try {
                                        UtilidadesLog.debug("crea Premio Puntos ");

                                        // crea Premio Puntos by ParametroNivelPremiacion
                                        //Cleal - 21468
                                        //collPremPunt = premPuntLH.findByParametroNivelPremiacion(lnParamNivelPrem);
                                        collPremPunt = premPuntLH.findByParametroNivelPremiacion(lnParamNivelPremOrig);

                                        if (collPremPunt != null) {
                                            UtilidadesLog.debug("collPremPunt != null ");

                                            for (Iterator itPremPunt = collPremPunt.iterator(); itPremPunt.hasNext();) {
                                                premPuntL = (PremioPuntosLocal) itPremPunt.next();
                                                cr_premPuntL = premPuntLH.create(premPuntL.getNumeroPremio(), lnParamNivelPrem,
                                                                                 premPuntL.getTipoPremioPuntos(), premPuntL.getConcursoDestino());//Cleal - 21468
                                                cr_premPuntL.setCantidad(premPuntL.getCantidad());
                                                cr_premPuntL.setPorcentaje(premPuntL.getPorcentaje());
                                                premPuntLH.merge(cr_premPuntL);

                                                // all fields                            
                                            }
                                        } // collPremPunt !null
                                    } catch (NoResultException fe) {
                                        UtilidadesLog.debug("FinderEx Premio Puntos");
                                    } catch (PersistenceException ce) {
                                        UtilidadesLog.debug("CreateEx Premio Puntos");
                                    }

                                    try {
                                        //Cleal - 21468
                                        //collPremDescuento = premDescuentoLH.findByParametroNivelPremiacion(lnParamNivelPrem);
                                        collPremDescuento = premDescuentoLH.findByParametroNivelPremiacion(lnParamNivelPremOrig);

                                        if (collPremDescuento != null) {
                                            UtilidadesLog.debug("collPremDescuento != null ");

                                            for (Iterator itPremDescuento = collPremDescuento.iterator(); itPremDescuento.hasNext();) {
                                                premDescuentoL = (PremioDescuentoLocal) itPremDescuento.next();
                                                UtilidadesLog.debug("crea PremioDescuento by ParametroNivelPremiacion");

                                                // crea Premio Descuento by ParametroNivelPremiacion
                                                try {
                                                    cr_premDescuentoL = premDescuentoLH.create(premDescuentoL.getNumeroPremio(), lnParamNivelPrem,
                                                                                               premDescuentoL.getPeriodoDesde(),
                                                                                               premDescuentoL.getTipoDescuento());
                                                    //Cleal - 21468
                                                    cr_premDescuentoL.setCantidadDescuento(premDescuentoL.getCantidadDescuento());
                                                    cr_premDescuentoL.setPeriodoHasta(premDescuentoL.getPeriodoHasta());
                                                    cr_premDescuentoL.setPorcentajeDescuento(premDescuentoL.getPorcentajeDescuento());
                                                    premDescuentoLH.merge(cr_premDescuentoL);

                                                    // all fields
                                                } catch (PersistenceException ce) {
                                                    UtilidadesLog.debug("CreateEx Producto Descuento ");
                                                }

                                                lnPremDescuentoOrig = premDescuentoL.getOid();
                                                lnPremDescuento = cr_premDescuentoL.getOid();

                                                try {
                                                    UtilidadesLog.debug("crea Producto Descuento by Premio Descuento");

                                                    // crea Producto Descuento by Premio Descuento
                                                    //Cleal - 21468
                                                    //collProdDescuento = prodDescuentoLH.findByPremioDescuento(lnPremDescuento);
                                                    collProdDescuento = prodDescuentoLH.findByPremioDescuento(lnPremDescuentoOrig);

                                                    if (collProdDescuento != null) {
                                                        UtilidadesLog.debug("collProdDescuento != null");

                                                        for (Iterator itProdDescuento = collProdDescuento.iterator(); itProdDescuento.hasNext();) {
                                                            prodDescuentoL = (ProductoDescuentoLocal) itProdDescuento.next();

                                                            cr_prodDescuentoL = prodDescuentoLH.create(prodDescuentoL.getMarcaProducto(),
                                                                                                       lnPremDescuento);
                                                            cr_prodDescuentoL.setCodigoProducto(prodDescuentoL.getCodigoProducto());
                                                            cr_prodDescuentoL.setGenerico(prodDescuentoL.getGenerico());
                                                            cr_prodDescuentoL.setNegocio(prodDescuentoL.getNegocio());
                                                            cr_prodDescuentoL.setSupergenerico(prodDescuentoL.getSupergenerico());
                                                            cr_prodDescuentoL.setUnidadNegocio(prodDescuentoL.getUnidadNegocio());
                                                            prodDescuentoLH.merge(cr_prodDescuentoL);

                                                            // all fields                                             
                                                        }
                                                    } // collProdDescuento !null
                                                } catch (NoResultException fe) {
                                                    UtilidadesLog.debug("FinderEx Producto Descuento");
                                                } catch (PersistenceException ce) {
                                                    UtilidadesLog.debug("CreateEx Producto Descuento");
                                                }
                                            }
                                        } // collPremDescuento !null
                                    } catch (NoResultException fe) {
                                        UtilidadesLog.debug("FinderEx Premio Descuento");
                                    } catch (PersistenceException ce) {
                                        UtilidadesLog.error("ERROR ", ce);
                                        throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                                    }
                                }
                            } // collParamNivelPrem !null        
                        } catch (NoResultException fe) {
                            UtilidadesLog.debug("FinderEx ParametrosNivelPremiacion");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("CreateEx ParametrosNivelPremiacion");
                        }

                        Long lnRegPrem = null;
                        RequisitosPremiacionLocalHome requisPremLH = this.getRequisitosPremiacionLocalHome();
                        RequisitosPremiacionLocal requisPremL = null;
                        RequisitosPremiacionLocal cr_requisPremL = null;

                        try {
                            requisPremL = requisPremLH.findByUK(argOidConcOrig);
                            UtilidadesLog.debug("crea Requisitos Premiacion by UK concurso");

                            // crea Requisitos Premiacion by UK concurso
                            cr_requisPremL = requisPremLH.create(requisPremL.getPedidoEnPeriodo(), requisPremL.getPagoATiempo(), crOidConcOrig);
                            cr_requisPremL.setAsistenciaCurso(requisPremL.getAsistenciaCurso());
                            cr_requisPremL.setCuotaIngreso(requisPremL.getCuotaIngreso());
                            cr_requisPremL.setDiasGracia(requisPremL.getDiasGracia());
                            cr_requisPremL.setMontoMinimoConcurso(requisPremL.getMontoMinimoConcurso());
                            cr_requisPremL.setMontoMinimoPedido(requisPremL.getMontoMinimoPedido());
                            cr_requisPremL.setNumeroPedidos(requisPremL.getNumeroPedidos());
                            cr_requisPremL.setPeriodoDesde(requisPremL.getPeriodoDesde());
                            cr_requisPremL.setPeriodoHasta(requisPremL.getPeriodoHasta());
                            requisPremLH.merge(cr_requisPremL);

                            // all fields
                            lnRegPrem = cr_requisPremL.getOid();
                        } catch (NoResultException fe) {
                            UtilidadesLog.debug("FinderEx Requisitos Premiacion by UK concurso");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("CreateEx Requisitos Premiacion");
                        }

                        try {
                            ProductosExigidosPremiacionLocal prodExigidPremL = null;
                            ProductosExigidosPremiacionLocal cr_prodExigidPremL = null;
                            ProductosExigidosPremiacionLocalHome prodExigidPremLH = this.getProductosExigidosPremiacionLocalHome();
                            Collection collProdExigidPrem = prodExigidPremLH.findByRequisito(lnRegPrem);

                            if (collProdExigidPrem != null) {
                                UtilidadesLog.debug("collProdExigidPrem != null ");

                                for (Iterator itProdExigidPrem = collProdExigidPrem.iterator(); itProdExigidPrem.hasNext();) {
                                    prodExigidPremL = (ProductosExigidosPremiacionLocal) itProdExigidPrem.next();
                                    UtilidadesLog.debug("crea Productos Exigidos Premiación ");

                                    // crea Productos Exigidos Premiación 
                                    // by Requisito obtenido previamente
                                    cr_prodExigidPremL = prodExigidPremLH.create(lnRegPrem, prodExigidPremL.getMarcaProducto());
                                    cr_prodExigidPremL.setCodigoProducto(prodExigidPremL.getCodigoProducto());
                                    cr_prodExigidPremL.setGenerico(prodExigidPremL.getGenerico());
                                    cr_prodExigidPremL.setNegocio(prodExigidPremL.getNegocio());
                                    //Cleal - 21468
                                    //cr_prodExigidPremL.setRequisitos(prodExigidPremL.getRequisitos());
                                    cr_prodExigidPremL.setSupergenerico(prodExigidPremL.getSupergenerico());
                                    cr_prodExigidPremL.setUnidadNegocio(prodExigidPremL.getUnidadNegocio());
                                    prodExigidPremLH.merge(cr_prodExigidPremL);

                                    // all fields
                                }
                            } // collProdExigidPrem !null
                        } catch (NoResultException fe) {
                            UtilidadesLog.debug("FinderEx Productos Exigidos Premiación");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("CreateEx Productos Exigidos Premiación");
                        }

                        try {
                            UtilidadesLog.debug("crea Despacho de Premios by Concurso ");

                            // crea Despacho de Premios by Concurso
                            DespachoPremiosLocal despachPremL = null;
                            DespachoPremiosLocal cr_despachPremL = null;
                            DespachoPremiosLocalHome despachPremLH = this.getDespachoPremiosLocalHome();
                            Collection collDespachPrem = despachPremLH.findByConcurso(argOidConcOrig);

                            if (collDespachPrem != null) {
                                UtilidadesLog.debug("collDespachPrem != null ");

                                for (Iterator itDespachPrem = collDespachPrem.iterator(); itDespachPrem.hasNext();) {
                                    despachPremL = (DespachoPremiosLocal) itDespachPrem.next();
                                    cr_despachPremL = despachPremLH.create(despachPremL.getComunicacionDespachoAutomatico(),
                                                                           despachPremL.getComunicacionDespachoManual(), crOidConcOrig);
                                    cr_despachPremL.setMensajeDespachoAutomatico(despachPremL.getMensajeDespachoAutomatico());
                                    cr_despachPremL.setMensajeDespachoManual(despachPremL.getMensajeDespachoManual());
                                    despachPremLH.merge(cr_despachPremL);

                                    // all fields
                                }
                            } // collDespachPrem !null
                        } catch (NoResultException fe) {
                            UtilidadesLog.debug("FinderEx Productos Exigidos Premiación");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("CreateEx Productos Exigidos Premiación");
                        }

                        try {
                            AccesoConcursoLocal accesoConcursoL = null;
                            AccesoConcursoLocal cr_accesoConcursoL = null;
                            AccesoConcursoLocalHome accesoConcursoLH = this.getAccesoConcursoLocalHome();
                            Collection collAccesoConcurso = accesoConcursoLH.findByConcurso(argOidConcOrig);

                            if (collAccesoConcurso != null) {
                                UtilidadesLog.debug("collAccesoConcurso != null ");

                                for (Iterator itAccesoConcurso = collAccesoConcurso.iterator(); itAccesoConcurso.hasNext();) {
                                    UtilidadesLog.debug("crea Acceso Concurso by Concurso ");

                                    accesoConcursoL = (AccesoConcursoLocal) itAccesoConcurso.next();
                                    UtilidadesLog.debug("crOidConcOrig "  + crOidConcOrig);
                                    UtilidadesLog.debug("accesoConcursoL.getAcceso() "  + accesoConcursoL.getAcceso());

                                    // crea Acceso Concurso by Concurso
                                    cr_accesoConcursoL = accesoConcursoLH.create(crOidConcOrig, accesoConcursoL.getAcceso());
                                    
                                    UtilidadesLog.debug("cr_accesoConcursoL "  + cr_accesoConcursoL.getOid());

                                    // all fields
                                }
                            }
                        } catch (NoResultException fe) {
                            UtilidadesLog.debug("FinderEx Acceso Concurso by Concursos", fe);
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("CreateEx Acceso Concurso by Concursos", ce);
                        } catch (Exception ce) {
                            UtilidadesLog.debug("CreateEx Acceso Concurso by Concursos", ce);
                        }


                        UtilidadesLog.debug(" ------ ******* -------");
                        
                        /*Crear un dtoNuevaVersion del tipo DTONuevaVersion con:
                         oidConcurso = oid
                         //el oid que se ha creado en la entidad ConcursoParametrosGenerales
                         pais = concursoOrigen.pais
                         oidMarca = concursoOrigen.marca
                         oidCanal = concursoOrigen.canal

                         oidPeriodoDesde = concursoOrigen.periodoDesde <- inc. 18957
                         oidPeriodoHasta = concursoOrigen.periodoHasta <- inc. 18957
                         oidRequisitoPremiacion = oid del registro creado
                             en la entidad RequisitosPremiacion
                         indPagoTiempo = reqPremiacionOrigen.pagoATiempo
                         diasGracia = reqPremiacionOrigen.diasGracia

                         oidPeriodoDesde = reqPremiacionOrigen.periodoDesde <- inc. 18957
                         oidPeriodoHasta = reqPremiacionOrigen.periodoHasta <- inc. 18957*/
                         
                        /* Agregado por Ssantana, 10/05/2006, Versionado */
                        String nomPeriodo = null;
                        if (requisPremL != null && requisPremL.getPeriodoHasta() != null) {
                            try {
                                PeriodoLocalHome periodoLH = this.getPeriodoLocalHome();
                                PeriodoLocal periodoL = periodoLH.findByPrimaryKey(requisPremL.getPeriodoHasta());
                                nomPeriodo = periodoL.getNombrePeriodo();
                            } catch (NoResultException nre) {
                                nomPeriodo = "";     
                            } catch (PersistenceException ce) {
                                UtilidadesLog.error("ERROR ", ce);
                                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                            }    
                        } else {
                            nomPeriodo = "";
                        }
                        
                        UtilidadesLog.debug(" ------ ******* 11 ------- ");
                        /* Fin Agregado por Ssantana, 10/05/2006, Versionado */
                        
                        dtoNuevaVersion = new DTONuevaVersion();
                        dtoNuevaVersion.setOidConcurso(crOidConcOrig);

                        dtoNuevaVersion.setOidPais(concursoOrigen.getPais());
                        dtoNuevaVersion.setOidMarca(concursoOrigen.getMarca());
                        dtoNuevaVersion.setOidCanal(concursoOrigen.getCanal());

                        dtoNuevaVersion.setOidPeriodoDesde(concursoOrigen.getPeriodoDesde());
                        dtoNuevaVersion.setOidPeriodoHasta(concursoOrigen.getPeriodoHasta());
                        dtoNuevaVersion.setOidRequisitoPremiacion(lnRegPrem);
                        
                        /* Agregado por Ssantana, 10/05/2006, Versionado */
                        dtoNuevaVersion.setCodPeriodoHasta(nomPeriodo);
                        /* Fin Agregado por Ssantana, 10/05/2006, Versionado */
                        
                        /* */
                        UtilidadesLog.debug(" ------ ******* 22 ------- ");

                        if (requisPremL != null) {
                            dtoNuevaVersion.setIndPagoTiempo(requisPremL.getPagoATiempo());
                            dtoNuevaVersion.setDiasGracia(requisPremL.getDiasGracia());

                            dtoNuevaVersion.setOidPeriodoDesdeReq(requisPremL.getPeriodoDesde());
                            dtoNuevaVersion.setOidPeriodoHastaReq(requisPremL.getPeriodoHasta());
                        }
                    } // si hizo create y oid para crear concursos
                } else { // - si concurso ya existe
                    UtilidadesLog.debug("concurso ya existe");

                    Long oidConcursoExistente = concursoExistente.getOid();

                    UtilidadesLog.debug("oidConcursoExistente  " + oidConcursoExistente);

                    RequisitosPremiacionLocalHome requisPremLH = this.getRequisitosPremiacionLocalHome();
                    RequisitosPremiacionLocal requisPremL = null;

                    try {
                        requisPremL = requisPremLH.findByUK(oidConcursoExistente);
                    } catch (NoResultException fe) {
                        UtilidadesLog.debug("FinderEx Requisitos Premiacion by UK concurso");
                    } catch (PersistenceException ce) {
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }

                    //concursoExistente
                    /* Agregado por Ssantana, 10/05/2006, Versionado */
                    String nomPeriodo = null;
                    try {
                        PeriodoLocalHome periodoLH = this.getPeriodoLocalHome();
                        PeriodoLocal periodoL = 
                            periodoLH.findByPrimaryKey(requisPremL.getPeriodoHasta());
                        nomPeriodo = periodoL.getNombrePeriodo();
                        
                    } catch (NoResultException nre) {
                        nomPeriodo = "";         
                    } 
                    /* Fin Agregado por Ssantana, 10/05/2006, Versionado */
                    
                    dtoNuevaVersion = new DTONuevaVersion();
                    dtoNuevaVersion.setOidConcurso(oidConcursoExistente);

                    /* Agregado por Ssantana, 10/05/2006, Versionado */
                    dtoNuevaVersion.setCodPeriodoHasta(nomPeriodo);
                    /* Fin Agregado por Ssantana, 10/05/2006, Versionado */

                    UtilidadesLog.debug("1");

                    dtoNuevaVersion.setOidPais(concursoOrigen.getPais());
                    dtoNuevaVersion.setOidMarca(concursoOrigen.getMarca());
                    dtoNuevaVersion.setOidCanal(concursoOrigen.getCanal());

                    dtoNuevaVersion.setOidPeriodoDesde(concursoOrigen.getPeriodoDesde());
                    dtoNuevaVersion.setOidPeriodoHasta(concursoOrigen.getPeriodoHasta());

                    if (requisPremL != null) {
                        UtilidadesLog.debug("2");

                        if (requisPremL.getOid() != null) {
                            UtilidadesLog.debug("3");
                            dtoNuevaVersion.setOidRequisitoPremiacion(requisPremL.getOid());
                        }

                        UtilidadesLog.debug("4");
                        dtoNuevaVersion.setIndPagoTiempo(requisPremL.getPagoATiempo());
                        dtoNuevaVersion.setDiasGracia(requisPremL.getDiasGracia());

                        dtoNuevaVersion.setOidPeriodoDesdeReq(requisPremL.getPeriodoDesde());
                        dtoNuevaVersion.setOidPeriodoHastaReq(requisPremL.getPeriodoHasta());
                    }

                    UtilidadesLog.debug("5");
                } // - si concurso existe

                UtilidadesLog.debug(" dtoNuevaVersion seteado ");
            } // verifique concurso origen !null
        } // dtoe.getOidConcursoOrigen() !null

        UtilidadesLog.debug(" dtoNuevaVersion : " + dtoNuevaVersion);
        UtilidadesLog.info("MONConcursoBean.crearConcursoNuevaVersion(DTOVersion dtoe):Salida");
        return dtoNuevaVersion;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param dtoe DTOVersion
     * @version 1.00 25 abr 2005
     * @author Igor Dedough
     *
     * //Se inserta un registro en la entidad VersionesConcurso
        Se hace un create() en la entidad VersionesConcurso con la siguiente información:
        oid = secuencia
        concurso = null //porque todavía no se crea el concurso realmente, sólo la posible nueva versión para un posible nuevo concurso
        concursoOrigen = DTOE.oidConcursoOrigen
        version = DTOE.version
        numeroConcurso = DTOE.numeroConcurso
        estadoConcurso = DTOE.oidEstado
        periodoEntradaVigor = DTOE.oidPeriodoInicioVigor

     *
     */
    public void insertarVersion(DTOVersion dtoe) throws MareException {
        UtilidadesLog.info("MONConcursoBean.insertarVersion(DTOVersion dtoe):Entrada");
        try {
            VersionesConcursoLocalHome versionesConcursoLH = this.getVersionesConcursoLocalHome();
            /*VersionesConcursoLocal versionesConcursoL = versionesConcursoLH.create(dtoe.getVersionNueva(), dtoe.getNumeroConcurso(),
                                                                                   dtoe.getOidPeriodoInicioVigor(), dtoe.getOidConcursoOrigen(),
                                                                                   dtoe.getOidEstado());*/
            
                
           VersionesConcursoLocal versionesConcursoL = versionesConcursoLH.create(dtoe.getVersionNueva(), 
                                                                                  dtoe.getNumeroConcurso(),
                                                                                   dtoe.getOidPeriodoInicioVigor(), 
                                                                                   dtoe.getOidConcursoOrigen(),
                                                                                   dtoe.getOidEstado(),
                                                                                   ConstantesINC.OID_VIG_CONCU_EN_PROCESO
                                                                                   );
           versionesConcursoL.setConcurso(null);
           versionesConcursoLH.merge(versionesConcursoL);
           
           Collection col = versionesConcursoLH.findByConcurso(dtoe.getOidConcursoOrigen());
           Iterator it = col.iterator();
            
           VersionesConcursoLocal versionOrigen = null;
           while (it.hasNext()) {
               versionOrigen = (VersionesConcursoLocal) it.next();
               versionOrigen.setEstadoConcurso(ConstantesINC.OID_ESTADO_EN_CAMBIO);
               versionesConcursoLH.merge(versionOrigen);
           }                                                                                   
        } catch (NoResultException fEx) {
            UtilidadesLog.error("ERROR ", fEx);
            sessionContext.setRollbackOnly();
            throw new MareException(fEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            sessionContext.setRollbackOnly();
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
        }
        UtilidadesLog.info("MONConcursoBean.insertarVersion(DTOVersion dtoe):Salida");
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 27/04/2005
     */
    public DTOProgramaNuevas obtenerProgramaNuevas(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerProgramaNuevas(DTOOID DTOE):Entrada");
        DAOConcurso dao = new DAOConcurso();
        DTOProgramaNuevas dto = dao.obtenerProgramaNuevas(DTOE);
        UtilidadesLog.info("MONConcursoBean.obtenerProgramaNuevas(DTOOID DTOE):Salida");
        return dto;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 27/04/2005
     */
    public DTOListaAmbitosGeograficos obtenerListaAmbitosGeograficos(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerListaAmbitosGeograficos(DTOOID DTOE):Entrada");
        DAOConcurso dao = new DAOConcurso();
        DTOListaAmbitosGeograficos dto = dao.obtenerListaAmbitosGeograficos(DTOE);
        UtilidadesLog.info("MONConcursoBean.obtenerListaAmbitosGeograficos(DTOOID DTOE):Salida");
        return dto;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 27/04/2005
     */
    public DTOObtencionPuntos obtenerObtencionPuntos(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerObtencionPuntos(DTOOID DTOE):Entrada");
        DAOConcurso dao = new DAOConcurso();
        DTOObtencionPuntos dto = dao.obtenerObtencionPuntos(DTOE);
        UtilidadesLog.info("MONConcursoBean.obtenerObtencionPuntos(DTOOID DTOE):Salida");   
        return dto;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 27/04/2005
     */
    public DTOListaMontoVentaRecomendadas obtenerMontoVentaRecomendadas(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerMontoVentaRecomendadas(DTOOID DTOE):Entrada");   
        DAOConcurso dao = new DAOConcurso();
        DTOListaMontoVentaRecomendadas dto = dao.obtenerMontoVentaRecomendadas(DTOE);
        UtilidadesLog.info("MONConcursoBean.obtenerMontoVentaRecomendadas(DTOOID DTOE):Salida");   
        return dto;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 27/04/2005
     */
    public DTOClasificacionParticipantes obtenerListasClasificacion(DTOClasificacionParticipantes DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerListasClasificacion(DTOClasificacionParticipantes DTOE):Entrada");   
        DTOOID dtoOID = new DTOOID();
        dtoOID.setOid(DTOE.getOidConcurso());
        dtoOID.setOidPais(DTOE.getOidPais());
        dtoOID.setOidIdioma(DTOE.getOidIdioma());

        DTOOID dtoOID2 = new DTOOID();
        dtoOID2.setOid(DTOE.getOidDirigidoA());
        dtoOID2.setOidPais(DTOE.getOidPais());
        dtoOID2.setOidIdioma(DTOE.getOidIdioma());

        RecordSet rsClasi = null;
        RecordSet rsParti = null;
        DTOSalida dtoClasi = this.obtenerListaClasificacionParticipantes(dtoOID);
        DTOSalida dtoParti = this.obtenerListaParticipantes(dtoOID2);

        if (dtoClasi != null) {
            rsClasi = dtoClasi.getResultado();
        }

        if (dtoParti != null) {
            rsParti = dtoParti.getResultado();
        }

        DTOClasificacionParticipantes dtoClasificacionParticipantes = new DTOClasificacionParticipantes();

        //Ambas listas son de tipo DTOParticipante
        //Se completa la lista LstClasificacionParticipantes
        DTOParticipante dtop = null;

        //Agregado por Cristian Valenzuela - 29/6/2005
        DTOClasificacion dtoc = null;
        ArrayList al = new ArrayList();
        Object o = null;

        for (int i = 0; (rsClasi != null) && !rsClasi.esVacio() && (i < rsClasi.getRowCount()); i++) {
            //Comentado por Cristian Valenzuela - 29/6/2005
            //Se setean los datos de la consulta al DTOClasificacion

            /*dtop = new DTOParticipante();
            dtop.setOid((o=rsClasi.getValueAt(i, "OID_CLAS_PART_CONC"))!=null?new Long(((BigDecimal)o).toString()):null);
            dtop.setDescripcion((o = rsClasi.getValueAt(i, "INC_PARTI"))!=null?o.toString():"");
            al.add(dtop);*/
            dtoc = new DTOClasificacion();
            dtoc.setOidClasificacionParticipante(((o = rsClasi.getValueAt(i, "OID_CLAS_PART_CONC")) != null) ? new Long(((BigDecimal) o).toString())
                                                                                                             : null);
            dtoc.setOidParticipante(((o = rsClasi.getValueAt(i, "OID_PART_CONC_CABE")) != null) ? new Long(((BigDecimal) o).toString()) : null);
            dtoc.setDescripcion(((o = rsClasi.getValueAt(i, "INC_PARTI")) != null) ? o.toString() : "");
            al.add(dtoc);
        }

        dtoClasificacionParticipantes.setLstClasificacionParticipantes(al);

        //Se completa la lista setLstParticipantes
        al = new ArrayList();

        for (int i = 0; (rsParti != null) && !rsParti.esVacio() && (i < rsParti.getRowCount()); i++) {
            dtop = new DTOParticipante();
            dtop.setOid(((o = rsParti.getValueAt(i, "OID_PART_CONC_CABE")) != null) ? new Long(((BigDecimal) o).toString()) : null);
            dtop.setDescripcion(((o = rsParti.getValueAt(i, "INC_PARTI")) != null) ? o.toString() : "");
            al.add(dtop);
        }

        dtoClasificacionParticipantes.setLstParticipantes(al);
        UtilidadesLog.info("MONConcursoBean.obtenerListasClasificacion(DTOClasificacionParticipantes DTOE):Salida");   
        return dtoClasificacionParticipantes;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 27/04/2005
     */
    public DTOSalida obtenerListaClasificacionParticipantes(DTOOID DTOE)
            throws MareException {
        
        UtilidadesLog.info("MONConcursoBean.obtenerListaClasificacionParticipantes(DTOOID DTOE):Entrada");   
        DAOConcurso dao = new DAOConcurso();
        RecordSet rs = dao.obtenerListaClasificacionParticipantes(DTOE);
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(rs);
        UtilidadesLog.info("MONConcursoBean.obtenerListaClasificacionParticipantes(DTOOID DTOE):Salida");   
        return dtos;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 27/04/2005
     */
    public DTOParametrosConsultoras obtenerParametrosConsultoras(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerParametrosConsultoras(DTOOID DTOE):Entrada");   
        DAOConcurso dao = new DAOConcurso();
        DTOParametrosConsultoras dto = dao.obtenerParametrosConsultoras(DTOE);
        UtilidadesLog.info("MONConcursoBean.obtenerParametrosConsultoras(DTOOID DTOE):Salida");   
        return dto;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 27/04/2005
     */
    public DTOParametrosGeneralesPremiacion obtenerParametrosPremiacion(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerParametrosPremiacion(DTOOID DTOE):Entrada");   
        DAOConcurso dao = new DAOConcurso();
        DTOParametrosGeneralesPremiacion dtoParametrosPremiacion = dao.obtenerParametrosPremiacion(DTOE);
        DTOSalida dtos = this.obtenerMaximoNumeroPremio(DTOE);

        if (dtos != null) {
            RecordSet rs = dtos.getResultado();

            if ((rs != null) && !rs.esVacio() && (rs.getValueAt(0, 0) != null)) {
                dtoParametrosPremiacion.setNumeroPremio(new Integer(((BigDecimal) rs.getValueAt(0, 0)).toString()));
            }
        }
        UtilidadesLog.info("MONConcursoBean.obtenerParametrosPremiacion(DTOOID DTOE):Salida");   
        return dtoParametrosPremiacion;
    }

    /**obtenerProductosValidos
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 27/04/2005
     */
    public DTOSalida obtenerMaximoNumeroPremio(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerMaximoNumeroPremio(DTOOID DTOE):Salida");   
        DAOConcurso dao = new DAOConcurso();
        RecordSet maximoPremio = dao.obtenerMaximoNumeroPremio(DTOE);
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(maximoPremio);
        UtilidadesLog.info("MONConcursoBean.obtenerMaximoNumeroPremio(DTOOID DTOE):Salida");      
        return dtos;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 27/04/2005
     */
    public DTORequisitosPremiacion obtenerRequisitosPremiacion(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerRequisitosPremiacion(DTOOID DTOE):Entrada");      
        DAOConcurso dao = new DAOConcurso();
        DTORequisitosPremiacion dto = dao.obtenerRequisitosPremiacion(DTOE);
        UtilidadesLog.info("MONConcursoBean.obtenerRequisitosPremiacion(DTOOID DTOE):Salida");      
        return dto;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 27/04/2005
     */
    public DTOCursosExigidosPremiacion obtenerCursosExigidosPremiacion(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerCursosExigidosPremiacion(DTOOID DTOE):entrada");      
        DAOConcurso dao = new DAOConcurso();
        DTOCursosExigidosPremiacion dto = dao.obtenerCursosExigidosPremiacion(DTOE);
        UtilidadesLog.info("MONConcursoBean.obtenerCursosExigidosPremiacion(DTOOID DTOE):Salida");
        return dto;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 27/04/2005
     */
    public DTOProductosExigidosPremiacion obtenerProductosExigidosPremiacion(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerCursosExigidosPremiacion(DTOOID DTOE):Entrada");
        DAOConcurso dao = new DAOConcurso();
        DTOProductosExigidosPremiacion dto = dao.obtenerProductosExigidosPremiacion(DTOE);
        UtilidadesLog.info("MONConcursoBean.obtenerCursosExigidosPremiacion(DTOOID DTOE):Salida");
        return dto;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 27/04/2005
     */
    public DTODespachoPremios obtenerDespachoPremios(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerDespachoPremios(DTOOID DTOE):Entrada");
        DAOConcurso dao = new DAOConcurso();
        DTODespachoPremios dto = dao.obtenerDespachoPremios(DTOE);
        UtilidadesLog.info("MONConcursoBean.obtenerDespachoPremios(DTOOID DTOE):Salida");
        return dto;
    }

    public DTOProducto obtenerProductosValidos(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerProductosValidos(DTOOID DTOE):Entrada");
        ProductosLocalHome productosLH = null;
        ProductosLocal productosL = null;

        try {
            UtilidadesLog.info("*** DTOE.getOid(): "+DTOE.getOid());
            productosLH = this.getProductosLocalHome();
            productosL = productosLH.findByUK(DTOE.getOid());
        } catch (NoResultException fe) {
            UtilidadesLog.info("MONConcursoBean.obtenerProductosValidos(DTOOID DTOE):Salida - FinderException");
            return null;

            //throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
         } catch (PersistenceException ce) {
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        

        DTOOID dtoOID = new DTOOID();
        dtoOID.setOid(productosL.getOid());
        dtoOID.setOidPais(DTOE.getOidPais());
        dtoOID.setOidIdioma(DTOE.getOidIdioma());

        DAOConcurso dao = new DAOConcurso();

        RecordSet rs = dao.obtenerProductosValidos(dtoOID);

        DTOProducto dtoProdu = new DTOProducto();
        dtoProdu.setOidTipoProducto(ConstantesINC.OID_TIPO_PRODUCTOS_VALIDOS);
        dtoProdu.setIndComunicacion(productosL.getComunicacionValidos());
        dtoProdu.setCodigoMensaje(productosL.getMensajeValidos());

        //-------------------
        DTOProdu dtop = null;
        ArrayList al = new ArrayList();
        Object o = null;

        /*
        A.OID_PROD_VALI,
        A.MAPR_OID_MARC_PROD,
        A.UNEG_OID_UNID_NEGO,
        A.NEGO_OID_NEGO,
        A.SGEN_OID_SUPE_GENE,
        A.GENE_OID_GENE,
        A.PROD_OID_PROD,
        A.TOFE_OID_TIPO_OFER,
        A.CIVI_OID_CICL_VIDA,
        NULL,
        NULL,
        B.DES_MARC_PROD,
        G1.VAL_I18N UNIDA_NEGOC,
        G2.VAL_I18N NEGOC,
        G3.VAL_I18N SUPER_GENER,
        G4.VAL_I18N GENER,
        G5.VAL_I18N TIPO_OFERT,
        G6.VAL_I18N CICLO_VIDA,
        C.COD_SAP,
        NULL,
        NULL,
        NULL,
        NULL,
        NULL

        */
        for (int i = 0; (rs != null) && !rs.esVacio() && (i < rs.getRowCount()); i++) {
            dtop = new DTOProdu();
            dtop.setCicloVida(((o = rs.getValueAt(i, "CICLO_VIDA")) != null) ? o.toString() : "");
            dtop.setCodigoProducto(((o = rs.getValueAt(i, "COD_SAP")) != null) ? o.toString() : "");

            //dtop.setFactorMultiplicidad(  );
            dtop.setGenerico(((o = rs.getValueAt(i, "GENER")) != null) ? o.toString() : "");

            //dtop.setMarcaProducto(  );
            //dtop.setMontoExigido();
            dtop.setNegocio(((o = rs.getValueAt(i, "NEGOC")) != null) ? o.toString() : "");

            //dtop.setOid(  );
            dtop.setOidCicloVida(((o = rs.getValueAt(i, "CIVI_OID_CICL_VIDA")) != null) ? new Long(((BigDecimal) o).toString()) : null);

            dtop.setOidGenerico(((o = rs.getValueAt(i, "GENE_OID_GENE")) != null) ? new Long(((BigDecimal) o).toString()) : null);
            dtop.setOidMarcaProducto(((o = rs.getValueAt(i, "MAPR_OID_MARC_PROD")) != null) ? new Long(((BigDecimal) o).toString()) : null);
            dtop.setOidNegocio(((o = rs.getValueAt(i, "NEGO_OID_NEGO")) != null) ? new Long(((BigDecimal) o).toString()) : null);
            dtop.setOidProducto(((o = rs.getValueAt(i, "PROD_OID_PROD")) != null) ? new Long(((BigDecimal) o).toString()) : null);
            dtop.setOidSupergenerico(((o = rs.getValueAt(i, "SGEN_OID_SUPE_GENE")) != null) ? new Long(((BigDecimal) o).toString()) : null);
            dtop.setOidTipoOferta(((o = rs.getValueAt(i, "TOFE_OID_TIPO_OFER")) != null) ? new Long(((BigDecimal) o).toString()) : null);
            dtop.setOidUnidadNegocio(((o = rs.getValueAt(i, "UNEG_OID_UNID_NEGO")) != null) ? new Long(((BigDecimal) o).toString()) : null);

            dtop.setSupergenerico(((o = rs.getValueAt(i, "SUPER_GENER")) != null) ? o.toString() : "");
            dtop.setTipoOferta(((o = rs.getValueAt(i, "TIPO_OFERT")) != null) ? o.toString() : "");
            dtop.setUnidadNegocio(((o = rs.getValueAt(i, "UNIDA_NEGOC")) != null) ? o.toString() : "");
            dtop.setMarcaProducto(((o = rs.getValueAt(i, "DES_MARC_PROD")) != null) ? o.toString() : ""); //DES_MARC_PROD
            dtop.setNegocio(((o = rs.getValueAt(i, "NEGOC")) != null) ? o.toString() : ""); //NEGOC
            dtop.setGenerico(((o = rs.getValueAt(i, "GENER")) != null) ? o.toString() : ""); //GENER
            dtop.setCicloVida(((o = rs.getValueAt(i, "CICLO_VIDA")) != null) ? o.toString() : ""); //CICLO_VIDA
            dtop.setCodigoProducto(((o = rs.getValueAt(i, "COD_SAP")) != null) ? o.toString() : ""); //COD_SAP

            al.add(dtop);
        }

        dtoProdu.setLstProductos(al);
        UtilidadesLog.info("MONConcursoBean.obtenerProductosValidos(DTOOID DTOE):Salida");
        return dtoProdu;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 28/04/2005
     */
    public DTOProducto obtenerProductosExcluidos(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerProductosExcluidos(DTOOID DTOE):Entrada");
        ProductosLocalHome productosLH = null;
        ProductosLocal productosL = null;
        DTOProducto dtoProdu = null;

        try {
            productosLH = this.getProductosLocalHome();
            productosL = productosLH.findByUK(DTOE.getOid());
        } catch (NoResultException fe) {
            UtilidadesLog.info("MONConcursoBean.obtenerProductosExcluidos(DTOOID DTOE):Salida");
            return null;

            //throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
         } catch (PersistenceException ce) {
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        DAOConcurso dao = new DAOConcurso();

        DTOOID dtoOID = new DTOOID();
        dtoOID.setOid(productosL.getOid());
        dtoOID.setOidPais(DTOE.getOidPais());
        dtoOID.setOidIdioma(DTOE.getOidIdioma());

        RecordSet rs = dao.obtenerProductosExcluidos(dtoOID);

        if ((rs != null) && !rs.esVacio()) {
            dtoProdu = new DTOProducto();

            dtoProdu.setOidTipoProducto(ConstantesINC.OID_TIPO_PRODUCTOS_EXCLUIDOS);
            dtoProdu.setIndComunicacion(productosL.getComunicacionExcluidos());
            dtoProdu.setCodigoMensaje(productosL.getMensajeExcluidos());

            //Se carga la lista
            DTOProdu dtop = null;
            Object o = null;
            ArrayList al = new ArrayList();

            for (int i = 0; i < rs.getRowCount(); i++) {
                dtop = new DTOProdu();

                //OID_PROD_EXCL
                dtop.setOidMarcaProducto(((o = rs.getValueAt(i, "MAPR_OID_MARC_PROD")) != null) ? new Long(((BigDecimal) o).toString()) : null); //MAPR_OID_MARC_PROD
                dtop.setOidUnidadNegocio(((o = rs.getValueAt(i, "UNEG_OID_UNID_NEGO")) != null) ? new Long(((BigDecimal) o).toString()) : null); //UNEG_OID_UNID_NEGO
                dtop.setOidNegocio(((o = rs.getValueAt(i, "NEGO_OID_NEGO")) != null) ? new Long(((BigDecimal) o).toString()) : null); //NEGO_OID_NEGO
                dtop.setOidSupergenerico(((o = rs.getValueAt(i, "SGEN_OID_SUPE_GENE")) != null) ? new Long(((BigDecimal) o).toString()) : null); //SGEN_OID_SUPE_GENE
                dtop.setOidGenerico(((o = rs.getValueAt(i, "GENE_OID_GENE")) != null) ? new Long(((BigDecimal) o).toString()) : null); //GENE_OID_GENE
                dtop.setOidProducto(((o = rs.getValueAt(i, "PROD_OID_PROD")) != null) ? new Long(((BigDecimal) o).toString()) : null); //PROD_OID_PROD
                dtop.setOidTipoOferta(((o = rs.getValueAt(i, "TOFE_OID_TIPO_OFER")) != null) ? new Long(((BigDecimal) o).toString()) : null); //TOFE_OID_TIPO_OFER
                dtop.setOidCicloVida(((o = rs.getValueAt(i, "CIVI_OID_CICL_VIDA")) != null) ? new Long(((BigDecimal) o).toString()) : null); //CIVI_OID_CICL_VIDA
                dtop.setOidPeriodoDesde(((o = rs.getValueAt(i, "PERD_OID_PERI_DESD")) != null) ? new Long(((BigDecimal) o).toString()) : null); //PERD_OID_PERI_DESD
                dtop.setOidPeriodoHasta(((o = rs.getValueAt(i, "PERD_OID_PERI_HAST")) != null) ? new Long(((BigDecimal) o).toString()) : null); //PERD_OID_PERI_HAST
                dtop.setMarcaProducto(((o = rs.getValueAt(i, "DES_MARC_PROD")) != null) ? o.toString() : ""); //DES_MARC_PROD
                dtop.setUnidadNegocio(((o = rs.getValueAt(i, "UNIDA_NEGOC")) != null) ? o.toString() : ""); //UNIDA_NEGOC
                dtop.setNegocio(((o = rs.getValueAt(i, "NEGOC")) != null) ? o.toString() : ""); //NEGOC
                dtop.setSupergenerico(((o = rs.getValueAt(i, "SUPER_GENER")) != null) ? o.toString() : ""); //SUPER_GENER
                dtop.setGenerico(((o = rs.getValueAt(i, "GENER")) != null) ? o.toString() : ""); //GENER
                dtop.setTipoOferta(((o = rs.getValueAt(i, "TIPO_OFERT")) != null) ? o.toString() : ""); //TIPO_OFERT
                dtop.setCicloVida(((o = rs.getValueAt(i, "CICLO_VIDA")) != null) ? o.toString() : ""); //CICLO_VIDA
                dtop.setCodigoProducto(((o = rs.getValueAt(i, "COD_SAP")) != null) ? o.toString() : ""); //COD_SAP
                dtop.setPeriodoDesde(((o = rs.getValueAt(i, "DESC_PERI_DESD")) != null) ? o.toString() : ""); //DESC_PERI_DESD
                dtop.setPeriodoHasta(((o = rs.getValueAt(i, "DESC_PERI_HAST")) != null) ? o.toString() : ""); //DESC_PERI_HAST
                al.add(dtop);
            }

            dtoProdu.setLstProductos(al);
        }
        UtilidadesLog.info("MONConcursoBean.obtenerProductosExcluidos(DTOOID DTOE):Salida");
        return dtoProdu;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 28/04/2005
     */
    public DTOProducto obtenerProductosBonificados(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerProductosBonificados(DTOOID DTOE):Entrada");
        ProductosLocalHome productosLH = null;
        ProductosLocal productosL = null;
        DTOProducto dtoProdu = null;

        try {
            productosLH = this.getProductosLocalHome();
            productosL = productosLH.findByUK(DTOE.getOid());
        } catch (NoResultException fe) {
            UtilidadesLog.info("MONConcursoBean.obtenerProductosBonificados(DTOOID DTOE):Salida");
            return null;

            //throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
         } catch (PersistenceException ce) {
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        DAOConcurso dao = new DAOConcurso();

        DTOOID dtoOID = new DTOOID();
        dtoOID.setOid(productosL.getOid());
        dtoOID.setOidPais(DTOE.getOidPais());
        dtoOID.setOidIdioma(DTOE.getOidIdioma());

        RecordSet rs = dao.obtenerProductosBonificados(dtoOID);

        if ((rs != null) && !rs.esVacio()) {
            dtoProdu = new DTOProducto();

            dtoProdu.setOidTipoProducto(ConstantesINC.OID_TIPO_PRODUCTOS_BONIFICADOS);
            dtoProdu.setIndComunicacion(productosL.getComunicacionBonificados());
            dtoProdu.setCodigoMensaje(productosL.getMensajeBonificados());

            //Se carga la lista
            DTOProdu dtop = null;
            Object o = null;
            ArrayList al = new ArrayList();

            for (int i = 0; i < rs.getRowCount(); i++) {
                dtop = new DTOProdu();

                //OID_PROD_BONI
                dtop.setOidMarcaProducto(((o = rs.getValueAt(i, "MAPR_OID_MARC_PROD")) != null) ? new Long(((BigDecimal) o).toString()) : null); //MAPR_OID_MARC_PROD
                dtop.setOidUnidadNegocio(((o = rs.getValueAt(i, "UNEG_OID_UNID_NEGO")) != null) ? new Long(((BigDecimal) o).toString()) : null); //UNEG_OID_UNID_NEGO
                dtop.setOidNegocio(((o = rs.getValueAt(i, "NEGO_OID_NEGO")) != null) ? new Long(((BigDecimal) o).toString()) : null); //NEGO_OID_NEGO
                dtop.setOidSupergenerico(((o = rs.getValueAt(i, "SGEN_OID_SUPE_GENE")) != null) ? new Long(((BigDecimal) o).toString()) : null); //SGEN_OID_SUPE_GENE
                dtop.setOidGenerico(((o = rs.getValueAt(i, "GENE_OID_GENE")) != null) ? new Long(((BigDecimal) o).toString()) : null); //GENE_OID_GENE
                dtop.setOidProducto(((o = rs.getValueAt(i, "PROD_OID_PROD")) != null) ? new Long(((BigDecimal) o).toString()) : null); //PROD_OID_PROD
                dtop.setOidTipoOferta(((o = rs.getValueAt(i, "TOFE_OID_TIPO_OFER")) != null) ? new Long(((BigDecimal) o).toString()) : null); //TOFE_OID_TIPO_OFER
                dtop.setOidCicloVida(((o = rs.getValueAt(i, "CIVI_OID_CICL_VIDA")) != null) ? new Long(((BigDecimal) o).toString()) : null); //CIVI_OID_CICL_VIDA
                dtop.setOidPeriodoDesde(((o = rs.getValueAt(i, "PERD_OID_PERI_DESD")) != null) ? new Long(((BigDecimal) o).toString()) : null); //PERD_OID_PERI_DESD
                dtop.setOidPeriodoHasta(((o = rs.getValueAt(i, "PERD_OID_PERI_HAST")) != null) ? new Long(((BigDecimal) o).toString()) : null); //PERD_OID_PERI_HAST
                dtop.setMarcaProducto(((o = rs.getValueAt(i, "DES_MARC_PROD")) != null) ? o.toString() : ""); //DES_MARC_PROD
                dtop.setUnidadNegocio(((o = rs.getValueAt(i, "UNIDA_NEGOC")) != null) ? o.toString() : ""); //UNIDA_NEGOC
                dtop.setNegocio(((o = rs.getValueAt(i, "NEGOC")) != null) ? o.toString() : ""); //NEGOC
                dtop.setSupergenerico(((o = rs.getValueAt(i, "SUPER_GENER")) != null) ? o.toString() : ""); //SUPER_GENER
                dtop.setGenerico(((o = rs.getValueAt(i, "GENER")) != null) ? o.toString() : ""); //GENER
                dtop.setTipoOferta(((o = rs.getValueAt(i, "TIPO_OFERT")) != null) ? o.toString() : ""); //TIPO_OFERT
                dtop.setCicloVida(((o = rs.getValueAt(i, "CICLO_VIDA")) != null) ? o.toString() : ""); //CICLO_VIDA
                dtop.setCodigoProducto(((o = rs.getValueAt(i, "COD_SAP")) != null) ? o.toString() : ""); //COD_SAP
                dtop.setPeriodoDesde(((o = rs.getValueAt(i, "DESC_PERI_DESD")) != null) ? o.toString() : ""); //DESC_PERI_DESD
                dtop.setPeriodoHasta(((o = rs.getValueAt(i, "DESC_PERI_HAST")) != null) ? o.toString() : ""); //DESC_PERI_HAST
                dtop.setPuntosUnidad(((o = rs.getValueAt(i, "NUM_PUNT_UNID")) != null) ? new Integer(((BigDecimal) o).toString()) : null); //NUM_PUNT_UNID
                dtop.setFactorMultiplicidad(((o = rs.getValueAt(i, "VAL_FACT_MULT")) != null) ? new Integer(((BigDecimal) o).toString()) : null); //VAL_FACT_MULT
                al.add(dtop);
            }

            dtoProdu.setLstProductos(al);
        }
        UtilidadesLog.info("MONConcursoBean.obtenerProductosBonificados(DTOOID DTOE):Salida");
        return dtoProdu;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 28/04/2005
     */
    public DTOProducto obtenerProductosExigidos(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerProductosExigidos(DTOOID DTOE):Entrada");
        ProductosLocalHome productosLH = null;
        ProductosLocal productosL = null;
        DTOProducto dtoProdu = null;

        try {
            productosLH = this.getProductosLocalHome();
            productosL = productosLH.findByUK(DTOE.getOid());
        } catch (NoResultException fe) {
            UtilidadesLog.info("MONConcursoBean.obtenerProductosExigidos(DTOOID DTOE):Salida");
            return null;

            //throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
         } catch (PersistenceException ce) {
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        DAOConcurso dao = new DAOConcurso();

        DTOOID dtoOID = new DTOOID();
        dtoOID.setOid(productosL.getOid());
        dtoOID.setOidPais(DTOE.getOidPais());
        dtoOID.setOidIdioma(DTOE.getOidIdioma());

        RecordSet rs = dao.obtenerProductosExigidos(dtoOID);

        if ((rs != null) && !rs.esVacio()) {
            dtoProdu = new DTOProducto();

            dtoProdu.setOidTipoProducto(ConstantesINC.OID_TIPO_PRODUCTOS_EXIGIDOS);
            dtoProdu.setIndComunicacion(productosL.getComunicacionExigidos());
            dtoProdu.setCodigoMensaje(productosL.getMensajeExigidos());

            //Se carga la lista
            DTOProdu dtop = null;
            Object o = null;
            ArrayList al = new ArrayList();

            for (int i = 0; i < rs.getRowCount(); i++) {
                dtop = new DTOProdu();

                //OID_PROD_EXIG
                dtop.setOidMarcaProducto(((o = rs.getValueAt(i, "MAPR_OID_MARC_PROD")) != null) ? new Long(((BigDecimal) o).toString()) : null); //MAPR_OID_MARC_PROD
                dtop.setOidUnidadNegocio(((o = rs.getValueAt(i, "UNEG_OID_UNID_NEGO")) != null) ? new Long(((BigDecimal) o).toString()) : null); //UNEG_OID_UNID_NEGO
                dtop.setOidNegocio(((o = rs.getValueAt(i, "NEGO_OID_NEGO")) != null) ? new Long(((BigDecimal) o).toString()) : null); //NEGO_OID_NEGO
                dtop.setOidSupergenerico(((o = rs.getValueAt(i, "SGEN_OID_SUPE_GENE")) != null) ? new Long(((BigDecimal) o).toString()) : null); //SGEN_OID_SUPE_GENE
                dtop.setOidGenerico(((o = rs.getValueAt(i, "GENE_OID_GENE")) != null) ? new Long(((BigDecimal) o).toString()) : null); //GENE_OID_GENE
                dtop.setOidProducto(((o = rs.getValueAt(i, "PROD_OID_PROD")) != null) ? new Long(((BigDecimal) o).toString()) : null); //PROD_OID_PROD
                dtop.setOidTipoOferta(((o = rs.getValueAt(i, "TOFE_OID_TIPO_OFER")) != null) ? new Long(((BigDecimal) o).toString()) : null); //TOFE_OID_TIPO_OFER
                dtop.setOidCicloVida(((o = rs.getValueAt(i, "CIVI_OID_CICL_VIDA")) != null) ? new Long(((BigDecimal) o).toString()) : null); //CIVI_OID_CICL_VIDA
                dtop.setOidPeriodoDesde(((o = rs.getValueAt(i, "PERD_OID_PERI_DESD")) != null) ? new Long(((BigDecimal) o).toString()) : null); //PERD_OID_PERI_DESD
                dtop.setOidPeriodoHasta(((o = rs.getValueAt(i, "PERD_OID_PERI_HAST")) != null) ? new Long(((BigDecimal) o).toString()) : null); //PERD_OID_PERI_HAST
                dtop.setMarcaProducto(((o = rs.getValueAt(i, "DES_MARC_PROD")) != null) ? o.toString() : ""); //DES_MARC_PROD
                dtop.setUnidadNegocio(((o = rs.getValueAt(i, "UNIDA_NEGOC")) != null) ? o.toString() : ""); //UNIDA_NEGOC
                dtop.setNegocio(((o = rs.getValueAt(i, "NEGOC")) != null) ? o.toString() : ""); //NEGOC
                dtop.setSupergenerico(((o = rs.getValueAt(i, "SUPER_GENER")) != null) ? o.toString() : ""); //SUPER_GENER
                dtop.setGenerico(((o = rs.getValueAt(i, "GENER")) != null) ? o.toString() : ""); //GENER
                dtop.setTipoOferta(((o = rs.getValueAt(i, "TIPO_OFERT")) != null) ? o.toString() : ""); //TIPO_OFERT
                dtop.setCicloVida(((o = rs.getValueAt(i, "CICLO_VIDA")) != null) ? o.toString() : ""); //CICLO_VIDA
                dtop.setCodigoProducto(((o = rs.getValueAt(i, "COD_SAP")) != null) ? o.toString() : ""); //COD_SAP
                dtop.setPeriodoDesde(((o = rs.getValueAt(i, "DESC_PERI_DESD")) != null) ? o.toString() : ""); //DESC_PERI_DESD
                dtop.setPeriodoHasta(((o = rs.getValueAt(i, "DESC_PERI_HAST")) != null) ? o.toString() : ""); //DESC_PERI_HAST
                dtop.setUnidadesExigidas(((o = rs.getValueAt(i, "NUM_UNID_EXIG")) != null) ? new Integer(((BigDecimal) o).toString()) : null); //NUM_UNID_EXIG
                dtop.setMontoExigido(((o = rs.getValueAt(i, "IMP_MONT_EXIG")) != null) ? (BigDecimal) o : null); //IMP_MONT_EXIG
                dtop.setPuntosExigidos(((o = rs.getValueAt(i, "NUM_PUNT_EXIG")) != null) ? new Integer(((BigDecimal) o).toString()) : null); //NUM_PUNT_EXIG
                // vbongiov -- Cambio 20080807 -- 15/04/2009
                dtop.setCodIndAgrup(((o = rs.getValueAt(i, "IND_AGRUP")) != null) ? o.toString() : ""); //IND_AGRUP
                
                if(dtop.getCodIndAgrup().equals("T")){
                    dtop.setIndAgrup("Obligatorio"); 
                }
                
                if(dtop.getCodIndAgrup().equals("U")){
                    dtop.setIndAgrup("Opcional"); 
                }
                
                al.add(dtop);
            }

            dtoProdu.setLstProductos(al);
        }
        UtilidadesLog.info("MONConcursoBean.obtenerProductosExigidos(DTOOID DTOE):Salida");
        return dtoProdu;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 28/04/2005
     */
    public DTOProducto obtenerProductosACalificar(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerProductosACalificar(DTOOID DTOE):Entrada");
        DTOProducto dtoProdu = null;
        DAOConcurso dao = new DAOConcurso();
        RecordSet rs = dao.obtenerProductosACalificar(DTOE);

        //Se carga la lista
        DTOProdu dtop = null;
        Object o = null;
        ArrayList al = new ArrayList();

        if ((rs != null) && !rs.esVacio()) {
            dtoProdu = new DTOProducto();
            dtoProdu.setOidTipoProducto(ConstantesINC.OID_TIPO_PRODUCTOS_A_CALIFICAR);

            for (int i = 0; i < rs.getRowCount(); i++) {
                dtop = new DTOProdu();

                //OID_PROD_CALI
                dtop.setOidMarcaProducto(((o = rs.getValueAt(i, "MAPR_OID_MARC_PROD")) != null) ? new Long(((BigDecimal) o).toString()) : null); //MAPR_OID_MARC_PROD
                dtop.setOidUnidadNegocio(((o = rs.getValueAt(i, "UNEG_OID_UNID_NEGO")) != null) ? new Long(((BigDecimal) o).toString()) : null); //UNEG_OID_UNID_NEGO
                dtop.setOidNegocio(((o = rs.getValueAt(i, "NEGO_OID_NEGO")) != null) ? new Long(((BigDecimal) o).toString()) : null); //NEGO_OID_NEGO
                dtop.setOidSupergenerico(((o = rs.getValueAt(i, "SGEN_OID_SUPE_GENE")) != null) ? new Long(((BigDecimal) o).toString()) : null); //SGEN_OID_SUPE_GENE
                dtop.setOidGenerico(((o = rs.getValueAt(i, "GENE_OID_GENE")) != null) ? new Long(((BigDecimal) o).toString()) : null); //GENE_OID_GENE
                dtop.setOidProducto(((o = rs.getValueAt(i, "PROD_OID_PROD")) != null) ? new Long(((BigDecimal) o).toString()) : null); //PROD_OID_PROD
                dtop.setOidTipoOferta(((o = rs.getValueAt(i, "TOFE_OID_TIPO_OFER")) != null) ? new Long(((BigDecimal) o).toString()) : null); //TOFE_OID_TIPO_OFER
                dtop.setOidCicloVida(((o = rs.getValueAt(i, "CIVI_OID_CICL_VIDA")) != null) ? new Long(((BigDecimal) o).toString()) : null); //CIVI_OID_CICL_VIDA
                dtop.setMarcaProducto(((o = rs.getValueAt(i, "DES_MARC_PROD")) != null) ? o.toString() : ""); //DES_MARC_PROD
                dtop.setUnidadNegocio(((o = rs.getValueAt(i, "UNIDA_NEGOC")) != null) ? o.toString() : ""); //UNIDA_NEGOC
                dtop.setNegocio(((o = rs.getValueAt(i, "NEGOC")) != null) ? o.toString() : ""); //NEGOC
                dtop.setSupergenerico(((o = rs.getValueAt(i, "SUPER_GENER")) != null) ? o.toString() : ""); //SUPER_GENER
                dtop.setGenerico(((o = rs.getValueAt(i, "GENER")) != null) ? o.toString() : ""); //GENER
                dtop.setTipoOferta(((o = rs.getValueAt(i, "TIPO_OFERT")) != null) ? o.toString() : ""); //TIPO_OFERT
                dtop.setCicloVida(((o = rs.getValueAt(i, "CICLO_VIDA")) != null) ? o.toString() : ""); //CICLO_VIDA
                dtop.setCodigoProducto(((o = rs.getValueAt(i, "COD_SAP")) != null) ? o.toString() : ""); //COD_SAP
                al.add(dtop);
            }

            dtoProdu.setLstProductos(al);
        }
        UtilidadesLog.info("MONConcursoBean.obtenerProductosACalificar(DTOOID DTOE):Salida");
        return dtoProdu;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 28/04/2005
     */
    public DTOProducto obtenerProductosExcluidosCalificacion(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerProductosExcluidosCalificacion(DTOOID DTOE):Salida");
        DTOProducto dtoProdu = null;
        DAOConcurso dao = new DAOConcurso();
        RecordSet rs = dao.obtenerProductosExcluidosCalificacion(DTOE);

        //Se carga la lista
        DTOProdu dtop = null;
        Object o = null;
        ArrayList al = new ArrayList();

        if ((rs != null) && !rs.esVacio()) {
            dtoProdu = new DTOProducto();
            dtoProdu.setOidTipoProducto(ConstantesINC.OID_TIPO_PRODUCTOS_EXCLUIDOS_CALIFICACION);

            for (int i = 0; i < rs.getRowCount(); i++) {
                dtop = new DTOProdu();

                //OID_PROD_EXCL_CALI
                dtop.setOidMarcaProducto(((o = rs.getValueAt(i, "MAPR_OID_MARC_PROD")) != null) ? new Long(((BigDecimal) o).toString()) : null); //MAPR_OID_MARC_PROD
                dtop.setOidUnidadNegocio(((o = rs.getValueAt(i, "UNEG_OID_UNID_NEGO")) != null) ? new Long(((BigDecimal) o).toString()) : null); //UNEG_OID_UNID_NEGO
                dtop.setOidNegocio(((o = rs.getValueAt(i, "NEGO_OID_NEGO")) != null) ? new Long(((BigDecimal) o).toString()) : null); //NEGO_OID_NEGO
                dtop.setOidSupergenerico(((o = rs.getValueAt(i, "SGEN_OID_SUPE_GENE")) != null) ? new Long(((BigDecimal) o).toString()) : null); //SGEN_OID_SUPE_GENE
                dtop.setOidGenerico(((o = rs.getValueAt(i, "GENE_OID_GENE")) != null) ? new Long(((BigDecimal) o).toString()) : null); //GENE_OID_GENE
                dtop.setOidProducto(((o = rs.getValueAt(i, "PROD_OID_PROD")) != null) ? new Long(((BigDecimal) o).toString()) : null); //PROD_OID_PROD
                dtop.setOidTipoOferta(((o = rs.getValueAt(i, "TOFE_OID_TIPO_OFER")) != null) ? new Long(((BigDecimal) o).toString()) : null); //TOFE_OID_TIPO_OFER
                dtop.setOidCicloVida(((o = rs.getValueAt(i, "CIVI_OID_CICL_VIDA")) != null) ? new Long(((BigDecimal) o).toString()) : null); //CIVI_OID_CICL_VIDA
                dtop.setOidPeriodoDesde(((o = rs.getValueAt(i, "PERD_OID_PERI")) != null) ? new Long(((BigDecimal) o).toString()) : null); //PERD_OID_PERI_DESD
                dtop.setOidPeriodoHasta(((o = rs.getValueAt(i, "PERD_OID_PERI_HASTA")) != null) ? new Long(((BigDecimal) o).toString()) : null); //PERD_OID_PERI_HAST
                dtop.setMarcaProducto(((o = rs.getValueAt(i, "DES_MARC_PROD")) != null) ? o.toString() : ""); //DES_MARC_PROD
                dtop.setUnidadNegocio(((o = rs.getValueAt(i, "UNIDA_NEGOC")) != null) ? o.toString() : ""); //UNIDA_NEGOC
                dtop.setNegocio(((o = rs.getValueAt(i, "NEGOC")) != null) ? o.toString() : ""); //NEGOC
                dtop.setSupergenerico(((o = rs.getValueAt(i, "SUPER_GENER")) != null) ? o.toString() : ""); //SUPER_GENER
                dtop.setGenerico(((o = rs.getValueAt(i, "GENER")) != null) ? o.toString() : ""); //GENER
                dtop.setTipoOferta(((o = rs.getValueAt(i, "TIPO_OFERT")) != null) ? o.toString() : ""); //TIPO_OFERT
                dtop.setCicloVida(((o = rs.getValueAt(i, "CICLO_VIDA")) != null) ? o.toString() : ""); //CICLO_VIDA
                dtop.setCodigoProducto(((o = rs.getValueAt(i, "COD_SAP")) != null) ? o.toString() : ""); //COD_SAP
                dtop.setPeriodoDesde(((o = rs.getValueAt(i, "DESC_PERI_DESD")) != null) ? o.toString() : ""); //DESC_PERI_DESD
                dtop.setPeriodoHasta(((o = rs.getValueAt(i, "DESC_PERI_HAST")) != null) ? o.toString() : ""); //DESC_PERI_HAST
                al.add(dtop);
            }

            dtoProdu.setLstProductos(al);
        }
        UtilidadesLog.info("MONConcursoBean.obtenerProductosExcluidosCalificacion(DTOOID DTOE):Salida");
        return dtoProdu;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana
     * Modificado: Cristian Valenzuela
     * Fecha:      23/2/2006
     * Incidencia: 22393
     */
    public DTOParametrosCalificacion obtenerParametrosCalificacion(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerParametrosCalificacion(DTOOID DTOE):Entrada");

        DTOParametrosCalificacion dtoCali = null;
        ParametrosCalificacionLocal cali = null;
        ParametrosCalificacionLocalHome parametrosCalificacionLH = null;

        MensajesLocal msgL = null;
        MensajesLocalHome msgLH = null;
        MONCalcularMetas monCalcularMetas = null;
        MONCalcularMetasHome monCalcularMetasHome = null;

        try {
            parametrosCalificacionLH = this.getParametrosCalificacionLocalHome();
            msgLH = this.getMensajesLocalHome();
            cali = parametrosCalificacionLH.findByUK(DTOE.getOid());

            if (cali.getMensaje() != null) {
                msgL = msgLH.findByPrimaryKey(cali.getMensaje());
            }
        } catch (NoResultException fe) {
            UtilidadesLog.error(fe);
            //throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
         } catch (PersistenceException ce) {
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        // Agregado por ssantana, si no se encuentran datos en BD para el Oid,
        // retorna NULL
        if (cali != null) {
            dtoCali = new DTOParametrosCalificacion();
            dtoCali.setOidParamCalificacion(cali.getOid());
            dtoCali.setIndDevoluciones(cali.getDevoluciones());
            dtoCali.setIndAnulaciones(cali.getAnulaciones());
            dtoCali.setIndFaltantesNoAnunciados(cali.getFaltantesNoAnunciados());
            dtoCali.setIndMetasModificables(cali.getMetasModificables());
            dtoCali.setIndMetasBloqueadas(cali.getMetasBloqueadas());
            dtoCali.setIndComunicacion(cali.getComunicacionCalificacion());
            dtoCali.setOidDirigidoA(cali.getDirigidoA());
            dtoCali.setOidFormaCalculo(cali.getFormaCalculo());
            dtoCali.setOidPeriodoDesde(cali.getPeriodoDesde());
            dtoCali.setOidPeriodoHasta(cali.getPeriodoHasta());
            dtoCali.setOidTipoDeterminacionMetas(cali.getTipoDeterminacionMetas());
            dtoCali.setOidTipoIncremento(cali.getTipoIncremento());
            dtoCali.setOidTipoVentaCalificacion(cali.getTipoVentaCalificacion());
            dtoCali.setOidTipoVentaHistorica(cali.getTipoVentaHistorica());
            dtoCali.setOidTipoVentaIncremental(cali.getTipoVentaIncremental());
            dtoCali.setLstIncrementosPorRango(this.obtenerIncrementosPorRango(DTOE.getOid()));
            dtoCali.setOidAgrupacion(cali.getAgrupacion());

            if (msgL != null) {
                dtoCali.setMensaje(msgL.getCodMensaje());
                dtoCali.setOidPais(msgL.getOidPais());
            }

            try {
                monCalcularMetasHome = this.getMONCalcularMetasHome();
                monCalcularMetas = monCalcularMetasHome.create();
            } catch (NamingException ne) {
                UtilidadesLog.error("ERROR ", ne);
                throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch (CreateException fe) {
                UtilidadesLog.error("ERROR ", fe);
                throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch (RemoteException re) {
                UtilidadesLog.error("ERROR ", re);
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }

            try {                
                dtoCali.setListaMetasVentaProyectada(monCalcularMetas.obtenerMetasVentaProyectadaSubgerencia(DTOE.getOid()));
                dtoCali.setListaMetasVentaProyectadaRegion(monCalcularMetas.obtenerMetasVentaProyectadaRegion(DTOE.getOid()));
                dtoCali.setListaMetasVentaProyectadaZona(monCalcularMetas.obtenerMetasVentaProyectadaZona(DTOE.getOid()));
                /*
                 * Modificado por Rafael Romero
                 * Para la consulta de concursos las metas no se traen de una vez.
                 * Solo se verifica que existan y se agrega una objeto a la lista como indicador
                 * de que hay Metas
                 */
                dtoCali.setListaMetasTipoVenta(monCalcularMetas.existenMetasTipoVenta(DTOE.getOid()));
            }
            catch (RemoteException re) {
                UtilidadesLog.error("ERROR ", re);
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }

        UtilidadesLog.debug("****** Retorna dtoCali: " + dtoCali);
        UtilidadesLog.info("MONConcursoBean.obtenerParametrosCalificacion(DTOOID DTOE):Salida");
        return dtoCali;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 02/05/2005
     */
    public DTOSalida obtenerMarcas(DTOOID DTOE) throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerMarcas(DTOOID DTOE):Entrada");
        DAOConcurso dao = new DAOConcurso();
        RecordSet rs = dao.obtenerMarcas(DTOE);
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(rs);
        UtilidadesLog.info("MONConcursoBean.obtenerMarcas(DTOOID DTOE):Salida");
        return dtos;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 02/05/2005
     */
    public DTOSalida obtenerAccesos(DTOOID DTOE) throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerAccesos(DTOOID DTOE):Entrada");
        DAOConcurso dao = new DAOConcurso();
        RecordSet rs = dao.obtenerAccesos(DTOE);
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(rs);
        UtilidadesLog.info("MONConcursoBean.obtenerAccesos(DTOOID DTOE):Salida");
        return dtos;
    }

    private MONCalcularMetasHome getMONCalcularMetasHome()
            throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONCalcularMetasHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONCalcularMetas"), MONCalcularMetasHome.class);
    }

    /**
    * @author: ssantana, 3/5/2005
    * @throws es.indra.mare.common.exception.MareException
    * @return DTOSalida
    * @param DTOTipoProducto DTOE
    */
    public DTOSalida obtenerTiposProducto(DTOTipoProducto DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerTiposProducto(DTOTipoProducto DTOE):Entrada");
        DAOConcurso daoConcurso = new DAOConcurso();
        RecordSet rTipos = null;
        DTOSalida dtoSalida = new DTOSalida();
        PlantillaConcursoLocalHome plantillaConcursoLH = null;
        PlantillaConcursoLocal plantillaConcurso = null;

        RecordSet rBuffer = new RecordSet(); // Contendrá el Recordset a devolver en el DTOSalida.
        Vector vCols = new Vector();
        vCols.add("OID");
        vCols.add("DESC");
        rBuffer.setColumnIdentifiers(vCols);

        // Obtenemos los tipos de Producto.    
        rTipos = daoConcurso.obtenerTiposProducto(DTOE);
        UtilidadesLog.debug("rTipos original: " + rTipos);

        if (DTOE.getIndGrupoProducto().longValue() == ConstantesINC.IND_GRUPO_PRODUCTO_0.longValue()) {
            UtilidadesLog.debug("Entro al if");

            try {
                Long oidPlantilla = DTOE.getOidPlantilla();
                plantillaConcursoLH = this.getPlantillaConcursoLocalHome();
                plantillaConcurso = plantillaConcursoLH.findByPrimaryKey(oidPlantilla);
            } catch (NoResultException fe) {
                UtilidadesLog.error("ERROR ", fe);
                String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                throw new MareException(fe, UtilidadesError.armarCodigoError(sCodigoError));
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            // Obtengo los long correspondientes al valor booleano de los distintos
            // Estados de los Proeductos.
            long productosValidos = 0;
            long productosExcluidos = 0;
            long productosBonificados = 0;
            long productosExigidos = 0;

            if (plantillaConcurso.getProductosValidos().booleanValue()) {
                productosValidos = 1;
            }

            if (plantillaConcurso.getProductosExcluidos().booleanValue()) {
                productosExcluidos = 1;
            }

            if (plantillaConcurso.getProductosBonificados().booleanValue()) {
                productosBonificados = 1;
            }

            if (plantillaConcurso.getProductosExigidos().booleanValue()) {
                productosExigidos = 1;
            }

            int i = 0;
            int cantFilas = rTipos.getRowCount();

            while (i < cantFilas) {
                UtilidadesLog.debug("***** Bucle con i = " + i);

                boolean registroEliminado = false;
                BigDecimal oid = (BigDecimal) rTipos.getValueAt(i, 0);
                UtilidadesLog.debug("Oid " + oid.toString() + ", CantFilas " + cantFilas);

                // ********** Primer Paso *******************************************************
                UtilidadesLog.debug("Paso 1");

                if (productosValidos == ConstantesINC.IND_ACTIVO.longValue()) {
                    // Quitamos el elemento del RecordSet cuyo oid sea igual 
                    // a ConstantesINC.OID_TIPO_PRODUCTOS_VALIDOS 
                    // o ConstantesINC.OID_TIPO_PRODUCTOS_EXCLUIDOS.
                    long oidTipoProductosValidos = ConstantesINC.OID_TIPO_PRODUCTOS_VALIDOS.longValue();
                    //
                    //long oidTipoProductosExcluidos = ConstantesINC.OID_TIPO_PRODUCTOS_EXCLUIDOS.longValue();

                    if (oid.longValue() == oidTipoProductosValidos)
                    //Cleal - 22142
                    //|| (oid.longValue() == oidTipoProductosExcluidos)) 
                    {
                        UtilidadesLog.debug("Match con Valido o Excluidos");
                        rTipos.removeRow(i);
                        cantFilas = cantFilas - 1;
                        registroEliminado = true;
                    }
                }

                // ********* Segundo Paso ****************************************************
                UtilidadesLog.debug("Paso 2");
                //Cleal - 22142
                if (productosExcluidos == ConstantesINC.IND_INACTIVO.longValue() 
                    && !registroEliminado) {
                    // Quitamos el elemento del recordset cuyo oid sea igual 
                    // a ConstantesINC.OID_TIPO_PRODUCTOS_EXCLUIDOS 
                    long oidTipoProductosExcluidos = ConstantesINC.OID_TIPO_PRODUCTOS_EXCLUIDOS.longValue();

                    if (oid.longValue() == oidTipoProductosExcluidos) {
                        UtilidadesLog.debug("Match con Excluidos");
                        rTipos.removeRow(i);
                        cantFilas = cantFilas - 1;
                        registroEliminado = true;
                    }
                }

                // *********** Tercer Paso ***************************************************
                UtilidadesLog.debug("Paso 3");

                if ((productosBonificados == ConstantesINC.IND_INACTIVO.longValue()) && !registroEliminado) {
                    // Quitamos el elemento del recordset cuyo oid sea igual 
                    // a ConstantesINC.OID_TIPO_PRODUCTOS_BONIFICADOS
                    long oidTipoProductosBonificados = ConstantesINC.OID_TIPO_PRODUCTOS_BONIFICADOS.longValue();

                    if (oid.longValue() == oidTipoProductosBonificados) {
                        UtilidadesLog.debug("Match con Bonificados");
                        rTipos.removeRow(i);
                        cantFilas = cantFilas - 1;
                        registroEliminado = true;
                    }
                }

                // *********** Cuarto Paso ***************************************************
                UtilidadesLog.debug("Paso 4");

                if ((productosExigidos == ConstantesINC.IND_INACTIVO.longValue()) && !registroEliminado) {
                    // Quitamos el elemento del recordset cuyo oid sea igual 
                    // a ConstantesINC.OID_TIPO_PRODUCTOS_EXIGIDOS            
                    long oidProductosExigidos = ConstantesINC.OID_TIPO_PRODUCTOS_EXIGIDOS.longValue();

                    if (oid.longValue() == oidProductosExigidos) {
                        UtilidadesLog.debug("Match con Exigidos");
                        rTipos.removeRow(i);
                        cantFilas = cantFilas - 1;
                        registroEliminado = true;
                    }
                }

                UtilidadesLog.debug("Recordset Luego de Bucle: " + rTipos);

                if (!registroEliminado) {
                    i++;
                    UtilidadesLog.debug("No se elimino registro");
                } else {
                    UtilidadesLog.debug("Se elimino registro");
                }
            } // Fin while
        } // Fin if

        dtoSalida.setResultado(rTipos);
        UtilidadesLog.info("MONConcursoBean.obtenerTiposProducto(DTOTipoProducto DTOE):Salida");
        return dtoSalida;
    }


    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 10/05/2005
     */
    public DTOSalida obtenerTiposVentaIncremental(DTOBelcorp DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerTiposVentaIncremental(DTOBelcorp DTOE):Entrada");
        DAOConcurso dao = new DAOConcurso();
        RecordSet rs = dao.obtenerTiposVentaIncremental(DTOE);
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(rs);
        UtilidadesLog.info("MONConcursoBean.obtenerTiposVentaIncremental(DTOBelcorp DTOE):Salida");
        return dtos;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 10/05/2005
     * Modificado por: Cristian Valenzuela
     * Fecha: 11/08/2006
     * Incidencia: BELC300021050
     */
    public DTOSalida obtenerTiposDeterminacionMetas(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerTiposDeterminacionMetas(DTOOID DTOE):Emtrada");
        DAOConcurso dao = new DAOConcurso();
        RecordSet rs = dao.obtenerTiposDeterminacionMetas(DTOE);
        RecordSet rsFinal = new RecordSet();
        rsFinal.addColumn("OID_TIPO_DETE_META");
        rsFinal.addColumn("VAL_I18N");
        
        int cant = rs.getRowCount();
        DTOSalida dtos = new DTOSalida();
        
        UtilidadesLog.debug("DTOE.getOid(): " + DTOE.getOid());
        if(DTOE.getOid().longValue() == 
            ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS.longValue()) {
            UtilidadesLog.debug("*** dirigido a consultoras");
            
            for(int i=0; i<cant; i++) {
                BigDecimal oid = (BigDecimal)rs.getValueAt(i, "OID_TIPO_DETE_META");
                Long lOid = new Long(oid.longValue());
                if(lOid.longValue() != ConstantesINC.OID_TIPO_DET_METAS_BONO_ANUAL.longValue()) {
                    rsFinal.addRow(rs.getRow(i));
                }            
            }
            
            UtilidadesLog.debug("*** rsFinal: " + rsFinal);            
            dtos.setResultado(rsFinal);
        }       
        else {
            UtilidadesLog.debug("*** rs: " + rs);        
            dtos.setResultado(rs);
        }       
        
        UtilidadesLog.info("MONConcursoBean.obtenerTiposDeterminacionMetas(DTOOID DTOE):Salida");
        return dtos;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 10/05/2005
     */
    public DTOSalida obtenerFormaCalculoMetas(DTOBelcorp DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerFormaCalculoMetas(DTOBelcorp DTOE):Entrada");
        DAOConcurso dao = new DAOConcurso();
        RecordSet rs = dao.obtenerFormaCalculoMetas(DTOE);
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(rs);
        UtilidadesLog.info("MONConcursoBean.obtenerFormaCalculoMetas(DTOBelcorp DTOE):Salida");
        return dtos;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 10/05/2005
     */
    public DTOSalida obtenerTiposIncremento(DTOBelcorp DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerTiposIncremento(DTOBelcorp DTOE):Entrada");
        DAOConcurso dao = new DAOConcurso();
        RecordSet rs = dao.obtenerTiposIncremento(DTOE);
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(rs);
        UtilidadesLog.info("MONConcursoBean.obtenerTiposIncremento(DTOBelcorp DTOE):Salida");
        return dtos;
    }

    public DTOSalida obtenerFormaCalculo(DTOBelcorp DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerFormaCalculo(DTOBelcorp DTOE):Entrada");
        //Llama al método obtenerFormaCalculo(DTOE) de la clase DAOConcurso y obtiene el 
        //RecordSet "formaCalculo" 
        //DTOSalida.resultado = formaCalculo    
        DAOConcurso daoC = new DAOConcurso();
        DTOSalida dtoS = new DTOSalida();
        RecordSet rs = new RecordSet();
        rs = daoC.obtenerFormaCalculo(DTOE);
        dtoS.setResultado(rs);
        UtilidadesLog.info("MONConcursoBean.obtenerFormaCalculo(DTOBelcorp DTOE):Salida");
        return dtoS;
    }

    public DTOSalida obtenerCalculoPremio(DTOBelcorp DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerCalculoPremio(DTOBelcorp DTOE):Entrada");
        /*  Llama al método obtenerCalculoPremio(DTOE) de la clase DAOConcurso y
         * obtiene el RecordSet "calculoPremio"
          DTOSalida.resultado = calculoPremio*/
        DTOSalida dtoS = new DTOSalida();
        DAOConcurso dao = new DAOConcurso();
        RecordSet rs = dao.obtenerCalculoPremio(DTOE);

        if (rs.esVacio()) {
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        dtoS.setResultado(rs);
        UtilidadesLog.info("MONConcursoBean.obtenerCalculoPremio(DTOBelcorp DTOE):Salida");
        return dtoS;
    }

    /**
          * Sistema:     Belcorp
          * Modulo:      INC
          * Fecha:       16/05/2005
          * @version     1.00
          * @autor       Viviana Bongiovanni
          */
    public DTOSalida obtenerTipoPremio(DTOBelcorp dtoe)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerTipoPremio(DTOBelcorp dtoe):Entrada");
        DAOConcurso dao = new DAOConcurso();
        DTOSalida dtoSalida = dao.obtenerTipoPremio(dtoe);
        UtilidadesLog.info("MONConcursoBean.obtenerTipoPremio(DTOBelcorp dtoe):Salida");
        return dtoSalida;
    }

    /**
          * Sistema:     Belcorp
          * Modulo:      INC
          * Fecha:       16/05/2005
          * @version     1.00
          * @autor       Viviana Bongiovanni
          */
    public DTOSalida obtenerTipoEleccion(DTOBelcorp dtoe)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerTipoEleccion(DTOBelcorp dtoe):Entrada");
        DAOConcurso dao = new DAOConcurso();
        DTOSalida dtoSalida = dao.obtenerTipoEleccion(dtoe);
        UtilidadesLog.info("MONConcursoBean.obtenerTipoEleccion(DTOBelcorp dtoe):Salida");
        return dtoSalida;
    }

    public DTOSalida obtenerTipoPremiacion(DTOBoolean dtoe) throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerTipoPremiacion(DTOBoolean dtoe):Entrada");
        DAOConcurso dao = new DAOConcurso();
        DTOSalida dtoSalida = dao.obtenerTipoPremiacion(dtoe);
        UtilidadesLog.info("MONConcursoBean.obtenerTipoPremiacion(DTOBoolean dtoe):Salida");
        return dtoSalida;
    }

    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:       17/05/2005
     * @version     1.00
     * @autor       Carlos Leal
     */
    public DTOVariablesVenta obtenerVariablesVenta(DTOOID dtoe)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerVariablesVenta(DTOOID dtoe):Entrada");
        UtilidadesLog.debug("****Entro MonConcurso.obtenerVariablesVenta****");

        DTOVariablesVenta dtoVariablesVenta;
        DAOConcurso dao = new DAOConcurso();
        dtoVariablesVenta = dao.obtenerVariablesVenta(dtoe);
        UtilidadesLog.debug("****Salio MonConcurso.obtenerVariablesVenta****");
        UtilidadesLog.info("MONConcursoBean.obtenerVariablesVenta(DTOOID dtoe):Salida");
        return dtoVariablesVenta;
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       18/05/2005
           * @version     1.00
           * @autor       Carlos Leal
           */
    public DTOParametrosGerentes obtenerParametrosGerentes(DTOOID dtoe)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerParametrosGerentes(DTOOID dtoe):Entrada");
        UtilidadesLog.debug("****Entro MonConcurso.obtenerParametrosGerentes****");

        DTOParametrosGerentes dTOParametrosGerentes;
        DAOConcurso dao = new DAOConcurso();
        dTOParametrosGerentes = dao.obtenerParametrosGerentes(dtoe);
        UtilidadesLog.debug("****Salio MonConcurso.obtenerParametrosGerentes****");
        UtilidadesLog.info("MONConcursoBean.obtenerParametrosGerentes(DTOOID dtoe):Salida");
        return dTOParametrosGerentes;
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       18/05/2005
           * @version     1.00
           * @autor       Carlos Leal
           */
    public DTOMultinivel obtenerMultinivel(DTOOID dtoe)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerMultinivel(DTOOID dtoe):Entrada");
        UtilidadesLog.debug("****Entro MonConcurso.obtenerMultinivel****");

        DAOConcurso dao = new DAOConcurso();
        DTOMultinivel dTOMultinivel = dao.obtenerMultinivel(dtoe);

        UtilidadesLog.debug("****Salio MonConcurso.obtenerMultinivel****");
        UtilidadesLog.info("MONConcursoBean.obtenerMultinivel(DTOOID dtoe):Salida");
        return dTOMultinivel;
    }

    /**
        * Sistema:     Belcorp
        * Modulo:      INC
        * Fecha:       18/05/2005
        * @version     1.00
        * @autor       Carlos Leal
        */
    public DTOSalida obtenerAgrupacion(DTOBelcorp dtoe)
            throws MareException {
        UtilidadesLog.debug("****Entro MonConcurso.obtenerAgrupacion****");
        UtilidadesLog.info("MONConcursoBean.obtenerAgrupacion(DTOBelcorp dtoe):Entrada");
        DAOConcurso dao = new DAOConcurso();
        DTOSalida dTOSalida = new DTOSalida();
        RecordSet rs = dao.obtenerAgrupacion(dtoe);
        dTOSalida.setResultado(rs);
        UtilidadesLog.debug("****Salio MonConcurso.obtenerAgrupacion****");
        UtilidadesLog.info("MONConcursoBean.obtenerAgrupacion(DTOBelcorp dtoe):Salida");
        return dTOSalida;
    }

    /**
          * Sistema:     Belcorp
          * Modulo:      INC
          * Fecha:       18/05/2005
          * @version     1.00
          * @autor       Carlos Leal
          */
    public DTOVariablesVentaProyectada obtenerVariablesVentaProyectada(DTOOID dtoe)
            throws MareException {
        UtilidadesLog.debug("****Entro MonConcurso.obtenerVariablesVentaProyectada****");
        UtilidadesLog.info("MONConcursoBean.obtenerVariablesVentaProyectada(DTOOID dtoe):Salida");
        DAOConcurso dao = new DAOConcurso();
        DTOVariablesVentaProyectada dTOVariablesVentaProyectada = dao.obtenerVariablesVentaProyectada(dtoe);
        UtilidadesLog.debug("****Salio MonConcurso.obtenerVariablesVentaProyectada****");
        UtilidadesLog.info("MONConcursoBean.obtenerVariablesVentaProyectada(DTOOID dtoe):Salida");
        return dTOVariablesVentaProyectada;
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       18/05/2005
           * @version     1.00
           * @autor       Viviana Bongiovanni
           */
    public DTOSalida obtenerTipoPremiosPuntos(DTOBelcorp dtoe)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerTipoPremiosPuntos(DTOBelcorp dtoe):entrada");
        DAOConcurso dao = new DAOConcurso();
        DTOSalida dtoSalida = dao.obtenerTipoPremiosPuntos(dtoe);
        UtilidadesLog.info("MONConcursoBean.obtenerTipoPremiosPuntos(DTOBelcorp dtoe):Salida");
        return dtoSalida;
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       18/05/2005
           * @version     1.00
           * @autor       Viviana Bongiovanni
           */
    public DTOSalida obtenerTipoPremioMonetario(DTOBelcorp dtoe)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerTipoPremioMonetario(DTOBelcorp dtoe):entrada");
        DAOConcurso dao = new DAOConcurso();
        DTOSalida dtoSalida = dao.obtenerTipoPremioMonetario(dtoe);
        UtilidadesLog.info("MONConcursoBean.obtenerTipoPremioMonetario(DTOBelcorp dtoe):Salida");
        return dtoSalida;
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       18/05/2005
           * @version     1.00
           * @autor       Viviana Bongiovanni
           */
    public DTOSalida obtenerFormaPago(DTOBelcorp dtoe)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerFormaPago(DTOBelcorp dtoe):Entrada");
        DAOConcurso dao = new DAOConcurso();
        DTOSalida dtoSalida = dao.obtenerFormaPago(dtoe);
        UtilidadesLog.info("MONConcursoBean.obtenerFormaPago(DTOBelcorp dtoe):Salida");
        return dtoSalida;
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       18/05/2005
           * @version     1.00
           * @autor       Viviana Bongiovanni
           */
    public DTOSalida obtenerTipoCumplimiento(DTOBelcorp dtoe)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerTipoCumplimiento(DTOBelcorp dtoe):Entrada");
        DAOConcurso dao = new DAOConcurso();
        DTOSalida dtoSalida = dao.obtenerTipoCumplimiento(dtoe);
        UtilidadesLog.info("MONConcursoBean.obtenerTipoCumplimiento(DTOBelcorp dtoe):Salida");
        return dtoSalida;
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       18/05/2005
           * @version     1.00
           * @autor       Viviana Bongiovanni
           */
    public DTOSalida obtenerTipoDescuento(DTOBelcorp dtoe)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerTipoDescuento(DTOBelcorp dtoe):Entrada");
        DAOConcurso dao = new DAOConcurso();
        DTOSalida dtoSalida = dao.obtenerTipoDescuento(dtoe);
        UtilidadesLog.info("MONConcursoBean.obtenerTipoDescuento(DTOBelcorp dtoe):Salida");
        return dtoSalida;
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       20/05/2005
           * @version     1.00
           * @autor       Sergio C. Saavedra                      
           */
    public void guardarDatosConcurso(DTOConcurso DTOE) throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarDatosConcurso(DTOConcurso dtoe):Salida");
        UtilidadesLog.debug("dentro de guardarDatosConcurso, recibo : " + DTOE);

        Long oidConcursoCreado = this.guardarParametrosGeneralesConcurso(DTOE.getParamGenerales());
        UtilidadesLog.debug("concurso luego de guardarParametrosGeneralesConcurso: " + oidConcursoCreado);

        if (DTOE.getParamGenerales().getOid() == null) { //si es una inserción de un concurso se bloquea la plantilla 
            DTOE.getPlantilla().setIndBloqueado(Boolean.TRUE);
            UtilidadesLog.debug("actualizarEstadoPlantilla, con: " + DTOE.getPlantilla());
            // vbongiov -- Cambio 20090920 -- 17/06/2009
            // this.actualizarEstadoPlantilla(DTOE.getPlantilla());
        }

        this.guardarVersion(DTOE.getParamGenerales(), oidConcursoCreado);

        if (DTOE.getIndObligAmbitosGeograficos().booleanValue()) {
            UtilidadesLog.debug("guardarAmbitosGeograficos, con: " + DTOE.getListaAmbitosGeograficos());
            this.guardarAmbitosGeograficos(DTOE.getListaAmbitosGeograficos(), oidConcursoCreado);
        }

        if (DTOE.getIndObligObtencionPuntos().booleanValue()) {
            UtilidadesLog.debug("guardarObtencionPuntos, con: " + DTOE.getObtencionPuntos());
            this.guardarObtencionPuntos(DTOE.getObtencionPuntos(), oidConcursoCreado);
        }

        if (DTOE.getIndEstatusVenta().booleanValue()) {
            UtilidadesLog.debug("guardarEstatusVenta, con: " + DTOE.getEstatusVenta());
            this.guardarEstatusVenta(DTOE, oidConcursoCreado);
        }
        //Cleal - INC-06
        if(DTOE.getIndEstatusVentaConsultoras().booleanValue()){
            guardarEstatusVentaConsultoras(DTOE, oidConcursoCreado);
        }


        if (DTOE.getIndMontoVentaRecomendadas().booleanValue()) {
            UtilidadesLog.debug("guardarMontoVentaRecomendadas, con: " + DTOE.getListaMontoVentaRecomendadas());
            this.guardarMontoVentaRecomendadas(DTOE.getListaMontoVentaRecomendadas(), oidConcursoCreado);
        }

        if (DTOE.getIndClasificacionParticipantes().booleanValue()) {
            UtilidadesLog.debug("guardarClasificacionParticipantes, con: " + DTOE.getClasificParticipantes());
            this.guardarClasificacionParticipantes(DTOE.getClasificParticipantes(), oidConcursoCreado);
        }

        if (DTOE.getIndObligConsultoras().booleanValue()) {
            UtilidadesLog.debug("guardarParametrosConsultoras, con: " + DTOE.getParamConsultoras());
            this.guardarParametrosConsultoras(DTOE.getParamConsultoras(), oidConcursoCreado);
        }

        if (DTOE.getIndObligPremios().booleanValue()) {
            UtilidadesLog.debug("guardarParametrosPremiacion, con: " + DTOE.getParamGralesPremiacion());
            this.guardarParametrosPremiacion(DTOE.getParamGralesPremiacion(), oidConcursoCreado);

            if (DTOE.getIndNivelPremiacion().booleanValue()) {
                UtilidadesLog.debug("guardarNivelesPremiacion, con: " + DTOE.getListaNivelesPremiacion());

                DTONivelesPremiacion param = DTOE.getListaNivelesPremiacion();

                if (DTOE.getOidPais() != null) {
                    param.setOidPais(DTOE.getOidPais());
                }

                this.guardarNivelesPremiacion(param, oidConcursoCreado);
            }
            
            // vbongiov -- Cambio 20080811 -- 26/08/2009
            if(DTOE.getPlantilla().getIndSorteo()!= null && DTOE.getPlantilla().getIndSorteo().booleanValue()){
                this.guardarNiveleSorteoPremiacion(DTOE.getParamGralesPremiacion(), oidConcursoCreado);
            }            
        }

        if (DTOE.getIndObligRequisitosPremiacion().booleanValue()) {
            UtilidadesLog.debug("guardarRequisitosPremiacion, con: " + DTOE.getRequisitosPremiacion());
            this.guardarRequisitosPremiacion(DTOE.getRequisitosPremiacion(), DTOE.getListaCursosExigidosPremiacion(), oidConcursoCreado);

            if (DTOE.getIndCursosExigidosPremiacion().booleanValue()) {
                UtilidadesLog.debug("guardarCursosExigidosPremiacion, con: " + DTOE.getListaCursosExigidosPremiacion());
                this.guardarCursosExigidosPremiacion(DTOE.getListaCursosExigidosPremiacion(), oidConcursoCreado);
            }

            if (DTOE.getIndProductosExigidosPremiacion().booleanValue()) {
                UtilidadesLog.debug("guardarProductosExigidosPremiacion, con: " + DTOE.getListaProductosExigidosPremiacion());

                DTOProductosExigidosPremiacion param = DTOE.getListaProductosExigidosPremiacion();

                if (DTOE.getOidPais() != null) {
                    param.setOidPais(DTOE.getOidPais());
                }

                this.guardarProductosExigidosPremiacion(DTOE.getListaProductosExigidosPremiacion(), oidConcursoCreado);
            }
        }

        if (DTOE.getIndObligDespachoPremios().booleanValue()) {
            UtilidadesLog.debug("guardarDespachoPremios, con: " + DTOE.getDespachoPremios());
            this.guardarDespachoPremios(DTOE.getDespachoPremios(), oidConcursoCreado);
        }
        
        
        /* 
         * Agregado por ssantana, 20/04/2006
         * Se pregunta por indBorradoProductos a Calidifcar y
         * Excluidos Calificacion
         */ 
         
         Boolean indBorradoProdACalificar = 
                DTOE.getIndBorradoProdACalificar();
                
         Boolean indBorradoProdExcluidosCalif = 
                DTOE.getIndBorradoProdExcluidosCalificacion();
          
         if (indBorradoProdACalificar != null && 
                indBorradoProdACalificar.booleanValue() ) {
            this.eliminarProdCalificar(oidConcursoCreado);
         }
         
        if (indBorradoProdExcluidosCalif != null && 
                indBorradoProdExcluidosCalif.booleanValue() ){
           this.eliminarProdExcluidosCalif(oidConcursoCreado);
        }       
        
        //Agregado por cvalenzu - 8/5/2006
        if(DTOE.getIndBorradoProductosExigidos()!=null &&
           DTOE.getIndBorradoProductosExigidos().booleanValue()) {
           this.borrarProductosExigidos(oidConcursoCreado);        
        }
        
        try {
          if(DTOE.getIndBorradoProductosExcluidos()!=null &&
             DTOE.getIndBorradoProductosExcluidos().booleanValue()) {
            MONConcursoRankingHome mrh = this.getMONConcursoRankingHome();
            mrh.create().borrarProductosExcluidos(oidConcursoCreado);
          }          
        }
        catch (RemoteException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (NamingException ne) {
            UtilidadesLog.error("ERROR ", ne);
            throw new MareException(ne, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        catch (CreateException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }      
        
        if(DTOE.getIndBorradoProductosBonificados()!=null &&
           DTOE.getIndBorradoProductosBonificados().booleanValue()) {
           this.borrarProductosBonificados(oidConcursoCreado);          
        }                       
        //FIN - Agregado por cvalenzu - 8/5/2006        
        
        UtilidadesLog.debug("voy a: this.guardarProductos(DTOE.." + DTOE);
        this.guardarProductos(DTOE, oidConcursoCreado);

        UtilidadesLog.debug("despues de guardarProductos " + DTOE);

        if (DTOE.getIndObligCalificacion().booleanValue()) {
            UtilidadesLog.debug("guardarParametrosCalificacion, con: " + DTOE.getParamCalificacion());
            this.guardarParametrosCalificacion(DTOE.getParamCalificacion(), oidConcursoCreado,
            DTOE.getPlantilla().getOidTipoCalificacion());
        }

        if (DTOE.getIndClasificacionParticipantesCalificacion().booleanValue()) {
            UtilidadesLog.debug("guardarClasificacionParticipantesCalificacion, con: " + DTOE.getCalificacionParticipantes());
            this.guardarClasificacionParticipantesCalificacion(DTOE.getCalificacionParticipantes(), oidConcursoCreado,
                                                               DTOE.getPlantilla().getOidDirigidoA());
        }

        if (DTOE.getIndObligProgramaNuevas().booleanValue()) {
            UtilidadesLog.debug("guardarProgramaNuevas, con: " + DTOE.getProgramaNuevas());
            this.guardarProgramaNuevas(DTOE.getProgramaNuevas(), oidConcursoCreado);
        }

        if (DTOE.getIndObligGerentes().booleanValue()) {
            UtilidadesLog.debug("guardarParametrosGerentes, con: " + DTOE.getParamGerentes());
            this.guardarParametrosGerentes(DTOE.getParamGerentes(), oidConcursoCreado);
        }

        if (DTOE.getIndVariablesVenta().booleanValue()) {
            UtilidadesLog.debug("guardarVariablesVenta, con: " + DTOE.getVariablesVenta());
            this.guardarVariablesVenta(DTOE.getVariablesVenta(), oidConcursoCreado);
        }

        if (DTOE.getIndObligMultinivel().booleanValue()) {
            UtilidadesLog.debug("guardarMultinivel, con: " + DTOE.getMultinivel());
            this.guardarMultinivel(DTOE.getMultinivel(), oidConcursoCreado);
        }

        if (DTOE.getIndVariablesVentaProyectada().booleanValue()) {
            UtilidadesLog.debug("guardarVariablesVentaProyectada, con: " + DTOE.getVariablesVentaProyectada());
            this.guardarVariablesVentaProyectada(DTOE.getVariablesVentaProyectada(), oidConcursoCreado);
        }

        // sapaza -- PER-SiCC-2011-0295 -- 16/06/2011
        if (DTOE.getParamGenerales().getOid() != null)
          actualizarRefrescoConcurso(DTOE.getParamGenerales().getOid());
        
        UtilidadesLog.info("MONConcursoBean.guardarDatosConcurso(DTOConcurso dtoe):Salida");
    }
    
    private void eliminarProdCalificar(Long oidConcurso)
            throws MareException {
       UtilidadesLog.debug("MONConcurso.eliminarProdCalificar(Long oidConcurso)" +
            ":Entrada");            
      try {
          ProductosCalificarLocal productosCL = null;
          ProductosCalificarLocalHome productosCLH = this.getProductosCalificarLocalHome();
  
          Collection colProdACalif = productosCLH.findByConcurso(oidConcurso);
  
          if (!colProdACalif.isEmpty()) {
              Iterator itProdVal = colProdACalif.iterator();
  
              while (itProdVal.hasNext()) {
                  ProductosCalificarLocal registro = (ProductosCalificarLocal) itProdVal.next();
                  productosCLH.remove(registro);
              }
          }  
        
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(sCodigoError));
        } catch (PersistenceException re) {
            UtilidadesLog.error("ERROR ", re);
            sessionContext.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }   
       UtilidadesLog.debug("MONConcurso.eliminarProdCalificar(Long oidConcurso)" +
            ":Salida");            
        
              
    }
      
    private void eliminarProdExcluidosCalif(Long oidConcurso)
            throws MareException {
       UtilidadesLog.debug("MONConcurso.eliminarProdExcluidosCalif(Long oidConcurso)" +
            ":Entrada");
       try {
            ProductosExcluidosCalificacionLocal productosECL = null;
            ProductosExcluidosCalificacionLocalHome productosECLH = this.getProductosExcluidosCalificacionLocalHome();

            Collection prodExclCalif = productosECLH.findByConcurso(oidConcurso);

            //remove de todos los producto Excluidos Calificacion...
            if (!prodExclCalif.isEmpty()) {
                Iterator itProdVal = prodExclCalif.iterator();

                while (itProdVal.hasNext()) {
                    ProductosExcluidosCalificacionLocal registro = (ProductosExcluidosCalificacionLocal) itProdVal.next();
                    productosECLH.remove(registro);
                }
            }        
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(sCodigoError));
        } catch (PersistenceException re) {
            UtilidadesLog.error("ERROR ", re);
            sessionContext.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }    
        
       UtilidadesLog.debug("MONConcurso.eliminarProdExcluidosCalif(Long oidConcurso)" +
            ":Salida");        
              
    }
    
    private void borrarProductosExigidos(Long oidConcurso)
       throws MareException {           
       UtilidadesLog.debug("MONConcurso.borrarProductosExigidos(Long oidConcurso) - Entrada");      

        try {        
            //Obtengo interface local home de productos
            ProductosLocalHome productosLH = this.getProductosLocalHome();            
            //Obtengo interface local home de productos exigidos
            ProductosExigidosLocalHome pelh = this.getProductosExigidosLocalHome();            
            //Busco por oid de concurso en la tabla de productos
            ProductosLocal productosL = productosLH.findByUK(oidConcurso);            
            //Busco por oid de producto en productos exigidos
            Collection prodExigidos = pelh.findByProducto(productosL.getOid());            
            //Si la collection es distinta de null
            if (prodExigidos != null) {
                //Se recorre la collection
                for (Iterator itProdExigi = prodExigidos.iterator(); itProdExigi.hasNext();) {
                    //Me posiciono en el registro de la tabla de productos exigidos
                    ProductosExigidosLocal registro = (ProductosExigidosLocal) itProdExigi.next();
                    //Se borra el registro
                    pelh.remove(registro);
                }
            }
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(sCodigoError));
        } catch (PersistenceException re) {
            UtilidadesLog.error("ERROR ", re);
            sessionContext.setRollbackOnly();
            throw new MareException(re, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }    
        
        UtilidadesLog.debug("MONConcurso.borrarProductosExigidos(Long oidConcurso) - Salida");        
    }
    
    private void borrarProductosBonificados(Long oidConcurso)
       throws MareException {           
       UtilidadesLog.debug("MONConcurso.borrarProductosBonificados(Long oidConcurso) - Entrada");      

        try {        
            //Obtengo interface local home de productos
            ProductosLocalHome productosLH = this.getProductosLocalHome();            
            //Obtengo interface local home de productos bonificados
            ProductosBonificadosLocalHome pblh = this.getProductosBonificadosLocalHome();
            //Busco por oid de concurso en la tabla de productos
            ProductosLocal productosL = productosLH.findByUK(oidConcurso);            
            //Busco por oid de producto en productos bonificados
            Collection prodBonificados = pblh.findByProducto(productosL.getOid());            
            //Si la collection es distinta de null
            if (prodBonificados != null) {
                //Se recorre la collection
                for (Iterator itProdBoni = prodBonificados.iterator(); itProdBoni.hasNext();) {
                    //Me posiciono en el registro de la tabla de productos bonificados
                    ProductosBonificadosLocal registro = (ProductosBonificadosLocal) itProdBoni.next();
                    //Se borra el registro
                    pblh.remove(registro);
                }
            }
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(sCodigoError));
        } catch (PersistenceException re) {
            UtilidadesLog.error("ERROR ", re);
            sessionContext.setRollbackOnly();
            throw new MareException(re, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }    
        
        UtilidadesLog.debug("MONConcurso.borrarProductosBonificados(Long oidConcurso) - Salida");        
    }      

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       20/05/2005
           * @version     1.00
           * @autor       Sergio C. Saavedra
           */
    public Long guardarParametrosGeneralesConcurso(DTOParametrosGeneralesConcurso DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarParametrosGeneralesConcurso(DTOParametrosGeneralesConcurso DTOE):Entrada");
        UtilidadesLog.debug("dentro de guardarParametrosGeneralesConcurso, recibo : " + DTOE);

        Long oidConcRet = null;

        UtilidadesLog.debug("DTOE.getOid()" + DTOE.getOid());

        if (DTOE.getOid() != null) {
            try {
                ConcursoParametrosGeneralesLocalHome concursoParametrosGeneralesLH = null;
                ConcursoParametrosGeneralesLocal concursoParametrosGeneralesL = null;
                AccesoConcursoLocalHome accesoConcursoLH = null;
                AccesoConcursoLocal accesoConcursoL = null;
                accesoConcursoLH = this.getAccesoConcursoLocalHome();

                concursoParametrosGeneralesLH = this.getConcursoParametrosGeneralesLocalHome();
                concursoParametrosGeneralesL = concursoParametrosGeneralesLH.findByPrimaryKey(DTOE.getOid());
                oidConcRet = DTOE.getOid();

                PeriodoLocalHome periodoLH = this.getPeriodoLocalHome();
                PeriodoLocal periodoLDesde = null;
                PeriodoLocal periodoLHasta = null;

                UtilidadesLog.debug("finder sobre: ConcursoParametrosGenerales, retorna: " + concursoParametrosGeneralesL);
                UtilidadesLog.debug("oid != null, es: " + DTOE.getOid());

                //set de los campos de: ConcursoParametrosGenerales
                concursoParametrosGeneralesL.setNombre(DTOE.getNombreConcurso());

                concursoParametrosGeneralesL.setDevoluciones(DTOE.getIndDevoluciones());
                concursoParametrosGeneralesL.setAnulaciones(DTOE.getIndAnulaciones());
                concursoParametrosGeneralesL.setFaltantesNoAnunciados(DTOE.getIndFaltantesNoAnunciados());
                concursoParametrosGeneralesL.setExpresionPuntaje(DTOE.getExpresionPuntaje());
                concursoParametrosGeneralesL.setPruebas(DTOE.getIndPruebas());
                concursoParametrosGeneralesL.setObservaciones(DTOE.getObservaciones());
                concursoParametrosGeneralesL.setActivo(DTOE.getIndActivo());
                concursoParametrosGeneralesL.setCanal(DTOE.getOidCanal());
                concursoParametrosGeneralesL.setDirigidoA(DTOE.getOidDirigidoA());
                concursoParametrosGeneralesL.setMarca(DTOE.getOidMarca());
                concursoParametrosGeneralesL.setPais(DTOE.getOidPais());
                
                if (DTOE.getIndDuplaCyzone() == null) {
                    DTOE.setIndDuplaCyzone(Boolean.FALSE);
                }
                
                //jrivas 31/1/2007 Cambio Dupla Cyzone
                concursoParametrosGeneralesL.setIndDuplaCyzone(DTOE.getIndDuplaCyzone());
                //agregado por cvalenzu - 4/7/2007 - fac-003
                concursoParametrosGeneralesL.setTipoPrograma(DTOE.getOidTipoPrograma());
                
                // vbongiov -- Cambio 20080809 -- 7/04/2009
                if (DTOE.getIndNoGeneraPunt() == null) {
                    DTOE.setIndNoGeneraPunt(Boolean.FALSE);
                }
                
                 // vbongiov -- Cambio 20090930 -- 16/07/2009
                concursoParametrosGeneralesL.setOidClasificacionConcurso(DTOE.getOidClasificacionConcurso());
                
                // sapaza -- PER-SiCC-2011-0042 -- 18/01/2011
                concursoParametrosGeneralesL.setOidTipoOfertaConcurso(DTOE.getOidTipoOfertaConcurso());
                
                // sapaza -- PER-SICC-2012-0082 -- 16/05/2012
                concursoParametrosGeneralesL.setIndMultiMarca(DTOE.getIndMultiMarca());
                concursoParametrosGeneralesL.setPuntosAbonar(DTOE.getPuntosAbonar());
                
                concursoParametrosGeneralesL.setIndNoGeneraPunt(DTOE.getIndNoGeneraPunt());

                try {
                    periodoLDesde = periodoLH.findByPrimaryKey(DTOE.getOidPeriodoDesde());
                    periodoLHasta = periodoLH.findByPrimaryKey(DTOE.getOidPeriodoHasta());
                } catch (NoResultException nre) {
                    //throw new MareException(fe, UtilidadesError.
                    //                            armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                 } catch (PersistenceException ce) {
                     UtilidadesLog.error("ERROR ", ce);
                     throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }

                if (periodoLHasta != null) {
                    if ((periodoLDesde.getFechainicio().getTime() <= periodoLHasta.getFechainicio().getTime()) &&
                            (periodoLDesde.getFechaFin().getTime() <= periodoLHasta.getFechaFin().getTime())) {
                        concursoParametrosGeneralesL.setPeriodoDesde(periodoLDesde.getOid());
                        concursoParametrosGeneralesL.setPeriodoHasta(periodoLHasta.getOid());
                    } else {
                        if (!DTOE.getIndRanking().booleanValue()) {
                            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC +
                                                                                                 ErroresDeNegocio.INC_0327));
                        } else {
                            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC +
                                                                                                 ErroresDeNegocio.INC_0331));
                        }
                    }
                } else {
                    concursoParametrosGeneralesL.setPeriodoDesde(periodoLDesde.getOid());
                    concursoParametrosGeneralesL.setPeriodoHasta(periodoLDesde.getOid());
                }

                concursoParametrosGeneralesL.setPlantilla(DTOE.getOidPlantilla());
                concursoParametrosGeneralesL.setTipoConcursoIVR(DTOE.getOidTipoConcursoIVR());

                concursoParametrosGeneralesLH.merge(concursoParametrosGeneralesL);
                
                Collection accesos = accesoConcursoLH.findByConcurso(DTOE.getOid());
                Iterator it = accesos.iterator();

                if (accesos != null) {
                    try {
                        while (it.hasNext()) {
                            accesoConcursoL = (AccesoConcursoLocal) it.next();
                            accesoConcursoLH.remove(accesoConcursoL);
                        }
                    } catch (PersistenceException fe) {
                        UtilidadesLog.error("ERROR ", fe);
                        throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                    }
                }

                if (DTOE.getLstAccesos() != null) {
                    for (int j = 0; j < DTOE.getLstAccesos().size(); j++) {
                        Long acceso = (Long) DTOE.getLstAccesos().get(j);

                        //create sobre AccesoConcurso ..
                        try {
                            // Se cambioa dado que la entidad recibe primero
                            // un oid y luego el acceso.
                            // ----Pcabrera 14/06/2005 ----
                            //accesoConcursoLH.create(acceso, DTOE.getOid());
                            accesoConcursoLH.create(DTOE.getOid(), acceso);
                        } catch (PersistenceException createException) {
                            UtilidadesLog.error("ERROR ", createException);
                            sessionContext.setRollbackOnly();
                            throw new MareException(createException,
                                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }
                    }
                }
            } catch (NoResultException fe) {
                UtilidadesLog.error("ERROR ", fe);
                throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        } else { //nulo insercion

            ConcursoParametrosGeneralesLocalHome concursoParametrosGeneralesLH = null;
            ConcursoParametrosGeneralesLocal concursoParametrosGeneralesL = null;
            AccesoConcursoLocalHome accesoConcursoLH = null;
            AccesoConcursoLocal accesoConcursoL = null;
            DTOE.setIndRanking(Boolean.FALSE);

            try {
                accesoConcursoLH = this.getAccesoConcursoLocalHome();
                concursoParametrosGeneralesLH = this.getConcursoParametrosGeneralesLocalHome();

                Long oid = null;

                if (DTOE.getOidFicticio() != null) {
                    oid = new Long(DTOE.getOidFicticio().longValue());
                    UtilidadesLog.debug("1 : " + oid);
                } else {
                    oid = null;
                }

                oidConcRet = oid;

                String numeroConcurso = obtenerNumeroConcurso();

                PeriodoLocalHome periodoLH = null;
                PeriodoLocal periodoLDesde = null;
                PeriodoLocal periodoLHasta = null;
                periodoLH = this.getPeriodoLocalHome();

                try {
                    periodoLDesde = periodoLH.findByPrimaryKey(DTOE.getOidPeriodoDesde());

                    periodoLHasta = periodoLH.findByPrimaryKey(DTOE.getOidPeriodoHasta());
                } catch (NoResultException nre) {
                    //throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                 } catch (PersistenceException ce) {
                     UtilidadesLog.error("ERROR ", ce);
                     throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }

                Long periodoDesde = null;
                Long periodoHasta = null;

                if (periodoLHasta != null) {
                    if ((periodoLDesde.getFechainicio().getTime() <= periodoLHasta.getFechainicio().getTime()) &&
                            (periodoLDesde.getFechaFin().getTime() <= periodoLHasta.getFechaFin().getTime())) {
                        periodoDesde = periodoLDesde.getOid();
                        periodoHasta = periodoLHasta.getOid();
                    } else {
                        if (!DTOE.getIndRanking().booleanValue()) {
                            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC +
                                                                                                 ErroresDeNegocio.INC_0327));
                        } else {
                            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC +
                                                                                                 ErroresDeNegocio.INC_0331));
                        }
                    }
                } else {
                    periodoDesde = periodoLDesde.getOid();
                    periodoHasta = periodoLDesde.getOid();
                }

                try {
                    if (DTOE.getIndDuplaCyzone() == null) {
                        DTOE.setIndDuplaCyzone(Boolean.FALSE);
                    }

                    concursoParametrosGeneralesL = concursoParametrosGeneralesLH.create(oid, numeroConcurso, ConstantesINC.VERSION_1,
                                                                                        DTOE.getOidPais(), DTOE.getNombreConcurso(), Boolean.FALSE, //NO es ranking
                                                                                        periodoDesde, periodoHasta, DTOE.getOidDirigidoA(),
                                                                                      DTOE.getOidMarca(), DTOE.getOidCanal(), DTOE.getIndDuplaCyzone());
                    oidConcRet = concursoParametrosGeneralesL.getOid();
                    concursoParametrosGeneralesL.setObservaciones(DTOE.getObservaciones());
                    concursoParametrosGeneralesL.setPruebas(DTOE.getIndPruebas());
                    concursoParametrosGeneralesL.setExpresionPuntaje(DTOE.getExpresionPuntaje());
                    concursoParametrosGeneralesL.setFaltantesNoAnunciados(DTOE.getIndFaltantesNoAnunciados());
                    concursoParametrosGeneralesL.setAnulaciones(DTOE.getIndAnulaciones());
                    concursoParametrosGeneralesL.setDevoluciones(DTOE.getIndDevoluciones());
                    concursoParametrosGeneralesL.setPlantilla(DTOE.getOidPlantilla());
                    concursoParametrosGeneralesL.setTipoConcursoIVR(DTOE.getOidTipoConcursoIVR());
                    concursoParametrosGeneralesL.setActivo(DTOE.getIndActivo());
                    //agregado por cvalenzu - 4/7/2007 - fac-003
                    concursoParametrosGeneralesL.setTipoPrograma(DTOE.getOidTipoPrograma());
                    
                     // vbongiov -- Cambio 20090930 -- 16/07/2009
                    concursoParametrosGeneralesL.setOidClasificacionConcurso(DTOE.getOidClasificacionConcurso());
                    
                    // sapaza -- PER-SiCC-2011-0042 -- 18/01/2011
                    concursoParametrosGeneralesL.setOidTipoOfertaConcurso(DTOE.getOidTipoOfertaConcurso());
                    
                    // sapaza -- PER-SICC-2012-0082 -- 16/05/2012
                    concursoParametrosGeneralesL.setIndMultiMarca(DTOE.getIndMultiMarca());
                    concursoParametrosGeneralesL.setPuntosAbonar(DTOE.getPuntosAbonar());
                    
                    // vbongiov -- Cambio 20080809 -- 7/04/2009
                    if (DTOE.getIndNoGeneraPunt() == null) {
                        DTOE.setIndNoGeneraPunt(Boolean.FALSE);
                    }
                    
                    concursoParametrosGeneralesL.setIndNoGeneraPunt(DTOE.getIndNoGeneraPunt());
                    
                    concursoParametrosGeneralesLH.merge(concursoParametrosGeneralesL);
                    
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    sessionContext.setRollbackOnly();
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
                }

                Collection accesos = accesoConcursoLH.findByConcurso(DTOE.getOid());
                Iterator it = accesos.iterator();

                if (accesos != null) {
                    try {
                        while (it.hasNext()) {
                            accesoConcursoL = (AccesoConcursoLocal) it.next();
                            accesoConcursoLH.remove(accesoConcursoL);
                        }
                    } catch (PersistenceException fe) {
                        UtilidadesLog.error("ERROR ", fe);
                        throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                    }
                }

                if (DTOE.getLstAccesos() != null) {
                    accesoConcursoLH = null;
                    accesoConcursoLH = this.getAccesoConcursoLocalHome();

                    for (int j = 0; j < DTOE.getLstAccesos().size(); j++) {
                        Long acceso = (Long) DTOE.getLstAccesos().get(j);

                        //create sobre AccesoConcurso ..
                        try {
                            accesoConcursoLH.create(concursoParametrosGeneralesL.getOid(), acceso);

                            UtilidadesLog.debug("listo " + acceso);
                        } catch (PersistenceException createException) {
                            UtilidadesLog.error("ERROR ", createException);
                            sessionContext.setRollbackOnly();
                            throw new MareException(createException,
                                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }
                    }
                }
            } catch (NoResultException fe) {
                UtilidadesLog.error("ERROR ", fe);
                throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONConcursoBean.guardarParametrosGeneralesConcurso(DTOParametrosGeneralesConcurso DTOE):Salida");
        return oidConcRet;
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       23/05/2005
           * @version     1.00
           * @autor       Sergio C. Saavedra
           */
    public void guardarAmbitosGeograficos(DTOListaAmbitosGeograficos DTOE, Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarAmbitosGeograficos(DTOListaAmbitosGeograficos DTOE, Long oidConcurso):Entrada");
        UtilidadesLog.debug("dentro de guardarAmbitosGeograficos, recibo : " + DTOE + " y oidConcurso: " + oidConcurso);

        try {
            AmbitoGeograficoLocal ambitoGeograficoL = null;
            AmbitoGeograficoLocalHome ambitoGeograficoLH = this.getAmbitoGeograficoLocalHome();

            Collection colAmbGeog = ambitoGeograficoLH.findByConcurso(oidConcurso);
            Iterator it = colAmbGeog.iterator();

            if (colAmbGeog != null) {
                try {
                    while (it.hasNext()) {
                        ambitoGeograficoL = (AmbitoGeograficoLocal) it.next();
                        ambitoGeograficoLH.remove(ambitoGeograficoL);
                    }
                } catch (PersistenceException fe) {
                    UtilidadesLog.error("ERROR ", fe);
                    throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
            }

            if ((DTOE.getAmbitoGeografico() != null) && (DTOE.getAmbitoGeografico().size() > 0)) {
                for (int j = 0; j < DTOE.getAmbitoGeografico().size(); j++) {
                    DTOIncAmbitoGeografico dtoElemLsta = (DTOIncAmbitoGeografico) DTOE.getAmbitoGeografico().get(j);

                    ambitoGeograficoL = ambitoGeograficoLH.create(dtoElemLsta.getOidSubgerencia(), oidConcurso);

                    ambitoGeograficoL.setSeccion(dtoElemLsta.getOidSeccion());
                    ambitoGeograficoL.setTerritorio(dtoElemLsta.getOidTerritorio());
                    ambitoGeograficoL.setZona(dtoElemLsta.getOidZona());
                    ambitoGeograficoL.setRegion(dtoElemLsta.getOidRegion());
                    ambitoGeograficoLH.merge(ambitoGeograficoL);
                }
            }
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException createException) {
            UtilidadesLog.error("ERROR ", createException);
            sessionContext.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONConcursoBean.guardarAmbitosGeograficos(DTOListaAmbitosGeograficos DTOE, Long oidConcurso):Salida");
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       23/05/2005
           * @version     1.00
           * @autor       Sergio C. Saavedra
           */
    public void guardarVersion(DTOParametrosGeneralesConcurso DTOE, Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarVersion(DTOParametrosGeneralesConcurso DTOE, Long oidConcurso):Entrada");
        UtilidadesLog.debug("dentro de guardarVersion, recibo : " + DTOE + " y oidConcurso: " + oidConcurso);

        if (DTOE.getOid() == null) { //insercion
            UtilidadesLog.debug("**** insercion");
            try {
                ConcursoParametrosGeneralesLocalHome concursoParametrosGeneralesLH = null;
                ConcursoParametrosGeneralesLocal concursoParametrosGeneralesL = null;

                concursoParametrosGeneralesLH = this.getConcursoParametrosGeneralesLocalHome();
                concursoParametrosGeneralesL = concursoParametrosGeneralesLH.findByPrimaryKey(oidConcurso);

                VersionesConcursoLocalHome verConcLHome = null;
                verConcLHome = this.getVersionesConcursoLocalHome();

                Long esc2OidEstaConc = null;

                if (DTOE.getIndActivo().booleanValue()) {
                    esc2OidEstaConc = ConstantesINC.OID_ESTADO_ACTIVO;
                } else {
                    esc2OidEstaConc = ConstantesINC.OID_ESTADO_EN_CREACION;
                }

                UtilidadesLog.debug("**** esc2OidEstaConc " + esc2OidEstaConc);
            
                VersionesConcursoLocal vers = verConcLHome.create(concursoParametrosGeneralesL.getVersion(),
                                                    concursoParametrosGeneralesL.getNumeroConcurso(),
                                                    DTOE.getOidPeriodoDesde(), 
                                                    concursoParametrosGeneralesL.getOid(), 
                                                    esc2OidEstaConc,
                                                    ConstantesINC.OID_VIG_CONCU_NO_VIGENTE);
                                                    
                vers.setConcurso(concursoParametrosGeneralesL.getOid());                
                verConcLHome.merge(vers);
                
            } catch (NoResultException fe) {
                UtilidadesLog.error("ERROR ", fe);
                throw new MareException(fe, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException createException) {
                UtilidadesLog.error("ERROR ", createException);
                sessionContext.setRollbackOnly();
                throw new MareException(createException, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        else  { //modificacion
            UtilidadesLog.debug("**** modificacion");
            
            try {
                ConcursoParametrosGeneralesLocalHome concursoParametrosGeneralesLH = null;
                ConcursoParametrosGeneralesLocal concursoParametrosGeneralesL = null;

                concursoParametrosGeneralesLH = this.getConcursoParametrosGeneralesLocalHome();
                concursoParametrosGeneralesL = concursoParametrosGeneralesLH.findByPrimaryKey(oidConcurso);

                VersionesConcursoLocalHome verConcLHome = null;
                VersionesConcursoLocal verConcLocal = null;
                verConcLHome = this.getVersionesConcursoLocalHome();
                
                verConcLocal = verConcLHome.findByConcursoVersion(concursoParametrosGeneralesL.getOid(),
                concursoParametrosGeneralesL.getVersion());

                Long esc2OidEstaConc = null;

                if (DTOE.getIndActivo().booleanValue()) {
                    esc2OidEstaConc = ConstantesINC.OID_ESTADO_ACTIVO;
                } else {
                    esc2OidEstaConc = ConstantesINC.OID_ESTADO_EN_CREACION;
                }

                UtilidadesLog.debug("****  esc2OidEstaConc " + esc2OidEstaConc);
                
                verConcLocal.setEstadoConcurso(esc2OidEstaConc);                
                
                // sapaza -- PER-SiCC-2012-1143 -- 09/01/2013
                verConcLocal.setPeriodoEntradaVigor(DTOE.getOidPeriodoDesde());

                verConcLHome.merge(verConcLocal);
            } catch (NoResultException fe) {
                UtilidadesLog.error("ERROR ", fe);
                throw new MareException(fe, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONConcursoBean.guardarVersion(DTOParametrosGeneralesConcurso DTOE, Long oidConcurso):Salida");
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       5/7/2005
           * @version     1.00
           * @autor       Cristian Valenzuela
           */
    public void guardarObtencionPuntos(DTOObtencionPuntos DTOE, Long oidConcurso)
            throws MareException {

        UtilidadesLog.info("MONConcursoBean.guardarObtencionPuntos(DTOObtencionPuntos DTOE, Long oidConcurso):Entrada");
        UtilidadesLog.debug("********** MONConcurso.guardarObtencionPuntos()");
        UtilidadesLog.debug("********** DTOObtencionPuntos " + DTOE);
        UtilidadesLog.debug("********** oidConcurso " + oidConcurso);

        //MODIFICACION
        if (DTOE.getOidObtencionPuntos() != null) {
            try {
                ObtencionPuntosLocal obtencionPuntosL = null;
                ObtencionPuntosLocalHome obtencionPuntosLH = this.getObtencionPuntosLocalHome();
                obtencionPuntosL = obtencionPuntosLH.findByPrimaryKey(DTOE.getOidObtencionPuntos());

                //VAL_FACT_CONV
                obtencionPuntosL.setFactorConversion(DTOE.getFactorConversion());

                //NUM_PUNT_ASIG             
                obtencionPuntosL.setNumPuntosAsignados(DTOE.getPuntosAsignar());

                //IND_COMU_OBTE    
                if (DTOE.getIndComunicacion().intValue() == 1) {
                    obtencionPuntosL.setIndComuObte(new Boolean(true));
                } else {
                    obtencionPuntosL.setIndComuObte(new Boolean(false));
                }

                //COPA_OID_PARA_GRAL
                obtencionPuntosL.setCopaOidParaGral(oidConcurso);

                //VAL_PUNT_ACUM
                if (DTOE.getIndPuntajeAcumulativo().intValue() == 1) {
                    obtencionPuntosL.setPuntoAcumulado(new Boolean(true));
                } else {
                    obtencionPuntosL.setPuntoAcumulado(new Boolean(false));
                }

                //IND_ACTI
                if (DTOE.getIndActividad().intValue() == 1) {
                    obtencionPuntosL.setIndActi(new Boolean(true));
                } else {
                    obtencionPuntosL.setIndActi(new Boolean(false));
                }

                //IND_CONS
                if (DTOE.getIndConstancia().intValue() == 1) {
                    obtencionPuntosL.setIndConsolidado(new Boolean(true));
                } else {
                    obtencionPuntosL.setIndConsolidado(new Boolean(false));
                }

                // sapaza -- ECU-SiCC-2012-0213 -- 13/02/2013
                obtencionPuntosL.setNumPeriodosSinPedido(DTOE.getNumPeriodosSinPedido());
                
                //MENS_OID_MENS   
                //Cleal - inc 21379
                if(ConstantesINC.IND_ACTIVO.equals(DTOE.getIndComunicacion())){
                    if (DTOE.getMensaje() != null && DTOE.getMensaje().length() > 1) {
                        //if (DTOE.getIndComunicacion().intValue() == 1) {
                            //busqueda en mensajes
                            MensajesLocal msgL = null;
                            MensajesLocalHome msgLH = this.getMensajesLocalHome();
    
                            try {
                                msgL = msgLH.findByUk(DTOE.getOidPais(), DTOE.getMensaje());
                                obtencionPuntosL.setMensaje(msgL.getOid());
                            } catch (NoResultException fe) {
                                UtilidadesLog.error("ERROR ", fe);
                                throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0001));
                            }  catch (PersistenceException ce) {
                                 UtilidadesLog.error("ERROR ", ce);
                                 throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                            }
                        //}
                    } else {
                            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0001));
                    }
                }
                obtencionPuntosLH.merge(obtencionPuntosL);
            } catch (NoResultException fe) {
                UtilidadesLog.error("ERROR ", fe);
                throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        } else { //INSERCION

            try {
                ObtencionPuntosLocal obtencionPuntosL = null;
                ObtencionPuntosLocalHome obtencionPuntosLH = this.getObtencionPuntosLocalHome();

                //Create de la entidad con los campos que no permiten
                //un valor nulo
                Boolean comunic;

                if (DTOE.getIndComunicacion().intValue() == 1) {
                    comunic = new Boolean(true);
                } else {
                    comunic = new Boolean(false);
                }

                obtencionPuntosL = obtencionPuntosLH.create(DTOE.getFactorConversion(), DTOE.getPuntosAsignar(), comunic, oidConcurso);

                //Se setean el resto de los campos
                //VAL_PUNT_ACUM
                if (DTOE.getIndPuntajeAcumulativo().intValue() == 1) {
                    obtencionPuntosL.setPuntoAcumulado(new Boolean(true));
                } else {
                    obtencionPuntosL.setPuntoAcumulado(new Boolean(false));
                }

                //IND_ACTI
                if (DTOE.getIndActividad().intValue() == 1) {
                    obtencionPuntosL.setIndActi(new Boolean(true));
                } else {
                    obtencionPuntosL.setIndActi(new Boolean(false));
                }

                //IND_CONS
                if (DTOE.getIndConstancia().intValue() == 1) {
                    obtencionPuntosL.setIndConsolidado(new Boolean(true));
                } else {
                    obtencionPuntosL.setIndConsolidado(new Boolean(false));
                }
                
                // sapaza -- ECU-SiCC-2012-0213 -- 13/02/2013
                obtencionPuntosL.setNumPeriodosSinPedido(DTOE.getNumPeriodosSinPedido());
                
                //Cleal - inc 21379
                if(ConstantesINC.IND_ACTIVO.equals(DTOE.getIndComunicacion())){
                    
                    if (DTOE.getMensaje() != null && DTOE.getMensaje().length() > 1) {
                        //MENS_OID_MENS           
                       // if (DTOE.getIndComunicacion().intValue() == 1) {
                            MensajesLocal msgL = null;
                            MensajesLocalHome msgLH = this.getMensajesLocalHome();
        
                            try {
                                msgL = msgLH.findByUk(DTOE.getOidPais(), DTOE.getMensaje());
                                obtencionPuntosL.setMensaje(msgL.getOid());
                            } catch (NoResultException fe) {
                                UtilidadesLog.error("ERROR ", fe);
                                throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0001));
                            }  catch (PersistenceException ce) {
                                 UtilidadesLog.error("ERROR ", ce);
                                 throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                            }
                        //}
                    } else{
                            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0001));
                          }
                }
                obtencionPuntosLH.merge(obtencionPuntosL);
            } catch (NoResultException ne) {
                UtilidadesLog.error("ERROR ", ne);
                throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch (PersistenceException createException) {
                UtilidadesLog.error("ERROR ", createException);
                sessionContext.setRollbackOnly();
                throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONConcursoBean.guardarObtencionPuntos(DTOObtencionPuntos DTOE, Long oidConcurso):Salida");
    }


    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:       24/05/2005
     * @version     1.00
     * @autor       Sergio C. Saavedra
     */
    public void guardarEstatusVenta(DTOConcurso DTOE, Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarEstatusVenta(DTOConcurso DTOE, Long oidConcurso):Entrada");
        UtilidadesLog.debug("dentro de guardarEstatusVenta, recibo : " + DTOE + " y oidConcurso: " + oidConcurso);

        //modif. segun inc.: 19370
        if ((DTOE.getParamGenerales().getIndRanking() == null) || (!DTOE.getParamGenerales().getIndRanking().booleanValue())) {
            //modif. segun inc.: 18772 
            if ((DTOE.getPlantilla().getIndFaseCalificacion().booleanValue()) &&
                    (DTOE.getParamGenerales().getOidDirigidoA().longValue() == ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS.longValue())) {
                //Borramos los elementos de la entidad MontoMinimoRangoConsultoras que estén relacionados con el concurso 
                DAOConcurso daoConc = new DAOConcurso();
                ArrayList listaMontoMinimo = daoConc.obtenerMontoMinimoRangoConsultoras(oidConcurso);

                try {
                    MontoMinimoRangoConsultorasLocal montoMinimoRangoConsultorasL = null;
                    MontoMinimoRangoConsultorasLocalHome montoMinimoRangoConsultorasLH = this.getMontoMinimoRangoConsultorasLocalHome();

                    if ((listaMontoMinimo != null) && (listaMontoMinimo.size() > 0)) {
                        Long registro = null;

                        for (int j = 0; j < listaMontoMinimo.size(); j++) {
                            registro = (Long) listaMontoMinimo.get(j);

                            //busco en: MontoMinimoRangoConsultoras ...
                            montoMinimoRangoConsultorasL = montoMinimoRangoConsultorasLH.findByPrimaryKey(registro);
                            montoMinimoRangoConsultorasLH.remove(montoMinimoRangoConsultorasL);
                        }
                    }
                } catch (NoResultException fe) {
                    UtilidadesLog.error("ERROR ", fe);
                    throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                } catch (PersistenceException fe) {
                    UtilidadesLog.error("ERROR ", fe);
                    throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
            }
        }

        //Se borran los registros de la entidad EstatusVenta para ese concurso y se vuelven a crear los nuevos 
        try {
            EstatusVentaLocal evcL = null;
            EstatusVentaLocalHome evcLH = this.getEstatusVentaLocalHome();

            Collection status = evcLH.findByConcurso(oidConcurso);
            EstatusVentaLocal registro = null;

            for (Iterator itStatus = status.iterator(); itStatus.hasNext();) {
                registro = (EstatusVentaLocal) itStatus.next();
                evcLH.remove(registro);
            }

            PeriodoLocalHome periodoLH = this.getPeriodoLocalHome();
            PeriodoLocal periodoLDesde = null;
            PeriodoLocal periodoLHasta = null;
            Long oidPeriodoDesde = null;
            Long oidPeriodoHasta = null;

            if ((DTOE.getEstatusVenta() != null) && (DTOE.getEstatusVenta().getEstatusVenta() != null) &&
                    (DTOE.getEstatusVenta().getEstatusVenta().size() > 0)) {
                for (int j = 0; j < DTOE.getEstatusVenta().getEstatusVenta().size(); j++) {
                    DTOEstatusVenta dtoElemLsta = (DTOEstatusVenta) DTOE.getEstatusVenta().getEstatusVenta().get(j);

                    //busco periodos.....
                    try {
                        periodoLDesde = periodoLH.findByPrimaryKey(dtoElemLsta.getOidPeriodoDesde());
                        periodoLHasta = periodoLH.findByPrimaryKey(dtoElemLsta.getOidPeriodoHasta());
                    } catch (NoResultException nre) {
                        sessionContext.setRollbackOnly();
                         UtilidadesLog.error("ERROR ", nre);
                        throw new MareException(nre,        
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                    } catch (PersistenceException ce) {
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
                    if ((periodoLDesde.getFechainicio().getTime() <= periodoLHasta.getFechainicio().getTime()) &&
                            (periodoLDesde.getFechaFin().getTime() <= periodoLHasta.getFechaFin().getTime())) {
                        oidPeriodoDesde = periodoLDesde.getOid();
                        oidPeriodoHasta = periodoLHasta.getOid();

                    }else{
                        throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC +
                                                                                                 ErroresDeNegocio.INC_0024));
                    }

                    evcL = evcLH.create(oidConcurso, dtoElemLsta.getOidEstatusVentaMae(), oidPeriodoDesde, oidPeriodoHasta);
                }
            }
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException createException) {
            UtilidadesLog.error("ERROR ", createException);
            sessionContext.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } 
        UtilidadesLog.info("MONConcursoBean.guardarEstatusVenta(DTOConcurso DTOE, Long oidConcurso):Salida");
    }


    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:       24/05/2005
     * @version     1.00
     * @autor       Sergio C. Saavedra
     */
    public void guardarMontoVentaRecomendadas(DTOListaMontoVentaRecomendadas DTOE, Long oid)
            throws MareException {
        
        UtilidadesLog.info("MONConcursoBean.guardarMontoVentaRecomendadas(DTOListaMontoVentaRecomendadas DTOE, Long oid):Entrada");
        UtilidadesLog.debug("dentro de guardarMontoVentaRecomendadas, recibo : " + DTOE + " y oidConcurso: " + oid);

        try {
            MontoVentaRecomendadasLocal mvrL = null;
            MontoVentaRecomendadasLocalHome mvrLH = this.getMontoVentaRecomendadasLocalHome();

            Collection colMVR = mvrLH.findByConcurso(oid);
            ArrayList arrayMVR = DTOE.getMontosVenta();
            DTOMontoVentaRecomendadas registro = new DTOMontoVentaRecomendadas();

            //borro
            for (Iterator itMVR = colMVR.iterator(); itMVR.hasNext();) {
                MontoVentaRecomendadasLocal registros = (MontoVentaRecomendadasLocal) itMVR.next();
                mvrLH.remove(registros);
            }

            //creo
            for (int j = 0; j < arrayMVR.size(); j++) {
                registro = (DTOMontoVentaRecomendadas) arrayMVR.get(j);
                mvrL = mvrLH.create(oid, registro.getOidTipoMontoVenta());
                mvrL.setCantidadMontoVenta((registro.getCantidad()!=null)?new BigDecimal(registro.getCantidad().toString()):null);
                mvrLH.merge(mvrL);
            }
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException re) {
            UtilidadesLog.error("ERROR ", re);
            sessionContext.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
        UtilidadesLog.info("MONConcursoBean.guardarMontoVentaRecomendadas(DTOListaMontoVentaRecomendadas DTOE, Long oid):Salida");
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       24/05/2005
           * @version     1.00
           * @autor       Sergio C. Saavedra
           */
    public void guardarClasificacionParticipantes(DTOClasificacionParticipantes DTOE, Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarClasificacionParticipantes(DTOClasificacionParticipantes DTOE, Long oidConcurso):Entrada");
        UtilidadesLog.debug("dentro de guardarClasificacionParticipantes, recibo : " + DTOE + " y oidConcurso: " + oidConcurso);

        try {
            ClasificacionParticipantesConcursoLocal ClasificacionParticipantesConcursoL = null;
            ClasificacionParticipantesConcursoLocalHome clasificacionParticipantesConcursoLH = this.getClasificacionParticipantesConcursoLocalHome();
            Collection participantesConsultoras = clasificacionParticipantesConcursoLH.findByConcurso(oidConcurso);

            ArrayList montoVenta = DTOE.getLstClasificacionParticipantes();

            //Modificado por Cristian Valenzuela 29/6/2005
            DTOClasificacion registro = new DTOClasificacion();

            //borro
            for (Iterator itPC = participantesConsultoras.iterator(); itPC.hasNext();) {
                ClasificacionParticipantesConcursoLocal registros = (ClasificacionParticipantesConcursoLocal) itPC.next();
                clasificacionParticipantesConcursoLH.remove(registros);
            }

            if (montoVenta != null) {
                //creo
                for (int j = 0; j < montoVenta.size(); j++) {
                    //Modificado por Cristian Valenzuela 29/6/2005
                    registro = (DTOClasificacion) montoVenta.get(j);

                    //Modificado por Cristian Valenzuela 29/6/2005
                    ClasificacionParticipantesConcursoL = clasificacionParticipantesConcursoLH.create(oidConcurso, registro.getOidParticipante());
                }
            }
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException re) {
            UtilidadesLog.error("ERROR ", re);
            sessionContext.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
        UtilidadesLog.info("MONConcursoBean.guardarClasificacionParticipantes(DTOClasificacionParticipantes DTOE, Long oidConcurso):Salida");
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       24/05/2005
           * @version     1.00
           * @autor       Sergio C. Saavedra
           */
    public void guardarParametrosConsultoras(DTOParametrosConsultoras DTOE, Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarParametrosConsultoras(DTOParametrosConsultoras DTOE, Long oidConcurso):Entrada");
        UtilidadesLog.debug("********* MONConcursoBean.guardarParametrosConsultoras()");
        UtilidadesLog.debug("********* DTOParametrosConsultoras " + DTOE);
        UtilidadesLog.debug("********* oidConcurso " + oidConcurso);

        ConcursoParametrosGeneralesLocalHome concursoParametrosGeneralesLH = null;
        ConcursoParametrosGeneralesLocal concursoParametrosGeneralesL = null;

        ConcursoParametrosConsultorasLocalHome concursoParametrosConsultorasLH = null;
        ConcursoParametrosConsultorasLocal concursoParametrosConsultorasL = null;

        try {
            concursoParametrosGeneralesLH = this.getConcursoParametrosGeneralesLocalHome();
            concursoParametrosGeneralesL = concursoParametrosGeneralesLH.findByPrimaryKey(oidConcurso);

            concursoParametrosConsultorasLH = this.getConcursoParametrosConsultorasLocalHome();

            concursoParametrosGeneralesL.setBaseCalculo(DTOE.getOidBaseCalculo());
            concursoParametrosGeneralesL.setTipoExigencia(DTOE.getOidEfectividad());
            concursoParametrosGeneralesLH.merge(concursoParametrosGeneralesL);

            if (DTOE.getOidParamConsultoras() != null) {
                UtilidadesLog.debug("********* Modificacion");
                concursoParametrosConsultorasL = concursoParametrosConsultorasLH.findByPrimaryKey(DTOE.getOidParamConsultoras());

                if (DTOE.getMontoMinimoPedido() != null) {
                    concursoParametrosConsultorasL.setMontoMinimoPedido(new BigDecimal(DTOE.getMontoMinimoPedido().toString()));
                }

                concursoParametrosConsultorasL.setUnidadesMinimasPedido(DTOE.getUnidadesMinimasPedido());
                concursoParametrosConsultorasL.setReingresoPierdePuntaje(DTOE.getIndReingresosPierdenPuntaje());
                concursoParametrosConsultorasL.setRecomendacionEfectiva(DTOE.getIndRecomendacionEfectiva());
                concursoParametrosConsultorasL.setPeriodoInicialEvaluacion(DTOE.getOidPeriodoInicialEvaluacion());
                concursoParametrosConsultorasL.setPeriodosEvaluacion(DTOE.getNroPeriodosEvaluar());

                if (DTOE.getNroMinimoPedidos() != null) {
                    concursoParametrosConsultorasL.setNumeroMinimoPedidos(new Integer(DTOE.getNroMinimoPedidos().toString()));
                }

                concursoParametrosConsultorasL.setNumeroMinimoPedidosRecomendada(DTOE.getNroMinimoPedidosRecomendada());
                // vbongiov -- 17/03/2008 -- Cambio RI 20080535
                concursoParametrosConsultorasL.setPremioCampEfect(DTOE.getIndPremioCampEfect());
                
                // vbongiov -- Cambio 20080580 -- 13/8/2008
                concursoParametrosConsultorasL.setGenerarPuntajeARecomendadas(DTOE.getIndGenerarPuntajeARecomendadas());
                concursoParametrosConsultorasL.setOidConcursoPuntajeRecomendada(DTOE.getOidConcursoPuntajeRecomendada());
                
                UtilidadesLog.debug("concursoParametrosConsultorasL.getPremioCampEfect(): " + concursoParametrosConsultorasL.getPremioCampEfect());
                
                concursoParametrosConsultorasL.setConcurso(oidConcurso);
                concursoParametrosConsultorasL.setTipoVenta(DTOE.getOidTipoVenta());
                concursoParametrosConsultorasLH.merge(concursoParametrosConsultorasL);
            } else {
                UtilidadesLog.debug("********* Insercion");
                concursoParametrosConsultorasL = concursoParametrosConsultorasLH.create(oidConcurso);
                concursoParametrosConsultorasL.setTipoVenta(DTOE.getOidTipoVenta());

                if (DTOE.getMontoMinimoPedido() != null) {
                    concursoParametrosConsultorasL.setMontoMinimoPedido(new BigDecimal(DTOE.getMontoMinimoPedido().toString()));
                }

                concursoParametrosConsultorasL.setUnidadesMinimasPedido(DTOE.getUnidadesMinimasPedido());
                concursoParametrosConsultorasL.setReingresoPierdePuntaje(DTOE.getIndReingresosPierdenPuntaje());
                concursoParametrosConsultorasL.setRecomendacionEfectiva(DTOE.getIndRecomendacionEfectiva());
                concursoParametrosConsultorasL.setPeriodoInicialEvaluacion(DTOE.getOidPeriodoInicialEvaluacion());
                concursoParametrosConsultorasL.setPeriodosEvaluacion(DTOE.getNroPeriodosEvaluar());

                if (DTOE.getNroMinimoPedidos() != null) {
                    concursoParametrosConsultorasL.setNumeroMinimoPedidos(new Integer(DTOE.getNroMinimoPedidos().toString()));
                }

                concursoParametrosConsultorasL.setNumeroMinimoPedidosRecomendada(DTOE.getNroMinimoPedidosRecomendada());
                
                 // vbongiov -- 17/03/2008 -- Cambio RI 20080535
                concursoParametrosConsultorasL.setPremioCampEfect(DTOE.getIndPremioCampEfect());
                
                // vbongiov -- Cambio 20080580 -- 13/8/2008
                concursoParametrosConsultorasL.setGenerarPuntajeARecomendadas(DTOE.getIndGenerarPuntajeARecomendadas());
                concursoParametrosConsultorasL.setOidConcursoPuntajeRecomendada(DTOE.getOidConcursoPuntajeRecomendada());
                
                concursoParametrosConsultorasLH.merge(concursoParametrosConsultorasL);
                
            }
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException createException) {
            UtilidadesLog.error("ERROR ", createException);
            sessionContext.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONConcursoBean.guardarParametrosConsultoras(DTOParametrosConsultoras DTOE, Long oidConcurso):Salida");
    }


    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:       24/05/2005
     * @version     1.00
     * @autor       Sergio C. Saavedra
     * Modificado:  Cristian Valenzuela
     * Fecha:       11/07/2006
     * Incidencia:  DBLG500000743
     * 
     * Cambios:     sapaza -- PER-SiCC-2010-0210 -- 23/04/2010, se agrego el metodo setPeriodoDespachoInicio 
     * 
     *              sapaza -- PER-SiCC-2011-0857 -- 23/01/2012, se agrego el metodo setSinPremioPorDefecto 
     * 
     */
    public void guardarParametrosPremiacion(DTOParametrosGeneralesPremiacion DTOE, Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarParametrosPremiacion(DTOParametrosGeneralesPremiacion DTOE, Long oidConcurso):Entrada");
        try {
            UtilidadesLog.debug("dentro de guardarParametrosPremiacion, recibo : " + DTOE + " y oidConcurso: " + oidConcurso);

            if (DTOE.getOidParamGralesPremiacion() != null) { //modificacion

                ParametrosGeneralesPremiacionLocal parametrosGeneralesPremiacionL = null;
                ParametrosGeneralesPremiacionLocalHome parametrosGeneralesPremiacionLH = this.getParametrosGeneralesPremiacionLocalHome();

                parametrosGeneralesPremiacionL = parametrosGeneralesPremiacionLH.findByPrimaryKey(DTOE.getOidParamGralesPremiacion());

                parametrosGeneralesPremiacionL.setNumeroNiveles(DTOE.getNroNiveles());
                parametrosGeneralesPremiacionL.setPremiosAcumulativosNiveles(DTOE.getIndPremiosAcumulativosNiveles());
                parametrosGeneralesPremiacionL.setNivelesRotativos(DTOE.getIndNivelesRotativos());
                parametrosGeneralesPremiacionL.setNumeroRotaciones(DTOE.getNroRotaciones());
                parametrosGeneralesPremiacionL.setAccesoNivelSuperior(DTOE.getIndAccesoNivelPremioSuperior());
                parametrosGeneralesPremiacionL.setPremiosElectivos(DTOE.getIndPremiosElectivos());
                parametrosGeneralesPremiacionL.setNumeroPeriodos(DTOE.getNroPeriodosObtencion());
                parametrosGeneralesPremiacionL.setComunicacion(DTOE.getIndComunicacion());
                parametrosGeneralesPremiacionL.setConcurso(oidConcurso);

                if (DTOE.getIndComunicacion().booleanValue()) {
                    //busqueda en mensajes
                    MensajesLocal msgL = null;
                    MensajesLocalHome msgLH = this.getMensajesLocalHome();

                    if (DTOE.getMensaje() != null && DTOE.getMensaje().length() > 1) {
                        try {
                            msgL = msgLH.findByUk(DTOE.getOidPais(), DTOE.getMensaje());
                            parametrosGeneralesPremiacionL.setMensaje(msgL.getOid());
                        } catch (NoResultException fe) {
                            UtilidadesLog.error("ERROR ", fe);
                            throw new MareException(null, null,
                                                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0001));
                        }  catch (PersistenceException ce) {
                             UtilidadesLog.error("ERROR ", ce);
                             throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }
                    }
                }

                parametrosGeneralesPremiacionL.setPeriodoDespachoExigido(DTOE.getIndPeriodoDespacho());
                //if (DTOE.getIndPeriodoDespacho() != null && !(DTOE.getIndPeriodoDespacho().booleanValue())) {
                if (DTOE.getIndPeriodoDespacho() != null && DTOE.getIndPeriodoDespacho().booleanValue() ) {
                    parametrosGeneralesPremiacionL.setPeriodoDespacho(DTOE.getOidPeriodo());
                    parametrosGeneralesPremiacionL.setPeriodoDespachoInicio(DTOE.getOidPeriodoInicio());
                } else {
                    parametrosGeneralesPremiacionL.setPeriodoDespacho(null);
                    parametrosGeneralesPremiacionL.setPeriodoDespachoInicio(null);
                }
                parametrosGeneralesPremiacionL.setTipoEleccion(DTOE.getOidTipoEleccion());
                parametrosGeneralesPremiacionL.setTipoPremiacion(DTOE.getOidTipoPremiacion());
                parametrosGeneralesPremiacionL.setHastaNivel(DTOE.getHastaNivel());
                
                // sapaza -- PER-SiCC-2011-0857 -- 23/01/2012
                parametrosGeneralesPremiacionL.setSinPremioPorDefecto(DTOE.getIndSinPremioPorDefecto());
                
                parametrosGeneralesPremiacionLH.merge(parametrosGeneralesPremiacionL);
            } else { //insercion

                ParametrosGeneralesPremiacionLocal parametrosGeneralesPremiacionL = null;
                ParametrosGeneralesPremiacionLocalHome parametrosGeneralesPremiacionLH = this.getParametrosGeneralesPremiacionLocalHome();

                parametrosGeneralesPremiacionL = parametrosGeneralesPremiacionLH.create(DTOE.getNroNiveles(), DTOE.getIndComunicacion(), oidConcurso);

                //create(Integer numNive, Boolean indAcceNiveSupe, Boolean indComu, Long tprmOidTipoPion, Long copaOidParaGral, Date fechaUltActu                                                                                      
                parametrosGeneralesPremiacionL.setAccesoNivelSuperior(DTOE.getIndAccesoNivelPremioSuperior());
                parametrosGeneralesPremiacionL.setTipoPremiacion(DTOE.getOidTipoPremiacion());
                parametrosGeneralesPremiacionL.setPremiosAcumulativosNiveles(DTOE.getIndPremiosAcumulativosNiveles());
                parametrosGeneralesPremiacionL.setNivelesRotativos(DTOE.getIndNivelesRotativos());
                parametrosGeneralesPremiacionL.setNumeroRotaciones(DTOE.getNroRotaciones());
                parametrosGeneralesPremiacionL.setPremiosElectivos(DTOE.getIndPremiosElectivos());
                parametrosGeneralesPremiacionL.setNumeroPeriodos(DTOE.getNroPeriodosObtencion());

                //create(Integer numNive, Boolean indAcceNiveSupe, Boolean indComu, 
                //Long tprmOidTipoPion, Long copaOidParaGral)
                //busqueda en mensajes
                if (DTOE.getIndComunicacion().booleanValue()) {
                    MensajesLocal msgL = null;
                    MensajesLocalHome msgLH = this.getMensajesLocalHome();

                    if (DTOE.getMensaje() != null && DTOE.getMensaje().length() > 1) {
                        try {
                            msgL = msgLH.findByUk(DTOE.getOidPais(), DTOE.getMensaje());
                            parametrosGeneralesPremiacionL.setMensaje(msgL.getOid());
                        } catch (NoResultException fe) {
                            UtilidadesLog.error("ERROR ", fe);
                            throw new MareException(null, null,
                                                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0001));
                        }  catch (PersistenceException ce) {
                             UtilidadesLog.error("ERROR ", ce);
                             throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }
                    }
                }

                parametrosGeneralesPremiacionL.setPeriodoDespachoExigido(DTOE.getIndPeriodoDespacho());
                //if (DTOE.getIndPeriodoDespacho() != null && !(DTOE.getIndPeriodoDespacho().booleanValue())) {
                if (DTOE.getIndPeriodoDespacho() != null && DTOE.getIndPeriodoDespacho().booleanValue() ) {
                    parametrosGeneralesPremiacionL.setPeriodoDespacho(DTOE.getOidPeriodo());
                    parametrosGeneralesPremiacionL.setPeriodoDespachoInicio(DTOE.getOidPeriodoInicio());
                } else {
                    parametrosGeneralesPremiacionL.setPeriodoDespacho(null);
                    parametrosGeneralesPremiacionL.setPeriodoDespachoInicio(null);
                }
                parametrosGeneralesPremiacionL.setTipoEleccion(DTOE.getOidTipoEleccion());
                parametrosGeneralesPremiacionL.setHastaNivel(DTOE.getHastaNivel());
                
                // sapaza -- PER-SiCC-2011-0857 -- 23/01/2012
                parametrosGeneralesPremiacionL.setSinPremioPorDefecto(DTOE.getIndSinPremioPorDefecto());
                
                parametrosGeneralesPremiacionLH.merge(parametrosGeneralesPremiacionL);
            }
        } catch (PersistenceException createException) {
            UtilidadesLog.error("ERROR ", createException);
            sessionContext.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONConcursoBean.guardarParametrosPremiacion(DTOParametrosGeneralesPremiacion DTOE, Long oidConcurso):Salida");
    }

    /**
     * @author: ssantana, 26/5/2005
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida
     * @param DTOBelcorp DTOE
     */
    public DTOSalida obtenerTipoMontoVentaRecomendada(DTOBelcorp DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerTipoMontoVentaRecomendada(DTOBelcorp DTOE):Entrada");
        UtilidadesLog.debug("Entrando a MONConcurso.obtenerTipoMontoVentaRecomendada");

        DAOConcurso daoConcurso = new DAOConcurso();

        DTOSalida dtoSalida = daoConcurso.obtenerTipoMontoVentaRecomendada(DTOE);
        UtilidadesLog.info("MONConcursoBean.obtenerTipoMontoVentaRecomendada(DTOBelcorp DTOE):Salida");
        return dtoSalida;
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       26/05/2005
           * @version     1.00
           * @autor       Sergio C. Saavedra
           */
    public void guardarRequisitosPremiacion(DTORequisitosPremiacion DTOE, DTOCursosExigidosPremiacion lstCursosExigidos, Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarRequisitosPremiacion(DTORequisitosPremiacion DTOE, DTOCursosExigidosPremiacion lstCursosExigidos, Long oidConcurso):Salida");
        try {
            UtilidadesLog.debug("dentro de guardarRequisitosPremiacion, recibo : " + DTOE + ", concurso: " + oidConcurso);

            //inc 20004
            Boolean asistenciaCurso = Boolean.FALSE;
            if ((lstCursosExigidos != null) && !lstCursosExigidos.getLstCursosExigidosPremiacion().isEmpty()) {
                asistenciaCurso = Boolean.TRUE;
            }

            if (DTOE.getOidRequisitosPremiacion() != null) { //modif.

                RequisitosPremiacionLocal requisitosPremiacionL = null;
                RequisitosPremiacionLocalHome requisitosPremiacionLH = this.getRequisitosPremiacionLocalHome();

                requisitosPremiacionL = requisitosPremiacionLH.findByPrimaryKey(DTOE.getOidRequisitosPremiacion());

                requisitosPremiacionL.setMontoMinimoConcurso(new BigDecimal((DTOE.getMontoMinimoConcurso() != null)
                                                                            ? DTOE.getMontoMinimoConcurso().toString() : new String("0")));
                requisitosPremiacionL.setNumeroPedidos(DTOE.getNumeroPedidos());
                requisitosPremiacionL.setCuotaIngreso(DTOE.getCuotaMinimaIngreso());
                requisitosPremiacionL.setPedidoEnPeriodo(DTOE.getIndPasarPedidoPeriodoPremiacion());
                requisitosPremiacionL.setMontoMinimoPedido(new BigDecimal((DTOE.getMontoMinimoPedido() != null)
                                                                          ? DTOE.getMontoMinimoPedido().toString() : new String("0")));
                requisitosPremiacionL.setPagoATiempo(DTOE.getIndPagoTiempo());
                requisitosPremiacionL.setDiasGracia(DTOE.getDiasGracia());
                requisitosPremiacionL.setConcurso(oidConcurso);

                //jrivas 20/7/2005
                //inc 20004                
                requisitosPremiacionL.setAsistenciaCurso(asistenciaCurso);
                //Agregado por cambio 20090929
                // vbongiov -- cambio 20090929 -- 9/11/2009
                if(DTOE.getOidValiDeuda() != null){
                    requisitosPremiacionL.setOidValidaDeuda(DTOE.getOidValiDeuda());
                } else { 
                    requisitosPremiacionL.setOidValidaDeuda(null);
                }
                
                if(DTOE.getNumeroPerioEspera() != null){
                    requisitosPremiacionL.setNumPerioEspe(DTOE.getNumeroPerioEspera());
                } else { 
                    requisitosPremiacionL.setNumPerioEspe(null);
                }                
                
                if(DTOE.getOidPeriodoMax() != null){
                    requisitosPremiacionL.setPeriodoMaxi(DTOE.getOidPeriodoMax());
                } else { 
                    requisitosPremiacionL.setPeriodoMaxi(null);
                }
                
                
                PeriodoLocalHome periodoLH = null;
                PeriodoLocal periodoLDesde = null;
                PeriodoLocal periodoLHasta = null;
                periodoLH = this.getPeriodoLocalHome();

                try {
                    if(DTOE.getOidPeriodoDesde()!=null){
                        periodoLDesde = periodoLH.findByPrimaryKey(DTOE.getOidPeriodoDesde());
                    }
                    
                    if(DTOE.getOidPeriodoHasta()!=null){
                        periodoLHasta = periodoLH.findByPrimaryKey(DTOE.getOidPeriodoHasta());
                    }
                } catch (NoResultException nre) {
                    //throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                 } catch (PersistenceException ce) {
                     UtilidadesLog.error("ERROR ", ce);
                     throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                } 

                if ((periodoLDesde != null) && (periodoLHasta != null)) {
                    if ((periodoLDesde.getFechainicio().getTime() <= periodoLHasta.getFechainicio().getTime()) &&
                            (periodoLDesde.getFechaFin().getTime() <= periodoLHasta.getFechaFin().getTime())) {
                        requisitosPremiacionL.setPeriodoDesde(periodoLDesde.getOid());
                        requisitosPremiacionL.setPeriodoHasta(periodoLHasta.getOid());
                    } else {
                        throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC + ErroresDeNegocio.INC_0336));
                    }
                } else {
                    requisitosPremiacionL.setPeriodoDesde(DTOE.getOidPeriodoDesde());
                    requisitosPremiacionL.setPeriodoHasta(DTOE.getOidPeriodoHasta());
                }
                requisitosPremiacionLH.merge(requisitosPremiacionL);
            } else {
                RequisitosPremiacionLocal requisitosPremiacionL = null;
                RequisitosPremiacionLocalHome requisitosPremiacionLH = this.getRequisitosPremiacionLocalHome();

                requisitosPremiacionL = requisitosPremiacionLH.create(DTOE.getIndPasarPedidoPeriodoPremiacion(), DTOE.getIndPagoTiempo(), oidConcurso);
                requisitosPremiacionL.setMontoMinimoConcurso(new BigDecimal((DTOE.getMontoMinimoConcurso() != null)
                                                                            ? DTOE.getMontoMinimoConcurso().toString() : new String("0")));
                requisitosPremiacionL.setNumeroPedidos(DTOE.getNumeroPedidos());
                requisitosPremiacionL.setCuotaIngreso(DTOE.getCuotaMinimaIngreso());
                requisitosPremiacionL.setMontoMinimoPedido(new BigDecimal((DTOE.getMontoMinimoPedido() != null)
                                                                          ? DTOE.getMontoMinimoPedido().toString() : new String("0")));
                requisitosPremiacionL.setDiasGracia(DTOE.getDiasGracia());

                //jrivas 20/7/2005
                //inc 20004
                requisitosPremiacionL.setAsistenciaCurso(asistenciaCurso);
                //Agregado por cambio 20090929
                if(DTOE.getOidValiDeuda() != null){
                    requisitosPremiacionL.setOidValidaDeuda(DTOE.getOidValiDeuda());
                }
                if(DTOE.getNumeroPerioEspera() != null){
                    requisitosPremiacionL.setNumPerioEspe(DTOE.getNumeroPerioEspera());
                }
                if(DTOE.getOidPeriodoMax() != null){
                    requisitosPremiacionL.setPeriodoMaxi(DTOE.getOidPeriodoMax());
                }

                PeriodoLocalHome periodoLH = null;
                PeriodoLocal periodoLDesde = null;
                PeriodoLocal periodoLHasta = null;
                periodoLH = this.getPeriodoLocalHome();

                try {
                    if(DTOE.getOidPeriodoDesde()!=null){
                        periodoLDesde = periodoLH.findByPrimaryKey(DTOE.getOidPeriodoDesde());
                    }
                    
                    if(DTOE.getOidPeriodoHasta()!=null){
                        periodoLHasta = periodoLH.findByPrimaryKey(DTOE.getOidPeriodoHasta());
                    }
                } catch (NoResultException nre) {
                    //throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                 } catch (PersistenceException ce) {
                     UtilidadesLog.error("ERROR ", ce);
                     throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                } 

                if ((periodoLDesde != null) && (periodoLHasta != null)) {
                    if ((periodoLDesde.getFechainicio().getTime() <= periodoLHasta.getFechainicio().getTime()) &&
                            (periodoLDesde.getFechaFin().getTime() <= periodoLHasta.getFechaFin().getTime())) {
                        requisitosPremiacionL.setPeriodoDesde(periodoLDesde.getOid());
                        requisitosPremiacionL.setPeriodoHasta(periodoLHasta.getOid());
                    } else {
                        throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC + ErroresDeNegocio.INC_0002));
                    }
                } else {
                    requisitosPremiacionL.setPeriodoDesde(DTOE.getOidPeriodoDesde());
                    requisitosPremiacionL.setPeriodoHasta(DTOE.getOidPeriodoHasta());
                }
                requisitosPremiacionLH.merge(requisitosPremiacionL);
            }
        } catch (PersistenceException createException) {
            UtilidadesLog.error("ERROR ", createException);
            sessionContext.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONConcursoBean.guardarRequisitosPremiacion(DTORequisitosPremiacion DTOE, DTOCursosExigidosPremiacion lstCursosExigidos, Long oidConcurso):Salida");
    }


    public void guardarCursosExigidosPremiacion(DTOCursosExigidosPremiacion DTOE, Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarCursosExigidosPremiacion(DTOCursosExigidosPremiacion DTOE, Long oidConcurso):Entrada");
        try {
            RequisitosPremiacionLocal requisitosPremiacionL = null;
            RequisitosPremiacionLocalHome requisitosPremiacionLH = this.getRequisitosPremiacionLocalHome();

            CursosExigidosPremiacionLocal cursosExigidosPremiacionL = null;
            CursosExigidosPremiacionLocalHome cursosExigidosPremiacionLH = this.getCursosExigidosPremiacionLocalHome();

            requisitosPremiacionL = requisitosPremiacionLH.findByUK(oidConcurso);

            Collection cursosExigidos = cursosExigidosPremiacionLH.findByRequisito(requisitosPremiacionL.getOid());

            for (Iterator itCursosExigidosPremiacion = cursosExigidos.iterator(); itCursosExigidosPremiacion.hasNext();) {
                cursosExigidosPremiacionLH.remove((CursosExigidosPremiacionLocal) itCursosExigidosPremiacion.next());
            }

            if (DTOE.getLstCursosExigidosPremiacion() != null) {
                for (int j = 0; j < DTOE.getLstCursosExigidosPremiacion().size(); j++) {
                    DTOCursoExigidoPremiacion registro = (DTOCursoExigidoPremiacion) DTOE.getLstCursosExigidosPremiacion().get(j);

                    //creo registro..       
                    cursosExigidosPremiacionL = cursosExigidosPremiacionLH.create(registro.getOidTipoCurso(), requisitosPremiacionL.getOid());
                }
            }
        } catch (PersistenceException createException) {
            UtilidadesLog.error("ERROR ", createException);
            sessionContext.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONConcursoBean.guardarCursosExigidosPremiacion(DTOCursosExigidosPremiacion DTOE, Long oidConcurso):Salida");
    }


    public void guardarProductosExigidosPremiacion(DTOProductosExigidosPremiacion DTOE, Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarProductosExigidosPremiacion(DTOProductosExigidosPremiacion DTOE, Long oidConcurso):Entrada");
        UtilidadesLog.debug("********** Entro a guardarProductosExigidosPremiacion");
        UtilidadesLog.debug("********** DTOProductosExigidosPremiacion " + DTOE);
        UtilidadesLog.debug("********** oidConcurso " + oidConcurso);
        
        try {
            RequisitosPremiacionLocal requisitosPremiacionL = null;
            RequisitosPremiacionLocalHome requisitosPremiacionLH = this.getRequisitosPremiacionLocalHome();

            ProductosExigidosPremiacionLocal productosExigidosPremiacionL = null;
            ProductosExigidosPremiacionLocalHome productosExigidosPremiacionLH = this.getProductosExigidosPremiacionLocalHome();

            MaestroProductosLocal mProductosL = null;
            MaestroProductosLocalHome mProductosLH = this.getMaestroProductosLocalHome();

            requisitosPremiacionL = requisitosPremiacionLH.findByUK(oidConcurso);

            Collection productosExigidosPremiacion = productosExigidosPremiacionLH.findByRequisito(requisitosPremiacionL.getOid());

            for (Iterator itproductosExigidosPremiacion = productosExigidosPremiacion.iterator(); itproductosExigidosPremiacion.hasNext();) {
                productosExigidosPremiacionLH.remove((ProductosExigidosPremiacionLocal) itproductosExigidosPremiacion.next());
            }

            Long producto = null;

            if (DTOE.getLstProductosExigidosPremiacion() != null) {
                for (int j = 0; j < DTOE.getLstProductosExigidosPremiacion().size(); j++) {
                    DTOProductoExigidoPremiacion registro = (DTOProductoExigidoPremiacion) DTOE.getLstProductosExigidosPremiacion().get(j);

                    //valido, codigo de producto....
                    if ((registro.getCodigoProducto() != null) && (registro.getCodigoProducto().length() > 0)) {
                        //Agregado por incidencia 20508
                        try {
                            mProductosL = mProductosLH.findByUK(DTOE.getOidPais(), new String(registro.getCodigoProducto().toString()));
                            producto = mProductosL.getOid();                            
                        }
                        catch (FinderException fe) {
                            UtilidadesLog.error("ERROR ", fe);
                            
                            ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(), 
                            UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0045));

                            ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                            ex.addParameter(registro.getCodigoProducto());
                            throw ex;        
                        }                               
                        //Fin - Agregado por incidencia 20508                  
                    }
                    else {
                        producto = registro.getOidCodigoProducto();
                    }

                    //creo registro..       
                    productosExigidosPremiacionL = productosExigidosPremiacionLH.create(requisitosPremiacionL.getOid(), registro.getOidMarca());

                    productosExigidosPremiacionL.setGenerico(registro.getOidGenerico());
                    productosExigidosPremiacionL.setNegocio(registro.getOidNegocio());
                    productosExigidosPremiacionL.setSupergenerico(registro.getOidSuperGenerico());
                    productosExigidosPremiacionL.setUnidadNegocio(registro.getOidUnidadNegocio());
                    productosExigidosPremiacionL.setCodigoProducto(producto);
                    productosExigidosPremiacionLH.merge(productosExigidosPremiacionL);
                }
            }
        }
        catch (PersistenceException createException) {
            UtilidadesLog.error("ERROR ", createException);
            sessionContext.setRollbackOnly();
            throw new MareException(createException, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (NamingException ne) {
            UtilidadesLog.error("ERROR ", ne);
            throw new MareException(ne, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    UtilidadesLog.info("MONConcursoBean.guardarProductosExigidosPremiacion(DTOProductosExigidosPremiacion DTOE, Long oidConcurso):Salida");
    }


    private MaestroProductosLocalHome getMaestroProductosLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MaestroProductosLocalHome) context.lookup("java:comp/env/MaestroProductos");
    }

    public void guardarDespachoPremios(DTODespachoPremios DTOE, Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarDespachoPremios(DTODespachoPremios DTOE, Long oidConcurso):Entrada");
        UtilidadesLog.debug("*** DTOE: "+DTOE);
        Integer indAuto = null;
        Integer indMan = null;
        if(DTOE.getIndComunicacionProcesoAutomatico()!=null){
            indAuto = DTOE.getIndComunicacionProcesoAutomatico().booleanValue()?new Integer(1):new Integer(0);
        } 
        if(DTOE.getIndComunicacionProcesoManual()!=null){
                indMan = DTOE.getIndComunicacionProcesoManual().booleanValue()?new Integer(1):new Integer(0);
        }
        UtilidadesLog.debug("*** indMan: "+indMan+" indAuto: "+indAuto);
        
        if (DTOE.getOidDespachoPremios() != null) {
            try {
                DespachoPremiosLocal despachoPremiosL = null;
                DespachoPremiosLocalHome despachoPremiosLH = this.getDespachoPremiosLocalHome();

                despachoPremiosL = despachoPremiosLH.findByPrimaryKey(DTOE.getOidDespachoPremios());

                despachoPremiosL.setComunicacionDespachoAutomatico(DTOE.getIndComunicacionProcesoAutomatico());
                despachoPremiosL.setComunicacionDespachoManual(DTOE.getIndComunicacionProcesoManual());

                //busqueda en mensajes
                MensajesLocal msgL = null;
                MensajesLocalHome msgLH = this.getMensajesLocalHome();

                //DESPACHO AUTOMATICO
                //Cleal - 21380
                if(ConstantesINC.IND_ACTIVO.equals(indAuto)){
                    UtilidadesLog.debug("***Comunicacion Automatica ");
             
                    if (DTOE.getMensajeDespachoAutomatico() != null && DTOE.getMensajeDespachoAutomatico().length() > 1) {
                        UtilidadesLog.debug("***Cargo mensaje ");
                        try {
                            msgL = msgLH.findByUk(DTOE.getOidPais(), DTOE.getMensajeDespachoAutomatico());
                            despachoPremiosL.setMensajeDespachoAutomatico(msgL.getOid());
                        } catch (NoResultException fe) {
                            UtilidadesLog.error("ERROR ", fe);
                            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0001));
                        }  catch (PersistenceException ce) {
                             UtilidadesLog.error("ERROR ", ce);
                             throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }
                    } else{
                            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0001));
                          }
                }

                //DESPACHO MANUAL
             //Cleal - 21380
             if(ConstantesINC.IND_ACTIVO.equals(indMan)){   
                UtilidadesLog.debug("***Comunicacion Manual ");
                if (DTOE.getMensajeDespachoManual() != null && DTOE.getMensajeDespachoManual().length() > 1) {
                    UtilidadesLog.debug("***Cargo mensaje ");
                    try {
                        msgL = msgLH.findByUk(DTOE.getOidPais(), DTOE.getMensajeDespachoManual());
                        despachoPremiosL.setMensajeDespachoManual(msgL.getOid());
                    } catch (NoResultException fe) {
                        UtilidadesLog.error("ERROR ", fe);
                        throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0001));
                    }  catch (PersistenceException ce) {
                         UtilidadesLog.error("ERROR ", ce);
                         throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
                } else{
                            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0001));
                          }
                }
                despachoPremiosLH.merge(despachoPremiosL);
            } catch (NoResultException fe) {
                UtilidadesLog.error("ERROR ", fe);
                throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            
        } else {
            try {
                DespachoPremiosLocal despachoPremiosL = null;
                DespachoPremiosLocalHome despachoPremiosLH = this.getDespachoPremiosLocalHome();

                despachoPremiosL = despachoPremiosLH.create(DTOE.getIndComunicacionProcesoAutomatico(), DTOE.getIndComunicacionProcesoManual(),
                                                            oidConcurso);

                //busqueda en mensajes
                MensajesLocal msgL = null;
                MensajesLocalHome msgLH = this.getMensajesLocalHome();
                
                //Cleal - 21380
                if(ConstantesINC.IND_ACTIVO.equals(indAuto)){
                    UtilidadesLog.debug("***Comunicacion Automatica ");
                    if (DTOE.getMensajeDespachoAutomatico() != null && DTOE.getMensajeDespachoAutomatico().length() > 1) {
                        UtilidadesLog.debug("***Cargo mensaje ");
                            try {
                                msgL = msgLH.findByUk(DTOE.getOidPais(), DTOE.getMensajeDespachoAutomatico());
                                despachoPremiosL.setMensajeDespachoAutomatico(msgL.getOid());
                            } catch (NoResultException fe) {
                                UtilidadesLog.error("ERROR ", fe);
                                throw new MareException(null, null,
                                                        UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0001));
                            }  catch (PersistenceException ce) {
                                 UtilidadesLog.error("ERROR ", ce);
                                 throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                            }
                        
                    } else{
                                throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0001));
                              }
                    }
                    
                //Cleal - 21380
                if(ConstantesINC.IND_ACTIVO.equals(indMan)){
                    UtilidadesLog.debug("***Comunicacion Manual ");
                    if (DTOE.getMensajeDespachoManual() != null && DTOE.getMensajeDespachoManual().length() > 1) {
                        UtilidadesLog.debug("***Cargo mensaje ");
                            try {
                                msgL = msgLH.findByUk(DTOE.getOidPais(), DTOE.getMensajeDespachoManual());
                                despachoPremiosL.setMensajeDespachoManual(msgL.getOid());
                            } catch (NoResultException fe) {
                                UtilidadesLog.error("ERROR ", fe);
                                throw new MareException(null, null,
                                                        UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0001));
                            }  catch (PersistenceException ce) {
                                 UtilidadesLog.error("ERROR ", ce);
                                 throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                            }
                        
                    } else {
                                throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0001));
                    }
                }
                despachoPremiosLH.merge(despachoPremiosL);
            } catch (PersistenceException createException) {
                UtilidadesLog.error("ERROR ", createException);
                sessionContext.setRollbackOnly();
                throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONConcursoBean.guardarDespachoPremios(DTODespachoPremios DTOE, Long oidConcurso):Salida");
    }


    /**
     * 
     * @throws es.indra.mare.common.exception.MareException
     * @param oidConcurso
     * @param DTOE
     * Modificado: Cristian Valenzuela
     * Fecha:      23/2/2006
     * Incidencia: 22393
     */
   
    public void guardarParametrosCalificacion(DTOParametrosCalificacion DTOE, 
        Long oidConcurso, Long oidTipoCalificacion) throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarParametrosCalificacion(DTOParametrosCalificacion DTOE, Long oidConcurso):Entrada");        
        UtilidadesLog.debug("********** DTOParametrosCalificacion " + DTOE);
        UtilidadesLog.debug("********** oidConcurso " + oidConcurso);

        ParametrosCalificacionLocal cali = null;
        ParametrosCalificacionLocalHome parametrosCalificacionLH = null;

        //busqueda en mensajes
        MensajesLocal msgL = null;
        MensajesLocalHome msgLH = null;

        if (DTOE.getOidParamCalificacion() != null) {
            try {
                parametrosCalificacionLH = this.getParametrosCalificacionLocalHome();
                UtilidadesLog.debug("********** Llamando al findByUK de la entidad ParametrosCalificacion");
                cali = parametrosCalificacionLH.findByUK(oidConcurso);
            } catch (NoResultException fe) {
                UtilidadesLog.error("ERROR ", fe);
                throw new MareException(fe, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        } else {
            try {
                parametrosCalificacionLH = this.getParametrosCalificacionLocalHome();               
                PeriodoLocalHome periodoLH = this.getPeriodoLocalHome();
                PeriodoLocal periodoLDesde = null;
                PeriodoLocal periodoLHasta = null;
                Long pDesde = null;
                Long pHasta = null;

                try {
                    UtilidadesLog.debug("********** Llamando al findByPrimaryKey de la entidad Periodo - desde");
                    periodoLDesde = periodoLH.findByPrimaryKey(DTOE.getOidPeriodoDesde());
                    UtilidadesLog.debug("********** Llamando al findByPrimaryKey de la entidad Periodo - hasta");
                    periodoLHasta = periodoLH.findByPrimaryKey(DTOE.getOidPeriodoHasta());
                    
                } catch (NoResultException nre) {
                     UtilidadesLog.error("ERROR ", nre);
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                } 

                if (periodoLHasta != null) {
                    if ((periodoLDesde.getFechainicio().getTime() <= periodoLHasta.getFechainicio().getTime()) &&
                            (periodoLDesde.getFechaFin().getTime() <= periodoLHasta.getFechaFin().getTime())) {
                        pDesde = periodoLDesde.getOid();
                        pHasta = periodoLHasta.getOid();
                    } else {
                        throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC + ErroresDeNegocio.INC_0334));
                    }
                } else {
                    pDesde = periodoLDesde.getOid();
                    pHasta = null;
                }

                UtilidadesLog.debug("********** Antes del create en la entidad ParametrosCalificacion");
                cali = parametrosCalificacionLH.create(DTOE.getIndDevoluciones(), DTOE.getIndAnulaciones(), DTOE.getIndFaltantesNoAnunciados(),
                                                       DTOE.getIndMetasModificables(), DTOE.getIndMetasBloqueadas(), DTOE.getIndComunicacion(),
                                                       pDesde, pHasta, DTOE.getOidTipoVentaCalificacion(), DTOE.getOidDirigidoA(), oidConcurso,
                                                       DTOE.getOidFormaCalculo());
                cali.setTipoIncremento(DTOE.getOidTipoIncremento());
                cali.setTipoVentaHistorica(DTOE.getOidTipoVentaHistorica());
                parametrosCalificacionLH.merge(cali);
            } catch (PersistenceException ne) {
                UtilidadesLog.error("ERROR ", ne);
                throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }

        if (DTOE.getMensaje() != null && DTOE.getMensaje().length() > 1) {
            try {
                if (DTOE.getIndComunicacion().booleanValue()) {
                    msgLH = this.getMensajesLocalHome();
                    UtilidadesLog.debug("********** Llamando al findByUk de la entidad Mensajes");
                    msgL = msgLH.findByUk(DTOE.getOidPais(), DTOE.getMensaje());
                    cali.setMensaje(msgL.getOid());
                }
            } catch (NoResultException fe) {
                UtilidadesLog.error("ERROR ", fe);
                throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0013));
            }  catch (PersistenceException ce) {
                 UtilidadesLog.error("ERROR ", ce);
                 throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }

        UtilidadesLog.debug("********** Seteando el resto de los campos");
        cali.setDevoluciones(DTOE.getIndDevoluciones());
        cali.setAnulaciones(DTOE.getIndAnulaciones());
        cali.setFaltantesNoAnunciados(DTOE.getIndFaltantesNoAnunciados());
        cali.setMetasModificables(DTOE.getIndMetasModificables());
        cali.setMetasBloqueadas(DTOE.getIndMetasBloqueadas());
        cali.setComunicacionCalificacion(DTOE.getIndComunicacion());
        cali.setAgrupacion(DTOE.getOidAgrupacion());
        cali.setFormaCalculo(DTOE.getOidFormaCalculo());
        cali.setPeriodoDesde(DTOE.getOidPeriodoDesde());
        cali.setPeriodoHasta(DTOE.getOidPeriodoHasta());
        cali.setTipoDeterminacionMetas(DTOE.getOidTipoDeterminacionMetas());
        cali.setTipoIncremento(DTOE.getOidTipoIncremento());
        cali.setTipoVentaCalificacion(DTOE.getOidTipoVentaCalificacion());
        cali.setTipoVentaHistorica(DTOE.getOidTipoVentaHistorica());
        cali.setTipoVentaIncremental(DTOE.getOidTipoVentaIncremental());
        
        parametrosCalificacionLH.merge(cali);

        UtilidadesLog.debug("********** Llamando a guardarIncrementosPorRango");
        this.guardarIncrementosPorRango(oidConcurso, DTOE.getLstIncrementosPorRango());
        
        UtilidadesLog.info("MONConcursoBean.guardarParametrosCalificacion(DTOParametrosCalificacion DTOE, Long oidConcurso):Salida");
    }

    public void guardarIncrementosPorRango(Long oidConcurso, ArrayList lista)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarIncrementosPorRango(Long oidConcurso, ArrayList lista):Entrada");
        RangoLocal rango = null;
        RangoLocalHome rangoLH = null;

        try {
            rangoLH = this.getRangoLocalHome();

            Collection rangos = rangoLH.findByConcurso(oidConcurso);
            Iterator it = rangos.iterator();

            if (rangos != null) {
                try {
                    while (it.hasNext()) {
                        rango = (RangoLocal) it.next();
                        rangoLH.remove(rango);
                    }
                } catch (PersistenceException fe) {
                    UtilidadesLog.error("ERROR ", fe);
                    throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
            }

            if (lista != null) {
                for (int j = 0; j < lista.size(); j++) {
                    DTOIncrementoPorRango elemento = (DTOIncrementoPorRango) lista.get(j);
                    rango = rangoLH.create(elemento.getDesde(), elemento.getHasta(), elemento.getIncremento(), oidConcurso);
                }
            }
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException createException) {
            UtilidadesLog.error("ERROR ", createException);
            sessionContext.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONConcursoBean.guardarIncrementosPorRango(Long oidConcurso, ArrayList lista):Salida");
    }

    public DTOListaEstatusVenta obtenerListaEstatusVentaConsultora(DTOOID DTOE)
            throws MareException {
        DAOConcurso dao = new DAOConcurso();
        return dao.obtenerListaEstatusVenta(DTOE);
    }


    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:       30/05/2005
     * @version     1.00
     * @autor       Sergio C. Saavedra
     */
    public void guardarClasificacionParticipantesCalificacion(DTOCalificacionParticipantes 
        DTOE, Long oidConcurso, Long oidDirigidoA) throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarClasificacionParticipantesCalificacion"+
        "(DTOCalificacionParticipantes DTOE, Long oidConcurso, Long oidDirigidoA):Entrada");
        
        //escrito segun inc.: 18472 
        try {
            UtilidadesLog.debug("dentro de guardarClasificacionParticipantesCalificacion, recibo : " + 
            DTOE + ", concurso: " + oidConcurso + ", dirigido A: " + oidDirigidoA);

            ClasificacionParticipantesCalificacionLocal clasificacionParticipantesCalificacionL = null;
            ClasificacionParticipantesCalificacionLocalHome clasificacionParticipantesCalificacionLH = this.getClasificacionParticipantesCalificacionLocalHome();

            MontoMinimoRangoGerentesLocalHome montoMinimoRangoGerentesLH = this.getMontoMinimoRangoGerentesLocalHome();

            MontoMinimoRangoConsultorasLocalHome montoMinimoRangoConsultorasLH = this.getMontoMinimoRangoConsultorasLocalHome();

            Collection participantesCalificacion = clasificacionParticipantesCalificacionLH.findByConcurso(oidConcurso);
            ClasificacionParticipantesCalificacionLocal registroA = null;
            MontoMinimoRangoGerentesLocal registroB = null;
            MontoMinimoRangoConsultorasLocal registroC = null;

            ArrayList lstCaliPart = DTOE.getLstCalificacionParticipantes();

            for (Iterator itPartCali = participantesCalificacion.iterator(); itPartCali.hasNext();) {
                registroA = (ClasificacionParticipantesCalificacionLocal) itPartCali.next();

                //******** Borrar montoMinimoRangoGerentes ******/
                Collection montoMinRangoGer = montoMinimoRangoGerentesLH.findByParticipanteCalificacion(registroA.getOid());

                for (Iterator itMontoMinRangGer = montoMinRangoGer.iterator(); itMontoMinRangGer.hasNext();) {
                    registroB = (MontoMinimoRangoGerentesLocal) itMontoMinRangGer.next();
                    montoMinimoRangoGerentesLH.remove(registroB);
                }

                //******** Borrar montoMinimoRangoConsultoras ******/
                Collection montoMinRangoCons = montoMinimoRangoConsultorasLH.findByParticipanteCalificacion(registroA.getOid());

                for (Iterator itMontoMinRangCons = montoMinRangoCons.iterator(); itMontoMinRangCons.hasNext();) {
                    registroC = (MontoMinimoRangoConsultorasLocal) itMontoMinRangCons.next();
                    montoMinimoRangoConsultorasLH.remove(registroC);                    
                }

                // Elimina Clasificacion Participantes Calificacion
                clasificacionParticipantesCalificacionLH.remove(registroA);                    
            }

            //INC 20271
            EstatusVentaLocal evcl = null;
            EstatusVentaLocalHome evclh = this.getEstatusVentaLocalHome();
            
            Long oidParticipante = null;

            //INC 20271
            if (lstCaliPart != null) {
                //Guardar los participantes Consultoras pasados como argumento
                for (int j = 0; j < lstCaliPart.size(); j++) {
                    DTOCalificacionParticipante registro = (DTOCalificacionParticipante) lstCaliPart.get(j);
                    
                    //Modificado por cvalenzu - 1/12/2006
                    //Incidencia: V-INC-16
                    //Comentario: generaba registros en INC_CLASI_PARTI_CALIF
                    //con oids de participantes repetidos, con lo cual
                    //se generaban datos basura en esta tabla
                    //Ahora inserta en INC_CLASI_PARTI_CALIF solo si cambia
                    //el oid de participante.
                    
                    UtilidadesLog.debug("*** oidParticipante:"+oidParticipante);
                    
                    if(j>0) {
                      UtilidadesLog.debug("*** j>0");
                      UtilidadesLog.debug("*** registro.getOidParticipante():"+registro.getOidParticipante());
                      
                      if(!oidParticipante.equals(registro.getOidParticipante())) {
                          oidParticipante = registro.getOidParticipante();
                          UtilidadesLog.debug("*** if - oidParticipante:"+oidParticipante);
                      
                          clasificacionParticipantesCalificacionL = clasificacionParticipantesCalificacionLH.create(oidConcurso, registro.getOidParticipante());                                            
                      }                      
                    }
                    else {
                      UtilidadesLog.debug("*** j=0");
                      oidParticipante = registro.getOidParticipante();
                      UtilidadesLog.debug("*** else - oidParticipante:"+oidParticipante);
                      
                      clasificacionParticipantesCalificacionL = clasificacionParticipantesCalificacionLH.create(oidConcurso, registro.getOidParticipante());                                          
                    }                    
                    //FIN - Modificado por cvalenzu - 1/12/2006                    
                    
                    if (oidDirigidoA.longValue() == ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS.longValue()) {
                        //INC 20271
                        //21272
                        //evcl = evclh.findByPrimaryKey(registro.getOidEstatusVenta());
                        evcl = evclh.findByUk(oidConcurso, registro.getOidEstatusVenta());

                        if (evcl != null) {
                            UtilidadesLog.debug("CreateMontoMinimoConcu: "+registro.getMontoMinimo()+" "
                            + evcl.getOid()+" "+clasificacionParticipantesCalificacionL.getOid());
                            montoMinimoRangoConsultorasLH.create(registro.getMontoMinimo(), 
                            evcl.getOid(),clasificacionParticipantesCalificacionL.getOid());                            
                        }
                        //21272
                        //INC 20271
                    }

                    if (oidDirigidoA.longValue() == ConstantesINC.OID_DIRIGIDO_A_GERENTE.longValue()) {
                        montoMinimoRangoGerentesLH.create(registro.getMontoMinimo(), clasificacionParticipantesCalificacionL.getOid());
                    }
                }
            }
        }
        catch (PersistenceException createException) {
            UtilidadesLog.error("ERROR ", createException);
            sessionContext.setRollbackOnly();
            throw new MareException(createException, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONConcursoBean.guardarClasificacionParticipantesCalificacion"+
        "(DTOCalificacionParticipantes DTOE, Long oidConcurso, Long oidDirigidoA):Salida");
    }


    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:       30/05/2005
     * @version     1.00
     * @autor       Sergio C. Saavedra
     */
    public void guardarNivelesPremiacion(DTONivelesPremiacion DTOE, Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarNivelesPremiacion(DTONivelesPremiacion DTOE, Long oidConcurso): Entrada");
        try {
        
            UtilidadesLog.debug("entro a guardarNivelesPremiacion, recibo : " + DTOE + ", concurso: " + oidConcurso);

            ParametrosGeneralesPremiacionLocal parametrosGeneralesPremiacionL = null;
            ParametrosGeneralesPremiacionLocalHome parametrosGeneralesPremiacionLH = this.getParametrosGeneralesPremiacionLocalHome();
            ParametrosNivelPremiacionLocal pnpL = null;
            ParametrosNivelPremiacionLocalHome pnpLH = this.getParametrosNivelPremiacionLocalHome();

            parametrosGeneralesPremiacionL = parametrosGeneralesPremiacionLH.findByUK(oidConcurso);

            Collection niveles = pnpLH.findByParametroGeneralPremiacion(parametrosGeneralesPremiacionL.getOid());

            if ((niveles != null) && (niveles.size() > 0)) {
                Iterator it = niveles.iterator();

                while (it.hasNext()) {
                    ParametrosNivelPremiacionLocal registro = (ParametrosNivelPremiacionLocal) it.next();
                    this.borrarPremios(registro.getOid());
                }
            }

            DTONivelPremiacion[] listaNiveles = DTOE.getListaNiveles();

            if ((listaNiveles != null) && (listaNiveles.length > 0)) {
                for (int i = 0; i < listaNiveles.length; i++) {
                    DTONivelPremiacion registro = (DTONivelPremiacion) listaNiveles[i];

                    pnpL = pnpLH.create(registro.getNumeroNivel(), parametrosGeneralesPremiacionL.getOid(), registro.getOidTipoPremio(),
                                        new Date(System.currentTimeMillis()));

                    pnpL.setCantidadFijaPuntos(registro.getCantidadFijaPuntos());
                    pnpL.setCantidadFinalPuntos(registro.getCantidadHasta());
                    pnpL.setCantidadInicialPuntos(registro.getCantidadDesde());
                    pnpL.setNivelSelectivo(registro.getIndNivelSelectivo());
                    pnpL.setNumeroAspirantes(registro.getNumeroAspirantes());
                    pnpL.setPuntajeServicio(registro.getPuntajeServicio());
                    pnpL.setPuntosProductosExigidos(registro.getPuntosProductosExigidos());
                    
                    pnpL.setDescripcionNivel(registro.getDescripcionNivel());
                    
                    pnpLH.merge(pnpL);
                    registro.setOid(pnpL.getOid());

                    if (registro.getOidTipoPremio().longValue() == ConstantesINC.OID_TIPO_PREMIO_PUNTOS.longValue()) {
                        this.guardarPremioPuntos(registro.getPremioPuntos(), registro.getOid());
                    }

                    if (registro.getOidTipoPremio().longValue() == ConstantesINC.OID_TIPO_PREMIO_MONETARIO.longValue()) {
                        this.guardarPremioMonetario(registro.getPremioMonetario(), registro.getOid());
                    }

                    if (registro.getOidTipoPremio().longValue() == ConstantesINC.OID_TIPO_PREMIO_ARTICULO.longValue()) {
                        DTOPremioArticulo param = registro.getPremioArticulo();
                        
                        UtilidadesLog.debug("param.getOidPais(): " + param.getOidPais());

                        if (DTOE.getOidPais() != null) {
                            param.setOidPais(DTOE.getOidPais());
                        }
                        
                        UtilidadesLog.debug("DTOE.getOidPais(): " + DTOE.getOidPais());

                        this.guardarPremioArticulo(param, registro.getOid());
                    }

                    if (registro.getOidTipoPremio().longValue() == ConstantesINC.OID_TIPO_PREMIO_DESCUENTO.longValue()) {
                        DTOPremioDescuento param = registro.getPremioDescuento();

                        if (DTOE.getOidPais() != null) {
                            param.setOidPais(DTOE.getOidPais());
                        }

                        this.guardarPremioDescuento(param, registro.getOid());
                    }
                }
            }
            
            UtilidadesLog.debug("salio de guardarNivelesPremiacion");
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException createException) {
            sessionContext.setRollbackOnly();
            UtilidadesLog.error("ERROR ", createException);
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONConcursoBean.guardarNivelesPremiacion(DTONivelesPremiacion DTOE, Long oidConcurso): Salida");
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       30/05/2005
           * @version     1.00
           * @autor       Sergio C. Saavedra
           */
    public void borrarPremios(Long oidParamNivelPremiacion)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.borrarPremios(Long oidParamNivelPremiacion): Entrada");
        PremioPuntosLocal ppL = null;
        PremioMonetarioLocal pmL = null;
        PagoMonetariosLocal pamL = null;
        PremioDescuentoLocal pdL = null;
        ProductoDescuentoLocal prdL = null;
        PremioArticuloLocal paL = null;
        LotePremioArticulosLocal lpaL = null;
        ArticulosLoteLocal alL = null;
        ParametrosNivelPremiacionLocal pnpL = null;

        try {
            UtilidadesLog.debug("entro a borrarPremios, recibo oidParamNivelPremiacion: " + oidParamNivelPremiacion);

            PremioPuntosLocalHome ppLH = this.getPremioPuntosLocalHome();
            PremioMonetarioLocalHome pmLH = this.getPremioMonetarioLocalHome();
            PagoMonetariosLocalHome pamLH = this.getPagoMonetariosLocalHome();
            PremioDescuentoLocalHome pdLH = this.getPremioDescuentoLocalHome();
            ProductoDescuentoLocalHome prdLH = this.getProductoDescuentoLocalHome();
            PremioArticuloLocalHome paLH = this.getPremioArticuloLocalHome();
            LotePremioArticulosLocalHome lpaLH = this.getLotePremioArticulosLocalHome();
            ArticulosLoteLocalHome aLLH = this.getArticulosLoteLocalHome();
            ParametrosNivelPremiacionLocalHome pnpLH = this.getParametrosNivelPremiacionLocalHome();

            Collection colNivPrem = ppLH.findByParametroNivelPremiacion(oidParamNivelPremiacion);

            if ((colNivPrem != null) && (colNivPrem.size() > 0)) {
                UtilidadesLog.debug("premio punto a borrar");

                Iterator it = colNivPrem.iterator();

                while (it.hasNext()) {
                    PremioPuntosLocal registro = (PremioPuntosLocal) it.next();
                    ppLH.remove(registro);
                }
            }

            Collection colParNivPrem = pmLH.findByParametroNivelPremiacion(oidParamNivelPremiacion);

            if ((colParNivPrem != null) && (colParNivPrem.size() > 0)) {
                UtilidadesLog.debug("premio monetario a borrar");

                Iterator it1 = colParNivPrem.iterator();

                while (it1.hasNext()) {
                    PremioMonetarioLocal registro = (PremioMonetarioLocal) it1.next();

                    Collection colPagoMonet = pamLH.findByPremioMonetario(registro.getOid());

                    if ((colPagoMonet != null) && (colPagoMonet.size() > 0)) {
                        UtilidadesLog.debug("pago a borrar");

                        Iterator it2 = colPagoMonet.iterator();

                        while (it2.hasNext()) {
                            PagoMonetariosLocal registro1 = (PagoMonetariosLocal) it2.next();
                            pamLH.remove(registro1);
                        }
                    }
                    pmLH.remove(registro);
                }
            }

            Collection colPremDto = pdLH.findByParametroNivelPremiacion(oidParamNivelPremiacion);

            if ((colPremDto != null) && (colPremDto.size() > 0)) {
                UtilidadesLog.debug("premio descuento a borrar");

                Iterator it2 = colPremDto.iterator();

                while (it2.hasNext()) {
                    PremioDescuentoLocal registro = (PremioDescuentoLocal) it2.next();

                    Collection colProdDto = prdLH.findByPremioDescuento(registro.getOid());

                    if ((colProdDto != null) && (colProdDto.size() > 0)) {
                        Iterator it3 = colProdDto.iterator();

                        while (it3.hasNext()) {
                            ProductoDescuentoLocal registro1 = (ProductoDescuentoLocal) it3.next();
                            prdLH.remove(registro1);
                        }
                    }
                    pdLH.remove(registro);
                }
            }

            Collection colPremArt = paLH.findByParametroNivelPremiacion(oidParamNivelPremiacion);

            if ((colPremArt != null) && (colPremArt.size() > 0)) {
                UtilidadesLog.debug("premio articulo a borrar");

                Iterator it4 = colPremArt.iterator();

                while (it4.hasNext()) {
                    PremioArticuloLocal registro = (PremioArticuloLocal) it4.next();

                    Collection colLotePremArt = lpaLH.findByLotePremioArticulo(registro.getOid());

                    if ((colLotePremArt != null) && (colLotePremArt.size() > 0)) {
                        UtilidadesLog.debug("lote a borrar");

                        Iterator it5 = colLotePremArt.iterator();

                        while (it5.hasNext()) {
                            LotePremioArticulosLocal registro1 = (LotePremioArticulosLocal) it5.next();

                            Collection colArtLote = aLLH.findByLotePremioArticulo(registro1.getOid());

                            if ((colArtLote != null) && (colArtLote.size() > 0)) {
                                UtilidadesLog.debug("producto a borrar");

                                Iterator it6 = colArtLote.iterator();

                                while (it6.hasNext()) {
                                    ArticulosLoteLocal registro2 = (ArticulosLoteLocal) it6.next();
                                    aLLH.remove(registro2);
                                }
                            }
                            lpaLH.remove(registro1);
                        }
                    }
                    paLH.remove(registro);
                }
            }

            //Se borra el oid de entrada de la entidad: Niveles Premiacion   
            pnpL = pnpLH.findByPrimaryKey(oidParamNivelPremiacion);
            UtilidadesLog.debug("borra nivel Premio: " + pnpL.getOid());
            pnpLH.remove(pnpL);

            UtilidadesLog.debug("termino borrarPremios");
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException re) {
            UtilidadesLog.error("ERROR ", re);
            sessionContext.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
        UtilidadesLog.info("MONConcursoBean.borrarPremios(Long oidParamNivelPremiacion): Salida");
    }


    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:       30/05/2005
     * @version     1.00
     * @autor       Sergio C. Saavedra
     */
    public void guardarPremioPuntos(DTOPremioPuntos DTOE, Long oidNivel)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarPremioPuntos(DTOPremioPuntos DTOE, Long oidNivel): Entrada");
        UtilidadesLog.debug("entro a guardarPremioPuntos, recibo : " + DTOE + ", oidNivel: " + oidNivel);

        // Se guarda el registro en INC:PremioPuntos 
        PremioPuntosLocal ppL = null;

        try {
            PremioPuntosLocalHome ppLH = this.getPremioPuntosLocalHome();
            ppL = ppLH.create(DTOE.getNumeroPremio(), oidNivel, DTOE.getOidTipoPremioPuntos(), DTOE.getOidConcursoDestino());

            ppL.setCantidad(DTOE.getCantidad());
            ppL.setPorcentaje(DTOE.getPorcentaje());
            ppLH.merge(ppL);
        } catch (PersistenceException createException) {
            UtilidadesLog.error("ERROR ", createException);
            sessionContext.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.debug("salio de guardarPremioPuntos");
        UtilidadesLog.info("MONConcursoBean.guardarPremioPuntos(DTOPremioPuntos DTOE, Long oidNivel): Salida");
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       30/05/2005
           * @version     1.00
           * @autor       Sergio C. Saavedra
           */
    public void guardarPremioMonetario(DTOPremioMonetario DTOE, Long oidNivel)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarPremioMonetario(DTOPremioMonetario DTOE, Long oidNivel): Entrada");
        UtilidadesLog.info("entro a guardarPremioMonetario, recibo : " + DTOE + ", oidNivel: " + oidNivel);

        // Se guarda el registro en INC:PremioMonetario 
        PremioMonetarioLocal pmL = null;

        try {
            PremioMonetarioLocalHome pmLH = this.getPremioMonetarioLocalHome();
            UtilidadesLog.info("PremioMonetarioLocalHome " + ((pmLH != null)?" NO":null) + " ES NULL");
            pmL = pmLH.create(DTOE.getNumeroPremio(), DTOE.getOidMoneda(), oidNivel, DTOE.getOidTipoPremioMonetario(), DTOE.getOidFormaPago());

            pmL.setPagoPartes(DTOE.getIndPagoPartes());
            pmL.setDescontarPagosAnticipados(DTOE.getIndDescontarPagosAnticipados());
            pmL.setCumplimiento(DTOE.getOidCumplimiento());

            if (DTOE.getOidTipoPremioMonetario().longValue() == ConstantesINC.TIPO_PREMIO_MONETARIO_PUNTOS_CANTIDAD_FIJA.longValue()) {
                pmL.setCantidad(new BigDecimal(DTOE.getCantidad().toString()));
            }

            if (DTOE.getOidTipoPremioMonetario().longValue() == ConstantesINC.TIPO_PREMIO_MONETARIO_PORCENTAJE_PUNTOS_PUNTAJE_OBTENIDO.longValue()) {
                pmL.setPorcentaje(new BigDecimal(DTOE.getPorcentaje().toString()));
            }
            pmLH.merge(pmL);

            if ((DTOE.getLstPagosMonetarios() != null) && (DTOE.getLstPagosMonetarios().size() > 0)) {
                PagoMonetariosLocal pamL = null;
                PagoMonetariosLocalHome pamLH = this.getPagoMonetariosLocalHome();

                for (int j = 0; j < DTOE.getLstPagosMonetarios().size(); j++) {
                    UtilidadesLog.debug("lista de pagos: " + DTOE.getLstPagosMonetarios());

                    DTOPagoMonetario registro = (DTOPagoMonetario) DTOE.getLstPagosMonetarios().get(j);

                    pamL = pamLH.create(new Long(registro.getNumeroPago().intValue()), new Double(registro.getPremio().toString()),
                                        registro.getOidPeriodoControl(), pmL.getOid());
                }
            }
            UtilidadesLog.info("MONConcursoBean.guardarPremioMonetario(DTOPremioMonetario DTOE, Long oidNivel): Salida");
            UtilidadesLog.debug("salio de guardarPremioMonetario");
        } catch (PersistenceException createException) {
            UtilidadesLog.error("ERROR ", createException);
            sessionContext.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       30/05/2005
           * @version     1.00
           * @autor       Sergio C. Saavedra
           */
    public void guardarPremioArticulo(DTOPremioArticulo DTOE, Long oidNivel)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarPremioArticulo(DTOPremioArticulo DTOE, Long oidNivel): Entrada");
        UtilidadesLog.debug("entro a guardarPremioArticulo, recibo : " + DTOE + ", oidNivel: " + oidNivel);        
        UtilidadesLog.debug("DTOE.getOidPais(): " + DTOE.getOidPais());

        try {
            PremioArticuloLocalHome paLH = this.getPremioArticuloLocalHome();
            PremioArticuloLocal paL = null;
            
            paL = paLH.create(DTOE.getNumeroUnidadesPremioArticulo(), oidNivel);

            if ((DTOE.getLstLotesPremio() != null) && (DTOE.getLstLotesPremio().size() > 0)) {
                UtilidadesLog.debug("lista de lotes: " + DTOE.getLstLotesPremio());

                int numeroLotePorPremio = 1;
                LotePremioArticulosLocalHome lpaLH = this.getLotePremioArticulosLocalHome();
                LotePremioArticulosLocal lpaL = null;

                ArticulosLoteLocalHome alLH = this.getArticulosLoteLocalHome();
                ArticulosLoteLocal alL = null;

                MaestroProductosLocal mProductosL = null;
                MaestroProductosLocalHome mProductosLH = this.getMaestroProductosLocalHome();
                Long producto = null;

                ContadorPremioArticuloLocalHome conPreArtLH = this.getContadorPremioArticuloLocalHome();
                
                ContadorPremioArticuloLocal conPreArtL = conPreArtLH.findByPais(DTOE.getOidPais());

                Long codVentaFicticio = null;

                for (int j = 0; j < DTOE.getLstLotesPremio().size(); j++) {
                    DTOLotesPremio registro = (DTOLotesPremio) DTOE.getLstLotesPremio().get(j);
                    numeroLotePorPremio = (numeroLotePorPremio + 1);
                    lpaL = lpaLH.create(new Integer(numeroLotePorPremio), registro.getNumeroPremio(), paL.getOid());
                    lpaL.setDescripcion(registro.getDescripcionLote());
                    lpaLH.merge(lpaL);

                    if ((registro.getLstProductosLote() != null) && (registro.getLstProductosLote().size() > 0)) {
                        UtilidadesLog.debug("lista de productos lote: " + registro.getLstProductosLote());

                        for (int k = 0; k < registro.getLstProductosLote().size(); k++) {
                            DTOProductosLote registro1 = (DTOProductosLote) registro.getLstProductosLote().get(k);

                            //Modificado: PER-SiCC-2009-0634 - 09-12-2009 - Sergio Apaza
                            UtilidadesLog.debug("Codigo Venta (" + registro1.getCodigoProducto() + ") : " + registro1.getCodVentaFicticio());
                            if(registro1.getCodVentaFicticio()==null)
                                codVentaFicticio = this.obtengoCodVentaFicticio(conPreArtL);
                            else
                                codVentaFicticio = new Long(registro1.getCodVentaFicticio());

                            //valido, codigo de producto....
                            if (registro1.getOidProducto() == null) {
                                //busco: codigoProducto 
                                if ((registro1.getCodigoProducto() != null) && (registro1.getCodigoProducto().length() > 0)) {
                                    try {
                                        mProductosL = mProductosLH.findByUK(DTOE.getOidPais(), registro1.getCodigoProducto());
                                        producto = mProductosL.getOid();
                                    } catch (FinderException fe) {
                                        UtilidadesLog.error("ERROR ", fe);
                                        // no se encuentra el producto ingresado a mano 
                                        ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(),
                                                                                               UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC,
                                                                                                                                "",
                                                                                                                                ErroresDeNegocio.INC_0304));

                                        ex.setPosicion(ExcepcionParametrizada.POSICION_INICIAL);
                                        ex.addParameter(registro1.getCodigoProducto());

                                        ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                                        ex.addParameter(registro.getNumeroPremio().toString());

                                        throw ex;
                                    }
                                } else {
                                    producto = null;
                                }
                            } else {
                                producto = registro1.getOidProducto();
                            }

                            // vbongiov -- 17/09/2007
                            alL = alLH.create(registro1.getIndDespachaArticulo(), registro1.getPrecioPublico(), registro1.getNumeroUnidades(),
                                              codVentaFicticio.toString(), producto, lpaL.getOid(), registro1.getIndCentroServGar(), registro1.getIndTipoEntrega());
                            
                            alL.setOidCentroServGar(registro1.getOidCentroServGar());
                            alL.setNumMeses(registro1.getNumMeses());
                            alL.setObservaciones(registro1.getObservaciones());
                            alL.setOidCentroServEntrega(registro1.getOidCentroServEntrega());                            
                            alLH.merge(alL);
                            
                        } //fin Para cada elemento de la lista lstProductosLote 
                    } //fin Si tamanyo (DTOE.lstLotesPremio[i].lstProductosLote)>0
                } //fin Para cada elemento de la lista lstLotesPremio 
            } //fin Si tamanyo(DTOE.lstLotesPremio) >0
            UtilidadesLog.info("MONConcursoBean.guardarPremioArticulo(DTOPremioArticulo DTOE, Long oidNivel): Salida");
            UtilidadesLog.debug("salio de guardarPremioArticulo");
        } catch (FinderException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (NamingException ne) {
            UtilidadesLog.error("ERROR ", ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (PersistenceException createException) {
            UtilidadesLog.error("ERROR ", createException);
            sessionContext.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       30/05/2005
           * @version     1.00
           * @autor       Sergio C. Saavedra
           */
    public void guardarPremioDescuento(DTOPremioDescuento DTOE, Long oidNivel)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarPremioDescuento(DTOPremioDescuento DTOE, Long oidNivel): Entrada");
        UtilidadesLog.debug("entro a guardarPremioDescuento, recibo : " + DTOE + ", oidNivel: " + oidNivel);

        try {
            PremioDescuentoLocalHome pdLH = this.getPremioDescuentoLocalHome();
            PremioDescuentoLocal pdL = null;

            ProductoDescuentoLocalHome prdLH = this.getProductoDescuentoLocalHome();
            ProductoDescuentoLocal prdL = null;

            PeriodoLocalHome periodoLH = this.getPeriodoLocalHome();
            PeriodoLocal periodoLDesde = null;
            PeriodoLocal periodoLHasta = null;

            Long pDesde = null;
            Long pHasta = null;

            try {
                periodoLDesde = periodoLH.findByPrimaryKey(DTOE.getOidPeriodoAplicacionDesde());
                periodoLHasta = periodoLH.findByPrimaryKey(DTOE.getOidPeriodoAplicacionHasta());
            } catch (NoResultException nre) {
                //throw new MareException(fe, UtilidadesError.
                //                            armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
             } catch (PersistenceException ce) {
                 UtilidadesLog.error("ERROR ", ce);
                 throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            if (periodoLHasta != null) {
                if ((periodoLDesde.getFechainicio().getTime() <= periodoLHasta.getFechainicio().getTime()) &&
                        (periodoLDesde.getFechaFin().getTime() <= periodoLHasta.getFechaFin().getTime())) {
                    pDesde = periodoLDesde.getOid();
                    pHasta = periodoLHasta.getOid();
                } else {
                    throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC + ErroresDeNegocio.INC_0330));
                }
            } else {
                pDesde = periodoLDesde.getOid();
                pHasta = null;
            }

            //create(Integer numPrem, Long oidParaNivePrem, Long perdOidPeriDesd, Long tdscOidTipoDesc)
            pdL = pdLH.create(DTOE.getNumeroPremio(), oidNivel, pDesde, DTOE.getOidTipoDescuento());

            if (DTOE.getOidTipoDescuento().longValue() == ConstantesINC.OID_TIPO_DESCUENTO_IMPORTE.longValue()) {
                pdL.setCantidadDescuento(DTOE.getCantidadDescuento());
            } else {
                pdL.setPorcentajeDescuento(DTOE.getPorcentajeDescuento());
            }

            pdL.setPeriodoHasta(pHasta);
            
            pdLH.merge(pdL);

            //
            if ((DTOE.getLstArticulos() != null) && (DTOE.getLstArticulos().size() > 0)) {
                UtilidadesLog.debug("lista de articulos: " + DTOE.getLstArticulos());

                DTOArticulo registro = null;

                MaestroProductosLocal mProductosL = null;
                MaestroProductosLocalHome mProductosLH = this.getMaestroProductosLocalHome();

                for (int j = 0; j < DTOE.getLstArticulos().size(); j++) {
                    registro = (DTOArticulo) DTOE.getLstArticulos().get(j);
                    prdL = prdLH.create(registro.getOidMarca(), pdL.getOid());

                    prdL.setUnidadNegocio(registro.getOidUnidadNegocio());
                    prdL.setNegocio(registro.getOidNegocio());
                    prdL.setSupergenerico(registro.getOidSupergenerico());
                    prdL.setGenerico(registro.getOidGenerico());

                    if (registro.getOidProducto() == null) { // verifica si el usuario ingreso el codigo a mano 

                        if ((registro.getCodigoProducto() != null) && (registro.getCodigoProducto().length() > 0)) {
                            try {
                                mProductosL = mProductosLH.findByUK(DTOE.getOidPais(), new String(registro.getCodigoProducto().toString()));
                                prdL.setCodigoProducto(mProductosL.getOid());
                            } catch (FinderException fe) {
                                UtilidadesLog.error("ERROR ", fe);
                                ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(),
                                                                                       UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "",
                                                                                                                        ErroresDeNegocio.INC_0303));

                                ex.setPosicion(ExcepcionParametrizada.POSICION_INICIAL);
                                ex.addParameter(registro.getCodigoProducto());

                                ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                                ex.addParameter(DTOE.getNumeroPremio().toString());

                                throw ex;
                            }
                        }
                    } else {
                        prdL.setCodigoProducto(registro.getOidProducto());
                    }
                    prdLH.merge(prdL);
                    
                } //for lsta. articulos
            } //lsta articulos con data
            UtilidadesLog.info("MONConcursoBean.guardarPremioDescuento(DTOPremioDescuento DTOE, Long oidNivel): Salida");
            UtilidadesLog.debug("salio de guardarPremioDescuento");
        } catch (NamingException ne) {
            UtilidadesLog.error("ERROR ", ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (PersistenceException createException) {
            UtilidadesLog.error("ERROR ", createException);
            sessionContext.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       30/05/2005
           * @version     1.00
           * @autor       Sergio C. Saavedra
           */
    public void guardarProgramaNuevas(DTOProgramaNuevas DTOE, Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarProgramaNuevas(DTOProgramaNuevas DTOE, Long oidConcurso): Entrada");
        UtilidadesLog.debug("dentro de guardarProgramaNuevas, recibo : " + DTOE + ", concurso: " + oidConcurso);

        ConcursoParametrosGeneralesLocalHome concursoParametrosGeneralesLH = null;
        ConcursoParametrosGeneralesLocal concursoParametrosGeneralesL = null;

        ProgramaNuevasLocalHome programaNuevasLH = null;
        ProgramaNuevasLocal programaNuevasL = null;

        RequisitosProgramaNuevasLocalHome requisitosProgramaNuevasLH = null;
        RequisitosProgramaNuevasLocal requisitosProgramaNuevasL = null;

        ParametrosGeneralesPremiacionLocalHome parametrosGeneralesPremiacionLH = null;
        ParametrosGeneralesPremiacionLocal parametrosGeneralesPremiacionL = null;

        ParametrosNivelPremiacionLocal pnpL = null;
        ParametrosNivelPremiacionLocalHome pnpLH = null;

        try {
            concursoParametrosGeneralesLH = this.getConcursoParametrosGeneralesLocalHome();
            concursoParametrosGeneralesL = concursoParametrosGeneralesLH.findByPrimaryKey(oidConcurso);

            concursoParametrosGeneralesL.setTipoExigencia(DTOE.getOidTipoExigencia());
            
            concursoParametrosGeneralesLH.merge(concursoParametrosGeneralesL);

            //Se guarda el registro en ProgramaNuevas 
            if (DTOE.getOidProgramaNuevas() != null) { //modificacion
                programaNuevasLH = this.getProgramaNuevasLocalHome();
                programaNuevasL = programaNuevasLH.findByPrimaryKey(DTOE.getOidProgramaNuevas());

                programaNuevasL.setNumeroPedidosEvaluar(DTOE.getPeriodosEvaluar());
                programaNuevasL.setNumeroPedidosAPremiar(DTOE.getPedidosPremiar());
                programaNuevasL.setTipoRequisito(DTOE.getOidTipoRequisito());
                
                programaNuevasLH.merge(programaNuevasL);

                //Realizamos un find sobre la entidad INC:RequisitosProgramaNuevas para eliminar todos los registros e insertar los nuevos 
                requisitosProgramaNuevasLH = this.getRequisitosProgramaNuevasLocalHome();

                Collection colProgNvas = requisitosProgramaNuevasLH.findByProgramaNuevas(DTOE.getOidProgramaNuevas());
                RequisitosProgramaNuevasLocal registro = null;

                for (Iterator itcolProgNvas = colProgNvas.iterator(); itcolProgNvas.hasNext();) {
                    registro = (RequisitosProgramaNuevasLocal) itcolProgNvas.next();
                    requisitosProgramaNuevasLH.remove(registro);
                }

                parametrosGeneralesPremiacionLH = this.getParametrosGeneralesPremiacionLocalHome();
                pnpLH = this.getParametrosNivelPremiacionLocalHome();

                if ((DTOE.getListaPedidosPremiar() != null) && (DTOE.getListaPedidosPremiar().size() > 0)) {
                    for (int j = 0; j < DTOE.getListaPedidosPremiar().size(); j++) {
                        DTOPedidoPremiar registroA = (DTOPedidoPremiar) DTOE.getListaPedidosPremiar().get(j);

                        requisitosProgramaNuevasL = requisitosProgramaNuevasLH.create(registroA.getNumeroPedido(),
                                                                                      new BigDecimal(registroA.getExigenciaMinima().toString()),
                                                                                      DTOE.getOidProgramaNuevas());

                        //Obtenemos el nivel de premiación                                                                                    
                        if (registroA.getOidNivelPremiacion() != null) {
                            parametrosGeneralesPremiacionL = parametrosGeneralesPremiacionLH.findByUK(oidConcurso);
                            pnpL = pnpLH.findByUK(new Integer(registroA.getOidNivelPremiacion().intValue()), parametrosGeneralesPremiacionL.getOid());
    
                            requisitosProgramaNuevasL.setNivelPremiacion(pnpL.getOid());
                            requisitosProgramaNuevasLH.merge(requisitosProgramaNuevasL);
                        }
                    }
                }
            } else {
                programaNuevasLH = this.getProgramaNuevasLocalHome();
                programaNuevasL = programaNuevasLH.create(DTOE.getPeriodosEvaluar(), oidConcurso, DTOE.getOidTipoRequisito(), DTOE.getPedidosPremiar());

                if ((DTOE.getListaPedidosPremiar() != null) && (DTOE.getListaPedidosPremiar().size() > 0)) {
                    requisitosProgramaNuevasLH = this.getRequisitosProgramaNuevasLocalHome();

                    for (int j = 0; j < DTOE.getListaPedidosPremiar().size(); j++) {
                        DTOPedidoPremiar registroB = (DTOPedidoPremiar) DTOE.getListaPedidosPremiar().get(j);

                        requisitosProgramaNuevasL = requisitosProgramaNuevasLH.create(registroB.getNumeroPedido(),
                                                                                      new BigDecimal(registroB.getExigenciaMinima().toString()),
                                                                                      programaNuevasL.getOid());

                        //Obtenemos el nivel de premiación          
                        parametrosGeneralesPremiacionLH = this.getParametrosGeneralesPremiacionLocalHome();
                        pnpLH = this.getParametrosNivelPremiacionLocalHome();
                        parametrosGeneralesPremiacionL = parametrosGeneralesPremiacionLH.findByUK(oidConcurso);
                        if (registroB.getOidNivelPremiacion() != null) {
                            pnpL = pnpLH.findByUK(new Integer(registroB.getOidNivelPremiacion().intValue()), parametrosGeneralesPremiacionL.getOid());
    
                            requisitosProgramaNuevasL.setNivelPremiacion(pnpL.getOid());
                            requisitosProgramaNuevasLH.merge(requisitosProgramaNuevasL);
                        }
                    }
                }
            }
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException createException) {
            UtilidadesLog.error("ERROR ", createException);
            sessionContext.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONConcursoBean.guardarProgramaNuevas(DTOProgramaNuevas DTOE, Long oidConcurso): Salida");
    }


    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:       18/07/2005
     * @version     1.00
     * @autor       Cristian Valenzuela
     */
    public void guardarParametrosGerentes(DTOParametrosGerentes DTOE, Long oidConcurso)
            throws MareException {

        UtilidadesLog.info("MONConcursoBean.guardarParametrosGerentes(DTOParametrosGerentes DTOE, Long oidConcurso): Entrada");
        UtilidadesLog.debug("*** Entro a MONConcursoBean.guardarParametrosGerentes()");
        UtilidadesLog.debug("*** oidConcurso " + oidConcurso);
        UtilidadesLog.debug("*** DTOParametrosGerentes " + DTOE);

        // La base de calculo se guarda en la entidad ConcursoParametrosGenerales 
        ConcursoParametrosGeneralesLocalHome concursoParametrosGeneralesLH = null;
        ConcursoParametrosGeneralesLocal concursoParametrosGeneralesL = null;

        ConcursoParametrosGerentesLocalHome concursoParametrosGerentesLH = null;
        ConcursoParametrosGerentesLocal concursoParametrosGerentesL = null;

        try {
            concursoParametrosGeneralesLH = this.getConcursoParametrosGeneralesLocalHome();
            concursoParametrosGeneralesL = concursoParametrosGeneralesLH.findByPrimaryKey(oidConcurso);
            concursoParametrosGeneralesL.setBaseCalculo(DTOE.getOidBaseCalculo());
            
            concursoParametrosGeneralesLH.merge(concursoParametrosGeneralesL);

            //Se guarda el registro en ConcursoParametrosGerentes 
            if (DTOE.getOidParamGerentes() != null) { //modificacion 
                concursoParametrosGerentesLH = this.getConcursoParametrosGerentesLocalHome();
                concursoParametrosGerentesL = concursoParametrosGerentesLH.findByPrimaryKey(DTOE.getOidParamGerentes());

                //COPA_OID_PARA_GRAL
                concursoParametrosGerentesL.setConcurso(oidConcurso);

                //FCAL_OID_FORM_CALC
                concursoParametrosGerentesL.setFormaCalculo(DTOE.getOidFormaCalculo());

                //VAL_RECO_EFEC        
                concursoParametrosGerentesL.setRecomendacionEfectiva(DTOE.getIndRecomendacionEfectiva());

                //VAL_PERI_EVAL
                concursoParametrosGerentesL.setPeriodosEvaluacion(DTOE.getNumeroPeriodosEvaluar());

                //NUM_MINI_PEDI
                concursoParametrosGerentesL.setNumeroMinimoPedidos(DTOE.getNumeroMinimoPedidos());

                //NUM_MINI_PEDI_RECO
                concursoParametrosGerentesL.setNumeroMinimoPedidosRecomendada(DTOE.getNumeroMinimoPedidosRecomendada());

                //PERD_OID_PERI
                concursoParametrosGerentesL.setPeriodoInicialEvaluacion(DTOE.getOidPeriodoInicialEvaluacion());

                //TVEN_OID_TIPO_VENT 
                concursoParametrosGerentesL.setTipoVenta(DTOE.getOidTipoVenta());
                
                concursoParametrosGerentesLH.merge(concursoParametrosGerentesL);
            } else { //inserción    
                concursoParametrosGerentesLH = this.getConcursoParametrosGerentesLocalHome();

                //CREATE (COPA_OID_PARA_GRAL Y FCAL_OID_FORM_CALC)
                concursoParametrosGerentesL = concursoParametrosGerentesLH.create(oidConcurso, DTOE.getOidFormaCalculo());

                //VAL_RECO_EFEC  
                concursoParametrosGerentesL.setRecomendacionEfectiva(DTOE.getIndRecomendacionEfectiva());

                //VAL_PERI_EVAL
                concursoParametrosGerentesL.setPeriodosEvaluacion(DTOE.getNumeroPeriodosEvaluar());

                //NUM_MINI_PEDI
                concursoParametrosGerentesL.setNumeroMinimoPedidos(DTOE.getNumeroMinimoPedidos());

                //NUM_MINI_PEDI_RECO
                concursoParametrosGerentesL.setNumeroMinimoPedidosRecomendada(DTOE.getNumeroMinimoPedidosRecomendada());

                //PERD_OID_PERI
                concursoParametrosGerentesL.setPeriodoInicialEvaluacion(DTOE.getOidPeriodoInicialEvaluacion());

                //TVEN_OID_TIPO_VENT              
                concursoParametrosGerentesL.setTipoVenta(DTOE.getOidTipoVenta());
                
                concursoParametrosGerentesLH.merge(concursoParametrosGerentesL);
            }
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException createException) {
            UtilidadesLog.error("ERROR ", createException);
            sessionContext.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONConcursoBean.guardarParametrosGerentes(DTOParametrosGerentes DTOE, Long oidConcurso): Salida");
    }


    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:       31/05/2005
     * @version     1.00
     * @autor       Sergio C. Saavedra
     */
    public void guardarVariablesVenta(DTOVariablesVenta DTOE, Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarVariablesVenta(DTOVariablesVenta DTOE, Long oidConcurso):Entrada");
        //Se guarda el registro en la entidad INC:ConcursoVariableVentaGerente 
        try {
            ConcursoVariablesVentaGerentesLocalHome concursoVariablesVentaGerentesLH = null;
            ConcursoVariablesVentaGerentesLocal concursoVariablesVentaGerentesL = null;

            if (DTOE.getOid() != null) { //Modificacion
                concursoVariablesVentaGerentesLH = this.getConcursoVariablesVentaGerentesLocalHome();
                concursoVariablesVentaGerentesL = concursoVariablesVentaGerentesLH.findByPrimaryKey(DTOE.getOid());

                concursoVariablesVentaGerentesL.setActivas(DTOE.getIndActivas());
                concursoVariablesVentaGerentesL.setIngreso(DTOE.getIndIngreso());
                concursoVariablesVentaGerentesL.setReingreso(DTOE.getIndReingreso());
                concursoVariablesVentaGerentesL.setEgresos(DTOE.getIndEgresos());
                concursoVariablesVentaGerentesL.setEntregadas(DTOE.getIndEntregadas());
                concursoVariablesVentaGerentesL.setRecibidas(DTOE.getIndRecibidas());
                concursoVariablesVentaGerentesL.setCapitalizacion(DTOE.getIndCapitalizacion());
                concursoVariablesVentaGerentesL.setActivasFinales(DTOE.getIndActivasFinales());
                concursoVariablesVentaGerentesL.setActividad(DTOE.getIndActividad());
                concursoVariablesVentaGerentesL.setNumeroPedidos(DTOE.getIndNumeroPedidos());
                concursoVariablesVentaGerentesL.setPrecioPromedioUnitario(DTOE.getIndPrecioPromedioUnitario());
                concursoVariablesVentaGerentesL.setPromedioVentaPedido(DTOE.getIndPromedioVentaPedido());
                concursoVariablesVentaGerentesL.setPromedioUnidadesPedido(DTOE.getIndPromedioUnidadesPedido());
                concursoVariablesVentaGerentesL.setPromedioOrdenesPedido(DTOE.getIndPromedioOrdenesPedido());
                concursoVariablesVentaGerentesL.setRetencion(DTOE.getIndRetencion());
                concursoVariablesVentaGerentesL.setVentaEstadisticable(DTOE.getIndVentaEstadisticable());
                concursoVariablesVentaGerentesLH.merge(concursoVariablesVentaGerentesL);
            } else { //inserción 
                concursoVariablesVentaGerentesLH = this.getConcursoVariablesVentaGerentesLocalHome();
                concursoVariablesVentaGerentesL = concursoVariablesVentaGerentesLH.create(oidConcurso);

                concursoVariablesVentaGerentesL.setActivas(DTOE.getIndActivas());
                concursoVariablesVentaGerentesL.setIngreso(DTOE.getIndIngreso());
                concursoVariablesVentaGerentesL.setReingreso(DTOE.getIndReingreso());
                concursoVariablesVentaGerentesL.setEgresos(DTOE.getIndEgresos());
                concursoVariablesVentaGerentesL.setEntregadas(DTOE.getIndEntregadas());
                concursoVariablesVentaGerentesL.setRecibidas(DTOE.getIndRecibidas());
                concursoVariablesVentaGerentesL.setCapitalizacion(DTOE.getIndCapitalizacion());
                concursoVariablesVentaGerentesL.setActivasFinales(DTOE.getIndActivasFinales());
                concursoVariablesVentaGerentesL.setActividad(DTOE.getIndActividad());
                concursoVariablesVentaGerentesL.setNumeroPedidos(DTOE.getIndNumeroPedidos());
                concursoVariablesVentaGerentesL.setPrecioPromedioUnitario(DTOE.getIndPrecioPromedioUnitario());
                concursoVariablesVentaGerentesL.setPromedioVentaPedido(DTOE.getIndPromedioVentaPedido());
                concursoVariablesVentaGerentesL.setPromedioUnidadesPedido(DTOE.getIndPromedioUnidadesPedido());
                concursoVariablesVentaGerentesL.setPromedioOrdenesPedido(DTOE.getIndPromedioOrdenesPedido());
                concursoVariablesVentaGerentesL.setRetencion(DTOE.getIndRetencion());
                concursoVariablesVentaGerentesL.setVentaEstadisticable(DTOE.getIndVentaEstadisticable());
                concursoVariablesVentaGerentesLH.merge(concursoVariablesVentaGerentesL);
            }
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException createException) {
            UtilidadesLog.error("ERROR ", createException);
            sessionContext.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONConcursoBean.guardarVariablesVenta(DTOVariablesVenta DTOE, Long oidConcurso): Salida");
    }


    /**
     * Sistema:     Belcorp
     * Modulo:      INC
     * Fecha:       13/07/2005
     * @version     1.00
     * @autor       Cristian Valenzuela
     */
    public void guardarMultinivel(DTOMultinivel DTOE, Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarMultinivel(DTOMultinivel DTOE, Long oidConcurso):Entrada");
        UtilidadesLog.debug("****** MONConcursoBean.guardarMultinivel()");
        UtilidadesLog.debug("****** oidConcurso " + oidConcurso);
        UtilidadesLog.debug("****** DTOMultinivel " + DTOE);

        try {
            MultinivelLocalHome multLH = null;
            MultinivelLocal multL = null;

            PeriodoLocalHome periodoLH = this.getPeriodoLocalHome();
            PeriodoLocal periodoLDesde = null;
            PeriodoLocal periodoLHasta = null;

            PeriodoLocal periodoLDesdePago = null;
            PeriodoLocal periodoLHastaPago = null;

            if (DTOE.getOid() != null) { //COMIENZA MODIFICACION
                multLH = this.getMultinivelLocalHome();
                multL = multLH.findByPrimaryKey(DTOE.getOid());

                //NUM_PERI_PARA_CALC              
                multL.setPeriodosParaCalculo(DTOE.getPeriodosParaCalculo());

                //NUM_PERI_SOBR_CALC
                multL.setPeriodosSobreCalculo(DTOE.getPeriodosSobreCalculo());

                //NUM_MINI_RECO
                multL.setNumeroMinimoRecomendadas(DTOE.getNumeroMinimoRecomendadas());

                //IND_ACTI
                multL.setActividad(DTOE.getActividad());

                //if (DTOE.getActividad().booleanValue() == true) {
                    //IMP_MONT_MINI_PEDI_HIJA
                    multL.setMontoMinimoPedidoHijas(DTOE.getMontoMinimoPedidoHijas());

                    //NUM_UNID_MINI_PEDI_HIJA
                    multL.setUnidadesMinimasPedidoHijas(DTOE.getUnidadesMinimasPedidoHijas());
                //}Modificado por dmaneiro - 05/12/2005 - Inc. 21879 - Inc. 22081

                //COPA_OID_PARA_GRAL
                multL.setConcurso(oidConcurso);

                //PERD_OID_PERI y PERD_OID_PERI_DESD
                //(Pero antes se valida que el desde sea menor que el hasta)
                try {
                    periodoLDesde = periodoLH.findByPrimaryKey(DTOE.getOidPeriodoDesde());
                    periodoLHasta = periodoLH.findByPrimaryKey(DTOE.getOidPeriodoHasta());
                } catch (NoResultException nre) {
                     UtilidadesLog.error("ERROR ", nre);       
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                } 

                if ((periodoLDesde.getFechainicio().getTime() <= periodoLHasta.getFechainicio().getTime()) &&
                        (periodoLDesde.getFechaFin().getTime() <= periodoLHasta.getFechaFin().getTime())) {
                    multL.setPeriodoDesde(DTOE.getOidPeriodoDesde());
                    multL.setPeriodoHasta(DTOE.getOidPeriodoHasta());
                } else {
                    throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC + ErroresDeNegocio.INC_0002));
                }

                //CPRE_OID_CALC_PREM
                multL.setCalculoPremio(DTOE.getOidCalculoPremio());

                //IMP_MONT_MINI_PEDI_POR_HIJA                         
                multL.setMontoMinimoPedido(DTOE.getMontoMinimoPedidoPorHijas());

                //IMP_MONT_MINI_RED              
                multL.setMontoMinimoRed(DTOE.getMontoMinimoRed());

                //NUM_PEDI_MINI_RED
                multL.setPedidosMinimosRed(DTOE.getPedidosMinimosRed());

                //NUM_UNID_MINI_RED
                multL.setUnidadesMinimasRed(DTOE.getUnidadesMinimasRed());

                //IMP_MONT_MINI_MADR
                multL.setMontoMinimoMadre(DTOE.getMontoMinimoMadre());

                //NUM_PEDI_MINI_MADR
                multL.setPedidosMinimosMadre(DTOE.getPedidosMinimosMadre());

                //NUM_UNID_MINI_MADR            
                multL.setUnidadesMinimasMadre(DTOE.getUnidadesMinimasMadre());

                //NUM_PEDI_MINI_HIJA
                multL.setPedidosMinimosHijas(DTOE.getPedidosMinimosHijas());

                //NUM_UNID_MINI_HIJA
                multL.setUnidadesMinimasHijas(DTOE.getUnidadesMinimasHijas());

                //VAL_PORC_SOBR_VENT       
                multL.setPorcentajeSobreVenta(DTOE.getPorcentajeSobreVenta());

                //VAL_PORC_SOBR_COBR             
                multL.setPorcentajeSobreCobranza(DTOE.getPorcentajeSobreCobranza());

                //IND_PAGO_TIEM              
                multL.setPagoATiempo(DTOE.getPagoTiempo());

                //PERD_OID_PERI_TIEM_DESD
                //PERD_OID_PERI_TIEM_HAST              
                //***************** INICIO CAMBIOS INC 19781 ********************             
                if (DTOE.getPagoTiempo().booleanValue() == true) {
                    try {
                        periodoLDesdePago = periodoLH.findByPrimaryKey(DTOE.getOidPeriodoATiempoDesde());

                        if (DTOE.getOidPeriodoATiempoHasta() != null) {
                            periodoLHastaPago = periodoLH.findByPrimaryKey(DTOE.getOidPeriodoATiempoHasta());
                        }
                    } catch (NoResultException nre) {
                         UtilidadesLog.error("ERROR ", nre);       
                    } catch (PersistenceException ce) {
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    } 

                    if (periodoLHastaPago != null) {
                        if ((periodoLDesdePago.getFechainicio().getTime() <= periodoLHastaPago.getFechainicio().getTime()) &&
                                (periodoLDesdePago.getFechaFin().getTime() <= periodoLHastaPago.getFechaFin().getTime())) {
                            multL.setPeriodoATiempoDesde(DTOE.getOidPeriodoATiempoDesde());
                            multL.setPeriodoATiempoHasta(DTOE.getOidPeriodoATiempoHasta());
                        } else {
                            /*Al definir la pestaña Multinivel el período Hasta
                               Pago a Tiempo no debe ser inferior al período
                               Desde Pago a Tiempo*/
                            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC +
                                                                                                 ErroresDeNegocio.INC_0026));
                        }
                    } else {
                        multL.setPeriodoATiempoDesde(DTOE.getOidPeriodoATiempoDesde());
                        multL.setPeriodoATiempoHasta(DTOE.getOidPeriodoATiempoDesde());
                    }
                    
                }else{//Modificado por dmaneiro - 05/12/2005 - Inc. 21879 - Inc.22081
                    
                    multL.setPeriodoATiempoDesde(DTOE.getOidPeriodoATiempoDesde());
                    multL.setPeriodoATiempoHasta(DTOE.getOidPeriodoATiempoDesde());                   
                
                }
                
                //NUM_DIAS_GRAC
                multL.setDiasGracia(DTOE.getDiasGracia());

                //***************** FIN CAMBIOS INC 19781 ********************       
                //FINALIZA MODIFICACION
                 multLH.merge(multL);
            } else {
                //COMIENZA INSERCION
                multLH = this.getMultinivelLocalHome();

                //Primero se valida que el periodo desde sea menor que el hasta
                //De lo contrario se lanza una Exception
                try {
                    periodoLDesde = periodoLH.findByPrimaryKey(DTOE.getOidPeriodoDesde());
                    periodoLHasta = periodoLH.findByPrimaryKey(DTOE.getOidPeriodoHasta());
                } catch (NoResultException nre) {
                     UtilidadesLog.error("ERROR ", nre);       
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }

                if ((periodoLDesde.getFechainicio().getTime() > periodoLHasta.getFechainicio().getTime()) ||
                        (periodoLDesde.getFechaFin().getTime() > periodoLHasta.getFechaFin().getTime())) {
                    throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC + ErroresDeNegocio.INC_0002));
                }

                //Se realiza el create sobre la entidad 
                //(Campos que no permiten valor null)
                multL = multLH.create(DTOE.getPeriodosParaCalculo(), DTOE.getPeriodosSobreCalculo(), DTOE.getNumeroMinimoRecomendadas(),
                                      DTOE.getActividad(), oidConcurso, DTOE.getOidPeriodoHasta(), DTOE.getOidPeriodoDesde(),
                                      DTOE.getOidCalculoPremio());

                //Se setean el resto de los campos 
                //(Campos que permiten valor null)
                //IMP_MONT_MINI_PEDI_POR_HIJA                         
                multL.setMontoMinimoPedido(DTOE.getMontoMinimoPedidoPorHijas());

                //if (DTOE.getActividad().booleanValue() == true) {
                    //IMP_MONT_MINI_PEDI_HIJA
                    multL.setMontoMinimoPedidoHijas(DTOE.getMontoMinimoPedidoHijas());

                    //NUM_UNID_MINI_PEDI_HIJA
                    multL.setUnidadesMinimasPedidoHijas(DTOE.getUnidadesMinimasPedidoHijas());
                //}Modificado por dmaneiro - 05/12/2005 - Inc. 21879 - Inc. 22081

                //IMP_MONT_MINI_RED              
                multL.setMontoMinimoRed(DTOE.getMontoMinimoRed());

                //NUM_PEDI_MINI_RED
                multL.setPedidosMinimosRed(DTOE.getPedidosMinimosRed());

                //NUM_UNID_MINI_RED
                multL.setUnidadesMinimasRed(DTOE.getUnidadesMinimasRed());

                //IMP_MONT_MINI_MADR
                multL.setMontoMinimoMadre(DTOE.getMontoMinimoMadre());

                //NUM_PEDI_MINI_MADR
                multL.setPedidosMinimosMadre(DTOE.getPedidosMinimosMadre());

                //NUM_UNID_MINI_MADR            
                multL.setUnidadesMinimasMadre(DTOE.getUnidadesMinimasMadre());

                //NUM_PEDI_MINI_HIJA
                multL.setPedidosMinimosHijas(DTOE.getPedidosMinimosHijas());

                //NUM_UNID_MINI_HIJA
                multL.setUnidadesMinimasHijas(DTOE.getUnidadesMinimasHijas());

                //VAL_PORC_SOBR_VENT       
                multL.setPorcentajeSobreVenta(DTOE.getPorcentajeSobreVenta());

                //VAL_PORC_SOBR_COBR             
                multL.setPorcentajeSobreCobranza(DTOE.getPorcentajeSobreCobranza());

                //IND_PAGO_TIEM              
                multL.setPagoATiempo(DTOE.getPagoTiempo());

                //PERD_OID_PERI_TIEM_DESD
                //PERD_OID_PERI_TIEM_HAST             
                //***************** INICIO CAMBIOS INCIDENCIA 19781              
                if (DTOE.getPagoTiempo().booleanValue() == true) {
                    try {
                        periodoLDesdePago = periodoLH.findByPrimaryKey(DTOE.getOidPeriodoATiempoDesde());

                        if (DTOE.getOidPeriodoATiempoHasta() != null) {
                            periodoLHastaPago = periodoLH.findByPrimaryKey(DTOE.getOidPeriodoATiempoHasta());
                        }
                    } catch (NoResultException nre) {
                         UtilidadesLog.error("ERROR ", nre);       
                    } catch (PersistenceException ce) {
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    } 
                    
                    if (periodoLHastaPago != null) {
                        if ((periodoLDesdePago.getFechainicio().getTime() <= periodoLHastaPago.getFechainicio().getTime()) &&
                                (periodoLDesdePago.getFechaFin().getTime() <= periodoLHastaPago.getFechaFin().getTime())) {
                            multL.setPeriodoATiempoDesde(DTOE.getOidPeriodoATiempoDesde());
                            multL.setPeriodoATiempoHasta(DTOE.getOidPeriodoATiempoHasta());
                        } else {
                            /*Al definir la pestaña Multinivel el período Hasta
                               Pago a Tiempo no debe ser inferior al período
                               Desde Pago a Tiempo*/
                            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC +
                                                                                                 ErroresDeNegocio.INC_0026));
                        }
                    } else {
                        multL.setPeriodoATiempoDesde(DTOE.getOidPeriodoATiempoDesde());
                        multL.setPeriodoATiempoHasta(DTOE.getOidPeriodoATiempoDesde());
                    }
                    
                }else{//Modificado por dmaneiro - 05/12/2005 - Inc. 21879 - Inc.22081
                    
                    multL.setPeriodoATiempoDesde(DTOE.getOidPeriodoATiempoDesde());
                    multL.setPeriodoATiempoHasta(DTOE.getOidPeriodoATiempoDesde());                   
                
                }
                
                //NUM_DIAS_GRAC
                multL.setDiasGracia(DTOE.getDiasGracia());

                //***************** FIN CAMBIOS INCIDENCIA 19781                
                 multLH.merge(multL);
            } //FINALIZA INSERCION
        UtilidadesLog.info("MONConcursoBean.guardarMultinivel(DTOMultinivel DTOE, Long oidConcurso): Salida");
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException createException) {
            UtilidadesLog.error("ERROR ", createException);
            sessionContext.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    /**
           * Sistema:     Belcorp
           * Modulo:      INC
           * Fecha:       01/06/2005
           * @version     1.00
           * @autor       Sergio C. Saavedra
           */
    public void guardarVariablesVentaProyectada(DTOVariablesVentaProyectada DTOE, Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarVariablesVentaProyectada(DTOVariablesVentaProyectada DTOE, Long oidConcurso): Entrada");
        UtilidadesLog.debug("**************** MONConcursoBean.guardarVariablesVentaProyectada()");
        UtilidadesLog.debug("**************** DTOVariablesVentaProyectada " + DTOE);
        UtilidadesLog.debug("**************** oidConcurso " + oidConcurso);

        try {
            ConcursoVariablesVentaProyectadaLocalHome cvvpLH = null;
            ConcursoVariablesVentaProyectadaLocal cvvpL = null;

            if (DTOE.getOid() != null) { //modificacion 
                cvvpLH = this.getConcursoVariablesVentaProyectadaLocalHome();
                cvvpL = cvvpLH.findByPrimaryKey(DTOE.getOid());

                cvvpL.setActivas(DTOE.getIndActivas());
                cvvpL.setIngreso(DTOE.getIndIngreso());
                cvvpL.setReingreso(DTOE.getIndReingreso());
                cvvpL.setEgresos(DTOE.getIndEgresos());
                cvvpL.setEntregadas(DTOE.getIndEntregadas());
                cvvpL.setRecibidas(DTOE.getIndRecibidas());
                cvvpL.setCapitalizacion(DTOE.getIndCapitalizacion());
                cvvpL.setActivasFinales(DTOE.getIndActivasFinales());
                cvvpL.setActividad(DTOE.getIndActividad());
                cvvpL.setNumeroPedidos(DTOE.getIndNumeroPedidos());
                cvvpL.setPrecioPromedioUnitario(DTOE.getIndPrecioPromedioUnitario());
                cvvpL.setPromedioVentaPedido(DTOE.getIndPromedioVentaPedido());
                cvvpL.setPromedioUnidadesPedido(DTOE.getIndPromedioUnidadesPedido());
                cvvpL.setPromedioOrdenesPedido(DTOE.getIndPromedioOrdenesPedido());
                cvvpL.setRetencion(DTOE.getIndRetencion());
                cvvpL.setVentaEstadisticable(DTOE.getIndVentaEstadisticable());
                cvvpL.setConcurso(oidConcurso);
                cvvpLH.merge(cvvpL);
            } else { //inserción 
                cvvpLH = this.getConcursoVariablesVentaProyectadaLocalHome();
                cvvpL = cvvpLH.create( //new String("falta este campo en el dto"),
                                    DTOE.getIndActivas(), DTOE.getIndIngreso(), DTOE.getIndReingreso(), DTOE.getIndEgresos(), DTOE.getIndEntregadas(),
                                    DTOE.getIndRecibidas(), DTOE.getIndCapitalizacion(), DTOE.getIndActivasFinales(), DTOE.getIndActividad(), DTOE.getIndNumeroPedidos(),
                                    DTOE.getIndPrecioPromedioUnitario(), DTOE.getIndPromedioVentaPedido(), DTOE.getIndPromedioOrdenesPedido(),
                                    DTOE.getIndPromedioUnidadesPedido(), DTOE.getIndRetencion(), DTOE.getIndVentaEstadisticable(), 
                                    //new Boolean(true),  ///y este tambien!!
                                    oidConcurso);

                //create(String valFichVentProy, Boolean indActi, Boolean indIngr, Boolean indRein, 
                //       Boolean indEgre, Boolean indEntr, Boolean indReci, Boolean indCapi, 
                //       Boolean indActiFina, Boolean indAdad, Boolean indNumePedi, 
                //       Boolean indPrecPromUnit, Boolean indPromVentPedi, Boolean indPromOrdePedi, 
                //       Boolean indPromUnidPedi, Boolean indRete, Boolean indVentEsta, 
                //       Boolean indMetaModi, Long copaOidParaGral)               
            }
         } catch (NoResultException fe) {
             UtilidadesLog.error("ERROR ", fe);
             throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException createException) {
            UtilidadesLog.error("ERROR ", createException);
            sessionContext.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONConcursoBean.guardarVariablesVentaProyectada(DTOVariablesVentaProyectada DTOE, Long oidConcurso): Salida");
    }

    public void guardarProductos(DTOConcurso DTOE, Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarProductos(DTOConcurso DTOE, Long oidConcurso): Entrada");
        //busqueda en mensajes
        MensajesLocal msgL = null;
        MensajesLocalHome msgLH = this.getMensajesLocalHome();

        ProductosLocal productosL = null;
        ProductosLocalHome productosLH = this.getProductosLocalHome();

        if (DTOE.getIndObligProductosValidos().booleanValue()) {
            if (DTOE.getProductosValidos().getCodigoMensaje() != null) {
                try {
                    if ((DTOE.getProductosValidos().getIndComunicacion() != null) &&
                            DTOE.getProductosValidos().getIndComunicacion().booleanValue()) {
                        msgL = msgLH.findByUk(DTOE.getOidPais(), DTOE.getProductosValidos().getCodigoMensaje());
                    }
                } catch (NoResultException fe) {
                    UtilidadesLog.error("ERROR ", fe);
                    throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0008));
                }  catch (PersistenceException ce) {
                     UtilidadesLog.error("ERROR ", ce);
                     throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }

            try {
                productosL = productosLH.findByUK(oidConcurso);

                productosL.setComunicacionValidos(DTOE.getProductosValidos().getIndComunicacion());
                productosL.setMensajeValidos(DTOE.getProductosValidos().getCodigoMensaje());
                productosLH.merge(productosL);
            } catch (NoResultException fe) {
                //no existe el producto....
                try {
                    productosL = productosLH.create(oidConcurso);
                    productosL.setComunicacionValidos(DTOE.getProductosValidos().getIndComunicacion());
                    productosL.setMensajeValidos(DTOE.getProductosValidos().getCodigoMensaje());
                    productosLH.merge(productosL);
                } catch (PersistenceException createException) {
                    UtilidadesLog.error("ERROR ", createException);
                    sessionContext.setRollbackOnly();
                    throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            //Llamar al método guardarProductosValidos....
            DTOProducto param = DTOE.getProductosValidos();

            if (DTOE.getOidPais() != null) {
                param.setOidPais(DTOE.getOidPais());
            }

            this.guardarProductosValidos(param, oidConcurso);
        }

        //
        if (DTOE.getIndObligProductosExcluidos().booleanValue()) {
            // Modificado por ssantana, 21/6/2005
            if (DTOE.getProductosExcluidos().getCodigoMensaje() != null) {
                //if (DTOE.getProductosValidos().getCodigoMensaje()!= null) {
                try {
                    if ((DTOE.getProductosExcluidos().getIndComunicacion() != null) &&
                            DTOE.getProductosExcluidos().getIndComunicacion().booleanValue()) {
                        msgL = msgLH.findByUk(DTOE.getOidPais(), DTOE.getProductosExcluidos().getCodigoMensaje());
                    }
                } catch (NoResultException fe) {
                    UtilidadesLog.error("ERROR ", fe);
                    throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0309));
                }  catch (PersistenceException ce) {
                     UtilidadesLog.error("ERROR ", ce);
                     throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }

            try {
                productosL = productosLH.findByUK(oidConcurso);

                productosL.setComunicacionExcluidos(DTOE.getProductosExcluidos().getIndComunicacion());
                productosL.setMensajeExcluidos(DTOE.getProductosExcluidos().getCodigoMensaje());
                productosLH.merge(productosL);
            } catch (NoResultException fe) {
                //no existe el producto....
                try {
                    productosL = productosLH.create(oidConcurso);
                    productosL.setComunicacionExcluidos(DTOE.getProductosExcluidos().getIndComunicacion());
                    productosL.setMensajeExcluidos(DTOE.getProductosExcluidos().getCodigoMensaje());
                    productosLH.merge(productosL);
                } catch (PersistenceException createException) {
                    UtilidadesLog.error("ERROR ", createException);
                    sessionContext.setRollbackOnly();
                    throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            //Llamar al método guardarProductosExcluidos....
            DTOProducto param = DTOE.getProductosExcluidos();

            if (DTOE.getOidPais() != null) {
                param.setOidPais(DTOE.getOidPais());
            }

            this.guardarProductosExcluidos(param, oidConcurso);
        }

        //
        if (DTOE.getIndObligProductosBonificados().booleanValue()) {
            // Modificado por ssantana, 21/6/2005
            if (DTOE.getProductosBonificados().getCodigoMensaje() != null) {
                //if (DTOE.getProductosValidos().getCodigoMensaje()!= null) {              
                try {
                    if ((DTOE.getProductosBonificados().getIndComunicacion() != null) &&
                            DTOE.getProductosBonificados().getIndComunicacion().booleanValue()) {
                        msgL = msgLH.findByUk(DTOE.getOidPais(), DTOE.getProductosBonificados().getCodigoMensaje());
                    }
                } catch (NoResultException fe) {
                    UtilidadesLog.error("ERROR ", fe);
                    throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0010));
                }  catch (PersistenceException ce) {
                     UtilidadesLog.error("ERROR ", ce);
                     throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }

            try {
                productosL = productosLH.findByUK(oidConcurso);

                productosL.setComunicacionBonificados(DTOE.getProductosBonificados().getIndComunicacion());
                productosL.setMensajeBonificados(DTOE.getProductosBonificados().getCodigoMensaje());
                productosLH.merge(productosL);
            } catch (NoResultException fe) {
                //no existe el producto....
                try {
                    productosL = productosLH.create(oidConcurso);
                    productosL.setComunicacionBonificados(DTOE.getProductosBonificados().getIndComunicacion());
                    productosL.setMensajeBonificados(DTOE.getProductosBonificados().getCodigoMensaje());
                    productosLH.merge(productosL);
                } catch (PersistenceException createException) {
                    UtilidadesLog.error("ERROR ", createException);
                    sessionContext.setRollbackOnly();
                    throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            //Llamar al método guardarProductosBonificados....
            DTOProducto param = DTOE.getProductosBonificados();

            if (DTOE.getOidPais() != null) {
                param.setOidPais(DTOE.getOidPais());
            }

            this.guardarProductosBonificados(param, oidConcurso);
        }

        //
        if (DTOE.getIndObligProductosExigidos().booleanValue()) {
            // Modificado por ssantana, 21/6/2005
            if (DTOE.getProductosExigidos().getCodigoMensaje() != null) {
                //if (DTOE.getProductosValidos().getCodigoMensaje()!= null) {              
                try {
                    if ((DTOE.getProductosExigidos().getIndComunicacion() != null) &&
                            DTOE.getProductosExigidos().getIndComunicacion().booleanValue()) {
                        msgL = msgLH.findByUk(DTOE.getOidPais(), DTOE.getProductosExigidos().getCodigoMensaje());
                    }
                } catch (NoResultException fe) {
                    UtilidadesLog.error("ERROR ", fe);
                    throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0011));
                }  catch (PersistenceException ce) {
                     UtilidadesLog.error("ERROR ", ce);
                     throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }

            try {
                productosL = productosLH.findByUK(oidConcurso);

                productosL.setComunicacionExigidos(DTOE.getProductosExigidos().getIndComunicacion());
                productosL.setMensajeExigidos(DTOE.getProductosExigidos().getCodigoMensaje());
                productosLH.merge(productosL);
            } catch (NoResultException fe) {
                //no existe el producto....
                try {
                    productosL = productosLH.create(oidConcurso);
                    productosL.setComunicacionExigidos(DTOE.getProductosExigidos().getIndComunicacion());
                    productosL.setMensajeExigidos(DTOE.getProductosExigidos().getCodigoMensaje());
                    productosLH.merge(productosL);
                } catch (PersistenceException createException) {
                    UtilidadesLog.error("ERROR ", createException);
                    sessionContext.setRollbackOnly();
                    throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            //Llamar al método guardarProductosExigidos....
            DTOProducto param = DTOE.getProductosExigidos();

            if (DTOE.getOidPais() != null) {
                param.setOidPais(DTOE.getOidPais());
            }

            this.guardarProductosExigidos(param, oidConcurso);
        }

        //
        if (DTOE.getIndObligProductosACalificar().booleanValue()) {
            // Modificado por ssantana, 21/6/2005
            if (DTOE.getProductosACalificar().getCodigoMensaje() != null) {
                //if (DTOE.getProductosValidos().getCodigoMensaje()!= null) {
                try {
                    if ((DTOE.getProductosACalificar().getIndComunicacion() != null) &&
                            DTOE.getProductosACalificar().getIndComunicacion().booleanValue()) {
                        msgL = msgLH.findByUk(DTOE.getOidPais(), DTOE.getProductosACalificar().getCodigoMensaje());
                    }
                } catch (NoResultException fe) {
                    UtilidadesLog.error("ERROR ", fe);
                    throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0012));
                }  catch (PersistenceException ce) {
                     UtilidadesLog.error("ERROR ", ce);
                     throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }

            DTOProducto param = DTOE.getProductosACalificar();

            if (DTOE.getOidPais() != null) {
                param.setOidPais(DTOE.getOidPais());
            }

            this.guardarProductosACalificar(DTOE.getProductosACalificar(), oidConcurso);
        }

        if (DTOE.getIndObligProductosExcluidosCalificacion().booleanValue()) {
            // Modificado por ssantana, 21/6/2005
            if (DTOE.getProductosExcluidosCalificacion().getCodigoMensaje() != null) {
                //if (DTOE.getProductosValidos().getCodigoMensaje()!= null) {
                try {
                    if ((DTOE.getProductosExcluidosCalificacion().getIndComunicacion() != null) &&
                            DTOE.getProductosExcluidosCalificacion().getIndComunicacion().booleanValue()) {
                        msgL = msgLH.findByUk(DTOE.getOidPais(), DTOE.getProductosExcluidosCalificacion().getCodigoMensaje());
                    }
                } catch (NoResultException fe) {
                    UtilidadesLog.error("ERROR ", fe);
                    throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0013));
                }  catch (PersistenceException ce) {
                     UtilidadesLog.error("ERROR ", ce);
                     throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }

            DTOProducto param = DTOE.getProductosExcluidosCalificacion();

            if (DTOE.getOidPais() != null) {
                param.setOidPais(DTOE.getOidPais());
            }

            this.guardarProductosExcluidosCalificacion(param, oidConcurso);
        }
        UtilidadesLog.info("MONConcursoBean.guardarProductos(DTOConcurso DTOE, Long oidConcurso): Salida");
    }

    public void actualizarEstadoPlantilla(DTOPlantilla DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.actualizarEstadoPlantilla(DTOPlantilla DTOE): Entrada");
        //Se actualiza la entidad Plantilla Concurso activando el indicador bloqueado 
        PlantillaConcursoLocalHome plantillaConcursoLH = null;
        PlantillaConcursoLocal plantillaConcurso = null;

        try {
            Long oidPlantilla = DTOE.getOidPlantilla();
            plantillaConcursoLH = this.getPlantillaConcursoLocalHome();
            plantillaConcurso = plantillaConcursoLH.findByPrimaryKey(DTOE.getOidPlantilla());
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(sCodigoError));
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        plantillaConcurso.setBloqueado(DTOE.getIndBloqueado());
        plantillaConcursoLH.merge(plantillaConcurso);
        UtilidadesLog.info("MONConcursoBean.actualizarEstadoPlantilla(DTOPlantilla DTOE): Salida");
    }


    public void guardarProductosValidos(DTOProducto DTOE, Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarProductosValidos(DTOProducto DTOE, Long oidConcurso): Entrada");
        UtilidadesLog.debug("dentro de guardarProductosValidos, recibo : " + 
        DTOE + ", y el concurso: " + oidConcurso);

        try {
            ProductosLocal productosL = null;
            ProductosLocalHome productosLH = this.getProductosLocalHome();

            ProductosValidosLocal productosVL = null;
            ProductosValidosLocalHome productosVLH = this.getProductosValidosLocalHome();

            try {
                productosL = productosLH.findByUK(oidConcurso);
            } catch (NoResultException fe) {
                //Lo acabo de Crear Deberia de Existir
             } catch (PersistenceException ce) {
                 UtilidadesLog.error("ERROR ", ce);
                 throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));

            }

            //remove de todos los producto Validos...
            Collection colProd = productosVLH.findByProducto(productosL.getOid());

            if (!colProd.isEmpty()) {
                Iterator itProdVal = colProd.iterator();

                while (itProdVal.hasNext()) {
                    ProductosValidosLocal registro = (ProductosValidosLocal) itProdVal.next();
                    productosVLH.remove(registro);
                }
            }

            MaestroProductosLocal mProductosL = null;
            MaestroProductosLocalHome mProductosLH = this.getMaestroProductosLocalHome();
            Long producto = null;

            for (int j = 0; j < DTOE.getLstProductos().size(); j++) {
                DTOProdu registro = (DTOProdu) DTOE.getLstProductos().get(j);

                //valido, codigo de producto....
                if (registro.getOidProducto() == null) {
                    //busco: codigoProducto 
                    if ((registro.getCodigoProducto() != null) && (registro.getCodigoProducto().length() > 0)) {
                        //Modificado por incidencia 20508
                        try {
                            mProductosL = mProductosLH.findByUK(DTOE.getOidPais(), registro.getCodigoProducto());
                            producto = mProductosL.getOid();
                        }
                        catch (FinderException fe) {
                            UtilidadesLog.error("ERROR ", fe);
                            /*ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(),
                            UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "",
                            ErroresDeNegocio.INC_0340));*/
                            
                            ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(),
                            UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "",
                            ErroresDeNegocio.INC_0046));

                            ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                            ex.addParameter(registro.getCodigoProducto());

                            throw ex;
                        }
                        //Fin - Modificado por incidencia 20508
                    }
                    else {
                        producto = null;
                    }
                } else {
                    producto = registro.getOidProducto();
                }

                productosVL = productosVLH.create(productosL.getOid());
                productosVL.setMarcaProducto(registro.getOidMarcaProducto());
                productosVL.setCicloVida(registro.getOidCicloVida());
                productosVL.setGenerico(registro.getOidGenerico());
                productosVL.setMarcaProducto(registro.getOidMarcaProducto());
                productosVL.setNegocio(registro.getOidNegocio());
                productosVL.setSupergenerico(registro.getOidSupergenerico());
                productosVL.setTipoOferta(registro.getOidTipoOferta());
                productosVL.setUnidadNegocio(registro.getOidUnidadNegocio());

                productosVL.setCodigoProducto(producto);
                productosVLH.merge(productosVL);
            }
        } catch (NamingException ne) {
            UtilidadesLog.error("ERROR ", ne);
            throw new MareException(ne, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (FinderException fe) {
            UtilidadesLog.error("ERROR ", fe);
            String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(sCodigoError));
        } catch (PersistenceException createException) {
            UtilidadesLog.error("ERROR ", createException);
            sessionContext.setRollbackOnly();
            throw new MareException(createException, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONConcursoBean.guardarProductosValidos(DTOProducto DTOE, Long oidConcurso): Salida");
    }


    public void guardarProductosExcluidos(DTOProducto DTOE, Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarProductosExcluidos(DTOProducto DTOE, Long oidConcurso): Entrada");
        UtilidadesLog.debug("dentro de guardarProductosExcluidos, recibo : " + 
        DTOE + ", y el concurso: " + oidConcurso);

        try {
            ProductosLocal productosL = null;
            ProductosLocalHome productosLH = this.getProductosLocalHome();

            try {
                productosL = productosLH.findByUK(oidConcurso);
            } catch (NoResultException fe) {
                //Lo acabo de Crear Deberia de Existir
             } catch (PersistenceException ce) {
                 UtilidadesLog.error("ERROR ", ce);
                 throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            ProductosExcluidosLocal productosEL = null;
            ProductosExcluidosLocalHome productosELH = this.getProductosExcluidosLocalHome();

            //remove de todos los producto Excluidos...
            Collection colProd = productosELH.findByProducto(productosL.getOid());

            if (!colProd.isEmpty()) {
                Iterator itProdVal = colProd.iterator();

                while (itProdVal.hasNext()) {
                    ProductosExcluidosLocal registro = (ProductosExcluidosLocal) itProdVal.next();
                    productosELH.remove(registro);
                }
            }

            MaestroProductosLocal mProductosL = null;
            MaestroProductosLocalHome mProductosLH = this.getMaestroProductosLocalHome();
            Long producto = null;

            PeriodoLocalHome periodoLH = this.getPeriodoLocalHome();
            PeriodoLocal periodoLDesde = null;
            PeriodoLocal periodoLHasta = null;

            for (int j = 0; j < DTOE.getLstProductos().size(); j++) {
                DTOProdu registro = (DTOProdu) DTOE.getLstProductos().get(j);

                if (registro.getOidProducto() == null) {
                    //busco: codigoProducto 
                    if ((registro.getCodigoProducto() != null) && (registro.getCodigoProducto().length() > 0)) {
                        //Modificado por incidencia 20508
                        try {
                            mProductosL = mProductosLH.findByUK(DTOE.getOidPais(), registro.getCodigoProducto());
                            producto = mProductosL.getOid();
                        }
                        catch (FinderException fe) {
                            UtilidadesLog.error("ERROR ", fe);
                            /*ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(),                            * 
                            UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "",
                            ErroresDeNegocio.INC_0341));*/
                            
                            ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(),
                            UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "",
                            ErroresDeNegocio.INC_0042));

                            ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                            ex.addParameter(registro.getCodigoProducto());

                            throw ex;
                        }
                        //Fin - Modificado por incidencia 20508
                    } else {
                        producto = null;
                    }
                } else {
                    producto = registro.getOidProducto();
                }

                // Validación de peridodo desde menor que periodo hasta
                if ((registro.getOidPeriodoDesde() != null) && (registro.getOidPeriodoHasta() != null)) {
                    periodoLDesde = periodoLH.findByPrimaryKey(registro.getOidPeriodoDesde());
                    periodoLHasta = periodoLH.findByPrimaryKey(registro.getOidPeriodoHasta());

                    if (!((periodoLDesde.getFechainicio().getTime() <= periodoLHasta.getFechainicio().getTime()) &&
                            (periodoLDesde.getFechaFin().getTime() <= periodoLHasta.getFechaFin().getTime()))) {
                        throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC + ErroresDeNegocio.INC_0333));
                    }
                }

                productosEL = productosELH.create(productosL.getOid());

                productosEL.setPeriodoDesde(registro.getOidPeriodoDesde());
                productosEL.setPeriodoHasta(registro.getOidPeriodoHasta());
                productosEL.setCicloVida(registro.getOidCicloVida());
                productosEL.setGenerico(registro.getOidGenerico());
                productosEL.setMarcaProducto(registro.getOidMarcaProducto());
                productosEL.setNegocio(registro.getOidNegocio());
                productosEL.setCodigoProducto(producto);
                productosEL.setSupergenerico(registro.getOidSupergenerico());
                productosEL.setTipoOferta(registro.getOidTipoOferta());
                productosEL.setUnidadNegocio(registro.getOidUnidadNegocio());
                productosELH.merge(productosEL);
            }
        } catch (NamingException ne) {
            UtilidadesLog.error("ERROR ", ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (FinderException fe) {
            UtilidadesLog.error("ERROR ", fe);
            String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(sCodigoError));
        } catch (PersistenceException createException) {
            UtilidadesLog.error("ERROR ", createException);
            sessionContext.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONConcursoBean.guardarProductosExcluidos(DTOProducto DTOE, Long oidConcurso): Salida");
    }


    public void guardarProductosBonificados(DTOProducto DTOE, Long oidConcurso)
            throws MareException {
        
        UtilidadesLog.info("MONConcursoBean.guardarProductosBonificados(DTOProducto DTOE, Long oidConcurso): Entrada");
        UtilidadesLog.debug("***** MONConcursoBean.guardarProductosBonificados()");
        UtilidadesLog.debug("***** DTOProducto: " + DTOE);
        UtilidadesLog.debug("***** oidConcurso: " + oidConcurso);

        try {
            ProductosLocal productosL = null;
            ProductosLocalHome productosLH = this.getProductosLocalHome();

            try {
                productosL = productosLH.findByUK(oidConcurso);
            } catch (NoResultException fe) {
                //Lo acabo de Crear Deberia de Existir
             } catch (PersistenceException ce) {
                 UtilidadesLog.error("ERROR ", ce);
                 throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            ProductosBonificadosLocal productosBL = null;
            ProductosBonificadosLocalHome productosBLH = this.getProductosBonificadosLocalHome();

            //remove de todos los producto Bonificados...
            Collection colProd = productosBLH.findByProducto(productosL.getOid());
            UtilidadesLog.debug("***** despues de findByProducto");

            if (!colProd.isEmpty()) {
                UtilidadesLog.debug("***** entro al if para borrar");

                Iterator itProdVal = colProd.iterator();

                while (itProdVal.hasNext()) {
                    UtilidadesLog.debug("***** entro al while para el remove");

                    ProductosBonificadosLocal registro = (ProductosBonificadosLocal) itProdVal.next();
                    productosBLH.remove(registro);
                }
            }

            MaestroProductosLocal mProductosL = null;
            MaestroProductosLocalHome mProductosLH = this.getMaestroProductosLocalHome();
            Long producto = null;

            for (int j = 0; j < DTOE.getLstProductos().size(); j++) {
                DTOProdu registro = (DTOProdu) DTOE.getLstProductos().get(j);
                UtilidadesLog.debug("***** DTOProdu");

                //busco: codigoProducto 
                if (registro.getOidProducto() == null) {
                    UtilidadesLog.debug("***** registro.getOidProducto() es nulo");

                    if ((registro.getCodigoProducto() != null) && (registro.getCodigoProducto().length() > 0)) {
                        //Agregado por incidencia 20508
                        try {
                            UtilidadesLog.debug("***** registro.getOidProducto() es distinto de nulo");
                            mProductosL = mProductosLH.findByUK(DTOE.getOidPais(), registro.getCodigoProducto());
                            producto = mProductosL.getOid();                            
                        }
                        catch (FinderException fe) {
                            UtilidadesLog.error("ERROR ", fe);
                            
                            ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(), 
                            UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", 
                            ErroresDeNegocio.INC_0041));

                            ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                            ex.addParameter(registro.getCodigoProducto());
                            throw ex;        
                        }                     
                        //Fin - Agregado por incidencia 20508
                    } else {
                        UtilidadesLog.debug("***** poniendo producto en nulo");
                        producto = null;
                    }
                } else {
                    producto = registro.getOidProducto();
                }

                //JRIVAS 18/7/2005
                //Inc 18270
                PeriodoLocalHome periodoLH = this.getPeriodoLocalHome();
                PeriodoLocal periodoLDesde = null;
                PeriodoLocal periodoLHasta = null;
                Long pDesde = null;
                Long pHasta = null;

                try {
                    periodoLDesde = periodoLH.findByPrimaryKey(registro.getOidPeriodoDesde());
                    periodoLHasta = periodoLH.findByPrimaryKey(registro.getOidPeriodoHasta());
                } catch (NoResultException nre) {
                    //throw new MareException(fe, UtilidadesError.
                    //                            armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                 } catch (PersistenceException ce) {
                     UtilidadesLog.error("ERROR ", ce);
                     throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                 } 

                if (periodoLHasta != null) {
                    if ((periodoLDesde.getFechainicio().getTime() <= periodoLHasta.getFechainicio().getTime()) &&
                            (periodoLDesde.getFechaFin().getTime() <= periodoLHasta.getFechaFin().getTime())) {
                        pDesde = periodoLDesde.getOid();
                        pHasta = periodoLHasta.getOid();
                    } else {
                        throw new MareException(null, null, 
                        UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC + 
                        ErroresDeNegocio.INC_0335));
                    }
                } else {
                    pDesde = periodoLDesde.getOid();
                    pHasta = periodoLDesde.getOid();
                }

                UtilidadesLog.debug("***** Haciendo el create de ProductosBonificados");
                productosBL = productosBLH.create(registro.getPuntosUnidad(), 
                registro.getFactorMultiplicidad(), pDesde, pHasta, productosL.getOid());

                UtilidadesLog.debug("***** Seteando el resto de los campos");

                productosBL.setCicloVida(registro.getOidCicloVida());
                productosBL.setGenerico(registro.getOidGenerico());
                productosBL.setMarcaProducto(registro.getOidMarcaProducto());
                productosBL.setNegocio(registro.getOidNegocio());
                productosBL.setCodigoProducto(producto);
                productosBL.setSupergenerico(registro.getOidSupergenerico());
                productosBL.setTipoOferta(registro.getOidTipoOferta());
                productosBL.setUnidadNegocio(registro.getOidUnidadNegocio());
                productosBLH.merge(productosBL);
            }
        }
        catch (NamingException ne) {
            UtilidadesLog.error("ERROR ", ne);
            throw new MareException(ne, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONConcursoBean.guardarProductosBonificados(DTOProducto DTOE, Long oidConcurso): Salida");
    }


    public void guardarProductosExigidos(DTOProducto DTOE, Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarProductosExigidos(DTOProducto DTOE, Long oidConcurso): Entrada");
        UtilidadesLog.debug("dentro de guardarProductosExigidos, recibo : " + 
        DTOE + ", y el concurso: " + oidConcurso);

        try {
            ProductosLocal productosL = null;
            ProductosLocalHome productosLH = this.getProductosLocalHome();

            try {
                productosL = productosLH.findByUK(oidConcurso);
            } catch (NoResultException fe) {
                //Lo acabo de Crear Deberia de Existir
             } catch (PersistenceException ce) {
                 UtilidadesLog.error("ERROR ", ce);
                 throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            ProductosExigidosLocal productosEL = null;
            ProductosExigidosLocalHome productosELH = this.getProductosExigidosLocalHome();

            //remove de todos los producto Exigidos...
            Collection colProd = productosELH.findByProducto(productosL.getOid());

            if (!colProd.isEmpty()) {
                Iterator itProdVal = colProd.iterator();

                while (itProdVal.hasNext()) {
                    ProductosExigidosLocal registro = (ProductosExigidosLocal) itProdVal.next();
                    productosELH.remove(registro);
                }
            }

            MaestroProductosLocal mProductosL = null;
            MaestroProductosLocalHome mProductosLH = this.getMaestroProductosLocalHome();
            Long producto = null;

            for (int j = 0; j < DTOE.getLstProductos().size(); j++) {
                DTOProdu registro = (DTOProdu) DTOE.getLstProductos().get(j);

                if (registro.getOidProducto() == null) {
                    //busco: codigoProducto 
                    if ((registro.getCodigoProducto() != null) && (registro.getCodigoProducto().length() > 0)) {
                        //Agregado por incidencia 20508
                        try {
                            mProductosL = mProductosLH.findByUK(DTOE.getOidPais(), registro.getCodigoProducto());
                            producto = mProductosL.getOid();                            
                        }
                        catch (FinderException fe) {
                            UtilidadesLog.error("ERROR ", fe);
                            
                            ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(), 
                            UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", 
                            ErroresDeNegocio.INC_0044));

                            ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                            ex.addParameter(registro.getCodigoProducto());
                            throw ex;        
                        }                              
                        //Fin - Agregado por incidencia 20508                 
                    } else {
                        producto = null;
                    }
                } else {
                    producto = registro.getOidProducto();
                }

                //JRIVAS 18/7/2005
                //Inc 18270
                PeriodoLocalHome periodoLH = this.getPeriodoLocalHome();
                PeriodoLocal periodoLDesde = null;
                PeriodoLocal periodoLHasta = null;
                Long pDesde = null;
                Long pHasta = null;

                try {
                    periodoLDesde = periodoLH.findByPrimaryKey(registro.getOidPeriodoDesde());
                    
                } catch (NoResultException nre) {
                    UtilidadesLog.debug("no encontro period desde " + registro.getOidPeriodoDesde());
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                } 
                
                try {
                    periodoLHasta = periodoLH.findByPrimaryKey(registro.getOidPeriodoHasta());
                } catch (NoResultException nre) {
                    UtilidadesLog.debug("no encontro period hasta " + registro.getOidPeriodoHasta());
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                } 
                    

                if (periodoLHasta != null) {
                    if ((periodoLDesde.getFechainicio().getTime() <= periodoLHasta.getFechainicio().getTime()) &&
                            (periodoLDesde.getFechaFin().getTime() <= periodoLHasta.getFechaFin().getTime())) {
                        pDesde = periodoLDesde.getOid();
                        pHasta = periodoLHasta.getOid();
                    } else {
                        throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC + ErroresDeNegocio.INC_0337));
                    }
                } else {
                    pDesde = periodoLDesde.getOid();
                    pHasta = periodoLDesde.getOid();
                }

                productosEL = productosELH.create(registro.getUnidadesExigidas(), registro.getMontoExigido(), registro.getPuntosExigidos(), pHasta,
                                                  pDesde, productosL.getOid());

                productosEL.setCicloVida(registro.getOidCicloVida());
                productosEL.setCodigoProducto(producto);
                productosEL.setGenerico(registro.getOidGenerico());
                productosEL.setMarcaProducto(registro.getOidMarcaProducto());
                productosEL.setNegocio(registro.getOidNegocio());
                productosEL.setSupergenerico(registro.getOidSupergenerico());
                productosEL.setTipoOferta(registro.getOidTipoOferta());
                productosEL.setUnidadNegocio(registro.getOidUnidadNegocio());
                // vbongiov -- Cambio 20080807 -- 15/04/2009
                productosEL.setIndAgrup(registro.getCodIndAgrup());
                
                productosELH.merge(productosEL);
            }
        } catch (NamingException ne) {
            UtilidadesLog.error("ERROR ", ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (FinderException fe) {
            UtilidadesLog.error("ERROR ", fe);
            String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(sCodigoError));
        } catch (PersistenceException createException) {
            UtilidadesLog.error("ERROR ", createException);
            sessionContext.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (MareException e) {
            UtilidadesLog.error("ERROR ", e);
            throw e;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
        UtilidadesLog.info("MONConcursoBean.guardarProductosExigidos(DTOProducto DTOE, Long oidConcurso): Salida");
    }


    public void guardarProductosExcluidosCalificacion(DTOProducto DTOE, Long oidConcurso)
            throws MareException {
       UtilidadesLog.info("MONConcursoBean.guardarProductosExcluidosCalificacion(DTOProducto DTOE, Long oidConcurso): Entrada");
        try {
            UtilidadesLog.debug("dentro de guardarProductosExcluidosCalificacion, recibo : " + 
            DTOE + ", y el concurso: " + oidConcurso);

            ProductosExcluidosCalificacionLocal productosECL = null;
            ProductosExcluidosCalificacionLocalHome productosECLH = this.getProductosExcluidosCalificacionLocalHome();

            Collection prodExclCalif = productosECLH.findByConcurso(oidConcurso);

            //remove de todos los producto Excluidos Calificacion...
            if (!prodExclCalif.isEmpty()) {
                Iterator itProdVal = prodExclCalif.iterator();

                while (itProdVal.hasNext()) {
                    ProductosExcluidosCalificacionLocal registro = (ProductosExcluidosCalificacionLocal) itProdVal.next();
                    productosECLH.remove(registro);
                }
            }

            MaestroProductosLocal mProductosL = null;
            MaestroProductosLocalHome mProductosLH = this.getMaestroProductosLocalHome();
            Long producto = null;

            for (int j = 0; j < DTOE.getLstProductos().size(); j++) {
                DTOProdu registro = (DTOProdu) DTOE.getLstProductos().get(j);

                if (registro.getOidProducto() == null) {
                    //busco: codigoProducto 
                    if ((registro.getCodigoProducto() != null) && (registro.getCodigoProducto().length() > 0)) {
                        //Agregado por incidencia 20508
                        try {
                            mProductosL = mProductosLH.findByUK(DTOE.getOidPais(), registro.getCodigoProducto());
                            producto = mProductosL.getOid();                            
                        }
                        catch (FinderException fe) {
                            UtilidadesLog.error("ERROR ", fe);
                            
                            ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(), 
                            UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", 
                            ErroresDeNegocio.INC_0043));

                            ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                            ex.addParameter(registro.getCodigoProducto());
                            throw ex;        
                        }                              
                        //Fin - Agregado por incidencia 20508
                    } else {
                        producto = null;
                    }
                } else {
                    producto = registro.getOidProducto();
                }

                //JRIVAS 18/7/2005
                //Inc 18270
                PeriodoLocalHome periodoLH = this.getPeriodoLocalHome();
                PeriodoLocal periodoLDesde = null;
                PeriodoLocal periodoLHasta = null;
                Long pDesde = null;
                Long pHasta = null;

                try {
                    periodoLDesde = periodoLH.findByPrimaryKey(registro.getOidPeriodoDesde());
                    periodoLHasta = periodoLH.findByPrimaryKey(registro.getOidPeriodoHasta());
                } catch (NoResultException nre) {
                     UtilidadesLog.error("ERROR ", nre);       
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }

                if (periodoLHasta != null) {
                    if ((periodoLDesde.getFechainicio().getTime() <= periodoLHasta.getFechainicio().getTime()) &&
                            (periodoLDesde.getFechaFin().getTime() <= periodoLHasta.getFechaFin().getTime())) {
                        pDesde = periodoLDesde.getOid();
                        pHasta = periodoLHasta.getOid();
                    } else {
                        throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC + ErroresDeNegocio.INC_0338));
                    }
                } else {
                    pDesde = periodoLDesde.getOid();
                    pHasta = periodoLDesde.getOid();
                }

                productosECL = productosECLH.create(oidConcurso, registro.getOidMarcaProducto(), pDesde, pHasta);

                productosECL.setCicloVida(registro.getOidCicloVida());
                productosECL.setCodigoProducto(producto);
                productosECL.setGenerico(registro.getOidGenerico());
                productosECL.setNegocio(registro.getOidNegocio());
                productosECL.setSupergenerico(registro.getOidSupergenerico());
                productosECL.setTipoOferta(registro.getOidTipoOferta());
                productosECL.setUnidadNegocio(registro.getOidUnidadNegocio());
                productosECLH.merge(productosECL);
            }
        } catch (NamingException ne) {
            UtilidadesLog.error("ERROR ", ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (FinderException fe) {
            UtilidadesLog.error("ERROR ", fe);
            String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(sCodigoError));
        } catch (PersistenceException createException) {
            UtilidadesLog.error("ERROR ", createException);
            sessionContext.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONConcursoBean.guardarProductosExcluidosCalificacion(DTOProducto DTOE, Long oidConcurso): Salida");
    }

    public void guardarProductosACalificar(DTOProducto DTOE, Long oidConcurso)
            throws MareException {
        
        UtilidadesLog.info("MONConcursoBean.guardarProductosACalificar(DTOProducto DTOE, Long oidConcurso): Entrada");
        UtilidadesLog.debug("dentro de guardarProductosACalificar, recibo : " + 
        DTOE + ", y el concurso: " + oidConcurso);

        try {
            ProductosCalificarLocal productosCL = null;
            ProductosCalificarLocalHome productosCLH = this.getProductosCalificarLocalHome();

            Collection colProdACalif = productosCLH.findByConcurso(oidConcurso);

            if (!colProdACalif.isEmpty()) {
                Iterator itProdVal = colProdACalif.iterator();

                while (itProdVal.hasNext()) {
                    ProductosCalificarLocal registro = (ProductosCalificarLocal) itProdVal.next();
                    productosCLH.remove(registro);
                }
            }        

            MaestroProductosLocal mProductosL = null;
            MaestroProductosLocalHome mProductosLH = this.getMaestroProductosLocalHome();
            Long producto = null;

            for (int j = 0; j < DTOE.getLstProductos().size(); j++) {
                DTOProdu registro = (DTOProdu) DTOE.getLstProductos().get(j);

                //busco: codigoProducto 
                if (registro.getOidProducto() == null) {
                    if ((registro.getCodigoProducto() != null) && 
                    (registro.getCodigoProducto().length() > 0)) {
                        //Agregado por incidencia 20508
                        try {
                            mProductosL = mProductosLH.findByUK(DTOE.getOidPais(), 
                            registro.getCodigoProducto());
                            producto = mProductosL.getOid();                            
                        }
                        catch (FinderException fe) {
                            UtilidadesLog.error("ERROR ", fe);
                            
                            ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(), 
                            UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", 
                            ErroresDeNegocio.INC_0040));

                            ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                            ex.addParameter(registro.getCodigoProducto());
                            throw ex;        
                        }        
                        //Fin - Agregado por incidencia 20508                        
                    } else {
                        producto = null;
                    }
                } else {
                    producto = registro.getOidProducto();
                }

                productosCL = productosCLH.create(oidConcurso, registro.getOidMarcaProducto());

                productosCL.setCicloVida(registro.getOidCicloVida());
                productosCL.setCodigoProducto(producto);
                productosCL.setGenerico(registro.getOidGenerico());
                productosCL.setNegocio(registro.getOidNegocio());
                productosCL.setSupergenerico(registro.getOidSupergenerico());
                productosCL.setTipoOferta(registro.getOidTipoOferta());
                productosCL.setUnidadNegocio(registro.getOidUnidadNegocio());
                productosCLH.merge(productosCL);
            }
        } catch (NamingException ne) {
            UtilidadesLog.error("ERROR ", ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }  catch (FinderException fe) {
            UtilidadesLog.error("ERROR ", fe);
            String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(fe, UtilidadesError.armarCodigoError(sCodigoError));
        }  catch (PersistenceException createException) {
            UtilidadesLog.error("ERROR ", createException);
            sessionContext.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONConcursoBean.guardarProductosACalificar(DTOProducto DTOE, Long oidConcurso): Salida");
    }


    public DTOSalida buscarConcursos(DTOBuscarConcursos DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.buscarConcursos(DTOBuscarConcursos DTOE): Entrada");
        DAOConcurso daoConcurso = new DAOConcurso();
        DTOSalida dtoSalida = new DTOSalida();

        UtilidadesLog.debug("--- MONConcurso.buscarConcursos()");
        dtoSalida.setResultado(daoConcurso.buscarConcursos(DTOE));

        UtilidadesLog.debug("dtoSalida: " + dtoSalida);
        UtilidadesLog.info("MONConcursoBean.buscarConcursos(DTOBuscarConcursos DTOE): Salida");
        return dtoSalida;
    }


    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param oidConcurso
     * @author Marcelo J. Maidana -- 28/04/2005
     */
    public ArrayList obtenerIncrementosPorRango(Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerIncrementosPorRango(Long oidConcurso): Entrada");
        DAOConcurso dao = new DAOConcurso();
        RecordSet rs = dao.obtenerIncrementosPorRango(oidConcurso);

        DTOIncrementoPorRango dtoIR = null;
        ArrayList al = new ArrayList();
        Object o = null;

        for (int i = 0; (rs != null) && !rs.esVacio() && (i < rs.getRowCount()); i++) {
            dtoIR = new DTOIncrementoPorRango();
            dtoIR.setOidRango(((o = rs.getValueAt(i, "OID_RANG")) != null) ? new Long(((BigDecimal) o).toString()) : null);
            dtoIR.setDesde(((o = rs.getValueAt(i, "VAL_DESD")) != null) ? (BigDecimal) o : null);
            dtoIR.setHasta(((o = rs.getValueAt(i, "VAL_HAST")) != null) ? (BigDecimal) o : null);
            dtoIR.setIncremento(((o = rs.getValueAt(i, "VAL_INCR")) != null) ? (BigDecimal) o : null);
            al.add(dtoIR);
        }
        UtilidadesLog.info("MONConcursoBean.obtenerIncrementosPorRango(Long oidConcurso): Salida");
        return al;
    }


    private MONProcesosPEDHome getMONProcesosPEDHome()
            throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONProcesosPEDHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONProcesosPED"), MONProcesosPEDHome.class);
    }

    private Long obtengoCodVentaFicticio(ContadorPremioArticuloLocal contPremioArt)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtengoCodVentaFicticio(ContadorPremioArticuloLocal contPremioArt): Entrada");
        
        Long codVentaFict = null; 
                
        UtilidadesLog.debug("contPremioArt.getRangoDesde(): " + contPremioArt.getRangoDesde());
        UtilidadesLog.debug("contPremioArt.getRangoHasta(): " + contPremioArt.getRangoHasta());
        UtilidadesLog.debug("contPremioArt.getUltimContador(): " + contPremioArt.getUltimContador());
        
        // vbongiov -- INC-8 --21/11/2007
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


    private String obtenerNumeroConcurso() throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerNumeroConcurso(): Entrada");
        String sCodigo;
        String sCodigoMax;
        int iSecuencia;

        Format formatter;
        formatter = new SimpleDateFormat("yy");
        sCodigo = formatter.format(new java.util.Date());

        sCodigoMax = new DAOConcurso().obtenerCodigoMaximo(sCodigo);

        /*
        if (sCodigoMax == null) {
          sCodigo += "/001";
        } else {
          int iLn = sCodigoMax.trim().length();
          sCodigo += "/".concat((iLn <= 2) ? ((iLn == 2) ? "0" : "00").
                                 concat(sCodigoMax.trim())) : sCodigoMax.trim();
        }*/
        if (sCodigoMax == null) {
            sCodigo += "/001";
        } else {
            iSecuencia = new Integer(sCodigoMax.substring(3)).intValue();
            iSecuencia += 1;

            int iCantCeros = 3 - (String.valueOf(iSecuencia).length());

            StringBuffer sPaddedSequence = new StringBuffer("");

            for (int i = 0; i < iCantCeros; i++) {
                sPaddedSequence.append("0");
            }

            sCodigo += ("/" + sPaddedSequence.toString() + String.valueOf(iSecuencia));
        }
        UtilidadesLog.info("MONConcursoBean.obtenerNumeroConcurso(): Salida");
        return sCodigo;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return ArrayList
     * @param RecordSet r
     */
    private ArrayList recordsetToArrayListaParticipantes(RecordSet r)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.recordsetToArrayListaParticipantes(RecordSet r): Entrada");
        UtilidadesLog.debug("-- MONConcurso.recordsetToArrayListaParticipantes()");

        ArrayList aList = new ArrayList();

        if ((r != null) && !r.esVacio()) {
            int cantFilas = r.getRowCount();
            BigDecimal bigOid = null;
            String sDesc = null;
            DTOParticipante dtoP = null;

            for (int i = 0; i < cantFilas; i++) {
                dtoP = new DTOParticipante();
                bigOid = (BigDecimal) r.getValueAt(i, 0);
                sDesc = (String) r.getValueAt(i, 1);

                dtoP.setOid(new Long(bigOid.longValue()));
                dtoP.setDescripcion(sDesc);
                UtilidadesLog.debug("DTOParticipante a añadir: " + dtoP);

                aList.add(dtoP);
            }
        }
        UtilidadesLog.info("MONConcursoBean.recordsetToArrayListaParticipantes(RecordSet r): Salida");
        return aList;
    }

    /**
     * @author: ssantana, 4/6/2005
     * @throws es.indra.mare.common.exception.MareException
     * @return DTONivelesPremiacion
     * @param DTOOID dtoe
     */
    public DTONivelesPremiacion obtenerNivelesPremiacion(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerNivelesPremiacion(DTOOID DTOE): Entrada");
        UtilidadesLog.log("-- MONConcurso.obtenerNivelesPremiacion()");

        ParametrosGeneralesPremiacionLocalHome pGralesPremiacionLH = null;
        PremioPuntosLocalHome premioPuntosLH = null;
        ParametrosNivelPremiacionLocalHome pNivelPremiacionLH = null;
        PremioMonetarioLocalHome premioMonetarioLH = null;
        PremioDescuentoLocalHome premioDescuentoLH = null;
        PagoMonetariosLocalHome pagoMonetarioLH = null;
        ProductoDescuentoLocalHome productoDescuentoLH = null;
        Entidadi18nLocalHome entidadI18NLH = null;
        PremioArticuloLocalHome premioArticuloLH = null;
        LotePremioArticulosLocalHome lotePremioArticuloLH = null;
        ArticulosLoteLocalHome articuloLoteLH = null;
        MaestroProductosLocalHome maestroProductosLH = null;
        MarcaProductoLocalHome marcaProductoLH = null;

        ParametrosGeneralesPremiacionLocal pGralesPremiacionL = null;
        ParametrosNivelPremiacionLocal pNivelPremiacionL = null;
        PremioPuntosLocal premioPuntosL = null;
        PremioMonetarioLocal premioMonetarioL = null;
        PagoMonetariosLocal pagoMonetarioL = null;
        PremioDescuentoLocal premioDescuentoL = null;
        ProductoDescuentoLocal productoDescuentoL = null;
        Entidadi18nLocal entidadI18NL = null;
        PremioArticuloLocal premioArticuloL = null;
        LotePremioArticulosLocal lotePremioArticuloL = null;
        ArticulosLoteLocal articulosLoteL = null;
        MaestroProductosLocal maestroProductosL = null;
        MarcaProductoLocal marcaProductoL = null;
        DAOCentrosServicios daoCentrosServicios = new DAOCentrosServicios();

        DTONivelesPremiacion dtoNivelesPremiacion = new DTONivelesPremiacion();
        DTONivelPremiacion dtoNivelPremiacion = null;
        Vector vPrincipal = new Vector();

        Collection niveles = null;

        try {
            pGralesPremiacionLH = this.getParametrosGeneralesPremiacionLocalHome();
            pNivelPremiacionLH = this.getParametrosNivelPremiacionLocalHome();
            premioPuntosLH = this.getPremioPuntosLocalHome();
            premioMonetarioLH = this.getPremioMonetarioLocalHome();
            pagoMonetarioLH = this.getPagoMonetariosLocalHome();
            productoDescuentoLH = this.getProductoDescuentoLocalHome();
            entidadI18NLH = this.getEntidadi18nLocalHome();
            premioArticuloLH = this.getPremioArticuloLocalHome();
            lotePremioArticuloLH = this.getLotePremioArticulosLocalHome();
            articuloLoteLH = this.getArticulosLoteLocalHome();
            maestroProductosLH = this.getMaestroProductosLocalHome();
            marcaProductoLH = this.getMarcaProductoLocalHome();

            pGralesPremiacionL = pGralesPremiacionLH.findByUK(DTOE.getOid());

            Long oidParamGral = pGralesPremiacionL.getOid();
            niveles = pNivelPremiacionLH.findByParametroGeneralPremiacion(oidParamGral);
        } catch (NamingException nEx) {
            UtilidadesLog.error("ERROR ", nEx);
            String sCodigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(nEx, UtilidadesError.armarCodigoError(sCodigoError));
        } catch (NoResultException fEx) {
            
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        if ((niveles == null) || niveles.isEmpty()) {
            UtilidadesLog.info("MONConcursoBean.obtenerNivelesPremiacion(DTOOID DTOE): Salida");
            return null;
        }

        Iterator it = niveles.iterator();

        while (it.hasNext()) {
            pNivelPremiacionL = (ParametrosNivelPremiacionLocal) it.next();

            Long oidNivelPremiacion = pNivelPremiacionL.getOid();
            dtoNivelPremiacion = new DTONivelPremiacion();

            dtoNivelPremiacion.setOid(pNivelPremiacionL.getOid());
            dtoNivelPremiacion.setNumeroNivel(pNivelPremiacionL.getNumeroNivel());
            dtoNivelPremiacion.setCantidadFijaPuntos(pNivelPremiacionL.getCantidadFijaPuntos());
            dtoNivelPremiacion.setCantidadDesde(pNivelPremiacionL.getCantidadInicialPuntos());
            dtoNivelPremiacion.setCantidadHasta(pNivelPremiacionL.getCantidadFinalPuntos());
            dtoNivelPremiacion.setIndNivelSelectivo(pNivelPremiacionL.getNivelSelectivo());
            dtoNivelPremiacion.setPuntajeServicio(pNivelPremiacionL.getPuntajeServicio());
            dtoNivelPremiacion.setNumeroAspirantes(pNivelPremiacionL.getNumeroAspirantes());
            dtoNivelPremiacion.setOidTipoPremio(pNivelPremiacionL.getTipoPremio());
            dtoNivelPremiacion.setPuntosProductosExigidos(pNivelPremiacionL.getPuntosProductosExigidos());
            // vbongiov -- Cambio 20090930 -- 16/07/2009
            dtoNivelPremiacion.setDescripcionNivel(pNivelPremiacionL.getDescripcionNivel());

            // TODO: Inc. 18916        
            // dto.listaNiveles[i].indModificar = 0         
            // Premio Puntos
            UtilidadesLog.debug("Carga Premio Puntos");

            try {
                Collection col = premioPuntosLH.findByParametroNivelPremiacion(oidNivelPremiacion);

                if (!col.isEmpty()) {
                    Iterator itPremioPuntos = col.iterator();
                    DTOPremioPuntos dtoPremioPuntos = null;

                    while (itPremioPuntos.hasNext()) {
                        dtoPremioPuntos = new DTOPremioPuntos();
                        premioPuntosL = (PremioPuntosLocal) itPremioPuntos.next();

                        dtoPremioPuntos.setCantidad(premioPuntosL.getCantidad());
                        dtoPremioPuntos.setNumeroPremio(premioPuntosL.getNumeroPremio());
                        dtoPremioPuntos.setOidConcursoDestino(premioPuntosL.getConcursoDestino());
                        dtoPremioPuntos.setOidPremioPuntos(premioPuntosL.getOid());
                        dtoPremioPuntos.setOidTipoPremioPuntos(premioPuntosL.getTipoPremioPuntos());
                        dtoPremioPuntos.setPorcentaje(premioPuntosL.getPorcentaje());

                        dtoNivelPremiacion.setPremioPuntos(dtoPremioPuntos);
                        dtoNivelPremiacion.setIndPremiosPuntos(Boolean.TRUE);
                        dtoNivelPremiacion.setIndPremiosDescuento(Boolean.FALSE);
                        dtoNivelPremiacion.setIndPremiosMonetarios(Boolean.FALSE);
                        dtoNivelPremiacion.setIndPremiosArticulos(Boolean.FALSE);
                    }
                }
            } catch (NoResultException fEx) {
                
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            // Premio monetario
            UtilidadesLog.debug("Carga Premio monetario");

            DTOPremioMonetario dtoPremioMonetario = null;

            try {
                // Nivel Premiacion en esta entidad es UK, así solo vendría UN UNICO REGISTRO
                Collection col = premioMonetarioLH.findByParametroNivelPremiacion(oidNivelPremiacion);

                if (!col.isEmpty()) {
                    Iterator itPremioMonetario = col.iterator();
                    dtoPremioMonetario = new DTOPremioMonetario();
                    premioMonetarioL = (PremioMonetarioLocal) itPremioMonetario.next();
                    dtoPremioMonetario.setOidPremioMonetario(premioMonetarioL.getOid());
                    dtoPremioMonetario.setNumeroPremio(premioMonetarioL.getNumeroPremio());
                    dtoPremioMonetario.setOidTipoPremioMonetario(premioMonetarioL.getTipoPremioMonetario());
                    dtoPremioMonetario.setCantidad(premioMonetarioL.getCantidad());
                    dtoPremioMonetario.setPorcentaje(premioMonetarioL.getPorcentaje());
                    dtoPremioMonetario.setOidMoneda(premioMonetarioL.getMoneda());
                    dtoPremioMonetario.setOidFormaPago(premioMonetarioL.getFormaPago());
                    dtoPremioMonetario.setIndPagoPartes(premioMonetarioL.getPagoPartes());
                    dtoPremioMonetario.setOidCumplimiento(premioMonetarioL.getCumplimiento());
                    dtoPremioMonetario.setIndDescontarPagosAnticipados(premioMonetarioL.getDescontarPagosAnticipados());
                }
            } catch (NoResultException fEx) {
                UtilidadesLog.error("ERROR ", fEx);

                String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(fEx, UtilidadesError.armarCodigoError(sCodigoError));
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            UtilidadesLog.debug("Carga Pagos Monetarios para Premio Monetario");

            if (dtoPremioMonetario != null) {
                // Pago Monetario
                try {
                    PeriodoLocalHome periodoLH = this.getPeriodoLocalHome();
                    PeriodoLocal periodoL = null;

                    Collection col = pagoMonetarioLH.findByPremioMonetario(dtoPremioMonetario.getOidPremioMonetario());
                    ArrayList aListPagoMonetario = new ArrayList();

                    if (!col.isEmpty()) {
                        Iterator itPagoMonetario = col.iterator();
                        DTOPagoMonetario dtoPagoMonetario = null;

                        while (itPagoMonetario.hasNext()) {
                            pagoMonetarioL = (PagoMonetariosLocal) itPagoMonetario.next();
                            dtoPagoMonetario = new DTOPagoMonetario();

                            dtoPagoMonetario.setOidPagoMonetario(pagoMonetarioL.getOid());

                            if (pagoMonetarioL.getNumeroPago() != null) {
                                dtoPagoMonetario.setNumeroPago(new Integer(pagoMonetarioL.getNumeroPago().intValue()));
                            }

                            dtoPagoMonetario.setPremio(new BigDecimal(pagoMonetarioL.getPorcentajePremio().doubleValue()));
                            dtoPagoMonetario.setOidPeriodoControl(pagoMonetarioL.getPeriodo());

                            periodoL = periodoLH.findByPrimaryKey(pagoMonetarioL.getPeriodo());
                            dtoPagoMonetario.setPeriodoControl(periodoL.getNombrePeriodo());

                            aListPagoMonetario.add(dtoPagoMonetario);
                        }
                    }

                    dtoPremioMonetario.setLstPagosMonetarios(aListPagoMonetario);
                    
                } catch (NoResultException nre) {
                    sessionContext.setRollbackOnly();
                     UtilidadesLog.error("ERROR ", nre);
                    throw new MareException(nre,        
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }

            dtoNivelPremiacion.setPremioMonetario(dtoPremioMonetario);

            if (dtoPremioMonetario != null) {
                dtoNivelPremiacion.setIndPremiosPuntos(Boolean.FALSE);
                dtoNivelPremiacion.setIndPremiosDescuento(Boolean.FALSE);
                dtoNivelPremiacion.setIndPremiosMonetarios(Boolean.TRUE);
                dtoNivelPremiacion.setIndPremiosArticulos(Boolean.FALSE);
            }

            // Premio Descuento        
            // Nota: Inc. 18916 - Ver si solamente debe traer uno (faltaria la UK en BD)
            UtilidadesLog.debug("Carga Premios Descuento");

            DTOPremioDescuento dtoPremioDescuento = null;

            try {
                premioDescuentoLH = this.getPremioDescuentoLocalHome();

                Collection col = premioDescuentoLH.findByParametroNivelPremiacion(oidNivelPremiacion);

                if (!col.isEmpty()) {
                    Iterator itPremioDescuento = col.iterator();

                    while (itPremioDescuento.hasNext()) {
                        dtoPremioDescuento = new DTOPremioDescuento();
                        premioDescuentoL = (PremioDescuentoLocal) itPremioDescuento.next();

                        dtoPremioDescuento.setOidPremioDescuento(premioDescuentoL.getOid());
                        dtoPremioDescuento.setNumeroPremio(premioDescuentoL.getNumeroPremio());
                        dtoPremioDescuento.setCantidadDescuento(premioDescuentoL.getCantidadDescuento());
                        dtoPremioDescuento.setPorcentajeDescuento(premioDescuentoL.getPorcentajeDescuento());
                        dtoPremioDescuento.setOidPeriodoAplicacionDesde(premioDescuentoL.getPeriodoDesde());
                        dtoPremioDescuento.setOidPeriodoAplicacionHasta(premioDescuentoL.getPeriodoHasta());
                        dtoPremioDescuento.setOidTipoDescuento(premioDescuentoL.getTipoDescuento());
                    }
                }
            } catch (NoResultException fEx) {
                UtilidadesLog.error("ERROR ", fEx);
                String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(fEx, UtilidadesError.armarCodigoError(sCodigoError));
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            UtilidadesLog.debug("Carga Articulos para PremioDescuento");

            if (dtoPremioDescuento != null) {
                try {
                    Collection col = productoDescuentoLH.findByPremioDescuento(dtoPremioDescuento.getOidPremioDescuento());
                    ArrayList aListaArticulos = new ArrayList();
                    DTOArticulo dtoProducto = null;

                    if (!col.isEmpty()) {
                        Iterator itProductosDescuentos = col.iterator();

                        while (itProductosDescuentos.hasNext()) {
                            dtoProducto = new DTOArticulo();
                            
                            productoDescuentoL = (ProductoDescuentoLocal) itProductosDescuentos.next();
                            dtoProducto.setOidMarca(productoDescuentoL.getMarcaProducto());
                            dtoProducto.setOidUnidadNegocio(productoDescuentoL.getUnidadNegocio());
                            dtoProducto.setOidNegocio(productoDescuentoL.getNegocio());
                            dtoProducto.setOidSupergenerico(productoDescuentoL.getSupergenerico());
                            dtoProducto.setOidGenerico(productoDescuentoL.getGenerico());
                            dtoProducto.setOidProducto(productoDescuentoL.getCodigoProducto());

                            if (productoDescuentoL.getUnidadNegocio() != null) {
                                entidadI18NL = entidadI18NLH.findByEntAtrIdioPK("MAE_UNIDA_NEGOC", new Long(ConstantesINC.NUM_ATRIBUTO.intValue()),
                                                                                DTOE.getOidIdioma(), productoDescuentoL.getUnidadNegocio());
                                dtoProducto.setUnidadNegocio(entidadI18NL.getDetalle());
                            }

                            if (productoDescuentoL.getNegocio() != null) {
                                entidadI18NL = entidadI18NLH.findByEntAtrIdioPK("MAE_NEGOC", new Long(ConstantesINC.NUM_ATRIBUTO.intValue()),
                                                                                DTOE.getOidIdioma(), productoDescuentoL.getNegocio());
                                dtoProducto.setNegocio(entidadI18NL.getDetalle());
                            }

                            if (productoDescuentoL.getSupergenerico() != null) {
                                entidadI18NL = entidadI18NLH.findByEntAtrIdioPK("MAE_SUPER_GENER", new Long(ConstantesINC.NUM_ATRIBUTO.intValue()),
                                                                                DTOE.getOidIdioma(), productoDescuentoL.getSupergenerico());
                                dtoProducto.setSupergenerico(entidadI18NL.getDetalle());
                            }

                            if (productoDescuentoL.getGenerico() != null) {
                                entidadI18NL = entidadI18NLH.findByEntAtrIdioPK("MAE_GENER", new Long(ConstantesINC.NUM_ATRIBUTO.intValue()),
                                                                                DTOE.getOidIdioma(), productoDescuentoL.getGenerico());
                                dtoProducto.setGenerico(entidadI18NL.getDetalle());
                            }

                            marcaProductoL = marcaProductoLH.findByPrimaryKey(productoDescuentoL.getMarcaProducto());
                            dtoProducto.setMarca(marcaProductoL.getDescripcion());

                            if (productoDescuentoL.getCodigoProducto() != null) {
                                MaestroProductosPK maePK = new MaestroProductosPK(productoDescuentoL.getCodigoProducto());
                                maestroProductosL = maestroProductosLH.findByPrimaryKey(maePK);
                                dtoProducto.setCodigoProducto(maestroProductosL.getCodigoSAP());
                            }

                            aListaArticulos.add(dtoProducto);
                        }
                    }

                    dtoPremioDescuento.setLstArticulos(aListaArticulos);
                } catch (FinderException fEx) {
                    UtilidadesLog.error("ERROR ", fEx);
                    String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                    throw new MareException(fEx, UtilidadesError.armarCodigoError(sCodigoError));
                } catch (NoResultException nre) {
                    sessionContext.setRollbackOnly();
                     UtilidadesLog.error("ERROR ", nre);
                    throw new MareException(nre,        
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }

            dtoNivelPremiacion.setPremioDescuento(dtoPremioDescuento);

            if (dtoPremioDescuento != null) {
                dtoNivelPremiacion.setIndPremiosPuntos(Boolean.FALSE);
                dtoNivelPremiacion.setIndPremiosDescuento(Boolean.TRUE);
                dtoNivelPremiacion.setIndPremiosMonetarios(Boolean.FALSE);
                dtoNivelPremiacion.setIndPremiosArticulos(Boolean.FALSE);
            }

            UtilidadesLog.debug("Carga PremioArticulo");

            try {
                // Solo vendría un UNICO registro ya que es UK. 
                Collection col = premioArticuloLH.findByParametroNivelPremiacion(oidNivelPremiacion);
                DTOPremioArticulo dtoPremioArticulo = null;

                if (!col.isEmpty()) {
                    Iterator itPremioArticulo = col.iterator();

                    while (itPremioArticulo.hasNext()) {
                        premioArticuloL = (PremioArticuloLocal) itPremioArticulo.next();
                        dtoPremioArticulo = new DTOPremioArticulo();
                        dtoPremioArticulo.setOidPremioArticulo(premioArticuloL.getOid());
                        dtoPremioArticulo.setNumeroUnidadesPremioArticulo(premioArticuloL.getNumeroUnidades());

                        Collection colLote = lotePremioArticuloLH.findByLotePremioArticulo(premioArticuloL.getOid());
                        ArrayList aListLote = new ArrayList();
                        DTOLotesPremio dtoLotesPremio = null;

                        if (!colLote.isEmpty()) {
                            Iterator itLote = colLote.iterator();

                            while (itLote.hasNext()) {
                                dtoLotesPremio = new DTOLotesPremio();
                                lotePremioArticuloL = (LotePremioArticulosLocal) itLote.next();
                                dtoLotesPremio.setOidLotePremio(lotePremioArticuloL.getOid());
                                dtoLotesPremio.setDescripcionLote(lotePremioArticuloL.getDescripcion());
                                dtoLotesPremio.setNumeroPremio(lotePremioArticuloL.getNumeroPremio());

                                // dto.listaNiveles[i].premioArticulo.lstLotesPremio[j].numeroLote = lotes[j].numeroLote 
                                Collection colArticuloLote = articuloLoteLH.findByLotePremioArticulo(lotePremioArticuloL.getOid());
                                ArrayList aListArticuloLote = new ArrayList();
                                DTOProductosLote dtoProductosLote = null;
                                DTOCentroServicio dtoCentroServicioGar = new DTOCentroServicio();
                                DTOCentroServicio dtoCentroServicioEntrega = new DTOCentroServicio();
                                DTOOID dtoOID = new DTOOID();

                                if (!colArticuloLote.isEmpty()) {
                                    Iterator itArtLote = colArticuloLote.iterator();

                                    while (itArtLote.hasNext()) {
                                        dtoProductosLote = new DTOProductosLote();
                                        articulosLoteL = (ArticulosLoteLocal) itArtLote.next();

                                        //dtoArticulosLote.set
                                        dtoProductosLote.setOidProductoLote(articulosLoteL.getOid());
                                        dtoProductosLote.setOidProducto(articulosLoteL.getProducto());
                                        dtoProductosLote.setCodVentaFicticio(articulosLoteL.getCodigoVentaFicticio());
                                        dtoProductosLote.setNumeroUnidades(articulosLoteL.getNumeroUnidades());
                                        dtoProductosLote.setPrecioPublico(articulosLoteL.getPrecioPublico());
                                        dtoProductosLote.setIndDespachaArticulo(articulosLoteL.getDespacha());
                                        // vbongiov -- 17/09/2007
                                        dtoProductosLote.setIndCentroServGar(articulosLoteL.getIndCentroServGar());
                                        dtoProductosLote.setOidCentroServGar(articulosLoteL.getOidCentroServGar());
                                        dtoProductosLote.setNumMeses(articulosLoteL.getNumMeses());
                                        dtoProductosLote.setObservaciones(articulosLoteL.getObservaciones());
                                        dtoProductosLote.setIndTipoEntrega(articulosLoteL.getIndTipoEntrega());
                                        dtoProductosLote.setOidCentroServEntrega(articulosLoteL.getOidCentroServEntrega());
                                        
                                        MaestroProductosPK maePK = new MaestroProductosPK(articulosLoteL.getProducto());
                                        maestroProductosL = maestroProductosLH.findByPrimaryKey(maePK);
                                        dtoProductosLote.setCodigoProducto(maestroProductosL.getCodigoSAP());
                                        
                                        // vbongiov -- Cambio 20090930 -- 16/07/2009                                        
                                        entidadI18NL = entidadI18NLH.findByEntAtrIdioPK("MAE_PRODU", new Long(ConstantesINC.NUM_ATRIBUTO.toString()),
                                                                                      DTOE.getOidIdioma(), articulosLoteL.getProducto());
                                                                                      
                                        dtoProductosLote.setDescProducto(entidadI18NL.getDetalle());      
                                        
                                        //UtilidadesLog.debug("DTOE.getOidIdioma(): " + DTOE.getOidIdioma());
                                        //UtilidadesLog.debug("articulosLoteL.getProducto(): " + articulosLoteL.getProducto());
                                        //UtilidadesLog.debug("dtoProductosLote.getDescProducto: " + dtoProductosLote.getDescProducto());
                                        
                                        dtoOID.setOid(articulosLoteL.getOidCentroServGar());
                                        dtoCentroServicioGar = daoCentrosServicios.obtenerCentroServicio(dtoOID);
                                        dtoProductosLote.setDescCentSerGar(dtoCentroServicioGar.getDescripcion());
                                        
                                        dtoOID.setOid(articulosLoteL.getOidCentroServEntrega());
                                        dtoCentroServicioEntrega = daoCentrosServicios.obtenerCentroServicio(dtoOID);
                                        dtoProductosLote.setDescCentSerEntrega(dtoCentroServicioEntrega.getDescripcion());
                                        
                                        aListArticuloLote.add(dtoProductosLote);
                                    }
                                }

                                dtoLotesPremio.setLstProductosLote(aListArticuloLote);
                                aListLote.add(dtoLotesPremio);
                            }
                        }

                        dtoPremioArticulo.setLstLotesPremio(aListLote);
                    }
                }

                dtoNivelPremiacion.setPremioArticulo(dtoPremioArticulo);

                if (dtoPremioArticulo != null) {
                    dtoNivelPremiacion.setIndPremiosPuntos(Boolean.FALSE);
                    dtoNivelPremiacion.setIndPremiosDescuento(Boolean.FALSE);
                    dtoNivelPremiacion.setIndPremiosMonetarios(Boolean.FALSE);
                    dtoNivelPremiacion.setIndPremiosArticulos(Boolean.TRUE);
                }
            } catch (FinderException fEx) {
                UtilidadesLog.error("ERROR ", fEx);
                String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(fEx, UtilidadesError.armarCodigoError(sCodigoError));
            }

            vPrincipal.add(dtoNivelPremiacion);
        }

        DTONivelPremiacion[] arrayDTOS = (DTONivelPremiacion[]) vPrincipal.toArray(new DTONivelPremiacion[vPrincipal.size()]);
        dtoNivelesPremiacion.setListaNiveles(arrayDTOS);
        UtilidadesLog.info("MONConcursoBean.obtenerNivelesPremiacion(DTOOID DTOE): Salida");
        return dtoNivelesPremiacion;
    }


    private MONParametrizacionHome getMONParametrizacionHome()
            throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONParametrizacionHome) PortableRemoteObject.narrow(context.lookup("MONParametrizacionINC"), MONParametrizacionHome.class);
    }


    /* private MetasVentaProyectadaZonaLocalHome getMetasVentaProyectadaZonaLocalHome() throws NamingException
     {
         final InitialContext context = new InitialContext();
         return (MetasVentaProyectadaZonaLocalHome)context.lookup("java:comp/env/MetasVentaProyectadaZona");
     }

     private MetasVentaProyectadaSubgerenciaVentaLocalHome getMetasVentaProyectadaSubgerenciaVentaLocalHome() throws NamingException
     {
         final InitialContext context = new InitialContext();
         return (MetasVentaProyectadaSubgerenciaVentaLocalHome)context.lookup("java:comp/env/MetasVentaProyectadaSubgerenciaVenta");
     }

     private MetasVentaProyectadaRegionLocalHome getMetasVentaProyectadaRegionLocalHome() throws NamingException
     {
         final InitialContext context = new InitialContext();
         return (MetasVentaProyectadaRegionLocalHome)context.lookup("java:comp/env/MetasVentaProyectadaRegion");
     }
     */
    private ArrayList parsearRecordSetMontoVenta(DTOSalida dto) {
        UtilidadesLog.info("MONConcursoBean.parsearRecordSetMontoVenta(DTOSalida dto): Entrada");

        UtilidadesLog.debug("Entrando a obtenerArrayListaMontoVentas()");
        UtilidadesLog.debug("DTOSalida Entrada: " + dto);

        // Recorre el Recordset del DTOSalida y por cada tupla del mismo, 
        // crea un DTOMontoVentaRecomendadas 
        ArrayList aList = new ArrayList();
        RecordSet r = dto.getResultado();

        // Si hay registros en el RecordSet, los procesa. 
        if (!r.esVacio()) {
            int cantRegistros = r.getRowCount();
            DTOMontoVentaRecomendadas dtoMontoVentaRecomendada = null;
            BigDecimal bigOid = null;
            String sDescTipo = null;

            // Genera por cada registro, un DTO en el ArrayList. 
            for (int i = 0; i < cantRegistros; i++) {
                dtoMontoVentaRecomendada = new DTOMontoVentaRecomendadas();

                bigOid = (BigDecimal) r.getValueAt(i, 0);
                sDescTipo = (String) r.getValueAt(i, 1);

                dtoMontoVentaRecomendada.setOidMontoVenta(null);
                dtoMontoVentaRecomendada.setCantidad(new BigDecimal(0));
                dtoMontoVentaRecomendada.setOidTipoMontoVenta(new Long(bigOid.longValue()));
                dtoMontoVentaRecomendada.setDescTipoMontoVenta(sDescTipo);
                aList.add(dtoMontoVentaRecomendada);
            }
        }
        UtilidadesLog.info("MONConcursoBean.parsearRecordSetMontoVenta(DTOSalida dto): Salida");
        return aList;
    }

    public DTOSalida obtenerConcursosREP(DTOBusquedaClienteCalificado dtoIn)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerConcursosREP(DTOBusquedaClienteCalificado dtoIn): Entrada");
        DAOConcurso dao = new DAOConcurso();
        RecordSet rs = dao.obtenerConcursosREP(dtoIn);
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(rs);
        UtilidadesLog.info("MONConcursoBean.obtenerConcursosREP(DTOBusquedaClienteCalificado dtoIn): Salida");
        return dtos;
    }

    public DTOSalida obtenerNivelesConcursoREP(DTOBelcorp dtoIn)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerNivelesConcursoREP(DTOBelcorp dtoIn): Entrada");
        DAOConcurso dao = new DAOConcurso();
        RecordSet rs = dao.obtenerNivelesConcursoREP(dtoIn);
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(rs);
        UtilidadesLog.info("MONConcursoBean.obtenerNivelesConcursoREP(DTOBelcorp dtoIn): Salida");
        return dtos;
    }

    public void guardarProductos(DTOConcurso DTOE) throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarProductos(DTOConcurso DTOE): Entrada");
        guardarProductos(DTOE, DTOE.getParamGenerales().getOid());
        UtilidadesLog.info("MONConcursoBean.guardarProductos(DTOConcurso DTOE): Salida");
    }

    // inc.20331

    /*3.        Crear el método obtenerConcursoParaCambios(DTOE : DTOOID) : DTOConcurso del MONConcurso
    “Crear un dtoConcurso del tipo DTOConcurso

    dtoConcurso.paramGenerales = llamar al método obtenerParametrosGeneralesConcurso(DTOE)
    dtoConcurso.productosValidos = llamar al método obtenerProductosValidos (DTOE)
    Si el método obtenerProductosValidos (DTOE) devuelve algún valor {
       dtoConcurso.indProductosValidos = true
       dtoConcurso.indObligProductosValidos = true
    }
    dtoConcurso.productosExcluidos = llamar al método obtenerProductosExcluidos (DTOE)
    Si el método obtenerProductosExcluidos (DTOE) devuelve algún valor {
       dtoConcurso.indProductosExcluidos = true
       dtoConcurso.indObligProductosExcluidos = true
    }
    dtoConcurso.productosBonificados = llamar al método obtenerProductosBonificados (DTOE)
    Si el método obtenerProductosBonificados (DTOE) devuelve algún valor {
       dtoConcurso.indProductosBonificados = true
       dtoConcurso.indObligProductosBonificados = true
    }
    dtoConcurso.productosExigidos = llamar al método obtenerProductosExigidos (DTOE)
    Si el método obtenerProductosExigidos (DTOE) devuelve algún valor {
       dtoConcurso.indProductosExigidos = true
       dtoConcurso.indObligProductosExigidos = true
    }

    Devolver dtoConcurso.”
    */
    public DTOConcurso obtenerConcursoParaCambios(DTOOID dtoe)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerConcursoParaCambios(DTOOID dtoe): Entrada");
        UtilidadesLog.debug("---- MONConcurso.obtenerConcursoParaCambios()");

        DTOConcurso dtoConcurso = new DTOConcurso();
        Long oidPlantilla = null;

        UtilidadesLog.debug("Llama a obtenerParametrosGeneralesConcurso()");

        if (dtoe != null) {
            DTOParametrosGeneralesConcurso dtoPramGener = obtenerParametrosGeneralesConcurso(dtoe);

            if (dtoPramGener != null) {
                dtoConcurso.setParamGenerales(dtoPramGener);
            }

            oidPlantilla = dtoConcurso.getParamGenerales().getOidPlantilla();
        }

        // Obtenemos el DTOPlantilla y lo seteamos en el DTOConcurso.
        UtilidadesLog.debug("");

        try {
            DTOOID dtoOid = new DTOOID();
            MONParametrizacionHome monParaHome = this.getMONParametrizacionHome();
            MONParametrizacion monPara = monParaHome.create();

            dtoOid.setOidPais(dtoe.getOidPais());
            dtoOid.setOidIdioma(dtoe.getOidIdioma());
            dtoOid.setOid(oidPlantilla);

            DTOPlantilla dtoPlantilla = monPara.obtenerPlantilla(dtoOid);
            dtoConcurso.setPlantilla(dtoPlantilla);
        } catch (NamingException nEx) {
            UtilidadesLog.error("ERROR ", nEx);
            String sCodigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(nEx, UtilidadesError.armarCodigoError(sCodigoError));
        } catch (RemoteException rEx) {
            UtilidadesLog.error("ERROR ", rEx);
            String sCodigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(rEx, UtilidadesError.armarCodigoError(sCodigoError));
        } catch (CreateException cEx) {
            UtilidadesLog.error("ERROR ", cEx);
            String sCodigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(cEx, UtilidadesError.armarCodigoError(sCodigoError));
        }

        // Fin Obtencion DTOPlantilla y seteo.
        // Modificacion por ssantana, 17/8/2005
        UtilidadesLog.debug("Obtencion Productos...");
        UtilidadesLog.debug("...Validos");
        DTOProducto dtoProductoValidos = this.obtenerProductosValidos(dtoe);
        
        UtilidadesLog.debug("...Excluidos");
        DTOProducto dtoProductoExcluidos = this.obtenerProductosExcluidos(dtoe);
        
        UtilidadesLog.debug("...Bonificados");
        DTOProducto dtoProductosBonificados = this.obtenerProductosBonificados(dtoe);
        
        UtilidadesLog.debug("...Exigidos");
        DTOProducto dtoProductosExigidos = this.obtenerProductosExigidos(dtoe);
        
        UtilidadesLog.debug("...ProgramaNuevas");
        DTOProgramaNuevas dtoProgramaNuevas = this.obtenerProgramaNuevas(dtoe);
        
        UtilidadesLog.debug("...ParametrosGralesPremiacion");
        DTOParametrosGeneralesPremiacion dtoParamGralesPrem = this.obtenerParametrosPremiacion(dtoe);
        
        UtilidadesLog.debug("...NivelesPremiacion");
        DTONivelesPremiacion dtoNivelesPremiacion = this.obtenerNivelesPremiacion(dtoe);

        if (dtoProductoValidos != null) {
            UtilidadesLog.debug("Validos != null");
            dtoConcurso.setProductosValidos(dtoProductoValidos);
            dtoConcurso.setIndProductosValidos(Boolean.TRUE);
            dtoConcurso.setIndObligProductosValidos(Boolean.TRUE);
        } else {
            dtoConcurso.setIndProductosValidos(Boolean.FALSE);
            dtoConcurso.setIndObligProductosValidos(Boolean.FALSE);
        }

        if (dtoProductoExcluidos != null) {
            UtilidadesLog.debug("Excluidos != null");
            dtoConcurso.setProductosExcluidos(dtoProductoExcluidos);
            dtoConcurso.setIndProductosExcluidos(Boolean.TRUE);
            dtoConcurso.setIndObligProductosExcluidos(Boolean.TRUE);
        } else {
            dtoConcurso.setIndProductosExcluidos(Boolean.FALSE);
            dtoConcurso.setIndObligProductosExcluidos(Boolean.FALSE);
        }

        if (dtoProductosBonificados != null) {
            UtilidadesLog.debug("Bonificados != null");
            dtoConcurso.setProductosBonificados(dtoProductosBonificados);
            dtoConcurso.setIndProductosBonificados(Boolean.TRUE);
            dtoConcurso.setIndObligProductosBonificados(Boolean.TRUE);
        } else {
            dtoConcurso.setIndProductosBonificados(Boolean.FALSE);
            dtoConcurso.setIndObligProductosBonificados(Boolean.FALSE);
        }

        if (dtoProductosExigidos != null) {
            UtilidadesLog.debug("Exigidos != null");
            dtoConcurso.setProductosExigidos(dtoProductosExigidos);
            dtoConcurso.setIndProductosExigidos(Boolean.TRUE);
            dtoConcurso.setIndObligProductosExigidos(Boolean.TRUE);
        } else {
            dtoConcurso.setIndProductosExigidos(Boolean.FALSE);
            dtoConcurso.setIndObligProductosExigidos(Boolean.FALSE);
        }

        if (dtoProgramaNuevas != null) {
            UtilidadesLog.debug("ProgramaNuevas != null");
            dtoConcurso.setProgramaNuevas(dtoProgramaNuevas);
            dtoConcurso.setIndProgramaNuevas(Boolean.TRUE);
            dtoConcurso.setIndObligProgramaNuevas(Boolean.TRUE);
        } else {
            dtoConcurso.setIndProgramaNuevas(Boolean.FALSE);
            dtoConcurso.setIndObligProgramaNuevas(Boolean.FALSE);
        }

        if (dtoParamGralesPrem != null) {
            UtilidadesLog.debug("ParamGralesPrem != null");
            dtoConcurso.setParamGralesPremiacion(dtoParamGralesPrem);
            dtoConcurso.setIndPremios(Boolean.TRUE);
            dtoConcurso.setIndObligPremios(Boolean.TRUE);
        } else {
            dtoConcurso.setIndPremios(Boolean.FALSE);
            dtoConcurso.setIndObligPremios(Boolean.FALSE);
        }

        if (dtoNivelesPremiacion != null) {
            UtilidadesLog.debug("Lista NivelesPremiacion != null");
            dtoConcurso.setListaNivelesPremiacion(dtoNivelesPremiacion);
            dtoConcurso.setIndNivelPremiacion(Boolean.TRUE);
        } else {
            dtoConcurso.setIndNivelPremiacion(Boolean.FALSE);
        }
        
        
        // Agregado por ssantana. 24/8/2005 - Para evitar que luego al guardar
        // se acceda a estos valores, se encuentren en NULL y se tire una 
        // Nullpointer Exception
        dtoConcurso.setIndObligProductosExcluidosCalificacion(Boolean.FALSE);
        dtoConcurso.setIndProductosExcluidosCalificacion(Boolean.FALSE);
        
        dtoConcurso.setIndObligProductosACalificar(Boolean.FALSE);
        dtoConcurso.setIndProductosACalificar(Boolean.FALSE);
        // Fin Agregado ssantana, 24/8/2005
        UtilidadesLog.info("MONConcursoBean.obtenerConcursoParaCambios(DTOOID dtoe): Salida");
        return dtoConcurso;
    }

    /**
     * @author: ssantana, 16/8/2005
     * @throws es.indra.mare.common.exception.MareException
     * @param DTOConcurso dtoConcurso
     */
    public void guardarPremiosNuevaVersion(DTOConcurso dtoConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarPremiosNuevaVersion(DTOConcurso dtoConcurso): Entrada");
        UtilidadesLog.debug("MONConcurso.guardarPremiosNuevaVersion()");

        Boolean bIndObligPremios = dtoConcurso.getIndObligPremios();
        Boolean bIndNivelPremiacion = dtoConcurso.getIndNivelPremiacion();

        UtilidadesLog.debug("bIndObligPremios: " + bIndObligPremios);
        UtilidadesLog.debug("bIndNivelPremiacion: " + bIndNivelPremiacion);

        if ((bIndObligPremios != null) && bIndObligPremios.booleanValue()) {
            DTOParametrosGeneralesPremiacion dtoPGPremiacion = dtoConcurso.getParamGralesPremiacion();
            Long oid = dtoConcurso.getParamGenerales().getOid();

            this.guardarParametrosPremiacion(dtoPGPremiacion, oid);
        }

        if ((bIndNivelPremiacion != null) && bIndNivelPremiacion.booleanValue()) {
            DTONivelesPremiacion dtoNivelesPremiacion = dtoConcurso.getListaNivelesPremiacion();
            Long oid = dtoConcurso.getParamGenerales().getOid();

            this.guardarNivelesPremiacion(dtoNivelesPremiacion, oid);
        }
        UtilidadesLog.info("MONConcursoBean.guardarPremiosNuevaVersion(DTOConcurso dtoConcurso): Salida");
    }

  /**
   * @author: ssantana, 23/8/2005
   * @throws es.indra.mare.common.exception.MareException
   * @param DTOConcurso dtoConcurso
   */
  public void guardarProductosNuevaVersion(DTOConcurso dtoConcurso) throws MareException {
     UtilidadesLog.info("MONConcursoBean.guardarProductosNuevaVersion(DTOConcurso dtoConcurso): Entrada");
     UtilidadesLog.debug("MONConcurso.guardarProductosNuevaVersion()");
     UtilidadesLog.debug("-- DTO: " + dtoConcurso);
     this.guardarProductos(dtoConcurso, dtoConcurso.getParamGenerales().getOid());
     UtilidadesLog.info("MONConcursoBean.guardarProductosNuevaVersion(DTOConcurso dtoConcurso): Salida");
  }
  
  /**
   * @author: Cleal
   * @throws es.indra.mare.common.exception.MareException
   * @param DTOConcurso DTOE
   * @param Long oidConcurso
   * Comentario: Creado por Incidencia INC-06
   */
  public void guardarEstatusVentaConsultoras (DTOConcurso DTOE, Long oidConcurso) throws MareException{
    UtilidadesLog.info("MONConcursoBean.guardarEstatusVentaConsultoras(DTOConcurso DTOE, Long oidConcurso): Entrada");
        try{
            EstatusVentaConsultoraLocal estVentConsL = null;
            //PeriodoLocal = null;
            
            PeriodoLocalHome periodoLH = getPeriodoLocalHome();

            
            EstatusVentaConsultoraLocalHome estVentConsLH = this.getEstatusVentaConsultoraLocalHome();
            Collection estatus = estVentConsLH.findByConcurso(oidConcurso);
            Iterator itCol = estatus.iterator();
            while(itCol.hasNext()){
                EstatusVentaConsultoraLocal estVtaConsL = (EstatusVentaConsultoraLocal) itCol.next();
                try {
                    estVentConsLH.remove(estVtaConsL);
                }
                catch (PersistenceException re) {
                    UtilidadesLog.error("ERROR ", re);
                    sessionContext.setRollbackOnly();
                    throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
            }
            //Por cada elemento "estatus" de DTOE.estatusVentaConsultoras (DTOListaEstatusVenta) 
            //DTOListaEstatusVenta
            ArrayList arrEst = DTOE.getEstatusVentaConsultoras().getEstatusVenta();

            if ((DTOE.getEstatusVentaConsultoras() != null) && (DTOE.getEstatusVentaConsultoras().getEstatusVenta() != null) &&
                    (DTOE.getEstatusVentaConsultoras().getEstatusVenta().size() > 0)) {
                    
                for(int i=0;i < arrEst.size();i++){
                    DTOEstatusVenta dTOEstatusVenta= (DTOEstatusVenta) arrEst.get(i);
                    PeriodoLocal perDesd = null;
                    PeriodoLocal perHast = null;
                    Long oidPeriodoDesde = null;
                    Long oidPeriodoHasta = null;
                    
                    try{                
                        perDesd = periodoLH.findByPrimaryKey(dTOEstatusVenta.getOidPeriodoDesde());
                        perHast = periodoLH.findByPrimaryKey(dTOEstatusVenta.getOidPeriodoHasta());
                    } catch (NoResultException nre) {
                        sessionContext.setRollbackOnly();
                         UtilidadesLog.error("ERROR ", nre);
                        throw new MareException(nre,        
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                    } catch (PersistenceException ce) {
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
    
                    if ((perDesd.getFechainicio().getTime() <= perHast.getFechainicio().getTime()) &&
                                (perDesd.getFechaFin().getTime() <= perHast.getFechaFin().getTime())) {
                            oidPeriodoDesde = perDesd.getOid();
                            oidPeriodoHasta = perHast.getOid();
                    }else{
                          throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC +
                                                                                                 ErroresDeNegocio.INC_0024));
                    }
                
                    estVentConsLH.create(oidConcurso, dTOEstatusVenta.getOidEstatusVentaMae(),oidPeriodoDesde,oidPeriodoHasta);
                    
                }
            
            }
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            sessionContext.setRollbackOnly();
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    
    UtilidadesLog.info("MONConcursoBean.guardarEstatusVentaConsultoras(DTOConcurso DTOE, Long oidConcurso): Salida");  
  } 


    private MONConcursoRankingHome getMONConcursoRankingHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONConcursoRankingHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONConcursoRanking"), MONConcursoRankingHome.class);
  }

  public void borrarVersionConcurso(DTOOID DTOE) throws MareException {    
    UtilidadesLog.info("MONConcursoBean.borrarVersionConcurso(DTOOID DTOE): Entrada");  
    try {
      VersionesConcursoLocalHome vclh = this.getVersionesConcursoLocalHome();  
      VersionesConcursoLocal vcl = vclh.findByPrimaryKey(DTOE.getOid());
      vclh.remove(vcl);
    } catch (NoResultException fe) {
      UtilidadesLog.error("ERROR ", fe);
      sessionContext.setRollbackOnly();
      throw new MareException(fe, 
      UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    } catch (PersistenceException re) {
      UtilidadesLog.error("ERROR ", re);
      sessionContext.setRollbackOnly();
      throw new MareException(re, 
      UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
    }
    UtilidadesLog.info("MONConcursoBean.borrarVersionConcurso(DTOOID DTOE): Salida");  
  }

    private MONGestionMensajesHome getMONGestionMensajesHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONGestionMensajesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGestionMensajes"), MONGestionMensajesHome.class);
    }

    public DTOSalida obtenerBaseIncumplimiento(DTOBelcorp dto) throws MareException{
       DAOConcurso daoConcurso = new DAOConcurso();
       return daoConcurso.obtenerBaseIncumplimiento(dto);
    }

  public DTOSalida obtenerConcursosMonetarios(DTOBusquedaClienteCalificado dto) throws MareException  {
     DAOConcurso daoConcurso = new DAOConcurso();
     return daoConcurso.obtenerConcursosMonetarios(dto);
  }

  public DTOSalida obtenerMontoVentaRep(DTOBelcorp dto) throws MareException{
     DAOConcurso daoConcurso = new DAOConcurso();
     return daoConcurso.obtenerMontoVentaRep(dto);
  }

    public DTOSalida obtenerTiposPrograma(DTOBelcorp DTOE) throws MareException {						      
        UtilidadesLog.info("MONConcursoBean.obtenerTiposPrograma(DTOBelcorp DTOE):Entrada");
        DAOConcurso dao = new DAOConcurso();
        RecordSet rs = dao.obtenerTiposPrograma(DTOE);
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(rs);
        UtilidadesLog.info("MONConcursoBean.obtenerTiposPrograma(DTOBelcorp DTOE):Salida");
        return dtos;
    }
    
    public DTOSalida obtenerConcursosPorPaisMarcaCanal(DTOBuscarConcursos DTOE) throws MareException {						      
        UtilidadesLog.info("MONConcursoBean.obtenerConcursosPorPaisMarcaCanal(DTOBuscarConcursos DTOE):Entrada");
        DAOConcurso dao = new DAOConcurso();
        RecordSet rs = dao.obtenerConcursosPorPaisMarcaCanal(DTOE);
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(rs);
        UtilidadesLog.info("MONConcursoBean.obtenerConcursosPorPaisMarcaCanal(DTOBuscarConcursos DTOE):Salida");
        return dtos;
    }
    public DTOSalida obtenerTipoMovimiento(DTOBelcorp DTOE) throws MareException {						      
        UtilidadesLog.info("MONConcursoBean.obtenerTipoMovimiento(DTOBuscarConcursos DTOE):Entrada");
        DAOConcurso dao = new DAOConcurso();
        RecordSet rs = dao.obtenerTipoMovimiento(DTOE);
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(rs);
        UtilidadesLog.info("MONConcursoBean.obtenerTipoMovimiento(DTOBuscarConcursos DTOE):Salida");
        return dtos;
    }
    
    public void guardarMovimientosCtaCtePuntos(DTOMovimientoCtaCte dtoMovimiento) throws MareException {						      
        UtilidadesLog.info("MONConcursoBean.guardarMovimientosCtaCtePuntos(DTOMovimientoCtaCte dtoMovimiento):Entrada");
        DAOConcurso dao = new DAOConcurso();
        DAOConsultaIntegralVarios daoC = new DAOConsultaIntegralVarios();
        
        RecordSet cliente = daoC.obtenerCliente(dtoMovimiento);
        
        if(cliente==null){
            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE + ErroresDeNegocio.MAE_0024));
        }
        
        dtoMovimiento.setOidCliente(new Long(cliente.getValueAt(0,"OID").toString()));
        RecordSet datosClienteConcurso = daoC.obtenerParticipaPaticipanteCompleto(dtoMovimiento);
        
        RecordSet clienteParticipante = dao.obtenerClienteParticipante(dtoMovimiento);
        
        if(("0").equals(datosClienteConcurso.getValueAt(0,"VAL_PART").toString())){
          if(clienteParticipante==null){
              throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC + ErroresDeNegocio.INC_0056));
          }
        }
        
        RecordSet descalificada = dao.obtenerDescalificacionClienteConcurso(dtoMovimiento.getOidCliente()
                                            ,dtoMovimiento.getOidConcurso());
        if(descalificada!=null){
            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC + ErroresDeNegocio.INC_0055));
        }
        
        this.insertarMovimientosCtaCtePuntos(dtoMovimiento);

        UtilidadesLog.info("MONConcursoBean.guardarMovimientosCtaCtePuntos(DTOMovimientoCtaCte dtoMovimiento):Salida");
        
    }
    
    private void insertarMovimientosCtaCtePuntos(DTOMovimientoCtaCte dtoMovimiento) throws MareException {						      
        UtilidadesLog.info("MONConcursoBean.insertarMovimientosCtaCtePuntos(DTOMovimientoCtaCte dtoMovimiento):Entrada");
        DAOConcurso dao = new DAOConcurso();
        StringBuffer insert = new StringBuffer();
        Long oidInsertar = SecuenciadorOID.obtenerSiguienteValor("INC_CUCP_SEQ");
        BelcorpService bs = BelcorpService.getInstance();
        
        insert.append(" INSERT INTO INC_CUENT_CORRI_PUNTO ( ");
        insert.append(" OID_CUEN_CORR_PUNT, ");
        insert.append(" NUM_MOVI, ");
        insert.append(" NUM_PUNT, ");
        insert.append(" NUM_PUNT_EXIG, ");
        insert.append(" FEC_MOVI, ");
        insert.append(" COPA_OID_PARA_GRAL, ");
        insert.append(" CLIE_OID_CLIE, ");
        insert.append(" PERD_OID_PERI, ");
        insert.append(" TMOV_OID_TIPO_MOVI, ");
        insert.append(" VAL_DESC ");
        insert.append(" ) VALUES (  ");
        insert.append(oidInsertar+", ");//oid
        insert.append(oidInsertar+", ");//num_movimiento
        insert.append(dtoMovimiento.getNumPuntos()+", ");
        insert.append(dtoMovimiento.getNumPuntosExigidos()+", ");
        insert.append("TO_DATE('"+dtoMovimiento.getFechaMovimiento()+"' , 'DD/MM/YYYY'), ");
        insert.append(dtoMovimiento.getOidConcurso()+", ");
        insert.append(dtoMovimiento.getOidCliente()+", ");
        insert.append(dtoMovimiento.getOidPeriodo()+", ");
        insert.append(dtoMovimiento.getOidTipoMovimiento()+", ");
        insert.append("'MANUAL-"+dtoMovimiento.getDescripcion()+"'");
        insert.append(" );");
        UtilidadesLog.info("Insertamos ---> "+insert.toString());
        try {
             bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", insert.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }

        UtilidadesLog.info("MONConcursoBean.insertarMovimientosCtaCtePuntos(DTOMovimientoCtaCte dtoMovimiento):Salida");
        
    }
    
    // vbongiov -- Cambio 20090930 -- 16/07/2009
    public DTOSalida obtenerClasificacionConcurso(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerClasificacionConcurso(DTOBelcorp DTOE):Entrada");
        DAOConcurso dao = new DAOConcurso();
        RecordSet rs = dao.obtenerClasificacionConcurso(dtoe);
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(rs);
        UtilidadesLog.info("MONConcursoBean.obtenerClasificacionConcurso(DTOBelcorp DTOE):Salida");
        return dtos;
    }
    
    // vbongiov -- Cambio 20080811 -- 26/08/2009
    public void guardarNiveleSorteoPremiacion(DTOParametrosGeneralesPremiacion dtoeParametrosGeneralesPremiacion, Long oidConcurso) throws MareException {
        UtilidadesLog.info("MONConcursoBean.guardarNiveleSorteoPremiacion(DTOParametrosGeneralesPremiacion dtoeParametrosGeneralesPremiacion, Long oidConcurso): Entrada");
        try {
        
            UtilidadesLog.debug("entro a guardarNiveleSorteoPremiacion, recibo : " + dtoeParametrosGeneralesPremiacion + ", concurso: " + oidConcurso);

            ParametrosGeneralesPremiacionLocal parametrosGeneralesPremiacionL = null;
            ParametrosGeneralesPremiacionLocalHome parametrosGeneralesPremiacionLH = this.getParametrosGeneralesPremiacionLocalHome();
            ParametrosNivelPremiacionLocal pnpL = null;
            ParametrosNivelPremiacionLocal registro = null;
            ParametrosNivelPremiacionLocalHome pnpLH = this.getParametrosNivelPremiacionLocalHome();
            PremioSorteoLocalHome psLH = this.getPremioSorteoLocalHome();

            parametrosGeneralesPremiacionL = parametrosGeneralesPremiacionLH.findByUK(oidConcurso);

            Collection niveles = pnpLH.findByParametroGeneralPremiacion(parametrosGeneralesPremiacionL.getOid());

            // borra niveles anteriores   
            if ((niveles != null) && (niveles.size() > 0)) {
                Iterator it = niveles.iterator();

                while (it.hasNext()) {
                    registro = (ParametrosNivelPremiacionLocal) it.next();
                    
                    Collection colNivPrem = psLH.findByParametroNivelPremiacion(registro.getOid());

                    if ((colNivPrem != null) && (colNivPrem.size() > 0)) {
                       UtilidadesLog.debug("premio sorteo a borrar");

                       Iterator itSorteo = colNivPrem.iterator();

                       while (itSorteo.hasNext()) {
                           PremioSorteoLocal registroSorteo = (PremioSorteoLocal) itSorteo.next();
                           psLH.remove(registroSorteo);
                       }
                    }
                }
                
                pnpL = registro;                
                
            } else {
            
                // Crea el registro de nivel
                pnpL = pnpLH.create(Integer.valueOf("1"), parametrosGeneralesPremiacionL.getOid(), ConstantesINC.OID_TIPO_PREMIO_SORTEO,
                                    new Date(System.currentTimeMillis()));
            }
            
            // Busca el producto para el sorteo
            if(dtoeParametrosGeneralesPremiacion.getOidProducto()== null){
            
                try {
                    MaestroProductosLocal mProductosL = null;
                    MaestroProductosLocalHome mProductosLH = this.getMaestroProductosLocalHome();
                    
                    mProductosL = mProductosLH.findByUK(dtoeParametrosGeneralesPremiacion.getOidPais(), dtoeParametrosGeneralesPremiacion.getCodProducto());
                    
                    dtoeParametrosGeneralesPremiacion.setOidProducto(mProductosL.getOid());
                    
                } catch (FinderException fe) {
                    UtilidadesLog.error("ERROR ", fe);
                    // no se encuentra el producto ingresado a mano 
                    ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(),
                                                                           UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC,
                                                                                                            "",
                                                                                                            ErroresDeNegocio.INC_0304));

                    ex.setPosicion(ExcepcionParametrizada.POSICION_INICIAL);
                    ex.addParameter(dtoeParametrosGeneralesPremiacion.getCodProducto());

                    ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                    ex.addParameter("1");

                    throw ex;
                }
            
            } 
            
            // Crea el sorteo
            psLH.create(oidConcurso, pnpL.getOid(), dtoeParametrosGeneralesPremiacion.getCantidadNumerosAOtorgar(), dtoeParametrosGeneralesPremiacion.getOidProducto());            
                        
            UtilidadesLog.debug("salio de guardarNiveleSorteoPremiacion");
            
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException createException) {
            sessionContext.setRollbackOnly();
            UtilidadesLog.error("ERROR ", createException);
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (FinderException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (NamingException ne) {
            UtilidadesLog.error("ERROR ", ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONConcursoBean.guardarNiveleSorteoPremiacion(DTOParametrosGeneralesPremiacion dtoeParametrosGeneralesPremiacion, Long oidConcurso): Salida");
    
    }


    private Entidadi18nLocalHome getEntidadi18nLocalHome() {
        return new Entidadi18nLocalHome();
    }

    private PeriodoLocalHome getPeriodoLocalHome(){
        return new PeriodoLocalHome();
    }
    
    private MarcaProductoLocalHome getMarcaProductoLocalHome() {
            return new MarcaProductoLocalHome();
    }
    
    private ConcursoParametrosGeneralesLocalHome getConcursoParametrosGeneralesLocalHome() {
            return new ConcursoParametrosGeneralesLocalHome();
    }

    private AccesoConcursoLocalHome getAccesoConcursoLocalHome() {
            return new AccesoConcursoLocalHome();
    }

    private VersionesConcursoLocalHome getVersionesConcursoLocalHome() {
            return new VersionesConcursoLocalHome();
    }

    private ProgramaNuevasLocalHome getProgramaNuevasLocalHome() {
            return new ProgramaNuevasLocalHome();
    }

    private ProductosLocalHome getProductosLocalHome() {
            return new ProductosLocalHome();
    }

    private ParametrosCalificacionLocalHome getParametrosCalificacionLocalHome() {
            return new ParametrosCalificacionLocalHome();
    }

    private PlantillaConcursoLocalHome getPlantillaConcursoLocalHome() {
            return new PlantillaConcursoLocalHome();
    }

    private ProductosCalificarLocalHome getProductosCalificarLocalHome() {
            return new ProductosCalificarLocalHome();
    }

    private ProductosExcluidosCalificacionLocalHome getProductosExcluidosCalificacionLocalHome() {
            return new ProductosExcluidosCalificacionLocalHome();
    }

    private ProductosExigidosLocalHome getProductosExigidosLocalHome() {
            return new ProductosExigidosLocalHome();
    }

    private ProductosBonificadosLocalHome getProductosBonificadosLocalHome() {
            return new ProductosBonificadosLocalHome();
    }
    
    private ProductosExcluidosLocalHome getProductosExcluidosLocalHome() {
            return new ProductosExcluidosLocalHome();
    }

    private ProductosValidosLocalHome getProductosValidosLocalHome() {
            return new ProductosValidosLocalHome();
    }

    private ConcursoVariablesVentaProyectadaLocalHome getConcursoVariablesVentaProyectadaLocalHome() {
            return new ConcursoVariablesVentaProyectadaLocalHome();
    }

    private MultinivelLocalHome getMultinivelLocalHome() {
            return new MultinivelLocalHome();
    }

    private ConcursoVariablesVentaGerentesLocalHome getConcursoVariablesVentaGerentesLocalHome() {
            return new ConcursoVariablesVentaGerentesLocalHome();
    }

    private ConcursoParametrosGerentesLocalHome getConcursoParametrosGerentesLocalHome() {
            return new ConcursoParametrosGerentesLocalHome();
    }

    private ParametrosNivelPremiacionLocalHome getParametrosNivelPremiacionLocalHome() {
            return new ParametrosNivelPremiacionLocalHome();
    }

    private RequisitosProgramaNuevasLocalHome getRequisitosProgramaNuevasLocalHome() {
            return new RequisitosProgramaNuevasLocalHome();
    }
    
    private EstatusVentaLocalHome getEstatusVentaLocalHome() {
            return new EstatusVentaLocalHome();
    }

    private MontoVentaRecomendadasLocalHome getMontoVentaRecomendadasLocalHome() {
            return new MontoVentaRecomendadasLocalHome();
    }

    private ConcursoParametrosConsultorasLocalHome getConcursoParametrosConsultorasLocalHome() {
            return new ConcursoParametrosConsultorasLocalHome();
    }

    private CursosExigidosPremiacionLocalHome getCursosExigidosPremiacionLocalHome() {
            return new CursosExigidosPremiacionLocalHome();
    }

    private DespachoPremiosLocalHome getDespachoPremiosLocalHome() {
            return new DespachoPremiosLocalHome();
    }

    private RangoLocalHome getRangoLocalHome() {
            return new RangoLocalHome();
    }

    private MontoMinimoRangoGerentesLocalHome getMontoMinimoRangoGerentesLocalHome() {
            return new MontoMinimoRangoGerentesLocalHome();
    }

    private RequisitosPremiacionLocalHome getRequisitosPremiacionLocalHome() {
            return new RequisitosPremiacionLocalHome();
    }

    private ProductosExigidosPremiacionLocalHome getProductosExigidosPremiacionLocalHome() {
            return new ProductosExigidosPremiacionLocalHome();
    }

    private PremioPuntosLocalHome getPremioPuntosLocalHome() {
            return new PremioPuntosLocalHome();
    }

    private PremioMonetarioLocalHome getPremioMonetarioLocalHome() {
            return new PremioMonetarioLocalHome();
    }

    private PagoMonetariosLocalHome getPagoMonetariosLocalHome() {
            return new PagoMonetariosLocalHome();
    }

    private PremioDescuentoLocalHome getPremioDescuentoLocalHome() {
            return new PremioDescuentoLocalHome();
    }

    private ProductoDescuentoLocalHome getProductoDescuentoLocalHome() {
            return new ProductoDescuentoLocalHome();
    }

    private PremioArticuloLocalHome getPremioArticuloLocalHome() {
            return new PremioArticuloLocalHome();
    }

    private LotePremioArticulosLocalHome getLotePremioArticulosLocalHome() {
            return new LotePremioArticulosLocalHome();
    }

    private ArticulosLoteLocalHome getArticulosLoteLocalHome() {
            return new ArticulosLoteLocalHome();
    }
    
    private ContadorPremioArticuloLocalHome getContadorPremioArticuloLocalHome() {
            return new ContadorPremioArticuloLocalHome();
    }
    
    private ClasificacionParticipantesConcursoLocalHome getClasificacionParticipantesConcursoLocalHome() {
            return new ClasificacionParticipantesConcursoLocalHome();
    }

    private EstatusVentaConsultoraLocalHome getEstatusVentaConsultoraLocalHome() {
            return new EstatusVentaConsultoraLocalHome();
    }

    private ClasificacionParticipantesCalificacionLocalHome getClasificacionParticipantesCalificacionLocalHome() {
            return new ClasificacionParticipantesCalificacionLocalHome();
    }

    private MetasVentaProyectadaRegionLocalHome getMetasVentaProyectadaRegionLocalHome() {
            return new MetasVentaProyectadaRegionLocalHome();
    }

    private MetasVentaProyectadaSubgerenciaVentaLocalHome getMetasVentaProyectadaSubgerenciaVentaLocalHome() {
            return new MetasVentaProyectadaSubgerenciaVentaLocalHome();
    }

    private MetasTipoVentaLocalHome getMetasTipoVentaLocalHome() {
            return new MetasTipoVentaLocalHome();
    }

    private ObtencionPuntosLocalHome getObtencionPuntosLocalHome() {
            return new ObtencionPuntosLocalHome();
    }

    private ParametrosGeneralesPremiacionLocalHome getParametrosGeneralesPremiacionLocalHome() {
            return new ParametrosGeneralesPremiacionLocalHome();
    }

    private MontoMinimoRangoConsultorasLocalHome getMontoMinimoRangoConsultorasLocalHome() {
            return new MontoMinimoRangoConsultorasLocalHome();
    }

    private AmbitoGeograficoLocalHome getAmbitoGeograficoLocalHome() {
            return new AmbitoGeograficoLocalHome();
    }
    
    private MetasVentaProyectadaZonaLocalHome getMetasVentaProyectadaZonaLocalHome() {
            return new MetasVentaProyectadaZonaLocalHome();
    }
    
    private MensajesLocalHome getMensajesLocalHome() {
            return new MensajesLocalHome();
    }
    
    private PremioSorteoLocalHome getPremioSorteoLocalHome() {
            return new PremioSorteoLocalHome();
    }

    //Agregado por cambio 20090929
    public DTOSalida validarDeuda(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("MONCocursoBean .validarDeuda(DTOBelcorp dtoe): Entrada");
               DAOConcurso dao = new DAOConcurso();
               RecordSet rs = dao.validaDeuda(dtoe);       
               DTOSalida dto = new DTOSalida();
               dto.setResultado(rs);
        UtilidadesLog.info("MONCocursoBean .validarDeuda(DTOBelcorp dtoe): Salida");
        return dto;
    }

    // sapaza -- PER-SiCC-2011-0042 -- 18/01/2011
    public DTOSalida obtenerTipoOfertaConcurso(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("MONConcursoBean.obtenerTipoOfertaConcurso(DTOBelcorp DTOE):Entrada");
        DAOConcurso dao = new DAOConcurso();
        RecordSet rs = dao.obtenerTipoOfertaConcurso(dtoe);
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(rs);
        UtilidadesLog.info("MONConcursoBean.obtenerTipoOfertaConcurso(DTOBelcorp DTOE):Salida");
        return dtos;
    }

    // sapaza -- PER-SiCC-2011-0295 -- 16/06/2011
    public void actualizarRefrescoConcurso(Long oidConcurso) throws MareException {                                                      
        UtilidadesLog.info("MONConcursoBean.actualizarRefrescoConcurso(Long oidConcurso): Salida");
        
        //Si el concurso esta Vigente, realizamos el refresco de Factoria de Concursos
        ConcursoParametrosGeneralesLocalHome concursoParametrosGeneralesLH = null;
        ConcursoParametrosGeneralesLocal concursoParametrosGeneralesL = null;

        concursoParametrosGeneralesLH = this.getConcursoParametrosGeneralesLocalHome();
        concursoParametrosGeneralesL = concursoParametrosGeneralesLH.findByPrimaryKey(oidConcurso);

        VersionesConcursoLocalHome verConcLHome = null;
        VersionesConcursoLocal verConcLocal = null;
        verConcLHome = this.getVersionesConcursoLocalHome();
        
        verConcLocal = verConcLHome.findByConcursoVersion(concursoParametrosGeneralesL.getOid(),
        concursoParametrosGeneralesL.getVersion());
        
        Long oidVigenciaConcurso = verConcLocal.getVigenciaConcurso();
        
        if(oidVigenciaConcurso.longValue() == ConstantesINC.OID_VIG_CONCU_VIGENTE.longValue()) {
            //Limpiamos la Factoria para que se cargue la primera vez que se necesite.
            FactoriaConcurso.refrescarConcursos();
        }
        
        UtilidadesLog.info("MONConcursoBean.actualizarRefrescoConcurso(Long oidConcurso): Salida");
    }
    
}
