import Array._
import java.io.File
import java.io.PrintWriter
import util.Random
object Main extends App {
 
  
  //slitherlink-gruppe 13
  
  
  class Board(xLen:Int,yLen:Int){
    var r = new Rules(this);
    val xLength = xLen;
    val yLength = yLen;
    //var possibleLinks = ofDim[Boolean](xLength,yLength)  
    var ActualLinks = ofDim[Int](xLength,yLength)   //   -1:undecided     0:false       1:true
    //var possibleNumbers = ofDim[Boolean](xLength,yLength) 
    var ActualNumbers = ofDim[Int](xLength,yLength)  // -1:undecided        0-3: amount of links allowed
    
    var LinkBool = ofDim[Boolean](xLength,yLength)
    
        //puts in -1 in possible link locations for undecided.
    for (i <- 0 to xLength-1) {
      for ( j <- 0 to yLength-1) {
        if(LinkCheck(i,j)){
           ActualLinks(i)(j) = -1;
           LinkBool(i)(j) = false;
          }
        }
    }
    
    
    //put -1 in possible number locations for undecided.
    
    for (i <- 0 to xLength-1) {
      for ( j <- 0 to yLength-1) {
        if(NumberCheck(i,j)==true){
           ActualNumbers(i)(j) = -1;
        }
      }
    }    
    
    
    
    
    def PointCheck(x:Int,y:Int):Boolean = {
      if(x%2==0 && y%2==0){
        return true;
      }
      return false;
    }
    
    def NumberCheck(x:Int,y:Int):Boolean ={
      if(x%2==1 && y%2==1){
        return true;
      }   
      return false;
    }
    def LinkCheck(x:Int,y:Int):Boolean ={
      if(x%2==0 && y%2==1){
        return true;
      }
      if(x%2==1 && y%2==0){
        return true;
      }
      return false;
    }
    


  /*  def isLinked(x1:Int,x2:Int,y1:Int,y2:Int):Boolean ={
      if(Math.abs(x1-x2)==1 && Math.abs(y1-y2)==1){
        return true;
      }
      return false;
    }*/
    
    def CheckLinksForNumber(x1:Int,y1:Int):Boolean = {
      val s = ActualNumbers(x1)(y1);
      var a = 0;
      if(ActualLinks(x1+1)(y1)==1){
        a+=1;
      }
      if(ActualLinks(x1-1)(y1)==1){
        a+=1;
      }
      if(ActualLinks(x1)(y1+1)==1){
        a+=1;
      }
      if(ActualLinks(x1)(y1-1)==1){
        a+=1;
      }
      if(s == -1 || s == a){
        return true;
      }
      return false;
    }
    
    def setNumber(x1:Int,y1:Int,n:Int){
      if(NumberCheck(x1,y1)){
        ActualNumbers(x1)(y1) = n;
      }
    }
    
    def setLink(x1:Int,y1:Int,n:Int){
      if(LinkCheck(x1,y1)){
        ActualLinks(x1)(y1) = n;
      }
    }
    
    def numPrint(){
      for (i <- 0 to xLength-1) {
        for ( j <- 0 to yLength-1) {
          if(NumberCheck(i,j)==true){
           println("i: "+i+" j: "+j+" Value: "+ActualNumbers(i)(j));
          }
        }
      }    
    }
    
    def linkPrint(){
      for (i <- 0 to xLength-1) {
        for ( j <- 0 to yLength-1) {
          if(LinkCheck(i,j)==true){
           println("i: "+i+" j: "+j+" Value: "+ActualLinks(i)(j));
          }
        }
      }    
    }
    
    def CheckConnection(x1:Int,y1:Int,n:Int):Int = {      //n=type kobling man ser etter, dvs 1=linje, 0=kryss
    var a = 0;
    
    if(x1==0){
      if(y1==0){
        if(ActualLinks(x1+1)(y1)==n){
          a+=1;
          }
        if(ActualLinks(x1)(y1+1)==n){
          a+=1;
          }    
        return a;
        }
      if(y1==yLength-1){
        if(ActualLinks(x1+1)(y1)==n){
          a+=1;
          }
        if(ActualLinks(x1)(y1-1)==n){
          a+=1;
          }    
        return a;
        }
      if(ActualLinks(x1+1)(y1)==n){
        a+=1;
        }
      if(ActualLinks(x1)(y1+1)==n){
        a+=1;
        }
      if(ActualLinks(x1)(y1-1)==n){
        a+=1;
        }    
      return a;
    }
    
    if(x1==xLength-1){
      if(y1==0){
        if(ActualLinks(x1-1)(y1)==n){
          a+=1;
          }
        if(ActualLinks(x1)(y1+1)==n){
          a+=1;
          }    
        return a;
        }
      if(y1==yLength-1){
        if(ActualLinks(x1-1)(y1)==n){
          a+=1;
          }
        if(ActualLinks(x1)(y1-1)==n){
          a+=1;
          }    
        return a;
        }
      if(ActualLinks(x1-1)(y1)==n){
        a+=1;
        }
      if(ActualLinks(x1)(y1+1)==n){
        a+=1;
        }
      if(ActualLinks(x1)(y1-1)==n){
        a+=1;
        }
      return a;
      }    
    if(y1==0){
      if(ActualLinks(x1+1)(y1)==n){
        a+=1;
        }
      if(ActualLinks(x1-1)(y1)==n){
        a+=1;
        }
      if(ActualLinks(x1)(y1+1)==n){
        a+=1;
        }
      return a;
      }
    if(y1==yLength-1){
      if(ActualLinks(x1+1)(y1)==n){
        a+=1;
        }
      if(ActualLinks(x1-1)(y1)==n){
        a+=1;
        }
      if(ActualLinks(x1)(y1-1)==n){
        a+=1;
        }
      return a;
      }
    if(ActualLinks(x1+1)(y1)==n){
      a+=1;
      }
    if(ActualLinks(x1-1)(y1)==n){
      a+=1;
      }
    if(ActualLinks(x1)(y1+1)==n){
      a+=1;
    }
    if(ActualLinks(x1)(y1-1)==n){
      a+=1;
    }
    return a;
    }
    
