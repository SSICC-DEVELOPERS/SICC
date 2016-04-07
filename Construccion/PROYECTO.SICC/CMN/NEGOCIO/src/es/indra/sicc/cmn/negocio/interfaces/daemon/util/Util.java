package es.indra.sicc.cmn.negocio.interfaces.daemon.util;


/**
 * Cuando se utilice Mare 1.3.1, cambiar las importaciones
 * que hacen referencia al paquete es.indra.sicc.cmn.negocio.interfaces.daemon.mareext
 * por las propias de Mare
 */
import es.indra.mare.common.exception.MareException;
//import es.indra.mare.common.mgc.IMareMGC;
//import es.indra.sicc.cmn.negocio.interfaces.daemon.mareext.IMareMGC;
//import es.indra.mare.common.mii.IMareServiceLocator;
//import es.indra.sicc.cmn.negocio.interfaces.daemon.mareext.IMareServiceLocator;
//import es.indra.mare.common.mii.MareMii;
//import es.indra.sicc.cmn.negocio.interfaces.daemon.mareext.MareMii;
import es.indra.mare.common.mgc.IMareMGC;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.IMareServiceLocator;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
//import es.indra.mare.common.mii.MareTopic;
//import es.indra.sicc.cmn.negocio.interfaces.daemon.mareext.MareTopic;
//import es.indra.mare.common.mii.ServiceLocator;
//import es.indra.sicc.cmn.negocio.interfaces.daemon.mareext.ServiceLocator;
// Mare 1.3.1
//import es.indra.mare.common.mii.helper.ServicesHelper;
//import es.indra.sicc.cmn.negocio.interfaces.daemon.mareext.ServicesHelper;
//import es.indra.mare.common.mii.services.vfs.IMareVFS;
//import es.indra.sicc.cmn.negocio.interfaces.daemon.mareext.IMareVFS;
//import es.indra.mare.common.mii.services.xmlservice.IXMLService;
//import es.indra.sicc.cmn.negocio.interfaces.daemon.mareext.IXMLService;
//import es.indra.mare.common.mii.services.xmlservice.XMLService;
//import es.indra.sicc.cmn.negocio.interfaces.daemon.mareext.XMLService;
//import es.indra.mare.common.mii.ServiceLocator;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.logging.LoggingService;
import es.indra.mare.common.mii.services.vfs.MareVFS;
import es.indra.mare.common.mii.services.xmlservice.XMLService;
import es.indra.sicc.cmn.negocio.interfaces.daemon.FileFolder;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.vfs.FileObject;
import org.apache.commons.vfs.FileSystemManager;

import es.indra.sicc.util.UtilidadesLog;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 * Cuando se utilice Mare 1.3.1, cambiar las importaciones
 * que hacen referencia al paquete es.indra.sicc.cmn.negocio.interfaces.daemon.mareext
 * por las propias de Mare
 */
public class

