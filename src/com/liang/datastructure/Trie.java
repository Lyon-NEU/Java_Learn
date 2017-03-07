package com.liang.datastructure;

/**
 * Created by Liang on 2016/10/15.
 */
public class Trie {
    private int SIZE=26;
    private TrieNode root; //root of tree

    Trie(){
        root=new TrieNode();
    }
    private class TrieNode{
        private int num;
        private TrieNode[] son;
        private boolean isEnd;
        private char val;

        TrieNode(){
            num=1;
            son=new TrieNode[SIZE];
            isEnd=false;
        }
    }

    // build dictionary tree
    public void insert(String str){
        if(str==null||str.length()==0){
            return;
        }
        TrieNode node=root;
        char[]letters=str.toCharArray();
        for(int i=0;i<str.length();i++){
            int pos=letters[i]-'a';
            if(node.son[pos]==null){
                node.son[pos]=new TrieNode();
                node.son[pos].val=letters[i];
            }
            else{
                node.son[pos].num++;
            }
            node=node.son[pos];
        }
        node.isEnd=true;
    }
    public boolean has(String str){
        if(str==null||str.length()==0){
            return false;
        }
        TrieNode node=root;
        char [] letters=str.toCharArray();
        for(int i=0;i<str.length();i++){
            int pos=letters[i]-'a';
            if(node.son[pos]!=null){
                node=node.son[pos];
            }
            else{
                return false;
            }
        }
        return node.isEnd;
    }
}
