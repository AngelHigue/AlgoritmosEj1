import java.util.Scanner;

public class Radio implements Interface {

    // Atributos de la radio
    private Vista vista;
    private Scanner sc = new Scanner(System.in);
    private boolean estado = false;
    private boolean estacion = false;
    private Float emisorasGuardas[] = new Float[12];
    private Float emisora = 530f;

    // Constructor
    Radio(Vista vista) {
        this.vista = vista;
    }

    /*
     * Se encarga de el funcionamiento general de la radio
     * 
     * @return void
     */
    public void activarRadio() {

        // Crear un bucle para mostrar el menu
        boolean ejecutar = true;

        while (ejecutar) {

            // Mostrar el menú
            vista.menu();
            vista.print("");
            int opcion = sc.nextInt();

            if (opcion == 1) {

                // Se cambia el estado de la radio a encendida y se muestra un mensaje de
                // confirmación
                encenderApagar();
                vista.print("[OK] La radio se ha encendido");
                vista.print("[Estado] Encendido");

            } else if (opcion == 2) {

                // Se mira en que emisora se encuentra la radio
                String nombreEmisora = "AM";
                if (!estacion) {
                    nombreEmisora = "FM";
                }
                vista.print("[LA EMISORA] " + nombreEmisora);
                // Cambia de emisora
                amFm();

                // Se mira en que emisora se encuentra la radio
                if (!estacion) {
                    nombreEmisora = "FM";
                } else {
                    nombreEmisora = "AM";
                }
                vista.print("[SE CAMBIO A LA EMISORA] " + nombreEmisora);

            } else if (opcion == 3) {

                // Avanza a la estacion siguiente
                double avanzar = avanzar();
                String nombreEmisora = "AM";
                if (!estacion) {
                    nombreEmisora = "FM";
                }
                vista.print("[!] Se ha colocado la estacion " + emisora + " " + nombreEmisora);

            } else if (opcion == 4) {

                // Mira en que emisora se encuentra la radio
                String nombreEmisora = "AM";
                if (!estacion) {
                    nombreEmisora = "FM";
                }
                vista.print("[Emisora] " + emisora + " " + nombreEmisora);

                // Mira en que boton guardara la estación
                vista.print("En que boton desea guardar la estacion actual?");
                int btn = sc.nextInt();

                // Guarda la estación en el boton indicado
                guardar(btn);
                vista.print("[!] La emisora se ha guardado correctamente");

            } else if (opcion == 5) {

                // Mira en que emisora se encuentra la radio
                String nombreEmisora = "AM";
                if (!estacion) {
                    nombreEmisora = "FM";
                }
                // Ingresa el numero de un boton donde se tenga guardada una estación
                vista.print("Seleccione el boton donde su emisora: ");
                int btn = sc.nextInt();

                // Se coloca esa estación
                vista.print("[!] Se ha puesto la emisora " + seleccionar(btn) + " " + nombreEmisora);

            } else if (opcion == 6) {

                // Se cambia el estado de la radio a encendida y se muestra un mensaje de
                // confirmación
                encenderApagar();
                vista.print("[OK] La radio se ha apagado");
                vista.print("[Estado] Apagado");

            } else {
                vista.print("[!] Opcion no disponible");
            }

        }

    }

    /*
     * Cambia el estado de la radio
     * 
     * @return true -> encendida / false -> apagada
     */
    @Override
    public boolean encenderApagar() {
        estado = !estado;
        return estado;
    }

    /*
     * Cambia el emisora de la radio
     * 
     * @return true -> AM / false -> FM
     */
    @Override
    public boolean amFm() {
        estacion = !estacion;

        if (estacion) {
            emisora = 87.9f;
        } else {
            emisora = 530f;
        }

        return estacion;
    }

    /*
     * Guarda la estación actual en un boton
     * 
     * @return mensaje de exito o advertencia
     */
    @Override
    public String guardar(int btn) {
        String msg = "";
        try {
            emisorasGuardas[btn] = emisora;
            msg = "[OK] La emisora se ha guardado correctamente";
        } catch (Exception e) {
            msg = "[!] El boton indicado no existe";
        }
        return msg;
    }

    /*
     * Se coloca la estacion del boton indicado
     * 
     * @params Un número de boton
     * 
     * @return true -> encendida / false -> apagada
     */
    @Override
    public String seleccionar(int btn) {
        String tempEmisora = "";
        try {
            tempEmisora = emisorasGuardas[btn].toString();
            emisora = emisorasGuardas[btn];
        } catch (Exception e) {
            tempEmisora = "[!] El boton indicado no existe";
        }
        return tempEmisora;
    }

    /*
     * Se avanza a la siguiente estación
     * 
     * @return la nueva estación
     */
    @Override
    public double avanzar() {
        if (estacion) { // AM

            if (emisora >= 107.9) {
                emisora = 87.9f;
            } else {
                emisora += 0.2f;
            }

        } else { // FM
            if (emisora >= 1610f) {
                emisora = 530f;
            } else {
                emisora += 10f;
            }

        }
        return emisora;
    }

}