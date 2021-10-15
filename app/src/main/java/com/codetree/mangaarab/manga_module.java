package com.codetree.mangaarab;

public class manga_module {
    String namear,nameeng,story,statue,imgsrc,slash;
    int idanime;
    public manga_module(int idanime,String namear,String nameng,String story,String statue,String imgsrc,String slash){
        this.idanime=idanime;
        this.imgsrc=imgsrc;
        this.namear=namear;
        this.statue=statue;
        this.story=story;
        this.slash=slash;
        this.nameeng=nameng;
    }

    public String getNamear() {
        return namear;
    }

    public String getSlash() {
        return slash;
    }

    public String getNameeng() {
        return nameeng;
    }

    public String getStatue() {
        return statue;
    }

    public String getStory() {
        return story;
    }

    public int getIdanime() {
        return idanime;
    }

    public String getImgsrc() {
        return imgsrc;
    }
}
