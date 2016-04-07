/**
 * Version 3.0
 *	LPInsertarRangoTipos
 *  Auto: ALem Joaquin
 *
 */


//import LPSICCBase;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Vector;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


public class LPSeleccionarEstrategia extends LPSICCBase {

    private Long oidPais = null;
    private String accion = null;
    private Long oidEstrategia = null;
    private String descripcionEstrategia = null;


    ////// CONSTRUCTOR  //////////

    public LPSeleccionarEstrategia()  {
        super();
    }  

    //////  METODO INICIO PARA CARGAR LA PAGINA    //////////
    public void inicio() throws Exception {
        this.pagina("contenido_estrategia_seleccionar");
    }

    //// METODO EJECUCCION //////
    public void ejecucion() throws Exception {   
          try {
              // CREA EL CONECTOR 
              DruidaConector conectorBuscarEstrategias = null;
              setTrazaFichero();
              accion = conectorParametro("accion");
              if (accion == null)
                 accion = "";
              traza("Accion: " + accion);	
              if (accion.equals("")) {
                      getFormatosValidaciones();
                      getConfiguracionMenu("LPSeleccionarEstrategia");

                      // Crea el idBusiness = "PREBuscarEstrategias"          
                      MareBusinessID id = new MareBusinessID("PREBuscarEstrategias");

                      Vector paramEntrada   = new Vector();

                      DTOBelcorp dtoe = new DTOBelcorp();
                      // Recupero de la seccion el oidPais, aca esta Harcodeado ya que me falta el menu
                      this.oidPais = UtilidadesSession.getPais(this);

                      dtoe.setOidPais(oidPais);

                      dtoe.setOidIdioma(UtilidadesSession.getIdioma(this));
            
                      paramEntrada.addElement(dtoe);
                      paramEntrada.addElement(id);                      
                      
                      conectorBuscarEstrategias  = conectar("ConectorBuscarEstrategias", paramEntrada);
                      traza("conecto");
                      // Asigna al Combo de la Pagina el resultado del Rowset 
                       MareDTO dtoSalida = (MareDTO) conectorBuscarEstrategias.objeto("dtoSalida");
                      
                       RecordSet estrategias = (RecordSet)dtoSalida.getProperty("resultado");
                      

                       asignar("COMBO", "cbEstrategia", UtilidadesBelcorp.generarConector("dtoSalida.resultado_ROWSET",estrategias,estrategias.getColumnIdentifiers()),"dtoSalida.resultado_ROWSET");
                    }
                     else if (accion.equals("Guardar"))
                     {
                          oidEstrategia = Long.valueOf(conectorParametro("oidEstrategia"));
                      
                          descripcionEstrategia = conectorParametro("descripcionEstrategia")==null?"":conectorParametro("descripcionEstrategia");
                      
                          // Guarda en sesion los datos de la estrategia seleccionada:        
                          conectorParametroSesion("oidEstrategia",oidEstrategia);
                          conectorParametroSesion("descripcionEstrategia",descripcionEstrategia);

                          // Recoge de sesion la ultima LP invocada (variable UltimaLP) y la activa con accion = "Estrategia seleccionada"

                          traza("voy a llamar a la ultima LP");
                          conectorAction((String)conectorParametroSesion("UltimaLP"));
                          conectorActionParametro("accion","EstrategiaSeleccionada");
                     }

                // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
                agregarMenuComplementario();
                // Fin agregado SICC20070322

            }catch (Exception ex) {
            logStackTrace(ex);
            
               this.lanzarPaginaError(ex);
            } 

        }

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
