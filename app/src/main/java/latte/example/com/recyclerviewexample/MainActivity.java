package latte.example.com.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv);
        adapter = new CustomAdapter();

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setOnItemClickListener((item, position) -> {
            Toast.makeText(this,"item title = \'" + item.title + "\' position = " + position,Toast.LENGTH_SHORT).show();
        });

        adapter.setItems(createItems());
    }

    private  ArrayList<CustomItem> createItems(){
        ArrayList<CustomItem> list = new ArrayList<>();
        for(int i = 0; i< 20; i++){
            list.add(new CustomItem("item Index = " + i));
        }
        return list;
    }
}
