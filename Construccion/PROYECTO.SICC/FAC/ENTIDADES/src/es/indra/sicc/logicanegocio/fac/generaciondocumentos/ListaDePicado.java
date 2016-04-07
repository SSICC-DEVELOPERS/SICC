package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ape.DTOConfiguracionCentroDistribucion;
import es.indra.sicc.dtos.msg.DTOImpresion;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;
import es.indra.sicc.dtos.ape.DTOListaPicadoCabeceraFacturacion;
import es.indra.sicc.dtos.ape.DTOListaPicadoDetalleFacturacion;
import es.indra.sicc.dtos.ape.DTOCajaListaPicado;

import es.indra.sicc.logicanegocio.ape.DAOCrearListaPicado;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Collections;

public class ListaDePicado extends DocumentoFAC 
{
 private byte[] documento;
 private float lineasXHoja = 56;
 private int lineasXHojaCmp = 56;     //la ut. para comparar
 private String cantTotCaj = null;
 String cantTotPag = new String("####");
 private UtilidadesLog log = new UtilidadesLog();
    
    public ListaDePicado()
    {
    }
    
    /**
     * CHANGELOG
     * ---------
     * 01/10/2009 - dmorello, Cambio 20090839
     *    - Se agrega linea divisoria (tag <cmbZna/>) luego de cada cambio de zona en los detalles
     */
    public void componerFactura(DTOFACConsolidado datosTotales) throws MareException{
      try{
          UtilidadesLog.info("ListaDePicado.componerFactura(DTOFACConsolidado datosTotales): Entrada");
          
          DTOListaPicadoCabeceraFacturacion datosLstaPicCabecera = datosTotales.getDtoCabeceraListaPicado();
          UtilidadesLog.debug("datosLstaPicCabecera, trae: " + datosLstaPicCabecera);
          
          //sb obtenemos indicador de datos basicos cliente
          int indicadorDatosBasicosCliente = getObtenerIndicadorDatosBasicoCliente(datosLstaPicCabecera.getOidConfiguracionCD());
          
          SerializadorListaDePicado sf1 = new SerializadorListaDePicado();
          Parseador miParseador = Parseador.getInstance();
          DTOImpresion miDTO= new DTOImpresion();
          
          HashMap detallesLP = datosLstaPicCabecera.getDetalles();
          int cantCajas = detallesLP.size();
          float cantHojasXestaCaja = 0;
          float unidEnEstaCaja = 0;
          float division = 0;
          float redondeo = 0;
          cantTotCaj = String.valueOf(cantCajas);
          
          String lineaSimpleDoble = "<txt><datoVariable01><t/><datoVariable02><t/><datoVariable03><t/><datoVariable04><t/><datoVariable05><t/><datoVariable06><t/><datoVariable07><t/><datoVariable08></txt>";
          
          int pagActual = 0;
          int pagActGral = 0;
          int cantTotaPag = 0;
          
          if (cantCajas>0){
              ArrayList array = new ArrayList((Collection)detallesLP.values());
              
              //ordeno x caja!
              Collections.sort(array, new CajasComparator());
              
              Iterator it = (Iterator)array.iterator();

              //ciclo la hash, que contiene una clave x caja distinta!
              Long numeroCaja = null;
              int contadorCajas = 0;
              int sumadorTotProdPorCaja=0;
              while (it.hasNext()){
                  DTOCajaListaPicado dtoCargaInicial = (DTOCajaListaPicado)it.next();
                  UtilidadesLog.debug("dtoCargaInicial, trae: " + dtoCargaInicial);
                  
                  numeroCaja = dtoCargaInicial.getNumeroCaja();
                  ArrayList cajaTal = new ArrayList();
                  cajaTal = dtoCargaInicial.getListaPicadoDetalleFacturacion();
                  
                  //ordeno x anaquel!
                  Collections.sort(cajaTal, new AnaquelComparador());
                 
                  contadorCajas++;
                  
                  // Cambio 20090839 - Agrego tags para lineas divisorias en cambios de zona de armado
                  ArrayList cajaTalTemp = new ArrayList();
                  Integer ultimaZona = null;
                  DTOListaPicadoDetalleFacturacion dtoActual = null;
                  for (int i = 0; i < cajaTal.size(); i++) {
                      dtoActual = (DTOListaPicadoDetalleFacturacion)cajaTal.get(i);
                      UtilidadesLog.debug("i = " + i);
                      UtilidadesLog.debug("ultimaZona = " + ultimaZona);
                      UtilidadesLog.debug("dtoActual.getIdZona() = " + dtoActual.getIdZona());
                      if (ultimaZona != null) {
                          if (! ultimaZona.equals(dtoActual.getIdZona())) {
                              // Cambio la zona
                              // Se agrega un DTO a la lista para generar una linea divisoria
                              DTOListaPicadoDetalleFacturacion dtoLineaDiv = new DTOListaPicadoDetalleFacturacion();
                              dtoLineaDiv.setDescrProd("<cmbZna/>");
                              cajaTalTemp.add(dtoLineaDiv);
                              UtilidadesLog.debug("Agregue un tag de cambio de zona!");
                          }
                      }
                      ultimaZona = dtoActual.getIdZona();
                      cajaTalTemp.add(dtoActual);
                  }
                  cajaTal = cajaTalTemp; // piso la lista inicial con la temporal
                  
                  //ciclo la caja tal, si las unidades en esta caja son mayor a 0
                  
                  //agrego a los productos los 4 'totales', como si fueran 4 prods. mas
                  DTOListaPicadoDetalleFacturacion dtoLPDF = new DTOListaPicadoDetalleFacturacion();
                  dtoLPDF.setDescrProd("*** FIN ***");
                  cajaTal.add(dtoLPDF);
                  DTOListaPicadoDetalleFacturacion dtoLPDF1 = new DTOListaPicadoDetalleFacturacion();
                  dtoLPDF1.setDescrProd("Totales");
                  cajaTal.add(dtoLPDF1);
                  DTOListaPicadoDetalleFacturacion dtoLPDF2 = new DTOListaPicadoDetalleFacturacion();
                  dtoLPDF2.setDescrProd("EMBALADO POR");
                  cajaTal.add(dtoLPDF2);
                  DTOListaPicadoDetalleFacturacion dtoLPDF3 = new DTOListaPicadoDetalleFacturacion();
                  dtoLPDF3.setDescrProd("VERIFICADO POR");
                  cajaTal.add(dtoLPDF3);
                  
                  unidEnEstaCaja = cajaTal.size();
                  UtilidadesLog.debug("unidEnEstaCaja, trae: " + cajaTal.size());
                  
                  //if (unidEnEstaCaja.compareTo(new BigDecimal("0"))==1) {  //unidades en caja > 0

                  UtilidadesLog.debug("prodXcaja: " + unidEnEstaCaja);
                  int cantArtXCaja = 0;
                  if (unidEnEstaCaja>0){ //unidades en caja > 0
                      if (unidEnEstaCaja > lineasXHojaCmp){
                          division = unidEnEstaCaja/lineasXHoja;
                          redondeo = (division - new Float( division ).intValue() > 0)? new 
                                      Float ( division ).intValue() + 1 : 
                                      new Float( division ).intValue();
                          cantHojasXestaCaja = redondeo;
                      }else{
                          cantHojasXestaCaja = 1;
                      }
                      //ciclo x hojas, para esa caja..
                      UtilidadesLog.debug("cantHojasXestaCaja: " + cantHojasXestaCaja);
                      sumadorTotProdPorCaja = 0;
                      int removidos = 0;
                      pagActual = 0;
                      for (int i = 0; i < cantHojasXestaCaja; i++) {
                          pagActual++;
                          pagActGral++;
                          String descTipoCaja = ((DTOListaPicadoDetalleFacturacion)cajaTal.get(0)).getDescripcionTipoCajaEmbalaje();
                          this.escriboCabecera(sf1, 
                                               datosLstaPicCabecera,
                                               miParseador,
                                               contadorCajas,
                                               descTipoCaja,
                                               pagActGral,
                                               indicadorDatosBasicosCliente);                      
                          cantTotaPag++;                                                
                          DTOListaPicadoDetalleFacturacion linea = null;
                          DTOListaPicadoDetalleFacturacion linea2column = null;
                          
                          UtilidadesLog.debug("cantHojasXestaCaja: " + cantHojasXestaCaja);
                          //si estoy imprimiendo la ult. hoja de la caja, son 24 prods. + las 4 de "totales" (APE-06)
                          //sino, 28.
                          cantArtXCaja = cajaTal.size();
                          
                          for (int j = 0; j < 28; j++) {
                          
                              if (j>=cantArtXCaja)
                                  break;
                              
                              if ((j<cantArtXCaja)) {
                              
                                  linea=(DTOListaPicadoDetalleFacturacion)cajaTal.get(j);
                                  miDTO = new DTOImpresion();
                                  UtilidadesLog.debug("linea: " + linea);
                                  
                                  //pregunto si lo que viene en DescrProd, es alguna de las 4 lineas de totales
                                  if (linea.getDescrProd().equals("*** FIN ***")) {
                                      miDTO.setDatoVariable1("  *** ");
                                      miDTO.setDatoVariable2("  *** ");
                                      miDTO.setDatoVariable3("  *** ");
                                      miDTO.setDatoVariable4("*** FIN ***");                              
                                  } else if (linea.getDescrProd().equals("Totales")) {
                                      miDTO.setDatoVariable1(" ");
                                      miDTO.setDatoVariable2(String.valueOf(sumadorTotProdPorCaja));
                                      miDTO.setDatoVariable3(String.valueOf(dtoCargaInicial.getCantProdDifParaEstaCaja()));
                                      miDTO.setDatoVariable4("Totales");                              
                                  } else if (linea.getDescrProd().equals("EMBALADO POR")) {
                                      miDTO.setDatoVariable1(" ");
                                      miDTO.setDatoVariable2(" ");
                                      miDTO.setDatoVariable3(" ");
                                      miDTO.setDatoVariable4("EMBALADO POR");                              
                                  } else if (linea.getDescrProd().equals("VERIFICADO POR")) {
                                      miDTO.setDatoVariable1(" ");
                                      miDTO.setDatoVariable2(" ");
                                      miDTO.setDatoVariable3(" ");
                                      miDTO.setDatoVariable4("VERIFICADO POR");                              
                                  } else if (linea.getDescrProd().equals("<cmbZna/>")) {
                                      miDTO.setDatoVariable1("-----");
                                      miDTO.setDatoVariable2("--");
                                      miDTO.setDatoVariable3("--");
                                      miDTO.setDatoVariable4(" ");
                                  }else{
                                      miDTO.setDatoVariable1(linea.getNumeroAnaquel());
                                      miDTO.setDatoVariable2(linea.getUnidadesProducto().toString());
                                      miDTO.setDatoVariable3(numeroCaja.toString());
                                      miDTO.setDatoVariable4(linea.getDescrProd());    
                                      sumadorTotProdPorCaja = sumadorTotProdPorCaja + linea.getUnidadesProducto().intValue();
                                  }    
                                  cajaTal.set(j, "Remove");
                                  removidos++;
                              }    
                              if ((cantArtXCaja>(j+28))) {
                                  linea2column=(DTOListaPicadoDetalleFacturacion)cajaTal.get(j+28);    
                                  UtilidadesLog.debug("J " + j);
                                  UtilidadesLog.debug("linea2column: " + linea2column);
                                  //pregunto si lo que viene en DescrProd, es alguna de las 4 lineas de totales
                                  if (linea2column.getDescrProd().equals("*** FIN ***")) {
                                      miDTO.setDatoVariable5("  *** ");
                                      miDTO.setDatoVariable6("  *** ");
                                      miDTO.setDatoVariable7("  *** ");
                                      miDTO.setDatoVariable8("*** FIN ***");                              
                                  } else if (linea2column.getDescrProd().equals("Totales")) {
                                      miDTO.setDatoVariable5(" ");
                                      miDTO.setDatoVariable6(String.valueOf(sumadorTotProdPorCaja));
                                      miDTO.setDatoVariable7(String.valueOf(dtoCargaInicial.getCantProdDifParaEstaCaja()));
                                      miDTO.setDatoVariable8("Totales");                              
                                  } else if (linea2column.getDescrProd().equals("EMBALADO POR")) {
                                      miDTO.setDatoVariable5(" ");
                                      miDTO.setDatoVariable6(" ");
                                      miDTO.setDatoVariable7(" ");
                                      miDTO.setDatoVariable8("EMBALADO POR");                              
                                  } else if (linea2column.getDescrProd().equals("VERIFICADO POR")) {
                                      miDTO.setDatoVariable5(" ");
                                      miDTO.setDatoVariable6(" ");
                                      miDTO.setDatoVariable7(" ");
                                      miDTO.setDatoVariable8("VERIFICADO POR");                              
                                  } else if (linea2column.getDescrProd().equals("<cmbZna/>")) {
                                      miDTO.setDatoVariable5("-----");
                                      miDTO.setDatoVariable6("--");
                                      miDTO.setDatoVariable7("--");
                                      miDTO.setDatoVariable8(" ");                              
                                  }else{
                                      miDTO.setDatoVariable5(linea2column.getNumeroAnaquel());
                                      UtilidadesLog.debug("linea2column.getUnidadesProducto() " + linea2column.getUnidadesProducto());
                                      miDTO.setDatoVariable6(linea2column.getUnidadesProducto().toString());
                                      miDTO.setDatoVariable7(numeroCaja.toString());
                                      miDTO.setDatoVariable8(linea2column.getDescrProd());
                                      sumadorTotProdPorCaja = sumadorTotProdPorCaja + linea2column.getUnidadesProducto().intValue();
                                  }                                     
                                  cajaTal.set(j+28, "Remove");
                                  removidos++;
                              }   
                              
                              sf1.addMensaje(miParseador.sustituirEtiquetasVariables(lineaSimpleDoble, miDTO));
                              
                          } //28 (* 2!!), articulos
                          //this.cierroHoja(sf1, miParseador, lineaSimpleDoble, sumadorTotProdPorCaja, dtoCargaInicial);
                          
                          //si es multihoja, pero no es la ultima; cierro parcialmente, o sea sin totales!
                          if (cantHojasXestaCaja>1){
                              if (pagActual<cantHojasXestaCaja){
                                  this.cierroHoja(sf1);    
                              }
                          }
                          
                          //elimino las pos. marcadas
                          int puntero=0;
                          
                          UtilidadesLog.debug("removidos: " + removidos);
                          
                          int remociones=0;
                          while (true){
                              if (cajaTal.size()==0)
                                  break;
                              if (remociones==removidos)    
                                  break;
                              if (cajaTal.get(puntero)=="Remove"){    
                                  cajaTal.remove(puntero);
                                  remociones++;
                                  UtilidadesLog.debug("remociones: " + remociones);
                              }    
                          }
                      } //hojas
                      //salgo de la caja tal, cierro la hoja
                      //this.cierroCaja(sf1, miParseador, lineaSimpleDoble, sumadorTotProdPorCaja, dtoCargaInicial);
                      this.cierroCaja(sf1);
                   } //tengo unidades
              } //ciclo x hash de cajas   
          }
          sf1.componerDocumento(cantTotPag, String.valueOf(cantTotaPag));
            
          try{
              sf1.saveDocument("c:\\", "ListaDePicado.txt");
              this.documento = sf1.bufferOut;
          }
          catch (Exception e)
          {
            e.printStackTrace();
          }
          
          if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
              UtilidadesLog.debug("ListaDePicado: "+sf1.toString());
              
              UtilidadesLog.info("ListaDePicado.componerFactura(DTOFACConsolidado datosTotales): Salida");
           
      }catch (Exception e){
          UtilidadesLog.error("ERROR en componerFactura (ListaDePicado)",e);
          if (e instanceof MareException){
              throw (MareException)e;
          }
            throw new MareException(e);
          }

    }
    
