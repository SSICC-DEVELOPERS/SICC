/*
    INDRA/CAR/PROY
    $Id: LPModificarCliente.java,v 1.1 2009/12/03 18:34:59 pecbazalar Exp $
    DESC
*/

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.xml.XMLDocument;
import java.io.ByteArrayInputStream;
import java.sql.Timestamp;

//Librerias DTO modulo
import es.indra.sicc.dtos.mae.DTOTipoSubtipo;
import es.indra.sicc.dtos.mae.DTOCodigoCliente;
import es.indra.sicc.dtos.mae.DTOPestanya1Base;
import es.indra.sicc.dtos.mae.DTOPestanya2;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.mae.DTOPestanya3;
import es.indra.sicc.dtos.mae.DTOCrearClienteBasico;
import es.indra.sicc.dtos.mae.DTOTipoSubtipoCliente;
import es.indra.sicc.dtos.mae.DTODireccion;
import es.indra.sicc.dtos.mae.DTOCliente;
import es.indra.sicc.dtos.mae.DTOValidarClientes;
import es.indra.sicc.dtos.mae.DTOPestanya4;
import es.indra.sicc.dtos.mae.DTOPreferencia;
import es.indra.sicc.dtos.mae.DTOObservacion;
import es.indra.sicc.dtos.mae.DTOTarjeta;
import es.indra.sicc.dtos.mae.DTOProblemaSolucion;
import es.indra.sicc.dtos.mae.DTOPsicografia;
import es.indra.sicc.dtos.mae.DTOPremioRecomendacion;
import es.indra.sicc.dtos.mae.DTOModificarCliente;
import es.indra.sicc.dtos.mae.DTOCampo;
import es.indra.sicc.dtos.mae.DTOConfiguracionCamposCliente;
import es.indra.sicc.dtos.mae.DTOComunicacion;
import es.indra.sicc.dtos.mae.DTOVinculo;
import es.indra.sicc.dtos.mae.DTOIdentificacion;
import es.indra.sicc.dtos.mae.DTOClienteMarca;
import es.indra.sicc.dtos.mae.DTOObtenerPestanya4;
import es.indra.sicc.dtos.mae.DTOClasificacionCliente;
import es.indra.mare.common.dto.MareDTO;


//Librerias Mare
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.exception.MareException;

//Librerias druida
import es.indra.druida.DruidaConector;

//Librerias Utilidades java
import java.util.Vector;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.lang.StringBuffer;
import java.lang.Exception;
import java.lang.Character;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.Calendar;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Text;


//Librerias utilidades XML
import org.w3c.dom.DOMException;

// Definicion de la clase
public class LPModificarCliente extends LPSICCBase {
private HashMap param = new HashMap();
private HashMap ptna1= new HashMap();
private HashMap ptna2= new HashMap();
private HashMap ptna3= new HashMap();
private HashMap ptna4 = new HashMap();
private HashMap tipoSubt= new HashMap();
private HashMap GrupoVinculo= new HashMap();
private String  hiddenOid  = new String("");
private String  hiddenCodigo = new String("");



public String accion;
//public String pestanyaAnterior;
          
public void inicio() throws Exception { 
                  //pagina("contenido_clientes_insertar");
                  //this.getConfiguracionMenu();   
  }

 public void ejecucion() throws Exception {
     setTrazaFichero();
  traza(" ************ Entro a Ejecucion **************");
  
  long tiempoInicio = System.currentTimeMillis();
  
         //String 
  accion = conectorParametro("accion");  
         accion = (accion==null )?"":accion;
         param=conectorParametro();

    //traza("Parametros de entrada" + param);
    traza("Entro a LP con accion = "+ accion);
    
  try{
           if(accion.equals("")) { 
      boolean reentrando = false;
      String pestanyaAnterior = this.conectorParametro("hPestanya");

      hiddenOid    = conectorParametroLimpia("dtoOid","",true);  
      hiddenCodigo = conectorParametroLimpia("hidCodigoCliente","",true);
        
      //traza("Accion vacia, Pestanya anterior: " + pestanyaAnterior);
      String sReentrandoP2 = "";
      String sReentrandoP3 = "";      
      String sReentrandoP4 = "";     
      conectorParametroSesion("hiddenOid",hiddenOid);
      conectorParametroSesion("hiddenCodigo",hiddenCodigo);
      
      if (pestanyaAnterior.equals("1")){
         reentrando = true;
         //this.asignarAtributo("VAR", "hReentrandoP1", "valor", "S" );
         ptna1 = param;
         this.conectorParametroSesion("pestana1", ptna1);
         param = (HashMap) this.conectorParametroSesion("tipoSubt"); 
         sReentrandoP2 = this.conectorParametro("hReentrandoP2"); 
         sReentrandoP3 = this.conectorParametro("hReentrandoP3");         
         sReentrandoP4 = this.conectorParametro("hReentrandoP4");                  
      }

      this.pagina("contenido_clientes_insertar");
      this.asignarAtributoPagina("cod", "0409");
                           this.asignarAtributo("VAR","casoDeUso","valor","ModificarCliente");      
      
      if (reentrando){
         this.asignarAtributo("VAR", "hReentrandoP1", "valor", "S" );
      }
         
      asignarAtributo("VAR", "hReentrandoP2", "valor", sReentrandoP2);
      asignarAtributo("VAR", "hReentrandoP3", "valor", sReentrandoP3);             
      asignarAtributo("VAR", "hReentrandoP4", "valor", sReentrandoP4);  
      asignarAtributo("VAR", "hiddenOid", "valor", hiddenOid);
      asignarAtributo("VAR", "hiddenCodigo", "valor", hiddenCodigo);
         
                           InicioLP(reentrando);
                           asignarAtributo("CAPA", "capaTitulo", "visibilidad", "hidden");
      long tiempoFin = System.currentTimeMillis();
      long tiempoTotal = tiempoFin - tiempoInicio;
      traza("Tiempo Total Accion Vacio: " + tiempoTotal);
                  }

                  if(accion.equals("Siguiente1")){ 
    
//         String cadenaPrueba = "h_oidCliente_0=243;h_comboTipoCliente_0=11;h_comboSubtipoCliente_0=18;h_descTipoCliente_0=BR-Gerente de zona;h_descSubtipoCliente_0=Normal";
//         this.parseaListaTipoSubtipo(cadenaPrueba);
    
         traza("*************** Siguiente1 ***************");
         boolean reentrando = false;
         
         String sReentrandoP2 = this.conectorParametro("hReentrandoP2");
         String sReentrandoP3 = this.conectorParametro("hReentrandoP3");         
         String sReentrandoP4 = this.conectorParametro("hReentrandoP4");                  
      
         //Guardo param de la pantalla anterior
         
         String pestanyaAnterior = (String) param.get("hPestanya");
         //traza("pestanya anterior: " + pestanyaAnterior);

         if (pestanyaAnterior.equals("0")) {
             traza("Viniendo a DNI desde Tipo/Subtipo");
             //traza("Tipo y Subtipo contiene " + param.toString() );         
             tipoSubt = param;
             this.conectorParametroSesion("tipoSubt", tipoSubt);
         
             // Determina si se está entrando por primera vez o ya se entro antes.
             String sReentrando = this.conectorParametro("hReentrandoP1");
             if (sReentrando == null || sReentrando.equals("") ) {
                 reentrando = false;
             } else {
                 reentrando = true;
             }
         } else if (pestanyaAnterior.equals("2")) {
             traza("Viniendo a DNI desde Pestanya 2 - Datos Personales");
             //traza("Pestaña de Datos personales contiene: " + param.toString() );
             ptna2 = param;
             this.conectorParametroSesion("pestana2", ptna2);     
  
             // es OBVIO que se está reingrensando (se está yendo de la 2 a la 1).
             reentrando = true;
         }

         this.mostrarPantalla(accion);
         asignarAtributo("VAR","casoDeUso","valor","ModificarCliente");         
         if (reentrando){   
             param = (HashMap) this.conectorParametroSesion("pestana1");
             //traza("param entrando a Pestanya 1: " + param.toString() );
             //asignarAtributo("VAR", "hReentrandoP1", "valor", "S");
         }
         asignarAtributo("VAR", "hReentrandoP1", "valor", "S");
         asignarAtributo("VAR", "hReentrandoP2", "valor", sReentrandoP2);
         asignarAtributo("VAR", "hReentrandoP3", "valor", sReentrandoP3);             
         asignarAtributo("VAR", "hReentrandoP4", "valor", sReentrandoP4);             
         
         this.colaParametros(0);
         this.Siguiente1(reentrando);

         long tiempoFin = System.currentTimeMillis();
         long tiempoTotal = tiempoFin - tiempoInicio;
         traza("Tiempo Total Accion Siguiente1: " + tiempoTotal);
         

                  }

                  if(accion.equals("Validar")) { 
         traza("********** Validar *************");

         // **** Determina si se está reentrando o es la primera vez. 
         boolean reentrando = false;
         String sReentrandoP1 = this.conectorParametro("hReentrandoP1");
         String sReentrandoP3 = this.conectorParametro("hReentrandoP3");         
         String sReentrandoP4 = this.conectorParametro("hReentrandoP4");                 

         //Guardo param de la pantalla anterior
         // TO DO: Setear de QUE PESTAÑA se viene a la 2 ( de la 1 o la 3).
         //String pestanyaAnterior = (String) this.conectorParametro("hPestanya");
         String pestanyaAnterior = (String) param.get("hPestanya");
         //traza("pestanya anterior: " + pestanyaAnterior);
         if(pestanyaAnterior.equals("1")){
           traza("Ingresando a Datos Cliente desde DNI");
           //traza("Datos DNI contiene " + param.toString() );         
           ptna1 = param;
           this.conectorParametroSesion("pestana1", ptna1);

           // Determina si se esta reentrando o es primerva vez. 
           String sReentrandoP2 = this.conectorParametro("hReentrandoP2");
           if (sReentrandoP2 == null || sReentrandoP2.equals("") )
             reentrando = false;
           else
             reentrando = true;
           
        } else if (pestanyaAnterior.equals("3")) {
           traza("Reingresando a DNI desde Pestanya 2 - Datos Personales");
           traza("Pestaña de Datos personales contiene: " + param.toString() );
           ptna3 = param;
           this.conectorParametroSesion("pestana3", ptna3);         

           // Chequea si se está volviendo de ls P2 (datos cliente) 
           // debido al error 160280004 o 160280003 (inc BELC300014099) (MAE-20 y MAE-19).
           // En ese caso, setea la variable sReentrandoP3 a "" para
           // indicar que la proxima vez que se entre a P3, es como
           // si fuera la primera vez
           String codigoErrorP3 = (String) param.get("errCodigo");
           if (codigoErrorP3.equals("160280004") || codigoErrorP3.equals("160280003") )//inc BELC300014099

             sReentrandoP3 = "";

           // Se está viniendo de la 3, o sea, se está reentrando. 
           reentrando = true;
         }  
         traza("antes de mostrar pantalla");
         this.mostrarPantalla(accion);
         asignarAtributo("VAR","casoDeUso","valor","ModificarCliente");                  

         if (reentrando){   
             param = (HashMap) this.conectorParametroSesion("pestana2");
             //traza("param de Pestanya 2: " + param.toString() );
         }         

         asignarAtributo("VAR", "hReentrandoP1", "valor", sReentrandoP1);
         asignarAtributo("VAR", "hReentrandoP2", "valor", "S");
         asignarAtributo("VAR", "hReentrandoP3", "valor", sReentrandoP3);             
         asignarAtributo("VAR", "hReentrandoP4", "valor", sReentrandoP4);             
         

         this.Validar(reentrando);
         long tiempoFin = System.currentTimeMillis();
         long tiempoTotal = tiempoFin - tiempoInicio;
         traza("Tiempo Total Accion Validar: " + tiempoTotal);         

                  }

    if(accion.equals("Siguiente3_Validar")){ 
        traza("esta en accion 3 validar");
        this.mostrarPantalla(accion);
        this.Siguiente3_Validar();

        long tiempoFin = System.currentTimeMillis();
        long tiempoTotal = tiempoFin - tiempoInicio;
        traza("Tiempo Total Accion Siguiente3_Validar: " + tiempoTotal);         

    }
    
                  if(accion.equals("Siguiente3")){ 
                  
                           traza("*************** Siguiente 3 ***************");
                           boolean reentrando = false;
                           String sReentrandoP1 = (String) this.conectorParametro("hReentrandoP1");
      traza("Reentrando a P1: " + sReentrandoP1);
                           String sReentrandoP2 = (String) this.conectorParametro("hReentrandoP2");
      traza("Reentrando a P2: " + sReentrandoP2);      
                           String sReentrandoP4 = (String) this.conectorParametro("hReentrandoP4");                  
      traza("Reentrando a P4: " + sReentrandoP4);             
                           
                           //Guardo param de la pantalla anterior
                           
                           String pestanyaAnterior = (String) param.get("hPestanya");
                           //traza("pestanya anterior: " + pestanyaAnterior);
                           if ( pestanyaAnterior.equals("2")){
                                traza("Ingresando a Pestanya 3 (Direccion) desde P2");
                                //traza(" Parametros de P2 son: " + param.toString() );
                                ptna2 = param;
                                this.conectorParametroSesion("pestana2", ptna2);
                                
                                // Determino si estoy reentrando o es la primera vez. 
                                String sReentrandoP3 = (String) this.conectorParametro("hReentrandoP3");
                                if ( sReentrandoP3 == null || sReentrandoP3.equals("") )
                                	reentrando = false;
                                 else
                                 	reentrando = true;
                           
                                    
                           }else if (pestanyaAnterior.equals("4")){
                                    // Obviamente se está reentrando.
                                    traza("Reentrando a Pestanya 3 desde Pestanya 4");
                                    //traza("Valores de P4 son: " + param.toString() );
                                    ptna4 = param;
                                    this.conectorParametroSesion("pestana4", ptna4); 
                                    
                                    reentrando = true;
         sReentrandoP4 = "S";
                           } 
                           
                           this.mostrarPantalla("Siguiente3");
                           asignarAtributo("VAR","casoDeUso","valor","ModificarCliente");	
      //if ( pestanyaAnterior.equals("2") )
      this.colaParametros(2);      
                           
                           if (reentrando){
                                    // Obtenemos los datos de Sesion 
                                    param = (HashMap) this.conectorParametroSesion("pestana3");
                                    //traza("Parametros en sesion de Pestanya 3: " + param.toString() );
                           }

      this.asignarAtributo("VAR", "hReentrandoP1", "valor", sReentrandoP1);
      this.asignarAtributo("VAR", "hReentrandoP2", "valor", sReentrandoP2);
      this.asignarAtributo("VAR", "hReentrandoP3", "valor", "S");
      this.asignarAtributo("VAR", "hReentrandoP4", "valor", sReentrandoP4);                                 
                           
                           this.Siguiente3(reentrando);

      long tiempoFin = System.currentTimeMillis();
      long tiempoTotal = tiempoFin - tiempoInicio;
      traza("Tiempo Total Accion Siguiente3: " + tiempoTotal);         
      
                  
                  }

    if(accion.equals("Siguiente4")){ 
           // llama a la pestanya 4
           traza(" ********* Entrando a la Pestaña 4 ******** ");
           boolean reentrando = false;

                           String sReentrandoP1 = (String) this.conectorParametro("hReentrandoP1");
           traza("Reentrando P1: " + sReentrandoP1);
                  String sReentrandoP2 = (String) this.conectorParametro("hReentrandoP2");
           traza("Reentrando P2: " + sReentrandoP2);           
                  String sReentrandoP3 = (String) this.conectorParametro("hReentrandoP3");           
           traza("Reentrando P3: " + sReentrandoP3);                      
                           String sReentrandoP4 = (String) this.conectorParametro("hReentrandoP4");                  
           traza("Reentrando P4: " + sReentrandoP4);                      

           // Setea el valor de param en Pestaña 3 en sesion 
           // ya que SIEMPRE contiene los valores de P3 cuando entra. }
           traza("Valores de P3 entrando en P4: " + param.toString() );
           ptna3 = param;

           String indGeo = (String) param.get("usaGeoreferenciador");  // BELC300023061 paso este indicador para validacion en P4 GrupoClasificacion
           traza(" usaGeoreferenciador_" + indGeo);
           this.conectorParametroSesion("pestana3", ptna3);

           // Chequea si se está reentrando. Como la primera vez siempre setea en S
           // el valor de la variable de reentrada, basta chequear esto para determinar
           // si se reentra. OJO: Valor se toma de datos de la pestaña 3.

           String sReentrando = (String)param.get("hReentrandoP4");

           if (sReentrando == null || sReentrando.equals("") ){
              reentrando = false;             
              traza("Reentrando es false");
           }else{
              reentrando = true;           
              traza("Reentrando es true");
           }


           if (reentrando){
             // Obtenemos los datos de PEstanya4 de Sesion. 
                                    param = (HashMap) this.conectorParametroSesion("pestana4");
                           traza("Parametros en sesion de Pestanya 4: " + param.toString() );
           }
                      
           this.mostrarPantalla("Siguiente4");
                           this.asignarAtributo("VAR","casoDeUso","valor","ModificarCliente");	           
           
           // Setea las variables de form. que definan la entrada y salida del caso de uso.
           this.asignarAtributo("VAR", "hReentrandoP1", "valor", sReentrandoP1);
           this.asignarAtributo("VAR", "hReentrandoP2", "valor", sReentrandoP2);
           this.asignarAtributo("VAR", "hReentrandoP3", "valor", "S");
           this.asignarAtributo("VAR", "hReentrandoP4", "valor", "S");                              
           this.asignarAtributo("VAR", "usaGeoreferenciador", "valor", indGeo);  // // BELC300023061 - Seteo para P4
           
           this.siguiente4(reentrando);
           
           if ("true".equals(indGeo)) {
              // Pongo la imagen de obligatorio (*) en los siguientes campos (son el 'Grupo2' de VALIDACION) - Inc. 23061
                        asignarAtributo("COMBO", "cbTipoCliente", "req", "S");
              asignarAtributo("COMBO", "cbSubtipoCliente", "req", "S");
              asignarAtributo("COMBO", "comboTipoClasificacion", "req", "S");
              asignarAtributo("COMBO", "comboClasificacion", "req", "S");
                    }

           long tiempoFin = System.currentTimeMillis();
           long tiempoTotal = tiempoFin - tiempoInicio;
           traza("Tiempo Total Accion Siguiente4: " + tiempoTotal);
           
    }
                  if(accion.equals("Guardar")){ 
         traza("Entro al guardar");
         this.guardar();
         long tiempoFin = System.currentTimeMillis();
         long tiempoTotal = tiempoFin - tiempoInicio;
         traza("Tiempo Total Accion Guardar: " + tiempoTotal);         
         
           //dtoClienteBasico.setApellido1();
      
                  }

                  if(accion.equals("BackP1")){ 

      //this.goBack1();
      
/*                         this.mostrarPantalla(accion);
                           //colaParametros(1);
                           this.BackP1();
                           asignarAtributo("VAR","casoDeUso","valor","ModificarCliente");
                           asignarAtributo("VAR","oidNull","valor",ptna2.get("oidNull").toString());*/
                  }

                  if(accion.equals("BackP2")){ 
         // Regresa a Pestanya 2. Desde la 3. 
   /*   ptna3 = param;
      conectorParametroSesion("pestana3", ptna3);

      // Toma el hashMap de la pestaña 2 de sesion y lo METE en param.
      param = (HashMap) conectorParametroSesion("pestana2");
      this.mostrarPantalla("Validar");
                           //colaParametros(1);
                           this.Validar(true);
                           asignarAtributo("VAR","casoDeUso","valor","ModificarCliente");*/
                  }

                  if(accion.equals("BackP3")){ 
                  }

    if ( accion.equals("volverTipoSubTipo")){
         // Solo se vuelve desde la pestaña 1, así que es la unica opcion (para este caso).
         traza("Volver a Tipo/SubTipo");
         ptna1 = param;
         conectorParametroSesion("pestana1", ptna1);
         traza("contenido de pestanya 1 antes de volver a TipoSubtipo: "+ ptna1.toString() );

         param = (HashMap) conectorParametroSesion("tipoSubt");
         this.mostrarPantalla("");
                           this.asignarAtributo("VAR","casoDeUso","valor","ModificarCliente");         
         this.InicioLP(true);  // está reentrando.
    }

    if (accion.equals("modificarTipoSubtipo")) {
         this.mostrarPantalla("modificarTipoSubtipo");
         this.modificarTipoSubtipo();
    }
      

      if (!accion.equals("Guardar")) {
           this.getConfiguracionMenu();                    
           }
      
      }catch (Exception ex){
      this.traza("Error en ejecucion");
      this.traza(ex);
      this.lanzarPaginaError(ex);
    }
 }
  private Object obtenerDatosSalida(String bID,String conector,Object dto)throws Exception{
                           try{
         traza("bID: " + bID);
         traza("Conector: " + conector);
                                    traza("entro a ObtenerDatos Salida");
                  Vector objBussines = new Vector();
                  MareBusinessID id = new MareBusinessID(bID);
                  objBussines.add(dto);
                  objBussines.add(id);
                  DruidaConector ver =conectar(conector,objBussines);
                  Object obj = ver.objeto("DTOSalida");
                                    //traza("ver DTOSalida: " + obj.toString());
         traza("saliendo de obtener datos salida");
                  return obj;
                           }catch(Throwable th){
             this.traza("error en Obtener Datos Salida");
             ByteArrayOutputStream stack = new ByteArrayOutputStream();
             PrintStream out = new PrintStream(stack);
             th.printStackTrace(out);
             traza(  stack.toString());
             BelcorpError belcorpError = new BelcorpError();
             DTOError dtoError = belcorpError.obtenerError(      th, 
             UtilidadesSession.getIdioma_ISO( this ) , 
                                             ""      
                                           );
             String s = th.getMessage();
             traza (  dtoError.getCodigoError() + " - " + dtoError.getDescripcionError() );
                    throw((Exception) th);
        
            }     
                     
  }

  private void mostrarPantalla(String accion) throws Exception {
     try {
         String oid    = (String) conectorParametroSesion("hiddenOid");
         String codigo = (String) conectorParametroSesion("hiddenCodigo");
         traza("el oid " + oid); 
         traza("el codigo " + codigo); 
         traza("Mostrar pantalla en " + accion);
         
         if (accion.equals("") ) {
            traza("Accion vacia");
            this.pagina("contenido_clientes_insertar");
            this.asignarAtributoPagina("cod", "0409");
            asignarAtributo("VAR", "hiddenOid", "valor", oid);
            asignarAtributo("VAR", "hiddenCodigo", "valor", codigo);
         }
  
         if (accion.equals("Siguiente1")) {
            traza("Siguiente1");
            this.pagina("contenido_grupo1_cliente_basico_crear2");
            this.asignarAtributoPagina("cod", "0409");   
            //SICC-GCC-MAE-006 - Cleal
            DTOCliente clie = (DTOCliente)conectorParametroSesion("DTOCliente");             
            if (clie.getIndicadorActivo() == null) {
                asignarAtributo("VAR","hIndActivoP2","valor","");
                traza("ind acti vacio");
            } else {
                asignarAtributo("VAR", 
                                  "hIndActivoP2", 
                                  "valor", 
                                  clie.getIndicadorActivo().toString());
                traza("clie.getIndicadorActivo().toString(): " + 
                           clie.getIndicadorActivo().toString());
            }
            asignarAtributo("VAR", "hiddenOid", "valor", oid);
            asignarAtributo("VAR", "hiddenCodigo", "valor", codigo);
         }

         if (accion.equals("Validar")) {
           pagina("contenido_grupo2_insertar");    
      
           // Setea pais e idioma de sesion para usar al con "recargaCombo" 
           // combo Periodo de Contacto.
           Long pais = UtilidadesSession.getPais(this);
           Long idioma = UtilidadesSession.getIdioma(this);
           this.asignarAtributo("VAR", "paisUsuario", "valor", pais.toString() );
           this.asignarAtributo("VAR", "idiomaUsuario", "valor", idioma.toString() );    
           this.asignarAtributo("VAR", "hiddenOid", "valor", oid);
           // Modificado por SICC20070431 - Rafael Romero - 27/09/2007
           // la pagina no tiene el campo para recibir el codigo, se asigna a una variable que si existe
           //this.asignarAtributo("VAR", "hiddenCodigo", "valor", codigo);
           this.asignarAtributo("VAR", "codigoCliente", "valor", codigo);
           // Fin modificado SICC20070431
           
           // vbongiov -- SiCC20070455 MAE -- 11/12/2007
           Timestamp fec_actu = new Timestamp(System.currentTimeMillis());
           java.sql.Date fd = new java.sql.Date(fec_actu.getTime());
           traza("fDesde: " + fd);          

           asignarAtributo("LABELC", "lblFechaIngresoActual", "valor",
              transformaFechas(fd));
           asignarAtributo("VAR", "hidFechaIngreso", "valor", transformaFechas(fd));
           
           traza("transformaFechas(fd): " + transformaFechas(fd));      
          
           // Calculo fecha desde + 1 año
           Calendar calendHasta = Calendar.getInstance();                  
           calendHasta.setTime(fec_actu);
          
           calendHasta.add(Calendar.YEAR, 1);
          
           java.util.Date fHastaCal = calendHasta.getTime();
          
           Date fHasta = new Date(fHastaCal.getTime());
          
           traza("fHasta: " + fHasta);
          
           asignarAtributo("VAR", "hidFechaHasta", "valor", transformaFechas(fHasta));        
          
           asignarAtributo("VAR", "OID_TIPO_VINCULO_RECOMENDANTE_RECOMENDADA", "valor", ConstantesMAE.OID_TIPO_VINCULO_RECOMENDANTE_RECOMENDADA.toString()); 
           
           this.asignarAtributoPagina("cod", "0409");    
         }

         if (accion.equals("Siguiente3_Validar")) {
           traza("entro en sig 3 validar");
           pagina("salidaGenerica");
           asignarAtributo("VAR", "cerrarVentana", "valor", "false");
         }

         if (accion.equals("Siguiente3")) {
            //pagina("contenido_grupo3_insertar1");
            pagina("contenido_grupo3_insertar");
            getFormatosValidaciones();
            this.asignarAtributoPagina("cod", "0409");    
            asignarAtributo("VAR", "hiddenOid", "valor", oid);
            asignarAtributo("VAR", "hiddenCodigo", "valor", codigo);
         }

         if (accion.equals("Siguiente4") ) {
           //this.pagina("contenido_grupo4_insertar0");    
           this.pagina("contenido_grupo4_insertar"); // La final
		   // vbongiov -- 17/10/2008
		   getFormatosValidaciones();
           this.asignarAtributoPagina("cod", "0409");  
           asignarAtributo("VAR", "hiddenOid", "valor", oid);
           asignarAtributo("VAR", "hiddenCodigo", "valor", codigo);
         }

         if (accion.equals("BackP1")) {
            pagina("contenido_grupo2_insertar0");
         }
      
        if (accion.equals("BackP2")){
           pagina("contenido_grupo2_insertar0");
         }  

         if (accion.equals("modificarTipoSubtipo")) {
             pagina("contenido_clientes_modificar_tipo_subtipo");
         }

         this.getConfiguracionMenu();  
     } catch(Throwable th) {
         this.traza("error en Mostrar Pantalla");
         ByteArrayOutputStream stack = new ByteArrayOutputStream();
         PrintStream out = new PrintStream(stack);
         th.printStackTrace(out);
         traza(  stack.toString());
         BelcorpError belcorpError = new BelcorpError();
         DTOError dtoError = belcorpError.obtenerError(  th, 
         UtilidadesSession.getIdioma_ISO( this ) , 
                                         ""  
                                      );
         String s = th.getMessage();
         traza (  dtoError.getCodigoError() + " - " + dtoError.getDescripcionError() );
                throw((Exception) th);
   
        }     
  }

  private void InicioLP(boolean reentrando)throws Exception{
         this.traza("1111111111111111111111111111111111Estoy en InicioLP");
         traza("param en InicioLP: " + param.toString() );

         Long oidIdioma = UtilidadesSession.getIdioma(this);
         Long oidPais = UtilidadesSession.getPais(this);
         String oidCliente = null;         
         String sSeparadorCampos = ";";
         String sSeparadorLineas = "|";
         
         traza("Obtengo oidCliente");
         if (!param.containsKey("dtoOid") ) {
            traza("param no contiene dtoOid");
            oidCliente = (String) this.conectorParametroSesion("oidCliente");
            traza("oidCliente tomado de sesion: " + oidCliente);
         } else {
            oidCliente = (String) param.get("dtoOid");
         }

         this.conectorParametroSesion("oidCliente", oidCliente);
         traza("oidCliente: " + oidCliente);
         
         /*try {*/
            if (!reentrando) {
                traza("Entrando por primera vez al Caso de Uso");
                UtilidadesBelcorp TVinc = new UtilidadesBelcorp();                
                DTOOID dtooid = new DTOOID();
                DTOBelcorp dtoBelcorp = new DTOBelcorp();
                DTOTipoSubtipo dtotsubtipo = null;                
                DTOCliente dtocliente = null;

                if(oidCliente != null){
                                 dtooid.setOid( Long.valueOf(oidCliente) );
                }

                dtooid.setOidIdioma(oidIdioma);
                dtooid.setOidPais(oidPais);

                dtoBelcorp.setOidPais(oidPais);
                dtoBelcorp.setOidIdioma(oidIdioma);

                /* Obtenemos e DTOCliente y el TipoSubtipo */      
                dtocliente=(DTOCliente)obtenerDatosSalida("MAEObtenerCliente",
                                                                "ConectorObjetoGenerico",
                                                                (DTOOID) dtooid);
                                                                
                dtotsubtipo= (DTOTipoSubtipo)obtenerDatosSalida("MAEObtenerTipoSubtipo",
                                                                      "ConectorTipoSubtipo",
                                                                      (DTOBelcorp) dtoBelcorp);
                                                                      
                /*DTOTipoSubtipoCliente[] dtoT = dtocliente.getBase().getTiposSubtipos();
                traza("En Inicio LP - OID Cliente: " + dtocliente.getOid().toString());
                
                StringBuffer sListaTipoSubtipo = new StringBuffer();
                long cantElementos = dtoT.length;
                
                for (int i=0; i < cantElementos; i++) {
                    traza("bucle " + i + ", DTOTipo: " + dtoT[i].toString() );
                    if (i != 0) {
                      sListaTipoSubtipo.append(sSeparadorLineas);
                    }

                    sListaTipoSubtipo.append( dtoT[i].getOid() );
                    sListaTipoSubtipo.append( sSeparadorCampos );
                    sListaTipoSubtipo.append( dtoT[i].getTipo() );                      
                    sListaTipoSubtipo.append( sSeparadorCampos );                      
                    sListaTipoSubtipo.append( dtoT[i].getSubtipo() );    
                }
                traza("A setear en variable de formulario: " + sListaTipoSubtipo.toString() );
                asignarAtributo("VAR", "listaTipoSubtipoUsuario", "valor", sListaTipoSubtipo.toString() );*/
                
                
                RecordSet rTipoSubtipo = dtocliente.getBase().getRTipoSubtipoCliente();
                DruidaConector conTipoSubtipo =
                         UtilidadesBelcorp.generarConector("rowset", 
                                                                rTipoSubtipo, 
                                                                rTipoSubtipo.getColumnIdentifiers());
                this.asignar("LISTADOA", "listado1", conTipoSubtipo, "rowset");

                this.traza("Cargamos combo tipo");                  
                RecordSet tipo = (RecordSet) dtotsubtipo.getTipos();
                TVinc.agregarRegistroVacio(tipo,0);
                Vector colID = tipo.getColumnIdentifiers();
                DruidaConector dtipo = this.generarConector("DTOSalida.tipos_ROWSET",
                                                                  tipo, 
                                                                  colID);
                asignar("COMBO", "comboTipoCliente", dtipo, "DTOSalida.tipos_ROWSET");

                this.traza("Cargamos listaoculta subtipo");                 
                RecordSet subtipo = (RecordSet) dtotsubtipo.getSubtipos();
                Vector colID2 = subtipo.getColumnIdentifiers();
                DruidaConector dsubtipo = 
                         this.generarConector("DTOSalida.subtipos_ROWSET",
                                                 subtipo, 
                                                 colID2);
                this.crearListaLP(colID2, 
                                    subtipo.getColumnCount(),
                                    "Capa1",
                                    "Lista1",
                                    "14",
                                    "200");
                asignar("LISTA",
                         "Lista1",
                         dsubtipo,
                         "DTOSalida.subtipos_ROWSET");
                                    traza("En InicioLP() - dtocliente.getOid().toString(): "+
                         dtocliente.getOid().toString());
                         
                asignarAtributo("VAR","hOidCliente","valor",dtocliente.getOid().toString());

                conectorParametroSesion("tipo",dtipo);
                conectorParametroSesion("subtipo",dsubtipo);
                conectorParametroSesion("DTOCliente",dtocliente);
           } else { // reentrando. 
                traza("Reentrando");
                String elementoLista = (String)param.get("elementos");
                RecordSet rListaSubtipos = this.parseaLista(elementoLista);
                /* 
                 * No pregunta si el RecordSet es nulo ya que siempre tiene 
                 * que existir al menos 1 Tipo/Subtipo para el cliente 
                 */ 
                DruidaConector con = UtilidadesBelcorp.generarConector("rowset", 
                                                                              rListaSubtipos,
                                                                              rListaSubtipos.getColumnIdentifiers());
                this.asignar("LISTADOA", "listado1", con, "rowset");
                                                                              
                /*if (!elementoLista.equals("") ) {
                    elementoLista = elementoLista.substring(0, elementoLista.length()-1);
                    traza("valor de elementoLista: " + elementoLista );  
                    StringTokenizer tok = new StringTokenizer(elementoLista, ";");
                    StringTokenizer tokElemento = null;
                    String sElem = null;
                    String sValor = null;
                    int i = 1;
                    StringBuffer sListaTipoSubtipo = new StringBuffer("");
                    while (tok.hasMoreTokens() ) {
                         sElem = tok.nextToken();
                         tokElemento = new StringTokenizer(sElem, "=");
                         
                         sValor = tokElemento.nextToken();
                         sValor = tokElemento.nextToken();
                         traza("sValor: " + sValor );

                         switch (i)
                         {
                           case 1:
                           case 2:
                           case 3:
                           case 4:
                             sListaTipoSubtipo.append(sValor + sSeparadorCampos);
                             break;
                           case 5:
                             sListaTipoSubtipo.append(sValor + sSeparadorLineas);
                             break;
                         }
                         if (i==5) {i = 0;}
                         i++;
                    }
                    
                    
                    sListaTipoSubtipo.substring(0, sListaTipoSubtipo.length()-1);
                    traza("Cadena a asignar a la Lista: " + sListaTipoSubtipo.toString() );
                    asignarAtributo("VAR", "listaTipoSubtipoUsuario", 
                                      "valor", sListaTipoSubtipo.toString() ); 
                    */
                    
                
                DTOBelcorp dtoBelcorp = new DTOBelcorp();
                this.traza("Cargamos Pais e Idiomas");
                dtoBelcorp.setOidPais(UtilidadesSession.getPais(this));
                dtoBelcorp.setOidIdioma(UtilidadesSession.getIdioma(this));

                DTOTipoSubtipo dtotsubtipo = new DTOTipoSubtipo();
                dtotsubtipo= (DTOTipoSubtipo)obtenerDatosSalida("MAEObtenerTipoSubtipo",
                                                                      "ConectorTipoSubtipo",
                                                                      (DTOBelcorp) dtoBelcorp);

                this.traza("Cargamos combo tipo");                  
                RecordSet tipo = (RecordSet)dtotsubtipo.getTipos();
                UtilidadesBelcorp.agregarRegistroVacio(tipo,0);
                Vector colID = tipo.getColumnIdentifiers();
                DruidaConector dtipo = this.generarConector("DTOSalida.tipos_ROWSET",
                                                                  tipo, 
                                                                  colID);
                asignar("COMBO","comboTipoCliente",dtipo,"DTOSalida.tipos_ROWSET");
    
                this.traza("Cargamos listaoculta subtipo");                 
                RecordSet subtipo = (RecordSet)dtotsubtipo.getSubtipos();
                Vector colID2 = subtipo.getColumnIdentifiers();
                DruidaConector dsubtipo = this.generarConector("DTOSalida.subtipos_ROWSET", 
                                                                     subtipo, 
                                                                     colID2);

                this.crearListaLP(colID2, 
                                    subtipo.getColumnCount(), 
                                    "Capa1", 
                                    "Lista1", 
                                    "14", 
                                    "200");
                asignar("LISTA", "Lista1", dsubtipo, "DTOSalida.subtipos_ROWSET");

                String elementosToDelete = (String) param.get("elemToDel");
                if (elementosToDelete == null) {elementosToDelete = "";}
                this.asignarAtributo("VAR", "elemToDel", "valor", elementosToDelete);
             }
           
                 
        /*} catch(Throwable th) {
           this.traza("error en InicioLP");
           ByteArrayOutputStream stack = new ByteArrayOutputStream();
           PrintStream out = new PrintStream(stack);
           th.printStackTrace(out);
           traza(  stack.toString());
           BelcorpError belcorpError = new BelcorpError();
           DTOError dtoError = belcorpError.obtenerError(         th, 
           UtilidadesSession.getIdioma_ISO( this ) , 
                                           ""         
                                         );
           String s = th.getMessage();
           traza (dtoError.getCodigoError() + " - " + dtoError.getDescripcionError());
           throw((Exception) th);
        }    */ 
  }

