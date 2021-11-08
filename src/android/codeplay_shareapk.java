package cordova.plugin.codeplay.share.own.apk;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;

/**
 * This class echoes a string called from JavaScript.
 */
public class codeplay_shareapk extends CordovaPlugin {

    public String defaultShareTitle="Share app via";
    CallbackContext _callbackContex;
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        _callbackContex=callbackContext;
        if (action.equals("openShare")) {

            String title = args.getString(0);
            String apkName = args.getString(1);

            String str;
            if(title!="" && title!="null")
            {
                str=title;
            }
            else
            {
                str=defaultShareTitle;
            }

            shareApplication(str,apkName);


            //this.coolMethod(message, callbackContext);
            return true;
        }


        if (action.equals("openShareFile")) {

            String title = args.getString(0);
            String apkName = args.getString(1);
            String filePath = args.getString(2);

            String str;
            if(title!="" && title!="null")
            {
                str=title;
            }
            else
            {
                str=defaultShareTitle;
            }

            if(filePath=="" || filePath=="null")
            {
                callbackContext.error("Please pass filePath value");
                return  false;
            }


            shareAnyFile(str,apkName,filePath);


            //this.coolMethod(message, callbackContext);
            return true;
        }


        if (action.equals("copyFile")) {

            String sourceFilePath = args.getString(0);
            String distinationFilePath = args.getString(1);
            String title = args.getString(2);

            //String apkName = args.getString(1);


            //String filePath = args.getString(2);

            String str;
            if(title!="" && title!="null")
            {
                str=title;
            }
            else
            {
                str=defaultShareTitle;
            }

            if(distinationFilePath=="" || distinationFilePath=="null")
            {
                callbackContext.error("Please pass distinationFilePath value");
                return  false;
            }

            if(sourceFilePath=="" || sourceFilePath=="null")
            {
                callbackContext.error("Please pass sourceFilePath value");
                return  false;
            }

            try {
                //distinationFilePath
                copyFile(sourceFilePath,distinationFilePath,title);

            } catch (IOException e) {
                e.printStackTrace();
            }
            //shareAnyFile(str,apkName,filePath);


            //this.coolMethod(message, callbackContext);
            return true;
        }

        if (action.equals("isSupport")) {

            Context testParameter = (cordova.getActivity()).getBaseContext();


            if (testParameter.getExternalCacheDir() != null) {
                callbackContext.success("true");
            }
            else
            {
                callbackContext.success("false");
            }

            //this.coolMethod(message, callbackContext);
            return true;
        }

