package es.indra.sicc.comunapplet;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import java.awt.Point;
public class TablaApplet  extends JTable implements FocusListener, KeyListener {
  private  Vector veCols            = new Vector();
  protected Vector veIsUpdate       = new Vector();
  private String  tableName         = null;
  private boolean bColorAdmin       = false;
  private boolean bEditable         = true;
  private boolean bInsertCapable    = true;
  private boolean bDeleteCapable    = true;
  private boolean bSortCapable      = false;
  private String  msgError          = "";

  private int     rowPosAnt  = -1;
  private int     colPosAnt  = -1;

  protected int   firstColumn = 0;
  protected int   lastColumn  = 0;  
   
  private boolean bIsEditingTextField   = false;

  private Color   colorBackSelected = new Color(205,204,255);
  private Color   colorBackNormal   = new Color(204,204,204);
  private Color   colorBackDisabled = new Color(224,224,248);
  private Color   colorGridEnabled  = new Color(153,152,153);
  private Color   colorGridDisabled = Color.white;
  private Color   colorFocus        = Color.white;
  private Color   colorBack         = colorBackNormal;

  private static final String CHARS_INIT_EDITING=" 01234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz,./<>?;:'\"[]{}|\\=+-_()*&^%$#@!~`ñÑ";
  private TablaApplet THIS=this;

//  private static final int ROW_STATUS_INSERT = 1;
  private static final int ROW_STATUS_UPDATE = 1;
  private static final int ROW_STATUS_CHANGE = 2;

// Modelo Abstracto de Sort
  //private GrillaSorterNdg sorter = null;


  protected boolean onError = false;
  
//-----------------------------------------------------------------------------
  public TablaApplet( String tableName ) {
    this.tableName=tableName;
  }
  