 private DruidaConector generarConector(String rowsetID, RecordSet datos,Vector columns)
                  throws DOMException,Exception
         {
                  StringBuffer salida = new StringBuffer();
                  int sizeColums = datos.getColumnCount();
                  int sizeRows = datos.getRowCount();
                  boolean flag = false;
                  Text txt;
                  if ( columns == null ){
                           columns = new Vector();
                  }

                  Vector columsDesc = datos.getColumnIdentifiers();		
                  
                  DruidaConector conectorValoresPosibles = new DruidaConector();				
                  XMLDocument xmlDoc  = new XMLDocument();
                  Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");			
                  Element e_rows = docDestino.createElement("ROWSET");
                  e_rows.setAttribute("ID",rowsetID);
                  docDestino.getDocumentElement().appendChild(e_rows);
                  
                  for (int i=0; i < sizeRows; i++)
                  {
                           Element e_row = docDestino.createElement("ROW");
                           e_rows.appendChild(e_row);

                           for (int j=0; j < sizeColums; j++){
                                    if ( columns.contains(columsDesc.elementAt(j)) ){
                                             Element e_campo2   = docDestino.createElement("CAMPO");
                                             if(flag){
                                                      e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString()+".DESCRIPCION");
                                                      flag=false;
                                             }else{
                                                      e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString()+".CODIGO");
                                                      flag=true;
                                             }
                                             e_campo2.setAttribute("TIPO","OBJECTO");
                                             e_campo2.setAttribute("LONGITUD","50");
                                             
                                                        txt = docDestino.createTextNode((datos.getValueAt(i,j)==null?"":datos.getValueAt(i,j).toString()));
                                                      
                                             e_campo2.appendChild(txt);
                                             e_row.appendChild(e_campo2);
                                    }
                           }
                  }	
                  conectorValoresPosibles.setXML(docDestino.getDocumentElement());
                  return conectorValoresPosibles;
         }

         private void crearListaLP(Vector nomColumns, int cantColumns,String nomCapa,String nomLista,String XCapa,String YCapa) throws Exception{
                  traza("dentro de crearListaLP()  " + nomColumns + " " + cantColumns);
                   
                  Document document = getXML();

                  Element eCapa = document.createElement("CAPA");
                  eCapa.setAttribute("nombre",nomCapa);
                  eCapa.setAttribute("alto","162");
                  eCapa.setAttribute("ancho","580");
                  eCapa.setAttribute("colorf","");
                  eCapa.setAttribute("borde","1");
                  eCapa.setAttribute("imagenf","");
                  eCapa.setAttribute("repeat","");
                  eCapa.setAttribute("padding","");
                  eCapa.setAttribute("visibilidad","hidden");
                  eCapa.setAttribute("contravsb","");
                  eCapa.setAttribute("zindex","");
                  eCapa.setAttribute("x",XCapa);
                  eCapa.setAttribute("y",YCapa);

                  Element eLista = document.createElement("LISTA");
                  
                  eLista.setAttribute("seleccion","boton"); eLista.setAttribute("nombre",nomLista);
                  eLista.setAttribute("ancho","580"); eLista.setAttribute("alto","150");
                  eLista.setAttribute("multisel","0"); eLista.setAttribute("incy","1");
                  eLista.setAttribute("incx","10"); eLista.setAttribute("colorf","#EFEFEF");
                  eLista.setAttribute("imagenoff","close_no.gif"); eLista.setAttribute("imagenon","close_up.gif");
                  eLista.setAttribute("accion",""); eLista.setAttribute("sep","|");
                  eLista.setAttribute("pixelsborde","3"); eLista.setAttribute("colorborde","#CCCCCC");

                  Element eCABECERA = document.createElement("CABECERA");
                  eCABECERA.setAttribute("nombre","cabecera");	eCABECERA.setAttribute("height","20");

                  Integer anchoCab;
                  if (cantColumns < 4) 
                           anchoCab = new Integer(580 / cantColumns);
                  else
                           anchoCab = new Integer(150);

                  Element eCOL_1 = document.createElement("COL");
                  eCOL_1.setAttribute("id","fondoCabecera"); eCOL_1.setAttribute("ancho", anchoCab.toString());

             Element eCOL_2 = document.createElement("COL");
                  eCOL_2.setAttribute("id","fondoCabecera"); eCOL_2.setAttribute("ancho", anchoCab.toString());
                  
                  Element eCOL_3 = document.createElement("COL");
                  eCOL_3.setAttribute("id","fondoCabecera"); eCOL_3.setAttribute("ancho", anchoCab.toString());

             Element eCOL_4 = document.createElement("COL");
                  eCOL_4.setAttribute("id","fondoCabecera"); eCOL_4.setAttribute("ancho", anchoCab.toString());
                  
                  Element eCOL_5 = document.createElement("COL");
                  eCOL_5.setAttribute("id","fondoCabecera"); eCOL_5.setAttribute("ancho", anchoCab.toString());

                  Element eCOL_6 = document.createElement("COL");
                  eCOL_6.setAttribute("id","fondoCabecera"); eCOL_6.setAttribute("ancho", anchoCab.toString());

                  Vector columnas = new Vector();

         for (int i = 0; i < cantColumns; i++) 
  {
                  Element eLABEL_2 = document.createElement("LABELC");
                  eLABEL_2.setAttribute("id","fondoCabecera");
                  eLABEL_2.setAttribute("nombre","lbDivisionesPoliticas" + i);
                  eLABEL_2.setAttribute("ancho", anchoCab.toString());	eLABEL_2.setAttribute("alto","20");
                  eLABEL_2.setAttribute("filas","1");		eLABEL_2.setAttribute("id","datosCamposCabecera");
                  
                  if (i != 0) 
                           eLABEL_2.setAttribute("valor", (String) nomColumns.get(i));
                  else
                           eLABEL_2.setAttribute("cod", "199");

                  eLABEL_2.setAttribute("enviaroculto","N");
                  columnas.add(eLABEL_2); //Agrego label a la columna
         }
                  traza("despues de poner en variables los titulos " + columnas.toString() + " " + cantColumns);
    
    
                  if (cantColumns >= 1) {
      if (columnas.get(0) == null)
         traza("columnas.get(0) es null"); 
         
                           eCOL_1.appendChild((Element) columnas.get(0));
                           eCABECERA.appendChild(eCOL_1);
                           traza("1");
                  }		
                  if (cantColumns >= 2) {
      if ( columnas.get(1) == null)
         traza("columnas.get(1) es null");
                           eCOL_2.appendChild((Element) columnas.get(1));
                           eCABECERA.appendChild(eCOL_2);
                           traza("2");
                  }
                  if (cantColumns >= 3)
    {
      traza("cantCols >= 3");
      if (columnas.get(2) == null)
         traza("columnas.get(2) es null");
                           eCOL_3.appendChild((Element) columnas.get(2));
                           eCABECERA.appendChild(eCOL_3);
                           traza("3");
                  }
                  if (cantColumns >= 4) {
                           eCOL_4.appendChild((Element) columnas.get(3));
                           eCABECERA.appendChild(eCOL_4);
                           traza("4");
                  }
                  if (cantColumns >= 5) {
                           eCOL_5.appendChild((Element) columnas.get(4));
                           eCABECERA.appendChild(eCOL_5);
                           traza("5");
                  }
                  if (cantColumns >= 6) {
                           eCOL_6.appendChild((Element) columnas.get(5));
                           eCABECERA.appendChild(eCOL_6);
                           traza("6");
                  }
  traza("------------------------------------------");
                  Element ePRESENTACION = document.createElement("PRESENTACION");
                  Integer ancho = new Integer(cantColumns * anchoCab.intValue());
                  ePRESENTACION.setAttribute("ancho", ancho.toString());
                  ePRESENTACION.setAttribute("filas","1");
         int swX1 = 0;
         StringBuffer cadena = new StringBuffer("['datosCamposCenterImpar'");
         traza("break brain");
         for (int i = 1; i < cantColumns; i++) {
                  if (swX1 == 0) {
                           cadena.append(", 'datosCamposCenterPar'"); 
                           swX1 = 1;
                  } else {
                           cadena.append(", 'datosCamposCenterImpar'"); 
                           swX1 = 0;
                  }
         }

         for (int i = 0; i < cantColumns; i++) {
                  Element eCOLP_2 = document.createElement("COL");
                  eCOLP_2.setAttribute("ancho",anchoCab.toString());
                  eCOLP_2.setAttribute("caracteres", "150");	
                  ePRESENTACION.appendChild(eCOLP_2); //Agrego columna a la presentacion
         }
                  cadena.append("]");

                  traza("### " + cadena.toString());
                  ePRESENTACION.setAttribute("bloquesid", cadena.toString());

                  Element eROWSET = document.createElement("ROWSET");

                  eLista.appendChild(eCABECERA); //Agrego la cabecera de la lista
                  eLista.appendChild(ePRESENTACION); //Agrego la presentacion de la lista
                  eLista.appendChild(eROWSET); //Agrego el rowset de la lista

                  eCapa.appendChild(eLista);

                  getXML().getElementsByTagName("FORMULARIO").item(0).appendChild(eCapa);		
         }

 private void Siguiente1(boolean reentrando) throws Exception {
          try { 
      this.traza("222222222222222222222222222222entro en Siguiente1");
      if (!reentrando) {
           traza("Entrando x primera vez");
           DTOBelcorp dtobelcorp = new DTOBelcorp();
           dtobelcorp.setOidPais( UtilidadesSession.getPais(this) );
           dtobelcorp.setOidIdioma( UtilidadesSession.getIdioma(this) );
           
           this.traza("Obtenemos la logica de negocio");
           DTOPestanya1Base dtop1Base = 
                    (DTOPestanya1Base) obtenerDatosSalida("MAEPestanya1Base",
                                                                "ConectorObjetoGenerico",
                                                                (DTOBelcorp) dtobelcorp);
                                                                
           RecordSet pestanya1 = (RecordSet) dtop1Base.getTiposDocumento();
           UtilidadesBelcorp.agregarRegistroVacio(pestanya1, 0);
           Vector colID = pestanya1.getColumnIdentifiers();
           DruidaConector doc = this.generarConector("DTOSalida.tiposDocumento",
                                                           pestanya1, 
                                                           colID);
           asignar("COMBO", "comboTipoDocId", doc, "DTOSalida.tiposDocumento");
  
           DTOCliente clieSesion = (DTOCliente) this.conectorParametroSesion("DTOCliente");
           
           traza("clieSesion.getBase: " + clieSesion.getBase() );
           String codigoCliente = clieSesion.getBase().getCodigoCliente();
           /*traza("En Siguiente1 - codigoCliente:"+codigoCliente);*/
           String digitoControl = clieSesion.getBase().getDigitoControl();
           /*traza("codigoCliente: " + codigoCliente);*/
           asignarAtributo("LABELC", "lblCodClienteActual", "valor", codigoCliente);
           asignarAtributo("VAR", "codCliente", "valor", codigoCliente);
           param.put("codCliente", codigoCliente );
           asignarAtributo("VAR", "hidCodigoAutomatico", "valor", "true");
           asignarAtributo("VAR", "hOidCliente", "valor", codigoCliente);           
           
           traza("Digito Control: " + digitoControl);
           if (digitoControl == null){
             digitoControl = "";
           }
           this.asignarAtributo("VAR", "hidDigitoControl", "valor", digitoControl );
    
           // Carga la variables de formulario hidListaIdentificacion con el contenido 
           // que habrá que mostrar en la lista (a partir del dtoCliente que hay en sesion). 
           /*DTOCliente dtocliente = null;
           dtocliente = (DTOCliente) this.conectorParametroSesion("DTOCliente");
           DTOIdentificacion[] arrayDTOIden = dtocliente.getBase().getIdentificaciones();
           DTOIdentificacion dtoIden = null;
           StringBuffer sListaIdentificacion = new StringBuffer("");
           long cantElems = arrayDTOIden.length;
           String sSeparadorCampos = ";";
           String sSeparadorLineas = "|";*/
           
           RecordSet rIdentificacion = 
                    clieSesion.getBase().getRIdentificacionCliente();
         /*for (int i=0; i < cantElems; i++) {
            dtoIden = arrayDTOIden[i];
            traza("bucle "+ i + ": " + dtoIden.toString() );
            if (i != 0 ) {
              sListaIdentificacion.append(sSeparadorLineas);
            }
            sListaIdentificacion.append( dtoIden.getOid().toString() + sSeparadorCampos);
            sListaIdentificacion.append( dtoIden.getTipoDocumento().toString() + sSeparadorCampos);             
            sListaIdentificacion.append( dtoIden.getNumeroDocumento().toString() + sSeparadorCampos);                           
            sListaIdentificacion.append( dtoIden.getNumeroDocumento().toString() + sSeparadorCampos);                                         
            sListaIdentificacion.append( dtoIden.getEsPrincipal().toString() + sSeparadorCampos);                                         
            sListaIdentificacion.append( dtoIden.getIndPersonaEmpresa() );                                                      
         }
  
         traza("Lista de identifiacacion a setear: " + sListaIdentificacion.toString() );
         asignarAtributo("VAR", 
                           "hidListaIdentificacion", 
                           "valor", 
                           sListaIdentificacion.toString() );*/
           traza("rIdentificacion: " + rIdentificacion);
           
           String sPersonaEmpresa = 
                    this.generaCadenaPersonaEmpresa(rIdentificacion);
           traza("columnaPersonaEmpresa: " + sPersonaEmpresa);
           DruidaConector conIdentificacion = 
                    UtilidadesBelcorp.generarConector("rowset", 
                                                           rIdentificacion, 
                                                           rIdentificacion.getColumnIdentifiers());
                           
           this.asignar("LISTADOA", "listado1", conIdentificacion, "rowset");
           this.asignarAtributo("VAR", 
                                   "columnaPersonaEmpresa", 
                                   "valor", 
                                   sPersonaEmpresa);
           
      } else {
           traza("Reentrando");    
           DTOBelcorp dtobelcorp = new DTOBelcorp();
           dtobelcorp.setOidPais( UtilidadesSession.getPais(this) );
           dtobelcorp.setOidIdioma( UtilidadesSession.getIdioma(this) );
           
           this.traza("Obtenemos la logica de negocio");
           DTOPestanya1Base dtop1Base = 
                    (DTOPestanya1Base)obtenerDatosSalida("MAEPestanya1Base",
                                                              "ConectorObjetoGenerico",
                                                              (DTOBelcorp)dtobelcorp);
           RecordSet pestanya1 =(RecordSet) dtop1Base.getTiposDocumento();
           UtilidadesBelcorp.agregarRegistroVacio(pestanya1,0); 
           Vector colID = pestanya1.getColumnIdentifiers();
           DruidaConector doc = this.generarConector("DTOSalida.tiposDocumento",pestanya1, colID);
           asignar("COMBO", "comboTipoDocId", doc, "DTOSalida.tiposDocumento");
  
           String sLista = (String)param.get("hidListaIdentificacion");
           RecordSet rListaIdentificacion = this.parseaLista(sLista);
           /* 
            * No pregunta si el RecordSet es nulo ya que siempre tiene 
            * que existir al menos 1 Identificacion para el cliente 
            */ 
           traza("rListaIdentificacion: " + rListaIdentificacion);
           DruidaConector conIndentificacion = 
                    UtilidadesBelcorp.generarConector("rowset",
                                                           rListaIdentificacion,
                                                           rListaIdentificacion.getColumnIdentifiers());
                                                        
           String sPersonaEmpresa = 
                    this.generaCadenaPersonaEmpresa(rListaIdentificacion);
           this.asignar("LISTADOA", "listado1", conIndentificacion, "rowset");
           traza("columnaPersonaEmpresa: " + sPersonaEmpresa);
           this.asignarAtributo("VAR", 
                                   "columnaPersonaEmpresa", 
                                   "valor", 
                                   sPersonaEmpresa);
  
           String sHidCodigoAutomatico = (String) param.get("hidCodigoAutomatico");
           asignarAtributo("VAR", "hidCodigoAutomatico", "valor", sHidCodigoAutomatico );         
  
           String sDigitoControl = (String) param.get("hidDigitoControl");
           if (sDigitoControl == null) {
             sDigitoControl = "";
           }
           asignarAtributo("VAR", "hidDigitoControl", "valor", sDigitoControl );                  
  
           String sCodigoCliente = (String) param.get("codCliente");
           if (sCodigoCliente == null) {
             sCodigoCliente = "";
           }
           asignarAtributo("LABELC","lblCodClienteActual","valor",sCodigoCliente);  
           asignarAtributo("VAR","codCliente", "valor", sCodigoCliente);
  
           String elemToDel = (String) param.get("elemToDelP2");
           if (elemToDel == null) { elemToDel="";}
           this.asignarAtributo("VAR", "elemToDelP2", "valor", elemToDel);
      }
          } catch(Throwable th) {
      this.traza("error en Siguiente1");
      ByteArrayOutputStream stack = new ByteArrayOutputStream();
      PrintStream out = new PrintStream(stack);
      th.printStackTrace(out);
      traza(  stack.toString());
      BelcorpError belcorpError = new BelcorpError();
      DTOError dtoError = belcorpError.obtenerError(    th, 
      UtilidadesSession.getIdioma_ISO( this ) , 
                                      ""    
                                    );
      String s = th.getMessage();
      traza (  dtoError.getCodigoError() + " - " + dtoError.getDescripcionError() );
             throw((Exception) th);
   }     
 }
 
 
 private String generaCadenaPersonaEmpresa(RecordSet r) throws Exception {
    long tiempoInicio = System.currentTimeMillis();
    int cantRegistros = r.getRowCount();
    StringBuffer sPersonaEmpresa = new StringBuffer("");
    for (int i=0; i<cantRegistros; i++ ) {
         if (i != 0) {
           sPersonaEmpresa.append(",");
         }
         String sValor = (String) r.getValueAt(i, 5);
         if (sValor != null && !sValor.equals("")) {
           sPersonaEmpresa.append(sValor);
         } else {
           sPersonaEmpresa.append(" ");
         }
    }
    
    long tiempoFin = System.currentTimeMillis();
    long tiempoTotal = tiempoFin - tiempoInicio;
    traza("Tiempo Total generaCadenaPersonaEmpresa() Vacio: " + tiempoTotal);
    
    return sPersonaEmpresa.toString();
 }

 private void Validar(boolean reentrando) throws Exception {
    traza("Entra a validar");
    traza("reentrando: " + reentrando);
    String longCodCliente = this.obtenerLongitudCodigoCliente().toString();
    traza("Long. codigo cliente: " + longCodCliente);
         
         try {
                            obtenerConfiguracionCampos();
                            traza("Sali de Configuracion Campos");
                            DTOCodigoCliente  dtocClien = new DTOCodigoCliente();
        DTOPestanya2 dtop2Base = null;        
                            UtilidadesBelcorp PVinc = new UtilidadesBelcorp();
                            UtilidadesBelcorp TVinc = new UtilidadesBelcorp();
                            UtilidadesBelcorp TPrefer = new UtilidadesBelcorp();
                            UtilidadesBelcorp TMarca = new UtilidadesBelcorp();
        
        this.asignarAtributo("VAR", "hidlongCliente", "valor", longCodCliente);
        
        traza("param en validar: " + param.toString() );
                            
        DTOCliente clieSesion = (DTOCliente) this.conectorParametroSesion("DTOCliente");
        String codigoCliente = clieSesion.getBase().getCodigoCliente();
        
        traza("Codigo de Cliente en DTOCliente en Sesion: " + codigoCliente );        
                            dtocClien.setOidIdioma(UtilidadesSession.getIdioma(this));
                            dtocClien.setOidPais(UtilidadesSession.getPais(this));
                            
                            String formatoFecha = UtilidadesSession.getFormatoFecha(this);
                            asignarAtributo("VAR","hFormatoFechaPais", "valor", formatoFecha);

                   //	Agregado por HRCS - Fecha 11/04/2007 - Incidencia Sicc20070184
          Long oidTipo = (Long)conectorParametroSesion("oidTipo");
          Long oidSubtipo = (Long)conectorParametroSesion("oidSubtipo");
                   dtocClien.setOidTipoCliente( oidTipo );
                   dtocClien.setOidSubTipoCliente( oidSubtipo );
          asignarAtributo("VAR", "cbTipo", "valor", oidTipo.toString() );
          asignarAtributo("VAR", "cbSTipo", "valor", oidSubtipo.toString() );

                   dtop2Base = (DTOPestanya2) obtenerDatosSalida("MAEPestanya2", "ConectorObjetoGenerico", (DTOCodigoCliente) dtocClien);

                   conectorParametroSesion("dtop2Base", dtop2Base);
                   traza("llame a la Logica de Negocios");
                   this.traza("Realizamos la logica con el DTOPestanya2");
        
        RecordSet marcasCombo = dtop2Base.getMarcas();
        traza("marcasCombo: " + marcasCombo);        

        // Setea Marca y Canal de Cliente Contacto
        if (marcasCombo != null) {
          DruidaConector con = UtilidadesBelcorp.generarConector("marcasCombo", 
                                                                         marcasCombo, 
                                                                         marcasCombo.getColumnIdentifiers());
          this.asignar("COMBO", "cbMarca", con, "marcasCombo");
        }

        RecordSet canalCombo = dtop2Base.getCanales();
        traza("canalCombo: " + canalCombo);        
        if (canalCombo != null) {
          DruidaConector con = UtilidadesBelcorp.generarConector("canalCombo", 
                                                                         canalCombo, 
                                                                         canalCombo.getColumnIdentifiers() );
          this.asignar("COMBO", "cbCanal", con, "canalCombo");           
        }
        // Fin Seteo Marca y Canal de Cliente Contacto        
         
                     if(!dtop2Base.getBase().getExiste().booleanValue()) {
             traza("No Existe cliente");
             RecordSet codClie = (RecordSet)dtop2Base.getBase().getFormasPago();
             codClie.removeColumn(1);
                                      Vector colID = codClie.getColumnIdentifiers();
                             DruidaConector dtipo = this.generarConector("DTOSalida.formasPago_ROWSET",codClie, colID);
                    conectorParametroSesion("cbFPago",dtipo);
             asignar("COMBO","cbFormaPago",dtipo,"DTOSalida.formasPago_ROWSET");
            	 } else {
             traza("existe cliente");
                                      if(dtop2Base.getBase().getEstaCastigado().booleanValue()) {
                  asignarAtributo("VAR","MsjValidacion","valor","MAE-0006");
                  asignarAtributo("VAR","SaldoCastigado","valor",dtop2Base.getBase().getSaldo().toString());
                  //falta recursar esta LP
              } else {
                  asignarAtributo("VAR","MsjValidacion","valor","MAE-0007");
                  conectorAction("LPModificarCliente");
                }
                            }


           traza("Asigna los recordset");
                            
                           RecordSet nacionalidad = (RecordSet)dtop2Base.getNacionalidad();
      traza("Nacionalidad: " + nacionalidad.toString() );
                           RecordSet estadoCivil = (RecordSet)dtop2Base.getEstadoCivil();
                           RecordSet nivelEstudios = (RecordSet)dtop2Base.getNivelEstudios();
      traza("nivel de estudios: " + nivelEstudios.toString() );
                           RecordSet NSEP = (RecordSet)dtop2Base.getNSEP();
                           RecordSet cicloVida = (RecordSet)dtop2Base.getCiclosVida();
                           RecordSet marcaObservacionN = (RecordSet)dtop2Base.getMarcas();
                           RecordSet tipoPreferenciaN = (RecordSet)dtop2Base.getTiposPreferencias();
                           TPrefer.agregarRegistroVacio(tipoPreferenciaN,0);
                           RecordSet tipoVinculo1 = (RecordSet)dtop2Base.getTiposVinculo();
                           traza("tipoVinculo1: "+tipoVinculo1);
                           TVinc.agregarRegistroVacio(tipoVinculo1,0);
                           RecordSet tipoClienteContactado = (RecordSet)dtop2Base.getTipoCliente();
      traza("tipoClienteContactado: " + tipoClienteContactado.toString() );
                           RecordSet marca = (RecordSet)dtop2Base.getMarcas();
                           TMarca.agregarRegistroVacio(marca,0);
                           
                           
                           traza("asigna los combos");
                           asignar("COMBO","cbNacionalidad",this.getRowset(nacionalidad,"DTOSalida.nacionalidad_ROWSET"));
                           asignar("COMBO","cbEstadoCivil",this.getRowset(estadoCivil,"DTOSalida.estadoCivil_ROWSET"));
                           asignar("COMBO","cbNivelEstudios",this.getRowset(nivelEstudios,"DTOSalida.nivelEstudios_ROWSET"));
                           asignar("COMBO","cbNivelSocioEconomico",this.getRowset(NSEP,"DTOSalida.NSEP_ROWSET"));
                           asignar("COMBO","cbCicloVidaFamiliar",this.getRowset(cicloVida,"DTOSalida.cicloVida_ROWSET"));
                           asignar("COMBO","comboTipoPreferencia",this.getRowset(tipoPreferenciaN,"DTOSalida.tiposPreferencias_ROWSET"));
                           asignar("COMBO","cbTipoClienteContactado",this.getRowset(tipoClienteContactado,"DTOSalida.tipoCliente_ROWSET"));
                           asignar("COMBO","comboMarca",this.getRowset(marca,"DTOSalida.marcas_ROWSET"));
                           asignar("COMBO","comboTipoVinculo",this.getRowset(tipoVinculo1,"DTOSalida.tiposVinculo_ROWSET"));

      DTOCliente clie = (DTOCliente)conectorParametroSesion("DTOCliente");             
      
      /*  vbongiov -- SiCC20070455 MAE -- 19/12/2007
        * Se elimina, la Fecha de Ingreso es la fecha del sistema
        * 
      // Para la Fecha de Ingreso en Pestaña 2: 
      // Primero, chequea que venga la fecha en clie. Si no:
      // 
      //  - Si esta vacio "hidFechaIngreso", pone la fecha del sistema en la pantalla.
      //  - Si no, pone el valor de hidFechaIngreso.
      Date dateFechaIngreso = clie.getBase().getFechaIngreso();
      String sFechaIngreso = null;
      String sFechaMostrar = null;           
      if (dateFechaIngreso == null){  // Si clie.getBase().getFechaIngreso() es null.
          // Toma el valor en hidFechaIngreso
          sFechaIngreso = (String) this.conectorParametro("hidFechaIngreso");
          sFechaMostrar = null;
          if (sFechaIngreso.equals("") ) { // Si ese valor esta vacio, toma la fecha actual.
             Date d = new Date();      
             sFechaMostrar = this.transformaFechas(d);
          } else { // Toma la fecha de la variable oculta (en realidad, se podria asignar directamente).
             String formatoFechaSesion = UtilidadesSession.getFormatoFecha(this);
             formatoFechaSesion = formatoFechaSesion.replace('m', 'M');
           
             SimpleDateFormat simpleDate = new SimpleDateFormat( formatoFechaSesion );
             Date d = simpleDate.parse(sFechaIngreso);
             sFechaMostrar = this.transformaFechas(d);;
          }         
      } else {
         sFechaMostrar = this.transformaFechas(dateFechaIngreso);
      }

      traza("Fecha a Mostrar en Label Fecha Ingreso: " + sFechaMostrar);
      //asignarAtributo("LABELC","lblFechaIngresoActual","valor",this.transformaFechas(clie.getBase().getFechaIngreso()));
      asignarAtributo("LABELC","lblFechaIngresoActual","valor", sFechaMostrar);      
      asignarAtributo("VAR", "hidFechaIngreso", "valor", sFechaMostrar);      
                            */
      
      if (!reentrando)  // Si es la primera vez que se entra carga los valores de la base.
      {
             if (clie.getBase().getApellido1() == null)
                asignarAtributo("CTEXTO","textApellido1","valor","");
             else
                asignarAtributo("CTEXTO","textApellido1","valor",clie.getBase().getApellido1());

             if (clie.getBase().getApellido2() == null)
                asignarAtributo("CTEXTO","textApellido2","valor","");
             else
                asignarAtributo("CTEXTO","textApellido2","valor",clie.getBase().getApellido2());                

             if (clie.getBase().getApellidoCasada() == null)
                asignarAtributo("CTEXTO","textApellidoCasada","valor","");
             else
                asignarAtributo("CTEXTO","textApellidoCasada","valor",clie.getBase().getApellidoCasada());                

             if (clie.getBase().getNombre1() == null)
                asignarAtributo("CTEXTO","textNombre1","valor","");
             else
                asignarAtributo("CTEXTO","textNombre1","valor",clie.getBase().getNombre1());                                

             if (clie.getBase().getNombre2() == null)
                asignarAtributo("CTEXTO","textNombre2","valor","");
             else
                asignarAtributo("CTEXTO","textNombre2","valor",clie.getBase().getNombre2());                                


             if (clie.getFechaNacimiento() != null)
                asignarAtributo("CTEXTO","textFechaNacimiento","valor",this.transformaFechas(clie.getFechaNacimiento()));
             if ( clie.getCodigoEmpleado() != null)
                asignarAtributo("CTEXTO","textCodEmpleado","valor",clie.getCodigoEmpleado());
             if ( clie.getCentroEstudios() != null)
                asignarAtributo("CTEXTO","textCentroEstudios","valor",clie.getCentroEstudios());
             if ( clie.getNumeroHijos() != null)
                asignarAtributo("CTEXTO","textNHijos","valor",clie.getNumeroHijos().toString());
             if ( clie.getPersonasDependientes() != null)
                asignarAtributo("CTEXTO","textNPersonasDependientes","valor",clie.getPersonasDependientes().toString());
                
             if ( clie.getImporteIngresos() != null){
                 String ingreso = new String();
                 ingreso = clie.getImporteIngresos().toString();

                 if(ingreso.indexOf(".") == -1){
                    traza("entro a Indexof");
                    String salida = new String();    
                    salida = ingreso + ".00"; 
                    ingreso = salida;
                  }else if(ingreso.endsWith(".0")){
                     traza("entro en el endwith"); 
                     String salida = new String();    
                     salida = ingreso + "0"; 
                     ingreso = salida;
                  }
                   
                                
                 traza("el importe es " + ingreso);
                 asignarAtributo("CTEXTO","textImporteIngresoFamiliar","valor",ingreso);
             }
             if ( clie.getOcupacion() != null )
                asignarAtributo("CTEXTO","textOcupacion","valor",clie.getOcupacion());
             if ( clie.getCentroTrabajo() != null )                
                asignarAtributo("CTEXTO","textCentroTrabajo","valor",clie.getCentroTrabajo());
             if ( clie.getClienteContactado() != null )
                asignarAtributo("CTEXTO","textCodClienteContactado","valor",clie.getClienteContactado());

             if (clie.getFechaPrimerContacto() != null )
             {
                traza("Fecha Primero Contacto: " + clie.getFechaPrimerContacto().toString() );
                asignarAtributo("CTEXTO","textFechaContacto","valor",this.transformaFechas(clie.getFechaPrimerContacto()));
             }

             if (clie.getFechaSiguienteContacto() != null)
             {
                traza("Fecha Siguiente Contacto: " + clie.getFechaSiguienteContacto().toString() );
                asignarAtributo("CTEXTO","textFechaSiguienteContacto","valor",this.transformaFechas(clie.getFechaSiguienteContacto()));
             }
             if ( clie.getProfesion() != null)
                asignarAtributo("CTEXTO","textProfesion","valor",clie.getProfesion());
             traza("1");
             if (clie.getCargo() != null)
                asignarAtributo("CTEXTO","textCargoDesempena","valor",clie.getCargo());
             traza("2");             
             asignarAtributo("LABELC",
                                "lblPaisContactoActual",
                                "valor",
                                UtilidadesSession.getDescripcionPais(this));
             traza("3");
             HashMap subtipo = (HashMap) this.conectorParametroSesion("tipoSubt");
             traza("MiSubtipo: " + subtipo.toString() );
             String sDescTipo = (String) subtipo.get("hDescripcionTipo");
             asignarAtributo("LABELC","lblTipoClienteContactoActual","valor", sDescTipo);
             traza("4"); 

             traza("clie: " + clie.toString() );
             
             if (clie.getTipoClienteContactado() != null) {
                traza("clie.getTipoClienteContactado(): " + clie.getTipoClienteContactado() );
                asignarAtributo("VAR","h_cbTipoClienteContactado","valor",clie.getTipoClienteContactado().toString() );
             }
             
             if (clie.getTipoContacto() != null) {
                traza("clie.getTipoContacto(): " + clie.getTipoContacto() );
                asignarAtributo("VAR","hidcbCodTipoContactado","valor",clie.getTipoContacto());
             }             
             traza("5");             
             if (clie.getBase().getTratamiento() != null)
                asignarAtributo("VAR","h_cbTratamiento","valor",clie.getBase().getTratamiento());
             traza("tratamiento: " + clie.getBase().getTratamiento()); 

             if ( clie.getBase().getSexo()  != null)
             {
                traza("sexo: " + clie.getBase().getSexo() );        
                asignarAtributo("VAR","h_rbSexo","valor",clie.getBase().getSexo());                
             }


             if (clie.getBase().getFormaPago() != null)
                asignarAtributo("VAR","h_cbFormaPago","valor",clie.getBase().getFormaPago().toString());

             traza("Forma Pago: " + clie.getBase().getFormaPago()); 
             if (clie.getNacionalidad() != null) {
                asignarAtributo("VAR","h_cbNacionalidad","valor",clie.getNacionalidad().toString());
                traza("Nacionalidad de cliente: " + clie.getNacionalidad().toString() );
             }
             if ( clie.getEstadoCivil() != null)
                asignarAtributo("VAR","h_cbEstadoCivil","valor",clie.getEstadoCivil().toString());
             if ( clie.getNivelEstudios() != null)
                asignarAtributo("VAR","h_cbNivelEstudios","valor",clie.getNivelEstudios().toString());
             if (clie.getNSEP() != null)
                asignarAtributo("VAR","h_cbNivelSocioEconomico","valor",clie.getNSEP().toString());
             if (clie.getCicloVida() != null)
                asignarAtributo("VAR","h_cbCicloVidaFamiliar","valor",clie.getCicloVida().toString());

             if (clie.getDeseaCorrespondencia() != null)
                asignarAtributo("VAR","h_rbDeseaCorrespondencia","valor",clie.getDeseaCorrespondencia().toString());
             //traza("correspondencia: " + clie.getDeseaCorrespondencia().toString() );
             if ( clie.getPaisContactado() != null)
                asignarAtributo("VAR","h_cbPaisContactado","valor",clie.getPaisContactado().toString());

             String ListaVinculo="";
             String ListaObservacion="";
             String ListaPrefe="";
                           
             traza("Vemos el DTOPreferencia dddd");
             RecordSet rPreferencias = clie.getRPreferencia();
             traza("rPreferencias: " + rPreferencias);
             if ( !rPreferencias.esVacio() ) {
                /* traza("clie.getPreferencias().length: " + clie.getPreferencias().length );*/
                DruidaConector conPreferencias = 
                         UtilidadesBelcorp.generarConector("rowset", 
                                                                rPreferencias,
                                                                rPreferencias.getColumnIdentifiers());
                this.asignar("LISTADOA", "listado2", conPreferencias, "rowset");
             } 
             
             traza("Vemos el DTOVinculo ");
             // DTOVinculo[] comv = comv=clie.getVinculos();
             /*for(int i=0;i<clie.getVinculos().length;i++){
                traza("Vinculos[" + i + "]: " + comv[i].toString() );
                if(comv[i].getOid()!=null ){      
                 ListaVinculo=    ListaVinculo +"h_oidVincu_" +i +"="+comv[i].getOid()+";";
                }
                if(comv[i].getCodigoCliente()!=null ){    
                 ListaVinculo=    ListaVinculo +"h_TextoClienteVinculo_" +i +"="+comv[i].getCodigoCliente()+";";
                }
                if(comv[i].getTipo()!=null ){ 
                 ListaVinculo= ListaVinculo +"h_comboTipoVinculo_" +i +"="+comv[i].getTipo().toString()+";";
                }

                if(comv[i].getFechaDesde()!=null ){ 
                 ListaVinculo= ListaVinculo +"h_TextoFechaDesde_" +i +"="+this.transformaFechas(comv[i].getFechaDesde())+";";
                }
                if(comv[i].getFechaHasta()!=null ){
                 ListaVinculo= ListaVinculo +"h_TextoFechaHasta_" +i +"="+this.transformaFechas(comv[i].getFechaHasta())+";";
                }
                if(comv[i].getPrincipal()!=null ){
                  if ( comv[i].getPrincipal().booleanValue() == false)
                        ListaVinculo= ListaVinculo +"h_CKVinculoPrincipal_" +i +"=N";          
                  else
                        ListaVinculo= ListaVinculo +"h_CKVinculoPrincipal_" +i +"=S";          
                }

                if ( i != (clie.getVinculos().length-1) )
                   ListaVinculo= ListaVinculo +"|";
                                    
             }
             if(ListaVinculo!=null ){
             asignarAtributo("VAR","hidListaVinculo","valor",ListaVinculo);
             }*/
             
             RecordSet rVinculo = clie.getRVinculo();
             traza("rVinculo: " + rVinculo);
             if (!rVinculo.esVacio()) {
                int cantTuplas = rVinculo.getRowCount();
                /* Formateo Fechas y Vinculo */
                for (int i=0; i<cantTuplas; i++) {
                   java.sql.Date fechaDesde = (java.sql.Date) rVinculo.getValueAt(i, 3);
                   java.sql.Date fechaHasta = (java.sql.Date) rVinculo.getValueAt(i, 4);
                   if (fechaDesde != null) {
                     String sFechaDesde = 
                           this.transformaFechas(new java.util.Date(fechaDesde.getTime()));
                     rVinculo.setValueAt(sFechaDesde, i, 3);
                   }
                   
                   if (fechaHasta != null) {
                     String sFechaHasta = 
                           this.transformaFechas(new java.util.Date(fechaHasta.getTime()));
                     rVinculo.setValueAt(sFechaHasta, i, 4);
                   }
                   
                   BigDecimal idPrincipal = (BigDecimal) rVinculo.getValueAt(i, 5);
                   if (idPrincipal != null && idPrincipal.longValue() == 1) {
                      rVinculo.setValueAt("S", i,5);
                   } else {
                      rVinculo.setValueAt("N", i,5);
                   }
                }
                DruidaConector conVinculo = 
                         UtilidadesBelcorp.generarConector("rowset", 
                                                                rVinculo,
                                                                rVinculo.getColumnIdentifiers());
                this.asignar("LISTADOA", "listado1", conVinculo, "rowset");                                                             
             
             }
             
             traza("Vemos el DTOObservacion ");
             RecordSet rObservaciones = clie.getRObservaciones();                      
             DruidaConector conObservaciones = 
                      UtilidadesBelcorp.generarConector("rowset", 
                                                             rObservaciones, 
                                                             rObservaciones.getColumnIdentifiers());
             this.asignar("LISTADOA", "listado3", conObservaciones, "rowset");
             

             Long canalContacto = clie.getCanalContacto();
    
             if (canalContacto != null){
                asignarAtributo("VAR", "hidCanalContacto", "valor", canalContacto.toString() );
                traza("canalContacto.toString(): " + canalContacto.toString());
             } else {
                asignarAtributo("VAR", "hidCanalContacto", "valor", "" );
                traza("CanalContacto es null");
             }

             Long marcaContacto = clie.getMarcaContacto();
             if (marcaContacto != null){
                asignarAtributo("VAR", "hidMarcaContacto", "valor", marcaContacto.toString() );
                traza("marcaContacto.toString(): " + marcaContacto.toString());
             } else{
                traza("MarcaContacto es null");             
                asignarAtributo("VAR", "hidMarcaContacto", "valor", "" );             
             }
             
             Long periodoContacto = clie.getPeriodoContacto();
             if (periodoContacto != null){
                asignarAtributo("VAR", "hidPeriodoContacto", "valor", periodoContacto.toString() );
                traza("periodoContacto.toString(): " + periodoContacto.toString());                
             } else{
                traza("PeriodoContacto es null");
                asignarAtributo("VAR", "hidPeriodoContacto", "valor", "" );             
             }
      } else {
         // no es la primera vez que se entra. Carga los valores de param (lo ultimo que el usuario
         // seleccionó) y NO de la Base de Datos.  ACA!
         //String 
         String sTemp = (String) param.get("textApellido1");
         if (sTemp == null) { sTemp = "";}
         asignarAtributo("CTEXTO", "textApellido1", "valor", sTemp );

         sTemp = (String) param.get("textApellido2");
         if (sTemp == null) { sTemp = "";}
         asignarAtributo("CTEXTO", "textApellido2", "valor", sTemp );

         sTemp = (String) param.get("textApellidoCasada");
         if (sTemp == null) { sTemp = "";}
         asignarAtributo("CTEXTO", "textApellidoCasada", "valor", sTemp );         

         sTemp = (String) param.get("textNombre1");
         if (sTemp == null) { sTemp = "";}
         asignarAtributo("CTEXTO", "textNombre1", "valor", sTemp );         

         sTemp = (String) param.get("textNombre2");
         if (sTemp == null) { sTemp = "";}
         asignarAtributo("CTEXTO", "textNombre2", "valor", sTemp );                  

         sTemp = (String) param.get("textImporteIngresoFamiliar");
         if (sTemp == null) { sTemp = "";}
         asignarAtributo("CTEXTO", "textImporteIngresoFamiliar", "valor", sTemp );         

         sTemp = (String) param.get("textFechaNacimiento");
         if (sTemp == null) { sTemp = "";}
         asignarAtributo("CTEXTO", "textFechaNacimiento", "valor", sTemp );         
         
         sTemp = (String) param.get("textFechaNacimiento");
         if (sTemp == null) { sTemp = "";}
         asignarAtributo("CTEXTO", "textFechaNacimiento", "valor", sTemp );         

         sTemp = (String) param.get("textCodEmpleado");
         if (sTemp == null) { sTemp = "";}
         asignarAtributo("CTEXTO", "textCodEmpleado", "valor", sTemp );         

         sTemp = (String) param.get("textCentroEstudios");
         if (sTemp == null) { sTemp = "";}
         asignarAtributo("CTEXTO", "textCentroEstudios", "valor", sTemp );                  

         sTemp = (String) param.get("textNHijos");
         if (sTemp == null) { sTemp = "";}
         asignarAtributo("CTEXTO", "textNHijos", "valor", sTemp );                  

         sTemp = (String) param.get("textNPersonasDependientes");
         if (sTemp == null) { sTemp = "";}
         asignarAtributo("CTEXTO", "textNPersonasDependientes", "valor", sTemp );      

         sTemp = (String) param.get("textOcupacion");
         if (sTemp == null) { sTemp = "";}
         asignarAtributo("CTEXTO", "textOcupacion", "valor", sTemp );            

         sTemp = (String) param.get("textCentroTrabajo");
         if (sTemp == null) { sTemp = "";}
         asignarAtributo("CTEXTO", "textCentroTrabajo", "valor", sTemp );                

         sTemp = (String) param.get("textCodClienteContactado");
         if (sTemp == null) { sTemp = "";}
         asignarAtributo("CTEXTO", "textCodClienteContactado", "valor", sTemp );                

         sTemp = (String) param.get("textFechaContacto");
         if (sTemp == null) { sTemp = "";}
         asignarAtributo("CTEXTO", "textFechaContacto", "valor", sTemp );                

         sTemp = (String) param.get("textFecha1PedidoContacto");
         if (sTemp == null) { sTemp = ""; }
         asignarAtributo("CTEXTO", "textFecha1PedidoContacto", "valor", sTemp );     

         sTemp = (String) param.get("textFechaSiguienteContacto");
         if (sTemp == null) { sTemp = ""; }
         asignarAtributo("CTEXTO", "textFechaSiguienteContacto", "valor", sTemp );     

         sTemp = (String) param.get("textProfesion");
         if (sTemp == null) { sTemp = ""; }
         asignarAtributo("CTEXTO", "textProfesion", "valor", sTemp );              

         sTemp = (String) param.get("textCargoDesempena");
         if (sTemp == null) { sTemp = ""; }
         asignarAtributo("CTEXTO", "textCargoDesempena", "valor", sTemp );              
         traza("P2 - 1");
         asignarAtributo("LABELC", "lblPaisContactoActual", "valor", UtilidadesSession.getDescripcionPais(this) );                        
         traza("P2 - 2");
         HashMap tipoSub = (HashMap) this.conectorParametroSesion("tipoSubt");
         String sDescTipo = (String) tipoSub.get("hDescripcionTipo");
         asignarAtributo("LABELC", "lblTipoClienteContactoActual", "valor", sDescTipo );         
         traza("P2 - 3");
         
         sTemp = (String) param.get("h_cbTratamiento");
         if (sTemp == null) { sTemp = ""; }
         asignarAtributo("VAR", "h_cbTratamiento", "valor", sTemp );                        

         sTemp = (String) param.get("h_rbSexo");
         if (sTemp == null) { sTemp = ""; }
         asignarAtributo("VAR", "h_rbSexo", "valor", sTemp );                        

         sTemp = (String) param.get("h_cbFormaPago");
         if (sTemp == null) { sTemp = ""; }
         asignarAtributo("VAR", "h_cbFormaPago", "valor", sTemp );                                 

         sTemp = (String) param.get("h_cbNacionalidad");
         if (sTemp == null) { sTemp = ""; }
         asignarAtributo("VAR", "h_cbNacionalidad", "valor", sTemp );                                          

         sTemp = (String) param.get("h_cbEstadoCivil");
         if (sTemp == null) { sTemp = ""; }
         asignarAtributo("VAR", "h_cbEstadoCivil", "valor", sTemp );                                          

         sTemp = (String) param.get("h_cbNivelEstudios");
         if (sTemp == null) { sTemp = ""; }
         asignarAtributo("VAR", "h_cbNivelEstudios", "valor", sTemp );                                          

         sTemp = (String) param.get("h_cbNivelSocioEconomico");
         if (sTemp == null) { sTemp = ""; }
         asignarAtributo("VAR", "h_cbNivelSocioEconomico", "valor", sTemp );                                                   

         sTemp = (String) param.get("h_cbCicloVidaFamiliar");
         if (sTemp == null) { sTemp = ""; }
         asignarAtributo("VAR", "h_cbCicloVidaFamiliar", "valor", sTemp );                                                            

         sTemp = (String) param.get("h_rbDeseaCorrespondencia");
         if (sTemp == null) { sTemp = ""; }
         asignarAtributo("VAR", "h_rbDeseaCorrespondencia", "valor", sTemp );                                                                     

         sTemp = (String) param.get("h_cbPaisContactado");
         if (sTemp == null) { sTemp = ""; }
         asignarAtributo("VAR", "h_cbPaisContactado", "valor", sTemp );                                                                              

         sTemp = (String) param.get("h_cbTipoClienteContactado");
         if (sTemp == null) { sTemp = ""; }
         asignarAtributo("VAR", "h_cbTipoClienteContactado", "valor", sTemp );                                                                                      

         sTemp = (String) param.get("hidcbCodTipoContactado");
         if (sTemp == null) { sTemp = ""; }
         asignarAtributo("VAR", "hidcbCodTipoContactado", "valor", sTemp );    

         sTemp = (String) param.get("h_cbTratamiento");
         if (sTemp == null) { sTemp = ""; }
         asignarAtributo("VAR", "h_cbTratamiento", "valor", sTemp);     

         
         sTemp = (String) param.get("h_TipoClienteContacto");
         traza("h_TipoClienteContacto en P2: " + sTemp);
         if (sTemp == null) { sTemp = ""; }
         asignarAtributo("VAR", "h_TipoClienteContacto", "valor", sTemp);     
         

         // Setea las listas. 
         /*sTemp = (String) param.get("hidListaVinculoSal");
         if (sTemp == null) { sTemp = ""; }         
         traza("Lista Vinculo: " + sTemp );
         asignarAtributo("VAR", "hidListaVinculo", "valor", sTemp);

         //sTemp = (String) param.get("hidListaObservacionSal");
         sTemp = (String) param.get("hidListaPrefeSal");         
         if (sTemp == null) { sTemp = ""; }
         traza("Lista Preferencias: " + sTemp );         
         asignarAtributo("VAR", "hidListaPrefe", "valor", sTemp);         


         sTemp = (String) param.get("hidListaObservacionSal");
         if (sTemp == null) { sTemp = ""; }         
         traza("Lista Observaciones: " + sTemp );         
         asignarAtributo("VAR", "hidListaObservacion", "valor", sTemp);    */
         
         String sListaVinculo = (String) param.get("hidListaVinculoSal");
         String sListaPreferencias = (String) param.get("hidListaPrefeSal");
         String sListaObservacion = (String) param.get("hidListaObservacionSal");
         
         
         RecordSet rListaVinculos = this.parseaLista(sListaVinculo);
         RecordSet rListaObservacion = this.parseaLista(sListaObservacion);
         RecordSet rListaPreferencias = this.parseaLista(sListaPreferencias);
         traza("Lista sListaPreferencias: " + sListaPreferencias );         
         traza("Lista sListaVinculo: " + sListaVinculo );         
         traza("Lista sListaObservacion: " + sListaObservacion);
         
         
         if (rListaVinculos != null && !rListaVinculos.esVacio()) {
            DruidaConector con = UtilidadesBelcorp.generarConector("rowset", 
                                                                           rListaVinculos, 
                                                                           rListaVinculos.getColumnIdentifiers());
            this.asignar("LISTADOA", "listado1", con, "rowset");
         }
         
         if (rListaPreferencias != null && !rListaPreferencias.esVacio()) {
            DruidaConector con = UtilidadesBelcorp.generarConector("rowset", 
                                                                           rListaPreferencias, 
                                                                           rListaPreferencias.getColumnIdentifiers());
            this.asignar("LISTADOA", "listado2", con, "rowset");
         }
         
         if (rListaObservacion != null && !rListaObservacion.esVacio()) {
            DruidaConector con = UtilidadesBelcorp.generarConector("rowset", 
                                                                           rListaObservacion, 
                                                                           rListaObservacion.getColumnIdentifiers());
            this.asignar("LISTADOA", "listado3", con, "rowset");
         }
         
         
         sTemp = (String) param.get("elementosEliminadosVincu");
         if (sTemp == null) { sTemp = ""; }         
         traza("elementosEliminadosVincu: " + sTemp );         
         asignarAtributo("VAR", "elementosEliminadosVincu", "valor", sTemp);                  

         sTemp = (String) param.get("elementosEliminadosObser");
         if (sTemp == null) { sTemp = ""; }         
         traza("elementosEliminadosObser: " + sTemp );         
         asignarAtributo("VAR", "elementosEliminadosObser", "valor", sTemp);                  

         sTemp = (String) param.get("elementosEliminadosPrefe");
         if (sTemp == null) { sTemp = ""; }         
         traza("elementosEliminadosPrefe: " + sTemp );         
         asignarAtributo("VAR", "elementosEliminadosPrefe", "valor", sTemp);                           

         sTemp = (String) param.get("hidMarcaContacto");
         if (sTemp == null) { sTemp = ""; }
         traza("hidMarcaContacto: " + sTemp);
         asignarAtributo("VAR", "hidMarcaContacto", "valor", sTemp);                           

         sTemp = (String) param.get("hidCanalContacto");
         if (sTemp == null) { sTemp = ""; }
         traza("hidCanalContacto: " + sTemp);
         asignarAtributo("VAR", "hidCanalContacto", "valor", sTemp);                                    
         
         sTemp = (String) param.get("hidPeriodoContacto");
         if (sTemp == null) { sTemp = ""; }
         traza("hidPeriodoContacto: " + sTemp);
         asignarAtributo("VAR", "hidPeriodoContacto", "valor", sTemp);                                             
         
         
      }

          }catch(Throwable th){
             this.traza("error en validar");
             ByteArrayOutputStream stack = new ByteArrayOutputStream();
             PrintStream out = new PrintStream(stack);
             th.printStackTrace(out);
             traza(  stack.toString());
             BelcorpError belcorpError = new BelcorpError();
             DTOError dtoError = belcorpError.obtenerError(      th, 
             UtilidadesSession.getIdioma_ISO( this ) , 
                                             ""      
                                           );
             String s = th.getMessage();
             traza (  dtoError.getCodigoError() + " - " + dtoError.getDescripcionError() );
                    throw((Exception) th);
        
            }     
      
           
  }
  
  private RecordSet generaRecordSetPrefencias(DTOPreferencia[] dtoPreferencia) 
           throws Exception {
           
     RecordSet r = new RecordSet(); 
     Vector vCampos = new Vector();
     Vector vFila = null;
     DTOPreferencia dtoPref = null;

     vCampos.add("Oid");
     vCampos.add("TipoPreferencia");
     vCampos.add("TextoDescripcion");
     r.setColumnIdentifiers(vCampos);
     
     long cantElems = dtoPreferencia.length;
     
     for (int i = 0; i < cantElems; i++ ) {
         dtoPref = dtoPreferencia[i];
         vFila = new Vector();
         vFila.add(dtoPref.getOid());
         vFila.add(dtoPref.getTipo());
         vFila.add(dtoPref.getDescripcion());
         r.addRow(vFila);
     }
     
     return r;
 }
 
 
 private RecordSet generaRecordSetObservaciones(DTOObservacion[] dtoObservaciones)
         throws Exception {
    
    Long oidMarca = null;
    Integer numero = null;
    String sTexto = null;
    RecordSet r = new RecordSet();
    Vector vCampos = new Vector();
    Vector vFila = null;
    DTOObservacion dtoObs = null;
    
    vCampos.add("Oid");
    vCampos.add("Marca");
    vCampos.add("NroObservacion");
    vCampos.add("Texto");
    r.setColumnIdentifiers(vCampos);
     
    long cantElems = dtoObservaciones.length;
    for (int i=0; i<cantElems; i++ ) {
        vFila = new Vector();
        dtoObs = dtoObservaciones[i];
        
        vFila.add(dtoObs.getOid());
        
        oidMarca = dtoObs.getMarca();
        numero = dtoObs.getNumero();
        sTexto = dtoObs.getTexto();
        
        vFila.add(oidMarca);
        
        if (numero != null ) {
           vFila.add(numero);
        } else {
           vFila.add("");
        }
        
        if (sTexto != null) {
           vFila.add(sTexto);
        } else {
           vFila.add("");
        }
        r.addRow(vFila);
    }
    
    return r;
   
 }
 
 private RecordSet generaRecordSetVinculo(DTOVinculo[] dtoVinculo) 
         throws Exception {
         
    RecordSet r = new RecordSet();
    Vector vCampos = new Vector();
    Vector vFila = null;
    
    vCampos.add("Oid");
    vCampos.add("CodigoCliente");
    vCampos.add("Tipo");
    vCampos.add("FechaDesde");
    vCampos.add("FechaHasta");
    vCampos.add("VinculoPrincipal");
    
    r.setColumnIdentifiers(vCampos);
             //traza("Vemos el DTOVinculo ");
            // DTOVinculo[] comv = comv=clie.getVinculos();
             /*for(int i=0;i<clie.getVinculos().length;i++){
                traza("Vinculos[" + i + "]: " + comv[i].toString() );
                if(comv[i].getOid()!=null ){      
                 ListaVinculo=    ListaVinculo +"h_oidVincu_" +i +"="+comv[i].getOid()+";";
                }
                if(comv[i].getCodigoCliente()!=null ){    
                 ListaVinculo=    ListaVinculo +"h_TextoClienteVinculo_" +i +"="+comv[i].getCodigoCliente()+";";
                }
                if(comv[i].getTipo()!=null ){ 
                 ListaVinculo= ListaVinculo +"h_comboTipoVinculo_" +i +"="+comv[i].getTipo().toString()+";";
                }

                if(comv[i].getFechaDesde()!=null ){ 
                 ListaVinculo= ListaVinculo +"h_TextoFechaDesde_" +i +"="+this.transformaFechas(comv[i].getFechaDesde())+";";
                }
                if(comv[i].getFechaHasta()!=null ){
                 ListaVinculo= ListaVinculo +"h_TextoFechaHasta_" +i +"="+this.transformaFechas(comv[i].getFechaHasta())+";";
                }
                if(comv[i].getPrincipal()!=null ){
                  if ( comv[i].getPrincipal().booleanValue() == false)
                        ListaVinculo= ListaVinculo +"h_CKVinculoPrincipal_" +i +"=N";          
                  else
                        ListaVinculo= ListaVinculo +"h_CKVinculoPrincipal_" +i +"=S";          
                }
    */
    
    return null;
   
 }
 
 

   private void obtenerConfiguracionCampos() throws Exception
   {
      try{
        traza("obtenerConfiguracionCampos() - Creamos los DTOS");
         Vector field = new Vector();
         DTOConfiguracionCamposCliente dtoConfigClie = new DTOConfiguracionCamposCliente();
         DTOConfiguracionCamposCliente dtoSalida = new DTOConfiguracionCamposCliente();
         DTOCampo[] dtocampo= new DTOCampo[24];
         UtilidadesSession sesion = new UtilidadesSession();

        traza("Leemos los objetos de la sesion");
         //tipoSubt=(HashMap)conectorParametroSesion("tipoSubtipo");
        HashMap tipoSubtipo =(HashMap)conectorParametroSesion("tipoSubt");    
        traza("obtenerConfiguracionCampos() - Tipo y subtipo: " + tipoSubtipo.toString() );
    
         if(tipoSubtipo.isEmpty()){
           traza("HasMap vacio");
         }
         
         this.traza("Cargamos los DTOCampos");
          for(int i=0;i<=23;i++){
           dtocampo[i]=new DTOCampo();
            switch(i){
             case 0:
                dtocampo[i].setCodigoCampo("MAECLIEAPELL1");
                field.addElement(dtocampo[i]);
                break;
             case 1:
                dtocampo[i].setCodigoCampo("MAECLIEAPELL2");
                field.addElement(dtocampo[i]);
                break;
             case 2:
                dtocampo[i].setCodigoCampo("MAECLIEAPELLCA");
                field.addElement(dtocampo[i]);
                break;
             case 3:
                dtocampo[i].setCodigoCampo("MAECLIENOM1");
                field.addElement(dtocampo[i]);
                break;
             case 4:
                dtocampo[i].setCodigoCampo("MAECLIENOM2");
                field.addElement(dtocampo[i]);
                break;
             case 5:
                dtocampo[i].setCodigoCampo("MAECLIEFECHNA");
                field.addElement(dtocampo[i]);
                break;
             case 6:
                dtocampo[i].setCodigoCampo("MAECLIECODEMP");
                field.addElement(dtocampo[i]);
                break;
             case 7:
                dtocampo[i].setCodigoCampo("MAECLIEOCUP");
                field.addElement(dtocampo[i]);
                break;
             case 8:
                dtocampo[i].setCodigoCampo("MAECLIEPROF");
                field.addElement(dtocampo[i]);
                break;
             case 9:
                dtocampo[i].setCodigoCampo("MAECLIECENTRA");
                field.addElement(dtocampo[i]);
                break;
             case 10:
                dtocampo[i].setCodigoCampo("MAECLIECARGO");
                field.addElement(dtocampo[i]);
                break;
             case 11:
                dtocampo[i].setCodigoCampo("MAECLIECENESTU");
                field.addElement(dtocampo[i]);
                break;
             case 12:
                dtocampo[i].setCodigoCampo("MAECLIEPERSDEP");
                field.addElement(dtocampo[i]);
                break;
             case 13:
                dtocampo[i].setCodigoCampo("MAECLIEINGFAM");
                field.addElement(dtocampo[i]);
                break;
             case 14:
                dtocampo[i].setCodigoCampo("MAECLIEFECHING");
                field.addElement(dtocampo[i]);
                break;
                                    
             case 15:
                dtocampo[i].setCodigoCampo("MAECLIETRAT");
                field.addElement(dtocampo[i]);
                break;
             case 16:
                dtocampo[i].setCodigoCampo("MAECLIENACIO");
                field.addElement(dtocampo[i]);
                break;
             case 17:
                dtocampo[i].setCodigoCampo("MAECLIEESTCIV");
                field.addElement(dtocampo[i]);
                break;
             case 18:
                dtocampo[i].setCodigoCampo("MAECLIENIVESTU");
                field.addElement(dtocampo[i]);
                break;
             case 19:
                dtocampo[i].setCodigoCampo("MAECLIENSEP");
                field.addElement(dtocampo[i]);
                break;
             case 20:
                dtocampo[i].setCodigoCampo("MAECLIECICLVID");
                field.addElement(dtocampo[i]);
                break;
             case 21:
                dtocampo[i].setCodigoCampo("MAECLIESEXO");
                field.addElement(dtocampo[i]);
                break;
             case 22:
                dtocampo[i].setCodigoCampo("MAECLIEDESCORR");
                field.addElement(dtocampo[i]);
                break;
/*             case 23:
                dtocampo[i].setCodigoCampo("MAECLIEEDAD");
                field.addElement(dtocampo[i]);
                break;*/
             case 23:
                dtocampo[i].setCodigoCampo("MAECLIEFORMPA");
                field.addElement(dtocampo[i]);
                break;
             
                                     
            }
          }
          dtoConfigClie.setCampos(field);
          traza("Seteando...");
           
          /* 
           * Obtengo Tipo y Subtipo del Primer elemento de la Lista TipoSubtipo
           * de la primer Modal. 
           * Por defecto siempre hay un elemento en esta lista. 
           */
          String sLista = (String) tipoSubtipo.get("elementos");
          RecordSet rTipos = this.parseaLista(sLista);
          
          Long tipo = Long.valueOf(rTipos.getValueAt(0,3).toString());
          Long subtipo = Long.valueOf(rTipos.getValueAt(0,4).toString());
          traza("tipo: " + tipo);
          traza("subtipo: " + subtipo);                     
          dtoConfigClie.setTipo(tipo);
          dtoConfigClie.setSubtipo(subtipo);
          traza("1");           
          dtoConfigClie.setOidPais(sesion.getPais(this));
          traza("2");           
          dtoConfigClie.setOidIdioma(sesion.getIdioma(this));
          traza("Conectando...");           
          dtoSalida= (DTOConfiguracionCamposCliente)obtenerDatosSalida("MAEConfiguracionCamposCliente","ConectorObjetoGenerico",(DTOConfiguracionCamposCliente)dtoConfigClie);
           traza("Luego...");
           Vector resultado=dtoSalida.getCampos();
           //traza("resultado: " + resultado.toString() );
           //this.asignarAtributo(resultado);
           this.asignarAtributoRequerido(resultado);
                  
                   //	Agregado por HRCS - Fecha 11/04/2007 - Incidencia Sicc20070184
          conectorParametroSesion("oidTipo", tipo );
          conectorParametroSesion("oidSubtipo", subtipo );
                   traza("Guardando: " + tipo.toString() + " - " + subtipo.toString() );
                   
     }catch(Throwable th){
                  this.traza("error en ConfiguracionCampos");
                  ByteArrayOutputStream stack = new ByteArrayOutputStream();
                  PrintStream out = new PrintStream(stack);
                  th.printStackTrace(out);
                  traza(  stack.toString());
                  BelcorpError belcorpError = new BelcorpError();
                  DTOError dtoError = belcorpError.obtenerError(  th, 
                  UtilidadesSession.getIdioma_ISO( this ) , 
                                                  ""  
                                                );
                  String s = th.getMessage();
                  traza (  dtoError.getCodigoError() + " - " + dtoError.getDescripcionError() );
                         throw((Exception) th);
        
                 }     
  }

  
  private DruidaConector getRowset(RecordSet rs,String rowset)throws Exception{
                  Vector vec = new Vector();
         //RecordSet codClie = (RecordSet)dtop2Base.getBase().getFormasPago();
                   vec = rs.getColumnIdentifiers();
                  return this.generarConector(rowset,rs,vec);
           
  }

    private void Siguiente3(boolean reentrando)throws Exception{
           try{
    
      traza(" ****** Entrando a Siguiente 3 ***********");
      //this.conectorActionOpener(false);
      if(reentrando)
         traza("Reentrando a P3");
      else
         traza("Entrando a P3 por primera vez");

                           /*HashMap p2 = (HashMap) this.conectorParametroSesion("pestana2");
      traza("valores de P2 en sesion: " + p2.toString() );
      traza("3333333333333333333333 - h_TipoClienteContacto en param: "+ (String)p2.get("h_TipoClienteContacto"));      
                           int n =(GrupoVinculo.keySet().size())/6;
                           traza("El tamaño del n es :" + n);
                           traza("1");
         
      DTOValidarClientes dtovaliclien = new DTOValidarClientes();      */
      UtilidadesBelcorp cb1 = new UtilidadesBelcorp();
      UtilidadesBelcorp cb2 = new UtilidadesBelcorp();
      UtilidadesBelcorp cb3 = new UtilidadesBelcorp();
      UtilidadesBelcorp cb4 = new UtilidadesBelcorp();      
      /*
      if (n != 0)
      {
             traza("Hay al menos 1 vinculo");
             Long[] paisVinculos= new Long[n];
             traza("2");
             String[] clientesVinculos= new String[n];
             traza("3");

             //DTOValidarClientes dtovaliclien = new DTOValidarClientes();
             for(int i=0;i<n;i++){
                traza("4 - "+i);
                //paisVinculos[i]=new Long(GrupoVinculo.get("h_paisVinculo_"+i).toString());
                paisVinculos[i]= UtilidadesSession.getPais(this);
                clientesVinculos[i]=GrupoVinculo.get("h_clienteVinculo_"+i).toString();
             }
             traza("Sale del for");

             dtovaliclien.setClientesVinculo(clientesVinculos);//array de string
             traza("setClientesVinculo[0]:  "+ clientesVinculos[0]);
                           
             dtovaliclien.setPaisesVinculo(paisVinculos);//array de longs
             traza("setPaisesVinculo[0]: "+ paisVinculos[0]);
      } else
      {
             traza("No hay vinculos");
             dtovaliclien.setClientesVinculo(null);
             dtovaliclien.setPaisesVinculo(null);
      }*/
      
                           HashMap p2 = (HashMap) this.conectorParametroSesion("pestana2");
      String sListaVinculos  = (String) p2.get("hidListaVinculoSal");
      traza("Lista Vinculos: " + sListaVinculos);
      RecordSet rListaVinculos = null;
      if (sListaVinculos != null && sListaVinculos.length() > 0) {
          rListaVinculos = this.parseaLista(sListaVinculos);
      }
      
      DTOValidarClientes dtoValiClien = new DTOValidarClientes();      
      UtilidadesSession sesion = new UtilidadesSession();      
      DTOCliente clie = (DTOCliente)conectorParametroSesion("DTOCliente");      
      
      if (rListaVinculos != null && !rListaVinculos.esVacio() ) {
          int cantRegistros = rListaVinculos.getRowCount();
          Long[] paisVinculos = new Long[cantRegistros];
          String[] clientesVinculos = new String[cantRegistros];
          Long paisSesion = UtilidadesSession.getPais(this);
          String sCodigoCliente = null;
          
          for (int i=0; i<cantRegistros; i++) {
             sCodigoCliente = (String) rListaVinculos.getValueAt(i, 1);
             paisVinculos[i] = paisSesion;
             clientesVinculos[i] = sCodigoCliente;
          }
          dtoValiClien.setClientesVinculo(clientesVinculos);
          dtoValiClien.setPaisesVinculo(paisVinculos);
          
      } else {
          traza("No hay vinculos");
          dtoValiClien.setClientesVinculo(null);
          dtoValiClien.setPaisesVinculo(null);
      }      
      
      boolean existeContacto = false;
      if ( !p2.get("textCodClienteContactado").toString().equals("") )
         existeContacto = true;

      if (!existeContacto)  // Si no existe Cliente Contacto pone todo en null.
      {
           traza("No se introdujo Primer Contacto");
           dtoValiClien.setClienteContacto(null);
           dtoValiClien.setPaisContactado(null);
           dtoValiClien.setTipoClienteContacto(null);
      } else
      {
           traza("Se introdujo Primer Contacto");
           
           dtoValiClien.setClienteContacto( p2.get("textCodClienteContactado").toString());
           traza("setClienteContacto: "+ p2.get("textCodClienteContactado").toString());
                  
           dtoValiClien.setPaisContactado(UtilidadesSession.getPais(this));
           traza("setPaisContactado: "+ UtilidadesSession.getPais(this).toString() );

           traza("h_cbTipoClienteContactado: " + (String) p2.get("h_cbTipoClienteContactado") ); 
           String sTipoClienteContacto = (String) p2.get("h_cbTipoClienteContactado");             

           Long nTipoClienteContacto = new Long(sTipoClienteContacto);
           dtoValiClien.setTipoClienteContacto( nTipoClienteContacto );//long             
           
      }
      
                           /*HashMap tipoSubtipo=(HashMap)conectorParametroSesion("tipoSubt");
      traza("HashMap tipoSubtipo en sesion: " + tipoSubtipo.toString() );
      traza("h_comboSubtipoCliente_0 en tipo subtipo: " + (String) tipoSubtipo.get("h_comboSubtipoCliente_0") );
                  dtovaliclien.setSubtipoCliente(new Long(tipoSubtipo.get("h_comboSubtipoCliente_0").toString()));//long*/
      
      HashMap tipoSubtipo = (HashMap) conectorParametroSesion("tipoSubt");
      String sListaSubtipo = (String) tipoSubtipo.get("elementos");
      
      if (sListaSubtipo != null && sListaSubtipo.length() > 0) {
          RecordSet rListaSubtipo = this.parseaLista(sListaSubtipo);
          if (rListaSubtipo != null && !rListaSubtipo.esVacio()) {
             String sSubtipo = (String) rListaSubtipo.getValueAt(0,4);
             dtoValiClien.setSubtipoCliente(Long.valueOf(sSubtipo));
          }
      }
      

                           dtoValiClien.setOidIdioma(sesion.getIdioma(this));
                           traza("setOidIdioma: "+sesion.getIdioma(this));
      
                           dtoValiClien.setOidPais(sesion.getPais(this));
                           traza("setOidPais: "+sesion.getPais(this));
      
                           asignarAtributo("VAR","hidPais","valor",sesion.getPais(this).toString());

      // Llama a obtener datos
                           /* DTOPestanya3 dtoP3 = 
                (DTOPestanya3)obtenerDatosSalida("MAEPestanya3",
                                                     "ConectorObjetoGenerico",
                                                     (DTOValidarClientes)dtoValiClien); */
      DTOPestanya3 dtoP3 = (DTOPestanya3) this.conectorParametroSesion("DTOPestanya3");
      traza("despues de conectar");

      if (dtoP3 == null){
         traza("dtoP3 es null");
      }
      traza("paso 1 ");
      Long[] listaVincu = dtoP3.getOidClientesVinculo();
      traza("paso 2 ");
      StringBuffer listaVincuToSet = new StringBuffer("");


      if (listaVincu != null)  // Puede que venga null si no se eligio nada en la lista. 
      {
           traza("Lista Vincu no es null");
           for (int i = 0; i < listaVincu.length; i++)
           {
             // Si hay un oid nulo, lanzamos error. 
             Long oidClienteVinculo = listaVincu[i];
             traza("Bucle " + i);

             if (oidClienteVinculo == null)
             {
                traza("Un Oid de Cliente Vinculo es null");
                throw new MareException( new Exception(), 160280003);//inc BELC300014099
             } else
             {
                  traza("oidClienteVinculo es " + oidClienteVinculo.toString() );
                  if (i != 0)
                    listaVincuToSet.append(",");

                  listaVincuToSet.append(oidClienteVinculo.toString() );
             }
           }
      }         
      //asignarAtributo("VAR", "listaVinculosOid", "valor", listaVincu.toString());*/
      traza("paso 3 ");
      asignarAtributo("VAR", "listaVinculosOid", "valor", listaVincuToSet.toString());           

      traza("paso 4 ");
      if((dtoP3.getOidClienteContacto() != null) && (dtoP3.getOidClienteContacto().equals(new Long(0)))){
            traza("DEBERIA ENTRAR ACA!!!!!");
            throw new MareException(new Exception(), 170000031);
      } 
      traza("paso 5 ");
      /*if (dtoP3.getOidClienteContacto() != null){
          traza("entro en el not NULL");
          asignarAtributo("VAR", "hidOidClienteCont", "valor", dtoP3.getOidClienteContacto().toString());  
              //throw new MareException(new Exception(), 170280004);
      }*/
      traza("el oid contacto es " + dtoP3.getOidClienteContacto());
                           if(dtoP3.getOidClienteContacto()!=null){
         //traza("dtoP3.getOidClienteContacto() es null - Vuelve a Pestanya 2");
                   	  //throw  new MareException( new Exception(), 170280004);         
                           //}else{ 
                                    //ponemos el oid del contactado	
         traza("dtoP3.getOidClienteContacto() NO es null - oid: " + dtoP3.getOidClienteContacto());
         asignarAtributo("VAR", "hidOidClienteCont", "valor", dtoP3.getOidClienteContacto().toString() );
      }

         // Chequea que existan oids para todos los clientes elegidos en la 
         // Lista de Vinculo.


                           
         traza("Luego del if");

         RecordSet tComunicaciones = (RecordSet)dtoP3.getTiposComunicacion();
         cb4.agregarRegistroVacio(tComunicaciones,0);
         RecordSet canales = (RecordSet)dtoP3.getBase().getCanales();
         dtoP3.getBase().getClasificaciones();
         RecordSet marcas = (RecordSet)dtoP3.getBase().getMarcas();
         cb2.agregarRegistroVacio(marcas,0);
         dtoP3.getBase().getTiposClasificacion();
         RecordSet direcciones = (RecordSet)dtoP3.getBase().getTiposDirecciones();
         cb1.agregarRegistroVacio(direcciones,0);
         RecordSet tvia=dtoP3.getBase().getTipoVia();
         cb3.agregarRegistroVacio(tvia,0);
         asignar("COMBO","comboTipoDireccion",this.getRowset(direcciones,"DTOSalida.tiposDirecciones_ROWSET"));
         asignar("COMBO","comboMarca",this.getRowset(marcas,"DTOSalida.marcas_ROWSET"));

         if(dtoP3.getBase().getUsaGeoreferenciador().booleanValue()){
           traza("Usa Georeferenciador");
//           asignarAtributo("VAR","hidusaGeoreferenciador","valor","true");
             asignarAtributo("VAR","usaGeoreferenciador","valor","true");
         }else{
           traza("No usa Georeferenciador");
//           asignarAtributo("VAR","hidusaGeoreferenciador","valor","false");
             asignarAtributo("VAR","usaGeoreferenciador","valor","false");
           
           
         }
                  asignar("COMBO","comboTipoVia",this.getRowset(tvia,"DTOSalida.tipoVia_ROWSET"));
         asignar("COMBO","comboTipoComunicacion",this.getRowset(tComunicaciones,"DTOSalida.marcas_ROWSET"));

         if (reentrando == false)
         {
              traza("Rellenamos los campos con los valores ocultos");
              //traza("Cargo: " + clie.getCargo());
          
              if(clie.getBase().getDirecciones()!= null)
              {
                 int nx =clie.getBase().getDirecciones().length;
                 traza("Estamos en el for");
                 DTODireccion[] direccion = new DTODireccion[clie.getBase().getDirecciones().length];
                 traza("direcciones creado");
                 direccion=clie.getBase().getDirecciones();
                 traza("direcciones cargado");
                 for(int i=0;i<clie.getBase().getDirecciones().length;i++)
                 {
                     traza("1");
                    /* if ( direccion[i].getNombreVia() == null)
                        asignarAtributo("CTEXTO","TextoNombreVia","valor","");
                     else
                        asignarAtributo("CTEXTO","TextoNombreVia","valor",direccion[i].getNombreVia().toString());*/
                        
                     traza("2");
                     if ( direccion[i].getNumeroPrincipal() == null)
                        asignarAtributo("CTEXTO","TextoNumeroPrincipal","valor","");
                     else
                        asignarAtributo("CTEXTO","TextoNumeroPrincipal","valor",direccion[i].getNumeroPrincipal().toString());
                        
                     traza("3");
                     if ( direccion[i].getCodigoPostal() == null)
                        asignarAtributo("CTEXTO","TextoCodPostal","valor","");
                     else
                        asignarAtributo("CTEXTO","TextoCodPostal","valor",direccion[i].getCodigoPostal());
                  }
         
                } else
                {
                  traza("clie.getBase().getDirecciones() es null");
                }

                //traza("asignamos el DTODirecciones");
                traza("asignamos el DTOComunicacion");
                RecordSet rComunicaciones = clie.getRComunicaciones();
                if (rComunicaciones != null && !rComunicaciones.esVacio() ) {
                   int cantRegistros = rComunicaciones.getRowCount();
                   BigDecimal bigIndPpal = null;
                   BigDecimal bigIntervalo = null;
                   
                   for (int i=0; i<cantRegistros; i++) {
                        bigIndPpal = (BigDecimal) rComunicaciones.getValueAt(i, 4);
                        bigIntervalo = (BigDecimal) rComunicaciones.getValueAt(i, 7);
                        if (bigIndPpal != null && bigIndPpal.longValue() != 1) {
                           rComunicaciones.setValueAt("N", i, 4);
                        } else {
                           rComunicaciones.setValueAt("S", i, 4);
                        }
                        
                        if (bigIntervalo != null) {
                          if (bigIntervalo.longValue() == 1){
                             rComunicaciones.setValueAt("true", i, 7);
                          } else {
                             rComunicaciones.setValueAt("false", i, 7);
                          }
                        }
                        
                        
                   }
                   
                   DruidaConector conComu = 
                           UtilidadesBelcorp.generarConector("rowset", 
                                                                  rComunicaciones, 
                                                                  rComunicaciones.getColumnIdentifiers());
                   this.asignar("LISTADOA", "listado2", conComu, "rowset");
                }

              /* if (clie.getComunicaciones() != null)
                {
                    traza("Comunicacion no es null");
                    DTOComunicacion[] dtoArrayComm = clie.getComunicaciones();         
                    int longArray = dtoArrayComm.length;
                    traza("Cantidad de dtos en array de Comm: " + longArray);
                    DTOComunicacion dtoComm = null;
                    StringBuffer cadenaComunicacion = new StringBuffer("");
                    Long oidComm = null;
                    Long tipoComm = null;
                    Character cDiaComunicacion = null;             
                    String textoComm = null;
                    Boolean principalComm = null;
                    Long horaDesde = null;
                    Long horaHasta = null;
                    Boolean intervaloComm = null;

                    for (int i = 0; i < longArray; i++)
                    {
                        dtoComm = dtoArrayComm[i];

                        if (i != 0)
                          cadenaComunicacion.append("|");

                        oidComm = dtoComm.getOid(); 
                        if (oidComm != null)
                          cadenaComunicacion.append( oidComm.toString() );
                        cadenaComunicacion.append(";");

                        tipoComm = dtoComm.getTipoComunicacion();
                        if (tipoComm != null)
                          cadenaComunicacion.append( tipoComm.toString() );
                        cadenaComunicacion.append(";");
                 
                        cDiaComunicacion = dtoComm.getDiaComunicacion();
                        if (cDiaComunicacion != null)
                          cadenaComunicacion.append( cDiaComunicacion.toString() );
                        cadenaComunicacion.append(";");

                        textoComm = dtoComm.getTextoComunicacion();
                        if (textoComm != null)
                          cadenaComunicacion.append( textoComm.toString() );
                        else 
                          cadenaComunicacion.append(" ");
                        cadenaComunicacion.append(";");
                 

                        principalComm = dtoComm.getPrincipal();
                        if (principalComm != null)
                          cadenaComunicacion.append( principalComm.booleanValue() );
                        cadenaComunicacion.append(";");
                 

                        horaDesde = dtoComm.getHoraDesde();
                        if (horaDesde != null)
                        {
                          SimpleDateFormat simpleDate = new SimpleDateFormat("HH:mm");
                          java.util.Date horaDate = new java.util.Date( horaDesde.longValue() );
                          String sHora = simpleDate.format(horaDate);
                          cadenaComunicacion.append( sHora );
                        }
                        cadenaComunicacion.append(";");
                 

                        horaHasta = dtoComm.getHoraHasta();
                        if (horaHasta != null)
                        {
                          SimpleDateFormat simpleDate = new SimpleDateFormat("HH:mm");
                          java.util.Date horaDate = new java.util.Date( horaHasta.longValue() );
                          String sHora = simpleDate.format(horaDate);
                          cadenaComunicacion.append( sHora );                        
                        }
                        cadenaComunicacion.append(";");
                 

                        intervaloComm = dtoComm.getIntervaloComunicacion();
                        if (intervaloComm != null)
                           cadenaComunicacion.append( intervaloComm.toString() );

                    } // Fin For de comunicacion

                    traza("Cadena de comunicacion para lista: " + cadenaComunicacion.toString() );
                    asignarAtributo("VAR", "hidListaComunicacion", "valor", cadenaComunicacion.toString() );
             
                }*/

                 // Asignamos Marcas
                 traza("Asignamos Marca");

                 if (clie.getBase().getMarcas() != null)
                 {
                      DTOClienteMarca[] arrayMarcas = clie.getBase().getMarcas();
                      int longitud = arrayMarcas.length;

                      DTOClienteMarca dtoMarca = null;
                      Long oidMarca = null;
                      Long marca = null;

                      StringBuffer cadenaMarca = new StringBuffer("");
                      for (int i = 0; i < longitud; i++)
                      {
                         dtoMarca = arrayMarcas[i];
                         oidMarca = dtoMarca.getOid();
                         marca = dtoMarca.getMarca();
                         if (i != 0)
                           cadenaMarca.append("|");

                         if (oidMarca != null)
                           cadenaMarca.append( oidMarca.toString() );

                         cadenaMarca.append(";");

                         if (marca != null)
                           cadenaMarca.append( marca.toString() );
                      }
                      traza("cadena de Marcas a setear: " + cadenaMarca.toString() );
                      asignarAtributo("VAR", "hidListaMarca", "valor", cadenaMarca.toString() );

                  }

                  // Asignamos Via
                  traza("Asignamos Via");
    
                  if (clie.getBase().getDirecciones() != null)
                  { 
                      traza("Setea Direcciones");
                      DTODireccion[] arrayDir = clie.getBase().getDirecciones();
                      DTODireccion dtoDir = null;
                      Long oid = null;
                      Long unidadesGeo = null;
                      Long tipoDir = null;
                      Long tipoVia = null;
                      String nombreVia = null;
                      Long via = null;
                      String nroPpal = null;
                      String codigoPostal = null;
                      String observaciones = null;
                      Boolean dirPPal = null;
                      StringBuffer cadenaDir = new StringBuffer("");
                      String nombreUniGeo = null;
                
                      for (int i = 0; i < arrayDir.length; i++)
                      {

                         dtoDir = arrayDir[i];
                         traza("dtoDir: " + dtoDir.toString() );
                  
                         oid = dtoDir.getOid();
                         unidadesGeo = dtoDir.getUnidadGeografica();
                         tipoDir = dtoDir.getTipoDireccion();
                         tipoVia = dtoDir.getTipoVia();
                         via = dtoDir.getVia();
                         nombreVia = dtoDir.getNombreVia();
                         nroPpal = dtoDir.getNumeroPrincipal();
                         codigoPostal = dtoDir.getCodigoPostal();
                         /*SICC-GCC-MAE-005
                                                interior = dtoDir.getInterior();
                         manzana = dtoDir.getManzana();
                         lote = dtoDir.getLote();
                         km = dtoDir.getKilometro();*/
                         observaciones = dtoDir.getObservaciones();
                         dirPPal = dtoDir.getEsDireccionPrincipal();
                         nombreUniGeo = dtoDir.getNombreUnidadGeografica();

                         if (i != 0)
                           cadenaDir.append("|");

                         if (oid != null) 
                           cadenaDir.append(oid.toString() );

                         cadenaDir.append(";");

/*                         if (unidadesGeo != null)
                           cadenaDir.append(unidadesGeo.toString());
                         cadenaDir.append(";");*/

                         if (nombreUniGeo != null)
                           cadenaDir.append(nombreUniGeo.toString());
                         cadenaDir.append(";");

                         if (tipoDir != null)
                           cadenaDir.append(tipoDir.toString());
                         cadenaDir.append(";");                  

                         if (tipoVia != null)
                           cadenaDir.append(tipoVia.toString());
                         cadenaDir.append(";");          

                         if (nombreVia != null)
                           cadenaDir.append(nombreVia);
                         cadenaDir.append(";"); 

                         if (nombreVia != null)
                           cadenaDir.append(nombreVia);
                         cadenaDir.append(";");                          

/*                         if (via != null)
                           cadenaDir.append(via);
                         cadenaDir.append(";"); */

                         if (nroPpal != null)
                           cadenaDir.append(nroPpal.toString() );
                         cadenaDir.append(";"); 

                         if (codigoPostal != null)
                           cadenaDir.append(codigoPostal.toString() );
                         cadenaDir.append(";"); 

                         /*SICC-GCC-MAE-005 - Cleal
                                                if (interior != null)
                           cadenaDir.append(interior.toString() );
                         cadenaDir.append(";"); 

                         if (manzana != null)
                           cadenaDir.append(manzana.toString() );
                         cadenaDir.append(";"); 

                         if (lote != null)
                           cadenaDir.append(lote.toString() );
                         cadenaDir.append(";");                   

                         if (km != null)
                           cadenaDir.append(km.toString() );
                         cadenaDir.append(";");  */            

                         if (observaciones != null)
                           cadenaDir.append(observaciones.toString() );
                         cadenaDir.append(";");                          

                         if (dirPPal != null)
                           cadenaDir.append(dirPPal.toString() + ";");

                         // Campos ocultos.
                         if (unidadesGeo != null)
                           cadenaDir.append(unidadesGeo.toString());
                         cadenaDir.append(";");                           

                         if (via != null)
                           cadenaDir.append(via);
                                                cadenaDir.append(";");  
                                                
                                                if (tipoVia != null)
                           cadenaDir.append(tipoVia.toString());
                         cadenaDir.append(";"); 
                                                
                                                if (tipoDir != null)
                           cadenaDir.append(tipoDir.toString());
//                         cadenaDir.append(";");                  

                                                    

                         


                         // Fin Campos ocultos.
                  
                      } // Fin for
                      traza("Cadena de Direccion: " + cadenaDir.toString() );
                      this.asignarAtributo("VAR", "hidListaDirecciones", "valor", cadenaDir.toString() );

             
                  }else{
                    traza("clie.getBase().getDirecciones es null");
                  }
           
         
           } else {
                HashMap p3 = (HashMap) this.conectorParametroSesion("pestana3");
                
                String sListaDirecciones = (String) p3.get("hidListaDirecciones");
                if (sListaDirecciones == null)  { sListaDirecciones = "";};
                traza("ListaDirecciones: " + sListaDirecciones);
                this.asignarAtributo("VAR", "hidListaDirecciones", "valor", sListaDirecciones);

                String sListaComunicacion = (String) p3.get("hidListaComunicacion");
                if (sListaComunicacion != null && sListaComunicacion.length() > 0) {
                   RecordSet rComunicaciones = this.parseaLista(sListaComunicacion);
                   if (rComunicaciones != null && !rComunicaciones.esVacio() ) {
                      DruidaConector conComu = 
                                UtilidadesBelcorp.generarConector("rowset", 
                                                                      rComunicaciones, 
                                                                      rComunicaciones.getColumnIdentifiers());
                      this.asignar("LISTADOA", "listado2", conComu, "rowset");
                  }
                }
                /*if (sListaComunicacion == null)  { sListaComunicacion = "";};                
                traza("Lista Comunicacion: " + sListaComunicacion);
                this.asignarAtributo("VAR", "hidListaComunicacion", "valor", sListaComunicacion);    */

                String sListaMarca = (String) p3.get("hidListaMarca");
                if (sListaMarca == null)  { sListaMarca = "";};                
                traza("Lista Comunicacion: " + sListaMarca);
                this.asignarAtributo("VAR", "hidListaMarca", "valor", sListaMarca);    

                String sTemp = (String) p3.get("elemToDelDir");
                if (sTemp == null) { sTemp = "";};
                traza("Elementos Direccion a Borrar: " + sTemp);
                this.asignarAtributo("VAR", "elemToDelDir", "valor", sTemp);
                
                sTemp = (String) p3.get("elemToDelComm");
                if (sTemp == null) { sTemp = "";};
                traza("Elementos Comunicacion a Borrar: " + sTemp);
                this.asignarAtributo("VAR", "elemToDelComm", "valor", sTemp);

                sTemp = (String) p3.get("elemToDelMarcas");
                if (sTemp == null) { sTemp = "";};
                traza("Elementos Marcas a Borrar: " + sTemp);
                this.asignarAtributo("VAR", "elemToDelMarcas", "valor", sTemp);

                sTemp = (String) p3.get("usaGeoreferenciador");
                if (sTemp == null) { sTemp = "";};
                traza("Usa georeferenciador: " + sTemp);
                this.asignarAtributo("VAR", "usaGeoreferenciador", "valor", sTemp);

           }

      //}
           }catch(Throwable th){
                    this.traza("error en Siguiente3");
                    ByteArrayOutputStream stack = new ByteArrayOutputStream();
                    PrintStream out = new PrintStream(stack);
                    th.printStackTrace(out);
                    traza(  stack.toString());
                    BelcorpError belcorpError = new BelcorpError();
                    DTOError dtoError = belcorpError.obtenerError(         th, 
                    UtilidadesSession.getIdioma_ISO( this ) , 
                                                    ""         
                                                  );
                    String s = th.getMessage();
                    traza (  dtoError.getCodigoError() + " - " + dtoError.getDescripcionError() );
                           throw((Exception) th);
        
                   } 
         
  }


 public void siguiente4(boolean reentrando) throws Exception
 {
    
    traza(" **** Entrando a Siguiente 4 *****");
    if (reentrando)
      traza("Reentrando a Siguiente4");
    else
      traza("Entrando a P4 x primera vez");

    HashMap tipoSub = (HashMap) this.conectorParametroSesion("tipoSubt");
    
    if (tipoSub != null)
     traza("Tipo/Subtipo no es null - Tipo Cliente: ");
    else
     traza("Tipo/SubTipo es null");

    // Por ahora hardcodeo el tipo subtipo
   // Long nTipoSubtipo = new Long(1);
   // DTOOID dtoOid = new DTOOID();

    // TODO: Que cuernos hace con este DTOOID????????
    // Si obtiene los datos del cliente, en el diseño falta el BussId. 
   // dtoOid.setOid(nTipoSubtipo);
    //DTOPestanya4 dtoP4 =  (DTOPestanya4)obtenerDatosSalida("MAEPestanya4","ConectorObjetoGenerico",(DTOOID)dtoOid);
    
    //traza("dtoP4: " + dtoP4.toString() );
  
    DTOObtenerPestanya4  dtoObtenerP4 = new DTOObtenerPestanya4();
    
    String sListaSubtipos = (String)tipoSub.get("elementos");
    RecordSet rSubtipos = this.parseaLista(sListaSubtipos);
    
    /* 
     * Debe existir al menos un registro de Tipo / Subtipo, en este
     * momento de la ejecucion.
     */ 
     int cantRegistros = rSubtipos.getRowCount();
     String sOidSubtipo = null;
     String sOidTipo = null;
     String sDescTipo = null;
     String sDescSubtipo = null;
     Long[] arraySubTipos = new Long[cantRegistros];
     
     RecordSet rDescTipos = new RecordSet(); 
     RecordSet rDescSubtipos = new RecordSet(); 
     Vector vFilaTipo = null;
     Vector vFilaSubtipo = null;
     Vector vValoresTipo = new Vector();
     Vector vValoresSubtipo = new Vector();
     
     vValoresTipo.add("OID");
     vValoresTipo.add("DESC");
     
     vValoresSubtipo.add("OID_TIPO");
     vValoresSubtipo.add("OID_SUBTIPO");
     vValoresSubtipo.add("DESC");
     
     rDescTipos.setColumnIdentifiers(vValoresTipo);
     rDescSubtipos.setColumnIdentifiers(vValoresSubtipo);
     
     for (int i=0; i<cantRegistros; i++){
         sDescTipo = (String) rSubtipos.getValueAt(i, 1);
         sDescSubtipo = (String) rSubtipos.getValueAt(i, 2);
         sOidTipo = (String) rSubtipos.getValueAt(i, 3);
         sOidSubtipo = (String) rSubtipos.getValueAt(i, 4);
         
         arraySubTipos[i] = Long.valueOf(sOidSubtipo);
         
         /* Agrego la fila [Oid Tipo / Desc tipo]  */ 
         vFilaTipo = new Vector();
         vFilaTipo.add(sOidTipo);
         vFilaTipo.add(sDescTipo);
         rDescTipos.addRow(vFilaTipo);
         
         /* Agrego la fila [Oid subtipo / Desc subtipo] */ 
         vFilaSubtipo = new Vector();
         vFilaSubtipo.add(sOidTipo);
         vFilaSubtipo.add(sOidSubtipo);
         vFilaSubtipo.add(sDescSubtipo);
         rDescSubtipos.addRow(vFilaSubtipo);
     }

    /*Vector vTiposSubTipos = new Vector();
    Long[] arraySubTipos = null;
    
    // Obtiene el array de Subtipos
    String elementos = (String)tipoSub.get("elementos");
    traza("Elementos: " + elementos);
    if (elementos != null || !elementos.equals("") )
    {
         // Separa las filas.
         StringTokenizer tokCadena = new StringTokenizer(elementos, ";");      
         traza("Cant de tokens: " + tokCadena.countTokens() );
         // Cada 3 elementos, ocurre el subtipo. 

         while ( tokCadena.hasMoreTokens() )
         //for (int i = 0; i < tokCadena.countTokens(); i++)
         {
             String elem = tokCadena.nextToken();
             traza("elem: " + elem);
           
             StringTokenizer tokElemento = new StringTokenizer(elem, "=");
             String nombre = tokElemento.nextToken();
             String valor = tokElemento.nextToken();

             traza("nombreCampo: " + nombre);
             StringTokenizer tokNombre = new StringTokenizer(nombre, "_");
             tokNombre.nextToken(); // Seria la h
             String nombreComponente = tokNombre.nextToken(); // Seria el nombre

             if ( nombreComponente.equals("comboSubtipoCliente") ) // Si es el elem. de subtipo.
             {
                  vTiposSubTipos.add(valor);
                  traza("Match");
             }

        }

         traza("vTiposSubTipos: " + vTiposSubTipos.toString() );
         int longVector = vTiposSubTipos.size();

         arraySubTipos = new Long[longVector];

         for ( int i=0; i < longVector; i++)
           arraySubTipos[i] = new Long( (String)vTiposSubTipos.get(i) );
    }*/

    // Obtengo el array de marcas
    // HashMap p3 = (HashMap) this.conectorParametroSesion("pestana3");
    // Si estoy entrando x primera vez, tengo los datos de P3 y se hace un param.get(xxx);
    // Si estoy reentrando, param contiene los datos de P4, por lo que habria que obtener
    // explicitamente los valores de P3.
    
    String cadenaMarcas = "";
    if (reentrando)  // Reentrando 
    {
         HashMap P3 = (HashMap) this.conectorParametroSesion("pestana3");
         cadenaMarcas = (String) P3.get("hidListaMarca");
    } else
      cadenaMarcas = (String) param.get("hidListaMarca");           

    traza("cadena de MArcas de P3: " + cadenaMarcas);
    Long[] arrayMarcas = null;
    Vector vecMarcas = new Vector();
    int i = 0;

    if ( !cadenaMarcas.equals("") )
    {
      StringTokenizer tokFilas = new StringTokenizer(cadenaMarcas, "|");
      // Suponiendo que obligatoriamente cada fila trae el oid de marca,
      // se setea el tamaño de arrayMarcas a la cantidad de filas
      arrayMarcas = new Long[tokFilas.countTokens()];
      while ( tokFilas.hasMoreTokens() )
      { 
           String fila = tokFilas.nextToken();
           traza("Fila marca " + i + ": " + fila);

           StringTokenizer tokElem = new StringTokenizer(fila, ";");
           // Solamente necesito el segundo elemento (el oid de marca - el combo)
           // NO el de la fila (que puede ser numerico o "g")

           tokElem.nextToken();
           String oidMarca = tokElem.nextToken();
           traza("oidMarca: " + oidMarca);
           arrayMarcas[i] = new Long(oidMarca);
           i++;
      }
    }

    DTOObtenerPestanya4 dtoObtP4 = new DTOObtenerPestanya4();
    dtoObtP4.setSubtipoCliente(arraySubTipos);
    dtoObtP4.setMarcasElegidas(arrayMarcas);
    dtoObtP4.setOidIdioma(UtilidadesSession.getIdioma(this));
    dtoObtP4.setOidPais(UtilidadesSession.getPais(this));

    DTOPestanya4 dtoP4 = (DTOPestanya4)obtenerDatosSalida("MAEPestanya4","ConectorObjetoGenerico",(DTOObtenerPestanya4) dtoObtP4);

    traza("dtoP4: " + dtoP4);  

    RecordSet rCanales = dtoP4.getCanales();
    RecordSet rClasificaciones = dtoP4.getClasificaciones();
    RecordSet rTipoClasificaciones = dtoP4.getTiposClasificacion();
    RecordSet rMarcasSeleccionadas = dtoP4.getMarcasSeleccionadas();
    RecordSet rTiposTarjetas = dtoP4.getTiposTarjeta();
    RecordSet rClasesTarjeta = dtoP4.getClasesTarjeta();
    RecordSet rTipoProblema = dtoP4.getTiposProblema();
    RecordSet rTipoSolucion = dtoP4.getTiposSolucion();
    RecordSet rBancos = dtoP4.getBancos();
    RecordSet rPerfiles = dtoP4.getTiposPerfiles();

    UtilidadesBelcorp utilidadesBelcorp  = new UtilidadesBelcorp();

    traza("Asigna Marcas Seleccionadas al Combo Marcas y al Psicograficas");
    if (rMarcasSeleccionadas.getRowCount() > 0)
    {
         utilidadesBelcorp.agregarRegistroVacio(rMarcasSeleccionadas,0);
      DruidaConector conMarcasSelec = this.generarConector("rowsetMarcas", rMarcasSeleccionadas, rMarcasSeleccionadas.getColumnIdentifiers() );
      traza("conMarcasSelec: " + conMarcasSelec.getXML() );      
      this.asignar("COMBO","comboMarca",conMarcasSelec,"rowsetMarcas");
      this.asignar("COMBO","comboMarcaPsico",conMarcasSelec,"rowsetMarcas");      
    }
    
    traza("Asigna Canales al Combo");
    if (rCanales.getRowCount() > 0)
    {
      utilidadesBelcorp.agregarRegistroVacio(rCanales,0);
      DruidaConector conCanales = this.generarConector("rowsetCanales", rCanales, rCanales.getColumnIdentifiers() );
      this.asignar("COMBO", "comboCanal", conCanales, "rowsetCanales");
    }

    traza("Asignar Tipos Tarjetas");
    if (rTiposTarjetas.getRowCount() > 0)
    {
      utilidadesBelcorp.agregarRegistroVacio(rTiposTarjetas,0);
      DruidaConector conTiposTarjeta = this.generarConector("rowsetTiposTarje", rTiposTarjetas, rTiposTarjetas.getColumnIdentifiers() );
      this.asignar("COMBO", "comboTipoTarjeta", conTiposTarjeta, "rowsetTiposTarje");
    }

    traza("Asignar Clases Tarjeta");
    if (rClasesTarjeta.getRowCount() > 0)
    {
      utilidadesBelcorp.agregarRegistroVacio(rClasesTarjeta,0);    
      DruidaConector conClasesTarjeta = this.generarConector("rowsetClasesTarje", rClasesTarjeta, rClasesTarjeta.getColumnIdentifiers() );
      this.asignar("COMBO", "comboClasesTarjeta", conClasesTarjeta, "rowsetClasesTarje");
    }    

    traza("Asignar Bancos");
    if (rBancos.getRowCount() > 0)
    {
      utilidadesBelcorp.agregarRegistroVacio(rBancos,0);         
      DruidaConector conBancos = this.generarConector("rowsetBancos", rBancos, rBancos.getColumnIdentifiers() );
      this.asignar("COMBO", "comboEntidadBancaria", conBancos, "rowsetBancos");
    }

    traza("Asignar Tipo Soluciones");
    if (rTipoSolucion.getRowCount() > 0)
    {
      utilidadesBelcorp.agregarRegistroVacio(rTipoSolucion,0);             
      DruidaConector conBancos = this.generarConector("rowsetSoluciones", rTipoSolucion, rTipoSolucion.getColumnIdentifiers() );
      this.asignar("COMBO", "comboTipoSolucion", conBancos, "rowsetSoluciones");
    }

    traza("Asignar Tipo Problemas");
    if (rTipoProblema.getRowCount() > 0)
    {
      utilidadesBelcorp.agregarRegistroVacio(rTipoProblema,0);                  
      DruidaConector conProblemas = this.generarConector("rowsetProblemas", rTipoProblema, rTipoProblema.getColumnIdentifiers() );
      this.asignar("COMBO", "comboTipoProblema", conProblemas, "rowsetProblemas");
    }

    traza("Asignar Tipos de Perfiles Psicografia");
    if (rPerfiles.getRowCount() > 0)
    {
      utilidadesBelcorp.agregarRegistroVacio(rPerfiles,0);                  
      DruidaConector conPerfiles = this.generarConector("rowsetPerfiles", rPerfiles, rPerfiles.getColumnIdentifiers() );
      this.asignar("COMBO", "comboTipoPerfil", conPerfiles, "rowsetPerfiles");
    }
 
    
    traza("antes de castear");
    /*********************************************************/

    /* Vector v = this.obtieneTipos(elementos);*/ 
    /*RecordSet rTipos = (RecordSet) v.get(0);
    RecordSet rSubTipos = (RecordSet) v.get(1);*/
    /* Long[] oidSubtipos = (Long[]) v.get(2);*/ 

    traza("rTipos: " + rDescTipos);
    traza("rSubTipos: " + rDescSubtipos);

    //  Asigna el RecordSet rTipos al combo de la pagina.
    traza("1");
    DruidaConector conTipoCliente = 
             UtilidadesBelcorp.generarConector("tiposCliente", 
                                                    rDescTipos, 
                                                    rDescTipos.getColumnIdentifiers() );
    traza("2");         
    this.asignar("COMBO", "cbTipoCliente", conTipoCliente, "tiposCliente");
    traza("3");         
 

    Vector colID = rDescSubtipos.getColumnIdentifiers();
    DruidaConector dsubtipo = 
             this.generarConector("DTOSalida.subtipo_ROWSET", 
                                     rDescSubtipos, 
                                     colID);
    traza("conector Subtipo: " + dsubtipo.getXML() );    
    //this.crearListaLP(colID, rSubTipos.getColumnCount(), "Capa5", "ListaSubtipo", "14", "200");
    //asignar("LISTA", "ListaSubtipo", dsubtipo, "DTOSalida.subtipo_ROWSET");
    asignar("LISTADOA", "ListaSubtipo", dsubtipo, "DTOSalida.subtipo_ROWSET");    

    
   /***********************************************************/

   // TipoClasificacion
    
    utilidadesBelcorp.agregarRegistroVacio( rTipoClasificaciones, 0);
    
    colID = rTipoClasificaciones.getColumnIdentifiers();
    DruidaConector dtipo = this.generarConector("DTOSalida.tiposClasificacion_ROWSET", rTipoClasificaciones, colID);
    this.crearListaLP(colID, rTipoClasificaciones.getColumnCount(), "Capa2", "ListaTipoClasi", "14", "200");
    asignar("LISTA", "ListaTipoClasi", dtipo, "DTOSalida.tiposClasificacion_ROWSET");
    //asignar("COMBO", "comboTipoClasificacion", dtipo, "DTOSalida.tiposClasificacion_ROWSET");
    traza("paso 7");

    // Clasificaciones
    RecordSet clasif = dtoP4.getClasificaciones();
    utilidadesBelcorp.agregarRegistroVacio(clasif, 0);
    colID = clasif.getColumnIdentifiers();
    dtipo = this.generarConector("DTOSalida.clasificaciones_ROWSET", clasif, colID);
    this.crearListaLP(colID, clasif.getColumnCount(), "Capa1", "Lista1", "14", "200");
    asignar("LISTA", "Lista1", dtipo, "DTOSalida.clasificaciones_ROWSET");
             traza("paso 8");

    /**/
    rTipoClasificaciones.removeColumn(1);
   
    //reentrando = false; // TODO: Quitar esto luego de tener todo andando.
    DTOCliente dtoClienteSesion = (DTOCliente) this.conectorParametroSesion("DTOCliente");
    if (reentrando == false)  // Setea
    {
      traza("Entrando a P4 por primera vez");
      DTOTarjeta[] dtoTarj = dtoClienteSesion.getTarjetas();
      StringBuffer cadenaBanco = new StringBuffer(""); 
      traza("Seteo cadena para Lista Tarjetas");
      if (dtoTarj.length != 0)
      {
         for (int n = 0; n < dtoTarj.length; n++)
         {
             if (n != 0)
                cadenaBanco.append("|");
                
             DTOTarjeta dtoT = dtoTarj[n];
             traza("DTOTarjeta[" + n + "]: " + dtoT);
             Long oidT = dtoT.getOid();
             Long banco = dtoT.getBanco();
             Long clase = dtoT.getClase();
             Long tipo = dtoT.getTipo();
             
             cadenaBanco.append(oidT.toString() + ";");
             cadenaBanco.append(tipo.toString() + ";");             

             if ( clase == null)
                cadenaBanco.append(" ;");
             else
                cadenaBanco.append(clase.toString() + ";");             

             if (banco == null)
                cadenaBanco.append(" ");
             else
                cadenaBanco.append(banco);
             //cadenaBanco.append(banco);
             
         }
      }
      traza("cadenaBanco a setear: " + cadenaBanco.toString() );
      asignarAtributo("VAR", "hidListaTarjetas", "valor", cadenaBanco.toString() );

      traza("Seteo cadena para Lista Clasificaciones");

      DTOClasificacionCliente[] dtoClasi = dtoClienteSesion.getBase().getClasificaciones();
      StringBuffer cadenaClasi = new StringBuffer("");
      if ( dtoClasi.length != 0)
      {
         RecordSet rListaClasificacion = new RecordSet();
         rListaClasificacion.setColumnCount(13);
         Vector vIdentifiers = new Vector();
         vIdentifiers.add("OID");
         vIdentifiers.add("MARCA_DESC");
         vIdentifiers.add("CANAL_DESC");
         vIdentifiers.add("TIPO_CLIE_DESC");
         vIdentifiers.add("SUBTI_CLIE_DESC");
         vIdentifiers.add("TIPO_CLASI_DESC");
         vIdentifiers.add("CLASI_DESC");
         vIdentifiers.add("OID_MARCA");
         vIdentifiers.add("OID_CANAL");
         vIdentifiers.add("OID_TIPO_CLASI");
         vIdentifiers.add("OID_CLASI");
         vIdentifiers.add("OID_TIPO_CLIE");
         vIdentifiers.add("OID_SUBTIPO_CLIE");
         
         rListaClasificacion.setColumnIdentifiers(vIdentifiers);

         
         for (int n = 0; n < dtoClasi.length; n++)
         {
             Vector vFila = new Vector();
             DTOClasificacionCliente dtoC = dtoClasi[n];
             traza("dtoC: " + dtoC.toString() );

             //traza("Paso 1 "); 
             Long oidClasi = dtoC.getOid(); 
             //traza("Paso 2 ");
             Long marcaClasi = dtoC.getMarca();
             //traza("Paso 3 ");
             Long canalClasi = dtoC.getCanal();
             //traza("Paso 4 ");
             Long tipoClasi = dtoC.getTipoClasificacion();
             //traza("Paso 5 ");
             Long clasi = dtoC.getClasificacion();
             //traza("Paso 6 ");
             Long tipoClie = dtoC.getTipo();
             Long subtiClie = dtoC.getSubtipo();
             String descMarca = dtoC.getMarcaDesc();
             String descCanal  = dtoC.getCanalDesc();
             String descTipoClie = dtoC.getTipoDesc();
             String descSubtiClie = dtoC.getSubtipoDesc();
             String descTipoClasi = dtoC.getTipoClasificacionDesc();
             String descClasi = dtoC.getClasificacionDesc();

             rListaClasificacion.setRowCount(n+1);
             rListaClasificacion.setValueAt(oidClasi, n, 0);
             rListaClasificacion.setValueAt(descMarca, n, 1);
             rListaClasificacion.setValueAt(descCanal, n, 2);             
             rListaClasificacion.setValueAt(descTipoClie, n, 3);                           
             rListaClasificacion.setValueAt(descSubtiClie, n, 4);                                         
             rListaClasificacion.setValueAt(descTipoClasi, n, 5);                                                      
             rListaClasificacion.setValueAt(descClasi, n, 6);                                                                    
             rListaClasificacion.setValueAt(marcaClasi, n, 7);                                                                                  
             rListaClasificacion.setValueAt(canalClasi, n, 8);                                                                                                
             rListaClasificacion.setValueAt(tipoClasi, n, 9);             
             rListaClasificacion.setValueAt(clasi, n, 10);                           
             rListaClasificacion.setValueAt(tipoClie, n, 11);
             rListaClasificacion.setValueAt(subtiClie, n, 12);
             

             traza("rListaClasi hasta ahora: " + rListaClasificacion);
         }
         traza("rListaClasificacion Final: " + rListaClasificacion);
         DruidaConector conClasificacion = UtilidadesBelcorp.generarConector("clasi", rListaClasificacion, rListaClasificacion.getColumnIdentifiers() );
         asignar("LISTA", "listado2", conClasificacion, "clasi");

      }
         
/*      traza("cadena Clasificacion a Setear: " + cadenaClasi.toString() );
      this.asignarAtributo("VAR", "hidListaClasificacion", "valor", cadenaClasi.toString() );*/

      traza("Seteo cadena para Problemas/Soluciones");
      DTOProblemaSolucion[] dtoProbSol = dtoClienteSesion.getProblemasSoluciones();
      StringBuffer cadenaProblema = new StringBuffer("");
      if (dtoProbSol.length != 0)
      {
         DTOProblemaSolucion dtoP = null;

         RecordSet rProb = new RecordSet();
         rProb.setColumnCount(7);
         Vector vColsIdent = new Vector();
         vColsIdent.add("OID");
         vColsIdent.add("TIPO_PROBLEMA");
         vColsIdent.add("DESC_PROBLEMA");
         vColsIdent.add("IND_SOLUCION");
         vColsIdent.add("TIPO_SOLUCION");
         vColsIdent.add("DESC_SOLUCION");
         vColsIdent.add("NEGOCIO");
         rProb.setColumnIdentifiers(vColsIdent);
         
         for (int n = 0; n < dtoProbSol.length; n++)
         {
              dtoP = dtoProbSol[n];
              traza("dtoP: " + dtoP.toString() );
              Long oid = dtoP.getOid(); // Not null
              Long tipoProblema = dtoP.getTipoProblema(); // Not null
              String descProblema = dtoP.getDescripcionProblema(); // Descripcion
              Boolean solucion = dtoP.getSolucion(); // Solucion
              Long tipoSolucion = dtoP.getTipoSolucion(); // Tipo solucion
              String descSolucion = dtoP.getDescripcionSolucion();
              String negocio = dtoP.getNegocio();
              
              rProb.setRowCount(n+1);
              rProb.setValueAt(oid, n, 0);
              rProb.setValueAt(tipoProblema, n, 1);
                
              if (descProblema == null)
                 rProb.setValueAt("", n, 2);
              else
                 rProb.setValueAt(descProblema, n, 2);

              if ( solucion != null && solucion.booleanValue() )
                 rProb.setValueAt("S", n, 3);
              else
                 rProb.setValueAt("N", n, 3);

              if ( tipoSolucion == null)
                 rProb.setValueAt("", n, 4);
              else
                 rProb.setValueAt(tipoSolucion.toString(), n,4);

              if (descSolucion == null)
                 rProb.setValueAt("", n, 5);
              else  
                 rProb.setValueAt(descSolucion, n, 5);

              if (negocio == null)
                 rProb.setValueAt("", n, 6);
              else
                 rProb.setValueAt(negocio, n, 6);

              traza("rProb hasta ahora: " + rProb);

         }

         DruidaConector conProblemaSolucion = UtilidadesBelcorp.generarConector("problema", rProb, rProb.getColumnIdentifiers());
         asignar("LISTA", "listado3", conProblemaSolucion, "problema");
      }

      traza("cadena de Problema/Solucion: " + cadenaProblema.toString() );
      asignarAtributo("VAR", "hidListaProbSolu", "valor", cadenaProblema.toString() );

      traza("Forma cadena de Psicografia");
      DTOPsicografia[] dtoPsicoArray = dtoClienteSesion.getPsicografias();
      StringBuffer cadenaPsico = new StringBuffer("");
      if (dtoPsicoArray.length != 0)
      {
         DTOPsicografia dtoPsico = null;
         for ( int n = 0; n < dtoPsicoArray.length; n++)
         {
           dtoPsico = dtoPsicoArray[n];
           traza("dtoPsico "  + n + ": " + dtoPsico);

           if ( n != 0)
             cadenaPsico.append("|");

           Long oidPsico = dtoPsico.getOid();
           Long marcaPsico = dtoPsico.getMarca();
           Long tipoPerfil = dtoPsico.getTipoPerfil();
           String codigoTest = dtoPsico.getCodigoTest();
           Date fechaPsico = dtoPsico.getFecha();

           cadenaPsico.append(oidPsico.toString() + ";");
           cadenaPsico.append(marcaPsico.toString() + ";");
           cadenaPsico.append(tipoPerfil.toString() + ";");
           cadenaPsico.append(codigoTest + ";");
           
           
           if ( fechaPsico != null ) {
             cadenaPsico.append(UtilidadesBelcorp.fechaFormateada(fechaPsico, UtilidadesSession.getFormatoFecha(this)));
           } else {
             cadenaPsico.append(" ");
           }
           
         }
         
      }
      traza("Cadena de Psico: " + cadenaPsico.toString() );
      asignarAtributo("VAR", "hidListaPsico", "valor", cadenaPsico.toString());
      
    } else
    {

      // Si se está reentrando, param contiene los valores de las variables
      // de las listas (ya que contiene los datos de P4 en lugar de P3) 
      // Solamente las tomo y las vuelvo a setear.
      
      traza("Reentrando a P4");

      traza("Asignando Cadena de tarjetas ya existente...");
      String cadenaListaTarjeta = (String) param.get("hidListaTarjetas");    
      traza("---- Cadena Tarjetas: " + cadenaListaTarjeta);
      if ( cadenaListaTarjeta != null )
           this.asignarAtributo("VAR", "hidListaTarjetas", "valor", cadenaListaTarjeta);

      traza("Asignando Cadena de tarjetas ya existente...");
      String cadenaListaClasificacion = (String) param.get("hidListaClasificacion");    
      traza("---- Cadena Clasificacion: " + cadenaListaClasificacion);
      if ( cadenaListaClasificacion != null )
           this.asignarAtributo("VAR", "hidListaClasificacion", "valor", cadenaListaClasificacion);


      traza("Asignando Cadena de Psicografia ya existente...");
      String cadenaListaPsicografia = (String) param.get("hidListaPsico");
      traza("---- Cadena Psicograficas: " + cadenaListaPsicografia);
      if ( cadenaListaPsicografia != null )
           this.asignarAtributo("VAR", "hidListaPsico", "valor", cadenaListaPsicografia);  
      
      traza("Asignando Grupo de Problemas/Soluciones ya existente...");
      String cadenaListaProb = (String) param.get("hidListaProbSolu");
      traza("---- Cadena Problemas: " + cadenaListaProb);
      if ( cadenaListaProb != null )
           this.asignarAtributo("VAR", "hidListaProbSolu", "valor", cadenaListaProb);  


      // Asignar variables de form. sobre campos eliminados
      // -------------------------------------------------------------------
      
      traza("Asignando Elementos Eliminados Tarjetas...");
      String cadenaElimTarjetas = (String) param.get("elemEliminadosTarjetas");
      traza("---- Cadena Elementos Elim. Tarjetas: " + cadenaElimTarjetas);
      if ( cadenaElimTarjetas != null )
           this.asignarAtributo("VAR", "elemEliminadosTarjetas", "valor", cadenaElimTarjetas);  

      traza("Asignando Elementos Eliminados Clasificacion...");
      String cadenaElimClasif = (String) param.get("elemEliminadosClasificacion");
      traza("---- Cadena Elementos Elim. Clasificacion: " + cadenaElimClasif);
      if ( cadenaElimClasif != null )
           this.asignarAtributo("VAR", "elemEliminadosClasificacion", "valor", cadenaElimClasif);  

      traza("Asignando Elementos Eliminados Problema...");
      String cadenaElimProb = (String) param.get("elemEliminadosProblema");
      traza("---- Cadena Elementos Elim. Problema: " + cadenaElimProb);
      if ( cadenaElimProb != null )
           this.asignarAtributo("VAR", "elemEliminadosProblema", "valor", cadenaElimProb);             

      traza("Asignando Elementos Eliminados Psicografia...");
      String cadenaElimPsico = (String) param.get("elemEliminadosPsico");
      traza("---- Cadena Elementos Elim. Problema: " + cadenaElimPsico);
      if ( cadenaElimPsico != null )
           this.asignarAtributo("VAR", "elemEliminadosPsico", "valor", cadenaElimPsico);    

      this.asignarAtributo("VAR", "hI18N", "valor", "S");   

      String sTemp = (String) param.get("elemEliminadosTarjetas");
      if (sTemp == null) { sTemp = "";};
      traza("Elementos de Tarjetas eliminados: " + sTemp);
      this.asignarAtributo("VAR", "elemEliminadosTarjetas", "valor", sTemp);

      sTemp = (String) param.get("elemEliminadosClasificacion");
      if (sTemp == null) { sTemp = "";};
      traza("Elementos de Clasificacion eliminados: " + sTemp);
      this.asignarAtributo("VAR", "elemEliminadosClasificacion", "valor", sTemp);

      sTemp = (String) param.get("elemEliminadosProblema");
      if (sTemp == null) { sTemp = "";};
      traza("Elementos de Problema eliminados: " + sTemp);
      this.asignarAtributo("VAR", "elemEliminadosProblema", "valor", sTemp);      

      sTemp = (String) param.get("elemEliminadosPsico");
      if (sTemp == null) { sTemp = "";};
      traza("Elementos de PsicoGrafias eliminados: " + sTemp);
      this.asignarAtributo("VAR", "elemEliminadosPsico", "valor", sTemp);      

     
      
    }
   
 }

 private boolean chequeaExistenciaTipos(Long codTipo, RecordSet rTipos)throws Exception
 {
   // Chequea que coincida el Long codTipo matchee
   // con alguno del RecordSet.
   // Si es asi, devuelve true
   // Si no, false.
   traza("1");
   
   boolean match = false;
   int rows = rTipos.getRowCount();
     
   traza("la cantidad " + rTipos.getRowCount());

   if ( rows > 0){
   traza("2");
     int i = 0;
     while ( i < rows  && match == false)
     {
         traza("3");
         Long tipo = new Long(((BigDecimal) rTipos.getValueAt(i,0) ).longValue());
         if (codTipo.equals(tipo))
           match = true;
         i++;
     }
     
   }
   traza("el match es " + match);
   return match;
 }

  private String obtieneDescripcionClasificacion(Long clasificacion, RecordSet rs) throws Exception
  {
      // Recorre el recordset. Donde el oid matchea clasificacion, devuelve esa descripcion
      BigDecimal oid = null;
      String desc = "";

      if (rs.getRowCount() > 0)
      {
         boolean bFlag = true;
         int i = 0;
         while (bFlag && (i < rs.getRowCount()) )
         {
             BigDecimal bigDecimal = (BigDecimal) rs.getValueAt(i,0);
             if (bigDecimal.longValue() == clasificacion.longValue())
             {
                desc = (String) rs.getValueAt(i,2);
                traza("Match... Desc es: " + desc);
                bFlag = false;
             }
             i++;
         }

      }
      
      return desc;
  }

  
 private String transformaFechas(Date fechaBD) throws Exception
  { 
      
      traza("TransformaFechas");
      // Transforma las Fechas para mostrar en pantalla, en formato de Sesión.
      String formatoFechaSesion = UtilidadesSession.getFormatoFecha(this);
      formatoFechaSesion = formatoFechaSesion.replace('m', 'M');
      //traza("Antes: " + fechaBD.toString() );
      SimpleDateFormat sFormat = new SimpleDateFormat(formatoFechaSesion);
      String sBuffer = sFormat.format(fechaBD);
      //traza("Despues: " + sBuffer.toString() );

      return sBuffer;
    
  }

 private void BackP1()throws Exception{
    traza("Entra a BackP1");
          try{
                           ptna2=(HashMap) conectorParametroSesion("pestana2");
                           DruidaConector dtipo =(DruidaConector)conectorParametroSesion("cbFPago");
                           traza("********ListaPrefe*****"+ptna2.get("hidListaVinculo").toString());
                           obtenerConfiguracionCampos();
                           traza("Estoy en Bak1");
                           DTOPestanya2 dtop2Base =(DTOPestanya2)conectorParametroSesion("dtop2Base");
                           traza("1");
                           DTOCliente clie = (DTOCliente)conectorParametroSesion("DTOCliente");
                           traza("2");
                           UtilidadesSession sesion = new UtilidadesSession();
                           UtilidadesBelcorp PVinc = new UtilidadesBelcorp();
                           UtilidadesBelcorp TVinc = new UtilidadesBelcorp();
                           UtilidadesBelcorp TPrefer = new UtilidadesBelcorp();
                           UtilidadesBelcorp TMarca = new UtilidadesBelcorp();
                           traza("3");
                           RecordSet nacionalidad = (RecordSet)dtop2Base.getNacionalidad();
                           RecordSet estadoCivil = (RecordSet)dtop2Base.getEstadoCivil();
                           RecordSet nivelEstudios = (RecordSet)dtop2Base.getNivelEstudios();
                           RecordSet NSEP = (RecordSet)dtop2Base.getNSEP();
                           RecordSet cicloVida = (RecordSet)dtop2Base.getCiclosVida();
                           RecordSet marcaObservacionN = (RecordSet)dtop2Base.getMarcas();
                           RecordSet paisContactado = (RecordSet)dtop2Base.getPaises();
                           RecordSet paisVinculoN = (RecordSet)dtop2Base.getPaises();
                           PVinc.agregarRegistroVacio(paisVinculoN,0);
                           RecordSet tipoPreferenciaN = (RecordSet)dtop2Base.getTiposPreferencias();
                           TPrefer.agregarRegistroVacio(tipoPreferenciaN,0);
                           RecordSet tipoVinculo1 = (RecordSet)dtop2Base.getTiposVinculo();
                           TVinc.agregarRegistroVacio(tipoVinculo1,0);
                           RecordSet tipoClienteContactado = (RecordSet)dtop2Base.getTipoCliente();
                           RecordSet marca = (RecordSet)dtop2Base.getMarcas();
                           TMarca.agregarRegistroVacio(marca,0);
                           traza("4");
                           traza(dtop2Base);
                           asignar("COMBO","cbFormaPago",dtipo,"DTOSalida.formasPago_ROWSET");
                           asignar("COMBO","cbNacionalidad",this.getRowset(nacionalidad,"DTOSalida.nacionalidad_ROWSET"));
                           asignar("COMBO","cbEstadoCivil",this.getRowset(estadoCivil,"DTOSalida.estadoCivil_ROWSET"));
                           asignar("COMBO","cbNivelEstudios",this.getRowset(nivelEstudios,"DTOSalida.nivelEstudios_ROWSET"));
                           asignar("COMBO","cbNivelSocioEconomico",this.getRowset(NSEP,"DTOSalida.NSEP_ROWSET"));
                           asignar("COMBO","comboPaisVinculo",this.getRowset(paisVinculoN,"DTOSalida.paises_ROWSET"));
                           asignar("COMBO","cbCicloVidaFamiliar",this.getRowset(cicloVida,"DTOSalida.cicloVida_ROWSET"));
                           asignar("COMBO","cbPaisContactado",this.getRowset(paisContactado,"DTOSalida.paises_ROWSET"));
                           asignar("COMBO","comboTipoPreferencia",this.getRowset(tipoPreferenciaN,"DTOSalida.tiposPreferencias_ROWSET"));
                           asignar("COMBO","cbTipoClienteContactado",this.getRowset(tipoClienteContactado,"DTOSalida.tipoCliente_ROWSET"));
                           asignar("COMBO","comboMarca",this.getRowset(marca,"DTOSalida.marcas_ROWSET"));
                           asignar("COMBO","comboTipoVinculo",this.getRowset(tipoVinculo1,"DTOSalida.tiposVinculo_ROWSET"));
                           traza("5");
                           asignarAtributo("CTEXTO","textApellido1","valor",ptna2.get("textApellido1").toString());
                           asignarAtributo("CTEXTO","textApellido2","valor",ptna2.get("textApellido2").toString());
                           asignarAtributo("CTEXTO","textApellidoCasada","valor",ptna2.get("textApellidoCasada").toString());
                           asignarAtributo("CTEXTO","textNombre1","valor",ptna2.get("textNombre1").toString());
                           asignarAtributo("CTEXTO","textNombre2","valor",ptna2.get("textNombre2").toString());
                           asignarAtributo("CTEXTO","textFechaNacimiento","valor",ptna2.get("textFechaNacimiento").toString());
                           traza("51");
                           asignarAtributo("CTEXTO","textCodEmpleado","valor",ptna2.get("textCodEmpleado").toString());
                           traza("52");
                           asignarAtributo("CTEXTO","textCentroEstudios","valor",ptna2.get("textCentroEstudios").toString());
                           traza("53");
                           asignarAtributo("CTEXTO","textNHijos","valor",ptna2.get("textNHijos").toString());
                           traza("54");
                           asignarAtributo("CTEXTO","textNPersonasDependientes","valor",ptna2.get("textNPersonasDependientes").toString());
                           traza("55");
                           asignarAtributo("CTEXTO","textImporteIngresoFamiliar","valor",ptna2.get("textImporteIngresoFamiliar").toString());
                           traza("56");
                           asignarAtributo("CTEXTO","textOcupacion","valor",ptna2.get("textOcupacion").toString());
                           traza("57");
                           asignarAtributo("CTEXTO","textCentroTrabajo","valor",ptna2.get("textCentroTrabajo").toString());
                           traza("58");
                           asignarAtributo("CTEXTO","textCodClienteContactado","valor",ptna2.get("textCodClienteContactado").toString());
                           traza("59");
                           asignarAtributo("CTEXTO","textFechaContacto","valor",this.transformaFechas(clie.getFechaPrimerContacto()));
                           traza("5");
                           //asignarAtributo("CTEXTO","textFecha1PedidoContacto","valor",this.transformaFechas(clie.getFechaPrimerPedidoContactado()));
                           traza("501");
                           asignarAtributo("CTEXTO","textFechaSiguienteContacto","valor",this.transformaFechas(clie.getFechaSiguienteContacto()));
                           traza("502");
                           asignarAtributo("CTEXTO","textProfesion","valor",ptna2.get("textProfesion").toString());
                           traza("503");
                           asignarAtributo("CTEXTO","textCargoDesempena","valor",ptna2.get("textCargoDesempena").toString());
                           traza("504");
                           asignarAtributo("LABELC","lblPaisContactoActual","valor",sesion.getDescripcionPais(this));
                           traza("505");
                           asignarAtributo("LABELC","lblTipoClienteContactoActual","valor",clie.getTipoClienteContacto().toString());
                           traza("6");
                           asignarAtributo("VAR","h_cbTratamiento","valor",ptna2.get("h_cbTratamiento").toString());
                           asignarAtributo("VAR","h_rbSexo","valor",ptna2.get("h_rbSexo").toString());
                           asignarAtributo("VAR","h_cbFormaPago","valor",ptna2.get("h_cbFormaPago").toString());
                           asignarAtributo("VAR","h_cbNacionalidad","valor",ptna2.get("h_cbNacionalidad").toString());
                           asignarAtributo("VAR","h_cbEstadoCivil","valor",ptna2.get("h_cbEstadoCivil").toString());
                           asignarAtributo("VAR","h_cbNivelEstudios","valor",ptna2.get("h_cbNivelEstudios").toString());
                           asignarAtributo("VAR","h_cbNivelSocioEconomico","valor",ptna2.get("h_cbNivelSocioEconomico").toString());
                           asignarAtributo("VAR","h_cbCicloVidaFamiliar","valor",ptna2.get("h_cbCicloVidaFamiliar").toString());
                           asignarAtributo("VAR","h_rbDeseaCorrespondencia","valor",ptna2.get("h_rbDeseaCorrespondencia").toString());
                           asignarAtributo("VAR","h_cbPaisContactado","valor",ptna2.get("h_cbPaisContactado").toString());
                           asignarAtributo("VAR","h_cbTipoClienteContactado","valor",ptna2.get("h_cbTipoClienteContactado").toString());
                           traza("7");
                           asignarAtributo("VAR","hidListaVinculo","valor",ptna2.get("hidListaVinculo").toString());
                           asignarAtributo("VAR","hidListaObservacion","valor",ptna2.get("hidListaObservacion").toString());
                           asignarAtributo("VAR","hidListaPrefe","valor",ptna2.get("hidListaPrefe").toString());
                           
                           
                           }catch(Throwable th){
             this.traza("error en Back1");
             ByteArrayOutputStream stack = new ByteArrayOutputStream();
             PrintStream out = new PrintStream(stack);
             th.printStackTrace(out);
             traza(  stack.toString());
             BelcorpError belcorpError = new BelcorpError();
             DTOError dtoError = belcorpError.obtenerError(      th, 
             UtilidadesSession.getIdioma_ISO( this ) , 
                                             ""      
                                           );
             String s = th.getMessage();
             traza (  dtoError.getCodigoError() + " - " + dtoError.getDescripcionError() );
                    throw((Exception) th);
        
            } 
 }


  private void asignarAtributoRequerido(Vector resultado) throws Exception
  {     
      traza("Entra a asignarAtributoRequerido");
      DTOCampo dtoCampo = null;
      HashMap hashCampos = new HashMap();
      
      Vector vCampos = new Vector();
      Vector vTipoNombre = new Vector();

      // Apellido 1 
      vTipoNombre.add("CTEXTO");
      vTipoNombre.add("textApellido1");
      hashCampos.put("MAECLIEAPELL1", vTipoNombre);

      // Apellido 2
      vTipoNombre = new Vector();
      vTipoNombre.add("CTEXTO");
      vTipoNombre.add("textApellido2");
      hashCampos.put("MAECLIEAPELL2", vTipoNombre);
      
      // Apellido Casada
      vTipoNombre = new Vector();
      vTipoNombre.add("CTEXTO");
      vTipoNombre.add("textApellidoCasada");
      hashCampos.put("MAECLIEAPELLCA", vTipoNombre);
      
      // Apellido Nombre 1 
      vTipoNombre = new Vector();
      vTipoNombre.add("CTEXTO");
      vTipoNombre.add("textNombre1");
      hashCampos.put("MAECLIENOM1", vTipoNombre);      

      // Apellido Nombre 2
      vTipoNombre = new Vector();
      vTipoNombre.add("CTEXTO");
      vTipoNombre.add("textNombre2");
      hashCampos.put("MAECLIENOM2", vTipoNombre);             

      // Fecha Nacimiento
      vTipoNombre = new Vector();
      vTipoNombre.add("CTEXTO");
      vTipoNombre.add("textFechaNacimiento");
      hashCampos.put("MAECLIEFECHNA", vTipoNombre);                    

      // Codigo Empleado
      vTipoNombre = new Vector();
      vTipoNombre.add("CTEXTO");
      vTipoNombre.add("textCodEmpleado");
      hashCampos.put("MAECLIECODEMP", vTipoNombre);           

      // Ocupacion 
      vTipoNombre = new Vector();
      vTipoNombre.add("CTEXTO");
      vTipoNombre.add("textOcupacion");
      hashCampos.put("MAECLIEOCUP", vTipoNombre);                  

      // Profesion
      vTipoNombre = new Vector();
      vTipoNombre.add("CTEXTO");
      vTipoNombre.add("textProfesion");
      hashCampos.put("MAECLIEPROF", vTipoNombre);                         

      // Centro de Trabajo
      vTipoNombre = new Vector();
      vTipoNombre.add("CTEXTO");
      vTipoNombre.add("textCentroTrabajo");
      hashCampos.put("MAECLIECENTRA", vTipoNombre);                         
      
      // Cargo que desempeña
      vTipoNombre = new Vector();
      vTipoNombre.add("CTEXTO");
      vTipoNombre.add("textCargoDesempena");
      hashCampos.put("MAECLIECARGO", vTipoNombre);                                
      
      // Centro Estudios
      vTipoNombre = new Vector();
      vTipoNombre.add("CTEXTO");
      vTipoNombre.add("textCentroEstudios");
      hashCampos.put("MAECLIECENESTU", vTipoNombre);                                

      // Personas Dependientes
      vTipoNombre = new Vector();
      vTipoNombre.add("CTEXTO");
      vTipoNombre.add("textNPersonasDependientes");
      hashCampos.put("MAECLIEPERSDEP", vTipoNombre);                                      

      // Ingresos Familiares
      vTipoNombre = new Vector();
      vTipoNombre.add("CTEXTO");
      vTipoNombre.add("textImporteIngresoFamiliar");
      hashCampos.put("MAECLIEINGFAM", vTipoNombre);   

      // Fecha de Ingreso 
      vTipoNombre = new Vector();
      vTipoNombre.add("LABELC");
      vTipoNombre.add("lbl2FechaIngresoActual");
      hashCampos.put("MAECLIEFECHING", vTipoNombre);          

      // Tratamiento
      vTipoNombre = new Vector();
      vTipoNombre.add("COMBO");
      vTipoNombre.add("cbTratamiento");
      hashCampos.put("MAECLIETRAT", vTipoNombre);                 

      // Nacionalidad 
      vTipoNombre = new Vector();
      vTipoNombre.add("COMBO");
      vTipoNombre.add("cbNacionalidad");
      hashCampos.put("MAECLIENACIO", vTipoNombre);                 

      // Estado Civil
      vTipoNombre = new Vector();
      vTipoNombre.add("COMBO");
      vTipoNombre.add("cbEstadoCivil");
      hashCampos.put("MAECLIEESTCIV", vTipoNombre);         

      // Nivel Estudios
      vTipoNombre = new Vector();
      vTipoNombre.add("COMBO");
      vTipoNombre.add("cbNivelEstudios");
      hashCampos.put("MAECLIENIVESTU", vTipoNombre);         

      // Nivel Socioeconomico
      vTipoNombre = new Vector();
      vTipoNombre.add("COMBO");
      vTipoNombre.add("cbNivelSocioEconomico");
      hashCampos.put("MAECLIENSEP", vTipoNombre);     

      // Ciclo de Vida
      vTipoNombre = new Vector();
      vTipoNombre.add("COMBO");
      vTipoNombre.add("cbCicloVidaFamiliar");
      hashCampos.put("MAECLIECICLVID", vTipoNombre);  

      // Sexo
      vTipoNombre = new Vector();
      vTipoNombre.add("RADIOB");
      vTipoNombre.add("rbSexo");
      hashCampos.put("MAECLIESEXO", vTipoNombre);  

      // Desea Correspondecia
      vTipoNombre = new Vector();
      vTipoNombre.add("RADIOB");
      vTipoNombre.add("rbDeseaCorrespondencia");
      hashCampos.put("MAECLIEDESCORR", vTipoNombre);  

      // Forma Pago (por inc. 5047)
      vTipoNombre = new Vector();
      vTipoNombre.add("COMBO");
      vTipoNombre.add("cbFormaPago");
      hashCampos.put("MAECLIEFORMPA", vTipoNombre);

      String codigoCampo = null;
      Boolean requerido = null;
      Boolean modificable = null;
      Vector vAsignar = null;
      String nombreCampoXML = null;
      String tipoCampoXML = null;
      StringBuffer sModificable = new StringBuffer(); 

      // Se utiliza para luego ver cual es el primer control (hasta el combo 
      // forma de Pago en la pantalla) que esta deshabilitado. 
      // (Para setear el foco, ya que un control deshabilitado al focalizar
      // tira error).
      //  - H por Habilitado      
      
      Vector vCamposFoco = new Vector();
      vCamposFoco.add("textApellido1");
      vCamposFoco.add("textApellido2");      
      vCamposFoco.add("textApellidoCasada");             
      vCamposFoco.add("textNombre1");                    
      vCamposFoco.add("textNombre2");                           
      vCamposFoco.add("cbTratamiento");                                  
      vCamposFoco.add("cbFormaPago");
      HashMap hshFoco = new HashMap();
      
      for (int i = 0; i < vCamposFoco.size(); i++)
           hshFoco.put((String) vCamposFoco.get(i), "H");

      traza("dtoCampo.size(): " + resultado.size() );
      //for (int i = 0; i < 24; i++)
      StringBuffer obligatorio = new StringBuffer("");
      for (int i = 0; i < resultado.size(); i++)
      {
         traza("Bucle " + i);
         //traza("AsignarAtributo, bucle " + i);
         dtoCampo = (DTOCampo)resultado.get(i);
         codigoCampo = dtoCampo.getCodigoCampo();
         //traza("param " + i + ": " + dtoCampo.toString() );
         //traza("    - codigo Campo: " + codigoCampo );
         requerido = dtoCampo.getObligatorio();
         modificable = dtoCampo.getModificable();
         
         vAsignar = (Vector) hashCampos.get(codigoCampo);
         tipoCampoXML = (String) vAsignar.get(0);
         nombreCampoXML = (String) vAsignar.get(1);     

         // Obligatoriedad
         traza("Obligatorio");
         if (requerido.booleanValue() == true)
         {
           if ( !obligatorio.toString().equals("") )
             obligatorio.append(",");

           obligatorio.append(nombreCampoXML);
           this.asignarAtributo(tipoCampoXML, nombreCampoXML, "req", "S");
           
         }
         else
         {
           this.asignarAtributo(tipoCampoXML, nombreCampoXML, "req", "N");        
         }

        // Modificabilidad
        traza("Modificable");
        if (modificable.booleanValue() == false )
        {
            if (!nombreCampoXML.equals("lbl2FechaIngresoActual") )
            {

                                                        if (sModificable.length() > 0)  
                                                        {
                                                                 // Ya se agrego al menos 1 campo, por lo que al siguiente (éste campo)
                                                                 // se le antepone una coma.
                                                                 sModificable.append(",");
                                                        }
                                                        sModificable.append(nombreCampoXML);
                                                        hshFoco.put(nombreCampoXML, "D");
                     }

         }
         traza("Fin bucle " + i );
      } // Fin bucle de 23 campos.
      traza("Fin FOR ");

      traza("obligatorio: " + obligatorio.toString());
      this.asignarAtributo("VAR", "obligatorio", "valor", obligatorio.toString());
      // Chequea si algun campo es no modificable. t
      String sCampoFocalizado = "textApellido1"; // Por defecto, forma de Pago.      
      traza("longitud sModificable: " + sModificable.length() );
      if (sModificable.length() > 0) 
      {
         this.asignarAtributo("VAR", "modificabilidad", "valor", sModificable.toString() );         
         traza("Cadena modificabilidad: " + sModificable.toString());

         // Chequea el HashMap para ver cual es el primer campo no deshabilitado (si hay uno)
         boolean continuar = true;
         int i = 0;
         String sBufferCampo = "";
         //sCampoFocalizado = "cbFormaPago"; // Por defecto, forma de Pago.
         sCampoFocalizado = "textFechaNacimiento";  // Fecha Nacimiento

         while ( i < vCamposFoco.size() && continuar == true)
         {
           sBufferCampo = (String)hshFoco.get( (String) vCamposFoco.get(i) );
           if (sBufferCampo.equals("H") )
           {
                // Este es el primer campo no deshabilitado, que deberia tomar el foco. 
                // Setea este campo y termina el bucle.
                sCampoFocalizado = (String) vCamposFoco.get(i);
                continuar = false;
           }
           i++;
         }
      
      }
      traza("Campo a focalizar: " + sCampoFocalizado);
      asignarAtributo("VAR", "campoToFocalizar", "valor", sCampoFocalizado);
      

  } 

  private void goBack1() throws Exception
  {
         this.mostrarPantalla("BackP1");
         this.BackP1();
                           asignarAtributo("VAR","casoDeUso","valor","ModificarCliente");
                  asignarAtributo("VAR","oidNull","valor",ptna2.get("oidNull").toString());

  }

  private void goBack2() throws Exception
  {

      traza("****** Entrando a goBack2 ************");

      // TODO: Se puede retornar a la 2 desde la pestaña 1 o la 3. 
      // de acuerdo a la que sea, setea el Hash ptna n correspondiente.
      // Para esto, agregar una variable de formulario, o algo similar que 
      // las distinga.
      ptna3 = param;
      conectorParametroSesion("pestana3", ptna3);

      // Toma el hashMap de la pestaña 2 de sesion y lo METE en param.
      param = (HashMap)conectorParametroSesion("pestana2");
      String sOidCliente = (String)this.conectorParametroSesion("oidCliente");
           traza("En goBack2() - sOidCliente"+sOidCliente);
      param.put("hOidCliente", sOidCliente);

      traza("param de pestana 2: " + param.toString() );
      this.mostrarPantalla("Validar");      

                           this.Validar(true);
                           asignarAtributo("VAR","casoDeUso","valor","ModificarCliente");         

  }  

  private void colaParametros(int ptna)throws Exception
  {
         traza(" ***** Entra a Cola de Parametros: " + ptna);
         HashMap tipoSubtipo = (HashMap) this.conectorParametroSesion("tipoSubt");
         HashMap p2 = null;
         traza("tipo y subtipo: " + tipoSubtipo.toString() );
         String str = null;
         try {
            if (ptna == 2) {
                // Separo ambas partes (parseado de cadena y luego parseado
                // de linea por claridad de codigo . 
                // Primero separa las filas por "|". 
                p2 = (HashMap) this.conectorParametroSesion("pestana2");                
                traza("P2: " + p2.toString() );                
                str = p2.get("hidListaVinculoSal").toString();                                
                traza("Pestanya 2, str: " + str);
                this.generaGrupoVinculo(str);
            } else {
                str = tipoSubtipo.get("elementos").toString();                             
                traza("str a parsear: " + str);             
                StringTokenizer tok = new StringTokenizer(str,";");
                //h_comboTipoCliente_0=1;h_comboTipoCliente_1=2;
                StringTokenizer tok1 = null;
                String clave=null;
                String valor=null;
                String elem;
                int dif=0;
                while (tok.hasMoreTokens()) {
                   elem=tok.nextToken().toString();
                   traza("##############"+elem);
                   tok1= new StringTokenizer(elem,"=");
                   clave=tok1.nextToken().toString();
                   traza("##############"+clave);
                   valor=elem.substring(clave.length()+1,elem.length());
                   traza("##############"+valor);
                   switch (ptna) {
                      case 0:
                          traza("setea clave: " + clave + ", valor: " + valor);
                          tipoSubtipo.put(clave, valor);
                          break;
                      case 1:
                          // ptna1.put((String)clave,(String)valor);
                          ptna1.put(clave, valor);
                          break;
                      case 2:
                          //GrupoVinculo.put( (String)clave, (String)valor );
                          GrupoVinculo.put(clave, valor);
                          break;
                      case 3:
                          //ptna3.put((String)clave,(String)valor);
                          ptna3.put(clave, valor);
                          break;
                                        }
                }
           }
           //Guarda en sesion el HashMap parseado
           switch(ptna)
           {
             case 0:     
                traza("HashMap tipoSubTipo a setear en sesion: " + tipoSubtipo.toString() );
                conectorParametroSesion("tipoSubt", tipoSubtipo);
                break;
           }
          
           traza(" ***** Sale de Cola de Parametros: " + ptna);     
      } catch(Throwable th) {
           this.traza("error colaParam");
           ByteArrayOutputStream stack = new ByteArrayOutputStream();
           PrintStream out = new PrintStream(stack);
           th.printStackTrace(out);
           traza(  stack.toString());
           BelcorpError belcorpError = new BelcorpError();
           DTOError dtoError = belcorpError.obtenerError(         th, 
           UtilidadesSession.getIdioma_ISO( this ) , 
      
                                           ""         
                                         );
           String s = th.getMessage();
           traza (  dtoError.getCodigoError() + " - " + dtoError.getDescripcionError() );
                  throw((Exception) th);
        
      }     
         
  }

  private void generaGrupoVinculo(String str) throws Exception {
         // Separo ambas partes (parseado de cadena y luego parseado
         // de linea por claridad de codigo . 
         // Primero separa las filas por "|". 

         String separadorLinea ="|";
         String separadorCampos = ";";
         String separadorElemento = "=";
                  
         StringTokenizer tokLinea = new StringTokenizer(str, separadorLinea);
         StringTokenizer tokCampo = null;
         StringTokenizer tokElemento = null;

         String sCampo = null;
         String sElemento = null;
         int cantTokens = tokLinea.countTokens();
                  
         String sLinea = null;
                  
         for ( int i = 0; i < cantTokens; i++) { // Recorre linea por linea
             // Cada linea es de formato xxxxx;yyyyy;zzzzzz
             traza("Linea " + i );
             sLinea = tokLinea.nextToken();

             tokCampo = new StringTokenizer(sLinea, separadorCampos);
             int cantCampos = tokCampo.countTokens();

             for (int j=0; j<cantCampos; j++) // Recorre Campo por Campo.
             { 
                  // Cada campo es de formato xxxx=yyyy (dos elementos SIEMPRE)
                  // nombre = valor
                  sCampo = tokCampo.nextToken();
                  traza("sCampo a insertar en GrupoVinculo: " + sCampo);                           

                  tokElemento = new StringTokenizer(sCampo, separadorElemento);
                  String sClave = tokElemento.nextToken();
                  String sValor = tokElemento.nextToken();
                  GrupoVinculo.put(sClave, sValor);
             }
                      
         }
    
  }

  private void guardar() throws Exception
  {
         pagina("salidaGenerica");
         DTOCrearClienteBasico dtoClienteBasico = new DTOCrearClienteBasico();
         DTOCliente dtoCliente = new DTOCliente();
         HashMap p0 = (HashMap) this.conectorParametroSesion("tipoSubt");
         HashMap p1 = (HashMap) this.conectorParametroSesion("pestana1");
         HashMap p2 = (HashMap) this.conectorParametroSesion("pestana2");
         HashMap p3 = (HashMap) this.conectorParametroSesion("pestana3");
         HashMap p4 = param; 
         
         String sFormatoFechaSesion = UtilidadesSession.getFormatoFecha(this) ;
         sFormatoFechaSesion = sFormatoFechaSesion.replace('m', 'M');
                  
         if ( p0 == null)
           traza("p0 es null");
         else
           traza("p0: " + p0.toString() );

         if ( p1 == null)
           traza("p1 es null");
         else
           traza("p1: " + p1.toString() );

         if ( p2 == null)
           traza("p2 es null");
         else
           traza("p2: " + p2.toString() );

         if ( p3 == null)
           traza("p3 es null");
         else
           traza("p3: " + p3.toString() );           

         if ( p4 == null)
           traza("p4 es null");
         else
           traza("p4: " + p4.toString() );   

         // **********************************************************
         //    Seteo Campos de la pestaña Tipo / Subtipo (pestaña 0)
         // **********************************************************

         // Tipo y Subtipo
         traza("***** Pestaña Tipo/Subtipo *****");
         traza("Tipo / Subtipo");
         
         String sListaTiposSubtipo = (String) p0.get("elementos");
         traza("---- sListaTiposSubtipo_" + sListaTiposSubtipo);
         if (sListaTiposSubtipo != null && !sListaTiposSubtipo.equals("") ){
            RecordSet rTipoSubtipo = this.parseaLista(sListaTiposSubtipo);
            traza("---- rTipoSubtipo_" + rTipoSubtipo);
            int cantRegistros = rTipoSubtipo.getRowCount();
            String sIndPpal = null;
            for (int i=0; i<cantRegistros; i++) {
                sIndPpal = (String) rTipoSubtipo.getValueAt(i,5);
                if ( sIndPpal != null && (sIndPpal.equals("S") || sIndPpal.equals("1")) ) {
                   rTipoSubtipo.setValueAt(new Long(1), i, 5);
                } else {
                   rTipoSubtipo.setValueAt(new Long(0), i, 5);
                }
            }
            traza("---- rTipoSubtipo con indPpal cambiado_" + rTipoSubtipo);
            dtoClienteBasico.setRTipoSubtipoCliente(rTipoSubtipo);  
         }

         /*DTOTipoSubtipoCliente[] dtoTipo = null;
         String sListaTiposSubtipo = (String) p0.get("elementos");
         dtoTipo = this.parseaListaTipoSubtipo(sListaTiposSubtipo);
         dtoClienteBasico.setTiposSubtipos(dtoTipo);*/

         //Preguntarle a SSantana
          dtoCliente.setOid(((DTOCliente) this.conectorParametroSesion("DTOCliente")).getOid());
          traza("En guardar() - oidCliente: "+dtoCliente.getOid());
         //

                  
         /* Preguntarle a SSantana
                  String oidCliente = (String)p0.get("hOidCliente");
                  traza("En guardar() - oidCliente: "+oidCliente);
         dtoCliente.setOid(new Long(oidCliente));
                  */

         // *************************************
         //    Seteo Campos de Pestaña 1 (DNI)
         // *************************************

         traza(" ******* Codigo Cliente *******");
         traza("Codigo de Cliente");

         String codCliente = null;
         //codCliente = (String) p0.get("codCliente");
         codCliente = (String) p1.get("codCliente");         
         traza("codCliente: " + codCliente);
         if ( codCliente == null || codCliente.equals("") ) 
             codCliente = "";
         dtoClienteBasico.setCodigoCliente(codCliente);

         traza("Digito Control");
         String digitoControl = null;
         digitoControl = (String) p1.get("hidDigitoControl");
         if ( digitoControl == null || digitoControl.equals("") )
             digitoControl = "";
         dtoClienteBasico.setDigitoControl(digitoControl);


         traza("Identificaciones");
         String sIdentificaciones = (String) p1.get("hidListaIdentificacion");

         if (sIdentificaciones == null || !sIdentificaciones.equals("") ) {
           RecordSet rIdentificaciones = this.parseaLista(sIdentificaciones);
           if (rIdentificaciones != null && !rIdentificaciones.esVacio()) {
             int cantRegistros = rIdentificaciones.getRowCount();
             
             for (int i=0; i<cantRegistros; i++) {
                String sIndPpal = (String) rIdentificaciones.getValueAt(i,4);  
                if (sIndPpal.equals("S")) {
                   rIdentificaciones.setValueAt(new Long(1), i, 4);
                } else {
                   rIdentificaciones.setValueAt(new Long(0), i, 4);
                }
             }
             dtoClienteBasico.setRIdentificacionCliente(rIdentificaciones);
           }
         }
         //dtoClienteBasico.setDigitoControl(digitoControl);         

         // ****************************
         //   Seteo campos de pestaña 2
         // ****************************
         
         // Apellido 1

         traza(" ***** Pestaña 2 ****** ");
         traza("Apellido 1");
         String sBuffer = (String) p2.get("textApellido1");
         if (sBuffer == null) { sBuffer = ""; }
         dtoClienteBasico.setApellido1(sBuffer);

         // Apellido 2
         traza("Apellido 2");         
         sBuffer = (String) p2.get("textApellido2");
         if (sBuffer == null) { sBuffer = ""; }
         dtoClienteBasico.setApellido2(sBuffer);

         // Nombre 1 
         traza("Nombre 1");         
         sBuffer = (String) p2.get("textNombre1");
         if (sBuffer == null) { sBuffer = ""; }
         dtoClienteBasico.setNombre1(sBuffer);         

         // Nombre 2
         traza("Nombre 2");                  
         sBuffer = (String) p2.get("textNombre2");
         if (sBuffer == null) { sBuffer = ""; }
         dtoClienteBasico.setNombre2(sBuffer);  

         // Apellido Casada 
         traza("Apellido Casada");                  
         sBuffer = (String) p2.get("textApellidoCasada");
         if (sBuffer == null) { sBuffer = ""; }
         dtoClienteBasico.setApellidoCasada(sBuffer);  

         // Tratamiento
         traza("Tratamiento");
         sBuffer = (String) p2.get("h_cbTratamiento");
         traza(" --- Tratamiento: " + sBuffer);
         if (sBuffer == null) { sBuffer = ""; }
         dtoClienteBasico.setTratamiento(sBuffer);  

         //Desc Tratamiento 
         traza("Desc Tratamiento");
         sBuffer = (String) p2.get("descTratamiento");
         traza("---------- descTratamiento: " + sBuffer);
         if (sBuffer == null) {sBuffer = "";}
         dtoClienteBasico.setTratamientoDesc(sBuffer);

         // Forma de Pago 
         traza("Forma Pago");
         sBuffer = (String) p2.get("h_cbFormaPago");
         if (sBuffer == null || sBuffer.equals("") ) 
           dtoClienteBasico.setFormaPago(null);      
         else
           dtoClienteBasico.setFormaPago( new Long(sBuffer) );      
           
         dtoCliente.setBase(dtoClienteBasico);
         
         // Lista Observaciones
         traza("Lista Observaciones");
         sBuffer = (String) p2.get("hidListaObservacionSal");
         if (sBuffer != null && !sBuffer.equals("") ) {
            RecordSet rObservaciones = this.parseaLista(sBuffer);
            dtoCliente.setRObservaciones(rObservaciones);
         }
         /* DTOObservacion[] dtoObserv = null;
         sBuffer = (String) p2.get("hidListaObservacionSal");
         if (sBuffer == null) { sBuffer =""; }
         dtoObserv = this.parseaObservaciones(sBuffer);
         dtoCliente.setObservaciones(dtoObserv); */

         // Lista Vinculos
         traza("Lista Vinculos");
         sBuffer =  (String) p2.get("hidListaVinculoSal");
         if (sBuffer != null && !sBuffer.equals("") ) {
            RecordSet rVinculos = this.parseaLista(sBuffer);
            if (rVinculos != null && !rVinculos.esVacio()) {
              int cantRegistros = rVinculos.getRowCount();
              String sOidVincu = (String) p3.get("listaVinculosOid");
              StringTokenizer tokVincuOid = new StringTokenizer(sOidVincu, ",");
              Vector vOidsVincu = new Vector();
              for (int i=0; i<cantRegistros; i++) {
                  String sFechaDesde = (String) rVinculos.getValueAt(i,3);
                  String sFechaHasta = (String) rVinculos.getValueAt(i,4);
                  String sIndPpal = (String) rVinculos.getValueAt(i,5);
                  
                  if (sFechaDesde != null && sFechaDesde.length() > 0) {
                     Date fechaDate = this.recuperaFecha(sFechaDesde, 
                                                              sFormatoFechaSesion);
                     rVinculos.setValueAt(fechaDate, i, 3);
                  } else {
                     rVinculos.setValueAt(null, i, 3);
                  }
                  
                  
                  if (sFechaHasta != null && sFechaHasta.length() > 0) {
                     Date fechaDate = this.recuperaFecha(sFechaHasta, 
                                                              sFormatoFechaSesion);
                     rVinculos.setValueAt(fechaDate, i, 4);
                  } else {
                     rVinculos.setValueAt(null, i, 4);
                  }
                  
                  if (sIndPpal.equals("S")){
                     rVinculos.setValueAt(new Long(1), i, 5);
                  } else {
                     rVinculos.setValueAt(new Long(0), i, 5);
                  }
                  
                  vOidsVincu.add(tokVincuOid.nextToken());
              }
              rVinculos.addColumn("AAA",vOidsVincu);
            }
            dtoCliente.setRVinculo(rVinculos);
         }
         
         /*DTOVinculo[] dtoVincu = null;
         sBuffer =  (String) p2.get("hidListaVinculoSal");
         String sOidVincu = (String) p3.get("listaVinculosOid");
         if (sBuffer == null) {sBuffer="";}
         dtoVincu = this.parseaVinculos(sBuffer, sOidVincu);
         dtoCliente.setVinculos(dtoVincu);*/

         // Lista Preferencias
         traza("Lista Preferencias");
         sBuffer = (String) p2.get("hidListaPrefeSal");
         if (sBuffer != null && !sBuffer.equals("") ) {
            RecordSet rPreferencia = this.parseaLista(sBuffer);
            dtoCliente.setRPreferencia(rPreferencia);
         }
         
         /*DTOPreferencia[] dtoPref = null;
         sBuffer = (String) p2.get("hidListaPrefeSal");
         if (sBuffer == null) {sBuffer="";}
         dtoPref = this.parseaPref(sBuffer);
         dtoCliente.setPreferencias(dtoPref);*/
         

         // Fecha Nacimiento
         traza("Fecha Nacimiento");
         sBuffer = (String) p2.get("textFechaNacimiento");
         java.sql.Date fechaNacimiento = null;
         if ( sBuffer == null || sBuffer.equals("") ) 
           sBuffer=null;
         else
         {
           java.util.Date fechaBuffer = null;

           String formatoFechaSesion = UtilidadesSession.getFormatoFecha(this);
           formatoFechaSesion = formatoFechaSesion.replace('m', 'M');
           
           SimpleDateFormat simpleDate = new SimpleDateFormat(formatoFechaSesion);
           fechaBuffer = simpleDate.parse(sBuffer);
           fechaNacimiento = new java.sql.Date( fechaBuffer.getTime() );
         }

         if (fechaNacimiento != null)
           traza("Fecha a Setear: " + fechaNacimiento.toString() );
         else
           traza("Fecha es null");
         dtoCliente.setFechaNacimiento(fechaNacimiento);

         // Codigo Empleado
         traza("Codigo Empleado");
         sBuffer = (String) p2.get("textCodEmpleado");
         if (sBuffer == null) { sBuffer = ""; }
         dtoCliente.setCodigoEmpleado(sBuffer);  

         // Nacionalidad
         traza("Nacionalidad");
         sBuffer = (String) p2.get("h_cbNacionalidad");
         traza(" --- Nacionalidad: " + sBuffer);
         Long nacionalidad = null;
         if ( sBuffer != null && !sBuffer.equals("") )
             nacionalidad = new Long(sBuffer);
         dtoCliente.setNacionalidad(nacionalidad);  

         // Edad
         traza("Edad");
         // TODO: Setear codigo en P2 que guarde la edad en hidEdad.
         //sBuffer = (String) p2.get()

         // Estado Civil
         traza("Estado Civil");
         sBuffer = (String) p2.get("h_cbEstadoCivil");
         Long estadoCivil = null;
         if ( sBuffer != null && !sBuffer.equals("") )
           estadoCivil = new Long(sBuffer);
         dtoCliente.setEstadoCivil(estadoCivil);

         // Ocupacion
         traza("Ocupacion");
         sBuffer = (String) p2.get("textOcupacion");
         if (sBuffer == null) { sBuffer = ""; }
         dtoCliente.setOcupacion(sBuffer);

         // Profesion
         traza("Profesion");
         sBuffer = (String) p2.get("textProfesion");
         if (sBuffer == null) { sBuffer = ""; }
         dtoCliente.setProfesion(sBuffer);
      
         // Centro de Trabajo
         traza("Centro de Trabajo ");
         sBuffer = (String) p2.get("textCentroTrabajo");
         if (sBuffer == null) { sBuffer = ""; }
         dtoCliente.setCentroTrabajo(sBuffer);

         // Cargo
         traza("Cargo");
         sBuffer = (String) p2.get("textCargoDesempena");
         if (sBuffer == null) { sBuffer = ""; }
         dtoCliente.setCargo(sBuffer);

         // nivelEstudios
         traza("Nivel de Estudios");
         sBuffer = (String) p2.get("h_cbNivelEstudios");
         Long nivelEstudios = null;
         if (sBuffer != null && !sBuffer.equals("") )
           nivelEstudios = new Long(sBuffer);
         dtoCliente.setNivelEstudios(nivelEstudios);

         // centroEstudios
         traza("Centro de Estudios");
         sBuffer = (String) p2.get("textCentroEstudios");
         if (sBuffer == null) {sBuffer = "";}
         dtoCliente.setCentroEstudios(sBuffer);

         // numeroHijos
         traza("Numero de Hijos");
         sBuffer = (String) p2.get("textNHijos");
         Byte nHijos = null;      
         if (sBuffer != null && !sBuffer.equals("") ) 
           nHijos = new Byte(sBuffer);
         dtoCliente.setNumeroHijos(nHijos);

         // personasDependientes
         traza("Numero de Personas Dependientes");
         sBuffer = (String) p2.get("textNPersonasDependientes");
         Byte nPersonasDepend = null;
         if (sBuffer != null && !sBuffer.equals("") ) 
           nPersonasDepend = new Byte(sBuffer);
         dtoCliente.setPersonasDependientes(nPersonasDepend);
 
         // NSEP
         traza("Nivel Socieconomico");
         sBuffer = (String) p2.get("h_cbNivelSocioEconomico");
         Long NSEP = null;
         if (sBuffer != null && !sBuffer.equals("") ) 
           NSEP = new Long(sBuffer);
         dtoCliente.setNSEP(NSEP);      
      
         // cicloVida
         traza("Ciclo de Vida Familiar");
         sBuffer = (String) p2.get("h_cbCicloVidaFamiliar");
         Long cicloVida = null;
         if (sBuffer != null && !sBuffer.equals("") ) 
           cicloVida = new Long(sBuffer);
         dtoCliente.setCicloVida(cicloVida);
      
         // deseaCorrespondencia
         traza("Desea correspondencia");
         sBuffer = (String) p2.get("rbDeseaCorrespondencia");
         Boolean correspondencia = new Boolean(false);
         if (sBuffer.equals("S")) 
           correspondencia = new Boolean(true);
         dtoCliente.setDeseaCorrespondencia(correspondencia);
      

         // importeIngresos
         traza("Ingreso Familiar");
         sBuffer = (String) p2.get("textImporteIngresoFamiliar");
         Double ingresos = null;
         if (sBuffer != null && !sBuffer.equals("") ) 
           ingresos = new Double(sBuffer);
         dtoCliente.setImporteIngresos(ingresos);

         boolean hayContacto = true;

         sBuffer = (String) p2.get("textCodClienteContactado");
         traza("Cliente contactado: " + sBuffer );         
         if (sBuffer == null || sBuffer.equals("") )
         {
           traza("No hay contacto");
           hayContacto = false;
         }
         if (hayContacto)           
           dtoCliente.setClienteContactado(sBuffer);         
         else
           dtoCliente.setClienteContactado(null);         

         sBuffer = (String) p2.get("h_cbTipoClienteContactado");
         traza(" --- Tipo de Cliente Contactado: " + sBuffer);
         if ( hayContacto )  // Si hay cliente Contacto, entonces si o si hay tipo de Cliente contactado.
            dtoCliente.setTipoClienteContactado(new Long(sBuffer));
         else
           dtoCliente.setTipoClienteContactado(null);

         traza("Fecha Primer Pedido Contactado");
         sBuffer = (String) p2.get("textFecha1PedidoContacto");
         java.sql.Date fechaPrimerPedido = null;
         if (sBuffer != null && !sBuffer.equals("") ) 
         {
           String formatoFechaSesion = UtilidadesSession.getFormatoFecha(this);
           formatoFechaSesion = formatoFechaSesion.replace('m', 'M');
         
           SimpleDateFormat simpleDate = new SimpleDateFormat(formatoFechaSesion);
           java.util.Date fechaBuffer = simpleDate.parse(sBuffer);
           fechaPrimerPedido = new java.sql.Date(fechaBuffer.getTime());
         }
         if (fechaPrimerPedido != null && hayContacto)
           traza("Fecha Primer Pedido: " + fechaPrimerPedido.toString() );
         else 
           traza("Fecha Primer Pedido es null ");
           
        //dtoCliente.setFechaPrimerPedidoContactado(fechaPrimerPedido);


         traza("Fecha Contacto");
         sBuffer = (String) p2.get("textFechaContacto");
         java.sql.Date fechaContacto = null;
         if (sBuffer != null && !sBuffer.equals("") ) 
         {
           String formatoFechaSesion = UtilidadesSession.getFormatoFecha(this);
           formatoFechaSesion = formatoFechaSesion.replace('m', 'M');
           
           SimpleDateFormat simpleDate = new SimpleDateFormat(formatoFechaSesion);           
           java.util.Date fechaBuffer = simpleDate.parse(sBuffer);
           fechaContacto = new java.sql.Date(fechaBuffer.getTime());
         }
         if (fechaContacto != null && hayContacto)
           traza("Fecha Contacto: " + fechaContacto.toString() );
         else 
           traza("Fecha Contacto es null ");
         //dtoCliente.setFechaSiguienteContacto(fechaContacto);
         dtoCliente.setFechaPrimerContacto(fechaContacto);

         traza("Fecha Siguiente Contacto");
         sBuffer = (String) p2.get("textFechaSiguienteContacto");
         java.sql.Date fechaSigContacto = null;
         if (sBuffer != null && !sBuffer.equals("") ) 
         {
           String formatoFechaSesion = UtilidadesSession.getFormatoFecha(this);
           formatoFechaSesion = formatoFechaSesion.replace('m', 'M');
         
           SimpleDateFormat simpleDate = new SimpleDateFormat(formatoFechaSesion);
           java.util.Date fechaBuffer = simpleDate.parse(sBuffer);
           fechaSigContacto = new java.sql.Date(fechaBuffer.getTime());
         }
         if (fechaSigContacto != null && hayContacto)
           traza("Fecha Siguiente Contacto: " + fechaSigContacto.toString() );
         else 
           traza("Fecha Siguiente Contacto es null ");
         dtoCliente.setFechaSiguienteContacto(fechaSigContacto);

         traza("Codigo de Tipo Contacto (Inbound/ OutBound)");
         sBuffer = (String) p2.get("hidcbCodTipoContactado");
         if (sBuffer != null && hayContacto)
           dtoCliente.setTipoContacto(sBuffer);
         else
           dtoCliente.setTipoContacto(null);

         sBuffer = (String) p2.get("hidMarcaContacto");     
         traza("----- Marca Contacto: " + sBuffer);         
         Long marcaContacto = null;
         if (sBuffer != null && !sBuffer.equals("") && hayContacto )
         {
           traza("Setea marcaContacto");
           marcaContacto = new Long(sBuffer);
         }
         dtoCliente.setMarcaContacto(marcaContacto);

         sBuffer = (String) p2.get("hidCanalContacto");     
         traza("----- Canal Contacto: " + sBuffer);
         Long canalContacto = null;
         if (sBuffer != null && !sBuffer.equals("") && hayContacto )
         {
           traza("Setea canalContacto");
           canalContacto = new Long(sBuffer);
         }
         dtoCliente.setCanalContacto(canalContacto);
         
         sBuffer = (String) p2.get("hidPeriodoContacto");     
         traza("----- Periodo Contacto: " + sBuffer);           
         Long periodoContacto = null;
         if (sBuffer != null && !sBuffer.equals("") && hayContacto )
         {
           traza("Setea periodoContacto");
           periodoContacto = new Long(sBuffer);
         }
         dtoCliente.setPeriodoContacto(periodoContacto);

         traza("Sexo");
         sBuffer = (String) p2.get("rbSexo");
         traza(" ----- Sexo: " + sBuffer);
         if ( sBuffer.equals("S"))
           dtoClienteBasico.setSexo("M");
         else
           dtoClienteBasico.setSexo("F");
         

         traza("Fecha de Ingreso");
         sBuffer = (String) p2.get("hidFechaIngreso");
         java.sql.Date fechaIngreso = null;
         if (sBuffer != null && !sBuffer.equals("") ) 
         {
           String formatoFechaSesion = UtilidadesSession.getFormatoFecha(this);
           formatoFechaSesion = formatoFechaSesion.replace('m', 'M');

           SimpleDateFormat simpleDate = new SimpleDateFormat(formatoFechaSesion);
           java.util.Date fechaBuffer = simpleDate.parse(sBuffer);
           fechaIngreso = new java.sql.Date(fechaBuffer.getTime());
         }
         if (fechaIngreso != null)
           traza("Fecha Ingreso: " + fechaIngreso.toString() );
         else 
           traza("Fecha Ingreso es null ");

           dtoClienteBasico.setFechaIngreso(fechaIngreso);



         
         
         
         
         // **********************************
         //     Seteo Campos de la Pestaña 3
         // **********************************
         
         traza("*********** Campos de la pestaña 3 ************");

         traza("Oid Cliente Contactado");
         sBuffer = (String) p3.get("hidOidClienteCont");
         if (sBuffer != null && !sBuffer.equals("") && hayContacto)
           dtoCliente.setOidClienteContactado(new Long(sBuffer) );
         else
           dtoCliente.setOidClienteContactado(null );         
         traza("dtoCliente hasta ahora: " + dtoCliente);

         traza("ListaComunicacion");
         /*DTOComunicacion[] dtoComm = null;*/
         sBuffer =  (String) p3.get("hidListaComunicacion");
         if (sBuffer != null && sBuffer.length() > 0) {
            RecordSet rComunicaciones = this.parseaLista(sBuffer);
            if (rComunicaciones != null && !rComunicaciones.esVacio()) {
                traza("rComunicaciones: " + rComunicaciones);
                int cantRegistros = rComunicaciones.getRowCount();
                String sIndPpal = null;
                String sIntervalo = null;
                String si = "S";
                for (int i=0; i<cantRegistros; i++) {
                   sIndPpal = (String) rComunicaciones.getValueAt(i,4);
                   sIntervalo = (String) rComunicaciones.getValueAt(i,7);                   
                   if (sIndPpal.equals(si)) {
                      rComunicaciones.setValueAt(new Long(1), i, 4);
                   } else {
                      rComunicaciones.setValueAt(new Long(0), i, 4);
                   }
                   
                   if (!sIntervalo.equals("")) {
                      if (sIntervalo.equals("true")) {
                         rComunicaciones.setValueAt("1", i, 7);
                      } else {
                         rComunicaciones.setValueAt("0", i, 7);
                      }
                   } 
                }
             }
             dtoCliente.setRComunicaciones(rComunicaciones);             
          }
         
        /* if (sBuffer == null) {sBuffer="";}
         dtoComm = this.parseaComunicacion(sBuffer);
         dtoCliente.setComunicaciones(dtoComm);         */
         
         
         traza("Lista Direcciones");
         DTODireccion[] dtoDireccion = null;
         sBuffer =  (String) p3.get("hidListaDirecciones");
         if (sBuffer == null) {sBuffer="";}
         dtoDireccion = this.parseaDireccion(sBuffer);
         dtoClienteBasico.setDirecciones(dtoDireccion);

         traza("Marcas");
         DTOClienteMarca[] dtoMarcas = null;
         sBuffer = (String) p3.get("hidListaMarca");
         if (sBuffer == null) {sBuffer="";}
         dtoMarcas = this.parseaMarcas(sBuffer);
         dtoClienteBasico.setMarcas(dtoMarcas);

         traza("usaGeoreferenciador");
         sBuffer = (String) p3.get("usaGeoreferenciador");
         traza("usaGeorefenciador: " + sBuffer);
         dtoClienteBasico.setUsaGeoreferenciador(new Boolean(sBuffer));
         
         // *********************************
         //   Seteo Campos de la pestaña 4
         // *********************************

         traza("******* Pestaña 4 *******");
         traza("----- Lista Tarjetas");
         DTOTarjeta[] dtoTarjeta = null;
         sBuffer = (String) p4.get("hidListaTarjetas");
         if (sBuffer == null) {sBuffer="";}
         dtoTarjeta = this.parseaTarjetas(sBuffer);
         dtoCliente.setTarjetas(dtoTarjeta);

         traza("----- Lista Clasificaciones");
         DTOClasificacionCliente[] dtoClasi = null;
         sBuffer = (String) p4.get("hidListaClasificacion");
         if (sBuffer == null) {sBuffer="";}
         dtoClasi = this.parseaClasificaciones(sBuffer);
         dtoClienteBasico.setClasificaciones(dtoClasi);

         traza("----- Lista Psicografias");
         DTOPsicografia[] dtoPsico = null;
         sBuffer = (String) p4.get("hidListaPsico");
         if (sBuffer == null) {sBuffer="";}
         dtoPsico = this.parseaPsicografias(sBuffer);
         dtoCliente.setPsicografias(dtoPsico);

         traza("----- Lista Problema Solucion");
         DTOProblemaSolucion[] dtoProble = null;
         sBuffer = (String) p4.get("hidListaProbSolu");
         if (sBuffer == null) {sBuffer="";}
         dtoProble = this.parseaProblema(sBuffer);
         dtoCliente.setProblemasSoluciones(dtoProble);

         DTOModificarCliente dtoModificar = new DTOModificarCliente();
         /*String tiposToDel = (String) p0.get("elemToDel");
         Long[] tiposToDelete = null;
         if (tiposToDel != null && !tiposToDel.equals(""))
         {
           ArrayList aList = new ArrayList();
           StringTokenizer tok = new StringTokenizer(tiposToDel,",");
           while (tok.hasMoreTokens())
             aList.add( new Long( tok.nextToken() ) );

           tiposToDelete = new Long[aList.size()];
           for (int i = 0; i < aList.size(); i++)
             tiposToDelete[i] = (Long) aList.get(i);
         }*/

         // ************** Elementos Quitados ******************

         // Tipos quitados
         traza("Tipos quitados");
         String tipoToDel = (String) p0.get("elemToDel");
         traza("********los tipos a eliminar " + tipoToDel);
         Long[] tipoToDelete = null;

         if (tipoToDel != null && !tipoToDel.equals(""))
         {
           ArrayList aList = new ArrayList();
           StringTokenizer tok = new StringTokenizer(tipoToDel,",");
           while (tok.hasMoreTokens())
             aList.add( new Long( tok.nextToken() ) );

           tipoToDelete = new Long[aList.size()];
           for (int i = 0; i < aList.size(); i++)
             tipoToDelete[i] = (Long) aList.get(i);
         }        
                  
         dtoModificar.setTiposQuitados(tipoToDelete);
         
         // DNIs Quitados
         traza("DNIs Quitados");
		 // vbongiov --  SiCC 20090865 -- 26/03/2009
         String dniToDel = (String) p1.get("elemToDelP2");
         traza("DNIToDel: " + dniToDel);
         Long[] dniToDelete = null;
         if (dniToDel != null && !dniToDel.equals(""))
         {
           ArrayList aList = new ArrayList();
           StringTokenizer tok = new StringTokenizer(dniToDel,",");
           while (tok.hasMoreTokens())
             aList.add( new Long( tok.nextToken() ) );

           dniToDelete = new Long[aList.size()];
           for (int i = 0; i < aList.size(); i++)
             dniToDelete[i] = (Long) aList.get(i);
         }        
         dtoModificar.setIdentificacionesQuitadas(dniToDelete);
         
         // Vinculos
         traza("vinculos Quitados");         
        String vincuToDel = (String) p2.get("elementosEliminadosVincu");
         traza("VincuToDel: " + vincuToDel);        
        Long[] vincuToDelete = null;
         if (vincuToDel != null && !vincuToDel.equals(""))
         {
           ArrayList aList = new ArrayList();
           StringTokenizer tok = new StringTokenizer(vincuToDel,",");
           while (tok.hasMoreTokens())
             aList.add( new Long( tok.nextToken() ) );

           vincuToDelete = new Long[aList.size()];
           for (int i = 0; i < aList.size(); i++)
             vincuToDelete[i] = (Long) aList.get(i);
         }        
         dtoModificar.setVinculosQuitados(vincuToDelete);
         
         // Observaciones
         traza("Observaciones Quitados");                  
        String obsToDel = (String) p2.get("elementosEliminadosObser");
         traza("ObsToDel: " + obsToDel);
        Long[] obsToDelete = null;
         if (obsToDel != null && !obsToDel.equals(""))
         {
           ArrayList aList = new ArrayList();
           StringTokenizer tok = new StringTokenizer(obsToDel,",");
           while (tok.hasMoreTokens())
             aList.add( new Long( tok.nextToken() ) );

           obsToDelete = new Long[aList.size()];
           for (int i = 0; i < aList.size(); i++)
             obsToDelete[i] = (Long) aList.get(i);
         }        
         dtoModificar.setObservacionesQuitadas(obsToDelete);

        // Preferencias
         traza("Preferencias Quitados");                          
        String prefToDel = (String) p2.get("elementosEliminadosPrefe");
        traza("prefToDel: " + prefToDel);
        
        Long[] prefToDelete = null;
        // splatas - 11/10/2006
        if( prefToDel != null && !prefToDel.equals("") ){
           traza(" - SAP601: entró al IF ");
             
           ArrayList aList = new ArrayList();
           StringTokenizer tok = new StringTokenizer(prefToDel,",");
           traza(" - SAP601: tok = " + tok);
           
           while (tok.hasMoreTokens()){
             aList.add( new Long( tok.nextToken() ) );
           }
           
           traza(" - SAP601: aList.size() = " + aList.size());  
           prefToDelete = new Long[aList.size()];
           for (int i = 0; i < aList.size(); i++)
             prefToDelete[i] = (Long) aList.get(i);
         }        
         traza(" - SAP601: setPreferenciasQuitadas = " + prefToDelete);
         dtoModificar.setPreferenciasQuitadas(prefToDelete);

         // Direcciones
         traza("Direcciones Quitados");                                   
        String dirToDel = (String) p3.get("elemToDelDir");
        traza("dirToDel: " + dirToDel);
        Long[] dirToDelete = null;
         if (dirToDel != null && !dirToDel.equals(""))
         {
           ArrayList aList = new ArrayList();
           StringTokenizer tok = new StringTokenizer(dirToDel,",");
           while (tok.hasMoreTokens())
             aList.add( new Long( tok.nextToken() ) );

           dirToDelete = new Long[aList.size()];
           for (int i = 0; i < aList.size(); i++)
             dirToDelete[i] = (Long) aList.get(i);
         }        
         dtoModificar.setDireccionesQuitadas(dirToDelete);

        // Comunicaciones
         traza("Comunicaciones Quitados");                                           
        String comToDel = (String) p3.get("elemToDelComm");
        traza("comToDel: " + comToDel);        
        Long[] comToDelete = null;
         if (comToDel != null && !comToDel.equals(""))
         {
           ArrayList aList = new ArrayList();
           StringTokenizer tok = new StringTokenizer(comToDel,",");
           while (tok.hasMoreTokens())
             aList.add( new Long( tok.nextToken() ) );

           comToDelete = new Long[aList.size()];
           for (int i = 0; i < aList.size(); i++)
             comToDelete[i] = (Long) aList.get(i);
         }        
         dtoModificar.setComunicacionesQuitadas(comToDelete);

        // Marcas
         traza("Marcas Quitados");                                                   
        String marcasToDel = (String) p3.get("elemToDelMarcas");
        traza("marcasToDel: " + marcasToDel);
        Long[] marcasToDelete = null;
         if (marcasToDel != null && !marcasToDel.equals(""))
         {
           ArrayList aList = new ArrayList();
           StringTokenizer tok = new StringTokenizer(marcasToDel,",");
           while (tok.hasMoreTokens())
             aList.add( new Long( tok.nextToken() ) );

           marcasToDelete = new Long[aList.size()];
           for (int i = 0; i < aList.size(); i++)
             marcasToDelete[i] = (Long) aList.get(i);
         }        
         dtoModificar.setMarcasQuitadas(marcasToDelete);

         // Tarjetas
         traza("Tarjetas Quitados");                                                    
        String tarjetasToDel = (String) p4.get("elemEliminadosTarjetas");
        traza("TarjetasToDel: " + tarjetasToDel);
        Long[] tarjetasToDelete = null;
         if (tarjetasToDel != null && !tarjetasToDel.equals(""))
         {
           ArrayList aList = new ArrayList();
           StringTokenizer tok = new StringTokenizer(tarjetasToDel,",");
           while (tok.hasMoreTokens())
             aList.add( new Long( tok.nextToken() ) );

           tarjetasToDelete = new Long[aList.size()];
           for (int i = 0; i < aList.size(); i++)
             tarjetasToDelete[i] = (Long) aList.get(i);
         }        
         dtoModificar.setTarjetasQuitadas(tarjetasToDelete);

        // Clasificacion
         traza("Clasificacion Quitados");                                                            
        String clasiToDel = (String) p4.get("elemEliminadosClasificacion");
        traza("ClasiToDel: " + clasiToDel);
        Long[] clasiToDelete = null;
         if (clasiToDel != null && !clasiToDel.equals(""))
         {
           ArrayList aList = new ArrayList();
           StringTokenizer tok = new StringTokenizer(clasiToDel,",");
           while (tok.hasMoreTokens())
             aList.add( new Long( tok.nextToken() ) );

           clasiToDelete = new Long[aList.size()];
           for (int i = 0; i < aList.size(); i++)
             clasiToDelete[i] = (Long) aList.get(i);
         }        
         dtoModificar.setClasificacionesQuitadas(clasiToDelete);

        // Problema
         traza("Problemas Quitados");                                                                    
        String probToDel = (String) p4.get("elemEliminadosProblema");
        traza("probToDel: " + probToDel);
        Long[] probToDelete = null;
        Long[] solToDelete = null;
        if (probToDel != null && !probToDel.equals(""))
        {
           ArrayList aListP = new ArrayList();
           ArrayList aListS = new ArrayList();
           StringTokenizer tok = new StringTokenizer(probToDel,",");
           while (tok.hasMoreTokens())
           {
                  String oidToDel = tok.nextToken();
                  String prefijo = oidToDel.substring(0, 1);
                  traza("prefijo: " + prefijo);
                  if ( prefijo.equals("S") ) // Solucion
                  {
                      String codigo = oidToDel.substring(1, oidToDel.length());
                      traza("Codigo Solucion a borrar: " + codigo);
                      aListS.add( new Long(codigo) );
                  }
                  else   // Problema 
                  {
                      String codigo = oidToDel.substring(1, oidToDel.length());
                      traza("Codigo Problema a borrar: " + codigo);
                      aListP.add( new Long(codigo) );
                  }
                  
            }
          probToDelete = new Long[aListP.size()];
          solToDelete = new Long[aListS.size()];

          for (int i = 0; i < aListP.size(); i++)
           probToDelete[i] = (Long) aListP.get(i);
         
          for (int j = 0; j < aListS.size(); j++)
           solToDelete[j] = (Long) aListS.get(j);
        }
        dtoModificar.setProblemasQuitados(probToDelete);
        //dtoModificar.setSolucionesQuitadas(solToDelete);
            
             

         // PsicoGrafia
         traza("Psicografia Quitados");                                                                            
         String psicoToDel = (String) p4.get("elemEliminadosPsico");
         traza("psicoToDel: " + psicoToDel);
         Long[] psicoToDelete = null;
         if (psicoToDel != null && !psicoToDel.equals("")) {
             ArrayList aList = new ArrayList();
             StringTokenizer tok = new StringTokenizer(psicoToDel,",");
             while (tok.hasMoreTokens())
                aList.add( new Long( tok.nextToken() ) );
  
             psicoToDelete = new Long[aList.size()];
             for (int i = 0; i < aList.size(); i++)
                psicoToDelete[i] = (Long) aList.get(i);
         }        
         dtoModificar.setPsicografiasQuitadas(psicoToDelete);
         dtoClienteBasico.setOidIdioma(UtilidadesSession.getIdioma(this));
         dtoClienteBasico.setOidPais(UtilidadesSession.getPais(this));

         dtoCliente.setBase(dtoClienteBasico);
         traza("Cliente basico: " + dtoClienteBasico);
         dtoModificar.setDatosCliente(dtoCliente);

         dtoModificar.setPrograma("LPModificarCliente");
         dtoModificar.setIpCliente(UtilidadesBelcorp.getIPCliente(this));

                  /* inicio Modificado incidencia DBLG700000052 */
                  DTOPremioRecomendacion dtoPremioR = (DTOPremioRecomendacion) 
                                    this.obtenerDatosSalida("MAEModificarCliente", 
                                                                                  "ConectorObjetoGenerico", 
                                                                                  (DTOModificarCliente)dtoModificar);

         traza("DTOPREMIO " + dtoPremioR);

                   asignarAtributo("VAR","ejecutar","valor","retorna(" + 
                                             dtoPremioR.getClienteRecomendado() + "," +
                                             dtoPremioR.getClienteRecomendante() +  ",'" +
                                    dtoPremioR.getProblemasEstatus() +
                            "');");

                  /* fin Modificado incidencia DBLG700000052 */


         //ConectorInsertarCliente         

  }

  private DTOObservacion[] parseaObservaciones(String cadenaLista) throws Exception
  {
      traza("Parseando Lista Observacion...");
      DTOObservacion[] dtoObserv = null;
      DTOObservacion dtoBuffer = null;
      ArrayList aLista = new ArrayList();
      StringTokenizer tokElems = null;
      StringTokenizer tokLinea = null;
      StringTokenizer tokUnidad=null;
      StringTokenizer tokNombre=null;

      if (!cadenaLista.equals("") )
      {
           tokLinea = new StringTokenizer(cadenaLista, "|");
           // tomo la cadena y la parseo en Lineas.
           while ( tokLinea.hasMoreTokens() )
           {
                String linea = tokLinea.nextToken();
                tokElems = new StringTokenizer(linea, ";");
                // Tomo la linea y la parseo en los elementos.
                int counter = 0;
                dtoBuffer = new DTOObservacion();                
                while ( tokElems.hasMoreElements() )
                {
                  // Tomo el elemento.
                  String unidadActual = tokElems.nextToken(); 
                  // Lo parseo en dos partes: nombre y valor:
                  tokUnidad = new StringTokenizer(unidadActual, "=");
                  String valor = tokUnidad.nextToken();
                  valor = tokUnidad.nextToken();

                  switch (counter)
                  {
                    case 0: // oid
                      if ( valor.equals("g") ) 
                      {
                           // Seteo el oid a null.
                           dtoBuffer.setOid(null);
                      } else
                         dtoBuffer.setOid(new Long(valor));
                      break;
                    case 1: // marca
                      dtoBuffer.setMarca(new Long(valor));
                      break;

                    case 2: // nroObservacion
                      dtoBuffer.setNumero(new Integer(valor));
                      break;

                    case 3: // textoObservacion
                      dtoBuffer.setTexto(valor);
                  }
                  
                  counter++;
                  if (counter == 4) 
                    counter = 0;
                  
                }
                aLista.add(dtoBuffer);
                traza("DTOObservacion generado: " + dtoBuffer);
           }
         
      }
      if (aLista.size() > 0)
      {
         dtoObserv = new DTOObservacion[aLista.size()];
         for (int i = 0; i < aLista.size(); i++)
           dtoObserv[i] = (DTOObservacion) aLista.get(i);
      }
      //dtoObserv = (DTOObservacion[]) aLista.toArray();
      traza("Retorna dtoObserv");

      return dtoObserv;
        
  }

  private DTOVinculo[] parseaVinculos(String cadenaLista, String sVincuOid) throws Exception
  {   // 
      traza("Parseando Lista Vinculos...");
      DTOVinculo[] dtoVincu = null;
      DTOVinculo dtoBuffer = null;
      ArrayList aLista = new ArrayList();
      StringTokenizer tokElems = null;
      StringTokenizer tokLinea = null;
      StringTokenizer tokUnidad=null;
      StringTokenizer tokNombre=null;
      StringTokenizer tokVincuOid=null;   
      Long paisSesion = UtilidadesSession.getPais(this);
      
      //String sListaVincuOid = (String) p2.get("listaVinculosOid");

      if ( !sVincuOid.equals("") )
      {
             traza("sVincuOid: " + sVincuOid);
             tokVincuOid = new StringTokenizer(sVincuOid, ",");  

             if (!cadenaLista.equals("") )
             {
                  tokLinea = new StringTokenizer(cadenaLista, "|");
                  // tomo la cadena y la parseo en Lineas.
                  while ( tokLinea.hasMoreTokens() )
                  {
                      String linea = tokLinea.nextToken();
                      tokElems = new StringTokenizer(linea, ";");
                      // Tomo la linea y la parseo en los elementos.
                      int counter = 0;
                      dtoBuffer = new DTOVinculo();                
                      while ( tokElems.hasMoreElements() )
                      {
                         // Tomo el elemento.
                         String unidadActual = tokElems.nextToken(); 
                         // Lo parseo en dos partes: nombre y valor:
                         tokUnidad = new StringTokenizer(unidadActual, "=");
                         String valor = tokUnidad.nextToken();
                         valor = tokUnidad.nextToken();

                         switch (counter)
                         {
                           case 0: // oid
                             if ( valor.equals("g") ) 
                             {
                                  // Seteo el oid a null.
                                  dtoBuffer.setOid(null);
                             } else
                                dtoBuffer.setOid(new Long(valor));
                             break;
                           case 1: // Cliente vinculo
                             dtoBuffer.setCodigoCliente(valor);
                             break;

                           case 2: // Tipo vinculo
                             dtoBuffer.setTipo(new Long(valor));
                             break;

                           case 3: // FechaDesde
                             String formatoFechaSesion = UtilidadesSession.getFormatoFecha(this);
                             formatoFechaSesion = formatoFechaSesion.replace('m', 'M');
                           
                             SimpleDateFormat dateFormat = new SimpleDateFormat(formatoFechaSesion);
                             Date fechaDesde = dateFormat.parse(valor);
                             java.sql.Date fechaSQL = new java.sql.Date(fechaDesde.getTime() );
                      
                             dtoBuffer.setFechaDesde(fechaSQL);
                             break;

                           case 4: // FechaHasta
                             formatoFechaSesion = UtilidadesSession.getFormatoFecha(this);
                             formatoFechaSesion = formatoFechaSesion.replace('m', 'M');
                           
                             dateFormat = new SimpleDateFormat(formatoFechaSesion);
                             Date fechaHasta = dateFormat.parse(valor);
                             fechaSQL = new java.sql.Date(fechaHasta.getTime() );
                             dtoBuffer.setFechaHasta(fechaSQL);
                             break;
                      
                           case 5: // Vinculo Principal
                             boolean ppal = false;
                             if ( valor.equals("N") )
                                ppal=false;
                             else
                                ppal=true;

                             dtoBuffer.setPrincipal(new Boolean(ppal));
                            //dtoBuffer.setPrincipal();
                         }

                         counter++;
                         if (counter == 6) 
                           counter = 0;
                  
                      }
                      dtoBuffer.setOidCliente( new Long( tokVincuOid.nextToken() ));
                      dtoBuffer.setPais(paisSesion);                
                      aLista.add(dtoBuffer);
                      traza("DTOVinculo generado: " + dtoBuffer);
                  }
         
             }
             if (aLista.size() > 0)
             {
                dtoVincu = new DTOVinculo[aLista.size()];
                for (int i = 0; i < aLista.size(); i++)
                  dtoVincu[i] = (DTOVinculo) aLista.get(i);
             }
      }
      
      //dtoVincu = (DTOVinculo[]) aLista.toArray();

      return dtoVincu;
        
  }  
  
  private DTOPreferencia[] parseaPref(String cadenaLista) throws Exception
  {
      traza("Parseando Lista Preferencias...");
      DTOPreferencia[] dtoPref = null;
      DTOPreferencia dtoBuffer = null;
      ArrayList aLista = new ArrayList();
      StringTokenizer tokElems = null;
      StringTokenizer tokLinea = null;
      StringTokenizer tokUnidad=null;
      StringTokenizer tokNombre=null;

      if (!cadenaLista.equals("") )
      {
           tokLinea = new StringTokenizer(cadenaLista, "|");
           // tomo la cadena y la parseo en Lineas.
           while ( tokLinea.hasMoreTokens() )
           {
                String linea = tokLinea.nextToken();
                tokElems = new StringTokenizer(linea, ";");
                // Tomo la linea y la parseo en los elementos.
                int counter = 0;
                dtoBuffer = new DTOPreferencia();                
                while ( tokElems.hasMoreElements() )
                {
                  // Tomo el elemento.
                  String unidadActual = tokElems.nextToken(); 
                  // Lo parseo en dos partes: nombre y valor:
                  tokUnidad = new StringTokenizer(unidadActual, "=");
                  String valor = tokUnidad.nextToken();
                  valor = tokUnidad.nextToken();

                  switch (counter)
                  {
                    case 0: // oid
                      if ( valor.equals("g") ) 
                      {
                           // Seteo el oid a null.
                           dtoBuffer.setOid(null);
                      } else
                         dtoBuffer.setOid(new Long(valor));
                      break;
                    case 1: // Tipo Pref.
                      dtoBuffer.setTipo( new Long(valor) );
                      break;

                    case 2: // Descripcion
                      dtoBuffer.setDescripcion(valor);
                      break;

                  }
                  
                  counter++;
                  if (counter == 3) 
                    counter = 0;
                  
                }
                aLista.add(dtoBuffer);
                traza("DTOPreferencia generado: " + dtoBuffer);
           }
         
      }
      if (aLista.size() > 0)
      {
         dtoPref = new DTOPreferencia[aLista.size()];
         for (int i = 0; i < aLista.size(); i++)
           dtoPref[i] = (DTOPreferencia) aLista.get(i);
      }
      
      //dtoVincu = (DTOVinculo[]) aLista.toArray();

      return dtoPref;
        
  }  


  private DTOTipoSubtipoCliente[] parseaListaTipoSubtipo(String tipoSubTipo) throws Exception
  {
      DTOTipoSubtipoCliente[] dtoTipo = null;
      ArrayList aList = new ArrayList();
      DTOTipoSubtipoCliente dtoBuffer = null;

      if ( !tipoSubTipo.equals("") )
      {
           tipoSubTipo = tipoSubTipo.substring(0, tipoSubTipo.length()-1);
           traza("Tipo Subtipo despues de parsear: " + tipoSubTipo);
           StringTokenizer elementosTok = new StringTokenizer(tipoSubTipo, ";");
           StringTokenizer finalTok = null;

           int counter = 0;
           boolean primero = true;
           dtoBuffer = new DTOTipoSubtipoCliente();
           while ( elementosTok.hasMoreTokens() )
           {
             String elemento = elementosTok.nextToken();
             traza("elemento: " + elemento);
             finalTok = new StringTokenizer(elemento, "=");

             finalTok.nextToken();
             String valor = finalTok.nextToken();

             switch (counter)
             {
                  case 0:   // Oid Tipo/Subtipo.
                    if ( valor.equals("g") )
                      dtoBuffer.setOid(null);
                    else
                      dtoBuffer.setOid(new Long(valor));
                    break;

                  case 1:  // Tipo
                    dtoBuffer.setTipo(new Long(valor));
                    break;

                  case 2:  // Subtipo
                    dtoBuffer.setSubtipo(new Long(valor));
                    break;

                  case 3: // Desc Tipo (se ignora)
                  case 4: // Desc subTipo (se ignora)
                    break;
                
             }
             counter++;
             if (counter == 5)
             {
                // Si se llego al final de la primer linea:

                if (primero)
                  dtoBuffer.setPrincipal(new Boolean(primero));
                else
                  dtoBuffer.setPrincipal(new Boolean(false));

                // Agrego el dto al ArrayList
                traza("DTOTipoSubtipo a armar:" + dtoBuffer );                
                aList.add(dtoBuffer);
                
                dtoBuffer = new DTOTipoSubtipoCliente();
                primero = false;
                counter = 0;
             }
           }

           dtoTipo = new DTOTipoSubtipoCliente[aList.size()];
           // Ahora setea el array de objetos
           for ( int i = 0; i < aList.size(); i++)
                dtoTipo[i] = (DTOTipoSubtipoCliente) aList.get(i);
           
      }

      traza("Retorna de TipoSubtipo");
      
      return dtoTipo;
  }

  private DTOIdentificacion[] parseaListaIdentificaciones(String sIdentificaciones) throws Exception
  {
    StringTokenizer lineaTok = null;
    StringTokenizer elementoTok = null;
    ArrayList aList = new ArrayList();
    DTOIdentificacion[] dtoIdent = null;
    DTOIdentificacion dtoBuffer = null;
    
    if (!sIdentificaciones.equals("") )
    {
         // Separa las lineas
         lineaTok = new StringTokenizer(sIdentificaciones, "|");

         while ( lineaTok.hasMoreTokens() )
         {
            // Obtiene la linea
            String linea = lineaTok.nextToken();
            traza("Linea: " + linea);
            // Parte la linea
            elementoTok = new StringTokenizer(linea, ";");
            int counter  = 0;
            dtoBuffer = new DTOIdentificacion();
            while (elementoTok.hasMoreTokens())
            {
              String valor = elementoTok.nextToken();
              switch (counter)
              {
                case 0:  // Oid
                  if ( valor.equals("g") )
                    dtoBuffer.setOid(null);
                  else
                    dtoBuffer.setOid(new Long(valor));
                  break;

                case 1:  // Tipo Documento
                  dtoBuffer.setTipoDocumento(new Long(valor));
                  break;

                case 2:  // Numero Doc.
                  dtoBuffer.setNumeroDocumento(valor);
                  break;

                case 4:  // Principal
                  if ( valor.equals("true"))
                    dtoBuffer.setEsPrincipal(new Boolean(true));
                  else
                    dtoBuffer.setEsPrincipal(new Boolean(false));
                  break;

                case 5:  // Persona o Empresa
                    dtoBuffer.setIndPersonaEmpresa(valor);
                    break;
              }

              counter++;
              if (counter == 6)
                counter = 0;

           }
           traza("dtoIdent a setear: " + dtoBuffer);
           aList.add(dtoBuffer);
        }
        
        dtoIdent = new DTOIdentificacion[aList.size()];
        for ( int i = 0; i < dtoIdent.length; i++)
          dtoIdent[i] =(DTOIdentificacion) aList.get(i);

   }
    traza("retorna dtoIdent");
   return dtoIdent;


      
  }
  
  private DTOComunicacion[] parseaComunicacion(String sComm) throws Exception
  {
    StringTokenizer lineaTok = null;
    StringTokenizer elementoTok = null;
    ArrayList aList = new ArrayList();
    DTOComunicacion[] dtoComm = null;
    DTOComunicacion dtoBuffer = null;
    
    if (!sComm.equals("") )
    {
         // Separa las lineas
         lineaTok = new StringTokenizer(sComm, "|");

         while ( lineaTok.hasMoreTokens() )
         {
            // Obtiene la linea
            String linea = lineaTok.nextToken();
            traza("Linea: " + linea);
            // Parte la linea
            elementoTok = new StringTokenizer(linea, ";");
            int counter  = 0;
            dtoBuffer = new DTOComunicacion();
            while (elementoTok.hasMoreTokens())
            {
                traza("counter: " + counter);
                        String valor = elementoTok.nextToken();
                        switch (counter)
                        {
                         case 0:  // Oid
                           if ( valor.equals("g") )
                             dtoBuffer.setOid(null);
                           else
                             dtoBuffer.setOid(new Long(valor));
                           break;
         
                         case 1:  // Tipo Comunicacion
                         	dtoBuffer.setTipoComunicacion(new Long(valor));
                           break;
         
                         case 2:  // Dia Comunicacion
                    if ( !valor.equals(" ") )
                      dtoBuffer.setDiaComunicacion(new Character(valor.toCharArray()[0]));
                    else
                      dtoBuffer.setDiaComunicacion(null);
                           break;
         
                         case 3:  // Texto Comunicacion
                    if ( !valor.equals(" ") )
                         	dtoBuffer.setTextoComunicacion(valor);
                    else
                      dtoBuffer.setTextoComunicacion(null);
                           break;
         
                         case 4:  // Comunicacion Principal
                         	if (valor.equals("S"))
                           	dtoBuffer.setPrincipal(new Boolean(true));
                           else if (valor.equals("N") )
                           	dtoBuffer.setPrincipal(new Boolean(false));
                    else
                      dtoBuffer.setPrincipal(null);
                           break;
                             
                         case 5:  // Hora Desde

                    Long horaDesde = null;
                    if ( !valor.equals(" ") )
                    {
                      SimpleDateFormat simpleDate = new SimpleDateFormat("HH:mm");                      
                      java.util.Date hora = simpleDate.parse(valor);                      
                      Timestamp t = new Timestamp(hora.getTime() );
                      traza("t.getTime:" + t.getTime());
                      traza("hora desde: " + hora.toString() );
                      traza("hora desde long: " + hora.getTime() );
                      horaDesde = new Long( t.getTime() );
                    }
                    dtoBuffer.setHoraDesde(horaDesde);
                         	break;
                         	
                         case 6:   // Hora hasta
                    Long horaHasta = null;
                    if ( !valor.equals(" ") )
                    {
                      SimpleDateFormat simpleDate = new SimpleDateFormat("HH:mm");                      
                      java.util.Date hora = simpleDate.parse(valor);                      
                      Timestamp t = new Timestamp(hora.getTime() );
                      traza("t.getTime:" + t.getTime());
                      traza("hora hasta: " + hora.toString() );
                      traza("hora hasta long: " + hora.getTime() );
                      horaHasta = new Long( t.getTime() );
                    }
                    dtoBuffer.setHoraHasta(horaHasta);
                  
                         	break;
                         	
                         case 7:   // Intervalo Comunicacion
                    if (valor.equals("true"))
                      dtoBuffer.setIntervaloComunicacion(new Boolean(true));                      
                    else if (valor.equals("false") )
                      dtoBuffer.setIntervaloComunicacion(new Boolean(false));
                    else
                      dtoBuffer.setIntervaloComunicacion(null);

                         	//dtoBuffer.setIntervaloComunicacion(new Long(valor));
                         	break;
                         	
                        }
         
                        counter++;
                        if (counter == 8)
                         counter = 0;

           }
           traza("dtoComunicacion a setear: " + dtoBuffer);
           aList.add(dtoBuffer);
        }
        
        dtoComm = new DTOComunicacion[aList.size()];
        for ( int i = 0; i < dtoComm.length; i++)
          dtoComm[i] =(DTOComunicacion) aList.get(i);

   }
   traza("retorna dtoComunicacion[]");
   return dtoComm;


      
  }  
  
