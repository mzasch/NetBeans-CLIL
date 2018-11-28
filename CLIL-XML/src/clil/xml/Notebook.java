package clil.xml;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Notebook {
    ArrayList<Note> notes = new ArrayList<>();

    @XmlElement
    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }
    
    public void AddNote(String description){
        Note n = new Note();
        n.setCreation(new Date());
        n.setDescription(description);
        AddNote(n);
    }
    
    public void AddNote(Note n){
        this.notes.add(n);
    }
    
    public ArrayList<Note> GetNotesByDescription(String word){
        ArrayList<Note> filter = new ArrayList<>();
        for (Note note : this.notes) {
            if(note.getDescription().contains(word)){
                filter.add(note);
            }
        }
        return filter;
    }
    
    public ArrayList<Note> GetNotesByDate(Date date){
        ArrayList<Note> filter = new ArrayList<>();
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        c1.set(Calendar.HOUR_OF_DAY, 0);
        c1.set(Calendar.MINUTE, 0);
        c1.set(Calendar.SECOND, 0);
        c1.set(Calendar.MILLISECOND, 0);
        Calendar c2 = Calendar.getInstance();
        
        for (Note note : this.notes) {
            c2.setTime(note.creation);
            c2.set(Calendar.HOUR_OF_DAY, 0);
            c2.set(Calendar.MINUTE, 0);
            c2.set(Calendar.SECOND, 0);
            c2.set(Calendar.MILLISECOND, 0);
            if(c1.getTime().equals(c2.getTime())){
                filter.add(note);
            }
        }
        return filter;
    }
}
