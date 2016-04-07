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
 * @author: Damasia Maneiro
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 20/09/2005 
 * 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.inc.DTOObtenerTipoSubtipoSolicitud;
import es.indra.sicc.dtos.inc.DTOPremioSustitutivo;
import es.indra.sicc.dtos.inc.DTOProductoSustitutivo;
import es.indra.sicc.dtos.msg.ConstantesMSG;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajes;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesLocal;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesLocalHome;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternos;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternosHome;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternosLocal;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternosLocalHome;
import es.indra.sicc.util.CRAEjbLocators;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.MSGEjbLocators;
import es.indra.sicc.util.PEDEjbLocators;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Date;
import java.sql.Timestamp;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import javax.ejb.CreateException;

import javax.naming.InitialContext;
import javax.naming.NamingException;


class BolsaFaltantesHelper {
    /**
    * Fecha de Creacion: 27/04/2005
    * Autor: Damasia Maneiro
    * Comentario: este metodo genera una solicitud para los productos
    * sustitutos elegidos por el usuario.
    */
    public static void generarSolicitudSustitutos(Faltante faltante,
        DTOPremioSustitutivo dtoSus) throws MareException {
        try {
            UtilidadesLog.info("BolsaFaltantesHelper." +
                "generarSolicitudSustitutos(Faltante faltante, " +
                "DTOPremioSustitutivo dtoSus):Entrada");

            //1.- Invoca al metodo obtenerDTOSolicitudSustitutos pasandole por 
            //parametro el objeto faltante y dtoSus recibido por parametro, de 
            // esta llamada recibe un objeto del tipo DTOSolicitudCabecera al 
            //que llamaremos dtoCabSol 
            DTOCabeceraSolicitud dtoCabeSolicitud = 
                obtenerDTOSolicitudSustitutos(faltante, dtoSus);
            UtilidadesLog.debug("*** dtoCabeSolicitud: " + dtoCabeSolicitud);

            //2.- El dto obtenido en el punto 1 se le pasa por parametro a 
            //IPEDGenerarSolicitudesExternas.generaSolicitud(dtoCabSol) el 
            //cual genera una nueva solicitud.
            MONGenerarSolicitudModulosExternosHome 
                monGenerarSolicitudModulosExternos = PEDEjbLocators
                    .getMONGenerarSolicitudModulosExternosHome();

            MONGenerarSolicitudModulosExternos generarSolicitudModulosExternos 
                = monGenerarSolicitudModulosExternos.create();

            generarSolicitudModulosExternos.generaSolicitud(dtoCabeSolicitud);

            //3.- Invocar a DAOFaltantes.actualizarEntidadesFaltantes 
            //pasandole por parametro el objeto faltante y dtoSus 
            DAOFaltantes dao = new DAOFaltantes();
            dao.actualizarEntidadesFaltantes(faltante, dtoSus);
            UtilidadesLog.info("Salio BolsaFaltantesHelper." +
                "generarSolicitudSustitutos(Faltante faltante, " +
                "DTOPremioSustitutivo dtoSus):Salida");
        } catch (CreateException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e);
        }
    }

    /**
    * Fecha de Creacion: 27/04/2005
    * Autor: Damasia Maneiro
    * Comentario: se genera el mensaje por los faltantes solicitados y se
    * guarda en la entidad de mensajes de incentivos.
    */
    private void generarMensajeFaltantes(Faltante faltante)
        throws MareException {
        UtilidadesLog.info("BolsaFaltantesHelper.generarMensajeFaltantes(" +
            "Faltante faltante):Entrada");

        DTOBuzonMensajes dtoMensaje = new DTOBuzonMensajes();
        DAOSolicitudActualizacion daoSolicitudActualizacion = 
            new DAOSolicitudActualizacion();
        MONGestionMensajesLocal gestionMensajes = null;
        DTOBuzonMensajes dtoBuzonRetorno = null;

        try {
            if (faltante != null) {
                dtoMensaje.setOidPais(faltante.getOidPais());
                dtoMensaje.setCodigoMensaje(faltante.getCodigoMensaje());
                dtoMensaje.setOidCliente(faltante.getOidCliente());
                dtoMensaje.setModuloOrigen(ConstantesINC.CODIGO_MODULO_ORIGEN);
                
                // vbongiov -- 12/07/2006 -- inc DBLG500000920
                // Formateo la fecha
                SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss");
                String dateString = formatter.format(new java.util.Date(System.currentTimeMillis()));
                dtoMensaje.setDatoVariable1(dateString);
                
                dtoMensaje.setDatoVariable2(faltante.getNombreCliente());
                dtoMensaje.setDatoVariable3(faltante.getApellidoCliente());
                dtoMensaje.setDatoVariable4(faltante.getCuentaCliente());
                dtoMensaje.setDatoVariable5(faltante.getCodigoZona());
                dtoMensaje.setDatoVariable6((faltante.getCodigoTerritorio() 
                    != null) ? faltante.getCodigoTerritorio().toString() 
                        : null);
                dtoMensaje.setDatoVariable7(faltante
                    .getCodigoPeriodoInicioConcurso());
                dtoMensaje.setDatoVariable8(faltante
                    .getCodigoPeriodoFinConcurso());
                dtoMensaje.setDatoVariable9(faltante.getCodigoProducto());
                dtoMensaje.setDatoVariable10(faltante
                    .getCodigoPeriodoDespacho());
                dtoMensaje.setDatoVariable12(faltante.getCodigoProducto());
                dtoMensaje.setDatoVariable13("");
                dtoMensaje.setDatoVariable14((faltante.getNumeroConcurso() 
                    != null)? faltante.getNumeroConcurso().toString() : null);
                dtoMensaje.setListaConsultoras(ConstantesMSG.NO);
                dtoMensaje.setCodigoPatron(null);
                
                //jrivas SiCC 20070242  28/5/07
                dtoMensaje.setDatoVariable16(faltante.getNombreConcurso());
                
                gestionMensajes = this.getMONGestionMensajesLocalHome().create();
                
                dtoBuzonRetorno = gestionMensajes.insertaDatosMensajeBatch(
                    dtoMensaje);
                daoSolicitudActualizacion.actualizarMensajeIncentivos(
                    faltante.getOidSolicitud(), faltante.getOidConcurso(), 
                    dtoBuzonRetorno);
            } else {
                throw new Exception("El Parametro " + faltante + "es nulo");
            }

            UtilidadesLog.info("BolsaFaltantesHelper.generarMensajeFaltantes" +
                "(Faltante faltante):Salida");
        }
        catch (CreateException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            throw me;
        }
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e);
        }
    }
    
    /**
    * Modificado por: Cristian Valenzuela
    * Fecha: 29/08/2006
    * Incidencia: BELC300023933
    */

    public static void generarMensajeFaltantes(Faltante faltante,
        DTOPremioSustitutivo dtoSus) throws MareException {
        UtilidadesLog.info("BolsaFaltantesHelper.generarMensajeFaltantes" +
            "(Faltante faltante, DTOPremioSustitutivo dtoSus):Entrada");

        DTOBuzonMensajes dtoMensaje;
        DTOBuzonMensajes dtoBuzonRetorno = null;
        MONGestionMensajes gestionMensajes = null;
        DAOSolicitudActualizacion daoSolicitudActualizacion =
            new DAOSolicitudActualizacion();
        int size = dtoSus.getProductosSustitutivos().size();

        try {
            for (int i = 0; i < size; i++) {
                DTOProductoSustitutivo dtoProdSus = (DTOProductoSustitutivo) 
                    dtoSus.getProductosSustitutivos().get(i);
                dtoMensaje = new DTOBuzonMensajes();
                dtoMensaje.setOidPais(dtoSus.getOidPais());
                dtoMensaje.setCodigoMensaje(dtoSus.getCodigoMensaje());
                dtoMensaje.setOidCliente(faltante.getOidCliente());
                dtoMensaje.setModuloOrigen(ConstantesINC.CODIGO_MODULO_ORIGEN);
                
                // vbongiov -- 12/07/2006 -- inc DBLG500000920
                // Formateo la fecha
                SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss");
                String dateString = formatter.format(new java.util.Date(System.currentTimeMillis()));
                dtoMensaje.setDatoVariable1(dateString);
                
                dtoMensaje.setDatoVariable2(faltante.getNombreCliente());
                dtoMensaje.setDatoVariable3(faltante.getApellidoCliente());
                dtoMensaje.setDatoVariable4(faltante.getCuentaCliente());
                dtoMensaje.setDatoVariable5(faltante.getCodigoZona());
                dtoMensaje.setDatoVariable6((faltante.getCodigoTerritorio() 
                    != null) ? faltante.getCodigoTerritorio().toString() 
                        : null);               
                dtoMensaje.setDatoVariable7(faltante
                    .getCodigoPeriodoInicioConcurso());
                dtoMensaje.setDatoVariable8(faltante
                    .getCodigoPeriodoFinConcurso());
                
                //dtoMensaje.setDatoVariable9(faltante.getCodigoProducto());
                dtoMensaje.setDatoVariable9(dtoProdSus.getCodSap());
                
                dtoMensaje.setDatoVariable10(faltante
                    .getCodigoPeriodoDespacho());
                
                dtoMensaje.setDatoVariable12(dtoProdSus.getCodSap());
                
                // DBLG700000068 - gPineda - 04/10/06
                //dtoMensaje.setDatoVariable13("");
                dtoMensaje.setDatoVariable13( dtoSus.getObservacionesCambio() );
                
                dtoMensaje.setDatoVariable14((faltante.getNumeroConcurso() 
                    != null) ? faltante.getNumeroConcurso().toString() : null);
                dtoMensaje.setListaConsultoras(ConstantesMSG.NO);
                dtoMensaje.setCodigoPatron(null);

                gestionMensajes = MSGEjbLocators.getMONGestionMensajesHome()
                                                .create();

                dtoBuzonRetorno = gestionMensajes.insertaDatosMensajeBatch(
                    dtoMensaje);

                daoSolicitudActualizacion.actualizarMensajeIncentivos(faltante
                    .getOidSolicitud(),
                    faltante.getOidConcurso(), dtoBuzonRetorno);
            }

            UtilidadesLog.info("BolsaFaltantesHelper.generarMensajeFaltantes"
                +"( Faltante faltante, DTOPremioSustitutivo dtoSus):Salida");
        } catch (CreateException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e);
        }
    }

    /**
    * Fecha de Creacion: 27/04/2005
    * Autor: Damasia Maneiro
    * Comentario: este metodo retorna el un DTOCabeceraSolicitud para productos
    * sustitutivos.
    */
    public static DTOCabeceraSolicitud obtenerDTOSolicitudSustitutos(
        Faltante faltante, DTOPremioSustitutivo dtoSus)
        throws MareException {
        UtilidadesLog.info("BolsaFaltantesHelper.obtenerDTOSolicitudSustitu"
            +"tos (Faltante faltante, DTOPremioSustitutivo dtoSus):Entrada");
        try {
            //1.- Crear un objeto de la clase DTOCabeceraSolicitud al que 
            //llamaremos dtoCabeceraRetorno. 
            DTOCabeceraSolicitud dtoCabeceraRetorno = new DTOCabeceraSolicitud();
            DAODespachoPremios daoDespachoPremios = new DAODespachoPremios();
            ArrayList posiciones = new ArrayList();
            ArrayList productosSustitutivos = new ArrayList();
            DTOProductoSustitutivo dtoProdSus = new DTOProductoSustitutivo();
            MONPeriodosHome monPeriodosHome = CRAEjbLocators.getMONPeriodosHome();
            MONPeriodos monPeriodos = monPeriodosHome.create();
            DTOPeriodo dtoPer = new DTOPeriodo();
        
            Long tipoCliente = null;

            if (ConstantesINC.TIPO_CONSULTORA.equals(faltante.getDirigidoA())){
                tipoCliente = ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA;
            }

            if (ConstantesINC.TIPO_GERENTE.equals(faltante.getDirigidoA())) {
                tipoCliente = ConstantesMAE.OID_TIPO_CLIENTE_GERENTE;
            }

            //2.- Obtener tipoSolicitudPosicion = DAODespachoPremios.obtenerTipoSubtipoSolicitud 
            
            // Obtengo el tipo subtipo Solicitud
            // vbongiov -- 16/08/2006
            DTOObtenerTipoSubtipoSolicitud dtoObtenerTipoSubtipoSolicitud = new DTOObtenerTipoSubtipoSolicitud();
            
            dtoObtenerTipoSubtipoSolicitud.setOidPais(faltante.getOidPais());
            dtoObtenerTipoSubtipoSolicitud.setOidOperacion(ConstantesINC.OPER_SOLIC_BOLSA_FALTANTES);
            dtoObtenerTipoSubtipoSolicitud.setOidCanal(faltante.getOidCanal());
            dtoObtenerTipoSubtipoSolicitud.setOidDirigidoA(faltante.getDirigidoA());
            dtoObtenerTipoSubtipoSolicitud.setOidMarca(faltante.getOidMarca());
            dtoObtenerTipoSubtipoSolicitud.setOidConcurso(faltante.getOidConcurso());
            dtoObtenerTipoSubtipoSolicitud.setOidCliente(faltante.getOidCliente());
            dtoObtenerTipoSubtipoSolicitud.setOidPeriodo(null);
            
            TipoSolicitudPosicion tipoSolicitudPosicion = daoDespachoPremios.obtenerTipoSubtipoSolicitud(
                                                                          dtoObtenerTipoSubtipoSolicitud);
                    
             // Obtiene el periodo actual
            dtoPer = monPeriodos.obtienePeriodoActual(faltante.getOidPais(),
                                                      faltante.getOidMarca(),
                                                      faltante.getOidCanal());                    

            //3.- Completar sus atributos con los datos recibidos por parametro 
            //de acuerdo a la siguiente especificacion:
            dtoCabeceraRetorno.setOperacion(ConstantesINC
                .OPER_SOLIC_BOLSA_FALTANTES);
            dtoCabeceraRetorno.setModulo(ConstantesINC.CODIGO_MODULO_ORIGEN);
            dtoCabeceraRetorno.setTipoSolicitud(tipoSolicitudPosicion
                .getTipoSolicitud());
            dtoCabeceraRetorno.setTipoCliente(tipoCliente);
            dtoCabeceraRetorno.setOidCliente(faltante.getOidCliente());
            dtoCabeceraRetorno.setMarca(faltante.getOidMarca());
            dtoCabeceraRetorno.setCanal(faltante.getOidCanal());
            dtoCabeceraRetorno.setAcceso(faltante.getOidAcceso());
            dtoCabeceraRetorno.setFecha(new Date(System.currentTimeMillis()));
            dtoCabeceraRetorno.setPeriodo(dtoPer.getOid());
            dtoCabeceraRetorno.setOidConcursoParametros(faltante
                .getOidConcurso());

            dtoCabeceraRetorno.setSubacceso(faltante.getOidSubacceso());
            dtoCabeceraRetorno.setOidPais(faltante.getOidPais());
            dtoCabeceraRetorno.setOidIdioma(new Long(1));

            /*// DBLG700000068 - gPineda - 04/10/06
            //dtoCabeceraRetorno.setObservaciones("");
            dtoCabeceraRetorno.setObservaciones( dtoSus.getObservacionesCambio() );*/
            //modificado por Sapaza - fecha 12/09/2007 - incidencia Sicc20070414
            if(dtoSus.getObservacionesCambio()!= null && dtoSus.getObservacionesCambio().length()>0)
                dtoCabeceraRetorno.setObservaciones( dtoSus.getObservacionesCambio() );
            else
                dtoCabeceraRetorno.setObservaciones(null);
                
            if( dtoSus.getNumeroPremioFaltante() != null ){
              dtoCabeceraRetorno.setNumeroPremio( new Integer( dtoSus.getNumeroPremioFaltante().intValue() ) );
            }
            
            //4.- Generar las posiciones para los productos sustitutivos. 
            productosSustitutivos = dtoSus.getProductosSustitutivos();

            for (int pos = 0; productosSustitutivos.size() > pos; pos++) {
                DTOPosicionSolicitud dtoPosicion = new DTOPosicionSolicitud();
                dtoProdSus = (DTOProductoSustitutivo) dtoSus
                    .getProductosSustitutivos().get(pos);
                dtoPosicion.setTipoPosicion(tipoSolicitudPosicion
                    .getTipoPosicion());
                dtoPosicion.setSubtipoPosicion(tipoSolicitudPosicion
                    .getSubtipoPosicion());
                dtoPosicion.setCodigoProducto(dtoProdSus.getCodSap());
                dtoPosicion.setProducto(dtoProdSus.getOidProducto());

                if (dtoProdSus.getCodigoVentaFicticio() != null) {
                    dtoPosicion.setCodigoVentaFicticio(Long.valueOf(
                            dtoProdSus.getCodigoVentaFicticio()));
                }

                dtoPosicion.setUnidadesDemandadas(dtoProdSus.getCantidad());
                
                //jrivas DBLG500000735 20/6/2006
                /*dtoPosicion.setPrecioContableUnitarioDocumento(BigDecimal
                    .valueOf(ConstantesINC.PRECIO_CONTABLE_SUSTITUTOS
                        .longValue()));*/
                dtoPosicion.setPrecioContableUnitarioLocal(BigDecimal
                    .valueOf(ConstantesINC.PRECIO_CONTABLE_SUSTITUTOS
                        .longValue()));                        

                posiciones.add(dtoPosicion);
            }

            dtoCabeceraRetorno.setPosiciones(posiciones);
            
            UtilidadesLog.debug("dtoCabeceraRetorno: " + dtoCabeceraRetorno);
            
            UtilidadesLog.info("BolsaFaltantesHelper." +
                "obtenerDTOSolicitudSustitutos(Faltante faltante," +
                "DTOPremioSustitutivo dtoSus):Salida");

            return dtoCabeceraRetorno;
            
        } catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            throw me;
        } catch (CreateException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException re) {
            UtilidadesLog.error("ERROR ", re);
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }

    /**
      * Fecha de Creacion: 5/05/2005
      * Autor: Carlos Leal
      * Comentario: completa el DTO para generar la solicitud
      */
    private static DTOCabeceraSolicitud obtenerDTOSolicitudFaltantes(
        Faltante faltante) throws MareException {
        UtilidadesLog.info("BolsaFaltantesHelper.obtenerDTOSolicitudFaltantes" +
            "(Faltante faltante):Entrada");

        try {
            DTOCabeceraSolicitud dtoCabeceraRetorno = new DTOCabeceraSolicitud();
            DAODespachoPremios dAODespachoPremios = new DAODespachoPremios();
            DTOPosicionSolicitud dtoPosicion = new DTOPosicionSolicitud();
            Date fd = new Date(System.currentTimeMillis());
            ArrayList dtoPosicionList = new ArrayList();
            /*MONPeriodosHome monPeriodosHome = CRAEjbLocators.getMONPeriodosHome();
            MONPeriodos monPeriodos = monPeriodosHome.create();*/
            DTOPeriodo dtoPer = new DTOPeriodo();
        
            Long tipoCliente = null;

            if (ConstantesINC.TIPO_CONSULTORA.equals(faltante.getDirigidoA())){
                tipoCliente = ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA;
            }

            if (ConstantesINC.TIPO_GERENTE.equals(faltante.getDirigidoA())){
                tipoCliente = ConstantesMAE.OID_TIPO_CLIENTE_GERENTE;
            }
            
            // vbongiov -- 16/08/2006
            DTOObtenerTipoSubtipoSolicitud dtoObtenerTipoSubtipoSolicitud = new DTOObtenerTipoSubtipoSolicitud();
            
            dtoObtenerTipoSubtipoSolicitud.setOidPais(faltante.getOidPais());
            dtoObtenerTipoSubtipoSolicitud.setOidOperacion(ConstantesINC.OPER_SOLIC_BOLSA_FALTANTES);
            dtoObtenerTipoSubtipoSolicitud.setOidCanal(faltante.getOidCanal());
            dtoObtenerTipoSubtipoSolicitud.setOidDirigidoA(faltante.getDirigidoA());
            dtoObtenerTipoSubtipoSolicitud.setOidMarca(faltante.getOidMarca());
            dtoObtenerTipoSubtipoSolicitud.setOidConcurso(faltante.getOidConcurso());
            dtoObtenerTipoSubtipoSolicitud.setOidCliente(faltante.getOidCliente());
            dtoObtenerTipoSubtipoSolicitud.setOidPeriodo(null);

            TipoSolicitudPosicion tipoSolicitudPosicion = dAODespachoPremios
                                    .obtenerTipoSubtipoSolicitud(dtoObtenerTipoSubtipoSolicitud);
            
            // Obtiene el periodo actual
            /*dtoPer = monPeriodos.obtienePeriodoActual(faltante.getOidPais(),
                                                      faltante.getOidMarca(),
                                                      faltante.getOidCanal());*/

            dtoCabeceraRetorno.setOperacion(ConstantesINC
                .OPER_SOLIC_BOLSA_FALTANTES);
            dtoCabeceraRetorno.setModulo(ConstantesINC.CODIGO_MODULO_ORIGEN);
            dtoCabeceraRetorno.setTipoSolicitud(tipoSolicitudPosicion
                .getTipoSolicitud());
            dtoCabeceraRetorno.setTipoCliente(tipoCliente);
            dtoCabeceraRetorno.setOidCliente(faltante.getOidCliente());
            dtoCabeceraRetorno.setMarca(faltante.getOidMarca());
            dtoCabeceraRetorno.setCanal(faltante.getOidCanal());
            dtoCabeceraRetorno.setAcceso(faltante.getOidAcceso());
            dtoCabeceraRetorno.setFecha(new Timestamp(fd.getTime()));
            dtoCabeceraRetorno.setPeriodo(faltante.getOidPeriodo());
            //modificado por Sapaza - fecha 12/09/2007 - incidencia Sicc20070414
            dtoCabeceraRetorno.setObservaciones(null);
            //dtoCabeceraRetorno.setObservaciones("");
            dtoCabeceraRetorno.setOidConcursoParametros(faltante
                .getOidConcurso());
                
            //DBLG50000899 31/7/2006 jrivas
            if (faltante.getNumeroPremio() != null) {
                dtoCabeceraRetorno.setNumeroPremio(new Integer(faltante.getNumeroPremio().intValue())); 
            }

            //Preguntar a Julian si levanto Incidencia!!!    
            dtoCabeceraRetorno.setOidPais(faltante.getOidPais());

            //Harcodeo solo se usa para trae oidcon descripcion??
            // Agregado por Julian Rivas
            dtoCabeceraRetorno.setOidIdioma(new Long(1));

            //vet DT
            dtoCabeceraRetorno.setSubacceso(faltante.getOidSubacceso());

            dtoPosicion.setTipoPosicion(tipoSolicitudPosicion
                .getTipoPosicion());
            dtoPosicion.setSubtipoPosicion(tipoSolicitudPosicion
                .getSubtipoPosicion());
            dtoPosicion.setCodigoProducto(faltante.getCodigoProducto());
            dtoPosicion.setProducto(faltante.getOidProducto());

            if (faltante.getCodigoVentaFicticio() != null) {
                dtoPosicion.setCodigoVentaFicticio(Long.valueOf(
                        faltante.getCodigoVentaFicticio()));
            }

            if (faltante.getUnidadesDemandadas() != null) {
                dtoPosicion.setUnidadesDemandadas(new Long(
                        (faltante.getUnidadesDemandadas()).longValue()));
            }

            // vbongiov -- 17/08/2006 -- inc DBLG500001125
            dtoPosicion.setPrecioContableUnitarioLocal(faltante
                .getPrecioPublico());

            dtoPosicionList.add(dtoPosicion);

            dtoCabeceraRetorno.setPosiciones(dtoPosicionList);
            
            UtilidadesLog.debug("dtoCabeceraRetorno: " + dtoCabeceraRetorno);
            
            UtilidadesLog.info("BolsaFaltantesHelper.obtenerDTOSolicitudFaltan"
            +"tes (Faltante faltante):Salida");

            return dtoCabeceraRetorno;
        
        } catch (MareException e) {
            UtilidadesLog.error("ERROR ", e);
            throw e;
        } /*catch (CreateException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException re) {
            UtilidadesLog.error("ERROR ", re);
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }*/
    }

    /**
      * Fecha de Creacion: 5/05/2005
      * Autor: Carlos Leal
      * Comentario:
      */
    private void generarSolicitudFaltantes(Faltante faltante)
        throws MareException {
        UtilidadesLog.info(" BolsaFaltantesHelper.generarSolicitudFaltantes("
            +"Faltante faltante):Entrada");

        /*
         * Descripcion: genera la solicitud para el faltante pasado por
         * parametro. Considera como precondicion que existe stock para el
         * producto.Implementacion:
          1.- Invoca al metodo obtenerDTOSolicitudFaltantes pasandole por
          parametro el objeto faltante recibido por parametro, de esta llamada
          recibe un objeto del tipo DTOSolicitudCabecera al que llamaremos
          dtoCabSol
          2.- El dto obtenido en el punto 1 se le pasa por parametro a
          IPEDGenerarSolicitudesExternas.generaSolicitud(dtoCabSol) el cual
          genera una nueva solicitud.
          3.- Invocar a DAOFaltantes.actualizarEntidadesFaltantes pasandole por
          parametro el objeto faltante.
         */
        DTOCabeceraSolicitud dtoCabSol = obtenerDTOSolicitudFaltantes(
            faltante);
        DAOFaltantes dAOFaltantes = new DAOFaltantes();

        try {
            /*MONGenerarSolicitudModulosExternosHome 
                monGenerarSolicitudModulosExternos = PEDEjbLocators
                    .getMONGenerarSolicitudModulosExternosHome();
            MONGenerarSolicitudModulosExternos generarSolicitudModulosExternos
                = monGenerarSolicitudModulosExternos.create();*/
            MONGenerarSolicitudModulosExternosLocalHome 
                monGenerarSolicitudModulosExternos = this.getMONGenerarSolicitudModulosExternosLocalHome();
            MONGenerarSolicitudModulosExternosLocal generarSolicitudModulosExternos
                = monGenerarSolicitudModulosExternos.create();        
                
            // vbongiov -- Cambio 20091380 -- 22/10/2009
            UtilidadesLog.debug("dtoCabSol: " + dtoCabSol);
                        
            generarSolicitudModulosExternos.generaSolicitud(dtoCabSol);
            dAOFaltantes.actualizarEntidadesFaltantes(faltante);


            UtilidadesLog.info(" BolsaFaltantesHelper." +
                "generarSolicitudFaltantes(Faltante faltante):Salida");
        } catch (Exception ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    /**
      * Fecha de Creacion: 5/05/2005
      * Autor: Carlos Leal
      * Comentario:
      */
    public void procesarFaltante(Faltante faltante)
        throws MareException {
        UtilidadesLog.info("BolsaFaltantesHelper.procesarFaltante(Faltante " +
            " faltante):Entrada");

        /*
         * Descripcion: procesa el faltante recibido por parametro.
          Implementacion:
          1.- Invocar a BolsaFaltantesHelper.generarSolicitudFaltantes
          pasandole por parametro el objeto faltante.
          2.- Si faltante.indEnvioMensaje entonces
          Invocar a BolsaFaltantesHelper.generarMensajeFaltantes pasandole
          por parametro el objeto faltante. FSi
         * */
        try {
        
            // vbongiov -- Cambio 20091380 -- 22/10/2009
            UtilidadesLog.debug("faltante: " + faltante);
                        
            this.generarSolicitudFaltantes(faltante);

            UtilidadesLog.debug("****BolsaFaltantesHelper.procesarFaltante, faltante.getIndEnvioMensaje()="+faltante.getIndEnvioMensaje());

            if(faltante.getIndEnvioMensaje() != null){
                if (faltante.getIndEnvioMensaje().booleanValue()) {
                    this.generarMensajeFaltantes(faltante);
                }
            }

            UtilidadesLog.info(
                "****BolsaFaltantesHelper.procesarFaltante(Faltante" +
                "faltante):Entrada");
        } catch (MareException e) {
            UtilidadesLog.error("ERROR ", e);
            throw e;
        }
    }
    
    private MONGenerarSolicitudModulosExternosLocalHome getMONGenerarSolicitudModulosExternosLocalHome() throws NamingException   {
        final InitialContext context = new InitialContext();
        return (MONGenerarSolicitudModulosExternosLocalHome)context.lookup("java:comp/env/ejb/local/MONGenerarSolicitudModulosExternos");
    }    
    
    private MONGestionMensajesLocalHome getMONGestionMensajesLocalHome() throws NamingException   {
        final InitialContext context = new InitialContext();
        return (MONGestionMensajesLocalHome)context.lookup("java:comp/env/ejb/local/MONGestionMensajes");
    }
}
