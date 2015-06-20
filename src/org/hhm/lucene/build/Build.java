package org.hhm.lucene.build;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import net.sf.json.JSONObject;

import org.hhm.common.pojo.Config;
import org.hhm.common.pojo.Content;
import org.hhm.common.util.xml.XmlBean;

public class Build {

	static XmlBean xmlBean = new XmlBean();
	static Config config = new Config();

	public void Start() {
		File file = new File(config.getIndexPath());
		File[] list = file.listFiles();
		for (int i = 0; i < list.length; i++) {

			File file1 = new File(list[i].getAbsolutePath());
			if (getExtName(file1.getName().toString(), '.').equals(".txt")) {
				JSONObject jsonObject = JSONObject
						.fromObject(ReadFromTxt(file1));
				Content content = (Content) JSONObject.toBean(jsonObject,
						Content.class);
				System.out.println(content);
			}

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

	public static String getExtName(String s, char split) {
		int i = s.indexOf(split);
		int leg = s.length();
		return (i > 0 ? (i + 1) == leg ? " " : s.substring(i, s.length()) : " ");
	}
}