Util {
    //private static IMareServiceLocator locator = new ServiceLocator();

    private static Util instance = null;
    private static Log log = null;
    private static XMLService xmlService = null;
    private static IMareMGC mgc = null;

    private static FileSystemManager fsm = null;
    //private static IMareVFS vfs = null;
    private static MareVFS vfs = null;

    static {
        //ServicesHelper.setServiceLocator( locator );
        try {
            //vfs = ServicesHelper.getVFSService();
            vfs =
 (MareVFS)MareMii.getService(new MareTopic("VFSService", null));
        } catch (MareMiiServiceNotFoundException ex) {
            getLog().error("Error al obtener servicio VFS");
            ex.printStackTrace();
            System.exit(0);
        }
    }

    private Util() throws MareException {
        //ServicesHelper.setServiceLocator( locator );
        //vfs = ServicesHelper.getVFSService();
        vfs = (MareVFS)MareMii.getService(new MareTopic("VFSService", null));
    }

    public static synchronized Util getUtil() throws MareException {
        if (instance == null)
            instance = new Util();
        return instance;
    }

    public static synchronized IMareMGC getMGC() throws MareException {
        if (mgc == null)
            //mgc = ServicesHelper.getConfigurationService();
            mgc =
 ((MareMGC)MareMii.getService(new MareTopic("Configuration", null)));
        return mgc;
    }

    public static synchronized Log getLog() {
        if (log == null) {
            try {
                //log = ServicesHelper.getLogService();
                log =
 ((LoggingService)MareMii.getService(new MareTopic("LoggingService",
                                                   null))).getMareLog();
            } catch (MareMiiServiceNotFoundException mex) {
                System.err.println("Error al obtener servicio de logging");
                mex.printStackTrace();
            }
        }
        return log;
    }

    public static synchronized FileSystemManager getFSM() throws MareException {
        return vfs.getManager();
    }

    @SuppressWarnings("unchecked")
    public static List getInterfaces() throws MareException {
        //xmlService = ServicesHelper.getXMLService();

        INTDaemonConfig config = new INTDaemonConfig();
        try{
            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(ConfigFactory.getINTDaemonConfig().getInterfacesConfigFile());
            
            List<Element> folders = (List<Element>)doc.getRootElement().getChildren("folder");
            
            for(Element folder: folders){
                FileFolder f = new FileFolder();
                f.setCodigo(folder.getChildText("codigo"));
                f.setIDBusiness(folder.getChildText("IDBusiness"));
                f.setPais(folder.getChildText("pais"));
                f.setPatronNombres(folder.getChildText("patronNombres"));
                f.setPeriodoMuestreo(folder.getChildText("periodoMuestreo"));
                f.setUrl(folder.getChildText("url"));
                config.getFolders().add(f);
            }
            
            //INTDaemonConfig config = (INTDaemonConfig)xmlService.castorFileMappingXMLUnmarshal(ConfigFactory.getINTDaemonConfig().getCastorMappingFile(),
            //                                                              ConfigFactory.getINTDaemonConfig().getInterfacesConfigFile(),
            //                                                              INTDaemonConfig.class);
        }catch(Exception e){
            if(e instanceof MareException){
                throw (MareException)e;
            }else{
                throw new MareException("Error al iniciar la configuracion del demonio",e);
            }
        }
        return config.getFolders();
    }

    public static FileObject[] filterFiles(FileObject[] files, String patron) {
        ArrayList list = new ArrayList();
        final Pattern pattern = Pattern.compile(patron.toUpperCase());
        Matcher matcher;

        int len = files.length;
        FileObject file;
        for (int i = 0; i < len; i++) {
            file = files[i];
            matcher =
                    pattern.matcher(file.getName().getBaseName().toUpperCase());
            if (matcher.matches())
                list.add(file);
        }

        //return (FileObject[])list.toArray();
        //FileObject[] fo = new FileObject[ list.size() ];
        //return list.toArray( fo );
        FileObject fo[] =
            (FileObject[])list.toArray(new FileObject[list.size()]);
        return fo;
    }


    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            Util util = new Util();

            //UtilidadesLog.debug( ConfigFactory.getINTDaemonConfig().getDBPath() );
            //UtilidadesLog.debug( ConfigFactory.getINTDaemonConfig().getInterfacesConfigFile() );
            //UtilidadesLog.debug( ConfigFactory.getINTDaemonConfig().getBusinessFacade() );
            //UtilidadesLog.debug( ConfigFactory.getINTDaemonConfig().getDBService() );
            //UtilidadesLog.debug( ConfigFactory.getINTDaemonConfig().getLogFile() );
            //UtilidadesLog.debug( ConfigFactory.getINTDaemonConfig().getLogService() );
            //UtilidadesLog.debug( ConfigFactory.getINTDaemonConfig().getPrefix() );
            //UtilidadesLog.debug( ConfigFactory.getINTDaemonConfig().getServer() );
            //UtilidadesLog.debug( ConfigFactory.getINTDaemonConfig().getCastorMappingFile() );
            //UtilidadesLog.debug( ConfigFactory.getINTDaemonConfig().getDBDriver() );

            FileSystemManager fsm = Util.getFSM();
            FileObject dir = fsm.resolveFile("C:/temp");
            FileObject[] files = dir.getChildren();
            FileObject[] filtered = Util.filterFiles(files, "SICC-DECU.*");
            for (int i = 0; i < filtered.length; i++) {
                UtilidadesLog.debug(filtered[i].getName().getBaseName());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
