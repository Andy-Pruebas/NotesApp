package pe.avilca.notesapp.repositories;

import com.orm.SugarRecord;

import java.util.List;

import pe.avilca.notesapp.models.Notes;

public class NotesRepository {
    public static List<Notes> list(){
        List<Notes> notesb = SugarRecord.listAll(Notes.class);

        return notesb;
    }

    public static List<Notes> listFavorites(){
        List<Notes> notesFavorites = null;
        List<Notes> notes = list();
        for (Notes n: notes) {
            if (n.getEstado() == 1){
                notesFavorites.add(n);
            }
        }
        return notesFavorites;
    }

    public static List<Notes> listArchived(){
        List<Notes> notesArchiveds = null;
        List<Notes> notes = list();
        for (Notes n: notes) {
            if (n.getEstado() == 2){
                notesArchiveds.add(n);
            }
        }
        return notesArchiveds;
    }

    public static void create(String title,String description, long usuarioId){
        Notes note = new Notes (title,description,usuarioId);
        SugarRecord.save(note);
    }
}
