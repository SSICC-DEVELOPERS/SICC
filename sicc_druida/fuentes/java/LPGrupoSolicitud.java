//utilidades sdk
import java.util.HashMap;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;
import java.util.StringTokenizer;
//utilidades Belcorp
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
//import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.xml.XMLDocument;
import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;

//Librerias CAR
import es.indra.sicc.dtos.car.DTOTiposSolicitudenGrupo;

//utilidades cmn
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

//Libreria Mare
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
//import LPSICCBase;

//librerias car
import es.indra.sicc.dtos.car.DTOGrupoSolicitud;

public class LPGrupoSolicitud extends LPSICCBase {
private HashMap param = new HashMap();
private HashMap oidTipoSolic = new HashMap();
private String caso = new String();
 
	
 public LPGrupoSolicitud () {super();}
 public void inicio() throws Exception {
		 pagina("contenido_grupos_solicitud_insertar");
		// this.getConfiguracionMenu();
    
  }

   public void ejecucion() throws Exception {
    setTrazaFichero();
    String accion = conectorParametro("accion");
    String casoDeUso = conectorParametro("casoDeUso");
    caso = conectorParametro("caso");
    traza("**************** caso " + caso);
    
	String i = conectorParametro("i");
	param=conectorParametro();
	accion = (accion==null )?"":accion;
	casoDeUso=(casoDeUso==null )?"":casoDeUso;
	i=(i==null )?"":i;
    setTrazaFichero();
    traza("Parametros de entrada" + param);
    traza("Entro a LP con accion = "+ accion);
    traza("El caso de Uso es " + casoDeUso);
    traza("Entro a LP con accion = "+ accion);
		try{
			
			 if(casoDeUso.equals("inserta")){
			    this.mostrarPantalla(casoDeUso);
				this.getConfiguracionMenu("LPGrupoSolicitud",casoDeUso);

				//cdos gPineda 09/08/06 - BELC300023917
				//this.anyadeHiddensI18N(true,"CAR_GRUPO_SOLIC",null,new Integer(1),"frmFormulario","txtDescripcion",false);

				this.cargarCampos(null,new Boolean(true));
				//asignarAtributo("COMBO","cbCodTipoSolicitud","multiple","N");
				 this.getConfiguracionMenu("LPGrupoSolicitud",casoDeUso);
				asignarAtributo("VAR","oidGrupoSol","valor","-1");
				asignarAtributo("VAR","casoDeUso","valor",casoDeUso);

				//cdos gPineda 09/08/06 - BELC300023917
				if( ! accion.equals("guardar") ){
					this.anyadeHiddensI18N(true,"CAR_GRUPO_SOLIC",null,new Integer(1),"frmFormulario","txtDescripcion",false);
				}
			 }
			  if(casoDeUso.equals("consulta")){
					 if(param.get("recargar")!=null){
						traza("recargar");
						asignarAtributo("VAR","recargar","valor","recargar");
					}
					this.mostrarPantalla(casoDeUso);
					this.getConfiguracionMenu("LPGrupoSolicitud",casoDeUso);
					asignarAtributo("PAGINA","contenido_grupos_solicitud_modificar","cod","0648");
					asignarAtributo("VAR","casoDeUso","valor",casoDeUso);
					this.cargarCampos(null,new Boolean(false));
			 }

			  if(casoDeUso.equals("elimina")){ 
				this.mostrarPantalla(casoDeUso);
				this.getConfiguracionMenu("LPGrupoSolicitud",casoDeUso);

				asignarAtributo("PAGINA","contenido_grupos_solicitud_modificar","cod","0649");
				asignarAtributo("VAR","casoDeUso","valor",casoDeUso);
				this.cargarCampos(null,new Boolean(false));				
				
				
			 }
			  if(casoDeUso.equals("modifica")){
			     
				this.mostrarPantalla(casoDeUso);
				this.getConfiguracionMenu("LPGrupoSolicitud",casoDeUso);
				if(param.get("recargar")!=null){
					traza("recargar");
					asignarAtributo("VAR","recargar","valor","recargar");
				}
				asignarAtributo("VAR","casoDeUso","valor",casoDeUso);
				this.cargarCampos(null,new Boolean(false));
				
			 }
			  if(accion.equals("modificaGrupo")){ 
				this.consultarGrupoSol(new Long(i),new Boolean(true),accion);
				
				//traza("el valor de i " + i);
				//this.cargarCampos(new Long(i),new Boolean(true));
			 }
			  if(accion.equals("detalleGrupo")){ 
				detalleGrupo(new Long(i));
				
				
			 }
			 if(accion.equals("guardar")){
				this.colaParametros();

				pagina("salidaGenerica");
				traza("salidaGenerica");

				this.guardarInsertar();

				 	traza("caso uso es " + casoDeUso);
					traza("accion  es " + accion);
				if(casoDeUso.equals("inserta") && accion.equals("guardar")){
						 this.preservaHiddensI18n(new Integer(1),"CAR_GRUPO_SOLIC","frmFormulario","txtDescripcion",false);
						 traza("antes de asignar atributo");
						 asignarAtributo("VAR", "ejecutar", "valor", "reload_insertar(true)");		 
				}
				/*
				if(param.get("rec")!=null){
					traza("Ejecuta recarga");
					this.recargar();
				}
				
				//this.cargarCampos(null,new Boolean(true));
				//recargarPantalla();
				
				*/
			 }

		 
		}catch (Exception ex) {
			
			if(casoDeUso.equals("inserta") && accion.equals("guardar")){
				 asignarAtributo("VAR", "ejecutar", "valor", "reload_insertar(false)");	
		    }
			this.traza("Error en ejecucion");
		   this.lanzarPaginaError(ex);

      }
   }

