import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
   @author Vinit Jain, Mumbai, India - +917666601601 , connect@technovadors.in
   #Note : Uncomment all the dislayCityDetails to check updated details of all cities in app island
*/

public class Main 
{
    
   public static void main(String[] args) 
   {
      Start letsBegin=new Start();
   }
   
   static class Start
   {
       
       int no_of_cities = 0,no_of_inquiries=0;
       int[][] pathArray,enquiryArray;
       ArrayList<City> cityList;
       ArrayList<Integer> EnquiryOutput;
       
       //This Constructor acts as the Government of Aps Island
       public Start()
       {
           takeInput();
           buildCity();
           connectCities();
          // displayCityDetails();
           processEnquiries();
          
           //print the output of all enquiries
           for(int i=0;i<EnquiryOutput.size();i++)
           {
               System.out.println(EnquiryOutput.get(i));
           }
           
       }
       
       //this method will print the last updated data of each city
       private void displayCityDetails()
       {
            for(int i=0;i<cityList.size();i++)
           {
               System.out.println("\n\n");
               
               City current_city=cityList.get(i);
               System.out.println("City ID : "+current_city.id);
               if(current_city.isFestiveCity)
               {
                   System.out.println("Is a Festive City");
               }
               
               System.out.print("Connected Cities ");
                for(int j=0;j<current_city.connectedcities.size();j++)
                   {
                       if(j==0)
                       {
                           System.out.print(current_city.connectedcities.get(j)+" ");
                       }
                       else System.out.print(", "+current_city.connectedcities.get(j));
                   }
               if(current_city.hasConnectedFestiveCity)
               {
                   System.out.print("Has connected Festive City ");
                   for(int j=0;j<current_city.connectedFestiveCities.size();j++)
                   {
                       System.out.print(","+current_city.connectedFestiveCities.get(j)+" ");
                   }
               }
               
           }
       }
       
       //This Method Processes all the enquiries of the travellers 
       private void processEnquiries()
       {
           
           for(int i=0;i<enquiryArray.length;i++)
           {
               //Check q(i)
               if(enquiryArray[i][0]==1)
               {
                   // Announce new festive city , c(i)
                   announceNewFestiveCity(enquiryArray[i][1]);
               }
               else
               {
                   //Find shortest distance to nearest festive city
                   if(EnquiryOutput==null)
                   {
                       EnquiryOutput=new ArrayList<>();
                   }
                   EnquiryOutput.add(findShortestPathToFestiveCity(enquiryArray[i][1],enquiryArray[i][1],enquiryArray[i][1],0));
                      
                   
               }
           }
       }
       
       //this method will do the job of finding the shortest path to the nearest festive city
       int findShortestPathToFestiveCity(int baseCity,int toCity,int fromCity,int yetTravelledDistance)
       {
           
          if(yetTravelledDistance==0)
          { if(cityList.get(baseCity-1).isFestiveCity)
           {
               return 0;
           }
           if(cityList.get(baseCity-1).hasConnectedFestiveCity)
           {
               return 1;
           }
          }
           
           
           int distance=yetTravelledDistance;
           boolean found=false;
           if(cityList.get(toCity-1).isFestiveCity)
           {
               return distance+0;
           }
           if(cityList.get(toCity-1).hasConnectedFestiveCity)
           {
               return distance+1;
           }
           else
           {
               for(int i=0;i<cityList.get(toCity-1).connectedcities.size();i++)
               {
                   City neighbour=cityList.get((cityList.get(toCity-1).connectedcities.get(i))-1);
                   if(neighbour.hasConnectedFestiveCity)
                   {
                       distance=distance+2;
                       found=true;
                       break;
                   }
               }
           }
           
           if(!found)
           {  //Now we have to check for the neighbours by traversing                    
                int[] distancesToFestiveCityFromAllNeighbours=new int[cityList.get(toCity-1).connectedcities.size()];
                distance++;
                int currentNeighbour=0;

                while(currentNeighbour!=distancesToFestiveCityFromAllNeighbours.length)
                { 
                    City neighbourCity=cityList.get((cityList.get(toCity-1).connectedcities.get(currentNeighbour))-1);

                    if(neighbourCity.id==fromCity)
                     {
                         distancesToFestiveCityFromAllNeighbours[currentNeighbour]=-1;
                         currentNeighbour++;
                         continue;
                     }

                     // if any of the neighbouring city is festive city, make distance 1
                     if(neighbourCity.hasConnectedFestiveCity)
                     {
                         distance=distance+1;
                         distancesToFestiveCityFromAllNeighbours[currentNeighbour]=distance;
                         currentNeighbour++;
                         continue;
                     }
                     else
                     {
                         boolean neighbourHasFestiveCity=false; 
                         //if any neighbouring city's neighbour have a direct connected festive city 
                             for(int i=0;i<neighbourCity.connectedcities.size();i++)
                             {
                                 if(cityList.get((neighbourCity.connectedcities.get(i))-1).hasConnectedFestiveCity)
                                 {
                                    neighbourHasFestiveCity=true; 
                                    break;               
                                 }
                             }

                             if(neighbourHasFestiveCity)
                             {
                                 distance=distance+2; 
                             }
                             else
                             {
                                 distance=findShortestPathToFestiveCity(baseCity, neighbourCity.id, toCity, distance);
                             }    

                             distancesToFestiveCityFromAllNeighbours[currentNeighbour]=distance;
                             currentNeighbour++;
                             continue;
                     }                
                }

                Arrays.sort(distancesToFestiveCityFromAllNeighbours);
                for(int i=0;i<distancesToFestiveCityFromAllNeighbours.length;i++)
                {
                    if(distancesToFestiveCityFromAllNeighbours[i]>-1)
                    {
                        distance=distancesToFestiveCityFromAllNeighbours[i];
                        break;
                    }
                }
           }
           
           return distance;
           
       }
       
