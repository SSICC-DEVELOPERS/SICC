package es.indra.sicc.comunapplet;

import java.awt.Color;
import java.awt.Font;

import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Columna extends Object {
  public static boolean paramClearBefore = false;

  private int     nIndex;
  private String  cTitulo;
  private int     nAncho;
  private int     nLargo;
  private byte    nTpDato;
  private byte    nCase;
  private byte    nDecimales;
  private boolean bVisible     = true;
  private boolean trimeable    = true;
  private boolean bPositivo    = true;
  private boolean bEditable    = true;
  private boolean bClearBefore = paramClearBefore;
  private boolean bKey         = false;
  private byte    nAlignement  = ALIGN_LEFT;

  private ComboBoxApplet oComboBox    = null;
  private Columna   oColRelation = null;

  public Vector  veDataRow    = null;
  public Vector  veDeletedRow = null;

  public static final byte BUTTON_QRY       = 100;
  public static final byte COMBO_BOX        = 101;
  //public static final byte COLOR           = 102;
  public static final byte TYPE_ALFANUMERICO= TextFieldApplet.TYPE_ALFANUMERICO;
  public static final byte TYPE_ALFABETICO  = TextFieldApplet.TYPE_ALFABETICO;
  public static final byte TYPE_INTEGER     = TextFieldApplet.TYPE_INTEGER;
  public static final byte TYPE_DECIMAL     = TextFieldApplet.TYPE_DECIMAL;
  public static final byte TYPE_FLOAT       = TextFieldApplet.TYPE_FLOAT;
  public static final byte TYPE_TIME        = TextFieldApplet.TYPE_TIME;
  public static final byte TYPE_DATE        = TextFieldApplet.TYPE_DATE;
  public static final byte TYPE_DATE_TIME   = TextFieldApplet.TYPE_DATE_TIME;
  public static final byte TYPE_PERIODO     = TextFieldApplet.TYPE_PERIODO;
  public static final byte TYPE_BOOLEAN     = TextFieldApplet.TYPE_BOOLEAN;
  public static final byte TYPE_SI_NO       = TextFieldApplet.TYPE_SI_NO;
  public static final byte TYPE_RUT         = TextFieldApplet.TYPE_RUT;

  public static final byte CASE_NONE        = TextFieldApplet.CASE_NONE;
  public static final byte CASE_LOWER       = TextFieldApplet.CASE_LOWER;
  public static final byte CASE_UPPER       = TextFieldApplet.CASE_UPPER;

  public static final byte ALIGN_LEFT       = JLabel.LEFT;
  public static final byte ALIGN_CENTER     = JLabel.CENTER;
  public static final byte ALIGN_RIGHT      = JLabel.RIGHT;

  class Celda {
    Object data =null;
    Color  colorForeground=null;
    Color  colorBackground=null;
    Font   font =null;
  }

  public Columna( String cTitle ) {
    this.init( cTitle );
  }

  private void init( String cTitle ) {
    this.nTpDato=TYPE_ALFANUMERICO;
    this.cTitulo=cTitle;
    this.veDataRow = new Vector();
    this.veDeletedRow = new Vector();
  }

//-----------------------------------------------------------------------------
  public void setIndex( int nIndex){
    this.nIndex=nIndex;
  }
  public int getIndex(){
    return this.nIndex;
  }

//-----------------------------------------------------------------------------
  public void setTitle( String cTitulo){
    this.cTitulo=cTitulo;
  }
  public String getTitle(){
    return this.cTitulo;
  }

//-----------------------------------------------------------------------------
  public void setWidth(int nAncho){
    this.nAncho=nAncho;
  }
  public int getWidth(){
    if( nAncho==0 && nTpDato==BUTTON_QRY )
      return 20;
    return this.nAncho;
  }

//-----------------------------------------------------------------------------
  public void setLength(int nLargo){
    this.nLargo=nLargo;
  }
  public int getLength(){
    return this.nLargo;
  }

//-----------------------------------------------------------------------------
  public void setType( byte nTpDato){
    switch(nTpDato){
    case TYPE_INTEGER:
    case TYPE_DECIMAL:
    case TYPE_FLOAT:
      this.setAlignement( this.ALIGN_RIGHT );
      break;
    case BUTTON_QRY:
      this.setEditable(false);
      break;
    case TYPE_RUT:
      this.setCase( this.CASE_UPPER );
      break;
    }
    this.nTpDato=nTpDato;
  }
  public byte getType(){
    return this.nTpDato;
  }

//-----------------------------------------------------------------------------
  public void setAlignement( byte nAlignement ){
    this.nAlignement=nAlignement;
  }
  public byte getAlignement(){
    return this.nAlignement;
  }

//-----------------------------------------------------------------------------
  /**
   * Esta propiedad es usada solo por GlGrilla, y hace que los datos contenidos
   * en la celda sean borrados al momento de entrar en edición, al GlTextField
   * se le construyo algo similar (ver GlTextField.focusGained )
   */
  public void setClearBeforeEdit(boolean bClearBefore ){
    this.bClearBefore=bClearBefore;
  }
  public boolean getClearBeforeEdit(){
    return this.bClearBefore;
  }

//-----------------------------------------------------------------------------
  public void setComboBox ( ComboBoxApplet oComboBox ) {
    this.oComboBox=oComboBox;
  }
  public ComboBoxApplet getComboBox(){
    return this.oComboBox;
  }
  
  public Color getColor(){
    return Color.WHITE;
  }

//-----------------------------------------------------------------------------
  public void setColRelation ( Columna oColRelation ) {
    this.oColRelation=oColRelation;
    oColRelation.oColRelation=this;
  }
  public Columna getColRelation(){
    return this.oColRelation;
  }

//-----------------------------------------------------------------------------
  public void setCase( byte nCase){
    this.nCase=nCase;
  }
  public byte getCase(){
    return this.nCase;
  }

//-----------------------------------------------------------------------------
  public void setDecimals( int nDecimales){
    this.nDecimales=(byte)nDecimales;
  }
  public byte getDecimals(){
    return this.nDecimales;
  }

//-----------------------------------------------------------------------------
  public void setPositiv( boolean bPositivo ){
    this.bPositivo=bPositivo;
  }
  public boolean getPositiv(){
    return this.bPositivo;
  }

//-----------------------------------------------------------------------------
  public void setEditable( boolean bEditable ){
    if( this.getType()==BUTTON_QRY || ! this.getVisible())
      bEditable=false;
    this.bEditable=bEditable;
  }
  public boolean getEditable(){
    return this.bEditable;
  }
  public boolean isEditable(){
    return this.bEditable;
  }

//-----------------------------------------------------------------------------
  public void setVisible( boolean bVisible ){
    if( !bVisible )
      this.setEditable(false);
    this.nAncho=-1;
    this.bVisible=bVisible;
  }
  public boolean getVisible(){
    return this.bVisible;
  }
  public boolean isVisible(){
    return this.bVisible;
  }

//-----------------------------------------------------------------------------
  public void setKey( boolean bKey ){
    this.bKey=bKey;
  }
  public boolean isKey(){
    return this.bKey;
  }

//-----------------------------------------------------------------------------
  public void setTrim(boolean bTrim){
    trimeable=bTrim;
  }
  public boolean getTrim(){
    return trimeable;
  }

//-----------------------------------------------------------------------------
  public int getRowCount(){
    return veDataRow.size();
  }

//-----------------------------------------------------------------------------
  public void setColorForeground( Color color, int nRow ){
    Object celda=(Object)veDataRow.elementAt( nRow );

    if( celda instanceof Celda ) {
      ((Celda)celda).colorForeground=color;
    } else {
      Celda celdaNueva=new Celda();
      celdaNueva.data=celda;
      celdaNueva.colorForeground=color;
      veDataRow.setElementAt(celdaNueva, nRow);
    }
  }

//-----------------------------------------------------------------------------
  public void removeColorForeground(){
    Object celda;

    for( int i=0 ; i < veDataRow.size() ; i++ ){
      celda=(Object)veDataRow.elementAt(i);
      if( celda instanceof Celda )
        ((Celda)celda).colorForeground=null;
    }
  }

//-----------------------------------------------------------------------------
  public Color getColorForeground( int nRow ){
    Object celda=(Object)veDataRow.elementAt( nRow );

    if( celda instanceof Celda )
      return ((Celda)celda).colorForeground;
    return null;
  }

//-----------------------------------------------------------------------------
  public void setColorBackground( Color color, int nRow ){
    Object celda=(Object)veDataRow.elementAt( nRow );

    if( celda instanceof Celda ) {
      ((Celda)celda).colorBackground=color;
    } else {
      Celda celdaNueva=new Celda();
      celdaNueva.data=celda;
      celdaNueva.colorBackground=color;
      veDataRow.setElementAt( celdaNueva, nRow );
    }
  }

//-----------------------------------------------------------------------------
  public void removeColorBackground(){
    Object celda;

    for( int i=0 ; i < veDataRow.size() ; i++ ){
      celda=(Object)veDataRow.elementAt(i);
      if( celda instanceof Celda )
        ((Celda)celda).colorBackground=null;
    }
  }

//-----------------------------------------------------------------------------
  public Color getColorBackground( int nRow ){
    try {
      Object celda=(Object)veDataRow.elementAt( nRow );
      if( celda instanceof Celda )
        return ((Celda)celda).colorBackground;
    } catch (ArrayIndexOutOfBoundsException e) { }
    return null;
  }

//-----------------------------------------------------------------------------
  // Todos estos Get usan como row un Integer, esto es para poder llamarlos
  // desde cualquier GlGen
  public boolean getValueBoolean( Integer row ){ return getValueBoolean( row.intValue());}
  //public byte    getValueByte   ( Integer row ){ return getValueByte   ( row.intValue());}
  //public short   getValueShort  ( Integer row ){ return getValueShort  ( row.intValue());}
  //public int     getValueInt    ( Integer row ){ return getValueInt    ( row.intValue());}
  //public long    getValueLong   ( Integer row ){ return getValueLong   ( row.intValue());}
  //public double  getValueDouble ( Integer row ){ return getValueDouble ( row.intValue());}
 // public Date    getValueDate   ( Integer row ){ return getValueDate   ( row.intValue());}
  public String  getValueString ( Integer row ){ return getValueString ( row.intValue());}
  public String  getText        ( Integer row ){ return getText        ( row.intValue());}
  //public byte    getValueByte   ( Integer row, Integer nDefault ){ return getValueByte   ( row.intValue(), nDefault.byteValue());}
  //public short   getValueShort  ( Integer row, Integer nDefault ){ return getValueShort  ( row.intValue(), nDefault.shortValue());}
  //public int     getValueInt    ( Integer row, Integer nDefault ){ return getValueInt    ( row.intValue(), nDefault.intValue());}
  //public long    getValueLong   ( Integer row, Integer nDefault ){ return getValueLong   ( row.intValue(), nDefault.longValue());}
  //public double  getValueDouble ( Integer row, Integer nDefault ){ return getValueDouble ( row.intValue(), nDefault.doubleValue());}

//-----------------------------------------------------------------------------
  public boolean getValue( boolean bValor, int nRow ){
    return getValueBoolean(nRow);
  }
  public boolean getValueBoolean(int nRow){
    try {
      if( this.getType()==TYPE_BOOLEAN ){
        return ((Boolean)this.getObject(nRow)).booleanValue();
      }else
        return this.getText(nRow).equals("1");
    } catch (ArrayIndexOutOfBoundsException e) { }
      catch (NullPointerException en){}
    return false;
  }

//-----------------------------------------------------------------------------
  //public byte  getValue( byte  nValor, int row ){ return   UtilsNDG.getInstance().long2byte ( getValueLong( row )); }
  //public short getValue( short nValor, int row ){ return UtilsNDG.getInstance().long2short( getValueLong( row )); }
  //public int   getValue( int   nValor, int row ){ return UtilsNDG.getInstance().long2int  ( getValueLong( row )); }
  //public long  getValue( long  bValor, int row ){ return getValueLong( row ); }
  //public byte  getValueByte ( int row ){ return UtilsNDG.getInstance().long2byte ( getValueLong( row, GlUtil.NULL_BYTE  )); }
  //public short getValueShort( int row ){ return UtilsNDG.getInstance().long2short( getValueLong( row, GlUtil.NULL_SHORT )); }
  //public int   getValueInt  ( int row ){ return UtilsNDG.getInstance().long2int  ( getValueLong( row, GlUtil.NULL_INT   )); }
  //public long  getValueLong ( int row ){ return getValueLong( row, UtilsNDG.getInstance().NULL_LONG ); }
  //public byte  getValueByte ( int row, byte  nDefault ){ return GlUtil.long2byte ( getValueLong( row, nDefault  )); }
  //public short getValueShort( int row, short nDefault ){ return GlUtil.long2short( getValueLong( row, nDefault  )); }
  //public int   getValueInt  ( int row, int   nDefault ){ return GlUtil.long2int  ( getValueLong( row, nDefault  )); }
  /*public long  getValueLong ( int row, long nDefault ){
    long n = GlUtil.string2long(this.getText( row ));
    if( n == GlUtil.NULL_LONG )
      return nDefault;
    return n;
  }*/

//-----------------------------------------------------------------------------
  //public double getValue( double nValor, int nRow ){ return getValueDouble(nRow); }
  //public double getValueDouble( int nRow){ return getValueDouble(nRow, GlUtil.NULL_DOUBLE); }
  /*public double getValueDouble( int nRow, double nDefault ){
    double n = GlUtil.string2decimal(this.getText(nRow),this.getDecimals());
    if( n == GlUtil.NULL_DOUBLE )
      return nDefault;
    return n;
  }*/

//-----------------------------------------------------------------------------
  /*public Date getValue( Date dValor, int nRow ){
    return getValueDate(nRow);
  }*/
  /*public Date getValueDate( int nRow){
    return GlUtil.string2date(this.getText(nRow));
  }*/

//-----------------------------------------------------------------------------
  public String getValue( String cValor, int nRow ){
    return this.getText(nRow);
  }
  public String getValueString( int nRow){
    return this.getText(nRow);
  }

//-----------------------------------------------------------------------------
  public int newValue(){
    if( nTpDato==BUTTON_QRY ){
      veDataRow.add(new JButton(""));
    }
    else if( nTpDato==TYPE_BOOLEAN ){
      veDataRow.add(new Boolean(false));
    } 
    else
      veDataRow.add(new String(""));
    return veDataRow.size();
  }

//-----------------------------------------------------------------------------
  public boolean isEmpty( int nRow ){
    if( nRow >= veDataRow.size())
      return true;

    Object celda=(Object)veDataRow.elementAt( nRow );

    if( celda==null )
      return true;
    if( celda instanceof Celda )
      celda = ((Celda)celda).data;
    if( celda instanceof Boolean )
      return ! ((Boolean)celda).booleanValue();
    if( celda instanceof String )
      return ((String)celda).trim().length()==0 ;
    if( celda instanceof JButton )
      return ((JButton)celda).getText().trim().length()==0;
    return false;
  }

//-----------------------------------------------------------------------------
  public void deleteRow( int nRow ){
    if( this.isKey() && !this.isEmpty(nRow)){
      veDeletedRow.add(veDataRow.elementAt( nRow ));
    }
    try {
      veDataRow.removeElementAt( nRow );
    } catch (ArrayIndexOutOfBoundsException e ){
    }
  }

//-----------------------------------------------------------------------------
  public void clear(){
    veDataRow.removeAllElements();
    veDeletedRow.removeAllElements();
  }

//-----------------------------------------------------------------------------
  public void setText( boolean bValor, int nRow ){
    if( this.getType()==TYPE_BOOLEAN )
      this.setObject((Object)new Boolean(bValor), nRow);
    else
      this.setText(bValor ? "1":"0", nRow);
  }
//-----------------------------------------------------------------------------
  public void setText( byte nValor, int nRow ){
    this.setText((long)nValor, nRow);
  }
  public void setText( short nValor, int nRow ){
    this.setText((long)nValor, nRow);
  }
  public void setText( int nValor, int nRow ){
    this.setText((long)nValor, nRow);
  }
  public void setText( long nValor, int nRow ){
    if(this.getTrim() && nValor == 0 )
      this.setText("", nRow);
    else
      this.setText(String.valueOf(nValor), nRow);
  }
//-----------------------------------------------------------------------------
  /*public void setText( double nValor, int nRow ){
    if((this.getTrim() && nValor == 0 ) || UtilsNDG.getInstance().isNull(nValor))
      this.setText("", nRow);
    else
      this.setText( GlUtil.decimal2string(nValor, this.getDecimals()), nRow);
  }*/
//-----------------------------------------------------------------------------
  /*public void setText( DateTime dValor, int nRow ){
    this.setText( GlUtil.dateTime2string(dValor), nRow);
  }*/
//-----------------------------------------------------------------------------
  /*public void setText( Date dValor, int nRow ){
    this.setText( GlUtil.date2string(dValor), nRow);
  }*/
//------------------------------------------------------------------------------
   public void setText ( Integer iValor, int nRow ) {
      if ( iValor == null ) iValor = iValor.valueOf("0");
      this.setText(iValor.intValue(), nRow );
   }
//------------------------------------------------------------------------------
   public void setText( String cValor, int nRow ){
      if ( cValor == null ) cValor = "";
      if( this.getType()==TYPE_BOOLEAN )
         this.setObject((Object)new Boolean(cValor.equals("1")), nRow);
      else if( this.getTrim())
         this.setObject((Object)cValor.trim(), nRow);
      else
         this.setObject((Object)cValor, nRow);
  }
  
  
//-----------------------------------------------------------------------------
  public String getText( int nRow ){
    try {
      Object celda=(Object)veDataRow.elementAt( nRow );
      if( celda==null ) return "";
      if( celda instanceof Celda )
        celda = ((Celda)celda).data;
      if( celda instanceof Boolean )
        return ((Boolean)celda).toString();
      if( celda instanceof String )
        return ((String)celda); //.trim();
      if( celda instanceof JButton )
        return ((JButton)celda).getText();
    } catch (ArrayIndexOutOfBoundsException e) { }
    return "";
  }

//-----------------------------------------------------------------------------
  public void setObject(Object oValor, int nRow){
    ComboBoxApplet oCombo=null;
    Object celda=(Object)veDataRow.elementAt( nRow );

    if( celda instanceof Celda ) {
      /*if( this.getType()==TYPE_DECIMAL )
        ((Celda)celda).data=(Object)GlUtil.decimalFix(oValor.toString(),this.getDecimals());
      else if( this.getType()==TYPE_RUT )
        ((Celda)celda).data=GlUtil.formatRUT(oValor.toString().toUpperCase());
      else*/
        ((Celda)celda).data=oValor;
      veDataRow.setElementAt( celda, nRow );
    } else {
      switch( this.getType()){
      case TYPE_DECIMAL:
      case TYPE_FLOAT:
        /*double nd=GlUtil.string2decimal((String)oValor,this.getDecimals());
        if( nd == 0 && this.getTrim())
          veDataRow.setElementAt("", nRow );
        else
          veDataRow.setElementAt((Object)GlUtil.decimal2string(nd,this.getDecimals()), nRow );
        break;*/
      case TYPE_INTEGER:
        long nl=Long.parseLong((String)oValor);
        if( nl == 0 && this.getTrim())
          veDataRow.setElementAt("", nRow );
        else
          veDataRow.setElementAt(oValor, nRow);
        break;
      case TYPE_RUT:
        /*veDataRow.setElementAt(GlUtil.formatRUT(oValor.toString().toUpperCase()), nRow);
        break;*/
      default:
        veDataRow.setElementAt(oValor, nRow);
        break;
      }
    }
  }

//-----------------------------------------------------------------------------
  public Object getObject( int nRow){
    Object celda;
    try {
      celda = (Object)veDataRow.elementAt( nRow );
    } catch (ArrayIndexOutOfBoundsException e){
      System.out.println("Columna.getObject, no existe la fila" + ":" + nRow );
      return null;
    }

    if( celda instanceof Celda )
      celda = ((Celda)celda).data;
    if( celda instanceof JButton || celda instanceof Boolean )
      return celda;
    return (Object)this.getText(nRow);
  }

//-----------------------------------------------------------------------------
  protected void copyData( Columna colOrigen ){
    veDataRow    = (Vector)colOrigen.veDataRow.clone();
    veDeletedRow = (Vector)colOrigen.veDeletedRow.clone();
  }


/**
 *  Metodos sobre el Vector de filas borradas, solo válido para
 *  las columnas tipo KEY
 */
//-----------------------------------------------------------------------------
  public int getRowDeletedCount(){
    return veDeletedRow.size();
  }

//-----------------------------------------------------------------------------
  public boolean updateColRelation( int row ) {
    boolean bRefresh=false;

    // Actualiza las columnas combinadas con una Combo
    if( this.getColRelation() != null ){
      if( this.getType()==Columna.COMBO_BOX && this.getComboBox()!=null ){
        /**
         * Si la columna que se actualiza es la combo se cambia el valor
         * de la columna relacionada
         */
        ComboBoxApplet oCombo  =this.getComboBox();
        Columna   oColText=this.getColRelation();

        //if( oCombo.getCargando() ) return;
        if( oCombo.getKey()!=oColText.getText(row)) {
          oColText.setText(oCombo.getKey(),row);
          bRefresh=true;
        }
      } else if (this.getColRelation().getComboBox()!=null) {
        /**
         * Si la columna no es una combo pero está relacionada
         * a una combo
         */
        Columna   oColCombo=this.getColRelation();
        ComboBoxApplet oCombo   =this.getColRelation().getComboBox();
        //if( oCombo.getCargando() ) return;
        if( this.getText(row).trim().equals("")){
          oCombo.setNoIndex();
          oColCombo.setText(new String(""), row);
        } else {
          oCombo.setSelectedIndexByKey(this.getText(row));
          if( oCombo.getSelectedItem()==null ) {
            System.out.println("Columna.updateColRelation, no existe opcion dentro del combo");
            oColCombo.setText("", row);
          } else
            oColCombo.setText(oCombo.getSelectedItem().toString(), row);
        }
        bRefresh=true;
      }
    }
    return bRefresh;
  }

//-----------------------------------------------------------------------------
  public void traspasaInfo(){
    /**
     * Sirve para intercambiar momentaneamente a los datos borrados, así no es
     * necesario reescribir codigo para manejar el vector de datos borrados
     */
    Vector veAux=this.veDataRow;
    this.veDataRow=this.veDeletedRow;
    this.veDeletedRow=veAux;
  }
}

