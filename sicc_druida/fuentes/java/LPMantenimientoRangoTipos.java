import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.pre.DTOERangoTipo;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.xml.XMLDocument;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Vector;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class LPMantenimientoRangoTipos extends LPSICCBase {    
    private String casoDeUso = null;
    private String accion = null;
    private Long canal = null;
    private Long marca = null;
    private Long estrategia = null;
    private String sDesde = null;
    private String sHasta = null;
    private Long oid = null;
    private Long oidIdioma = null;
    private Long oidPais = null;
    private String varPais = null;
    private String varMarca = null;
    private String varCanal = null;
    private String varEstrategia = null;
    private Long marcaDef = null;
    private Long canalDef = null;
    
    public LPMantenimientoRangoTipos() { super(); }

    public void inicio() throws Exception { }

    public void ejecucion() throws Exception {      
        try {
            setTrazaFichero();
            casoDeUso = conectorParametro("casoDeUso")==null?"":conectorParametro("casoDeUso");
            accion = conectorParametro("accion")==null?"":conectorParametro("accion");
            canal  = conectorParametro("cbCanal")==null?null:Long.valueOf(conectorParametro("cbCanal"));
            marca  = conectorParametro("cbMarca")==null?null:Long.valueOf(conectorParametro("cbMarca"));
            varPais  = conectorParametro("varPais")==null?"":conectorParametro("varPais");
            varCanal  = conectorParametro("varCanal")==null?"":conectorParametro("varCanal");
            varMarca  = conectorParametro("varMarca")==null?"":conectorParametro("varMarca");
            varEstrategia  = conectorParametro("varEstrategia")==null?"":conectorParametro("varEstrategia");
            sHasta  = conectorParametro("txtNTipHasta")==null?"":conectorParametro("txtNTipHasta");
            sDesde  = conectorParametro("txtNTipDesde")==null?"":conectorParametro("txtNTipDesde");
            estrategia  = conectorParametro("cbEstrategia")==null?null:Long.valueOf(conectorParametro("cbEstrategia"));
            
            oidIdioma = UtilidadesSession.getIdioma(this);
            oidPais = UtilidadesSession.getPais(this);
            marcaDef = UtilidadesSession.getMarcaPorDefecto(this);
            canalDef = UtilidadesSession.getCanalPorDefecto(this);
            traza("Caso de Uso: "+casoDeUso);
            traza("Accion: "+accion);
            if (casoDeUso.equalsIgnoreCase("insertar")){
                if (accion.equals("")){
                    pagina("contenido_rango_tipos_insertar");
                    cargarDatos();
                    setearValoresPorDefecto();
                }
                if (accion.equals("Guardar")){
                    insertar();
                }                 
            }
            if ((casoDeUso.equalsIgnoreCase("consultar")) | (casoDeUso.equalsIgnoreCase("modificar")) |  (casoDeUso.equalsIgnoreCase("eliminar"))) {
                if (accion.equals("")) {
                    traza("entra por consultar ");
                    pagina("contenido_rango_tipos_buscar_modificar");    
                    cargarDatos();
                    setearValoresPorDefecto();
                }
                if (accion.equals("Mostrar datos")) {
                    pagina("contenido_rango_tipos_insertar");
                    mostrarDatos();
                }
                if (accion.equals("modificar")) {
                    pagina("contenido_rango_tipos_insertar");
                    mostrarDatos();
                }
                if (accion.equals("guardar_modif")) {
                    modificar();                     
                }
            }
        }catch(Exception ex){  
            logStackTrace(ex); 
            asignarAtributo("VAR","ejecutarError","valor","onErrorGuardar();");
            this.lanzarPaginaError(ex);
        }
    }

    private void setearValoresPorDefecto() throws Exception {
        asignarAtributo("VAR","marca","valor",this.marcaDef!=null?marcaDef.toString():"");
        asignarAtributo("VAR","canal","valor",this.canalDef!=null?canalDef.toString():"");
    }

    //Este metodo setea el titulo y los iconos del menu secundario
    //dependiendo el caso de uso
    private void cargarMenuSecundario() throws Exception {
        traza(casoDeUso);
       if (casoDeUso.equalsIgnoreCase("Insertar")) {
          getConfiguracionMenu("LPMantenimientoRangoTipos","Insertar");
          asignarAtributoPagina("cod","0593");
       }

       if (casoDeUso.equalsIgnoreCase("Consultar")){
          getConfiguracionMenu("LPMantenimientoRangoTipos","Consultar");
          asignarAtributoPagina("cod","0595");
       }

       if (casoDeUso.equalsIgnoreCase("Modificar")) {
           getConfiguracionMenu("LPMantenimientoRangoTipos","Mostrar");
           asignarAtributoPagina("cod","0594");  
       }
       if (casoDeUso.equalsIgnoreCase("Eliminar")){
        getConfiguracionMenu("LPMantenimientoRangoTipos","Eliminar");
        asignarAtributoPagina("cod","0596");
       }       
    }

    //Este metodo es llamado para cargar valores iniciales
    public void cargarDatos() throws Exception {
        cargarMenuSecundario();
        // -1
        DTOBelcorp dtoe = new DTOBelcorp();
        dtoe.setOidPais( UtilidadesSession.getPais(this) );
        dtoe.setOidIdioma( UtilidadesSession.getIdioma(this) );

        // -2
        ComposerViewElementList lista = new ComposerViewElementList();

        // -3
        ComposerViewElement elem = new ComposerViewElement();
        elem.setIDBusiness( "SEGConsultaCanales" );
        elem.setDTOE( dtoe );
        elem.setPosOID( (byte)0 );
        elem.setPosDesc( (byte)1 );
        lista.addViewElement( elem );

        elem = new ComposerViewElement();
        elem.setIDBusiness( "SEGConsultaMarcas" );
        elem.setDTOE( dtoe );
        elem.setPosOID( (byte)0 );
        elem.setPosDesc( (byte)1 );
        lista.addViewElement( elem );

        elem = new ComposerViewElement();
        elem.setIDBusiness( "PREBuscarEstrategias" );
        elem.setDTOE( dtoe );
        lista.addViewElement( elem );

        // -4
        //Utilizamos el subsistema
        ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());

        if( conector != null ){
            conector.ejecucion();
            DruidaConector resultados = null;
            resultados = conector.getConector();

            // -5
            if( resultados != null ){
                asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas");
                asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");
                asignar("COMBO", "cbEstrategia", resultados, "PREBuscarEstrategias");
            }
        }
        /*cargarPaisMarcaCanal();
        cargarEstrategia();*/
        this.getFormatosValidaciones();
        asignarAtributo("VAR","casoDeUso","valor",casoDeUso);
        asignarAtributo("LABELC","lblPaisX","valor",UtilidadesSession.getDescripcionPais(this));
        asignarAtributo("VAR","accion","valor",this.accion);
        //Cargamos Datos para la pantalla de busqueda
    }

    public void insertar() throws Exception {
          traza("vamos a guardar");
          pagina("salidaGenerica");
          Vector vec = new Vector();
          MareBusinessID id_bus = new MareBusinessID("PREGuardarRangoTipo");
          DTOERangoTipo dto = new DTOERangoTipo();
          dto.setOidPais(this.oidPais);
          dto.setOidIdioma(this.oidIdioma);
          dto.setOidCanal(this.canal);
          dto.setOidEstrategia(this.estrategia);
          dto.setOidMarca(this.marca);
          dto.setTipoDesde(this.sDesde.equals("")?null:Integer.valueOf(sDesde));
          dto.setTipoHasta(this.sHasta.equals("")?null:Integer.valueOf(sHasta));
          vec.add(dto);
          vec.add(id_bus);
          conectar("ConectorGuardarRangoTipo",vec);
          asignarAtributo("VAR","ejecutar","valor","despuesDeGuardar()");
    }

    //Este metodo solamente asigna a los CTEXTO valores que obtiene de variables
    //ocultas, y ademas setea otras variables ocultas
    public void mostrarDatos() throws Exception{
        traza("caso de usp"+this.casoDeUso+ "--" + this.accion);
        oid = (conectorParametro("oidRangoTipos")==null?"":conectorParametro("oidRangoTipos")).equals("")?null:Long.valueOf(conectorParametro("oidRangoTipos")==null?"":conectorParametro("oidRangoTipos"));
        
        cargarMenuSecundario();
        this.getFormatosValidaciones();
        traza(accion+casoDeUso+varPais+varMarca+varCanal+varEstrategia+sDesde+sHasta);
        asignarAtributo("VAR","accion","valor",accion);
        asignarAtributo("VAR","casoDeUso","valor",casoDeUso);                        
        asignarAtributo("VAR","marca","valor",this.varMarca!=null?varMarca:"");
        asignarAtributo("LABELC","lblPaisX","valor",UtilidadesSession.getDescripcionPais(this));
        asignarAtributo("VAR","canal","valor",this.varCanal!=null?varCanal:"");
        asignarAtributo("VAR","estrategia","valor",this.varEstrategia!=null?varEstrategia:"");
        asignarAtributo("VAR","desde","valor",this.sDesde==null?"":this.sDesde.toString());
        asignarAtributo("VAR","hasta","valor",this.sHasta==null?"":this.sHasta.toString());
        asignarAtributo("VAR","oidRangoTipos","valor",this.oid==null?"":this.oid.toString());
    }

    //Este metodo es llamado cuando se quiere modificar
    //puede lanzar una excepcion si hay rango solapado

    public void modificar() throws Exception {
          
          Vector vec = new Vector();
          MareBusinessID id_bus = new MareBusinessID("PREModificarRangoTipo");
          DTOERangoTipo dto = new DTOERangoTipo();
          oid = (conectorParametro("oidRangoTipos")==null?"":conectorParametro("oidRangoTipos")).equals("")?null:Long.valueOf(conectorParametro("oidRangoTipos")==null?"":conectorParametro("oidRangoTipos"));
          traza("Oid: "+oid);
          pagina("salidaGenerica");
          dto.setTipoDesde(this.sDesde.equals("")?null:Integer.valueOf(sDesde));
          dto.setTipoHasta(this.sHasta.equals("")?null:Integer.valueOf(sHasta));
          dto.setOidRangoTipo(oid);
          vec.add(dto);
          vec.add(id_bus);
          conectar("ConectorGuardarRangoTipo",vec);
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

}
