import es.indra.druida.DruidaConector;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LPDescuentosPorCliente extends LPSICCBase {
  private String mAccion = null;
  private String mCasoDeUso = null;
  private String mPais = null;     
  private Long lPais = null;
  private String mIdioma = null;
  private Long lIdioma = null;
  private String mDescPais = null;   

  private String oidCliente = null;
  private String codigoCliente = null;
  private String oidPais = null;
  private String oidMarca = null;
  private String oidCanal = null;
  private String periodoDesde = null;
  private String periodoHasta = null;  

  private String oidSolicitud = null;

  public LPDescuentosPorCliente() { super(); }

  public void inicio() throws Exception { }
  
  public void ejecucion() throws Exception {    
    setTrazaFichero();    
    traza("******************* Entre a LPDescuentosPorCliente");
    
    mPais = UtilidadesSession.getPais(this).toString();
    lPais = UtilidadesSession.getPais(this);
    mIdioma = UtilidadesSession.getIdioma(this).toString();
    lIdioma = UtilidadesSession.getIdioma(this);
    mDescPais = UtilidadesSession.getDescripcionPais(this).toString();

    mAccion = conectorParametro("accion");

    if(mAccion==null) mAccion = "";      
    
    try {
      this.rastreo();
      traza("************ accion:" + mAccion);

      if(this.mAccion.equals("")) {
         pagina("contenido_descuentos_clientes_consultar");
         asignarAtributo("VAR","hLongCodigoCliente","valor",String.valueOf(this.obtenerLongitudCodigoCliente().longValue()));
         cargarPaginaBuscar();           
      }

      if(this.mAccion.equals("detalleCliente")) {
         pagina("contenido_descuentos_clientes_consultar_solicitudes");
         cargarPaginaSolicitudesCliente();
      }

      if(this.mAccion.equals("detalleSolicitud")) {
         pagina("contenido_descuentos_clientes_consultar_productos");
         cargarPaginaDetalleSolicitud();           
      }
      cargarMenuSecundario();   
    }
    catch ( Exception e )  {    
      ByteArrayOutputStream pila = new ByteArrayOutputStream();
      PrintStream out = new PrintStream(pila);
      e.printStackTrace(out);
      traza("EL STACK ES COMO SIGUE : " +  pila.toString());
      e.printStackTrace(); 
      e.getMessage();
      lanzarPaginaError(e);
    }
  }

  private void cargarPaginaBuscar() throws Exception {
    /*-> Asignar página "contenido_descuentos_clientes_consultar" 
      -> Crear objeto DTOBelcorp con idioma y pais del usuario activo 
      -> Llamar al subsistema GestorCargaPantalla con la siguiente información 
      - idBusiness = "SEGConsultaMarcas" => llena combo "marca" 
      - idBusiness = "SEGConsultaCanales" y DTOBelcorp => llena combo "canal" 
      -> Mostrar pantalla vacía habilitando los campos de criterios de búsqueda y el botón buscar.*/
    traza("******************* Entre a cargarPaginaBuscar");

    DTOBelcorp dtoBel = new DTOBelcorp();
    dtoBel.setOidPais(this.lPais);
    dtoBel.setOidIdioma(this.lIdioma);

    ComposerViewElementList lista = new ComposerViewElementList();
    ComposerViewElement composer1 = new ComposerViewElement();
    ComposerViewElement composer2 = new ComposerViewElement();
    
    composer1.setIDBusiness("SEGConsultaMarcas");
    composer1.setDTOE(dtoBel);

    composer2.setIDBusiness("SEGConsultaCanales");
    composer2.setDTOE(dtoBel);    

    lista.addViewElement(composer1);
    lista.addViewElement(composer2);
    
    ConectorComposerView conector = new ConectorComposerView(lista,this.getRequest());
    conector.ejecucion();

    DruidaConector con = conector.getConector();
    asignar("COMBO", "cbMarca", con, "SEGConsultaMarcas");
    asignar("COMBO", "cbCanal", con, "SEGConsultaCanales");

    traza("********************* mPais " + mPais);
    traza("********************* mIdioma " + mIdioma);
    traza("********************* mDescPais " + mDescPais);
    
    asignarAtributo("VAR", "oidPais", "valor", mPais);
    asignarAtributo("VAR", "oidIdioma", "valor", mIdioma);    
    asignarAtributo("VAR", "desPais", "valor", mDescPais);
  }

  private void cargarPaginaSolicitudesCliente() throws Exception {
    //-> Asignar página "contenido_descuentos_clientes_consultar_solicitudes"
    traza("******************* Entre a cargarPaginaSolicitudesCliente");

    pagina("contenido_descuentos_clientes_consultar_solicitudes");

    oidCliente = conectorParametro("oidCliente");
    codigoCliente = conectorParametro("codigoCliente");
    oidPais = conectorParametro("oidPais");
    oidMarca = conectorParametro("oidMarca");
    oidCanal = conectorParametro("oidCanal");
    periodoDesde = conectorParametro("periodoDesde");
    periodoHasta = conectorParametro("periodoHasta");

    if(oidCliente==null) oidCliente = "";      
    if(codigoCliente==null) codigoCliente = "";
    if(oidPais==null) oidPais = "";
    if(oidMarca==null) oidMarca = "";
    if(oidCanal==null) oidCanal = "";
    if(periodoDesde==null) periodoDesde = "";
    if(periodoHasta==null) periodoHasta = "";

    traza("******************* oidCliente " + oidCliente);
    traza("******************* codigoCliente " + codigoCliente);
    traza("******************* oidPais " + oidPais);
    traza("******************* oidMarca " + oidMarca);
    traza("******************* oidCanal " + oidCanal);
    traza("******************* periodoDesde " + periodoDesde);
    traza("******************* periodoHasta " + periodoHasta);

    asignarAtributo("VAR", "oidCliente", "valor", oidCliente);
    asignarAtributo("VAR", "codigoCliente", "valor", codigoCliente);
    asignarAtributo("VAR", "oidPais", "valor", oidPais);
    asignarAtributo("VAR", "oidMarca", "valor", oidMarca);
    asignarAtributo("VAR", "oidCanal", "valor", oidCanal);
    asignarAtributo("VAR", "periodoDesde", "valor", periodoDesde);
    asignarAtributo("VAR", "periodoHasta", "valor", periodoHasta);    
  }

  private void cargarPaginaDetalleSolicitud() throws Exception {
    traza("******************* Entre a cargarPaginaDetalleSolicitud");

    pagina("contenido_descuentos_clientes_consultar_productos");

    oidSolicitud = conectorParametro("oidSolicitud");
    if(oidSolicitud==null) oidSolicitud = "";   
    traza("******************* oidSolicitud " + oidSolicitud);
    asignarAtributo("VAR", "oidSolicitud", "valor", oidSolicitud);    
  }

  private void cargarMenuSecundario() throws Exception {
    traza("******************* Entre a cargarMenuSecundario");    

    if(this.mAccion.equals("")) {
      getConfiguracionMenu("LPDescuentosPorCliente","consultar");
    }

    if(this.mAccion.equals("detalleCliente")) {
      getConfiguracionMenu("LPDescuentosPorCliente","detalleCliente");
    }

    if(this.mAccion.equals("detalleSolicitud")) {
      getConfiguracionMenu("LPDescuentosPorCliente","detalleSolicitud");
    }    
  }
}
