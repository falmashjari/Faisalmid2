package Faisal.mid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Database2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database2);
        setTitle("You are in Activity3");

        Button go1 = findViewById(R.id.btn_go_3act1);
        Button go2 = findViewById(R.id.btn_go_3act2);

        Button delete = findViewById(R.id.btn_delete);
        Button select = findViewById(R.id.btn_select);

        EditText inp_id = findViewById(R.id.inp_ID);
        EditText inp_name = findViewById(R.id.inp_name);


        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = Databaseh.getResult(inp_name.getText() + "");

                if (c == null) {
                    Toast.makeText(Database2.this, "There is no such record.", Toast.LENGTH_SHORT).show();
                    return;
                }
                String message = c.getInt(0) + " " +
                        c.getString(1) + " " +
                        c.getString(2) + " " +
                        c.getString(3) + " " +
                        c.getString(4) + " ";

                Toast.makeText(Database2.this, "Record found: " + message, Toast.LENGTH_LONG).show();


            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Databaseh.delete(inp_id.getText() + "");
            }
        });

        go1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Database2.this, intro.class));
            }
        });
        go2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Database2.this, Database.class));
            }
        });
    }}



