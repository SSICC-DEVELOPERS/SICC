//import LPSICCBase;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.mae.DTOClasificaciones;
import es.indra.sicc.dtos.mav.DTOCampaniaEstimadosBP;
import es.indra.sicc.dtos.mav.DTODetalleCampaniaEstimadosBP;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

public class LPSimularEstimadosBP extends LPSICCBase {
	private String casoDeUso = null;
	private String accion = null;
	private Long idioma = null;
	private Long pais = null;
	private String descPais = null;
	private String oide =null;
	private String estatus1 =null;
	private String estatus2 =null;
	private String programa =null;
	private String detalle=null; 
	private String esta1 = null;
	private String marca=null;
	private String tip_cli=null;
	private String actividad=null;
	private String ipcliente= null;
	private String campana =null;
	private String seleccion= null;

  private String oidsSubtipos = null;
  private String oidDetalleMAV = null; 
  private String tipoClasificacion = null;
  private String clasificacion = null;

  private String idsSubtiposCliente = null;
  private String idTipoClasificacion = null;
  private String idClasificacion = null;
  private String valUnidadesPromedio = null;
  private String valUnidadesTotales = null;  

  private String codVenta = null;

  private String recal = null;

  private String recalCodProducto = null;
  private String recalCodVenta = null;
  private String recalDesProducto = null;
  private String recalClientesEsti = null;
  private String recalUnidadesPro = null;
  private String recalUnidadesTot = null;
  private String recalUnidadesDis = null;
  private String recalCondicion = null;
  private String recalValCondicion = null;
	
	public LPSimularEstimadosBP() {	super();	}              
	public void inicio() throws Exception	{	}
  
