public class Safe{


    //Class Attributes
    private String secret;
    private int[] lock;
    private boolean locked;
    private int progress;

    //Contructors
    public Safe(int[] lock){
        this.lock = new int[lock.length];

        for (int i = 0; i < lock.length; i++){
            this.lock[i] = lock[i];
        }


        this.locked = false;
        this.progress = 0;
        this.secret = "";
    }
    
    /**
     * Checks whether or not the safe is locked
     */
    public boolean locked(){
        return this.locked;
    }

    /**
     * Stores a secret in the safe
     */
    public void store(String secret){
        if (!this.locked){
            this.secret = secret;
        }

    }

    /**
     * Returns the contents of the safe if it's unlocked
     */
    public String contents(){

        if (!this.locked){
            return this.secret;
        } else {
            return "";
        }

    }

    /**
     * Inserts n into the lock
     */
    public void insert(int n){

        if (this.locked){
            if (n == this.lock[this.progress]){
                this.progress++;
            } else {
                this.progress = 0;
            }
        }

        if (this.progress == this.lock.length){
            this.locked = false;
        }

    }

    /**
     * Resets lock progress
     */
    public void reset(){
        this.progress = 0;

    }

    /**
     * Lock the safe
     */
    public void lock(){
        
        if (!this.locked){
            this.locked = true;
        }

    }




}