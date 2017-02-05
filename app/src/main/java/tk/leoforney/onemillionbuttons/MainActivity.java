package tk.leoforney.onemillionbuttons;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.futuremind.recyclerviewfastscroll.FastScroller;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FastScroller fastScroller;

    List<Integer> numbers;
    int size = 1000000;
    final static String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        fastScroller = (FastScroller) findViewById(R.id.fastscroll);

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

        fastScroller.setRecyclerView(recyclerView);

    }
}
