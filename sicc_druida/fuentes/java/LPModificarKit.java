import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.DTOPais;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.util.xml.XMLDocument;
import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;

//Librerias DTO modulo
import es.indra.sicc.dtos.mae.DTOConfiguracionCamposProducto;
import es.indra.sicc.dtos.mae.DTOCombosKit;
import es.indra.sicc.dtos.mae.DTOCampo;
import es.indra.sicc.dtos.mae.DTOProducto;
import es.indra.sicc.dtos.mae.DTOKit;
import es.indra.sicc.dtos.mae.DTOProductoKit;
import es.indra.sicc.dtos.mae.DTOKitModificar;

//import es.indra.sicc.dtos.zon.DTOUsuario;
//import es.indra.sicc.dtos.zon.DTOEGPaises;

//Librerias Mare
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgu.manager.Property;

//Librerias druida
import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.druida.DruidaBaseComun;
import es.indra.druida.DruidaConector;

//Librerias Utilidades java
import java.util.Vector;

import java.util.Date;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Enumeration;
import java.util.ArrayList;
import java.io.*;
import java.math.BigDecimal;

//Librerias utilidades XML
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.dom.DOMException;
import es.indra.sicc.util.xml.XMLDocument;
import java.lang.StringBuffer;
import java.lang.Boolean;
import java.lang.Throwable;
import java.lang.Exception;
//import LPSICCBase;

//Constructor de la clase
public class LPModificarKit extends LPSICCBase {  

   private String oid = null;
   private String casoDeUso = null;
   private ArrayList al = null;
   private ArrayList alCodes = null;
   private String separadorDecimal = null;

   public void inicio() throws Exception { }      
     
   public LPModificarKit () {  super();  }
   
