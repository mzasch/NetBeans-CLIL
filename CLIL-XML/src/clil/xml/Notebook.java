package clil.xml;

import java.util.ArrayList;
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
        for (Note note : this.notes) {
            if(note.getCreation().equals(date)){
                filter.add(note);
            }
        }
        return filter;
    }
}
