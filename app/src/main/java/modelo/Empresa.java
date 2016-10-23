package modelo;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

/**
 * Created by carlos.morales on 18/10/2016.
 */
public class Empresa  implements KvmSerializable {

    private int idEmpresa;
    private String nombreEmpresa;
    private String nitEmpresa;
    private String DescripcionEmpresa;
    private String RazonSocialEmpresa;
    private String EstadoEmpresa;

    public Empresa(){

        idEmpresa=1;
        nombreEmpresa="miempresa";
        nitEmpresa="1sfs";
        DescripcionEmpresa="1df";
        RazonSocialEmpresa="1";
        EstadoEmpresa="abierto";
    }

    public Empresa(int idEmpresa, String nombreEmpresa, String EstadoEmpresa){
        this.idEmpresa = idEmpresa;
       this.nombreEmpresa =nombreEmpresa;
        this.EstadoEmpresa = EstadoEmpresa;
    }

    @Override
    public Object getProperty(int arg0) {
        switch(arg0)
        {
            case 0:
                return idEmpresa;
            case 1:
                return nombreEmpresa;
            case 2:
                return nitEmpresa;
            case 3:
                return DescripcionEmpresa;
            case 4:
                return RazonSocialEmpresa;
            case 5:
                return EstadoEmpresa;


        }

        return null;
    }

    @Override
    public int getPropertyCount() {
        return 8;
    }

    @Override
    public void getPropertyInfo(int ind, Hashtable ht, PropertyInfo info) {
        switch(ind)
        {
            case 0:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "idEmpresa";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "nombreEmpresa";
                break;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "nitEmpresa";
                break;
            case 3:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "DescripcionEmpresa";
                break;
            case 4:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "RazonSocialEmpresa";
                break;
            case 5:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "EstadoEmpresa";
                break;


            default:break;
        }
    }

    @Override
    public void setProperty(int ind, Object val) {
        switch(ind)
        {
            case 0:
                idEmpresa = Integer.parseInt(val.toString());
                break;
            case 1:
                nombreEmpresa = val.toString();
                break;
            case 2:
                nitEmpresa = val.toString();
                break;
            case 3:
                DescripcionEmpresa = val.toString();
                break;
            case 4:
                RazonSocialEmpresa = val.toString();
                break;
            case 5:
                EstadoEmpresa = val.toString();
                break;



            default:
                break;
        }
    }



    public String getEstadoEmpresa() {
        return EstadoEmpresa;
    }

    public void setEstadoEmpresa(String estadoEmpresa) {
        EstadoEmpresa = estadoEmpresa;
    }

    public String getRazonSocial() {
        return RazonSocialEmpresa;
    }

    public void setRazonSocial(String razonSocial) {
        RazonSocialEmpresa = razonSocial;
    }

    public String getDescripcionEmpresa() {
        return DescripcionEmpresa;
    }

    public void setDescripcionEmpresa(String descripcionEmpresa) {
        DescripcionEmpresa = descripcionEmpresa;
    }

    public String getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(String nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String  nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
}