   public void ejecucion() throws Exception {
      rastreo();
		
		setTrazaFichero();      
		oid = conectorParametro("oid");
		traza("Entrada OID: " + oid);
		casoDeUso = conectorParametro("casoDeUso");
		traza("casoDeUso: " + casoDeUso);

	  String exito = conectorParametroLimpia("exito","",true);
	  if(oid.equals("")) oid = conectorParametroLimpia("hid_Oid","",true);	  
	  if(!exito.equals("TRUE")) {
		  String accion=conectorParametroLimpia("accion","",true);

		  separadorDecimal = UtilidadesSession.getSeparadorDecimales(this);
		  traza("0 - ejecucion");
		  
		  try{
			 if(accion.equals(new String("Guardar"))){
			 	pagina("salidaGenerica");
			 	traza("antes de guardar");
				this.guardar();
				traza("despuesde guardar");
			 }else{
			 	 pagina("contenido_kit_productos_insertar");

			 	 asignar("VAR","hid_oidIdioma",UtilidadesSession.getIdioma(this).toString());
			 	 asignar("VAR","hid_oidPais",UtilidadesSession.getPais(this).toString());

				 //anyadeHiddensI18N(true, "MAE_PRODU", null, new Integer(1),"frmPrototipoInsertarUsuario","txtDescripcionSAP");
				 anyadeHiddensI18N(true, "MAE_PRODU", new Long(oid), new Integer(1),"frmKitProductos","txtDescripcionSAP", false);
				 al = new ArrayList();
				 alCodes = new ArrayList();
				 // 0 -> 1 -> 2
				 //al.add("txtCodigoSAP");             alCodes.add("MAEPRODCODSAP");  
				 al.add("txtDescripcionSAP");        alCodes.add("MAEDESSAP");  
				 al.add("txtCodigoAntiguo");         alCodes.add("MAEPRODCODANT");    
				 al.add("txtDescripcionCorta");      alCodes.add("MAEPRODDESCORT");
				 al.add("rbIndicadorLote");          alCodes.add("MAEPRODINDLOT");
				 al.add("cbIndicadorPS");            alCodes.add("MAEPRODINDPS");   
				 al.add("cbMarca");                  alCodes.add("MAEPRODMARCA");
				 al.add("cbUnidadNegocio");          alCodes.add("MAEPRODUNIDNEG"); 
				 al.add("cbNegocio");                alCodes.add("MAEPRODNEG");     
				 al.add("cbGenerico");               alCodes.add("MAEPRODGEN");
				 al.add("cbSuperGenerico");          alCodes.add("MAEPRODSGEN");
				 al.add("txtJerarquia1");            alCodes.add("MAEPRODJER1");          
				 al.add("txtJerarquia2");            alCodes.add("MAEPRODJER2");
				 al.add("txtJerarquia3");            alCodes.add("MAEPRODJER3");    
				 al.add("cbLinea");                  alCodes.add("MAEPRODLINPRO");       
				 al.add("txtAtributo1");             alCodes.add("MAEPRODATR1");
				 al.add("txtAtributo2");             alCodes.add("MAEPRODATR2");
				 al.add("txtAtributo3");             alCodes.add("MAEPRODATR3");     
				 al.add("txtDimensionAlto");         alCodes.add("MAEPRODDIMAL");
				 al.add("txtDimensionLargo");        alCodes.add("MAEPRODDIMLAR");
				 al.add("txtDimensionAncho");        alCodes.add("MAEPRODDIMANCH");    
				 al.add("cbUnidadMedidaDimensiones");alCodes.add("MAEPRODUMDIM");
				 al.add("txtVolumen");               alCodes.add("MAEPRODVOL");
				 al.add("cbUnidadMedidaVolumen");    alCodes.add("MAEPRODUMVOL");   
				 al.add("txtPeso");                  alCodes.add("MAEPRODPESO");
				 al.add("cbUnidadMedidaPeso");       alCodes.add("MAEPRODUMPESO");
				 al.add("txtUnidadesDentroPedido");  alCodes.add("MAEPRODUDENPED"); 
				 al.add("txtUnidadesCaja");          alCodes.add("MAEPRODUNIDCAJ");
				 al.add("txtCosteEstandar");         alCodes.add("MAEPRODPRECOSE");
				 al.add("txtPrecioPosicionamiento"); alCodes.add("MAEPRODPREPOS");
				 al.add("cbSituacion");              alCodes.add("MAEPRODSITU");
				 al.add("cbEstatusProducto");        alCodes.add("MAEPRODESTPROD");
				 al.add("cbIndicadorDentroCaja");    alCodes.add("MAEPRODINDDFCAJ");   
				 al.add("cbCodigoPagoFraccionado");  alCodes.add("MAEPRODCODPAF");
				 al.add("txtPrecioCatalogo");        alCodes.add("MAEPRODPRECAT");
				 al.add("txtPrecioContable");        alCodes.add("MAEPRODPRECON");
				 // -> 34                                     
				 this.RellenarCombosKit();
				 traza("7   - RellenarCombosKit!");
				 if(accion.equals("")){
					traza("7.1"); MareBusinessID id = new MareBusinessID("MAEObtenerKit");
					DTOOID dtoOid = new DTOOID();
					dtoOid.setOid(new Long(oid));
					dtoOid.setOidIdioma(UtilidadesSession.getIdioma(this));
					dtoOid.setOidPais(UtilidadesSession.getPais(this));
					traza("7.2"); Vector args = new Vector();
					args.add(dtoOid);
					args.add(id);
					traza("Veeeeector:   "   + args);
					traza("7.3"); DruidaConector priemnik = conectar("ConectorObtenerKit",args);
					traza("7.4"); DTOKitModificar dtos = (DTOKitModificar) priemnik.objeto("DTOSalida");
					traza("7.5"); DTOKit dtoKit = dtos.getDatos();
					traza("Line 239. " + dtoKit.getCodAntiguo());
					asignar("VAR","casoDeUso",casoDeUso);
					traza("7.6");
					traza("oid: " + oid);
					asignar("VAR","hid_Oid",oid);
					//------------------------ CTEXTOS -------------------------------------------------
					traza("7.7");
					if (dtoKit.getPorcentajeUnidades()!=null)
						asignar("CTEXTO","txtPorcentajeUnidades",dtoKit.getPorcentajeUnidades().toString());
					traza("242 obtener CodigoSAP");
					if(dtoKit.getCodSAP() != null)
					   asignar("CTEXTO","txtCodigoSAP",dtoKit.getCodSAP());
					traza("244");
					if (dtoKit.getCodAntiguo()!=null)
						asignar("CTEXTO","txtCodigoAntiguo",dtoKit.getCodAntiguo());
					traza("246");
					if (dtoKit.getDescCorta()!=null)
						asignar("CTEXTO","txtDescripcionCorta",dtoKit.getDescCorta());
					traza("248 obtener DescripcionSAP");
					if(dtoKit.getDescSAP() != null)
					   asignar("CTEXTO","txtDescripcionSAP",dtoKit.getDescSAP());
					traza("250");
					if (dtoKit.getJerarquia1()!=null){
                        traza("######################");
						asignar("CTEXTO","txtJerarquia1",dtoKit.getJerarquia1());
                    }

					traza("252");
					if (dtoKit.getJerarquia2()!=null)
						asignar("CTEXTO","txtJerarquia2",dtoKit.getJerarquia2());
					if (dtoKit.getJerarquia3()!=null)
						asignar("CTEXTO","txtJerarquia3",dtoKit.getJerarquia3());
                    traza("%%%%%%%%%%%%%%%%JOJOJOJOJOJOJO%%%%%%");
                    if (dtoKit.getGrupoArticulos() != null) {
                        traza("%%%%%%%%%%%%%%%%%%");
                        traza("getGrupoArticulos(): " + dtoKit.getGrupoArticulos());
                        asignar("CTEXTO","txtGrupoArticulos",dtoKit.getGrupoArticulos());
                    }
						
					traza("258");
					if(dtoKit.getAlto() != null) {
					   String alto = dtoKit.getAlto().toString();
					   if(separadorDecimal.equals(","))
						   alto = alto.replace('.',',');
						asignar("CTEXTO","txtDimensionAlto",alto);
					}
					if (dtoKit.getLargo()!=null)
						asignar("CTEXTO","txtDimensionLargo",dtoKit.getLargo().toString());
					if (dtoKit.getAncho()!=null)
						asignar("CTEXTO","txtDimensionAncho",dtoKit.getAncho().toString());
					traza("267");
					
					if (dtoKit.getAtributo1()!=null)
						asignar("CTEXTO","txtAtributo1",dtoKit.getAtributo1().toString());
						
					if (dtoKit.getAtributo2()!=null)
						asignar("CTEXTO","txtAtributo2",dtoKit.getAtributo2().toString());
					if (dtoKit.getAtributo3()!=null)
						asignar("CTEXTO","txtAtributo3",dtoKit.getAtributo3().toString());
					
					traza("271 -  getVolumen");			 
					if(dtoKit.getVolumen() != null) {
					   String volumen = dtoKit.getVolumen().toString();
					   if(separadorDecimal.equals(","))
						   volumen = volumen.replace('.',',');
					   traza("Volumen:  " + volumen);
					   asignar("CTEXTO","txtVolumen",volumen);
					}
					traza("278");			
					if(dtoKit.getPeso() != null) {
					   String peso = dtoKit.getPeso().toString();
					   if(separadorDecimal.equals(","))
						   peso = peso.replace('.',',');
					   asignar("CTEXTO","txtPeso",peso);
					}
					traza("285");  
					if (dtoKit.getUnidDentroPedido()!=null)
						asignar("CTEXTO","txtUnidadesDentroPedido",dtoKit.getUnidDentroPedido().toString());
					traza("287");  
					if (dtoKit.getUnidPorCaja()!=null)
						asignar("CTEXTO","txtUnidadesCaja",dtoKit.getUnidPorCaja().toString());
					traza("289");  if(dtoKit.getCosteEstandar() != null) {
									   String CosteEstandar = dtoKit.getCosteEstandar().toString();
									   if(separadorDecimal.equals(","))
										   CosteEstandar = CosteEstandar.replace('.',',');
									   asignar("CTEXTO","txtCosteEstandar", CosteEstandar);
									}
					traza("296");	if(dtoKit.getPrecioPosicionamiento() != null) {
									   String PrecioPosicionamiento = dtoKit.getPrecioPosicionamiento().toString();
									   if(separadorDecimal.equals(","))
										   PrecioPosicionamiento = PrecioPosicionamiento.replace('.',',');
									   asignar("CTEXTO","txtPrecioPosicionamiento", PrecioPosicionamiento);
									}
					//traza("303");   asignar("CTEXTO","txtCodigoPagoFraccionado",dtoKit.getCodPagoFraccionado().toString());
					traza("303");  
					if (dtoKit.getFormaPago()!=null)
						asignar("VAR","hid_cbCodigoPagoFraccionado",dtoKit.getFormaPago().toString());					
					traza("305");	if(dtoKit.getPrecioCatalogo() != null) {
									   String PrecioCatalogo = dtoKit.getPrecioCatalogo().toString();
									   if(separadorDecimal.equals(","))
										   PrecioCatalogo = PrecioCatalogo.replace('.',',');
									   asignar("CTEXTO","txtPrecioCatalogo",PrecioCatalogo);
									}
					traza("7.25");			
					if(dtoKit.getPrecioContable() != null) {
					   String PrecioContable = dtoKit.getPrecioContable().toString();
					   if(separadorDecimal.equals(","))
						   PrecioContable = PrecioContable.replace('.',',');
					   asignar("CTEXTO","txtPrecioContable",PrecioContable);
					}
					traza("7.26");
					if (dtoKit.getCodImpuesto()!=null)
						asignar("CTEXTO","txtCodigoImpuesto",dtoKit.getCodImpuesto().toString());
					//----- VAR HIDDEN PARA VALORES DE COMBOS ------------------------------
					asignar("VAR","hid_Oid",oid);
					traza("c.1");
					if(dtoKit.getProductoServicio() != null)
					  asignar("VAR","hid_cbIndicadorPS", dtoKit.getProductoServicio().toString());
					traza("c.2");
					if(dtoKit.getMarca() != null) {
					    String marca = dtoKit.getMarca().toString();
						asignar("VAR","hid_cbMarca",marca);
					}
					traza("c.3");
					if(dtoKit.getCanal() != null) {
					    String canal = dtoKit.getCanal().toString();
						asignar("VAR","hid_cbCanal",canal);
					}
              if(dtoKit.getMarcaPeriodo() != null) {
					    String marca2 = dtoKit.getMarcaPeriodo().toString();
					    asignar("VAR","hid_cbMarca2",marca2);
					}
//               if (dtoKit.getTipoPeriodo()!=null)
//               	asignar("VAR","hid_cbTipoPeriodo",dtoKit.getTipoPeriodo().toString());					
					traza("c.4");
					if (dtoKit.getPeriodoInicio()!=null)
						asignar("VAR","hid_cbPeriodoInicio",dtoKit.getPeriodoInicio().toString());
					traza("c.5");
					if (dtoKit.getPeriodoFin()!=null)
						asignar("VAR","hid_cbPeriodoFin",dtoKit.getPeriodoFin().toString());
					traza("c.6");
					if (dtoKit.getLineaProducto()!=null)
						asignar("VAR","hid_cbLinea",dtoKit.getLineaProducto().toString());
					traza("c.7");
					if (dtoKit.getNegocio()!=null)
						asignar("VAR","hid_cbNegocio",dtoKit.getNegocio().toString());
					traza("c.8");
					if (dtoKit.getUnidadNegocio()!=null)
						asignar("VAR","hid_cbUnidadNegocio",dtoKit.getUnidadNegocio().toString());
					traza("c.9");
					if (dtoKit.getGenerico()!=null)
						asignar("VAR","hid_cbGenerico",dtoKit.getGenerico().toString());
					traza("c.10 SuperGenerico");
					if (dtoKit.getSupergenerico()!=null)
						asignar("VAR","hid_cbSuperGenerico",dtoKit.getSupergenerico().toString());
					traza("c.11");
					if (dtoKit.getEstatus()!=null)
						asignar("VAR","hid_cbEstatusProducto",dtoKit.getEstatus().toString());
					traza("c.12");
					if (dtoKit.getSituacion()!=null)
						asignar("VAR","hid_cbSituacion",dtoKit.getSituacion().toString());
					traza("c.13");
					if (dtoKit.getUnidMedidaDimensiones()!=null)
						asignar("VAR","hid_cbUnidadMedidaDimensiones",dtoKit.getUnidMedidaDimensiones().toString());
					traza("c.14");
					if (dtoKit.getUnidMedidaVolumen()!=null)
						asignar("VAR","hid_cbUnidadMedidaVolumen",dtoKit.getUnidMedidaVolumen().toString());
					traza("c.15");
					if (dtoKit.getUnidMedidaPeso()!=null)
						asignar("VAR","hid_cbUnidadMedidaPeso",dtoKit.getUnidMedidaPeso().toString());
					traza("c.16");
					if (dtoKit.getCajaBolsa()!=null)
						asignar("VAR","hid_cbIndicadorDentroCaja",dtoKit.getCajaBolsa().toString());
					// ----- RADIOBS -----------------------------
					traza("rb.1");
					if (dtoKit.getIndLote()!=null)
						asignar("VAR","hid_rbIndicadorLote",dtoKit.getIndLote().toString());
					//----------------------------------------------
					ArrayList dtoProductosKit = new ArrayList();
					traza("ArrayList.1");
					dtoProductosKit = dtoKit.getProductos();
					traza("RecordSet periodos 1");
					//RecordSet rs_periodos = dtos.getPeriodos();
					RecordSet rs_productoKit = new RecordSet();
					rs_productoKit.addColumn("oid");
					rs_productoKit.addColumn("producto");
					rs_productoKit.addColumn("numUnidades");
					Vector row = null;
					DTOProductoKit dtoProductoKit = null;
					for(int x=0;x < dtoProductosKit.size();x++) {
					   row = new Vector();
					   dtoProductoKit = (DTOProductoKit)dtoProductosKit.get(x);
					   row.addElement(dtoProductoKit.getOidProducto());               
					   row.addElement(dtoProductoKit.getProducto());
					   row.addElement(dtoProductoKit.getNumUnidades());
					   rs_productoKit.addRow(row);               
					}
					traza("Generar conector");
					DruidaConector listaeditable_productosKit = this.generarConectorParaListaEditable("DTOSalida.rs_productoKit_ROWSET",rs_productoKit, rs_productoKit.getColumnIdentifiers());
					traza("Conector: " + listaeditable_productosKit.getXML() );
					asignar("VAR","hid_temp",listaeditable_productosKit.getXML().toString());
					traza("asignar LISTAEDITABLE");
					asignar("LISTADOA","listado1",listaeditable_productosKit,"DTOSalida.rs_productoKit_ROWSET");                        
				 }				 
			 
					if(casoDeUso.equals("Consultar")){
						asignarAtributoPagina("cod","0345");
						traza("1");
					} else {
						asignarAtributoPagina("cod","0402");	  
						traza("2");
					}
					getConfiguracionMenu("LPModificarKit", "Modificar");
			 }			 			 
		  }catch(Exception ex){
            lanzarPaginaError(ex); 	 
		  }
	  }
   }
   
