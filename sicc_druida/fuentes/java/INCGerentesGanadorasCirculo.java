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


public class INCGerentesGanadorasCirculo extends LPSICCBase {           
    public INCGerentesGanadorasCirculo() {	 
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
                getConfiguracionMenu("INCGerentesGanadorasCirculo");
            }

        } catch (Exception ex) {
     			
            //pagina("contenido_informe_circulo_excelencia_generar");
            //getConfiguracionMenu("INCGerentesGanadorasCirculo");
               
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
        } //Fin Metodo
  
  
    private void cargarPagina() throws Exception{
        pagina("contenido_informe_circulo_excelencia_generar");   
        
        ComposerViewElementList cv = crearParametrosEntrada();
        ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
        conector.ejecucion();
        DruidaConector resultados = conector.getConector();
        traza(" 4 " + resultados.getXML());
        
        asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");
        asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
        
        asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
        asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
        
        //DTOs
        DTOUnidadAdministrativa dtoUA = new DTOUnidadAdministrativa();
        dtoUA.setOidPais(UtilidadesSession.getPais(this));
        dtoUA.setOidIdioma(UtilidadesSession.getIdioma(this));
        
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
    }
          
  
    private void generarReporte() throws Exception{
        HashMap datos = new HashMap();
        datos.put("MODULO", "INC");
        
        //comienzo de los parametrso de filtrado
        
        String pais = conectorParametroLimpia("pais", "", true);
        datos.put(ConstantesREP.PAIS, pais);
        
        String marca = conectorParametroLimpia("marca", "", true);
        datos.put(ConstantesREP.MARCA, marca);
        
        String canal = conectorParametroLimpia("canal", "", true);
        datos.put(ConstantesREP.CANAL, canal);
        
        String concurso = conectorParametroLimpia("concurso", "", true);
        datos.put(ConstantesREP.CONCURSO, concurso);
        
        String numeroSubgerenciaVentas = conectorParametroLimpia("numeroSubgerenciaVentas", "", true);
        if(!numeroSubgerenciaVentas.equals("")){
            datos.put(ConstantesREP.NUMEROSUBGERENCIAVENTAS, numeroSubgerenciaVentas);
        }
        
        String numeroRegion = conectorParametroLimpia("numeroRegiones", "", true);
        if(!numeroRegion.equals("")){
            datos.put(ConstantesREP.NUMEROREGIONES, numeroRegion);
        }
        
        String numeroZona = conectorParametroLimpia("numeroZonas", "", true);
        if(!numeroZona.equals("")){
            datos.put(ConstantesREP.NUMEROZONAS, numeroZona);
        }
        
        datos.put(ConstantesREP.TITULO, "Ganadoras Circulo de la Excelencia");
        traza("++++++Antes de enviar a reportes " + datos);
        
        String formato = conectorParametroLimpia("formato", "", true);
        if(formato.equals("xls")){
            datos.put(ConstantesREP.FORMATOSALIDA, "EXCEL");
        }
        
		String reporte;
		
		if(!numeroZona.equals("")){
		   reporte = "RD_REP-066_02";    
		}else{
		   if(!numeroRegion.equals("")){
			  reporte = "RD_REP-066_01";
		   }else{
			  reporte = "RD_REP-066";
		   }
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

        lista.addViewElement(cbMarca);
        lista.addViewElement(cbCanales);

        return lista;
    }


    private DruidaConector generaConector(RecordSet rs, String ID_Rows, String campoCod,
        String campoNom, String campoF, String campoG, String campoH, String campoI) throws Exception {
        XMLDocument xmlDoc = new XMLDocument();
        Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");
        
        String formatoFechaPais = UtilidadesSession.getFormatoFecha(this);
        
        Element e_rows = docDestino.createElement("ROWSET");
        e_rows.setAttribute("ID", ID_Rows);
        docDestino.getDocumentElement().appendChild(e_rows);
    
        for (int i = 0; i < rs.getRowCount(); i++) {
            Element e_row = docDestino.createElement("ROW");
            e_rows.appendChild(e_row);
            
            Element e_campo1 = docDestino.createElement("CAMPO");
            e_campo1.setAttribute("NOMBRE", campoCod);
            e_campo1.setAttribute("TIPO", "OBJECTO");
            e_campo1.setAttribute("LONGITUD", "50");
            
            Text txtCod = docDestino.createTextNode(((rs.getValueAt(i, campoCod) == null) ? ""
                                                                                                  : rs.getValueAt(
                       i, campoCod).toString()));
            e_campo1.appendChild(txtCod);
            e_row.appendChild(e_campo1);
            
            Element e_campo2 = docDestino.createElement("CAMPO");
            e_campo2.setAttribute("NOMBRE", campoNom);
            e_campo2.setAttribute("TIPO", "OBJECTO");
            e_campo2.setAttribute("LONGITUD", "50");
            
            Text txtDesc = docDestino.createTextNode(((rs.getValueAt(i, campoNom) == null) ? ""
                                                                                                    : rs.getValueAt(
                       i, campoNom).toString()));
            e_campo2.appendChild(txtDesc);
            e_row.appendChild(e_campo2);
    
            if (campoF != null) {
                Element e_campo3 = docDestino.createElement("CAMPO");
                e_campo3.setAttribute("NOMBRE", campoF);
                e_campo3.setAttribute("TIPO", "OBJECTO");
                e_campo3.setAttribute("LONGITUD", "50");
                
                Text txtF = docDestino.createTextNode(((rs.getValueAt(i, campoF) == null) ? ""
                                : rs.getValueAt(i, campoF).toString()));
                e_campo3.appendChild(txtF);
                e_row.appendChild(e_campo3);
            }
            if (campoG != null) {
                Element e_campo4 = docDestino.createElement("CAMPO");
                e_campo4.setAttribute("NOMBRE", campoG);
                e_campo4.setAttribute("TIPO", "OBJECTO");
                e_campo4.setAttribute("LONGITUD", "50");
                
                Text txtF = docDestino.createTextNode(((rs.getValueAt(i, campoG) == null) ? ""
                                : rs.getValueAt(i, campoG).toString()));
                e_campo4.appendChild(txtF);
                e_row.appendChild(e_campo4);
            }  
            if (campoH != null) {
                Element e_campo5 = docDestino.createElement("CAMPO");
                e_campo5.setAttribute("NOMBRE", campoG);
                e_campo5.setAttribute("TIPO", "OBJECTO");
                e_campo5.setAttribute("LONGITUD", "50");
                
                Text txtF = docDestino.createTextNode(((rs.getValueAt(i, campoH) == null) ? ""
                                : rs.getValueAt(i, campoH).toString()));
                e_campo5.appendChild(txtF);
                e_row.appendChild(e_campo5);
            }        
            if (campoI != null) {
                Element e_campo6 = docDestino.createElement("CAMPO");
                e_campo6.setAttribute("NOMBRE", campoI);
                e_campo6.setAttribute("TIPO", "OBJECTO");
                e_campo6.setAttribute("LONGITUD", "50");
                
                Text txtF = docDestino.createTextNode(((rs.getValueAt(i, campoI) == null) ? ""
                                : rs.getValueAt(i, campoI).toString()));
                e_campo6.appendChild(txtF);
                e_row.appendChild(e_campo6);
            }               
        }

        DruidaConector conect = new DruidaConector();
        conect.setXML(docDestino.getDocumentElement());
        
        return conect;
    }    


    private DruidaConector generaConector(RecordSet rs, String ID_Rows, String campoCod,
        String campoNom, String campoF) throws Exception {
        XMLDocument xmlDoc = new XMLDocument();
        Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");
        
        Element e_rows = docDestino.createElement("ROWSET");
        e_rows.setAttribute("ID", ID_Rows);
        docDestino.getDocumentElement().appendChild(e_rows);
        
        for (int i = 0; i < rs.getRowCount(); i++) {
            Element e_row = docDestino.createElement("ROW");
            e_rows.appendChild(e_row);
            
            Element e_campo1 = docDestino.createElement("CAMPO");
            e_campo1.setAttribute("NOMBRE", campoCod);
            e_campo1.setAttribute("TIPO", "OBJECTO");
            e_campo1.setAttribute("LONGITUD", "50");
            
            Text txtCod = docDestino.createTextNode(((rs.getValueAt(i, campoCod) == null) ? ""
                            : rs.getValueAt(i, campoCod).toString()));
            e_campo1.appendChild(txtCod);
            e_row.appendChild(e_campo1);
            
            Element e_campo2 = docDestino.createElement("CAMPO");
            e_campo2.setAttribute("NOMBRE", campoNom);
            e_campo2.setAttribute("TIPO", "OBJECTO");
            e_campo2.setAttribute("LONGITUD", "50");
            
            Text txtDesc = docDestino.createTextNode(((rs.getValueAt(i, campoNom) == null) ? ""
                            : rs.getValueAt(i, campoNom).toString()));
            e_campo2.appendChild(txtDesc);
            e_row.appendChild(e_campo2);
            
            if (campoF != null) {
                  Element e_campo3 = docDestino.createElement("CAMPO");
                  e_campo3.setAttribute("NOMBRE", campoF);
                  e_campo3.setAttribute("TIPO", "OBJECTO");
                  e_campo3.setAttribute("LONGITUD", "50");
 
                  Text txtF = docDestino.createTextNode(((rs.getValueAt(i, campoF) == null) ? ""
                                : rs.getValueAt(i, campoF).toString()));
                  e_campo3.appendChild(txtF);
                  e_row.appendChild(e_campo3);
             }
        }
 
        DruidaConector conect = new DruidaConector();
        conect.setXML(docDestino.getDocumentElement());
        
        return conect;
    }
     
    
}
