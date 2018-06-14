package ru.job4j.tracker;

public class Item {

    private String id;
    private String name;
    private String desc;
    private Long create;
    private String comments;

    public Item(String name, String desc, Long create, String comments){
        this.name = name;
        this.desc = desc;
        this.create = create;
        this.comments = comments;
    }

    public Item(String name, String desc){
        this.name = name;
        this.desc = desc;
    }
    public Item() {
    }
    public Item(String id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }
    public String getDesc(){
        return this.desc;
    }
    public Long getCreate(){
        return this.create;
    }
    public String getComments(){
        return this.comments;
    }
    public String getId(){
        return this.id = id;
    }

  public void setId(String id) {
      this.id = id;
  }
}
