/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 /*
    INDRA/CAR/PROY
    $Id: LPBusquedaConfiguracionCampos.java,v 1.1 2009/12/03 18:32:59 pecbazalar Exp $
    DESC
 */
import LPSICCBase;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.mae.DTOBusquedaConfiguracionCampo;
import es.indra.sicc.dtos.mae.DTOCombosConfiguracionCampos;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Vector;


public class LPBusquedaConfiguracionCampos extends LPSICCBase  {
	
  String casoDeUso;
	String accion;

	String tipoCampo;
	String nombreCampo;
	String obligatorio;
	String modificable;
	String valorxdefecto;
	String tipoCliente;
	String subtipoCliente;
  String oIDsEliminar;
  String oIDConsultar;
  String oIDModificar;
  boolean resultado;

	public LPBusquedaConfiguracionCampos()  {
		super();
	}

	// Definicion del metodo abstracto inicio
	public void inicio() throws Exception  {
		// Defino el nombre de la vista
		pagina("contenido_campos_parametrizables_modificar");
	}

	// Definicion del metodo abstracto ejecucion
  public void ejecucion() throws Exception  {

    try {
      Vector paramEntrada;
      setTrazaFichero();
      traza(" ");
      traza("********************************************************");
      traza("********************* ejecucion() LPBusqueda **********************");
      traza("********************************************************");

      casoDeUso = conectorParametroLimpia("hCasoDeUso","",true);
      traza("casoDeUso : " + casoDeUso);
      accion = conectorParametroLimpia("accion","",true);
      traza("accion : " + accion);
      tipoCampo = conectorParametroLimpia("cbTipoCampo","",true);
      nombreCampo = conectorParametroLimpia("cbNombreCampo","",true);
      obligatorio = conectorParametroLimpia("IngresoObligatorio","",true);
      modificable = conectorParametroLimpia("ModificableporUsuario","",true);
      valorxdefecto = conectorParametroLimpia("txtValorPorDefecto","",true);
      tipoCliente = conectorParametroLimpia("cbTipoCliente","",true);
      subtipoCliente = conectorParametroLimpia("cbSubTipoCliente","",true);
      oIDsEliminar = conectorParametroLimpia("hOID","",true);
      oIDConsultar = conectorParametroLimpia("hOID","",true);
      oIDModificar = conectorParametroLimpia("hOID","",true);

      traza("tipoCampo : " + tipoCampo);
      traza("nombreCampo : "    + nombreCampo);
      traza("obligatorio : "    + obligatorio);
      traza("modificable : "    + modificable);
      traza("valorxdefecto : "  + valorxdefecto);
      traza("tipoCliente : "    + tipoCliente);
      traza("subtipoCliente : " + subtipoCliente);
      traza("oIDsEliminar : "   + oIDsEliminar);
      traza("oIDConsultar : "   + oIDConsultar);
      traza("oIDModificar : "   + oIDModificar);

  //accion == " " ---------------------------------------------------------------------------
      if (accion.equals("")) {
        traza("accion 1: "   + accion);
        cargarDatosFiltro();
        traza("accion 2: "   + accion);        
        asignarAtributo("VAR","hCasoDeUso", "valor", casoDeUso);
        traza("accion 3: "   + accion);        
        UtilidadesSession sesion = new UtilidadesSession();
        asignarAtributo("VAR","hOidIdioma", "valor",String.valueOf(sesion.getIdioma(this)) );
        asignarAtributo("VAR", "hOidOPais", "valor", String.valueOf(sesion.getPais(this)));
      }

  //accion == "Eliminar" -------------------------------------------------------------------
      if (accion.equals("Eliminar"))  {
        traza(" ");
        traza(accion);
        paramEntrada = new Vector();
        //-idBusiness = "MAEEliminarConfiguracionCampos" 
        //-Se crea un DTOOIDs con los oid de los campos ocultos de las filas seleccionadas por el cliente.
        DTOOIDs dtoDel = new DTOOIDs();
        UtilidadesSession sesion = new UtilidadesSession();
        dtoDel.setOidIdioma( sesion.getIdioma(this) );
        dtoDel.setOidPais( sesion.getPais(this) );
        dtoDel.setOids( parsearString(oIDsEliminar) ); //
          traza("dtoDel : " + dtoDel);
        //-Se llama al ConectorEliminarConfiguracionCampos
        paramEntrada.add( dtoDel );
        paramEntrada.add( new MareBusinessID("MAEEliminarConfiguracionCampos") );
          traza("pramEntrada : " + paramEntrada);
          traza(" conectando con ConectorEliminarConfiguracionCampos... ");
        DruidaConector con = conectar("ConectorEliminarConfiguracionCampos",paramEntrada);
          traza(" conexión establecida ");
        asignarAtributo("VAR","exito", "valor", "si");
        cargarDatosFiltro();
        enviarVarsOcultas();
        resultado = realizarBusqueda();
      }
    } catch (Exception e) {
      e.printStackTrace();
      logStackTrace(e);
        traza("e.printStackTrace()" + e.toString() );
      lanzarPaginaError(e);
    }

    if ( casoDeUso.equals("Modificar") )  {
      getConfiguracionMenu("LPBusquedaConfiguracionCamposM","");
      asignarAtributoPagina("cod","0369");
    } else if ( casoDeUso.equals("Eliminar") )  {
      getConfiguracionMenu("LPBusquedaConfiguracionCamposE","");
      asignarAtributoPagina("cod","0370");
    } else if ( casoDeUso.equals("Consultar") )  {
      getConfiguracionMenu("LPBusquedaConfiguracionCamposC","");
      asignarAtributoPagina("cod","0371");
    }
	} //ejecucion()

