

class Rules(m:Main.Board) extends App{
  
  def LinkAroundLine(x1:Int,y1:Int): Boolean ={
    if(m.PointCheck(x1,y1)==true){
      if(m.CheckConnection(x1,y1,1)==2){
        if((x1==0 && y1==0) || (x1==m.xLength-1 && y1==0) || (x1==0 && y1==m.yLength-1) || (x1==m.xLength-1 && y1==m.yLength-1)){
          return false;
        }
        else if(x1==0){
          if(m.CheckConnection(x1,y1,0)==1)return false;
          if(m.ActualLinks(x1)(y1+1)== -1){m.SetCorrectLink(x1,y1+1,0)}
          if(m.ActualLinks(x1)(y1-1)== -1){m.SetCorrectLink(x1,y1-1,0)}
          if(m.ActualLinks(x1+1)(y1)== -1){m.SetCorrectLink(x1+1,y1,0)}
          return true;
        }
        else if(y1==0){
          if(m.CheckConnection(x1,y1,0)==1)return false;
          if(m.ActualLinks(x1)(y1+1)== -1){m.SetCorrectLink(x1,y1+1,0)}
          if(m.ActualLinks(x1+1)(y1)== -1){m.SetCorrectLink(x1+1,y1,0)}
          if(m.ActualLinks(x1-1)(y1)== -1){m.SetCorrectLink(x1-1,y1,0)}
          return true; 
        }
        else if(x1==m.xLength-1){
          if(m.CheckConnection(x1,y1,0)==1)return false;
          if(m.ActualLinks(x1)(y1+1)== -1){m.SetCorrectLink(x1,y1+1,0)}
          if(m.ActualLinks(x1)(y1-1)== -1){m.SetCorrectLink(x1,y1-1,0)}
          if(m.ActualLinks(x1-1)(y1)== -1){m.SetCorrectLink(x1-1,y1,0)}
          return true;
        }
        else if(y1==m.yLength-1){
          if(m.CheckConnection(x1,y1,0)==1)return false;
          if(m.ActualLinks(x1)(y1-1)== -1){m.SetCorrectLink(x1,y1-1,0)}
          if(m.ActualLinks(x1+1)(y1)== -1){m.SetCorrectLink(x1+1,y1,0)}
          if(m.ActualLinks(x1-1)(y1)== -1){m.SetCorrectLink(x1-1,y1,0)}
          return true;
        }
        else{
          if(m.CheckConnection(x1,y1,0)==2)return false;
          if(m.ActualLinks(x1)(y1+1)== -1){m.SetCorrectLink(x1,y1+1,0)}
          if(m.ActualLinks(x1)(y1-1)== -1){m.SetCorrectLink(x1,y1-1,0)}
          if(m.ActualLinks(x1+1)(y1)== -1){m.SetCorrectLink(x1+1,y1,0)}
          if(m.ActualLinks(x1-1)(y1)== -1){m.SetCorrectLink(x1-1,y1,0)}
          return true;
        }
      }
    }
    return false;
  }
  
