package content;

public class GridGenerator {
    private String difficulty;

    public GridGenerator(String difficulty) {
        this.difficulty = difficulty;
    }

    public int[][] generate() {
        int[][] gridExample = new int[9][9];

        switch(difficulty) {
            case "easy":
                gridExample[0] = new int[]{4, 1, 0, 2, 7, 0, 8, 0, 5};
                gridExample[1] = new int[]{0, 8, 5, 1, 4, 6, 0, 9, 7};
                gridExample[2] = new int[]{0, 7, 0, 5, 8, 0, 0, 4, 0};
                gridExample[3] = new int[]{9, 2, 7, 4, 5, 1, 3, 8, 6};
                gridExample[4] = new int[]{5, 3, 8, 6, 9, 7, 4, 1, 2};
                gridExample[5] = new int[]{1, 6, 4, 3, 2, 8, 7, 5, 9};
                gridExample[6] = new int[]{8, 5, 2, 7, 0, 4, 9, 0, 0};
                gridExample[7] = new int[]{0, 9, 0, 8, 0, 2, 5, 7, 4};
                gridExample[8] = new int[]{7, 4, 0, 9, 6, 5, 0, 2, 8};
                break;

            case "medium":
                gridExample[0] = new int[]{5, 0, 0, 0, 1, 0, 0, 0, 4};
                gridExample[1] = new int[]{2, 7, 4, 0, 0, 0, 6, 0, 0};
                gridExample[2] = new int[]{0, 8, 0, 9, 0, 4, 0, 0, 0};
                gridExample[3] = new int[]{8, 1, 0, 4, 6, 0, 3, 0, 2};
                gridExample[4] = new int[]{0, 0, 2, 0, 3, 0, 1, 0, 0};
                gridExample[5] = new int[]{7, 0, 6, 0, 9, 1, 0, 5, 8};
                gridExample[6] = new int[]{0, 0, 0, 5, 0, 3, 0, 1, 0};
                gridExample[7] = new int[]{0, 0, 5, 0, 0, 0, 9, 2, 7};
                gridExample[8] = new int[]{1, 0, 0, 0, 2, 0, 0, 0, 3};
                break;

            case "difficult":
                gridExample[1] = new int[]{0, 0, 0, 0, 0, 3, 0, 8, 5};
                gridExample[2] = new int[]{0, 0, 1, 0, 2, 0, 0, 0, 0};
                gridExample[3] = new int[]{0, 0, 0, 5, 0, 7, 0, 0, 0};
                gridExample[4] = new int[]{0, 0, 4, 0, 0, 0, 1, 0, 0};
                gridExample[5] = new int[]{0, 9, 0, 0, 0, 0, 0, 0, 0};
                gridExample[6] = new int[]{0, 0, 5, 0, 0, 0, 0, 7, 3};
                gridExample[7] = new int[]{0, 0, 2, 0, 1, 0, 0, 0, 0};
                gridExample[8] = new int[]{0, 0, 0, 0, 4, 0, 0, 0, 9};
                break;

        }

        return gridExample;
    }
}
