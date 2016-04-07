package es.indra.sicc.util;

import java.io.*;

import java.math.BigDecimal;

import java.util.*;


public class TesterUtilidadesSICC {
   public static void main(String[] args) {
      testValidarCampos();
      UtilidadesLog.debug(testArmarSQLWhere());
   }

   public static void testValidarCampos() {
      try {
         UtilidadesBD.validarCampos("001",
            CodigosCasosDeUsoMAE.CONSULTAR_UNIDAD_DE_NEGOCIO,
            new Object[] { "abc", new Integer(1), new Float(3), "aa1234567890" },
            new int[] { 9, 3, 3, 100 },
            new boolean[] { true, false, false, false });
         UtilidadesLog.debug("OK");
      } catch (Exception e) {
         UtilidadesLog.debug("ERRROR");
      }
   }

   public static String testArmarSQLWhere() {
      return UtilidadesBD.armarSQLWhere(new String[] {
            "PAIS_COD_PAIS", "COD_LINE_PROD", "DES_LINE_PROD"
         }, new Object[] { null, null, null },
         new boolean[] { false, false, true });
   }
}
