

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.ccc.DTOCargaMarcasTipoAbono;
import es.indra.sicc.dtos.ccc.DTOCollection;
import es.indra.sicc.dtos.ccc.DTOConsultarMarcasTipoAbono;
import es.indra.sicc.dtos.ccc.DTOMarcasPorTipoAbono;
import es.indra.sicc.util.DTOBelcorp;

import es.indra.sicc.util.DTOSalida;

import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.math.BigDecimal;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;




import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

public class LPMarcasTipo extends LPSICCBase {
  private String mAccion = null;
  private String mCasoDeUso = null;
  private String oid = null;
  private String oidProceso  = null;
  private String oidSubproceso = null;
  private String oidTipoAbono = null;
  private String mPais = null;     
  private String mIdioma = null;
  private String mDescPais = null;   
  private Long oIdPais = null;     
  private Long oIdioma = null;
  
  

  public LPMarcasTipo() { super(); }

	public void inicio() throws Exception { }
  
  
  public void ejecucion() throws Exception {    
  setTrazaFichero();    
  
  mPais = UtilidadesSession.getPais(this).toString();
  mDescPais = UtilidadesSession.getDescripcionPais(this).toString();
  mIdioma = UtilidadesSession.getIdioma(this).toString();
  
  oIdioma = UtilidadesSession.getIdioma(this);
  oIdPais = UtilidadesSession.getPais(this);
  
  asignarAtributo("VAR", "hIdioma", "valor", mIdioma);
  mAccion = conectorParametroLimpia("accion", "", true);
  mCasoDeUso = conectorParametro("casoDeUso");
  oid = conectorParametro("oid");
  oidSubproceso = conectorParametro("oidSubproceso");
  oidTipoAbono = conectorParametro("oidTipoAbono");
  oidProceso = conectorParametro("oidProceso");
  
  traza("************** EJECUCCION: " );
  traza("************** Cuando entre a ejecucion oid: " + oid);
    
  try {
         traza("************ caso de uso:" + mCasoDeUso);
         traza("************ accion:" + mAccion);
          
         if(mAccion.equals(""))  { 
             inicializar(); 
             //cargaInicialInsertar();
         } else if(mAccion.equals("guardar")) {           
              guardar();
		 } else if(mAccion.equals("modificar")) {           
			//cargaModificar();
			 traza ("modificar"); 
			 pagina("contenido_marcas_situacion_relacionadas_insertar");
			 cargaModificar(new Long(oid));
		 } else if(mAccion.equals("detalle")) {
			 pagina("contenido_marcas_situacion_relacionadas_insertar");
			 cargaConsultar(new Long(oid));            
			 //cargaConsultar();            
          }
        cargarMenuSecundario();
      }  catch ( Exception e )  {
              traza("pincho la lp principal");
              ByteArrayOutputStream pila = new ByteArrayOutputStream();
              PrintStream out = new PrintStream(pila);
              e.printStackTrace(out);
              traza("EL STACK ES COMO SIGUE : " +  pila.toString());
              e.printStackTrace(); 
              e.getMessage();
              lanzarPaginaError(e);
    } 
}     
       
  
public void inicializar() throws Exception {
    
    traza("Inicializar");
    setTrazaFichero();    
    mPais = UtilidadesSession.getPais(this).toString();
    mDescPais = UtilidadesSession.getDescripcionPais(this).toString();
    mIdioma = UtilidadesSession.getIdioma(this).toString();
    
    mAccion = conectorParametroLimpia("accion", "", true);
    mCasoDeUso = conectorParametro("casoDeUso");
    
    oid = conectorParametro("oid");
    oidSubproceso = conectorParametro("oidSubproceso");
    oidTipoAbono = conectorParametro("oidTipoAbono");

    traza("************** Cuando entre a inicializar oid: " + oid);
    
    try {
          traza("************ caso de uso:" + mCasoDeUso);
          traza("************ accion:" + mAccion);
          if(mCasoDeUso.equals("insertar")) { 
                  pagina("contenido_marcas_situacion_relacionadas_insertar");  
                  asignarAtributo("VAR", "casoDeUso", "valor", mCasoDeUso );
                  cargaInicial();
          }else if  (mCasoDeUso.equals("modificar")){ 
                pagina("contenido_marcas_situacion_relacionadas_modificar");
                asignarAtributo("VAR", "casoDeUso", "valor", mCasoDeUso );
                cargarProcesos();
                //Habilita el botón btBuscar 
                //Oculta la lista de resultados 
                //Oculta el boton btDetalle 
        }else if  ((mCasoDeUso.equals("eliminar")) || (mCasoDeUso.equals("consultar"))) { 
                pagina("contenido_marcas_situacion_relacionadas_modificar");
                asignarAtributo("VAR", "casoDeUso", "valor", mCasoDeUso );
                cargarProcesos();
                //Habilita el botón btBuscar 
                //Oculta la lista de resultados 
                //Oculta el boton btModificar 
        }
		asignarAtributo("VAR", "hIdioma", "valor", mIdioma);
        cargarMenuSecundario();

    } catch ( Exception e )  {
              traza("pincho la lp principal");
              ByteArrayOutputStream pila = new ByteArrayOutputStream();
              PrintStream out = new PrintStream(pila);
              e.printStackTrace(out);
              traza("EL STACK ES COMO SIGUE : " +  pila.toString());
              e.printStackTrace(); 
              e.getMessage();
              lanzarPaginaError(e);
    }    
}

public void cargarProcesos() throws Exception {
try   {
    

        traza ("Entra cargar Procesos");
        ComposerViewElementList cv = crearParametrosEntrada();
        traza("1");
        //Utilizamos el subsistema
        ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
        traza (conector);
        conector.ejecucion();
        traza ("3");
        DruidaConector resultados = conector.getConector();
        traza ("4");
        //Cargamos los combos con los resultados
        asignar("COMBO", "cmbProcesos", resultados, "CCCObtieneProcesos");
        traza ("5");
        } catch ( Exception e )  {
              ByteArrayOutputStream pila = new ByteArrayOutputStream();
              PrintStream out = new PrintStream(pila);
              e.printStackTrace(out);
              traza("EL STACK ES COMO SIGUE : " +  pila.toString());
              e.printStackTrace(); 
              e.getMessage();
              lanzarPaginaError(e);
    }    
		




}

private ComposerViewElementList crearParametrosEntrada(){
		
    DTOBelcorp dtoe = new DTOBelcorp();
    dtoe.setOidIdioma(oIdioma);
    dtoe.setOidPais(oIdPais);
    ComposerViewElementList lista = new ComposerViewElementList(); 
		//Primer combo
		ComposerViewElement ci1 = new ComposerViewElement();
		ci1.setIDBusiness("CCCObtieneProcesos");
		ci1.setDTOE(dtoe);
		lista.addViewElement(ci1);
		return lista;
	}



public void cargarMarcasSituacion() throws Exception{

    traza("cargarMarcasSituacion()");
    Vector paramEntrada = new Vector();

    DTOBelcorp dtoe = new DTOBelcorp();
    dtoe.setOidIdioma(oIdioma);
    dtoe.setOidPais(oIdPais);
    
	  MareBusinessID id = new MareBusinessID("CCCcargaMarcasTipo");
    

	  paramEntrada.addElement(dtoe);
	  paramEntrada.addElement(id);
    
    traza (paramEntrada);
    traza("antes de conectar");
	  DruidaConector con = conectar("ConectorCargaMarcasTipo", paramEntrada);
    traza("despues de conectar");
    traza(con);

    asignar("LISTADOA", "listado1",con, "dtoSalida.resultado_ROWSET");	 

}


  
  
