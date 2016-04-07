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
 *
 */


package es.indra.sicc.logicanegocio.ape;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.print.SpoolManagerLocal;
import es.indra.sicc.cmn.negocio.print.SpoolManagerLocalHome;
import es.indra.sicc.dtos.ape.DTOBusquedaEtiqueta;
import es.indra.sicc.dtos.ape.DTODatosImpresionEtiquetas;
import es.indra.sicc.dtos.ape.DTOImpresionEtiquetas;
import es.indra.sicc.dtos.ape.DTOImpresionEtiquetasManual;
import es.indra.sicc.dtos.ped.DTOSeguimientoPedidos;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTODocumento;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.ped.MONSeguimientoPedidosLocal;
import es.indra.sicc.logicanegocio.ped.MONSeguimientoPedidosLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.ExcepcionParametrizada;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;


public class MONImpresionEtiquetasManualBean implements SessionBean 
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

  /**
   * @author dmorello
   * @since 22-01-2007
   */
  public DTOSalida buscarEtiquetasImprimir(DTOBusquedaEtiqueta dtoe) throws MareException  {
      UtilidadesLog.info("MONImpresionEtiquetasManualBean.buscarEtiquetasImprimir(DTOBusquedaEtiqueta dtoe): Entrada");
      DTOSalida dtoSalida = new DAOImpresionEtiquetasManual().buscarEtiquetasImprimir(dtoe);
      UtilidadesLog.info("MONImpresionEtiquetasManualBean.buscarEtiquetasImprimir(DTOBusquedaEtiqueta dtoe): Salida");
      return dtoSalida;
  }

  /**
   * @author dmorello
   * @since 22-01-2007
   */
  public void imprimirEtiquetasSeleccionadas(DTOImpresionEtiquetas dtoe) throws MareException {
      UtilidadesLog.info("MONImpresionEtiquetasManualBean.imprimirEtiquetasSeleccionadas(DTOImpresionEtiquetas dtoe): Entrada");
      
      SpoolManagerLocal spoolManager = null;
      try {
          spoolManager = this.getSpoolManagerLocalHome().create();
      } catch (CreateException e) {
          String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }
      
      DTOOIDs dtoOids = new DTOOIDs();
      Long[] oids = dtoe.getOids();
      dtoOids.setOids(oids);
      DAOImpresionEtiquetasManual dao = new DAOImpresionEtiquetasManual();
      RecordSet formatos = dao.recuperarFormatosEtiquetas(dtoOids);
      
      // Recorremos el array de etiquetas recibido para ver si tiene un formato asociado, caso contrario se loguea el error 
      /* BELC400000524 - dmorello, 21/06/2007 */
      HashMap impresorasDatos = new HashMap();
      int rowCount = formatos.getRowCount();
      for (int j = 0; j < rowCount; j++) {
          Object formato = formatos.getValueAt(j, "NOMBR_PROGR");
          if (formato == null) {
              UtilidadesLog.error("No hay formato para la etiqueta de OID " + formatos.getValueAt(j, "OID_ETIQ"));
              
              // Logueo el error
              Object numEtiqueta = formatos.getValueAt(j, "NUMEROETIQUETA");
              Object numConsolidado = formatos.getValueAt(j, "VAL_NUME_SOLI");
              UtilidadesLog.debug("numEtiqueta: " + numEtiqueta);
              UtilidadesLog.debug("numConsolidado: " + numConsolidado);
              StringBuffer error = new StringBuffer();
              error.append("La etiqueta ").append(numEtiqueta);
              error.append(" para el consolidado ").append(numConsolidado);
              error.append(" no se puede imprimir por no haber formato definido para la Sublinea.");
              error.append(" Fecha y hora del sistema: ").append(new Date());
              LogAPP.error(error.toString());
              UtilidadesLog.error(error.toString());
              
              // La etiqueta <numero> no se puede imprimir por no haber formato definido.
              ExcepcionParametrizada exPar;
              int numeroError = UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE, ErroresDeNegocio.APE_0937);
              exPar = new ExcepcionParametrizada("", numeroError);
              exPar.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
              exPar.addParameter(numEtiqueta.toString());
              UtilidadesLog.info("MONImpresionEtiquetasManualBean.imprimirEtiquetasSeleccionadas(...): Salida (Formato)");
              throw exPar;
          }
      }
      
      // Recupero los textos variables para los clientes que poseen etiquetas
      // Tambien recupero los datos de los clientes
      UtilidadesLog.debug("--- Paso a armar el DTOOIDs de clientes");
      int rows = formatos.getRowCount();
      TreeSet set = new TreeSet();
      for (int i = 0; i < rows; i++) {
          set.add(formatos.getValueAt(i, "OID_CLIE"));
      }
      Object[] objOids = set.toArray();
      Long[] oidsClientes = new Long[objOids.length];
      for (int i = 0; i < objOids.length; i++) {
          oidsClientes[i] = new Long(((BigDecimal)objOids[i]).longValue());
      }
      DTOOIDs dtoOidsClientes = new DTOOIDs();
      dtoOidsClientes.setOids(oidsClientes);
      dtoOidsClientes.setOidPais(dtoe.getOidPais());
      HashMap hash = dao.recuperarTextosVariables(dtoOidsClientes);
      RecordSet rsClientes = dao.obtenerDatosClientes(dtoOidsClientes); // Viene ordenado por OID de cliente
      
      /* BELC400000524 - dmorello, 21/06/2007 */
      ArrayList etiquetasImpresas = new ArrayList();

      // En este ciclo se imprimen las etiquetas que tienen asociado un formato
      for (int i = 0; i < rows; i++) {
          Object formato = formatos.getValueAt(i, "NOMBR_PROGR");
          UtilidadesLog.debug("Formato para la posicion " + i + ':' + formato);
          
          // Procedo a imprimir solo las etiquetas que tienen un formato asociado
          if (formato != null) {
          
              // Armo el DTO con los datos a imprimir en la etiqueta
              DTODatosImpresionEtiquetas dto = this.armarDTODatosImpresionEtiquetas(formatos,rsClientes,i,hash);
              
              // Instancio la clase correspondiente al formato de etiqueta en cuestion
              AbstractEtiqueta etiqueta = null;
              try {
                  etiqueta = (AbstractEtiqueta)Class.forName("es.indra.sicc.logicanegocio.ape." + formato).newInstance();
              } catch (Throwable e) {
                  UtilidadesLog.error("Error al buscar o instanciar la clase correspondiente al formato " + formato);
                  LogAPP.error("Error al buscar o instanciar la clase correspondiente al formato " + formato);
                  continue;
              }
              
              // Imprimo tantas veces como indica el numero de etiquetas en el tipo de caja
              // Si no se especifica en el tipo de caja, imprimo una sola vez
              Object numEtiqFormatos = formatos.getValueAt(i, "NUM_ETIQ");
              int numEtiquetas = (numEtiqFormatos != null)? ((BigDecimal)numEtiqFormatos).intValue() : 1;
              UtilidadesLog.debug("numEtiquetas = " + numEtiquetas);
              
              Long sublinea = new Long(((BigDecimal)formatos.getValueAt(i, "OID_SUBL_ARMA")).longValue());
              Long subacceso = ConstantesAPE.SUBACCESO_DEFECTO;
              //Long idSpool = spoolManager.openSpoolEtiquetas(subacceso, sublinea);
              
              byte[] bytesEtiqueta = etiqueta.componerEtiqueta(dto);
              
              // Obtengo la impresora donde enviar las etiquetas
              Long oidImpresora = new DAOEtiquetado().recuperarImpresoraEtiquetado(subacceso, sublinea, null);
              if (oidImpresora == null) {
                  throw new MareException("No existe impresora asociada al subacceso y la sublinea");
              }
              
              /* BELC400000524 - dmorello, 21/06/2007 */
              ByteArrayOutputStream stream;
              if (! impresorasDatos.containsKey(oidImpresora)) {
                  stream = new ByteArrayOutputStream();
                  impresorasDatos.put(oidImpresora, stream);
              } else {
                  stream = (ByteArrayOutputStream)impresorasDatos.get(oidImpresora);
              }
              
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
              etiquetasImpresas.add(formatos.getValueAt(i, "OID_ETIQ")); // es un BigDecimal
              
              //spoolManager.closeSpoolEtiquetas(idSpool);
              
              // Actualizo estado de etiqueta
              //StringBuffer update = new StringBuffer();
              //update.append(" UPDATE APE_ETIQU SET IND_ESTA = '");
              //update.append(dtoe.getImpresa().booleanValue()? ConstantesAPE.ESTADO_REIMPRESA : ConstantesAPE.ESTADO_IMPRESA);
              //update.append("', IND_IMPR = '").append(ConstantesAPE.IMPRESION_SI);
              //update.append("' WHERE OID_ETIQ = ").append(formatos.getValueAt(i, "OID_ETIQ"));
              
              //try {
              //    UtilidadesEJB.getBelcorpService().dbService.executeUpdate(update.toString());
              //} catch (Exception e) {
              //    String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
              //    throw new MareException(e, UtilidadesError.armarCodigoError(error));
              //}
              /* Fin BELC400000524 dmorello 21/06/2007 */
          }
      }
      
      /* Agregado BELC400000524 - dmorello 21/06/2007 */
      
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
      // Cuando NO sea reimpresion, actualizo también estatus del pedido
      dao.actualizarEtiquetas(etiquetasImpresas, dtoe.getImpresa().booleanValue());
      
      /* Fin agregado BELC400000524 dmorello 21/06/2007 */
      
      UtilidadesLog.info("MONImpresionEtiquetasManualBean.imprimirEtiquetasSeleccionadas(DTOImpresionEtiquetas dtoe): Salida");
  }
  
  
  /**
   * CHANGELOG
   * ---------
   * dmorello,  20/03/2007 - BELC400000224: En el DTO seteo nro secuencia = numero etiqueta
   * dmorello,  23/04/2007 - BELC400000391: El tipo de caja podra ser nulo
   * ssaavedra, 29/05/2007 - BELC400000473: dejar de existir el campo ind_cheq, ahora es: inre_oid_indi_revi
   * dmorello,  07/06/2007 - El indicador de revision puede ser null
   * dmorello,  19/11/2007 - Cambio APE-04: Se setean en DTO: secuencia caja PTL, texto primer pedido 
   * dmorello,  24/06/2008 - Cambio APE-10: Se setea el barrio en el DTO de salida
   * dmorello,  08/01/2009 - Elimino obtención del dato rsFormatos.COD_TERR porque ya no existe
   * dmorello,  03/09/2009 - Seteo en el DTO a devolver el nuevo flag indImprimirDatosBasicosCliente
   * dmorello,  08/10/2009 - Seteo en el DTO a devolver los campos descripcionLineaArmado y fechaFacturacion
   */
  private DTODatosImpresionEtiquetas armarDTODatosImpresionEtiquetas(RecordSet rsFormatos,
                                                                     RecordSet rsClientes,
                                                                     int filaRsFormatos,
                                                                     HashMap hashTextoVar) {
                                                                     
      UtilidadesLog.info("MONImpresionEtiquetasManualBean.armarDTODatosImpresionEtiquetas(RecordSet rsFormatos,RecordSet rsClientes,"
                          + "int filaRsFormatos,HashMap hashTextoVar): Entrada");
      
      DTODatosImpresionEtiquetas dto = new DTODatosImpresionEtiquetas();
      
      dto.setNumConsolidado(new Long(((BigDecimal)rsFormatos.getValueAt(filaRsFormatos, "VAL_NUME_SOLI")).longValue()));
      dto.setNumCaja(new Long(((BigDecimal)rsFormatos.getValueAt(filaRsFormatos, "NUM_CAJA")).longValue()));
      dto.setNumeroTotalCajas(new Long(((BigDecimal)rsFormatos.getValueAt(filaRsFormatos, "NUM_TOTA_CAJA")).longValue()));
      dto.setLongitudNumeroEtiqueta(new Integer(((BigDecimal)rsFormatos.getValueAt(filaRsFormatos, "NUM_LONG_NUME_ETIQ")).intValue()));
      dto.setCampania(rsFormatos.getValueAt(filaRsFormatos, "COD_PERI").toString());
      dto.setCargo(rsFormatos.getValueAt(filaRsFormatos, "COD_SUBT_CLIE").toString());
      dto.setCodigoSeccion(rsFormatos.getValueAt(filaRsFormatos, "COD_SECC").toString());
      dto.setCompania(rsFormatos.getValueAt(filaRsFormatos, "VAL_DENO").toString());
      dto.setFecha(new Date(System.currentTimeMillis()));
      dto.setIndImprimirDatosBasicosCliente(UtilidadesBD.convertirABoolean(rsFormatos.getValueAt(filaRsFormatos, "IND_IMPR_DATO_BASI_CLIE")));
      
      dto.setNroSecuencia(new Long(((BigDecimal)rsFormatos.getValueAt(filaRsFormatos, "NUMEROETIQUETA")).longValue()));
      
      // Cambio 20090839
      dto.setDescripcionLineaArmado(UtilidadesBD.convertirAString(rsFormatos.getValueAt(filaRsFormatos, "DESC_LINEA")));
      dto.setFechaFacturacion((java.util.Date)rsFormatos.getValueAt(filaRsFormatos, "FEC_FACT"));
      
      UtilidadesLog.debug("1");
      
      Object objIndRevi = rsFormatos.getValueAt(filaRsFormatos, "INRE_OID_INDI_REVI");
      if (objIndRevi != null) {
          dto.setIndChequeo(new Long(((BigDecimal)objIndRevi).longValue()));
      }
      
      dto.setRegion(rsFormatos.getValueAt(filaRsFormatos, "COD_REGI").toString());
      dto.setZona(rsFormatos.getValueAt(filaRsFormatos, "COD_ZONA").toString());
      
      UtilidadesLog.debug("2");

      dto.setSecuenciaCajaPTL( new Long( ((BigDecimal)rsFormatos.getValueAt(filaRsFormatos, "NUM_SECU")).longValue() ) );
      dto.setTextoPrimerPedido((String)rsFormatos.getValueAt(filaRsFormatos, "VAL_TEXT_PRIM_PEDI"));
      
      Object talla = rsFormatos.getValueAt(filaRsFormatos, "VAL_TIPO_CAJA").toString();
      if (talla != null) {
          dto.setTalla(talla.toString());
      } else {
          dto.setTalla(null);
      }
      
      Long oidCliente = new Long(((BigDecimal)rsFormatos.getValueAt(filaRsFormatos, "OID_CLIE")).longValue());
      Object textoVariable = hashTextoVar.get(oidCliente);
      if (textoVariable != null) {
          dto.setTextoVariable(textoVariable.toString());
      }
      
      UtilidadesLog.debug("3");

      int rowsClientes = rsClientes.getRowCount();
      for (int j = 0; j < rowsClientes; j++) {
          BigDecimal oidClieDatos = (BigDecimal)rsClientes.getValueAt(j, "OID_CLIE");
          if (oidCliente.longValue() == oidClieDatos.longValue()) {
              UtilidadesLog.debug("Obtengo del RecordSet los datos del cliente");
              
              Object nombre1 = rsClientes.getValueAt(j, "VAL_NOM1");
              Object nombre2 = rsClientes.getValueAt(j, "VAL_NOM2");
              Object apellido1 = rsClientes.getValueAt(j, "VAL_APE1");
              Object apellido2 = rsClientes.getValueAt(j, "VAL_APE2");
              Object nombreVia = rsClientes.getValueAt(j, "VAL_NOMB_VIA");
              Object numPrincipal = rsClientes.getValueAt(j, "NUM_PPAL");
              Object codPostal = rsClientes.getValueAt(j, "VAL_COD_POST");
              Object telefono = rsClientes.getValueAt(j, "TELEFONO");
              Object barrio = rsClientes.getValueAt(j, "VAL_BARR");
        
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
              
              // Salgo del FOR
              j = rowsClientes;
          }
      }
      
      UtilidadesLog.info("MONImpresionEtiquetasManualBean.armarDTODatosImpresionEtiquetas(RecordSet rsFormatos,RecordSet rsClientes,"
                          + "int filaRsFormatos,HashMap hashTextoVar): Salida");
      return dto;
  }

	 private SpoolManagerLocalHome getSpoolManagerLocalHome() throws MareException {
      UtilidadesLog.info("MONImpresionEtiquetasManualBean.getSpoolManagerLocalHome(): Entrada");
      SpoolManagerLocalHome home = (SpoolManagerLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/SpoolManager");
      UtilidadesLog.info("MONImpresionEtiquetasManualBean.getSpoolManagerLocalHome(): Salida");
      return home;
  }

    /**
     * CAMBIO APE-09
     * Imprime las etiquetas correspondientes al consolidado/caja recibidos
     * por parámetro. Devuelve un DTO donde indica si se encontraron e imprimieron
     * etiquetas o no.
     * 
     * @author dmorello
     * @since 21-may-2008
     */
    public void imprimirEtiquetasConsolidadoCaja(DTOImpresionEtiquetasManual dtoe) throws MareException {
        UtilidadesLog.info("MONImpresionEtiquetasManualBean.imprimirEtiquetasConsolidadoCaja(DTOImpresionEtiquetasManual dtoe): Entrada");
        
        DAOImpresionEtiquetasManual dao = new DAOImpresionEtiquetasManual();
        RecordSet etiquetas = dao.obtenerInfoEtiquetas(dtoe);
        
        // Si no se recuperaron etiquetas, salgo...
        if (etiquetas.esVacio()) {
            UtilidadesLog.info("MONImpresionEtiquetasManualBean.imprimirEtiquetasConsolidadoCaja"
                              + "(DTOImpresionEtiquetasManual dtoe): Salida sin imprimir");
                              
            ExcepcionParametrizada exPar;
            int numeroError = UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE, ErroresDeNegocio.APE_0056);
            exPar = new ExcepcionParametrizada("", numeroError);
            exPar.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
            exPar.addParameter(dtoe.getNumConsolidado().toString());
                             
            throw exPar;
        }
        
        // Imprimo las etiquetas y las actualizo en BD
        Long[] oids = new Long[etiquetas.getRowCount()];
        for (int i = 0; i < oids.length; i++) {
            oids[i] = new Long(((BigDecimal)etiquetas.getValueAt(i, "OID_ETIQ")).longValue());
        }
        DTOImpresionEtiquetas dtoImp = new DTOImpresionEtiquetas();
        dtoImp.setOidPais(dtoe.getOidPais());
        dtoImp.setOids(oids);
        dtoImp.setImpresa(Boolean.FALSE);
        this.imprimirEtiquetasSeleccionadas(dtoImp);
        
        // Actualizo la fecha inicio embalaje en la lista de picado
        Long oidListaPicado = new Long(((BigDecimal)etiquetas.getValueAt(0, "OID_LIST_PICA_CABE")).longValue());
        new DAOImpresionPTL().actualizarFechaInicioEmbalajeLista(oidListaPicado);
        
        // Llamo al CU Actualizar seguimiento pedidos
        try {
            MONSeguimientoPedidosLocal mon = this.getMONSeguimientoPedidosLocalHome().create();
        
            String codLista = etiquetas.getValueAt(0, "COD_LIST_PICA").toString();
            Long oidConsolidado = new Long(((BigDecimal)etiquetas.getValueAt(0, "OID_SOLI_CABE")).longValue());
            DTOSeguimientoPedidos dtoSeg = new DTOSeguimientoPedidos();
            dtoSeg.setOidPais(dtoe.getOidPais());
            dtoSeg.setSolicitud(oidConsolidado);
            dtoSeg.setConsolidado(oidConsolidado);
            dtoSeg.setHitoSeguimiento(ConstantesPED.HITO_10);
            dtoSeg.setTipoDocumento(ConstantesPED.TIPO_DOCUMENTO_LISTA_PICADO);
            dtoSeg.setNumeroDocumento(codLista);
            dtoSeg.setFecha(new Date(System.currentTimeMillis()));
            dtoSeg.setIndCompleto(Boolean.TRUE);
            
            mon.actualizarSeguimientoPedidos(dtoSeg);
        } catch (CreateException e) {
            String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("MONImpresionEtiquetasManualBean.imprimirEtiquetasConsolidadoCaja(DTOImpresionEtiquetasManual dtoe): Salida");
    }

    private MONSeguimientoPedidosLocalHome getMONSeguimientoPedidosLocalHome() throws MareException {
        UtilidadesLog.info("MONImpresionEtiquetasManualBean.getMONSeguimientoPedidosLocalHome(): Entrada");
        Object home = UtilidadesEJB.getLocalHome("java:comp/env/MONSeguimientoPedidos");
        UtilidadesLog.info("MONImpresionEtiquetasManualBean.getMONSeguimientoPedidosLocalHome(): Salida");
        return (MONSeguimientoPedidosLocalHome)home;
    }
    
}