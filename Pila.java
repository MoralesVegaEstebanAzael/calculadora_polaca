
/**
 * Write a description of class Pila here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pila
{
    private char[]arre;
    private int tope,max;
    public Pila(int max)
    {
        this.max=max;
        arre= new char[max];
        tope=-1;
    }
    public boolean tavacia()
    {
        return tope==-1;
    }
    public boolean tallena()
    {
        return tope==max-1;
    }
    public boolean push(char o)
    {
        if(!tallena())
        {
            tope++;
            arre[tope]=o;
            return true;
        }
        return false;
    }
    public char verTope()
    {
        if(!tavacia())
        {
            return arre[tope];
        }
        return ' ';
    }
    public char pop()
    {
        if(!tavacia())
        {
           char aux= arre[tope];
           arre[tope]=' ';
           tope--;
           return aux;
        }
        return ' ';
    }
    public int cuantos()
    {
        return tope+1;
    }
    public String imprime()
    {
        String s=" ";
        for(int x=0; x<=tope; x++)
        {
            s=s+(char)arre[x];
        }
        return s;
    }
}