  /*
  public void ejecucion2() throws Exception {    
    setTrazaFichero();    
    mPais = UtilidadesSession.getPais(this).toString();
    mDescPais = UtilidadesSession.getDescripcionPais(this).toString();
    mIdioma = UtilidadesSession.getIdioma(this).toString();
    asignarAtributo("VAR", "hIdioma", "valor", mIdioma);
    mAccion = conectorParametroLimpia("accion", "", true);
    mCasoDeUso = conectorParametro("casoDeUso");
    oid = conectorParametro("oid");

    traza("************** Cuando entre a ejecucion oid: " + oid);
    
    try {
      traza("************ caso de uso:" + mCasoDeUso);
      traza("************ accion:" + mAccion);
      
       if(mCasoDeUso.equals("insertar")) {   
          pagina("contenido_marcas_situacion_relacionadas_insertar");          
          if(mAccion.equals(""))  {            
             cargaInicialInsertar();
          }          
          else if(mAccion.equals("guardar")) {           
            guardar();
          }
       }
        
       else if((mCasoDeUso.equals("consultar")) || (mCasoDeUso.equals("modificar")) || (mCasoDeUso.equals("eliminar"))) {
          if(mAccion.equals("")) {
            pagina("contenido_marcas_situacion_relacionadas_modificar");
            cargaInicial();           
          }
          
          else if(mAccion.equals("Mostrar datos")) {
            pagina("contenido_marcas_situacion_relacionadas_insertar");
            asignarAtributoPagina("cod","0405");            
            cargaModificar(new Long(oid));            
          }
          
          else if(mAccion.equals("detalle")) {
            pagina("contenido_marcas_situacion_relacionadas_insertar");
            cargaConsultar(new Long(oid));            
          }
          else if(mAccion.equals("guardar")) {            
            pagina("contenido_marcas_situacion_relacionadas_insertar");
            guardar();            
          }         
        }
        cargarMenuSecundario();
   
    }
    catch ( Exception e )  {
      traza("pincho la lp principal");
      ByteArrayOutputStream pila = new ByteArrayOutputStream();
      PrintStream out = new PrintStream(pila);
      e.printStackTrace(out);
      traza("EL STACK ES COMO SIGUE : " +  pila.toString());
		  e.printStackTrace(); 
		  e.getMessage();
		  lanzarPaginaError(e);
    }
  }
*/


