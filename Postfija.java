
 
public class Postfija
{
    Pila operadores= new Pila(50);
    Pila post= new Pila(50);
    
   private boolean evalua(char x){
     if(x== '+' || x=='-' || x== '*' || x=='/' || x=='^' || x=='('|| x=='='){
       return true;    
     }
     return false; 
   }
   public int orden(char x)
   {
        if(x=='^')
            return 4;
        if(x=='/' || x=='*')
            return 3;
        if(x=='+' || x=='-')
            return 2;
        if(x=='=')
            return 1;
         
        return 0;
    }
    public void pilaOperadores(char x)
    {
       if(x=='(')
       {
           operadores.push(x);
       }
        else if((orden(x)) > (orden(operadores.verTope())))
       {
          operadores.push(x); 
       }
       else if((orden(x)) < (orden(operadores.verTope())))
       { 
         char e=' '; 
        while(!operadores.tavacia()){
          e= operadores.pop();
          post.push(e);
        }
        operadores.push(x);
       }
       else if((orden(x)) == (orden(operadores.verTope())))
       {
           post.push(operadores.pop()); 
           operadores.push(x);
       }
       
    }
    public void vaciar()
    {
        char a=' ';
        while(!operadores.tavacia())
        {
            a= operadores.pop();
            if(a != '(')
            post.push(a);
        }
    }
    public String recibe(String expre)
    {
        for(int x=0; x<expre.length(); x++)
        {
            if(evalua(expre.charAt(x)))
            {
                if(operadores.tavacia())
                {
                   operadores.push(expre.charAt(x));
                }
                else
                {
                   pilaOperadores(expre.charAt(x));  
                }
            }
            else if(expre.charAt(x) == ')')
            {
               char a=' '; 
               while(!operadores.tavacia()){
                a=operadores.pop(); 
                 if(a!='('){ 
                   post.push(a);
                }
               } 
            }
            else 
            {
                post.push(expre.charAt(x));
            }
            
            if(x==expre.length()-1)
            {
                  char a=' '; 
               while(!operadores.tavacia()){
                a=operadores.pop(); 
                 if(a!='('){ 
                   post.push(a);
                }
               } 
            }
        }
        return post.imprime();
    } 
}