   //********************* Metodos privados ****************************
   
   private void RellenarCombosKit()throws Exception {
      try{                    
          DTOBelcorp dtoBelcorp = new DTOBelcorp();
          //UtilidadesSession sesion = new UtilidadesSession();
          Vector objBussines = new Vector();
          //Vector conectores = new Vector();
          MareBusinessID id = new MareBusinessID("MAERellenarCombosKit");
          //RecordSet rs[]=new RecordSet[10];
          //int[] numCol = new int[10];
          this.traza("Asigno Pais e idioma ");   
          dtoBelcorp.setOidPais(UtilidadesSession.getPais(this));
          dtoBelcorp.setOidIdioma(UtilidadesSession.getIdioma(this));
          this.traza("Asigno DTO y Facade");
          objBussines.add(dtoBelcorp);
          objBussines.add(id);
          this.traza("Vemos el resultado del objeto DTO");
          DruidaConector ver = conectar("ConectorCargaCombosKit",objBussines);
          DTOCombosKit dtos = (DTOCombosKit) ver.objeto("DTOSalida");
          /*traza("DTOSalida: "+dtos);
		  traza("getUnidadesMedida(): " + dtos.getUnidadesMedida().toStringTabFormat());
		  traza("getMarcas(): " + dtos.getMarcas().toStringTabFormat());
		  traza("getEstatus(): " + dtos.getEstatus().toStringTabFormat());*/
          RecordSet rs_unidadesMedida = (RecordSet)dtos.getUnidadesMedida();          
          DruidaConector combo_unidadesMedida = this.generarConector("DTOSalida.unidadesMedida_ROWSET",rs_unidadesMedida, rs_unidadesMedida.getColumnIdentifiers());
          //this.traza("Asigno los combos");
          asignar("COMBO","cbUnidadMedidaDimensiones",combo_unidadesMedida,"DTOSalida.unidadesMedida_ROWSET");
          asignar("COMBO","cbUnidadMedidaVolumen",combo_unidadesMedida,"DTOSalida.unidadesMedida_ROWSET");
          asignar("COMBO","cbUnidadMedidaPeso",combo_unidadesMedida,"DTOSalida.unidadesMedida_ROWSET");         
          //this.put_rs("COMBO","cbMarca",(RecordSet)dtos.getMarcasProducto());
          this.put_rs("COMBO","cbMarca2",(RecordSet)dtos.getMarcas());
          this.put_rs("COMBO","cbUnidadNegocio",(RecordSet)dtos.getUnidadesNegocio());
          this.put_rs("COMBO","cbNegocio",(RecordSet)dtos.getNegocio());
          this.put_rs("COMBO","cbGenerico",(RecordSet)dtos.getGenericos());
          this.put_rs("COMBO","cbSuperGenerico",(RecordSet)dtos.getSupergenericos());
          this.put_rs("COMBO","cbLinea",(RecordSet)dtos.getLineas());
//          this.put_rs("COMBO","cbTipoPeriodo",(RecordSet)dtos.getTiposPeriodo());
//		  traza("mod combo tipo P: " + (RecordSet)dtos.getTiposPeriodo());
          this.put_rs("COMBO","cbEstatusProducto",(RecordSet)dtos.getEstatus());
          this.put_rs("LISTA","lstOculta",(RecordSet)dtos.getCanales());
		  this.put_rs("COMBO","cbCodigoPagoFraccionado",(RecordSet)dtos.getFormasPago());
          asignar("VAR","hid_SeparadorDecimales",UtilidadesSession.getSeparadorDecimales(this));
          asignar("VAR","hid_NumeroDecimales",UtilidadesSession.getFormatoNumerico(this));
          this.ConfigurarCampos();                                        
      }catch(Throwable th){	      
          this.traza("error en RellenarCombosKit ");
          ByteArrayOutputStream stack = new ByteArrayOutputStream();
          PrintStream out = new PrintStream(stack);
          th.printStackTrace(out);
          traza(  stack.toString());
          BelcorpError belcorpError = new BelcorpError();
          DTOError dtoError = belcorpError.obtenerError(th,UtilidadesSession.getIdioma_ISO(this),"");
          //String s = th.getMessage();
          traza (  dtoError.getCodigoError() + " - " + dtoError.getDescripcionError() );
          throw((Exception)th);       
      }          
   }

