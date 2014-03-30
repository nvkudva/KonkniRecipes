package com.nvkudva.recipes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.*;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nvkudva.recipes.dao.Ingredient;
import com.nvkudva.recipes.dao.Plate;

public class RecipeView extends ActionBarActivity {
    static Plate plate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_view);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            plate = (Plate) extras.getSerializable("plate");
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.recipe_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_recipe_view, container, false);
            TextView txtKonkaniName = (TextView) rootView.findViewById(R.id.txtKonkaniName);
            txtKonkaniName.setText(plate.konkaniName);

            TextView txtName = (TextView) rootView.findViewById(R.id.txtName);
            txtName.setText(plate.name);

            TextView txtPreperationTime = (TextView) rootView.findViewById(R.id.txtPreperationTime);
            txtName.setText(plate.preperationTime+ " Minutes");

            TextView txt = (TextView) rootView.findViewById(R.id.txtContributors);
            txtName.setText(plate.name);

            LinearLayout layoutIngredients = (LinearLayout) rootView.findViewById(R.id.layoutIngredients);
            for (Ingredient ing : plate.ingredients) {
                TextView tv = (TextView) inflater.inflate(R.layout.row_directions, null);
                String str =ing.item + "\t\t\t:" + ing.quantity;
                String txtx=str.substring(0,1).toUpperCase() + str.substring(1);
                tv.setText(txtx);
                layoutIngredients.addView(tv);
            }

            LinearLayout layoutDirections = (LinearLayout) rootView.findViewById(R.id.layoutDirections);
            for (String step : plate.directions) {
                TextView tv = (TextView) inflater.inflate(R.layout.row_directions, null);
                String txtx=step.substring(0,1).toUpperCase() + step.substring(1);
                tv.setText(txtx);
                tv.setTextAppearance(rootView.getContext(), R.style.textBoldX);
                layoutDirections.addView(tv);
            }


            TextView txtContributors = (TextView) rootView.findViewById(R.id.txtContributors);
            txtContributors.setText("");
            if(plate.contributors!=null){
                for (String c : plate.contributors) {
                    String txtx=c.substring(0,1).toUpperCase() + c.substring(1);
                    txtContributors.append(txtx+ " ");
                }
            }


            String heart = "\u2764 "+ plate.likes + " Likes";
            Button btnLike = (Button) rootView.findViewById(R.id.btnLike);
            return rootView;
        }

    }

}