   private void guardar() throws Exception {
      traza("******************* Entre al guardar - LPMarcasTipo ***********************");

      pagina("salidaGenerica");

      String observaciones = null;
      String tipoAbono = null;

      observaciones = conectorParametro("varObservaciones");
      tipoAbono = conectorParametro("varTipoAbono");

      if(observaciones==null) observaciones = "";
      if(tipoAbono==null) tipoAbono = "";      

      traza("******************* oid: " + oid);
      traza("******************* observaciones: " + observaciones);
      traza("******************* tipoAbono: " + tipoAbono);

      DTOMarcasPorTipoAbono dto = new DTOMarcasPorTipoAbono();     
      dto.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
      dto.setPrograma(UtilidadesSession.getFuncion(this));
      dto.setOidPais(new Long(mPais));
      dto.setObservaciones(observaciones);
      dto.setTipoAbono(new Long(tipoAbono));
      
      if (mCasoDeUso.equals("modificar")){
              traza("Seteo el OID ya que estoy por el modificar");
              dto.setOid(new Long(tipoAbono));
              
              
              
              
      }
      
      

      DTOCollection dtoCol = new DTOCollection();
      ArrayList lista = new ArrayList();

      String strMarcaSituacionSalida = null;
      String strMarcaSituacionEntrada = null;

      strMarcaSituacionSalida = conectorParametro("varMarcaSituacionSalida");
      strMarcaSituacionEntrada = conectorParametro("varMarcaSituacionEntrada");
      traza("mss " + strMarcaSituacionSalida);
      traza("mse " + strMarcaSituacionEntrada);

      if(strMarcaSituacionSalida==null) strMarcaSituacionSalida = "";
      if(strMarcaSituacionEntrada==null) strMarcaSituacionEntrada = "";

      traza("******************* oid: " + oid);
      traza("******************* strMarcaSituacionSalida: " + strMarcaSituacionSalida);
      traza("******************* strMarcaSituacionEntrada: " + strMarcaSituacionEntrada);

      if((this.oid==null) || (this.oid.equals(""))) {
        lista.add(0,null);
      }
      else {
        lista.add(0,new Long(this.oid));
      }

      if((strMarcaSituacionSalida==null) || (strMarcaSituacionSalida.equals(""))) {
        lista.add(1,null);
        dto.setMarcaSituacionSalida(null);
      }
      else {
        lista.add(1,new Long(strMarcaSituacionSalida));
        dto.setMarcaSituacionSalida(new Long(strMarcaSituacionSalida));
      }

      if((strMarcaSituacionEntrada!=null) && !(strMarcaSituacionEntrada.equals(""))) {
        StringTokenizer st1 = new StringTokenizer(strMarcaSituacionEntrada,",");
        int cant = st1.countTokens();
        traza("************ cantidad de elementos " + cant);
      
        Long[] array = new Long[cant];

        int i = 0;      
        while(st1.hasMoreTokens()) {
          String elementoI = st1.nextToken();
          traza("************ Elemento: " + elementoI);
          Long elem = new Long(elementoI);
          traza("************ elem: " + elem);
          array[i] = elem;
          i++;
        }
        
        lista.add(2,array);
        dto.setMarcasSituacionEntrada(array);
      }
      else {
        Long[] arrayVacio = new Long[0];
        lista.add(2,arrayVacio);
        dto.setMarcasSituacionEntrada(arrayVacio);
        
      }      
          
      lista.add(3,dto);

      traza("******************* lista: " +  lista);

      dtoCol.setLista(lista);
      
      
      
      MareBusinessID businessID = new MareBusinessID("CCCGuardarMarcasTipo");
      Vector parametros = new Vector();
      //parametros.add(dtoCol);
      
      
      parametros.add(dto);
      parametros.add(businessID);
      traza (parametros);

      try {
        traza("******************* Entrando al try...");
        traza("******************* Antes de conectar");
        DruidaConector con = conectar("ConectorGuardar", parametros);
        traza("******************* Despues de conectar");

        if(this.mCasoDeUso.equals("insertar")) {
          traza("********** Ejecutar llama a reInicio");
          asignarAtributo("VAR","ejecutar","valor","reInicio()");
        }
        else {
          traza("********** Ejecutar llama a reModifica");
          asignarAtributo("VAR","ejecutar","valor","reModifica();");
        }        
      }
      catch(Exception e) {
        traza("******************* Entrando al catch...");
        if(this.mCasoDeUso.equals("insertar")) {
               asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardarI()");
        }
        else {
          asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardarM()");
        }  
        throw e;
      }     
   }
 
   private void cargaInicial() throws Exception {
      
      traza ("************ cargaInicial2 ******* ");

      traza (" Llama a cargarProcesos()");
      cargarProcesos();
      traza(" Llama a cargarMarcasSituacion() ");
      cargarMarcasSituacion();
      
	    asignarAtributo("LABELC", "lblvalorPais", "valor", mDescPais);
      asignarAtributo("VAR", "casoDeUso", "valor", mCasoDeUso );
      asignarAtributo("VAR", "hPais", "valor", mPais);
      asignarAtributo("VAR", "hIdioma", "valor", mIdioma);  
   }

   private void cargaInicialInsertar() throws Exception {
      Vector paramEntrada = new Vector();
    	Long oid = null;
	    DTOCargaMarcasTipoAbono dto = null;  
      traza("esta en carga inicial");
       
	    DTOBelcorp dtoEntrada = new DTOBelcorp();
	    MareBusinessID id = new MareBusinessID("CCCcargaMarcasTipo");
	    dtoEntrada.setOidPais(new Long(mPais));
	    dtoEntrada.setOidIdioma(new Long(mIdioma));
      traza("despues de setear el dto");

	    paramEntrada.addElement(dtoEntrada);
	    paramEntrada.addElement(id);
      traza("despues de setear paramentrada");
     
	    DruidaConector con = conectar("ConectorCargaMarcasTipo",  paramEntrada);
                
      asignar("COMBO","cmbProcesos", con,"dtoSalida.procesos_ROWSET");
      asignar("LISTADOA", "listado1",con, "dtoSalida.marcasSituacion_ROWSET");	    
	    asignarAtributo("LABELC", "lblvalorPais", "valor", mDescPais);
      asignarAtributo("VAR", "casoDeUso", "valor", mCasoDeUso );
      asignarAtributo("VAR", "hPais", "valor", mPais);
      asignarAtributo("VAR", "hIdioma", "valor", mIdioma);      
   }

