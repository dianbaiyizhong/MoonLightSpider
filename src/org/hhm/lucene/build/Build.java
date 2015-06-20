package org.hhm.lucene.build;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import net.sf.json.JSONObject;

import org.hhm.common.pojo.Content;

public class Build {
	public static void main(String[] args) {

		File file = new File("F:\\SpiderMoonLight\\新浪门户");

		File[] list = file.listFiles();

		for (int i = 0; i < list.length; i++) {
			File file1 = new File(list[i].getAbsolutePath());
			JSONObject jsonObject = JSONObject.fromObject(ReadFromTxt(file1));
			Content content = (Content) JSONObject.toBean(jsonObject,
					Content.class);
			System.out.println(content);
		}
	}

	public static String ReadFromTxt(File file) {
		try {
			Scanner in = new Scanner(file);
			String str = "";
			while (in.hasNextLine()) {
				str = str + in.nextLine();
			}

			return str;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
