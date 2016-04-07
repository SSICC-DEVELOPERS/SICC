
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;

import java.lang.Exception;

import java.util.Vector;

import org.jaxen.dom.DOMXPath;

import org.w3c.dom.Element;
import org.w3c.dom.Node;



public class LPConsultarMatrizFacturacion extends LPSICCBase{

    private String codigoVenta = "";
    private String codigoProducto = "";
    private String descrpcionProdu = "";
    private String tipoOferta = "";
    private String accion;

    public LPConsultarMatrizFacturacion(){
        super();
    }

    public void inicio() throws Exception{
        pagina("contenido_matriz_facturacion_consultar");
        getConfiguracionMenu();
    }

    public void ejecucion() throws Exception{
        accion = conectorParametroLimpia("accion","", true);
        setTrazaFichero();
        traza(">>>> Entrando a LPConsultarMatrizFacturacion <<<<<");
        traza("accion: " + accion);

        try  {
            if( accion.equals("") ){
                traza("Entro por accion vacio");
                conectorParametroSesion("UltimaLP", "LPConsultarMatrizFacturacion");									 				 
                conectorAction("LPSeleccionarMF");
                conectorActionParametro("nueva", "false");
            }else if( accion.equals("Matriz seleccionada") ){                               
        				traza("Entro por accion Matriz Seleccionada ttt");
        				cargarPantalla();             				
                        this.getConfiguracionMenu();
      			}/*else if( accion.equals("Consultar") ){
                traza("Entro por accion Consultar eee");
                cargarPantalla();
                consultarMF();
                this.getConfiguracionMenu();				
            }*/
            
            // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
            agregarMenuComplementario();
            // Fin agregado SICC20070322
            
        } catch (Exception ex)  {
      			lanzarPaginaError(ex);
            ex.printStackTrace();
        }
        
    }
	// 15/09/2005 - pperanzola  - [1] Modificaciones para Codigo unico de venta
    public void cargarPantalla() throws Exception {
        Long oidCabeceraMF = (Long)conectorParametroSesion("oidCabeceraMF");
		this.pagina("contenido_matriz_facturacion_consultar");

        DTOOID dto = new DTOOID();
        dto.setOid(oidCabeceraMF);
        dto.setOidPais(UtilidadesSession.getPais(this));
        dto.setOidIdioma(UtilidadesSession.getIdioma(this));
        MareBusinessID id = new MareBusinessID("PRECargarPantallaConsultarMF");                                                
        Vector parametros = new Vector();
    		parametros.add(dto);
        parametros.add(id);
    		DruidaConector conector = conectar("ConectorCargarPantallaConsultarMF", parametros);
        if (oidCabeceraMF!=null)
            asignarAtributo("VAR","varOidCabeceraMF","valor",oidCabeceraMF.toString());
		    asignar("COMBO", "cbTiposOferta", conector, "dtoSalida.resultado_ROWSET");
		///* [1]



		traza(" >>>>cargarEstrategia ");
		//this.pagina("contenido_catalogo_seleccion"); 
		 
		ComposerViewElementList cv = crearParametrosEntrada();
		ConectorComposerView conectorV = new ConectorComposerView(cv, this.getRequest());
		conectorV.ejecucion();
		traza(" >>>Se ejecuto el conector ");
		DruidaConector resultados = conectorV.getConector();
		asignar("COMBO", "cbEstrategia", resultados, "PRECargarEstrategias");
		traza(" >>>Se asignaron los valores ");
		// */ [1]
		

    }

	private ComposerViewElementList crearParametrosEntrada() throws Exception {
        ComposerViewElementList lista = new ComposerViewElementList(); 
        DTOBelcorp dtobcp = new DTOBelcorp();
 		UtilidadesSession sesion = new UtilidadesSession();

		dtobcp.setOidIdioma(sesion.getIdioma(this));
        dtobcp.setOidPais(sesion.getPais(this));

		ComposerViewElement ci1 = new ComposerViewElement();
        ci1.setIDBusiness("PRECargarEstrategias");         
        ci1.setDTOE(dtobcp);
        lista.addViewElement(ci1);
	    return lista;

    }


