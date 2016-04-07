package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.LogAPP;


import es.indra.sicc.cmn.negocio.correo.DTOCorreoElectronico;
import es.indra.sicc.cmn.negocio.correo.MONServicioCorreoElectronico;
import es.indra.sicc.cmn.negocio.correo.MONServicioCorreoElectronicoHome;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import es.indra.sicc.dtos.mav.DTOAgrupacionEnvios;
import es.indra.sicc.dtos.mav.DTOCargaPaginaRegistrosMAV;
import es.indra.sicc.dtos.mav.DTODetalleMAV;
import es.indra.sicc.dtos.mav.DTOECBRegistrosMAV;
import es.indra.sicc.dtos.mav.DTOEValidarProducto;
import es.indra.sicc.dtos.mav.DTOEnvioMAV;
import es.indra.sicc.dtos.mav.DTOLineaCombo;
import es.indra.sicc.dtos.mav.DTOProcesoDetalleMAV;
import es.indra.sicc.dtos.mav.DTORegistrosMAV;
import es.indra.sicc.dtos.mav.DTOSProductoValidado;
import es.indra.sicc.dtos.pre.DTOBuscarCodigoVentaPeriodo;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.entidades.bel.EstadosMercanciaLocal;
import es.indra.sicc.entidades.bel.EstadosMercanciaLocalHome;
import es.indra.sicc.entidades.bel.StockLocal;
import es.indra.sicc.entidades.bel.StockLocalHome;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.mae.MaestroProductosLocal;
import es.indra.sicc.entidades.mae.MaestroProductosLocalHome;
import es.indra.sicc.entidades.mae.MaestroProductosPK;
import es.indra.sicc.entidades.mav.ActividadesMAVLocal;
import es.indra.sicc.entidades.mav.ActividadesMAVLocalHome;
import es.indra.sicc.entidades.mav.DetalleMAVLocal;
import es.indra.sicc.entidades.mav.DetalleMAVLocalHome;
import es.indra.sicc.entidades.mav.EnvioMAVLocal;
import es.indra.sicc.entidades.mav.EnvioMAVLocalHome;
import es.indra.sicc.entidades.mav.ParametrizacionMAVLocal;
import es.indra.sicc.entidades.mav.ParametrizacionMAVLocalHome;
import es.indra.sicc.entidades.pre.MatrizFacturacionLocal;
import es.indra.sicc.entidades.pre.MatrizFacturacionLocalHome;
import es.indra.sicc.entidades.pre.CabeceraMFLocal;
import es.indra.sicc.entidades.pre.CabeceraMFLocalHome;
import es.indra.sicc.entidades.seg.SubaccesoLocal;
import es.indra.sicc.entidades.seg.SubaccesoLocalHome;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMF;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMFHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.logicanegocio.zon.MONUnidadesAdministrativas;
import es.indra.sicc.logicanegocio.zon.MONUnidadesAdministrativasHome;
import es.indra.sicc.logicanegocio.mae.MONClientesHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Timestamp;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.Iterator;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;

import javax.rmi.PortableRemoteObject;


public class MONRegistroMAVBean implements SessionBean {
    SessionContext ctx = null;

    public void ejbCreate() {}

    public void ejbActivate() {}

    public void ejbPassivate() {}

    public void ejbRemove() {}

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    public DTOSalida buscarEnviosMAVATC(DTOECBRegistrosMAV dto)
        throws MareException {
        UtilidadesLog.info("MONRegistroMAVBean.buscarEnviosMAVATC(DTOECBRegistrosMAV dto):Entrada");
        DAORegistrosMAV daoReg = new DAORegistrosMAV();
        DTOSalida dtoSalida = daoReg.buscarEnviosMAVATC(dto);
        UtilidadesLog.info("MONRegistroMAVBean.buscarEnviosMAVATC(DTOECBRegistrosMAV dto):Salida");
        return dtoSalida;
    }

    public DTOSalida buscarEnviosMAVATD(DTOECBRegistrosMAV dto)
        throws MareException {
        UtilidadesLog.info("MONRegistroMAVBean.buscarEnviosMAVATD(DTOECBRegistrosMAV dto):Entrada");
        DAORegistrosMAV daoReg = new DAORegistrosMAV();
        DTOSalida dtoSalida = daoReg.buscarEnviosMAVATD(dto);
        UtilidadesLog.info("MONRegistroMAVBean.buscarEnviosMAVATD(DTOECBRegistrosMAV dto):Salida");
        return dtoSalida;
    }

    private Boolean esGerenteZona(Long oidCliente) throws MareException {
        /*-> Crear variable llamada "esGerente" de tipo Boolean
-> Llamar al método "DAORegistrosMAV.obtenerZonasGerente(oidCliente : Long) : RecordSet" pasando el oidCliente de entrada
-> Tomar el RecordSet obtenido de la llamada anterior
Si el RecordSet tiene registros entonces
-> esGerente = "True"
Si no entonces
-> esGerente = "False"
Fin Si
-> Devolver "esGerente"*/
        UtilidadesLog.info("MONRegistroMAVBean.esGerenteZona(Long oidCliente):Entrada");
        Boolean esGerente = Boolean.valueOf(false);
        DAODetalleMAV dao = new DAODetalleMAV();
        RecordSet rs = dao.obtenerZonasGerente(oidCliente);

        if(!rs.esVacio())
            esGerente = Boolean.valueOf(true);

        UtilidadesLog.info("MONRegistroMAVBean.esGerenteZona(Long oidCliente):Salida");
        return esGerente;
    }

    public void generarEnvioMAV(DTODetalleMAV dto, Long periodo, Long actividad, Long cliente, Long unidadesEnvio)
        throws MareException {
        /*Proceso:
-> Crear variable llamada envioMAV de tipo DTOEnvioMAV
-> envioMAV.numeroUnidades = unidadesEnvio
-> envioMAV.tipoEstadoEnvio = ConstantesMAV.ESTADO_ENVIO_PENDIENTE
-> envioMAV.fechaEntrega = "MONEnvioIniFinPeriodo.obtenerFechaEntrega(periodo : Long) : Date" pasando el "periodo" de entrada como parámetro
-> envioMAV.precioEstandar = dto.precioEstandar
-> envioMAV.precio = dto.precio
-> envioMAV.precioContable = dto.precioContable
-> envioMAV.oidDetalle = dto.oid
-> envioMAV.oidMatrizFact = dto.codigoVenta
-> envioMAV.oidCliente = cliente
-> envioMAV.oidSolicitudEnvio = null
-> envioMAV.oidFormaCobro = dto.formaCobro
-> envioMAV.oidBuzonMensaje = null
-> envioMAV.oidActividadTipoDespacho = dto.tipoDespacho
-> envioMAV.oidActividad = actividad
-> envioMAV.oidFormaPago = dto.formaPago
-> envioMAV.indEnvio = ConstantesMAV.INDICADOR_PENDIENTE_ENVIO
// Generar envío
-> Llamar al método "MONEnvioIniFinPeriodo.insertarEnvioMAV(dtoin : DTOEnvioMAV) : void" */
        UtilidadesLog.info("MONRegistroMAVBean.generarEnvioMAV(DTODetalleMAV dto, Long periodo, Long actividad, Long cliente, Long unidadesEnvio):Entrada");
        UtilidadesLog.debug("Periodo: " + periodo);
        UtilidadesLog.debug("Cliente: " + cliente);
        try {
        
            // 5/4/2005 - Inc. MAV-12 PERU (15881)
            // Se obtiene la UA del cliente para luego obtener la Zona.
            //MONClientesHome monClientesHome = this.getMONClientesHome();
            //MONClientesHome monClientesHome = null;
            
            //MONClientes clientes = monClientesHome.create();
            //DTOUnidadAdministrativa unidadAdministrativa = clientes.obtenerUnidadAdministrativa(cliente, periodo);

            
            StringBuffer buf = new StringBuffer();
            buf.append("SELECT sub.pais_oid_pais, sub.marc_oid_marc, sub.cana_oid_cana, ");
            buf.append("oid_subg_vent, oid_regi, oid_zona, oid_secc, terr_oid_terr, ");
            buf.append("t.cod_nse1, t.cod_nse2, t.cod_nse3, oid_terr_admi ");
            buf.append("FROM mae_clien_unida_admin unid, zon_terri_admin tadm, zon_terri t, zon_secci, zon_zona, zon_regio, zon_sub_geren_venta sub ");
            buf.append("WHERE unid.clie_oid_clie = "+cliente.toString()+ " AND unid.PERD_OID_PERI_FIN is null AND ");
            buf.append("ztad_oid_terr_admi = oid_terr_admi AND terr_oid_terr = oid_terr  AND zscc_oid_secc = oid_secc ");
            buf.append("AND zzon_oid_zona = oid_zona  AND zorg_oid_regi = oid_regi AND zsgv_oid_subg_vent = oid_subg_vent "); 
            buf.append("AND ROWNUM = 1");
            
            RecordSet salida = BelcorpService.getInstance().dbService.executeStaticQuery(buf.toString());
            DTOUnidadAdministrativa unidadAdministrativa = null;
            if(!salida.esVacio()){
                //aunque luego se use solamente la zona, completo el dto. (GAcevedo)
                unidadAdministrativa = new DTOUnidadAdministrativa();
                if(salida.getValueAt(0,"COD_NSE1")!=null){
                    unidadAdministrativa.setNSE1(salida.getValueAt(0,"COD_NSE1").toString());
                }
                if(salida.getValueAt(0,"COD_NSE2")!=null){
                    unidadAdministrativa.setNSE2(salida.getValueAt(0,"COD_NSE2").toString());
                }
                if(salida.getValueAt(0,"COD_NSE3")!=null){
                    unidadAdministrativa.setNSE3(salida.getValueAt(0,"COD_NSE3").toString());
                }
                if(salida.getValueAt(0,"CANA_OID_CANA")!=null){
                    unidadAdministrativa.setOidCanal(new Long(salida.getValueAt(0,"CANA_OID_CANA").toString()));
                }
                unidadAdministrativa.setOidCliente(cliente);
                if(salida.getValueAt(0,"MARC_OID_MARC")!=null){
                    unidadAdministrativa.setOidMarca(new Long(salida.getValueAt(0,"MARC_OID_MARC").toString()));
                }
                if(salida.getValueAt(0,"PAIS_OID_PAIS")!=null){
                    unidadAdministrativa.setOidPais(new Long(salida.getValueAt(0,"PAIS_OID_PAIS").toString()));    
                }
                if(salida.getValueAt(0,"OID_REGI")!=null){
                    unidadAdministrativa.setOidRegion(new Long(salida.getValueAt(0,"OID_REGI").toString()));
                }
                if(salida.getValueAt(0,"OID_SECC")!=null) {
                    unidadAdministrativa.setOidSeccion(new Long(salida.getValueAt(0,"OID_SECC").toString()));    
                }
                if(salida.getValueAt(0,"OID_SUBG_VENT")!=null){
                    unidadAdministrativa.setOidSGV(new Long(salida.getValueAt(0,"OID_SUBG_VENT").toString()));
                }
                if(salida.getValueAt(0,"TERR_OID_TERR")!=null){
                    unidadAdministrativa.setOidTerritorio(new Long(salida.getValueAt(0,"TERR_OID_TERR").toString()));
                }
                if(salida.getValueAt(0,"OID_TERR_ADMI")!=null){
                    unidadAdministrativa.setOidTerritorioAdministrativo(new Long(salida.getValueAt(0,"OID_TERR_ADMI").toString()));    
                }
                if(salida.getValueAt(0,"OID_ZONA")!=null){
                    unidadAdministrativa.setOidZona(new Long(salida.getValueAt(0,"OID_ZONA").toString()));    
                }
            }
            UtilidadesLog.debug("unidadAdministrativa: " + unidadAdministrativa);
            
            if (unidadAdministrativa == null ) {
               UtilidadesLog.debug("No se encontró Unidad Administrativa para Cliente " + cliente);
               UtilidadesLog.debug(" - periodo " + periodo + " --- NO SE GENERA ENVIO");
            } else {
                DTOEnvioMAV envioMAV = new DTOEnvioMAV();
    
                MONEnvioIniFinPeriodoLocal monEnvio = getMONEnvioIniFinPeriodoLocalHome().create();
                envioMAV.setNumeroUnidades(unidadesEnvio);
                
                // Agregado por ssantana, BELC300018229
                // Se obtiene el pais del DetalleMAV para luego identificar la Parametrizacion
                // MAV correspondiente. 
                Long oidPaisDetalleMAV = this.obtienePaisDetalleMAV(dto);
                ParametrizacionMAVLocalHome paramMAVLocalHome = new ParametrizacionMAVLocalHome();
                ParametrizacionMAVLocal paramMAVLocal = paramMAVLocalHome.findByUK(oidPaisDetalleMAV);
    
                if ( paramMAVLocal.getRequerirAutorizacion().booleanValue() ) {
                   if (!dto.getFormaCobro().equals(ConstantesMAV.FORMA_COBRO_GRATIS))
                      envioMAV.setTipoEstadoEnvio(ConstantesMAV.ESTADO_ENVIO_PENDIENTE);
                   else 
                      envioMAV.setTipoEstadoEnvio(ConstantesMAV.ESTADO_ENVIO_SIN_AUTORIZACION);
                      
                } else {
                   double limitePrecioAutorizacion = paramMAVLocal.getLimitePrecioAutorizacion().doubleValue();
                   double detalleMAVPrecio = dto.getPrecio().doubleValue();
                   
                   if (detalleMAVPrecio > limitePrecioAutorizacion ) 
                      envioMAV.setTipoEstadoEnvio(ConstantesMAV.ESTADO_ENVIO_PENDIENTE);
                   else
                      envioMAV.setTipoEstadoEnvio(ConstantesMAV.ESTADO_ENVIO_SIN_AUTORIZACION);
                }
                
                //Long zonaUA = unidadAdministrativa.getOidZona();
                //java.util.Date fechaEntrega = monEnvio.obtenerFechaEntrega(periodo, zonaUA);
                // Modificado por ssantana, 20/1/2005
                // monEnvio.obtenerFechaEntrega(periodo) puede retornar NULL, asi que se tiene eso
                // en cuenta. 
                // 5/4/2005 - Se le pasa ademas "zona" de parametro (inc. 15881) 
                /*if (fechaEntrega == null) {
                    envioMAV.setFechaEntrega(null);
                } else {
                    envioMAV.setFechaEntrega(new Timestamp(fechaEntrega.getTime()));
                }*/
                  //envioMAV.setFechaEntrega(new Timestamp(monEnvio.obtenerFechaEntrega(periodo).getTime()));
                // Fin modificacion ssantana, 9/9/2005. 
                //envioMAV.setFechaEntrega(new Timestamp(monEnvio.obtenerFechaEntrega(periodo).getTime()));
                envioMAV.setPrecioEstandar(new BigDecimal(dto.getPrecioEstandar().doubleValue()));
                envioMAV.setPrecio(new BigDecimal(dto.getPrecio().doubleValue()));
                envioMAV.setPrecioContable(new BigDecimal(dto.getPrecioContable().doubleValue()));
                envioMAV.setOidDetalle(dto.getOid());
                envioMAV.setOidMatrizFact(dto.getCodigoVenta());
                envioMAV.setOidCliente(cliente);
                envioMAV.setOidSolicitudEnvio(null);
                envioMAV.setOidFormaCobro(dto.getFormaCobro());
                envioMAV.setOidActividadTipoDespacho(dto.getTipoDespacho());
                
                // Agregado por ssantana, 20/1/2005
                // Segun el DMCO, si actividad == null, entonces se toma dto.acitvidad()
                if (actividad == null)
                  actividad = dto.getActividad();
                  
                envioMAV.setOidActividad(actividad);
                envioMAV.setOidFormaPago(dto.getFormaPago());
                envioMAV.setIndEnvio("" + ConstantesMAV.INDICADOR_PENDIENTE_ENVIO);
                
                /*
                 * Agregado por ssantana, 03/03/2006, inc. 22717
                 */
                envioMAV.setOidMensaje(dto.getMensaje());            
                /*
                 * Fin Agregado por ssantana, 03/03/2006, inc. 22717
                 */
                
                monEnvio.insertarEnvioMAV(envioMAV);
            }
        } catch(NoResultException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch(NamingException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(RemoteException re) {
            UtilidadesLog.error(re);
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        } catch(CreateException re) {
            UtilidadesLog.error(re);
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        } catch (MareException me) {
          UtilidadesLog.error(me);
          ctx.setRollbackOnly();
          throw me;
        } catch (Exception ex) {
          UtilidadesLog.error(ex);
          ctx.setRollbackOnly();
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));          
        }
        UtilidadesLog.info("MONRegistroMAVBean.generarEnvioMAV(DTODetalleMAV dto, Long periodo, Long actividad, Long cliente, Long unidadesEnvio):Salida");
    }

