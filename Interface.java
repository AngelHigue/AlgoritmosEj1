
public interface Interface {
    
    public boolean encenderApagar(); // cambiar estado de la radio
    public boolean amFm(); // cambiar entre AM y FM
    public String guardar(int btn); // guardar la emisora actual en un boton
    public String seleccionar(int btn); // Seleccionar una emisora guardada
    public double avanzar(); // Avanzar de estación

}