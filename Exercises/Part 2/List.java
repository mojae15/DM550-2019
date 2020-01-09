public class List{

    private String[] list;

    public List(String[] v){
        this.list = v;
    }

    public boolean isEmpty(){
        return (this.list.length == 0);
    }

    public String head(){
        return this.list[0];
    }

    public void tail(){
        String[] newList = new String[this.list.length-1];
        int i = 0;

        while (i < this.list.length-1){
            newList[i] = this.list[i+1];
            i++;
        }
        this.list = newList;
    }
    
    public String toString(){
        String res = "";
        int i = 0;
        while (i < this.list.length-1){
            res = res + this.list[i] + ", ";
            i++;
        } 
        res = res + this.list[i];
        return res;
    }
}