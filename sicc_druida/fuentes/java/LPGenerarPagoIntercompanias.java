import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.ListaEditableDinamica;
import es.indra.sicc.dtos.mav.DTOGenerarPagoIntercompanias;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;


import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;

import es.indra.sicc.dtos.mav.DTOActividadMAV;
import es.indra.sicc.util.DTOSalida;
      
public class LPGenerarPagoIntercompanias extends LPSICCBase {

  public LPGenerarPagoIntercompanias() {
    super();
  }
    
  public void inicio() throws Exception {
  }

  public void ejecucion() throws Exception {    
    /*
        Si accion = "" entonces 
        -> ejecutar método privado "cargarPagina" 
        Si accion = "generar" 
        -> ejecutar método privado "generar" 
        Fin Si
     */
     try {
        rastreo();
        setTrazaFichero();
        String accion = this.conectorParametroLimpia("accion", "", true);
        traza("accion: " + accion);
        
        if (accion.equals("")) {
           pagina("contenido_pago_intercompanias_generar");
           traza("va a configurar el muenu");
           //this.getConfiguracionMenu();
           traza("se va a cargar la pagina");
           this.cargarPagina();
        } else if (accion.equals("generar")) {
           this.generar();
        } else if (accion.equals("recargarActividades")) {
           this.recargarActividades();
        }
        traza("termino la ejecucion");
     } catch (Exception ex) {
         ex.printStackTrace();
         this.lanzarPaginaError(ex);
     }
  }

  private void cargarPagina() throws Exception {
    traza("ENTRO EN CARGAR PAGINA");
    //pagina("contenido_pago_intercompanias_generar");
    this.getConfiguracionMenu("LPGenerarPagoIntercompanias");
    this.getFormatosValidaciones();
    
    Long pais = UtilidadesSession.getPais(this);
    Long idioma = UtilidadesSession.getIdioma(this);
    String accion = "";
    
    DTOBelcorp dtoe = new DTOBelcorp();
    
    dtoe.setOidPais(pais);
    dtoe.setOidIdioma(idioma);
  
    ComposerViewElementList cLista = new ComposerViewElementList();

    ComposerViewElement elem2 = new ComposerViewElement();
    elem2.setIDBusiness( "SEGConsultaMarcas" );
    elem2.setDTOE( dtoe );
    cLista.addViewElement( elem2 );

    ComposerViewElement elem3 = new ComposerViewElement();
    elem3.setIDBusiness( "SEGConsultaCanales" );
    elem3.setDTOE( dtoe );
    cLista.addViewElement( elem3 );
        
    //Utilizamos e1l subsistema
    ConectorComposerView conector = new ConectorComposerView(cLista, this.getRequest());
    if( conector != null ){
      conector.ejecucion();
      DruidaConector resultados = null;
      resultados = conector.getConector();

      if( resultados != null ){
        asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas");
        asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");
      }
    }

    asignarAtributo("LABELC", "lbldtPais", "valor", UtilidadesSession.getDescripcionPais(this));
    asignarAtributo("VAR", "accion", "valor", accion);

    asignarAtributo("VAR", "hidIdioma", "valor", UtilidadesSession.getIdioma(this).toString() );
    asignarAtributo("VAR", "hidPais", "valor", UtilidadesSession.getPais(this).toString() );
    asignarAtributo("VAR", "hidCanal", "valor", UtilidadesSession.getCanalPorDefecto(this).toString() );
    asignarAtributo("VAR", "hidMarca", "valor", UtilidadesSession.getMarcaPorDefecto(this).toString() );

    

  }

