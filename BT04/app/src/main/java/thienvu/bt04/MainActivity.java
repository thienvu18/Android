package thienvu.bt04;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    private ListView lvContacts;
    private TextView txUserChosen;
    private List<Model> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvContacts = findViewById(R.id.lvContacts);
        txUserChosen = findViewById(R.id.tvUserChosen);

        models = new ArrayList<>();
        models.add(new Model("Nguyễn Văn A", "0989897874", R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground));
        models.add(new Model("Lê Thị B", "0967995843", R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground));
        models.add(new Model("Trần Văn C", "0907955843", R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground));
        models.add(new Model("Phan Văn C", "0967885811", R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground));
        models.add(new Model("Đinh Văn D", "0988885231", R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground));

        lvContacts.setAdapter(new MyAdapter(this, models));
        lvContacts.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        txUserChosen.setText("You choose: " + models.get(position).getName());
    }
}
