
import es.indra.druida.Contexto;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.pre.ConstantesPRE;
import es.indra.sicc.dtos.pre.DTOEFicheroGP;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import java.lang.reflect.InvocationTargetException;

import java.util.Vector;

import jxl.Workbook;

import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.jaxen.dom.DOMXPath;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class LPDescargarGP extends LPSICCBase {

   private int COLUMNAS_TOTALES = 4;
   public LPDescargarGP() {
      super();
   }

   public void inicio() throws Exception {
      setTrazaFichero();
   }

   public void ejecucion() throws Exception {
      setTrazaFichero();
      String accion = conectorParametroLimpia("accion", "", true);
      if (accion.equals("")) {
         conectorParametroSesion("UltimaLP", "LPDescargarGP");
         conectorAction("LPSeleccionarMF");
         conectorActionParametro("nueva", "false");
      }
	  if (accion.equals("Matriz seleccionada")) {
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

	  }//[1] if (accion.equals("Matriz seleccionada")) {
      else if (accion.equals("CatalogoSeleccionado")) { 
         try{
            getFichero();
         }catch(Exception e){
            System.out.println("Poruqe no me muestra el error");
            logStackTrace(e);
            pagina("salidaGenerica");
            asignarAtributo("VAR","cerrarVentana","valor","false");
            asignarAtributo("VAR","generarGuiaProducto","valor","true");
            lanzarPaginaError(e);
         }
      }
        // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
        agregarMenuComplementario();
        // Fin agregado SICC20070322
   }

   private void getFichero()throws Exception{

		try{
			traza(" >>>>Entra en getFichero ");
			Long oidCabeceraMF = (new Long(conectorParametroSesion("oidCabeceraMF").toString()));
			String sCatalogo = null; 
			Long oidCatalogo = null; 
			sCatalogo = conectorParametroLimpia("cbCatalogo","",true);
			traza(" >>>>Catalogo:" + sCatalogo);
			if (!sCatalogo.equals("")){
				traza(" >>>>Catalogo != null");
				oidCatalogo = new Long (sCatalogo);	
			}
			traza(" >>>>Obtuve oidCatalogo "  + oidCatalogo);

			MareBusinessID id = new MareBusinessID("PREGenerarCabeceraGP");
			DTOEFicheroGP dto = new DTOEFicheroGP();
			traza(" >>>>Obtuve oidCatalogo ");
			dto.setOidCabeceraMF(oidCabeceraMF);
			dto.setOidIdioma(UtilidadesSession.getIdioma(this));
			dto.setOidCatalogo (oidCatalogo); 
			traza(" >>>>Obtuve oidCatalogo ");
			Vector params = new Vector();
			params.add(dto);
			params.add(id);
			//obtengo la cabecera
			DruidaConector dc1 = conectar("ConectorFicheroGP", params);
			traza(" >>>>Obtuve la cabecera ");
			//ahora obtengo el contenido del archivo
			Vector paramos = new Vector();
			DTOEFicheroGP dto1 = new DTOEFicheroGP();
			dto1.setOidCabeceraMF(oidCabeceraMF);
			dto1.setOidIdioma(UtilidadesSession.getIdioma(this));
			dto1.setIndicadorSituacion(new Long(0));
			dto1.setTamanioPagina(new Integer(ConstantesPRE.PAQUETE_FICHERO_GP));
			dto1.setOidCatalogo (oidCatalogo);
			id = new MareBusinessID("PREGenerarGP");
			paramos.add(dto1);
			paramos.add(id);
			DruidaConector dc2 = conectar("ConectorFicheroGP2", paramos);
			traza(" >>>>Obtuve la cabecera2 ");

            String nombreFichero = getNombreFichero();
            WritableWorkbook workbook = Workbook.createWorkbook(new File(Contexto.getPropiedad("DESCARGABLES", "PATH") + nombreFichero)); 
            WritableSheet sheet = workbook.createSheet("Guia Productos", 0); 
            Label label;
            int j;
            int tamanoCabec;
            Node cabecera = dc1.getXML().getElementsByTagName("ROW").item(0);
			NodeList lista = dc2.getXML().getElementsByTagName("ROW");
            
			// CABECERA
            tamanoCabec = cabecera.getChildNodes().getLength();
            for(int i = 0; i<tamanoCabec ;i++){
                label = new Label(i,0, cabecera.getChildNodes().item(i).getFirstChild().getNodeValue());
                sheet.addCell(label); 
			}
            // DETALLE
            int largo = lista.getLength();
			for(int i = 0; i< largo;i++){
                for( j = 0; j<tamanoCabec ;j++){
                    label = new Label(j, i+1, lista.item(i).getChildNodes().item(j).getFirstChild().getNodeValue());
                    sheet.addCell(label); 
                }
			
			}
            workbook.write(); 
            workbook.close();
            
            pagina("salidaGenerica");
            asignarAtributo("VAR","ejecutar","valor","descargar('"+nombreFichero+"')");
           
		}catch(Exception e){
        traza("la clase: "+e.getClass().getName());
        if (e instanceof InvocationTargetException)
            traza(((InvocationTargetException)e).getTargetException().getClass().getName());
        logStackTrace(e); 
        BelcorpError error = new BelcorpError();
        DTOError dtoError = error.obtenerError(e);
        System.out.println("Codigo de Error: "+dtoError.getCodigoError());
        if (dtoError.getCodigoError()!=null && dtoError.getCodigoError().equals("50038")){
            throw new MareException(new Exception(), 50038);
        }else{
            throw new MareException(new Exception(), 50037);
        }
    }
   }
   
   private synchronized String getNombreFichero() throws Exception{
        return "GuiadeProductos"+  System.currentTimeMillis()+ ".xls";
   }
   


   private void logStackTrace(Throwable e) {
      ByteArrayOutputStream os = new ByteArrayOutputStream();
      PrintStream ps = new PrintStream(os);

      e.printStackTrace(ps);
      try {
         traza("Se produjo la excepcion: "
               + e.getMessage()
               + "\n"
               + "stackTrace = "
               + os.toString());
      } catch (Exception ex) {
         //traza ("Error en logStackTrace: " + ex.getMessage ());
         e.printStackTrace();
      }
   }

   	private void cargarCatalogo() throws Exception {
		traza(" >>>>Entra en cargarCatalogo de descarga");
		this.pagina("contenido_catalogo_seleccion_descarga"); 
		this.getConfiguracionMenu("LPRegistroAutomaticoOfertasIndividuales","");
		this.asignarAtributoPagina("cod","PreCatal.lov.label");
		ComposerViewElementList cv = crearParametrosEntrada();
		traza(" >>>Se crearon Parametros de Entrada ");
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		conector.ejecucion();
		traza(" >>>Se ejecuto el conector ");
		DruidaConector resultados = conector.getConector();
		asignar("COMBO", "cbCatalogo", resultados, "MAVCargarCatalagosBP");
		asignarAtributo("VAR","lpOrigen","valor","LPDescargarGP");
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