  def OneWay(x1:Int,y1:Int): Boolean = {
    if(m.PointCheck(x1,y1)==true && m.CheckConnection(x1, y1, 1)==1){
      if(x1==0 && y1==0){
        m.SetCorrectLink(x1+1,y1,1);
        m.SetCorrectLink(x1,y1+1,1);
      }
      else if(x1==m.xLength-1 && y1==0){
        m.SetCorrectLink(x1-1,y1,1);
        m.SetCorrectLink(x1,y1+1,1);        
      }
      else if(x1==0 && y1==m.yLength-1){
        m.SetCorrectLink(x1+1,y1,1);
        m.SetCorrectLink(x1,y1-1,1);        
      }
      else if(x1==m.xLength-1 && y1==m.yLength-1){
        m.SetCorrectLink(x1-1,y1,1);
        m.SetCorrectLink(x1,y1-1,1);        
      }
      else if(x1==0){
        if(m.CheckConnection(x1,y1,0)!=1)return false;
        if(m.ActualLinks(x1)(y1+1)== -1){m.SetCorrectLink(x1,y1+1,1)}
        if(m.ActualLinks(x1)(y1-1)== -1){m.SetCorrectLink(x1,y1-1,1)}
        if(m.ActualLinks(x1+1)(y1)== -1){m.SetCorrectLink(x1+1,y1,1)}
      }
      else if(x1==m.xLength-1){
        if(m.CheckConnection(x1,y1,0)!=1)return false;
        if(m.ActualLinks(x1)(y1+1)== -1){m.SetCorrectLink(x1,y1+1,1)}
        if(m.ActualLinks(x1)(y1-1)== -1){m.SetCorrectLink(x1,y1-1,1)}
        if(m.ActualLinks(x1-1)(y1)== -1){m.SetCorrectLink(x1-1,y1,1)}
      }
      else if(y1==0){
        if(m.CheckConnection(x1,y1,0)!=1)return false;
        if(m.ActualLinks(x1)(y1+1)== -1){m.SetCorrectLink(x1,y1+1,1)}
        if(m.ActualLinks(x1+1)(y1)== -1){m.SetCorrectLink(x1+1,y1,1)}
        if(m.ActualLinks(x1-1)(y1)== -1){m.SetCorrectLink(x1-1,y1,1)}
      }
      else if(x1==m.yLength-1){
        if(m.CheckConnection(x1,y1,0)!=1)return false;
        if(m.ActualLinks(x1)(y1-1)== -1){m.SetCorrectLink(x1,y1-1,1)}
        if(m.ActualLinks(x1+1)(y1)== -1){m.SetCorrectLink(x1+1,y1,1)}
        if(m.ActualLinks(x1-1)(y1)== -1){m.SetCorrectLink(x1-1,y1,1)}
      }
      
      else{
        if(m.CheckConnection(x1,y1,0)!=2)return false;
        if(m.ActualLinks(x1)(y1+1)== -1){m.SetCorrectLink(x1,y1+1,1)}
        if(m.ActualLinks(x1)(y1-1)== -1){m.SetCorrectLink(x1,y1-1,1)}
        if(m.ActualLinks(x1+1)(y1)== -1){m.SetCorrectLink(x1+1,y1,1)}
        if(m.ActualLinks(x1-1)(y1)== -1){m.SetCorrectLink(x1-1,y1,1)}
      }
    }
    return false;
  }
  
  def DeadEnd(x1:Int,y1:Int): Boolean = {            
    if(m.PointCheck(x1,y1)==true){
      if(x1==0 && y1==0){
        if(m.CheckConnection(x1,y1,0)!=1)return false;
        m.SetCorrectLink(x1,y1+1,0);
        m.SetCorrectLink(x1+1,y1,0);
        return true;
      }
      else if(x1==m.xLength-1 && y1==0){
        if(m.CheckConnection(x1,y1,0)!=1)return false;
        m.SetCorrectLink(x1,y1+1,0);
        m.SetCorrectLink(x1-1,y1,0);
        return true;
      }
      else if(x1==0 && y1==m.yLength-1){
        if(m.CheckConnection(x1,y1,0)!=1)return false;
        m.SetCorrectLink(x1,y1-1,0);
        m.SetCorrectLink(x1+1,y1,0);
        return true;
      }
      else if(x1==m.xLength-1 && y1==m.yLength-1){
        if(m.CheckConnection(x1,y1,0)!=1)return false;
        m.SetCorrectLink(x1,y1-1,0);
        m.SetCorrectLink(x1-1,y1,0);
        return true;
      }
      
      else if(x1==0){
        if(m.CheckConnection(x1,y1,0)!=2)return false;
        m.SetCorrectLink(x1,y1+1,0)
        m.SetCorrectLink(x1,y1-1,0)
        m.SetCorrectLink(x1+1,y1,0)
        return true;
      }
      else if(y1==0){
        if(m.CheckConnection(x1,y1,0)!=2)return false;
        m.SetCorrectLink(x1,y1+1,0)
        m.SetCorrectLink(x1+1,y1,0)
        m.SetCorrectLink(x1-1,y1,0)
        return true; 
      }
      else if(x1==m.xLength-1){
        if(m.CheckConnection(x1,y1,0)!=2)return false;
        m.SetCorrectLink(x1,y1+1,0)
        m.SetCorrectLink(x1,y1-1,0)
        m.SetCorrectLink(x1-1,y1,0)
        return true;
      }
      else if(y1==m.yLength-1){
        if(m.CheckConnection(x1,y1,0)!=2)return false;
        m.SetCorrectLink(x1,y1-1,0)
        m.SetCorrectLink(x1+1,y1,0)
        m.SetCorrectLink(x1-1,y1,0)
        return true;
      }
      else{
        if(m.CheckConnection(x1,y1,0)!=3)return false;
        m.SetCorrectLink(x1,y1+1,0)
        m.SetCorrectLink(x1,y1-1,0)
        m.SetCorrectLink(x1+1,y1,0)
        m.SetCorrectLink(x1-1,y1,0)
        return true;
      }
    }
    return false;
  }

