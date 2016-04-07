/**
 * Copyright 2003 ® por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dbunit;

import oracle.jdbc.OracleDriver;

import java.io.*;

import java.sql.*;

import java.util.*;
import es.indra.sicc.util.UtilidadesLog;

public class UtilTag {
   private Connection miConn = null;
   private Vector miVectorNombres = new Vector();
   private Vector miVectorTipos = new Vector();
   private Vector miVectorNombresTipos = new Vector();
   private Vector miVectorAnchoColumnas = new Vector();

   public UtilTag() {
      try {
         this.miConn = this.getConnection();
      } catch (SQLException e) {
         UtilidadesLog.error(e);
      }
   }

   /**
    *        @args                Primer parámetro: nombre de xml a escribir
    *                         Demás parametros: nombre de las tablas cuya estructura se exportara
    *                                                          al XML.
    */
   public static void main(String[] args) {
      try {
         String miTabla = null;
         Iterator ite = null;

         UtilTag ut = new UtilTag();
         Iterator miIteTablas = Arrays.asList(args).iterator();

         File miFile = new File((String) miIteTablas.next());
         FileWriter miFr = new FileWriter(miFile);

         while (miIteTablas.hasNext()) {
            miTabla = (String) miIteTablas.next();
            ite = ut.armarEncabezadoTabla(miTabla);

            while (ite.hasNext()) {
               miFr.write((String) ite.next());
            }

            miFr.write(ut.armarTag(miTabla));
         }

         miFr.close();
         ut.miConn.close();
      } catch (SQLException e) {
         UtilidadesLog.error(e);
      } catch (IOException e) {
         UtilidadesLog.error(e);
      }
   }

   public String armarTag(String tabla) {
      Iterator miIteNombres = this.miVectorNombres.iterator();
      Iterator miIteTipos = this.miVectorTipos.iterator();
      Iterator miIteAncho = this.miVectorAnchoColumnas.iterator();

      Tag miTag = new Tag(tabla);
      Vector misAtributos = new Vector();

      while (miIteNombres.hasNext()) {
         misAtributos.add(new AtributoTag((String) miIteNombres.next(),
               ((Integer) miIteTipos.next()).intValue(),
               Integer.parseInt((String) miIteAncho.next())));
      }

      miTag.setAtributos(misAtributos);

      return miTag.imprimir();
   }

   public Iterator armarEncabezadoTabla(String tabla) {
      try {
         Vector miVectorRet = new Vector();

         this.limpiarVectores();
         this.buscarMetaDataTabla(tabla);

         miVectorRet.add(Formato.linea());
         miVectorRet.add(Formato.linea("<!--"));
         miVectorRet.add(Formato.linea("TABLE_NAME = " + tabla));
         miVectorRet.add(Formato.linea(
               "======================================="));
         miVectorRet.add(Formato.linea());
         miVectorRet.add(Formato.linea(Formato.agregarEspacios("COLUMN_NAME") +
               Formato.agregarEspacios("DATA_TYPE") +
               Formato.agregarEspacios("TYPE_NAME") +
               Formato.agregarEspacios("COLUMN_SIZE")));
         miVectorRet.add(Formato.linea(Formato.agregarEspacios("============") +
               Formato.agregarEspacios("============") +
               Formato.agregarEspacios("============") +
               Formato.agregarEspacios("============")));

         Iterator ite1 = this.miVectorNombres.iterator();
         Iterator ite2 = this.miVectorTipos.iterator();
         Iterator ite3 = this.miVectorNombresTipos.iterator();
         Iterator ite4 = this.miVectorAnchoColumnas.iterator();

         while (ite1.hasNext()) {
            miVectorRet.add(Formato.linea(Formato.agregarEspacios(
                     (String) ite1.next()) +
                  Formato.agregarEspacios(((Integer) ite2.next()).toString()) +
                  Formato.agregarEspacios((String) ite3.next()) +
                  Formato.agregarEspacios((String) ite4.next())));
         }

         miVectorRet.add(Formato.linea("-->"));
         miVectorRet.add(Formato.linea());

         return miVectorRet.iterator();
      } catch (SQLException e) {
         UtilidadesLog.error(e);

         return null;
      }
   }

   public void limpiarVectores() {
      this.miVectorNombres.clear();
      this.miVectorTipos.clear();
      this.miVectorNombresTipos.clear();
      this.miVectorAnchoColumnas.clear();
   }

   public void buscarMetaDataTabla(String tabla) throws SQLException {
      DatabaseMetaData dbmd = this.miConn.getMetaData();
      ResultSet rs = dbmd.getColumns(null, null, tabla, "%");

      while (rs.next()) {
         this.miVectorNombres.add(rs.getString(rs.findColumn("COLUMN_NAME")));
         this.miVectorTipos.add(new Integer(rs.getInt(rs.findColumn("DATA_TYPE"))));
         this.miVectorNombresTipos.add(rs.getString(rs.findColumn("TYPE_NAME")));
         this.miVectorAnchoColumnas.add(rs.getString(rs.findColumn(
                  "COLUMN_SIZE")));
      }
   }

   public static Connection getConnection() throws SQLException {
      String username = "usu_peru";
      String password = "usu_peru";
      String thinConn = "jdbc:oracle:thin:@192.168.118.106:1521:siccd";
      Driver d = new OracleDriver();

      return DriverManager.getConnection(thinConn, username, password);
   }
}
