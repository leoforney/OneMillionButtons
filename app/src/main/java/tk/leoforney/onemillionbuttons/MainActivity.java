package tk.leoforney.onemillionbuttons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    List<Integer> numbers;
    int size = 100000;
    final static String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        GridLayoutManager glm = new GridLayoutManager(this, 3);
        glm.setOrientation(GridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(glm);

        numbers = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            int buttonnum = i + 1;
            numbers.add(buttonnum);
        }

        RVAdapter adapter = new RVAdapter(numbers);
        recyclerView.setAdapter(adapter);

    }
}
