package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FacturaPeru1 extends DocumentoFAC 
{
	private byte[] documento;
	// Comunes
	 private UtilidadesLog log = new UtilidadesLog();

    public FacturaPeru1()
    {
    }
    
    // Modificado por la BELC300011949, BELC300015920
     public void componerFactura(DTODocLegal datosDocLegal){
      UtilidadesLog.info("FacturaPeru1.componerFactura(DTODocLegal datosDocLegal): Entrada"); 
      ArrayList listaPaginas=datosDocLegal.getlistaPaginas();
      SerializadorTextFacturaPeru1 sf1 = new SerializadorTextFacturaPeru1();
      
      
//PARTE 3
      for(int i=0;i<listaPaginas.size();i++){

      ArrayList datos = new ArrayList(); // Contiene objetos de tipo "dato"
      
      
      DTOFACDocumentoContable docuContable=(DTOFACDocumentoContable)listaPaginas.get(i);
       
      DTOFACDocumentoContableCabecera miCabecera = docuContable.getCabecera();

      datos.add(0,Integer.toString(i+1));
      datos.add(1,Integer.toString(listaPaginas.size()));
      sf1.addMensaje(0, datos);
      datos.clear();
		
      datos.add(0,validarToString(miCabecera.getCodPeriodo()));
    
      String auxFecha = null;
      String stringFecha = "";
      try {
          // yyyy-MM-dd
          auxFecha = UtilidadesFecha.convertirAString(miCabecera.getFechaFacturacion());
          String[] splitFechas = new String[3];
          StringTokenizer st = new StringTokenizer(auxFecha, "-");
          for(int cont = 0; cont<3; cont++) {
              splitFechas[cont] = st.nextToken();
          }
          /* dmorello, 30/08/2006: La fecha va en formato dd/MM/yyyy */
          //stringFecha = splitFechas[2]+"/"+splitFechas[1]+"/"+splitFechas[0].substring(splitFechas[0].length()-2, splitFechas[0].length());
          stringFecha = splitFechas[2] + '/' + splitFechas[1] + '/' +splitFechas[0];
      } catch(Exception e){
      }
      datos.add(1,stringFecha);
      sf1.addMensaje(2, datos);
      datos.clear();

      datos.add(0, validarToString(miCabecera.getCodZona())+"-"+ validarToString(miCabecera.getCodTerritorio()));
      datos.add(1,miCabecera.getCodCliente());
      sf1.addMensaje(3,datos);
      datos.clear();
  
      datos.add(0,miCabecera.getApellido1()+" "+ validarToString(miCabecera.getApellido2())+" ,"+
                  validarToString(miCabecera.getNombre1())+" "+ validarToString(miCabecera.getNombre2()));
      sf1.addMensaje(5, datos);
      datos.clear();
      datos.add(0,validarToString(miCabecera.getNumIdentificacionFiscal()));
      sf1.addMensaje(4, datos);
      datos.clear();
				
      String direccion="";
      
      if (miCabecera.getNombreVia()!=null){
         direccion = miCabecera.getNombreVia();
      }
      String[] split = this.dividirCadena(direccion, 47);
      
      datos.add(0,split[0]);
      if (split.length>1){
          datos.add(1,split[1]);
      }else{
          datos.add(1," ");
      }
      if (split.length>2){
          datos.add(2,split[2]);
      }else{
          datos.add(2," ");
      }
      if (split.length>3){
          datos.add(3,split[3]);
      }else{
          datos.add(3," ");
      }      
      sf1.addMensaje(6, datos);
      datos.clear();
      
      split = this.dividirCadena(validarToString(miCabecera.getDescripcionUbigeo()), 47);
      
      datos.add(0,split[0]);
      if (split.length>1){
          datos.add(1,split[1]);
      }else{
          datos.add(1," ");
      }
      if (split.length > 2) {
          datos.add(2,split[2]);
      } else {
          datos.add(2, " ");
      }
      
      if (datosDocLegal.getIndOnline() != null && datosDocLegal.getIndOnline().booleanValue()) {
          datos.add(3, validarToString(miCabecera.getNumDocContableInterno()));
      } else {
          datos.add(3, "$$$$$$$$$$$$$");
      }

      if (split.length > 3) {
          datos.add(4, split[3]);
      } else {
          datos.add(4, " ");
      }
      
      datos.add(5, validarToString(miCabecera.getNumConsolidado()));
      sf1.addMensaje(8, datos);
      datos.clear();
      sf1.addMensaje(7, datos);
      datos.clear();
      
      sf1.addSeccion(0);
		
      //PARTE 3.1        
      ArrayList misDetalles= docuContable.getDetalle();
    
      ArrayList listaFueraCaja= new ArrayList();
      String codigoCompleto="";
      for(int x=0;x<misDetalles.size();x++){
          DTOFACDocumentoContableDetalle miDetalle=(DTOFACDocumentoContableDetalle)misDetalles.get(x);
          UtilidadesLog.debug("El indicador dentro caja fuera bolsa es: "+miDetalle.getIndicadorDentroFueraCajaBolsa());
          if(!miDetalle.getNoImprimible()){ 
              if("C".equals(miDetalle.getIndicadorDentroFueraCajaBolsa())) {
                UtilidadesLog.debug("Entra en dentro caja");
                datos.add(0,validarToString(miDetalle.getUnidadesAtendidas()));
                datos.add(1,validarToString(miDetalle.getDescripcionProd()));
                //  Modificado por HRCS - Fecha 06/06/2007 - Cambio Sicc20070274
                if(miDetalle.getCodigoVenta()!=null) {
                    codigoCompleto= calcularCodigoCompletoVenta(miDetalle.getCodPeriodo(),miDetalle.getCodigoVenta(),miDetalle.getPrecioCatalUnitLocal());                                                                    
                } else {
                    codigoCompleto= calcularCodigoCompletoVenta(miDetalle.getCodPeriodo(),miDetalle.getCodigoProducto(),miDetalle.getPrecioCatalUnitLocal());                                                                         
                }
        
                datos.add(2,codigoCompleto);
        
                if(miDetalle.getPrecioSinImpuUnitLocal()!=null){
                    datos.add(3,new BigDecimal( miDetalle.getPrecioSinImpuUnitLocal().floatValue()).setScale(2,BigDecimal.ROUND_HALF_EVEN).toString());
                } else {
                    datos.add(3,"  ");
                }
        
                if(miDetalle.getPrecioNetoUnitarioLocal()!=null){
                    datos.add(4,new BigDecimal( miDetalle.getPrecioNetoUnitarioLocal().floatValue()).setScale(2,BigDecimal.ROUND_HALF_EVEN).toString());
                } else {
                    datos.add(4,"  ");
                }
        
                if(miDetalle.getPrecioNetoTotalLocal()!=null){
                    datos.add(5,new BigDecimal( miDetalle.getPrecioNetoTotalLocal().floatValue()).setScale(2,BigDecimal.ROUND_HALF_EVEN).toString());
                } else {
                    datos.add(5,"  ");
                }
                
            sf1.addMensaje(11,datos);
            datos.clear();
            } else {
                listaFueraCaja.add(miDetalle);
            }
        }   //fin if dentro caja          
    }//fin for
      
      sf1.addMensaje(10,new ArrayList());
      UtilidadesLog.debug("SF1 es: " + sf1);
          
      for(int x=0;x<listaFueraCaja.size();x++)
      {
        DTOFACDocumentoContableDetalle miDetalle=(DTOFACDocumentoContableDetalle)listaFueraCaja.get(x);
        
        datos.add(0, validarToString(miDetalle.getUnidadesAtendidas()));
        datos.add(1, validarToString(miDetalle.getDescripcionProd()));
        //  Modificado por HRCS - Fecha 06/06/2007 - Cambio Sicc20070274
        if(miDetalle.getCodigoVenta()!=null) {
          codigoCompleto= calcularCodigoCompletoVenta(validarToString(miDetalle.getCodPeriodo()),validarToString(miDetalle.getCodigoVenta()),miDetalle.getPrecioCatalUnitLocal());                                                                    
        } else {
          codigoCompleto= calcularCodigoCompletoVenta(validarToString(miDetalle.getCodPeriodo()),validarToString(miDetalle.getCodigoProducto()), miDetalle.getPrecioCatalUnitLocal());                                                                         
        }
        datos.add(2,codigoCompleto);
        
        if(miDetalle.getPrecioSinImpuUnitLocal()!=null){
            datos.add(3,new BigDecimal( miDetalle.getPrecioSinImpuUnitLocal().floatValue()).setScale(2,BigDecimal.ROUND_HALF_EVEN).toString());
        } else {
            datos.add(3,"  ");
        }

        if(miDetalle.getPrecioNetoUnitarioLocal()!=null){
            datos.add(4,new BigDecimal( miDetalle.getPrecioNetoUnitarioLocal().floatValue()).setScale(2,BigDecimal.ROUND_HALF_EVEN).toString());
        } else {
            datos.add(4,"  ");
        }

        if(miDetalle.getPrecioNetoTotalLocal()!=null){
            datos.add(5,new BigDecimal( miDetalle.getPrecioNetoTotalLocal().floatValue()).setScale(2,BigDecimal.ROUND_HALF_EVEN).toString());
        } else {
            datos.add(5,"  ");
        }
        sf1.addMensaje(11,datos);
        datos.clear();
      }
     
     
         
		// Composición de la sección 3
		
    datos.clear();

    if ((miCabecera.getGlosa()!=null) && (miCabecera.getGlosa().trim().length()>0) && (!miCabecera.getGlosa().trim().equals("null"))) {
        String glosa = "NOTA: " + validarToString(miCabecera.getGlosa());
        datos.add(0, glosa);
    } else {
        datos.add(0,"");
    }
    sf1.addMensaje(12, datos);
    datos.clear();
    
    sf1.addSeccion(1);
    
    float totaVentaCata=0;
    float totalDescuento=0;

   	datos.add(0, validarToString(miCabecera.getNumUnidadesAtendidas()));
    if (miCabecera.getTotalAPagarLocal()==null) miCabecera.setTotalAPagarLocal(new Float(0));
    if (miCabecera.getImporteImpuestosTotalLocal()==null) miCabecera.setImporteImpuestosTotalLocal(new Float(0));
    if (miCabecera.getImporteFleteSinImpuestosTotalLocal()==null) miCabecera.setImporteFleteSinImpuestosTotalLocal(new Float(0));
    if (miCabecera.getPrecioCatSinImpTotLoc()==null) miCabecera.setPrecioCatSinImpTotLoc(new Float(0));
    if (miCabecera.getImpDesc1SinImpTotLocal()==null) miCabecera.setImpDesc1SinImpTotLocal(new Float(0));
    if (miCabecera.getImpDesc3TotalLocal()==null) miCabecera.setImpDesc3TotalLocal(new Float(0));
    
    if(miCabecera.getTotalAPagarLocal()!=null && miCabecera.getImporteImpuestosTotalLocal()!=null
       && miCabecera.getImporteFleteSinImpuestosTotalLocal()!=null && miCabecera.getPrecioCatSinImpTotLoc()!=null
       && miCabecera.getImpDesc1SinImpTotLocal()!=null && miCabecera.getImpDesc3TotalLocal()!=null){
        totaVentaCata = miCabecera.getTotalAPagarLocal().floatValue() - miCabecera.getImporteImpuestosTotalLocal().floatValue() -
                        miCabecera.getImporteFleteSinImpuestosTotalLocal().floatValue() + (miCabecera.getPrecioContSinImpTotLoc().floatValue()
                        +miCabecera.getImpDesc1SinImpTotLocal().floatValue()+miCabecera.getImpDesc3TotalLocal().floatValue());
        BigDecimal totaVentaCata2 = new BigDecimal(totaVentaCata).setScale(2,BigDecimal.ROUND_HALF_EVEN);
        if (totaVentaCata < 0){
            datos.add(1,totaVentaCata2.toString());
        }else if (totaVentaCata >= 0){
            datos.add(1,totaVentaCata2.toString());
        }
    }else{
        datos.add(1," ");  
    }
    
   totalDescuento = (miCabecera.getPrecioContSinImpTotLoc()!=null?miCabecera.getPrecioContSinImpTotLoc().floatValue():0) + 
                    (miCabecera.getImpDesc1SinImpTotLocal()!=null?miCabecera.getImpDesc1SinImpTotLocal().floatValue():0)+
                    (miCabecera.getImpDesc3TotalLocal()!=null?miCabecera.getImpDesc3TotalLocal().floatValue():0);
    BigDecimal totalDescuento2 = new BigDecimal(totalDescuento).setScale(2,BigDecimal.ROUND_HALF_EVEN);
    datos.add(2,'(' + totalDescuento2.toString());

    float contAux = (totaVentaCata - totalDescuento);
    double contAux1 = Math.rint(contAux*100)/100;
    
    BigDecimal aux = new BigDecimal(contAux1).setScale(2,BigDecimal.ROUND_HALF_EVEN);
    if( contAux<0){
        datos.add(3,aux.toString());
    }else{
        datos.add(3,aux.toString());
    }
    
    
      
      
    if(miCabecera.getImporteFleteSinImpuestosTotalLocal()!=null && miCabecera.getImporteFleteSinImpuestosTotalLocal().floatValue()<0){
        datos.add(4,new BigDecimal(miCabecera.getImporteFleteSinImpuestosTotalLocal().floatValue()).setScale(2,BigDecimal.ROUND_HALF_EVEN).toString());  
    }else if(miCabecera.getImporteFleteSinImpuestosTotalLocal()!=null && miCabecera.getImporteFleteSinImpuestosTotalLocal().floatValue()>=0){
        datos.add(4,new BigDecimal(miCabecera.getImporteFleteSinImpuestosTotalLocal().floatValue()).setScale(2,BigDecimal.ROUND_HALF_EVEN).toString());  
    }else{
        datos.add(4," ");
    }
    
    sf1.addMensaje(21, datos);		
	datos.clear();
	String res="CERO";
    if(miCabecera.getTotalAPagarLocal()!=null){
    Numtotext numero = new Numtotext(1);
    res = numero.procesar(miCabecera.getTotalAPagarLocal());
    }
    String monedaAux=" ";
    if(miCabecera.getMoneda()!=null)
    {
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
    
    datos.add(0, arraySon[0]);
    datos.add(1, arraySon[1]);


    if (miCabecera.getImporteImpuestosTotalLocal()!=null && miCabecera.getImporteImpuestosTotalLocal().floatValue()<0){
        datos.add(2,new BigDecimal(miCabecera.getImporteImpuestosTotalLocal().floatValue()).setScale(2,BigDecimal.ROUND_HALF_EVEN).toString());  
    }else if (miCabecera.getImporteImpuestosTotalLocal()!=null && miCabecera.getImporteImpuestosTotalLocal().floatValue()>=0){
        datos.add(2,new BigDecimal(miCabecera.getImporteImpuestosTotalLocal().floatValue()).setScale(2,BigDecimal.ROUND_HALF_EVEN).toString());  
    }else{
        datos.add(2,"  ");
    }
    
    
	if(miCabecera.getTotalAPagarLocal()!=null && miCabecera.getTotalAPagarLocal().floatValue()<0){
        datos.add(3,new BigDecimal(miCabecera.getTotalAPagarLocal().floatValue()).setScale(2,BigDecimal.ROUND_HALF_EVEN).toString());  
    }else if(miCabecera.getTotalAPagarLocal()!=null && miCabecera.getTotalAPagarLocal().floatValue()>=0){
        datos.add(3,new BigDecimal(miCabecera.getTotalAPagarLocal().floatValue()).setScale(2,BigDecimal.ROUND_HALF_EVEN).toString());  
    }else{
        datos.add(3," ");
    }
    
   datos.add(4, arraySon[2]);
    Float tasaPercepcion = miCabecera.getTasaImpuestoPercepcion();
    UtilidadesLog.debug("tasaPercepcion: " + tasaPercepcion);
    if (miCabecera.getIndImprimirPercepcion()!=null && miCabecera.getIndImprimirPercepcion().booleanValue()) {
        if (tasaPercepcion != null && tasaPercepcion.floatValue() > 0) {
            UtilidadesLog.debug("Corresponde imprimir la percepción");
            UtilidadesLog.debug("miCabecera.fleteSinImpuestosTotalLocal: " + miCabecera.getImporteFleteSinImpuestosTotalLocal());
            UtilidadesLog.debug("miCabecera.fleteTotalLocal: " + miCabecera.getImporteFleteTotalLocal());
            
            float importeFleteTotalLocal = (miCabecera.getImporteFleteTotalLocal() != null)? miCabecera.getImporteFleteTotalLocal().floatValue() : 0;
            float montoCalcularPerc = miCabecera.getTotalAPagarLocal().floatValue() - importeFleteTotalLocal;
            BigDecimal montoPercepcion = new BigDecimal(this.calcularPercepcion(new Float(montoCalcularPerc), tasaPercepcion).floatValue());
            montoPercepcion = montoPercepcion.setScale(2, BigDecimal.ROUND_HALF_EVEN);
            
            BigDecimal nuevoTotal = new BigDecimal(montoPercepcion.floatValue() + miCabecera.getTotalAPagarLocal().floatValue());
            nuevoTotal = nuevoTotal.setScale(2, BigDecimal.ROUND_HALF_EVEN);
            datos.add(5, "PERCEPCION " + miCabecera.getTasaImpuestoPercepcion().intValue() + '%');
            datos.add(6, montoPercepcion.toString());
            datos.add(7, "TOTAL A PAGAR   S/.");
            datos.add(8, nuevoTotal.toString());
        } else {
            UtilidadesLog.debug("No corresponde imprimir percepcion, las lineas van en blanco");
            datos.add(5, " ");
            datos.add(6, " ");
            datos.add(7, " ");
            datos.add(8, " ");
        } 
    } else {
        UtilidadesLog.debug("No corresponde imprimir percepcion, las lineas van en blanco");
        datos.add(5, " ");
        datos.add(6, " ");
        datos.add(7, " ");
        datos.add(8, " ");
    }   
    
	sf1.addMensaje(22, datos);
    sf1.addSeccion(2);
    sf1.insertarCaracterFinDePagina();
    }
      
    try		{
      sf1.componerDocumento();
			sf1.saveDocument("c:\\", "facturaPeru1.txt");
			this.documento = sf1.bufferOut;
		}	catch (Exception e) {
			UtilidadesLog.error("ERROR",e);
		}
      if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
	UtilidadesLog.debug("FacturaPeru1: "+sf1.toString());
        
    UtilidadesLog.info("FacturaPeru1.componerFactura(DTODocLegal datosDocLegal): Salida"); 
  }

    public byte[] getDocument(){
        return this.documento;
    }
  
  
    public String calcularCodigoCompletoVenta(String codPeriodoEntrada, String codVenta, Float precioCatalogoUnitLocalEntrada){
     UtilidadesLog.info("FacturaPeru1.calcularCodigoCompletoVenta(String codPeriodoEntrada, String codVenta, Float precioCatalogoUnitLocalEntrada): Entrada"); 
     
     String salida="";
     if(codPeriodoEntrada.length()>2){
        salida=codPeriodoEntrada.substring(codPeriodoEntrada.length()-2 ,codPeriodoEntrada.length());
     } else {
        salida=codPeriodoEntrada;  
     }
     
     if(codVenta.length()>5){
     salida+=codVenta.substring(0,5);
     } else {
       salida+=codVenta;
     }

    if(precioCatalogoUnitLocalEntrada!=null && (precioCatalogoUnitLocalEntrada.floatValue()!=0)) {
        salida+="8";
    } else {
        salida+="0";
    }

     UtilidadesLog.info("FacturaPeru1.calcularCodigoCompletoVenta(String codPeriodoEntrada, String codVenta, Float precioCatalogoUnitLocalEntrada): Salida"); 
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
    	FacturaPeru1 fac = new FacturaPeru1();
    }

    /**
     * Calcula el importe de la percepción a partir del total a pagar local.
     * Construido por SICC-GCC-FAC-002
     * @return percepcion
     * @param percepcion Tasa de percepcion
     * @param totalAPagarLocal
     * @author dmorello
     * @date   17/10/2006
     */
    private Float calcularPercepcion(Float totalAPagarLocal, Float percepcion) {
        return new Float(totalAPagarLocal.floatValue() * percepcion.floatValue() / 100);
    }


}
