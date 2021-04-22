package sg.edu.rp.id18044455.sgholidays;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class EthnicReligionAdapter extends ArrayAdapter<EthnicReligion> {

    private ArrayList<EthnicReligion> eRholsList;
    private Context context;
    private TextView tvHolidayName, tvHolidayDate;
    private ImageView ivHoliday;

    public EthnicReligionAdapter(Context context, int resource, ArrayList<EthnicReligion> objects){
        super(context, resource, objects);
        eRholsList = objects;
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvHolidayName = (TextView) rowView.findViewById(R.id.tvHolidayName);
        tvHolidayDate = (TextView) rowView.findViewById(R.id.tvHolidayDate);
        ivHoliday = (ImageView) rowView.findViewById(R.id.ivHoliday);

        EthnicReligion currentHol = eRholsList.get(position);


        tvHolidayName.setText(currentHol.getHolidayName());
        tvHolidayDate.setText(currentHol.getHolidayDate());


        if(currentHol.getHolidayName() == "Chinese New Year") {
            ivHoliday.setImageResource(R.drawable.cny);
        }
        else if(currentHol.getHolidayName() == "Good Friday") {
            ivHoliday.setImageResource(R.drawable.goodfriday);
        }

        return rowView;
    }


}//end of class
