package com.nix.homework.builder;

import com.nix.homework.util.BundleUtil;

import java.util.Map;

public interface AbstractBuilder {
	default Map<String, String> getKeyValueMapByBundleProperties(String lang) {
		return BundleUtil.getBundleProperties(lang);
	}

	void buildDataList();
}
