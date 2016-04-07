package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import es.indra.sicc.dtos.fac.DTOFACConsolidado;
import es.indra.sicc.util.UtilidadesFecha;
import java.math.BigDecimal;
import java.util.ArrayList;
//import es.indra.sicc.dtos.fac.DTOFACConsolidado;
import java.util.StringTokenizer;

import es.indra.sicc.util.UtilidadesLog;

public class DocuNotaDebito extends DocumentoFAC 
{
	private byte[] documento;
	private DTOFACConsolidado datosConsolidado;
  //private DTOFACDocumentoContable datosDocumentoContable;
   private UtilidadesLog log = new UtilidadesLog();
  
    public DocuNotaDebito(){    
    }
    
       
    public void componerFactura(DTODocLegal datosDocLegal) {
       UtilidadesLog.info("DocuNotaDebito.componerFactura(DTODocLegal datosDocLegal): Entrada"); 
       ArrayList listaPaginas=datosDocLegal.getlistaPaginas();
       SerializadorDebito sf1 = new SerializadorDebito();  
       
       for (int i=0; i<listaPaginas.size(); i++) {
            ArrayList datos = new ArrayList(); // Contiene objetos de tipo "dato"
      
            DTOFACDocumentoContable docuContable=(DTOFACDocumentoContable)listaPaginas.get(i);
                   
            DTOFACDocumentoContableCabecera miCabecera =  docuContable.getCabecera();
              
            datos.add(0, validarToString(miCabecera.getNumConsolidado()));
            sf1.addMensaje(1,datos); 
            datos.clear();
      
            sf1.addMensaje(2,datos);
            datos.clear();
    
            datos.add(0,miCabecera.getCodCliente().toString());
            datos.add(1,validarToString(miCabecera.getNumDocReferencia()));
      
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
                stringFecha = splitFechas[2]+"/"+splitFechas[1]+"/"+splitFechas[0].substring(splitFechas[0].length()-4, splitFechas[0].length());
            } catch(Exception e){
            }

            datos.add(2,stringFecha);
      
            sf1.addMensaje(3,datos);
            datos.clear();
      
            datos.add(0,miCabecera.getApellido1()+" "+ validarToString(miCabecera.getApellido2()) +", "+ validarToString(miCabecera.getNombre1())+" "+ validarToString(miCabecera.getNombre2()));
            sf1.addMensaje(4,datos);
            datos.clear();
      
      
            String[] split = this.dividirCadena(validarToString(miCabecera.getNombreVia()), 46);
            datos.add(0,split[0]);
            if (split.length > 1) {
                datos.add(1, split[1]);
            } else {
                datos.add(1, " ");
            }
            if (split.length > 2) {
                datos.add(2, split[2]);
            } else {
                datos.add(2, " ");
            }
            sf1.addMensaje(5,datos);
            datos.clear();
      
            split = this.dividirCadena(validarToString(miCabecera.getDescripcionUbigeo()), 46);
            datos.add(0,split[0]);
            sf1.addMensaje(6,datos);
            datos.clear(); 
      
      
            if (datosDocLegal.getIndOnline() != null && datosDocLegal.getIndOnline().booleanValue()) {
                datos.add(0, validarToString(miCabecera.getNumDocContableInterno()));
            } else {
                datos.add(0, "$$$$$$$$$$$$$");
            }

            sf1.addMensaje(7,datos);
            datos.clear();
      
            ArrayList misDetalles= docuContable.getDetalle();
            sf1.addSeccion(0);
            for (int x=0; x<misDetalles.size(); x++) {
                DTOFACDocumentoContableDetalle miDetalle=(DTOFACDocumentoContableDetalle)misDetalles.get(x);
                String codigoCompleto="";
                if (!miDetalle.getNoImprimible()) {  
                    if (miDetalle.getPrecioCatalUnitLocal() != null) {
                        if (miDetalle.getCodigoVenta()!=null) {
                            codigoCompleto= calcularCodigoCompletoVenta(miCabecera.getCodPeriodo(),miDetalle.getCodigoVenta(),miDetalle.getPrecioCatalUnitLocal());                                                                    
                        } else {
                            codigoCompleto= calcularCodigoCompletoVenta(miCabecera.getCodPeriodo(),miDetalle.getCodigoProducto(),miDetalle.getPrecioCatalUnitLocal());                                                                         
                        }
                    }
                    datos.add(0,codigoCompleto);
                    if (miDetalle.getDescripcionProd() != null) {
                        datos.add(1,miDetalle.getDescripcionProd());
                    } else {
                        datos.add(1," ");
                    }
                    datos.add(2, validarToString(miDetalle.getUnidadesAtendidas()));
                    if (miDetalle.getPrecioCatalUnitLocal() != null && miDetalle.getPrecioContUnitLocal() != null) {
                        datos.add(3,anadirCeroFloat(String.valueOf(miDetalle.getPrecioSinImpuUnitLocal())));
                    } else {
                        datos.add(3," ");  
                    }
                    if (miDetalle.getPrecioCatalTotLocal() != null && miDetalle.getPrecioContTotLocal() != null) {
                        datos.add(4,anadirCeroFloat(String.valueOf(miDetalle.getPrecioSinImpuTotalLocal())));
                    } else {
                        datos.add(4," ");
                    }
            
                    sf1.addMensaje(8,datos);
                    datos.clear();
                }
            }

            if ((miCabecera.getGlosa()!=null) && (miCabecera.getGlosa().trim().length()>0)) {
                String glosa = "NOTA: " + validarToString(miCabecera.getGlosa());
                datos.add(0, glosa);
            } else {
                datos.add(0,"");
            }
            sf1.addMensaje(9, datos);
            datos.clear();           

            sf1.addSeccion(1);
            Numtotext numero = new Numtotext(1);
            String  res= "CERO";
            if (miCabecera.getTotalAPagarLocal() != null) {
                res = numero.procesar(miCabecera.getTotalAPagarLocal());
		    }
            
            String moneda = " ";
            if (miCabecera.getMoneda() != null) {
                moneda = miCabecera.getMoneda();
            }
            datos.add(0, res + " " + moneda);
      
            datos.add(1, " ");
            if (miCabecera.getPrecioCatSinImpTotLoc() != null && miCabecera.getPrecioContSinImpTotLoc() != null) {
                datos.add(2,anadirCeroFloat(String.valueOf(miCabecera.getPrecioCatSinImpTotLoc().floatValue()+miCabecera.getPrecioContSinImpTotLoc().floatValue())));
            } else {
                datos.add(2," ");  
            }
            sf1.addMensaje(10,datos);  //DBLG500000514
            datos.clear();
            
            Float tasaPercepcion = miCabecera.getTasaImpuestoPercepcion();
            BigDecimal nuevoTotal = null;
            if (miCabecera.getIndImprimirPercepcion().booleanValue()) {
                if (tasaPercepcion != null && tasaPercepcion.floatValue() > 0) {
                    UtilidadesLog.debug("miCabecera.getTotalAPagarLocal().floatValue() -> " + miCabecera.getTotalAPagarLocal().floatValue());
                    UtilidadesLog.debug("miCabecera.getImporteFleteTotalLocal().floatValue() -> " + miCabecera.getImporteFleteTotalLocal().floatValue());
                    float montoCalcularPerc = miCabecera.getTotalAPagarLocal().floatValue() - miCabecera.getImporteFleteTotalLocal().floatValue();
                    UtilidadesLog.debug("montoCalcularPerc ->" + montoCalcularPerc);
                    
                    BigDecimal montoPercepcion = new BigDecimal(this.calcularPercepcion(new Float(montoCalcularPerc), tasaPercepcion).floatValue());
                    UtilidadesLog.debug("montoPercepcion ->" + montoPercepcion);                    
                    montoPercepcion = montoPercepcion.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                                        
                    nuevoTotal = new BigDecimal(montoPercepcion.floatValue() + miCabecera.getTotalAPagarLocal().floatValue());
                    nuevoTotal = nuevoTotal.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                    datos.add(0, "PERCEPCION " + miCabecera.getTasaImpuestoPercepcion().intValue() + '%');
                    datos.add(1, montoPercepcion.toString());
                } else {
                    datos.add(0, " ");
                    datos.add(1, " ");
                }
            } else {
                datos.add(0, " ");
                datos.add(1, " ");
            }

      
      
            if (miCabecera.getImporteImpuestosTotalLocal() != null) {
                datos.add(2, anadirCeroFloat(miCabecera.getImporteImpuestosTotalLocal().toString()));
            } else {
                datos.add(2," ");
            }
      
            sf1.addMensaje(11,datos);   //DBLG500000514
            datos.clear();
            
            if (miCabecera.getIndImprimirPercepcion().booleanValue()) {
                if (tasaPercepcion != null && tasaPercepcion.floatValue() > 0) {
                    datos.add(0, "TOTAL A PAGAR S/.");
                    datos.add(1, nuevoTotal.toString());
                } else {
                    datos.add(0, " ");
                    datos.add(1, " ");
                }
            } else {
                datos.add(0, " ");
                datos.add(1, " ");
            }

      
            if (miCabecera.getTotalAPagarLocal()!=null) {
                datos.add(2, anadirCeroFloat(miCabecera.getTotalAPagarLocal().toString()));
            } else {
                datos.add(2," ");
            }
 
            sf1.addMensaje(12,datos);   //DBLG500000514
            datos.clear();
      
            sf1.insertarCaracterFinDePagina();
            sf1.resetearContadorLineas();
        }
    
