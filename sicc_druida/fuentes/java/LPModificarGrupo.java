/*
    INDRA/CAR/PROY
    $Id: LPModificarGrupo.java,v 1.1 2009/12/03 18:43:08 pecbazalar Exp $
    DESC
*/

//import LPSICCBase;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.pre.ConstantesPRE;
import es.indra.sicc.dtos.pre.DTODetalleOferta;
import es.indra.sicc.dtos.pre.DTOEstrategia;
import es.indra.sicc.dtos.pre.DTOGrupo;
import es.indra.sicc.dtos.pre.DTOOferta;
import es.indra.sicc.dtos.pre.DTOProducto;
import es.indra.sicc.dtos.pre.DTOSCargarCriteriosDefinirOferta;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;

import java.math.BigDecimal;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jaxen.dom.DOMXPath;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.w3c.dom.Node;

public class LPModificarGrupo extends LPSICCBase {
	private String sAccion		= null;
	private String sCampoUno	= null;
	private String elementosSeleccionadosProductosAsociados = null;

	private String crearGrupoValorCombo 	= null;
	private String crearGrupoFactorCuadre 	= null;
	private String sGrupoActual				= null;
			
	private Vector vProductosGrupo	= new Vector();
	private Vector vDetalleOferta	= new Vector();
	private Vector vParamEntrada	= new Vector();
	private Vector vMonoGrupoTrue	= new Vector();
	private Vector vMonoGrupoFalse	= new Vector();
	private Vector vDtoOfertaGrupo	= new Vector();

	private Integer iNumeroGrupos	= null;
	private Integer iGrupoActual	= null;
	private Integer iNumeroPaquetes	= null;
	
	private Long lMonoGrupo			= null;

	private Boolean grupo;
	private Boolean paquete;
	private Boolean grupoCondicionante;
	private Boolean grupoCondicionado;
	private Boolean cuadreGrupos;

	private RecordSet rec_Set = null;
	private RecordSet opcionesCombo;
  private long TiempoDeCargaInicio;
  private long TiempoDeCargaFin;
	
	DTODetalleOferta	dtoDetOferta	= null;
	DTOProducto			dtoProd			= null;
	DTOGrupo			dtoGrupo		= null;
	DTOGrupo			dtoOfertaGrupo	= null;
	DTOOferta			dtoOferta		= null;
	DTOOID				dtoOid			= null;
	DTOSalida			dtoSalida		= null;
	DTOProducto 		dto_LP			= null;
	DTOEstrategia		dtoEstrategia	= null;
	DTOSCargarCriteriosDefinirOferta dtoSCargarCriteriosDefinirOferta = null;
	
	MareBusinessID idBusIndCuadre;
    
    // Agregado por SICC20070316 - Rafael Romero - 18/07/2007
    String casoDeUso = null;

	public LPModificarGrupo(){
		super();
	}

	//Definicion del metodo abstracto inicio
    public void inicio() throws Exception {
        pagina("contenido_grupo_crear");
        this.getConfiguracionMenu();
        this.getFormatosValidaciones();
    }

  public void ejecucion () throws  Exception{
  
    TiempoDeCargaInicio = System.currentTimeMillis();
    setTrazaFichero();

    //Asigna el titulo a la pagina "Modificar Grupo"
    this.asignarAtributoPagina( "cod", "0152" );
    traza("LPModificarGrupo.ejecucion()");    
    
    try{		
      crearGrupoValorCombo = (String)this.conectorParametroSesion( "CrearGrupoValorCombo" );
      crearGrupoFactorCuadre = (String)this.conectorParametroSesion( "CrearGrupoFactorCuadre" );
    } catch(Exception exc){}

    if( crearGrupoValorCombo == null || crearGrupoValorCombo.trim().equals( "" ) ){
      crearGrupoValorCombo = this.conectorParametroLimpia( "valorCombo", "", true );
    }
    if( crearGrupoFactorCuadre == null || crearGrupoFactorCuadre.trim().equals( "" ) ){
      crearGrupoFactorCuadre = this.conectorParametroLimpia( "hFactorCuadre", "", true );
    }
    
    sAccion = conectorParametroLimpia("accion", "", true);

    sGrupoActual = conectorParametroLimpia("hidNroGrupo", "", true);
    
    traza("accion:" + sAccion);
    
    // Agregado por SICC20070316 - Rafael Romero - 18/07/2007
    casoDeUso = conectorParametroLimpia("casoDeUso", "", true);
    if(!casoDeUso.equals("consultar")){
        casoDeUso = "modificar";
    }else{
        this.asignarAtributoPagina( "cod", "01072" );
    }
    traza("casoDeUso:" + casoDeUso);
    // Fin agregado SICC20070316
    
    try{
      if (sAccion.equals("")){
          cargarPantalla();
          cargarListaProductos(); 
          asignarAtributo("VAR","casoDeUso","valor",casoDeUso);
      } else if (sAccion.equals("Buscar producto")){
          asignarAtributo("VAR","casoDeUso","valor",casoDeUso);
          if ((sGrupoActual!=null)&&(!sGrupoActual.equals("")))
              conectorParametroSesion("hidNroGrupo",sGrupoActual);
          buscarProducto();
      } else if (sAccion.equals("Producto seleccionado")){
          productoSeleccionado();
          cargarPantalla();
          cargarListaProductos();
          asignarAtributo("VAR","casoDeUso","valor","modificar");
      }else if (sAccion.equals("Eliminar productos")){
          eliminarProducto();
          cargarPantalla();
          cargarListaProductos();
      }else if (sAccion.equals("Guardar")){
          asignarAtributo("VAR","casoDeUso","valor","modificar");
          guardarGrupo();
      } else if (sAccion.equals("Modificar producto") ){
        /*
         * Agregado por ssantana, 6/10/2005, GCC-PRE-001
         */
        if ((sGrupoActual!=null)&&(!sGrupoActual.equals("")))
            conectorParametroSesion("hidNroGrupo",sGrupoActual);         
         this.modificarProducto();
         
        /*
         * Fin agregado por ssantana, 6/10/2005, GCC-PRE-001 
         */
          
      }

      asignarAtributo("VAR", "hidNroGrupo", "valor", (sGrupoActual==null ? "" : sGrupoActual));
      
        // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
        agregarMenuComplementario();
        // Fin agregado SICC20070322
      
      TiempoDeCargaFin = System.currentTimeMillis();
      traza("El tiempo de carga de LPModificarGrupo es :"+(TiempoDeCargaFin-TiempoDeCargaInicio));
    } catch (Exception ex) {
      traza("exception: " + ex);

      java.io.StringWriter sw = new java.io.StringWriter();
      java.io.PrintWriter pw = new java.io.PrintWriter(sw);
      ex.printStackTrace(pw);
      pw.flush();
      traza("trace:" + sw);
      this.lanzarPaginaError(ex);
    }
  }

