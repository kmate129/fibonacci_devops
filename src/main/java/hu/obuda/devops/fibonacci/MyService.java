package hu.obuda.devops.fibonacci;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class MyService {
    
    public ArrayList<Integer> GetFibonaccis(int n)
    {
        ArrayList<Integer> returnValue = new ArrayList<>();

        for(int i=0; i<n; i++){
            returnValue.add(fib(i+1));
        }

        return returnValue;
    }

    private int fib(int n)
    {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }
}
