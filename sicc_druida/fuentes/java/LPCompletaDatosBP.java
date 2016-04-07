/*
    $Id: LPCompletaDatosBP.java,v 1.5 2010/12/20 22:18:06 peextsapaza Exp $
    CasoUso: BusinessPlanning, MAV
    DESC
*/

//import LPSICCBase;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.mav.DTOBuscarCargaBP;
import es.indra.sicc.dtos.mav.DTOCargaBP;
import es.indra.sicc.dtos.mav.DTODetalleMAV;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesSession;


// Definicion de la clase
public class LPCompletaDatosBP extends LPSICCBase 
{
  // Pagina Completar Datos
  private Long oidCanal = null;
  private Long oidMarca = null;
  private Long oidActividadMAV = null;
  private Long oidPeriodo = null;
  private Long oidTipoCliente = null;
  
  private String descCanal = null;
  private String descMarca = null;
  private String descActividadMAV = null;
  private String descPeriodo = null;
  private String descTipoCliente = null;

    // Agregado por SICC20070356 - Rafael Romero - 05/09/2007
    public static final String CODIGO_CAMPO_VD_NEBP_ACCE     = "002";
    public static final String CODIGO_CAMPO_VD_NEBP_SUB_ACCE = "003";
    public static final String CODIGO_CAMPO_VD_NEBP_TIP_OFER = "004";
    public static final String CODIGO_CAMPO_VD_NEBP_TIP_CLIE = "005";
    public static final String CODIGO_CAMPO_VD_NEBP_SBT_CLIE = "006";
    public static final String CODIGO_CAMPO_VD_NEBP_CIC_VIDA = "007";
    public static final String CODIGO_CAMPO_VD_NEBP_CRI_ASIG = "008";
    public static final String CODIGO_CAMPO_VD_NEBP_TIP_DESP = "009";
    // Fin agregado SICC20070356

  public void inicio() throws Exception 
  {	
    	//pagina("contenido_datos_bp_completar");
      //this.getConfiguracionMenu();   
  }

 public void ejecucion() throws Exception
 {
     setTrazaFichero();
     this.rastreo();

    try
    {
       //this.prueba();
       traza(" ************ Entro a Ejecucion **************");       
       String accion = this.conectorParametroLimpia("accion", "", true);
       traza("Accion: " + accion);

       if (accion.equals("") )
       {
          this.pagina("contenido_datos_bp_completar");
          this.asignarAtributoPagina("cod", "0225");
          this.getConfiguracionMenu();
          // Falta agregar valores para sistema de validacion - SiCC 20070270
          this.getFormatosValidaciones();
          this.cargaInicial();
       }

       if (accion.equals("nueva") )
       {
          oidCanal = new Long( (String)this.conectorParametro("oidCanal") );
          oidMarca = new Long( (String)this.conectorParametro("oidMarca") );
          oidActividadMAV = new Long( (String) this.conectorParametro("oidActividad") );
          oidPeriodo = new Long( (String) this.conectorParametro("oidPeriodo") );
          oidTipoCliente = new Long( (String) this.conectorParametro("oidTipoCliente") );
          
          descCanal = (String)this.conectorParametro("descCanal");
          descMarca = (String)this.conectorParametro("descMarca");
          descActividadMAV = (String) this.conectorParametro("descActividad");
          descPeriodo = (String) this.conectorParametro("descPeriodo");
          descTipoCliente = (String) this.conectorParametro("descTipoCliente");
          
          this.pagina("contenido_datos_bp_detalle"); 
          this.asignarAtributoPagina("cod", "0271");
          this.asignarAtributo("CAPA", "capa2", "visibilidad", "hidden");
          this.asignarAtributo("CAPA", "capa3", "visibilidad", "visible");          
          this.getFormatosValidaciones();
          this.getConfiguracionMenu();
          traza("Asigna Labels");
          this.asignarAtributo("LABELC","lbldtPais","valor",UtilidadesSession.getDescripcionPais(this));          
          this.asignarAtributo("LABELC","lbldtMarca","valor", descMarca);                    
          this.asignarAtributo("LABELC","lbldtCanal","valor", descCanal);                              
          this.asignarAtributo("LABELC","lbldtActividad","valor", descActividadMAV);                                        
          this.asignarAtributo("LABELC","lbldtPeriodo","valor", descPeriodo);                                                  
          this.asignarAtributo("LABELC","lbldtTiposCliente","valor", descTipoCliente);  
          
          // Asigna Oids a VARs
          this.asignarAtributo("VAR", "varLblMarca", "valor", oidMarca.toString() );
          this.asignarAtributo("VAR", "varCanal", "valor", oidCanal.toString() );          
          this.asignarAtributo("VAR", "varActividad", "valor", oidActividadMAV.toString() );                    
          this.asignarAtributo("VAR", "varPeriodo", "valor", oidPeriodo.toString() );                              
          this.asignarAtributo("VAR", "varTipoCliente", "valor", oidTipoCliente.toString() );

          // Asigna Desc de cabecera a VARs (para luego usar en accion "nuevoDetalle")
          this.asignarAtributo("VAR", "varDescMarca", "valor", descMarca.toString() );
          this.asignarAtributo("VAR", "varDescCanal", "valor", descCanal.toString() );          
          this.asignarAtributo("VAR", "varDescActividad", "valor", descActividadMAV.toString() );                    
          this.asignarAtributo("VAR", "varDescPeriodo", "valor", descPeriodo.toString() );                              
          this.asignarAtributo("VAR", "varDescTipoCliente", "valor", descTipoCliente.toString() );          
          
          
          this.nueva(false);
       }

       if (accion.equals("nuevoDetalle"))
       {
          // Se encuentra en la pantalla contenido_datos_bp_detalle
          // Se deben tomar los valores de la cabecera para generar un nuevo Detalle.
          // El resto, es igual como si accion fuera "nueva".
          traza("Accion nuevoDetalle - Toma valores oid de la pagina");
          oidCanal = new Long( (String)this.conectorParametro("varCanal") );
          oidMarca = new Long( (String)this.conectorParametro("varLblMarca") );
          oidActividadMAV = new Long( (String) this.conectorParametro("varActividad") );
          oidPeriodo = new Long( (String) this.conectorParametro("varPeriodo") );
          oidTipoCliente = new Long( (String) this.conectorParametro("varTipoCliente") );

          descCanal = (String)this.conectorParametro("varDescCanal");
          traza("descCanal: " + descCanal);
          descMarca = (String)this.conectorParametro("varDescMarca");
          traza("descMarca: " + descMarca);          
          descActividadMAV = (String) this.conectorParametro("varDescActividad");
          traza("descActividadMAV: " + descActividadMAV);          
          descPeriodo = (String) this.conectorParametro("varDescPeriodo");
          traza("descPeriodo: " + descPeriodo);                    
          descTipoCliente = (String) this.conectorParametro("varDescTipoCliente");
          traza("descTipoCliente: " + descTipoCliente);                              
          
          this.pagina("contenido_datos_bp_detalle");  
          this.asignarAtributoPagina("cod", "0271");          
          this.getFormatosValidaciones();          
          this.getConfiguracionMenu();
          this.asignarAtributo("LABELC","lbldtPais","valor",UtilidadesSession.getDescripcionPais(this));          
          this.asignarAtributo("LABELC","lbldtMarca","valor", descMarca);                    
          this.asignarAtributo("LABELC","lbldtCanal","valor", descCanal);                              
          this.asignarAtributo("LABELC","lbldtActividad","valor", descActividadMAV);                                        
          this.asignarAtributo("LABELC","lbldtPeriodo","valor", descPeriodo);                                                  
          this.asignarAtributo("LABELC","lbldtTiposCliente","valor", descTipoCliente);       

          this.asignarAtributo("VAR", "varLblMarca", "valor", oidMarca.toString() );
          this.asignarAtributo("VAR", "varCanal", "valor", oidCanal.toString() );          
          this.asignarAtributo("VAR", "varActividad", "valor", oidActividadMAV.toString() );                    
          this.asignarAtributo("VAR", "varPeriodo", "valor", oidPeriodo.toString() );                              
          this.asignarAtributo("VAR", "varTipoCliente", "valor", oidTipoCliente.toString() );                                        

          // Asigna Desc de cabecera a VARs (para luego usar en accion "nuevoDetalle")
          this.asignarAtributo("VAR", "varDescMarca", "valor", descMarca.toString() );
          this.asignarAtributo("VAR", "varDescCanal", "valor", descCanal.toString() );          
          this.asignarAtributo("VAR", "varDescActividad", "valor", descActividadMAV.toString() );                    
          this.asignarAtributo("VAR", "varDescPeriodo", "valor", descPeriodo.toString() );                              
          this.asignarAtributo("VAR", "varDescTipoCliente", "valor", descTipoCliente.toString() );                    
          
          //this.nueva(true);  <-- Asi esta en el DMCO.
          this.nueva(false); // <-- Modificacion MIA.
       }

       if (accion.equals("detalle") )
       {
          String sOidDetalle = null;
          sOidDetalle = this.conectorParametroLimpia("oid", "", true); 
          traza("sOidDetalle: " + sOidDetalle);

          oidCanal = new Long( (String)this.conectorParametro("oidCanal") );
          oidMarca = new Long( (String)this.conectorParametro("oidMarca") );
          oidActividadMAV = new Long( (String) this.conectorParametro("oidActividad") );
          oidPeriodo = new Long( (String) this.conectorParametro("oidPeriodo") );
          oidTipoCliente = new Long( (String) this.conectorParametro("oidTipoCliente") );          

          descCanal = (String)this.conectorParametro("descCanal");
          traza("descCanal: " + descCanal);
          descMarca = (String)this.conectorParametro("descMarca");
          traza("descMarca: " + descMarca);
          descActividadMAV = (String) this.conectorParametro("descActividad");
          traza("descActividadMAV: " + descActividadMAV);
          descPeriodo = (String) this.conectorParametro("descPeriodo");
          traza("descPeriodo: " + descPeriodo);
          descTipoCliente = (String) this.conectorParametro("descTipoCliente");
          traza("descTipoCliente: " + descTipoCliente);
          
          
          this.pagina("contenido_datos_bp_detalle");   
          this.asignarAtributoPagina("cod", "0225");                    
          this.asignarAtributo("CAPA", "capa2", "visibilidad", "visible"); // Con boton Nueva Entrada
          this.asignarAtributo("CAPA", "capa3", "visibilidad", "hidden");          
          
          this.asignarAtributo("LABELC","lbldtActividad","valor", descActividadMAV);                                        
          this.asignarAtributo("VAR", "varActividad", "valor", oidActividadMAV.toString() );                              
          this.asignarAtributo("VAR", "varDescActividad", "valor", descActividadMAV.toString() );                              

          // Modificacion por incidencia 11056
          // by ssantana, 8/12/2004
          // Se quita el indicador REQ de los siguientes campos ya que en "detalle"
          // estarán deshabilitados.
          /*
           * Comentado por Rafael Romero
           * SiCC20070189 - 25/04/2007
           * En caso de detalle todos los datos seram modificables
           */
           /*
          this.asignarAtributo("COMBO", "cbPeriodoFin", "req", "N");
          this.asignarAtributo("AREATEXTO", "atxtObservaciones", "req", "N");          
          this.asignarAtributo("CTEXTO", "txtCodProducto", "req", "N");                    
          this.asignarAtributo("CTEXTO", "txtCodVenta", "req", "N");                              
          this.asignarAtributo("CTEXTO", "txtCodProducto", "req", "N");                              
          this.asignarAtributo("CTEXTO", "txtPrecioEstandar", "req", "N");                                        
          this.asignarAtributo("CTEXTO", "txtBaseDestinatarios", "req", "N");                                                  
          this.asignarAtributo("CTEXTO", "txtFactorCorreccion", "req", "N");                                                  
          this.asignarAtributo("CTEXTO", "txtPromedio", "req", "N");                                                            
          this.asignarAtributo("CTEXTO", "txtUnidades", "req", "N");                                                                      
          this.asignarAtributo("CTEXTO", "txtCriterio", "req", "N");                                                                                
           */
          this.getConfiguracionMenu();
          this.getFormatosValidaciones();          
          this.carga();
          this.detalle(sOidDetalle);
       }

       if (accion.equals("guardar") )
       {

         // this.obtieneValoresPaginaDetalle();
          this.pagina("contenido_datos_bp_detalle");
          this.asignarAtributoPagina("cod", "0225");                              
          this.getFormatosValidaciones();          
          this.getConfiguracionMenu();          
          this.guardar();
       }

        /*
         * Agregado para resolver incidencia SiCC20070189 - 23/04/2007
         * JVM-RRV
         */
       if (accion.equals("desactiva") )
       {
          String sOidDetalle = null;
          sOidDetalle = this.conectorParametroLimpia("oid", "", true); 
          traza("Accion DesActiva, sOidDetalle: " + sOidDetalle);
          this.desActiva(sOidDetalle);
       }
        /*
         * fin agregar
         */
	    if(accion.equals("desProducto")){
				this.traza("7777777LPCompletaDatosBP.desProducto(): Entrada");

				pagina("salidaGenerica");
				try{
					String codigoProducto = conectorParametroLimpia("txtCodProducto", "", true);
					String oidProd = null;
					String desProducto= null;
					traza("7777777codigoProducto: " + codigoProducto);
					Long  idioma = UtilidadesSession.getIdioma(this);
					Long  pais =  UtilidadesSession.getPais(this);

					DTODetalleMAV dtoP = new DTODetalleMAV();
					dtoP.setOidPais(pais);
					dtoP.setOidIdioma(idioma);
					dtoP.setProdCodSAP(new String(codigoProducto));
					MareBusinessID businessID = new MareBusinessID("MAVObtenerProducto");
					
					Vector para = new Vector(); 
					para.add(dtoP);
					para.add(businessID);
					
					traza("7777777777 Antes de conectar");
					DruidaConector dc =	conectar("ConectorObtenerProducto", para);
					traza("777777777 Despues de conectar");

					DTOSalida dtoSalida = (DTOSalida)dc.objeto("DTOSalida");
					RecordSet rs = dtoSalida.getResultado(); 							
					traza("rs: " + rs);
					
					
					oidProd   =  ((BigDecimal)rs.getValueAt(0,"VAL_OID")).toString();
					desProducto = (String)rs.getValueAt(0,"VAL_I18N");			  
					
					traza("77777777oidProducto: " + oidProd);
					traza("77777777desProducto: " + desProducto);
					//asignarAtributo("VAR", "oidProducto", "valor", oidProd);
					//asignarAtributo("VAR", "desProducto", "valor", desProducto);
					asignarAtributo("VAR", "cerrarVentana", "valor", "false");
					asignarAtributo("VAR", "ejecutar", "valor", "fverProducto('" + this.replace(desProducto,"'", " ") + "');");  
					this.traza("7777777LPCompletaDatosBP.desProducto(): Salida");
				}catch(Exception e){
					traza("777777777 Entrando al Catch");
					asignarAtributo("VAR", "ejecutarError", "valor", "fBuscarErr()");
					throw e;
				}	



			}	


	
	 } catch (Exception ex)	{
			 this.lanzarPaginaError(ex);    
			 this.traza("Error en ejecucion");
			 logStackTrace(ex);

    }


 }

