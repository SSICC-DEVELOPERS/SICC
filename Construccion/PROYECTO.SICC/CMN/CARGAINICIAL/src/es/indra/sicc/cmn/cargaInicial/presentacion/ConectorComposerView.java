package es.indra.sicc.cmn.cargaInicial.presentacion;

import es.indra.druida.Contexto;
import es.indra.druida.DruidaConector;
import es.indra.druida.DruidaConectorException;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.enterprise.mln.BusinessFacade;
import es.indra.mare.enterprise.mln.BusinessFacadeHome;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.DTODatosPantalla;
import es.indra.sicc.util.*;
import es.indra.sicc.util.xml.XMLDocument;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.Hashtable;
import java.util.Vector;

import javax.naming.Context;

import javax.rmi.PortableRemoteObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * <p>Title: SICC</p>
 * <p>Description: Esta clase actúa de entrada al subsistema de carga inicial</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Indra</p>
 * @author Gonzalo Herreros González
 * @version 1.0
 */
public class ConectorComposerView {
    //El identificador de negocio de este subsistema
    protected static final String ID_BUSINESS_SUBSISTEMA = "CMNComposerView";
    protected static final String MARE_RESULT_NAME = "resultado";
    public static final String BUSINESS_FACADE = "mare.mln.BusinessFacade";
    private ComposerViewElementList lista; //La entrada al subsistema
    private DTODatosPantalla resultado; //Los resultados obtenidos
    private HttpServletRequest httpservletrequest;

    /**Constructor que recibe la entrada del susistema
     * @param parametros
    * @param request
     */
    public ConectorComposerView(ComposerViewElementList parametros,
        HttpServletRequest request) {
        lista = parametros;
        httpservletrequest = request;
    }

    /*
     * @see es.indra.druida.base.ObjetoNegocio#ejecucion()
     */
    public void ejecucion() throws Exception {
        if (lista == null) {
            return;
        }

        if (httpservletrequest == null) {
            return;
        }

        Context ctx = obtenerContextoInicial();
        resultado = ejecutarProceso(ctx);
    }

    /**Devuelve el resultado del subsistema en forma de conector. Se debe haber realizado
     * primero la ejecucion
     * @return El conector con el resultado de la llamada al servidor
     * @throws Exception
     */
    public DruidaConector getConector() throws Exception {
        if ((lista == null) || (resultado == null)) {
            return null;
        }

        if (lista.getSize() != resultado.obtenerNumeroElementos()) {
            return null;
        }

        XMLDocument xmldocument = new XMLDocument();
        Document document = xmldocument.makeDocument("<ROWSET2/>");

        int i;
        int j;
        RecordSet datosElemento = null;
        Element element = null;

        //Se agrega el elemento "ROWSET" al documento para cada elemento en el ComposerViewElementList envidado.
        for (i = 0; i < resultado.obtenerNumeroElementos(); i++) {
            element = document.createElement("ROWSET");
            element.setAttribute("ID", lista.getViewElement(i).getIDBusiness());
            document.getDocumentElement().appendChild(element);
            datosElemento = resultado.obtenerDatos(i);

            byte posicionOID = lista.getViewElement(i).getPosOID();
            byte posicionDesc = lista.getViewElement(i).getPosDesc();

            if (datosElemento == null) {
                //no tiene nada
                continue;
            }

            if ((posicionOID > datosElemento.getColumnCount()) ||
                    (posicionDesc > datosElemento.getColumnCount())) {
                continue; //Continuamos con el siguiente rowset porque este está mal definido
            }

            //Para cada Row en el RecordSet dentro del DTODatosPantalla se genere un elemento "ROW. )Considerando que los ROW van desde Z=0 hasta Z=datos.obtenerDatos(J).getRowCount()-1)
            Element rows = null;

            for (j = 0; j < resultado.obtenerDatos(i).getRowCount(); j++) {
                rows = generarFilas(document, datosElemento.getRow(j),
                        datosElemento.getColumnName(posicionOID),
                        datosElemento.getColumnName(posicionDesc), posicionOID,
                        posicionDesc);
                element.appendChild(rows);
            }
        }

        DruidaConector druidaConector = new DruidaConector();
        druidaConector.setXML(document.getDocumentElement());

        return druidaConector;
    }

