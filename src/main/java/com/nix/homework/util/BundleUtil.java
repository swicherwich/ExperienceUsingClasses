package com.nix.homework.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class BundleUtil {
	private static final ResourceBundle RESOURCE_COURSES_EN = ResourceBundle.getBundle("books_en");
	private static final ResourceBundle RESOURCE_COURSES_RU = ResourceBundle.getBundle("books_ru");

	public static Map<String, String> getBundleProperties(String lang) {
		return convertResourceBundleToMap(getBundle(lang));
	}

	private static Map<String, String> convertResourceBundleToMap(ResourceBundle resource) {
		Map<String, String> map = new HashMap<>();
		Enumeration<String> keys = resource.getKeys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			map.put(key, resource.getString(key));
		}
		return map;
	}

	private static ResourceBundle getBundle(String lang) {
		if (lang.isBlank() || lang.equals("en")) {
			return RESOURCE_COURSES_EN;
		} else {
			return RESOURCE_COURSES_RU;
		}
	}
}
