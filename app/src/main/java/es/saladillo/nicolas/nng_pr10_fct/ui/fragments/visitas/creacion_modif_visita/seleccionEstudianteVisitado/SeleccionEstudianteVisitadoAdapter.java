package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.visitas.creacion_modif_visita.seleccionEstudianteVisitado;

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
import es.saladillo.nicolas.nng_pr10_fct.data.model.Estudiante;
import es.saladillo.nicolas.nng_pr10_fct.ui.activity.MainActivityViewModel;
import es.saladillo.nicolas.nng_pr10_fct.ui.fragments.estudiantes.creacion_modif_estudiante.seleccionEmpresaEstudiante.SeleccionEmpresaEstudianteAdapter;

public class SeleccionEstudianteVisitadoAdapter extends ListAdapter<Estudiante, SeleccionEstudianteVisitadoAdapter.ViewHolder> {
    MainActivityViewModel vm ;

    public SeleccionEstudianteVisitadoAdapter(MainActivityViewModel vm) {
        super(new DiffUtil.ItemCallback<Estudiante>() {
            @Override
            public boolean areItemsTheSame(@NonNull Estudiante oldItem, @NonNull Estudiante newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull Estudiante oldItem, @NonNull Estudiante newItem) {
                return TextUtils.equals(oldItem.getNombre(), newItem.getNombre());
            }
        });

        this.vm = vm;

    }


    @Override
    public Estudiante getItem(int position) {
        return super.getItem(position);
    }


    @NonNull
    @Override
    public SeleccionEstudianteVisitadoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SeleccionEstudianteVisitadoAdapter.ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.seleccion_estudiante_visitado_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SeleccionEstudianteVisitadoAdapter.ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    //VIEWHOLDER
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView lblEstudianteAvisitar_Nombre;
        private Estudiante estudianteSeleccionado;

        ViewHolder(View itemView) {
            super(itemView);
            lblEstudianteAvisitar_Nombre = ViewCompat.requireViewById(itemView, R.id.lblEstudianteAvisitar_Nombre);
            itemView.setOnClickListener(v -> navegarAestudiante(v));
        }

        private void navegarAestudiante(View v) {
            NavController navCtrl = Navigation.findNavController(v);
            vm.setEstudianteVisitadoSeleccionado(estudianteSeleccionado);
            vm.setSeHaSeleccionadoEstudianteVisitado(true);
            navCtrl.navigateUp();
        }

        void bind(Estudiante estudiante) {
            lblEstudianteAvisitar_Nombre.setText(estudiante.getNombre());
            estudianteSeleccionado = estudiante;
        }
    }
}
