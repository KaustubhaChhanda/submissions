class Solution {
    public int maximumPopulation(int[][] logs) {
        int baseYear = 1950;
        int[] population = new int[100];

        for (int[] log : logs) {
            for (int i = log[0]; i < log[1]; i++) {
                population[i - baseYear]++;
            }
        }

        int max = 0;
        int year = baseYear;

        for (int i = 0; i < 100; i++) {
            if (population[i] > max) {
                max = population[i];
                year = baseYear + i;
            }
        }

        return year;
    }
}