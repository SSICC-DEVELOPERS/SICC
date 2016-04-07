package es.indra.sicc.comunapplet;


import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;

import java.util.Date;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import javax.swing.undo.UndoManager;

public class TextFieldApplet extends JTextField {
  public static final byte CASE_NONE  = 0;
  public static final byte CASE_UPPER = 2;
  public static final byte CASE_LOWER = 3;

  public static final byte TYPE_ALFANUMERICO= 0;
  public static final byte TYPE_ALFABETICO  = 1;
  public static final byte TYPE_INTEGER     = 2;
  public static final byte TYPE_DECIMAL     = 3;
  public static final byte TYPE_FLOAT       = 4;
  public static final byte TYPE_TIME        = 5;
  public static final byte TYPE_DATE        = 6;
  public static final byte TYPE_DATE_TIME   = 16;
  public static final byte TYPE_PERIODO     = 7;
  public static final byte TYPE_BOOLEAN     = 8;
  public static final byte TYPE_SI_NO       = 9;
  public static final byte TYPE_RUT         = 10;

  public static boolean paramClearBefore = false;

  private boolean trimeable     = false;
  private boolean formatear     = true;
  private boolean nullable      = false;
  private boolean positiv       = false;
  private boolean isObligatorio = false;
  private boolean isFocusCycle  = false; 
  private boolean bClearBefore = paramClearBefore;
  private int     caseModif = 0;
  private int     length    = 0;
  private int     decimals  = 0;
  private int     tipoDato  = TYPE_ALFANUMERICO;

  private ComboBoxApplet cbRelac= null;

  private boolean validActiv= true;
  private Toolkit toolkit;
  private TextFieldApplet mySuper=this;

  private UndoManager undo = new UndoManager();
//------------------------------------------------------------------------------
  public TextFieldApplet() {
    super();
    try {
      toolkit = Toolkit.getDefaultToolkit();
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
//------------------------------------------------------------------------------
  private void jbInit() throws Exception {
    this.setToolTipText("");
    this.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent e) {
        this_focusGained(e);
      }
      public void focusLost(FocusEvent e) {
        this_focusLost(e);
      }
    });
    this.addKeyListener(new java.awt.event.KeyAdapter() {
      /*public void keyReleased ( KeyEvent e) {
         this_keyPressed(e);
      }*/
      public void keyPressed(KeyEvent e) {
        this_keyPressed(e);
      }
    });
  }

  //========================================================================================================
  // Manipula propiedades de la clase
  //========================================================================================================
//-----------------------------------------------------------------------------
  public void setText(byte nValue){
      setText((long)nValue);
  }
  public void setText(short nValue){    
      setText((long)nValue);
  }
  public void setText(int nValue){
      setText((long)nValue);
  }
  public void setText(long nValue){
      super.setText(String.valueOf(nValue));
  }

//-----------------------------------------------------------------------------
  public void setText(double nValue){
    if( this.formatear )
      this.formatDecimal(nValue);
    else
      super.setText(String.valueOf(nValue));
  }
//------------------------------------------------------------------------------
  public void setText(String sValue){
      validActiv=false;
      super.setText(sValue);
      // Alinea el texto a la posición inicial
      if(super.getCaret().getDot()>1){
        super.getCaret().setDot(1);
        super.setCaret(this.getCaret());
      }
      validActiv=true;
    }
  

//-----------------------------------------------------------------------------
  public void setType(int t){
    switch ( t ){
    case TYPE_INTEGER:
    case TYPE_DECIMAL:
    case TYPE_FLOAT:
      super.setHorizontalAlignment(SwingConstants.RIGHT);
      break;
    }
    tipoDato=t;
    verificaLargo();
  }
  public int getType(){
    return tipoDato;
  }

//-----------------------------------------------------------------------------
  public void setTrim(boolean b){
    trimeable=b;
  }
  public boolean getTrim(){
    return trimeable;
  }

//-----------------------------------------------------------------------------
  /**
   * Esta propiedad hace que el texto al obtener el focus sea selecccionada
   * en forma automática
   */
  public void setClearBeforeEdit(boolean bClearBefore ){
    this.bClearBefore=bClearBefore;
  }
  public boolean getClearBeforeEdit(){
    return this.bClearBefore;
  }

//-----------------------------------------------------------------------------
  public void setLength(int l){
    length=l;
    verificaLargo();
  }
  public int getLength(){
    return length;
  }

//-----------------------------------------------------------------------------
  public void setDecimals(int d){
    if( d > 0 ) {
      switch( this.getType()){
      case TYPE_DECIMAL:
      case TYPE_FLOAT:
        // this.setFormating(true);
        break;
      }
    } else if ( d < 0 )
      d=0;
    decimals=d;
  }
  public int getDecimals(){
    return decimals;
  }

