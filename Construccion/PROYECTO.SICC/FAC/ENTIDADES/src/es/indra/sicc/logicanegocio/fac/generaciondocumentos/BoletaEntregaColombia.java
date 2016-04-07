package es.indra.sicc.logicanegocio.fac.generaciondocumentos;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.fac.DTODatosDetalleBoletaEntregaColombia;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.dtos.msg.DTOImpresion;
import java.util.ArrayList;
import java.util.Iterator;
import es.indra.sicc.util.UtilidadesFecha;
import java.util.StringTokenizer;

public class BoletaEntregaColombia extends DocumentoFAC  {
    private byte[] documento;
    int lineasXPagina = 12;
    private UtilidadesLog log = new UtilidadesLog();
    
    public BoletaEntregaColombia() {
    }
    
    public byte[] getDocument() {
      return this.documento;
    }
    
    public void componerFactura(DTODocLegal datosDocLegal) throws MareException {
      try{
          UtilidadesLog.info("BoletaEntregaColombia.componerFactura(DTODocLegal datosDocLegal): Entrada");
          ArrayList listaPaginas = datosDocLegal.getlistaPaginas();
         
          SerializadorBoletaRecojoColombia sf1 = new SerializadorBoletaRecojoColombia();
            
          DTOFACDocumentoContable docuContable = (DTOFACDocumentoContable)listaPaginas.get(0);
          DTOFACDocumentoContableCabecera miCabecera = docuContable.getCabecera();

          StringBuffer listaBoletasGeneradas = new StringBuffer();
    
            DAODocuContable daoActivo = new DAODocuContable();
            ArrayList arrayDetalles = (ArrayList)daoActivo.recuperarDatosDetalleBoletaEntregaColombia(miCabecera.getOidCabeceraSolicitud());
            Long unidadesFacturadas = (Long)daoActivo.recuperarUnidadesFacturadasBoletaEntregaColombia(miCabecera.getOidCabeceraSolicitud());
            int indicadorAnterior = 0;
            int contPos = 0;
            int totalPagina = 0;
            int paginaActual = 0;
            int totalArticulos = 0;
            Float division = new Float(new Float(arrayDetalles.size()).floatValue() / new Float(lineasXPagina).floatValue());    
            
            if ((division.floatValue() - division.intValue()) > 0) {                  
              totalPagina = division.intValue() + 1;
            } else {
              totalPagina = division.intValue();
            }                
            
            Parseador miParseador = Parseador.getInstance();  
            DTOImpresion miDTO = new DTOImpresion();
            if (miCabecera.getIndicadorReimpresion().booleanValue()) {
                miDTO.setDatoVariable1(miCabecera.getSerieDocumentoLegal() + "-" + miCabecera.getNumeroDocumentoLegal());
            } else {
                miDTO.setDatoVariable1("$$$$$$$$$$-$$$$$$$$$$");
            }
            String mensa = "<factura><datoVariable01></factura>";
            sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
            
            if (arrayDetalles.size() > 0) {
              indicadorAnterior = ((DTODatosDetalleBoletaEntregaColombia)arrayDetalles.get(0)).getIndicadorAgrupacion().intValue();
            } else {
              paginaActual++;
              totalPagina++;
              this.generarBoletaEntregaCabecera(sf1, miCabecera, paginaActual, totalPagina);
              mensa = "<detalle>";
              sf1.addMensaje(mensa);
              mensa = "<txt>UNIDADES ENTREGADAS<t/><datoVariable01></txt>";
              miDTO = new DTOImpresion();  
              miDTO.setDatoVariable1(validarToString(unidadesFacturadas));
              sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
              mensa = "</detalle>";
              sf1.addMensaje(mensa);
              miDTO.setDatoVariable1(validarToString(new Integer(totalArticulos)));
              mensa = "<blqtaf><datoVariable01></blqtaf>";
              sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
              String mensaFinal = "</frmbe> ";
              sf1.addMensaje(mensaFinal);
            }

            Iterator itDetalles = (Iterator)arrayDetalles.iterator();
            while (itDetalles.hasNext()) {                
                DTODatosDetalleBoletaEntregaColombia dtoDetalle = (DTODatosDetalleBoletaEntregaColombia)itDetalles.next();
                if (dtoDetalle.getIndicadorAgrupacion().intValue() == 1) {
                  totalArticulos += dtoDetalle.getUnidades().intValue(); 
                }
                    
                contPos++;
                if (contPos == 1) {
                    paginaActual++;
                    this.generarBoletaEntregaCabecera(sf1, miCabecera, paginaActual, totalPagina);
                    this.generarInicioDetalles(sf1, dtoDetalle, unidadesFacturadas);
                }
                if ((indicadorAnterior != dtoDetalle.getIndicadorAgrupacion().intValue())) {
                    sf1.addMensaje("<txt>ARTICULOS FUERA DE CAJA PEDIDO</txt>");
                    contPos++;
                }
                this.generarDetalles(sf1, dtoDetalle);
                if (contPos == lineasXPagina && itDetalles.hasNext()) {
                   contPos = 0;                            
                   mensa = "</detalle>";
                   sf1.addMensaje(mensa);
                   String mensaFinal = "</frmbe>";
                   sf1.addMensaje(mensaFinal);
                }
                if (!itDetalles.hasNext()) {
                   mensa = "</detalle>";
                   sf1.addMensaje(mensa);
                   miParseador = Parseador.getInstance();
                   miDTO = new DTOImpresion();                           
                   miDTO.setDatoVariable1(validarToString(new Integer(totalArticulos)));
                   mensa = "<blqtaf><datoVariable01></blqtaf>";
                   sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
                   String mensaFinal = "</frmbe> ";
                   sf1.addMensaje(mensaFinal);                           
                }
                indicadorAnterior = dtoDetalle.getIndicadorAgrupacion().intValue();
            }
    
            sf1.componerDocumento();                
            try {
              sf1.saveDocument("c:\\", "BoletaEntregaColombia.txt");                  
              listaBoletasGeneradas.append(sf1.toString());
            } catch (Exception e) {
              e.printStackTrace();
            }
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
              UtilidadesLog.debug("BoletaEntregaColombia: " + sf1.toString());
          
            this.documento = listaBoletasGeneradas.toString().getBytes();
            
          UtilidadesLog.info("BoletaEntregaColombia.componerFactura(DTODocLegal datosDocLegal): Salida"); 
          } catch (Exception e) {
              UtilidadesLog.error("ERROR en BoletaEntregaColombia",e);
              if (e instanceof MareException){
                  throw (MareException)e;
              }
              throw new MareException(e);
          }
    }
    
