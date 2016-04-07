/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
package es.indra.sicc.logicanegocio.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.print.SpoolManager;
import es.indra.sicc.cmn.negocio.print.SpoolManagerHome;

import es.indra.sicc.dtos.fac.DTODatosCupones;
import es.indra.sicc.dtos.fac.DTODatosDocMensajes;
import es.indra.sicc.dtos.fac.DTODatosTipoFormulario;
import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;
import es.indra.sicc.dtos.fac.DTOOIDsDocumentos;
import es.indra.sicc.dtos.msg.DTOImpresion;

import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DAODocuContable;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DAOPatronDocumento;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTOClienteSolicitud;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTODocLegal;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTODocumento;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTOFACDocumentoContable;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTOFACDocumentoContableCabecera;

import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DatosClienteHelper;
import es.indra.sicc.logicanegocio.msg.MONImpresionMensajes;
import es.indra.sicc.logicanegocio.msg.MONImpresionMensajesHome;

import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import java.util.ArrayList;

import java.util.Date;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONReimpresionBean implements SessionBean {
    private SessionContext ctx;

    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    // Modificado por la BELC300015675
    public void reimprimir(DTOOIDsDocumentos dtoOidsDocumentos) throws MareException {
        //ENTRADA: oidsEntrada: DTOOIDs
        //RESUMEN: Se encarga de preparar el entorno de impresión y
        //componer los documentos cuyos oids nos entran por cabecera
        UtilidadesLog.info("MONReimpresionBean.reimprimir(DTOOIDsDocumentos dtoOidsDocumentos): Entrada");

        DTOOIDs oidsDocumentos = dtoOidsDocumentos.getLista();
        Long subacceso = dtoOidsDocumentos.getSubacceso();
        
        DTODocumento dtoDocumento = null;
        Long idSpool = null;

        SpoolManager spoolManager = this.getSpoolManagerHome();

        //1.- Se crea una instancia del SpoolManager y se llama a su método openSpool.
        //            Este método nos devuelve un "idSpool".
        try {
            idSpool = spoolManager.openSpool(subacceso);
        } catch (RemoteException re) {
            UtilidadesLog.error("*** Error en reimprimir, spoolManager.openSpool();",
                re);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re,
                UtilidadesError.armarCodigoError(codigoError));
        }

        //2.- Por cada oid almacenado en el DTOIDs entrada hacer
        Long[] arrayOids = oidsDocumentos.getOids();

        for (int i = 0; i < arrayOids.length; i++) {
            //Se compone un DTOOID con el long que corresponda según el indice del bucle.
            DTOOID dtoOid = new DTOOID();
            dtoOid.setOid(arrayOids[i]);

            MONImpresionSICC monImpresionSICC = this.getMONImpresionSICCHome();

            try {
                //Se llama al método visualizarDocumentoFacturacion(DTOOID) del
                //MONImpresionSICC que nos devolverá un DTODocumento.
                dtoDocumento = monImpresionSICC.visualizarDocumentoFacturacion(dtoOid, subacceso);
            } catch (RemoteException re) {
                UtilidadesLog.error("*** Error en reimprimir, monImpresionSICC.visualizarDocumentoFacturacion(dtoOid); ",
                    re);

                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re,
                    UtilidadesError.armarCodigoError(codigoError));
            }
            if (dtoDocumento != null) {
              try {
                  //Llamamos al método addPrintableDocument del spoolManager
                  //pasandole el DTODocumento y el idSpool obtenido en el paso 1.
                  spoolManager.addPrintableDocuments(dtoDocumento, idSpool);
              } catch (RemoteException re) {
                  UtilidadesLog.error("*** Error en reimprimir, spoolManager.addPrintableDocuments(dtoDocumento,idSpool); ",
                      re);
  
                  String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                  throw new MareException(re,
                      UtilidadesError.armarCodigoError(codigoError));
              }
            }
        }

        //Fin for
        //  3.- Se llama al método closeSpool del SpoolManager pasandole el idSpool.
        try {
            spoolManager.closeSpool(idSpool);
        } catch (RemoteException re) {
            UtilidadesLog.error("*** Error en reimprimir, spoolManager.closeSpool(idSpool); ",
                re);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONReimpresionBean.reimprimir(DTOOIDsDocumentos dtoOidsDocumentos): Salida");
    }

    public DTOSalida obtenerSolicitudes(DTODatosDocMensajes dtoEntrada)
        throws MareException {
        //ENTRADA: datosEntrada: DTODatosDocMensajes
        //SALIDA: datosSalida: DTOSalida
        //RESUMEN: El objetivo de este método es obtener los datos
        //que se deben mostrar como resultado de la busqueda hecha por el usuario.
        UtilidadesLog.info("MONReimpresionBean.obtenerSolicitudes(DTODatosDocMensajes dtoEntrada): Entrada");

        //1.- invocamos al método obtenerSolicitudes( datosEntrada )
        //del DAOGestionDocumentos. Tendremos que devolver la salida de esta invocación.  
        String usuario = ctx.getCallerPrincipal().getName();
        DAOGestionDocumentos daoGestionDocumentos = new DAOGestionDocumentos(usuario);
        DTOSalida dtoSalida = daoGestionDocumentos.obtenerSolicitudes(dtoEntrada);

        UtilidadesLog.info("MONReimpresionBean.obtenerSolicitudes(DTODatosDocMensajes dtoEntrada): Salida");

        return dtoSalida;
    }

    // BELC300015675
    public void reimprimirUltimasNoticias(DTOOIDsDocumentos dtoOidsDocumentos)
        throws MareException {
        // ENTRADA: oidsEntrada: DTOOIDs
        // RESUMEN: El objetivo de este método crear el documento "ultimas noticias" 
        // para todos los oids de consolidados que nos llegan por cabecera.
        UtilidadesLog.info("MONReimpresionBean.reimprimirUltimasNoticias(DTOOIDsDocumentos dtoOidsDocumentos): Entrada");

        DTOOIDs oidsEntrada = dtoOidsDocumentos.getLista();
        oidsEntrada.setOidPais(dtoOidsDocumentos.getOidPais());
        oidsEntrada.setOidIdioma(dtoOidsDocumentos.getOidIdioma());
        Long subacceso = dtoOidsDocumentos.getSubacceso();

        Long idSpool = null;

        // 1.- Llamamos al método openSpool del SpoolManager. Nos devolvera un idSpool.         
        SpoolManager spoolManager = this.getSpoolManagerHome();

        try {
            idSpool = spoolManager.openSpool(subacceso);
        } catch (RemoteException re) {
            UtilidadesLog.error("*** Error en reimprimirUltimasNoticias, spoolManager.openSpool();",
                re);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re,
                UtilidadesError.armarCodigoError(codigoError));
        }

        //2.- Por cada oid contenido en oidsEntrada hacer: 
        Long[] arrayOids = oidsEntrada.getOids();

        for (int i = 0; i < arrayOids.length; i++) { //for(1)

            //2.1.-creamos un DTOFACConsolidado y le asignamos el idSpool obtenido anterior.
            DTOFACConsolidado dtoFACConsolidado = new DTOFACConsolidado();
            dtoFACConsolidado.setIDSpool(idSpool);

            /*
             *  2.2.-invocamos al método obtenerCabecerasSolicitud del DAOSolicitudCabecera,
             *  pasandole el oid pertinente según el indice del bucle
             *  insertado en un arrayList.
             *  Este método nos devuelve un DTOFACabeceraSolicitud que le asignaremos
             *  al atributo dtoCabecera del objeto DTOFACConsolidado
             *  que hemos creado al inicio de la vuelta del bucle.
             */
            DAOSolicitudCabecera daoSC = new DAOSolicitudCabecera();
            ArrayList arrayOidSolicitud = new ArrayList();
            Long oidSolicitud = arrayOids[i];
            arrayOidSolicitud.add(oidSolicitud);

            ArrayList arrayListDtoFACCS = daoSC.obtenerCabecerasSolicitud(arrayOidSolicitud);
            DTOFACCabeceraSolicitud dtoFACCS = (DTOFACCabeceraSolicitud) arrayListDtoFACCS.get(0);
            dtoFACConsolidado.setDtoCabecera(dtoFACCS);

            /*
             * 2.3.-invocamos al método obtenerCabecerasDeUnConsolidado
             * pasandole el oid pertinente según el indice del bucle.
             * Este método nos devuelve un arrayList que deberemos asignarselo
             * al atributo listaSolicitud del objeto DTOFACConsolidado que hemos
             * creado al inicio de la vuelta del bucle. Nos creamos un arrayList
             * con los oids de los registros recuperados.
             */
            DAOGestionDocumentos daoGD = new DAOGestionDocumentos();
            ArrayList arrayListaSolicitudes = daoGD.obtenerCabecerasDeUnConsolidado(oidSolicitud);
            dtoFACConsolidado.setListaSolicitudes(arrayListaSolicitudes);

            ArrayList registrosRecuperados = new ArrayList();

            for (int j = 0; j < arrayListaSolicitudes.size(); j++) {
                DTOFACCabeceraSolicitud dtoFCCS = (DTOFACCabeceraSolicitud) arrayListaSolicitudes.get(j);
                registrosRecuperados.add(dtoFCCS.getOidCabeceraSolicitud());
            }

            /*
             * 2.4.-invocamos al método obtenerPosicionesCabeceras del
             * DAOSolicitudCabecera, pasandole el arrayList que hemos creado
             * al final del paso anterior. Este método nos devuelve un
             * arrayList que deberemos asignarselo al atributo listaPosiciones.
             */
             if (registrosRecuperados.size() > 0) {
                ArrayList listaPosiciones = daoSC.obtenerPosicionesCabeceras(registrosRecuperados);
                dtoFACConsolidado.setListaPosiciones(listaPosiciones);
             } else {
                dtoFACConsolidado.setListaPosiciones(new ArrayList());
             }

            /*
             *  2.5. Llamamos al método obtenerFormulariosUltimasNoticias del
             *  DAOGestionDocumentos pasandole el oidSolicitud. 
             *  - Para cada registro que se obtiene hacer:
             */
            DAOGestionDocumentos daoGestionDocumentos = new DAOGestionDocumentos();
            ArrayList ultimasNoticias = daoGestionDocumentos.obtenerFormulariosUltimasNoticias(oidSolicitud, subacceso);
        
            // Añadido por la BELC300019162 
            dtoFACConsolidado.setOidPais(dtoOidsDocumentos.getOidPais());
            dtoFACConsolidado.setOidIdioma(dtoOidsDocumentos.getOidIdioma());
            
            for (int k = 0; k < ultimasNoticias.size(); k++) { //for(2)

                /*
                 * 2.5.1. Crearemos una instancia del DAOPatronDocumento y llamamos al
                 * método consultarPatronDocumento() pasandole el oidFormulario 
                 * (correspondiente a la vuelta del bucle) y el oidPeriodo
                 * (lo podemos sacar del DTOFACConsolidado). Lo que nos devuelva es el
                 * oidPatron que tiene asociado.
                 */
                DAOPatronDocumento daoPatronDocumento = new DAOPatronDocumento();
                DTODatosTipoFormulario dtoDatosTipoFormulario = null;
                dtoDatosTipoFormulario = (DTODatosTipoFormulario) ultimasNoticias.get(k);

                Long oidFormulario = dtoDatosTipoFormulario.getOidFormulario();
                Long oidPeriodo = dtoFACConsolidado.getDtoCabecera().getPeriodo();
                Long oidPatron = daoPatronDocumento.consultarPatronDocumento(oidFormulario,
                        oidPeriodo);

                /*
                 * 2.5.2. Deberemos llamar al método imprimirMensajesFacturacion
                 * (DTOConsolidado : DTOFACConsolidado, null)
                 * de la clase MONImpresionMensajes para recuperar un vector
                 * dtoMensajesFinal de objetos DTOImpresion.
                 */
                MONImpresionMensajes monImpresionMensajes = this.getMONImpresionMensajesHome();
                DTOImpresion[] dtoImpresion = null;
                ArrayList dtoMensajesFinal = new ArrayList();

                try {
                    dtoImpresion = monImpresionMensajes.imprimirMensajesFacturacion(dtoFACConsolidado);
                } catch (RemoteException re) {
                    UtilidadesLog.error("*** Error en reimprimirUltimasNoticias, monImpresionMensajes.imprimirMensajesFacturacion(dtoFACConsolidado); ",
                        re);

                    String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(re,
                        UtilidadesError.armarCodigoError(codigoError));
                }

                if (dtoImpresion != null)
                    for (int x = 0; x < dtoImpresion.length; x++) {
                        dtoImpresion[x].setOidPais(oidsEntrada.getOidPais());
                        dtoImpresion[x].setOidIdioma(oidsEntrada.getOidIdioma());
                        dtoMensajesFinal.add(dtoImpresion[x]);
                    }

                /*
                 * 2.5.3.- Deberemos llamar al método getDocumentoMensajes() de la clase
                 * MONImpresionMensajes pasandole el oidPatron y los DTOImpresion,
                 * para obtener un DTODocumento
                 */
                MONImpresionSICC monImpresionSICC = this.getMONImpresionSICCHome();
                DTODocumento dtoDocumento = null;

                try {
                  if (dtoMensajesFinal.size() > 0 && oidPatron != null)
                    dtoDocumento = monImpresionSICC.getDocumentoMensajes(oidPatron, dtoMensajesFinal);
                } catch (RemoteException re) {
                    UtilidadesLog.error("*** Error en reimprimirUltimasNoticias, monImpresionSICC.getDocumentoMensajes(oidPatron,dtoMensajesFinal); ",
                        re);

                    String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(re,
                        UtilidadesError.armarCodigoError(codigoError));
                }

                /*
                 * 2.5.4.- Asignaremos al atributo oidImpresoraVirtual del DTODocumento
                 * recuperado en el paso anterior el atributo oidImpresoraVirtual del
                 * DTODatosTipoFormulario
                 */
                
                if (dtoDocumento != null) {
                  dtoDocumento.setTipoDocumento(dtoDatosTipoFormulario.getIdImpresoraVirtual());
  
                  /*
                   * 2.5.5..- Llamamos al método addPrintableDocument del SpoolManager
                   * pasandole el DTODocumento y el idSpool obtenido en el paso 1.
                   */
                  try {
                      spoolManager.addPrintableDocuments(dtoDocumento, idSpool);
                  } catch (RemoteException re) {
                      UtilidadesLog.error("*** Error en reimprimirUltimasNoticias, spoolManager.addPrintableDocuments(dtoDocumento,idSpool); ",
                          re);
  
                      String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                      throw new MareException(re,
                          UtilidadesError.armarCodigoError(codigoError));
                  }
                }
            }

            //fin for(2)
        }

        //fin for(1)
        //3.- Se llama al método closeSpool del SpoolManager pasandole el idSpool.
        try {
            spoolManager.closeSpool(idSpool);
        } catch (RemoteException re) {
            UtilidadesLog.error("*** Error en reimprimirUltimasNoticias, spoolManager.closeSpool(idSpool); ",
                re);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONReimpresionBean.reimprimirUltimasNoticias(DTOOIDsDocumentos dtoOidsDocumentos): Salida");
    }

    // Modificado por la BELC300015675
    public void reimprimirCartaConsultoras(DTOOIDsDocumentos dtoOidsDocumentos)
        throws MareException {
        UtilidadesLog.info("MONReimpresionBean.reimprimirCartaConsultoras(DTOOIDsDocumentos dtoOidsDocumentos): Entrada");

        //ENTRADA: oidsEntrada: DTOOIDs
        //RESUMEN: El objetivo de este método crear el documento "carta consultoras" para todos los oids de consolidados que nos llegan por cabecera.
        Long idSpool = null;

        DTOOIDs oidsEntrada = dtoOidsDocumentos.getLista();
        oidsEntrada.setOidPais(dtoOidsDocumentos.getOidPais());
        oidsEntrada.setOidIdioma(dtoOidsDocumentos.getOidIdioma());
        Long subacceso = dtoOidsDocumentos.getSubacceso();

        // 1.- Llamamos al método openSpool del SpoolManager. Nos devolvera un idSpool.         
        SpoolManager spoolManager = this.getSpoolManagerHome();

        try {
            idSpool = spoolManager.openSpool(subacceso);
        } catch (RemoteException re) {
            UtilidadesLog.error("*** Error en reimprimirCartaConsultoras, spoolManager.openSpool();",
                re);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re,
                UtilidadesError.armarCodigoError(codigoError));
        }

        //2.- Por cada oid contenido en oidsEntrada hacer: 
        Long[] arrayOids = oidsEntrada.getOids();

        for (int i = 0; i < arrayOids.length; i++) { //for(1)

            //2.1.-creamos un DTOFACConsolidado y le asignamos el idSpool obtenido anterior.
            DTOFACConsolidado dtoFACConsolidado = new DTOFACConsolidado();
            dtoFACConsolidado.setIDSpool(idSpool);

            /*
             * 2.2.-invocamos al método obtenerCabecerasSolicitud del DAOSolicitudCabecera,
             * pasandole el oid pertinente según el indice del bucle insertado en un arrayList.
             * Este método nos devuelve un DTOFACabeceraSolicitud que le asignaresmo al atributo
             * dtoCabecera del objeto DTOFACConsolidado que hemos creado al inicio de la vuelta del
             * bucle.
             */
            DAOSolicitudCabecera daoSC = new DAOSolicitudCabecera();
            ArrayList arrayOidSolicitud = new ArrayList();
            Long oidSolicitud = arrayOids[i];
            arrayOidSolicitud.add(oidSolicitud);

            ArrayList arrayListDtoFACCS = daoSC.obtenerCabecerasSolicitud(arrayOidSolicitud);
            DTOFACCabeceraSolicitud dtoFACCS = (DTOFACCabeceraSolicitud) arrayListDtoFACCS.get(0);
            dtoFACConsolidado.setDtoCabecera(dtoFACCS);

            /*
             * 2.3.-invocamos al método obtenerCabecerasDeUnConsolidado pasandole el oid pertinente
             * según el indice del bucle. Este método nos devuelve un arrayList que deberemos
             * asignarselo al atributo listaSolicitud del objeto DTOFACConsolidado que hemos
             * creado al inicio de la vuelta del bucle. Nos creamos un arrayList con los oids de
             * los registros recuperados.
             */
            DAOGestionDocumentos daoGD = new DAOGestionDocumentos();
            ArrayList arrayListaSolicitudes = daoGD.obtenerCabecerasDeUnConsolidado(oidSolicitud);
            dtoFACConsolidado.setListaSolicitudes(arrayListaSolicitudes);

            ArrayList registrosRecuperados = new ArrayList();

            for (int j = 0; j < arrayListaSolicitudes.size(); j++) {
                DTOFACCabeceraSolicitud dtoFCCS = (DTOFACCabeceraSolicitud) arrayListaSolicitudes.get(j);
                registrosRecuperados.add(dtoFCCS.getOidCabeceraSolicitud());
            }

            /*
             * 2.4.-invocamos al método obtenerPosicionesCabeceras del DAOSolicitudCabecera,
             * pasandole el arrayList que hemos creado al final del paso anterior.
             * Este método nos devuelve un arrayList que deberemos asignarselo al atributo
             * listaPosiciones.
             */
             if (registrosRecuperados.size() > 0) {
                ArrayList listaPosiciones = daoSC.obtenerPosicionesCabeceras(registrosRecuperados);
                dtoFACConsolidado.setListaPosiciones(listaPosiciones);
             } else {
                dtoFACConsolidado.setListaPosiciones(new ArrayList());
             }

            /*
             * 2.5. Llamamos al método obtenerFormulariosCartaConsultoras del
             * DAOGestionDocumentos pasandole el oidSolicitud.
             * - Para cada registro que se obtiene hacer:
             */
            DAOGestionDocumentos daoGestionDocumentos = new DAOGestionDocumentos();
            ArrayList cartasConsultoras = daoGestionDocumentos.obtenerFormulariosCartaConsultoras(oidSolicitud, subacceso);

            // Añadido por la BELC300019162 
            dtoFACConsolidado.setOidPais(dtoOidsDocumentos.getOidPais());
            dtoFACConsolidado.setOidIdioma(dtoOidsDocumentos.getOidIdioma());

            for (int k = 0; k < cartasConsultoras.size(); k++) { //for(2)

                /*
                 * 2.5.1. Crearemos una instancia del DAOPatronDocumento y llamamos al método
                 * consultarPatronDocumento() pasandole el oidFormulario
                 * (correspondiente a la vuelta del bucle) y el oidPeriodo
                 * (lo podemos sacar del DTOFACConsolidado).
                 * Lo que nos devuelva es el oidPatron que tiene asociado.
                 */
                DAOPatronDocumento daoPatronDocumento = new DAOPatronDocumento();
                DTODatosTipoFormulario dtoDatosTipoFormulario = null;
                dtoDatosTipoFormulario = (DTODatosTipoFormulario) cartasConsultoras.get(k);

                Long oidFormulario = dtoDatosTipoFormulario.getOidFormulario();
                Long oidPeriodo = dtoFACConsolidado.getDtoCabecera().getPeriodo();
                Long oidPatron = daoPatronDocumento.consultarPatronDocumento(oidFormulario,
                        oidPeriodo);

                /*
                 * 2.5.2. Deberemos llamar al método
                 * imprimirMensajesFacturacion(DTOConsolidado : DTOFACConsolidado, null) de la clase
                 * MONImpresionMensajes para recuperar un vector dtoMensajesFinal de objetos DTOImpresion.
                 */
                MONImpresionMensajes monImpresionMensajes = this.getMONImpresionMensajesHome();
                DTOImpresion[] dtoImpresion = null;
                ArrayList dtoMensajesFinal = new ArrayList();

                try {
                    dtoImpresion = monImpresionMensajes.imprimirMensajesFacturacion(dtoFACConsolidado);
                } catch (RemoteException re) {
                    UtilidadesLog.error("*** Error en reimprimirCartaConsultoras, monImpresionMensajes.imprimirMensajesFacturacion(dtoFACConsolidado); ",
                        re);

                    String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(re,
                        UtilidadesError.armarCodigoError(codigoError));
                }

                if (dtoImpresion != null)
                for (int x = 0; x < dtoImpresion.length; x++) {
                    dtoImpresion[x].setOidPais(oidsEntrada.getOidPais());
                    dtoImpresion[x].setOidIdioma(oidsEntrada.getOidIdioma());
                    dtoMensajesFinal.add(dtoImpresion[x]);
                }

                /*
                 * 2.5.3.- Deberemos llamar al método getDocumentoMensajes() de la clase
                 * MONImpresionMensajes pasandole el oidPatron y los DTOImpresion, para obtener un
                 * DTODocumento
                 */
                MONImpresionSICC monImpresionSICC = this.getMONImpresionSICCHome();
                DTODocumento dtoDocumento = null;

                try {
                    if (dtoMensajesFinal.size() > 0 && oidPatron != null)
                      dtoDocumento = monImpresionSICC.getDocumentoMensajes(oidPatron, dtoMensajesFinal);
                } catch (RemoteException re) {
                    UtilidadesLog.error("*** Error en reimprimirCartaConsultoras, monImpresionSICC.getDocumentoMensajes(oidPatron,dtoMensajesFinal); ",
                        re);

                    String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(re,
                        UtilidadesError.armarCodigoError(codigoError));
                }

                /*
                 * 2.5.4.- Asignaremos al atributo oidImpresoraVirtual del DTODocumento
                 * recuperado en el paso anterior el atributo oidImpresoraVirtual del
                 * DTODatosTipoFormulario
                 */
                if (dtoDocumento != null) {
                  dtoDocumento.setTipoDocumento(dtoDatosTipoFormulario.getIdImpresoraVirtual());
  
                  /*
                   * 2.5.5..- Llamamos al método addPrintableDocument del SpoolManager
                   * pasandole el DTODocumento y el idSpool obtenido en el paso 1.
                   */
                  try {
                      spoolManager.addPrintableDocuments(dtoDocumento, idSpool);
                  } catch (RemoteException re) {
                      UtilidadesLog.error("*** Error en reimprimirCartaConsultoras, spoolManager.addPrintableDocuments(dtoDocumento,idSpool); ",
                          re);
  
                      String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                      throw new MareException(re,
                          UtilidadesError.armarCodigoError(codigoError));
                  }
                }
            }

            //fin for(2).
        }

        //fin for(1).
        //3.- Se llama al método closeSpool del SpoolManager pasandole el idSpool.
        try {
            spoolManager.closeSpool(idSpool);
        } catch (RemoteException re) {
            UtilidadesLog.error("*** Error en reimprimirCartaConsultoras, spoolManager.closeSpool(idSpool); ",
                re);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONReimpresionBean.reimprimirCartaConsultoras(DTOOIDsDocumentos dtoOidsDocumentos): Salida");
    }

    // Modificado por la BELC300015675
    public void reimprimirBoletaDespacho(DTOOIDsDocumentos dtoOidsDocumentos)
        throws MareException {
        UtilidadesLog.info("MONReimpresionBean.reimprimirBoletaDespacho(DTOOIDsDocumentos dtoOidsDocumentos): Entrada");

        //ENTRADA: oidsEntrada: DTOOIDs
        //SALIDA:
        //RESUMEN: El objetivo de este método crear el documento "boleta de d espacho" 
        //para todos los oids de consolidados que nos llegan por cabecera.
        Long idSpool = null;

        DTOOIDs oidsEntrada = dtoOidsDocumentos.getLista();
        Long subacceso = dtoOidsDocumentos.getSubacceso();

        // 1.- Llamamos al método openSpool del SpoolManager. Nos devolvera un idSpool.         
        SpoolManager spoolManager = this.getSpoolManagerHome();

        try {
            idSpool = spoolManager.openSpool(subacceso);
        } catch (RemoteException re) {
            UtilidadesLog.error("*** Error en reimprimirBoletaDespacho, spoolManager.openSpool();",
                re);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re,
                UtilidadesError.armarCodigoError(codigoError));
        }

        //2.- Por cada oid contenido en oidsEntrada hacer: 
        Long[] arrayOids = oidsEntrada.getOids();

        for (int i = 0; i < arrayOids.length; i++) { //for(1)

            //2.1.-creamos un DTOFACConsolidado y le asignamos el idSpool obtenido anterior.
            DTOFACConsolidado dtoFACConsolidado = new DTOFACConsolidado();
            dtoFACConsolidado.setIDSpool(idSpool);

            /*
             * 2.2.-invocamos al método obtenerCabecerasSolicitud del DAOSolicitudCabecera,
             * pasandole el oid pertinente según el indice del bucle insertado en un arrayList.
             * Este método nos devuelve un DTOFACabeceraSolicitud que le asignaresmo al atributo
             * dtoCabecera del objeto DTOFACConsolidado que hemos creado al inicio de la vuelta del
             * bucle.
             */
            DAOSolicitudCabecera daoSC = new DAOSolicitudCabecera();
            ArrayList arrayOidSolicitud = new ArrayList();
            Long oidSolicitud = arrayOids[i];
            arrayOidSolicitud.add(oidSolicitud);

            ArrayList arrayListDtoFACCS = daoSC.obtenerCabecerasSolicitud(arrayOidSolicitud);
            DTOFACCabeceraSolicitud dtoFACCS = (DTOFACCabeceraSolicitud) arrayListDtoFACCS.get(0);
            dtoFACConsolidado.setDtoCabecera(dtoFACCS);

            /*
             * 2.3.-invocamos al método obtenerCabecerasDeUnConsolidado pasandole el oid pertinente
             * según el indice del bucle. Este método nos devuelve un arrayList que deberemos
             * asignarselo al atributo listaSolicitud del objeto DTOFACConsolidado que hemos
             * creado al inicio de la vuelta del bucle. Nos creamos un arrayList con los oids de
             * los registros recuperados.
             */
            DAOGestionDocumentos daoGD = new DAOGestionDocumentos();
            ArrayList arrayListaSolicitudes = daoGD.obtenerCabecerasDeUnConsolidado(oidSolicitud);
            dtoFACConsolidado.setListaSolicitudes(arrayListaSolicitudes);

            ArrayList registrosRecuperados = new ArrayList();

            for (int j = 0; j < arrayListaSolicitudes.size(); j++) {
                DTOFACCabeceraSolicitud dtoFCCS = (DTOFACCabeceraSolicitud) arrayListaSolicitudes.get(j);
                registrosRecuperados.add(dtoFCCS.getOidCabeceraSolicitud());
            }

            /*
             * 2.4.-invocamos al método obtenerPosicionesCabeceras del DAOSolicitudCabecera,
             * pasandole el arrayList que hemos creado al final del paso anterior.
             * Este método nos devuelve un arrayList que deberemos asignarselo al atributo
             * listaPosiciones.
             */
             if (registrosRecuperados.size() > 0) {
                ArrayList listaPosiciones = daoSC.obtenerPosicionesCabeceras(registrosRecuperados);
                dtoFACConsolidado.setListaPosiciones(listaPosiciones);
             } else {
                dtoFACConsolidado.setListaPosiciones(new ArrayList());
             }

            /*
             * 2.5. Llamamos al método obtenerFormulariosBoletaDespacho del DAOGestionDocumentos
             * pasandole el oidSolicitud.
             * - Para cada registro que se obtiene hacer:
             */
            DAOGestionDocumentos daoGestionDocumentos = new DAOGestionDocumentos();
            ArrayList boletaDespacho = daoGestionDocumentos.obtenerFormulariosBoletaDespacho(oidSolicitud, subacceso);

            for (int k = 0; k < boletaDespacho.size(); k++) { //for(2)

                DTODatosTipoFormulario dtoDatosTipoFormulario = null;
                dtoDatosTipoFormulario = (DTODatosTipoFormulario) boletaDespacho.get(k);

                /*
                 * 2.5.1. Creamos un DTODocLegal, tambien creamos un DTOFACDocumentoContable
                 * y un DTOFACDocumentoContableCabecera. Este ultimo se lo añadimos al
                 * DTOFACDocumentoContable y este a su vez al DTODocLegal.
                 */
                DTODocLegal dtoDocLegal = new DTODocLegal();
                DTOFACDocumentoContable dtoDocuConta = new DTOFACDocumentoContable();
                DTOFACDocumentoContableCabecera dtoFACDocuContaCabe = new DTOFACDocumentoContableCabecera();

                dtoDocuConta.setCabecera(dtoFACDocuContaCabe);
                dtoDocLegal.añadirPagina(dtoDocuConta);

                /*
                 * 2.5.2. Invocamos al método obtenerDatosDocumentosNoLegales
                 * (DTOFACCabeceraSolicitud entrada):RecordSet del DAODocuContable,
                 * pasandole el DTOFACCabeceraSolicitud creada en el punto 2.2..
                 * Este método nos devuleve un RecordSet resultados.
                 */
                DAODocuContable daoDocuContable = new DAODocuContable();

                RecordSet resultado = daoDocuContable.obtenerDatosDocumentosNoLegales(dtoFACCS);

                /*
                 * 2.5.3. Invocamos al método rellenarDTOFACDocumentoNoLegal()
                 * del MONImpresionSICC, pasandole el recordSet resultados,
                 * el DTOFACDocumentoContableCabecera creado en el punto 2.5.1. y
                 * el DTOFACConsolidado creado en el punto 2.2..
                 * Esto rellerana lel DTOFACDocumentoContableCabecera.
                 */
                 
                 //seteamos el oidUbigeo llamando al método obtenerOidUbigeoClienteReceptor
                RecordSet rs = daoDocuContable.obtenerOidUbigeoClienteReceptor(dtoFACConsolidado.getDtoCabecera().getReceptorFactura(),
                dtoFACConsolidado.getDtoCabecera().getOidCabeceraSolicitud());
                if (rs!=null)
                {
                    if (!rs.esVacio())
                    {
                        dtoFACDocuContaCabe.setOidUbigeo(new Long(((BigDecimal)rs.getValueAt(0, "VEPO_OID_VALO_ESTR_GEOP")).longValue()));
                    }
                }
                
                MONImpresionSICC monImpresionSICC = this.getMONImpresionSICCHome();
                

               try {
                    dtoFACDocuContaCabe = monImpresionSICC.rellenarDTOFACDocumentoNoLegal(resultado, dtoFACDocuContaCabe,dtoFACConsolidado);
                } catch (RemoteException re) {
                UtilidadesLog.error("*** Error en reimprimirBoletaDespacho, monImpresionSICC.rellenarDTOFACDocumentoNoLegal(); ",
                re);

                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re,
                UtilidadesError.armarCodigoError(codigoError));
                }

                /* Agregado por SiCC20080725 ------ AL */
                RecordSet rs2 = daoDocuContable.obtenerDatosReimpresionBoletaEntrega(dtoFACConsolidado.getDtoCabecera().getOidCabeceraSolicitud(), dtoFACConsolidado.getDtoCabecera().getOidCliente());
                if (rs2 != null && !rs2.esVacio()){
                    dtoFACDocuContaCabe.setSerieDocumentoLegal(UtilidadesBD.convertirAString(rs2.getValueAt(0, "VAL_SERI_DOCU_LEGA")));
                    dtoFACDocuContaCabe.setNumeroDocumentoLegal(UtilidadesBD.convertirALong(rs2.getValueAt(0, "NUM_DOCU_LEGA")));
                    dtoFACDocuContaCabe.setBarrio(UtilidadesBD.convertirAString(rs2.getValueAt(0, "VAL_BARR")));
                    dtoFACDocuContaCabe.setDepartamento(UtilidadesBD.convertirAString(rs2.getValueAt(0, "DEPARTAMENTO")));
                    dtoFACDocuContaCabe.setMunicipio(UtilidadesBD.convertirAString(rs2.getValueAt(0, "MUNICIPIO")));
                    dtoFACDocuContaCabe.setTelefonoFijo(UtilidadesBD.convertirAString(rs2.getValueAt(0, "TELEF_FIJO")));
                    dtoFACDocuContaCabe.setTelefonoCelular(UtilidadesBD.convertirAString(rs2.getValueAt(0, "TELEF_CEL")));
                    dtoFACDocuContaCabe.setPrimerPedido(UtilidadesBD.convertirAString(rs2.getValueAt(0, "PRI_PED")));
                    if (rs2.getValueAt(0, "FECHAENTREGA") != null) {
                        dtoFACDocuContaCabe.setFechaEntrega((Date)rs2.getValueAt(0, "FECHAENTREGA"));
                    }
                    dtoFACDocuContaCabe.setIndicadorReimpresion(Boolean.TRUE);
                }
                /* Agregado por SiCC20080725 ------ AL */
                /*
                 * 2.5.4. Asignaremos al atributo rutinaDiseñoFormulario del
                 * DTOFACDocumentoContableCabecera el atributo rutinaDiseñoFormulario del
                 * DTODatosTipoFormulario correspondiente a la vuelta del bucle.
                 */
                dtoFACDocuContaCabe.setRutinaDiseñoFormulario(dtoDatosTipoFormulario.getRutinaDiseñoFormulario());
                dtoDocuConta.setCabecera(dtoFACDocuContaCabe);
       
                /*
                 * 2.5.5. Invocaremos al método componerDoc() del MONImpresionSICC
                 * pasandole el DTODocLegal. Esto nos devolverá un DTODocumento
                 */ 
                DTODocumento dtoDocumento = null;
                
                DatosClienteHelper datosClienteHelper = new DatosClienteHelper();
                ArrayList listaPaginas=dtoDocLegal.getlistaPaginas();
                dtoDocLegal.setUsuario(ctx.getCallerPrincipal().getName());
                DTOFACDocumentoContable docuContable=(DTOFACDocumentoContable)listaPaginas.get(0);              
                DTOClienteSolicitud dtoClienteSolicitud = datosClienteHelper.obtenerDatosCliente(docuContable.getCabecera().getOidCabeceraSolicitud(), dtoDocLegal.getUsuario());

                try {
                    dtoDocumento = monImpresionSICC.componerDoc(dtoDocLegal, dtoClienteSolicitud);
                } catch (RemoteException re) {
                    UtilidadesLog.error("*** Error en reimprimirBoletaDespacho, monImpresionSICC.monImpresionSICC.componerDoc(dtoDocLegal); ",
                        re);

                    String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(re,
                        UtilidadesError.armarCodigoError(codigoError));
                }

                /*
                 * 2.5.6. Asignaremos al atributo oidImpresoraVirtual del DTODocumento
                 * recuperado en el paso anterior el atributo oidImpresoraVirtual
                 * del DTODatosTipoFormulario
                 */
              if (dtoDocumento != null) {
                dtoDocumento.setTipoDocumento(dtoDatosTipoFormulario.getIdImpresoraVirtual());

                /*
                 * 2.5.7.- Llamamos al método addPrintableDocument del SpoolManager
                 * pasandole el DTODocumento y el idSpool obtenido en el paso 1.
                 */
                try {
                    spoolManager.addPrintableDocuments(dtoDocumento, idSpool);
                } catch (RemoteException re) {
                    UtilidadesLog.error("*** Error en reimprimirBoletaDespacho, spoolManager.addPrintableDocuments(dtoDocumento,idSpool); ",
                        re);

                    String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(re,
                        UtilidadesError.armarCodigoError(codigoError));
                }
              }
            }

            //fin for(2).
        }

        //fin for(1).
        //3.- Se llama al método closeSpool del SpoolManager pasandole el idSpool.
        try {
            spoolManager.closeSpool(idSpool);
        } catch (RemoteException re) {
            UtilidadesLog.error("*** Error en reimprimirBoletaDespacho, spoolManager.closeSpool(idSpool); ",
                re);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONReimpresionBean.reimprimirBoletaDespacho(DTOOIDsDocumentos dtoOidsDocumentos): Salida");
    }

    public DTOSalida obtenerSolicitudesCupones(DTODatosCupones dtoEntrada)
        throws MareException {
        UtilidadesLog.info("MONReimpresionBean.obtenerSolicitudesCupones(DTODatosCupones dtoEntrada): Entrada");
        UtilidadesLog.debug("DTODatosCupones recibido: " + dtoEntrada);

        // ENTRADA: datosEntrada: DTODatosCupones
        // SALIDA: datosSalida: DTOSalida
        // RESUMEN: El objetivo de este método es obtener los datos que se deben mostrar como resultado de la busqueda hecha por el usuario.
        //1.- invocamos al método obtenerSolicitudesCupon( datosEntrada ) 
        //del DAOGestionDocumentos. Tendremos que devolver la salida de esta invocación.
        String usuario = ctx.getCallerPrincipal().getName();
        DAOGestionDocumentos daoGestionDocumentos = new DAOGestionDocumentos(usuario);
        DTOSalida dtoSalida = daoGestionDocumentos.obtenerSolicitudesCupon(dtoEntrada);

        UtilidadesLog.info("MONReimpresionBean.obtenerSolicitudesCupones(DTODatosCupones dtoEntrada): Salida");

        return dtoSalida;
    }

    // Modificado por la BELC300015675
    public void imprimirCuponReemplazo(DTOOIDsDocumentos dtoOidsDocumentos)
        throws MareException {
        UtilidadesLog.info("MONReimpresionBean.imprimirCuponReemplazo(DTOOIDsDocumentos dtoOidsDocumentos): Entrada");

        //ENTRADA: oidsEntrada: DTOOIDs
        //RESUMEN: El objetivo de este método crear el documento "Cupon de Reemplazo" para todos los oids de consolidados que nos llegan por cabecera.
        Long idSpool = null;

        DTOOIDs oidsEntrada = dtoOidsDocumentos.getLista();
        Long subacceso = dtoOidsDocumentos.getSubacceso();
        
        UtilidadesLog.debug("subacceso: " + subacceso);

        // 1.- Llamamos al método openSpool del SpoolManager. Nos devolvera un idSpool.         
        SpoolManager spoolManager = this.getSpoolManagerHome();

        try {
            idSpool = spoolManager.openSpool(subacceso);
        } catch (RemoteException re) {
            UtilidadesLog.error("*** Error en imprimirCuponReemplazo, spoolManager.openSpool();",
                re);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re,
                UtilidadesError.armarCodigoError(codigoError));
        }

        //2.- Por cada oid contenido en oidsEntrada hacer: 
        Long[] arrayOids = oidsEntrada.getOids();

        for (int i = 0; i < arrayOids.length; i++) { //for(1)
            UtilidadesLog.debug("Iteracion: " + i + " - OID: " + arrayOids[i]);

            //2.1.-creamos un DTOFACConsolidado y le asignamos el idSpool obtenido anterior.
            DTOFACConsolidado dtoFACConsolidado = new DTOFACConsolidado();
            dtoFACConsolidado.setIDSpool(idSpool);

            /*
             *  2.2.-invocamos al método obtenerCabecerasSolicitud del DAOSolicitudCabecera,
             *  pasandole el oid pertinente según el indice del bucle
             *  insertado en un arrayList.
             *  Este método nos devuelve un DTOFACabeceraSolicitud que le asignaremos
             *  al atributo dtoCabecera del objeto DTOFACConsolidado
             *  que hemos creado al inicio de la vuelta del bucle.
             */
            DAOSolicitudCabecera daoSC = new DAOSolicitudCabecera();
            ArrayList arrayOidSolicitud = new ArrayList();
            Long oidSolicitud = arrayOids[i];
            arrayOidSolicitud.add(oidSolicitud);

            ArrayList arrayListDtoFACCS = daoSC.obtenerCabecerasSolicitud(arrayOidSolicitud);
            DTOFACCabeceraSolicitud dtoFACCS = (DTOFACCabeceraSolicitud) arrayListDtoFACCS.get(0);
            dtoFACCS.setOidIdioma(oidsEntrada.getOidIdioma());
            dtoFACConsolidado.setDtoCabecera(dtoFACCS);

            /*
             * 2.3.-invocamos al método obtenerCabecerasDeUnConsolidado
             * pasandole el oid pertinente según el indice del bucle.
             * Este método nos devuelve un arrayList que deberemos asignarselo
             * al atributo listaSolicitud del objeto DTOFACConsolidado que hemos
             * creado al inicio de la vuelta del bucle. Nos creamos un arrayList
             * con los oids de los registros recuperados.
             */
            DAOGestionDocumentos daoGD = new DAOGestionDocumentos();
            ArrayList arrayListaSolicitudes = daoGD.obtenerCabecerasDeUnConsolidado(oidSolicitud);
            dtoFACConsolidado.setListaSolicitudes(arrayListaSolicitudes);

            ArrayList registrosRecuperados = new ArrayList();
            Integer numeroDecimales = new Integer(0);

            for (int j = 0; j < arrayListaSolicitudes.size(); j++) {
                DTOFACCabeceraSolicitud dtoFCCS = (DTOFACCabeceraSolicitud) arrayListaSolicitudes.get(j);
                registrosRecuperados.add(dtoFCCS.getOidCabeceraSolicitud());
                numeroDecimales = new Integer(dtoFCCS.getNumeroDecimalesRedondeo().intValue());
            }

            /*
             * 2.4.-invocamos al método obtenerPosicionesCabeceras del
             * DAOSolicitudCabecera, pasandole el arrayList que hemos creado
             * al final del paso anterior. Este método nos devuelve un
             * arrayList que deberemos asignarselo al atributo listaPosiciones.
             */
             if (registrosRecuperados.size() > 0) {
                ArrayList listaPosiciones = daoSC.obtenerPosicionesCabeceras(registrosRecuperados);
                dtoFACConsolidado.setListaPosiciones(listaPosiciones);
             } else {
                dtoFACConsolidado.setListaPosiciones(new ArrayList());
             }

            /*
             * 2.5. Llamamos al método obtenerFormulariosCuponReemplazo del
             * DAOGestionDocumentos pasandole el oidSolicitud.
             * - Para cada registro que se obtiene hacer:
             */
            
            ArrayList cuponRemplazo = daoGD.obtenerFormulariosCuponReemplazo(oidSolicitud, subacceso);
            UtilidadesLog.debug("cuponRemplazo: " + cuponRemplazo);

            for (int k = 0; k < cuponRemplazo.size(); k++) { //for(2)

                DTODatosTipoFormulario dtoDatosTipoFormulario = null;
                dtoDatosTipoFormulario = (DTODatosTipoFormulario) cuponRemplazo.get(k);

                /*
                 * 2.5.1. Creamos un DTODocLegal, tambien creamos un DTOFACDocumentoContable
                 * y un DTOFACDocumentoContableCabecera. Este ultimo se lo añadimos al
                 * DTOFACDocumentoContable y este a su vez al DTODocLegal.
                 */
                DTODocLegal dtoDocLegal = new DTODocLegal();
                DTOFACDocumentoContable dtoDocuConta = new DTOFACDocumentoContable();
                DTOFACDocumentoContableCabecera dtoFACDocuContaCabe = new DTOFACDocumentoContableCabecera();
                dtoFACDocuContaCabe.setNumeroDecimales(numeroDecimales);

                dtoDocuConta.setCabecera(dtoFACDocuContaCabe);
                dtoDocLegal.añadirPagina(dtoDocuConta);

                /*
                 * 2.5.2. Invocamos al método obtenerDatosDocumentosNoLegales
                 * (DTOFACCabeceraSolicitud entrada):RecordSet del DAODocuContable,
                 * pasandole el DTOFACCabeceraSolicitud creada en el punto 2.2..
                 * Este método nos devuleve un RecordSet resultados.
                 */
                DAODocuContable daoDocuContable = new DAODocuContable();

                RecordSet resultado = daoDocuContable.obtenerDatosDocumentosNoLegales(dtoFACCS);

                /*
                 * 2.5.3. Invocamos al método rellenarDTOFACDocumentoNoLegal() del
                 * MONImpresionSICC, pasandole el recordSet resultados, el
                 * DTOFACDocumentoContableCabecera creado en el punto 2.5.1. y el
                 * DTOFACConsolidado creado en el punto 2.2..
                 * Esto rellerana lel DTOFACDocumentoContableCabecera.
                 */
                 
                 //seteamos el oidUbigeo llamando al método obtenerOidUbigeoClienteReceptor
                RecordSet rs = daoDocuContable.obtenerOidUbigeoClienteReceptor(dtoFACConsolidado.getDtoCabecera().getReceptorFactura(),
                dtoFACConsolidado.getDtoCabecera().getOidCabeceraSolicitud());
                if (rs!=null)
                {
                    if (!rs.esVacio())
                    {
                        dtoFACDocuContaCabe.setOidUbigeo(new Long(((BigDecimal)rs.getValueAt(0, "VEPO_OID_VALO_ESTR_GEOP")).longValue()));
                    }
                }
                
                MONImpresionSICC monImpresionSICC = this.getMONImpresionSICCHome();

                try {
                    dtoFACDocuContaCabe = monImpresionSICC.rellenarDTOFACDocumentoNoLegal(resultado,  dtoFACDocuContaCabe,dtoFACConsolidado);
                } catch (RemoteException re) {
                UtilidadesLog.error("*** Error en imprimirCuponReemplazo,  monImpresionSICC.rellenarDTOFACDocumentoNoLegal(); ",
                re);

                /* Agregado por Cambio FAC-003-COL ------ AL */
                dtoFACDocuContaCabe.setIndicadorReimpresion(Boolean.TRUE);
                /* Agregado por Cambio FAC-003-COL ------ AL */

                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re,
                UtilidadesError.armarCodigoError(codigoError));
                }
                dtoDocuConta.setCabecera(dtoFACDocuContaCabe);           
                /*
                 * 2.5.4. Llamaremos al método componerDatosCCC del MONImpresionSICC.
                 */
                DatosClienteHelper datosClienteHelper = new DatosClienteHelper();
                ArrayList listaPaginas=dtoDocLegal.getlistaPaginas();
                dtoDocLegal.setUsuario(ctx.getCallerPrincipal().getName());
                DTOFACDocumentoContable docuContable=(DTOFACDocumentoContable)listaPaginas.get(0);              
                DTOClienteSolicitud dtoClienteSolicitud = datosClienteHelper.obtenerDatosCliente(docuContable.getCabecera().getOidCabeceraSolicitud(), dtoDocLegal.getUsuario());
                try {
                    dtoDocLegal = monImpresionSICC.componerDatosCCC(dtoFACConsolidado, dtoDocLegal);
                } catch (RemoteException re) {
                    UtilidadesLog.error("*** Error en imprimirCuponReemplazo, monImpresionSICC.componerDatosCCC(dtoFACConsolidado,dtoDocLegal); ",
                        re);

                    String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(re,
                        UtilidadesError.armarCodigoError(codigoError));
                }

                /*
                 * 2.5.5. Asignaremos al atributo rutinaDiseñoFormulario del
                 * DTOFACDocumentoContableCabecera el atributo
                 * rutinaDiseñoFormulario del DTODatosTipoFormulario
                 * correspondiente a la vuelta del bucle.
                 */
                ((DTOFACDocumentoContable)(dtoDocLegal.getlistaPaginas().get(0))).getCabecera().setRutinaDiseñoFormulario(dtoDatosTipoFormulario.getRutinaDiseñoFormulario());

                /*
                 * 2.5.6. Invocaremos al método componerDoc() del MONImpresionSICC
                 * pasandole el DTODocLegal. Esto nos devolverá un DTODocumento
                 */
                DTODocumento dtoDocumento = null;
                
                try {
                    //dtoDocumento = monImpresionSICC.componerDoc(dtoDocLegal);
                    dtoDocumento = monImpresionSICC.componerDoc(dtoDocLegal, dtoClienteSolicitud);
                } catch (Exception re) {
                    UtilidadesLog.error("*** Error en imprimirCuponReemplazo, monImpresionSICC.componerDoc(dtoDocLegal); ",
                        re);

                    String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(re,
                        UtilidadesError.armarCodigoError(codigoError));
                }

                /*
                 * 2.5.7. Asignaremos al atributo oidImpresoraVirtual del DTODocumento
                 * recuperado en el paso anterior el atributo oidImpresoraVirtual
                 * del DTODatosTipoFormulario
                 */
                if (dtoDocumento != null) {
                  dtoDocumento.setTipoDocumento(dtoDatosTipoFormulario.getIdImpresoraVirtual());
                  
                  UtilidadesLog.debug("dtoDocumento:" + dtoDocumento);
  
                  /*
                   * 2.5.8.- Llamamos al método addPrintableDocument del SpoolManager
                   * pasandole el DTODocumento y el idSpool obtenido en el paso 1.
                   */
                  try {
                      spoolManager.addPrintableDocuments(dtoDocumento, idSpool);
                  } catch (RemoteException re) {
                      UtilidadesLog.error("*** Error en imprimirCuponReemplazo, spoolManager.addPrintableDocuments(dtoDocumento,idSpool); ",
                          re);
  
                      String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                      throw new MareException(re,
                          UtilidadesError.armarCodigoError(codigoError));
                  }
              }
            }

            //fin for(2).
        }

        //fin for(1).
        //3.- Se llama al método closeSpool del SpoolManager pasandole el idSpool.
        try {
            spoolManager.closeSpool(idSpool);
        } catch (RemoteException re) {
            UtilidadesLog.error("*** Error en imprimirCuponReemplazo, spoolManager.closeSpool(idSpool); ",
                re);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONReimpresionBean.imprimirCuponReemplazo(DTOOIDsDocumentos dtoOidsDocumentos): Salida");
    }

   
    private SpoolManager getSpoolManagerHome() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONReimpresionBean.getSpoolManagerHome(): Entrada");

        SpoolManagerHome home = (SpoolManagerHome) UtilidadesEJB.getHome("SpoolManager",
                SpoolManagerHome.class);

        // Se obtiene el interfaz remoto
        SpoolManager ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getSpoolManagerHome", e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONReimpresionBean.getSpoolManagerHome(): Salida");

        return ejb;
    }

    private MONImpresionSICC getMONImpresionSICCHome()
        throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONReimpresionBean.getMONImpresionSICCHome(): Entrada");

        MONImpresionSICCHome home = (MONImpresionSICCHome) UtilidadesEJB.getHome("MONImpresionSICC",
                MONImpresionSICCHome.class);

        // Se obtiene el interfaz remoto
        MONImpresionSICC ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONImpresionSICCHome", e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONReimpresionBean.getMONImpresionSICCHome(): Salida");

        return ejb;
    }

    private MONImpresionMensajes getMONImpresionMensajesHome()
        throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONReimpresionBean.getMONImpresionMensajesHome(): Entrada");

        MONImpresionMensajesHome home = (MONImpresionMensajesHome) UtilidadesEJB.getHome("MONImpresionMensajes",
                MONImpresionMensajesHome.class);

        // Se obtiene el interfaz remoto
        MONImpresionMensajes ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONImpresionMensajesHome", e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONReimpresionBean.getMONImpresionMensajesHome(): Salida");

        return ejb;
    }
    
}