import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
   @author Vinit Jain, Mumbai, India - +917666601601 , connect@technovadors.in
   #Note : Uncomment all the System.out.println statements to understand and trace the snake's path to hit the max score
*/

public class Main 
{
    public static void main(String[] args)
    {
        Start letsBegin=new Start();     
    }
   
        static class Start
        {
                private int[][] ground;
                private int rows,columns;
                private int[] terminalMaxScores;    
                ArrayList<Integer> scoreList;

                //jeff opens the game here
                public Start()
                {
                    takeInput();
                       System.out.println("\n\n");
                    if(isReachable())
                    {
                        calculateTerminalMaxScores();

                         System.out.println("Input Grid");
                         System.out.println(Arrays.deepToString(ground));
                         System.out.println("Max Terminal Scores");
                       
                        //This will print the max scores of all terminals
                        for(int i=0;i<terminalMaxScores.length;i++)
                        {
                             System.out.println(i+" : "+terminalMaxScores[i]);
                        }
                       
                         System.out.println("\n\n");
                       
                        if(columns==1)
                        {
                            Arrays.sort(terminalMaxScores);
                            System.out.println(terminalMaxScores[terminalMaxScores.length-1]);
                        }
                        else startPlaying();
                    }
                    else
                    {
                        System.out.println("-1");
                    }
                }

                //this method checks wether the snake can reach the right most cell or not , so he can start playing the game else it's waste of time
                private boolean isReachable()
                {
                    boolean reachable=false;
                    for(int i=0;i<columns;i++)
                        {
                            reachable=false;
                            for(int j=0;j<rows;j++)
                            {
                                if(ground[j][i]!=-1)
                                {
                                    reachable=true;
                                }
                            }

                            if(!reachable)
                            break;
                        }
                    return reachable;
                }
        
                //This is where Jeff Starts Analysing the score grid to get the max score possible
                private void startPlaying()
                {   
                    //This will find number of possible start points from left boundary
                    ArrayList<Integer> startPoints=new ArrayList<>();
                    for(int i=0;i<ground.length;i++)
                    {
                        if(ground[i][0]!=-1)
                        {
                            startPoints.add(i);
                        }
                    }
                    scoreList=new ArrayList<>();
                    for(int i=0;i<startPoints.size();i++)
                    {
                         System.out.println("Start Point : "+startPoints.get(i));
                        getAllPossibleEndPaths(startPoints.get(i),0,startPoints.get(i),0,0,0,0);
                    }

                    Collections.sort(scoreList);
                    System.out.println(scoreList.get(scoreList.size()-1));
                }
        
