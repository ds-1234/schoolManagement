package com.project.school.management.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Utils {
	
	@Value("${file.upload-dir}")
    private String uploadDir;
	
	private static final Logger log = LoggerFactory.getLogger(Utils.class);
	
	// Regular expression for a valid phone number (supports international format with +, -, spaces)
    private static final String PHONE_NUMBER_REGEX = "^\\+?[0-9. ()-]{7,15}$";

    // Compile the pattern for reuse
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile(PHONE_NUMBER_REGEX);
    
    // Regular expression for a valid email address
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    // Compile the pattern for reuse
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
	
	public String generateUniqueId(String string) {
		log.info("++++inside generate holiday method+++");
		String name = string.substring(0, 3).toUpperCase();
		String ranNum = generateRandomNumber();
		String dayId = name + ranNum;
		return dayId;
	}
	
	private String generateRandomNumber() {
		log.info("++++inside generate random method+++");
		Random random = new Random();
		int num = random.nextInt(100, 999); 
		String strNum = String.valueOf(num);
		return strNum;
	}
	
	public void copyNonNullProperties(Object src, Object target) {
		log.info("******  call copyProperties method and pass another getNullPropertyNames function as param******");
	    BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
	}
	
	public static String[] getNullPropertyNames (Object source) {
	    final BeanWrapper src = new BeanWrapperImpl(source);
	    java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

	    Set<String> emptyNames = new HashSet<String>();
	    for(java.beans.PropertyDescriptor pd : pds) {
	        Object srcValue = src.getPropertyValue(pd.getName());
	        if (srcValue == null) emptyNames.add(pd.getName());
	    }
	    String[] result = new String[emptyNames.size()];
	    return emptyNames.toArray(result);
	}
	
	public String generateRandomId() {
		log.info("++++inside generate random method+++");
		Random random = new Random();
		int num = random.nextInt(1000, 9999); 
		String strNum = String.valueOf(num);
		return strNum;
	}
	
	public String capitalizeFirstCharacter(String string) {
		log.info("++++inside capitalizeFirstCharacter method+++");
		String afterCapitalize = string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
		return afterCapitalize;
	}
	
	public String upperCase(String string) {
		log.info("++++inside upperCase method+++");
		String afterupperCase = string.toUpperCase();
		return afterupperCase;
	}
	
	public boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return false;  // Null or empty phone numbers are invalid
        }
        return PHONE_NUMBER_PATTERN.matcher(phoneNumber).matches();
    }
    
    public boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;  // Null or empty emails are invalid
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }
    
    public String uploadFile(MultipartFile file) throws IOException{
    	Path uploadDirPath = Paths.get(uploadDir);
        Files.createDirectories(uploadDirPath); // Ensure the directory exists

        // Save the file locally
        String fileName = file.getOriginalFilename();
        Path filePath = uploadDirPath.resolve(fileName);  // Create full file path
        Files.write(filePath, file.getBytes());

        return "fileName: "+fileName + "filePath: "+ filePath;
    }

}
