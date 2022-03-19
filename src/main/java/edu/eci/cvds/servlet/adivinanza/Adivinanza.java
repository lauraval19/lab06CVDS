package edu.eci.cvds.servlet.adivinanza;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;


@ManagedBean(name = "guessBean")
@ApplicationScoped


public class Adivinanza {
    int Numadi=(int) (Math.random() * 10);
    private int intentos;
    private int premio=0;
    String estado;
    String numingr;
    private ArrayList<Integer> lisintentos;

    public Adivinanza() {}

    /**
     * obtener lista de intentos realizados por el usuario
     * @return
     */
    public ArrayList<Integer> getLisintentos() {
        return lisintentos;
    }


    /**
     * obetner el numero que se va a adivinar
     * @return numero a adivinar
     */
    public int getNumadi() {
        return Numadi;
    }

    /**
     * obetner el numero de intentos
     * @return numero de intentos
     */
    public int getIntentos() {
        return intentos;
    }

    /**
     * obtener el puntaje del premio
     * @return puntaje del premio
     */
    public int getPremio() {
        return premio;
    }

    /**
     * obtner el numero que se va a adivinar
     * @return numero a adivinar
     */
    public String getEstado() {
        return estado;
    }

    /**
     * obetner el numero que se va a adivinar
     * @return numero a adivinar
     */
    public String getNumingr() {
        return numingr;
    }

    /**
     * poner numero que se va a adivinar
     * @param numadi
     */
    public void setNumadi(int numadi) {
        Numadi = numadi;
    }

    /**
     * poner numero que de intentos
     * @param intentos
     */
    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    /**
     * poner valor del puntaje
     * @param premio
     */
    public void setPremio(int premio) {
        this.premio = premio;
    }

    /**
     * poner estado del juego, si ganó o no
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * poner valor ingresado
     * @param numingr
     */
    public void setNumingr(String numingr) {
        this.numingr = numingr;
    }

    /**
     * calcula el puntaje segun la palabra adivinada
     * @param numero ingresado en la pagina
     */
    public void guess(String numero){
        lisintentos.add(Integer.parseInt(numero));
        numingr = numero;
        if (Numadi == Integer.parseInt(numero)){
            premio += 100000;
            estado = "ganó 100 puntos";
        }
        else{
            if(premio >= 10000){
                premio -= 10000;
            }
            premio += 0;
            estado = "no gana";
        }
    }

    /**
     * reiniciar el juego
     */
    public void restart(){
        lisintentos = new ArrayList<>();
        intentos=0;
        premio=0;
        estado="";
        numingr="";
        Numadi = (int) (Math.random() * 10);
    }
}
