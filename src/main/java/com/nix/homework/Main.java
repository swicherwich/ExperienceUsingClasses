package com.nix.homework;

import com.nix.homework.builder.DataBuilder;
import com.nix.homework.config.ApplicationEnvironment;

public class Main {
	public static void main(String[] args) {
		runDataBuilder(args);
	}

	private static  void runDataBuilder(String[] args) {
		DataBuilder dataBuilder = new DataBuilder();
		if (args.length != 0) {
			ApplicationEnvironment.setPropertyLang(args[0]);
		} else {
			ApplicationEnvironment.setPropertyLang("ru");
		}
		dataBuilder.buildDataList();
	}
}
