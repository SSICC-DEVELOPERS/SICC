package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.dtos.mav.DTODatosMensaje;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.entidades.bel.EstadosMercanciaLocal;
import es.indra.sicc.entidades.bel.EstadosMercanciaLocalHome;
import es.indra.sicc.entidades.bel.StockLocal;
import es.indra.sicc.entidades.bel.StockLocalHome;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.mav.EstadosActividadLocal;
import es.indra.sicc.entidades.mav.EstadosActividadLocalHome;
import es.indra.sicc.entidades.mav.ParametrizacionMAVLocal;
import es.indra.sicc.entidades.mav.ParametrizacionMAVLocalHome;
import es.indra.sicc.entidades.zon.RegionLocal;
import es.indra.sicc.entidades.zon.RegionLocalHome;
import es.indra.sicc.entidades.zon.TerritorioAdministrativoLocal;
import es.indra.sicc.entidades.zon.TerritorioAdministrativoLocalHome;
import es.indra.sicc.entidades.zon.TerritorioLocal;
import es.indra.sicc.entidades.zon.TerritorioLocalHome;
import es.indra.sicc.entidades.zon.ZonaLocal;
import es.indra.sicc.entidades.zon.ZonaLocalHome;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.mae.MONClientes;
import es.indra.sicc.logicanegocio.mae.MONClientesHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;



import javax.naming.InitialContext;
import javax.naming.NamingException;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesLocalHome;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesLocal;

import javax.persistence.NoResultException;


public class MONGenerarMensajesBean implements SessionBean {
    public void ejbCreate() {}

    public void ejbActivate() {}

    public void ejbPassivate() {}

    public void ejbRemove() {}

    public void setSessionContext(SessionContext ctx) {}

