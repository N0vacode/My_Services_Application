/*
 * Copyright (c) $2019 NovaCode All Rights Reserved
 * This product is protected by copyright and distributed under licenses restricting copying,distribution, and decompilation.
 */

package app.novacode.myservices.entity;

import app.novacode.myservices.R;

public class Services {
    private String nombre;
    private int idDrawable;

    public Services(String nombre, int idDrawable) {
        this.nombre = nombre;
        this.idDrawable = idDrawable;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public int getId() {
        return nombre.hashCode();
    }

    public static Services[] ITEMS = {
            new Services("Jaguar F-Type 2015", R.drawable.ic_art),
            new Services("Mercedes AMG-GT", R.drawable.ic_services),
            new Services("Mazda MX-5", R.drawable.ic_building),
            new Services("Porsche 911 GTS", R.drawable.ic_electrical),
            new Services("BMW Serie 6", R.drawable.ic_carpenter),
            new Services("Ford Mondeo", R.drawable.ic_healt),
    };

    /**
     * Obtiene item basado en su identificador
     *
     * @param id identificador
     * @return Coche
     */
    public static Services getItem(int id) {
        for (Services item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
