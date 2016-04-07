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
    $Id: LPCrearGrupo.java,v 1.1 2009/12/03 18:32:26 pecbazalar Exp $
    DESC
*/

import com.evermind.server.rmi.OrionRemoteException;

import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.cra.DTOEntradaCalendario;
import es.indra.sicc.dtos.pre.*;
import es.indra.sicc.dtos.pre.DTOEstrategia;
import es.indra.sicc.dtos.pre.DTOOferta;
import es.indra.sicc.dtos.pre.DTOProducto;
import es.indra.sicc.dtos.pre.DTOSCargarCriteriosDefinirOferta;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.UtilidadesBelcorp;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.lang.reflect.InvocationTargetException;

import java.math.BigDecimal;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import es.indra.sicc.util.*;

public class LPCrearGrupo extends LPSICCBase {

  Vector productosGrupo;

  String accion = "";
  DTOOferta dtoOferta;
  Integer grupoActual;

  //almacena los datos seleccionados en la lista editable
  //separados por pipes
  String elementosSeleccionadosProductosAsociados;

  Integer iNumeroGrupos;
  Integer iNumeroPaquetes;

  Boolean grupo;
  Boolean paquete;
  Boolean grupoCondicionante;
  Boolean grupoCondicionado;

  DTOSCargarCriteriosDefinirOferta dtoSCargarCriteriosDefinirOferta;
  Boolean cuadreGrupos;
  DTOEstrategia estrategia;
  MareBusinessID id;
  DTOOID dtoOID;
  DruidaConector conectorGenerico;
  Vector params;
  DTOSalida dtoSalida;
  Integer numeroGrupos;
  RecordSet opcionesCombo;
  Element comboElement;
  DruidaConector dc;

  //variables para actualizar pagina
  String crearGrupoValorCombo;
  String crearGrupoFactorCuadre;
  private long TiempoDeCargaInicio;
  private long TiempoDeCargaFin;

  // Definicion del constructor
  public LPCrearGrupo() {
    super();
	}

  // Definicion del metodo abstracto inicio
  public void inicio() throws Exception {
    // Defino el nombre de la vista
    pagina("contenido_grupo_crear");
  }

  public void ejecucion() throws Exception {
    TiempoDeCargaInicio=System.currentTimeMillis();
    setTrazaFichero();

    traza("entro a lp");
    //agregado Por el caso de uso modificar grupos
    String casoDeUso = conectorParametroLimpia("casoDeUso","",true);
    asignarAtributo("VAR",casoDeUso,"valor",casoDeUso);
  
	
  	//Recupera variables de la pagina
		accion = conectorParametroLimpia("accion", "", true);
    elementosSeleccionadosProductosAsociados = conectorParametroLimpia( 
                          "elementosSeleccionadosProductosAsociados", "", true );
    
    productosGrupo = new Vector();
    
    try{
      //acciones
      if( accion.equals( "" ) ){
          this.conectorParametroSesion( "productosGrupo", productosGrupo );
          cargarPantalla();
      } else if( accion.equals( "Buscar producto" ) ){
          crearGrupoValorCombo = this.conectorParametroLimpia( "cbIndicadorCuadre", "", true );
          crearGrupoFactorCuadre = this.conectorParametroLimpia( "txtFactorCuadre", "", true );
          this.conectorParametroSesion( "CrearGrupoValorCombo", (crearGrupoValorCombo==null) ? "" : crearGrupoValorCombo );
          this.conectorParametroSesion( "CrearGrupoFactorCuadre", (crearGrupoFactorCuadre==null) ? "" : crearGrupoFactorCuadre );
          this.buscarProducto();
        
      } else if( accion.equals( "Producto seleccionado" ) ){
          this.cargarPantalla();
          //Guarda en sesion el valor seleccionado del combo
          crearGrupoValorCombo = (String) this.conectorParametroSesion( "campoIndicadorCuadre" );

          if( crearGrupoValorCombo != null ){
              this.asignarAtributo( "VAR", "valorCombo", "valor", crearGrupoValorCombo );
          }
          crearGrupoFactorCuadre = (String) this.conectorParametroSesion( "CrearGrupoFactorCuadre" );

          if( crearGrupoFactorCuadre != null ){
              this.asignarAtributo( "CTEXTO", "txtFactorCuadre", "valor", crearGrupoFactorCuadre );
          }

        this.productoSeleccionado();
        
      } else if( accion.equals( "Eliminar productos" ) ){
          crearGrupoValorCombo = this.conectorParametroLimpia( "cbIndicadorCuadre", "", true );
          crearGrupoFactorCuadre = this.conectorParametroLimpia( "txtFactorCuadre", "", true );
          this.conectorParametroSesion( "CrearGrupoValorCombo", (crearGrupoValorCombo==null) ? "" : crearGrupoValorCombo );
          this.conectorParametroSesion( "CrearGrupoFactorCuadre", (crearGrupoFactorCuadre==null) ? "" : crearGrupoFactorCuadre );
          traza("ind y factor cuadre: "+crearGrupoValorCombo+crearGrupoFactorCuadre);
          this.cargarPantalla();
          this.eliminarProductos();
          this.asignarAtributo( "VAR", "valorCombo", "valor", crearGrupoValorCombo );
          this.asignarAtributo( "CTEXTO", "txtFactorCuadre", "valor", crearGrupoFactorCuadre );
        
      } else if( accion.equals( "Guardar" ) ){
          crearGrupoValorCombo = this.conectorParametroLimpia( "cbIndicadorCuadre", "", true );
          crearGrupoFactorCuadre = this.conectorParametroLimpia( "txtFactorCuadre", "", true );
          this.guardarGrupo();
        
      }

      //Asignar variables hidden
      //this.asignarAtributo( "VAR", "valorCombo", "valor", ((crearGrupoValorCombo==null) ? "" : crearGrupoValorCombo) );
      traza("entron a 2---->" + crearGrupoFactorCuadre);
	    this.asignarAtributo( "VAR", "hFactorCuadre", "valor", ((crearGrupoFactorCuadre==null) ? "" : crearGrupoFactorCuadre) );
      this.conectorParametroSesion( "CrearGrupoValorCombo", (crearGrupoValorCombo==null) ? "" : crearGrupoValorCombo );
      this.conectorParametroSesion( "CrearGrupoFactorCuadre", (crearGrupoFactorCuadre==null) ? "" : crearGrupoFactorCuadre );

      this.getConfiguracionMenu( "LPCrearGrupo", "" );

      TiempoDeCargaFin = System.currentTimeMillis();
      traza("El tiempo de carga de LPCrearGrupo es :"+(TiempoDeCargaFin-TiempoDeCargaInicio));
    } catch (Exception ex){
      logStackTrace( ex );
      this.lanzarPaginaError(ex);
    }
  }

