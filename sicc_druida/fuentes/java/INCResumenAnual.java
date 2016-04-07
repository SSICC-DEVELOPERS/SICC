import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;
import java.util.Vector;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class INCResumenAnual extends LPSICCBase {

  public INCResumenAnual() {
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
        getConfiguracionMenu("INCResumenAnual");
      }
      
    } catch (Exception ex) {
     			
      //pagina("contenido_informe_resumen_anual_generar");
      //getConfiguracionMenu("INCResumenAnual");
               
      ByteArrayOutputStream stack = new ByteArrayOutputStream();
      PrintStream out = new PrintStream(stack);
      ex.printStackTrace(out);
      traza("EXCEPCION:" + stack.toString());
      lanzarPaginaError(ex);
      
      /*try{
        cargarPagina();
      }catch(Exception e){
        e.printStackTrace();
      }*/
    
    }
    
  }
  
  private DruidaConector generarConector(String rowsetID, RecordSet datos,Vector columns) throws DOMException, Exception {
  
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
          e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
          e_campo2.setAttribute("TIPO", "OBJECTO");
          e_campo2.setAttribute("LONGITUD", "50");
          
          Text txt = docDestino.createTextNode(((datos.getValueAt(i, j) == null)? "" : datos.getValueAt(i, j).toString()));
          e_campo2.appendChild(txt);
          e_row.appendChild(e_campo2);
        }
      }
    }
   
    conectorValoresPosibles.setXML(docDestino.getDocumentElement());

    return conectorValoresPosibles;
  
  }
  
  private void cargarPagina() throws Exception{
    
    pagina("contenido_informe_resumen_anual_generar");
    
    asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
    asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
    
    //asignarAtributo("LABELC", "lbldtPais", "valor", UtilidadesSession.getDescripcionPais(this));
        
    ComposerViewElementList cv = crearParametrosEntrada();
    ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
    conector.ejecucion();
    DruidaConector resultados = conector.getConector();
    traza(" 4 " + resultados.getXML());
    
    asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");
    asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
    
    
    //DTOs
    DTOBelcorp dto = new DTOBelcorp();
    dto.setOidPais(UtilidadesSession.getPais(this));
    dto.setOidIdioma(UtilidadesSession.getIdioma(this));
    
    Vector vec = new Vector();
    
    // Carga Paises        
    MareBusinessID idPais = new MareBusinessID("REPRecuperarPaises");
    dto.setOidIdioma(UtilidadesSession.getIdioma(this));
      
    vec.add(dto);
    vec.add(idPais);
    
    DTOSalida dtoSalPais = (DTOSalida)conectar("ConectorPaises",vec).objeto("dtoSalida"); 
     
    RecordSet pais = (RecordSet)dtoSalPais.getResultado();
    Vector colPAIS = pais.getColumnIdentifiers();
    DruidaConector paises = generarConector("DTOSalida.paises_ROWSET",pais, colPAIS);
    asignar("COMBO", "cbPais", paises, "DTOSalida.paises_ROWSET");  
    
    
    this.getFormatosValidaciones();
    
     
    Calendar calendar = new GregorianCalendar(); 
    int anio;
    anio = calendar.get(Calendar.YEAR);
    asignarAtributo("VAR", "anioDefault", "valor", new String(""+ anio));   
    
    
  }
  
  private void generarReporte() throws Exception{
    
    HashMap datos = new HashMap();
    datos.put("MODULO", "INC");
    
    String anio = conectorParametroLimpia("anio", "", true);
    datos.put(ConstantesREP.ANIO, anio);
     
    String pais = conectorParametroLimpia("pais", "", true);
    datos.put(ConstantesREP.PAIS, pais);
    
    String paisDesc = conectorParametroLimpia("paisDesc", "", true);
     
    String marca = conectorParametroLimpia("marca", "", true);
    datos.put(ConstantesREP.MARCA, marca);
    
    String canal = conectorParametroLimpia("canal", "", true);
    datos.put(ConstantesREP.CANAL, canal);

    String subgerenciaVentas = conectorParametroLimpia("subgerenciaVentas", "", true);
    String region = conectorParametroLimpia("region", "", true);
    String zona = conectorParametroLimpia("zona", "", true);
    String reporte = new String();
    
    if(subgerenciaVentas.equals("S")){
		datos.put(ConstantesREP.SUBGERENCIAVENTA, "1");
	}

    if(region.equals("S")){
		datos.put(ConstantesREP.REGION, "1");
	}

	if(zona.equals("S")){
	   datos.put(ConstantesREP.ZONA, "1");
	}

	if((!subgerenciaVentas.equals("S")) && (!region.equals("S")) && (!zona.equals("S"))){
  	   datos.put(ConstantesREP.SUBGERENCIAVENTA, "1");
       datos.put(ConstantesREP.REGION, "1");
	   datos.put(ConstantesREP.ZONA, "1");
	}

      
	reporte = "RD_REP-070";   

    String concurso = conectorParametroLimpia("concurso", "", true);
    datos.put(ConstantesREP.NUMEROCONCURSOS, concurso);
    
    String periodo = conectorParametroLimpia("periodo", "", true);
    if(!periodo.equals("")) {
      datos.put(ConstantesREP.PERIODOS, periodo);
    }
    
    
    datos.put(ConstantesREP.TITULO, "CONCURSOS VIGENTES EN " + paisDesc + " " + anio);
    traza("++++++Antes de enviar a reportes " + datos); 
     
    String formato = conectorParametroLimpia("formato", "", true);
     
    
    if(formato.equals("xls")){
      datos.put(ConstantesREP.FORMATOSALIDA, "EXCEL");
    }
       
     
    ejecutarReporte2(datos, "REPGenerarReporteBatch", reporte, formato);
  
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

    //Carga de combo paises
    //ComposerViewElement cbPaises = new ComposerViewElement();
    //cbPaises.setIDBusiness("SEGConsultaPaises");
    //cbPaises.setDTOE(dtoBel);
    
    
    lista.addViewElement(cbMarca);
    lista.addViewElement(cbCanales);
    //lista.addViewElement(cbPaises);

    return lista;
  
  }

}