   private void mostrarPantalla(String accion)throws Exception{
  try{
		  if(accion.equals("inserta")){
			  pagina("contenido_grupos_solicitud_insertar");
			 
		  }
  
		  if(accion.equals("consulta")){
			
			 pagina("contenido_grupos_solicitud_modificar");
			 
	  
	 
		  }

		  if(accion.equals("elimina")){
			  pagina("contenido_grupos_solicitud_modificar");
	 
	  
		  }

		  if(accion.equals("modifica")){
			  
			   pagina("contenido_grupos_solicitud_modificar");
			   
	  
		  }
		 if(accion.equals("modificaGrupo")){
			  pagina("contenido_grupos_solicitud_insertar");
	  
		  }

		  if(accion.equals("detalleGrupo")){
			  pagina("contenido_grupos_solicitud_insertar");
	  
		  }

		  if(accion.equals("guarda")){
			 
			  
	  
		  }
   
	
	 }catch(Throwable th){
            this.traza("error en Mostrar Pantalla");
			if (accion.equals("guarda")){
				this.preservaHiddensI18n(new Integer(1),"CAR_GRUPO_SOLIC","frmFormulario","txtDescripcion",false);
				
			}
				  //printError(th);
                  throw((Exception) th);
       
           }     
  }
private void printError(Throwable th)throws Exception{
 
			ByteArrayOutputStream stack = new ByteArrayOutputStream();
            PrintStream out = new PrintStream(stack);
            th.printStackTrace(out);
            traza(  stack.toString());
            BelcorpError belcorpError = new BelcorpError();
            DTOError dtoError = belcorpError.obtenerError(	th, 
            UtilidadesSession.getIdioma_ISO( this ) , 
                                        ""	
                                      );
            String s = th.getMessage();
            traza (  dtoError.getCodigoError() + " - " + dtoError.getDescripcionError() );
			throw((Exception) th);
 
  }
 