	public void ejecucion() throws Exception {
		try {
			setTrazaFichero();

      pais = UtilidadesSession.getPais(this);
			idioma= UtilidadesSession.getIdioma(this);
			ipcliente= UtilidadesBelcorp.getIPCliente(this);
			programa = UtilidadesSession.getFuncion(this);
			descPais = UtilidadesSession.getDescripcionPais(this);
      
			casoDeUso = conectorParametro("casoDeUso")==null?"":conectorParametro("casoDeUso");
			accion = conectorParametro("accion")==null?"":conectorParametro("accion");			
			marca=conectorParametro("marca")==null?"":conectorParametro("marca");
			tip_cli=conectorParametro("tip_cli")==null?"":conectorParametro("tip_cli");
			actividad=conectorParametro("actividad")==null?"":conectorParametro("actividad");			
			campana =conectorParametro("campana")==null?"":conectorParametro("campana");
			seleccion= conectorParametro("seleccion")==null?"":conectorParametro("seleccion");

      oidsSubtipos = conectorParametro("oidsSubtipos")==null?"":conectorParametro("oidsSubtipos");
      oidDetalleMAV = conectorParametro("oidDetalleMAV")==null?"":conectorParametro("oidDetalleMAV");
      tipoClasificacion = conectorParametro("tipoClasificacion")==null?"":conectorParametro("tipoClasificacion");
      clasificacion = conectorParametro("clasificacion")==null?"":conectorParametro("clasificacion");

      idsSubtiposCliente = conectorParametro("idsSubtiposCliente")==null?"":conectorParametro("idsSubtiposCliente");
			idTipoClasificacion = conectorParametro("idTipoClasificacion")==null?"":conectorParametro("idTipoClasificacion");
			idClasificacion = conectorParametro("idClasificacion")==null?"":conectorParametro("idClasificacion");			
			valUnidadesPromedio = conectorParametro("valUnidadesPromedio")==null?"":conectorParametro("valUnidadesPromedio");
			valUnidadesTotales = conectorParametro("valUnidadesTotales")==null?"":conectorParametro("valUnidadesTotales");

      codVenta = conectorParametro("codVenta")==null?"":conectorParametro("codVenta");

      recal = conectorParametro("recal")==null?"":conectorParametro("recal");

      recalCodProducto = conectorParametro("recalCodProducto")==null?"":conectorParametro("recalCodProducto");
      recalCodVenta = conectorParametro("recalCodVenta")==null?"":conectorParametro("recalCodVenta");
      recalDesProducto = conectorParametro("recalDesProducto")==null?"":conectorParametro("recalDesProducto");
      recalClientesEsti = conectorParametro("recalClientesEsti")==null?"":conectorParametro("recalClientesEsti");
      recalUnidadesPro = conectorParametro("recalUnidadesPro")==null?"":conectorParametro("recalUnidadesPro");
			recalUnidadesTot = conectorParametro("recalUnidadesTot")==null?"":conectorParametro("recalUnidadesTot");
			recalUnidadesDis = conectorParametro("recalUnidadesDis")==null?"":conectorParametro("recalUnidadesDis");			
			recalCondicion = conectorParametro("recalCondicion")==null?"":conectorParametro("recalCondicion");
			recalValCondicion = conectorParametro("recalValCondicion")==null?"":conectorParametro("recalValCondicion");
			
			/*
			Si accion = "" entonces 
				-> ejecutar método privado "cargarPagina" 
			Si accion = "detalle" entonces 
				-> ejecutar método privado "cargarDetalle" 
			Si accion = "cargarPaginaDetalle" entonces 
				-> ejecutar método privado "cargarPaginaDetalle" 
			Si accion = "recalcular" entonces 
				-> ejecutar método privado "recalcular" 
			Si accion = "actualizar" entonces 
				-> ejecutar método privado "actualizar" 
			Fin Si
			 */
			if (accion.equalsIgnoreCase("")){
				this.cargarPagina();
			}
			if (accion.equalsIgnoreCase("detalle")) {
				this.cargarDetalle();
			}
			if (accion.equalsIgnoreCase("cargarPaginaDetalle")){
				this.cargarPaginaDetalle();
			}
			if (accion.equalsIgnoreCase("recalcular")){
				this.recalcular();
			}
			if (accion.equalsIgnoreCase("actualizar")){
				this.actualizar();
			}
			traza("Fin LPSimularEstimadosBP.ejecucion()");
		}	
		 
		catch (Exception ex ) {
			traza(ex);
			 this.lanzarPaginaError(ex);
		}
		traza(this.getXML().getDocumentElement());
	}
	public void cargarPagina() throws Exception{
	/*
		 -> Asignar página "contenido_campana_seleccionar" 
		-> Crear idBusiness = "MAVCargarCampañasSimularEstimadosBP" 
		-> Crear objeto DTOBelcorp con pais e idioma de la sesión 
		-> Asignar conector ConectorCargarCampañasSimularEstimadosBP 
		-> Recuperar DTOSalida y mapear el RecordSet en la lista editable "campañas" 
		-> Dejar habilitado el botón "detalle" y ocultar la lista "detalleCampaña" y el botón "recalcular"
	*/

  traza("************** Entre a cargarPagina");
  
		try {
			traza("a ver si ahorra!!!!");
			pagina("contenido_campana_seleccionar");
			traza("a ver si ahorra!!!! 2");
			getConfiguracionMenu("LPSimularEstimadosBP","");
			traza("a ver si ahorra!!!! 3");
			asignarAtributo("VAR","idioma","valor",this.idioma.toString());
			asignarAtributo("VAR","pais","valor",this.pais.toString());
			traza("a ver si ahorra!!!! 4");
		}
		 catch (Exception ex ){
			traza(ex);
			this.lanzarPaginaError(ex);
		}	
	}