  public TablaApplet( String tableName, Boolean bColorAdmin ) {
    this.tableName=tableName;
    this.bColorAdmin = bColorAdmin.booleanValue();
  }

//-----------------------------------------------------------------------------
  public TablaApplet( String tableName, boolean bSort ) {
    this.tableName=tableName;
    this.bSortCapable = bSort;
  }

//-----------------------------------------------------------------------------
  public void init() {
    this.init( this.AUTO_RESIZE_OFF );
  }
  public void init( int nAutoResizeMode ) {
    super.setBackground(this.colorAlternativo(colorBackNormal));
    colorBack=colorBackNormal;
    try {
      this.jbInit();
      if( isInsertCapable()) {
        newRow();
      } else {
       newRow();
      }
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    super.autoResizeMode = nAutoResizeMode;
  }
/**-----------------------------------------------------------------------------
 * Comienzo del método jbInit
 * ---------------------------------------------------------------------------*/
  private void jbInit() throws Exception {
    setCellEditor(new DefaultCellEditor( new TextFieldApplet()));

    addKeyListener( this );
    addMouseListener(new java.awt.event.MouseAdapter() {
      
      public void mouseClicked(MouseEvent e){
        this_mousePressed(e);
      }
      
    });
    AbstractTableModel modelo = new AbstractTableModel(){
      public int getColumnCount() { return veCols.size(); }
      public int getRowCount() { return THIS.getRowCount(); }
      public String getColumnName(int col) { return getColumn(col).getTitle(); }
      public Class getColumnClass(int c) { return getColumn(c).getObject(0).getClass(); }
      public void setValueAt(Object oValue, int row,  int col) {
        setIsChange( true, row );
        Columna oCol=((Columna)veCols.elementAt(col));
        /*if( oCol.getType()==Columna.TYPE_DATE )
          oCol.setObject(GlUtil.completaDate(oValue.toString()), row);
        else*/
          oCol.setObject(oValue, row);
        if(oCol.updateColRelation(row))
          refresh();
        setCell(oValue,row,col);
      }
      public boolean isCellEditable(int row, int col){
        if( !isEditable()) return false;
        Boolean bUserDef=isEditable(row, col);
        if( bUserDef==null )
          return ((Columna)veCols.elementAt(col)).getEditable();
        return bUserDef.booleanValue();
      }
      public Object getValueAt(int row, int col){
        if((getSelectedColumn()==col && getSelectedRow()==row ) &&
           (rowPosAnt != row || colPosAnt!= col)) {
          // Si hay cambio de posición dentro de la grilla se termina la edicion
          bIsEditingTextField=false;
          changePosition(row, col);
          rowPosAnt=row;
          colPosAnt=col;
        }
        return ((Columna)veCols.elementAt(col)).getObject( row );
      }
    };
    // Activa Ordenamiento
//    if( this.isSortCapable()){
//      sorter = new GrillaSorterNdg( modelo );
//      setModel( sorter );
//      sorter.addMouseListenerToHeaderInTable( this );
//    } else {
      setModel( modelo );
//    }
    // Se apunta a si mismo porque la clase implementa FocusListener
    this.addFocusListener(this);

    autoResizeMode=this.AUTO_RESIZE_OFF;
    Columna    col=null;
    TextFieldApplet text=null;
    JCheckBox   check=null;
    DefaultTableCellRenderer rightColumnRenderer = new DefaultTableCellRenderer();
    DefaultTableCellRenderer centerColumnRenderer = new DefaultTableCellRenderer();

    rightColumnRenderer.setHorizontalAlignment(JLabel.RIGHT);
    centerColumnRenderer.setHorizontalAlignment(JLabel.CENTER);

    // Modifica los editores de las celdas segun el tipo de columna
    super.autoResizeMode=JTable.AUTO_RESIZE_OFF;
    for( int i=0 ; i < getColCount() ; i++ ){
      col=(Columna)veCols.elementAt(i);

      // Set Editor
      switch( col.getType() ){
      case Columna.COMBO_BOX:
        this.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(col.getComboBox()));
        break;
      case Columna.TYPE_ALFANUMERICO:
      case Columna.TYPE_ALFABETICO:
        text = new TextFieldApplet();
        text.addFocusListener(this);
        text.setType(col.getType());
        text.setLength(col.getLength());
        text.setCase(col.getCase());
        getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor( text ));
        break;
      case Columna.TYPE_INTEGER:
      case Columna.TYPE_DECIMAL:
      case Columna.TYPE_FLOAT:
        text = new TextFieldApplet();
        text.addFocusListener(this);
        text.setType(col.getType());
        text.setLength(col.getLength());
        text.setPositiv(col.getPositiv());
        text.setDecimals(col.getDecimals());
        getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor( text ));
        break;
      case Columna.TYPE_TIME:
      case Columna.TYPE_DATE:
      case Columna.TYPE_PERIODO:
      case Columna.TYPE_SI_NO:
        text = new TextFieldApplet();
        text.addFocusListener(this);
        text.setType(col.getType());
        getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor( text ));
        break;      
      }
      

      // Set Renderer, cambia la forma de visualizacion de los objetos
      switch( col.getType() ){
      case Columna.TYPE_BOOLEAN:
        // Se ve como check
        this.getColumnModel().getColumn(i).setCellRenderer(new GlGrillaBooleanRenderer());
        break;
      case Columna.BUTTON_QRY:
        // Se ve in funciona como boton
        this.getColumnModel().getColumn(i).setCellRenderer(new GlGrillaButtonRenderer());
        break;
      default:
        // Maneja el color si se especifico Administracion de Color
        if( bColorAdmin ){
          GlGrillaDefaultRenderer renderCol=new GlGrillaDefaultRenderer();
          renderCol.setHorizontalAlignment(col.getAlignement());
          this.getColumnModel().getColumn(i).setCellRenderer(renderCol);
        } else {
          if( col.getAlignement()!=Columna.ALIGN_LEFT ){
            DefaultTableCellRenderer alingRender = new DefaultTableCellRenderer();
            alingRender.setHorizontalAlignment(col.getAlignement());
            this.getColumnModel().getColumn(i).setCellRenderer(alingRender);
          }
        }
        break;
      }
      // Setea las columnas Invisibles
      if( col.getVisible() )
        this.getColumnModel().getColumn(i).setPreferredWidth(col.getWidth());
      else {
        this.getColumnModel().getColumn(i).setMaxWidth(-1);
        this.getColumnModel().getColumn(i).setMinWidth(-1);
        this.getColumnModel().getColumn(i).setPreferredWidth(-1);
        this.getColumnModel().getColumn(i).setResizable(false);
      }
    }
  }
