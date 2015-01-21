color pallete[]={color(255, 0, 0),color(0, 255, 0),color(0, 0, 255),color(0, 0, 0)};//rgb black
int nxTerm;
int poz[][]={{0,0},{300,0},{0,300},{300,300}};
int spoz[][]={{0,150},{400,150}};
char swap[]= {
  0, 0
};
char visited[]= {
  0, 0, 0, 0
};
char term[][]=new char[4][2];
char indi[]= {
  0, 0, 0, 0
};  //index is color value is terminal
//char schD[]=new schD;  //values: 0 1 or 2, access by CT%2
//char schP[2];
char threshold=10000;
char RED=0, GREEN=1, BLUE=2, BLACK=3, EMPTY=4;
char CT=0;
char adjCount=0, farCount=0,i;
int arm[]={0,0};

void make(int CT,int side,int col)
{
  fill(pallete[col]);
  rect(poz[CT-1][0]+side*20,poz[CT-1][1],30,30);
}
void smake(int CT,int col)
{
   fill(pallete[col]);
  rect(spoz[CT-1][0],spoz[CT-1][1],30,30);
}
void setup()
{
  size(displayWidth,displayHeight);
  for(i=1;i<5;i++)
  {
    make(i,0,color(255));
    make(i,1,color(255));
  }
  for(i=1;i<3;i++)
  {
    smake(i,color(255));
    smake(i,color(255));
  }
  //fill()
  //fill colors
}
void draw()
{
}
//CODE------------------------
//=======================

char adjC()
{

  if (CT==1)
    return 2;
  if (CT==2)
    return 1;
  if (CT==3)
    return 4;
  if (CT==4)
    return 3;
  else return 0;
}
void travel(int CT, int nxTerm)
{

//  forwardJaa();
  //dist+=1
  //swapEncounterdAction
  
  if ((CT==1 && (nxTerm == 3 || nxTerm== 4)) || (CT==4 && (nxTerm == 1 || nxTerm== 2)))
  {
  //  forwardJaa();
   // forwardJaa();
    //swap
    
   } else if ((CT==2 && (nxTerm == 3 || nxTerm== 4)) || (CT==3 && (nxTerm == 1 || nxTerm== 2)))
  {
    
    //forwardJaa();
    //forwardJaa();
    //swapEncounterdAction
  } else
  {
  }
  //forwardJaa();
}
void pick_color( char node)  //0 or 1
{
  //read_color();
  visited[CT]=1;
}
void counter()
{
  //solveNode //v r inside d term wid one box of its color and an empty arm and MAYBE 1 box at sort
  adjCount=0;
  farCount=0;
  char adj=adjC();
  //belongs to near
  if (indi[CT]==term[adj][0])
    adjCount++;

  if (indi[CT]==term[adj][1])
    adjCount++;

  //belongs to far
  if (!(indi[CT]==term[CT][0] && indi[adj]==term[CT][0]))
    farCount++;

  if (!(indi[CT]==term[CT][1] && indi[adj]==term[CT][1]))
    farCount++;
}
int unvisited()
{
  for (i=1; i<=4; i++)
    if (visited[i]==0)
      return i;
  return 0;
}
void place(char term,int side,int col)
{
  make(term,side,col);
}
void grip(int side,int col)
{
  arm[side]=col;
}
void drop(int side)
{
  
}
void swapMan(char here)
{
  
  if(swap[here]==indi[nxTerm])  
  {
    
    if(CT%2==nxTerm%2) /*same side*/
    {
      if(((arm[1]==0 && arm[0]==0) || (term[nxTerm][0]==0 || term[nxTerm][1]==0))) //empty arm or empty block
        pickup(0,1);
    }
    else if(((arm[1]==0 && arm[0]==0) || (term[nxTerm][0]==0 || term[nxTerm][1]==0)) || swap[nxTerm]==0)  //or even an empty space
      pickup(0,1);
  }
  else if(CT%2!=nxTerm%2)
  {
    if(((arm[1]==0 && arm[0]==0) || (term[nxTerm][0]==0 || term[nxTerm][1]==0)) || swap[nxTerm]==0)
      pickup(0,1);
  }
}
int pickup(int side,int mode)
{  
  if(mode==1)
   {
     smake(CT,4);
     if(arm[side]==0)
     {
       place(CT,side,0);  //place color at that poz
       grip(side,4);
       return 1;
     }
     else if(arm[(side+1)%2]==0)
     {
       place(CT,side,0);  //place color at that poz
       grip((side+1)%2,4);
       return 1;
     }
   }
   //swap
    
  if(arm[side]==0)
  {
    if(term[CT][side]!=indi[CT])
    {
      place(CT,side,0);  //place color at that poz
      grip(side,term[CT][side]);  //plae color at arm
      return 1;
    }
  }
  else if(arm[(side+1)%2]==0)
  {
    if(term[CT][side]!=indi[CT])
    {
      //rotate 90deg;
      place(CT,(side+1)%2,0);
      grip(side,term[CT][(side+1)%2]);
      return 1;
    }
  }
  return 0;
}
void placeBot(int x,int y)
{
  ellipse(x+50,y,20,20);
}
void gotoSort( char CT)
{
  placeBot(spoz[CT%2][0],spoz[CT%2][1]);
}

