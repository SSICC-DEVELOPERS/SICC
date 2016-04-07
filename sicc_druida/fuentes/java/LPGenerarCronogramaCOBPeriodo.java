
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.cob.DTOCronogramaCobranza;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
//import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.cob.DTOCronogramaGenerado;
import es.indra.sicc.dtos.cob.DTOGenerarCronogramaCOBPeriodo;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.druida.DruidaConector;


import java.util.ArrayList;
import java.util.Vector;
import java.util.StringTokenizer;
import java.text.SimpleDateFormat;
import es.indra.sicc.util.DTOColeccion;

public class LPGenerarCronogramaCOBPeriodo extends LPSICCBase
{
     public LPGenerarCronogramaCOBPeriodo() {
        super();
     }	
     
     public void inicio() throws Exception {}

// ----------------------------------------------------------------------------------------------
     public void ejecucion() throws Exception 
     {  

        String sAccion = null;
        setTrazaFichero();
        traza("----------------- Entrando a LPGenerarCronogramaCOBPeriodo --------");             
        try 
        {

           sAccion = this.conectorParametroLimpia("accion", "", true);
           traza("Accion: " + sAccion);
          
           if (sAccion.equals("")) {
             this.pagina("contenido_cronograma_cobranza_periodo_generar");
             this.asignarAtributoPagina("cod", "0264");
             this.getConfiguracionMenu("LPGenerarCronogramaCOBPeriodo", "");
             this.cargarPagina();
           }
          
           if (sAccion.equals("generarCronograma") ) {
            this.generarCronograma();
           }
          
           if (sAccion.equals("guardarCronograma") ) {
            this.guardarCronograma();
           }
          
        } catch (Exception ex)
        {
          ex.printStackTrace();
          this.lanzarPaginaError(ex);
        }
         
        
    
     }
     
// ---------------------------------------------------------------------------------------------     
     private void cargarPagina() throws MareException, Exception 
     {
        traza(" ---------- cargarPagina");
        DTOBelcorp dtoBelcorp = null;
        DTOSalida dtoSalida = null;
        Long oidPais = null;
        Long oidIdioma = null;
        ComposerViewElementList compViewList = null;
        ConectorComposerView conectorCompView = null;
        DruidaConector conMarcaCanal = null;
        DruidaConector conLista = null;
        RecordSet rLista = null;
        MareBusinessID bussId = null;
        Vector vParams = null;
        
        // ------ Construimos DTOBelcorp con Pais e Idioma de Sesion -------------------
        traza("---- Construimos DTOBelcorp con Pais e Idioma de Sesion");
        oidPais = UtilidadesSession.getPais(this);
        oidIdioma = UtilidadesSession.getIdioma(this);
        dtoBelcorp = new DTOBelcorp();
        dtoBelcorp.setOidIdioma(oidIdioma);
        dtoBelcorp.setOidPais(oidPais);       

        // --------- Rellenamos los campos "Canal" y "Marca", y "VAR Pais" --------------------------        
        traza("---- Rellenamos los campos 'Canal' y 'Marca'");
        compViewList = this.preparaCargaInicial(dtoBelcorp);
        conectorCompView = new ConectorComposerView(compViewList, this.getRequest());
        traza("- Ejecutamos ");
        conectorCompView.ejecucion();
        traza("- Obtenemos Conector");
        conMarcaCanal = conectorCompView.getConector();
        traza("Conector: " + conMarcaCanal.getXML().toString());
        
        this.asignar("COMBO", "cbMarca", conMarcaCanal, "SEGConsultaMarcas" );
        this.asignar("COMBO", "cbCanal", conMarcaCanal, "SEGConsultaCanales" );
        this.asignarAtributo("VAR", "hPais", "valor", UtilidadesSession.getPais(this).toString());
        
        // ------- Completamos listaEditable ------------------------------------------
        traza("---- Completamos listaEditable ");
        
        bussId = new MareBusinessID("COBConsultarEtapasCobranza");
        vParams = new Vector();
        vParams.add(dtoBelcorp);        
        vParams.add(bussId);
        traza("- Nos conectamos");
        conLista = this.conectar("ConectorConsultarEtapasCobranza", vParams);
        traza("- Recuperamos DTOSalida");
        
        dtoSalida = (DTOSalida) conLista.objeto("dtoSalida");
        traza("dtoSalida obtenido: " + dtoSalida);
        
        rLista = dtoSalida.getResultado();
        
        if ( rLista.esVacio() )
        {
          traza("Recorset es vacio - Genera Excepcion UICOB0002");
          this.asignarAtributo("VAR", "deshabilitaBoton", "valor", "S");
          throw new MareException("Recorset es vacio - Genera Excepcion UICOB0002", 17010006);
          
        } else
        {
          traza("Recordset no es vacio... asignando a ListaEditable");
          DruidaConector conListaTemp = UtilidadesBelcorp.generarConector("listaTemp", rLista, rLista.getColumnIdentifiers());
          this.asignar("LISTADOA", "listado1", conListaTemp, "listaTemp");
        }
       
     }
     
// ---------------------------------------------------------------------------------------------
     private void generarCronograma() throws Exception 
     {
        // ************************************************
        // Basado en correcciones de Inc. 13098 (22/2/2005)
        // ************************************************
        
        traza(" ---------- cargarPagina"); 
        DTOGenerarCronogramaCOBPeriodo datosEntrada = null;
        DTOCronogramaGenerado dtoCronoGenerado= null;
        String sOidPeriodo = null;
        String sOidEtapas = null;
        String sMensaje = null;
        ArrayList arrayOidEtapas = null;
        MareBusinessID bussId = null;
        Vector vParams = null;
        DruidaConector con = null;
        ArrayList arrayCronogramas = null;
        RecordSet rLista = null;
        DruidaConector conLista = null;
        
        
        // ------------------ Obtiene oids de Etapas de Periodo --------------------------------
        sOidEtapas = (String) this.conectorParametroLimpia("oidSeleccionados", "", true);
        traza("sOidEtapas: " + sOidEtapas);
        arrayOidEtapas = this.parseaOidsEtapas(sOidEtapas);
        
        // ------------------------------ Obtenemos Oid de Periodo de pantalla ----------------
        traza(" ---- Obtenemos oid de Periodo de Pantalla");
        datosEntrada = new DTOGenerarCronogramaCOBPeriodo();
        sOidPeriodo = (String) this.conectorParametro("hOidPeriodo");
        
        
        // ------------------------- Llamamos a COBGenerarCronogramaCobranzas -----------------
        this.pagina("contenido_cronograma_cobranza_periodo_generar_3");
        this.asignarAtributoPagina("cod", "0264");        
        this.getConfiguracionMenu("LPGenerarCronogramaCOBPeriodo", "generarCronograma");        
        this.getFormatosValidaciones();
        
        traza("---- Llamamos a COBGenerarCronogramaCobranzas");
        bussId = new MareBusinessID("COBGenerarCronogramaCobranzas");
      
        datosEntrada.setPeriodo( new Long(sOidPeriodo) );
        datosEntrada.setEtapas(arrayOidEtapas);
        datosEntrada.setOidIdioma(UtilidadesSession.getIdioma(this));
        datosEntrada.setOidPais(UtilidadesSession.getPais(this));
        
        vParams = new Vector();
        vParams.add(datosEntrada);
        vParams.add(bussId);
        
        traza("- Conectar");        
        con = this.conectar("ConectorGenerarCronogramaCobranzas", vParams);
        traza("- Obtenemos DTOCronogramaGenerado()");
        dtoCronoGenerado = (DTOCronogramaGenerado) con.objeto("dtoSalida");
        traza("dtoCronoGenerado: " + dtoCronoGenerado);
        
        sMensaje = dtoCronoGenerado.getMensaje();
        if (sMensaje != null && !sMensaje.equals("") )
          this.asignarAtributo("VAR","hMensaje","valor",sMensaje);
        
        // -------------- Asignamos atributo DTOCronogramaGenerado.cronograma a sesion ---------
        arrayCronogramas = dtoCronoGenerado.getCronograma();
        if (arrayCronogramas != null)  // Solo es un failsafe, no deberia venir NULL nunca aca.
          this.conectorParametroSesion("cronogramaProvisional", arrayCronogramas);
        
        // ------ Armo RecordSet a partir de Array de DTOCronogramaGenerado.cronograma ---------
        rLista = this.armaRecordSetCronogramas(arrayCronogramas);
        conLista = UtilidadesBelcorp.generarConector("conLista", rLista, rLista.getColumnIdentifiers());
        System.out.println("Asigna a la lista");
        this.asignar("LISTADOA", "listado1", conLista, "conLista");
        
        
     }
     
// ---------------------------------------------------------------------------------------------
     private void guardarCronograma() throws Exception
     {
       DTOColeccion dtoCol = new DTOColeccion();
       ArrayList aListFechaCierre = null;
       ArrayList aListFechaEvaluacion = null;
       ArrayList aListFechaAuditoria = null;
       MareBusinessID bussID = null;
       Vector vParams = null;
       DruidaConector con = null;
       
       // Toma los valores a guardar de la pantalla (solo los campos modificables de la lista),
       // o sea, tres fechas por fila. 
       String sFechaCierre = (String) this.conectorParametroLimpia("hFechaCierre", "", true);
       String sFechaEvaluacion = (String) this.conectorParametroLimpia("hFechaEvaluacion", "", true);
       String sFechaAuditoria = (String) this.conectorParametroLimpia("hFechaAuditoria", "", true);       
       
       traza("sFechaCierre: " + sFechaCierre);
       traza("sFechaEvaluacion: " + sFechaEvaluacion);
       traza("sFechaAuditoria: " + sFechaAuditoria);
       pagina("salidaGenerica");
       
       if ( !sFechaCierre.equals("") )
         aListFechaCierre = this.armaArrayFechas(sFechaCierre);
          
       if ( !sFechaEvaluacion.equals("") )
         aListFechaEvaluacion = this.armaArrayFechas(sFechaEvaluacion);
          
       if ( !sFechaAuditoria.equals("") )
         aListFechaAuditoria = this.armaArrayFechas(sFechaAuditoria);
          

       ArrayList aListSesion = (ArrayList) this.conectorParametroSesion("cronogramaProvisional");
       DTOColeccion dtoColeccion = new DTOColeccion();
       
       for (int i = 0; i < aListSesion.size(); i++)
       {
          traza("Procesando fila " + i);
          DTOCronogramaCobranza dtoCronogramaCobranza = (DTOCronogramaCobranza) aListSesion.get(i);
          traza("dtoC antes: " + dtoCronogramaCobranza);
          
          // Setea el valor nuevo de Fecha Cierre para la fila i
          traza("1");
          java.sql.Date sqlFechaCierre = (java.sql.Date) aListFechaCierre.get(i);
          traza("2");
          dtoCronogramaCobranza.setFechaCierre(sqlFechaCierre);
          traza("Setea el valor nuevo de Fecha Cierre para la fila " + i);

          // Setea el valor nuevo de Fecha Evaluacion para la fila i
          java.sql.Date sqlFechaEvaluacion = (java.sql.Date) aListFechaEvaluacion.get(i);
          dtoCronogramaCobranza.setFechaEvaluacion(sqlFechaEvaluacion);
          traza("Setea el valor nuevo de Fecha Evaluacion para la fila " + i);          

          // Setea el valor nuevo de Fecha Auditoria para la fila i
          java.sql.Date sqlFechaAuditoria = (java.sql.Date) aListFechaAuditoria.get(i);
          dtoCronogramaCobranza.setFechaAuditoria(sqlFechaAuditoria);
          traza("Setea el valor nuevo de Fecha Auditoria para la fila " + i);
          
          aListSesion.set(i, dtoCronogramaCobranza);
          traza("dtoC despues: " + dtoCronogramaCobranza);
       }
       
       traza("Termino el bucle");
       dtoCol = new DTOColeccion();
       dtoCol.setLista(aListSesion);
       bussID = new MareBusinessID("COBGuardarCronogramaCobranzas");
       vParams = new Vector();
       vParams.add(dtoCol);
       vParams.add(bussID);
       
       traza("Conectando...");
       con = this.conectar("ConectorGuardarCronogramaCobranzas", vParams);
       traza("Conecto!!!!");
       
       this.asignarAtributo("VAR", "ejecutar", "valor", "terminoOK()");
       
     }

// ---------------------------------------------------------------------------------------------     
     private ArrayList armaArrayFechas(String sCadenaFechas) throws Exception 
     {
        traza("--------------- armaArrayFechas() - cadena: " + sCadenaFechas);
        // Recibe una cadena de formato "[Fecha,Fecha,Fecha]" y devuelve un ArrayList
        // con java.sql.Date.
        
        // Primero quito los "[" "]" al principio y final.
        sCadenaFechas = sCadenaFechas.substring(1,sCadenaFechas.length()-1);
        traza("CadenaFechas ahora: " + sCadenaFechas);
/*        sCadenaFechas = sCadenaFechas.substring(sCadenaFechas.length()-2, sCadenaFechas.length()-1);
        traza("CadenaFechas ahora: " + sCadenaFechas);*/
        
        ArrayList aList = new ArrayList();
        String sFormatoSesion = UtilidadesSession.getFormatoFecha(this);
        StringTokenizer sTok = new StringTokenizer(sCadenaFechas, ",");
        sFormatoSesion = sFormatoSesion.replace('m', 'M');        
        
        SimpleDateFormat simpleDate = new SimpleDateFormat(sFormatoSesion);
        
        while ( sTok.hasMoreTokens() )
        {
          String sToken = sTok.nextToken();
          traza("sToken: " + sToken);
          if (sToken.equals(" ") ){
            traza("Anyade NULL");
            aList.add(null);
          } else
          {
            java.util.Date utilDate = simpleDate.parse(sToken);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            traza("Anyade Fecha " + sqlDate.toString());
            aList.add(sqlDate);
          }
        }
        
        return aList;
     }

// ---------------------------------------------------------------------------------------------
     private ComposerViewElementList preparaCargaInicial(DTOBelcorp dtoBelcorp) throws MareException
     {
        ComposerViewElementList compViewList = null;
        ComposerViewElement compElement1 = null;
        ComposerViewElement compElement2 = null;

        // ------ Generamos ComposerViewElementList ------------------------------------
        compViewList = new ComposerViewElementList();
        
        compElement1 = new ComposerViewElement();
        compElement1.setDTOE(dtoBelcorp);
        compElement1.setIDBusiness("SEGConsultaCanales");
        
        compElement2 = new ComposerViewElement();
        compElement2.setDTOE(dtoBelcorp);
        compElement2.setIDBusiness("SEGConsultaMarcas");
        
        compViewList.addViewElement(compElement1);
        compViewList.addViewElement(compElement2);
        
        return compViewList;
       
     }
     
// ---------------------------------------------------------------------------------------------     
     private ArrayList parseaOidsEtapas(String oidEtapas)
     {
        ArrayList aList = new ArrayList();
        if (oidEtapas != null && !oidEtapas.equals("") )
        {

          StringTokenizer sTok = new StringTokenizer(oidEtapas, ",");
      
          while (sTok.hasMoreElements()) {
            aList.add( new Long(sTok.nextToken()) );
          }
          
        }
        
        return aList;
     }
     