    private void generarBoletaEntregaCabecera (SerializadorBoletaRecojoColombia sf1, DTOFACDocumentoContableCabecera miCabecera, int paginaActual, int totalPaginas) {
      Parseador miParseador = Parseador.getInstance();
      String mensa = "<frmbe>";
      sf1.addMensaje(mensa);

      mensa = "<blqcab>";
      sf1.addMensaje(mensa);
      
      DTOImpresion miDTO = new DTOImpresion();
      miDTO.setDatoVariable1(validarToString("BF"));
      mensa = "<tipb><datoVariable01></tipb>";
      sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
      
      miDTO = new DTOImpresion();
      miDTO.setDatoVariable1(validarToString(miCabecera.getNumeroSolicitud()));
      mensa = "<nbd><datoVariable01></nbd>";
      sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
    
      miDTO = new DTOImpresion();
      miDTO.setDatoVariable1(validarToString(miCabecera.getCodRegion() + miCabecera.getCodZona() + miCabecera.getCodSeccion() + cerosIzq(miCabecera.getCodTerritorio(), 6)));
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
      miDTO.setDatoVariable1(validarToString(miCabecera.getCodPeriodo().substring(4, 6).toString() + "-" + miCabecera.getCodPeriodo().substring(0, 4).toString()));
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

       if (miCabecera.getFechaEntrega() != null) {
          miDTO = new DTOImpresion();
          auxFecha = null;
          stringFecha = "";
          try {
             auxFecha = UtilidadesFecha.convertirAString(miCabecera.getFechaEntrega()); // Aca va la Fecha de Recojo
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
        
       miDTO = new DTOImpresion();
       miDTO.setDatoVariable1(validarToString(miCabecera.getPrimerPedido()));
       mensa = "<tcon><datoVariable01></tcon>";
       sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
       
       mensa = "</blqcab>";
       sf1.addMensaje(mensa);
    }
    
    private void generarInicioDetalles (SerializadorBoletaRecojoColombia sf1, DTODatosDetalleBoletaEntregaColombia dtoDetalle, Long unidadesFacturadas) {
       Parseador miParseador = Parseador.getInstance();
       String mensa = "<detalle>";
       sf1.addMensaje(mensa);
       
       mensa = "<txt>UNIDADES ENTREGADAS<t/><datoVariable01></txt>";
       DTOImpresion miDTO = new DTOImpresion();  
       miDTO.setDatoVariable1(validarToString(unidadesFacturadas));
       sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
    
       miDTO = new DTOImpresion();  
       mensa = "<txt><datoVariable01></txt>";
       if (dtoDetalle.getIndicadorAgrupacion().intValue() == 0) {
          miDTO.setDatoVariable1(validarToString("POSTVENTA DENTRO DE CAJA DE PEDIDO"));
       } else {
          miDTO.setDatoVariable1(validarToString("ARTICULOS FUERA DE CAJA PEDIDO"));
       }
       sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
    }
    
    private void generarDetalles (SerializadorBoletaRecojoColombia sf1, DTODatosDetalleBoletaEntregaColombia dtoDetalle) {
       Parseador miParseador = Parseador.getInstance();
       String mensa = "<txt><datoVariable01><t/><datoVariable02><t/><datoVariable03></txt>";
       DTOImpresion miDTO = new DTOImpresion();  
       miDTO.setDatoVariable1(validarToString(dtoDetalle.getUnidades()));
       miDTO.setDatoVariable2(validarToString(dtoDetalle.getDescProducto()));
       miDTO.setDatoVariable3(validarToString(dtoDetalle.getDescModulo()));
       sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
       
    }   
    
    private void insertarDatosBoletaGenerada (int totalPagina, Long oidCabeceraSolicitud, Long idSpool) throws Exception {
        UtilidadesLog.info("BoletaEntregaColombia.insertarDatosBoletaGenerada(int totalPagina, Long oidCabeceraSolicitud, Long idSpool): Entrada");
        StringBuffer query = new StringBuffer();        
        query.append("INSERT INTO FAC_DOCUM_BOLET_ENTRE ( ");
        query.append(" OID_DOCU_BOLE_ENTR, "); 
        query.append(" VAL_CANT_PAGI, ");
        query.append(" SOCA_OID_SOLI_CABE, "); 
        query.append(" GSPO_OID_SPOO) "); 
        query.append(" VALUES ( ");
        query.append(" FAC_DBEN_SEQ.NEXTVAL, ");
        query.append(totalPagina).append(",");
        query.append(oidCabeceraSolicitud).append(",");
        query.append(idSpool).append(");");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();         
        bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", query.toString());
        UtilidadesLog.info("BoletaEntregaColombia.insertarDatosBoletaGenerada(int totalPagina, Long oidCabeceraSolicitud, Long idSpool): Salida");
    }
}