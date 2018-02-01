package app.main.wangliwei.enablehands.bean;


public class Picture {
    private int type;
    private String picture;
    private String title;
    private String content;

    public Picture(int type,String picture,String title,String content) {
        this.type = type;
        this.picture = picture;
        this.title = title;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
