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

/*import LPSICCBase;*/
import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.ped.DTOBuscarDatosMonitor;
import es.indra.sicc.dtos.ped.DTODatosMonitor;
import es.indra.sicc.dtos.ped.DTOElementoPlantilla;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Date;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
//sacar
/**
 * Sistema:       Belcorp
 * Modulo:        PED
 * Submódulo:     Monitor
 * Componente:    LPMonitor
 * Fecha:         30/07/2004
 * Observaciones:     
 * @version        1.0
 * @autor         
 */

public class LPPruebaMonitor extends LPSICCBase {

	public LPPruebaMonitor() {
		super();
	}

	public void inicio() throws Exception {
		pagina("contenido_prueba_monitor");
	}

	public void ejecucion() throws Exception {

	  setTrazaFichero();
	  
	  try{
          DTOBuscarDatosMonitor dtoBDM = new DTOBuscarDatosMonitor();
          dtoBDM.setOidIdioma(new Long(1));
          dtoBDM.setOidPais(new Long(1));
          dtoBDM.setFechaInicio(new Date("01/07/2005"));
          dtoBDM.setFechaFin(new Date("01/12/2005"));
          dtoBDM.setIpCliente("");
          dtoBDM.setPrograma("");

          MareBusinessID bizId = new MareBusinessID("PEDBuscarDatosMonitor");

          Vector params = new Vector();
          params.addElement( dtoBDM );
          params.addElement( bizId );

          //traza( "Antes conector: " + dtoBDM);
          //DruidaConector dc  =	conectar( "ConectorDatosMonitor" , params );

          //DTODatosMonitor dtoS = (DTODatosMonitor) dc.objeto("dtoSalida"); 
          //DTODatosMonitor dtoS = new DTODatosMonitor(); /*** SACAR POR COMENTARIO ANTERIOR ***/
          //dtoS.setProcesos(armarRecordSetPrueba());  /*** SACAR POR COMENTARIO ANTERIOR ***/
          String asignacion ;//=     convertirRecordSetAString(dtoS.getProcesos());   
          //traza(asignacion);
          asignacion = "1####Consolidado NC - Consultora####12####1012####0########1########0########0########0########1####1####13%%%%0####Consolidado NC - Consultora############0########1########0########0########0########1####0####0%%%%1####Consolidado NC - Consultora####12####1012####0########1########0########0########0########1####1####13%%%%0####Consolidado NC - Consultora############0########1########0########0########0########1####0####0%%%%1####Consolidado NC - Consultora####12####1012####0########1########0########0########0########1####1####13%%%%0####Consolidado NC - Consultora############0########1########0########0########0########1####0####0%%%%1####Consolidado NC - Consultora####12####1012####0########1########0########0########0########1####1####13%%%%0####Consolidado NC - Consultora############0########1########0########0########0########1####0####0";
          //DruidaConector conector = generarConector(dtoS.getProcesos());
          //asignar( "REJILLA", "monitor", conector);
          asignarAtributo("VAR","valoresLista","valor",asignacion);
          


	  }catch (Exception ex){
			   
		  logStackTrace(ex); 

		  this.lanzarPaginaError(ex);
			
	  }

		  //getConfiguracionMenu();

	}
  
  private String convertirRecordSetAString(RecordSet r){
      try{
          StringBuffer s = new StringBuffer();
          for (int i = 0; i<r.getRowCount();i++){
              for (int j = 0 ; j < r.getColumnCount(); j++){
                  if (r.getValueAt(i,j)!=null){
                      traza(r.getValueAt(i,j));
                      s.append(r.getValueAt(i,j));
                  }else{
                      s.append("");
                  }
                  if (j !=  (r.getColumnCount()-1)){
                      s.append("####");
                  }
              }
              if (i !=  (r.getRowCount()-1)){
                  s.append("%%%%");
              }
          }
          return s.toString();
      }catch (Exception e){
          e.printStackTrace();
      }
      return "";
  }


  