   private RecordSet cargaInicialConsultarModificar() throws Exception {
      traza("************** Entre a cargaInicialConsultarModificar ***************");
      
      Vector paramEntrada = new Vector();
    	Long oid = null;
	    DTOCargaMarcasTipoAbono dto = null;  
      
      traza("************** DTOBelcorp dtoEntrada = new DTOBelcorp() ***************"); 
	    DTOBelcorp dtoEntrada = new DTOBelcorp();
	    MareBusinessID id = new MareBusinessID("CCCcargaMarcasTipo");
	    dtoEntrada.setOidPais(new Long(mPais));
	    dtoEntrada.setOidIdioma(new Long(mIdioma));

	    paramEntrada.addElement(dtoEntrada);
	    paramEntrada.addElement(id);
      traza("************** Antes de Conectar - cargaInicialConsultar ***************");
     
	    DruidaConector con = conectar("ConectorCargaMarcasTipo",  paramEntrada);
      
      traza("************** Despues de Conectar - cargaInicialConsultar ***************");

      DTOSalida dtoCarga = (DTOSalida)con.objeto("DTOSalida");           
      
      traza("************** Despues del Cast ***************");
      traza (dtoCarga);
      
      
      RecordSet rsOriginal = dtoCarga.getResultado();
      RecordSet rsCompleto = new RecordSet();

      rsCompleto.addColumn(new String("oid"));
      rsCompleto.addColumn(new String("marca"));
      rsCompleto.addColumn(new String("entrada"));
      rsCompleto.addColumn(new String("salida"));

      for (int i = 0 ; i < rsOriginal.getRowCount(); i++){
        BigDecimal codigo = null;
        String marca = null;
        String entrada = new String("N");
        String salida = new String("N");

        codigo = (BigDecimal)rsOriginal.getValueAt(i,0);
        marca = (String)rsOriginal.getValueAt(i,1);
        
        rsCompleto.addRow(new Object[] {codigo, marca , entrada, salida});        
      }
    
      traza("************** El RecordSet original ***************");
      traza("************** rsOriginal " + rsOriginal);
      
      traza("************** El RecordSet completo ***************");
      traza("************** rsCompleto " + rsCompleto);      

      return rsCompleto;
   }



    private void cargaConsultar () throws Exception {
      traza ("Entra a cargaConsultar ()");
    
      Vector paramEntrada = new Vector();
      DTOMarcasPorTipoAbono dto = new DTOMarcasPorTipoAbono();
      dto.setProceso(new Long(oid));
      dto.setSubproceso(new Long(oidSubproceso));
      dto.setTipoAbono(new Long(oidTipoAbono));
      dto.setOidIdioma(oIdioma);
      dto.setOidPais(oIdPais);
      traza(" Seteo todo el dto ");
    
      MareBusinessID id = new MareBusinessID("CCCConsultarMarcasPorTipoAbono");
  	  paramEntrada.addElement(dto);
      paramEntrada.addElement(id);
      
      traza(" Antes de Conectar ");
      DruidaConector con = conectar("ConectorConsultarMarcasTipoAbono",  paramEntrada);
      DTOConsultarMarcasTipoAbono  dtoDatos = (DTOConsultarMarcasTipoAbono)con.objeto("DTOSalida");           
      pagina("contenido_marcas_situacion_relacionadas_insertar");
      
      String procesoDesc = dtoDatos.getProcesoDesc();
      traza("************** procesoDesc: " + procesoDesc);
      String subprocesoDesc = dtoDatos.getSubprocesoDesc();
      traza("************** subprocesoDesc: " + subprocesoDesc);
      String tipoAbonoDesc = dtoDatos.getTipoAbonoDesc();
      traza("************** tipoAbonoDesc: " + tipoAbonoDesc);
      String observaciones = dtoDatos.getObservaciones();

	    if(observaciones == null){
        observaciones = "";
      }
      
      traza("************** observaciones: " + observaciones);
      
      asignarAtributo("LABELC", "lblvalorPais", "valor", mDescPais);
      asignarAtributo("VAR", "hProcesos", "valor", procesoDesc);
      asignarAtributo("VAR", "hSubProcesos", "valor", subprocesoDesc);
      asignarAtributo("VAR", "hTipoCargo", "valor", tipoAbonoDesc);
      asignarAtributo("VAR", "hObservaciones", "valor", observaciones);
      asignarAtributo("VAR", "oid", "valor", oid.toString());
      asignarAtributo("VAR", "casoDeUso", "valor", mCasoDeUso ); 
      
      // VER DESDE ACA SI SIRVE
      //1° Creo un recordset para la salida (si hay)
      RecordSet rsSalida = new RecordSet();

      //2° Le añado las columnas
      rsSalida.addColumn(new String("oid"));
      rsSalida.addColumn(new String("marca"));
      rsSalida.addColumn(new String("entrada"));
      rsSalida.addColumn(new String("salida"));

      //3° Le añado la fila de marca situacion salida (si es que tiene)
      if(dtoDatos.getMarcaSituacionSalida()!=null) {
        rsSalida.addRow(new Object[] {dtoDatos.getMarcaSituacionSalida(), new String(dtoDatos.getMarcaSituacionSalidaDesc()) , new String("N"), new String("S")});             
      }

      traza("************** El RecordSet de Salida ***************");
      traza("************** rsSalida " + rsSalida);

      //4° Creo un recordset para las entradas
      RecordSet rsEntradas = new RecordSet();

      //5° Le añado las columnas
      rsEntradas.addColumn(new String("oid"));
      rsEntradas.addColumn(new String("marca"));
      rsEntradas.addColumn(new String("entrada"));
      rsEntradas.addColumn(new String("salida"));

      //6° Le añado las filas de marca situacion entrada (si es que tiene)     
      if(dtoDatos.getMarcasSituacionEntrada()!=null) {
        Long[] arrayOids = dtoDatos.getMarcasSituacionEntrada();
        int cant = arrayOids.length;

        String[] arrayDesc = dtoDatos.getMarcasSituacionEntradaDesc();

        for(int i=0; i < cant ;i++) {
          rsEntradas.addRow(new Object[] {arrayOids[i], arrayDesc[i] , new String("S"), new String("N")});
        } 
      }
      
      
      traza("************** El RecordSet de Entrada ***************");
      traza("************** rsEntradas " + rsEntradas);
      
      traza ("otra cosa");
      
      
      //7° Al recordset de entrada le añado las filas de marca situacion salida
      traza ("rsSalida.getRowCount()");
      int cantS = rsSalida.getRowCount();
      traza ("rsEntradas.getRowCount");
      int cantE = rsEntradas.getRowCount();
      
      traza ("1");
      
      boolean agrego = false;

      if(cantS > 0) {
        for(int i=0; i < cantS; i++) {
          traza ("Entra al for 1");
          agrego = true;
          Long oidSalida = (Long)rsSalida.getValueAt(i,0);
          traza ("2");
          long lSal = oidSalida.longValue();
          int indice = 0;

          for(int j=0; j < cantE; j++) {
            traza ("Entra al for 2");
            Long oidEntrada = (Long)rsEntradas.getValueAt(j,0);       
            long lEnt = oidEntrada.longValue();
            
            if(lSal==lEnt){
              agrego = false;      
              indice = j;
            }        
          }

          if(agrego) {
            traza ("agrego");
            rsEntradas.addRow(new Object[] {dtoDatos.getMarcaSituacionSalida(), dtoDatos.getMarcaSituacionSalidaDesc() , new String("N"), new String("S")});
          }
          else {
            traza ("no agrego");
            rsEntradas.setValueAt(new String("S"),indice,3); 
          }          
        }       
      }

      traza("************** El RecordSet de Entrada MAS LOS DE SALIDA ***************");
      traza("************** rsEntradas " + rsEntradas);

      traza("************** El RecordSet completo con todas las marcas ***************");
      
      //8° Armar el Recordset final con todas las marcas de la base de datos, 
      // con las marcas chequeadas segun corresponda

      int cantEntradas = rsEntradas.getRowCount();
     // int cantCompleto = rsCompleto.getRowCount();


        traza("************** Antes de entrar al segundo for ***************");
        for(int j=0; j<cantEntradas; j++) {
          Long oidEnt = (Long)rsEntradas.getValueAt(j,0);
          long lent = oidEnt.longValue();

          traza("************** Antes de entrar al if ***************");
          
          traza("************** lent " + lent);
          
          
          }       

      traza("************** El RecordSet DEFINITIVO ***************");


      //9° Le añado el RecordSet a la lista
      rsEntradas.sortByColumn(1,true);
      DruidaConector con2 = UtilidadesBelcorp.generarConector("dtoSalida.marcasSituacion_ROWSET",rsEntradas,rsEntradas.getColumnIdentifiers());      
      asignar("LISTADOA", "listado1",con2, "dtoSalida.marcasSituacion_ROWSET");
      asignarAtributo("AREATEXTO", "areaObservaciones", "readonly", "S");
  }
  
