package pl.kamol84.giveawaystuff.enums;

public enum GiftCategory {

    CLOTHES_IN_GOOD_CONDITION("good"),
    CLOTHES_IN_BAD_CONDITION("bad"),
    TOYS("toys"),
    BOOKS("books"),
    OTHER("other");

    private String shortcut;

    GiftCategory(String shortcut) {

        this.shortcut = shortcut;

    }
}
