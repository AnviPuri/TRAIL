package com.anvipuri.trail;


import android.widget.EditText;

public class Task {
    private int id;
    private String todo;


    public Task() {
    }

    public Task(int id, String todo) {
        this.id = id;
        this.todo = todo;
    }


    public Task(String todo) {

        this.todo = todo;
    }

    public int getId() {
        return id;
    }

    public String getTodo() {
        return todo;
    }

    public void setId(int id) {this.id = id;}

    public void setTodo(String todo) {
        this.todo = todo;
    }
}