    /**Crea el XML correspondiente la las filas de un rowset, a partir del recordset recibido</p>
     * Como se utiliza para cargar combos, sólo se toman dos columnas: las indicadas por lo parametros
     * posicionOID y posicionDesc.
     * @param document
     * @param row
     * @param nombreColumnaOID
     * @param nombreColumnaDesc
     * @param posicionOID
     * @param posicionDesc
     * @return El XML que representa las filas del vector row
     */
    protected Element generarFilas(Document document, Vector row,
        String nombreColumnaOID, String nombreColumnaDesc, byte posicionOID,
        byte posicionDesc) {
        Element elementRow = document.createElement("ROW");

        //Dentro del ROW se crean dos campos que corresponde a los datos de dos columnas del RecordSet
        Element elementCampo = document.createElement("CAMPO");
        elementCampo.setAttribute("NOMBRE", nombreColumnaOID);
        elementCampo.setAttribute("TIPO", "STRING");
        elementCampo.setAttribute("LONGITUD", "100");

        org.w3c.dom.Text text = document.createTextNode(row.elementAt(
                    posicionOID).toString());
        elementCampo.appendChild(text);
        elementRow.appendChild(elementCampo);

        Element elementCampo2 = document.createElement("CAMPO");
        elementCampo2.setAttribute("NOMBRE", nombreColumnaDesc);
        elementCampo2.setAttribute("TIPO", "STRING");
        elementCampo2.setAttribute("LONGITUD", "100");

        org.w3c.dom.Text text2 = null;

        if (row.elementAt(posicionDesc) != null) {
            text2 = document.createTextNode(row.elementAt(posicionDesc).toString());
        } else {
            text2 = document.createTextNode("");
        }

        elementCampo2.appendChild(text2);
        elementRow.appendChild(elementCampo2);

        return elementRow;
    }

    /** Se crea el Context JNDI para poder hacer la llamada a MARE, los parametros
     *  se obtienenen del context de Druida
     * @return El contexto para llamar a Mare
     * @throws Exception
     */
    protected Context obtenerContextoInicial() throws Exception {
        String txFactory = Contexto.getPropiedad("EJB.CONTEXT"); //java.naming.factory.initial
        String txURL = Contexto.getPropiedad("EJB.URL"); //java.naming.provider.url
        String txUsuario = "";
        String txPassword = "";

        try {
            //HttpServletRequest httpservletrequest = null;
            if (httpservletrequest != null) {
                HttpSession httpsession = httpservletrequest.getSession();

                if (httpsession.getAttribute("DruidaUsuario") != null) {
                    txUsuario = (String) httpsession.getAttribute(
                            "DruidaUsuario");
                }

                if (httpsession.getAttribute("DruidaPassword") != null) {
                    txPassword = (String) httpsession.getAttribute(
                            "DruidaPassword");
                }
            }
        } catch (Exception ex) {
        }

        if (txUsuario.equals("")) {
            UtilidadesLog.warn("OBTENGO EL USUARIO POR DEFECTO");
            txUsuario = Contexto.getPropiedad("EJB.USER");
        }

        if (txPassword.equals("")) {
            txPassword = Contexto.getPropiedad("EJB.PASSWORD");
        }
        
        Hashtable env = new Hashtable();

        //env.put(Context.INITIAL_CONTEXT_FACTORY, "com.evermind.server.rmi.RMIInitialContextFactory");
        //env.put(Context.SECURITY_PRINCIPAL, "admin");
        //env.put(Context.SECURITY_CREDENTIALS, "welcome");
        //env.put(Context.PROVIDER_URL, "ormi://localhost:23891/current-workspace-app");
        UtilidadesLog.warn("USER: "+txUsuario);
        env.put(Context.INITIAL_CONTEXT_FACTORY, txFactory);
        env.put(Context.SECURITY_PRINCIPAL, txUsuario);
        env.put(Context.SECURITY_CREDENTIALS, txPassword);
        env.put(Context.PROVIDER_URL, txURL);

        return new javax.naming.InitialContext(env);
    }

    /**Ejecuta la solicitud al servidor utilizando el contexto que se pasa.
     * Como parametros se envía el atributo lista, que se configura en el constructor
     * @param ctx
     * @return El resultado de la operación de negocio
     * @throws DruidaConectorException
     */
    protected DTODatosPantalla ejecutarProceso(Context ctx)
        throws Exception {
        //Se crea el MareBusinessID especifico de este subsistema 
        MareBusinessID id = new MareBusinessID(ID_BUSINESS_SUBSISTEMA);
        Object objResult = null;

        try {
            //Llamamos al servidor Mare para ejecutar la operacion
            Object objref = ctx.lookup(BUSINESS_FACADE);
            BusinessFacadeHome home = (BusinessFacadeHome) PortableRemoteObject.narrow(objref,
                    BusinessFacadeHome.class);
            BusinessFacade ejbObject = home.create();
            objResult = ejbObject.execute(lista, id);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR",e);

            //throw new DruidaConectorException("No se pudieron obtener los datos solicitados.\n\nStack:\n"+e.toString());

            /*try{
              BelcorpError belcorpError = new BelcorpError();
              DTOError dtoError = belcorpError.obtenerError(e);
              if(!(Integer.parseInt(dtoError.getCodigoError())==5)){
                throw e;
              }
            }catch(Exception e2){
              throw e;
            }*/
            throw e;
        }

        //Se obtiene el DTODatosPantalla que devuelve la llamada
        if ((objResult == null) || !(objResult instanceof DTODatosPantalla)) {
            return null;
        } else {
            return (DTODatosPantalla) objResult;
        }
    }
}
