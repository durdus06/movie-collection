package durdu.projects.moviecollection.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	private static final String uploadDir = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\images";

	public static void uploadFile(MultipartFile file, String code) {

		// Create the directory If it doesn't exist.
		if (!new File(uploadDir).exists()) {
			new File(uploadDir).mkdirs();
		}

		String imageName = code + ".jpg";
		// project directory upload
		Path fileNameAndPath = Paths.get(uploadDir, imageName);
		try {
			Files.write(fileNameAndPath, file.getBytes());
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
