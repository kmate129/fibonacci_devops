package hu.obuda.devops.fibonacci;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class MyController {

    @Autowired
    MyService service;
    
    @GetMapping("/fibonacci/{n}")
    public String Fibonacci(@PathVariable("n") int n )
    {
        if(n>46){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        ArrayList<Integer> values = this.service.GetFibonaccis(n);

        String html ="";
        for(int i=0; i<n; i++){
            html+="f("+((int)i+(int)1)+") = "+values.get(i)+"<br>";
        }

        return html;
    }
}
