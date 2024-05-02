class JaggedArray{
    public static void main(String[] args) {
        
        int jaggedArray[][] = new int[3][];
        jaggedArray[0] = new int[4];
        jaggedArray[1] = new int[2];
        jaggedArray[2] = new int[3];

        for(int i=0; i<jaggedArray.length; i++){
            for(int j=0; j<jaggedArray[i].length; j++){
                jaggedArray[i][j] = (int)(Math.random()*10);
            }
        }
        
        for(int array[] : jaggedArray){
            for(int value: array){
                System.out.print(value+" ");
            }
            System.out.println();
        }
    }
}