  private void generar() throws Exception {
    /*
    -> Asignar página "contenido_pago_intercompanias_generar" 
    -> Crear objeto DTOGenerarPagoIntercompañias con los datos de pantalla 
    -> Crear idBusiness = "MAVGenerarPagoIntercompañias" 
    -> Asignar conector "ConectorGenerarPagoIntercompañias" con idBusiness y dto creados 
    -> Si todo va bien se muestra el mensaje genérico de operación realizada correctamente al usuario. 
    */
      this.pagina("salidaGenerica");
      DTOGenerarPagoIntercompanias dtoGenPagoInter = new DTOGenerarPagoIntercompanias();    
      MareBusinessID idBusiness = new MareBusinessID("MAVGenerarPagoIntercompanias");
      Vector params = new Vector();

      dtoGenPagoInter.setActividad(new Long(conectorParametro("cbActividad")));
      dtoGenPagoInter.setMarca(new Long(conectorParametro("cbMarca")));
      dtoGenPagoInter.setCanal(new Long(conectorParametro("cbCanal")));
      dtoGenPagoInter.setFechaDesde(new Timestamp(toDate(conectorParametro("txtFechaDesde")).getTime()));
      dtoGenPagoInter.setFechaHasta(new Timestamp(this.toDate(conectorParametro("txtFechaHasta")).getTime()));
      dtoGenPagoInter.setOidPais(UtilidadesSession.getPais(this));
      dtoGenPagoInter.setOidIdioma(UtilidadesSession.getIdioma(this));

      params.add(dtoGenPagoInter);
      params.add(idBusiness);
	  traza(dtoGenPagoInter);
      DruidaConector con = conectar("ConectorGenerarPagoIntercompanias", params);
  }
  
  private Date toDate(String sFecha) throws Exception{
    String formatoFecha = UtilidadesSession.getFormatoFecha(this);
    formatoFecha = formatoFecha.replace('m', 'M');
    SimpleDateFormat sdf = new SimpleDateFormat(formatoFecha);
    java.sql.Date sqlDate = new java.sql.Date(sdf.parse(sFecha).getTime() );
    return sqlDate;
  }
  
  
    /**
     * @author: ssantana, 11/05/2006, inc. 23074
     * @throws java.lang.Exception
     */
  private void recargarActividades() throws Exception {
      this.pagina("salidaGenerica");
      DTOSalida dtoSalida = null;
      Long lPais = UtilidadesSession.getPais(this);
      Long lIdioma = UtilidadesSession.getIdioma(this);
      /* Estos campos sonb obligatorios en la pantalla, siempre tendrán valor */ 
      String sOidMarca = this.conectorParametroLimpia("cbMarca", "", true);
      String sOidCanal = this.conectorParametroLimpia("cbCanal", "", true);
      String sArray = "";
      DruidaConector con = null;
      
      Vector vParams = new Vector();
      DTOActividadMAV dtoActividad = new DTOActividadMAV();
      
      MareBusinessID bussId = new MareBusinessID("MAVObtieneActividadesMAV");
      
      dtoActividad.setOidIdioma(lIdioma);
      dtoActividad.setOidPais(lPais);
      dtoActividad.setOidCanal(Long.valueOf(sOidCanal));
      dtoActividad.setOidMarca(Long.valueOf(sOidMarca));
      
      vParams.add(dtoActividad);
      vParams.add(bussId);
      
      con = this.conectar("ConectorObtenerActividadesMAV", vParams);
      dtoSalida = (DTOSalida) con.objeto("dtoSalida");
      traza("dtoSalida: " + dtoSalida);
      
      if (dtoSalida != null) {
         RecordSet r = dtoSalida.getResultado();
         if (r != null && !r.esVacio() ) {
            sArray = this.generaArrayLista(r);
         }
      }
      
      traza("Cadena de Parametros: " + sArray);
      if (sArray != null && sArray.length() > 0) {
          this.asignarAtributo("VAR", 
                               "ejecutar", 
                               "valor", 
                               "recargaComboActividad(\"" + sArray + "\");");
      } else {
          this.asignarAtributo("VAR", 
                               "ejecutar", 
                               "valor", 
                               "recargaComboActividad(null);");
      }
      
  }

    /**
     * @author: ssantana, 11/05/2006, inc. 23074
     * @throws java.lang.Exception
     * @return String
     * @param RecordSet r
     */
  private String generaArrayLista(RecordSet r) throws Exception {
    int cantRegistros = r.getRowCount();
    int cantCampos = 0;
    Object oTemp = null;
    StringBuffer sArray = new StringBuffer("");
    Vector vFila = null;
    String sSeparador = ",";
    
    for (int i=0; i<cantRegistros; i++) {
        if (i != 0) {
            sArray.append("|");
        }
        vFila = r.getRow(i);
        cantCampos = vFila.size();
        for (int j=0; j<cantCampos; j++) {
           if (j != 0) {
              sArray.append(",");
           }
           oTemp = vFila.get(j);
           if (oTemp != null) {
              sArray.append(oTemp.toString());
           } else {
              sArray.append(" ");
           }
        }
    }
    return sArray.toString();
  }

}
