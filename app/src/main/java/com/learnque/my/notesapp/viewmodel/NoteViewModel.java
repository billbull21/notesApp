package com.learnque.my.notesapp.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.learnque.my.notesapp.db.NoteHelper;
import com.learnque.my.notesapp.model.Note;

import java.util.ArrayList;

public class NoteViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Note>> data = new MutableLiveData<>();

    public LiveData<ArrayList<Note>> getData() {
        return data;
    }

    public void setData(Context context) {
        NoteHelper noteHelper = NoteHelper.getInstance(context);
        noteHelper.open();
        data.postValue(noteHelper.getAllNotes());
        noteHelper.close();
    }
}
