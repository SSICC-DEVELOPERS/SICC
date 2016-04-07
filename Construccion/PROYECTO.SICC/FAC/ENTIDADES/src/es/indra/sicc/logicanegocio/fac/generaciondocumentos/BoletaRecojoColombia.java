package es.indra.sicc.logicanegocio.fac.generaciondocumentos;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.fac.DTODatosBoletaRecojo;
import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import es.indra.sicc.dtos.fac.DTOFACPosicionSolicitud;
import es.indra.sicc.dtos.msg.DTOImpresion;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Date;

public class BoletaRecojoColombia extends DocumentoFAC {
    private byte[] documento;
    int lineasXPagina = 14;
    private UtilidadesLog log = new UtilidadesLog();
    
    public BoletaRecojoColombia() {
    }
    
     public byte[] getDocument() {
        return this.documento;
     }
    
     /**
      * CHANGELOG
      * ---------
      * 21/07/2009 - dmorello, Cambio 20080765
      * - Se modifica llamada a DAODocuContable.validarPosicionesImprimiblesBR:
      *   ahora recibe un OID de boleta de recojo consolidado.
      * 18/09/2009 - dmorello, Cambio 20080765
      * - Se dejan de excluir las solicitudes (PED) cuyo modulo origen sea distinto de REC
      */
     public void componerFactura(DTODocLegal datosDocLegal) throws MareException {
      try{
          UtilidadesLog.info("BoletaRecojoColombia.componerFactura(DTODocLegal datosDocLegal): Entrada");
          boolean generado = false;
          ArrayList listaPaginas = datosDocLegal.getlistaPaginas();
         
          SerializadorBoletaRecojoColombia sf1 = new SerializadorBoletaRecojoColombia();
            
          DTOFACDocumentoContable docuContable = (DTOFACDocumentoContable)listaPaginas.get(0);
          DTOFACDocumentoContableCabecera miCabecera = docuContable.getCabecera();
          UtilidadesLog.debug("*** miCabecera: " + miCabecera);

          Iterator it = miCabecera.getListaSolicitudes().iterator();
          while (it.hasNext()) {
            DTOFACCabeceraSolicitud dtoCabeceraSolicitud = (DTOFACCabeceraSolicitud)it.next();             
            //if (dtoCabeceraSolicitud.getModulo().equals(new Long(ConstantesSEG.MODULO_REC))) {
              DAODocuContable daoActivo = new DAODocuContable();
              HashMap hashPosicionesImprimibles = daoActivo.validarPosicionesImprimiblesBR(miCabecera.getOidBoletaRecojoConsolidado());
              UtilidadesLog.debug("*** hashPosicionesImprimibles: " + hashPosicionesImprimibles);
              if (hashPosicionesImprimibles.size() > 0) {
                DTODatosBoletaRecojo dtoDatosBoletaRecojo = daoActivo.recuperarDatosCabeceraRecojo(dtoCabeceraSolicitud.getOidCabeceraSolicitud(), dtoCabeceraSolicitud.getTipoSolicitud());
                for (int copias = 0; copias < 2; copias++) {
                    int contPos = 0;
                    int totalPagina = 0;
                    int paginaActual = 0;
                    int totalArticulos = 0;
                    generado = true;
                    
                    Float division = new Float(new Float(hashPosicionesImprimibles.size()).floatValue() / new Float(lineasXPagina).floatValue());                    
                    if ((division.floatValue() - division.intValue()) > 0) {                  
                      totalPagina = division.intValue() + 1;
                    } else {
                      totalPagina = division.intValue();
                    }                
                    
                    Iterator itPosiciones = miCabecera.getListaDetalle().iterator();
                    UtilidadesLog.debug("*** miCabecera.getListaDetalle(): " + miCabecera.getListaDetalle());
                    while (itPosiciones.hasNext()) {
                        DTOFACPosicionSolicitud dtoFACPosicionSolicitud = (DTOFACPosicionSolicitud)itPosiciones.next();
                        if (hashPosicionesImprimibles.containsKey(dtoFACPosicionSolicitud.getOidPosicion())) {
                            totalArticulos += dtoFACPosicionSolicitud.getUnidadesAtendidas().intValue(); 
                            contPos++;
                            if (contPos == 1) {
                                String mensa = "";
                                if (copias == 0) {
                                   mensa = "<frmbro>";
                                } else {
                                   mensa = "<frmbrc>";
                                }
                                sf1.addMensaje(mensa);
                                paginaActual++;
                                this.generarBoletaRecojoCabecera(sf1, miCabecera, dtoCabeceraSolicitud.getFechaEntrega(), dtoDatosBoletaRecojo, paginaActual, totalPagina);
                            }
                            this.generarBoletaRecojoDetalle(sf1, dtoDatosBoletaRecojo, dtoFACPosicionSolicitud);
                            if (contPos == lineasXPagina && itPosiciones.hasNext()) {
                               contPos = 0;                            
                               String mensa = "</detalle>";
                               sf1.addMensaje(mensa);
                               if (copias == 0) {
                                  mensa = "</frmbro>";
                               } else {
                                  mensa = "</frmbrc>";
                               }
                               sf1.addMensaje(mensa);
                            }
                        }
                        if (!itPosiciones.hasNext()) {
                           String mensa = "</detalle>";
                           sf1.addMensaje(mensa);
                           Parseador miParseador = Parseador.getInstance();
                           DTOImpresion miDTO = new DTOImpresion();                           
                           miDTO.setDatoVariable1(validarToString(new Integer(convertirValorAbsoluto(totalArticulos))));
                           mensa = "<blqtar><datoVariable01></blqtar>";
                           sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
                           if (copias == 0) {
                              mensa = "</frmbro> ";
                           } else {
                              mensa = "</frmbrc> ";
                           }                               
                           sf1.addMensaje(mensa);                           
                        }
                    }
    
                    sf1.componerDocumento();                
                    try {
                      sf1.saveDocument("c:\\", "BoletaRecojoColombia.txt");                                        
                    } catch (Exception e) {
                      e.printStackTrace();
                    }
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                      UtilidadesLog.debug("BoletaRecojoColombia: " + sf1.toString());
                }                
              }                 
            //}
          }          
          if (!generado) {
            this.documento = new byte[0];
          } else {
            this.documento = sf1.toString().getBytes();
          }
            
          UtilidadesLog.info("BoletaRecojoColombia.componerFactura(DTODocLegal datosDocLegal): Salida"); 
          } catch (Exception e) {
              UtilidadesLog.error("ERROR en BoletaRecojoColombia",e);
              if (e instanceof MareException){
                  throw (MareException)e;
              }
              throw new MareException(e);
          }
    }
    
