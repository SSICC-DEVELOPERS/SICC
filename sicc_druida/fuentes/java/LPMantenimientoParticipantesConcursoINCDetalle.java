import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.math.BigDecimal;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.StringTokenizer;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import es.indra.sicc.dtos.mae.DTOTipoSubtipo;
import es.indra.sicc.dtos.mae.DTOClasificaciones;
import es.indra.sicc.dtos.inc.DTOParticipantesDetalle;

public class LPMantenimientoParticipantesConcursoINCDetalle extends LPSICCBase {	
    public LPMantenimientoParticipantesConcursoINCDetalle () { super(); }
	private String accion = null;
	private String opcionMenu = null;
	private String sPais = null;     
	private String sIdioma = null;
	private Long lPais = null;     
	private Long lIdioma = null;

	public void inicio() throws Exception { }
  
    public void ejecucion() throws Exception {
		setTrazaFichero();	    
	    
		try  {
			traza("LPMantenimientoParticipantesConcursoINCDetalle.ejecucion() - Entrada");

			accion = conectorParametroLimpia("accion", "", true);
			opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
			sPais = UtilidadesSession.getPais(this).toString();
			sIdioma = UtilidadesSession.getIdioma(this).toString();
			lPais = UtilidadesSession.getPais(this);
			lIdioma = UtilidadesSession.getIdioma(this);

			traza("**** accion : " + accion);
			traza("**** opcionMenu : " + opcionMenu);

			if(opcionMenu.equals("insertar") ) {
				pagina("contenido_participantes_concurso_detalle_insertar");
			}
			else if(opcionMenu.equals("consultar") || opcionMenu.equals("eliminar") || opcionMenu.equals("modificar")) {
				pagina("contenido_participantes_concurso_detalle_consultar");
			}

			getFormatosValidaciones();

			asignarAtributo("VAR", "accion", "valor", accion); 
			asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu); 
			asignarAtributo("VAR", "varPais", "valor", sPais); 
			asignarAtributo("VAR", "varIdioma", "valor", sIdioma); 
			
			if (accion.equals("")) {
				cargarPagina();
			}
			else if (accion.equals("recargaTipoClasificacion")) {
				recargarTipoClasificacion();
			}
			else if (accion.equals("guardar")) {
				guardar();
			}
			else if (accion.equals("detalle")) {
				detalle();
			}
			else if (accion.equals("modificar")){
				modificar();
			}

			cargarMenuSecundario();
			traza("LPMantenimientoParticipantesConcursoINCDetalle.ejecucion() - Salida");
		}
		catch ( Exception e )  {			
            e.printStackTrace();
			traza("Exception en LPMantenimientoParticipantesConcursoINCDetalle");
			traza(e);
			lanzarPaginaError(e);
	    }
	}


	public void cargarPagina() throws Exception {
		traza("LPMantenimientoParticipantesConcursoINCDetalle.cargarPagina() - Entrada");

		DTOBelcorp dtoe = new DTOBelcorp();
		dtoe.setOidIdioma(lIdioma);
		dtoe.setOidPais(lPais);

		MareBusinessID businessID = new MareBusinessID("INCObtenerGruposCliente");
		Vector parametros = new Vector();
		parametros.add(dtoe);
		parametros.add(businessID);

		traza("******** Antes de conectar");
		DruidaConector con = conectar("ConectorObtenerGruposCliente", parametros);
		traza("******** Despues de conectar");

		DTOSalida dtoSalida = (DTOSalida)con.objeto("DTOSalida");
		traza("******** dtoSalida " + dtoSalida);

		traza("******** Cargando combo cbGrupoCliente");
        this.asignar("COMBO", "cbGrupoCliente", 
		generarConectorComboGrupoCliente(dtoSalida.getResultado()));

		traza("******** Asignando variable oculta ");
        asignarAtributo("VAR", "listaGrupoClientes", "valor", 
		generarCadenaListaGrupoClientes(dtoSalida.getResultado()));

		MareBusinessID businessID2 = new MareBusinessID("MAEObtenerTipoSubtipo");
		Vector parametros2 = new Vector();
		parametros2.add(dtoe);
		parametros2.add(businessID2);

		traza("******** Antes de conectar");
		DruidaConector con2 = conectar("ConectorTipoSubtipo", parametros2);
		traza("******** Despues de conectar");

		DTOTipoSubtipo dtoTipoSubtipo = (DTOTipoSubtipo)con2.objeto("DTOSalida");
		traza("******** dtoTipoSubtipo " + dtoTipoSubtipo);

		RecordSet rsTipos = dtoTipoSubtipo.getTipos();

		traza("******** Cargando combo cbTipoCliente");
		this.asignar("COMBO", "cbTipoCliente", 
		UtilidadesBelcorp.generarConector("dtoSalida", rsTipos, rsTipos.getColumnIdentifiers()));

		traza("******** Asignando variable oculta ");
		RecordSet rsSubTipos = dtoTipoSubtipo.getSubtipos();

		asignarAtributo("VAR", "listaSubtipos", "valor", 
		generarCadenaListaSubTipos(rsSubTipos));

		traza("LPMantenimientoParticipantesConcursoINCDetalle.cargarPagina() - Salida");
	}

	public DruidaConector generarConectorComboGrupoCliente(RecordSet rsOriginal) throws Exception{
		traza("LPMantenimientoParticipantesConcursoINCDetalle.generarConectorComboGrupoCliente(RecordSet rs) - Entrada");		
		
		int cant = rsOriginal.getRowCount();
		traza("*** cant " + cant);	
	    RecordSet rs = new RecordSet();
		Vector v = null;
    
		rs.addColumn("OID");
		rs.addColumn("DESC");
    
		for (int i = 0; i<cant; i++){      
			v = new Vector();
            v.add(rsOriginal.getValueAt(i, 0));
            v.add(rsOriginal.getValueAt(i, 1));
			rs.addRow(v);
	    }
              
	    traza("*************** rs " + rs);
	    traza("LPMantenimientoParticipantesConcursoINCDetalle.generarConectorComboGrupoCliente(RecordSet rs) - Salida");	
	    return UtilidadesBelcorp.generarConector("dtoSalida", rs, rs.getColumnIdentifiers());  	  
	}

	public String generarCadenaListaGrupoClientes(RecordSet rsOriginal) throws Exception{
		traza("LPMantenimientoParticipantesConcursoINCDetalle.generarCadenaListaGrupoClientes(RecordSet rsOriginal) - Entrada");	
	
		String cadena = "";
		int cant = rsOriginal.getRowCount();
		traza("*** cant " + cant);	
		
		for(int i=0; i<cant;i++){
			String oidTemp = rsOriginal.getValueAt(i,0).toString();
		    String desTemp = rsOriginal.getValueAt(i,2).toString();
	
			if(i==0) {
				cadena = cadena + oidTemp + "," + desTemp;
			}
			else {
				cadena = cadena + "|" +oidTemp + "," + desTemp;
			}					
  	    }
		
		traza("*************** cadena " + cadena);
	    traza("LPMantenimientoParticipantesConcursoINCDetalle.generarCadenaListaGrupoClientes(RecordSet rsOriginal) - Salida");	
		return cadena;
	}

	public String generarCadenaListaSubTipos(RecordSet rsOriginal) throws Exception{
		traza("LPMantenimientoParticipantesConcursoINCDetalle.generarCadenaListaSubTipos(RecordSet rsOriginal) - Entrada");	
	
		String cadena = "";
		int cant = rsOriginal.getRowCount();
		traza("*** cant " + cant);	
		
		for(int i=0; i<cant;i++){
			String oidTemp = rsOriginal.getValueAt(i,0).toString();
			String oidTemp2 = rsOriginal.getValueAt(i,1).toString();
		    String desTemp = rsOriginal.getValueAt(i,2).toString();
	
			if(i==0) {
				cadena = cadena + oidTemp + "," + oidTemp2 + "," + desTemp;
			}
			else {
				cadena = cadena + "|" + oidTemp + "," + oidTemp2 + "," + desTemp;
			}					
  	    }
		
		traza("*************** cadena " + cadena);
	    traza("LPMantenimientoParticipantesConcursoINCDetalle.generarCadenaListaSubTipos(RecordSet rsOriginal) - Salida");	
		return cadena;
	}

	public void recargarTipoClasificacion() throws Exception {
		traza("LPMantenimientoParticipantesConcursoINCDetalle.recargarTipoClasificacion() - Entrada");		
		pagina("salidaGenerica");
		this.asignarAtributo("VAR", "cerrarVentana", "valor", "false"); 

		String oidSubTipoCliente = conectorParametroLimpia("oidSubTipoCliente", "", true);
		traza("**** oidSubTipoCliente " + oidSubTipoCliente);

		DTOOID dto = new DTOOID();
		dto.setOidPais(lPais);
		dto.setOidIdioma(lIdioma);
		dto.setOid(new Long(oidSubTipoCliente));

		MareBusinessID businessID = new MareBusinessID("MAEObtenerClasificacionesSubtipo");
		Vector parametros = new Vector();
		parametros.add(dto);
		parametros.add(businessID);

		try {
			traza("******** Antes de conectar");
			DruidaConector con = conectar("ConectorObtenerClasificacionesSubtipo", parametros);
			traza("******** Despues de conectar");

			DTOClasificaciones dtoClasificaciones = (DTOClasificaciones)con.objeto("DTOSalida");
			traza("******** dtoClasificaciones " + dtoClasificaciones);

			String strTipoClasificacion = 
			generarCadenaTipoClasificacion(dtoClasificaciones.getTipoClasificacion());

			String strClasificacion = 
			generarCadenaClasificacion(dtoClasificaciones.getClasificacion());

			traza("******** vivi6 strTipoClasificacion " + strTipoClasificacion);
			traza("******** strClasificacion " + strClasificacion);
			
			// vbongiov -- RI- 20090851 -- 4/03/2009				
			strTipoClasificacion = replace(strTipoClasificacion, "'", " ");
			strClasificacion = replace(strClasificacion, "'", " ");			

			traza("******** sin comilla strTipoClasificacion " + strTipoClasificacion);
			traza("******** sin comilla strClasificacion " + strClasificacion);

			traza("LPMantenimientoParticipantesConcursoINCDetalle.recargarTipoClasificacion() - Salida");
			asignarAtributo("VAR","ejecutar","valor","finalizaRecargarTipoClasificacionOK('" +
			strTipoClasificacion + "','" + strClasificacion + "')");
		}
		catch (Exception e) {
             asignarAtributo("VAR", "ejecutarError", "valor", "finalizaRecargarTipoClasificacionERR()");           
             throw e;
         } 		
	}
	
	// vbongiov -- RI- 20090851 -- 4/03/2009
	public String replace(String s, String s1, String s2) throws Exception {
		traza("replace(String s, String s1, String s2):Entrada");
        int i = 0;
        int j = 0;
        int k = s1.length();
        StringBuffer stringbuffer = null;
        String s3 = s;
		while ((j = s.indexOf(s1, i)) >= 0) {
			if(stringbuffer == null) {
				stringbuffer = new StringBuffer(s.length() * 2);
			}

			stringbuffer.append(s.substring(i, j));
			stringbuffer.append(s2);

			i = j + k;
		}
		if (i != 0) {
			stringbuffer.append(s.substring(i));
			s3 = stringbuffer.toString();
		}
		traza("replace(String s, String s1, String s2):Salida");
        return s3;
    }

    
	public String generarCadenaTipoClasificacion(RecordSet rsOriginal) throws Exception{
		traza("LPMantenimientoParticipantesConcursoINCDetalle.generarCadenaTipoClasificacion(RecordSet rsOriginal) - Entrada");	
	
		String cadena = "";
		int cant = rsOriginal.getRowCount();
		traza("*** cant " + cant);	
		
		for(int i=0; i<cant;i++){
			String oidTemp = rsOriginal.getValueAt(i,0).toString();
		    String desTemp = rsOriginal.getValueAt(i,1).toString();
	
			if(i==0) {
				cadena = cadena + oidTemp + "," + desTemp;
			}
			else {
				cadena = cadena + "|" + oidTemp +  "," + desTemp;
			}					
  	    }
		
		traza("*************** cadena " + cadena);
	    traza("LPMantenimientoParticipantesConcursoINCDetalle.generarCadenaTipoClasificacion(RecordSet rsOriginal) - Salida");	
		return cadena;
	}

	public String generarCadenaClasificacion(RecordSet rsOriginal) throws Exception{
		traza("LPMantenimientoParticipantesConcursoINCDetalle.generarCadenaClasificacion(RecordSet rsOriginal) - Entrada");	
	
		String cadena = "";
		int cant = rsOriginal.getRowCount();
		traza("*** cant " + cant);	
		
		for(int i=0; i<cant;i++){
			String oidTemp = rsOriginal.getValueAt(i,0).toString();
			String desTemp = rsOriginal.getValueAt(i,1).toString();
			String oidTemp2 = rsOriginal.getValueAt(i,2).toString();		    
	
			if(i==0) {
				cadena = cadena + oidTemp + "," + desTemp + "," + oidTemp2;
			}
			else {
				cadena = cadena + "|" + oidTemp + "," + desTemp + "," + oidTemp2;
			}					
  	    }
		
		traza("*************** cadena " + cadena);
	    traza("LPMantenimientoParticipantesConcursoINCDetalle.generarCadenaClasificacion(RecordSet rsOriginal) - Salida");	
		return cadena;
	}

	public void guardar() throws Exception {
		traza("LPMantenimientoParticipantesConcursoINCDetalle.guardar() - Entrada");
		pagina("salidaGenerica");

		String oidCabecera = conectorParametroLimpia("oidCabecera", "", true);
		String tipoCliente = conectorParametroLimpia("tipoCliente", "", true);
		String subtipoCliente = conectorParametroLimpia("subtipoCliente", "", true);
		String tipoClasificacion = conectorParametroLimpia("tipoClasificacion", "", true);
		String clasificacion = conectorParametroLimpia("clasificacion", "", true);
		String descripcion = conectorParametroLimpia("descripcion", "", true);
		String oidDetalle = conectorParametroLimpia("oidDetalle", "", true);

		traza("**** oidCabecera " + oidCabecera);
		traza("**** tipoCliente " + tipoCliente);
		traza("**** subtipoCliente " + subtipoCliente);
		traza("**** tipoClasificacion " + tipoClasificacion);
		traza("**** clasificacion " + clasificacion);
		traza("**** descripcion " + descripcion);
		traza("**** oidDetalle " + oidDetalle);

		DTOParticipantesDetalle dto = new DTOParticipantesDetalle();
		dto.setOidCabecera(new Long(oidCabecera));
		dto.setTipoCliente(new Long(tipoCliente));

		if(!subtipoCliente.equals("")) {
			dto.setSubtipoCliente(new Long(subtipoCliente));
		}

		if(!tipoClasificacion.equals("")) {
			dto.setTipoClasificacion(new Long(tipoClasificacion));
		}

		if(!clasificacion.equals("")) {
			dto.setClasificacion(new Long(clasificacion));
		}

		if(!oidDetalle.equals("")){
			dto.setOid(new Long(oidDetalle));
		}
		if(!descripcion.equals("")){
			dto.setDescripcion(descripcion);
		}

  	    MareBusinessID businessID = new MareBusinessID("INCGuardarParticipantesDetalle");
		Vector parametros = new Vector();
		parametros.add(dto);
		parametros.add(businessID);

		try {
	        traza("******************* Antes de conectar");
			DruidaConector con = conectar("ConectorGuardarParticipantesDetalle", parametros);
			traza("******************* Despues de conectar");
			traza("LPMantenimientoParticipantesConcursoINCDetalle.guardar() - Salida");
  		    asignarAtributo("VAR","ejecutar","valor","guardarOK()");        
		}
		catch(Exception e) {
		    asignarAtributo("VAR", "ejecutarError", "valor", "guardarERR()");  
	        throw e;
		}     		
	}

	public void detalle () throws Exception {
		traza("LPMantenimientoParticipantesConcursoINCDetalle.detalle() - Entrada");
		String oidCabecera = conectorParametroLimpia("oidCabecera", "", true);
		String IDclasificacion = conectorParametroLimpia("IDclasificacion", "", true);
		String tipoCliente = conectorParametroLimpia("tipoCliente", "", true);
		String subtipoCliente = conectorParametroLimpia("subtipoCliente", "", true);
		String tipoClasificacion = conectorParametroLimpia("tipoClasificacion", "", true);
		String clasificacion = conectorParametroLimpia("clasificacion", "", true);
		String oidGrupo = conectorParametroLimpia("oidGrupo", "", true);
		String accion = conectorParametroLimpia("accion", "", true);
		String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
		String descripcion = conectorParametroLimpia("descripcion", "", true);

		traza("**** oidCabecera " + oidCabecera);
		traza("**** IDclasificacion " + IDclasificacion);
		traza("**** tipoCliente " + tipoCliente);
		traza("**** subtipoCliente " + subtipoCliente);
		traza("**** tipoClasificacion " + tipoClasificacion);
		traza("**** clasificacion " + clasificacion);
		traza("**** oidGrupo " + oidGrupo);		
		traza("**** accion " + accion);
		traza("**** opcionMenu " + opcionMenu);
		traza("**** descripcion " + descripcion);

		pagina("contenido_participantes_concurso_detalle_insertar");
		cargarPagina();

		asignarAtributo("VAR", "oidCabecera", "valor", oidCabecera);
		asignarAtributo("VAR", "IDclasificacion", "valor", IDclasificacion);
 	    asignarAtributo("VAR", "tipoCliente", "valor", tipoCliente);
  	    asignarAtributo("VAR", "subtipoCliente", "valor", subtipoCliente);
  	    asignarAtributo("VAR", "tipoClasificacion", "valor", tipoClasificacion);
  	    asignarAtributo("VAR", "clasificacion", "valor", clasificacion);
  	    asignarAtributo("VAR", "oidGrupo", "valor", oidGrupo);
 	    asignarAtributo("VAR", "accion", "valor", accion);
 	    asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
 	    asignarAtributo("VAR", "descripcion", "valor", descripcion);

		traza("LPMantenimientoParticipantesConcursoINCDetalle.detalle() - Salida");
	}

	 private void cargarMenuSecundario() throws Exception {      
		traza("LPMantenimientoParticipantesConcursoINCDetalle.cargarMenuSecundario() - Entrada");

		if (opcionMenu.equals("insertar")) {
			getConfiguracionMenu("LPMantenimientoParticipantesConcursoINCDetalle","insertar");
	        asignarAtributoPagina("cod","IncPartiConcuDetal.create.label");
		}
		else if (opcionMenu.equals("consultar")) {
			getConfiguracionMenu("LPMantenimientoParticipantesConcursoINCDetalle","consultar");
	        asignarAtributoPagina("cod","IncPartiConcuDetal.query.label");
		}
		else if (opcionMenu.equals("eliminar")) {
			getConfiguracionMenu("LPMantenimientoParticipantesConcursoINCDetalle","eliminar");
	        asignarAtributoPagina("cod","IncPartiConcuDetal.remove.label");
		}
		else if (opcionMenu.equals("modificar")) {
			getConfiguracionMenu("LPMantenimientoParticipantesConcursoINCDetalle","modificar");
	        asignarAtributoPagina("cod","IncPartiConcuDetal.update.label");
		}


 		traza("LPMantenimientoParticipantesConcursoINCDetalle.cargarMenuSecundario() - Salida");
	 }

	public void modificar () throws Exception {
		traza("LPMantenimientoParticipantesConcursoINCDetalle.modificar() - Entrada");
		String oidCabecera = conectorParametroLimpia("oidCabecera", "", true);
		String IDclasificacion = conectorParametroLimpia("IDclasificacion", "", true);
		String tipoCliente = conectorParametroLimpia("tipoCliente", "", true);
		String subtipoCliente = conectorParametroLimpia("subtipoCliente", "", true);
		String tipoClasificacion = conectorParametroLimpia("tipoClasificacion", "", true);
		String clasificacion = conectorParametroLimpia("clasificacion", "", true);
		String oidGrupo = conectorParametroLimpia("oidGrupo", "", true);
		String accion = conectorParametroLimpia("accion", "", true);
		String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
		String oidDetalle = conectorParametroLimpia("oidDetalle", "", true);
		String descripcion = conectorParametroLimpia("descripcion", "", true);

		traza("**** oidCabecera " + oidCabecera);
		traza("**** IDclasificacion " + IDclasificacion);
		traza("**** tipoCliente " + tipoCliente);
		traza("**** subtipoCliente " + subtipoCliente);
		traza("**** tipoClasificacion " + tipoClasificacion);
		traza("**** clasificacion " + clasificacion);
		traza("**** oidGrupo " + oidGrupo);		
		traza("**** accion " + accion);
		traza("**** opcionMenu " + opcionMenu);
		traza("**** oidDetalle " + oidDetalle);
		traza("**** descripcion " + descripcion);

		pagina("contenido_participantes_concurso_detalle_insertar");
		cargarPagina();

		asignarAtributo("VAR", "oidCabecera", "valor", oidCabecera);
		asignarAtributo("VAR", "IDclasificacion", "valor", IDclasificacion);
 	    asignarAtributo("VAR", "tipoCliente", "valor", tipoCliente);
  	    asignarAtributo("VAR", "subtipoCliente", "valor", subtipoCliente);
  	    asignarAtributo("VAR", "tipoClasificacion", "valor", tipoClasificacion);
  	    asignarAtributo("VAR", "clasificacion", "valor", clasificacion);
  	    asignarAtributo("VAR", "oidGrupo", "valor", oidGrupo);
 	    asignarAtributo("VAR", "accion", "valor", accion);
 	    asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
	    asignarAtributo("VAR", "oidDetalle", "valor", oidDetalle);
	    asignarAtributo("VAR", "descripcion", "valor", descripcion);

		traza("LPMantenimientoParticipantesConcursoINCDetalle.modificar() - Salida");
	}
}