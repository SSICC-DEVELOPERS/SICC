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
 *----------------------------------------------------
 * Sistema:       Belcorp
 * Modulo:        PED
 * Submódulo:     Monitor
 * Componente:    LPAlarmaPedidos
 * Fecha:         08/09/2004
 * Observaciones:     
 * @version        1.0
 * @autor: Hugo Mansi         
 */
import LPSICCBase;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.ped.DTOAlarmaPedidos;
import es.indra.sicc.dtos.ped.DTOAlarmas;
import es.indra.druida.DruidaConector;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Vector;


public class LPAlarmaPedidos extends LPSICCBase {

	public LPAlarmaPedidos() {
		super();
	}

	public void inicio() throws Exception {
       
		pagina("contenido_pedidos_facturados_alarma");
     	
	}

	public void ejecucion() throws Exception {

	  setTrazaFichero();
	  rastreo();
      try{
        String accion = conectorParametroLimpia( "accion", "", true );
        traza("accion    *****   accion   " + accion);
		if (accion.equals("")) {
          traza("Entro a vacio ");
          String fechaIni = conectorParametroLimpia("hFechaIni","",true);
          traza("Fecha Ini = " + fechaIni);
          String fechaFin = conectorParametroLimpia("hFechaFin","",true);
          traza("Fecha Fin = " + fechaFin);
		  asignarAtributo("VAR","varFechaIni","valor",fechaIni);
		  asignarAtributo("VAR","varFechaFin","valor",fechaFin);
          asignarAtributo("VAR","varOidPais","valor", UtilidadesSession.getPais(this).toString());
          traza("0");
		  String formatoFecha = UtilidadesSession.getFormatoFecha(this);
         
          formatoFecha = formatoFecha.replace('m','M');
		
          traza("1" + formatoFecha); 
          SimpleDateFormat simpledateformat = new SimpleDateFormat(formatoFecha);
          traza("2");  
          DTOAlarmaPedidos dtoe = new DTOAlarmaPedidos();
          traza("3");
		  Date fechaInicio =  simpledateformat.parse(fechaIni);
          traza("4");
   	      Date fechaFinal  = simpledateformat.parse(fechaFin);
          traza("5"); 
          dtoe.setFechaIni(new java.sql.Date(fechaInicio.getTime()));
          traza("6"); 
          dtoe.setFechaFin( new java.sql.Date(fechaFinal.getTime()));
          traza("7"); 
		  dtoe.setOidIdioma(UtilidadesSession.getIdioma(this));
		  dtoe.setOidPais(UtilidadesSession.getPais(this));
          MareBusinessID id = new MareBusinessID("PEDAlarmas");
		  traza("8"); 
  	      Vector param = new Vector();
          traza("9"); 
          param.add(dtoe);          
          traza("10"); 
          param.add(id);
          traza("18881   --->" + param + "    --->"  + dtoe);
          DruidaConector con = this.conectar("ConectorAlarmas",param);
          traza("12");
          DTOAlarmas dtoAlarma = (DTOAlarmas)con.objeto("DTOAlarmas");
		  traza("13" + dtoAlarma);
		  asignarAtributo("VAR", "varTotales", "valor", dtoAlarma.getNumAlarmas()!=null?dtoAlarma.getNumAlarmas().toString():"");
          traza("14");
     	}
	  }catch (Exception ex){
		  	   
		  logStackTrace(ex); 

		  this.lanzarPaginaError(ex);
			
	  }
       traza("Excelente]");
	   getConfiguracionMenu("LPAlarmaPedidos","");

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


	private void traza(String s) throws Exception {
		super.traza(s);
		System.out.println(s);
	}

}
