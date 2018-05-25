package com.example.darshana.notesafeapp;

import android.content.ClipData;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NoteHome extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_home);

        listView = (ListView) findViewById(R.id.listNote);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_note_home,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_notehome_new_note:
                //start new activity new note mode
                Intent intent = new Intent(this, Notes.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        listView.setAdapter(null);

        ArrayList<Note> notes = Utilities.getAllSavedNotes(this);

        if (notes == null || notes.size() == 0){
            Toast.makeText(this,"You have no saved notes",Toast.LENGTH_SHORT).show();
            return;
        }else {
            NoteAdapter na = new NoteAdapter(this,R.layout.item_note,notes);
            listView.setAdapter(na);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String fileName = ((Note)listView.getItemAtPosition(position)).getmDateTime()
                            +Utilities.FILE_EXTENSION;

                    Intent viewNoteIntent = new Intent(getApplicationContext(),Notes.class);
                    viewNoteIntent.putExtra("NOTE_FILE",fileName);
                    startActivity(viewNoteIntent);
                }
            });
        }
    }
}
