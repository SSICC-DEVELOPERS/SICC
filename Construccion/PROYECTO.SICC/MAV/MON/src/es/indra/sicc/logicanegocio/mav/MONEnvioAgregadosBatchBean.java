package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.mav.DTODetalleMAV;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOEstatusSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.dtos.pre.DTOProductoMatriz;
import es.indra.sicc.logicanegocio.mav.DAOProcesoEnvioAgregadosSolicitud;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesLocalHome;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.ped.MONGenerarPosicionSolicitudLocal;
import es.indra.sicc.logicanegocio.ped.MONGenerarPosicionSolicitudLocalHome;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternosLocalHome;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMFLocal;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMFLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.RecuperadorIdiomaDefectoServidor;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Hashtable;

import java.util.Map;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;


public class MONEnvioAgregadosBatchBean implements SessionBean 
{
    SessionContext ctx = null;
    private static UtilidadesLog logAux = new UtilidadesLog();

    public void ejbCreate() {}

    public void ejbActivate() {}

    public void ejbPassivate() {}

    public void ejbRemove() {}

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    //MONEnvioAgregadosBatchBean
    public DTOEstatusSolicitud  validarAgregados(DTOSolicitudValidacion dto) throws MareException {
        UtilidadesLog.info("MONEnvioAgregadosBatchBean.validarAgregados(DTOSolicitudValidacion dto):Entrada");
        
        //doliva -- cambio Optimizacion Logs -- 09/04/2010
        if(logAux.isDebugEnabled())
            UtilidadesLog.debug("DTOSolicitudValidacion: " + dto);
        
        try { 
            DTODetalleMAV[] detallesMAV = this.obtenerDetallesMAVBatch(dto.getOidCliente(), dto.getOidPeriodo(), 
                    new Long(ConstantesMAV.T_ESTAD_PROCESO_INICIADO)); 
            if(detallesMAV.length > 0) { 
                //RecordSet rdatos = this.obtieneDatosCriterios(detallesMAV, dto);
                comprobarTodosCodigoVenta(dto, detallesMAV);
                for(int i = 0; i < detallesMAV.length; i++) { 
                    DTODetalleMAV dtoDetalleMAV = detallesMAV[i];
                    this.procesarLineaDetalle(dto, dtoDetalleMAV);
                }
            } 
            this.generarEnvio(dto, detallesMAV);
        } catch(Exception e) { 
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS)); 
        }
        
        
        this.aniadirAgregados(dto);
        
        DTOEstatusSolicitud dtos = new DTOEstatusSolicitud();
        dtos.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONEnvioAgregadosBatchBean.validarAgregados(DTOSolicitudValidacion dto):Salida");
        return dtos;        
    }
    
    //MONEnvioAgregadosBatchBean
    private void procesarLineaDetalle(DTOSolicitudValidacion dto1, DTODetalleMAV dto2)
        throws MareException {
        UtilidadesLog.info("MONEnvioAgregadosBatchBean.procesarLineaDetalle(DTOSolicitudValidacion dto1, DTODetalleMAV dto2):Entrada");
        UtilidadesLog.info("detalleMav: " + dto2.getOid());

        if ( dto2.getOidIdioma() == null)  {
            RecuperadorIdiomaDefectoServidor recuperadorIdioma = new RecuperadorIdiomaDefectoServidor();
            Long idiomaPorDefecto = recuperadorIdioma.getIdiomaDefectoServidor();
            dto2.setOidIdioma(idiomaPorDefecto);
        }
        try {
            dto2.setValidado(false);
            if(this.validarSolicitudPorDetalleMAV(dto1, dto2).booleanValue()) {
                dto2.setValidado(true);
                //Se hace todo junto y mas arriba
                //autor: jpbosnja
                //DTODetalleMAV dtoDetalleMAV =  this.comprobarCodigoVenta(dto2, dto1.getOidPeriodo());
                //UtilidadesLog.debug("DTODetalleMAV luego de Matriz Facturacion: " + dtoDetalleMAV);
                
                //Se genera En forma Masiva ahora
                //Autor: JPB
                //this.generarEnvio(dto1, dto2);
            }
            UtilidadesLog.debug(" Validacion oid detalle MAV " + dto2.getOid() + " es " + dto2.getValidado() );

        } catch(Exception e) {
            UtilidadesLog.error(e);
            if(e instanceof MareException) {
                throw (MareException)e;
            } else {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONEnvioAgregadosBatchBean.procesarLineaDetalle(DTOSolicitudValidacion dto1, DTODetalleMAV dto2):Salida");
    }       
    
    //MONEnvioAgregadosBatchBean    
    private Boolean validarSolicitudPorDetalleMAV(DTOSolicitudValidacion dto1, DTODetalleMAV dto2)
        throws MareException {
        UtilidadesLog.info("MONEnvioAgregadosBatchBean.validarSolicitudPorDetalleMAV(DTOSolicitudValidacion dto1, DTODetalleMAV dto2):Entrada");

        //jrivas 14/4/2008
        //Mejora T�cnica del Proceso Validar Agregados de MAV (GP2) 
        //Boolean bCumpleZonificacionYEstatus = this.cumpleZonificacionYEstatus(dto2, dto1.getOidCliente());
        Boolean bCumpleZonificacionYEstatus = new Boolean(true);


        if(bCumpleZonificacionYEstatus.booleanValue()) {
            Boolean bCumpleCriterioAsignacion = this.cumpleCriteriosAsignacion(dto1, dto2);
            UtilidadesLog.debug("bCumpleCriterioAsignacion " + bCumpleCriterioAsignacion);
            return bCumpleCriterioAsignacion;
        }

        UtilidadesLog.info("MONEnvioAgregadosBatchBean.validarSolicitudPorDetalleMAV(DTOSolicitudValidacion dto1, DTODetalleMAV dto2):Salida");
        return Boolean.FALSE;
    }    
    
  
    //MONEnvioAgregadosBatchBean    
        private void generarEnvio(DTOSolicitudValidacion dto1, DTODetalleMAV[] dto2)
            throws MareException {
            UtilidadesLog.info("MONEnvioAgregadosBatchBean.generarEnvio(DTOSolicitudValidacion dto1, DTODetalleMAV dto2):Entrada");
            /*Long lngUnidadesEnvio = new Long(0);
            if (dto2.getUnidadesPorCliente() != null) {
                lngUnidadesEnvio = new Long(dto2.getUnidadesPorCliente().longValue());
            }*/
    
            MONRegistroMAVLocal monMAV = null;
            if (dto2.length >0){
                try {
                    monMAV = this.getMONRegistroMAVLocalHome().create();
                    Long oidPeriodoProcesado = dto1.getOidPeriodo();
       
                    monMAV.generarEnviosMasivos(dto2, oidPeriodoProcesado,  dto1.getOidCliente());
                    
                } catch(CreateException re) {
                    UtilidadesLog.error("ERROR",re);
                    throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                } catch(NamingException ne) {
                    UtilidadesLog.error("ERROR",ne);
                    throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                } catch (Exception fex) {
                    UtilidadesLog.error("ERROR",fex);
                    String sCodigoError = 
                            CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(fex, 
                                  UtilidadesError.armarCodigoError(sCodigoError));
                }
            }
             
            UtilidadesLog.info("MONEnvioAgregadosBatchBean.generarEnvio(DTOSolicitudValidacion dto1, DTODetalleMAV dto2):Salida");
        }
        

      public DTODetalleMAV[] obtenerDetallesMAVBatch(Long lngOidCliente, Long lngOidPeriodo, Long lngTipoEstadoProceso)
        throws MareException {
        UtilidadesLog.info("obtenerDetallesMAVBatch(Long lngOidCliente, Long lngOidPeriodo, Long lngTipoEstadoProceso):Entrada");
        BelcorpService bs;
        //StringBuffer query = new StringBuffer();
        ArrayList aux = new ArrayList();
        DTODetalleMAV dtoDetalleMAV;
        ArrayList aux2 = new ArrayList();
        
          Long actividad;
          Long baseEstimadosDest;
          Integer campanaEvaluacion;
          Long catalogo;
          Long cicloVida;
          Long clasificacion;
          String criterio = "";
          Long curso;
          Long edadDesde;
          Long edadHasta;
          Boolean enviarMensaje;
          Long estadoMAV;
          Long estadoProceso;
          Double factorCorreccion;
          Long formaCobro;
          Long formaPago;
          Long listaClientes;
          Long marcaCondicion;
          Long mensaje;
          Double monto;
          Long negocio;
          String numeroAniversario = "";
          String observ = "";
          Long oid;
          Long periodo;
          Long periodoCurso;
          Long periodoFin;
          Long periodoFinMonto;
          Long periodoIniMonto;
          Double precio;
          Double precioContable;
          Double precioEstandar;
          String procedencia = "";
          Long producto;
          Long subCriterio;
          Long tipoClasificacion;
          Long tipoCliente;
          Long tipoOferta;
          BigDecimal unidadesEstimadas = new BigDecimal(0);
          Integer unidadesClientes;
          Integer unidadesTotales;
          Long unidadesTotalesEstimadas;
          Long unidadNegocio;
          Long tipoDespacho;
          Long criterioAsignacion;
          Long marca;
          Long canal;
          Long pais;
          String textoPeriodo = "";
          String descMarca = "";
          String descCanal = "";
          String descActividad = "";
          String descTipoCliente = "";     
          DTODetalleMAV[] dtoDetalles = new DTODetalleMAV[0];
        
        try {
            bs = BelcorpService.getInstance();
        } catch(MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        try {
            RecordSet rs;
            Vector parametros = new Vector();
            parametros.add(lngOidPeriodo.toString());
            parametros.add(lngOidCliente.toString());
            parametros.add(lngTipoEstadoProceso.toString());

            //rs = bs.dbService.executeProcedure("PQ_PLANI.MAV_OBTENER_DETALLES_MAV",parametros);
            rs = bs.dbService.executePreparedQuery("SELECT * FROM TABLE (CAST(MAV_OBTENER_DETALLES_MAV2 (?,?,?) AS OBJ_MAV_OBT_DETAL_MAV_TABLE))",parametros);
            bs = null;

            if(!rs.esVacio()) { 
                for(int i = 0; i < rs.getRowCount(); i++) { 
                    actividad = bigToLong(rs.getValueAt(i, 0)); 
                    baseEstimadosDest = bigToLong(rs.getValueAt(i, 1)); 
                    campanaEvaluacion = bigToInt(rs.getValueAt(i, 2)); 
                    catalogo = bigToLong(rs.getValueAt(i, 3)); 
                    cicloVida = bigToLong(rs.getValueAt(i, 4)); 
                    clasificacion = bigToLong( rs.getValueAt(i, 5)); 

                    if (rs.getValueAt(i, 6) != null) {
                        criterio = rs.getValueAt(i, 6).toString(); 
                    }

                    curso = bigToLong(rs.getValueAt(i, 7)); 
                    edadDesde = bigToLong(rs.getValueAt(i, 8)); 
                    edadHasta = bigToLong(rs.getValueAt(i, 9)); 
                    
                    if (rs.getValueAt(i, 10) != null &&
                         rs.getValueAt(i, 10).toString().equals("1")) {
                        enviarMensaje = Boolean.TRUE;
                    } else {
                        enviarMensaje = Boolean.FALSE;
                    }
                    
                    estadoMAV = bigToLong(rs.getValueAt(i, 11)); 
                    estadoProceso = bigToLong(rs.getValueAt(i, 12)); 
                    factorCorreccion = bigToDouble(rs.getValueAt(i, 13)); 
                    formaCobro = bigToLong(rs.getValueAt(i, 14)); 
                    listaClientes = bigToLong(rs.getValueAt(i, 15)); 
                    marcaCondicion = bigToLong(rs.getValueAt(i, 16)); 
                    mensaje = bigToLong(rs.getValueAt(i, 17)); 
                    monto = bigToDouble(rs.getValueAt(i, 18)); 
                    negocio = bigToLong(rs.getValueAt(i, 19)); 

                    // sapaza -- PER-SiCC-2010-0628 -- 20/10/2010
                    if (rs.getValueAt(i, 20) != null) {
                        numeroAniversario = rs.getValueAt(i, 20).toString(); 
                    }
                    
                    if (rs.getValueAt(i, 21) != null) {
                        observ = rs.getValueAt(i, 21).toString(); 
                    }
                    
                    oid = bigToLong(rs.getValueAt(i, 22)); 
                    periodo = bigToLong(rs.getValueAt(i, 23));  //**
                    periodoCurso = bigToLong(rs.getValueAt(i, 24));           
                    periodoFin = bigToLong(rs.getValueAt(i, 25)); 
                    periodoFinMonto = bigToLong(rs.getValueAt(i, 26)); 
                    periodoIniMonto = bigToLong(rs.getValueAt(i, 27)); 
                    precio = bigToDouble(rs.getValueAt(i, 28));    //**
                    precioContable = bigToDouble(rs.getValueAt(i, 29)); 
                    precioEstandar = bigToDouble(rs.getValueAt(i, 30)); //**
                    
                   
                    if (rs.getValueAt(i, 31) != null) {
                        procedencia = rs.getValueAt(i, 31).toString(); 
                    } else {
                        procedencia = null;
                    }
                    
                    producto = bigToLong(rs.getValueAt(i, 32)); 
                    subCriterio = bigToLong(rs.getValueAt(i, 33)); 
                    tipoClasificacion = bigToLong(rs.getValueAt(i, 34)); 
                    tipoCliente = bigToLong(rs.getValueAt(i, 35));   //**
                    tipoOferta = bigToLong(rs.getValueAt(i, 36));           
                    
                    if (rs.getValueAt(i, 37) != null) {
                        unidadesEstimadas = new BigDecimal(rs.getValueAt(i, 37).toString()); 
                    }
                    unidadesClientes = bigToInt(rs.getValueAt(i, 38)); 
                    unidadesTotales = bigToInt(rs.getValueAt(i, 39)); 
                    unidadesTotalesEstimadas = bigToLong(rs.getValueAt(i, 40)); 
                    unidadNegocio = bigToLong(rs.getValueAt(i, 41)); 
                    tipoDespacho = bigToLong(rs.getValueAt(i, 42));           
                    criterioAsignacion = bigToLong(rs.getValueAt(i, 43));
                    canal = bigToLong(rs.getValueAt(i, 44));           
                    marca = bigToLong(rs.getValueAt(i, 45)); 
                    pais = bigToLong(rs.getValueAt(i, 46));
                    
                    if (rs.getValueAt(i, 47) != null) {
                        textoPeriodo = rs.getValueAt(i, 47).toString();
                    }
                    
                    if (rs.getValueAt(i, 48) != null) {
                        descMarca = rs.getValueAt(i, 48).toString();
                    }
                    
                    if (rs.getValueAt(i, 49) != null) {
                        descCanal = rs.getValueAt(i, 49).toString();
                    }
                    
                    if (rs.getValueAt(i, 50) != null) {
                        descActividad = rs.getValueAt(i, 50).toString();
                    }

                    if (rs.getValueAt(i, 51) != null) {
                        descTipoCliente = rs.getValueAt(i, 51).toString(); 
                    }                    

                    formaPago = bigToLong(rs.getValueAt(i, 52)); 
                    
                    aux2.add(oid);
                    
                    dtoDetalleMAV = new DTODetalleMAV();
                    dtoDetalleMAV.setActividad(actividad);
                    dtoDetalleMAV.setBaseEstimadosDestinatarios(baseEstimadosDest);
                    dtoDetalleMAV.setCampagnaEvaluacion(campanaEvaluacion);
                    dtoDetalleMAV.setCatalogo(catalogo);
                    dtoDetalleMAV.setCicloVida(cicloVida);
                    dtoDetalleMAV.setClasificacion(clasificacion);
                    dtoDetalleMAV.setCriterio(criterio);
                    dtoDetalleMAV.setCurso(curso);
                    dtoDetalleMAV.setEdadDesde(edadDesde);
                    dtoDetalleMAV.setEdadHasta(edadHasta);
                    dtoDetalleMAV.setEnviarMensaje(enviarMensaje);
                    dtoDetalleMAV.setEstadoMAV(estadoMAV);
                    dtoDetalleMAV.setEstadoProceso(estadoProceso);
                    dtoDetalleMAV.setFactorCorreccion(factorCorreccion);
                    dtoDetalleMAV.setFormaCobro(formaCobro);
                    dtoDetalleMAV.setFormaPago(formaPago);
                    dtoDetalleMAV.setListaClientes(listaClientes);
                    dtoDetalleMAV.setMarcaCondicion(marcaCondicion);
                    dtoDetalleMAV.setMensaje(mensaje);
                    dtoDetalleMAV.setMonto(monto);
                    dtoDetalleMAV.setNegocio(negocio);
                    dtoDetalleMAV.setNumeroAniversario(numeroAniversario);
                    dtoDetalleMAV.setObservaciones(observ);
                    dtoDetalleMAV.setOid(oid);
                    dtoDetalleMAV.setPeriodo(periodo);
                    dtoDetalleMAV.setPeriodoCurso(periodoCurso);
                    dtoDetalleMAV.setPeriodoFin(periodoFin);
                    dtoDetalleMAV.setPeriodoFinMonto(periodoFinMonto);
                    dtoDetalleMAV.setPeriodoIniMonto(periodoIniMonto);
                    dtoDetalleMAV.setPrecio(precio);
                    dtoDetalleMAV.setPrecioContable(precioContable);
                    dtoDetalleMAV.setPrecioEstandar(precioEstandar);
                    dtoDetalleMAV.setProcedencia(procedencia);
                    dtoDetalleMAV.setProducto(producto);
                    dtoDetalleMAV.setSubcriterio(subCriterio);
                    dtoDetalleMAV.setCriterioAsignacion(criterioAsignacion);
                    dtoDetalleMAV.setTipoClasificacion(tipoClasificacion);
                    dtoDetalleMAV.setTipoCliente(tipoCliente);
                    dtoDetalleMAV.setTipoOferta(tipoOferta);
                    dtoDetalleMAV.setUnidadesEstimadas(unidadesEstimadas);
                    dtoDetalleMAV.setUnidadesPorCliente(unidadesClientes);
                    dtoDetalleMAV.setUnidadesTotales(unidadesTotales);
                    dtoDetalleMAV.setUnidadesTotalesEstimadas(unidadesTotalesEstimadas);
                    dtoDetalleMAV.setUnidadNegocio(unidadNegocio);
                    dtoDetalleMAV.setTipoDespacho(tipoDespacho);
                    dtoDetalleMAV.setCanal(canal);
                    dtoDetalleMAV.setMarca(marca);
                    dtoDetalleMAV.setOidPais(pais);
                    dtoDetalleMAV.setTextoMarca(descMarca);
                    dtoDetalleMAV.setTextoCanal(descCanal);
                    dtoDetalleMAV.setTextoPeriodo(textoPeriodo);
                    dtoDetalleMAV.setTextoActividad(descActividad);
                    dtoDetalleMAV.setTextoTipoCliente(descTipoCliente);
                    
                    aux.add(dtoDetalleMAV);
                }
                dtoDetalles = (DTODetalleMAV[])aux.toArray(new DTODetalleMAV[aux.size()]);
                
                //jrivas 14/4/2008
                //Mejora T�cnica del Proceso Validar Agregados de MAV (GP2) 
                //this.completarDTODetalleMAV(dtoDetalles, aux2);
                
            }
           
            return dtoDetalles;
        } catch(Exception e) {
            if(e instanceof MareException) {
                UtilidadesLog.error(e);
                throw (MareException)e;
            } else {
                UtilidadesLog.error(e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
    }
    
    private void completarDTODetalleMAV (DTODetalleMAV[] dtoDetalles, ArrayList oidS) throws MareException{
        BelcorpService bs;
        RecordSet resultado = new RecordSet();
        bs = UtilidadesEJB.getBelcorpService();
        String oids = generaIN(oidS);
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
            query = new StringBuffer();
            query.append(" select A.DENV_OID_DETA_MAV,  A.SBAC_OID_SBAC, B.ACCE_OID_ACCE ");
            query.append(" from MAV_DETAL_MAV_ACCES_SUBAC A, SEG_SUBAC B ");
            query.append(" WHERE A.SBAC_OID_SBAC = B.OID_SBAC ");
            query.append(" AND DENV_OID_DETA_MAV " + oids);
            resultado = bs.dbService.executeStaticQuery(query.toString());
            
            if (!resultado.esVacio()) {
                int i = 0;
                Long oidActual = new Long(resultado.getValueAt(0, "DENV_OID_DETA_MAV").toString()); 
                Long oid;
                Long acceso;
                Long subacceso;
                
                ArrayList accesos = new ArrayList();
                ArrayList subAccesos = new ArrayList();
                while (i < resultado.getRowCount() ) {
                    oid = new Long(resultado.getValueAt(i, "DENV_OID_DETA_MAV").toString()); 
                    acceso = new Long(resultado.getValueAt(i, "ACCE_OID_ACCE").toString()); 
                    subacceso = new Long(resultado.getValueAt(i, "SBAC_OID_SBAC").toString()); 
                    if (oidActual.equals(oid)) {
                        accesos.add(acceso);
                        subAccesos.add(subacceso);
                    } else {
                        for (int t = 0; t < dtoDetalles.length; t++ ) {
                            if (oidActual.equals(dtoDetalles[t].getOid())) {
                                dtoDetalles[t].setAccesos((Long[]) accesos.toArray(new Long[accesos.size()]));
                                dtoDetalles[t].setSubaccesos((Long[]) subAccesos.toArray(new Long[subAccesos.size()]));
                                break;
                            }           
                        }
                        accesos = new ArrayList();
                        subAccesos = new ArrayList();
                        accesos.add(acceso);
                        subAccesos.add(subacceso);
                        oidActual = oid;
                    }
                    i++;
                }
                for (int t = 0; t < dtoDetalles.length; t++ ) {
                    if (oidActual.equals(dtoDetalles[t].getOid())) {
                        dtoDetalles[t].setAccesos((Long[]) accesos.toArray(new Long[accesos.size()]));
                        dtoDetalles[t].setSubaccesos((Long[]) subAccesos.toArray(new Long[subAccesos.size()]));
                        break;
                    }           
                }                
            }
        } catch(RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }


        try {
            bs = BelcorpService.getInstance();
            query = new StringBuffer();
            query.append(" select DENV_OID_DETA_MAV, ZSGV_OID_SUBG_VENT,  ");
            query.append(" ZORG_OID_REGI, ZZON_OID_ZONA,  TERR_OID_TERR  ");
            query.append(" from MAV_DETAL_MAV_UNIDA_ADMIN ");
            query.append(" WHERE DENV_OID_DETA_MAV " + oids);
            resultado = bs.dbService.executeStaticQuery(query.toString());
            if (!resultado.esVacio()) {
                int i = 0;
                Long oidActual = new Long(resultado.getValueAt(0, "DENV_OID_DETA_MAV").toString()); 
                Long oid;
                Long zona;
                Long region;
                Long sgv;
                
                ArrayList zonas = new ArrayList();
                ArrayList regiones = new ArrayList();
                ArrayList sgvs = new ArrayList();
                //<inicio>SiCC-20070232 (Sapaza), se agregan listas para poder mantener las regiones y SGVS sin detalle
                ArrayList regionesTodas = new ArrayList();
                ArrayList sgvsTodas = new ArrayList();
                //<fin>SiCC-20070232

                //<inicio>SiCC-20070232 (Sapaza), se agregan listas para poder mantener las regiones sin zonas
                //y Subgerencias sin regiones
                while (i < resultado.getRowCount() ) {
                    oid = new Long(resultado.getValueAt(i, "DENV_OID_DETA_MAV").toString()); 
                    sgv = bigToLong(resultado.getValueAt(i, "ZSGV_OID_SUBG_VENT")); 
                    region = bigToLong(resultado.getValueAt(i, "ZORG_OID_REGI")); 
                    zona = bigToLong(resultado.getValueAt(i, "ZZON_OID_ZONA")); 
                    if (oidActual.equals(oid)) {
                        if (zona != null) {
                            zonas.add(zona);
                        }
                        if (region != null) {
                            regiones.add(region);
                            
                            if(zona == null)
                                regionesTodas.add(region);
                        }
                        if (sgv != null) {
                            sgvs.add(sgv);

                            if(region == null)
                                sgvsTodas.add(region);
                        }
                    } else {
                        for (int t = 0; t < dtoDetalles.length; t++ ) {
                            if (oidActual.equals(dtoDetalles[t].getOid())) {
                                dtoDetalles[t].setZonas((Long[]) zonas.toArray(new Long[zonas.size()]));
                                dtoDetalles[t].setSubgerencias((Long[]) sgvs.toArray(new Long[sgvs.size()]));
                                dtoDetalles[t].setRegiones((Long[]) regiones.toArray(new Long[regiones.size()]));
                                
                                dtoDetalles[t].setSubgerenciasTodas((Long[]) sgvsTodas.toArray(new Long[sgvsTodas.size()]));
                                dtoDetalles[t].setRegionesTodas((Long[]) regionesTodas.toArray(new Long[regionesTodas.size()]));
                                break;
                            }           
                        }
                        zonas = new ArrayList();
                        regiones = new ArrayList();
                        sgvs = new ArrayList();
                        regionesTodas = new ArrayList();
                        sgvsTodas = new ArrayList();
                
                        if (zona != null) {
                            zonas.add(zona);
                        }
                        if (region != null) {
                            regiones.add(region);
                            
                            if(zona == null)
                                regionesTodas.add(region);
                        }
                        if (sgv != null) {
                            sgvs.add(sgv);

                            if(region == null)
                                sgvsTodas.add(region);
                        }
                        oidActual = oid;
                    }
                    i++;
                }
                for (int t = 0; t < dtoDetalles.length; t++ ) {
                    if (oidActual.equals(dtoDetalles[t].getOid())) {
                        dtoDetalles[t].setZonas((Long[]) zonas.toArray(new Long[zonas.size()]));
                        dtoDetalles[t].setSubgerencias((Long[]) sgvs.toArray(new Long[sgvs.size()]));
                        dtoDetalles[t].setRegiones((Long[]) regiones.toArray(new Long[regiones.size()]));

                        dtoDetalles[t].setSubgerenciasTodas((Long[]) sgvsTodas.toArray(new Long[sgvsTodas.size()]));
                        dtoDetalles[t].setRegionesTodas((Long[]) regionesTodas.toArray(new Long[regionesTodas.size()]));
                        break;
                    }           
                }
                //<fin>SiCC-20070232
            }
        } catch(RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        /*try {
            bs = BelcorpService.getInstance();
            query = new StringBuffer();
            query.append(" select DENV_OID_DETA_MAV, SBTI_OID_SUBT_CLIE ");
            query.append(" from MAV_SUBTI_CLIEN_DETAL ");
            query.append(" WHERE DENV_OID_DETA_MAV " + oids);
            resultado = bs.dbService.executeStaticQuery(query.toString());

            if (!resultado.esVacio()) {
                int i = 0;
                Long oidActual = new Long(resultado.getValueAt(0, "DENV_OID_DETA_MAV").toString()); 
                Long oid;
                Long subtipo;
               
                ArrayList subtipos = new ArrayList();
                while (i < resultado.getRowCount() ) {
                    oid = new Long(resultado.getValueAt(i, "DENV_OID_DETA_MAV").toString()); 
                    subtipo = new Long(resultado.getValueAt(i, "SBTI_OID_SUBT_CLIE").toString()); 
                    if (oidActual.equals(oid)) {
                        subtipos.add(subtipo);
                    } else {
                        for (int t = 0; t < dtoDetalles.length; t++ ) {
                            if (oidActual.equals(dtoDetalles[t].getOid())) {
                                dtoDetalles[t].setSubtiposCliente((Long[]) subtipos.toArray(new Long[subtipos.size()]));
                                break;
                            }           
                        }
                        subtipos = new ArrayList();
                        subtipos.add(subtipo);
                        oidActual = oid;
                    }
                    i++;
                }
                for (int t = 0; t < dtoDetalles.length; t++ ) {
                    if (oidActual.equals(dtoDetalles[t].getOid())) {
                        dtoDetalles[t].setSubtiposCliente((Long[]) subtipos.toArray(new Long[subtipos.size()]));
                        break;
                    }           
                }                
            }
            
        } catch(RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }*/
    }
    
    //MONEnvioAgregadosBatchBean
    private void aniadirAgregados(DTOSolicitudValidacion dto1) throws MareException {
        UtilidadesLog.info("MONEnvioAgregadosBatchBean.aniadirAgregados(DTOSolicitudValidacion dto1):Entrada");
        DAOProcesoEnvioAgregadosSolicitud daoProcesoEnvioAgregadosSolicitud = new DAOProcesoEnvioAgregadosSolicitud();
        RecordSet rs = new RecordSet();

        try {
            UtilidadesLog.debug("Llama a daoProcesoEnvioAgregadosSolicitud.obtenerEnviosMAV");
            rs = daoProcesoEnvioAgregadosSolicitud.obtenerEnviosMAV(dto1);
            ArrayList posiciones = new ArrayList();
            ArrayList arrayMensajes = new ArrayList();
            ArrayList envios = new ArrayList();
            if(!rs.esVacio()) {
                // Agregado por ssantana, 25/7/2005, 
                //  a petici�n de Juan Pablo Bosnjak
                BigDecimal ultCodPosi = daoProcesoEnvioAgregadosSolicitud.obtenerUltimaPosicion(dto1.getOidSolicitud());             
                if(ultCodPosi == null) 
                      ultCodPosi = new BigDecimal(0.0D); 
                // Fin agregado ssantana, 27/5/2005
                
                DTODetalleMAV dtoDetalleMAV;
                for(int i = 0; i < rs.getRowCount(); i++) {
                    dtoDetalleMAV = new DTODetalleMAV();

                    DTOOID dtoOid = new DTOOID();
                    dtoOid.setOid(new Long((rs.getValueAt(i, 6)).toString()));
                    dtoOid.setIpCliente(dto1.getIpCliente());
                    dtoOid.setOidIdioma(dto1.getOidIdioma());

                    if (dtoDetalleMAV.getOidIdioma() == null) {
                        UtilidadesLog.debug("Recupera Idioma por defecto servidor");
                        RecuperadorIdiomaDefectoServidor recuperadorIdioma = 
                                new RecuperadorIdiomaDefectoServidor();
                        Long idiomaPorDefecto = 
                                recuperadorIdioma.getIdiomaDefectoServidor();
                        dtoDetalleMAV.setOidIdioma(idiomaPorDefecto);        
                    }

                    DTOPosicionSolicitud dtoPosicion = new DTOPosicionSolicitud();
                                        
                    dtoPosicion.setNumeroPosicion(new Long(ultCodPosi.longValue()+i+1));                     
                    dtoPosicion.setCodigoVenta((String) (rs.getValueAt(i,19)));
                    dtoPosicion.setOidDetalleOferta(Long.valueOf(rs.getValueAt(i,20).toString()) );
                    dtoPosicion.setTipoPosicion(dto1.getProceso().getOidTipoPosicion());
                    dtoPosicion.setSubtipoPosicion(dto1.getProceso().getOidSubTipoPosicion());
                    
                    dtoPosicion.setProducto(bigToLong(rs.getValueAt(i,21)));
                    
                    dtoPosicion.setUnidadesDemandadas(new Long(0));
                    dtoPosicion.setUnidadesPorAtender(new Long((rs.getValueAt(i, 2)).toString()));
                    dtoPosicion.setUnidadesComprometidas(dtoPosicion.getUnidadesPorAtender());
                    dtoPosicion.setUnidadesDemandaReal(dtoPosicion.getUnidadesPorAtender());

                    Double precio = bigToDouble(rs.getValueAt(i,22));
                    Double precioContable = bigToDouble(rs.getValueAt(i,23));
                    if (precioContable == null) {
                        precioContable = new Double(0);
                    }
                    
                    if(precio.doubleValue() > 0) { // sapaza -- PER-SiCC-2011-0292 -- 25/04/2011
                        
                        BigDecimal bigPrecioCatUnitLocal = new BigDecimal(precio.doubleValue());
                        BigDecimal bigTipoCambio = dto1.getTipoCambio();
                        BigDecimal bigPrecioCatUniDoc = new BigDecimal(0);
                        
                        if ( bigTipoCambio != null && bigTipoCambio.doubleValue() > 0)
                          bigPrecioCatUniDoc = bigPrecioCatUnitLocal.divide(bigTipoCambio, BigDecimal.ROUND_HALF_UP);

                        dtoPosicion.setPrecioContableUnitarioLocal(new BigDecimal(0));                        
                        dtoPosicion.setPrecioContableUnitarioDocumento(new BigDecimal(0));
                        dtoPosicion.setPrecioCatalogoUnitarioLocal(bigPrecioCatUnitLocal);
                        dtoPosicion.setPrecioCatalogoUnitarioDocumento(bigPrecioCatUniDoc);

                    } else {
                        UtilidadesLog.debug("dtoDetalleMAV.getPrecio() <= 0");
                        
                        BigDecimal bigPrecioContable = new BigDecimal(precioContable.doubleValue());
                        BigDecimal bigTipoCambio = dto1.getTipoCambio();
                        BigDecimal bigPrecioContableUnitDoc = new BigDecimal(0);
                        if ( bigTipoCambio != null && bigTipoCambio.doubleValue() > 0) 
                           bigPrecioContableUnitDoc = bigPrecioContable.divide(bigTipoCambio, BigDecimal.ROUND_HALF_UP);
                                        
                        dtoPosicion.setPrecioCatalogoUnitarioLocal(new BigDecimal(0));
                        dtoPosicion.setPrecioCatalogoUnitarioDocumento(new BigDecimal(0));
                        dtoPosicion.setPrecioContableUnitarioLocal(bigPrecioContable);
                        dtoPosicion.setPrecioContableUnitarioDocumento(bigPrecioContableUnitDoc);
                    }
                    dtoPosicion.setEstadoPosicion(ConstantesPED.ESTADO_POSICION_CORRECTO);

                    // sapaza -- PER-SiCC-2013-0432 -- 18/04/2013
                    if(rs.getValueAt(i, 45) != null)    {
                        dtoPosicion.setOidAlmacen(new Long(rs.getValueAt(i, 45).toString()));
                    }
                    
                    posiciones.add(dtoPosicion);
            
                    boolean enviaMen = false;
                    if (rs.getValueAt(i,24) != null && rs.getValueAt(i,24).toString().equals("1")) {
                        enviaMen = true;
                    }
                    boolean hayStock = false;
                    if (rs.getValueAt(i,35) != null && rs.getValueAt(i,35).toString().equals("1")) {
                        hayStock = true;
                    }
                    
                    //doliva -- cambio Optimizacion Logs -- 09/04/2010
                    if(logAux.isDebugEnabled())
                        UtilidadesLog.debug(" enviaMen: " + enviaMen + " hayStock: " + hayStock);
                        
                    //String mensajeLog = "condicion envio mensaje - enviaMen: " + enviaMen + " hayStock: " + hayStock + " para detalle mav " + dtoDetalleMAV;
                    //UtilidadesLog.debug(mensajeLog);

                    if ( enviaMen && hayStock ) {
                        DTOBuzonMensajes dtoDatosMensaje = new DTOBuzonMensajes();
                        dtoDatosMensaje.setOidPais(bigToLong(rs.getValueAt(i,25)));
                        if (rs.getValueAt(i, 15) != null) {
                            Long oidMensaje = Long.valueOf( rs.getValueAt(i, 15).toString());
                            dtoDatosMensaje.setOidMensaje(oidMensaje);
                        }
                        dtoDatosMensaje.setCodigoMensaje(rs.getValueAt(i,34).toString());
                        dtoDatosMensaje.setOidCliente(new Long(rs.getValueAt(i,8).toString()));
                        dtoDatosMensaje.setModuloOrigen(new Long(ConstantesSEG.MODULO_MAV));
                        dtoDatosMensaje.setDatoVariable1("" +bigToLong(rs.getValueAt(i,28)));
                        dtoDatosMensaje.setDatoVariable2((String) (rs.getValueAt(i,19)));
                        if (rs.getValueAt(i, 18)!=null){
                            dtoDatosMensaje.setDatoVariable3(rs.getValueAt(i, 18).toString()); //     * -> mensaje.descripcionProducto = descripcion de producto del registro del env�o
                        }
                        if (rs.getValueAt(i,23) != null) {
                            dtoDatosMensaje.setDatoVariable4(""+new BigDecimal(rs.getValueAt(i,23).toString()));
                        }
                        
                        if (rs.getValueAt(i,22) != null) {
                            dtoDatosMensaje.setDatoVariable5(""+new BigDecimal(rs.getValueAt(i,22).toString()));
                            dtoDatosMensaje.setDatoVariable6(""+new BigDecimal(rs.getValueAt(i,22).toString()));
                        }
                        
                        dtoDatosMensaje.setDatoVariable7("" + new Long((rs.getValueAt(i, 2)).toString()));
                        
                        dtoDatosMensaje.setDatoVariable8("" +(String)rs.getValueAt(i, 41));//PeriodoInicio
                        dtoDatosMensaje.setDatoVariable9("" +(String)rs.getValueAt(i, 42));//PeriodoFin
                        
                        //  Inicio - Agregado por HRCS - Recuperado de la decompilacion 09/04/2007
                        if(rs.getValueAt(i, 43) != null)    {
                            dtoDatosMensaje.setDatoVariable10(rs.getValueAt(i, 43).toString());
                        }
                        if(rs.getValueAt(i, 44) != null)    {
                            dtoDatosMensaje.setDatoVariable11(rs.getValueAt(i, 44).toString());
                        }
                        if(rs.getValueAt(i, 16) != null)    {
                            dtoDatosMensaje.setDatoVariable20(rs.getValueAt(i, 16).toString());
                        }
                        //  Fin - Agregado por HRCS - Recuperado de la decompilacion 09/04/2007
                        
                        dtoDatosMensaje.setDatoVariable13((String)rs.getValueAt(i, 36));//TipoCliente
                        dtoDatosMensaje.setDatoVariable14((String)rs.getValueAt(i, 37));//SubtipoCliente
                        dtoDatosMensaje.setDatoVariable15((String)rs.getValueAt(i, 38));//TipoClasificacion
                        dtoDatosMensaje.setDatoVariable16((String)rs.getValueAt(i, 39));//Clasificacion
                        dtoDatosMensaje.setDatoVariable17((String)rs.getValueAt(i, 40));//EstadoMAV
                        dtoDatosMensaje.setDatoVariable18(null);
                        dtoDatosMensaje.setDatoVariable19(null);
                        //dtoDatosMensaje.setDatoVariable20(null);  Quitado por HRCS - Decompilado 09/04/2007
                        dtoDatosMensaje.setListaConsultoras("N");
                        dtoDatosMensaje.setCodigoPatron(null);
                        dtoDatosMensaje.setNumeroSecuencial(null);
                        dtoDatosMensaje.setNumeroLoteImpresion(null);
                        dtoDatosMensaje.setFechaGrabacion(null);
                        
                        dtoDatosMensaje.setOidCabeceraSolicitudTemp(new Long((rs.getValueAt(i, 0)).toString()));
                        arrayMensajes.add(dtoDatosMensaje);
                    }

                    envios.add(new Long((rs.getValueAt(i, 0)).toString()));
                }
                DTOCabeceraSolicitud cabecera = new DTOCabeceraSolicitud();
                cabecera.setOidCabeceraSolicitud(dto1.getOidSolicitud());
                cabecera.setPeriodo(dto1.getOidPeriodo());
                cabecera.setAcceso(dto1.getOidAcceso());
                cabecera.setSubacceso(dto1.getOidSubAcceso());
                cabecera.setIndicadorDigitacion(new Boolean("false"));//no es digitada
                cabecera.setTipoSolicitud(dto1.getOidTipoSolPais());
                MONGenerarPosicionSolicitudLocal monGenerearPosi =  this.getMONGenerarPosicionSolicitudLocalHome().create();
                posiciones = monGenerearPosi.generarPosicionesCuadre(cabecera, posiciones);
                for (int z = 0 ; z < posiciones.size() ; z++ ){
                    DTOPosicionSolicitud dtop = (DTOPosicionSolicitud) posiciones.get(z);
                    if (dtop.getOK()!=null && !dtop.getOK().booleanValue()){
                        String mensajeLog = "[PED] [ANIADIR AGREGADOS] Posici�n solicitud anulada";
                        BelcorpService.getInstance().log.info(mensajeLog);
                    }
                }                
                
            }
            DTOBuzonMensajes[] dtoBuzonMensajes = new DTOBuzonMensajes[arrayMensajes.size()];
            for ( int x = 0 ; x < arrayMensajes.size() ; x++ ){
                dtoBuzonMensajes[x] = (DTOBuzonMensajes)arrayMensajes.get(x);
            }
            if (dtoBuzonMensajes.length>0){
                dtoBuzonMensajes = this.getMONGestionMensajesLocalHome().create().insertarDatosMensajesBatch(dtoBuzonMensajes);
            }
            
            //doliva -- cambio Optimizacion Logs -- 09/04/2010
            if(logAux.isDebugEnabled())
                UtilidadesLog.debug("arrayMensajes.size() " + arrayMensajes.size() + "dtoBuzonMensajes.length " + dtoBuzonMensajes.length );

            StringBuffer inserts = new StringBuffer();  
            if(!dto1.getIndSimulacion().booleanValue()) {
                for (int x = 0 ; x < envios.size() ; x++ ){
                    Long oidEnvio = (Long)envios.get(x);
                    Long numeroSecuencia = null;
                    //<inicio>modificado por incidencia SICC-20070230
                    for (int z = 0 ; z < dtoBuzonMensajes.length ; z++){
                        if (dtoBuzonMensajes[z].getOidCabeceraSolicitudTemp()!=null &&
                            dtoBuzonMensajes[z].getOidCabeceraSolicitudTemp().longValue() == oidEnvio.longValue()){
                            numeroSecuencia = dtoBuzonMensajes[z].getNumeroSecuencial();
                            break;
                        }
                    }    
                    StringBuffer query = new StringBuffer();
                    query.append("update MAV_ENVIO ");
                    query.append(" set IND_ENVI = 'E' ");
                    //27/12/2006 (gacevedo)
                    //se comprueba que el dto no sea nulo, ya que si no hay stock
                    //para el producto, el mensaje no se genera y por ende el dto
                    //es null.
                    if (numeroSecuencia!=null) {
                        query.append(" , NUM_SECU = " + numeroSecuencia);
                    }
                    query.append(" where OID_ENVI = " + oidEnvio);
                    query.append(";");
                    inserts.append(query);
                    query = new StringBuffer();
                    query.append("INSERT INTO MAV_SOLIC_ENVIO ");
                    query.append(" (OID_SOLI_ENVI, SOCA_OID_SOLI_CABE, IND_GENE, MENV_OID_ENVI ) ");
                    query.append(" VALUES ");
                    query.append(" (MAV_SOEN_SEQ.nextval, " + dto1.getOidSolicitud() + ", 1, " + oidEnvio + " );");
                    inserts.append(query);
                    //}
                    //<fin>modificado por incidencia SICC-20070230
                }            
            }
            BelcorpService belcorpService = BelcorpService.getInstance();
            belcorpService.dbService.executeProcedure("PQ_PLANI.EXECUTOR", inserts.toString());
        } catch(CreateException ce) {
            UtilidadesLog.error(ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(NamingException ne) {
            UtilidadesLog.error(ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(Exception e) {
            e.printStackTrace();
            UtilidadesLog.error(e);
            if(e instanceof MareException) {
                throw (MareException)e;
            } else {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONEnvioAgregadosBatchBean.aniadirAgregados(DTOSolicitudValidacion dto1):Salida");
   } 
   
   
    /**
    * Retorna true si cumple con la zonificacion y el estatus.
    */
    private Boolean cumpleZonificacionYEstatus(DTODetalleMAV dtoDetalleMAV, Long lngOidCliente) throws MareException {
        UtilidadesLog.info("cumpleZonificacionYEstatus():Entrada");
        BelcorpService bs;
        StringBuffer query = new StringBuffer();
        StringBuffer queryEstatus = new StringBuffer();
        boolean cumpleZonificacion = false;
        boolean cumpleEstatus = false;
        RecordSet rsZon, rsEst;

        try {
            bs = BelcorpService.getInstance();
        } catch(MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        /*
         * Verifica si cumple Zonificacion.
         */
        String sgv = this.includeIN("ZON_SUB_GEREN_VENTA.OID_SUBG_VENT", dtoDetalleMAV.getSubgerencias());
        String regi = this.includeIN("ZON_REGIO.OID_REGI", dtoDetalleMAV.getRegiones());
        String zonas = this.includeIN("ZON_ZONA.OID_ZONA", dtoDetalleMAV.getZonas());
        //<inicio>SiCC-20070232, modificado por Sapaza
        String sgvTodas = this.includeIN("ZON_SUB_GEREN_VENTA.OID_SUBG_VENT", dtoDetalleMAV.getSubgerenciasTodas());
        String regiTodas = this.includeIN("ZON_REGIO.OID_REGI", dtoDetalleMAV.getRegionesTodas());
        //<fin>SiCC-20070232, modificado por Sapaza
        
        if(sgv.length()>0 ||regi.length() > 0|| zonas.length() > 0) {
            query.append(" SELECT count(*) cumpleZonificacion ");
            query.append(" FROM ");
            query.append("   MAE_CLIEN, ");
            query.append("   MAE_CLIEN_UNIDA_ADMIN, ");
            query.append("   ZON_TERRI_ADMIN, ");
            query.append("   ZON_SECCI, ");
            
            //<inicio>SiCC-20070232 (Sapaza), se modifico la query pa que incluyera a las regiones
            //con todas sus zonas y subgerencia de ventas con todas sus regiones
            if (zonas.length() > 0 && regiTodas.length()==0 && sgvTodas.length()==0) {
                query.append(" ZON_ZONA ");
            } else {
                if (regi.length() > 0 && sgvTodas.length()==0 ) {
                    query.append(" ZON_ZONA, ");
                    query.append(" ZON_REGIO ");
                } else {
                    if (sgv.length() > 0) {
                        query.append(" ZON_ZONA, ");
                        query.append(" ZON_REGIO, ");
                        query.append(" ZON_SUB_GEREN_VENTA  ");
                    }                
                }
            }
            query.append(" WHERE ");
            query.append(" mae_clien.oid_clie = mae_clien_unida_admin.CLIE_OID_CLIE ");            
            query.append(" AND ZON_TERRI_ADMIN.OID_TERR_ADMI = MAE_CLIEN_UNIDA_ADMIN.ZTAD_OID_TERR_ADMI ");
            query.append(" AND ZON_TERRI_ADMIN.ZSCC_OID_SECC = ZON_SECCI.OID_SECC ");

            if (zonas.length() > 0 && regiTodas.length()==0 && sgvTodas.length()==0) {
                query.append(" AND ZON_ZONA.OID_ZONA = ZON_SECCI.ZZON_OID_ZONA ");
            } else {
                if (regi.length() > 0 && sgvTodas.length()==0 ) {
                    query.append(" AND ZON_ZONA.OID_ZONA = ZON_SECCI.ZZON_OID_ZONA ");
                    query.append(" AND ZON_REGIO.OID_REGI = ZON_ZONA.ZORG_OID_REGI ");
                } else {
                    if (sgv.length() > 0) {
                        query.append(" AND ZON_ZONA.OID_ZONA = ZON_SECCI.ZZON_OID_ZONA ");
                        query.append(" AND ZON_REGIO.OID_REGI = ZON_ZONA.ZORG_OID_REGI ");
                        query.append(" AND ZON_SUB_GEREN_VENTA.OID_SUBG_VENT = ZON_REGIO.ZSGV_OID_SUBG_VENT ");
                    }                
                }
            }
            if (zonas.length() > 0) {
                query.append(" AND ((" + zonas + ") ");              
                
                //se agregan las regiones que no tiene detalle de zona y subgerencias que no tiene detalle de regiones
                if (regiTodas.length() > 0)  
                  query.append(" OR (" + regiTodas + ") ");
    
                if (sgvTodas.length() > 0)  
                  query.append(" OR (" + sgvTodas + ") ");
                
            } else {
                if (regi.length() > 0) { 
                  query.append(" AND ((" + regi + ") ");
                 
                  //se agregan las subgerencias que no tiene detalle de regiones
                  if (sgvTodas.length() > 0)  
                    query.append(" OR (" + sgvTodas + ") ");
                  
                } else {
                    if (sgv.length() > 0) {
                        query.append(" AND ((" + sgv + ")");
                    }
                }
            }

            query.append(" )");
            //<fin>SiCC-20070232, modificado por Sapaza
            
            query.append(" AND MAE_CLIEN.OID_CLIE = " + lngOidCliente);
            query.append(" AND MAE_CLIEN_UNIDA_ADMIN.IND_ACTI = 1 ");
            try {
                rsZon = bs.dbService.executeStaticQuery(query.toString());
            } catch(Exception e) {
                e.printStackTrace();
                UtilidadesLog.error(e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            if (((BigDecimal)rsZon.getValueAt(0,0)).intValue() > 0) {
                cumpleZonificacion = true;
            }

        } else {
            cumpleZonificacion = true;
        }

        /*
         * Verifica si cumple Estatus.
         */
        queryEstatus.append(" SELECT count (*) cumpleEstatus ");
        queryEstatus.append(" FROM mav_detal_mav ");
        queryEstatus.append(" WHERE mav_detal_mav.oid_deta_mav = " + dtoDetalleMAV.getOid() );
        queryEstatus.append(" AND ( mav_detal_mav.aest_oid_esta_acti IS NULL ");
        queryEstatus.append("     OR ( SELECT COUNT (*) ");
        queryEstatus.append("          FROM mae_clien, ");
        queryEstatus.append("             mae_clien_datos_adici, ");
        queryEstatus.append("             mae_estat_clien, ");
        queryEstatus.append("             mav_estad_mav_mae, ");
        queryEstatus.append("             mav_estad_mav, ");
        queryEstatus.append("             mav_activ_estad ");
        queryEstatus.append("          WHERE mae_clien.oid_clie = " + lngOidCliente);
        queryEstatus.append("             AND mae_clien_datos_adici.clie_oid_clie = mae_clien.oid_clie ");
        queryEstatus.append("             AND mae_clien_datos_adici.esta_oid_esta_clie = mae_estat_clien.oid_esta_clie ");
        queryEstatus.append("             AND mae_estat_clien.oid_esta_clie = mav_estad_mav_mae.esta_oid_esta_clie ");
        queryEstatus.append("             AND mav_estad_mav_mae.emav_oid_esta_mav = mav_estad_mav.oid_esta_mav ");
        queryEstatus.append("             AND mav_estad_mav.oid_esta_mav = mav_activ_estad.emav_oid_esta_mav ");
        queryEstatus.append("             AND mav_activ_estad.oid_esta_acti = mav_detal_mav.aest_oid_esta_acti ");
        queryEstatus.append("         ) > 0 ");
        queryEstatus.append("      ) ");

        try {
            rsEst = bs.dbService.executeStaticQuery(queryEstatus.toString());
        } catch(Exception e) {
            e.printStackTrace();
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (((BigDecimal)rsEst.getValueAt(0,0)).intValue() > 0) {
            cumpleEstatus = true;
        }        
        
        UtilidadesLog.info("cumpleZonificacionYEstatus():Salida " + (cumpleZonificacion && cumpleEstatus) );
        return Boolean.valueOf(cumpleZonificacion && cumpleEstatus);
    }   
    
    
    //MONEnvioAgregadosBatchBean    
    private Boolean cumpleCriteriosAsignacion(DTOSolicitudValidacion dto1, DTODetalleMAV dto2)
        throws MareException {
        UtilidadesLog.info("MONEnvioAgregadosBatchBean.cumpleCriteriosAsignacion(DTOSolicitudValidacion dto1, DTODetalleMAV dto2):Entrada");
        Boolean bRespuesta = Boolean.FALSE;

        DAOProcesoEnvioAgregadosSolicitud daoProcesoEnvioAgregadosSolicitud = new DAOProcesoEnvioAgregadosSolicitud();

        if(dto2.getCriterioAsignacion().intValue() == ConstantesMAV.CRITERIO_ASIGNA_ATRIBUTOS) {
            try {
                bRespuesta = daoProcesoEnvioAgregadosSolicitud.cumpleCriterioPorAtributos(dto1, dto2);
                daoProcesoEnvioAgregadosSolicitud = null;
            } catch(Exception e) {
                UtilidadesLog.error("ERROR", e);
                if(e instanceof MareException) {
                    throw (MareException)e;
                } else {
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
            }
        }else if(dto2.getCriterioAsignacion().intValue() == ConstantesMAV.CRITERIO_ASIGNA_VARIABLES){
            bRespuesta = new Boolean(true);
        }

        UtilidadesLog.info("MONEnvioAgregadosBatchBean.cumpleCriteriosAsignacion(DTOSolicitudValidacion dto1, DTODetalleMAV dto2):Salida");
        return bRespuesta;
    } 
    
/*    private RecordSet obtieneDatosCriterios(DTODetalleMAV[] dto2, DTOSolicitudValidacion dto) throws MareException {
        RecordSet resultado = null;
        BelcorpService bs;
        StringBuffer query = new StringBuffer();
        ArrayList periodosDesde = new ArrayList();
        ArrayList periodosHasta = new ArrayList();
        DTODetalleMAV dtoAux;
        for (int t = 0; t < dto2.length; t++ ) {
                dtoAux = dto2[t];
                if (dtoAux.getPeriodoIniMonto() != null) {
                    periodosDesde.add(dto2[t].getPeriodoIniMonto());
                }

                if (dtoAux.getPeriodoFinMonto() != null) {
                    periodosHasta.add(dto2[t].getPeriodoFinMonto());
                }                
        }           

        String perDes = this.generaIN(periodosDesde);
        String perHas = this.generaIN(periodosHasta);

        try {
            bs = BelcorpService.getInstance();
        } catch(MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append("     SELECT   SUM (  ped_solic_posic.num_unid_por_aten * ped_solic_posic.val_prec_cata_unit_loca ) monto, ");
            query.append("          mp.mapr_oid_marc_prod, mp.uneg_oid_unid_nego, mp.nego_oid_nego, ");
            query.append("          pre_ofert_detal.ocat_oid_catal, pcabecera.oid_peri ");
            query.append("     FROM ped_solic_cabec, ");
            query.append("          ped_solic_posic, ");
            if (periodosDesde.size() != 0) {
                query.append("          cra_perio pini, ");
                query.append("          cra_perio pfin, ");
            }
            query.append("          cra_perio pcabecera, ");
            query.append("          pre_ofert_detal, ");
            query.append("          mae_produ mp ");
            query.append("    WHERE ped_solic_cabec.oid_soli_cabe != " + dto.getOidSolicitud());
            query.append("      AND ped_solic_cabec.oid_soli_cabe = ped_solic_posic.soca_oid_soli_cabe ");
            query.append("      AND ped_solic_cabec.clie_oid_clie = " + dto.getOidCliente());
            query.append("      AND ped_solic_cabec.fec_fact IS NOT NULL ");
            query.append("      AND ped_solic_cabec.perd_oid_peri = pcabecera.oid_peri ");
            
            if (periodosDesde.size() != 0) {
                query.append("      AND pcabecera.fec_inic >= pini.fec_inic ");
                query.append("      AND pcabecera.fec_fina <= pfin.fec_fina ");
                query.append("      AND pcabecera.cana_oid_cana = pini.cana_oid_cana ");
                query.append("      AND pcabecera.marc_oid_marc = pini.marc_oid_marc ");
                query.append("      AND pcabecera.pais_oid_pais = pini.pais_oid_pais ");
                query.append("      AND pini.oid_peri = (select OID_PERI from ( ");
                query.append(" 			  select cp.OID_PERI from cra_perio cp ");
                query.append(" 			  where cp.OID_PERI " + perDes);
                query.append(" 			  order by cp.FEC_INIC ");
                query.append(" 			  ) where rownum = 1)	 ");
                query.append("      AND pfin.oid_peri = (select OID_PERI from (	");
                query.append(" 		  	  select cp.OID_PERI from cra_perio cp ");
                query.append(" 			  where cp.OID_PERI " + perHas);
                query.append(" 			  order by cp.FEC_INIC desc  ");
                query.append(" 			  ) where rownum = 1)	 ");
            } else {
                query.append(" AND pcabecera.oid_peri = " + dto.getOidPeriodo());
            }
            query.append("      AND ped_solic_posic.ofde_oid_deta_ofer = pre_ofert_detal.oid_deta_ofer ");
            query.append("      AND ped_solic_posic.prod_oid_prod = mp.oid_prod ");
            query.append(" GROUP BY mp.mapr_oid_marc_prod, ");
            query.append("          mp.uneg_oid_unid_nego, ");
            query.append("          mp.nego_oid_nego, ");
            query.append("          pre_ofert_detal.ocat_oid_catal, ");
            query.append("          pcabecera.oid_peri ");
            query.append(" UNION ALL ");
            query.append(" SELECT   SUM (  ped_solic_posic.num_unid_por_aten * ped_solic_posic.val_prec_cata_unit_loca) monto, ");
            query.append("          mp.mapr_oid_marc_prod, mp.uneg_oid_unid_nego, mp.nego_oid_nego, ");
            query.append("          pre_ofert_detal.ocat_oid_catal, ped_solic_cabec.perd_oid_peri ");
            query.append("     FROM ped_solic_cabec, ped_solic_posic, pre_ofert_detal, mae_produ mp ");
            query.append("    WHERE ped_solic_cabec.oid_soli_cabe = " + dto.getOidSolicitud());
            query.append("      AND ped_solic_cabec.oid_soli_cabe = ped_solic_posic.soca_oid_soli_cabe ");
            query.append("      AND ped_solic_posic.ofde_oid_deta_ofer = pre_ofert_detal.oid_deta_ofer ");
            query.append("      AND ped_solic_posic.prod_oid_prod = mp.oid_prod ");
            query.append(" GROUP BY mp.mapr_oid_marc_prod, ");
            query.append("          mp.uneg_oid_unid_nego, ");
            query.append("          mp.nego_oid_nego, ");
            query.append("          pre_ofert_detal.ocat_oid_catal, ");
            query.append("          ped_solic_cabec.perd_oid_peri		 ");

            es.indra.mare.common.mii.services.jdbcservice.RecordSet rs;
            rs = (es.indra.mare.common.mii.services.jdbcservice.RecordSet)bs.dbService.executeStaticQuery(query.toString());
            
            bs = null;

            return resultado;
        } catch(Exception e) {
            UtilidadesLog.error(e);
            if(e instanceof MareException) {
                throw (MareException)e;
            } else {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }

    }*/
    
  //MONRegistroMAVBean
  //Ya no se usa mas este metodo
  //JPB
  /*
  private DTODetalleMAV comprobarCodigoVenta(DTODetalleMAV dto, Long oidPeriodo) throws MareException {
        UtilidadesLog.info("comprobarCodigoVenta(DTODetalleMAV dto, Long oidPeriodo):Entrada");
        
        DTODetalleMAV dtoRetorno = null;
        
        if(dto.getCodigoVenta() == null) {
            DTOEValidarProducto producto = new DTOEValidarProducto();
            producto.setOidIdioma(dto.getOidIdioma());
            producto.setIpCliente(dto.getIpCliente());
            producto.setPrograma(dto.getPrograma());
            producto.setOidPais(dto.getOidPais());
            producto.setPais(dto.getOidPais());
            producto.setMarca(dto.getMarca());
            producto.setCanal(dto.getCanal());

            if((dto.getSubaccesos() != null) && (dto.getSubaccesos().length > 0) && (dto.getSubaccesos()[0] != null)) {
                producto.setOidSubacceso(dto.getSubaccesos()[0]);
            }
            if((dto.getAccesos() != null) && (dto.getAccesos().length > 0) && (dto.getAccesos()[0] != null)) {
                producto.setOidAcceso(dto.getAccesos()[0]);
            }

            producto.setPeriodo(oidPeriodo);
            producto.setPeriodo(dto.getPeriodoFin());
            
            producto.setTipoOferta(dto.getTipoOferta());
            producto.setCicloVida(dto.getCicloVida());
            producto.setFormaPago(dto.getFormaPago());

            producto.setPrecioCatalogo(dto.getPrecio());
            producto.setPrecioContable(dto.getPrecioContable());

            DTOSProductoValidado productoValidado = null;

            try {
                productoValidado = this.validarProductos(producto, dto.getProducto());
            } catch(MareException ne) {
                UtilidadesLog.error(ne);
                throw ne;
            } catch(Exception ex) {
                UtilidadesLog.error(ex);
                LogAPP.error("MAV:Generar Informaci�n MAV: " + ex.getMessage());
                
                String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));          
            }

            MONMantenimientoMFLocalHome monMFHome = null;
            MONMantenimientoMFLocal monMF = null;
            DTOSalida dtoS = null;

            try {
                monMFHome = this.getMONMantenimientoMFLocalHome();
                monMF = monMFHome.create();
                UtilidadesLog.debug("Se encontro MONMantenimientoMFHome");

                DTOBuscarCodigoVentaPeriodo dtoBC = new DTOBuscarCodigoVentaPeriodo();
                dtoBC.setPeriodo(oidPeriodo);
                dtoBC.setCodigoVenta(productoValidado.getCodigoVenta());
                dtoS = monMF.buscarCodigoVentaPeriodo(dtoBC);
            } catch(NamingException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch(CreateException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            //  El RecordSet obtenido de la llamada anterior tiene un �nico registro, con un oid de detalle de oferta
            Long oidMatrizFacturacion = 
                    Long.valueOf(dtoS.getResultado().getValueAt(0, "OID_MATR_FACT").toString());

            dto.setCodigoVenta(oidMatrizFacturacion);
            dtoRetorno = dto;

        }
        UtilidadesLog.info("comprobarCodigoVenta(DTODetalleMAV dto, Long oidPeriodo):Salida");
        return dtoRetorno;
  
  }  */
  
    //MONCargaMantenimientoListasBean
    //Ya no se usa este metodo
    //JPB
    /*
    private DTOSProductoValidado validarProductos(DTOEValidarProducto dto, Long oidProd)
        throws MareException {
        UtilidadesLog.info("validarProductos(DTOEValidarProducto dto):Entrada");
        try {
            MONMantenimientoMFLocalHome mmMFH = this.getMONMantenimientoMFLocalHome();
            MONMantenimientoMFLocal mmMF = mmMFH.create();

            if(oidProd != null) 
            {
                DTOProductoMatriz dtoPM = new DTOProductoMatriz();

                dtoPM.setOidIdioma(dto.getOidIdioma());
                dtoPM.setIpCliente(dto.getIpCliente());
                dtoPM.setPrograma(dto.getPrograma());

                dtoPM.setOidAcceso(dto.getOidAcceso());
                dtoPM.setOidCanal(dto.getCanal());
                dtoPM.setOidCicloVida(dto.getCicloVida());
                dtoPM.setOidFormaPago(dto.getFormaPago());
                dtoPM.setOidMarca(dto.getMarca());
                dtoPM.setOidPais(dto.getPais());
                dtoPM.setOidPeriodo(dto.getPeriodo());
                dtoPM.setOidPeriodoFin(dto.getPeriodoFin());
                dtoPM.setOidSAP(oidProd);
                dtoPM.setOidSubacceso(dto.getOidSubacceso());
                dtoPM.setOidTipoOferta(dto.getTipoOferta());
                dtoPM.setPrecioCatalogo((dto.getPrecioCatalogo()!=null)?new BigDecimal(dto.getPrecioCatalogo().doubleValue()):null);
                dtoPM.setPrecioContable((dto.getPrecioContable()!=null)?new BigDecimal(dto.getPrecioContable().doubleValue()):null);

                DTOProductoMatriz dtoPM1 = new DTOProductoMatriz();

                dtoPM1 = mmMF.buscaProductoEnMatriz(dtoPM);

                if(dtoPM1 != null) 
                {
                    UtilidadesLog.debug(" ---------- Entra al Primer Branch");
                    if((dtoPM1.getOidTipoOferta().longValue() == dto.getTipoOferta().longValue())
                        && (dtoPM1.getOidCicloVida().longValue() == dto.getCicloVida().longValue())) 
                    {
                        Long formaPago = dtoPM1.getOidFormaPago();
                        BigDecimal bigPrecioCatalogo = dtoPM1.getPrecioCatalogo();
                        
                        UtilidadesLog.debug("dto.getFormaPago: " + dto.getFormaPago());
                        UtilidadesLog.debug("dto.getPrecioCatalogo(): " + dto.getPrecioCatalogo().doubleValue());
                        if ( ( (dto.getFormaPago() == null && formaPago == null) ||
                               (formaPago != null &&  dto.getFormaPago() != null && 
                                formaPago.longValue() == dto.getFormaPago().longValue())  
                              ) && 
                              ( bigPrecioCatalogo != null && 
                                (bigPrecioCatalogo.doubleValue() == dto.getPrecioCatalogo().doubleValue())) )
                           {
                                  DTOSProductoValidado dtosPV = new DTOSProductoValidado();
                                  dtosPV.setCodigoVenta(dtoPM1.getCodigoVenta());
                                  dtosPV.setPrecioCatalogo((dtoPM1.getPrecioCatalogo()!=null)?new Double(dtoPM1.getPrecioCatalogo().doubleValue()):null);
                                  UtilidadesLog.info("validarProductos(DTOEValidarProducto dto):Salida");
                                  return dtosPV;
                            } else {
                               
                                 return this.agregarProducto(dto,dtoPM, mmMF ,oidProd);
                            }
                    }
                } else {
                    UtilidadesLog.info("validarProductos(DTOEValidarProducto dto):Salida");
                    
                    return this.agregarProducto(dto,dtoPM, mmMF ,oidProd);
                }
            } else {
                BelcorpService belcorpService = BelcorpService.getInstance();
                LogAPP.info(new String("validarProductos: " + ErroresNegocio.MAV_0002));

                throw new MareException(new Exception(),
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAV, "", ErroresNegocio.MAV_0002));                                                   
            }
        } catch(NamingException Ne) {
            UtilidadesLog.error(Ne);
            ctx.setRollbackOnly();
            throw new MareException(Ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(MareException e) {
            UtilidadesLog.error(e);
            throw e;
        } catch(Exception e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }  */
    
    //MONCargaMantenimientoListasBean
    //Ya no se invoca mas a este metodo
    /*private DTOSProductoValidado agregarProducto(DTOEValidarProducto dto,DTOProductoMatriz dtoPM, MONMantenimientoMFLocal mmMF ,Long oidProd)throws MareException{

        DAOParametrizacionMAV daoPM1 = new DAOParametrizacionMAV();
        
        Long oidEstr1 = new Long(0);
        
        try {
            oidEstr1 = new Long(daoPM1.obtenerEstrategiaParametrizacionMAVPais(dto.getOidPais()).toString());
        } catch(MareException ne) {
          UtilidadesLog.error(ne);
          throw ne;
        } catch(Exception exception) {
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        DTOProductoMatriz dtoPM2 = new DTOProductoMatriz();
        
        dtoPM2.setOidAcceso(dto.getOidAcceso());
        dtoPM2.setOidCanal(dto.getCanal());
        dtoPM2.setOidCicloVida(dto.getCicloVida());
        dtoPM2.setOidEstrategia(oidEstr1);
        dtoPM2.setOidFormaPago(dto.getFormaPago());
        dtoPM2.setOidMarca(dto.getMarca());
        dtoPM2.setOidPais(dto.getOidPais());
        dtoPM2.setOidPeriodo(dto.getPeriodo());
        dtoPM2.setOidPeriodoFin(dto.getPeriodoFin());
        dtoPM2.setOidSAP(oidProd);
        dtoPM2.setOidSubacceso(dto.getOidSubacceso());
        dtoPM2.setOidTipoOferta(dto.getTipoOferta());
        dtoPM2.setPrecioCatalogo((dto.getPrecioCatalogo()!=null)?new BigDecimal(dto.getPrecioCatalogo().doubleValue()):null);
        dtoPM2.setPrecioContable((dto.getPrecioContable()!=null)?new BigDecimal(dto.getPrecioContable().doubleValue()):null);
        dtoPM2.setOidIdioma(dto.getOidIdioma());
        dtoPM2.setIpCliente(dto.getIpCliente());
        dtoPM2.setPrograma(dto.getPrograma());
        
        //insertar prod. en matriz.
        Hashtable hs = null;
        
        try{
            hs = mmMF.insertarProductoEnMatriz(dtoPM2);
        }catch(Exception e) {
            throw new MareException("Excepcion al crear el producto",e);
        }
        Long codigoVenta = null;
        if (hs.contains(dto.getOidPais())){
            codigoVenta = (Long)hs.get(dto.getOidPais());
        }
        DTOSProductoValidado dtosPV2 = new DTOSProductoValidado();
        dtosPV2.setCodigoVenta(codigoVenta);
        dtosPV2.setPrecioCatalogo((dtoPM.getPrecioCatalogo()!=null)?new Double(dtoPM.getPrecioCatalogo().doubleValue()):null);
        
        UtilidadesLog.info("MONCargaMantenimientoListasBean.validarProductos(DTOEValidarProducto dto):Salida");
        return dtosPV2;
        
    }    */
     
    private MONRegistroMAVLocalHome getMONRegistroMAVLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONRegistroMAVLocalHome)context.lookup("java:comp/env/ejb/local/MONRegistroMAV");
    }

    private MONBusinessPlanningLocalHome getMONBusinessPlanningLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONBusinessPlanningLocalHome)context.lookup("java:comp/env/ejb/local/MONBusinessPlanning");
    }


    private MONGenerarSolicitudModulosExternosLocalHome getMONGenerarSolicitudModulosExternosLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONGenerarSolicitudModulosExternosLocalHome)context.lookup("java:comp/env/MONGenerarSolicitudModulosExternos");
    }

    private MONGenerarMensajesLocalHome getMONGenerarMensajesLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONGenerarMensajesLocalHome)context.lookup("java:comp/env/ejb/local/MONGenerarMensajes");
    }
    
    private MONMantenimientoMFLocalHome getMONMantenimientoMFLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONMantenimientoMFLocalHome)context.lookup("java:comp/env/ejb/local/MONMantenimientoMF");
    }
    
    private MONGenerarPosicionSolicitudLocalHome getMONGenerarPosicionSolicitudLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONGenerarPosicionSolicitudLocalHome)context.lookup("java:comp/env/ejb/local/MONGenerarPosicionSolicitud");
    }
    

    private String includeIN(String tabla, Long[] oids) {
        Long[] aux = oids;
        StringBuffer aux2 = new StringBuffer();

        if(aux != null && aux.length > 0) {
            int canti = aux.length - 1;
            int k = 0;  
                aux2.append(tabla + " IN (");

                for(int i = 0; i < canti; i++){
                    aux2.append(aux[i] + ", ");
                    k++;
                    if(k > 997){
                        if((i + 1) < canti){
                            aux2.deleteCharAt(aux2.length()-2);
                            aux2.append(" ) OR " + tabla + " IN ( ");
                            k = 0;
                        }
                    }
                }
                
                aux2.append(aux[canti] + ")");
            
        }
        return aux2.toString();
    }        
    
    private Long bigToLong(Object num) {
        if (num != null) {
            return (new Long((num).toString()));
        } else {
            return null;
        }
    }

    private Integer bigToInt(Object num) {
        if (num != null) {
            return (new Integer((num).toString()));
        } else {
            return null;
        }
    }    
    
    private Double bigToDouble(Object num) {
        if (num != null) {
            return (new Double((num).toString()));
        } else {
            return null;
        }
    }      
    
  private String generaIN(ArrayList oids)   { 
     StringBuffer sClausula = new StringBuffer("");
     
     sClausula.append(" IN ( ");
     for (int i = 0; i < oids.size(); i++)
     {
        Long oid = (Long)oids.get(i);
        
        if (i != 0)
          sClausula.append(", ");
          
        sClausula.append(""+ oid);
     }
     sClausula.append(")");
     return sClausula.toString();
  }   
  
    private StringBuffer generaQueryCodigoVenta (Long periodo, Long producto, Long cicloVida, Long tipoOferta, Long formaPago, Double precioCatalogo, Long acceso, Long subacceso, boolean union) {
        StringBuffer sb = new StringBuffer();
        
        sb.append(" SELECT pre_ofert_detal.val_codi_vent, ");
        sb.append(" pre_ofert_detal.civi_oid_ciclo_vida, ");
        sb.append(" pre_ofert_detal.tofe_oid_tipo_ofer,  ");
        sb.append(" pre_ofert_detal.fopa_oid_form_pago,  ");
        sb.append(" pre_ofert_detal.imp_prec_cata,  ");
        sb.append(" pre_ofert_detal.imp_prec_posi ,pre_ofert_detal.prod_oid_prod, pre_matri_factu.OID_MATR_FACT ");
        sb.append(" FROM pre_ofert_detal, pre_matri_factu  ");
        sb.append(" WHERE pre_ofert_detal.prod_oid_prod = "+producto);
        sb.append(" AND pre_ofert_detal.ind_matr_fact_gene = 1  ");
        if (tipoOferta != null){
            sb.append(" AND pre_ofert_detal.tofe_oid_tipo_ofer = "+tipoOferta);
        }else{
            sb.append(" AND pre_ofert_detal.tofe_oid_tipo_ofer is null ");
        }
        if (cicloVida != null){
            sb.append(" AND pre_ofert_detal.civi_oid_ciclo_vida = "+cicloVida);
        }else{
            sb.append(" AND pre_ofert_detal.civi_oid_ciclo_vida is null ");
        }
        if (formaPago != null){
            sb.append(" AND pre_ofert_detal.fopa_oid_form_pago = "+formaPago);
        }else{
            sb.append(" AND pre_ofert_detal.fopa_oid_form_pago is null ");
        }
        sb.append(" and pre_ofert_detal.OID_DETA_OFER = pre_matri_factu.OFDE_OID_DETA_OFER ");
        sb.append(" and pre_ofert_detal.imp_prec_cata = "+precioCatalogo);
        sb.append(" AND pre_ofert_detal.ofer_oid_ofer IN (SELECT oid_ofer  ");
        sb.append(" FROM pre_ofert  ");
        sb.append(" WHERE mfca_oid_cabe = (SELECT oid_cabe  ");
        sb.append(" FROM pre_matri_factu_cabec  ");
        sb.append(" WHERE perd_oid_peri = "+periodo+" ) ");
        if (acceso!=null){
            sb.append(" AND acce_oid_acce = "+acceso);
        }
        if (subacceso!=null){
            sb.append(" AND sbac_oid_sbac = "+subacceso);
        }
        sb.append(" ) ");
        
        if (union){
            sb.append(" union ");
        }
        return sb;
    }   
    
    private DTODetalleMAV[] existenCodigosVenta (DTOSolicitudValidacion dto1, DTODetalleMAV[] dto2) throws MareException{
        StringBuffer query = new StringBuffer();
        for(int i = 0; i < dto2.length; i++) { 
            DTODetalleMAV dtoDetalleMAV = dto2[i];
            Long subAcceso = null;
            Long acceso = null;
            if((dtoDetalleMAV.getSubaccesos() != null) && (dtoDetalleMAV.getSubaccesos().length > 0) && (dtoDetalleMAV.getSubaccesos()[0] != null)) {
                subAcceso = dtoDetalleMAV.getSubaccesos()[0];
            }
            if((dtoDetalleMAV.getAccesos() != null) && (dtoDetalleMAV.getAccesos().length > 0) && (dtoDetalleMAV.getAccesos()[0] != null)) {
                acceso = dtoDetalleMAV.getAccesos()[0];
            }
            if (i < (dto2.length-1)){
                query.append(generaQueryCodigoVenta(dto1.getOidPeriodo(), dtoDetalleMAV.getProducto(), dtoDetalleMAV.getCicloVida(),
                                                dtoDetalleMAV.getTipoOferta(), dtoDetalleMAV.getFormaPago(), dtoDetalleMAV.getPrecio(),
                                                acceso, subAcceso, true));
            }else{
                query.append(generaQueryCodigoVenta(dto1.getOidPeriodo(), dtoDetalleMAV.getProducto(), dtoDetalleMAV.getCicloVida(),
                                                dtoDetalleMAV.getTipoOferta(), dtoDetalleMAV.getFormaPago(), dtoDetalleMAV.getPrecio(),
                                                acceso, subAcceso, false));
            }
            /*String clave = ""+dtoDetalleMAV.getProducto()+"-"+dtoDetalleMAV.getCicloVida()+"-"+dtoDetalleMAV.getTipoOferta()+"-"
                           +dtoDetalleMAV.getFormaPago()+"-"+dtoDetalleMAV.getPrecio();
            if (!hs.contains(clave)){
                hs.put(clave, dtoDetalleMAV);
                UtilidadesLog.debug("Clave HASH: "+clave);
            }  */          
        }
        RecordSet r = null;
        if (query.length()>0){
            try{
                r = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            }catch (Exception e){
                UtilidadesLog.error("error",e);
                throw new MareException(e);
            }
        }
        
        if ( r!=null &&!r.esVacio() ) {
            for (int i = 0 ; i < r.getRowCount() ; i++){    
                //String sCodigoVenta = r.getValueAt(i,0).toString();
                Long cicloVida = Long.valueOf(r.getValueAt(i,1).toString());
                Long tipoOferta = Long.valueOf(r.getValueAt(i,2).toString()); 
                Long formaPago = null;
                if (r.getValueAt(i,3) != null )  {
                    formaPago = Long.valueOf(r.getValueAt(i,3).toString()); 
                }               
                BigDecimal bigPrecioCatalogo = (BigDecimal)r.getValueAt(i,4);
                //BigDecimal bigPrecioPosicionamiento = (BigDecimal) r.getValueAt(i,5);
                Long producto = Long.valueOf(r.getValueAt(i,6).toString()); 
                Long oidMatri = Long.valueOf(r.getValueAt(i,7).toString()); 
                String clave = ""+producto+"-"+cicloVida+"-"+tipoOferta+"-"+formaPago+"-"+bigPrecioCatalogo.doubleValue();
                UtilidadesLog.debug("Clave Salida: "+clave);
                for (int j = 0 ;  j < dto2.length; j++) { 
                    DTODetalleMAV dtoDetalleMAV = dto2[j];
                    String clave2 = ""+dtoDetalleMAV.getProducto()+"-"+dtoDetalleMAV.getCicloVida()+"-"+dtoDetalleMAV.getTipoOferta()+"-"
                           +dtoDetalleMAV.getFormaPago()+"-"+dtoDetalleMAV.getPrecio().doubleValue();
                    UtilidadesLog.debug("Clave Entrada: "+clave2);
                    if (dtoDetalleMAV.getCodigoVenta() == null && clave.equals(clave2)){
                        dtoDetalleMAV.setCodigoVenta(oidMatri);
                    }                
                }                
            }
        }
        
        ArrayList detallesNoEncontrados = new ArrayList();
        for (int j = 0 ;  j < dto2.length; j++) { 
            DTODetalleMAV dtoDetalleMAV = (DTODetalleMAV)dto2[j];
            if (dtoDetalleMAV.getCodigoVenta() == null){
                detallesNoEncontrados.add(dtoDetalleMAV);
            }
        }
        return (DTODetalleMAV[])detallesNoEncontrados.toArray(new DTODetalleMAV[detallesNoEncontrados.size()]);
    }
    private void comprobarTodosCodigoVenta(DTOSolicitudValidacion dto1, DTODetalleMAV[] dto2) throws MareException{
        UtilidadesLog.info("MONEnvioAgregadosBatch.comprobarTodosCodigoVenta:Entrada");
        UtilidadesLog.debug("Cantidad detalles: "+dto2.length);
        try{
            DTODetalleMAV[] detallesNoEncontrados = existenCodigosVenta(dto1, dto2);
            if (detallesNoEncontrados.length>0){
                UtilidadesLog.debug("Cantidad detalles no encontrados: "+detallesNoEncontrados.length);
                getMONEnvioAgregadosBatchLocalHome().create().insertarProductosMasivos(detallesNoEncontrados, dto1);
            }
        }catch(Exception e){
            UtilidadesLog.error("error",e);
            ctx.setRollbackOnly();
            throw new MareException(e);
        }
        UtilidadesLog.info("MONEnvioAgregadosBatch.comprobarTodosCodigoVenta:Salida");        
    }
    
    public void insertarProductosMasivos (DTODetalleMAV[] detallesNoEncontrados, DTOSolicitudValidacion dto1) throws MareException{    
        UtilidadesLog.info("MONEnvioAgregadosBatch.insertarProductosMasivos:Entrada");
        DAOParametrizacionMAV daoPM1 = new DAOParametrizacionMAV();
        //control
        lockeaTabla();
        detallesNoEncontrados = existenCodigosVenta(dto1, detallesNoEncontrados);        
        
        if (detallesNoEncontrados.length>0){
            UtilidadesLog.debug("Cantidad detalles2 no encontrados: "+detallesNoEncontrados.length);
            MONMantenimientoMFLocal mmf = null;
            
            // sapaza -- PER-SiCC-2010-0606 -- 18/10/2010        
            Long oidEstr1 = null;
            Long oidCatalogo = null;
            Long oidCondicionPromocion = null;

            try {
                Map resultado = daoPM1.obtenerParametrizacionMAVPais(detallesNoEncontrados[0].getOidPais());
                mmf =  getMONMantenimientoMFLocalHome().create();
                
                oidEstr1 = (Long)resultado.get("oidEstrategia");
                
                if(resultado.get("oidCatalogo")!=null)
                    oidCatalogo = (Long)resultado.get("oidCatalogo");
                if(resultado.get("oidCondicionPromocion")!=null)
                    oidCondicionPromocion = (Long)resultado.get("oidCondicionPromocion");
                    
            } catch(MareException ne) {
                UtilidadesLog.error("error",ne);
                ctx.setRollbackOnly();
                throw ne;
            } catch(Exception exception) {
                UtilidadesLog.error("error",exception);
                ctx.setRollbackOnly();
                throw new MareException(exception,
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }        
            
            Hashtable hs1 =  new Hashtable();
            for (int i = 0 ; i < detallesNoEncontrados.length ; i++){
                DTODetalleMAV dto = (DTODetalleMAV) detallesNoEncontrados[i];
                String clave = ""+dto.getProducto()+"-"+dto.getCicloVida()+"-"+dto.getTipoOferta()+"-"
                           +dto.getFormaPago()+"-"+dto.getPrecio();
                if (!hs1.contains(clave)){                
                    DTOProductoMatriz dtoPM2 = new DTOProductoMatriz();
                    Long subAcceso = null;
                    Long acceso = null;
                    if((dto.getSubaccesos() != null) && (dto.getSubaccesos().length > 0) && (dto.getSubaccesos()[0] != null)) {
                        subAcceso = dto.getSubaccesos()[0];
                    }
                    if((dto.getAccesos() != null) && (dto.getAccesos().length > 0) && (dto.getAccesos()[0] != null)) {
                        acceso = dto.getAccesos()[0];
                    }
                    dtoPM2.setOidAcceso(acceso);
                    dtoPM2.setOidCanal(dto.getCanal());
                    dtoPM2.setOidCicloVida(dto.getCicloVida());
                    dtoPM2.setOidEstrategia(oidEstr1);
                    dtoPM2.setOidFormaPago(dto.getFormaPago());
                    dtoPM2.setOidMarca(dto.getMarca());
                    dtoPM2.setOidPais(dto.getOidPais());
                    dtoPM2.setOidPeriodo(dto.getPeriodo());
                    dtoPM2.setOidPeriodoFin(dto.getPeriodoFin());
                    dtoPM2.setOidSAP(dto.getProducto());
                    dtoPM2.setOidSubacceso(subAcceso);
                    dtoPM2.setOidTipoOferta(dto.getTipoOferta());
                    dtoPM2.setPrecioCatalogo((dto.getPrecio()!=null)?new BigDecimal(dto.getPrecio().doubleValue()):null);
                    dtoPM2.setPrecioContable((dto.getPrecioContable()!=null)?new BigDecimal(dto.getPrecioContable().doubleValue()):null);
                    dtoPM2.setOidIdioma(dto.getOidIdioma());
                    dtoPM2.setIpCliente(dto.getIpCliente());
                    dtoPM2.setPrograma(dto.getPrograma());
                    
                    // sapaza -- PER-SiCC-2010-0606 -- 18/10/2010
                    dtoPM2.setOidCatalogo(oidCatalogo);
                    dtoPM2.setOidCondicionPromocion(oidCondicionPromocion);
                    
                    //insertar prod. en matriz.
                    Hashtable hs = null;
                    
                    try{
                        hs = mmf.insertarProductoEnMatrizAgregados(dtoPM2);
                    }catch(Exception e) {
                        UtilidadesLog.error("error",e);
                        ctx.setRollbackOnly();
                        throw new MareException("Excepcion al crear el producto",e);
                    }
                    if (hs.get(dto.getPeriodo())!=null){
                        dto.setCodigoVenta((Long)hs.get(dto.getPeriodo()));
                    }
                    hs1.put(clave, (Long)hs.get(dto.getPeriodo()));
                    UtilidadesLog.debug("Clave HASH: "+clave);
                }else{
                    dto.setCodigoVenta((Long)hs1.get(clave));
                }
            }
        }
        liberaTabla();
        UtilidadesLog.info("MONEnvioAgregadosBatch.insertarProductosMasivos:Salida");
    }

    private MONEnvioAgregadosBatchLocalHome getMONEnvioAgregadosBatchLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONEnvioAgregadosBatchLocalHome)context.lookup("java:comp/env/ejb/local/MONEnvioAgregadosBatch");
    }
    
    private void lockeaTabla(){
        try{
            StringBuffer queryFinal = new StringBuffer();
            queryFinal.append("SELECT OID_CONT_CORR_STOC FROM BEL_CONTR_CORRE_STOCK WHERE OID_CONT_CORR_STOC = 1 FOR UPDATE");
            this.executeQuery(queryFinal.toString());
        } catch ( Exception e ) {
            UtilidadesLog.error("ERROR",e);
        }       
    }
    
    private void liberaTabla(){
        try{
            StringBuffer queryFinal = new StringBuffer();
            queryFinal.append("UPDATE BEL_CONTR_CORRE_STOCK SET FEC_ULTI_STOC = SYSDATE WHERE OID_CONT_CORR_STOC = 1");
            BelcorpService belcorpService = BelcorpService.getInstance();
            int cant = belcorpService.dbService.executeUpdate( queryFinal.toString() );
            if (cant == 0){
                queryFinal = new StringBuffer("INSERT INTO BEL_CONTR_CORRE_STOCK ( OID_CONT_CORR_STOC, FEC_ULTI_STOC ) VALUES ( 1, SYSDATE) ");
                belcorpService.dbService.executeUpdate( queryFinal.toString() );
            }
        } catch ( Exception e ) {
            UtilidadesLog.error("ERROR",e);
        }       
    }
    
    private RecordSet executeQuery(String query) throws MareException {
        RecordSet rs = null;
        try {
            BelcorpService belcorpService = BelcorpService.getInstance();
            rs = belcorpService.dbService.executeStaticQuery( query );
        } catch ( Exception ex ) {
            throw new MareException( ex, 
                  UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
        }       
        return rs;
    }
    
    private MONGestionMensajesLocalHome getMONGestionMensajesLocalHome() throws NamingException{
        final InitialContext context = new InitialContext();
        return (MONGestionMensajesLocalHome)context.lookup("java:comp/env/ejb/local/MONGestionMensajes");
    }
}