	public void cargarDetalle() throws Exception{
	/*	-> Crear idBusiness = "MAVCargarDetalleSimularEstimadosBP" 
		-> Tomar los datos del registro seleccionado en la lista "campañas" 
		-> Crear objeto DTOCampañaEstimadosBP y llenar sus atributos con los datos tomados en la actividad anterior 
		-> Asignar conector "ConectorCargarDetalleSimularEstimadosBP" 
		-> Recuperar objeto DTOSalida y mapear el RecordSet que lleva dentro en la lista editable "detalleCampaña" 
		-> Motrar la lista y habilitar los campos editables de la misma 
		-> Mostrar y habilitar el botón "recalcular" 
	*/

  traza("************** Entre a cargarDetalle");
  
		try {
    traza("***************** Entre a cargarDetalle");
		pagina("salidaGenerica");
    traza("***************** Creando BusinessID y DTO");
		MareBusinessID mar = new MareBusinessID("MAVCargarDetalleSimularEstimadosBP");
		DTOCampaniaEstimadosBP dtoe = new DTOCampaniaEstimadosBP();
    traza("***************** Seteando Actividad " + actividad);
		dtoe.setActividad(new Long (actividad));
    traza("***************** Seteando IpCliente " + ipcliente);
		dtoe.setIpCliente(ipcliente);
    traza("***************** Seteando Marca " + marca);
		dtoe.setMarca(new Long(marca));
    traza("***************** Seteando Idioma " + idioma);
		dtoe.setOidIdioma(idioma);
    traza("***************** Seteando Pais " + pais);
		dtoe.setOidPais(pais);
    traza("***************** Seteando Pais " + pais);
		dtoe.setPais(pais);
    traza("***************** Seteando Tipo de cliente " + tip_cli);
		dtoe.setTipoCliente(new Long (tip_cli));
    
    // Agregado por ssantana, 15/6/2005
    // Inc. 18071. 
    traza("***************** Seteando Campaña: " + campana);
    dtoe.setPeriodo(new Long(campana));
    
		Vector vec =new Vector();
		vec.add(dtoe);
		vec.add(mar);
		traza("***************** Antes de conectar");
		DruidaConector llamada = conectar("ConectorCargarDetalleSimularEstimadosBP",vec);
    traza("***************** Despues de conectar");
		
    DTOSalida salida =(DTOSalida)  llamada.objeto("DTOSalida"); 			
		traza("***************** Obtiene RecordSet");
		RecordSet resu = salida.getResultado();
		traza ("RecordSet " + resu);

		StringBuffer resultado = new StringBuffer();
		for (int i=0 ;i <resu.getRowCount(); i++){
			for (int j =0 ;j < resu.getColumnCount();j++){
				if (j==0){
					resultado.append(resu.getValueAt(i,j));
				} 
				else{
					resultado.append("¬"+ resu.getValueAt(i,j));
				}
				
			}
			resultado.append("|");
		}
			asignarAtributo("VAR", "ejecutar", "valor", "datos('"+resultado.toString() +"')");
		}
		 catch (Exception ex ){
			traza(ex);
			this.lanzarPaginaError(ex);
		}	
	}
	public void cargarPaginaDetalle() throws Exception{
		/*
		 -> Asignar página "contenido_campana_recalcular" 
			-> Tomar el oidTipoCliente del registro seleccionado en la lista editable "campañas" 
			de la pantalla "contenido_campana_seleccionar" y crear un DTOOID con él, 
			y con pais e idioma de la sesión 
		-> Llamar al subsistema GestorCargaPantalla con la siguiente información 
		- idBusiness = "MAEObtenerSubTipos" y DTOOID creado => llena combo "subtiposCliente" de la lista "detalleCampaña" 


		-> Crear objeto DTOBelcorp con idioma y pais de la sesión 
		-> Crear idBusiness = "MAVCargarClasificacionTipoClasificacion" 
		-> Asignar conector "ConectorCargarClasificacionTipoClasificacion" con idBusiness y DTOBelcorp creados 
		-> Recuperar DTOClasificaciones y mapear los RecordSet que contiene en los combos de tipoClasificacion y clasificacion de la pantalla "contenido_campana_recalcular" 


	  -> Tomar oid de Detalle MAV del registro seleccionado en la lista editable "detalleCampaña"
    de la pantalla "contenido_campana_seleccionar" y crear objeto DTOOID con pais e idioma
    }de la sesión y con el oid de Detalle MAV 
		-> Crear idBusiness = "MAVCargarFormularioRecalculo" 
		-> Asignar conector "ConectorCargarFormularioRecalculo" con idBusiness y DTOOID creados 
		-> Recuperar objeto DTODetalleCampañaEstimadosBP y mapearlo en la pantalla 
		-> Habilitar botones "aceptar" y "recalcular" 
		*/

		try {
      traza("************** Entre a cargarPaginaDetalle");

      traza("************** oidsSubtipos " + oidsSubtipos);
      traza("************** oidDetalleMAV " + oidDetalleMAV);
      traza("************** tipoClasificacion " + tipoClasificacion);
      traza("************** clasificacion " + clasificacion);
      traza("************** Idioma " + idioma);
      
			pagina("contenido_campana_recalcular");
      this.getFormatosValidaciones();
      getConfiguracionMenu("LPSimularEstimadosBP","recalcular");
      asignarAtributo("VAR","oidDetalleMAV","valor", oidDetalleMAV);

      //1° - Asignar al combo Subtipo cliente

			DTOOID oid = new DTOOID();
			oid.setIpCliente(ipcliente);
			oid.setOid(new Long(tip_cli));
			oid.setOidIdioma(idioma);
			oid.setOidPais(pais);
      
			MareBusinessID id = new MareBusinessID("MAEobtenerSubtipos");
			Vector vec2 = new Vector();
			vec2.add(oid);
			vec2.add(id);

			traza("******************** Antes de conectar");
			DruidaConector llamada2 = conectar("ConectorObjetoGenerico",vec2);
      traza("******************** Despues de conectar");
      
			DTOSalida dtoclasi2 = (DTOSalida) llamada2.objeto("DTOSalida");
			RecordSet reg2 = dtoclasi2.getResultado();
			DruidaConector con4 = UtilidadesBelcorp.generarConector("tipoclasi2", reg2, reg2.getColumnIdentifiers() );

			asignarAtributo("VAR","codigos1","valor", oidsSubtipos);
			asignar("COMBO", "cbSubtipoCliente", con4, "tipoclasi2");

      //2° - Asignar a los combos tipo clasificacion y clasificacion      
			DTOBelcorp dtoBel = new DTOBelcorp();
			dtoBel.setOidIdioma(idioma);
			dtoBel.setOidPais(pais);
			
			MareBusinessID id2 = new MareBusinessID("MAVCargarClasificacionTipoClasificacion");
			Vector vec = new Vector();
			vec.add(dtoBel);
			vec.add(id2);

      traza("*************** Antes de conectar");
			DruidaConector llamada = conectar("ConectorCargarClasificacionTipoClasificacion",vec);
      traza("*************** Despues de conectar");

			DTOClasificaciones dtoclasi = (DTOClasificaciones) llamada.objeto("DTOClasificaciones");
      //Empieza asignación de los RecordSet completos a las listas ocultas
      RecordSet rsTipoClasi = dtoclasi.getTipoClasificacion();
      RecordSet rsClasi = dtoclasi.getClasificacion();
      
      traza("*************** rsTipoClasi " + rsTipoClasi);
      traza("*************** rsClasi " + rsClasi);      

      DruidaConector conTipo = UtilidadesBelcorp.generarConector("conTipo", rsTipoClasi, rsTipoClasi.getColumnIdentifiers() );
      DruidaConector conClasi = UtilidadesBelcorp.generarConector("conClasi", rsClasi, rsClasi.getColumnIdentifiers() );
      
      asignar("LISTADOA", "listaTipoClasificacion", conTipo, "conTipo");
      asignar("LISTADOA", "listaClasificacion", conClasi, "conClasi");
      //Finaliza asignación de los RecordSet completos a las listas ocultas
      
			RecordSet reg = dtoclasi.getTipoClasificacion();
			Vector col = reg.getColumnIdentifiers();
			RecordSet formateo = new RecordSet();
			formateo.addColumn(col.get(0).toString());			
			formateo.addColumn(col.get(2).toString());
			for (int i=0;i < reg.getRowCount();i++){
				col = new Vector();
				col.add(reg.getValueAt(i,0));
				col.add(reg.getValueAt(i,2));
				formateo.addRow(col);
			}
			traza("******** Tipo clasificacion " + reg);
      traza("******** formateo " + formateo);
			DruidaConector con3 = UtilidadesBelcorp.generarConector("tipoclasi", formateo, formateo.getColumnIdentifiers() );
			asignar("COMBO", "cbTipoClasificacion", con3, "tipoclasi");
      asignarAtributo("VAR","codigos2","valor", tipoClasificacion);      


			reg = dtoclasi.getClasificacion();
			col = reg.getColumnIdentifiers();
			formateo = new RecordSet();
			formateo.addColumn(col.get(0).toString());			
			formateo.addColumn(col.get(2).toString());
			for (int i=0;i < reg.getRowCount();i++){
				col = new Vector();
				col.add(reg.getValueAt(i,0));
				col.add(reg.getValueAt(i,2));
				formateo.addRow(col);
			}
      traza("******** Clasificacion " + reg);
      traza("******** formateo " + formateo);
			DruidaConector con2 = UtilidadesBelcorp.generarConector("clasi", formateo, formateo.getColumnIdentifiers() );
			asignar("COMBO", "cbClasificacion", con2, "clasi");
      asignarAtributo("VAR","codigos3","valor", clasificacion);

      if(recal.equals("false")) {
        traza("********* recal es false");
        traza("********* llamando al BusinessID - MAVCargarFormularioRecalculo");

        //3° - Asignar al resto de los componentes  
      
        oid = new DTOOID();			
        oid.setOid(new Long(oidDetalleMAV));
        oid.setOidPais(pais);
        oid.setOidIdioma(idioma);
        id =new MareBusinessID("MAVCargarFormularioRecalculo");
        vec = new Vector();
        vec.add(oid);
        vec.add(id);
        llamada = conectar("ConectorCargarFormularioRecalculo",vec);
        DTODetalleCampaniaEstimadosBP deta = (DTODetalleCampaniaEstimadosBP) llamada.objeto("DTODetalleCampaniaEstimadosBP");
        traza("deta: " + deta);
			
        if (deta.getNumeroClientesEstimados()!=null){
          asignarAtributo("LABELC","lbldtNumClientesEstimados","valor",deta.getNumeroClientesEstimados().toString());
          asignarAtributo("VAR","cliEsti","valor",deta.getNumeroClientesEstimados().toString());
        }
        else {
          asignarAtributo("LABELC","lbldtNumClientesEstimados","valor","");
        }
        
        if (deta.getCodigoVenta()!=null){
          asignarAtributo("LABELC","lbldtCodVenta","valor",deta.getCodigoVenta());
          asignarAtributo("VAR","codVenta","valor", deta.getCodigoVenta());
        }
        else {
          asignarAtributo("LABELC","lbldtCodVenta","valor","");
        }
        
        if (deta.getCondicion()!=null){
          asignarAtributo("LABELC","lbldtCondicion","valor",deta.getCondicion());
          asignarAtributo("VAR","condi","valor", deta.getCondicion());
        }
        else {
          asignarAtributo("LABELC","lbldtCondicion","valor","");
        }
        
        if (deta.getCodigoSAP()!=null){
          asignarAtributo("LABELC","lbldtCodProducto","valor",deta.getCodigoSAP());
        }
        else {
          asignarAtributo("LABELC","lbldtCodProducto","valor","");
        }
        
        if (deta.getDescripcionProducto()!=null){
          asignarAtributo("LABELC","lbldtDescripcionProducto","valor",deta.getDescripcionProducto());
        }
        else {
          asignarAtributo("LABELC","lbldtDescripcionProducto","valor","");
        }
        
        if (deta.getUnidadesDisponibles()!=null){
          asignarAtributo("LABELC","lbldtUnidadesDisponibles","valor",deta.getUnidadesDisponibles().toString());
          asignarAtributo("VAR","uniDis","valor",deta.getUnidadesDisponibles().toString());
        }
        else {
          asignarAtributo("LABELC","lbldtUnidadesDisponibles","valor","");
        }
        
        if (deta.getValorCondicion()!=null){
          asignarAtributo("LABELC","lbldtValorCondicion","valor",deta.getValorCondicion());
          asignarAtributo("VAR","valCondi","valor",deta.getValorCondicion());
        }
        else {
          asignarAtributo("LABELC","lbldtValorCondicion","valor","");
        }
        
        if (deta.getUnidadesPromedio()!=null){
          asignarAtributo("CTEXTO","txtUnidadesPromedio","valor",deta.getUnidadesPromedio().toString());
          asignarAtributo("VAR","uniPro","valor",deta.getUnidadesPromedio().toString());
           // Agregado por ssantana, 15/6/2005
           // Inc. BELC300018074 - Si el campo Unidades Promedio tiene valor, entonces 
           // se debe deshabilitar Unidades Totales. 
           this.asignarAtributo("VAR", "campoDeshabilitar", "valor", "txtUnidadesTotales");
        } else {
          asignarAtributo("CTEXTO","txtUnidadesPromedio","valor","");
        }
        
        if (deta.getUnidadesTotales()!=null){
           asignarAtributo("CTEXTO","txtUnidadesTotales","valor",deta.getUnidadesTotales().toString());
           asignarAtributo("VAR","uniTot","valor",deta.getUnidadesTotales().toString());
           // Agregado por ssantana, 15/6/2005
           // Inc. BELC300018074 - Si el campo Unidades Promedio tiene valor, entonces 
           // se debe deshabilitar Unidades Totales. 
           this.asignarAtributo("VAR", "campoDeshabilitar", "valor", "txtUnidadesPromedio");
        } else {
          asignarAtributo("CTEXTO","txtUnidadesTotales","valor","");
        }    
        
      }
      else {
        traza("********* recal es true");
        traza("********* asignando los valores de la pagina a la modal");
        
        asignarAtributo("LABELC","lbldtNumClientesEstimados","valor",recalClientesEsti);                
        asignarAtributo("LABELC","lbldtCodVenta","valor",recalCodVenta);        
        asignarAtributo("LABELC","lbldtCondicion","valor",recalCondicion);
        asignarAtributo("LABELC","lbldtCodProducto","valor",recalCodProducto);
        asignarAtributo("LABELC","lbldtDescripcionProducto","valor",recalDesProducto);
        asignarAtributo("LABELC","lbldtUnidadesDisponibles","valor",recalUnidadesDis);        
        asignarAtributo("LABELC","lbldtValorCondicion","valor",recalValCondicion);
        
        asignarAtributo("CTEXTO","txtUnidadesPromedio","valor",recalUnidadesPro);               
        asignarAtributo("CTEXTO","txtUnidadesTotales","valor",recalUnidadesTot);

        asignarAtributo("VAR","codVenta","valor", recalCodVenta);
        asignarAtributo("VAR","cliEsti","valor",recalClientesEsti);
        asignarAtributo("VAR","uniPro","valor",recalUnidadesPro);
        asignarAtributo("VAR","uniTot","valor",recalUnidadesTot);
        asignarAtributo("VAR","uniDis","valor",recalUnidadesDis);
        asignarAtributo("VAR","condi","valor", recalCondicion);
        asignarAtributo("VAR","valCondi","valor",recalValCondicion);
      }      
			
		} catch (Exception ex ){
			traza (ex);
			this.lanzarPaginaError(ex);
		}	
	}

