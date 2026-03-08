package praktikum;

import lombok.ToString;

/**
 * Модель булочки для бургера.
 * Булочке можно дать название и назначить цену.
 */
@ToString(includeFieldNames = false)
public class Bun {

    public String name;
    public float price;

    public Bun(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

}