private DTODireccion[] parseaDireccion(String sDireccion) throws Exception
  {
    StringTokenizer lineaTok = null;
    StringTokenizer elementoTok = null;
    ArrayList aList = new ArrayList();
    DTODireccion[] dtoDireccion = null;
    DTODireccion dtoBuffer = null;
    
    if (!sDireccion.equals("") )
    {
         // Separa las lineas
         lineaTok = new StringTokenizer(sDireccion, "|");

         while ( lineaTok.hasMoreTokens() )
         {
            // Obtiene la linea
            String linea = lineaTok.nextToken();
            traza("Linea: " + linea);
            // Parte la linea
            elementoTok = new StringTokenizer(linea, ";");
            int counter  = 0;
            dtoBuffer = new DTODireccion();
            while (elementoTok.hasMoreTokens())
            {
                        String valor = elementoTok.nextToken();
                 traza("counter: " + counter);
                 traza("Valor a setear: " + valor);
                        switch (counter)
                        {
                         case 0:  // Oid
                    
                           if ( valor.equals("g") )
                             dtoBuffer.setOid(null);
                           else
                             dtoBuffer.setOid(new Long(valor));
                           break;
         
                         case 1:  // Unidades Geograficas
                    dtoBuffer.setNombreUnidadGeografica(valor);
                    //dtoBuffer.setUnidadGeografica(new Long(valor));
                           break;
         
                         case 4:  // Nombre via

                  if (!valor.equals(" ") && !valor.equals("") )
                    dtoBuffer.setNombreVia(valor);
                  else
                    //dtoBuffer.setNombreVia(null);
                                      dtoBuffer.setNombreVia("");   //  Modificado por HRCS - Incidencia Sicc20070401
                    
                         break;
         
                         case 6:  // Nro Principal
                  if (!valor.equals(" ") && !valor.equals("") )
                    dtoBuffer.setNumeroPrincipal(valor);
                  else  
                    dtoBuffer.setNumeroPrincipal(null);
                  break;
                         	
                         case 7:   // Codigo Postal
                  if (!valor.equals(" ") && !valor.equals("") )                  
                    dtoBuffer.setCodigoPostal(valor);
                  else  
                    dtoBuffer.setCodigoPostal(null);
                         	break;
                  
                         case 8:  // Observaciones
                  if (!valor.equals(" ") && !valor.equals("") )                                                                                           
                    dtoBuffer.setObservaciones(valor);
                  else                      
                    dtoBuffer.setObservaciones(null);                  
                    
                         	break;
                         	
                         case 9:  // Direccon Ppal.
                    if (valor.equals("false"))
                      dtoBuffer.setEsDireccionPrincipal(new Boolean(false));
                    else
                      dtoBuffer.setEsDireccionPrincipal(new Boolean(true));
                         	break;

                  case 10: // Unidad Geografica
                    dtoBuffer.setUnidadGeografica(new Long(valor));
                    break;

                  
                                    case 11: // Via - 13
                    if (!valor.equals(" "))
                      dtoBuffer.setVia(new Long(valor));
                    else
                      dtoBuffer.setVia(null);
                           break;
                                    

                  case 12: // Tipo Via 
                    dtoBuffer.setTipoVia(new Long(valor));
                    break;

                                case 13: // Tipo Direccion - 11
                                             dtoBuffer.setTipoDireccion(new Long(valor));
                                             break;

                        }
         
                        counter++;
                        if (counter == 14)
                         counter = 0;

           }
           dtoBuffer.setOidIdioma(UtilidadesSession.getIdioma(this));
           dtoBuffer.setOidPais(UtilidadesSession.getPais(this));           
           
           traza("DTO Direccion a setear: " + dtoBuffer);
           aList.add(dtoBuffer);
        }
        
        dtoDireccion = new DTODireccion[aList.size()];
        for ( int i = 0; i < dtoDireccion.length; i++)
          dtoDireccion[i] =(DTODireccion) aList.get(i);

   }
   //DruidaConector con = new DruidaConector();
   traza("retorna dtoDireccion[]");
   return dtoDireccion;
      
  }   

  private DTOClienteMarca[] parseaMarcas(String sMarca) throws Exception
  {
    StringTokenizer lineaTok = null;
    StringTokenizer elementoTok = null;
    ArrayList aList = new ArrayList();
    DTOClienteMarca[] dtoMarca = null;
    DTOClienteMarca dtoBuffer = null;
    
    if (!sMarca.equals("") )
    {
         // Separa las lineas
         lineaTok = new StringTokenizer(sMarca, "|");
         boolean principal = true;        

         while ( lineaTok.hasMoreTokens() )
         {
            // Obtiene la linea
            String linea = lineaTok.nextToken();
            traza("Linea: " + linea);
            // Parte la linea
            elementoTok = new StringTokenizer(linea, ";");
            int counter  = 0;
            dtoBuffer = new DTOClienteMarca();
            while (elementoTok.hasMoreTokens())
            {
                        String valor = elementoTok.nextToken();
                 traza("counter: " + counter);
                        switch (counter)
                        {
                         case 0:  // Oid de Registro
                           if ( valor.equals("g") )
                             dtoBuffer.setOid(null);
                           else
                             dtoBuffer.setOid(new Long(valor));
                           break;
         
                         case 1:  // Codigo (Oid de Marca)
                    dtoBuffer.setMarca(new Long(valor));
                           break;
                         	
                        }
         
                        counter++;
                        if (counter == 2)
                 {
                   // Seteo principal, en caso de ser la primera
                   dtoBuffer.setPrincipal(new Boolean(principal));                                         
                   if (principal)
                     principal = !principal;                   

                         counter = 0;                     
                 }

           }
           traza("DTO Marca a setear: " + dtoBuffer);
           dtoBuffer.setOidIdioma(UtilidadesSession.getIdioma(this));
           dtoBuffer.setOidPais(UtilidadesSession.getPais(this));
           aList.add(dtoBuffer);
        }
        
        dtoMarca = new DTOClienteMarca[aList.size()];
        for ( int i = 0; i < dtoMarca.length; i++)
          dtoMarca[i] =(DTOClienteMarca) aList.get(i);

   }
   traza("retorna dtoMarca[]");
   return dtoMarca;  
    
  }


  private DTOTarjeta[] parseaTarjetas(String sTarjeta) throws Exception
  {
    StringTokenizer lineaTok = null;
    StringTokenizer elementoTok = null;
    ArrayList aList = new ArrayList();
    DTOTarjeta[] dtoTarje = null;
    DTOTarjeta dtoBuffer = null;
    
    if (!sTarjeta.equals("") )
    {
         // Separa las lineas
         lineaTok = new StringTokenizer(sTarjeta, "|");

         while ( lineaTok.hasMoreTokens() )
         {
            // Obtiene la linea
            String linea = lineaTok.nextToken();
            traza("Linea: " + linea);
            // Parte la linea
            elementoTok = new StringTokenizer(linea, ";");
            int counter  = 0;
            dtoBuffer = new DTOTarjeta();
            while (elementoTok.hasMoreTokens())
            {
              String valor = elementoTok.nextToken();
              switch (counter)
              {
                case 0:  // Oid
                  if ( valor.equals("g") )
                    dtoBuffer.setOid(null);
                  else
                    dtoBuffer.setOid(new Long(valor));
                  break;

                case 1:  // Tipo Tarjeta
                  dtoBuffer.setTipo(new Long(valor));
                  break;

                case 2:  // Clase Tarjeta 
                  dtoBuffer.setClase(new Long(valor));
                  break;

                case 3:  // Entidad Bancaria
                  dtoBuffer.setBanco(new Long(valor));
                  break;
              }

              counter++;
              if (counter == 4)
                counter = 0;

           }
           traza("dtoTarjeta a setear: " + dtoBuffer);
           aList.add(dtoBuffer);
        }
        
        dtoTarje = new DTOTarjeta[aList.size()];
        for ( int i = 0; i < dtoTarje.length; i++)
          dtoTarje[i] =(DTOTarjeta) aList.get(i);

   }
    traza("retorna dtoTarjeta");
   return dtoTarje;  
    
  }

  private DTOClasificacionCliente[] parseaClasificaciones(String sClasificacion) throws Exception {
      traza("Grupo Clasificacion string es_" + sClasificacion);
      /* Entrada:
          clasi=1125;comboMarcaDesc=Grupo Ebel;comboCanalDesc=Venta directa;comboTipoClienteDesc=Cliente;comboSubtipoClienteDesc=Final;comboTipoClasificacionDesc=Lider;
          comboClasificacionDesc=Lider;comboMarca=8;comboCanal=2;comboTipoClasificacion=1;comboClasificacion=1;
          comboTipoCliente=1;comboSubtipoCliente=2|clasi=g;comboMarcaDesc=Grupo Ebel;.....
        */
      traza("---- Grupo Clasificacion string es_" + sClasificacion);
      UtilidadesSession utilidadesSesion = new UtilidadesSession();
      Long oidPais = utilidadesSesion.getPais(this);
      Long oidIdioma = utilidadesSesion.getIdioma(this);

      StringTokenizer stkLista = new StringTokenizer(sClasificacion, "|");
      StringTokenizer stkClasificacion = null;
      StringTokenizer stkCampo = null;
      DTOClasificacionCliente dtoClasificacion = null;
         
      int cantFilas = stkLista.countTokens();
      traza("    cantClasificaciones: " + cantFilas);
      DTOClasificacionCliente[] clasificaciones = null;
      
      if (cantFilas > 0) {
           clasificaciones = new DTOClasificacionCliente[cantFilas];
           int indice = 0;
           int nCampo;
           String sClasi;
           String sCampo;
           String sValor;
           
           while ( stkLista.hasMoreTokens() ) {
                sClasi = stkLista.nextToken();
                traza("    clasificacion_" + sClasi);
                
                dtoClasificacion = new DTOClasificacionCliente();
                dtoClasificacion.setPrincipal((indice == 0)? new Boolean(true) : new Boolean(false)); // Setea Principal = true en el primero, en otros = false
                
                stkClasificacion = new StringTokenizer(sClasi, ";");
                nCampo = 0;
                   
                while ( stkClasificacion.hasMoreTokens() ) {
                    sCampo = stkClasificacion.nextToken();
                    stkCampo = new StringTokenizer(sCampo, "=");
                        
                    if ( stkCampo.countTokens() > 1 ) {   // Si un campo más de 1 token es porque tiene nombre y también valor
                         stkCampo.nextToken();              // No me interesa este valor (es nombre del campo).
                         sValor = stkCampo.nextToken();    // Valor real.
                         
                         switch (nCampo) {
                            case 0:    // Clasi (oid / g segun ya exista o se trate de una nueva clasificacion a insertar respectivamente)
                              traza("    campo es 0 Oid_" + sValor);
                              if ( sValor.equals("g") ) {
                                   dtoClasificacion.setOid(null);
                              } else {
                                   dtoClasificacion.setOid(new Long(sValor));
                              }
                                                 break;
                            case 7:    // Marca
                              traza("    campo es 7 Marca_" + sValor);
                              dtoClasificacion.setMarca(new Long(sValor));
                              break;
                            case 8:    // Canal
                              traza("    campo es 8 Canal_" + sValor);
                              dtoClasificacion.setCanal(new Long(sValor));
                              break;
                            case 9:    // Tipo Clasificacion
                              traza("    campo es 9 TipoClasificacion_" + sValor);
                              dtoClasificacion.setTipoClasificacion(new Long(sValor));
                              break;
                            case 10:   // Clasificacion
                              traza("    campo es 10 Clasificacion_" + sValor);
                              dtoClasificacion.setClasificacion(new Long(sValor));
                              break;
                         }
                      
                    }            
                    nCampo++;
                }
                
                dtoClasificacion.setOidPais(oidPais);
                dtoClasificacion.setOidIdioma(oidIdioma);
                
                clasificaciones[indice] = dtoClasificacion;
                
                indice++;
                
           }

      }
      return clasificaciones;    
  }


  private DTOPsicografia[] parseaPsicografias(String sPsicografias) throws Exception
  {
    StringTokenizer lineaTok = null;
    StringTokenizer elementoTok = null;
    ArrayList aList = new ArrayList();
    DTOPsicografia[] dtoPsico = null;
    DTOPsicografia dtoBuffer = null;
    
    if (!sPsicografias.equals("") )
    {
         // Separa las lineas
         lineaTok = new StringTokenizer(sPsicografias, "|");

         while ( lineaTok.hasMoreTokens() )
         {
            // Obtiene la linea
            String linea = lineaTok.nextToken();
            traza("Linea: " + linea);
            // Parte la linea
            elementoTok = new StringTokenizer(linea, ";");
            int counter  = 0;
            dtoBuffer = new DTOPsicografia();
            while (elementoTok.hasMoreTokens()) {
              String valor = elementoTok.nextToken();
              switch (counter)
              {
                case 0:  // Oid
                  if ( valor.equals("g") )

                    dtoBuffer.setOid(null);
                  else
                    dtoBuffer.setOid(new Long(valor));
                  break;

                case 1:  // Marca
                  dtoBuffer.setMarca(new Long(valor));
                  break;

                case 2:  // Tipo Perfil
                  dtoBuffer.setTipoPerfil(new Long(valor));
                  break;

                case 3:  // Cod. Test.
                  dtoBuffer.setCodigoTest(valor);
                  break;

                case 4:  // Fecha
                  String formatoFechaSesion = UtilidadesSession.getFormatoFecha(this);
                  formatoFechaSesion = formatoFechaSesion.replace('m', 'M');
                
                  SimpleDateFormat simpleDate = new SimpleDateFormat(formatoFechaSesion);
                  java.util.Date fechaBuffer = null;
                  java.sql.Date fechaTest = null;
                
                  if ( valor != null && 
                             (!valor.equals("") && !valor.equals(" ")) ) {
                    fechaBuffer = simpleDate.parse(valor);
                    fechaTest = new java.sql.Date(fechaBuffer.getTime());
                  }
           
                  dtoBuffer.setFecha(fechaTest);
                  break;
              }

              counter++;
              if (counter == 5)
                counter = 0;

           }
           traza("dtoPsicografia a setear: " + dtoBuffer);
           aList.add(dtoBuffer);
        }
        
        dtoPsico = new DTOPsicografia[aList.size()];
        for ( int i = 0; i < dtoPsico.length; i++)
          dtoPsico[i] =(DTOPsicografia) aList.get(i);

   }
    traza("retorna dtoPsicografia");
    return dtoPsico;  
    
  }    