    private void cargaConsultar (Long oid) throws Exception {   
      traza("************** Entre a cargaConsultar ***************");
  	  traza("************** oid: " + oid);      
      
      oidSubproceso = conectorParametro("oidSubproceso");
      oidTipoAbono = conectorParametro("oidTipoAbono");
      oidProceso = conectorParametro("oidProceso");
      
      traza("************** Primero llamo a cargaInicialConsultarModificar ***************");
      RecordSet rsCompleto = cargaInicialConsultarModificar();
      traza("************** Sigamos222... ***************");      

      MareBusinessID id = new MareBusinessID("CCCConsultarMarcasPorTipoAbono");
      
      DTOMarcasPorTipoAbono dto = new DTOMarcasPorTipoAbono();
      dto.setProceso(new Long (oidProceso));
      dto.setSubproceso(new Long(oidSubproceso));
      dto.setTipoAbono(new Long(oidTipoAbono));
      dto.setOidIdioma(oIdioma);
      dto.setOidPais(oIdPais);

      Vector paramEntrada = new Vector();

      paramEntrada.add(dto);
      paramEntrada.add(id);

      traza("************** Antes de conectar ConectorObjeto");
      DruidaConector conectorObjeto = conectar("ConectorObjeto", paramEntrada);
      traza("************** Despues de conectar ConectorObjeto");
      
      DTOConsultarMarcasTipoAbono dtoDatos = (DTOConsultarMarcasTipoAbono) conectorObjeto.objeto("DTOSalida");
      
      String procesoDesc = dtoDatos.getProcesoDesc();
      traza("************** procesoDesc: " + procesoDesc);
      String subprocesoDesc = dtoDatos.getSubprocesoDesc();
      traza("************** subprocesoDesc: " + subprocesoDesc);
      String tipoAbonoDesc = dtoDatos.getTipoAbonoDesc();
      traza("************** tipoAbonoDesc: " + tipoAbonoDesc);
      String observaciones = dtoDatos.getObservaciones();

	    if(observaciones == null){
        observaciones = "";
      }
      traza("************** observaciones: " + observaciones);

      asignarAtributo("LABELC", "lblvalorPais", "valor", mDescPais);
      asignarAtributo("VAR", "hProcesos", "valor", procesoDesc);
      asignarAtributo("VAR", "hSubProcesos", "valor", subprocesoDesc);
      asignarAtributo("VAR", "hTipoCargo", "valor", tipoAbonoDesc);
      asignarAtributo("VAR", "hObservaciones", "valor", observaciones);
      asignarAtributo("VAR", "oid", "valor", oid.toString());
      asignarAtributo("VAR", "casoDeUso", "valor", mCasoDeUso );     

      //1° Creo un recordset para la salida (si hay)
      RecordSet rsSalida = new RecordSet();

      //2° Le añado las columnas
      rsSalida.addColumn(new String("oid"));
      rsSalida.addColumn(new String("marca"));
      rsSalida.addColumn(new String("entrada"));
      rsSalida.addColumn(new String("salida"));
      
      traza (" dtoDatos" + dtoDatos);
      traza (" dtoDatos.getMarcaSituacionSalida" + dtoDatos.getMarcaSituacionSalida());
      traza (" dtoDatos.getMarcasSituacionEntrada()"+  dtoDatos.getMarcasSituacionEntrada());
      

      //3° Le añado la fila de marca situacion salida (si es que tiene)
      if(dtoDatos.getMarcaSituacionSalida()!=null) {
        rsSalida.addRow(new Object[] {dtoDatos.getMarcaSituacionSalida(), new String(dtoDatos.getMarcaSituacionSalidaDesc()) , new String("N"), new String("S")});             
      }

      traza("************** El RecordSet de Salida ***************");
      traza("************** rsSalida " + rsSalida);

      //4° Creo un recordset para las entradas
      RecordSet rsEntradas = new RecordSet();

      //5° Le añado las columnas
      rsEntradas.addColumn(new String("oid"));
      rsEntradas.addColumn(new String("marca"));
      rsEntradas.addColumn(new String("entrada"));
      rsEntradas.addColumn(new String("salida"));

      //6° Le añado las filas de marca situacion entrada (si es que tiene)     
      if(dtoDatos.getMarcasSituacionEntrada()!=null) {
        Long[] arrayOids = dtoDatos.getMarcasSituacionEntrada();
        int cant = arrayOids.length;
        traza ("cantidad" + cant);

        String[] arrayDesc = dtoDatos.getMarcasSituacionEntradaDesc();

        for(int i=0; i < cant ;i++) {
          rsEntradas.addRow(new Object[] {arrayOids[i], arrayDesc[i] , new String("S"), new String("N")});
        } 
      }
      
      traza("************** El RecordSet de Entrada ***************");
      traza("************** rsEntradas " + rsEntradas);

      //7° Al recordset de entrada le añado las filas de marca situacion salida
      traza ("1");
      int cantS = rsSalida.getRowCount();
      traza ("2");
      int cantE = rsEntradas.getRowCount();
      traza ("3");
      boolean agrego = false;

      if(cantS > 0) {
        for(int i=0; i < cantS; i++) {
          agrego = true;
          traza ("4");
          Long oidSalida = (Long)rsSalida.getValueAt(i,0);
          traza ("5");
          long lSal = oidSalida.longValue();
          int indice = 0;

          for(int j=0; j < cantE; j++) {
            traza ("6");
            Long oidEntrada = (Long)rsEntradas.getValueAt(j,0);
            traza (oidEntrada);
            traza ("7");
            long lEnt = oidEntrada.longValue();
            traza ("8");
            if(lSal==lEnt){
              agrego = false;      
              indice = j;
            }        
          }

          if(agrego) {
            traza ("9");
            rsEntradas.addRow(new Object[] {dtoDatos.getMarcaSituacionSalida(), dtoDatos.getMarcaSituacionSalidaDesc() , new String("N"), new String("S")});
          }
          else {
            traza ("10");
            rsEntradas.setValueAt(new String("S"),indice,3); 
          }          
        }       
      }

      traza("************** El RecordSet de Entrada MAS LOS DE SALIDA ***************");
      traza("************** rsEntradas " + rsEntradas);

      traza("************** El RecordSet completo con todas las marcas ***************");
      traza("************** rsCompleto " + rsCompleto);     

      //8° Armar el Recordset final con todas las marcas de la base de datos, 
      // con las marcas chequeadas segun corresponda

      int cantEntradas = rsEntradas.getRowCount();
      int cantCompleto = rsCompleto.getRowCount();

      traza("************** Antes de entrar al primer for ***************");
      for(int i=0; i<cantCompleto; i++) {
        BigDecimal oidCom = (BigDecimal)rsCompleto.getValueAt(i,0);
        long lcom = oidCom.longValue();

        traza("************** Antes de entrar al segundo for ***************");
        for(int j=0; j<cantEntradas; j++) {
          Long oidEnt = (Long)rsEntradas.getValueAt(j,0);
          long lent = oidEnt.longValue();

          traza("************** Antes de entrar al if ***************");
          traza("************** lcom " + lcom);
          traza("************** lent " + lent);
          
          if(lcom == lent) {
            traza("************* Entre al if porque coinciden los oids");
            //Obtengo el String de entrada
            String strEnt = (String)rsEntradas.getValueAt(j,2);
            traza("************* strEnt " + strEnt);

            //Obtengo el String de salida
            String strSal = (String)rsEntradas.getValueAt(j,3);
            traza("************* strSal " + strSal);

            //Seteo el valor para entrada          
            rsCompleto.setValueAt(strEnt,i,2);

            //Seteo el valor para salida          
            rsCompleto.setValueAt(strSal,i,3);           
          }       
        }       
      }

      traza("************** El RecordSet DEFINITIVO ***************");
      traza("************** rsCompleto " + rsCompleto);      

      //9° Le añado el RecordSet a la lista
      rsEntradas.sortByColumn(1,true);
      DruidaConector con = UtilidadesBelcorp.generarConector("dtoSalida.marcasSituacion_ROWSET",rsEntradas,rsEntradas.getColumnIdentifiers());      
      asignar("LISTADOA", "listado1",con, "dtoSalida.marcasSituacion_ROWSET");
      asignarAtributo("AREATEXTO", "areaObservaciones", "readonly", "S");
   }

