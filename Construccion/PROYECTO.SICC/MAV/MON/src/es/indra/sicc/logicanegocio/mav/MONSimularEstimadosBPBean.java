package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.dtos.mav.DTOCampaniaEstimadosBP;
import es.indra.sicc.dtos.mav.DTODetalleCampaniaEstimadosBP;
import es.indra.sicc.dtos.mav.DTODetalleMAV;
import es.indra.sicc.dtos.mav.DTOProcesoDetalleMAV;
import es.indra.sicc.entidades.bel.EstadosMercanciaLocal;
import es.indra.sicc.entidades.bel.EstadosMercanciaLocalHome;
import es.indra.sicc.entidades.bel.StockLocal;
import es.indra.sicc.entidades.bel.StockLocalHome;
import es.indra.sicc.entidades.mae.MaestroProductosLocal;
import es.indra.sicc.entidades.mae.MaestroProductosLocalHome;
import es.indra.sicc.entidades.mae.MaestroProductosPK;
import es.indra.sicc.entidades.mav.SubcriterioAsignacionLocal;
import es.indra.sicc.entidades.mav.SubcriterioAsignacionLocalHome;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.entidades.mav.DetalleMAVLocalHome;
import es.indra.sicc.entidades.mav.DetalleMAVLocal;
import es.indra.sicc.entidades.mav.SubtipoClienteDetalleMAVLocalHome;

import es.indra.sicc.util.UtilidadesLog;
import java.rmi.RemoteException;

import java.util.ArrayList;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;

import javax.persistence.PersistenceException;

import javax.rmi.PortableRemoteObject;


public class MONSimularEstimadosBPBean implements SessionBean {
    SessionContext ctx = null;

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    public void ejbCreate() {}

    public void ejbActivate() {}

    public void ejbPassivate() {}

    public void ejbRemove() {}

