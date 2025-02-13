//package com.example.android_photonsapp;
//
//import android.content.pm.PackageManager;
//import android.graphics.SurfaceTexture;
//import android.hardware.camera2.CameraAccessException;
//import android.hardware.camera2.CameraCaptureSession;
//import android.hardware.camera2.CameraCharacteristics;
//import android.hardware.camera2.CameraDevice;
//import android.hardware.camera2.CameraManager;
//import android.hardware.camera2.CaptureRequest;
//import android.hardware.camera2.params.StreamConfigurationMap;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.HandlerThread;
//import android.os.PersistableBundle;
//import android.util.Size;
//import android.Manifest;
//import android.view.Surface;
//import android.view.TextureView;
//
//import androidx.activity.EdgeToEdge;
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import java.util.Collections;
//
//public class CameraActivity extends AppCompatActivity {
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//    }
//
//    CameraManager cameraManager;
//    Size size;
//    String cameraId;
//    private Object CameraMetadata;
//    Handler backGroundHandler;
//    HandlerThread handlerThread;
//    CameraDevice cameraDevice;
//
//
//    private final static int CAMERA_REQUEST_CODE = 334568684;
//
//    CameraDevice.StateCallback stateCallback = new CameraDevice.StateCallback() {
//        @Override
//        public void onOpened(@NonNull CameraDevice camera) {
//            cameraDevice = camera;
//            createCaptureSession();
//        }
//
//        @Override
//        public void onDisconnected(@NonNull CameraDevice camera) {
//
//        }
//
//        @Override
//        public void onError(@NonNull CameraDevice camera, int error) {
//
//        }
//    };
//    TextureView textureView = findViewById(R.id.camera_textureView);
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
//            @Override
//            public void onSurfaceTextureAvailable(@NonNull SurfaceTexture surface, int width, int height) {
//                openBackgroundHandler();
//                setupCamera();
//                openCamera();
//            }
//
//            @Override
//            public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surface, int width, int height) {
//
//            }
//
//            @Override
//            public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surface) {
//                return false;
//            }
//
//            @Override
//            public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surface) {
//
//            }
//        });
//
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        closeBackgroundHandler();
//    }
//
//    private void openCamera() {
//        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_DENIED) {
//            requestPermissions(new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST_CODE);
//
//        } else {
//            try {
//                cameraManager.openCamera(cameraId, stateCallback, backGroundHandler);
//            } catch (CameraAccessException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    private void openBackgroundHandler() {
//        HandlerThread handlerThread = new HandlerThread("camera_app");
//        handlerThread.start();
//        backGroundHandler = new Handler(handlerThread.getLooper());
//    }
//
//    private void closeBackgroundHandler() {
//        handlerThread.quit();
//        handlerThread = null;
//        backGroundHandler = null;
//    }
//
//    private void setupCamera() {
//        cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
//        try {
//            String[] cameraIds = cameraManager.getCameraIdList();
//
//            for (String cameraId : cameraIds) {
//                CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(cameraId);
//
//                if (cameraCharacteristics.get(CameraCharacteristics.LENS_FACING) == android.hardware.camera2.CameraMetadata.LENS_FACING_FRONT) {
//                    this.cameraId = cameraId;
//                    StreamConfigurationMap streamConfigurationMap = cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
//                    size = streamConfigurationMap.getOutputSizes(SurfaceTexture.class)[0];
//                }
//
//
//            }
//        } catch (CameraAccessException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private void createCaptureSession() {
//        SurfaceTexture surfaceTexture = textureView.getSurfaceTexture();
//        surfaceTexture.setDefaultBufferSize(size.getWidth(), size.getHeight());
//        Surface surface = new Surface(surfaceTexture);
//
//        try {
//            cameraDevice.createCaptureSession(Collections.singletonList(surface), new CameraCaptureSession.StateCallback() {
//                @Override
//                public void onConfigured(@NonNull CameraCaptureSession session) {
//                    try {
//                        CaptureRequest.Builder captureRequestBuilder = cameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW);
//                        session.setRepeatingRequest(captureRequestBuilder.build(), null,backGroundHandler);
//                    } catch (CameraAccessException e) {
//                        throw new RuntimeException(e);
//                    }
//
//                }
//
//                @Override
//                public void onConfigureFailed(@NonNull CameraCaptureSession session) {
//
//                }
//            }, backGroundHandler);
//        } catch (CameraAccessException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}