    private void cargaModificar (Long oid) throws Exception {
    
      oidSubproceso = conectorParametro("oidSubproceso");
      oidTipoAbono = conectorParametro("oidTipoAbono");
      oidProceso = conectorParametro("oidProceso");
      
      oid = new Long(conectorParametro("oid"));
      
    
      traza("************** Entre a cargaModificar (Long oid) ***************");
  	  traza("************** oid: " + oid);      
      traza("************** oidSubproceso: " + oidSubproceso);      
      traza("************** oidTipoAbono: " + oidTipoAbono);
      traza("************** oidProceso: " + oidProceso);

      traza("************** Primero llamo a cargaInicialConsultarModificar ***************");
      RecordSet rsCompleto = cargaInicialConsultarModificar();
      traza("************** Sigamos... ***************");      
      traza("************** Sigamos22222222222... ***************");      
      
      MareBusinessID id = new MareBusinessID("CCCConsultarMarcasPorTipoAbono");
      traza("************** 1 ***************");      
      DTOMarcasPorTipoAbono dto = new DTOMarcasPorTipoAbono();
      dto.setProceso(new Long(oidProceso));
      traza("************** 2 ***************");      
      dto.setSubproceso(new Long(oidSubproceso));
      traza("************** 3 ***************");      
      dto.setTipoAbono(new Long(oidTipoAbono));
      traza("************** 4 ***************");      
      dto.setOidIdioma(oIdioma);
      traza("************** 5 ***************");      
      dto.setOidPais(oIdPais); 
      traza("************** 6 ***************");      

       Vector paramEntrada = new Vector();

       paramEntrada.add(dto);
       paramEntrada.add(id);
       
       traza (paramEntrada);

     
       //DTOOID dto = new DTOOID();
       //dto.setOid(oid);
       //dto.setOidPais(new Long(mPais));
       //dto.setOidIdioma(new Long(mIdioma));

      traza("************** Antes de conectar ConectorObjeto");
      DruidaConector conectorObjeto = conectar("ConectorObjeto", paramEntrada);
      traza("************** Despues de conectar ConectorObjeto");
      
      DTOConsultarMarcasTipoAbono dtoDatos = (DTOConsultarMarcasTipoAbono) conectorObjeto.objeto("DTOSalida");
      
      String procesoDesc = dtoDatos.getProcesoDesc();
      traza("************** procesoDesc: " + procesoDesc);
      String subprocesoDesc = dtoDatos.getSubprocesoDesc();
      traza("************** subprocesoDesc: " + subprocesoDesc);
      String tipoAbonoDesc = dtoDatos.getTipoAbonoDesc();
      traza("************** tipoAbonoDesc: " + tipoAbonoDesc);
      String observaciones = dtoDatos.getObservaciones();

	    if(observaciones == null){
        observaciones = "";
      }
      traza("************** observaciones: " + observaciones);
      
      
      traza("************** aaaaaaaaaaaa: " + mDescPais);
      traza("************** bbbbbbbbbbbbb: " + procesoDesc);
      traza("************** cccccccccccc: " + subprocesoDesc);
      traza("************** ddddddddddd: " + tipoAbonoDesc);
      traza("************** eeeeeeeeeeeeeee: " + oid.toString());
      

      asignarAtributo("LABELC", "lblvalorPais", "valor", mDescPais);
      
      asignarAtributo("VAR", "hProcesos", "valor", procesoDesc);
      
      asignarAtributo("VAR", "hSubProcesos", "valor", subprocesoDesc);
      
      asignarAtributo("VAR", "hTipoCargo", "valor", tipoAbonoDesc);
      
      asignarAtributo("VAR", "hObservaciones", "valor", observaciones);
      
      asignarAtributo("VAR", "oid", "valor", oid.toString());
      
      asignarAtributo("VAR", "casoDeUso", "valor", mCasoDeUso );     

      //1° Creo un recordset para la salida (si hay)
      RecordSet rsSalida = new RecordSet();

      //2° Le añado las columnas
      rsSalida.addColumn(new String("oid"));
      rsSalida.addColumn(new String("marca"));
      rsSalida.addColumn(new String("entrada"));
      rsSalida.addColumn(new String("salida"));

      //3° Le añado la fila de marca situacion salida (si es que tiene)
      if(dtoDatos.getMarcaSituacionSalida()!=null) {
        rsSalida.addRow(new Object[] {dtoDatos.getMarcaSituacionSalida(), new String(dtoDatos.getMarcaSituacionSalidaDesc()) , new String("N"), new String("S")});             
      }

      traza("************** El RecordSet de Salida ***************");
      traza("************** rsSalida " + rsSalida);

      //4° Creo un recordset para las entradas
      RecordSet rsEntradas = new RecordSet();

      //5° Le añado las columnas
      rsEntradas.addColumn(new String("oid"));
      rsEntradas.addColumn(new String("marca"));
      rsEntradas.addColumn(new String("entrada"));
      rsEntradas.addColumn(new String("salida"));

      //6° Le añado las filas de marca situacion entrada (si es que tiene)
      if(dtoDatos.getMarcasSituacionEntrada()!=null) {
        Long[] arrayOids = dtoDatos.getMarcasSituacionEntrada();
        int cant = arrayOids.length;

        String[] arrayDesc = dtoDatos.getMarcasSituacionEntradaDesc();

        for(int i=0; i < cant ;i++) {
          rsEntradas.addRow(new Object[] {arrayOids[i], arrayDesc[i] , new String("S"), new String("N")});
        } 
      }

      traza("************** El RecordSet de Entrada ***************");
      traza("************** rsEntradas " + rsEntradas);

      //7° Al recordset de entrada le añado las filas de marca situacion salida

      int cantS = rsSalida.getRowCount();
      int cantE = rsEntradas.getRowCount();
      boolean agrego = false;

      if(cantS > 0) {
        for(int i=0; i < cantS; i++) {
          agrego = true;
          Long oidSalida = (Long)rsSalida.getValueAt(i,0);
          long lSal = oidSalida.longValue();
          int indice = 0;

          for(int j=0; j < cantE; j++) {
            Long oidEntrada = (Long)rsEntradas.getValueAt(j,0);       
            long lEnt = oidEntrada.longValue();
            
            if(lSal==lEnt){
              agrego = false;      
              indice = j;
            }        
          }

          if(agrego) {
            rsEntradas.addRow(new Object[] {dtoDatos.getMarcaSituacionSalida(), dtoDatos.getMarcaSituacionSalidaDesc() , new String("N"), new String("S")});
          }
          else {
            rsEntradas.setValueAt(new String("S"),indice,3); 
          }          
        }       
      }

      traza("************** El RecordSet de Entrada MAS LOS DE SALIDA ***************");
      traza("************** rsEntradas " + rsEntradas);

      traza("************** El RecordSet completo con todas las marcas ***************");
      traza("************** rsCompleto " + rsCompleto);     

      //8° Armar el Recordset final con todas las marcas de la base de datos, 
      // con las marcas chequeadas segun corresponda

      int cantEntradas = rsEntradas.getRowCount();
      int cantCompleto = rsCompleto.getRowCount();

      traza("************** Antes de entrar al primer for ***************");
      for(int i=0; i<cantCompleto; i++) {
        BigDecimal oidCom = (BigDecimal)rsCompleto.getValueAt(i,0);
        long lcom = oidCom.longValue();

        traza("************** Antes de entrar al segundo for ***************");
        for(int j=0; j<cantEntradas; j++) {
          Long oidEnt = (Long)rsEntradas.getValueAt(j,0);
          long lent = oidEnt.longValue();

          traza("************** Antes de entrar al if ***************");
          traza("************** lcom " + lcom);
          traza("************** lent " + lent);
          
          if(lcom == lent) {
            traza("************* Entre al if porque coinciden los oids");
            //Obtengo el String de entrada
            String strEnt = (String)rsEntradas.getValueAt(j,2);
            traza("************* strEnt " + strEnt);

            //Obtengo el String de salida
            String strSal = (String)rsEntradas.getValueAt(j,3);
            traza("************* strSal " + strSal);

            //Seteo el valor para entrada          
            rsCompleto.setValueAt(strEnt,i,2);

            //Seteo el valor para salida          
            rsCompleto.setValueAt(strSal,i,3);           
          }       
        }       
      }

      traza("************** El RecordSet DEFINITIVO ***************");
      traza("************** rsCompleto " + rsCompleto);      

      //9° Le añado el RecordSet a la lista
      DruidaConector con = UtilidadesBelcorp.generarConector("dtoSalida.marcasSituacion_ROWSET",rsCompleto,rsCompleto.getColumnIdentifiers());      
      asignar("LISTADOA", "listado1",con, "dtoSalida.marcasSituacion_ROWSET");
      asignarAtributo("VAR", "oiSubproceso", "valor", dtoDatos.getSubproceso().toString());
      asignarAtributo("VAR", "oiTipoAbono", "valor", dtoDatos.getTipoAbono().toString());
   }    

