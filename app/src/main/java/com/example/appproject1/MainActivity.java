package com.example.appproject1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
List<Model> modelList;
RecyclerView recyclerView;
OrderAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating on arraylist
        modelList=new ArrayList<>();
        //la liste des sushis
        modelList.add(new Model("Sushi Saumon",getString(R.string.sushi_saumon),R.drawable.sushisaumon));
        modelList.add(new Model("Sushi anguille",getString(R.string.sushi_anguille),R.drawable.sushianguille));
        modelList.add(new Model("Sushi avocat",getString(R.string.sushi_avocat),R.drawable.sushiavocat));
        modelList.add(new Model("Sushi crevettes",getString(R.string.sushi_crevettes),R.drawable.sushicrevette));
        modelList.add(new Model("Sushi omlette",getString(R.string.sushi_omlette),R.drawable.sushiomlette));
        modelList.add(new Model("Sushi daurade",getString(R.string.sushi_daurade),R.drawable.sushidaurade));
        modelList.add(new Model("Sushi maquereau",getString(R.string.sushi_maquereau),R.drawable.sushimaquereau));
        modelList.add(new Model("Sushi surimi",getString(R.string.sushi_surimi),R.drawable.sushisurimi));
        modelList.add(new Model("Sushi thon",getString(R.string.sushi_thon),R.drawable.sushithon));
        //la liste des makis
        modelList.add(new Model("Maki Saumon",getString(R.string.maki_saumon),R.drawable.makisaumon));
        modelList.add(new Model("Maki avocat",getString(R.string.maki_avocat),R.drawable.makiavocat));
        modelList.add(new Model("Maki cheese",getString(R.string.maki_cheese),R.drawable.makicheese));
        modelList.add(new Model("Maki Concombre",getString(R.string.maki_concombre),R.drawable.makiconcombre));
        modelList.add(new Model("Maki Radis Jaune",getString(R.string.maki_radis_jaune),R.drawable.makiradisjaune));
        modelList.add(new Model("Maki thon",getString(R.string.maki_thon),R.drawable.makithon));
        //la list des croustimaki
        modelList.add(new Model("Crousti Maki avocat concombre",getString(R.string.Crousti_Maki_avocat_concombre),R.drawable.croustimakiavocatconcombre));
        modelList.add(new Model("Crousti Maki cheese saumon",getString(R.string.Crousti_Maki_cheese_saumon),R.drawable.croustimakicheesesaumon));
        modelList.add(new Model("Crousti Maki avocat saumon",getString(R.string.Crousti_Maki_avocat_saumon),R.drawable.croustimakiavocatsaumon));
        modelList.add(new Model("Crousti Maki avocat thon cuit",getString(R.string.Crousti_Maki_avocat_thon_cuit),R.drawable.croustimakiavocatthoncuit));
        //la list des california
        modelList.add(new Model("california avocat crevette",getString(R.string.california_avocat_crevette),R.drawable.californiaavocatcrevette));
        modelList.add(new Model("california avocat saumon",getString(R.string.california_avocat_saumon),R.drawable.californiaavocatsaumon));
        modelList.add(new Model("california avocat surimi",getString(R.string.california_avocat_surimi),R.drawable.californiaavocatsurimi));
        modelList.add(new Model("california avocat thon",getString(R.string.california_avocat_thon),R.drawable.californiaavocatthon));
        modelList.add(new Model("california avocat thon cuit",getString(R.string.california_avocat_thon_cuit),R.drawable.californiaavocatthoncuit));
        //la list des sashimi

        modelList.add(new Model("sashimi assortiment",getString(R.string.sashimi_assortiment),R.drawable.sashimiassortiment));
        modelList.add(new Model("sashimi daurade",getString(R.string.sashimi_daurade),R.drawable.sashimidaurade));
        modelList.add(new Model("sashimi maquereau",getString(R.string.sashimi_maquereau),R.drawable.sashimimaquereau));
        modelList.add(new Model("sashimi saumon",getString(R.string.sashimi_saumon),R.drawable.sashimisaumon));
        modelList.add(new Model("sashimi thon",getString(R.string.sashimi_thon),R.drawable.sashimithon));
// la list des temakis

        modelList.add(new Model("Temaki avocat saumon",getString(R.string.Temaki_avocat_saumon),R.drawable.temakiavocatsaumon));
        modelList.add(new Model("Temaki avocat saumon thon",getString(R.string.Temaki_avocat_saumon_thon),R.drawable.temakiavocatsaumonthon));
        modelList.add(new Model("Temaki avocat thon",getString(R.string.Temaki_avocat_thon),R.drawable.temakiavocatthon));
        //la list des Yakitoris

        modelList.add(new Model("yakitori boeuf",getString(R.string.yakitori_boeuf),R.drawable.yakitoriboeuf));
        modelList.add(new Model("yakitori boeuf fromage",getString(R.string.yakitori_boeuf_fromage),R.drawable.yakitoriboeuffromage));
        modelList.add(new Model("yakitori boulettes poulet",getString(R.string.yakitori_boulettes_poulet),R.drawable.yakitoriboulettesdepoulet));
        modelList.add(new Model("yakitori gambs",getString(R.string.yakitori_gambs),R.drawable.yakitorigambas));
        modelList.add(new Model("yakitori poulet",getString(R.string.yakitori_poulet),R.drawable.yakitoripoulet));
        modelList.add(new Model("yakitori thon",getString(R.string.yakitori_thon),R.drawable.yakitorithon));
//saumonroll

        modelList.add(new Model("saumon roll avocat",getString(R.string.saumon_roll_avocat),R.drawable.saumonrollavocat));
        modelList.add(new Model("saumon roll cheese",getString(R.string.saumon_roll_cheese),R.drawable.saumonrollcheese));
        modelList.add(new Model("saumon roll cheese saumon",getString(R.string.saumon_roll_cheese_saumon),R.drawable.saumonrollcheesesaumon));
        modelList.add(new Model("saumon roll thon",getString(R.string.saumon_roll_thon),R.drawable.saumonrollthon));

        //printemps

        modelList.add(new Model("printemps roll avocat concombre",getString(R.string.printemps_roll_avocat_concombre),R.drawable.printempsrollavocatconcombre));
        modelList.add(new Model("printemps roll avocat crevettes",getString(R.string.printemps_roll_avocat_crevettes),R.drawable.printempsrollavocatcrevette));
        modelList.add(new Model("printemps roll avocat saumon",getString(R.string.printemps_roll_avocat_saumon),R.drawable.printempsrollavocatsaumon));
        modelList.add(new Model("printemps roll avocat saumon thon",getString(R.string.printemps_roll_avocat_saumon_thon),R.drawable.printempsrollavocatsaumonthon));
//recyclerview
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));
        //adapter
        mAdapter = new OrderAdapter(this,modelList);
        recyclerView.setAdapter(mAdapter);




    }
}

