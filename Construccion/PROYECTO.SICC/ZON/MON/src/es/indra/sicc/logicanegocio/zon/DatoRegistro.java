/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
package es.indra.sicc.logicanegocio.zon;
import es.indra.sicc.util.UtilidadesLog;

public class DatoRegistro 
{
    private int DIM_UA = 15;
    private int DIM_SUBGERENCIA = 2;
    private int DIM_REGION = 2;
    private int DIM_ZONA = 4;
    private int DIM_SECCION = 1;
    private int DIM_TERRITORIO = 6;
    private int DIM_UA_REGION = DIM_SUBGERENCIA + DIM_REGION;
    private int DIM_UA_ZONA = DIM_UA_REGION + DIM_ZONA;
    private int DIM_UA_SECCION = DIM_UA_ZONA + DIM_SECCION;
    //Modificado por incidencia 18426
    public int SUBGERENCIA = 1;
    public int REGION = 2;
    public int ZONA = 3;
    public int SECCION = 4;
    public int TERRITORIO = 5;
    public static final String TIPO_OPERACION_PARTICION = "P";
    public static final String TIPO_OPERACION_FUSION = "F";
    public static final String TIPO_OPERACION_TRASVASE = "T";
    //fin modificacion
    private String dato = null;
    private Long pais = null;
    private Long marca = null;
    private Long canal = null;
    private String NSE1 = null;
    private String NSE2 = null;
    private Long cliente = null;
    
    public DatoRegistro()
    {
    }
    
    public DatoRegistro(String datoOrigen, String nse1, String nse2)
    {
        UtilidadesLog.info("DatoRegistro(String datoOrigen, String nse1, String nse2): Entrada");
        this.dato = datoOrigen;
        this.NSE1 = nse1;
        this.NSE2 = nse2;   
        UtilidadesLog.info("DatoRegistro(String datoOrigen, String nse1, String nse2): Salida");
    }
    
    public DatoRegistro(String datoOrigen)
    {
        UtilidadesLog.info("DatoRegistro(String datoOrigen): Entrada");
        this.dato = datoOrigen;    
        UtilidadesLog.info("DatoRegistro(String datoOrigen): Salida");
    }    

    public String getSubgerencia()
    {
        UtilidadesLog.info("DatoRegistro.getSubgerencia(): Entrada");
        // Devuelve la parte correspondiente a la subgerencia
        // Devuelve dato.substring(0, DIM_SUBGERENCIA)
        if (dato != null && dato.length() >= this.DIM_SUBGERENCIA){
            UtilidadesLog.info("DatoRegistro.getSubgerencia(): Salida");
            return dato.substring(0,this.DIM_SUBGERENCIA);
        } else{
            UtilidadesLog.info("DatoRegistro.getSubgerencia(): Salida null");
            return null;
        }
    }
    
    public String getRegion()
    {
        UtilidadesLog.info("DatoRegistro.getRegion(): Entrada");
        // Devuelve la parte correspondiente a la region
        //Devuelve dato.substring(DIM_SUBGERENCIA, DIM_UA_REGION)
        if (dato != null && dato.length() >= this.DIM_UA_REGION) {
            UtilidadesLog.info("DatoRegistro.getRegion(): Salida");
            return dato.substring(this.DIM_SUBGERENCIA, this.DIM_UA_REGION);            
        } else {
            UtilidadesLog.info("DatoRegistro.getRegion(): Salida null");
            return null;
        }

    }
    
    public String getZona()
    {
        UtilidadesLog.info("DatoRegistro.getZona(): Entrada");
        // Devuelve la parte correspondiente a la zona
        //Devuelve dato.substring(DIM_UA_REGION, DIM_UA_ZONA)
        if (dato != null && dato.length() >= this.DIM_UA_ZONA){
            UtilidadesLog.info("DatoRegistro.getZona(): Salida");
            return dato.substring(this.DIM_UA_REGION, this.DIM_UA_ZONA);
        } else{
            UtilidadesLog.info("DatoRegistro.getZona(): Salida null");
            return null;
        }
    }
    
