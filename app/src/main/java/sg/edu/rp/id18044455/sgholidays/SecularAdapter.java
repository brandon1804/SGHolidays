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

public class SecularAdapter extends ArrayAdapter<Secular> {

    private ArrayList<Secular> secularholsList;
    private Context context;
    private TextView tvHolidayName, tvHolidayDate;
    private ImageView ivHoliday;

    public SecularAdapter(Context context, int resource, ArrayList<Secular> objects){
        super(context, resource, objects);
        secularholsList = objects;
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

        Secular currentHol = secularholsList.get(position);


        tvHolidayName.setText(currentHol.getHolidayName());
        tvHolidayDate.setText(currentHol.getHolidayDate());

        if(currentHol.getHolidayName() == "New Year's Day") {
            ivHoliday.setImageResource(R.drawable.newyear);
        }
        else if(currentHol.getHolidayName() == "Labour Day") {
            ivHoliday.setImageResource(R.drawable.labourday);
        }

        return rowView;
    }


}//end of class
