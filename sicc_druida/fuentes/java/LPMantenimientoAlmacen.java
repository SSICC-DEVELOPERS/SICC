import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;
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

public class LPMantenimientoAlmacen extends LPSICCBase {           
   public LPMantenimientoAlmacen() {	 
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
           getConfiguracionMenu("LPMantenimientoAlmacen");
        }
     
     } catch (Exception ex) {
			  cargarPantalla();
				getConfiguracionMenu("LPMantenimientoAlmacen");

	      ByteArrayOutputStream stack = new ByteArrayOutputStream();
		    PrintStream out = new PrintStream(stack);
			  ex.printStackTrace(out);
	      traza("EXCEPCION:" + stack.toString());
		    lanzarPaginaError(ex);

     }
     
     
  }
  
  private void cargarPantalla() throws Exception{
     
     pagina("contenido_movimiento_diario_almacen_obtener"); 
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
     
     //cargo el combo de Supergenericos
     MareBusinessID id3 = new MareBusinessID("MAEObtenerSuperGenericosPorPais");
     Vector parametros3 = new Vector();
     parametros3.add(dto);
     parametros3.add(id3);
     
     DTOSalida dtoSal3 = (DTOSalida) conectar("ConectorSupergenericos",parametros3).objeto("dtoSalida"); 
     RecordSet supergenerico = (RecordSet)dtoSal3.getResultado();
     Vector colSup = supergenerico.getColumnIdentifiers();
     DruidaConector supergenericos = generarConector("DTOSalida.supergenericos_ROWSET",supergenerico, colSup);
     traza("supergenericos "+dtoSal3.getResultado());
     traza("supergenerico "+dtoSal3.getResultado().getColumnIdentifiers());
     asignar("COMBO", "cbSupergenerico", supergenericos, "DTOSalida.supergenericos_ROWSET");  
     
     //cargo el combo de Genericos
     MareBusinessID id4 = new MareBusinessID("MAEObtenerGenericosPorPais");
     
     Vector parametros4 = new Vector();
     parametros4.add(dto);
     parametros4.add(id4);
     
     DTOSalida dtoSal4 = (DTOSalida) conectar("ConectorGenericos",parametros4).objeto("dtoSalida"); 
     RecordSet generico = (RecordSet)dtoSal4.getResultado();
     Vector colGen = generico.getColumnIdentifiers();
     DruidaConector genericos = generarConector("DTOSalida.genericos_ROWSET",generico, colGen);
     traza("genericos "+dtoSal4.getResultado());
     traza("generico "+dtoSal4.getResultado().getColumnIdentifiers());
     asignar("COMBO", "cbGenerico", genericos, "DTOSalida.genericos_ROWSET");
     
     
     //cargo el combo de Almacenes
     MareBusinessID id5 = new MareBusinessID("BELObtenerAlmacenes");
     
     Vector parametros5 = new Vector();
     parametros5.add(dto);
     parametros5.add(id5);
     
     DTOSalida dtoSal5 = (DTOSalida) conectar("ConectorAlmacenes",parametros5).objeto("dtoSalida"); 
     RecordSet almacen = (RecordSet)dtoSal5.getResultado();
     Vector colAlm = almacen.getColumnIdentifiers();
     DruidaConector almacenes = generarConector("DTOSalida.almacenes_ROWSET",almacen, colAlm);
     traza("almacen "+dtoSal5.getResultado());
     traza("almacen "+dtoSal5.getResultado().getColumnIdentifiers());
     asignar("COMBO", "cbAlmacen", almacenes, "DTOSalida.almacenes_ROWSET");
    
     
      //cargo los combos de mercancias
     MareBusinessID id6 = new MareBusinessID("BELObtenerEstadosMercancia");
     
     Vector parametros6 = new Vector();
     parametros6.add(dto);
     parametros6.add(id6);
     
     DTOSalida dtoSal6 = (DTOSalida) conectar("ConectorEstadosMercancia",parametros6).objeto("dtoSalida"); 
     RecordSet estado = (RecordSet)dtoSal6.getResultado();
     Vector colEst = estado.getColumnIdentifiers();
     DruidaConector estados = generarConector("DTOSalida.estados_ROWSET",estado, colEst);
     traza("estados "+dtoSal6.getResultado());
     traza("estados "+dtoSal6.getResultado().getColumnIdentifiers());
     
     asignar("COMBO", "cbEstadoMercaderiaDisponible", estados, "DTOSalida.estados_ROWSET");
     asignar("COMBO", "cbEstadoMercaderiaComprometido", estados, "DTOSalida.estados_ROWSET");
     asignar("COMBO", "cbEstadoMercaderiaAsignado", estados, "DTOSalida.estados_ROWSET");
     asignar("COMBO", "cbEstadoMercaderiaReservado", estados, "DTOSalida.estados_ROWSET");
     
     asignarAtributo("LABELC", "lblPaisDesc", "valor", UtilidadesSession.getDescripcionPais(this));
     
  
  }
  
  
  private void generarReporte() throws Exception{
       
       HashMap datos = new HashMap();
       datos.put(ConstantesREP.MODULO, "MAE");
        
         //comienzo de los parametrso de filtrado
         
       String pais                 = conectorParametroLimpia("pais", "", true);  
       if(!pais.equals("")){
          datos.put(ConstantesREP.PAISES, pais);
       }
       
       String unidadNegocio        = conectorParametroLimpia("unidadNegocio", "", true);
       if(!unidadNegocio.equals("")){
          datos.put(ConstantesREP.UNIDADNEGOCIOS, unidadNegocio);     
       }
       
       String negocio        = conectorParametroLimpia("negocio", "", true);
       if(!negocio.equals("")){
          datos.put(ConstantesREP.NEGOCIOS, negocio);     
       }
        
       String supergenerico        = conectorParametroLimpia("supergenerico", "", true);
       if(!supergenerico.equals("")){
          datos.put(ConstantesREP.SUPERGENERICOS, supergenerico);     
       }
       
       String generico        = conectorParametroLimpia("generico", "", true);
       if(!generico.equals("")){
          datos.put(ConstantesREP.GENERICOS, generico);     
       }
       
       String almacen        = conectorParametroLimpia("almacen", "", true);
       if(!almacen.equals("")){
          datos.put(ConstantesREP.ALMACENES, almacen);     
       }
       
       String estMercDisp        = conectorParametroLimpia("estMercDisp", "", true);
       if(!estMercDisp.equals("")){
          datos.put(ConstantesREP.ESTADOMERCANCIADISPONIBLE, estMercDisp);     
       }
       
       String estMercComp        = conectorParametroLimpia("estMercComp", "", true);
       if(!estMercComp.equals("")){
          datos.put(ConstantesREP.ESTADOMERCANCIACOMPROMETIDO, estMercComp);     
       }
       
       String estMercAsign        = conectorParametroLimpia("estMercAsign", "", true);
       if(!estMercAsign.equals("")){
          datos.put(ConstantesREP.ESTADOMERCANCIAASIGNADO, estMercAsign);     
       }
       
       String estMercRes        = conectorParametroLimpia("estMercRes", "", true);
       if(!estMercRes.equals("")){
          datos.put(ConstantesREP.ESTADOMERCANCIARESERVADO, estMercRes);     
       }
       
       datos.put(ConstantesREP.TITULO, "Movimiento diario de almacen");
       
       traza("los datos " + datos);
       //ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-040", null);
       ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-040", "pdf");
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