void goBack( char CT)
{
  assert(!"The method or operation is not implemented.");
}


//SORTMAN
//MAIN SORTING FUNCTION
//R-0 L-1
void sortMan()
{
  char nxTerm;

  int pSwap=((CT==2||CT==3)?1:0);
  int pFar=(term[CT][0]==indi[adj]);    //wont work for empty node
  if (Sort[CT]==indi[CT])
  {
    if (farCount==2)
    {
      if (term[CT][0]==term[CT][1])
        nxTerm=indi[term[CT][0]]; //the common terminal
      else  //both diff of far
      nxTerm=indi[term[CT][0]];
      pickup(0);
      drop(0);
      gotoSort(CT);
      pickup(pSwap);
      drop(pSwap);
      goBack(CT);
      pickup(1);
      drop(1);
      //SchPickupAtSort  //CT
      //SchDropAtSort    //far
    } else if (farCount==1)
    {
      if (adjCount==1)
      {
        nxTerm=adj;
        pickup(pFar);
        drop(pFar);
        gotoSort(CT);
        pickup(pSwap);
        drop(pSwap);
        goBack(CT);
        pickup((pFar+1)%2);
        drop((pFar+1)%2);
        //nothing to schedule
      } else
      {  //empty node
        //:O :O
        if (vis[adj]==0)
          nxTerm=adj;

        else  //seq also usable for both empty
        {
          nxTerm=far;
          pickup(pFar);
          drop(pFar);
          gotoSort(CT);
          pickup(pSwap);
          goBack(CT);
          drop((pFar+1)%2);
        }
      }
    } else if (adjCount==1)
    {
      if (farCount==1)
      {
        nxTerm=adj;
        pickup(pFar);
        drop(pFar);
        gotoSort(CT);
        pickup(pSwap);
        drop(pSwap);
        goBack(CT);
        pickup((pFar+1)%2);
        drop((pFar+1)%2);
        //nothing to schedule
      } else
      {
        //empty node
        drop(pFar);
        gotoSOrt(CT);
        pickup(pSwap);
        goBack(CT);
        pickup((pFar+1)%2);
        drop((pFar+1)%2);
        nxTerm=adj;
      }
    } else if (adjCount==2)
    {
      nxTerm=adj;
      pickup(0);
      drop(0);
      gotoSort(CT);
      pickup(pSwap);
      drop(pSwap);
      goBack(CT);
      pickup(1);
      drop(1);
    }
    if (arm[0]==0 && arm[1]==0)
    {
      travel(CT, nxTerm);
      sortNoSwap();
    } else
    {
      travel(CT, nxTerm);
      sortMan();
    }
  } else if (Sort[CT]!=indi[CT])  //Sort can be empty
  {
    if (farCount==2)
    {
      if (term[CT][0]==term[CT][1])  //and sort not empty why ?? :/
      {
        nxTerm=indi[term[CT][0]]; //the common terminal
        //SchPickupAtSort
        //SchDropAtSort
        pickup(0);
        drop(0);
        pickup(1);
        drop(1);
      } else if (Sort[CT]==term[CT][0])
      {
        pickup(0);
        drop(0);
        nxTerm=indi[arm[0]];
      } else if (Sort[CT]==term[CT][1])
      {
        pickup(1);
        drop(1);
        nxTerm=indi[arm[1]];
      }
    } else if (farCount==1)
    {
      if (adjCount==1)
      {
        if (Sort[CT]==0)
        {
          pickup((pFar+1)%2); //adjwala
          drop((pFar+1)%2);
          pickup(pFar);
          nxTerm=adj;
          //SchDropAtSort
        } else
        {
          //Sort of far and CT has 1 far a adj
          pickup((pFar+1)%2);
          drop((pFar+1)%2);
          nxTerm=adj;
        }
      } else  //====
      {  //one node is empty
        nxTerm=indi[term[CT][pFar]];
        pickup(pFar);
        drop(pFar);
        //SchDropAtSort
      }
    } else if (adjCount==1)
    {
      if (farCount==1)
      {
        if (Sort[CT]==0)
        {
          pickup((pFar+1)%2); //adjwala
          drop((pFar+1)%2);
          pickup(pFar);
          nxTerm=adj;
          //SchDropAtSort
        } else
        {
          //Sort of far and CT has 1 far a adj
          pickup((pFar+1)%2);
          drop((pFar+1)%2);
          nxTerm=adj;
        }
      } else  //1 empty 1 adj
      {
        pickup
          drop
          nxTerm=adj;
      }
    } else if (adjCount==2)
    {
      if (Sort[CT]>0) //smthin is at Sort
      {
        pickup(0);
        drop(0);
      } else
      {
        pickup(0);
        drop(0);
        pickup(1);
      }
      nxTerm=adj;
    } else    //empty
    {
      drop(0);
      drop(1);
      nxTerm=unvisited();
      if (nxTerm==0)
      {
        if (checkForCompletion())
        {
          //Exit Sequence
        }
      }
    }
  }
  if (arm[0]==0 && arm[1]==0)
  {
    travel(CT, nxTerm);
    sortNoSwap();
  } else
  {
    travel(CT, nxTerm);
    sortMan();
  }
}
void sortNoSwap()
{
  counter();
  if (farCount==2)
  {
    nxTerm=indi[arm[0]];
    SchDropAtSort(nxTerm);
  } else if (adjCount==1)
  {
    if (farCount==1)
    {
      nxTerm=adj;
      SchDropAtSort(nxTerm);
    } else  //1 empty block
    {
      pickup;
      nxTerm=adj;
    }
  } else if (farCount==1)
  {
    if (adjCount==1)
    {
      nxTerm=adj;
      SchDropAtSort(nxTerm);
    } else  //1 empty block
    {
      if (visited[adj]==0)
      {
        nxTerm=adj;
        SchDropAtSort(nxTerm);
      } else
      {
        nxTerm=arm[0];
      }
    }
  } else if (adjCount==2)
  {
    nxTerm=adj;
    SchDropAtSort(nxTerm);
  } else  //empty term
  {
    if (visited[adj]==0)
      nxTerm=adj;
    else
      unvisited();
  }
  if (arm[0]==0 && arm[1]==0)
  {
    travel(CT, nxTerm);
    sortNoSwap();
  } else
  {
    travel(CT, nxTerm);
    sortMan();
  }
}

void sorter()
{
  pickUp(0);
  pickUp(1);
  sortNoSwap();
}

