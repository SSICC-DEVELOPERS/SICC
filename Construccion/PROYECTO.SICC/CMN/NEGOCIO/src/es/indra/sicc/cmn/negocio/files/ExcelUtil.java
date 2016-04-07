package es.indra.sicc.cmn.negocio.files;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.sicc.util.BelcorpAuthenticator;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import java.net.Authenticator;
import java.net.URL;
import java.net.URLConnection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


/**
 * Metodos utilitarios para la lectura de archivos excel.
 * 
 * @author <a href="mailto:sapaza@belcorp.biz">Sergio Apaza</a>
 */
public class ExcelUtil {

    /**    
     * Este objeto de la clase HSSFWorkbook contiene todas las hojas o   
     * pestañas de un archivo xls   
     * */  
    private HSSFWorkbook wb;
    private HSSFSheet ws;
    
    private InputStream input;
    private FileOutputStream output;
    Iterator itRows;
    
    private HSSFFont font1;
    private HSSFFont font2;
    private HSSFCellStyle cstyle1;
    private HSSFCellStyle cstyle2;
    
    private short registro;
    private short columna;
    private int   registroExcelGrande;


    public ExcelUtil(String path, String filename, boolean local) throws MareException { 
        UtilidadesLog.debug("path: " + path);
        UtilidadesLog.debug("fileName: " + filename);
        String fileNameNuevo = path + "/" + filename;
        UtilidadesLog.debug("fileNameNuevo: " + fileNameNuevo);
    
        try {
            if(local) {
                //Esto crea un objeto que lee los bytes del archivo      
                File file = new File(fileNameNuevo);
                this.input = new FileInputStream(file);      
                POIFSFileSystem fs = new POIFSFileSystem(input);
                 
                //Una vez creado el workbook tenemos acceso a las hojas (pestañas)       
                //incluidas en el archivo de excel    
                this.wb = new HSSFWorkbook(fs);        
            } else {
                InputStream in = obtenerFichero(fileNameNuevo);
                this.wb = new HSSFWorkbook(in);   
            }        
        } catch(Exception e) {
            throw new MareException(e);
        }    
    }

