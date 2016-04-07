package es.indra.sicc.util;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.log.MareDebug;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;

import java.io.ByteArrayOutputStream;

import java.io.InputStream;

import java.io.OutputStream;

import java.math.BigDecimal;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.ResultSet;

import java.text.*;

import java.util.*;
import java.util.Vector;

import oracle.jdbc.driver.OracleTypes;

import oracle.sql.BLOB;


public class UtilidadesBD {
   public final static int OP_BUSCAR = 1;
   public final static int OP_ELIMINAR = 2;
   public final static int OP_MODIFICAR = 3;
   public final static int OP_INSERTAR = 4;

   /**
    * Este metodo arma la condicion where de una consulta SQL.
    * Por ejemplo si recibe {"A", "B", "C", "D"}, {"", "pepe", "  ", "casa"}, {true, false, true, true}
    */
   public static String armarSQLWhere(String[] nombresCampos,
      Object[] valoresParametros, boolean[] comodines) {
      String whereSQL = "";

      for (int i = 0; i <= (nombresCampos.length - 1); i++) {
         whereSQL = agregarSQLCampo(nombresCampos, valoresParametros, whereSQL,
               i, comodines);
      }

      return whereSQL;
   }

   private static String agregarSQLCampo(String[] nombresCampos,
      Object[] valoresParametros, String whereSQL, int pos, boolean[] comodines) {
      String comparacion = "";

      if (valoresParametros[pos] == null) {
         return whereSQL;
      }

      //---String---
      if (valoresParametros[pos] instanceof String) {
         if (((String) valoresParametros[pos]).trim().length() == 0) {
            return whereSQL;
         }

         if (comodines[pos]) {
            comparacion = "upper(" + nombresCampos[pos] + ") like upper('" +
               reemplazaComillasSimples(valoresParametros[pos].toString()) +
               "')";
         } else {
            comparacion = "upper(" + nombresCampos[pos] + ") = upper('" +
               reemplazaComillasSimples(valoresParametros[pos].toString()) +
               "')";
         }

         //---Number---                
      } else if ((valoresParametros[pos] instanceof Integer) ||
             (valoresParametros[pos] instanceof Long) ||
             (valoresParametros[pos] instanceof Double) ||
             (valoresParametros[pos] instanceof BigDecimal) ||
             (valoresParametros[pos] instanceof Float)) {
         comparacion = " " + nombresCampos[pos] + " = " +
            valoresParametros[pos] + " ";

         //---Boolean---                
      } else if (valoresParametros[pos] instanceof Boolean) {
         comparacion = " " + nombresCampos[pos] + " = " +
            convertirBooleanANumber((Boolean) valoresParametros[pos]) + " ";

         //---java.util.Date---                
      } else if (valoresParametros[pos] instanceof Date) {
         comparacion = " " + oracleTO_DATE(oracleTO_CHAR(nombresCampos[pos])) +
            " = " + oracleTO_DATE((Date) valoresParametros[pos]) + " ";
      }

      if (whereSQL == "") {
         return whereSQL + " where " + comparacion;
      }

      return whereSQL + " and " + comparacion;
   }

   /**
    * Este metodo arma la condicion where de una consulta SQL.
    * Por ejemplo si recibe {"and GEN_I18N_SICC.val_oid != 0 "}, ""
    */
   public static String armarSQLWhereDinamico(String[] lineasDinamicas,
      String sqlWhere) {
      String whereSQL = sqlWhere;

      if (whereSQL == "") {
         whereSQL = " where ";
      }

      for (int i = 0; i <= (lineasDinamicas.length - 1); i++) {
         whereSQL = whereSQL + lineasDinamicas[i];
      }

      return whereSQL;
   }

   public static void validarCampos(Object[] valores, int[] longitudes,
      boolean[] obligatorio) throws MareException {
      validarCampos(ConstantesSEG.INDEFINIDO,
         CodigosError.CASO_DE_USO_INDEFINIDO, valores, longitudes, obligatorio);
   }

