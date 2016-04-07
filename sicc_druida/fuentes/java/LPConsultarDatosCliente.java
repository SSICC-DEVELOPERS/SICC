/*
 *      LPConsultarDatosCliente.java
 */
 
 /**
  *   author: splatas
  */
  
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesSession;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Vector;
import es.indra.sicc.dtos.cob.DTODatosClienteCOB;


public class LPConsultarDatosCliente extends LPSICCBase
{
    private String accion = null; 
    
    
    public  LPConsultarDatosCliente() {
        super();
    }

   /*
    * -> Asignar página "contenido_datos_cliente_consultar"
    */
    public void inicio() throws Exception {
    
        pagina("contenido_datos_cliente_consultar");
    }

  /*  
   * Si accion = "" entonces 
   *     ejecutar "cargarPagina()" 
   *  Fin Si 
   */ 
   public void ejecucion() throws Exception {
                
        try {
          setTrazaFichero();
           //traza("en ejecucion");
          accion = conectorParametroLimpia("accion","",true);
          if( accion.equals("") ) {
            cargarPagina();
          }
          
          getConfiguracionMenu();
        }
        catch (Exception e) {
          //System.out.println("Entró en catch por...");
          lanzarPaginaError(e);
          //e.printStackTrace();
        }
  } 
     
     
  private void cargarPagina() throws Exception  {
		//traza("cargarPagina");
        //[1] pagina("contenido_datos_cliente_consultar");
        // -> Tomar de sesión el parámetro "codigoCliente" y el pais 
        //String codigoCliente = (String) conectorParametroSesion("codigoCliente");
		//[1] String codigoCliente = (String) conectorParametro("codigoCliente");
        //[1] Long sPais = UtilidadesSession.getPais(this);
        // -> Crear un objeto DTOString con esos datos 
        DTOString dtoString= new DTOString();
        dtoString.setCadena((String) conectorParametro("codigoCliente"));//[1] codigoCliente);
		  //traza("codigoCliente: "+codigoCliente);
        dtoString.setOidPais(UtilidadesSession.getPais(this));//[1] sPais);             
       // traza("pais: "+sPais);
        // -> Crear idBuisness = "COBConsultarDatosCliente" 
        MareBusinessID bussId = new MareBusinessID("COBConsultarDatosCliente");
        Vector vParams = new Vector();
        vParams.add(dtoString);
        vParams.add(bussId);        
       
        // -> Asignar conector "ConectorConsultarDatosClienteCOB" con idBusiness y dto creados 
		 // traza("antes de conectar");
        DruidaConector con = this.conectar("ConectorConsultarDatosClienteCOB", vParams);        
		//  traza("conectooooooooo: ");        
        
        // -> Recuperar DTODatosClienteCOB y mapear los datos en memoria
        DTODatosClienteCOB dtoDatosClienteCOB = 
                          (DTODatosClienteCOB) con.objeto("DTODatosClienteCOB");
		// traza("dto: "+dtoDatosClienteCOB);
        asignarAtributo("LABELC", "lbldtCodigoCliente", "valor", dtoDatosClienteCOB.getCodigoCliente()==null?"":dtoDatosClienteCOB.getCodigoCliente());          
        asignarAtributo("LABELC", "lbldtApellido1", "valor", dtoDatosClienteCOB.getApellido1()==null?"":dtoDatosClienteCOB.getApellido1());
        asignarAtributo("LABELC", "lbldtApellido2", "valor", dtoDatosClienteCOB.getApellido2()==null?"":dtoDatosClienteCOB.getApellido2());
        asignarAtributo("LABELC", "lbldtApellidoCasada", "valor", dtoDatosClienteCOB.getApellidoCasada()==null?"":dtoDatosClienteCOB.getApellidoCasada());
        asignarAtributo("LABELC", "lbldtNombre1", "valor", dtoDatosClienteCOB.getNombre1()==null?"":dtoDatosClienteCOB.getNombre1());
        asignarAtributo("LABELC", "lbldtNombre2", "valor", dtoDatosClienteCOB.getNombre2()==null?"":dtoDatosClienteCOB.getNombre2());
        asignarAtributo("LABELC", "lbldtTratamiento", "valor", dtoDatosClienteCOB.getTratamiento()==null?"":dtoDatosClienteCOB.getTratamiento());
        asignarAtributo("LABELC", "lbldtTipoVia", "valor", dtoDatosClienteCOB.getTipoVia()==null?"":dtoDatosClienteCOB.getTipoVia());
        asignarAtributo("LABELC", "lbldtNombreVia", "valor", dtoDatosClienteCOB.getNombreVia()==null?"":dtoDatosClienteCOB.getNombreVia());
        asignarAtributo("LABELC", "lbldtNumeroPrincipal", "valor", dtoDatosClienteCOB.getNumeroPrincipal()==null?"":dtoDatosClienteCOB.getNumeroPrincipal().toString());
        asignarAtributo("LABELC", "lbldtEstatus", "valor", dtoDatosClienteCOB.getEstatus()==null?"":dtoDatosClienteCOB.getEstatus());
        asignarAtributo("LABELC", "lbldtIndicadorActivo", "valor", dtoDatosClienteCOB.getIndicadorActivo()==null?"":dtoDatosClienteCOB.getIndicadorActivo().toString());
        asignarAtributo("LABELC", "lbldtFechaNacimiento", "valor", dtoDatosClienteCOB.getFechaNacimiento()==null?"":obtenerFechaFormatoPais( dtoDatosClienteCOB.getFechaNacimiento()));
        asignarAtributo("LABELC",  "lbldtInterior" , "valor", dtoDatosClienteCOB.getPuerta()==null?"":dtoDatosClienteCOB.getPuerta());
        /*  
         * INCIDENCIA 14515: No existe LABEL 'PUERTA'
         *  asignarAtributo("LABELC",  "lblinterior" , "valor", (sValor==null? "": sValor));
         */
         
 	}
  
     
  /* 
   * Retorna el string fecha segun el formato por pais.
   * La fecha a formatear viene en formato Date YYYY-MM-DD.
   */
  private String obtenerFechaFormatoPais(Date fecha) throws Exception 
  {   
      // obtenemos el formato de fecha actual segun el pais
      String formatoFecha = null;
      formatoFecha = UtilidadesSession.getFormatoFecha(this);
      
      // aseguro el indicador de mes a mayuscula  
      formatoFecha = formatoFecha.replace('m','M');
      
      //trabajamos con el formato del pais
      SimpleDateFormat formatoPais = new SimpleDateFormat(formatoFecha);
      
      //formateamos la fecha segun el formato del pais
      String fechaFormatoPaisStr = null;
      if (fecha != null){
         fechaFormatoPaisStr = formatoPais.format(fecha);
      }
      
      //retorna la fecha formateada    
      return fechaFormatoPaisStr;
    }
}
