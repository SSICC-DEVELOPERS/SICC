package es.indra.sicc;

import es.indra.druida.Contexto;
import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.DruidaDataBase;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.druida.parser.ParserBase;
import es.indra.druida.util.DruidaUtils;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareCredentials;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.presentacion.cache.Cache;
import es.indra.sicc.cmn.presentacion.cache.SoftSessionCache;
import es.indra.sicc.cmn.presentacion.i18n.Idioma;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.rep.dtos.DTOReporte;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOPais;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.IVariablesSesion;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.jaxen.dom.DOMXPath;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public abstract class LPSICCBaseNueva extends DruidaBase {

    public static final int FORMATO_DEFAULT = 0;
    public static final int FORMATO_MONEDA = 1;
    public static final int FORMATO_ALTERNATIVA = 2;

    private static DruidaConector conectorObjeto = null;
    private static Collection cIdiomas = null;
    private String LPIdentificarUsuario = "LPIdentificarUsuario";
    private String LPSustitucionUsuario = "LPSustitucionUsuario";
    private DTOPais paisInstancia = null;

    // INCIDENCIA 7215    INCIDENCIA 7215    INCIDENCIA 7215
    private Cache sessionCache;

    public LPSICCBaseNueva() {
        super();
    }

    /**
     * Obtiene la configuracion del Menu Secundario
     * utilizando para ello el servicio MGC de Mare.
     * Una vez obtenida la configuracion, usa el metodo
     * asignarAtributo de Druida para dejarlo en un VAR
     * llamado SICC_TOOLBAR_CONFIG, el cual no debe ser agregado
     * por los constructores.
     *
     * @throws Exception
     *
     */
    public final void getConfiguracionMenu(String nombreLogica,
                                           String accion) throws Exception {
        MareMGC mgc;
        ArrayList vSalida = null;
        String salida;

        if ((nombreLogica == null) || nombreLogica.trim().equals("")) {
            traza("Error: Falta uno de los parametros requeridos: nombreLogica: " +
                  nombreLogica + "//accion: " + accion);
            throw new Exception("Falta uno de los parametros requeridos: nombreLogica: " +
                                nombreLogica + "//accion: " + accion);
        }

        if (accion == null) {
            accion = "";
        } else {
            if (accion.trim().equals("")) {
                accion = "";
            }
        }

        //Modificacion para soportar el espacio en el nombre de la propiedad
        accion = accion.replaceAll(" ", "-");

        mgc = (MareMGC)MareMii.getService(new MareTopic("Configuration"));
        vSalida = (ArrayList)mgc.getProperty(nombreLogica + "/" + accion);

        if (vSalida == null) {
            traza("No se recupero el menu para " + nombreLogica + "/" +
                  accion + "\nrecuperando la configuracion por defecto");
            vSalida = (ArrayList)mgc.getProperty("application/menusecundario");
        }

        if (vSalida == null) {
            salida = "";
        } else {
            salida = vSalida.toString();
        }

        DOMXPath xpath = new DOMXPath("//VAR[@nombre='SICC_TOOLBAR_CONFIG']");
        Node var = (Node)xpath.selectSingleNode(getXML());

        if (var == null) {
            var = (Node)this.getXML().createElement("VAR");
            ((Element)var).setAttribute("nombre", "SICC_TOOLBAR_CONFIG");
        }

        ((Element)var).setAttribute("valor", salida);

        Node elemento = (Node)getFormulario();
        elemento.appendChild(var);
    }

    public final void getConfiguracionMenu(String nombreLogica) throws Exception {
        if ((nombreLogica == null) || nombreLogica.equals("")) {
            throw new Exception("Falta uno de los parametros requeridos: conectorAction: " +
                                nombreLogica);
        }

        getConfiguracionMenu(nombreLogica, "");
    }

    public final void getConfiguracionMenu() throws Exception {
        String accion;
        String nombreLogica;
        accion = conectorParametroLimpia("accion", "", true);
        nombreLogica =
                this.conectorParametroLimpia("conectorAction", "", true);

        if ((nombreLogica == null) || nombreLogica.trim().equals("")) {
            throw new Exception("Falta el parametro requerido: conectorAction: " +
                                nombreLogica);
        }

        getConfiguracionMenu(nombreLogica, accion);
    }

    /**
     * Este metodo se utiliza para generar los VARs necesarios para las funciones de validacion
     */
    public final void getFormatosValidaciones() throws Exception {
        generarHiddenFormatoNumerico();
        generarHiddenFormatoNumericoAlternativo();
        generarHiddenFormatoFecha();
    }

    /**
     * M�todo que almacena en un hidden de la p�gina (lo genera) el formato de fecha
     * con que debe trabajar el usuario. Toma los datos de sesi�n.
     *
     * @author gacevedo
     * @throws Exception
     */
    public final void generarHiddenFormatoFecha() throws Exception {
        Element formulario = getFormulario();

        DOMXPath xpath = new DOMXPath("//VAR[@nombre='hFormatoFechaPais']");
        Element test = (Element)xpath.selectSingleNode(getXML());

        if (test == null) {
            DruidaDOMObjeto var =
                this.crearOCULTO("hFormatoFechaPais", UtilidadesSession.getFormatoFecha(this));
            formulario.appendChild((Node)var.getXML());
        } else {
            test.setAttribute("valor",
                              UtilidadesSession.getFormatoFecha(this));
        }
    }

    /**
     * Este metodo crea los hiddens con la informacion del formato numerico de
     * usuario, segun el pais por defecto
     *
     * @author  Gacevedo
     * @throws Exception
     */
    public final void generarHiddenFormatoNumerico() throws Exception {
        Element formulario = getFormulario();

        DOMXPath xpath =
            new DOMXPath("//VAR[@nombre='hCantidadDecimalesPais']");
        Element test = (Element)xpath.selectSingleNode(getXML());

        if (test == null) {
            DruidaDOMObjeto var =
                this.crearOCULTO("hCantidadDecimalesPais", UtilidadesSession.getFormatoNumerico(this));
            formulario.appendChild((Node)var.getXML());
        } else {
            test.setAttribute("valor",
                              UtilidadesSession.getFormatoNumerico(this));
        }

        test = null;

        xpath = new DOMXPath("//VAR[@nombre='hSeparadorDecimalPais']");
        test = (Element)xpath.selectSingleNode(getXML());

        String separadorDecimal =
            UtilidadesSession.getSeparadorDecimales(this);

        if (test == null) {
            DruidaDOMObjeto var =
                this.crearOCULTO("hSeparadorDecimalPais", separadorDecimal);
            formulario.appendChild((Node)var.getXML());
        } else {
            test.setAttribute("valor", separadorDecimal);
        }

        test = null;

        String separadorMiles = ((separadorDecimal.equals("."))) ? "," : ".";
        xpath = new DOMXPath("//VAR[@nombre='hSeparadorMilesPais']");
        test = (Element)xpath.selectSingleNode(getXML());

        if (test == null) {
            DruidaDOMObjeto var =
                this.crearOCULTO("hSeparadorMilesPais", separadorMiles);
            formulario.appendChild((Node)var.getXML());
        } else {
            test.setAttribute("valor", separadorMiles);
        }
    }

    /**
     * Si bien existe un formato de moneda alternativo, no esta claro si el mismo
     * define un nuevo formato de manera completa o solo la cantidad de decimales,
     * por lo que se ha decidido generar un metodo nuevo que obtiene el formato
     * alternativo como si enr ealidad definise tanto la catidad de decimales, como
     * el separador de miles y separador de decimales.
     *
     * @author Gacevedo
     * @throws Exception
     */
    public final void generarHiddenFormatoNumericoAlternativo() throws Exception {
        Element formulario = getFormulario();

        DOMXPath xpath =
            new DOMXPath("//VAR[@nombre='hCantidadDecimalesAlternativos']");
        Element test = (Element)xpath.selectSingleNode(getXML());

        if (test == null) {
            DruidaDOMObjeto var =
                this.crearOCULTO("hCantidadDecimalesAlternativos",
                                 UtilidadesSession.getFormatoNumericoAlternativo(this));
            formulario.appendChild((Node)var.getXML());
        } else {
            test.setAttribute("valor",
                              UtilidadesSession.getFormatoNumericoAlternativo(this));
        }

        test = null;

        xpath = new DOMXPath("//VAR[@nombre='hSeparadorDecimalAlternativo']");
        test = (Element)xpath.selectSingleNode(getXML());

        String separadorDecimal =
            UtilidadesSession.getSeparadorDecimales(this);

        if (test == null) {
            DruidaDOMObjeto var =
                this.crearOCULTO("hSeparadorDecimalAlternativo",
                                 separadorDecimal);
            formulario.appendChild((Node)var.getXML());
        } else {
            test.setAttribute("valor", separadorDecimal);
        }

        test = null;

        String separadorMiles = ((separadorDecimal.equals("."))) ? "," : ".";
        xpath = new DOMXPath("//VAR[@nombre='hSeparadorMilesAlternativo']");
        test = (Element)xpath.selectSingleNode(getXML());

        if (test == null) {
            DruidaDOMObjeto var =
                this.crearOCULTO("hSeparadorMilesAlternativo", separadorMiles);
            formulario.appendChild((Node)var.getXML());
        } else {
            test.setAttribute("valor", separadorMiles);
        }
    }

    public final void asignarAtributoPagina(String atributo,
                                            String valor) throws Exception {
        try {
            if (atributo == null) {
                throw new Exception("El parametro 'atributo' no puede ser nulo.");
            } else {
                if (valor == null) {
                    throw new Exception("El parametro 'valor' no puede ser nulo.");
                }
            }

            if (!atributo.trim().equals("")) {
                Document doc = getXML();
                NodeList lista = doc.getElementsByTagName("PAGINA");

                if (lista.getLength() > 0) {
                    Element pagina = (Element)lista.item(0);
                    pagina.setAttribute(atributo, valor);
                } else {
                    throw new Exception("No se ha encontrado el Tag PAGINA");
                }
            } else {
                throw new Exception("el nombre del atributo no es valido");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            throw e;
        }
    }

    public final void lanzarPaginaError(Exception e) throws Exception {
        DTOError dtoError = UtilidadesBelcorp.recuperarDatosException(e, this);

        generarHiddensError();

        traza("Codigo Error: " + dtoError.getCodigoError());
        asignarAtributo("VAR", "errCodigo", "valor",
                        "" + dtoError.getCodigoError());

        traza("Mensaje: " + dtoError.getDescripcionError());
        asignarAtributo("VAR", "errDescripcion", "valor",
                        "" + dtoError.getDescripcionError());

        traza("Severidad: " + dtoError.getSeveridad());
        asignarAtributo("VAR", "errSeverity", "valor",
                        "" + dtoError.getSeveridad());


        try {
            if (Integer.valueOf(dtoError.getCodigoError()).intValue() == 0) {
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);
                traza("---------------------------------Error 'cero' en lanzarPaginaError. Logueando------------------------------");
                traza(sw.toString());
                traza("-----------------------------------------------Fin de Logueo----------------------------------------------------");
            }
        } catch (Exception e1) {
            ;
        }
    }

    private Element getFormulario() throws Exception {
        DOMXPath xform =
            new DOMXPath("//PAGINA/FORMULARIO[VAR[@nombre='conectorAction']]");
        final Element formulario = (Element)xform.selectSingleNode(getXML());

        if (formulario == null) {
            traza("No se encontro el formulario con el var 'conectorAction'.");
            throw new Exception("No se encontro el formulario con el var 'conectorAction'.");
        }

        return formulario;
    }

    /**
     * Este metodo agrega, de ser necesario,
     * los hiddens para el manejo de los errores
     *
     * @author Gacevedo
     * @throws Exception
     */
    private void generarHiddensError() throws Exception {
        Element formulario = getFormulario();

        DOMXPath xpath = new DOMXPath("//VAR[@nombre='errCodigo']");
        Element test = (Element)xpath.selectSingleNode(getXML());

        if (test == null) {
            DruidaDOMObjeto errCodigo = this.crearOCULTO("errCodigo", "");
            formulario.appendChild((Node)errCodigo.getXML());
        }

        test = null;
        xpath = new DOMXPath("//VAR[@nombre='errDescripcion']");
        test = (Element)xpath.selectSingleNode(getXML());

        if (test == null) {
            DruidaDOMObjeto errDescripcion =
                this.crearOCULTO("errDescripcion", "");
            formulario.appendChild((Node)errDescripcion.getXML());
        }

        test = null;

        xpath = new DOMXPath("//VAR[@nombre='errSeverity']");
        test = (Element)xpath.selectSingleNode(getXML());

        if (test == null) {
            DruidaDOMObjeto errSeverity = this.crearOCULTO("errSeverity", "");
            formulario.appendChild((Node)errSeverity.getXML());
        }

        test = null;
    }

    public final void recuperaPaisInstancia() throws Exception {
        Vector params = new Vector();
        DTOOID dto = new DTOOID();

        //Modificado por Cristian Valenzuela - 20/4/2006
        dto.setOid(UtilidadesSession.getPais(this));
        dto.setOidIdioma(UtilidadesSession.getIdioma(this));

        traza("********* pais " + UtilidadesSession.getPais(this));
        traza("********* idioma " + UtilidadesSession.getIdioma(this));
        traza("********* DTOOID " + dto);
        //dto.setOidIdioma(new Long(1));
        //FIN - Modificado por Cristian Valenzuela - 20/4/2006

        params.add(dto);
        params.add(new MareBusinessID("SEGRecuperaPais"));

        DruidaConector conector = conectar("ConectorRecuperarPais", params);
        DTOSalida dtos = (DTOSalida)conector.objeto("dtoSalidaObjeto");
        RecordSet salida = dtos.getResultado();

        paisInstancia = new DTOPais();
        paisInstancia.setPais(new Long(salida.getValueAt(0,
                                                         "OID_PAIS").toString()));

        Object aux = salida.getValueAt(0, "NUM_POSI_NUME_CLIE");

        if (!(aux == null)) {
            paisInstancia.setLongitudCodigoClientePais(new Byte(aux.toString()));
        }

        HashMap aux2 = new HashMap();
        aux2.put(paisInstancia.getPais(), salida.getValueAt(0, "VAL_I18N"));
        paisInstancia.setDescripcionesPais(aux2);
    }

    public final String getDescripcionPais() throws Exception {
        if (paisInstancia == null) {
            this.recuperaPaisInstancia();
        }

        return (String)paisInstancia.getDescripcionesPais().get(this.getOidPais());
    }

    public final Byte obtenerLongitudCodigoCliente() throws Exception {
        if (paisInstancia == null) {
            this.recuperaPaisInstancia();
        }

        return paisInstancia.getLongitudCodigoClientePais();
    }

    public final Long getOidPais() throws Exception {
        if (paisInstancia == null) {
            this.recuperaPaisInstancia();
        }

        return paisInstancia.getPais();
    }

    /*
   * Devuelve el codigo ISO del oid del pais recibido por par�metro y lo busca
   * dentro de la collection de getIdiomas().
   * */

    public final String getISO(Long oid) throws Exception {
        setTrazaFichero();

        String desc_iso = null;

        if (cIdiomas != null) {
            Iterator it = cIdiomas.iterator();
            boolean bSeguir = true;

            while (it.hasNext() && bSeguir) {
                Idioma idioma = (Idioma)it.next();

                if ((idioma.getOid().toString()).equals(oid.toString())) {
                    desc_iso = idioma.getCodigoISO();
                    bSeguir =
                            false; //cambio flag						
                }
            }
        } else { //no estan seteados los idiomas
            traza("no estan seteados los idiomas");
            throw new Exception();
        }

        if (desc_iso == null) { //no se encontr� el oid de idioma en la lista.
            traza("no se encontr�");
            throw new Exception();
        } else {
            return desc_iso;
        }
    }

    /*
   * Devuelve el codigo ISO del oid del pais recibido por par�metro y lo busca
   * dentro de la collection de getIdiomas().
   * */

    public final String get_ISO(Long oid) throws Exception {
        setTrazaFichero();

        String desc_iso = null;

        if (cIdiomas != null) {
            Iterator it = cIdiomas.iterator();
            boolean bSeguir = true;

            while (it.hasNext() && bSeguir) {
                Idioma idioma = (Idioma)it.next();

                if ((idioma.getOid().toString()).equals(oid.toString())) {
                    desc_iso = idioma.getCodigo();
                    bSeguir =
                            false; //cambio flag						
                }
            }
        } else { //no estan seteados los idiomas
            traza("no estan seteados los idiomas");
            throw new Exception();
        }

        if (desc_iso == null) { //no se encontr� el oid de idioma en la lista.
            traza("no se encontr�");
            throw new Exception();
        } else {
            return desc_iso;
        }
    }

    /**
     * Devuelve un Collection con objetos Idioma Pej:
     * [[1, Espa�ol, es, ES, 1], [2, Franc�s, fr, FR, 0], [3, Portugu�s, pt, PT, 0]]
     * Para los idiomas definidos en el sistema.
     * Estos idiomas los cachea en un atributos "static" de la clase,
     * y los obtiene invocando el m�todo recuperaIdiomas() del MON MONMantenimientoSEG mediante un motor plano.
     * En el m�todo recuperaIdiomas mete un DTOBelcorp con el idioma seteado al por defecto (OID=1).
     */
    public final ArrayList getIdiomas() throws Exception {
        DTOBelcorp dtoEntrada;
        DTOSalida dtoSalida;
        RecordSet rsIdiomas;
        ArrayList idiomas;

        //write("cIdiomas " + cIdiomas);
        if (cIdiomas == null) {
            Vector paramEntrada = new Vector();
            dtoEntrada = new DTOBelcorp();
            dtoEntrada.setOidIdioma(new Long(1)); //segun dise�o
            paramEntrada.add(dtoEntrada);
            paramEntrada.add(new MareBusinessID("CMNRecuperarIdiomasSEG"));

            //write("antes de conectar");
            conectorObjeto = conectar("ConectorObjeto", paramEntrada);

            //write("des�pes de conectar");
            dtoSalida = (DTOSalida)conectorObjeto.objeto("DTOSalida");

            //write("des�pes de conectro objectpo");
            //pasamos los idiomas del recordSet a un ArrayList
            rsIdiomas = (RecordSet)dtoSalida.getResultado();
            idiomas = new ArrayList();

            for (int pos = 0; pos < rsIdiomas.getRowCount(); pos++) {
                //creamos un idioma por cada regsitro del resultSet
                Idioma idioma = new Idioma();
                idioma.setOid(new Long(((BigDecimal)rsIdiomas.getValueAt(pos,
                                                                         0)).longValue())); // de GEN_I18N_SICC el campo val_oid
                idioma.setDescripcion((String)rsIdiomas.getValueAt(pos,
                                                                   1)); // de GEN_I18N_SICC el campo val_i18n
                idioma.setCodigoISO((String)rsIdiomas.getValueAt(pos,
                                                                 2)); //codigo ISO
                idioma.setCodigo((String)rsIdiomas.getValueAt(pos,
                                                              3)); //codigo
                idioma.setIndicadorTraducible(((((BigDecimal)rsIdiomas.getValueAt(pos,
                                                                                  4)).longValue()) ==
                                               1) ? new Boolean(true) :
                                              new Boolean(false)); //indTrad
                idiomas.add(idioma);
            }

            //write("idiomas " + idiomas);
            this.cIdiomas = idiomas;
        }

        //write("cIdiomas de conectar" + cIdiomas);
        return new ArrayList(cIdiomas);
    }

    public final void anyadeHiddensI18N(boolean cargado, String entidad,
                                        Long oid,
                                        Integer nroAtributoTraducible,
                                        String nombreFormulario,
                                        String nombreAtributo,
                                        boolean soloLectura) throws Exception {
        MareMGC mgc;

        setTrazaFichero();

        traza("ARRANCA:" + cargado);

        if (cargado == true) {
            //limpio las variables en sesion por reinicio del caso de uso.
            conectorParametroSesion("hEntidad_" + nroAtributoTraducible, "");
            conectorParametroSesion("hOid_" + nroAtributoTraducible, "");
            conectorParametroSesion("hCargado_" + nroAtributoTraducible, "");

            //conectorParametroSesion("hfrmNombre_"+nroAtributoTraducible, "");
            //conectorParametroSesion("htxtNombre_"+nroAtributoTraducible, "");
            conectorParametroSesion("cargo_" + nroAtributoTraducible, "");
        }

        //datos principales
        DruidaDOMObjeto vari18NEntidad =
            this.crearOCULTO("hi18NEntidad_" + nroAtributoTraducible, "");
        vari18NEntidad.setAtributo("valor", entidad);

        DruidaDOMObjeto vari18NOID =
            this.crearOCULTO("hi18NOID_" + nroAtributoTraducible, "");

        if (oid != null) {
            vari18NOID.setAtributo("valor", oid.toString());
        } else {
            vari18NOID.setAtributo("valor", "");
        }

        DruidaDOMObjeto vari18NCargado =
            this.crearOCULTO("hi18NCargado_" + nroAtributoTraducible, "");
        vari18NCargado.setAtributo("valor", (new Boolean(cargado)).toString());

        DruidaDOMObjeto vari18NiActual =
            this.crearOCULTO("hi18NidiomaActual", "");
        vari18NiActual.setAtributo("valor",
                                   UtilidadesSession.getIdioma(this).toString());

        DruidaDOMObjeto vari18NfrmNom =
            this.crearOCULTO("hfrmNombre_" + nroAtributoTraducible, "");
        vari18NfrmNom.setAtributo("valor", nombreFormulario);

        DruidaDOMObjeto vari18NnomAtr =
            this.crearOCULTO("htxtNombre_" + nroAtributoTraducible, "");
        vari18NnomAtr.setAtributo("valor", nombreAtributo);

        DruidaDOMObjeto vari18Nbandera =
            this.crearOCULTO("hBandera_" + nroAtributoTraducible, "");
        vari18Nbandera.setAtributo("valor", "true");

        DruidaDOMObjeto vari18NSoloLectura =
            this.crearOCULTO("hSoloLectura_" + nroAtributoTraducible, "");
        vari18NSoloLectura.setAtributo("valor",
                                       (new Boolean(soloLectura)).toString());

        Element elemento = getFormulario();

        Collection idiomas = this.getIdiomas();
        Iterator itIdiomas = idiomas.iterator();
        int cantIdiomas = idiomas.size();
        traza("Nro de Idiomas: " + cantIdiomas);

        if (elemento != null) {
            elemento.appendChild((Node)vari18NiActual.getXML());
            elemento.appendChild((Node)vari18NEntidad.getXML());
            elemento.appendChild((Node)vari18NOID.getXML());
            elemento.appendChild((Node)vari18NCargado.getXML());
            elemento.appendChild((Node)vari18NfrmNom.getXML());
            elemento.appendChild((Node)vari18NnomAtr.getXML());
            elemento.appendChild((Node)vari18Nbandera.getXML());
            elemento.appendChild((Node)vari18NSoloLectura.getXML());

            DruidaDOMObjeto vari18NTraduccion;
            String strOids = new String();

            for (int i = 0; i < cantIdiomas; i++) {
                Idioma idioma = (Idioma)itIdiomas.next();
                vari18NTraduccion =
                        this.crearOCULTO("hi18NTraduccion_" + nroAtributoTraducible +
                                         "_" + idioma.getOid(), "");
                vari18NTraduccion.setAtributo("valor", "");
                elemento.appendChild((Node)vari18NTraduccion.getXML());
                strOids = strOids + idioma.getOid() + "|";
                traza(vari18NTraduccion.getXML());
            }

            DruidaDOMObjeto vari18NOidsIdioma =
                this.crearOCULTO("hOidsIdiomas", "");
            vari18NOidsIdioma.setAtributo("valor", strOids);
            elemento.appendChild((Node)vari18NOidsIdioma.getXML());
            conectorParametroSesion("hEntidad_" + nroAtributoTraducible,
                                    entidad);

            if (oid != null) {
                conectorParametroSesion("hOid_" + nroAtributoTraducible, oid);
            } else {
                conectorParametroSesion("hOid_" + nroAtributoTraducible, "");
            }

            conectorParametroSesion("hCargado_" + nroAtributoTraducible,
                                    (new Boolean(cargado)).toString());
            conectorParametroSesion("hSoloLectura_" + nroAtributoTraducible,
                                    (new Boolean(soloLectura)).toString());
            conectorParametroSesion("hfrmNombre_" + nroAtributoTraducible,
                                    nombreFormulario);
            conectorParametroSesion("htxtNombre_" + nroAtributoTraducible,
                                    nombreAtributo);

            if (conectorParametroSesion("cargo_" + nroAtributoTraducible) ==
                null) {
                conectorParametroSesion("cargo_" + nroAtributoTraducible,
                                        "false");
            }

            //Recarga de valores de sesion
            String hCargado =
                conectorParametro("hi18NCargado_" + nroAtributoTraducible);
            traza("hCargado: " + hCargado);

            if ((hCargado != null) && (hCargado.equals("true"))) {
                //si ya cargo antes y se llamo alguna accion
                traza("hi18NEntidad_" + nroAtributoTraducible + ": " +
                      conectorParametro("hi18NEntidad_" +
                                        nroAtributoTraducible));
                asignarAtributo("VAR", "hi18NEntidad_" + nroAtributoTraducible,
                                "valor",
                                "" + conectorParametro("hi18NEntidad_" +
                                                       nroAtributoTraducible));
                asignarAtributo("VAR", "hi18NOID_" + nroAtributoTraducible,
                                "valor",
                                "" + conectorParametro("hi18NOID_" + nroAtributoTraducible)); //BUG
                asignarAtributo("VAR", "hi18NCargado_" + nroAtributoTraducible,
                                "valor",
                                "" + conectorParametro("hi18NCargado_" +
                                                       nroAtributoTraducible));
                asignarAtributo("VAR", "hSoloLectura_" + nroAtributoTraducible,
                                "valor",
                                "" + conectorParametro("hSoloLectura_" +
                                                       nroAtributoTraducible));
                asignarAtributo("VAR", "hOidsIdiomas", "valor",
                                "" + conectorParametro("hOidsIdiomas"));

                Iterator it2Idiomas = idiomas.iterator();

                for (int i = 0; i < cantIdiomas; i++) {
                    Idioma idioma = (Idioma)it2Idiomas.next();
                    asignarAtributo("VAR",
                                    "hi18NTraduccion_" + nroAtributoTraducible +
                                    "_" + idioma.getOid(), "valor",
                                    "" + conectorParametro("hi18NTraduccion_" +
                                                           nroAtributoTraducible +
                                                           "_" +
                                                           idioma.getOid()));
                }
            }
        } else {
            throw new Exception("No se encontro el formulario donde colocar los atributos de i18n.");
        }
    }

    public final void preservaHiddensI18n(Integer numAtrTrad, String nomTabla,
                                          String nombreFormulario,
                                          String nombreAtributo,
                                          boolean soloLectura) throws Exception {
        Collection idiomas = this.getIdiomas();
        Iterator itIdiomas = idiomas.iterator();
        int cantIdiomas = idiomas.size();

        anyadeHiddensI18N(false, nomTabla, null, numAtrTrad, nombreFormulario,
                          nombreAtributo, soloLectura);
        asignarAtributo("VAR", "hBandera_" + numAtrTrad, "valor", "false");

        for (int i = 0; i < cantIdiomas; i++) {
            Idioma idioma = (Idioma)itIdiomas.next();
            asignarAtributo("VAR",
                            "hi18NTraduccion_" + numAtrTrad + "_" + idioma.getOid(),
                            "valor",
                            conectorParametro("hi18NTraduccion_" + numAtrTrad +
                                              "_" + idioma.getOid()));
        }
    }

    public final Vector recuperaTraduccionesI18N(Integer nroAtributoTraducible) throws Exception {
        Vector resultado = new Vector();
        String traduccion;

        Integer idiomaActual =
            new Integer(UtilidadesSession.getIdioma(this).toString());

        //String nomForm = (String)conectorParametroSesion("hfrmNombre_"+nroAtributoTraducible);
        String nomAtrib =
            (String)conectorParametroSesion("htxtNombre_" + nroAtributoTraducible);
        traza("nombre de atributo:" + nomAtrib + " bandera:" +
              conectorParametroSesion("cargo_" + nroAtributoTraducible));

        if (conectorParametroSesion("cargo_" + nroAtributoTraducible) ==
            "true") {
            Collection idiomas = this.getIdiomas();
            Iterator itIdiomas = idiomas.iterator();
            int cantIdiomas = idiomas.size();

            for (int i = 0; i < cantIdiomas; i++) {
                Idioma idioma = (Idioma)itIdiomas.next();
                DTOI18nSICC dto = new DTOI18nSICC();

                if (idioma.getOid().equals(new Long(idiomaActual.toString()))) {
                    traduccion = conectorParametro(nomAtrib);
                } else {
                    traduccion =
                            conectorParametro("hi18NTraduccion_" + nroAtributoTraducible +
                                              "_" + idioma.getOid());

                    if ((traduccion == null) || (traduccion.equals(""))) {
                        traza("es null-->" + idioma.getOid());
                        traduccion = " ";
                    }
                }

                dto.setOidIdioma(idioma.getOid());
                dto.setOidAtriuto(new Long(nroAtributoTraducible.longValue()));
                dto.setValorI18n(traduccion);
                resultado.add(dto);
            }
        } else { //if (conectorParametroSesion("cargo_"+nroAtributoTraducible)=="false")
            DTOI18nSICC dto = new DTOI18nSICC();
            traduccion = conectorParametro(nomAtrib);
            traza("paso por false---->" + traduccion);
            dto.setOidIdioma(new Long(idiomaActual.toString()));
            dto.setOidAtriuto(new Long(nroAtributoTraducible.longValue()));
            dto.setValorI18n(traduccion);
            resultado.add(dto);
        }

        return resultado;
    }

    public final RecordSet recuperaHiddensI18N(Integer nroAtributoTraducible) throws Exception {
        RecordSet resultado;
        Hashtable ht = new Hashtable();
        Vector vNomCol = new Vector();
        Vector vFila = new Vector();
        Integer numFilas;
        String traduccion;

        Integer idiomaActual =
            new Integer(UtilidadesSession.getIdioma(this).toString());

        //String nomForm = (String)conectorParametroSesion("hfrmNombre_"+nroAtributoTraducible);
        String nomAtrib =
            (String)conectorParametroSesion("htxtNombre_" + nroAtributoTraducible);

        Collection idiomas = this.getIdiomas();
        Iterator itIdiomas = idiomas.iterator();
        int cantIdiomas = idiomas.size();

        vNomCol.add("IDIO_OID_IDIO");
        vNomCol.add("VAL_I18N");
        ht.put("vectorIdentificadores", vNomCol);
        ht.put("numRow", new Integer(cantIdiomas));

        for (int i = 0; i < cantIdiomas; i++) {
            vFila = new Vector();

            Idioma idioma = (Idioma)itIdiomas.next();

            if (idioma.getOid().equals(idiomaActual)) {
                traduccion = conectorParametro(nomAtrib);
            } else {
                traduccion =
                        conectorParametro("hi18NTraduccion_" + nroAtributoTraducible +
                                          "_" + idioma.getOid());
            }

            vFila.add(idioma.getOid());
            vFila.add(traduccion);
            ht.put("Row" + i, vFila);
        }

        resultado = new RecordSet(ht);

        return resultado;
    }

    /* Realiza el rastreo de la accion.
   **/

    public final void rastreo() throws MareException, Exception {
        setTrazaFichero();
        traza("Entrando a funcion de rastreo");

        MareCredentials credenciales =
            (MareCredentials)conectorParametroSesion(IVariablesSesion.MARE_CREDENTIALS);
        String nombre = credenciales.getUser().getName();
        String password = credenciales.getPassword().toString();
        String idFuncion = UtilidadesSession.getFuncion(this);
        IRastreador tracer = Rastreador.getInstance();

        if ((nombre == null) || (idFuncion == null)) {
            throw new Exception("Nombre y/o idfuncion son null");
        }

        java.sql.Date fechaHora =
            new java.sql.Date(Calendar.getInstance().getTime().getTime());

        try {
            tracer.RastrearFuncion(fechaHora, idFuncion, nombre, password);
        } catch (MareException ex) {
            ex.printStackTrace();
            throw new Exception();
        }
    }

    public void asignarAtributoElementoValidacion(String grupo,
                                                  String nombreElemento,
                                                  String nombreAtributo,
                                                  String nuevoValor) {
        Element elemento = null;
        DOMXPath xpath = null;

        try {
            xpath =
new DOMXPath("//ELEMENTO[@name='" + nombreElemento + "' and @group='" + grupo +
             "']");
            elemento = (Element)xpath.selectSingleNode(getXML());

            if (elemento != null) {
                elemento.setAttribute(nombreAtributo, nuevoValor);
            }
        } catch (Exception e) {
            try {
                traza(e.toString());
            } catch (Exception e1) {
                ;
            }
        }
    }

    public void asignarAtributoElementoValidacion(String nombreElemento,
                                                  String nombreAtributo,
                                                  String nuevoValor) {
        Element elemento = null;
        DOMXPath xpath = null;

        try {
            xpath = new DOMXPath("//ELEMENTO[@name='" + nombreElemento + "']");
            elemento = (Element)xpath.selectSingleNode(getXML());

            if (elemento != null) {
                elemento.setAttribute(nombreAtributo, nuevoValor);
            }
        } catch (Exception e) {
            try {
                traza(e.toString());
            } catch (Exception e1) {
                ;
            }
        }
    }

    public void asignarAtributoElemento(String nombreElemento,
                                        String nombreAtributo,
                                        String nuevoValor) {
        Element elemento = null;
        DOMXPath xpath = null;

        try {
            xpath = new DOMXPath("//*[@nombre='" + nombreElemento + "']");
            elemento = (Element)xpath.selectSingleNode(getXML());

            if (elemento != null) {
                elemento.setAttribute(nombreAtributo, nuevoValor);
            } else {
                xpath = new DOMXPath("//*[@name='" + nombreElemento + "']");

                if (elemento != null) {
                    elemento.setAttribute(nombreAtributo, nuevoValor);
                }
            }
        } catch (Exception e) {
            try {
                traza(e.toString());
            } catch (Exception e1) {
                ;
            }
        }
    }

    /*
   * Temporal, borrorar. Es para ver un log porque la traza no funciona
   * */

    private static String getFileName() {
        String mareRoot = System.getProperty("MareConfigurationRoot");

        if (!mareRoot.endsWith(File.separator)) {
            mareRoot += File.separator;
        }

        mareRoot += "fichero_rastreo.log";
        System.out.println("Archivo Rastreo: " + mareRoot);

        return mareRoot;
    }

    /*
   * Temporal, borrorar. Es para ver un log porque la traza no funciona
   * */

    private static void write(String str) {
        try {
            RandomAccessFile logFile =
                new RandomAccessFile(getFileName(), "rw");
            logFile.seek(logFile.length());

            logFile.writeBytes(str + "\n");

            logFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

            String codigoError = CodigosError.ERROR_ARCHIVO_RASTREO;

            //throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (IOException e) {
            e.printStackTrace();

            String codigoError = CodigosError.ERROR_ARCHIVO_RASTREO;

            //throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    }

    public void seleccionarValorCambo(String nombreCombo,
                                      String valorSeleccionable) throws Exception {
        Element elemento = null;
        Element fila = null;
        NodeList listaCombos = null;
        NodeList listaRows = null;

        listaCombos =
                getXML().getDocumentElement().getElementsByTagName("COMBO");

        int largoCombos = listaCombos.getLength();

        for (int i = 0; i < largoCombos; i++) {
            if (((Element)listaCombos.item(i)).getAttribute("nombre").equals(nombreCombo)) {
                listaRows =
                        ((Element)listaCombos.item(i)).getElementsByTagName("ROW");

                int largoRows = listaRows.getLength();

                for (int j = 0; j < largoRows; j++) {
                    if ((((Element)listaRows.item(j).getFirstChild()).getAttribute("valor") !=
                         null) &&
                        ((Element)listaRows.item(j).getFirstChild()).getAttribute("valor").equals(valorSeleccionable)) {
                        ((Element)listaRows.item(j)).setAttribute("check",
                                                                  "S");

                        break;
                    } else {
                        if ((((Element)listaRows.item(j).getFirstChild()).getFirstChild().getNodeValue() !=
                             null) &&
                            ((Element)listaRows.item(j).getFirstChild()).getFirstChild().getNodeValue().equals(valorSeleccionable)) {
                            ((Element)listaRows.item(j)).setAttribute("check",
                                                                      "S");

                            break;
                        }
                    }
                }

                break;
            }
        }
    }

    protected void traza(Object p0) throws Exception {
        if (p0 instanceof Throwable) {
            logStackTrace((Throwable)p0);
        } else {
            UtilidadesLog.debug(p0);
        }
    }

    private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());

        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);

        if (e instanceof MareException) {
            MareException e2 = (MareException)e;
            traza("Es una mare Exception con codigo de error: " +
                  e2.getCode());
        }

        e.printStackTrace(out);
        traza("stack Trace : " + pila.toString());
    }

    public String conectorParametroNumero(String paramName,
                                          int formato) throws Exception {
        //obtenemos el valor de parametro a formatear
        String valorParametro = conectorParametro(paramName);

        return desFormatearNumero(valorParametro, formato);

    }


    // INCIDENCIA 7215    INCIDENCIA 7215    INCIDENCIA 7215

    public void iniciobase(HttpServletRequest httpservletrequest, boolean flag,
                           String s, String s1, String s2,
                           ParserBase parserbase) throws Exception {
        super.iniciobase(httpservletrequest, flag, s, s1, s2, parserbase);
        sessionCache = new SoftSessionCache(this);
    }

    protected Cache getSessionCache() {
        return sessionCache;
    }
    // INCIDENCIA 7215    INCIDENCIA 7215    INCIDENCIA 7215

    protected DruidaConector conectar(String id,
                                      Vector params) throws Exception {
        long tiempoInicio;
        DruidaConector con = null;

        traza("Parametros ipCliente: " + UtilidadesBelcorp.getIPCliente(this) +
              " - Programa: " + UtilidadesSession.getFuncion(this) +
              " : seteados.");

        if (params.get(0) instanceof DTOAuditableSICC) {
            DTOAuditableSICC dto = (DTOAuditableSICC)params.get(0);
            dto.setPrograma(UtilidadesSession.getFuncion(this));
            dto.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
            tiempoInicio = System.currentTimeMillis();
            con = super.conectar(id, params);
            UtilidadesLog.warn("\nEl tiempo de ejecucion de la transacion " +
                               ((MareBusinessID)params.get(1)).getBusinessID() +
                               " fue de " +
                               (System.currentTimeMillis() - tiempoInicio) +
                               ".\n");
            return con;
        } else {
            tiempoInicio = System.currentTimeMillis();
            con = super.conectar(id, params);
            UtilidadesLog.warn("\nEl tiempo de ejecucion de la transacion " +
                               ((MareBusinessID)params.get(1)).getBusinessID() +
                               " fue de " +
                               (System.currentTimeMillis() - tiempoInicio) +
                               ".\n");
            return con;
        }

        /*		try{		
			DTOAuditableSICC dto = (DTOAuditableSICC) params.get(0);
			dto.setPrograma(UtilidadesSession.getFuncion(this));
			dto.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
			traza("Parametros ipCliente: " + dto.getIpCliente() + " - Programa: " + dto.getPrograma() + " : seteados." );
			//return super.conectar(id, params);
      tiempoInicio = System.currentTimeMillis();
      con = super.conectar(id, params);
      tiempoFin = System.currentTimeMillis();
      traza("\nEl tiempo de ejecucion de la transacion "+((MareBusinessID)params.get(1)).getBusinessID()+" fue de "+(tiempoFin-tiempoInicio) + ".\n");
      return con;
			
		}catch(ClassCastException e){		
			//traza("conectar: ClassCastException / " + e);
			//return super.conectar(id, params);
      tiempoInicio = System.currentTimeMillis();
      con = super.conectar(id, params);
      tiempoFin = System.currentTimeMillis();
      traza("El tiempo de ejecucion de la transacion "+((MareBusinessID)params.get(1)).getBusinessID()+" fue de "+(tiempoFin-tiempoInicio));
      return con;		
    }*/
    }

    public String desFormatearNumero(String paramName,
                                     int formato) throws Exception {
        //obtenemos el valor de parametro a formatear
        String valorParametro = paramName;

        if (valorParametro == null || valorParametro.equals("")) {
            return "";
        }

        String cantidadDecimales = "";
        String separadorDecimal =
            UtilidadesSession.getSeparadorDecimales(this);
        String separadorMiles = ((separadorDecimal.equals("."))) ? "," : ".";

        //Obtenemos de session las propiedades de formateo para el usuario
        switch (formato) {
        case LPSICCBaseNueva.FORMATO_DEFAULT:
            cantidadDecimales = "2";
            break;
        case LPSICCBaseNueva.FORMATO_MONEDA:
            cantidadDecimales = UtilidadesSession.getFormatoNumerico(this);
            break;
        case LPSICCBaseNueva.FORMATO_ALTERNATIVA:
            cantidadDecimales =
                    UtilidadesSession.getFormatoNumericoAlternativo(this);
            break;
        default:
            throw new Exception("formato desconocido");

        }

        //formateamos y devolvemos el valor
        //la parte del separador de miles es simple, se quitan
        StringTokenizer tokens =
            new StringTokenizer(valorParametro, separadorMiles);
        StringBuffer buffer = new StringBuffer();

        while (tokens.hasMoreTokens()) {
            buffer.append(tokens.nextToken());
        }

        valorParametro = buffer.toString();

        //ahora cambio el separador decimal si corresponde
        if (separadorDecimal.equals(",")) {
            tokens = new StringTokenizer(valorParametro, separadorDecimal);
            buffer = new StringBuffer();

            //El numero tiene separador decimal, por lo tanto tiene decimales.
            if (tokens.countTokens() == 2) {
                buffer.append(tokens.nextToken());
                buffer.append(".");
                buffer.append(tokens.nextToken());
            } else {
                //No tiene separador decimal
                buffer.append(tokens.nextToken());
            }


            valorParametro = buffer.toString();
        }

        return valorParametro;
    }

    public void ejecutarReporte2(HashMap datos, String businessID,
                                 String idReporte,
                                 String extension) throws Exception {
        pagina("contenido_generando_fichero");
        DruidaConector d1 = null;
        Vector vec = new Vector();
        DTOReporte dto = new DTOReporte();
        MareBusinessID id = new MareBusinessID(businessID);

        System.out.println("La ext. que recibo, es: " + extension);

        datos.put(ConstantesREP.PAIS, UtilidadesSession.getPais(this));
        datos.put(ConstantesREP.DESCPAIS,
                  UtilidadesSession.getDescripcionPais(this));

        datos.put(ConstantesREP.USUARIO, UtilidadesSession.getIdUsuario(this));
        datos.put(ConstantesREP.IDIOMA, UtilidadesSession.getIdioma(this));
        datos.put(ConstantesREP.FORMATOFECHA,
                  UtilidadesSession.getFormatoFecha(this));
        datos.put(ConstantesREP.SEPARADORDECIMALES,
                  UtilidadesSession.getSeparadorDecimales(this));
        if (extension == null || extension.length() < 1) {
            extension = "pdf";
        }
        datos.put(ConstantesREP.EXTENSION, extension);

        System.out.println("el hash, es....: " + datos);

        dto.setIdReporte(idReporte);
        dto.setParametros(datos);

        vec.add(dto);
        vec.add(id);

        traza("***********antes de castear");
        d1 = conectar("ConectorReporte", vec);

        String salidaBatch = ((DTOString)d1.objeto("dtoSalida")).getCadena();
        traza("la salida batch es " + salidaBatch);
        traza("la extension, es: " + extension);
        asignarAtributo("VAR", "idProceso", "valor", salidaBatch);

        asignarAtributo("VAR", "extension", "valor", extension);
        asignarAtributo("VAR", "timeoutVentana", "valor",
                        Contexto.getPropiedad("REP", "WINDOWTIMEOUT"));

    }

    public void verReporte(DTOReporte dtoS,
                           String extension) throws Exception {
        byte[] salidaBytes = dtoS.getResultados();
        traza("Array de Bytes: " + salidaBytes.length);

        String path = Contexto.getPropiedad("TMP", "UPLOAD");
        traza("el path es " + path);
        String nombre = dtoS.getNombreResultados();
        traza("el nombre es " + nombre);

        FileOutputStream fichero = new FileOutputStream(path + "/" + nombre);
        //
        /*HashMap datos;
        datos = dtoS.getParametros();
        datos.put(ConstantesREP.PAIS, UtilidadesSession.getPais(this));
        datos.put(ConstantesREP.DESCPAIS, UtilidadesSession.getDescripcionPais(this));

        datos.put(ConstantesREP.USUARIO, UtilidadesSession.getIdUsuario(this));
        datos.put(ConstantesREP.IDIOMA, UtilidadesSession.getIdioma(this));
        datos.put(ConstantesREP.FORMATOFECHA, UtilidadesSession.getFormatoFecha(this));
        datos.put(ConstantesREP.SEPARADORDECIMALES, UtilidadesSession.getSeparadorDecimales(this));

        dtoS.setParametros(datos);*/
        //
        fichero.write(salidaBytes);

        fichero.close();

        DruidaConector conFinal = new DruidaConector();
        XMLDocument xmlDoc = new XMLDocument();
        Document doc = xmlDoc.makeDocument("<FICHERO/>");
        Element e_rows = doc.createElement("ROWSET");
        e_rows.setAttribute("ID", "salida");
        e_rows.setAttribute("NOMBRE", "salida");
        doc.getDocumentElement().appendChild(e_rows);
        Element e_row = doc.createElement("ROW");
        e_rows.appendChild(e_row);
        Element e_campo2 = doc.createElement("CAMPO");
        e_campo2.setAttribute("NOMBRE", "salida");
        e_campo2.setAttribute("TIPO", "FICHEROSTREAM");
        e_campo2.setAttribute("LONGITUD", "100");
        Text txt = doc.createTextNode("fichero" + nombre);
        e_campo2.appendChild(txt);
        e_row.appendChild(e_campo2);
        traza("Element: " + doc.getDocumentElement());
        conFinal.setXML(doc.getDocumentElement());

        traza("Despues");

        if ((extension != null) && (extension.equals("xls"))) {
            fichero("FicheroReportesExcel");
        } else {
            fichero("FicheroReportes");
        }

        asignarAtributo("FICHERO", "Reporte", "nombre", nombre);
        asignar("FICHERO", nombre, conFinal);

    }

    public void ejecutarReporte(HashMap datos, String businessID,
                                String idReporte,
                                String extension) throws Exception {
        DruidaConector d1 = null;
        Vector vec = new Vector();
        DTOReporte dto = new DTOReporte();
        MareBusinessID id = new MareBusinessID(businessID);

        datos.put(ConstantesREP.PAIS, UtilidadesSession.getPais(this));
        datos.put(ConstantesREP.DESCPAIS,
                  UtilidadesSession.getDescripcionPais(this));

        datos.put(ConstantesREP.USUARIO, UtilidadesSession.getIdUsuario(this));
        datos.put(ConstantesREP.IDIOMA, UtilidadesSession.getIdioma(this));
        datos.put(ConstantesREP.FORMATOFECHA,
                  UtilidadesSession.getFormatoFecha(this));
        datos.put(ConstantesREP.SEPARADORDECIMALES,
                  UtilidadesSession.getSeparadorDecimales(this));

        dto.setIdReporte(idReporte);
        dto.setParametros(datos);

        vec.add(dto);
        vec.add(id);

        d1 = conectar("ConectorReporte", vec);
        traza("Reporte " + idReporte + " ejecutado con exito");
        DTOReporte dtoS = (DTOReporte)d1.objeto("dtoSalida");
        byte[] salidaBytes = dtoS.getResultados();
        traza("Array de Bytes: " + salidaBytes.length);

        String path = Contexto.getPropiedad("TMP", "UPLOAD");
        traza("el path es " + path);
        String nombre = dtoS.getNombreResultados();
        traza("el nombre es " + nombre);

        FileOutputStream fichero = new FileOutputStream(path + "/" + nombre);

        fichero.write(salidaBytes);

        fichero.close();

        DruidaConector conFinal = new DruidaConector();
        XMLDocument xmlDoc = new XMLDocument();
        Document doc = xmlDoc.makeDocument("<FICHERO/>");
        Element e_rows = doc.createElement("ROWSET");
        e_rows.setAttribute("ID", "salida");
        e_rows.setAttribute("NOMBRE", "salida");
        doc.getDocumentElement().appendChild(e_rows);
        Element e_row = doc.createElement("ROW");
        e_rows.appendChild(e_row);
        Element e_campo2 = doc.createElement("CAMPO");
        e_campo2.setAttribute("NOMBRE", "salida");
        e_campo2.setAttribute("TIPO", "FICHEROSTREAM");
        e_campo2.setAttribute("LONGITUD", "100");
        Text txt = doc.createTextNode("fichero" + nombre);
        e_campo2.appendChild(txt);
        e_row.appendChild(e_campo2);
        traza("Element: " + doc.getDocumentElement());
        conFinal.setXML(doc.getDocumentElement());

        traza("Despues");

        if ((extension != null) && (extension.equals("xls"))) {
            fichero("FicheroReportesExcel");
        } else {
            fichero("FicheroReportes");
        }

        asignarAtributo("FICHERO", "Reporte", "nombre", nombre);
        asignar("FICHERO", nombre, conFinal);

    }

    /**
     * Obtiene la traduccion desde el archivo idiomas.xml
     * usando el idiom(es, en, etc) y el codigo de traduccion (0059, belc.etiqueta1.valor)
     *
     * @throws java.lang.Exception
     * @return
     * @param codigo
     * @param idioma
     */
    public String getTraduccion(String idioma,
                                String codigo) throws Exception {
        return DruidaUtils.drd30_Traducir(idioma, codigo);
    }

    /**
     * este metodo setea los valores de traduccion para las constantes
     * utilizadas en la clases de formateo de conectores de Druida
     * sacando los valores de las traducciones del archivo idiomas.xml
     *
     * @throws java.lang.Exception
     */
    public void setTraduccionFormatosConector() throws Exception {
        String idioma = UtilidadesSession.getIdioma_ISO(this);
        DruidaDataBase drdDataBase = new DruidaDataBase();
        drdDataBase.setRequest(getRequest());
        drdDataBase.sesionString("BOOL_TRUE",
                                 getTraduccion(idioma, "BelAlmac.indInfoSap.1.label"));
        drdDataBase.sesionString("BOOL_FALSE",
                                 getTraduccion(idioma, "BelAlmac.indInfoSap.0.label"));
    }

    public java.util.Date conectorParametroFecha(String fechaUsuario) throws Exception {
        java.util.Date fechaSalida = null;
        if (fechaUsuario != null && !fechaUsuario.equals("")) {
            String formatoUsuario = UtilidadesSession.getFormatoFecha(this);
            formatoUsuario = formatoUsuario.replaceAll("m", "M");
            SimpleDateFormat f = new SimpleDateFormat();
            f.applyLocalizedPattern(formatoUsuario);
            try {
                fechaSalida = f.parse(fechaUsuario);
            } catch (Exception e) {
                traza("Error al formatear la fecha de usuario: " +
                      fechaUsuario + " , con el formato" + formatoUsuario);
            }
        }
        return fechaSalida;
    }

    public String conectorParametroFechaString(String fechaUsuario) throws Exception {
        String fechaSalida = null;
        java.util.Date fechaDate = null;
        if (fechaUsuario != null && !fechaUsuario.equals("")) {
            String formatoUsuario = UtilidadesSession.getFormatoFecha(this);
            if (formatoUsuario.equalsIgnoreCase("dd/mm/yyyy")) {
                fechaSalida = fechaUsuario;
            } else {
                SimpleDateFormat f = new SimpleDateFormat();
                formatoUsuario = formatoUsuario.replaceAll("m", "M");
                f.applyLocalizedPattern(formatoUsuario);
                try {
                    fechaDate = f.parse(fechaUsuario);
                    f.applyLocalizedPattern("dd/MM/yyyy");
                    fechaSalida = f.format(fechaDate);
                } catch (Exception e) {
                    traza("Error al formatear la fecha de usuario: " +
                          fechaUsuario + " , con el formato" + formatoUsuario);
                }
            }
        }
        return fechaSalida;
    }


}
