package modelo;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

/**
 * Created by carlos.morales on 8/10/2016.
 */
public class Cliente implements KvmSerializable {
    public int idCliente;
    public String primerNombre;
    public String segundoNombre ;
    public String primerApellido;
    public String segundoApellido;
    public String cuenta;
    public String contrasena;
    public String nombreCompleto;
    public String correo;


    public Cliente()
    {
        idCliente = 0;
        primerNombre = "";
        segundoNombre = "";
        primerApellido = "";
        segundoApellido = "";
        cuenta = "";
        contrasena = "";
        nombreCompleto = "";
        correo = "";

    }

    public Cliente(int idCliente, String primerNombre, String segundoNombre,String primerApellido,String segundoApellido,String cuenta,String contrasena,String nombreCompleto,String correo)
    {
        this.idCliente = idCliente;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.cuenta = cuenta;
        this.contrasena = contrasena;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
    }

    @Override
    public Object getProperty(int arg0) {

        switch(arg0)
        {
            case 0:
                return idCliente;
            case 1:
                return primerNombre;
            case 2:
                return segundoNombre;
            case 3:
                return primerApellido;
            case 4:
                return segundoApellido;
            case 5:
                return cuenta;
            case 6:
                return contrasena;
            case 7:
                return nombreCompleto;
            case 8:
                return correo;
        }

        return null;
    }

    @Override
    public int getPropertyCount() {
        return 9;
    }

    @Override
    public void getPropertyInfo(int ind, Hashtable ht, PropertyInfo info) {
        switch(ind)
        {
            case 0:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "idCliente";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "primerNombre";
            break;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "segundoNombre";
                break;
            case 3:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "primerApellido";
                break;
            case 4:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "segundoApellido";
                break;
            case 5:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "cuenta";
                break;
            case 6:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "contrasena";
                break;
            case 7:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "nombreCompleto";
                break;
            case 8:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "correo";
                break;


            default:break;
        }
    }

    @Override
    public void setProperty(int ind, Object val) {
        switch(ind)
        {
            case 0:
                idCliente = Integer.parseInt(val.toString());
                break;
            case 1:
                primerNombre = val.toString();
                break;
            case 2:
                segundoNombre = val.toString();
                break;
            case 3:
                primerApellido = val.toString();
                break;
            case 4:
                segundoApellido = val.toString();
                break;
            case 5:
                cuenta = val.toString();
                break;
            case 6:
                contrasena = val.toString();
                break;
            case 7:
                nombreCompleto = val.toString();
                break;
            case 8:
                correo = val.toString();
                break;

            default:
                break;
        }
    }
}
