

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.pre.DTOProductoVenta;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.jaxen.dom.DOMXPath;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class LPBuscarMatrizCodigosRecuperacion extends LPSICCBase{

  private String accion = "";
  private String LPActual = "";
  private String UltimaLP = "";
 
  public LPBuscarMatrizCodigosRecuperacion(){
  }

  public void inicio() throws Exception{
    pagina("contenido_matriz_codigos_recuperacion_eliminar");
  }

  public void ejecucion() throws Exception{
    setTrazaFichero();
    String accion = conectorParametroLimpia("accion","",true); 
    traza("accion: " + accion);
		asignarAtributo("VAR", "accion", "valor", accion );
		
		String casodeuso = (String)conectorParametroSesion("casodeuso");
		asignarAtributo("VAR", "casodeuso", "valor", casodeuso);
       
		if(casodeuso.equals("consultar")){
      asignarAtributoPagina("cod", "0178");
		}else{
      asignarAtributoPagina("cod", "0138");
		}
		
    try{
      if(accion.equals("")){
        // Acción "" 
        // 1- Asignar pagina "_matriz_codigos_reemplazo_registrar" 
        // 2- Guardar en sesión el nombre de la LP actual y llamar a la LP 
        // "LPSeleccionarMF" perteneciente al caso de uso 
        // "SeleccionarMatrizFacturacion". 
        conectorParametroSesion("UltimaLP", "LPBuscarMatrizCodigosRecuperacion");
        conectorAction("LPSeleccionarMF");
      }else if( accion.equals("Matriz seleccionada") ){
        // Acción "matrizSeleccionada" 
        // 1- Obtener de la sesión el oid de la matriz seleccionada en la 
        // actividad anterior.
        // 2- Mostrar pagina "_matriz_codigos_reemplazo_registrar" vacía 
        String sOidMatriz = ((Long) conectorParametroSesion("oidCabeceraMF")).toString(); 
				traza("contenido del oid de matriz  ::: . " + sOidMatriz);	
      }else if( accion.equals("buscarProductoPrincipal") ){
        // Acción "buscarProductoPrincipal" 
        // 1- Guardar en sesión el nombre de la LP actual en la variable 
        // "UltimaLP" y llamar a la LP "LPBuscarProductosVenta", 
        // accion "buscarProductoPrincipal" .
        conectorParametroSesion("UltimaLP", "LPBuscarMatrizCodigosRecuperacion");
        conectorAction("LPBuscarProductosVenta");
        //conectorActionParametro("accion", "buscarProductoPrincipal");
        conectorActionParametro("accion", "buscarProductoPrincipalRecuparacion");        
      }else if( accion.equals("productoPrincipalSeleccionado") ){
        DTOProductoVenta dtoProductoPrincipal  = (DTOProductoVenta)conectorParametroSesion("DTOProductoVenta");
				asignarAtributo("LABELC", "lblCodigoVentaXX", "valor", dtoProductoPrincipal.getCodigoVenta());
        asignarAtributo("LABELC", "lblDescripcionXX", "valor", dtoProductoPrincipal.getDescripcion());
				asignarAtributo("VAR", "hidOidFacturacion", "valor", dtoProductoPrincipal.getOidMatrizFacturacion().toString());
				asignarAtributo("VAR", "hidCodigoVenta", "valor", dtoProductoPrincipal.getCodigoVenta());
				asignarAtributo("VAR", "hidDescripcion", "valor", dtoProductoPrincipal.getDescripcion());
				asignarAtributo("VAR", "hIdioma", "valor", UtilidadesSession.getIdioma(this).toString());
			} 
        
        // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
        agregarMenuComplementario();
        // Fin agregado SICC20070322
        
    }catch (Exception ex)  {
      logStackTrace(ex);
      this.lanzarPaginaError(ex);
    }
		getConfiguracionMenu("LPBuscarMatrizCodigosRecuperacion");
  }

	public void logStackTrace(Throwable e) throws Exception {
    traza("Se produjo la excepcion: " + e.getMessage());

		ByteArrayOutputStream pila = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(pila);
    
		if (e instanceof MareException){
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
