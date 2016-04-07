package es.indra.sicc.logicanegocio.fac.generaciondocumentos;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FacturaEcuador1 extends DocumentoFAC  {
    private byte[] documento;
    private UtilidadesLog log = new UtilidadesLog();
    
    public FacturaEcuador1() {
    }
    
    public void componerFactura(DTODocLegal datosDocLegal) {
      UtilidadesLog.info("FacturaEcuador1.componerFactura(DTODocLegal datosDocLegal): Entrada"); 
      
      ArrayList listaPaginas = datosDocLegal.getlistaPaginas();
      SerializadorTextFacturaEcuador1 sf1 = new SerializadorTextFacturaEcuador1();
      int totalPaginas = listaPaginas.size();      
      
      for(int i=0;i < totalPaginas;i++) {
        DTOFACDocumentoContable docuContable = (DTOFACDocumentoContable)listaPaginas.get(i);
        DTOFACDocumentoContableCabecera miCabecera = docuContable.getCabecera();
      
        this.generarSeccion0(sf1, miCabecera, totalPaginas, i, datosDocLegal.getIndOnline());        
        this.generarSeccion1(sf1, miCabecera, docuContable);        
        this.generarSeccion2(sf1, miCabecera, docuContable);
        sf1.insertarCaracterFinDePagina();
      }
      
      try {
        sf1.componerDocumento();
		sf1.saveDocument("c:\\", "FacturaEcuador1.txt");
		this.documento = sf1.bufferOut;
	  }	catch (Exception e) {
	    UtilidadesLog.error("ERROR",e);
	  }
          if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
            UtilidadesLog.debug("FacturaEcuador1: " + sf1.toString());
          
      UtilidadesLog.info("FacturaEcuador1.componerFactura(DTODocLegal datosDocLegal): Salida"); 
  }

    public byte[] getDocument(){
        return this.documento;
    }
  
  
    public String calcularCodigoCompletoVenta(String codPeriodoEntrada, String codVenta, Float precioCatalogoUnitLocalEntrada){
     UtilidadesLog.info("FacturaEcuador1.calcularCodigoCompletoVenta(String codPeriodoEntrada, String codVenta, Float precioCatalogoUnitLocalEntrada): Entrada"); 
     
     String salida="";
     if(codPeriodoEntrada.length()>2){
        salida = codPeriodoEntrada.substring(codPeriodoEntrada.length()-2 ,codPeriodoEntrada.length());
     } else {
        salida = codPeriodoEntrada;  
     }
     
     if(codVenta.length()>5){
       salida += codVenta.substring(0,5);
     } else {
       salida += codVenta;
     }

    if(precioCatalogoUnitLocalEntrada!=null && (precioCatalogoUnitLocalEntrada.floatValue()!=0)) {
        salida += "8";
    } else {
        salida += "0";
    }

     UtilidadesLog.info("FacturaEcuador1.calcularCodigoCompletoVenta(String codPeriodoEntrada, String codVenta, Float precioCatalogoUnitLocalEntrada): Salida"); 
     return salida;
    }
    
     protected String validarToString(Object objetoEntrada) {
      String salida=" ";
      if(objetoEntrada!=null) {
        salida=objetoEntrada.toString();
      }
      return salida;  
    }
  
    
    public static void main(String[] arg) {
    	FacturaEcuador1 fac = new FacturaEcuador1();
    }

    private Float calcularPercepcion(Float totalAPagarLocal, Float percepcion) {
        return new Float(totalAPagarLocal.floatValue() * percepcion.floatValue() / 100);
    }

    private void generarSeccion2(SerializadorTextFacturaEcuador1 sf1, DTOFACDocumentoContableCabecera miCabecera, DTOFACDocumentoContable dtoDoc) {       
      this.generarTotalesColumnas(sf1, miCabecera);  
      this.generarTotales(sf1, miCabecera, dtoDoc);
    }


    private void generarTotalesColumnas(SerializadorTextFacturaEcuador1 sf1, DTOFACDocumentoContableCabecera miCabecera) {  
      ArrayList datos = new ArrayList();       
            
      datos.add(0, miCabecera.getNumUnidadesAtendidas().toString());
      
      float totalVentaCata = (float)this.calcularTotalVentaCata(miCabecera);      
      datos.add(1, validarSignosImportes(new BigDecimal(totalVentaCata).toString()));  

      sf1.addMensaje(20, datos);		
      datos.clear();
        
      float totalDescuento = (float)miCabecera.getImporteDescuentoTotaLocal().floatValue();    
      datos.add(0, validarSignosImportes(new BigDecimal(totalDescuento).toString()));
    
      sf1.addMensaje(21, datos);		
      datos.clear();
    }
    
    
    private float calcularTotalVentaCata(DTOFACDocumentoContableCabecera miCabecera) {
      float totaVentaCata=0;
      if (miCabecera.getTotalAPagarLocal() == null) miCabecera.setTotalAPagarLocal(new Float(0));
      if (miCabecera.getImporteFleteTotalLocal() == null) miCabecera.setImporteFleteTotalLocal(new Float(0));
      if (miCabecera.getImporteDescuentoTotaLocal() == null) miCabecera.setImporteDescuentoTotaLocal(new Float(0));
      
      totaVentaCata = miCabecera.getTotalAPagarLocal().floatValue() - miCabecera.getImporteFleteTotalLocal().floatValue() 
                      + miCabecera.getImporteDescuentoTotaLocal().floatValue();
                        
      return totaVentaCata;
    }

    /**
     * CHANGELOG
     * ---------
     * dmorello, 09/06/2009 - Cambio 20090922
     *    - Se agrega parametro DTOFACDocumentoContable
     *    - Se agrega llamada a calcularImpuestoProductoNacional
     *    - Se reordenan los datos para el serializador
     */
    private void generarTotales(SerializadorTextFacturaEcuador1 sf1, DTOFACDocumentoContableCabecera miCabecera, DTOFACDocumentoContable dtoDoc) {  
      ArrayList datos = new ArrayList();
      datos.add(0, validarSignosImportes(this.calcularImpuestoProductoNacional(dtoDoc.getDetalle()).toString()));
      datos.add(1, validarSignosImportes(this.calcularBaseImponibleIVA(miCabecera).toString()));
      datos.add(2, miCabecera.getTasaImpuesto().intValue() + "%");   
      datos.add(3, validarSignosImportes(miCabecera.getImporteImpuestosTotalLocal().toString())); 
      datos.add(4, miCabecera.getTasaImpuestoFlete().intValue() + "%");
      datos.add(5, validarSignosImportes(miCabecera.getImporteFleteTotalLocal().toString())); 
      datos.add(6, validarSignosImportes(miCabecera.getTotalAPagarLocal().toString())); 
      
      String[] arraySon = (String[])this.generarTotalLetras(miCabecera);
    
      datos.add(7, arraySon[0]);
      datos.add(8, arraySon[1]);
      datos.add(9, arraySon[2]);
      sf1.addMensaje(22, datos);		
    } 
    
    private BigDecimal calcularBaseImponibleIVA(DTOFACDocumentoContableCabecera miCabecera) {      
      if (miCabecera.getImporteFleteTotalLocal() == null) miCabecera.setImporteFleteTotalLocal(new Float(0));
      if (miCabecera.getImporteImpuestosTotalLocal() == null) miCabecera.setImporteImpuestosTotalLocal(new Float(0));
      
      return new BigDecimal(miCabecera.getTotalAPagarLocal().floatValue() - miCabecera.getImporteImpuestosTotalLocal().floatValue()
            - miCabecera.getImporteFleteTotalLocal().floatValue()).setScale(2,BigDecimal.ROUND_HALF_EVEN);  
    }
    
    private String[] generarTotalLetras(DTOFACDocumentoContableCabecera miCabecera) {
      String res="CERO";
      if (miCabecera.getTotalAPagarLocal() != null) {
        Numtotext numero = new Numtotext(1);
        res = numero.procesar(miCabecera.getTotalAPagarLocal());
      }
      String monedaAux=" ";
      if (miCabecera.getMoneda() != null) {
        monedaAux=miCabecera.getMoneda();
      }
    
      String son = res + ' ' + monedaAux;

      String[] arraySon = new String[3];
      if (son.length() <= 40) {
        arraySon[0] = son;
        arraySon[1] = " ";
        arraySon[2] = " ";
      } else {
        arraySon[0] = son.substring(0,40);
        son = son.substring(40);
        if (son.length() <= 45) {
          arraySon[1] = son;
          arraySon[2] = " ";
        } else {
          arraySon[1] = son.substring(0,45);
          son = son.substring(45);
          if (son.length() <= 41) {
            arraySon[2] = son;
          } else {
            arraySon[2] = son.substring(0,41);
          }
        }
      }
      return arraySon;    
    }
    
    private void generarSeccion1(SerializadorTextFacturaEcuador1 sf1, DTOFACDocumentoContableCabecera miCabecera, DTOFACDocumentoContable docuContable) {
      this.generarDetalles(sf1, miCabecera, docuContable);      
    }
    
    private void generarDetalles(SerializadorTextFacturaEcuador1 sf1, DTOFACDocumentoContableCabecera miCabecera, DTOFACDocumentoContable docuContable) {
      ArrayList misDetalles = docuContable.getDetalle();
      ArrayList listaFueraCaja = new ArrayList();
      
      for (int x=0;x<misDetalles.size();x++) {
        DTOFACDocumentoContableDetalle miDetalle = (DTOFACDocumentoContableDetalle)misDetalles.get(x);
        UtilidadesLog.debug("El indicador dentro caja fuera bolsa es: " + miDetalle.getIndicadorDentroFueraCajaBolsa());
        if (!miDetalle.getNoImprimible()) { 
          if ("C".equals(miDetalle.getIndicadorDentroFueraCajaBolsa())) {
            UtilidadesLog.debug("Entra en dentro caja");
            ArrayList datos = (ArrayList)this.armarLineaDetalle(miDetalle);
            sf1.addMensaje(9,datos);
          } else {
            listaFueraCaja.add(miDetalle);
          }
        }   //fin if dentro caja          
      }//fin for
      
      sf1.addMensaje(8, new ArrayList());
      UtilidadesLog.debug("SF1 es: " + sf1);
          
      for (int x=0;x<listaFueraCaja.size();x++) {
        DTOFACDocumentoContableDetalle miDetalle=(DTOFACDocumentoContableDetalle)listaFueraCaja.get(x);
        ArrayList datos = (ArrayList)this.armarLineaDetalle(miDetalle);
        sf1.addMensaje(9,datos);
        datos.clear();
      }
  }
   
   
   private ArrayList armarLineaDetalle(DTOFACDocumentoContableDetalle miDetalle) { 
     ArrayList datos = new ArrayList();
     String codigoCompleto = "";     
     datos.add(0, validarSignosImportesUA(miDetalle.getUnidadesAtendidas().toString()));
     datos.add(1, validarToString(miDetalle.getDescripcionProd()));
        
     if (miDetalle.getPrecioCatalUnitLocal() == null) {
        miDetalle.setPrecioCatalUnitLocal(new Float(0));
     }
     if (miDetalle.getPrecioContUnitLocal() == null) {
        miDetalle.setPrecioContUnitLocal(new Float(0));
     }
     datos.add(2, validarSignosImportes(new BigDecimal(miDetalle.getPrecioCatalUnitLocal().floatValue() + miDetalle.getPrecioContUnitLocal().floatValue()).toString()));
     datos.add(3, validarSignosImportes(new BigDecimal((miDetalle.getPrecioCatalUnitLocal().floatValue() + miDetalle.getPrecioContUnitLocal().floatValue()) * miDetalle.getUnidadesAtendidas().floatValue()).toString()));
     return datos;
   }
   
   private void generarSeccion0(SerializadorTextFacturaEcuador1 sf1, DTOFACDocumentoContableCabecera miCabecera, int totalPaginas, int numPagina, Boolean indOnLine) { 
     ArrayList datos = new ArrayList();
     datos.add(0, Integer.toString(numPagina + 1));
     datos.add(1, Integer.toString(totalPaginas));
     sf1.addMensaje(0, datos);
     datos.clear();

     String[] splitFechas = (String[])this.generarFecha(miCabecera);     
     datos.add(0, splitFechas[2]);
     datos.add(1, splitFechas[1]);
     datos.add(2, splitFechas[0].substring(2, 4));
     sf1.addMensaje(1, datos);
     datos.clear();

     datos.add(0, validarToString(miCabecera.getNumConsolidado()));
     if (indOnLine != null && indOnLine.booleanValue()) {
       datos.add(1, validarToString(miCabecera.getNumDocContableInterno()));
     } else {
       datos.add(1, "$$$$$$$$$$$$$");
     }     
     sf1.addMensaje(2, datos);
     datos.clear();

     if (miCabecera.getTotalAPagarLocal() != null && miCabecera.getTotalAPagarLocal().floatValue() < 0 && miCabecera.getNumDocReferencia() != null ) {
        datos.add(0, "Bol Despacho Ref : " + miCabecera.getNumDocReferencia() + " CMP Ref.: " + miCabecera.getCodPeriodoRefe());
     } else {        
        datos.add(0, "");
     }     
     sf1.addMensaje(3, datos);
     datos.clear();     

     datos.add(0, "\n");
     sf1.addMensaje(11, datos);
     datos.clear();
     
  
     datos.add(0, validarToString(miCabecera.getCodCliente()));
     datos.add(1, validarToString(miCabecera.getCodZona())+"-"+ validarToString(miCabecera.getCodTerritorio()));
     datos.add(2, this.generarIdentificacionFiscal(miCabecera));
     sf1.addMensaje(6, datos);
     datos.clear();

     datos.add(0, this.generarApellidoNombre(miCabecera));
     datos.add(1, validarToString(miCabecera.getCodPeriodo()));
     sf1.addMensaje(5, datos);
     datos.clear();
	
     datos.add(0, this.generarDireccion(miCabecera));
     sf1.addMensaje(7, datos);         
     datos.clear();
     sf1.addMensaje(10, datos);         
     datos.clear();
     
     if (numPagina != 0) {
        datos.add(0, "\n");
        sf1.addMensaje(11, datos);
        datos.clear();
     } 
      
     sf1.addSeccion(0);
   }
   
   private String generarApellidoNombre(DTOFACDocumentoContableCabecera miCabecera) {
     String nyap = "";
     nyap = miCabecera.getApellido1()+" "+ validarToString(miCabecera.getApellido2())+" ,"+ validarToString(miCabecera.getNombre1())+" "+ validarToString(miCabecera.getNombre2());
     if (nyap.length()>=40) {
         nyap = nyap.substring(0,40);
     }
     return nyap;
   }
   
   private String generarDireccion(DTOFACDocumentoContableCabecera miCabecera) {
     String dir = "";
     dir = miCabecera.getNombreVia();
     if (dir.length()>=60) {
         dir = dir.substring(0,60);
     }
     return dir;
   }   

   private String generarIdentificacionFiscal(DTOFACDocumentoContableCabecera miCabecera) {
     String ruc = "";
     ruc = miCabecera.getNumIdentificacionFiscal();
     if (ruc.length() > 15) {
         ruc = ruc.substring(0, 15);
     }
     return ruc;
   }   

   
   private String[] generarFecha(DTOFACDocumentoContableCabecera miCabecera) {
     String auxFecha = null;     
     String[] splitFechas = new String[3];
     try {
       auxFecha = UtilidadesFecha.convertirAString(miCabecera.getFechaFacturacion());
       StringTokenizer st = new StringTokenizer(auxFecha, "-");
       for(int cont = 0; cont<3; cont++) {
         splitFechas[cont] = st.nextToken();
       }
     } catch(Exception e) {}
     return splitFechas;
   }

   private String validarSignosImportes(String entrada) {
    String salida = "";
    float aux = new BigDecimal(entrada).floatValue();
    if ( aux < 0 ) {
        salida = "(" + new BigDecimal(aux * (-1)).setScale(2,BigDecimal.ROUND_HALF_EVEN).toString() + ")"; 
    } else {
        salida = new BigDecimal(aux).setScale(2,BigDecimal.ROUND_HALF_EVEN).toString();
    }
    return salida;
  }
  
  private String validarSignosImportesUA(String entrada) {
    String salida = "";
    int aux = new BigDecimal(entrada).intValue();
    if ( aux < 0 ) {
        salida += "(" + (aux * (-1)) + ")"; 
    } else {
        salida = entrada;
    }
    return salida;
  }
  
  /**
   * Creado por Cambio 2009092
   * Calcula la suma de "impuesto producto nacional" para todos los detalles del documento
   * @author dmorello
   * @since 09-jun-2009
   */
  private BigDecimal calcularImpuestoProductoNacional(ArrayList listaDetalles) {
      BigDecimal sumaImpuesto = new BigDecimal("0");
      BigDecimal impuesto = null;
      for (int i = 0; i < listaDetalles.size(); i++) {
          DTOFACDocumentoContableDetalle detalle;
          detalle = (DTOFACDocumentoContableDetalle)listaDetalles.get(i);
          impuesto = detalle.getImporteImpuestoProductoNacional();
          if (impuesto != null) {
            sumaImpuesto = sumaImpuesto.add(impuesto);
          }
      }
      return sumaImpuesto;
  }

   
}