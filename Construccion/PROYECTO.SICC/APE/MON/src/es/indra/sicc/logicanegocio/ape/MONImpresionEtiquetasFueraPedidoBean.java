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
import es.indra.sicc.dtos.ape.DTOImpresionFP;
import es.indra.sicc.dtos.ape.DTODatosImpresionEtiquetas;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTODocumento;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.LogAPP;
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

public class MONImpresionEtiquetasFueraPedidoBean implements SessionBean {

    public void ejbCreate()    {
    }
  
    public void ejbActivate()    {
    }
  
    public void ejbPassivate()    {
    }
  
    public void ejbRemove()    {
    }
  
    public void setSessionContext(SessionContext ctx)    {
    }
  
    public DTOSalida buscarEtiquetasFP(DTOImpresionFP dtoe) throws MareException {
        UtilidadesLog.info("MONImpresionEtiquetasFueraPedidoBean.buscarEtiquetasFP(DTOImpresionFP dtoe): Entrada");
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(new DAOImpresionEtiquetasFueraPedido().buscarEtiquetasFP(dtoe));
        UtilidadesLog.info("MONImpresionEtiquetasFueraPedidoBean.buscarEtiquetasFP(DTOImpresionFP dtoe): Entrada");
        return dtoSalida;
    }
  