                //this method gets all possible end paths from a particular cell with the score
                private void getAllPossibleEndPaths(int row,int column,int fromRow,int fromColumn,int scoreTillYet,int upCounter,int downCounter)
                {
                     System.out.print("\tCame to "+row+","+column+" from "+fromRow+","+fromColumn+" with score "+scoreTillYet);

                    if(isTerminal(column))
                    {
                        int score=scoreTillYet;
                        if(row==rows-1)
                        {
                            if(getScore(row-1, column)==-1)
                            {
                                int score1=score+getScore(row, column);
                                int score2=terminalMaxScores[row];

                                if(score1<score2)
                                {
                                     System.out.println("Reached Terminal @score "+score2);
                                    scoreList.add(score2);
                                }
                                else 
                                {
                                     System.out.println("Reached Terminal @score "+score1);
                                    scoreList.add(score1);
                                }
                            }
                            else 
                            {
                                  System.out.println("Reached Teeminal @score "+(score+terminalMaxScores[row]));
                                scoreList.add(score+terminalMaxScores[row]);
                            }
                        }
                        else if(row==0)
                        {
                            if(getScore(row+1, column)==-1)
                            {
                                int score1=score+getScore(row, column);
                                int score2=terminalMaxScores[row];

                                if(score1<score2)
                                {
                                     System.out.println("Reached Terminal @score "+score2);
                                    scoreList.add(score2);
                                }
                                else 
                                {
                                     System.out.println("Reached Terminal @score "+score1);
                                    scoreList.add(score1);
                                }
                            }
                            else 
                            {
                                 System.out.println("Reached Teeminal @score "+(score+terminalMaxScores[row]));
                                scoreList.add(score+terminalMaxScores[row]);
                            }
                        }
                        else 
                        {
                             System.out.println("Reached Teeminal @score "+(score+terminalMaxScores[row]));
                            scoreList.add(score+terminalMaxScores[row]);
                        }
                    }
                    else
                    {
                        int score=scoreTillYet+getScore(row, column);
                         System.out.println(" @score became "+score);
    
                          
                            if(hasUp(row, column))
                            {
                                if(upCounter!=rows)
                                {  
                                     System.out.println("\t\tGoing Up");
                                    if(isTeleportedDown(row, column))
                                    {
                                        if(!isFromSame(rows-1, column, fromRow, fromColumn))
                                        {
                                            if(column==fromColumn)
                                            {
                                                upCounter++;
                                            }
                                            else upCounter=0;
                                            getAllPossibleEndPaths(rows-1, column, row, column, 0,upCounter,downCounter);
                                        }
                                    }
                                    else
                                    {
                                        if(!isFromSame(row-1, column, fromRow, fromColumn))   
                                        {
                                            if(column==fromColumn)
                                            {
                                                upCounter++;
                                            }
                                            else upCounter=0;
                                            getAllPossibleEndPaths(row-1, column, row, column, score,upCounter,downCounter);
                                        }
                                    }      
                                }
                            }      
                            
                       if(hasRight(row, column))
                       {
                             System.out.println("\t\tGoing Right");
                           getAllPossibleEndPaths(row, column+1, row, column,score,upCounter,downCounter);
                       }


                       if(downCounter!=rows)
                       {
                           if(hasDown(row, column))
                            {
                                 System.out.println("\t\tGoing Down");
                                if(isTeleportedUp(row, column))
                                {
                                    if(!isFromSame(0, column, fromRow, fromColumn))
                                    {
                                         if(column==fromColumn)
                                            {
                                                downCounter++;
                                            }
                                            else downCounter=0;
                                         
                                        getAllPossibleEndPaths(0, column, row, column, 0,upCounter,downCounter);
                                    }
                                }
                                else
                                {
                                    if(!isFromSame(row+1, column, fromRow, fromColumn))   
                                    {
                                          if(column==fromColumn)
                                            {
                                                downCounter++;
                                            }
                                            else downCounter=0;
                                         
                                         getAllPossibleEndPaths(row+1, column, row, column, score,upCounter,downCounter);
                                    }
                                }
                            }
                       }
                    }
                }


                //this method gets the score of a particular cell
                private int getScore(int row,int column)
                {
                    return ground[row][column];
                }

                //this method checks wether the snake can go down or not
                private boolean hasDown(int row,int column)
                {
                    if(row==rows-1)
                    {
                        if(ground[0][column]==-1)
                        {
                            System.out.println("\t\tNo Way Down");
                            return false;
                        }   
                    }
                    else if(ground[row+1][column]==-1)
                    {
                        System.out.println("\t\tNo Way Down");
                        return false;
                    }

                    return true;
                }
        
                //this method checks wether snake can go right or not
                private boolean hasRight(int row,int column)
                {
                    if(isTerminal(column))
                    {
                        System.out.println("\t\tNo Way Right");
                        return false;
                    }
                    else if(ground[row][column+1]==-1)
                    {
                        System.out.println("\t\tNo Way Right");
                        return false;
                    }
                    return true;
                }

        
                //this method checks wether snake can go up or not
                private boolean hasUp(int row,int column)
                {
                    if(row==0)
                    {
                        if(ground[rows-1][column]==-1)
                        {
                               System.out.println("\t\tNo Way Up");
                            return false;
                        }
                    }
                    else if(ground[row-1][column]==-1)
                    {
                           System.out.println("\t\tNo Way Up");
                        return false;
                    }
                    return true;
                }

        
                //this method checks wether the snake has come from the same cell or not
                private boolean isFromSame(int row,int column,int fromRow,int fromColumn)
                {
                    if(row==fromRow)
                    {
                        if(column==fromColumn)
                        {
                               System.out.println("\t\tCame from same side , gng back");
                            return true;
                        }
                    }

                    return false;
                }

                //this mehod checks whether the snake white going down is TELEPORTED DOWN OR NOT
                private boolean isTeleportedDown(int row,int column)
                {
                       if(row==0)
                       {
                            return true;
                       }
                       return false;
                }
        
                //This method checks whether the snake while going down has been TELEPORTED UP OR NOT
                private boolean isTeleportedUp(int row,int column)
                {
                       if(row==rows-1)
                       {
                            return true;
                       }
                       return false;
                }

                //This method checks whether the cell is the right most cell or not
                private boolean isTerminal(int columnNumber)
                {
                    if(columnNumber==columns-1)
                    {
                        return true;
                    }
                    return false;
                }

