package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.mare.common.mii.services.ejbservice.EJBLocator;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.mae.DTOClasificaciones;
import es.indra.sicc.dtos.mav.DTOBuscarCargaBP;
import es.indra.sicc.dtos.mav.DTOCargaBP;
import es.indra.sicc.dtos.mav.DTODetalleMAV;
import es.indra.sicc.dtos.mav.DTOEValidarProducto;
import es.indra.sicc.dtos.mav.DTOSProductoValidado;
import es.indra.sicc.dtos.mav.DTOValoresDefectoDatosBP;
import es.indra.sicc.dtos.pre.DTOBuscarCodigoVentaPeriodo;
import es.indra.sicc.dtos.seg.DTOAccesosPorCanal;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.mav.AccesosSubaccesosPorDetalleMAVLocal;
import es.indra.sicc.entidades.mav.AccesosSubaccesosPorDetalleMAVLocalHome;
import es.indra.sicc.entidades.mav.DetalleMAVLocal;
import es.indra.sicc.entidades.mav.DetalleMAVLocalHome;
import es.indra.sicc.entidades.mav.SubcriterioAsignacionLocal;
import es.indra.sicc.entidades.mav.SubcriterioAsignacionLocalHome;
import es.indra.sicc.entidades.mav.SubtipoClienteDetalleMAVLocal;
import es.indra.sicc.entidades.mav.SubtipoClienteDetalleMAVLocalHome;
import es.indra.sicc.entidades.mav.TipoDespachoActividadLocalHome;
import es.indra.sicc.entidades.mav.UnidadAdministrativaPorDetalleMAVLocal;
import es.indra.sicc.entidades.mav.UnidadAdministrativaPorDetalleMAVLocalHome;
import es.indra.sicc.entidades.pre.DetalleOfertaLocal;
import es.indra.sicc.entidades.pre.DetalleOfertaLocalHome;
import es.indra.sicc.entidades.pre.MatrizFacturacionLocal;
import es.indra.sicc.entidades.pre.MatrizFacturacionLocalHome;
import es.indra.sicc.entidades.seg.MarcaLocal;
import es.indra.sicc.entidades.seg.MarcaLocalHome;
import es.indra.sicc.entidades.seg.SubaccesoLocal;
import es.indra.sicc.entidades.seg.SubaccesoLocalHome;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.mae.MONConfiguracionClientes;
import es.indra.sicc.logicanegocio.mae.MONConfiguracionClientesHome;
import es.indra.sicc.logicanegocio.mav.MONCargaMantenimientoListas;
import es.indra.sicc.logicanegocio.mav.MONCargaMantenimientoListasHome;
import es.indra.sicc.logicanegocio.mav.MONMantenimientoActividadesMAV;
import es.indra.sicc.logicanegocio.mav.MONMantenimientoActividadesMAVHome;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMF;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMFHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;
import es.indra.sicc.logicanegocio.zon.MONUnidadesAdministrativas;
import es.indra.sicc.logicanegocio.zon.MONUnidadesAdministrativasHome;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.RecuperadorIdiomaDefectoServidor;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;

import javax.rmi.PortableRemoteObject;
//import es.indra.sicc.util.CodigosModulos;


public class MONBusinessPlanningBean implements SessionBean {
    private DetalleMAVLocalHome instanciaDetalleMAV;
    private SubaccesoLocalHome instanciaSubacceso;
    private AccesosSubaccesosPorDetalleMAVLocalHome instanciaAccesosSubaccesosPorDetalleMAV;
    private UnidadAdministrativaPorDetalleMAVLocalHome instanciaUnidadAdministrativaPorDetalleMAV;
    private SubtipoClienteDetalleMAVLocalHome instanciaSubtipoClienteDetalleMAV;
    private TipoDespachoActividadLocalHome instanciaTipoDespachoActividad;
    private MarcaLocalHome instanciaMarca;
    private Entidadi18nLocalHome instanciaI18n;
    private PeriodoLocalHome instanciaPeriodo;
    //private ActividadesMAVLocalHome instanciaActividadesMAV;
    //private PeriodoLocalHome instanciaCraPeriodo;
    private int puntero;
    SessionContext ctx = null;

    public void ejbCreate() {}

    public void ejbActivate() {}

    public void ejbPassivate() {}