    private void actualizarStock(DTODetalleMAV dto, Long numeroUnidadesEnviadas)
        throws MareException {
        /*Proceso:
-> Llamar al método "MONGenerarMensajes.obtenerAlmacen(pais : Long) : Long" pasando como parámetro dto.pais
-> Crear variable tipo Long llamada "almacen" y asignar la respuesta a la llamada anterior
-> Tomar dto.pais, dto.oidProducto, almacen y numeroUnidadesEnviadas para la siguiente llamada
-> Llamar al método "MONGenerarMensajes.hayStockSuficiente(pais : Long, producto : Long, almacen : Long, unidadesDemandadas : Long) : Boolean"
-> Crear variable tipo Boolean llamada "hayStockSuficiente" y guardar la respuesta a la llamada anterior
-> Invocar al método "findByClaveUnica(almacen : Long, estado : Long, producto : Long)" de la entidad Stock
Si (hayStockSuficiente == True) entonces
-> Tomar almacen, estado y dto.oidProducto para hacer la siguiente llamada
-> Stock.saldo = Stock.saldo - numeroUnidadesEnviadas
Si no entonces
-> Crear variable tipo String llamada "mensaje"
-> Hacer findByPrimaryKey sobre la entidad MaestroProductos tomando dto.oidProducto
-> Crear variable tipo String llamada "codigoSAP" y almacenar MaestroProductos.codigoSAP
-> Hacer findByPrimaryKey sobre la entidad Periodo tomando dto.periodo
-> Crear variable tipo String llamada "periodo" y almacenar Periodo.nombre
-> Hacer findByUK sobre la entidad ParametrizacionMAV pasando como parámetro dto.pais
-> Crear variable tipo String llamada "direccionEmail" y almacenar ParametrizacionMAV.direccionElectronicaEnvioFaltaStock
-> Crear variable tipo Long llamada "unidadesFaltantes"
-> unidadesFaltantes = numeroUnidadesEnviadas - Stock.saldo
-> Mensaje = "Se ha detectado una falta de stock del producto "+ codigoSAP +" para el período "+ periodo +". El número de unidades detectado como faltante es "+ unidadesFaltantes
-> Llamar al método "IServicioCorreoElectronico.enviarMensaje(direccion : String, mensaje : String) : void"
Fin Si */

        UtilidadesLog.info("MONRegistroMAVBean.actualizarStock(DTODetalleMAV dto, Long numeroUnidadesEnviadas):Entrada");
        try {
            MONGenerarMensajesHome monGenerarMensajesHome = getMONGenerarMensajesHome();
            MONGenerarMensajes monGenerarMensajes = monGenerarMensajesHome.create();

            Long almacen = monGenerarMensajes.obtenerAlmacen(dto.getOidPais());

            UtilidadesLog.debug("Almacen: " + almacen);            
            UtilidadesLog.debug("dto.getProducto(): " + dto.getProducto());
            UtilidadesLog.debug("dto.getOidPais(): " + dto.getOidPais());
            UtilidadesLog.debug("numeroUnidadesEnviadas: " + numeroUnidadesEnviadas);
            
            Boolean hayStockSuficiente = monGenerarMensajes.hayStockSuficiente(dto.getOidPais(), 
            dto.getProducto(), almacen, numeroUnidadesEnviadas);

            //Inc. 9159
            EstadosMercanciaLocalHome emlh  = new EstadosMercanciaLocalHome();
            EstadosMercanciaLocal estado = emlh.findByUK(dto.getOidPais(), 
            ConstantesBEL.COD_EST_LIBRE_DISP);
            
            UtilidadesLog.debug("Estado: " + estado);

            //Agregado por cvalenzu
            //Incidencia DBLG700000235 - BELC300024498
            StockLocal stock;
            try  {
                StockLocalHome slh = new StockLocalHome();
                stock = slh.findByClaveUnica(almacen, estado.getOid(), dto.getProducto());    
            }
            catch(NoResultException re) {
                stock = null;
            }           
            //FIN - Agregado por cvalenzu       
        
            // Modificado por ssantana, 25/1/2005
            // Segun lo hablado entre Construccion, DT y Modelizado, nunca se actualiza Stock
            // aqui. Solamente se verifica que haya stock suficiente, y si no hay,
            // envia el mail correspondiente .        
          /*if(hayStockSuficiente.booleanValue()) {
                UtilidadesLog.debug("Hay Stock suficiente");
                stock.setSaldo(new Long(stock.getSaldo().longValue() - numeroUnidadesEnviadas.longValue()));
            }*/
            if ( !hayStockSuficiente.booleanValue() ) {
                UtilidadesLog.debug("No hay stock suficiente");
                String mensaje = "";
                MaestroProductosPK mpPK = new MaestroProductosPK(dto.getProducto());

                MaestroProductosLocal maestroProducto = getMaestroProductosLocalHome().findByPrimaryKey(mpPK);

                String codigoSAP = maestroProducto.getCodigoSAP();
                PeriodoLocalHome plh = new PeriodoLocalHome();
                PeriodoLocal peri = plh.findByPrimaryKey(dto.getPeriodo());
                String periodo = peri.getNombrePeriodo();
                
                ParametrizacionMAVLocalHome pmavlh = new ParametrizacionMAVLocalHome();                
                ParametrizacionMAVLocal pm = pmavlh.findByUK(dto.getOidPais());
                String direccionEmail = pm.getDireccionElectronicaEnvioFaltaStock();
                
                //Agregado por cvalenzu
                //Incidencia DBLG700000235 - BELC300024498
                Long unidadesFaltantes;
                if(stock == null) {
                    unidadesFaltantes = new Long(numeroUnidadesEnviadas.longValue());    
                }
                else {
                    unidadesFaltantes = new Long(numeroUnidadesEnviadas.longValue() - stock.getSaldo().longValue());
                }           
                //FIN - Agregado por cvalenzu
                
                mensaje = "Se ha detectado una falta de stock del producto " + codigoSAP + " para el período " + periodo
                    + ". El número de unidades detectado como faltante es " + unidadesFaltantes;

                DTOCorreoElectronico dtoCorreo = new DTOCorreoElectronico();
                dtoCorreo.setDireccion(direccionEmail);
                dtoCorreo.setMensaje(mensaje);
                
                // Agregado por ssantana, 24/1/2005 - Inc. 12583
                dtoCorreo.setAsunto("Detectada falta de stock – Material de apoyo a ventas");
                MONServicioCorreoElectronico monCorreo = getMONServicioCorreoElectronicoHome().create();
                monCorreo.enviarCorreo(dtoCorreo);
            }
        }  catch(NoResultException re) {
            UtilidadesLog.error(re);
            ctx.setRollbackOnly();
            throw new MareException(re, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        catch(NamingException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        catch(FinderException re) {
            UtilidadesLog.error(re);
            ctx.setRollbackOnly();
            throw new MareException(re, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        catch(RemoteException re) {
            UtilidadesLog.error(re);
            ctx.setRollbackOnly();
            throw new MareException(re, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
        catch(CreateException re) {
            UtilidadesLog.error(re);
            ctx.setRollbackOnly();
            throw new MareException(re, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONRegistroMAVBean.actualizarStock(DTODetalleMAV dto, Long numeroUnidadesEnviadas):Salida");
    }

    public DTOSalida buscarEnviosMAVProductos(DTOECBRegistrosMAV dto)
        throws MareException {
        UtilidadesLog.info("MONRegistroMAVBean.buscarEnviosMAVProductos(DTOECBRegistrosMAV dto):Entrada");
        DAORegistrosMAV daoReg = new DAORegistrosMAV();
        DTOSalida dtoSalida = daoReg.buscarEnviosMAVProductos(dto);
        UtilidadesLog.info("MONRegistroMAVBean.buscarEnviosMAVProductos(DTOECBRegistrosMAV dto):Salida");
        return dtoSalida;
    }

    public DTOSalida detalleAgrupacionEnviosMAV(DTOAgrupacionEnvios dto)
        throws MareException {
        UtilidadesLog.info("MONRegistroMAVBean.detalleAgrupacionEnviosMAV(DTOAgrupacionEnvios dto):Entrada");
        DAORegistrosMAV daoReg = new DAORegistrosMAV();
        DTOSalida dtoSalida = daoReg.detalleAgrupacionEnviosMAV(dto);
        UtilidadesLog.info("MONRegistroMAVBean.detalleAgrupacionEnviosMAV(DTOAgrupacionEnvios dto):Salida");
        return dtoSalida;
    }

    public void guardarRegistrosMAV(DTORegistrosMAV dto) throws MareException {
        UtilidadesLog.info("MONRegistroMAVBean.guardarRegistrosMAV(DTORegistrosMAV dto):Entrada");
        UtilidadesLog.debug("DTO Entrada: " + dto);
        ArrayList agrupacionesEnvios = dto.getAgrupacionesEnvios();
        ArrayList enviosProducto = dto.getEnviosProducto();
        ArrayList detalleAgrupacion = dto.getDetalleAgrupacion();

        if(agrupacionesEnvios.size() > 0) {
            DTOAgrupacionEnvios dtoAgrup = (DTOAgrupacionEnvios)agrupacionesEnvios.get(0);
            Boolean retorno = this.validarVinculosAgrupacionEnvioMAV(dtoAgrup);

            if(retorno.booleanValue() == true) {
                UtilidadesLog.debug("--- Valida todo ok, se procede a guardar ---");
                this.guardarAgrupaciones(agrupacionesEnvios);
            } else {
                UtilidadesLog.debug("Error al validar");
                throw new MareException(null, null, UtilidadesError.armarCodigoError("GEN-0030"));
            }
        }

        UtilidadesLog.debug("Envios Producto: " + enviosProducto.size());
        UtilidadesLog.debug("enviosProducto.isEmpty(): " + enviosProducto.isEmpty());

        if(enviosProducto.size() > 0) {
            DTOEnvioMAV dtoEnvio = (DTOEnvioMAV)enviosProducto.get(0);
            Long oidEnvioMAV = dtoEnvio.getOidEnvioMAV();
            UtilidadesLog.debug("OidEnvioMAV a validar: " + oidEnvioMAV.toString());
            Boolean retorno = this.validarVinculosEnvioMAV(oidEnvioMAV);

            if(retorno.booleanValue() == true) {
                UtilidadesLog.debug("--- Valido todo ok, procede a grabar -----");
                this.guardarProductos(enviosProducto);
            } else {
                UtilidadesLog.debug("Error al validar");
                throw new MareException(null, null, UtilidadesError.armarCodigoError("GEN-0030"));
            }
        }

        UtilidadesLog.debug("Detalle Agrupacion: " + detalleAgrupacion.size());
        UtilidadesLog.debug("DetalleAgrupacion.isEmpty(): " + detalleAgrupacion.isEmpty());

        if(detalleAgrupacion.size() > 0) {
            DTOEnvioMAV dtoEnvio = (DTOEnvioMAV)detalleAgrupacion.get(0);
            Long oidEnvioMAV = dtoEnvio.getOidEnvioMAV();
            UtilidadesLog.debug("OidEnvioMAV a validar: " + oidEnvioMAV.toString());
            Boolean retorno = this.validarVinculosEnvioMAV(oidEnvioMAV);

            if(retorno.booleanValue() == true) {
                UtilidadesLog.debug("--- Valido todo ok, procede a grabar -----");
                this.guardarDetalleAgrupacion(detalleAgrupacion);
            } else {
                UtilidadesLog.debug("Error al validar");
                throw new MareException(null, null, UtilidadesError.armarCodigoError("GEN-0030"));
            }
        }
        UtilidadesLog.info("MONRegistroMAVBean.guardarRegistrosMAV(DTORegistrosMAV dto):Salida");
    }

    private void guardarDetalleAgrupacion(ArrayList detalleAgrupacion)
        throws MareException {
        // Guarda detalleAgrupacion (criterio Ordenacion Cliente/Despacho)
        UtilidadesLog.info("MONRegistroMAVBean.guardarDetalleAgrupacion(ArrayList detalleAgrupacion):Entrada");

        for(int i = 0; i < detalleAgrupacion.size(); i++) {
            DTOEnvioMAV dtoEnvio = (DTOEnvioMAV)detalleAgrupacion.get(i);
            Long oidEnvio = dtoEnvio.getOidEnvioMAV();
            Long estadoEnvio = dtoEnvio.getTipoEstadoEnvio();
            Long numUnidades = dtoEnvio.getNumeroUnidades();
            StringBuffer sql = new StringBuffer("");
            sql.append(" UPDATE MAV_ENVIO m SET m.NUM_UNID = " + numUnidades.toString() + ", ");
            sql.append(" m.ESEN_OID_ESTA_ENVI = " + estadoEnvio.toString());
            sql.append(" where m.OID_ENVI = " + oidEnvio.toString());

            BelcorpService bs = BelcorpService.getInstance();

            try {
                bs.dbService.executeUpdate(sql.toString());
            } catch(Exception ex) {
                UtilidadesLog.debug("Error");
                ctx.setRollbackOnly();
                UtilidadesLog.error(ex);
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            UtilidadesLog.debug("Ejecuto UPDATE correctamente");
        }
        UtilidadesLog.info("MONRegistroMAVBean.guardarDetalleAgrupacion(ArrayList detalleAgrupacion):Salida");
    }

    private void guardarProductos(ArrayList aList) throws MareException {
        // Modifica la base para el criterio de Ordenacion "Productos"
        UtilidadesLog.info("MONRegistroMAVBean.guardarProductos(ArrayList aList):Entrada");

        for(int i = 0; i < aList.size(); i++) {
            DTOEnvioMAV dtoEnvio = (DTOEnvioMAV)aList.get(i);
            Long oidEnvio = dtoEnvio.getOidEnvioMAV();
            Long numUnidades = dtoEnvio.getNumeroUnidades();
            Long oidEstadoEnvio = dtoEnvio.getTipoEstadoEnvio();
            Timestamp tFechaEntrega = dtoEnvio.getFechaEntrega();
            String fechaEntrega = null;

            if(tFechaEntrega != null)
                fechaEntrega = this.timestampToString(tFechaEntrega, "dd/MM/yyyy");

            StringBuffer sql = new StringBuffer("");
            sql.append(" UPDATE MAV_ENVIO m ");
            sql.append(" SET m.NUM_UNID = " + numUnidades.toString() + ", ");

            if(fechaEntrega == null)
                sql.append(" m.FEC_ENTR = NULL, ");
            else
                sql.append(" m.FEC_ENTR = to_date('" + fechaEntrega + "', 'dd/MM/yyyy'), ");

            sql.append(" m.ESEN_OID_ESTA_ENVI = " + oidEstadoEnvio.toString() + " ");
            sql.append(" WHERE m.OID_ENVI = " + oidEnvio.toString());

            BelcorpService bs = BelcorpService.getInstance();

            try {
                bs.dbService.executeUpdate(sql.toString());
            } catch(Exception ex) {
                UtilidadesLog.debug("Error");
                ctx.setRollbackOnly();
                UtilidadesLog.error(ex);
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            UtilidadesLog.info("MONRegistroMAVBean.guardarProductos(ArrayList aList):Salida");
        }
    }

    private void guardarAgrupaciones(ArrayList aList) throws MareException {
        UtilidadesLog.info("MONRegistroMAVBean.guardarAgrupaciones(ArrayList aList):Entrada");

        for(int i = 0; i < aList.size(); i++) {
            DTOAgrupacionEnvios dtoAgrup = (DTOAgrupacionEnvios)aList.get(i);
            Long tipoDespacho = dtoAgrup.getOidTipoDespacho();
            String codigoCliente = dtoAgrup.getCodigoCliente();
            Long tipoCliente = dtoAgrup.getOidTipoCliente();
            Timestamp tStamp = dtoAgrup.getFechaEntrega();
            String sFechaFormateada = null;

            if(tStamp != null)
                sFechaFormateada = this.timestampToString(tStamp, "dd/MM/yyyy");

            StringBuffer sql = new StringBuffer("");
            sql.append(" UPDATE MAV_ENVIO m SET ");

            if(sFechaFormateada == null)
                sql.append(" m.FEC_ENTR = NULL ");
            else
                sql.append(" m.FEC_ENTR = to_date('" + sFechaFormateada + "', 'dd/MM/yyyy') ");

            sql.append(" WHERE m.atde_oid_acti_tipo_desp IN ( ");
            sql.append("    SELECT mav_activ_tipo_despa.oid_acti_tipo_desp ");
            sql.append("    FROM mav_tipo_despa, mav_activ_tipo_despa ");
            sql.append("    WHERE mav_activ_tipo_despa.tdch_oid_tipo_desp = mav_tipo_despa.oid_tipo_desp ");
            sql.append("    AND mav_tipo_despa.oid_tipo_desp = " + tipoDespacho.toString() + ") ");
            sql.append(" AND m.clie_oid_clie IN (SELECT mae_clien.oid_clie ");
            sql.append("    FROM mae_clien, mae_clien_tipo_subti ");
            sql.append("    WHERE mae_clien.cod_clie = '" + codigoCliente + "') ");
            sql.append(" AND m.denv_oid_deta_mav IN (SELECT mav_detal_mav.oid_deta_mav ");
            sql.append("    FROM mav_detal_mav ");
            sql.append("    WHERE mav_detal_mav.ticl_oid_tipo_clie = " + tipoCliente.toString() + ")");

            BelcorpService bs = BelcorpService.getInstance();

            try {
                bs.dbService.executeUpdate(sql.toString());
            } catch(Exception ex) {
                UtilidadesLog.debug("Error");
                ctx.setRollbackOnly();
                UtilidadesLog.error(ex);
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONRegistroMAVBean.guardarAgrupaciones(ArrayList aList):Salida");
    }

    private String timestampToString(Timestamp t, String formato)
        throws MareException {
        UtilidadesLog.info("MONRegistroMAVBean.timestampToString(Timestamp t, String formato):Entrada");
        // Toma un Timestamp, y devuelve un String con la fecha formateada
        // segun <formato>
        UtilidadesLog.debug("Fecha de entrada: " + t.toString());

        SimpleDateFormat simpleDate = new SimpleDateFormat(formato);
        java.util.Date dateTemp = new java.util.Date(t.getTime());
        String fechaFormateada = simpleDate.format(dateTemp);

        UtilidadesLog.debug("Fecha de salida: " + fechaFormateada);
        UtilidadesLog.info("MONRegistroMAVBean.timestampToString(Timestamp t, String formato):Salida");
        return fechaFormateada;
    }

    public void generarInformacionMAV(MareDTO dto) throws MareException 
    {
        UtilidadesLog.info("MONRegistroMAVBean.generarInformacionMAV(MareDTO dto):Entrada");
        UtilidadesLog.debug("MareDTO Entrada: " + dto);
        Object[] valoresEntrada = this.leeMareDTO(dto);

        /* retorno[0] = pais;
           retorno[1] = marca;
           retorno[2] = canal;     
           retorno[3] = periodo;
           retorno[4] = actividad;
           retorno[5] = tipoCliente;
           retorno[6] = ipCliente;
           retorno[7] = programa;
           retorno[8] = idioma;*/
          
         Long pais =  (Long) valoresEntrada[0];
         Long marca = (Long) valoresEntrada[1];
         Long canal = (Long) valoresEntrada[2];
         Long periodo = (Long) valoresEntrada[3];
         Long actividad = (Long) valoresEntrada[4];
         Long tipoCliente = (Long) valoresEntrada[5];
         String ipCliente = (String) valoresEntrada[6];
         String programa = (String) valoresEntrada[7];
         Long idioma = (Long) valoresEntrada[8];
        

         if((pais == null) || (marca == null) || (canal == null) || (periodo == null))
            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAV, "", ErroresNegocio.MAV_0007));
         else 
         {
            DTODetalleMAV detalleMAV = new DTODetalleMAV();
            detalleMAV.setOidPais(pais);
            detalleMAV.setMarca(marca);
            detalleMAV.setCanal(canal);
            detalleMAV.setPeriodo(periodo);
            detalleMAV.setIpCliente(ipCliente);
            detalleMAV.setPrograma(programa);

            if(actividad != null)
                detalleMAV.setActividad(actividad);

            if(tipoCliente != null)
                detalleMAV.setTipoCliente(tipoCliente);

            DAODetalleMAV dao = new DAODetalleMAV();

            //Incidencia 8781
            
            // Modific. x ssantana, 25/1/2005
            // Se pasa el Tipo de Estado de Proceso Completado.
            Long tipoEstadoProceso = Long.valueOf(String.valueOf(ConstantesMAV.T_ESTAD_PROCESO_COMPLETADO));
            DTOSalida dtoS = dao.obtieneDetallesMAVCampania(detalleMAV, tipoEstadoProceso );

            Boolean simulacion = Boolean.valueOf(false);
            RecordSet rs = dtoS.getResultado();
            UtilidadesLog.debug("*************************** rs: " + rs);           

            MONBusinessPlanningHome monBPHome = null;
            MONBusinessPlanning monBP = null;

            try {
                monBPHome = (MONBusinessPlanningHome)UtilidadesEJB.getHome("MONBusinessPlanning", MONBusinessPlanningHome.class);
                monBP = monBPHome.create();
                UtilidadesLog.debug("Se encontro MONBusinessPlanningHome");

                for(int i = 0; i < rs.getRowCount(); i++)
                {
                    UtilidadesLog.debug("----- Bucle " + i + " -------");
                    
                    BigDecimal bigOidDetalle = (BigDecimal)rs.getValueAt(i, "OID_DETA_MAV");
                    Long oidDetalleMAV = Long.valueOf(bigOidDetalle.toString());
                    
                    DTOOID dtoO = new DTOOID();
                    dtoO.setOid(oidDetalleMAV);
                    dtoO.setIpCliente(ipCliente);
                    dtoO.setPrograma(programa);
                    dtoO.setOidIdioma(idioma);

                    detalleMAV = monBP.obtieneDetalleMAV(dtoO);
                    
                    // sapaza -- PER-SiCC-2010-0699 -- 23/02/2011
                    boolean aplicarUnidadesxRegionZona = false;
                    if(detalleMAV.getUnidadesRegionZona()!=null) {
                      Iterator it = detalleMAV.getUnidadesRegionZona().keySet().iterator();
                      String claveUA = (String)it.next();
                      Long valorUA = (Long)detalleMAV.getUnidadesRegionZona().get(claveUA);
                         
                       if(valorUA!=null)    
                          aplicarUnidadesxRegionZona = true;
                    }
                     UtilidadesLog.debug("aplicarUnidadesxRegionZona :" + aplicarUnidadesxRegionZona);
                     if(aplicarUnidadesxRegionZona)
                        actualizarZonasUnidades(detalleMAV);
                    
                    // Agregado por ssantana, 29/7/2005, inc. 18060
                    detalleMAV.setOidPais(pais);
                    // Fin Agregado por ssantana, 29/7/2005, inc. 18060
                    detalleMAV.setIpCliente(ipCliente);
                    detalleMAV.setPrograma(programa);
                    detalleMAV.setOidIdioma(idioma);

                    DTOProcesoDetalleMAV procesoDetalleMAV = procesarLineaDetalleMAV(detalleMAV, periodo, actividad, simulacion);
                    Long numeroUnidadesEnviadas = procesoDetalleMAV.getNumeroUnidadesEnviadas();
                    
                    
                    // Agregado por ssantana, 25/1/2005, segun inc. 11653
                    if (numeroUnidadesEnviadas.longValue() == 0) {
                      //BelcorpService belcorpService = BelcorpService.getInstance();
                      //belcorpService.appLog.info("[MAV] [Generar Información MAV] El número de registros creados para un producto ha sido 0");
                      LogAPP.info("[MAV] [Generar Información MAV] El número de registros creados para un producto ha sido 0");
                    } else {
                      ParametrizacionMAVLocalHome paramLocalHome = new ParametrizacionMAVLocalHome();
                      ParametrizacionMAVLocal paramLocal = paramLocalHome.findByUK(pais);
                      
                      if (procesoDetalleMAV.getNumeroClientes().longValue() > 
                                paramLocal.getNumeroRegistrosAviso().longValue() ) {
                        //BelcorpService belcorpService = BelcorpService.getInstance();
                        //belcorpService.appLog.info("[MAV] [Generar Información MAV] El número de registros creados para un producto ha sido mayor que el especificado por país");
                        LogAPP.info("[MAV] [Generar Información MAV] El número de registros creados para un producto ha sido mayor que el especificado por país");
                      }
                    }
                    
                    // Fin Agregado por ssantana, 1/8/2005
                    UtilidadesLog.debug("Salio de ProcesarLineaDetalle");
                }
            } catch(RemoteException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch(CreateException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            } catch (NoResultException fEx){
                UtilidadesLog.error(fEx);
                ctx.setRollbackOnly();
                throw new MareException(fEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );
            } catch (MareException mEx) {
                UtilidadesLog.error(mEx);
                ctx.setRollbackOnly();
                throw mEx;
            }
            
        }
        UtilidadesLog.info("MONRegistroMAVBean.generarInformacionMAV(MareDTO dto):Salida");
    }

    private RecordSet elaborarListaClientes(DTODetalleMAV dto, Boolean simulacion)
        throws MareException {
        UtilidadesLog.info("MONRegistroMAVBean.elaborarListaClientes(DTODetalleMAV dto, Boolean simulacion):Entrada");
        RecordSet listaClientes = null;

        if(dto.getListaClientes() == null) {
            UtilidadesLog.debug("Lista Clientes es NULL");
            if((dto.getCriterioAsignacion() != null)
                && (dto.getCriterioAsignacion().intValue() == ConstantesMAV.CRITERIO_ASIGNA_ATRIBUTOS))
                listaClientes = listaCriterioPorAtributos(dto, simulacion);
            else if((dto.getCriterioAsignacion() != null)
                && (dto.getCriterioAsignacion().intValue() == ConstantesMAV.CRITERIO_ASIGNA_VARIABLES))
                listaClientes = listaCriterioPorVariables(dto, simulacion);
            else if((dto.getCriterioAsignacion() != null)
                && (dto.getCriterioAsignacion().intValue() == ConstantesMAV.CRITERIO_ASIGNA_FORMULA))
                listaClientes = listaCriterioPorFormula(dto, simulacion);
            else
                throw new MareException(null, null,
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAV, "", ErroresNegocio.MAV_0008));
        } else {
            UtilidadesLog.debug(" Lista Clientes no es NULL");
            DAODetalleMAV dao = new DAODetalleMAV();
            listaClientes = dao.obtenerClientesLista(dto.getListaClientes());

        }
        UtilidadesLog.info("MONRegistroMAVBean.elaborarListaClientes(DTODetalleMAV dto, Boolean simulacion):Salida");
        return listaClientes;
    }

    private RecordSet listaCriterioPorAtributos(DTODetalleMAV dto, Boolean simulacion)
        throws MareException {
        UtilidadesLog.info("MONRegistroMAVBean.listaCriterioPorAtributos(DTODetalleMAV dto, Boolean simulacion):Entrada");
        if(!simulacion.booleanValue()) {
            try {
                DetalleMAVLocalHome detaLocalHome = getDetalleMAVLocalHome();
                detaLocalHome.parametrosAuditoria(dto);
                DetalleMAVLocal detaLocal = detaLocalHome.findByPrimaryKey(dto.getOid());

                detaLocal.setOidEstadoProceso(new Long(ConstantesMAV.T_ESTAD_PROCESO_INICIADO));
                dto.setEstadoProceso(new Long(ConstantesMAV.T_ESTAD_PROCESO_INICIADO));
            } catch(FinderException fe) {
                UtilidadesLog.error(fe);
                ctx.setRollbackOnly();
                throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
        }

        DAODetalleMAV dao = new DAODetalleMAV();
        RecordSet r = dao.obtenerClientesPorAtributos(dto);
        UtilidadesLog.info("MONRegistroMAVBean.listaCriterioPorAtributos(DTODetalleMAV dto, Boolean simulacion):Salida");
        return r;
    }

    private RecordSet listaCriterioPorVariables(DTODetalleMAV dto, Boolean simulacion)
        throws MareException {
        UtilidadesLog.info("MONRegistroMAVBean.listaCriterioPorAtributos(DTODetalleMAV dto, Boolean simulacion):Entrada");
        DAODetalleMAV dao = new DAODetalleMAV();
        RecordSet r = dao.obtenerClientesPorVariables(dto);
        UtilidadesLog.info("MONRegistroMAVBean.listaCriterioPorAtributos(DTODetalleMAV dto, Boolean simulacion):Salida");
        return r;
        
    }

    private RecordSet listaCriterioPorFormula(DTODetalleMAV dto, Boolean simulacion)
        throws MareException {
        UtilidadesLog.info("MONRegistroMAVBean.listaCriterioPorFormula(DTODetalleMAV dto, Boolean simulacion):Entrada");
        DAODetalleMAV dao = new DAODetalleMAV();
        RecordSet r = dao.obtenerClientesPorFormula(dto);
        UtilidadesLog.info("MONRegistroMAVBean.listaCriterioPorFormula(DTODetalleMAV dto, Boolean simulacion):Salida");
        return r;
    }

    private Long obtenerNumeroUnidadesEnviadas(DTODetalleMAV dto, RecordSet listaClientes, Long periodo, Long actividad,
        Boolean simulacion) throws MareException {
        /*
Entrada: 
- dto : DTODetalleMAV 
- listaClientes : RecordSet 
- periodo : Long 
- actividad : Long 
- simulacion : Boolean 
Proceso: 
-> Crear variable de tipo Long llamada "numeroUnidadesEnviadas" inicializada a 0 
(1)Si (dto.listaClientes == null) entonces 
 (2)Si (detalleMAV.criterioAsignacion == ConstantesMAV.CRITERIO_ASIGNA_ATRIBUTOS) entonces 
  -> numeroUnidadesEnviadas = longitud del RecordSet "listaClientes" x dto.unidadesPorCliente 
 (2)Si no Si (detalleMAV.criterioAsignacion == ConstantesMAV.CRITERIO_ASIGNA_VARIABLES) entonces 
  -> Llamar al método "MONRegistrosMAV.obtenerNUECriterioPorVariable(dto : DTODetalleMAV, listaClientes : RecordSet, periodo : Long, actividad : Long) : Long" 
  -> numeroUnidadesEnviadas += respuesta de la llamada anterior 
 (2)Si no Si (detalleMAV.criterioAsignacion == ConstantesMAV.CRITERIO_ASIGNA_FORMULA) entonces 
  -> Llamar al método "MONRegistrosMAV.obtenerNUECriterioPorFormula(dto : DTODetalleMAV, listaClientes : RecordSet, periodo : Long, actividad : Long) : Long" 
  -> numeroUnidadesEnviadas += respuesta de la llamada anterior 
 (2)Fin Si 
(1)Si no entonces 
 // Generar los envíos para cada cliente de la lista, que han sido extraídos de la lista de DetalleMAV 
 -> Crear variable llamada "unidadesEnvio" de tipo Long inicializada a 0 
 -> Crear variable llamada "clienteEnvio" de tipo Long inicializada a null 
 (3)Si (dto.unidadesTotales <> 0 ó vacío) entonces 
  -> Crear variable llamada "numeroClientes" de tipo Long inicializada a la longitud del RecordSet "listaClientes" 
  -> unidadesEnvio = dto.unidadesTotales / numeroClientes 
 (3)Si no entonces 
  -> unidadesEnvio = dto.unidadesPorCliente 
 (3)Fin Si 
 (4)Para cada posición de "listaClientes" hacer 
  // Recuperamos el cliente del envío 
  -> clienteEnvio = listaClientes[i] 
  -> numeroUnidadesEnviadas += unidadesEnvio 
  (5)Si (simulacion = false) entonces 
   -> Tomar dto, periodo, actividad, clienteEnvio y unidadesEnvio para la siguiente llamada 
   -> Llamar al método "MONRegistrosMAV.generarEnvioMAV(dto : DTODetalleMAV, periodo : Long, actividad : Long, cliente : Long, unidadesEnvio : Long) : void" 
  (5)Fin Si 
 (4)Fin Para 
(1)Fin Si 
-> Devolver el valor de "numeroUnidadesEnviadas
*/
        UtilidadesLog.info("MONRegistroMAVBean.obtenerNumeroUnidadesEnviadas(DTODetalleMAV dto, RecordSet listaClientes, Long periodo, Long actividad, Boolean simulacion):Entrada");
        Long numeroUnidadesEnviadas = new Long(0);

        if(dto.getListaClientes() == null) 
        {
            UtilidadesLog.debug("Lista de Clientes es NULL");
            if(dto.getCriterioAsignacion().intValue() == ConstantesMAV.CRITERIO_ASIGNA_ATRIBUTOS) 
            {
                UtilidadesLog.debug("Criterio por Atributos");
                Integer clien = new Integer(listaClientes.getRowCount());
                Long unidadesPorCliente = new Long(0);
                if (dto.getUnidadesPorCliente() != null)
                  unidadesPorCliente = new Long(dto.getUnidadesPorCliente().longValue());
                numeroUnidadesEnviadas = new Long(clien.longValue() * unidadesPorCliente.longValue());
            } else 
            {
                if(dto.getCriterioAsignacion().intValue() == ConstantesMAV.CRITERIO_ASIGNA_VARIABLES){
                    UtilidadesLog.debug("Criterio por Variables");                
                    numeroUnidadesEnviadas = new Long(numeroUnidadesEnviadas.longValue()
                            + this.obtenerNUECriterioPorVariable(dto, listaClientes, periodo, actividad, simulacion).longValue());
                }
                else if(dto.getCriterioAsignacion().intValue() == ConstantesMAV.CRITERIO_ASIGNA_FORMULA)
                {
                        UtilidadesLog.debug("Criterio por Formulas");                
                        numeroUnidadesEnviadas = new Long(numeroUnidadesEnviadas.longValue()
                                + this.obtenerNUECriterioPorFormula(dto, listaClientes, periodo, actividad, simulacion).longValue());
                }
            }
        } else {
            UtilidadesLog.debug("Lista de Clientes NO es NULL");
            Long unidadesEnvio = new Long(0);
            Long clienteEnvio = null;
            /* 
             * Modificado por ssantana, inc. 23022 - A confirmar 
             * diferencia en tipo de datos entre par de campos de Criterio de
             * Asignacion, y par de campos de Lista de Clientes.
             */
            if ((dto.getUnidadesTotalesEstimadas() != null) && 
                    (dto.getUnidadesTotalesEstimadas().longValue() != 0)) {
                UtilidadesLog.debug("dto.getUnidadesTotales().longValue() != 0");
                UtilidadesLog.debug("ListaCliente.getRowCount(): " + listaClientes.getRowCount());

                /* 
                 * Modificado por ssantana, 20/1/2005
                 * Si por acaso listaCliente.getRowCount() viene en 0 (no deberia pasar),
                 * unidadesEnvio directamente es 0 (para evitar Division By Zero).
                 */
                if ( listaClientes.esVacio() ){
                  unidadesEnvio = new Long(0);
                } else {
                  Integer reg = new Integer(listaClientes.getRowCount());
                  Long numeroClientes = new Long(reg.longValue());
                  unidadesEnvio = new Long(dto.getUnidadesTotalesEstimadas().longValue() / numeroClientes.longValue());
                }
            } else {
                if ( dto.getUnidadesEstimadas() != null ) {
                    unidadesEnvio = new Long(dto.getUnidadesEstimadas().longValue());
                }
            }
                
            UtilidadesLog.debug("Entra al bucle AAAAAAAAAAAAAAAAAAAAAAAAAAA");
            Long  unidadesEnvioAux = new Long(0);
            for(int i = 0; i < listaClientes.getRowCount(); i++) 
            {
                UtilidadesLog.debug("--- Bucle " + i);

                // sapaza -- PER-SiCC-2010-0699 -- 13/12/2010                
                Long unidadesEnvioConf = new Long(((BigDecimal) listaClientes.getValueAt(i,1)).longValue());
                if(unidadesEnvioConf.longValue() > 0)
                    unidadesEnvioAux = unidadesEnvioConf;
                else
                    unidadesEnvioAux =  unidadesEnvio; 
                    
                numeroUnidadesEnviadas = new Long(unidadesEnvioAux.longValue() + numeroUnidadesEnviadas.longValue());
                
                BigDecimal numero = (BigDecimal)listaClientes.getValueAt(i, 0);
                clienteEnvio = new Long(numero.longValue());
                UtilidadesLog.debug("Simulacion es " + simulacion.booleanValue());
                if(simulacion.booleanValue() == false)
                    this.generarEnvioMAV(dto, periodo, actividad, clienteEnvio, unidadesEnvioAux);
            }
        }
        UtilidadesLog.info("MONRegistroMAVBean.obtenerNumeroUnidadesEnviadas(DTODetalleMAV dto, RecordSet listaClientes, Long periodo, Long actividad, Boolean simulacion):Salida");
        return numeroUnidadesEnviadas;
    }

    private Long obtenerNUECriterioPorVariable(DTODetalleMAV dto, RecordSet listaClientes, Long periodo, Long actividad,
        Boolean simulacion) throws MareException {
        UtilidadesLog.info("MONRegistroMAVBean.obtenerNUECriterioPorVariable(DTODetalleMAV dto, RecordSet listaClientes, Long periodo, Long actividad, Boolean simulacion):Entrada");
        DAODetalleMAV daoDetalleMAV = new DAODetalleMAV();
        Long numeroUnidadesEnviadas = new Long(0);
        ArrayList listaConsultorasCliente = new ArrayList();
        ArrayList consultoraCliente = null;
        Long totalConsultoras = new Long(0);
        Long numConsultoras = null;
        
        /*
         * Agregado por ssantana, 09/01/2006, inc. BELC300021972
         * Se obtienen los subtipos de Gerente (Zona y Region) parametrizados
         * para el Pais del DetalleMAV. 
         */
        Long oidPais = dto.getOidPais();
        Long[] subtiposDetalleMAV = dto.getSubtiposCliente();
        
        RecordSet rSubtipos = 
                daoDetalleMAV.obtieneParametrizacionSubtiposMAV(oidPais);

        Long oidGerenteRegion = 
                Long.valueOf(rSubtipos.getValueAt(0,0).toString());
        Long oidGerenteZona = 
                Long.valueOf(rSubtipos.getValueAt(0,1).toString());
                
        UtilidadesLog.debug("OidGerenteZona (x parametr.): " + oidGerenteZona);
        UtilidadesLog.debug("OidGerenteRegion (x parametr.): " + oidGerenteRegion);

        Boolean bTieneSubtipoZona = this.tieneSubtipo(subtiposDetalleMAV,
                                                      oidGerenteZona);
        Boolean bTieneSubtipoRegion = this.tieneSubtipo(subtiposDetalleMAV,
                                                        oidGerenteRegion);
                                                   
        UtilidadesLog.debug("DetalleMAV tiene subt. Zona? " + 
                bTieneSubtipoZona);
        UtilidadesLog.debug("DetalleMAV tiene subt. Region? " +
                bTieneSubtipoRegion);
        /*
         * Fin Agregado por ssantana, 09/01/2006
         */
        

        UtilidadesLog.debug("------- obtenerNUECriterioPorVariable()");
        for(int i = 0; i < listaClientes.getRowCount(); i++){
            Long oidCliente = 
               Long.valueOf(listaClientes.getValueAt(i, "OID_CLIE").toString());
               
            UtilidadesLog.debug(" **** Procesa cliente: " + oidCliente);
            /* 
             * Modificado por ssantana, 30/3/2005, por MAV-12
             * Ya no se chequea qué tipo de Gerente es, ya que se ejecutan 
             * los branches por igual y luego se suman los resultados 
             * de consultoras de ambos. 
             */
            Long numConsultorasBuffer = new Long(0);            
            numConsultoras = new Long(0);
            
            /*
             * Modificado por ssantana, 12/01/2006, inc. BELC300021972.
             * (Solamente se obtienen consultoras por Region o Zona si el 
             *  DetalleMAV posee esos subtipos asociados).
             */
            if ( bTieneSubtipoRegion.booleanValue() ) {
               numConsultorasBuffer = 
                      this.recuperarConsultorasRegion(dto, 
                                                      oidCliente, 
                                                      periodo);
               UtilidadesLog.debug("-- Sale de recuperarConsultorasRegion --");
               UtilidadesLog.debug("Consultoras por Region: " + 
                      numConsultorasBuffer);
                      
               numConsultoras = new Long(numConsultoras.longValue() + 
                      numConsultorasBuffer.longValue());
            }
            
            if ( bTieneSubtipoZona.booleanValue() ) {
               numConsultorasBuffer = 
                      this.recuperarConsultorasZona(dto, 
                                                    oidCliente, 
                                                    periodo);
                                                                    
               UtilidadesLog.debug("-- Sale de recuperarConsultorasZona -- ");
               UtilidadesLog.debug("Consultoras por Zona: " + 
                      numConsultorasBuffer);
                      
               numConsultoras = new Long(numConsultoras.longValue() + 
                      numConsultorasBuffer.longValue());
            }
            /*
             * Fin modificado por ssantana, 12/01/2006, inc. BELC300021972.
             * (Solamente se obtienen consultoras por Region o Zona si 
             *  el DetalleMAV tiene esos subtipos).
             */
            totalConsultoras = new Long(totalConsultoras.longValue() +
                    numConsultoras.longValue());                
            UtilidadesLog.debug("totalConsultoras Temporal: " + totalConsultoras);

            consultoraCliente = new ArrayList();
            consultoraCliente.add(oidCliente);
            consultoraCliente.add(numConsultoras);

            listaConsultorasCliente.add(consultoraCliente);
        }
        
        UtilidadesLog.debug("totalConsultoras Final: " + totalConsultoras);        

        Long unidadesEnvio = new Long(0);
        Long clienteEnvio = null;
        Long numeroConsultoras = new Long(0);

        Integer dtoUnidadesTotales = dto.getUnidadesTotales();
        BigDecimal bigTemp = null;
        for(int i = 0; i < listaConsultorasCliente.size(); i++) 
        {
            consultoraCliente = (ArrayList)listaConsultorasCliente.get(i);
            clienteEnvio = (Long)consultoraCliente.get(0);
            numeroConsultoras = (Long)consultoraCliente.get(1);
            UtilidadesLog.debug("Ejecutando division");
            if(dto.getUnidadesTotales() != null && totalConsultoras.longValue() > 0) {
                UtilidadesLog.debug("dto.getUnidadesTotales() no es NULL, es: " + dto.getUnidadesTotales());
                UtilidadesLog.debug("Ejecuta unidadesEnvio = new Long((numeroConsultoras.longValue() * dto.getUnidadesTotales().longValue()) / totalConsultoras .longValue());");
                /*
                 * Modificacion por ssantana, 28/02/2006
                 * Se contempla redondeo.
                 */
                double dTemp = numeroConsultoras.doubleValue() * 
                        dtoUnidadesTotales.doubleValue();
                dTemp = dTemp / totalConsultoras.doubleValue();
                
                bigTemp = new BigDecimal(dTemp);
                bigTemp = bigTemp.setScale(0, BigDecimal.ROUND_HALF_EVEN);
                unidadesEnvio = Long.valueOf(bigTemp.toString());
                /*unidadesEnvio = new Long((numeroConsultoras.longValue() * dto.getUnidadesTotales().longValue()) / totalConsultoras
                        .longValue());*/
                /*
                 * Fin Modificacion por ssantana, 28/02/2006
                 */
            } else {
                UtilidadesLog.debug("dto.getUnidadesTotales() es NULL o totalConsultoras es 0, por lo que unidadesEnvio es " + unidadesEnvio);
                unidadesEnvio = new Long(0);
            }
            UtilidadesLog.debug("Finalizo Division");
            numeroUnidadesEnviadas = new Long(numeroUnidadesEnviadas.longValue() + unidadesEnvio.longValue());

            if(!simulacion.booleanValue())
            {
                UtilidadesLog.debug("Aca llamaria a MONRegistroMAV.generarEnvio()");
                // Modificacion por ssantana, 27/1/2005
                // Si unidadesEnvio es 0, entonces no genera el envio (un envio 
                // con 0 unidades no tiene sentido)
                
                if (unidadesEnvio.longValue() > 0)
                {
                  UtilidadesLog.debug("Unidades a enviar es: " + unidadesEnvio + ", se envia");
                  generarEnvioMAV(dto, periodo, actividad, clienteEnvio, unidadesEnvio);
                } else {
                  UtilidadesLog.debug("Unidades a enviar es 0, no se genera envio");
                }
            }
        }
        UtilidadesLog.info("MONRegistroMAVBean.obtenerNUECriterioPorVariable(DTODetalleMAV dto, RecordSet listaClientes, Long periodo, Long actividad, Boolean simulacion):Salida");
        return numeroUnidadesEnviadas;
    }

    private Long obtenerNUECriterioPorFormula(DTODetalleMAV dto, RecordSet listaClientes, Long periodo, Long actividad,
        Boolean simulacion) throws MareException {
        UtilidadesLog.info("MONRegistroMAVBean.obtenerNUECriterioPorFormula(DTODetalleMAV dto, RecordSet listaClientes, Long periodo, Long actividad, Boolean simulacion):Entrada");
        DAODetalleMAV daoDetalleMAV = new DAODetalleMAV();
        Long numeroUnidadesEnviadas = new Long(0);
        ArrayList listaConsultorasCliente = new ArrayList();
        ArrayList consultoraCliente = null;
        Long totalConsultoras = new Long(0);
        Long numConsultoras = null;

        /*
         * Agregado por ssantana, 09/01/2006, inc. BELC300021972
         * Se obtienen los subtipos de Gerente (Zona y Region) parametrizados
         * para el Pais del DetalleMAV. 
         */
        Long oidPais = dto.getOidPais();
        Long[] subtiposDetalleMAV = dto.getSubtiposCliente();
        
        RecordSet rSubtipos = 
                daoDetalleMAV.obtieneParametrizacionSubtiposMAV(oidPais);

        Long oidGerenteRegion = 
                Long.valueOf(rSubtipos.getValueAt(0,0).toString());
        Long oidGerenteZona = 
                Long.valueOf(rSubtipos.getValueAt(0,1).toString());
                
        UtilidadesLog.debug("OidGerenteZona (x parametr.): " + oidGerenteZona);
        UtilidadesLog.debug("OidGerenteRegion (x parametr.): " + oidGerenteRegion);

        Boolean bTieneSubtipoZona = this.tieneSubtipo(subtiposDetalleMAV,
                                                      oidGerenteZona);
        Boolean bTieneSubtipoRegion = this.tieneSubtipo(subtiposDetalleMAV,
                                                        oidGerenteRegion);
                                                   
        UtilidadesLog.debug("DetalleMAV tiene subt. Zona? " + 
                bTieneSubtipoZona);
        UtilidadesLog.debug("DetalleMAV tiene subt. Region? " +
                bTieneSubtipoRegion);

        // sapaza -- PER-SiCC-2010-0699 -- 13/12/2010                
        boolean aplicarUnidadesxRegionZona = false;
        if(dto.getUnidadesRegionZona()!=null) {
            Iterator it = dto.getUnidadesRegionZona().keySet().iterator();
            String claveUA = (String)it.next();
            Long valorUA = (Long)dto.getUnidadesRegionZona().get(claveUA);
            
            if(valorUA!=null)    
                aplicarUnidadesxRegionZona = true;
        }
        UtilidadesLog.debug("aplicarUnidadesxRegionZona :" + aplicarUnidadesxRegionZona);
                                                   
        /*
         * Fin Agregado por ssantana, 09/01/2006
         */
        UtilidadesLog.debug("-------- obtenerNUECriterioPorFormula()");
        for(int i = 0; i < listaClientes.getRowCount(); i++) {
            Long oidCliente = 
                Long.valueOf(listaClientes.getValueAt(i, "OID_CLIE").toString());
                
            UtilidadesLog.debug(" **** Procesa cliente " + oidCliente);
            /* 
             * Modificado por ssantana, 30/3/2005, por MAV-12. 
             * Ya no se chequea qué tipo de Gerente es, ya que se ejecutan 
             * los branches por igual
             * y luego se suman los resultados de consultoras de ambos. 
             */
            Long numConsultorasBuffer = new Long(0);
            numConsultoras = new Long(0);
            
            /*
             * Modificado por ssantana, 12/01/2006, inc. BELC300021972.
             * (Solamente se obtienen consultoras por Region o Zona si el 
             *  DetalleMAV posee esos subtipos asociados).
             */
            if ( bTieneSubtipoRegion.booleanValue() ) {
               numConsultorasBuffer = this.recuperarConsultorasRegion(dto, 
                                                                      oidCliente, 
                                                                      periodo);
               UtilidadesLog.debug("-- Sale de recuperarConsultorasRegion -- ");
               UtilidadesLog.debug("Consultoras por region: " + 
                      numConsultorasBuffer);
               numConsultoras = new Long(numConsultoras.longValue() + 
                       numConsultorasBuffer.longValue());
            }
            
            if ( bTieneSubtipoZona.booleanValue() ) {
               numConsultorasBuffer = this.recuperarConsultorasZona(dto, 
                                                                    oidCliente, 
                                                                    periodo);
               UtilidadesLog.debug("-- Sale de recuperarConsultorasZona -- ");
               UtilidadesLog.debug("Consultoras por zona: " +   
                      numConsultorasBuffer);
                      
               numConsultoras = new Long(numConsultoras.longValue() + 
                      numConsultorasBuffer.longValue());
            }
            /*
             * Fin modificado por ssantana, 12/01/2006, inc. BELC300021972.
             * (Solamente se obtienen consultoras por Region o Zona si 
             *  el DetalleMAV tiene esos subtipos).
             */

            totalConsultoras = new Long(totalConsultoras.longValue() + 
                                        numConsultoras.longValue());
            UtilidadesLog.debug("totalConsultoras Temporal: " + totalConsultoras);
            consultoraCliente = new ArrayList();
            consultoraCliente.add(oidCliente);
            consultoraCliente.add(numConsultoras);

            listaConsultorasCliente.add(consultoraCliente);
        }
        UtilidadesLog.debug("totalConsultoras Final: " + totalConsultoras);        

        Long unidadesEnvio = new Long(0);
        Long clienteEnvio = null;
        Long numeroConsultoras = new Long(0);

        for(int i = 0; i < listaConsultorasCliente.size(); i++)
        {
            consultoraCliente = (ArrayList)listaConsultorasCliente.get(i);
            clienteEnvio = (Long)consultoraCliente.get(0);
            numeroConsultoras = (Long)consultoraCliente.get(1);
            
            // sapaza -- PER-SiCC-2010-0699 -- 13/12/2010 
            if(aplicarUnidadesxRegionZona) {
                unidadesEnvio = numeroConsultoras.longValue();
            } 
            else {
                if (dto.getUnidadesPorCliente() !=null)            
                  unidadesEnvio = new Long(numeroConsultoras.longValue() * dto.getUnidadesPorCliente().longValue());
                else
                  unidadesEnvio = new Long(0);
            }      
              
            numeroUnidadesEnviadas = new Long(numeroUnidadesEnviadas.longValue() + unidadesEnvio.longValue());

            if(!simulacion.booleanValue())
            {
                UtilidadesLog.debug("Simulacion es false, procede a llamar a MONRegistroMAV.generarEnvio()");
                if (unidadesEnvio.longValue() > 0)
                {
                  UtilidadesLog.debug("Unidades a Enviar es " + unidadesEnvio + ", se realiza el envio");
                  generarEnvioMAV(dto, periodo, actividad, clienteEnvio, unidadesEnvio);
                } else
                {
                  UtilidadesLog.debug("Unidades a Enviar es 0, no se realiza el envio");
                }
            }
        }
        UtilidadesLog.info("MONRegistroMAVBean.obtenerNUECriterioPorFormula(DTODetalleMAV dto, RecordSet listaClientes, Long periodo, Long actividad, Boolean simulacion):Salida");
        return numeroUnidadesEnviadas;
    }

    private Boolean esGerenteRegion(Long oidCliente) throws MareException {
        UtilidadesLog.info("MONRegistroMAVBean.esGerenteRegion(Long oidCliente):Entrada");
        Boolean esGerente = Boolean.valueOf(false);
        DAODetalleMAV dao = new DAODetalleMAV();
        RecordSet rs = dao.obtenerRegionesGerente(oidCliente);

        if(!rs.esVacio())
            esGerente = Boolean.valueOf(true);
            
        UtilidadesLog.info("MONRegistroMAVBean.esGerenteRegion(Long oidCliente):Salida");
        return esGerente;
    }

    private Long recuperarConsultorasRegion(DTODetalleMAV dto, Long oidCliente, Long periodo)
        throws MareException {
        UtilidadesLog.info("MONRegistroMAVBean.recuperarConsultorasRegion(DTODetalleMAV dto, Long oidCliente, Long periodo):Entrada");
        DAODetalleMAV dao = new DAODetalleMAV();
        UtilidadesLog.debug("Llama a consultorasGerenteRegionPorSubcriterio");
        Long oid = dao.consultorasGerenteRegionPorSubcriterio(dto, oidCliente, periodo);
        UtilidadesLog.info("MONRegistroMAVBean.recuperarConsultorasRegion(DTODetalleMAV dto, Long oidCliente, Long periodo):Salida");
        return oid;
    }

    private Long recuperarConsultorasZona(DTODetalleMAV dto, Long oidCliente, Long periodo)
        throws MareException {
        UtilidadesLog.info("MONRegistroMAVBean.recuperarConsultorasZona(DTODetalleMAV dto, Long oidCliente, Long periodo):Entrada");
        DAODetalleMAV dao = new DAODetalleMAV();
        UtilidadesLog.debug("Llama a consultorasGerenteZonaPorSubcriterio");
        Long oid = dao.consultorasGerenteZonaPorSubcriterio(dto, oidCliente, periodo);
        UtilidadesLog.info("MONRegistroMAVBean.recuperarConsultorasZona(DTODetalleMAV dto, Long oidCliente, Long periodo):Salida");
        return oid;
    }


    private MONUnidadesAdministrativasHome getMONUnidadesAdministrativasHome()
        throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONUnidadesAdministrativasHome)PortableRemoteObject.narrow(context.lookup("MONUnidadesAdministrativas"),
            MONUnidadesAdministrativasHome.class);
    }

    public DTOCargaPaginaRegistrosMAV cargaPaginaRegistrosMAV(DTOBelcorp dto)
        throws MareException {
        UtilidadesLog.info("MONRegistroMAVBean.cargaPaginaRegistrosMAV(DTOBelcorp dto):Entrada");

        DTOCargaPaginaRegistrosMAV dtoRetorno = new DTOCargaPaginaRegistrosMAV();
        DTOUnidadAdministrativa dtoUA = new DTOUnidadAdministrativa();

        MONUnidadesAdministrativasHome monUAHome = null;
        MONUnidadesAdministrativas monUA = null;

        try {
            monUAHome = this.getMONUnidadesAdministrativasHome();
            monUA = monUAHome.create();
            dtoUA.setOidPais(dto.getOidPais());

            UtilidadesLog.debug("Trayendo Zonas...");

            DTOSalida dtoSalida = monUA.obtenerZonasPorRegiones(dtoUA);
            RecordSet r = dtoSalida.getResultado();
            dtoRetorno.setZonas(r);

            UtilidadesLog.debug("Trayendo Regiones...");
            dtoSalida = monUA.obtenerRegionesPorSGV(dtoUA);
            r = dtoSalida.getResultado();
            dtoRetorno.setRegiones(r);
        } catch(NamingException nEx) {
            UtilidadesLog.debug("Naming Exception");
            UtilidadesLog.error(nEx);
            throw new MareException(nEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(RemoteException rEx) {
            UtilidadesLog.debug("Remote Exception");
            UtilidadesLog.error(rEx);
            throw new MareException(rEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException cEx) {
            UtilidadesLog.debug("Create Exception");
            UtilidadesLog.error(cEx);
            throw new MareException(cEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.debug("dto a devolver: " + dtoRetorno);
        UtilidadesLog.info("MONRegistroMAVBean.cargaPaginaRegistrosMAV(DTOBelcorp dto):Salida");
        return dtoRetorno;
    }

    public DTOProcesoDetalleMAV procesarLineaDetalleMAV(DTODetalleMAV dto, Long peirodo, Long actividad, Boolean simulacion)
        throws MareException {
        /*Entrada: 
 - dto : DTODetalleMAV
    - periodo : Long
 - actividad : Long
    - simulacion : Boolean
 Proceso: 
 (1)Si (simulacion = false) entonces
 -> Llamar al método "MONRegistrosMAV.comprobarCodigoVenta(dto : DTODetalleMAV) : void" pasando dto
 como parámetro
 (1)Fin Si
 -> Llamar al método "MONRegistrosMAV.elaborarListaClientes(dto : DTODetalleMAV, simulacion : Boolean) :
 RecordSet" pasando dto y simulacion como parámetros
 -> Tomar RecordSet obtenido como parámetro "listaClientes" de la siguiente llamada, además de dto, periodo,
 actividad y simulacion de la entrada
 -> Llamar al método "MONRegistrosMAV.obtenerNumeroUnidadesEnviadas(dto : DTODetalleMAV, listaClientes :
 RecordSet, periodo : Long, actividad : Long, simulacion : Boolean) : Long "
 -> Crear variable llamada "numeroUnidadesEnviadas" de tipo Long y almacenar la respuesta a la llamada anterior 
 (2)Si ((numeroUnidadesEnviadas > 0)&&(simulacion = false)) entonces 
     -> Utilizar numeroUnidadesEnviadas para la siguiente llamada 
 -> Llamar al método "MONRegistrosMAV.actualizarStock(dto : DetalleMAV, numeroUnidadesEnviadas : Long) :
 void"
 (2)Fin Si
 (3)Si ((dto.criterioAsignacion = ConstantesMAV.CRITERIO_ASIGNA_ATRIBUTOS)&&
     (simulacion = false)) entonces
     -> Hacer findByPrimaryKey sobre la entidad DetalleMAV con el atributo dto.oid
     -> DetalleMAV.estadoProceso = ConstantesMAV.T_ESTAD_PROCESO_GENERADO
 (3)Fin Si
 -> Crear variable llamada "procesoDetalleMAV" de tipo DTOProcesoDetalleMAV
 -> procesoDetalleMAV.numeroClientes = número de filas del RecordSet "listaClientes"
 -> procesoDetalleMAV.numeroUnidadesEnviadas = numeroUnidadesEnviadas
 -> Devolver "procesoDetalleMAV"*/

        // Obtenemos el Oid de Matriz de Facturacion a utilizar. 
        // (Se completa el DTODetalleMAV con este valor para uso posterior). 
        UtilidadesLog.info("MONRegistroMAVBean.procesarLineaDetalleMAV(DTODetalleMAV dto, Long peirodo, Long actividad, Boolean simulacion):Entrada");
        if(simulacion.booleanValue() == false) {
            UtilidadesLog.debug("DTODetalleMAV antes de CmprobarCodigoVenta(): " + dto);
            this.comprobarCodigoVenta(dto, peirodo);
            UtilidadesLog.debug("DTODetalleMAV luego de comprobarCodigoVenta(): " + dto);
        }
        
        // Chequeamos si ya existe algún Envío anterior para ese DetalleMAV, 
        // para el periodo al que pertenece esa Matriz de Facturación. 
        Long oidMatrizFacturacion = dto.getCodigoVenta();
        Long oidDetalleMAV = dto.getOid();
        Boolean yaExisteEnvio = yaExisteEnvio(oidMatrizFacturacion, oidDetalleMAV);
        DTOProcesoDetalleMAV procesoDetalleMAV = null;
        if ( yaExisteEnvio.booleanValue() ) {
            procesoDetalleMAV = new DTOProcesoDetalleMAV();
            procesoDetalleMAV.setNumeroClientes( new Long(0) );
            procesoDetalleMAV.setNumeroUnidadesEnviadas( new Long(0) );
        } else {
            UtilidadesLog.debug("Antes de llamar a elaborarListaClientes()");
            RecordSet listaCliente = this.elaborarListaClientes(dto, simulacion);
            UtilidadesLog.debug("Despues de llamar a elaborarListaClientes()");  
            Long numeroUnidadesEnviadas = this.obtenerNumeroUnidadesEnviadas(dto, listaCliente, peirodo, actividad, simulacion);
            UtilidadesLog.debug("Despues de obtenerNumeroUnidadesEnviadas");
            
            // sapaza -- PER-SiCC-2010-0578 -- 06/10/2010
            /* 
             * Modificacion por ssantana, 25/1/2005
             * Si el Criterio de Asignacion es por Atributos, entonces no
             * se debe llamar a this.actualizarStock() ya que no se genera envio alguno.
             */
            /*if( (numeroUnidadesEnviadas != null) && 
                (numeroUnidadesEnviadas.longValue() > 0) && 
                (simulacion.booleanValue() == false) && 
                ( (dto.getCriterioAsignacion() == null ) ||
                  (dto.getCriterioAsignacion().intValue() != ConstantesMAV.CRITERIO_ASIGNA_ATRIBUTOS )) )  
            {
                UtilidadesLog.debug("Antes de ActualizarStock()");
                this.actualizarStock(dto, numeroUnidadesEnviadas);
                UtilidadesLog.debug("Despues de ActualizarStock()");            
            }*/
    
            // Por incidencia 10066, se cambia operador del sig. if, de
            //   "dto.getCriterioAsignacion().intValue() == ConstantesMAV.CRITERIO_ASIGNA_ATRIBUTOS"
            // a 
            //   "dto.getCriterioAsignacion().intValue() != ConstantesMAV.CRITERIO_ASIGNA_ATRIBUTOS)"
            // ---------------------------------------------------------------------------------------
            // Modificacion hecha por ssantana, 18/11/2004
            
            UtilidadesLog.debug("dto.getCriterioAsignacion(): " + dto.getCriterioAsignacion());
            UtilidadesLog.debug("Simulacion: " + simulacion.booleanValue());
            if( (dto.getCriterioAsignacion() == null ||
                 dto.getCriterioAsignacion().intValue() != ConstantesMAV.CRITERIO_ASIGNA_ATRIBUTOS) &&
                (simulacion.booleanValue() == false)) 
            { 
                UtilidadesLog.debug("Entra al if");
                try {
                    DetalleMAVLocalHome detalleLH = getDetalleMAVLocalHome();
                    DetalleMAVLocal detalleL = detalleLH.findByPrimaryKey(dto.getOid());
                    
                    /*
                     * Modificado por ssantana, 1/8/2005
                     * Solo se cambia el estado del DetalleMAV en dos casos:
                     *  1- Es un DetalleMAV solo con Periodo Inicio.
                     *  2- Es un DetalleMAV con Período Fin, se está procesando
                     *     el envío para el dicho Período Fin.
                     *     
                     */
                     
                    Integer constan = null;
                    /*Long periodoFinalDetalleMAV = dto.getPeriodoFin();
                    Long periodoInicioDetalleMAV = dto.getPeriodo();*/
                    
                    constan = new Integer(ConstantesMAV.T_ESTAD_PROCESO_GENERADO);
                    detalleL.setOidEstadoProceso(new Long(constan.longValue()) );                  
                    
                } catch(FinderException e) {
                    UtilidadesLog.error(e);
                    ctx.setRollbackOnly();
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
            }
    
            procesoDetalleMAV = new DTOProcesoDetalleMAV();
            Integer filas = new Integer(listaCliente.getRowCount());
            procesoDetalleMAV.setNumeroClientes(new Long(filas.longValue()));
            procesoDetalleMAV.setNumeroUnidadesEnviadas(numeroUnidadesEnviadas);
            UtilidadesLog.debug("procesoDetalleMAV: " + procesoDetalleMAV);
        }
        UtilidadesLog.info("MONRegistroMAVBean.procesarLineaDetalleMAV(DTODetalleMAV dto, Long peirodo, Long actividad, Boolean simulacion):Salida");
        return procesoDetalleMAV;        
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


    private MaestroProductosLocalHome getMaestroProductosLocalHome()
        throws NamingException {
        final InitialContext context = new InitialContext();
        return (MaestroProductosLocalHome)context.lookup("java:comp/env/MaestroProductos");
    }


    public Boolean validarVinculosAgrupacionEnvioMAV(DTOAgrupacionEnvios dtoAgrupacion)
        throws MareException {
        UtilidadesLog.info("MONRegistroMAVBean.validarVinculosAgrupacionEnvioMAV(DTOAgrupacionEnvios dtoAgrupacion):Entrada");
        DAORegistrosMAV daoReg = new DAORegistrosMAV();
        DTOSalida dtoSalida = daoReg.obtenerAgrupacionEnviosMAV(dtoAgrupacion);
        RecordSet r = dtoSalida.getResultado();
        UtilidadesLog.debug("Recordset r: " + r);

        MONValidacionHome monVHome = null;
        MONValidacion monV = null;

        try {
            monVHome = this.getMONValidacionHome();
            monV = monVHome.create();
        } catch(NamingException nEx) {
            UtilidadesLog.debug("Naming Exception");
            UtilidadesLog.error(nEx);
            throw new MareException(nEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(RemoteException rEx) {
            UtilidadesLog.debug("Remote Exception");
            UtilidadesLog.error(rEx);
            throw new MareException(rEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException cEx) {
            UtilidadesLog.debug("Create Exception");
            UtilidadesLog.error(cEx);
            throw new MareException(cEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        for(int i = 0; i < r.getRowCount(); i++) {
            UtilidadesLog.debug("Bucle " + i);
            Long pais = new Long(((BigDecimal)r.getValueAt(i, 0)).longValue());
            Long marca = new Long(((BigDecimal)r.getValueAt(i, 1)).longValue());
            Long canal = new Long(((BigDecimal)r.getValueAt(i, 2)).longValue());
            Boolean retorno = null;

            try {
                retorno = monV.validarAccesos(pais, null, marca, canal, null, null, null, null, null, null, null);
            } catch(RemoteException rEx) {
                UtilidadesLog.error(rEx);
                throw new MareException(rEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }

            if(retorno.booleanValue() == false) {
                UtilidadesLog.debug("Devuelve FALSE");
                UtilidadesLog.info("MONRegistroMAVBean.validarVinculosAgrupacionEnvioMAV(DTOAgrupacionEnvios dtoAgrupacion):Salida");
                return Boolean.FALSE;
            }
        }

        UtilidadesLog.debug("Devuelve TRUE");
        UtilidadesLog.info("MONRegistroMAVBean.validarVinculosAgrupacionEnvioMAV(DTOAgrupacionEnvios dtoAgrupacion):Salida");
        return Boolean.TRUE;
    }

    public Boolean validarVinculosEnvioMAV(Long oid) throws MareException {
        UtilidadesLog.info("MONRegistroMAVBean.validarVinculosEnvioMAV(Long oid):Entrada");
        EnvioMAVLocalHome envioMAVLocalH = null;
        EnvioMAVLocal envioMAVLocal = null;
        DetalleMAVLocalHome detalleMAVLocalH = null;
        DetalleMAVLocal detalleMAVLocal = null;
        PeriodoLocalHome periodoLocalH = null;
        PeriodoLocal periodoLocal = null;

        MONValidacionHome monValidacionH = null;
        MONValidacion monValidacion = null;

        UtilidadesLog.debug("EnvioMAVLocal");

        try {
            envioMAVLocalH = new EnvioMAVLocalHome();
            envioMAVLocal = envioMAVLocalH.findByPrimaryKey(oid);
        } catch(NoResultException fEx) {
            UtilidadesLog.debug("Finder Exception en findByPrimaryKey() de EnvioMALLocal");
            UtilidadesLog.error(fEx);
            throw new MareException(fEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        Long oidDetalle = envioMAVLocal.getOidDetalleMAV();

        if(oidDetalle == null)
            UtilidadesLog.debug("oidDetalle es null");
        else
            UtilidadesLog.debug("OidDetalle: " + oidDetalle.toString());

        try {
            detalleMAVLocalH = this.getDetalleMAVLocalHome();
            detalleMAVLocal = detalleMAVLocalH.findByPrimaryKey(oidDetalle);
        } catch(FinderException fEx) {
            UtilidadesLog.debug("Finder Exception en findByPrimaryKey() de EnvioMALLocal");
            UtilidadesLog.error(fEx);
            throw new MareException(fEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        Long oidPeriodo = detalleMAVLocal.getOidPeriodo();

        if(oidPeriodo == null)
            UtilidadesLog.debug("oidPeriodo es null");
        else
            UtilidadesLog.debug("oidPeriodo: " + oidPeriodo.toString());

        try {
            periodoLocalH = new PeriodoLocalHome();
            periodoLocal = periodoLocalH.findByPrimaryKey(oidPeriodo);
        } catch(NoResultException fEx) {
            UtilidadesLog.debug("Finder Exception en findByPrimaryKey() de PeriodoLocalHome");
            UtilidadesLog.error(fEx);
            throw new MareException(fEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        UtilidadesLog.debug("Realizo finder periodo");
        Long oidPais = periodoLocal.getOidPais();
        Long oidMarca = periodoLocal.getOidMarca();
        Long oidCanal = periodoLocal.getOidCanal();
        Boolean valorBooleano = null;

        try {
            monValidacionH = this.getMONValidacionHome();
            monValidacion = monValidacionH.create();
            valorBooleano = monValidacion.validarAccesos(oidPais, null, oidMarca, oidCanal, null, null, null, null, null, null, null);
        } catch(NamingException nEx) {
            UtilidadesLog.error(nEx);
            throw new MareException(nEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException cEx) {
            UtilidadesLog.error(cEx);
            throw new MareException(cEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(RemoteException rEx) {
            UtilidadesLog.error(rEx);
            throw new MareException(rEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONRegistroMAVBean.validarVinculosEnvioMAV(Long oid):Salida");
        return valorBooleano;
    }

    private MONValidacionHome getMONValidacionHome() throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONValidacionHome)PortableRemoteObject.narrow(context.lookup("MONValidacion"), MONValidacionHome.class);
    }

    public DTOLineaCombo recuperarTipoClienteActividad(DTOOID dto)
        throws MareException {
        UtilidadesLog.info("MONRegistroMAVBean.recuperarTipoClienteActividad(DTOOID dto):Entrada");
        try {
            /*Proceso: 
-> Tomar el valor de dto.oid y hacer findByPrimaryKey sobre la entidad ActividadesMAV 
-> Crear variable llamada "respuesta" de tipo "DTOLineaCombo" 
-> respuesta.oid = ActividadesMAV.oidTipoCliente 
-> respuesta.descripcion = descripción internacionalizada del tipo de cliente tomando el valor de ActividadesMAV.oidTipoCliente 
-> Devolver "respuesta"*/

            ActividadesMAVLocalHome amavlh = new ActividadesMAVLocalHome();
            ActividadesMAVLocal acti = amavlh.findByPrimaryKey(dto.getOid());
            DTOLineaCombo respuesta = new DTOLineaCombo();
            respuesta.setOid(acti.getOidTipoCliente());
            Entidadi18nLocalHome ei18nlh = new Entidadi18nLocalHome();
            Entidadi18nLocal i18n = ei18nlh.findByEntAtrIdioPK("MAE_TIPO_CLIEN", new Long(1),
                    dto.getOidIdioma(), acti.getOidTipoCliente());
            respuesta.setDescripcion(i18n.getDetalle());
            UtilidadesLog.info("MONRegistroMAVBean.recuperarTipoClienteActividad(DTOOID dto):Salida");
            return respuesta;
        } catch(NoResultException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } /*catch(Exception e) {
            ctx.setRollbackOnly();
            e.printStackTrace();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }*/
    }


    private MONGenerarMensajesHome getMONGenerarMensajesHome()
        throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONGenerarMensajesHome)PortableRemoteObject.narrow(context.lookup("MONGenerarMensajes"), MONGenerarMensajesHome.class);
    }

    private MONServicioCorreoElectronicoHome getMONServicioCorreoElectronicoHome()
        throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONServicioCorreoElectronicoHome)PortableRemoteObject.narrow(context.lookup("MONServicioCorreoElectronico"),
            MONServicioCorreoElectronicoHome.class);
    }

    private MONEnvioIniFinPeriodoHome getMONEnvioIniFinPeriodoHome()
        throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONEnvioIniFinPeriodoHome)PortableRemoteObject.narrow(context.lookup("MONEnvioIniFinPeriodo"),
            MONEnvioIniFinPeriodoHome.class);
    }


    private MONClientesHome getMONClientesHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONClientesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONClientes"), MONClientesHome.class);
  }
  
  
  /**
   * @author: ssantana, 19/7/2005, inc. BELC300018229
   * @throws es.indra.mare.common.exception.MareException
   * @return Long   
   */
  private Long obtienePaisDetalleMAV(DTODetalleMAV dtoDetalleMAV) throws MareException {
     // Busca el pais correspondiente al período del detalleMAV
     UtilidadesLog.info("MONRegistroMAVBean.recuperarTipoClienteActividad(DTOOID dto):Entrada");
     Long oidPeriodo = dtoDetalleMAV.getPeriodo();
     Long oidPais = null;
     
     try {
        PeriodoLocalHome periodoLocalHome = new PeriodoLocalHome();
        PeriodoLocal periodoLocal = periodoLocalHome.findByPrimaryKey(oidPeriodo);
        oidPais = periodoLocal.getOidPais();
     }  catch (NoResultException fEx) {
        UtilidadesLog.error(fEx);
        String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;        
        throw new MareException(fEx, UtilidadesError.armarCodigoError(codigoError));
     }
     UtilidadesLog.info("MONRegistroMAVBean.recuperarTipoClienteActividad(DTOOID dto):Salida");
     return oidPais;
  }
  
  
  
  
  
  /**
   * @author: ssantana, 1/8/2005
   * @throws es.indra.mare.common.exception.MareException
   * @return Boolean
   */
  private Boolean existeEnvioAnterior(Long oidDetalleMAV, Long oidPeriodo, Long oidPais, Long oidMarca, Long oidCanal) throws MareException {
     /*
      * Verifica si ya existe un Envío generado para el DetalleMAV de entrada, durante 
      * el Período especificado. 
      */
      UtilidadesLog.info("MONRegistroMAVBean.existeEnvioAnterior(Long oidDetalleMAV, Long oidPeriodo, Long oidPais, Long oidMarca, Long oidCanal):Entrada");
      StringBuffer sqlQuery = new StringBuffer(""); 
      Boolean bRetorno = null;
      
      sqlQuery.append(" SELECT COUNT (mav_envio.oid_envi) ");
      sqlQuery.append(" FROM mav_envio ");
      sqlQuery.append(" WHERE mav_envio.denv_oid_deta_mav = " + oidDetalleMAV);
      sqlQuery.append(" AND " + oidPeriodo + " IN ( ");
      sqlQuery.append(" SELECT cra_perio.oid_peri ");
      sqlQuery.append(" FROM cra_perio ");
      sqlQuery.append(" WHERE mav_envio.fec_entr BETWEEN cra_perio.fec_inic ");
      sqlQuery.append(" AND cra_perio.fec_fina ");
      sqlQuery.append(" AND cra_perio.pais_oid_pais = " + oidPais);
      sqlQuery.append(" AND cra_perio.marc_oid_marc = " + oidMarca);
      sqlQuery.append(" AND cra_perio.cana_oid_cana = " + oidCanal + ") ");   
      
      
      try { 
         BelcorpService bs = BelcorpService.getInstance();
         RecordSet r = bs.dbService.executeStaticQuery(sqlQuery.toString());
         UtilidadesLog.debug("r: " + r);
         
         BigDecimal bigBuffer = (BigDecimal) r.getValueAt(0,0);
         if (bigBuffer.longValue() > 0) {
            bRetorno = Boolean.valueOf(true);
         } else {
            bRetorno = Boolean.valueOf(false);
         }
         
      } catch (Exception ex) {
         UtilidadesLog.error(ex);
         String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;        
         throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
      }
      UtilidadesLog.info("MONRegistroMAVBean.existeEnvioAnterior(Long oidDetalleMAV, Long oidPeriodo, Long oidPais, Long oidMarca, Long oidCanal):Salida");
      return bRetorno;
  }

  public DTODetalleMAV comprobarCodigoVenta(DTODetalleMAV dto, Long oidPeriodo) throws MareException {
        long comienzo = System.currentTimeMillis();
        UtilidadesLog.info("MONRegistroMAVBean.comprobarCodigoVenta(DTODetalleMAV dto, Long oidPeriodo):Entrada");
        
        DTODetalleMAV dtoRetorno = null;
        
        if(dto.getCodigoVenta() == null) {
            //Mapeos en base a incidencia 8779
            DTOEValidarProducto producto = new DTOEValidarProducto();
            producto.setOidIdioma(dto.getOidIdioma());
            producto.setIpCliente(dto.getIpCliente());
            producto.setPrograma(dto.getPrograma());
            producto.setOidPais(dto.getOidPais());
            producto.setPais(dto.getOidPais()); // Agregado 17/8/2005.
            producto.setMarca(dto.getMarca());
            producto.setCanal(dto.getCanal());

            if((dto.getSubaccesos() != null) && (dto.getSubaccesos().length > 0) && (dto.getSubaccesos()[0] != null)) {
                try {
                    SubaccesoLocalHome subacLocalHome = new SubaccesoLocalHome();                    
                    SubaccesoLocal subacLocal = subacLocalHome.findByPrimaryKey(dto.getSubaccesos()[0]);

                    producto.setOidSubacceso(subacLocal.getOid());
                    producto.setOidAcceso(subacLocal.getOidAcceso());
                } catch(NoResultException fe) {
                    UtilidadesLog.debug("NO se encontró subacceso: " + dto.getSubaccesos()[0]);
                } 
            }

            // Modificado por ssantana, 1/8/2005, inc. BELC300015618
            //producto.setPeriodo(dto.getPeriodo());
            //producto.setPeriodoFin(dto.getPeriodoFin());
            producto.setPeriodo(oidPeriodo);
            // Fin Modificacion ssantana, 1/18/2005, inc. BELC300015618
            
            producto.setTipoOferta(dto.getTipoOferta());
            producto.setCicloVida(dto.getCicloVida());
            producto.setFormaPago(dto.getFormaPago());

            if(dto.getProducto() != null) {
                try {
                    MaestroProductosLocalHome maeProdLocalHome = getMaestroProductosLocalHome();
                    maeProdLocalHome.parametrosAuditoria(dto);
                    MaestroProductosPK mpPK = new MaestroProductosPK(dto.getProducto());
                    MaestroProductosLocal maeProdLocal = maeProdLocalHome.findByPrimaryKey(mpPK);

                    producto.setCodigoSAP(maeProdLocal.getCodigoSAP());
                } catch(FinderException fe) {
                    UtilidadesLog.debug("NO se encontró producto: " + dto.getProducto());
                } catch(NamingException fe) {
                    UtilidadesLog.error(fe);
                    ctx.setRollbackOnly();
                    throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
            }

            producto.setPrecioCatalogo(dto.getPrecio());
            producto.setPrecioContable(dto.getPrecioContable());

            MONCargaMantenimientoListasHome monCMHome = null;
            MONCargaMantenimientoListas monCM = null;

            try {
                monCMHome = (MONCargaMantenimientoListasHome)UtilidadesEJB.getHome("MONCargaMantenimientoListas",
                        MONCargaMantenimientoListasHome.class);
                monCM = monCMHome.create();
                UtilidadesLog.debug("Se encontro MONCargaMantenimientoListasHome");
            } catch(RemoteException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch(CreateException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            DTOSProductoValidado productoValidado = null;

            try {
                UtilidadesLog.debug("EEEEEE DTOEValidarProducto: " + producto);
                productoValidado = monCM.validarProductos(producto);
            } catch(MareException ne) {
                UtilidadesLog.error(ne);
                throw ne;
            } catch(Exception ex) {
                UtilidadesLog.error(ex);
                //BelcorpService bs = BelcorpService.getInstance();
                //bs.appLog.error("MAV:Generar Información MAV: " + ex.getMessage());
                LogAPP.error("MAV:Generar Información MAV: " + ex.getMessage());
                
                // Agregado por ssantana, 2/8/2005 
                // Creo que se debería patear la excepción para arriba, además...
                String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));          
            }

            MONMantenimientoMFHome monMFHome = null;
            MONMantenimientoMF monMF = null;
            DTOSalida dtoS = null;

            try {
                monMFHome = (MONMantenimientoMFHome)UtilidadesEJB.getHome("MONMantenimientoMF", MONMantenimientoMFHome.class);
                monMF = monMFHome.create();
                UtilidadesLog.debug("Se encontro MONMantenimientoMFHome");

                DTOBuscarCodigoVentaPeriodo dtoBC = new DTOBuscarCodigoVentaPeriodo();
                
                // Modificado por ssantana, 1/8/2005, inc. BELC300015618}
                //dtoBC.setPeriodo(dto.getPeriodo());
                dtoBC.setPeriodo(oidPeriodo);
                // Fin Modificacion por ssantana, 1/8/2005, inc. BELC300015618
                dtoBC.setCodigoVenta(productoValidado.getCodigoVenta());
                dtoS = monMF.buscarCodigoVentaPeriodo(dtoBC);
            } catch(RemoteException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch(CreateException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            //  El RecordSet obtenido de la llamada anterior tiene un único registro, con un oid de detalle de oferta
            Long oidDetalleOferta = 
                    Long.valueOf(dtoS.getResultado().getValueAt(0, "OID").toString());

            try {
                MatrizFacturacionLocalHome matrizLocalHome = 
                        new MatrizFacturacionLocalHome();
                CabeceraMFLocalHome cabeceraMFLocalHome = 
                        new CabeceraMFLocalHome();
                
                CabeceraMFLocal cabeceraMFLocal = 
                        cabeceraMFLocalHome.findByUK(oidPeriodo);
                        
                Long oidCabecera = cabeceraMFLocal.getOid();
                
                MatrizFacturacionLocal matrizLocal = 
                        matrizLocalHome.findByUK(oidCabecera, 
                                                 oidDetalleOferta);
                
                Long oidMatrizFacturacion = matrizLocal.getOid();

                // Modificado por ssantana, 2/8/2005, inc. 15618
                // No existe más el atributo OidMAtrizFacturacion en MAV_DETAL_MAV
                /*DetalleMAVLocalHome detaLocalHome = getDetalleMAVLocalHome();
                detaLocalHome.parametrosAuditoria(dto);
                DetalleMAVLocal detaLocal = detaLocalHome.findByPrimaryKey(dto.getOid());

                detaLocal.setOidMatrizFacturacion(oidMatrizFacturacion);*/
                // Fin Modificacion por ssantana, 2/8/2005, inc. 15618
                
                dto.setCodigoVenta(oidMatrizFacturacion);
                dtoRetorno = dto;
                
            } catch(NoResultException fe) {
                UtilidadesLog.error(fe);
                ctx.setRollbackOnly();
                throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } 
        }
        UtilidadesLog.info("MONRegistroMAVBean.comprobarCodigoVenta(DTODetalleMAV dto, Long oidPeriodo):Salida");
        UtilidadesLog.warn("comprobarCodigoVenta: FIN ---> " + (System.currentTimeMillis() - comienzo));        
        return dtoRetorno;
  
  }
  
  
  /**
   * @author: ssantana, 17/8/2005
   * @throws es.indra.mare.common.exception.MareException
   * @return Object[] 
   * @param  dto
   */
  private Object[] leeMareDTO(MareDTO dto) throws MareException {
     UtilidadesLog.info("MONRegistroMAVBean.leeMareDTO(MareDTO dto):Entrada");
     
     Object[] retorno = new Object[9];
     try { 
         String sPropPais = null;
         String sPropMarca = null;
         String sPropCanal = null;
         String sPropPeriodo = null;
         Long pais = null;
         Long marca = null;     
         Long canal = null;
         Long periodo = null;
         Long actividad = null;
         Long tipoCliente = null;
         String ipCliente = "";
         String programa = "";
         Long idioma = null;
         
         if (dto instanceof DTOFACProcesoCierre) {
             UtilidadesLog.debug("Casteo a DTOFACProcesoCierre");
             DTOFACProcesoCierre dtoFac = (DTOFACProcesoCierre) dto;
             pais = dtoFac.getOidPais();
             marca = dtoFac.getMarca();
             canal = dtoFac.getCanal();
             periodo = dtoFac.getPeriodo();
             idioma = dtoFac.getOidIdioma();
             programa = dtoFac.getPrograma();
         } else {
             /*
              * Agregado por ssantana, 15/05/2006
              * En FAC se genera un MAREDTO a partir de "DTOFACProcesoCierre". Los 
              * atributos del DTO tienen un nombre distinto a los de "Generar Inf. MAV"
              */ 
              UtilidadesLog.debug("Manejo entrada como MareDTO");
              if (dto.containsKey("pais") ) {
                 sPropPais = "pais";
              } else if (dto.containsKey("oidPais")) {
                 sPropPais = "oidPais";
              } 
              
              UtilidadesLog.debug("Nombre Propiedad Pais: " + sPropPais);
              
              if (dto.containsKey("marca") ) {
                 sPropMarca = "marca";
              } else if (dto.containsKey("oidMarca")) {
                 sPropMarca = "oidMarca";
              }
              
              if (dto.containsKey("canal")) {
                 sPropCanal = "canal";
              } else if (dto.containsKey("oidCanal")) {
                 sPropCanal = "oidCanal";
              }
              
              if (dto.containsKey("periodo")) {
                 sPropPeriodo = "periodo";
              } else if (dto.containsKey("oidPeriodo")) {
                 sPropPeriodo = "oidPeriodo";
              }
             
             
             /* Modificado por ssantana, 15/05/2005 */
             UtilidadesLog.debug("dto.getProperty(sPropPais): " + dto.getProperty(sPropPais));
             if (sPropPais != null && dto.getProperty(sPropPais) != null) {
                 pais = (Long)dto.getProperty(sPropPais);
                 UtilidadesLog.debug("Obtuvo pais: " + pais);
             }
             
             if (sPropMarca != null && dto.getProperty(sPropMarca) != null) {
                marca = (Long)dto.getProperty(sPropMarca);
             }
             
             if (sPropCanal != null && dto.getProperty(sPropCanal) != null) {
                canal = (Long)dto.getProperty(sPropCanal);
             }
        
             if (sPropPeriodo != null && dto.getProperty(sPropPeriodo) != null) {
                periodo = (Long)dto.getProperty(sPropPeriodo);
             }
             
             if(dto.containsKey("oidActividad") && (dto.getProperty("oidActividad") != null))
                actividad = (Long)dto.getProperty("oidActividad");
                
             if (dto.containsKey("oidTipoCliente") && (dto.getProperty("oidTipoCliente") != null))
                tipoCliente = (Long)dto.getProperty("oidTipoCliente");
                
             if (dto.containsKey("ipCliente")  && (dto.getProperty("ipCliente") != null ) )
                ipCliente = (String) dto.getProperty("ipCliente");
                
             if (dto.containsKey("programa") && (dto.getProperty("programa") != null) )
                programa = (String) dto.getProperty("programa");
                
             if ( dto.containsKey("oidIdioma") && (dto.getProperty("oidIdioma") != null) )
                idioma = (Long) dto.getProperty("oidIdioma");
         }
         UtilidadesLog.debug("pais: " + pais);
         UtilidadesLog.debug("marca: " + marca);
         UtilidadesLog.debug("canal: " + canal);
         UtilidadesLog.debug("periodo: " + periodo);
         UtilidadesLog.debug("actividad: " + actividad);
         UtilidadesLog.debug("tipoCliente: " + tipoCliente);
         UtilidadesLog.debug("ipCliente: " + ipCliente);
         UtilidadesLog.debug("programa: " + programa);
         UtilidadesLog.debug("idioma: " + idioma);
         retorno[0] = pais;
         retorno[1] = marca;
         retorno[2] = canal;     
         retorno[3] = periodo;
         retorno[4] = actividad;
         retorno[5] = tipoCliente;
         retorno[6] = ipCliente;
         retorno[7] = programa;
         retorno[8] = idioma;
     
     } catch (Exception ex) {
         UtilidadesLog.error(ex);
     }
     UtilidadesLog.info("MONRegistroMAVBean.leeMareDTO(MareDTO dto):Salida");
     return retorno;
     
  }
  
  /**
   * @author: ssantana, 4/8/2005
   * @throws es.indra.mare.common.exception.MareException
   * @return Boolean 
   * @param  oidDetalleMAV
   * @param  oidMatrizFacturacion
   */
  private Boolean yaExisteEnvio(Long oidMatrizFacturacion, Long oidDetalleMAV)
         throws MareException {
     /*
      *  Determina que no haya otro envío para ese DetalleMAV en ese período, 
      *  para ese Cliente y con esa Matriz de Facturacion.
      */
      UtilidadesLog.info("MONRegistroMAVBean.yaExisteEnvio(Long oidMatrizFacturacion, Long oidDetalleMAV):Entrada");
      Boolean existeEnvio = Boolean.FALSE;
    
      try { 
         
         
         // Se fija si ya existe algún Envío anterior para ese DetalleMAV, 
         // para el periodo al que pertenece esa Matriz de Facturación. 
         StringBuffer sqlQuery = new StringBuffer("");
         
         sqlQuery.append(" SELECT COUNT (mav_envio.oid_envi) ");
         sqlQuery.append(" FROM mav_envio, pre_matri_factu, pre_matri_factu_cabec ");
         sqlQuery.append(" WHERE mav_envio.mafa_oid_matr_fact = pre_matri_factu.oid_matr_fact ");
         sqlQuery.append(" AND pre_matri_factu.mfca_oid_cabe = pre_matri_factu_cabec.oid_cabe ");
         sqlQuery.append(" AND pre_matri_factu_cabec.perd_oid_peri = ");
         sqlQuery.append("            (SELECT pre_matri_factu_cabec.perd_oid_peri ");
         sqlQuery.append("             FROM pre_matri_factu, pre_matri_factu_cabec "); 
         sqlQuery.append("             WHERE pre_matri_factu.oid_matr_fact = " + oidMatrizFacturacion);
         sqlQuery.append("                AND pre_matri_factu.mfca_oid_cabe = "); 
         sqlQuery.append("                    pre_matri_factu_cabec.oid_cabe) ");
         sqlQuery.append(" AND mav_envio.denv_oid_deta_mav = " + oidDetalleMAV);
        
         RecordSet r = null;
         BelcorpService bs = BelcorpService.getInstance();
         r = bs.dbService.executeStaticQuery( sqlQuery.toString() );
         
         UtilidadesLog.debug("r: " + r);
         
         BigDecimal bigCantRegistros = (BigDecimal)r.getValueAt(0,0);
         if ( bigCantRegistros.longValue() > 0)  {
            UtilidadesLog.debug("Ya existe al menos un Envío para el DetalleMAV " + oidDetalleMAV + 
                               " para el periodo de la matriz de Facturacion " + oidMatrizFacturacion + 
                               " - NO SE GENERA ENVIO para este periodo");
            existeEnvio = Boolean.TRUE;
         }
         
      } catch (Exception ex) {
         UtilidadesLog.error(ex);
         String sCodigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
      }
      UtilidadesLog.info("MONRegistroMAVBean.yaExisteEnvio(Long oidMatrizFacturacion, Long oidDetalleMAV):Salida");
      return existeEnvio;
  }
  
  
  /**
   * @author: ssantana, 09/01/2006, inc. BELC300021972
   * @throws es.indra.mare.common.exception.MareException
   * @return Boolean
   * @param  oidSubtipo
   * @param  subtipos
   */
  private Boolean tieneSubtipo(Long[] subtipos, Long oidSubtipo) 
          throws MareException {
     Boolean bRetorno = Boolean.FALSE;
     boolean bMatch = false;
     
     int cantElem = subtipos.length;
     for (int i = 0; (i < cantElem) && (!bMatch); i++ ) {
     
        Long oidElem = subtipos[i]; 
        if (oidElem.equals(oidSubtipo) ) {
          bMatch = true;
          bRetorno = Boolean.TRUE;
        }
     }
     return bRetorno;
  }


    private MONEnvioIniFinPeriodoLocalHome getMONEnvioIniFinPeriodoLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONEnvioIniFinPeriodoLocalHome)context.lookup("java:comp/env/ejb/local/MONEnvioIniFinPeriodo");
    }

    public void generarEnviosMasivos(DTODetalleMAV[] dto, Long periodo, Long cliente) throws MareException{
        UtilidadesLog.info("MONRegistroMAVBean.generarEnviosMasivos(DTODetalleMAV[] dto, Long periodo, Long cliente):Entrada");
        try {
            
            StringBuffer buf = new StringBuffer();
            buf.append("SELECT sub.pais_oid_pais, sub.marc_oid_marc, sub.cana_oid_cana, ");
            buf.append("oid_subg_vent, oid_regi, oid_zona, oid_secc, terr_oid_terr, ");
            buf.append("t.cod_nse1, t.cod_nse2, t.cod_nse3, oid_terr_admi ");
            buf.append("FROM mae_clien_unida_admin unid, zon_terri_admin tadm, zon_terri t, zon_secci, zon_zona, zon_regio, zon_sub_geren_venta sub ");
            buf.append("WHERE unid.clie_oid_clie = "+cliente.toString()+ " AND unid.PERD_OID_PERI_FIN is null AND ");
            buf.append("ztad_oid_terr_admi = oid_terr_admi AND terr_oid_terr = oid_terr  AND zscc_oid_secc = oid_secc ");
            buf.append("AND zzon_oid_zona = oid_zona  AND zorg_oid_regi = oid_regi AND zsgv_oid_subg_vent = oid_subg_vent "); 
            buf.append("AND ROWNUM = 1");
            
            RecordSet salida = BelcorpService.getInstance().dbService.executeStaticQuery(buf.toString());
            DTOUnidadAdministrativa unidadAdministrativa = null;
            if(!salida.esVacio()){
                //aunque luego se use solamente la zona, completo el dto. (GAcevedo)
                unidadAdministrativa = new DTOUnidadAdministrativa();
                if(salida.getValueAt(0,"COD_NSE1")!=null){
                    unidadAdministrativa.setNSE1(salida.getValueAt(0,"COD_NSE1").toString());
                }
                if(salida.getValueAt(0,"COD_NSE2")!=null){
                    unidadAdministrativa.setNSE2(salida.getValueAt(0,"COD_NSE2").toString());
                }
                if(salida.getValueAt(0,"COD_NSE3")!=null){
                    unidadAdministrativa.setNSE3(salida.getValueAt(0,"COD_NSE3").toString());
                }
                if(salida.getValueAt(0,"CANA_OID_CANA")!=null){
                    unidadAdministrativa.setOidCanal(new Long(salida.getValueAt(0,"CANA_OID_CANA").toString()));
                }
                unidadAdministrativa.setOidCliente(cliente);
                if(salida.getValueAt(0,"MARC_OID_MARC")!=null){
                    unidadAdministrativa.setOidMarca(new Long(salida.getValueAt(0,"MARC_OID_MARC").toString()));
                }
                if(salida.getValueAt(0,"PAIS_OID_PAIS")!=null){
                    unidadAdministrativa.setOidPais(new Long(salida.getValueAt(0,"PAIS_OID_PAIS").toString()));    
                }
                if(salida.getValueAt(0,"OID_REGI")!=null){
                    unidadAdministrativa.setOidRegion(new Long(salida.getValueAt(0,"OID_REGI").toString()));
                }
                if(salida.getValueAt(0,"OID_SECC")!=null) {
                    unidadAdministrativa.setOidSeccion(new Long(salida.getValueAt(0,"OID_SECC").toString()));    
                }
                if(salida.getValueAt(0,"OID_SUBG_VENT")!=null){
                    unidadAdministrativa.setOidSGV(new Long(salida.getValueAt(0,"OID_SUBG_VENT").toString()));
                }
                if(salida.getValueAt(0,"TERR_OID_TERR")!=null){
                    unidadAdministrativa.setOidTerritorio(new Long(salida.getValueAt(0,"TERR_OID_TERR").toString()));
                }
                if(salida.getValueAt(0,"OID_TERR_ADMI")!=null){
                    unidadAdministrativa.setOidTerritorioAdministrativo(new Long(salida.getValueAt(0,"OID_TERR_ADMI").toString()));    
                }
                if(salida.getValueAt(0,"OID_ZONA")!=null){
                    unidadAdministrativa.setOidZona(new Long(salida.getValueAt(0,"OID_ZONA").toString()));    
                }
            }
            UtilidadesLog.debug("unidadAdministrativa: " + unidadAdministrativa);
            
            if (unidadAdministrativa == null ) {
               UtilidadesLog.debug("No se encontró Unidad Administrativa para Cliente " + cliente);
               UtilidadesLog.debug(" - periodo " + periodo + " --- NO SE GENERA ENVIO");
            } else {
                buf = new StringBuffer();
                RecordSet r = obtenerLimiteAutorizacion(periodo);
                boolean requiereAutorizacion = (r.getValueAt(0,0).toString().equals("0")?false:true);
                double limite = new Double(r.getValueAt(0,1).toString()).doubleValue();
                for (int i = 0 ; i < dto.length ; i++){
                    DTOEnvioMAV envioMAV = new DTOEnvioMAV();
                    DTODetalleMAV dtoDetalleMav = dto[i];
                    if (dtoDetalleMav.getValidado()){
                        Long lngUnidadesEnvio = new Long(0);
                        if (dtoDetalleMav.getUnidadesPorCliente() != null) {
                            lngUnidadesEnvio = new Long(dtoDetalleMav.getUnidadesPorCliente().longValue());
                        }
                
                        envioMAV.setNumeroUnidades(lngUnidadesEnvio);
                        
                        if ( requiereAutorizacion ) {
                           if (!dtoDetalleMav.getFormaCobro().equals(ConstantesMAV.FORMA_COBRO_GRATIS))
                              envioMAV.setTipoEstadoEnvio(ConstantesMAV.ESTADO_ENVIO_PENDIENTE);
                           else 
                              envioMAV.setTipoEstadoEnvio(ConstantesMAV.ESTADO_ENVIO_SIN_AUTORIZACION);
                              
                        } else {
                           double detalleMAVPrecio = dtoDetalleMav.getPrecio().doubleValue();
                           
                           if (detalleMAVPrecio > limite ) 
                              envioMAV.setTipoEstadoEnvio(ConstantesMAV.ESTADO_ENVIO_PENDIENTE);
                           else
                              envioMAV.setTipoEstadoEnvio(ConstantesMAV.ESTADO_ENVIO_SIN_AUTORIZACION);
                        }
                        
                        //Long zonaUA = unidadAdministrativa.getOidZona();
                        //java.util.Date fechaEntrega = monEnvio.obtenerFechaEntrega(periodo, zonaUA);
                        // Modificado por ssantana, 20/1/2005
                        // monEnvio.obtenerFechaEntrega(periodo) puede retornar NULL, asi que se tiene eso
                        // en cuenta. 
                        // 5/4/2005 - Se le pasa ademas "zona" de parametro (inc. 15881) 
                        /*if (fechaEntrega == null) {
                            envioMAV.setFechaEntrega(null);
                        } else {
                            envioMAV.setFechaEntrega(new Timestamp(fechaEntrega.getTime()));
                        }*/
                          //envioMAV.setFechaEntrega(new Timestamp(monEnvio.obtenerFechaEntrega(periodo).getTime()));
                        // Fin modificacion ssantana, 9/9/2005. 
                        //envioMAV.setFechaEntrega(new Timestamp(monEnvio.obtenerFechaEntrega(periodo).getTime()));
                        envioMAV.setPrecioEstandar(new BigDecimal(dtoDetalleMav.getPrecioEstandar().doubleValue()));
                        envioMAV.setPrecio(new BigDecimal(dtoDetalleMav.getPrecio().doubleValue()));
                        envioMAV.setPrecioContable(new BigDecimal(dtoDetalleMav.getPrecioContable().doubleValue()));
                        envioMAV.setOidDetalle(dtoDetalleMav.getOid());
                        envioMAV.setOidMatrizFact(dtoDetalleMav.getCodigoVenta());
                        envioMAV.setOidCliente(cliente);
                        envioMAV.setOidSolicitudEnvio(null);
                        envioMAV.setOidFormaCobro(dtoDetalleMav.getFormaCobro());
                        envioMAV.setOidActividadTipoDespacho(dtoDetalleMav.getTipoDespacho());
                        
                        envioMAV.setOidActividad(dtoDetalleMav.getActividad());
                        envioMAV.setOidFormaPago(dtoDetalleMav.getFormaPago());
                        envioMAV.setIndEnvio("" + ConstantesMAV.INDICADOR_PENDIENTE_ENVIO);
                        
                        /*
                         * Agregado por ssantana, 03/03/2006, inc. 22717
                         */
                        envioMAV.setOidMensaje(dtoDetalleMav.getMensaje());            
                        /*
                         * Fin Agregado por ssantana, 03/03/2006, inc. 22717
                         */
                        buf.append(this.generarInsertEnvioMav(envioMAV));
                        //monEnvio.insertarEnvioMAV(envioMAV);
                    }
                }
                if (buf.toString().trim().length()>0){
                    BelcorpService belcorpService = BelcorpService.getInstance();
                    belcorpService.dbService.executeProcedure("PQ_PLANI.EXECUTOR", buf.toString());
                }
            }
        } catch(NamingException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(RemoteException re) {
            UtilidadesLog.error(re);
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        } catch(CreateException re) {
            UtilidadesLog.error(re);
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        } catch (MareException me) {
          UtilidadesLog.error(me);
          ctx.setRollbackOnly();
          throw me;
        } catch (Exception ex) {
          UtilidadesLog.error(ex);
          ctx.setRollbackOnly();
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));          
        }
        UtilidadesLog.info("MONRegistroMAVBean.generarEnviosMasivos(DTODetalleMAV dto, Long periodo, Long actividad, Long cliente, Long unidadesEnvio):Salida");
    }
    
    private RecordSet obtenerLimiteAutorizacion (Long periodo) throws MareException{
        StringBuffer sb = new StringBuffer(" select m.IND_REQU_AUTO, m.VAL_LIMI_PREC_AUTO from cra_perio c, MAV_PARAM m ");
        sb.append(" where c.PAIS_OID_PAIS = m.PAIS_OID_PAIS ");
        sb.append(" and c.oid_peri = "+periodo);
        RecordSet r = null;
        try{
            r = BelcorpService.getInstance().dbService.executeStaticQuery(sb.toString());
        }catch (Exception e){
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e);
        }
        return r;
    }
    
    private StringBuffer generarInsertEnvioMav (DTOEnvioMAV envioMav){
        StringBuffer sb = new StringBuffer();
        Character indicadorEnvio = ((envioMav.getIndEnvio() != null) ? new Character(envioMav.getIndEnvio().charAt(0)) : null);
        sb.append("INSERT INTO mav_envio ");
        sb.append(" (oid_envi, num_unid, val_prec_stnd, val_prec, ");
        sb.append(" val_prec_cont, denv_oid_deta_mav, mafa_oid_matr_fact, ");
        sb.append(" clie_oid_clie, esen_oid_esta_envi, fcob_oid_form_cobr, ");
        sb.append(" atde_oid_acti_tipo_desp, fopa_oid_form_pago, ind_envi, ");
        sb.append(" acti_oid_acti");
        sb.append(" ) ");
        sb.append(" VALUES (mav_menv_seq.NEXTVAL ");
        sb.append(" , "+envioMav.getNumeroUnidades().toString());
        sb.append(" , "+envioMav.getPrecioEstandar().toString());
        sb.append(" , "+envioMav.getPrecio().toString());
        sb.append(" , "+envioMav.getPrecioContable().toString());
        sb.append(" , "+envioMav.getOidDetalle().toString());
        sb.append(" , "+envioMav.getOidMatrizFact().toString());
        sb.append(" , "+envioMav.getOidCliente().toString());
        sb.append(" , "+envioMav.getTipoEstadoEnvio().toString());
        sb.append(" , "+envioMav.getOidFormaCobro().toString());
        sb.append(" , "+envioMav.getOidActividadTipoDespacho().toString());
        if (envioMav.getOidFormaPago()!=null){
            sb.append(" , "+envioMav.getOidFormaPago().toString());
        }else{
            sb.append(" , NULL");
        }
        sb.append(" , '"+indicadorEnvio.toString().toUpperCase()+"'");
        sb.append(" , "+envioMav.getOidActividad().toString());
        sb.append(" );");
        return sb;
    }
 
    // sapaza -- PER-SiCC-2010-0699 -- 23/02/2011 
    private void actualizarZonasUnidades (DTODetalleMAV detalleMAV) throws MareException{
        StringBuffer sb = new StringBuffer("");
        sb.append("SELECT zon.oid_zona, adm.num_unid ");
        sb.append("  FROM mav_detal_mav_unida_admin adm, zon_zona zon ");
        sb.append(" WHERE adm.zorg_oid_regi = zon.zorg_oid_regi ");
        sb.append("   AND adm.zzon_oid_zona IS NULL ");
        sb.append("   AND adm.denv_oid_deta_mav = " + detalleMAV.getOid());
        sb.append("   AND zon.ind_acti = 1 ");
        
        RecordSet rs = null;
        
        try{
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(sb.toString());
        }catch (Exception e){
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e);
        }
        
        if (rs!=null && !rs.esVacio()) {
            for(int i=0; i<rs.getRowCount(); i++) {   
                String zona = rs.getValueAt(i,0).toString();
                Long  unidades = new Long(rs.getValueAt(i,1).toString());
                
                detalleMAV.getUnidadesRegionZona().put("z" + zona, unidades);
            }    
        }
        
    } 
  
}