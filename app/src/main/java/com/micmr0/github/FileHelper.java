package com.micmr0.github;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.webkit.MimeTypeMap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileHelper {
	public static String readFromFile(File pFile) {
		String output = "";
		try {
			FileInputStream inputStream = new FileInputStream(pFile);
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			StringBuilder input = new StringBuilder(inputStream.available());
			for (String line; (line = reader.readLine()) != null; ) {
				input.append(line);
			}
			inputStream.close();
			output = input.toString();
		} catch (Exception ignored) {}

		return output;
	}

	public static String getPathForDownloadedMediaFile(int fileId, FileTypeEnum type, String dirName, String subDirName) {
		String mediaDirPath;
		File mediaStorageDir;
		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			if (subDirName != null) {
				mediaDirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + dirName;
				mediaStorageDir = new File(mediaDirPath, subDirName);
			} else {
				mediaDirPath = Environment.getExternalStorageDirectory().getAbsolutePath();
				mediaStorageDir = new File(mediaDirPath, dirName);
			}
			if (!mediaStorageDir.exists()) {
				if (!mediaStorageDir.mkdirs()) {
					return null;
				}
			}
		} else {
			mediaStorageDir = GApplication.getInstance().getFilesDir();
		}

		String ext;
		if (type.equals(FileTypeEnum.IMAGE)) {
			ext = ".jpg"; //NON-NLS
		} else {
			ext = ".mp4"; //NON-NLS
		}
		String pre = "";
		return mediaStorageDir.getPath() + File.separator + pre + fileId + ext;
	}

	public static String getMimeType(Context pContext, Uri uri) {
		String mimeType;
		if (uri.getScheme().equals(ContentResolver.SCHEME_CONTENT)) {
			ContentResolver cr = pContext.getContentResolver();
			mimeType = cr.getType(uri);
		} else {
			String fileExtension = MimeTypeMap.getFileExtensionFromUrl(uri.toString());
			mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtension.toLowerCase());
		}
		return mimeType;
	}

	public enum FileTypeEnum {
		IMAGE, AUDIO_VIDEO
	}
}
