package sg.edu.rp.id18044455.sgholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    TextView tvCategory;
    ListView lvHolidays;
    ArrayAdapter arrayAdapter;


    ArrayList<Secular> secularholsList;
    ArrayList<EthnicReligion> eRholsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvCategory = findViewById(R.id.tvCategory);
        lvHolidays = findViewById(R.id.lvHolidays);

        secularholsList = new ArrayList<Secular>();
        secularholsList.add(new Secular("New Year's Day", "1 Jan 2021"));
        secularholsList.add(new Secular("Labour Day", "1 May 2021"));

        eRholsList = new ArrayList<EthnicReligion>();
        eRholsList.add(new EthnicReligion("Chinese New Year", "12-13 Feb 2021"));
        eRholsList.add(new EthnicReligion("Good Friday", "2 April 2021"));

        Intent intent = getIntent();
        String category = intent.getStringExtra(Intent.EXTRA_TEXT);
        tvCategory.setText(category);


        if(category.equals("Secular")){
            arrayAdapter = new SecularAdapter(this, R.layout.row, secularholsList);

        }
        else if(category.equals("Ethnic & Religion")){
            arrayAdapter = new EthnicReligionAdapter(this, R.layout.row, eRholsList);
        }

        lvHolidays.setAdapter(arrayAdapter);

        lvHolidays.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(category.equals("Secular")){
                    Secular currSelection = secularholsList.get(position);
                    Toast.makeText(SecondActivity.this, currSelection.getHolidayName()
                                    + " Date: " + currSelection.getHolidayDate(),
                            Toast.LENGTH_LONG).show();
                }
                else if(category.equals("Ethnic & Religion")){
                    EthnicReligion currSelection = eRholsList.get(position);
                    Toast.makeText(SecondActivity.this, currSelection.getHolidayName()
                                    + " Date: " + currSelection.getHolidayDate(),
                            Toast.LENGTH_LONG).show();
                }


            }
        });



    }//end of onCreate

}//end of class