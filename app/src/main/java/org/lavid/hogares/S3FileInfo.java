package org.lavid.hogares;

import android.content.Context;
import android.util.Log;

import com.amplifyframework.core.Amplify;
import com.amplifyframework.storage.StorageItem;

import java.util.ArrayList;

public class S3FileInfo {

    public static String[] listFiles() {

        ArrayList<String> list = new ArrayList<>();

        Amplify.Storage.list(
                "Android/",
                storageListResult -> {
                    for(StorageItem item : storageListResult.getItems()) {
                        list.add(item.getKey());
                    }
                },
                storageFailure -> Log.e("StorageQuickStart", storageFailure.getMessage(), storageFailure)
        );

        String[] array = new String[list.size()];
        array = list.toArray(array);

        return array;
    }
}
