package pe.avilca.notesapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import pe.avilca.notesapp.R;
import pe.avilca.notesapp.adapters.NotesAdapter;
import pe.avilca.notesapp.models.Notes;
import pe.avilca.notesapp.repositories.NotesRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotesFragment extends Fragment {

    private RecyclerView notes_list;
    public NotesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes, container, false);
        notes_list = view.findViewById(R.id.notes_list);
        notes_list.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Notes> notes = NotesRepository.list();
        notes_list.setAdapter(new NotesAdapter(notes));
        return view;
    }

}
