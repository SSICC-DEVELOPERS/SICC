package es.indra.sicc.logicanegocio.fac.generaciondocumentos;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.msg.DTOImpresion;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Collection;
import java.util.Collections;
import java.sql.Date;
import java.math.BigDecimal;

public class FacturaColombia2 extends DocumentoFAC {
    private byte[] documento; 
    String mensaDetalles = "<txt><datoVariable01><t/><datoVariable02><t/><datoVariable03></txt>";
    int lineasXPagina = 22;
    int lineasxPaginaGrande = 38;
    int lineasxPaginaPeq = 22;
    String fechaVencimiento;

    public FacturaColombia2() {
    }
    
      public void componerFactura(DTODocLegal datosDocLegal) throws MareException {
        try {
          UtilidadesLog.info("FacturaColombia2.componerFactura(DTODocLegal datosDocLegal): Entrada");
          ArrayList listaPaginas = datosDocLegal.getlistaPaginas();
          SerializadorFacturaColombia2 sf2 = new SerializadorFacturaColombia2();          
                    
          DTOFACDocumentoContable docuContable = (DTOFACDocumentoContable)listaPaginas.get(0);
          DTOFACDocumentoContableCabecera miCabecera = docuContable.getCabecera();
          ArrayList misDetalles = docuContable.getDetalle();
          this.recuperarFechaVencimiento(miCabecera);
          int cantidadLineasAGenerar = 0;
          //boolean generarBloqueAbonosSPV = false;
          boolean generarBloqueIVA = false;
          boolean generarBloqueDescuentos = false;
          boolean generarBloqueDescuentos3 = false;
          boolean generarBloqueImporteRedondeo = false;
          
          DAODocuContable daoActivo = new DAODocuContable();
          ArrayList arrayDetallesXCatalogo = (ArrayList)this.calcularDetallesAGenerar(docuContable, miCabecera.getNumeroDecimales());  
          cantidadLineasAGenerar = arrayDetallesXCatalogo.size();
          cantidadLineasAGenerar++;     // Linea de SubTotal
          cantidadLineasAGenerar++;     // Linea de Flete          
           
          /*Float abonoSPV = (Float)daoActivo.obtenerAbonosSPV(miCabecera.getOidCliente(), miCabecera.getOidPeriodo());
          if (abonoSPV != null && abonoSPV.floatValue() != 0) {
             cantidadLineasAGenerar++;
             generarBloqueAbonosSPV = true;
          }*/
          
          ArrayList arrayProductosSinCV = (ArrayList)this.calcularCantidadProductosSinCV(misDetalles, miCabecera.getNumeroDecimales());
          cantidadLineasAGenerar = cantidadLineasAGenerar + arrayProductosSinCV.size();
          
          cantidadLineasAGenerar++;     // Linea de Total a Pagar
          
          Float baseIVAAsumido = new Float(0);
          if (miCabecera.getIvaAsumidoEmpresa() != null && miCabecera.getIvaAsumidoEmpresa().floatValue() > 0){
            baseIVAAsumido = new Float(miCabecera.getIvaAsumidoEmpresa().floatValue());
            cantidadLineasAGenerar++; 
            generarBloqueIVA = true;
          }
          cantidadLineasAGenerar++;   // Linea Datos IVA
          
          if (miCabecera.getImpDesc3TotalLocal() != null && miCabecera.getImpDesc3TotalLocal().floatValue() != 0) {
            cantidadLineasAGenerar++;
            generarBloqueDescuentos3 = true;
          }
          
          Float calculoDescuento = new Float(valorAbsoluto(miCabecera.getImpDesc1TotLocal()).floatValue() + valorAbsoluto(miCabecera.getPrecioContTotaLocal()).floatValue() + valorAbsoluto(miCabecera.getImpDesc3TotalLocal()).floatValue());
          if (calculoDescuento.floatValue() != 0) {
            cantidadLineasAGenerar++;
            generarBloqueDescuentos = true;
          }
          
          if (miCabecera.getImporteRedondeoLocal() != null && miCabecera.getImporteRedondeoLocal().floatValue() != 0) {
             cantidadLineasAGenerar++;
             generarBloqueImporteRedondeo = true;                 
          }  


          DTOImpresion miDTO= new DTOImpresion();
          String mensa = "<frmfc2>";

          Parseador miParseador = Parseador.getInstance();
          sf2.addMensaje(mensa);
          
          miDTO = new DTOImpresion();
          if (miCabecera.getIndicadorReimpresion().booleanValue()) {
             miDTO.setDatoVariable1(miCabecera.getSerieDocumentoLegal() + "-" + miCabecera.getNumeroDocumentoLegal());
          } else {
             miDTO.setDatoVariable1("$$$$$$$$$$-$$$$$$$$$$");
          }

          mensa = "<nfac><datoVariable01></nfac>";
          sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

          int totalPagina = 0;
          int paginaActual = 1;
          int numeroLineaGenerada = 0;
          if (cantidadLineasAGenerar <= lineasxPaginaPeq) {
            totalPagina = 1;
            this.generarAperturaPaginaPeq(sf2);
          } else {
              Float division = new Float(new Float(cantidadLineasAGenerar - lineasxPaginaPeq).floatValue() / new Float(lineasxPaginaGrande).floatValue());                    
              if ((division.floatValue() - division.intValue()) > 0) {                  
                totalPagina = division.intValue() + 2;
              } else {
                totalPagina = division.intValue() + 1;
              }                         
              this.generarAperturaPaginaGrande(sf2);
          }          

         

          this.generarPrimerCabeceraFactura(sf2, miCabecera, miParseador, paginaActual, totalPagina);
          this.generarSegundaCabeceraFactura(sf2, miCabecera, miParseador);
          this.generarAperturaDetalles(sf2);
          
          int arrayDetallesXCatalogoSize = arrayDetallesXCatalogo.size();
          Float SubTotalxCatalogo = new Float(0);          
          for (int i = 0; i < arrayDetallesXCatalogoSize; i++) {
            miDTO = (DTOImpresion)arrayDetallesXCatalogo.get(i);
            if (i != (arrayDetallesXCatalogoSize - 1)) {
                SubTotalxCatalogo = new Float(SubTotalxCatalogo.floatValue() + new Float(miDTO.getDatoVariable4()).floatValue()); 
            }
            sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensaDetalles, miDTO)); 
            numeroLineaGenerada++;
            if (this.validarNuevaPagina(sf2, miParseador, miCabecera, numeroLineaGenerada, paginaActual, totalPagina)) {
                numeroLineaGenerada = 0;
            }            
          }
          