   private void ConfigurarCampos()throws Exception{       
      try{
          DTOConfiguracionCamposProducto dto = new DTOConfiguracionCamposProducto();
          Vector campo= new Vector();
          Vector out= new Vector();
          Vector objBussines = new Vector();
          DTOCampo var = null;
          for(int i=0;i<=34;i++){
            var = new DTOCampo();
            var.setCodigoCampo(this.alCodes.get(i).toString());
            campo.addElement(var);
          }      
          dto.setOidIdioma(UtilidadesSession.getIdioma(this));
          dto.setOidPais(UtilidadesSession.getPais(this));
          /*dto.setOidIdioma(sesion.getIdioma(this));
          dto.setOidPais(sesion.getPais(this));*/
          dto.setCampos(campo);
          MareBusinessID id = new MareBusinessID("MAEConfiguracionCampos");
          //this.traza("Pase la asignacion FACADE");
          objBussines.add(dto);
          objBussines.add(id);
          DruidaConector ver=conectar("ConectorConfiguracionCamposProductos",objBussines);
          MareDTO dt =(MareDTO)ver.objeto("DTOSalidaTipoConfig");
          //traza(dt);
          DTOConfiguracionCamposProducto dtos = (DTOConfiguracionCamposProducto) dt.getProperty("resultado");
          traza("DTOSalida: "+dtos);
          traza("Cargamos los campos: ");
          out=dtos.getCampos();
          //Asignamos los atributos
          for(int i=0;i<=34;i++){
            var=(DTOCampo)out.get(i);
            //Son CTEXTO
            if(i!=3 ||i!=4||i!=5||i!=6||i!=7||i!=8||i!=9||i!=13||i!=20||i!=22||i!=24||i!=29||i!=30||i!=31||i!=32){
               if(var.getObligatorio()!=null && var.getObligatorio().booleanValue()){
                 asignarAtributo("CTEXTO",this.al.get(i).toString(),"req","S");
               }
               if(var.getValorDefecto()!=null && !(var.getValorDefecto().equals(""))){
                 asignarAtributo("CTEXTO",this.al.get(i).toString(),"valor",var.getValorDefecto());
               }			   
            }
            //Son COMBO
            if(i==4||i==5||i==6||i==7||i==8||i==9||i==13||i==20||i==22||i==24||i==29||i==30||i==31||i==32){                
                if(var.getObligatorio()!=null && var.getObligatorio().booleanValue()){
                    asignarAtributo("COMBO",this.al.get(i).toString(),"req","S");
                }
            }
            if(i==3){
           	  if(var.getObligatorio()!=null && var.getObligatorio().booleanValue()){
                 asignarAtributo("RADIOB",this.al.get(i).toString(),"req","S");
              }
            }
			// Son todos modificable o no
			if(var.getModificable() != null && !(var.getModificable().booleanValue())){
                 asignarAtributo("VAR","hid_" + this.al.get(i).toString() + "_modificable","valor","N");
            }
			// Son todos requeridos o no
			if(var.getObligatorio()!=null && var.getObligatorio().booleanValue()){
                 asignarAtributo("VAR","hid_" + this.al.get(i).toString() + "_req","valor","REQ");
            }
          }           
		  
		   asignarAtributo("CTEXTO","txtCodigoSAP","req","S");

      }catch(Throwable th){
         this.traza("error en Configurar campos ");
         ByteArrayOutputStream stack = new ByteArrayOutputStream();
         PrintStream out = new PrintStream(stack);
         th.printStackTrace(out);
         traza(  stack.toString());
         BelcorpError belcorpError = new BelcorpError();
         DTOError dtoError = belcorpError.obtenerError(th,UtilidadesSession.getIdioma_ISO(this),"");
         //String s = th.getMessage();
         traza (  dtoError.getCodigoError() + " - " + dtoError.getDescripcionError() );
         throw((Exception)th);       
      }
   }

