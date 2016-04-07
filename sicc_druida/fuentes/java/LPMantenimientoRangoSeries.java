import LPSICCBase;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.dtos.pre.DTOERangoSerie;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Vector;

public class LPMantenimientoRangoSeries extends LPSICCBase{

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
             
    public void inicio() throws Exception{
    }
  
    public void ejecucion() throws Exception{
        try{
             setTrazaFichero();
             casoDeUso = conectorParametro("casoDeUso")==null?"":conectorParametro("casoDeUso");
             accion = conectorParametro("accion")==null?"":conectorParametro("accion");
             canal  = conectorParametro("cbCanal")==null?null:Long.valueOf(conectorParametro("cbCanal"));
             marca  = conectorParametro("cbMarca")==null?null:Long.valueOf(conectorParametro("cbMarca"));
             varPais  = conectorParametro("varPais")==null?"":conectorParametro("varPais");
             varCanal  = conectorParametro("varCanal")==null?"":conectorParametro("varCanal");
             varMarca  = conectorParametro("varMarca")==null?"":conectorParametro("varMarca");
             varEstrategia  = conectorParametro("varEstrategia")==null?"":conectorParametro("varEstrategia");
             sHasta  = conectorParametro("txtNSerHasta")==null?"":conectorParametro("txtNSerHasta");
             sDesde  = conectorParametro("txtNSerDesde")==null?"":conectorParametro("txtNSerDesde");
             estrategia  = conectorParametro("cbEstrategia")==null?null:Long.valueOf(conectorParametro("cbEstrategia"));
             //oid = (conectorParametro("oidRangoSerie")==null?"":conectorParametro("oidRangoSerie")).equals("")?null:Long.valueOf(conectorParametro("oidRangoSerie")==null?"":conectorParametro("oidRangoSerie"));
             
             oidIdioma = UtilidadesSession.getIdioma(this);
             oidPais = UtilidadesSession.getPais(this);
             marcaDef = UtilidadesSession.getMarcaPorDefecto(this);
             canalDef = UtilidadesSession.getCanalPorDefecto(this);
             traza("Caso de Uso: "+casoDeUso);
             traza("Accion: "+accion);
             if (casoDeUso.equals("insertar")){
                  if (accion.equals("")){
                      pagina("contenido_rango_series_insertar");
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
                      pagina("contenido_rango_series_buscar_modificar");    
                      cargarDatos();  
                      setearValoresPorDefecto();
                  }
                  if (accion.equals("Mostrar datos")) {
                      pagina("contenido_rango_series_insertar");
                      mostrarDatos();
                  }
                  if (accion.equals("modificar")) {
                      pagina("contenido_rango_series_insertar");
                      mostrarDatos();
                      getConfiguracionMenu("LPMantenimientoRangoSeries","modificar");
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

    public void cargarDatos() throws Exception {
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
        if (casoDeUso.equals("insertar")){//Cargarmos datos para la pantalla de insercion
            getConfiguracionMenu("LPMantenimientoRangoSeries","");
        }
        //Cargamos Datos para la pantalla de busqueda
        if (!accion.equals("modificar")& !casoDeUso.equals("eliminar")& !casoDeUso.equals("insertar")& !casoDeUso.equals("consultar")){
            getConfiguracionMenu("LPMantenimientoRangoSeries","consultar");
        }
        if (casoDeUso.equals("eliminar") ){
            getConfiguracionMenu("LPMantenimientoRangoSeries","eliminar");
            asignarAtributoPagina("cod","0600");
            asignarAtributo("BOTON","Borrar","cod","3");
        } 
        if (casoDeUso.equals("consultar")){
            getConfiguracionMenu("LPMantenimientoRangoSeries","consultar");
            asignarAtributoPagina("cod","0599");
        }
    }

    private void setearValoresPorDefecto() throws Exception {
        asignarAtributo("VAR","marca","valor",this.marcaDef!=null?marcaDef.toString():"");
        asignarAtributo("VAR","canal","valor",this.canalDef!=null?canalDef.toString():"");
    }
  
    public void insertar() throws Exception {
          pagina("salidaGenerica");
          Vector vec = new Vector();
          MareBusinessID id_bus = new MareBusinessID("PREGuardarRangoSerie");
          DTOERangoSerie dto = new DTOERangoSerie();
          dto.setOidPais(this.oidPais);
          dto.setOidIdioma(this.oidIdioma);
          dto.setOidCanal(this.canal);
          dto.setOidEstrategia(this.estrategia);
          dto.setOidMarca(this.marca);
          dto.setSerieDesde(this.sDesde.equals("")?null:Integer.valueOf(sDesde));
          dto.setSerieHasta(this.sHasta.equals("")?null:Integer.valueOf(sHasta));
          vec.add(dto);
          vec.add(id_bus);
          conectar("ConectorGuardarRangoSerie",vec);
          asignarAtributo("VAR","ejecutar","valor","despuesDeGuardar()");
    }

    public void modificar() throws Exception {
          pagina("salidaGenerica");
          Vector vec = new Vector();
          MareBusinessID id_bus = new MareBusinessID("PREModificarRangoSerie");
          DTOERangoSerie dto = new DTOERangoSerie();
          oid = (conectorParametro("oidRangoSerie")==null?"":conectorParametro("oidRangoSerie")).equals("")?null:Long.valueOf(conectorParametro("oidRangoSerie")==null?"":conectorParametro("oidRangoSerie"));
          dto.setSerieDesde(this.sDesde.equals("")?null:Integer.valueOf(sDesde));
          dto.setSerieHasta(this.sHasta.equals("")?null:Integer.valueOf(sHasta));
          dto.setOidRangoSerie(oid);
          vec.add(dto);
          vec.add(id_bus);
          conectar("ConectorGuardarRangoSerie",vec);
    }

    public void mostrarDatos() throws Exception{
        traza("caso de usp"+this.casoDeUso+ "--" + this.accion);
        this.getFormatosValidaciones();
        oid = (conectorParametro("oidRangoSerie")==null?"":conectorParametro("oidRangoSerie")).equals("")?null:Long.valueOf(conectorParametro("oidRangoSerie")==null?"":conectorParametro("oidRangoSerie"));
        
        if (casoDeUso.equals("modificar")){
            getConfiguracionMenu("LPMantenimientoRangoSeries","");
            asignarAtributoPagina("cod","0598");
        }
           
        if (casoDeUso.equals("insertar")){
            getConfiguracionMenu("LPMantenimientoRangoSeries","");
            asignarAtributoPagina("cod","0597");
        }

        if (!casoDeUso.equals("insertar") & !casoDeUso.equals("modificar") ){
            getConfiguracionMenu("LPMantenimientoRangoSeries","consultar");
            asignarAtributoPagina("cod","0599");
        }
        traza(accion+casoDeUso+varPais+varMarca+varCanal+varEstrategia+sDesde+sHasta);
        asignarAtributo("VAR","accion","valor",accion);
        asignarAtributo("VAR","casoDeUso","valor",casoDeUso);                        
        asignarAtributo("VAR","marca","valor",this.varMarca!=null?varMarca:"");
        asignarAtributo("LABELC","lblPaisX","valor",UtilidadesSession.getDescripcionPais(this));
        asignarAtributo("VAR","canal","valor",this.varCanal!=null?varCanal:"");
        asignarAtributo("VAR","estrategia","valor",this.varEstrategia!=null?varEstrategia:"");
        asignarAtributo("VAR","desde","valor",this.sDesde==null?"":this.sDesde.toString());
        asignarAtributo("VAR","hasta","valor",this.sHasta==null?"":this.sHasta.toString());
        asignarAtributo("VAR","oidRangoSerie","valor",this.oid==null?"":this.oid.toString());
    }

// ================= LOG STACK TRACE ====================================================
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