   public static void validarCampos(String codigoModulo,
      String codigoCasoDeUso, Object[] valores, int[] longitudes,
      boolean[] obligatorio) throws MareException {
      String codigoError;

      for (int i = 0; i < valores.length; i++) {
         /* Si es un array, verifica todos sus elementos contra la posicion que
          * le corresponde en longitudes y obligatoriedad
          */
         if ((valores[i] != null) && valores[i].getClass().isArray()) {
            Object[] aux = (Object[]) valores[i];

            for (int j = 0; j < aux.length; j++) {
               validarCampo(codigoModulo, codigoCasoDeUso, aux[j],
                  longitudes[i], obligatorio[i]);
            }

            /*
                                                    if (obligatorio[i]) {
                                                            if (valores[i] == null) {
                                                                    codigoError = CodigosError.ERROR_CAMPO_OBLIGATORIO_NO_DEFINIDO;
                                                                    throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoModulo,codigoCasoDeUso,codigoError));
                                                            } else if (valores[i] instanceof String) {
                                                                                    if (((String)valores[i]).trim().length() == 0) {
                                                                                            codigoError = CodigosError.ERROR_CAMPO_OBLIGATORIO_NO_DEFINIDO;
                                                                                            throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoModulo,codigoCasoDeUso,codigoError));
                                                                                    }
                                                                    }
                                                    }
                                              //---String---
                                              if (valores[i] instanceof String) {
                                                            if (((String)valores[i]).length() > longitudes[i]) {
                                                                     codigoError = CodigosError.ERROR_CAMPO_CON_LONGITUD_MAYOR_A_LA_PERMITIDA;
                                                                     throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoModulo,codigoCasoDeUso,codigoError));
                                                            }
                                              }
                                            }
            */
         } else {
            validarCampo(codigoModulo, codigoCasoDeUso, valores[i],
               longitudes[i], obligatorio[i]);

            /*
                                            if (obligatorio[i]) {
                                                    if (valores[i] == null) {
                                                            codigoError = CodigosError.ERROR_CAMPO_OBLIGATORIO_NO_DEFINIDO;
                                                            throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoModulo,codigoCasoDeUso,codigoError));
                                                    } else if (valores[i] instanceof String) {
                                                                            if (((String)valores[i]).trim().length() == 0) {
                                                                                    codigoError = CodigosError.ERROR_CAMPO_OBLIGATORIO_NO_DEFINIDO;
                                                                                    throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoModulo,codigoCasoDeUso,codigoError));
                                                                            }
                                                            }
                                            }
                                      //---String---
                                      if (valores[i] instanceof String) {
                                                    if (((String)valores[i]).length() > longitudes[i]) {
                                                             codigoError = CodigosError.ERROR_CAMPO_CON_LONGITUD_MAYOR_A_LA_PERMITIDA;
                                                             throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoModulo,codigoCasoDeUso,codigoError));
                                                    }
                                      }
            */
         }
      }
   }

   public static void validarCampo(String codigoModulo, String codigoCasoDeUso,
      Object valor, int longitud, boolean obligatoriedad)
      throws MareException {
      String codigoError;

      if (obligatoriedad) {
         if (valor == null) {
            codigoError = CodigosError.ERROR_CAMPO_OBLIGATORIO_NO_DEFINIDO;
            throw new MareException(null, null,
               UtilidadesError.armarCodigoError(codigoModulo, codigoCasoDeUso,
                  codigoError));
         } else if (valor instanceof String) {
            if (((String) valor).trim().length() == 0) {
               codigoError = CodigosError.ERROR_CAMPO_OBLIGATORIO_NO_DEFINIDO;
               throw new MareException(null, null,
                  UtilidadesError.armarCodigoError(codigoModulo,
                     codigoCasoDeUso, codigoError));
            }
         }
      }

      //---String---
      if (valor instanceof String) {
         if (((String) valor).length() > longitud) {
            codigoError = CodigosError.ERROR_CAMPO_CON_LONGITUD_MAYOR_A_LA_PERMITIDA;
            throw new MareException(null, null,
               UtilidadesError.armarCodigoError(codigoModulo, codigoCasoDeUso,
                  codigoError));
         }
      }
   }

