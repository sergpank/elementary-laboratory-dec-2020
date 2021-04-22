package com.hillel;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpectreGeneratorTest
{
    @Test
    public void testCellCreation()
    {
        final SpectreGenerator sg = new SpectreGenerator();
        final String actual = sg.generateCell(1, 2, 3);

        final String expected = "<td style='background-color: rgb(1, 2, 3)'></td>";
        assertEquals(expected, actual);
    }

    @Test
    public void testRowCreation()
    {
        final SpectreGenerator sg = new SpectreGenerator();
        final String row = sg.generateRow(1);

        String expected = """
                          	<tr>
                          		<td style='background-color: rgb(1, 0, 0)'></td>
                          		<td style='background-color: rgb(0, 1, 0)'></td>
                          		<td style='background-color: rgb(0, 0, 1)'></td>
                          	</tr>
                          """;

        assertEquals(expected, row);
    }
}