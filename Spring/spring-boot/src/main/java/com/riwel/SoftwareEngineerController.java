package com.riwel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineer")
public class SoftwareEngineerController {

    @GetMapping
    public List<SoftwareEngineer> getEngineers(){
        return List.of(
                new SoftwareEngineer(
                        1,
                        "Pepe",
                        "js,node,python"
                ),
                new SoftwareEngineer(
                        2,
                        "Joel",
                        "js,html,css"
                ),
                new SoftwareEngineer(
                        3,
                        "Jessica",
                        "java, spring"
                )
        );
    }
}
