package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ccc.DTOTotal;
import es.indra.sicc.dtos.cra.ConstantesCRA;
import es.indra.sicc.dtos.msg.DTOImpresion;
import es.indra.sicc.logicanegocio.ccc.MONInterfaceModulos;
import es.indra.sicc.logicanegocio.ccc.MONInterfaceModulosHome;
import es.indra.sicc.logicanegocio.cra.DAOCRA;
import es.indra.sicc.logicanegocio.cra.MONCronograma;
import es.indra.sicc.logicanegocio.cra.MONCronogramaHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesFecha;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Timestamp;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.ejb.CreateException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;

public class CuponDePagoPeru extends DocumentoFAC 
{
 private byte[] documento;
 private Context ctx = null;
 
 private static Hashtable periodoSiguiete = new Hashtable();
 private static Hashtable fechasVencimientos = new Hashtable();
 private UtilidadesLog log = new UtilidadesLog();
    
 public static void borrarVariablesStaticas(){
   if (periodoSiguiete != null){
     periodoSiguiete = new Hashtable();
   }
   if (fechasVencimientos != null) {
     fechasVencimientos = new Hashtable();
   }
 }
 
  public CuponDePagoPeru()
  {
      if (periodoSiguiete == null){
        periodoSiguiete = new Hashtable();
      }
      if (fechasVencimientos == null) {
        fechasVencimientos = new Hashtable();
      }
  }

// Modificado por la BELC300012000. BELC300015516
public void componerFactura(DTODocLegal datosDocLegal) throws MareException
    {

    UtilidadesLog.info("CuponDePagoPeru.componerFactura(DTODocLegal datosDocLegal): Entrada");
     
    ArrayList listaPaginas=datosDocLegal.getlistaPaginas();

    /*IMPORTANTE!!! ESTE MÉTODO HAY QUE LLAMARLO DEL MONInterfaceModulos. De momento se devuelve una constante
    Float 
    =calcularSaldosCuentaCorriente(pais,codCliente);
    */
 
    // Añadido por la BELC300012000
    try{
      this.ctx = new InitialContext();
    }catch(NamingException e){
//      String error = CodigosError.
        throw new MareException(e);
    }

    /*MONInterfaceModulos monInterfaceModulos = null;
    monInterfaceModulos = this.getMONInterfaceModulos();*/
    
    MONCronograma monCronograma = null;
    monCronograma = this.getMONCronograma();

    Double saldoCuentaCorriente = null;
    DTOTotal dtoTotal = null;
    


    Double saldoAnterior=null;

    SerializadorCuponDePagoPeru sf1 = new SerializadorCuponDePagoPeru();
    
    
    // Modificado por la BELC300012000
    // Si es null se encarga monInterfaceModulos.calcularSaldoCCCliente lanzar la excepcion
    DTOFACDocumentoContable docuContable=(DTOFACDocumentoContable)listaPaginas.get(0);
    DTOFACDocumentoContableCabecera miCabecera = docuContable.getCabecera();
    
    /*DTOSaldosPorFechasyVtos dtoSaldos = new DTOSaldosPorFechasyVtos();
    if(miCabecera.getOidCliente()!=null) {
      dtoSaldos.setOidCliente(new Long(miCabecera.getOidCliente().intValue()));
    }
    dtoSaldos.setOidIdioma(miCabecera.getOidIdioma());
    dtoSaldos.setOidPais(miCabecera.getOidPais());*/
    
    dtoTotal = obtenerSaldoCliente(miCabecera.getOidPais(), miCabecera.getOidCliente(), null);
    saldoCuentaCorriente = new Double(dtoTotal.getTotal().doubleValue());
  
    // Modificado por hsanchez tras hablar con gmamano
    saldoAnterior = calcularSaldoAnterior(datosDocLegal, saldoCuentaCorriente);
    //saldoAnterior = new Float (3.3);
  
   
    DAOCRA daoCra= new DAOCRA();
    Long oidPeriodo=null;
    ArrayList fechasCra = null;//añadido por incidencia 11135
    //DTOClienteSolicitud dtoClienteSolicitud = null;
    //DatosClienteHelper datosClienteHelper = new DatosClienteHelper();
    for(int i=0;i<listaPaginas.size();i++){
    
        ArrayList datos = new ArrayList(); // Contiene objetos de tipo "dato"
      
            
        docuContable=(DTOFACDocumentoContable)listaPaginas.get(i);
         
        miCabecera = docuContable.getCabecera();
        // Invocación del serializador
        
        // Composición de la sección 1
        DTOImpresion miDTO= new DTOImpresion();
        String mensa="<frmecc><cab>";
        //Parseador miParseador= new Parseador();
        Parseador miParseador= Parseador.getInstance();
        sf1.addMensaje(mensa);
        
          
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
        
        // vbongiov -- inc 20850
        miDTO= new DTOImpresion();
        /*
         * dmorello, 27/11/2006: Cambia la forma de imprimir el periodo.
         * Ej: "201003" pasaria a imprimirse como "03/2010"
         */
        //miDTO.setDatoVariable1(validarToString(miCabecera.getCodPeriodo()));
        String periodo = validarToString(miCabecera.getCodPeriodo());
        miDTO.setDatoVariable1(periodo.substring(4) + '/' + periodo.substring(0,4));
              
        mensa="<fcam><datoVariable01></fcam>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
        
        miDTO= new DTOImpresion();
        miDTO.setDatoVariable1(validarToString(validarToString(this.getDtoClienteSolicitud().getCodTerritorio())));
        mensa="<cter><datoVariable01></cter>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
                
        miDTO= new DTOImpresion();
        //modificado por incidencia 21005. Se setea el campo nombre via 
        //que ya trae todos los valores concatenados
        //String direccion=null;
        /*if (this.getDtoClienteSolicitud().getNombreVia()!=null)
        {
            direccion = this.getDtoClienteSolicitud().getNombreVia();
        }*/
        /*if (miCabecera.getNombreVia()!=null){
            direccion = miCabecera.getNombreVia();
        }else{
            direccion = "";
        }*/
        //miDTO.setDatoVariable1(validarToString(miCabecera.getTipoVia())+" "+validarToString(miCabecera.getNombreVia())+" "+validarToString(miCabecera.getNumero()));
        String direccion
            = this.getDtoClienteSolicitud().getDescripcionVia() + ' ' 
            + this.getDtoClienteSolicitud().getNombreVia()+ ' '
            + this.getDtoClienteSolicitud().getNumero();
            
        if (direccion.length()>100){
            direccion = direccion.substring(0,100);
        }
        miDTO.setDatoVariable1(validarToString(direccion));
        mensa="<dir1><datoVariable01></dir1>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
                
        miDTO= new DTOImpresion();
        miDTO.setDatoVariable1(validarToString(this.getDtoClienteSolicitud().getDescripcionUbigeo()));
        mensa="<dir2><datoVariable01></dir2>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
        
        
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
            //stringFecha = splitFechas[2]+"/"+splitFechas[1]+"/"+splitFechas[0].substring(splitFechas[0].length()-2, splitFechas[0].length());
            stringFecha = splitFechas[2]+'/'+splitFechas[1]+'/'+splitFechas[0]; // Todas las fechas van en formato dd/MM/yyyy
        } catch(Exception e){
        }
    /*    String aux;
        Date fechaAux= miCabecera.getFechaFacturacion();
        if(fechaAux!=null){
          String añoAux=String.valueOf(fechaAux.getYear()).toString();
          aux= String.valueOf(fechaAux.getDay()+"/" +fechaAux.getMonth())+"/"+añoAux;
        }
        else
        {
          aux=" ";
        }*/
        
        miDTO= new DTOImpresion();
        miDTO.setDatoVariable1(stringFecha);
        mensa="<fec><datoVariable01></fec>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
    
        miDTO= new DTOImpresion();
        mensa="</cab><blqcp>";
        sf1.addMensaje(mensa);    
                  
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
        miDTO.setDatoVariable1(validarToString(validarToString(this.getDtoClienteSolicitud().getCodTerritorio())));
        mensa="<cter><datoVariable01></cter>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
        BigDecimal bd = new BigDecimal(saldoAnterior.doubleValue()).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        BigDecimal bdvec = new BigDecimal(bd.doubleValue()).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        String fechaVencimiento = "";
        Timestamp fechaVenc = null;
        if (miCabecera.getMostrarFechaVencimiento()) {
            //llamaos a DAOCra.obtenerPeriodoSiguiente
            UtilidadesLog.debug("Cupon de pago: El oid periodo que llega es: "+miCabecera.getOidPeriodo());
            if (periodoSiguiete.containsKey(miCabecera.getOidPeriodo())){
                oidPeriodo = (Long)periodoSiguiete.get(miCabecera.getOidPeriodo());
            }else{
                oidPeriodo=daoCra.obtienePeriodoSiguiente(miCabecera.getOidPeriodo());
                periodoSiguiete.put(miCabecera.getOidPeriodo(), oidPeriodo);
            }
            UtilidadesLog.debug("El perido es : "+oidPeriodo);
            if (oidPeriodo!=null) {
                if (fechasVencimientos.containsKey(""+miCabecera.getOidZona()+"-"+oidPeriodo)){
                    fechasCra = (ArrayList)fechasVencimientos.get(""+miCabecera.getOidZona()+"-"+oidPeriodo);
                }else{
                    fechasCra=this.obtenerFechasFacturacionPorPeriodoZona(miCabecera.getOidZona(), oidPeriodo);
                    fechasVencimientos.put(""+miCabecera.getOidZona()+"-"+oidPeriodo, fechasCra);
                }
                //fechasCra=this.obtenerFechasFacturacionPorPeriodoZona(miCabecera.getOidZona(), oidPeriodo);
                
                if (fechasCra != null && fechasCra.size()>0){
                    miDTO= new DTOImpresion();
                    fechaVenc = (Timestamp)fechasCra.get(0);
                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    fechaVencimiento = df.format(new Date(fechaVenc.getTime())).toString();
                    
                    /*dtoSaldos = new DTOSaldosPorFechasyVtos();
                    if(miCabecera.getOidCliente()!=null) {
                      dtoSaldos.setOidCliente(new Long(miCabecera.getOidCliente().intValue()));
                    }
                    dtoSaldos.setOidIdioma(miCabecera.getOidIdioma());
                    dtoSaldos.setOidPais(miCabecera.getOidPais());
                    dtoSaldos.setFechaVtoHasta(new Date(fechaVenc.getTime()));*/
                    
                    dtoTotal = obtenerSaldoCliente(miCabecera.getOidPais(), miCabecera.getOidCliente(), new Date(fechaVenc.getTime()));
                    bdvec = dtoTotal.getTotal().setScale(2, BigDecimal.ROUND_HALF_EVEN);
                }
            }
        }
        
        miDTO= new DTOImpresion();
        if (miCabecera.getMostrarFechaVencimiento()) {
            miDTO.setDatoVariable1(validarToString(bdvec));
        }else{
            miDTO.setDatoVariable1(validarToString(new BigDecimal(saldoCuentaCorriente.doubleValue()).setScale(2, BigDecimal.ROUND_HALF_EVEN)));
        }
        
        // dmorello, 23/11/2006: Si el saldo es negativo, debe ser reemplazado por cero.
        if (miDTO.getDatoVariable1().startsWith("-")) {
            miDTO.setDatoVariable1("0.00");
        }
        
        mensa="<saldo><datoVariable01></saldo>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
        
        miDTO= new DTOImpresion();
        miDTO.setDatoVariable1(stringFecha);
        mensa="<fec><datoVariable01></fec>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
        
        //añadido por incidencia 11135
        if (miCabecera.getMostrarFechaVencimiento()) {
            miDTO.setDatoVariable1(fechaVencimiento);
        }else{
            miDTO.setDatoVariable1(" ");
        }
        mensa="<fecven><datoVariable01></fecven>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
        
        miDTO= new DTOImpresion();
        mensa="</blqcp>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));    
          
          
          
        miDTO= new DTOImpresion();
        mensa="<detalle>";
    
        sf1.addMensaje(mensa);  

        miDTO= new DTOImpresion();
        String fechaUltimaGeneracion = "";
        if (docuContable.getMovimientos().size()>0){
            Date fechaU =((DTOMovimientoDetalle)docuContable.getMovimientos().get(0)).getFechaUltimaGeneracion();
            UtilidadesLog.debug("fechaUltimaGeneracion: "+fechaU);
            try {
                // yyyy-MM-dd
                auxFecha = UtilidadesFecha.convertirAString(fechaU);
                String[] splitFechas = new String[3];
                StringTokenizer st = new StringTokenizer(auxFecha, "-");
                for(int cont = 0; cont<3; cont++) {
                    splitFechas[cont] = st.nextToken();
                }
                //fechaUltimaGeneracion = splitFechas[2]+"/"+splitFechas[1]+"/"+splitFechas[0].substring(splitFechas[0].length()-2, splitFechas[0].length());
                fechaUltimaGeneracion = splitFechas[2]+'/'+splitFechas[1]+'/'+splitFechas[0];
            } catch(Exception e){
            }
        }
        UtilidadesLog.debug("fechaUltimaGeneracionFormateada: "+fechaUltimaGeneracion);
        miDTO.setDatoVariable1(fechaUltimaGeneracion);//tendria que estar la fecha de generacion del ultimo cupon de pago.
        miDTO.setDatoVariable2("Saldo anterior a pagar");
        miDTO.setDatoVariable3("0.00");
        miDTO.setDatoVariable4("0.00");
        miDTO.setDatoVariable5(validarToString(bd.setScale(2, BigDecimal.ROUND_HALF_EVEN)));
        mensa="<txt><datoVariable01><t/><datoVariable02><tr/><datoVariable03><tr/><datoVariable04><tr/><datoVariable05></txt>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
        
        //se modifica por incidencia 11135
        //ArrayList misDetalles= docuContable.getDetalle();
        ArrayList misDetalles= docuContable.getMovimientos();
          
        String añoAux;
        boolean vencimientosFuturos = false;
        HashMap consolidadosReclamos = new HashMap();
        for(int x=0;x<misDetalles.size();x++) {
          
          DTOMovimientoDetalle miDetalle=(DTOMovimientoDetalle)misDetalles.get(x);
          UtilidadesLog.debug("Fecha Vencimiento: "+miDetalle.getFechaVencimiento());
          if ( (fechaVenc!=null) && (miDetalle.getFechaVencimiento()!=null) && (x!=(misDetalles.size()-1)) && (!vencimientosFuturos) 
               && (miDetalle.getFechaVencimiento().getTime() > fechaVenc.getTime())){
              if (!miCabecera.getMostrarFechaVencimiento()) {
                  break;
              }
              miDTO= new DTOImpresion();
              miDTO.setDatoVariable1("");//tendria que estar la fecha de generacion del ultimo cupon de pago.
              miDTO.setDatoVariable2("");
              miDTO.setDatoVariable3("");
              miDTO.setDatoVariable4("");
              miDTO.setDatoVariable5("");
              mensa="<txt><datoVariable01><t/><datoVariable02><tr/><datoVariable03><tr/><datoVariable04><tr/><datoVariable05></txt>";
              sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
              miDTO= new DTOImpresion();
              miDTO.setDatoVariable1("");//tendria que estar la fecha de generacion del ultimo cupon de pago.
              miDTO.setDatoVariable2("***VENCIMIENTOS FUTUROS***");
              miDTO.setDatoVariable3("");
              miDTO.setDatoVariable4("");
              miDTO.setDatoVariable5("");
              mensa="<txt><datoVariable01><t/><datoVariable02><tr/><datoVariable03><tr/><datoVariable04><tr/><datoVariable05></txt>";
              sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
              vencimientosFuturos = true;
          }   
          miDTO= new DTOImpresion();
          //
          //    Fecha de Operacion
          //
          stringFecha = "";
          try {
              // yyyy-MM-dd
              auxFecha = UtilidadesFecha.convertirAString(miDetalle.getFechaMovimiento());
              String[] splitFechas = new String[3];
              StringTokenizer st = new StringTokenizer(auxFecha, "-");
              for(int cont = 0; cont<3; cont++) {
                  splitFechas[cont] = st.nextToken();
              }
              //stringFecha = splitFechas[2]+"/"+splitFechas[1]+"/"+splitFechas[0].substring(splitFechas[0].length()-2, splitFechas[0].length());
              stringFecha = splitFechas[2]+'/'+splitFechas[1]+'/'+splitFechas[0];
          } catch(Exception e){
          }
          miDTO.setDatoVariable1(stringFecha);
          //
          //    Modificado por HRCS - Fecha 20/06/2007 - Cambio Sicc20070296
          //    Si el monto es menor a 0, entonces se realiza una validacion para ver si es reclamo
          //
          boolean esImpreso = false;
          if ( (miDetalle.getCodProceso().toUpperCase()).equals("CCC001") && miDetalle.getImporteMovimiento().doubleValue() < 0.0 
             && miDetalle.getConsolidado()!=null ) {
            UtilidadesLog.debug("Importe es negativo...");
            //  Obtenemos el oid del consolidado que genero el movimiento
            Long consolidado = miDetalle.getConsolidado();
            //  Si el oid consolidado ya ha sido modificado o agregado, entonces ya no se toma en cuenta
            if ( consolidadosReclamos.containsKey(consolidado) )   {
                UtilidadesLog.debug("El consolidado de reclamo ["+ consolidado +"] ya fue impreso.");
                esImpreso = true;   //  El registro ya fue impreso
            }
            else    {
                ArrayList solicitudes = obtenerSolicitudesOrigenReclamo( consolidado );
                //  Si la lista tiene por lo menos un registro, entonces es un consolidado de RECLAMO
                if (solicitudes!=null && !solicitudes.isEmpty())    {   // es reclamo
                    esImpreso = true;
                    if (solicitudes.size() == 1)    {
                        UtilidadesLog.debug("Reemplazando la descripcion por la del Reclamo...");
                        HashMap solicitudReclamo = (HashMap)solicitudes.get(0);
                        //  Obtiene la descripcion del reclamo
                        miDTO.setDatoVariable2( (String)solicitudReclamo.get("DESCRIP") );
                        //  Calcula el saldo del movimiento, pasandole como monto el del CONSOLIDADO
                        saldoAnterior = calculaSaldoDelMovimiento( miDetalle.getValIndConsulta(), (Double)solicitudReclamo.get("CONVTPL"), saldoAnterior, miDTO );
                        
                        mensa="<txt><datoVariable01><t/><datoVariable02><tr/><datoVariable03><tr/><datoVariable04><tr/><datoVariable05></txt>";
                        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));                    
                    }
                    else    {
                        //  Se recorre todas las solicitudes del consolidado
                        HashMap solicitud = null;
                        double montoAcumulado = 0.0;
                        for(int conta=0; conta<solicitudes.size(); conta++)   {
                            solicitud = (HashMap)solicitudes.get(conta);
                            montoAcumulado = montoAcumulado + ((Double)solicitud.get("RECPOSSUM")).doubleValue();
                        }
                        //  Calcula el ajuste de todos las solicitudes de reclamos
                        double ajuste = ((Double)solicitud.get("CONVTPL")).doubleValue() - montoAcumulado;
                        UtilidadesLog.debug("El ajuste para el consolidado("+ consolidado +") es de: ["+ ajuste +"]");
                        
                        //  Se imprime cada detalle del reclamo en el cupon de pago
                        for(int conta=0; conta<solicitudes.size(); conta++)   {
                            HashMap solicitudReclamo = (HashMap)solicitudes.get(conta);
                            
                            //  Obtiene la descripcion del reclamo
                            miDTO.setDatoVariable2( (String)solicitudReclamo.get("DESCRIP") );
                            //  Si es la primera solicitud, se le suma el ajuste
                            if (conta==0)   {
                                UtilidadesLog.debug("Se modifica el primer registro del consolidado de reclamos..." );
                                Double montoAjustado = new Double( ((Double)solicitudReclamo.get("RECPOSSUM")).doubleValue() + ajuste );
                                saldoAnterior = calculaSaldoDelMovimiento( miDetalle.getValIndConsulta(), montoAjustado, saldoAnterior, miDTO );
                            }
                            else    {
                                UtilidadesLog.debug("Se agrego un nuevo registro al detalle..." );
                                saldoAnterior = calculaSaldoDelMovimiento( miDetalle.getValIndConsulta(), (Double)solicitudReclamo.get("RECPOSSUM"), saldoAnterior, miDTO );
                            }
                            
                            mensa="<txt><datoVariable01><t/><datoVariable02><tr/><datoVariable03><tr/><datoVariable04><tr/><datoVariable05></txt>";
                            sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));    
                        }
                    }
                    //  Agregando al hash de consolidados...
                    consolidadosReclamos.put( consolidado, consolidado );                    
                }
            }   // fin del else de consolidado ya impreso
          }
          // Si el movimiento no era de Reclamo, entonces se procede de la forma Normal.
          if (!esImpreso)   {
               
               if((miDetalle.getCodProceso().toUpperCase()).equals("CCC001")){
                   StringBuffer sb = new StringBuffer();
                   sb.append("Ped. ");
                   sb.append(miCabecera.getCodPeriodo());
                   sb.append(" B.Despacho ");
                   sb.append(miDetalle.getEjercicioIdentificadorCuota());
                   sb.append(cerosIzq(miDetalle.getNumIdentCuota(),8)); 
                   UtilidadesLog.debug("DatoVariable2: "+sb.toString());
                   miDTO.setDatoVariable2(sb.toString());  
               }else{
                   UtilidadesLog.debug("DatoVariable2: "+miDetalle.getDescripcionTipoCargoAbono());
                   miDTO.setDatoVariable2(miDetalle.getDescripcionTipoCargoAbono());
               }
               //   Modificado por HRCS - Fecha 20/06/2007 - Cambio Sicc20070296
               saldoAnterior = calculaSaldoDelMovimiento( miDetalle.getValIndConsulta(), miDetalle.getImporteMovimiento(), saldoAnterior, miDTO );
                
               mensa="<txt><datoVariable01><t/><datoVariable02><tr/><datoVariable03><tr/><datoVariable04><tr/><datoVariable05></txt>";
               sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
          }
        }
        if (!vencimientosFuturos && miCabecera.getMostrarFechaVencimiento()){
            miDTO= new DTOImpresion();
            miDTO.setDatoVariable1("");//tendria que estar la fecha de generacion del ultimo cupon de pago.
            miDTO.setDatoVariable2("");
            miDTO.setDatoVariable3("");
            miDTO.setDatoVariable4("");
            miDTO.setDatoVariable5("");
            mensa="<txt><datoVariable01><t/><datoVariable02><tr/><datoVariable03><tr/><datoVariable04><tr/><datoVariable05></txt>";
            sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
            miDTO= new DTOImpresion();
            miDTO.setDatoVariable1("");//tendria que estar la fecha de generacion del ultimo cupon de pago.
            /* Se saca por incidencia de RKanna y AGuardiola --------- Alorenzo 22/02/2007*/
            miDTO.setDatoVariable2("");
            //miDTO.setDatoVariable2("***NO HAY VENCIMIENTOS FUTUROS***");
            
            miDTO.setDatoVariable3("");
            miDTO.setDatoVariable4("");
            miDTO.setDatoVariable5("");
            mensa="<txt><datoVariable01><t/><datoVariable02><tr/><datoVariable03><tr/><datoVariable04><tr/><datoVariable05></txt>";
            sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));
        }
          
        miDTO= new DTOImpresion();
        mensa="</detalle></frmecc>";
        sf1.addMensaje(miParseador.sustituirEtiquetasVariables(mensa, miDTO));   
      
        //sf1.componerDocumento();
        // Añadido por la BELC300015527
        sf1.resetearContadorLineas();
    }

    try {
        // Añadido por la BELC300015527
        sf1.componerDocumento();

        sf1.saveDocument("c:\\", "CuponDePagoPeru.txt");
        this.documento = sf1.bufferOut;
    } catch (Exception e) {
        e.printStackTrace();
    }
	if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
	    UtilidadesLog.debug("CuponDePagoPeru: "+sf1.toString());
      
      UtilidadesLog.info("CuponDePagoPeru.componerFactura(DTODocLegal datosDocLegal): Salida");
      
    }


    private Double calcularSaldoAnterior(DTODocLegal datosDocLegal,Double saldoCuentaCorriente){
        UtilidadesLog.info("CuponDePagoPeru.calcularSaldoAnterior(DTODocLegal datosDocLegal,Float saldoCuentaCorriente): Entrada"); 
        ArrayList paginas= datosDocLegal.getlistaPaginas();        
        DTOFACDocumentoContable miDocumento=(DTOFACDocumentoContable)paginas.get(0);
        DTOFACDocumentoContableCabecera cabecera= miDocumento.getCabecera();
        Long pais= cabecera.getPais();
        Long codCliente= cabecera.getOidCliente();        
        
        
        ArrayList detalles; 
        DTOMovimientoDetalle miDetalle; 
        Double importe;
        String codSub;
        for(int documento=0;documento<paginas.size();documento++){
            miDocumento= (DTOFACDocumentoContable)paginas.get(documento);
            detalles =miDocumento.getMovimientos();
            for(int pagina=0;pagina<detalles.size();pagina++){
                miDetalle=(DTOMovimientoDetalle)detalles.get(pagina); 
                importe = miDetalle.getImporteMovimiento();
                codSub= miDetalle.getValIndConsulta();
                if(codSub.equals("D")){
                    saldoCuentaCorriente=new Double(saldoCuentaCorriente.doubleValue()-importe.doubleValue());       
                }
                if(codSub.equals("H")){
                    saldoCuentaCorriente=new Double(saldoCuentaCorriente.doubleValue()+importe.doubleValue());
                }
            }
        }
        UtilidadesLog.info("CuponDePagoPeru.calcularSaldoAnterior(DTODocLegal datosDocLegal,Float saldoCuentaCorriente): Salida"); 
        return saldoCuentaCorriente;  
    }



    public byte[] getDocument(){
        return this.documento;
    }
    
  // Añadido por la BELC300012000    
	private MONInterfaceModulos getMONInterfaceModulos() throws MareException {
      MONInterfaceModulos monInterfaceModulos = null;
      
      MONInterfaceModulosHome monInterfaceModulosHome = null;
      try{
        monInterfaceModulosHome = (MONInterfaceModulosHome)PortableRemoteObject.narrow(ctx.lookup("MONInterfaceModulos"), MONInterfaceModulosHome.class);
        monInterfaceModulos = monInterfaceModulosHome.create();
      }catch(RemoteException e){
        String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }catch(CreateException e){
        String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }catch(NamingException e){
        String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }
      UtilidadesLog.debug("****Metodo  getSpoolManager: Salida");
      return monInterfaceModulos;
  }	
  
  //añadido por incidencia 11135
  private MONCronograma getMONCronograma() throws MareException {
      MONCronograma monCronograma = null;
      
      MONCronogramaHome monCronogramaHome = null;
      try{
        monCronogramaHome = (MONCronogramaHome)PortableRemoteObject.narrow(ctx.lookup("MONCronograma"), MONCronogramaHome.class);
        monCronograma = monCronogramaHome.create();
      }catch(RemoteException e){
        String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }catch(CreateException e){
        String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }catch(NamingException e){
        String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }
      UtilidadesLog.debug("****Metodo  getSpoolManager: Salida");
      return monCronograma;
  }	
  
    
    public ArrayList obtenerFechasFacturacionPorPeriodoZona(Long oidZona, Long oidPeriodo) throws MareException {
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet(); 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
    
        query.append("   SELECT cra.fec_inic fecha ");
        query.append("     FROM cra_crono cra, cra_activ act, cra_clase_activ clase   ");
        query.append("    WHERE cra.zzon_oid_zona =  " + oidZona);
        query.append("      AND act.oid_acti = cra.cact_oid_acti   ");
        query.append("      AND clase.oid_clas_acti = act.clac_oid_clas_acti   ");
        query.append("      AND CLASE.COD_CLAS_ACTI = '" + ConstantesCRA.COD_CLASE_ACTIVIDAD_CONFERENCIA_DE_VENTAS + "' ");
        query.append("      AND cra.perd_oid_peri =  " + oidPeriodo);
        query.append("      ORDER BY fecha ASC  ");
        
        try {
            rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
        } catch (Exception e) {
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }           
        ArrayList arryListFechas = new ArrayList();
        Date fecha = null;
        int sizeRecord = rs.getRowCount();
        for (int i = 0; i < sizeRecord; i++)  {
            fecha = (Date) rs.getValueAt(i,"FECHA");
            Timestamp tmsmp = new Timestamp(fecha.getTime());
            arryListFechas.add(tmsmp);
        }

        return arryListFechas;
    }
    
    public DTOTotal obtenerSaldoCliente(Long pais, Long cliente, java.util.Date fechaVtoHasta) throws MareException {
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet(); 
        DTOTotal dtoTotal = new DTOTotal();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String proceso = "CON001";
        Integer subproceso = new Integer(1);
        
        query.append("   SELECT SUM(IMP_PEND) as suma ");
        query.append(" FROM CCC_MOVIM_CUENT_CORRI m, MAE_CLIEN c ");
        query.append(" WHERE m.CLIE_OID_CLIE = c.OID_CLIE  ");
        query.append(" AND c.PAIS_OID_PAIS= "+pais);
        query.append(" AND m.CLIE_OID_CLIE = "+cliente);
        if(fechaVtoHasta!=null){
            java.sql.Date fechaVtoHasta1 = new java.sql.Date(fechaVtoHasta.getTime());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String sFechaVtoHasta = sdf.format(fechaVtoHasta1);
            //query.append(" AND m.FEC_VENC <= TO_DATE( '2007-01-01' ,'YYYY-MM-DD') ");
            query.append(" AND m.FEC_VENC <= TO_DATE( '" + sFechaVtoHasta  + "' ,'YYYY-MM-DD') ");
        }
        query.append(" AND m.MASI_OID_MARC_SITU IN (SELECT u.OID_MARC_SITU FROM  ");
        query.append(" CCC_MARCA_SITUA u,CCC_MARCA_TIPO_ABONO m,  ");
        query.append(" CCC_TIPO_ABONO_SUBPR t,CCC_SUBPR s,  ");
        query.append(" CCC_PROCE p  ");
        query.append(" WHERE u.OID_MARC_SITU = m.MASI_OID_MARC_SALI  ");
        query.append(" AND m.TASP_OID_TIPO_ABON_SUBP = t.OID_TIPO_ABON_SUBP  ");
        query.append(" AND t.SUBP_OID_SUBP = s.OID_SUBP  ");
        query.append(" AND s.CCPR_OID_PROC = p.OID_PROC  ");
        query.append(" AND s.COD_SUBP = '"+subproceso+"'");
        query.append(" AND p.COD_PROC = '"+proceso+"' ");
        query.append(" AND u.PAIS_OID_PAIS = "+pais);
        query.append(" AND m.IND_ENTR_SALI like 'E')  ");
        query.append(" AND m.IMP_MOVI <> m.IMP_PAGA  ");
        
        try {
            rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
        } catch (Exception e) {
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }           
        if (rs.getValueAt(0,0) != null) {
            dtoTotal.setTotalString(rs.getValueAt(0, 0).toString());
            dtoTotal.setTotal((BigDecimal)rs.getValueAt(0, 0));
        }else{
            dtoTotal.setTotalString("0");
            BigDecimal valor = new BigDecimal(0);
            dtoTotal.setTotal(valor);
        }
        return dtoTotal;
    }
    
    /**
     * Metodo que trae las solicitudes origen de una solictud RECLAMO
     * Agregado por HRCS - Fecha 20/06/2007 - Cambio Sicc20070296
     * @throws es.indra.mare.common.exception.MareException
     * @return ArrayList con la o las solicitudes origen
     * @param oidConsolidado
     */
    private ArrayList obtenerSolicitudesOrigenReclamo(Long oidConsolidado) throws MareException {
        UtilidadesLog.debug("CuponDePagoPeru.obtenerSolicitudesOrigenReclamo(Long oidConsolidado): Entrada"); 
        
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        query.append(" SELECT ");
        query.append("   cons.oid_soli_cabe as CONSOLIDADO ");
        query.append("   , cons.val_tota_paga_loca as CONVTPL ");
        query.append("   , solicRecla.oid_soli_cabe as RECLAMO ");
        query.append("   , solicRecla.modu_oid_modu as RECMOD ");
        query.append("   , solicRecla.val_tota_paga_loca as RECVTPL ");
        query.append("   , solicRecla.soca_oid_docu_refe as RECSOLREF ");
        query.append("   , sum(posicRecla.val_prec_fact_tota_loca - posicRecla.val_prec_cont_tota_loca) as RECPOSSUM ");
        query.append("   , 'C' || perioCorpo.cod_peri || ' ' || opera.val_desc_larg || ' NRO.' || cabecRecla.num_recl as DESCRIP ");
        query.append(" FROM ");
        query.append("   ped_solic_cabec cons ");
        query.append("   , ped_solic_cabec solicRecla ");
        query.append("   , ped_solic_cabec solicOrigen ");
        query.append("   , ped_solic_posic posicRecla ");
        query.append("   , rec_solic_opera solicOpera ");
        query.append("   , rec_opera_recla operaRecla ");
        query.append("   , rec_cabec_recla cabecRecla ");
        query.append("   , rec_tipos_opera tiposOpera ");
        query.append("   , rec_opera opera ");
        query.append("   , cra_perio perio ");
        query.append("   , seg_perio_corpo perioCorpo ");
        query.append(" WHERE ");
        query.append("   cons.oid_soli_cabe = ? ");
        parametros.add(oidConsolidado);
        query.append("   AND cons.oid_soli_cabe = solicRecla.soca_oid_soli_cabe ");
        query.append("   AND solicRecla.oid_soli_cabe = posicRecla.soca_oid_soli_cabe(+) ");
        query.append("   AND solicRecla.soca_oid_docu_refe is not null ");    // Esto para validar si es reclamo
        query.append("   AND solicRecla.oid_soli_cabe = solicOpera.soca_oid_soli_cabe ");
        query.append("   AND solicOpera.opre_oid_oper_recl = operaRecla.oid_oper_recl ");
        query.append("   AND operaRecla.care_oid_cabe_recl = cabecRecla.oid_cabe_recl ");
        query.append("   AND operaRecla.tiop_oid_tipo_oper = tiposOpera.oid_tipo_oper ");
        query.append("   AND tiposOpera.rope_oid_oper = opera.oid_oper ");
        query.append("   AND solicRecla.soca_oid_docu_refe = solicOrigen.oid_soli_cabe ");
        query.append("   AND solicOrigen.perd_oid_peri = perio.oid_peri ");
        query.append("   AND perio.peri_oid_peri = perioCorpo.oid_peri ");
        query.append(" GROUP BY ");
        query.append("   cons.oid_soli_cabe ");
        query.append("   , cons.val_tota_paga_loca ");
        query.append("   , solicRecla.oid_soli_cabe ");
        query.append("   , solicRecla.modu_oid_modu ");
        query.append("   , solicRecla.val_tota_paga_loca ");
        query.append("   , solicRecla.soca_oid_docu_refe ");
        query.append("   , cabecRecla.num_recl ");
        query.append("   , opera.val_desc_larg ");
        query.append("   , perioCorpo.cod_peri ");
    
        RecordSet rs = new RecordSet();
        try {
            rs = (RecordSet)BelcorpService.getInstance().dbService.executePreparedQuery(query.toString(),parametros);
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        //  Volcamos los resultados en un HasMap
        ArrayList solicitudes = new ArrayList();
        if (rs!=null && !rs.esVacio())  {
            for (int i = 0; i < rs.getRowCount(); i++)  {
                HashMap solicitud = new HashMap();
                solicitud.put( "CONSOLIDADO", (rs.getValueAt(i,0)!=null? new Long( ((BigDecimal)rs.getValueAt(i,0)).longValue() ) : null ) );
                solicitud.put( "CONVTPL", (rs.getValueAt(i,1)!=null? new Double( ((BigDecimal)rs.getValueAt(i,1)).doubleValue() ) : null ) );
                solicitud.put( "RECLAMO", (rs.getValueAt(i,2)!=null? new Long( ((BigDecimal)rs.getValueAt(i,2)).longValue() ) : null ) );
                solicitud.put( "RECMOD", rs.getValueAt(i,3) );
                solicitud.put( "RECVTPL", (rs.getValueAt(i,4)!=null? new Double( ((BigDecimal)rs.getValueAt(i,4)).doubleValue() ) : null ) );
                solicitud.put( "RECSOLREF", (rs.getValueAt(i,5)!=null? new Long( ((BigDecimal)rs.getValueAt(i,5)).longValue() ) : null ) );
                solicitud.put( "RECPOSSUM", (rs.getValueAt(i,6)!=null? new Double( ((BigDecimal)rs.getValueAt(i,6)).doubleValue() ) : null ) );
                solicitud.put( "DESCRIP", rs.getValueAt(i,7) );
                //  Agregando al array de solicitudes
                solicitudes.add( solicitud );
            }
        }
        UtilidadesLog.debug("CuponDePagoPeru.obtenerSolicitudesOrigenReclamo(Long oidConsolidado): Salida"); 
        return solicitudes;
    }
    
    /**
     * Metodo de apoyo para el calculo del Saldo en el Cupon de Pago
     * Agregado por HRCS - Fecha 20/06/2007 - Cambio Sicc20070296
     * @return Saldo
     * @param miDTO
     * @param saldoAnterior
     * @param importeMovimiento
     * @param indConsulta
     */
    private Double calculaSaldoDelMovimiento( String indConsulta, Double importeMovimiento, Double saldoAnterior, DTOImpresion miDTO )   {
        Double nuevoSaldo = null;
       if(indConsulta.equals("D")){
            nuevoSaldo=new Double(saldoAnterior.doubleValue()+importeMovimiento.doubleValue());
            if (importeMovimiento.doubleValue() != 0.0){
                if (importeMovimiento.doubleValue()>0)   {
                    miDTO.setDatoVariable3(new BigDecimal(importeMovimiento.doubleValue()).setScale(2, BigDecimal.ROUND_HALF_EVEN).toString());
                    miDTO.setDatoVariable4("0.00");
                }
                else {   //  Importe es negativo, para efectos de impresion se invierte la presentacion - Cambio Sicc20070357 - HRCS - 06/08/2007
                    miDTO.setDatoVariable3("0.00");
                    miDTO.setDatoVariable4(new BigDecimal(importeMovimiento.doubleValue()).setScale(2, BigDecimal.ROUND_HALF_EVEN).toString());
                }
            }else{
                miDTO.setDatoVariable3("0.00");
                miDTO.setDatoVariable4("0.00");
            }
            //miDTO.setDatoVariable4("0.00");
            BigDecimal bd1 = new BigDecimal(nuevoSaldo.doubleValue());
            miDTO.setDatoVariable5(bd1.setScale(2, BigDecimal.ROUND_HALF_EVEN).toString());  
        }
        if(indConsulta.equals("H")){
            nuevoSaldo=new Double(saldoAnterior.doubleValue()-importeMovimiento.doubleValue());
            miDTO.setDatoVariable3("0.00");
            if (importeMovimiento.doubleValue() != 0.0){
                miDTO.setDatoVariable4("-"+new BigDecimal(importeMovimiento.doubleValue()).setScale(2, BigDecimal.ROUND_HALF_EVEN).toString());
            }else{
                miDTO.setDatoVariable4("0.00");
            }
            BigDecimal bd1 = new BigDecimal(nuevoSaldo.doubleValue());
            miDTO.setDatoVariable5(bd1.setScale(2, BigDecimal.ROUND_HALF_EVEN).toString());
        }
        
        if(indConsulta.equals("A")){
          if (importeMovimiento!=null){
              miDTO.setDatoVariable3(importeMovimiento.toString());
              miDTO.setDatoVariable4(importeMovimiento.toString());
          }else{
              miDTO.setDatoVariable3(" ");
              miDTO.setDatoVariable4(" ");
          }
          miDTO.setDatoVariable5(" ");
          nuevoSaldo = saldoAnterior;
        }
        if(indConsulta.equals("N")){
            miDTO.setDatoVariable3("0.00");
            miDTO.setDatoVariable4("0.00");
            miDTO.setDatoVariable5(" ");
            nuevoSaldo = new Double( 0.0 );
        }
        return nuevoSaldo;
    }
}