    public String getSeccion()
    {
        UtilidadesLog.info("DatoRegistro.getSeccion(): Entrada");
        // Devuelve la parte correspondiente a la seccion 
        //Devuelve dato.substring(DIM_UA_ZONA, DIM_UA_SECCION)
        if (dato != null && dato.length() >= this.DIM_UA_SECCION){
            UtilidadesLog.info("DatoRegistro.getSeccion(): Salida");
            return dato.substring(this.DIM_UA_ZONA, this.DIM_UA_SECCION);
        } else{
            UtilidadesLog.info("DatoRegistro.getSeccion(): Salida null");
            return null;
        }
    }
    public String getTerritorio(){
        UtilidadesLog.info("DatoRegistro.getTerritorio(): Entrada");
        // Devuelve la parte correspondiente al territorio
        if (dato != null && dato.length() > this.DIM_UA_SECCION) {
            UtilidadesLog.info("DatoRegistro.getTerritorio(): Salida");
            return dato.substring(this.DIM_UA_SECCION);
        } else {
            UtilidadesLog.info("DatoRegistro.getTerritorio(): Salida null");
            return null;
        } 
    }
    
    public int obtenerTipoUnidad(){
        UtilidadesLog.info("DatoRegistro.obtenerTipoUnidad(): Entrada");
        /* Obtiene el tipo de unidad que se corresponde con el código 
           Si codigo.length() == DIM_SUBGERENCIA Devuelve SUBGERENCIA */
        
        if (dato.length() == DIM_SUBGERENCIA){
            UtilidadesLog.debug("***Igual a DIM_SUBGERENCIA: "+this.DIM_SUBGERENCIA);
            UtilidadesLog.info("DatoRegistro.obtenerTipoUnidad(): Salida");
            return this.SUBGERENCIA;
        }
        //Si codigo.length() == DIM_UA_REGION Devuelve REGION
        if (dato.length() == DIM_UA_REGION){ 
            UtilidadesLog.debug("***Igual a DIM_REGION: "+this.DIM_REGION);
            UtilidadesLog.info("DatoRegistro.obtenerTipoUnidad(): Salida");
            return this.REGION;
        } 
        //Si codigo.length() == DIM_UA_ZONA Devuelve ZONA
        if (dato.length() == DIM_UA_ZONA){ 
            UtilidadesLog.debug("***Igual a DIM_ZONA: "+this.DIM_ZONA);
            UtilidadesLog.info("DatoRegistro.obtenerTipoUnidad(): Salida");
            return this.ZONA;
        }         
        //Si codigo.length() == DIM_UA_SECCION Devuelve SECCION
        if (dato.length() == DIM_UA_SECCION){
            UtilidadesLog.debug("***Igual a DIM_SECCION: "+this.DIM_SECCION);
            UtilidadesLog.info("DatoRegistro.obtenerTipoUnidad(): Salida");
            return this.SECCION;
        } 
        //Si codigo.length() == DIM_UA Devuelve TERRITORIO
        /*
        if (dato.length() == DIM_UA){
            UtilidadesLog.debug("***Igual a DIM_UA: "+this.DIM_UA);
            UtilidadesLog.info("DatoRegistro.obtenerTipoUnidad(): Salida");
            return this.TERRITORIO;
        }
        */
        if (dato.length() > DIM_UA_SECCION){
            UtilidadesLog.debug("*** Mayor a DIM_UA_SECCION ");
            UtilidadesLog.info("DatoRegistro.obtenerTipoUnidad(): Salida");
            return this.TERRITORIO;
        }
       
        return 0; //Si no se cumple ninguna condicion?
    }
    
    public boolean esTerritorio(){
        UtilidadesLog.info("DatoRegistro.esTerritorio(): Entrada");
        // Devuelve true si el dato representa un territorio 
        //Si (codigo.length() > DIM_UA_SECCION) Devuelve true 
        //sino  Devuelve false 
        if ( (dato.length() > DIM_UA_SECCION) && (dato.length() <= DIM_UA ) ){ 
            UtilidadesLog.info("true");
            UtilidadesLog.info("DatoRegistro.esTerritorio(): Salida");
            return true;
        }
        UtilidadesLog.info("false");
        UtilidadesLog.info("DatoRegistro.esTerritorio(): Salida");
        return false;
    }
    
