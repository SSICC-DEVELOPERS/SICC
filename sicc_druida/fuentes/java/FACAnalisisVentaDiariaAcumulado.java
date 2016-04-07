//01-02-2005 mdolce
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class FACAnalisisVentaDiariaAcumulado extends LPSICCBase {   
  
   Long pais = null;
   Long idioma = null;

   public FACAnalisisVentaDiariaAcumulado() {	 
     super();
   }

   public void inicio() throws Exception { 
     
   }

   public void ejecucion() throws Exception {		
      String accion = conectorParametroLimpia("accion","", true);
      setTrazaFichero();
      traza("vengo.....");
      pais = UtilidadesSession.getPais(this);     
      idioma = UtilidadesSession.getIdioma(this);
      try {
         this.rastreo();
        
         if (accion.equals("generar")){
            generarReporte(); 
            traza("termino de generar el reporte");
         }else{
            traza("c. inicial...............");
            cargarPagina();
			//cargarPeriodos();
            getConfiguracionMenu("FACAnalisisVentaDiariaAcumulado");
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
      pagina("contenido_analisis_venta_diario_acumulado");   
      this.generarHiddenFormatoFecha();

      ComposerViewElementList cv = crearParametrosEntrada();
      ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
      conector.ejecucion();
      DruidaConector resultados = conector.getConector();
      traza(" 4 " + resultados.getXML());
      
      this.generarHiddenFormatoFecha();
      
      String fechaActual = null;
      java.util.Date fecha = new java.util.Date(System.currentTimeMillis());
      String formatoFechaSesion = UtilidadesSession.getFormatoFecha(this);
 	  asignarAtributo("VAR", "formatoFecha", "valor", formatoFechaSesion);
      formatoFechaSesion = formatoFechaSesion.replace('m', 'M');
            
      SimpleDateFormat simpleDate = new SimpleDateFormat(formatoFechaSesion);
      fechaActual = simpleDate.format(fecha);
      traza("la fecha actual " + fechaActual);
                
      asignarAtributo("VAR", "idioma", "valor", this.idioma.toString());
      asignarAtributo("VAR", "pais", "valor", this.pais.toString());
      asignarAtributo("VAR", "fechaSistema", "valor", fechaActual);

      asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");             
      asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");

      asignar("COMBO","cbUnidadNegocio",resultados,"MAEBuscarUnidadesNegocioPorPais");             
      asignar("COMBO","cbNegocio",resultados,"MAEBuscarNegocioPorPais");
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
                          
     //Carga de UnidadNegocio
     ComposerViewElement cbUnidadNegocio = new ComposerViewElement();
     cbUnidadNegocio.setIDBusiness("MAEBuscarUnidadesNegocioPorPais");
     cbUnidadNegocio.setDTOE(dtoBel);

	 //Carga de Negocio
     ComposerViewElement cbNegocio = new ComposerViewElement();
     cbNegocio.setIDBusiness("MAEBuscarNegocioPorPais");
     cbNegocio.setDTOE(dtoBel);

     lista.addViewElement(cbMarca);
     lista.addViewElement(cbCanales);   
     lista.addViewElement(cbUnidadNegocio);   
     lista.addViewElement(cbNegocio);   
     
     return lista;
   }

  private void generarReporte() throws Exception{
     //pagina("contenido_generando_fichero");    
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "FAC");
     
     //comienzo de los parametrso de filtrado    
    
     
     String marca = conectorParametroLimpia("marca", "", true);
     if(!marca.equals("")){
        datos.put(ConstantesREP.MARCA, marca);     
     }
     
     String canal = conectorParametroLimpia("canal", "", true);
     if(!canal.equals("")){
        datos.put(ConstantesREP.CANAL, canal);     
     }
       
     String periodos = conectorParametroLimpia("periodos", "", true);
     if(!periodos.equals("")){
        datos.put(ConstantesREP.PERIODO, periodos);     
     }
     
     String accesos = conectorParametroLimpia("accesos", "", true);
     if(!accesos.equals("")){
        datos.put(ConstantesREP.ACCESO, accesos);     
     }

     String Fdesde = conectorParametroLimpia("desde", "", true);
     if(!Fdesde.equals("")){
        datos.put(ConstantesREP.FECHAINICIO, Fdesde);     
     }

     String Fhasta = conectorParametroLimpia("hasta", "", true);
     if(!Fhasta.equals("")){
        datos.put(ConstantesREP.FECHAFIN, Fhasta);     
     }

     String uneg = conectorParametroLimpia("unidNegocio", "", true);
     if(!uneg.equals("")){
        datos.put(ConstantesREP.UNIDADNEGOCIOS, uneg);     
     }

     String neg = conectorParametroLimpia("negocio", "", true);
     if(!neg.equals("")){
        datos.put(ConstantesREP.NEGOCIOS, neg);     
     }

     datos.put(ConstantesREP.TITULO, "Análisis Venta Diaria Acumulado");
          
     traza("++++++Antes de enviar a reportes " + datos); 
     //ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-160", null);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-160", "pdf");
  }

    private void cargarPeriodos() throws Exception {
    
         DTOSalida dtoS = new DTOSalida();
         DTOPeriodo dto = new DTOPeriodo();
         dto.setOidIdioma(idioma);
         dto.setOidPais(pais);
         dto.setPais(pais);
         
         DruidaConector conPeri = null;         

         /*DTOBelcorp dtoE = new DTOBelcorp();
         dtoE.setOidIdioma(idioma);*/

         Vector paramEntrada = new Vector();
         paramEntrada.add(dto);
         paramEntrada.add(new MareBusinessID("CRAObtenerPeriodos"));

         conPeri = conectar("ConectorObjeto", paramEntrada);

         dtoS = (DTOSalida) conPeri.objeto("DTOSalida");
         
         conPeri = generaConector(dtoS.getResultado(), "dtoSalida",
                  "OID_PERI", "VAL_NOMB_PERI", "MARC_OID_MARC","CANA_OID_CANA","FEC_INIC","FEC_FINA");
         asignar("COMBO", "lstPeriodo", conPeri, "dtoSalida");
         
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
                                                                                                      : rs.getValueAt(
                                i, campoF).toString()));
                  e_campo3.appendChild(txtF);
                  e_row.appendChild(e_campo3);
             }
             if (campoG != null) {
                  Element e_campo4 = docDestino.createElement("CAMPO");
                  e_campo4.setAttribute("NOMBRE", campoG);
                  e_campo4.setAttribute("TIPO", "OBJECTO");
                  e_campo4.setAttribute("LONGITUD", "50");

                  Text txtF = docDestino.createTextNode(((rs.getValueAt(i, campoG) == null) ? ""
                                                                                                      : rs.getValueAt(
                                i, campoG).toString()));
                  e_campo4.appendChild(txtF);
                  e_row.appendChild(e_campo4);
             }  
             if (campoH != null) {
                  Element e_campo5 = docDestino.createElement("CAMPO");
                  e_campo5.setAttribute("NOMBRE", campoG);
                  e_campo5.setAttribute("TIPO", "OBJECTO");
                  e_campo5.setAttribute("LONGITUD", "50");
                  Date aux = (Date)rs.getValueAt(i, campoH);
                  String dDesde = ((rs.getValueAt(i, campoH) == null) ? null : UtilidadesBelcorp.fechaFormateada(aux, formatoFechaPais));
				  Text txtF = docDestino.createTextNode(dDesde);

                  e_campo5.appendChild(txtF);
                  e_row.appendChild(e_campo5);
             }        
             if (campoI != null) {
                  Element e_campo6 = docDestino.createElement("CAMPO");
                  e_campo6.setAttribute("NOMBRE", campoI);
                  e_campo6.setAttribute("TIPO", "OBJECTO");
                  e_campo6.setAttribute("LONGITUD", "50");
                  Date aux1 = (Date)rs.getValueAt(i, campoI);
		   		  String dHasta = ((rs.getValueAt(i, campoI) == null) ? null : UtilidadesBelcorp.fechaFormateada(aux1, formatoFechaPais));
                  Text txtF = docDestino.createTextNode(dHasta);

                  e_campo6.appendChild(txtF);
                  e_row.appendChild(e_campo6);
             }               
         }

         DruidaConector conect = new DruidaConector();
         conect.setXML(docDestino.getDocumentElement());

         return conect;
    } 

}
