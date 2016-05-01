package com.lucence.test;

import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

public class RAMDirectoryTest {
private static Directory directory;
static{
	directory = new RAMDirectory();
}
	
public static void main(String[] args) throws IOException, ParseException {
	RAMDirectoryTest ramDirectory = new RAMDirectoryTest();
	
	// 在内存中创建索引
	ramDirectory.createIndex(directory);
	
	// 读取索引
	ramDirectory.searchIndex(directory);
}

public void createIndex(Directory directory){
	try {
		
		// 1. 指定索引存放地
//	    Directory directory = new RAMDirectory();
	    
	    // 2. 创建索引分析器
	    Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_45);
	    
	    // To store an index on disk, use this instead:
	    //Directory directory = FSDirectory.open("/tmp/testindex");
	    
	    // 3. 创建写索引配置类
	    IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_45, analyzer);
	    
	    // 4. 创建写索引类
	    IndexWriter iwriter = new IndexWriter(directory, config);
		
	    // 5. 创建索引文档
	    Document doc = new Document();
	    
	    // 6. 创建索引文档字段
	    Field field = new Field("fieldname", "This is a index.", TextField.TYPE_STORED);
	    
	    // 7. 添加索引
	    doc.add(field);
	    
	    // 8. 将索引文档写到指定地址
	    iwriter.addDocument(doc);
	    
	    // 9. 关闭写索引类
	    iwriter.close();
	    
//	    directory.close();
	    
	} catch (IOException e) {
		e.printStackTrace();
	}
    
}

public void searchIndex(Directory directory){
	try {
		
		// DirectoryReader ireader = DirectoryReader.open(directory);
	    // 1. 指定读索引目的地
//		Directory directory = new RAMDirectory();
	    IndexReader ireader = DirectoryReader.open(directory);
	    
	    // 2. 创建查询类索引
	    IndexSearcher isearcher = new IndexSearcher(ireader);
	    
	    // 3. 创建索引分析器
	    Analyzer analyzer2 = new StandardAnalyzer(Version.LUCENE_45);
	    
	    // 4. 根据索引分析器和要查询的field创建查询解析类
	    QueryParser parser = new QueryParser(Version.LUCENE_45, "fieldname", analyzer2);
	    
	    // 5. 通过查询分析器和查询关键词，返回查询对象
	    Query query = parser.parse("index");
	    
	    
	    // 6. 索引查询类根据查询对象，返回查询打的文档集合
	    TopDocs tooResults = isearcher.search(query, null, 1000);
	    
	    // 7. 获取查询到的文档的得分权值考前的文档
	    ScoreDoc[] hits = tooResults.scoreDocs;
	    
	    // assertEquals(1, hits.length);
	    for (int i = 0; i < hits.length; i++) {
	    	
	    	// 8. 获得文档id
	    	int docId = hits[i].doc;
	    	
	    	// 9. 索引查询类，根据文档id查询文档
	    	Document hitDoc = isearcher.doc(docId);
	    	
	    	// 10. 从文档中获取指定feild名字的值
	    	String fieldname = hitDoc.get("fieldname");
	    	
	    	System.out.println(fieldname);
	    }
	    
	    ireader.close();
//	    directory.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}

}
