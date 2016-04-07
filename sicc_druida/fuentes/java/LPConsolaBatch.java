import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.cmn.negocio.batch.DTOConsolaBatch;
import es.indra.sicc.util.DTOSalida;

import es.indra.sicc.cmn.negocio.batch.DTOConsolaBatch;

import es.indra.sicc.util.DTOBelcorp;
import java.text.SimpleDateFormat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class LPConsolaBatch extends LPSICCBase {
    private Long pais = null;
    private Long idioma = null;
    private String accion =null;   

  public void inicio() throws Exception{
  }

  public LPConsolaBatch() 
  {
    super();
  }

    public void ejecucion() throws Exception {
         this.setTrazaFichero();
         try{
             traza("LLEGA");
             this.rastreo();

             accion = conectorParametro("accion");
             accion = (accion==null?"":accion);
             traza("accion"+accion);
             if (accion.equalsIgnoreCase("")){

                  pais=UtilidadesSession.getPais(this);
                  idioma=UtilidadesSession.getIdioma(this);
				  asignarAtributo( "VAR", "hIdioma", "valor", idioma.toString()); 
  			      asignarAtributo( "VAR", "hPais", "valor", pais.toString()); 
                  traza("scs1");
                  asignarAtributo( "VAR", "hMostrarLista", "valor", "0");   
				  traza("scs2");
                  this.muestraPagina();
				  this.getConfiguracionMenu("LPConsolaBatch");

             }else if(accion.equalsIgnoreCase("subprocesos")){
                  pais=UtilidadesSession.getPais(this);
                  idioma=UtilidadesSession.getIdioma(this);
				  this.cargoSubProcesos();
             }             
         }catch(Exception e){
             logStackTrace(e);
             e.printStackTrace();
             this.lanzarPaginaError(e);
         }
    }

    private void muestraPagina() throws Exception{
		 pagina("contenido_subsistema_batch_consultar");
         this.getFormatosValidaciones();
         DTOBelcorp dto = new DTOBelcorp();
         dto.setOidIdioma(idioma);
         dto.setOidPais(pais);
		 ComposerViewElementList lista = new ComposerViewElementList();
		 ComposerViewElement ci1 = new ComposerViewElement();

         ci1.setIDBusiness( "BATCHEstadosProcesos" ); 
         ci1.setDTOE( dto ); 

		 lista.addViewElement( ci1 );

		 //Utilizamos el subsistema 
		 traza("antes de conectar con BATCHEstadosProcesos");
         ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
         conector.ejecucion();
		 traza("luego de conectar con BATCHEstadosProcesos");

		 DruidaConector resultados = null; 
		 traza("SCS ## 1");
		 resultados = conector.getConector(); 
		 traza("SCS ## 2");

		 asignar("COMBO", "cbEstado", resultados, "BATCHEstadosProcesos");

         asignarAtributo( "VAR", "hFechaIni", "valor", hoyAString());    
         asignarAtributo( "VAR", "hFechaFin", "valor", hoyAString());      

		 traza("SCS ## 3");

    }

    private String hoyAString() throws Exception {
        String formato = UtilidadesSession.getFormatoFecha(this);
        traza("Formato fecha: "+formato);
        int pos = formato.indexOf("mm");
        if ( pos > -1) 
            formato = formato.substring(0, pos) + "MM" + formato.substring(pos+2);
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        String fecha = sdf.format(new java.util.Date());
        traza("Fecha: "+fecha);

        return fecha;
    }

	public void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());

		ByteArrayOutputStream pila = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(pila);
		if (e instanceof MareException)
		{
			
			MareException e2=(MareException)e;
			traza("Es una mare Exception con codigo de error: "+e2.getCode());
		
		}
		e.printStackTrace(out);
		traza("stack Trace : " +  pila.toString());
	}

    private java.util.Date stringAFecha(String fecha) throws Exception {
        if (fecha.trim().equals(""))
            return null;
        String formato = UtilidadesSession.getFormatoFecha(this);
        int pos = formato.indexOf("mm");
        if ( pos > -1) 
            formato = formato.substring(0, pos) + "MM" + formato.substring(pos+2);
        SimpleDateFormat sdf = new SimpleDateFormat(formato);

        return sdf.parse(fecha);
    }

    private void cargoSubProcesos() throws Exception { 
  	    pagina("contenido_subsistema_batch_consultar_detalle"); 
		traza("dentro de: cargoSubProcesos()..........");

		this.getConfiguracionMenu("LPConsolaBatch","");

        String codigoProceso = this.conectorParametroLimpia("dtoCodProc", "", true); 
        // String codigoProceso = (String)conectorParametro("dtoCodProc");  // Oid de Cliente para consultar. 
        traza("Valor de codigoOid: " + codigoProceso);

		DTOConsolaBatch dtoCB = new DTOConsolaBatch();
		dtoCB.setCodProc(codigoProceso);

        dtoCB.setOidIdioma(idioma);
        dtoCB.setOidPais(pais);

        Vector paramEntradaConsulta     = new Vector();
        MareBusinessID idConsulta       = new MareBusinessID("BATCHBuscarSubProcesos");
        DruidaConector conectorConsulta = new DruidaConector();

		paramEntradaConsulta.add(dtoCB);
		paramEntradaConsulta.add(idConsulta);

        traza("Antes del conector 1");
		DruidaConector dc =	conectar( "ConectorBatchProcesosHijo", paramEntradaConsulta);
        traza("Antes de conectar 2");

        DTOSalida dtoS = (DTOSalida) dc.objeto("dtoSalida");
        traza("Luego de conectar");
        traza("dtoDatos: " + dtoS.toString() );

		RecordSet rHIJOS = dtoS.getResultado();

		if (rHIJOS.getRowCount() > 0) {
		  DruidaConector conector = generarConector(rHIJOS);	 
		  asignar( "LISTADOA", "listado1", conector,"resultado" );
        }
		 
    }

    private DruidaConector generarConector(RecordSet rs) throws Exception {
        traza("Inicio generarConector");
        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document docDestino = docBuilder.newDocument();
        Element rowset2 = docDestino.createElement("ROWSET2");
        
        Element rowset = docDestino.createElement("ROWSET");
        rowset.setAttribute("ID", "resultado");
        rowset2.appendChild(rowset);

        for (int i = 0; i < rs.getRowCount(); i++) {
            Element elemRow = docDestino.createElement("ROW");
            rowset.appendChild(elemRow);

            Element elemDato = docDestino.createElement("CAMPO");
            elemDato.setAttribute("NOMBRE", "Ident");
            elemDato.setAttribute("TIPO", "STRING");
            elemDato.setAttribute("LONGITUD", "50");
            Text txt = docDestino.createTextNode(i+"");
            elemDato.appendChild(txt);
            elemRow.appendChild(elemDato);

            for (int k = 0; k < rs.getColumnCount(); k++) {
                elemDato = docDestino.createElement("CAMPO");
                elemDato.setAttribute("NOMBRE", rs.getColumnName(k));
                elemDato.setAttribute("TIPO", "STRING");
                elemDato.setAttribute("LONGITUD", "50");
                String dato = rs.getValueAt(i, k) == null ? "" : rs.getValueAt(i, k).toString();
                txt = docDestino.createTextNode(dato);
                elemDato.appendChild(txt);
                elemRow.appendChild(elemDato);
                
            }

        }

        DruidaConector conectorLista = new DruidaConector();
        conectorLista.setXML(rowset2);

        return conectorLista;
    }

}