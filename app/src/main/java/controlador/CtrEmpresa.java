package controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.Empresa;

/**
 * Created by carlos.morales on 22/10/2016.
 */
public class CtrEmpresa {




    private static Empresa [] misEmpresas;
    private static CtrEmpresa repository = new CtrEmpresa();
    private static HashMap<Integer, Empresa> empresas = new HashMap<>();


    public static CtrEmpresa getInstance(Empresa [] misempresas) {
        misEmpresas=misempresas;
           for(int i = 0; i < misempresas.length ; i++)
        {
            saveLead(misempresas[i]);
        }
        return repository;
    }

    private CtrEmpresa() {



    }

    private static void saveLead(Empresa empresa) {
        empresas.put(empresa.getIdEmpresa(), empresa);
    }

    public List<Empresa> getLeads() {
        return new ArrayList<>(empresas.values());
    }

}
