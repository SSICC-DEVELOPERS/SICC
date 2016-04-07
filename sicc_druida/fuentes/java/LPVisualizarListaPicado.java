import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.logicanegocio.ape.ConstantesAPE;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;


import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.mare.common.exception.MareException;

import java.util.Vector;
import java.util.HashMap;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.util.DTOBoolean;

public class LPVisualizarListaPicado extends LPSICCBase {
    private Long pais = null;
    private Long idioma = null;
    private String accion =null;  
    private String soidCabeceraSolicitud = null;
    private Long oidCabeceraSolicitud = null;
    private String operacion = null;
    
    
    public void inicio() throws Exception{
    }

    public LPVisualizarListaPicado() {
         super();
    }
  
    public void ejecucion() throws Exception {
         traza("Entra a LPVisualizarListaPicado");
         String accion = conectorParametroLimpia("accion","", true);
         setTrazaFichero();
         try {
            this.rastreo();
            
            if (accion.equals("generar")){
               generarReporte(); 
               traza("termino de generar el reporte");
            }else if (accion.equals("validar")) {
                pagina("salidaGenerica");
        
                String txtTerritorio = conectorParametroLimpia("txtTerritorio", "", true);
                traza("txtTerritorio: " + txtTerritorio );
                
                DTOOID dtoOid = new DTOOID();
                dtoOid.setOid(new Long(txtTerritorio));
                 
                Vector parametros = new Vector();
                parametros.add(dtoOid);
                parametros.add(new MareBusinessID("APEValidarTerritorio"));
        
                traza("*** antes de conectar para validar territorio");
                DruidaConector conector = conectar("ConectorValidarTerritorio", parametros);
                traza("*** despues de conectar para validar territorio");
                 
                DTOBoolean existeTerritorio = (DTOBoolean)conector.objeto("DTOBoolean");
    
                if (existeTerritorio.getValor()) {
                    asignarAtributo("VAR", "ejecutar", "valor", "noExisteTerritorio();");            
                }else{
                    asignarAtributo("VAR", "ejecutar", "valor", "existeTerritorio();");               
                }
    
            }else {
              cargarPagina();
            }
         
         } catch (Exception ex) {
                    
            ByteArrayOutputStream stack = new ByteArrayOutputStream();
                PrintStream out = new PrintStream(stack);
                  ex.printStackTrace(out);
              traza("EXCEPCION:" + stack.toString());
                lanzarPaginaError(ex);
         }
  }    

    private void cargarPagina() throws Exception{
         pagina("contenido_picado_lista");
    
         pais=UtilidadesSession.getPais(this);
         idioma=UtilidadesSession.getIdioma(this);
         
         asignarAtributoPagina("cod", "0601");
         asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
         asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
         
         cargarCombos();
         getFormatosValidaciones();
         getConfiguracionMenu("LPVisualizarListaPicado");         
  }    

    private void generarReporte() throws Exception{
         traza("*** LPVisualizarListaPicado.generarReporte() - Entrada ***");
         HashMap datos = new HashMap();
    
         //comienzo de los parametrso de filtrado
         datos.put(ConstantesREP.PAIS, pais);     
         String consolidado   = conectorParametroLimpia("consolidado", "", true);
         String centroDist = conectorParametroLimpia("centroDist", "", true);
         String lineaArmado = conectorParametroLimpia("lineaArmado", "", true);
         String periodo = conectorParametroLimpia("periodo", "", true);
         String fechaValorDesde = conectorParametroLimpia("fechaValorDesde", "", true);
         String fechaValorHasta = conectorParametroLimpia("fechaValorHasta", "", true);
         String territorio = conectorParametroLimpia("territorio", "", true);
         
         if (consolidado != null && !"".equals(consolidado)){
             traza("*** consolidado" + consolidado);         
             datos.put("CONSOLIDADOVALUE", consolidado);     
         }
         if (centroDist != null && !"".equals(centroDist)){
             traza("*** centroDist" + centroDist);
             datos.put("CENTROVALUE", centroDist);          
         }
         if (lineaArmado != null && !"".equals(lineaArmado)){
             traza("*** lineaArmado" + lineaArmado);
             datos.put("LINEAVALUE", lineaArmado);          
         }
         if (periodo != null && !"".equals(periodo)){
             traza("*** periodo" + periodo);
             datos.put("PERIODOVALUE", periodo);     
         }
         if (fechaValorDesde != null && !"".equals(fechaValorDesde)){
             traza("*** fechaValorDesde" + fechaValorDesde);         
             datos.put("FDESDEVALUE",fechaValorDesde);
         }
         if (fechaValorHasta != null && !"".equals(fechaValorHasta)){
             traza("*** fechaValorHasta" + fechaValorHasta);
             datos.put("FHASTAVALUE",fechaValorHasta);
         }
         if (territorio != null && !"".equals(territorio)){
             traza("*** territorio" + territorio);
             datos.put("TERRITORIOVALUE",territorio);          
         }
     
         datos.put("MODULO", "APE");
         datos.put(ConstantesREP.TITULO, "Lista Picado");  
         
         String formatoSalida = conectorParametroLimpia("formatoSalida", "", true);
         String formato = null;
         
         if(formatoSalida.equals("xls")){
            datos.put(ConstantesREP.FORMATOSALIDA, "EXCEL");
            formato = "xls";
         }else{
            formato = "pdf";
         }
    
         traza("++++++Antes de enviar a reportes " + datos); 
         ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_APE-014", formato);
    
         traza("*** LPVisualizarListaPicado.generarReporte() - Salida ***");
    } 

