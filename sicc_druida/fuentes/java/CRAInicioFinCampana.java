import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;
import java.util.Calendar;
import java.util.GregorianCalendar;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;
import java.util.Vector;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class CRAInicioFinCampana extends LPSICCBase {           
   public CRAInicioFinCampana() {	 
     super();
  }

  public void inicio() throws Exception { 
     
  }

  public void ejecucion() throws Exception {		
     String accion = conectorParametroLimpia("accion","", true);
     setTrazaFichero();
     try {
        this.rastreo();
        
        if (accion.equals("generar")){
           generarReporte(); 
           traza("termino de generar el reporte");
          //cargarPagina();
        }else{
           cargarPagina();
           getConfiguracionMenu("CRAInicioFinCampana");
        }
     
     } catch (Exception ex) {
     			
        cargarPagina();
        getConfiguracionMenu("CRAInicioFinCampana");
               
        ByteArrayOutputStream stack = new ByteArrayOutputStream();
		    PrintStream out = new PrintStream(stack);
			  ex.printStackTrace(out);
	      traza("EXCEPCION:" + stack.toString());
		    lanzarPaginaError(ex);
      /*  try{
            cargarPagina();
        }catch(Exception e){
            e.printStackTrace();
        }*/

     }

    
  }
  
  private void cargarPagina() throws Exception{
      pagina("contenido_informe_inicio_fin_campana_generar");   
    
      ComposerViewElementList cv = crearParametrosEntrada();
      ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
      conector.ejecucion();
      DruidaConector resultados = conector.getConector();
      traza(" 4 " + resultados.getXML());
           
      asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");             
      asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
      asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
          
      Calendar calendar = new GregorianCalendar(); 
      int anio;
      anio = calendar.get(Calendar.YEAR);
      
      asignarAtributo("VAR", "anioDefault", "valor", new String(""+ anio));     
            
      this.generarHiddenFormatoFecha();
      
      DTOBelcorp dto = new DTOBelcorp();
     
      dto.setOidPais(UtilidadesSession.getPais(this));
      dto.setOidIdioma(UtilidadesSession.getIdioma(this));
     
      Vector vec = new Vector();
     
      MareBusinessID idPais = new MareBusinessID("REPRecuperarPaises");
      dto.setOidIdioma(UtilidadesSession.getIdioma(this));
          
      vec.add(dto);
      vec.add(idPais);
     
      DTOSalida dtoSalPais = (DTOSalida)conectar("ConectorPaises",vec).objeto("dtoSalida"); 
         
      RecordSet pais = (RecordSet)dtoSalPais.getResultado();
      Vector colPAIS = pais.getColumnIdentifiers();
      DruidaConector paises = generarConector("DTOSalida.paises_ROWSET",pais, colPAIS);
      asignar("COMBO", "cbPais", paises, "DTOSalida.paises_ROWSET");  
      
           
   
  }
  
  
 
  private ComposerViewElementList crearParametrosEntrada() throws Exception{
     traza("metodo crearParametrosEntrada() ");
     DTOBelcorp dtoBel = new DTOBelcorp();
     
     dtoBel.setOidPais(UtilidadesSession.getPais(this));
     dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));
       
     ComposerViewElementList lista = new ComposerViewElementList();
     
     //Carga de combo marca
     ComposerViewElement cbMarca = new ComposerViewElement();
     cbMarca.setIDBusiness("SEGConsultaMarcas");
     cbMarca.setDTOE(dtoBel);
     
     //Carga de combo canales
     ComposerViewElement cbCanales = new ComposerViewElement();
     cbCanales.setIDBusiness("SEGConsultaCanales");
     cbCanales.setDTOE(dtoBel);
                          
     lista.addViewElement(cbMarca);
     lista.addViewElement(cbCanales);   
        
     
     return lista;
  }
         
  
 private void generarReporte() throws Exception{
     
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "CRA");
     
     //comienzo de los parametrso de filtrado
     
     String pais        = conectorParametroLimpia("pais", "", true);
     datos.put(ConstantesREP.PAISES, pais);     
        
     String anio        = conectorParametroLimpia("anio", "", true);
     datos.put(ConstantesREP.ANIO, anio);     
         
     String canal        = conectorParametroLimpia("canal", "", true);
     datos.put(ConstantesREP.CANAL, canal);     
         
     String acceso        = conectorParametroLimpia("acceso", "", true);
	 if(!acceso.equals("")){
        datos.put(ConstantesREP.ACCESO, acceso);     
	 }

              
     String marca        = conectorParametroLimpia("marca", "", true);
     datos.put(ConstantesREP.MARCA, marca);     
     
        
     String periodo        = conectorParametroLimpia("periodo", "", true);
     if(!periodo.equals("")){
        datos.put(ConstantesREP.PERIODOS, periodo);     
     }

     String opcionesImpresion        = conectorParametroLimpia("opcionesImpresion", "", true);
     
   
     if(!opcionesImpresion.equals("2")){
	    String fechaInicioPV        = conectorParametroLimpia("fiPeriodoVenta", "", true);
        if(!fechaInicioPV.equals("")){
           datos.put(ConstantesREP.FECHAINICIOPERIODOVENTA, fechaInicioPV);     
        }
	 }
          
	 if(!opcionesImpresion.equals("2")){
   	    String fechaFinPV        = conectorParametroLimpia("ffPeriodoVenta", "", true);
	    if(!fechaFinPV.equals("")){
           datos.put(ConstantesREP.FECHAFINPERIODOVENTA, fechaFinPV);     
        }
	 }
     
     if(!opcionesImpresion.equals("3")){
	    String fechaInicioPF        = conectorParametroLimpia("fiPeriodoFacturacion", "", true);
		if(!fechaInicioPF.equals("")){
		   datos.put(ConstantesREP.FECHAINICIOPERIODOFACTURACION, fechaInicioPF);     
		}
     }

     if(!opcionesImpresion.equals("3")){ 
        String fechaFinPF        = conectorParametroLimpia("ffPeriodoFacturacion", "", true);
        if(!fechaFinPF.equals("")){
           datos.put(ConstantesREP.FECHAFINPERIODOFACTURACION, fechaFinPF);     
        }
	 }
     
     

     String reporte = null;
     
     if(opcionesImpresion.equals("1")){
        reporte = "RD_REP-001_01";
     }
     
     if(opcionesImpresion.equals("2")){
        reporte = "RD_REP-001_02";
     }
     
     if(opcionesImpresion.equals("3")){
        reporte = "RD_REP-001_03";
     }
     
     
     datos.put(ConstantesREP.TITULO, "Inicio y fin de Campaña");   
     traza("++++++Antes de enviar a reportes " + datos); 
     //ejecutarReporte(datos, "REPGenerarReporte", reporte, null);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", reporte, "pdf");
          
  } 
  
  private DruidaConector generarConector(String rowsetID, RecordSet datos,
          Vector columns) throws DOMException, Exception {
          StringBuffer salida = new StringBuffer();

          int sizeColums = datos.getColumnCount();
          int sizeRows = datos.getRowCount();

          if (columns == null) {
              columns = new Vector();
          }

          Vector columsDesc = datos.getColumnIdentifiers();

          DruidaConector conectorValoresPosibles = new DruidaConector();
          XMLDocument xmlDoc = new XMLDocument();
          Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");
          Element e_rows = docDestino.createElement("ROWSET");
          e_rows.setAttribute("ID", rowsetID);
          docDestino.getDocumentElement().appendChild(e_rows);

          for (int i = 0; i < sizeRows; i++) {
              Element e_row = docDestino.createElement("ROW");
              e_rows.appendChild(e_row);

              for (int j = 0; j < sizeColums; j++) {
                    if (columns.contains(columsDesc.elementAt(j))) {
                         Element e_campo2 = docDestino.createElement("CAMPO");
                         e_campo2.setAttribute("NOMBRE",
                              columsDesc.elementAt(j).toString());
                         e_campo2.setAttribute("TIPO", "OBJECTO");
                         e_campo2.setAttribute("LONGITUD", "50");

                         Text txt = docDestino.createTextNode(((datos.getValueAt(i, j) == null)
                                    ? "" : datos.getValueAt(i, j).toString()));
                         e_campo2.appendChild(txt);
                         e_row.appendChild(e_campo2);
                    }
              }
          }

          conectorValoresPosibles.setXML(docDestino.getDocumentElement());

          return conectorValoresPosibles;
    }
  
 


}