          if (arrayDetallesXCatalogo.size() != 0) {
              this.generarBloqueSubtotalXCatalogo(sf2, miParseador, SubTotalxCatalogo, miCabecera.getNumeroDecimales()); 
              numeroLineaGenerada++;
              if (this.validarNuevaPagina(sf2, miParseador, miCabecera, numeroLineaGenerada, paginaActual, totalPagina)) {
                    numeroLineaGenerada = 0;
              }            
          } 
          
          Float totalFlete = (Float)this.generarBloqueFlete(sf2, miParseador, miCabecera);  
          numeroLineaGenerada++;
          if (this.validarNuevaPagina(sf2, miParseador, miCabecera, numeroLineaGenerada, paginaActual, totalPagina)) {
                numeroLineaGenerada = 0;
          }            
   
          
          /*if (generarBloqueAbonosSPV) {
             this.generarBloqueAbonosPostVenta(sf1, miParseador, abonoSPV);
              numeroLineaGenerada++;
          }*/
          if (this.validarNuevaPagina(sf2, miParseador, miCabecera, numeroLineaGenerada, paginaActual, totalPagina)) {
             numeroLineaGenerada = 0;
          }            
          
          Float totalProductosSinCV = new Float(0);
          int arrayProductosSinCVSize = arrayProductosSinCV.size();
          for (int i = 0; i < arrayProductosSinCVSize; i++) {  
            if (i == 0) {
               sf2.addMensaje("<blqpsc>");
            }
            miDTO = (DTOImpresion)arrayProductosSinCV.get(i);
            sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensaDetalles, miDTO)); 
            totalProductosSinCV = new Float(totalProductosSinCV.floatValue() + new Float(miDTO.getDatoVariable4()).floatValue());
            numeroLineaGenerada++;
            if (this.validarNuevaPagina(sf2, miParseador, miCabecera, numeroLineaGenerada, paginaActual, totalPagina)) {
                numeroLineaGenerada = 0;
            }            
            if (i == (arrayProductosSinCVSize - 1)) {
               sf2.addMensaje("</blqpsc>");
            }
          }
          
          if (generarBloqueDescuentos3) {
            Float calculoDescuento3;
            if (miCabecera.getImpDesc3TotalLocal().floatValue() > 0) {
                calculoDescuento3 = new Float(miCabecera.getImpDesc3TotalLocal().floatValue() * (-1));
            } else {
                calculoDescuento3 = new Float(miCabecera.getImpDesc3TotalLocal().floatValue());
            }                        
            this.generarBloqueResumenDescuentos3(sf2, miParseador, calculoDescuento3, miCabecera.getNumeroDecimales());
            numeroLineaGenerada++;
            if (this.validarNuevaPagina(sf2, miParseador, miCabecera, numeroLineaGenerada, paginaActual, totalPagina)) {
               numeroLineaGenerada = 0;
            }            
          }
          
          if (generarBloqueImporteRedondeo) {
            this.generarBloqueImporteRedondeo(sf2, miParseador, miCabecera.getImporteRedondeoLocal(), miCabecera.getNumeroDecimales());              
            numeroLineaGenerada++;
            if (this.validarNuevaPagina(sf2, miParseador, miCabecera, numeroLineaGenerada, paginaActual, totalPagina)) {
                numeroLineaGenerada = 0;
            }            
          }

          
          //Float totalAPagar = new Float(SubTotalxCatalogo.floatValue() + totalFlete.floatValue() + totalProductosSinCV.floatValue());          
          this.generarBloqueTotalAPagar(sf2, miParseador, miCabecera.getTotalAPagarLocal(), miCabecera.getNumeroDecimales());
          numeroLineaGenerada++;
          if (this.validarNuevaPagina(sf2, miParseador, miCabecera, numeroLineaGenerada, paginaActual, totalPagina)) {
             numeroLineaGenerada = 0;
          }            
          
          
          if (generarBloqueIVA) {
            this.generarBloqueIVAAsumido(sf2, miParseador, miCabecera, baseIVAAsumido);         
            numeroLineaGenerada++;
            if (this.validarNuevaPagina(sf2, miParseador, miCabecera, numeroLineaGenerada, paginaActual, totalPagina)) {
                numeroLineaGenerada = 0;
            }            
          }
          
          this.generarDatosIVA(sf2, miParseador, miCabecera, generarBloqueIVA, miCabecera.getNumeroDecimales());   
          numeroLineaGenerada++;
          if (this.validarNuevaPagina(sf2, miParseador, miCabecera, numeroLineaGenerada, paginaActual, totalPagina)) {
              numeroLineaGenerada = 0;
          }            
          
          if (generarBloqueDescuentos) {
            this.generarBloqueResumenDescuentos(sf2, miParseador, calculoDescuento, miCabecera.getNumeroDecimales());
          }
          
          this.generarCierreDetalles(sf2);
      
          if (paginaActual != totalPagina) {
            this.generarCierrePaginaGrande(sf2);
            this.generarAperturaPaginaPeq(sf2);
            this.generarPrimerCabeceraFactura(sf2, miCabecera, miParseador, paginaActual, totalPagina);
            this.generarSegundaCabeceraFactura(sf2, miCabecera, miParseador);            
          }  
          this.generarInformacionPagos(sf2, miParseador, miCabecera);
        
          this.generarCierrePaginaPeq(sf2);
          
          String mensaFinal="</frmfc2> ";
          sf2.addMensaje(mensaFinal);
          sf2.componerDocumento();
            
          try {
            sf2.saveDocument("c:\\", "FacturaColombia2.txt");
            this.documento = sf2.bufferOut;
          } catch (Exception e) {
            e.printStackTrace();
          }
          UtilidadesLog.debug("FacturaColombia2: " + sf2.toString());
          UtilidadesLog.info("FacturaColombia2.componerFactura(DTODocLegal datosDocLegal): Salida");
           
          } catch (Exception e) {
              UtilidadesLog.error("ERROR en FacturaColombia2",e);
              if (e instanceof MareException){
                  throw (MareException)e;
              }
              throw new MareException(e);
          }
    }

    public byte[] getDocument() {
      return this.documento;
    }
    
    private void generarPrimerCabeceraFactura (SerializadorFacturaColombia2 sf2, DTOFACDocumentoContableCabecera miCabecera, Parseador miParseador, int paginaActual, int totalPaginas) throws MareException {        
       String mensa = "<blqbar>";
       sf2.addMensaje(mensa);

       DTOImpresion miDTO = new DTOImpresion();
       miDTO.setDatoVariable1(validarToString(miCabecera.getCodigoBarras()));
       mensa = "<nbd><datoVariable01></nbd>";
       sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

       mensa = "</blqbar>";
       sf2.addMensaje(mensa);
  
       mensa = "<blqcab>";
       sf2.addMensaje(mensa);

       miDTO = new DTOImpresion();
       miDTO.setDatoVariable1(validarToString(miCabecera.getCodPeriodo().substring(4, 6).toString() + "-" + miCabecera.getCodPeriodo().substring(0, 4).toString()));
       mensa = "<fcam><datoVariable01></fcam>";
       sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
       
       miDTO = new DTOImpresion();
       miDTO.setDatoVariable1(validarToString(miCabecera.getCodRegion() + miCabecera.getCodZona() + miCabecera.getCodSeccion() + cerosIzq(miCabecera.getCodTerritorio(), 6)));
       mensa = "<cter><datoVariable01></cter>";
       sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

       miDTO = new DTOImpresion();
       miDTO.setDatoVariable1(validarToString(miCabecera.getNumConsolidado()));
       mensa = "<nbd><datoVariable01></nbd>";
       sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
  
       miDTO = new DTOImpresion();
       if (miCabecera.getIndicadorReimpresion().booleanValue()) {
           DAODocuContable daoActivo = new DAODocuContable();           
           miDTO.setDatoVariable1(validarToString(daoActivo.obtenerTagPrimerPedido(miCabecera.getOidCliente())));
       } else {
           miDTO.setDatoVariable1(validarToString(miCabecera.getPrimerPedido()));
       }
       mensa = "<tcon><datoVariable01></tcon>";
       sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
  
       miDTO = new DTOImpresion();
       miDTO.setDatoVariable1(validarToString(miCabecera.getCodCliente()));
       mensa = "<ccon><datoVariable01></ccon>";
       sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

       miDTO = new DTOImpresion();
       miDTO.setDatoVariable1(validarToString(miCabecera.getApellido1()));
       miDTO.setDatoVariable2(validarToString(miCabecera.getApellido2()));
       miDTO.setDatoVariable3(validarToString(miCabecera.getNombre1()));
       miDTO.setDatoVariable4(validarToString(miCabecera.getNombre2()));       
       mensa = "<ncon><datoVariable01> <datoVariable02> <datoVariable03> <datoVariable04></ncon>";
       sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

       miDTO = new DTOImpresion();
       miDTO.setDatoVariable1(validarToString(miCabecera.getNombreVia()));
       mensa = "<dir1><datoVariable01></dir1>";
       sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
       
       miDTO = new DTOImpresion();
       if (miCabecera.getTelefonoFijo() != null) {
          miDTO.setDatoVariable1(validarToString(miCabecera.getTelefonoFijo()));
       } else if (miCabecera.getTelefonoCelular() != null) {
          miDTO.setDatoVariable1(validarToString(miCabecera.getTelefonoCelular()));
       } else {
          miDTO.setDatoVariable1("");
       }
       mensa = "<telfijo><datoVariable01></telfijo>";
       sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
       
       miDTO = new DTOImpresion();
       miDTO.setDatoVariable1(validarToString(new Integer(paginaActual)));
       miDTO.setDatoVariable2(validarToString(new Integer(totalPaginas)));
       mensa = "<pagina>Pag. <datoVariable01>/<datoVariable02></pagina>";
       sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
       
       miDTO = new DTOImpresion();
       miDTO.setDatoVariable1(validarToString(miCabecera.getBarrio()));
       mensa = "<barrio><datoVariable01></barrio>";
       sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));


       miDTO = new DTOImpresion();
       String auxFecha = null;
       String stringFecha = "";
       try {
         auxFecha = UtilidadesFecha.convertirAString(miCabecera.getFechaFacturacion());
         String[] splitFechas = new String[3];
         StringTokenizer st = new StringTokenizer(auxFecha, "-");
         for(int cont = 0; cont<3; cont++) {
            splitFechas[cont] = st.nextToken();
         }
         stringFecha = splitFechas[2] + '/' + splitFechas[1] + '/' + splitFechas[0];  // Las fechas van en formato dd/MM/yyyy
       } catch(Exception e){
         UtilidadesLog.error("Error FacturaColombia1",e);
       }
       miDTO.setDatoVariable1(stringFecha);
       mensa = "<femi><datoVariable01></femi>";
       sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

       miDTO = new DTOImpresion();
       miDTO.setDatoVariable1(validarToString(miCabecera.getMunicipio())  + "(" + validarToString(miCabecera.getDepartamento()) + ")");
       mensa = "<ciudad><datoVariable01></ciudad>";
       sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
       
       mensa = "</blqcab>";
       sf2.addMensaje(mensa);
    }
    
    private void generarSegundaCabeceraFactura (SerializadorFacturaColombia2 sf2, DTOFACDocumentoContableCabecera miCabecera, Parseador miParseador) throws MareException {        
       String mensa = "<blqpag>";
       sf2.addMensaje(mensa);

       DTOImpresion miDTO = new DTOImpresion();
       miDTO.setDatoVariable1(validarToString(miCabecera.getCodCliente()));
       mensa = "<refupg><datoVariable01></refupg>";
       sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
      
       miDTO.setDatoVariable1(this.fechaVencimiento);
       mensa = "<feli><datoVariable01></feli>";
       sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
       
       mensa = "</blqpag>";
       sf2.addMensaje(mensa);
    }
    
     private ArrayList generarTotalesXCatalogo(DTOFACDocumentoContable docuContable) throws MareException {    
       ArrayList misDetalles = docuContable.getDetalle(); 
       HashMap hashCatalogos = new HashMap();
       ArrayList arrayCodigoVenta = new ArrayList();       
       int arraySize = misDetalles.size();
       for (int i = 0; i < arraySize; i++) {
          DTOFACDocumentoContableDetalle dtoDetalle = (DTOFACDocumentoContableDetalle)misDetalles.get(i);
          if (dtoDetalle.getCodigoVenta() != null ) {
              arrayCodigoVenta.add(dtoDetalle.getCodigoVenta().toString());
          } else {
            if (dtoDetalle.getCodigoVentaFicticio() != null) {
                /* Agregado por Cambio SiCC20080697   ----- AL */
                misDetalles.remove(i);
                i--;
                arraySize = misDetalles.size();
                /* Agregado por Cambio SiCC20080697   ----- AL */
                /* Eliminado por Cambio SiCC20080697  ----- AL   
                if (dtoDetalle.getPrecioContTotLocal().floatValue() != 0) {
                    DTOAgrupaCatalogos dtoCata = null;
                    if (hashCatalogos.containsKey("1-SD")) {
                        dtoCata = (DTOAgrupaCatalogos)hashCatalogos.get("1-SD");
                        dtoCata.setValorTotal(new Float(dtoCata.getValorTotal().floatValue() + dtoDetalle.getPrecioFactTotalLocal().floatValue()));                    
                    } else {
                        dtoCata = new DTOAgrupaCatalogos();
                        dtoCata.setCodigoAgrupacion("1-SD");
                        dtoCata.setCodigo("SD");
                        dtoCata.setDescripcion("Productos con SuperDescuento");
                        dtoCata.setValorTotal(new Float(dtoDetalle.getPrecioFactTotalLocal().floatValue()));                               
                    }
                hashCatalogos.put("1-SD", dtoCata);
                }
                */
            }
          }     
       }
       
       if (arrayCodigoVenta.size() > 0) {
           DAODocuContable daoActivo= new DAODocuContable();
           /* Eliminado por Cambio SiCC20080697    ----- AL 
           HashMap hashCatalogosAux = (HashMap)daoActivo.obtenerDatosCatalogo(arrayCodigoVenta, docuContable.getCabecera().getOidCabeceraSolicitud(), docuContable.getCabecera().getOidIdioma());
           */
           /* Agregado por Cambio SiCC20080697   ----- AL */
           HashMap hashCatalogosAux = (HashMap)daoActivo.obtenerDatosCatalogoFacturas(arrayCodigoVenta, docuContable.getCabecera().getOidCabeceraSolicitud());
           /* Agregado por Cambio SiCC20080697   ----- AL */
           
           for (int i = 0; i < arraySize; i++) {
              DTOFACDocumentoContableDetalle dtoDetalle = (DTOFACDocumentoContableDetalle)misDetalles.get(i);              
              if (dtoDetalle.getCodigoVenta() != null ) {
                 DTOAgrupaCatalogos dtoCataAux = (DTOAgrupaCatalogos)hashCatalogosAux.get(dtoDetalle.getCodigoVenta().toString());
                 if (dtoCataAux != null) {
                    DTOAgrupaCatalogos dtoCata = null; 
                    if ((dtoCataAux.getCodigoAgrupacion().substring(0, 1).equals("0") && dtoDetalle.getPrecioCatalTotLocal().floatValue() != 0) || 
                         (dtoCataAux.getCodigoAgrupacion().substring(0, 1).equals("1") && dtoDetalle.getPrecioContTotLocal().floatValue() != 0)) {
                        if (hashCatalogos.containsKey(dtoCataAux.getCodigoAgrupacion().toString())) {
                            dtoCata = (DTOAgrupaCatalogos)hashCatalogos.get(dtoCataAux.getCodigoAgrupacion().toString());
                            dtoCata.setValorTotal(new Float(dtoCata.getValorTotal().floatValue() + dtoDetalle.getPrecioFactTotalLocal().floatValue()));                    
                        } else {
                            dtoCata = new DTOAgrupaCatalogos();
                            dtoCata.setCodigoAgrupacion(dtoCataAux.getCodigoAgrupacion().toString());
                            dtoCata.setCodigo(dtoCataAux.getCodigo().toString());
                            dtoCata.setDescripcion(dtoCataAux.getDescripcion().toString());
                            dtoCata.setValorTotal(new Float(dtoDetalle.getPrecioFactTotalLocal().floatValue()));                               
                        }
                        hashCatalogos.put(dtoCataAux.getCodigoAgrupacion().toString(), dtoCata);
                    }
                } else {
                    UtilidadesLog.warn("El Codigo de Venta " + dtoDetalle.getCodigoVenta().toString() + " no tiene condicion promocion en null o 00 ");
                    misDetalles.remove(i);
                    i--;
                    arraySize = misDetalles.size();
                }
             }
          }           
       }
       
       ArrayList arrayTotalesXCatalogo = new ArrayList((Collection)hashCatalogos.values());       
       Collections.sort(arrayTotalesXCatalogo, new CatalogosComparator()); 
       return arrayTotalesXCatalogo;
     }
     
     private void generarBloqueSubtotalXCatalogo (SerializadorFacturaColombia2 sf2, Parseador miParseador, Float Subtotal, Integer numeroDecimales) {  
       sf2.addMensaje("<blqstf>");          
       DTOImpresion miDTO = new DTOImpresion();   
       miDTO.setDatoVariable1("");
       miDTO.setDatoVariable2("SUB TOTAL");
       miDTO.setDatoVariable3(validarToString(formatearDecimales(new BigDecimal(Subtotal.floatValue()).setScale(numeroDecimales.intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                                                                     
       sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensaDetalles, miDTO));       
       sf2.addMensaje("</blqstf>");
     }
     
     private Float generarBloqueFlete (SerializadorFacturaColombia2 sf2, Parseador miParseador, DTOFACDocumentoContableCabecera miCabecera) {  
       Float flete = new Float(0);
       if (miCabecera.getImporteFleteTotalLocal() != null && miCabecera.getImporteFleteTotalLocal().floatValue() > 0) {
           sf2.addMensaje("<blqflt>");          
           DTOImpresion miDTO = new DTOImpresion();   
           miDTO.setDatoVariable1("");
           miDTO.setDatoVariable2("FLETES");
           miDTO.setDatoVariable3(validarToString(formatearDecimales(new BigDecimal(miCabecera.getImporteFleteTotalLocal().floatValue()).setScale(miCabecera.getNumeroDecimales().intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                                                                            
           flete = new Float(miCabecera.getImporteFleteTotalLocal().floatValue());
           sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensaDetalles, miDTO));           
           sf2.addMensaje("</blqflt>");          
       }
       return flete;       
     }

     private void generarBloqueAbonosPostVenta(SerializadorFacturaColombia2 sf2, Parseador miParseador, Float abonoSPV, Integer numeroDecimales) {  
          DTOImpresion miDTO = new DTOImpresion();   
          miDTO.setDatoVariable1("");
          miDTO.setDatoVariable2("ABONOS SERVICIOS POSTVENTA");
          miDTO.setDatoVariable3(validarToString(formatearDecimales(new BigDecimal(abonoSPV.floatValue()).setScale(numeroDecimales.intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                                                                     
          sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensaDetalles, miDTO));           
     }

    private Float generarBloqueProductosSinCV (SerializadorFacturaColombia2 sf2, DTOFACDocumentoContable docuContable, Parseador miParseador, Integer numeroDecimales) {  
       Float totalProductosSinCV = new Float(0);
       sf2.addMensaje("<blqpsc>");          
       DTOImpresion miDTO;
       ArrayList misDetalles = docuContable.getDetalle();
       int arraySize = misDetalles.size();
       for (int i = 0; i < arraySize; i++) {
          DTOFACDocumentoContableDetalle dtoDetalle = (DTOFACDocumentoContableDetalle)misDetalles.get(i);   
          if (dtoDetalle.getCodigoVenta() == null && dtoDetalle.getCodigoVentaFicticio() == null) {
            miDTO = new DTOImpresion();
            miDTO.setDatoVariable1("");
            miDTO.setDatoVariable2(dtoDetalle.getDescripcionProd().toString());
            miDTO.setDatoVariable3(validarToString(formatearDecimales(new BigDecimal(dtoDetalle.getPrecioFactTotalLocal().floatValue()).setScale(numeroDecimales.intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                                                                                 
            sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensaDetalles, miDTO));          
            totalProductosSinCV = new Float(totalProductosSinCV.floatValue() + dtoDetalle.getPrecioFactTotalLocal().floatValue());
          }
       } 
       sf2.addMensaje("</blqpsc>");          
       return totalProductosSinCV;
    }
    
    private void generarBloqueTotalAPagar (SerializadorFacturaColombia2 sf2, Parseador miParseador, Float totalAPagar, Integer numeroDecimales) {  
       sf2.addMensaje("<blqttf>");          
       DTOImpresion miDTO = new DTOImpresion();   
       miDTO.setDatoVariable1("");
       miDTO.setDatoVariable2("*** TOTAL FACTURA");
       miDTO.setDatoVariable3(validarToString(formatearDecimales(new BigDecimal(totalAPagar.floatValue()).setScale(numeroDecimales.intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                                                                            
       sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensaDetalles, miDTO)); 
       sf2.addMensaje("</blqttf>");          
    }
    
    private void generarBloqueResumenDescuentos(SerializadorFacturaColombia2 sf2, Parseador miParseador, Float calculoDescuento, Integer numeroDecimales) {         
       sf2.addMensaje("<totpro>");          
       DTOImpresion miDTO = new DTOImpresion();   
       miDTO.setDatoVariable1("");
       miDTO.setDatoVariable2("ESTA FACTURA INCLUYE DESCUENTOS POR ");
       miDTO.setDatoVariable3(validarToString("$" + formatearDecimales(new BigDecimal(calculoDescuento.floatValue()).setScale(numeroDecimales.intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                                                                                                    
       sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensaDetalles, miDTO));           
       sf2.addMensaje("</totpro>");          
     }

   private void generarDatosIVA(SerializadorFacturaColombia2 sf2, Parseador miParseador, DTOFACDocumentoContableCabecera miCabecera, boolean generoIvaAsumido, Integer numeroDecimales) {  
     if (!generoIvaAsumido) {
        sf2.addMensaje("<blqiva>");
     }
     DTOImpresion miDTO = new DTOImpresion();   
     if (miCabecera.getImporteImpuestosTotalLocal() == null) {
         miCabecera.setImporteImpuestosTotalLocal(new Float(0));
     }
     if (miCabecera.getImporteImpuestosTotalLocal().floatValue() == 0) {
          miDTO.setDatoVariable1("");
          miDTO.setDatoVariable2("VENTA " + miCabecera.getDepartamento() + " IVA EXCLUIDO L-47/93 ART-22");
          miDTO.setDatoVariable3("$ 0");
     } else {
          miDTO.setDatoVariable1("");
          miDTO.setDatoVariable2("ESTA FACTURA INCLUYE IVA POR VALOR DE");
          miDTO.setDatoVariable3("$ " + formatearDecimales(new BigDecimal(miCabecera.getImporteImpuestosTotalLocal().floatValue()).setScale(numeroDecimales.intValue(), BigDecimal.ROUND_HALF_EVEN).toString()));            
     }
     sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensaDetalles, miDTO));   
     sf2.addMensaje("</blqiva>");          
   }
   
   private void generarBloqueIVAAsumido(SerializadorFacturaColombia2 sf2, Parseador miParseador, DTOFACDocumentoContableCabecera miCabecera, Float baseIVAAsumido) throws MareException {  
     sf2.addMensaje("<blqiva>");          
     DAODocuContable daoActivo = new DAODocuContable();
     DTOImpresion miDTO = new DTOImpresion();   
     miDTO.setDatoVariable1("");
     miDTO.setDatoVariable2("ESTA FACTURA INCLUYE IVA ASUMIDO POR LA EMPRESA POR VALOR $ :");
     miDTO.setDatoVariable3(validarToString(formatearDecimales(new BigDecimal(baseIVAAsumido.floatValue()).setScale(miCabecera.getNumeroDecimales().intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                                                                                                  
     sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensaDetalles, miDTO));            
   }


    private void generarInformacionPagos(SerializadorFacturaColombia2 sf2, Parseador miParseador, DTOFACDocumentoContableCabecera miCabecera) throws MareException {  
       sf2.addMensaje("<blqcpg>");
       DTOImpresion miDTO = new DTOImpresion();
       miDTO.setDatoVariable1(validarToString(miCabecera.getCodCliente()));
       String mensa = "<refupg><datoVariable01></refupg>";
       sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

       miDTO = new DTOImpresion();
       miDTO.setDatoVariable1(validarToString(this.fechaVencimiento));
       mensa = "<feli><datoVariable01></feli>";
       sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

       DAODocuContable daoActivo = new DAODocuContable();
       Float saldoCC = (Float)daoActivo.obtenerSaldoCC(miCabecera.getOidCliente(), this.fechaVencimiento, miCabecera.getOidPais());
    
       Float saldoCupon3 = new Float(0);  
       if (miCabecera.getDiasCruce() != null) {
         saldoCupon3 = (Float)daoActivo.obtenerSaldoCupon3(miCabecera.getOidCliente(), miCabecera.getOidPais(), miCabecera.getOidPeriodo(), miCabecera.getOidCabeceraSolicitud(), miCabecera.getIndicadorReimpresion(), Boolean.FALSE);            
       }
 
       Float saldoTotal = new Float(saldoCC.floatValue() - saldoCupon3.floatValue());
       miDTO = new DTOImpresion();   
       if (saldoTotal.floatValue() <= 0) {
          miDTO.setDatoVariable1(validarToString("0")); 
       } else {
          BigDecimal saldoAux = new BigDecimal(saldoTotal.intValue()).divide(new BigDecimal(100), miCabecera.getNumeroDecimales().intValue(), BigDecimal.ROUND_UP);  
          Integer saldoRedondeado = new Integer(saldoAux.intValue()*100);
          miDTO.setDatoVariable1(validarToString(formatearDecimales(new BigDecimal(saldoRedondeado.floatValue()).setScale(miCabecera.getNumeroDecimales().intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                                                                                                            
       }
       mensa = "<totapg><datoVariable01></totapg>";
       sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
       sf2.addMensaje("</blqcpg>");
    }
    
    
      private ArrayList calcularDetallesAGenerar (DTOFACDocumentoContable docuContable, Integer numeroDecimales) throws MareException {         
       ArrayList arrayDetallesXCatalogo = new ArrayList();
       ArrayList arrayTotalesXCatalogo = (ArrayList)this.generarTotalesXCatalogo(docuContable);        
       DTOImpresion miDTO;
       int arraySize = arrayTotalesXCatalogo.size();
       for (int i = 0; i < arraySize; i++) {
          DTOAgrupaCatalogos dtoCata = (DTOAgrupaCatalogos)arrayTotalesXCatalogo.get(i);
          miDTO = new DTOImpresion();   
          miDTO.setDatoVariable1(dtoCata.getCodigo().toString());
          miDTO.setDatoVariable2(dtoCata.getDescripcion().toString());
          miDTO.setDatoVariable3(validarToString(formatearDecimales(new BigDecimal(dtoCata.getValorTotal().floatValue()).setScale(numeroDecimales.intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                                                                                                                      
          miDTO.setDatoVariable4(dtoCata.getValorTotal().toString());
          arrayDetallesXCatalogo.add(miDTO);  
       } 
       if (arrayDetallesXCatalogo.size() != 0) {
           miDTO = new DTOImpresion();   
           miDTO.setDatoVariable1("");
           miDTO.setDatoVariable2("");
           miDTO.setDatoVariable3("______________");
           arrayDetallesXCatalogo.add(miDTO);
       }        
       return arrayDetallesXCatalogo;
   }
   
   private ArrayList calcularCantidadProductosSinCV (ArrayList misDetalles, Integer numeroDecimales) {  
       ArrayList arrayProductosSinCV = new ArrayList();
       int arraySize = misDetalles.size();
       for (int i = 0; i < arraySize; i++) {
          DTOFACDocumentoContableDetalle dtoDetalle = (DTOFACDocumentoContableDetalle)misDetalles.get(i);   
          if (dtoDetalle.getCodigoVenta() == null && dtoDetalle.getCodigoVentaFicticio() == null) {
            DTOImpresion miDTO = new DTOImpresion();
            miDTO.setDatoVariable1("");
            miDTO.setDatoVariable2(dtoDetalle.getDescripcionProd().toString());
            miDTO.setDatoVariable3(validarToString(formatearDecimales(new BigDecimal(dtoDetalle.getPrecioFactTotalLocal().floatValue()).setScale(numeroDecimales.intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                                                                                             
            miDTO.setDatoVariable4(dtoDetalle.getPrecioFactTotalLocal().toString());
            arrayProductosSinCV.add(miDTO);
          }
       } 
       return arrayProductosSinCV; 
   }
   
    private void generarAperturaDetalles (SerializadorFacturaColombia2 sf2) {
       String mensa = "<detalle>";
       sf2.addMensaje(mensa);
    }
    
    private void generarCierreDetalles (SerializadorFacturaColombia2 sf2) {
       String mensa = "</detalle>";
       sf2.addMensaje(mensa);
    }
    
    private boolean validarNuevaPagina(SerializadorFacturaColombia2 sf2, Parseador miParseador, DTOFACDocumentoContableCabecera miCabecera, int numeroLineaGenerada, int paginaActual, int totalPagina) throws MareException{
        boolean paginaNueva = false;
        if (numeroLineaGenerada == lineasXPagina) {
            paginaNueva = true;            
            this.generarCierreDetalles(sf2);
            this.generarCierrePaginaGrande(sf2);
            paginaActual++;            
            if (paginaActual == totalPagina) {
                this.generarAperturaPaginaPeq(sf2);
            } else {
                this.generarAperturaPaginaGrande(sf2);
            }
            this.generarPrimerCabeceraFactura(sf2, miCabecera, miParseador, paginaActual, totalPagina);
            this.generarSegundaCabeceraFactura(sf2, miCabecera, miParseador);
            this.generarAperturaDetalles(sf2);
        }
        return paginaNueva;
    }
    
    
    private void generarAperturaPaginaPeq (SerializadorFacturaColombia2 sf2) {
       String mensa = "<frmfc2pq>";
       sf2.addMensaje(mensa);
    }
    
    private void generarCierrePaginaPeq (SerializadorFacturaColombia2 sf2) {
       String mensa = "</frmfc2pq>";
       sf2.addMensaje(mensa);
    }
    
    private void generarAperturaPaginaGrande (SerializadorFacturaColombia2 sf2) {
       String mensa = "<frmfc2gr>";
       sf2.addMensaje(mensa);
    }

    private void generarCierrePaginaGrande (SerializadorFacturaColombia2 sf2) {
       String mensa = "</frmfc2gr>";
       sf2.addMensaje(mensa);
    }
    
    private void recuperarFechaVencimiento(DTOFACDocumentoContableCabecera miCabecera) throws MareException {
       DAODocuContable daoActivo= new DAODocuContable();
       Date fechaVenc = (Date)daoActivo.obtenerFechaVencimiento(miCabecera.getOidCabeceraSolicitud());

       if (fechaVenc == null) {
         fechaVenc = (Date)daoActivo.obtenerFechaFacturacionCampañaSiguiente(miCabecera.getOidPeriodo(), miCabecera.getOidZona());          
       }

       DTOImpresion miDTO = new DTOImpresion();
       String auxFecha = null;
       String stringFecha = "";
       try {
         auxFecha = UtilidadesFecha.convertirAString(fechaVenc);   
         String[] splitFechas = new String[3];
         StringTokenizer st = new StringTokenizer(auxFecha, "-");
         for(int cont = 0; cont<3; cont++) {
         splitFechas[cont] = st.nextToken();
       }
         stringFecha = splitFechas[2] + '/' + splitFechas[1] + '/' + splitFechas[0];  // Las fechas van en formato dd/MM/yyyy
       } catch(Exception e){
         UtilidadesLog.error("FacturaColombia1 de número consolidado = " + miCabecera.getOidCabeceraSolicitud() + " no puede seleccionar fecha límite pago");
         UtilidadesLog.error("Error FacturaColombia1",e);
       }
       this.fechaVencimiento = new String(stringFecha); 
    }
    
    
    private void generarBloqueResumenDescuentos3(SerializadorFacturaColombia2 sf2, Parseador miParseador, Float calculoDescuento3, Integer numeroDecimales) {         
       sf2.addMensaje("<premon>");          
       DTOImpresion miDTO = new DTOImpresion();   
       miDTO.setDatoVariable1("");
       miDTO.setDatoVariable2("PREMIO MONETARIO ");
       miDTO.setDatoVariable3(validarToString(formatearDecimales(new BigDecimal(calculoDescuento3.floatValue()).setScale(numeroDecimales.intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                                                                                                    
       sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensaDetalles, miDTO));           
       sf2.addMensaje("</premon>");          
     }

    private void generarBloqueImporteRedondeo(SerializadorFacturaColombia2 sf2, Parseador miParseador, Float importeRedondeo, Integer numeroDecimales) {         
       sf2.addMensaje("<ajured>");          
       DTOImpresion miDTO = new DTOImpresion();   
       miDTO.setDatoVariable1("");
       miDTO.setDatoVariable2("AJUSTES POR REDONDEO");
       if (importeRedondeo.floatValue() > 0) {
            miDTO.setDatoVariable3(validarToString("-" + formatearDecimales(new BigDecimal(importeRedondeo.floatValue() * (-1)).setScale(numeroDecimales.intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                                                                                                            
       } else {
            miDTO.setDatoVariable3(validarToString(formatearDecimales(new BigDecimal(importeRedondeo.floatValue()).setScale(numeroDecimales.intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                                                                                                    
       }
       sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensaDetalles, miDTO));           
       sf2.addMensaje("</ajured>");          
    }


}