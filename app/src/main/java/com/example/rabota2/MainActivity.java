package com.example.rabota2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {

        ArrayList<State> states = new ArrayList<>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_main);

            setInitialData();
            RecyclerView recyclerView = findViewById(R.id.list);

            StateAdapter adapter = new StateAdapter(this, states);
            recyclerView.setAdapter(adapter);

        }

        private void setInitialData(){
            states.add(new State("Белый флаг","сдаююсьь", R.drawable.withflag));
            states.add(new State("Германия","Берлин", R.drawable.germany));
            states.add(new State("Россия","матушка русь", R.drawable.russia));

        }
    }