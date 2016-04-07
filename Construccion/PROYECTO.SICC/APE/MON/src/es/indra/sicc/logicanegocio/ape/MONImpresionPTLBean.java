/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.logicanegocio.ape;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.print.SpoolManagerLocal;
import es.indra.sicc.dtos.ape.DTOBusquedaEtiqueta;
import es.indra.sicc.dtos.ape.DTODatosImpresionEtiquetas;
import es.indra.sicc.dtos.ape.DTOEtiqueta;
import es.indra.sicc.dtos.intsys.DTOEtiquetaInduccionPTL;
import es.indra.sicc.dtos.ped.DTOSeguimientoPedidos;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTODocumento;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
//import es.indra.sicc.entidades.ape.ListaPicadoCabeceraLocal;
//import es.indra.sicc.entidades.ape.ListaPicadoCabeceraLocalHome;
import es.indra.sicc.logicanegocio.ped.MONSeguimientoPedidosLocal;
import es.indra.sicc.logicanegocio.ped.MONSeguimientoPedidosLocalHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
//import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import javax.ejb.CreateException;
//import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import java.util.ArrayList;
import es.indra.sicc.cmn.negocio.print.SpoolManagerLocalHome;
import es.indra.sicc.util.UtilidadesBD;

public class MONImpresionPTLBean implements SessionBean 
{
  public void ejbCreate()
  {
  }

  public void ejbActivate()
  {
  }

  public void ejbPassivate()
  {
  }

  public void ejbRemove()
  {
  }

  public void setSessionContext(SessionContext ctx)
  {
  }

