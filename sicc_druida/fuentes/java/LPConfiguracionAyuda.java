import LPSICCBase;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import java.util.HashMap;
import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.mare.common.mgu.manager.Property;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.MareCredentials;
import es.indra.mare.common.exception.MareException;
import es.indra.druida.DruidaConector;
import es.indra.sicc.util.IVariablesSesion;

import es.indra.sicc.dtos.seg.FuncionesPerfilesUsuarioDTO;
import es.indra.sicc.dtos.seg.PerfilesUsuarioDTO;
import es.indra.sicc.dtos.seg.AyudaDTO;

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOSalida;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;

import java.util.*;
import java.lang.reflect.Array;
import java.sql.Date;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.dom.DOMException;
import es.indra.sicc.util.xml.XMLDocument;

import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.dtos.zon.DTOUsuario;

public class LPConfiguracionAyuda extends LPSICCBase {

    private Long idioma;
  
    public LPConfiguracionAyuda() {
        super();
    }

    public void inicio() throws Exception {
        idioma = UtilidadesSession.getIdioma(this);
    }

    public void ejecucion() throws Exception {   

        asignarAtributoPagina("cod", "03"); 
        
        setTrazaFichero();
        traza("******* ENTRO A LPConfiguracionAyuda **********");
        String accion = conectorParametro("accion");
        traza("Accion: " + accion);
        if (accion == null)
            accion = "";
        try {
            // Rastreo
            rastreo();

            if ( accion.equals("") ) {
                accionVacia();
            } else if (accion.equals("modificar")) {
                accionModificarAyuda();
            } else if (accion.equals("grabar")) {
                accionGrabarAyuda();
            }
            
        } catch (Exception ex) {
            traza("Excepcion");
            logStackTrace(ex);
            //i18n gus
            preservaHiddensI18n(new Integer(1), "SEG_AYUDA", "frmConfigurarAyuda", "areaObservaciones", false);
            //manejo de error
            this.lanzarPaginaError(ex);
            asignarAtributo("VAR","ejecutarError","valor","noPersistio();");
        } 
        getConfiguracionMenu("LPConfiguracionAyuda");      
    }


    private void accionVacia() throws Exception {
        traza("Accion vacío");
        traza("SCS.....");
        pagina("contenido_ayuda_configurar");
        traza("SCS1.....");
        //String sExito = conectorParametro("exito");
        cargaComboFunciones();
        asignarAtributo("VAR", "accion", "valor", "");
        //i18n gus
        anyadeHiddensI18N(true, "SEG_AYUDA", null, new Integer(1), "frmConfigurarAyuda", "areaObservaciones", false);
    }


    private void accionModificarAyuda() throws Exception {
        pagina("salidaGenerica"); 
        traza("Accion modificar SCS");
        //cargaComboFunciones();
            
        //asignarAtributo("CAPA", "capaResultado", "visibilidad", "visible");
        Long oidFuncion = new Long( conectorParametro("oidFuncion") );
        traza("oidFuncion SCS: " + oidFuncion.toString() );

        MareBusinessID bussID = new MareBusinessID("BuscarAyudaFuncion");
        Vector params = new Vector();
        AyudaDTO ayudaDTO= new AyudaDTO();            

        ayudaDTO.setPrograma( UtilidadesSession.getFuncion(this) );
        ayudaDTO.setIpCliente( UtilidadesBelcorp.getIPCliente(this) );
        ayudaDTO.setOidIdioma(idioma);
        ayudaDTO.setOidFuncion(oidFuncion);

        params.add(ayudaDTO);
        params.add(bussID);
        traza("Antes de conectar");
        DruidaConector con = conectar("ConectorBuscarAyudaFuncion", params);
        traza("Despues de conectar");
            
        AyudaDTO ayudaDTOSalida = (AyudaDTO) con.objeto("dtoSalida");
        
        if (ayudaDTOSalida == null)
          traza("ayudaDTOSalida es null");
        else
          traza("ayudaDTOSalida: " + ayudaDTOSalida);
              
        traza("Obtiene textoAyuda");
        String sTextoAyuda = ayudaDTOSalida.getTextoAyuda();
        traza("sTextoAyuda es: " + sTextoAyuda);
        if (sTextoAyuda == null)
            sTextoAyuda = "";
        
        anyadeHiddensI18N(true, "SEG_AYUDA", ayudaDTO.getOidFuncion(), new Integer(1), "frmConfigurarAyuda", "areaObservaciones", false);
        
        asignarAtributo("VAR","ejecutar","valor","guardoOk('"+oidFuncion+"','"+sTextoAyuda+"');");

    }


