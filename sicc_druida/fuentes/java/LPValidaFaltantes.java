//import LPSICCBase;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.dtos.ped.ConstantesPedFaltantes;
import java.sql.Date;
import es.indra.sicc.dtos.ped.DTOEInformeFaltantes;
import es.indra.sicc.dtos.ped.DTOInformeFaltantes;
import es.indra.mare.common.exception.MareException;

import java.util.Vector;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
//import java.text.DateFormat;
import java.util.Iterator;
import es.indra.sicc.util.xml.XMLDocument;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import es.indra.sicc.dtos.ped.DTOMovimiento;
import es.indra.sicc.dtos.ped.DTOCabeceraReporte;
import java.util.ArrayList;
import java.util.Collection;
import org.w3c.dom.Text;

public class LPValidaFaltantes extends LPSICCBase {
    private Long pais = null;
    private Long idioma = null;
    private String accion =null;   
	private String tempOidLote =null;   
    static int TAMANOPAGINASINDINAMICA = 728;
    Integer yLista;

    XMLDocument xml = null;
    Document doc = null;

    //para prueba con harcodeo
    DTOInformeFaltantes dtoif = null;
    
  public void inicio() throws Exception{
  }

  public LPValidaFaltantes() 
  {
    super();
  }
    public void ejecucion() throws Exception {
        this.setTrazaFichero();
        try{
            traza("LLEGA");
            this.rastreo();
            pais=UtilidadesSession.getPais(this);
            idioma=UtilidadesSession.getIdioma(this);

            accion = conectorParametro("accion");
            accion = (accion==null?"":accion);
            traza("accion"+accion);
            if (accion.equalsIgnoreCase("")){
                this.muestraPagina();
                this.getConfiguracionMenu("LPValidaFaltantes","");
            }else if(accion.equalsIgnoreCase("ver")){
                ejecutarInforme(ConstantesPedFaltantes.OP_MUESTRA);
                this.getConfiguracionMenu("LPValidaFaltantes","");
            }else if(accion.equalsIgnoreCase("aprobar")){
                ejecutarInforme(ConstantesPedFaltantes.OP_APRUEBA);
                this.getConfiguracionMenu("LPValidaFaltantes","");
            }else if(accion.equalsIgnoreCase("generar")){
                ejecutarInforme(ConstantesPedFaltantes.OP_GENERA);
                this.getConfiguracionMenu("LPValidaFaltantes","");
            }else if(accion.equalsIgnoreCase("Reporte")){
                cargarInformes();
                this.getConfiguracionMenu("LPValidaFaltantes","Reporte");
            }            
        }catch(Exception e){
            logStackTrace(e);
            //e.printStackTrace();
            this.lanzarPaginaError(e);
        }
    }

    private void muestraPagina() throws Exception{
        String fechaIni = conectorParametro("fechaIni")==null?"":conectorParametro("fechaIni");
        String fechaFin = conectorParametro("fechaFin")==null?"":conectorParametro("fechaFin");
        traza("fechaIni: "+fechaIni);
        traza("fechaFin: "+fechaFin);
        //cambio incidencia 11410
        DTOBelcorp dto = new DTOBelcorp();
        dto.setOidIdioma(idioma);
        dto.setOidPais(pais);
        MareBusinessID id = new MareBusinessID("PEDCargaValidarFaltantes");
        Vector vec = new Vector();
        vec.add(dto);
        vec.add(id);
        traza("antes de conectar ConectorCargaValidarFaltantes");
        DruidaConector conectorSalida = conectar("ConectorCargaValidarFaltantes",vec);
        DTOOID dtoS = (DTOOID)conectorSalida.objeto("DTOOID");
        
        pagina("contenido_monitor_emergente");   
		    this.getFormatosValidaciones();
        traza("varOidLoteReporteFaltantes "+((dtoS.getOid()!=null)?dtoS.getOid().toString():"vino nulo"));
        asignarAtributo("VAR","fechaIni", "valor",fechaIni);
        asignarAtributo("VAR","fechaFin", "valor",fechaFin);          
        asignarAtributo("VAR","varOidLoteReporteFaltantes", "valor",(dtoS.getOid()!=null)?dtoS.getOid().toString():"");  
        
    }
    