  //****************************************************************************
  // METODOS DE SERVICIO
  //****************************************************************************


  private void cargarPantalla() throws Exception{
    this.getFormatosValidaciones();
    //Se guarda el Vector productoGrupo en sesion
    //this.conectorParametroSesion( "productosGrupo", productosGrupo );
    dtoOferta = (DTOOferta) this.conectorParametroSesion( "DTOOferta" );
    grupoActual = (Integer) this.conectorParametroSesion( "grupoActual" );
    iNumeroGrupos = dtoOferta.getNumeroGrupos();
    iNumeroPaquetes = dtoOferta.getNumeroPaquetes();

    //Asignar numero de grupos
    if( iNumeroGrupos != null && iNumeroGrupos.intValue() > 0 ){
      this.asignarAtributo( "LABELC", "lblNGrupoX", "valor", grupoActual.toString() + " de " + iNumeroGrupos.toString() );
    } else{
      this.asignarAtributo( "LABELC", "lblNGrupoX", "valor", grupoActual.toString() + " de " + ((iNumeroPaquetes==null) ? null : iNumeroPaquetes.toString()) );
    }

    //Asignar tipo de grupos
    grupo = (Boolean) this.conectorParametroSesion( "grupo" );
    paquete = (Boolean) this.conectorParametroSesion( "paquete" );
    grupoCondicionante = (Boolean) this.conectorParametroSesion( "condicionante" );
    grupoCondicionado = (Boolean) this.conectorParametroSesion( "condicionado" );

    //Asignacion de Tipo de Grupo
    if( grupo != null && grupo.booleanValue() ){
      this.asignarAtributo( "LABELC", "lblTipoGrupoX", "valor", "Grupo" );
    }
    else if( paquete != null && paquete.booleanValue() ){
      this.asignarAtributo( "LABELC", "lblTipoGrupoX", "valor", "Paquete" );
	  this.asignarAtributo( "VAR", "hDeshabilitarFactorCuadre", "valor", "S" );
    }
    else if( grupoCondicionante != null && grupoCondicionante.booleanValue() ){
      this.asignarAtributo( "LABELC", "lblTipoGrupoX", "valor", "Grupo_condicionante" );
    }
    else if( grupoCondicionado != null && grupoCondicionado.booleanValue() ){
      this.asignarAtributo( "LABELC", "lblTipoGrupoX", "valor", "Grupo_condicionado" );
    }
    
    dtoSCargarCriteriosDefinirOferta = (DTOSCargarCriteriosDefinirOferta) 
              this.conectorParametroSesion( "DTOSCargarCriteriosDefinirOferta" );

    if( dtoSCargarCriteriosDefinirOferta != null ){
      estrategia = dtoSCargarCriteriosDefinirOferta.getEstrategia();
      if( estrategia != null ){
        cuadreGrupos = estrategia.getCuadreGrupos();

        if( cuadreGrupos != null && cuadreGrupos.booleanValue() ){

          traza("ENTRO POR CUADRE GRUPOS == TRUE");
        
          id = new MareBusinessID( "PREBuscarIndicadoresCuadrePorTipoEstrategia" );
          dtoOID = new DTOOID();

          //Parametros auditoria
          dtoOID.setIpCliente( UtilidadesSession.getIdUsuario( this ) );
          dtoOID.setPrograma( UtilidadesSession.getFuncion( this ) );
          
          dtoOID.setOid( estrategia.getOid() );
          dtoOID.setOidIdioma(UtilidadesSession.getIdioma(this));
          dtoOID.setOidPais(UtilidadesSession.getPais(this));

          params = new Vector();
          params.add( dtoOID );
          params.add( id );

          //cambiar por ConectorcargarIndicadoresCuadrePorTipoEstrategia
          //esta andando con ConectorBuscarEstrategias
          traza( "--VA A CONECTAR!--" );
          conectorGenerico = this.conectar( "ConectorcargarIndicadoresCuadrePorTipoEstrategia", params );
          traza( "--CONECTO!--" );

          dtoSalida = (DTOSalida) conectorGenerico.objeto( "dtoSalida" );
          opcionesCombo = dtoSalida.getResultado();

          //-------------------------------------------
          traza("RESULTADO OBTENIDO");
          traza( dtoSalida.getResultado() );
          //-------------------------------------------

          //Cargar los indicadores de cuadre en el combo teniendo en cuenta en 
          //numero e grupos de la oferta.
          //Si es 1 carga los indicadores de monogrupo.
          //Si es > 1 carga los indicadores multigrupo.
          this.asignarCombo( opcionesCombo, dtoOferta, true, ((grupoCondicionado==null)?false:grupoCondicionado.booleanValue()) );
     
        } else{

          traza("--ENTRO POR CUADRE GRUPOS == FALSE--");

          //Se asigna el indicador de cuadre de la oferta (DTOOferta.oidIndicadorCuadre)
          //al combo Indicador de cuadre.
          //La descripcion se obtiene de DTOSCargarCriteriosDefinirOferta.indicadoresCuadre.
          Long oidIndCuadre = dtoOferta.getOidIndCuadre();
          RecordSet indicadoresCuadre = dtoSCargarCriteriosDefinirOferta.getIndicadoresCuadre();

          //Se debe setear la accion y un VAR en la pagina para que el 
          //JavaScript de la pagina asigne el valor al combo y lo deshabilite.
          traza("entron a 3");
          this.asignarAtributo( "VAR", "hDeshabilitarCombo", "valor", "S" );
          this.asignarAtributo( "VAR", "valorCombo", "valor", 
                        (oidIndCuadre == null) ? "" : oidIndCuadre.toString() );
       
          this.asignarCombo( indicadoresCuadre, dtoOferta, false, ((grupoCondicionado==null)?false:grupoCondicionado.booleanValue()) );
        }
      }
    }
  }

