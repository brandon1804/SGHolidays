package sg.edu.rp.id18044455.sgholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lvCategory;

    String[] categoryArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCategory = findViewById(R.id.lvCategory);
        categoryArr = new String[2];
        categoryArr[0] = "Secular";
        categoryArr[1] = "Ethnic & Religion";

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categoryArr);
        lvCategory.setAdapter(adapter);

        lvCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT, categoryArr[position]);
                startActivity(intent);
            }
        });


    }//end of onCreate


}//end of class