    /**
     * CHANGELOG
     * ---------
     * 25/09/2009 - dmorello, Cambio 20080765
     * - El contenido del tag <nfac> va en blanco cuando este CU se invoca desde REC
     *   ya que el numero de consolidado viene en blanco
     */
    private void generarBoletaRecojoCabecera (SerializadorBoletaRecojoColombia sf1, DTOFACDocumentoContableCabecera miCabecera, Date fechaRecojo, DTODatosBoletaRecojo dtoDatosBoletaRecojo, int paginaActual, int totalPaginas) {
      Parseador miParseador = Parseador.getInstance();
      String mensa = "<blqcab>";
      sf1.addMensaje(mensa);
      
      DTOImpresion miDTO = new DTOImpresion();
      miDTO.setDatoVariable1(validarToString("BR"));
      mensa = "<tipb><datoVariable01></tipb>";
      sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
      
      miDTO = new DTOImpresion();
      miDTO.setDatoVariable1(validarToString(dtoDatosBoletaRecojo.getNumeroBoleta()));
      mensa = "<nbd><datoVariable01></nbd>";
      sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

      miDTO = new DTOImpresion();
      miDTO.setDatoVariable1(validarToString(dtoDatosBoletaRecojo.getCodigoTerritorial()));
      mensa = "<cter><datoVariable01></cter>";
      sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

      miDTO = new DTOImpresion();
      miDTO.setDatoVariable1(validarToString(miCabecera.getCodCliente()));
      mensa = "<ccon><datoVariable01></ccon>";
      sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

      miDTO = new DTOImpresion();
      // Si este CU se invoca desde REC, el numero de solicitud viene en blanco
      // con lo cual el numero de factura tambien va en blanco...
      if (miCabecera.getNumeroSolicitud() != null) {
          if (miCabecera.getIndPedidoServicio().booleanValue()) {
            miDTO.setDatoVariable1(validarToString("S" + miCabecera.getNumeroSolicitud()));
          } else {
            miDTO.setDatoVariable1(validarToString(miCabecera.getNumeroSolicitud()));
          }
      } else {
          miDTO.setDatoVariable1(" ");
      }
      mensa = "<nfac><datoVariable01></nfac>";
      sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

      miDTO = new DTOImpresion();
      miDTO.setDatoVariable1(validarToString(miCabecera.getNombre1()));
      miDTO.setDatoVariable2(validarToString(miCabecera.getNombre2()));       
      miDTO.setDatoVariable3(validarToString(miCabecera.getApellido1()));
      miDTO.setDatoVariable4(validarToString(miCabecera.getApellido2()));
      mensa = "<ncon><datoVariable01> <datoVariable02> <datoVariable03> <datoVariable04></ncon>";
      sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

      miDTO = new DTOImpresion();
      miDTO.setDatoVariable1(validarToString(miCabecera.getCodPeriodo().toString()));
      mensa = "<fcam><datoVariable01></fcam>";
      sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

      miDTO = new DTOImpresion();
      miDTO.setDatoVariable1(validarToString(new Integer(paginaActual)));
      miDTO.setDatoVariable2(validarToString(new Integer(totalPaginas)));
      mensa = "<pagina>Pag <datoVariable01> / <datoVariable02></pagina>";
      sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
      
      miDTO = new DTOImpresion();
      miDTO.setDatoVariable1(validarToString(miCabecera.getMunicipio()));
      miDTO.setDatoVariable2(validarToString(miCabecera.getDepartamento()));
      mensa = "<ciudad><datoVariable01>(<datoVariable02>)</ciudad>";
      sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
     
      miDTO = new DTOImpresion();
      if (miCabecera.getTelefonoFijo() != null) {
         miDTO.setDatoVariable1(validarToString(miCabecera.getTelefonoFijo()));
      } else {
         miDTO.setDatoVariable1("");
      }
      mensa = "<telfijo><datoVariable01></telfijo>";
      sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

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
         UtilidadesLog.error("Error BoletaRecojoColombia",e);
       }
       miDTO.setDatoVariable1(stringFecha);
       mensa = "<femi><datoVariable01></femi>";
       sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

