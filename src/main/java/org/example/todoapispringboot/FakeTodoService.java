package org.example.todoapispringboot;


import org.springframework.stereotype.Service;

@Service("fakeTodoService")
public class FakeTodoService implements TodoService {

    @Override
    public String doSomething() {
        return "something";
    }
}
