//01-02-2005 mdolce
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.sicc.util.DTOString;
import es.indra.sicc.rep.dtos.DTOReporte;

import java.util.HashMap;
import java.util.Vector;
import es.indra.mare.common.mln.MareBusinessID;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import es.indra.mare.common.exception.MareException;
import java.lang.reflect.InvocationTargetException;

public class REPGenBusquedaReportes extends LPSICCBase {           
   public REPGenBusquedaReportes() {	 
     super();
  }

  public void inicio() throws Exception { 
     
  }

  public void ejecucion() throws Exception {		
     String accion = conectorParametroLimpia("accion","", true);
     setTrazaFichero();
     try {
        this.rastreo();

        if (accion.equals("verReporte")) { 
          traza("voy a ver el reporte: " + conectorParametroLimpia("oidReporte", "", true));
		  generarReporte();
		} else {
          pagina("contenido_reportes_consultar");   
       
          asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
          asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
          this.generarHiddenFormatoFecha();
     
		  DTOBelcorp dto = new DTOBelcorp();
          dto.setOidIdioma(UtilidadesSession.getIdioma(this));
     
          MareBusinessID id = new MareBusinessID("REPObtenerModulo");
          Vector vec = new Vector();
		 
		  vec.add(dto);
 		  vec.add(id);
   		  DTOSalida dtoS = (DTOSalida)conectar("ConectorUA",vec).objeto("dtoSalida"); 
		  RecordSet mod = (RecordSet)dtoS.getResultado();
		  Vector colMOD = mod.getColumnIdentifiers();
		  DruidaConector mods = generarConector("DTOSalida.mod_ROWSET",mod, colMOD);
		  asignar("COMBO", "cbModulo", mods, "DTOSalida.mod_ROWSET");  


          getConfiguracionMenu("REPGenBusquedaReportes");
        }
     } catch (Exception ex) {
     			
        ByteArrayOutputStream stack = new ByteArrayOutputStream();
		    PrintStream out = new PrintStream(stack);
			  ex.printStackTrace(out);
	      traza("EXCEPCION:" + stack.toString());
		    lanzarPaginaError(ex);
 
     }
  }

  private void generarReporte() throws Exception{
     String codigoRep =  conectorParametroLimpia("oidReporte", "", true);

	 try {
  	   pagina("salidaGenerica");

	   DTOString dtoS = new  DTOString();
	   dtoS.setCadena(codigoRep);

	   MareBusinessID bizId = new MareBusinessID("REPVerReporte");

       Vector params = new Vector();
       params.addElement( dtoS );
       params.addElement( bizId );
	   String extension = conectorParametroLimpia( "extension", "", true );

       asignarAtributo("VAR", "cerrarVentana", "valor", "0"); 
       traza("Antes conector: " + dtoS);
       DruidaConector dc = conectar( "ConectorPollEstados" , params);
       traza( "dc ");
    
       DTOReporte dtoSal = (DTOReporte) dc.objeto("dtoSalida");
       traza("DTO Reporte resultante: "+dtoSal.getResultados());
   
	   //llamo a, ver reporte....
	   this.verReporte(dtoSal, extension); 
     } catch (Exception e) {
		 if(e instanceof InvocationTargetException) {
           if (((InvocationTargetException) e).getTargetException() instanceof MareException) {
                 MareException mareException = (MareException) ((InvocationTargetException) e).getTargetException();

                 traza("la mare-exc. que me retorna, tiene el codigo : " + mareException.getCode());	                 
  
                  if (mareException.getCode() == 40601) {            
            		this.lanzarPaginaError(e);
		            traza("if del blob vacio!!");
				  }
		   } else { 
	           traza("que, no es instancia...........de: MareException??");
		       ByteArrayOutputStream stack = new ByteArrayOutputStream();
			   PrintStream out = new PrintStream(stack);
	  	       e.printStackTrace(out);
			   traza("EXCEPCION:" + stack.toString());
			   this.lanzarPaginaError(e);
			   asignarAtributo("VAR", "ejecutarError", "valor", "killTimeOut();");  
		   }
         } else {
           traza("que, no es instancia...........de: InvocationTargetException??");
           ByteArrayOutputStream stack = new ByteArrayOutputStream();
	       PrintStream out = new PrintStream(stack);
		   e.printStackTrace(out);
		   traza("EXCEPCION:" + stack.toString());
		   this.lanzarPaginaError(e);
		   asignarAtributo("VAR", "ejecutarError", "valor", "killTimeOut();");  
         } 
	 }

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
  
 
  
  

    
  
 
 

