    public boolean esSeccion(){
        UtilidadesLog.info("DatoRegistro.esSeccion(): Entrada");
        // Devuelve true si el dato representa una seccion 
        // Si (codigo.length() == DIM_UA_SECCION) Devuelve true 
        // sino Devuelve false 
        if (dato.length() == DIM_UA_SECCION){ 
            UtilidadesLog.info("true");
            UtilidadesLog.info("DatoRegistro.esSeccion(): Salida");
            return true;
        }
        UtilidadesLog.info("false");
        UtilidadesLog.info("DatoRegistro.esSeccion(): Salida");
        return false;
    }
    
    public boolean esZona(){
        UtilidadesLog.info("DatoRegistro.esZona(): Entrada");
        // Devuelve true si el dato representa una zona 
        // Si (codigo.length() == DIM_UA_ZONA) Devuelve true
        // sino Devuelve false
        if (dato.length() == DIM_UA_ZONA){
            UtilidadesLog.info("true");
            UtilidadesLog.info("DatoRegistro.esZona(): Salida");
            return true;
        }
        UtilidadesLog.info("false");
        UtilidadesLog.info("DatoRegistro.esZona(): Salida");
        return false;
    }
    
    public boolean esRegion(){
        UtilidadesLog.info("DatoRegistro.esRegion(): Entrada");
        // Devuelve true si el dato representa una region 
        // Si (codigo.length() == DIM_UA_REGION) Devuelve true
        // sino devuelve false
        if (dato.length() == DIM_UA_REGION){
            UtilidadesLog.info("true");
            UtilidadesLog.info("DatoRegistro.esRegion(): Salida");
            return true;
        }
        UtilidadesLog.info("false");
        UtilidadesLog.info("DatoRegistro.esRegion(): Salida");
        return false;
    }
    
    public boolean esSubgerencia (){
        UtilidadesLog.info("DatoRegistro.esSubgerencia (): Entrada");
        // Devuelve true si el dato representa una subgerencia
        //Si (codigo.length() == DIM_SUBGERENCIA) devuelve true
        // sino devuelve false
        if (dato.length() == DIM_SUBGERENCIA){
            UtilidadesLog.info("true");
            UtilidadesLog.info("DatoRegistro.esSubgerencia (): Salida");
            return true;
        }
        UtilidadesLog.info("false");
        UtilidadesLog.info("DatoRegistro.esSubgerencia (): Salida");
        return false;
    }
    
    public String obtenerCodigoUnidad(){
        UtilidadesLog.info("DatoRegistro.obtenerCodigoUnidad(): Entrada");
        //Si obtenerTipoUnidad() == SUBGERENCIA Devuelve getSubgerencia()
        if (obtenerTipoUnidad() == this.SUBGERENCIA){
            UtilidadesLog.debug("*** Igual a SUBGERENCIA: "+this.SUBGERENCIA);
            UtilidadesLog.info("DatoRegistro.obtenerCodigoUnidad(): Salida");
            return this.getSubgerencia();
        }

        //Si obtenerTipoUnidad() == REGION Devuelve getRegion()
        if (obtenerTipoUnidad() == this.REGION){ 
            UtilidadesLog.debug("*** Igual a REGION: "+this.REGION);
            UtilidadesLog.info("DatoRegistro.obtenerCodigoUnidad(): Salida");
            return this.getRegion();
        } 
        
        //Si obtenerTipoUnidad() == ZONA Devuelve getZona() 
        if (obtenerTipoUnidad() == this.ZONA){ 
            UtilidadesLog.debug("*** Igual a ZONA: "+this.ZONA);
            UtilidadesLog.info("DatoRegistro.obtenerCodigoUnidad(): Salida");
            return this.getZona();
        } 
        
        //Si obtenerTipoUnidad() == SECCION Devuelve getSeccion()
        if (obtenerTipoUnidad() == this.SECCION){
            UtilidadesLog.debug("*** Igual a SECCION: "+this.SECCION);
            UtilidadesLog.info("DatoRegistro.obtenerCodigoUnidad(): Salida");
            return this.getSeccion();
        } 
        
        //QUE SE DEVUELVE SI NO SE CUMPLE NINGUNA CONDICION?
        UtilidadesLog.info("DatoRegistro.obtenerCodigoUnidad(): Salida");
        return null;
    }
    