  def FillLines(x1:Int,y1:Int): Boolean={
    if(m.NumberCheck(x1,y1)==true){
      var a=0;
      if(m.ActualLinks(x1+1)(y1)==0){ a+=1; }
      if(m.ActualLinks(x1-1)(y1)==0){ a+=1; }
      if(m.ActualLinks(x1)(y1+1)==0){ a+=1; }
      if(m.ActualLinks(x1)(y1-1)==0){ a+=1; }
      
      if(4-a==m.ActualNumbers(x1)(y1) && ((m.ActualLinks(x1+1)(y1)== -1)||(m.ActualLinks(x1-1)(y1)== -1)||(m.ActualLinks(x1)(y1+1)== -1)||(m.ActualLinks(x1)(y1-1)== -1))){
        
        if(m.ActualLinks(x1+1)(y1)== -1){
          m.SetCorrectLink(x1+1,y1,1); }
        if(m.ActualLinks(x1-1)(y1)== -1){
          m.SetCorrectLink(x1-1,y1,1); }
        if(m.ActualLinks(x1)(y1+1)== -1){
          m.SetCorrectLink(x1,y1+1,1); }
        if(m.ActualLinks(x1)(y1-1)== -1){
          m.SetCorrectLink(x1,y1-1,1); }
        return true;
       }
    }
    return false;
  }
  
    def FillBlanks(x1:Int,y1:Int):Boolean ={
    if(m.NumberCheck(x1,y1)==true){
      var a=0;
      if(m.ActualLinks(x1+1)(y1)==1){ a+=1; }
      if(m.ActualLinks(x1-1)(y1)==1){ a+=1; }
      if(m.ActualLinks(x1)(y1+1)==1){ a+=1; }
      if(m.ActualLinks(x1)(y1-1)==1){ a+=1; }
      if(a==m.ActualNumbers(x1)(y1) && ((m.ActualLinks(x1+1)(y1)== -1)||(m.ActualLinks(x1-1)(y1)== -1)||(m.ActualLinks(x1)(y1+1)== -1)||(m.ActualLinks(x1)(y1-1)== -1))){
        if(m.ActualLinks(x1+1)(y1)== -1){
          m.SetCorrectLink(x1+1,y1,0); }
        if(m.ActualLinks(x1-1)(y1)== -1){
          m.SetCorrectLink(x1-1,y1,0); }
        if(m.ActualLinks(x1)(y1+1)== -1){
          m.SetCorrectLink(x1,y1+1,0); }
        if(m.ActualLinks(x1)(y1-1)== -1){
          m.SetCorrectLink(x1,y1-1,0); }
        return true;
       }
    }
    return false;
  }
  
  
  def OneInCorner(){
    if(m.ActualNumbers(1)(1)==1){
        m.SetCorrectLink(1,0,0)
        m.SetCorrectLink(0,1,0)
      }
      if(m.ActualNumbers(m.xLength-2)(1)==1){
        m.SetCorrectLink(m.xLength-2,0,0)
        m.SetCorrectLink(m.xLength-1,1,0)
      }
      if(m.ActualNumbers(1)(m.yLength-2)==1){
        m.SetCorrectLink(1,m.yLength-1,0)
        m.SetCorrectLink(0,m.yLength-2,0)
      }
      if(m.ActualNumbers(m.xLength-2)(m.yLength-2)==1){
        m.SetCorrectLink(m.xLength-2,m.yLength-1,0)
        m.SetCorrectLink(m.xLength-1,m.yLength-2,0)
      }
      return;
  }
  
  def TwoInCorner(){
      if(m.ActualNumbers(1)(1)==2){
        m.SetCorrectLink(3,0,1)
        m.SetCorrectLink(0,3,1)
      }
      if(m.ActualNumbers(m.xLength-2)(1)==2){
        m.SetCorrectLink(m.xLength-4,0,1)
        m.SetCorrectLink(m.xLength-1,3,1)
      }
      if(m.ActualNumbers(1)(m.yLength-2)==2){
        m.SetCorrectLink(3,m.yLength-1,1)
        m.SetCorrectLink(0,m.yLength-4,1)
      }
      if(m.ActualNumbers(m.xLength-2)(m.yLength-2)==2){
        m.SetCorrectLink(m.xLength-4,m.yLength-1,1)
        m.SetCorrectLink(m.xLength-1,m.yLength-4,1)
      }
      return;
  }
  
