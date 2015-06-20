package org.hhm.lucene.control;


import java.io.File;
import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class SearchIndexControl {

	public static void main(String[] args) throws IOException, ParseException {
		IKAnalyzer analyzer = new IKAnalyzer(true);
		String fieldName = "content";
		File file = new File("F:\\lucene");
		Directory directory = FSDirectory.open(file);

		IndexReader ireader = DirectoryReader.open(directory);

		IndexSearcher isearcher = new IndexSearcher(ireader);

		QueryParser qp = new QueryParser(Version.LUCENE_47, fieldName, analyzer);

		qp.setDefaultOperator(QueryParser.AND_OPERATOR);

		Query query = qp.parse("屌");
		System.out.println("Query = " + query);

		// 搜索相似度最高的5条记录
		TopDocs topDocs = isearcher.search(query, 5);
		System.out.println("命中：" + topDocs.totalHits);
		// 输出结果
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		for (int i = 0; i < topDocs.totalHits; i++) {
			Document targetDoc = isearcher.doc(scoreDocs[i].doc);
			System.out.println("内容：" + targetDoc.toString());
		}

	}

}
