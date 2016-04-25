package com.lucence.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class Mysearch {
	public static void main(String[] args) throws IOException, ParseException {
		
		// 
		IndexReader indexReader = DirectoryReader.open(FSDirectory.open(new File("E:\\test\\lucenceindex")));
		
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);
		
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_45);
		
		QueryParser parser = new QueryParser(Version.LUCENE_45, "contents", analyzer);
		
		Query query = parser.parse("demo");
		
		doPagingSearch(indexSearcher, query, 20);
	}
	
	public static void doPagingSearch(IndexSearcher indexSearcher, Query query, int hitsPerPage) throws IOException {
		
		TopDocs results = indexSearcher.search(query, 5 * hitsPerPage);
	    ScoreDoc[] hits = results.scoreDocs;
	    
	    int numTotalHits = results.totalHits;
	    System.out.println(numTotalHits + " total matching documents");
	    
	    for (int i = 0; i < hits.length; i++) {
	    	 Document doc = indexSearcher.doc(hits[i].doc);
	         String path = doc.get("path");
	    	 System.out.println((i+1) + ". "  + "doc="+hits[i].doc+" score="+hits[i].score +"---path: "+ path);
	    }
	}
}
