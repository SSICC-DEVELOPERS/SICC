import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;
import es.indra.druida.DruidaConector;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;
import java.util.Vector;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;


import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class LPPadronClientes extends LPSICCBase {           
   public LPPadronClientes() {	 
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
           //cargarPantalla();
        }else{
			     cargarPantalla();
           getConfiguracionMenu("LPPadronClientes");
           
        }
     
     } catch (Exception ex) {
			  pagina("contenido_patron_clientes_obtener"); 
				getConfiguracionMenu("LPPadronClientes");

	      ByteArrayOutputStream stack = new ByteArrayOutputStream();
		    PrintStream out = new PrintStream(stack);
			  ex.printStackTrace(out);
	      traza("EXCEPCION:" + stack.toString());
		    lanzarPaginaError(ex);

     }
     
     
  }
  
  private void cargarPantalla() throws Exception{
 
     pagina("contenido_patron_clientes_obtener"); 
     MareBusinessID idPais = new MareBusinessID("REPRecuperarPaises");
     DTOBelcorp dto = new DTOBelcorp();
     Vector vec = new Vector();
     
     dto.setOidIdioma(UtilidadesSession.getIdioma(this));
          
     vec.add(dto);
     vec.add(idPais);
     
     DTOSalida dtoSalPais = (DTOSalida)conectar("ConectorPaises",vec).objeto("dtoSalida"); 
         
     RecordSet pais = (RecordSet)dtoSalPais.getResultado();
     Vector colPAIS = pais.getColumnIdentifiers();
     DruidaConector paises = generarConector("DTOSalida.paises_ROWSET",pais, colPAIS);
     asignar("COMBO", "cbPais", paises, "DTOSalida.paises_ROWSET");  

	 MareBusinessID idStatus = new MareBusinessID("MAEObtenerEstatusCliente");
     Vector vecStatus = new Vector();	
	         
     vecStatus.add(dto);
     vecStatus.add(idStatus);     

     DTOSalida dtoSalStatus = (DTOSalida)conectar("ConectorPaises",vecStatus).objeto("dtoSalida"); 
         
     RecordSet status = (RecordSet)dtoSalStatus.getResultado();
     Vector colSTATUS = status.getColumnIdentifiers();
     DruidaConector status2 = generarConector("DTOSalida.status_ROWSET",status, colSTATUS);
     asignar("COMBO", "cbStatusCliente", status2, "DTOSalida.status_ROWSET");  

     
     asignarAtributo("VAR", "hLongCliente", "valor", this.obtenerLongitudCodigoCliente().toString());

	 ComposerViewElementList cv = crearParametrosEntrada();
     ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
     conector.ejecucion();
     DruidaConector resultados = conector.getConector();
     traza(" 4 " + resultados.getXML());


     asignar("COMBO","cbRegion",resultados,"ZONObtenerRegiones");

  
  }
  
  
  private void generarReporte() throws Exception{
//        fichero("FicheroReportes");
        
        HashMap datos = new HashMap();
        datos.put(ConstantesREP.MODULO, "MAE");
     
     
        //comienzo de los parametrso de filtrado
       String pais        = conectorParametroLimpia("pais", "", true);
      
       datos.put(ConstantesREP.PAIS, pais);     
      
        
       String codigoCliente        = conectorParametroLimpia("codigoCliente", "", true);
       if(!codigoCliente.equals("")){
          datos.put(ConstantesREP.CODIGOCLIENTE, codigoCliente);     
       }
         
       String apPaterno    = conectorParametroLimpia("apePat", "", true);
       if(!apPaterno.equals("")){
          datos.put(ConstantesREP.APELLIDOPATERNO, apPaterno);
       }
       
       String apMaterno    = conectorParametroLimpia("apeMat", "", true);
       if(!apMaterno.equals("")){
          datos.put(ConstantesREP.APELLIDOMATERNO, apMaterno);
       }
       
       String nombre1      = conectorParametroLimpia("nombre1", "", true);
       if(!nombre1.equals("")){
          datos.put(ConstantesREP.NOMBRE1, nombre1);
       }
       
       String nombre2      = conectorParametroLimpia("nombre2", "", true);
       if(!nombre2.equals("")){
          datos.put(ConstantesREP.NOMBRE2, nombre2);
       }

	   String region = conectorParametroLimpia("region", "", true);
	   datos.put(ConstantesREP.REGION, region);

	   String status = conectorParametroLimpia("status", "", true);
	   if(!status.equals("")){
	      datos.put(ConstantesREP.BANCO, status);
	   }
       
       datos.put(ConstantesREP.TITULO, "Padron de clientes");
       
       traza("++++++Antes de enviar a reportes " + datos);  
       //ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-041", null);
       ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-041", "pdf");
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
     
              
     //Carga de combo region
     DTOUnidadAdministrativa dtoUA = new DTOUnidadAdministrativa();
     dtoUA.setOidPais(UtilidadesSession.getPais(this));
     dtoUA.setOidIdioma(UtilidadesSession.getIdioma(this));
     ComposerViewElement cbRegiones = new ComposerViewElement();
     cbRegiones.setIDBusiness("ZONObtenerRegiones");
     cbRegiones.setDTOE(dtoUA);
     cbRegiones.setPosOID((byte)0);
     cbRegiones.setPosDesc((byte)5);
     

     lista.addViewElement(cbRegiones);
     
     return lista;
  }

  
       
}