/**-----------------------------------------------------------------------------
 * Fin jbInit
 * ---------------------------------------------------------------------------*/
 
/**
 * Implementa --> FocusListener
 */
  public void focusLost(FocusEvent e){
  
    // Al perder el focus la grilla, también pierde la edición
    bIsEditingTextField=false;
    /**
     * Salio de un texto desde la grilla, se detiene la edicion para que el
     * valor sea traspasado a la grilla
     */
    if(this.getCellEditor()==null)
      return;
    if( e.getComponent() instanceof TextFieldApplet ||
        ( e.getComponent() instanceof TablaApplet && bIsEditingTextField )){
      bIsEditingTextField=false;

      //se obtiene el indice de la columna actual antes de hacer el stopCellEditing
      this.firstColumn = this.getEditingColumn();
      
      this.getCellEditor().stopCellEditing();
      
    }
  }
  
  public void focusGained(FocusEvent e){
    if ( lastColumn == firstColumn ) {
      if( e.getComponent() instanceof TextFieldApplet ||
          ( e.getComponent() instanceof TablaApplet && bIsEditingTextField )) {
        TextFieldApplet text = ( TextFieldApplet ) e.getComponent();
        text.setFocusCycle( true );
      }
    }
    
    if(onError){
      onError = false;
      editCellAt( this.getSelectedRow(), firstColumn );
      this.getEditorComponent().requestFocus();
    }
  }
  
//------------------------------------------------------------------------------
  public void keyReleased ( KeyEvent e ) {
    if(this.getValueAt( this.getSelectedRow(), firstColumn ) != null && !this.getValueAt( this.getSelectedRow(), firstColumn ).toString().equals("") ){
      this.this_keyReleased( e );
    }
  }
   
   public void keyTyped ( KeyEvent e) {
   }
   
   public void keyPressed ( KeyEvent e){
   }
//-----------------------------------------------------------------------------
  public void setTableName( String tableName ){
    this.tableName=tableName;
  }
  public String getTableName(){
    return this.tableName;
  }
//-----------------------------------------------------------------------------
  public void setEnabled(boolean enabled){
    super.setEnabled(enabled);
    if( enabled ) {
      super.setGridColor(colorGridEnabled);
      super.setBackground(this.colorAlternativo(colorBackNormal));
      colorBack=colorBackNormal;
    } else {
      this.stopEditing();
      super.setGridColor(colorGridDisabled);
      super.setBackground(this.colorAlternativo(colorBackDisabled));
      colorBack=colorBackDisabled;
    }
    this.refresh();
  }
//-----------------------------------------------------------------------------
  public void setColorAdmin(boolean bColorAdmin ){
    this.bColorAdmin=bColorAdmin;
  }
  public boolean getColorAdmin(){
    return this.bColorAdmin;
  }

//-----------------------------------------------------------------------------
  public void setInsertCapable(boolean bInsertCapable ){
    this.bInsertCapable=bInsertCapable;
  }
  public boolean isInsertCapable(){
    return this.bInsertCapable;
  }

//-----------------------------------------------------------------------------
  public void setDeleteCapable(boolean bDeleteCapable ){
    this.bDeleteCapable=bDeleteCapable;
  }
  public boolean isDeleteCapable(){
    return this.bDeleteCapable;
  }

//-----------------------------------------------------------------------------
  public void setSortCapable(boolean bSortCapable ){
    this.bSortCapable=bSortCapable;
  }
  public boolean isSortCapable(){
    return this.bSortCapable;
  }
//-----------------------------------------------------------------------------
  public void setColorBackground( Color color, int vnRow ){
    for( int i=0 ; i<this.getColCount() ; i++ )
      this.getColumn(i).setColorBackground(color, vnRow);
    this.refresh();
  }

