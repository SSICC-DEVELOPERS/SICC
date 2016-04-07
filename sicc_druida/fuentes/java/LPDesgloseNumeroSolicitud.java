/**
 * Sistema:     Belcorp
 * Modulo:      PED
 * Fecha:       02/11/2004
 * @version     1.0
 * @autor       Maximiliano Dello Russo
 */

//import LPSICCBase;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.druida.DruidaConector;
import es.indra.sicc.util.DTOOID;
import es.indra.mare.common.mln.MareBusinessID;
import java.util.Vector;
import java.util.Iterator;
import es.indra.sicc.dtos.ped.DTOTipoSolicitud;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.dtos.ped.DTOEDesglose;
import java.util.Date;
import java.text.SimpleDateFormat;
import es.indra.sicc.dtos.ped.DTOCargarPaginaDesglose;



public class LPDesgloseNumeroSolicitud extends LPSICCBase{
	private String accion;

	public LPDesgloseNumeroSolicitud(){
		super();
	}
	
	public void inicio() throws Exception {}

	public void ejecucion() throws Exception{
		setTrazaFichero();
		traza("> Entrando a LPDesgloseNumeroSolicitud...");
		accion = conectorParametroLimpia("accion", "", true);
		traza("Accion: " + accion);
		try{
			
			// -> Asignar página "contenido_desglose_numero_solicitud_consultar" 
			traza("Seteando página");
			pagina("contenido_desglose_numero_solicitud_consultar");
		    
			if(accion.equals("acceso")){
			traza("entro por acceso");
			asignarAtributoPagina("cod", "0677");
			}

			if(accion.equals("contenido")){
			traza("entro por contenido");
			asignarAtributoPagina("cod", "0679");
			}

			if(accion.equals("estados")){
			traza("entro por estados");
			asignarAtributoPagina("cod", "0678");
			}

			if(accion.equals("tipocliente")){
			traza("entro por tipocliente");
			asignarAtributoPagina("cod", "0676");
			}
		
			// -> Tomar de sesión la variable "datosDesglose" de tipo "DTOEDesglose" 
			//    y mapear en pantalla los siguientes datos exclusivamente: 
			traza("Tomando dto de sesion");
			DTOEDesglose dto = (DTOEDesglose)conectorParametroSesion("datosDesglose");
			traza("dto tomado: " + dto);
			// fechaInicio, 
			Date fecha = dto.getFechaInicio();
			traza("Armando formato para fecha");
			String formatString = UtilidadesSession.getFormatoFecha(this);
			formatString = formatString.replace('m','M'); 
			SimpleDateFormat formato = new SimpleDateFormat(formatString);
			if( fecha != null ){
				traza("Asignando fecha: " + formato.format(fecha));
				asignarAtributo("VAR", "fechaInicio", "valor", formato.format(fecha));
			}
			// fechaFin,
			fecha = dto.getFechaFin();
			if( fecha != null ){
				traza("Asignando fechaFin: " + formato.format(fecha));
				asignarAtributo("VAR", "fechaFin", "valor", formato.format(fecha));
			}
			// tipoSolicitud,
			if( dto.getTipoSolicitud() != null ){
				traza("oidTipoSolicitud: " + dto.getTipoSolicitud().toString());
				asignarAtributo("VAR", "oidTipoSolicitud", "valor", dto.getTipoSolicitud().toString());
			}
			// marca,
			if( dto.getMarca() != null ){
				traza("marca: " + dto.getMarca().toString());
				asignarAtributo("VAR", "marca", "valor", dto.getMarca().toString());
			}
			// canal,
			if( dto.getCanal() != null ){
				asignarAtributo("VAR", "canal", "valor", dto.getCanal().toString());
			}
			// zona,
			if( dto.getZona() != null ){
				asignarAtributo("VAR", "zona", "valor", dto.getZona().toString());
			}
			// grupoProcesos
			if( dto.getGrupoProcesos() != null ){
				asignarAtributo("VAR", "grupoProcesos", "valor", dto.getGrupoProcesos().toString());
			}
			// tipoCliente,
			if( dto.getTipoCliente() != null ){
				asignarAtributo("VAR", "tipoCliente", "valor", dto.getTipoCliente().toString() );
			}
			// subtipoCliente,
			if( dto.getSubtipoCliente() != null ){
				asignarAtributo("VAR", "subtipoCliente", "valor", dto.getSubtipoCliente().toString() );
			}
			// tipoClasificacion,
			if( dto.getTipoClasificacion() != null ){
				asignarAtributo("VAR", "tipoClasificacion", "valor", dto.getTipoClasificacion().toString());
			}
			// clasificacion,
			if( dto.getClasificacion() != null ){
				asignarAtributo("VAR", "clasificacion", "valor", dto.getClasificacion().toString() );
			}
			// acceso y			
			if( dto.getAcceso() != null ){
				asignarAtributo("VAR", "acceso", "valor", dto.getAcceso().toString() );
			}
			// estadoSolicitud.
			if( dto.getEstadoSolicitud() != null ){
				asignarAtributo("VAR", "estadoSolicitud", "valor", dto.getEstadoSolicitud().toString());			
			}
			getConfiguracionMenu("LPDesgloseEstados", "buscar");
			// -> Mostrar página
			asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
			asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
		}catch(Exception e){
			traza("> EXCEPCION: " + e.toString());
			traza("Lanzando página error");
			lanzarPaginaError(e);
			traza("--- Página lanzada ---");			
		}
	}
}


	