  public void imprimirEtiquetasPTL(ArrayList arrayDTO) throws MareException {
      UtilidadesLog.info("MONImpresionPTLBean.imprimirEtiquetasPTL(ArrayList arrayDTO): Entrada");
      
      if (arrayDTO != null) {
      
          UtilidadesLog.debug("arrayDTO: " + arrayDTO);
      
          SpoolManagerLocal spoolManager = null;
          try {
              spoolManager = this.getSpoolManagerLocalHome().create();
          } catch (CreateException e) {
              String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
              throw new MareException(e, UtilidadesError.armarCodigoError(error));
          }
      
          DAOImpresionPTL daoPTL = new DAOImpresionPTL();
          DAOImpresionEtiquetasManual daoManual = new DAOImpresionEtiquetasManual();
          //ListaPicadoCabeceraLocalHome listaCabHome = this.getListaPicadoCabeceraLocalHome();
          DAOEtiquetado daoEtiq = new DAOEtiquetado();
          
          /* BELC400000524 - dmorello, 22/06/2007 */
          HashMap impresorasDatos = new HashMap();
          Long oidListaPicadoCabecera = null;
          Long oidSolicitudCabecera = null;
          Hashtable listasPicadoProcesadas = new Hashtable(); // AGREGADO - eiraola 03/09/2007 - BELC400000690
          ArrayList etiquetasImpresas = new ArrayList();
          
          /* BELC400000635 - dmorello, 04/09/2007 */
          ArrayList arrayEtiquetas = new ArrayList();
          ArrayList arrayEtiquetasCrear = new ArrayList();
          
          // Cambio APE-04 - dmorello, 10/01/2008
          ArrayList arrayEtiquetasActualizar = new ArrayList();
      
          int size = arrayDTO.size();
          for (int i = 0; i < size; i++) {
              DTOEtiquetaInduccionPTL dto = (DTOEtiquetaInduccionPTL)arrayDTO.get(i);
              UtilidadesLog.debug("dto para iteracion " + i + ':' + dto);
              DTOBusquedaEtiqueta dtoBusqueda = new DTOBusquedaEtiqueta();
              dtoBusqueda.setNroSolicCabec(dto.getNroSolicitud());
              dtoBusqueda.setNroCaja(new Integer(dto.getNroCaja().intValue()));
              dtoBusqueda.setOidPais(dto.getOidPais());
              
              
              // Busco datos de la etiqueta para el consolidado y el numero de caja del dto
              // Si no hay etiqueta creada, el campo OID_ETIQ viene nulo
              RecordSet etiquetasImprimir = daoPTL.recuperarInformacionEtiquetasPTL(dtoBusqueda);
              UtilidadesLog.debug("etiquetasImprimir: " + etiquetasImprimir);
              
              
              // dmorello, 05/03/2007: El RecordSet traerá a lo sumo un registro
              if (! etiquetasImprimir.esVacio()) {

                  /* Busco los datos del cliente para imprimir */
                  DTOOIDs dtoClientes = new DTOOIDs();
                  BigDecimal oidCliente = (BigDecimal)etiquetasImprimir.getValueAt(0, "OID_CLIE");
                  Long[] oids = { new Long(oidCliente.longValue()) };
                  dtoClientes.setOids(oids);
                  dtoClientes.setOidPais(dto.getOidPais());
                  
                  HashMap hashTextoVariable = daoManual.recuperarTextosVariables(dtoClientes);
                  //RecordSet datosCliente = daoManual.obtenerDatosClientes(dtoClientes);
                  
                  /* BELC400000635 - dmorello, 04/09/2007
                   * Genero el DTOEtiqueta para la etiqueta actual
                   * y elimino la insercion de la etiqueta en BD */
                  // Cambio APE-04 - dmorello, 10/01/2008 - Modifico llamada por cambio de firma del metodo
                  //DTOEtiqueta dtoEtiqueta = this.armarDTOEtiqueta(etiquetasImprimir, hashTextoVariable, dto.getOidPais(), dto.getCodImpresora());
                  DTOEtiqueta dtoEtiqueta = this.armarDTOEtiqueta(etiquetasImprimir, hashTextoVariable, dto);
                  
                  UtilidadesLog.debug("DTOEtiqueta apenas salgo de armarDTOEtiqueta: " + dtoEtiqueta);
                  
                  UtilidadesLog.debug(".... el Numero Total de Cajas que debemos setear "
                                     +"es el que viene de la Interfaz: " + dto.getNroTotalCajas());
                  dtoEtiqueta.setNumeroTotalCajas(dto.getNroTotalCajas());

                  /* Genero la etiqueta si no existe y guardo su OID */
                  Object objOidEtiqueta = etiquetasImprimir.getValueAt(0, "OID_ETIQ");
                  //Long oidEtiqueta = null;
                  if (objOidEtiqueta == null) {
                      arrayEtiquetasCrear.add(dtoEtiqueta);
                      // Inserto en BD
                      //Object objTextoVar = hashTextoVariable.get(oidCliente);
                      //String textoVar = (objTextoVar != null)? objTextoVar.toString() : null;
                      //oidEtiqueta = daoPTL.insertarEtiqueta(etiquetasImprimir, textoVar, dto.getOidPais(), dto.getNroCaja(), dto.getNroTotalCajas());
                  } else {
                      //oidEtiqueta = new Long(((BigDecimal)objOidEtiqueta).longValue());
                      dtoEtiqueta.setOidEtiqueta(new Long(((BigDecimal)objOidEtiqueta).longValue()));
                      
                      // Cambio APE-04 - dmorello, 10/01/2008
                      arrayEtiquetasActualizar.add(dtoEtiqueta);
                  }
                  
                  arrayEtiquetas.add(dtoEtiqueta);
                  /* Fin BELC400000635 dmorello 04/09/2007 */
              }
          }
                  
          /* BELC400000635 - dmorello, 04/09/2007
           * Se crean en este punto las etiquetas que no existan */
          daoPTL.insertarEtiquetas(arrayEtiquetasCrear);
          
          // Cambio APE-04 - dmorello, 10/01/2008
          daoPTL.actualizarEtiquetas(arrayEtiquetasActualizar);
          
          /* BELC400000635 - dmorello, 04/09/2007  - Se prepara la impresion de etiquetas */
          size = arrayEtiquetas.size();
          for (int i = 0; i < size; i++) {
                  DTOEtiqueta dtoEtiqueta = (DTOEtiqueta)arrayEtiquetas.get(i);
              
                  /* Verifico si hay formato para imprimir */
                  //Object formato = etiquetasImprimir.getValueAt(0, "NOMBR_PROGR");
                  //UtilidadesLog.debug("formato: " + formato);
                  //if (formato == null) {
                  if (dtoEtiqueta.getFormatoEtiqueta() == null) {
                      /*  Loguear el error y continuar con el siguiente elemento de arrayDTO */
                      //LogAPP.error(this.getMensajeErrorFormatoNoDefinido(dto.getNroSolicitud(), dto.getNroCaja()));
                      LogAPP.error(this.getMensajeErrorFormatoNoDefinido(dtoEtiqueta.getNumeroConsolidado(),dtoEtiqueta.getNumeroCaja()));
                      
                      // dmorello, 15/03/2007
                      /* BELC400000524 - dmorello 22/06/2007:
                       * Se agrega la etiqueta al ArrayList para marcarla como impresa despues */
                      //daoPTL.marcarEtiquetaComoImpresa(oidEtiqueta);
                      
                      /* BELC400000635 - dmorello, 04/09/2007 */
                      //etiquetasImpresas.add(oidEtiqueta);
                      etiquetasImpresas.add(dtoEtiqueta.getOidEtiqueta());
                      
                      
                  } else {

                      /* Armo DTO con datos para imprimir */
                      DTOOIDs dtoClientes = new DTOOIDs();
                      Long[] oids = { dtoEtiqueta.getOidCliente() };
                      dtoClientes.setOids(oids);
                      RecordSet datosCliente = daoManual.obtenerDatosClientes(dtoClientes);

                      DTODatosImpresionEtiquetas dtoImpresion = this.armarDTODatosImpresionEtiquetas(dtoEtiqueta, datosCliente);
                      
                      
                      /* Obtengo el programa correspondiente al formato de la etiqueta */
                      AbstractEtiqueta etiquetaImprimir = null;
                      try {
                          //etiquetaImprimir = (AbstractEtiqueta)Class.forName("es.indra.sicc.logicanegocio.ape." + formato).newInstance();
                          etiquetaImprimir = (AbstractEtiqueta)Class.forName("es.indra.sicc.logicanegocio.ape." + dtoEtiqueta.getFormatoEtiqueta()).newInstance();
                      } catch (Exception e) {
                          LogAPP.error("Error al buscar o instanciar la clase correspondiente al formato " + dtoEtiqueta.getFormatoEtiqueta());
                          continue; // Paso al siguiente elemento de arrayDTO
                      }
                      
                      
                      /* Genero los bytes para enviar a la impresora */
                      byte[] bytesEtiqueta = etiquetaImprimir.componerEtiqueta(dtoImpresion);

                      // Creo un spool para imprimir la etiqueta
                      //Long sublinea = new Long(((BigDecimal)etiquetasImprimir.getValueAt(0, "OID_SUBL_ARMA")).longValue());
                      Long subacceso = ConstantesAPE.SUBACCESO_DEFECTO;
                      //Long idSpool = spoolManager.openSpoolEtiquetas(subacceso, sublinea);
                      
                      // Obtengo la impresora donde enviar las etiquetas
                      //Long oidImpresora = daoEtiq.recuperarImpresoraEtiquetado(subacceso, sublinea, dto.getCodImpresora());
                      Long oidImpresora = daoEtiq.recuperarImpresoraEtiquetado(subacceso, dtoEtiqueta.getOidSublineaArmado(), dtoEtiqueta.getCodigoImpresora());
                      if (oidImpresora == null) {
                          throw new MareException("No existe impresora asociada al subacceso y la sublinea");
                      }
                      //Long idSpool = spoolManager.openSpoolEtiquetas(subacceso, oidImpresora);
                      
                      /* BELC400000524 - dmorello, 21/06/2007 */
                      ByteArrayOutputStream stream;
                      if (! impresorasDatos.containsKey(oidImpresora)) {
                          stream = new ByteArrayOutputStream();
                          impresorasDatos.put(oidImpresora, stream);
                      } else {
                          stream = (ByteArrayOutputStream)impresorasDatos.get(oidImpresora);
                      }
                      
                      /* Imprimo la etiqueta tantas veces como se indique en NUM_ETIQ */
                      //Object numEtiqFormatos = etiquetasImprimir.getValueAt(0, "NUM_ETIQ");
                      //int numEtiquetas = (numEtiqFormatos != null)? ((BigDecimal)numEtiqFormatos).intValue() : 1;
                      int numEtiquetas = (dtoEtiqueta.getNumeroEtiquetasCaja() != null)?
                                                dtoEtiqueta.getNumeroEtiquetasCaja().intValue()
                                              : 1;
                      //DTODocumento dtoDocu = new DTODocumento();
                      //dtoDocu.setDocumentoByte(bytesEtiqueta);
                      //dtoDocu.setTipoDocumento(oidImpresora);
                      for (int k = 0; k < numEtiquetas; k++) {
                           //spoolManager.addPrintableDocuments(dtoDocu, idSpool);
                          try {
                              stream.write(bytesEtiqueta);
                          } catch (IOException e) {
                              throw new MareException(e);
                          }
                      }
                      //etiquetasImpresas.add(oidEtiqueta);
                      etiquetasImpresas.add(dtoEtiqueta.getOidEtiqueta());
                      
                      //spoolManager.closeSpoolEtiquetas(idSpool);
                      
                      /* Actualizo estado de etiqueta */
                      //daoPTL.marcarEtiquetaComoImpresa(oidEtiqueta);
                      
                      
                      /* Actualizo fecha y hora de inicio de embalaje en la lista */
                      //ListaPicadoCabeceraLocal lista = null;
                      //try {
                          //Long oidListaPicado = new Long(((BigDecimal)etiquetasImprimir.getValueAt(0, "OID_LIST_PICA_CABE")).longValue());
                          if (oidListaPicadoCabecera == null) {
                              //BigDecimal bdOidLista = (BigDecimal)etiquetasImprimir.getValueAt(0, "OID_LIST_PICA_CABE");
                              //oidListaPicadoCabecera = new Long(bdOidLista.longValue());
                              oidListaPicadoCabecera = dtoEtiqueta.getListaPicado();
                          }
                          if (oidSolicitudCabecera == null) {
                              //BigDecimal bdOidSolicitud = (BigDecimal)etiquetasImprimir.getValueAt(0, "OID_SOLI_CABE");
                              //oidSolicitudCabecera = new Long(bdOidSolicitud.longValue());
                              oidSolicitudCabecera = dtoEtiqueta.getSolicitudCabecera();
                          }
                          //UtilidadesLog.debug("oidListaPicado: " + oidListaPicado);
                          //lista = listaCabHome.findByPrimaryKey(oidListaPicado);
                          //if (lista.getFechaHoraInicioEmbalaje() == null) {
                          //    lista.setFechaHoraInicioEmbalaje(new Timestamp(System.currentTimeMillis()));
                          //}
                          /* Recupero el codigo de la lista y la fecha/hora inicio embalaje
                           * Esta query recupera siempre un registro */
                          //RecordSet codFecha = daoPTL.getCodFechaInicioEmbalajeLista(oidListaPicado);
                          //Long codLista = null;
                          //if (codFecha != null && ! codFecha.esVacio()) {
                              //codLista = new Long(((BigDecimal)codFecha.getValueAt(0,"COD_LIST_PICA")).longValue());
                              //Object fecha = codFecha.getValueAt(0,"FEC_HORA_INIC_EMBA");
                              //if (fecha == null) {
                              //    daoPTL.actualizarFechaInicioEmbalajeLista(oidListaPicado);
                              //}
                          //} else {
                      //} catch (FinderException e) {
                          //String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                          //throw new MareException(e, UtilidadesError.armarCodigoError(error));
                          //throw new MareException("", UtilidadesError.armarCodigoError(error));
                      //}
                      
                      
                      /* dmorello, 12/03/2007: Llamo al CU Actualizar seguimiento pedidos (PED) */
                      //if (monSeguimiento == null) {
                      //    try {
                      //        monSeguimiento = this.getMONSeguimientoPedidosLocalHome().create();
                      //    } catch (CreateException e) {
                      //        String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                      //        throw new MareException(e, UtilidadesError.armarCodigoError(error));
                      //    }
                      //}
                      
                      // Obtengo el OID de consolidado para setear al DTO
                      //Long oidCons = new Long(((BigDecimal)etiquetasImprimir.getValueAt(0,"OID_SOLI_CABE")).longValue());
                  
                      //DTOSeguimientoPedidos dtoX = new DTOSeguimientoPedidos();
                      //dtoX.setConsolidado(oidCons);
                      //dtoX.setSolicitud(oidCons);
                      //dtoX.setHitoSeguimiento(ConstantesPED.HITO_10);
                      //dtoX.setNumeroDocumento(lista.getCodigoListaPicado().toString());
                      //dtoX.setNumeroDocumento(codLista.toString());
                      //dtoX.setFecha(new Date(System.currentTimeMillis()));
                      //dtoX.setIndCompleto(Boolean.TRUE);
                      
                      //monSeguimiento.actualizarSeguimientoPedidos(dtoX);
                      /* Fin BELC400000524 dmorello 22/06/2007 */
                      
                  } // Fin if (formato == null)
                  
              //} // Fin if (! etiquetasImprimir.esVacio())    
              
              // AGREGADO - eiraola 03/09/2007 - BELC400000690 [INICIO]
              if (oidListaPicadoCabecera != null) {
                  UtilidadesLog.debug("[acumulando lista] Consolidado (oid): " + oidSolicitudCabecera + 
                          " Lista de picado cabec (oid): " + oidListaPicadoCabecera );
                  listasPicadoProcesadas.put(oidSolicitudCabecera, oidListaPicadoCabecera);
              }
              // AGREGADO - eiraola 03/09/2007 - BELC400000690 [FIN]
              

          } // Fin FOR recorrido arrayDTO
          
          // AGREGADO - eiraola 03/09/2007 - BELC400000690 [FIN]
          Set oidsConsolidado = listasPicadoProcesadas.keySet();
          Iterator itCons = oidsConsolidado.iterator();
          
          UtilidadesLog.debug("... Preparando para actualizar FechaInicioEmbalaje y Seguimiento "
                  +"pedidos (cant Elementos: "+ listasPicadoProcesadas.size() +")");
          while (itCons.hasNext()) {
              UtilidadesLog.debug("   .. Elemento");
              oidSolicitudCabecera = (Long)itCons.next();
              oidListaPicadoCabecera = (Long)listasPicadoProcesadas.get(oidSolicitudCabecera);
              
              // Recupero el codigo de la lista y la fecha/hora inicio embalaje
              // Luego actualizo la fecha/hora en la lista de picado (solo si fecha/hora inicio embalaje era null)
              RecordSet codFecha = daoPTL.getCodFechaInicioEmbalajeLista(oidListaPicadoCabecera);
              Long codLista = null;
              if (codFecha != null && ! codFecha.esVacio()) {
                  codLista = new Long(((BigDecimal)codFecha.getValueAt(0,"COD_LIST_PICA")).longValue());
                  Object fecha = codFecha.getValueAt(0,"FEC_HORA_INIC_EMBA");
                  if (fecha == null) {
                      daoPTL.actualizarFechaInicioEmbalajeLista(oidListaPicadoCabecera);
                  }
              }
              
              MONSeguimientoPedidosLocal monSeguimiento = null;
              try {
                  monSeguimiento = this.getMONSeguimientoPedidosLocalHome().create();
              } catch (CreateException e) {
                  String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                  throw new MareException(e, UtilidadesError.armarCodigoError(error));
              }
              
              // Actualizo el seguimiento del pedido
              DTOSeguimientoPedidos dtoX = new DTOSeguimientoPedidos();
              dtoX.setConsolidado(oidSolicitudCabecera);
              dtoX.setSolicitud(oidSolicitudCabecera);
              dtoX.setHitoSeguimiento(ConstantesPED.HITO_10);
              dtoX.setNumeroDocumento(codLista.toString());
              dtoX.setFecha(new Date(System.currentTimeMillis()));
              dtoX.setIndCompleto(Boolean.TRUE);
              
              monSeguimiento.actualizarSeguimientoPedidos(dtoX);
          }
          // AGREGADO - eiraola 03/09/2007 - BELC400000690 [FIN]

          /* Agregado BELC400000524 - dmorello 22/06/2007 */
          
          // ELIMINADO - eiraola 03/09/2007 - BELC400000690 [INICIO]
          //---------------------------------------------------------------------------------------
          /*
          // Recupero el codigo de la lista y la fecha/hora inicio embalaje
          // Esta query recupera siempre un registro
          // Luego actualizo la fecha/hora en la lista de picado
          RecordSet codFecha = daoPTL.getCodFechaInicioEmbalajeLista(oidListaPicadoCabecera);
          Long codLista = null;
          if (codFecha != null && ! codFecha.esVacio()) {
              codLista = new Long(((BigDecimal)codFecha.getValueAt(0,"COD_LIST_PICA")).longValue());
              Object fecha = codFecha.getValueAt(0,"FEC_HORA_INIC_EMBA");
              if (fecha == null) {
                  daoPTL.actualizarFechaInicioEmbalajeLista(oidListaPicadoCabecera);
              }
          }
          
          MONSeguimientoPedidosLocal monSeguimiento = null;
          try {
              monSeguimiento = this.getMONSeguimientoPedidosLocalHome().create();
          } catch (CreateException e) {
              String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
              throw new MareException(e, UtilidadesError.armarCodigoError(error));
          }
          
          // Actualizo el seguimiento del pedido
          DTOSeguimientoPedidos dtoX = new DTOSeguimientoPedidos();
          dtoX.setConsolidado(oidSolicitudCabecera);
          dtoX.setSolicitud(oidSolicitudCabecera);
          dtoX.setHitoSeguimiento(ConstantesPED.HITO_10);
          dtoX.setNumeroDocumento(codLista.toString());
          dtoX.setFecha(new Date(System.currentTimeMillis()));
          dtoX.setIndCompleto(Boolean.TRUE);
          
          monSeguimiento.actualizarSeguimientoPedidos(dtoX);
          */
          // ELIMINADO - eiraola 03/09/2007 - BELC400000690 [FIN]
          //---------------------------------------------------------------------------------------
          
          

          // Imprimo todas las etiquetas
          Iterator it = impresorasDatos.keySet().iterator();
          while (it.hasNext()) {
              // Obtengo los bytes a imprimir y armo el DTODocumento
              Long key = (Long)it.next();
              ByteArrayOutputStream stream = (ByteArrayOutputStream)impresorasDatos.get(key);
              DTODocumento dtoDocu = new DTODocumento();
              dtoDocu.setDocumentoByte(stream.toByteArray()); // Bytes a imprimir
              dtoDocu.setTipoDocumento(key); // OID impresora
              
              // Imprimo las etiquetas
              Long idSpool = spoolManager.openSpoolEtiquetas(ConstantesAPE.SUBACCESO_DEFECTO, key);
              spoolManager.addPrintableDocuments(dtoDocu, idSpool);
              spoolManager.closeSpoolEtiquetas(idSpool);
          }
          
          // Si se imprimieron todas OK, las marco como impresas
          daoPTL.marcarEtiquetasComoImpresas(etiquetasImpresas);

          /* Fin agregado BELC400000524 dmorello 22/06/2007 */
      }

      UtilidadesLog.info("MONImpresionPTLBean.imprimirEtiquetasPTL(ArrayList arrayDTO): Salida");
  }

