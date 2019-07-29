package com.learnque.my.notesapp.ui.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.learnque.my.notesapp.R;
import com.learnque.my.notesapp.model.Note;
import com.learnque.my.notesapp.ui.NoteAddUpdateActivity;
import com.learnque.my.notesapp.ui.utility.CustomOnItemClickListener;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private ArrayList<Note> notes = new ArrayList<>();
    private Activity activity;

    public NoteAdapter(Activity activity) {
        this.activity = activity;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        if (notes.size() > 0) {
            this.notes.clear();
        }
        this.notes.addAll(notes);
        notifyDataSetChanged();
    }

    public void addItem(Note note) {
        this.notes.add(note);
        notifyItemInserted(notes.size() - 1);
    }

    public void updateItem(int position, Note note) {
        this.notes.set(position, note);
        notifyItemChanged(position, note);
    }

    public void removeItem(int position) {
        this.notes.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,notes.size());
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_note, viewGroup, false);
        return new NoteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int i) {
        holder.bind(getNotes().get(i));

        holder.cardView.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Intent intent = new Intent(activity, NoteAddUpdateActivity.class);
                intent.putExtra(NoteAddUpdateActivity.EXTRA_POSITION, position);
                intent.putExtra(NoteAddUpdateActivity.EXTRA_NOTE, getNotes().get(position));
                activity.startActivityForResult(intent, NoteAddUpdateActivity.REQUEST_UPDATE);
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getNotes().size();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView title, desc, date;

        NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cv_item_note);
            title = itemView.findViewById(R.id.tv_item_title);
            desc = itemView.findViewById(R.id.tv_item_description);
            date = itemView.findViewById(R.id.tv_item_date);
        }

        void bind(Note note) {
            title.setText(note.getTitle());
            desc.setText(note.getDescription());
            date.setText(note.getDate());
        }
    }
}
