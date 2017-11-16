/*
 *      Author :::  Brian Sterling
 *     Program ::: Bases de Datos
 *  Credential ::: SIST0008-G01:SIV
 */

package modelo;

public class Artista
{
    private int cedula;
    private String nombre;
    private int edad;
    private String obra;
    private String estilo;

    public int getCedula()
    {
        return cedula;
    }

    public void setCedula(int cedula)
    {
        this.cedula = cedula;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getEdad()
    {
        return edad;
    }

    public void setEdad(int edad)
    {
        this.edad = edad;
    }

    public String getObra()
    {
        return obra;
    }

    public void setObra(String obra)
    {
        this.obra = obra;
    }

    public String getEstilo()
    {
        return estilo;
    }

    public void setEstilo(String estilo)
    {
        this.estilo = estilo;
    }

    @Override
    public String toString()
    {
        return "Artista{" + "cedula=" + cedula + ", nombre=" + nombre + ", edad=" + edad + ", obra=" + obra + ", estilo=" + estilo + '}';
    }
}