package es.indra.sicc.logicanegocio.fac.generaciondocumentos;


import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.fac.DTODatosProgramasIncentivos;
import es.indra.sicc.dtos.fac.DTOFACPosicionSolicitud;
import es.indra.sicc.dtos.msg.DTOImpresion;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BoletaDeDespacho extends DocumentoFAC 
{
 private byte[] documento;
    private UtilidadesLog log = new UtilidadesLog();
    
    public BoletaDeDespacho(){
    }

    /**
     * CHANGELOG
     * ---------
     * 02/06/2009 - dmorello, Cambio 20090923
     *     - El contenido del tag <cter> pasa a ser <seccion>-<territorio>
     * 19/06/2009 - dmorello, Cambio 20090900
     *     - Se modifica el indicador dentro/fuera caja/bolsa segun flag
     *       "imprimirProdFueraCajaBolsa" recibido en el DTO de entrada
     */
    public void componerFactura(DTODocLegal datosDocLegal) throws MareException{
      try{
          UtilidadesLog.info("BoletaDeDespacho.componerFactura(DTODocLegal datosDocLegal): Entrada");
          //UtilidadesLog.warn("Boleta de Despacho");
          
          ArrayList listaPaginas=datosDocLegal.getlistaPaginas();
      
          SerializadorBoletaDeDespacho sf1 = new SerializadorBoletaDeDespacho();
            
          ArrayList datos = new ArrayList(); // Contiene objetos de tipo "dato"
            
          DTOFACDocumentoContable docuContable=(DTOFACDocumentoContable)listaPaginas.get(0);
          DTOFACDocumentoContableCabecera miCabecera = docuContable.getCabecera();
          
          


          DTOImpresion miDTO= new DTOImpresion();
          String mensa="<frmbd> <pbd1>";

          Parseador miParseador= Parseador.getInstance();
          sf1.addMensaje(mensa);

          miDTO= new DTOImpresion();
          miDTO.setDatoVariable1(validarToString(miCabecera.getNumeroSecuenciaFacturacionDiaria()));
          mensa = "<blqcab><nsec><datoVariable01></nsec>";
          sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
 
          UtilidadesLog.debug("Boleta Despacho - Indicador Revision --> " + miCabecera.getIndicadorRevision());             
          String chequeo = "";
          
          // sapaza -- PER-SiCC-2011-0213 -- 11/04/2011
          /*DAODocuContable daoActivo = new DAODocuContable();
          Integer totalChequeos = daoActivo.obtenerTotalChequeos(miCabecera.getNumeroSolicitud(), miCabecera.getCodPeriodo());
              
          // sapaza -- PER-SiCC-2010-0140 -- 28/02/2011
          if(totalChequeos.intValue() > 0) {
             chequeo = "PEDIDO A CHEQUEAR";
             mensa = "<chq op=\"1\"><datoVariable01></chq>";   
          } else {*/
             mensa = "<chq><datoVariable01></chq>";
          //}


          miDTO= new DTOImpresion();
          miDTO.setDatoVariable1(validarToString(chequeo));
          mensa = "<chq><datoVariable01></chq>";
          sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
 
 
          miDTO= new DTOImpresion();
          miDTO.setDatoVariable1(validarToString(this.getDtoClienteSolicitud().getCodigoCliente()));
          mensa="<ccon><datoVariable01></ccon>";
          sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
          
          miDTO= new DTOImpresion();
          miDTO.setDatoVariable1(validarToString(this.getDtoClienteSolicitud().getNombre()));
          mensa="<ncon><datoVariable01></ncon>";
          sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
              
          miDTO= new DTOImpresion();
          miDTO.setDatoVariable1(validarToString(this.getDtoClienteSolicitud().getCodZona()));
          mensa="<czon><datoVariable01></czon>";
          sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
              
          miDTO= new DTOImpresion();
          String seccTerr = this.getDtoClienteSolicitud().getCodSeccion() + " - "
                          + this.getDtoClienteSolicitud().getCodTerritorio();
          miDTO.setDatoVariable1(validarToString(seccTerr));
          mensa="<cter><datoVariable01></cter>";
          sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
              
          miDTO= new DTOImpresion();
          miDTO.setDatoVariable1(validarToString(this.getDtoClienteSolicitud().getDescripcionVia()) + " " + 
                                 validarToString(this.getDtoClienteSolicitud().getNombreVia()) + " " + 
                                 validarToString(this.getDtoClienteSolicitud().getNumero()) + " " +
                                 validarToString(this.getDtoClienteSolicitud().getObservaciones()));
          mensa="<dir1><datoVariable01></dir1>";
          sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
              
          miDTO= new DTOImpresion();
          miDTO.setDatoVariable1(validarToString(this.getDtoClienteSolicitud().getDescripcionUbigeo()));
          mensa="<dir2><datoVariable01></dir2>";
          sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
              
 
          miDTO= new DTOImpresion();
          miDTO.setDatoVariable1(validarToString(validarToString(miCabecera.getNumeroSolicitud())));
          mensa="<nbd><datoVariable01></nbd>";
          sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
              
          miDTO= new DTOImpresion();
          String periodo = validarToString(miCabecera.getCodPeriodo());
          miDTO.setDatoVariable1(periodo.substring(4) + '/' + periodo.substring(0,4));
          mensa="<fcam><datoVariable01></fcam>";
          sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
              
          miDTO= new DTOImpresion();
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
            UtilidadesLog.error("Error BoletaDeDespacho",e);
          }
              
          miDTO.setDatoVariable1(stringFecha);
          mensa="<femi><datoVariable01></femi>";
          sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
              
          miDTO= new DTOImpresion();
          mensa="</blqcab>";
          sf1.addMensaje(mensa); 
              
          miDTO= new DTOImpresion();
          miDTO.setDatoVariable1(validarToString(miCabecera.getNumUnidadesAtendidas()));

          BigDecimal nuevoTotal = new BigDecimal(miCabecera.getTotalAPagarLocal().floatValue());
          nuevoTotal = nuevoTotal.setScale(2, BigDecimal.ROUND_HALF_EVEN);
          miDTO.setDatoVariable2(nuevoTotal.toString());  
              
          miDTO.setDatoVariable3(" ");
          miDTO.setDatoVariable4(" ");
          miDTO.setDatoVariable5(" ");
          mensa="<blqimp><txt><datoVariable01></txt>";
          mensa+="<txt/>";
          mensa+="<txt><datoVariable02></txt>";
          mensa+="<txt/>";
          mensa+="<txt><datoVariable03></txt>";
          mensa+="<txt><datoVariable04></txt>";
          mensa+="<txt/>";
          mensa+="<txt><datoVariable05></txt>";
          mensa+="</blqimp>";
          sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
              
              
          miDTO= new DTOImpresion();              
          String unidadesFueraCaja="";
          boolean unidadesEnBolsa = false;
          sf1.addMensaje("<detalle>");          
              
          if ((miCabecera.getUnidadesEnBolsa().intValue() + miCabecera.getUnidadesFueraCaja().intValue() + miCabecera.getUnidadesPremiosCaja().intValue()) > 0){
            unidadesFueraCaja = new Integer(miCabecera.getUnidadesEnBolsa().intValue() + miCabecera.getUnidadesFueraCaja().intValue() + miCabecera.getUnidadesPremiosCaja().intValue()).toString();
            miDTO.setDatoVariable1(unidadesFueraCaja);
            mensa = "<txt>SE ADJUNTAN  <datoVariable01> UNIDADES FUERA DE LA CAJA Y/O PREMIOS</txt>"; 
            sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
            unidadesEnBolsa = true;
          }
          
          boolean cerrarPagina = true;    
          int contadorPaginas = 1;
          DTOFACPosicionSolicitud detalle;
          ArrayList detalles = miCabecera.getListaDetalle();            

          int det = detalles.size();

          if (unidadesEnBolsa) {
            // Obtengo el flag que indica si imprimo los premios como fuera caja/bolsa
            UtilidadesLog.debug("miCabecera.getIndImpresionProdFueraCajaBolsa(): " + miCabecera.getIndImpresionProdFueraCajaBolsa());
            boolean imprimirProduFueraCajaBolsa = false;
            if (miCabecera.getIndImpresionProdFueraCajaBolsa() != null
                    && miCabecera.getIndImpresionProdFueraCajaBolsa().booleanValue()) {
                imprimirProduFueraCajaBolsa = true;
            }
            
            UtilidadesLog.debug("imprimirProduFueraCajaBolsa: " + imprimirProduFueraCajaBolsa);
          
          
            sf1.addMensaje("<txt>SIRVASE VERIFICAR: </txt>");                  
            sf1.addMensaje("<txt>UNID<t/>IND<t/>DESCRIPCION DE PRODUCTO<t/><t/><t/><t/><t/><t/><t/>UNID<t/>IND<t/>DESCRIPCION DE PRODUCTO</txt>");            
        
            
            int cantidadLineasXPaginaUno = 28;                        
            int cantidadLineasXPaginaSig = 28;                        
            for (int i=0 ; i < det;i++) {
              miDTO = new DTOImpresion();   
              detalle = (DTOFACPosicionSolicitud)detalles.get(i);
              mensa = "<txt><datoVariable01><t/><datoVariable02><t/><datoVariable03><t/><t/><t/><t/><t/><t/><t/><datoVariable04><t/><datoVariable05><t/><datoVariable06></txt>";
              miDTO.setDatoVariable1(detalle.getUnidadesAtendidas().toString());
              
              // Cambio 20090900 - dmorello, 19/06/2009
              UtilidadesLog.debug("detalle.getIndicadorDentroFueraCajaBolsa(): " + detalle.getIndicadorDentroFueraCajaBolsa());
              UtilidadesLog.debug("detalle.getCodigoTipoProgramaConcurso(): " + detalle.getCodigoTipoProgramaConcurso());
              if (imprimirProduFueraCajaBolsa) {
                  if (detalle.getIndicadorDentroFueraCajaBolsa() != null
                        && (detalle.getIndicadorDentroFueraCajaBolsa().equals("F") || detalle.getIndicadorDentroFueraCajaBolsa().equals("B"))) {
                      miDTO.setDatoVariable2(detalle.getIndicadorDentroFueraCajaBolsa().toString());
                  } else {
                      miDTO.setDatoVariable2("P");
                  }
              } else {
                  if (detalle.getIndicadorDentroFueraCajaBolsa() != null
                        && (detalle.getIndicadorDentroFueraCajaBolsa().equals("F") || detalle.getIndicadorDentroFueraCajaBolsa().equals("B"))) {
                      if (detalle.getCodigoTipoProgramaConcurso() != null) {
                          miDTO.setDatoVariable2("P");
                      } else {
                          miDTO.setDatoVariable2(detalle.getIndicadorDentroFueraCajaBolsa().toString());
                      }
                  } else {
                      if (detalle.getCodigoTipoProgramaConcurso() != null) {
                          miDTO.setDatoVariable2("D");
                      } else {
                          miDTO.setDatoVariable2(detalle.getIndicadorDentroFueraCajaBolsa().toString());
                      }
                  }
              }
              // Fin Cambio 20090900 - dmorello, 19/06/2009
              
              if (detalle.getDecripcionSAPI18N() != null) {
                if (detalle.getDecripcionSAPI18N().length() > 40) {
                  miDTO.setDatoVariable3(detalle.getDecripcionSAPI18N().substring(0, 40));
                } else {
                  miDTO.setDatoVariable3(detalle.getDecripcionSAPI18N().toString());                  
                }
              } else {
                miDTO.setDatoVariable3(" ");
              }
              i++;
              if (i < det) {
                detalle = (DTOFACPosicionSolicitud)detalles.get(i);
                miDTO.setDatoVariable4(detalle.getUnidadesAtendidas().toString());
               // Cambio 20090900 - dmorello, 19/06/2009
                if (imprimirProduFueraCajaBolsa) {
                    if (detalle.getIndicadorDentroFueraCajaBolsa() != null
                          && (detalle.getIndicadorDentroFueraCajaBolsa().equals("F") || detalle.getIndicadorDentroFueraCajaBolsa().equals("B"))) {
                        miDTO.setDatoVariable5(detalle.getIndicadorDentroFueraCajaBolsa().toString());
                    } else {
                        miDTO.setDatoVariable5("P");
                    }
                } else {
                    if (detalle.getIndicadorDentroFueraCajaBolsa() != null
                          && (detalle.getIndicadorDentroFueraCajaBolsa().equals("F") || detalle.getIndicadorDentroFueraCajaBolsa().equals("B"))) {
                        if (detalle.getCodigoTipoProgramaConcurso() != null) {
                            miDTO.setDatoVariable5("P");
                        } else {
                            miDTO.setDatoVariable5(detalle.getIndicadorDentroFueraCajaBolsa().toString());
                        }
                    } else {
                        if (detalle.getCodigoTipoProgramaConcurso() != null) {
                            miDTO.setDatoVariable5("D");
                        } else {
                            miDTO.setDatoVariable5(detalle.getIndicadorDentroFueraCajaBolsa().toString());
                        }
                    }
                }
               // Fin Cambio 20090900 - dmorello, 19/06/2009
               if (detalle.getDecripcionSAPI18N() != null) {
                  if (detalle.getDecripcionSAPI18N().length() > 40) {
                    miDTO.setDatoVariable6(detalle.getDecripcionSAPI18N().substring(0, 40));
                  } else {
                    miDTO.setDatoVariable6(detalle.getDecripcionSAPI18N().toString());
                  }
                } else {
                  miDTO.setDatoVariable6(" ");
                }  
              } else {
                miDTO.setDatoVariable4(" ");
                miDTO.setDatoVariable5(" ");
                miDTO.setDatoVariable6(" ");                 
              }
              sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
              int cantidadLineasXPagina;
              if (contadorPaginas == 1){
                cantidadLineasXPagina = cantidadLineasXPaginaUno;
              } else {
                cantidadLineasXPagina = cantidadLineasXPaginaSig;
              }              
              if (cantidadLineasXPagina == ((i/2)/contadorPaginas)){
                if (contadorPaginas == 1) {
                  sf1.addMensaje("</detalle>");
                  sf1.addMensaje("</pbd1>");
                  cerrarPagina = false;                  
                } else {
                  sf1.addMensaje("</detalle>");
                  sf1.addMensaje("</pbds>");  
                  cerrarPagina = false;
                }
                if (i + 1 < det) {
                  sf1.addMensaje("<pbds>");
                  sf1.addMensaje("<detalle>");    
                  sf1.addMensaje("<txt>UNID<t/>IND<t/>DESCRIPCION DE PRODUCTO<t/><t/><t/><t/><t/><t/><t/>UNID<t/>IND<t/>DESCRIPCION DE PRODUCTO</txt>");                  
                  cerrarPagina = true;
                }
                contadorPaginas++;
              }
            }
          }
          
          if (cerrarPagina){
            if (contadorPaginas == 1) {
               sf1.addMensaje("</detalle>");
               sf1.addMensaje("</pbd1>");
            } else {
               sf1.addMensaje("</detalle>");
               sf1.addMensaje("</pbds>");  
            }
          }   
          
          HashMap hashDatosPremios = (HashMap)miCabecera.getHashDatosPremios();
          
          for (int i=0 ; i < det;i++) {
            detalle = (DTOFACPosicionSolicitud)detalles.get(i);
            if (detalle.getCodigoTipoProgramaConcurso() != null && detalle.getCodigoTipoProgramaConcurso().equals("C")) {
              if (hashDatosPremios.containsKey(detalle.getOidCabecera())) { 
                DTODatosProgramasIncentivos dtoDatos = (DTODatosProgramasIncentivos)hashDatosPremios.get(detalle.getOidCabecera());
                if ( detalle.getPrecioContableUL().floatValue() >= dtoDatos.getImporteTipoPrograma().floatValue()) {
                  miDTO = new DTOImpresion();
                  mensa = "<frmcargo><concurso><datoVariable01></concurso><cventas><datoVariable02></cventas><nombre><datoVariable03></nombre><dni><datoVariable04></dni>";
                  mensa += "<direccion><datoVariable05></direccion><premio><datoVariable06></premio><cantidad><datoVariable07></cantidad></frmcargo>";
                  miDTO.setDatoVariable1(validarToString(dtoDatos.getNumeroConcurso()));
                  miDTO.setDatoVariable2(validarToString(dtoDatos.getNombreConcurso()));
                  miDTO.setDatoVariable3(validarToString(this.getDtoClienteSolicitud().getNombre()));
                  miDTO.setDatoVariable4(validarToString(dtoDatos.getDNI()));
                  miDTO.setDatoVariable5(validarToString(this.getDtoClienteSolicitud().getDescripcionVia()) + " " + 
                                 validarToString(this.getDtoClienteSolicitud().getNombreVia()) + " " + 
                                 validarToString(this.getDtoClienteSolicitud().getNumero()) + " " +
                                 validarToString(this.getDtoClienteSolicitud().getObservaciones()));
                  if (detalle.getDecripcionSAPI18N() != null) {
                    if (detalle.getDecripcionSAPI18N().length() > 40) {
                      miDTO.setDatoVariable6(detalle.getDecripcionSAPI18N().substring(0, 40));
                    } else {
                      miDTO.setDatoVariable6(detalle.getDecripcionSAPI18N().toString());
                    }
                  } else {
                    miDTO.setDatoVariable6(" ");
                  }  
                  miDTO.setDatoVariable7(validarToString(detalle.getUnidadesAtendidas()));
                  sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
                }
              } else {
                UtilidadesLog.info("No se genera el formulario de cargo en la Boleta de Despacho porque No existe un concurso asociado a la Solicitud = " + detalle.getOidCabecera());
              }    
            }      
          }
          
            
          
          
          
          String mensaFinal="</frmbd>";
          sf1.addMensaje(mensaFinal);
          sf1.componerDocumento();
            
          try {
            sf1.saveDocument("c:\\", "boletaDeDespacho.txt");
            this.documento = sf1.bufferOut;
          } catch (Exception e) {
            e.printStackTrace();
          }
          if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
            UtilidadesLog.debug("BoletaDeDespacho: "+sf1.toString());
            
          UtilidadesLog.info("BoletaDeDespacho.componerFactura(DTODocLegal datosDocLegal): Salida");
           
          } catch (Exception e) {
              UtilidadesLog.error("ERROR en datosClienteHelper",e);
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
    
    
}