                //This method takes input of the rows,columns & the scores in the ground grid
                private void takeInput()
                {
                    Scanner takeInput=new Scanner(System.in);
                    rows=takeInput.nextInt();
                    columns=takeInput.nextInt();
                    ground=new int[rows][columns];
                    for(int i=0;i<rows;i++)
                    {
                        for(int j=0;j<columns;j++)
                        {
                           ground[i][j]=100;//takeInput.nextInt();
                        }
                    }
                } 

                //this method calculates maximum scores which snake can score if it reaches any terminal
                private void calculateTerminalMaxScores()
                {
                    terminalMaxScores=new int[rows];

                    for(int i=0;i<rows;i++)
                    {
                        terminalMaxScores[i]=getThisTerminalMaxScore(i);
                    }
                }

                //this method gets the maximum score the snake can score if it reaches the particular rightmost cell
                int getThisTerminalMaxScore(int terminal)
                {

                       System.out.println("Terminal : "+terminal);
                   int score=0;
                   if(getScoreAtTerminal(terminal)==-1)
                   {
                       score=0;
                   }
                   else
                   {
                      score=getScoreAtTerminal(terminal);
                      ArrayList<Integer> terminalScore=new ArrayList<>();
                      terminalScore.add(score);

                      //check down score
                      if(isDownThere(terminal))
                      {
                          int currentPostion=terminal;

                          if(terminal==rows-1)
                          {
                              currentPostion=0;
                              score=ground[currentPostion][columns-1];
                              terminalScore.add(score);
                          }
                          else 
                          {
                              currentPostion=terminal+1;
                              score=score+ground[currentPostion][columns-1];
                              terminalScore.add(score);
                          }
                          int endpoint=0;
                          if(terminal==0)
                          {
                              endpoint=rows-1;
                          }
                          else endpoint=terminal-1;

                          while(isDownThere(currentPostion))
                          {
                             if(currentPostion!=endpoint)
                             {   if(currentPostion==rows-1)
                                  {
                                       currentPostion=0;
                                       score=ground[currentPostion][columns-1];
                                       terminalScore.add(score);
                                  }
                                  else 
                                  {
                                    currentPostion=currentPostion+1;
                                    score=score+ground[currentPostion][columns-1];
                                    terminalScore.add(score);
                                  }
                             }
                             else break;
                          }    
                      }

                      //check up score
                      score=getScoreAtTerminal(terminal);
                      if(isUpThere(terminal))
                      {
                          int currentPostion=terminal;  
                          if(terminal==0)
                          {
                              currentPostion=rows-1;
                              score=ground[currentPostion][columns-1];
                              terminalScore.add(score);
                          }
                          else 
                          {
                              currentPostion=terminal-1;
                              score=score+ground[currentPostion][columns-1];
                              terminalScore.add(score);
                          }

                          int endpoint=0;
                          if(terminal==rows-1)
                          {
                              endpoint=0;
                          }
                          else endpoint=terminal+1;

                          while(isUpThere(currentPostion) )
                          {
                             if(currentPostion!=endpoint)
                             {   if(currentPostion==0)
                                  {
                                       currentPostion=rows-1;
                                       score=ground[currentPostion][columns-1];
                                       terminalScore.add(score);
                                  }
                                  else 
                                  {
                                    currentPostion=currentPostion-1;
                                    score=score+ground[currentPostion][columns-1];
                                    terminalScore.add(score);
                                  }
                             }
                             else break;
                          }    
                      }



                      Collections.sort(terminalScore);
                      score=terminalScore.get(terminalScore.size()-1);
                   }

                   return score;
                }

                //this method checks if the sname can tracel down from the terminal/right most cell
                 boolean isDownThere(int terminal)
                    {
                        if(terminal==rows-1)
                        {
                            if(ground[0][columns-1]==-1)
                            {
                                return false;
                            }
                            else return true;
                        }
                        else
                        {
                           if(ground[terminal+1][columns-1]==-1)    
                           {
                               return false;
                           }
                           else return true;
                        } 

                    }

               //this method checks if the snake can travel up from the terminal/right most cell
                boolean isUpThere(int terminal)
                {
                    if(terminal==0)
                    {
                        if(ground[rows-1][columns-1]==-1)
                        {
                            return false;
                        }
                        else return true;
                    }
                    else
                    {
                       if(ground[terminal-1][columns-1]==-1)    
                       {
                           return false;
                       }
                       else return true;
                    } 

                }

            //this method gets score at the given righmost terminal cell
             int getScoreAtTerminal(int terminal)
                {
                    return ground[terminal][columns-1];
                }       
        }
    
}
