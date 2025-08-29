package test.task;

import org.testng.annotations.Test;

public class TaskManagement {

    @Test(groups = {"smoke"})
    void createTask () {
        System.out.println("SSOLogin: create task");
    }

    @Test(groups = {"regression"})
    void deleteTask () {
        System.out.println("TaskManagement: delete task");
    }
}
