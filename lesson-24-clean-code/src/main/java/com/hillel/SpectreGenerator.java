package com.hillel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SpectreGenerator {
    public static void main(String[] args) {
        new SpectreGenerator().generate();
    }

    private void generate() {
        createTable();
    }

    private void createTable() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("demo.html"))) {
            writeln(bw, "<table style=\"width: 400px; height: 200px;\">");
            generateRows(bw);
            writeln(bw, "</table>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generateRows(BufferedWriter bw) throws IOException {
        for (int i = 255; i >= 0; i -= 5) {
            writeln(bw, generateRow(i));
        }
    }

    String generateRow(int i)
    {
        StringBuilder sb = new StringBuilder();

        sb.append('\t').append("<tr>").append('\n');
        sb.append("\t\t").append(generateCell(i, 0, 0)).append('\n');
        sb.append("\t\t").append(generateCell(0, i, 0)).append('\n');
        sb.append("\t\t").append(generateCell(0, 0, i)).append('\n');
        sb.append('\t').append("</tr>").append('\n');

        return sb.toString();
    }

    String generateCell(int red, int green, int blue)
    {
        String data = String.format("<td style='background-color: rgb(%d, %d, %d)'></td>", red, green, blue);
        return data;
    }

    private void writeln(BufferedWriter bw, String s) throws IOException {
        bw.write(s);
        bw.write("\n");
    }
}