    public String obtenerCodigoUAPadre(){
        UtilidadesLog.info("DatoRegistro.obtenerCodigoUAPadre(): Entrada");
        
        int tipoUnidad = obtenerTipoUnidad();
        
        String retorno = null;
        //Si obtenerTipoUnidad() == SUBGERENCIA Devuelve "" (String vacio) 
        if (tipoUnidad == this.SUBGERENCIA){
            UtilidadesLog.debug("*** Igual a SUBGERENCIA: "+this.SUBGERENCIA);
            UtilidadesLog.info("DatoRegistro.obtenerCodigoUAPadre(): Salida");
            return new String("");
        } 
        
        //Si obtenerTipoUnidad() == REGION Devuelve getSubgerencia()
        if (tipoUnidad == this.REGION){ 
            UtilidadesLog.debug("*** Igual a REGION: "+this.REGION);
            UtilidadesLog.info("DatoRegistro.obtenerCodigoUAPadre(): Salida");
            return this.getSubgerencia();
        } 
        
        //Si obtenerTipoUnidad() == ZONA Devuelve getSubgerencia() + getRegion() 
        if (tipoUnidad == this.ZONA){ 
            UtilidadesLog.debug("*** Igual a ZONA: "+this.ZONA);
            retorno = this.getSubgerencia() + this.getRegion();
            UtilidadesLog.debug("****Retorno: "+retorno);
            UtilidadesLog.info("DatoRegistro.obtenerCodigoUAPadre(): Salida");
            return retorno;
        } 
        
        //Si obtenerTipoUnidad() == SECCION Devuelve getSubgerencia() + getRegion() + getZona() 
        if (tipoUnidad == this.SECCION){
            UtilidadesLog.debug("*** Igual a SECCION: "+this.SECCION);
            retorno = this.getSubgerencia() + this.getRegion() + this.getZona();
            UtilidadesLog.debug("****Retorno: "+retorno);
            UtilidadesLog.info("DatoRegistro.obtenerCodigoUAPadre()): Salida");
            return retorno;
        }
        
        //Si obtenerTipoUnidad() == TERRITORIO Devuelve getSubgerencia() + getRegion() + getZona() + getSeccion()  
        if (tipoUnidad == this.TERRITORIO){
            UtilidadesLog.debug("*** Igual a TERRITORIO: "+this.TERRITORIO);
            retorno = this.getSubgerencia() + this.getRegion() + this.getZona() + this.getSeccion();
            UtilidadesLog.debug("****Retorno: "+retorno);
            UtilidadesLog.info("DatoRegistro.obtenerCodigoUAPadre()): Salida");
            return retorno;
        }
        UtilidadesLog.info("DatoRegistro.obtenerCodigoUAPadre()): Salida");
        return retorno;
    }
    
