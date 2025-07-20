package org.example.todoapispringboot;

import org.springframework.stereotype.Service;

@Service("anotherFakeTodoService")
public class AnotherFakeTodoService implements TodoService {


    @Override
    public String doSomething() {
        return "something from another fake todo service";
    }
}