    public DTOSalida cargarCampaniasSimularEstimadosBP(DTOSiccPaginacion dto)
        throws MareException {
        /** MONSimularEstimadosBP.cargarCampañasSimularEstimadosBP(dto : DTOBelcorp) : DTOSalida  
Entrada: 
- dto : DTOBelcorp 
Proceso: 
-> Llamar al método "DAODetallesMAV.cargarCampañasSimularEstimadosBP(dto : DTOBelcorp) : DTOSalida" pasando el dto de entrada 
-> Devolver objeto DTOSalida obtenido en llamada anterior
*/
        UtilidadesLog.info("MONSimularEstimadosBPBean.cargarCampaniasSimularEstimadosBP(DTOSiccPaginacion dto):Entrada");
        UtilidadesLog.debug("parametros ");
        UtilidadesLog.debug("dto " + dto);
        DAODetalleMAV daoDetalle = new DAODetalleMAV();
        DTOSalida salida = new DTOSalida();

        try {
            salida = daoDetalle.cargarCampaniasSimularEstimadosBP(dto);
            UtilidadesLog.debug("salida " + salida);
            UtilidadesLog.debug("-------------sale cargarCampaniasSimularEstimadosBP -----------------------------------");
        } catch(MareException ne) {
            UtilidadesLog.error(ne);
            throw ne;
        } catch(Exception ne) {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONSimularEstimadosBPBean.cargarCampaniasSimularEstimadosBP(DTOSiccPaginacion dto):Salida");
        return salida;
    }

    public DTOSalida cargarDetalleSimularEstimadosBP(DTOCampaniaEstimadosBP dto)
        throws MareException {
        /** MONSimularEstimadosBP.cargarDetalleSimularEstimadosBP(dto : DTOCampañaEstimadosBP) : DTOSalida 
Entrada: 
- dto : DTOCampañaEstimadosBP 
Proceso: 
-> Llamar al método "DAODetallesMAV.cargarDetalleSimularEstimadosBP(dto : DTOCampañaEstimadosBP) : DTOSalida" pasando como parámetro el dto de entrada 
-> Devolver el objeto DTOSalida obtenido en la llamada anterior
*/
        UtilidadesLog.info("MONSimularEstimadosBPBean.cargarDetalleSimularEstimadosBP(DTOCampaniaEstimadosBP dto):Entrada");
        DAODetalleMAV daoDetalle = new DAODetalleMAV();
        DTOSalida salida = new DTOSalida();

        try {
            UtilidadesLog.debug("parametros ");
            UtilidadesLog.debug("dto " + dto);
            salida = daoDetalle.cargarDetalleSimularEstimadosBP(dto);
            UtilidadesLog.debug("salida " + salida);
            UtilidadesLog.debug("-------------sale cargarDetalleSimularEstimadosBP -----------------------------------");
        } catch(MareException ne) {
            UtilidadesLog.error(ne);
            throw ne;
        } catch(Exception ne) {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONSimularEstimadosBPBean.cargarDetalleSimularEstimadosBP(DTOCampaniaEstimadosBP dto):Salida");
        return salida;
    }

    public DTODetalleCampaniaEstimadosBP cargarFormularioRecalculo(DTOOID dto)
        throws MareException {
        /*
Entrada: 
- dto : DTOOID 
Proceso: 
-> Crear variable llamada detalleMAV de tipo DTODetalleMAV 
-> Llamar al método "MONBusinessPlanning.obtieneDetalleMAV(dto : DTOOID) : DTODetalleMAV" pasando el dto de entrada 
-> detalleMAV = respuesta a la llamada anterior 
-> Crear variable llamada registroRespuesta de tipo DTODetalleCampañaEstimadosBP 
-> Hacer el siguiente mapeo: 
-> registroRespuesta.oidDetalleMAV = detalleMAV.oid 
-> Hacer findByPrimaryKey sobre la entidad MaestroProductos usando detalleMAV.producto 
-> registroRespuesta.codigoSAP = MaestroProductos.codigoSAP 
-> Hacer findByPrimaryKey sobre la entidad MatrizFacturacion usando detalleMAV.codigoVenta 
-> registroRespuesta.codigoVenta = MatrizFacturacion.oidDetalleOferta 
-> registroRespuesta.descripcionProducto = descripcionInternacionalizada del MaestroProductos hallado 
-> registroRespuesta.subtiposCliente = detalleMAV.subtiposCliente 
-> registroRespuesta.tipoClasificacion = detalleMAV.tipoClasificacion 
-> registroRespuesta.clasificacion = detalleMAV.clasificacion 
-> registroRespuesta.numeroClientesEstimados = detalleMAV.baseEstimadosDestinatarios 
-> registroRespuesta.unidadesPromedio = detalleMAV.unidadesPorCliente 
-> registroRespuesta.unidadesTotales = detalleMAV.unidadesTotales 
-> Llamar al método "MONSimularEstimadosBP.consultarUnidadesDisponibles(pais : Long, producto : Long) : Long" pasando como parámetros detalleMAV.pais y detalleMAV.producto 
-> registroRespuesta.unidadesDisponibles = respuesta a llamada anterior 
(1)Si (detalleMAV.listaClientes <> null) entonces 
-> registroRespuesta.condicion = "Lista de Clientes" 
(1)Si no entonces 
-> Hacer findByPrimaryKey sobre la entidad SubcriterioAsignacion con detalleMAV.subcriterio 
-> registroRespuesta.condicion = SubcriterioAsignacion.descripcion 
(1)Fin Si 
-> registroRespuesta.valorCondicion

*/
        UtilidadesLog.info("MONSimularEstimadosBPBean.cargarFormularioRecalculo(DTOOID dto):Entrada");
        UtilidadesLog.debug("parametros ");
        UtilidadesLog.debug("dto " + dto);

        DTODetalleMAV detalleMAV = new DTODetalleMAV();
        MONBusinessPlanningHome businessPlanningH = getMONBusinessPlanningHome();
        MONBusinessPlanning businessPlanningL = null;

        try {
            businessPlanningL = businessPlanningH.create();
            detalleMAV = businessPlanningL.obtieneDetalleMAV(dto);
            UtilidadesLog.debug("Finalizo obtencion de DetalleMAV");
        } catch(RemoteException ne) {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException ne) {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        DTODetalleCampaniaEstimadosBP registroRespuesta = new DTODetalleCampaniaEstimadosBP();

        try {
            UtilidadesLog.debug("Obtiene Cod. Sap de producto");
            registroRespuesta.setOidDetalleMAV(detalleMAV.getOid());
            MaestroProductosLocalHome maestroProductoLH = getMaestroProductosLocalHome();
            MaestroProductosPK clave = new MaestroProductosPK(detalleMAV.getProducto());
            MaestroProductosLocal maestroProductoL = maestroProductoLH.findByPrimaryKey(clave);
            registroRespuesta.setCodigoSAP(maestroProductoL.getCodigoSAP());
            UtilidadesLog.debug("Finaliza obtencion de Codigo SAP");
            
            // Codigo comentado por ssantana, 3/8/2005, inc. BELC300015618
            /*MatrizFacturacionLocalHome matrizFacturacionLH = getMatrizFacturacionLocalHome();
            MatrizFacturacionLocal matrizFacturacionL = matrizFacturacionLH.findByPrimaryKey(detalleMAV.getCodigoVenta());
            DetalleOfertaLocalHome detaoferLH = getDetalleOfertaLocalHome();
            DetalleOfertaLocal detaoferL = detaoferLH.findByPrimaryKey(matrizFacturacionL.getOidDetaOfer());
            registroRespuesta.setCodigoVenta(detaoferL.getCodigoVenta());*/
            // Fin Codigo comentado por ssantana, 3/8/2005, inc. BELC300015618
            Entidadi18nLocalHome i18nLH = new Entidadi18nLocalHome();
            Entidadi18nLocal i18nL = i18nLH.findByEntAtrIdioPK("MAE_PRODU", new Long(1), dto.getOidIdioma(), maestroProductoL.getOid());
            registroRespuesta.setDescripcionProducto(i18nL.getDetalle());
            Long[] subtipoCliente = detalleMAV.getSubtiposCliente();
            ArrayList subtipoCli = new ArrayList();
            
            // Agregado by ssantana, 16/9/2005, se contempla que Subtipo Cliente puede
            // ser null.
            if ( subtipoCliente != null ) {
              for(int i = 0; i < subtipoCliente.length; i++) {
                  subtipoCli.add(subtipoCliente[i]);
              }
            }
            // Fin Agregado by ssantana, 16/9/2005

            UtilidadesLog.debug("1");
            registroRespuesta.setSubtiposCliente(subtipoCli);
            UtilidadesLog.debug("2");            
            registroRespuesta.setTipoClasificacion(detalleMAV.getTipoClasificacion());
            UtilidadesLog.debug("3");            
            registroRespuesta.setClasificacion(detalleMAV.getClasificacion());
            UtilidadesLog.debug("4");
            registroRespuesta.setNumeroClientesEstimados(detalleMAV.getBaseEstimadosDestinatarios());
            // incidencia 8646
            if ( detalleMAV.getUnidadesPorCliente()!= null) 
              registroRespuesta.setUnidadesPromedio(new Long(detalleMAV.getUnidadesPorCliente().toString()));
            // incidencia 8646
            UtilidadesLog.debug("5");
            if ( detalleMAV.getUnidadesTotales() != null )
              registroRespuesta.setUnidadesTotales(new Long(detalleMAV.getUnidadesTotales().toString()));
            UtilidadesLog.debug("6");  
            registroRespuesta.setUnidadesDisponibles(consultarUnidadesDisponibles(detalleMAV.getOidPais(), detalleMAV.getProducto()));

            UtilidadesLog.debug("7");
            if(detalleMAV.getListaClientes() != null)
            {
                UtilidadesLog.debug("8");
                registroRespuesta.setCondicion("Lista de Clientes");
            } else {
                UtilidadesLog.debug("9");
                SubcriterioAsignacionLocalHome subcriterioAsignacionLH = new SubcriterioAsignacionLocalHome();
                SubcriterioAsignacionLocal subcriterioAsignacionL = subcriterioAsignacionLH.findByPrimaryKey(detalleMAV.getSubcriterio());
                registroRespuesta.setCondicion(subcriterioAsignacionL.getDescripcion());
            }
            UtilidadesLog.debug("10");
            if(detalleMAV.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_EDAD.longValue()) {
                UtilidadesLog.debug("11");
                registroRespuesta.setValorCondicion(detalleMAV.getEdadDesde().toString() + " a " + detalleMAV.getEdadHasta());
            } else {
                UtilidadesLog.debug("12");
                if(detalleMAV.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_ANIVERSARIO.longValue()) {
                    UtilidadesLog.debug("13");
                    registroRespuesta.setValorCondicion(detalleMAV.getNumeroAniversario().toString());
                } else {
                    UtilidadesLog.debug("14");
                    if((detalleMAV.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_PED_SUP_MONTO.longValue())
                        || (detalleMAV.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_PED_SUP_MONTO_MARCA.longValue())
                        || (detalleMAV.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_PED_SUP_MONTO_U_NEGOCIO.longValue())
                        || (detalleMAV.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_PED_SUP_MONTO_NEGOCIO.longValue())
                        || (detalleMAV.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_PED_SUP_MONTO_CATALOGO.longValue())) { 
                          UtilidadesLog.debug("15");
                          registroRespuesta.setValorCondicion(detalleMAV.getMonto().toString());
                   } else {
                        UtilidadesLog.debug("16");
                        registroRespuesta.setValorCondicion(null);
                   }
                }
            }
        } catch(NoResultException ne) {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }catch(FinderException ne) {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.debug("--SALE cargarFormularioRecalculo----------------------------------------------");
        UtilidadesLog.debug("registroRespuesta" + registroRespuesta);
        UtilidadesLog.info("MONSimularEstimadosBPBean.cargarFormularioRecalculo(DTOOID dto):Salida");
        return registroRespuesta;
    }

    public DTODetalleCampaniaEstimadosBP recalcularDetalleCampaniaEstimadosBP(DTODetalleCampaniaEstimadosBP dto)
        throws MareException {
        /*
* MONSimularEstimadosBP.recalcularDetalleCampañaEstimadosBP(dto : DTODetalleCampañaEstimadosBP) : DTODetalleCampañaEstimadosBP 
Entrada: 
- dto : DTODetalleCampañaEstimadosBP 
Proceso: 
-> Llamar al método "MONBusinessPlannig.obtenerDetalleMAV(dto : DTOOID) : DetalleMAV 
-> Tomar DTODetalleMAV de respuesta y sustituir en él los atributos del dto de entrada 
-> Tomar el DTODetalleMAV modificado, periodo a null, actividad a null y simulacion = True para la llamada siguiente 
-> Llamar al método "MONRegistrosMAV.procesarLineaDetalleMAV(dto : DTODetalleMAV, periodo : Long, actividad : Long, simulacion : Boolean) : DTOProcesoDetalleMAV" 
-> Mapear DTOProcesoDetalleMAV como sigue: 
-> Crear variable registroRespuesta de tipo DTODetalleCampañaEstimadosBP 
-> Hacer el siguiente mapeo: 
-> registroRespuesta.oidDetalleMAV = detalleMAV.oid 
-> Hacer findByPrimaryKey sobre la entidad MaestroProductos usando detalleMAV.producto 
-> registroRespuesta.codigoSAP = MaestroProductos.codigoSAP 
-> Hacer findByPrimaryKey sobre la entidad MatrizFacturacion usando detalleMAV.codigoVenta 
-> registroRespuesta.codigoVenta = MatrizFacturacion.oidDetalleOferta 
-> registroRespuesta.descripcionProducto = descripcionInternacionalizada del MaestroProductos hallado 
-> registroRespuesta.subtiposCliente = detalleMAV.subtiposCliente 
-> registroRespuesta.tipoClasificacion = detalleMAV.tipoClasificacion 
-> registroRespuesta.clasificacion = detalleMAV.clasificacion 
-> registroRespuesta.numeroClientesEstimados = detalleMAV.baseEstimadosDestinatarios 
-> registroRespuesta.unidadesPromedio = detalleMAV.unidadesPorCliente 
-> registroRespuesta.unidadesTotales = detalleMAV.unidadesTotales 
-> Llamar al método "MONSimularEstimadosBP.consultarUnidadesDisponibles(pais : Long, producto : Long) : Long" pasando como parámetros detalleMAV.pais y detalleMAV.producto 
-> registroRespuesta.unidadesDisponibles = respuesta a llamada anterior 
(1)Si (detalleMAV.listaClientes <> null) entonces 
-> registroRespuesta.condicion = "Lista de Clientes" 
(1)Si no entonces 
-> Hacer findByPrimaryKey sobre la entidad SubcriterioAsignacion con detalleMAV.subcriterio 
-> registroRespuesta.condicion = SubcriterioAsignacion.descripcion 
(1)Fin Si 
-> Devolver registroRespuesta 

*/
        
        UtilidadesLog.info("MONSimularEstimadosBPBean.recalcularDetalleCampaniaEstimadosBP(DTODetalleCampaniaEstimadosBP dto):Entrada");
        UtilidadesLog.debug("parametros ");
        UtilidadesLog.debug("dto " + dto);
        DTODetalleMAV detalleMav = new DTODetalleMAV();
        DTOProcesoDetalleMAV ProcesoDetalle = null;
        DTODetalleCampaniaEstimadosBP registroRespuesta = new DTODetalleCampaniaEstimadosBP();

        try {
            DTOOID dtooid = new DTOOID();
            dtooid.setOidIdioma(dto.getOidIdioma());
            dtooid.setOidPais(dto.getOidPais());
            dtooid.setOid(dto.getOidDetalleMAV());
            MONBusinessPlanningHome monBusinessPlanningH = getMONBusinessPlanningHome();
            MONBusinessPlanning monBusinessPlanningL = monBusinessPlanningH.create();
            detalleMav = monBusinessPlanningL.obtieneDetalleMAV(dtooid);
            detalleMav.setClasificacion(dto.getClasificacion());
            //Inc. 9299
            //detalleMav.setCodigoVenta(new Long(dto.getCodigoVenta()));
            detalleMav.setOid(dto.getOidDetalleMAV());
            detalleMav.setOidIdioma(dto.getOidIdioma());
            detalleMav.setOidPais(dto.getOidPais());
            detalleMav.setIpCliente(dto.getIpCliente());
            Object[] arr = (dto.getSubtiposCliente() != null) ? dto.getSubtiposCliente().toArray() : null;
            Long[] tip = null;

            if(arr != null) {
                tip = new Long[arr.length];

                for(int i = 0; i < arr.length; i++)
                    tip[i] = (Long)arr[i];
            } else
                tip = null;

            detalleMav.setSubtiposCliente(tip);
            detalleMav.setTipoClasificacion(dto.getTipoClasificacion());
            
            // Agregado por ssantana, inc. 18074
            // Chequea que dto.getUnidadesTotales pueda ser null. 
            if ( dto.getUnidadesTotales() != null)
              detalleMav.setUnidadesTotales(new Integer(dto.getUnidadesTotales().intValue()));
            else
              detalleMav.setUnidadesTotales(null);
              
              
            if ( dto.getUnidadesPromedio() != null )
              detalleMav.setUnidadesPorCliente(new Integer(dto.getUnidadesPromedio().intValue()));
            else
              detalleMav.setUnidadesPorCliente(null);
            // Fin agregado ssantana, inc. 18074
            
            MONRegistroMAVHome registromavH = getMONRegistroMAVHome();
            MONRegistroMAV registromav = registromavH.create();
            
            // Modificado por ssantana, inc. 18074 25/7/2005 - Periodo se necesita para poder
            //   filtrar en la query de Subcriterios de Asignacion. 
            //ProcesoDetalle = registromav.procesarLineaDetalleMAV(detalleMav, null, null, new Boolean(true));
            ProcesoDetalle = registromav.procesarLineaDetalleMAV(detalleMav, detalleMav.getPeriodo(), null, Boolean.valueOf(true));
            // Fin Modificacion por ssantana, inc. 18074 25/7/2005
            registroRespuesta.setOidDetalleMAV(detalleMav.getOid());
            MaestroProductosLocalHome maestroprodLH = getMaestroProductosLocalHome();
            MaestroProductosPK maestro = new MaestroProductosPK(detalleMav.getProducto());
            MaestroProductosLocal maestroprodL = maestroprodLH.findByPrimaryKey(maestro);
            registroRespuesta.setCodigoSAP(maestroprodL.getCodigoSAP());

            //Inc. 9299
            // Codigo comentado por ssantana, 3/8/2005, inc. BELC300015618
            /*MatrizFacturacionLocalHome matriFactuLH = getMatrizFacturacionLocalHome();
            MatrizFacturacionLocal matrifactuL = matriFactuLH.findByPrimaryKey(detalleMav.getCodigoVenta());
            DetalleOfertaLocalHome detaoferLH = getDetalleOfertaLocalHome();
            DetalleOfertaLocal detaoferL = detaoferLH.findByPrimaryKey(matrifactuL.getOidDetaOfer());
            registroRespuesta.setCodigoVenta(detaoferL.getCodigoVenta());*/
            // Fin codigo comentado por ssantana, 3/8/2005, inc. BELC300015618

            Entidadi18nLocalHome i18nLH = new Entidadi18nLocalHome();
            Entidadi18nLocal i18nL = i18nLH.findByEntAtrIdioPK("MAE_PRODU", new Long(1), dto.getOidIdioma(), maestroprodL.getOid());
            registroRespuesta.setDescripcionProducto(i18nL.getDetalle());
            ArrayList arrList = new ArrayList();

            if(detalleMav.getSubtiposCliente() != null) {
                Long[] datos = detalleMav.getSubtiposCliente();

                for(int j = 0; j < datos.length; j++)
                    arrList.add(datos[j]);
            }

            registroRespuesta.setSubtiposCliente(arrList);
            registroRespuesta.setTipoClasificacion(detalleMav.getTipoClasificacion());
            registroRespuesta.setClasificacion(detalleMav.getClasificacion());
            registroRespuesta.setNumeroClientesEstimados(ProcesoDetalle.getNumeroClientes());
            // incidencia 8778
            registroRespuesta.setUnidadesPromedio(new Long((ProcesoDetalle.getNumeroClientes().longValue() != 0L)
                    ? (ProcesoDetalle.getNumeroUnidadesEnviadas().longValue() / ProcesoDetalle.getNumeroClientes().longValue()) : 0));
            registroRespuesta.setUnidadesTotales(ProcesoDetalle.getNumeroUnidadesEnviadas());
            registroRespuesta.setUnidadesDisponibles(consultarUnidadesDisponibles(detalleMav.getOidPais(), detalleMav.getProducto()));

            if(detalleMav.getListaClientes() != null)
                registroRespuesta.setCondicion("Lista de Clientes");
            else {
                SubcriterioAsignacionLocalHome subcriterioAsignacionLH = new SubcriterioAsignacionLocalHome();
                SubcriterioAsignacionLocal subcriterioAsignacionL = subcriterioAsignacionLH.findByPrimaryKey(detalleMav.getSubcriterio());
                registroRespuesta.setCondicion(subcriterioAsignacionL.getDescripcion());
            }

            if(detalleMav.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_EDAD.longValue())
                registroRespuesta.setValorCondicion(detalleMav.getEdadDesde().toString() + " a " + detalleMav.getEdadHasta());
            else {
                if(detalleMav.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_ANIVERSARIO.longValue())
                    registroRespuesta.setValorCondicion(detalleMav.getNumeroAniversario().toString());
                else {
                    if((detalleMav.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_PED_SUP_MONTO.longValue())
                        || (detalleMav.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_PED_SUP_MONTO_MARCA.longValue())
                        || (detalleMav.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_PED_SUP_MONTO_U_NEGOCIO.longValue())
                        || (detalleMav.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_PED_SUP_MONTO_NEGOCIO.longValue())
                        || (detalleMav.getSubcriterio().longValue() == ConstantesMAV.SUBCRI_PED_SUP_MONTO_CATALOGO.longValue()))
                        registroRespuesta.setValorCondicion(detalleMav.getMonto().toString());
                    else
                        registroRespuesta.setValorCondicion(null);
                }
            }
        } catch(NoResultException ne) {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        } catch(FinderException ne) {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        } catch(RemoteException ne) {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException ne) {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONSimularEstimadosBPBean.recalcularDetalleCampaniaEstimadosBP(DTODetalleCampaniaEstimadosBP dto):Salida");
        return registroRespuesta;
    }

    public Long consultarUnidadesDisponibles(Long pais, Long producto)
        throws MareException {
        /*
Entrada: 
- pais : Long 
- producto : Long 
Proceso: 
-> Crear variable llamada "almacen" de tipo Long 
-> Llamar al método "MONGenerarMensajes.obtenerAlmacen(pais : Long) : Long" 
-> almacen = respuesta a llamada anterior 
-> Hacer "findByUK(pais : Long, codigoEstado : String)" sobre la entidad "EstadosMercancia", pasando el pais de entrada y la constante "ConstantesBEL.COD_EST_LIBRE_DISP" respectivamente como parámetros 
-> Crear variable llamada "oidEstadoMercancia" de tipo Long 
-> oidEstadoMercancia <= EstadosMercancia.oid 
// Hallamos el registro de Stock 
-> Hacer "findByClaveUnica(almacen : Long, estado : Long, producto : Long)" sobre la entidad "Stock" pasando almacen, oidEstadoMercancia y producto respectivamente como parámetros 
-> Devolver el valor de Stock.saldo
*/
        UtilidadesLog.info("MONSimularEstimadosBPBean.consultarUnidadesDisponibles(Long pais, Long producto):Entrada");
        Long almacen = null;
        Long oidEstadoMercancia = null;

        try {
            MONGenerarMensajesHome monGenerarMensajesH = getMONGenerarMensajesHome();
            MONGenerarMensajes GenerarMensajes = monGenerarMensajesH.create();
            almacen = GenerarMensajes.obtenerAlmacen(pais);
        } catch(RemoteException ne) {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException ne) {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        EstadosMercanciaLocal estadoMercanciaL = null;

        try {
            EstadosMercanciaLocalHome estadoMercanciaLH = new EstadosMercanciaLocalHome();
            estadoMercanciaL = estadoMercanciaLH.findByUK(pais, ConstantesBEL.COD_EST_LIBRE_DISP);
        } catch(NoResultException ne) {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        oidEstadoMercancia = estadoMercanciaL.getOid();
        StockLocal stockL = null;

        try {
            StockLocalHome stockLH = new StockLocalHome();
            UtilidadesLog.debug("almacen,oidEstadoMercancia, producto " + almacen + ", " + oidEstadoMercancia + ", " + producto);
            stockL = stockLH.findByClaveUnica(almacen, oidEstadoMercancia, producto);
        } catch(NoResultException ne) {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONSimularEstimadosBPBean.consultarUnidadesDisponibles(Long pais, Long producto):Salida");
        return stockL.getSaldo();
    }

    private MONBusinessPlanningHome getMONBusinessPlanningHome()
        throws MareException {
        try {
            final InitialContext context = new InitialContext();
            return (MONBusinessPlanningHome)PortableRemoteObject.narrow(context.lookup("MONBusinessPlanning"),
                MONBusinessPlanningHome.class);
        } catch(NamingException ne) {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }

    private MONGenerarMensajesHome getMONGenerarMensajesHome()
        throws MareException {
        try {
            final InitialContext context = new InitialContext();
            return (MONGenerarMensajesHome)PortableRemoteObject.narrow(context.lookup("MONGenerarMensajes"),
                MONGenerarMensajesHome.class);
        } catch(NamingException ne) {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }

    private MaestroProductosLocalHome getMaestroProductosLocalHome()
        throws MareException {
        try {
            final InitialContext context = new InitialContext();
            return (MaestroProductosLocalHome)context.lookup("java:comp/env/MaestroProductos");
        } catch(NamingException ne) {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }


    private MONRegistroMAVHome getMONRegistroMAVHome() throws MareException {
        try {
            final InitialContext context = new InitialContext();
            return (MONRegistroMAVHome)PortableRemoteObject.narrow(context.lookup("MONRegistroMAV"), MONRegistroMAVHome.class);
        } catch(NamingException ne) {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }


    public void actualizarDetalleCampaniaEstimadosBP(DTODetalleCampaniaEstimadosBP dto) throws MareException
    {
        UtilidadesLog.info("MONSimularEstimadosBPBean.actualizarDetalleCampaniaEstimadosBP(DTODetalleCampaniaEstimadosBP dto):Entrada");
        UtilidadesLog.debug("parametros ");
        UtilidadesLog.debug("dto " + dto);
        //DTODetalleMAV detalleMav = new DTODetalleMAV();
        //DTOProcesoDetalleMAV ProcesoDetalle = null;
  
        try {
            Object[] arr = (dto.getSubtiposCliente() != null) ? dto.getSubtiposCliente().toArray() : null;
            Long[] subtiposCliente = null;
  
            if(arr != null) {
                subtiposCliente = new Long[arr.length];
  
                for(int i = 0; i < arr.length; i++)
                    subtiposCliente[i] = (Long)arr[i];
            } else
                subtiposCliente = null;
  
            Long unidadesTotales = null;
            Long unidadesPromedio = null;
  
            if ( dto.getUnidadesTotales() != null)
              unidadesTotales = new Long(dto.getUnidadesTotales().intValue());
              
            if ( dto.getUnidadesPromedio() != null )
              unidadesPromedio = new Long(dto.getUnidadesPromedio().intValue());
  
            DetalleMAVLocalHome detalleMAVLocalH = this.getDetalleMAVLocalHome();
            DetalleMAVLocal detalleMAVLocal = detalleMAVLocalH.findByPrimaryKey(dto.getOidDetalleMAV());
            detalleMAVLocal.setOidTipoClasificacion(dto.getTipoClasificacion());
            detalleMAVLocal.setOidClasificacion(dto.getClasificacion());
            detalleMAVLocal.setUnidadesPorCliente(unidadesPromedio);
            detalleMAVLocal.setUnidadesTotales(unidadesTotales);
  
            this.eliminaSubtipoClienteMAV(dto.getOidDetalleMAV());
            if (subtiposCliente != null) {
              this.insertaTipoClienteMAV(dto.getOidDetalleMAV(), subtiposCliente);
            }  
              
        } catch(FinderException fEx) {
            UtilidadesLog.debug("Finder Exception en findByPrimaryKey() de DetalleMAVLocal");
            UtilidadesLog.error(fEx);
            throw new MareException(fEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
  
        UtilidadesLog.info("MONSimularEstimadosBPBean.actualizarDetalleCampaniaEstimadosBP(DTODetalleCampaniaEstimadosBP dto):Salida");
    }
 
    private DetalleMAVLocalHome getDetalleMAVLocalHome() throws MareException {
        try {
            final InitialContext context = new InitialContext();
            return (DetalleMAVLocalHome)context.lookup("java:comp/env/DetalleMAV");
        } catch(NamingException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }

    private void insertaTipoClienteMAV(Long oidDetalleMAV, Long[] subtipoCliente)
        throws MareException {
        UtilidadesLog.info("MONSimularEstimadosBPBean.insertaTipoClienteMAV(Long oidDetalleMAV, Long[] subtipoCliente):Entrada");

        for(int i = 0; i < subtipoCliente.length; i++) {
            UtilidadesLog.debug("Bucle SubtipoCliente " + i);
            UtilidadesLog.debug("oidDetalle: " + oidDetalleMAV.toString() + " - subtipoCliente: " + subtipoCliente[i].toString());
            
            try {
                SubtipoClienteDetalleMAVLocalHome SubtipoClienteH = new SubtipoClienteDetalleMAVLocalHome();
                SubtipoClienteH.create(subtipoCliente[i], oidDetalleMAV);
            } catch(PersistenceException cEx) {
                UtilidadesLog.error(cEx);
                throw new MareException(cEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }

        UtilidadesLog.info("MONSimularEstimadosBPBean.insertaTipoClienteMAV(Long oidDetalleMAV, Long[] subtipoCliente):Salida");
        return;
    }


    private void eliminaSubtipoClienteMAV(Long oidDetalleMAV)
        throws MareException {
        UtilidadesLog.info("MONSimularEstimadosBPBean.eliminaRegistrosSubtipoClienteMAV(Long oidDetalleMAV):Entrada");
        BelcorpService bs = BelcorpService.getInstance();
        StringBuffer sql = new StringBuffer("DELETE FROM mav_subti_clien_detal m ");
        sql.append(" WHERE m.DENV_OID_DETA_MAV = " + oidDetalleMAV.toString());

        try {
            bs.dbService.executeUpdate(sql.toString());
        } catch(Exception ex) {
            UtilidadesLog.debug("Error al eliminar tuplas U. Subtipo Cliente");
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }

        UtilidadesLog.info("MONSimularEstimadosBPBean.eliminaRegistrosSubtipoClienteMAV(Long oidDetalleMAV):Salida");
        return;
    }
    
}