public class Vista{

    public void print(String mensaje){
        System.out.println(mensaje);
    }

    public void menu(){
        print("\n  ::  RADIO  ::");
        print("1. Encender radio");
        print("2. Cambiar emisora (AM /FM)");
        print("3. Avanzar emisora");
        print("4. Guardar emisora");
        print("5. Seleccionar emisora");
        print("6. Apagar radio ");
    }

}