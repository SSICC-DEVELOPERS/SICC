//utilidades sdk
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Vector;
import java.util.StringTokenizer;
//utilidades Belcorp
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
//import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.xml.XMLDocument;

import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;


//Librerias PED

import es.indra.sicc.dtos.ped.DTOAgregarSolicitudesGrupo;
import es.indra.sicc.dtos.ped.DTOEGrupoReversion;
import es.indra.sicc.dtos.ped.DTOAgregarSolicitudesCriterio;

//utilidades cmn
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

//Libreria Mare
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgu.manager.Property;

//Librerias druida
import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.druida.DruidaBaseComun;


//librerias car
//import es.indra.sicc.dtos.car.DTOGrupoSolicitud;

import java.math.BigDecimal;

public class LPCrearGrupoReversion extends LPSICCBase {

private HashMap param = new HashMap();
private ArrayList lista= new ArrayList();

public LPCrearGrupoReversion () {super();}
 public void inicio() throws Exception {
		pagina("contenido_grupos_reversion_crear");
	    
    
  }

   public void ejecucion() throws Exception {
	   String accion = conectorParametro("accion");
	   param=conectorParametro();
	   accion = (accion==null )?"":accion;
	   setTrazaFichero();
	   traza("Parametros de entrada" + param);
       traza("Entro a LP con accion = "+ accion);
       this.getConfiguracionMenu("LPCrearGrupoReversion");
	   try{
		// rastreo();
	     if(accion.equals("")){
		   //this.mostrarPantalla(accion);
		    this.colaParametros(param.get("listaSolicitudes").toString());
		    cargarPagina();
			
		 }

		 if(accion.equals("agregar")){
		    this.colaParametros(param.get("lista").toString());
			//pagina("salidaGenerica");
			agregarSolicitudes();
		

		 }

		 
	   }catch (Exception ex) {
			this.traza("Error en ejecucion");
		    this.lanzarPaginaError(ex);
      }
   
   }

   private void mostrarPantalla(String accion)throws Exception{
			  pagina("contenido_grupos_reversion_crear");	  
   }

    

  private void cargarPagina() throws Exception{
	  traza("asignamos los parametros de entrada");
	     
		String s1=(String)this.param.get("grupoReversion");
	   if (conectorParametroLimpia( "accion", "", true ).equals("")) {
			ArrayList aList = this.lista;
			traza("Proceso de actualizacion de solicitudes	 ");
			DTOAgregarSolicitudesGrupo dtoagregarsolicitudesgrupo = new DTOAgregarSolicitudesGrupo();
			dtoagregarsolicitudesgrupo.setListaSolicitudes(aList);
			dtoagregarsolicitudesgrupo.setGrupoReversion(s1);
			Object conn= this.obtenerDatosSalida("PEDAgregarSolicitudesGrupo","ConectorAgregarSolicitudesGrupo",(DTOAgregarSolicitudesGrupo)dtoagregarsolicitudesgrupo);
	   }

	 traza("Carga de combos");
		 DTOBelcorp dtobelcorp = new DTOBelcorp();
		 dtobelcorp.setOidIdioma(UtilidadesSession.getIdioma(this));
		 dtobelcorp.setOidPais(UtilidadesSession.getPais(this));
		
		 Object[] obj= new Object[4];
		 obj[0]=new String("PEDobtieneTiposSolicitudPorPais");
		 obj[1]=dtobelcorp;
		 obj[2]=new String("SEGConsultaSubaccesos");
		 obj[3]=dtobelcorp;
	 
		 ComposerViewElementList lista = this.crearParametrosEntrada(obj);
		 traza("a");
		 ConectorComposerView conector = new ConectorComposerView(lista,this.getRequest());
		 traza("b");
		 conector.ejecucion();
		 traza("c");
		 traza("Obtenemos el conector");
		 DruidaConector resultados = conector.getConector();
		traza("Vemos el resultado " +resultados.getXML());
		 traza("cargamos el combo");
		 asignar("COMBO","cbTipoSolicitud",resultados,"PEDobtieneTiposSolicitudPorPais");
		 asignar("COMBO","cbSubacceso",resultados,"SEGConsultaSubaccesos");

	traza("Carga el numero de solicitudes del grupo");
	         DTOEGrupoReversion dtoegruporeversion = new DTOEGrupoReversion();
			 dtoegruporeversion.setGrupoReversion(s1);
			 DTOSalida dtosalida = new DTOSalida();
			 
			  dtosalida = (DTOSalida) this.obtenerDatosSalida("PEDContarSolicitudesGrupo","ConectorContarSolicitudesGrupo",(DTOEGrupoReversion)dtoegruporeversion);
			 RecordSet num =  dtosalida.getResultado();
			 
             // DruidaConector salida = this.generarConector("DTOSalida.numero_ROWSET", num, colID);
			 //asignarAtributo("CTEXTO", "txtNumeroSolicitud", "valor", (String) num.getValueAt(0,0).toString());
		     asignarAtributo("VAR", "hNumSol", "valor", ((BigDecimal) num.getValueAt(0,0)).toString());
		     asignarAtributo("VAR", "grupoReversion", "valor", s1);
			 if(param.get("accion").equals("")){
				 
				  asignarAtributo("VAR", "lista", "valor",(String) param.get("listaSolicitudes"));
			 }else{
				asignarAtributo("VAR", "lista", "valor",(String) param.get("lista"));
			 }
			 
	 
  }

