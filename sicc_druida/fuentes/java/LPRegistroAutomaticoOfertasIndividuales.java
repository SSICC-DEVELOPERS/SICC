
import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.pre.DTOCabecCatal;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Vector;

import org.jaxen.dom.DOMXPath;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class LPRegistroAutomaticoOfertasIndividuales extends LPSICCBase {
    String accion = null;
//***********************************************************************************  
    public LPRegistroAutomaticoOfertasIndividuales()  {
        super();
    }  
//***********************************************************************************
    public void inicio() throws Exception {
           this.pagina("contenido_registro_automatico");
    }
//***********************************************************************************
    public void ejecucion() throws Exception {
        setTrazaFichero();
        try{
            rastreo(); 
            accion = conectorParametro("accion")==null?"":conectorParametro("accion");
  
            if (accion.equals("")) {
                conectorAction("LPSeleccionarMF");
                conectorParametroSesion("UltimaLP","LPRegistroAutomaticoOfertasIndividuales");
                conectorActionParametro("nueva","true");
            
            }else if (accion.equals("Matriz seleccionada")){
                //guardar();
				cargarCatalogo();
            }else if (accion.equals("CatalogoSeleccionado")){
				guardar();
			}

            // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
            agregarMenuComplementario();
            // Fin agregado SICC20070322

        }catch(Exception ex){
            logStackTrace(ex);
            this.lanzarPaginaError(ex);
        }

    }
//***********************************************************************************
    private void guardar() throws Exception{

        this.pagina("contenido_registro_automatico");

        traza("===========> ENTRA AL GUARDAR"); 

        MareBusinessID id = new MareBusinessID("PRERegistrarOfertasIndividuales");
        //DTOOID dto = new DTOOID();
		String sCatalogo = null; 
		Long oidCatalogo = null; 
		sCatalogo = conectorParametroLimpia("cbCatalogo","",true);
		traza(" >>>>Catalogo:" + sCatalogo);
		if (!sCatalogo.equals("")){
			oidCatalogo = new Long (sCatalogo);	
		}

		DTOCabecCatal dto  = new DTOCabecCatal();
        dto.setOidCabecera((Long)conectorParametroSesion("oidCabeceraMF"));
		dto.setOidPais(UtilidadesSession.getPais(this)); 
        dto.setOidIdioma(UtilidadesSession.getIdioma(this));
		dto.setOidCatalogo (oidCatalogo); 

        Vector param = new Vector();
        param.add(dto);
        param.add(id);
        traza (dto);
        // ver el tema de conector
        conectar("ConectorGenerico",param);
        traza("se ha guardado con exito, volvemos a seleccionar matriz de facturación");
        
    }
    /**
    * Imprime el stack trace en caso de errores.
    */
    
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

	private void cargarCatalogo() throws Exception {
	  traza(" >>>>Entra en cargarCatalogo ");
	  this.pagina("contenido_catalogo_seleccion"); 
	  this.getConfiguracionMenu("LPRegistroAutomaticoOfertasIndividuales","");
	  this.asignarAtributoPagina("cod","PreCatal.lov.label");
	  ComposerViewElementList cv = crearParametrosEntrada();
	  traza(" >>>Se crearon Parametros de Entrada ");
	  ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
	  conector.ejecucion();
	  traza(" >>>Se ejecuto el conector ");
	  DruidaConector resultados = conector.getConector();
	  asignar("COMBO", "cbCatalogo", resultados, "MAVCargarCatalagosBP");
	  asignarAtributo("VAR","lpOrigen","valor","LPRegistroAutomaticoOfertasIndividuales");
	  traza(" >>>Se asignaron los valores ");

   }

   private ComposerViewElementList crearParametrosEntrada() throws Exception {
		ComposerViewElementList lista = new ComposerViewElementList(); 
		DTOBelcorp dtobcp = new DTOBelcorp();
		UtilidadesSession sesion = new UtilidadesSession();

		dtobcp.setOidIdioma(sesion.getIdioma(this));
		dtobcp.setOidPais(sesion.getPais(this));

		ComposerViewElement ci1 = new ComposerViewElement();
		ci1.setIDBusiness("MAVCargarCatalagosBP");          
		ci1.setDTOE(dtobcp);
		lista.addViewElement(ci1);

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
