public class StaticBlockTest  implements Runnable{  
      
    static{  
        if(true){  
            System.out.println("test");  
//          while(true){  
//                
//          }  
        }  
          
    }  
    public StaticBlockTest(){
        System.out.println("constructor");
    } 
    @Override  
    public void run() {  
          
        System.out.println("run");  
    }  

    public static void main(String[] args) {  
        StaticBlockTest s = new StaticBlockTest();  
        StaticBlockTest s1 = new StaticBlockTest();  
        Thread t1 = new Thread(s);  
        Thread t2 = new Thread(s1);  
          
          
        t1.start();  
        t2.start();  
          
    }  
  
  
  
}  

/**
*output:
*test
*constructor
*constructor
*run
*run 
*/
