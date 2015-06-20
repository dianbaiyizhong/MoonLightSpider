package org.hhm.crawler.pojo;

public class Content {
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Content [title=" + title + ", text=" + text.trim() + ", url="
				+ url + "]";
	}

	private String title;
	private String text;
	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	private String md5;
	public String getSeedName() {
		return seedName;
	}

	public void setSeedName(String seedName) {
		this.seedName = seedName;
	}

	private String seedName;
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private String url;

}