   def ThreeInCorner(){
      if(m.ActualNumbers(1)(1)==3){
        m.SetCorrectLink(1,0,1)
        m.SetCorrectLink(0,1,1)
      }
      if(m.ActualNumbers(m.xLength-2)(1)==3){
        m.SetCorrectLink(m.xLength-2,0,1)
        m.SetCorrectLink(m.xLength-1,1,1)
      }
      if(m.ActualNumbers(1)(m.yLength-2)==3){
        m.SetCorrectLink(1,m.yLength-1,1)
        m.SetCorrectLink(0,m.yLength-2,1)
      }
      if(m.ActualNumbers(m.xLength-2)(m.yLength-2)==3){
        m.SetCorrectLink(m.xLength-2,m.yLength-1,1)
        m.SetCorrectLink(m.xLength-1,m.yLength-2,1)
      }
      return;
    }
   
    def zeroLinks(x1:Int,y1:Int){
      if(m.ActualNumbers(x1)(y1)==0){
        m.SetCorrectLink(x1,y1+1,0)
        m.SetCorrectLink(x1,y1-1,0)
        m.SetCorrectLink(x1+1,y1,0)
        m.SetCorrectLink(x1-1,y1,0)
      }
    }
    
    def AdjacentThrees1(x1:Int,y1:Int){
      if(x1<m.xLength-2){
        if(m.ActualNumbers(x1)(y1)==3 && m.ActualNumbers(x1+2)(y1)==3){
          m.SetCorrectLink(x1-1,y1,1)
          m.SetCorrectLink(x1+1,y1,1)
          m.SetCorrectLink(x1+3,y1,1)
          if(y1>1)            m.SetCorrectLink(x1+1,y1-2,0)
          if(y1<m.yLength-2)  m.SetCorrectLink(x1+1,y1+2,0)
        }
      }
    }
    
    def AdjacentThrees2(x1:Int,y1:Int){
      if(y1<m.yLength-2){
        if(m.ActualNumbers(x1)(y1)==3 && m.ActualNumbers(x1)(y1+2)==3){
          m.SetCorrectLink(x1,y1-1,1)
          m.SetCorrectLink(x1,y1+1,1)
          m.SetCorrectLink(x1,y1+3,1)
          if(x1>1)            m.SetCorrectLink(x1-2,y1+1,0)
          if(x1<m.xLength-2)  m.SetCorrectLink(x1+2,y1+1,0)
        }
      }
    }
    
    def DiagonalOnes_1_1(x1:Int,y1:Int):Boolean ={             //fix alt ===>
      if(x1<m.xLength-2 && y1<m.yLength-2){
        if(m.ActualNumbers(x1)(y1)==1 && m.ActualNumbers(x1+2)(y1+2)==1 
            && m.ActualLinks(x1+1)(y1)==0 && m.ActualLinks(x1)(y1+1)==0){
          m.SetCorrectLink(x1+1,y1+2,0)
          m.SetCorrectLink(x1+2,y1+1,0)
          return true;
        }
      }
      return false;
    }
    
    def DiagonalOnes_1_2(x1:Int,y1:Int):Boolean ={
      if(x1<m.xLength-2 && y1>1){
        if(m.ActualNumbers(x1)(y1)==1 && m.ActualNumbers(x1+2)(y1-2)==1 
            && m.ActualLinks(x1+1)(y1)==0 && m.ActualLinks(x1)(y1-1)==0){
          m.SetCorrectLink(x1+1,y1-2,0)
          m.SetCorrectLink(x1+2,y1-1,0)
          return true;
        }
      }
      return false;
    }
    
    def DiagonalOnes_2_1(x1:Int,y1:Int):Boolean ={
      if(x1<m.xLength-2 && y1<m.yLength-2){
        if(m.ActualNumbers(x1)(y1)==1 && m.ActualNumbers(x1+2)(y1+2)==1 
            && m.ActualLinks(x1-1)(y1)==0 && m.ActualLinks(x1)(y1-1)==0){
          m.SetCorrectLink(x1+3,y1+2,0)
          m.SetCorrectLink(x1+2,y1+3,0)
          return true;
        }
      }
      return false;
    }
    
