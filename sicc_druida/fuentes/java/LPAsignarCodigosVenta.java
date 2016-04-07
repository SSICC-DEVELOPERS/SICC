import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.mare.common.exception.MareException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Vector;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.pre.DTOCabecCatal;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class LPAsignarCodigosVenta extends LPSICCBase{
    private String accion = null;
    private Long oidCabecera = null;

//***********************************************************************************
    public void inicio() throws Exception

    { 
        this.pagina("contenido_secuenciar_ofertas");
    }

//***********************************************************************************    
    public void ejecucion() throws Exception{
        try{
            rastreo();
            setTrazaFichero();
            accion = conectorParametro("accion")==null?"":conectorParametro("accion");
            traza("===========> ACCION: "+accion);
            if (accion.equals("")){
                conectorParametroSesion("UltimaLP","LPAsignarCodigosVenta");
                conectorAction("LPSeleccionarMF");
            }if (accion.equals("Matriz seleccionada")|| accion.equals("Matrizseleccionada")) {
                 try{
                  cargarCatalogo(); 
                 }catch(Exception e){
                  System.out.println("cargarCatalogo Poruqe no me muestra el error"); 
                  logStackTrace(e);
                  pagina("salidaGenerica");
                  asignarAtributo("VAR","cerrarVentana","valor","false");
                  asignarAtributo("VAR","generarGuiaProducto","valor","true");
                  lanzarPaginaError(e);
                 }

           } else if (accion.equals("CatalogoSeleccionado")|| accion.equals("Catalogo Seleccionado")){
                asignarAtributo("VAR","cerrar","valor","AsignarCodigoVenta");
                traza ("===========> Entra a Catalogo Seleccionado");
                
                //esto se usa cuando se llama a asignar CV desde consultar orden oferta.
                String cerrar = conectorParametro("origen");
                if (cerrar != null && (!cerrar.equals(""))){
                  asignarAtributo("VAR","cerrar2","valor",cerrar);
                }
                  
                DTOCabecCatal dto = new DTOCabecCatal();

                Object catalogo = conectorParametro("cbCatalogo");				
                Object o = conectorParametroSesion("oidCabeceraMF");
                if (o!=null && o instanceof java.lang.Long){
                    dto.setOidCabecera((Long)o);
                    dto.setOidIdioma(UtilidadesSession.getIdioma(this));
                } else 
                       if (o!=null && o instanceof java.lang.String){               
                                dto.setOidCabecera(Long.valueOf((String)o));
                                dto.setOidIdioma(UtilidadesSession.getIdioma(this));
                       } else {
                                traza("Error");
                                throw new Exception("Error");
                       }
                if (catalogo!=null && catalogo instanceof java.lang.Long){
                    dto.setOidCatalogo((Long)catalogo);
                } else if (catalogo!=null && catalogo instanceof java.lang.String && !catalogo.equals("")){                   
                    dto.setOidCatalogo(Long.valueOf((String)catalogo));
                }                
                Vector vec = new Vector();
                vec.add(dto);
                vec.add(new MareBusinessID("PREAsignarCodigosVenta"));
                traza(vec);
                traza ("===========> Va a conectar");
                
                // VER EL CONECTOR
                conectar("ConectorGenerico",vec);
                          
                }

            // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
            agregarMenuComplementario();
            // Fin agregado SICC20070322
                
        }catch (Exception e){
            logStackTrace(e);
            this.lanzarPaginaError(e);
        }
    } 
//**********************************************************************************

   	private void cargarCatalogo() throws Exception {
		traza(" >>>>Entra en cargarCatalogo ");

		String cerrar = conectorParametro("origen");
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
		asignarAtributo("VAR", "lpOrigen", "valor", "LPAsignarCodigosVenta");
		if (cerrar != null && (!cerrar.equals(""))){
		asignarAtributo("VAR","origen","valor",cerrar);
		}
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
//**********************************************************************************

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