  private void buscarProducto() throws Exception {
    this.conectorParametroSesion( "volverLPBuscarProducto", "LPCrearGrupo" );

	//enozigli 27/09/2005 BELC300021032
	DTOOferta dtoOf = (DTOOferta) conectorParametroSesion("DTOOferta");
	conectorParametroSesion("oidCatalogo", dtoOf.getOidCatalogo().toString());
	conectorParametroSesion("descripcionCatalogo", dtoOf.getDescripcionCatalogo());	

    //Guarda en sesion el valor seleccionado del combo
    this.conectorParametroSesion( "campoIndicadorCuadre", crearGrupoValorCombo );
    this.conectorAction( "LPBuscarProducto" );
    this.conectorActionParametro( "accion", "" );
    this.conectorActionParametro( "multiseleccion", "true" );
    this.conectorActionParametro( "mostrarValoresAdicionales", "true" );
  }

  //lo llamas cuando la accion es producto seleccionado
  private void productoSeleccionado() throws Exception{ 
  
    Hashtable htp = null;
    Vector productosGrupo = null;
    htp = (Hashtable)conectorParametroSesion("Productos");
    productosGrupo = (Vector) this.conectorParametroSesion( "productosGrupo" );
    productosGrupo = (productosGrupo==null) ? new Vector() : productosGrupo;
    Collection c = htp.values();
    
    if( c != null ){

      //Antes de agregar, se verifica que en ese vector no exista ningun 
      //DTOProducto con ese oid.
      DTOProducto dtoProductoBuscado = null;
      DTOProducto dtop = null;
      Iterator idtopb = c.iterator();
      Iterator idtop = null; //productosGrupo.iterator();
      Boolean existe = Boolean.FALSE;

      while( idtopb.hasNext() ){
        try{
          dtoProductoBuscado = (DTOProducto)idtopb.next();
          if( dtoProductoBuscado != null ){
            existe = Boolean.FALSE;

            idtop = productosGrupo.iterator();
            
            while( idtop.hasNext() && !existe.booleanValue() ){
              dtop = (DTOProducto)idtop.next();
              if( dtop != null && dtoProductoBuscado.getOid().equals( dtop.getOid() ) ){
                productosGrupo.remove(dtop);
                existe = Boolean.TRUE;
              }
            }
           // if( !existe.booleanValue() ){
              productosGrupo.add( dtoProductoBuscado );
           // }
          }
        } catch(Exception exc){exc.printStackTrace();}
      }
    }

    if( productosGrupo != null ){

      //Carga los productos en la lista
      generaRecordSetProductos( productosGrupo );
      traza("Productos en la pantalla: "+productosGrupo);
      this.conectorParametroSesion( "productosGrupo", productosGrupo );
    }
  }