//-----------------------------------------------------------------------------
  public void setColorBackground( Color color ){
    for( int i=0 ; i<this.getColCount() ; i++ )
      this.getColumn(i).removeColorBackground();
    colorBackNormal=color;
    colorBack=color;
    super.setBackground(this.colorAlternativo(color));
    this.refresh();
  }
//-----------------------------------------------------------------------------
  public Color getColorBackground( int vnRow ){
    Color color=getColumn(0).getColorBackground(vnRow);

    for( int i=1 ; i<this.getColCount() ; i++ ) {
      if( color != this.getColumn(i).getColorBackground(vnRow))
        return null;
    }
    return color;
  }
//-----------------------------------------------------------------------------
  public void setMsgError(String msgError){
    this.msgError=msgError;
  }
  public String getMsgError(){
    return this.msgError;
  }

/******************************************************************************
  Manejo de Eventos
******************************************************************************/
//-----------------------------------------------------------------------------
  public void add( Columna col ){
    for( int i=0 ; i < veCols.size() ; i++ ){
      if( ( Columna ) veCols.elementAt( i ) == col ){
         //System.out.println("El objeto columna ya existe"  + ": " + col.getTitle());
         return;
      }
    }
    col.setIndex(veCols.size());
    veCols.add(col);
  }
//-----------------------------------------------------------------------------
   void this_keyReleased(KeyEvent e) {
      /**!isRowEmpty(getSelectedRow()) && */
      
      if( e.getKeyCode()==KeyEvent.VK_ENTER && getSelectedRow()>=getRowCount()-1 &&
          isInsertCapable() && validacionesAdicionales().booleanValue()) {

        if(this.lastColumn != this.firstColumn){
          editCellAt( this.getSelectedRow(), ++this.firstColumn );
          this.getEditorComponent().requestFocus();
        }else{
          this.firstColumn = 0; 
          int row = newRow();
          editCellAt( row, 0 );
          setRowSelectionInterval(row, row);
          getColumnModel().getSelectionModel().setSelectionInterval(0,this.veCols.size());
          getEditorComponent().requestFocus();
          scrollRectToVisible(this.getCellRect(row,0,true));
        }

      }else if(e.getKeyCode()==KeyEvent.VK_ENTER && getSelectedRow()<getRowCount()-1 &&
        isInsertCapable() && validacionesAdicionales().booleanValue()){

        if(this.lastColumn != this.firstColumn){
          editCellAt( this.getSelectedRow(), ++this.firstColumn );
          this.getEditorComponent().requestFocus();
        }else{
          this.firstColumn = 0; 
          int row = this.getSelectedRow() + 1;
          editCellAt( row, 0 );
          setRowSelectionInterval(row, row);
          getColumnModel().getSelectionModel().setSelectionInterval(0,this.veCols.size());
          getEditorComponent().requestFocus();
          scrollRectToVisible(this.getCellRect(row,0,true));
        }

      } else if( e.getKeyCode()==KeyEvent.VK_DELETE && e.getModifiers()==KeyEvent.CTRL_MASK &&
          isDeleteCapable()) {
        deleteRow(this.getSelectedRow());
        e.consume();
      } else if ( e.getKeyCode()==KeyEvent.VK_SPACE ) {
         Columna col=getColumn(this.convertColumnIndexToModel(getSelectedColumn()));
         if ( col != null ) {
         if ( col.getType()==Columna.BUTTON_QRY )
            execButton(this.getSelectedRow(),this.convertColumnIndexToModel(getSelectedColumn()));
         else if( col.getType()==Columna.COMBO_BOX)
            e.setKeyCode(KeyEvent.VK_F2);
         }
      } 

    // Si comienza edición, es importante verificar el String 'strChrEditing',
    if( CHARS_INIT_EDITING.indexOf(e.getKeyChar()) > 0 || e.getKeyCode()==KeyEvent.VK_BACK_SPACE ){
      if( ! bIsEditingTextField ){
        Columna oCol=this.getColumn(this.getSelectedColumn());
        // La edición no comienza si no esta el focus sobre una columna
        if( oCol != null ){
          bIsEditingTextField=true;
          // Borra el contenido de la celda antes de entrar a Edición
          if( oCol.getClearBeforeEdit())
            oCol.setText("",this.getSelectedRow());
        }
      } else {
        // Cualquier otra tecla implica fin de la edición
        bIsEditingTextField=false;
      }
    }

    //this.key_Releassed ( e );
  }