    private void accionGrabarAyuda() throws Exception {
        pagina("salidaGenerica");
        traza("Accion grabar");
        // Se obtiene la información del XML.
        String sOidFuncion = conectorParametro("oidFuncion");
        //String sOidAyuda = conectorParametro("oidAyuda");
        String sTextoAyuda = conectorParametro("textoAyuda");

        AyudaDTO dtoAyuda = new AyudaDTO();

        dtoAyuda.setIpCliente( UtilidadesBelcorp.getIPCliente(this) );
        dtoAyuda.setPrograma( UtilidadesSession.getFuncion(this) );
        dtoAyuda.setOidIdioma(idioma);
        dtoAyuda.setOidFuncion( new Long(sOidFuncion) );
        //dtoAyuda.setOidAyuda( new Long(sOidAyuda) );
        //dtoAyuda.setUbicacionFicheroAyuda( sPath );
        dtoAyuda.setTextoAyuda( sTextoAyuda );

        //i18n gus. cargado en false porque voy grabar.
        anyadeHiddensI18N(false, "SEG_AYUDA", dtoAyuda.getOidFuncion(), new Integer(1), "frmConfigurarAyuda", "areaObservaciones", false);
        //i18n gus. recupero las traduccion del atributo traducible. 
        traza("traducciones: " + recuperaTraduccionesI18N(new Integer(1)));
        Vector traducciones = recuperaTraduccionesI18N(new Integer(1));
        dtoAyuda.setVectorTraducciones(traducciones);
        traza("traducciones bis: " + recuperaTraduccionesI18N(new Integer(1)));
              
        MareBusinessID bussID = new MareBusinessID("ModificarAyuda");
        Vector params = new Vector();
        params.add(dtoAyuda);
        params.add(bussID);

        traza("Antes de conectar");
        DruidaConector con = conectar("ConectorModificacionAyuda", params);
        traza("Despues de conectar");
             
        anyadeHiddensI18N(true, "SEG_AYUDA", null, new Integer(1), "frmConfigurarAyuda", "areaObservaciones", false);

        asignarAtributo("VAR","ejecutar","valor","persistioOk();");
        traza("final");
        
    }


    private void cargaComboFunciones() throws Exception {
        traza("Funcion cargaComboFunciones");
    
        HashMap hs = (HashMap)conectorParametroSesion("propiedades");

        String usuario = UtilidadesSession.getIdUsuario(this);
        traza("usuario: " + usuario);
        traza("idioma: " + idioma);

        DTOUsuario dto = new DTOUsuario();
        dto.setIpCliente( UtilidadesBelcorp.getIPCliente(this) );
        dto.setPrograma( UtilidadesSession.getFuncion(this) );
        dto.setIdUsuario( usuario );
        dto.setOidIdioma( idioma );
            
        MareBusinessID bussID = new MareBusinessID("ObtenerFuncionesPerfilesUsuario");
        Vector params = new Vector();

        params.add(dto);
        params.add(bussID);

        traza("Antes de conectar");
        DruidaConector con = conectar("ConectorObtenerFuncionesPerfilesUsuario", params);
        traza("Despues de conectar");
 
        asignar("COMBO","comboCodFuncion", con, "dtoSalida.resultado_ROWSET"); 

        traza("Sale de cargaComboFunciones");
    }
  

	/***
	* Genera un conector XML, a partir de un Rowset que contiene los datos a cargar.
	* @param rowsetId, Identificador del rowset.
	* @param datos, Rowset con los datos a cargar.
	* @param colums, Indica las columnas del rowset a completar.
	*/
	private DruidaConector generarConector(String rowsetID,RecordSet datos,Vector columns)
		throws DOMException,Exception
	{
		StringBuffer salida = new StringBuffer();
		int sizeColums = datos.getColumnCount();
		int sizeRows = datos.getRowCount();

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
		
		for (int i=0; i < sizeRows; i++)
		{
			Element e_row = docDestino.createElement("ROW");
			e_rows.appendChild(e_row);

			for (int j=0; j < sizeColums; j++){
				if ( columns.contains(columsDesc.elementAt(j)) ){
					Element e_campo2   = docDestino.createElement("CAMPO");
					e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
					e_campo2.setAttribute("TIPO","OBJECTO");
					e_campo2.setAttribute("LONGITUD","50");
					Text txt = docDestino.createTextNode((datos.getValueAt(i,j)==null?"":datos.getValueAt(i,j).toString()));
					e_campo2.appendChild(txt);
					e_row.appendChild(e_campo2);
				}
			}
		}	
		conectorValoresPosibles.setXML(docDestino.getDocumentElement());
		return conectorValoresPosibles;
	}

  
    public String replace(String s, String s1, String s2) {
        int i = 0;
        int j = 0;
        int k = s1.length();
        StringBuffer stringbuffer = null;
        String s3 = s;
        while((j = s.indexOf(s1, i)) >= 0) 
        {
            if(stringbuffer == null)
            {
                stringbuffer = new StringBuffer(s.length() * 2);
            }
            stringbuffer.append(s.substring(i, j));
            stringbuffer.append(s2);
            i = j + k;
        }
        if(i != 0)
        {
            stringbuffer.append(s.substring(i));
            s3 = stringbuffer.toString();
        }
        return s3;
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