  private void generaRecordSetProductos(Vector table)throws Exception{
    Hashtable h = new Hashtable();
    DTOProducto dto = null;
    Enumeration e = table.elements();
    Long oid = null;

    while( e.hasMoreElements() ){
      try{
        dto = (DTOProducto)e.nextElement();
        oid = dto.getOid();
        h.put( oid.toString(), dto );
      } catch(Exception exc){}
    }
    this.generaRecordSetProductos( h );
  }

  //Arma el RecordSet y lo asigna a la LISTA EDITABLE
  //Parametros:
  // Hashtable table: Hashtable recuperado de sesion ("Productos").
  private void generaRecordSetProductos(Hashtable table)throws Exception{
  
    RecordSet recordSet = new RecordSet();
    
    /*if (table.size()!=0){
      traza("hash vacio");
      throw new RuntimeException();
    }*/

    llenarRecordSetProductos(recordSet);
    
    Enumeration enum = table.elements();
    int i=0;
    Vector vv = null;
    
    while(enum.hasMoreElements()){
      DTOProducto dto = (DTOProducto)enum.nextElement();
      
      vv = new Vector();
      vv.setSize( 21 );
      recordSet.addRow( vv );
      
      recordSet.setValueAt(dto.getOid(),i,0);
      if (dto.getCodigoSAP() != null) recordSet.setValueAt(dto.getCodigoSAP(), i, 1);            
      if (dto.getTextoBreve() != null) recordSet.setValueAt(dto.getTextoBreve(), i, 2);
      if (dto.getDescripcionTipoOferta() != null) recordSet.setValueAt(dto.getDescripcionTipoOferta(), i, 3);
      if (dto.getDescripcionCicloVida() != null) recordSet.setValueAt(dto.getDescripcionCicloVida(), i, 4);
      if (dto.getFactorRepeticion() != null) recordSet.setValueAt(dto.getFactorRepeticion(), i, 5);
      if (dto.getPrecioCatalogo() != null) recordSet.setValueAt(UtilidadesBelcorp.formateaNumeroSICC(dto.getPrecioCatalogo().toString(),this.FORMATO_DEFAULT,this), i, 6);
      if (dto.getAtributo1() != null) recordSet.setValueAt(dto.getAtributo1(), i, 7);            
      if (dto.getAtributo2() != null) recordSet.setValueAt(dto.getAtributo2(), i, 8);            
      if (dto.getAtributo3() != null) recordSet.setValueAt(dto.getAtributo3(), i, 9);
      if (dto.getPaginaCatalogo() != null) recordSet.setValueAt(dto.getPaginaCatalogo(), i, 10);            
      if (dto.getPosicionPagina() != null) recordSet.setValueAt(dto.getPosicionPagina(), i, 11);            
      if (dto.getUnidadesEstimadas() != null) recordSet.setValueAt(dto.getUnidadesEstimadas(), i, 12);            
      if (dto.getVentaNetaEstimada() != null) recordSet.setValueAt(dto.getVentaNetaEstimada(), i, 13);            
      if (dto.getPrecioPosicionamiento() != null) recordSet.setValueAt(dto.getPrecioPosicionamiento(), i, 14);            
      if (dto.getCosteEstandar() != null) recordSet.setValueAt(dto.getCosteEstandar(), i, 15);            
      if (dto.getOidCatalogo() != null) recordSet.setValueAt(dto.getOidCatalogo(), i, 16);            
      //recordSet.setValueAt(null,i,17);//no esta la descripcion del catalogo en el dto
      if (dto.getOidTipoOferta() != null) recordSet.setValueAt(dto.getOidTipoOferta(), i, 18);            
      if (dto.getOidCicloVida() != null) recordSet.setValueAt(dto.getOidCicloVida(), i, 19);
      if (dto.getCentro() != null)  recordSet.setValueAt(dto.getCentro(), i, 20);
      
      i++;
    }
    
    asignar("LISTADOA", "listado1", UtilidadesBelcorp.generarConector("dtoSalida", recordSet,
                                recordSet.getColumnIdentifiers()), "dtoSalida");
                 
    //conectorParametroSesion("DTOProductoPrincipal", table); //Subo la hash, no el dto
  }
  
