   /**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.pre.DTOTextoOferta;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Vector;

import org.jaxen.dom.DOMXPath;

import org.w3c.dom.Element;
import org.w3c.dom.Node;


public class LPDefinirTextosOfertas extends LPSICCBase{

    private Long oidCabeceraMF = null;
    private Long oid = null;
    private Long numeroOrden = null;
    private Long pais = null;
    private Long idioma = null;
    private String accion = null;
    private String modal = null;
    private String textoOferta = null;
    private Long oidCatalogo = null;
    
    public LPDefinirTextosOfertas() {
        super();
    }  

     public void inicio() throws Exception {
     }
     
    public void ejecucion() throws Exception {
    
        setTrazaFichero();
        try{
            //this.rastreo();
            accion = conectorParametro("accion")==null?"":conectorParametro("accion");
            modal = conectorParametro("modal")==null?"":conectorParametro("modal");
            traza("modal: "+modal);
            traza ("accion:  " + accion);

            pais = UtilidadesSession.getPais(this);
            idioma = UtilidadesSession.getIdioma(this);

            if (accion.equals("")){
                conectorParametroSesion("UltimaLP","LPDefinirTextosOfertas");
                conectorAction("LPSeleccionarMF");
                this.pagina("contenido_textos_definir");
                this.getFormatosValidaciones();
            }else if (accion.equals("Matriz seleccionada")||accion.equals("Matrizseleccionada")){
				this.matrizSeleccionada();
            }else if (accion.equals("guardarTextoOferta")){
                guardarTextoOferta();
            }else if (accion.equals("eliminarTextoOferta")){
                eliminarTextoOferta();        
            }else if (accion.equals("Buscar texto")){
                obtenerTextoOferta();
            }else if (accion.equals("salir")){
                    traza("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                   if ((conectorParametroSesion("UltimaLP")).equals("LPConsultarOrdenOfertas")) {
                    
                    traza("LPDefinirTextosOfertas-Salir......: Invocando UltimaLP: "+
                                    (String)conectorParametroSesion("UltimaLP"));
                    traza("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    conectorAction((String)conectorParametroSesion("UltimaLP"));
                }
                else
                {
                    traza("LPDefinirTextosOfertas-Salir......: Invocando LPSeleccionarMF ");
                    traza("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    conectorAction((String)conectorParametroSesion("LPSeleccionarMF"));
                }
            }

            // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
            agregarMenuComplementario();
            // Fin agregado SICC20070322

         }catch(Exception ex){
            asignarAtributo("VAR","ejecutarError","valor","enError()");
            logStackTrace(ex);
            lanzarPaginaError(ex);
        } 
    } 


	private void matrizSeleccionada() throws Exception {
		pagina("contenido_textos_definir");

		this.cargarCatalogo();
		
		getConfiguracionMenu("LPDefinirTextosOfertas","");
		this.getFormatosValidaciones();
		asignarAtributo("VAR","modal","valor",modal);
	}


	private void cargarCatalogo() throws Exception {
        traza("cargarCatalogo()");
		// Se llama al idBusiness "PRECargarCatalogos" pasandole un DTOBelcorp -oidIdioma -oidPais 
		// Se decidio reutilizar la el id de negocio MAVCargarCatalagosBP que tiene la misma funcion
        ComposerViewElementList cvLista = new ComposerViewElementList();
        ComposerViewElement cvCatalogos = new ComposerViewElement();
        cvCatalogos.setIDBusiness("MAVCargarCatalagosBP");
        DTOBelcorp dtoBelcorp = new DTOBelcorp();
        dtoBelcorp.setOidPais(pais);
        dtoBelcorp.setOidIdioma(idioma);
		cvCatalogos.setDTOE(dtoBelcorp);
        cvLista.addViewElement(cvCatalogos);

        ConectorComposerView conector = new ConectorComposerView(cvLista, this.getRequest());
        conector.ejecucion();
        DruidaConector conConsultar = conector.getConector();

        // Cargamos los combos con los resultados
        traza("cargar combo catalogo");
        asignar("COMBO", "cbCatalogo", conConsultar, "MAVCargarCatalagosBP"); 
	}


   private void guardarTextoOferta() throws Exception {
		traza("guardarTextoOferta()");
        pagina("salidaGenerica");
        asignarAtributo("VAR", "cerrarVentana", "valor", "false");
        DTOTextoOferta dtoTextoOferta = null;
        MareDTO dtoSalida = null;
        
        numeroOrden = Long.valueOf(conectorParametro("txtNOrden"));
        oidCatalogo = Long.valueOf(conectorParametro("hOidCatalogo"));
		traza("numeroOrden: " + numeroOrden + " oidCatalogo: " + oidCatalogo);

		try{
            oid = Long.valueOf(conectorParametro("hidOid"));
        }catch(Exception e){
            oid=null;
        }
        textoOferta = conectorParametro("areaTexto");

        this.oidCabeceraMF = (Long)conectorParametroSesion("oidCabeceraMF");
        
        DruidaConector conectorGuardarTextoOfertas = null;
        /* Creo el DTOTextoOferta y seteo todas sus atributos
        * menos el oid ya que lo crea el servidor
        */
        MareBusinessID id = new MareBusinessID("PREGuardarTextoOferta");
        DTOTextoOferta dto = new DTOTextoOferta();
        dto.setNumeroOrden(numeroOrden);
        dto.setOidCabeceraMF(oidCabeceraMF);
        dto.setTexto(textoOferta);
        dto.setOidPais(pais);
        dto.setOidIdioma(idioma);
        dto.setOid(oid);
		dto.setOidCatalogo(oidCatalogo);
        traza(dto);
        Vector param = new Vector();
        param.add(dto);
        param.add(id);

        conectar("ConectorGuardarTextoOferta",param);
        asignarAtributo("VAR","ejecutar","valor","despuesDeGuardarEliminar()");
	}


    private void eliminarTextoOferta() throws Exception {
        traza("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        traza("Entrando a eliminarTextoOferta");
        try{
            oid = Long.valueOf(conectorParametro("hidOid"));
        }catch(Exception e){
            oid=null;
        }
        pagina("salidaGenerica");   
        asignarAtributo("VAR", "cerrarVentana", "valor", "false");
        if ( (oid.toString() != "") && (oid!= null)) {
            traza ("Eliminando ---> oid: "+  oid.toString()  );
                        
            DruidaConector conectorEliminarTextoOferta = null;
            MareBusinessID id = new MareBusinessID("PREEliminarTextoOferta");
            DTOOID dto = new DTOOID();
            dto.setOid(oid);
            dto.setOidPais(pais);
            dto.setOidIdioma(idioma);
            
            Vector param = new Vector();
            param.add(dto);
            param.add(id);
            traza("++++++++++TRAZA DEL PARAM A ENVIAR PARA ELIMINAR +++++");
            traza(param);

            conectorEliminarTextoOferta = conectar("ConectorEliminarTextosOfertas",param);
            traza("++++++++++ ELIMINANDO TEXTO DE OFERTAS ++++++++++++");
            // Mostrar la pantalla vacia
            asignarAtributo("VAR","ejecutar","valor","despuesDeGuardarEliminar()");
        } else {
            throw new MareException(new Exception(), 50031);
        }
    }

    private void obtenerTextoOferta() throws Exception {
        pagina("salidaGenerica");  
        asignarAtributo("VAR", "cerrarVentana", "valor", "false");
        DruidaConector conectorObtenerTextoOferta = null;
        MareBusinessID id = new MareBusinessID("PREObtenerTextoOferta");
        DTOTextoOferta dto = new DTOTextoOferta();
        dto.setOidCabeceraMF((Long)conectorParametroSesion("oidCabeceraMF"));
        dto.setOidPais(pais);
        dto.setOidIdioma(idioma);
        dto.setNumeroOrden(Long.valueOf(conectorParametro("txtNOrden")));
        traza("dtoTextoOferta " + dto);
        Vector param = new Vector();
        param.add(dto);
        param.add(id);

        conectorObtenerTextoOferta = conectar("ConectorObtenerTextoOferta",param);
        MareDTO dtoSalida = (MareDTO)conectorObtenerTextoOferta.objeto("dtoSalida");
        if (dtoSalida == null){
            traza("NO Existe el Texto");
            asignarAtributo("VAR","ejecutar","valor","despuesDeValidar('')");
        }else{
            if(dtoSalida.containsKey("oid")){
                traza("++++++++++ Registro existente +++++++++++++");
                DTOTextoOferta dtoS=  (DTOTextoOferta )dtoSalida;
                if (dtoS.getTexto()!=null){
                    traza("Texto Existe");
                    String s = "despuesDeValidar('"+dtoS.getOidCatalogo()+"', '"+dtoS.getTexto()+"', '"+dtoS.getOid()+"')";
                    traza(s);
                    asignarAtributo("VAR","ejecutar","valor",s);
                }else{
                    traza("Texto No Existe");
                    asignarAtributo("VAR","ejecutar","valor","despuesDeValidar('', '', '"+dtoS.getOid()+"')");
                }
            }
        }
    }
    
    private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());

        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);

        if (e instanceof MareException) {
            MareException e2=(MareException)e;
            traza("Es una mare Exception con codigo de error: "+e2.getCode());
        }
        e.printStackTrace(out);
        traza("stack Trace : " +  pila.toString());
    }
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
