package com.company;

public class Worker {

    private OnTaskDoneListener callback; // выполненная задача
    private OnTaskErrorListener errorCallback; // не выполненная задача

    @FunctionalInterface
    public interface OnTaskDoneListener { //Интервейс выполненной задачи
        void onDone(String result);
    }


    public Worker(OnTaskDoneListener callback , OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    @FunctionalInterface
    public interface OnTaskErrorListener{ // Инттерфейс не выполненная задачи
        void onError(String result);
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if ( i == 33){
                errorCallback.onError("Task " + i + " is not done ‼️ ❌ ‼️");
            } else {
                callback.onDone("Task " + i + " is done ✅");
            }
        }
    }
}
