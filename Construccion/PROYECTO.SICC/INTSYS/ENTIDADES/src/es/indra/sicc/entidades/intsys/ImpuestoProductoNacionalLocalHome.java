package es.indra.sicc.entidades.intsys;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.SecuenciadorOID;
import java.sql.Date;
import java.util.Collection;
import javax.persistence.*;

// Referenced classes of package es.indra.sicc.entidades.intsys:
//            ImpuestoProductoNacionalLocal

public class ImpuestoProductoNacionalLocalHome
{

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
    private EntityManager em = emf.createEntityManager();

    public ImpuestoProductoNacionalLocal create(Long oidProducto)
        throws MareException
    {
        Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_IPNA_SEQ");
        EntityTransaction et = em.getTransaction();
        et.begin();
        ImpuestoProductoNacionalLocal local = new ImpuestoProductoNacionalLocal(oid, oidProducto);
        em.persist(local);
        et.commit();
        return local;
    }

    public void remove(ImpuestoProductoNacionalLocal local)
    {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(local);
        et.commit();
    }

    public void merge(ImpuestoProductoNacionalLocal local)
    {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(local);
        et.commit();
    }

    public ImpuestoProductoNacionalLocal findByPrimaryKey(Long  oid) {
		ImpuestoProductoNacionalLocal local = em.find(ImpuestoProductoNacionalLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

    public Collection findAll()
    {
        Query query = em.createNamedQuery("ImpuestoProductoNacionalLocal.FindAll");
        return query.getResultList();
    }

    public ImpuestoProductoNacionalLocal findByCodSAPYFecha(Long oidProducto, Date fechaCarga)
    {
        Query query = em.createNamedQuery("ImpuestoProductoNacionalLocal.FindByCodSAPYFecha");
        query.setParameter(1, oidProducto);
        query.setParameter(2, fechaCarga);
        return (ImpuestoProductoNacionalLocal)query.getSingleResult();
    }

  
}
