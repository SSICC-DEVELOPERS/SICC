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
package es.indra.sicc.util;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;


public class UtilidadesI18N {
   public static Long IDIOMA_DEFAULT = new Long(1);

   public static void eliminar(String entidad, Long atributo, Long oid)
      throws MareException {
      Entidadi18nLocalHome localHome = getEntidadi18nLocalHome();
      String codigoError;
      UtilidadesLog.debug("Ingreso a UtilidadesI18N.eliminar");

      try {
         Collection i18nCol = localHome.findByEntAtrPK(entidad, atributo, oid);

         //            UtilidadesLog.debug("Encontre "+i18nCol.size()+ " registro");
         for (Iterator ite = i18nCol.iterator(); ite.hasNext();) {
            //                UtilidadesLog.debug("Borro regitro de I18n");
            localHome.remove((Entidadi18nLocal)ite.next());
         }
      } catch (RollbackException e) {
         codigoError = CodigosError.ERROR_DE_BORRADO_DE_DATOS;

         //            UtilidadesLog.debug("Error UtilidadesI18N.eliminar, RemoveException :"+e.toString());
         throw new MareException(e,
            UtilidadesError.armarCodigoError(codigoError));
      } catch (PersistenceException e) {
         codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;

         //            UtilidadesLog.debug("Error UtilidadesI18N.eliminar, FinderException :"+e.toString());
         throw new MareException(e,
            UtilidadesError.armarCodigoError(codigoError));
      }

      //        UtilidadesLog.debug("Saliendo de UtilidadesI18N.eliminar");
   }

   public static Entidadi18nLocalHome getEntidadi18nLocalHome()
      throws MareException {
      
      return new Entidadi18nLocalHome();
   }

   private static String asignarAlias(String query, String tabla, String alias) {
      StringBuffer retorno = new StringBuffer();

      //UtilidadesLog.debug(query);
      int index = query.toString().indexOf(tabla) + tabla.length();

      //UtilidadesLog.debug(query.substring(index,index+1));
      while (query.substring(index, index + 1).equals(".")) {
         index = query.toString().indexOf(tabla) + tabla.length();
      }

      //UtilidadesLog.debug(index);
      // guardo en retorno el query hasta donde termina el nombre de la tabla
      retorno.append(query.substring(0, index));

      //UtilidadesLog.debug(retorno);
      // agrego el alias
      retorno.append(" " + alias + " ");

      // agrego el resto de la consulta
      retorno.append(query.substring(index + 1));

      //UtilidadesLog.debug(retorno);
      return retorno.toString();
   }

   /*
    * no agregar en el where del sql la condicion del idioma
    */
   public static String armarSQLPatronI18n(StringBuffer sql, Long oidIdioma,
      String orderby) {
      StringBuffer query = new StringBuffer();
      String qryOri = sql.toString().toUpperCase();

      query.append(asignarAlias(qryOri, "GEN_I18N_SICC", "I18N"));
      query.append(" AND i18n.IDIO_OID_IDIO = " + oidIdioma);
      query.append(" UNION ALL ");
      query.append(asignarAlias(qryOri, "GEN_I18N_SICC", "I18N"));
      query.append(" AND i18n.IDIO_OID_IDIO = " + IDIOMA_DEFAULT);
      query.append(" AND NOT EXISTS (");
      query.append(asignarAlias(qryOri, "GEN_I18N_SICC", "I18NB"));
      query.append(" AND I18NB.IDIO_OID_IDIO = " + oidIdioma);
      query.append(" AND I18NB.VAL_OID = I18N.VAL_OID ");
      query.append(")");
      query.append(" " + orderby + " ");

      return query.toString();
   }

   /**
    * RecordSet rs        = consulta que contiene los oids que se quieren internacionalizar.
    * int[] pos        = en este array van las posiciones dentro de rs que contienen los oids (recordar que el RecordSet es una Vector, por la tanto la primer posicion es la 0)
    * String[] tablas        = en este array va el nombre de la tabla (el que figura en GEN_I18N_SICC.ATTR_ENTI es el mismo que el nombre de la tabla)
    * Long idioma         = idioma por el cual se van a traer las descripciones, si no existen se traen las descripciones del idioma default (1)
    */
   public static RecordSet traeDescI18N(RecordSet rs, int[] pos,
      String[] tablas, Long idioma) {
      Vector desc = new Vector();
      Vector oid = new Vector();

      if (rs.esVacio()) {
         return armarRecordSetDesc(rs, tablas);
      }

      for (int i = 0; i < pos.length; i++) {
         oid = rs.getColumn(pos[i]);
         desc.add(i, consultaDesc(oid, tablas[i], new Long(2)));
      }

      return unir(rs, desc, pos, tablas);
   }

