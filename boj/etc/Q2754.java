package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2754 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String grade = br.readLine();
        double gpa = 0;
        switch (grade) {
            case "A+":
                gpa = 4.3;
                break;
            case "A0":
                gpa = 4.0;
                break;
            case "A-":
                gpa = 3.7;
                break;
            case "B+":
                gpa = 3.3;
                break;
            case "B0":
                gpa = 3.0;
                break;
            case "B-":
                gpa = 2.7;
                break;
            case "C+":
                gpa = 2.3;
                break;
            case "C0":
                gpa = 2.0;
                break;
            case "C-":
                gpa = 1.7;
                break;
            case "D+":
                gpa = 1.3;
                break;
            case "D0":
                gpa = 1.0;
                break;
            case "D-":
                gpa = 0.7;
                break;
            case "F":
                gpa = 0.0;
                break;
            default:
                break;
        }
        System.out.println(gpa);
    }
}
