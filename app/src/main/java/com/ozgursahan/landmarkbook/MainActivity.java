package com.ozgursahan.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.ozgursahan.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    ArrayList<Landmark> landmarkArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        landmarkArrayList=new ArrayList<>();

        // Data Part
        Landmark pisa=new Landmark("Pisa Tower","Italy",R.drawable.pisa);
        Landmark eiffel=new Landmark("Eiffel Tower","France",R.drawable.eiffel);
        Landmark tacmahal=new Landmark("Tac Mahal","India",R.drawable.tacmahal);
        Landmark liberty=new Landmark("Statue of Liberty","USA",R.drawable.liberty);

        landmarkArrayList.add(pisa);
        landmarkArrayList.add(eiffel);
        landmarkArrayList.add(tacmahal);
        landmarkArrayList.add(liberty);

        //RecyclerView zor verimli
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapter landmarkAdapter=new LandmarkAdapter(landmarkArrayList);
        binding.recyclerView.setAdapter(landmarkAdapter);

        /*
        //ListView kolay verimsiz
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,landmarkArrayList.stream().map(landmark-> landmark.name).collect(Collectors.toList()));
        binding.listView.setAdapter(arrayAdapter);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //System.out.println(landmarkNames.get(i));
                //System.out.println(countryNames.get(i));
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("landmark", landmarkArrayList.get(i));
                startActivity(intent);
            }
        });
         */

    }
}