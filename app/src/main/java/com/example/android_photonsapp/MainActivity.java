package com.example.android_photonsapp;

import android.graphics.Camera;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    CameraManager cManager;
    Size size;
    String cameraId;
    private Object CameraMetadata;
    Handler backGroundHandler;
    HandlerThread handlerThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.main_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void openCamera() {
        if (Build.VERSION.SDK_INT >= 23) {
            if()
        }
    }

    private void openBackgroundHandler() {
        HandlerThread handlerThread = new HandlerThread("camera_app");
        handlerThread.start();
        backGroundHandler = new Handler(handlerThread.getLooper());
    }

    private void stopBackgroundHandler() {
        handlerThread.quit();
        handlerThread = null;
        backGroundHandler = null;
    }

    private void setupCamera() {
        cManager = (CameraManager) getSystemService(CAMERA_SERVICE);
        try {
            String[] cameraIds = cManager.getCameraIdList();

            for (String cameraId : cameraIds) {
                CameraCharacteristics cameraCharacteristics = cManager.getCameraCharacteristics(cameraId);

                if (cameraCharacteristics.get(CameraCharacteristics.LENS_FACING) == android.hardware.camera2.CameraMetadata.LENS_FACING_FRONT) {
                    this.cameraId = cameraId;
                    StreamConfigurationMap streamConfigurationMap = cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                    size = streamConfigurationMap.getOutputSizes(SurfaceTexture.class)[0];
                }


            }
        } catch (CameraAccessException e) {
            throw new RuntimeException(e);
        }
    }
}