  private void cargarDatosFiltro()  throws Exception  {
    Vector paramEntrada = new Vector();
    DTOBelcorp dtoIn = new DTOBelcorp();
    UtilidadesSession sesion = new UtilidadesSession();
    dtoIn.setOidIdioma( sesion.getIdioma(this) );
    dtoIn.setOidPais( sesion.getPais(this) );
    paramEntrada.add( dtoIn );
    paramEntrada.add( new MareBusinessID("MAECombosConfiguracionCampos") );
    DruidaConector con = conectar("ConectorRellenarCombosConfiguracionCampos",paramEntrada);
    DTOCombosConfiguracionCampos dtoOut = (DTOCombosConfiguracionCampos) con.objeto("DTOSalida");

    RecordSet rsNombreCampo = dtoOut.getCampos();
      traza("dtoOut.getCampos()" + dtoOut.getCampos());
    Vector columnas = rsNombreCampo.getColumnIdentifiers();
    DruidaConector dcNC = UtilidadesBelcorp.generarConector( "dtoSalida.resultado_ROWSET", rsNombreCampo, columnas );
    asignar( "LISTA", "listaOcultaNC", dcNC);

    RecordSet rsTipoCliente = dtoOut.getTipoCliente();
    columnas = rsTipoCliente.getColumnIdentifiers();
    DruidaConector dcTC = UtilidadesBelcorp.generarConector( "dtoSalida.resultado_ROWSET", rsTipoCliente, columnas );
    asignar( "COMBO", "cbTipoCliente", dcTC);

    RecordSet rsSubtipoCliente = dtoOut.getSubtipoCliente();
    columnas = rsSubtipoCliente.getColumnIdentifiers();
    DruidaConector dcSTC = UtilidadesBelcorp.generarConector( "dtoSalida.resultado_ROWSET", rsSubtipoCliente,  columnas);
    asignar( "LISTA", "listaOcultaSTC", dcSTC);
  }

  //parseo del String cuyos tokens son |
  public Long[] parsearString( String aParsear ) throws Exception  {
    StringTokenizer stk = new StringTokenizer(aParsear,"|");
    Long[] claves = new Long[stk.countTokens()];
    int i = 0;
    while ( stk.hasMoreTokens() ) {
      claves[i] = Long.valueOf( stk.nextToken() );
      i++;
    }
    return claves;
  }

  public void enviarVarsOcultas() throws Exception  {
    asignarAtributo("VAR","hCasoDeUso", "valor", casoDeUso);
    asignarAtributo("VAR","accion", "valor", accion);
    asignarAtributo("VAR","hTipoCampo", "valor", tipoCampo);
    asignarAtributo("VAR","hTipoCliente", "valor", tipoCliente);
    asignarAtributo("VAR","hSubtipoCliente", "valor", subtipoCliente);
    asignarAtributo("VAR","hNombreCampo", "valor", nombreCampo);
    asignarAtributo("VAR","hObligatorio", "valor", obligatorio);
    asignarAtributo("VAR","hModificable", "valor", modificable);
    asignarAtributo("CTEXTO","txtValorPorDefecto","valor", valorxdefecto);
  }

