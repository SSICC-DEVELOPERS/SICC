
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.cob.DTOAsignacionesCobranza;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;
import java.math.BigDecimal;
import java.util.Vector;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class LPReasignarCarteraSaldos extends LPSICCBase {
    
    
    private String accion;
    private String pais;
    private String idioma;

	public LPReasignarCarteraSaldos() {	super();	}

	public void inicio() throws Exception {
        pagina ("contenido_cartera_saldos_reasignar");
    }
  
  public void ejecucion() throws Exception {
    setTrazaFichero();
    getFormatosValidaciones();
    try  {
          //this.rastreo();
          traza(" Entrando a LPReasignarCarteraSaldos.ejecucion");
          pais = (UtilidadesSession.getPais(this)).toString();
          idioma = (UtilidadesSession.getIdioma(this)).toString();
          
          asignarAtributo("VAR","oidPais","valor", pais.toString());
          asignarAtributo("VAR","oidIdioma","valor", idioma.toString());
          
          
          accion = conectorParametroLimpia("accion", "", true);
          traza("Accion de sesion: " + accion);
          if( accion.equals("")){
            
            getConfiguracionMenu("LPReasignarCarteraSaldos", accion);	
            this.cargarPagina();
            
          }else if( accion.equals("buscar") ){
                // splatas - 10/05/2006 - DBLG400000888
                this.buscar();
                
          }else if( accion.equals("reasignar")){
                    //getConfiguracionMenu("LPReasignarCarteraSaldos", accion);	
                this.reasignar();
          }
          
    }
    catch ( Exception e )  {
      traza("Exception en LPConsultarResumenAsignacion");
      e.printStackTrace();     
      lanzarPaginaError(e);
    }
  }
  
  
  	private void cargarPagina() throws Exception{
    
          ComposerViewElementList cv = crearParametrosEntrada();

    
          traza ("cv " + cv);
          
          ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
          traza ("conector " +conector);
          conector.ejecucion();
          traza("Ejecutado");                                    
          // 5.- DruidaConector conConsultar = conectar("ConectorCargaPantalla", paramEntrada); 
          DruidaConector conConsultar = conector.getConector(); 
          asignar("COMBO", "cbUsuarioOrigen", conConsultar, "COBObtenerUsuariosCobCombo");
          asignar("COMBO", "cbMarca", conConsultar, "SEGConsultaMarcas");
          asignar("COMBO", "cbCanal", conConsultar, "SEGConsultaCanales");
          
          
      }
    
    
        private ComposerViewElementList crearParametrosEntrada()throws Exception {
        traza("en crearParamentrosEntrada");
        DTOBelcorp dtoBel =  new DTOBelcorp();
        dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));
        dtoBel.setOidPais(UtilidadesSession.getPais(this));
        
        ComposerViewElementList lista = new ComposerViewElementList();
    
        //Combo canal
        ComposerViewElement ci1 = new ComposerViewElement();
        ci1.setIDBusiness("SEGConsultaCanales");
        ci1.setDTOE(dtoBel);
        
        //Combo marca
        ComposerViewElement ci2 = new ComposerViewElement();
    		ci2.setIDBusiness("SEGConsultaMarcas");
        ci2.setDTOE(dtoBel);
        
        //Combo grupo procesos
        ComposerViewElement ci3 = new ComposerViewElement();
        ci3.setIDBusiness("COBObtenerUsuariosCobCombo");
        ci3.setDTOE(dtoBel);

        lista.addViewElement(ci1);
        lista.addViewElement(ci2);
        lista.addViewElement(ci3);
        
        traza("saliendo de crearParamentrosEntrada");        
        return lista;
	}
  
  
  private void reasignar ()throws Exception {
  
     MareBusinessID id = new MareBusinessID("COBReasignarCartera");
     DTOAsignacionesCobranza dto = new DTOAsignacionesCobranza();
     
     dto.setOidIdioma(new Long(idioma));
     dto.setOidPais(new Long(pais));
     
     traza ("Idioma" + dto.getOidIdioma());  
     traza ("pais" + dto.getOidPais());  
     String usuarioOrigen = conectorParametro("usuarioOrigen");
     
     String usuarioDestino  = conectorParametro("usuarioDestino");
     traza ("usuarioDestino"+ usuarioDestino);
     
     String etapaDeuda =   conectorParametro("etapaDeuda");
     traza ("etapaDeuda"+ etapaDeuda);
     
     String marca = conectorParametro("marca");
     traza ("marca"+ marca);
     
     String canal = conectorParametro("canal");
     traza ("canal"+ canal);
     
     String periodo = conectorParametro("periodo");
     traza ("periodo"+ periodo);
     
     String porcentajeHasta =  conectorParametro("porcentajeHasta");
     traza ("porcentajeHasta"+ porcentajeHasta);
     
     String importeHasta = conectorParametro("importeHasta");
     traza ("importeHasta"+ importeHasta);
     
     if ((usuarioOrigen != null) && !(usuarioOrigen.equals(""))){
          dto.setUsuarioOrigen(new Long(usuarioOrigen)); 
          traza ("usuarioOrigen"+ usuarioOrigen);
     }
     if ((usuarioDestino != null) && !(usuarioDestino.equals(""))){
          dto.setUsuarioDestino(new Long(usuarioDestino));
          traza ("usuarioDestino"+ usuarioDestino);
     }
     
     if ((etapaDeuda != null) && !(etapaDeuda.equals(""))){
            dto.setEtapaDeuda(new Long(conectorParametro("etapaDeuda")));
            traza ("etapaDeuda"+ etapaDeuda);
     }
     
     if ( (marca != null) && !(marca.equals(""))){
            dto.setMarca(new Long(marca));
            traza ("marca"+ marca);
     }
     if ((canal != null) && !(canal.equals(""))){
          dto.setCanal(new Long(canal));
          traza ("canal"+ canal);
     }     
     
     
     if ((periodo != null) &&!(periodo.equals(""))){
          dto.setPeriodo(new Long(periodo));
          traza ("periodo"+ periodo);
          
    }   
     
     if ((porcentajeHasta != null) && !(porcentajeHasta.equals(""))){
          dto.setPorcentajeHasta(new Float(porcentajeHasta));
          traza ("porcentajeHasta"+ porcentajeHasta);
     }
          
     if ((importeHasta != null) && !(importeHasta.equals(""))){
          dto.setImporteHasta( new BigDecimal(importeHasta));
          traza ("importeHasta"+ importeHasta);
    }    
    
      dto.setPaginado(null);
      dto.setRegion(null);
      dto.setSubgerencia(null);
      dto.setSeccion(null);
      dto.setTerritorio(null);
      dto.setZona(null);
    
      Vector parametros = new Vector();
      parametros.add(dto);
      parametros.add(id);
      traza("Conectando a ConectorReasignarCartera... ");
      DruidaConector conector = conectar("ConectorReasignarCartera", parametros);
      traza("Conectó.");
      
      this.buscar();
      //this.asignarAtributo("VAR", "ejecutar", "valor", "buscarOnClick()");

          //-> Asignar conector "ConectorReasignarCartera" con idBusiness y dto creados
  
  }
  
  /**
   * splatas - 10/05/2006 - DBLG400000888
   * Método que reemplaza la búsqueda original
   */
  private void buscar()throws Exception {
    /* configurarPaginado(mipgndo,"COBBuscarAsignacionesCobranza","ConectorBuscarAsignacionesCobranza",
     *                    "es.indra.sicc.dtos.cob.DTOAsignacionesCobranza", armarArray());
    */
    traza("Entra al método LPReasignarCarteraSaldos.buscar()....");
    
    asignar("VAR", "hListaVisible", "1");    
    
    MareBusinessID id = new MareBusinessID("COBBuscarAsignacionesCobranza");
    DTOAsignacionesCobranza dto = new DTOAsignacionesCobranza();
    
    dto.setOidIdioma(new Long(idioma));
    dto.setOidPais(new Long(pais));
 
    traza ("Idioma" + dto.getOidIdioma());  
    traza ("pais" + dto.getOidPais());  
    String usuarioOrigen = conectorParametro("cbUsuarioOrigen");
     
    String usuarioDestino  = conectorParametro("cbUsuarioDestino");
    traza ("usuarioDestino"+ usuarioDestino);
     
    String etapaDeuda =   conectorParametro("cbCodEtapaDeuda");
    traza ("etapaDeuda"+ etapaDeuda);
     
    String marca = conectorParametro("cbMarca");
    traza ("marca"+ marca);
     
    String canal = conectorParametro("cbCanal");
    traza ("canal"+ canal);
 
    String periodo = conectorParametro("cbCodPeriodo");
    traza ("periodo"+ periodo);
 
    String porcentajeHasta =  conectorParametro("txtPorcentajeHasta");
    traza ("porcentajeHasta"+ porcentajeHasta);
 
    String importeHasta = conectorParametro("txtImporteHasta");
    traza ("importeHasta"+ importeHasta);
 
    if ((usuarioOrigen != null) && !(usuarioOrigen.equals(""))){
        dto.setUsuarioOrigen(new Long(usuarioOrigen)); 
        traza ("usuarioOrigen"+ usuarioOrigen);
    }
    
    if ((usuarioDestino != null) && !(usuarioDestino.equals(""))){
        dto.setUsuarioDestino(new Long(usuarioDestino));
        traza ("usuarioDestino"+ usuarioDestino);
    }
 
    if ((etapaDeuda != null) && !(etapaDeuda.equals(""))){
        dto.setEtapaDeuda(new Long(etapaDeuda));
        traza ("etapaDeuda"+ etapaDeuda);
    }
 
    if ( (marca != null) && !(marca.equals(""))){
        dto.setMarca(new Long(marca));
        traza ("marca"+ marca);
    }
    
    if ((canal != null) && !(canal.equals(""))){
        dto.setCanal(new Long(canal));
        traza ("canal"+ canal);
    }     
 
    if ((periodo != null) &&!(periodo.equals(""))){
        dto.setPeriodo(new Long(periodo));
        traza ("periodo"+ periodo);
    }   
 
    if ((porcentajeHasta != null) && !(porcentajeHasta.equals(""))){
        dto.setPorcentajeHasta(new Float(porcentajeHasta));
        traza ("porcentajeHasta"+ porcentajeHasta);
    }
      
    if ((importeHasta != null) && !(importeHasta.equals(""))){
        dto.setImporteHasta( new BigDecimal(importeHasta));
        traza ("importeHasta"+ importeHasta);
    }    

    this.cargarPagina();
    
    traza("reasigno las variables...");    
    asignar("VAR", "usuarioOrigen", usuarioOrigen);
    asignar("VAR", "usuarioDestino", usuarioDestino);
    asignar("VAR", "etapaDeuda", etapaDeuda);
    asignar("VAR", "marca", marca);
    asignar("VAR", "canal", canal);
    asignar("VAR", "periodo", periodo);
    asignar("VAR", "porcentajeHasta", porcentajeHasta);
    asignar("VAR", "importeHasta", importeHasta);   
   
    Vector parametros = new Vector();
    parametros.add(dto);
    parametros.add(id);
    
    traza("Conectando...");
    DTOSalida dtoSalCrono = (DTOSalida)conectar("ConectorBuscarAsignacionesCobranza", parametros).objeto("dtoSalida"); 
    traza("dtoSalCrono = " + dtoSalCrono.toString());
    
    traza("genero el RecordSet...");     
    RecordSet crono = (RecordSet)dtoSalCrono.getResultado();
    traza("El RecordSet 'crono' = " + crono.getColumnIdentifiers());
    
    Vector colCRONO = crono.getColumnIdentifiers();
     
    traza("genera el conector...");
    DruidaConector cronogramas = generarConector("LISTA", crono, colCRONO);
    
    traza("asigno la listaEditable...");
    asignar("LISTADOA", "listado1", cronogramas, "LISTA");   
    
  }
    
  /**
   *    splatas - DBLG400000888 - 10/05/2006 
   */
  private DruidaConector generarConector(String rowsetID, RecordSet datos,Vector columns) throws DOMException, Exception {
   
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
          e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
          e_campo2.setAttribute("TIPO", "OBJECTO");
          e_campo2.setAttribute("LONGITUD", "50");
          
          Text txt = docDestino.createTextNode(((datos.getValueAt(i, j) == null)? "" : datos.getValueAt(i, j).toString()));
          e_campo2.appendChild(txt);
          e_row.appendChild(e_campo2);
        }
      }
    }
    
    conectorValoresPosibles.setXML(docDestino.getDocumentElement());
 
    return conectorValoresPosibles;
  }
  
}
