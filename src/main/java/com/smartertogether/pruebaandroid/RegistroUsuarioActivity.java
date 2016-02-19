package com.smartertogether.pruebaandroid;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class RegistroUsuarioActivity extends AppCompatActivity {

    TextView email;
    TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        email = (TextView) findViewById(R.id.etxt_email);
        password = (TextView) findViewById(R.id.etxt_password);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registro_usuario, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void registrarUsuario(View view){
        //Toast.makeText(RegistroUsuarioActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();
        RegistroUsuarioDbHelper rudb = new RegistroUsuarioDbHelper(getApplicationContext());
        boolean blnInsertado = rudb.insertContact(email.getText().toString(),password.getText().toString());

        Toast.makeText(RegistroUsuarioActivity.this, blnInsertado+"", Toast.LENGTH_SHORT).show();


    }
}
