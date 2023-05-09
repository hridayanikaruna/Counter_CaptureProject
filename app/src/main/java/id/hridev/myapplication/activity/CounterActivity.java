package id.hridev.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import id.hridev.myapplication.R;
import id.hridev.myapplication.model.alatCounting;

public class CounterActivity extends AppCompatActivity {
    private TextView angka;
    private EditText text_judul_aktivitas;
    private Button btnKirim, btnMin, btnReset, btnPlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_counter);

        //variabel
        angka = findViewById(R.id.angka);
        text_judul_aktivitas = findViewById(R.id.judul_aktivitas);
        alatCounting Alatcounting = new alatCounting();
        btnKirim = findViewById(R.id.btnKirim);
        btnMin = findViewById(R.id.btnMin);
        btnReset = findViewById(R.id.btnReset);
        btnPlus = findViewById(R.id.btnPlus);

        //toast dari form
        Intent intent = getIntent();
        String namaMahasiswa = intent.getStringExtra("namaMahasiswa");
        Toast toast = Toast.makeText(getApplicationContext(), "Terimakasih! " + namaMahasiswa, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();

        btnKirim.setOnClickListener(view -> {
            String contentJudulAktivitas = text_judul_aktivitas.getText().toString();
            String contentCounter = angka.getText().toString();
            Intent intent1 = new Intent(CounterActivity.this, CaptureActivity.class);
            intent1.putExtra("contentJudulAktivitas", contentJudulAktivitas);
            intent1.putExtra("contentCounter", contentCounter);
            startActivity(intent1);
        });

        btnMin.setOnClickListener(view -> {
            Alatcounting.mengurangi();
            if (Alatcounting.getCounter() <= 0){
                angka.setText("0");
                Alatcounting.mereset();
            }else {
                angka.setText(Alatcounting.getCounter() + "");
            }
        });

        btnReset.setOnClickListener(view -> {
            Alatcounting.mereset();
            angka.setText(Alatcounting.getCounter() + "");
        });

        btnPlus.setOnClickListener(view -> {
            Alatcounting.menambah();
            angka.setText(Alatcounting.getCounter() + "");
        });
    }
}