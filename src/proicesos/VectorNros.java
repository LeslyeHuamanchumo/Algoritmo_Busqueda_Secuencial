
package proicesos;

public class VectorNros
{
    private double elemento[];
    private int conta;
    
    public VectorNros(int tamaño)
    {
        conta = 0;
        elemento = new double[tamaño];
         
    }
        
    public int getConta()
    {
        return conta;
    }
    
    public double getElemento(int pos)
    {
        return elemento[pos];
    }
    
    public void adicionar(double dato)
    {
        elemento[conta] = dato;
        conta = conta + 1;
    }
    
    
    // Declaramos el método con un int porque nos va a devolver la posición, que es un valor entero. 
    // Este método va a recibir un parámetro. 
    
    public int buscarSecuencial(double dato)   // Búsqueda secuencial. "dato" va a recibir el valor q vamos a buscar. El tipo de dato debe corresponder con el tipo de dato del vector (double). 
    {
        int i;
                
        for (i = 0; i < conta; i=i+1)   // recorremos el vector 
            if (elemento[i] == dato)    // cada vez que entremos a este bucle estaremos comparando el dato que buscamos con el elemento ubicado en una determinada posición dentro del vector. 
                return i;   // cuando encuentra el dato se abandona el método a través de la instrucción return y devuelve la posición.

        return -1; // si no se encuentra devolverá -1
    }
    
    
    // Declaramos el método con un int porque nos va a devolver la posición, que es un valor entero. 
    
    public int buscarBinaria(double dato)      // Búsqueda binaria
    {
        int limInf, limSup, medio; // necesitamos 3 variables 

        ordenar();   // Requisito
       
        /*
        
        La primera vez que calculamos la posición central, tomamos como 
        referencia todo el vector.
        
        */
        
        limInf = 0;  
        limSup = conta - 1; // ejemplo: si el vector tiene 20 elementos, el último se encuentra en la posicion 19

        do
        {
            medio = (limInf + limSup) / 2; // calculamos la posicion central.

            if (dato == elemento[medio]) // comparamos el dato con la posicion central.
                return medio; // va a devolver la posicion donde lo encontró

            if (dato < elemento[medio])  // averiguamos si el dato es menor al termino de la posicion central.
                limSup = medio - 1; // este sería el nuevo limite superior
            else
                limInf = medio + 1;  // este sería el nuevo límite inferior
        }
        while(limInf <= limSup);

        return -1;  // si no lo encuentra devuelve -1
    }
    
        
    // este método no requiere devolver valor pero recibe dos parámetros
    
    public void modificar(double dato, int pos) // dato va a recibir el valor de reemplazo. pos va a recibir la posición donde vamos a hacer la modificación
    { 
        elemento[pos] = dato;
    }
    
    
    // este método no requiere devolver valor pero recibe 1 parámetro
    // cómo obtenemos la posición del elemento a eliminar? - Buscando. Primero invocamos a cualquiera de los métodos de búsqueda. Estos métodos ya nos dan la posición.
    // conociendo ya la posición del elemento a eliminar, invocamos a este método.
    // OJO: es más un método de traslados y reubicación de los elementos en sus nuevas posiciones después de la eliminación. 
    
    public void eliminar(int pos)  // pos recibe la posición donde se encuentra el elemento a eliminar. 
    {
       int i;
       
       for (i = pos; i < (conta - 1); i=i+1)  // for empezará en la posición donde se van a empezar a realizar los traslados. i<(conta-1) quiere decir que i no va a llegar hasta la última posición, sino hasta la penúltima.
           elemento[i] = elemento[i + 1];  // si tuviéramos 100 elementos, estamos diciendo que el elemento que está en la posición 99 pase a la posición 98 
       
       // luego de terminar de hacer todos los traslados va a quedar un elemento menos en el vector, entonces al salir del bucle for lo que hacemos es disminuir el valor de conta en 1 unidad.     
       
       conta = conta - 1; 
    }
    
    public void ordenar() {}
}



