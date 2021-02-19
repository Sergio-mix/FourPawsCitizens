package edu.unbosque.fourpawscitizens.model.daos;

public class Pet {

    private String id;
    private Long microchip;
    private String species;
    private String sex;
    private String size;
    private boolean potentDangerous;
    private String neighborhood;

    /**
     *
     */
    public Pet() {
        this.id = id;
        this.microchip = microchip;
        this.species = species;
        this.sex = sex;
        this.size = size;
        this.potentDangerous = potentDangerous;
        this.neighborhood = neighborhood;
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Long getMicrochip() {
        return microchip;
    }

    /**
     *
     * @param microchip
     */
    public void setMicrochip(Long microchip) {
        this.microchip = microchip;
    }

    /**
     *
     * @return
     */
    public String getSpecies() {
        return species;
    }

    /**
     *
     * @param species
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     *
     * @return
     */
    public String getSex() {
        return sex;
    }

    /**
     *
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     *
     * @return
     */
    public String getSize() {
        return size;
    }

    /**
     *
     * @param size
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     *
     * @return
     */
    public boolean isPotentDangerous() {
        return potentDangerous;
    }

    /**
     *
     * @param potentDangerous
     */
    public void setPotentDangerous(boolean potentDangerous) {
        this.potentDangerous = potentDangerous;
    }

    /**
     *
     * @return
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     *
     * @param neighborhood
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
    public boolean soloNumeros(String cadena){
        boolean mensaje;
        try {
            Integer.parseInt(cadena);
            mensaje = true;
        } catch (NumberFormatException e){
            mensaje = false;
        }


        return mensaje;
    }

    public boolean soloLetras(String cadena){
        boolean mensaje;
        if (cadena.matches("[a-zA-Z]*")) {
            mensaje = true;
        } else {
            mensaje = false;
        }
        return mensaje;
    }
    public boolean validarBoolean(String cadena) {
        boolean mensaje;
        if (cadena.matches("[0-9]*")) {
            mensaje = true;
        } else {
            mensaje = false;
        }
        return mensaje;
    }
}