   public static void validarCampos(RecordSet valores, int[] longitudes,
      boolean[] obligatorio) throws MareException {
      validarCampos(ConstantesSEG.INDEFINIDO,
         CodigosError.CASO_DE_USO_INDEFINIDO, valores, longitudes, obligatorio);
   }

   public static void validarCampos(String codigoModulo,
      String codigoCasoDeUso, RecordSet valores, int[] longitudes,
      boolean[] obligatorio) throws MareException {
      Object[] aux;
      Vector aux2;

      for (int i = 0; i <= (valores.getRowCount() - 1); i++) {
         aux2 = valores.getRow(i);
         aux = convertirVectorAArray(aux2);
         validarCampos(codigoModulo, codigoCasoDeUso, aux, longitudes,
            obligatorio);
      }
   }

   public static void validarCampos(Vector valores, int[] longitudes,
      boolean[] obligatorio) throws MareException {
      validarCampos(ConstantesSEG.INDEFINIDO,
         CodigosError.CASO_DE_USO_INDEFINIDO, valores, longitudes, obligatorio);
   }

   public static void validarCampos(String codigoModulo,
      String codigoCasoDeUso, Vector valores, int[] longitudes,
      boolean[] obligatorio) throws MareException {
      Vector aux;

      for (int i = 0; i < valores.size();) {
         aux = new Vector();

         for (int j = 0; j < longitudes.length; j++, i++) {
            aux.addElement(valores.get(i));
         }

         UtilidadesBD.validarCampos(codigoModulo, codigoCasoDeUso,
            aux.toArray(), longitudes, obligatorio);
      }
   }

   private static Object[] convertirVectorAArray(Vector vector) {
      Object[] aux = new Object[vector.size()];

      for (int i = 0; i < vector.size(); i++) {
         aux[i] = (Object) vector.elementAt(i);
      }

      return aux;
   }

   /**
   * Si Boolean(true)         --> 1
   * Si Boolean(false) o null --> 0
   *    return (aBoolean.booleanValue() == true ? 1 : 0);
   * @param  Boolean aBoolean
   * @throws
   * @return int
   */
   private static int convertirBooleanANumber(Boolean aBoolean) {
      if (aBoolean.booleanValue()) {
         return 1;
      }

      return 0;
   }

   /**
    *
    */
   private static String oracleTO_DATE(Date fecha) {
      String paramDate = "";

      try {
         paramDate = " TO_DATE('" + UtilidadesFecha.convertirAString(fecha) +
            "', 'yyyy-mm-dd') ";
      } catch (ParseException pe) {
         return "";
      }

      return paramDate;
   }

   private static String oracleTO_DATE(String str) {
      return " TO_DATE(" + str + ", 'yyyy-mm-dd') ";
   }

   /**
    *
    */
   private static String oracleTO_CHAR(String campo) {
      return " TO_CHAR(" + campo + ", 'yyyy-mm-dd') ";
   }

   public static String reemplazaComillasSimples(String cadena) {
      int s = 0;
      int e = 0;
      StringBuffer result = new StringBuffer();

      if (cadena != null) {
         while ((e = cadena.indexOf("'", s)) >= 0) {
            result.append(cadena.substring(s, e));
            result.append("''");
            s = e + 1;
         }

         result.append(cadena.substring(s));
      }

      return (result == null) ? null : result.toString();
   }
   
     public static Float convertirAFloat(Object numero) {    
    if (numero != null) {
      return new Float(((BigDecimal) numero).floatValue());
    } else {
      return null;
    }
  }
  
  public static Long convertirALong(Object numero) {    
    if (numero != null) {
      return new Long(((BigDecimal) numero).longValue());
    } else {
      return null;
    }
  }
  
  public static Integer convertirAInteger(Object numero) {    
    if (numero != null) {
      return new Integer(((BigDecimal) numero).intValue());
    } else {
      return null;
    }
  }

