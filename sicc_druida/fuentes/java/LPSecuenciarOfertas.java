
import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.pre.DTOComprobarOrden;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Vector;

import org.jaxen.dom.DOMXPath;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
// import org.w3c.dom.DOMException;

public class LPSecuenciarOfertas extends LPSICCBase {
    
     

    private String accion=null;
    private String origen=null;


    // Sacar averiguar por que no anda el tema de secciones
    private Long idioma = new Long(1);
    private Long pais = new Long(1);

    private String accionParametro=null;

    private Long oidCabeceraMF = null;
    private String pais2 = null;
    private String marca = null;
    private String canal = null;
    private String periodo = null;
    

//************************************************************************************************
    public LPSecuenciarOfertas()  {
        super();
    }  
//************************************************************************************************
    public void inicio() throws Exception {
      this.pagina("contenido_secuenciar_ofertas");
      //this.pagina("testRG3");
    }
//****************************************************/********************************************
    public void ejecucion2() throws Exception {
        setTrazaFichero();
        traza("aaaa");
    }
    
    public void ejecucion() throws Exception {
        setTrazaFichero();
        try{       
            // Funcion Rastreo
            
            rastreo(); 
         
            traza ("===>  Entro a la LPSecuenciarOfertas");
            accion = conectorParametro("accion")==null?"":conectorParametro("accion");
            
            traza("============>   ACCION: "+ accion);
            // Cargo los label
            this.cargarDatos();
            
            if (accion.equals("")) {
                traza ("ESTA POR ENTRAR AL ");  
                conectorAction("LPSeleccionarMF");
                conectorParametroSesion("UltimaLP","LPSecuenciarOfertas");
                //conectorActionParametro("nueva","true");
      
            }else 
               if ((accion.equals("Matrizseleccionada")) || (accion.equals("Matriz seleccionada"))){
                      traza ("ESTA POR ENTRAR AL MATRIZ SELECCIONADA");  
                      matrizSeleccionada();
            } else 
                  if (accion.equals("secuenciarOfertasAceptar")){
                           traza ("ESTA POR ENTRAR AL SECUENCIAR OFERTAS ACEPTAR"); 
                  secuenciarOfertasAceptar();                       
            } else
                   if (accion.equals("salir")){
                        if ((conectorParametroSesion("UltimaLP")).equals("LPConsultarOrdenOfertas")) {
                              conectorAction("LPConsultarOrdenOfertas"); 
                     }
            }

            // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
            agregarMenuComplementario();
            // Fin agregado SICC20070322

        }catch(Exception ex){
            traza ("====> ENTRA AL CARGAR DATOS POR EL ERROR");
            this.cargarDatos();
            this.lanzarPaginaError(ex);  
            logStackTrace(ex);
         
            
            }
    }

//************************************************************************************************
    private void secuenciarOfertasAceptar() throws Exception{
      traza ("======> ENTRA AL SECUENCIAR OFERTAS ACEPTAR");  
      //this.pagina("contenido_secuenciar_ofertas");


      DruidaConector conectorSecuenciarOfertas = null;

      traza ("=====> ESTOY POR INICIALIZAR EL MARE BUSINESS ID");
      MareBusinessID id = new MareBusinessID("PRESecuenciarOfertas");


      traza ("=====> CREO EL DTO");
      DTOOID dto = new DTOOID();


      traza ("=====> SETEO LOS DTO");

      traza ("=====> SETEAR OID ");
      dto.setOid((Long)conectorParametroSesion("oidCabeceraMF"));
      
      traza ("=====>SETEAR IPCLIENTE");
      dto.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
      
      traza ("=====> SETEAR FUNCTION  ");
      dto.setPrograma(UtilidadesSession.getFuncion(this));
      
      traza ("=====> SETEAR IDIOMA ");
      dto.setOidIdioma(UtilidadesSession.getIdioma(this));
      
      traza ("=====> SETEAR PAIS ");
      dto.setOidPais(UtilidadesSession.getPais(this));
      
      

      traza ("=====> DTO");
      traza(dto);

      Vector param = new Vector();
      param.add(dto);
      param.add(id);

      traza ("=====> VECTOR");
      traza(param);

      traza ("=====> CONECTA......");
      conectorSecuenciarOfertas = conectar("ConectorSecuenciarOfertas",param);
      traza("===========> CONECTO");

      String cerrar = conectorParametro("origen");
      if (cerrar != null && (!cerrar.equals(""))){
            asignarAtributo("VAR","cerrar2","valor",cerrar);
      }
      asignarAtributo("VAR","cerrar","valor","secuenciarOfertasAceptar");


      traza("==============> CERRAR2");
      traza(cerrar);

      

     }


//************************************************************************************************