  private void llenarRecordSetProductos(RecordSet r){
      r.addColumn("OID");
      r.addColumn("COD_SAP");
      r.addColumn("VAL_TEXT_BREV");
      r.addColumn("DES_TIPO_OFER");
      r.addColumn("DES_CICL_VIDA");
      r.addColumn("VAL_FACT_REPE");
      r.addColumn("IMP_PREC_CATA");
      r.addColumn("VAL_ATRI_1");
      r.addColumn("VAL_ATRI_2");
      r.addColumn("VAL_ATRI_3");
      r.addColumn("NUM_PAGI_CATA");
      r.addColumn("VAL_POSI_PAGI");
      r.addColumn("NUM_UNID_ESTI");
      r.addColumn("IMP_VENT_NETA");
      r.addColumn("IMP_PREC_POSI");
      r.addColumn("VAL_COST_ESTA");
      r.addColumn("OCAT_OID_CATA");
      r.addColumn("DES_CATA");
      r.addColumn("TOFE_OID_TIPO_OFER");
      r.addColumn("CIVI_OID_CICL_VIDA");
      r.addColumn("VAL_CENT");
  }

  private void eliminarProductos() throws Exception {
  
    DTOOferta dtoOferta = null;

    elementosSeleccionadosProductosAsociados = this.conectorParametro( "elementosSeleccionadosProductosAsociados" );
    traza("elementos a borrar: "+elementosSeleccionadosProductosAsociados);
    //Vector con los elementos de la lista en pantalla (los seleccionados).
    Vector vec=this.parsearElementosLista(this.elementosSeleccionadosProductosAsociados);
    traza("Vector final: "+vec);
    //Vector con los elementos guardados en sesion. Representa a todos los elementos
    //de la lista. De este vector se eliminan los elementos.
    Vector productosGrupo = (Vector)conectorParametroSesion("productosGrupo");
    
    Enumeration enum = vec.elements();

    //Se eliminan los elementos
    while(enum.hasMoreElements()){
      Long oid = (Long) enum.nextElement();
      Enumeration enum2 = productosGrupo.elements();
      while(enum2.hasMoreElements()){
        DTOProducto dto = (DTOProducto)enum2.nextElement();
        traza("oidProductos: "+dto.getOid());
        if (dto.getOid().equals(oid)){
          traza("borre un elemento en forma logica: "+oid);
          // Modificacion por ssantana, 17/10/2005, GCC-PRE-001
          productosGrupo.remove(dto);//porque aun no existe en BD o sea solo no hay que insertarlo.
          //dto.setTipoOperacion("baja");
          // Fin modificacion por ssantana, 17/10/2005, GCC-PRE-001
          break;
        }
      }
    }

    // Modificacion por ssantana, 17/10/2005, GCC-PRE-001
    dtoOferta = (DTOOferta) this.conectorParametroSesion( "DTOOferta" );
    dtoOferta.setModificacionGrupo(Boolean.TRUE);
    this.conectorParametroSesion("DTOOferta", dtoOferta);
    // Fin modificacion por ssantana, 17/10/2005, GCC-PRE-001
    
    generaRecordSetProductos( productosGrupo );

    //Una vez eliminados los elementos del vector, se guarda en sesion nuevamente.
    conectorParametroSesion("productosGrupo", productosGrupo);
  }

  private Vector parsearElementosLista( String lista ){
    Vector vec = new Vector();
    StringTokenizer st = new StringTokenizer(lista,"|");
    while (st.hasMoreElements()) {
      vec.addElement(new Long(st.nextToken()));
    }        
    return vec;
  }

