package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesLog;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NotaCreditoBvPeru extends DocumentoFAC 
{
 
 private byte[] documento;
    private UtilidadesLog log = new UtilidadesLog();
 
  public NotaCreditoBvPeru()
  {
  }
  
  // Modificado por la BELC300015920
   public void componerFactura(DTODocLegal datosDocLegal) {
    UtilidadesLog.info("NotaCreditoBvPeru.componerFactura(DTODocLegal datosDocLegal): Entrada"); 
    ArrayList listaPaginas=datosDocLegal.getlistaPaginas();
    SerializadorNotaCreditoBvPeru sf1 = new SerializadorNotaCreditoBvPeru();  
      
    for(int i=0;i<listaPaginas.size();i++){
      ArrayList datos = new ArrayList(); // Contiene objetos de tipo "dato"
      
      
      DTOFACDocumentoContable docuContable=(DTOFACDocumentoContable)listaPaginas.get(i);
       
      DTOFACDocumentoContableCabecera miCabecera = docuContable.getCabecera();
      
      datos.add(0, Integer.toString(i+1));
      datos.add(1, Integer.toString(listaPaginas.size()));
      sf1.addMensaje(0,datos);
      datos.clear();
      
      datos.add(0,miCabecera.getCodPeriodo());
      
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
            stringFecha = splitFechas[2] + '/' + splitFechas[1] + '/' +splitFechas[0];
        } catch(Exception e){
        }  
      datos.add(1,stringFecha);
      sf1.addMensaje(1,datos);
      datos.clear();
     
      
      if(miCabecera.getNumDocReferencia()!=null) {
        datos.add(0,miCabecera.getNumDocReferencia());
      } else {
        datos.add(0," ");
      }
      
      if(miCabecera.getCodPeriodoRefe()!=null) {
        datos.add(1,miCabecera.getCodPeriodoRefe().toString());
      } else {
        datos.add(1," ");
      }
      
      sf1.addMensaje(12,datos);
      datos.clear();
      
     
     
     
      datos.add(0, validarToString(miCabecera.getCodZona())+"-"+ validarToString(miCabecera.getCodTerritorio()));
      datos.add(1,miCabecera.getCodCliente());
      sf1.addMensaje(2,datos);
      datos.clear();
     
      String cadenaAux="";
      cadenaAux = validarToString(miCabecera.getApellido1())+" "+ validarToString(miCabecera.getApellido2())+
                    ", "+ validarToString(miCabecera.getNombre1())+" "+ validarToString(miCabecera.getNombre2());
      datos.add(0,cadenaAux);
      
      if(miCabecera.getDNI()!=null){
        datos.add(1,"DNI:"+miCabecera.getDNI());
      } else {
        datos.add(1, " ");
      }
      
      sf1.addMensaje(3,datos);
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
      sf1.addMensaje(4, datos);
      datos.clear();
      
      split = this.dividirCadena(validarToString(miCabecera.getDescripcionUbigeo()), 47);
      datos.add(0,split[0]);
      
      if (datosDocLegal.getIndOnline() != null && datosDocLegal.getIndOnline().booleanValue()) {
          datos.add(1, validarToString(miCabecera.getNumDocContableInterno()));
      } else {
          datos.add(1, "$$$$$$$$$$$$$");
      }

      if (split.length>1){
          datos.add(2,split[1]);
      }else{
          datos.add(2,"");
      }
      datos.add(3, validarToString(miCabecera.getNumConsolidado()));
      if (split.length>2){
          datos.add(4,split[2]);
      }else{
          datos.add(4,"");
      }

      sf1.addMensaje(5,datos);
      datos.clear();
      
      ArrayList misDetalles= docuContable.getDetalle();
      ArrayList listaFueraCaja= new ArrayList();
      
      sf1.addSeccion(0);
      String codigoCompleto="";
      for(int x=0;x<misDetalles.size();x++){
        DTOFACDocumentoContableDetalle miDetalle=(DTOFACDocumentoContableDetalle)misDetalles.get(x);
        UtilidadesLog.debug("El indicador dentro caja fuera bolsa es: "+miDetalle.getIndicadorDentroFueraCajaBolsa());
         if(!miDetalle.getNoImprimible()){
         if("C".equals(miDetalle.getIndicadorDentroFueraCajaBolsa())) {
              /* Agregado por Cambio FAC-003 ------ AL */
              if (miCabecera.getCodigoTipoProgramaConcurso() != null && miCabecera.getCodigoTipoProgramaConcurso().equalsIgnoreCase("B")) {
                datos.add(0, " ");
                datos.add(1, "Bonificacion otorgada por haber alcanzado el");
                datos.add(2, "volumen de compra requerido en el periodo " + miCabecera.getPeriodoInicioConcurso());
                datos.add(3, "al " + miCabecera.getPeriodoFinConcurso() + " correspondiente al programa " + miCabecera.getNumeroConcurso());
                datos.add(4, " ");
                sf1.addMensaje(13, datos); //modificado por Sapaza, fecha 12-12-2007, incidencia SiCC-20070527
                datos.clear();
              }
              /* Agregado por Cambio FAC-003 ------ AL */

                Long unidades = new Long((miDetalle.getUnidadesAtendidas().longValue()*(-1)));
                datos.add(0, validarToString(unidades));
                if(miDetalle.getDescripcionProd()!=null){
                    datos.add(1,miDetalle.getDescripcionProd());
                } else {
                    datos.add(1," ");
                }
            
                if(miDetalle.getCodigoVenta()!=null) {
                    codigoCompleto= calcularCodigoCompletoVenta(miCabecera.getCodPeriodo(),miDetalle.getCodigoVenta(),miDetalle.getPrecioCatalUnitLocal());                                                                    
                } else {
                    codigoCompleto= calcularCodigoCompletoVenta(miCabecera.getCodPeriodo(),miDetalle.getCodigoProducto(),miDetalle.getPrecioCatalUnitLocal());                                                                         
                }
                        
                datos.add(2,codigoCompleto);
                if(miDetalle.getPrecioCatalUnitLocal()!=null && miDetalle.getPrecioContUnitLocal()!=null){
                      float contAux = (miDetalle.getPrecioCatalUnitLocal().floatValue() + miDetalle.getPrecioContUnitLocal().floatValue());
                      datos.add(3,anadirCeroFloat(String.valueOf(contAux)));
                } else {
                    datos.add(3," ");  
                }
                
                if (miDetalle.getPrecioFactUnitLocal()!=null){
                    datos.add(4,anadirCeroFloat(new Float(miDetalle.getPrecioFactUnitLocal().floatValue()).toString()));
                }else{
                    datos.add(4," ");
                }
                                
                
                if(miDetalle.getPrecioFactTotalLocal()!=null) {
                    datos.add(5,anadirCeroFloat(new Float(miDetalle.getPrecioFactTotalLocal().floatValue()*(-1)).toString()));
                } else {
                    datos.add(5," ");
                }
                sf1.addMensaje(7,datos);
                datos.clear();
            } else {
                listaFueraCaja.add(miDetalle);
            }
        }             
      }
      
      sf1.addMensaje(11,new ArrayList());
          
      for(int x=0;x<listaFueraCaja.size();x++){
          DTOFACDocumentoContableDetalle miDetalle=(DTOFACDocumentoContableDetalle)listaFueraCaja.get(x);
          /* Agregado por Cambio FAC-003 ------ AL */
          if (miCabecera.getCodigoTipoProgramaConcurso() != null && miCabecera.getCodigoTipoProgramaConcurso().equalsIgnoreCase("B")) {
            datos.add(0, " ");
            datos.add(1, "Bonificacion otorgada por haber alcanzado el");
            datos.add(2, "volumen de compra requerido en el periodo " + miCabecera.getPeriodoInicioConcurso());
            datos.add(3, "al " + miCabecera.getPeriodoFinConcurso() + " correspondiente al programa " + miCabecera.getNumeroConcurso());
            datos.add(4, " ");
            sf1.addMensaje(13, datos); //modificado por Sapaza, fecha 12-12-2007, incidencia SiCC-20070527
            datos.clear();
          }
          /* Agregado por Cambio FAC-003 ------ AL */

          Long unidades = new Long(miDetalle.getUnidadesAtendidas().longValue()*(-1));
          datos.add(0, validarToString(unidades));
          if (miDetalle.getDescripcionProd()!=null) {
            datos.add(1,miDetalle.getDescripcionProd());
          } else {
            datos.add(1," ");
          }
          
          if(miDetalle.getPrecioCatalUnitLocal()!=null) {
              if(miDetalle.getCodigoVenta()!=null) {
                codigoCompleto= calcularCodigoCompletoVenta(miCabecera.getCodPeriodo(),miDetalle.getCodigoVenta(),miDetalle.getPrecioCatalUnitLocal());                                                                    
              } else {
                codigoCompleto= calcularCodigoCompletoVenta(miCabecera.getCodPeriodo(),miDetalle.getCodigoProducto(),miDetalle.getPrecioCatalUnitLocal());                                                                         
              }
          }
              
          datos.add(2,codigoCompleto);
          if(miDetalle.getPrecioCatalUnitLocal()!=null && miDetalle.getPrecioContUnitLocal()!=null){
              float contAux = (miDetalle.getPrecioCatalUnitLocal().floatValue() + miDetalle.getPrecioContUnitLocal().floatValue());
              datos.add(3,anadirCeroFloat(String.valueOf(contAux)));
          }else{
              datos.add(3," ");  
          }
          
          if (miDetalle.getPrecioFactUnitLocal()!=null){
              datos.add(4,anadirCeroFloat(new Float(miDetalle.getPrecioFactUnitLocal().floatValue()).toString()));
          }else{
              datos.add(4," ");
          }
          
          if(miDetalle.getPrecioFactTotalLocal()!=null) {
              datos.add(5,anadirCeroFloat(new Float(miDetalle.getPrecioFactTotalLocal().floatValue()*(-1)).toString()));
          }else{
              datos.add(5," ");
          }
          sf1.addMensaje(7,datos);
          datos.clear();
      }

     if ((miCabecera.getGlosa()!=null) && (miCabecera.getGlosa().trim().length()>0)) {
        String glosa = "NOTA: " + validarToString(miCabecera.getGlosa());
        datos.add(0, glosa);
     } else {
        datos.add(0,"");
     }
     sf1.addMensaje(8, datos);
     datos.clear();
     
     sf1.addSeccion(1);
     
     if(miCabecera.getNumUnidadesAtendidas()!=null){
        Integer totalAtendidas = new Integer(miCabecera.getNumUnidadesAtendidas().intValue()*(-1));
        datos.add(0,totalAtendidas.toString());
     } else {
       datos.add(0," ");
     }
     
     
     float totaVentaCata=0;
     float totalDescuento=0;
     
     if (miCabecera.getTotalAPagarLocal()==null) miCabecera.setTotalAPagarLocal(new Float(0));
     if (miCabecera.getImporteFleteTotalLocal()==null) miCabecera.setImporteFleteTotalLocal(new Float(0));
     if (miCabecera.getImporteDescuentoTotaLocal()==null) miCabecera.setImporteDescuentoTotaLocal(new Float(0));
    
     if(miCabecera.getTotalAPagarLocal()!=null && miCabecera.getImporteFleteTotalLocal()!=null&& miCabecera.getImporteDescuentoTotaLocal()!=null){
         totaVentaCata=(miCabecera.getTotalAPagarLocal().floatValue()-miCabecera.getImporteFleteTotalLocal().floatValue()+ miCabecera.getImporteDescuentoTotaLocal().floatValue())*(-1);
         datos.add(1,anadirCeroFloat(String.valueOf(totaVentaCata)));     
     }else{
         datos.add(1," ");
     }
     
     if(miCabecera.getImporteDescuentoTotaLocal()!=null){
        totalDescuento=(miCabecera.getImporteDescuentoTotaLocal().floatValue())*(-1);  
        if (totalDescuento<0.00){
            datos.add(2,'(' + anadirCeroFloat(String.valueOf(totalDescuento)));
        }else if (totalDescuento>0.00){
            datos.add(2,'(' + anadirCeroFloat(String.valueOf(totalDescuento)));
        }else{
            datos.add(2, "(0.00");
        }
     }
     else
     {
       datos.add(2," ");
     }
     
    //modificado por incidencia 21757 
    float contAux1 = (totaVentaCata-totalDescuento);
    double contAux2 = Math.rint(contAux1*100)/100;
    if (contAux2<0){
        datos.add(3,anadirCeroFloat(String.valueOf(contAux2)));
    }else if (contAux2>0.00){
        datos.add(3,anadirCeroFloat(String.valueOf(contAux2)));
    }else{
        datos.add(3,"0.00");
    }
     
     
    if(miCabecera.getImporteFleteTotalLocal()!=null){
         float contAux = (miCabecera.getImporteFleteTotalLocal().floatValue())*(-1);
         if (contAux<0.00){
            datos.add(4,anadirCeroFloat(String.valueOf(contAux)));
         }else if (contAux>0.00){
            datos.add(4,anadirCeroFloat(String.valueOf(contAux)));
         }else{
            datos.add(4,"0.00");
        }
    }else{
        datos.add(4," ");
    }
     
     sf1.addMensaje(9,datos);
     datos.clear();
     
     String res="CERO";
     if(miCabecera.getTotalAPagarLocal()!=null){
        Numtotext numero = new Numtotext(1);
        res = numero.procesar(new Float(miCabecera.getTotalAPagarLocal().floatValue()*(-1)));
     }
    String monedaAux=" ";
    if(miCabecera.getMoneda()!=null)  {
        monedaAux=miCabecera.getMoneda();
    }
    datos.add(0,res+" "+ monedaAux);
    UtilidadesLog.debug(res+" "+ monedaAux);    
    datos.add(1,"");
    
    if(miCabecera.getTotalAPagarLocal()!=null){
        /* Se modifica por Peticion de Cambio ------ Alorenzo 26/02/2007 */        
        /*float contAux= (miCabecera.getTotalAPagarLocal().floatValue()-miCabecera.getImporteFleteTotalLocal().floatValue()
                        +miCabecera.getImporteDescuentoTotaLocal().floatValue())*(-1);*/
        float contAux= (miCabecera.getTotalAPagarLocal().floatValue())*(-1);
        //float contAux= miCabecera.getTotalAPagarLocal().floatValue();
        if (contAux<0) {
            datos.add(2,anadirCeroFloat(String.valueOf(contAux)));
        } else {
            datos.add(2,anadirCeroFloat(String.valueOf(contAux)));
        } 
    } else {
        datos.add(2,"");
    }
    datos.add(3,"");
     //
     sf1.addMensaje(10,datos);
     datos.clear();
     
      sf1.insertarCaracterFinDePagina();
      sf1.resetearContadorLineas();
      
	}//fin for
        
    try {
            sf1.componerDocumento();
			sf1.saveDocument("c:\\", "notaCreditoBvPeru.txt");
			this.documento = sf1.bufferOut;
		} catch (Exception e) {
			UtilidadesLog.error("ERROR",e);
		}
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
            UtilidadesLog.debug("NotaCreditoBvPeru: "+sf1.toString());
                
      UtilidadesLog.info("NotaCreditoBvPeru.componerFactura(DTODocLegal datosDocLegal): Salida"); 
  
    }
 
   public byte[] getDocument() {
        return this.documento;
   }



public String calcularCodigoCompletoVenta(String codPeriodoEntrada, String codVenta, Float precioCatalogoUnitLocalEntrada) {     
     UtilidadesLog.info("NotaCreditoBvPeru.calcularCodigoCompletoVenta(String codPeriodoEntrada, String codVenta, Float precioCatalogoUnitLocalEntrada): Entrada"); 
     String salida="";
     if(codPeriodoEntrada.length()>2) {
       salida=codPeriodoEntrada.substring(codPeriodoEntrada.length()-2 ,codPeriodoEntrada.length());
     } else {
       salida=codPeriodoEntrada;  
     }
     
     if(codVenta.length()>5) {
       salida+=codVenta.substring(0,5);
     } else {
       salida+=codVenta;
     }
     
     if(precioCatalogoUnitLocalEntrada.floatValue()==0) {
       salida+="0";
     } else {
       salida+="8";
     }
    UtilidadesLog.info("NotaCreditoBvPeru.calcularCodigoCompletoVenta(String codPeriodoEntrada, String codVenta, Float precioCatalogoUnitLocalEntrada): Salida"); 
     return salida;
    }









}