  private RecordSet armarRecordSetPrueba() throws Exception {
      RecordSet rs = new RecordSet();

      rs.addColumn("tieneTextBox");
      rs.addColumn("DESCRIPCION");
      rs.addColumn("DES_REGI");
      rs.addColumn("DES_ZONA");
      rs.addColumn("GP1");
      rs.addColumn("GP1SEC");
      rs.addColumn("GP2");
      rs.addColumn("GP2SEC");
      rs.addColumn("GP3");
      rs.addColumn("GP3SEC");
      rs.addColumn("GP4");
      rs.addColumn("GP4SEC");
      rs.addColumn("GP5");
      rs.addColumn("GP5SEC");
      rs.addColumn("TSPA_OID_TIPO_SOLI_PAIS");
      rs.addColumn("ZORG_OID_REGI");
      rs.addColumn("ZZON_OID_ZONA");

      Vector fila = new Vector();
      fila.add("1");
      fila.add("BELCENTER");
      fila.add("SVG01-Region10");
      fila.add("SG01R10Zona1011");
      fila.add("10");
      fila.add("");
      fila.add("0");
      fila.add("");
      fila.add("0");
      fila.add("");
      fila.add("0");
      fila.add("");
      fila.add("0");
      fila.add("");
      fila.add(new Long(1));
      fila.add(new Long(1));
      fila.add(new Long(1));
      
      rs.addRow(fila);

      fila = new Vector();
      fila.add("1");
      fila.add("BELCENTER 2");
      fila.add("SVG01-Region10 2");
      fila.add("SG01R10Zona1011 2");
      fila.add("14");
      fila.add("");
      fila.add("0");
      fila.add("");
      fila.add("0");
      fila.add("");
      fila.add("0");
      fila.add("");
      fila.add("0");
      fila.add("");
      fila.add(new Long(1));
      fila.add(new Long(1));
      fila.add(new Long(1));
      
      rs.addRow(fila);

      fila = new Vector();
      fila.add("0");
      fila.add("BELCENTER 2");
      fila.add("");
      fila.add("");
      fila.add("24");
      fila.add("");
      fila.add("0");
      fila.add("");
      fila.add("0");
      fila.add("");
      fila.add("0");
      fila.add("");
      fila.add("0");
      fila.add("");
      fila.add(new Long(1));
      fila.add(new Long(0));
      fila.add(new Long(0));
      
      rs.addRow(fila);
      
      return rs;
    
  }

  private TreeSet generarTreeSet(String sTree) throws Exception {
      traza("Inicio generarTreeSet");
      //Supongo que viene para cada GP de la pantalla:
      //Tipo1 | Region1 | Zona1 | Secuencia1 |#| Tipo1 | Region1 | Zona1 | Secuencia2 ...
      TreeSet ts = new TreeSet();
      if (!sTree.equals("")) {
          do {
              traza("sTree: "+ sTree);
              int pos = sTree.indexOf("|#|");
              String sElem = sTree.substring(0,pos);
              sTree = sTree.substring(pos+3);

              StringTokenizer stkElem = new StringTokenizer(sElem,"|");
              traza("sElem: "+sElem);
              //Armo el DTOElementoPlantilla
              DTOElementoPlantilla dtoEP = new DTOElementoPlantilla();
              dtoEP.setTipoSolicitud(new Long((String) stkElem.nextToken()));
              dtoEP.setRegion(new Long((String) stkElem.nextToken()));
              dtoEP.setZona(new Long((String) stkElem.nextToken()));
              dtoEP.setSecuencia(new Integer((String) stkElem.nextToken()));

              traza("DTOEP: "+ dtoEP);
              ts.add(dtoEP);
              traza("DTOEP despues");

          } while (!sTree.equals(""));

      }

      traza("Fin generarTreeSet");
      return ts;
      
    
  }


  private DruidaConector generarConector(RecordSet rs) throws Exception {
        traza("Inicio generarConector");
        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document docDestino = docBuilder.newDocument();
        Element rowset2 = docDestino.createElement("ROWSET2");
        
        Element rowset = docDestino.createElement("ROWSET");
        rowset.setAttribute("ID", "resultado");
        rowset2.appendChild(rowset);

        for (int i = 0; i < rs.getRowCount(); i++) {
            Element elemRow = docDestino.createElement("ROW");
            rowset.appendChild(elemRow);

            Element elemDato = docDestino.createElement("CAMPO");
            elemDato.setAttribute("NOMBRE", "Ident");
            elemDato.setAttribute("TIPO", "STRING");
            elemDato.setAttribute("LONGITUD", "50");
            Text txt = docDestino.createTextNode(i+"");
            elemDato.appendChild(txt);
            elemRow.appendChild(elemDato);

            for (int k = 0; k < rs.getColumnCount(); k++) {
                elemDato = docDestino.createElement("CAMPO");
                elemDato.setAttribute("NOMBRE", rs.getColumnName(k));
                elemDato.setAttribute("TIPO", "STRING");
                elemDato.setAttribute("LONGITUD", "50");
                String dato = rs.getValueAt(i, k) == null ? "" : rs.getValueAt(i, k).toString();
                txt = docDestino.createTextNode(dato);
                elemDato.appendChild(txt);
                elemRow.appendChild(elemDato);
                
            }

        }

        DruidaConector conectorLista = new DruidaConector();
        conectorLista.setXML(rowset2);

        return conectorLista;
  }

	public void logStackTrace(Throwable e) throws Exception {
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

}
