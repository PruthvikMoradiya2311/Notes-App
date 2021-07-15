package com.example.notesapp.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.notesapp.Dao.NotesDao;
import com.example.notesapp.Database.NotesDatabase;
import com.example.notesapp.Model.Notes;

import java.util.List;

public class NotesRepository {

    public NotesDao notesDao;
    public LiveData<List<Notes>> getAllNotes;

    public LiveData<List<Notes>> highToLow;
    public LiveData<List<Notes>> lowToHigh;




    public NotesRepository(Application application) {
        NotesDatabase database = NotesDatabase.getDatabaseInstance(application);
        notesDao = database.notesDao();
        getAllNotes = notesDao.getAllNotes();
        highToLow = notesDao.highToLow();
        lowToHigh = notesDao.lowToHigh();


    }

    public void insertNotes(Notes notes)
    {
        notesDao.insertNotes(notes);
    }

    public void deleteNotes(int id)
    {
        notesDao.deleteNotes(id);
    }

   public void updateNotes(Notes notes){
       notesDao.updateNotes(notes);
    }



}
