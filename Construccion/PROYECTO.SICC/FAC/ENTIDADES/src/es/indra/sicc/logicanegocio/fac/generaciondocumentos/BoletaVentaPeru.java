package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BoletaVentaPeru extends DocumentoFAC 
{
 
 private byte[] documento;
 private UtilidadesLog log = new UtilidadesLog(); 
 
  public BoletaVentaPeru()
  {
  }
  
  // Modificado por la BELC300015920
    public void componerFactura(DTODocLegal datosDocLegal){
        UtilidadesLog.info("BoletaVentaPeru.componerFactura(DTODocLegal datosDocLegal): Entrada");
        ArrayList listaPaginas=datosDocLegal.getlistaPaginas();
        SerializadorBoletaVentaPeru sf1 = new SerializadorBoletaVentaPeru();  
        
        
        for(int i=0;i<listaPaginas.size();i++){
            ArrayList datos = new ArrayList(); // Contiene objetos de tipo "dato"
            
            DTOFACDocumentoContable docuContable=(DTOFACDocumentoContable)listaPaginas.get(i);
            DTOFACDocumentoContableCabecera miCabecera = docuContable.getCabecera();
            
            datos.add(0,Integer.toString(i+1));
            datos.add(1,Integer.toString(listaPaginas.size()));
            sf1.addMensaje(0,datos);
            datos.clear();
            
            datos.add(0, validarToString(miCabecera.getCodPeriodo()));
            if(miCabecera.getFechaFacturacion()!=null){
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
            }
            sf1.addMensaje(1,datos);
            datos.clear();
           
            datos.add(0,validarToString(miCabecera.getCodZona())+"-"+validarToString(miCabecera.getCodTerritorio()));
            if(miCabecera.getCodCliente()!=null){
              datos.add(1,miCabecera.getCodCliente());
            }
            sf1.addMensaje(2,datos);
            datos.clear();
           
            String cadenaAux="";
            cadenaAux = miCabecera.getApellido1()+" "+ validarToString(miCabecera.getApellido2())+", "+ 
                          validarToString(miCabecera.getNombre1())+" "+ validarToString(miCabecera.getNombre2());
            datos.add(0,cadenaAux);

            if(miCabecera.getDNI()!=null) {
              datos.add(1,"DNI:"+miCabecera.getDNI());
            } else {
              datos.add(1, " ");
            }
            
            sf1.addMensaje(3,datos);
            datos.clear();
            String direccion=" ";
            
            if (miCabecera.getNombreVia()!=null){
               direccion = miCabecera.getNombreVia();
            }
            String[] split = this.dividirCadena(direccion, 47);
            
            datos.add(0,split[0]);
            if (split.length>1) {
                datos.add(1,split[1]);
            } else {
                datos.add(1," ");
            }
            if (split.length>2) {
                datos.add(2,split[2]);
            } else {
                datos.add(2," ");
            }
            if (split.length>3) {
                datos.add(3,split[3]);
            } else {
                datos.add(3," ");
            }      
            sf1.addMensaje(4, datos);
            datos.clear();
           
            split = this.dividirCadena(validarToString(miCabecera.getDescripcionUbigeo()), 47);
            datos.add(0,split[0]);
            if (split.length>1) {
                datos.add(1,split[1]);
            } else {
                datos.add(1,"");
            }
            if (split.length>2) {
                datos.add(2,split[2]);
            } else {
                datos.add(2,"");
            }

            //jrivas 17/10/2006
            if (datosDocLegal.getIndOnline() != null && datosDocLegal.getIndOnline().booleanValue()) {
                datos.add(3, validarToString(miCabecera.getNumDocContableInterno()));
            } else {
                datos.add(3, "$$$$$$$$$$$$$");
            }

            if (split.length>3){
                datos.add(4,split[3]);
            } else {
                datos.add(4,"");
            }
            datos.add(5,validarToString(miCabecera.getNumConsolidado()));
            
            sf1.addMensaje(5,datos);
            datos.clear();
            
            ArrayList misDetalles= docuContable.getDetalle();
            ArrayList listaFueraCaja= new ArrayList();
            
            sf1.addSeccion(0);
            String codigoCompleto="";
            for(int x=0;x<misDetalles.size();x++){
                DTOFACDocumentoContableDetalle miDetalle=(DTOFACDocumentoContableDetalle)misDetalles.get(x);
                if(!miDetalle.getNoImprimible()){
                    UtilidadesLog.debug("El indicador dentro caja fuera bolsa es: "+miDetalle.getIndicadorDentroFueraCajaBolsa());
                    if("C".equals(miDetalle.getIndicadorDentroFueraCajaBolsa())) {
                        /* Agregado por Cambio FAC-003 ------ AL */
                        if (miCabecera.getCodigoTipoProgramaConcurso() != null && miCabecera.getCodigoTipoProgramaConcurso().equalsIgnoreCase("B")) {
                          datos.add(0, " ");
                          datos.add(1, "Bonificacion otorgada por haber alcanzado el");
                          datos.add(2, "volumen de compra requerido en el periodo " + miCabecera.getPeriodoInicioConcurso());
                          datos.add(3, "al " + miCabecera.getPeriodoFinConcurso() + " correspondiente al programa " + miCabecera.getNumeroConcurso());
                          datos.add(4, " ");
                          sf1.addMensaje(13, datos);
                          datos.clear();
                        }
                        /* Agregado por Cambio FAC-003 ------ AL */
                        datos.add(0, validarToString(miDetalle.getUnidadesAtendidas()));
                        if(miDetalle.getDescripcionProd()!=null){
                            datos.add(1,miDetalle.getDescripcionProd());
                        } else {
                            datos.add(1," ");
                        }
                        if(miDetalle.getCodigoVenta()!=null){
                            codigoCompleto= calcularCodigoCompletoVenta(miDetalle.getCodPeriodo(),miDetalle.getCodigoVenta(),miDetalle.getPrecioCatalUnitLocal());                                                                    
                        } else {
                            codigoCompleto= calcularCodigoCompletoVenta(miDetalle.getCodPeriodo(),miDetalle.getCodigoProducto(),miDetalle.getPrecioCatalUnitLocal());                                                                         
                        }     
                        datos.add(2,codigoCompleto);
                        
                        if(miDetalle.getPrecioCatalUnitLocal()!=null && miDetalle.getPrecioContUnitLocal()!=null){
                            datos.add(3,anadirCeroFloat(new Float(miDetalle.getPrecioCatalUnitLocal().floatValue()+miDetalle.getPrecioContUnitLocal().floatValue()).toString()));
                        } else {
                            datos.add(3," ");  
                        }
                        if (miDetalle.getPrecioFactUnitLocal()!=null) {
                            datos.add(4,anadirCeroFloat(miDetalle.getPrecioFactUnitLocal().toString()));
                        } else {
                            datos.add(4," ");
                        }
                        if(miDetalle.getPrecioFactTotalLocal()!=null) {
                            datos.add(5,anadirCeroFloat(miDetalle.getPrecioFactTotalLocal().toString()));
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
            ArrayList listaBolsa= new ArrayList();    
            
            for(int x=0;x<listaFueraCaja.size();x++){
                DTOFACDocumentoContableDetalle miDetalle=(DTOFACDocumentoContableDetalle)listaFueraCaja.get(x);
                if("F".equals(miDetalle.getIndicadorDentroFueraCajaBolsa())) {
                  /* Agregado por Cambio FAC-003 ------ AL */
                  if (miCabecera.getCodigoTipoProgramaConcurso() != null && miCabecera.getCodigoTipoProgramaConcurso().equalsIgnoreCase("B")) {
                    datos.add(0, " ");
                    datos.add(1, "Bonificacion otorgada por haber alcanzado el");
                    datos.add(2, "volumen de compra requerido en el periodo " + miCabecera.getPeriodoInicioConcurso());
                    datos.add(3, "al " + miCabecera.getPeriodoFinConcurso() + " correspondiente al programa " + miCabecera.getNumeroConcurso());
                    datos.add(4, " ");
                    sf1.addMensaje(13, datos);
                    datos.clear();
                  }
                  /* Agregado por Cambio FAC-003 ------ AL */
                  datos.add(0, validarToString(miDetalle.getUnidadesAtendidas()));
                  if (miDetalle.getDescripcionProd()!=null) {
                    datos.add(1,miDetalle.getDescripcionProd());
                  } else {
                    datos.add(1," ");
                  }
                  
                  if(miDetalle.getCodigoVenta()!=null) {
                    codigoCompleto= calcularCodigoCompletoVenta(miDetalle.getCodPeriodo(),miDetalle.getCodigoVenta(),miDetalle.getPrecioCatalUnitLocal());                                                                    
                  } else {
                    codigoCompleto= calcularCodigoCompletoVenta(miDetalle.getCodPeriodo(),miDetalle.getCodigoProducto(),miDetalle.getPrecioCatalUnitLocal());                                                                         
                  }
                              
                  datos.add(2,codigoCompleto);
                  if(miDetalle.getPrecioCatalUnitLocal()!=null && miDetalle.getPrecioContUnitLocal()!=null){
                    datos.add(3,anadirCeroFloat(new Float( miDetalle.getPrecioCatalUnitLocal().floatValue()+miDetalle.getPrecioContUnitLocal().floatValue()).toString()));
                  } else {
                    datos.add(3," ");  
                  }
                  
                  if(miDetalle.getPrecioFactUnitLocal()!=null){
                      datos.add(4,anadirCeroFloat(miDetalle.getPrecioFactUnitLocal().toString()));
                  } else {
                    datos.add(4," ");
                  }
                  
                  if(miDetalle.getPrecioSinImpuTotalLocal()!=null){
                    //datos.add(5,anadirCeroFloat(miDetalle.getPrecioSinImpuTotalLocal().toString()));
                    datos.add(5,anadirCeroFloat(miDetalle.getPrecioFactTotalLocal().toString()));
                  } else {
                    datos.add(5," ");
                  }
                  sf1.addMensaje(7,datos);
                  datos.clear();
                } else {
                  listaBolsa.add(miDetalle);
                }
            }
            sf1.addMensaje(12,new ArrayList());
            
            for(int x=0;x<listaBolsa.size();x++){
              /* Agregado por Cambio FAC-003 ------ AL */
              if (miCabecera.getCodigoTipoProgramaConcurso() != null && miCabecera.getCodigoTipoProgramaConcurso().equalsIgnoreCase("B")) {
                datos.add(0, " ");
                datos.add(1, "Bonificacion otorgada por haber alcanzado el");
                datos.add(2, "volumen de compra requerido en el periodo " + miCabecera.getPeriodoInicioConcurso());
                datos.add(3, "al " + miCabecera.getPeriodoFinConcurso() + " correspondiente al programa " + miCabecera.getNumeroConcurso());
                datos.add(4, " ");
                sf1.addMensaje(13, datos);
                datos.clear();
              }
              /* Agregado por Cambio FAC-003 ------ AL */

              DTOFACDocumentoContableDetalle miDetalle=(DTOFACDocumentoContableDetalle)listaBolsa.get(x);
              datos.add(0, validarToString(miDetalle.getUnidadesAtendidas()));
              if(miDetalle.getDescripcionProd()!=null){
                datos.add(1,miDetalle.getDescripcionProd());
              } else {
                datos.add(1," ");
              }                  
              if(miDetalle.getCodigoVenta()!=null) {
                codigoCompleto= calcularCodigoCompletoVenta(miDetalle.getCodPeriodo(),miDetalle.getCodigoVenta(),miDetalle.getPrecioCatalUnitLocal());                                                                    
              } else {
                codigoCompleto= calcularCodigoCompletoVenta(miDetalle.getCodPeriodo(),miDetalle.getCodigoProducto(),miDetalle.getPrecioCatalUnitLocal());                                                                         
              }
                              
              datos.add(2,codigoCompleto);
              if(miDetalle.getPrecioCatalUnitLocal()!=null && miDetalle.getPrecioContUnitLocal()!=null){
                datos.add(3,anadirCeroFloat(new Float( miDetalle.getPrecioCatalUnitLocal().floatValue()+miDetalle.getPrecioContUnitLocal().floatValue()).toString()));
              } else {
                datos.add(3," ");  
              }
                  
              if(miDetalle.getPrecioFactUnitLocal()!=null){
                datos.add(4,anadirCeroFloat(miDetalle.getPrecioFactUnitLocal().toString()));
              } else {
                datos.add(4," ");
              }
                  
              if(miDetalle.getPrecioSinImpuTotalLocal()!=null){
                datos.add(5,anadirCeroFloat(miDetalle.getPrecioFactTotalLocal().toString()));
              } else { 
                datos.add(5," ");
              }
              sf1.addMensaje(7,datos);
              datos.clear();
            }


            if ((miCabecera.getGlosa()!=null) && (miCabecera.getGlosa().trim().length()>0) && (!miCabecera.getGlosa().trim().equals("null"))) {
                String glosa = "NOTA: " + validarToString(miCabecera.getGlosa());
                datos.add(0, glosa);
            } else {
                datos.add(0," ");
            }
            sf1.addMensaje(8, datos);
            datos.clear();
            
            sf1.addSeccion(1);            
            
            
            if(miCabecera.getNumUnidadesAtendidas()!=null){
                datos.add(0,miCabecera.getNumUnidadesAtendidas().toString());
            } else {
                datos.add(0," ");
            }
            
            
            float totaVentaCata=0;
            float totalDescuento=0;
            
            if (miCabecera.getTotalAPagarLocal()==null) miCabecera.setTotalAPagarLocal(new Float(0));
            if (miCabecera.getImporteFleteTotalLocal()==null) miCabecera.setImporteFleteTotalLocal(new Float(0));
            if (miCabecera.getImporteDescuentoTotaLocal()==null) miCabecera.setImporteDescuentoTotaLocal(new Float(0));
    
            
            totaVentaCata=miCabecera.getTotalAPagarLocal().floatValue() - miCabecera.getImporteFleteTotalLocal().floatValue() + miCabecera.getImporteDescuentoTotaLocal().floatValue();
            BigDecimal totaVentaCata2 = new BigDecimal(totaVentaCata).setScale(2,BigDecimal.ROUND_HALF_EVEN);
            datos.add(1,anadirCeroFloat(String.valueOf(totaVentaCata2)));     
           
            totalDescuento=miCabecera.getImporteDescuentoTotaLocal().floatValue();
            datos.add(2, '(' + anadirCeroFloat(String.valueOf(totalDescuento)));    
            

            double contAux = Math.rint(new Double(totaVentaCata - totalDescuento).doubleValue()*100)/100;
            datos.add(3,anadirCeroFloat(String.valueOf(contAux))); 

            datos.add(4,anadirCeroFloat(miCabecera.getImporteFleteTotalLocal().toString()));
            
            sf1.addMensaje(9,datos);
            datos.clear();
            
            String res="CERO";
            if(miCabecera.getTotalAPagarLocal()!=null){
                Numtotext numero = new Numtotext(1);
                res = numero.procesar(miCabecera.getTotalAPagarLocal());
            }
            String monedaAux=" ";
            if(miCabecera.getMoneda()!=null){
                monedaAux=miCabecera.getMoneda();
            }

            String son = res + ' ' + monedaAux;
            String[] arraySon = new String[3];
            if (son.length() <= 53) {
                arraySon[0] = son;
                arraySon[1] = " ";
                arraySon[2] = " ";
            } else {
                arraySon[0] = son.substring(0,53);
                son = son.substring(53);
                if (son.length() <= 57) {
                    arraySon[1] = son;
                    arraySon[2] = " ";
                } else {
                    arraySon[1] = son.substring(0,57);
                    son = son.substring(57);
                    if (son.length() <= 41) {
                        arraySon[2] = son;
                    } else {
                        arraySon[2] = son.substring(0,41);
                    }
                }
            }
            
            datos.add(0, arraySon[0]);
            datos.add(1, arraySon[1]);
            
            if(miCabecera.getTotalAPagarLocal()!=null){
                datos.add(2,anadirCeroFloat(miCabecera.getTotalAPagarLocal().toString())); 
            }else{
                datos.add(2," ");
            }
            
            datos.add(3, arraySon[2]);

            Float tasaPercepcion = miCabecera.getTasaImpuestoPercepcion();
            if (miCabecera.getIndImprimirPercepcion().booleanValue()) {
                if (tasaPercepcion != null && tasaPercepcion.floatValue() > 0) {
                    float montoCalcularPerc = miCabecera.getTotalAPagarLocal().floatValue() - miCabecera.getImporteFleteTotalLocal().floatValue();
                    BigDecimal montoPercepcion = new BigDecimal(this.calcularPercepcion(new Float(montoCalcularPerc), tasaPercepcion).floatValue());
                    montoPercepcion = montoPercepcion.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                    
                    BigDecimal nuevoTotal = new BigDecimal(montoPercepcion.floatValue() + miCabecera.getTotalAPagarLocal().floatValue());
                    nuevoTotal = nuevoTotal.setScale(2, BigDecimal.ROUND_HALF_EVEN);
                    datos.add(4, "PERCEPCION " + miCabecera.getTasaImpuestoPercepcion().intValue() + '%');
                    datos.add(5, montoPercepcion.toString());
                    datos.add(6, "TOTAL A PAGAR   S/.");
                    datos.add(7, nuevoTotal.toString());
                } else {
                    datos.add(4, " ");
                    datos.add(5, " ");
                    datos.add(6, " ");
                    datos.add(7, " ");
                }
            } else {
                datos.add(4, " ");
                datos.add(5, " ");
                datos.add(6, " ");
                datos.add(7, " ");
            }
            
            sf1.addMensaje(10,datos);
            datos.clear();
            sf1.insertarCaracterFinDePagina();
            sf1.resetearContadorLineas();
        }
   
        try{
            sf1.componerDocumento();
            sf1.saveDocument("c:\\", "Boleta venta.txt");
            this.documento = sf1.bufferOut;
        }catch (Exception e){
            e.printStackTrace();
        }
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
          UtilidadesLog.debug("BoletaVentaPeru: "+sf1.toString());      
        UtilidadesLog.info("BoletaVentaPeru.componerFactura(DTODocLegal datosDocLegal): Salida");
    }
  
    public byte[] getDocument(){
        return this.documento;
    }

    public String calcularCodigoCompletoVenta(String codPeriodoEntrada, String codVenta, Float precioCatalogoUnitLocalEntrada){
        // UtilidadesLog.debug.("ESTOS SON LOS PARAMETROS QUE ME ENTRAN: " + codPeriodoEntrada+" "+codVenta+" "+precioCatalogoUnitLocalEntrada);
        UtilidadesLog.info("BoletaVentaPeru.calcularCodigoCompletoVenta(String codPeriodoEntrada, String codVenta, Float precioCatalogoUnitLocalEntrada): Entrada");
        
        String salida="";
        if(codPeriodoEntrada.length()>2){
            salida=codPeriodoEntrada.substring(codPeriodoEntrada.length()-2 ,codPeriodoEntrada.length());
        }else{
            salida=codPeriodoEntrada;  
        }
        
        if(codVenta.length()>5){
            salida+=codVenta.substring(0,5);
        }else{
            salida+=codVenta;
        }
     
        if(precioCatalogoUnitLocalEntrada!=null && (precioCatalogoUnitLocalEntrada.floatValue()!=0)) {
            salida+="8";
        } else {
            // Hablado con DT. Si es nulo, termina en 0
            salida+="0";
        }

        // UtilidadesLog.debug.("Y ESTA ES LA SALIDA: "+ salida);
        UtilidadesLog.info("BoletaVentaPeru.calcularCodigoCompletoVenta(String codPeriodoEntrada, String codVenta, Float precioCatalogoUnitLocalEntrada): Salida");
        return salida;
    }

    /**
     * Calcula el monto de percepcion a partir del total a pagar y de la tasa.
     * Creado por cambio SICC-GCC-FAC-002
     * @author dmorello
     * @date 20/10/2006
     */
    private Float calcularPercepcion(Float totalAPagarLocal, Float percepcion) {
        return new Float(totalAPagarLocal.floatValue() * percepcion.floatValue() / 100);
    }










}