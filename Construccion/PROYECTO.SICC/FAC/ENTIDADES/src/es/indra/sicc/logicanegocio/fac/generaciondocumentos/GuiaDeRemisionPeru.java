package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import es.indra.sicc.util.UtilidadesLog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class GuiaDeRemisionPeru extends DocumentoFAC 
{
 private byte[] documento;
 
  public GuiaDeRemisionPeru()
  {
  }


 // Modificado por la BELC300015920
  /**
   * @author: vconte
   * @param DTODocLegal datosDocLegal
   * @nota: cambio SICC-GCC-PED-003
   */
 public void componerFactura(DTODocLegal datosDocLegal) {
    ArrayList listaPaginas=datosDocLegal.getlistaPaginas(); 
    SerializadorGuiaDeRemisionPeru sf1 =  new SerializadorGuiaDeRemisionPeru(); 
                  
    int nSize = listaPaginas.size();
    for(int i=0; i < nSize; i++) { 
        ArrayList datos = new ArrayList(); // Inicio datos Cabecera 
        DTOFACDocumentoContable docuContable = (DTOFACDocumentoContable)listaPaginas.get(i); 
                              
        DTOFACDocumentoContableCabecera miCabecera = docuContable.getCabecera(); 
        
        datos.add(0, Integer.toString(i+1));
        datos.add(1, Integer.toString(nSize));
        sf1.addMensaje(0,datos); 
        datos.clear(); 

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (miCabecera.getFechaFacturacion() != null) {
            datos.add(0,validarToString(sdf.format(miCabecera.getFechaFacturacion())));
        } else {
            datos.add(0,validarToString(miCabecera.getFechaFacturacion()));
        }
        
        sf1.addMensaje(1, datos);         
        datos.clear(); 

        String[] split = this.dividirCadena(miCabecera.getDescripTipoSolicitud(), 22);
        datos.add(0, validarToString(split[0]));
        datos.add(1, validarToString(miCabecera.getCodZona()) + '-' + this.paddToSix(validarToString(miCabecera.getCodTerritorio())));
        if (split.length > 1) {
            datos.add(2, validarToString(split[1]));
        } else {
            datos.add(2, "");
        }
        sf1.addMensaje(2, datos);
        datos.clear();
        
        datos.add(0, validarToString(miCabecera.getCodCliente()));
        sf1.addMensaje(3,datos); 
        datos.clear();
        
        datos.add(0,validarToString(miCabecera.getCodPeriodo())); 
        datos.add(1,validarToString(miCabecera.getNumConsolidado())); 
        sf1.addMensaje(4,datos); 
        datos.clear();

        String puntoLlegada = "AV. SAN GENARO 150 URB MOLITALIA LOS OLIVOS/LIMA/LIMA";
        split = this.dividirCadena(puntoLlegada, 40);
        String[] split2 = this.dividirCadena(validarToString(miCabecera.getNombreVia()+" "+miCabecera.getDescripcionUbigeo()),38);
        int j = 0;
        for (int x = 0 ; x<4; x=x+2){
            if (split.length>j){
                datos.add(x,split[j]);
            }else{
                datos.add(x,"");
            }
            if (split2.length>j){
                datos.add(x+1,split2[j]);
            }else{
                datos.add(x+1,"");
            }
            j++;
        }
        sf1.addMensaje(5,datos); 
        datos.clear(); 
        
        datos.add(0,validarToString(miCabecera.getApellido1())+" "
                  +validarToString(miCabecera.getApellido2())+ ", "
                  +validarToString(miCabecera.getNombre1())+" "+
                  validarToString(miCabecera.getNombre2())); 
        sf1.addMensaje(6, datos); 
        datos.clear(); 
        
        datos.add(0,"4"); 
        sf1.addMensaje(7,datos); 
        datos.clear(); // Fin datos Cabecera
        
        // Inicio datos Detalle
        ArrayList misDetalles= docuContable.getDetalle(); 
        int repeticiones = misDetalles.size();
        for(int x=0; x<repeticiones; x++) { 
            DTOFACDocumentoContableDetalle miDetalle = (DTOFACDocumentoContableDetalle)misDetalles.get(x); 
            if(miDetalle.getNoImprimible()) continue; //modificado por Sapaza, fecha 04-12-2007, incidencia SiCC-20070522
            
            String codigoCompleto = ""; 
            
            Float PrecioUnitLocal = miDetalle.getPrecioCatalUnitLocal(); 
            if(miDetalle.getCodigoVenta()!=null) { 
                codigoCompleto = calcularCodigoCompletoVenta(miCabecera.getCodPeriodo(), miDetalle.getCodigoVenta(), PrecioUnitLocal); 
            } else { 
                codigoCompleto = calcularCodigoCompletoVenta(miCabecera.getCodPeriodo(), miDetalle.getCodigoProducto(), PrecioUnitLocal); 
            }             
            datos.add(0,codigoCompleto); 
            datos.add(1,validarToString(miDetalle.getDescripcionProd())); 
            datos.add(2,validarToString(miDetalle.getUnidadesAtendidas())); 
            sf1.addMensaje(8,datos); 
            datos.clear(); 
        } // Fin datos Detalle 
        
        datos.add(0,"----------"); 
        sf1.addMensaje(9,datos); 
        datos.clear(); 
        
        datos.add(0, validarToString(miCabecera.getNumUnidadesAtendidas()));
        sf1.addMensaje(10,datos); 
        datos.clear();         
        if (miCabecera.getGlosa()!=null && miCabecera.getGlosa().trim().length()>0){
            String glosa = "NOTA: "+validarToString(miCabecera.getGlosa());
            datos.add(0, glosa);
        }else{
            datos.add(0,"");
        }
        sf1.addMensaje(11, datos);
        datos.clear();
        if (i < nSize - 1) {
          sf1.insertarCaracterFinDePagina();
        }
    } //Final 
       
    sf1.componerDocumento();     
    this.documento = sf1.bufferOut;
    UtilidadesLog.info("GuiaDeRemisionPeru.componerFactura(DTODocLegal datosDocLegal): Salida"); 
}
    

    public byte[] getDocument()
    {
        return this.documento;
    }

    
    public String calcularCodigoCompletoVenta(String codPeriodoEntrada, String codVenta, Float precioCatalogoUnitLocalEntrada){
        //System.out.println("ESTOS SON LOS PARAMETROS QUE ME ENTRAN: " + codPeriodoEntrada+" "+codVenta+" "+precioCatalogoUnitLocalEntrada);
        UtilidadesLog.info("GuiaDeRemisionPeru.calcularCodigoCompletoVenta(String codPeriodoEntrada, String codVenta, Float precioCatalogoUnitLocalEntrada): Entrada"); 
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
        if(precioCatalogoUnitLocalEntrada.floatValue()==0){
            salida+="0";
        }else{
            salida+="8";
        }        
        UtilidadesLog.info("GuiaDeRemisionPeru.calcularCodigoCompletoVenta(String codPeriodoEntrada, String codVenta, Float precioCatalogoUnitLocalEntrada): Salida");
        return salida;
    }
    
    private String paddToSix(String toPadd) {
        String ret = new String();
        int lenToPadd = toPadd.trim().length();
        if (lenToPadd < 6) {
            ret = this.addCeros((6-lenToPadd)).concat(toPadd.trim());
            UtilidadesLog.info("paddToSix, retorna: " + ret);        
            return ret;
        } else {
            return toPadd;
        }        
    }

    private String addCeros(int cnt) {
        UtilidadesLog.info("cnt: " + cnt); 
        String ret = new String();
        String cero = new String("0");
        for(int i=0;i<cnt;i++){
            ret = ret.concat(cero);
        }
        UtilidadesLog.info("addCeros, retorna: " + ret);        
        return ret;
    }
    
    public static void main(String[] arg){
        GuiaDeRemisionPeru g = new GuiaDeRemisionPeru();
        DTODocLegal d = new DTODocLegal();
        DTOFACDocumentoContable dtoFac = new DTOFACDocumentoContable();
        DTOFACDocumentoContableCabecera dtoFacC = new DTOFACDocumentoContableCabecera();
        dtoFacC.setApellido1("Apellido 1");
        dtoFacC.setApellido2("Apellido 2");
        dtoFacC.setNombre1("Nombre 1");
        dtoFacC.setNombre2("Nombre 2");
        dtoFacC.setCodCliente("10000023");
        dtoFacC.setDescripTipoSolicitud("Tipo de solic");
        dtoFacC.setNombreVia("Habana 3546 cap federal, villa devoto, argentina y mas lejos aun");
        dtoFacC.setDescripcionUbigeo("Ubigeo muy lejos, casi en la lomas del mirador");
        dtoFacC.setCodPeriodo("200619");
        dtoFacC.setCodRegion("2356");
        dtoFacC.setCodZona("Zona1");
        dtoFacC.setCodTerritorio("TERR1");
        dtoFacC.setRutinaDiseñoFormulario("GuiaRemisionPeru");
        dtoFacC.setFechaFacturacion(new java.util.Date());
        dtoFac.setCabecera(dtoFacC);
        d.añadirPagina(dtoFac);        
        g.componerFactura(d);
        System.out.println(new String(g.getDocument()));
    }
}