	private void  cargarCampos(Long oidGrupSolicitud,Boolean TiposSolLibres)throws Exception{
	   
	     //Asignamos los parametros
		 traza("Entramos a cargarCampos con ");
		 if(oidGrupSolicitud==null){
			 traza("oidGrupSolicitud es null");
		 }else{
			traza("oidGrupSolicitud es " +oidGrupSolicitud.toString() ); 
		 }
			//Creamos los componentes
			DTOTiposSolicitudenGrupo dtosolgrp = new DTOTiposSolicitudenGrupo();
		traza("Cargamos los componentes");
			//Seteamos los parametros para la invocacion al Facade
			dtosolgrp.setOidGrupoSolicitud(oidGrupSolicitud);
			dtosolgrp.setTiposSolLibres(TiposSolLibres);
			dtosolgrp.setOidIdioma(this.utilidadesSession().getIdioma(this));
			
				ComposerViewElementList lista = this.crearParametrosEntrada("CARTiposSolicitudRelacionados",(DTOTiposSolicitudenGrupo)dtosolgrp);
				ConectorComposerView conector = new ConectorComposerView(lista,this.getRequest());
				conector.ejecucion();
				traza("Obtenemos el conector");
				DruidaConector resultados = conector.getConector();
				//traza("Vemos el resultado " +resultados.getXML());
				traza("cargamos el combo");
				asignar("COMBO","cbCodTipoSolicitud",resultados,"CARTiposSolicitudRelacionados");
				if(oidGrupSolicitud == null){
					asignarAtributo("VAR","oidGrupoSol","valor","0");
				}else{
					asignarAtributo("VAR","oidGrupoSol","valor",oidGrupSolicitud.toString());
				}
			
			
		
  }

  private void consultarGrupoSol(Long oidTipoSolicitud,Boolean modifica,String casoDeUso)throws Exception{
		traza("Entramos a consultarGrupoSol "+casoDeUso);

		traza("Tipo de solicitud: " + oidTipoSolicitud);

		DTOOID dtooid = new DTOOID(); 
		Vector vc = new Vector();
		Vector tSolic = null;
		StringBuffer TiposSolic= new StringBuffer();
		dtooid.setOid(oidTipoSolicitud);
		dtooid.setOidIdioma(this.utilidadesSession().getIdioma(this));
		DTOGrupoSolicitud dtoG=(DTOGrupoSolicitud)this.obtenerDatosSalida("CARGrupoSolicitudConsultar","CARConsultarGrupoSol",(DTOOID)dtooid);
		
		vc=dtoG.getAttriTraducible();
		
		DTOI18nSICC i18 =(DTOI18nSICC) vc.get(0);
		tSolic=dtoG.getTiposSolicitud();
		if(casoDeUso.equals("modificaGrupo")){
			//Cargamos los tipos solicitud recibidos
				for(int i=0;i<tSolic.size();i++){
					//TiposSolic=TiposSolic + tSolic.get(i).toString()+",";
					 TiposSolic.append(tSolic.get(i).toString());
					 TiposSolic.append(",");
					 
				}
			traza("parametros " + TiposSolic);	
			this.mostrarPantalla("inserta");
			this.getConfiguracionMenu("LPGrupoSolicitud",casoDeUso);
		    this.anyadeHiddensI18N(true,"CAR_GRUPO_SOLIC",dtoG.getOidGrupoSol(),new Integer(1),"frmFormulario","txtDescripcion",false);
			this.cargarCampos(dtoG.getOidGrupoSol(),new Boolean(true));
			asignarAtributo("VAR","accion","valor","modificaGrupo");
			asignarAtributo("VAR","oidGrupoSol","valor","" + dtoG.getOidGrupoSol());
			asignarAtributo("PAGINA","contenido_grupos_solicitud_insertar","cod","0647");
			asignarAtributo("VAR","oidGrupoSol","valor",dtoG.getOidGrupoSol().toString());
			asignarAtributo("VAR","lista","valor",TiposSolic.toString());
			asignarAtributo("VAR","rec","valor","rec");
		}else{
		    this.mostrarPantalla(casoDeUso);
			this.getConfiguracionMenu("LPGrupoSolicitud",casoDeUso);
			this.anyadeHiddensI18N(true,"CAR_GRUPO_SOLIC",dtoG.getOidGrupoSol(),new Integer(1),"frmFormulario","txtDescripcion",true);
			this.cargarCampos(dtoG.getOidGrupoSol(),new Boolean(false));
      if(caso.equals(new String("elimina"))) {
        traza("************ Titulo para Eliminar");
        asignarAtributo("PAGINA","contenido_grupos_solicitud_insertar","cod","0649");  
      }
      else {
        traza("************ Titulo para Consultar");
        asignarAtributo("PAGINA","contenido_grupos_solicitud_insertar","cod","0648");
      }
			
			traza("aaaa - 1");
			asignarAtributo("VAR","accion","valor",casoDeUso);
			traza("aaaa - 2");
			
			
		}
		traza(casoDeUso);
		asignarAtributo("CTEXTO","txtCodGrupoSolicitud","valor",dtoG.getCodGrupoSolicitud());
		traza("5");
		asignarAtributo("CTEXTO","txtDescripcion","valor",i18.getValorI18n());
		traza("6");
		
		
	  
	  
  }