        try {
            sf1.componerDocumento();
			sf1.saveDocument("c:\\", "Nota de Debito.txt");
			this.documento = sf1.bufferOut;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
            UtilidadesLog.debug(sf1.toString());
            
        UtilidadesLog.info("DocuNotaDebito.componerFactura(DTODocLegal datosDocLegal): Salida"); 
    }
   
   
   
    // Modificado por la BELC300015920
    public void componerFactura2()
    {
        UtilidadesLog.info("DocuNotaDebito.componerFactura2(): Entrada"); 
		// Invocación del serializador
		SerializadorDebito sf1 = new SerializadorDebito();
		// Composición de la sección 1
		//sf1.addSeccion(1);
		ArrayList datos = new ArrayList(); // Contiene objetos de tipo "dato"
		
    
    sf1.addMensaje(1,datos);
    datos.add(0,"03-139009");
    datos.add(1,"20100123763");
    sf1.addMensaje(2,datos);
    //UtilidadesLog.debug("MENSAJE Nº1");
    datos.clear();
    
    datos.add(0,"007135904");
    datos.add(1,"M200000");
    datos.add(2,"31/01/03");
    sf1.addMensaje(3,datos);
    //UtilidadesLog.debug("MENSAJE Nº2");
    datos.clear();
    
    datos.add(0,"PEREZ");
    datos.add(1,"SANCHEZ");
    datos.add(2,"ALVARO");
    datos.add(3,"JESUS");
    
    sf1.addMensaje(4,datos);
    //UtilidadesLog.debug("MENSAJE Nº3");
    datos.clear();
    
    datos.add(0,"AVENIDA");
    datos.add(1,"ILUSTRISIMA");
    datos.add(2,"6 6ºA");
    sf1.addMensaje(5,datos);
    //UtilidadesLog.debug("MENSAJE Nº4");
    datos.clear();
    
    datos.add(0,"LIMA/LIMA/EL AGUSTINO");
    datos.add(1,"MCTE928 3");
    sf1.addMensaje(6,datos);
    //UtilidadesLog.debug("MENSAJE Nº5");
    datos.clear();
    
    //sf1.addSeccion(2);
    
    datos.add(0,"PPCCCCCJ");
    datos.add(1,"ANULACION DE NOTA DE CREDITO");
    datos.add(2,"2");
    datos.add(3,"123");
    datos.add(4,"348.95");
    sf1.addMensaje(7,datos);
    //UtilidadesLog.debug("MENSAJE Nº6");
    datos.clear();
    
    //sf1.addSeccion(3);
    
    datos.add(0,"CUATROCIENTOS ONCE Y 76/100 NUEVOS SOLES");
    datos.add(1,"348.95");
    sf1.addMensaje(8,datos);
    //UtilidadesLog.debug("MENSAJE Nº7");
    datos.clear();
    
    datos.add(0,"223");
    datos.add(1,"62.81");
    sf1.addMensaje(9,datos);
    //UtilidadesLog.debug("MENSAJE Nº8");
    datos.clear();
    
    datos.add(0,"411.76");
    sf1.addMensaje(10,datos);
    //UtilidadesLog.debug("MENSAJE Nº9");
    datos.clear();
    
    // Final
		sf1.componerDocumento();
		
    try
		{
			sf1.saveDocument("c:\\", "Nota de Debito.txt");
			this.documento = sf1.bufferOut;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
            UtilidadesLog.debug(sf1.toString());
            
        UtilidadesLog.info("DocuNotaDebito.componerFactura2(): Salida"); 
    }
    
    public byte[] getDocument()
    {
        return this.documento;
    }
   
   
   public String calcularCodigoCompletoVenta(String codPeriodoEntrada, String codVenta, Float precioCatalogoUnitLocalEntrada)
    {
     UtilidadesLog.info("DocuNotaDebito.calcularCodigoCompletoVenta(String codPeriodoEntrada, String codVenta, Float precioCatalogoUnitLocalEntrada): Entrada"); 
     UtilidadesLog.debug("ESTOS SON LOS PARAMETROS QUE ME ENTRAN: " + codPeriodoEntrada+" "+codVenta+" "+precioCatalogoUnitLocalEntrada);
     
     String salida="";
     if(codPeriodoEntrada.length()>2){
     salida=codPeriodoEntrada.substring(codPeriodoEntrada.length()-2 ,codPeriodoEntrada.length());
     }
     else
     {
     salida=codPeriodoEntrada;  
     }
     
     if(codVenta.length()>5){
     salida+=codVenta.substring(0,5);
     }
     else
     {
       salida+=codVenta;
     }
     
     if(precioCatalogoUnitLocalEntrada.floatValue()==0)
     {
       salida+="0";
     }
     else
     {
       salida+="8";
     }
     
     UtilidadesLog.debug("Y ESTA ES LA SALIDA: "+ salida);
     UtilidadesLog.info("DocuNotaDebito.calcularCodigoCompletoVenta(String codPeriodoEntrada, String codVenta, Float precioCatalogoUnitLocalEntrada): Salida"); 
     return salida;
    }
   
      private Float calcularPercepcion(Float totalAPagarLocal, Float percepcion) {
        return new Float(totalAPagarLocal.floatValue() * percepcion.floatValue() / 100);
    }
}
