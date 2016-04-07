package es.indra.sicc.entidades.mae;
import java.io.Serializable;

public class MaestroProductosPK implements Serializable 
{

    public Long oid;

    public MaestroProductosPK(Long paramOid)
    {
        oid = paramOid;
    }

    public MaestroProductosPK()
    {
    }

    public boolean equals(Object other)
    {
        if (other instanceof MaestroProductosPK)
        {
            final MaestroProductosPK otherMaestroProductosPK = (MaestroProductosPK)other;

            // The following assignment statement is auto-maintained and may be overwritten!
            boolean areEqual = true;

            if (!otherMaestroProductosPK.oid.equals(oid)) {
                areEqual = false;
            }

            return areEqual;
        }

        return false;
    }

    public int hashCode()
    {
        // Add custom hashCode() impl here
        return super.hashCode();
    }
}