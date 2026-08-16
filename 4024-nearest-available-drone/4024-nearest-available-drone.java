class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int min = Integer.MAX_VALUE;
        int index  =  -1;

        for  (int i = drones.length - 1; i >=  0; i--) {
            int x1 = drones[i][0];
            int y1 = drones[i][1];
            int range  = drones[i][2];
            int x2 = target[0];
            int y2 = target[1];

            int dist = Math.abs(x1 -  x2) + Math.abs(y1 - y2);

            if (dist <= range) {
                if (dist <=  min) {
                    min = dist;
                    index = i;
                }
            }
        }

        return  index;
    }
}