    private void ejecutarInforme(int operacion) throws Exception{
        String oidLoteReporte = conectorParametro("varOidLoteReporteFaltantes");
        traza("oidLoteReporte"+oidLoteReporte);
    	String formatoFecha = conectorParametro("hFormatoFechaPais")==null?"dd/MM/yy":conectorParametro("hFormatoFechaPais");
        pagina("contenido_monitor_emergente");
        this.getFormatosValidaciones();
        DTOEInformeFaltantes dto = new DTOEInformeFaltantes();
        dto.setOidIdioma(idioma);
        dto.setOidPais(pais);
        dto.setOperacion(operacion);
        dto.setOidLoteReporteFaltantes((oidLoteReporte!=null&&(!oidLoteReporte.equals("")))?new Long(oidLoteReporte):null);
        traza("antes de recuperar fechas");
		if (formatoFecha==null)
		{
	    	formatoFecha = conectorParametro("hFormatoFechaPais")==null?"dd/MM/yy":conectorParametro("hFormatoFechaPais");
		}

		formatoFecha = formatoFecha.replace('m','M');
        SimpleDateFormat date = new SimpleDateFormat(formatoFecha);
		String fechaIni = conectorParametro("fechaIni");
		String fechaFin = conectorParametro("fechaFin");
        asignarAtributo("VAR","fechaIni", "valor",fechaIni);
        asignarAtributo("VAR","fechaFin", "valor",fechaFin);          
		traza("Fini:"+fechaIni+" Ffin:"+fechaFin+" Formato:"+formatoFecha);

        try{
            if (conectorParametro("fechaIni")!=null && !conectorParametro("fechaIni").equals("")){
                dto.setFechaInicio(new java.sql.Date(date.parse(conectorParametro("fechaIni")).getTime()));
            }
            if (conectorParametro("fechaFin")!=null && !conectorParametro("fechaFin").equals("")){
                dto.setFechaFin(new java.sql.Date(date.parse(conectorParametro("fechaFin")).getTime()));
            }
        }catch(Exception e){traza("Error al formatear fechas");
        }
        traza("antes de conectar a");        
        MareBusinessID id = new MareBusinessID("PEDEjecutarInformeFaltantes");
        Vector vec = new Vector();
        vec.add(dto);
        vec.add(id);
        traza("antes de conectar b");        
        DruidaConector conectorSalida = conectar("ConectorInformeFaltantes",vec);
        DTOInformeFaltantes dtoS = (DTOInformeFaltantes)conectorSalida.objeto("dtoSalida");//dtoif;//
        
        tempOidLote = dtoS.getOid().toString();
		traza("en ejecutarInforme, el tempOidLote, es: " + tempOidLote);
        traza("antes de muestra informe");
        traza("dto resultado:"+dtoS);
        if (dtoS.getCabecera()!=null)
        {
            for (int i = 0; i<dtoS.getCabecera().length;i++){
                traza("cabecera"+i+" "+dtoS.getCabecera()[i]);
                        if (dtoS.getCabecera()[i].getMovimientoCategoria()!=null)
                        {
                          for(int j=0;j<dtoS.getCabecera()[i].getMovimientoCategoria().length;j++)
                          {
                            traza("categria"+i+j+" "+dtoS.getCabecera()[i].getMovimientoCategoria()[j]);
                          }
                        }

						traza("   ---- tiro valores por defecto ----   ");

			  //DTOMovimiento dtomovprod = new DTOMovimiento();
              //dtomovprod.setAlmacen(new Long(21));
              //dtomovprod.setDemanda(new Long(19));
              //dtomovprod.setFaltante(new Long(20));
              //dtomovprod.setIndAhorro(new Boolean(false));
              //dtomovprod.setIndDiario(new Boolean(true));
              //dtomovprod.setNegocio(new Long(1));
              //dtomovprod.setOidIdioma(new Long(1));
              //dtomovprod.setOidPais(new Long(1));
              //dtomovprod.setPosicion(new Long(1));
              //dtomovprod.setProducto(new Long(19));
              //dtomovprod.setStockDisponible(new Long(1));
              //dtomovprod.setUnidades(new Long(21));
              //dtomovprod.setTxtAlmacen(new String("ALMAC21"));
              //dtomovprod.setTxtNegocio(new String("NEG1"));
              //dtomovprod.setTxtProducto(new String("PROD19"));  

              //DTOMovimiento dtomovprod2 = new DTOMovimiento();
              //dtomovprod2.setAlmacen(new Long(16));
              //dtomovprod2.setDemanda(new Long(22));
              //dtomovprod2.setFaltante(new Long(23));
              //dtomovprod2.setIndAhorro(new Boolean(true));
              //dtomovprod2.setIndDiario(new Boolean(false));
              //dtomovprod2.setNegocio(new Long(7));
              //dtomovprod2.setOidIdioma(new Long(1));
              //dtomovprod2.setOidPais(new Long(1));
              //dtomovprod2.setPosicion(new Long(1));
              //dtomovprod2.setProducto(new Long(19));
              //dtomovprod2.setStockDisponible(new Long(1));
              //dtomovprod2.setUnidades(new Long(24));
              //dtomovprod2.setTxtAlmacen(new String("ALMAC16"));
              //dtomovprod2.setTxtNegocio(new String("NEG7"));
              //dtomovprod2.setTxtProducto(new String("PROD19")); 
			  //DTOMovimiento[] dtosmovprod = {dtomovprod,dtomovprod2};
			  //dtoS.getCabecera()[i].setMovimientoProducto(dtosmovprod);

						if (dtoS.getCabecera()[i].getMovimientoProducto()!=null)
                        {
                          for(int k=0;k<dtoS.getCabecera()[i].getMovimientoProducto().length;k++)
                          {
                            traza("producto"+i+k+" "+dtoS.getCabecera()[i].getMovimientoProducto()[k]);
                          }
                        }        
            }
        } 
        muestraInforme(dtoS);
        traza("fin ejecutar informe");
    }

    private void muestraInforme(DTOInformeFaltantes informe) throws Exception{
        //pagina("contenido_monitor_emergente");
		traza("en...muestraInforme!!");
        String fechaIni = conectorParametro("fechaIni")==null?"":conectorParametro("fechaIni");
        String fechaFin = conectorParametro("fechaFin")==null?"":conectorParametro("fechaFin");
        String oidLote; /*= conectorParametro("varOidLoteReporteFaltantes")==null?"":conectorParametro("varOidLoteReporteFaltantes");*/

        if (tempOidLote!=null) {
          oidLote=tempOidLote.toString();
		  traza("tempOidLote, != null, cargo oidLote desde tempOidLote!");
		}else{
	      oidLote = conectorParametro("varOidLoteReporteFaltantes")==null?"":conectorParametro("varOidLoteReporteFaltantes");
          traza("tempOidLote, == null, cargo oidLote desde varOidLoteReporteFaltantes!");
        } 

		traza("oidLote: " + oidLote);
		traza("informe: " + informe);
		traza("fechaIni: " + fechaIni);
		traza("fechaFin: " + fechaFin);
		
        conectorParametroSesion("informe",informe);
        asignarAtributo("VAR","fechaIni", "valor",fechaIni);
        asignarAtributo("VAR","fechaFin", "valor",fechaFin);        
        asignarAtributo("VAR","varOidLoteReporteFaltantes", "valor",oidLote);
        asignarAtributo("VAR","cartel", "valor","1");
        if (informe==null||informe.getCabecera()==null||informe.getCabecera().length==0)
        {
		   traza("se dio que: informe==null||informe.getCabecera()==null||informe.getCabecera().length==0");
          /*throw new MareException(new Exception(),);*/
        }
            
        
    }