//------------------------------------------------------------------------------
   public Boolean validacionesAdicionales () {
      return new Boolean(true);
   }
//------------------------------------------------------------------------------
  void this_mousePressed(MouseEvent e) {
  
    //int nCol=this.convertColumnIndexToModel(getSelectedColumn());
    //if(getColumn(nCol)!=null && getColumn().getType()==Columna.BUTTON_QRY)
    //  execButton(this.getSelectedRow(),this.convertColumnIndexToModel(getSelectedColumn()));
      
    if ( e.getClickCount() == 1 && e.getButton() == MouseEvent.BUTTON1 ) {
      Point p = e.getPoint();
  
      int col = this.columnAtPoint(p);
      int row = this.rowAtPoint(p);

      System.out.println( "fila: " + row + " columna: " + col );
  
      firstColumn = col;
  
      this.editCellAt( row, col );
      if(this.getEditorComponent() != null) {
        this.getEditorComponent().requestFocus();
      }

      getColumnModel().getSelectionModel().setSelectionInterval(row, col);
      scrollRectToVisible(this.getCellRect(row, col, true));
    }
  }

/******************************************************************************
  Métodos propios
******************************************************************************/
//-----------------------------------------------------------------------------
  public void clearData(){
    for( int i=0 ; i < this.getColCount() ; i++ )
      this.getColumn(i).clear();
    veIsUpdate.clear();
    this.reallocateIndexes();
    rowPosAnt=-1;
    colPosAnt=-1;
  }   
//-----------------------------------------------------------------------------
  public void copyData( TablaApplet grOrigen ){
    Object obj;

    this.clearData();
    for( int col=0 ; col < grOrigen.getColCount() ; col++ )
       getColumn( col ).copyData( grOrigen.getColumn( col ));
    this.reallocateIndexes();
    rowPosAnt=-1;
    colPosAnt=-1;
  }

//-----------------------------------------------------------------------------
  public void clear(){
    this.clearData();
    if( isInsertCapable())
      this.newRow();
    this.refresh();
  }
//-----------------------------------------------------------------------------
  public void deleteRow(int row){
    for( int i=0 ; i < this.getColCount() ; i++ )
      getColumn(i).deleteRow(row);
    try {
      veIsUpdate.removeElementAt(row);
    } catch (Exception e){}
    if( isInsertCapable() && getRowCount()==0 )
      newRow();
    this.refresh();
    if(row>=getRowCount())
      row=getRowCount()-1;
    this.changeSelection(row,convertColumnIndexToModel(getSelectedColumn()),true,false);
    this.reallocateIndexes();
    this.refresh( row );
  }

//-----------------------------------------------------------------------------
  public int newRow(){
    int nRow=0;
    for( int i=0 ; i < this.getColCount() ; i++ )
      nRow=getColumn(i).newValue();
    this.refresh();
    this.setIsUpdate( false, nRow-1 );
    return (nRow-1);
  }

//-----------------------------------------------------------------------------
  private int getVectorIsUpdate( int row ){
    int i;

    try {
      Integer ins = (Integer)veIsUpdate.elementAt( row );
      i = ins.intValue();
    } catch (Exception e){
      i = 0;
    }
    return i;
  }

//-----------------------------------------------------------------------------
  private void setVectorIsUpdate(boolean bActiva, int row, int status ){
    int i = getVectorIsUpdate( row );
    if( bActiva )
      i = i | status;
    else
      i = i & ~status;
    if( veIsUpdate.size() <= row )
      veIsUpdate.setSize( row+ 1);
    veIsUpdate.setElementAt( new Integer( i ), row);
  }