   private void cargarMenuSecundario() throws Exception {      
      if (mCasoDeUso.equals("insertar")) {
        getConfiguracionMenu("LPMarcasTipo","insertar");
        asignarAtributoPagina("cod","0404");
      }

      if (mCasoDeUso.equals("consultar")) {
        if(mAccion.equals("detalle")){		
        getConfiguracionMenu("LPMarcasTipo","consultarDetalle");
        asignarAtributoPagina("cod","0406");
      }
      else {
        getConfiguracionMenu("LPMarcasTipo","consultar");
        asignarAtributoPagina("cod","0406");
      }	   
	  }

	  if (mCasoDeUso.equals("modificar")) {	
      if(mAccion.equals("modificar")){          
        getConfiguracionMenu("LPMarcasTipo","guardar");
        asignarAtributoPagina("cod","0405");  
      }
      else {
        getConfiguracionMenu("LPMarcasTipo","modificar");
        asignarAtributoPagina("cod","0405");         
		  }        
	  }

	   if (mCasoDeUso.equals("eliminar")){
        if(mAccion.equals("detalle")) {
          getConfiguracionMenu("LPMarcasTipo","consultarDetalle");
          asignarAtributoPagina("cod","0407");
          
        }
        else {
          getConfiguracionMenu("LPMarcasTipo","eliminar");
          asignarAtributoPagina("cod","0407");
        }
    }    
   }

	 protected void traza(Object p0) throws Exception {
		 System.out.println(p0.toString());
		 super.traza(p0);
	 }
}
