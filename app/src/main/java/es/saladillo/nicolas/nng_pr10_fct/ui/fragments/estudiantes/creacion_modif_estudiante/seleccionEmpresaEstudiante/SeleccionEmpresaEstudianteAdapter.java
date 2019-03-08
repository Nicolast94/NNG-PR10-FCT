package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.estudiantes.creacion_modif_estudiante.seleccionEmpresaEstudiante;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import es.saladillo.nicolas.nng_pr10_fct.R;
import es.saladillo.nicolas.nng_pr10_fct.data.model.Empresa;
import es.saladillo.nicolas.nng_pr10_fct.ui.activity.MainActivityViewModel;

public class SeleccionEmpresaEstudianteAdapter extends ListAdapter<Empresa, SeleccionEmpresaEstudianteAdapter.ViewHolder> {
    MainActivityViewModel vm ;

    public SeleccionEmpresaEstudianteAdapter(MainActivityViewModel vm) {
        super(new DiffUtil.ItemCallback<Empresa>() {
            @Override
            public boolean areItemsTheSame(@NonNull Empresa oldItem, @NonNull Empresa newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull Empresa oldItem, @NonNull Empresa newItem) {
                return TextUtils.equals(oldItem.getNombre(), newItem.getNombre());
            }
        });

        this.vm = vm;

    }


    @Override
    public Empresa getItem(int position) {
        return super.getItem(position);
    }


    @NonNull
    @Override
    public SeleccionEmpresaEstudianteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SeleccionEmpresaEstudianteAdapter.ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.seleccion_empresa_estudiante_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SeleccionEmpresaEstudianteAdapter.ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    //VIEWHOLDER
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView lblEmpresaParaSeleccionarNombre;
        private Empresa empresaSeleccionada;

        ViewHolder(View itemView) {
            super(itemView);
            lblEmpresaParaSeleccionarNombre = ViewCompat.requireViewById(itemView, R.id.lblEmpresaParaSeleccionarNombre);
            itemView.setOnClickListener(v -> navegarAestudiante(v));
        }

        private void navegarAestudiante(View v) {
            NavController navCtrl = Navigation.findNavController(v);
            vm.setEmpresaAsignadaSeleccionada(empresaSeleccionada);
            vm.setSeHaAsignadoEmpresa(true);
            navCtrl.navigateUp();
        }

        void bind(Empresa empresa) {
            lblEmpresaParaSeleccionarNombre.setText(empresa.getNombre());
            empresaSeleccionada = empresa;
        }
    }
}
