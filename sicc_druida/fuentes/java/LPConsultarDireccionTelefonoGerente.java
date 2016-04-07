/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.druida.DruidaConector;

import java.io.ByteArrayOutputStream; 
import java.io.PrintStream;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;

//Nuevos
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.UtilidadesBelcorp;


import java.util.Vector;
import java.util.Date;
import es.indra.sicc.dtos.cal.DTOConsultaGerente;


public class LPConsultarDireccionTelefonoGerente extends LPSICCBase {
	
	private String accion = null;
	private Long idioma;
    private Long pais;
    private Long oidCliente;
   	private Long oidZona;
   	private String oidContacto = null;
  	public LPConsultarDireccionTelefonoGerente () {
	    super();
  	}
    
	public void inicio() throws Exception {
 		pagina("contenido_direccion_telefono_gerente_zona_consultar");
 		getConfiguracionMenu("LPConsultarDireccionTelefonoGerente","");
  	}

  	public void ejecucion() throws Exception {
  		rastreo();
      	setTrazaFichero();
      	this.accion = conectorParametroLimpia("accion", "", true);
      	this.idioma = UtilidadesSession.getIdioma(this);
      	this.pais = UtilidadesSession.getPais(this);

		this.oidContacto = conectorParametroLimpia("oidContacto","",true);   
		asignar("VAR", "oidContacto", this.oidContacto);

 
	    traza("accion de entrada " + accion);  
      	asignarAtributo("PAGINA","contenido_direccion_telefono_gerente_zona_consultar", "cod", "0577");
      	asignarAtributo("PAGINA","contenido_direccion_telefono_gerente_zona_consultar", "msgle", "Consultar dirección y teléfono de gerente de zona");
      
      	try{
      	if(accion.equals("")){
			//obtiene el oidCliente y el oidPais 
			traza("falla aqui");
      		cargaInicial();
    	}
      	}catch(Exception  e){
         	traza("ERROR: " + e);
            e.printStackTrace();
            lanzarPaginaError(e);  
        }
}

  
  	private void cargaInicial() throws Exception {
  		try{
  			//Cambio DTOOID por DTOConsultaGerente incidencia BELC300012615.
  			traza("Entra en carga inicial");
        	DTOConsultaGerente dtoe = new DTOConsultaGerente ();
            dtoe.setOidPais(this.pais);
            dtoe.setOidIdioma(this.idioma);
            this.oidCliente = new Long(conectorParametroLimpia("oidCliente","", true));
			traza("this.oidCliente"+this.oidCliente);
            dtoe.setOidCliente(this.oidCliente);
            traza("antes de zona");
            this.oidZona = new Long(conectorParametroLimpia("oidZona", "", true));
            traza("Despues de zona");
            dtoe.setOidZona(this.oidZona);
            Vector paramConector = new Vector();
            paramConector.add(dtoe);
            MareBusinessID mid = new MareBusinessID("CALConsultarDireccionTelefonoGerente");
            paramConector.add(mid);
            traza("antes de llamar al conector objeto");
            DruidaConector conector = conectar("ConectorConsultarDireccionTelefonoGerente", paramConector);
            traza("Despues de conectar");
            DTOSalida dtoSalida = (DTOSalida)conector.objeto("DTOSalida");
            if (dtoSalida.getResultado().getValueAt(0,0)!=null){
            	asignar("LABELC","lbldtNombre1",(dtoSalida.getResultado().getValueAt(0,0)).toString());
        	}
            if (dtoSalida.getResultado().getValueAt(0,1)!=null){
            	asignar("LABELC","lbldtNombre2",(dtoSalida.getResultado().getValueAt(0,1)).toString());
        	}
        	if (dtoSalida.getResultado().getValueAt(0,2)!=null){
            	asignar("LABELC","lbldtApellido1",(dtoSalida.getResultado().getValueAt(0,2)).toString());
        	}
        	if (dtoSalida.getResultado().getValueAt(0,3)!=null){
            	asignar("LABELC","lbldtApellido2",(dtoSalida.getResultado().getValueAt(0,3)).toString()); 
        	}
        	if (dtoSalida.getResultado().getValueAt(0,4)!=null){
        		traza("Entra el telefono");
            	asignar("LABELC","lbldtTelefono",(dtoSalida.getResultado().getValueAt(0,4)).toString());
        	}
            asignar("LABELC","lbldtTipoComunicacion","Telefono");
            /*if (dtoSalida.getResultado().getValueAt(0,5)!= null){
            	asignar("LABELC","lbldtTelefono",(dtoSalida.getResultado().getValueAt(0,5)).toString());
        	}*/
            //Incidencia BELC300012612
            //Recorremos todas las filas recuperadas en el recordSet: 
           	RecordSet rs = new RecordSet();
           	rs.addColumn(new String("oid"));
           	rs.addColumn(new String("DIRECCION"));
			rs.addColumn(new String("DES_ABRV_TIPO_VIA"));
			rs.addColumn(new String("VAL_NOMB_VIA"));
			rs.addColumn(new String("NUM_PPAL"));
			rs.addColumn(new String("IND_DIRE_PPAL"));
            Vector cols= rs.getColumnIdentifiers();
            Vector row = null;
            traza("Antes for");
            for (int i=0;i<dtoSalida.getResultado().getRowCount();i++){
            	row = new Vector();
                traza("Vector creado");
                row.add(dtoSalida.getResultado().getValueAt(i,0));
                row.add(dtoSalida.getResultado().getValueAt(i,5));
                row.add(dtoSalida.getResultado().getValueAt(i,6));
                row.add(dtoSalida.getResultado().getValueAt(i,7));
                row.add(dtoSalida.getResultado().getValueAt(i,8));
                row.add(dtoSalida.getResultado().getValueAt(i,9));
                traza("parametro anadido");
             	rs.addRow(row);            
            	traza("row anadida al rs");
            }
            traza(rs);
            Vector cols1 = rs.getColumnIdentifiers();
            DruidaConector conectorCargaLista = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rs, cols1);
			asignar("LISTAEDITABLE", "listado1", conectorCargaLista, "DTOSalida.combo_ROWSET");
            
            
            /*RecordSet rs = new RecordSet();
            
            
			Vector cols= rs.getColumnIdentifiers();
			traza("DTOSalida");
			traza(dtoSalida);
        	for (int i=0;i<dtoSalida.getResultado().getRowCount();i++){
        		if (dtoSalida.getResultado().getValueAt(i,5)!= null){
            		rs.setValueAt(dtoSalida.getResultado().getValueAt(i,5),i,0);
            	}
            	if (dtoSalida.getResultado().getValueAt(i,6)!= null){
            		rs.setValueAt(dtoSalida.getResultado().getValueAt(i,6),i,1);
            	}
            	if (dtoSalida.getResultado().getValueAt(i,7)!= null){
            		rs.setValueAt(dtoSalida.getResultado().getValueAt(i,7),i,2);
            	}
            	if (dtoSalida.getResultado().getValueAt(i,8)!= null){
            		rs.setValueAt(dtoSalida.getResultado().getValueAt(i,8),i,3);
            	}
            	if (dtoSalida.getResultado().getValueAt(i,9)!= null){
            		rs.setValueAt(dtoSalida.getResultado().getValueAt(i,9),i,4);
            	}
        	}
        	traza("Recordset");
        	traza(rs.getRecords());
            if (rs != null) {
            	traza("Entra en distinto de null");
            	DruidaConector conectorCargaLista = UtilidadesBelcorp.generarConector("DTOSalida.combo_ROWSET",rs,cols);
                asignar("LISTAEDITABLE", "listado1", conectorCargaLista, "DTOSalida.combo_ROWSET");
        	}      */
        	traza("Sale de carga inicial");      
         }catch(Exception  e){
         	traza("ERROR: " + e);
            e.printStackTrace();
            lanzarPaginaError(e);  
         }  	
	}	
}