	public void imprimirEtiquetasFP(DTOOIDs dtoe) throws MareException {
		UtilidadesLog.info("MONImpresionEtiquetasFueraPedidoBean.imprimirEtiquetasFP(DTOOIDs dtoe): Entrada");
    
    /*
     * BELC400000177 - dmorello, 07/03/2007
     * Ahora dtoe contiene OIDs de listas de picado. Busco los OIDs de etiquetas
     * para las mismas y armo el DTOOIDs para recuperar formatos.
     */
    DAOImpresionEtiquetasFueraPedido daoFP = new DAOImpresionEtiquetasFueraPedido();
    DTOSalida dtoEntrada = daoFP.buscarEtiquetasListaPicado(dtoe);
    RecordSet resultado = dtoEntrada.getResultado();
    if (resultado.getRowCount() != 0) {
    
        SpoolManagerLocal spoolManager = null;
        try{
            spoolManager = this.getSpoolManagerLocalHome().create();
        } catch (CreateException e) {
            String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        DTOOIDs dtoOids = new DTOOIDs();
        Long[] oids = new Long[resultado.getRowCount()];
        for (int i = 0; i < oids.length; i++) {
            oids[i] = new Long(((BigDecimal)resultado.getValueAt(i, "OID_ETIQ")).longValue());
        }
        dtoOids.setOids(oids);
        dtoOids.setOidPais(dtoe.getOidPais());
        
        DAOImpresionEtiquetasManual dao = new DAOImpresionEtiquetasManual();
        //RecordSet formatos = dao.recuperarFormatosEtiquetas(dtoe);
        //RecordSet formatos = dao.recuperarFormatosEtiquetas(dtoOids);         // Eliminado - eiraola 09/08/2007
        RecordSet formatos = daoFP.recuperarFormatosEtiquetasFP(dtoOids);       // Agregado  - eiraola 09/08/2007
        /* Fin BELC400000177 dmorello 07/03/2007 */
        
        if (! formatos.esVacio()) {
          // Recupero la info de los clientes para los cuales hay etiquetas
          DTOOIDs dtoClientes = this.armarDTOOIDsClientes(formatos, dtoe.getOidPais());
          HashMap hashTextoVariable = dao.recuperarTextosVariables(dtoClientes);
          RecordSet datosClientes = dao.obtenerDatosClientes(dtoClientes);

          /* BELC400000524 - dmorello, 21/06/2007 */
          ArrayList etiquetasImpresas = new ArrayList();
          HashMap impresorasDatos = new HashMap();
          
          // En este ciclo se imprimen las etiquetas que tienen asociado un formato
          int sizeFormatos = formatos.getRowCount();
          for (int i = 0; i < sizeFormatos; i++) {
              Object formato = formatos.getValueAt(i, "NOMBR_PROGR");
              UtilidadesLog.debug("Formato para la posicion " + i + ':' + formato);
      
              // Procedo a imprimir solo las etiquetas que tienen un formato asociado
              if (formato != null) {
        
                  // Armo el DTO con los datos a imprimir en la etiqueta
                  DTODatosImpresionEtiquetas dto = this.armarDTODatosImpresionEtiquetas(formatos,datosClientes,i,hashTextoVariable);
        
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
                  
                  byte[] bytesEtiqueta = etiqueta.componerEtiqueta(dto);
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
                  //Long oidEtiqueta = new Long(((BigDecimal)formatos.getValueAt(i, "OID_ETIQ")).longValue());
                  //daoFP.marcarEtiquetaComoImpresa(oidEtiqueta);
                  
                  /*
                   * TODO:  Llamar a "INT SAT-9 Enviar lista de palets a despachar"
                   * con el número de etiqueta correspondiente y el país
                   */
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
          daoFP.marcarEtiquetasComoImpresas(etiquetasImpresas);
          
          /* Fin agregado BELC400000524 dmorello 21/06/2007 */

          
        } else {
            UtilidadesLog.error("--- No se recupero el FORMATO!");
            throw new MareException("", UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE, 
                    ErroresDeNegocio.APE_0027));
        }
      } else {
          UtilidadesLog.error("--- No se recuperaron ETIQUETAS!");
          throw new MareException("", UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE, 
                  ErroresDeNegocio.APE_0027));
      }
      UtilidadesLog.info("MONImpresionEtiquetasFueraPedidoBean.imprimirEtiquetasFP(DTOOIDs dtoe): Salida");
	}
	
	private DTOOIDs armarDTOOIDsClientes(RecordSet formatos, Long oidPais) {
		// Agrego los OIDs del RecordSet al TreeSet para eliminar los repetidos
		TreeSet set = new TreeSet();
		int sizeFormatos = formatos.getRowCount();
        Long oidCliente;
        
		for (int i = 0; i < sizeFormatos; i++) {
            if (formatos.getValueAt(i, "OID_CLIE") != null) {
                oidCliente = new Long(((BigDecimal)formatos.getValueAt(i, "OID_CLIE")).longValue());
                set.add(oidCliente);
            }
        }
        
        if (set.size() == 0) {
            set.add(null); // Esto para que las querys siguientes funcionen (ej. oid_clie IN (null))
        }
		
		// Convierto a Long[]
        Long[] oidsClientes = (Long[]) set.toArray(new Long[set.size()]);
		
		// Armo el DTOOIDs
		DTOOIDs dtoOids = new DTOOIDs();
		dtoOids.setOids(oidsClientes);
		dtoOids.setOidPais(oidPais);
		return dtoOids;
	}
	
	
  /**
   * CHANGELOG
   * ---------
   * dmorello,  20/03/2007 - BELC400000224: Seteo en DTO numero secuencia = numero etiqueta
   * dmorello,  23/04/2007 - BELC400000391: El tipo de caja podra ser nulo
   * ssaavedra, 29/05/2007 - BELC400000473: dejar de existir el campo ind_cheq, ahora es: inre_oid_indi_revi
   * dmorello,  20/06/2007 - El indicador de revision puede ser nulo
   * eiraola,   10/08/2007 - Se utiliza para Codigo de Barras (de etiquetas AFP)
   *                         el campo de la Lista de Picado COD_LIST_PICA
   * dmorello,  19/11/2007 - Cambio APE-04: Se setean en DTO: secuencia caja PTL, texto primer pedido 
   * dmorello,  23/06/2008 - Cambio APE-10: Se setea el barrio en el DTO de salida
   * 
   */
  private DTODatosImpresionEtiquetas armarDTODatosImpresionEtiquetas(RecordSet rsFormatos,
                                                                     RecordSet rsClientes,
                                                                     int filaRsFormatos,
                                                                     HashMap hashTextoVar) {
                                                                     
      UtilidadesLog.info("MONImpresionEtiquetasFueraPedidoBean.armarDTODatosImpresionEtiquetas"
                          + "(RecordSet rsFormatos,RecordSet rsClientes,"
                          + "int filaRsFormatos,HashMap hashTextoVar): Entrada");
      
      DTODatosImpresionEtiquetas dto = new DTODatosImpresionEtiquetas();
      
      if (rsFormatos.getValueAt(filaRsFormatos, "VAL_NUME_SOLI") != null) {
        dto.setNumConsolidado(new Long(((BigDecimal)rsFormatos.getValueAt(filaRsFormatos, "VAL_NUME_SOLI")).longValue()));
      }
      dto.setNumCaja(new Long(((BigDecimal)rsFormatos.getValueAt(filaRsFormatos, "NUM_CAJA")).longValue()));
      dto.setNumeroTotalCajas(new Long(((BigDecimal)rsFormatos.getValueAt(filaRsFormatos, "NUM_TOTA_CAJA")).longValue()));
      dto.setLongitudNumeroEtiqueta(new Integer(((BigDecimal)rsFormatos.getValueAt(filaRsFormatos, "NUM_LONG_NUME_ETIQ")).intValue()));
      dto.setCampania(rsFormatos.getValueAt(filaRsFormatos, "COD_PERI").toString());
      
      if (rsFormatos.getValueAt(filaRsFormatos, "COD_SUBT_CLIE") != null) {
        dto.setCargo(rsFormatos.getValueAt(filaRsFormatos, "COD_SUBT_CLIE").toString());
      }
      if (rsFormatos.getValueAt(filaRsFormatos, "COD_SECC") != null) {
        dto.setCodigoSeccion(rsFormatos.getValueAt(filaRsFormatos, "COD_SECC").toString());
      }
      if (rsFormatos.getValueAt(filaRsFormatos, "VAL_DENO") != null) {
        dto.setCompania(rsFormatos.getValueAt(filaRsFormatos, "VAL_DENO").toString());
      }
      
      if (rsFormatos.getValueAt(filaRsFormatos, "COD_LIST_PICA") != null) {
        dto.setCodigoListaPicado(rsFormatos.getValueAt(filaRsFormatos, "COD_LIST_PICA").toString());
      }
      dto.setFecha(new Date(System.currentTimeMillis()));
      
      dto.setNroSecuencia(new Long(((BigDecimal)rsFormatos.getValueAt(filaRsFormatos, "NUMEROETIQUETA")).longValue()));
      
      Object indChequeo = rsFormatos.getValueAt(filaRsFormatos, "INRE_OID_INDI_REVI");
      if (indChequeo != null) {
          dto.setIndChequeo(new Long(((BigDecimal)indChequeo).longValue()));
      } else {
          dto.setIndChequeo(null);
      }
      
      dto.setRegion(rsFormatos.getValueAt(filaRsFormatos, "COD_REGI").toString());
      
      if (rsFormatos.getValueAt(filaRsFormatos, "COD_ZONA") != null) {
        dto.setZona(rsFormatos.getValueAt(filaRsFormatos, "COD_ZONA").toString());
      }
      
      dto.setSecuenciaCajaPTL( new Long( ((BigDecimal)rsFormatos.getValueAt(filaRsFormatos, "NUM_SECU")).longValue() ) );
      dto.setTextoPrimerPedido((String)rsFormatos.getValueAt(filaRsFormatos, "VAL_TEXT_PRIM_PEDI"));
      
      String talla = null;
      if (rsFormatos.getValueAt(filaRsFormatos, "VAL_TIPO_CAJA") != null) {
          talla = (String)rsFormatos.getValueAt(filaRsFormatos, "VAL_TIPO_CAJA"); // LG_V400000046 Puede ser null
      }
      dto.setTalla(talla);
      
      Long oidCliente = null;
      if (rsFormatos.getValueAt(filaRsFormatos, "OID_CLIE") != null) {
          oidCliente = new Long(((BigDecimal)rsFormatos.getValueAt(filaRsFormatos, "OID_CLIE")).longValue());
      }
      Object textoVariable = hashTextoVar.get(oidCliente);
      if (textoVariable != null) {
          dto.setTextoVariable(textoVariable.toString());
      }
      
      int rowsClientes = (rsClientes != null) ? rsClientes.getRowCount() : 0 ;
      
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
      
      UtilidadesLog.info("MONImpresionEtiquetasFueraPedidoBean.armarDTODatosImpresionEtiquetas"
                          + "(RecordSet rsFormatos,RecordSet rsClientes,"
                          + "int filaRsFormatos,HashMap hashTextoVar): Salida");
      return dto;
  }	
  
	 private SpoolManagerLocalHome getSpoolManagerLocalHome() throws MareException {
      UtilidadesLog.info("MONImpresionEtiquetasManualBean.getSpoolManagerLocalHome(): Entrada");
      SpoolManagerLocalHome home = (SpoolManagerLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/SpoolManager");
      UtilidadesLog.info("MONImpresionEtiquetasManualBean.getSpoolManagerLocalHome(): Salida");
      return home;
  }
  
}