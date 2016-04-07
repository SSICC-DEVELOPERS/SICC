import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
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

public class LPFlujoClientesGerenteZona extends LPSICCBase {           
   public LPFlujoClientesGerenteZona() {	 
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
        }else{
			     cargarPantalla();
           getConfiguracionMenu("LPFlujoClientesGerenteZona");
        }
     
     } catch (Exception ex) {
			  cargarPantalla();
				getConfiguracionMenu("LPFlujoClientesGerenteZona");

	      ByteArrayOutputStream stack = new ByteArrayOutputStream();
		    PrintStream out = new PrintStream(stack);
			  ex.printStackTrace(out);
	      traza("EXCEPCION:" + stack.toString());
		    lanzarPaginaError(ex);

     }
    
     
  }
  
  private void cargarPantalla() throws Exception{
 
      pagina("contenido_flujo_clientes_gerente_zona_obtener"); 
     
     
      ComposerViewElementList cv = crearParametrosEntrada();
      ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
      conector.ejecucion();
      DruidaConector resultados = conector.getConector();
      traza(" 4 " + resultados.getXML());
      
      asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");             
      asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
      //asignar("COMBO","cbRegion",resultados,"ZONObtenerRegiones");
      asignarAtributo("VAR","pais","valor", UtilidadesSession.getPais(this).toString());
      asignarAtributo("VAR","idioma","valor", UtilidadesSession.getIdioma(this).toString());
      
      DTOBelcorp dto = new DTOBelcorp();
      MareBusinessID id = new MareBusinessID("REPRecuperarPaises");
      dto.setOidIdioma(UtilidadesSession.getIdioma(this));
      Vector vec = new Vector();
      
      vec.add(dto);
      vec.add(id);
     
      DTOSalida dtoSal = (DTOSalida)conectar("ConectorPaises",vec).objeto("dtoSalida"); 
         
      RecordSet pais = (RecordSet)dtoSal.getResultado();
      Vector colPAIS = pais.getColumnIdentifiers();
      DruidaConector paises = generarConector("DTOSalida.paises_ROWSET",pais, colPAIS);
      asignar("COMBO", "cbPais", paises, "DTOSalida.paises_ROWSET");  
      
      asignarAtributo("VAR", "hLongCliente", "valor", this.obtenerLongitudCodigoCliente().toString());
           
       
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
         
     //Carga de combo region
     //DTOUnidadAdministrativa dtoUA = new DTOUnidadAdministrativa();
   //  dtoUA.setOidPais(UtilidadesSession.getPais(this));
   //  dtoUA.setOidIdioma(UtilidadesSession.getIdioma(this));
    // ComposerViewElement cbRegiones = new ComposerViewElement();
   //  cbRegiones.setIDBusiness("ZONObtenerRegiones");
   //  cbRegiones.setDTOE(dtoUA);
  //   cbRegiones.setPosOID((byte)0);
   //  cbRegiones.setPosDesc((byte)5);
                      
     lista.addViewElement(cbMarca);
     lista.addViewElement(cbCanales);   
    // lista.addViewElement(cbRegiones);
     
      return lista;
  }
  
  
  private void generarReporte() throws Exception{
              
        HashMap datos = new HashMap();
        datos.put(ConstantesREP.MODULO, "MAE");
     
        
       //comienzo de los parametros de filtrado
        
       String marca        = conectorParametroLimpia("marca", "", true);
       if(!marca.equals("")){
          datos.put(ConstantesREP.MARCA, marca);     
       }
     
       String canal        = conectorParametroLimpia("canal", "", true);
       if(!canal.equals("")){
         datos.put(ConstantesREP.CANAL, canal);     
       }
       
       String periodo        = conectorParametroLimpia("periodo", "", true);
       String periodoDesc        = conectorParametroLimpia("periodoDesc", "", true);
       if(!periodo.equals("")){
         datos.put(ConstantesREP.PERIODOCIERRE, periodo);     
         datos.put(ConstantesREP.PERIODODESC, periodoDesc);     
       }
       
       String subgerencia        = conectorParametroLimpia("subgerencia", "", true);
       if(!subgerencia.equals("")){
         datos.put(ConstantesREP.SUBGERENCIA, subgerencia);     
       }
       
       String region       = conectorParametroLimpia("region", "", true);
       if(!region.equals("")){
          datos.put(ConstantesREP.REGION, region);  
       }
       
       String zona         = conectorParametroLimpia("zona", "", true);
       if(!zona.equals("")){
          datos.put(ConstantesREP.ZONA, zona);
       }
       
       String seccion      = conectorParametroLimpia("seccion", "", true);
       if(!seccion.equals("")){
          datos.put(ConstantesREP.SECCION, seccion);
       }
       
       String territorio      = conectorParametroLimpia("territorio", "", true);
       if(!territorio.equals("")){
          datos.put(ConstantesREP.TERRITORIO, territorio);
       }
       
       String codigoCliente        = conectorParametroLimpia("codigoCliente", "", true);
       if(!codigoCliente.equals("")){
           datos.put(ConstantesREP.CODIGOCLIENTE, codigoCliente);     
       }
       
       datos.put(ConstantesREP.TITULO, "Flujo de clientes por gerente de zona");
       
       traza("++++++Antes de enviar a reportes " + datos); 
       //ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-037", null);
       ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-037", "pdf");
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
