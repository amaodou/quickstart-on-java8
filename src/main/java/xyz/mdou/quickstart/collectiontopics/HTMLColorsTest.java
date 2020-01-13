package xyz.mdou.quickstart.collectiontopics;

public class HTMLColorsTest {

    static final Integer DISPLAY_SIZE = 20;

    public static void main(String[] args) {
        HTMLColors.show(HTMLColors.MAP, DISPLAY_SIZE);
        HTMLColors.border();
        HTMLColors.showInv(HTMLColors.INVERT_MAP, DISPLAY_SIZE);
        HTMLColors.border();
        HTMLColors.show(HTMLColors.LIST, DISPLAY_SIZE);
        HTMLColors.border();
        HTMLColors.showrgb(HTMLColors.RGBLIST, DISPLAY_SIZE);
        HTMLColors.border();
    }
}
