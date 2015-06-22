package Constructor;
public class item
{
 private int code;
 private int price;
 item(int cde,int prce)
 {
     code=cde;
     price=prce;
 }
 item()
 {
     code=23;
     price=283;
 }
 void function()
 {
     System.out.println(code+" has  Rs   "+price);
    }
     
   
}
