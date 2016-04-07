package es.indra.sicc.logicanegocio.zon;
import es.indra.sicc.util.UtilidadesLog;

/**
 * En esta clase se definen los mensajes de error que son usados para 
 * reportar el estado de los procesamiento de los ficheros en el ZONLog. 
 * Para cada error se le debe asignar un codigo y una descripción, del tipo: 
 * 
 * public static final String M00001 = "El Territorio tiene unidades inferiores"; 
 * 
 * Ademas tiene un metodo obtenerDescMen(String codigo), que retorna el mensaje que
 * esta guardado bajo ese codigo, si el cogi no exite, retorna: 
 * "ERROR: CODIGO NO EXISTENTE"
 * 
 */
public class FileInterfaceMensajes  {

  public static final String M00001 = "La Unidad Administrativa tiene unidades inferiores"; 
	public static final String M00002 = "La Unidad Administrativa tiene clientes asignados"; 
	public static final String M00003 = "No existe la Unidad Administrativa"; 	
	public static final String M00004 = "Inicio procesarEliminarUA()"; 	
	public static final String M00005 = "Fin procesarEliminarUA()";
  public static final String M00006 = "Pais no tiene Estructura Geopolitica Definida"; 	
  public static final String M00007 = "Pais no tiene Unidades Geográficas Asociadas";
  public static final String M00008 = "Territorio no Existe";
  public static final String M00009 = "UBIGEO no existe";
  public static final String M00010 = "Territorio ya asignado a la Unidad Geográfica"; 	
  public static final String M00011 = "Territorio asignado a otra Unidad Geográfica";
  public static final String M00012 = "Cabecera del fichero incorrecta";
  public static final String M00013 = "Registro del fichero incorrecto";
  public static final String M00014 = "Unidad Geograficas no corresponden con Estructura Geopolitica"; 	
  public static final String M00015 = "Error al insertar la Unidad Geográfica";
  public static final String M00016 = "Error al borrar la Unidad Geográfica";
  public static final String M00017 = "Error al modificar la Unidad Geográfica";
  public static final String M00018 = "Gerente a asignar no definido en MAE:DatosClientesBasicos";
  public static final String M00019 = "Unidad Administrativa superior no existe";
  public static final String M00020 = "Periodo no Existe" ;
  public static final String M00021 = "Existe mas de un Territorio por codigo y Pais";
  public static final String M00022 = "Existe mas de un Tipo Via por codigo";
  public static final String M00023 = "No existe el Tipo de Vía";
  public static final String M00024 = "Existe mas de una Via por Pais, Nombre y TipoVia";
  public static final String M00025 = "Vía no Existe";
  public static final String M00026 = "Error al Crear Segmento Via";
  public static final String M00027 = "Segmento de Via no Existe";
  public static final String M00028 = "Existe mas de Segmento Via por Territorio y Via";    
  public static final String M00029 = "Error al modificar Territorio";    
  public static final String M00030 = "Error al insertar la Unidad Administrativa";
  public static final String M00031 = "Baja de territorio no asociado";
  public static final String M00032 = "No existe Segmento Via";
  public static final String M00033 = "No es un fichero de asignación de territorios";
  public static final String M00034 = "La unidad geográfica había sido dada de alta previamente";
  public static final String M00035 = "Pais no existe";
  public static final String M00036 = "Marca no existe";
  public static final String M00037 = "Canal no existe";
  public static final String M00038 = "La unidad Administrativa ya existe";
  public static final String M00039 = "Territorio ya asignado a la sección indicada";
  public static final String M00040 = "Territorio ya asociado a una subgerencia del pais,canal y marca indicado";
  public static final String M00041 = "NSE1 no válido";
  public static final String M00042 = "NSE2 no válido";
  public static final String M00043 = "UBIGEO no Existe";
  public static final String M00044 = "Operacion incorrecta";
  public static final String M00045 = "La unidad geográfica no existe";
  public static final String M00046 = "Fin procesarCrearUA()";
  public static final String M00048 = "Para poder realizar la operacion falta el Dato";
  public static final String M00049 = "No existe la UA del Dato";
  public static final String M00050 = "Ya existe la UA del Dato";
  public static final String M00051 = "Faltan datos para poder realizar la operacion";
  public static final String M00052 = "Falta el codigo de cliente";
  public static final String M00053 = "No existe el codigo de cliente";
  public static final String M00054 = "El cliente ya tiene una UA para el periodo indicado";
  
  //(04/06/2007) agregado por incidencia Sicc-20070266 (Sapaza)
  public static final String M00055 = "Error al ubicar periodo inicio y/o fin";
  public static final String M00056 = "No se encontro Datos Adicionales para el cliente";
  public static final String M00057 = "Error al actualizar Status del cliente";
  public static final String M00058 = "Error al actualizar Direccion del cliente";  
  public static final String M00059 = "No se encontro Historico Status para el periodoInicio";
	public static final String M00060 = "No existe Unidad Administrativa Activa"; 	
  public static final String M00061 = "No existe Ultima Unidad Administrativa con periodoFin nulo"; 	  
  
	public String obtenerDescMen (String cod) {
    UtilidadesLog.info("FileInterfaceMensajes.obtenerDescMen (String cod): Entrada");
		try {            
      UtilidadesLog.info("FileInterfaceMensajes.obtenerDescMen (String cod): Salida");
			return cod + " - " + (String)this.getClass().getField(cod).get(new Object());			
		}
    catch (Exception e) {
      UtilidadesLog.info("FileInterfaceMensajes.obtenerDescMen (String cod): Salida");
			return "ERROR: CODIGO NO EXISTENTE";
		}
	} 

	public FileInterfaceMensajes() {	}

}