//-----------------------------------------------------------------------------
  public void setNullable(boolean n){
    nullable=n;
  }
  public boolean getNullable(){
    return nullable;
  }

//-----------------------------------------------------------------------------
  public void setCase(int c){
    caseModif=c;
  }
  public int getCase(){
    return caseModif;
  }

//-----------------------------------------------------------------------------
  public void setPositiv(boolean p){
    positiv=p;
  }
  public boolean getPositiv(){
    return positiv;
  }
//------------------------------------------------------------------------------
   public void setObligatorio ( boolean isObligatorio ) {
      this.isObligatorio = isObligatorio;
   }

   public boolean isObligatorio () {
      return this.isObligatorio;
   }
//------------------------------------------------------------------------------
   public void setFocusCycle ( boolean bValor ) {
      this.isFocusCycle = bValor;
   }
   public boolean getFocusCycle () {
      return this.isFocusCycle;
   }
//------------------------------------------------------------------------------
  public void setCombo(ComboBoxApplet cb){
    cbRelac=cb;
  }
  public ComboBoxApplet getCombo(){
    return cbRelac;
  }

//-----------------------------------------------------------------------------
  public void setFormating(boolean b){
    this.formatear=b;
  }
  public boolean getFormating(){
    return formatear;
  }

//-----------------------------------------------------------------------------
  public boolean getValue( boolean bValor ){
    return getValueBoolean();
  }
  public boolean getValueBoolean(){
      return this.getText().equals("1");
  }

//-----------------------------------------------------------------------------
  public long  getValue( long  bValor ){ return getValueLong(); }
  public long getValueLong(){
    return 0;  
  }

//-----------------------------------------------------------------------------
  public double getValue( double nValor ){
    return 0;  
  }

//-----------------------------------------------------------------------------
  public Date getValue( Date dValor ){
    return getValueDate();
  }
  public Date getValueDate(){
    return null;
  }

//-----------------------------------------------------------------------------
  public String getValue( String cValor ){
    return this.getText();
  }
  public String getValueString(){
    return this.getText();
  }

//-----------------------------------------------------------------------------
  public String getTextNoFormat(){
    return this.getText();
  }

//-----------------------------------------------------------------------------
  private void verificaLargo(){
    switch( tipoDato ){
    case TYPE_ALFANUMERICO:
      length = 17;
      break;
    case TYPE_TIME:
      length=8;
      break;
    case TYPE_DATE:
      length=10;
      break;
    case TYPE_PERIODO:
      length=7;
      break;
    case TYPE_BOOLEAN:
      length=1;
      break;
    case TYPE_SI_NO:
      length=1;
      break;
    case TYPE_RUT:
      length=12;
      break;
    }
  }

//-----------------------------------------------------------------------------
  public void updateRelation(){
    if( cbRelac != null ){
      String cAux=this.getText(); // Esta variable es necesaria porque la combo
                                  // tiene un metodo que puede borrar el contenido
                                  // si no existe el valor en la combo
      cbRelac.setSelectedIndexByKey( cAux );
      //cbRelac.setSelectIndexByKey(cAux);
      super.setText(cAux);
    }
  }

//-----------------------------------------------------------------------------
  public boolean isEmpty(){
    String c=this.getText();
    if( c==null )
      return true;
    return c.trim().length()==0;
  }

//========================================================================================================
// Manipula eventos de la clase
//========================================================================================================
//-----------------------------------------------------------------------------
  void this_keyPressed( KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_ENTER ){
      transferFocus();
      e.consume();
    }
    switch ( e.getKeyCode() ) {
       case KeyEvent.VK_DOWN: {
          e.consume();
          this.getToolkit().beep();
          break;
       }
       case KeyEvent.VK_UP:{
          e.consume();
          this.getToolkit().beep();
          break;
       }
       case KeyEvent.VK_TAB: {
          e.consume();
          this.getToolkit().beep();
          break;
       }
    }
  }

//-----------------------------------------------------------------------------
  void this_focusGained(FocusEvent e) {
    if( getClearBeforeEdit()){
      // Deja el texto seleccionada al recibir el foco
      String s=super.getText();
      if( s.length() > 0 ){
        super.setSelectionStart( 0 );
        super.setSelectionEnd  ( s.length());
      }
    }
  }

