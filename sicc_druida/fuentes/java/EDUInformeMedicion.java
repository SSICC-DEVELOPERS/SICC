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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;
import java.util.Vector;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class EDUInformeMedicion extends LPSICCBase {           
   public EDUInformeMedicion() {	 
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
           getConfiguracionMenu("EDUInformeMedicion");
        }
     
     } catch (Exception ex) {
     			
        //cargarPagina();
      //  getConfiguracionMenu("EDUInformeMedicion");
               
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
     pagina("contenido_informe_medicion_generar");   
    
     DTOBelcorp dto = new DTOBelcorp();
     dto.setOidPais(UtilidadesSession.getPais(this));
     dto.setOidIdioma(UtilidadesSession.getIdioma(this));
     Vector vec = new Vector();
     MareBusinessID idPais = new MareBusinessID("REPRecuperarPaises");
     vec.add(dto);
     vec.add(idPais);
     DTOSalida dtoSalPais = (DTOSalida)conectar("ConectorPaises",vec).objeto("dtoSalida"); 
     RecordSet pais = (RecordSet)dtoSalPais.getResultado();
     Vector colPAIS = pais.getColumnIdentifiers();
     DruidaConector paises = generarConector("DTOSalida.paises_ROWSET",pais, colPAIS);
     asignar("COMBO", "cbPais", paises, "DTOSalida.paises_ROWSET");  
     traza("cargo combo paises");
     
     Vector vecOP = new Vector();
     MareBusinessID idOP = new MareBusinessID("EDUObtieneOidPlantilla");
     vecOP.add(dto);
     vecOP.add(idOP);
     DTOSalida dtoSalOP = (DTOSalida)conectar("ConectorUA",vecOP).objeto("dtoSalida"); 
     RecordSet op = (RecordSet)dtoSalOP.getResultado();
     Vector colOP = op.getColumnIdentifiers();
     DruidaConector ops = generarConector("DTOSalida.ops_ROWSET",op, colOP);
     asignar("COMBO", "cbCodPlantilla", ops, "DTOSalida.ops_ROWSET");       
     traza("cargo combo plantilla");
     
     
     ComposerViewElementList cv = crearParametrosEntrada();
     ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
     conector.ejecucion();
     DruidaConector resultados = conector.getConector();
     traza(" 4 " + resultados.getXML());
          
     asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");             
     asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
     
     this.generarHiddenFormatoFecha();
     
     asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
     asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
         
   
  }
          
  
 private void generarReporte() throws Exception{
     
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "EDU");
     
     //comienzo de los parametrso de filtrado
       
     String pais        = conectorParametroLimpia("paisSelec", "", true);
     if(!pais.equals("")){
        datos.put(ConstantesREP.PAIS, pais);     
     }
          
     String marca        = conectorParametroLimpia("marca", "", true);
     if(!marca.equals("")){
        datos.put(ConstantesREP.MARCA, marca);     
     }
               
     String canal        = conectorParametroLimpia("canal", "", true);
     if(!canal.equals("")){
        datos.put(ConstantesREP.CANAL, canal); 
     }
     
     String periodo        = conectorParametroLimpia("periodo", "", true);
     datos.put(ConstantesREP.PERIODO, periodo); 
     
     String codigoPlantilla        = conectorParametroLimpia("codigoPlantilla", "", true);
     if(!codigoPlantilla.equals("")){
        datos.put(ConstantesREP.CODIGOPLANTILLA, codigoPlantilla); 
     }
         
     String codigoCurso        = conectorParametroLimpia("codigoCurso", "", true);
     if(!codigoCurso.equals("")){
        datos.put(ConstantesREP.CODIGOCURSO, codigoCurso); 
     }
     String muestraPorVentas        = conectorParametroLimpia("muestraPorVentas", "", true);
     if(muestraPorVentas.equals("1")){
        datos.put(ConstantesREP.MODALIDADMUESTRAVENTAS, "' ASC'"); 
     }else{
       datos.put(ConstantesREP.MODALIDADMUESTRAVENTAS, "' DESC'"); 
     }

     String tamanioMuestra        = conectorParametroLimpia("tamanioMuestra", "", true);
     datos.put(ConstantesREP.TAMANIOMUESTRACOMPARATIVA, tamanioMuestra); 

     String modalidadParticipante        = conectorParametroLimpia("modalidadParticipante", "", true);
	 if(!modalidadParticipante.equals("")){
        datos.put(ConstantesREP.MODALIDADPARTICIPANTE, modalidadParticipante); 
	 }
     
     String tiporeporte        = conectorParametroLimpia("tiporeporte", "", true);
     
     String reporte = null;
     if (tiporeporte.equals("1"))
     {
       reporte = new String("RD_REP-014_01");
     } else 
     {
       reporte = new String("RD_REP-014_02");
     }
     
     String zona        = conectorParametroLimpia("zona", "", true);
     if(!zona.equals("")){
        datos.put(ConstantesREP.ZONA, zona); 
     }
        
       
       
     datos.put(ConstantesREP.TITULO, "Informe de Medicion");     
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
  
 
    
  
 
 


}








