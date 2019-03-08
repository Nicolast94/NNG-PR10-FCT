package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.estudiantes;

import android.os.Bundle;
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

public class EstudiantesAdapter extends ListAdapter<Estudiante, EstudiantesAdapter.ViewHolder> {

    public EstudiantesAdapter() {
        super(new DiffUtil.ItemCallback<Estudiante>() {
            @Override
            public boolean areItemsTheSame(@NonNull Estudiante oldItem, @NonNull Estudiante newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull Estudiante oldItem, @NonNull Estudiante newItem) {
                return TextUtils.equals(oldItem.getNombre(), newItem.getNombre())
                        && TextUtils.equals(oldItem.getEmpresa_asignada(), newItem.getEmpresa_asignada())
                        && TextUtils.equals(oldItem.getTutor(), newItem.getTutor());
            }
        });

    }


    @Override
    public Estudiante getItem(int position) {
        return super.getItem(position);
    }


    @NonNull
    @Override
    public EstudiantesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EstudiantesAdapter.ViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.estudiante_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EstudiantesAdapter.ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    //VIEWHOLDER
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView lblNombreEstudiante,lblEmpresaEstudiante,lblNombreTutor;
        private long estudianteID;

        ViewHolder(View itemView) {
            super(itemView);
            lblNombreEstudiante = ViewCompat.requireViewById(itemView, R.id.lblNombreEstudianteVisita);
            lblEmpresaEstudiante = ViewCompat.requireViewById(itemView, R.id.lblEmpresaEstudianteVisita);
            lblNombreTutor = ViewCompat.requireViewById(itemView, R.id.lblNombreTutor);
            itemView.setOnClickListener(v -> navegarAestudiante(v));
        }

        private void navegarAestudiante(View v) {
            NavController navCtrl = Navigation.findNavController(v);
            Bundle argumentos = new Bundle();
            argumentos.putLong("idEstudiante", estudianteID);
            navCtrl.navigate(R.id.actionEstudianteToCreacionModifEstudiante,argumentos);
        }

        void bind(Estudiante estudiante) {
            lblNombreEstudiante.setText(estudiante.getNombre());
            lblEmpresaEstudiante.setText(estudiante.getEmpresa_asignada());
            lblNombreTutor.setText(String.format("Tutor: %s",estudiante.getTutor()));
            estudianteID = estudiante.getId();
        }
    }
}