//------------------------------------------------------------------------------
  protected void setIsUpdate(boolean update, int row){
    setVectorIsUpdate(update, row, ROW_STATUS_UPDATE );
  }
  public boolean isUpdate(int row){
    return (getVectorIsUpdate( row ) & ROW_STATUS_UPDATE) == ROW_STATUS_UPDATE;
  }

//-----------------------------------------------------------------------------
  protected void setIsChange(boolean change, int row){
    setVectorIsUpdate(change, row, ROW_STATUS_CHANGE );
  }
  public boolean isChange(int row){
    return (getVectorIsUpdate( row ) & ROW_STATUS_CHANGE) == ROW_STATUS_CHANGE;
  }

//-----------------------------------------------------------------------------
  public void setEditable( boolean bEditable){
   this.bEditable = bEditable;
  }
  public boolean getEditable(){
   return this.bEditable;
  }
  public boolean isEditable(){
   return this.bEditable;
  }

//-----------------------------------------------------------------------------
  public void stopEditing(){
    if(this.getCellEditor()!=null)
      this.getCellEditor().stopCellEditing();
  }
//-----------------------------------------------------------------------------
  public void refresh(int row){
    if( row > 0 ){
      ((AbstractTableModel)getModel()).fireTableRowsUpdated(row,row);
      this.reallocateIndexes();
    }
  }
  public void refresh(){
    ((AbstractTableModel)this.getModel()).fireTableDataChanged();
    this.reallocateIndexes();
  }

//-----------------------------------------------------------------------------
  public void refreshStructure(){
    ((AbstractTableModel)this.getModel()).fireTableStructureChanged();
  }

//-----------------------------------------------------------------------------
  public Columna getColumn(){
    return this.getColumn(super.convertColumnIndexToModel(super.getSelectedColumn()));
  }
  public Columna getColumn(int col ){
    try {
      return (Columna)veCols.elementAt(col);
    } catch ( ArrayIndexOutOfBoundsException e ) {
    }
    return null;
  }

//-----------------------------------------------------------------------------
  public boolean isRowEmpty(int vnRow){
    for( int i=0 ; i < this.getColCount() ; i++ )
      if( !getColumn(i).isEmpty(vnRow)) return false;
    return true;
  }

//-----------------------------------------------------------------------------
  public void deleteEmptyRows(){
    for( int i=this.getRowCount() ; i >= 0  ; i-- ){
      if( isRowEmpty( i ))
        this.deleteRow( i );
    }
  }

  public void deleteRows(){
    for( int i=this.getRowCount() ; i >= 0  ; i-- ){
      this.deleteRow( i );
    }
  }
//-----------------------------------------------------------------------------
  public int getColCount(){
    if( veCols==null )
      return 0;
    return veCols.size();
  }

//-----------------------------------------------------------------------------
  public int getRowCount(){
    int i=0;
    int maxRows=-1;
    boolean bHayDif=false;

    if( veCols==null || veCols.size()==0 )
      return 0;
    maxRows = this.getColumn(0).getRowCount();
    for(i=1; i < this.getColCount() ; i++ ){
      bHayDif = bHayDif || (maxRows != this.getColumn(i).getRowCount());
      if( maxRows < this.getColumn(i).getRowCount())
        maxRows = this.getColumn(i).getRowCount();
    }
    if( bHayDif ){
      for(i=1; i < this.getColCount() ; i++ ){
        while( this.getColumn(i).getRowCount() < maxRows )
          this.getColumn(i).newValue();
      }
    }
    // Tambien actualiza las filas faltantes del vector que indica si la fila es Update
/*    while( veIsUpdate.size() < maxRows )
      veIsUpdate.add(new Boolean(false));*/

    return maxRows;
  }

//-----------------------------------------------------------------------------
  public int getSelectedRow() {
    //if( sorter != null )
      //return sorter.indexRow( super.getSelectedRow());
    return super.getSelectedRow();
  }

/**
 * Clases necesarias para Renderizar la Grilla
 */
