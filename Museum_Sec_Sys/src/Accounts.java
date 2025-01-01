public class Accounts {
    String username ;
    String password ;
    int password2 ;

    int[] denominations = new int[50] ;

    Accounts(){

    }
    Accounts(String usernames ,String passwords1 ,int passwords2 ,int[] denominations ){
        this.username = usernames;
        this.password = passwords1 ;
        this.password2 = password2;
        this.denominations = denominations;
    }
    void setUsername(String usernames){
        this.username = usernames;
    }
    void setPassword(String passwords){
        this.password = passwords;
    }
    void setPassword2(int passwords2){
        this.password2 = passwords2 ;
    }
    String getUsername(){
        return this.username;
    }
    String getPassword(){
        return this.password;
    }
    int getPassword2(){
        return this.password2;
    }
}