   /* def isLinked(){
      for (i <- 0 to xLength-1) {
        for ( j <- 0 to yLength-1) {
          if(LinkCheck(i,j)==true){
          
            if(Math.abs(x1-x2)==1 && Math.abs(y1-y2)==1)
            
            
          }
        }
      }
    }
*/    
    def randomSolution(){
      for (i <- 0 to xLength-1){
        for ( j <- 0 to yLength-1){
          if(LinkCheck(i,j)==true && LinkBool(i)(j)==false){
            val r = scala.util.Random
            val res = r.nextInt(2);
            ActualLinks(i)(j) = res;
          }
        }
      }     
    }
    
    def SetCorrectLink(x1:Int,y1:Int,n:Int){
      setLink(x1,y1,n);
      LinkBool(x1)(y1)=true;
    }
    
    /*def recursionSolution(b1:Board,x1:Int,y1:Int):Board ={
    if(isValid(b1)==true){
      println("solved")
      return b1;
    }
    println("x: "+x1+" y: "+y1);
    if(y1!=yLength-1 && b1.ActualLinks(x1)(y1+1)!=1){
      b1.setLink(x1,y1+1,1);
      var b2 = recursionSolution(b1,x1,y1+2);
      b1.setLink(x1,y1+1,-1);
    }
    else if(x1!=xLength-1  && b1.ActualLinks(x1+1)(y1)!=1){
      b1.setLink(x1+1,y1,1)
      var b2 = recursionSolution(b1,x1+2,y1)
      b1.setLink(x1+1,y1,-1)
    }
    else if(y1!=0 && b1.ActualLinks(x1)(y1-1)!=1){
      b1.setLink(x1,y1-1,1);
      var b2 = recursionSolution(b1,x1,y1-2);        
      b1.setLink(x1,y1-1,-1);
    }
    else if(x1!=0 && b1.ActualLinks(x1-1)(y1)!=1){
      b1.setLink(x1-1,y1,1);
      var b2 = recursionSolution(b1,x1-2,y1);        
      b1.setLink(x1-1,y1,-1);
    }  
    return b1;
    }*/
    
    def NumberIsValid(b:Board):Boolean={            
      for (i <- 0 to xLength-1) {
        for ( j <- 0 to yLength-1) {
          if(NumberCheck(i,j)==true){
            if(CheckLinksForNumber(i,j)==false){
              return false;
            }
          }
        }
      }
      return true;
    }
    
    def LinkIsValid(b:Board):Boolean={
      for (i <- 0 to xLength-1) {
        for ( j <- 0 to yLength-1) {
          if(PointCheck(i,j)==true){            
            if(!(CheckConnection(i,j,1)==0 || CheckConnection(i,j,1)==2)){
              return false;
            }
          }
        }
      }
      return true;      
    }
    
