
package control;

import java.util.ArrayList;
import model.Cachorro;


public class ControlCachorro {
   ArrayList<Cachorro> cachorros; 
   
   public void adicionarCachorro(Cachorro cachorro){
   cachorros.add(cachorro);
   }
   public void eliminarCachorro(Cachorro cachorro){
   cachorros.remove(cachorro);
   }
}