        return false;
    }





    public void shareApplication(String title,String apkName) {

        Context testParameter = (cordova.getActivity()).getBaseContext();
        ApplicationInfo app = testParameter.getApplicationContext().getApplicationInfo();

        String filePath = app.sourceDir;




        Intent intent = new Intent(Intent.ACTION_SEND);

        // MIME of .apk is "application/vnd.android.package-archive".
        // but Bluetooth does not accept this. Let's use "*/*" instead.
        intent.setType("*/*");

        // Append file and send Intent
        File originalApk = new File(filePath);

        try {
            //Make new directory in new location
            //File tempFile = new File(testParameter.getCacheDir() + "/ExtractedApk");
            //If directory doesn't exists create new





            //File tempFile = new File(testParameter.getCacheDir().getAbsolutePath() + "/ExtractedApk");

            //File tempFile = new File(testParameter.getExternalCacheDir() + "/ExtractedApk");
            //File tempFile = new File(testParameter.getApplicationInfo().dataDir + "/ExtractedApk");


            ///File tempFile = new File(testParameter.getCacheDir() + "/ExtractedApk");


            File tempFile=new File("");
            String cachePath; // you still need a default value if not mounted


            if (testParameter.getExternalCacheDir() != null) {
                tempFile = new File(testParameter.getExternalCacheDir().getPath() + "/ExtractedApk"); // most likely your null value
            }
            else if (testParameter.getCacheDir() != null) {
                tempFile = new File(testParameter.getCacheDir().getPath() + "/ExtractedApk");
            }



            if (!tempFile.isDirectory())
                if (!tempFile.mkdirs())
                    return;

            //Get application's name and convert to lowercase
            String tempAppname="";
            if(apkName=="" || apkName=="null")
            {
                tempAppname=testParameter.getString(app.labelRes).replace(" ","").toLowerCase();
            }
            else
            {
                tempAppname=apkName;
            }

            tempFile = new File(tempFile.getPath() + "/" + tempAppname + ".apk");
            //If file doesn't exists create new
            if (!tempFile.exists()) {
                if (!tempFile.createNewFile()) {
                    return;
                }
            }
            //Copy file to new location
            InputStream in = new FileInputStream(originalApk);
            OutputStream out = new FileOutputStream(tempFile);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();

            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());


            System.out.println("File copied.");
            //Open share dialog
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(tempFile));


            testParameter.startActivity(Intent.createChooser(intent, title).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }



    public void shareAnyFile(String title,String shareFileName,String filePath) {

        Context testParameter = (cordova.getActivity()).getBaseContext();
        ApplicationInfo app = testParameter.getApplicationContext().getApplicationInfo();

        //String filePath = app.sourceDir;




        Intent intent = new Intent(Intent.ACTION_SEND);

        // MIME of .apk is "application/vnd.android.package-archive".
        // but Bluetooth does not accept this. Let's use "*/*" instead.
        intent.setType("*/*");

        // Append file and send Intent
        //File originalApk = new File(filePath);
        File originalApk = new File(filePath);
        //Environment.getExternalStorageDirectory();
        try {


            File tempFile=new File("");
            String cachePath; // you still need a default value if not mounted


            if (testParameter.getExternalCacheDir() != null) {
                tempFile = new File(testParameter.getExternalCacheDir().getPath() + "/ExtractedApk"); // most likely your null value
            }
            else if (testParameter.getCacheDir() != null) {
                tempFile = new File(testParameter.getCacheDir().getPath() + "/ExtractedApk");
            }



            if (!tempFile.isDirectory())
                if (!tempFile.mkdirs())
                    return;



            tempFile = new File(tempFile.getPath() + "/" + shareFileName);
            //If file doesn't exists create new
            if (!tempFile.exists()) {
                if (!tempFile.createNewFile()) {
                    return;
                }
            }
            //Copy file to new location
            InputStream in = new FileInputStream(originalApk);
            OutputStream out = new FileOutputStream(tempFile);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();

            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());


            System.out.println("File copied.");
            //Open share dialog
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(tempFile));


            testParameter.startActivity(Intent.createChooser(intent, title).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

        }
        catch (IOException e)
        {
            _callbackContex.error("File not found");
            e.printStackTrace();
        }
    }



    private void copyFile (String filePath,String distinationFilePath,String shareFileName) throws IOException{
        Context testParameter = (cordova.getActivity()).getBaseContext();
        ApplicationInfo app = testParameter.getApplicationContext().getApplicationInfo();

        File originalApk = new File(filePath);
        try
        {

            File tempFile=new File("");
            String cachePath; // you still need a default value if not mounted


            if (testParameter.getExternalCacheDir() != null) {
                tempFile = new File(distinationFilePath);

            }
            else if (testParameter.getCacheDir() != null) {
                tempFile = new File(distinationFilePath);
            }



            if (!tempFile.isDirectory())
                if (!tempFile.mkdirs())
                    return;



            tempFile = new File(tempFile.getPath() + "/" + shareFileName);
            //If file doesn't exists create new
            if (!tempFile.exists()) {
                if (!tempFile.createNewFile()) {
                    return;
                }
            }
            //Copy file to new location
            InputStream in = new FileInputStream(originalApk);
            OutputStream out = new FileOutputStream(tempFile);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();

            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());

            _callbackContex.success("Success");
        }
        catch (IOException e)
        {
            _callbackContex.error("File not found");
            e.printStackTrace();
        }
    }



}