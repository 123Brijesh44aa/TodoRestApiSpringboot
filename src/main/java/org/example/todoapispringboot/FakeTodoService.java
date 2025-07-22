package org.example.todoapispringboot;


import org.springframework.stereotype.Service;

@Service("fakeTodoService")
public class FakeTodoService implements TodoService {

    @TimeMonitor
    public String doSomething() {
        for (long i = 0; i < 1000000000L; i++) {
        }
        return "something";
    }
}
