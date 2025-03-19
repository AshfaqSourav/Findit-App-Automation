package utils;

import io.qameta.allure.Allure;
import org.testng.ITestResult;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenRecordingUtils {


    public static void saveRecordingToFile(ITestResult result) {
        try {
            // ✅ Define correct internal storage path
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            String deviceVideoPath = "/storage/emulated/0/test_video.mp4";
            String testRecordingsDir = "test-recordings";
            String localVideoPath = testRecordingsDir + "/" + result.getMethod().getMethodName() + "_" + timestamp + ".mp4";

            // ✅ Ensure `test-recordings/` exists & is writable
            File videoDir = new File(testRecordingsDir);
            if (!videoDir.exists()) {
                boolean dirCreated = videoDir.mkdirs();
                if (!dirCreated) {
                    System.out.println("❌ Failed to create test-recordings directory.");
                    return;
                }
            }

            if (!videoDir.canWrite()) {
                System.out.println("❌ No write permissions for test-recordings directory.");
                return;
            }

            // ✅ Pull video from internal storage
            String pullCommand = "adb pull " + deviceVideoPath + " " + localVideoPath;
            System.out.println("📂 Pulling video from device: " + pullCommand);

            Process process = Runtime.getRuntime().exec(pullCommand);
            process.waitFor(); // Wait for the process to complete

            // ✅ Check if file exists & attach to Allure
            File localFile = new File(localVideoPath);
            if (localFile.exists()) {
                System.out.println("✅ Video successfully pulled: " + localVideoPath);
                ScreenRecordingUtils.attachVideoToAllure(localVideoPath, result.getMethod().getMethodName());
            } else {
                System.out.println("❌ Failed to pull video. Check ADB connection or file path.");
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("❌ Error saving screen recording: " + e.getMessage());
        }
    }

    public static void attachVideoToAllure(String videoPath, String testName) {
        try {
            File videoFile = new File(videoPath);
            if (videoFile.exists()) {
                String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
                InputStream videoStream = Files.newInputStream(Paths.get(videoPath));
                Allure.addAttachment("Video Recording - " + testName +"_"+ timestamp, "video/mp4", videoStream, "mp4");
                System.out.println("📎 Video attached to Allure report.");
            } else {
                System.out.println("⚠️ Video file not found: " + videoPath);
            }
        } catch (FileNotFoundException e) {
            System.out.println("❌ Failed to attach video to Allure.");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}