	private void cargarCombos() throws Exception {
         traza("*** LPVisualizarListaPicado.cargarCombos() - Entrada ***");
            
         Vector dtos = new Vector();
         DTOBelcorp dtoBelcorp = new DTOBelcorp();
         dtoBelcorp.setOidIdioma(idioma);
         dtoBelcorp.setOidPais(pais);
    
         String[] idBusiness = new String[] {"APEObtenerDescripcionesCD","SEGObtenerMarcasSinFiltro",
                                             "SEGObtenerCanalesSinFiltro"};
         String[] comboBox = new String[] {"cbCentroDistribucion", "cbMarca", "cbCanal" };                
    
         cargarCombos(dtoBelcorp, idBusiness, comboBox, null, null);
         /*
            * Recupero el valor por defecto para el combo cbCentroDistribucion
            * y lo asigno a la variable hidden.
            * NOTA (dmorello, 19/01/2007):
            * En el DMCO se indica hacerlo usando ConectorComposerView
            * pero se optó por esta forma, ya que así es como viene haciéndose.
            * Esta forma de implementar hizo necesario crear el
            * ConectorObtenerValoresDefecto, que no figura en el modelo.
            * 
            */
           //  Ejecuto esto sólo cuando no voy a levantar la modal.
         
         Vector parametros = new Vector();
         parametros.add(dtoBelcorp);
         parametros.add(new MareBusinessID("APEObtenerValoresDefecto"));
      
         traza("*** antes de conectar para obtener valores por defecto");
         DruidaConector conector2 = conectar("ConectorObtenerValoresDefecto", parametros);
         traza("*** despues de conectar para obtener valores por defecto");
    
         DTOSalida dtoSalida = (DTOSalida)conector2.objeto("DTOSalida");
         RecordSet rs = dtoSalida.getResultado();
         traza("*** rs: " + rs);
    
         /*
            * Aqui guardo todas las lineas de armado por defecto
            * Los OIDs van separados por pipes y luego se envian a la pagina
         */
         StringBuffer lineasDef = new StringBuffer();
         int size = rs.getRowCount();
         for (int i = 0; i < size; i++) {
                 Object combo = rs.getValueAt(i, "COMBO");
                 if (ConstantesAPE.CONFIGURACION_CD.equals(combo)) {
                          asignar("VAR", "hOidCentroDistribucionDefecto", rs.getValueAt(i, "OID").toString());
                 } else if (ConstantesAPE.LINEA_ARMADO.equals(combo)) {
                          lineasDef.append(rs.getValueAt(i, "OID").toString()).append('|');
                 }
         }
    
         // Borro el ultimo pipe, a fin de hacer un split en JavaScript
         int length = lineasDef.length();
         if (length > 0) {
                 lineasDef.delete(length-1, length);
         }
         asignar("VAR", "hOidsLineasArmadoDefecto", lineasDef.toString());
         // Fin 
    
    
         traza("*** LPVisualizarListaPicado.cargarCombos() - Salida ***");
	}

        
    private void cargarCombos(DTOBelcorp dto, String[] idBusiness, String[] comboBox, String[] column, String[] selected) throws Exception {
         traza("*** Entrada - LPVisualizarListaPicado - cargarCombos ***");
    
         ComposerViewElementList list = new ComposerViewElementList();
         ComposerViewElement element = null;
    
         for (int i = 0; i < idBusiness.length; i++) { 
            element = new ComposerViewElement(); 
            element.setIDBusiness(idBusiness[i]);
            traza("*** idBusiness[i]: , " + idBusiness[i]);
            element.setDTOE(dto);
            list.addViewElement(element);
         }
    
         traza("***dto : , " + dto);
    
         // Obtener un RowSet que contiene los datos solicitados por list.
         ConectorComposerView ccv = new ConectorComposerView(list, this.getRequest());
    
         ccv.ejecucion();
         DruidaConector dc = ccv.getConector();
    
         // Asignar los datos obtenidos a los combos.
         if (selected != null && column != null) {
            for (int i = 0; i < comboBox.length; i++) {
                if (selected[i] != null && column[i] != null) {
                    asignar("COMBO", comboBox[i], dc, idBusiness[i], column[i], selected[i]);
                } else {
                    asignar("COMBO", comboBox[i], dc, idBusiness[i]); 
                }
            }   
         } else {
            for(int i = 0; i < comboBox.length; i++) {
                asignar("COMBO", comboBox[i], dc, idBusiness[i]); 
            }
         }
         traza("*** Salida - LPVisualizarListaPicado - cargarCombos ***");
}   
         
    private void logStackTrace(Throwable e) throws Exception {
         traza("Se produjo la excepcion: " + e.getMessage());

         ByteArrayOutputStream pila = new ByteArrayOutputStream();
         PrintStream out = new PrintStream(pila);
    
         if (e instanceof MareException) {
            MareException e2 = (MareException) e;
            traza("Es una mare Exception con codigo de error: " + e2.getCode());
         }
    
         e.printStackTrace(out);
         traza("stack Trace : " + pila.toString());
    }
}
