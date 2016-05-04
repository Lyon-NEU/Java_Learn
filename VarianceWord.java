package algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 变位词
 * @author Lyon
 * @date 2016/05/04
 */
class WordPair{
	private String word;
	private String root;
	public WordPair(String w,String r){
		word=w;
		root=r;
	}
	public String getWord(){
		return word;
	}
	public String getRoot(){
		return root;
	}
}
public class VarianceWord {
	/*
	 * sort
	 */
	public static String rootWord(String word){
		String root="";
		char[]wc=word.toCharArray();
		Arrays.sort(wc);
		root=String.valueOf(wc);
		return root;
	}
	//对变位词排序 str.compartTo(s2)
	public static void SortList(){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<WordPair>wpList=new ArrayList<WordPair>();
		BufferedReader in=null;
		try{
			in=new BufferedReader(new FileReader(new File("")));
			String line="";
			while((line=in.readLine())!=null){
				String []words=line.split(" ");
				for(String word:words){
					String root=rootWord(word);
					WordPair wp=new WordPair(word,root);
					wpList.add(wp);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				in.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
