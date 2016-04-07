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

public class MAVStatusProductoMav extends LPSICCBase {           
   public MAVStatusProductoMav() {	 
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
           getConfiguracionMenu("MAVStatusProductoMav");
        }
     
     } catch (Exception ex) {
     			
        cargarPagina();
        getConfiguracionMenu("MAVStatusProductoMav");
               
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
     pagina("contenido_informe_status_producto_generar");   
    
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
     
     ComposerViewElementList cv = crearParametrosEntrada();
     ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
     conector.ejecucion();
     DruidaConector resultados = conector.getConector();
     traza(" 4 " + resultados.getXML());
          
     asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");             
     asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
     
     //carga el combo de ciclos de vida
     DTOBelcorp dtoB = new DTOBelcorp();
     MareBusinessID idCV = new MareBusinessID("PREObtenerCiclosVida");
     dtoB.setOidIdioma(UtilidadesSession.getIdioma(this));
     Vector vecCV = new Vector();
     vecCV.add(dtoB);
     vecCV.add(idCV);
     DTOSalida dtoSalCV = (DTOSalida)conectar("ConectorCicloVida",vecCV).objeto("dtoSalida"); 
     RecordSet ciclo = (RecordSet)dtoSalCV.getResultado();
     Vector colCICLO = ciclo.getColumnIdentifiers();
     DruidaConector ciclos = generarConector("DTOSalida.ciclos_ROWSET",ciclo, colCICLO);
     asignar("COMBO", "cbCicloVida", ciclos, "DTOSalida.ciclos_ROWSET");  
      
      //carga el combo de tipo oferta
     DTOOID dtoTO = new DTOOID();
     MareBusinessID idTO = new MareBusinessID("PREObtenerTiposOfertaPorCanal");
     dtoTO.setOidIdioma(UtilidadesSession.getIdioma(this));
     dtoTO.setOid(UtilidadesSession.getCanalPorDefecto(this));
     Vector vecTO = new Vector();
     vecTO.add(dtoTO);
     vecTO.add(idTO);
     DTOSalida dtoSalTO = (DTOSalida)conectar("ConectorTipoOferta",vecTO).objeto("dtoSalida"); 
     RecordSet oferta = (RecordSet)dtoSalTO.getResultado();
     Vector colOFERTA = oferta.getColumnIdentifiers();
     DruidaConector ofertas = generarConector("DTOSalida.ofertas_ROWSET",oferta, colOFERTA);
     asignar("COMBO", "cbTipoOferta", ofertas, "DTOSalida.ofertas_ROWSET");   
     
     asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
     asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
     
     
     DTOTipoSubtipo dtotsubtipo = new DTOTipoSubtipo(); 
     DTOBelcorp dtoBelcorp = new DTOBelcorp();
     dtoBelcorp.setOidPais(UtilidadesSession.getPais(this));
     dtoBelcorp.setOidIdioma(UtilidadesSession.getIdioma(this));
     dtotsubtipo = (DTOTipoSubtipo) obtenerDatosSalida("MAEObtenerTipoSubtipo", "ConectorTipoSubtipo", (DTOBelcorp) dtoBelcorp);
     RecordSet tipo = (RecordSet) dtotsubtipo.getTipos();
     Vector colID = tipo.getColumnIdentifiers();
     DruidaConector dtipo = this.generarConector("DTOSalida.tipos_ROWSET", tipo, colID);
     asignar("COMBO", "cbTipoCliente", dtipo, "DTOSalida.tipos_ROWSET");
     
           
   
  }
          
  
 private void generarReporte() throws Exception{
     
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "MAV");
     
     //comienzo de los parametrso de filtrado
       
     String pais        = conectorParametroLimpia("paisSelec", "", true);
     datos.put(ConstantesREP.PAIS, pais);     
     
     String marca        = conectorParametroLimpia("marca", "", true);
     String marcaDesc        = conectorParametroLimpia("marcaDesc", "", true);
     datos.put(ConstantesREP.MARCA, marca);     
     datos.put(ConstantesREP.MARCADESC, marcaDesc);     
          
     String canal        = conectorParametroLimpia("canal", "", true);
     String canalDesc        = conectorParametroLimpia("canalDesc", "", true);
     datos.put(ConstantesREP.CANAL, canal); 
     datos.put(ConstantesREP.CANALDESC, canalDesc); 
            
     String periodo        = conectorParametroLimpia("periodo", "", true);
     datos.put(ConstantesREP.PERIODO, periodo);
     
     String periodoDesc = conectorParametroLimpia("periodoDesc", "", true);
     datos.put(ConstantesREP.PERIODODESC, periodoDesc);
     
     String actividad        = conectorParametroLimpia("actividad", "", true);
     if(!actividad.equals("")){
        datos.put(ConstantesREP.ACTIVIDADES, actividad);     
     }
     
      String codProdDesde        = conectorParametroLimpia("codProdDesde", "", true);
     if(!codProdDesde.equals("")){
        datos.put(ConstantesREP.CODIGOPRODUCTODESDE, codProdDesde);     
     }
     
     String codProdHasta        = conectorParametroLimpia("codProdHasta", "", true);
     if(!codProdHasta.equals("")){
        datos.put(ConstantesREP.CODIGOPRODUCTOHASTA, codProdHasta);     
     }
     
     String codVentaDesde        = conectorParametroLimpia("codVentaDesde", "", true);
     if(!codVentaDesde.equals("")){
        datos.put(ConstantesREP.CODIGOVENTADESDE, codVentaDesde);     
     }
     
     String codVentaHasta        = conectorParametroLimpia("codVentaHasta", "", true);
     if(!codVentaHasta.equals("")){
        datos.put(ConstantesREP.CODIGOVENTAHASTA, codVentaHasta);     
     }
     
     String operadorPrecioCatalogo        = conectorParametroLimpia("operadorPrecioCatalogo", "", true);
     datos.put(ConstantesREP.OPERADORPRECIOCATALOGO, this.devolverOperador(operadorPrecioCatalogo));     
     
     String precioCatalogo = conectorParametroLimpia("precioCatalogo", "", true);
     if(!precioCatalogo.equals("")){
        datos.put(ConstantesREP.PRECIOCATALOGO, precioCatalogo);
     }
     
     String operadorPrecioContable        = conectorParametroLimpia("operadorPrecioContable", "", true);
     datos.put(ConstantesREP.OPERADORPRECIOCONTABLE, this.devolverOperador(operadorPrecioContable));     
     
     String precioContable = conectorParametroLimpia("precioContable", "", true);
     if(!precioContable.equals("")){
        datos.put(ConstantesREP.PRECIOCONTABLE, precioContable);
     }
     
     String operadorUnidadesEstimadas        = conectorParametroLimpia("operadorUnidadesEstimadas", "", true);
     datos.put(ConstantesREP.OPERADORCANTIDADESTIMADA, this.devolverOperador(operadorUnidadesEstimadas));     
     
     String unidadesEstimadas = conectorParametroLimpia("unidadesEstimadas", "", true);
     if(!unidadesEstimadas.equals("")){
        datos.put(ConstantesREP.UNIDADESTIMADA, unidadesEstimadas);
     }   
     
     String tipoCliente        = conectorParametroLimpia("tipoCliente", "", true);
     if(!tipoCliente.equals("")){
        datos.put(ConstantesREP.TIPOCLIENTES, tipoCliente);     
     }    
       
     String cicloVida        = conectorParametroLimpia("cicloVida", "", true);
     if(!cicloVida.equals("")){
        datos.put(ConstantesREP.CICLOVIDAS, cicloVida);     
     }
     
     String tipoOferta        = conectorParametroLimpia("tipoOferta", "", true);
     if(!tipoOferta.equals("")){
        datos.put(ConstantesREP.TIPOOFERTA, tipoOferta);     
     }
     
     String reporte = null;
     String seleccion = conectorParametroLimpia("seleccion", "", true);
	 String criterio = conectorParametroLimpia("seleccionCriterio", "", true);
     
     if(seleccion.equals("1")){
	    if(criterio.equals("1")){
			reporte = "RD_REP-031_01";
		}else{
			reporte = "RD_REP-031_03";
		}
     }else{
		if(criterio.equals("1")){
			reporte = "RD_REP-031_02";
		}else{
		    reporte = "RD_REP-031_04";
		}
     }
	    
  
     datos.put(ConstantesREP.TITULO, "ESTATUS DE PRODUCTOS MAV – PERÍODO " + periodoDesc);
     traza("++++++Antes de enviar a reportes " + datos); 
     //ejecutarReporte(datos, "REPGenerarReporte", reporte, null);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", reporte, "pdf");
          
  } 
  
  private String devolverOperador(String oidOperador) throws Exception{
     
     String strOperador = null;
     
     if(oidOperador.equals("1")){
        strOperador = "'<'";
     }
     
     if(oidOperador.equals("2")){
        strOperador = "'>'";
     }
     
     if(oidOperador.equals("3")){
        strOperador = "'='";
     }
     
     if(oidOperador.equals("4")){
        strOperador = "'<='";
     }
     
     if(oidOperador.equals("4")){
        strOperador = "'>='";
     } 
  
     return strOperador;
  
  
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
  
  private Object obtenerDatosSalida(String bID, String conector, Object dto) throws Exception {
      
            //traza("entro a ObtenerDatos Salida");
            Vector paramEntrada = new Vector();
            MareBusinessID id = new MareBusinessID(bID);
            paramEntrada.add(dto);
            paramEntrada.add(id);

            //traza("****************dto del obtener: " + dto);
            //traza("****************id del obtener: " + id.getBusinessID());
            //traza("*********Conector " + conector);
            DruidaConector ver = conectar(conector, paramEntrada);
            Object obj = ver.objeto("DTOSalida");

            //traza("ver DTOSalida " + obj.toString());
            return obj;
        
    }

    
  
 
 


}






