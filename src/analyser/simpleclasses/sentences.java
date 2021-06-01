/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyser.simpleclasses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import ru.narod.macrocosm.mcr.Ray;

/**
 *
 * @author alex_
 */
public class sentences {
   private LinkedList<String> sentences = new LinkedList<>(); 
   private LinkedList<String> errWords = new LinkedList<>(); 
   private String generalWord="";
// private LinkedList<LinkedList> words = new LinkedList<>();  


  public sentences(){
   }
   
   public  sentences(LinkedList<String> in){
    this.copyLinkedList(in, this.sentences); 
            } 
   
   public  sentences(String fileName,String fileNameExeptions,boolean lemm) throws 
            FileNotFoundException, IOException {
        
    if (fileNameExeptions.length()>4){
        BufferedReader reader1 = new BufferedReader(new FileReader(fileNameExeptions));
        String line1;
       
        errWords.clear();
        while ((line1 = reader1.readLine()) != null) {
        LinkedList<String> buf = new LinkedList<>();
        buf.clear();
         this.copyLinkedList(this.wordsToList(line1), buf);
         System.out.println("BUF:"+buf);
        if(buf.size()>0)
         for(int i=0;i<buf.size();i++)    
        errWords.add(buf.get(i));
        
        System.out.println("ERR:"+errWords);
        }}
       
        
    //Этот спец. объект для построения строки
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        LinkedList<String> buf = new LinkedList<>();
        this.sentences.clear();
        
        while ((line = reader.readLine()) != null) {
        buf.clear();
            String senc="";
        senc=this.getNormalText(line);
        //System.out.println("senc:"+senc);
        String senc2="";
        buf=this.sentsToList(senc);
        for(int g=0;g<buf.size();g++)
        {
            buf.set(g, this.delErrWordsStr(buf.get(g)));
            System.out.println("Buf_"+g+":"+buf.get(g));
        }
        //senc2=this.delErrWordsStr(senc);
        
       //buf=this.sentsToList(senc2);
       // System.out.println("buf:"+buf);
        for(int i=0;i<buf.size();i++){
        this.sentences.add(buf.get(i));
       // System.out.println("sent:"+this.sentences.get(i)+" i:"+i);
        }
     } 
      //  for(int i=0;i<this.sentences.size();i++)
     //   System.out.println("ALLsent:"+this.sentences.get(i)+" i:"+i);
        
   }
   
     public void setSentence(LinkedList<String> in){
     sentences buf = new sentences(in);
      this.sentences.clear();
     this.copyLinkedList(buf.getSentences(),  this.sentences); 
     }
     public LinkedList<String> getSentences(){
     return this.copyLinkedList(this.sentences);
     }

    
    private String delErrWordsStr(String in){
 String ret="";
 LinkedList<String> words;
  words = this.wordsToList(in);

  int max=words.size();
 // int i=0;
  //System.out.println("size:"+this.errWords.size());
 // System.out.println("sizeWords:"+max);
  for(int j=0;j<this.errWords.size();j++){
       max=words.size();
      int i=0; 
      while(i<max){
 int indx=words.get(i).indexOf( this.errWords.get(j));
 //         System.out.println(
 //         "Word:"+words.get(i).toString()+
 //         " ErrWord:"+this.errWords.get(j).toString()+ 
 //         " True:"+
 //                words.get(i).indexOf( this.errWords.get(j).toString())+"|"+ 
 //               words.get(i).equalsIgnoreCase(this.errWords.get(j).toString())+"|wrdlen|"+ 
 //               words.get(i).length() +"|wrdlen|"+ 
 //               this.errWords.get(j).length()     
 //         );
          if(
          words.get(i).equalsIgnoreCase(this.errWords.get(j).toString())
          &
        // indx>-1 & 
                  words.get(i).length()==this.errWords.get(j).length()
                  ){
          words.remove(i);
          max--;
          i--;
          }
          
  i++;
  }
  }
  for(int k=0;k<words.size();k++){
  ret=ret+words.get(k)+" ";
  }
 
 // System.out.println("ret:"+ret);
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
 //System.out.println("ret:"+ret);
return ret;
}    
 
 private boolean equals(String string1, String string2){
boolean ret=false;
    if (string1.length()==string2.length())
      if (string1.equalsIgnoreCase(string2)) ret=true;  
return ret;
}
    
    public void clearSents(){
    sentences.clear();
    }
    
    public int getSize(){
     return sentences.size();
    } 
   