    def LinkSize(x1:Int,y1:Int):Int={
      if(CheckConnection(x1,y1,1)==0){
        return 0;
      }
      else{
        var a=0;
        var x2=x1;
        var y2=y1;
        var dir= -1;
        do{
        
        if(x2==0 && y2==0){
          if(ActualLinks(x2+1)(y2)==1&&dir!=2){x2+=2;a+=1;dir=1;}
          else if(ActualLinks(x2)(y2+1)==1&&dir!=4){y2+=2;a+=1;dir=3;}
        }
        else if(x2==xLength-1 && y2==0){
          if(ActualLinks(x2-1)(y2)==1&&dir!=1){x2-=2;a+=1;dir=2;}
          else if(ActualLinks(x2)(y2+1)==1&&dir!=4){y2+=2;a+=1;dir=3;}
        }
        else if(x2==0 && y2==yLength-1){
          if(ActualLinks(x2+1)(y2)==1&&dir!=2){x2+=2;a+=1;dir=1;}
          else if(ActualLinks(x2)(y2-1)==1&&dir!=3){y2-=2;a+=1;dir=4;}
        }
        else if(x2==xLength-1 && y2==yLength-1){
          if(ActualLinks(x2-1)(y2)==1&&dir!=1){x2-=2;a+=1;dir=2;}
          else if(ActualLinks(x2)(y2-1)==1&&dir!=3){y2-=2;a+=1;dir=4;}
        }
        else if(x2==0){
          if(ActualLinks(x2+1)(y2)==1&&dir!=2){x2+=2;a+=1;dir=1;}
          else if(ActualLinks(x2)(y2+1)==1&&dir!=4){y2+=2;a+=1;dir=3;}
          else if(ActualLinks(x2)(y2-1)==1&&dir!=3){y2-=2;a+=1;dir=4;}
        }
        else if(x2==xLength-1){
          if(ActualLinks(x2-1)(y2)==1&&dir!=1){x2-=2;a+=1;dir=2;}
          else if(ActualLinks(x2)(y2+1)==1&&dir!=4){y2+=2;a+=1;dir=3;}
          else if(ActualLinks(x2)(y2-1)==1&&dir!=3){y2-=2;a+=1;dir=4;}          
        }
        else if(y2==0){
          if(ActualLinks(x2+1)(y2)==1&&dir!=2){x2+=2;a+=1;dir=1;}
          else if(ActualLinks(x2-1)(y2)==1&&dir!=1){x2-=2;a+=1;dir=2;}
          else if(ActualLinks(x2)(y2+1)==1&&dir!=4){y2+=2;a+=1;dir=3;}
        }
        else if(y2==yLength-1){
          if(ActualLinks(x2+1)(y2)==1&&dir!=2){x2+=2;a+=1;dir=1;}
          else if(ActualLinks(x2-1)(y2)==1&&dir!=1){x2-=2;a+=1;dir=2;}
          else if(ActualLinks(x2)(y2-1)==1&&dir!=3){y2-=2;a+=1;dir=4;}
        }
        else{  
          if(ActualLinks(x2+1)(y2)==1&&dir!=2){x2+=2;a+=1;dir=1;}
          else if(ActualLinks(x2-1)(y2)==1&&dir!=1){x2-=2;a+=1;dir=2;}
          else if(ActualLinks(x2)(y2+1)==1&&dir!=4){y2+=2;a+=1;dir=3;}
          else if(ActualLinks(x2)(y2-1)==1&&dir!=3){y2-=2;a+=1;dir=4;}        
          }
        }
        while (!(x2==x1 && y2==y1))
        return a;
      }
    }
    
    def LinkTotal(b:Board):Int={
    var a = 0;
      for ( i <- 0 to xLength-1) {
        for ( j <- 0 to yLength-1) {
          if(ActualLinks(i)(j)==1){
            a+=1;
          }
        }
      }
      return a;
    }
        
    
    def OneLinkCheck(b:Board):Boolean={
      val a1 = LinkTotal(b);
      if(LinkIsValid(b)){
        for ( i <- 0 to xLength-1) {
          for ( j <- 0 to yLength-1) {
            if(CheckConnection(i,j,1)==2){
              val a2 = LinkSize(i,j)
              if(a1==a2){
                return true;
              }
              if(a2!=0){
                return false;
              }
            }
          }
        }
      }
      return false;
    }
    
    
    def isValid(b:Board):Boolean={
      if(NumberIsValid(b) && OneLinkCheck(b)){
        return true;
      }
      return false;
    }
    
    def bruteForceSolution(b:Board){
      var a = 0;
      while(isValid(b)==false){
        a += 1;
        randomSolution()
      }
      println(linkPrint2(b));
      println(a+" iterations");
    }
    
    def linkPrint2(b:Board): String={
      var line="1\n"+(xLength-1)/2+"x"+(yLength-1)/2+"\n";
      for ( i <- 0 to xLength-1) {
          for ( j <- 0 to yLength-1) {
            if(i%2==0 && j%2==0){
              line+="+"
            }
            else if(i%2==1 && j%2==0 && ActualLinks(i)(j)==1){
             line+="|" 
            }
            else if(i%2==0 && j%2==1 && ActualLinks(i)(j)==1){
              line+="-"
            }
            else{
              if(ActualNumbers(i)(j)== -1){line+=" "}
              else{line+=ActualNumbers(i)(j)
                }

            }

          }
          if(i!=xLength-1){
            line+="\n";
       }
      }
      return line;
    }
   

  }
  
  val i = new Input();
  var k = 0;
     for(file <- (new File("src/Input")).listFiles.toIterator if file.isFile)
   {
    //println(file.getAbsolutePath);
    //i.matrixPrint(i.fileToArray(file.getAbsolutePath));   
    var mat = i.growMatrix(i.fileToArray(file.getAbsolutePath));
    var b = new Board(mat.length,mat(0).length);
    b.ActualNumbers = mat;
    b.r.ApplyRules();
    b.bruteForceSolution(b)
    
    var file2 = new File("test"+k +".txt");
    file2.createNewFile()
    var pw = new PrintWriter("src/Output/test"+k+".txt")
    pw.write(b.linkPrint2(b));
    pw.close()
    k+=1;    
   }  
}