	public void recalcular() throws Exception{
		/*-> Crear objeto DTODetalleCampañaEstimadosBP y mapear los datos de la pantalla 
      -> Crear idBusiness = "MAVRecalcularDetalleCampañaEstimadosBP" 
      -> Asignar conector ConectorRecalcularDetalleCampañaEstimadosBP con idBusiness y dto creados 
      -> Obtener DTODetalleCampañaEstimadosBP y mapearlo en la pantalla "contenido_campana_recalcular" */

    traza("************** Entre a recalcular");

    pagina("salidaGenerica");

    traza("************** idsSubtiposCliente " + idsSubtiposCliente);
    traza("************** idTipoClasificacion " + idTipoClasificacion);
    traza("************** idClasificacion " + idClasificacion);
    traza("************** valUnidadesPromedio " + valUnidadesPromedio);
    traza("************** valUnidadesTotales " + valUnidadesTotales);
    traza("************** oidDetalleMAV " + oidDetalleMAV);
    traza("************** oidIdioma " + idioma);		
    traza("************** oidPais " + pais);

    ArrayList idsSubtipos = new ArrayList();    
    StringTokenizer st1 = new StringTokenizer(idsSubtiposCliente,",");
    int cant = st1.countTokens();
    traza("************ cantidad de ids subtipos cliente " + cant);
        
    while(st1.hasMoreTokens()) {
      String elementoI = st1.nextToken();
      Long elem = new Long(elementoI);
      idsSubtipos.add(elem);
     }

    traza("************** idsSubtipos " + idsSubtipos);
    
    MareBusinessID id = new MareBusinessID("MAVRecalcularDetalleCampaniaEstimadosBP");

    DTODetalleCampaniaEstimadosBP dto = new DTODetalleCampaniaEstimadosBP();
  
    dto.setOidIdioma(idioma);
    dto.setOidPais(pais);
    dto.setOidDetalleMAV(new Long(oidDetalleMAV));
    dto.setCodigoVenta(codVenta);
    dto.setIpCliente(ipcliente);    
    
    // modif. splatas - DBLG700000146 - 23/10/2006
    if (idClasificacion != null  &&  !idClasificacion.equals("")) {
        dto.setClasificacion(new Long(idClasificacion));
    }
    
    if (idsSubtipos != null  &&  idsSubtipos.size() > 0){
        dto.setSubtiposCliente(idsSubtipos);
    }
    
    if (idTipoClasificacion != null  &&  !idTipoClasificacion.equals("")) {
        dto.setTipoClasificacion(new Long(idTipoClasificacion));    
    }
    // fin modif. splatas - DBLG700000146 - 23/10/2006
    
    
    // Modificado por ssantana, 16/6/2005
    if ( valUnidadesTotales != null && !valUnidadesTotales.equals("") )
      dto.setUnidadesTotales( new Long(valUnidadesTotales) );
    
    if ( valUnidadesPromedio != null && !valUnidadesPromedio.equals("") )
      dto.setUnidadesPromedio(new Long(valUnidadesPromedio));
			
		Vector param = new Vector();
		param.add(dto);
		param.add(id);

		traza("******************** Antes de conectar");
		DruidaConector con = conectar("ConectorRecalcularDetalleCampaniaEstimadosBP",param);
    traza("******************** Despues de conectar");

    DTODetalleCampaniaEstimadosBP dtoDetalle = (DTODetalleCampaniaEstimadosBP) con.objeto("DTODetalleCampaniaEstimadosBP");
    traza("******************** Obteniendo valores");	

    String valorCondicion = dtoDetalle.getValorCondicion();
    String condicion = dtoDetalle.getCondicion();
    Long unidadesTotales = dtoDetalle.getUnidadesTotales();
    Long unidadesDisponibles = dtoDetalle.getUnidadesDisponibles();
    Long unidadesPromedio = dtoDetalle.getUnidadesPromedio();
    Long clientesEstimados = dtoDetalle.getNumeroClientesEstimados();
    Long clasificacion = dtoDetalle.getClasificacion();
    Long tipoClasificacion = dtoDetalle.getTipoClasificacion();
    ArrayList subtipos = dtoDetalle.getSubtiposCliente();
    String descripcionProducto = dtoDetalle.getDescripcionProducto();
    String codigoVenta = dtoDetalle.getCodigoVenta();
    String codigoSAP = dtoDetalle.getCodigoSAP();
    Long oidDetalleMAV = dtoDetalle.getOidDetalleMAV();

    traza("******************** valorCondicion " + valorCondicion);
    traza("******************** condicion " + condicion);
    traza("******************** unidadesTotales " + unidadesTotales);
    traza("******************** unidadesDisponibles " +  unidadesDisponibles);
    traza("******************** unidadesPromedio " + unidadesPromedio);
    traza("******************** clientesEstimados " + clientesEstimados);
    traza("******************** clasificacion " + clasificacion);
    traza("******************** tipoClasificacion " + tipoClasificacion);
    traza("******************** subtipos " + subtipos);
    traza("******************** descripcionProducto " + descripcionProducto);
    traza("******************** codigoVenta " +  codigoVenta);
    traza("******************** codigoSAP " + codigoSAP);
    traza("******************** oidDetalleMAV " + oidDetalleMAV);

    String idsSub = new String();

    for(int i=0; i<subtipos.size(); i++) {
      Long val = (Long)subtipos.get(i);
      if(i==0) {
        idsSub = val.toString();  
      }
      else {
        idsSub = idsSub + "/" + val.toString();
      }      
    }    

    traza("******************** idsSub " + idsSub);
    
    String nuevosValores = new String();

    nuevosValores = nuevosValores + valorCondicion + ",";
    nuevosValores = nuevosValores + condicion + ",";
    nuevosValores = nuevosValores + unidadesTotales + ",";
    nuevosValores = nuevosValores + unidadesDisponibles + ",";
    nuevosValores = nuevosValores + unidadesPromedio + ",";
    nuevosValores = nuevosValores + clientesEstimados + ",";
    nuevosValores = nuevosValores + clasificacion + ",";
    nuevosValores = nuevosValores + tipoClasificacion + ",";
    nuevosValores = nuevosValores + idsSub + ",";
    nuevosValores = nuevosValores + descripcionProducto + ",";
    nuevosValores = nuevosValores + codigoVenta + ",";
    nuevosValores = nuevosValores + codigoSAP + ",";
    nuevosValores = nuevosValores + oidDetalleMAV;    

    traza("******************** nuevosValores " + nuevosValores);

    asignarAtributo("VAR", "cerrarVentana", "valor", "false");
    asignarAtributo("VAR", "ejecutar", "valor", "despuesRecalcular('" + nuevosValores  + "')");
	}
	
