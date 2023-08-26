package com.project.school.management.utility;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

@Component
public class Utils {
	
	private static final Logger log = LoggerFactory.getLogger(Utils.class);
	
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

}
