package nontakarn.Nontakarn_restaurant;

import android.content.Context;
import android.content.pm.LabeledIntent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import nontakarn.Nontakarn_restaurant.R;
import com.squareup.picasso.Picasso;



public class ProductAdapter extends BaseAdapter {
    private Context context;
    private  String[] iconStrings,titleStrings,priceString;
    public  ProductAdapter(Context context,
                           String[] iconStrings,
                           String[] titleStrings,
                           String[] priceString){
        this.context=context;
        this.iconStrings=iconStrings;
        this.titleStrings=titleStrings;
        this.priceString=priceString;
    }







    @Override
    public int getCount() { return iconStrings.length;

    }

    @Override
    public Object getItem(int i ) {return null;

    }

    @Override
    public long getItemId(int i ) {return 0;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.food_listview,viewGroup,false);
        TextView titleTextView = (TextView) view.findViewById(R.id.textView);
        titleTextView.setText(titleStrings[i]);

        TextView priceTextView = (TextView) view.findViewById(R.id.textView2);
        priceTextView.setText(priceString[i]);

        ImageView iconImageView = (ImageView) view.findViewById(R.id.imageView2);
        Picasso.with(context).load(iconStrings[i]).resize(150,150).into(iconImageView);
        return view;
    }
    //Explicit



}//Mainclass