     public void getSearchSentences(
             String search,LinkedList<String> outL)
    {       
    LinkedList<String> wrds =new LinkedList<>();
    LinkedList<String> buf =new LinkedList<>();
    this.copyLinkedList(this.sentences, buf);
  //  System.out.println("in Get Sent size:"+outL.size());
    for(int i=0;i<buf.size();i++){
    String line="";//,tmpLine="";
    line=buf.get(i).toLowerCase();
    //tmpLine=line.toLowerCase();
    
     
        wrds.clear();
        this.copyLinkedList(this.wordsToList(line), wrds);
    //this.wordsToList(line, wrds);
    
    int max= wrds.size();
   int i2=0;
   int flag=0;
    while(i2<max){
 
    if (search.length()==wrds.get(i2).toString().length())
    if(search.equalsIgnoreCase(wrds.get(i2).toString())){
       outL.add(line); 
       flag++;
        }
    i2++;
    if(flag>0)i2=max;
    if(i2==max)wrds.clear();
    }
    
    
    }
    }
    
     public LinkedList<String> wordsToList(){
     LinkedList<String> rtrn = new LinkedList<>();
     LinkedList<String> buf = new LinkedList<>();
     int i=0;
     rtrn.clear();
     for(int j=0;j< sentences.size();j++){ 
      //   System.out.println("sentns:"+sentences.get(j));
       buf.clear();
         buf=this.wordsToList(this.sentences.get(j));
      //   System.out.println("buf of sn:"+buf);
     for(int i1=0;i1< buf.size();i1++)rtrn.add(buf.get(i1));
     }
     
    // System.out.println("All sentns:"+rtrn);
     return rtrn;
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
     
      public String NormalForm(String in){
String ret=in;

 StringBuilder buf = new StringBuilder();
	 Ray r=new Ray();
        // r.
	 if (r.b()>0)
	 {
		 r.a(in, buf);
		// System.out.println(buf.toString());
                // System.out.println(buf.length());
         String out="",bufer="";
         int start=0,stop=0;
         start=buf.indexOf("1)");
         if(start>0){
         bufer=buf.substring(start+2);
         stop=(bufer.indexOf("("));
         if ((stop>0)&(stop<buf.length())){
           //       System.out.println("start:"+start+" stop:"+stop);
         
         out=buf.substring(start+2,start+2+stop-1);
         ret=out;

         }
         }}
          else System.out.print("Loading failed with code="+r.b());
        // TODO code application logic here
        return ret;
    } 
     
      public String FormOfWord(String in){
String ret="Неиз";

 StringBuilder buf = new StringBuilder();
	 Ray r=new Ray();
	 if (r.b()>0)
	 {
	 r.a(in, buf);
         String out="",bufer="";
         int start=0,stop=0;
         start=buf.indexOf("(");
         if(start>0){
         bufer=buf.substring(start+1);
         stop=bufer.indexOf(".");
         out=buf.substring(start+1,start+1+stop);
         ret=out;
	 }}
          else System.out.print("Loading failed with code="+r.b());
        // TODO code application logic here
        return ret;
    } 
      
      public LinkedList<String> wordsToList(String in){
     LinkedList<String> rtrn = new LinkedList<>();
     String wrd="";   
     //String[] words= new String[65535];
    // int i=0;
     for(int j=0;j< in.length();j++){ 
      //  for(int i1=0;i1< in.get(j).length();i1++){    
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
//   i++;
              wrd="";
            }}
     }
     return rtrn;
     }
public LinkedList getSentenceWords(int i, boolean lemm){
    LinkedList<String> ret=new LinkedList();
  //   LinkedList<String> ebaniy=new LinkedList();
   // System.out.println("sent:"+this.sentences.get(i));
  //  ebaniy=this.wordsToList(this.sentences.get(i),lemm);
    if(lemm){
    this.copyLinkedList(this.getWordsToListNormal(this.sentences.get(i)),ret);
    }
   if(!lemm){
    this.copyLinkedList(this.wordsToList(this.sentences.get(i)),ret);
    }
// System.out.println("lemm:"+lemm);
//  System.out.println("ret:"+ret);
     
return ret;     
}  
      
 public LinkedList getWordsToListNormal (String in){
    LinkedList<String> ret=new LinkedList();
    LinkedList<String> buf=new LinkedList();
     this.copyLinkedList(this.wordsToList(in),buf);
     for(int i=0;i<buf.size();i++){
     //    System.out.println("in word:"+buf.get(i));
     ret.add(this.NormalForm(this.getNormalText(buf.get(i))));
   //  System.out.println("out word:"+this.NormalForm(this.getNormalText(buf.get(i))));
     }
     
 // System.out.println("ret:"+ret);
     
return ret;       
 }

      
  public void setGenerWord(String inp){this.generalWord=inp;}
public String getGenerWord(){return this.generalWord;}
public String getSentence(int i){return this.sentences.get(i);}    

}
