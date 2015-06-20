package org.hhm.crawler.util.xml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Element;
import org.hhm.crawler.pojo.Config;
import org.hhm.crawler.pojo.DBConfig;
import org.hhm.crawler.pojo.Seeds;

public class XmlBean {

	public List<Seeds> getSeeds(Element root) {
		List<Seeds> list = new ArrayList<Seeds>();

		for (Iterator it = root.elementIterator(); it.hasNext();) {
			Element e = (Element) it.next();
			Seeds seeds = new Seeds();
			seeds.setId(e.attributeValue("id"));
			seeds.setSeedName(e.attributeValue("name"));
			for (Iterator it1 = e.elementIterator(); it1.hasNext();) {
				// e1包含了seed节点中的所有field

				Element e1 = (Element) it1.next();

				String name = e1.attributeValue("name");

				if (name.equals("url")) {
					seeds.setUrl(e1.getText().trim());
				} else if (name.equals("title")) {
					seeds.setTitle(e1);
				} else if (name.equals("text")) {
					seeds.setText(e1);
				} else if (name.equals("time")) {
					seeds.setTime(e1);
				} else if (name.equals("author")) {
					seeds.setAuthor(e1);
				} else if (name.equals("depth")) {
					seeds.setPoint_depth(Integer.parseInt(e1.getText().trim()));
				} else if (name.equals("filterSuffix")) {
					seeds.setFilterSuffix(e1.getText().trim());
				} else if (name.equals("directDomain")) {
					seeds.setDirectDomain(e1.getText().trim());
				} else if (name.equals("point_depth")) {
					seeds.setPoint_depth(Integer.parseInt(e1.getText()));
				}

			}

			list.add(seeds);

		}
		return list;

	}

	public Config getConfig(Element root) {
		Config config = new Config();

		config.setThreads(Integer.parseInt(root.elementText("threads")));
		config.setIsApplyTemplate(Integer.parseInt(root
				.elementText("isApplyTemplate")));
		config.setIsLucene(Integer.parseInt(root.elementText("isLucene")));
		config.setMonitorTime(Integer.parseInt(root.elementText("monitorTime")));
		config.setTaskID(Integer.parseInt(root.elementText("taskID")));
		config.setThreadGatherMax(Integer.parseInt(root
				.elementText("threadGatherMax")));

		config.setIndexPath(root.elementText("indexPath"));
		return config;
	}

	public DBConfig getDBConfig(Element root) {
		DBConfig dBConfig = new DBConfig();
		dBConfig.setDataBaseName(root.elementText("DataBaseName"));
		dBConfig.setiP(root.elementText("ServerIP"));
		dBConfig.setUserName(root.elementText("ServerUserName"));
		dBConfig.setPassword(root.elementText("ServerPassword"));
		return dBConfig;
	}

}
