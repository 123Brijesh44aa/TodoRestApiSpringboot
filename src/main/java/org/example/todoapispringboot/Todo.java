package org.example.todoapispringboot;

public class Todo {
    private int id;
    private boolean completed;
    private String title;
    private int userId;

    public Todo(int id, Boolean completed, String title, int userId) {
        this.id = id;
        this.completed = completed;
        this.title = title;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Boolean isCompleted() {
        return completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return
                "Todo{" +
                        "id = '" + id + '\'' +
                        ",completed = '" + completed + '\'' +
                        ",title = '" + title + '\'' +
                        ",userId = '" + userId + '\'' +
                        "}";
    }
}
