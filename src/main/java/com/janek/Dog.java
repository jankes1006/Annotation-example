package com.janek;

@FavoriteAnimal
public class Dog {
    @DefaultName
    private String name;
    private String favoriteToy;

    public Dog(String name, String favoriteToy) {
        this.name = name;
        this.favoriteToy = favoriteToy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteToy() {
        return favoriteToy;
    }

    public void setFavoriteToy(String favoriteToy) {
        this.favoriteToy = favoriteToy;
    }

    @ImportantFunction
    public void getVoice() {
        System.out.println("hau hau hau!");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", favoriteToy='" + favoriteToy + '\'' +
                '}';
    }
}
