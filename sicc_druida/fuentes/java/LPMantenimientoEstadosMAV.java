import LPSICCBase;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.util.Date;
import java.util.Vector;
import java.util.StringTokenizer;
import es.indra.sicc.dtos.mav.DTOEstadoMAV;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

                          
public class LPMantenimientoEstadosMAV  extends LPSICCBase{
  private String casoDeUso = null;
  private String accion = null;
  private Long idioma = null;
  private Long pais = null;
  private String descPais = null;
  private String oide =null;
  private String estatus1 =null;
  private String estatus2 =null;
  private String ipcliente =null;
  private String programa =null;
  private String detalle=null; 
  private String  esta1 = null;
  
  public LPMantenimientoEstadosMAV() 
  {
    super();
  }
             
   public void inicio() throws Exception
   {
   }
  
  public void ejecucion() throws Exception
  {
    /*-----------------------------------------------------------------------------
    Acción "consultar" 
       // Carga de ventana de búsqueda, aplica paginación 
       -> Asignar pantalla "contenido_estados_consultar" y presentar vacía 
       -> Tomar variable de sesión "casodeuso" y habilitar botón "detalle" para casos Consultar y Eliminar 
    Acción "detalle" 
       // Se consulta un registro y se muestra el detalle 
       -> Asignar página "contenido_estados_insertar" 
       -> Tomar de pantalla el oid del registro seleccionado para modificación 
       -> Crear objeto DTOOID 
       -> Crear idBusiness = "MAVConsultarEstadoMAV" 
       -> Asignar conector "ConectorConsultarEstadoMAV" 
       -> Recuperar objeto "DTOEstadoMAV" de salida 
       -> Mapear todos los datos a pantalla y deshabilitar todos los campos 
    Acción "insertar" 
       // Se carga pantalla de inserción 
       -> Asignar página "contenido_estados_insertar" 
       -> Crear objeto DTOBelcorp 
       -> Llamar al subsistema GestorCargaPantalla con los siguientes datos: 
       - idBusiness "MAEObtenerEstatusCliente" y "DTOBelcorp" => llena combo "estatus1" 
    Acción "modificar" 
        // Se carga pantalla de modificación con registro seleccionado 
        -> Asignar página "contenido_estados_insertar" 
        -> Tomar de pantalla el oid del registro seleccionado para modificación 
        -> Crear objeto DTOOID 
        -> Crear idBusiness = "MAVConsultarEstado" 
        -> Asignar conector "ConectorConsultarEstadoMAV" 
        -> Recuperar objeto "DTOEstadoMAV" de salida 
        // Carga de combos de pantalla 
        -> Crear objeto DTOBelcorp 
        -> Llamar al subsistema GestorCargaPantalla con los siguientes datos: 
        - idBusiness "MAEObtenerEstatusCliente" y "DTOBelcorp" => llena combo "estatus1" 
        -> Seleccionar en el combo multiselección rellenado los estatus del registro recuperado 
    Acción "guardar" 
        // Se guarda inserción o modificación 
        -> Tomar los datos de la pantalla y crear objeto "DTOEstadoMAV" 
        -> Crear idBusiness = "MAVGuardarEstadoMAV" 
        -> Asignar conector "ConectorGuardarEstadoMAV"
     ------------------------------------------------------------------------------*/
      try
      {
        setTrazaFichero();
        casoDeUso = conectorParametro("casoDeUso")==null?"":conectorParametro("casoDeUso");
        accion = conectorParametro("accion")==null?"":conectorParametro("accion");
        pais = UtilidadesSession.getPais(this);
        idioma=	UtilidadesSession.getIdioma(this);
        ipcliente= UtilidadesBelcorp.getIPCliente(this);
        programa = UtilidadesSession.getFuncion(this);
        descPais = UtilidadesSession.getDescripcionPais(this);
       // idioma = UtilidadesSession.getIdioma(this);
        oide = conectorParametro("oide");
        detalle= conectorParametro("detalle");
        /* trae valor de los combos*/
        estatus1  = conectorParametro("cbEstatus1");
        
        estatus2  = conectorParametro("cbEstatus2");
        
        traza("al comienzo");
        esta1= conectorParametro("esta1");
        if (esta1==null){
          esta1="";
        }
        if (oide ==null) {
          oide ="";
        }
        if (detalle ==null) {
          detalle ="";
        }
        traza("---------------------------------------------------------------");
        traza("caso de uso " +casoDeUso+" accion "+ accion);
 
        if (accion.equals("consultar"))
        {
          /*----------------------------------------------------------------------------------
          Acción "consultar" 
          // Carga de ventana de búsqueda, aplica paginación 
          -> Asignar pantalla "contenido_estados_consultar" y presentar vacía 
          -> Tomar variable de sesión "casodeuso" y habilitar botón "detalle" para casos Consultar y Eliminar
          ----------------------------------------------------------------------------------------------*/
          pagina("contenido_estados_consultar");
          if (casoDeUso.equals("consultar")){
          asignarAtributoPagina("cod","0415");  
          getConfiguracionMenu("LPMantenimientoEstadosMAV","consultar");
          }
          if (casoDeUso.equals("modificar")){
            asignarAtributoPagina("cod","0414");
            getConfiguracionMenu("LPMantenimientoEstadosMAV","consultar");
          }
          if (casoDeUso.equals("eliminar")){
          traza ("entra para codigos eliminar");
            asignarAtributoPagina("cod","0416");
            getConfiguracionMenu("LPMantenimientoEstadosMAV","eliminar");
          }
          traza ("entra despues de asignacion pantalla");
          ByteArrayOutputStream pila = new ByteArrayOutputStream();
          PrintStream out = new PrintStream(pila);
          String classPath = System.getProperty("java.class.path");
          traza("Old Classpath: "+classPath);
          if(classPath.indexOf("/var/opt/sicc3desa/lib/entidades-mav.jar:") == -1){
          traza("no existe en el calsspath");
          }else {
          traza(" existe en el calsspath");
          }
  
          //getConfiguracionMenu("LPMantenimientoEstadosMAV","consultar");
          asignarAtributo("VAR","casoDeUso","valor",this.casoDeUso);
          asignarAtributo("VAR","accion","valor",this.accion);
          asignarAtributo("VAR","idioma","valor",this.idioma.toString());
    		                      




        }

        if (accion.equals("detalle"))
        { /*  Acción "detalle" 
          // Se consulta un registro y se muestra el detalle 
          -> Asignar página "contenido_estados_insertar" 
          -> Tomar de pantalla el oid del registro seleccionado para modificación 
          -> Crear objeto DTOOID 
          -> Crear idBusiness = "MAVConsultarEstadoMAV" 
          -> Asignar conector "ConectorConsultarEstadoMAV" 
          -> Recuperar objeto "DTOEstadoMAV" de salida 
          -> Mapear todos los datos a pantalla y deshabilitar todos los campos*/ 
          
            pagina("contenido_estados_insertar");
          if (casoDeUso.equals("consultar")){
          asignarAtributoPagina("cod","0415");  
          getConfiguracionMenu("LPMantenimientoEstadosMAV","detalle");
          }
          if (casoDeUso.equals("modificar")){
            asignarAtributoPagina("cod","0414");
            getConfiguracionMenu("LPMantenimientoEstadosMAV","modificar");
          
          }
            if (casoDeUso.equals("eliminar")){
          traza ("entra para codigos eliminar");
            asignarAtributoPagina("cod","0416");
            getConfiguracionMenu("LPMantenimientoEstadosMAV","eliminar");
          }
            
            DTOOID est =new DTOOID();
            est.setIpCliente(ipcliente);
            est.setOid(new Long (detalle));
            est.setOidIdioma(idioma);
            est.setOidPais(pais);
            est.setPrograma(programa);
            traza ("est"+est);
            Vector vec = new Vector();
            MareBusinessID mar = new MareBusinessID("MAVConsultarEstadoMAV");
            vec.add(est);
            vec.add(mar);
            traza("llega");
            DruidaConector llamada = conectar("ConectorConsultarEstadoMAV",vec);
            traza("llega 2");
            DTOEstadoMAV resul =(DTOEstadoMAV) llamada.objeto("DTOEstadoMAV");
            traza ("DTOEstadoMAV "+ resul );
            /*falta asignacion */
            //asignar("CTEXTO", "cbEstatus1", resultados, "MAEObtenerEstatusCliente");
            
            Vector aux=resul.getEstadosMAE();
            traza("recorset");
            RecordSet des =(RecordSet) aux.firstElement();
            traza("despues del dto");
            Vector codigos =des.getColumn(0);
            traza("despues de column");
            
            String estatus_cli =null;
            for (int i=0 ;i < codigos.size();i++){
              if (i==0){
                estatus_cli = codigos.get(i).toString();
              }
              else{
                estatus_cli=estatus_cli+"|"+ codigos.get(i).toString();
              }
              
            }
           
            String esta2=null;
            if (resul.getNoActivo().equals(new Boolean(true))){
              esta2="1";
            }
            else {
              esta2="0";
            }
            

            if (resul.getActivo().equals(new Boolean(true))){
              esta2=esta2+"1";
            }
            else {
              esta2=esta2+"0";
            }
            traza("estad2"+esta2);
            
            /*carga combo con todos los valores */
            DruidaConector resultados =  CargaCombos();
            traza("antes asignacion combo");
            asignar ("COMBO", "cbEstatus1", resultados, "MAEObtenerEstatusCliente");
            traza ("antes auxi");
            String auxi = (String) resul.getDescripcion().firstElement();
            //Long num = (Long) resul.getDescripcion().get(1); 
            //traza (num);
            if (casoDeUso.equals("modificar")){
            traza(" anyade true");
            anyadeHiddensI18N(true, "MAV_ESTAD_MAV", est.getOid(), new Integer(1),"frmInsertarActividades", "txtDescripcionEstado", false);
            }else{
            traza(" anyade false");
            anyadeHiddensI18N(true, "MAV_ESTAD_MAV", est.getOid(), new Integer(1),"frmInsertarActividades", "txtDescripcionEstado", true);  
            }
               
            if (auxi==null) {
              auxi="";
            }
            traza("auxi"+auxi);
            asignarAtributo("VAR","CTEXTO","valor",auxi);
            traza("despues c texto"+auxi);
            /* valores a las varibles ocultas */
            asignarAtributo("VAR","esta2","valor",esta2);
            asignarAtributo("VAR","detalle","valor",detalle);
            asignarAtributo("VAR","esta1","valor",estatus_cli);
            asignarAtributo("VAR","accion","valor",this.accion);
            asignarAtributo("VAR","casoDeUso","valor",this.casoDeUso);
            asignarAtributo("VAR","idioma","valor",this.idioma.toString());
            
            
            /*sirve
             * Vector columnas = des.getColumnIdentifiers();
                                        
            DruidaConector dtipo =   UtilidadesBelcorp.generarConector("DTOSalida.tipos_ROWSET",des, columnas);
            asignar("COMBO","cbEstatus1",dtipo,"DTOSalida.tipos_ROWSET");
            */
            /*RecordSet tipo = (RecordSet)dtotsubtipo.getTipos();
                Vector colID = tipo.getColumnIdentifiers();
                DruidaConector dtipo = this.generarConector("DTOSalida.tipos_ROWSET",tipo, colID);
                asignar("COMBO","comboTipoCliente",dtipo,"DTOSalida.tipos_ROWSET");
            */

          
            
        }
        if (accion.equals("insertar")) 
        {/* // Se carga pantalla de inserción 
            -> Asignar página "contenido_estados_insertar" 
            -> Crear objeto DTOBelcorp 
            -> Llamar al subsistema GestorCargaPantalla con los siguientes datos: 
            - idBusiness "MAEObtenerEstatusCliente" y "DTOBelcorp" => llena combo "estatus1" 
            */
            pagina("contenido_estados_insertar");
            asignarAtributoPagina("cod","0413");
            traza("despues de la pagina");
			
           // getConfiguracionMenu("LPMantenimientoEstadosMAV","insertar");
            anyadeHiddensI18N(false, "MAV_ESTAD_MAV", null, new Integer(1),"frmInsertarActividades", "txtDescripcionEstado", false);

            traza("despues de la internacionalizacion");
            //Cargamos los combos con los resultados
            DruidaConector resultados =  CargaCombos();
            
            asignar("COMBO", "cbEstatus1", resultados, "MAEObtenerEstatusCliente");
            asignarAtributo("VAR","accion","valor",this.accion);
            asignarAtributo("VAR","casoDeUso","valor",this.casoDeUso);
            traza ("caso  de uso " + casoDeUso);
            asignarAtributo("VAR","idioma","valor",this.idioma.toString());
            getConfiguracionMenu("LPMantenimientoEstadosMAV","insertar");
            traza ("despues de la configureacion");
            //asignarAtributoPagina("cod","0599");
                 
        }
        if (accion.equalsIgnoreCase("guardar") && casoDeUso.equalsIgnoreCase("insertar")) 
        { 
          pagina("contenido_estados_insertar");
          traza("despues de pagina"); 
          traza("ipcliente" + ipcliente);
          anyadeHiddensI18N(false, "MAV_ESTAD_MAV", null, new Integer(1),"frmInsertarActividades", "txtDescripcionEstado", false);
          Vector status1 = new Vector();
          /* recupero descripcion internacionalizable */
          Vector inter = recuperaTraduccionesI18N(new Integer(1));
          DTOEstadoMAV estados = new DTOEstadoMAV();
		  /* meto en el dto la descripcion internacionalizable */
          estados.setDescripcion(inter);
		  
          estados.setIpCliente(ipcliente);
          estados.setPrograma(programa);
          /* inserto valores del estado activo e inactivo segun lo que venga */
          traza ("estaus 2 "+estatus2); 
          StringTokenizer codi2 =new StringTokenizer(estatus2,"|");
          if (codi2.countTokens()>1) 
          { /*ci tengo mas de un estatus de cliente */
            traza("entra por el if que correspodnde");
            estados.setNoActivo(new Boolean(true));
            estados.setActivo(new Boolean(true));
          }
          else 
          {
            if (estatus2.equals("0")) 
            {
              traza ("entra por no activo");
              estados.setNoActivo(new Boolean(true));
              estados.setActivo(new Boolean(false));
            }
            else 
            {
              traza ("entra por activo");
              estados.setNoActivo(new Boolean(false));
              estados.setActivo(new Boolean(true));  
            }
          }
          StringTokenizer codi =new StringTokenizer(estatus1,"|");
          /* si tengo seleccionados varios estados de cliente o si tengo so,lo uno*/
          if (codi.countTokens()>=1) 
          { /*ci tengo mas de un estatus de cliente */
            while (codi.hasMoreTokens()) 
            {/*coloco los estatus en un vector */
                status1.add(codi.nextToken());  
            }
          }
          else 
          {/*coloco el unico estatus seleccionado en un vector */
           status1.add(estatus1);  
          }
          
          /*inserto en el dto los estatus*/
          estados.setEstadosMAE(status1);
          /*inserto demas datos */
          estados.setOidPais(pais);
          estados.setOidIdioma(idioma);
          /* mare bussiness conecto y llamada*/
          
          MareBusinessID bdpreparadaID = new MareBusinessID("MAVGuardarEstadoMAV");
          Vector vec =new Vector();
          vec.add(estados);
          vec.add(bdpreparadaID);
          traza("antes del conectar");
         conectar("ConectorGuardarEstadoMAV",vec);
          traza("despues del conectar");		  		
        
          DruidaConector resultados =  CargaCombos();
          asignar("COMBO", "cbEstatus1", resultados, "MAEObtenerEstatusCliente");
          
          asignarAtributo("VAR","accion","valor",this.accion);
          asignarAtributo("VAR","casoDeUso","valor",this.casoDeUso);
         	asignarAtributo("VAR","idioma","valor",this.idioma.toString());
        }
        
         if (accion.equalsIgnoreCase("guardar") && casoDeUso.equalsIgnoreCase("modificar")) 
        { 
          pagina("contenido_estados_insertar");
          traza("despues de pagina"); 
          traza("ipcliente" + ipcliente);
          anyadeHiddensI18N(false, "MAV_ESTAD_MAV", new Long (detalle), new Integer(1),"frmInsertarActividades", "txtDescripcionEstado", false);
          Vector status1 = new Vector();
          /* recupero descripcion internacionalizable */
          Vector inter = recuperaTraduccionesI18N(new Integer(1));
          DTOEstadoMAV estados = new DTOEstadoMAV();
          /* meto en el dto la descripcion internacionalizable */
          estados.setDescripcion(inter);
          estados.setOidEstadoMAV(new Long(detalle));
          estados.setIpCliente(ipcliente);
          estados.setPrograma(programa);
          traza("estatus2"+estatus2);
          /* inserto valores del estado activo e inactivo segun lo que venga */
          StringTokenizer codi2 =new StringTokenizer(estatus2,"|");
          if (codi2.countTokens()>1) 
          { /*ci tengo mas de un estatus de cliente */
            traza("entra por el if que correspodnde");
            estados.setNoActivo(new Boolean(true));
            estados.setActivo(new Boolean(true));
          }
          else 
          {
            if (estatus2.equals("0")) 
            {
              traza("entra por el if noactivo");
              estados.setNoActivo(new Boolean(true));
              estados.setActivo(new Boolean(false));
            }
            else 
            {
              traza("entra por el if activo");
              estados.setNoActivo(new Boolean(false));
              estados.setActivo(new Boolean(true));  
            }
          }
          StringTokenizer codi =new StringTokenizer(estatus1,"|");
          /* si tengo seleccionados varios estados de cliente o si tengo so,lo uno*/
          if (codi.countTokens()>=1) 
          { /*ci tengo mas de un estatus de cliente */
            while (codi.hasMoreTokens()) 
            {/*coloco los estatus en un vector */
                status1.add(codi.nextToken());  
            }
          }
          else 
          {/*coloco el unico estatus seleccionado en un vector */
           status1.add(estatus1);  
          }
          
          /*inserto en el dto los estatus*/
          estados.setEstadosMAE(status1);
          /*inserto demas datos */
          estados.setOidPais(pais);
          estados.setOidIdioma(idioma);
          /* mare bussiness conecto y llamada*/
          traza("estado "+estados);
          MareBusinessID bdpreparadaID = new MareBusinessID("MAVGuardarEstadoMAV");
          Vector vec =new Vector();
          vec.add(estados);
          vec.add(bdpreparadaID);
          traza("antes del conectar");
         conectar("ConectorGuardarEstadoMAV",vec);
          traza("despues del conectar");		  		
        
          DruidaConector resultados =  CargaCombos();
          asignar("COMBO", "cbEstatus1", resultados, "MAEObtenerEstatusCliente");
          
          asignarAtributo("VAR","accion","valor",this.accion);
          asignarAtributo("VAR","casoDeUso","valor",this.casoDeUso);
         	asignarAtributo("VAR","idioma","valor",this.idioma.toString());
          
        }

        
      }
      catch (Exception ex) 
      {
        java.io.StringWriter sw = new java.io.StringWriter();
        java.io.PrintWriter pw = new java.io.PrintWriter(sw);
        ex.printStackTrace(pw);
        preservaHiddensI18n(new Integer(1),"MAV_ESTAD_MAV","frmInsertarActividades","txtDescripcionEstado", false);
        pw.flush();
        if (accion.equalsIgnoreCase("guardar") || accion.equals("detalle")|| accion.equals("insertar"))
        {
        DruidaConector resultados =  CargaCombos();
        asignar("COMBO", "cbEstatus1", resultados, "MAEObtenerEstatusCliente");
        }
        this.lanzarPaginaError(ex);  
        
      }
  }

	private DruidaConector CargaCombos() throws Exception
  {
    //Este método es un ejemplo de combo utilizar el subsistema de carga inicial 
    //  para cargar combos
    //Preparamos los parametros del subsistema
		ComposerViewElementList cv = crearParametrosEntrada();
		//Utilizamos el subsistema
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();
		return resultados;
	}

	private ComposerViewElementList crearParametrosEntrada(){
		ComposerViewElementList lista = new ComposerViewElementList(); 
		//Primer combo
		ComposerViewElement ci1 = new ComposerViewElement();
		ci1.setIDBusiness("MAEObtenerEstatusCliente");
    DTOBelcorp dto =new DTOBelcorp();
    dto.setOidIdioma(idioma);
    dto.setOidPais(pais);
    ci1.setDTOE(dto);

		//Refefinimos la posición de las columnas porque el resultado de 
		// la operación de negocio no es estándar
		//ci2.setPosOID((byte)2);
		//ci2.setPosDesc((byte)0);
		
		lista.addViewElement(ci1);
		//lista.addViewElement(ci2);
		return lista;
	}



}


