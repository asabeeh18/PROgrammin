package Constructor;
class Ticket
{
  private int price,total,balance;
  Ticket(int pr,int t,int bal)
  {
      price=pr;
      total=t;
      balance=bal;
    }
    Ticket(int pr)
    {
        price=pr;
        total=0;
        balance=0;
    }
    Ticket(int t,int pr)
    {
        price=pr;
        balance=0;
        total=t;
    }
    Ticket()
    {
    }
    void disp()
    {
        System.out.println("Price="+price+"  Balance="+balance+"  Total="+total);
    }
}
       
      
      
      