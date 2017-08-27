import scala.Array._
import scala.io._
import java.io.File 

class Input(){
  def fileToArray(fName:String): Array[Array[Int]] = {
  //var fName = "test.txt"
  var n=(0)
  for(line <- Source.fromFile(fName).getLines().slice(1,2))
  {

    val k =line.split("x")
    
    n = k(0).toString.toInt
  }

  var l:List[Char] =  List();
  for(line <- Source.fromFile(fName).getLines().slice(2,n+2))
  {
    val n2 = line.split(" ")
    val n3=n2.mkString

    for(k <- n3)
      {
       l = l   :+ k
      }
  }  
 var myMatrix = ofDim[Int](n,n)

 
 for (i <- 0 until  n)
    {
      for ( j <- 0 until  n)
      {
        myMatrix(i)(j) = -1;
        
      }
    }

    for (i <- 0 until  n)
    {
      for ( j <- 0 until  n)
      {
        val c1 = l(i*n+j).toString
        if(c1!="*"){
          val c2 = Integer.parseInt(c1)
          myMatrix(i)(j) = c2;
        }
      }
    }
    
   
  

      return myMatrix;
  }
  
  def growMatrix(mat:Array[Array[Int]]): Array[Array[Int]] = {
    var mat2 = ofDim[Int](2*mat.length+1,2*mat(0).length+1)
    for (i <- 0 until  mat2.length){
      for ( j <- 0 until  mat2(0).length){
        mat2(i)(j)= -1;
      }
    } 
    
    for (i <- 0 until  mat.length){
      for ( j <- 0 until  mat(0).length){
        mat2(2*i+1)(2*j+1) = mat(i)(j);
      }
    }
    return mat2;
  }
  
  
  def matrixPrint(a:Array[Array[Int]]){
        for (i <- 0 until  a.length)
    {
      var matrixline="";  
      for ( j <- 0 until  a(0).length)
      {
        
        matrixline += "    "+a(i)(j).toString;
      }
      println(matrixline);
    }

  }
  
/*   for(file <- (new File("src/Input")).listFiles.toIterator if file.isFile)
   {
    //println(file.getAbsolutePath);
    matrixPrint(fileToArray(file.getAbsolutePath));
  }*/
}