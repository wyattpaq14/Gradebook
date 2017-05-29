package neit.gradebook;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    public EditText txtStudID;
    public EditText txtFirstName;
    public EditText txtLastName;
    public EditText txtGrade;
    public EditText txtAssignment;
    public Button btnSubmit;
    public Button btnDelete;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        txtStudID = (EditText) findViewById(R.id.txtStudID);
        txtFirstName = (EditText) findViewById(R.id.txtFirstName);
        txtLastName = (EditText) findViewById(R.id.txtLastName);
        txtGrade = (EditText) findViewById(R.id.txtGrade);
        txtAssignment = (EditText) findViewById(R.id.txtAssignment);


        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnDelete = (Button) findViewById(R.id.btnDeleteGrades);


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File dir = getFilesDir();
                File file = new File(dir, "config.txt");
                file.delete();

                Toast toast = Toast.makeText(getApplicationContext(), "Grades Deleted!", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processNewGrade();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    public void processNewGrade() {

        Context context = getApplicationContext();
        Grade grade1 = new Grade(txtStudID.getText().toString(), txtFirstName.getText().toString(), txtLastName.getText().toString(), Double.parseDouble(txtGrade.getText().toString()), txtAssignment.getText().toString());
        grade1.writeToFile(context);


        Toast toast = Toast.makeText(this.getApplicationContext(), Grade.readFromFile(context)[0], Toast.LENGTH_LONG);
        toast.show();


    }
}
