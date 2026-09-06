class Solution {
    public int countGroups(int[] position, int[] speed, int distance) {
        int n=position.length;
        int curr_vel=speed[n-1];
        int group=1;

        for(int i=n-2; i>=0; i--){
            // if they are too far and leftone vel is less than right group, they can not be merged
            if(position[i+1]-position[i]>distance && speed[i] <= curr_vel){
                group++;
                curr_vel=speed[i];
            }
            // and if distance are less, they will be merged
            // velocity is already rightmost's one so no need too update
            //AND left one vel is more than right group, then it will catch, no need to update velocity again, they will be in same group eventually after few sec
        }
        return group;
    }
}