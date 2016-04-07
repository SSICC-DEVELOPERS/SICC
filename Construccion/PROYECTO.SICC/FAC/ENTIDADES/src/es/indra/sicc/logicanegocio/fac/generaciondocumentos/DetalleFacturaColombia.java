package es.indra.sicc.logicanegocio.fac.generaciondocumentos;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.fac.DTOVencimientosCC;
import es.indra.sicc.dtos.msg.DTOImpresion;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class DetalleFacturaColombia extends DocumentoFAC {
    private byte[] documento;
    String mensaDetalles = "<txt><datoVariable01><t/><datoVariable02><t/><datoVariable03><t/><datoVariable04><t/><datoVariable05><t/><datoVariable06><t/><datoVariable07>" +
                           "<t/><datoVariable08><t/><datoVariable09><t/><datoVariable10><t/><datoVariable11></txt>";    
    String fechaVencimiento;
    int cantLineasPrimeraPagina = 41;
    int cantLineasSiguientesPaginas = 50;
    boolean indFechaVencimiento = false;
    Float totalProductosDirectos = new Float(0);
    
    public DetalleFacturaColombia() {
    }
    
    public byte[] getDocument() {
        return this.documento;
    }
    
    public void componerFactura(DTODocLegal datosDocLegal) throws MareException {
      try {
          UtilidadesLog.info("DetalleFacturaColombia.componerFactura(DTODocLegal datosDocLegal): Entrada");
          UtilidadesLog.warn("Generando DetalleFacturaColombia.......................................... ");          
          ArrayList listaPaginas = datosDocLegal.getlistaPaginas();
          Float totalCatalogo = new Float(0);
          
          SerializadorDetalleFacturaColombia sf2 = new SerializadorDetalleFacturaColombia();
          
          Iterator itPaginas = (Iterator)listaPaginas.iterator();
          
          while (itPaginas.hasNext()) {  
            DTOFACDocumentoContable docuContable = (DTOFACDocumentoContable)itPaginas.next();
            DTOFACDocumentoContableCabecera miCabecera = docuContable.getCabecera();
            Parseador miParseador = Parseador.getInstance();
            this.recuperarDatosPaginas(docuContable);               

            if (indFechaVencimiento) {
                DTOImpresion miDTO = new DTOImpresion();
                String mensa = "<frmdfc>";            
                sf2.addMensaje(mensa);
    
                DTOSubtotalesDetalleFactura dtoSubTotales = new DTOSubtotalesDetalleFactura();
                HashMap hashTotalesXCatalogo = (HashMap)this.generarTotalesXCatalogo(docuContable); 
           
           
                ArrayList misDetalles = docuContable.getDetalle(); 
                UtilidadesLog.debug("-AL- Detalle Factura Colombia - Array Detalles --> " + misDetalles);
                ArrayList arrayProductosDirectos = this.calcularCantidadProductosDirectos(misDetalles, miCabecera.getNumeroDecimales());     
                UtilidadesLog.debug("-AL- Detalle Factura Colombia - Array Detalles Despues Productos Directos --> " + misDetalles);
                Collections.sort(misDetalles, new PosicionesComparator());  
           
                int arraySize = misDetalles.size();
                int numeroPaginaActual = 1;            
                int numeroLineaGenerada = 0;
                String codAgrupCatalogoAnterior = new String("");
                String descCatalogoAnterior = new String("");            
                int cantidadLineasxPagina = cantLineasPrimeraPagina;
                
                mensa = "<blqpag41>";            
                sf2.addMensaje(mensa);
                this.generarPrimerCabeceraFactura(sf2, miCabecera, miParseador, numeroPaginaActual);                    
                mensa = "<detalle>";            
                sf2.addMensaje(mensa);
                boolean primerLinea = true;
                
                for (int i = 0; i < arraySize; i++) {                                
                    DTOFACDocumentoContableDetalle dtoDetalle = (DTOFACDocumentoContableDetalle)misDetalles.get(i);
                    /* Eliminado por Cambio SiCC20080697    ----- AL 
                    if ((dtoDetalle.getCodAgrupCatalogo().substring(0, 1).equals("0") && dtoDetalle.getPrecioCatalTotLocal().floatValue() != 0) || 
                            (dtoDetalle.getCodAgrupCatalogo().substring(0, 1).equals("1") && dtoDetalle.getPrecioContTotLocal().floatValue() != 0)) {
                    */
                    /* Agregado por Cambio SiCC20080697    ----- AL */
                    if (dtoDetalle.getCodAgrupCatalogo().substring(0, 1).equals("0") || (dtoDetalle.getCodAgrupCatalogo().substring(0, 1).equals("1") && dtoDetalle.getPrecioContTotLocal().floatValue() != 0)) {
                    /* Agregado por Cambio SiCC20080697    ----- AL */
                        if (!(codAgrupCatalogoAnterior.equals(dtoDetalle.getCodAgrupCatalogo().toString()))){
                            if (!primerLinea) {
                               if (cantidadLineasxPagina == numeroLineaGenerada) {
                                    this.generarCierreDetalleProductos(sf2);
                                    this.generarCierrePaginaActual(sf2, miParseador, numeroPaginaActual);
                                    cantidadLineasxPagina = cantLineasSiguientesPaginas;
                                    numeroPaginaActual++;
                                    numeroLineaGenerada = 0;
                                    this.generarNuevaPagina(sf2, miParseador, numeroPaginaActual, miCabecera);
                               } else {
                                    this.generarCierreDetalleProductos(sf2);
                               }                              
                               this.generarLineaTotalCatalogo(sf2, miParseador, dtoSubTotales, descCatalogoAnterior, miCabecera.getNumeroDecimales());
                               totalCatalogo = new Float(totalCatalogo.floatValue() + dtoSubTotales.getSubtotalPrecioTotal().floatValue());
                               dtoSubTotales = new DTOSubtotalesDetalleFactura(); 
                               numeroLineaGenerada++;
                            }
                            if (cantidadLineasxPagina == numeroLineaGenerada) {
                                this.generarCierrePaginaActual(sf2, miParseador, numeroPaginaActual);
                                cantidadLineasxPagina = cantLineasSiguientesPaginas;
                                numeroPaginaActual++;
                                numeroLineaGenerada = 0;
                                this.generarNuevaPagina(sf2, miParseador, numeroPaginaActual, miCabecera);
                            }                            
                            codAgrupCatalogoAnterior = dtoDetalle.getCodAgrupCatalogo().toString();
                            DTOAgrupaCatalogos dtoCata = (DTOAgrupaCatalogos)hashTotalesXCatalogo.get(dtoDetalle.getCodAgrupCatalogo().toString());                  
                            this.generarLineaCabeceraCatalogo(sf2, miParseador, dtoCata.getDescripcion());
                            descCatalogoAnterior = dtoCata.getDescripcion().toString();
                            numeroLineaGenerada++;
                            if (cantidadLineasxPagina == numeroLineaGenerada) {
                                this.generarCierrePaginaActual(sf2, miParseador, numeroPaginaActual);
                                cantidadLineasxPagina = cantLineasSiguientesPaginas;
                                numeroPaginaActual++;
                                numeroLineaGenerada = 0;
                                this.generarNuevaPagina(sf2, miParseador, numeroPaginaActual, miCabecera);
                                this.generarAperturaDetalleProductos(sf2);
                            } else {
                                this.generarAperturaDetalleProductos(sf2);
                            }
                        }
                        if (cantidadLineasxPagina == numeroLineaGenerada) {
                            this.generarCierreDetalleProductos(sf2);
                            this.generarCierrePaginaActual(sf2, miParseador, numeroPaginaActual);
                            cantidadLineasxPagina = cantLineasSiguientesPaginas;
                            numeroPaginaActual++;
                            numeroLineaGenerada = 0;
                            this.generarNuevaPagina(sf2, miParseador, numeroPaginaActual, miCabecera);
                            this.generarAperturaDetalleProductos(sf2);
                        }
                        dtoSubTotales = (DTOSubtotalesDetalleFactura)this.generarLineaDetalle(sf2, miParseador, dtoSubTotales, dtoDetalle, miCabecera.getNumeroDecimales());
                        numeroLineaGenerada++;
                        primerLinea = false;
                    }
                 } 
    
                 if (arraySize > 0 && !primerLinea) {
                     this.generarCierreDetalleProductos(sf2);
                     if (cantidadLineasxPagina == numeroLineaGenerada) {                
                        this.generarCierrePaginaActual(sf2, miParseador, numeroPaginaActual);
                        cantidadLineasxPagina = cantLineasSiguientesPaginas;
                        numeroPaginaActual++;
                        numeroLineaGenerada = 0;
                        this.generarNuevaPagina(sf2, miParseador, numeroPaginaActual, miCabecera);                
                     }            
                     this.generarLineaTotalCatalogo(sf2, miParseador, dtoSubTotales, descCatalogoAnterior, miCabecera.getNumeroDecimales());                        
                     totalCatalogo = new Float(totalCatalogo.floatValue() + dtoSubTotales.getSubtotalPrecioTotal().floatValue());
                     numeroLineaGenerada++;
                 }
                 
                 int lineaImporteRedondeo = 0;
                 if (miCabecera.getImporteRedondeoLocal() != null && miCabecera.getImporteRedondeoLocal().floatValue() != 0) {
                    lineaImporteRedondeo++;
                 }
                 
                 Integer cantidadLineasBloqueTotales = new Integer(12 + arrayProductosDirectos.size() + lineaImporteRedondeo);
                 numeroLineaGenerada = numeroLineaGenerada + 5; // Se agregan 5 lineas para separacion entre detalles y el Bloque de totales
                 if (cantidadLineasxPagina <= numeroLineaGenerada) {                
                    this.generarCierrePaginaActual(sf2, miParseador, numeroPaginaActual);
                    cantidadLineasxPagina = cantLineasSiguientesPaginas;
                    numeroPaginaActual++;
                    numeroLineaGenerada = 0;
                    this.generarNuevaPagina(sf2, miParseador, numeroPaginaActual, miCabecera);                                
                 } else {   
                    if (new Integer(numeroLineaGenerada + cantidadLineasBloqueTotales.intValue()).intValue() > cantidadLineasxPagina) {
                        this.generarCierrePaginaActual(sf2, miParseador, numeroPaginaActual);
                        cantidadLineasxPagina = cantLineasSiguientesPaginas;
                        numeroPaginaActual++;
                        numeroLineaGenerada = 0;
                        this.generarNuevaPagina(sf2, miParseador, numeroPaginaActual, miCabecera);                                    
                    }                
                 }              
                 this.generarBloqueTotales(sf2, docuContable, miParseador, this.fechaVencimiento, arrayProductosDirectos, cantidadLineasBloqueTotales, numeroLineaGenerada, totalCatalogo);
                 numeroLineaGenerada = numeroLineaGenerada + cantidadLineasBloqueTotales.intValue();
    
                 DAODocuContable daoActivo = new DAODocuContable();
                 ArrayList arrayVencimientos = (ArrayList)daoActivo.obtenerVencimientosCC(miCabecera.getOidCliente(), this.fechaVencimiento, miCabecera.getOidPais());
    
                 if (cantidadLineasxPagina == numeroLineaGenerada) {                
                    this.generarCierrePaginaActual(sf2, miParseador, numeroPaginaActual);
                    cantidadLineasxPagina = cantLineasSiguientesPaginas;
                    numeroPaginaActual++;
                    numeroLineaGenerada = 0;
                    this.generarNuevaPagina(sf2, miParseador, numeroPaginaActual, miCabecera);                                
                 }             
                
                 if (arrayVencimientos.size() > 0) {                 
                     if (new Integer(numeroLineaGenerada + 4).intValue() > cantidadLineasxPagina) {                
                        this.generarCierrePaginaActual(sf2, miParseador, numeroPaginaActual);
                        cantidadLineasxPagina = cantLineasSiguientesPaginas;
                        numeroPaginaActual++;
                        numeroLineaGenerada = 0;
                        this.generarNuevaPagina(sf2, miParseador, numeroPaginaActual, miCabecera);                                
                     }                    
                 } else {
                    if (new Integer(numeroLineaGenerada + 2).intValue() > cantidadLineasxPagina) {
                        this.generarCierrePaginaActual(sf2, miParseador, numeroPaginaActual);
                        cantidadLineasxPagina = cantLineasSiguientesPaginas;
                        numeroPaginaActual++;
                        numeroLineaGenerada = 0;
                        this.generarNuevaPagina(sf2, miParseador, numeroPaginaActual, miCabecera);                                    
                    }
                 }
                 
                 this.generarCabeceraBloqueVencimientos(sf2, miCabecera, miParseador);
                 numeroLineaGenerada++;
                 
                 this.generarAperturaBloqueDetalleVencimientos(sf2);             
                 if (arrayVencimientos.size() > 0) {   
                    this.generarCabeceraDetallesVencimientos(sf2, miParseador);
                    numeroLineaGenerada++;
                    numeroLineaGenerada++;
                    Iterator it = (Iterator)arrayVencimientos.iterator();
                    Float totalImportes = new Float(0);
                    while (it.hasNext()) {
                       DTOVencimientosCC dtoVencimientosCC = (DTOVencimientosCC)it.next();         
                       this.generarLineaVencimientos(sf2, miParseador, dtoVencimientosCC, miCabecera.getNumeroDecimales());                   
                       totalImportes = new Float(totalImportes.floatValue() + dtoVencimientosCC.getImportePendiente().floatValue());
                       numeroLineaGenerada++;
                       if (cantidadLineasxPagina == numeroLineaGenerada) {                
                           this.generarCierreBloqueDetalleVencimientos(sf2);
                           this.generarCierrePaginaActual(sf2, miParseador, numeroPaginaActual);
                           cantidadLineasxPagina = cantLineasSiguientesPaginas;
                           numeroPaginaActual++;
                           numeroLineaGenerada = 0;
                           this.generarNuevaPagina(sf2, miParseador, numeroPaginaActual, miCabecera);  
                           this.generarCabeceraBloqueVencimientos(sf2, miCabecera, miParseador);
                           numeroLineaGenerada++;
                           this.generarAperturaBloqueDetalleVencimientos(sf2);
                           this.generarCabeceraDetallesVencimientos(sf2, miParseador);
                           numeroLineaGenerada++;
                           numeroLineaGenerada++;
                       }
                    }                
                    this.generarTotalBloqueVencimientos(sf2, miParseador, totalImportes, miCabecera.getNumeroDecimales());
                    this.generarCierreBloqueDetalleVencimientos(sf2);
                    this.generarCierrePaginaActual(sf2, miParseador, numeroPaginaActual);
                 } else {                
                    sf2.addMensaje("<txt>Su cuenta no presenta cuotas por pagar para las proximas facturaciones</txt>");
                    this.generarCierreBloqueDetalleVencimientos(sf2);
                    this.generarCierrePaginaActual(sf2, miParseador, numeroPaginaActual);
                 }
                
                 miDTO = new DTOImpresion();
                 miDTO.setDatoVariable1(validarToString(new Integer(numeroPaginaActual)));
                 mensa = "<totpag><datoVariable01></totpag>";
                 sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
    
                String mensaFinal = "</frmdfc> ";
                sf2.addMensaje(mensaFinal);
                sf2.componerDocumento();            
              }
          } 
          
          
          try {
            sf2.saveDocument("c:\\", "DetalleFacturaColombia.txt");
            if (indFechaVencimiento) {
                this.documento = sf2.bufferOut;
            } else {
                this.documento = new byte[0];
            }
          } catch (Exception e) {
             e.printStackTrace();
          }                
          UtilidadesLog.debug("DetalleFacturaColombia: " + sf2.toString());
            
          UtilidadesLog.info("DetalleFacturaColombia.componerFactura(DTODocLegal datosDocLegal): Salida"); 
      } catch (Exception e) {
          UtilidadesLog.error("ERROR en DetalleFacturaColombia",e);
          if (e instanceof MareException){
              throw (MareException)e;
          }
          throw new MareException(e);
      }
    }
    
    
    private void generarPrimerCabeceraFactura (SerializadorDetalleFacturaColombia sf2, DTOFACDocumentoContableCabecera miCabecera, Parseador miParseador, int numeroPaginaActual) {        
       UtilidadesLog.info("DetalleFacturaColombia.generarPrimerCabeceraFactura(SerializadorDetalleFacturaColombia sf2, DTOFACDocumentoContableCabecera miCabecera, Parseador miParseador): Entrada");
       String mensa = "<blqcab>";
       sf2.addMensaje(mensa);
       
       DTOImpresion miDTO = new DTOImpresion();
       miDTO.setDatoVariable1("$$$$$$$$$$-$$$$$$$$$$");
       mensa = "<nfac><datoVariable01></nfac>";
       sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
       
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
       miDTO.setDatoVariable1(validarToString(miCabecera.getCodCliente()));
       mensa = "<refupg><datoVariable01></refupg>";
       sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
  
       miDTO = new DTOImpresion();
       miDTO.setDatoVariable1(validarToString(miCabecera.getPrimerPedido()));
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
       miDTO.setDatoVariable1(validarToString(new Integer(numeroPaginaActual)));
       mensa = "<pagina>Pag. <datoVariable01>/ </pagina>";
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
         UtilidadesLog.error("Error DetalleFacturaColombia",e);
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
       UtilidadesLog.info("DetalleFacturaColombia.generarPrimerCabeceraFactura(SerializadorDetalleFacturaColombia sf2, DTOFACDocumentoContableCabecera miCabecera, Parseador miParseador): Salida");
    }
    
     private HashMap generarTotalesXCatalogo(DTOFACDocumentoContable docuContable) throws MareException {   
       UtilidadesLog.info("DetalleFacturaColombia.generarTotalesXCatalogo(DTOFACDocumentoContable docuContable): Entrada");       
       HashMap hashCatalogos = new HashMap();
       ArrayList arrayCodigoVenta = new ArrayList();    
       ArrayList misDetalles = docuContable.getDetalle();
       
       int arraySize = misDetalles.size();
       for (int i = 0; i < arraySize; i++) {
          DTOFACDocumentoContableDetalle dtoDetalle = (DTOFACDocumentoContableDetalle)misDetalles.get(i);
          if (dtoDetalle.getCodigoVenta() != null ) {
              arrayCodigoVenta.add(dtoDetalle.getCodigoVenta().toString());
          } else {
            if (dtoDetalle.getCodigoVentaFicticio() != null) {
                if (dtoDetalle.getPrecioContTotLocal().floatValue() != 0) {
                    dtoDetalle.setCodAgrupCatalogo("1-SD");
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
            }
          }     
       }
       
       if (arrayCodigoVenta.size() > 0) {
           DAODocuContable daoActivo= new DAODocuContable();
           HashMap hashCatalogosAux = (HashMap)daoActivo.obtenerDatosCatalogo(arrayCodigoVenta, docuContable.getCabecera().getOidCabeceraSolicitud(), docuContable.getCabecera().getOidIdioma());
           
           for (int i = 0; i < arraySize; i++) {
              DTOFACDocumentoContableDetalle dtoDetalle = (DTOFACDocumentoContableDetalle)misDetalles.get(i);              
              if (dtoDetalle.getCodigoVenta() != null ) {
                 DTOAgrupaCatalogos dtoCataAux = (DTOAgrupaCatalogos)hashCatalogosAux.get(dtoDetalle.getCodigoVenta().toString());
                 dtoDetalle.setCodAgrupCatalogo(dtoCataAux.getCodigoAgrupacion());
                 DTOAgrupaCatalogos dtoCata = null; 
                 /* Eliminado por Cambio SiCC20080697    ----- AL 
                 if ((dtoCataAux.getCodigoAgrupacion().substring(0, 1).equals("0") && dtoDetalle.getPrecioCatalTotLocal().floatValue() != 0) || 
                     (dtoCataAux.getCodigoAgrupacion().substring(0, 1).equals("1") && dtoDetalle.getPrecioContTotLocal().floatValue() != 0)) {
                 */
                 /* Agregado por Cambio SiCC20080697    ----- AL */
                 if (dtoCataAux.getCodigoAgrupacion().substring(0, 1).equals("0") || (dtoCataAux.getCodigoAgrupacion().substring(0, 1).equals("1") && dtoDetalle.getPrecioContTotLocal().floatValue() != 0)) {
                 /* Agregado por Cambio SiCC20080697    ----- AL */
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
              }
           }           
       }
       UtilidadesLog.info("DetalleFacturaColombia.generarTotalesXCatalogo(DTOFACDocumentoContable docuContable): Salida");
       return hashCatalogos;
     }
 
    private void generarBloqueTotales(SerializadorDetalleFacturaColombia sf2, DTOFACDocumentoContable docuContable, Parseador miParseador, String fechaVenc, ArrayList arrayProductosDirectos, Integer cantidadLineasBloqueTotales, int numeroLineaActual, Float totalCatalogo) throws MareException { 
        UtilidadesLog.info("DetalleFacturaColombia.generarBloqueTotales(SerializadorDetalleFacturaColombia sf2, DTOFACDocumentoContable docuContable, Parseador miParseador, String fechaVenc, ArrayList arrayProductosDirectos, Integer cantidadLineasBloqueTotales, Float totalCatalogo): Entrada");
        DTOFACDocumentoContableCabecera miCabecera = docuContable.getCabecera();
        DAODocuContable daoActivo = new DAODocuContable();
        Float saldoAnterior = new Float(0);        
        Float saldoCupon3 = new Float(0);  
        if (miCabecera.getDiasCruce() != null) {
          saldoCupon3 = (Float)daoActivo.obtenerSaldoCupon3(miCabecera.getOidCliente(), miCabecera.getOidPais(), miCabecera.getOidPeriodo(), miCabecera.getOidCabeceraSolicitud(), Boolean.FALSE, Boolean.FALSE);            
        }
        if (miCabecera.getSaldoAnterior() != null) {
            saldoAnterior = new Float(miCabecera.getSaldoAnterior().floatValue());
        }
        UtilidadesLog.debug("Detalle Factura - Saldo Anterior - " + saldoAnterior);
        UtilidadesLog.debug("Detalle Factura - Saldo Cupon 3 - " + saldoCupon3);
        Float saldoAux = new Float(saldoAnterior.floatValue() - saldoCupon3.floatValue());
        UtilidadesLog.debug("Detalle Factura - (Saldo Anterior - Cupon 3) - " + saldoAux);
        if (saldoAux.floatValue() >= 0) {
            saldoAnterior = (Float)saldoAux;
        } else {
            saldoAnterior = new Float(0);
        }
        UtilidadesLog.debug("Detalle Factura - Saldo Anterior - Despues del IF" + saldoAnterior);
        
        Float saldoActual = (Float)daoActivo.obtenerSaldoCCDetalleFactura(miCabecera.getOidCliente(), fechaVenc, miCabecera.getOidPais(), 0);
        if (miCabecera.getIndicadorReimpresion() == null || !miCabecera.getIndicadorReimpresion().booleanValue()) {
           daoActivo.actualizarSaldoAnterior(saldoActual, miCabecera.getOidCliente());
        }        
        UtilidadesLog.debug("Detalle Factura - Saldo Actual - " + saldoActual);
        UtilidadesLog.debug("Detalle Factura - Saldo Cupon 3 - " + saldoCupon3);        
        saldoActual = new Float(saldoActual.floatValue() - saldoCupon3.floatValue());        
        UtilidadesLog.debug("Detalle Factura - (Saldo Actual - Cupon 3) - " + saldoActual);
        if (saldoActual.floatValue() <= 0) {
            saldoActual = new Float(0);
        }
        UtilidadesLog.debug("Detalle Factura - Saldo Actual - Despues del IF Actual - " + saldoActual);
        
        sf2.addMensaje("<blqcrs>"); 
        DTOImpresion miDTO = new DTOImpresion();
        miDTO.setDatoVariable1(validarToString(cantidadLineasBloqueTotales));        
        String mensa = "<crslin><datoVariable01></crslin>";
        sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

        miDTO = new DTOImpresion();
        if (numeroLineaActual == 0) {
            miDTO.setDatoVariable1(validarToString("1"));        
        } else {
            miDTO.setDatoVariable1(validarToString("0"));        
        }        
        mensa = "<salto><datoVariable01></salto>";        
        sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
        
        miDTO = new DTOImpresion();
        //Float totalCatalogo = new Float(miCabecera.getPrecioCataTotaLocal().floatValue() + miCabecera.getPrecioContTotaLocal().floatValue());
        miDTO.setDatoVariable1(new String("TOTAL CATALOGO"));
        miDTO.setDatoVariable2(validarToString(formatearDecimales(new BigDecimal(totalCatalogo.floatValue()).setScale(miCabecera.getNumeroDecimales().intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));
        mensa = "<txtcrs><datoVariable01></txtcrs><valcrs><datoVariable02></valcrs>";
        sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

        Float superDescuento = new Float(miCabecera.getPrecioContTotaLocal().floatValue());
        miDTO = new DTOImpresion();
        miDTO.setDatoVariable1(new String("(-) Superdescuento"));
        miDTO.setDatoVariable2(validarToString(formatearDecimales(new BigDecimal(superDescuento.floatValue()).setScale(miCabecera.getNumeroDecimales().intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));            
        sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

        Float descuento = new Float((miCabecera.getImpDesc1TotLocal().floatValue() + miCabecera.getImpDesc3TotalLocal().floatValue()));
        miDTO = new DTOImpresion();
        miDTO.setDatoVariable1(new String("(-) Descuentos"));
        miDTO.setDatoVariable2(validarToString(formatearDecimales(new BigDecimal(descuento.floatValue()).setScale(miCabecera.getNumeroDecimales().intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                            
        sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

        Float totalConDescuento = new Float(miCabecera.getPrecioCataTotaLocal().floatValue() + miCabecera.getPrecioContTotaLocal().floatValue() - miCabecera.getImporteDescuentoTotaLocal().floatValue() - this.totalProductosDirectos.floatValue());
        miDTO = new DTOImpresion();
        miDTO.setDatoVariable1(new String("TOTAL CON DESCUENTO"));
        miDTO.setDatoVariable2(validarToString(formatearDecimales(new BigDecimal(totalConDescuento.floatValue()).setScale(miCabecera.getNumeroDecimales().intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                           
        sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

        miDTO = new DTOImpresion();
        miDTO.setDatoVariable1(new String("(+) Gastos de transporte"));
        miDTO.setDatoVariable2(validarToString(formatearDecimales(new BigDecimal(miCabecera.getImporteFleteTotalLocal().floatValue()).setScale(miCabecera.getNumeroDecimales().intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                           
        sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

        
        ArrayList arrayDetalles = docuContable.getDetalle(); 
        this.generarBloqueProductosDirectos(sf2, arrayProductosDirectos, miParseador);

        if (miCabecera.getImporteRedondeoLocal() != null && miCabecera.getImporteRedondeoLocal().floatValue() != 0) {
            miDTO = new DTOImpresion();
            Float importeRedondeo = new Float(miCabecera.getImporteRedondeoLocal().floatValue());
            if (miCabecera.getImporteRedondeoLocal().floatValue() < 0) {            
               miDTO.setDatoVariable1(new String("(-) Ajustes Por Redondeo"));    
               importeRedondeo = new Float(importeRedondeo.floatValue() * (-1));
            } else {
               miDTO.setDatoVariable1(new String("(+) Ajustes Por Redondeo"));    
            }           
            miDTO.setDatoVariable2(validarToString(formatearDecimales(new BigDecimal(importeRedondeo.floatValue()).setScale(miCabecera.getNumeroDecimales().intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                          
            sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
        }


        Float totalFactura = new Float(miCabecera.getTotalAPagarLocal().floatValue());
        miDTO = new DTOImpresion();
        miDTO.setDatoVariable1(new String("TOTAL"));
        miDTO.setDatoVariable2(validarToString(formatearDecimales(new BigDecimal(totalFactura.floatValue()).setScale(miCabecera.getNumeroDecimales().intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                          
        sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

        Float abonosServiciosPV = (Float)daoActivo.obtenerAbonosSPV(miCabecera.getOidCliente(), miCabecera.getOidPeriodo());
        miDTO = new DTOImpresion();
        miDTO.setDatoVariable1(new String("(-) Abono Atencion de Servicios"));
        if (abonosServiciosPV.floatValue() < 0) {
            miDTO.setDatoVariable2(validarToString(formatearDecimales(new BigDecimal(new Float(abonosServiciosPV.floatValue() * (-1)).floatValue()).setScale(miCabecera.getNumeroDecimales().intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                  
        } else {
            miDTO.setDatoVariable2(validarToString(formatearDecimales(new BigDecimal(abonosServiciosPV.floatValue()).setScale(miCabecera.getNumeroDecimales().intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                          
        }        
        sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

        Float saldoPP = (Float)daoActivo.obtenerSaldoCCDetalleFactura(miCabecera.getOidCliente(), fechaVenc, miCabecera.getOidPais(), 1);
        miDTO = new DTOImpresion();
        miDTO.setDatoVariable1(new String("(-) Pagos posteriores"));
        miDTO.setDatoVariable2(validarToString(formatearDecimales(new BigDecimal(saldoPP.floatValue()).setScale(miCabecera.getNumeroDecimales().intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                  
        sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));


        UtilidadesLog.debug("Detalle Factura - Antes del Calculo de Otros Ajustes - Saldo Actual - " + saldoActual);
        UtilidadesLog.debug("Detalle Factura - Antes del Calculo de Otros Ajustes - Saldo Anterior - " + saldoAnterior);
        UtilidadesLog.debug("Detalle Factura - Antes del Calculo de Otros Ajustes - abonosServiciosPV - " + abonosServiciosPV);
        UtilidadesLog.debug("Detalle Factura - Antes del Calculo de Otros Ajustes - totalFactura - " + totalFactura);
        Float otrosAjustes = new Float(saldoActual.floatValue() - saldoAnterior.floatValue() - abonosServiciosPV.floatValue() - totalFactura.floatValue());
        if (otrosAjustes.floatValue() != 0) {
            miDTO = new DTOImpresion();
            miDTO.setDatoVariable1(new String("(+/-) Otros Ajustes"));    
            miDTO.setDatoVariable2(validarToString(formatearDecimales(new BigDecimal(otrosAjustes.floatValue()).setScale(miCabecera.getNumeroDecimales().intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                              
            sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
        }

        /*Float saldoSinAjustar = (Float)daoActivo.obtenerSaldoCC(miCabecera.getOidCliente(), fechaVenc, miCabecera.getOidPais());
        BigDecimal saldoCCBD = new BigDecimal((saldoSinAjustar.floatValue() - saldoCupon3.floatValue()) /100);*/
        BigDecimal saldoCCBD = new BigDecimal((saldoActual.floatValue()) /100);        
        saldoCCBD = saldoCCBD.setScale(miCabecera.getNumeroDecimales().intValue(), BigDecimal.ROUND_UP);
        /*BigDecimal saldoBD = new BigDecimal(saldoSinAjustar.floatValue()).setScale(miCabecera.getNumeroDecimales().intValue(), BigDecimal.ROUND_HALF_EVEN);*/
        BigDecimal saldoBD = new BigDecimal(saldoActual.floatValue()).setScale(miCabecera.getNumeroDecimales().intValue(), BigDecimal.ROUND_HALF_EVEN);        
        Float saldoAjustadoCentena = new Float(new Float(saldoCCBD.floatValue() * 100).floatValue() - saldoBD.floatValue());

        
        miDTO = new DTOImpresion();
        miDTO.setDatoVariable1(new String("(+) Ajuste a la Centena")); 
        miDTO.setDatoVariable2(validarToString(formatearDecimales(new BigDecimal(saldoAjustadoCentena.floatValue()).setScale(miCabecera.getNumeroDecimales().intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));        
        sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

        miDTO = new DTOImpresion();
        miDTO.setDatoVariable1(new String("(+) Saldo campaña anterior")); 
        miDTO.setDatoVariable2(validarToString(formatearDecimales(new BigDecimal(saldoAnterior.floatValue()).setScale(miCabecera.getNumeroDecimales().intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                                              
        sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

        Float totalMontoPagar = new Float(saldoActual.floatValue() + saldoAjustadoCentena.floatValue() - saldoPP.floatValue());
        miDTO = new DTOImpresion();
        miDTO.setDatoVariable1(new String("TOTAL MONTO A PAGAR")); 
        miDTO.setDatoVariable2(validarToString(formatearDecimales(new BigDecimal(totalMontoPagar.floatValue()).setScale(miCabecera.getNumeroDecimales().intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                                                              
        mensa = "<txtcrs><b><datoVariable01></b></txtcrs><valcrs><b><datoVariable02></b></valcrs>";
        sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO)); 

        sf2.addMensaje("</blqcrs>"); 
        UtilidadesLog.info("DetalleFacturaColombia.generarBloqueTotales(SerializadorDetalleFacturaColombia sf2, DTOFACDocumentoContable docuContable, Parseador miParseador, String fechaVenc, ArrayList arrayProductosDirectos, Integer cantidadLineasBloqueTotales, Float totalCatalogo): Salida");
    }
    
    private void generarLineaVencimientos (SerializadorDetalleFacturaColombia sf2, Parseador miParseador, DTOVencimientosCC dtoVencimientosCC, Integer numeroDecimales) throws MareException { 
        UtilidadesLog.info("DetalleFacturaColombia.generarLineaVencimientos(SerializadorDetalleFacturaColombia sf2, Parseador miParseador, DTOVencimientosCC dtoVencimientosCC): Entrada");
        String mensaVencDet = "<txt><datoVariable01><t/><datoVariable02><t/><datoVariable03><t/><datoVariable04><t/><datoVariable05></txt>";

        DTOImpresion miDTO = new DTOImpresion();
        miDTO.setDatoVariable1(validarToString(dtoVencimientosCC.getCodigoPeriodo()));
        miDTO.setDatoVariable2(validarToString(dtoVencimientosCC.getNumeroIdentificadorCuota()));
        miDTO.setDatoVariable3(validarToString(dtoVencimientosCC.getNumeroOrdenCuota()));
        miDTO.setDatoVariable4(validarToString(dtoVencimientosCC.getFechaVencimiento()));
        miDTO.setDatoVariable5(validarToString(formatearDecimales(new BigDecimal(dtoVencimientosCC.getImportePendiente().floatValue()).setScale(numeroDecimales.intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                                                                                                                                  
        sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensaVencDet, miDTO)); 
 
        UtilidadesLog.info("DetalleFacturaColombia.generarLineaVencimientos(SerializadorDetalleFacturaColombia sf2, Parseador miParseador, DTOVencimientosCC dtoVencimientosCC): Entrada");
    }


    private void generarBloqueProductosDirectos(SerializadorDetalleFacturaColombia sf2, ArrayList arrayProductosDirectos, Parseador miParseador) {
       UtilidadesLog.info("DetalleFacturaColombia.generarBloqueProductosDirectos(SerializadorDetalleFacturaColombia sf2, ArrayList arrayProductosDirectos, Parseador miParseador): Entrada");       
       String mensa = "<txtcrs><datoVariable01></txtcrs><valcrs><datoVariable02></valcrs>";
       int arraySize = arrayProductosDirectos.size();
       for (int i = 0; i < arraySize; i++) {
          DTOImpresion miDTO = (DTOImpresion)arrayProductosDirectos.get(i);
          sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));        
       }
       UtilidadesLog.info("DetalleFacturaColombia.generarBloqueProductosDirectos(SerializadorDetalleFacturaColombia sf2, ArrayList arrayProductosDirectos, Parseador miParseador): Salida");
    }
    
    private void recuperarDatosPaginas(DTOFACDocumentoContable docuContable) throws MareException {                
       DTOFACDocumentoContableCabecera miCabecera = docuContable.getCabecera();
       DAODocuContable daoActivo= new DAODocuContable();
       
       Date fechaVencimientoDate = (Date)daoActivo.obtenerFechaVencimiento(miCabecera.getOidCabeceraSolicitud());

       if (fechaVencimientoDate == null) {
         fechaVencimientoDate = (Date)daoActivo.obtenerFechaFacturacionCampañaSiguiente(miCabecera.getOidPeriodo(), miCabecera.getOidZona());          
       }

       String auxFecha = null;       
       try {
         auxFecha = UtilidadesFecha.convertirAString(fechaVencimientoDate);   
         String[] splitFechas = new String[3];
         StringTokenizer st = new StringTokenizer(auxFecha, "-");
         for(int cont = 0; cont<3; cont++) {
            splitFechas[cont] = st.nextToken();
         }
         this.fechaVencimiento = splitFechas[2] + '/' + splitFechas[1] + '/' + splitFechas[0];  // Las fechas van en formato dd/MM/yyyy
         this.indFechaVencimiento = true;
       } catch(Exception e){
         UtilidadesLog.error("DetalleFacturaColombia de número consolidado = " + miCabecera.getOidCabeceraSolicitud() + " no puede seleccionar fecha límite pago");
         UtilidadesLog.error("Error DetalleFacturaColombia", e);
       }
    }
    
    private void generarLineaTotalCatalogo (SerializadorDetalleFacturaColombia sf2, Parseador miParseador, DTOSubtotalesDetalleFactura dtoSubTotales, String descCatalogo, Integer numeroDecimales) {
       String mensa = "<blqtct>";
       sf2.addMensaje(mensa);
       
       DTOImpresion miDTO = new DTOImpresion();                            
       miDTO.setDatoVariable1("");
       miDTO.setDatoVariable2(validarToString("TOTAL " + descCatalogo.toString()));
       miDTO.setDatoVariable3("");
       miDTO.setDatoVariable4(validarToString(dtoSubTotales.getSubtotalUnidadesSolicitadas().toString()));
       miDTO.setDatoVariable5(validarToString(dtoSubTotales.getSubtotalUnidadesAtendidas().toString()));
       miDTO.setDatoVariable6(validarToString(dtoSubTotales.getSubtotalUnidadesFaltantes().toString()));
       miDTO.setDatoVariable7(validarToString(formatearDecimales(new BigDecimal(dtoSubTotales.getSubtotalPrecioTotal().floatValue()).setScale(numeroDecimales.intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                                                                                                  
       miDTO.setDatoVariable8("");
       miDTO.setDatoVariable9(validarToString(formatearDecimales(new BigDecimal(dtoSubTotales.getSubtotalDescuentos().floatValue()).setScale(numeroDecimales.intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                                                                                                  
       miDTO.setDatoVariable10(validarToString(formatearDecimales(new BigDecimal(dtoSubTotales.getSubtotalTotalconDescuentos().floatValue()).setScale(numeroDecimales.intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                                                                                                  
       miDTO.setDatoVariable11("");
       sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensaDetalles, miDTO));  
       
       mensa = "</blqtct>";
       sf2.addMensaje(mensa);
    }

    private DTOSubtotalesDetalleFactura generarLineaDetalle (SerializadorDetalleFacturaColombia sf2, Parseador miParseador, DTOSubtotalesDetalleFactura dtoSubTotales, DTOFACDocumentoContableDetalle dtoDetalle, Integer numeroDecimales) {
      DTOImpresion miDTO = new DTOImpresion(); 
      if (dtoDetalle.getCodigoVenta() != null) {
        miDTO.setDatoVariable1(validarToString(dtoDetalle.getCodigoVenta().toString()));
      } else {
        miDTO.setDatoVariable1(validarToString(dtoDetalle.getCodigoVentaFicticio().toString()));
      }          
      miDTO.setDatoVariable2(validarToString(dtoDetalle.getDescripcionProd().toString()));          
      miDTO.setDatoVariable4(validarToString(dtoDetalle.getUnidadesSolicitadas().toString()));
      dtoSubTotales.setSubtotalUnidadesSolicitadas(new Long(dtoSubTotales.getSubtotalUnidadesSolicitadas().longValue() + dtoDetalle.getUnidadesSolicitadas().longValue()));
      miDTO.setDatoVariable5(validarToString(dtoDetalle.getUnidadesAtendidas().toString()));
      dtoSubTotales.setSubtotalUnidadesAtendidas(new Long(dtoSubTotales.getSubtotalUnidadesAtendidas().longValue() + dtoDetalle.getUnidadesAtendidas().longValue()));
      Long unidadesFaltantes = new Long(dtoDetalle.getUnidadesSolicitadas().longValue() - dtoDetalle.getUnidadesAtendidas().longValue());
      miDTO.setDatoVariable6(validarToString(unidadesFaltantes));
      dtoSubTotales.setSubtotalUnidadesFaltantes(new Long(dtoSubTotales.getSubtotalUnidadesFaltantes().longValue() + unidadesFaltantes.longValue()));
      if (dtoDetalle.getCodAgrupCatalogo().substring(0, 1).equals("0")){
        miDTO.setDatoVariable3(validarToString(formatearDecimales(new BigDecimal(dtoDetalle.getPrecioCatalUnitLocal().floatValue()).setScale(numeroDecimales.intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                                                                                                            
        miDTO.setDatoVariable7(validarToString(formatearDecimales(new BigDecimal(dtoDetalle.getPrecioCatalTotLocal().floatValue()).setScale(numeroDecimales.intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                                                                                                            
        dtoSubTotales.setSubtotalPrecioTotal(new Float(dtoSubTotales.getSubtotalPrecioTotal().floatValue() + dtoDetalle.getPrecioCatalTotLocal().floatValue()));
      } else {
        miDTO.setDatoVariable3(validarToString(formatearDecimales(new BigDecimal(dtoDetalle.getPrecioContUnitLocal().floatValue()).setScale(numeroDecimales.intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                                                                                                            
        miDTO.setDatoVariable7(validarToString(formatearDecimales(new BigDecimal(dtoDetalle.getPrecioContTotLocal().floatValue()).setScale(numeroDecimales.intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                                                                                                                            
        dtoSubTotales.setSubtotalPrecioTotal(new Float(dtoSubTotales.getSubtotalPrecioTotal().floatValue() + dtoDetalle.getPrecioContTotLocal().floatValue()));
      }        
      if (dtoDetalle.getPorcentajeDescuento() != null) {
        miDTO.setDatoVariable8(validarToString(dtoDetalle.getPorcentajeDescuento().toString()));
      } else {
        miDTO.setDatoVariable8("");          
      }
      miDTO.setDatoVariable9(validarToString(formatearDecimales(new BigDecimal(dtoDetalle.getImporteDescTotaLocal().floatValue()).setScale(numeroDecimales.intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                                                                                                                                  
      dtoSubTotales.setSubtotalDescuentos(new Float(dtoSubTotales.getSubtotalDescuentos().floatValue() + dtoDetalle.getImporteDescTotaLocal().floatValue()));
      miDTO.setDatoVariable10(validarToString(formatearDecimales(new BigDecimal(dtoDetalle.getPrecioFactTotalLocal().floatValue()).setScale(numeroDecimales.intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                                                                                                                                  
      dtoSubTotales.setSubtotalTotalconDescuentos(new Float(dtoSubTotales.getSubtotalTotalconDescuentos().floatValue() + dtoDetalle.getPrecioFactTotalLocal().floatValue()));
      if (dtoDetalle.getOidFormaPago() == null) {
        miDTO.setDatoVariable11("");          
      } else {
        miDTO.setDatoVariable11("X");          
      }
      sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensaDetalles, miDTO));   
      return dtoSubTotales;
    }    
    
    private void generarLineaCabeceraCatalogo (SerializadorDetalleFacturaColombia sf2, Parseador miParseador, String descCatalogo) {
        String mensa = "<blqcat>";
        sf2.addMensaje(mensa);                  

        mensa = "<txt><datoVariable01></txt>"; 
        DTOImpresion miDTO = new DTOImpresion();               
        miDTO.setDatoVariable1(descCatalogo.toString());
        sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));           

        mensa = "</blqcat>";
        sf2.addMensaje(mensa);  
    }
    
    private void generarCierrePaginaActual (SerializadorDetalleFacturaColombia sf2, Parseador miParseador, int numeroPaginaActual) {
        String mensa = "</detalle>";
        sf2.addMensaje(mensa); 

        if (numeroPaginaActual == 1) {
            mensa = "</blqpag41>";                                    
        } else {
            mensa = "</blqpag50>";               
        }
        sf2.addMensaje(mensa); 
    }
    
    private void generarNuevaPagina (SerializadorDetalleFacturaColombia sf2, Parseador miParseador, int numeroPaginaActual, DTOFACDocumentoContableCabecera miCabecera) {
        String mensa;
        if (numeroPaginaActual == 1) {
            mensa = "<blqpag41>";             
        } else {
            mensa = "<blqpag50>";             
        }
        sf2.addMensaje(mensa);
        
        if (numeroPaginaActual == 1) {
            this.generarPrimerCabeceraFactura(sf2, miCabecera, miParseador, numeroPaginaActual);             
        } else {
            this.generarCabeceraSiguientesPaginas(sf2, miParseador, numeroPaginaActual);            
        }
        
        mensa = "<detalle>";
        sf2.addMensaje(mensa);          
    }
    
    private void generarCabeceraSiguientesPaginas (SerializadorDetalleFacturaColombia sf2, Parseador miParseador, int numeroPaginaActual) {
       String mensa = "<blqcab>";
       sf2.addMensaje(mensa);

       DTOImpresion miDTO = new DTOImpresion();
       miDTO.setDatoVariable1(validarToString(new Integer(numeroPaginaActual)));
       mensa = "<pagina>Pag. <datoVariable01>/ </pagina>";
       sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
       
       mensa = "</blqcab>";
       sf2.addMensaje(mensa);   
    }
   
    private void generarCierreDetalleProductos (SerializadorDetalleFacturaColombia sf2) {
       String mensa = "</blqprd>";
       sf2.addMensaje(mensa);
    }
    
    private void generarAperturaDetalleProductos (SerializadorDetalleFacturaColombia sf2) {
       String mensa = "<blqprd>";
       sf2.addMensaje(mensa);
    }

    private ArrayList calcularCantidadProductosDirectos (ArrayList arrayDetalles, Integer numeroDecimales) {
       ArrayList arrayProductosDirectos = new ArrayList();
       int arraySize = arrayDetalles.size();
       for (int i = 0; i < arraySize; i++) {
          DTOFACDocumentoContableDetalle dtoDetalle = (DTOFACDocumentoContableDetalle)arrayDetalles.get(i);
          if (dtoDetalle.getCodigoVenta() == null && dtoDetalle.getCodigoVentaFicticio() == null) {
            if (dtoDetalle.getPrecioFactTotalLocal() != null && dtoDetalle.getPrecioFactTotalLocal().floatValue() != 0) {
                DTOImpresion miDTO = new DTOImpresion();
                if (dtoDetalle.getPrecioFactTotalLocal().floatValue() > 0) {    
                    miDTO.setDatoVariable1(validarToString("(+) " + dtoDetalle.getDescripcionProd().toString()));         
                    miDTO.setDatoVariable2(validarToString(formatearDecimales(new BigDecimal(dtoDetalle.getPrecioFactTotalLocal().floatValue()).setScale(numeroDecimales.intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                                                                                                                                                                          
                } else {
                    miDTO.setDatoVariable1(validarToString("(-) " + dtoDetalle.getDescripcionProd().toString()));
                    miDTO.setDatoVariable2(validarToString(formatearDecimales(new BigDecimal(dtoDetalle.getPrecioFactTotalLocal().floatValue() * (-1)).setScale(numeroDecimales.intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                                                                                                                                                          
                }
                this.totalProductosDirectos = new Float(totalProductosDirectos.floatValue() + dtoDetalle.getPrecioCatalTotLocal().floatValue());
                arrayProductosDirectos.add(miDTO); 
                arrayDetalles.remove(i);
                i--;
                arraySize = arrayDetalles.size();
            }
          }    
       }
       return arrayProductosDirectos;
    } 
    
    
    private void generarCabeceraBloqueVencimientos (SerializadorDetalleFacturaColombia sf2, DTOFACDocumentoContableCabecera miCabecera, Parseador miParseador) throws MareException { 
        UtilidadesLog.info("DetalleFacturaColombia.generarCabeceraBloqueVencimientos(SerializadorDetalleFacturaColombia sf2,  DTOFACDocumentoContableCabecera miCabecera, Parseador miParseador): Entrada");        
        sf2.addMensaje("<blqvec>"); 
 
        DTOImpresion miDTO = new DTOImpresion();
        miDTO.setDatoVariable1(validarToString(validarToString(miCabecera.getCodPeriodo().substring(4, 6).toString() + "-" + miCabecera.getCodPeriodo().substring(0, 4).toString())));
        String mensa = "<txt>** ESTADO DE LA CUENTA CORRIENTE EN LA CAMPAÑA<t/><datoVariable01><t/>**</txt>";
        sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

        sf2.addMensaje("</blqvec>"); 
        UtilidadesLog.info("DetalleFacturaColombia.generarCabeceraBloqueVencimientos(SerializadorDetalleFacturaColombia sf2,  DTOFACDocumentoContableCabecera miCabecera, Parseador miParseador): Salida");        
    }    
    
    private void generarAperturaBloqueDetalleVencimientos (SerializadorDetalleFacturaColombia sf2) {
       String mensa = "<blqved>";
       sf2.addMensaje(mensa);
    }

    private void generarCierreBloqueDetalleVencimientos (SerializadorDetalleFacturaColombia sf2) {
       String mensa = "</blqved>";
       sf2.addMensaje(mensa);
    }
    
    private void generarTotalBloqueVencimientos (SerializadorDetalleFacturaColombia sf2, Parseador miParseador, Float totalImportes, Integer numeroDecimales) throws MareException { 
        UtilidadesLog.info("DetalleFacturaColombia.generarTotalBloqueVencimientos (SerializadorDetalleFacturaColombia sf2, Parseador miParseador, Float totalImportes, Integer numeroDecimales): Entrada");        
        DTOImpresion miDTO = new DTOImpresion();
        
        miDTO.setDatoVariable1(validarToString(formatearDecimales(new BigDecimal(totalImportes.floatValue()).setScale(numeroDecimales.intValue(), BigDecimal.ROUND_HALF_EVEN).toString())));                                                                                                                                                                                          
        String mensa = "<txt>><t/><t/>Total valor a pagar ---><t/><t/><datoVariable01><t/></txt>";
        sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));        
        UtilidadesLog.info("DetalleFacturaColombia.generarTotalBloqueVencimientos (SerializadorDetalleFacturaColombia sf2, Parseador miParseador, Float totalImportes, Integer numeroDecimales): Salida");        
    }    

    private void generarCabeceraDetallesVencimientos (SerializadorDetalleFacturaColombia sf2, Parseador miParseador) {
        String mensaVencDet = "<txt><datoVariable01><t/><datoVariable02><t/><datoVariable03><t/><datoVariable04><t/><datoVariable05></txt>";

        DTOImpresion miDTO = new DTOImpresion();
        miDTO.setDatoVariable1(validarToString("CMP-ORIGEN"));
        miDTO.setDatoVariable2(validarToString("DOCUMENTO"));
        miDTO.setDatoVariable3(validarToString("NRO-CUOTA"));
        miDTO.setDatoVariable4(validarToString("VENCIMIENTO"));
        miDTO.setDatoVariable5(validarToString("SALDO"));
        sf2.addMensaje(miParseador.sustituirEtiquetasVariables(mensaVencDet, miDTO)); 
        
        sf2.addMensaje("<txt>Su cupon de pago esta compuesto por:</txt>"); 
        
    }
}