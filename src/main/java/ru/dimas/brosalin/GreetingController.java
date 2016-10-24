/**
 * Created by DmitriyBrosalin on 11/09/16.
 */

package ru.dimas.brosalin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s !";
    private final AtomicLong id = new AtomicLong();

    @RequestMapping("/greet")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World !") String name){

        return new Greeting(id.incrementAndGet(), String.format(template, name));

    }

}
