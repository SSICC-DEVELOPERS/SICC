/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

/*
    INDRA/CAR/PROY
    $Id: LPConsultaFacturas.java,v 1.1 2009/12/03 18:37:54 pecbazalar Exp $
    DESC
*/

import es.indra.druida.Contexto;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTODocumento;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.PrintStream;

import java.util.StringTokenizer;
import java.util.Vector;

import org.w3c.dom.Element;

import org.w3c.dom.Text;
import orinoco.Document;
import orinoco.Font;
import orinoco.PDFWriter;
import orinoco.Paper;


public class LPConsultaFacturas extends LPSICCBase {
    
    private String accion = null;
    private Long idioma;
    private Long pais;   
    private char linefeed[] = {'\n','\r'};
    private String MSG_BLANK = new String(linefeed);

    
    // Definicion del constructor
    public LPConsultaFacturas() {
    	super();
    }

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {

          
    }

    // Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
      rastreo();
      try{
          setTrazaFichero(); 
          traza("***Entrada - LPConsultaFacturas - ejecucion***");
          
          this.idioma = UtilidadesSession.getIdioma(this);
          this.pais = UtilidadesSession.getPais(this);
          
          this.accion = conectorParametroLimpia("accion","",true);
          traza("***accion : "+accion);
    
       
          
          //Bifurcamos la accion
          if (accion.equals("")) {
              inicializar(this.pais, this.idioma);
          }
          /*if(accion.equals("buscar")){   se elimina por incidencia 8874, no estaba correcto el diseño
            //visualizarDocumento();	
          }*/
          if(accion.equals("visualizar")){
              //PDTE hasta que se implemente el caso de uso "Visualizar Documentos de Facturación"
              //Incidencia 15800	
              /*Se compone un DTOOID con el oid del documento contable seleccionado en la lista de resultados 
              Se invoca al método MONImpresionSICC.visualizarDocumentoFacturacion que nos devolverá un DTODocumento 
              Se muestra en la página PGDocumentoMensajes la información del documento contenido en el DTODocumento 
              atDocumento = DTODocumento.documento */
              traza("*** Accion visualizar *** ");
              pagina("contenido_pantalla_vacia");
              
              DTOOID dto = new DTOOID();
              String oid = conectorParametroLimpia("oid","",true);
              
              dto.setOidPais(this.pais);
              dto.setOidIdioma(this.idioma);
              dto.setOid(new Long(oid));
              //traza("*** DTO = "+dto);
              
              Vector paramsEntrada = new Vector();
              paramsEntrada.add(dto);
              paramsEntrada.add(new MareBusinessID("FACVisualizarDocumento"));
              DruidaConector conector = conectar("ConectorVisualizarDocumento", paramsEntrada);
                
              DTODocumento dtoDocumento = (DTODocumento)conector.objeto("DTODocumento");
              //traza("************ DTODocumento recuperado: " + dtoDocumento);
              
              
              getConfiguracionMenu("LPConsultaFacturas",""); 
              asignarAtributo("PAGINA","contenido_pantalla_vacia", "cod", "0542");
              asignarAtributo("PAGINA","contenido_pantalla_vacia", "msgle", "Consultar Documentos de Facturación");  
                
              //String documento = new String(dtoDocumento.getDocumentoByte());
              traza(dtoDocumento.getDocumento().toString());
              visualizarEnPantalla(dtoDocumento.getDocumento().toString());
          }     
          traza("***Salida - LPConsultaFacturas - ejecucion***");
      }catch(Exception e){
            logStackTrace(e);
              lanzarPaginaError(e);
      }
	}
  
    private void visualizarEnPantalla(String salidaBytes) throws Exception{
        //StringBuffer sb = new StringBuffer();
        //sb.append(salidaBytes);
                
        //traza("Array de Bytes: "+salidaBytes.length);     
        StringTokenizer tk = new StringTokenizer(salidaBytes, MSG_BLANK);
        
        String path = Contexto.getPropiedad("TMP", "UPLOAD");
        traza("el path es " + path);
        String nombre = "documentoFacturacion"+System.currentTimeMillis();
        traza("el nombre es " + nombre);
        
        //OutputStream fichero = new OutputStream(path +"/"+nombre);
        Document docu = new Document (Paper.LETTER, new PDFWriter(new File(path +"/"+nombre)));
        Font f = new Font(Font.COURIER, 8);
        docu.open();
        while (tk.hasMoreTokens()){
          String s1 = tk.nextToken();
          traza(s1);
          traza("===============================================================");
          if (s1 == null){
              break;
          }
          docu.writeLine(s1,f);
        }
       
        docu.close();
        //fichero.write(salidaBytes);
  
        //fichero.close();
        
        DruidaConector conFinal = new DruidaConector();
        XMLDocument xmlDoc = new XMLDocument();
        org.w3c.dom.Document doc = xmlDoc.makeDocument("<FICHERO/>");
        Element e_rows = doc.createElement("ROWSET");
        e_rows.setAttribute("ID", "salida");
        e_rows.setAttribute("NOMBRE", "salida");
        doc.getDocumentElement().appendChild(e_rows);
        Element e_row = doc.createElement("ROW");
        e_rows.appendChild(e_row);
        Element e_campo2 = doc.createElement("CAMPO");
        e_campo2.setAttribute("NOMBRE","salida");
        e_campo2.setAttribute("TIPO", "FICHEROSTREAM");
        e_campo2.setAttribute("LONGITUD", "100");
        Text txt = doc.createTextNode("fichero"+nombre);
        e_campo2.appendChild(txt);
        e_row.appendChild(e_campo2);
        traza("Element: "+doc.getDocumentElement());
        conFinal.setXML(doc.getDocumentElement());
        
              
        fichero("FicheroReportes");
        
        asignarAtributo("FICHERO","Reporte","nombre",nombre);
        asignar("FICHERO", nombre, conFinal);
  }
    
 	private void inicializar(Long pais, Long idioma) throws Exception {
 		
 		traza("***Entrada - LPConsultaFacturas - inicializar***");
 		// Defino el nombre de la vista
        pagina("contenido_documentos_facturacion_consultar"); 
        asignar("VAR", "idioma", idioma.toString());
        asignar("VAR", "pais", pais.toString()); 
 		asignarAtributo("PAGINA","contenido_documentos_facturacion_consultar", "cod", "0542");
        asignarAtributo("PAGINA","contenido_documentos_facturacion_consultar", "msgle", "Consultar Documentos de Facturación");
 		getConfiguracionMenu("LPConsultaFacturas","");
 		this.generarHiddenFormatoFecha();
 		
 		Byte longitudCodigoCliente = this.obtenerLongitudCodigoCliente();
        asignar("VAR","numDigitosCodigoCliente", longitudCodigoCliente.toString());

 		obtenerDatosIniciales(pais, idioma);
 		
 		traza("***Salida - LPConsultaFacturas - inicializar***");
 	}
 	
 	private void obtenerDatosIniciales(Long pais, Long idioma) throws Exception{
 		traza("***Entrada - LPConsultaFacturas - obtenerDatosIniciales***");
 		
 		try{
 			 		
 			//Creamos DTOBelcorp
 			DTOBelcorp dto = new DTOBelcorp();
 			dto.setOidPais(pais);
 			dto.setOidIdioma(idioma);
 		
 			//Creamos lista composerView
 			ComposerViewElementList listElement = new ComposerViewElementList();
 		
 			//Carga canales
 			ComposerViewElement elem1=new ComposerViewElement();
			elem1.setIDBusiness("SEGConsultaCanales");
       		elem1.setDTOE(dto);
        	elem1.setPosOID((byte)0);
       		elem1.setPosDesc((byte)1);
        	listElement.addViewElement(elem1);
        	traza("elemento añadido");
               
       		//Carga los tipos de documento
        	ComposerViewElement elem2 = new ComposerViewElement();
        	elem2.setIDBusiness("FACObtenerTiposDocumentoLegal");
        	elem2.setDTOE(dto);
        	listElement.addViewElement(elem2);
        	traza("elemento añadido");
              		
			//Llamar al subsistema GestorCargaPantalla
			ConectorComposerView conector = new ConectorComposerView(listElement,this.getRequest());
        	traza("conector creado");
        	conector.ejecucion();
        	traza("ejecutado");
        	DruidaConector conConsultar = conector.getConector();
        	traza("Obtener conConsultar");
        
       
        	asignar("COMBO","cbCanal", conConsultar,"SEGConsultaCanales"); 
        	asignar("COMBO","cbTipoDocumentoContable", conConsultar,"FACObtenerTiposDocumentoLegal");
        
		}catch ( Exception e )  {
       		logStackTrace(e);
			lanzarPaginaError(e);
		}		

 		traza("***Salida - LPConsultaFacturas - obtenerDatosIniciales***");
 	}
 	
 	 	
 	protected void logStackTrace(Throwable e) throws Exception {
          traza("Se produjo la excepcion: " + e.getMessage());
    
          ByteArrayOutputStream baos = new ByteArrayOutputStream();
          PrintStream ps = new PrintStream(baos);
          e.printStackTrace(ps);
                         
          traza("Stack Trace: " + baos.toString());
    }
    
}