  private void guardarGrupo() throws Exception {

    Integer grupoActual = null;
    Boolean grupo = null;
    Boolean paquete = null;
    Boolean condicionante = null;
    Boolean condicionado = null;
    DTOSCargarCriteriosDefinirOferta dtoSCargarCriteriosDefinirOferta = null;
    Vector productosGrupo = null;
    DTOOferta dtoOferta = null;
    
    grupoActual = (Integer) this.conectorParametroSesion( "grupoActual" );
    paquete = (Boolean)this.conectorParametroSesion( "paquete" );
    grupo = (Boolean)this.conectorParametroSesion( "grupo" );
    condicionante = (Boolean)this.conectorParametroSesion( "condicionante" );
    condicionado = (Boolean)this.conectorParametroSesion( "condicionado" );

    DTOGrupo dtoGrupo = new DTOGrupo();

    //Parametros auditoria
    dtoGrupo.setIpCliente( UtilidadesSession.getIdUsuario( this ) );
    dtoGrupo.setPrograma( UtilidadesSession.getFuncion( this ) );

    dtoGrupo.setIndicadorGrupo( grupo );
	  traza("grupoActual   "  + grupoActual);
    dtoGrupo.setNumeroGrupo( grupoActual );

    try{
      dtoGrupo.setOidIndicadorCuadre( new Long(crearGrupoValorCombo) );
      dtoGrupo.setDescripcionIndicadorCuadre(conectorParametro("textoCombo") );
    } catch(Exception exc){}

    try{
      dtoGrupo.setFactorCuadre( new BigDecimal(crearGrupoFactorCuadre) );
    } catch(Exception exc){}

    crearGrupoValorCombo="";
    crearGrupoFactorCuadre="";
    this.conectorParametroSesion( "CrearGrupoValorCombo", crearGrupoValorCombo );
    this.conectorParametroSesion( "CrearGrupoFactorCuadre",  crearGrupoFactorCuadre );
    dtoGrupo.setCondicionante( condicionante );
    dtoGrupo.setCondicionado( condicionado );

    DTODetalleOferta dtoDetalleOferta = null;
    DTOProducto dtoProducto = null;
    Enumeration e = null;
    
    productosGrupo = ( Vector ) this.conectorParametroSesion( "productosGrupo" );
    dtoOferta = ( DTOOferta ) this.conectorParametroSesion( "DTOOferta" );
    dtoSCargarCriteriosDefinirOferta = (DTOSCargarCriteriosDefinirOferta) 
              this.conectorParametroSesion( "DTOSCargarCriteriosDefinirOferta" );

    //Se agrega el grupo al dtoOferta
    Vector grupos = null;
    if( dtoOferta.getGrupo() == null ){
      grupos = new Vector();
    } else{
      grupos = dtoOferta.getGrupo();
    }
    grupos.add( dtoGrupo );
    dtoOferta.setGrupo( grupos );
    
    //Detalles de Oferta
    Vector detallesOferta = new Vector();

    if( productosGrupo != null && dtoOferta != null ){
      e = productosGrupo.elements();

      if( dtoOferta.getDetalleOferta() == null ){
        dtoOferta.setDetalleOferta( new Vector() );
      }
      
      Enumeration eDTOOferta = dtoOferta.getDetalleOferta().elements();
      int contDetalles = 0;
      DTODetalleOferta dtoDO = null;

      //Se cuenta la cantidad de DTODetalleOferta que trae el DTOOferta
      while( eDTOOferta.hasMoreElements() ) {
        try{
          dtoDO = (DTODetalleOferta) eDTOOferta.nextElement();
          if( dtoDO != null )
            contDetalles++;
        }catch(Exception exc){}
      }

      while( e.hasMoreElements() ){
        dtoProducto = (DTOProducto) e.nextElement();
        dtoDetalleOferta = new DTODetalleOferta();

        //Parametros auditoria
        dtoDetalleOferta.setIpCliente( UtilidadesSession.getIdUsuario( this ) );
        dtoDetalleOferta.setPrograma( UtilidadesSession.getFuncion( this ) );
        
        dtoDetalleOferta.setLineaOferta( new Integer( ++contDetalles ) );
        dtoDetalleOferta.setOidSAP( (dtoProducto==null) ? null : dtoProducto.getOid() );
        dtoDetalleOferta.setDescripcion( (dtoProducto==null) ? null : dtoProducto.getTextoBreve() );
        dtoDetalleOferta.setUnidadesEstimadas( (dtoProducto==null) ? null : dtoProducto.getUnidadesEstimadas() );
        dtoDetalleOferta.setOrigen( ConstantesPRE.MF );
        dtoDetalleOferta.setFactorRepeticion( (dtoProducto==null) ? null : dtoProducto.getFactorRepeticion() );
        dtoDetalleOferta.setDigitable( (dtoProducto==null) ? null : dtoProducto.getDigitable() );
        dtoDetalleOferta.setImpresionGP( (dtoProducto==null) ? null : dtoProducto.getImprimible() );
        dtoDetalleOferta.setPosicionRanking( null );
        dtoDetalleOferta.setOidFormaPago( (dtoOferta==null) ? null : dtoOferta.getOidFormaPago() );
        dtoDetalleOferta.setNumeroGrupo( (dtoGrupo==null) ? null : dtoGrupo.getNumeroGrupo() );
        dtoDetalleOferta.setProductoPrincipal( null );
        dtoDetalleOferta.setPrecioCatalogo( (dtoProducto==null) ? null : dtoProducto.getPrecioCatalogo() );
        dtoDetalleOferta.setPosicionPagina( (dtoProducto==null) ? null : dtoProducto.getPosicionPagina() );
        dtoDetalleOferta.setPrecioPosicionamiento( (dtoProducto==null) ? null : dtoProducto.getPrecioPosicionamiento() );
        //dtoDetalleOferta.setOidMoneda( (dtoSCargarCriteriosDefinirOferta==null) ? null : dtoSCargarCriteriosDefinirOferta.getOidMoneda() ); 
        dtoDetalleOferta.setCosteEstandar( (dtoProducto==null) ? null : dtoProducto.getCosteEstandar() );
        dtoDetalleOferta.setVentaNetaEstimada( (dtoProducto==null) ? null : dtoProducto.getVentaNetaEstimada() );
        dtoDetalleOferta.setOidCatalogo( (dtoProducto==null) ? null : dtoProducto.getOidCatalogo() );
        dtoDetalleOferta.setPaginaCatalogo( (dtoProducto==null) ? null : dtoProducto.getPaginaCatalogo() );
        dtoDetalleOferta.setOidCondicionPromocion( (dtoProducto==null) ? null : dtoProducto.getOidCondicionPromocion() );
        dtoDetalleOferta.setOidTipoOferta( (dtoProducto==null) ? null : dtoProducto.getOidTipoOferta() );
        dtoDetalleOferta.setOidCicloVida( (dtoProducto==null) ? null : dtoProducto.getOidCicloVida() );
        dtoDetalleOferta.setCentro( (dtoProducto==null) ? null : dtoProducto.getCentro() );
        dtoDetalleOferta.setCodigoSAP( (dtoProducto==null) ? null :dtoProducto.getCodigoSAP() );        
        dtoDetalleOferta.setAtributo1( (dtoProducto==null) ? null :dtoProducto.getAtributo1() );
        dtoDetalleOferta.setAtributo2( (dtoProducto==null) ? null :dtoProducto.getAtributo2() );
        dtoDetalleOferta.setAtributo3( (dtoProducto==null) ? null :dtoProducto.getAtributo3() );   
		/*inicio enozigli COL-PRE-002*/
		dtoDetalleOferta.setRangosPrecios( (dtoProducto==null) ? null :dtoProducto.getRangosPrecios() ); 
		/*fin enozigli COL-PRE-002*/
        
        // Agregado por ssantana, 17/10/2005, GCC-PRE-001
        traza("Setea operacion como 'Alta'");
        dtoDetalleOferta.setTipoOperacion("alta");
        // Fin Agregado por ssantana, 17/10/2005, GCC-PRE-001 
        
        detallesOferta.add( dtoDetalleOferta );
      }

      if( dtoOferta.getDetalleOferta() == null ){
        dtoOferta.setDetalleOferta( detallesOferta );
      } else{

        //Antes de agregar, se verifica que en ese vector no exista ningun 
        //DTOProducto con ese oid.
        DTODetalleOferta dtop = null;
        Boolean existe = Boolean.FALSE;
        DTODetalleOferta dtoProductoBuscado = null;
        Iterator idtop = null;
        Vector detallesEnOferta = dtoOferta.getDetalleOferta();
        Iterator idtopb = detallesOferta.iterator();

        while( idtopb.hasNext() ){
          try{
            dtoProductoBuscado = (DTODetalleOferta)idtopb.next();
            /*if( dtoProductoBuscado != null ){
              existe = Boolean.FALSE;

              idtop = detallesEnOferta.iterator();

              while( idtop.hasNext() && !existe.booleanValue() ){
                dtop = (DTODetalleOferta)idtop.next();
                if( dtop != null && dtoProductoBuscado.getOidSAP().equals( dtop.getOidSAP() ) ){
                  existe = Boolean.TRUE;
                }
              }
              if( !existe.booleanValue() ){*/
                detallesEnOferta.add( dtoProductoBuscado );
            /* }
            }*/
          } catch(Exception exc){}
        }
      }

      //Elimina de sesion el productosGrupo
      this.getRequest().getSession().removeAttribute( "productosGrupo" );
      
      // Agregado por ssantana, 5/10/2005, cambio SICC-PRE-GCC-001
      dtoOferta.setModificacionGrupo(Boolean.TRUE);
      // Fin Agregado por ssantana, 5/10/2005, cambio SICC-PRE-GCC-001
      
      if( dtoOferta != null ){
        this.conectorParametroSesion("DTOOferta", dtoOferta );
      }
    }

    String lpRegreso = (String)conectorParametroSesion("LPRegreso");

  	if(lpRegreso!=null && lpRegreso.equals("LPModificarOferta")){
        this.conectorAction( "LPModificarOferta" );
        this.conectorActionParametro( "accion", "GrupoAnadido" );
    } else{
        this.conectorAction( "LPDefinirOferta" );
        this.conectorActionParametro( "accion", "Comprobar restricciones" );
    }
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

  /**
   * Toma los datos obtenidos de sesion, los pasa a un RowSet y los asigna al
   * combo en pantalla.
   */
  private void asignarCombo( RecordSet opcionesCombo, DTOOferta dtoOferta, boolean cuadreOferta, boolean esGrupoCondicionado ) throws Exception {

    Element comboElement = null;
    DruidaConector dc = null;

    if( cuadreOferta ){
      comboElement = this.getElementFromRecordSet( opcionesCombo, "CLAVE", 
        ((dtoOferta.getNumeroGrupos()!=null) ? dtoOferta.getNumeroGrupos() : dtoOferta.getNumeroPaquetes()), esGrupoCondicionado );
    }
    else{
      comboElement = this.getElementFromRecordSet( opcionesCombo, "CLAVE" );
    }

    if( comboElement != null ){
      dc = new DruidaConector();
      dc.setXML( comboElement );
      this.asignar( "COMBO", "cbIndicadorCuadre", dc, "CLAVE" );
    }
  }

  private Element getElementFromRecordSet(RecordSet rsEntrada, String id, Integer tipoUsuario, boolean esGrupoCondicionado) throws Exception{

    int INDEX_INDICADOR_CUADRE_TIPO_ESTRATEGIA  = 0;
    int INDEX_VAL_I18N                          = 1;
    int INDEX_INDICADOR_CUADRE                  = 2;
    int INDEX_INDICADOR_MONOGRUPO               = 3;

    //tipo usuario
    int iTipoUsuario = 0;
    iTipoUsuario = ( tipoUsuario==null ) ? iTipoUsuario : tipoUsuario.intValue();

    BigDecimal indTipoUsuario = null;
    DocumentBuilder docBuild = null;
    docBuild = DocumentBuilderFactory.newInstance().newDocumentBuilder();
  
    if(docBuild == null){
       docBuild = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    }

    Document doc = docBuild.newDocument();
    Element raiz = doc.createElement("ROWSET2");
    doc.appendChild(raiz);
    int filas = rsEntrada.getRowCount();
    int columnas = rsEntrada.getColumnCount();
    Vector nombresColumnas = rsEntrada.getColumnIdentifiers();
    Vector vFila = null;
    Element rowset = doc.createElement("ROWSET");
    rowset.setAttribute("ID", id);
    rowset = (Element)doc.getDocumentElement().appendChild(rowset);
    Element campo = null;
    Element row = null;

    for(int i = 0; i < filas; i++){
       vFila = rsEntrada.getRow(i);
       //incidencia 10247
       if((!esGrupoCondicionado)||
          ((esGrupoCondicionado)&&
           (vFila.get(0)!= null)&&
           (!(new Long(vFila.get(0).toString())).equals(new Long(ConstantesPRE.CUADRE_TOTAL_MONTOS))))){
       row = doc.createElement("ROW");
       row = (Element)rowset.appendChild(row);
       row.setAttribute("ID", (vFila.get(0) == null)?"":vFila.get(0).toString());
      indTipoUsuario = (BigDecimal) vFila.get( INDEX_INDICADOR_MONOGRUPO );

      traza("indTipoUsuario: " + indTipoUsuario);

      //iTipoUsuario viene de DTOOferta recuperado de sesion.
      //Si iTipoUsuario == 1 se cargan los registros con monogrupo, o sea los que
      //tienen el campo de indicador de monogrupo en 1 (true).
      //Si iTipoUsuario > 1 se cargan los registros con multigrupo, o sea los que
      //tienen el campo de indicador de monogrupo en 0 (false).
      if( (iTipoUsuario == 1 && indTipoUsuario.intValue() == 1) || 
          (iTipoUsuario > 1 && indTipoUsuario.intValue() == 0) ){
       
        for(int j = columnas - 1; j >= 0; j--){
          if( j == INDEX_INDICADOR_CUADRE   ||
                j == INDEX_VAL_I18N ){

            campo = doc.createElement("CAMPO");
            campo.setAttribute("TIPO", "STRING");
            campo.setAttribute("LONGITUD", "100");
            campo.setAttribute("NOMBRE", (String)nombresColumnas.get(j));
            campo.appendChild(doc.createTextNode((vFila.get(j) == null)?"":vFila.get(j).toString()));
            row.appendChild(campo);
          }
        }
      }
      }
    }
    return doc.getDocumentElement();
  }

  private Element getElementFromRecordSet(RecordSet rsEntrada, String id ) throws Exception{

    DocumentBuilder docBuild = null;
    docBuild = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    
    if(docBuild == null){
       docBuild = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    }

    Document doc = docBuild.newDocument();
    Element raiz = doc.createElement("ROWSET2");
    doc.appendChild(raiz);

    int filas = rsEntrada.getRowCount();
    int columnas = rsEntrada.getColumnCount();

    Vector nombresColumnas = rsEntrada.getColumnIdentifiers();
    Vector vFila = null;
    Element rowset = doc.createElement("ROWSET");
    rowset.setAttribute("ID", id);
    rowset = (Element)doc.getDocumentElement().appendChild(rowset);
    Element campo = null;
    Element row = null;

    for(int i = 0; i < filas; i++){
      vFila = rsEntrada.getRow(i);
      row = doc.createElement("ROW");
      row = (Element)rowset.appendChild(row);
      row.setAttribute("ID", (vFila.get(0) == null)?"":vFila.get(0).toString());
       
      for(int j = 0; j < columnas; j++){
        if( j == 0 || j == 1 ){
          campo = doc.createElement("CAMPO");
          campo.setAttribute("TIPO", "STRING");
          campo.setAttribute("LONGITUD", "100");
          campo.setAttribute("NOMBRE", (String)nombresColumnas.get(j));
          campo.appendChild(doc.createTextNode((vFila.get(j) == null)?"":vFila.get(j).toString()));
          row.appendChild(campo);
        }
      }
    }
    return doc.getDocumentElement();
  }
}
