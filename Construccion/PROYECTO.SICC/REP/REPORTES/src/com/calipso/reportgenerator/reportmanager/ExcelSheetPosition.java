package com.calipso.reportgenerator.reportmanager;

import es.indra.mare.common.info.InfoException;
import com.calipso.reportgenerator.common.LanguageTraslator;

/**
 * Esta clase representa una posición en una planilla excel. Puede usarse para definir una direccion como C4 y traducirla
 * a formato numerico fila / columna para ser usada con HSSF.
 * User: jbassino
 * Date: 28/10/2004
 */
public class ExcelSheetPosition {

  //private char[] columns = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
  private static final String columns = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  private String columnName;
  private int row;
  private short column;

  /**
   * Este constructor recibe un string como E8 y lo parsea para obtener una posicion que represente una fila columna.
   * @param position
   * @throws InfoException
   */
  public ExcelSheetPosition(String position) throws InfoException{
    if(position==null || position.equalsIgnoreCase("")){
      throw new InfoException(LanguageTraslator.traslate("379"));
    }
    position = position.toUpperCase();
    columnName = getLetters(position);
    row = Integer.parseInt(getNumbers(position.substring(columnName.length())));
    column = getIndexFor(columnName);
  }

  /**
   * Este constructor recibe directamente como parametro la fila y columna, y no realiza ningún calculo.
   * @param row
   * @param column
   */
  public ExcelSheetPosition(int row, short column){
    this.row = row;
    this.column = column;
  }

  /**
   * Recibe la columna por su nombre y la transforma a numero.
   * @param columnName
   * @param row
   * @throws InfoException
   */
  public ExcelSheetPosition(String columnName, int row) throws InfoException {
    this.row = row;
    this.columnName = columnName;
    this.column = getIndexFor(columnName);
  }

  /**
   * Recibe un nombre de columna de 1 o 2 caracteres y obtiene la posicion que este representa en una hoja excel,
   * empezando por A = 0.
   * @param columnName
   * @return
   * @throws InfoException
   */
  private short getIndexFor(String columnName) throws InfoException {
    if(columnName.length()==1){
      return (short)columns.indexOf(columnName);
    }else if(columnName.length()==2){
      if(columns.indexOf(columnName.substring(0,1)) < 10){
        return (short)(26*(columns.indexOf(columnName.substring(0,1)) + 1) + columns.indexOf(columnName.substring(1)));
      }
    }
    throw new InfoException(LanguageTraslator.traslate("378") + columnName);
  }

  /**
   * De un string obtiene la parte que son numeros. Ejemplo AB1024 retornara 1024.
   * @param position
   * @return
   */
  private String getNumbers(String position) {
    StringBuffer buffer = new StringBuffer();
    for(int i=0;i < position.length(); i++){
      if(Character.isDigit(position.charAt(i))){
        buffer.append(position.charAt(i));
      }else{
        break;
      }
    }
    return buffer.toString();
  }

  /**
   * De un string obtiene la primera parte con letras. Ejemplo AB1024 retorna AB
   * @param position
   * @return
   */
  private String getLetters(String position) {
    StringBuffer buffer = new StringBuffer();
    for(int i=0;i < position.length(); i++){
      if(Character.isLetter(position.charAt(i))){
        buffer.append(position.charAt(i));
      }else{
        break;
      }
    }
    return buffer.toString();
  }

  public int getRow() {
    return row;
  }

  public short getColumn() {
    return column;
  }

  public void setRow(int row) {
    this.row = row;
  }

  public void setColumn(short column) {
    this.column = column;
  }
}