  public boolean realizarBusqueda() throws Exception  {
    Vector paramEntrada = new Vector();
    //-Se crea un DTOBusquedaConfiguracionCampo (hereda del paginable) y se rellena con los campos correspondientes de la
    //pantalla. Si un campo no tiene valor se pone un null en el DTO.
    DTOBusquedaConfiguracionCampo dtoIn = new DTOBusquedaConfiguracionCampo();
    UtilidadesSession sesion = new UtilidadesSession();
    dtoIn.setOidPais( sesion.getPais(this) );
      traza("pais "+ dtoIn.getOidPais());

    if ( tipoCampo == null || tipoCampo.equals("") ) 
      dtoIn.setIndClienteProducto( null );
    else if ( tipoCampo.equals("0") ) 
      dtoIn.setIndClienteProducto(Boolean.TRUE);
    else 
      dtoIn.setIndClienteProducto(Boolean.FALSE);

    if ( tipoCliente == null || tipoCliente.equals("") ) 
      dtoIn.setTipoCliente(null);
    else 
      dtoIn.setTipoCliente( Long.valueOf(tipoCliente) );

		if ( subtipoCliente == null || subtipoCliente.equals("") ) 
      dtoIn.setSubtipoCliente(null);
		else 
      dtoIn.setSubtipoCliente( Long.valueOf(subtipoCliente) );

		if ( nombreCampo == null || nombreCampo.equals("") ) 
      dtoIn.setCampo(null);
		else 
      dtoIn.setCampo( Long.valueOf(nombreCampo) );

		if ( obligatorio == null || obligatorio.equals("") ) 
      dtoIn.setObligatorio( null );
		else if ( obligatorio.equals("S") ) 
      dtoIn.setObligatorio( Boolean.TRUE);
    else 
      dtoIn.setObligatorio( Boolean.FALSE);

		if ( modificable == null || modificable.equals("") ) 
      dtoIn.setModificable( null );
		else if ( modificable.equals("S") ) 
      dtoIn.setModificable( Boolean.TRUE);
		else 
      dtoIn.setModificable( Boolean.FALSE);

		if ( valorxdefecto == null || valorxdefecto.equals("") ) 
      dtoIn.setValorDefecto( null );
		else 
      dtoIn.setValorDefecto( valorxdefecto );

    paramEntrada.add( dtoIn );
    //-idBusiness="MAEBuscarConfiguracionCampos"
    paramEntrada.add( new MareBusinessID("MAEBuscarConfiguracionCampos") );
    //-Se llama ConectorBuscarConfiguracionCampos
    
    traza(" conectando con ConectorBuscarConfiguracionCampos... ");
    DruidaConector con = conectar("ConectorBuscarConfiguracionCampos",paramEntrada);
    traza(" conexión establecida ");

    //-Con el DTOSalida de resultados rellenamos la lista resultados con las siguientes consideraciones: 
    //La primera columna de cada fila es un oid que no se muestra sino que se guarda en un campo oculto para cada fila. 
    DTOSalida dtoOutFind = (DTOSalida) con.objeto("DTOSalida");
    RecordSet rsResultadoBuscar = dtoOutFind.getResultado();
    //[OID_CONF_CAMP, DES_ATRI, IND_OBLI, IND_MODI, VAL_DEFE, OID_SUBT_CLIE, TICL_OID_TIPO_CLIE, DES_MAE_SUBTI_CLIEN, DES_MAE_TIPO_CLIEN]
    traza("rsResultadoBuscar  : " + rsResultadoBuscar );
      
    //Si en la consulta el campo indClienteProducto es false en la tabla de resultados no aparecen las columnas "Tipo Cliente" y "Subtipo Cliente" 
    if ( tipoCampo.equals("0") ) {
      rsResultadoBuscar.sortByColumn(1,true);        
      Vector columnasProd = new Vector();
      
      for (int i=0; i<5; i++) 
        columnasProd.addElement( rsResultadoBuscar.getColumnName(i) );
        
      DruidaConector dcResultadoBuscar = UtilidadesBelcorp.generarConector( "dtoSalida.resultado_ROWSET", rsResultadoBuscar, columnasProd );
      asignar( "LISTA", "listado1", dcResultadoBuscar);
    } else {
      rsResultadoBuscar.removeColumn(5);
      rsResultadoBuscar.removeColumn(5);
      rsResultadoBuscar.interchangeColumns(1,6);
      rsResultadoBuscar.interchangeColumns(2,5);
      rsResultadoBuscar.interchangeColumns(3,6);
      rsResultadoBuscar.interchangeColumns(4,5);
      rsResultadoBuscar.interchangeColumns(5,6);
      rsResultadoBuscar.sortByColumn(1,true);
      Vector columnasCli = rsResultadoBuscar.getColumnIdentifiers();
      DruidaConector dcResultadoBuscar = UtilidadesBelcorp.generarConector( "dtoSalida.resultado_ROWSET", rsResultadoBuscar, columnasCli );
      traza(dcResultadoBuscar.getXML());
      asignar( "LISTA", "listado1", dcResultadoBuscar);
    }
    
    //Las columnas obligatorio y modificable contendran "SI" cuando tengamos un 1 en el recordset
    //y "NO" cuando tengamos un 0 (en el idioma del usuario).
    //NOTA: Implementado en JavaScript.
    if ( rsResultadoBuscar.getRowCount() != 0 ) 
      return true; 
    else 
      return false;
  }

  private void logStackTrace(Throwable e) throws Exception {
    traza("Se produjo la excepcion: " + e.getMessage());
 
    ByteArrayOutputStream pila = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(pila);
    if (e instanceof MareException) {
      MareException e2=(MareException)e;
      traza("Es una mare Exception con codigo de error: "+e2.getCode());
    }
    e.printStackTrace(out);
    traza("stack Trace : " +  pila.toString());
  }
}