    /*public void consultarMF() throws Exception{
        codigoVenta = conectorParametroLimpia("hidCodVenta","",true);
    		codigoProducto = conectorParametroLimpia("hidCodProducto","",true);
    		descrpcionProdu = conectorParametroLimpia("hidDescripcionProdu","",true);
        tipoOferta = conectorParametroLimpia("hidTipoOferta","",true);
        DTOEConsultarMF dto = new DTOEConsultarMF();
        Long oidCabeceraMF = (conectorParametroSesion("oidCabeceraMF") != null)?(Long)conectorParametroSesion("oidCabeceraMF"):null;
        dto.setOidCabeceraMF(oidCabeceraMF);
        dto.setOidIdioma(UtilidadesSession.getIdioma(this));
    		dto.setOidPais(UtilidadesSession.getPais(this));
        dto.setOidTipoOferta(tipoOferta==""?null:Long.getLong(tipoOferta));
        dto.setCodigoProducto(codigoProducto);
        dto.setCodigoVenta(codigoVenta);
        dto.setDescripcionProducto(descrpcionProdu);
        MareBusinessID id = new MareBusinessID("PREConsultarMF");
        Vector parametros = new Vector();
        parametros.add(dto);
        parametros.add(id);
        asignarAtributo("VAR", "hidCodVenta", "valor", codigoVenta);
        asignarAtributo("VAR", "hidCodProducto", "valor", codigoProducto);
    		asignarAtributo("VAR", "hidDescripcionProdu", "valor", descrpcionProdu);
		    asignarAtributo("VAR", "hidTipoOferta", "valor", tipoOferta);
        DruidaConector conector = conectar("ConectorConsultarMF", parametros);
        asignarAtributo("CTEXTO", "txtCodigoVenta", "valor", codigoVenta);
        asignar("LISTADOA", "listado1", conector, "dtoSalida.resultado_ROWSET");
    }

  
    private DruidaConector generarConectorComboLEditable(String rowsetID, RecordSet datos,Vector columns)
		throws DOMException,Exception{
        StringBuffer salida = new StringBuffer();
        int sizeColums = datos.getColumnCount();
        int sizeRows = datos.getRowCount();
        boolean flag = false;
        Text txt;
        if ( columns == null ){
            columns = new Vector();
        }

        Vector columsDesc = datos.getColumnIdentifiers();		
		
        DruidaConector conectorValoresPosibles = new DruidaConector();				
        XMLDocument xmlDoc  = new XMLDocument();
        Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");			
        Element e_rows = docDestino.createElement("ROWSET");
        e_rows.setAttribute("ID",rowsetID);
        docDestino.getDocumentElement().appendChild(e_rows);
		
        for (int i=0; i < sizeRows; i++){
            Element e_row = docDestino.createElement("ROW");
            e_rows.appendChild(e_row);

            for (int j=0; j < sizeColums; j++){
                if ( columns.contains(columsDesc.elementAt(j)) ){
                    Element e_campo2   = docDestino.createElement("CAMPO");
                    if(flag){
                        e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString()+".DESCRIPCION");
                        flag=false;
                    }else{
                        e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString()+".CODIGO");
                        flag=true;
                    }
                    e_campo2.setAttribute("TIPO","OBJECTO");
                    e_campo2.setAttribute("LONGITUD","50");
					
                    txt = docDestino.createTextNode((datos.getValueAt(i,j)==null?"":datos.getValueAt(i,j).toString()));
						
                    e_campo2.appendChild(txt);
                    e_row.appendChild(e_campo2);
                }
            }
        }	
        conectorValoresPosibles.setXML(docDestino.getDocumentElement());
        return conectorValoresPosibles;
    }*/
    // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
    private void agregarMenuComplementario() throws Exception{
        if(conectorParametroSesion("descripcionPeriodo")!=null){
            DOMXPath xform = new DOMXPath("//PAGINA/FORMULARIO[VAR[@nombre='conectorAction']]");
            Element formulario = (Element)xform.selectSingleNode(getXML());
            if(formulario != null)
            {
                DOMXPath xpath = new DOMXPath("//VAR[@nombre='SICC_CUSTOM_TITTLE']");
                Node var = (Node)xpath.selectSingleNode(getXML());
                if(var == null)
                {
                    var = getXML().createElement("VAR");
                    ((Element)var).setAttribute("nombre", "SICC_CUSTOM_TITTLE");
                }
                ((Element)var).setAttribute("valor", (String)conectorParametroSesion("descripcionPeriodo"));
                
                formulario.appendChild(var);
            }
        }
    }
    // Fin agregado SICC20070322
}
