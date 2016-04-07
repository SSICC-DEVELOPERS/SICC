package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NotaCreditoF1Peru extends DocumentoFAC 
{
	private byte[] documento;
	// Comunes
	 private UtilidadesLog log = new UtilidadesLog();

    public NotaCreditoF1Peru()
    {
    }
    
    // Modificado por la BELC300015920
    public void componerFactura(DTODocLegal datosDocLegal)
    {
      UtilidadesLog.info("NotaCreditoF1Peru.componerFactura(DTODocLegal datosDocLegal): Entrada"); 
      ArrayList listaPaginas=datosDocLegal.getlistaPaginas();
      SerializadorNotaCreditoF1Peru sf1 = new SerializadorNotaCreditoF1Peru();
      
      for(int i=0;i<listaPaginas.size();i++){

        ArrayList datos = new ArrayList(); // Contiene objetos de tipo "dato"
        DTOFACDocumentoContable docuContable=(DTOFACDocumentoContable)listaPaginas.get(i);
        DTOFACDocumentoContableCabecera miCabecera = docuContable.getCabecera();

    		datos.add(0, Integer.toString(i+1));
        datos.add(1, Integer.toString(listaPaginas.size()));
        sf1.addMensaje(0, datos);
        datos.clear();

        datos.add(0, validarToString(miCabecera.getCodPeriodo()));
    
        String auxFecha = null;
        String stringFecha = "";
        try {
          auxFecha = UtilidadesFecha.convertirAString(miCabecera.getFechaFacturacion());
          String[] splitFechas = new String[3];
          StringTokenizer st = new StringTokenizer(auxFecha, "-");
          for(int cont = 0; cont<3; cont++) {
            splitFechas[cont] = st.nextToken();
          }
          stringFecha = splitFechas[2] + '/' + splitFechas[1] + '/' +splitFechas[0];
        } catch(Exception e){
        }
        datos.add(1,stringFecha);
        sf1.addMensaje(2, datos);
        datos.clear();

        if(miCabecera.getNumDocReferencia()!=null){
          datos.add(0,miCabecera.getNumDocReferencia());
        } else {
          datos.add(0," ");
        }
    
        if(miCabecera.getCodPeriodoRefe()!=null){
          datos.add(1, validarToString(miCabecera.getCodPeriodoRefe()));
        }else{
          datos.add(1," ");
        }
    
        sf1.addMensaje(13,datos);
        datos.clear();
		
        datos.add(0, validarToString(miCabecera.getCodZona())+"-"+ validarToString(miCabecera.getCodTerritorio()));
        datos.add(1,miCabecera.getCodCliente());
        sf1.addMensaje(3,datos);
        datos.clear();
    
        datos.add(0,miCabecera.getApellido1()+" "+ validarToString(miCabecera.getApellido2())+" ,"+
                validarToString(miCabecera.getNombre1())+" "+validarToString(miCabecera.getNombre2()));
        datos.add(1, validarToString(miCabecera.getNumIdentificacionFiscal()));
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
        sf1.addMensaje(5, datos);
        datos.clear();
      
        split = this.dividirCadena(validarToString(miCabecera.getDescripcionUbigeo()), 47);
        datos.add(0,split[0]);
        datos.add(1, validarToString(miCabecera.getNumConsolidado()));
        if (split.length > 1) {
          datos.add(2, split[1]);
        } else {
          datos.add(2, " ");
        }
        if (datosDocLegal.getIndOnline() != null && datosDocLegal.getIndOnline().booleanValue()) {
          datos.add(3, validarToString(miCabecera.getNumDocContableInterno()));
        } else {
          datos.add(3, "$$$$$$$$$$$$$");
        }

      if (split.length > 2) {
          datos.add(4, split[2]);
      } else {
          datos.add(4, " ");
      }
      sf1.addMensaje(8, datos);
      datos.clear();
      sf1.addSeccion(0);
		
  		ArrayList misDetalles= docuContable.getDetalle();
      ArrayList listaFueraCaja= new ArrayList();
      String codigoCompleto="";
      for(int x=0;x<misDetalles.size();x++){
        DTOFACDocumentoContableDetalle miDetalle=(DTOFACDocumentoContableDetalle)misDetalles.get(x);
        UtilidadesLog.debug("El indicador dentro caja fuera bolsa es: "+miDetalle.getIndicadorDentroFueraCajaBolsa());
         if(!miDetalle.getNoImprimible()){
          if("C".equals(miDetalle.getIndicadorDentroFueraCajaBolsa())) {
            long unidades = 0;
            if (miDetalle.getUnidadesAtendidas().longValue() < 1) {
                unidades = miDetalle.getUnidadesAtendidas().longValue()*(-1);
            }else{
                unidades = miDetalle.getUnidadesAtendidas().longValue();
            }

            datos.add(0, validarToString(new Long(unidades)));
            datos.add(1, validarToString(miDetalle.getDescripcionProd()));
            if(miDetalle.getPrecioCatalUnitLocal()!=null) {
                if(miDetalle.getPrecioContUnitLocal()!=null){
                  if(miDetalle.getCodigoVenta()!=null)
                  {
                    codigoCompleto= calcularCodigoCompletoVenta(miCabecera.getCodPeriodo(),miDetalle.getCodigoVenta(),miDetalle.getPrecioCatalUnitLocal());                                                                    
                  }
                  else
                  {
                    codigoCompleto= calcularCodigoCompletoVenta(miCabecera.getCodPeriodo(),miDetalle.getCodigoProducto(),miDetalle.getPrecioCatalUnitLocal());                                                                         
                  }
                }
            }
            datos.add(2,codigoCompleto);
            if(miDetalle.getPrecioSinImpuUnitLocal()!=null){
                datos.add(3,anadirCeroFloat(new Float(miDetalle.getPrecioSinImpuUnitLocal().floatValue()).toString()));
            } else {
               datos.add(3," ");
            }
            if (miDetalle.getPrecioNetoUnitarioLocal()!=null) {
                datos.add(4,anadirCeroFloat(new Float(miDetalle.getPrecioNetoUnitarioLocal().floatValue()).toString()));
            } else {
                datos.add(4," ");
            }
            
            //BELC300018617
            if (miDetalle.getPrecioNetoTotalLocal()!=null) {
                if (miDetalle.getPrecioNetoTotalLocal().floatValue()<0) {                   
                  datos.add(5,anadirCeroFloat(new Float(miDetalle.getPrecioNetoTotalLocal().floatValue()*(-1)).toString()));
                } else {
                  datos.add(5,anadirCeroFloat(new Float(miDetalle.getPrecioNetoTotalLocal().floatValue()).toString()));                           
                }
            } else {
                datos.add(5," ");
            }
            sf1.addMensaje(11,datos);
            datos.clear();
            } else {
             listaFueraCaja.add(miDetalle);
            }
        }             
      }
      
      sf1.addMensaje(10,new ArrayList());
          
      for(int x=0;x<listaFueraCaja.size();x++){
        DTOFACDocumentoContableDetalle miDetalle=(DTOFACDocumentoContableDetalle)listaFueraCaja.get(x);
        
        long unidades = 0;
        if (miDetalle.getUnidadesAtendidas().longValue() < 1) {
            unidades = miDetalle.getUnidadesAtendidas().longValue()*(-1);
        }else{
            unidades = miDetalle.getUnidadesAtendidas().longValue();
        }        
        Long unidadesAtendidas = new Long(unidades);
        datos.add(0,validarToString(unidadesAtendidas));
        datos.add(1, validarToString(miDetalle.getDescripcionProd()));
        if(miDetalle.getPrecioCatalUnitLocal()!=null) {
            if(miDetalle.getCodigoVenta()!=null){
                codigoCompleto= calcularCodigoCompletoVenta(miCabecera.getCodPeriodo(),miDetalle.getCodigoVenta(),miDetalle.getPrecioCatalUnitLocal());                                                                    
            }else{
                codigoCompleto= calcularCodigoCompletoVenta(miCabecera.getCodPeriodo(),miDetalle.getCodigoProducto(),miDetalle.getPrecioCatalUnitLocal());                                                                         
            }
        }
        
          datos.add(2,codigoCompleto);
        
        
        
        if(miDetalle.getPrecioSinImpuUnitLocal()!=null){
                datos.add(3,anadirCeroFloat(new Float(miDetalle.getPrecioSinImpuUnitLocal().floatValue()).toString()));
            }else{
                datos.add(3," ");
            }
            if (miDetalle.getPrecioNetoUnitarioLocal()!=null){
                datos.add(4,anadirCeroFloat(new Float(miDetalle.getPrecioNetoUnitarioLocal().floatValue()).toString()));
            }else{
                datos.add(4," ");
            }
            
            //BELC300018617
            if (miDetalle.getPrecioNetoTotalLocal()!=null) {
                if (miDetalle.getPrecioNetoTotalLocal().floatValue() < 0) {
                    datos.add(5,anadirCeroFloat(new Float(miDetalle.getPrecioNetoTotalLocal().floatValue()*(-1)).toString()));
                } else {
                    datos.add(5,anadirCeroFloat(new Float(miDetalle.getPrecioNetoTotalLocal().floatValue()).toString()));                      
                }
            } else {
                datos.add(5," ");
            }
        sf1.addMensaje(11,datos);
        datos.clear();
      }
     
     
     // Composición de la sección 3.2
     datos.clear();

     if ((miCabecera.getGlosa()!=null) && (miCabecera.getGlosa().trim().length()>0)) {
        String glosa = "NOTA: " + validarToString(miCabecera.getGlosa());
        datos.add(0, glosa);
     } else {
        datos.add(0,"");
     }
     sf1.addMensaje(12, datos);
     datos.clear();
     
     sf1.addSeccion(1);
     
    if (miCabecera.getNumUnidadesAtendidas()!=null)
    {
        int totalUnidades = 0;
        if (miCabecera.getNumUnidadesAtendidas().intValue() < 0) {
            totalUnidades = (miCabecera.getNumUnidadesAtendidas().intValue()*(-1));
        } else {
            totalUnidades = (miCabecera.getNumUnidadesAtendidas().intValue());
            
        }
        datos.add(0,validarToString(new Integer(totalUnidades)));
    }else
    {
        datos.add(0," ");
    }
    //Añadido por incidencia BELC300021757
    float totaVentaCata = 0;
    float totalDescuento = 0;	
    if (miCabecera.getTotalAPagarLocal()==null) miCabecera.setTotalAPagarLocal(new Float(0));
    if (miCabecera.getImporteImpuestosTotalLocal()==null) miCabecera.setImporteImpuestosTotalLocal(new Float(0));
    if (miCabecera.getImporteFleteSinImpuestosTotalLocal()==null) miCabecera.setImporteFleteSinImpuestosTotalLocal(new Float(0));
    if (miCabecera.getPrecioContSinImpTotLoc()==null) miCabecera.setPrecioContSinImpTotLoc(new Float(0));
    if (miCabecera.getImpDesc1SinImpTotLocal()==null) miCabecera.setImpDesc1SinImpTotLocal(new Float(0));
    if (miCabecera.getImpDesc3TotalLocal()==null) miCabecera.setImpDesc3TotalLocal(new Float(0));
    
    if(miCabecera.getTotalAPagarLocal()!=null && miCabecera.getImporteImpuestosTotalLocal()!=null
       && miCabecera.getImporteFleteSinImpuestosTotalLocal()!=null && miCabecera.getPrecioCatSinImpTotLoc()!=null
       && miCabecera.getImpDesc1SinImpTotLocal()!=null && miCabecera.getImpDesc3TotalLocal()!=null){
        totaVentaCata = (miCabecera.getTotalAPagarLocal().floatValue() - miCabecera.getImporteImpuestosTotalLocal().floatValue() -
                        miCabecera.getImporteFleteSinImpuestosTotalLocal().floatValue() + (miCabecera.getPrecioContSinImpTotLoc().floatValue()
                        +miCabecera.getImpDesc1SinImpTotLocal().floatValue()+miCabecera.getImpDesc3TotalLocal().floatValue()))*(-1);    //  Modificado HRCS - Incidencia Sicc20070358
        BigDecimal totaVentaCata2 = new BigDecimal(totaVentaCata).setScale(2,BigDecimal.ROUND_HALF_EVEN);
        if (totaVentaCata < 0){
            datos.add(1,totaVentaCata2.toString());
        }else if (totaVentaCata >= 0){
            datos.add(1,totaVentaCata2.toString());
        }
    }else{
        datos.add(1," ");  
    }
    
    if (miCabecera.getPrecioContSinImpTotLoc()!=null 
        && miCabecera.getImpDesc1SinImpTotLocal()!=null 
        && miCabecera.getImpDesc3TotalLocal()!=null){
        totalDescuento = (miCabecera.getPrecioContSinImpTotLoc().floatValue() 
            + miCabecera.getImpDesc1SinImpTotLocal().floatValue() + 
            miCabecera.getImpDesc3TotalLocal().floatValue())*(-1);  //  Modificado HRCS - Incidencia Sicc20070358
        
        if (totalDescuento<0){
            datos.add(2,'(' + anadirCeroFloat(String.valueOf(totalDescuento)));
        }else if (totalDescuento>0){
            datos.add(2,'(' + anadirCeroFloat(String.valueOf(totalDescuento)));
        }else{
            datos.add(2,"(0.00");
        }        
    }else{
        datos.add(2,"  ");
    }
    
    float contAux = (totaVentaCata-totalDescuento);
    double contAux1 = Math.rint(contAux*100)/100;
    
    if (contAux1<0){
        datos.add(3,anadirCeroFloat(String.valueOf(contAux1)));
    }else if(contAux1>0){
        datos.add(3,anadirCeroFloat(String.valueOf(contAux1)));
    }else{
        datos.add("0.00");
    }
    

    if(miCabecera.getImporteFleteSinImpuestosTotalLocal()!=null){
        float contAux2 = (miCabecera.getImporteFleteSinImpuestosTotalLocal().floatValue())*(-1);    //  Modificado HRCS - Incidencia Sicc20070358
        if (contAux2<0){
            datos.add(4,anadirCeroFloat(String.valueOf(contAux2)));
        }else if (contAux2>0){
            datos.add(4,anadirCeroFloat(String.valueOf(contAux2)));
        }else{
            datos.add(4,"0.00");
        }
    }else
    {
      datos.add(4," ");
    }

    sf1.addMensaje(21, datos);		
		datos.clear();
		String res="CERO";
    if(miCabecera.getTotalAPagarLocal()!=null){
        Numtotext numero = new Numtotext(1);
        res = numero.procesar(new Float(miCabecera.getTotalAPagarLocal().floatValue()*(-1)));   //  Modificado HRCS - Incidencia Sicc20070358
    }
    UtilidadesLog.debug("valor en letras: "+res);
    String monedaAux=" ";
    if(miCabecera.getMoneda()!=null) {
      monedaAux=miCabecera.getMoneda();
    }
    datos.add(0,res+" "+ monedaAux);
	datos.add(1,"");
	
    //TOTAL IMPUESTO
    if (miCabecera.getImporteImpuestosTotalLocal()!=null){
        float contAux2 = (miCabecera.getImporteImpuestosTotalLocal().floatValue())*(-1);      //  Modificado HRCS - Incidencia Sicc20070358
        if (contAux2<0){
            datos.add(2,anadirCeroFloat(String.valueOf(contAux2)));
        } else {
            datos.add(2,anadirCeroFloat(String.valueOf(contAux2)));
        }
    }else {
        datos.add(2,"  ");
    }
    
    //total a pagar local
    if(miCabecera.getTotalAPagarLocal()!=null)
    {
        float contAux2=(miCabecera.getTotalAPagarLocal().floatValue())*(-1);    //  Modificado HRCS - Incidencia Sicc20070358
        if (contAux2<0)
        {
            datos.add(3,anadirCeroFloat(String.valueOf(contAux2)));
        }else
        {
            datos.add(3,anadirCeroFloat(String.valueOf(contAux2)));
        }
    }else
    {
      datos.add(3," ");
    }

    datos.add(4,"");
	sf1.addMensaje(22, datos);
    sf1.insertarCaracterFinDePagina();
        
	}

      
    try
		{
      sf1.componerDocumento();
			sf1.saveDocument("c:\\", "notaCreditoF1Peru.txt");
			this.documento = sf1.bufferOut;
		}
		catch (Exception e)
		{
			UtilidadesLog.error("ERROR",e);
		}
              if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
		UtilidadesLog.debug("NotaCreditoF1Peru: "+sf1.toString());
                
    UtilidadesLog.info("NotaCreditoF1Peru.componerFactura(DTODocLegal datosDocLegal): Salida"); 
          }
   
   

    public byte[] getDocument()
    {
        return this.documento;
    }
    

    
    public String calcularCodigoCompletoVenta(String codPeriodoEntrada, String codVenta, Float precioCatalogoUnitLocalEntrada)
    {
     //UtilidadesLog.debug("ESTOS SON LOS PARAMETROS QUE ME ENTRAN: " + codPeriodoEntrada+" "+codVenta+" "+precioCatalogoUnitLocalEntrada);
     UtilidadesLog.info("NotaCreditoF1Peru.calcularCodigoCompletoVenta(String codPeriodoEntrada, String codVenta, Float precioCatalogoUnitLocalEntrada): Entrada"); 
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
        // Hablado con DT. Si es nulo, termina en 0
        salida+="0";
    }
     
     //UtilidadesLog.debug("Y ESTA ES LA SALIDA: "+ salida);
     UtilidadesLog.info("NotaCreditoF1Peru.calcularCodigoCompletoVenta(String codPeriodoEntrada, String codVenta, Float precioCatalogoUnitLocalEntrada): Salida"); 
     return salida;
    }
  

}