  /**
   * Arma un DTODatosImpresionEtiquetas con los datos recuperados de BD
   * para imprimir la etiqueta.
   * 
   * 
   * CHANGELOG
   * ---------
   * dmorello,  23/04/2007 - BELC400000391: El tipo de caja podra ser nulo
   * ssaavedra, 29/05/2007 - BELC400000473: dejar de existir el campo ind_cheq, ahora es: inre_oid_indi_revi
   * dmorello,  07/06/2007 - Se considera posibilidad de ind. revisión == null
   * dmorello,  04/09/2007 - BELC400000635: Cambio parametros recibidos: DTOEtiqueta, RecordSet con info de clientes
   *                                       Cambia el origen de los datos a setear en el DTO de salida
   * dmorello,  15/11/2007 - Cambio APE-04: Se setean en DTO: secuencia caja PTL, texto primer pedido 
   * dmorello,  24/06/2008 - Cambio APE-10: Se setea el barrio en el DTO de salida
   * dmorello,  03/09/2009 - Cambio 20090839: Seteo el nuevo flag indImprimirDatosBasicosCliente del DTO a devolver
   * dmorello,  19/10/2009 - Cambio 20090839: Seteo los campos descripcionLineaArmado y fechaFacturacion del DTO a devolver
   */
    private DTODatosImpresionEtiquetas armarDTODatosImpresionEtiquetas(DTOEtiqueta dtoEtiqueta, RecordSet rsClientes) {
                                                                     
      DTODatosImpresionEtiquetas dto = new DTODatosImpresionEtiquetas();
      
      dto.setFecha(new Date(System.currentTimeMillis()));
      dto.setNumConsolidado(dtoEtiqueta.getNumeroConsolidado());
      dto.setNumCaja(dtoEtiqueta.getNumeroCaja());
      dto.setNumeroTotalCajas(dtoEtiqueta.getNumeroTotalCajas());
      dto.setLongitudNumeroEtiqueta(dtoEtiqueta.getLongitudNumeroEtiqueta());
      dto.setCampania(dtoEtiqueta.getCampania());
      dto.setCargo(dtoEtiqueta.getCargo());
      dto.setCodigoSeccion(dtoEtiqueta.getCodigoSeccion());
      dto.setCompania(dtoEtiqueta.getCompania());
      
      dto.setIndChequeo(dtoEtiqueta.getIndicadorChequeo());
      
      dto.setRegion(dtoEtiqueta.getCodigoRegion());
      dto.setZona(dtoEtiqueta.getCodigoZona());
      
      dto.setSecuenciaCajaPTL(dtoEtiqueta.getSecuencial());
      dto.setTextoPrimerPedido(dtoEtiqueta.getTextoPrimerPedido());
      
      dto.setTalla(dtoEtiqueta.getTalla());
      
      dto.setTextoVariable(dtoEtiqueta.getTextoVariable());
      
      // Este RecordSet trae un solo registro. Voy directo a la fila cero.
      // Obtengo del RecordSet los datos del cliente
      Object nombre1 = rsClientes.getValueAt(0, "VAL_NOM1");
      Object nombre2 = rsClientes.getValueAt(0, "VAL_NOM2");
      Object apellido1 = rsClientes.getValueAt(0, "VAL_APE1");
      Object apellido2 = rsClientes.getValueAt(0, "VAL_APE2");
      Object nombreVia = rsClientes.getValueAt(0, "VAL_NOMB_VIA");
      Object numPrincipal = rsClientes.getValueAt(0, "NUM_PPAL");
      Object codPostal = rsClientes.getValueAt(0, "VAL_COD_POST");
      Object telefono = rsClientes.getValueAt(0, "TELEFONO");
      Object barrio = rsClientes.getValueAt(0, "VAL_BARR");

      // Los asigno al DTO
      dto.setNombre1((nombre1 != null)? nombre1.toString() : null);
      dto.setNombre2((nombre2 != null)? nombre2.toString() : null);
      dto.setApellido1((apellido1 != null)? apellido1.toString() : null);
      dto.setApellido2((apellido2 != null)? apellido2.toString() : null);
      dto.setNombreVia((nombreVia != null)? nombreVia.toString() : null);
      dto.setNumeroPrincipal((numPrincipal != null)? numPrincipal.toString() : null);
      dto.setCodPostal((codPostal != null)? codPostal.toString() : null);
      dto.setTelefono((telefono != null)? telefono.toString() : null);
      dto.setBarrio((barrio != null)? barrio.toString() : null);
      
      // dmorello, 14/02/2007: Aun no se sabe como recuperar estos campos
      dto.setCiudad("");
      dto.setDepartamento("");
      
      // Cambio 20090839
      dto.setIndImprimirDatosBasicosCliente(dtoEtiqueta.getIndImprimirDatosBasicosCliente());
      dto.setFechaFacturacion(dtoEtiqueta.getFechaFacturacion());
      dto.setDescripcionLineaArmado(dtoEtiqueta.getDescripcionLineaArmado());
      
      return dto;
  }
  
