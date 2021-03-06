import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;
import java.util.Vector;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class LPUsuariosTotales extends LPSICCBase {           
   public LPUsuariosTotales() {	 
     super();
  }

  public void inicio() throws Exception { 
    
  }

  public void ejecucion() throws Exception {		
     String accion = conectorParametroLimpia("accion","", true);
     setTrazaFichero();
     try {
        this.rastreo();
        
        if (accion.equals("generar")){
           generarReporte(); 
           //cargarPagina();
          // getConfiguracionMenu("LPUsuariosTotales");
        }else{
           traza("adonde estoy yendo?");
           cargarPagina();
           getConfiguracionMenu("LPUsuariosTotales");
        }
     
     } catch (Exception ex) {
     			
        cargarPagina();
        getConfiguracionMenu("LPUsuariosTotales");
               
        ByteArrayOutputStream stack = new ByteArrayOutputStream();
		    PrintStream out = new PrintStream(stack);
			  ex.printStackTrace(out);
	      traza("EXCEPCION:" + stack.toString());
		    lanzarPaginaError(ex);
      /*  try{
            cargarPagina();
        }catch(Exception e){
            e.printStackTrace();
        }*/

     }

    
  }
  
  private void cargarPagina() throws Exception{
       pagina("contenido_listado_usuarios_totales_obtener");   
    
      ComposerViewElementList cv = crearParametrosEntrada();
      ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
      conector.ejecucion();
      DruidaConector resultados = conector.getConector();
      traza(" 4 " + resultados.getXML());
     
      //cargo la lista oculta de zonas
      DTOUnidadAdministrativa dtoUA = new DTOUnidadAdministrativa();
      dtoUA.setOidPais(UtilidadesSession.getPais(this));
      dtoUA.setOidIdioma(UtilidadesSession.getIdioma(this));

      /*DruidaConector conectorRecargaZona = null;
      MareBusinessID bId = new MareBusinessID("ZONRecargaZonas");
      Vector vec = new Vector();
      vec.add(dtoUA);
      vec.add(bId);
      DTOSalida dtoSal = (DTOSalida) conectar("ConectorRecargaZonas",vec).objeto("dtoSalida"); 
      RecordSet zona = (RecordSet)dtoSal.getResultado();
      Vector colZona = zona.getColumnIdentifiers();
      DruidaConector zonas = generarConector("DTOSalida.zonas_ROWSET",zona, colZona);
      traza("zonas "+dtoSal.getResultado());
      traza("zonas "+dtoSal.getResultado().getColumnIdentifiers());
      this.crearListaLP(colZona, zona.getColumnCount(), "Capa1","Lista1", "14", "200");
      asignar("LISTA", "Lista1", zonas, "DTOSalida.zonas_ROWSET");  
     
      //cargo la lista oculta de secciones
      DruidaConector conectorRecargaSeccion = null;
      MareBusinessID bId2 = new MareBusinessID("ZONRecargaSecciones");
      Vector vec2 = new Vector();
      vec2.add(dtoUA);
      vec2.add(bId2);
      DTOSalida dtoSal2 = (DTOSalida) conectar("ConectorRecargaSecciones",vec2).objeto("dtoSalida"); 
      RecordSet seccion = (RecordSet)dtoSal2.getResultado();
      Vector colSeccion = seccion.getColumnIdentifiers();
      DruidaConector secciones = generarConector("DTOSalida.secciones_ROWSET",seccion, colSeccion);
      traza("regiones "+dtoSal2.getResultado());
      traza("regiones "+dtoSal2.getResultado().getColumnIdentifiers());
      this.crearListaLP(colSeccion, seccion.getColumnCount(), "Capa2","Lista2", "14", "200");
      asignar("LISTA", "Lista2", secciones, "DTOSalida.secciones_ROWSET");*/
      
      DTOBelcorp dtoB = new DTOBelcorp();
      MareBusinessID idDep = new MareBusinessID("REPObtenerDepartamentos");
      DruidaConector conectorDepartamentos = null;
      dtoB.setOidIdioma(UtilidadesSession.getIdioma(this));
      dtoB.setOidPais(UtilidadesSession.getPais(this));
      
      Vector vecDep = new Vector();
     
      vecDep.add(dtoB);
      vecDep.add(idDep);
          
      DTOSalida dtoSal3 = (DTOSalida) conectar("ConectorDepartamentos",vecDep).objeto("dtoSalida"); 
      RecordSet departamento = (RecordSet)dtoSal3.getResultado();
      Vector colDepto = departamento.getColumnIdentifiers();
      DruidaConector departamentos = generarConector("DTOSalida.departamentos_ROWSET",departamento, colDepto);
     
      traza("departamentos "+dtoSal3.getResultado());
      traza("regiones "+dtoSal3.getResultado().getColumnIdentifiers());
      asignar("COMBO", "cbDepartamento", departamentos, "DTOSalida.departamentos_ROWSET");  
      
      asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");             
      asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
      asignar("COMBO", "cbEmpresa", resultados, "SEGObtenerEmpresasSinFiltro");
      asignar("COMBO","cbRegion",resultados,"ZONObtenerRegiones");
      asignarAtributo("VAR", "casoDeUso", "valor","LPUsuariosTotales");
          
      //cargaValoresPorDefecto();
	  String paisOid = UtilidadesSession.getPais(this).toString();
	  traza("pais "+paisOid);
      asignarAtributo("VAR", "pais", "valor", paisOid);
  }
  
  
  private void cargaValoresPorDefecto() throws Exception{
  
      if(UtilidadesSession.getMarcaPorDefecto(this) != null){
         traza("marca defecto es diferente de null");
         Long marcaDefecto = UtilidadesSession.getMarcaPorDefecto(this);
         asignarAtributo("VAR", "marcaDefecto", "valor", marcaDefecto.toString());
      }
      
      traza("paso 1");      
      
      if(UtilidadesSession.getCanalPorDefecto(this) != null){
         traza("canal defecto es diferente de null");
         Long canalDefecto = UtilidadesSession.getCanalPorDefecto(this);
         asignarAtributo("VAR", "canalDefecto", "valor", canalDefecto.toString());
      }
      
      traza("paso 2");
      
      if(UtilidadesSession.getRegionPorDefecto(this) != null){
         traza("region defecto es diferente de null");
         Long regionDefecto = UtilidadesSession.getRegionPorDefecto(this);
         asignarAtributo("VAR", "regionDefecto", "valor", regionDefecto.toString());
      }
      
      traza("paso 3");
      
      if(UtilidadesSession.getZonaPorDefecto(this) != null){
         traza("zona defecto es diferente de null");
         Long zonaDefecto = UtilidadesSession.getZonaPorDefecto(this);
         asignarAtributo("VAR", "zonaDefecto", "valor", zonaDefecto.toString());
      }
      
      traza("paso 4");
      
      if(UtilidadesSession.getSeccion(this) != null){
         traza("seccion defecto es diferente de null");
         Integer seccionDefecto = UtilidadesSession.getSeccion(this);
         asignarAtributo("VAR", "seccionDefecto", "valor", seccionDefecto.toString());
      }
     
  }
  private ComposerViewElementList crearParametrosEntrada() throws Exception{
     traza("metodo crearParametrosEntrada() ");
     DTOBelcorp dtoBel = new DTOBelcorp();
     
     dtoBel.setOidPais(UtilidadesSession.getPais(this));
     dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));
       
     ComposerViewElementList lista = new ComposerViewElementList();
     
     //Carga de combo marca
     ComposerViewElement cbMarca = new ComposerViewElement();
     cbMarca.setIDBusiness("SEGConsultaMarcas");
     cbMarca.setDTOE(dtoBel);
     
     //Carga de combo canales
     ComposerViewElement cbCanales = new ComposerViewElement();
     cbCanales.setIDBusiness("SEGConsultaCanales");
     cbCanales.setDTOE(dtoBel);
     
     //Carga de combo empresa
     DTOOID dtoEmpre = new DTOOID();
     dtoEmpre.setOid(UtilidadesSession.getPais(this));
     ComposerViewElement cbEmpresa = new ComposerViewElement();
     cbEmpresa.setIDBusiness("SEGObtenerEmpresasSinFiltro");
     cbEmpresa.setDTOE(dtoEmpre);
     
     //Carga de combo region
     DTOUnidadAdministrativa dtoUA = new DTOUnidadAdministrativa();
     dtoUA.setOidPais(UtilidadesSession.getPais(this));
     dtoUA.setOidIdioma(UtilidadesSession.getIdioma(this));
     ComposerViewElement cbRegiones = new ComposerViewElement();
     cbRegiones.setIDBusiness("ZONObtenerRegiones");
     cbRegiones.setDTOE(dtoUA);
     cbRegiones.setPosOID((byte)0);
     cbRegiones.setPosDesc((byte)5);
                      
     lista.addViewElement(cbMarca);
     lista.addViewElement(cbCanales);   
     lista.addViewElement(cbEmpresa);
     lista.addViewElement(cbRegiones);
     
     return lista;
  }
         
  
  private void generarReporte() throws Exception{
     
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "SEG");
     
     //comienzo de los parametrso de filtrado
     String marca        = conectorParametroLimpia("marca", "", true);
     if(!marca.equals("")){
        datos.put(ConstantesREP.MARCAS, marca);     
     }
     
     String canal        = conectorParametroLimpia("canal", "", true);
     if(!canal.equals("")){
        datos.put(ConstantesREP.CANALES, canal);     
     }
     
     String empresa      = conectorParametroLimpia("empresa", "", true);
     if(!empresa.equals("")){
        datos.put(ConstantesREP.EMPRESAS, empresa);     
     }
     
     String departamento = conectorParametroLimpia("departamento", "", true);
     if(!departamento.equals("")){
        datos.put(ConstantesREP.DEPARTAMENTOS, departamento);     
     }
     
     String region       = conectorParametroLimpia("region", "", true);
     if(!region.equals("")){
        datos.put(ConstantesREP.REGIONES, region);  
     }
     
     String zona         = conectorParametroLimpia("zona", "", true);
     if(!zona.equals("")){
        datos.put(ConstantesREP.ZONAS, zona);
     }
     
     String seccion      = conectorParametroLimpia("seccion", "", true);
     if(!seccion.equals("")){
        datos.put(ConstantesREP.SECCIONES, seccion);
     }
     
     String apPaterno    = conectorParametroLimpia("apePat", "", true);
     if(!apPaterno.equals("")){
        datos.put(ConstantesREP.APELLIDOPATERNO, apPaterno);
     }
     
     String apMaterno    = conectorParametroLimpia("apeMat", "", true);
     if(!apMaterno.equals("")){
        datos.put(ConstantesREP.APELLIDOMATERNO, apMaterno);
     }
     
     String nombre1      = conectorParametroLimpia("nombre1", "", true);
     if(!nombre1.equals("")){
        datos.put(ConstantesREP.NOMBRE1, nombre1);
     }
     
     String nombre2      = conectorParametroLimpia("nombre2", "", true);
     if(!nombre2.equals("")){
        datos.put(ConstantesREP.NOMBRE2, nombre2);
     }
     
     datos.put(ConstantesREP.TITULO, "Usuarios totales");
     traza("++++++Antes de enviar a reportes"); 
     //ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-028", null);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-028", "pdf");
          
  } 
  
  private DruidaConector generarConector(String rowsetID, RecordSet datos,
          Vector columns) throws DOMException, Exception {
          StringBuffer salida = new StringBuffer();

          int sizeColums = datos.getColumnCount();
          int sizeRows = datos.getRowCount();

          if (columns == null) {
              columns = new Vector();
          }

          Vector columsDesc = datos.getColumnIdentifiers();

          DruidaConector conectorValoresPosibles = new DruidaConector();
          XMLDocument xmlDoc = new XMLDocument();
          Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");
          Element e_rows = docDestino.createElement("ROWSET");
          e_rows.setAttribute("ID", rowsetID);
          docDestino.getDocumentElement().appendChild(e_rows);

          for (int i = 0; i < sizeRows; i++) {
              Element e_row = docDestino.createElement("ROW");
              e_rows.appendChild(e_row);

              for (int j = 0; j < sizeColums; j++) {
                    if (columns.contains(columsDesc.elementAt(j))) {
                         Element e_campo2 = docDestino.createElement("CAMPO");
                         e_campo2.setAttribute("NOMBRE",
                              columsDesc.elementAt(j).toString());
                         e_campo2.setAttribute("TIPO", "OBJECTO");
                         e_campo2.setAttribute("LONGITUD", "50");

                         Text txt = docDestino.createTextNode(((datos.getValueAt(i, j) == null)
                                    ? "" : datos.getValueAt(i, j).toString()));
                         e_campo2.appendChild(txt);
                         e_row.appendChild(e_campo2);
                    }
              }
          }

          conectorValoresPosibles.setXML(docDestino.getDocumentElement());

          return conectorValoresPosibles;
    }
    
    
    private void crearListaLP(Vector nomColumns, int cantColumns,
          String nomCapa, String nomLista, String XCapa, String YCapa)
          throws Exception {
          traza("dentro de crearListaLP()  " + nomColumns + " " + cantColumns);

          Document document = getXML();

          Element eCapa = document.createElement("CAPA");
          eCapa.setAttribute("nombre", nomCapa);
          eCapa.setAttribute("alto", "162");
          eCapa.setAttribute("ancho", "580");
          eCapa.setAttribute("colorf", "");
          eCapa.setAttribute("borde", "1");
          eCapa.setAttribute("imagenf", "");
          eCapa.setAttribute("repeat", "");
          eCapa.setAttribute("padding", "");
          eCapa.setAttribute("visibilidad", "hidden");
          eCapa.setAttribute("contravsb", "");
          eCapa.setAttribute("zindex", "");
          eCapa.setAttribute("x", XCapa);
          eCapa.setAttribute("y", YCapa);

          Element eLista = document.createElement("LISTA");

          eLista.setAttribute("seleccion", "boton");
          eLista.setAttribute("nombre", nomLista);
          eLista.setAttribute("ancho", "580");
          eLista.setAttribute("alto", "150");
          eLista.setAttribute("multisel", "0");
          eLista.setAttribute("incy", "1");
          eLista.setAttribute("incx", "10");
          eLista.setAttribute("colorf", "#EFEFEF");
          eLista.setAttribute("imagenoff", "close_no.gif");
          eLista.setAttribute("imagenon", "close_up.gif");
          eLista.setAttribute("accion", "");
          eLista.setAttribute("sep", "|");
          eLista.setAttribute("pixelsborde", "3");
          eLista.setAttribute("colorborde", "#CCCCCC");

          Element eCABECERA = document.createElement("CABECERA");
          eCABECERA.setAttribute("nombre", "cabecera");
          eCABECERA.setAttribute("height", "20");

          Integer anchoCab;

          if (cantColumns < 4) {
              anchoCab = new Integer(580 / cantColumns);
          } else {
              anchoCab = new Integer(150);
          }

          Element eCOL_1 = document.createElement("COL");
          eCOL_1.setAttribute("id", "fondoCabecera");
          eCOL_1.setAttribute("ancho", anchoCab.toString());

          Element eCOL_2 = document.createElement("COL");
          eCOL_2.setAttribute("id", "fondoCabecera");
          eCOL_2.setAttribute("ancho", anchoCab.toString());

          Element eCOL_3 = document.createElement("COL");
          eCOL_3.setAttribute("id", "fondoCabecera");
          eCOL_3.setAttribute("ancho", anchoCab.toString());

          Element eCOL_4 = document.createElement("COL");
          eCOL_4.setAttribute("id", "fondoCabecera");
          eCOL_4.setAttribute("ancho", anchoCab.toString());

          Element eCOL_5 = document.createElement("COL");
          eCOL_5.setAttribute("id", "fondoCabecera");
          eCOL_5.setAttribute("ancho", anchoCab.toString());

          Element eCOL_6 = document.createElement("COL");
          eCOL_6.setAttribute("id", "fondoCabecera");
          eCOL_6.setAttribute("ancho", anchoCab.toString());

          Vector columnas = new Vector();

          for (int i = 0; i < cantColumns; i++) {
              Element eLABEL_2 = document.createElement("LABELC");
              eLABEL_2.setAttribute("id", "fondoCabecera");
              eLABEL_2.setAttribute("nombre", "lbDivisionesPoliticas" + i);
              eLABEL_2.setAttribute("ancho", anchoCab.toString());
              eLABEL_2.setAttribute("alto", "20");
              eLABEL_2.setAttribute("filas", "1");
              eLABEL_2.setAttribute("id", "datosCamposCabecera");

              if (i != 0) {
                    eLABEL_2.setAttribute("valor", (String) nomColumns.get(i));
              } else {
                    eLABEL_2.setAttribute("cod", "199");
              }

              eLABEL_2.setAttribute("enviaroculto", "N");
              columnas.add(eLABEL_2); //Agrego label a la columna
          }

          traza("despues de poner en variables los titulos " + columnas + " " +
              cantColumns);

          if (cantColumns >= 1) {
              eCOL_1.appendChild((Element) columnas.get(0));
              eCABECERA.appendChild(eCOL_1);
              traza("1");
          }

          if (cantColumns >= 2) {
              eCOL_2.appendChild((Element) columnas.get(1));
              eCABECERA.appendChild(eCOL_2);
              traza("1");
          }

          if (cantColumns >= 3) {
              eCOL_3.appendChild((Element) columnas.get(2));
              eCABECERA.appendChild(eCOL_3);
              traza("1");
          }

          if (cantColumns >= 4) {
              eCOL_4.appendChild((Element) columnas.get(3));
              eCABECERA.appendChild(eCOL_4);
              traza("1");
          }

          if (cantColumns >= 5) {
              eCOL_5.appendChild((Element) columnas.get(4));
              eCABECERA.appendChild(eCOL_5);
              traza("1");
          }

          if (cantColumns >= 6) {
              eCOL_6.appendChild((Element) columnas.get(5));
              eCABECERA.appendChild(eCOL_6);
              traza("1");
          }

          Element ePRESENTACION = document.createElement("PRESENTACION");
          Integer ancho = new Integer(cantColumns * anchoCab.intValue());
          ePRESENTACION.setAttribute("ancho", ancho.toString());
          ePRESENTACION.setAttribute("filas", "1");

          int swX1 = 0;
          StringBuffer cadena = new StringBuffer("['datosCamposCenterImpar'");
          traza("break brain");

          for (int i = 1; i < cantColumns; i++) {
              if (swX1 == 0) {
                    cadena.append(", 'datosCamposCenterPar'");
                    swX1 = 1;
              } else {
                    cadena.append(", 'datosCamposCenterImpar'");
                    swX1 = 0;
              }
          }

          for (int i = 0; i < cantColumns; i++) {
              Element eCOLP_2 = document.createElement("COL");
              eCOLP_2.setAttribute("ancho", anchoCab.toString());
              eCOLP_2.setAttribute("caracteres", "150");
              ePRESENTACION.appendChild(eCOLP_2); //Agrego columna a la presentacion
          }

          cadena.append("]");

          traza("### " + cadena.toString());
          ePRESENTACION.setAttribute("bloquesid", cadena.toString());

          Element eROWSET = document.createElement("ROWSET");

          eLista.appendChild(eCABECERA); //Agrego la cabecera de la lista
          eLista.appendChild(ePRESENTACION); //Agrego la presentacion de la lista
          eLista.appendChild(eROWSET); //Agrego el rowset de la lista

          eCapa.appendChild(eLista);

          getXML().getElementsByTagName("FORMULARIO").item(0).appendChild(eCapa);
    }



}