    public void ejbRemove() {}

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    public DTOSalida obtieneDetallesMAV(DTODetalleMAV dto) throws MareException {
        UtilidadesLog.info("MONBusinessPlanningBean.obtieneDetallesMAV(DTODetalleMAV dto):Entrada");
        try {
            //UtilidadesLog.debug(dto);
            
            RecordSet rs = new RecordSet();
            DTOSalida dtos = new DTOSalida();
            DAODetalleMAV ddm = new DAODetalleMAV();


            rs = ddm.obtieneDetallesAPT(dto.getActividad(), dto.getPeriodo(), dto.getTipoCliente(), new Long(dto.getIndicadorSituacion().longValue()),
                    dto.getTamanioPagina(), dto.getOidIdioma(), dto.getProdCodSAP(), dto.getUnidadesEstimadas());
            dtos.setResultado(rs);
            UtilidadesLog.info("MONBusinessPlanningBean.obtieneDetallesMAV(DTODetalleMAV dto):Salida");
            return dtos;
        } catch(MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch(MareException ne) {
           UtilidadesLog.error(ne);
            throw ne;
        } catch(Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public DTODetalleMAV obtieneDetalleMAV(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONBusinessPlanningBean.obtieneDetalleMAV(DTOOID dto):Entrada");
        long comienzo = System.currentTimeMillis();
        try {
            //1
            instanciaDetalleMAV = this.getDetalleMAVLocalHome();
            DetalleMAVLocal aux = instanciaDetalleMAV.findByPrimaryKey(dto.getOid());

            //2
            DTODetalleMAV dm = new DTODetalleMAV();

            // Se setea el idioma. Se utiliza en el método 'cargaTextosDetalle'
            dm.setOidIdioma(dto.getOidIdioma());

            //instanciaDetalleMAV = this.getDetalleMAVLocalHome();

            //3 
            dm.setActividad(aux.getOidActividad());
            dm.setBaseEstimadosDestinatarios(aux.getBaseEstimadosDestinatarios());
            dm.setCampagnaEvaluacion(aux.getCampagnaEvaluacion());
            dm.setCatalogo(aux.getOidCatalogo());
            UtilidadesLog.debug("CicloVida Entidad: " + aux.getOidCicloVida());
            dm.setCicloVida(aux.getOidCicloVida());
            dm.setClasificacion(aux.getOidClasificacion());

            // Modif. x ssantana, 9/12/2004
            // Obtiene Codigo Venta (si hay alguno) a partir del oid 
            // de Matriz Facturacion.
            /*UtilidadesLog.debug("Obteniendo Codigo Venta.......");
            Long codigoVenta = aux.getOidMatrizFacturacion();
            dm.setCodigoVenta(codigoVenta);
            UtilidadesLog.debug("" + codigoVenta);
            if (codigoVenta != null)  // Si hay Codigo de Venta, obtiene su valor.
            {
                String sCodigoVenta = this.obtieneCodigoVenta(codigoVenta);
                if (s
                != null)
                  dm.setSCodigoVenta(sCodigoVenta);
                else
                  dm.setSCodigoVenta(null);
            } else // No hay codigo de Venta, setea null
            {
                dm.setSCodigoVenta(null);
            }*/
            
            dm.setCriterio(aux.getCriterio());
            dm.setCurso(aux.getOidCurso());

            if(aux.getEdadDesde() != null)
                dm.setEdadDesde(new Long(aux.getEdadDesde().longValue()));
            else
                dm.setEdadDesde(null);

            if(aux.getEdadHasta() != null)
                dm.setEdadHasta(new Long(aux.getEdadHasta().longValue()));
            else
                dm.setEdadHasta(null);

            dm.setEnviarMensaje(aux.getEnviarMensaje());
            dm.setEstadoMAV(aux.getOidEstadoActividad());
            dm.setEstadoProceso(aux.getOidEstadoProceso());
            dm.setFactorCorreccion(aux.getFactorCorreccion());
            dm.setFormaCobro(aux.getOidFormaCobro());
            dm.setFormaPago(aux.getOidFormaPago());
            dm.setListaClientes(aux.getOidListaClientes());
            dm.setMarcaCondicion(aux.getOidMarcaCondicion());
            dm.setMensaje(aux.getOidMensaje());
            dm.setMonto(aux.getMonto());
            dm.setNegocio(aux.getOidNegocio());
            dm.setNumeroAniversario(aux.getNumeroAniversario());
            dm.setObservaciones(aux.getObservaciones());
            dm.setOid(aux.getOid());
            dm.setPeriodo(aux.getOidPeriodo());
            dm.setPeriodoCurso(aux.getOidPeriodoCurso());
            dm.setPeriodoFin(aux.getOidPeriodoFin());
            dm.setPeriodoFinMonto(aux.getOidPeriodoFinMonto());
            dm.setPeriodoIniMonto(aux.getOidPeriodoIniMonto());
            dm.setPrecio(aux.getPrecio());
            dm.setPrecioContable(aux.getPrecioContable());
            dm.setPrecioEstandar(aux.getPrecioEstandar());

            // sapaza -- PER-SiCC-2010-0628 -- 20/10/2010
            dm.setIndExclusionTipoClasificacion(aux.getIndExclusionTipoClasificacion());

            // sapaza -- PER-SiCC-2010-0674 -- 25/11/2010
            dm.setTipoClienteCriterio(aux.getOidTipoClienteCriterio());
            dm.setSubTipoCliente(aux.getOidSubTipoCliente());

            if(aux.getOidProcedencia() == null)
                dm.setProcedencia(null);
            else
                dm.setProcedencia(aux.getOidProcedencia().toString());

            // Modif. x ssantana, 28/11/2004
            // Obtiene Codigo SAP de producto (si hay alguno) 
            // Nota: si bien en la pantalla es obligatorio al grabar, 
            // en BD no  lo es (asi que puede venir null si se modifico de algun
            // otro lado).
            Long producto = aux.getOidProducto();
            dm.setProducto(producto);
          
            UtilidadesLog.debug("" + producto);
            String sCodSAP = null;
            if (producto != null) {
                sCodSAP = obtieneCodigoSAP(producto);
                UtilidadesLog.debug("Producto " + producto.toString() + ", CodSAP " + sCodSAP);
            } else {
              UtilidadesLog.debug("Producto es null");
            }

            dm.setProdCodSAP(sCodSAP);
            DTOSalida de =  this.descProducto(dm);
            RecordSet rs = de.getResultado(); 
            String desProducto = (String)rs.getValueAt(0,"VAL_I18N");
            dm.setDesProducto(desProducto);
            // Fin Modif. ssantana

            Long subCriterioAsignacion = aux.getOidSubcriterio();
            dm.setSubcriterio(subCriterioAsignacion);

            // Obtiene el criterio de asignacion a partir del Subcriterio
            // Como puede no existir el subcriterio, se contempla que si el subcriterio
            // es NULL, el Criterio de Asignacion es NULL.
            if (subCriterioAsignacion != null){
                UtilidadesLog.debug("subCriterioAsignacion no es NULL");
                SubcriterioAsignacionLocalHome subcriterioLocalHome = new SubcriterioAsignacionLocalHome();
                SubcriterioAsignacionLocal subcriterioLocal = subcriterioLocalHome.findByPrimaryKey(subCriterioAsignacion);
                Long criterioAsignacion = subcriterioLocal.getOidCriterioAsignacion();
                dm.setCriterioAsignacion(criterioAsignacion);
            } else{
                UtilidadesLog.debug("subCriterioAsignacion es NULL - Idem Criterio Asign.");            
                dm.setCriterioAsignacion(null);
            }

            dm.setTipoClasificacion(aux.getOidTipoClasificacion());
            dm.setTipoCliente(aux.getOidTipoCliente());
            dm.setTipoOferta(aux.getOidTipoOferta());
            dm.setUnidadesEstimadas(aux.getUnidadesEstimadas());
            
            //dm.setUnidadesEstimadas(aux.getUnidadesEstimadas());


            if(aux.getUnidadesPorCliente() != null)
                dm.setUnidadesPorCliente(new Integer(aux.getUnidadesPorCliente().toString()));
            else
                dm.setUnidadesPorCliente(null);


            if(aux.getUnidadesTotales() != null)
                dm.setUnidadesTotales(new Integer(aux.getUnidadesTotales().toString()));
            else
                dm.setUnidadesTotales(null);

            dm.setUnidadesTotalesEstimadas(aux.getUnidadesTotalesEstimadas());
            dm.setUnidadNegocio(aux.getOidUnidadNegocio());

            //4
            Long oidDetalle = dto.getOid();

            //5
            instanciaAccesosSubaccesosPorDetalleMAV = new AccesosSubaccesosPorDetalleMAVLocalHome();
            Collection aux1 = instanciaAccesosSubaccesosPorDetalleMAV.findByOidDetaMav(oidDetalle);

            if(aux1.size() > 0) {
                Iterator itaux1 = aux1.iterator();
                Long[] aAccesosSubaccesosPorDetalleMAV = new Long[aux1.size()];
                Long[] aAccesos = new Long[aux1.size()];
                puntero = 0;

                while(itaux1.hasNext()) {
                    AccesosSubaccesosPorDetalleMAVLocal asdml = (AccesosSubaccesosPorDetalleMAVLocal)itaux1.next();
                    SubaccesoLocalHome subLocalHome = new SubaccesoLocalHome();

                    Long oidSubacceso = asdml.getOidSubacceso();

                    SubaccesoLocal subLocal = subLocalHome.findByPrimaryKey(oidSubacceso);

                    Long oidAcceso = subLocal.getOidAcceso();

                    aAccesosSubaccesosPorDetalleMAV[puntero] = oidSubacceso;
                    aAccesos[puntero] = oidAcceso;

                    puntero++;
                }

                dm.setSubaccesos(aAccesosSubaccesosPorDetalleMAV);
                dm.setAccesos(aAccesos);
            }

            //6
            instanciaUnidadAdministrativaPorDetalleMAV = new UnidadAdministrativaPorDetalleMAVLocalHome();
            Collection aux2 = instanciaUnidadAdministrativaPorDetalleMAV.findByOidDetaMav(oidDetalle);

            if(aux2.size() > 0) {
                Iterator itaux2 = aux2.iterator();

                //obtengo tamaño de arrays
                Vector vSubg = new Vector();
                Vector vZona = new Vector();
                Vector vRegion = new Vector();
                Map unidadesRegionZona = new HashMap();

                while(itaux2.hasNext()) {
                    UnidadAdministrativaPorDetalleMAVLocal uadml = (UnidadAdministrativaPorDetalleMAVLocal)itaux2.next();
                    Long oidSubg = uadml.getOidSubgerencia();
                    Long oidZona = uadml.getOidZona();
                    Long oidRegion = uadml.getOidRegion();
                    
                    // sapaza -- PER-SiCC-2010-0699 -- 15/12/2010
                    Long unidades = uadml.getUnidades();
                    if(oidZona!=null) {
                        unidadesRegionZona.put("z" + oidZona.toString(), unidades);
                    } else if (oidRegion!=null) {
                        unidadesRegionZona.put("r" + oidRegion.toString(), unidades);
                    } else {
                        unidadesRegionZona.put("s" + oidSubg.toString(), unidades);
                    }

                    // Modificado por SiCC20070449 - Rafael Romero - 27/09/2007
                    if(oidSubg != null && !vSubg.contains(oidSubg))
                        vSubg.add(oidSubg);

                    if(oidZona != null && !vZona.contains(oidZona))
                        vZona.add(oidZona);

                    if(oidRegion != null && !vRegion.contains(oidRegion))
                        vRegion.add(oidRegion);
                    // Fin modificado SiCC20070449
                }


                if(vSubg.size() > 0) {
                    Long[] aSubg = (Long[])vSubg.toArray(new Long[vSubg.size()]);
                    dm.setSubgerencias(aSubg);
                }

                if(vZona.size() > 0) {
                    Long[] aZona = (Long[])vZona.toArray(new Long[vZona.size()]);
                    dm.setZonas(aZona);
                }

                if(vRegion.size() > 0) {
                    Long[] aRegion = (Long[])vRegion.toArray(new Long[vRegion.size()]);
                    dm.setRegiones(aRegion);
                }

                // sapaza -- PER-SiCC-2010-0699 -- 15/12/2010
                dm.setUnidadesRegionZona(unidadesRegionZona);
            }

            //7
            instanciaSubtipoClienteDetalleMAV = new SubtipoClienteDetalleMAVLocalHome();
            Collection aux3 = instanciaSubtipoClienteDetalleMAV.findByOidDetaMav(oidDetalle);

            // sapaza -- PER-SiCC-2010-0628 -- 20/10/2010
            if(aux3.size() > 0) {
                Iterator itaux3 = aux3.iterator();
                
                //obtengo tamaño de arrays
                Vector vSubTipoCliente = new Vector();
                Vector vTipoClasificacion = new Vector();
                Vector vClasificacion = new Vector();
                
                while(itaux3.hasNext()) {
                    SubtipoClienteDetalleMAVLocal scdm = (SubtipoClienteDetalleMAVLocal)itaux3.next();
                    Long oidSubTipoCliente = scdm.getOidSubtipoCliente();
                    Long oidTipoClasificacion = scdm.getOidTipoClasificacion();                    
                    Long oidClasificacion = scdm.getOidClasificacion();

                    if(oidSubTipoCliente != null && !vSubTipoCliente.contains(oidSubTipoCliente))
                        vSubTipoCliente.add(oidSubTipoCliente);

                    if(oidTipoClasificacion != null && !vTipoClasificacion.contains(oidTipoClasificacion))
                        vTipoClasificacion.add(oidTipoClasificacion);

                    if(oidClasificacion != null && !vClasificacion.contains(oidClasificacion))
                        vClasificacion.add(oidClasificacion);
                }


                if(vSubTipoCliente.size() > 0) {
                    Long[] aSubTipoCliente = (Long[])vSubTipoCliente.toArray(new Long[vSubTipoCliente.size()]);
                    dm.setSubtiposCliente(aSubTipoCliente);
                }

                if(vTipoClasificacion.size() > 0) {
                    Long[] aTipoClasificacion = (Long[])vTipoClasificacion.toArray(new Long[vTipoClasificacion.size()]);
                    dm.setTiposClasificacion(aTipoClasificacion);
                }

                if(vClasificacion.size() > 0) {
                    Long[] aClasificacion = (Long[])vClasificacion.toArray(new Long[vClasificacion.size()]);
                    dm.setClasificaciones(aClasificacion);
                }
            }

            //8
            UtilidadesLog.debug("--- Tipo Despacho");
            instanciaTipoDespachoActividad = new TipoDespachoActividadLocalHome();

            Long tipoDespacho = aux.getOidTipoDespacho();

            if (tipoDespacho != null)
              dm.setTipoDespacho(tipoDespacho);
            else
              dm.setTipoDespacho(null);


            //dm.setIndicadorEnvio(aux4.
            //9
            //periodo desde CRA
            PeriodoLocalHome instanciaCraPeriodo = new PeriodoLocalHome();

            PeriodoLocal pl = instanciaCraPeriodo.findByPrimaryKey(aux.getOidPeriodo());
            dm.setCanal(pl.getOidCanal());
            dm.setMarca(pl.getOidMarca());
            dm.setOidPais(pl.getOidPais());

            //10
            this.cargaTextosDetalle(dm);
            UtilidadesLog.warn("obtieneDetalleMAV --> "+(System.currentTimeMillis()-comienzo));
            UtilidadesLog.info("MONBusinessPlanningBean.obtieneDetalleMAV(DTOOID dto):Salida");
            return dm;
        } catch(FinderException fe) {
            UtilidadesLog.error(fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        } catch(NoResultException fe) {
            UtilidadesLog.error(fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch(MareException ne) {
            UtilidadesLog.error(ne);
            throw ne;
        }
    }

    public void cargaTextosDetalle(DTODetalleMAV dto) throws MareException {
        UtilidadesLog.info("MONBusinessPlanningBean.cargaTextosDetalle(DTODetalleMAV dto):Entrada");

        RecuperadorIdiomaDefectoServidor recuperadorIdioma=new RecuperadorIdiomaDefectoServidor();
        Long idiomaPorDefecto= recuperadorIdioma.getIdiomaDefectoServidor();
        if (dto.getOidIdioma()!=null && idiomaPorDefecto.longValue()!= dto.getOidIdioma().longValue())
            idiomaPorDefecto = dto.getOidIdioma();
        UtilidadesLog.debug("*** idiomaPorDefecto = "+idiomaPorDefecto);

        try {
            //1
            UtilidadesLog.debug("1");
            instanciaMarca = new MarcaLocalHome();
            MarcaLocal aux5 = instanciaMarca.findByPrimaryKey(dto.getMarca());
            dto.setTextoMarca(aux5.getDes_marc());
        } catch(NoResultException fe) {
            UtilidadesLog.error(fe);
            //throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }            

        try {
            //2
            instanciaI18n = new Entidadi18nLocalHome();
            Entidadi18nLocal aux6 = instanciaI18n.findByEntAtrIdioPK("SEG_CANAL", new Long(1), idiomaPorDefecto, dto.getCanal());
            dto.setTextoCanal(aux6.getDetalle());
        } catch(NoResultException fe) {
            UtilidadesLog.error(fe);
            //throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }            

        try {
            //3
            instanciaPeriodo = new PeriodoLocalHome();
            PeriodoLocal aux7 = instanciaPeriodo.findByPrimaryKey(dto.getPeriodo());
            dto.setTextoPeriodo(aux7.getNombrePeriodo());
        } catch(NoResultException fe) {
            UtilidadesLog.error(fe);
            //throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }            

        try {
            //4
            // Modificado por ssantana, 14/12/2004, por incidencia 11073
            // Modificacion por ssantana, 21/12/2004, la actividad puede ser NULL
            instanciaI18n = new Entidadi18nLocalHome();
            if ( dto.getActividad() != null) {
                Entidadi18nLocal i18nActividad = instanciaI18n.findByEntAtrIdioPK("MAV_ACTIV",
                                                                  new Long(1),
                                                                  idiomaPorDefecto,
                                                                  dto.getActividad() );
                dto.setTextoActividad(i18nActividad.getDetalle());
            } else {
              UtilidadesLog.debug("Actividad es NULL");
              dto.setTextoActividad(null);
            }
        } catch(NoResultException fe) {
            UtilidadesLog.error(fe);
            //throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }            

        try {            
            /*
            instanciaActividadesMAV = this.getActividadesMAVLocalHome();
            ActividadesMAVLocal aux8 = instanciaActividadesMAV.findByPrimaryKey(dto.getActividad());
            dto.setTextoActividad(aux8.getDescripcionDetallada());*/
            //SCS veeeeeeeeeeer  dto.setTextoActividad(aux8.);
            //5
            instanciaI18n = new Entidadi18nLocalHome();
            Entidadi18nLocal aux9 = instanciaI18n.findByEntAtrIdioPK("MAE_TIPO_CLIEN", new Long(1), idiomaPorDefecto, 
                    dto.getTipoCliente());
            dto.setTextoTipoCliente(aux9.getDetalle());
            UtilidadesLog.info("MONBusinessPlanningBean.cargaTextosDetalle(DTODetalleMAV dto):Salida");
        } catch(NoResultException fe) {
            UtilidadesLog.error(fe);
            //throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
    }

    public DTOSProductoValidado actualizaDetalleMAV(DTODetalleMAV dto)
        throws MareException {
        
        UtilidadesLog.info("MONBusinessPlanningBean.actualizaDetalleMAV(DTODetalleMAV dto):Entrada");
        
        DetalleMAVLocal aux;
        UtilidadesLog.debug("DTODetalleMAV: " + dto);

        try {

            // sapaza -- PER-SiCC-2010-0699 -- 09/02/2011
            if(dto.getListaClientes() != null) {
                
                Long totalClientesSinUnidades = this.obtieneTotalClientesSinUnidades(dto.getListaClientes());
                
                if((totalClientesSinUnidades > 0) && (dto.getUnidadesEstimadas().longValue() == 0)) {
                    UtilidadesLog.debug("--- MONBusinessPlanning, Unidades Lista esta en 0 y existe cliente sin unidades");
                    throw new MareException("Unidades Lista esta en 0 y existe cliente sin unidades", 
                              UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAV, 
                                        "", ErroresNegocio.MAV_0019));
                }                        
            }

            // sapaza -- PER-SiCC-2010-0580 -- 04/10/2010
            if(dto.getOid() != null) {
                Long totalEnvios = this.obtieneTotalEnvios(dto.getOid());
                
                if(totalEnvios > 0) {
                    UtilidadesLog.debug("--- MONBusinessPlanning, Existe [Envios] relacionados al Detalle MAV");
                    throw new MareException("Existe [Envios] relacionados al Detalle MAV", 
                              UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAV, 
                                        "", ErroresNegocio.MAV_0018));
                }                        
            }    
            

            // Agregado por ssantana, 15/12/2004
            // Se agrega Validacion de Tipo y subtipo de Cliente x gerente de Zona y Region
            // si el criterio de Asig. es por Variable Ventas o Formula.
            Long criterioAsignacion = dto.getCriterioAsignacion();
            if (criterioAsignacion != null && 
                  (criterioAsignacion.longValue() == 2 || 
                   criterioAsignacion.longValue() == 3 ) )
            {
                Boolean tiposClienteValidados = this.validarTipoSubtipoCliente(dto.getOidPais(), dto.getTipoCliente(), dto.getSubtiposCliente());
  
                if ( tiposClienteValidados.booleanValue() == false)
                {
                  // Tira MareException MAE-11
                  UtilidadesLog.debug("--- MONBusinessPlanning, Tipo Cliente o Subtipo no son de ZONA o GERENTE" );
                  throw new MareException("Tipo Cliente o Subtipo no son de ZONA o GERENTE", 
                            UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAV, 
                                      "",
                                      ErroresNegocio.MAV_0011));
                }
            }
            
            // Agregado por ssantana, 6/1/2005
            // Si existe un Período Fin, se valida que éste sea posterior al Periodo Inicio.
            // (siempre y cuando Periodo Fin y Inicio sean distintos).
            if (dto.getPeriodoFin() != null)
            {
               Boolean validado = this.validaPeriodos(dto.getPeriodo(), dto.getPeriodoFin(), dto.getOidPais() );
               if ( !validado.booleanValue() )
               {
                 UtilidadesLog.debug("No se validó Periodo. Tirando Exception....");
                 throw new MareException("Periodo Fin es anterior a Periodo Inicio", 
                              UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAV,
                                                                "",
                                                                ErroresNegocio.MAV_PERIODO_FIN_ANTERIOR_A_PERIODO_INICIO)
                                        );
               }
            }
            
            UtilidadesLog.debug("1");
            DTOSProductoValidado dtospv = new DTOSProductoValidado();

            //1
            UtilidadesLog.debug("2");

            //2
            UtilidadesLog.debug("3");
            instanciaTipoDespachoActividad = new TipoDespachoActividadLocalHome();

            //SCS este finder esta para el culo, le faltan parametros, segun modelado..........
            UtilidadesLog.debug("4");

            Long oidTipoDespachoActividad = dto.getTipoDespacho();
            Long actividad = dto.getActividad();
            //Long envioConSolicitud = dto.getIndicadorEnvio();

/*            UtilidadesLog.debug("Ejecuta Finder....");
            Collection col = instanciaTipoDespachoActividad.findByCampos(tipoDespacho, actividad, envioConSolicitud);
            UtilidadesLog.debug("Ejecuto Finder....");

            Long oidTipoDespachoActividad = null;

            if(!col.isEmpty()) {
                Iterator it = col.iterator();
                TipoDespachoActividadLocal tipoDespachoActividadLocal = (TipoDespachoActividadLocal)it.next();
                oidTipoDespachoActividad = tipoDespachoActividadLocal.getOid();
                UtilidadesLog.debug("oidTipoDespachoActividad: " + oidTipoDespachoActividad.toString());
            }*/

            //3
            UtilidadesLog.debug("5");
            Long oidDetalle = null;
            StringBuffer statement = new StringBuffer("");

            // Agregado de SSantana, 28/11/2004
            // Desc: Valida que existe realmente ese CodigoSAP
            // Si no existe, aborta acá mismo tirando la excepcion que indica eso.
            // Si existe, obtiene el oid de Producto, lo setea en el DTO y procede a grabar.
            String sCodSAP = dto.getProdCodSAP();
            UtilidadesLog.debug("Codigo SAP: " + sCodSAP);
                
            Long oidProducto = obtieneOid(sCodSAP, dto.getOidPais());
            if (oidProducto != null)
            {
              UtilidadesLog.debug("oidProducto es " + oidProducto.toString());                  
              dto.setProducto(oidProducto);                     
            }
            else
            {
              UtilidadesLog.debug("Oid Producto es null ");
              throw new MareException("CODSAP no existe en MAE_PRODU", 
              //  UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_MAV, "", ErroresNegocio.MAV_0001));
                UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_MAV, "", ErroresNegocio.MAV_PRODUCTO_NO_EXISTENTE) );             
                
            }

            // Ahora valida Cod. de Venta. 
            // Por inc. 11056, hecho por ssantana, 8/12/2004.
            // Busca el Oid de Matriz Facturacion correspondiente al Codigo de Venta
            // Ingresado, y lo setea en dto.setCodigoVenta(Long);
            // -----------------------------------------------------------------------
            // Por inc. 11532, ahora Codigo de Venta puede venir vacio y se obtiene a partir 
            // del Producto. Si viene Codigo de VEnta, entonces se esta en Detalle y ya tenemos 
            // el Oid de Matriz de Facturacion
            
            //dto.setCodigoVenta(null);
            
            // Modificado por ssantana, 1/8/2005, x inc. BELC300015618
            // Se quita manejo de Codigo Venta en este Caso de Uso. 
            /* String sCodigoVenta = dto.getSCodigoVenta();
           
            if ( sCodigoVenta == null || sCodigoVenta.equals("") )
            {
                UtilidadesLog.debug("Obtenemos Codigo de Venta");
                UtilidadesLog.debug("SCodigoVenta: " + sCodigoVenta);
                dtospv = this.validaProducto(dto);       
                UtilidadesLog.debug("******************* DTOSPV: " + dtospv);                
            
                Long oidPais = dto.getOidPais();
                Long oidPeriodo = dto.getPeriodo();
                Long oidMarca = dto.getMarca();
                Long oidCanal = dto.getCanal();
                Long oidMatrizFacturacion = this.verificaCodigoVenta(dtospv.getCodigoVenta(),
                                                  oidPais,
                                                  oidMarca,
                                                  oidCanal,
                                                  oidPeriodo);
    
                dto.setCodigoVenta(oidMatrizFacturacion);
            } else {
              UtilidadesLog.debug("Codigo Venta ya existe - Oid Codigo Venta ya viene de la pantalla");
              UtilidadesLog.debug("Viejo Codigo Venta es: " + dto.getCodigoVenta().toString() );
            } */
            // Fin Modificacion por ssantana, 1/8/2005, x inc. BELC300015618

            if(dto.getOid() != null) {
                // Realiza el UPDATE 
                // *****************
                int count = 0;
                oidDetalle = dto.getOid();
                this.armaUpdateDetalle(dto, oidDetalle, oidTipoDespachoActividad);
            } else {
                // INSERT: oidDetalle tiene que tener el valor del resultado
                // de incrementar la secuencia.
                oidDetalle = SecuenciadorOID.obtenerSiguienteValor("MAV_DENV_SEQ");
                String sql = " INSERT INTO MAV_DETAL_MAV ( OID_DETA_MAV, VAL_PREC_STND, VAL_PREC, VAL_PREC_CONT, TICL_OID_TIPO_CLIE, PERD_OID_PERI ) VALUES ( ?, ?, ?, ?, ?, ? ) ";
                Vector vec = new Vector();
                vec.add(oidDetalle);
                // Modificado por SICC20070356 - Rafael Romero - 05/09/2007
                vec.add(dto.getPrecioEstandar()!=null ? dto.getPrecioEstandar() : new Double(0.0)); // Precios
                vec.add(dto.getPrecio()!=null ? dto.getPrecio() : new Double(0.0)); // Precios
                // Fin modificado SICC20070356
                Double dPrecioContable = dto.getPrecioContable();
                if (dPrecioContable !=  null) {
                  vec.add(dPrecioContable); // Precios
                } else {
                  vec.add(new Double(0.0));
                }
                vec.add(dto.getTipoCliente()); // Tipo CLiente
                vec.add(dto.getPeriodo()); // Periodo     

                UtilidadesLog.debug(" ------- Ejecutando ");
                BelcorpService belcorpService = BelcorpService.getInstance();

                try {
                    int cod = belcorpService.dbService.executePreparedUpdate(sql, vec);
                } catch(Exception ex) {
                    UtilidadesLog.debug("Insercion de Detalle Fallo");
                    UtilidadesLog.error(ex);
                    throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }

                // Ahora actualiza la tupla creada con todos los valores correspondientes 
                UtilidadesLog.debug(" ------- Actualizacion luego de insercion");

                dto.setOid(oidDetalle);
                this.armaUpdateDetalle(dto, oidDetalle, oidTipoDespachoActividad);

                UtilidadesLog.debug(" ------- Ejecutando ");
            }

            UtilidadesLog.debug(" ****** Termino trabajo en DetalleMAV ******** ");

            this.eliminaRegistrosSubaccesosMAV(oidDetalle);
            this.eliminaRegistrosUAPorDetalleMAV(oidDetalle);
            this.eliminaRegistrosSubtipoClienteMAV(oidDetalle);
            this.insertaSubaccesoMAV(oidDetalle, dto.getSubaccesos());
            
            // sapaza -- PER-SiCC-2010-0628 -- 20/10/2010
            this.insertaTipoClientePorDetalleMAV(oidDetalle, dto.getSubtiposCliente(), dto.getTiposClasificacion(), dto.getClasificaciones());
            
            // sapaza -- PER-SiCC-2010-0699 -- 12/12/2010
            this.insertaUAPorDetalleMAV(oidDetalle, dto.getSubgerencias(), dto.getRegiones(), dto.getZonas(), dto.getUnidadesRegionZona());
           
        } catch(MareServiceException e) {
            UtilidadesLog.debug("Actualiza - MareException");
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(MareException ex) {
        
             BelcorpError belcorpError = new BelcorpError();
             DTOError dtoError = belcorpError.obtenerError(ex);
             UtilidadesLog.debug("cod error: " + dtoError.getCodigoError());
             if(dtoError.getCodigoError().equals("50035"))
                throw new MareException(new Exception(),
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAV,"",ErroresNegocio.MAV_0111));                                                   

            UtilidadesLog.debug("Error");
            UtilidadesLog.error(ex);
            ctx.setRollbackOnly();
            throw ex;
        }
        
        DTOSProductoValidado dtoRetorno = new DTOSProductoValidado();
        UtilidadesLog.info("MONBusinessPlanningBean.actualizaDetalleMAV(DTODetalleMAV dto):Salida");        
        return dtoRetorno;
    }

    public DTOSProductoValidado validaProducto(DTODetalleMAV dto)
        throws MareException {
        UtilidadesLog.info("MONBusinessPlanningBean.validaProducto(DTODetalleMAV dto):Entrada");
        try {
            instanciaSubacceso = new SubaccesoLocalHome();
            UtilidadesLog.debug("ValidaProducto");

            //1
            DTOEValidarProducto dtoE = new DTOEValidarProducto();

            dtoE.setOidPais(dto.getOidPais());
            dtoE.setPais(dto.getOidPais());
            dtoE.setOidIdioma(dto.getOidIdioma());
            dtoE.setMarca(dto.getMarca());
            dtoE.setCanal(dto.getCanal());
            dtoE.setPeriodo(dto.getPeriodo());
            dtoE.setPeriodoFin(dto.getPeriodoFin());
            dtoE.setTipoOferta(dto.getTipoOferta());
            dtoE.setCicloVida(dto.getCicloVida());
            dtoE.setFormaPago(dto.getFormaPago());
            
/*            UtilidadesLog.debug("Toma Catalogo, catalogo es " + dto.getCatalogo() );
            dtoE.set
            dtoE.setOidCatalogo(dto.getCatalogo());*/

            // Modificado por ssantana, 21/12/2004, espera Codigo SAP si no pincha
            // porque como está, está recibiendo el OID de Producto.
/*            if(dto.getProducto() == null)
                dtoE.setCodigoSAP(null);
            else
                dtoE.setCodigoSAP(dto.getProducto().toString());*/

            if(dto.getProdCodSAP() == null)
                dtoE.setCodigoSAP(null);
            else
                dtoE.setCodigoSAP(dto.getProdCodSAP().toString());                

            // Fin Modific. de ssantana, 21/12/2004
            dtoE.setPrecioCatalogo(dto.getPrecio());
            dtoE.setPrecioContable(dto.getPrecioContable());

            UtilidadesLog.debug("ValidaProducto 1");

            if(dto.getSubaccesos().length == 1) {
                UtilidadesLog.debug("dto.getSubaccesos().length == 1");
                Long[] oidsA = dto.getSubaccesos();

                SubaccesoLocal aux = instanciaSubacceso.findByPrimaryKey(oidsA[0]);
                dtoE.setOidAcceso(aux.getOidAcceso());
                dtoE.setOidSubacceso(oidsA[0]);
            } else {
                UtilidadesLog.debug("dto.getSubaccesos().length != 1");
                dtoE.setOidAcceso(null);
                dtoE.setOidSubacceso(null);
            }

            //2
            UtilidadesLog.debug("ValidaProducto 2");
            DTOSProductoValidado dtopv = new DTOSProductoValidado();
            MONCargaMantenimientoListasHome cargaMantenimHome = this.getMONCargaMantenimientoListasHome();
            MONCargaMantenimientoListas cargaMantenim = cargaMantenimHome.create();

            UtilidadesLog.debug("DTOE en MONBP.ValidarProductos(): " + dtoE);

            dtopv = cargaMantenim.validarProductos(dtoE);

            //3
            UtilidadesLog.debug("Sale de ValidaProducto - " + dtopv);
            UtilidadesLog.info("MONBusinessPlanningBean.validaProducto(DTODetalleMAV dto):Salida");
            return dtopv;
        } catch(NoResultException exception) {
            UtilidadesLog.debug("ValidaProductos - MareException");
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }catch(MareException me) {
            UtilidadesLog.error(me);
            throw  me;
        } catch(Exception exception) {
            UtilidadesLog.debug("ValidaProductos - MareException");
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
    }

    public DTOCargaBP cargaPaginaBP(DTOBuscarCargaBP dto) throws MareException {
        UtilidadesLog.info("MONBusinessPlanningBean.cargaPaginaBP(DTOBuscarCargaBP dto):Entrada");
        DTOCargaBP dtoCBP = new DTOCargaBP();

        try {
            MONMantenimientoActividadesMAVHome monMantActHome = this.getMONMantenimientoActividadesMAVHome();
            MONMantenimientoActividadesMAV monMantAct = monMantActHome.create();

            // **** Subtipos cliente ****
            // Cambio por ssantana, 22/6/2005
            
            //DTOSalida sc = monMantAct.obtenerSubtiposCliente(dto)
            DTOOID dtoOid = new DTOOID();
            dtoOid.setOid(dto.getOidActividadMAV());
            dtoOid.setOidPais(dto.getOidPais());
            dtoOid.setOidIdioma(dto.getOidIdioma());
            DTOSalida sc = monMantAct.obtenerSubtiposClienteMAV(dtoOid);

            //asigno....
            RecordSet r = sc.getResultado();

            if(r != null)
                UtilidadesLog.debug(" ---- RecordSet Subtipos Clientes: " + r.toString());

            dtoCBP.setSubtipoCliente(r);

            MONConfiguracionClientesHome monConfigClientesHome = this.getMONConfiguracionClientesHome();
            MONConfiguracionClientes monConfigClientes = monConfigClientesHome.create();

            // **** Clasificaciones ****
            DTOClasificaciones dtoClas = monConfigClientes.obtenerClasificaciones(dto);

            //asigno....
            r = dtoClas.getClasificacion();

            if(r != null)
                UtilidadesLog.debug(" ---- RecordSet Clasificacion: " + r.toString());

            dtoCBP.setClasificacion(dtoClas.getClasificacion());

            // **** Tipo Clasificacion ****
            r = dtoClas.getTipoClasificacion();

            if(r != null)
                UtilidadesLog.debug(" ---- RecordSet tipos: " + r.toString());

            dtoCBP.setTipoClasificacion(dtoClas.getTipoClasificacion());

            // **** Accesos ****
            MONMantenimientoSEGHome monMantSEGHome = this.getMONMantenimientoSEGHome();
            MONMantenimientoSEG monMantSEG = monMantSEGHome.create();
            
            // Modificado por ssantana, 11/1/2005
            // Se cambia la llamada a método de MONMantenimientoSEG para
            // filtrar por Canales.
            DTOAccesosPorCanal dtoAccesosPorCanal = new DTOAccesosPorCanal();
            dtoAccesosPorCanal.setOidCanal(dto.getOidCanal());
            dtoAccesosPorCanal.setOidIdioma(dto.getOidIdioma());
            DTOSalida dtoSal = monMantSEG.recuperarAccesosPorCanal(dtoAccesosPorCanal);
            //DTOSalida dtoSal = monMantSEG.recuperarAccesos(dto);

            //asigno....
            r = dtoSal.getResultado();

            if(r != null)
                UtilidadesLog.debug(" ---- RecordSet Accesos: " + r.toString());

            dtoCBP.setAcceso(dtoSal.getResultado());

            // **** Subaccesos ****
            DTOSalida dtoSal1 = monMantSEG.recuperarSubaccesos(dto);
            r = dtoSal1.getResultado();

            if(r != null)
                UtilidadesLog.debug(" ---- RecordSet Subaccesos: " + r.toString());

            //asigno....
            dtoCBP.setSubacceso(dtoSal1.getResultado());

            DTOUnidadAdministrativa dtoUA = new DTOUnidadAdministrativa();

            dtoUA.setOidPais(dto.getOidPais());
            dtoUA.setOidCanal(dto.getOidCanal());
            dtoUA.setOidMarca(dto.getOidMarca());

            MONUnidadesAdministrativasHome monUAHome = this.getMONUnidadesAdministrativasHome();
            MONUnidadesAdministrativas monUA = monUAHome.create();

            // **** Subgerencias ****
            r = monUA.obtenerSubgerenciaVentas(dtoUA);

            if(r != null)
                UtilidadesLog.debug(" ---- RecordSet Subgerencias Venta: " + r.toString());

            dtoCBP.setSubgerencia(r);

            // **** Regiones x SubGV ****
            DTOSalida dtoSalida = monUA.obtenerRegionesPorSGV(dtoUA);
            r = dtoSalida.getResultado();

            if(r != null)
                UtilidadesLog.debug(" ---- RecordSet Regiones: " + r.toString());

            dtoCBP.setRegion(r);

            // **** Zonas x regiones ****
            dtoSalida = monUA.obtenerZonasPorRegiones(dtoUA);
            r = dtoSalida.getResultado();

            if(r != null)
                UtilidadesLog.debug(" ---- RecordSet Zonas: " + r.toString());

            dtoCBP.setZona(r);
            
            // Agregado por Incidencia SICC20070356 - Rafael Romero - 05/09/2007
            
            DTOValoresDefectoDatosBP dtoVDE = new DTOValoresDefectoDatosBP();
            dtoVDE.setOidActividad(dto.getOidActividadMAV());
            dtoVDE.setOidPais(dto.getOidPais());
            
            DAOMantenimientoParametrosDBP daoMPDBP = new DAOMantenimientoParametrosDBP();
            DTOSalida dtoVDS = daoMPDBP.obtenerValoresDefectoPorActividad(dtoVDE);
            
            dtoCBP.setValoresDefecto(dtoVDS.getResultado());
            
            // Fin agregado incidencia SICC20070356
            
            // sapaza -- PER-SiCC-2013-0355 -- 04/04/2013
             String indValidaPrecioContable = daoMPDBP.obtenerValorParametroPais(dto.getOidPais(), "MAV","002");
             dtoCBP.setIndValidaPrecioContable(indValidaPrecioContable);
            
            // sapaza -- PER-SiCC-2013-0432 -- 18/04/2013
            String descripcionAlmacen = daoMPDBP.obtenerDescripcionAlmacen(dto.getOidActividadMAV(), dto.getOidIdioma());
            dtoCBP.setDescripcionAlmacen(descripcionAlmacen); 
            
            UtilidadesLog.info("MONBusinessPlanningBean.cargaPaginaBP(DTOBuscarCargaBP dto):Salida");
            return dtoCBP;
        } catch(MareException ne) {
            UtilidadesLog.error(ne);
            throw ne;
        } catch(Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    private DetalleMAVLocalHome getDetalleMAVLocalHome() throws MareException {
        String codigoError;
        EJBLocator servicioEjbLocator;
        DetalleMAVLocalHome localHome = null;
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.debug("Excepcion BelcorpService");
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            localHome = (DetalleMAVLocalHome)bs.ejbLocator.getEntityLocalHome("java:comp/env/DetalleMAV");
        } catch(MareServiceException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.debug("Excepcion Obtener Local Home");
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        return localHome;
    }


    private MONMantenimientoActividadesMAVHome getMONMantenimientoActividadesMAVHome()
        throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONMantenimientoActividadesMAVHome)PortableRemoteObject.narrow(context.lookup("MONMantenimientoActividadesMAV"),
            MONMantenimientoActividadesMAVHome.class);
    }

    private MONConfiguracionClientesHome getMONConfiguracionClientesHome()
        throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONConfiguracionClientesHome)PortableRemoteObject.narrow(context.lookup("MONConfiguracionClientes"),
            MONConfiguracionClientesHome.class);
    }

    private MONMantenimientoSEGHome getMONMantenimientoSEGHome()
        throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONMantenimientoSEGHome)PortableRemoteObject.narrow(context.lookup("MONMantenimientoSEG"),
            MONMantenimientoSEGHome.class);
    }

    private MONUnidadesAdministrativasHome getMONUnidadesAdministrativasHome()
        throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONUnidadesAdministrativasHome)PortableRemoteObject.narrow(context.lookup("MONUnidadesAdministrativas"),
            MONUnidadesAdministrativasHome.class);
    }


    private String cargaCampo(Vector vec, String campoDB, Object parametro) {
        UtilidadesLog.info("MONBusinessPlanningBean.cargaCampo(Vector vec, String campoDB, Object parametro):Entrada");
        if(parametro != null) {
            vec.add(parametro);
            UtilidadesLog.debug(campoDB + " = " + parametro.toString());
            UtilidadesLog.info("MONBusinessPlanningBean.cargaCampo(Vector vec, String campoDB, Object parametro):Salida");
            return new String(" " + campoDB + " = ?,");
        } else {
            UtilidadesLog.debug(" " + campoDB + " = NULL,");
            UtilidadesLog.info("MONBusinessPlanningBean.cargaCampo(Vector vec, String campoDB, Object parametro):Salida");
            return new String(" " + campoDB + " = NULL,");
        }
    }

    private void armaUpdateDetalle(DTODetalleMAV dto, Long oidDetalle, Long oidTipoDespachoActividad)
        throws MareException {
        // Realiza el Update sobre una tupla de MAV_DETAL_MAV
        
        UtilidadesLog.info("MONBusinessPlanningBean.armaUpdateDetalle(DTODetalleMAV dto, Long oidDetalle, Long oidTipoDespachoActividad):Entrada");
        Vector vec = new Vector();
        StringBuffer statement = new StringBuffer("");
        statement.append(" UPDATE MAV_DETAL_MAV SET ");
        statement.append(cargaCampo(vec, "VAL_BASE_ESTI_DEST", dto.getBaseEstimadosDestinatarios()));
        statement.append(cargaCampo(vec, "VAL_CAMP_EVAL", dto.getCampagnaEvaluacion()));

        if((dto.getCriterio() == null) || dto.getCriterio().equals(""))
            statement.append(cargaCampo(vec, "VAL_CRIT", null));
        else
            statement.append(cargaCampo(vec, "VAL_CRIT", dto.getCriterio()));

        statement.append(cargaCampo(vec, "VAL_EDAD_DESD", dto.getEdadDesde()));
        statement.append(cargaCampo(vec, "VAL_EDAD_HAST", dto.getEdadHasta()));

        //statement.append(cargaCampo(vec, "IND_ENVI_MENS", dto.getIndicadorEnvio()));
        if(dto.getEnviarMensaje() == null)
            statement.append(cargaCampo(vec, "IND_ENVI_MENS", null));
        else
            statement.append(cargaCampo(vec, "IND_ENVI_MENS", dto.getEnviarMensaje()));

        // sapaza -- PER-SiCC-2010-0628 -- 20/10/2010
        if(dto.getIndExclusionTipoClasificacion() == null)
            statement.append(cargaCampo(vec, "IND_EXCL_TIPO_CLAS", null));
        else
            statement.append(cargaCampo(vec, "IND_EXCL_TIPO_CLAS", dto.getIndExclusionTipoClasificacion()));

        statement.append(cargaCampo(vec, "VAL_FACT_CORR", dto.getFactorCorreccion()));
        statement.append(cargaCampo(vec, "VAL_MONT", dto.getMonto()));
        statement.append(cargaCampo(vec, "NUM_ANIV", dto.getNumeroAniversario()));

        if((dto.getObservaciones() == null) || dto.getObservaciones().equals(""))
            statement.append(cargaCampo(vec, "VAL_OBSE", null));
        else
            statement.append(cargaCampo(vec, "VAL_OBSE", dto.getObservaciones()));

        //statement.append(cargaCampo(vec, "OID_DETA_MAV", dto.getOid()));
        statement.append(cargaCampo(vec, "ACTI_OID_ACTI", dto.getActividad()));
        statement.append(cargaCampo(vec, "OCAT_OID_CATA", dto.getCatalogo()));


        // Ssantana, 20/12/2004
        // Se cambia ACCV_OID_ACTI_CICL_VIDA por CIVI_OID_CICL_VIDA
        // por cambio en la relación en MAV_DETAL_MAV
        //statement.append(cargaCampo(vec, "ACCV_OID_ACTI_CICL_VIDA", dto.getCicloVida()));        
        statement.append(cargaCampo(vec, "CIVI_OID_CICL_VIDA", dto.getCicloVida()));

        
        statement.append(cargaCampo(vec, "CLAS_OID_CLAS", dto.getClasificacion()));
        statement.append(cargaCampo(vec, "MCUR_OID_CURS", dto.getCurso()));

        //statement.append(cargaCampo(vec, "AEST_OID_ESTA_ACTI", dto.getEstadoMAV()));
        statement.append(cargaCampo(vec, "AEST_OID_ESTA_ACTI", dto.getEstadoMAV()));

        //        statement.append(cargaCampo(vec, "TEPR_OID_TIPO_ESTA_PROC", dto.getEstadoProceso()));
        statement.append(cargaCampo(vec, "FCOB_OID_FORM_COBR", dto.getFormaCobro()));
        
        if (dto.getFormaPago() == null || dto.getFormaPago().equals("") )
          statement.append(cargaCampo(vec, "FOPA_OID_FORM_PAGO", null));
        else
          statement.append(cargaCampo(vec, "FOPA_OID_FORM_PAGO", dto.getFormaPago()));
          
        statement.append(cargaCampo(vec, "LICL_OID_LIST_CLIE", dto.getListaClientes()));
        statement.append(cargaCampo(vec, "MAPR_OID_MARC_PROD", dto.getMarcaCondicion()));

        // Solamente se modifica Codigo de Venta si se recibe uno existente. Si no, 
        // se deja sin grabar (se asume que ya existe entonces y por lo tanto no se pisa.
        
        // Modificado por ssantana, 1/8/2005, x inc. BELC300015618
        /*Long codigoVenta = dto.getCodigoVenta();
        if (codigoVenta != null)
        { 
          UtilidadesLog.debug("Codigo de a grabar: " + codigoVenta.toString() );
          statement.append(cargaCampo(vec, "MAFA_OID_MATR_FACT", codigoVenta));
        }*/
        // Fin Modificacion por ssantana, 1/8/2005, x inc. BELC300015618
        
        statement.append(cargaCampo(vec, "MENS_OID_MENS", dto.getMensaje()));
        statement.append(cargaCampo(vec, "NEGO_OID_NEGO", dto.getNegocio()));
        statement.append(cargaCampo(vec, "PERD_OID_PERI", dto.getPeriodo()));
        statement.append(cargaCampo(vec, "PERD_OID_PERI_FINA", dto.getPeriodoFin()));
        statement.append(cargaCampo(vec, "PERD_OID_PERI_FINA_MONT", dto.getPeriodoFinMonto()));
        statement.append(cargaCampo(vec, "PERD_OID_PERI_INIC_MONT", dto.getPeriodoIniMonto()));

        // DMCO: procedencia = Si (dto.oid!=null) se pone 1 y sino 2 
        if(dto.getOid() != null)
            statement.append(cargaCampo(vec, "PRDN_OID_PROC", "1"));
        else
            statement.append(cargaCampo(vec, "PRDN_OID_PROC", "2"));

        statement.append(cargaCampo(vec, "PROD_OID_PROD", dto.getProducto()));
        statement.append(cargaCampo(vec, "SCAS_OID_SUBC", dto.getSubcriterio()));
        statement.append(cargaCampo(vec, "TICL_OID_TIPO_CLIE", dto.getTipoCliente()));
        statement.append(cargaCampo(vec, "ATDE_OID_ACTI_TIPO_DESP", oidTipoDespachoActividad));

        // Ssantana, 20/12/2004
        // Se cambia ACCV_OID_ACTI_CICL_VIDA por CIVI_OID_CICL_VIDA
        // por cambio en la relación en MAV_DETAL_MAV
        //statement.append(cargaCampo(vec, "ATOF_OID_TIPO_OFER_ACTI", dto.getTipoOferta()));
        statement.append(cargaCampo(vec, "TOFE_OID_TIPO_OFER", dto.getTipoOferta()));

        statement.append(cargaCampo(vec, "UNEG_OID_UNID_NEGO", dto.getUnidadNegocio()));
        // Modificado por SICC20070356 - Rafael Romero - 05/09/2007
        statement.append(cargaCampo(vec, "VAL_PREC", dto.getPrecio()!=null ? dto.getPrecio() : new Double(0.0)));
        
        Double dPrecioContable = dto.getPrecioContable();
        if (dPrecioContable == null ) {
           dPrecioContable = new Double(0.0);
        } 
        statement.append(cargaCampo(vec, "VAL_PREC_CONT", dPrecioContable));
              
        statement.append(cargaCampo(vec, "VAL_PREC_STND", dto.getPrecioEstandar()!=null ? dto.getPrecioEstandar() : new Double(0.0)));
        // Fin modificado SICC20070356      
        statement.append(cargaCampo(vec, "NUM_UNID_ESTI", dto.getUnidadesEstimadas()));
        statement.append(cargaCampo(vec, "NUM_UNID_CLIE", dto.getUnidadesPorCliente()));
        statement.append(cargaCampo(vec, "NUM_UNID_TOTA", dto.getUnidadesTotales()));
        statement.append(cargaCampo(vec, "NUM_UNID_TOTA_ESTI", dto.getUnidadesTotalesEstimadas()));
        statement.append(cargaCampo(vec, "PERD_OID_PERI_CURS", dto.getPeriodoCurso()));
        statement.append(cargaCampo(vec, "TCCL_OID_TIPO_CLAS", dto.getTipoClasificacion()));
        statement.append(cargaCampo(vec, "tepr_oid_tipo_esta_proc", "2"));

        // sapaza -- PER-SiCC-2010-0674 -- 25/11/2010            
        statement.append(cargaCampo(vec, "TICL_OID_TIPO_CLIE_CRIT", dto.getTipoClienteCriterio()));
        statement.append(cargaCampo(vec, "SBTI_OID_SUBT_CLIE", dto.getSubTipoCliente()));

        statement.deleteCharAt(statement.length() - 1);
        statement.append(" WHERE 1=1 AND OID_DETA_MAV = ? ");

        vec.add(oidDetalle);

        BelcorpService bs = BelcorpService.getInstance();

        try {
            int retorno = bs.dbService.executePreparedUpdate(statement.toString(), vec);
            UtilidadesLog.info("MONBusinessPlanningBean.armaUpdateDetalle(DTODetalleMAV dto, Long oidDetalle, Long oidTipoDespachoActividad):Salida");
        } catch(Exception ex) {
            //ctx.setRollbackOnly();              
            UtilidadesLog.debug("Pincho en el UPDATE de DetalleMAV");
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    private void eliminaRegistrosUAPorDetalleMAV(Long oidDetalleMAV)
        throws MareException {
        UtilidadesLog.info("MONBusinessPlanningBean.eliminaRegistrosUAPorDetalleMAV(Long oidDetalleMAV):Entrada");
        
        BelcorpService bs = BelcorpService.getInstance();
        StringBuffer sql = new StringBuffer("DELETE FROM mav_detal_mav_unida_admin m ");
        sql.append(" WHERE m.DENV_OID_DETA_MAV = " + oidDetalleMAV.toString());

        try {
            int retorno = bs.dbService.executeUpdate(sql.toString());
        } catch(Exception ex) {
            UtilidadesLog.debug("Error al eliminar Tuplas U. Administrativa");
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }

        UtilidadesLog.info("MONBusinessPlanningBean.eliminaRegistrosUAPorDetalleMAV(Long oidDetalleMAV):Salida");
        return;
    }

    private void eliminaRegistrosSubtipoClienteMAV(Long oidDetalleMAV)
        throws MareException {
        UtilidadesLog.info("MONBusinessPlanningBean.eliminaRegistrosSubtipoClienteMAV(Long oidDetalleMAV):Entrada");
        BelcorpService bs = BelcorpService.getInstance();
        StringBuffer sql = new StringBuffer("DELETE FROM mav_subti_clien_detal m ");
        sql.append(" WHERE m.DENV_OID_DETA_MAV = " + oidDetalleMAV.toString());

        try {
            int retorno = bs.dbService.executeUpdate(sql.toString());
        } catch(Exception ex) {
            UtilidadesLog.debug("Error al eliminar tuplas U. Subtipo Cliente");
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }

        UtilidadesLog.info("MONBusinessPlanningBean.eliminaRegistrosSubtipoClienteMAV(Long oidDetalleMAV):Salida");
        return;
    }

    private void eliminaRegistrosSubaccesosMAV(Long oidDetalleMAV)
        throws MareException {
        UtilidadesLog.info("MONBusinessPlanningBean.eliminaRegistrosSubaccesosMAV(Long oidDetalleMAV):Entrada");
        BelcorpService bs = BelcorpService.getInstance();
        StringBuffer sql = new StringBuffer("DELETE FROM mav_detal_mav_acces_subac m ");
        sql.append(" WHERE m.DENV_OID_DETA_MAV = " + oidDetalleMAV.toString());

        try {
            int retorno = bs.dbService.executeUpdate(sql.toString());
        } catch(Exception ex) {
            UtilidadesLog.debug("Error al eliminar tuplas Subaccesos");
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }

        UtilidadesLog.info("MONBusinessPlanningBean.eliminaRegistrosSubaccesosMAV(Long oidDetalleMAV):Salida");
        return;
    }

    private void insertaSubaccesoMAV(Long oidDetalleMAV, Long[] subacceso)
        throws MareException {
        UtilidadesLog.info("MONBusinessPlanningBean.insertaSubaccesoMAV(Long oidDetalleMAV, Long[] subacceso):Entrada");
        BelcorpService bs = BelcorpService.getInstance();

        for(int i = 0; i < subacceso.length; i++) {
            UtilidadesLog.debug("Bucle Subacceso " + i);
            UtilidadesLog.debug("oidDetalle: " + oidDetalleMAV.toString() + " - aSubacc: " + subacceso[i].toString());
            Long oidSubacceso = SecuenciadorOID.obtenerSiguienteValor("MAV_DMAS_SEQ");
            StringBuffer sqlInsertaSubacceso = new StringBuffer(
                    "INSERT INTO mav_detal_mav_acces_subac ( OID_DETA_MAV_ACCE_SUBA, DENV_OID_DETA_MAV, SBAC_OID_SBAC ) VALUES ( ");
            sqlInsertaSubacceso.append(oidSubacceso.toString() + ", " + oidDetalleMAV.toString());
            sqlInsertaSubacceso.append(", " + subacceso[i].toString() + ")");

            try {
                int retorno = bs.dbService.executeUpdate(sqlInsertaSubacceso.toString());
            } catch(Exception ex) {
                //ctx.setRollbackOnly();
                UtilidadesLog.debug("Pincho en Insert en subacceso");
                UtilidadesLog.error(ex);
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }

        UtilidadesLog.info("MONBusinessPlanningBean.insertaSubaccesoMAV(Long oidDetalleMAV, Long[] subacceso):Salida");
        return;
    }

    private void insertaTipoClienteMAV(Long oidDetalleMAV, Long[] subtipoCliente)
        throws MareException {
        UtilidadesLog.info("MONBusinessPlanningBean.insertaTipoClienteMAV(Long oidDetalleMAV, Long[] subtipoCliente):Entrada");
        BelcorpService bs = BelcorpService.getInstance();

        for(int i = 0; i < subtipoCliente.length; i++) {
            UtilidadesLog.debug("Bucle SubtipoCliente " + i);
            UtilidadesLog.debug("oidDetalle: " + oidDetalleMAV.toString() + " - subtipoCliente: " + subtipoCliente[i].toString());
            Long oidSubtipoCliente = SecuenciadorOID.obtenerSiguienteValor("MAV_DMAS_SEQ");
            StringBuffer sqlInsertaSubtipoCliente = new StringBuffer(
                    "INSERT INTO mav_subti_clien_detal ( OID_SUBT_CLTE_DETA, SBTI_OID_SUBT_CLIE, DENV_OID_DETA_MAV ) VALUES ( ");
            sqlInsertaSubtipoCliente.append(oidSubtipoCliente.toString() + ", ");
            sqlInsertaSubtipoCliente.append(subtipoCliente[i].toString() + ", " + oidDetalleMAV.toString() + " )");

            try {
                int retorno = bs.dbService.executeUpdate(sqlInsertaSubtipoCliente.toString());
            } catch(Exception ex) {
                //ctx.setRollbackOnly();
                UtilidadesLog.debug("Pincho en Insert en SubtipoCliente");
                UtilidadesLog.error(ex);
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }

        UtilidadesLog.info("MONBusinessPlanningBean.insertaTipoClienteMAV(Long oidDetalleMAV, Long[] subtipoCliente):Salida");
        return;
    }

    private void insertaUAPorDetalleMAV(Long oidDetalle, Long[] subgerencia, Long[] regiones, Long[] zonas, Map unidades)
        throws MareException {
        UtilidadesLog.info("MONBusinessPlanningBean.insertaUAPorDetalleMAV(Long oidDetalle, Long[] subgerencia, Long[] regiones, Long[] zonas):Entrada");
        BelcorpService bs = BelcorpService.getInstance();

        try 
        {
          UtilidadesLog.debug(" ----- Insertan en Unidades Administrativas ");
          UtilidadesLog.debug("             Insertar subgerencias");
          
          RecordSet rZonas = null;
          RecordSet rRegiones = null;
          Vector vOidRegConZona = new Vector();
          Vector vOidSubgConRegion = new Vector();
            
          if (zonas.length != 0)
          {
              UtilidadesLog.debug("Paso 1");
              // 1- Obtiene las SubgV, Regiones y Zonas a grabar por Zona
              rZonas = this.obtieneZonificacionPorZona(zonas);
              vOidRegConZona = new Vector();
              vOidSubgConRegion = new Vector();

              UtilidadesLog.debug("Paso 2");
              // 2- Obtiene los oids de Regiones que YA tienen su Zona correspondiente.
              //    y los oids de Subg. que tengan Regiones ya asociadas con su Zona. 
              for (int i = 0; i <  rZonas.getRowCount(); i++)
              {
                  BigDecimal bigBuffer = (BigDecimal)rZonas.getValueAt(i,1);  // Col. de Regiones.
                  vOidRegConZona.add( new Long(bigBuffer.longValue()) );
                  
                  bigBuffer = (BigDecimal) rZonas.getValueAt(i,0); // Col. de Subgv.
                  vOidSubgConRegion.add(new Long(bigBuffer.longValue()));
              }
          }
          
          UtilidadesLog.debug("vOidRegionesConZona: " + vOidRegConZona);
          Long[] aRegExistentes = (Long[])vOidRegConZona.toArray(new Long[vOidRegConZona.size()]);
          UtilidadesLog.debug("Paso 3");          
          // 3- Ahora quita al array de regiones original, los oids de regiones que ya tengan Zona.
          Long[] regionesSinZona = this.quitaOidsRepetidos(regiones, aRegExistentes);
          
          if (regionesSinZona.length != 0)
          {
              UtilidadesLog.debug("Paso 4");          
              // 4- Obtiene las SubgV de las Regiones que NO tienen Zona Asociada.          
              rRegiones = this.obtieneZonificacionPorRegion(regionesSinZona);  
          }
          
          UtilidadesLog.debug("Paso 5");          
          // 5- Obtiene los Oids de Subgerencias de Ventas que YA tienen una Region asociada
          //   (usa las Regiones no tienen Zona asociada)
          if (rRegiones != null)
          {
              for (int i = 0; i < rRegiones.getRowCount(); i++)
              {
                  BigDecimal bigBuffer = (BigDecimal) rRegiones.getValueAt(i,0); // Col. de Subgv.
                  vOidSubgConRegion.add(new Long(bigBuffer.longValue()));
              }
          }
          
          Long[] aSubgvExistentes = (Long[])vOidSubgConRegion.toArray(new Long[vOidSubgConRegion.size()]);          
          UtilidadesLog.debug("Paso 6 - aSubgvExistentes.length: " + aSubgvExistentes.length);
          // 6- Quita los oid de Subgerencia de Ventas que ya tienen una region asociada 
          //    para dejar los que no tienen nada asociado. 
          Long[] SGVSinRegion = null;
          if (aSubgvExistentes.length > 0) 
            SGVSinRegion = this.quitaOidsRepetidos(subgerencia, aSubgvExistentes);
          else
            SGVSinRegion = subgerencia;

          UtilidadesLog.debug("----------- Ahora procede a grabar -------------");
          
          // Graba Zonas          
          if (rZonas != null && !rZonas.esVacio() )
          {
              UtilidadesLog.debug("Graba recordSet rZonas...");
              for (int i = 0; i < rZonas.getRowCount(); i++)
              {
                  UtilidadesLog.debug("Bucle rZonas " + i);            
                  
                  BigDecimal bigOidSGV = (BigDecimal) rZonas.getValueAt(i,0);
                  BigDecimal bigOidRegion = (BigDecimal) rZonas.getValueAt(i,1);
                  BigDecimal bigOidZona = (BigDecimal) rZonas.getValueAt(i,2);

                  // sapaza -- PER-SiCC-2010-0699 -- 12/12/2010                  
                  String numeroUnidades = "NULL";
                  if(unidades.get("z" + bigOidZona.toString()) != null)
                    numeroUnidades = String.valueOf(unidades.get("z" + bigOidZona.toString()));
                  
                  Long oidTupla = SecuenciadorOID.obtenerSiguienteValor("MAV_DMUA_SEQ");
                  StringBuffer sqlInsert = new StringBuffer(" INSERT INTO mav_detal_mav_unida_admin m ");
                  sqlInsert.append(" (OID_DETA_MAV_UNID_ADMI, DENV_OID_DETA_MAV, ZZON_OID_ZONA, TERR_OID_TERR, ");
                  sqlInsert.append(" ZORG_OID_REGI, ZSGV_OID_SUBG_VENT, NUM_UNID) VALUES (");
                  sqlInsert.append(oidTupla.toString() + ", " + oidDetalle.toString() + ",");
                  sqlInsert.append( bigOidZona.toString() + ", NULL, " + bigOidRegion.toString() + ", " + bigOidSGV.toString() + ", ");
                  sqlInsert.append( numeroUnidades + ")");
                  
                  int nRetorno = bs.dbService.executeUpdate(sqlInsert.toString());
              }
          } else
          {
            UtilidadesLog.debug("rZonas es NULL o vacio, asi que no graba rZonas...");
          }
          
          // Graba Regiones sin Zona asociada.
          if (rRegiones != null && !rRegiones.esVacio())
          {
              UtilidadesLog.debug("Graba recordSet rRegiones...");
              for (int i = 0; i < rRegiones.getRowCount(); i++)
              {
                UtilidadesLog.debug("Bucle rRegiones " + i);            
                
                BigDecimal bigOidSGV = (BigDecimal) rRegiones.getValueAt(i,0);
                BigDecimal bigOidRegion = (BigDecimal) rRegiones.getValueAt(i,1);
                
                // sapaza -- PER-SiCC-2010-0699 -- 12/12/2010                  
                String numeroUnidades = "NULL";
                if(unidades.get("r" + bigOidRegion.toString()) != null)
                  numeroUnidades = String.valueOf(unidades.get("r" + bigOidRegion.toString()));
                
                Long oidTupla = SecuenciadorOID.obtenerSiguienteValor("MAV_DMUA_SEQ");
                StringBuffer sqlInsert = new StringBuffer(" INSERT INTO mav_detal_mav_unida_admin m ");
                sqlInsert.append(" (OID_DETA_MAV_UNID_ADMI, DENV_OID_DETA_MAV, ZZON_OID_ZONA, TERR_OID_TERR, "); 
                sqlInsert.append("  ZORG_OID_REGI, ZSGV_OID_SUBG_VENT, NUM_UNID) VALUES (");
                sqlInsert.append(oidTupla.toString() + ", " + oidDetalle.toString() + ",");
                sqlInsert.append("NULL, NULL, " + bigOidRegion.toString() + ", " + bigOidSGV.toString() + ", " + numeroUnidades + ")");
                
                int nRetorno = bs.dbService.executeUpdate(sqlInsert.toString());
              }
          } else
          {
              UtilidadesLog.debug("rRegiones es NULL o vacio, asi que no graba rRegiones...");
          }
          
          // Graba SGV sin Regiones Asociadas
          if (SGVSinRegion.length != 0)
          {
            for (int i = 0; i < SGVSinRegion.length; i++)
            {
                Long oidSGV = SGVSinRegion[i];
                Long oidTupla = SecuenciadorOID.obtenerSiguienteValor("MAV_DMUA_SEQ");
                StringBuffer sqlInsert = new StringBuffer(" INSERT INTO mav_detal_mav_unida_admin m ");
                sqlInsert.append(" (OID_DETA_MAV_UNID_ADMI, DENV_OID_DETA_MAV, ZZON_OID_ZONA, TERR_OID_TERR, ZORG_OID_REGI, ZSGV_OID_SUBG_VENT) VALUES (");
                sqlInsert.append(oidTupla.toString() + ", " + oidDetalle.toString() + ",");
                sqlInsert.append("NULL, NULL, NULL, " + oidSGV + ")");

                int nRetorno = bs.dbService.executeUpdate(sqlInsert.toString());                
            }
            
          } else
          {
            UtilidadesLog.debug("NO hay SGV sin regiones asociadas");
          }
          
        // FIN CODIGO ORIGINAL          
        } catch(MareException ne) {
            UtilidadesLog.error(ne);
            throw ne;
        } catch(Exception ex) {
            UtilidadesLog.debug("Error en insercion");
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.debug("Inserto en Unidades Administrativas correctamente");
        UtilidadesLog.info("MONBusinessPlanningBean.insertaUAPorDetalleMAV(Long oidDetalle, Long[] subgerencia, Long[] regiones, Long[] zonas):Salida");
        return;
    }
    
 // -------------------------------------------------------------------------------------------------------------
  private RecordSet obtieneZonificacionPorZona(Long[] zonas) throws MareException
  {
      UtilidadesLog.info("MONBusinessPlanningBean.obtieneZonificacionPorZona(Long[] zonas):Entrada");
      RecordSet r = null;
      BelcorpService bs = BelcorpService.getInstance();
      
      StringBuffer sqlQuery = new StringBuffer("");
      sqlQuery.append(" SELECT zon_regio.ZSGV_OID_SUBG_VENT, zon_zona.zorg_oid_regi, ");
      sqlQuery.append(" zon_zona.oid_zona ");
      sqlQuery.append(" FROM zon_zona, zon_regio ");
      sqlQuery.append(" WHERE zon_zona.oid_zona " + this.generaINClause(zonas) );
      sqlQuery.append(" and zon_regio.oid_regi = zon_zona.ZORG_OID_REGI ");
      sqlQuery.append(" order by 2 ");
      
      try 
      {
        r = bs.dbService.executeStaticQuery(sqlQuery.toString());
      } catch (Exception ex)
      {
        UtilidadesLog.error(ex);
        String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
        throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
      }
      UtilidadesLog.info("MONBusinessPlanningBean.obtieneZonificacionPorZona(Long[] zonas):Salida");
      return r;
    
  }
  
 // ------------------------------------------------------------------------------------------------------------- 
  private RecordSet obtieneZonificacionPorRegion(Long[] regiones) throws MareException
  {
      UtilidadesLog.info("MONBusinessPlanningBean.obtieneZonificacionPorRegion(Long[] regiones):Entrada");
      RecordSet r = null;
      BelcorpService bs = BelcorpService.getInstance();
      StringBuffer sqlQuery = new StringBuffer("");    
      
      sqlQuery.append(" SELECT zon_regio.zsgv_oid_subg_vent, zon_regio.oid_regi, NULL ");
      sqlQuery.append(" FROM zon_regio ");
      sqlQuery.append(" WHERE zon_regio.oid_regi " + this.generaINClause(regiones) );
      sqlQuery.append(" ORDER BY 2 ");
      
      try 
      {
        r = bs.dbService.executeStaticQuery(sqlQuery.toString());
      } catch (Exception ex)
      {
        UtilidadesLog.error(ex);
        String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
        throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
      }
      
      UtilidadesLog.info("MONBusinessPlanningBean.obtieneZonificacionPorRegion(Long[] regiones):Salida");
      return r;

  }

 // -------------------------------------------------------------------------------------------------------------    
  private String generaINClause(Long[] oids) 
  { 
     UtilidadesLog.info("MONBusinessPlanningBean.generaINClause(Long[] oids) :Entrada");
     // Se asume que oids[] tenga al menos 1 registro
     StringBuffer sClausula = new StringBuffer("");
     
     sClausula.append(" IN ( ");
     for (int i = 0; i < oids.length; i++)
     {
        Long oidZona = oids[i];
        
        if (i != 0)
          sClausula.append(", ");
          
        sClausula.append(""+ oidZona);
     }
     sClausula.append(")");
     UtilidadesLog.info("MONBusinessPlanningBean.generaINClause(Long[] oids) :Salida");
     return sClausula.toString();
  }
  
 // -------------------------------------------------------------------------------------------------------------
  private Long[] quitaOidsRepetidos(Long[] original, Long[] aQuitar)
  {
    UtilidadesLog.info("MONBusinessPlanningBean.quitaOidsRepetidos(Long[] original, Long[] aQuitar):Entrada");
    Vector v = new Vector();
    
    for (int i = 0; i < original.length; i++)
    {
        boolean bAgregar = true;
        UtilidadesLog.debug("******* Valor original: " + original[i]);
        for (int j = 0; (j < aQuitar.length) && (bAgregar); j++)
        {
            UtilidadesLog.debug(" - Valor a comparar: " + aQuitar[j]);
            if (original[i].longValue() ==  aQuitar[j].longValue() )  // Si el oid de "original" ya existe en "aQuitar"
            {
                UtilidadesLog.debug("Se quita");
                bAgregar = false;             
            }
        }
        
        if (bAgregar)
        {
          UtilidadesLog.debug("Se deja");
          v.add(original[i]);
        }
    }
    
    UtilidadesLog.debug("Nuevo vector: " + v);
    Long[] aRetornar = (Long[])v.toArray(new Long[v.size()]);    
    UtilidadesLog.info("MONBusinessPlanningBean.quitaOidsRepetidos(Long[] original, Long[] aQuitar):Salida");
    return aRetornar;
    
  }



 // -------------------------------------------------------------------------------------------------------------    
    // by ssantana, 28/11/2004
    // params:  codSAP (String)
    //          oidPais (Long)
    // returns: Long (oid de Producto)
    private Long obtieneOid(String codSAP, Long oidPais) throws MareException
    {
        UtilidadesLog.info("MONBusinessPlanningBean.obtieneOid(String codSAP, Long oidPais):Entrada");
        StringBuffer query = new StringBuffer("");
        query.append(" select m.OID_PROD from mae_produ m ");
        query.append(" where m.COD_SAP = '" + codSAP + "' ");
        query.append(" and m.PAIS_OID_PAIS = " + oidPais.toString() );

        BelcorpService bs = BelcorpService.getInstance();
        RecordSet r = null;
        try {
          r = bs.dbService.executeStaticQuery(query.toString() );
        } catch (Exception ex)
        {
          UtilidadesLog.error(ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        // COD_SAP y PAIS_OID_PAIS son UK, asi que o devuelve un registro, o nada:
        // Si no devuelve nada, entonces devolver NULL. Si no, devuelve el OID. 
        BigDecimal b = (BigDecimal) r.getValueAt(0,0);
        Long oidProducto = null;

        if (b != null)
          oidProducto = new Long( b.longValue() );

        UtilidadesLog.info("MONBusinessPlanningBean.obtieneOid(String codSAP, Long oidPais):Salida");
        return oidProducto;
        
    }

    // by ssantana, 28/11/2004
    // params:  oidProducto (Long)
    // returns: String (Codigo SAP Producto)
    private String obtieneCodigoSAP(Long oidProducto) throws MareException
    {
      UtilidadesLog.info("MONBusinessPlanningBean.obtieneCodigoSAP(Long oidProducto):Entrada");
      StringBuffer sQuery = new StringBuffer("");
      sQuery.append(" select m.COD_SAP from mae_produ m ");
      sQuery.append(" where m.OID_PROD = " + oidProducto.toString() );

      BelcorpService bs = BelcorpService.getInstance();
      RecordSet r = null;

      try {
        r = bs.dbService.executeStaticQuery(sQuery.toString());
      } catch (Exception ex)
      {
        UtilidadesLog.error(ex);
        throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));       
      }
      String sCodSAP = (String) r.getValueAt(0,0);

      UtilidadesLog.info("MONBusinessPlanningBean.obtieneCodigoSAP(Long oidProducto):Salida");
      return sCodSAP;

    }

    private Long verificaCodigoVenta(String sCodigoVenta, Long oidPais, Long oidMarca, Long oidCanal, Long oidPeriodo) throws MareException
    {
        UtilidadesLog.info("MONBusinessPlanningBean.verificaCodigoVenta(String sCodigoVenta, Long oidPais, Long oidMarca, Long oidCanal, Long oidPeriodo):Entrada");
        Long oidMatrizFacturacion = null;        
        try 
        {
        
          MONPeriodosHome perioHome = this.getMONPeriodosHome(); //this.getPeriodoLocalHome();
          MONPeriodos perio = null;            
          MONMantenimientoMF matrizMF = null;
          MONMantenimientoMFHome matrizMFHome = null;
          DTOPeriodo dtoPerio = null;        
          DTOBuscarCodigoVentaPeriodo dtoBuscarCodigoVenta = new DTOBuscarCodigoVentaPeriodo();
          MatrizFacturacionLocal matrizFacturacionLocal = null;
          MatrizFacturacionLocalHome matrizFacturacionLocalHome = null;

          /*UtilidadesLog.debug("Realiza el Create");
          perio = perioHome.create();
          UtilidadesLog.debug("Obtiene periodo actual");
          dtoPerio = perio.obtienePeriodoActual(oidPais, oidMarca, oidCanal);          
          UtilidadesLog.debug("Periodo Actual obtenido: " + dtoPerio);*/


          // Modificado. x ssantana, 28/12/2004. Se toma el primer Periodo, provisoriamente.
          
          //dtoBuscarCodigoVenta.setPeriodo( dtoPerio.getOid() );
          dtoBuscarCodigoVenta.setPeriodo(oidPeriodo);
          dtoBuscarCodigoVenta.setOidPais(oidPais);
          dtoBuscarCodigoVenta.setCodigoVenta(sCodigoVenta);

          matrizMFHome = this.getMONMantenimientoMFHome();
          matrizMF = matrizMFHome.create();

          UtilidadesLog.debug("Busca Codigo Venta por Periodo");
          DTOSalida dtoSalida = matrizMF.buscarCodigoVentaPeriodo(dtoBuscarCodigoVenta);
          UtilidadesLog.debug("DTOSalida: " + dtoSalida);          
          RecordSet r = dtoSalida.getResultado();

          if (r != null && !r.esVacio() )
          {
              Long oidDetalleOferta = new Long(((BigDecimal) r.getValueAt(0,0)).longValue());          
              matrizFacturacionLocalHome = new MatrizFacturacionLocalHome();
              UtilidadesLog.debug("Busca en MatrizFacturacion por oidDetalleOferta = " + oidDetalleOferta);
              matrizFacturacionLocal = matrizFacturacionLocalHome.findByOidDetaOfer(oidDetalleOferta);
              oidMatrizFacturacion = matrizFacturacionLocal.getOid();
              UtilidadesLog.debug("OidMatrizFacturacion a setear: " + oidMatrizFacturacion);
          }

        } catch (RemoteException rEx)
        {
           UtilidadesLog.debug("Remove Exception");            
           UtilidadesLog.error(rEx);
           throw new MareException(rEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));       
        } catch (CreateException cEx)
        {
           UtilidadesLog.debug("Create Exception");
           UtilidadesLog.error(cEx);
           throw new MareException(cEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));       
        } catch (NamingException nEx)
        {
           UtilidadesLog.debug("Naming Exception");
           UtilidadesLog.error(nEx);
           throw new MareException(nEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));       
        } catch (NoResultException fEx)
        {
          UtilidadesLog.debug("Finder Exception");
          UtilidadesLog.error(fEx);
          throw new MareException(fEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));       
        }
        UtilidadesLog.info("MONBusinessPlanningBean.verificaCodigoVenta(String sCodigoVenta, Long oidPais, Long oidMarca, Long oidCanal, Long oidPeriodo):Salida");
        return oidMatrizFacturacion;
    
    }

      // Autor: SSantana
      // Params: Long oidMatrizF
      // Returns: String
      // Nota: Hecho por inc. 11056, obtiene el Codigo de Venta a partir de una 
      //       determinada Matriz Facturacion (si no encuentra concidencia, devuelve null)1
     private String obtieneCodigoVenta(Long oidMatrizF) throws MareException
     {
        UtilidadesLog.info("MONBusinessPlanningBean.obtieneCodigoVenta(Long oidMatrizF):Entrada");
        String sCodigoVenta = null;
        try 
        {
          MatrizFacturacionLocalHome mfLocalHome = new MatrizFacturacionLocalHome();
          MatrizFacturacionLocal mfLocal = mfLocalHome.findByPrimaryKey(oidMatrizF);
          
          Long oidDetalleOferta = mfLocal.getOidDetaOfer();
          UtilidadesLog.debug("oidDetalleOferta: " + oidDetalleOferta);
          DetalleOfertaLocalHome detalleLocalHome = new DetalleOfertaLocalHome();
          DetalleOfertaLocal detalleLocal = detalleLocalHome.findByPrimaryKey(oidDetalleOferta);
          
          UtilidadesLog.debug("sCodigoVenta: " + sCodigoVenta);
          sCodigoVenta = detalleLocal.getCodigoVenta();
        } catch (NoResultException fEx)
        {
          UtilidadesLog.debug("Finder Exception");
          UtilidadesLog.error(fEx);
        }
        UtilidadesLog.info("MONBusinessPlanningBean.obtieneCodigoVenta(Long oidMatrizF):Salida");
        return sCodigoVenta;
     }
    

    // Autor: ssantana, por incidencia 11090
    // Fecha: 14/12/2004
    // Params: Long pais
    //         Long tipoCliente
    //         Long[] subtipoCliente
    // Returns: Boolean
    private Boolean validarTipoSubtipoCliente(Long pais, Long tipoCliente, Long[] subtipoCliente) throws MareException
    {
      UtilidadesLog.info("MONBusinessPlanningBean.validarTipoSubtipoCliente(Long pais, Long tipoCliente, Long[] subtipoCliente):Entrada");
      DAODetalleMAV daoDetalleMav = new DAODetalleMAV();
      RecordSet r = daoDetalleMav.obtenerParametrizacionMAV(pais);
      boolean flag = true;
      if ( subtipoCliente != null && subtipoCliente.length > 0) {
          if (!r.esVacio()) {
              // Primero chequea si el valor de tipoCliente se encuentra en alguna fila del RecordSet
              boolean existeTipoCliente = this.validarExistenciaTipoCliente(r, tipoCliente);
              // Chequea la existencia de los sutbipos de cliente. 
              boolean existenSubtipos = this.validarExistenciaSubtipoCliente(r, subtipoCliente);
    
              if (existeTipoCliente && existenSubtipos)
                flag = true;
              else
                flag = false;
    
          } else {
            flag = false;
          } 
      } else {
        flag = false;
      }
      
      UtilidadesLog.info("MONBusinessPlanningBean.validarTipoSubtipoCliente(Long pais, Long tipoCliente, Long[] subtipoCliente):Salida");
      return new Boolean(flag);

    }

    private boolean validarExistenciaTipoCliente(RecordSet r, Long tipoCliente)
    {
      UtilidadesLog.info("MONBusinessPlanningBean.validarExistenciaTipoCliente(RecordSet r, Long tipoCliente):Entrada");
      boolean flag = false;

      int cantReg = r.getRowCount();
      Long buffer = null;

      for (int i = 0; (i < cantReg) && (flag == false); i++)
      {
        buffer = new Long( ((BigDecimal) r.getValueAt(i,0)).longValue() );
        if (buffer.equals(tipoCliente)){
          flag = true;  // Se encontró al menos una coincidencia.
          UtilidadesLog.debug("Encontro Tipo Cliente, validó");
        }
      }
      UtilidadesLog.debug("Retorna: " + flag);
      UtilidadesLog.info("MONBusinessPlanningBean.validarExistenciaTipoCliente(RecordSet r, Long tipoCliente):Salida");
      return flag;
    }
    
   private boolean validarExistenciaSubtipoCliente(RecordSet r, Long[] subtipoCliente)
   {
     UtilidadesLog.info("MONBusinessPlanningBean.validarExistenciaSubtipoCliente(RecordSet r, Long[] subtipoCliente):Entrada");
     boolean flag = true;
     UtilidadesLog.debug("------- Valida Existencia Subtipo Cliente");
     int cantRegistros = r.getRowCount();

     for (int i = 0; (i < subtipoCliente.length) && (flag == true) ; i++)
     {
          // Si no se encontro coincidencia para el subtipo actual en todo el 
          // RecordSet, se recibe flag = false, y rompe el bucle y devuelve false.
          flag = this.buscaSubtipoCliente(r, subtipoCliente[i]);
     }

     UtilidadesLog.debug("------ Retorna " + flag);
     UtilidadesLog.info("MONBusinessPlanningBean.validarExistenciaSubtipoCliente(RecordSet r, Long[] subtipoCliente):Salida");
     return flag;
   }

   private boolean buscaSubtipoCliente(RecordSet r, Long subtipo)
   {
      UtilidadesLog.info("MONBusinessPlanningBean.buscaSubtipoCliente(RecordSet r, Long subtipo):Entrada");
      boolean flag = false;

      int cantRegistros = r.getRowCount();
      Long buffer = null;

      for ( int i = 0; (i < cantRegistros) && (flag == false); i++)
      {
        buffer = new Long( ( (BigDecimal) r.getValueAt(i,1) ).longValue() );
        if ( subtipo.equals(buffer) )
        {
          UtilidadesLog.debug("Encontró match para subtipo " + subtipo);
          flag = true;
        }
      }
      
      UtilidadesLog.debug("Retorna " + flag);
      UtilidadesLog.info("MONBusinessPlanningBean.buscaSubtipoCliente(RecordSet r, Long subtipo):Salida");
      return flag;
   }


    private MONMantenimientoMFHome getMONMantenimientoMFHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONMantenimientoMFHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONMantenimientoMF"), MONMantenimientoMFHome.class);
  }

  private MONPeriodosHome getMONPeriodosHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONPeriodosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONPeriodos"), MONPeriodosHome.class);
  }

