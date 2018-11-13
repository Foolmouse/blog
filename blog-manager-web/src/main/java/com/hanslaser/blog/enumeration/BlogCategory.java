package com.hanslaser.blog.enumeration;

/**
 * Description : Eum class is a powerful util , we can use this to put data by the value that like Map;
 *
 * @author LuoJu
 * @since 2018.10.31
 */
public enum BlogCategory {
    LIVE(1, "生活类"), PROGRAMME(2, "技术类") , CHAT(3,"闲谈");

    private String name;
    private int index;

    private BlogCategory(int index, String name) {
        this.name = name;
        this.index = index;
    }

    public static String getValueByKey(int index) {
        BlogCategory[] categories = BlogCategory.values();
        for (BlogCategory category : categories) {
            if (category.getIndex() == index) {
                return category.getName();
            }
        }
        return "";
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }
}