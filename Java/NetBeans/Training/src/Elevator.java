
import java.util.*;

public class Elevator
{

    static class Person implements Comparable<Person>
    {

        int t, f;

        Person(int a, int b)
        {
            t = a;
            f = b;
        }

        @Override
        public int compareTo(Person o)
        {
            return Integer.compare(this.t, o.t);
        }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int w = in.nextInt();
        int c = in.nextInt();
        int m = in.nextInt() - 1;
        int rt = -1;
        PriorityQueue<Person> tr = new PriorityQueue<>();
        PriorityQueue<Person> st = new PriorityQueue<>();
        PriorityQueue<Integer> fl = new PriorityQueue<>();
        PriorityQueue<Person> lf = new PriorityQueue<>();
        //Stack<Person> l=new Stack<>();

        for (int a0 = 0; a0 < n; a0++)
        {
            int id = in.nextInt();
            int t = in.nextInt();
            int f = in.nextInt();
            if (id == 1)
            {
                st.add(new Person(t, f));
            } else
            {
                tr.add(new Person(t, f));
            }
            if (a0 == m)
            {
                rt = t;
            }
        }
        int time=0;
        
        
        int ftime=Integer.MIN_VALUE-w-1;
        
        int elC = 0;
        Person p=null;
        int maxf = -1;
        int trip = 1;
        while (!st.isEmpty() && !tr.isEmpty())
        {
            //space and time
            if (elC < c && time < ftime + w)
            {

                //p=st.peek().t<tr.peek().t?st.remove().t:tr.remove().t;
                //teacher
                p = tr.peek();
                if (p.t <= ftime + w)
                {
                    if (tr.remove().t > maxf)
                    {
                        maxf = p.f;
                    }
                    if(elC==0)
                        ftime=p.t;
                    elC++;
                    time = p.t;
                    if (p.t == rt)
                    {
                        System.out.print(trip + " ");
                    }
                } else if ((p = st.peek()).t <= ftime + w)    //student
                {
                    //p = st.peek();

                    lf.add(st.remove());
                    if(elC==0)
                        ftime=p.t;
                    elC++;
                    time = p.t;
                    if (p.t == rt)
                    {
                        System.out.print(trip + " ");
                    }

                } //start lift
                else
                {
                    for (Person i : lf)
                    {
                        if (i.f > maxf)
                        {
                            maxf = i.f;
                        }
                    }
                    time += 2 * maxf;
                    trip++;
                    lf = null;
                    ftime=Integer.MIN_VALUE-w-1;
                    //p = null;
                    elC = 0;
                }
            } else
            {
                //no space but time ..teacher entery
                if (time < ftime + w)
                {
                    p = tr.peek();
                    if (p.t <= ftime + w)
                    {
                        if (tr.remove().t > maxf)
                        {
                            maxf = p.f;
                        }
                        st.add(lf.remove());
                        lf.add(tr.remove());
                        if(elC==0)
                            ftime=p.t;
                        elC++;
                        time = p.t;
                    }
                    if (p.t == rt)
                    {
                        System.out.print(trip + " ");
                    }
                } //start lift
                else
                {
                    for (Person i : lf)
                    {
                        if (i.f > maxf)
                        {
                            maxf = i.f;
                        }
                    }
                    time += 2 * maxf;
                    trip++;
                    lf = null;
                    ftime=Integer.MIN_VALUE-w-1;
                    //p = null;
                    elC = 0;
                }
            }
        }

        //Only teachers left
        while (!tr.isEmpty())
        {
            //space and time
            if (elC < c && time < ftime + w)
            {
                //teacher
                p = tr.peek();
                if (p.t <= ftime + w)
                {
                    if (tr.remove().t > maxf)
                    {
                        maxf = p.f;
                    }
                    if(elC==0)
                        ftime=p.t;
                    elC++;
                    time = p.t;
                    if (p.t == rt)
                    {
                        System.out.print(trip + " ");
                    }
                } //start lift
                else
                {
                    time += 2 * maxf;
                    trip++;
                    lf = null;
                    ftime=Integer.MIN_VALUE-w-1;
                    //p = null;
                    elC = 0;
                }
            } else
            {
                time += 2 * maxf;
                trip++;
                lf = null;
                //p = null;
                elC = 0;

            }
        }
        //only students left
        while (!st.isEmpty())
        {
            //space and time
            if (elC < c && time < ftime + w)
            {

                //p=st.peek().t<tr.peek().t?st.remove().t:tr.remove().t;
                //teacher
                if ((p = st.peek()).t <= ftime + w)    //student
                {
                    //p = st.peek();

                    lf.add(st.remove());
                    if(elC==0)
                        ftime=p.t;
                    elC++;
                    time = p.t;
                    if (p.t == rt)
                    {
                        System.out.print(trip + " ");
                    }

                } //start lift
                else
                {
                    for (Person i : lf)
                    {
                        if (i.f > maxf)
                        {
                            maxf = i.f;
                        }
                    }
                    time += 2 * maxf;
                    trip++;
                    lf = null;
                    ftime=Integer.MIN_VALUE-w-1;
                    //p = null;
                    elC = 0;
                }
            } 
            else
            {
                //start lift
                for (Person i : lf)
                {
                    if (i.f > maxf)
                    {
                        maxf = i.f;
                    }
                }
                time += 2 * maxf;
                trip++;
                lf = null;
                ftime=Integer.MIN_VALUE-w-1;
                //p = null;
                elC = 0;

            }

        }
        System.out.println(time-(maxf+maxf-p.f));
    }
}
