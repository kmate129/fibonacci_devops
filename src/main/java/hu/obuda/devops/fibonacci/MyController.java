package hu.obuda.devops.fibonacci;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    MyService service;
    
    @GetMapping("/fibonacci/{n}")
    public String Fibonacci(@PathVariable("n") int n )
    {
        ArrayList<Integer> values = this.service.GetFibonaccis(n);

        String html ="";
        for(int i=1; i<n; i++){
            html+="f("+i+") = "+values.get(i-1)+"\n";
        }

        return html;
    }
}
