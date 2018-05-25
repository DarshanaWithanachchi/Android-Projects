package com.example.darshana.notesafeapp;

import android.content.DialogInterface;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class Notes extends AppCompatActivity {

    private EditText edTitle;
    private EditText edContent;

    private String mNoteFileName;
    private Note mLoadedNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        edTitle = findViewById(R.id.edTitle);
        edContent = findViewById(R.id.edNote);

        mNoteFileName = getIntent().getStringExtra("NOTE_FILE");
        if (mNoteFileName != null && !mNoteFileName.isEmpty()){
            mLoadedNote = Utilities.getNoteByName(this,mNoteFileName);

            if (mLoadedNote != null){
                edTitle.setText(mLoadedNote.getmTitle());
                edContent.setText(mLoadedNote.getmContent());
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_notes,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_notes_save_note:saveNote();break;
            case R.id.action_notes_save_delete:deleteNote();break;
        }
        return true;
    }

    private void saveNote(){
        Note note;

        if (mLoadedNote == null){
             note = new Note(System.currentTimeMillis(),edTitle.getText().toString(),edContent.getText().toString());
        }else {
             note = new Note(mLoadedNote.getmDateTime(),edTitle.getText().toString(),edContent.getText().toString());
        }


        if (Utilities.saveNote(this,note)){
            Toast.makeText(this,"Your note is saved",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Can not save the note,please make sure you have enough space on your device",Toast.LENGTH_SHORT).show();
        }
        finish();
    }

    private void deleteNote(){
        if (mLoadedNote == null){
            finish();
        }else {

            AlertDialog.Builder dialog = new AlertDialog.Builder(this)
                    .setTitle("delete")
                    .setMessage("Youare about to delete"+edTitle.getText().toString()+"Are you sure")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Utilities.deleteNote(getApplicationContext(),mLoadedNote.getmDateTime()+Utilities.FILE_EXTENSION);
                            Toast.makeText(getApplicationContext(),edTitle.getText().toString()+" is deleted ",Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    })
                    .setNegativeButton("no",null)
                    .setCancelable(false);
            dialog.show();
        }
    }
}
