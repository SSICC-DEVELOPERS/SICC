package es.indra.sicc.logicanegocio.edu;

public class ErroresNegocio  {
	public ErroresNegocio() {
	}
		public static String NO_VALIDO_ACCESOS = "25";
		public static String NO_VALIDO_VINCULOS = "30";
		public static String CONFIGURACION_MULTIPLE_MF_PAIS = "1001";
        public final static String TIPO_SOLICITUD_NO_ENCONTRADO   = "2001";
	
        public final static String EDU_2001 =    "2001"; 
        //código de error: 1002 "El curso seleccionado no existe"     
        public final static String EDU_1002 =    "1002"; 
        //El código de curso no puede ser superior a 999. Se debe reiniciar la secuencia.
        public final static String EDU_1003 = "1003"; 
        
        //no se puede eliminar plantilla ya q' tiene cursos asignados
        public final static String EDU_1004 = "1004"; 
        
        //no se puede modificar plantilla ya q' tiene cursos asignados
        public final static String EDU_1005 = "1005"; 
        
}