  public static Boolean convertirABoolean(Object indicador) {    
     if (indicador != null) {
       if (((BigDecimal) indicador).intValue() == 1)  { 
         return Boolean.TRUE;
       } else {
         return Boolean.FALSE;           
       }           
     } else {
       return Boolean.FALSE;
     }
  }
  
  public static String convertirAString(Object cadena) {    
     if (cadena != null) {
       return cadena.toString();
     } else {
       return null;
     }
  }

  public static RecordSet executeQuery(String query) throws MareException {
    UtilidadesLog.info("UtilidadesBD.executeQuery(String query): Entrada");
    RecordSet rs = null;
    
    try {
      BelcorpService belcorpService = BelcorpService.getInstance();
      rs = belcorpService.dbService.executeStaticQuery( query );
    } catch ( Exception ex ) {
      throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }       
    UtilidadesLog.info("UtilidadesBD.executeQuery(String query): Salida");  
    return rs;
  } 
  
  
  /**
   * Convierte un BLOB de Oracle a un byte array.
   * Nota: la MareException lanzada debe ser capturada y, en el catch,
   * debe llamarse a SessionContext.setRollbackOnly().
   * @author dmorello
   * @since 15-abr-2009
   */
  public static byte[] oracleBlobToByteArray(BLOB blob) throws MareException {
      try {
          InputStream in = blob.getBinaryStream();
          ByteArrayOutputStream out = new ByteArrayOutputStream();
          int c = 0;
          while ((c = in.read()) != -1) {
            out.write(c);
          }
          in.close();
          out.close();
          return out.toByteArray();
      } catch (Exception e) {
          String error = CodigosError.ERROR_DE_LECTURA_BLOB;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }
  }
  
  public static Character convertirACharacter(Object o) {
      if (o != null) {
          if (o instanceof String) {
              return Character.valueOf(o.toString().charAt(0));
          } else if (o instanceof Character) {
              return (Character)o;
          } else {
              throw new IllegalArgumentException("Se esperaba un String");
          }
      } else {
          return null;
      }
  }
  
    /**
     * 16-03-2011       Agregado por Sapaza, cambio RoadMap-Optimizacion Querys GP5
     * 
     * @throws es.indra.mare.common.exception.MareException
     */  
    public static RecordSet executeProcedureCursor(String procedure, Vector params) throws MareException {
      UtilidadesLog.info("UtilidadesBD.executeProcedureCursor(String Procedure, Vector params): Entrada");
      RecordSet rs = null;

      //construimos la llamda al stored procedure
      StringBuffer sb = new StringBuffer("{call ").append(procedure);
      if(params != null && params.size() > 0) {
        sb.append("(");
        for(int i = 0; i < params.size(); i++) {
           sb.append("?,");
        }
        sb.append("?"); //parametro de salida del cursor
        sb.append(")");
      }
      sb.append("}");
      
      MareDebug.write("[UtilidadesBD] - executeProcedureCursor: " + sb.toString());  //pintamos el stored que estamos invocando
        
      try {
        BelcorpService belcorpService = BelcorpService.getInstance();
        Connection connection = belcorpService.dbService.getConnection();
        
        //invocamos al stored procedure, cuyo ultimo parametro debe ser de TIPO CURSOR de salida
        CallableStatement stmt = connection.prepareCall(sb.toString());
        
        for(int x = 1; x <= params.size(); x++)
          stmt.setString(x, params.get(x - 1).toString());
        
        // register the type of the out param - an Oracle specific type
        stmt.registerOutParameter(params.size() + 1, OracleTypes.CURSOR);
        
        stmt.execute();
        ResultSet rsAux = (ResultSet)stmt.getObject(params.size() + 1);
         
        //tenemos que generar el tipo RecordSet manejado en las consultas de SICC  
        rs = new RecordSet(rsAux);
        
        if(rsAux != null)
          rsAux.close();
        if(stmt != null)
          stmt.close();
        if(connection != null)
          connection.close();          
              
      } catch ( Exception ex ) {
        throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }       
      
      UtilidadesLog.info("UtilidadesBD.executeProcedureCursor(String Procedure, Vector params): Salida");
      return rs;
    }
    
}