   private void guardar()throws Exception{
      //try{ 
         traza("1 - a guardar");
         traza("2");                
         DTOKit dtoKit = new DTOKit();      
         Vector paramEntrada = new Vector();
         ArrayList dtoProductoKitList = new ArrayList();                
         // Armando vector DTOKit               
         //---------------------------------------
         traza("C O M M O N S");
         //dtoKit.setOid(new Long(1));
		 String oidModify = conectorParametroLimpia("hid_Oid","",true );
         traza("1. setOid- > " + oidModify);		 
		 dtoKit.setOid(new Long(oidModify));
         traza("2. setOidIdioma: UtilidadesSession->" + UtilidadesSession.getIdioma(this));
         dtoKit.setOidIdioma(UtilidadesSession.getIdioma(this));
         dtoKit.setOidPais(UtilidadesSession.getPais(this));
         traza("3. setOidPais: UtilidadesSession->" + UtilidadesSession.getPais(this));
         //dtoKit.setIdioma()
         dtoKit.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
         traza("4. setIpCliente: UtilidadesBelcorp->" + UtilidadesBelcorp.getIPCliente(this));
         dtoKit.setPrograma(UtilidadesSession.getFuncion(this));
         traza("5. setPrograma: UtilidadesSession->" + UtilidadesSession.getFuncion(this));
         //-----------------------------------------
         //--------- RADIOBUTTONS ------------------
         traza("RADIOBUTTON");
         dtoKit.setIndLote((conectorParametroLimpia("rbIndicadorLote","",true ).equals("1"))?Boolean.TRUE:Boolean.FALSE);            
         traza("6. setIndLote: " + dtoKit.getIndLote().toString());
         //--------- COMBOS ------------------------
         traza("COMBOS de Character");
         //----- tipo Character --------------------
         String indicadorDentroCaja = conectorParametroLimpia("cbIndicadorDentroCaja","",true );
         String situacion = conectorParametroLimpia("cbSituacion","",true );
         if(!indicadorDentroCaja.equals(""))
            dtoKit.setCajaBolsa(new Character(indicadorDentroCaja.charAt(0)));
         if(!situacion.equals(""))
            dtoKit.setSituacion(new Character(situacion.charAt(0)));
         traza("7. setCajaBolsa: " + indicadorDentroCaja);
		 
         traza("8. setSituacion: " + situacion);         
         //----- tipo Long -------------------------
         traza("---- L O N G S ----");
         String canal = conectorParametroLimpia("cbCanal","",true );
		 traza("672. canal: " + canal); 
         if(!canal.equals("")) dtoKit.setCanal(new Long(canal));
         traza("9. setCanal: " + canal); 
         String estatusProducto = conectorParametroLimpia("cbEstatusProducto","",true );
         if(!estatusProducto.equals("")) dtoKit.setEstatus(new Long(estatusProducto));
         traza("10. setEstatusProducto: " + estatusProducto);
         String generico = conectorParametroLimpia("cbGenerico","",true );
         if(!generico.equals(""))  dtoKit.setGenerico(new Long(generico));
         traza("11. setGenerico: " + generico);
         String linea = conectorParametroLimpia("cbLinea","",true );
         if(!linea.equals("")) dtoKit.setLineaProducto(new Long(linea));
         traza("12. setLineaProducto: " + linea);      
         String marca = conectorParametroLimpia("cbMarca2","",true );
         if(!marca.equals("")) dtoKit.setMarca(new Long(marca));
         traza("13. setMarca: " + marca); 
         String negocio = conectorParametroLimpia("cbNegocio","",true );
         if(!negocio.equals("")) dtoKit.setNegocio(new Long(negocio));            
		 traza("14. setNegocio: " + negocio); 
         String periodoFin = conectorParametroLimpia("cbPeriodoFin","",true );
         if(!periodoFin.equals("")) dtoKit.setPeriodoFin(new Long(periodoFin));   
		 traza("15. setPeriodoFin: " + periodoFin); 
         String periodoInicio = conectorParametroLimpia("cbPeriodoInicio","",true );
         if(!periodoInicio.equals("")) dtoKit.setPeriodoInicio(new Long(periodoInicio));
		 traza("16. setPeriodoInicio: " + periodoInicio); 
         String superGenerico = conectorParametroLimpia("cbSuperGenerico","",true );
         if(!superGenerico.equals("")) dtoKit.setSupergenerico(new Long(superGenerico));
         traza("17. setSupergenerico: " + superGenerico); 
         String unidadNegocio = conectorParametroLimpia("cbUnidadNegocio","",true );
         if(!unidadNegocio.equals("")) dtoKit.setUnidadNegocio(new Long(unidadNegocio));
         traza("18. setUnidadNegocio: " + unidadNegocio); 
         String unidadMedidaDimensiones = conectorParametroLimpia("cbUnidadMedidaDimensiones","",true );
         if(!unidadMedidaDimensiones.equals("")) dtoKit.setUnidMedidaDimensiones(new Long(unidadMedidaDimensiones));
         traza("19. setUnidMedidaDimensiones: " + unidadMedidaDimensiones); 
         String unidadMedidaPeso = conectorParametroLimpia("cbUnidadMedidaPeso","",true );
         if(!unidadMedidaPeso.equals("")) dtoKit.setUnidMedidaPeso(new Long(unidadMedidaPeso));
         traza("20. setUnidMedidaPeso: " + unidadMedidaPeso); 
         String unidadMedidaVolumen = conectorParametroLimpia("cbUnidadMedidaVolumen","",true );
         if(!unidadMedidaVolumen.equals("")) dtoKit.setUnidMedidaVolumen(new Long(unidadMedidaVolumen));
         traza("21. setUnidMedidaVolumen: " + unidadMedidaVolumen); 
         //----- tipo Boolean --------------------
         dtoKit.setProductoServicio((conectorParametroLimpia("cbIndicadorPS","",true ).equals("1"))?Boolean.TRUE:Boolean.FALSE);            
         traza("22. setProductoServicio: " + conectorParametroLimpia("cbIndicadorPS","",true )); 
         //--------- TEXTOS ------------------------
         traza("---- T E X T O S de BigDecimals ----"); 
         //----- tipo BigDecimal -------------------
         //......... volumenes .....................
         String dimensionAlto = conectorParametroLimpia("txtDimensionAlto","",true );
         if(!dimensionAlto.equals("")) {
            if(separadorDecimal.equals(","))
               dimensionAlto = dimensionAlto.replace(',','.');
            dtoKit.setAlto(new BigDecimal(dimensionAlto));
         }
         traza("23. setAlto: " + dimensionAlto); 
         String dimensionAncho = conectorParametroLimpia("txtDimensionAncho","",true );
         if(!dimensionAncho.equals("")) {
            if(separadorDecimal.equals(","))
               dimensionAncho = dimensionAncho.replace(',','.');
            dtoKit.setAncho(new BigDecimal(dimensionAncho));
         }
         traza("24. setAncho: " + dimensionAncho); 
         String dimensionLargo = conectorParametroLimpia("txtDimensionLargo","",true );
         if(!dimensionLargo.equals("")) {
            if(separadorDecimal.equals(","))
               dimensionLargo = dimensionLargo.replace(',','.');
            dtoKit.setLargo(new BigDecimal(dimensionLargo));
         }
         traza("25. setLargo: " + dimensionLargo); 
         String volumen = conectorParametroLimpia("txtVolumen","",true );
         if(!volumen.equals("")) {
            if(separadorDecimal.equals(","))  volumen = volumen.replace(',','.');
               dtoKit.setVolumen(new BigDecimal(volumen));
         }
         traza("26. setVolumen: " + volumen); 
         String peso = conectorParametroLimpia("txtPeso","",true );
         if(!peso.equals("")) {
            if(separadorDecimal.equals(",")) peso = peso.replace(',','.');
               dtoKit.setPeso(new BigDecimal(peso));
         }
         traza("27. setPeso: " + peso); 
         //......... precios .......................
         String costeEstandar = conectorParametroLimpia("txtCosteEstandar","",true );
         if(!costeEstandar.equals("")) {
            if(separadorDecimal.equals(","))
               costeEstandar = costeEstandar.replace(',','.');
            dtoKit.setCosteEstandar(new BigDecimal(costeEstandar));
         }
         traza("28. setCosteEstandar: " + costeEstandar); 
         String precioCatalogo = conectorParametroLimpia("txtPrecioCatalogo","",true );
         if(!precioCatalogo.equals("")) {
            if(separadorDecimal.equals(","))
               precioCatalogo = precioCatalogo.replace(',','.');
            dtoKit.setPrecioCatalogo(new BigDecimal(precioCatalogo));
         }
         traza("29. setPrecioCatalogo: " + precioCatalogo); 
         String precioContable = conectorParametroLimpia("txtPrecioContable","",true );
         if(!precioContable.equals("")) {
            if(separadorDecimal.equals(","))
               precioContable = precioContable.replace(',','.');
            dtoKit.setPrecioContable(new BigDecimal(precioContable));
         }
         traza("30. setPrecioContable: " + precioContable); 
         String precioPosicionamiento = conectorParametroLimpia("txtPrecioPosicionamiento","",true );
         if(!precioPosicionamiento.equals("")) {
            if(separadorDecimal.equals(","))
               precioPosicionamiento = precioPosicionamiento.replace(',','.');
            dtoKit.setPrecioPosicionamiento(new BigDecimal(precioPosicionamiento));
         }
         traza("31. setPrecioPosicionamiento: " + precioPosicionamiento); 
         //----- tipo Integer ----------------------
         traza("---- I N T E G E R S ----");
         String porcentajeUnidades = conectorParametroLimpia("txtPorcentajeUnidades","",true );
         if(!porcentajeUnidades.equals("")) dtoKit.setPorcentajeUnidades(new Integer(porcentajeUnidades));                        
         traza("32. setPorcentajeUnidades: " + porcentajeUnidades); 
         String unidadesDentroPedido = conectorParametroLimpia("txtUnidadesDentroPedido","",true );
         if(!unidadesDentroPedido.equals("")) dtoKit.setUnidDentroPedido(new Integer(unidadesDentroPedido));            
         traza("33. setUnidDentroPedido: " + unidadesDentroPedido); 
         String unidadesCaja = conectorParametroLimpia("txtUnidadesCaja","",true );
         if(!unidadesCaja.equals("")) dtoKit.setUnidPorCaja(new Integer(unidadesCaja));
         traza("34. setUnidPorCaja: " + unidadesCaja); 
         traza("2.1");
         traza("---- S T R I N G S ----");
         //----- tipo String -------------------
         String atr1 = conectorParametroLimpia("txtAtributo1","",true );
         dtoKit.setAtributo1(atr1);
         traza("35. setAtributo1: " + atr1);
         String atr2 = conectorParametroLimpia("txtAtributo2","",true );
         dtoKit.setAtributo2(atr2);
         traza("36. setAtributo2: " + atr2);
         String atr3 = conectorParametroLimpia("txtAtributo3","",true );
         dtoKit.setAtributo3(atr3);
         traza("37. setAtributo3: " + atr3); 
         //........ codigos ....................
         String codSAP = conectorParametroLimpia("txtCodigoSAP","",true );
         dtoKit.setCodSAP(codSAP);
         traza("38. setCodSAP: " + codSAP);
         String codAntiguo = conectorParametroLimpia("txtCodigoAntiguo","",true );
         dtoKit.setCodAntiguo(codAntiguo);
         traza("39. setCodAntiguo: " + codAntiguo); 
         String codImpuesto = conectorParametroLimpia("txtCodigoImpuesto","",true );
         dtoKit.setCodImpuesto(codImpuesto);
         traza("40. setCodImpuesto: " + codImpuesto);
         String formaPago = conectorParametroLimpia("cbCodigoPagoFraccionado","",true );
		 if(!formaPago.equals("")) dtoKit.setFormaPago(new Long(formaPago));
         traza("41. setCodPagoFraccionado: " + formaPago); 
         //........ descripciones ..............
         String descripcionCorta = conectorParametroLimpia("txtDescripcionCorta","",true );
         dtoKit.setDescCorta(descripcionCorta);
         traza("42. setDescCorta: " + descripcionCorta); 
         //String descripcionSAP = conectorParametroLimpia("txtDescripcionSAP","",true );      
         //dtoKit.setDescSAP(new String(descripcionSAP));
         //traza("43. setDescSAP: " + descripcionSAP); 
         
         dtoKit.setDescSapI18n(recuperaTraduccionesI18N(new Integer(1)));
         traza("44. setDescSapI18n: " + recuperaTraduccionesI18N(new Integer(1)));
         String Jerarquia1 = conectorParametroLimpia("txtJerarquia1","",true );
         dtoKit.setJerarquia1(Jerarquia1);
         traza("45. setJerarquia1: " + Jerarquia1);      
         String Jerarquia2 = conectorParametroLimpia("txtJerarquia2","",true );
         dtoKit.setJerarquia2(Jerarquia2);
         traza("46. setJerarquia2: " + Jerarquia2);
         String Jerarquia3 = conectorParametroLimpia("txtJerarquia3","",true );
         dtoKit.setJerarquia3(Jerarquia3);
         traza("47. setJerarquia3: " + Jerarquia3);
         String grupoArticulos = conectorParametroLimpia("txtGrupoArticulos","",true );
         dtoKit.setGrupoArticulos(grupoArticulos);
         traza("47. grupoArticulos: " + grupoArticulos);
         
         //------- datos de LISTAEDIDABLE ---------------
		 StringTokenizer st_0 = new StringTokenizer(conectorParametroLimpia("hid_lstColumnOidProductos","",true ),"|");
         StringTokenizer st_1 = new StringTokenizer(conectorParametroLimpia("hid_lstColumnProductos","",true ),"|");            
         StringTokenizer st_2 = new StringTokenizer(conectorParametroLimpia("hid_lstColumnNumUnidades","",true ),"|");
         traza("3 .......");
         while(st_1.hasMoreTokens()) {		
		   String prod = st_1.nextToken();
		   if(!prod.equals("D")) {
		    traza(prod);
            DTOProductoKit dtoProductoKit = new DTOProductoKit();
			String nll = st_0.nextToken();			
			if(!nll.equals("D")) {
               traza("nll: " + nll);
			   dtoProductoKit.setOidProducto(new Long(nll));
			}
            dtoProductoKit.setProducto(prod);
            dtoProductoKit.setNumUnidades(new Integer(st_2.nextToken()));
            dtoProductoKitList.add(dtoProductoKit);
		   }
         } 
         traza("4 ....");
         dtoKit.setProductos(dtoProductoKitList);
         traza("48. setProductos: " + dtoProductoKitList.toString()); 
         traza("TRAZA de DTOKit: " + dtoKit);
         MareBusinessID id = new MareBusinessID("MAEModificar");
         paramEntrada.addElement(dtoKit);
         paramEntrada.addElement(id);          
         // Conectando para grabar
         traza("5 ..- conectar a Modificar");
         DruidaConector conector = conectar("ConectorModificarKit",paramEntrada);
         traza("870 . - exito!");
		 asignarAtributo("VAR", "ejecutar", "valor", "ReturnNClose()");
         //asignarAtributo("VAR", "exito", "valor", "TRUE" );
		 //this.getConfiguracionMenu();		 
/*
      }catch(Throwable th){
	     
         this.traza("error en guardar ");
         ByteArrayOutputStream stack = new ByteArrayOutputStream();
         PrintStream out = new PrintStream(stack);
         th.printStackTrace(out);
         traza(  stack.toString());
		 asignar("VAR","oid",oid);
         //i18n para que no pierda los valores cuando hubo una insersion con error.	
         preservaHiddensI18n(new Integer("1"), "MAE_PRODU","frmPrototipoInsertarUsuario","txtDescripcionSAP", false);
		 
         BelcorpError belcorpError = new BelcorpError();
         DTOError dtoError = belcorpError.obtenerError(th, UtilidadesSession.getIdioma_ISO(this),"");
         //String s = th.getMessage();
         traza ( dtoError.getCodigoError() + " - " + dtoError.getDescripcionError() );
         throw((Exception)th);		 		 
      }
*/
   }
   //--------------- UTILITIES ----------------------
   private void put_rs(String type_of_tag, String tag_combo,RecordSet rs_dtos) throws Exception {
      asignar(type_of_tag,tag_combo,this.generarConector("DTOSalida." + tag_combo + "_ROWSET",rs_dtos, rs_dtos.getColumnIdentifiers()),"DTOSalida." + tag_combo + "_ROWSET");      
   }
   /*   Conector Dinamico    */
   private DruidaConector generarConector(String rowsetID, RecordSet datos,Vector columns)
      throws DOMException,Exception	{
      //StringBuffer salida = new StringBuffer();
      int sizeColums = datos.getColumnCount();
      int sizeRows = datos.getRowCount();
      if ( columns == null ){	columns = new Vector();	}
      Vector columsDesc = datos.getColumnIdentifiers();				
      DruidaConector conectorValoresPosibles = new DruidaConector();				
      XMLDocument xmlDoc  = new XMLDocument();
      Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");			
      Element e_rows = docDestino.createElement("ROWSET");
      e_rows.setAttribute("ID",rowsetID);
      docDestino.getDocumentElement().appendChild(e_rows);		
      for (int i=0; i < sizeRows; i++)	{
         Element e_row = docDestino.createElement("ROW");
         e_rows.appendChild(e_row);
         for (int j=0; j < sizeColums; j++) {
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
	  traza(rowsetID + " : "+ conectorValoresPosibles.getXML());
      return conectorValoresPosibles;
   }

   private DruidaConector generarConectorParaListaEditable(String rowsetID, RecordSet datos,Vector columns) 
      throws DOMException, Exception {
		//StringBuffer salida = new StringBuffer();
		int sizeColums = datos.getColumnCount();
		int sizeRows = datos.getRowCount();
		if ( columns == null )
			columns = new Vector();		
		Vector columsDesc = datos.getColumnIdentifiers();				
		DruidaConector conectorValoresPosibles = new DruidaConector();				
		XMLDocument xmlDoc  = new XMLDocument();
		Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");			
		Element e_rows = docDestino.createElement("ROWSET");
		e_rows.setAttribute("ID",rowsetID);
		docDestino.getDocumentElement().appendChild(e_rows);		
		for (int i=0; i < sizeRows; i++)	{
			Element e_row = docDestino.createElement("ROW");
			e_rows.appendChild(e_row);
			for (int j=0; j < sizeColums; j++){				
					Element e_campo2   = docDestino.createElement("CAMPO");
					e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
					e_campo2.setAttribute("TIPO","OBJECTO");
					e_campo2.setAttribute("LONGITUD","50");
					Text txt0 = docDestino.createTextNode((datos.getValueAt(i,j)==null?"":datos.getValueAt(i,j).toString()));
					e_campo2.appendChild(txt0);
					e_row.appendChild(e_campo2);
			}
		}
      conectorValoresPosibles.setXML(docDestino.getDocumentElement());
      return conectorValoresPosibles;
	}	

}
