package com.recommender.create;

import java.util.Arrays;
import java.util.List;

/**
 * Created by swara on 12/01/2017.
 */
public class Skills {
    //Top 70 skills in tech from LinkedIn
    private static final String SKILLS_CSV = "Java, C,C++,C#,Python,VB,PHP,Pearl,JS,Ruby, .NET, Swift, R, Matlab,SQL, Groovy,Scala,Bash,VBscript,4th Dimension/4D, ABC," +
            " ActionScript, APL, Avenue, Awk, BBC BASIC, bc, Bourne shell, C shell, CFML, cg, CL (OS/400), Clojure, Common Lisp, cT, Forth, Hack, Icon, IDL, Inform, Io, Ioke, J, Julia," +
            " Korn shell, Mathematica, Mercury, MQL4, MS-DOS batch, NATURAL, NXT-G, OCaml, OpenCL, Oz, PL/I, PowerShell, Programming Without Coding Technology, Pure Data, Q, S, S-PLUS," +
            " Smalltalk, Standard ML, Stata, Tcl, thinBasic, Verilog, VHDL, Z shell";

    public static void main(String[] args) {
        List<String> skills = Arrays.asList(SKILLS_CSV.split("\\s*,\\s*"));
        System.out.println(skills.get(68));
    }
}
