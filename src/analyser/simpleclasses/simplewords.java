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
public class simplewords {
 private LinkedList<String> words = new LinkedList<>(); 
 private LinkedList<String> partOfSpeech = new LinkedList<>(); 
 
  public simplewords(LinkedList<String> in,LinkedList<String> pos){
     this.copyLinkedList(in, this.words);
     this.copyLinkedList(pos, this.partOfSpeech);
 }
 public simplewords(LinkedList<String> in){
     this.copyLinkedList(in, this.words);
     this.partOfSpeech.clear();
     for(int i=0;i<this.partOfSpeech.size();i++){this.partOfSpeech.add("");}
 }
 public simplewords(){
 this.words.clear();
 this.partOfSpeech.clear();
 }

 public void setSizePOS(){
 this.partOfSpeech.clear();
 int size=this.getSize();
 for(int i=0;i<size;i++){this.partOfSpeech.add("Неиз");}
 }
 public void setPOS(int i,String in){
 this.partOfSpeech.set(i, in);
 }
 
 public String getPOS(int in){
 String ret ="-1";
 ret=this.partOfSpeech.get(in);
 return ret;
 }

  public String getPOS(String in){
 String ret ="-1";
 for (int i=0;i<this.words.size();i++){
 if(this.equals(in, this.words.get(i)))ret=this.partOfSpeech.get(i);
 }
 return ret;
 }
  
 public int getSize(){return this.words.size();}
 public LinkedList getAllWords(){return this.words;}
 public void toLowCase(){
 int max=this.words.size();
 for(int i=0;i<max;i++){this.words.set(i, this.words.get(i).toLowerCase());}
 }
 public void calculateFreq(String in,Double freqInText){
int max=this.words.size();
int value=1;

for(int i=0;i<max;i++){

if (this.words.get(i).equalsIgnoreCase(in)){
        value++;}
}
freqInText=Double.valueOf(value)/Double.valueOf(max);
}
  public Double calculateFreq(String in){
      Double freqInText=0.0;
int max=this.words.size();
int value=1;

for(int i=0;i<max;i++){

if (this.words.get(i).equalsIgnoreCase(in)){
        value++;}
}
freqInText=Double.valueOf(value)/Double.valueOf(max);
return freqInText;
}
  public void remWordsOfSize(int size){
  for(int i=this.words.size()-1;i>=0;i--){
      if(this.words.get(i).length()<=size)this.words.remove(i);
  }
  }

public void delDuplicateWords(){
int max=this.words.size();
//System.out.println("max:"+max);
LinkedList<String> bufWrd = new LinkedList<>();
this.copyLinkedList(this.words, bufWrd);    
     
for(int i=0;i<max;i++){
for(int j=0;j<max;j++){
if(i!=j){
if (this.equals(bufWrd.get(i),bufWrd.get(j))){bufWrd.set(j, "---");}
//System.out.println("repl j:"+j);
}
//System.out.println("i:"+i+" j:"+j);
}
}
int i1=0;
//System.out.println("bufSize:"+bufWrd.size());
while(i1<bufWrd.size()){
 if( this.equals(bufWrd.get(i1).toString(),"---")){
bufWrd.remove(i1);
//if(i1>=bufWrd.size())i1=bufWrd.size()-1;
}
if(i1<bufWrd.size()) {
if(!this.equals(bufWrd.get(i1).toString(),"---")){i1++;}}

//System.out.println("i1:"+i1+" bufSize:"+bufWrd.size());
}
this.copyLinkedList(bufWrd, this.words);
}
 

public Double getPovtor(String in){
Double ret=0.0;
int max =this.words.size();
    int i=0;
       while(i<max){

        if(in.equalsIgnoreCase(this.words.get(i))){
        ret=ret+1.0;
        }
 
    i++;
    }
return ret;
}
 public void remWord(int i){
if (i < this.words.size()){
    this.words.remove(i);
    this.partOfSpeech.remove(i);
}}
 public String getWord(int i){
String ret="err";
    if (i < words.size()){
   ret= words.get(i);
}
return ret;
}
 public void addWord(String addword){
this.words.add(addword);
this.partOfSpeech.add("");
}
  public void addWords (LinkedList<String> addword){
  for (int i=0;i<addword.size();i++){
      words.add(addword.get(i));
      this.partOfSpeech.add("");
  }
}
  public void replaceWord(String in,int k){
 //this.words.set(i, in);
 LinkedList<String> tmpwrds=new LinkedList<>();
 tmpwrds.clear();
 for(int i=0;i<this.words.size();i++){
 if(i==k){tmpwrds.add(in);}
 if(i!=k){tmpwrds.add(this.words.get(i).toLowerCase());}
 }
 this.copyLinkedList(tmpwrds, this.words);
 }
 public void replaceWord2(String in,int i){
 this.words.set(i, in);
 }
  public void replaceWords(LinkedList<String> wrds){
 this.copyLinkedList(wrds, this.words);
 this.partOfSpeech.clear();
 for (int i=0;i<wrds.size();i++){
     
 }
 }
   public void clearWords(){
 this.words.clear();
 }
     private boolean equals(String string1, String string2){
boolean ret=false;
    if (string1.length()==string2.length()){
      if (string1.equalsIgnoreCase(string2)){ ret=true;}}  
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
 //System.out.println("ret:"+ret);
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
