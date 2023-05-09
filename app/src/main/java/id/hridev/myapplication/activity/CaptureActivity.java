package id.hridev.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import id.hridev.myapplication.R;

public class CaptureActivity extends AppCompatActivity {
    TextView judulAktivitasTxt, counterTxt;
    ImageView imageView;
    Button btnCapture;
    private static final int requestcamera_code= 12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_capture);

        getSupportActionBar();

        //variabel
        judulAktivitasTxt = (TextView) findViewById(R.id.value_judul_aktivitas);
        counterTxt = (TextView) findViewById(R.id.value_counter);
        imageView = (ImageView) findViewById(R.id.image_view);
        btnCapture = (Button) findViewById(R.id.btnCapture);

        //menampilkan getIntent value dari MainCounterActivity
        Intent intent = getIntent();
        String judulAktivitasValue = intent.getStringExtra("contentJudulAktivitas");
        String counterValue = intent.getStringExtra("contentCounter");
        judulAktivitasTxt.setText(judulAktivitasValue);
        counterTxt.setText(counterValue);

        btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera,requestcamera_code);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==requestcamera_code){
            Bitmap imageBitmap=(Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }
}