package es.indra.mare.common.mln.engine;

import es.indra.mare.common.activator.*;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.exception.MareSystemLevelException;
import es.indra.mare.common.log.MareDebug;
import es.indra.mare.common.mii.*;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.mare.common.mln.businessdefinition.BusinessDefinition;
import es.indra.mare.common.mln.businessdefinition.BusinessDefinitionException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.configuration.Configuration;

// Referenced classes of package es.indra.mare.common.mln.engine:
//            IMareEngine, EngineNotFoundException

public class EngineFactory extends MareService
{

    public EngineFactory()
    {
    }

    private static ActivatorFactory getActivatorFactory()
        throws EngineNotFoundException
    {
        if(af == null)
            try
            {
                af = (ActivatorFactory)MareMii.getService(new MareTopic("ActivatorService"));
            }
            catch(MareMiiServiceNotFoundException e)
            {
                throw new EngineNotFoundException("Can\264t find Activator Service", e);
            }
        return af;
    }

    public IMareEngine create(String businessProcess)
        throws EngineNotFoundException, BusinessDefinitionException
    {
        IMareEngine engine = (IMareEngine)cache.get(businessProcess);
        if(engine == null)
        {
            MareDebug.write((new StringBuilder()).append("[EngineFactory] can\264t find businessProcess: ").append(businessProcess).toString());
            ArrayList engineConf = (ArrayList)conf.getProperty(businessProcess);
            String engineClassName = (String)engineConf.get(0);
            String businessDef = (String)engineConf.get(1);
            String urlBusinessDefFactory = conf.getString(engineClassName);
            ClassOperation operation;
            try
            {
                operation = (ClassOperation)getActivatorFactory().create(urlBusinessDefFactory);
            }
            catch(ActivatorNotFoundException e)
            {
                throw new BusinessDefinitionException("Can\264t instate BusinessDefFactory", e);
            }
            operation.setArgsValues(new String[] {
                businessDef
            });
            BusinessDefinition busDef;
            try
            {
                busDef = (BusinessDefinition)operation.invoke();
            }
            catch(MareException e)
            {
                throw new BusinessDefinitionException((new StringBuilder()).append("Can\264t build Business Definition in file").append(businessDef).toString(), e);
            }
            catch(MareSystemLevelException e)
            {
                throw new BusinessDefinitionException((new StringBuilder()).append("Can\264t build Business Definition in file").append(businessDef).toString(), e);
            }
            Class clazz;
            try
            {
                clazz = Thread.currentThread().getContextClassLoader().loadClass(engineClassName);
            }
            catch(ClassNotFoundException e)
            {
                throw new EngineNotFoundException("Can\264t instantiate the engine", e);
            }
            Constructor constructor = clazz.getDeclaredConstructors()[0];
            try
            {
                engine = (IMareEngine)constructor.newInstance(new Object[] {
                    busDef
                });
            }
            catch(InstantiationException e)
            {
                throw new EngineNotFoundException("Can\264t instantiate the engine", e);
            }
            catch(IllegalAccessException e)
            {
                throw new EngineNotFoundException("Can\264t instantiate the engine", e);
            }
            catch(InvocationTargetException e)
            {
                throw new EngineNotFoundException("Can\264t instantiate the engine", e);
            }
            cache.putIfAbsent(businessProcess, engine);
        }
        return engine;
    }

    public void init(Configuration config, MareTopic mtopic)
        throws MareServiceException
    {
        if(conf == null)
        {
            cache = new ConcurrentHashMap();        
            mareTopic = mtopic;
            conf = config;
        }
    }

    public boolean isInitialized()
    {
        return conf != null;
    }

    public void shutdown()
    {
    }

    private static ActivatorFactory af = null;
    private static MareTopic mareTopic = null;
    private static Configuration conf = null;
    private static ConcurrentHashMap cache = null;

}