  /**
   * Notas:
   *     - Cambio APE-04 - dmorello, 10/01/2008 - Se modifica la firma del método:
   *       Elimino oidPais,codImpresora - Agrego DTOEtiquetaInduccionPTL dtoe
   *     - Cambio 20090839 - dmorello, 03/09/2009 - Seteo nuevo campo DTOEtiqueta.indImprimirDatosBasicosCliente
   *     - Cambio 20090839 - dmorello, 19/10/2009 - Seteo campo DTOEtiqueta.fechaFacturacion y descripcionLineaArmado
   */
  private DTOEtiqueta armarDTOEtiqueta(RecordSet rs, HashMap hashTextoVariable, DTOEtiquetaInduccionPTL dtoe) {
      DTOEtiqueta dto = new DTOEtiqueta();
     
      dto.setOidPais(dtoe.getOidPais());
      dto.setNumeroCaja(dtoe.getNroCaja());
      dto.setNumeroTotalCajas(dtoe.getNroTotalCajas());
      dto.setCodigoImpresora(dtoe.getCodImpresora());
      dto.setCentroDistribucion(new Long(((BigDecimal)rs.getValueAt(0, "OID_CONF_CENT_DIST")).longValue()));
      dto.setListaPicado(new Long(((BigDecimal)rs.getValueAt(0, "OID_LIST_PICA_CABE")).longValue()));
      dto.setSolicitudCabecera(new Long(((BigDecimal)rs.getValueAt(0, "OID_SOLI_CABE")).longValue()));
      dto.setLongitudNumeroEtiqueta(new Integer(((BigDecimal)rs.getValueAt(0, "NUM_LONG_NUME_ETIQ")).intValue()));
      dto.setNumeroConsolidado(new Long(((BigDecimal)rs.getValueAt(0, "VAL_NUME_SOLI")).longValue()));
      dto.setSecuencial(dtoe.getNumeroCajaPTLActual());
      dto.setTipoCajaEmbalaje(new Long(((BigDecimal)rs.getValueAt(0, "TCEM_OID_TIPO_CAJA_EMBA")).longValue()));
      dto.setTextoChequeo((String)rs.getValueAt(0, "VAL_TEXT_CHEQ"));
      dto.setTextoPrimerPedido((String)rs.getValueAt(0, "VAL_TEXT_PRIM_PEDI"));
      dto.setTextoVariable((String)hashTextoVariable.get(new Long(((BigDecimal)rs.getValueAt(0, "OID_CLIE")).longValue())));
      dto.setSeccion(new Long(((BigDecimal)rs.getValueAt(0, "OID_SECC")).longValue()));
      dto.setZona(new Long(((BigDecimal)rs.getValueAt(0, "OID_ZONA")).longValue()));
      dto.setEstadoPedido(ConstantesAPE.OID_ESTADO_PEDIDO_INDUCIDO);
      dto.setCampania(rs.getValueAt(0, "COD_PERI").toString());
      dto.setCargo((String)rs.getValueAt(0, "COD_SUBT_CLIE"));
      dto.setCodigoSeccion((String)rs.getValueAt(0, "COD_SECC"));
      dto.setCompania((String)rs.getValueAt(0, "VAL_DENO"));
      dto.setFormatoEtiqueta((String)rs.getValueAt(0, "NOMBR_PROGR"));
      dto.setOidCliente(new Long(((BigDecimal)rs.getValueAt(0, "OID_CLIE")).longValue()));
      dto.setOidSublineaArmado(new Long(((BigDecimal)rs.getValueAt(0, "OID_SUBL_ARMA")).longValue()));
      
      BigDecimal numEtiq = (BigDecimal)rs.getValueAt(0, "NUM_ETIQ");
      if (numEtiq != null) {
          dto.setNumeroEtiquetasCaja(new Integer(numEtiq.intValue()));
      }

      BigDecimal indChequeo = (BigDecimal)rs.getValueAt(0, "INRE_OID_INDI_REVI");
      if (indChequeo != null) {
          dto.setIndicadorChequeo(new Long(indChequeo.longValue()));
      }

      dto.setCodigoRegion((String)rs.getValueAt(0, "COD_REGI"));
      dto.setTalla((String)rs.getValueAt(0, "VAL_TIPO_CAJA"));
      dto.setCodigoZona((String)rs.getValueAt(0, "COD_ZONA"));
      
      // Cambio 20090839
      dto.setIndImprimirDatosBasicosCliente(UtilidadesBD.convertirABoolean(rs.getValueAt(0, "IND_IMPR_DATO_BASI_CLIE")));
      dto.setFechaFacturacion((Date)rs.getValueAt(0, "FEC_FACTU"));
      dto.setDescripcionLineaArmado(UtilidadesBD.convertirAString(rs.getValueAt(0, "DESC_LINEA")));
      
      return dto;
  }
  