    private void cargarDatosPantalla()throws  Exception {

    }

    private void buscarProducto() throws  Exception {
        conectorParametroSesion("volverLPBuscarProducto", "LPModificarGrupo");
        conectorAction("LPBuscarProducto");
        conectorActionParametro( "accion", "" );
        conectorActionParametro("multiseleccion", "true");
        conectorActionParametro("mostrarValoresAdicionales", "true");
    } 

    private void productoSeleccionado() throws Exception{ 
        Hashtable htProductos	= null;
        htProductos = (Hashtable) this.conectorParametroSesion("Productos");
        traza("producto de sesion: "+htProductos);
        vProductosGrupo = (Vector) this.conectorParametroSesion( "productosGrupo" );
        vProductosGrupo = (vProductosGrupo==null) ? new Vector() : vProductosGrupo;
        Collection c = htProductos.values();
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

            idtop = vProductosGrupo.iterator();
            
            while( idtop.hasNext() && !existe.booleanValue() ){
              dtop = (DTOProducto)idtop.next();
              if( dtop != null && dtoProductoBuscado.getOid().equals( dtop.getOid()) && 
                  (!ConstantesPRE.OPERACION_BAJA.equals(dtop.getTipoOperacion()))){
                  
                  if (ConstantesPRE.OPERACION_ALTA.equals(dtop.getTipoOperacion())){
                    dtoProductoBuscado.setTipoOperacion(ConstantesPRE.OPERACION_ALTA);
                    dtop = dtoProductoBuscado;
                  } else if (ConstantesPRE.OPERACION_MODIFICACION.equals(dtop.getTipoOperacion())
                            ||dtop.getTipoOperacion()==null){
                    //si es null entonces viene de la BD
                    dtoProductoBuscado.setTipoOperacion(ConstantesPRE.OPERACION_MODIFICACION);
                    dtop = dtoProductoBuscado;
                  }
                  existe = Boolean.TRUE;
              }
            }
            if( !existe.booleanValue() ){
              dtoProductoBuscado.setTipoOperacion(ConstantesPRE.OPERACION_ALTA);
              vProductosGrupo.add( dtoProductoBuscado );
            }
          }
        } catch(Exception exc){exc.printStackTrace();}
      }
    }
        if( vProductosGrupo != null ){
            //generaRecordSetProductos( vProductosGrupo );
            conectorParametroSesion( "productosGrupo", vProductosGrupo );
        }
    }
  
    private void eliminarProducto() throws Exception {

        traza("ENTRA A eliminarProducto");
    
        elementosSeleccionadosProductosAsociados = 
        this.conectorParametro( "elementosSeleccionadosProductosAsociados" );

        Vector vec = this.parsearElementosLista(this.elementosSeleccionadosProductosAsociados);

        vProductosGrupo = (Vector) this.conectorParametroSesion("productosGrupo");

        traza("Vector \"productosGrupo\" de sesion (antes de hacer la eliminacion)");
        traza(vProductosGrupo);

        Enumeration enum = vec.elements();

        //Se eliminan los elementos
        while(enum.hasMoreElements()) {
            Long oid = (Long) enum.nextElement();
            Enumeration enum2 = vProductosGrupo.elements();
            while(enum2.hasMoreElements()) {
                DTOProducto dto = (DTOProducto)enum2.nextElement();
                if (dto.getOid().equals(oid)&&!ConstantesPRE.OPERACION_BAJA.equals(dto.getTipoOperacion())) {
                    //vProductosGrupo.remove(dto);
                    dto.setTipoOperacion(ConstantesPRE.OPERACION_BAJA);
                    break;
                }
            }
        }
        
        //generaRecordSetProductos( vProductosGrupo );

        traza("Vector \"productosGrupo\" de sesion (despues de hacer la eliminacion)");
        traza(vProductosGrupo);

        conectorParametroSesion("productosGrupo", vProductosGrupo);
    }

    private void guardarGrupo() throws Exception {
        String sOidIndicadorCuadre = null;
        String sFactorCuadre = null;

        Long lOidIndicadorCuadre = null;
        Integer iFactorCuadre	= null;
  
        dtoOferta = (DTOOferta) conectorParametroSesion("DTOOferta");
        vDtoOfertaGrupo = dtoOferta.getGrupo();


        traza("grupo actual"+conectorParametroSesion("grupoActual"));
        traza("sgrupo actual"+sGrupoActual);
        iGrupoActual = (conectorParametroSesion("grupoActual")==null?null:(Integer)conectorParametroSesion("grupoActual"));
        Enumeration enum = vDtoOfertaGrupo.elements();
        String valorCombo = conectorParametroLimpia("valorCombo", "", true);
        //String hFactorCuadre = conectorParametroLimpia("hFactorCuadre", "", true);
        String hFactorCuadre = conectorParametroNumero("hFactorCuadre",this.FORMATO_DEFAULT); 
        traza("hFactorCuadre: "+hFactorCuadre);

        //Se setea el Indicador de Cuadre y el Factor de Cuadre a los Grupos
        //con igual numero que el actual.
        while(enum.hasMoreElements()){
          dtoGrupo = (DTOGrupo)enum.nextElement();
		  traza("dtoGrupo.getNumeroGrupo()"+dtoGrupo.getNumeroGrupo());
          if(dtoGrupo.getNumeroGrupo().equals(iGrupoActual)){
            try{
              dtoGrupo.setOidIndicadorCuadre((valorCombo==""?null:Long.valueOf(valorCombo)));
            }catch(NumberFormatException ne){}
			if (dtoGrupo.getFactorCuadre()!=null&&(!dtoGrupo.getFactorCuadre().equals(hFactorCuadre==""?null:new BigDecimal(hFactorCuadre)))){
				dtoGrupo.setTipoOperacion(ConstantesPRE.OPERACION_MODIFICACION);
			}
            try{
              dtoGrupo.setFactorCuadre(hFactorCuadre==""?null:new BigDecimal(hFactorCuadre));
            }catch(NumberFormatException ne1){}
			break;
          }		
        }
        
        Vector vProduG = new Vector();
        vProduG = (conectorParametroSesion("productosGrupo")==null?null:(Vector)conectorParametroSesion("productosGrupo"));
        Enumeration enProduG = vProduG.elements();
        DTOProducto dtoProducto = null;
        Vector detallesOferta = new Vector();
        DTODetalleOferta dtoDetalleOferta = null;
        
        while(enProduG.hasMoreElements()){
          dtoDetalleOferta = new DTODetalleOferta();
          dtoProducto = (DTOProducto)enProduG.nextElement();
          if (dtoProducto!=null){
  		    //se setea esta opcion para que la parte servidora sepa que el grupo ha sido modificado
			dtoGrupo.setTipoOperacion(ConstantesPRE.OPERACION_MODIFICACION);

            dtoDetalleOferta.setOidSAP( dtoProducto.getOid() );
            dtoDetalleOferta.setCodigoSAP( dtoProducto.getCodigoSAP() );
            dtoDetalleOferta.setDescripcion( dtoProducto.getTextoBreve() );
            dtoDetalleOferta.setUnidadesEstimadas( dtoProducto.getUnidadesEstimadas() );
            dtoDetalleOferta.setOrigen( ConstantesPRE.MF );
            dtoDetalleOferta.setFactorRepeticion( dtoProducto.getFactorRepeticion() );
            dtoDetalleOferta.setDigitable( dtoProducto.getDigitable() );
            dtoDetalleOferta.setImpresionGP( dtoProducto.getImprimible() );
            dtoDetalleOferta.setOidFormaPago(dtoOferta.getOidFormaPago() );
            dtoDetalleOferta.setNumeroGrupo( iGrupoActual );
            dtoDetalleOferta.setProductoPrincipal(Boolean.FALSE);
            dtoDetalleOferta.setPrecioCatalogo( dtoProducto.getPrecioCatalogo() );
            dtoDetalleOferta.setPrecioPosicionamiento( dtoProducto.getPrecioPosicionamiento() );
            dtoDetalleOferta.setCosteEstandar( dtoProducto.getCosteEstandar() );
            dtoDetalleOferta.setVentaNetaEstimada( dtoProducto.getVentaNetaEstimada() );
            dtoDetalleOferta.setOidCatalogo( dtoProducto.getOidCatalogo() );
            dtoDetalleOferta.setPaginaCatalogo( dtoProducto.getPaginaCatalogo() );
            dtoDetalleOferta.setOidCondicionPromocion( dtoProducto.getOidCondicionPromocion() );
            dtoDetalleOferta.setOidTipoOferta( dtoProducto.getOidTipoOferta() );
            dtoDetalleOferta.setOidCicloVida( dtoProducto.getOidCicloVida() );
            dtoDetalleOferta.setAtributo1( dtoProducto.getAtributo1() );
            dtoDetalleOferta.setAtributo2( dtoProducto.getAtributo2() );
            dtoDetalleOferta.setAtributo3( dtoProducto.getAtributo3() );
            dtoDetalleOferta.setCentro( dtoProducto.getCentro() );
            dtoDetalleOferta.setPosicionPagina( dtoProducto.getPosicionPagina() );
            //enozigli 28/10/2005 club priviledges
            dtoDetalleOferta.setProgramaFidelizacion(dtoProducto.getProgramaFidelizacion());
            dtoDetalleOferta.setPuntajeFijo(dtoProducto.getPuntajeFijo());
            dtoDetalleOferta.setVariantes(dtoProducto.getVariantes());

			/*inicio enozigli COL-PRE-002*/
            dtoDetalleOferta.setRangosPrecios(dtoProducto.getRangosPrecios());
			/*fin enozigli COL-PRE-002*/
            
            // Agregado por ssantana, 17/10/2005, GCC-PRE-001
            traza("Traspaso el tipo de Operacion");
            dtoDetalleOferta.setTipoOperacion(dtoProducto.getTipoOperacion());
            // Fin Agregado por ssantana, 17/10/2005, GCC-PRE-001
                        
            Vector detallesOfertaMerge = dtoOferta.getDetalleOferta();
            Enumeration enumMerge = detallesOfertaMerge.elements();
            while (enumMerge.hasMoreElements()){
                DTODetalleOferta dtoMerge = (DTODetalleOferta)enumMerge.nextElement();
                if(dtoMerge.getNumeroGrupo().equals(iGrupoActual)&&
                   dtoMerge.getOidSAP().equals(dtoProducto.getOid())&&
                   !ConstantesPRE.OPERACION_BAJA.equals(dtoMerge.getTipoOperacion())){
                  dtoDetalleOferta.setCodigoVenta(dtoMerge.getCodigoVenta());
                  dtoDetalleOferta.setCodigoVentaGenerado(dtoMerge.getCodigoVentaGenerado());
                  dtoDetalleOferta.setLineaOferta(dtoMerge.getLineaOferta());
                  //cambio enozigli 06/03/2006 inc. 22718 
                  //dtoDetalleOferta.setMatrizFacturacionGenerada(dtoMerge.getMatrizFacturacionGenerada());
                  dtoDetalleOferta.setMatrizFacturacionGenerada(Boolean.FALSE);
                  //fin cambio enozigli 06/03/2006 inc. 22718 
                  dtoDetalleOferta.setOidDetalleOferta(dtoMerge.getOidDetalleOferta());
                  dtoDetalleOferta.setOidGrupo(dtoMerge.getOidGrupo());
                  dtoDetalleOferta.setPrecioUnitario(dtoMerge.getPrecioUnitario());
                  dtoDetalleOferta.setProductoPrincipal(dtoMerge.getProductoPrincipal());
                }
            }            
          }
          if (dtoDetalleOferta.getOidDetalleOferta()==null&&
              ConstantesPRE.OPERACION_BAJA.equals(dtoDetalleOferta.getTipoOperacion()))
             {//excluyo los que no existen en BD y son Baja
             } else {
               detallesOferta.add( dtoDetalleOferta );
             }
        }
        
        Vector vDetalleOAux = new Vector(); 
        Vector detallesOferta2 = dtoOferta.getDetalleOferta();
        Enumeration enum2 = detallesOferta2.elements();
        dtoDetalleOferta = new DTODetalleOferta();

        //De los dtoDetalleOfeta existentes, se agregan los que pertenezcan al grupo actual.
        while(enum2.hasMoreElements()){
            dtoDetalleOferta = (DTODetalleOferta)enum2.nextElement();
            if(!dtoDetalleOferta.getNumeroGrupo().equals(iGrupoActual)){              
                vDetalleOAux.addElement(dtoDetalleOferta);
            }		
        }
        traza("productos no del grupo "+vDetalleOAux);
        //Se agregan todos los DTODetalleOferta del vector detallesOferta, que fue
        //armado anteriormente a partir de productosGrupo.
        Enumeration enumDO = detallesOferta.elements();
        while(enumDO.hasMoreElements()){
            vDetalleOAux.addElement((DTODetalleOferta)enumDO.nextElement());		
        }
        traza("todos prod "+vDetalleOAux);
        dtoOferta.setDetalleOferta(vDetalleOAux);


        traza("- GUARDAR ----------------------------");
        traza("dtoOferta a guardar");
        traza(dtoOferta);
        traza("--------------------------------------");


        getRequest().getSession().removeAttribute("productosGrupo");
        getRequest().getSession().removeAttribute("hidNroGrupo");

        conectorParametroSesion("DTOOferta",dtoOferta);	

        conectorAction("LPModificarOferta");
        conectorActionParametro("accion","GrupoAnadido");	
    }

    private void cargarListaProductos() throws Exception{
    
        RecordSet rec_Lista = new RecordSet();
        String nombreListado = "listado1";
        int fila = 0;
        rec_Lista = llenarRecordSet(rec_Lista);
        traza("PRODUCTOS-------------->"+vProductosGrupo);
        if(vProductosGrupo.size() > 0){
            Enumeration en = vProductosGrupo.elements();            
            
            traza("antes del while");
            while (en.hasMoreElements()){
                dto_LP = (DTOProducto)en.nextElement();
                String sTipoOperacion = dto_LP.getTipoOperacion();
                traza("Prueba ssantana");
                if (!ConstantesPRE.OPERACION_BAJA.equals(sTipoOperacion)) {                   
                    rec_Lista.addRow(new Vector());
                    rec_Lista.setValueAt(dto_LP.getOid(),fila ,0);
                    rec_Lista.setValueAt(dto_LP.getCodigoSAP(),fila ,1);
                    //rec_Lista.setValueAt(dto_LP.getDescripcionSAP(),fila ,2);
                    rec_Lista.setValueAt(dto_LP.getTextoBreve(),fila ,2);
                    rec_Lista.setValueAt(dto_LP.getDescripcionTipoOferta(),fila ,3); 
                    rec_Lista.setValueAt(dto_LP.getDescripcionCicloVida(),fila,4);
                    rec_Lista.setValueAt(  (dto_LP.getFactorRepeticion()==null?"":dto_LP.getFactorRepeticion().toString() ) ,fila ,5);
                    rec_Lista.setValueAt( (dto_LP.getPrecioCatalogo()==null?"":UtilidadesBelcorp.formateaNumeroSICC(dto_LP.getPrecioCatalogo().toString(),this.FORMATO_DEFAULT,this)), fila ,6);
                    rec_Lista.setValueAt(dto_LP.getAtributo1(),fila ,7);
                    rec_Lista.setValueAt(dto_LP.getAtributo2(),fila ,8);
                    rec_Lista.setValueAt(dto_LP.getAtributo3(),fila ,9);
                    fila++;
                }
            }
        }else{
            rec_Lista.setRowCount(0);
        }
        DruidaConector con = UtilidadesBelcorp.generarConector("dtoSalida_ROWSET", rec_Lista, rec_Lista.getColumnIdentifiers());

        //traza("RecordSet a asignar a LISTAEDITABLE");
        //traza(con.getXML());
        
        asignarAtributo("VAR","casoDeUso","valor","modificar");
        asignar("LISTADOA", nombreListado, con,"dtoSalida_ROWSET");
    } 

    private RecordSet llenarRecordSet(RecordSet recordset){
        recordset.addColumn("Oid");
        recordset.addColumn("Código");
        recordset.addColumn("Descripción");
        recordset.addColumn("Tipo Oferta");
        recordset.addColumn("Ciclo vida");
        recordset.addColumn("Factor de Repeticion");
        recordset.addColumn("Precio unitario");
        recordset.addColumn("Atributo 1");
        recordset.addColumn("Atributo 2");
        recordset.addColumn("Atributo 3");
        
        // Agregado por ssantana, 
        return recordset;
    }

    private Vector parsearElementosLista( String lista ){
        Vector vec = new Vector();
        StringTokenizer st = new StringTokenizer(lista,"|");
        while (st.hasMoreElements()) {
            vec.addElement(new Long(st.nextToken()));
        }        
        return vec;
    }

   /* private void generaRecordSetProductos(Vector table)throws Exception{
        Hashtable h		= new Hashtable();
        DTOProducto dto = null;
        Enumeration e	= table.elements();
        Long oid 		= null;

        while( e.hasMoreElements() ){
            try{
                dto = (DTOProducto)e.nextElement();
                oid = dto.getOid();
                h.put( oid.toString(), dto );
            }catch(Exception exc){
            }
        }
        this.generaRecordSetProductos( h );
    }

    private void generaRecordSetProductos(Hashtable table)throws Exception{
        RecordSet recordSet = new RecordSet();

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
            if (dto.getOidTipoOferta() != null) recordSet.setValueAt(dto.getOidTipoOferta(), i, 18);             
            if (dto.getOidCicloVida() != null) recordSet.setValueAt(dto.getOidCicloVida(), i, 19);
            if (dto.getCentro() != null)  recordSet.setValueAt(dto.getCentro(), i, 20);
      
            i++;
        }
    }
*/
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

    private void asignarCombo( RecordSet opcionesCombo, DTOOferta dtoOferta, boolean cuadreOferta ) throws Exception {
        Element comboElement = null;
        DruidaConector dc = null;

        if( cuadreOferta ){
            comboElement = this.getElementFromRecordSet( opcionesCombo, "CLAVE",((dtoOferta.getNumeroGrupos()!=null) ? dtoOferta.getNumeroGrupos() : dtoOferta.getNumeroPaquetes()) );
        }else{
            comboElement = this.getElementFromRecordSet( opcionesCombo, "CLAVE" );
        }
        if( comboElement != null ){
            dc = new DruidaConector();
            dc.setXML( comboElement );
            this.asignar( "COMBO", "cbIndicadorCuadre", dc, "CLAVE" );
        }
    }

    private Element getElementFromRecordSet(RecordSet rsEntrada, String id, Integer tipoUsuario) throws Exception{
        int INDEX_INDICADOR_CUADRE_TIPO_ESTRATEGIA  = 0;
        int INDEX_VAL_I18N                          = 1;
        int INDEX_INDICADOR_CUADRE                  = 2;
        int INDEX_INDICADOR_MONOGRUPO               = 3;

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
            row = doc.createElement("ROW");
            row = (Element)rowset.appendChild(row);
            row.setAttribute("ID", (vFila.get(0) == null)?"":vFila.get(0).toString());
            indTipoUsuario = (BigDecimal) vFila.get( INDEX_INDICADOR_MONOGRUPO );

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
        return doc.getDocumentElement();
    }
    
    private void cargarPantalla() throws Exception{

        traza("############################################################");
        traza("ENTRO A cargarPantalla");

        asignarAtributo("VAR","casoDeUso","valor","modificar");
        //sGrupoActual = conectorParametroLimpia("hidNroGrupo", "", true);
        if ((sGrupoActual==null)||(sGrupoActual.equals(""))){
            sGrupoActual = (conectorParametroSesion("hidNroGrupo")!=null)?conectorParametroSesion("hidNroGrupo").toString():"";
        }
        
        iGrupoActual  = (sGrupoActual.equals("")) ? null : new Integer(sGrupoActual);
        // Recuperamos de sesion el DTOSCargarCriteriosDefinirOferta
        dtoSCargarCriteriosDefinirOferta = (this.conectorParametroSesion( "DTOSCargarCriteriosDefinirOferta" ) == "") ? null :(DTOSCargarCriteriosDefinirOferta) this.conectorParametroSesion( "DTOSCargarCriteriosDefinirOferta" );        

        traza("sAccion: " + sAccion);
        if( (!sAccion.equals("Eliminar productos"))&&(!sAccion.equals("Producto seleccionado")) ){
          
          armaVecProductosGrupo(dtoSCargarCriteriosDefinirOferta);
        }else{
          dtoOferta = (DTOOferta) this.conectorParametroSesion("DTOOferta");
        }
        
        iNumeroGrupos = dtoOferta.getNumeroGrupos();
        iNumeroPaquetes = dtoOferta.getNumeroPaquetes();

        if( iNumeroGrupos != null && iNumeroGrupos.intValue() > 0 ){
            this.asignarAtributo( "LABELC", "lblNGrupoX", "valor", sGrupoActual + " de " + iNumeroGrupos.toString() );
        } else {
            this.asignarAtributo( "LABELC", "lblNGrupoX", "valor", sGrupoActual + " de " + ((iNumeroPaquetes==null) ? null : iNumeroPaquetes.toString()) );
        }

        //Asignar tipo de grupos
        Vector vDtoGrupo = new Vector();
        vDtoGrupo = dtoOferta.getGrupo();
        Iterator itGrupo = vDtoGrupo.iterator();

        DTOGrupo grupo = new DTOGrupo(); 
        boolean flag = false;
        while (itGrupo.hasNext() && flag == false){
            grupo = (DTOGrupo) itGrupo.next();
            if (grupo.getNumeroGrupo().equals(iGrupoActual)){
                flag= true;
                break;
            }
        }

        if ((grupo.getIndicadorGrupo().booleanValue() == false)) {
                    this.asignarAtributo( "LABELC", "lblTipoGrupoX", "valor", "Paquete" );
					this.asignarAtributo( "VAR", "hDeshabilitarFactorCuadre", "valor", "S" );
                    paquete = new Boolean (true);
          if (grupo.getCondicionado().booleanValue() == true) {
                    this.asignarAtributo( "LABELC", "lblTipoGrupoX", "valor", "Grupo Condicionado" );
                    paquete = new Boolean (false);
                    grupoCondicionado = new Boolean(true);
          } else if (grupo.getCondicionante().booleanValue() == true) {
                    this.asignarAtributo( "LABELC", "lblTipoGrupoX", "valor", "Grupo Condicionante" );
                    paquete = new Boolean (true);
          }
        } else if ((grupo.getCondicionado().booleanValue() == false) &&
              (grupo.getCondicionante().booleanValue() == false)) {
                    this.asignarAtributo( "LABELC", "lblTipoGrupoX", "valor", "Grupo" );
                    paquete = new Boolean (false);
        } 
        /*
        if(grupo.getIndicadorGrupo().equals(Boolean.TRUE)){

        } else if (grupo.getIndicadorGrupo().equals(new Boolean (false) )){

        } else if(grupo.getCondicionado().equals(new Boolean (true))) {

        }else if(grupo.getCondicionante().equals(new Boolean (true))){

        }*/

        RecordSet registros = new RecordSet ();
        registros.setColumnIdentifiers(new Object [] {"Oid","Descripcion"});

        traza("dtoSCargarCriteriosDefinirOferta: ");
        traza(dtoSCargarCriteriosDefinirOferta);

        //if(dtoSCargarCriteriosDefinirOferta != null){

        if (  dtoSCargarCriteriosDefinirOferta != null && 
              dtoSCargarCriteriosDefinirOferta.getEstrategia() != null && 
              dtoSCargarCriteriosDefinirOferta.getEstrategia().getCuadreGrupos() != null &&
              dtoSCargarCriteriosDefinirOferta.getEstrategia().getCuadreGrupos().equals( Boolean.TRUE )){

            traza("CARGA cbIndicadorCuadre: entro por if");

            idBusIndCuadre = new MareBusinessID( "PREBuscarIndicadoresCuadrePorTipoEstrategia" );
			
            DTOOID dtoOid = new DTOOID();
            dtoOid.setOid(dtoSCargarCriteriosDefinirOferta.getEstrategia().getOid());
            dtoOid.setIpCliente( UtilidadesSession.getIdUsuario( this ) );
            dtoOid.setPrograma( UtilidadesSession.getFuncion( this ) );
            dtoOid.setOidIdioma(UtilidadesSession.getIdioma(this));
            dtoOid.setOidPais(UtilidadesSession.getPais(this));

            vParamEntrada.add( dtoOid );
            vParamEntrada.add( idBusIndCuadre );

            DruidaConector conector = this.conectar("ConectorBuscarEstrategias", vParamEntrada );
            //DruidaConector conector = this.conectar("ConectorCargarIndicadoresCuadrePorTipoEstrategia", vParamEntrada );
            dtoSalida = (DTOSalida) conector.objeto( "dtoSalida" );
            opcionesCombo = dtoSalida.getResultado();

            Vector filas = new Vector();
            int contadorFilas = opcionesCombo.getRowCount();
            
            if(dtoOferta.getNumeroGrupos().equals(new Integer (1))){
              for(int i = 0 ; i < contadorFilas; i++){
                filas = opcionesCombo.getRow(i);
                if (filas.elementAt(3).equals(new BigDecimal(1))){
                  registros.addRow(new Object [] {filas.elementAt(0),filas.elementAt(1)});
                }
              }
            }else{
              traza("grupoCondicionado"+grupoCondicionado);
              boolean grcond = (grupoCondicionado==null?false:grupoCondicionado.booleanValue());
              for(int i = 0 ; i < contadorFilas; i++){
                filas = opcionesCombo.getRow(i);
                if(filas.elementAt(3).equals(new BigDecimal(0))){
                  //incidencia 10247                 
                  if((!grcond)||
                    ((grcond)&&
                    (filas.elementAt(0)!= null)&&
                    (!(new Long(filas.elementAt(0).toString())).equals(new Long(ConstantesPRE.CUADRE_TOTAL_MONTOS))))){                      
                      registros.addRow(new Object [] {filas.elementAt(0),filas.elementAt(1)});
                    }
                }
              } 
            }

            DruidaConector dConector = UtilidadesBelcorp.generarConector("dtoSalida",registros, registros.getColumnIdentifiers());
                    
            this.asignar("COMBO","cbIndicadorCuadre",dConector,"dtoSalida");
        }else{

            traza("CARGA cbIndicadorCuadre: entro por else");
        


            RecordSet indicadoresCuadre = dtoSCargarCriteriosDefinirOferta.getIndicadoresCuadre();
          //  indicadoresCuadre.setColumnIdentifiers(new Object [] {"Oid","Descripcion"});
            DruidaConector dConector = UtilidadesBelcorp.generarConector("dtoSalida",indicadoresCuadre, indicadoresCuadre.getColumnIdentifiers());

            this.asignar("COMBO","cbIndicadorCuadre",dConector,"dtoSalida");

            
            this.asignarAtributo( "VAR", "hDeshabilitarCombo", "valor", "S" );            
            
        }
        Long oidIndCuadre = dtoOferta.getOidIndCuadre();
        Long oidIndCuadGrup = grupo.getOidIndicadorCuadre();        
        this.asignarAtributo( "VAR", "valorCombo", "valor", 
              (oidIndCuadre == null) ? ((oidIndCuadGrup == null) ? "" : oidIndCuadGrup.toString()) : oidIndCuadre.toString() );
        BigDecimal fcuad = grupo.getFactorCuadre();
        //this.asignarAtributo("CTEXTO", "txtFactorCuadre", "valor", ((fcuad!=null)?fcuad.toString():""));
		  this.asignarAtributo("CTEXTO","txtFactorCuadre","valor",(fcuad==null?"":UtilidadesBelcorp. formateaNumeroSICC (fcuad.toString(),this.FORMATO_DEFAULT , this))); 
        //}

        if (paquete.equals(new Boolean (true))){
            this.asignarAtributo("CTEXTO", "txtFactorCuadre", "disabled", "false");
        }

        traza("############################################################");
        
    } 

    private void armaVecProductosGrupo(DTOSCargarCriteriosDefinirOferta dtoccdo) 
                                                                      throws Exception {
        // Recupero se sesion el DTOOferta
        dtoOferta = (DTOOferta) this.conectorParametroSesion("DTOOferta");
        traza("AAA");
        vDetalleOferta = dtoOferta.getDetalleOferta(); // Vector de dto Detalle Oferta
        Iterator it = vDetalleOferta.iterator();
        while (it.hasNext()){
            traza("BBB");
            dtoDetOferta = (DTODetalleOferta) it.next(); // recupero un dto del Vector vDetalleOferta
            String sTipoOperacionDTO = dtoDetOferta.getTipoOperacion();
            Integer iNroGrupoDTO = dtoDetOferta.getNumeroGrupo();
            traza("CCC");
            if( iNroGrupoDTO.equals(iGrupoActual) && 
                (!ConstantesPRE.OPERACION_BAJA.equals(sTipoOperacionDTO)) ) {
                   traza("DDD");
                   dtoProd = new DTOProducto();
                   // Modificado por SICC20070316 - Rafael Romero - 20/07/2007
                    if(casoDeUso.equals("consultar")){
                        dtoProd.setOid(dtoDetOferta.getOidDetalleOferta());
                    }else{
                        dtoProd.setOid(dtoDetOferta.getOidSAP());
                    }
                   // fin modificado SICC20070316
                   dtoProd.setCodigoSAP(dtoDetOferta.getCodigoSAP());
                   dtoProd.setDescripcionSAP(dtoDetOferta.getDescripcion());
                   dtoProd.setTextoBreve(dtoDetOferta.getDescripcion());
                   dtoProd.setAtributo1(dtoDetOferta.getAtributo1());
                   dtoProd.setAtributo2(dtoDetOferta.getAtributo2());
                   dtoProd.setAtributo3(dtoDetOferta.getAtributo3());
                   dtoProd.setPrecioCatalogo(dtoDetOferta.getPrecioCatalogo());
                   dtoProd.setPaginaCatalogo(dtoDetOferta.getPaginaCatalogo());
                   dtoProd.setPosicionPagina(dtoDetOferta.getPosicionPagina());
                   dtoProd.setDigitable(dtoDetOferta.getDigitable());
                   dtoProd.setImprimible(dtoDetOferta.getImpresionGP());
                   dtoProd.setFactorRepeticion(dtoDetOferta.getFactorRepeticion());
                   dtoProd.setUnidadesEstimadas(dtoDetOferta.getUnidadesEstimadas());
                   dtoProd.setVentaNetaEstimada(dtoDetOferta.getVentaNetaEstimada());
                   dtoProd.setPrecioPosicionamiento(dtoDetOferta.getPrecioPosicionamiento());
                   dtoProd.setCosteEstandar(dtoDetOferta.getCosteEstandar());
                   dtoProd.setOidCatalogo(dtoDetOferta.getOidCatalogo());
                   dtoProd.setOidCondicionPromocion(dtoDetOferta.getOidCondicionPromocion());
                   dtoProd.setOidTipoOferta(dtoDetOferta.getOidTipoOferta());
                   dtoProd.setOidCicloVida(dtoDetOferta.getOidCicloVida());
                   dtoProd.setCentro(dtoDetOferta.getCentro());
                   //seteo el tipo de operacion para saber en que venia
                   dtoProd.setTipoOperacion(dtoDetOferta.getTipoOperacion());

				   /*inicio enozigli COL-PRE-002*/
                   dtoProd.setRangosPrecios(dtoDetOferta.getRangosPrecios());
				   /*fin enozigli COL-PRE-002*/
                   
                   traza("EEE");
                   if (dtoccdo!=null){
                     RecordSet rs = dtoccdo.getTiposOferta();
                     if (dtoDetOferta.getOidTipoOferta()!=null && !rs.esVacio()) {                
                       for(int j=0; j<rs.getRowCount(); j++){  
                           Long tipoOfert = rs.getValueAt(j,0)==null ? null : new Long(rs.getValueAt(j,0).toString());
                           if(tipoOfert.equals(dtoDetOferta.getOidTipoOferta()) ){
                               if ((rs.getValueAt(j,1))!=null)
                                 dtoProd.setDescripcionTipoOferta((String)rs.getValueAt(j,1));
                               break;
                           }
                       }              
                     }
                     rs = dtoccdo.getCiclosVida();
                     if (dtoDetOferta.getOidCicloVida()!=null && !rs.esVacio()) {                
                       for(int j=0; j<rs.getRowCount(); j++){  
                           Long civi = rs.getValueAt(j,0)==null ? null : new Long(rs.getValueAt(j,0).toString());
                           if(civi.equals(dtoDetOferta.getOidCicloVida()) ){
                               if ((rs.getValueAt(j,1))!=null)
                                 dtoProd.setDescripcionCicloVida((String)rs.getValueAt(j,1));
                               break;
                           }
                       }              
                     }                  
                   }
                   traza("FFF");   
                   // agrego el dto del producto al vector
                   vProductosGrupo.addElement(dtoProd);		
            }
            traza("ZZZZ");
        }
        this.conectorParametroSesion( "productosGrupo", vProductosGrupo );
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

    private DruidaConector generarConectorListEdit(String rowsetID, RecordSet datos, Vector columns) throws DOMException,Exception{
        StringBuffer salida = new StringBuffer();
        int sizeColums = datos.getColumnCount();
        int sizeRows = datos.getRowCount();

        if ( columns == null ){
            columns = new Vector();
        }
        Vector columsDesc = datos.getColumnIdentifiers();		
		
        DruidaConector conectorValoresPosibles = new DruidaConector();				
        XMLDocument xmlDoc  = new XMLDocument();
        Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");			
        Element e_rows = docDestino.createElement("ROWSET");
        e_rows.setAttribute("ID",rowsetID);
        docDestino.getDocumentElement().appendChild(e_rows);
		
        for (int i=0; i < sizeRows; i++){
            Element e_row = docDestino.createElement("ROW");
            e_rows.appendChild(e_row);

            for (int j=0; j < sizeColums; j++){
                if ( columns.contains(columsDesc.elementAt(j)) ){
                    Element e_campo0   = docDestino.createElement("CAMPO");
                    e_campo0.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
                    e_campo0.setAttribute("TIPO","OBJECTO");
                    e_campo0.setAttribute("LONGITUD","50");
                    Text txt = docDestino.createTextNode("");
                    e_campo0.appendChild(txt);
                    e_row.appendChild(e_campo0);
				
                    //------------------------------------------------------------
                    Element e_campo2   = docDestino.createElement("CAMPO");
                    e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
                    e_campo2.setAttribute("TIPO","OBJECTO");
                    e_campo2.setAttribute("LONGITUD","50");
                    Text txt0 = docDestino.createTextNode((datos.getValueAt(i,j)==null?"":datos.getValueAt(i,j).toString()));
                    e_campo2.appendChild(txt0);
                    e_row.appendChild(e_campo2);
                }
            }
        }
        return conectorValoresPosibles;
    }
    
    
  /**
   * @author: ssantana, 6/10/2005
   * @throws java.lang.Exception
   */
    private void modificarProducto() throws Exception {
       traza("LPModificarGrupo.modificarProducto()");
  
       Hashtable hshProductos = new Hashtable();
       DTOProducto dtoProdu = null;
       Long oidProdu = null;
       Vector vDTOs = null;
       Vector vOidProductos = null;
       Vector vOidsSeleccionados = null;
       
       Vector vProductosSession = (Vector) 
                                      this.conectorParametroSesion("productosGrupo");
       
       /*String hidListaEditable = this.conectorParametro("hidListaEditable");
       traza("hidListaEditable: " + hidListaEditable);*/
       String sCadenaCodigos = this.conectorParametro("hidCodSeleccionadosLE");
       traza("hidCodSeleccionadosLE: " + sCadenaCodigos);
       
       // Obtengo el Vector con los Códigos ocultos (oids) de los elementos
       // seleccionados en la lista. 
       vOidsSeleccionados = this.parseaCodigosSeleccionados(sCadenaCodigos);
       
       traza("Pongo todos los DTOs en el Hashtable y armo Vector oidsProducto.");
      
       // La idea es buscar en vProductosSession aquellos DTOProducto que 
       // coinciden con los Oid de Productos seleccionados. Cuando se encuentre 
       // un match, se guarda ese DTOProducto en el hashtable "hshProductos".
       // Se parte del hecho, que el DTOProducto recuperado posee TODOS los valores
       // que se necesitan. 
       vOidProductos = new Vector(); 
       int cantOidsSelccionados = vOidsSeleccionados.size();
       int cantProdSesion = vProductosSession.size();
       boolean bMatch = false;
       for (int i = 0; i < cantOidsSelccionados; i++) {
          // Recorro el Vector de Oids seleccionados. 
          bMatch = false;
          Long oidProdSeleccionado = (Long) vOidsSeleccionados.get(i);
          traza("Oid a Procesar: " + oidProdSeleccionado);
          for ( int j = 0; (j < cantProdSesion) && (!bMatch); j++ ) {
             // Recorro el Vector
             DTOProducto dtoProduSesion = (DTOProducto) vProductosSession.get(j);
             Long oidProdSesion = dtoProduSesion.getOid();
             traza(" --- Matcheando con " + oidProdSesion);
             if (oidProdSesion.equals(oidProdSeleccionado) ) {
                // Si coinciden, meto el DTOProducto  en la hashtable
                // "hshProductos" con el oid de Producto, como Key. 
                traza(" --- Match en " + oidProdSesion);
                bMatch = true;
                hshProductos.put(oidProdSeleccionado, dtoProduSesion);
                vOidProductos.add(oidProdSeleccionado);
             }
          }
       }
       traza("Done!");
       
       // Pongo el Hashtable y el Vector en sesión
       traza("Meto todo en sesión");
       this.conectorParametroSesion("Productos", hshProductos);
       this.conectorParametroSesion("oidProductos", vOidProductos);
       
       // Llamo a LPDatosProducto con tipoOperacion == "modificacion y accion = ""
       this.conectorAction("LPDatosProducto");
       this.conectorActionParametro("accion", "");
       this.conectorActionParametro( "multiseleccion", "true" );
       this.conectorActionParametro( "mostrarValoresAdicionales", "true" );       
       this.conectorActionParametro("lpRetorno", "LPModificarGrupo");
       this.conectorActionParametro("tipoOperacion", "modificacion");
    }
  
    
    
    
  /**
   * @author: ssantana, 12/10/2005, GCC-PRE-001
   * @return Vector
   * @param String sCadenaCodigo
   */
    private Vector parseaCodigosSeleccionados(String sCadenaCodigos) 
                                                              throws Exception{
      /*
       * Recibe una cadena del formato [codigo1,codigo2,codigo3,...]
       * que representa los campos ocultos seleccionados en la ListaEditable. 
       * Retorna un Vector donde cada elemento es un código, en String.
       */
      Vector vRetorno = new Vector(); 
      
      // Quito los corchetes.
      sCadenaCodigos = sCadenaCodigos.substring(0, sCadenaCodigos.length()-1);
      sCadenaCodigos = sCadenaCodigos.substring(1, sCadenaCodigos.length());
      traza("sCadenaCodigos al momento: " + sCadenaCodigos);
      
      // Pueblo el Vector.
      StringTokenizer sTokCodigos = new StringTokenizer(sCadenaCodigos, ",");
      while (sTokCodigos.hasMoreTokens()) {
         String sCodigo = sTokCodigos.nextToken();
         vRetorno.add(Long.valueOf(sCodigo));
      }
      
      return vRetorno;
    }

    // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
    private void agregarMenuComplementario() throws Exception{
        if(conectorParametroSesion("descripcionPeriodo")!=null){
            DOMXPath xform = new DOMXPath("//PAGINA/FORMULARIO[VAR[@nombre='conectorAction']]");
            Element formulario = (Element)xform.selectSingleNode(getXML());
            if(formulario != null)
            {
                DOMXPath xpath = new DOMXPath("//VAR[@nombre='SICC_CUSTOM_TITTLE']");
                Node var = (Node)xpath.selectSingleNode(getXML());
                if(var == null)
                {
                    var = getXML().createElement("VAR");
                    ((Element)var).setAttribute("nombre", "SICC_CUSTOM_TITTLE");
                }
                ((Element)var).setAttribute("valor", (String)conectorParametroSesion("descripcionPeriodo"));
                
                formulario.appendChild(var);
            }
        }
    }
    // Fin agregado SICC20070322

} // Cierro Clase
