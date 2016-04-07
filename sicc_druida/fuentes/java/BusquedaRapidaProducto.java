import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;
import es.indra.druida.DruidaConector;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;
import java.util.Vector;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;



public class BusquedaRapidaProducto extends LPSICCBase {        
         
         public BusquedaRapidaProducto() {
                  super();
         }
         
         public void inicio() throws Exception {
                  setTrazaFichero();
                  pagina("contenido_busqueda_rapida_producto");
         }
 
         public void ejecucion() throws Exception {
                  rastreo();
                  
                  String accion     = conectorParametroLimpia( "accion","",true );
                  
                  try{

                     if ( accion.equals("") ) {
                        cargaPantalla();                
                           
                     }else{
                   
                           }

                  } catch (Exception ex){
                                    this.lanzarPaginaError(ex);
                  }
                  
                  getConfiguracionMenu();
         }

		 private void cargaPantalla() throws Exception{
		 
             asignarAtributo("VAR","hidOidPais","valor", UtilidadesSession.getPais(this).toString());
             asignarAtributo("VAR","hidOidIdioma","valor", UtilidadesSession.getIdioma(this).toString());
			 DTOBelcorp dto = new DTOBelcorp();
     
             dto.setOidPais(UtilidadesSession.getPais(this));
             dto.setOidIdioma(UtilidadesSession.getIdioma(this));
			 
			 MareBusinessID id = null;
			 //cargo el combo de Unidades Negocio
			 id = new MareBusinessID("MAEObtenerUnidadesNegocioPorPais");
			 
			 Vector parametros = new Vector();
			 parametros.add(dto);
			 parametros.add(id);
			 
			 DTOSalida dtoSal = (DTOSalida) conectar("ConectorUnidadesNegocio",parametros).objeto("dtoSalida"); 
				  
			 RecordSet unidad = (RecordSet)dtoSal.getResultado();
			 Vector colUN = unidad.getColumnIdentifiers();
			 DruidaConector unidades = generarConector("DTOSalida.unidades_ROWSET",unidad, colUN);
			 traza("unidades negocio "+dtoSal.getResultado());
			 traza("unidades negocio "+dtoSal.getResultado().getColumnIdentifiers());
			 asignar("COMBO", "cbUnidadNegocio", unidades, "DTOSalida.unidades_ROWSET");  
			 
			 //cargo el combo de Negocios
			 MareBusinessID id2 = new MareBusinessID("MAEObtenerNegocioPorPais");
			 Vector parametros2 = new Vector();
			 parametros2.add(dto);
			 parametros2.add(id2);
			 
			 DTOSalida dtoSal2 = (DTOSalida) conectar("ConectorNegocios",parametros2).objeto("dtoSalida"); 
			 RecordSet negocio = (RecordSet)dtoSal2.getResultado();
			 Vector colNeg = negocio.getColumnIdentifiers();
			 DruidaConector negocios = generarConector("DTOSalida.negocios_ROWSET",negocio, colNeg);
			 traza("negocio "+dtoSal2.getResultado());
			 traza("negocio "+dtoSal2.getResultado().getColumnIdentifiers());
			 asignar("COMBO", "cbNegocio", negocios, "DTOSalida.negocios_ROWSET"); 

			 //cargo el combo de MarcaProducto
			 MareBusinessID id3 = new MareBusinessID("REPObtenerMarcaProducto");
			 Vector parametros3 = new Vector();
			 parametros3.add(dto);
			 parametros3.add(id3);
			 
			 DTOSalida dtoSal3 = (DTOSalida) conectar("ConectorNegocios",parametros3).objeto("dtoSalida"); 
			 RecordSet marcaProducto = (RecordSet)dtoSal3.getResultado();
			 Vector colMP = marcaProducto.getColumnIdentifiers();
			 DruidaConector marcaProductos = generarConector("DTOSalida.marcaProducto_ROWSET",marcaProducto, colMP);
			 traza("negocio "+dtoSal3.getResultado());
			 traza("negocio "+dtoSal3.getResultado().getColumnIdentifiers());
			 asignar("COMBO", "cbMarcaProducto", marcaProductos, "DTOSalida.marcaProducto_ROWSET"); 
				 
		 
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