   private static RecordSet unir(RecordSet rs, Vector desc, int[] pos,
      String[] tablas) {
      Object des;
      Vector row;

      //Creo el nuevo recordSet
      RecordSet rs2 = armarRecordSetDesc(rs, tablas);

      for (int i = 0; i < rs.getRowCount(); i++) {
         row = rs.getRow(i);

         for (int f = 0; f < pos.length; f++) {
            des = buscarDesc(row.elementAt(pos[f]),
                  (RecordSet) desc.elementAt(f));
            row.add(des);
         }

         rs2.addRow(row);
      }

      return rs2;
   }

   private static Object buscarDesc(Object oid, RecordSet rs2) {
      boolean listo = false;
      int i = 0;
      Object res = null;
      Object desc = null;

      while (!listo && (i < rs2.getRowCount())) {
         res = rs2.getRow(i).elementAt(0);
         desc = rs2.getRow(i).elementAt(1);
         listo = res.toString().equalsIgnoreCase(oid.toString());
         i++;
      }

      if (listo) {
         return desc;
      }

      return "";
   }

   private static RecordSet armarRecordSetDesc(RecordSet rs, String[] tablas) {
      //Creo el nuevo recordSet
      RecordSet rs2 = new RecordSet();

      //Le agrego las columnas que tenia el original
      for (int f = 0; f < rs.getColumnCount(); f++) {
         rs2.addColumn(rs.getColumnName(f));
      }

      //Le agrego las nuevas columnas para las descipciones
      for (int f = 0; f < tablas.length; f++) {
         rs2.addColumn("DES_" + tablas[f].toUpperCase());
      }

      return rs2;
   }

   private static String inClause(String campo, Vector codigos) {
      if ((codigos == null) || (codigos.size() == 0)) {
         return "";
      }

      String result = "";

      if (codigos.get(0) instanceof String) {
         result = "UPPER(" + campo + ") in (";
      } else {
         result = campo + " in (";
      }

      Object element;
      Iterator it = codigos.iterator();

      while (it.hasNext()) {
         element = it.next();
         result += element;
         result += ((it.hasNext()) ? ", " : "");
      }

      result += ")";

      return result;
   }

   private static RecordSet consultaDesc(Vector oid, String tabla, Long idioma) {
      RecordSet result = null;
      StringBuffer query = new StringBuffer();

      try {
         BelcorpService bs = BelcorpService.getInstance();
         query.append(
            " select VAL_OID, VAL_I18N from GEN_I18N_SICC where UPPER(ATTR_ENTI) = UPPER('" +
            tabla + "') and ");
         query.append(inClause("VAL_OID", oid));

         String h = armarSQLPatronI18n(query, idioma, "");
         result = bs.dbService.executeStaticQuery(h);
      } catch (Exception e) {
         /*           codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
              throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));*/
      }

      return result;
   }

   public static String recuperarTraducciones(String entidad, Long oidEntidad,
      Long idioma, Long atributo) throws MareException {
      BelcorpService bs = null;
      RecordSet traducciones = new RecordSet();

      try {
         bs = BelcorpService.getInstance();

         StringBuffer query = new StringBuffer();
         query.append(" select IDIO_OID_IDIO, VAL_I18N ");
         query.append(" from V_GEN_I18N_SICC I  ");
         query.append(" where I.ATTR_ENTI = '" + entidad + "' ");
         query.append(" and I.VAL_OID = " + oidEntidad);
         query.append(" and I.IDIO_OID_IDIO = " + idioma);
         query.append(" and I.ATTR_NUM_ATRI = " + atributo);

         traducciones = bs.dbService.executeStaticQuery(query.toString());

         if (!traducciones.esVacio()) {
            return (String) traducciones.getValueAt(0, 1);
         } else {
            return "";
         }
      } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
         throw new MareException(serviceNotFoundException,
            UtilidadesError.armarCodigoError(
               CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      } catch (Exception exception) {
         throw new MareException(exception,
            UtilidadesError.armarCodigoError(
               CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
   }
}
