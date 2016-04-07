

import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.jaxen.dom.DOMXPath;

import org.w3c.dom.Element;
import org.w3c.dom.Node;


public class LPConsultarOrdenOfertas extends LPSICCBase{

    private Long pais = null;
    private Long idioma = null;
    private String soloImprimible = null;


    private String accion=null;
    private Long oidCabeceraMF = null;
    private String pais2 = null;
    private String marca = null;
    private String canal = null;
    private String periodo = null;


    public LPConsultarOrdenOfertas()  {
        super();
    }  

// ================= INICIO ====================================================    
    public void inicio() throws Exception {
        this.pagina("contenido_orden_ofertas_consultar");
    }


// ================= EJECUCCION ====================================================
    public void ejecucion() throws Exception{
        try{
            // Funcion Rastreo
            //rastreo(); 
            
            setTrazaFichero();
            accion = conectorParametro("accion")==null?"":conectorParametro("accion");

            // Seteo el idioma y el pais
            idioma = UtilidadesSession.getIdioma(this);
            pais = UtilidadesSession.getPais(this);
            // Cargo los label con el pais,marca,canal,periodo
            this.cargarDatos();

            // asigno las variables oidPais,oidIdioma de la pantalla

            asignarAtributo("VAR","oidIdioma","valor",idioma.toString());
            asignarAtributo("VAR","oidPais","valor",pais.toString());//BELC300021447 

            traza ("=======> VER EL PAIS");
            traza(idioma);
            traza ("=======> VER EL IDIOMA");
            traza (pais);

            traza("==============>  ACCION: "+ accion);
  
            if (accion.equals("")){

                /* Guardar en sesión el nombre de la LP actual en variable ultimaLP 
                 * y llamar a la LP "LPSeleccionarMF"
                 * perteneciente al caso de uso "SeleccionarMatrizFacturacion" 
                */
                
                traza("==============>  ENTRA ACCION VACIA ");  
                conectorParametroSesion("UltimaLP","LPConsultarOrdenOfertas"); 
                conectorAction("LPSeleccionarMF");
            }
            else if (accion.equals("Matriz seleccionada")){

                traza("==============>  ENTRA ACCION MATRIZ SELECCIONADA ");
                this.pagina("contenido_orden_ofertas_consultar");
                getConfiguracionMenu("LPConsultarOrdenOfertas","");
                this.cargarDatos();
				cargarCatalogoYTiposOferta();
             }

            else if (accion.equals("secuenciarOfertas")){
                traza("==============>  ENTRA SECUENCIAR OFERTAS ");
                conectorParametroSesion("UltimaLP","LPConsultarOrdenOfertas");
                conectorAction("LPSecuenciarOfertas");
                conectorActionParametro("accion","Matriz seleccionada");

                /* ACA DEBERIA ASIGNAR UNA ACCION PARA SABER SI ENTRA AL 
                 * SECUENCIAR OFERTA POR "CONSULTAR ORDEN OFERTAS"
                */
                
            }
            
            else if (accion.equals("definirTextos")){
                traza("==============>  ENTRA DEFINIR TEXTOS ");
                conectorParametroSesion("UltimaLP","LPConsultarOrdenOfertas");
                conectorAction("LPDefinirTextosOfertas");
                conectorActionParametro("accion","Matriz seleccionada");
                
            }
            else if (accion.equals("asignarCodigosVenta")){
                traza("==============>  ENTRA ASIGNAR CODIGOS VENTA ");
                conectorParametroSesion("UltimaLP","LPConsultarOrdenOfertas");
                conectorAction("LPAsignarCodigosVenta");
                conectorActionParametro("accion","Matriz seleccionada");
        
				
            }

            // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
            agregarMenuComplementario();
            // Fin agregado SICC20070322
            
        }catch(Exception e){
              traza ("====> ENTRA AL CARGAR DATOS POR EL ERROR");
              this.cargarDatos();
              logStackTrace(e);
              lanzarPaginaError(e);
        }
    }


// ================= CARGAR DATOS ====================================================
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

// ================= LOG STACK TRACE ====================================================
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

    private void cargarCatalogoYTiposOferta() throws Exception {
        traza(" >>>>Entra en cargarCatalogo y Tipos Oferta Pais ");
        this.getFormatosValidaciones();
        ComposerViewElementList cv = crearParametrosEntrada();
        traza(" >>>Se crearon Parametros de Entrada ");
        ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
        conector.ejecucion();
        traza(" >>>Se ejecuto el conector ");
        DruidaConector resultados = conector.getConector();
        asignar("COMBO", "cbCatalogo", resultados, "MAVCargarCatalagosBP");
        asignar("COMBO", "cbTipoOferta", resultados, "PREObtenerTiposOfertaPorCanal");		
        traza(" >>>Se asignaron los valores ");
    
    }

     private ComposerViewElementList crearParametrosEntrada() throws Exception {
       ComposerViewElementList lista = new ComposerViewElementList(); 
       DTOBelcorp dtobcp = new DTOBelcorp();
        
       dtobcp.setOidIdioma(idioma);
       dtobcp.setOidPais(pais);
      
       ComposerViewElement ci1 = new ComposerViewElement();
       ci1.setIDBusiness("MAVCargarCatalagosBP");          
       ci1.setDTOE(dtobcp);

	   DTOOID dtooid = new DTOOID();

       Long oidCanal = UtilidadesSession.getCanalPorDefecto(this);
	   dtooid.setOid(oidCanal);//oidCanal
       dtooid.setOidIdioma(idioma);
       dtooid.setOidPais(pais);

       ComposerViewElement ci2 = new ComposerViewElement();
       ci2.setIDBusiness("PREObtenerTiposOfertaPorCanal");          
       ci2.setDTOE(dtooid);

       lista.addViewElement(ci1);
       lista.addViewElement(ci2);
      
        return lista;    
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