	public void actualizar() throws Exception{
		/*-> actualiza los campos procedencia, subtipo_cliente, tipo_clasificacion, clasificacion,
		     unidades_promedio, unidades_totales */

    traza("************** Entre a actualizar");

    pagina("salidaGenerica");

    traza("************** idsSubtiposCliente " + idsSubtiposCliente);
    traza("************** idTipoClasificacion " + idTipoClasificacion);
    traza("************** idClasificacion " + idClasificacion);
    traza("************** valUnidadesPromedio " + valUnidadesPromedio);
    traza("************** valUnidadesTotales " + valUnidadesTotales);
    traza("************** oidDetalleMAV " + oidDetalleMAV);
    traza("************** oidIdioma " + idioma);		
    traza("************** oidPais " + pais);

    ArrayList idsSubtipos = new ArrayList();    
    StringTokenizer st1 = new StringTokenizer(idsSubtiposCliente,",");
    int cant = st1.countTokens();
    traza("************ cantidad de ids subtipos cliente " + cant);
        
    while(st1.hasMoreTokens()) {
      String elementoI = st1.nextToken();
      Long elem = new Long(elementoI);
      idsSubtipos.add(elem);
     }

    traza("************** idsSubtipos " + idsSubtipos);
    
    MareBusinessID id = new MareBusinessID("MAVActualizarDetalleCampaniaEstimadosBP");

    DTODetalleCampaniaEstimadosBP dto = new DTODetalleCampaniaEstimadosBP();
  
    dto.setOidIdioma(idioma);
    dto.setOidPais(pais);
    dto.setOidDetalleMAV(new Long(oidDetalleMAV));
    dto.setCodigoVenta(codVenta);
    dto.setIpCliente(ipcliente);    
    
    if (idClasificacion != null  &&  !idClasificacion.equals("")) {
        dto.setClasificacion(new Long(idClasificacion));
    }
    
    if (idsSubtipos != null  &&  idsSubtipos.size() > 0){
        dto.setSubtiposCliente(idsSubtipos);
    }
    
    if (idTipoClasificacion != null  &&  !idTipoClasificacion.equals("")) {
        dto.setTipoClasificacion(new Long(idTipoClasificacion));    
    }
    
    if ( valUnidadesTotales != null && !valUnidadesTotales.equals("") )
      dto.setUnidadesTotales( new Long(valUnidadesTotales) );
    
    if ( valUnidadesPromedio != null && !valUnidadesPromedio.equals("") )
      dto.setUnidadesPromedio(new Long(valUnidadesPromedio));
			
		Vector param = new Vector();
		param.add(dto);
		param.add(id);

		traza("******************** Antes de conectar");
		DruidaConector con = conectar("ConectorActualizarDetalleCampaniaEstimadosBP",param);
    traza("******************** Despues de conectar");

    asignarAtributo("VAR", "cerrarVentana", "valor", "false");
    asignarAtributo("VAR", "ejecutar", "valor", "despuesAceptar()");
	}
	
}