//-----------------------------------------------------------------------------
  void this_focusLost(FocusEvent e) {
    this.validActiv=false;
    switch( tipoDato ){
    case TYPE_INTEGER:
      if(this.getText().equals("-"))
        this.setText("");
      else if(this.getTrim() && Long.parseLong(this.getText())==0 )
        this.setText("");
      break;
    case TYPE_DECIMAL:
    case TYPE_FLOAT:
    case TYPE_TIME:
      // no valido
      break;
    case TYPE_DATE:
    case TYPE_PERIODO:
      break;
    case TYPE_RUT:
    default:
      if(this.getTrim() && !this.getText().trim().equals(this.getText()))
        this.setText(this.getText().trim());
    }
    this.validActiv=false;
    this.updateRelation();
    this.validActiv=true;
  }

//-----------------------------------------------------------------------------
  private void formatDecimal(double nValue){
    this.validActiv=false;
    this.validActiv=true;
  }

//-----------------------------------------------------------------------------
  
  protected Document createDefaultModel() {
    return new WholeNumberDocument();
  }
//========================================================================================================
// Override Sub-Clase PlainDocument
//========================================================================================================
//-----------------------------------------------------------------------------
  protected class WholeNumberDocument extends PlainDocument {
    private static final String minusculas="abcdefghijklmnopqrstuvwxyzáéíóúüñ";
    private static final String mayusculas="ABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚÜÑ";
    private static final String simbolos=" .,:;-+?!$%/#º()[]{}\"'";

    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
      String result;
      if( !validActiv ){
        super.insertString(offs, str, a);
        return;
      }
      if(length!=0 && this.getLength()>=length){
         if ( getFocusCycle() ) {
            toolkit.beep();
            super.insertString(offs, "", a);
            return;
         } else {
            super.insertString(offs, str, a);
            transferFocus();  
         }   
      } 

      switch( tipoDato ){
         case TYPE_INTEGER:
            result=digitaInteger(offs, str);
            break;
         case TYPE_ALFANUMERICO:
            result=digitaAlfanumerico(offs, str);
            break;
         case TYPE_ALFABETICO:
            result=digitaAlfabetico(offs, str);
            break;
         case TYPE_DECIMAL:
            result=digitaDecimal(offs, str);
            break;
         case TYPE_FLOAT:
            // Por ahora se usa la misma, pero falta controlar la cantidad de decimales
            result=digitaFlotante(offs, str);
            break;
         case TYPE_TIME:
            result=digitaHora(offs, str);
            break;
         case TYPE_DATE:
            result=digitaFecha(offs, str);
            break;
         case TYPE_PERIODO:
            result=digitaPeriodo(offs, str);
            break;
         case TYPE_BOOLEAN:
            result=digitaLogico(offs,str);
            break;
         case TYPE_SI_NO:
            result=digitaSiNo(offs,str);
            break;
         case TYPE_RUT:
            result=digitaRUT(offs,str);
            break;
         default:
            result="";
        }
        super.insertString(offs, result, a);
    }

//-----------------------------------------------------------------------------
    private String digitaInteger(int offs, String str) throws BadLocationException {
      char[] source = str.toCharArray();
      char[] result = new char[source.length];
      int j = 0;
      for (int i = 0; i < result.length; i++) {
        switch( source[i] ){
        case '0': case '1': case '2': case '3': case '4':
        case '5': case '6': case '7': case '8': case '9':
          result[j++] = source[i]; break;
        case '-':
          if(!mySuper.positiv && offs==0 && !this.getText(0,1).equals("-"))
            result[j++] = source[i];
          else
            toolkit.beep();
          break;
        default:
          toolkit.beep();
        }
      }
      return(new String(result, 0, j));
    }

//-----------------------------------------------------------------------------
    private String digitaDecimal(int offs, String str) throws BadLocationException {
  
      return "";
    }

//-----------------------------------------------------------------------------
    private String digitaFlotante(int offs, String str) throws BadLocationException {
      char[] source = str.toCharArray();
      char[] result = new char[source.length];
      int j = 0;
      for (int i = 0; i < result.length; i++) {
        switch( source[i] ){
        case '0': case '1': case '2': case '3': case '4':
        case '5': case '6': case '7': case '8': case '9':
          result[j++] = source[i]; break;
        case '-':
          if(!mySuper.positiv && offs==0 && !this.getText(0,1).equals("-"))
            result[j++] = source[i];
          else
            toolkit.beep();
          break;
        case '.':          
          break;
        case ',':
        default:
          toolkit.beep();
        }
      }
      return(new String(result, 0, j));
    }

//-----------------------------------------------------------------------------
    private String digitaAlfabetico(int offs, String str) throws BadLocationException {
      char[] source = str.toCharArray();
      char[] result = new char[source.length];
      int j = 0, p;
      for (int i = 0; i < result.length; i++) {
        if((minusculas+mayusculas+simbolos).indexOf(source[i]) >= 0){
          if(getCase()==CASE_UPPER && (p=minusculas.indexOf(source[i])) >= 0){
            result[j++] = mayusculas.charAt(p);
          }
          else if(getCase()==CASE_LOWER && (p=mayusculas.indexOf(source[i])) >= 0){
            result[j++] = minusculas.charAt(p);
          }
          else
            result[j++] = source[i];
        }
        else
          toolkit.beep();
      }
      return(new String(result, 0, j));
    }

