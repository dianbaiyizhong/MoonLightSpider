package org.hhm.crawler.analyzer;

import org.hhm.crawler.pojo.Content;
import org.hhm.crawler.pojo.Seeds;
import org.hhm.crawler.store.Store;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Analyzer {

	Seeds seeds_plan;
	String sourceCode;

	static Store store = new Store();

	public Analyzer(Seeds seeds_plan, String sourceCode) {
		this.seeds_plan = seeds_plan;
		this.sourceCode = sourceCode;
	}

	public void start() {
		Content content = new Content();

		content.setUrl(seeds_plan.getUrl());
		content.setSeedName(seeds_plan.getSeedName());
		content.setMd5(seeds_plan.getMd5());
		Document doc = Jsoup.parse(sourceCode);

		if (seeds_plan.getTitle() != null) {

			content.setTitle(doc.title());

		}

		if (seeds_plan.getText() != null) {

			String lablename = seeds_plan.getText().attributeValue("lablename");

			String labelclass = seeds_plan.getText().attributeValue(
					"labelclass");
			String labelid = seeds_plan.getText().attributeValue("labelid");

			String text = "";
			if (labelclass != "") {
				text = doc.select(lablename + "[class=" + labelclass + "]")
						.text();
			} else if (labelid != "") {
				text = doc.select(lablename + "[id=" + labelid + "]").text();

			}

			if (labelclass == null && labelid == null) {
				text = doc.text();
			}

			content.setText(text);
		}

		System.out.println(content);

		if (content.getText().length() != 0) {

			store.Save(content);

		}

	}
}
