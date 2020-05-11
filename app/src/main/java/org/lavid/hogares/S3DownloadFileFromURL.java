package org.lavid.hogares;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.amplifyframework.core.Amplify;
import java.io.File;

public class S3DownloadFileFromURL extends AsyncTask<String, String, String> {

    private Context mContext;

    public S3DownloadFileFromURL(Context context){
        mContext = context;
    }

    @Override
    protected String doInBackground(String... f_url) {
        int count; String name; String destinyPath;
        byte data[] = new byte[1024];

        try {
            for (int i = 1; i < 100; i++) {
                name = "MDLB_" + i + ".html";
                destinyPath = mContext.getExternalFilesDir(null).toString() + "/" + name;
                File file = new File(destinyPath);

                if(!file.exists()) {
                    Amplify.Storage.downloadFile("Android/" + name, mContext.getExternalFilesDir(null).toString() + "/" + name,
                            result -> Log.i("StorageQuickStart", "Successfully downloaded: " + result.getFile().getName()),
                            storageFailure -> Log.e("StorageQuickStart", storageFailure.getMessage(), storageFailure)
                    );
                }

            }
        } catch (Exception e) {
            Log.e("Error: ", e.getMessage());
        }

        return null;
    }
}
