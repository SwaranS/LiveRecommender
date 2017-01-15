package com.recommender.web.controller;

import com.recommender.persistance.SkillDAO;
import com.recommender.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;

/**
 * Created by Home on 15/01/2017.
 */
@Controller
@RequestMapping("/insert-data")
public class InsertDataController {

    @Autowired
    @Qualifier("skillServiceImpl")
    private SkillService skillService;

    @RequestMapping(value = "/create-skills", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> createSkills() {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        //Commented out as was intended to used once only
        /*final String SKILLS_CSV = "Java, C,C++,C#,Python,VB,PHP,Pearl,JS,Ruby, .NET, Swift, R, Matlab,SQL, Groovy,Scala,Bash,VBscript,4th Dimension/4D, ABC," +
                " ActionScript, APL, Avenue, Awk, BBC BASIC, bc, Bourne shell, C shell, CFML, cg, CL (OS/400), Clojure, Common Lisp, cT, Forth, Hack, Icon, IDL, Inform, Io, Ioke, J, Julia," +
                " Korn shell, Mathematica, Mercury, MQL4, MS-DOS batch, NATURAL, NXT-G, OCaml, OpenCL, Oz, PL/I, PowerShell, Programming Without Coding Technology, Pure Data, Q, S, S-PLUS," +
                " Smalltalk, Standard ML, Stata, Tcl, thinBasic, Verilog, VHDL, Z shell";
        skillService.createMultipleSkills(Arrays.asList(SKILLS_CSV.split("\\s*,\\s*")));
        */
        return new ResponseEntity<>("{\"successMessage\": \"Skills Created\"}", httpHeaders, HttpStatus.OK);
    }
}
