import java.util.Scanner;

public class Radio implements Interface {

    private Vista vista;
    private Scanner sc = new Scanner(System.in);
    private boolean estado = false;
    private boolean estacion = false;
    private Float emisorasGuardas[] = new Float[12];
    private Float emisora = 530f; 

    Radio(Vista vista) {
        this.vista = vista;
    }

    public void activarRadio() {

        boolean ejecutar = true;

        while (ejecutar) {

            vista.menu();
            vista.print("");
            int opcion = sc.nextInt();

            if (opcion == 1) {
                encenderApagar();
                vista.print("[OK] La radio se ha encendido");
                vista.print("[Estado] Encendido");

            } else if (opcion == 2) {

                String nombreEmisora = "AM";
                if (!estacion) {
                    nombreEmisora = "FM";
                }
                vista.print("[LA EMISORA] " + nombreEmisora);
                amFm();
                if (!estacion) {
                    nombreEmisora = "FM";
                }else{
                    nombreEmisora = "AM";
                }
                vista.print("[SE CAMBIO A LA EMISORA] " + nombreEmisora);

            } else if (opcion == 3) {

                double avanzar = avanzar();
                String nombreEmisora = "AM";
                if (!estacion) {
                    nombreEmisora = "FM";
                }
                vista.print("[!] Se ha colocado la estacion " + emisora + " " + nombreEmisora);

            } else if (opcion == 4) {
                String nombreEmisora = "AM";
                if (!estacion) {
                    nombreEmisora = "FM";
                }
                vista.print("[Emisora] " + emisora + " " + nombreEmisora);
                vista.print("En que boton desea guardar la estacion actual?");
                int btn = sc.nextInt();
                guardar(btn);
                vista.print("[!] La emisora se ha guardado correctamente");

            } else if (opcion == 5) {
                String nombreEmisora = "AM";
                if (!estacion) {
                    nombreEmisora = "FM";
                }
                vista.print("Seleccione el boton donde su emisora: ");
                int btn = sc.nextInt();
                
                vista.print("[!] Se ha puesto la emisora " + seleccionar(btn) + " " + nombreEmisora);

            } else if (opcion == 6) {
                encenderApagar();
                vista.print("[OK] La radio se ha apagado");
                vista.print("[Estado] Apagado");

            } else {
                vista.print("[!] Opcion no disponible");
            }

        }

    }

    @Override
    public boolean encenderApagar() {
        estado = !estado;
        return estado;
    }

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