 private void cargaInicial() throws Exception
 {
      traza("---------- cargaInicial ----------");

     // prueba();
      ComposerViewElementList cListCarga = this.preparaCargaInicial();
      
      ConectorComposerView conector = new ConectorComposerView(cListCarga, this.getRequest());
      traza("Antes de conectar");
      conector.ejecucion();
      traza("Luego de conectar");
      traza("Antes de obtener Conector");
      DruidaConector conPantalla = conector.getConector();
      traza("Luego de obtener Conector");

      traza("Asignando combos...");
      asignar("COMBO", "cbCanal", conPantalla, "SEGConsultaCanales"); 
      asignar("COMBO", "cbMarca", conPantalla, "SEGConsultaMarcas"); 
      traza("Combos asignados !!!!!!!!!!!!!!");
      
      asignarAtributo("LABELC","lbldtPais","valor",UtilidadesSession.getDescripcionPais(this));      
      
      asignarAtributo("VAR", "hidIdioma", "valor", UtilidadesSession.getIdioma(this).toString() );
      asignarAtributo("VAR", "hidPais", "valor", UtilidadesSession.getPais(this).toString() );

      traza("------ Saliendo de cargaInicial -------");
 }
 	public static String replace(String s, String s1, String s2){  

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
 
 /*
  * [1] Se agrega instrucciones para establecer valor de variable EstadoProceso
  */
 private void detalle(String sOidDetalle) throws Exception
 {
    // Obtiene a partir del OID, el Detalle y lo manda a la pagina.
   traza("--- AccionDetalle ---");

   DTOOID dtoOid = new DTOOID();
   MareBusinessID bussId = new MareBusinessID("MAVObtieneDetalleMAV"); 
   Vector params = new Vector();

   // TODO: Ver que matchee el nombre de esta variable con el de la pantalla
   // de JP.
   
   Long oid = new Long(sOidDetalle);

   dtoOid.setOid(oid);
   dtoOid.setOidIdioma(UtilidadesSession.getIdioma(this));
   dtoOid.setOidPais(UtilidadesSession.getPais(this));
   dtoOid.setPrograma(UtilidadesSession.getFuncion(this));
   dtoOid.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
   
   params.add(dtoOid);   
   params.add(bussId);

   traza("Antes de conectar");
   DruidaConector con = this.conectar("ConectorObtieneDetalleMAV", params);
   traza("Despues de conectar");

   DTODetalleMAV dtoMav = (DTODetalleMAV) con.objeto("dtoSalida");
   
   // Toma los datos del DTO y los muestra en pantalla

   // Pais (de Sesion)
   traza("Toma oid");
   Long oidDetalle = dtoMav.getOid();
   asignarAtributo("VAR", "varOid", "valor", oidDetalle.toString());
   
   traza("Toma Pais");
   String textoPais = UtilidadesSession.getDescripcionPais(this);
   asignarAtributo("LABELC", "lbldtPais", "valor", textoPais);


   // Marca 
   traza("Toma Marca");
   String textoMarca = dtoMav.getTextoMarca();
   asignarAtributo("LABELC", "lbldtMarca", "valor", textoMarca);
   oidMarca = dtoMav.getMarca();
   asignarAtributo("VAR", "varLblMarca", "valor", oidMarca.toString() );
   this.asignarAtributo("VAR", "varDescMarca", "valor", textoMarca.toString() );
   
   // Canal
   traza("Toma Canal");   
   String textoCanal = dtoMav.getTextoCanal();
   asignarAtributo("LABELC", "lbldtCanal", "valor", textoCanal);
   oidCanal = dtoMav.getCanal();
   asignarAtributo("VAR", "varCanal", "valor", oidCanal.toString() );
   this.asignarAtributo("VAR", "varDescCanal", "valor", textoCanal.toString() );             


   // Actividad
   traza("Toma Actividad");   
   String textoActividad = dtoMav.getTextoActividad();
   // Si no hay Texto Actividad (puede pasar si el Detalle se cargó de MAV_BPS_INTER)
   // no se setea nada ya que se ha cargado la actividad de la pantalla anterior
   // en el método "ejecucion"
   if ( textoActividad != null && !textoActividad.equals("") )
   {
     asignarAtributo("LABELC", "lbldtActividad", "valor", textoActividad);
     oidActividadMAV = dtoMav.getActividad();
     asignarAtributo("VAR", "varActividad", "valor", oidActividadMAV.toString() );
     this.asignarAtributo("VAR", "varDescActividad", "valor", textoActividad.toString() );                       
   }

   // Período
   traza("Toma Periodo");   
   String textoPeriodo = dtoMav.getTextoPeriodo();
   asignarAtributo("LABELC", "lbldtPeriodo", "valor", textoPeriodo);
   oidPeriodo = dtoMav.getPeriodo();
   asignarAtributo("VAR", "varPeriodo", "valor", oidPeriodo.toString() );
   this.asignarAtributo("VAR", "varDescPeriodo", "valor", textoPeriodo.toString() );                                 

   // Tipo Cliente
   traza("Toma Tipo Cliente");   
   String textoTipoClien = dtoMav.getTextoTipoCliente();
   asignarAtributo("LABELC", "lbldtTiposCliente", "valor", textoTipoClien);
   oidTipoCliente = dtoMav.getTipoCliente();
   asignarAtributo("VAR", "varTipoCliente", "valor", oidTipoCliente.toString() );
   this.asignarAtributo("VAR", "varDescTipoCliente", "valor", textoTipoClien.toString() );                             
   
   // Subgerencia
   traza("Toma Subgerencia");   
   StringBuffer sBuffer = new StringBuffer("");
   Long[] subG = dtoMav.getSubgerencias();
   if (subG != null)  // Puede ser NULL si el Detalle se cargo de MAV_BPS_INTER
     asignarAtributo("VAR", "varSubgerencia", "valor", parseaArray(subG) );
   else
     asignarAtributo("VAR", "varSubgerencia", "valor", "" );

   // Region
   traza("Toma Regiones");   
   sBuffer = new StringBuffer("");
   Long[] region = dtoMav.getRegiones();
   if ( region != null)
     asignarAtributo("VAR", "varRegion", "valor", parseaArray(region) );   
   else
     asignarAtributo("VAR", "varRegion", "valor", "" );      
    
   // Zona
   traza("Toma Zona");   
   sBuffer = new StringBuffer("");
   Long[] zona = dtoMav.getZonas();
   if ( zona != null)
     asignarAtributo("VAR", "varZona", "valor", parseaArray(zona) );   
   else
     asignarAtributo("VAR", "varZona", "valor", "" );   
     
   // Unidades x Region/Zona
   traza("Toma Unidades x Region/Zona");   
   StringBuffer sBufferUnidades = new StringBuffer("");
   Map unidadesRegionZona = dtoMav.getUnidadesRegionZona();
   if(unidadesRegionZona!=null) {
	   Iterator it = unidadesRegionZona.keySet().iterator();
	   int totalElementos = 0;
	   while(it.hasNext()) {
		   String claveUA = (String)it.next();
		   
		   if(unidadesRegionZona.get(claveUA)!=null)
			   claveUA = claveUA + "_" + unidadesRegionZona.get(claveUA).toString();
		   else
			   claveUA = claveUA + "_NULL";
		   
		   if(totalElementos == 0)
			   sBufferUnidades.append(claveUA);
		   else
			   sBufferUnidades.append("|").append(claveUA);
		   
		  totalElementos = totalElementos + 1;
	   }
   }
   
   asignarAtributo("VAR", "varListaUnidades", "valor", sBufferUnidades.toString() );  
   
   // Observaciones
   traza("Toma Observaciones");   
   if (dtoMav.getObservaciones() != null)
     asignarAtributo("VAR", "varObservaciones", "valor", dtoMav.getObservaciones());
   else
     asignarAtributo("VAR", "varObservaciones", "valor", "");

   // SubTipo Cliente
   traza("Toma Subtipo Cliente");
   Long[] subTipo = dtoMav.getSubtiposCliente();
   if (dtoMav.getSubtiposCliente() != null)
     asignarAtributo("VAR", "varSubtipoCliente", "valor", parseaArray(subTipo) );   
   else
     asignarAtributo("VAR", "varSubtipoCliente", "valor", "");   

   // Tipo Clasificacion Cliente
   traza("Toma TipoClasificacion");   
   Long[] tipoClasificacion = dtoMav.getTiposClasificacion(); // sapaza -- PER-SiCC-2010-0628 -- 20/10/2010
   if ( tipoClasificacion != null )
     asignarAtributo("VAR", "varTipoClasificacionCliente", "valor", parseaArray(tipoClasificacion) );
   else
     asignarAtributo("VAR", "varTipoClasificacionCliente", "valor", "");

  // Clasificacion Cliente
  traza("Toma Clasificacion");
  Long[] clasificacion = dtoMav.getClasificaciones(); // sapaza -- PER-SiCC-2010-0628 -- 20/10/2010
  if ( clasificacion != null )
    asignarAtributo("VAR", "varClasificacionCliente", "valor", parseaArray(clasificacion) ); 
  else
    asignarAtributo("VAR", "varClasificacionCliente", "valor", "");

  // sapaza -- PER-SiCC-2010-0674 -- 29/11/2010
  traza("Toma Tipo Cliente Criterio");
  Long tipoClienteCriterio = dtoMav.getTipoClienteCriterio();
  if (tipoClienteCriterio != null)
    asignarAtributo("VAR", "varTipoClienteCriterio", "valor", tipoClienteCriterio.toString());   
  else
    asignarAtributo("VAR", "varTipoClienteCriterio", "valor", "");
  
  traza("Toma Subtipo Cliente Criterio");
  Long subtipoClienteCriterio = dtoMav.getSubTipoCliente();
  if (subtipoClienteCriterio != null)
    asignarAtributo("VAR", "varSubtipoClienteCriterio", "valor", subtipoClienteCriterio.toString());   
  else
    asignarAtributo("VAR", "varSubtipoClienteCriterio", "valor", "");

  traza("Toma TipoClasificacion Criterio");
  Long tipoClasificacionClienteCriterio = dtoMav.getTipoClasificacion();
  if (tipoClasificacionClienteCriterio != null)
    asignarAtributo("VAR", "varTipoClasificacionClienteCriterio", "valor", tipoClasificacionClienteCriterio.toString());   
  else
    asignarAtributo("VAR", "varTipoClasificacionClienteCriterio", "valor", "");
  
  traza("Toma Clasificacion Criterio");
  Long clasificacionClienteCriterio = dtoMav.getClasificacion();
  if (clasificacionClienteCriterio != null)
    asignarAtributo("VAR", "varClasificacionClienteCriterio", "valor", clasificacionClienteCriterio.toString());   
  else
    asignarAtributo("VAR", "varClasificacionClienteCriterio", "valor", "");

  
  
  // Estado
  traza("Toma Estado");
  Long estado = dtoMav.getEstadoMAV();
  if ( estado != null)
    asignarAtributo("VAR", "varEstado", "valor", estado.toString() );
  else
    asignarAtributo("VAR", "varEstado", "valor", "");

        /*
         * [1]
         * Agregado por Rafael Romero
         * SiCC 20070189 - 23/04/2007
         */
        Long estadoProceso = dtoMav.getEstadoProceso();
        UtilidadesLog.debug("Estado Proceso ["+estadoProceso+"]");
        if(estadoProceso!=null){
            asignarAtributo("VAR", "varEstadoProceso", "valor", estadoProceso.toString() );
        } else {
            asignarAtributo("VAR", "varEstadoProceso", "valor", "" );
        }
        /*
         * Fin Agregado [1]
         */

  // Criterio de Asignacion
  traza("Toma Criterio Asignacion");  
  Long criterioAsig = dtoMav.getCriterioAsignacion();
  if (criterioAsig != null)
    asignarAtributo("VAR", "varCriterioAsig", "valor", criterioAsig.toString() );
  else
    asignarAtributo("VAR", "varCriterioAsig", "valor", "" );

  // Acceso 
  traza("Toma Acceso");
  Long[] acceso = dtoMav.getAccesos();
  if (acceso != null)
    asignarAtributo("VAR", "varAcceso", "valor", parseaArray(acceso) ); 
  else  
    asignarAtributo("VAR", "varAcceso", "valor", ""); 

  // SubAcceso
  traza("Toma Subacceso");
  Long subAcceso[] = dtoMav.getSubaccesos();
  if (subAcceso != null)
    asignarAtributo("VAR", "varSubacceso", "valor", parseaArray(subAcceso) );
  else
    asignarAtributo("VAR", "varSubacceso", "valor", "" );

  // Periodo Fin
  traza("Toma Periodo Fin");
  Long periodoFin = dtoMav.getPeriodoFin();
  if (periodoFin != null)
    asignarAtributo("VAR", "varPeriodoFin", "valor", periodoFin.toString() );
  else
    asignarAtributo("VAR", "varPeriodoFin", "valor", "");

  // Tipo Oferta
  traza("Toma Tipo Oferta");
  Long tipoOferta = dtoMav.getTipoOferta();
  if (tipoOferta != null)
    asignarAtributo("VAR", "varTipoOferta", "valor", tipoOferta.toString() );
  else
    asignarAtributo("VAR", "varTipoOferta", "valor", "");

  // Ciclo Vida
  traza("Toma Ciclo Vida");
  Long cicloVida = dtoMav.getCicloVida();
  if (cicloVida != null)
    asignarAtributo("VAR", "varCicloVida", "valor", cicloVida.toString() );
  else
    asignarAtributo("VAR", "varCicloVida", "valor", "" );

  // Modificado por ssantana, 28/11/2004
  // Ahora se muestra el codigo SAP asi que tomo Cod SAP de dto.
  // Cod. Producto
  traza("Toma Codigo Producto");
  String codigoSAP = dtoMav.getProdCodSAP();
  if ( codigoSAP != null)
    asignarAtributo("VAR", "varCodProducto", "valor", codigoSAP.toString() );  
  else
    asignarAtributo("VAR", "varCodProducto", "valor", "" );
    
	String desProducto = dtoMav.getDesProducto();
	if(desProducto != null)
		asignarAtributo("LABELC", "lblDesProducto", "valor", desProducto.toString());
	else 
	   asignarAtributo("LABELC", "lblDesProducto", "valor", "");	
/*  Long codigoProducto = dtoMav.getProducto();
  if (codigoProducto != null)
    asignarAtributo("VAR", "varCodProducto", "valor", codigoProducto.toString() );
  else
    asignarAtributo("VAR", "varCodProducto", "valor", "" );*/

  // Codigo Venta
  // Modificado por ssantana, 28/11/2004
  // Ahora se muestra el codigo de venta y no Oid, 
  // asi que tomo Cod Venta de dto.getSCodigoVenta()
  
  
  // Modificado por Inc. BELC300015618, 1/8/2005, ssantana
  // Se quita Codigo de Venta de este caso de uso
  /*traza("Toma Codigo Venta - Descripcion");
  String sCodigoVenta = dtoMav.getSCodigoVenta();
  if (sCodigoVenta != null)
    asignarAtributo("VAR", "varCodVenta", "valor", sCodigoVenta.toString() );
  else
    asignarAtributo("VAR", "varCodVenta", "valor", "" );
    
    
  traza("Toma Codigo Venta - Oid");    
  Long oidCodigoVenta = dtoMav.getCodigoVenta();
  if (oidCodigoVenta != null)
    asignarAtributo("VAR", "varCodVentaOid", "valor", oidCodigoVenta.toString() );
  else
    asignarAtributo("VAR", "varCodVentaOid", "valor", "" );*/
  // Fin Modificacion por Inc. BELC300015618, 1/8/2005, ssantana
  // Se quita Codigo de Venta de este caso de uso
  
/*  Long codigoVenta = dtoMav.getCodigoVenta();
  if (codigoVenta != null)
    asignarAtributo("VAR", "varCodVenta", "valor", codigoVenta.toString() );
  else
    asignarAtributo("VAR", "varCodVenta", "valor", "" );*/


  // Precio Estandar
  traza("Toma Precio Estandar");
  Double precioEstandar = dtoMav.getPrecioEstandar();
  if (precioEstandar != null) {
    String sPrecioEstandar = formateaMonto(precioEstandar.toString()); // sapaza -- PER-SiCC-2010-0578 -- 06/10/2010
    asignarAtributo("VAR", "varPrecioEstandar", "valor", sPrecioEstandar );
  }
  else {
    asignarAtributo("VAR", "varPrecioEstandar", "valor", "");
  }

  // Precio
  traza("Toma Precio");
  Double precio = dtoMav.getPrecio();
  if (precio != null){
    String sPrecio = formateaMonto(precio.toString());   // sapaza -- PER-SiCC-2010-0578 -- 06/10/2010
    asignarAtributo("VAR", "varPrecio", "valor", sPrecio );
  }
  else{
    asignarAtributo("VAR", "varPrecio", "valor", "");
  }

  // Precio Contable
  traza("Toma Precio Contable");
  Double precioContable = dtoMav.getPrecioContable();
  if ( precioContable != null){
    String sPrecioContable = formateaMonto(precioContable.toString()); // sapaza -- PER-SiCC-2010-0578 -- 06/10/2010
    asignarAtributo("VAR", "varPrecioContable", "valor", sPrecioContable );
  }
  else {
    asignarAtributo("VAR", "varPrecioContable", "valor", "" );
  }

  // Base Destinatarios
  traza("Toma Base Destinatarios");
  Long baseDestinatarios = dtoMav.getBaseEstimadosDestinatarios();
  if (baseDestinatarios != null)
    asignarAtributo("VAR", "varBaseDestinatarios", "valor", baseDestinatarios.toString() );
  else
    asignarAtributo("VAR", "varBaseDestinatarios", "valor", "");

  // Factor Correccion
  traza("Toma Factor Correccion");
  Double factorCorreccion = dtoMav.getFactorCorreccion();
  if ( factorCorreccion != null){
    String sFactorCorreccion = UtilidadesBelcorp.formateaNumeroSICC(factorCorreccion.toString(), LPSICCBase.FORMATO_DEFAULT, this);  
    asignarAtributo("VAR", "varFactorCorreccion", "valor", sFactorCorreccion );
  }
  else
    asignarAtributo("VAR", "varFactorCorreccion", "valor", "" );

  // Factor Promedio
  traza("Toma Promedio (Unidades Estimadas)");
  String sUEstimadas = "";
  try{
    BigDecimal uEstimadas = dtoMav.getUnidadesEstimadas();
    if ( uEstimadas != null)
    {
      System.out.println("Formatea UEstimadas");
      sUEstimadas = UtilidadesBelcorp.formateaNumeroSICC(uEstimadas.toString(), LPSICCBase.FORMATO_DEFAULT, this);  
      asignarAtributo("VAR", "varUEstimadas", "valor", sUEstimadas );
    }
    else{
    traza("NULL");
      asignarAtributo("VAR", "varUEstimadas", "valor", "" );
    }

    traza("PASO UNIDADES ESTIMADAS");    
  } catch (Exception ex)
  {
    ex.printStackTrace();
  }
  // Unidades (Campo de XML)
  traza("Toma Unid. Totales Estimadas (Campo XML 'Unidades')");
  Long uTotalesEstimadas = dtoMav.getUnidadesTotalesEstimadas();
  if (uTotalesEstimadas != null )
    asignarAtributo("VAR", "varUTotalesEstimadas", "valor", uTotalesEstimadas.toString() );
  else
    asignarAtributo("VAR", "varUTotalesEstimadas", "valor", "" );
  
  // Criterio
  traza("Toma Criterio");
  String criterio = dtoMav.getCriterio();
  if (criterio != null)
    asignarAtributo("VAR", "varCriterio", "valor", criterio );
  else
    asignarAtributo("VAR", "varCriterio", "valor", "" );

  
  /*
   * Cambio ssantana, 24/11/2005, inc. 21444. 
   * Ya no se levanta mas Forma de Cobro o Forma de Pago, ya que se toman
   * de la Actividad. 
   */
  // Forma Cobro 
  /*traza("Toma Forma Cobro");
  Long formaCobro = dtoMav.getFormaCobro();
  if ( formaCobro != null)
    asignarAtributo("VAR", "varFormaCobro", "valor", formaCobro.toString() );
  else
    asignarAtributo("VAR", "varFormaCobro", "valor", "" );

  // Forma Pago
  traza("Toma Forma Pago");
  Long formaPago = dtoMav.getFormaPago();
  if (formaPago != null)
    asignarAtributo("VAR", "varFormaPago", "valor", formaPago.toString() );
  else
    asignarAtributo("VAR", "varFormaPago", "valor", "" );
  */
  // Fin Cambio ssantana, 24/11/2005, inc. 21444. 

  // Tipo Despacho 
  traza("Toma Tipo Despacho");
  Long tipoDespacho = dtoMav.getTipoDespacho();
  if ( tipoDespacho != null)
    asignarAtributo("VAR", "varTipoDespacho", "valor", tipoDespacho.toString() );
  else
    asignarAtributo("VAR", "varTipoDespacho", "valor", "" );

  // Envio con Solicitud
/*  traza("Toma Envio Con Solicitud");
  Long indicadorEnvio = dtoMav.getIndicadorEnvio();
  if ( indicadorEnvio != null )
    asignarAtributo("VAR", "varEnvioSolicitud", "valor", indicadorEnvio.toString() );    
  else
    asignarAtributo("VAR", "varEnvioSolicitud", "valor", "" );    */

  // Enviar Mensaje
  traza("Toma Enviar Mensaje");
  Boolean enviarMensaje = dtoMav.getEnviarMensaje();
  if (enviarMensaje != null){
    traza("enviarMensaje.toString(): " + enviarMensaje.toString() );
    asignarAtributo("VAR", "varRadioMensaje", "valor", enviarMensaje.toString() );
  }
  else
  {
    traza("Enviar Mensaje es nulo");
    asignarAtributo("VAR", "varRadioMensaje", "valor", "");
  }

  // Enviar ExclusionTipoClasificacion
  traza("Toma Enviar Mensaje");
  Boolean indExclusionTipoClasificacion = dtoMav.getIndExclusionTipoClasificacion();
  if (enviarMensaje != null){
    traza("indExclusionTipoClasificacion.toString(): " + indExclusionTipoClasificacion.toString() );
    asignarAtributo("VAR", "varRadioExclusionTipoClasificacion", "valor", indExclusionTipoClasificacion.toString() );
  }
  else
  {
    traza("Enviar ExclusionTipoClasificacion es nulo");
    asignarAtributo("VAR", "varRadioExclusionTipoClasificacion", "valor", "");
  }

  // Codigo Mensaje 
  traza("Codigo Mensaje");
  Long mensaje = dtoMav.getMensaje();
  if (mensaje != null)
    asignarAtributo("VAR", "varMensaje", "valor", mensaje.toString() );
  else
    asignarAtributo("VAR", "varMensaje", "valor", "" );

  // Caso de Uso
  traza("Caso de Uso");
  asignarAtributo("VAR", "casoUso", "valor", "detalle");

  traza(" ------- Campos ocultos -------");
  traza("Toma Lista Clientes");
  Long listaClientes = dtoMav.getListaClientes();
  if (listaClientes != null)
    asignarAtributo("VAR", "varListaCliente", "valor", listaClientes.toString() );
  else
    asignarAtributo("VAR", "varListaCliente", "valor", "");

  traza("Toma Edad Desde");
  Long edadDesde = dtoMav.getEdadDesde();
  if (edadDesde != null)
    asignarAtributo("VAR", "varEdadDesde", "valor", edadDesde.toString() );
  else
    asignarAtributo("VAR", "varEdadDesde", "valor", "");

  traza("Toma Edad Hasta");
  Long edadHasta = dtoMav.getEdadHasta();
  if (edadHasta != null)
    asignarAtributo("VAR", "varEdadHasta", "valor", edadHasta.toString() );
  else
    asignarAtributo("VAR", "varEdadHasta", "valor", "");

  traza("Toma PeriodoCurso");
  Long periodoCurso = dtoMav.getPeriodoCurso();
  if ( periodoCurso != null)
    asignarAtributo("VAR", "varPeriodoCurso", "valor", periodoCurso.toString() );
  else
    asignarAtributo("VAR", "varPeriodoCurso", "valor", "");

  traza("Toma Periodo Inicio Monto");
  Long periodoInicioMonto = dtoMav.getPeriodoIniMonto();
  if ( periodoInicioMonto != null)
    asignarAtributo("VAR", "varPeriodoDesde", "valor", periodoInicioMonto.toString() );
  else
    asignarAtributo("VAR", "varPeriodoDesde", "valor", "" );

  traza("Toma Periodo Fin Monto");
  Long periodoFinMonto = dtoMav.getPeriodoFinMonto();
  if ( periodoFinMonto != null)
    asignarAtributo("VAR", "varPeriodoHasta", "valor", periodoFinMonto.toString() );
  else
    asignarAtributo("VAR", "varPeriodoHasta", "valor", "");

  traza("Toma Numero Aniversario");
  String numAniversario = dtoMav.getNumeroAniversario();
  if ( numAniversario != null)
    asignarAtributo("VAR", "varNumeroAniversario", "valor", numAniversario );
  else
    asignarAtributo("VAR", "varNumeroAniversario", "valor", "");

  traza("Toma Subcriterio");
  Long subCriterio = dtoMav.getSubcriterio();
  if (subCriterio != null)
    asignarAtributo("VAR", "varSubcriterio", "valor", subCriterio.toString() );
  else
    asignarAtributo("VAR", "varSubcriterio", "valor", "");

  traza("Toma Monto");
  Double monto = dtoMav.getMonto();
  if (monto != null)
    asignarAtributo("VAR", "varMonto", "valor", monto.toString() );
  else
    asignarAtributo("VAR", "varMonto", "valor", "");

  traza("Toma Periodo Desde");
  Long perioDesde = dtoMav.getPeriodoIniMonto();
  if (perioDesde != null)
    asignarAtributo("VAR", "varPeriodoDesde", "valor", perioDesde.toString() );
  else  
    asignarAtributo("VAR", "varPeriodoDesde", "valor", "");

  traza("Toma Periodo Hasta");
  Long perioHasta = dtoMav.getPeriodoFinMonto();
  //Long perioHasta = dtoMav.getPeriodoIniMonto();
  if (perioHasta != null)
    asignarAtributo("VAR", "varPeriodoHasta", "valor", perioHasta.toString() );
  else  
    asignarAtributo("VAR", "varPeriodoHasta", "valor", "");  

  traza("Toma Marca Criterio");
  Long marcaCriterio = dtoMav.getMarcaCondicion();
  if ( marcaCriterio != null)
    asignarAtributo("VAR", "varMarcaCriterio", "valor", marcaCriterio.toString() );
  else
    asignarAtributo("VAR", "varMarcaCriterio", "valor", "");  

  traza("Toma Catalogo");
  Long catalogo = dtoMav.getCatalogo();
  if ( catalogo != null)
    asignarAtributo("VAR", "varCatalogo", "valor", catalogo.toString() );
  else
    asignarAtributo("VAR", "varCatalogo", "valor", "" );

  traza("Toma Unidad de Negocio");
  Long uNegocio = dtoMav.getUnidadNegocio();
  if ( uNegocio != null)
    asignarAtributo("VAR", "varUnidadNegocio", "valor", uNegocio.toString() );
  else
    asignarAtributo("VAR", "varUnidadNegocio", "valor", "" );
  
  traza("Toma Negocio");
  Long negocio = dtoMav.getNegocio();
  if (negocio != null)
    asignarAtributo("VAR", "varNegocio", "valor", negocio.toString() );
  else
    asignarAtributo("VAR", "varNegocio", "valor", "");    

  traza("Toma Campanya");
  Integer camp = dtoMav.getCampagnaEvaluacion();
  if (camp != null)
    asignarAtributo("VAR", "varCampanyaFuente", "valor", camp.toString() );
  else
    asignarAtributo("VAR", "varCampanyaFuente", "valor", "");    

  traza("Curso");
  Long curso = dtoMav.getCurso();
  if (curso != null)
    asignarAtributo("VAR", "varCurso", "valor", curso.toString() );
  else
    asignarAtributo("VAR", "varCurso", "valor", "");

  traza("Numero de Unidades Cliente");
  Integer unidadesClientes = dtoMav.getUnidadesPorCliente();
  if (unidadesClientes != null)
    asignarAtributo("VAR", "varNumUnidadesCliente", "valor", unidadesClientes.toString() );
  else
    asignarAtributo("VAR", "varNumUnidadesCliente", "valor", "");

  traza("Numero de Unidades Totales");
  Integer unidadesTotales = dtoMav.getUnidadesTotales();
  if ( unidadesTotales != null)
    asignarAtributo("VAR", "varNumUnidadesTotales", "valor", unidadesTotales.toString() );  
  else
    asignarAtributo("VAR", "varNumUnidadesTotales", "valor", "");  


        /*
         * [1] Agregado por Rafael Romero
         * SiCC20070189 - 25/04/2007
         * Para quitar atributos de requiered para estado 4
         */
        if(estadoProceso!=null && estadoProceso.intValue()==4){
            this.asignarAtributo("CTEXTO", "txtCodProducto", "req", "N");
            this.asignarAtributo("COMBO", "cbTipoOferta", "req", "N");
            this.asignarAtributo("COMBO", "cbCicloVida", "req", "N");
            this.asignarAtributo("CTEXTO", "txtPrecio", "req", "N");
            this.asignarAtributo("CTEXTO", "txtPrecioEstandar", "req", "N");
            this.asignarAtributo("COMBO", "cbFormaCobro", "req", "N");
            this.asignarAtributo("COMBO", "cbFormaPago", "req", "N");
            this.asignarAtributo("COMBO", "cbTipoDespacho", "req", "N");
            this.asignarAtributo("COMBO", "cbAcceso", "req", "N");
            this.asignarAtributo("COMBO", "cbSubacceso", "req", "N");
            this.asignarAtributo("COMBO", "cbCodMensaje2", "req", "N");
            this.asignarAtributo("COMBO", "cbCodMensaje3", "req", "N");
        }
        /*
         * Fin agregar []
         */

 }

 private void nueva(boolean nueva) throws Exception
 {
    if (nueva){
      traza("Metodo nueva True");
    }else{
      traza("Metodo nueva False");
      this.carga();
    }
 }

 private void carga() throws Exception
 {
      // Carga los datos de la pantalla.
      this.cargaConGestor();
      traza("Entra a carga");
      DTOBuscarCargaBP dtoCarga = new DTOBuscarCargaBP();
      MareBusinessID bussId = new MareBusinessID("MAVCargaPaginaBP");      
      Vector params = new Vector();
      
      dtoCarga.setOidCanal(oidCanal);
      dtoCarga.setOidMarca(oidMarca);
      dtoCarga.setOidActividadMAV(oidActividadMAV);
      dtoCarga.setOidPeriodo(oidPeriodo);
      dtoCarga.setOidTipoCliente(oidTipoCliente);

      dtoCarga.setOidIdioma(UtilidadesSession.getIdioma(this));
      dtoCarga.setOidPais(UtilidadesSession.getPais(this));

      traza("dtoCarga: " + dtoCarga.toString() );
      params.add(dtoCarga);
      params.add(bussId);

      traza("Antes de conectar");
      DruidaConector conCarga = this.conectar("ConectorCargaBP", params);
      traza("Luego de conectar");

      DTOCargaBP dtoCargaBP = (DTOCargaBP)conCarga.objeto("dtoSalida");      
      traza("dtoCargaBP: " + dtoCargaBP.toString() );

      // creaListas Ocultas
      Vector nomCols = new Vector();
      for (int i =0; i < 4; i++)
        nomCols.add(""+i);

      RecordSet rRegiones = dtoCargaBP.getRegion();
      RecordSet rZonas = dtoCargaBP.getZona();
      RecordSet rTipoClasi = dtoCargaBP.getTipoClasificacion();
      RecordSet rClasi = dtoCargaBP.getClasificacion();
      RecordSet rSubAccesos = dtoCargaBP.getSubacceso();
      RecordSet rSubgerencia = dtoCargaBP.getSubgerencia();
      RecordSet rSubTipo = dtoCargaBP.getSubtipoCliente();
      RecordSet rAccesos = dtoCargaBP.getAcceso();
      // Agregado por SICC20070356 - Rafael Romero - 05/09/2007
      RecordSet rValoresDefecto = dtoCargaBP.getValoresDefecto();
      // Fin agregado SICC20070356
      
      // sapaza -- PER-SiCC-2010-0699 -- 13/12/2010        
      this.getSessionCache().put("subgerenciaMAV", rSubgerencia);      
      this.getSessionCache().put("regionesMAV", rRegiones);
      this.getSessionCache().put("zonasMAV", rZonas);

      DruidaConector conSubgerencia = null; 
      DruidaConector conSubtipoCliente = null;
      DruidaConector conAccesos = null;
      DruidaConector conTipoClasi = null;
      

     if (rRegiones != null && rRegiones.getRowCount() > 0)
      {
        traza("Asignando regiones a lista...");
        traza("rRegiones: " + rRegiones);
        DruidaConector con = UtilidadesBelcorp.generarConector("regiones", rRegiones, rRegiones.getColumnIdentifiers() );       
        asignar("LISTADOA", "listaRegiones", con, "regiones");
      } else
      traza("Regiones es null o vacio");

     if (rZonas != null && rZonas.getRowCount() > 0)
      {
        traza("Asignando Zonas a lista...");
        DruidaConector con = UtilidadesBelcorp.generarConector("zonas", rZonas, rZonas.getColumnIdentifiers() );       
        asignar("LISTADOA", "listaZonas", con, "zonas");
      } else
      traza("Zonas es null o vacio");    

     if (rTipoClasi != null && rTipoClasi.getRowCount() > 0)
      {
        traza("Asignando Tipo Clasificacion a lista...");
        DruidaConector con = UtilidadesBelcorp.generarConector("tipoClasi", rTipoClasi, rTipoClasi.getColumnIdentifiers() );       
        asignar("LISTADOA", "listaTiposClasificacion", con, "tipoClasi");
      } else
        traza("Tipo Clasificaciones es null o vacio");          

     if (rClasi != null && rClasi.getRowCount() > 0)
      {
        traza("Asignando Clasificacion a lista...");
        DruidaConector con = UtilidadesBelcorp.generarConector("clasi", rClasi, rClasi.getColumnIdentifiers() );       
        asignar("LISTADOA", "listaClasificaciones", con, "clasi");
      } else
        traza("Clasificaciones es null o vacio");          

     if (rSubAccesos != null && rSubAccesos.getRowCount() > 0)
      {
        traza("Asignando Subaccesos a lista...");
        DruidaConector con = UtilidadesBelcorp.generarConector("subAccesos", rSubAccesos, rSubAccesos.getColumnIdentifiers() );       
        asignar("LISTADOA", "listaSubaccesos", con, "subAccesos");
      } else
        traza("Subaccesos es null o vacio");     
      
      if (rSubgerencia != null && rSubgerencia.getRowCount() > 0)
      {
        traza("Asignando subgerencias a combo...");
        RecordSet rNuevo = new RecordSet();
        Vector vCols = new Vector();
        vCols = new Vector();
        
        rSubgerencia.removeColumn(1);
        rSubgerencia.removeColumn(1);
        rSubgerencia.removeColumn(1);        
        rSubgerencia.removeColumn(2);    
        rSubgerencia.removeColumn(2);    
        rSubgerencia.removeColumn(2);    
        rSubgerencia.removeColumn(2);  
        traza("subgerencia luego de eliminar columnas: " + rSubgerencia.toString());
        
        conSubgerencia = UtilidadesBelcorp.generarConector("subgerencia", rSubgerencia, rSubgerencia.getColumnIdentifiers() );       
        asignar("COMBO", "cbSubgerencia", conSubgerencia, "subgerencia");
      } else
       traza("Subgerencias es null o vacio");

      // Modificado por ssantana, segun inc. 16866. - 22/6/2005
      // Nota: Puede ser que esté mal algo (ver inc. 19639 para más inf.)
      /*if (rSubTipo != null && rSubTipo.getRowCount() > 0)
      {
        // Obtiene unicamente los clientes que pertenecen al tipo en
        // oidTipoCliente.
        RecordSet rNuevo = new RecordSet();
        Vector cols = new Vector();
        cols.add("oidSubt");
        cols.add("oidClie");
        cols.add("desc");
        rNuevo.setColumnIdentifiers(cols);
        
        for (int i = 0; i<rSubTipo.getRowCount(); i++)
        {
          BigDecimal tipoClie = (BigDecimal) rSubTipo.getValueAt(i,1);
          if (tipoClie.longValue() == oidTipoCliente.longValue() )
            rNuevo.addRow(rSubTipo.getRow(i));
        }

        traza("Nuevo RecordSet subtipo: " + rNuevo.toString() );
        

        traza("Asignando SubTipo a combo...");      
        rNuevo.removeColumn(1);
        conSubtipoCliente = UtilidadesBelcorp.generarConector("subtipo", rNuevo, rNuevo.getColumnIdentifiers() ); 
        asignar("COMBO", "cbSubtipoCliente", conSubtipoCliente, "subtipo");      
      } else
          traza("SubTipo es null o vacio");      */
      conSubtipoCliente = UtilidadesBelcorp.generarConector("subtipo", rSubTipo, rSubTipo.getColumnIdentifiers() ); 
      asignar("COMBO", "cbSubtipoCliente", conSubtipoCliente, "subtipo");      
      // fin Modificacion ssantana, 22/6/2005

      if (rAccesos != null && rAccesos.getRowCount() > 0)
      {
        traza("Asignando Accesos a combo...");      
        //rAccesos.removeColumn(2);
        conAccesos = UtilidadesBelcorp.generarConector("accesos", rAccesos, rAccesos.getColumnIdentifiers() ); 
        asignar("COMBO", "cbAcceso", conAccesos, "accesos");      
      } else
         traza("Accesos es null o vacio");

      if (rTipoClasi != null && rTipoClasi.getRowCount() > 0)
      {
        traza("Asignando TipoClasificacion a Lista...");      
        conTipoClasi = UtilidadesBelcorp.generarConector("tipoClasi", rTipoClasi, rTipoClasi.getColumnIdentifiers() ); 
        asignar("LISTADOA", "listaTiposClasificacion", conTipoClasi, "tipoClasi");
      } else
         traza("TipoClasificacion es null o vacio");      

        // Agregado por SICC20070356 - Rafael Romero - 05/09/2007
        if(rValoresDefecto != null && rValoresDefecto.getRowCount() > 0){
            UtilidadesLog.debug("Asignando valores por defecto...");
            for(int i = 0; i < rValoresDefecto.getRowCount(); i++){
                String codigoVD = rValoresDefecto.getValueAt(i,"COD").toString();
                String valorVD  = rValoresDefecto.getValueAt(i,"VAL")==null ? "" : rValoresDefecto.getValueAt(i,"VAL").toString();

                if(codigoVD.equals(CODIGO_CAMPO_VD_NEBP_ACCE)){
                    asignarAtributo("VAR","hOidAcce","valor",valorVD);
                }
                if(codigoVD.equals(CODIGO_CAMPO_VD_NEBP_SUB_ACCE)){
                    asignarAtributo("VAR","hOidSubAcce","valor",valorVD);
                }
                if(codigoVD.equals(CODIGO_CAMPO_VD_NEBP_TIP_OFER)){
                    asignarAtributo("VAR","hOidTipOfer","valor",valorVD);
                }
                if(codigoVD.equals(CODIGO_CAMPO_VD_NEBP_TIP_CLIE)){
                    asignarAtributo("VAR","hOidTipClie","valor",valorVD);
                }
                if(codigoVD.equals(CODIGO_CAMPO_VD_NEBP_SBT_CLIE)){
                    asignarAtributo("VAR","hOidSubTipClie","valor",valorVD);
                }
                if(codigoVD.equals(CODIGO_CAMPO_VD_NEBP_CIC_VIDA)){
                    asignarAtributo("VAR","hOidCicVida","valor",valorVD);
                }
                if(codigoVD.equals(CODIGO_CAMPO_VD_NEBP_CRI_ASIG)){
                    asignarAtributo("VAR","hOidCriAsig","valor",valorVD);
                }
                if(codigoVD.equals(CODIGO_CAMPO_VD_NEBP_TIP_DESP)){
                    asignarAtributo("VAR","hOidTipDesp","valor",valorVD);
                }
                
            }
        }else
            traza("No hay valores por defecto para la actividad ["+oidActividadMAV+"]");
        
        // Fin agregado SICC20070356

      //PER-SiCC-2013-0355 - Sergio Apaza - 04/04/2013
      String indValidaPrecioContable = dtoCargaBP.getIndValidaPrecioContable();
      if(indValidaPrecioContable != null) 
    	  asignarAtributo("VAR","varValidaPrecioContable","valor",indValidaPrecioContable);
      else
    	  asignarAtributo("VAR","varValidaPrecioContable","valor","");
      
      //PER-SiCC-2013-0432 - Sergio Apaza - 18/04/2013
      String descripcionAlmacen = dtoCargaBP.getDescripcionAlmacen();
      if(descripcionAlmacen != null) 
    	  asignarAtributo("LABELC","lbldtAlmacen","valor", descripcionAlmacen);
      else
    	  asignarAtributo("LABELC","lbldtAlmacen","valor", "");
      
      return;

 } 

 private ComposerViewElementList preparaCargaInicial() throws Exception
 {

   DTOBelcorp dtoe = new DTOBelcorp();
   
   ComposerViewElementList cList = new ComposerViewElementList();
   ComposerViewElement cElem1 = new ComposerViewElement();
   ComposerViewElement cElem2 = new ComposerViewElement();   
   //ComposerViewElement cElem3 = new ComposerViewElement();      

   dtoe.setOidIdioma(UtilidadesSession.getIdioma(this));
   dtoe.setOidPais(UtilidadesSession.getPais(this));

   cElem1.setIDBusiness("SEGConsultaCanales");
   cElem1.setDTOE(dtoe);

   cElem2.setIDBusiness("SEGConsultaMarcas");
   cElem2.setDTOE(dtoe);

   /*cElem3.setIDBusiness("MAEObtenerTipos");
   cElem3.setDTOE(dtoe);*/

   cList.addViewElement(cElem1);
   cList.addViewElement(cElem2);   
   //cList.addViewElement(cElem3);   

   return cList;


 }

 private void guardar() throws Exception
 {
    pagina("salidaGenerica");
    this.asignarAtributo("VAR", "cerrarVentana", "valor", "false");

    try {
        DTODetalleMAV dtoMav = new DTODetalleMAV();

        // Estas no debe ser null. Siempre deben contener valor
        String marca = (String) this.conectorParametro("varLblMarca");
        String canal = (String) this.conectorParametro("varCanal");
        String actividad = (String) this.conectorParametro("varActividad");
        String periodo = (String) this.conectorParametro("varPeriodo");
        String tipoCliente = (String) this.conectorParametro("varTipoCliente");
        // Fin Comentario

        String sOidDetalle = this.conectorParametroLimpia("varOid", "", true);
        Long oidDetalle = null;
        if ( !sOidDetalle.equals("") )
          oidDetalle = new Long(sOidDetalle);
          
    
        String subgerenciaV = (String) this.conectorParametro("cbSubgerencia");
        Long subgerenciaArray[] = null;
        if (subgerenciaV != null)
          subgerenciaArray = this.parseaCombos(subgerenciaV);

        String regiones = (String) this.conectorParametro("cbRegion");
        Long regionesArray[] = null;
        if (regiones != null)
          regionesArray = this.parseaCombos(regiones);

        String zona = (String) this.conectorParametro("cbZona");
        Long zonaArray[] = null;
        if (zona != null)
          zonaArray = this.parseaCombos(zona);

        // sapaza -- PER-SiCC-2010-0699 -- 13/12/2010        
        String varListaUnidades = this.conectorParametroLimpia("varListaUnidades", "", true);
        Map unidades = parseaUnidades(varListaUnidades);
                
        String txtObservaciones = (String) this.conectorParametro("atxtObservaciones");
    
        String subtipoCliente = (String) this.conectorParametro("cbSubtipoCliente");
        Long subtipoClienteArray[] = null;
        if ( subtipoCliente != null)
          subtipoClienteArray = this.parseaCombos(subtipoCliente);

        // sapaza -- PER-SiCC-2010-0628 -- 20/10/2010
        String tipoClasificacion = (String) this.conectorParametro("cbTipoClasificacionCliente");
        Long tipoClasificacionArray[] = null;
        if ( tipoClasificacion != null)
        	tipoClasificacionArray = this.parseaCombos(tipoClasificacion);

        String clasificacion = (String) this.conectorParametro("cbClasificacionCliente");
        Long clasificacionArray[] = null;
        if ( clasificacion != null)
        	clasificacionArray = this.parseaCombos(clasificacion);
        
        /*String tipoClasificacion = (String) this.conectorParametro("cbTipoClasificacionCliente");
        traza("TipoClasificacionCliente: " + tipoClasificacion);
        String clasificacion = (String) this.conectorParametro("varClasificacionCliente");
        traza("ClasificacionCliente: " + clasificacion);*/
        
        String estadoMAV = (String) this.conectorParametro("cbEstado");
        String listaClientes = (String) this.conectorParametro("varListaCliente");   
        traza("Codigo Lista Clientes: " + listaClientes);


        String criterioAsig = (String) this.conectorParametro("cbCriterioAsignacion");

        String subAcceso = (String) this.conectorParametro("cbSubacceso");
        Long[] subAccesoArray = null;
        if ( subAcceso != null)
          subAccesoArray = this.parseaCombos(subAcceso);
   
        String periodoFin = (String) this.conectorParametro("cbPeriodoFin");
        String tipoOferta = (String) this.conectorParametro("cbTipoOferta");
        String cicloVida = (String) this.conectorParametro("cbCicloVida");
        String codigoProducto = (String) this.conectorParametro("txtCodProducto");
        
        // Modificado por ssantana, 1/8/2005, x inc. BELC300015618
        /* String codigoVenta = (String) this.conectorParametro("txtCodVenta");
        String codigoVentaOid = (String) this.conectorParametro("varCodVentaOid");*/
        // Fin Modificacion por ssantana, 1/8/2005, x inc. BELC300015618   
        
        String precioEstandar = (String) this.conectorParametro("txtPrecioEstandar");
        String precio = (String) this.conectorParametro("txtPrecio");
        String precioContable = (String) this.conectorParametro("txtPrecioContable");
        String baseDestinatarios = (String) this.conectorParametro("txtBaseDestinatarios");
        String factorCorreccion = (String) this.conectorParametro("txtFactorCorreccion");
        String promedio = (String) this.conectorParametro("txtPromedio");
        String unidadesTotalesEstimadas = (String) this.conectorParametro("txtUnidades");
        String criterio = (String) this.conectorParametro("txtCriterio");  
        String formaCobro = (String) this.conectorParametro("cbFormaCobro");      
        String formaPago = (String) this.conectorParametro("cbFormaPago");
        String tipoDespacho = (String) this.conectorParametro("cbTipoDespacho");    
        //String indicadorEnvio = (String) this.conectorParametro("cbTipoEnvio");        
        
        // Modif. x ssantana, 8/12/2004 - Se quita Envio con Solicitud ya que está 
        // asociado a Tipo Despacho Actividad (inc 11073)
        //String indicadorEnvio = (String) this.conectorParametro("cbEnvioSolicitud");   

        // Toma Caso de Uso para luego ver cual de los controles de Enviar Mensaje y Cod Mensaje
        // usar.
        String casoUso = (String) this.conectorParametro("casoUso");
        String enviarMensaje = null;
        String codigoMensaje = null;
        traza("Caso Uso al guardar: " + casoUso);
        if (casoUso.equals("detalle") ) {
             traza("Detalle - Capa 2");
             enviarMensaje = (String) this.conectorParametro("rbEnviarMensaje2");
             codigoMensaje = (String) this.conectorParametro("cbCodMensaje2");
        } else {
             traza("Detalle - Capa 3");        
             enviarMensaje = (String) this.conectorParametro("rbEnviarMensaje3");
             codigoMensaje = (String) this.conectorParametro("cbCodMensaje3");
        }
        traza("enviarMensaje: " + enviarMensaje);
        traza("codigoMensaje: " + codigoMensaje);
        
        String indExclusionTipoClasificacion = (String) this.conectorParametro("rbExclusionTipoClasificacion");
        
        String numUnidadesCliente = (String) this.conectorParametro("varNumUnidadesCliente");
        String numAniversario = (String) this.conectorParametro("varNumeroAniversario");
        String edadDesde = (String) this.conectorParametro("varEdadDesde");
        String edadHasta = (String) this.conectorParametro("varEdadHasta");
        String monto = (String) this.conectorParametro("varMonto");
        String periodoDesde = (String) this.conectorParametro("varPeriodoDesde");
        String periodoHasta = (String) this.conectorParametro("varPeriodoHasta");
        String marcaCondicion = (String) this.conectorParametro("varMarcaCriterio");        
        String catalogo = (String) this.conectorParametro("varCatalogo");
        String unidadNegocio = (String) this.conectorParametro("varUnidadNegocio");
        String negocio = (String) this.conectorParametro("varNegocio");
        String numUnidadesTotales = (String) this.conectorParametro("varNumUnidadesTotales");
        String campanya = (String) this.conectorParametro("varCampanyaFuente");
        String subCriterio = (String) this.conectorParametro("varSubcriterio");
        String curso = (String) this.conectorParametro("varCurso");    
        String periodoCurso = (String) this.conectorParametro("varPeriodoCurso");
        
        // sapaza -- PER-SiCC-2010-0674 -- 29/11/2010
        String varTipoClienteCriterio = (String) this.conectorParametro("varTipoClienteCriterio");
        String varSubtipoClienteCriterio = (String) this.conectorParametro("varSubtipoClienteCriterio");
        String varTipoClasificacionClienteCriterio = (String) this.conectorParametro("varTipoClasificacionClienteCriterio");
        String varClasificacionClienteCriterio = (String) this.conectorParametro("varClasificacionClienteCriterio");

        traza("Comienza a armar DTODetalle");
        dtoMav.setOid(oidDetalle);
        dtoMav.setOidPais(UtilidadesSession.getPais(this) );
        dtoMav.setMarca( new Long(marca) );
        dtoMav.setCanal( new Long(canal) );
        dtoMav.setActividad( new Long(actividad) );
        dtoMav.setPeriodo( new Long(periodo) );
        dtoMav.setTipoCliente( new Long(tipoCliente) );
        dtoMav.setSubgerencias(subgerenciaArray);
        dtoMav.setRegiones(regionesArray);
        dtoMav.setZonas(zonaArray);
        
        // sapaza -- PER-SiCC-2010-0699 -- 13/12/2010        
        dtoMav.setUnidadesRegionZona(unidades);
        
        if (txtObservaciones != null ) {
          dtoMav.setObservaciones(txtObservaciones);
        } else {
          dtoMav.setObservaciones(null);
        }
        
        dtoMav.setSubtiposCliente(subtipoClienteArray);

        // sapaza -- PER-SiCC-2010-0628 -- 20/10/2010
        dtoMav.setTiposClasificacion(tipoClasificacionArray);
        dtoMav.setClasificaciones(clasificacionArray);
        
        // sapaza -- PER-SiCC-2010-0674 -- 29/11/2010
        if (varTipoClienteCriterio != null && !varTipoClienteCriterio.equals("") ) {
          dtoMav.setTipoClienteCriterio(new Long(varTipoClienteCriterio) );
        } else {
          dtoMav.setTipoClienteCriterio(null);
        }
        if (varSubtipoClienteCriterio != null && !varSubtipoClienteCriterio.equals("") ) {
          dtoMav.setSubTipoCliente(new Long(varSubtipoClienteCriterio) );
        } else {
          dtoMav.setSubTipoCliente(null);
        }
        if (varTipoClasificacionClienteCriterio != null && !varTipoClasificacionClienteCriterio.equals("") ) {
          dtoMav.setTipoClasificacion( new Long(varTipoClasificacionClienteCriterio) );
        } else {
          dtoMav.setTipoClasificacion(null);
        }
        if (varClasificacionClienteCriterio != null && !varClasificacionClienteCriterio.equals("") ) {
          dtoMav.setClasificacion( new Long(varClasificacionClienteCriterio) );
        } else {
          dtoMav.setClasificacion(null);
        }
        
        if ( estadoMAV != null && !estadoMAV.equals("") ) {
          dtoMav.setEstadoMAV(new Long(estadoMAV) );
        } else {
          dtoMav.setEstadoMAV(null);
        }

        if ( listaClientes != null && !listaClientes.equals("") ) {
          dtoMav.setListaClientes(new Long(listaClientes) );
        } else {
          dtoMav.setListaClientes(null);
        }

        if ( criterioAsig != null && !criterioAsig.equals("") ) {
          dtoMav.setCriterioAsignacion( new Long(criterioAsig) );
        } else {
          dtoMav.setCriterioAsignacion(null);
        }
      
        dtoMav.setSubaccesos(subAccesoArray);

        if ( periodoFin != null && !periodoFin.equals("") ) {
          dtoMav.setPeriodoFin( new Long(periodoFin) );
        } else {
          dtoMav.setPeriodoFin(null);
        }

        if ( tipoOferta != null && !tipoOferta.equals("") ) {
          dtoMav.setTipoOferta( new Long(tipoOferta) );
        } else {
          dtoMav.setTipoOferta(null);
        }

        if ( cicloVida != null && !cicloVida.equals("") ) {
          dtoMav.setCicloVida( new Long(cicloVida) );
        } else {
          dtoMav.setCicloVida( null );
        }

        // Modif. x ssantana, 28/11/2004
        // Se cambia dtoMav.setProducto() a dtoMav.setProdCodSAP().
        // Caja de Texto (en realidad este campo es Required)
        if ( codigoProducto != null  && !codigoProducto.equals("") )
          dtoMav.setProdCodSAP(codigoProducto);
        else
          dtoMav.setProdCodSAP(null);

         // Modificado x ssantana, 9/12/2004
         // Se pasa ahora el Codigo Venta en lugar del Oid. 
         
         // Modificado por ssantana, 1/8/2005, x inc. BELC300015618         
        /*traza("CodigoVenta - Descripcion"); // Caja de Texto
        if ( codigoVenta != null && !codigoVenta.equals("") )
          dtoMav.setSCodigoVenta(codigoVenta);
        else
          dtoMav.setSCodigoVenta(null);
          
        traza("CodigoVenta - Oid");
        if ( codigoVentaOid != null && !codigoVentaOid.equals("") )
          dtoMav.setCodigoVenta(new Long(codigoVentaOid));
        else
          dtoMav.setCodigoVenta(null);*/
        // Fin Modificado por ssantana, 1/8/2005, x inc. BELC300015618

        // Caja de Texto
        if (precioEstandar != null && !precioEstandar.equals("") ) {
          precioEstandar = this.conectorParametroNumero("txtPrecioEstandar", LPSICCBase.FORMATO_MONEDA);
          dtoMav.setPrecioEstandar( new Double(precioEstandar) );
        }
        else {
          dtoMav.setPrecioEstandar( null );    
        }

        // Caja de Texto
        if (precio != null && !precio.equals("") ) {
          precio = this.conectorParametroNumero("txtPrecio", LPSICCBase.FORMATO_MONEDA);        
          dtoMav.setPrecio( new Double(precio) );
        }
        else {
          dtoMav.setPrecio( null );
        }

         // Caja de Texto
        if (precioContable != null && !precioContable.equals("") ) {
          precioContable = this.conectorParametroNumero("txtPrecioContable", LPSICCBase.FORMATO_MONEDA);
          dtoMav.setPrecioContable(new Double(precioContable) );          
        }
        else {
          /* Modificado por ssantana, 14/08/2006, inc. BELC300023672 
           * Se indica 0.0 como valor por defecto */ 
          dtoMav.setPrecioContable(new Double(0.0));
        }

        // Caja de Texto
        if (baseDestinatarios != null && !baseDestinatarios.equals("")) 
          dtoMav.setBaseEstimadosDestinatarios( new Long(baseDestinatarios) );
        else
          dtoMav.setBaseEstimadosDestinatarios( null );

        // Caja de Texto
        if (factorCorreccion != null && !factorCorreccion.equals("") ) {
          factorCorreccion = this.conectorParametroNumero("txtFactorCorreccion", LPSICCBase.FORMATO_DEFAULT);                          
          dtoMav.setFactorCorreccion( new Double(factorCorreccion) );
        }
        else {
          dtoMav.setFactorCorreccion( null );
        }

        // Caja de Texto
        if (promedio != null && !promedio.equals("") )
        {
          //precioEstandar = this.conectorParametroNumero("txtPrecioEstandar", LPSICCBase.FORMATO_MONEDA);        
          promedio = this.desFormatearNumero(promedio, LPSICCBase.FORMATO_DEFAULT );
          dtoMav.setUnidadesEstimadas( new BigDecimal(promedio) );
        }
        else{
          dtoMav.setUnidadesEstimadas( null );
        }

        // Caja de Texto
        if (unidadesTotalesEstimadas != null && !unidadesTotalesEstimadas.equals("") ) {
          dtoMav.setUnidadesTotalesEstimadas( new Long(unidadesTotalesEstimadas) );
        } else {
          dtoMav.setUnidadesTotalesEstimadas( null );      
        }

        // Caja de Texto
        if (criterio != null) {
          dtoMav.setCriterio(criterio);
        } else {
          dtoMav.setCriterio( null );      
        }

        
        if (formaCobro != null && !formaCobro.equals("") ) {
            dtoMav.setFormaCobro( new Long(formaCobro) );
        } else {
          dtoMav.setFormaCobro( null );
        }


        if (formaPago != null && !formaPago.equals("") ) {
          dtoMav.setFormaPago( new Long(formaPago) );
        } else {
          dtoMav.setFormaPago( null );      
        }

        if (tipoDespacho != null && !tipoDespacho.equals("") ){
          dtoMav.setTipoDespacho(new Long(tipoDespacho) );
        } else {
          dtoMav.setTipoDespacho( null );      
        }

        dtoMav.setIndicadorEnvio( null );      

        if (enviarMensaje != null || !enviarMensaje.equals("") )
        {
          if ( enviarMensaje.equals("S") ) {
            dtoMav.setEnviarMensaje(new Boolean(true)); 
          } else {
            dtoMav.setEnviarMensaje(new Boolean(false));
          }
        } else {
          dtoMav.setEnviarMensaje(null);
        }

        // sapaza -- PER-SiCC-2010-0628 -- 20/10/2010
        if (indExclusionTipoClasificacion != null || !indExclusionTipoClasificacion.equals("") )
        {
          if ( indExclusionTipoClasificacion.equals("S") ) {
            dtoMav.setIndExclusionTipoClasificacion(new Boolean(true)); 
          } else {
            dtoMav.setIndExclusionTipoClasificacion(new Boolean(false));
          }
        } else {
          dtoMav.setIndExclusionTipoClasificacion(null);
        }

        if (codigoMensaje != null && !codigoMensaje.equals("") ) {
          dtoMav.setMensaje(new Long(codigoMensaje) );
        } else {
          dtoMav.setMensaje( null );
        }

        if ( numUnidadesCliente != null && !numUnidadesCliente.equals("") ) {
          dtoMav.setUnidadesPorCliente( new Integer(numUnidadesCliente) );
        } else {
          dtoMav.setUnidadesPorCliente(null);
        }

        if ( numAniversario != null && !numAniversario.equals("") ) {
          dtoMav.setNumeroAniversario( numAniversario );
        } else {
          dtoMav.setNumeroAniversario( null );
        }  
          
        if ( edadDesde != null && !edadDesde.equals("") ) {
          dtoMav.setEdadDesde( new Long(edadDesde) );
        } else {
          dtoMav.setEdadDesde( null );
        }

        if ( edadHasta != null && !edadHasta.equals("") ) {
          dtoMav.setEdadHasta( new Long(edadHasta) );
        } else {
          dtoMav.setEdadHasta( null );
        }
          
        if (monto != null && !monto.equals("") ){
          monto = this.conectorParametroNumero("varMonto", LPSICCBase.FORMATO_MONEDA);                                    
          dtoMav.setMonto( new Double(monto) );
        }
        else {
          dtoMav.setMonto(null);
        }

        if ( periodoDesde != null && !periodoDesde.equals("") ) {
          dtoMav.setPeriodoIniMonto( new Long(periodoDesde) );
        } else {
          dtoMav.setPeriodoIniMonto( null );
        }

        if ( periodoHasta != null && !periodoDesde.equals("") ) {
          dtoMav.setPeriodoFinMonto( new Long(periodoHasta) );
        } else {
          dtoMav.setPeriodoFinMonto( null );
        }

        if ( marcaCondicion != null && !marcaCondicion.equals("") ) {
          dtoMav.setMarcaCondicion( new Long(marcaCondicion) );
        } else {
          dtoMav.setMarcaCondicion( null );
        }

        if ( catalogo != null && !catalogo.equals("") ) {
          dtoMav.setCatalogo( new Long(catalogo) );
        } else {
          dtoMav.setCatalogo( null );
        }

        if ( unidadNegocio != null && !unidadNegocio.equals("") ) {
          dtoMav.setUnidadNegocio( new Long(unidadNegocio) );    
        } else {
          dtoMav.setUnidadNegocio(null);
        }

        if ( negocio != null && !negocio.equals("") ) {
          dtoMav.setNegocio( new Long(negocio) );
        } else {
          dtoMav.setNegocio(null);
        }

        if ( numUnidadesTotales != null && !numUnidadesTotales.equals("") ) {
          dtoMav.setUnidadesTotales( new Integer(numUnidadesTotales) );
        } else {
          dtoMav.setUnidadesTotales( null );
        }

        if ( campanya != null && !campanya.equals("") ) {
          dtoMav.setCampagnaEvaluacion( new Integer(campanya) );
        } else {
          dtoMav.setCampagnaEvaluacion( null );
        }


        if ( subCriterio != null && !subCriterio.equals("") ){
          dtoMav.setSubcriterio( new Long(subCriterio) );
        } else {
          dtoMav.setSubcriterio( null );
        }

        if (curso != null && !curso.equals("") ) {
          dtoMav.setCurso( new Long(curso) );
        } else {
          dtoMav.setCurso(null);
        }

        if ( periodoCurso != null && !periodoCurso.equals("") ) {
          dtoMav.setPeriodoCurso( new Long(periodoCurso) );
        } else {
          dtoMav.setPeriodoCurso( null );
        }

        dtoMav.setOidIdioma(UtilidadesSession.getIdioma(this));
        dtoMav.setPrograma(UtilidadesSession.getFuncion(this));
        dtoMav.setIpCliente(UtilidadesBelcorp.getIPCliente(this));

        traza("Termino de armar DTO");
        DruidaConector con = null;
        Vector params = new Vector();
        MareBusinessID bussId = new MareBusinessID("MAVActualizaDetalleMAV");

        params.add(dtoMav);
        params.add(bussId);
        traza("dtoDetalle a enviar: " + dtoMav);
        traza("Antes de conectar");
        con = this.conectar("ConectorGuardaBP", params);
        traza("Luego de conectar");   
        
    } catch(Exception ex)
    {
      this.lanzarPaginaError(ex);        
      ex.printStackTrace();
      traza("--- Exception guardando");
      asignarAtributo("VAR", "ejecutar", "valor", "errorAlGuardar()");

      return;
    }
    traza("No hubo excepcion al guardar");
    asignarAtributo("VAR", "ejecutar", "valor", "noHayError()");
   
 }

 private void cargaConGestor() throws Exception
 {
    traza("--- cargaConGestor ----");
    //this.prueba();
    DTOBelcorp dtoe = new DTOBelcorp();
    DTOPeriodo dtoPerio = new DTOPeriodo();
    DTOOID dtoOid = new DTOOID();
    
    ComposerViewElementList cList = new ComposerViewElementList();
    ComposerViewElement cElem1 = new ComposerViewElement();
    ComposerViewElement cElem2 = new ComposerViewElement();    
    ComposerViewElement cElem3 = new ComposerViewElement();    
    ComposerViewElement cElem4 = new ComposerViewElement();
    ComposerViewElement cElem5 = new ComposerViewElement();    
    ComposerViewElement cElem6 = new ComposerViewElement();    
    ComposerViewElement cElem7 = new ComposerViewElement();
    ComposerViewElement cElem8 = new ComposerViewElement();    
    ComposerViewElement cElem9 = new ComposerViewElement();        

    // Setea valores del DTOBelcorp
    traza("Setea DTO");
    dtoe.setOidIdioma(UtilidadesSession.getIdioma(this));
    dtoe.setOidPais(UtilidadesSession.getPais(this));
    traza("FIn Seteo DTO");

    // Setea los valores de los cElemN
    //cElem1.setIDBusiness("MAVObtenerEstadosMAV");
	//incidencia 8054
    
	cElem1.setIDBusiness("MAVObtenerEstadosMAVActividad");
    dtoOid.setOid(oidActividadMAV);
    dtoOid.setOidIdioma(UtilidadesSession.getIdioma(this));
    cElem1.setDTOE(dtoOid);

    cElem2.setIDBusiness("MAVObtenerCriteriosAsignacion");
    cElem2.setDTOE(dtoe);

    //cElem3.setIDBusiness("CRAObtienePeriodos");    
	// vbongiov -- 29/09/2006
	 traza("cambio por aceptacion");
    cElem3.setIDBusiness("MAVObtienePeriodosBPMAV");        
    dtoPerio.setPais(UtilidadesSession.getPais(this));
    dtoPerio.setMarca(oidMarca);
    dtoPerio.setCanal(oidCanal);
    cElem3.setDTOE(dtoPerio);


    cElem4.setIDBusiness("MAVObtenerTiposOfertaActividad");
    dtoOid.setOidIdioma( UtilidadesSession.getIdioma(this) );
    cElem4.setDTOE(dtoOid);

    cElem5.setIDBusiness("MAVObtenerCiclosVidaActividad");
    cElem5.setDTOE(dtoOid);

    cElem6.setIDBusiness("MAVObtenerFormaCobro");
    // Modificado por ssantana, 23/11/2005, inc. 21444
    //cElem6.setDTOE(dtoe);
    cElem6.setDTOE(dtoOid);

    /*cElem7.setIDBusiness("BELFormasPagoPais");
    cElem7.setDTOE(dtoe);*/

    traza("AAAAA");
    cElem7.setIDBusiness("MAVObtieneFormasPagoActividad");
    cElem7.setDTOE(dtoOid);    
    

    cElem8.setIDBusiness("MAVObtenerTiposDespachoActividad");
    cElem8.setDTOE(dtoOid);

    cElem9.setIDBusiness("MAVObtenerEnvioConSolicitud");  
    cElem9.setDTOE(dtoe);    

    cList.addViewElement(cElem1);
    cList.addViewElement(cElem2);    
    cList.addViewElement(cElem3);        
    cList.addViewElement(cElem4);
    cList.addViewElement(cElem5);    
    cList.addViewElement(cElem6);    
    cList.addViewElement(cElem7);
    cList.addViewElement(cElem8);    
    cList.addViewElement(cElem9);   
    
    ConectorComposerView conector = new ConectorComposerView(cList, this.getRequest());
    traza("Ejecutando...44444444");
	    conector.ejecucion();
    traza("Luego de ejecutar44444444");
    DruidaConector con = conector.getConector();
    traza("con: " + con.getXMLString());
    
/*
    this.asignar("COMBO", "cbEstado", con, "MAVObtenerEstadosMAV");
    this.asignar("COMBO", "cbCriterioAsignacion", con, "MAVObtenerCriteriosAsignacion");
    this.asignar("COMBO", "cbPeriodoFin", con, "MAVObtienePeriodosBP");
    this.asignar("COMBO", "cbTipoOferta", con, "PREObtenerTiposOfertaPorCanal");     
    this.asignar("COMBO", "cbCicloVida", con, "PREObtenerCiclosVida");
    this.asignar("COMBO", "cbFormaCobro", con, "MAVObtenerFormaCobro");
    this.asignar("COMBO", "cbFormaPago", con, "BELFormasPagoPais");    
    this.asignar("COMBO", "cbTipoDespacho", con, "MAVObtenerTiposDespacho");
    this.asignar("COMBO", "cbEnvioSolicitud", con, "MAVObtenerEnvioConSolicitud");        
*/
//cambio realizado el 30/09/2004 inc. 8054
    
	this.asignar("COMBO", "cbEstado", con, "MAVObtenerEstadosMAVActividad");
	traza("1");
	this.asignar("COMBO", "cbCriterioAsignacion", con, "MAVObtenerCriteriosAsignacion");
	traza("2");	
	this.asignar("COMBO", "cbPeriodoFin", con, "MAVObtienePeriodosBPMAV");
	traza("3");
	this.asignar("COMBO", "cbTipoOferta", con, "MAVObtenerTiposOfertaActividad");
	traza("4");
	this.asignar("COMBO", "cbCicloVida", con, "MAVObtenerCiclosVidaActividad");
	traza("5");
	this.asignar("COMBO", "cbFormaCobro", con, "MAVObtenerFormaCobro");
	traza("6");
	this.asignar("COMBO", "cbFormaPago", con, "MAVObtieneFormasPagoActividad");
	traza("7");

  // Modificado x ssantana, 9/12/2004, por inc. 11073
  // Se carga combo Tipo Despacho Actividad , y se asigna a la lista oculta 
  //  "listaEnvioSolicitud" los valores corresp. de Envio Solicitud.

  Vector v = new Vector(); 
  MareBusinessID bussId = new MareBusinessID("MAVObtenerTiposDespachoActividad");
  v.add(dtoOid);
  v.add(bussId);

  DruidaConector conTipoDespacho = this.conectar("ConectorTipoDespachoActividad", v);
  DTOSalida dtoSalida = (DTOSalida) conTipoDespacho.objeto("dtoSalida"); 

  RecordSet r[] = this.obtieneRecordSetsDespachoSolicitud(dtoSalida);

  RecordSet rDespacho = r[0];
  if (rDespacho != null && rDespacho.getRowCount() > 0)  // Asigna al combo TipoDespacho si vino con valor.
  {
    traza("Se asigna Tipo Despacho");  
    DruidaConector conDespacho = UtilidadesBelcorp.generarConector("despacho", rDespacho, rDespacho.getColumnIdentifiers());
    this.asignar("COMBO", "cbTipoDespacho", conDespacho, "despacho");
  }

  RecordSet rSolicitud = r[1];
  if (rSolicitud != null && rSolicitud.getRowCount() > 0)  // Asigna a lista oculta SolicitudEnvio
  {
    traza("Se asigna Lista Oculta Solicitud Envio");  
    DruidaConector conSolicitud = UtilidadesBelcorp.generarConector("solicitud", rSolicitud, rSolicitud.getColumnIdentifiers());
    this.asignar("LISTADOA", "listaEnvioSolicitud", conSolicitud, "solicitud");
  }

/*	this.asignar("COMBO", "cbTipoDespacho", con, "MAVObtenerTiposDespachoActividad");
	traza("8");
	this.asignar("COMBO", "cbEnvioSolicitud", con, "MAVObtenerEnvioConSolicitud");
	traza("9");*/


    traza("---- Saliendo de cargaConGestor() ----");
    
 }


 private void prueba() throws Exception
 {
    // Metodo de PRUEBA.

    traza("Prueba");

    MareBusinessID bussId = new MareBusinessID("MAVObtieneDetallesMAV");
    //es.indra.sicc.dtos.mav.DTOActividadMAV dto = new es.indra.sicc.dtos.mav.DTOActividadMAV();
//    DTOOID dto = new DTOOID();
//    dto.setOid( UtilidadesSession.getIdioma(this) );
    
    //DTOBelcorp dto = new DTOBelcorp();
    DTODetalleMAV dto = new DTODetalleMAV();

  //  dto.setOid( new Long(1) );
    dto.setOidIdioma( new Long(1) );
    dto.setOidPais( new Long(1) );
    dto.setActividad(new Long(1) );
    dto.setTipoCliente(new Long(2));
    dto.setPeriodo(new Long(18));
    dto.setTamanioPagina(new Integer(20));

   dto.setPrograma(UtilidadesSession.getFuncion(this));
   dto.setIpCliente(UtilidadesBelcorp.getIPCliente(this));


    Vector params = new Vector();

    params.add(dto);
    params.add(bussId);

    traza("Antes de conectar PREObtenerTiposOfertaPorCanal - Prueba");
    DruidaConector con = conectar("ConectorObtieneDetalleMAV", params);
    traza("Despues de conectar PREObtenerTiposOfertaPorCanal - Prueba");

//    DTOSalida d = (DTOSalida) con.objeto("dtoSalida");
//    RecordSet r = d.getResultado();

/*    if (r == null)
      traza("r es null");
    else
      traza("r tiene: " + r.toString() );*/

 }


  private Long[] parseaCombos(String sCadena) throws Exception
  {
    traza(" ---- ParseaCombos ----");
    traza("sCadena: " + sCadena);
    StringTokenizer tok = new StringTokenizer(sCadena, "|");
    Vector v = new Vector();

    int i = 0;
    while ( tok.hasMoreTokens() )
    {
       String sToken = tok.nextToken();
       traza("sToken: " + sToken);
       v.add( new Long(sToken) );      
    }
    traza(" Fin bucle");

    Long[] sRetorno = (Long[]) v.toArray( new Long[v.size()] );
    
    
    

    

    traza(" ---- End Parsea Combos ----");


    return sRetorno;
  
  }

/*  private void obtieneValoresPaginaDetalle() throws Exception
  {
    subgerenciaV = (String) this.conectorParametro("cbSubgerencia");
    if (subgerenciaV != null)
      subgerenciaArray = this.parseaCombos(subgerenciaV);

    regiones = (String) this.conectorParametro("cbRegion");
    if (regiones != null)
      regionesArray = this.parseaCombos(regiones);

    zona = (String) this.conectorParametro("cbZona");
    if (zona != null)
      zonaArray = this.parseaCombos(zona);

    txtObservaciones = (String) this.conectorParametro("textObservaciones");
    
    subtipoCliente = (String) this.conectorParametro("cbSubtipoCliente");
    if ( subtipoCliente != null)
      subtipoClienteArray = this.parseaCombos(subtipoCliente);

    tipoClasificacion = (String) this.conectorParametro("cbTipoClasificacionCliente");
    clasificacion = (String) this.conectorParametro("cbClasificacionCliente");
    estadoMAV = (String) this.conectorParametro("cbEstado");
    listaClientes = (String) this.conectorParametro("listaClientes");
    criterioAsig = (String) this.conectorParametro("cbCriterioAsignacion");

    subAcceso = (String) this.conectorParametro("cbSubacceso");
    if ( subAcceso != null)
      subAccesoArray = this.parseaCombos(subAcceso);
   
    periodoFin = (String) this.conectorParametro("cbPeriodoFin");
    tipoOferta = (String) this.conectorParametro("cbTipoOfertaF");
    cicloVida = (String) this.conectorParametro("cbCicloVida");
    codigoProducto = (String) this.conectorParametro("textCodProducto");
    codigoVenta = (String) this.conectorParametro("textCodVenta");
    precioEstandar = (String) this.conectorParametro("textPrecioEstandar");
    precio = (String) this.conectorParametro("textPrecio");
    precioContable = (String) this.conectorParametro("textPrecioContable");
    baseDestinatarios = (String) this.conectorParametro("textBaseDestinatarios");
    factorCorreccion = (String) this.conectorParametro("textFactorCorreccion");
    promedio = (String) this.conectorParametro("txtPromedio");
    unidadesTotalesEstimadas = (String) this.conectorParametro("textUnidades");
    criterio = (String) this.conectorParametro("textCriterio");  
    formaCobro = (String) this.conectorParametro("cbFormaCobro");      
    formaPago = (String) this.conectorParametro("cbFormaPago");
    tipoDespacho = (String) this.conectorParametro("cbTipoDespacho");    
    indicadorEnvio = (String) this.conectorParametro("cbTipoEnvio");        
    enviarMensaje = (String) this.conectorParametro("rbEnviarMensaje");
    codigoMensaje = (String) this.conectorParametro("cbCodMensaje");
    numUnidadesCliente = (String) this.conectorParametro("varNumUnidadesCliente");
    numAniversario = (String) this.conectorParametro("varNumeroAniversario");
    edadDesde = (String) this.conectorParametro("varEdadDesde");
    edadHasta = (String) this.conectorParametro("varEdadHasta");
    monto = (String) this.conectorParametro("varMonto");
    periodoDesde = (String) this.conectorParametro("varPeriodoDesde");
    periodoHasta = (String) this.conectorParametro("varPeriodoHasta");
    marcaCondicion = (String) this.conectorParametro("varMarca");
    catalogo = (String) this.conectorParametro("varCatalogo");
    unidadNegocio = (String) this.conectorParametro("varUnidadNegocio");
    negocio = (String) this.conectorParametro("varNegocio");
    numUnidadesTotales = (String) this.conectorParametro("varNumUnidadesTotales");
    campanya = (String) this.conectorParametro("varCampanyaFuente");
    subCriterio = (String) this.conectorParametro("varSubcriterio");
    curso = (String) this.conectorParametro("varCurso");    
    periodoCurso = (String) this.conectorParametro("varPeriodoCurso");

  }*/

  private void seteaValoresPaginaDetalle()
  {
  
  }
  

  

  private void logStackTrace(Throwable e) throws Exception 
  { 
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

  private String parseaArray(Long[] array) throws Exception
  {
      StringBuffer sBuffer = new StringBuffer("");
      traza("Arraylength: " + array.length);
      if (array != null)
      {
          for (int i = 0; i < array.length; i++)
          {
            if (i!= 0)
              sBuffer.append(",");
            sBuffer.append( array[i].toString() );
            traza(array[i].toString() );
          }
      }

      return sBuffer.toString();
  }

  // Por Ssantana, 9/12/2004
  //  param: DTOSalida
  //  returns: RecodSet[] 
  // Desc: creado por inc. 11073, recibe un DTOSalida y arma un array de REcordSet 
  //       con dos elementos, un RecordSet para llenar combo Tipo Despacho,
  //       y el otro para llenar la lista ocultad listaEnvioSolicitud. 
  private RecordSet[] obtieneRecordSetsDespachoSolicitud(DTOSalida dto) throws Exception
  {

    RecordSet[] rArray = new RecordSet[2];
    RecordSet rActividad = null;
    RecordSet rSolicitud = null;

    RecordSet r = dto.getResultado();

    if ( r != null && !r.esVacio() ) 
    {
      Vector vActividad = new Vector();
      vActividad.add("OID");
      vActividad.add("DESC_ACTIVIDAD");

      Vector vSolicitud = new Vector();
      vSolicitud.add("OID_ACTIVIDAD");
      vSolicitud.add("OID_SOLICITUD");
      vSolicitud.add("DESC_SOLICITUD");

      rActividad = new RecordSet();
      rSolicitud = new RecordSet();
      rActividad.setColumnIdentifiers(vActividad);
      rSolicitud.setColumnIdentifiers(vSolicitud);
      
      int cantFilas = r.getRowCount();

      // Procede a armar los recordset a partir del RecordSet principal, fila x fila
      Vector vBuffer = null;
      for (int i = 0; i < cantFilas; i++)
      {
          Long oidActividad = new Long( ((BigDecimal) r.getValueAt(i,0)).longValue() );
          String descActividad = (String) r.getValueAt(i,1);

          Long oidDespacho = null;
          if ( r.getValueAt(i,2) != null )  
           oidDespacho = new Long( ((BigDecimal) r.getValueAt(i,2)).longValue() );

          String descDespacho = null;
          if ( r.getValueAt(i,3) != null )
           descDespacho = (String) r.getValueAt(i,3); 

          vBuffer = new Vector(); 
          vBuffer.add(oidActividad);
          vBuffer.add(descActividad);
          rActividad.addRow(vBuffer);

          if ( oidDespacho != null) // Si no hay OidDespacho, entonces la desc. tambien será null.
          {
              vBuffer = new Vector();
              vBuffer.add(oidActividad);
              vBuffer.add(oidDespacho);
              vBuffer.add(descDespacho);
              rSolicitud.addRow(vBuffer);
          }

      }

      traza("rActividad: " + rActividad);
      traza("rSolicitud: " + rSolicitud);
      if ( rSolicitud.getRowCount() == 0 )
        rSolicitud = null;

    } else
    {
      traza("RecordSet de DTO es vacio");
    }
    
    rArray[0] = rActividad;
    rArray[1] = rSolicitud;

    return rArray;
  }

    /*
     * Agregado para resolver incidencia SiCC20070189 - 23/04/2007
     * JVM-RRV
     */
    private void desActiva(String sOidDetalle) throws Exception 
    {
        this.pagina("salidaGenerica");
        this.asignarAtributo("VAR", "cerrarVentana", "valor", "false");
    
        try {
            DTOOID dtoOid = new DTOOID();
    
            Long oid = new Long(sOidDetalle);
            dtoOid.setOid(oid);
    
            DruidaConector con = null;
            Vector params = new Vector();
            MareBusinessID bussId = new MareBusinessID("MAVDesActivaDetalleMAV");
    
            params.add(dtoOid);
            params.add(bussId);
            traza("DesActivar Detalle, dtoOid a enviar: " + dtoOid);
            traza("Antes de conectar");
            con = this.conectar("ConectorDesActivaDetalleBP", params);
            traza("Luego de conectar");   
            
        } catch(Exception ex)
        {
          //this.lanzarPaginaError(ex);
          //ex.printStackTrace();
          traza("--- Exception guardando");
          asignarAtributo("VAR", "ejecutar", "valor", "errorAlDesActivar()");
          throw ex;
        }
        traza("No hubo excepcion al desactivar");
        asignarAtributo("VAR", "ejecutar", "valor", "noHayError()");
    }

    // sapaza -- PER-SiCC-2010-0578 -- 06/10/2010
    private String formateaMonto(String dineroEntrada){
		String separadorMiles = ",";
		String separadorDecimales = UtilidadesSession.getSeparadorDecimales(this);
		String numeroDecimales = UtilidadesSession.getFormatoNumerico(this);
		if (separadorDecimales.equals(",")) separadorMiles=".";
		
		StringTokenizer tokens=new StringTokenizer(dineroEntrada, ".");
		StringBuffer bufferEntero=new StringBuffer(tokens.nextToken());// almacena la parte entera.
		StringBuffer bufferDinero=new StringBuffer();//almacena el resultado
		StringBuffer bufferDecimales=new StringBuffer();//almacena la parte decimal
		
		//Si ya contiene los separadores de mil no formateamos la cadena
		for (int i=0; i<bufferEntero.length(); i++) {
			if (bufferEntero.charAt(i) == separadorMiles.charAt(0)) return dineroEntrada;
		}
		int miles=0;
		while (bufferEntero.length()>0) {
			miles++;
			bufferDinero.insert(0, bufferEntero.charAt(bufferEntero.length()-1));
			bufferEntero.deleteCharAt(bufferEntero.length()-1);
			if (miles==3 && bufferEntero.length()>0) {
				miles=0;
				bufferDinero.insert(0, separadorMiles);
			}
		}

		if (numeroDecimales != null && tokens.hasMoreTokens()) { 
			bufferDecimales.append(tokens.nextToken());
			//Scale siempre vendrá a 00? //creo que en plantillas puede ser de longitud 0
			//if (!bufferDecimales.substring(0, bufferDecimales.length()).equals("00") && !bufferDecimales.substring(0, bufferDecimales.length()).equals("0")) {
				if (numeroDecimales.equals("1")) 
					bufferDinero.append(separadorDecimales + bufferDecimales.substring(0,1));
				else if (numeroDecimales.equals("2")) {
					if (bufferDecimales.length() == 2) 
						bufferDinero.append(separadorDecimales + bufferDecimales.substring(0, 2));
					else if (bufferDecimales.length() == 1)
						bufferDinero.append(separadorDecimales + bufferDecimales.substring(0, 1) + "0");
				}

			//}
		}		
		
		
		return bufferDinero.toString();

	}

    private Map parseaUnidades(String sCadena) throws Exception {
        traza(" ---- parseaUnidades ----");
        traza("sCadena: " + sCadena);
        StringTokenizer tok = new StringTokenizer(sCadena, "|");
        Map unidades = new HashMap();
        	
        int i = 0;
        while ( tok.hasMoreTokens() ) {
           String sToken = tok.nextToken();
           traza("sToken: " + sToken);
           
           StringTokenizer tokAux = new StringTokenizer(sToken, "_");
           String claveUA = tokAux.nextToken();
           String valorUA = tokAux.nextToken();
           
           if(valorUA.equals("NULL")) {
        	   valorUA = null;
           }
           
           unidades.put(claveUA, valorUA);
        }

        traza(" ---- End parseaUnidades ----");

        return unidades;
    }
    
}