    public byte[] getDocument()
    {
        return this.documento;
    }
    
    private void cierroHoja(SerializadorListaDePicado sf1) throws MareException{
      UtilidadesLog.info("cierroHoja(..... Entrada");                      
      String mensa="</detalle>";          
      sf1.addMensaje(mensa);                          
      mensa="</ptl> ";          
      sf1.addMensaje(mensa);    
      UtilidadesLog.info("cierroHoja(..... Salida");                      
    }
    
    private void cierroCaja(SerializadorListaDePicado sf1) throws MareException{
      String mensa="</detalle>";          
      sf1.addMensaje(mensa);                          
      mensa="</ptl>";          
      sf1.addMensaje(mensa);    
      UtilidadesLog.info("cierroCaja(..... Salida");                      
    }

    
    private void cierroCaja(SerializadorListaDePicado sf1, Parseador miParseador, 
                            String lineaSimpleDoble, int unidEnEstaCaja,
                            DTOCajaListaPicado dtoCargaInicial) throws MareException{
      UtilidadesLog.info("cierroCaja(..... Entrada");                      
      DTOImpresion miDTO= new DTOImpresion();                            
      
      //elimino interlineas, cbio.APE-06
      miDTO = new DTOImpresion();
      miDTO.setDatoVariable1("  *** ");
      miDTO.setDatoVariable2("  *** ");
      miDTO.setDatoVariable3("  *** ");
      miDTO.setDatoVariable4("*** FIN ***");                              
      miDTO.setDatoVariable5(" ");
      miDTO.setDatoVariable6(" ");
      miDTO.setDatoVariable7(" ");
      miDTO.setDatoVariable8(" ");
      sf1.addMensaje(miParseador.sustituirEtiquetasVariables(lineaSimpleDoble, miDTO));

      miDTO = new DTOImpresion();
      miDTO.setDatoVariable1(" ");
      miDTO.setDatoVariable2(String.valueOf(unidEnEstaCaja));
      miDTO.setDatoVariable3(String.valueOf(dtoCargaInicial.getCantProdDifParaEstaCaja()));
      miDTO.setDatoVariable4("Totales");                              
      miDTO.setDatoVariable5(" ");
      miDTO.setDatoVariable6(" ");
      miDTO.setDatoVariable7(" ");
      miDTO.setDatoVariable8(" ");
      sf1.addMensaje(miParseador.sustituirEtiquetasVariables(lineaSimpleDoble, miDTO));

      miDTO = new DTOImpresion();
      miDTO.setDatoVariable1(" ");
      miDTO.setDatoVariable2(" ");
      miDTO.setDatoVariable3(" ");
      miDTO.setDatoVariable4("EMBALADO POR");                              
      miDTO.setDatoVariable5(" ");
      miDTO.setDatoVariable6(" ");
      miDTO.setDatoVariable7(" ");
      miDTO.setDatoVariable8(" ");
      sf1.addMensaje(miParseador.sustituirEtiquetasVariables(lineaSimpleDoble, miDTO));

      miDTO = new DTOImpresion();
      miDTO.setDatoVariable1(" ");
      miDTO.setDatoVariable2(" ");
      miDTO.setDatoVariable3(" ");
      miDTO.setDatoVariable4("VERIFICADO POR");                              
      miDTO.setDatoVariable5(" ");
      miDTO.setDatoVariable6(" ");
      miDTO.setDatoVariable7(" ");
      miDTO.setDatoVariable8(" ");
      sf1.addMensaje(miParseador.sustituirEtiquetasVariables(lineaSimpleDoble, miDTO));
      
      String mensa="</detalle>";          
      sf1.addMensaje(mensa);                          
      mensa="</ptl>";          
      sf1.addMensaje(mensa);    
      UtilidadesLog.info("cierroCaja(..... Salida");                      
    }
    
