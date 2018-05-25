package com.example.trisys.dogether;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

public class CameraActivity extends AppCompatActivity {

  private ImageView imgPreview;
  private VideoView videoPreview;
  private Button btnCapturePicture, btnRecordVideo;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_camera);
  imgPreview = (ImageView) findViewById(R.id.imgPreview);
  videoPreview = (VideoView) findViewById(R.id.videoPreview);
  btnCapturePicture = (Button) findViewById(R.id.btnCapturePicture);
  btnRecordVideo = (Button) findViewById(R.id.btnRecordVideo);

  /**
   * Capture image button click event
   * */
        btnCapturePicture.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
      // capture picture
      captureImage();
    }
  });

  /**
   * Record video button click event
   */
        btnRecordVideo.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
      // record video
      recordVideo();
      
    }
  });
}

  private void recordVideo() {
    if(isDeviceSupportCamera()){

      Intent captureVideo=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);


    }else {

    }
  }

  private void captureImage() {
    if(isDeviceSupportCamera()){

     Intent captureImage= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

    }else {

    }


  }

  /**
   * Checking device has camera hardware or not
   * */
  private boolean isDeviceSupportCamera() {
    if (getApplicationContext().getPackageManager().hasSystemFeature(
        PackageManager.FEATURE_CAMERA)) {
      // this device has a camera
      return true;
    } else {
      // no camera on this device
      return false;
    }
  }
}
