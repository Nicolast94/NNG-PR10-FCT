package es.saladillo.nicolas.nng_pr10_fct.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import es.saladillo.nicolas.nng_pr10_fct.R;
import es.saladillo.nicolas.nng_pr10_fct.data.Repositorio;
import es.saladillo.nicolas.nng_pr10_fct.data.RepositorioImpl;
import es.saladillo.nicolas.nng_pr10_fct.data.local.AppDatabase;
import es.saladillo.nicolas.nng_pr10_fct.data.local.EmpresaDao;
import es.saladillo.nicolas.nng_pr10_fct.data.local.EstudianteDao;
import es.saladillo.nicolas.nng_pr10_fct.data.local.VisitaDao;
import es.saladillo.nicolas.nng_pr10_fct.ui.fragments.empresas.EmpresasViewModel;
import es.saladillo.nicolas.nng_pr10_fct.ui.fragments.empresas.EmpresasViewModelFactory;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    DrawerLayout drawerLayout;
    private Repositorio repositorio;
    private MainActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navController = Navigation.findNavController(this, R.id.navHostFragment);
        setupToolbar();
        setupNavigationDrawer();
        setupViewModel();
    }

    private void setupViewModel() {
        EstudianteDao estudianteDao = AppDatabase.getInstance(this).estudianteDao();
        VisitaDao visitaDao = AppDatabase.getInstance(this).visitaDao();
        EmpresaDao empresaDao = AppDatabase.getInstance(this).empresaDao();
        repositorio = new RepositorioImpl(estudianteDao, visitaDao, empresaDao);
        vm = ViewModelProviders.of(this, new MainActivityViewModelFactory(repositorio)).get(MainActivityViewModel.class);
    }

    private void setupToolbar() {
        Toolbar toolbar = ActivityCompat.requireViewById(this, R.id.toolbar);
        drawerLayout = ActivityCompat.requireViewById(this, R.id.drawerLayout);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(
                        R.id.destProximasVisitasFragment, R.id.destVisitasFragment, R.id.destEmpresasFragment,R.id.destEstudiantesFragment,R.id.destAcercaDeFragment)
                        .setDrawerLayout(drawerLayout)
                        .build();

        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
    }

    private void setupNavigationDrawer() {
        NavigationView navigationView =
                ActivityCompat.requireViewById(this, R.id.navigationView);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
