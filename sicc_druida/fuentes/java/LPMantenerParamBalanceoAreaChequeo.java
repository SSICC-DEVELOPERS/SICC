/**
* Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOIDs;
import es.indra.druida.DruidaConector;
import java.math.BigDecimal;
import es.indra.sicc.logicanegocio.ape.ConstantesAPE;
import es.indra.sicc.dtos.ape.DTOParamBalanceoAreaChequeo;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringTokenizer;
import java.util.Vector;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import es.indra.sicc.util.xml.XMLDocument;

public class LPMantenerParamBalanceoAreaChequeo extends LPSICCBase {

	private String accion = null;
	private String opcionMenu = null;
	private Long idioma;
	private Long pais;

	public LPMantenerParamBalanceoAreaChequeo() {
		super();
	}


	public void inicio() throws Exception {


	}
	public void ejecucion() throws Exception {
		try{
			this.setTrazaFichero();
			this.traza("LPMantenerParamBalanceoAreaChequeo.ejecucion(): Entrada");
			this.rastreo();
			
			accion = this.conectorParametroLimpia("accion", "", true);
			opcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);
			idioma = UtilidadesSession.getIdioma(this);
			pais = UtilidadesSession.getPais(this);
			
			if(accion.equals("")){
				if(opcionMenu.equals("insertar")){
					this.pagina("contenido_parametros_balanceo_area_chequeo_insertar");
					this.asignarAtributoPagina( "cod", "0973" );
          this.getConfiguracionMenu("LPMantenerParamBalanceoAreaChequeo","Guardar");
          //this.getConfiguracionMenu("LPMantenimientoRegalos", "Consultar");
					cargarCombos();
				}else if(opcionMenu.equals("consultar")||opcionMenu.equals("modificar")||opcionMenu.equals("eliminar")){
					this.pagina("contenido_parametros_balanceo_area_chequeo_modificar");
          this.getConfiguracionMenu("LPMantenerParamBalanceoAreaChequeo");

					// Configurar titulo de caso de uso
					if(opcionMenu.equals("consultar")){
						this.asignarAtributoPagina( "cod", "0975" );
						//this.getConfiguracionMenu("LPMantenerParamBalanceoAreaChequeo","consultar");
					}else if(opcionMenu.equals("modificar")){
						this.asignarAtributoPagina( "cod", "0974" );
						//this.getConfiguracionMenu("LPMantenerParamBalanceoAreaChequeo","modificar");
					}else if(opcionMenu.equals("eliminar")){
						this.asignarAtributoPagina( "cod", "0976" );
            this.getConfiguracionMenu("LPMantenerParamBalanceoAreaChequeo","Eliminar");
					}
					cargarCombos();
				}
			}else if(accion.equals("guardar")){
				 // invocar al metodo guardar 
         guardar();
			}else if(accion.equals("modificar")){
				this.pagina("contenido_parametros_balanceo_area_chequeo_insertar");
					if(opcionMenu.equals("consultar")){
						this.asignarAtributoPagina( "cod", "0975" );
						//this.getConfiguracionMenu("LPMantenerParamBalanceoAreaChequeo","consultar");
					}else if(opcionMenu.equals("modificar")){
						this.asignarAtributoPagina( "cod", "0974" );
						//this.getConfiguracionMenu("LPMantenerParamBalanceoAreaChequeo","modificar");
					}else if(opcionMenu.equals("eliminar")){
						this.asignarAtributoPagina( "cod", "0976" );
            //this.getConfiguracionMenu("LPMantenerParamBalanceoAreaChequeo","Eliminar");
					}
        this.getConfiguracionMenu("LPMantenerParamBalanceoAreaChequeo","Guardar");
				// deshabilitar los combos cbCentroDistribucion y cbLineaArmado
				// cargar los valores
        cargaValores();
				// invocar al metodo obtenerSolicitudesLinea 
				obtenerSolicitudesLinea();
			}else if(accion.equals("detalle")){
				this.pagina("contenido_parametros_balanceo_area_chequeo_insertar");
					if(opcionMenu.equals("consultar")){
						this.asignarAtributoPagina( "cod", "0975" );
						//this.getConfiguracionMenu("LPMantenerParamBalanceoAreaChequeo","consultar");
					}else if(opcionMenu.equals("modificar")){
						this.asignarAtributoPagina( "cod", "0974" );
						//this.getConfiguracionMenu("LPMantenerParamBalanceoAreaChequeo","modificar");
					}else if(opcionMenu.equals("eliminar")){
						this.asignarAtributoPagina( "cod", "0976" );
            //this.getConfiguracionMenu("LPMantenerParamBalanceoAreaChequeo","Eliminar");
					}
        this.getConfiguracionMenu("LPMantenerParamBalanceoAreaChequeo");
				// deshabilitar todos los atributos
				// cargar los valores
        cargaValores();
				// invocar al metodo obtenerSolicitudesLinea 
				obtenerSolicitudesLinea();
			}
      
      this.getFormatosValidaciones();
      
      asignarAtributo("VAR", "hFormatoDef", "valor", (new Integer(this.FORMATO_DEFAULT)).toString());
      
      this.asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
      this.asignarAtributo("VAR", "accion", "valor", accion);
      this.asignarAtributo("VAR", "varIdioma", "valor", idioma.toString());
      this.asignarAtributo("VAR", "varPais", "valor", pais.toString());
      
      this.traza("LPMantenerParamBalanceoAreaChequeo.ejecucion(): Salida");
	
		}catch(Exception e){
			logStackTrace(e);
			this.lanzarPaginaError(e);
		}

	}
	
	private void cargarCombos() throws Exception {
		// Creamos lista composerView
		ComposerViewElementList listElement = new ComposerViewElementList();
		// Creamos DTOBelcorp
		DTOBelcorp dtoe = new DTOBelcorp();
		dtoe.setOidPais(pais);
		dtoe.setOidIdioma(idioma);
		// Carga los Centros de Distribucion
		ComposerViewElement elem1 = new ComposerViewElement();
		elem1.setIDBusiness("APEObtenerDescripcionesCD");
		elem1.setDTOE(dtoe);
		elem1.setPosOID((byte)0);
		elem1.setPosDesc((byte)1);
		listElement.addViewElement(elem1);


		//Llamar al subsistema GestorCargaPantalla
		ConectorComposerView conector = new ConectorComposerView(listElement,this.getRequest());
		traza("conector creado");
		conector.ejecucion();
		traza("ejecutado");
		DruidaConector conConsultar = conector.getConector();
		traza("Obtener conConsultar");

		asignar("COMBO","cbCentroDistribucion", conConsultar,"APEObtenerDescripcionesCD");
		

		// Carga Valores por defecto
    DTOBelcorp dtoBel = new DTOBelcorp();      
    dtoBel.setOidPais(pais);
    dtoBel.setOidIdioma(idioma);
    MareBusinessID mareBusinessID = new MareBusinessID("APEObtenerValoresDefecto");
		Vector params = new Vector();		
		params.addElement(dtoBel);
    params.addElement(mareBusinessID);
 
    traza("antes del conector");
		DruidaConector dc  =	conectar("ConectorObtenerValoresDefecto", params);
    traza("despues del conector");

    DTOSalida dtoSalida = (DTOSalida)dc.objeto("DTOSalida");

		// Asignar Valor por defecto al Combo
		// Se guarda en un variable de la pagina y se establece con JS
		RecordSet rs = dtoSalida.getResultado();
		int i = 0;
		boolean hallado = false;
		while(i<rs.getRowCount()&&!hallado){
      //traza("i["+i+"], hallado["+hallado+"]");
      //traza("rs.getValueAt(i,\"combo\")["+rs.getValueAt(i,"combo")+"], ConstantesAPE.CONFIGURACION_CD["+ConstantesAPE.CONFIGURACION_CD+"]");
			if(((String)rs.getValueAt(i,"combo")).equals(ConstantesAPE.CONFIGURACION_CD)){
				this.asignarAtributo("VAR", "centroDistribucionVD", "valor", rs.getValueAt(i,"OID").toString());
        traza("Valor por defecto: ["+rs.getValueAt(i,"OID").toString()+"]");
				hallado = true;
			}
			i++;
		}
    
    asignarAtributo("VAR", "hCbLineasCDDef", "valor", aplanarLineasCDDef(dtoSalida));
	}
  
  private String aplanarLineasCDDef(DTOSalida dtoSalida) throws Exception{ 
    traza("entro a aplanarLineasCDDef");
    RecordSet valoresDef = dtoSalida.getResultado();
    String lineasCDDef = "";
    int cant = valoresDef.getRowCount();
         
    for(int i=0; i<cant; i++){      
      if(((String)(valoresDef.getValueAt(i,"COMBO"))).equals(ConstantesAPE.LINEA_ARMADO)){
           lineasCDDef = lineasCDDef + "," + ((BigDecimal)valoresDef.getValueAt(i,"OID")).toString();
      }
    }   
    
    if(!lineasCDDef.equals("")){
         return lineasCDDef.substring(1);
    } else {
         traza("No hay linea por defecto");
         return "";
    }
  }

	private void guardar() throws Exception{
    this.traza("LPMantenerParamBalanceoAreaChequeo.guardar(): Por asignar SALIDAGENERICA");
    this.pagina("salidaGenerica");
    String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);      
    String ejecutarOK = null;
    String ejecutarError = null;
    if(opcionMenu.equals("insertar")) {           
      ejecutarOK = "fLimpiar();";
      ejecutarError = "focalizaCD();";
    } else if(opcionMenu.equals("modificar")) { 
      ejecutarOK = "cerrarModal();";
      ejecutarError = "focalizaCD();";
    }

    try{
      this.traza("LPMantenerParamBalanceoAreaChequeo.guardar(): Por leer datos de pantalla");
      // Obtener valores ocultos
      String oidParametros = this.conectorParametroLimpia("oidParametros", "", true);
      String solicitudesLinea = this.conectorParametroLimpia("solicitudesLinea", "", true);
      String horaDias = this.conectorParametroLimpia("txtHoraDia", "", true);
      // Obtener valores de la pantalla
      String oidCentroDistribucion = this.conectorParametroLimpia("oidCentroDistribucion", "", true);
      String oidLineaArmado = this.conectorParametroLimpia("oidLineaArmado", "", true);
      String parametroDistribucion = this.conectorParametroNumero("txtParamDistrib", this.FORMATO_DEFAULT);
      String pedidosArmadoHoras = this.conectorParametroNumero("txtNroPedidoArmado", this.FORMATO_DEFAULT);
      String unidadesChequeoHoraPersona = this.conectorParametroNumero("txtNroUnidades", this.FORMATO_DEFAULT);
      String codAgrupacion = this.conectorParametroNumero("txtCodigoAgrupacion", this.FORMATO_DEFAULT);
	  
  
      this.traza("LPMantenerParamBalanceoAreaChequeo.guardar(): Por construir el DTO");
      // Llenando el DTO
      DTOParamBalanceoAreaChequeo dtoPBAC = new DTOParamBalanceoAreaChequeo();
      if(!oidParametros.equals("")){
        dtoPBAC.setOidParametros(new Long(oidParametros));
      }
      if(!oidCentroDistribucion.equals("")){
        dtoPBAC.setOidCentroDistribucion(new Long(oidCentroDistribucion));
      }
      if(!oidLineaArmado.equals("")){
        dtoPBAC.setOidLineaArmado(new Long(oidLineaArmado));
      }
	  // dmorello, 07/09/2007 - Se saca temporalmente fuera del IF la creacion del DTOOIDs
	  // Se hace para evitar ciertos errores derivados de BELC400000732, a la fecha sin respuesta de DT.
	  Long[] datos = null;
      if(!solicitudesLinea.equals("")){
        // Parsear la cadena, llenar el DTO y establecer valor
        StringTokenizer tokens = new StringTokenizer(solicitudesLinea, ",");
        int nDatos = tokens.countTokens();
        //Long[] datos = new Long[nDatos];
		/* BELC400000734 - dmorello, 10/09/2007 */
		datos = new Long[nDatos];
        int i = 0;
        String str = null;
        while(tokens.hasMoreTokens()){
          str = tokens.nextToken();
          datos[i] = new Long(str);
          i++;
        }
        //DTOOIDs oids = new DTOOIDs();
        //oids.setOids(datos);
        //dtoPBAC.setListaSolicitudes(oids);
      }
	  else {
        datos = new Long[0];
	  }
      DTOOIDs oids = new DTOOIDs();
      oids.setOids(datos);
      dtoPBAC.setListaSolicitudes(oids);
      // Fin dmorello 07/09/2007
	  
	  if(!parametroDistribucion.equals("")){
        dtoPBAC.setParametroDistribucion(parametroDistribucion);
      }
      if(!pedidosArmadoHoras.equals("")){
        dtoPBAC.setPedidosArmadoHoras(pedidosArmadoHoras);
      }
      if(!unidadesChequeoHoraPersona.equals("")){
        dtoPBAC.setUnidadesChequeoHoraPersona(unidadesChequeoHoraPersona);
      }
      if(!codAgrupacion.equals("")){
        dtoPBAC.setCodAgrupacion( new Long(codAgrupacion));
      }

	  traza("hora dia nuevo : " + horaDias + " aa  " + this.conectorParametroLimpia("txtHoraDia", "", true));

      if(!horaDias.equals("")){
        dtoPBAC.setDiaHora(new Double(horaDias));
      }

	  traza("DTO SALIDA " + dtoPBAC);
  
      Vector params = new Vector();
      params.add(dtoPBAC);
      params.add(new MareBusinessID("APEGuardarParamBalanceoAreaChequeo"));
      this.traza("LPMantenerParamBalanceoAreaChequeo.guardar(): Por invocar el conector guardar");
      conectar("ConectorGuardarParamBalanceoAreaChequeo", params);
      asignarAtributo("VAR", "ejecutar", "valor", ejecutarOK);
      this.traza("LPMantenerParamBalanceoAreaChequeo.guardar(): Valor GUARDADO");
    }catch(Exception e){
      traza("Excepcion: " + e);
      asignarAtributo("VAR", "ejecutarError", "valor", ejecutarError);
      throw e;
    }
	}
	
	private void obtenerSolicitudesLinea() throws Exception{
		this.traza("LPMantenerParamBalanceoAreaChequeo.obtenerSolicitudesLinea(): Por armar DTO");
		String oidParametros = this.conectorParametroLimpia("oidParametros", "", true);
		DTOParamBalanceoAreaChequeo dtoPBAC = new DTOParamBalanceoAreaChequeo();
    dtoPBAC.setOidIdioma(idioma);
		if(!oidParametros.equals("")){
			dtoPBAC.setOidParametros(new Long(oidParametros));
		}
		Vector params = new Vector();
		params.add(dtoPBAC);
		params.add(new MareBusinessID("APEObtenerSolicitudesBalanceoAreaChequeo"));
		this.traza("LPMantenerParamBalanceoAreaChequeo.obtenerSolicitudesLinea(): Por invocar el conector...");
    DTOSalida dtoS = (DTOSalida)(conectar("ConectorObtenerSolicitudesBalanceoAreaChequeo", params)).objeto("DTOSalida");
    String solicitudesLinea = "";
    RecordSet rs = dtoS.getResultado();
    for(int i = 0; i < rs.getRowCount(); i++){
      solicitudesLinea += rs.getValueAt(i,"oid") + ",";
    }
    solicitudesLinea = solicitudesLinea.substring(0,solicitudesLinea.length()-1);
		this.traza("LPMantenerParamBalanceoAreaChequeo.obtenerSolicitudesLinea(): Por asignar a variable oculta...");
    this.asignarAtributo("VAR", "solicitudesLinea", "valor", solicitudesLinea);
	}

	private void logStackTrace(Throwable e) throws Exception {
		this.traza("Se produjo la excepcion, en LPMantenerParamBalanceoAreaChequeo: " + e.getMessage());
		ByteArrayOutputStream pila = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(pila);
		if (e instanceof MareException){
			MareException e2=(MareException)e;
			traza("Es una mare Exception con codigo de error: "+e2.getCode());
		}
		e.printStackTrace(out);
		this.traza("stack Trace : " +  pila.toString());
  }
  
  private void cargaValores() throws Exception{
  
		// Obtener valores ocultos
		String oidParametros = this.conectorParametroLimpia("oidParametros", "", true);
		String solicitudesLinea = this.conectorParametroLimpia("solicitudesLinea", "", true);
		// Obtener valores de la pantalla
		String oidCentroDistribucion = this.conectorParametroLimpia("oidCentroDistribucion", "", true);
		String oidLineaArmado = this.conectorParametroLimpia("oidLineaArmado", "", true);
		String parametroDistribucion = this.conectorParametroLimpia("parametroDistribucion", "", true);
		String pedidosArmadoHoras = this.conectorParametroLimpia("pedidosArmadoHoras", "", true);
		String unidadesChequeoHoraPersona = this.conectorParametroLimpia("unidadesChequeoHoraPersona", "", true);
		// Obtener valores de descrpciones de combos
		String centroDistribucion  = this.conectorParametroLimpia("centroDistribucion", "", true);
		String lineaArmado = this.conectorParametroLimpia("lineaArmado", "", true);

		String codAgru  = this.conectorParametroLimpia("codAgrupacion", "", true);
		String horaDias = this.conectorParametroLimpia("horaDias", "", true);
	
    /*
    this.traza("LPMantenerParamBalanceoAreaChequeo.cargaValores: oidParametros["+oidParametros+"]");
    this.traza("LPMantenerParamBalanceoAreaChequeo.cargaValores: solicitudesLinea["+solicitudesLinea+"]");
    this.traza("LPMantenerParamBalanceoAreaChequeo.cargaValores: oidCentroDistribucion["+oidCentroDistribucion+"]");
    this.traza("LPMantenerParamBalanceoAreaChequeo.cargaValores: oidLineaArmado["+oidLineaArmado+"]");
    this.traza("LPMantenerParamBalanceoAreaChequeo.cargaValores: parametroDistribucion["+parametroDistribucion+"]");
    this.traza("LPMantenerParamBalanceoAreaChequeo.cargaValores: pedidosArmadoHoras["+pedidosArmadoHoras+"]");
    this.traza("LPMantenerParamBalanceoAreaChequeo.cargaValores: unidadesChequeoHoraPersona["+unidadesChequeoHoraPersona+"]");
    this.traza("LPMantenerParamBalanceoAreaChequeo.cargaValores: centroDistribucion["+centroDistribucion+"]");
    this.traza("LPMantenerParamBalanceoAreaChequeo.cargaValores: lineaArmado["+lineaArmado+"]");
    */
    
    // Asignar a tags de pantalla
    // Valores ocultos
    this.asignarAtributo("VAR", "oidParametros", "valor", oidParametros);
    this.asignarAtributo("VAR", "solicitudesLinea", "valor", solicitudesLinea);
    this.asignarAtributo("VAR", "oidCentroDistribucion", "valor", oidCentroDistribucion);
    this.asignarAtributo("VAR", "oidLineaArmado", "valor", oidLineaArmado);
    // TAGS XML
    this.asignarAtributo("CTEXTO", "txtNroPedidoArmado", "valor", pedidosArmadoHoras);
    this.asignarAtributo("CTEXTO", "txtNroUnidades", "valor", unidadesChequeoHoraPersona);
    this.asignarAtributo("CTEXTO", "txtParamDistrib", "valor", parametroDistribucion);

    this.asignarAtributo("CTEXTO", "txtCodigoAgrupacion", "valor", codAgru);
    this.asignarAtributo("CTEXTO", "txtHoraDia", "valor", horaDias);
	
	// Combos XML
    RecordSet rs = new RecordSet();
    rs.addColumn("oid");
    rs.addColumn("des");
    rs.addRow(new Object[] {oidCentroDistribucion, centroDistribucion}); 
    this.asignar("COMBO", "cbCentroDistribucion", generarConector("ROWSET", rs, (Vector)rs.getColumnIdentifiers()),"ROWSET");
    //this.checkCombo("cbCentroDistribucion",oidCentroDistribucion);

    RecordSet rs2 = new RecordSet();
    rs2.addColumn("oid");
    rs2.addColumn("des");
    rs2.addRow(new Object[] {oidLineaArmado, lineaArmado}); 
    this.asignar("COMBO", "cbLineaArmado", generarConector("ROWSET", rs2, (Vector)rs2.getColumnIdentifiers()),"ROWSET");
    //this.checkCombo("cbCentroDistribucion",oidLineaArmado);
  }
  
  private DruidaConector generarConector(String rowsetID, RecordSet datos, Vector columns) throws DOMException, Exception{
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
    for (int i=0; i < sizeRows; i++){
      Element e_row = docDestino.createElement("ROW");
      e_rows.appendChild(e_row);
      Element e_campo0   = docDestino.createElement("CAMPO");
      for(int j=0; j < sizeColums; j++){
        if( columns.contains(columsDesc.elementAt(j))){
          Element e_campo2   = docDestino.createElement("CAMPO");
          if(j == 0){
            e_campo0.setAttribute("NOMBRE","oculto");
          }else{
            e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
          }
          e_campo2.setAttribute("TIPO","OBJECTO");
          e_campo2.setAttribute("LONGITUD","50");
          Text txt0 = docDestino.createTextNode((datos.getValueAt(i,j)==null?"":datos.getValueAt(i,j).toString()));
          e_campo2.appendChild(txt0);
          e_row.appendChild(e_campo2);
        }
      }
    }
    conectorValoresPosibles.setXML(docDestino.getDocumentElement());
    return conectorValoresPosibles;
  }
}
