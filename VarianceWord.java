package algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
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
	@Override
	public String toString(){
		return root+" "+word;
	}
}
public class VarianceWord {
	/**
	 * 对字符串的字符进行排序
	 * @param word
	 * @return
	 */
	public static String rootWord(String word){
		String root="";
		char[]wc=word.toCharArray();
		Arrays.sort(wc);  //基本数据类型的排序
		root=String.valueOf(wc);
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<WordPair>wpList=new ArrayList<WordPair>();
		BufferedReader in=null;
		try{
			in=new BufferedReader(new FileReader(new File("variance.txt")));
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
		//重新排序
		WordPair[]wp=(WordPair[]) wpList.toArray(new WordPair[wpList.size()]);//必须填写参数类型
		Arrays.sort(wp,new Comparator<WordPair>(){

			@Override
			public int compare(WordPair o1, WordPair o2) {
				// TODO Auto-generated method stub
				return o1.getRoot().compareTo(o2.getRoot());
			}
			
		});
		wpList=Arrays.asList(wp);
		//for(WordPair ws:wpList)
		//	System.out.println(ws);
		
		//合并重复项，生成变位词集
		LinkedHashMap<String,String>words=new LinkedHashMap<String ,String>();
		for(WordPair wd:wpList){
			if(words.get(wd.getRoot())!=null){
				String tmp=words.get(wd.getRoot());
				words.put(wd.getRoot(),tmp+","+wd.getWord());
			}
			else{
				words.put(wd.getRoot(),wd.getWord());
			}
		}
		//output
		//for(Entry<String, String> entry:words.entrySet()){
		//	System.out.println(entry.getKey()+" "+entry.getValue());
		//}
		for(String word:words.values())
			System.out.println(word);
	}

}

