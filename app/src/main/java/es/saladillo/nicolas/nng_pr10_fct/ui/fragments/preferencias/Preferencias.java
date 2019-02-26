package es.saladillo.nicolas.nng_pr10_fct.ui.fragments.preferencias;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;
import es.saladillo.nicolas.nng_pr10_fct.R;

public class Preferencias extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }
}