    /**
     * Abrir fichero XLS que esta alojada en la instancia web desde el lado servidor Online
     * 
     * @param fichero
     * @return
     * @throws MareException
     */
    private InputStream obtenerFichero(String fichero) throws MareException {
        ByteArrayInputStream bis = null;

        String ficheroPath = null;
        String user = null;
        String password = null;
        String fileFullPath = null;

        MareMGC mgc = (MareMGC)MareMii.getService(new MareTopic(MareMii.SERVICE_MGC));
    
        ficheroPath = (String) mgc.getProperty("application.uploadURL");          
        user = (String) mgc.getProperty("application.uploadURL.user");          
        password = (String) mgc.getProperty("application.uploadURL.password");   
        UtilidadesLog.debug("user: " + user);
        UtilidadesLog.debug("password: " + password);
        UtilidadesLog.debug("ficheroPath: " + ficheroPath);
          
        if (ficheroPath==null || ficheroPath.equals("")) {
          ficheroPath="";
        }
        
        Authenticator.setDefault(new BelcorpAuthenticator(user, password));
        System.out.println(ficheroPath + fichero);

        fileFullPath = ficheroPath + fichero;
        try {
            UtilidadesLog.debug(" - abrirFichero(" + fileFullPath + ")");   

            URL url = new URL(fileFullPath);
            URLConnection con = url.openConnection();
            con.connect();
            UtilidadesLog.debug(" - connect 1");

            InputStream in = con.getInputStream();
            //obtenemos la cantidad de bytes del Fichero        
            int c;
            int fila =0;
            while((c=in.read())!=-1) {
                fila = fila + 1;
            }
            UtilidadesLog.debug("Filas : " + fila);
                        
            con = url.openConnection();
            con.connect();
            System.out.println(" - connect 2");
            in = con.getInputStream();
            //obtenemos el contenido en el buffer de bytes
            byte lineas[] = new byte[fila];
            fila =0;
            while((c=in.read())!=-1) {
                lineas[fila]=(byte)c;
                fila = fila + 1;
            }
                
            bis = new ByteArrayInputStream(lineas);
            UtilidadesLog.debug("ByteArrayInputStream");
            
        } catch (FileNotFoundException ex) {
            UtilidadesLog.error(ex);        
            String codigo = CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO;
            //throw new MareException("Error al abrir el fichero "+fileFullPath, ex, 120070006);
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigo));
        } catch (java.net.MalformedURLException mfe) {  
            System.out.println(" ==== ERROR EN LA URL  ===== " + fileFullPath);
            String codigo = CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO;            
            //throw new MareException("Error al abrir el fichero "+fileFullPath, mfe, 120070006);
            throw new MareException(mfe, UtilidadesError.armarCodigoError(codigo));
        } catch (java.io.IOException ioe) {
            System.out.println(" ==== ERROR DE IO ===== " + fileFullPath);
            String codigo = CodigosError.ERROR_DE_LECTURA_DE_ARCHIVO;            
            throw new MareException(ioe, UtilidadesError.armarCodigoError(codigo));
        }
        
        return bis;
        
    }

     /**
     * Crea una instancia de ExcelUtil de acuerdo a un archivo xls Específico. 
     * @param file
     * @throws Exception
     */
    public ExcelUtil(File file) throws MareException { 
         try {
             //Esto crea un objeto que lee los bytes del archivo
             this.input = new FileInputStream(file);      
             POIFSFileSystem fs = new POIFSFileSystem(input);
             
             //Una vez creado el workbook tenemos acceso a las hojas (pestañas)       
             //incluidas en el archivo de excel    
             this.wb = new HSSFWorkbook(fs);  
         } catch(Exception e) {
             throw new MareException(e);
         }    
             
     }
     
     /**
     * Utilizado para grabar archivos Excel
     * @param FileOutputStream
     * @throws Exception
     */
    public ExcelUtil(FileOutputStream FileOutputStream) throws MareException { 
         try {
             //Esto crea un objeto que lee los bytes del archivo
             this.output = FileOutputStream;    
             // create a new workbook object; note that the workbook
             // and the file are two separate things until the very
             // end, when the workbook is written to the file.
             //this.wb = new HSSFWorkbook();
             this.wb = new HSSFWorkbook();
    
             // create a new worksheet
             this.ws = wb.createSheet();  
         } catch(Exception e) {
             throw new MareException(e);
         }    
         
         /* Generacion de estilos por default */
         this.generarEstilosDefault();
         this.columna  = 0;
         this.registro = 0;
         this.registroExcelGrande = 0;
     }
    
    /**
     * Utilizado para grabar archivos Excel
     * @param FileOutputStream
     * @throws Exception
     */
    public ExcelUtil(FileOutputStream FileOutputStream, String fileName, String nombreHoja) throws MareException { 
         //Esto crea un objeto que lee los bytes del archivo
         this.output = FileOutputStream;
         
         try {
             if (fileName == null) {
                     this.wb = new HSSFWorkbook();
                 //create a new worksheet
                 this.ws = wb.createSheet();
             }    
             else {
                     File file = new File(fileName);
                     this.input = new FileInputStream(file);      
                     POIFSFileSystem fs = new POIFSFileSystem(input);
                     this.wb = new HSSFWorkbook(fs);
                     this.ws = wb.createSheet(nombreHoja);
             }	 
         } catch(Exception e) {
             throw new MareException(e);
         }    
         
         /* Generacion de estilos por default */
         this.generarEstilosDefault();
         this.columna  = 0;
         this.registro = 0;
     }
    
    /**
     * Cierra Archivo Output de Formato Excel
     * @throws Exception
     */
    public void cerrarOutput() throws MareException  {
        try {
            this.wb.write(this.output);
            this.output.close();
        } catch(Exception e) {
            throw new MareException(e);
        }    
            
    }
    
    /**
     * @throws Exception
     */
    public void generarEstilosDefault() throws MareException { 
        try {
            //need to be defined before they are used
            cstyle1 = wb.createCellStyle();
            cstyle2 = wb.createCellStyle();
    
            // create two font objects for formatting
            font1 = wb.createFont();
            font2 = wb.createFont();
        } catch(Exception e) {
            throw new MareException(e);
        }    
            
        font1.setFontHeightInPoints((short) 10);
        font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        //set font 2 to 10 point red type
        font2.setFontHeightInPoints((short) 9);
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        font2.setColor(HSSFFont.COLOR_NORMAL);
        
        //for cell style 1, use font 1 and set data format
        cstyle1.setFont(font1);

        //for cell style 2, use font 2, set a thin border, text format
        //cstyle2.setBorderBottom(cstyle2.BORDER_THIN);
        cstyle2.setFont(font2);
    }
    
     /**
     * @param sheetInt
     * @throws Exception
     */
    public void initSheet(int sheetInt) throws MareException { 
        try {    
            //Obtenemos la hoja o pestaña elegida       
            HSSFSheet sheet = wb.getSheetAt(sheetInt); 
            //Para recorrer las filas utilizamos el Iterador de filas "rows"      
            this.itRows = sheet.rowIterator();  
         } catch(Exception e) {
             throw new MareException(e);
         }    
     }
     
    /**   
     * Esta función se encarga de leer la hoja o pestaña elegida   
     * Para este caso nos referimos a un número especifico   
     * según el órden en que aparecen las pestañas, si un archivo   
     * xls solo cuenta con una hoja, para referirse a esa hoja   
     * utilizamos el primer índice que sería el cero.   
     * La función devuelve un vector de vectores
     * */
    public Vector getHoja(int sheetInt) {  
        //Aqui recopilamos todas las filas leidas en la hoja       
        Vector sheetVector = new Vector(); 
        
        //Obtenemos la hoja o pestaña elegida       
        HSSFSheet sheet = wb.getSheetAt(sheetInt); 
        
        //Para recorrer las filas utilizamos el Iterador de filas "rows"      
        Iterator rows = sheet.rowIterator();
        
        //Hay que verificar si hay alguna otra fila que leer      
        while (rows.hasNext()) {     
                //Es por que si hay otra fila que leer que obtenemos la fila que sigue          
                HSSFRow row = (HSSFRow)rows.next();
                
                //Aqui se colocan todos los valores almacenados en dicha fila.         
                Vector rowVector = new Vector();
                
                //recorremosr uno a uno las celdas    
                for (short c=row.getFirstCellNum(); c<row.getLastCellNum(); c++) {
                        HSSFCell cell = row.getCell( c );

                        if( cell != null ) {
                                switch (cell.getCellType()) {              
                                        // La celda contiene texto        
                                        case HSSFCell.CELL_TYPE_STRING:                  
                                                rowVector.add(cell.getStringCellValue());                  
                                                break;    
                                                
                                        // El caso de que la celda contenga un valor númerico               
                                        case HSSFCell.CELL_TYPE_NUMERIC:                  
                                                rowVector.add(String.valueOf(cell.getNumericCellValue()));                  
                                                break;              
                                                
                                        // El caso de que la celda contenga un valor con formula					
                                        case HSSFCell.CELL_TYPE_FORMULA:                  
                                                rowVector.add(String.valueOf(cell.getNumericCellValue()));                  
                                                break;              
                                        
                                        // En este caso para este tutorial no guardamos nada */              
                                        default:                  
                                                rowVector.add("");
                                }
                        } else {         
                                rowVector.add(null);	
                        }
                }	
                System.out.println(rowVector);
                // Una vez leidas las celdas, el vector de la fila es agregado           
                // al vector de vectores           
                sheetVector.add(rowVector);      
        }          
        
        // Se devuevlen los datos leidos en un vector de vectores.      
        return sheetVector;  
    }

    /**   
     * Esta función se encarga de leer una fila de una hoja elegida   
     * Para este caso nos referimos a un número especifico   
     * según el órden en que aparecen las pestañas, si un archivo   
     * xls solo cuenta con una hoja, para referirse a esa hoja   
     * utilizamos el primer índice que sería el cero e igual seria
     * el caso para la primera fila   
     * La función devuelve un vector 
     * */
    public Vector getFila(int sheetInt, int rowInt) {  
        //Aqui se colocan todos los valores almacenados en dicha fila.       
        Vector rowVector = new Vector(); 
         
        //Obtenemos la hoja o pestaña elegida       
        HSSFSheet sheet = wb.getSheetAt(sheetInt); 
        
        //Para recorrer las filas utilizamos el Iterador de filas "rows"
        HSSFRow row = sheet.getRow(rowInt);
                
        //recorremosr uno a uno las celdas    
        for (short c=row.getFirstCellNum(); c<row.getLastCellNum(); c++) {
                HSSFCell cell = row.getCell( c );

                if( cell != null ) {
                        switch (cell.getCellType()) {              
                                // La celda contiene texto        
                                case HSSFCell.CELL_TYPE_STRING:                  
                                        rowVector.add(cell.getStringCellValue());                  
                                        break;    
                                        
                                // El caso de que la celda contenga un valor númerico               
                                case HSSFCell.CELL_TYPE_NUMERIC:                  
                                        rowVector.add(String.valueOf(cell.getNumericCellValue()));                  
                                        break;              
                                        
                                // El caso de que la celda contenga un valor con formula					
                                case HSSFCell.CELL_TYPE_FORMULA:                  
                                        rowVector.add(String.valueOf(cell.getNumericCellValue()));                  
                                        break;              
                                
                                // En este caso para este tutorial no guardamos nada */              
                                default:                  
                                        rowVector.add("");
                        }
                } else {         
                        rowVector.add(null);	
                }
        }	
        
        // Se devuevlen los datos leidos en un vector de vectores.      
        return rowVector;  
    }

    /**   
     * Esta función se encarga de leer una fila de una hoja elegida   
     * Para este caso nos referimos a un número especifico   
     * según el órden en que aparecen las pestañas, si un archivo   
     * xls solo cuenta con una hoja, para referirse a esa hoja   
     * utilizamos el primer índice que sería el cero e igual seria
     * el caso para la primera fila, trae la informacion de la columna
     * asi como la posicion de la columna  
     * La función devuelve un vector 
     * */
    public List getFilaConColumnaNoNulos(int sheetInt, int rowInt) {  
        //Aqui se colocan todos los valores almacenados en dicha fila.       
        List rowList = new ArrayList(); 
         
        //Obtenemos la hoja o pestaña elegida       
        HSSFSheet sheet = wb.getSheetAt(sheetInt); 
        
        //Obtenemos la fila deseada
        HSSFRow row = sheet.getRow(rowInt);
                
        //recorremos uno a uno las celdas    
        for (short c=row.getFirstCellNum(); c<row.getLastCellNum(); c++) {
            HSSFCell cell = row.getCell( c );
            
            if( cell != null ) {
                DTOString base = new DTOString();
                base.setOidIdioma(new Long(String.valueOf(c)));
                
                switch (cell.getCellType()) {              
                    // La celda contiene texto        
                    case HSSFCell.CELL_TYPE_STRING:                  
                            base.setCadena(cell.getStringCellValue());                  
                            break;    
                            
                    // El caso de que la celda contenga un valor númerico               
                    case HSSFCell.CELL_TYPE_NUMERIC:                  
                            base.setCadena(String.valueOf(cell.getNumericCellValue()));                  
                            break;              
                            
                    // El caso de que la celda contenga un valor con formula					
                    case HSSFCell.CELL_TYPE_FORMULA:                  
                            base.setCadena(String.valueOf(cell.getNumericCellValue()));                  
                            break;              
                    
                    // En este caso para este tutorial no guardamos nada */              
                    default:                  
                            base.setCadena("");
                }
                rowList.add(base);
            } 
        }	
        
        // Se devuevlen los datos leidos en una lista de clases tipo Base      
        return rowList;  
    }

    /**   
     * Esta función se encarga de leer una fila de una hoja elegida   
     * Para este caso nos referimos a un número especifico   
     * según el órden en que aparecen las pestañas, si un archivo   
     * xls solo cuenta con una hoja, para referirse a esa hoja   
     * utilizamos el primer índice que sería el cero e igual seria
     * el caso para la primera fila, trae la informacion de la columna
     * asi como la posicion de la columna en un objeto Map
     * */
    public Map getFilaConPosicionColumna(int sheetInt, int rowInt) {  
        //Aqui se colocan todos los valores almacenados en dicha fila.       
        Map rowMap = new HashMap(); 
         
        //Obtenemos la hoja o pestaña elegida       
        HSSFSheet sheet = wb.getSheetAt(sheetInt); 
        
        //Obtenemos la fila deseada
        HSSFRow row = sheet.getRow(rowInt);
                
        //recorremos uno a uno las celdas    
        for (short c=row.getFirstCellNum(); c<row.getLastCellNum(); c++) {
            HSSFCell cell = row.getCell( c );
            
            if( cell != null ) {
                switch (cell.getCellType()) {              
                    // La celda contiene texto        
                    case HSSFCell.CELL_TYPE_STRING:                  
                            rowMap.put(String.valueOf(c), cell.getStringCellValue());                  
                            break;    
                            
                    // El caso de que la celda contenga un valor númerico               
                    case HSSFCell.CELL_TYPE_NUMERIC:                  
                            rowMap.put(String.valueOf(c), String.valueOf(cell.getNumericCellValue()));
                            break;              
                            
                    // El caso de que la celda contenga un valor con formula					
                    case HSSFCell.CELL_TYPE_FORMULA:                  
                            rowMap.put(String.valueOf(c), String.valueOf(cell.getNumericCellValue()));
                            break;              
                    
                    // En este caso para este tutorial no guardamos nada */              
                    default:                  
                            rowMap.put(String.valueOf(c), "");
                }
            } else {         
                    rowMap.put(String.valueOf(c), null);	
            }
        }	
        
        // Se devuelven los datos leidos en una lista de clases tipo Base      
        return rowMap;  
    }

    /**   
     * Esta función se encarga de leer una fila de una hoja elegida   
     * Para este caso nos referimos a un número especifico   
     * según el órden en que aparecen las pestañas, si un archivo   
     * xls solo cuenta con una hoja, para referirse a esa hoja   
     * utilizamos el primer índice que sería el cero e igual seria
     * el caso para la primera fila, trae la informacion de la columna
     * asi como la posicion de la columna en un objeto Map
     * */
    private Map getFilaConPosicionColumna(HSSFRow row) {  
        //Aqui se colocan todos los valores almacenados en dicha fila.       
        Map rowMap = new HashMap(); 
         
        //recorremos uno a uno las celdas    
        for (short c=row.getFirstCellNum(); c<row.getLastCellNum(); c++) {
            HSSFCell cell = row.getCell( c );
            
            if( cell != null ) {
                switch (cell.getCellType()) {              
                    // La celda contiene texto        
                    case HSSFCell.CELL_TYPE_STRING:                  
                            rowMap.put(String.valueOf(c), cell.getStringCellValue());                  
                            break;    
                            
                    // El caso de que la celda contenga un valor númerico               
                    case HSSFCell.CELL_TYPE_NUMERIC:                  
                            double resultado = cell.getNumericCellValue();
                            rowMap.put(String.valueOf(c), String.valueOf(resultado).trim()); 
                            break;              
                            
                    // El caso de que la celda contenga un valor con formula					
                    case HSSFCell.CELL_TYPE_FORMULA:                  
                            rowMap.put(String.valueOf(c), cell.getStringCellValue().trim());
                            break;              
                    
                    // En este caso para este tutorial no guardamos nada */              
                    default:                  
                            rowMap.put(String.valueOf(c), "");
                }
            } else {         
                    rowMap.put(String.valueOf(c), null);	
            }
        }	
        
        // Se devuevlen los datos leidos en una lista de clases tipo Base      
        return rowMap;  
    }
    
    public boolean hasNext() {
        return itRows.hasNext();
    }
    
    public Map next() {
        HSSFRow row = (HSSFRow)itRows.next();
        
        Map mapFila = getFilaConPosicionColumna(row);
        mapFila.put("rowNum", String.valueOf(row.getRowNum()+1));
        
        return mapFila;
    }	
    
    public void cerrar() {
        try {
            input.close();
        }catch(Exception ex) {}	
    }
    
                    
    /**
     * @return the wb
     */
    public HSSFWorkbook getWb() {
        return wb;
    }

    /**
     * @param wb the wb to set
     */
    public void setWb(HSSFWorkbook wb) {
        this.wb = wb;
    }

    /**
     * @return the ws
     */
    public HSSFSheet getWs() {
        return ws;
    }

    /**
     * @param ws the ws to set
     */
    public void setWs(HSSFSheet ws) {
        this.ws = ws;
    }

    /**
     * @return the output
     */
    public FileOutputStream getOutput() {
        return output;
    }

    /**
     * @param output the output to set
     */
    public void setOutput(FileOutputStream output) {
        this.output = output;
    }

    /**
     * @return the columna
     */
    public short getColumna() {
        return columna;
    }

    /**
     * @param columna the columna to set
     */
    public void setColumna(short columna) {
        this.columna = columna;
    }
    
    /**
     * @return the registro
     */
    public short getRegistro() {
        return registro;
    }

    /**
     * @param registro the registro to set
     */
    public void setRegistro(short registro) {
        this.registro = registro;
    }

    /**
     * @return the registroExcelGrande
     */
    public int getRegistroExcelGrande() {
        return registroExcelGrande;
    }

    /**
     * @param registroExcelGrande the registroExcelGrande to set
     */
    public void setRegistroExcelGrande(int registroExcelGrande) {
        this.registroExcelGrande = registroExcelGrande;
    }

}	