   private Object obtenerDatosSalida(String bID,String conector,Object dto)throws Exception{
			Object obj=null;
            traza("mi traza -----> " + bID + "     " + conector + "   " + dto);
			
				traza("entro a ObtenerDatos Salida");
                Vector objBussines = new Vector();
                MareBusinessID id = new MareBusinessID(bID);
                objBussines.add(dto);
                objBussines.add(id);
				traza("Asigno el facade");
                DruidaConector ver = conectar(conector,objBussines);
                obj = ver.objeto("DTOSalida");
				traza("ver DTOSalida" + obj.toString());
                
			  
		   return obj;
                   
  }

 private ComposerViewElementList crearParametrosEntrada(Object[]params)throws Exception{
	traza("Estoy en crearParametrosEntrada"  );
	traza("Arg 1 " +params[0].getClass().toString());
	traza("Args 2 " +params[1].getClass().toString());
	traza ("length " + params.length);
	 
	 ComposerViewElementList lista = new ComposerViewElementList();
	     ComposerViewElement elem1 = new ComposerViewElement();
		 ComposerViewElement elem2 = new ComposerViewElement();
	     elem1.setIDBusiness((String)params[0]);
		 elem1.setDTOE((DTOBelcorp)params[1]);
		 elem2.setIDBusiness((String)params[2]);
		 elem2.setDTOE((DTOBelcorp)params[3]);
		 lista.addViewElement(elem1);
	     lista.addViewElement(elem2);
	

	 return lista;
 }

 private void agregarSolicitudes()throws Exception{
 this.cargarPagina();
 traza("SolicitudesA");
  DTOAgregarSolicitudesCriterio dtoagregarsolicitudescriterio = new DTOAgregarSolicitudesCriterio();
  dtoagregarsolicitudescriterio.setGrupoReversion((String)param.get("grupoReversion"));
   traza("SolicitudesB");
  dtoagregarsolicitudescriterio.setOidTipoSolicitudPais(new Long(param.get("cbTipoSolicitud").toString()));
   traza("SolicitudesC");
   if(param.get("cSubac").toString()!="0" ){
       traza("enctro al if   cbSubacceso = " +  param.get("cbSubacceso")+ "  cSubac = " + param.get("cSubac")); 

       if(param.get("cbSubacceso")==null || param.get("cbSubacceso").toString().equals("") ){
 	       dtoagregarsolicitudescriterio.setOidSubacceso(null);  
	   }else{
   	       dtoagregarsolicitudescriterio.setOidSubacceso(new Long(param.get("cbSubacceso").toString()));
	   }
	   traza("klop");
	   asignarAtributo("VAR","cSubac","valor",param.get("cSubac").toString());
       traza("SOLP");
   }
   if(param.get("txtNumeroSolicitud")==null || param.get("txtNumeroSolicitud").toString().equals("") ){
 	     dtoagregarsolicitudescriterio.setNumeroSolicitud(null);  
	   }else{
   	        dtoagregarsolicitudescriterio.setNumeroSolicitud(param.get("txtNumeroSolicitud").toString());
	   }
  //dtoagregarsolicitudescriterio.setNumeroSolicitud(param.get("txtNumeroSolicitud").toString());


  traza("SolicitudesD");
  Object conn= this.obtenerDatosSalida("PEDAgregarSolicitudesCriterio","ConectorAgregarSolicitudesCriterio",(DTOAgregarSolicitudesCriterio)dtoagregarsolicitudescriterio);
  asignarAtributo("VAR","accion","valor","agregar");
  asignarAtributo("VAR","cTipoSolic","valor",param.get("cTipoSolic").toString());

  
  
  
	 
 }
/**
 * Parsea el argumento lista que recibe via http y lo coloca en 
 * el hashmap param para que este disponible como ArrayList
 */


  private void colaParametros(String s)throws Exception{

	String str = s;
	StringTokenizer tok = new StringTokenizer(str,",");
	//h_comboTipoCliente_0=1;h_comboTipoCliente_1=2;
	StringTokenizer tok1 = null;
	String clave=null;
	String valor=null;
	String elem;
	int dif=0;
	while (tok.hasMoreTokens()) {
         elem=tok.nextToken().toString();
		 traza("##############"+elem);
		 this.lista.add(new Long(elem));
		 dif++;
		 
		
	}
	traza(this.lista.toString());
  }

}