//-----------------------------------------------------------------------------
    private String digitaAlfanumerico(int offs, String str) throws BadLocationException {
      char[] source = str.toCharArray();
      char[] result = new char[source.length];
      int j = 0, p;
      for (int i = 0; i < result.length; i++) {
        if(getCase()==CASE_UPPER && (p=minusculas.indexOf(source[i])) >= 0){
          result[j++] = mayusculas.charAt(p);
        }
        else if(getCase()==CASE_LOWER && (p=mayusculas.indexOf(source[i])) >= 0){
          result[j++] = minusculas.charAt(p);
        }
        else
          result[j++] = source[i];
      }
      return(new String(result, 0, j));
    }

//-----------------------------------------------------------------------------
    private String digitaSiNo(int offs, String str) throws BadLocationException {
      char[] source = str.toCharArray();
      String result=" ";
      for (int i = 0; i < source.length; i++) {
        switch(source[i]){
        case 'S': case 's': case 'Y': case 'y':
          result="S";
        case 'N': case 'n':
          result="N";
        default:
          toolkit.beep();
        }
      }
      return(result);
    }

//-----------------------------------------------------------------------------
    private String digitaLogico(int offs, String str) throws BadLocationException {
      char[] source = str.toCharArray();
      String result=" ";
      for (int i = 0; i < source.length; i++) {
        switch(source[i]){
        case '0':
          result="0";
        case '1':
          result="1";
        default:
          toolkit.beep();
        }
      }
      return(result);
    }

//-----------------------------------------------------------------------------
    private String digitaFecha(int offs, String str) throws BadLocationException {
      char[] source = str.toCharArray();
      char[] result = new char[source.length];
      int j = 0;
      for(int i = 0; i < result.length; i++) {
        switch(source[i]){
        case '0': case '1': case '2': case '3': case '4':
        case '5': case '6': case '7': case '8': case '9':
          result[j++] = source[i]; break;
        case '-': case '/':
          if(countChar(this.getText(0,this.getLength()),"-/")<2)
            result[j++] = source[i];
          else
            toolkit.beep();
          break;
        default:
          toolkit.beep();
        }
      }
      return(new String(result, 0, j));
    }

//-----------------------------------------------------------------------------
    private String digitaHora(int offs, String str) throws BadLocationException {
      return str;
    }

//-----------------------------------------------------------------------------
    private String digitaPeriodo(int offs, String str) throws BadLocationException {
      return str;
    }

//-----------------------------------------------------------------------------
    private String digitaRUT(int offs, String str) throws BadLocationException {
      char[] source = str.toCharArray();
      char[] result = new char[source.length];
      int    j      = 0;
      String s      = this.getText(0,this.getLength());
      int posGuion  = s.indexOf("-");
      int posK      = s.indexOf("K");

      for (int i = 0; i < result.length; i++) {
        switch( source[i] ){
        case '0': case '1': case '2': case '3': case '4':
        case '5': case '6': case '7': case '8': case '9':
          // Mas de un caracter como DV
          if((posGuion >= 0 && offs - posGuion >= 2 ) || ( posK >= 0 && offs - posK >= 1 ))
            toolkit.beep();
          else if(countChar(s,"0123456789K") >= 9)
            toolkit.beep();
          else
            result[j++] = source[i];
          break;
        case '-':
          if( offs==0 || posGuion>=0 )
            toolkit.beep();
          else if( this.getLength() - offs > 1 )
            toolkit.beep();
          else
            result[j++] = source[i];
          break;
        case 'k':
          source[i]='K';
        case 'K':
          if( offs==0 || posK > 0)
            toolkit.beep();
          else if(countChar(s,"0123456789K") >= 9)
            toolkit.beep();
          else {
            // Mas de un caracter como DV
            if( posGuion >= 0 && offs - posGuion >= 2 )
              toolkit.beep();
            else
              result[j++] = source[i];
          }
          break;
        default:
          toolkit.beep();
        }
      }
      return(new String(result, 0, j));
    }

//-----------------------------------------------------------------------------
    private int countChar(String s, String sFind){
      return countChar(s.toCharArray(), sFind);
    }
    private int countChar(char [] source, String sFind){
      int count=0;

      for( int i=0; i<source.length; i++){
        if( sFind.indexOf(source[i])>= 0 )
          count++;
      }
      return count;
    }
  }
}