  private String getMensajeErrorFormatoNoDefinido(Long numConsolidado, Long numCaja) throws MareException {
      StringBuffer error = new StringBuffer();
      error.append("La etiqueta para el consolidado ").append(numConsolidado);
      error.append(" con numero de caja ").append(numCaja);
      error.append(" no se puede imprimir por no haber formato definido para la Sublinea.");
      error.append(" Fecha y hora del sistema: ").append(new Date(System.currentTimeMillis()));
      return error.toString();
  }
  
  private MONSeguimientoPedidosLocalHome getMONSeguimientoPedidosLocalHome() throws MareException {
      UtilidadesLog.info("MONImpresionPTLBean.getMONSeguimientoPedidosLocalHome(): Entrada");
      MONSeguimientoPedidosLocalHome home = (MONSeguimientoPedidosLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/MONSeguimientoPedidos");
      UtilidadesLog.info("MONImpresionPTLBean.getMONSeguimientoPedidosLocalHome(): Salida");
      return home;
  }

	 private SpoolManagerLocalHome getSpoolManagerLocalHome() throws MareException {
      UtilidadesLog.info("MONImpresionEtiquetasManualBean.getSpoolManagerLocalHome(): Entrada");
      SpoolManagerLocalHome home = (SpoolManagerLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/SpoolManager");
      UtilidadesLog.info("MONImpresionEtiquetasManualBean.getSpoolManagerLocalHome(): Salida");
      return home;
  }
}