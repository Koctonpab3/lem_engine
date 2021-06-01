/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyser.simpleclasses;

import java.util.LinkedList;

/**
 *
 * @author Admin
 */
public class simplesentences {
    private LinkedList<String> sentences = new LinkedList<>();  
  private LinkedList <simplewords> words = new LinkedList<>();  
   
   
  public simplesentences MNtoSentences(int m,int n,String word){
     simplesentences ret = new simplesentences();
      for (int i=0;i<this.sentences.size();i++){
      LinkedList<String> tmpWrds = new LinkedList<>();
  this.copyLinkedList(this.wordsToList(this.getSentence(i)),tmpWrds);
     int flag=0,index=0;
     String tmpSent="";
     for (int j=0;j<tmpWrds.size();j++){
     if (this.equals(word, tmpWrds.get(j))){
         index=j;
         flag=1;}
     }
     if (flag==1){
         int start=0,stop=tmpWrds.size();
         if (index-m>0)start=index-m;
         if (index+n+1<stop)stop=index+n+1;
         for(int z=start;z<stop;z++){
         
           if(z!=index)  tmpSent=tmpSent+" "+tmpWrds.get(z);
         
         }       
       //  tmpSent=tmpSent+".";
         ret.addSentence(tmpSent);}
      }
      return ret;
  }
  
    public LinkedList<String> MNtoSentencesLL(int m,int n,String word){
     LinkedList<String> ret = new LinkedList<>();
      for (int i=0;i<this.sentences.size();i++){
      LinkedList<String> tmpWrds = new LinkedList<>();
  this.copyLinkedList(this.wordsToList(this.getSentence(i)),tmpWrds);
     int flag=0,index=0;
     String tmpSent="";
     for (int j=0;j<tmpWrds.size();j++){
     if (this.equals(word, tmpWrds.get(j))){
         index=j;
         flag=1;}
     }
     if (flag==1){
         int start=0,stop=tmpWrds.size();
         if (index-m>0)start=index-m;
         if (index+n+1<stop)stop=index+n+1;
         for(int z=start;z<stop;z++){
         
           if(z!=index)  tmpSent=tmpSent+" "+tmpWrds.get(z);
         
         }       
       //  tmpSent=tmpSent+".";
         ret.add(tmpSent);}
      }
      return ret;
  }
  
    public simplesentences getSentencesWithWord(String word){
      simplesentences ret = new simplesentences();
      for (int i=0;i<this.sentences.size();i++){
      LinkedList<String> tmpWrds = new LinkedList<>();
  this.copyLinkedList(this.wordsToList(this.getSentence(i)),tmpWrds);
     int flag=0;
     for (int j=0;j<tmpWrds.size();j++){
     if (this.equals(word, tmpWrds.get(j)))flag=1;
     }
     if (flag==1){ret.addSentence(this.getSentence(i));}
      }
      return ret;
  }
    public LinkedList<String> getSentencesWithWordLL(String word){
      LinkedList<String> ret = new LinkedList<>();
      for (int i=0;i<this.sentences.size();i++){
      LinkedList<String> tmpWrds = new LinkedList<>();
  this.copyLinkedList(this.wordsToList(this.getSentence(i)),tmpWrds);
     int flag=0;
     for (int j=0;j<tmpWrds.size();j++){
     if (this.equals(word, tmpWrds.get(j)))flag=1;
     }
     if (flag==1){ret.add(this.getSentence(i));}
      }
      return ret;
  }
  public LinkedList<String> getWordsOfSentence(int i){
   return this.words.get(i).getAllWords();
   }
  public LinkedList<String> getCalculateWordsOfText(int i){
  this.words.get(i).clearWords();
  this.words.get(i).addWords(this.wordsToList(this.getSentence(i)));
   return this.words.get(i).getAllWords();
  }
  public void calculateWordsOfText(int i){
  this.words.get(i).addWords(this.wordsToList(this.getSentence(i)));
  }
   public void setWordsOfSentence(LinkedList<String> in,int i){
      this.words.get(i).addWords(in);
     }
   public void addSentence(String in){
   this.sentences.add(in);
   simplewords twrd=new simplewords(); 
   twrd.addWords(this.wordsToList(in));
   this.words.add(twrd);
   }  
  public LinkedList<String> getAllSents(){
     LinkedList<String> ret =new LinkedList<>(); 
     this.copyLinkedList(this.sentences, ret);
   return ret;
   } 
  