    private void escriboCabecera(SerializadorListaDePicado sf1, 
                                 DTOListaPicadoCabeceraFacturacion datosLstaPicCabecera,
                                 Parseador miParseador,
                                 int cajaAct,
                                 String descTipoCajaAct,
                                 int pagAct,int indicadorImprmirDatosBasicos) throws MareException{
                                 
        UtilidadesLog.info("escriboCabecera(..... Entrada");
        String mensa="<ptl>";          
        sf1.addMensaje(mensa);
        DTOImpresion miDTO= new DTOImpresion();
                                 
        mensa="<blqcab>";          
        sf1.addMensaje(mensa);
        miDTO= new DTOImpresion();
        
        miDTO= new DTOImpresion();
        miDTO.setDatoVariable1(validarToString(datosLstaPicCabecera.getDescrLineaArmado()));
        //mensa = "<titulo><b><datoVariable01></b></titulo>";
        //elimino b b, cbio.APE-06
        mensa = "<titulo><datoVariable01></titulo>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
        
        miDTO= new DTOImpresion();
        String auxFecha = null;
        String stringFecha = "";
        try {
          auxFecha = UtilidadesFecha.convertirAString(datosLstaPicCabecera.getFechaFacturacion());
          String[] splitFechas = new String[3];
          StringTokenizer st = new StringTokenizer(auxFecha, "-");
          for(int cont = 0; cont<3; cont++) {
            splitFechas[cont] = st.nextToken();
          }
          stringFecha = splitFechas[2] + '/' + splitFechas[1] + '/' + splitFechas[0];  // Las fechas van en formato dd/MM/yyyy
        } catch(Exception e){
          UtilidadesLog.error("Error ListaDePicado",e);
        }
              
        miDTO.setDatoVariable1(stringFecha);
        mensa="<fec><datoVariable01></fec>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
        
        miDTO= new DTOImpresion();
        miDTO.setDatoVariable1(validarToString(datosLstaPicCabecera.getCodBarr()));
        mensa = "<nbd><datoVariable01></nbd>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
        
        miDTO= new DTOImpresion();
        miDTO.setDatoVariable1(validarToString(datosLstaPicCabecera.getCodTerritorial()));
        mensa = "<cter><datoVariable01></cter>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
        
        miDTO= new DTOImpresion();
        String aux = String.valueOf(cajaAct).concat("/").concat(cantTotCaj);
        miDTO.setDatoVariable1(validarToString(aux));
        mensa = "<caja><datoVariable01></caja>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
        
        // Cambio 20090839 - Se agrega la descripcion del tipo de caja
        miDTO= new DTOImpresion();
        miDTO.setDatoVariable1(validarToString(descTipoCajaAct));
        mensa = "<Dtipcaj><datoVariable01></Dtipcaj>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
        
        // Cambio 20090839 - Se deja lugar para el numero de secuencia, que aun no fue generado
        // Se coloca una cadena formada por tantos $ como cifras tendra el num de secuencia
        miDTO= new DTOImpresion();
        int longitud = datosLstaPicCabecera.getLongitudNumeroEtiqueta().intValue();
        UtilidadesLog.debug("longitud (para crear secuencia de $): " + longitud);
        char[] a = new char[longitud];
        for (int i = 0; i < a.length; i++) {
            a[i] = '$';
        }
        String nroUnicoCaja = validarToString(String.valueOf(a));
        UtilidadesLog.debug("nroUnicoCaja: " + nroUnicoCaja);
        miDTO.setDatoVariable1(nroUnicoCaja);
        mensa = "<NuniCj><datoVariable01></NuniCj>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
        
        miDTO= new DTOImpresion();
        String aux1 = String.valueOf(pagAct).concat("/").concat(cantTotPag);
        miDTO.setDatoVariable1(validarToString(aux1));
        mensa = "<pag><datoVariable01></pag>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
                                 
        miDTO= new DTOImpresion();
        miDTO.setDatoVariable1(validarToString(datosLstaPicCabecera.getTextoChequeo()));
        mensa = "<chk><datoVariable01></chk>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
                                 
        miDTO= new DTOImpresion();  
        miDTO.setDatoVariable1(validarToString(datosLstaPicCabecera.getTextoPrimerPedido()));
        mensa = "<ppd><datoVariable01></ppd>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
                    
        miDTO= new DTOImpresion();
        miDTO.setDatoVariable1(validarToString(datosLstaPicCabecera.getSecuencia()));
        mensa = "<zal><datoVariable01></zal>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
        
        miDTO= new DTOImpresion();
        miDTO.setDatoVariable1(validarToString(datosLstaPicCabecera.getDescrPeriodo()));
        mensa = "<fcam><datoVariable01></fcam>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
        
        miDTO= new DTOImpresion();
        if(indicadorImprmirDatosBasicos == 1)
            miDTO.setDatoVariable1(validarToString(datosLstaPicCabecera.getCodConsult()));
        else    
            miDTO.setDatoVariable1(validarToString(""));
        mensa = "<ccon><datoVariable01></ccon>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
        
        miDTO= new DTOImpresion();
        if(indicadorImprmirDatosBasicos ==1){
            String nombreConsultora = new DAOCrearListaPicado().obtenerNombrComplConsultByCodigo(datosLstaPicCabecera.getCodConsult());
            miDTO.setDatoVariable1(validarToString(nombreConsultora));
        }else{    
            miDTO.setDatoVariable1(validarToString(""));
        }   
        mensa = "<ncon><datoVariable01></ncon>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
        
        mensa="</blqcab>";          
        sf1.addMensaje(mensa);
        
        mensa="<detalle>";          
        sf1.addMensaje(mensa);                          
        
        UtilidadesLog.info("escriboCabecera(..... Salida");
    }
 /*
  * SB 19/02/2010
  * Retorna el indicado de impresion 
  * */
    private int getObtenerIndicadorDatosBasicoCliente(Long oidConfiguracionCD) throws MareException {       
       DTOConfiguracionCentroDistribucion confCD= new DAOCrearListaPicado().obtenerByIdConfiguracionCD(oidConfiguracionCD);
       return confCD.getImpresionDatosbasicos().intValue();     
    }
}