  private UtilidadesSession utilidadesSession()throws Exception{
		
			UtilidadesSession sesion = new UtilidadesSession();
			 return sesion;
		
		 
  }

  private Object obtenerDatosSalida(String bID,String conector,Object dto)throws Exception{
			Object obj=null;
			try{
				traza("entro a ObtenerDatos Salida");

				traza("--- PARAMETROS ---");
				traza("BusinessID: " + bID);
				traza("conector: " + conector);
				traza("dto.class: " + dto.getClass().getName());
				traza("dto: " + dto.toString());
				traza("--- PARAMETROS ---");

                Vector objBussines = new Vector();
                MareBusinessID id = new MareBusinessID(bID);
                objBussines.add(dto);
                objBussines.add(id);
				traza("Asigno el facade");
                DruidaConector ver =conectar(conector,objBussines);
                obj = ver.objeto("DTOSalida");
				traza("ver DTOSalida" + obj.toString());
                
			}catch(Throwable th){
            this.traza("error en Obtener Datos Salida");
            this.printError(th);
       
           }  
		   return obj;
                   
  }

  private void guardarInsertar()throws Exception {		

	//cdos gPineda 04/08/06 - BELC300023917
	this.anyadeHiddensI18N(false,"CAR_GRUPO_SOLIC",null,new Integer(1),"frmFormulario","txtDescripcion",false);

	 DTOGrupoSolicitud dtoGSol= new DTOGrupoSolicitud();		
		Vector solicitudes = new Vector();

		for(int i=0;i<this.oidTipoSolic.size();i++){
      solicitudes.add((Long)this.oidTipoSolic.get("key"+i));
		}

		dtoGSol.setOidGrupoSol(new Long(param.get("oidGrupoSol").toString()) );
		dtoGSol.setCodGrupoSolicitud(param.get("txtCodGrupoSolicitud").toString());				  
	//solicitudes.add(new Long((String)param.get("cbCodTipoSolicitud")));
	  dtoGSol.setTiposSolicitud(solicitudes);
	  dtoGSol.setAttriTraducible(this.recuperaTraduccionesI18N(new Integer(1)));
	  dtoGSol.setPrograma(UtilidadesSession.getFuncion(this));
	  dtoGSol.setIpCliente(UtilidadesBelcorp.getIPCliente(this));	

		traza("******** Valor recuperaTraduccionesI18N " + this.recuperaTraduccionesI18N(new Integer(1)).toString());

    Vector traducciones = this.recuperaTraduccionesI18N(new Integer(1));

    for (int i=0; i<traducciones.size(); i++) {
      DTOI18nSICC dtoSicc = (DTOI18nSICC)traducciones.get(i);
      System.out.println("******** OID " + dtoSicc.getOidAtriuto().toString());
      System.out.println("******** VALOR " + dtoSicc.getValorI18n());      
    }
	 String casoDeUso = conectorParametro("casoDeUso");
	 casoDeUso=(casoDeUso==null )?"":casoDeUso;
			
		Object conn= this.obtenerDatosSalida("CARGrupoSolicitudGuardar","CARGuardarGrupoSol",(DTOGrupoSolicitud)dtoGSol);
	 
  }

