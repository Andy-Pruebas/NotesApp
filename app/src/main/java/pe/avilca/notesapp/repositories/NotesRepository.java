package pe.avilca.notesapp.repositories;

import com.orm.SugarRecord;

import java.util.List;

import pe.avilca.notesapp.models.Notes;

public class NotesRepository {
    public static List<Notes> list(){
        List<Notes> notes = SugarRecord.listAll(Notes.class);
        return notes;
    }

    public static List<Notes> findByState(String type){
        List<Notes> notes = SugarRecord.find(Notes.class, "state =? ", type);
        return notes;
    }

    public static void create(String title, String content,Long userId){
        Notes note = new Notes(title, content,userId);
        SugarRecord.save(note);
    }

    public static void updateState(String state, long id){
        Notes note = SugarRecord.findById(Notes.class, id);
        note.getState();
        SugarRecord.save(note);
    }
}