  private MONCargaMantenimientoListasHome getMONCargaMantenimientoListasHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONCargaMantenimientoListasHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONCargaMantenimientoListas"), MONCargaMantenimientoListasHome.class);
  }
  
  
  // Autor: ssantana, 6/1/2005
  // Params: Long oidPeriodoInicio
  //         Long oidPeriodoFin
  //         Long oidPais 
  // Retorna: Boolean
  // Throws: MareException
  // -------------------------------------------------------
  // Desc: Verifica que la Fecha de Inicio de Período oidPeriodoFin sea posterior
  //       a la Fecha de Finalizacion de oidPeriodoInicio, para un Pais determinado
  //       (solamente si ambos Períodos son distintos - !oidPeriodoInicio.equals(oidPeriodoFin)  )
  private Boolean validaPeriodos(Long oidPeriodoInicio, Long oidPeriodoFin, Long oidPais) throws MareException
  {
    UtilidadesLog.info("MONBusinessPlanningBean.validaPeriodos(Long oidPeriodoInicio, Long oidPeriodoFin, Long oidPais):Entrada");
    UtilidadesLog.debug("---------- validaPeriodos()");
    Boolean validado = new Boolean(false);
    
    // Se fija que ambos períodos sean distintos. Si no, devuelve TRUE
    if (oidPeriodoInicio.equals(oidPeriodoFin)) {
      UtilidadesLog.debug("oidPeriodoInicio es igual oidPeriodoFin");
      validado = new Boolean(true);
    } else
    {
        try
        {
          UtilidadesLog.debug("oidPeriodoInicio es distinto a oidPeriodoFin");
          StringBuffer sql = new StringBuffer("");
          BelcorpService bs = BelcorpService.getInstance();
          
          sql.append(" SELECT * FROM cra_perio ");
          sql.append(" WHERE cra_perio.oid_peri IN ( ");
          sql.append("      SELECT p.oid_peri ");
          sql.append("      FROM cra_perio p ");
          sql.append("      WHERE p.pais_oid_pais = " + oidPais);
          sql.append("      AND p.fec_inic > ( ");
          sql.append("                SELECT perio.fec_fina ");
          sql.append("                FROM cra_perio perio ");
          sql.append("                WHERE perio.oid_peri = " + oidPeriodoInicio );
          sql.append("           )) ");
          sql.append(" AND cra_perio.oid_peri = " + oidPeriodoFin);
          RecordSet r = bs.dbService.executeStaticQuery(sql.toString() );
          if ( !r.esVacio() ) { 
            // Si encuentra un Periodo, entonces oidPeriodoFin es posterior a oidPeriodoFin
            validado = new Boolean(true);
          }
          
        } catch (MareMiiServiceNotFoundException mEx)
        {
          UtilidadesLog.error(mEx);
          throw new MareException(mEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } catch (Exception ex)
        {
          UtilidadesLog.error(ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
    }    
    UtilidadesLog.debug("Periodo Validado: " + validado.booleanValue());
    UtilidadesLog.info("MONBusinessPlanningBean.validaPeriodos(Long oidPeriodoInicio, Long oidPeriodoFin, Long oidPais):Salida");  
    return validado;
    
  }

  /**
   * @author: ssantana, 27/12/2005
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOSalida
   * @param DTOPeriodo dtoPeriodo
   */
  public DTOSalida obtenerPeriodosRangoAnual(DTOPeriodo dtoPeriodo) 
          throws MareException {
    UtilidadesLog.info("MONBusinessPlanning.obtenerPeriodosRangoAnual(" + 
                        "DTOPeriodo dtoPeriodo):Entrada");
  
    DAOServicioMAV daoServicioMAV = new DAOServicioMAV();
    
    DTOSalida dtoSalida = new DTOSalida();
    
    Long oidPeriodoPivot = dtoPeriodo.getOid();
    Long oidMarca = dtoPeriodo.getMarca();
    Long oidCanal = dtoPeriodo.getCanal();
    Long oidPais = dtoPeriodo.getOidPais();
    RecordSet r = daoServicioMAV.obtenerPeriodosRangoAnual(oidPeriodoPivot, 
                                                           oidMarca, 
                                                           oidCanal, 
                                                           oidPais);
    dtoSalida.setResultado(r);
    UtilidadesLog.info("MONBusinessPlanning.obtenerPeriodosRangoAnual(" + 
                        "DTOPeriodo dtoPeriodo):Salida");
    return dtoSalida;
  }

  public void desactivaDetalleMAV(DTOOID dto) throws MareException {
    UtilidadesLog.info("MONBusinessPlanningBean.desactivaDetalleMAV(DTOOID dto):Entrada");
    
    UtilidadesLog.debug("DTOOID: " + dto);

    try {    
        instanciaDetalleMAV = this.getDetalleMAVLocalHome();
        DetalleMAVLocal aux = instanciaDetalleMAV.findByPrimaryKey(dto.getOid());    

        Long estadoProceso = aux.getOidEstadoProceso();
            
        aux.setOidEstadoProceso(new Long(5));
        
        if (estadoProceso.intValue() == 4) {
            BelcorpService bs = BelcorpService.getInstance();        
            StringBuffer statement = new StringBuffer("");
            statement.append(" UPDATE MAV_ENVIO SET IND_ENVI = 'D' ");
            statement.append("  WHERE DENV_OID_DETA_MAV="+dto.getOid());    
            statement.append("    AND IND_ENVI = 'P' ");
            int rc = bs.dbService.executeUpdate(statement.toString());
        }
                                
    } catch(MareServiceException e) {
        UtilidadesLog.debug("Actualiza - MareException");
        ctx.setRollbackOnly();
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    } catch(MareException ex) {        
         BelcorpError belcorpError = new BelcorpError();
         DTOError dtoError = belcorpError.obtenerError(ex);
         UtilidadesLog.debug("cod error: " + dtoError.getCodigoError());
         if(dtoError.getCodigoError().equals("50035"))
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAV,"",ErroresNegocio.MAV_0111));                                                   

        UtilidadesLog.debug("Error");
        UtilidadesLog.error(ex);
        ctx.setRollbackOnly();
        throw ex;
    } catch(Exception ex) {
        UtilidadesLog.debug("Pincho en el UPDATE de DesActivaDetalleMAV");
        UtilidadesLog.error(ex);
        throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));           
    }
    
    UtilidadesLog.info("MONBusinessPlanningBean.desactivaDetalleMAV(DTOOID dto): Salida");
    
  }

    private MONMantenimientoParametrosDBPLocalHome getMONMantenimientoParametrosDBPLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONMantenimientoParametrosDBPLocalHome)context.lookup("java:comp/env/MONMantenimientoParametrosDBPLocal");
    }

    public DTOSalida descProducto(DTODetalleMAV dtoe) throws MareException {
        UtilidadesLog.info("MONBusinessPlanningBean.desProducto(DTODetalleMAV): Entrada");        
        DAODetalleMAV dao = new DAODetalleMAV();        
        UtilidadesLog.info("MONBusinessPlanningBean.desProducto(DTODetalleMAV): Salida");
        return dao.desProducto(dtoe);
    }
    
    // sapaza -- PER-SiCC-2010-0580 -- 04/10/2010
    private Long obtieneTotalEnvios(Long oidDetalleMAV) throws MareException {
        UtilidadesLog.info("MONBusinessPlanningBean.obtieneTotalEnvios(Long oidDetalleMAV):Entrada");
        StringBuffer query = new StringBuffer("");
        query.append(" SELECT COUNT(1) ");
        query.append("   FROM MAV_ENVIO ");
        query.append("  WHERE DENV_OID_DETA_MAV = " + oidDetalleMAV);

        BelcorpService bs = BelcorpService.getInstance();
        RecordSet r = null;
        try {
          r = bs.dbService.executeStaticQuery(query.toString() );
        } catch (Exception ex)
        {
          UtilidadesLog.error(ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        Long total = new Long(((BigDecimal) r.getValueAt(0,0)).longValue());          
        
        UtilidadesLog.info("MONBusinessPlanningBean.obtieneTotalEnvios(Long oidDetalleMAV):Salida");
        return total;
    }
    
    // sapaza -- PER-SiCC-2010-0628 -- 20/10/2010
    private void insertaTipoClientePorDetalleMAV(Long oidDetalle, Long[] subTiposCliente, Long[] tiposClasificacion, Long[] clasificaciones)
        throws MareException {
        UtilidadesLog.info("MONBusinessPlanningBean.insertaTipoClientePorDetalleMAV(Long oidDetalle, Long[] subTiposCliente, " +
                            "Long[] tiposClasificacion, Long[] clasificaciones):Entrada");
        BelcorpService bs = BelcorpService.getInstance();

        try 
        {
          RecordSet rClasificaciones = null;
          RecordSet rTiposClasificacion = null;
          Vector vOidTCconCL = new Vector();
          Vector vOidSTconTC = new Vector();
            
          if (clasificaciones.length != 0) {
              UtilidadesLog.debug("Paso 1");
              // 1- Obtiene los SubTipoClientes, TipoClasificaciones y Clasificaciones a grabar por Clasificacion
              rClasificaciones = this.obtieneClasificacionesPorTipoClasificacion(clasificaciones);
              vOidTCconCL = new Vector();
              vOidSTconTC = new Vector();

              UtilidadesLog.debug("Paso 2");
              // 2- Obtiene los oids de TipoClasificaciones que YA tienen su Clasificacion correspondiente.
              //    y los oids de SubTipoClientes que tengan TipoClasificaciones ya asociadas con su Clasificacion. 
              for (int i = 0; i <  rClasificaciones.getRowCount(); i++)
              {
                  BigDecimal bigBuffer = (BigDecimal)rClasificaciones.getValueAt(i,1);  // Col. de TiposClasificaciones.
                  vOidTCconCL.add( new Long(bigBuffer.longValue()) );
                  
                  bigBuffer = (BigDecimal) rClasificaciones.getValueAt(i,0); // Col. de SubTipoClientes.
                  vOidSTconTC.add(new Long(bigBuffer.longValue()));
              }
          }
          
          UtilidadesLog.debug("vOidSTconTC: " + vOidTCconCL);
          Long[] aTCExistentes = (Long[])vOidTCconCL.toArray(new Long[vOidTCconCL.size()]);
          UtilidadesLog.debug("Paso 3");          
          // 3- Ahora quita al array de tiposClasificacion original, los oids de TiposClasificacion que ya tengan Clasificacion.
          Long[] TCSinCL = this.quitaOidsRepetidos(tiposClasificacion, aTCExistentes);
          
          if (TCSinCL.length != 0)
          {
              UtilidadesLog.debug("Paso 4");          
              // 4- Obtiene los SubTiposCliente de los TiposClasificacion que NO tienen Clasificacion Asociada.          
              rTiposClasificacion = this.obtieneTiposClasificacionPorSubTiposCliente(TCSinCL);  
          }
          
          UtilidadesLog.debug("Paso 5");          
          // 5- Obtiene los Oids de SubTiposCliente que YA tienen un TipoClasificacion asociada
          //   (usa los TiposClasificacion que no tienen Clasificacion asociada)
          if (rTiposClasificacion != null)
          {
              for (int i = 0; i < rTiposClasificacion.getRowCount(); i++)
              {
                  BigDecimal bigBuffer = (BigDecimal) rTiposClasificacion.getValueAt(i,0); // Col. de Subgv.
                  vOidSTconTC.add(new Long(bigBuffer.longValue()));
              }
          }
          
          Long[] aSTExistentes = (Long[])vOidSTconTC.toArray(new Long[vOidSTconTC.size()]);          
          UtilidadesLog.debug("Paso 6 - aSTExistentes.length: " + aSTExistentes.length);
          // 6- Quita los oid de SubTipoClientes que ya tienen un TipoClasificacion asociada 
          //    para dejar los que no tienen nada asociado. 
          Long[] STSinTC = null;
          if (aSTExistentes.length > 0) 
            STSinTC = this.quitaOidsRepetidos(subTiposCliente, aSTExistentes);
          else
            STSinTC = subTiposCliente;

          UtilidadesLog.debug("----------- Ahora procede a grabar -------------");
          
          // Graba Clasificaciones          
          if (rClasificaciones != null && !rClasificaciones.esVacio() )
          {
              UtilidadesLog.debug("Graba recordSet rClasificaciones...");
              for (int i = 0; i < rClasificaciones.getRowCount(); i++) {
                  UtilidadesLog.debug("Bucle rClasificaciones " + i);            
                  
                  BigDecimal bigOidST = (BigDecimal) rClasificaciones.getValueAt(i,0);
                  BigDecimal bigOidTC = (BigDecimal) rClasificaciones.getValueAt(i,1);
                  BigDecimal bigOidCL = (BigDecimal) rClasificaciones.getValueAt(i,2);
                  
                  Long oidTupla = SecuenciadorOID.obtenerSiguienteValor("MAV_DMAS_SEQ");
                  StringBuffer sqlInsert = new StringBuffer(" INSERT INTO mav_subti_clien_detal ");
                  sqlInsert.append(" (OID_SUBT_CLTE_DETA, DENV_OID_DETA_MAV, CLAS_OID_CLAS, TCCL_OID_TIPO_CLASI, SBTI_OID_SUBT_CLIE) VALUES (");
                  sqlInsert.append(oidTupla.toString() + ", " + oidDetalle.toString() + ",");
                  sqlInsert.append( bigOidCL.toString() + ", " + bigOidTC.toString() + ", " + bigOidST.toString() + ")");
                  
                  int nRetorno = bs.dbService.executeUpdate(sqlInsert.toString());
              }
          } else
          {
            UtilidadesLog.debug("rClasificaciones es NULL o vacio, asi que no graba rClasificaciones...");
          }
          
          // Graba TiposClasiificacion sin Clasificacion asociada.
          if (rTiposClasificacion != null && !rTiposClasificacion.esVacio())
          {
              UtilidadesLog.debug("Graba recordSet rTiposClasificacion...");
              for (int i = 0; i < rTiposClasificacion.getRowCount(); i++)
              {
                UtilidadesLog.debug("Bucle rTiposClasificacion " + i);            
                
                BigDecimal bigOidST = (BigDecimal) rTiposClasificacion.getValueAt(i,0);
                BigDecimal bigOidTC = (BigDecimal) rTiposClasificacion.getValueAt(i,1);
                
                Long oidTupla = SecuenciadorOID.obtenerSiguienteValor("MAV_DMAS_SEQ");
                StringBuffer sqlInsert = new StringBuffer(" INSERT INTO mav_subti_clien_detal ");
                sqlInsert.append(" (OID_SUBT_CLTE_DETA, DENV_OID_DETA_MAV, CLAS_OID_CLAS, TCCL_OID_TIPO_CLASI, SBTI_OID_SUBT_CLIE) VALUES (");
                sqlInsert.append(oidTupla.toString() + ", " + oidDetalle.toString() + ",");
                sqlInsert.append("NULL, " + bigOidTC.toString() + ", " + bigOidST.toString() + ")");
                
                int nRetorno = bs.dbService.executeUpdate(sqlInsert.toString());
              }
          } else
          {
              UtilidadesLog.debug("rTiposClasificacion es NULL o vacio, asi que no graba rTiposClasificacion...");
          }
          
          // Graba SubTipoCliente sin TiposClasificacion Asociadas
          if (STSinTC.length != 0)
          {
            for (int i = 0; i < STSinTC.length; i++)
            {
                Long oidST = STSinTC[i];
                Long oidTupla = SecuenciadorOID.obtenerSiguienteValor("MAV_DMAS_SEQ");
                StringBuffer sqlInsert = new StringBuffer(" INSERT INTO mav_subti_clien_detal ");
                sqlInsert.append(" (OID_SUBT_CLTE_DETA, DENV_OID_DETA_MAV, CLAS_OID_CLAS, TCCL_OID_TIPO_CLASI, SBTI_OID_SUBT_CLIE) VALUES (");
                sqlInsert.append(oidTupla.toString() + ", " + oidDetalle.toString() + ",");
                sqlInsert.append("NULL, NULL, " + oidST + ")");

                int nRetorno = bs.dbService.executeUpdate(sqlInsert.toString());                
            }
            
          } else
          {
            UtilidadesLog.debug("NO hay SubTipoCliente sin TiposClasificacion asociadas");
          }
          
        // FIN CODIGO ORIGINAL          
        } catch(MareException ne) {
            UtilidadesLog.error(ne);
            throw ne;
        } catch(Exception ex) {
            UtilidadesLog.debug("Error en insercion");
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.debug("Inserto de tipologia de cliente correctamente");
        UtilidadesLog.info("MONBusinessPlanningBean.insertaTipoClientePorDetalleMAV(Long oidDetalle, Long[] subTiposCliente, " +
                            "Long[] tiposClasificacion, Long[] clasificaciones):Salida");
    }

    private RecordSet obtieneClasificacionesPorTipoClasificacion(Long[] clasificaciones) throws MareException
    {
        UtilidadesLog.info("MONBusinessPlanningBean.obtieneClasificacionesPorTipoClasificacion(Long[] clasificaciones):Entrada");
        RecordSet r = null;
        BelcorpService bs = BelcorpService.getInstance();
        
        StringBuffer sqlQuery = new StringBuffer("");
        sqlQuery.append(" SELECT b.SBTI_OID_SUBT_CLIE, b.OID_TIPO_CLAS, a.OID_CLAS ");
        sqlQuery.append("   FROM MAE_CLASI a, MAE_TIPO_CLASI_CLIEN b ");
        sqlQuery.append(" WHERE a.OID_CLAS " + this.generaINClause(clasificaciones) );
        sqlQuery.append("   AND a.TCCL_OID_TIPO_CLAS = b.OID_TIPO_CLAS ");
        sqlQuery.append(" order by 2 ");
        
        try 
        {
          r = bs.dbService.executeStaticQuery(sqlQuery.toString());
        } catch (Exception ex)
        {
          UtilidadesLog.error(ex);
          String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
          throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
        }
        UtilidadesLog.info("MONBusinessPlanningBean.obtieneClasificacionesPorTipoClasificacion(Long[] clasificaciones):Salida");
        return r;
      
    }

    private RecordSet obtieneTiposClasificacionPorSubTiposCliente(Long[] tiposClasificaciones) throws MareException
    {
        UtilidadesLog.info("MONBusinessPlanningBean.obtieneTiposClasificacionPorSubTiposCliente(Long[] tiposClasificaciones):Entrada");
        RecordSet r = null;
        BelcorpService bs = BelcorpService.getInstance();
        StringBuffer sqlQuery = new StringBuffer("");    
        
        sqlQuery.append(" SELECT SBTI_OID_SUBT_CLIE, OID_TIPO_CLAS, NULL ");
        sqlQuery.append(" FROM MAE_TIPO_CLASI_CLIEN ");
        sqlQuery.append(" WHERE OID_TIPO_CLAS " + this.generaINClause(tiposClasificaciones) );
        sqlQuery.append(" ORDER BY 2 ");
        
        try 
        {
          r = bs.dbService.executeStaticQuery(sqlQuery.toString());
        } catch (Exception ex)
        {
          UtilidadesLog.error(ex);
          String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
          throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
        }
        
        UtilidadesLog.info("MONBusinessPlanningBean.obtieneTiposClasificacionPorSubTiposCliente(Long[] tiposClasificaciones):Salida");
        return r;

    }

    // sapaza -- PER-SiCC-2010-0699 -- 09/02/2011
    private Long obtieneTotalClientesSinUnidades(Long oidListaCliente) throws MareException {
        UtilidadesLog.info("MONBusinessPlanningBean.obtieneTotalClientesSinUnidades(Long oidListaCliente):Entrada");
        StringBuffer query = new StringBuffer("");
        query.append(" SELECT COUNT(1) ");
        query.append("   FROM MAV_LISTA_CLIEN_CLIEN ");
        query.append("  WHERE LICL_OID_LISTA_CLIE = " + oidListaCliente);
        query.append("    AND nvl(NUM_UNID,0) = 0 ");

        BelcorpService bs = BelcorpService.getInstance();
        RecordSet r = null;
        try {
          r = bs.dbService.executeStaticQuery(query.toString() );
        } catch (Exception ex)
        {
          UtilidadesLog.error(ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        Long total = new Long(((BigDecimal) r.getValueAt(0,0)).longValue());          
        
        UtilidadesLog.info("MONBusinessPlanningBean.obtieneTotalClientesSinUnidades(Long oidListaCliente):Salida");
        return total;
    }    
}
