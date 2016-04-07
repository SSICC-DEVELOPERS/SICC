//import LPSICCBase;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.mav.DTOAgrupacionEnvios;
import es.indra.sicc.dtos.mav.DTOCargaPaginaRegistrosMAV;
import es.indra.sicc.dtos.mav.DTOECBRegistrosMAV;
import es.indra.sicc.dtos.mav.DTOEnvioMAV;
import es.indra.sicc.dtos.mav.DTORegistrosMAV;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import java.text.SimpleDateFormat;

/************************************************************/
public class LPMantenimientoRegistrosMAV extends LPSICCBase 
{
  public String casoUso = null;
  public String accion = null;

// -----------------------------------------------------------------------------------
  public LPMantenimientoRegistrosMAV()
  {
  }

// -----------------------------------------------------------------------------------
  public void inicio()
  {
    
  }

// -----------------------------------------------------------------------------------
  public void ejecucion() throws Exception
  {
    setTrazaFichero();

    try 
    {    
        accion = (String) this.conectorParametro("accion");
        casoUso = (String) this.conectorParametro("casoUso");
        traza("-- accion: " + accion);
        traza("-- casoUso: " + casoUso);
        
        if ( accion.equals("buscar") ) {
          this.cargarPaginaBuscar();
        }

        if (accion.equals("detalle") ) {
          this.cargarPaginaDetalle();
        }

        if (accion.equals("buscarRegistros") )
          this.buscarRegistros();

        if (accion.equals("guardar") )
          this.guardar();
    
      
    } catch (Exception ex)
    {
      traza("ERROR");
      ex.printStackTrace();
      this.lanzarPaginaError(ex);
    }
    
  }

// -----------------------------------------------------------------------------------
  private void cargarPaginaBuscar() throws Exception
  {
    traza(" ------ cargarPaginaBuscar ----------");
    String casoUso = (String) this.conectorParametro("casoUso");
    
    this.pagina("contenido_registros_material_apoyo_ventas_buscar");
    this.getConfiguracionMenu("LPMantenimientoRegistrosMAV", "buscar");
    this.seteaTitulo(casoUso);    
    this.getFormatosValidaciones();  // --- Para validaciones varias

    this.cargaDatosPantalla();
    
  }

// -----------------------------------------------------------------------------------
  private void cargarPaginaDetalle() throws Exception
  {
      traza(" ---- cargarPaginaDetalle ---- ");

      DTOAgrupacionEnvios dtoAgrupacion = new DTOAgrupacionEnvios();

      String criterio = (String) this.conectorParametro("criterio");
      String reentrando = null;

      traza("Criterio: " + criterio);

      reentrando = this.conectorParametro("reentrando");
      if ( reentrando.equals("N") )  // Carga todo de la base.
      {
          traza("Se toma de BD");
          Timestamp timeFechaEntrega = null;
          String tipoDespacho = null;
          String codCliente = null;
          String fechaEntrega = null;
          String oidTipoCliente = null;
          String casoUso = null;      
          // Toma los datos de la pantalla.
          tipoDespacho = (String) this.conectorParametro("oidTipoDespacho");
          codCliente = (String) this.conectorParametro("codCliente");
          fechaEntrega = (String) this.conectorParametro("fechaEntrega");
          oidTipoCliente = (String) this.conectorParametro("oidTipoCliente");
          casoUso = (String) this.conectorParametro("casoUso");
      
          this.pagina("contenido_registros_material_apoyo_ventas_productos_buscar");
          this.getConfiguracionMenu("LPMantenimientoRegistrosMAV", "detalle");
          this.seteaTitulo(casoUso);          
          this.getFormatosValidaciones();
          this.asignarAtributo("VAR", "casoUso", "valor", casoUso);

          MareBusinessID bussID = new MareBusinessID("MAVDetalleAgrupacionEnviosMAV");
          Vector params = new Vector();


          if (tipoDespacho != null)
            dtoAgrupacion.setOidTipoDespacho( new Long(tipoDespacho) );

          if (codCliente != null)
            dtoAgrupacion.setCodigoCliente(codCliente);


          if ( fechaEntrega != null && !fechaEntrega.equals("") ) 
          {
            //  Se presupone que La fecha viene de la pantalla en formato de sesión. 
            traza("Fecha de Entrega: " + fechaEntrega);
            String formatoFecha = UtilidadesSession.getFormatoFecha(this);
            formatoFecha = formatoFecha.replace('m', 'M');
            SimpleDateFormat formatoFechaUsuario = new SimpleDateFormat(formatoFecha);

            java.util.Date fechaTemp = formatoFechaUsuario.parse(fechaEntrega); // Obtengo un date
            timeFechaEntrega = new Timestamp( fechaTemp.getTime() );  

            dtoAgrupacion.setFechaEntrega(timeFechaEntrega);
          }

          if ( oidTipoCliente != null )
            dtoAgrupacion.setOidTipoCliente( new Long(oidTipoCliente) );

          dtoAgrupacion.setOidIdioma(UtilidadesSession.getIdioma(this));
          dtoAgrupacion.setOidPais(UtilidadesSession.getPais(this));
      
          params.add(dtoAgrupacion);   
          params.add(bussID);

          DruidaConector con = this.conectar("ConectorDetalleAgrupacionEnviosMAV", params);
          traza("Salio de conectar");
          DTOSalida dtoSalida = (DTOSalida) con.objeto("dtoSalida");

          RecordSet r = dtoSalida.getResultado();
          traza("dtoSalida: " + dtoSalida);
          DruidaConector conLista = null;

          int numFilas = r.getRowCount();
          if (r != null && numFilas > 0)
          {
            RecordSet rNuevo = new RecordSet();
            Vector vCols = new Vector();
            vCols.add("Oculto");
            vCols.add("CodProd");
            vCols.add("DescProd");
            vCols.add("NumUnidades");
            vCols.add("EstadiEnvio");
            vCols.add("EstadoAutorizacion");
            vCols.add("Modificado");
            rNuevo.setColumnIdentifiers(vCols);
            traza("Antes de bucle");
            rNuevo.setRowCount(numFilas);
            for (int i = 0; i < numFilas; i++)
            {
              rNuevo.setValueAt(r.getValueAt(i,0), i, 0);
              rNuevo.setValueAt(r.getValueAt(i,1), i, 1);
              rNuevo.setValueAt(r.getValueAt(i,2), i, 2);
              rNuevo.setValueAt(r.getValueAt(i,3), i, 3);              
              rNuevo.setValueAt(r.getValueAt(i,4), i, 4);                            
              rNuevo.setValueAt(r.getValueAt(i,5), i, 5);                                          
              rNuevo.setValueAt("N", i, 6);
            }
            
            traza("r Modificado: " + rNuevo.toString());  
            conLista = UtilidadesBelcorp.generarConector("conectorLista", rNuevo, rNuevo.getColumnIdentifiers());
            this.asignar("LISTADOA","listado2", conLista, "conectorLista");
          }
      } else if (reentrando.equals("S") ) // Carga de la variable de formulario.
      {
          traza("Se carga lista de variable formulario");
          //String sLista = this.conectorParametro("fila");
          String sLista = this.conectorParametro("listaToSet");          
          String casoUso = this.conectorParametro("casoUso");

          this.pagina("contenido_registros_material_apoyo_ventas_productos_buscar");
          this.getConfiguracionMenu("LPMantenimientoRegistrosMAV", "detalle");
          this.seteaTitulo(casoUso);                    
          this.getFormatosValidaciones();
          this.asignarAtributo("VAR", "casoUso", "valor", casoUso);

          RecordSet rNuevo = new RecordSet();
          Vector vCols = new Vector();
          vCols.add("Oculto");
          vCols.add("CodProd");
          vCols.add("DescProd");
          vCols.add("NumUnidades");
          vCols.add("EstadoEnvio");
          vCols.add("EstadoAutorizacion");
          vCols.add("Modificado");
          rNuevo.setColumnIdentifiers(vCols);
          rNuevo.setRowCount(0);
          traza("Antes de bucle");
          
          if (sLista != "")
          {
            StringTokenizer sTok = new StringTokenizer(sLista, ",");
            int contadorFilas = 0; 
            ArrayList aList = new ArrayList();

            while (sTok.hasMoreTokens())
            {
              aList.add(sTok.nextToken());
              contadorFilas++;
              if (contadorFilas == 7)
              {
                traza("1");
                rNuevo.setRowCount(rNuevo.getRowCount()+1);
                traza("2");                
                int filaActual = rNuevo.getRowCount()-1;
                traza("3");                
                for (int j = 0; j < aList.size(); j++)
                  rNuevo.setValueAt((String)aList.get(j), filaActual, j);
                traza("4");                  
                contadorFilas = 0;
                aList = new ArrayList();
              }
            }
            traza("RNuevo: " + rNuevo);
            // Genera la lista
            // ***************
            traza("Genera Lista");
            DruidaConector conLista = UtilidadesBelcorp.generarConector("conLista", rNuevo, rNuevo.getColumnIdentifiers() );
            this.asignar("LISTADOA","listado2", conLista, "conLista");            
          }
          
      }
      
      return;
  }

// -----------------------------------------------------------------------------------
  private void buscarRegistros() throws Exception
  {
    String selMarca = (String) this.conectorParametro("hidSelMarca");
    String selCanal = (String) this.conectorParametro("hidSelCanal");    
    String selSubg = (String) this.conectorParametro("hidSelSubg");        
    String selRegion = (String) this.conectorParametro("hidSelRegion");            
    String selZona = (String) this.conectorParametro("hidSelZona");                
    String selActividad = (String) this.conectorParametro("hidSelActividad");
    String selPeriodo = (String) this.conectorParametro("hidSelPeriodo");
    String selEstadoEnvio = (String) this.conectorParametro("hidSelEstadoEnvio"); // "P" o "E"
    String selEstadoAutorizacion = (String) this.conectorParametro("hidSelEstadoAutorizacion"); // 1,2,3,4,5
    String selCriterio = (String) this.conectorParametro("hidSelCriterio");
    String selTipoCliente = (String) this.conectorParametro("hidSelTipoCliente");
    String selTipoDespacho = (String) this.conectorParametro("hidSelTipoDespacho");
    String contenidoCbProductos = (String) this.conectorParametro("hidContenidoProductos");
    String selProducto = (String) this.conectorParametro("hidSelTipoProductos");  
    String casoUso = (String) this.conectorParametro("casoUso");
    

    this.pagina("contenido_registros_material_apoyo_ventas_buscar");
    this.getConfiguracionMenu("LPMantenimientoRegistrosMAV", "buscarRegistros");
    this.seteaTitulo(casoUso);        
    this.getFormatosValidaciones();  // --- Para validaciones varias
    this.cargaDatosPantalla();

    // Setea indicador de que se está reentrando
    this.asignarAtributo("VAR", "hidReentrandoBusqueda", "valor", "S");
    
    if (selMarca != null)
      this.asignarAtributo("VAR", "hidSelMarca", "valor", selMarca);
      
    if (selCanal != null)
      this.asignarAtributo("VAR", "hidSelCanal", "valor", selCanal);  
      
    if (selSubg != null)
      this.asignarAtributo("VAR", "hidSelSubg", "valor", selSubg);         

    if (selRegion != null)
      this.asignarAtributo("VAR", "hidSelRegion", "valor", selRegion);             
      
    if ( selZona != null)  
      this.asignarAtributo("VAR", "hidSelZona", "valor", selZona);    

    if ( selActividad != null)
      this.asignarAtributo("VAR", "hidSelActividad", "valor", selActividad);        

    if ( selPeriodo != null)
      this.asignarAtributo("VAR", "hidSelPeriodo", "valor", selPeriodo);            

    if ( selEstadoEnvio != null)
      this.asignarAtributo("VAR", "hidSelEstadoEnvio", "valor", selEstadoEnvio);                

    if ( selEstadoAutorizacion != null)
      this.asignarAtributo("VAR", "hidSelEstadoAutorizacion", "valor", selEstadoAutorizacion);             

    traza("selCriterio: "  +selCriterio);
    if (  selCriterio != null  )
      this.asignarAtributo("VAR", "hidSelCriterio", "valor", selCriterio);

    if ( selTipoCliente != null )
      this.asignarAtributo("VAR", "hidSelTipoCliente", "valor", selTipoCliente);   

    if ( selTipoDespacho != null )
      this.asignarAtributo("VAR", "hidSelTipoDespacho", "valor", selTipoDespacho); 

    if ( contenidoCbProductos != null)
      this.asignarAtributo("VAR", "hidContenidoProductos", "valor", contenidoCbProductos);

    if ( selProducto != null )
      this.asignarAtributo("VAR", "hidSelTipoProductos", "valor", selProducto);     

    this.asignarAtributo("VAR", "casoUso", "valor", casoUso);     


    DTOECBRegistrosMAV dtoBusqueda = new DTOECBRegistrosMAV();

    Long marca = null;
    traza("--- Marca: " + selMarca);
    if (selMarca != null && !selMarca.equals("") )
      marca = new Long(selMarca);
    dtoBusqueda.setOidMarca(marca);

    Long canal = null;
    traza("--- Canal: " + selCanal);
    if (selCanal != null && !selCanal.equals("") )
      canal = new Long(selCanal);
    dtoBusqueda.setOidCanal(canal);

    ArrayList arraySubg = null;
    traza("--- Subgerencia: " + selSubg);    
    if (selSubg != null && !selSubg.equals("") )
      arraySubg = parseaCampos(selSubg);
    dtoBusqueda.setSubgerencia(arraySubg);      

    ArrayList arrayRegiones = null;
    traza("--- Region: " + selRegion);    
    if (selRegion != null && !selRegion.equals("") )
      arrayRegiones = parseaCampos(selRegion);
    dtoBusqueda.setRegion(arrayRegiones);       
    
    ArrayList arrayZona = null;
    traza("--- Zona: " + selZona);    
    if (selZona != null && !selZona.equals("") )
      arrayZona = parseaCampos(selZona);
    dtoBusqueda.setZona(arrayZona);      

    Long actividad = null;
    traza("--- Actividad: " + selActividad);
    if (selActividad != null && !selActividad.equals("") )
      actividad = new Long(selActividad);
    dtoBusqueda.setOidActividadMAV(actividad);    

    Long periodo = null;
    traza("--- Periodo: " + selPeriodo);
    if (selPeriodo != null && !selPeriodo.equals("") )
      periodo = new Long(selPeriodo);
    dtoBusqueda.setOidPeriodo(periodo);       

    Character estadoEnvio = null;
    traza("--- Estdo Envio: " + selEstadoEnvio);
    if (selEstadoEnvio != null && !selEstadoEnvio.equals("") )
      estadoEnvio = new Character(selEstadoEnvio.charAt(0));
    dtoBusqueda.setEstadoEnvio(estadoEnvio);     

    Long estadoAutorizacion = null;
    traza("--- Estado Autorizacion: " + selEstadoAutorizacion);
    if (selEstadoAutorizacion != null && !selEstadoAutorizacion.equals("") )
      estadoAutorizacion = new Long(selEstadoAutorizacion);
    dtoBusqueda.setOidTipoEstadoProceso(estadoAutorizacion);    

    dtoBusqueda.setOidPais(UtilidadesSession.getPais(this));
    dtoBusqueda.setOidIdioma(UtilidadesSession.getIdioma(this));    
    dtoBusqueda.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
    dtoBusqueda.setPrograma(UtilidadesSession.getFuncion(this));

    DruidaConector con = null;
    if ( selCriterio.equals("Despacho") )
    {
      ArrayList arrayDespacho = null;
      if(selTipoDespacho != null && !selTipoDespacho.equals("") )
        arrayDespacho = this.parseaCampos(selTipoDespacho);
      dtoBusqueda.setTipoDespacho( arrayDespacho );

      MareBusinessID bussId = new MareBusinessID("MAVBuscarEnviosMAVATD");
      Vector params = new Vector();
      params.add(dtoBusqueda);
      params.add(bussId);

      traza("Conectando Despacho...");
      con = this.conectar("ConectorBuscarEnviosMAVATD", params);
      traza("Finalizando Conectar Despacho...");

      DTOSalida dtoSalida = (DTOSalida) con.objeto("dtoSalida");
      RecordSet r = dtoSalida.getResultado();

      // Formatea la fecha
      for (int i = 0; i < r.getRowCount(); i++)
      {
         if (r.getValueAt(i,5) != null)
         {
           String fecha = ((java.sql.Date) r.getValueAt(i,5)).toString();
           String fechaFormateada = formateaFechas(fecha);
           r.setValueAt(fechaFormateada, i, 5);
           // Agregado 3/2/2005 por ssantana. Tambien formatea columna oculta (la 7)
           // que posee la misma fecha.
           r.setValueAt(fechaFormateada, i, 7);
         } else // Si la fecha es null, devuelve ""
         {
           r.setValueAt("", i, 5);           
           r.setValueAt("", i, 7);                      
         }
      }
      DruidaConector conDespacho = UtilidadesBelcorp.generarConector("despacho", r, r.getColumnIdentifiers() );
      this.asignar("LISTADOA", "listado3", conDespacho, "despacho");    

    }

    if ( selCriterio.equals("Cliente") )
    {
      ArrayList arrayClientes = null;
      if (selTipoCliente != null && !selTipoCliente.equals("") ) 
        arrayClientes = this.parseaCampos(selTipoCliente);
      dtoBusqueda.setTipoCliente( arrayClientes );

      MareBusinessID bussId = new MareBusinessID("MAVBuscarEnviosMAVATC");
      Vector params = new Vector();
      params.add(dtoBusqueda);
      params.add(bussId);

      traza("Conectando Cliente...");
      con = this.conectar("ConectorBuscarEnviosMAVATC", params);
      traza("Finalizando Conectar Cliente...");      

      DTOSalida dtoSalida = (DTOSalida) con.objeto("dtoSalida");
      RecordSet r = dtoSalida.getResultado();

      // Formatea la fecha
      for (int i = 0; i < r.getRowCount(); i++)
      {
         if (r.getValueAt(i,5) != null){
           String fecha = ((java.sql.Date) r.getValueAt(i,5)).toString();
           String fechaFormateada = formateaFechas(fecha);
           // Agregado 3/2/2005 por ssantana. Tambien formatea columna oculta (la 7)
           // que posee la misma fecha.
           r.setValueAt(fechaFormateada, i, 5);
           r.setValueAt(fechaFormateada, i, 7);           
         } else {
           r.setValueAt("",i,5);
           r.setValueAt("",i,7);           
         }
         
      } 
      DruidaConector conCliente = UtilidadesBelcorp.generarConector("cliente", r, r.getColumnIdentifiers() );
      this.asignar("LISTADOA", "listado1", conCliente, "cliente");          
    }

    if ( selCriterio.equals("Producto") )
    {
      ArrayList arrayProductos = null;
      if ( selProducto != null && !selProducto.equals("") ) 
        arrayProductos = this.parseaCampos(selProducto);
      dtoBusqueda.setProductos(arrayProductos);

      MareBusinessID bussId = new MareBusinessID("MAVBuscarEnviosMAVProductos");
      Vector params = new Vector();
      params.add(dtoBusqueda);
      params.add(bussId);

      traza("Conectando Producto...");
      con = this.conectar("ConectorBuscarEnviosMAVATC", params);
      traza("Finalizando Conectar Producto...");        

      DTOSalida dtoSalida = (DTOSalida) con.objeto("dtoSalida");
      RecordSet r = dtoSalida.getResultado();
      
      // Formatea la fecha
      for (int i = 0; i < r.getRowCount(); i++)
      {
        if (r.getValueAt(i,9) != null){
          String fecha = ((java.sql.Date) r.getValueAt(i,9)).toString();      
          String fechaFormateada = this.formateaFechas(fecha);
          r.setValueAt(fechaFormateada, i, 9);
        } else
        {
          r.setValueAt("",i,9);
        }
        
      }
      DruidaConector conProductos = UtilidadesBelcorp.generarConector("productos", r, r.getColumnIdentifiers() );
      this.asignar("LISTADOA", "listado4", conProductos, "productos");                
    }

  }

// -----------------------------------------------------------------------------------
  private ArrayList parseaCampos(String cadena)
  {
    ArrayList aList = new ArrayList();

    StringTokenizer tok = new StringTokenizer(cadena, ",");

    while ( tok.hasMoreTokens()  )
    {
      String elemento = tok.nextToken();
      aList.add(new Long(elemento));
    }

    return aList;

   }

// -----------------------------------------------------------------------------------
  private void cargaDatosPantalla() throws Exception
  {
      Long pais = UtilidadesSession.getPais(this);
      String descPais = UtilidadesSession.getDescripcionPais(this);
      Long idioma = UtilidadesSession.getIdioma(this);

      this.asignarAtributo("LABELC", "lbldtPais", "valor", descPais);
      this.asignarAtributo("VAR", "oidPais", "valor", pais.toString() );
      this.asignarAtributo("VAR", "oidIdioma", "valor", idioma.toString() );    
    
      this.asignarAtributo("VAR", "casoUso", "valor", casoUso);
    
      DTOBelcorp dtoBelcorp = new DTOBelcorp();
      dtoBelcorp.setOidIdioma(idioma);
      dtoBelcorp.setOidPais(pais);

      ComposerViewElementList cList = new ComposerViewElementList();
      ComposerViewElement cElem1 = new ComposerViewElement();
      ComposerViewElement cElem2 = new ComposerViewElement();    
//      ComposerViewElement cElem3 = new ComposerViewElement();
      ComposerViewElement cElem4 = new ComposerViewElement();
      ComposerViewElement cElem5 = new ComposerViewElement();
      ComposerViewElement cElem6 = new ComposerViewElement();

      cElem1.setIDBusiness("SEGConsultaMarcas");
      cElem1.setDTOE(dtoBelcorp);

      cElem2.setIDBusiness("SEGConsultaCanales");
      cElem2.setDTOE(dtoBelcorp);

/*      cElem3.setIDBusiness("MAVObtieneTiposEstadoProceso");
      cElem3.setDTOE(dtoBelcorp);*/

      cElem4.setIDBusiness("MAVObtieneEstadosEnvio");
      cElem4.setDTOE(dtoBelcorp);

      cElem5.setIDBusiness("MAVObtenerTiposDespacho");
      cElem5.setDTOE(dtoBelcorp);

      cElem6.setIDBusiness("MAEObtenerTipos");
      cElem6.setDTOE(dtoBelcorp);

      cList.addViewElement(cElem1);
      cList.addViewElement(cElem2);    
//      cList.addViewElement(cElem3);        
      cList.addViewElement(cElem4);
      cList.addViewElement(cElem5);
      cList.addViewElement(cElem6);


      ConectorComposerView conector = new ConectorComposerView(cList, this.getRequest());
      traza("Ejecuta Conectar");
      conector.ejecucion();
      traza("Termina ejecucion Conectar");
      DruidaConector conPantalla = conector.getConector();

      MareBusinessID bussID = new MareBusinessID("MAVCargaPaginaRegistrosMAV");
      Vector vRegZonas = new Vector();
      vRegZonas.add(dtoBelcorp);
      vRegZonas.add(bussID);
      traza("Ejecuta Conectar Regiones / Zonas");
      DruidaConector conRegionesZonas = this.conectar("ConectorCargaPaginaRegistrosMAV", vRegZonas);
      traza("Termina Conectar Regiones / Zonas");    
      DTOCargaPaginaRegistrosMAV dtoRegZonas = (DTOCargaPaginaRegistrosMAV) conRegionesZonas.objeto("dtoSalida");
      RecordSet regiones = dtoRegZonas.getRegiones();
      RecordSet zonas = dtoRegZonas.getZonas();

      traza("regiones: " + regiones);
      traza("zonas: " + zonas);

      DruidaConector conectorRegiones = UtilidadesBelcorp.generarConector("conectorRegiones", regiones, regiones.getColumnIdentifiers() );
      DruidaConector conectorZonas = UtilidadesBelcorp.generarConector("conectorZonas", zonas, zonas.getColumnIdentifiers() );    

      traza("Asigna Listas Ocultas");
      this.asignar("LISTADOA", "listaRegiones", conectorRegiones, "conectorRegiones"); 
      this.asignar("LISTADOA", "listaZonas", conectorZonas, "conectorZonas");     

      traza("Asigna Combos");


      this.asignar("COMBO", "cbMarca", conPantalla, "SEGConsultaMarcas");
      this.asignar("COMBO", "cbCanal", conPantalla, "SEGConsultaCanales");
      //this.asignar("COMBO", "cbEstadoAutorizacion", conPantalla, "MAVObtieneTiposEstadoProceso");  // ????????
      this.asignar("COMBO", "cbEstadoAutorizacion", conPantalla, "MAVObtieneEstadosEnvio");
      this.asignar("COMBO", "cbTipoDespacho", conPantalla, "MAVObtenerTiposDespacho");
      this.asignar("COMBO", "cbTipoClientes", conPantalla, "MAEObtenerTipos");

      return;
      

  }

// ---------------------------------------------------------------------------------
  private String formateaFechas(String fecha) throws Exception
  {
    traza(" ---- formateaFechas ");
    traza("Fecha Entrada: " + fecha);
    SimpleDateFormat simpleDateBD = new SimpleDateFormat("yyyy-mm-dd");
    SimpleDateFormat simpleDateSalida = new SimpleDateFormat(UtilidadesSession.getFormatoFecha(this));
    java.util.Date fechaTemp = simpleDateBD.parse(fecha);

    String fechaSalida = simpleDateSalida.format(fechaTemp);

    traza("Fecha Salida: " + fechaSalida);

    return fechaSalida;

  }  

// ---------------------------------------------------------------------------------
  private void guardar() throws Exception
  {
      traza("Entrando a Guardar");
      String hidCriterioOrdenacion = (String) this.conectorParametro("hidCriterioOrdenacion");
      traza("CriterioOrdenacion: " + hidCriterioOrdenacion);
      String hidAgrupacionCliente = (String) this.conectorParametro("hidAgrupacionCliente");
      String hidAgrupacionDespacho = (String) this.conectorParametro("hidAgrupacionDespacho");
      String hidAgrupacionProductos = (String) this.conectorParametro("hidAgrupacionProductos");
      String hidProductosCD = (String) this.conectorParametro("hidProductosCD");
      traza("hidAgrupacionCliente: " + hidAgrupacionCliente);
      traza("hidAgrupacionDespacho: " + hidAgrupacionDespacho);
      traza("hidAgrupacionProductos: " + hidAgrupacionProductos);      
      traza("hidProductosCD: " + hidProductosCD);            
      

      this.pagina("salidaGenerica");
      DTORegistrosMAV dtoReg = new DTORegistrosMAV();

      // ---------------------------------------------
      // Seccion de Proceso de Criterios de Ordenacion
      // ---------------------------------------------      
      if ( hidCriterioOrdenacion.equals("Cliente") )
      {
        traza("--- Procesa Criterio Ordenacion Cliente");      
        traza("hidAgrupacionCliente: " + hidAgrupacionCliente);
        if ( !hidAgrupacionCliente.equals("") ) 
        {
          ArrayList aList = this.parseaDespachoClientes(hidAgrupacionCliente);
          dtoReg.setAgrupacionesEnvios(aList);
        } else {
          dtoReg.setAgrupacionesEnvios( new ArrayList() );
        } 
        // Completa con ArrayList envioProducto (setDetalleAgrupacion se completa abajo)
        dtoReg.setEnviosProducto(new ArrayList() );
        
      }

      if ( hidCriterioOrdenacion.equals("Despacho") )
      {
        traza("--- Procesa Criterio Ordenacion Despacho");      
        traza("hidAgrupacionDespacho: " + hidAgrupacionDespacho);
        if ( !hidAgrupacionDespacho.equals("") )
        {
          ArrayList aList = this.parseaDespachoClientes(hidAgrupacionDespacho);
          dtoReg.setAgrupacionesEnvios(aList);
        } else {
          dtoReg.setAgrupacionesEnvios( new ArrayList() );
        }
        // Completa con ArrayList envioProducto (setDetalleAgrupacion se completa abajo)
        dtoReg.setEnviosProducto(new ArrayList() );
        
      }            

      if ( hidCriterioOrdenacion.equals("Producto") )
      {
        traza("--- Procesa Criterio Ordenacion Productos");
        traza("hidAgrupacionProductos: " + hidAgrupacionProductos);
        if ( !hidAgrupacionProductos.equals("") )
        {
          ArrayList aList = this.parseaProducto(hidAgrupacionProductos);
          dtoReg.setEnviosProducto(aList);
        } else {
          dtoReg.setEnviosProducto( new ArrayList() );
        }
        // Completa con ArrayList vacios los demás criterios.
        dtoReg.setAgrupacionesEnvios(new ArrayList() );
        dtoReg.setDetalleAgrupacion(new ArrayList() );
      }            
      
      // -------------------------------------------------------
      // Seccion de Productos para criterios Cliente / Despacho
      // -------------------------------------------------------      
      if ( hidCriterioOrdenacion.equals("Cliente") || hidCriterioOrdenacion.equals("Despacho") )
      {
         if ( !hidProductosCD.equals("") )
         {
           ArrayList aList = this.parseaProductoCD(hidProductosCD);
           dtoReg.setDetalleAgrupacion(aList);
         } else {
           dtoReg.setDetalleAgrupacion( new ArrayList() );
         }
         
      }

      traza("DTORegistro: " + dtoReg);
      
      MareBusinessID bussID = new MareBusinessID("MAVGuardarRegistrosMAV");
      Vector v = new Vector();
      v.add(dtoReg);
      v.add(bussID);
      traza("Yendo al guardar");
      DruidaConector con = this.conectar("ConectorGuardarRegistrosMAV", v);
      traza("Salio del guardar");

      this.asignarAtributo("VAR", "ejecutar", "valor", "accionBuscar()");

  }


// ---------------------------------------------------------------------------------
  private ArrayList parseaProducto(String cadena) throws Exception
  {
    // Formato de Fila: [oidEnvio, fechaEntrega, numUnidades, estadoEnvio]
    traza("ParseaProducto(" + cadena + ");");
    StringTokenizer tok = new StringTokenizer(cadena, ",");
    ArrayList aList = new ArrayList();
    DTOEnvioMAV dtoEnvio = new DTOEnvioMAV();
    int n = 0;

    while ( tok.hasMoreTokens() ) 
    {
      String valor = tok.nextToken();
      traza("Indice: " + n);      
      traza("Valor: " + valor);

      if (n == 0)
        dtoEnvio.setOidEnvioMAV( new Long(valor) );      

      if (n == 1)
      { 
         // Formato de fecha de entrega, si es "" o " " pasa null
        valor = valor.trim();
         if (!valor.equals(" ") && !valor.equals("") ){
           Timestamp t = this.obtieneTimestamp(valor);
           dtoEnvio.setFechaEntrega(t);
         } else
          dtoEnvio.setFechaEntrega(null);
      }

      if (n == 2)
         dtoEnvio.setNumeroUnidades( new Long(valor) );      

      if (n == 3) 
         dtoEnvio.setTipoEstadoEnvio( new Long(valor) );        

      n++;
      if (n == 4)
      {
         traza("dtoEnvio a enviar: " + dtoEnvio);
         aList.add(dtoEnvio);
         dtoEnvio = new DTOEnvioMAV();
         n = 0;        
      }
    }
   
    return aList;

  }

// ---------------------------------------------------------------------------------
  private ArrayList parseaProductoCD(String cadena) throws Exception
  {
    // Parsea producto para criterio Cliente/Despacho - No tenemos Fecha Entrega
    // Formato de Fila: [oidEnvio, numUnidades, estadoEnvio]    
    traza("----- parseaProductoCD(" + cadena + ")");
    ArrayList aList = new ArrayList();
    StringTokenizer tok = new StringTokenizer(cadena, ",");
    DTOEnvioMAV dtoEnvio = new DTOEnvioMAV();
    int contador = 0;

    while ( tok.hasMoreTokens() )
    {
      String valor = tok.nextToken();
      if (contador == 0)
        dtoEnvio.setOidEnvioMAV( new Long(valor) );

      if (contador == 1)
        dtoEnvio.setNumeroUnidades( new Long(valor) );

      if (contador == 2)
        dtoEnvio.setTipoEstadoEnvio( new Long(valor) );

      contador++;
      if (contador == 3)
      {
        aList.add(dtoEnvio);
        traza("DTOEnvio: " + dtoEnvio);
        dtoEnvio = new DTOEnvioMAV();
        contador = 0;
      }
      
    }
    return aList;
    
  }
  
// ---------------------------------------------------------------------------------
  private ArrayList parseaDespachoClientes(String cadena) throws Exception
  {
    // Formato de fila: [oidTipoCliente, CodCliente, FechaEntrega, oidTipoDespacho
    traza("parseaDespachoClientes(" + cadena + ")");
    ArrayList aList = new ArrayList();
    StringTokenizer tok = new StringTokenizer(cadena, ",");
    DTOAgrupacionEnvios dtoEnvio = new DTOAgrupacionEnvios();

    int contador = 0;
    
    while ( tok.hasMoreTokens() )
    {
      String valor = tok.nextToken();
      if (contador == 0)
        dtoEnvio.setOidTipoCliente(new Long(valor));

      if (contador == 1)
        dtoEnvio.setCodigoCliente(valor);

      if (contador == 2)
      {
        // Fecha de entrega. Si del javascript viene " " o "", pasa null
        valor = valor.trim();        
        if (!valor.equals(" ") && !valor.equals("") )
        {
          Timestamp t = this.obtieneTimestamp(valor);
          dtoEnvio.setFechaEntrega(t);
        } else
          dtoEnvio.setFechaEntrega(null);
      }

      if (contador == 3)
        dtoEnvio.setOidTipoDespacho(new Long(valor));

      contador++;
      
      if ( contador == 4)
      {
        contador = 0;
        dtoEnvio.setOidPais(UtilidadesSession.getPais(this));
        traza("dtoEnvio a agregar: " + dtoEnvio);
        aList.add(dtoEnvio);
        dtoEnvio = new DTOAgrupacionEnvios();
      }
      
    }

    return aList;
  
  }  

// ---------------------------------------------------------------------------------
  private Timestamp obtieneTimestamp(String fecha) throws Exception
  {
    // Toma un String con <fecha> y devuelve un Timestamp. 
    // Se asume que el formato de fecha es el mismo que el que se
    // encuentra en sesion.
    
    Timestamp t = null;

    String formatoFecha = UtilidadesSession.getFormatoFecha(this);
    formatoFecha = formatoFecha.replace('m', 'M');
    SimpleDateFormat simpleDate = new SimpleDateFormat(formatoFecha);    
    java.util.Date fechaDate = simpleDate.parse(fecha);
    t = new Timestamp( fechaDate.getTime() );

    return t;
    
  }

// ---------------------------------------------------------------------------------
  private void seteaTitulo(String casoUso) throws Exception
  {
      if ( casoUso.equals("consultar") )
        this.asignarAtributoPagina("cod", "0240");      
        
      if ( casoUso.equals("modificar") )
        this.asignarAtributoPagina("cod", "0276");      
      return;
  }

}
