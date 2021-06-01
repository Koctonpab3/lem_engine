/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyser.simpleclasses;

import static java.lang.Math.abs;
import java.util.LinkedList;

/**
 *
 * @author alex_
 */
public class words {
    private LinkedList<String> words = new LinkedList<>();
    private LinkedList<Double> freqInText = new LinkedList<>();
    private LinkedList<Double> freqInTextRevers = new LinkedList<>();
    private LinkedList<String> PartOfSpeech = new LinkedList<>();
    private Integer sizeOfWords=0; 
    private String generalWord="";
//  private LinkedList<String> wordsChoose = new LinkedList<>();
    // private LinkedList<Double> IndxOfWord = new LinkedList<>();
 //  private LinkedList<Double> freqInText = new LinkedList<>();

public words(){
    this.generalWord="";
}
public words(int in){
    for(int i=0;i<in;i++){
    this.words.add("");
    this.freqInText.add(0.0);}
} 

public words(String str){
this.generalWord=str;
}    
    
public words(LinkedList<String> wrds){
   this.sizeOfWords=wrds.size();
    int max=this.sizeOfWords;
    this.freqInText.clear();
    this.words.clear();
    this.PartOfSpeech.clear();
   
    words buf = new words();
  //  fjhufctjfc
    for(int i=0;i<wrds.size();i++){
    buf.addWord(wrds.get(i));
    }
    
    buf.calculateFreq();
  //   System.out.println("delDupl ON");
    buf.delDuplicateWords();
  //   System.out.println("calc deldupl fin");
   // buf=this.delDuplicate(wrds);
    this.copyLinkedList(buf.getWords(), this.words);
    this.copyLinkedList(buf.getFrqs(), this.freqInText);
    this.copyLinkedList(buf.getWordsPOS(), this.PartOfSpeech);

}    
public void calculateFreq(){
int max=this.words.size();
int value=1;

for(int i=0;i<max;i++){
    value=1;
for(int j=0;j<max;j++){
if(i!=j){
if (this.words.get(i).equalsIgnoreCase(this.words.get(j))){
        value++;}
}
}
this.freqInText.set(i, (Double.valueOf(value)/Double.valueOf(max)));
}

}

public void delDuplicateWords(){
int max=this.words.size();
     LinkedList<String> bufWrd = new LinkedList<>();
     LinkedList<Double> bufFrq = new LinkedList<>();
     LinkedList<String> bufPOS = new LinkedList<>();
     
this.copyLinkedList(this.words, bufWrd);
this.copyLinkedList(this.freqInText, bufFrq);  
this.copyLinkedList(this.PartOfSpeech, bufPOS);
     
while(bufFrq.size()!=bufWrd.size())bufFrq.add(0.0);
while(bufPOS.size()!=bufWrd.size())bufPOS.add("Неиз");

for(int i=0;i<max;i++){
for(int j=0;j<max;j++){
if(i!=j){
if (bufWrd.get(i).equalsIgnoreCase(bufWrd.get(j))){
    bufFrq.set(j, -1.0);
    bufWrd.set(j, "---");
    bufPOS.set(j, "---");
}
}
}
}
int i1=0;

while(i1<bufWrd.size()-1){
   // System.out.println("i1:"+i1+" size:"+bufWrd.size());
    if( this.equals(bufWrd.get(i1).toString(),"---")){
bufWrd.remove(i1);
bufFrq.remove(i1);
bufPOS.remove(i1);
//if(i1>=bufWrd.size())i1=bufWrd.size()-1;
}
if(!this.equals(bufWrd.get(i1).toString(),"---")&i1<bufWrd.size()-1){i1++;}
}



this.copyLinkedList(bufWrd, this.words);
this.copyLinkedList(bufFrq, this.freqInText);
this.copyLinkedList(bufPOS, this.PartOfSpeech);

}

public Double getPovtor(String in,LinkedList<String> inLL){
Double ret=0.0;
int max =this.words.size();
    int i=0;
       while(i<max){

        if(in.equalsIgnoreCase(inLL.get(i))){
        ret=ret+1.0;
        }
 
    i++;
    }
return ret;
}

public void copyLinkedList(LinkedList in,LinkedList out){
out.clear();
out.removeAll(out);
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

public void setFreqs(LinkedList<Double> in){
this.copyLinkedList(in,this.freqInText);
}
public void setWords(LinkedList<String> in){
this.copyLinkedList(in,this.words);
this.freqInText.clear();
this.freqInTextRevers.clear();
this.PartOfSpeech.clear();
for (int i=0;i<this.words.size();i++){
//this.words.set(i, this.words.get(i).);
this.freqInText.add(0.0);
this.freqInTextRevers.add(0.0);
this.PartOfSpeech.add("Неиз");
}
}

private boolean equals(String string1, String string2){
boolean ret=false;
    if (string1.length()==string2.length())
      if (string1.equalsIgnoreCase(string2)) ret=true;  
return ret;
}

public void addWord(String addword){
this.words.add(addword);
this.freqInText.add(0.0);
this.PartOfSpeech.add("Неизв");//this.getWordPOS(addword));
}
public void addWord(String addword, Double freq){
this.words.add(addword);
this.freqInText.add(freq);
this.PartOfSpeech.add("Неизв");//this.getWordPOS(addword));
}
public void addWord(String addword, Double freq,Double freqREV){
this.words.add(addword);
this.freqInText.add(freq);
this.freqInTextRevers.add(freqREV);
this.PartOfSpeech.add("Неизв");//this.getWordPOS(addword));
}
public void addWord(String addword, Double freq, String pos){
this.words.add(addword);
this.freqInText.add(freq);
this.PartOfSpeech.add(pos);
}
public void remWord(int i){
if (i < this.words.size()){
    this.words.remove(i);
    this.freqInText.remove(i);
    this.PartOfSpeech.remove(i);
}}
public void remWord(String in){
for(int i=this.words.size()-1;i>-1;i--){
    if (this.equals(in,this.words.get(i))){
    this.words.remove(i);
    this.freqInText.remove(i);
    this.PartOfSpeech.remove(i);
    }
}

}

public String getWord(int i){
String ret="err";
    if (i < words.size()){
   ret= words.get(i);
}
return ret;
}
public Double getFreq(int i){
Double ret;
//    if (i < freqInText.size()){
ret= freqInText.get(i);

//}
return ret;
}
public Double getFreq(String wrd){
Double ret=0.0;
for (int i=0;i<this.words.size();i++){
    if (this.equals(wrd, words.get(i))){
   ret= freqInText.get(i);
    }}
return ret;
}
public void getWrdFrq(int i, String wrd, Double frq){
   if (i < freqInText.size()){
   frq= freqInText.get(i);
   wrd= words.get(i);
}
}
public void setWrdFrq(int i, String wrd, Double frq){
   if (i < freqInText.size()){
   freqInText.set(i,frq);
   words.set(i,wrd);
}}
public void setWrdFrq(LinkedList <String> wrd,LinkedList <Double> frq){
  this.copyLinkedList(frq,this.freqInText); 
  this.copyLinkedList(wrd,this.words); 
}
public LinkedList <String> getWords(){return this.copyLinkedList(this.words);}
public LinkedList <Double> getFrqs(){return this.copyLinkedList(this.freqInText);}
public LinkedList <String> getWordsPOS(){return this.copyLinkedList(this.PartOfSpeech);}

public void setWord(int i,String wrd){
   words.set(i,wrd); 
}
public void setFreq(int i,Double frq){
   freqInText.set(i,abs(frq)); 
}
public int getSize(){
return words.size();
}
public Double summAllFreq(){
Double ret=0.0;
for(int i=0;i<this.freqInText.size();i++)ret=ret+this.freqInText.get(i);
return ret;
}

//govno peredelat
        public Double summNotWordsFreq(LinkedList <String> in){
Double ret=0.0,buf=0.0;
buf=this.summAllFreq()-this.summWordsFreq(in);
if(buf>=0.0&buf<9999.99)ret=buf;
return ret;
}

public Double summWordsFreq(LinkedList <String> in){
Double ret=0.0;
for(int i=0;i<this.freqInText.size();i++)
{    
 for(int j=0;j<in.size();j++)
{    
 if(words.get(i).equalsIgnoreCase(in.get(j)))ret=ret+freqInText.get(i);
}}
return ret;
}

public void clear(){
this.words.clear();
this.freqInText.clear();
this.PartOfSpeech.clear();
}

public void delete(){
this.words.remove();
this.freqInText.remove();
this.PartOfSpeech.remove();
}

//pod voprosom
///*
public void sortByIndex(){
    String bufStr="";
    Double bufDbl=0.0;
    String bufPOS="";
    for (int i=0;i<words.size();i++){
    for (int j=0;j<words.size();j++){
    if (freqInText.get(i)>freqInText.get(j)){
     bufDbl=freqInText.get(i);
     freqInText.set(i,freqInText.get(j));   
     freqInText.set(j,bufDbl); 
    bufStr=words.get(i);
     words.set(i,words.get(j));   
     words.set(j,bufStr); 
    bufPOS=this.PartOfSpeech.get(i);
     this.PartOfSpeech.set(i,this.PartOfSpeech.get(j));   
     this.PartOfSpeech.set(j,bufPOS);
     
    }}
    }

}

public void sortByIndexWithREV(){
    String bufStr="";
    Double bufDbl=0.0;
    Double bufDblREV=0.0;
    String bufPOS="";
    for (int i=0;i<words.size();i++){
    for (int j=0;j<words.size();j++){
    if (freqInText.get(i)>freqInText.get(j)){
     bufDbl=freqInText.get(i);
     bufDblREV=freqInTextRevers.get(i);
     freqInText.set(i,freqInText.get(j));   
     freqInText.set(j,bufDbl); 
//
     bufDblREV=freqInTextRevers.get(i);
     freqInTextRevers.set(i,freqInTextRevers.get(j));   
     freqInTextRevers.set(j,bufDblREV); 
    bufStr=words.get(i);
     words.set(i,words.get(j));   
     words.set(j,bufStr); 
    bufPOS=this.PartOfSpeech.get(i);
     this.PartOfSpeech.set(i,this.PartOfSpeech.get(j));   
     this.PartOfSpeech.set(j,bufPOS);
     
    }}
    }

}
//*/
public void getByFreq(Double min,Double max,
                                LinkedList<String> wrd,
                                 LinkedList<String> POS,
                                      LinkedList<Double> frq){
wrd.clear();
frq.clear();
POS.clear();
wrd.remove();
frq.remove();
POS.remove();

for (int i=0;i<words.size();i++){
if (freqInText.get(i)>=min & freqInText.get(i)<=max)
{
wrd.add(words.get(i));
frq.add(freqInText.get(i));
POS.add(this.PartOfSpeech.get(i));
}}
}

public words getByFreq(Double min,Double max ){
words ret =new words();
for (int i=0;i<words.size();i++){
if (freqInText.get(i)>=min & freqInText.get(i)<=max)
{
ret.addWord(this.words.get(i),
        this.freqInText.get(i)
        ,this.PartOfSpeech.get(i));
}}
return ret;
}

public Integer getSizeOfWords(){
return this.sizeOfWords;
}
public void setGenerWord(String inp){this.generalWord=inp;}
public String getGenerWord(){return this.generalWord;}

public void setPartOfSpeech(int in,String str){
 if(in>0 | in<this.PartOfSpeech.size()) this.PartOfSpeech.set(in, str);
}

public String getPartOfSpeech(int in){
String ret="-1";
if(in>0 | in<this.PartOfSpeech.size()) ret=this.PartOfSpeech.get(in);
return ret;
}
public String getPartOfSpeech(String in){
String ret="-1";
for(int i=0;i<this.words.size();i++){
if(this.equals(in, this.words.get(i))){ret=this.getPartOfSpeech(i);}
}
return ret;
}
public void CreateFreqRev(){
this.freqInTextRevers.clear();
    for(int i=0;i<this.words.size();i++){
this.freqInTextRevers.add(0.0);
}
}
public void setFreqRev(int i, double in){
this.freqInTextRevers.set(i, in);
}
public double getFreqRev(int i){
double ret=0.0;
if (i>0&i<this.words.size())ret=this.freqInTextRevers.get(i);
return ret;
}

/*
public String getWordPOS(String in){
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
         if( stop > 0 & stop<bufer.length()){ 
         out=buf.substring(start+1,start+1+stop);
         ret=out;
	 }}}
          else System.out.print("Loading failed with code="+r.b());
        return ret;
    } 
*/
}