/*  private DTOProblemaSolucion[] parseaProblema(String sProblema) throws Exception 
  {
    ArrayList arrayBuffer = new ArrayList();
    ArrayList 
    StringTokenizer lineaTok = null;
    StringTokenizer elementoTok = null;
    ArrayList aList = new ArrayList();
    DTOProblemaSolucion[] dtoProble = null;
    DTOProblemaSolucion dtoBuffer = null;


    lineaTok = new StringTokenizer(sProblema, "|");
    while (lineaTok.hasMoreTokens())
    {
         lineaTok.nextToken()      
    }

    



    
  }*/

/*private DTOProblemaSolucion[] parseaProblema(String sProblema) throws Exception
  {
    StringTokenizer lineaTok = null;
    StringTokenizer elementoTok = null;
    ArrayList aList = new ArrayList();
    DTOProblemaSolucion[] dtoProble = null;
    DTOProblemaSolucion dtoBuffer = null;
    
    if (!sProblema.equals("") )
    {
         // Separa las lineas
         lineaTok = new StringTokenizer(sProblema, "|");

         while ( lineaTok.hasMoreTokens() )
         {
            boolean bFlag = false;  // Para distinguir entre problema/solucion
                                        // true - Problema
                                        // false - Solucion
            
            // Obtiene la linea            
            String linea = lineaTok.nextToken();
            traza("Linea: " + linea);
            // Parte la linea
            elementoTok = new StringTokenizer(linea, ";");
            traza("Cantidad de tokens en linea: " + elementoTok.countTokens());
            int counter  = 0;
            dtoBuffer = new DTOProblemaSolucion();
            while (elementoTok.hasMoreTokens())
            {
              String valor = elementoTok.nextToken();
              traza("counter: " + counter);              
              traza("valor: " + valor);
              switch (counter)
              {
         
                case 0:  // Oid
                  if ( valor.equals("g") )
                  {
                    dtoBuffer.setOid(null);                    
                  }
                  else
                  {
                     // Parsea Valor para sacar el prefijo S o P (por la tabla corresp.)
                     // y saber si es problema o solucion.
                     String sPrefijo = valor.substring(0,1);
                     if (sPrefijo.equals("P"))
                         bFlag = true;
                     else
                         bFlag = false;

                     valor = valor.substring(1, valor.length());
                     traza("valor a setear: " + valor);
                     dtoBuffer.setOid(new Long(valor));
                  }
                  break;

                case 1:  // Tipo Problema
                  // Antes chequeo si dtoBuffer.getOid es null. Siendo asi, entonces
                  // se necesita leer el combo de problema (esta posicion) para determinar el 
                  // valor de bFlag. SI es -1, entonces estaba deshabilitado, por lo que indica
                  // "Solucion". Si no, es Problema. (setea bFlag de acuerdo a esto, segun 
                  // case 0
                  if (dtoBuffer.getOid() == null)
                  {
                    traza("oid null");
                    if ( valor.equals("-1") )
                    {
                      bFlag = false;
                      traza("Es solucion");
                    }
                    else
                    {
                      bFlag = true;
                      traza("Es Problema");
                    }
                      
                  }
                  if (bFlag)
                    dtoBuffer.setTipo(new Long(valor));
                  break;

                case 2:  // Desc Problema
                  // Solo se setea si es problema.
                  if (bFlag)
                    dtoBuffer.setDescripcion(valor);
                
                  break;

                case 3:  // Ind. de Problema / Solucion
                  // Esta invertido respecto a bFlag. O sea, Problema es false,
                  // Solucion es true
                  traza("bFlag: " + bFlag);
//                  if (bFlag)
                    dtoBuffer.setSolucion(new Boolean(!bFlag));
//                  else
//                    dtoBuffer.setTipo(new Long(valor));
                  break;

                case 4:  // Tipo Solucion

                  if (bFlag == false)
                      dtoBuffer.setTipo(new Long(valor));                 
                  break;

                case 5:  // Desc. Solucion
                   //dtoBuffer.setDescripcion(valor);                
                  if (bFlag == false)
                   dtoBuffer.setDescripcion(valor);                

                  break;

                case 6:
                  dtoBuffer.setNegocio(valor);
                  break;
                  
             }

             counter++;
             if (counter == 7)
                counter = 0;
           }
           traza("dtoProblema a setear: " + dtoBuffer);
           aList.add(dtoBuffer);
        }
        
        dtoProble = new DTOProblemaSolucion[aList.size()];
        for ( int i = 0; i < dtoProble.length; i++)
          dtoProble[i] =(DTOProblemaSolucion) aList.get(i);

   }
    traza("retorna dtoProblema");
    return dtoProble;  
    
  }         */


  private DTOProblemaSolucion[] parseaProblema(String sProblema) throws Exception
  {
      StringTokenizer lineasTok = null;
      StringTokenizer elementoTok = null;
      ArrayList aList = new ArrayList();
      DTOProblemaSolucion[] dtoProble = null;
      DTOProblemaSolucion dtoBuffer = null;

      Vector vLista = new Vector();
      Vector vFila = new Vector();
    
      if ( !sProblema.equals("") )
      {
           // ******* Primero obtiene en un Vector los datos **********
           // *********************************************************
           // Separa las lineas
           lineasTok = new StringTokenizer(sProblema, "|");
           traza("Cadena solucion a parser: " + sProblema);

           while (lineasTok.hasMoreTokens() )
           {
                 //g;3;aaaaaaaaaaaaaaa;S;2;aaaaaaaaaaaaaaaa;aaaaaaaaaaaaaaaaaaaaaaaaa|g;5;ddddddddddddddd;N; ; ;ddddddddddddddddd
                // Obtiene la linea-
                dtoBuffer = new DTOProblemaSolucion();
                String linea = lineasTok.nextToken();
                elementoTok = new StringTokenizer(linea, ";");
                int counter = 0;
                while ( elementoTok.hasMoreTokens() )
                {
                  String valor = elementoTok.nextToken();
                  traza("valor: " + valor);
                  
                  switch (counter)
                  {
                    case 0:   // Oid 
                      if (valor.equals("g") ) 
                         dtoBuffer.setOid(null);
                      else
                         dtoBuffer.setOid(new Long(valor) );
                      break;
                      
                    case 1:   // Tipo Problema (Not Null en BD)
                      dtoBuffer.setTipoProblema( new Long(valor) );
                      break;

                    case 2:   // Desc Problema (Admite Null en BD)
                      if (!valor.equals(" ") )
                         dtoBuffer.setDescripcionProblema(valor);
                      else
                         dtoBuffer.setDescripcionProblema(null);
                      break;

                    case 3:  // Tipo Problema/Solucion (Not NULL en BD)
                      if ( valor.equals("S") )
                         dtoBuffer.setSolucion( new Boolean(true) );
                      else
                         dtoBuffer.setSolucion( new Boolean(false) );
                      break;

                    case 4:  // Tipo Solucion (puede ser null en BD)
                      // Solo toma valoers que se pasan, si Indicador Solucion es true
                      if ( dtoBuffer.getSolucion().booleanValue() )
                      {
                         if (!valor.equals(" ") )
                           dtoBuffer.setTipoSolucion(new Long(valor));
                         else
                           dtoBuffer.setTipoSolucion(null);
                      } else {
                         dtoBuffer.setTipoSolucion(null);
                      }
                      break;

                    case 5:  // Desc Solucion (puede ser null en BD)
                      // Solo toma valores que se pasan, si Indicador Solucion es true
                      if (dtoBuffer.getSolucion().booleanValue() )
                      {
                         if ( !valor.equals(" ") )
                           dtoBuffer.setDescripcionSolucion(valor);
                         else
                           dtoBuffer.setDescripcionSolucion(null);
                      } else {
                         dtoBuffer.setDescripcionSolucion(null);
                      }
                      break;

                    case 6:  // Negocio
                      if ( !valor.equals(" ") )
                         dtoBuffer.setNegocio(valor);
                      else
                         dtoBuffer.setNegocio(null);
                      
                      break;
                  }
                  counter++;                  

                  if (counter == 7)
                  {
                    vLista.add(dtoBuffer);
                    traza("DTOProblema a setear: " + dtoBuffer);
                    dtoBuffer = new DTOProblemaSolucion();
                    counter = 0;
                  }
                }
           }

           dtoProble = (DTOProblemaSolucion[]) vLista.toArray(new DTOProblemaSolucion[vLista.size()]);

      } 
      
      return dtoProble;

  }   


  private void Siguiente3_Validar()throws Exception{  
    
      traza(" ****** Entrando a Siguiente 3 Validar***********");
      
                           HashMap p2 = (HashMap) this.conectorParametro();
      String sListaVinculos  = (String) p2.get("hidListaVinculoSal");
      traza("Lista Vinculos: " + sListaVinculos);
      RecordSet rListaVinculos = null;
      if (sListaVinculos != null && sListaVinculos.length() > 0) {
          rListaVinculos = this.parseaLista(sListaVinculos);
      }
      
      /* this.generaGrupoVinculo(vinculos); */
      /*traza("valores de P2 en sesion: " + p2.toString() );
      traza("3333333333333333333333 - h_TipoClienteContacto en param: "+ (String)p2.get("h_TipoClienteContacto"));
      traza("GrupoVinculo.toString(): " + GrupoVinculo.toString());
      
                           int n =(GrupoVinculo.keySet().size())/6;
                           traza("El tamaño del n es :" + n);
                           traza("1");*/
         
      DTOValidarClientes dtoValiClien = new DTOValidarClientes();      
      UtilidadesSession sesion = new UtilidadesSession();      
      DTOCliente clie = (DTOCliente)conectorParametroSesion("DTOCliente");      
      
      if (rListaVinculos != null && !rListaVinculos.esVacio() ) {
          int cantRegistros = rListaVinculos.getRowCount();
          Long[] paisVinculos = new Long[cantRegistros];
          String[] clientesVinculos = new String[cantRegistros];
          Long paisSesion = UtilidadesSession.getPais(this);
          String sCodigoCliente = null;
          
          for (int i=0; i<cantRegistros; i++) {
             sCodigoCliente = (String) rListaVinculos.getValueAt(i, 1);
             paisVinculos[i] = paisSesion;
             clientesVinculos[i] = sCodigoCliente;
          }
          dtoValiClien.setClientesVinculo(clientesVinculos);
          dtoValiClien.setPaisesVinculo(paisVinculos);
          
      } else {
          traza("No hay vinculos");
          dtoValiClien.setClientesVinculo(null);
          dtoValiClien.setPaisesVinculo(null);
      }
      
      /*if (n != 0){
             traza("Hay al menos 1 vinculo");
             Long[] paisVinculos= new Long[n];
             traza("2");
             String[] clientesVinculos= new String[n];
             traza("3");

             //DTOValidarClientes dtovaliclien = new DTOValidarClientes();
             for(int i=0;i<n;i++){
                traza("4 - "+i);
                //paisVinculos[i]=new Long(GrupoVinculo.get("h_paisVinculo_"+i).toString());
                paisVinculos[i]= UtilidadesSession.getPais(this);
                clientesVinculos[i]=GrupoVinculo.get("h_clienteVinculo_"+i).toString();
             }
             traza("Sale del for");

             dtovaliclien.setClientesVinculo(clientesVinculos);//array de string
             traza("setClientesVinculo[0]:  "+ clientesVinculos[0]);
                           
             dtovaliclien.setPaisesVinculo(paisVinculos);//array de longs
             traza("setPaisesVinculo[0]: "+ paisVinculos[0]);
      }else{
             traza("No hay vinculos");
             dtovaliclien.setClientesVinculo(null);
             dtovaliclien.setPaisesVinculo(null);
      }*/
      
      boolean existeContacto = false;
      if (!p2.get("textCodClienteContactado").toString().equals("") ) {
          existeContacto = true;
      }

      if (!existeContacto) {
           traza("No se introdujo Primer Contacto");
           dtoValiClien.setClienteContacto(null);
           dtoValiClien.setPaisContactado(null);
           dtoValiClien.setTipoClienteContacto(null);
      } else {
           traza("Se introdujo Primer Contacto");
           
           dtoValiClien.setClienteContacto( p2.get("textCodClienteContactado").toString());
           traza("setClienteContacto: "+ p2.get("textCodClienteContactado").toString());
                  
           dtoValiClien.setPaisContactado(UtilidadesSession.getPais(this));
           traza("setPaisContactado: "+ UtilidadesSession.getPais(this).toString() );

           traza("h_cbTipoClienteContactado: " + (String) p2.get("h_cbTipoClienteContactado") ); 
           String sTipoClienteContacto = (String) p2.get("h_cbTipoClienteContactado");             

           Long nTipoClienteContacto = new Long(sTipoClienteContacto);
           dtoValiClien.setTipoClienteContacto( nTipoClienteContacto );//long             
      }
      
      HashMap tipoSubtipo = (HashMap) conectorParametroSesion("tipoSubt");
      String sListaSubtipo = (String) tipoSubtipo.get("elementos");
      
      // Modificado por SICC20070433 - Rafael Romero - 25/09/2007
      Long subTipoL = null;
      if (sListaSubtipo != null && sListaSubtipo.length() > 0) {
          RecordSet rListaSubtipo = this.parseaLista(sListaSubtipo);
          if (rListaSubtipo != null && !rListaSubtipo.esVacio()) {
             String sSubtipo = (String) rListaSubtipo.getValueAt(0,4);
             subTipoL = new Long(sSubtipo);
             dtoValiClien.setSubtipoCliente(subTipoL);
          }
      }
      // Fin modificado SiCC20070433
      
                           /*HashMap tipoSubtipo=(HashMap)conectorParametroSesion("tipoSubt");
      traza("HashMap tipoSubtipo en sesion: " + tipoSubtipo.toString() );
      traza("h_comboSubtipoCliente_0 en tipo subtipo: " + (String) tipoSubtipo.get("h_comboSubtipoCliente_0") );
                  dtoValiClien.setSubtipoCliente(new Long(tipoSubtipo.get("h_comboSubtipoCliente_0").toString()));//long*/

                           dtoValiClien.setOidIdioma(sesion.getIdioma(this));
                           traza("setOidIdioma: "+sesion.getIdioma(this));
      
                           dtoValiClien.setOidPais(sesion.getPais(this));
                           traza("setOidPais: "+sesion.getPais(this));
      
                           // Agregado por SiCC20070433 - Rafael Romero - 24/09/2007 
                           String hidEdad = p2.get("hidEdad").toString(); 
                           if(hidEdad!=null && hidEdad.length()>0){ 
                             dtoValiClien.setEdad(new Integer(hidEdad)); 
                           } 
                           // Fin agregado SICC20070433 

                           asignarAtributo("VAR","hidPais","valor",sesion.getPais(this).toString());

      // Llama a obtener datos
                           DTOPestanya3 dtoP3 = (DTOPestanya3) obtenerDatosSalida("MAEPestanya3",
                                                                     "ConectorObjetoGenerico",
                                                                     (DTOValidarClientes)dtoValiClien);
      this.conectorParametroSesion("DTOPestanya3", dtoP3);                                                                     
      
      traza("dtoP3: " + dtoP3);
      Long[] listaVincu = dtoP3.getOidClientesVinculo();
      StringBuffer listaVincuToSet = new StringBuffer("");

      if (listaVincu != null){
           traza("Lista Vincu no es null");
           for (int i = 0; i < listaVincu.length; i++) {
             // Si hay un oid nulo, lanzamos error. 
             Long oidClienteVinculo = listaVincu[i];
             traza("Bucle " + i);

             if (oidClienteVinculo == null) {
                traza("Un Oid de Cliente Vinculo es null");
                throw new MareException( new Exception(), 160280003);//inc BELC300014099
             } else {
                  traza("oidClienteVinculo es " + oidClienteVinculo.toString() );
                  if (i != 0)
                    listaVincuToSet.append(",");

                  listaVincuToSet.append(oidClienteVinculo.toString() );
             }
           }
      }
      //asignarAtributo("VAR", "listaVinculosOid", "valor", listaVincu.toString());*/
      asignarAtributo("VAR", "listaVinculosOid", "valor", listaVincuToSet.toString());     

//      Long oidClienteContactado = dtoP3.getOidClienteContacto();
      
      Long oidClienteContacto = dtoP3.getOidClienteContacto();
      if (existeContacto)  // Solamente si se ha cargado contacto en la pagina principal.
      {
           if (oidClienteContacto != null){
              traza("Hay Cliente Contacto - Validado");
              asignarAtributo("VAR", "hidOidClienteCont", "valor", dtoP3.getOidClienteContacto().toString());  
                   //throw new MareException(new Exception(), 170280004);
           }

           if((oidClienteContacto != null) && (oidClienteContacto.equals(new Long(0))))
           {
              traza("NO hay cliente contacto asociado - No se valido");
              throw new MareException(new Exception(), 160310000);
           } 

           if (oidClienteContacto == null)
           {
             traza("Cliente Contacto es null - No se valido");
             throw new MareException(new Exception(), 160280004);           
           }

      }

                           // Modificado por SiCC20070433 - Rafael Romero - 24/09/2007 
                           Long cte_oid_subtipo_hija_dupla = dtoP3.getCteOidSubTipoHijaDupla(); 
                            
                           StringBuffer vectorRetorno = new StringBuffer();; 
                           vectorRetorno.append("["+cte_oid_subtipo_hija_dupla); 
                           if(subTipoL!=null && subTipoL.equals(cte_oid_subtipo_hija_dupla)){ 
                             vectorRetorno.append(","+dtoP3.getNivelValidacionEdadHijaDupla().toString()); 
                             vectorRetorno.append(","+dtoP3.getNivelValidacionTipoHijaDupla().toString()); 
                           } 
                           vectorRetorno.append("]"); 
                            
                           asignarAtributo("VAR","ejecutar","valor","validoOkModificar("+vectorRetorno.toString()+");"); 
                           // Fin modificado SiCC20070433 
    
  }
  
  
  private Vector obtieneTipos(String cadena) throws Exception
    {
         System.out.println("------ Entrando a obtiene Tipos --------");
         RecordSet tiposCliente = new RecordSet();
         RecordSet subTipos = new RecordSet();
         Vector vSubTipos = new Vector();
         Long[] subtipos = null;

         Vector vTipos = new Vector();
         Vector vSubtipos = new Vector();
         
         tiposCliente.setColumnCount(2);
         subTipos.setColumnCount(3);
         Vector vTiposCol = new Vector();
         vTiposCol.add("OID_CLIENTE");
         vTiposCol.add("DESC_CLIENTE");
         tiposCliente.setColumnIdentifiers( vTiposCol );

         vTiposCol = new Vector();
         vTiposCol.add("OID_CLIENTE");
         vTiposCol.add("OID_SUBTIPO");
         vTiposCol.add("DESC_CLIENTE");         
         subTipos.setColumnIdentifiers(vTiposCol);

         StringTokenizer tok = new StringTokenizer(cadena, ";");
         StringTokenizer tokCampo = null;
         String valor = null;
         String sCampo = null;
         int contadorFilas = 0;
         int contadorCampos = 0;
         traza("Entra al while");
         traza("Fila: " + contadorFilas); // Seria 0. 
         while ( tok.hasMoreTokens() )
         {
           int i = 0; // Se procesa el token cuando i = 0 e i = 2 (Id Cliente y Descripcion).
           sCampo = tok.nextToken();
           traza("sCampo: " + sCampo);
           tokCampo = new StringTokenizer(sCampo, "=");
           while ( tokCampo.hasMoreTokens() )  // Proceso el 4campo actual.
           {
                traza("Procesa campo " + contadorCampos);
                valor = tokCampo.nextToken(); // Este no importa, es el nombre del campo.
                valor = tokCampo.nextToken();  // Valor del campo, este es el que importa.
                if ( contadorCampos == 1 ) // Se tiene el Oid Tipo 
                {
                  tiposCliente.setRowCount( tiposCliente.getRowCount()+1 );
                  subTipos.setRowCount( subTipos.getRowCount()+1);
                  tiposCliente.setValueAt(valor, contadorFilas, 0);
                  subTipos.setValueAt(valor, contadorFilas, 0);
                }

                if ( contadorCampos == 2) {// Se tiene el Oid Subtipo
                  vSubTipos.add(new Long(valor));
                  subTipos.setValueAt(valor, contadorFilas, 1);
                }

                if ( contadorCampos == 3) // Se tiene la Desc Tipo
                  tiposCliente.setValueAt(valor, contadorFilas, 1);

                if ( contadorCampos == 4) // Se tiene la Desc Subtipo
                  subTipos.setValueAt(valor, contadorFilas, 2);
                
           }
           contadorCampos++;

           if (contadorCampos == 5)
           {
             contadorFilas++;
             contadorCampos = 0;
             traza("Fila: " + contadorFilas);             
           }


         }

         // Arma el array Long[] con los oid Subtipos
         Long[] sRetorno = (Long[]) vSubTipos.toArray( new Long[vSubTipos.size()] );
         traza("tiposCliente: " + tiposCliente);
         traza("subTipos: " + subTipos);

         Vector v = new Vector();
         v.add(tiposCliente);
         v.add(subTipos);
         v.add(sRetorno);

         return v;
      
    }
    
  /**
   * @author: ssantana, 16/03/2006
   * @throws java.lang.Exception
   * @return void
   * @param String sXml
   */
    private RecordSet parseaLista(String sXml) throws Exception {
         traza("sxml: " + sXml);
         sXml = sXml.replaceAll("&", "&amp;");
         String sPropiedadActual = null;
         String sValorCampo = null;
         String sPropiedad = null;
         Node nodeDoc = null;         
         Node nodoRow = null;
         Node nodoCampo = null;
         NodeList nodeList = null;
         NodeList nodeListCampos = null;
         HashMap hshAtributos = new HashMap();
         DocumentBuilder docBuilder = null;
         RecordSet rRetorno = null;
         Vector vFila = null;
   
         ArrayList posicionesOperacion = new ArrayList();
         
         DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
         docBuilder = docBuilderFactory.newDocumentBuilder();
         ByteArrayInputStream inputStream = new ByteArrayInputStream(sXml.getBytes());
         
         nodeDoc = docBuilder.parse(inputStream).getFirstChild();
         traza("nodeDoc: " + nodeDoc.getNodeName());
         nodeList = nodeDoc.getOwnerDocument().getElementsByTagName("ROW");
         //nodeDoc.getChildNodes(); 
         long cantElems = nodeList.getLength();
         traza("cantElems: " + cantElems);
         /* Recorro tags <ROW> */         
         for (int i=0; i<cantElems; i++) {
            hshAtributos = new HashMap();
            nodoRow = nodeList.item(i);
            nodeListCampos = nodoRow.getChildNodes();
            long cantCampos = nodeListCampos.getLength();

            /* 
             * Si es la primer iteracion, armo la estrucutra del RecordSet 
             * con el numero de campos
             */             
            if (i == 0) {
                rRetorno = this.armarEstructuraRecordSet(cantCampos);              
            }
            
             /* Recorro tags <CAMPO> */
            vFila = new Vector(); 
            for (int j=0; j<cantCampos; j++) {
                 nodoCampo = nodeListCampos.item(j);
                 /* sPropiedad = this.obtenerPropiedadCampo(nodoCampo);*/
                 sValorCampo = this.obtenerValorCampo(nodoCampo);
                 vFila.add(sValorCampo);
            }
            rRetorno.addRow(vFila);
         }
         return rRetorno;
    }    
    
    
  private RecordSet armarEstructuraRecordSet(long cantCampos)
           throws Exception {
           
      RecordSet r = new RecordSet();
      Vector vCampos = new Vector();
      String sCampo = "campo_";
      
      for (int i=0; i < cantCampos; i++ ){
          vCampos.add(sCampo + i);
      }
      
      r.setColumnIdentifiers(vCampos);
      return r;
  }
  /**
   * @author: ssantana, 18/03/2006
   * @throws java.lang.Exception
   * @return String
   * @param Node nodo
   * @param String sNombreAtributo
   */
    private String obtenerPropiedadCampo(Node nodo) 
           throws Exception {
      NamedNodeMap nodeMap = nodo.getAttributes();
      Node nAtributo = nodeMap.getNamedItem("nombre");
      String sValorAtributo = nAtributo.getNodeValue();
      
      return sValorAtributo;
    }
    
  /**
   * @author: ssantana, 18/03/2006
   * @throws java.lang.Exception
   * @return String
   * @param Node nodo
   */
    private String obtenerValorCampo(Node nodo) 
           throws Exception {
         Node textNode = nodo.getFirstChild();
         String sValorCampo = null;
         if (textNode != null) { 

           sValorCampo = textNode.getNodeValue();
         } else {
           sValorCampo = "";
         }
         return sValorCampo;
    }    
    
    
    private Date recuperaFecha(String sCadena, String sFormato) 
             throws Exception {
             
        /* 
         * String sCadena: Cadena que contiene una fecha
         * String sFormato: Cadena con el formato de la fecha
         * 
         * Retorna un objeto Date con la fecha luego de parsearla
         * con el formato de sFormato 
         */
             
        SimpleDateFormat simpleDate = new SimpleDateFormat(sFormato);
        Date fechaRetorno = simpleDate.parse(sCadena);
        
        return fechaRetorno;
   }

   private void modificarTipoSubtipo() throws Exception {
        this.traza("LPModificarCliente.modificarTipoSubtipo() - Entrada");
        DTOBelcorp dtoBelcorp = new DTOBelcorp();
        dtoBelcorp.setOidPais(UtilidadesSession.getPais(this));
        dtoBelcorp.setOidIdioma(UtilidadesSession.getIdioma(this));
        
        // Tipo cliente
        DTOTipoSubtipo dtotsubtipo = new DTOTipoSubtipo();
        dtotsubtipo= (DTOTipoSubtipo)obtenerDatosSalida("MAEObtenerTipoSubtipo",
                                                              "ConectorTipoSubtipo",
                                                              (DTOBelcorp) dtoBelcorp);
        traza("DTOTipoSubtipo_" + dtotsubtipo);
        RecordSet tipo = (RecordSet)dtotsubtipo.getTipos();
        UtilidadesBelcorp.agregarRegistroVacio(tipo,0);
        Vector colID = tipo.getColumnIdentifiers();
        DruidaConector dtipo = this.generarConector("DTOSalida.tipos_ROWSET",
                                                           tipo, 
                                                           colID);
        asignar("COMBO","comboTipoCliente", dtipo,"DTOSalida.tipos_ROWSET");

        // Subtipo cliente
        this.traza("Cargamos listaoculta subtipo");                
        RecordSet subtipo = (RecordSet) dtotsubtipo.getSubtipos();
        Vector colID2 = subtipo.getColumnIdentifiers();
        DruidaConector dsubtipo = 
                     this.generarConector("DTOSalida.subtipos_ROWSET",
                                              subtipo, 
                                              colID2);
        this.crearListaLP(colID2, 
                            subtipo.getColumnCount(),
                            "Capa1",
                            "Lista1",
                            "0",
                            "0");
        asignar("LISTA", "Lista1", dsubtipo, "DTOSalida.subtipos_ROWSET");

        // Parametros de la fila seleccionada para modificar
        String oidtipo = conectorParametroLimpia("oidTipoCliente", "", true);
        String oidsubtipo = conectorParametroLimpia("oidSubtipoCliente", "", true);
        traza("A modificar: tipo_" + oidtipo + " subtipo_" + oidsubtipo);
        asignarAtributo("VAR","hOidTipo","valor", oidtipo);
        asignarAtributo("VAR","hOidSubtipo","valor", oidsubtipo);   
   }
             


}