  private ComposerViewElementList crearParametrosEntrada(String idBussis,Object DtoEntrada)throws Exception{
	  ComposerViewElementList lista = new ComposerViewElementList();
	  ComposerViewElement c1 = new ComposerViewElement();
	 
	  traza("Entro a crear parametros de entrada");
	  
	   c1.setIDBusiness(idBussis);
	   c1.setDTOE((DTOBelcorp)DtoEntrada);
	   lista.addViewElement(c1);
	   
		   traza("Vemos la lista "+ lista.toString());
	   return lista;
	   
  }

  private void recargarPantalla()throws Exception{
 
	  for(int i=0;i<=2;i++){
		  switch(i){
			  case 0:
				if(param.get("txtCodGrupoSolicitud")!=null){
					traza("Guardando Param1");
					asignarAtributo("CTEXTO","txtCodGrupoSolicitud","valor",param.get("txtCodGrupoSolicitud").toString());
				}
				case 1:
				if(param.get("txtDescripcion")!=null){
				    traza("Guardando Param2");
					asignarAtributo("CTEXTO","txtDescripcion","valor",param.get("txtDescripcion").toString());
				}
		  }
	  }
	  asignarAtributo("VAR","valCombo","valor",param.get("cbCodTipoSolicitud").toString());
	  
  }

  private void detalleGrupo(Long param)throws Exception{

	traza("entro a detalle grupo");

	traza("El valor de param es :"+param.toString());


    this.consultarGrupoSol(param,new Boolean(false),"detalleGrupo");

	traza("paso consultarGrupoSol");

	this.obtenerTiposSolicitud(param);

	traza("paso obtenerTiposSolicitud");


	traza("fin detalleGrupo");

  }

	private void obtenerTiposSolicitud(Long param) throws Exception {

		traza("entro a obtenerTiposSolicitud");

		Vector vc = null;
		Vector tSolic = null;
		StringBuffer TiposSolic = new StringBuffer();

		DTOOID dtooid = new DTOOID();
		dtooid.setOid(param);
		dtooid.setOidIdioma(this.utilidadesSession().getIdioma(this));

		DTOGrupoSolicitud dtoG = (DTOGrupoSolicitud)
			this.obtenerDatosSalida("CARGrupoSolicitudConsultar", 
			"CARConsultarGrupoSol", (DTOOID)dtooid);
		
		vc = dtoG.getAttriTraducible();
		
		DTOI18nSICC i18 = (DTOI18nSICC)vc.get(0);
		tSolic = dtoG.getTiposSolicitud();

		//Cargamos los tipos solicitud recibidos
		for (int i = 0; i < tSolic.size(); i++){
			//TiposSolic=TiposSolic + tSolic.get(i).toString()+",";
			TiposSolic.append(tSolic.get(i).toString());
			TiposSolic.append(",");
		}

		asignarAtributo("VAR", "lista", "valor", TiposSolic.toString());
	}

  private void colaParametros()throws Exception{

	String str = param.get("valorSeleccionado").toString();
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
		 this.oidTipoSolic.put((String)"key"+dif,new Long(elem));
		 dif++;
		 
		
	}
	traza(this.oidTipoSolic.toString());
  }
  private void recargar()throws Exception{
				this.mostrarPantalla("consulta");
				this.getConfiguracionMenu("LPGrupoSolicitud","consulta");
				asignarAtributo("PAGINA","contenido_grupos_solicitud_modificar","cod","0648");
				asignarAtributo("VAR","casoDeUso","valor","consulta");
				asignarAtributo("VAR","recargar","valor","recargar");
				this.cargarCampos(null,new Boolean(false));
	}
}
