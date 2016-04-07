import es.indra.druida.DruidaConector;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.ape.DTOListaPicado;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.Vector;
import java.util.Date;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class LPImpresionListaPicadoFP extends LPSICCBase {
    private String accion;
    private String opcionMenu;
    private Long idioma;
    private Long pais;

    public LPImpresionListaPicadoFP() {
        super();
    }

    public void inicio() throws Exception {
    }

    public void ejecucion() throws Exception {
        try {
            this.setTrazaFichero();
            this.traza("LPImpresionListaPicadoFP.ejecucion(): Entrada");
            this.rastreo();

            accion = this.conectorParametroLimpia("accion", "", true);
            opcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);
            idioma = UtilidadesSession.getIdioma(this);
            pais = UtilidadesSession.getPais(this);

            if (accion.equals("")) {
                cargarPantalla();
            } else if (accion.equals("imprimir")) {
                imprimir();
            }

            this.getFormatosValidaciones();

            this.asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
            this.asignarAtributo("VAR", "accion", "valor", accion);
            this.asignarAtributo("VAR", "varIdioma", "valor", idioma.toString());
            this.asignarAtributo("VAR", "varPais", "valor", pais.toString());

            this.traza("LPImpresionListaPicadoFP.ejecucion(): Salida");
            
        } catch (Exception e) {
            logStackTrace(e);
            this.lanzarPaginaError(e);
        }
    }

    private void cargarPantalla() throws Exception{
        
        this.traza("LPImpresionListaPicadoFP.cargarPantalla(): Entrada");
    
        // Asignar pagina
        this.pagina("contenido_listas_picado_fuera_pedido_imprimir");

        // Preparando datos para el subsistema de carga inicial
        DTOBelcorp dtoBel = new DTOBelcorp();
        dtoBel.setOidPais(pais);
        dtoBel.setOidIdioma(idioma);
        
        ComposerViewElementList cv = new ComposerViewElementList();
        // Carga de combo marca
        ComposerViewElement cbMarca = new ComposerViewElement();
        cbMarca.setIDBusiness("SEGConsultaMarcas");
        cbMarca.setDTOE(dtoBel);
        // Carga de combo canales
        ComposerViewElement cbCanales = new ComposerViewElement();
        cbCanales.setIDBusiness("SEGConsultaCanales");
        cbCanales.setDTOE(dtoBel);
        
        cv.addViewElement(cbMarca);
        cv.addViewElement(cbCanales);   
        
        // Invocando al Subsistema de Carga Inicial
        ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
        conector.ejecucion();
        DruidaConector resultados = conector.getConector();

        this.asignarAtributoPagina("cod","0979");
        this.getConfiguracionMenu("LPImpresionListaPicadoFP");
        this.asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");                
        this.asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
        
        this.asignarAtributo("CTEXTO", "txtFechaArmado", "valor", UtilidadesBelcorp.fechaFormateada(new Date(),UtilidadesSession.getFormatoFecha(this)));
        
        this.traza("LPImpresionListaPicadoFP.cargarPantalla(): Salida");
        
    }

    private void imprimir() throws Exception {
        this.traza("LPImpresionListaPicadoFP.imprimir (): Entrada");

        this.pagina("salidaGenerica");
        String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
        String ejecutarOK = "ejecutaBien();";
        String ejecutarError = "ejecutaMal();";

        try {
            ArrayList lista = new ArrayList();
            DTOColeccion dtoC = new DTOColeccion();
            DTOListaPicado dtoLP = null;
            String resultado = this.conectorParametroLimpia("resultado","",true);
            this.traza("Lista: " + resultado);
            
            String hListasPicado = conectorParametroLimpia("hListasPicado", "", true);
            RecordSet rListasPicado = null;
            //DTOColeccion dtoLP[] = null;
      
            if (hListasPicado != null) {
              rListasPicado = this.parseaLista(hListasPicado);
              if (rListasPicado != null) {
                //dtoLP = new DTOListaPicado[rListaUsuarios.getRowCount()];
                for (int i = 0; i < rListasPicado.getRowCount(); i++) {
                  dtoLP = new DTOListaPicado();
                  dtoLP.setOidListaPicado(new Long((String)rListasPicado.getValueAt(i,0)));
                  this.traza("rListasPicado.getValueAt(i,0):" + rListasPicado.getValueAt(i,0));
                  /*SI ES QUE SE NECESITA ENVIAR MAS DATOS COMPLETAR AQUI*/
                  /*dtoLP.setOidCentroDistribucion(new Long((String)rListasPicado.getValueAt(i,8)));
                  this.traza("rListasPicado.getValueAt(i,8):" + rListasPicado.getValueAt(i,8));
                  dtoLP.setOidLineaArmado(new Long((String)rListasPicado.getValueAt(i,8)));*/
                  lista.add(dtoLP);
                }
              }
              dtoC.setLista(lista);
            }
			
            Vector params = new Vector();
            
            params.add(dtoC);
            params.add(new MareBusinessID("APEImprimirListaPicadoCabeceraFP"));
            this.traza("LPImpresionListaPicadoFP.imprimir(): Por invocar el conector imprimir");
            this.conectar("ConectorListaPicadoCabeceraFPImprimir", params);
            
            asignarAtributo("VAR", "ejecutar", "valor", ejecutarOK);
            this.traza("LPImpresionListaPicadoFP.imprimir(): Salida OK");

        } catch (Exception e) {
            traza("Excepcion: " + e);
            asignarAtributo("VAR", "ejecutarError", "valor", ejecutarError);
            this.traza("LPImpresionListaPicadoFP.imprimir(): Salida ERROR");
            throw e;
        }
    }

	private RecordSet parseaLista(String sXml) throws Exception {
        traza("sxml: " + sXml);
        sXml = sXml.replaceAll("&", "&amp;");
        String sPropiedadActual = null;
        String sValorCampo = null;
        String sPropiedad = null;
        Node nodeDoc = null;        
        Node nodoRow = null;
        Node nodoCampo = null;
        NodeList nodeList = null;
        NodeList nodeListCampos = null;
        HashMap hshAtributos = new HashMap();
        DocumentBuilder docBuilder = null;
        RecordSet rRetorno = null;
        Vector vFila = null;
   
        ArrayList posicionesOperacion = new ArrayList();
        
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        docBuilder = docBuilderFactory.newDocumentBuilder();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(sXml.getBytes());
        
        nodeDoc = docBuilder.parse(inputStream).getFirstChild();
        traza("nodeDoc: " + nodeDoc.getNodeName());
        nodeList = nodeDoc.getOwnerDocument().getElementsByTagName("ROW");
        //nodeDoc.getChildNodes(); 
        long cantElems = nodeList.getLength();
        traza("cantElems: " + cantElems);

        /* Recorro tags <ROW> */        
        for (int i=0; i<cantElems; i++) {
        
           hshAtributos = new HashMap();
           nodoRow = nodeList.item(i);
           nodeListCampos = nodoRow.getChildNodes();
           long cantCampos = nodeListCampos.getLength();

           /* 
            * Si es la primer iteracion, armo la estrucutra del RecordSet 
            * con el numero de campos
            */            
           if (i == 0) {
              rRetorno = this.armarEstructuraRecordSet(cantCampos);             
           }
           
            /* Recorro tags <CAMPO> */
           vFila = new Vector(); 
           for (int j=0; j<cantCampos; j++) {
               nodoCampo = nodeListCampos.item(j);
               /* sPropiedad = this.obtenerPropiedadCampo(nodoCampo);*/
               sValorCampo = this.obtenerValorCampo(nodoCampo);
               vFila.add(sValorCampo);
           }
           rRetorno.addRow(vFila);
        }

        return rRetorno;
    }  

  private RecordSet armarEstructuraRecordSet(long cantCampos)
          throws Exception {
          
      RecordSet r = new RecordSet();
      Vector vCampos = new Vector();
      String sCampo = "campo_";
      
      for (int i=0; i < cantCampos; i++ ){
         vCampos.add(sCampo + i);
      }
      
      r.setColumnIdentifiers(vCampos);
      return r;
  }

    private String obtenerValorCampo(Node nodo) 
          throws Exception {
        Node textNode = nodo.getFirstChild();
        String sValorCampo = null;
        if (textNode != null) { 

          sValorCampo = textNode.getNodeValue();
        } else {
          sValorCampo = "";
        }
        return sValorCampo;
    } 

    private void logStackTrace(Throwable e) throws Exception {
        this.traza("Se produjo la excepcion, en LPImpresionListaPicadoFP: " + e.getMessage());

        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);

        if (e instanceof MareException) {
            MareException e2 = (MareException) e;
            traza("Es una mare Exception con codigo de error: " + e2.getCode());
        }

        e.printStackTrace(out);
        this.traza("stack Trace : " + pila.toString());
    }

}
