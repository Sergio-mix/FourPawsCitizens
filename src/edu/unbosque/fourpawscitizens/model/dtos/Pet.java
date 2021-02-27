package edu.unbosque.fourpawscitizens.model.dtos;

/**Clase main
 * @author Miguel Sierra, Sergio Hernandez, Brayan Romero
 */
public class Pet {

    public String id;
    public Long microchip;
    public String species;
    public String sex;
    public String size;
    public boolean potentDangerous;
    public String neighborhood;



    /**Se crea el constructor de la clase
     * <b>pre</b>Se definen los parametros que van a ir dentro del constructor
     * <b>post</b>se crea el constructor Pet<br>
     * @param id
     * @param microchip
     * @param species
     * @param sex
     * @param size
     * @param potentDangerous
     * @param neighborhood
     */
    public Pet(String id, Long microchip, String species, String sex, String size, boolean potentDangerous, String neighborhood) {
        this.id = id;
        this.microchip = microchip;
        this.species = species;
        this.sex = sex;
        this.size = size;
        this.potentDangerous = potentDangerous;
        this.neighborhood = neighborhood;
    }






     /**Se modifica la id
     * 	 * <b>pre</b>Se definen los parametros que se van a evaluar
     * 	 * <b>post</b>se especifica que id se va a modificar<br>
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
}
