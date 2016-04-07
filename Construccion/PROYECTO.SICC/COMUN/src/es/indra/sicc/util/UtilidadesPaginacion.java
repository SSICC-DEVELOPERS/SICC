package es.indra.sicc.util;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

import java.util.StringTokenizer;


public class UtilidadesPaginacion {
   /*
    * Metodo que genera automaticamente un select para paginacion.
    * Recibe como parametro un String con el query y 2 int, con el numero de ultimo registro
    * y la cantidad de lineas de ima pagina.
    * La unica condicion para que funcione es que el select tenga entre los campos
    * el campo OID:
    *
    *      ej: oid_pais OID
    */

   /**
    * @deprecated
    */
   public static String armarQueryPaginacion(String consultaOri,
      int ultLineaPresentada, int cantidadLineas) {
      DTOSiccPaginacion dto = new DTOSiccPaginacion();
      dto.setIndicadorSituacion(new Long(ultLineaPresentada));
      dto.setTamanioPagina(new Integer(cantidadLineas));

      return armarQueryPaginacion(consultaOri, dto);
   }

   public static String armarQueryPaginacion(String consultaOri,
      DTOSiccPaginacion dto) {
      Long ultLineaPresentada = dto.getIndicadorSituacion();
      Integer cantidadLineas = dto.getTamanioPagina();

      if ((ultLineaPresentada == null) || (cantidadLineas == null)) {
         return consultaOri;
      } else {
         boolean order = false;
         StringBuffer consultaFin = new StringBuffer();
         StringBuffer salida = new StringBuffer();
         StringTokenizer tokenizer = new StringTokenizer(consultaOri, " ");

         if ((consultaOri.toUpperCase().indexOf(" OID,") == -1) &&
                (consultaOri.toUpperCase().indexOf(" OID ") == -1)) {
            throw new RuntimeException("Necesita tener un campo llamado OID");
         }

         while (tokenizer.hasMoreTokens()) {
            String tok = tokenizer.nextToken();
            consultaFin.append(tok + " ");

            if (tok.toUpperCase().equalsIgnoreCase("ORDER")) {
               order = true;
            } else {
               if (tok.toUpperCase().equalsIgnoreCase("GROUP") && order) {
                  order = false;
               } else {
                  if (tok.toUpperCase().equalsIgnoreCase("BY") && order) {
                     consultaFin.append(" OID, ");
                  }
               }
            }
         }

         if (consultaFin.toString().toUpperCase().indexOf("ORDER BY") == -1) {
            consultaFin.append(" ORDER BY OID ");
         }
         
         //modificado por Gacevedo(25/09/2006)
         //Se agrega el sql necesario para marcar el ultimo registro del paginado
         //a fin de solucionar la indicencia DBLG500000967
         //modificado por Gacevedo(29/09/2006)
         //Se modifica el sql a fin de cumplimentar el pedido de performance
         salida.append("SELECT * FROM ( SELECT X.*, ");
         salida.append("CASE WHEN (("+ cantidadLineas + " -  COUNT(*)  OVER (PARTITION BY 1)) < 0) THEN 0 ELSE 1 END SICC_ES_ULTIMA_PAGINA ");
         salida.append("FROM (" + consultaFin + " )  X  WHERE ROWNUM <= " +(cantidadLineas.intValue()+1)+ "  AND OID > " +ultLineaPresentada+ ") Y ");
         salida.append(" WHERE ROWNUM <= " + cantidadLineas);
         salida.append(" and OID > " + ultLineaPresentada);

         return salida.toString();
      }
   }
   
    /**
     * Funciona de modo similar a armarQueryPaginacion
     * con la diferencia de que no altera ningun ORDER BY que ya tenga la query
     * (asume que la query recibida ya está ordenada por el campo OID)
     * @author dmorello
     * @since 17-01-2007
     */
    public static String armarQueryPaginacionEspecial(String consultaOri, DTOSiccPaginacion dto) {
        
        Long ultLineaPresentada = dto.getIndicadorSituacion();
        Integer cantidadLineas = dto.getTamanioPagina();
  
        if ((ultLineaPresentada == null) || (cantidadLineas == null)) {
           return consultaOri;
        } else {
            StringBuffer salida = new StringBuffer();
  
           if ((consultaOri.toUpperCase().indexOf(" OID,") == -1) &&
                  (consultaOri.toUpperCase().indexOf(" OID ") == -1)) {
              throw new RuntimeException("Necesita tener un campo llamado OID");
           }
  
           salida.append("SELECT * FROM ( SELECT X.*, ");
           // dmorello, 18/09/2007: Se elimina PARTITION BY
           //salida.append("CASE WHEN (("+ cantidadLineas + " -  COUNT(*)  OVER (PARTITION BY 1)) < 0) THEN 0 ELSE 1 END SICC_ES_ULTIMA_PAGINA ");
           salida.append("CASE WHEN (("+ cantidadLineas + " -  COUNT(*)  OVER ()) < 0) THEN 0 ELSE 1 END SICC_ES_ULTIMA_PAGINA ");
           // Fin dmorello, 18/09/2007
           salida.append("FROM (" + consultaOri + " )  X  WHERE ROWNUM <= " +(cantidadLineas.intValue()+1)+ "  AND OID > " +ultLineaPresentada+ ") Y ");
           salida.append(" WHERE ROWNUM <= " + cantidadLineas);
           salida.append(" and OID > " + ultLineaPresentada);
  
           return salida.toString();
        }
    } 
}