    public String obtenerCodigoUACompleto(String codigo){
        UtilidadesLog.info("DatoRegistro.generarRegistroCC(DTOFACConsolidado dtoConso): Entrada");
        String retorno = null;

        //Si obtenerTipoUnidad() == SUBGERENCIA Devuelve getSubgerencia() 
        if (obtenerTipoUnidad() == this.SUBGERENCIA){
            UtilidadesLog.debug("*** Igual a SUBGERENCIA: "+this.SUBGERENCIA);
            UtilidadesLog.info("DatoRegistro.obtenerCodigoUACompleto(String codigo): Salida");
            return this.getSubgerencia();
        }
        
        //Si obtenerTipoUnidad() == REGION Devuelve getSubgerencia() + getRegion()
        if (obtenerTipoUnidad() == this.REGION){ 
            UtilidadesLog.debug("*** Igual a REGION: "+this.REGION);
            retorno = this.getSubgerencia() + this.getRegion();
            UtilidadesLog.debug("****Retorno: "+retorno);
            UtilidadesLog.info("DatoRegistro.obtenerCodigoUACompleto(String codigo): Salida");
            return retorno;
        }
        
        //Si obtenerTipoUnidad() == ZONA Devuelve getSubgerencia() + getRegion() + getZona() 
        if (obtenerTipoUnidad() == this.ZONA){
            UtilidadesLog.debug("*** Igual a ZONA: "+this.ZONA);
            retorno = this.getSubgerencia() + this.getZona();
            UtilidadesLog.debug("****Retorno: "+retorno);
            UtilidadesLog.info("DatoRegistro.obtenerCodigoUACompleto(String codigo): Salida");
        } 
        
        //Si obtenerTipoUnidad() == SECCION Devuelve getSubgerencia() + getRegion() + getZona() + getSeccion() 
        if (obtenerTipoUnidad() == this.SECCION){
            UtilidadesLog.debug("*** Igual a SECCION: "+this.SECCION);
            retorno = this.getSubgerencia() + this.getRegion() + this.getZona() + this.getSeccion();
            UtilidadesLog.debug("****Retorno: "+retorno);
            UtilidadesLog.info("DatoRegistro.obtenerCodigoUACompleto(String codigo): Salida");
        } 
        
        UtilidadesLog.info("DatoRegistro.obtenerCodigoUACompleto(String codigo): Salida");
        return retorno;
    }

    public String obtenerNSE1()
    {
        return this.NSE1;
    }

    public String obtenerNSE2()
    {
        return this.NSE2;
    }
  /**
   * INC BELC300024021 gPineda 06/06/2006
   * @return 
   * @param otroDatoRegistro
   */
    public String obtenerCodigoHastaVariacion( DatoRegistro otroDatoRegistro )
    {
        UtilidadesLog.info("DatoRegistro.obtenerCodigoHastaVariacion(DatoRegistro otroDatoRegistro): Entrada");
        String miCod = null;
        String otroCod = null;
        String retorno =  null;
        String sDescRetorno = null;
        
        miCod = this.getSubgerencia();
        otroCod = otroDatoRegistro.getSubgerencia();
        if( retorno == null && miCod != null && otroCod != null &&
            ! miCod.equals(otroCod) )
            {
              retorno =  this.getSubgerencia();
              sDescRetorno = "SUBGERENCIA";
            }
        
        miCod = this.getRegion();
        otroCod = otroDatoRegistro.getRegion();
        if( retorno == null && miCod != null && otroCod != null &&
            ! miCod.equals(otroCod) )
            {
              retorno =  this.getSubgerencia() + this.getRegion();
              sDescRetorno = "REGION";
            }
            
        miCod = this.getZona();
        otroCod = otroDatoRegistro.getZona();
        if( retorno == null && miCod != null && otroCod != null &&
            ! miCod.equals(otroCod) )
            {
              retorno =  this.getSubgerencia() + this.getRegion() + this.getZona();
              sDescRetorno = "ZONA";
            }

        miCod = this.getSeccion();
        otroCod = otroDatoRegistro.getSeccion();
        if( retorno == null && miCod != null && otroCod != null &&
            ! miCod.equals(otroCod) )
            {
              retorno =  this.getSubgerencia() + this.getRegion() + this.getZona() + this.getSeccion();
              sDescRetorno = "SECCION";
            }
   
        miCod = this.getTerritorio();
        otroCod = otroDatoRegistro.getTerritorio();
        if( retorno == null && miCod != null && otroCod != null &&
            ! miCod.equals(otroCod) )
            {
              retorno = this.getSubgerencia() + this.getRegion() + this.getZona() + this.getSeccion() + this.getTerritorio();
              sDescRetorno = "TERRITORIO";
            }
            
        UtilidadesLog.info("Se produce variacion a nivel de " + sDescRetorno + " (" + retorno +")" );
        UtilidadesLog.info("DatoRegistro.obtenerCodigoHastaVariacion(DatoRegistro otroDatoRegistro): Salida");
        return retorno;
    }
    
}