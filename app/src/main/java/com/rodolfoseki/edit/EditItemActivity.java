package com.rodolfoseki.edit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.rodolfoseki.simpletodo.R;

public class EditItemActivity extends AppCompatActivity {

    EditText etView;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        etView = (EditText) findViewById(R.id.etEdit);
        String item = getIntent().getStringExtra("item");
        etView.setText(item);
        pos = Integer.parseInt(getIntent().getStringExtra("pos"));

    }



    public void onSubmit(View v) {
        // Prepare data intent
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("item", etView.getText().toString());
        data.putExtra("pos", String.valueOf(pos)); // ints work too
        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set result code and bundle data for response
        finish(); // closes the activity, pass data to parent
    }
}
