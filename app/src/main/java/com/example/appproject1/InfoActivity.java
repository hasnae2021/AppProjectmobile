package com.example.appproject1;

import static com.example.appproject1.DBmain.KEY_CHOICE;
import static com.example.appproject1.DBmain.KEY_NAME;
import static com.example.appproject1.DBmain.KEY_NATURE;
import static com.example.appproject1.DBmain.KEY_SAUCE;
import static com.example.appproject1.DBmain.KEY_TOPPINGS;
import static com.example.appproject1.DBmain.TABLE_NAME;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class InfoActivity extends AppCompatActivity  {

    ImageView imageView;

    ImageButton plusquantity, minusquantity;
    TextView quantitynumber, sushiName, sushiPrice;
    RadioButton vegetarienRadioButton,SpicyRadioButton;
    CheckBox addToppings, addSauce;
    Spinner spinner;
    Button submit,display;
    String[]choice={"emporté","Livraison à domicile"};//for spinner array
    int quantity;
    public Uri mCurrentCartUri;
    boolean hasAllRequiredValues = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        imageView = findViewById(R.id.imageViewInfo);
        plusquantity = findViewById(R.id.addquantity);
        minusquantity = findViewById(R.id.subquantity);
        quantitynumber = findViewById(R.id.quantity);
        sushiName = findViewById(R.id.sushiNameInfo);
        sushiPrice = findViewById(R.id.sushiPrice);
        addToppings = findViewById(R.id.addToppings);
        //addtoCart = findViewById(R.id.addtocart);
        addSauce = findViewById(R.id.addSauce);
        sushiName.setText("Sushi Saumon");

        plusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int basePrice=30;
                quantity++;
                displayQuantity();
                int sushiiPrice= basePrice * quantity;
                String setnewPrice = String.valueOf(sushiiPrice);
                sushiPrice.setText(setnewPrice);

                int ifCheckBox = CalculatePrice(addSauce, addToppings);
                sushiPrice.setText("DH" + ifCheckBox);
            }
        });
        minusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int basePrice=30;
                if(quantity==0){
                    Toast.makeText(InfoActivity.this, "Cant decrease quantity <0", Toast.LENGTH_SHORT).show();
                }else {
                    quantity--;
                    displayQuantity();
                    int sushiiPrice= basePrice * quantity;
                    String setnewPrice = String.valueOf(sushiiPrice);
                    sushiPrice.setText(setnewPrice);

                }
            }
        });
    }



    private int CalculatePrice(CheckBox addSauce, CheckBox addToppings) {
        int basePrice=30;

        if(addSauce.isChecked()){
            basePrice=basePrice+20;
        }
        if(addToppings.isChecked()){
            basePrice=basePrice+15;
        }
        return  basePrice * quantity;
    }

    private void displayQuantity() {
        quantitynumber.setText(String.valueOf(quantity));
    }


}