    private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());

        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);

        if (e instanceof MareException) {
            MareException e2 = (MareException) e;
            traza("Es una mare Exception con codigo de error: " + e2.getCode());
        }

        e.printStackTrace(out);
        traza("stack Trace : " + pila.toString());
   }
   private void cargarInformes() throws Exception{
      traza("==============>  ENTRA A cargarInformes()");
      this.pagina("contenido_reportes_faltantes");
      this.getFormatosValidaciones();
      asignarAtributoPagina("cod","00611");
      getConfiguracionMenu();
      DTOInformeFaltantes dto = (DTOInformeFaltantes)conectorParametroSesion("informe");
      traza("dto"+dto);
      /*if (dto!=null){
          traza("dtoCabelength"+dto.getCabecera().length);
          if(dto.getCabecera().length>0)
              traza("dtoCabe1"+dto.getCabecera()[0]);
      }*/
      if (dto!=null){
        xml = new XMLDocument();
        doc = xml.makeDocument("<DIV/>");
        Element listado0 = generaPantalla(dto);        
        DruidaConector con0 = new DruidaConector();        
        con0.setXML(listado0);
        if (listado0!=null) {
          traza("PANTALLA ARMADA:---------");
          traza(con0.getXML());        
          asignar("REJILLA","rejlistado1",con0);
        }
      }
   }
   private Element generaPantalla(DTOInformeFaltantes informe) throws Exception{
      traza("==============>  ENTRA A generaPantalla()");     
      
      Element tablePantalla = null; //Contiene la pantalla
      if (informe.getCabecera()!=null){
        int elements = informe.getCabecera().length;
        tablePantalla = doc.createElement("table");
        tablePantalla.setAttribute("border","1");
        tablePantalla.setAttribute("align","center");
        tablePantalla.setAttribute("cellspacing","0");
        tablePantalla.setAttribute("cellpadding","0");
        for (int i=0;i<elements;i++){           
             tablePantalla.appendChild(generaPagina(informe, i, elements));
        }
      }
      return tablePantalla;
   }
   private Element generaPagina(DTOInformeFaltantes informe, int i, int elements) throws Exception{
      traza("==============>  ENTRA A generaPagina()"+ i );   
      Element tablePagina = null; //Contiene una pagina completa

      tablePagina = doc.createElement("table");
      tablePagina.setAttribute("border","1");
      tablePagina.setAttribute("align","center");
      tablePagina.setAttribute("cellspacing","0");
      tablePagina.setAttribute("cellpadding","0");

      //Cabecera
      Element tableCabecera = null;      
      DTOCabeceraReporte cabecera = (DTOCabeceraReporte)informe.getCabecera()[i];
      tableCabecera = generaCabecera(cabecera, (i+1), elements);
      tablePagina.appendChild(tableCabecera);

      //Movimientos
      Element tableMovimientos = null;   
      tableMovimientos = doc.createElement("table");
      tableMovimientos.setAttribute("border","1");
      tableMovimientos.setAttribute("width","790");
      if(cabecera==null) return null;//cabecera vacia.
        if(cabecera.getMovimientoCategoria()!=null&&cabecera.getMovimientoCategoria().length>0){
            //Movimientos Categoria
              //Cab. mov. cat.
              Element trEncabezadoMovCategoria = getTR();
              trEncabezadoMovCategoria.appendChild(getTD());
              Element tdMovDiario = getTD();
              tdMovDiario.setAttribute("align","center");
              tdMovDiario.appendChild(getTEXT("Movimiento Diario"));
              trEncabezadoMovCategoria.appendChild(tdMovDiario);
              Element tdMovAcumulado = getTD();
              tdMovAcumulado.setAttribute("align","center");
              tdMovAcumulado.appendChild(getTEXT("Movimiento Acumulado"));
              trEncabezadoMovCategoria.appendChild(tdMovAcumulado);
              tableMovimientos.appendChild(trEncabezadoMovCategoria);          
              
              int nromovcat = cabecera.getMovimientoCategoria().length;
              //debo filtrar por almacen
              //busco el almacen con numero mas bajo
              DTOMovimiento movcatini = (DTOMovimiento)cabecera.getMovimientoCategoria()[0];
              if (movcatini.getAlmacen()==null) return null;//no tiene datos.
              
              Long almacen = movcatini.getAlmacen();
              String txtalmac = movcatini.getTxtAlmacen();
              
              for(int j=0;j<nromovcat;j++){
                 DTOMovimiento movcat = (DTOMovimiento)cabecera.getMovimientoCategoria()[j];
                 Long almacenActual = movcat.getAlmacen();
                 String txtalmacenActual = movcat.getTxtAlmacen();
                 if (almacen.compareTo(almacenActual)>0) {
                    almacen=almacenActual;
                    txtalmac = txtalmacenActual;
                 }
              }
    
              while (almacen!=null){
                    Collection colmovcatalmac = new ArrayList();//va a contener todos los movimientos de este almacen
                    for(int j=0;j<nromovcat;j++){
                        DTOMovimiento movcat = (DTOMovimiento)cabecera.getMovimientoCategoria()[j];
                        if (movcat.getAlmacen().equals(almacen)){
                            colmovcatalmac.add(movcat);
                        }
                    }
                    if(!colmovcatalmac.isEmpty()){
                      //proceso almacen
                      //Titulo mov. cat.
                      Element trTitMovCategoria = getTR();
                      Element tdAlmac = getTD();
                      tdAlmac.setAttribute("align","center");
                      tdAlmac.appendChild(getTEXT("Almacen:"+txtalmac));
                      trTitMovCategoria.appendChild(tdAlmac);
                      Element tdTotFalt1 = getTD();
                      tdTotFalt1.setAttribute("align","center");
                      tdTotFalt1.appendChild(getTEXT("Total Faltantes"));
                      trTitMovCategoria.appendChild(tdTotFalt1);
                      Element tdTotFalt2 = getTD();
                      tdTotFalt2.setAttribute("align","center");
                      tdTotFalt2.appendChild(getTEXT("Total Faltantes"));
                      trTitMovCategoria.appendChild(tdTotFalt2);
                      tableMovimientos.appendChild(trTitMovCategoria);
                      //Tablas mov. cat.            
                      Element trTablaMovCategoria = generaMovimientosPorCategoria(colmovcatalmac,almacen);//es un tr con 3 td y 1 table en cada td
                      tableMovimientos.appendChild(trTablaMovCategoria);
                    }
                    //Busco siguiente almacen
                    Long siguAlmac = null;
                    String txtsiguAlmac = null;
                    boolean primeraVez = true;
                    for(int j=0;j<nromovcat;j++){
                        DTOMovimiento movcat = (DTOMovimiento)cabecera.getMovimientoCategoria()[j];
                        if (movcat.getAlmacen().compareTo(almacen)>0){
                            //es superior, tengo que buscar el inferior de los superiores.
                            if (primeraVez) {
                                siguAlmac = movcat.getAlmacen();
                                txtsiguAlmac = movcat.getTxtAlmacen();
                                primeraVez = false;
                            } else {
                              if (movcat.getAlmacen().compareTo(siguAlmac)<0){                          
                                  siguAlmac = movcat.getAlmacen();
                                  txtsiguAlmac = movcat.getTxtAlmacen();
                              }
                            }
                        }
                    }
                    almacen = siguAlmac;
                    txtalmac = txtsiguAlmac;
              }
          }
          
          if(cabecera.getMovimientoProducto()!=null&&cabecera.getMovimientoProducto().length>0){
          //Movimientos Productos
          //Cab. mov prod.
          Element trEncabezadoMovProducto = getTR();
          trEncabezadoMovProducto.appendChild(getTD());
          Element tdMovDiario2 = getTD();
          tdMovDiario2.setAttribute("align","center");
          tdMovDiario2.appendChild(getTEXT("Movimiento Diario"));
          trEncabezadoMovProducto.appendChild(tdMovDiario2);
          Element tdMovAcumulado2 = getTD();
          tdMovAcumulado2.setAttribute("align","center");
          tdMovAcumulado2.appendChild(getTEXT("Movimiento Acumulado"));
          trEncabezadoMovProducto.appendChild(tdMovAcumulado2);          
          tableMovimientos.appendChild(trEncabezadoMovProducto);
          //Titulo mov. prod 
          Element trTitMovProducto = getTR();
          Element tdDescr = getTD();
          tdDescr.setAttribute("align","center");          
          tdDescr.appendChild(getTEXT("Descripción"));
          //tdDescr.appendChild(getSPAN("Descripcion"));
          trTitMovProducto.appendChild(tdDescr);
          Element tdTotFalt1 = getTD();
          tdTotFalt1.setAttribute("align","center");
          tdTotFalt1.appendChild(getTEXT("Total Faltantes"));
          trTitMovProducto.appendChild(tdTotFalt1);
          Element tdTotFalt2 = getTD();
          tdTotFalt2.setAttribute("align","center");
          tdTotFalt2.appendChild(getTEXT("Total Faltantes"));
          trTitMovProducto.appendChild(tdTotFalt2);          
          tableMovimientos.appendChild(trTitMovProducto);
          
          //Tabla mov. prod
          Element trTablaMovProducto = generaMovimientosPorProducto(cabecera.getMovimientoProducto(), cabecera);//es un tr con 3 td y 1 table en cada td
          tableMovimientos.appendChild(trTablaMovProducto); 
        
          tablePagina.appendChild(tableMovimientos);
          }
      return tablePagina;
   }   
   private Element generaCabecera(DTOCabeceraReporte cabecera, int i, int elements) throws Exception{
      traza("==============>  ENTRA A generaCabecera()");
      
      Element tableCabecera = null; //Contiene una cabecera

      tableCabecera = doc.createElement("table");
      tableCabecera.setAttribute("border","1");

        //Superior
        Element tableCabeceraSup = null; //Contiene la parte superior de la cabecera

        tableCabeceraSup = doc.createElement("table");
        tableCabeceraSup.setAttribute("border","0");
        tableCabeceraSup.setAttribute("width","782");
          
          Element trSuperior = getTR();
            Element tdSuperior = getTD();
                Element trDatos1 = getTR();
                  Element tdDatos11 = getTD();                                 
                  Element tdDatos12 = getTD();
                  Element tdDatos13 = getTD();
                    tdDatos13.setAttribute("align","right");
                    tdDatos13.appendChild(getTEXT("Pag.:"+i+" de "+elements));
                trDatos1.appendChild(tdDatos11);
                trDatos1.appendChild(tdDatos12);
                trDatos1.appendChild(tdDatos13);
                Element trDatos2 = getTR();
                  Element tdDatos21 = getTD();                                 
                    tdDatos21.setAttribute("align","left");
                    tdDatos21.appendChild(getTEXT("Belcorp"));                  
                  Element tdDatos22 = getTD();
                    tdDatos22.setAttribute("align","center");
                    tdDatos22.appendChild(getTEXT("Reporte de Faltantes"));                  
                  Element tdDatos23 = getTD();
                    tdDatos23.setAttribute("align","right");
                    tdDatos23.appendChild(getTEXT("Fecha:"+obtenerFechaActualFormatoPais()));
                trDatos2.appendChild(tdDatos21);
                trDatos2.appendChild(tdDatos22);
                trDatos2.appendChild(tdDatos23);                  
                Element trDatos3 = getTR();
                  Element tdDatos31 = getTD();                                 
                    tdDatos31.setAttribute("align","left");
                    tdDatos31.appendChild(getTEXT("Peru-Facturacion"));                  
                  Element tdDatos32 = getTD();
                    tdDatos32.setAttribute("align","center");
                    tdDatos32.appendChild(getTEXT("Validacion de Grupo de Procesos (GP3)"));                  
                  Element tdDatos33 = getTD();
                    tdDatos33.setAttribute("align","right");
                    tdDatos33.appendChild(getTEXT("Hora:"+this.obtenerHoraActual()));
                trDatos3.appendChild(tdDatos31);
                trDatos3.appendChild(tdDatos32);
                trDatos3.appendChild(tdDatos33);                   
                Element trDatos4 = getTR();
                  Element tdDatos41 = getTD();                                 
                    tdDatos41.setAttribute("align","left");
                    tdDatos41.appendChild(getTEXT("FAC-015"));                  
                  Element tdDatos42 = getTD();
                    tdDatos42.setAttribute("align","center");
                    tdDatos42.appendChild(getTEXT(""));                  
                  Element tdDatos43 = getTD();
                    tdDatos43.setAttribute("align","right");
                    tdDatos43.appendChild(getTEXT("Cod. Usuario:"+UtilidadesSession.getIdUsuario(this)));
                trDatos4.appendChild(tdDatos41);
                trDatos4.appendChild(tdDatos42);
                trDatos4.appendChild(tdDatos43);                      
            tdSuperior.appendChild(trDatos1);
            tdSuperior.appendChild(trDatos2);
            tdSuperior.appendChild(trDatos3);
            tdSuperior.appendChild(trDatos4);
          trSuperior.appendChild(tdSuperior);
          
        tableCabeceraSup.appendChild(trSuperior);

     tableCabecera.appendChild(tableCabeceraSup);
     
        //Inferior
        Element tableCabeceraInf = null; //Contiene la parte inferior de la cabecera

        tableCabeceraInf = doc.createElement("table");
        tableCabeceraInf.setAttribute("border","1");
        tableCabeceraInf.setAttribute("width","782");

          Element tdInfLeft = getTD();
          tdInfLeft.setAttribute("width","258");
            Element tableInfLeft = doc.createElement("table");
            tableInfLeft.setAttribute("border","0");	
            tableInfLeft.setAttribute("width","255");	
              Element trPais = getTR();//<TR>Pais: xxxx</TR>
                trPais.appendChild(getTEXT("Pais:"+(cabecera.getTxtPais()!=null?cabecera.getTxtPais():"")));
              Element trPeriodo = getTR();//<TR>Periodo: xxxx</TR>
                trPeriodo.appendChild(getTEXT("Periodo:"+(cabecera.getTxtPeriodo()!=null?cabecera.getTxtPeriodo():"")));
              Element trCanal = getTR();//<TR>Canal: xxxx</TR>
                trCanal.appendChild(getTEXT("Canal:"+(cabecera.getTxtCanal()!=null?cabecera.getTxtCanal():"")));
            tableInfLeft.appendChild(trPais);
            tableInfLeft.appendChild(trPeriodo);
            tableInfLeft.appendChild(trCanal);
          tdInfLeft.appendChild(tableInfLeft); 

          Element tdInfCenter = getTD();  
          tdInfCenter.setAttribute("width","260");
            Element tableInfCenter = doc.createElement("table");
            tableInfCenter.setAttribute("border","0");	
            tableInfCenter.setAttribute("width","257");	
              Element trMarca = getTR();//<TR>Marca: xxxx</TR>
                trMarca.appendChild(getTEXT("Marca:"+(cabecera.getTxtMarca()!=null?cabecera.getTxtMarca():"")));
              Element trAcceso = getTR();//<TR>Acceso: xxxx</TR>
                trAcceso.appendChild(getTEXT("Acceso:"+(cabecera.getTxtAcceso()!=null?cabecera.getTxtAcceso():"")));                
              Element trUNeg = getTR();//<TR>Unidad de Negocio: xxxx</TR>
                trUNeg.appendChild(getTEXT("Unidad de Negocio:"+(cabecera.getTxtUnidadNegocio()!=null?cabecera.getTxtUnidadNegocio():"")));              
            tableInfCenter.appendChild(trMarca);
            tableInfCenter.appendChild(trAcceso);
            tableInfCenter.appendChild(trUNeg);
          tdInfCenter.appendChild(tableInfCenter);   

          Element tdInfRight = getTD();
          tdInfRight.setAttribute("width","258");
            Element tableInfRight = doc.createElement("table");
            tableInfRight.setAttribute("border","0");	
            tableInfRight.setAttribute("width","255");	
              Element trFechAprob = getTR();//<TR>Fecha de Aprobacion: xx/xx/xxxx</TR>
                trFechAprob.appendChild(getTEXT("Fecha de Aprobacion:"));              
              Element trHoraAprob = getTR();//<TR>Hora de Aprobacion: xx:xx:xx</TR>
                trHoraAprob.appendChild(getTEXT("Hora de Aprobacion:"));                
              Element trAprob = getTR();//<TR>Aprobado por: xxxxxxxx</TR>
                trAprob.appendChild(getTEXT("Aprobado por:"));              
            tableInfRight.appendChild(trFechAprob);
            tableInfRight.appendChild(trHoraAprob);
            tableInfRight.appendChild(trAprob);
          tdInfRight.appendChild(tableInfRight);  
          
        tableCabeceraInf.appendChild(tdInfLeft);
        tableCabeceraInf.appendChild(tdInfCenter);
        tableCabeceraInf.appendChild(tdInfRight);
        
     tableCabecera.appendChild(tableCabeceraInf);
     
      return tableCabecera;
   }   
   private Element generaMovimientosPorCategoria(Collection collection, Long almacen) throws Exception{
      traza("==============>  ENTRA A generaMovimientosPorCategoria() Almacen:"+almacen);
      //El formato de lo que sale de este metodo será un tr con 3 td y cada td tendrá un table adentro.
      //la coleccion trae los movimientos correspondientes a un solo almacen      
      
      Element trTablaMovCat = getTR();
        Element tdTablaPricipal = getTD();
        Element tablePricipal = doc.createElement("table");//contiene la primera tabla de titulos
        tablePricipal.setAttribute("border","1");
        tablePricipal.setAttribute("width","100%");
        Element tdTablaDiario = getTD();
        Element tableDiario = doc.createElement("table");//contiene la segunda tabla de diarios
        tableDiario.setAttribute("border","1");
        tableDiario.setAttribute("width","100%");
        Element tdTablaAcumulados = getTD();
        Element tableAcumulados = doc.createElement("table");//contiene la tercera tabla de acumulados
        tableAcumulados.setAttribute("border","1");
        tableAcumulados.setAttribute("width","100%");        
        //Titulos Tabla
        Element trTitulosPrinc = getTR();
            Element tdTitPrinc = getTD();
              tdTitPrinc.appendChild(getTEXT("Total Faltantes por Negocio:"));
            trTitulosPrinc.appendChild(tdTitPrinc);
        tablePricipal.appendChild(trTitulosPrinc);//Total Faltantes por Negocio:
        Element trTitulosDiario = getTR();
              Element tdDem = getTD(); 
                tdDem.appendChild(getTEXT("Demanda"));
              Element tdStD = getTD();
                tdStD.appendChild(getTEXT("Stock Disponible"));
              Element tdFal = getTD();
                tdFal.appendChild(getTEXT("Faltantes"));
              Element tdUni = getTD();
                tdUni.appendChild(getTEXT("Unidades"));
            trTitulosDiario.appendChild(tdDem);//Demanda
            trTitulosDiario.appendChild(tdStD);//Stock Disponible
            trTitulosDiario.appendChild(tdFal);//Faltantes
            trTitulosDiario.appendChild(tdUni);//Unidades
        tableDiario.appendChild(trTitulosDiario);
        Element trTitulosAcumulado = getTR();
              Element tdDemA = getTD(); 
                tdDemA.appendChild(getTEXT("Demanda"));
              Element tFalA = getTD();
                tFalA.appendChild(getTEXT("Faltantes"));
              Element tdUniA = getTD();
                tdUniA.appendChild(getTEXT("Unidades"));   
        trTitulosAcumulado.appendChild(tdDemA);//Demanda
        trTitulosAcumulado.appendChild(tFalA);//Faltantes
        trTitulosAcumulado.appendChild(tdUniA);//Unidades        
        tableAcumulados.appendChild(trTitulosAcumulado);
        //Lineas Tabla        
        //hay que ubicar los pares de movimientos pertenecientes al mismo negocio
        Iterator itcol = collection.iterator();
        boolean noEncontroPar = true;
        
       while(!collection.isEmpty()){              
              DTOMovimiento dtoMov1P = (DTOMovimiento)itcol.next();
              DTOMovimiento dtoMov2P = null;
              itcol.remove();
              traza("dtoMov1P"+dtoMov1P);
              //Busco el par del mismo negocio              
              while(itcol.hasNext()&&noEncontroPar){
                    DTOMovimiento siguiente = (DTOMovimiento)itcol.next();
                    traza("siguiente"+siguiente);
                    if (dtoMov1P.getNegocio().equals(siguiente.getNegocio())){
                        traza("encontro");
                        itcol.remove();
                        dtoMov2P = siguiente;
                        noEncontroPar = false;
                    }
              }
              if (!noEncontroPar){
                  if ((dtoMov2P.getIndDiario()!=null)&&
                      (dtoMov2P.getIndDiario().equals(new Boolean(true)))){
                      DTOMovimiento aux = new DTOMovimiento();
                      aux = dtoMov2P;
                      dtoMov2P = dtoMov1P;
                      dtoMov1P = aux;
                  }              
                  Element trPrinc = getTR();
                      Element tdPrinc = getTD();
                      String ahorroGuia = new String("");
                      if (dtoMov1P.getIndAhorro().equals(new Boolean(true))){
                        ahorroGuia = ahorroGuia.concat("-"+ConstantesPedFaltantes.CTE_AHORRO_GUIA);
                      }
                      if (dtoMov1P.getTxtNegocio()!=null){
                        tdPrinc.appendChild(getTEXT(""+dtoMov1P.getTxtNegocio()+ahorroGuia));
                      } else {
                        tdPrinc.appendChild(getTEXT(" - "+ahorroGuia));
                      }
				  traza("Negocio: "+dtoMov1P.getTxtNegocio()+ahorroGuia);
				  traza("Demanda: "+dtoMov1P.getDemanda());
                  trPrinc.appendChild(tdPrinc);
                  tablePricipal.appendChild(trPrinc);
                  
                  Element trDiario = getTR();
                      Element tdDemData = getTD(); 
                        tdDemData.appendChild(getTEXT(""+dtoMov1P.getDemanda()));
                      Element tdStDData = getTD();
                        tdStDData.appendChild(getTEXT(""+dtoMov1P.getStockDisponible()));
                      Element tdFalData = getTD();
                        String falta = dtoMov1P.getFaltante().toString();
                        int punto = falta.indexOf(".");
                        falta = falta.substring(0,(punto+2));
                        tdFalData.appendChild(getTEXT(""+falta+" %"));
                      Element tdUniData = getTD();
                        tdUniData.appendChild(getTEXT(""+dtoMov1P.getUnidades()));                  
                  trDiario.appendChild(tdDemData);//Demanda
                  trDiario.appendChild(tdStDData);//Stock Disponible
                  trDiario.appendChild(tdFalData);//Faltantes
                  trDiario.appendChild(tdUniData);//Unidades
                  tableDiario.appendChild(trDiario);
                  
                  Element trAcumulado = getTR();
                      Element tdDemAData = getTD(); 
                        tdDemAData.appendChild(getTEXT(""+dtoMov2P.getDemanda()));
                      Element tFalAData = getTD();
                        falta = dtoMov2P.getFaltante().toString();
                        punto = falta.indexOf(".");
                        falta = falta.substring(0,(punto+2));                      
                        tFalAData.appendChild(getTEXT(""+falta+" %"));
                      Element tdUniAData = getTD();
                        tdUniAData.appendChild(getTEXT(""+dtoMov2P.getUnidades()));                     
                  trAcumulado.appendChild(tdDemAData);//Demanda
                  trAcumulado.appendChild(tFalAData);//Faltantes
                  trAcumulado.appendChild(tdUniAData);//Unidades        
                  tableAcumulados.appendChild(trAcumulado);   
                  noEncontroPar = true;
              }
              itcol = collection.iterator();
        }       
      tdTablaPricipal.appendChild(tablePricipal);
      tdTablaDiario.appendChild(tableDiario);
      tdTablaAcumulados.appendChild(tableAcumulados);
      trTablaMovCat.appendChild(tdTablaPricipal);
      trTablaMovCat.appendChild(tdTablaDiario);
      trTablaMovCat.appendChild(tdTablaAcumulados);
      traza("Mov. por Categoria Almacen:"+almacen+" XML:"+trTablaMovCat.toString());
      return trTablaMovCat;
   }      
   private Element generaMovimientosPorProducto(DTOMovimiento[] dtoMovProd, DTOCabeceraReporte cabecera) throws Exception{
      traza("==============>  ENTRA A generaMovimientosPorProducto()");   
      Element trTablaMovProd = getTR();
      
        Element tdTablaPricipal = getTD();
        Element tablePricipal = doc.createElement("table");//contiene la primera tabla de titulos
        tablePricipal.setAttribute("border","1");
        tablePricipal.setAttribute("width","100%");
        Element tdTablaDiario = getTD();
        Element tableDiario = doc.createElement("table");//contiene la segunda tabla de diarios
        tableDiario.setAttribute("border","1");
        tableDiario.setAttribute("width","100%");
        Element tdTablaAcumulados = getTD();
        Element tableAcumulados = doc.createElement("table");//contiene la tercera tabla de acumulados
        tableAcumulados.setAttribute("border","1");
        tableAcumulados.setAttribute("width","100%");        
        //Titulos Tabla
        Element trTitulosPrinc = getTR();
            Element tdTitPrinc = getTD();
              tdTitPrinc.appendChild(getTEXT("Productos Criticos:"));
            Element tdTitPrinc2 = getTD();
              tdTitPrinc2.appendChild(getTEXT("Marca"));              
            trTitulosPrinc.appendChild(tdTitPrinc);
            trTitulosPrinc.appendChild(tdTitPrinc2);
        tablePricipal.appendChild(trTitulosPrinc);//Total Faltantes por Negocio:
        Element trTitulosDiario = getTR();
              Element tdAlm = getTD(); 
                tdAlm.appendChild(getTEXT("Almacen"));        
              Element tdDem = getTD(); 
                tdDem.appendChild(getTEXT("Demanda"));
              Element tdStD = getTD();
                tdStD.appendChild(getTEXT("Stock Disponible"));
              Element tdFal = getTD();
                tdFal.appendChild(getTEXT("Faltantes"));
              Element tdUni = getTD();
                tdUni.appendChild(getTEXT("Unidades"));
            trTitulosDiario.appendChild(tdAlm);//Almacen    
            trTitulosDiario.appendChild(tdDem);//Demanda
            trTitulosDiario.appendChild(tdStD);//Stock Disponible
            trTitulosDiario.appendChild(tdFal);//Faltantes
            trTitulosDiario.appendChild(tdUni);//Unidades
        tableDiario.appendChild(trTitulosDiario);
        Element trTitulosAcumulado = getTR();
              Element tdDemA = getTD(); 
                tdDemA.appendChild(getTEXT("Demanda"));
              Element tFalA = getTD();
                tFalA.appendChild(getTEXT("Faltantes"));
              Element tdUniA = getTD();
                tdUniA.appendChild(getTEXT("Unidades"));   
        trTitulosAcumulado.appendChild(tdDemA);//Demanda
        trTitulosAcumulado.appendChild(tFalA);//Faltantes
        trTitulosAcumulado.appendChild(tdUniA);//Unidades        
        tableAcumulados.appendChild(trTitulosAcumulado);      
      //Titulos Tabla      
      int cont = 1; 
      //Lineas Tabla      
      int nromovprod = cabecera.getMovimientoProducto().length;
      for(int j=0;j<nromovprod;j++){  
              DTOMovimiento dtoMov1P = (DTOMovimiento)cabecera.getMovimientoProducto()[j];
              j++;//2da vez
              DTOMovimiento dtoMov2P = (DTOMovimiento)cabecera.getMovimientoProducto()[j];              
              
              boolean dummy = false;
              traza("dtoMov1P["+j+"]:"+dtoMov1P);              
              traza("dtoMov2P["+j+"]:"+dtoMov2P);
              //chequeo de nulo
              if ((dtoMov1P.getAlmacen()==null)&&
                  (dtoMov1P.getDemanda()==null)&&
                  (dtoMov1P.getFaltante()==null)&&
                  (dtoMov1P.getNegocio()==null)&&
                  (dtoMov1P.getOidIdioma()==null)&&
                  (dtoMov1P.getOidPais()==null)&&
                  (dtoMov1P.getPosicion()==null)&&
                  (dtoMov1P.getProducto()==null)&&
                  (dtoMov1P.getStockDisponible()==null)&&
                  (dtoMov1P.getUnidades()==null)){
                    dummy = true;
                  }
              /* no hace mas falta pues vienen siempre ordenados diario y despues acumulado
              if ((dtoMov2P.getIndDiario()!=null)&&
                  (dtoMov2P.getIndDiario().equals(new Boolean(true)))){
                  DTOMovimiento aux = new DTOMovimiento();
                  aux = dtoMov2P;
                  dtoMov2P = dtoMov1P;
                  dtoMov1P = aux;
              }*/
              Element trPrinc = getTR();
                  Element tdPrinc = getTD(); 
                  if (!dummy){
                    tdPrinc.appendChild(getTEXT(""+cont+"-"+dtoMov1P.getTxtProducto()));
                  } else {
                    tdPrinc.appendChild(getTEXT(" - "));
                  }
                  Element tdPrinc2 = getTD();
                  if (!dummy){
                    tdPrinc2.appendChild(getTEXT(""+cabecera.getTxtMarca()));
                  } else {
                    tdPrinc2.appendChild(getTEXT(" - "));
                  }
              trPrinc.appendChild(tdPrinc);
              trPrinc.appendChild(tdPrinc2);
              tablePricipal.appendChild(trPrinc);
              
              Element trDiario = getTR();
                  Element tdAlmData = getTD(); 
                    if (!dummy){
                      tdAlmData.appendChild(getTEXT(""+dtoMov1P.getTxtAlmacen()));
                    } else {
                      tdAlmData.appendChild(getTEXT("-"));
                    }
                  Element tdDemData = getTD(); 
                    if (!dummy){
                      tdDemData.appendChild(getTEXT(""+dtoMov1P.getDemanda()));
                    } else {
                      tdDemData.appendChild(getTEXT("-"));
                    }
                  Element tdStDData = getTD();
                    if (!dummy){
                      tdStDData.appendChild(getTEXT(""+dtoMov1P.getStockDisponible()));
                    } else {
                      tdStDData.appendChild(getTEXT("-"));
                    }
                  Element tdFalData = getTD();
                    if (!dummy){
                      String falta = dtoMov1P.getFaltante().toString();
                      int punto = falta.indexOf(".");
                      falta = falta.substring(0,(punto+2));
                      tdFalData.appendChild(getTEXT(""+falta+" %"));
                    } else {
                      tdFalData.appendChild(getTEXT("-"));
                    }
                  Element tdUniData = getTD();
                    if (!dummy){
                      tdUniData.appendChild(getTEXT(""+dtoMov1P.getUnidades()));
                    } else {
                      tdUniData.appendChild(getTEXT("-"));
                    }
              trDiario.appendChild(tdAlmData);//Almacen      
              trDiario.appendChild(tdDemData);//Demanda
              trDiario.appendChild(tdStDData);//Stock Disponible
              trDiario.appendChild(tdFalData);//Faltantes
              trDiario.appendChild(tdUniData);//Unidades
              tableDiario.appendChild(trDiario);
              
              Element trAcumulado = getTR();
                  Element tdDemAData = getTD(); 
                    if (!dummy){
                      tdDemAData.appendChild(getTEXT(""+dtoMov2P.getDemanda()));
                    } else {
                      tdDemAData.appendChild(getTEXT("-"));
                    }
                  Element tFalAData = getTD();
                    if (!dummy){
                      String falta = dtoMov2P.getFaltante().toString();
                      int punto = falta.indexOf(".");
                      falta = falta.substring(0,(punto+2));
                      tFalAData.appendChild(getTEXT(""+falta+" %"));
                    } else {
                      tFalAData.appendChild(getTEXT("-"));
                    }
                  Element tdUniAData = getTD();
                    if (!dummy){
                      tdUniAData.appendChild(getTEXT(""+dtoMov2P.getUnidades()));
                    } else {
                      tdUniAData.appendChild(getTEXT("-"));
                    }
              trAcumulado.appendChild(tdDemAData);//Demanda
              trAcumulado.appendChild(tFalAData);//Faltantes
              trAcumulado.appendChild(tdUniAData);//Unidades        
              tableAcumulados.appendChild(trAcumulado);   
              cont++;              
        }       
      
      tdTablaPricipal.appendChild(tablePricipal);
      tdTablaDiario.appendChild(tableDiario);
      tdTablaAcumulados.appendChild(tableAcumulados);
      trTablaMovProd.appendChild(tdTablaPricipal);
      trTablaMovProd.appendChild(tdTablaDiario);
      trTablaMovProd.appendChild(tdTablaAcumulados);
      return trTablaMovProd;
   }
   
   private Element getTR(){
        Element tr = doc.createElement("tr");
        return tr;
   }
   private Element getTD(){
        Element td = doc.createElement("td");
        return td;
   }   
   private Element getLABELCx(String nombre, String ancho, String alto, String filas, String valor, String id, String cod){
        Element labelC = doc.createElement("LABELC");
        labelC.setAttribute("nombre",nombre);
        labelC.setAttribute("ancho",ancho);
        labelC.setAttribute("alto",alto);
        labelC.setAttribute("filas",filas);
        labelC.setAttribute("valor",valor);
        labelC.setAttribute("id",id);
        labelC.setAttribute("cod",cod);
        return labelC;
   }
   private Element getLABELx(String nombre, String ancho, String alto,
        String filas, String valor, String id) {
        Element label = doc.createElement("LABEL");
        label.setAttribute("nombre", nombre);
        label.setAttribute("ancho", ancho);
        label.setAttribute("alto", alto);
        label.setAttribute("filas", filas);
        label.setAttribute("valor", valor);
        label.setAttribute("id", id);
        //label.setAttribute("cod", cod);
        return label;
   }
   private Text getTEXT(String valor) {   
      Text text = doc.createTextNode(valor);
      return text;
    }    
    private String obtenerFechaActualFormatoPais() throws Exception {
      // obtenemos el formato de fecha actual segun el pais
      Date fecha = new Date(System.currentTimeMillis());
      String formatoFecha = null;
         formatoFecha = UtilidadesSession.getFormatoFecha(this);
      // aseguro el indicador de mes a mayuscula  
      formatoFecha = formatoFecha.replace('m','M');
      //trabajamos con el formato del pais
      SimpleDateFormat formatoPais = new SimpleDateFormat(formatoFecha);
      //formateamos la fecha segun el formato del pais
      String fechaFormatoPaisStr = null;
      if (fecha != null){
         fechaFormatoPaisStr = formatoPais.format(fecha);
      }
      //retorna la fecha formateada    
      return fechaFormatoPaisStr;
    }
    private String obtenerHoraActual() throws Exception {
      // obtenemos el formato de fecha actual segun el pais
      Date hora = new Date(System.currentTimeMillis());
      String formatoHora = null;
         formatoHora = new String("hh:mm:ss");
      // aseguro el indicador de mes a mayuscula  

      //trabajamos con el formato del pais
      SimpleDateFormat formatoPais = new SimpleDateFormat(formatoHora);
      //formateamos la fecha segun el formato del pais
      String horaFormatoPaisStr = null;
      if (hora != null){
         horaFormatoPaisStr = formatoPais.format(hora);
      }
      //retorna la fecha formateada    
      return horaFormatoPaisStr;
    }
     private Element getIMG(int width, int height){
				Element img = doc.createElement("IMG")   ;
				img.setAttribute("src","b.gif");
				img.setAttribute("width",""+width);
				img.setAttribute("height",""+height);
				return img;
    }
    private Element getTR(int tds){
        Element tr = doc.createElement("tr");
        while(tds > 0){
           tr.appendChild(doc.createElement("td"));
           tds--;
        }
        return tr;
    }
    private Element getFIELDSET(){
        Element fieldset = doc.createElement("fieldset");
        return fieldset;
    }

    private Element getLegend(){
        Element legend = doc.createElement("legend");
        legend.setAttribute("class","legend");
        //legend.appendChild(getTEXT("lblLegend","105","13","1","","legend","00117" ));
        return legend;
    }    
}