    def DiagonalOnes_2_2(x1:Int,y1:Int): Boolean ={
      if(x1<m.xLength-2 && y1>1){
        if(m.ActualNumbers(x1)(y1)==1 && m.ActualNumbers(x1+2)(y1-2)==1 
            && m.ActualLinks(x1-1)(y1)==0 && m.ActualLinks(x1)(y1+1)==0){
          m.SetCorrectLink(x1+3,y1-2,0)
          m.SetCorrectLink(x1+2,y1-3,0)
          return true;
        }
      }
      return false;
    }    
    
    
    def DiagonalThrees1(x1:Int,y1:Int){
      if(x1<m.xLength-2 && y1<m.yLength-2){
         if(m.ActualNumbers(x1)(y1)==3 && m.ActualNumbers(x1+2)(y1+2)==3){
           m.SetCorrectLink(x1-1,y1,1)
           m.SetCorrectLink(x1,y1-1,1)
           m.SetCorrectLink(x1+3,y1+2,1)
           m.SetCorrectLink(x1+2,y1+3,1)
         }
      }
    }
    
    def DiagonalThrees2(x1:Int,y1:Int){
      if(x1<m.xLength-2 && y1>1){
         if(m.ActualNumbers(x1)(y1)==3 && m.ActualNumbers(x1+2)(y1-2)==3){
           m.SetCorrectLink(x1-1,y1,1)
           m.SetCorrectLink(x1,y1+1,1)
           m.SetCorrectLink(x1+3,y1-2,1)
           m.SetCorrectLink(x1+2,y1-3,1)
         }
      }
    }
    
    
    
    def DualDiagonalThrees1(x1:Int,y1:Int){
      if(y1>=3 && y1<=m.yLength-4 && x1<=m.yLength-4){
        if(m.ActualNumbers(x1)(y1)==3 && m.ActualNumbers(x1+2)(y1-2)==3 && m.ActualNumbers(x1+2)(y1+2)==3){
          m.SetCorrectLink(x1-1,y1,1)
          m.SetCorrectLink(x1+1,y1,0)
          m.SetCorrectLink(x1,y1-1,1)
          m.SetCorrectLink(x1,y1+1,1)
          m.SetCorrectLink(x1+1,y1-2,0)
          m.SetCorrectLink(x1+3,y1-2,1)
          m.SetCorrectLink(x1+2,y1-1,1)
          m.SetCorrectLink(x1+2,y1-3,1)
          m.SetCorrectLink(x1+1,y1+2,0)
          m.SetCorrectLink(x1+3,y1+2,1)
          m.SetCorrectLink(x1+2,y1+1,1)
          m.SetCorrectLink(x1+2,y1+3,1)
          m.SetCorrectLink(x1+3,y1,0)
          m.SetCorrectLink(x1-1,y1-2,0)
          m.SetCorrectLink(x1-1,y1+2,0)
          m.SetCorrectLink(x1-2,y1-1,0)
          m.SetCorrectLink(x1-2,y1+1,0)
        }
      }
    }
  
    def DualDiagonalThrees2(x1:Int,y1:Int){
      if(x1>=3 && x1<=m.yLength-4 && y1<=m.yLength-4){
        if(m.ActualNumbers(x1)(y1)==3 && m.ActualNumbers(x1-2)(y1+2)==3 && m.ActualNumbers(x1+2)(y1+2)==3){
          m.SetCorrectLink(x1,y1-1,1)
          m.SetCorrectLink(x1,y1+1,0)
          m.SetCorrectLink(x1-1,y1,1)
          m.SetCorrectLink(x1+1,y1,1)
          m.SetCorrectLink(x1-2,y1+1,0)
          m.SetCorrectLink(x1-2,y1+3,1)
          m.SetCorrectLink(x1-1,y1+2,1)
          m.SetCorrectLink(x1-3,y1+2,1)
          m.SetCorrectLink(x1+2,y1+1,0)
          m.SetCorrectLink(x1+2,y1+3,1)
          m.SetCorrectLink(x1+1,y1+2,1)
          m.SetCorrectLink(x1+3,y1+2,1)
          m.SetCorrectLink(x1,y1+3,0)
          m.SetCorrectLink(x1-2,y1-1,0)
          m.SetCorrectLink(x1+2,y1-1,0)
          m.SetCorrectLink(x1-1,y1-2,0)
          m.SetCorrectLink(x1+1,y1-2,0)
        }
      }
    }
  