//-----------------------------------------------------------------------------
  class GlGrillaButtonRenderer extends JButton implements TableCellRenderer {
    public GlGrillaButtonRenderer() { setOpaque(true); }
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
      if( hasFocus ) {
         ((JButton)value).setBackground(colorFocus);
      } else if( isSelected ) {
         ((JButton)value).setForeground(table.getSelectionForeground());
         ((JButton)value).setBackground(colorBackSelected);
      } else {
         if( getColumn(column).getColorForeground(row)==null )
           ((JButton)value).setForeground(getCellColorForeground(row,column));
         else
           ((JButton)value).setForeground(getColumn(column).getColorForeground(row) );
         if( getColumn(column).getColorBackground(row)==null )
           ((JButton)value).setBackground(getCellColorBackground(row,column));
         else
           ((JButton)value).setBackground(getColumn(column).getColorBackground(row));
      }
      return (JButton)value;
    }
  }

//-----------------------------------------------------------------------------
  class GlGrillaDefaultRenderer extends DefaultTableCellRenderer {
    public GlGrillaDefaultRenderer() { super(); }//setOpaque(true); }
    public Component getTableCellRendererComponent( JTable table, Object value,
                                                    boolean isSelected,
                                                    boolean hasFocus,
                                                    int row, int column ) {
      Component comp = super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
      JLabel label=(JLabel)comp;

      if ( isSelected) {
        label.setForeground(table.getSelectionForeground());
        label.setBackground(colorBackSelected);
      } else {
        if( getColumn(column).getColorForeground(row)==null )
          label.setForeground(getCellColorForeground( row, column));
        else {
          label.setForeground(getColumn(column).getColorForeground(row));
        }
        if( getColumn(column).getColorBackground(row)==null )
          label.setBackground(getCellColorBackground( row, column));
        else {
          label.setBackground(getColumn(column).getColorBackground(row));
        }
      }
      return label;
    }
 }

//-----------------------------------------------------------------------------
  class GlGrillaBooleanRenderer extends JCheckBox implements TableCellRenderer
  {
    public GlGrillaBooleanRenderer() {
      super();
      setHorizontalAlignment(JLabel.CENTER);
    }
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
      if (hasFocus) {
         super.setBackground(colorFocus);
      } else if (isSelected) {
         setForeground(table.getSelectionForeground());
         super.setBackground(colorBackSelected);
      } else {
         if( getColumn(column).getColorForeground(row)==null )
           setForeground(getCellColorForeground(row, column));
         else
           setForeground(getColumn(column).getColorForeground(row) );
         if( getColumn(column).getColorBackground(row)==null )
           super.setBackground(getCellColorBackground(row, column));
         else
           super.setBackground(getColumn(column).getColorBackground(row));
      }
      setSelected((value != null && ((Boolean)value).booleanValue()));
      return this;
    }
  }
//------------------------------------------------------------------------------
  private static Color colorAlternativo( Color color){
    /**
     * Produce un pequeño desplazamiento del color rojo, para evitar
     * que el Background de la Tabla sea igual al Background de los
     * renderizadores. Se detectaron problemas de refresco cuando ambos
     * colores coinciden.
     */
    int r=color.getRed();
    int g=color.getGreen();
    int b=color.getBlue();

    if( r > 1 )     r--;
    else if( r==0 ) r=1;
    else            r=0;
    return new Color( r, g, b);
  }

//-----------------------------------------------------------------------------
  public void reallocateIndexes(){
    //if( sorter != null )
      // sorter.reallocateIndexes();
  }
//------------------------------------------------------------------------------
// Implementar
//------------------------------------------------------------------------------
  public void key_Releassed ( KeyEvent evt ) {} 
  
  public void mousePressed(MouseEvent e){ 
    
  }
  
  public void execButton  (int row, int col){ }
  public void setCell( Object oValue, int row, int col ){ }
  public void loadRow( int row ){ }
  public void saveRow( int row ){ }
  public void afterSaveRow( int row ){ }
  public Color getCellColorForeground( int row, int col){return super.getForeground();}
  public Color getCellColorBackground( int row, int col){return colorBack;}
  public Boolean isEditable( int row, int col){ return null;}
  public void changePosition( int row, int col){ }
//------------------------------------------------------------------------------

 
}

