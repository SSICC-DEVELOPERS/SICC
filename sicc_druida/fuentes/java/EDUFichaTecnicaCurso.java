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
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;
import es.indra.sicc.dtos.mae.DTOTipoSubtipo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;
import java.util.Vector;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class EDUFichaTecnicaCurso extends LPSICCBase {           
   public EDUFichaTecnicaCurso() {	 
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
           getConfiguracionMenu("EDUFichaTecnicaCurso");
        }
     
     } catch (Exception ex) {
     			
      //  cargarPagina();
       // getConfiguracionMenu("EDUFichaTecnicaCurso");
               
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
     pagina("contenido_informe_ficha_tecnica_generar");   
    
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
       
     
     this.generarHiddenFormatoFecha();
     
     //cargo el combo de tipo curso
     Vector vecTC = new Vector();
     MareBusinessID idTC = new MareBusinessID("EDUObtieneTipoCurso");
     dto.setOidIdioma(UtilidadesSession.getIdioma(this));
     vecTC.add(dto);
     vecTC.add(idTC);
     DTOSalida dtoSalTC = (DTOSalida)conectar("ConectorUA",vecTC).objeto("dtoSalida"); 
     RecordSet tc = (RecordSet)dtoSalTC.getResultado();
     Vector colTC = tc.getColumnIdentifiers();
     DruidaConector tcs = generarConector("DTOSalida.tipoCurso_ROWSET",tc, colTC);
     asignar("COMBO", "cbCodTipoCurso", tcs, "DTOSalida.tipoCurso_ROWSET");  
         
     asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
     asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
         
   
  }
          
  
 private void generarReporte() throws Exception{
     
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "EDU");
     
     //comienzo de los parametrso de filtrado
      
     
     String codigoTipoCurso        = conectorParametroLimpia("codigoTipoCurso", "", true);
     String codigoCurso        = conectorParametroLimpia("codigoCurso", "", true);

	 datos.put(ConstantesREP.CODIGOCURSO, codigoCurso);     
	 datos.put(ConstantesREP.CODIGOTIPOCURSO, codigoTipoCurso);     
           
     datos.put(ConstantesREP.TITULO, "Ficha Tecnica del Curso");     
     traza("++++++Antes de enviar a reportes " + datos); 
     //ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-013", null);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-013", "pdf");
     
          
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