   public void replaceSentence(String sent,int i){
      this.sentences.set(i, sent);
   simplewords twrd=new simplewords(); 
   twrd.addWords(this.wordsToList(sent));
   this.words.set(i, twrd);
      
     }  
    public void setSentences(LinkedList<String> in){
      this.copyLinkedList(in,  this.sentences); 
     this.words.clear();
   for(int i=0;i<in.size();i++){
   simplewords twrd=new simplewords(); 
   twrd.addWords(this.wordsToList(in.get(i)));
   this.words.add(twrd);
      }
     }  
  public LinkedList<String> sentsToList(String in){
     LinkedList<String> rtrn = new LinkedList<>();
     String wrd="";   
    // int i=0;
     for(int j=0;j< in.length();j++){    
            if ( in.charAt(j)!='.'
                    | in.charAt(j)!='!'
                     | in.charAt(j)!='?'
                     )
            {wrd=wrd+in.charAt(j);}
            if ( in.charAt(j)=='.'
                    | in.charAt(j)=='!'
                     | in.charAt(j)=='?'){
            if(!(wrd.isEmpty()|
                    wrd.equalsIgnoreCase("")|
                    wrd.equalsIgnoreCase(null)|
                    wrd.equalsIgnoreCase(" ")))
            {
             if(((wrd.substring(0, wrd.length()-1)).length()>2) | 
                     (j==in.length()-1))
                rtrn.add(wrd.substring(0, wrd.length()-1));
          //   i++;
              wrd="";
            }}}
     return rtrn;
     }
  public int getSize(){
     return sentences.size();
    } 
    public void clearSents(){
    this.sentences.clear();
    this.words.clear();
    }
  public String getSentence(int i){return this.sentences.get(i);}   
       
  public LinkedList<String> wordsToListFromAllSents(){
     LinkedList<String> rtrn = new LinkedList<>();
     LinkedList<String> buf = new LinkedList<>();
     int i=0;
     rtrn.clear();
     for(int j=0;j< sentences.size();j++){ 
       buf.clear();
        this.copyLinkedList(wordsToList(this.sentences.get(j)), buf);
     for(int i1=0;i1< buf.size();i1++)rtrn.add(buf.get(i1));
     }
     return rtrn;
     }
  public LinkedList<String> wordsToList(String in){
     LinkedList<String> rtrn = new LinkedList<>();
     String wrd="";   
     for(int j=0;j< in.length();j++){  
            if ( j!=(in.length()-1)
                   | in.charAt(j)!=' '  
                   | in.charAt(j)!='.'
                    | in.charAt(j)!='!'
                     | in.charAt(j)!='?'
                     )
            {wrd=wrd+in.charAt(j);}
            if ( j==(in.length()-1)
                    | in.charAt(j)==' '  
                   | in.charAt(j)=='.'
                    | in.charAt(j)=='!'
                     | in.charAt(j)=='?'
                    ){
            if(!(wrd.isEmpty()|
                    wrd.equalsIgnoreCase("")|
                    wrd.equalsIgnoreCase(null)|
                    wrd.equalsIgnoreCase(" ")))
            {
             if(((wrd.substring(0, wrd.length()-1)).length()>2)|
                     (j==in.length()-1)){
             
               rtrn.add(wrd.substring(0, wrd.length()).replaceAll(" ", ""));
             }
              wrd="";
            }}
     }
     return rtrn;
     }
     private boolean equals(String string1, String string2){
boolean ret=false;
    if (string1.length()==string2.length())
      if (string1.equalsIgnoreCase(string2)) ret=true;  
return ret;
}
     public String getNormalText(String in){
String ret="";
 char[] baseSymbols = {
            'a','A','b','B','c','C','d','D','e','E','f','F',
             'g','G','h','H','i','I','j','J','k','K','l','L',
              'm','M','n','N','o','O','p','P','q','Q','r','R',
               's','S','t','T','u','U','v','V','w','W','x','X',
                'y','Y','z','Z','а','А','б','Б','в','В','г',
                 'Г','д','Д','е','Е','ё','Ё','ж','Ж','з','З','и',
                  'И','й','Й','к','К','л','Л','м','М','н','Н','о',
                   'О','п','П','р','Р','с','С','т','Т','у','У','ф',
                   'Ф','х','Х','ц','Ц','ч','Ч','ш','Ш','щ','Щ','ь',
                   'Ь','ъ','Ъ','ы','Ы','э','Э','ю','Ю','я','Я','?','!',' ','.'};

 
 for (int i=0;i<in.length();i++){
 for (int j=0;j<baseSymbols.length;j++){

 if(in.charAt(i)==baseSymbols[j]){
 ret=ret+baseSymbols[j];
 }
 }
 }
return ret;
}    
    public void copyLinkedList(LinkedList in,LinkedList out){
out.clear();
    for (int i=0;i<in.size();i++)
        out.add(in.get(i));
}
    public LinkedList copyLinkedList(LinkedList in){
LinkedList out= new LinkedList();
    out.clear();
    for (int i=0;i<in.size();i++)
        out.add(in.get(i));
    return out;
}
}
