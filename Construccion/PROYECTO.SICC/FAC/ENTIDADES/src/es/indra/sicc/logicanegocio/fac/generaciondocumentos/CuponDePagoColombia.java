package es.indra.sicc.logicanegocio.fac.generaciondocumentos;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.msg.DTOImpresion;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.Date;
import java.util.StringTokenizer;

public class CuponDePagoColombia extends DocumentoFAC {
    private byte[] documento;
    private UtilidadesLog log = new UtilidadesLog();
    
    public CuponDePagoColombia() {
    }
    
    public byte[] getDocument() {
        return this.documento;
    }
    
    public void componerFactura(DTODocLegal datosDocLegal) throws MareException {
      try {
          UtilidadesLog.info("CuponDePagoColombia.componerFactura(DTODocLegal datosDocLegal): Entrada");
          //UtilidadesLog.warn("Generando CuponDePagoColombia ...........................................");
          ArrayList listaPaginas = datosDocLegal.getlistaPaginas();
          SerializadorCuponDePagoColombia sf1 = new SerializadorCuponDePagoColombia();          
                      
          DTOFACDocumentoContable docuContable = (DTOFACDocumentoContable)listaPaginas.get(0);
          DTOFACDocumentoContableCabecera miCabecera = docuContable.getCabecera();
          DAODocuContable daoActivo = new DAODocuContable();
                    
          Date fechaVencimiento = (Date)daoActivo.obtenerFechaVencimiento(miCabecera.getOidCabeceraSolicitud());            
          
          if (fechaVencimiento == null) {
            fechaVencimiento = (Date)daoActivo.obtenerFechaFacturacionCampañaSiguiente(miCabecera.getOidPeriodo(), miCabecera.getOidZona());          
          }
          
          
          String auxFecha = null;
          String stringFecha = "";
          try {
             auxFecha = UtilidadesFecha.convertirAString(fechaVencimiento);   
             String[] splitFechas = new String[3];
             StringTokenizer st = new StringTokenizer(auxFecha, "-");
             for(int cont = 0; cont<3; cont++) {
             splitFechas[cont] = st.nextToken();
          }
            stringFecha = splitFechas[2] + '/' + splitFechas[1] + '/' + splitFechas[0];  // Las fechas van en formato dd/MM/yyyy
          } catch(Exception e){
            UtilidadesLog.error("Cupón Pago de número consolidado = " + miCabecera.getOidCabeceraSolicitud() + " no puede seleccionar fecha límite pago");
            UtilidadesLog.error("Error CuponDePagoColombia",e);
          }           

          Float saldoCC = (Float)daoActivo.obtenerSaldoCC(miCabecera.getOidCliente(), stringFecha, miCabecera.getOidPais());
            
          Float saldoCupon3 = new Float(0);  
          if (miCabecera.getDiasCruce() != null) {
            Boolean indUpdate = Boolean.TRUE;
            if (miCabecera.getIndicadorReimpresion() != null && miCabecera.getIndicadorReimpresion().booleanValue()) {
                indUpdate = Boolean.FALSE;
            }
            saldoCupon3 = (Float)daoActivo.obtenerSaldoCupon3(miCabecera.getOidCliente(), miCabecera.getOidPais(), miCabecera.getOidPeriodo(), miCabecera.getOidCabeceraSolicitud(), miCabecera.getIndicadorReimpresion(), indUpdate);            
          }
            
          Float saldoTotal = new Float(saldoCC.floatValue() - saldoCupon3.floatValue());  
          BigDecimal saldoAux = new BigDecimal(saldoTotal.intValue()).divide(new BigDecimal(100), miCabecera.getNumeroDecimales().intValue(), BigDecimal.ROUND_UP);  
          Integer saldoRedondeado = new Integer(saldoAux.intValue()*100);
          
          if (saldoRedondeado.intValue() > 0) {
              String mensa = "<frmcpc copies=" + '\u0022' + "3" + '\u0022' + ">";
    
              Parseador miParseador = Parseador.getInstance();
              sf1.addMensaje(mensa);
    
              
              Long numeroCupon = (Long)daoActivo.obtenerNumeroCuponPago();     
    
              DTOImpresion miDTO = new DTOImpresion();
              miDTO.setDatoVariable1(validarToString(numeroCupon));
              mensa = "<ncup><datoVariable01></ncup>";
              sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
    
              miDTO = new DTOImpresion();
              miDTO.setDatoVariable1(validarToString(miCabecera.getCodRegion() + miCabecera.getCodZona() + miCabecera.getCodSeccion() + miCabecera.getCodTerritorio()));
              mensa = "<cter><datoVariable01></cter>";
              sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
        
              miDTO = new DTOImpresion();
              miDTO.setDatoVariable1(validarToString(miCabecera.getCodCliente()));
              mensa = "<ccon><datoVariable01></ccon>";
              sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
        
              miDTO = new DTOImpresion();
              miDTO.setDatoVariable1(validarToString(miCabecera.getApellido1()));
              miDTO.setDatoVariable2(validarToString(miCabecera.getApellido2()));
              miDTO.setDatoVariable3(validarToString(miCabecera.getNombre1()));
              miDTO.setDatoVariable4(validarToString(miCabecera.getNombre2()));       
              mensa = "<ncon><datoVariable01> <datoVariable02> <datoVariable03> <datoVariable04></ncon>";
              sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
    
              
              miDTO = new DTOImpresion();   
              miDTO.setDatoVariable1(validarToString(this.rellenarDato(formatearDecimales(saldoRedondeado.toString()))));
              mensa = "<totapg><datoVariable01></totapg>";
              sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
    
              miDTO = new DTOImpresion();   
              miDTO.setDatoVariable1("(415)"); //Dato Fijo
              miDTO.setDatoVariable2("7709998007499"); //Dato Fijo
              miDTO.setDatoVariable3("(8020)"); //Dato Fijo
              miDTO.setDatoVariable4(validarToString(cerosIzq(miCabecera.getCodCliente(), 16)));
              miDTO.setDatoVariable5("(8020)"); //Dato Fijo
              miDTO.setDatoVariable6(validarToString(cerosIzq(numeroCupon.toString(), 8)));
              miDTO.setDatoVariable7("(3900)"); //Dato Fijo
              miDTO.setDatoVariable8(validarToString(cerosIzq(saldoRedondeado.toString(), 12)));          
              
              mensa = "<codiac><datoVariable01><datoVariable02><datoVariable03><datoVariable04><datoVariable05><datoVariable06><datoVariable07><datoVariable08></codiac>";
              sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
    
              miDTO = new DTOImpresion();   
              miDTO.setDatoVariable1("415"); //Dato Fijo
              miDTO.setDatoVariable2("7709998007499"); //Dato Fijo
              miDTO.setDatoVariable3("8020"); //Dato Fijo
              miDTO.setDatoVariable4(validarToString(cerosIzq(miCabecera.getCodCliente(), 16)));
              miDTO.setDatoVariable5("8020"); //Dato Fijo
              miDTO.setDatoVariable6(validarToString(cerosIzq(numeroCupon.toString(), 8)));
              miDTO.setDatoVariable7("F13900"); //Dato Fijo
              miDTO.setDatoVariable8(validarToString(cerosIzq(saldoRedondeado.toString(), 12)));          
              
              mensa = "<codbar><datoVariable01><datoVariable02><datoVariable03><datoVariable04><datoVariable05><datoVariable06><datoVariable07><datoVariable08></codbar>";
              sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
    
    
              sf1.addMensaje("<txcam>Campaña</txcam>");
    
              miDTO = new DTOImpresion();   
              miDTO.setDatoVariable1(validarToString(miCabecera.getCodPeriodo().substring(4, 6).toString() + "-" + miCabecera.getCodPeriodo().substring(0, 4).toString()));
              mensa = "<fcam><datoVariable01></fcam>";
              sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
              
              String mensaFinal = "</frmcpc> ";
              sf1.addMensaje(mensaFinal);
              sf1.componerDocumento();
              sf1.saveDocument("c:\\", "CuponDePagoColombia.txt");
          }

          try {            
            if (saldoRedondeado.intValue() > 0) {
                this.documento = sf1.bufferOut;
            } else {
                this.documento = new byte[0];
            }            
          } catch (Exception e) {
            e.printStackTrace();
          }
          if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
            UtilidadesLog.debug("CuponDePagoColombia: " + sf1.toString());
          UtilidadesLog.info("CuponDePagoColombia.componerFactura(DTODocLegal datosDocLegal): Salida");
           
          } catch (Exception e) {
              UtilidadesLog.error("ERROR en CuponDePagoColombia",e);
              if (e instanceof MareException){
                  throw (MareException)e;
              }
              throw new MareException(e);
          }
    }
    
    

    private String rellenarDato(String dato) {
        int lenDato = dato.length();
        if (lenDato < 14) {
           for (int i = lenDato; i < 15; i++) {
               dato = "*" + dato.toString(); 
           } 
        } 
       return dato.toString();
    }

}