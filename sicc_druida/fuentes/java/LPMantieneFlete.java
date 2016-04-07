
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewClass;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.dtos.ped.DTODetalleFlete;
import es.indra.sicc.dtos.ped.DTOFlete;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;

import java.io.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.lang.reflect.InvocationTargetException;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import es.indra.sicc.dtos.ped.DTORangoFlete;
import java.util.StringTokenizer;
import java.lang.reflect.Method;
import es.indra.mare.common.exception.MareException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LPMantieneFlete extends LPSICCBase {

  private String mAccion = null;
  private String oidLst = null;
  private String mPais = null;
  private String mDescPais = null;
  private String mIdioma = null;
  private Long oidI18N;
  private String casoDeUso = null;
  private String formatoDef = null;

  private DTORangoFlete dtoRangoFlete;
  
public LPMantieneFlete() {	
	super();	
}

public void inicio() throws Exception {	
}
  
public void ejecucion() throws Exception {
    setTrazaFichero();

	mAccion     = conectorParametroLimpia("accion", "", true);
	mPais 		= UtilidadesSession.getPais(this).toString();
    mDescPais	= UtilidadesSession.getDescripcionPais(this).toString();
    mIdioma 	= UtilidadesSession.getIdioma(this).toString();
	casoDeUso   =  conectorParametro("casoDeUso");

	traza("mPais>>> " + mPais);

	traza("mIdioma>>>>" + mIdioma);

	String separadorDecimal = UtilidadesSession.getSeparadorDecimales(this);
	String separadorMiles = ((separadorDecimal.equals("."))) ? "," : ".";

	formatoDef = (new Integer(this.FORMATO_DEFAULT)).toString();

	asignarAtributo("VAR", "hFormatoDef", "valor",formatoDef);

	traza("a ver tipo formato >>> " + (new Integer(this.FORMATO_DEFAULT)).toString());


	try {
		if (mAccion.equals("modificar")){
			casoDeUso = "modificar";
			muestraInsercion();	
			modifica();		
			anyadeHiddensI18N(true, "PED_FLETE", oidI18N, new Integer(1), "formulario", "txtDescripcion", false);
			getConfiguracionMenu("LPMantieneFlete", "muestraModificacion");	
			asignarAtributoPagina("cod", "0626");				
		}	
	
		if (mAccion.equals("muestraConsulta")){
			casoDeUso = "consultar";
			muestraConsultas();
			getConfiguracionMenu("LPMantieneFlete", "muestraConsulta");	
			asignarAtributoPagina("cod", "0627");
		} 
		
		if (mAccion.equals("muestraBorrado")){
			casoDeUso = "elimina";
			muestraConsultas();	
			getConfiguracionMenu("LPMantieneFlete", "muestraBorrado");	
			asignarAtributoPagina("cod", "0628");					
		}
		if (mAccion.equals("muestraModificacion")){
			casoDeUso = "modificar";
			muestraConsultas();		
			getConfiguracionMenu("LPMantieneFlete", "muestraModificacion");	
			asignarAtributoPagina("cod", "0626");						
		}
		if (mAccion.equals("muestraInsercion")){
			muestraInsercion();	
			anyadeHiddensI18N(true, "PED_FLETE", oidI18N, new Integer(1), "formulario", "txtDescripcion", false);
			getConfiguracionMenu("LPMantieneFlete", "");	
			asignarAtributoPagina("cod", "0625");
		}
		
		if (mAccion.equals("detalle")){
			modifica();
			anyadeHiddensI18N(true, "PED_FLETE", oidI18N, new Integer(1), "formulario", "txtDescripcion", true);
			getConfiguracionMenu("LPMantieneFlete", "detalle");	
			asignarAtributoPagina("cod", "0627");
		} 
		if (mAccion.equals("detalleFlete")){
			detalleFlete();
			getConfiguracionMenu("LPMantieneFlete", "rangosFlete");	
			asignarAtributoPagina("cod", "3436");
		} 

		if (mAccion.equals("guardar")){	
			guarda();				
		}

		asignarAtributo("VAR","hPais","valor",mPais);
		asignarAtributo("VAR","hIdioma","valor",mIdioma);		
		asignarAtributo("VAR","accion","valor",mAccion);
		asignarAtributo("VAR", "hSepMiles", "valor", separadorMiles);
		asignarAtributo("VAR", "hSepDec", "valor", separadorDecimal);
 }
    catch ( Exception e )  {
      traza("Exception en LPMantieneFlete");
      e.printStackTrace(); 
	  traza("e " + e);
      lanzarPaginaError(e);
    }
}

private void modifica() throws Exception {
	traza("mAccion>>>>>" + mAccion);
 
	if(mAccion.equals("detalle")){
		pagina("contenido_flete_insertar");
		casoDeUso ="consultar";
		asignarAtributo("VAR","accion","valor",mAccion);
		
	}	
	else{
		ComposerViewElementList cvInserccion = crearParametrosEntradaInserccion();
		ConectorComposerView conector = new ConectorComposerView(cvInserccion, this.getRequest());

		conector.ejecucion();
		
		DruidaConector resultados = conector.getConector();

		asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales"); 
		asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas"); 
		asignar("COMBO", "cbTipoCliente", resultados, "MAEObtenerTipos"); 
		traza("antes de cbTipoDespacho");
	
		asignar("COMBO", "cbTipoDespacho", resultados, "PEDconsultaTiposDespacho");

	}
	traza("en el de modificar!!!!!");
	if (!casoDeUso.equals("")){
			asignarAtributo("VAR", "casoDeUso", "valor", casoDeUso);
	}
	traza("caso de uso>>> " + casoDeUso); 	

	 String marcaD = conectorParametro("marcaDescr");	 
	 String canalD = conectorParametro("canalDescr");
	 String zonaD = conectorParametro("zonaDescr");
	 String ubigeoOID = conectorParametro("zonaDescr");
	 String despachoD = conectorParametro("despachoDescr");
	 String tipoCliente = conectorParametro("tipoClienteDescr");
	 String subTipoCliente = conectorParametro("subTipoClienteDescr");
	 String tipoClasi = conectorParametro("tipoClasiDescr");
	 String clasi = conectorParametro("clasiDescr");

	 traza("por aca!!!!!");
	 String montoF = conectorParametroNumero("txtMontoFijo",this.FORMATO_DEFAULT);
	 String fleteMi = conectorParametroNumero("txtFleteMin",this.FORMATO_DEFAULT);
	 String fleteMa = conectorParametroNumero("txtFleteMax",this.FORMATO_DEFAULT); 
	 String tasa = conectorParametroNumero("txtTasa",this.FORMATO_DEFAULT);
	 String contraEntrega = conectorParametroNumero("txtContraEntrega",this.FORMATO_DEFAULT);

	 traza("1");

	 DTOOID dto = new DTOOID();
	 String seleccion = conectorParametroLimpia("seleccion", "", true);

	 traza("seleccion>>>>>" + seleccion);

	 dto.setOid(new Long(seleccion));
	 dto.setOidIdioma(new Long(mIdioma));
	 dto.setOidPais(new Long(mPais));

	 traza("dto**** " + dto);

	 MareBusinessID businessID = new MareBusinessID("PEDdetallesFlete");

	 Vector parametros = new Vector();
     parametros.add(dto);
     parametros.add(businessID);

	 traza("parametros>>>> " + parametros);
	 traza("2");
     DruidaConector con = conectar("ConectorDetallesFlete", parametros);
	 traza("3");

	 DTOFlete dtoDatos = (DTOFlete) con.objeto("DTOFlete");
	 Long oid = dtoDatos.getOid();
	 traza("4");

	 serializarRangosFlete(dtoDatos);

	 BigDecimal txtMontoFi = dtoDatos.getMontoFijo();
	 BigDecimal txtTas =  dtoDatos.getTasa();
	 BigDecimal txtFMin = dtoDatos.getFleteMin();
	 BigDecimal txtMax = dtoDatos.getFleteMax();
	 BigDecimal txtContraE = dtoDatos.getContraEntrega();
	 

	 traza("lo que me trae el dtoDatos>>>>>" + dtoDatos);
   
     if(dtoDatos.getOidSubtipoCliente()!=null){
		asignarAtributo("VAR", "SubTipoCliente", "valor", subTipoCliente);
		asignarAtributo("VAR", "subModi", "valor", dtoDatos.getOidSubtipoCliente().toString());
		asignarAtributo("VAR", "OIDSubTipoCliente", "valor", dtoDatos.getOidSubtipoCliente().toString());
		traza("dtoDatos.getOidSubtipoCliente().toString()>>>>> " + dtoDatos.getOidSubtipoCliente().toString());
	}

	if(dtoDatos.getOidTipoClasificacion()!=null){
		asignarAtributo("VAR", "OIDTipoClasificacion", "valor", dtoDatos.getOidTipoClasificacion().toString());
		asignarAtributo("VAR", "tipClas", "valor", dtoDatos.getOidTipoClasificacion().toString());
		traza("dtoDatos.getOidTipoClasificacion().toString()++++" + dtoDatos.getOidTipoClasificacion().toString());
		asignarAtributo("VAR", "TipoClasificacion", "valor", tipoClasi);
	}

	if(dtoDatos.getOidClasificacion()!=null){
		asignarAtributo("VAR", "OIDClasificacion", "valor", dtoDatos.getOidClasificacion().toString());
		asignarAtributo("VAR", "clsi", "valor", dtoDatos.getOidClasificacion().toString());
		traza("dtoDatos.getOidClasificacion().toString()>>>> " + dtoDatos.getOidClasificacion().toString());
		asignarAtributo("VAR", "Clasificacion", "valor", clasi);
	}		
 
	if( dtoDatos.getAttriTraducible() != null ){

			Iterator it = dtoDatos.getAttriTraducible().iterator();

			DTOI18nSICC dtoTraducible = null;
			while(it.hasNext()){
				dtoTraducible = (DTOI18nSICC)it.next();

			    if( dtoTraducible.getOidIdioma().equals(UtilidadesSession.getIdioma(this)) ){

					if(dtoTraducible.getValorI18n().equals("")){
					}else{
							asignar("CTEXTO", "txtDescripcion", dtoTraducible.getValorI18n());
							asignar("VAR", "descrip", dtoTraducible.getValorI18n());
							oidI18N = new Long(dtoDatos.getOid().longValue());
							break;
					}	
				}
			}
		}
 
	
	if (dtoDatos.getOidMarca()!=null){
		asignarAtributo("VAR", "marca2", "valor",marcaD);
		asignarAtributo("VAR", "OIDMarca", "valor",  dtoDatos.getOidMarca().toString());		
		traza("dtoDatos.getOidMarca().toString()" + dtoDatos.getOidMarca().toString());		
	}
	
	if (dtoDatos.getOidCanal()!=null){
		asignarAtributo("VAR", "OIDCanal", "valor", dtoDatos.getOidCanal().toString());
		asignarAtributo("VAR", "canal2", "valor", canalD);
		traza("dtoDatos.getOidCanal().toString()>>> " + dtoDatos.getOidCanal().toString());
	}

	if (dtoDatos.getZona()!=null){
		asignarAtributo("VAR", "OIDZona", "valor", dtoDatos.getZona().toString());
		traza("dtoDatos.getZona().toString()++++" + dtoDatos.getZona().toString());
		asignarAtributo("VAR", "zona", "valor",zonaD);
	}
	
	if(dtoDatos.getUbigeo()!=null){
			 asignarAtributo("CTEXTO", "txtUbigeo", "valor",ubigeoOID );
			 traza("ubigeoOID>>> " + ubigeoOID);
			 asignarAtributo("VAR", "ubigeo", "valor", dtoDatos.getUbigeo().toString());
			 traza("dtoDatos.getUbigeo().toString()>>>" + dtoDatos.getUbigeo().toString());
	}

	if(dtoDatos.getOidUbigeo()!=null){
			 asignarAtributo("VAR", "OIDUbige", "valor", dtoDatos.getOidUbigeo().toString());
			 asignarAtributo("VAR", "OIDUbigeo", "valor", ubigeoOID);
			 traza("ubigeoOID>>> " + ubigeoOID);
			 traza("dtoDatos.getOidUbigeo().toString() **********" + dtoDatos.getOidUbigeo().toString());
	}

	if(dtoDatos.getOidTipoDespacho()!=null){
		asignarAtributo("VAR", "TipoDespacho", "valor",despachoD);
	    asignarAtributo("VAR", "OIDDespacho", "valor", dtoDatos.getOidTipoDespacho().toString());
	}

	if(dtoDatos.getDescripcion()!=null){
		asignarAtributo("CTEXTO", "txtDescripcion", "valor", dtoDatos.getDescripcion().toString());
		asignarAtributo("VAR", "descrip", "valor",dtoDatos.getDescripcion().toString());
	}	

	if (dtoDatos.getMontoFijo()!=null){
		asignarAtributo("CTEXTO", "txtMontoFijo", "valor", UtilidadesBelcorp.formateaNumeroSICC(txtMontoFi.toString(), this.FORMATO_DEFAULT, this));
		asignarAtributo("VAR", "montoF", "valor", UtilidadesBelcorp.formateaNumeroSICC(txtMontoFi.toString(), this.FORMATO_DEFAULT, this));
	}
		
	
	if(dtoDatos.getTasa()!=null){	
		asignarAtributo("CTEXTO", "txtTasa", "valor",UtilidadesBelcorp.formateaNumeroSICC(txtTas.toString(), this.FORMATO_DEFAULT, this));
		asignarAtributo("VAR", "tas", "valor", UtilidadesBelcorp.formateaNumeroSICC(txtTas.toString(), this.FORMATO_DEFAULT, this));	 
	}
	
	if(dtoDatos.getFleteMin()!=null){
		asignarAtributo("CTEXTO", "txtFleteMin", "valor", UtilidadesBelcorp.formateaNumeroSICC(txtFMin.toString(), this.FORMATO_DEFAULT, this));
		asignarAtributo("VAR", "fmin", "valor", UtilidadesBelcorp.formateaNumeroSICC(txtFMin.toString(), this.FORMATO_DEFAULT, this));
	}

	if(dtoDatos.getFleteMax()!=null){
		asignarAtributo("CTEXTO", "txtFleteMax", "valor",UtilidadesBelcorp.formateaNumeroSICC(txtMax.toString(), this.FORMATO_DEFAULT, this));
		asignarAtributo("VAR", "fmax", "valor", UtilidadesBelcorp.formateaNumeroSICC(txtMax.toString(), this.FORMATO_DEFAULT, this));
	}  

	if(dtoDatos.getContraEntrega()!=null){
		asignarAtributo("CTEXTO", "txtContraEntrega", "valor",UtilidadesBelcorp.formateaNumeroSICC(txtContraE .toString(), this.FORMATO_DEFAULT, this));
		asignarAtributo("VAR", "contraE", "valor", UtilidadesBelcorp.formateaNumeroSICC(txtContraE .toString(), this.FORMATO_DEFAULT, this));
	} 
	
	if(dtoDatos.getOidTipoCliente()!=null){
		asignarAtributo("VAR", "OIDTipoCliente", "valor", dtoDatos.getOidTipoCliente().toString());
		asignarAtributo("VAR", "TipoCliente", "valor", tipoCliente);	
	} 

	if (oid.toString() != null){
			asignarAtributo("VAR", "varOid", "valor", oid.toString());	 	
	}


	/*if(dtoDatos.getDetalleFlete()!=null){
	//FIX ME!
	}*/

}
	
 
private void muestraInsercion() throws Exception {

	traza("esta en el de insertar!!!!");	
	pagina("contenido_flete_insertar");
	this.getFormatosValidaciones();

	if ((casoDeUso.equals("insertar"))|| (mAccion.equals("muestraInsercion"))){
			asignar("VAR", "marca", UtilidadesSession.getMarcaPorDefecto(this).toString());
			asignar("VAR", "canal", UtilidadesSession.getCanalPorDefecto(this).toString());	
			asignar("VAR", "zona", UtilidadesSession.getZonaPorDefecto(this).toString());
	}
	
	ComposerViewElementList cvInserccion = crearParametrosEntradaInserccion();
	ConectorComposerView conector = new ConectorComposerView(cvInserccion, this.getRequest());

	conector.ejecucion();
		
	DruidaConector resultados = conector.getConector();

	asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales"); 
	asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas"); 
	asignar("COMBO", "cbTipoCliente", resultados, "MAEObtenerTipos"); 
	asignar("COMBO", "cbTipoDespacho", resultados, "PEDconsultaTiposDespacho");
	
	if (esZona()){
			traza("true");
			asignarAtributo("VAR", "hVisibleZona", "valor", "S");
			asignarAtributo("VAR", "hTxtUbigeo", "valor", "N");
			asignarAtributo("COMBO", "cbZona", "req", "S");
			asignarAtributoElementoValidacion("cbZona","required", "true");
		}else{
			traza("false");
			asignarAtributo("VAR", "hVisibleZona", "valor", "N");	
			asignarAtributo("VAR", "hTxtUbigeo", "valor", "S");
			asignarAtributo("CTEXTO", "txtUbigeo", "req", "S");
			asignarAtributoElementoValidacion("txtUbigeo","required", "true");
	}
	if (!casoDeUso.equals("")){
			traza("caso de uso *******>>> " + casoDeUso);
			asignarAtributo("VAR", "casoDeUso", "valor", casoDeUso);
			if (casoDeUso.equals("modificar")){			
				asignarAtributoElementoValidacion("cbZona","required", "false");
				asignarAtributoElementoValidacion("txtUbigeo","required", "false");
				asignarAtributo("COMBO", "cbZona", "req", "N");
				asignarAtributo("CTEXTO", "txtUbigeo", "req", "N");
			}
	}

	traza("caso de uso>>> " + casoDeUso);
}

private ComposerViewElementList crearParametrosEntradaInserccion() throws Exception{
	ComposerViewElementList lista = new ComposerViewElementList();
	
    ComposerViewElement cmb1 = new ComposerViewElement();
	cmb1.setIDBusiness("SEGConsultaCanales"); 

	DTOBelcorp dto1 = new DTOBelcorp();
	dto1.setOidIdioma(new Long(mIdioma));
	dto1.setOidPais(new Long(mPais));

	cmb1.setDTOE(dto1);
	lista.addViewElement(cmb1);

	ComposerViewElement cmb2 = new ComposerViewElement();
	cmb2.setIDBusiness("SEGConsultaMarcas"); 	
	cmb2.setDTOE(dto1);
	lista.addViewElement(cmb2);

	ComposerViewElement cmb3 = new ComposerViewElement();
	cmb3.setIDBusiness("MAEObtenerTipos"); 	
	cmb3.setDTOE(dto1);
	lista.addViewElement(cmb3);


	ComposerViewElement cmb4 = new ComposerViewElement();
	cmb4.setIDBusiness("PEDconsultaTiposDespacho"); 	
	cmb4.setDTOE(dto1);

	lista.addViewElement(cmb4);

	return lista; 
}	

private void muestraConsultas() throws Exception {

		pagina("contenido_flete_buscar");

		asignar("VAR", "marca", UtilidadesSession.getMarcaPorDefecto(this).toString());
		asignar("VAR", "canal", UtilidadesSession.getCanalPorDefecto(this).toString());
		asignar("VAR", "zona", UtilidadesSession.getZonaPorDefecto(this).toString());

		DTOBelcorp dto = new DTOBelcorp();
		dto.setOidPais(new Long(mPais));
		dto.setOidIdioma(new Long(mIdioma));

		ComposerViewElementList cv = crearParametrosEntrada();
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		conector.ejecucion();
		
		DruidaConector resultados = conector.getConector();
					
		asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales"); 
		asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas"); 
		asignar("COMBO", "cbTipoDespacho", resultados, "PEDconsultaTiposDespacho"); 

		if (esZona()){
			traza("true");
			asignarAtributo("VAR", "hVisibleZona", "valor", "S");
			asignarAtributo("VAR", "hTxtUbigeo", "valor", "N");		
		}else{
			traza("false");
			asignarAtributo("VAR", "hVisibleZona", "valor", "N");	
			asignarAtributo("VAR", "hTxtUbigeo", "valor", "S");		
		}
		
		if (!casoDeUso.equals("")){
			traza("caso de uso *******>>> " + casoDeUso);
			asignarAtributo("VAR", "casoDeUso", "valor", casoDeUso);
			if (casoDeUso.equals("modificar")){			
				asignarAtributoElementoValidacion("cbZona","required", "false");
				asignarAtributo("COMBO", "cbZona", "req", "N");
				asignarAtributo("CTEXTO", "txtUbigeo", "req", "N");
				asignarAtributoElementoValidacion("txtUbigeo","required", "false");
			}
		}		
		traza("caso de uso>>> " + casoDeUso);		
}

private void guarda() throws Exception {
	try{

	 pagina("salidaGenerica");
	 traza("String casoDeUso  " + casoDeUso);
	  
	 DTOFlete dtoF = new DTOFlete();

	 dtoF = construyeFletes();
	 dtoF.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
	 dtoF.setPrograma(UtilidadesSession.getFuncion(this));
	 dtoF.setOidPais(UtilidadesSession.getPais(this));
	 dtoF.setOidIdioma(UtilidadesSession.getIdioma(this));
	 dtoF = deserializarRangosFlete(dtoF);

	 MareBusinessID businessID = new MareBusinessID("PEDguardaFlete");

	 Vector parametros = new Vector();
	 parametros.add(dtoF);
	 parametros.add(businessID);

	 traza("******************* Antes de conectar");
     DruidaConector con = conectar("ConectorGuardarFlete", parametros);
	 traza("******************* DEspues de conectar");

	 if(casoDeUso.equals("modificar") ){
				asignarAtributo("VAR", "ejecutar", "valor", "cerrarVentana()");
	 } else {
				asignarAtributo("VAR", "ejecutar", "valor", "borrarTodo()");
	}

	}catch(Exception e){
			   asignarAtributo("VAR", "ejecutarError", "valor", "errorAlGuardar()");
			   throw e;
		}
}		   

private DTOFlete construyeFletes() throws Exception {

	 DTOFlete dtoF = new DTOFlete();
	 String oid = conectorParametroLimpia("varOid","",true);
	 String marcaOID = conectorParametro("OIDMarca");
	 String canalOID = conectorParametro("OIDCanal");
	 String zonaOID = conectorParametro("OIDZona");
	 String ubigeoOID = conectorParametro("OIDUbigeo");
	 String despachoOID = conectorParametro("OIDDespacho");
	 String tipoClienteOID = conectorParametro("OIDTipoCliente");
	 String subTipoClienteOID = conectorParametro("OIDSubTipoCliente");
	 String tipoClasificacionOID = conectorParametro("OIDTipoClasificacion");
	 String clasificacionOID = conectorParametro("OIDClasificacion");
	 String ub = conectorParametro("OIDUbige");
	 String desc = conectorParametro("descrip");

	 Vector descripciones = this.recuperaTraduccionesI18N(new Integer(1));
	 dtoF.setAttriTraducible(descripciones);
	/* String monto = conectorParametro("montoF");
	 String Tasa = conectorParametro("tas");
	 String FleteMin = conectorParametro("fmin");
	 String FleteMax = conectorParametro("fmax");
	 String contraEnt = conectorParametro("contraE");*/

	 String monto = conectorParametroNumero("txtMontoFijo",this.FORMATO_DEFAULT);
	 String Tasa = conectorParametroNumero("txtTasa", this.FORMATO_DEFAULT);
	 String FleteMin = conectorParametroNumero("txtFleteMin", this.FORMATO_DEFAULT);
	 String FleteMax = conectorParametroNumero("txtFleteMax", this.FORMATO_DEFAULT);
	 String contraEnt = conectorParametroNumero("txtContraEntrega", this.FORMATO_DEFAULT);
	 
	 if (!ub.equals("")){
			String ubi=ubigeoOID;
			traza("ubi>>>>++++++++++++++++ " +ubi);
			 dtoF.setUbigeo(ubi);
			 dtoF.setOidUbigeo(new Long(ub));
	 }else{
			dtoF.setUbigeo("");
			dtoF.setOidUbigeo(null);
	 }	

	 if (!desc.equals("")){
			 dtoF.setDescripcion(desc);
	 }
		
	if (!monto.equals("")){
			 dtoF.setMontoFijo(new BigDecimal(monto));
	}
	
	if (!Tasa.equals("")){
			 dtoF.setTasa(new BigDecimal(Tasa));
	}
 
	if (!FleteMin.equals("")){
			 dtoF.setFleteMin(new BigDecimal(FleteMin));
	}
	 
	if (!FleteMax.equals("")){
			 dtoF.setFleteMax(new BigDecimal(FleteMax));
	}

	if (!contraEnt.equals("")){
			 dtoF.setContraEntrega(new BigDecimal(contraEnt));
	}	 

	if (!zonaOID.equals("")){
			 dtoF.setZona(new Long(zonaOID));
	}	

	if (!canalOID.equals("")){
			 dtoF.setOidCanal(new Long(canalOID));
	}

	if (!marcaOID.equals("")){
			 dtoF.setOidMarca(new Long(marcaOID));
	}

	if (!despachoOID.equals("")){
			 dtoF.setOidTipoDespacho(new Long(despachoOID));
	}	
	  
	if (!tipoClienteOID.equals("")){
			traza("contenido de tipoClienteOID>>>>" +tipoClienteOID);
			 dtoF.setOidTipoCliente(new Long(tipoClienteOID));
	}

	if (!subTipoClienteOID.equals("")){
			 dtoF.setOidSubtipoCliente(new Long(subTipoClienteOID));
	}	

	if (!tipoClasificacionOID.equals("")){
			 dtoF.setOidTipoClasificacion(new Long(tipoClasificacionOID));
	}	
	
	if (!clasificacionOID.equals("")){
			 dtoF.setOidClasificacion(new Long(clasificacionOID));
	}

	String tipoCliente1 = conectorParametro("cbTipoCliente");

	if (tipoCliente1.equals("")){
		 dtoF.setOidTipoCliente(null);
	}else{
			 dtoF.setOidTipoCliente(new Long(tipoCliente1));
	}	

	String Subtipo1 = conectorParametro("cbSubTipoCliente");
	if (!Subtipo1.equals("")){
				dtoF.setOidSubtipoCliente(new Long(Subtipo1));
	}

	String Tipo1 = conectorParametro("cbTipoClasificacion");
	if (!Tipo1.equals("")){
		dtoF.setOidTipoClasificacion(new Long(Tipo1));
	}	

	String Clasi1 = conectorParametro("cbClasificacion");
	if (!Clasi1.equals("")){
		dtoF.setOidClasificacion(new Long(Clasi1));
	}

	traza("//////////////////////////////////////////////////");

	if (marcaOID.equals("")){
	 
			 String marca = conectorParametro("cbMarca");
			 String ub1 = conectorParametro("OIDUbige");
			 String canal = conectorParametro("cbCanal");
			 String zona = conectorParametro("cbZona");
			 
			 if (zona.equals("0") || zona.equals("") || zona.equals("|")){
					dtoF.setZona(null);
			 }else{
					 dtoF.setZona(new Long(zona));
			 }			
			 String ubigeo = conectorParametro("OIDUbigeo");
			 traza("ubigeo>>>> " + ubigeo);

			 if(ubigeo.equals("")){
				dtoF.setUbigeo("");
				dtoF.setOidUbigeo(null);
			 }else{
					 dtoF.setUbigeo(ubigeo);
					 dtoF.setOidUbigeo(null);
			 }
	 	
			 String tipoDespacho = conectorParametro("cbTipoDespacho");
			 String tipoCliente = conectorParametro("cbTipoCliente");

			  if (tipoCliente.equals("")){
					dtoF.setOidTipoCliente(null);
			  }else{
						 dtoF.setOidTipoCliente(new Long(tipoCliente));
			  }
			
			 Vector descripcion = recuperaTraduccionesI18N(new Integer(1));

			 String montoFijo = conectorParametroNumero("txtMontoFijo",this.FORMATO_DEFAULT);
			 String tasa = conectorParametroNumero("txtTasa", this.FORMATO_DEFAULT);
			 String fleteMin = conectorParametroNumero("txtFleteMin", this.FORMATO_DEFAULT);
			 String fleteMax = conectorParametroNumero("txtFleteMax", this.FORMATO_DEFAULT);
			 String contraEntrega = conectorParametroNumero("txtContraEntrega", this.FORMATO_DEFAULT);
			
			// String montoFijo = conectorParametro("txtMontoFijo");

			 if (montoFijo.equals("")){
			 }else{
					 dtoF.setMontoFijo(new BigDecimal(montoFijo));
			  }
			
		//	 String tasa = conectorParametro("txtTasa");

			 if (tasa.equals("")){
			 }else{
					 dtoF.setTasa(new BigDecimal(tasa));
			 }
			
		//	 String fleteMin = conectorParametro("txtFleteMin");

			 if (fleteMin.equals("")){
			 }else{
					dtoF.setFleteMin(new BigDecimal(fleteMin));
			 }
			
		//	 String fleteMax = conectorParametro("txtFleteMax");

			 if (fleteMax.equals("")){
			 }else{
					dtoF.setFleteMax(new BigDecimal(fleteMax));
			 }
			
		//	 String contraEntrega = conectorParametro("txtContraEntrega");

			 if (contraEntrega.equals("")){
			 }else{
					dtoF.setContraEntrega(new BigDecimal(contraEntrega));
			 }

			 String Subtipo = conectorParametro("cbSubTipoCliente");
			 if (!Subtipo.equals("")){
				dtoF.setOidSubtipoCliente(new Long(Subtipo));
			 }

			 String Tipo = conectorParametro("cbTipoClasificacion");
			 if (!Tipo.equals("")){
				dtoF.setOidTipoClasificacion(new Long(Tipo));
			 }	

			 String Clasi = conectorParametro("cbClasificacion");
			 if (!Clasi.equals("")){
				dtoF.setOidClasificacion(new Long(Clasi));
			 }
	 
				
			 dtoF.setOidMarca(new Long(marca));
			 dtoF.setOidCanal(new Long(canal));
			 dtoF.setOidTipoDespacho(new Long(tipoDespacho));
			 dtoF.setAttriTraducible(descripcion);	

	} ///significa que entro por modificar --////// 
	
	 if(!oid.equals("")){
		dtoF.setOid(new Long(oid));
	 }
	
	 traza("contenido del dto de detalles>>>>>>> " + dtoF);	
	 return dtoF;
}

private ComposerViewElementList crearParametrosEntrada() throws Exception{
	ComposerViewElementList lista = new ComposerViewElementList();
	
    ComposerViewElement cmb1 = new ComposerViewElement();
	cmb1.setIDBusiness("SEGConsultaCanales");

	DTOBelcorp dto1 = new DTOBelcorp();
	dto1.setOidIdioma(new Long(mIdioma));
	dto1.setOidPais(new Long(mPais));

	cmb1.setDTOE(dto1);
	lista.addViewElement(cmb1);

	ComposerViewElement cmb2 = new ComposerViewElement();
	cmb2.setIDBusiness("SEGConsultaMarcas"); 	
	cmb2.setDTOE(dto1);
	lista.addViewElement(cmb2);


	ComposerViewElement cmb3 = new ComposerViewElement();
	cmb3.setIDBusiness("PEDconsultaTiposDespacho"); 	
	cmb3.setDTOE(dto1);
	lista.addViewElement(cmb3);
	
	return lista; 

}

private boolean esZona() throws Exception {

		DTOBelcorp dto = new DTOBelcorp();
		dto.setOidPais(new Long(mPais));
		dto.setOidIdioma(new Long(mIdioma));

		MareBusinessID businessID = new MareBusinessID("SEGObtenerIndicadorFleteZonaUbigeo");

		Vector parametros = new Vector();
		parametros.add(dto);
		parametros.add(businessID);
			
		DruidaConector con = conectar("ConectorBoolean", parametros);

		DTOBoolean dtoDatos = (DTOBoolean)con.objeto("DTOBoolean");

		boolean valor = dtoDatos.getValor();

		traza("valor" + valor);
		return valor;
}


private void detalleFlete() throws Exception {

	traza("LPMantieneFlete.detalleFlete():Entrada");
	pagina("contenido_flete_detalle");
	this.getFormatosValidaciones();


	traza("caso de uso: " + casoDeUso);
	traza("LPMantieneFlete.detalleFlete():Salida");
}

  private void serializarRangosFlete(DTOFlete flete) throws Exception {

		  traza("LPMantieneFlete.serializarRangosFlete():Entrada");

		  StringBuffer rangosSerializados = new StringBuffer();
		  Long oidFlete = null;

		  ArrayList rangosFlete = flete.getRangosFlete();

		  if (rangosFlete!=null&&!rangosFlete.isEmpty()) {
				for (int i=0;i<rangosFlete.size();i++) {
					  DTORangoFlete dtoRango = (DTORangoFlete)rangosFlete.get(i);
					  rangosSerializados.append("oidRangoFlete¿"+dtoRango.getOidRangoFlete()+"&");
					  rangosSerializados.append("rangoInf¿"+dtoRango.getRangoInf()+"&");
					  rangosSerializados.append("rangoSup¿"+dtoRango.getRangoSup()+"&");
					  rangosSerializados.append("montoFij¿"+dtoRango.getMontoFij()+"&");
					  rangosSerializados.append("oidFlete¿"+dtoRango.getOidFlete()+"");
					  rangosSerializados.append("#");
					  if (oidFlete==null) {
								oidFlete = dtoRango.getOidFlete();
					  }
				}
		  }
		  if (oidFlete==null) {
				   oidFlete = new Long(0);
		  }
		  this.asignarAtributo("VAR", "hOidFlete", "valor", oidFlete.toString());
		  this.asignarAtributo("VAR", "hSDetalleFlete", "valor", rangosSerializados.toString());

		  traza("LPMantieneFlete.serializarRangosFlete():Salida");   
  }

   private DTOFlete deserializarRangosFlete(DTOFlete flete) throws Exception {

			traza("LPMantieneFlete.deserializarRangosFlete():Entrada");

			String sRangosFlete = conectorParametro("hSDetalleFlete");   
						   
			//proceso los rangos de Precios del detalle

			StringTokenizer rangosFlete = new StringTokenizer(sRangosFlete, "#");

			if (rangosFlete.hasMoreTokens()) {                   
				flete.setRangosFlete(new ArrayList());

				while(rangosFlete.hasMoreTokens()){
				   StringTokenizer unrangoFleteEnTokens = new StringTokenizer(rangosFlete.nextToken(), "&"); 
				   
				   dtoRangoFlete = new DTORangoFlete();
				   while (unrangoFleteEnTokens.hasMoreTokens()) {                               
					   asignarADTO(unrangoFleteEnTokens.nextToken(), dtoRangoFlete, "¿");
				   }
				   flete.getRangosFlete().add(dtoRangoFlete);
				}                       
			}
			traza("LPMantieneFlete.deserializarRangosFlete():Salida");
			return flete;
   }

  private void asignarADTO(String datos, Object dto, String separator) throws Exception {
      traza("LPMantieneFlete.asignarADTO()-Previo:Entrada");
  
      StringTokenizer propValor = new StringTokenizer(datos, separator);
      
      String nombreProperty = propValor.nextToken();
      String valorASetear = propValor.hasMoreTokens()?propValor.nextToken():"";   
      
      asignarADTO(nombreProperty, valorASetear, dto);
      
      traza("LPMantieneFlete.asignarADTO()-Previo:Salida");
  }
    
  private void asignarADTO(String nombreProperty, Object valorASetear, Object dto) throws Exception {      
      traza("LPMantieneFlete.asignarADTO():Entrada");
      
      if ((valorASetear!=null)&&(!valorASetear.equals(""))) {
          Method metodo = obtenerMetodo(nombreProperty, dto);
          
          if (metodo!=null) {
              try {
              
                Class claseDelParametro = metodo.getParameterTypes()[0];
                traza("Clase del parametro:"+claseDelParametro.getName());
                if(claseDelParametro.isPrimitive()&&("char".equals(claseDelParametro.getName()))) {
                  traza("El tipo es primitivo char");   
                  Object[] args = {new Character(valorASetear.toString().charAt(0))};
                  Object res = metodo.invoke(dto,args);   
                } else {                  
                  Class[] paramParamType = {valorASetear.getClass()};
                  Object[] paramsParam = {valorASetear};
                  Object param = claseDelParametro.getConstructor(paramParamType).newInstance(paramsParam);                  
                  Object[] args = {param};               
                  Object res = metodo.invoke(dto,args);
                }
              } catch (Exception e) {
                traza("Pincho la asignacion del parametro "+ nombreProperty +" en "+ dto.getClass().getName() +", con el valor "+valorASetear);
                logStackTrace(e);
              }
          } else {
              traza("No se encontro el setter correspondiente a "+ nombreProperty +" en "+ dto.getClass().getName() +", puede que no exista.");
          }
      }
      traza("LPMantieneFlete.asignarADTO():Salida");        
  }

    private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());

        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);

        if (e instanceof MareException) {
            MareException e2 = (MareException) e;
            traza("Es una mare Exception con codigo de error: " + e2.getCode());
        }

        e.printStackTrace(out);
        traza("stack Trace : " + pila.toString());
    }


  private Method obtenerMetodo(String nombreProp, Object dto) throws Exception {
  
        traza("LPMantieneFlete.obtenerMetodo()");
        String primerLetra = nombreProp.substring(0, 1).toUpperCase();
        String restoNombre = nombreProp.substring(1);
        String methodName = "set" + primerLetra + restoNombre;
        
        Class clsDTO = dto.getClass();
        
        Method[] metodos = clsDTO.getMethods();
        
        int i=0;
        int cant = metodos.length;
       
        while (i<cant) {
            if (methodName.equals(metodos[i].getName())) {
              return metodos[i];
            }
            i++;
        }        
        return null;
  }

}