     private void matrizSeleccionada() throws Exception{

                  traza("=========> ENTRA AL MATRIZ SELECCIONADA ");

        //          this.pagina("contenido_secuenciar_ofertas");

                  traza("=========> INICIALIZO EL CONECTOR    ");
                  origen = conectorParametro("origen")==null?"":conectorParametro("origen");
                  asignarAtributo("VAR","origen","valor",origen);
                  traza("=========> ORIGEN   ");
                  traza (origen);
                  DruidaConector conectorComprobarOrdenOfertas = null;

                  traza("=========> CREO EL DTOOID   ");
                  DTOOID dto = new DTOOID();
                  /* OBTENGO DE SESCION EL OID DE CABECERA DE LA MATRIZ DE FACTURACION
                   CONSTRUIMOS UN DTOOID */
                  dto.setOid((Long)conectorParametroSesion("oidCabeceraMF"));

                  traza("=========> SETEO EL OID   ");

                  // CREAMOS EL idBusiness = "PREComprobarOrdenOfertas"
                  MareBusinessID id = new MareBusinessID("PREComprobarOrdenOfertas");

                  traza("=========> CREO EL MARE BUSINESS ID   ");

                  Vector param = new Vector();
                  param.add(dto);
                  param.add(id);
                  traza ("============>  trazeo el dto");
                  traza(param);
                  traza("=========> VA A CONECTAR  ");
                  
                  conectorComprobarOrdenOfertas = conectar("ConectorComprobarOrdenOfertas",param); // -> Asignar conector "ConectorComprobarOrdenOfertas", antes habia ConectorGenerico
                  DTOComprobarOrden dtoS = (DTOComprobarOrden)conectorComprobarOrdenOfertas.objeto("dtoSalida");
                  traza(dtoS);
                  
                  traza("=========>  CONECTO  ");
                                                                       
                  // Agregado ya que aparece en la incidencia 1776  

                 //conectorActionParametro("accion","SecuenciarOferta");
                 //traza ("----------> ConectorActionParametro");
                  
                 if (dtoS.getOfertasOrdenadas().equals(Boolean.TRUE)){                     
                     throw new MareException(new Exception(),50006);
                 }
                 //INC 10878
                                else
                           throw new MareException(new Exception(),50007);
                   
     }
     

    /**
    * Imprime el stack trace en caso de errores.
    */
//***********************************************************************************
 private void cargarDatos() throws Exception {   

        // RECUPERA DE SECCION LOS SIGUIENTES DATOS

      traza ("Entra al cargar datos");
      
        
      this.canal = conectorParametroSesion("descripcionCanal") == null?"":conectorParametroSesion("descripcionCanal").toString();
      this.marca = conectorParametroSesion("descripcionMarca")== null?"":conectorParametroSesion("descripcionMarca").toString();
      this.pais2 = conectorParametroSesion("descripcionPais") == null?"":conectorParametroSesion("descripcionPais").toString();
      this.periodo = conectorParametroSesion("descripcionPeriodo")== null?"":conectorParametroSesion("descripcionPeriodo").toString();
      this.oidCabeceraMF = (conectorParametroSesion("oidCabeceraMF") == null || conectorParametroSesion("oidCabeceraMF").equals(""))?
              null: (Long)(conectorParametroSesion("oidCabeceraMF"));

        // ASIGNO LOS LABEL A LA PAGINA 
        traza("CANAL: " + canal);
        traza("MARCA: " + marca);
        traza("PAIS: " + pais2);
        traza("PERIODO: " + periodo);
        traza("OIDCABECERAMF: " + oidCabeceraMF);
        //-----------------------------------------------------------------------------------
        asignarAtributo("LABELC","lblMarcaX","valor",marca);
        asignarAtributo("LABELC","lblCanalX","valor",canal);
        asignarAtributo("LABELC","lblPaisX","valor",pais2);
        asignarAtributo("LABELC","lblPeriodoX","valor",periodo);


        asignarAtributo("VAR","oidCabeceraMF","valor",oidCabeceraMF==null?"":oidCabeceraMF.toString());

    }

//***********************************************************************************
    private void logStackTrace(Throwable e) throws Exception {
      traza("Se produjo la excepcion: " + e.getMessage());

      ByteArrayOutputStream pila = new ByteArrayOutputStream();
      PrintStream out = new PrintStream(pila);
      if (e instanceof MareException) {
        MareException e2=(MareException)e;
        traza("Es una mare Exception con codigo de error: "+e2.getCode());
      }
      e.printStackTrace(out);
      traza("stack Trace : " +  pila.toString());
    }

    // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
    private void agregarMenuComplementario() throws Exception{
        if(conectorParametroSesion("descripcionPeriodo")!=null){
            DOMXPath xform = new DOMXPath("//PAGINA/FORMULARIO[VAR[@nombre='conectorAction']]");
            Element formulario = (Element)xform.selectSingleNode(getXML());
            if(formulario != null)
            {
                DOMXPath xpath = new DOMXPath("//VAR[@nombre='SICC_CUSTOM_TITTLE']");
                Node var = (Node)xpath.selectSingleNode(getXML());
                if(var == null)
                {
                    var = getXML().createElement("VAR");
                    ((Element)var).setAttribute("nombre", "SICC_CUSTOM_TITTLE");
                }
                ((Element)var).setAttribute("valor", (String)conectorParametroSesion("descripcionPeriodo"));
                
                formulario.appendChild(var);
            }
        }
    }
    // Fin agregado SICC20070322
}