      def DualDiagonalThrees3(x1:Int,y1:Int){
      if(y1>=3 && y1<=m.yLength-4 && x1>=3){
        if(m.ActualNumbers(x1)(y1)==3 && m.ActualNumbers(x1-2)(y1-2)==3 && m.ActualNumbers(x1-2)(y1+2)==3){
          m.SetCorrectLink(x1+1,y1,1)
          m.SetCorrectLink(x1-1,y1,0)
          m.SetCorrectLink(x1,y1-1,1)
          m.SetCorrectLink(x1,y1+1,1)
          m.SetCorrectLink(x1-1,y1-2,0)
          m.SetCorrectLink(x1-3,y1-2,1)
          m.SetCorrectLink(x1-2,y1-1,1)
          m.SetCorrectLink(x1-2,y1-3,1)
          m.SetCorrectLink(x1-1,y1+2,0)
          m.SetCorrectLink(x1-3,y1+2,1)
          m.SetCorrectLink(x1-2,y1+1,1)
          m.SetCorrectLink(x1-2,y1+3,1)
          m.SetCorrectLink(x1-3,y1,0)
          m.SetCorrectLink(x1+1,y1-2,0)
          m.SetCorrectLink(x1+1,y1+2,0)
          m.SetCorrectLink(x1+2,y1-1,0)
          m.SetCorrectLink(x1+2,y1+1,0)
        }
      }
    }
      
     def DualDiagonalThrees4(x1:Int,y1:Int){
      if(x1>=3 && x1<=m.yLength-4 && y1>=3){
        if(m.ActualNumbers(x1)(y1)==3 && m.ActualNumbers(x1-2)(y1-2)==3 && m.ActualNumbers(x1+2)(y1-2)==3){
          m.SetCorrectLink(x1,y1+1,1)
          m.SetCorrectLink(x1,y1-1,0)
          m.SetCorrectLink(x1-1,y1,1)
          m.SetCorrectLink(x1+1,y1,1)
          m.SetCorrectLink(x1-2,y1-1,0)
          m.SetCorrectLink(x1-2,y1-3,1)
          m.SetCorrectLink(x1-1,y1-2,1)
          m.SetCorrectLink(x1-3,y1-2,1)
          m.SetCorrectLink(x1+2,y1-1,0)
          m.SetCorrectLink(x1+2,y1-3,1)
          m.SetCorrectLink(x1+1,y1-2,1)
          m.SetCorrectLink(x1+3,y1-2,1)
          m.SetCorrectLink(x1,y1-3,0)
          m.SetCorrectLink(x1-2,y1+1,0)
          m.SetCorrectLink(x1+2,y1+1,0)
          m.SetCorrectLink(x1-1,y1+2,0)
          m.SetCorrectLink(x1+1,y1+2,0)
        }
      }
    }
  
  
def ApplyRules(){
    OneInCorner();
    TwoInCorner();                         //ting som kun skjer i hjørnet
    ThreeInCorner();
    for (i <- 0 to m.xLength-1) {
      for ( j <- 0 to m.yLength-1) {
        if(m.NumberCheck(i,j)==true){
          zeroLinks(i,j)
          DiagonalThrees1(i,j)
          DiagonalThrees2(i,j)
          DualDiagonalThrees1(i,j)                //ting som skjer hvor som helst 
          DualDiagonalThrees2(i,j)                //skjer bare 1 gang siden det kun er avhengig av nummer
          DualDiagonalThrees3(i,j)
          DualDiagonalThrees4(i,j)
          AdjacentThrees1(i,j)
          AdjacentThrees2(i,j)
          }
        }        
      }
    var changed = true
    while(changed==true){
      changed=false;
      for (i <- 0 to m.xLength-1) {
        for ( j <- 0 to m.yLength-1) {
            
            if(m.NumberCheck(i,j)==true){
              if(FillLines(i,j)==true){changed=true}
              if(FillBlanks(i,j)==true){changed=true}                    //trenger flere sjekker siden de er avhengige
              //if(DiagonalOnes_1_1(i,j)==true){DiagonalOnes_1_1(i,j);changed=true}
              //if(DiagonalOnes_1_2(i,j)==true){changed=true}
              //if(DiagonalOnes_2_1(i,j)==true){changed=true}
              //if(DiagonalOnes_2_2(i,j)==true){changed=true}
            }
            if(m.PointCheck(i,j)==true){
              if(LinkAroundLine(i,j)==true){changed=true}
              if(DeadEnd(i,j)==true){changed=true}
              if(OneWay(i,j)==true){changed=true}              
          }
        }
      }
    }
  }
}