       //This method does the job of announcing a city festive & notifing all negibouring cities that tbis city is festive
       void announceNewFestiveCity(int cityID)
       {
           City current_city=cityList.get(cityID-1);
           
           // announced city as festive
           current_city.makeThisCityFestive();
           
           
           // notify all negibouring cities that tbis city is festive
           for(int i=0;i<current_city.connectedcities.size();i++)
           {
               cityList.get((current_city.connectedcities.get(i))-1).makeHasConnectedFestiveCityTrue();
               cityList.get((current_city.connectedcities.get(i))-1).addAnotherFestiveCity(cityID);
           }
       }
       
       //This class uses the given data build cities in Aps Islandnetwork
       private void buildCity()
       {
         cityList=new ArrayList<>();
         for(int i=1;i<=no_of_cities;i++)
         {
             cityList.add(new City(i));
             if(i==1)
             {
                 cityList.get(0).makeThisCityFestive();
             }
         }
         
       }
       
       //This method connects cities with highway conection data given
       private void connectCities()
       {
           
           for(int i=0;i<pathArray.length;i++)
           {
              
               cityList.get(pathArray[i][0]-1).addHighwayToAnotherCity(pathArray[i][1]);
               if(cityList.get(pathArray[i][0]-1).isFestiveCity)
               {
                  cityList.get(pathArray[i][1]-1).addAnotherFestiveCity(pathArray[i][0]);
               }
                          
               cityList.get(pathArray[i][1]-1).addHighwayToAnotherCity(pathArray[i][0]);
                if(cityList.get(pathArray[i][1]-1).isFestiveCity)
               {
                  cityList.get(pathArray[i][0]-1).addAnotherFestiveCity(pathArray[i][1]);
               }
           }
       }
       
       //this class takes inputfrom console
        private void takeInput()
        {
            Scanner takeInput=new Scanner(System.in);
            no_of_cities=takeInput.nextInt();
            no_of_inquiries=takeInput.nextInt();
            pathArray=new int[no_of_cities-1][2];
            enquiryArray=new int[no_of_inquiries][2];
            
            for(int i=0;i<pathArray.length;i++)
            {
                pathArray[i][0]=takeInput.nextInt();
                pathArray[i][1]=takeInput.nextInt();
            }
            
            for(int i=0;i<enquiryArray.length;i++)
            {
                enquiryArray[i][0]=takeInput.nextInt();
                enquiryArray[i][1]=takeInput.nextInt();
            }
            
            //Uncomment to print the input data
           // System.out.println("Paths : "+Arrays.deepToString(pathArray));
           // System.out.println("Enquiries : "+Arrays.deepToString(enquiryArray));
            
        }
       
     //This class describes a city , city's attributes in the Aps Island
      class City
      {
          int id;
          boolean isFestiveCity=false,hasConnectedFestiveCity=false;
          ArrayList<Integer> connectedcities,connectedFestiveCities;
          
          City(int id)
          {
              this.id=id;
              this.connectedcities=new ArrayList<>();
              this.connectedFestiveCities=new ArrayList<>();
          }
          
          ///this method makes the given city festive
          void makeThisCityFestive()
          {
              this.isFestiveCity=true;
          }
          
          //this method makes the indication that the city has connected festive cities
          void makeHasConnectedFestiveCityTrue()
          {
             this.hasConnectedFestiveCity=true;   
          }
          
          //this method connects this city to given city
          void addHighwayToAnotherCity(int cityID)
          {
              if(!cityAlreadyConected(cityID))
              {
                  this.connectedcities.add(cityID);
              }
          }
          
          //this method adds another connected festive city to this city
          void addAnotherFestiveCity(int cityID)
          {
              this.hasConnectedFestiveCity=true;
              if(!festiveCityAlreadyConected(cityID))
              {
                  this.connectedFestiveCities.add(cityID);
              }
          }
          
          //checks if the given city is alrady connected as a festive city
           boolean festiveCityAlreadyConected(int cityID)
          {
              for(int i=0;i<this.connectedFestiveCities.size();i++)
              {
                  if(this.connectedFestiveCities.get(i)==cityID)
                  {
                      return true;
                  }
              }
              return false;
          }
           
          //checks if a city is already connected to the given city
          boolean cityAlreadyConected(int cityID)
          {
              for(int i=0;i<this.connectedcities.size();i++)
              {
                  if(this.connectedcities.get(i)==cityID)
                  {
                      return true;
                  }
              }
              return false;
          }                  
      }
   }   
}
