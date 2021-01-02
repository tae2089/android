package org.techtown.captureintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;


public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    File file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture();
            }
        });
    }

    public void takePicture() {
        //카메라 앱으로 간다.
        //찍은 사진을 돌려받는다. -> 파일 위치만 정보를 받아 이를 불러온다.
        if (file == null) {
            file = createFile();
        }
        Uri fileuri = FileProvider.getUriForFile(this,"org.techtown.captureintent.fileprovider",file);
        Intent intetn = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intetn.putExtra(MediaStore.EXTRA_OUTPUT,fileuri);
        if(intetn.resolveActivity(getPackageManager())!= null){
            startActivityForResult(intetn, 101);
        }
    }

    public File createFile() {
        //폰에서 찍으면 확장자가 jpg
        String filename = "capture.jpg";
        File storageDir = Environment.getExternalStorageDirectory();
        File outputFile = new File(storageDir,filename);
        return outputFile;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101 && resultCode == RESULT_OK){
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize= 6;
            Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath(),options);
            imageView.setImageBitmap(bitmap);
        }
    }
}