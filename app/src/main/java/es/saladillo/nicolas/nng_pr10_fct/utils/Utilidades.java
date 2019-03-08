package es.saladillo.nicolas.nng_pr10_fct.utils;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import es.saladillo.nicolas.nng_pr10_fct.data.Repositorio;
import es.saladillo.nicolas.nng_pr10_fct.data.RepositorioImpl;
import es.saladillo.nicolas.nng_pr10_fct.data.local.AppDatabase;
import es.saladillo.nicolas.nng_pr10_fct.data.local.EmpresaDao;
import es.saladillo.nicolas.nng_pr10_fct.data.local.EstudianteDao;
import es.saladillo.nicolas.nng_pr10_fct.data.local.VisitaDao;
import es.saladillo.nicolas.nng_pr10_fct.ui.fragments.empresas.EmpresasAdapter;

public class Utilidades {

    private Utilidades() { }

    public static Repositorio obtenerRepositorioBD(Context context){
        EstudianteDao estudianteDao;
        VisitaDao visitaDao;
        EmpresaDao empresaDao;

        estudianteDao = AppDatabase.getInstance(context).estudianteDao();
        visitaDao = AppDatabase.getInstance(context).visitaDao();
        empresaDao = AppDatabase.getInstance(context).empresaDao();
        return new RepositorioImpl(estudianteDao, visitaDao, empresaDao);
    }

}