       if (fechaRecojo != null) {
          miDTO = new DTOImpresion();
          auxFecha = null;
          stringFecha = "";
          try {
             auxFecha = UtilidadesFecha.convertirAString(fechaRecojo); // Aca va la Fecha de Recojo
             String[] splitFechas = new String[3];
             StringTokenizer st = new StringTokenizer(auxFecha, "-");
             for(int cont = 0; cont<3; cont++) {
                splitFechas[cont] = st.nextToken();
             }
             stringFecha = splitFechas[2] + '/' + splitFechas[1] + '/' + splitFechas[0];  // Las fechas van en formato dd/MM/yyyy
           } catch(Exception e){
             UtilidadesLog.error("Error BoletaRecojoColombia",e);
           }
           miDTO.setDatoVariable1(stringFecha);
        } else {
           miDTO.setDatoVariable1("");
        }
        mensa = "<fent><datoVariable01></fent>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
       
        miDTO = new DTOImpresion();
        miDTO.setDatoVariable1(validarToString(miCabecera.getBarrio()));
        mensa = "<barrio><datoVariable01></barrio>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

        miDTO = new DTOImpresion();
        if (miCabecera.getTelefonoCelular() != null) {
           miDTO.setDatoVariable1(validarToString(miCabecera.getTelefonoCelular()));
        } else {
           miDTO.setDatoVariable1("");
        }
        mensa = "<telcelu><datoVariable01></telcelu>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));

        miDTO = new DTOImpresion();
        miDTO.setDatoVariable1(validarToString(this.getDtoClienteSolicitud().getDescripcionVia()) + " " + 
                                 validarToString(this.getDtoClienteSolicitud().getNombreVia()) + " " + 
                                 validarToString(this.getDtoClienteSolicitud().getNumero()) + " " +
                                 validarToString(this.getDtoClienteSolicitud().getObservaciones()));
        mensa = "<dir1><datoVariable01></dir1>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
       
       mensa = "</blqcab>";
       sf1.addMensaje(mensa);
       
       mensa = "<detalle>";
       sf1.addMensaje(mensa);
    }
    
    private void generarBoletaRecojoDetalle (SerializadorBoletaRecojoColombia sf1, DTODatosBoletaRecojo dtoDatosBoletaRecojo, DTOFACPosicionSolicitud dtoFACPosicionSolicitud) {
        Parseador miParseador = Parseador.getInstance();
        
        String mensa = "<txt><datoVariable01><t/><datoVariable02><t/><datoVariable03><t/><datoVariable04>-<datoVariable05></txt>";
        DTOImpresion miDTO = new DTOImpresion();  
        miDTO.setDatoVariable1(validarToString(new Integer(convertirValorAbsoluto(dtoFACPosicionSolicitud.getUnidadesAtendidas().intValue()))));
        miDTO.setDatoVariable2(validarToString(dtoFACPosicionSolicitud.getDecripcionSAPI18N()));
        miDTO.setDatoVariable3(validarToString(dtoDatosBoletaRecojo.getDescripcionRecojo()));
        miDTO.setDatoVariable4(validarToString(dtoDatosBoletaRecojo.getCodigoOperacion()));
        miDTO.setDatoVariable5(validarToString(dtoDatosBoletaRecojo.getNumeroReclamo()));
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
    }
  
    private int convertirValorAbsoluto (int valor) {
        if (valor < 0) {
            valor = valor * (-1);
        } 
        return valor;
    }
     
    
}