/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyser.simpleclasses;

/**
 *
 * @author Admin
 */
public class Timer {
  private long startMsec=0,startSec=0,startMin=0,
            stopMsec=0,stopSec=0,stopMin=0,
            Msec=0,Sec=0,Min=0;
  private String out="";
   public Timer(){
            startMsec=0;startSec=0;startMin=0;
            stopMsec=0;stopSec=0;stopMin=0;
            Msec=0;Sec=0;Min=0;out="";
    }
    public void resetAll(){
        startMsec=0;startSec=0;startMin=0;
            stopMsec=0;stopSec=0;stopMin=0;
            Msec=0;Sec=0;Min=0;
    }
    public void resetMsec(){startMsec=0;stopMsec=0;Msec=0;}
    public void resetSec(){startSec=0;stopSec=0;Sec=0;}
    public void resetMin(){startMin=0;stopMin=0;Min=0;}
    public void startMsec(){startMsec=System.currentTimeMillis();}
    public void startSec(){startSec=System.currentTimeMillis()/1000;}
    public void startMin(){startMin=System.currentTimeMillis()/60000;}
    public void stopMsec(){stopMsec=System.currentTimeMillis();
    Msec=stopMsec-startMsec;
    out=(Msec/1000)+"."+(Msec-(Msec/1000)*1000);
    }
    public void stopSec(){stopSec=System.currentTimeMillis()/1000;
    Sec=stopSec-startSec;}
    public void stopMin(){stopMin=System.currentTimeMillis()/60000;
    Min=stopMin-startMin;}
    public String getMsec(){return out;}
    public long getSec(){return Sec;}
    public long getMin(){return Min;}
    
}