 // ---------------------------------------------------------------------------------------------    
     private RecordSet armaRecordSetCronogramas(ArrayList arrayCronogramas) throws Exception
     {
        RecordSet rLista = null;
        Vector vCols = new Vector();
        vCols.add("oid");
        vCols.add("ID Cartera");
        vCols.add("Usuario Cobranza");
        vCols.add("Etapa");
        vCols.add("Tipo Cargo");
        vCols.add("Marca");
        vCols.add("Canal");
        vCols.add("Periodo");
        vCols.add("Subgerencia Ventas");
        vCols.add("Region");
        vCols.add("Zona");
        vCols.add("Seccion");
        vCols.add("Territorio");
        vCols.add("Fecha Cierre");
        vCols.add("Fecha Evaluacion");
        vCols.add("Fecha Auditoria");    

		/* INC BELC300016904 gPineda 02/06/2006 INICIO */
		vCols.add("FechaMin");
		vCols.add("FechaMax");
		/* INC BELC300016904 gPineda 02/06/2006  FIN  */
        rLista = new RecordSet();
        
        rLista.setColumnIdentifiers(vCols);
        
        traza("Procesando filas para completar lista");
        for (int i = 0; i < arrayCronogramas.size(); i++)
        {
           // Genera la fila 
           String sFechaFormateada = "";
           DTOCronogramaCobranza dto = (DTOCronogramaCobranza) arrayCronogramas.get(i);
           Vector vFila = new Vector();
           vFila.add("n" + i);  // Oid indicador de Nuevo (se usara luego en MONCronogramaCobranzas.guardar)
           vFila.add(dto.getIdCartera());
           //vFila.add(dto.getOidUsuarioCobranza());
           vFila.add(dto.getDescripcionUsuarioCobranza());
           vFila.add(dto.getCodigoEtapaDeuda());
           vFila.add(dto.getDescripcionTipoCargo());
           //vFila.add(dto.getOidEtapa());
           //vFila.add(dto.getOidTipoCargo());
           vFila.add(dto.getDescripcionMarca());
           vFila.add(dto.getDescripcionCanal());
           vFila.add(dto.getDescripcionPeriodo());
           vFila.add(dto.getDescripcionSubgerencia());
           vFila.add(dto.getDescripcionRegion());
           vFila.add(dto.getDescripcionZona());
           vFila.add(dto.getDescripcionSeccion());
           vFila.add(dto.getDescripcionTerritorio());
           
           // Formatea las fechas
           if (dto.getFechaCierre()!= null)
              sFechaFormateada = this.formateaFecha(dto.getFechaCierre());
           vFila.add(sFechaFormateada);
           
           sFechaFormateada = "";
           if (dto.getFechaEvaluacion()!= null)
              sFechaFormateada = this.formateaFecha(dto.getFechaEvaluacion());
           vFila.add(sFechaFormateada);

           sFechaFormateada = "";
           if (dto.getFechaAuditoria() != null)
              sFechaFormateada = this.formateaFecha(dto.getFechaAuditoria());
           vFila.add(dto.getFechaAuditoria());
           
			/* INC BELC300016904 gPineda 02/06/2006 INICIO */
			/* Calculo de las fechas min y max para las validaciones */
			sFechaFormateada = "";
			if ( dto.getFechaFacturacion() != null ){
				java.sql.Date fecha = new java.sql.Date(dto.getFechaFacturacion().getTime() + dto.getEdadInicialEtapa().longValue()*86400000);
				sFechaFormateada = this.formateaFecha( fecha );
			}
			vFila.add(sFechaFormateada);

			sFechaFormateada = "";
			if ( dto.getFechaFacturacion() != null ){
				java.sql.Date fecha = new java.sql.Date(dto.getFechaFacturacion().getTime() + dto.getEdadFinalEtapa().longValue()*86400000);
				sFechaFormateada = this.formateaFecha( fecha );
			}
			vFila.add(sFechaFormateada);
			/* INC BELC300016904 gPineda 02/06/2006  FIN  */
 
           // Añade la fila a rLista
           rLista.addRow(vFila);
           traza("dto: " + dto);
        }
        traza("RecordSet a retornar: " + rLista );
        
        return rLista;
     }
     
 // ---------------------------------------------------------------------------------------------    
   private String formateaFecha(java.sql.Date fecha) throws Exception
   {
     traza(" Entra a FormateaFecha");
     String sFechaFormateada = null;
     String sFormatoFecha = null;
     SimpleDateFormat simpleDate = null;
     
     sFormatoFecha = UtilidadesSession.getFormatoFecha(this);
     sFormatoFecha = sFormatoFecha.replace('m', 'M');
     simpleDate = new SimpleDateFormat(sFormatoFecha);
     
     sFechaFormateada = simpleDate.format(fecha);
     
     traza("Fecha Formateada: " + sFechaFormateada);
     return sFechaFormateada;
   }
}