    public DTOBuzonMensajes generarMensaje(DTODatosMensaje dto) throws MareException {
        /** MONGenerarMensajes.generarMensaje(dto : DTODatosMensaje) : void */

        // Obtenemos el oid del almacén para el pais 

        /*-> Crear variable llamada oidAlmacen de tipo Long 
-> Llamar al método "MONGenerarMensajes.obtenerAlmacen(pais : Long) : Long" pasando como parámetro el atributo dto.pais 
-> Asignar a oidAlmacen el dato obtenido de la llamada anterior 
// Comprobamos el Stock del producto 
-> Llamar al método "MONGenerarMensajes.hayStockSuficiente(pais : Long, producto : Long, almacen : Long, unidadesDemandadas : Long) : Boolean" 
-> Crear un objeto de tipo DTOBuzonMensajes, llamado "mensaje" 
-> mensaje.codigoMensaje <= dto.codigoMensaje 
-> Llamar al método "IMaestroClientes.obtenerOidCliente(pais : Long, codCliente : String) : Long" pasando dto.pais y dto.codigoCliente respectivamente como parámetros de entrada 
-> Crear variable llamada oidCliente de tipo Long, y asignarle la respuesta a la llamada anterior 

-> mensaje.oidCliente <= oidCliente 
-> mensaje.moduloOrigen <= ConstantesSEG.MODULO_MAV 
-> mensaje.datoVariable1 <= dto.oidActividad 
-> mensaje.datoVariable2 <= dto.codigoVenta 
-> mensaje.datoVariable3 <= dto.descripcionProducto 
-> mensaje.datoVariable4 <= dto.precioPosicionamiento 
-> mensaje.datoVariable5 <= dto.precioCatalogo 
-> mensaje.datoVariable6 <= dto.precioVenta 
-> mensaje.datoVariable7 <= dto.unidadesDemandadas // Preguntar por este campo al modelizador, porque el DECU dice unidadesAtendidas, y ese dato no le tenemos como entrada ¿habría que calcularlo? 
-> Hacer findByPrimaryKey sobre la entidad Periodo (CRA) usando dto.oidPeriodoInicio 
-> mensaje.datoVariable8 <= Periodo.nombre 
-> Hacer findByPrimaryKey sobre la entidad Periodo (CRA) usando dto.oidPeriodoFin 
-> mensaje.datoVariable9 <= Periodo.nombre 
-> Hacer findByPrimaryKey sobre la entidad Region (ZON) usando dto.oidRegion 
-> mensaje.datoVariable10 <= Region.nombre 
-> Hacer findByPrimaryKey sobre la entidad Zona (ZON) usando dto.oidZona 
-> mensaje.datoVariable11 <= Zona.nombre 
//Inc. 8709
-> Hacer TerritorioAdministrativo.findByPrimaryKey, tomar TerritorioAdministrativo.oidTerritorio y con él hacer
Territorio.findByPrimaryKey y tomar Territorio y no tomar descripción, tomar el código de Territorio, atributo
codTerritorio, que corresponde al campo de base de datos ZON_TERRI.COD_TERR
-> mensaje.datoVariable12 <= TerritorioAdministrativo.nombre 
-> Hallar descripción internacionalizada para dto.oidTipoCliente 
-> mensaje.datoVariable13 <= descripción internacionalizada de tipo cliente 
-> Hallar descripción internacionalizada para dto.oidSubtipoCliente 
-> mensaje.datoVariable14 <= descripción internacionalizada de subtipo cliente 
-> Hallar descripción internacionalizada para dto.oidTipoClasificacion 
-> mensaje.datoVariable15 <= descripción internacionalizada de tipo de clasificación 
-> Hallar descripción internacionalizada para dto.oidClasificacion 
-> mensaje.datoVariable16 <= descripción internacionalizada de clasificación 
//Inc. 8709
-> MAV_ACTIV_ESTAD corresponde a la entidad EstadosActividad, con la que se relaciona MAV_DETAL_MAV,
que corresponde a la entidad DetalleMAV. Entonces se saca el valor del atributo oidEstadoActividad, campo
EMAV_OID_ESTA_MAV, con él se obtiene en la tabla MAV_ESTAD_MAV la descripción internacionalizada.
-> mensaje.datoVariable17 <= descripción internacionalziada de estatusMAV 
*/  
        DTOBuzonMensajes dtoBuzonMensajes = null;
        UtilidadesLog.info("MONGenerarMensajesBean.generarMensaje(DTODatosMensaje dto):Entrada");
        
        
        UtilidadesLog.debug("DTOBuzonMensajes: "+dto);
        try {
            Long oidAlmacen = null;
            oidAlmacen = this.obtenerAlmacen(dto.getOidPais());
            Boolean haystock = this.hayStockSuficiente(dto.getOidPais(), dto.getOidProducto(), oidAlmacen, dto.getUnidadesDemandadas());
            
            /*
             * Modificado por ssantana, inc. BELC300019929, 22/7/2005
             *  - Solo se genera mensaje si hay Stock suficiente. 
             *  - Se contempla que algunos campos pueden ser null.
             */
            if ( haystock.booleanValue() )
            {
                UtilidadesLog.debug("Hay Stock, genera el mensaje");
                DTOBuzonMensajes mensaje = new DTOBuzonMensajes();
                mensaje.setOidPais(dto.getOidPais());
                mensaje.setCodigoMensaje(dto.getCodigoMensaje());
                mensaje.setOidMensaje(dto.getOidMensaje());
                Long oidCliente = this.getMONClientes().obtenerOidCliente(dto.getOidPais(), dto.getCodigoCliente());
                mensaje.setOidCliente(oidCliente);
                mensaje.setModuloOrigen(new Long(ConstantesSEG.MODULO_MAV));
                mensaje.setDatoVariable1("" + dto.getOidActividad());
                mensaje.setDatoVariable2(dto.getCodigoVenta());
                mensaje.setDatoVariable3(dto.getDescripcionProducto());
                mensaje.setDatoVariable4("" + dto.getPrecioPosicionamiento());
                mensaje.setDatoVariable5("" + dto.getPrecioCatalogo());
                mensaje.setDatoVariable6("" + dto.getPrecioVenta());
                mensaje.setDatoVariable7("" + dto.getUnidadesDemandadas());
                PeriodoLocalHome plh = new PeriodoLocalHome();
                RegionLocalHome rlh = new RegionLocalHome();
                ZonaLocalHome zlh = new ZonaLocalHome();
                PeriodoLocal periodoInicio = plh.findByPrimaryKey(dto.getOidPeriodoInicio());
                mensaje.setDatoVariable8(periodoInicio.getNombrePeriodo());
                
                UtilidadesLog.debug("- periodo Fin");
                if ( dto.getOidPeriodoFin() != null ) {
                   UtilidadesLog.debug("  A1");
                   PeriodoLocal periodoFin = plh.findByPrimaryKey(dto.getOidPeriodoFin());
                   mensaje.setDatoVariable9(periodoFin.getNombrePeriodo());
                }
                UtilidadesLog.debug("- oidRegion");
                if ( dto.getOidRegion() != null ) {
                   UtilidadesLog.debug("  B1");                
                   RegionLocal region = rlh.findByPrimaryKey(dto.getOidRegion());
                   mensaje.setDatoVariable10(region.getDescripcionRegion());
                }
                UtilidadesLog.debug("- oidZona");
                if ( dto.getOidZona() != null ) {
                   UtilidadesLog.debug("  C1");                                
                   ZonaLocal zona = zlh.findByPrimaryKey(dto.getOidZona());
                   mensaje.setDatoVariable11(zona.getDescripcion());
                }
                
                UtilidadesLog.debug("- oidTerritorio");
                TerritorioAdministrativoLocalHome talh = new TerritorioAdministrativoLocalHome();
                TerritorioLocalHome tlh = new TerritorioLocalHome();
                
                if ( dto.getOidTerritorio() != null ) {
                   TerritorioAdministrativoLocal terradm = talh.findByPrimaryKey(dto.getOidTerritorio());
                   TerritorioLocal terr = tlh.findByPrimaryKey(terradm.getOidTerritorio());
                   mensaje.setDatoVariable12(terr.getCodTerritorio().toString());
                }
                
                UtilidadesLog.debug("- tipoCliente");
                Entidadi18nLocalHome ei18nlh = new Entidadi18nLocalHome();
                String tipoCliente = ei18nlh
                    .findByEntAtrIdioPK("MAE_TIPO_CLIEN", new Long(1), dto.getOidIdioma(), dto.getOidTipoCliente()).getDetalle();
                mensaje.setDatoVariable13(tipoCliente);
                
                UtilidadesLog.debug("- subtipoCliente");
                /*
                 * Modificacion por ssantana, 02/03/2006
                 * Se contempla que SubtipoCliente sea NULL
                 */
                Long oidSubtipoCliente = dto.getOidSubtipoCliente();                
                if (oidSubtipoCliente != null ) {
                    String subtipoCliente = ei18nlh
                        .findByEntAtrIdioPK("MAE_SUBTI_CLIEN", 
                                            new Long(1), 
                                            dto.getOidIdioma(), 
                                            oidSubtipoCliente).getDetalle();
                    mensaje.setDatoVariable14(subtipoCliente);
                }
                /*
                 * Fin Modificacion por ssantana, 02/03/2006
                 * Se contempla que SubtipoCliente sea NULL
                 */
                
                
                UtilidadesLog.debug("- oidTipoClasificacion");
                if ( dto.getOidTipoClasificacion() != null ) {
                    String tipoClasificacion = ei18nlh
                        .findByEntAtrIdioPK("MAE_TIPO_CLASI_CLIEN", new Long(1), dto.getOidIdioma(), dto.getOidTipoClasificacion()).getDetalle();
                    mensaje.setDatoVariable15(tipoClasificacion);
                }
                
                UtilidadesLog.debug("- oidClasificacion");
                if ( dto.getOidClasificacion() != null ) {
                    String clasificacion = ei18nlh
                        .findByEntAtrIdioPK("MAE_CLASI", new Long(1), dto.getOidIdioma(), dto.getOidClasificacion()).getDetalle();
                    mensaje.setDatoVariable16(clasificacion);
                }
                
                UtilidadesLog.debug("- oidEstatusMAV");
                if ( dto.getOidEstatusMAV() != null ) {
                    EstadosActividadLocalHome ealh = new EstadosActividadLocalHome();
                    EstadosActividadLocal estadoMav = ealh.findByPrimaryKey(dto.getOidEstatusMAV());
                    String estatus = ei18nlh
                        .findByEntAtrIdioPK("MAV_ESTAD_MAV", new Long(1), dto.getOidIdioma(), estadoMav.getOidEstadosMAV()).getDetalle();
                    mensaje.setDatoVariable17(estatus);                        
                }
                mensaje.setDatoVariable18(null);
                mensaje.setDatoVariable19(null);
                mensaje.setDatoVariable20(null);
                mensaje.setListaConsultoras("N");
                mensaje.setCodigoPatron(null);
                mensaje.setNumeroSecuencial(null);
                mensaje.setNumeroLoteImpresion(null);
                mensaje.setFechaGrabacion(null);

                
                // Se genera el mensaje.                 
                UtilidadesLog.debug("Llama a MONGestionMensajes.insertaDatosMensaje()");
                /*MONGestionMensajesHome monGestionMensajesHome = this.getMONGestionMensajesHome();
                MONGestionMensajes monGestionMensajes = monGestionMensajesHome.create();
                dtoBuzonMensajes = monGestionMensajes.insertaDatosMensaje(mensaje);*/

                MONGestionMensajesLocalHome monGestionMensajesHome = this.getMONGestionMensajesLocalHome();
                MONGestionMensajesLocal monGestionMensajes = monGestionMensajesHome.create();
                dtoBuzonMensajes = monGestionMensajes.insertaDatosMensajeBatch(mensaje);
                
            }
            // Fin modificacion ssantana, inc. BELC300019929, 22/7/2005
            
        } catch(NoResultException re) {
            UtilidadesLog.error(re);
            throw new MareException(re, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAV + ErroresNegocio.MAV_0009));
        }catch(RemoteException re) {
            UtilidadesLog.error(re);
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(NamingException re) {
            UtilidadesLog.error(re);
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException cEx) {
            UtilidadesLog.error(cEx);
            throw new MareException(cEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONGenerarMensajesBean.generarMensaje(DTODatosMensaje dto):Salida");
        return dtoBuzonMensajes;
    }

    public Long obtenerAlmacen(Long oidPais) throws MareException {
       UtilidadesLog.info("MONGenerarMensajesBean.obtenerAlmacen(Long oidPais):Entrada");
       
        /** Se trata de obtener el oid del almacén parametrizado para el pais de entrada en la entidad ParametrizacionMAV */
        
        try {
            ParametrizacionMAVLocalHome plh = new ParametrizacionMAVLocalHome();
            ParametrizacionMAVLocal param = plh.findByUK(oidPais);
            UtilidadesLog.info("MONGenerarMensajesBean.obtenerAlmacen(Long oidPais):Salida");
            return param.getOidAlmacenes();
        } catch(NoResultException re) {
            UtilidadesLog.error(re);
            throw new MareException(re, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAV + ErroresNegocio.MAV_0009));
        }
        
    }

    public Boolean hayStockSuficiente(Long pais, Long producto, Long almacen, Long unidadesDemandadas)
        throws MareException {
        /** Se ha de comprobar el Stock del producto de entrada en el almacén de entrada para el estado de mercancía "LD" (Libre disposición) */
        UtilidadesLog.info("MONGenerarMensajesBean.hayStockSuficiente(Long pais, Long producto, Long almacen, Long unidadesDemandadas):Entrada");
        try {
            UtilidadesLog.debug("---- Metodo hayStockSuficiente ---");
            EstadosMercanciaLocalHome estalh = new EstadosMercanciaLocalHome();
            EstadosMercanciaLocal esta = estalh.findByUK(pais, ConstantesBEL.COD_EST_LIBRE_DISP);
            Long oidEstadoMercancia = esta.getOid();
            
            UtilidadesLog.debug("almacen: " + almacen);
            UtilidadesLog.debug("oidEstadoMercancia: " + oidEstadoMercancia);
            UtilidadesLog.debug("producto: " + producto);
            
            StockLocalHome estlh = new StockLocalHome();
            StockLocal est = null;
            
            //Agregado por cvalenzu
            //Incidencia DBLG700000235 - BELC300024498
            try {
                est = estlh.findByClaveUnica(almacen, oidEstadoMercancia, producto);    
            }
            catch(NoResultException re) {
                UtilidadesLog.debug("*** metodo findByClaveUnica no trajo datos ***");
                UtilidadesLog.info("MONGenerarMensajesBean.hayStockSuficiente"+
                "(Long pais, Long producto, Long almacen, Long unidadesDemandadas):Salida");
                return Boolean.FALSE;               
            }         
            //FIN - Agregado por cvalenzu

            if(est.getSaldo().intValue() >= unidadesDemandadas.intValue()) {
                UtilidadesLog.info("MONGenerarMensajesBean.hayStockSuficiente"+
                "(Long pais, Long producto, Long almacen, Long unidadesDemandadas):Salida");
                return Boolean.TRUE;
            }
            else {
                UtilidadesLog.info("MONGenerarMensajesBean.hayStockSuficiente"+
                "(Long pais, Long producto, Long almacen, Long unidadesDemandadas):Salida");
                return Boolean.FALSE;
            }
        }
          catch(NoResultException re) {
            UtilidadesLog.error(re);
            throw new MareException(re, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
    }


    private MONClientes getMONClientes() throws MareException {
        MONClientesHome home = (MONClientesHome)UtilidadesEJB.getHome("MONClientes", MONClientesHome.class);

        MONClientes ejb = null;

        try {
            ejb = home.create();
        } catch(Exception e) {
            UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        return ejb;
    }


    /*private MONGestionMensajesHome getMONGestionMensajesHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONGestionMensajesHome)PortableRemoteObject.narrow(context.lookup("MONGestionMensajes"), MONGestionMensajesHome.class);
  }*/
  
    private MONGestionMensajesLocalHome getMONGestionMensajesLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONGestionMensajesLocalHome)context.lookup("java:comp/env/ejb/local/MONGestionMensajes");
    }
  
}